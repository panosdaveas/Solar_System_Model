import processing.core.PVector;
import static processing.core.PApplet.cos;
import static processing.core.PApplet.sin;

public class rotation {
    //Pitch
    static float[][] rotationX(float angle){
        return new float[][]{
                { 1,          0,           0},
                { 0, cos(angle), -sin(angle)},
                { 0, sin(angle),  cos(angle)}
        };
    }
    //Yaw
    static float[][] rotationY(float angle){
        return new float[][]{
                { cos(angle), 0, sin(angle)},
                { 0,          1,          0},
                {-sin(angle), 0, cos(angle)}
        };
    }
    //Roll
    static float[][] rotationZ(float angle){
        return new float[][]{
                { cos(angle), -sin(angle), 0},
                { sin(angle),  cos(angle), 0},
                { 0,           0,          1}
        };
    }

    static float[][] rotationFull(PVector angle){
        //important* use this order: roll/pitch/yaw depending on screen axis orientation
        new matrix();
        return matrix.matmul(matrix.matmul(rotationX(angle.x),rotationY(angle.y)),rotationZ(angle.z));
    }

}
