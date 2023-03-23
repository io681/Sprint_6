package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private boolean isHasMane;
    private String sex;
    private Lion lion;
    public LionParameterizedTest(boolean isHasMane,String sex) {
        this.isHasMane = isHasMane;
        this.sex =sex;
    }
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {true, "Самец"},
                {false, "Самка"},
        };
    }
    @Test
    public void isHaveManeTest () throws Exception {
        //внедрение зависимости
        Predator feline = new Feline();
        lion  = new Lion(sex, feline);
        assertEquals("Ошибка сравнения",isHasMane, lion.isHaveMane());
    }

}
