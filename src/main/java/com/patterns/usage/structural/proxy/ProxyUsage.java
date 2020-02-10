package com.patterns.usage.structural.proxy;

import com.patterns.usage.AbstractPatternUsage;

import java.lang.reflect.Proxy;

public class ProxyUsage extends AbstractPatternUsage {

    public ProxyUsage() {
        this.description = "С помощью шаблона «Заместитель» класс представляет функциональность другого класса.\n";
        ;
    }

    @Override
    public void demonstrate() {

        //Создаем оригинальный объект
        Man vasia = new Man("Вася", 30, "Санкт-Петербург", "Россия");

        //Получаем загрузчик класса у оригинального объекта
        ClassLoader vasiaClassLoader = vasia.getClass().getClassLoader();

        //Получаем все интерфейсы, которые реализует оригинальный объект
        Class[] interfaces = vasia.getClass().getInterfaces();

        //Создаем прокси нашего объекта vasia
        Person proxyVasia = (Person) Proxy.newProxyInstance(vasiaClassLoader, interfaces, new PersonInvocationHandler(vasia));

        //Вызываем у прокси объекта один из методов нашего оригинального объекта
        proxyVasia.introduce(vasia.getName());

    }
}
