package utils;

/**
 * The type Timer.
 */
public class ChessClock {
    private int hh;
    private int mm;
    private int ss;

    /**
     * Instantiates a new Timer.
     *
     * @param hh the hh
     * @param mm the mm
     * @param ss the ss
     */
    public ChessClock(int hh, int mm, int ss) {
        this.hh = hh;
        this.mm = mm;
        this.ss = ss;
    }

    /**
     * Is out of time boolean.
     *
     * @return the boolean
     */
    public boolean isOutOfTime() {
        return (this.hh == 0 && this.mm == 0 && this.ss == 0);
    }

    /**
     * Decrement.
     */
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
