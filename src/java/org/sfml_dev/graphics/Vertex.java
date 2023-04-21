package org.sfml_dev.graphics;

import org.sfml_dev.system.Vector2f;

public class Vertex {
    
    public Vector2f position;

    public Color color;

    public Vector2f texCoords;

    public Vertex() {
        this.position = new Vector2f(0, 0);
        this.color = new Color(255, 255, 255);
        this.texCoords = new Vector2f(0, 0);
    }

    public Vertex(Vector2f thePosition) {
        this.position = thePosition.clone();
        this.color = new Color(255, 255, 255);
        this.texCoords = new Vector2f(0, 0);
    }

    public Vertex(Vector2f thePosition, Color theColor) {
        this.position = thePosition.clone();
        this.color = theColor.clone();
        this.texCoords = new Vector2f(0, 0);
    }

    public Vertex(Vector2f thePosition, Vector2f theTexCoords) {
        this.position = thePosition.clone();
        this.color = new Color(255, 255, 255);
        this.texCoords = theTexCoords.clone();
    }

    public Vertex(Vector2f thePosition, Color theColor, Vector2f theTexCoords) {
        this.position = thePosition.clone();
        this.color = theColor.clone();
        this.texCoords = theTexCoords.clone();
    }
}
