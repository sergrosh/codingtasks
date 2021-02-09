package com.coding.patterns;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

public class Singleton {

    private Singleton() {
    }

    public static Singleton getInstance() {
        return Holder.singleton;
    }

    private static class Holder {
        static Singleton singleton = new Singleton();
    }


    private UUID uuid = UUID.randomUUID();

    public void printUUID() {
        System.out.println("Your uuid is: " + uuid.toString());
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        singleton.printUUID();
        singleton1.printUUID();

        Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        constructor.newInstance().printUUID();
    }
}
