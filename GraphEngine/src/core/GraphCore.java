package core;


import java.awt.*;

public class GraphCore {
    Graphics2D g;

    public GraphCore(Graphics2D g) {
        this.g = g;
    }

    public void drawPoint(Vertex2D v) {
        g.setColor(v.c);
        g.drawRect(v.x, v.y, 1, 1);
    }

    public void drawLine(Vertex2D v0, Vertex2D v1) {
        int x0 = v0.x, y0 = v0.y;
        float[] c0 = v0.c.getRGBColorComponents(null);
        float[] c1 = v1.c.getRGBColorComponents(null);
        //Color c0 = v0.c, c1 = v1.c;
        final int x1 = v1.x, y1 = v1.y;
        final int dx = Math.abs(x1 - x0), sx = x0 < x1 ? 1 : -1;
        final int dy = Math.abs(y1 - y0), sy = y0 < y1 ? 1 : -1;
        int err = (dx > dy ? dx : -dy) / 2, e2;
        for (int i = 0; i < 3; i++) {
            c1[i] = (c1[i] - c0[i]) / (dx > dy ? dx : dy);
        }

        while (true) {
            drawPoint(new Vertex2D(x0, y0, new Color(testColor(c0[0]), testColor(c0[1]), testColor(c0[2]))));
            if (x0 == x1 && y0 == y1) break;

            for (int i = 0; i < 3; i++) {
                c0[i] += c1[i];
                if (c0[i] > 1) c0[i] = 1;
            }

            e2 = err;
            if (e2 > -dx) {
                err -= dy;
                x0 += sx;
            }
            if (e2 < dy) {
                err += dx;
                y0 += sy;
            }
        }
    }

    private float testColor(float f) {
        if (f <= 0) return 0f;
        if (f >= 1) return 1f;
        return f;
    }
}

