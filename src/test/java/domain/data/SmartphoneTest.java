package domain.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    @Test
    public void shouldUseSmartphone() {
        Smartphone first = new Smartphone(11,"Autor1",400,"somebody");
        Smartphone second = new Smartphone(12,"Autor2",400,"was");
        Smartphone third = new Smartphone(13,"Autor3",400,"toldMe");
        assertEquals(first, second,third);
    }
}