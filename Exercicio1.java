public class Exercicio1 {
    public static void main(String[] args) {
        int n = 4;
        int[][] matrix = new int[n][n];
        
        System.out.println("Matriz para o valor de N=" + n);
        if(!preencheMatriz(matrix, 0)){
            System.out.println("Não existe solução para este tamanho de matriz");
        }

        printMatrix(matrix);
        
    }
    public static boolean canPlace(int[][] matrix, int linha, int coluna)
    {
        int i=0, j =0;
        for (i = 0; i < coluna; i++)
            if (matrix[linha][i] == 1)
                return false;
        for (i = linha, j = coluna; i >= 0 && j >= 0; i--, j--)
            if (matrix[i][j] == 1)
                return false;
        for (i = linha, j = coluna; j >= 0 && i < matrix.length; i++, j--)
            if (matrix[i][j] == 1)
                return false;
  
        return true;
    }

    public static boolean preencheMatriz(int matrix[][], int col)
    {
        if (col >= matrix.length)
            return true;

        for (int i = 0; i < matrix.length; i++) {
            if (canPlace(matrix, i, col)) {
                matrix[i][col] = 1;
  
                if (preencheMatriz(matrix, col + 1) == true)
                    return true;
                matrix[i][col] = 0;
            }
        }
        return false;
    }
    public static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                
                System.out.print(" " + matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
