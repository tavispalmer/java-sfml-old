package org.sfml_dev.graphics;

import org.sfml_dev.graphics.BlendMode.Equation;
import org.sfml_dev.graphics.BlendMode.Factor;

public class RenderStates implements Cloneable {

    public static final RenderStates DEFAULT = new RenderStates(new BlendMode(Factor.SRC_ALPHA, Factor.ONE_MINUS_SRC_ALPHA, Equation.ADD, Factor.ONE, Factor.ONE_MINUS_SRC_ALPHA, Equation.ADD));

    public BlendMode blendMode;

    public Transform transform;

    public Texture texture;

    public Shader shader;

    public RenderStates() {
        this.blendMode = BlendMode.BLEND_ALPHA.clone();
        this.transform = new Transform();
        this.texture = null;
        this.shader = null;
    }

    public RenderStates(BlendMode theBlendMode) {
        this.blendMode = theBlendMode.clone();
        this.transform = new Transform();
        this.texture = null;
        this.shader = null;
    }

    public RenderStates(Transform theTransform) {
        this.blendMode = BlendMode.BLEND_ALPHA.clone();
        this.transform = theTransform.clone();
        this.texture = null;
        this.shader = null;
    }

    public RenderStates(Texture theTexture) {
        this.blendMode = BlendMode.BLEND_ALPHA.clone();
        this.transform = new Transform();
        this.texture = theTexture;
        this.shader = null;
    }

    public RenderStates(Shader theShader) {
        this.blendMode = BlendMode.BLEND_ALPHA.clone();
        this.transform = new Transform();
        this.texture = null;
        this.shader = theShader;
    }

    public RenderStates(BlendMode theBlendMode, Transform theTransform, Texture theTexture, Shader theShader) {
        this.blendMode = theBlendMode.clone();
        this.transform = theTransform.clone();
        this.texture = theTexture;
        this.shader = theShader;
    }

    public RenderStates clone() {
        return new RenderStates(blendMode, transform, texture, shader);
    }
}
