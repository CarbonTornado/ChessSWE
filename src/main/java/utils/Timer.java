package utils;

public class Timer {
    private int hh;
    private int mm;
    private int ss;

    public Timer(int hh, int mm, int ss) {
        this.hh = hh;
        this.mm = mm;
        this.ss = ss;
    }

    public boolean isOutOfTime() {
        return (this.hh == 0 && this.mm == 0 && this.ss == 0);
    }

    public void decrement() {
        if (this.mm == 0 && this.ss == 0) {
            this.ss = 59;
            this.mm = 59;
            this.hh--;
        } else if (this.ss == 0) {
            this.ss = 59;
            this.mm--;
        } else this.ss--;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", this.hh, this.mm, this.ss);
    }

}
