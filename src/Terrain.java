import processing.core.PApplet;

public class Terrain extends PApplet {

    int w = 2000;
    int h = 1600;
    int col, row;
    int scale = 20;
    float[][] terrain;
    float fly = 0;

    public void settings(){
        size(600, 600, P3D);
        col = w / scale;
        row = h / scale;
        terrain = new float[col][row];
        //3840X2160
        pixelDensity(2);
    }

    public void draw() {
        fly -= 0.01;
        float yOffset = fly;
        for(int y = 0; y< row; y++) {
            float xOffset = 0;
            for (int x = 0; x < col; x++) {
                terrain[x][y] = map(noise(xOffset, yOffset), 0, 1, -100, 100);
                xOffset += 0.1;
            }
            yOffset += 0.1;
        }
        background(0);
        //stroke(255);
        stroke(230,230,250);
        noFill();
        translate(width / 2, height/2 +50);
        rotateX(PI / 3);

        translate(- w / 2, - h / 2);
        for(int y = 0; y< row - 1; y++){
            beginShape(TRIANGLE_STRIP);
            for(int x = 0; x < col; x++){
                vertex(x * scale, y * scale, terrain[x][y]);
                vertex(x * scale, (y + 1) * scale, terrain[x][y + 1]);
            }
            endShape(TRIANGLE_STRIP);
        }
    }

    public static void main(String... args){
        PApplet.main("Terrain");
    }
}
