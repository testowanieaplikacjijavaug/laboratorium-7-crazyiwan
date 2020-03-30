import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.assertj.core.api.Assertions.assertThat;

public class NoteTest {

    @Test
    void testGetName(){
        assertThat(Note.of("Jarek", 4).getName()).isEqualTo("Jarek");
    }

    @Test
    void testGetNote(){
        assertThat(Note.of("Jarek", 4).getNote()).isEqualTo(4);
    }

    @Test
    void testEmptyName(){
        assertThatThrownBy(() -> {
            Note.of("", 4);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Imię ucznia nie może być puste");
    }

    @Test
    void testNullName(){
        assertThatThrownBy(() -> {
            Note.of(null, 4);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Imię ucznia nie może być null");
    }

    @Test
    void testTrimWhitespaces(){
        assertThatThrownBy(() -> {
            Note.of(" \n \t \n    ", 4);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Imię ucznia nie może być puste");
    }

    @Test
    void testGradeOverRange(){
        assertThatThrownBy(() -> {
            Note.of("Marek", 8);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Niewłaściwa ocena");
    }

    @Test
    void testGradeBelowRange(){
        assertThatThrownBy(() -> {
            Note.of("Czarek", 1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Niewłaściwa ocena");
    }

    @Test
    void testNegativeGrade(){
        assertThatThrownBy(() -> {
            Note.of("Bartek", -3);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Niewłaściwa ocena");
    }
}
