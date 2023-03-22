package com.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LionExceptionTest {
    Predator feline = new Feline();
    @Test
    public void ExceptionTest() {
        try {
            Lion lion = new Lion("Чудо", feline);
        } catch (Exception thrown) {
            assertEquals("Исключение сработало некорректно", "Используйте допустимые значения пола животного - самец или самка", thrown.getMessage());
        }
    }
}
