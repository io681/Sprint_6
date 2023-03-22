package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineTest {
    private final int countKittens;
    private Feline felineSpy;

    public FelineTest (int countKittens){
        this.countKittens=countKittens;
    }
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {4},
                {-1},
                {1},
                {0},
        };
    }
    @Before
    public void initSpyFeline() {
        Feline feline = new Feline();
        felineSpy  = Mockito.spy(feline);
    }
    @Test
    public void eatMeatTest() throws Exception {
        List<String> actual = felineSpy.eatMeat();
        Mockito.verify(felineSpy, Mockito.times(1)).getFood("Хищник");
        assertEquals("Ошибка сравнения 1-го элемента", "Животные", actual.get(0));
        assertEquals("Ошибка сравнения 2-го элемента", "Птицы", actual.get(1));
        assertEquals("Ошибка сравнения 3-го элемента", "Рыба", actual.get(2));
    }

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        assertEquals("Ошибка сравнения", "Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensTest() {
        int actual = felineSpy.getKittens();
        Mockito.verify(felineSpy, Mockito.times(1)).getKittens(1);
        assertEquals("Ошибка сравнения", 1, actual);
    }

    @Test
    public void getKittensWithArgumentTest() {
        int actual = felineSpy.getKittens(countKittens);
        Mockito.verify(felineSpy, Mockito.times(1)).getKittens(countKittens);
        assertEquals("Ошибка сравнения", countKittens, actual);
    }

}