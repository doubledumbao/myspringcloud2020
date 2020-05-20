package com.dumbao.singleton;

import java.lang.reflect.Constructor;

//枚举实现单例模式
public enum EnumSingleton {

    SINGLETON;

    public static EnumSingleton getInstance(){
        return SINGLETON;
    }

    public static void main(String[] args) throws Exception {
        EnumSingleton enumSingleton1 = EnumSingleton.getInstance();
        EnumSingleton enumSingleton2 = EnumSingleton.getInstance();
        System.out.println(enumSingleton1);
        System.out.println(enumSingleton2);

        //试图通过反射破坏单例模式
        //Constructor<EnumSingleton> declaredConstructor = EnumSingleton.class.getDeclaredConstructor(null);
        //declaredConstructor.setAccessible(true);
        //EnumSingleton enumSingleton = declaredConstructor.newInstance(null);//NoSuchMethodException
        //System.out.println(enumSingleton);


        //jad -sjava EnumSingleton.class
        //Exception in thread "main" java.lang.IllegalArgumentException: Cannot reflectively create enum objects
        Constructor<EnumSingleton> declaredConstructor = EnumSingleton.class.getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true);
        EnumSingleton enumSingleton = declaredConstructor.newInstance(String.class, int.class);
        System.out.println(enumSingleton);
    }
}
