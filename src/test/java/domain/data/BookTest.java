package domain.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BookTest {
    @Test
    public void shouldUseBook() {
        Book first = new Book(21,"Autor21",400,"theWorld ");
        Book second = new Book(22,"Autor22",400,"isGonna");
        Book third = new Book(23,"Autor23",400,"rollMe");
        assertEquals(first, second,third);
    }
}