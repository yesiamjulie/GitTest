package importTest;

import java.util.Random;

class Vectors {
    private float x, y, z, w;

    public Vectors(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }
    public Vectors() {
        this(0, 0, 0, 0);
    }
    public Vectors addVec(Vectors v) {
        Vectors tmp;
        tmp = new Vectors(x + v.x, y + v.y, z + v.z, w + v.w);
        return tmp;
    }
    public Vectors subVec(Vectors v) {
        Vectors tmp;
        tmp = new Vectors(x - v.x, y - v.y, z - v.z, w - v.w);
        return tmp;
    }
    public Vectors scaleVec(float scale) {
        Vectors tmp;
        tmp = new Vectors(scale * x, scale * y, scale * z, scale * w);
        return tmp;
    }


    class Matrix  {
        private float matArr[][];
        private float scale[];
        private Vectors v[];
        private int row;
        private int col;
        private Random rand;

        private float resX, resY, resZ;

    public Matrix(int rows, int cols, int arr[][]) {
        row = rows;
        col = cols;

        rand = new Random();

        matArr = new float[row][col];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < col; j++) {
                matArr[i][j] = arr[i][j];
            }

            v[i] = new Vectors(matArr[i][0], matArr[i][1], matArr[i][2], matArr[i][3]);
        }

    }
    public void gaussElimination() {
        float subElem;
        Vectors tmp;

        scale[0] = matArr[0][0];

        v[0] = v[0].scaleVec(1 / scale[0]);
        System.out.println(v[0]);

        subElem = matArr[1][0];
        v[1] = v[1].subVec(v[0].scaleVec(subElem));
        System.out.println(v[1]);

        subElem = matArr[2][0];
        v[2] = v[2].subVec(v[0].scaleVec(subElem));
        System.out.println(v[2]);

        scale[1] = v[1].getY();

        v[1] = v[1].scaleVec(1 / scale[1]);
        System.out.println(v[1]);

        subElem = v[2].getY();
        v[2] = v[2].subVec(v[1].scaleVec(subElem));
        System.out.println(v[2]);

        resZ = v[2].getW() / v[2].getZ();
        resY = v[1].getW() - v[1].getZ() * resZ;
        resX = v[0].getW() - v[0].getZ() * resZ - v[0].getY() * resY;
    }
    public String toString() {
        return "x = " + resX + ", y = " + resY + ", z = " + resZ;
    }
}
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public float getZ() {
        return z;
    }
    public float getW() {
        return w;
    }
    public String toString() {
        return "x = " + x + ", y = " + y + ", z = " + z + ", w = " + w;
    }
}





public class Matrix {

}
