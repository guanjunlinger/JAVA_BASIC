package com.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;

public class MyParameterizedType implements Print<String> {

    @Override
    public void print(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        Class<MyParameterizedType> clazz = MyParameterizedType.class;
        TypeVariable[] typeVariables = clazz.getTypeParameters();
        System.out.println(typeVariables.length);
        ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericInterfaces()[0];
        System.out.println(parameterizedType.getActualTypeArguments()[0] instanceof Class);

    }

}
