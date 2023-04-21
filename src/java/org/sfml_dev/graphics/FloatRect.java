package org.sfml_dev.graphics;

import org.sfml_dev.system.Vector2f;

public class FloatRect implements Cloneable {
    
    public float left;
    public float top;
    public float width;
    public float height;

    public FloatRect() {
        this.left = 0;
        this.top = 0;
        this.width = 0;
        this.height = 0;
    }

    public FloatRect(float rectLeft, float rectTop, float rectWidth, float rectHeight) {
        this.left = rectLeft;
        this.top = rectTop;
        this.width = rectWidth;
        this.height = rectHeight;
    }

    public FloatRect(Vector2f position, Vector2f size) {
        this.left = position.x;
        this.top = position.y;
        this.width = size.x;
        this.height = size.y;
    }

    public boolean contains(float x, float y) {
        // Rectangles with negative dimensions are allowed, so we must handle them correctly

        // Compute the real min and max of the rectangle on both axes
        float minX = Math.min(left, (float)(left + width));
        float maxX = Math.max(left, (float)(left + width));
        float minY = Math.min(top, (float)(top + height));
        float maxY = Math.max(top, (float)(top + height));

        return (x >= minX) && (x < maxX) && (y >= minY) && (y < maxY);
    }

    public boolean contains(Vector2f point) {
        return contains(point.x, point.y);
    }

    public boolean intersects(FloatRect rectangle) {
        FloatRect intersection = new FloatRect();
        return intersects(rectangle, intersection);
    }

    public boolean intersects(FloatRect rectangle, FloatRect intersection) {
        // Rectangles with negative dimensions are allowed, so we must handle them correctly

        // Compute the min and max of the first rectangle on both axes
        float r1MinX = Math.min(left, (float)(left + width));
        float r1MaxX = Math.max(left, (float)(left + width));
        float r1MinY = Math.min(top, (float)(top + height));
        float r1MaxY = Math.max(top, (float)(top + height));

        // Compute the min and max of the second rectangle on both axes
        float r2MinX = Math.min(rectangle.left, (float)(rectangle.left + rectangle.width));
        float r2MaxX = Math.max(rectangle.left, (float)(rectangle.left + rectangle.width));
        float r2MinY = Math.min(rectangle.top, (float)(rectangle.top + rectangle.height));
        float r2MaxY = Math.max(rectangle.top, (float)(rectangle.top + rectangle.height));

        // Compute the intersection boundaries
        float interLeft   = Math.max(r1MinX, r2MinX);
        float interTop    = Math.max(r1MinY, r2MinY);
        float interRight  = Math.min(r1MaxX, r2MaxX);
        float interBottom = Math.min(r1MaxY, r2MaxY);

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
        if (val instanceof FloatRect floatRect) {
            return (left == floatRect.left) && (width == floatRect.width) &&
                   (top == floatRect.top) && (height == floatRect.height);
        }
        return false;
    }

    public FloatRect clone() {
        return new FloatRect(this.left, this.top, this.width, this.height);
    }

    public String toString() {
        return "{left=" + left +
                ", top=" + top +
                ", width=" + width +
                ", height=" + height + "}";
    }
}
