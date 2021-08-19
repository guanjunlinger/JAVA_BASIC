package com.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;

public class MyTypeVariable<T extends Number> implements Print<T> {

    @Override
    public void print(T s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        Class<MyTypeVariable> clazz = MyTypeVariable.class;
        TypeVariable[] typeVariables = clazz.getTypeParameters();
        System.out.println(typeVariables.length);
        ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericInterfaces()[0];
        System.out.println(parameterizedType.getActualTypeArguments()[0] instanceof TypeVariable);

    }
}
