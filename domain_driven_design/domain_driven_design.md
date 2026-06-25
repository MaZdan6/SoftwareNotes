## Domain driven design
- Paczki porządkuj według funkcjonalności (package by feature), a nie warstw (package by layer).

### Przykładowa struktura projektu package by feature

```
src/main/java/com/example/app/
│
├── order/                          # Feature: zamówienia
│   ├── Order.java                  # Entity / Domain object
│   ├── OrderStatus.java            # Enum
│   ├── OrderRepository.java        # Spring Data JPA interface
│   ├── OrderService.java           # Business logic
│   ├── OrderController.java        # REST endpoint
│   ├── OrderRequestDto.java           # DTO (incoming)
│   └── OrderResponseDto.java          # DTO (outgoing)
│
├── product/                        # Feature: produkty
│   ├── Product.java
│   ├── ProductCategory.java
│   ├── ProductRepository.java
│   ├── ProductService.java
│   ├── ProductController.java
│   ├── ProductRequestDto.java
│   └── ProductResponseDto.java
│
├── customer/                       # Feature: klienci
│   ├── Customer.java
│   ├── CustomerRepository.java
│   ├── CustomerService.java
│   ├── CustomerController.java
│   └── CustomerResponseDto.java
│
└── shared/                         # Wspólne, przekrojowe elementy
    ├── exception/
    │   ├── NotFoundException.java
    │   └── GlobalExceptionHandler.java
    ├── audit/
    │   └── AuditableEntity.java    # @MappedSuperclass z createdAt/updatedAt
    └── config/
        └── JpaConfig.java
```

- Jedna paczka = jeden kontekst domenowy np.order/, product/, customer/
- Wszystko co dotyczy danej funkcjonalności – znajduje się wewnątrz np. Entity, repo, serwis, kontroler, DTO
- Paczka shared/ jest wykorzystywana tylko dla kodu naprawdę przekrojowego (wyjątki, audyt, konfiguracja)

### Bounded Context

Dziel domenę na mniejsze konteksty, które mają własne modele i logikę biznesową. Każdy kontekst jest niezależny i może
ewoluować w swoim tempie.

## Komunikacja między kontekstami

### Kiedy używać którego podejścia?

| Scenariusz | Podejście |
|---|---|
| Potrzebujesz danych z innego kontekstu synchronicznie | Anti-Corruption Layer lub Facade (API Contract) |
| Reagujesz na fakt, że coś się wydarzyło | Event-driven |
| Chcesz izolować się od zmian w cudzym modelu | Anti-Corruption Layer |
| Chcesz zdefiniować stabilny kontrakt dla konsumentów | Facade (API Contract) |

- Najczęściej te trzy podejścia uzupełniają się – Facade definiuje kontrakt, ACL tłumaczy model, zdarzenia obsługują reakcje asynchroniczne.

Kiedy konteksty muszą się komunikować, używaj:

### Anti-Corruption Layer  (ACL)
* Warstwa ochronna między kontekstami
* Chroni kontekst przed "przeciekiem" modelu sąsiedniego kontekstu.
```java
// Zamiast bezpośrednio używać Product z kontekstu product/,
// kontekst order/ definiuje własny widok (adapter) potrzebnych danych

@Component
public class ProductAdapter {

    private final ProductService productService;

    public ProductAdapter(ProductService productService) {
        this.productService = productService;
    }

    public OrderableProduct findOrderableProduct(Long productId) {
        Product product = productService.findById(productId);
        return new OrderableProduct(product.getId(), product.getName(), product.getPrice());
    }
}

// kontekst order/
// Model produktu z perspektywy kontekstu order/ – nie Product.java
public record OrderableProduct(Long id, String name, BigDecimal price) {}

```


### Event-driven communication
- zdarzenia jako kanał komunikacji
- Konteksty nie wywołują się bezpośrednio – publikują zdarzenia

```java
public record OrderPlacedEvent(Long orderId, Long customerId, List<Long> productIds) {}

@Service
public class OrderService {

    private final ApplicationEventPublisher eventPublisher;

    public Order placeOrder(OrderRequestDto request) {
        Order order = // ... logika tworzenia zamówienia
        eventPublisher.publishEvent(new OrderPlacedEvent(order.getId(), ...));
        return order;
    }
}


// Kontekst notification/ reaguje na zdarzenie – nie zna OrderService
@Component
public class OrderPlacedEventListener {

    @EventListener
    public void onOrderPlaced(OrderPlacedEvent event) {
        // wyślij email, powiadomienie itp.
    }
}


// Kontekst notification/ reaguje na zdarzenie – nie zna OrderService
@Component
public class OrderPlacedEventListener {

    @EventListener
    public void onOrderPlaced(OrderPlacedEvent event) {
        // wyślij email, powiadomienie itp.
    }
}

```


Uwaga: @EventListener to synchroniczne zdarzenia Spring. Dla asynchronicznych użyj @Async + @EventListener lub zewnętrznego brokera (Kafka, RabbitMQ).

### API contracts
- jasnie zdefiniowane interfejsy
```java

// Publiczne API kontekstu product/ – jedyny punkt wejścia dla innych kontekstów
public interface ProductFacade {
    ProductSummary findById(Long id);
    boolean isAvailable(Long id, int quantity);
}


// kontekst product/
@Service
class ProductFacadeImpl implements ProductFacade {

    private final ProductRepository productRepository;

    @Override
    public ProductSummary findById(Long id) {
        return productRepository.findById(id)
                .map(p -> new ProductSummary(p.getId(), p.getName(), p.getPrice()))
                .orElseThrow(() -> new NotFoundException("Product not found: " + id));
    }

    @Override
    public boolean isAvailable(Long id, int quantity) {
        return productRepository.findById(id)
                .map(p -> p.getStock() >= quantity)
                .orElse(false);
    }
}

// kontekst product/
@Service
class ProductFacadeImpl implements ProductFacade {

    private final ProductRepository productRepository;

    @Override
    public ProductSummary findById(Long id) {
        return productRepository.findById(id)
                .map(p -> new ProductSummary(p.getId(), p.getName(), p.getPrice()))
                .orElseThrow(() -> new NotFoundException("Product not found: " + id));
    }

    @Override
    public boolean isAvailable(Long id, int quantity) {
        return productRepository.findById(id)
                .map(p -> p.getStock() >= quantity)
                .orElse(false);
    }
}

// kontekst order/ importuje tylko ProductFacade i ProductSummary – nigdy Product, ProductRepository ani ProductService.
```



# Notacja
- Dla nazw klas,zmiennych, metod i pól używaj:
    - notacji camelCase
    - nazw angielskich
- Unikaj nazw klas Helper, Utils o niejasnej odpowiedzialności.
