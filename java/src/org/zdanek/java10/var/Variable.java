package org.zdanek.java10.var;

import java.util.function.BiFunction;

//https://docs.oracle.com/en/java/javase/25/language/local-variable-type-inference.html#GUID-D2C58FE6-1065-4B50-9326-57DD8EC358AC
//https://openjdk.org/projects/amber/guides/lvti-style-guide
//https://openjdk.org/jeps/286
public class Variable {

    void main(){
        var a = 1;
        var b= 1;
        IO.println(String.format("a= %s, b= %s, a+b= %s",a,b,a+b));
    }
}
