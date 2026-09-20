package org.zdanek.javabasic.generics.wildcards;

public class Partner extends Person
{
    public Partner(final String name, final int age)
    {
        super(name, age);
    }

    @Override
    public String toString()
    {
        return "Partner{" +
            "name='" + getName() + '\'' +
            ", age=" + getAge() +
            '}';
    }
}
