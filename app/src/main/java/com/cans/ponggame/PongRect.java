package com.cans.ponggame;

class PongRect {
    private final float left;
    private final float top;
    private final float right;
    private final float bottom;

    float getLeft() {return left;}
    float getRight() {return right;}
    float getTop() {return top;}
    float getBottom() {return bottom;}

    @Override
    public String toString()
    {
        return String.format("%d %d %d %d", left, top, right, bottom);
    }


    public PongRect(float left, float top, float right, float bottom) {
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

    public PongRect translate(float x, float y) {
        return new PongRect(left + x, top + y, right+x, bottom+y);
    }
}
