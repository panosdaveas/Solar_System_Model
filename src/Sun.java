import processing.core.PVector;

public class Sun extends Surface{

    public void drawSphere(Surface s, PVector angle, float scale) {
        float points = 50;
        float gr= (float) ((sqrt(5.0F) + 1.0) / 2.0);  // golden ratio = 1.6180339887498948482
        float ga= (float) ((2.0 - gr) * (2.0*PI));  // golden angle = 2.39996322972865332
        float k =10;
        for (float i = 0; i < points; i++) {
            float phi = k * sqrt(i);
            for (float j = 0; j < points; j++){
                float theta = ga * j;
                PVector v = new PVector();
                v.x = cos(theta) * cos(phi);
                v.y = sin(theta) * cos(phi);
                v.z = sin(phi);
                PVector rotated =matrix.matmul(rotation.rotationFull(angle), v);
                matrix.normalizeVector(rotated);
                rotated.mult(scale);
                v.mult(scale);
                s.point(rotated.x, rotated.y);
                s.point(v.x, v.y);
            }
        }
    }

}


