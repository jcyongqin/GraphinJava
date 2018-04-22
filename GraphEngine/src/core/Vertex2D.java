package core;

import java.awt.*;

public class Vertex2D {
    public int x;
    public int y;
    public Color c;

    public Vertex2D(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.c = color;
    }

    public Vertex2D(int x, int y) {
        this.x = x;
        this.y = y;
        this.c = Color.black;
    }
}


