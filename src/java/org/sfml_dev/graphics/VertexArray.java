package org.sfml_dev.graphics;

import java.util.function.LongConsumer;
import org.sfml_dev.system.*;

import static org.sfml_dev.system.sys.new_.*;
import static org.sfml_dev.system.sys.SFML_System.*;
import static org.sfml_dev.graphics.sys.SFML_Graphics.*;

public class VertexArray extends CppObject implements Drawable {

    public VertexArray() {
        sf_VertexArray_VertexArray(getPtr());
    }

    public VertexArray(PrimitiveType type) {
        this(type, 0);
    }

    public VertexArray(PrimitiveType type, int vertexCount) {
        sf_VertexArray_VertexArray(getPtr(), type.ordinal(), vertexCount);
    }

    public int getVertexCount() {
        return (int)sf_VertexArray_getVertexCount(getPtr());
    }

    public Vertex get(int index) {
        long vertex = sf_VertexArray_operator_index(getPtr(), index);
        long vertex_position = vertex + sf_Vertex_position;
        long vertex_color = vertex + sf_Vertex_color;
        long vertex_texCoords = vertex + sf_Vertex_texCoords;
        return new Vertex(
            new Vector2f(
                sf_Vector2f_getX(vertex_position),
                sf_Vector2f_getY(vertex_position)
            ),
            new Color(
                sf_Color_getR(vertex_color),
                sf_Color_getG(vertex_color),
                sf_Color_getB(vertex_color),
                sf_Color_getA(vertex_color)
            ),
            new Vector2f(
                sf_Vector2f_getX(vertex_texCoords),
                sf_Vector2f_getY(vertex_texCoords)
            )
        );
    }

    public void set(int index, Vertex value) {
        long thePosition = operator_new(sf_Vector2f_sizeof);
        sf_Vector2f_Vector2f(thePosition, value.position.x, value.position.y);

        long theColor = operator_new(sf_Color_sizeof);
        sf_Color_Color(theColor, value.color.r, value.color.g, value.color.b, value.color.a);

        long theTexCoords = operator_new(sf_Vector2f_sizeof);
        sf_Vector2f_Vector2f(theTexCoords, value.texCoords.x, value.texCoords.y);

        long vertex = sf_VertexArray_operator_index(getPtr(), index);
        sf_Vertex_Vertex(vertex, thePosition, theColor, theTexCoords);

        operator_delete(theTexCoords);
        operator_delete(theColor);
        operator_delete(thePosition);
    }

    public void clear() {
        sf_VertexArray_clear(getPtr());
    }

    public void resize(int vertexCount) {
        sf_VertexArray_resize(getPtr(), vertexCount);
    }

    public void append(Vertex vertex) {
        long thePosition = operator_new(sf_Vector2f_sizeof);
        sf_Vector2f_Vector2f(thePosition, vertex.position.x, vertex.position.y);

        long theColor = operator_new(sf_Color_sizeof);
        sf_Color_Color(theColor, vertex.color.r, vertex.color.g, vertex.color.b, vertex.color.a);

        long theTexCoords = operator_new(sf_Vector2f_sizeof);
        sf_Vector2f_Vector2f(theTexCoords, vertex.texCoords.x, vertex.texCoords.y);

        long sfVertex = operator_new(sf_Vertex_sizeof);
        sf_Vertex_Vertex(sfVertex, thePosition, theColor, theTexCoords);

        operator_delete(theTexCoords);
        operator_delete(theColor);
        operator_delete(thePosition);

        sf_VertexArray_append(getPtr(), sfVertex);
        
        operator_delete(sfVertex);
    }

    public void setPrimitiveType(PrimitiveType type) {
        sf_VertexArray_setPrimitiveType(getPtr(), type.ordinal());
    }

    public PrimitiveType getPrimitiveType() {
        return PrimitiveType.values()[sf_VertexArray_getPrimitiveType(getPtr())];
    }

    public FloatRect getBounds() {
        long sfBounds = operator_new(sf_FloatRect_sizeof);
        sf_VertexArray_getBounds(sfBounds, getPtr());

        FloatRect bounds = new FloatRect(
            sf_FloatRect_getLeft(sfBounds),
            sf_FloatRect_getTop(sfBounds),
            sf_FloatRect_getWidth(sfBounds),
            sf_FloatRect_getHeight(sfBounds)
        );

        operator_delete(sfBounds);
        return bounds;
    }

    public void draw(RenderTarget target, RenderStates states) {
        sf_VertexArray_draw(getPtr(), target.getPtr(), 0, 0);
    }

    protected long sizeof() {
        return sf_VertexArray_sizeof;
    }

    protected LongConsumer getDestructor() {
        return ptr -> sf_VertexArray_destructor(ptr);
    }
}
