import processing.core.PApplet;
import processing.core.PVector;

import java.util.Vector;

public class Cube extends PApplet{

    float step;
    PVector angle;
    int vertex;
    float distance;
    Vector<PVector> cube;
    PVector[][] faces;

    public  void settings(){
       size(600, 600);
       pixelDensity(2);
       angle = new PVector(0, 0, 0);
       vertex = 1;
       step = 2F;
       distance = 4;
    }

    public void draw(){
        background(0);
        stroke(255);
        strokeWeight(1);
        noFill();
        translate(width/2, height/2);

        cube = new Vector<>();
        faces = new PVector[6][4];
        createCube(vertex);
        angle = matrix.addToVector(angle, 0.01f);
    }

    public void createCube(int vertex) {
        for (float x = -vertex; x <= vertex; x+=step) {
            for (float y = -vertex; y <= vertex; y+=step) {
                for (float z = -vertex; z <= vertex; z+=step) {
                    PVector v = new PVector(x,y,z);
                    PVector r = matrix.matmul(rotation.rotationFull(angle), v);
                    r.normalize();//sphere??
                    PVector p = matrix.matmul(new projection().perspProjection2D(distance, r.z), r);
                    //PVector p = matrix.matmul(new projection().projection2D, r);
                    p.mult(200);
                    point(p.x, p.y);
                    cube.add(new PVector(p.x, p.y));
                }
            }
        }

        faces[0] = new PVector[]{ cube.get(0), cube.get(1), cube.get(3), cube.get(2)} ;
        faces[1] = new PVector[]{ cube.get(0), cube.get(4), cube.get(5), cube.get(1)} ;
        faces[2] = new PVector[]{ cube.get(5), cube.get(4), cube.get(6), cube.get(7)} ;
        faces[3] = new PVector[]{ cube.get(2), cube.get(6), cube.get(7), cube.get(3)} ;
        faces[4] = new PVector[]{ cube.get(1), cube.get(5), cube.get(7), cube.get(3)} ;
        faces[5] = new PVector[]{ cube.get(0), cube.get(4), cube.get(6), cube.get(2)} ;

        for(int i = 0; i < 6; i++){
            connect(0, 1, faces[i]);
            connect(1, 2, faces[i]);
            connect(2, 3, faces[i]);
            connect(3, 0, faces[i]);
            connect(0, 2, faces[i]);
        }
    }

    public void  connect(int i, int j, PVector[] points){
        PVector a = points[i];
        PVector b = points[j];
        line(a.x, a.y, b.x, b.y);
    }

    public static void main(String... args){
        PApplet.main("Cube");
    }

}
