package com.nomadlabs.quartolib;

/**
 * Created by doubleo2 on 9/7/14.
 */
public class Piece {

    Color color;

    Density density;

    Size size;

    Shape shape;

    boolean isPlayed;

    boolean isHighlighted;

    public Piece(Color color, Density density, Shape shape, Size size) {
        this.color = color;
        this.density = density;
        this.shape = shape;
        this.size = size;
        this.isPlayed = false;
    }

    public static Piece[] createSet(Piece.Color color) {
        Piece[] pieces = new Piece[8];

        int index = 0;
        for (Piece.Density d : Piece.Density.values()) {
            for (Piece.Shape h : Piece.Shape.values()) {
                for (Piece.Size s : Piece.Size.values()) {
                    pieces[index] = new Piece(color, d, h, s);
                    index++;
                }
            }
        }

        return pieces;
    }

    public static boolean haveCommonDimension(Piece... pieces) {
        if (pieces.length < 2) {
            return true;
        }

        Piece ref = pieces[0];
        boolean colorMatch = true,
                densityMatch = true,
                shapeMatch = true,
                sizeMatch = true;

        for (Piece p : pieces) {
            if (colorMatch) {
                colorMatch = ref.colorEquals(p);
            }
            if (densityMatch) {
                densityMatch = ref.densityEquals(p);
            }
            if (shapeMatch) {
                shapeMatch = ref.shapeEquals(p);
            }
            if (sizeMatch) {
                sizeMatch = ref.sizeEquals(p);
            }
        }
        return colorMatch || densityMatch || shapeMatch || sizeMatch;
    }

    boolean colorEquals(Piece p) {
        return (null != p) && this.color == p.color;
    }

    boolean densityEquals(Piece p) {
        return (null != p) && this.density == p.density;
    }

    boolean shapeEquals(Piece p) {
        return (null != p) && this.shape == p.shape;
    }

    boolean sizeEquals(Piece p) {
        return (null != p) && this.size == p.size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Piece)) {
            return false;
        }

        Piece p = (Piece) obj;

        return this.color == p.color &&
                this.density == p.density &&
                this.shape == p.shape &&
                this.size == p.size;
    }

    public void setHighlighted(boolean b) {
        isHighlighted = b;
    }

    public void setPlayed(boolean b) {
        isPlayed = b;
    }

    public static enum Color {
        BLUE, RED
    }

    public static enum Size {
        SHORT, TALL
    }

    public static enum Shape {
        ROUND, SQUARE
    }

    public static enum Density {
        HOLLOW, SOLID
    }

}
