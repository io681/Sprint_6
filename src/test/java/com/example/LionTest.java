package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private Lion lionSpy;
    //Создание мока для стаба
    @Mock
    Lion lionStub;

    //внедрение зависимости и  инициализация  шпиона в Before
    @Before
        public void init () throws Exception {
        Predator feline = new Feline();
        Lion lion = new Lion("Самка", feline);
        lionSpy  = Mockito.spy(lion);
    }

    @Test
    public void getKittensTest () {
        Mockito.when(lionStub.getKittens()).thenReturn(1);
        int actual = lionStub.getKittens();
        assertEquals("Ошибка сравнения", 1, actual);

    }
    @Test
    public void getFood () throws Exception {
        List<String> actual = lionSpy.getFood();
        Mockito.verify(lionSpy, Mockito.times(1)).getFood();
        assertEquals("Ошибка сравнения 1-го элемента", "Животные", actual.get(0));
        assertEquals("Ошибка сравнения 2-го элемента", "Птицы", actual.get(1));
        assertEquals("Ошибка сравнения 3-го элемента", "Рыба", actual.get(2));

    }

}