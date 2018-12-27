package com.cans.ponggame;

class PongRect {
    private final int left;
    private final int top;
    private final int right;
    private final int bottom;

    int getLeft() {return left;}
    int getRight() {return right;}
    int getTop() {return top;}
    int getBottom() {return bottom;}

    @Override
    public String toString()
    {
        return String.format("%d %d %d %d", left, top, right, bottom);
    }


    public PongRect(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof PongRect ))return false;
        PongRect otherRect = (PongRect )other;
        return otherRect.left == left
                && otherRect.right == right
                && otherRect.bottom == bottom
                && otherRect.top == top;

    }
}
