import processing.core.PVector;

public class Satelite extends Surface{

    public void orbit(Surface s, PVector angle, float mySpeed, float myRadius) {
            PVector myAngle = new PVector(angle.x, angle.y);
            if (myAngle.x > 2*PI ){
                    myAngle.x =0; myAngle.y =0;
            }
            myAngle.mult(mySpeed);
            PVector c = new PVector();
            c.x = 2 * myRadius * sin(myAngle.x);
            c.y = myRadius * cos(myAngle.y);
            c.mult(scale);
            s.point(c.x, c.y);
    }

        public void orbit1(Surface s, PVector angle, float mySpeed, float myRadius) {
                PVector myAngle = new PVector(angle.x, angle.y);
                if (myAngle.x > 2*PI ){
                        myAngle.x =0; myAngle.y =0;
                }
                myAngle.mult(mySpeed);
                PVector c = new PVector();
                c.x = 2 * myRadius * sin(-myAngle.x);
                c.y = myRadius * cos(-myAngle.y);
                c.mult(scale);
                s.point(c.x, c.y);
        }

}


