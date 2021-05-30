import java.util.ArrayList;
import java.util.List;

public class Exercicio2 {
    static List<List<Integer> > result
    = new ArrayList<List<Integer> >();
    static List<List<Integer> > nRainhas(int n)
    {
        result.clear();
        int matrix[][] = new int[n][n];
        preencheMatriz(matrix, 0);
         
        return result;
    }
    public static void main(String[] args)
    {
        int n = 4; 
        List<List<Integer> > resultado = nRainhas(n);
        System.out.println("Todas as matrizes possíveis para N=" + n + "\n" + resultado);
    }
    static boolean canPlace(int matrix[][], int linha, int col)
    {
        int i, j;
        int N = matrix.length;
        for (i = 0; i < col; i++)
            if (matrix[linha][i] == 1)
                return false;
        for (i = linha, j = col; i >= 0 && j >= 0; i--, j--)
            if (matrix[i][j] == 1)
                return false;
 
        for (i = linha, j = col; j >= 0 && i < N; i++, j--)
            if (matrix[i][j] == 1)
                return false;
 
        return true;
    }
    static boolean  preencheMatriz(int matrix[][], int col)
    {
        int N = matrix.length;
        if (col == N) {
 
            List<Integer> v = new ArrayList<>();
 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (matrix[i][j] == 1)
                        v.add(j + 1);
                }
            }
            result.add(v);
            return true;
        }
        boolean res = false;
        for (int i = 0; i < N; i++) {

            if (canPlace(matrix, i, col)) {
 
                matrix[i][col] = 1;
                res = preencheMatriz(matrix, col + 1) || res;
                matrix[i][col] = 0;
            }
        }
        return res;
    }
}
