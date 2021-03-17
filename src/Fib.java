import processing.core.PVector;

public class Fib extends Surface {

    public void drawSphereSpiral(Surface s, PVector angle, float scale) {
        float points = 500;
        float e = (float) 0.36;
        float goldenRatio = (float) ((sqrt(5.0F) + 1.0) / 2.0);  // golden ratio = 1.6180339887498948482

        for (float i = 0; i < points; i += 0.5) {//for i++ becomes same as the one below
            float theta = 2 * PI * i / goldenRatio;
            float phi = acos(1 - 2 * (i + e) / (points - 1 + 2 * e));
            PVector v = new PVector();
            v.x = cos(theta) * sin(phi);
            v.y = sin(theta) * sin(phi);
            v.z = cos(phi);
            PVector rotated = matrix.matmul(rotation.rotationFull(angle), v);
            matrix.normalizeVector(rotated);
            rotated.mult(scale);
            s.point(rotated.x, rotated.y);
        }
    }

    public void drawSphere(Surface s, PVector angle, float scale) {
        float points = 100;
        float goldenRatio = (float) ((sqrt(5.0F) + 1.0) / 2.0);  // golden ratio = 1.6180339887498948482
        float offset = 2 / points;
        float increment = PI * (3- sqrt(5));
        PVector[] g ;
        g = new PVector[(int) (points + 1)];

       for (int i = 0; i < points; i ++) {
           PVector v = new PVector();
           v.y = ((i * offset) - 1) + (offset/2);
           float distance = sqrt(1 - pow(v.y, 2));
           float phi = ((i + 1) % points) * increment;
           v.x = cos(phi) * distance;
           v.z = sin(phi) * distance;
           PVector rotated = matrix.matmul(rotation.rotationFull(angle), v);
           matrix.normalizeVector(rotated);
           rotated.mult(scale);
           g[i] = rotated;
           s.point(g[i].x, g[i].y);
       }
    }

}

