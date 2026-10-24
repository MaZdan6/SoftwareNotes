package org.zdanek.java.function.predicate.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class A03LambdaAsMethodReference {

    static void main() {

        /*Here are the four types of method references
        Static 	RefType::staticMethod 	(args) -> RefType.staticMethod(args)
        Bound 	expr::instanceMethod 	(args) -> expr.instanceMethod(args)
        Unbound 	RefType::instanceMethod 	(arg0, rest) -> arg0.instanceMethod(rest)
        Constructor 	ClassName::new 	(args) -> new ClassName(args)*/

        IO.println("------");
        IO.println("Static RefType::staticMethod (args) -> RefType.staticMethod(args)");

        Function<Double, Double> sqrt = a -> Math.sqrt(a);
        IO.println(sqrt.apply(4.00));


        IO.println("------");
        IO.println("Bound expr::instanceMethod (args) -> expr.instanceMethod(args)");

        Function<Double, Double> sqrt2 = Math::sqrt;
        IO.println(sqrt.apply(9.00));

        BiFunction<Double,Double, Double> pow = Math::pow;
        IO.println(pow.apply(2.00,2.00));






    }
}
