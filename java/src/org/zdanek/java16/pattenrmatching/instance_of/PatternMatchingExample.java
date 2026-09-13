package org.zdanek.java16.pattenrmatching.instance_of;

public class PatternMatchingExample {

    void main() {
        var rectangle = new Rectangle(2, 3);
        var circle = new Circle(3);

        IO.println(Shape.getPerimeter(rectangle));
        IO.println(Shape.getPerimeter(circle));

        IO.println(Shape.getPerimeterSwitch(rectangle));
        IO.println(Shape.getPerimeterSwitch(circle));
    }
}
