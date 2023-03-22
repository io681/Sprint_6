package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AlexLionTest {
    AlexLion alexLion;

    @Before
    public void initObject () throws Exception {
        //внедрение зависимости и инициализация объекта
        Predator feline = new Feline();
        alexLion  = new AlexLion(feline);
    }

    @Test
    public void getFriendsTest () {

        List<String> actual =  alexLion.getFriends();
        assertEquals("Ошибка сравнения 1-го элемента", "Марти", actual.get(0));
        assertEquals("Ошибка сравнения 2-го элемента", "Глория", actual.get(1));
        assertEquals("Ошибка сравнения 3-го элемента", "Мелман", actual.get(2));
    }

    @Test
    public void getPlaceOfLivingTest () {
        assertEquals("Ошибка места жительства", "Нью-Йоркский зоопарк", alexLion.getPlaceOfLiving());
    }

    @Test
    public void getKittensTest (){
        assertEquals("Ошибка сравнения", 0, alexLion.getKittens());
    }
}
