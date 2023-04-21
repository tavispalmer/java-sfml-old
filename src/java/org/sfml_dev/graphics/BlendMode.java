package org.sfml_dev.graphics;

public class BlendMode implements Cloneable {

    public enum Factor {
        ZERO,
        ONE,
        SRC_COLOR,
        ONE_MINUS_SRC_COLOR,
        DST_COLOR,
        ONE_MINUS_DST_COLOR,
        SRC_ALPHA,
        ONE_MINUS_SRC_ALPHA,
        DST_ALPHA,
        ONE_MINUS_DST_ALPHA
    }

    public enum Equation {
        ADD,
        SUBTRACT,
        REVERSE_SUBTRACT
    }

    public static final BlendMode BLEND_ALPHA = new BlendMode(Factor.SRC_ALPHA, Factor.ONE_MINUS_SRC_ALPHA, Equation.ADD,
                                                              Factor.ONE, Factor.ONE_MINUS_SRC_ALPHA, Equation.ADD);

    public static final BlendMode BLEND_ADD = new BlendMode(Factor.SRC_ALPHA, Factor.ONE, Equation.ADD,
                                                            Factor.ONE, Factor.ONE, Equation.ADD);

    public static final BlendMode BLEND_MULTIPLY = new BlendMode(Factor.DST_COLOR, Factor.ZERO);

    public static final BlendMode BLEND_NONE = new BlendMode(Factor.ONE, Factor.ZERO);

    public Factor colorSrcFactor;
    
    public Factor colorDstFactor;

    public Equation colorEquation;

    public Factor alphaSrcFactor;

    public Factor alphaDstFactor;

    public Equation alphaEquation;

    public BlendMode() {
        this.colorSrcFactor = Factor.SRC_ALPHA;
        this.colorDstFactor = Factor.ONE_MINUS_SRC_ALPHA;
        this.colorEquation = Equation.ADD;
        this.alphaSrcFactor = Factor.ONE;
        this.alphaDstFactor = Factor.ONE_MINUS_SRC_ALPHA;
        this.alphaEquation = Equation.ADD;
    }

    public BlendMode(Factor sourceFactor, Factor destinationFactor) {
        this(sourceFactor, destinationFactor, Equation.ADD);
    }

    public BlendMode(Factor sourceFactor, Factor destinationFactor, Equation blendEquation) {
        this.colorSrcFactor = sourceFactor;
        this.colorDstFactor = destinationFactor;
        this.colorEquation = blendEquation;
        this.alphaSrcFactor = sourceFactor;
        this.alphaDstFactor = destinationFactor;
        this.alphaEquation = blendEquation;
    }

    public BlendMode(Factor colorSourceFactor, Factor colorDestinationFactor,
                     Equation colorBlendEquation, Factor alphaSourceFactor,
                     Factor alphaDestinationFactor, Equation alphaBlendEquation) {
        this.colorSrcFactor = colorSourceFactor;
        this.colorDstFactor = colorDestinationFactor;
        this.colorEquation = colorBlendEquation;
        this.alphaSrcFactor = alphaSourceFactor;
        this.alphaDstFactor = alphaDestinationFactor;
        this.alphaEquation = alphaBlendEquation;
    }

    public boolean equals(Object val) {
        if (val instanceof BlendMode blendMode) {
            return (this.colorSrcFactor == blendMode.colorSrcFactor) &&
                   (this.colorDstFactor == blendMode.colorDstFactor) &&
                   (this.colorEquation  == blendMode.colorEquation)  &&
                   (this.alphaSrcFactor == blendMode.alphaSrcFactor) &&
                   (this.alphaDstFactor == blendMode.alphaDstFactor) &&
                   (this.alphaEquation  == blendMode.alphaEquation);
        }
        return false;
    }

    public BlendMode clone() {
        return new BlendMode(colorSrcFactor, colorDstFactor, colorEquation, alphaSrcFactor, alphaDstFactor, alphaEquation);
    }

    public String toString() {
        return "{colorSrcFactor=" + colorSrcFactor +
                ", colorDstFactor=" + colorDstFactor +
                ", colorEquation=" + colorEquation +
                ", alphaSrcFactor=" + alphaSrcFactor +
                ", alphaDstFactor=" + alphaDstFactor +
                ", alphaEquation=" + alphaEquation + "}";
    }
}
