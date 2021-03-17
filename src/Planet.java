import processing.core.PVector;

public class Planet extends Surface{

    public void orbit(Surface s, PVector angle, float scale, float orbitVelocity, PVector orbitAngle){
            float count = 0;
            while (count < orbitVelocity) {
                drawSphere(s, angle, scale);
                count += orbitVelocity / 0.01;
            }
            orbitAngle.x += orbitVelocity;
            orbitAngle.y += orbitVelocity;
            center.x = (float) (2 * sin(orbitAngle.x));
            center.y = cos(orbitAngle.y);
            center.mult(scale);
            if (orbitAngle.x >= 2*PI || orbitAngle.y >= 2*PI){
                orbitAngle.x =0; orbitAngle.y =0;
            }
    }

    public void drawSphere(Surface s, PVector angle, float scale) {
        int points = 20;
        for( int i = 0; i < points; i++){
            float theta = map(i, 0, points, - PI, PI);
            for( int j = 0; j <= points; j++){
                float phi = map (j, 0 , points, - (HALF_PI), (HALF_PI));
                PVector v = new PVector();
                v.x = sin(theta) * cos(phi);
                v.y = sin(theta) * sin(phi);
                v.z = cos(theta);
                PVector rotated =matrix.matmul(rotation.rotationFull(angle), v);
                matrix.normalizeVector(rotated);
                PVector projected = matrix.matmul(new projection().projection2D, rotated);
                projected.mult(scale);
                s.point(center.x + projected.x, center.y + projected.y);
            }
        }
    }

}
