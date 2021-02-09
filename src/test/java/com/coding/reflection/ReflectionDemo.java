package com.coding.reflection;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

public class ReflectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        ReflectionDemo reflectionDemo = new ReflectionDemo();
        ClassLoader classLoader = ReflectionDemo.class.getClassLoader();
        Package pack = reflectionDemo.getClass().getPackage();
        String packageName = pack.getName();
        String packagePath = packageName.replace('.', '/');
        URL urls = classLoader.getResource(packagePath);
        File folder = new File(urls.getPath());
        File[] classes = folder.listFiles();

        for (File aClass : classes) {
            int index = aClass.getName().indexOf(".");
            String className = aClass.getName().substring(0, index);
            String classNamePath = packageName + "." + className;
            Class<?> repoClass = Class.forName(classNamePath);

            Annotation[] annotations = repoClass.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType() == CustomAnnotation.class) {
                    System.out.println(
                            "Detected CustomAnnotation!!! It is " + repoClass.getName()
                    );
                    Class[] params = new Class[]{String.class, String.class, String.class};
                    Constructor constructor = repoClass.getDeclaredConstructor(params);
                    constructor.setAccessible(true);
                    User user = (User) constructor.newInstance("user", "user@user.com", "123");
                    Field field = user.getClass().getDeclaredField("userName");
                    field.setAccessible(true);
                    field.set(user, "userChanged");
                    Method method = user.getClass().getDeclaredMethod("printUserData", String.class);
                    method.setAccessible(true);
                    method.invoke(user, "prefix");
                }
            }

        }


    }
}
