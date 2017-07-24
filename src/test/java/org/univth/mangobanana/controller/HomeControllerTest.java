package org.univth.mangobanana.controller;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by TaeHwan
 * 2017. 7. 24. PM 3:09
 */
public class HomeControllerTest {
    @Test
    public void home() throws Exception {
        HomeController home = new HomeController();
        assertEquals("Hello World",home.home());
    }
}