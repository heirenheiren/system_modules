package com.reflection;
/**
 *2011-6-1 ����08:32:01
 *perlin
 */

import java.lang.reflect.Method;

public class DumpMethods
{
    public static void main(String args[]) throws Exception
    {
        Class<?> classType = Class.forName(args[0]);
        Method methods[] = classType.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++)
        {
            System.out.println(methods[i].toString());
        }
    }
}
