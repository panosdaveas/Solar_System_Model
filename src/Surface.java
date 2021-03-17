import processing.core.PApplet;
import processing.core.PVector;

public class Surface extends PApplet {

    boolean paused = false;
    float radius = 1;//create normalized objects
    float speed = (float) 0.01;
    float scale = 100;
    PVector angle = new PVector(0,0,0);
    PVector center = new PVector(0,0);
    float orbitVelocity = 0.005f;
    PVector orbitAngle = new PVector(0, 0, 0);

    Fib fib; Moon moon; Sun sun; Satelite sat; Planet planet; test t;

    public void settings(){
        size(1000, 800);
        fib = new Fib();
        t = new test();
        moon = new Moon();
        sun = new Sun();
        sat = new Satelite();
        planet = new Planet();
    }
    public void draw() {
        background(0);
        stroke(255);
        strokeWeight(1);
        noFill();

        translate((float)width/2, (float)height/2);

        planet.drawSphere(this, angle, scale);
        //fib.drawSphere(this, angle, scale*2);
        // pushMatrix();
        // translate((float)width/2, (float)height/2);
        //planet.orbit(this, angle, scale/2, orbitVelocity, orbitAngle);
        // popMatrix();

        // pushMatrix();
        // translate(width - 80, height - 80);
        //sun.drawSphere(this, angle, scale * 2);
        // popMatrix();

        // pushMatrix();
        // translate(80,80);
        // moon.drawSphere(this, angle, scale * 2);
        // popMatrix();

        // pushMatrix();
        // translate((float)width/2, (float)height/2);
        // fib.drawSphere(this, angle, scale);
        // strokeWeight(4);
        // sat.orbit(this, angle, 1, 2);
        // strokeWeight(6);
        // sat.orbit1(this, angle, 1, 1);
        // popMatrix();

        setAngle();

    }

    void setAngle(){
        angle.x += speed;
        angle.y += speed;
        angle.z += speed;
        if (angle.x > 2*PI ){
            angle.x =0; angle.y =0; angle.z = 0;
        }
    }

    public void keyPressed() {
        if (key == CODED) {
            if (keyCode == LEFT) {
                angle.y += 0.04;
            }
            if (keyCode == RIGHT) {
                angle.y -= 0.04;
            }
            if (keyCode == UP) {
                angle.x -= 0.04;
            }
            if (keyCode == DOWN) {
                angle.x += 0.04;
            }
            if (keyCode == SHIFT) {
                paused = !paused;
                if (paused) {
                    noLoop();
                    redraw();
                } else {
                    loop();
                }
            }
            } else if (key == 'w') {
                angle.z += 0.04;
            } else if (key == 's') {
                angle.z -= 0.04;
            }
        }

    public static void main(String... args){
        PApplet.main("Surface");
    }
}