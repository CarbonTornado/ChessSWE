package utils;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ChessClockTest {

    @Test
    public void outOfTime() {
        ChessClock chessClock = new ChessClock(0, 0, 1);
        chessClock.decrement();
        assertThat(chessClock.isOutOfTime()).isTrue();
    }

    @Test
    public void notOutOfTimeMinutes() {
        ChessClock chessClock = new ChessClock(0, 1, 0);
        chessClock.decrement();
        assertThat(chessClock.isOutOfTime()).isFalse();
    }

    @Test
    public void notOutOfTimeHours() {
        ChessClock chessClock = new ChessClock(1, 0, 0);
        chessClock.decrement();
        assertThat(chessClock.isOutOfTime()).isFalse();
    }

   @Test
    public void testToString(){
        ChessClock chessClock = new ChessClock(10, 0, 0);
        assertThat(chessClock).hasToString("10:00:00");
    }
}
