package org.zdanek.java16.record;

public class RecordExample {

    void main(){

        record Rectangle(double length, double width) { }
        Rectangle r = new Rectangle(4,5);
        IO.println("Length: " + r.length() + ", width: " + r.width());
        IO.println(r);
        IO.println(r.hashCode());

    }
}
