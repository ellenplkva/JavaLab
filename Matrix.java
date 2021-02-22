public class Matrix {
    private  ComplexNum[][] dataComplex;
    private int rows,cols;


   public Matrix(int rows, int cols,int[][] data) {
        this.rows = rows;
        this.cols = cols;

        dataComplex = new ComplexNum[rows][cols];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                dataComplex[i][j] = new ComplexNum();
            }
        }
    }

    public void set (int i,int j, ComplexNum anew){
        dataComplex[i][j]= anew;
    }


    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.dataComplex = new ComplexNum[rows][cols];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                dataComplex[i][j] = new ComplexNum();
            }
        }
    }

    public Matrix SumMat (Matrix anew){

        Matrix A = new Matrix(rows, cols);
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                A.dataComplex[i][j] = dataComplex[i][j].SumComplexNum(anew.dataComplex[i][j]);
            }
        }
        return A;
    }

    public Matrix SubMat(Matrix anew){
        Matrix A = new Matrix(rows, cols);
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                A.dataComplex[i][j] = dataComplex[i][j].SubComplexNum(anew.dataComplex[i][j]);
            }
        }
        return A;
    }

    public Matrix MultiMat(Matrix anew){
        if (cols != anew.rows) {
            System.out.println("Матрица должна быть квадратной!");
        }
        var newA = new Matrix(rows, anew.cols);

        for (int i = 0; i < this.rows; i++)
            for (int j = 0; j < anew.cols; j++)
                for (int k = 0; k < this.cols; k++)
                    newA.dataComplex[i][j] = newA.dataComplex[i][j].SumComplexNum(this.dataComplex[i][k].MultiComplexNum(anew.dataComplex[k][j]));

        return newA;
    }

    public Matrix MultiMat(ComplexNum anew) {
        Matrix A = new Matrix(rows, cols);
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                A.dataComplex[i][j].MultiComplexNum(anew);
            }
        }
        return A;
    }

    public Matrix transpMat() {
        if (cols != rows){
            System.out.println("Матрица должна быть квадратной!"); }

        Matrix newA = new Matrix(rows, cols);
        for (int i = 0; i < cols; i++)
            for (int j = 0; j < rows; j++)
                newA.dataComplex[j][i] = this.dataComplex[i][j];

        return newA;
    }

    public void print() {
        for(int i = 0; i < cols; ++i) {
            for(int j = 0; j < rows; ++j) {
                dataComplex[i][j].print();
                System.out.print(" ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

}
