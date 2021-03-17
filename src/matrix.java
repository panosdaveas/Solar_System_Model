import processing.core.PVector;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class matrix {

    static PVector addToVector(PVector v, float s){
        PVector u;
        u = new PVector(v.x + s, v.y +s, v.z + s);
        return u;
    }

    float distance(PVector a, PVector b){
        return (float) sqrt(pow(a.x - b.x, 2) + pow(a.y - b.y, 2) + pow(a.z - b.z, 2));
    }

    static PVector cross(PVector a, PVector b) {
        PVector v = new PVector();
        v.x = a.y * b.z - b.y * a.z;
        v.y = a.z * b.x - b.z * a.x;
        v.z = a.x * b.y - b.x * a.y;
        return v;
    }

    static PVector subtractVectors(PVector v1, PVector v2){
        PVector v;
        v = new PVector(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z);
        return v;
    }

    static PVector normalizeVector(PVector v) {
        float d = (float) sqrt(pow(v.x,2) + pow(v.y ,2) + pow(v.z, 2));
        v.x /=d; v.y/=d; v.z/=d;
        return v;
    }

    float dot(PVector a, PVector b){
        return ((a.x * b.x) + (a.y * b.y) + (a.z * b.z));
    }

    static float[][] vector2Matrix(PVector v){
        float[][] m = new float[3][1];
        m[0][0] = v.x;
        m[1][0] = v.y;
        m[2][0] = v.z;
        return m;
    }

    static PVector matrix2Vector(float[][] m){
        PVector v = new PVector();
        v.x = m[0][0];
        v.y = m[1][0];
        if(m.length > 2){
            v.z = m[2][0];
        }
        return v;
    }

    static PVector matmul(float[][] a, PVector b){
        float[][] m = vector2Matrix(b);
        float[][] result = matmul(a, m);
        return matrix2Vector(result);
    }

    static float[][] matmul(float[][] a, float[][] b){
        int colA = a[0].length;
        int rowA = a.length;
        int colB = b[0].length;
        int rowB = b.length;

        if(colA != rowB){
            return null;
        }

        float result[][] = new float[rowA][colB];

        for(int i = 0; i < rowA; i++){
            for(int j = 0; j < colB; j++){
                float sum = 0;
                for(int k = 0; k < colA; k++){
                    sum += a[i][k] * b[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

}
