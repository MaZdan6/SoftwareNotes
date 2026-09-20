### Generic Method

```java
public static <T> T min(List<T> values, Comparator<T> comparator)
    {
        if (values.isEmpty())
        {
            throw new IllegalArgumentException("Unable to find the minimum of an empty list");
        }

        T lowestFound = values.get(0);

        for (int i = 1; i < values.size(); i++)
        {
            final T element = values.get(i);
            if (comparator.compare(element, lowestFound) < 0)
            {
                lowestFound = element;
            }
        }

        return lowestFound;
    }
```

### Wildcard
https://www.geeksforgeeks.org/wildcards-in-java/

#### Upper Bounded 
	List<? extends Cls>
	Dopuszczone są wszystkie klasy dziedziczące po wymienionej klasie
	```java
		public void saveAll(final List<? extends Person> people) throws IOException
    {
        for (Person person : people)
        {
            save(person);
        }
    }
	 ```
	* Declare an upper bound for the type parameter	 
	* To get data out of the parameter
	* Covariance

	 
#### Lower Bounded 
	List<? super Cls>
	
	*  Declare a lower bound for the type parameter
	*  To put data into the parameter
	*  Contravariance
	
#### Unbounded
	List<?>
	
#### Guidelines for Usage
	* Get data with extends 
	* Put data with super
	* Use ? Instead of ?
	* extends Object Get and Put
without wildcards