package pieces;

/**
 * The enum Piece color.
 */
public enum PieceColor {
    /**
     * Black piece color.
     */
    BLACK("Black"),
    /**
     * White piece color.
     */
    WHITE("White");

    private final String name;

    PieceColor(String name) {
        this.name = name;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }
}
