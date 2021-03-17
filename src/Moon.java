import processing.core.PVector;

public class Moon extends Surface{

    public void drawSphere(Surface s, PVector angle,float scale) {
        float goldenRatio = (sqrt(5) + 1) / 2;
        float points = 2000;
            for (float i = 0; i < points; i++) {
                float theta = 2 * PI * i / goldenRatio;
                float phi = acos((float) (1 - 2 * (i+ 0.5) / points));
                PVector v = new PVector();
                v.x = cos(theta) * cos(phi);
                v.y = sin(theta) * cos(phi);
                v.z = sin(phi);
                PVector angleMoon = new PVector(PI/2,angle.y,angle.z);
                PVector rotated =matrix.matmul(rotation.rotationFull(angleMoon), v);
                matrix.normalizeVector(rotated);
                rotated.mult(scale);
                if(rotated.z >= 0) {
                    //s.pushMatrix();
                    //s.translate(50, 50);
                    s.point(rotated.x, rotated.y);
                    //s.popMatrix();
                }
            }
        }

}


