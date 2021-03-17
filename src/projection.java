import processing.core.PVector;

import static java.lang.Math.*;

public class projection {

    float[][] projection2D =
            new float[][]  {
                    {-1,0,0},
                    {0,-1,0}
            };

    float[][] perspProjection2D(float distance, float rotated )  {
        float z = 1 / (distance/2 - rotated/2);
        return new float[][]{
                {z, 0, 0},
                {0, z, 0},
        };
    }

    float[][] stereoProjection(PVector v)  {
        return new float[][]{
                {(float) (sin(PI/3) / (1 - cos(PI/3))),0, 0},
                {0, v.y, 0},
        };
    }

}

