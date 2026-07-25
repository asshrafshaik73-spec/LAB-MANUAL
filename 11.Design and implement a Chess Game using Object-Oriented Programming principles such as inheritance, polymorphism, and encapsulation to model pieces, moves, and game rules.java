abstract class ChessPiece {
    private String color;

    public ChessPiece(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    // Polymorphism
    public abstract void move();
}

// Inheritance
class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    public void move() {
        System.out.println(getColor() + " King moves one square in any direction.");
    }
}

class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    public void move() {
        System.out.println(getColor() + " Queen moves any number of squares.");
    }
}

class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    public void move() {
        System.out.println(getColor() + " Rook moves horizontally or vertically.");
    }
}

class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    public void move() {
        System.out.println(getColor() + " Bishop moves diagonally.");
    }
}

class Knight extends ChessPiece {
    public Knight(String color) {
        super(color);
    }

    public void move() {
        System.out.println(getColor() + " Knight moves in an L-shape.");
    }
}

class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    public void move() {
        System.out.println(getColor() + " Pawn moves one step forward.");
    }
}

public class ChessGame {

    public static void main(String[] args) {

        ChessPiece[] pieces = {
            new King("White"),
            new Queen("White"),
            new Rook("White"),
            new Bishop("White"),
            new Knight("White"),
            new Pawn("White"),

            new King("Black"),
            new Queen("Black"),
            new Rook("Black"),
            new Bishop("Black"),
            new Knight("Black"),
            new Pawn("Black")
        };

        System.out.println("===== Chess Game =====");

        // Polymorphism
        for (ChessPiece piece : pieces) {
            piece.move();
        }
    }
}
