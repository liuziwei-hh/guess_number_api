package com.twschool.practice.domain;

import org.junit.Assert;
import org.junit.Test;

public class UserTest {

    @Test
    public void should_get_user_id_when_init_user_with_userId_is_test() {
        User u = new User("test");
        Assert.assertEquals("test", u.getUserId());
    }

    @Test
    public void should_return_3_when_user_win_1() {
        User u = new User("test");
        u.win();
        Assert.assertEquals(3, u.getscore());
    }

    @Test
    public void should_return_11_when_user_win_3() {
        User u = new User("test");
        u.win();
        u.win();
        u.win();
        Assert.assertEquals(11, u.getscore());
    }

    @Test
    public void should_return_20_when_user_win_5() {
        User u = new User("test");
        u.win();
        u.win();
        u.win();
        u.win();
        u.win();
        Assert.assertEquals(20, u.getscore());
    }

    @Test
    public void should_return_31_when_user_win_8() {
        User u = new User("test");
        u.win();
        u.win();
        u.win();
        u.win();
        u.win();
        u.win();
        u.win();
        u.win();
        Assert.assertEquals(31, u.getscore());
    }

    @Test
    public void should_return_40_when_user_win_10() {
        User u = new User("test");
        u.win();
        u.win();
        u.win();
        u.win();
        u.win();
        u.win();
        u.win();
        u.win();
        u.win();
        u.win();
        Assert.assertEquals(40, u.getscore());
    }

    @Test
    public void should_return_burden_3_when_user_lose() {
        User u = new User("test");
        u.lose();
        Assert.assertEquals(-3, u.getscore());
    }

    @Test
    public void should_return_6_when__2_times_win_and_lose_and_win() {
        User u = new User("test");
        u.win();
        u.win();
        u.lose();
        u.win();
        Assert.assertEquals(6, u.getscore());
    }

    @Test
    public void should_return_14_when_2_times_win_and_lose_and_3_times_win() {
        User i = new User("test");
        i.win();
        i.win();
        i.lose();
        i.win();
        i.win();
        i.win();
        Assert.assertEquals(14, i.getscore());
    }

}
