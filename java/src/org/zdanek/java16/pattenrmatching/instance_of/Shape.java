package org.zdanek.java16.pattenrmatching.instance_of;

public interface Shape {
    public static double getPerimeter(Shape s) throws IllegalArgumentException {
        if (s instanceof Rectangle r) {
            IO.println("instanceof Rectangle");
            return 2 * r.length() + 2 * r.width();
        } else if (s instanceof Circle c) {
            IO.println("instanceof Circle");
            return 2 * c.radius() * Math.PI;
        } else {
            throw new IllegalArgumentException("Unrecognized shape");
        }
    }

    public static double getPerimeterSwitch(Shape s) throws IllegalArgumentException {
        return switch (s) {
            case Rectangle r ->
                    2 * r.length() + 2 * r.width();
            case Circle c ->
                    2 * c.radius() * Math.PI;
            default ->
                    throw new IllegalArgumentException("Unrecognized shape");
        };
    }


    public static double getPerimeterSwitch2(Shape s) throws IllegalArgumentException {
        switch (s) {
            case Rectangle r:
                return 2 * r.length() + 2 * r.width();
            case Circle c:
                return 2 * c.radius() * Math.PI;
            default:
                throw new IllegalArgumentException("Unrecognized shape");
        }
    }
}
