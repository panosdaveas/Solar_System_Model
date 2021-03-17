import processing.core.PApplet;
import processing.core.PVector;

public class test extends  PApplet {

    float FOVangle = deg2rad(60);
    int numOfRays = 320;
    float rayAngle;
    int tileSize = 32;
    int rows = 10;
    int cols = 10;
    int windowWidth = cols * tileSize;
    int windowHeight = rows * tileSize;
    int[][] wall;

    public  void settings(){
        size(windowWidth, windowHeight);
        wall = new int[32][32];
   }

    public void draw(){
        background(0);
        noFill();
        //translate(width/2 ,  height/2);

        printGrid();
        //rayAngle += FOVangle / numOfRays;
    }

    public void grid(){
        for (int i = 0; i < cols; i++){
            for ( int j = 0; j < rows; j++){
                if (i == 0 || i == cols -1 || j ==0){
                   wall[i][j] = 1;
                }else{
                   wall[i][j] = 0;
                }
            }
        }
    }

    public void printGrid(){
        grid();
        for (int i = 0; i < cols; i++){
            for ( int j = 0; j < rows; j++){
                int tileX = i * tileSize;
                int tileY = j * tileSize;
                int tileColor = wall[i][j] == 1 ? 0 : 139;
                stroke(255);
                strokeWeight(1);
                fill(tileColor);
                rect(tileX, tileY, tileSize, tileSize);
            }
        }
    }

    public float distance(PVector a, PVector b){
        return (float) sqrt(pow(a.x - b.x, 2) + pow(a.y - b.y, 2));
    }

    public float deg2rad(float degrees) {
        return degrees * (PI / 180);
    }

    public static void main(String... args){
        PApplet.main("test");
    }
}

