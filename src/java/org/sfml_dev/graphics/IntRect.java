package org.sfml_dev.graphics;

import org.sfml_dev.system.Vector2i;

public class IntRect implements Cloneable {
    
    public int left;
    public int top;
    public int width;
    public int height;

    public IntRect() {
        this.left = 0;
        this.top = 0;
        this.width = 0;
        this.height = 0;
    }

    public IntRect(int rectLeft, int rectTop, int rectWidth, int rectHeight) {
        this.left = rectLeft;
        this.top = rectTop;
        this.width = rectWidth;
        this.height = rectHeight;
    }

    public IntRect(Vector2i position, Vector2i size) {
        this.left = position.x;
        this.top = position.y;
        this.width = size.x;
        this.height = size.y;
    }

    public boolean contains(int x, int y) {
        // Rectangles with negative dimensions are allowed, so we must handle them correctly

        // Compute the real min and max of the rectangle on both axes
        int minX = Math.min(left, (int)(left + width));
        int maxX = Math.max(left, (int)(left + width));
        int minY = Math.min(top, (int)(top + height));
        int maxY = Math.max(top, (int)(top + height));

        return (x >= minX) && (x < maxX) && (y >= minY) && (y < maxY);
    }

    public boolean contains(Vector2i point) {
        return contains(point.x, point.y);
    }

    public boolean intersects(IntRect rectangle) {
        IntRect intersection = new IntRect();
        return intersects(rectangle, intersection);
    }

    public boolean intersects(IntRect rectangle, IntRect intersection) {
        // Rectangles with negative dimensions are allowed, so we must handle them correctly

        // Compute the min and max of the first rectangle on both axes
        int r1MinX = Math.min(left, (int)(left + width));
        int r1MaxX = Math.max(left, (int)(left + width));
        int r1MinY = Math.min(top, (int)(top + height));
        int r1MaxY = Math.max(top, (int)(top + height));

        // Compute the min and max of the second rectangle on both axes
        int r2MinX = Math.min(rectangle.left, (int)(rectangle.left + rectangle.width));
        int r2MaxX = Math.max(rectangle.left, (int)(rectangle.left + rectangle.width));
        int r2MinY = Math.min(rectangle.top, (int)(rectangle.top + rectangle.height));
        int r2MaxY = Math.max(rectangle.top, (int)(rectangle.top + rectangle.height));

        // Compute the intersection boundaries
        int interLeft   = Math.max(r1MinX, r2MinX);
        int interTop    = Math.max(r1MinY, r2MinY);
        int interRight  = Math.min(r1MaxX, r2MaxX);
        int interBottom = Math.min(r1MaxY, r2MaxY);

        // If the intersection is valid (positive non zero area), then there is an intersection
        if ((interLeft < interRight) && (interTop < interBottom)) {
            intersection.left = interLeft;
            intersection.top = interTop;
            intersection.width = interRight - interLeft;
            intersection.height = interBottom - interTop;
            return true;
        }
        else {
            intersection.left = 0;
            intersection.top = 0;
            intersection.width = 0;
            intersection.height = 0;
            return false;
        }
    }

    public boolean equals(Object val) {
        if (val instanceof IntRect intRect) {
            return (left == intRect.left) && (width == intRect.width) &&
                   (top == intRect.top) && (height == intRect.height);
        }
        return false;
    }

    public IntRect clone() {
        return new IntRect(this.left, this.top, this.width, this.height);
    }

    public String toString() {
        return "{left=" + left +
                ", top=" + top +
                ", width=" + width +
                ", height=" + height + "}";
    }
}
