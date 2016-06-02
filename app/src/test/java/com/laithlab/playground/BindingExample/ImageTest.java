package com.laithlab.playground.BindingExample;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ImageTest {

    @Test
    public void testingTheGetMethodsForSillyReasons() throws Exception {
        Image image = new Image("title", "url");
        assertEquals(image.getTitle(), "title");
        assertEquals(image.getUrl(), "url");
    }
    @Test
    public void testingTheSetMethodsForSillyReasons() throws Exception {
        Image image = new Image("title", "url");
        assertEquals(image.getTitle(), "title");
        image.setTitle("title1");
        assertEquals(image.getTitle(), "title1");
    }
}