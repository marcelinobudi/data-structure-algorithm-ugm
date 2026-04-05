import java.util.Arrays;

class Matrix{
    private int[][] arr;
    public int rowLength, columnLength;

    public Matrix(int[][] arr){
        this.arr = arr;
        this.rowLength = arr.length;
        this.columnLength = arr[0].length;
    }

    public int get(int rowIndex, int columnIndex){
        // error index out of bounds dihandling langsung oleh array!
        return arr[rowIndex][columnIndex];
    }

    public void print(){
        System.out.println("[");
        for(int i = 0; i < rowLength; i++){
            System.out.print("[");
            for(int j = 0; j < columnLength; j++){
                System.out.print(arr[i][j]);
                if(j < columnLength-1) System.out.print(", ");
            }
            System.out.println("],");
        }
        System.out.println("]");
    }

    public int[] search(int element){
        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < columnLength; j++){
                if(arr[i][j] == element){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1,-1};
    }

}

public class MatrixImpl {
    public static void main(String[] args) {
        Matrix A = new Matrix(new int[][]{ {1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15} });
        System.out.println(Arrays.toString(A.search(5)));
    }
}
