package com.globant.google.nest;

@FunctionalInterface
public interface MyFuntional<E, D> {

    D myMapping(E e);

    default String toMyString(E e) {
        return String.valueOf(e);
    }

    default String toMyString(E e, String concat) {
        return String.valueOf(e + concat);
    }

}
