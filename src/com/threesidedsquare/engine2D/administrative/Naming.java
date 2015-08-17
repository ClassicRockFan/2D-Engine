package com.threesidedsquare.engine2D.administrative;


public class Naming {

    public static String getReccomendedName(Class clazz) {
        String className = clazz.toString();
        String packageName = clazz.getPackage().toString();

        String reccomendedName = className.substring(packageName.length() - 1);
        return reccomendedName;
    }
}
