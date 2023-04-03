package com.example;

import java.util.List;

public class Lion {
    // добавлено поле типа интерфейса Predator для инъекции зависимости
    protected Predator predator;
    boolean hasMane;
    // добавлен параметр типа Predator в конструктор для инъекции зависимости
    public Lion(String sex , Predator predator) throws Exception {
        this.predator = predator;
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    Feline feline = new Feline();

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean isHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}
