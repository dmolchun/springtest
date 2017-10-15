package ru.clean.process;

import org.junit.Assert;
import org.junit.Test;

public class UnbynkTest {
    @Test
    public void testGetString() {
        Assert.assertEquals("String", new Unbynk().getString());
    }
}
