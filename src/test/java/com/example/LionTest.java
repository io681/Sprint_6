package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTest {
    private boolean isHasMane;
    private String sex;
    private Lion lion;
    private Lion lionSpy;



    public LionTest(boolean isHasMane,String sex) {
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
    //внедрение зависимости и  инициализация шпиона в Before
    @Before
        public void init () throws Exception {
        Predator feline = new Feline();
        lion  = new Lion(sex, feline);
        lionSpy  = Mockito.spy(lion);
    }
    @Test
    public void isHaveManeWhenMaleTest () {
        assertEquals("Объект не самец",isHasMane, lionSpy.isHaveMane());
    }
    @Test
    public void isHaveManeWhenFemaleTest () {
        assertEquals("Объект не самка", isHasMane, lionSpy.isHaveMane());
    }
    @Test
    public void getKittensTest () {
        int actual = lionSpy.getKittens();
        Mockito.verify(lionSpy, Mockito.times(1)).getKittens();
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