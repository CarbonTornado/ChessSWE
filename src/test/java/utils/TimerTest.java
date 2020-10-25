package utils;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TimerTest {

    @Test
    public void outOfTime() {
        Timer timer = new Timer(0, 0, 1);
        timer.decrement();
        assertThat(timer.isOutOfTime()).isTrue();
    }

    @Test
    public void notOutOfTimeMinutes() {
        Timer timer = new Timer(0, 1, 0);
        timer.decrement();
        assertThat(timer.isOutOfTime()).isFalse();
    }

    @Test
    public void notOutOfTimeHours() {
        Timer timer = new Timer(1, 0, 0);
        timer.decrement();
        assertThat(timer.isOutOfTime()).isFalse();
    }

   @Test
    public void string(){
        Timer timer = new Timer(10, 0, 0);
        assertThat(timer).hasToString("10:00:00");
    }
}
