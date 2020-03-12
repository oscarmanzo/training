package com.globant.google.nest;

import java.util.function.*;

public class LambdaType {

    public static void main(String[] args) {
        String name = "oscar";
        Predicate<String> predicate = (s) -> s.length() > 10;
        System.out.println("predicate for higher than 10: ["+ name +"] "+ predicate.test(name));

        Consumer<String> consumer = (s) -> System.out.println("consumer getting "+ s);
        consumer.accept(name);

        Function<String, Integer> function = (s)-> s.length() + 10;
        System.out.println("function length plus 10: "+ function.apply(name));

        Supplier<String> supplier = () -> name.toUpperCase();
        System.out.println("supplier for "+ supplier.get());

        BinaryOperator<String> binaryOperator = (a, b) -> a.toUpperCase() +" "+ b.toLowerCase();
        System.out.println("binaryOperator "+ binaryOperator.apply(name, supplier.get()));

        UnaryOperator<String> unaryOperator = (s) -> s.toLowerCase() + " updated for unary operator";
        System.out.println(unaryOperator.apply(name));
    }


}
