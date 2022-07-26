package dsaassisstedprojects;

public class matrixmultiplication {
	public static int[][] matrixmultiply(int[][] matrixone, int[][] matrixtwo, int r1, int a1, int a2) 
	{
	                int[][] product = new int[r1][a2];
	                for(int i = 0; i < r1; i++) 
	                {
	                        for (int j = 0; j < a2; j++) 
	                        {
	                            for (int k = 0; k < a1; k++) 
	                            {
	                                    product[i][j] += matrixone[i][k] * matrixtwo[k][j];
	                            }
	                        }
	                }
	                return product;
    }
	public static void displayresult(int[][] product) 
	{
	                System.out.println("Product of two matrices is: ");
	                for(int[] row : product) 
	                {
	                        for (int column : row) 
	                        {
	                            System.out.print(column + "    ");
	                        }
	                        System.out.println();
	                }
    }
	public static void main(String[] args) 
	{
	            int r1 = 2, a1 = 3;
	                int r2 = 3, a2 = 2;
	                int[][] matrixone = { {4, -5, -8}, {7, 3, -2} };
	                int[][] matrixtwo = { {3,2}, {-9, 8}, {7, -4} };
	int[][] product = matrixmultiply(matrixone, matrixtwo, r1, a1, a2);
	displayresult(product);
	        }

	
}
