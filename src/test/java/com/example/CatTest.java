package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    private final Feline feline = new Feline();
    @Spy
    Cat catSpy = new Cat(feline);

    @Test
    public void getSoundTest (){
        Cat cat = new Cat(feline);
        String actual = cat.getSound();
        assertEquals("Ошибка сравнения", "Мяу", actual);
    }
    @Test
    public void getFoodTest () throws Exception {
        List<String> actual = catSpy.getFood();
        Mockito.verify(catSpy, Mockito.times(1)).getFood();
        assertEquals("Ошибка сравнения", "Животные", actual.get(0));
        assertEquals("Ошибка сравнения", "Птицы", actual.get(1));
        assertEquals("Ошибка сравнения", "Рыба", actual.get(2));
    }

}