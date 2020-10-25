package pieces;

public enum PieceColor {
    BLACK("Black"), WHITE("White");

    private final String name;

    PieceColor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
