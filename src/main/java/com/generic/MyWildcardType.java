package com.generic;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.WildcardType;

public class MyWildcardType {
    public Print<? extends Number> print;

    public static void main(String[] args) throws NoSuchFieldException {
        Class<MyWildcardType> clazz = MyWildcardType.class;
        Field field = clazz.getField("print");
        ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
        System.out.println(parameterizedType.getActualTypeArguments()[0] instanceof WildcardType);
    }
}


