package utils;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClockTest {

    @Test
    public void outOfTime() {
        Clock clock = new Clock(0, 0, 1);
        clock.decrement();
        assertThat(clock.isOutOfTime()).isTrue();
    }

    @Test
    public void notOutOfTimeMinutes() {
        Clock clock = new Clock(0, 1, 0);
        clock.decrement();
        assertThat(clock.isOutOfTime()).isFalse();
    }

    @Test
    public void notOutOfTimeHours() {
        Clock clock = new Clock(1, 0, 0);
        clock.decrement();
        assertThat(clock.isOutOfTime()).isFalse();
    }

   @Test
    public void testToString(){
        Clock clock = new Clock(10, 0, 0);
        assertThat(clock).hasToString("10:00:00");
    }
}
