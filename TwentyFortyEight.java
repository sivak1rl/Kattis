import java.util.Scanner;

/**
 * Not completed
 * 
 * @author RSIVAK
 */
public class TwentyFortyEight
{

	public static void main(String[] args)
	{
		int[][] grid = new int[4][4];
		int move;
		try (Scanner sc = new Scanner(System.in))
		{
			for (int i = 0; i < 4; i++)
			{
				for (int j = 0; j < 4; j++)
				{
					grid[i][j] = sc.nextInt();
				}
			}
			move = sc.nextInt();
		}
		switch (move)
		{
		// left
			case 0:
				moveElementsLeft(grid);
				break;
			// up
			case 1:
				// turn 90
				rotateMatrix(4, grid);
				moveElementsLeft(grid);
				rotateMatrix(4, grid);
				rotateMatrix(4, grid);
				rotateMatrix(4, grid);
				break;
			// right
			case 2:
				// turn 180
				rotateMatrix(4, grid);
				rotateMatrix(4, grid);
				moveElementsLeft(grid);
				rotateMatrix(4, grid);
				rotateMatrix(4, grid);
				break;
			// down
			case 3:
				// turn 180
				rotateMatrix(4, grid);
				rotateMatrix(4, grid);
				rotateMatrix(4, grid);
				moveElementsLeft(grid);
				rotateMatrix(4, grid);
				break;
		}

		for (int[] arr : grid)
		{
			for (int i : arr)
			{
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	private static void moveElementsLeft(int[][] grid)
	{
		for (int i = 0; i < 4; i++)
		{
			if (grid[0][i] == 0)
			{
				int j;
				for (j = i + 1; j < 4; j++)
				{
					if (grid[0][j] != 0)
					{
						break;
					}
				}
				if (j < 4)
				{
					grid[0][i] = grid[0][j];
					grid[0][j] = 0;
					for (; j < 3; j++)
					{
						grid[0][j] = grid[0][j + 1];
					}
					grid[0][3] = 0;
				}
			}
			else
			{
				int j;
				boolean pair = false;
				for (j = i + 1; j < 4; j++)
				{
					if (grid[0][j] == grid[0][i])
					{
						pair = true;
						break;
					}
					else if (grid[0][j] != 0)
					{
						break;
					}
				}
				if (j < 4 && pair)
				{
					grid[0][i] *= 2;
					grid[0][j] = 0;
					for (; j < 3; j++)
					{
						grid[0][j] = grid[0][j + 1];
					}
					grid[0][3] = 0;
				}
			}
			if (grid[1][i] == 0)
			{
				int j;
				for (j = i + 1; j < 4; j++)
				{
					if (grid[1][j] != 0)
					{
						break;
					}
				}
				if (j < 4)
				{
					grid[1][i] = grid[1][j];
					grid[1][j] = 0;
					for (; j < 3; j++)
					{
						grid[1][j] = grid[1][j + 1];
					}
					grid[1][3] = 0;
				}
			}
			else
			{
				int j;
				boolean pair = false;
				for (j = i + 1; j < 4; j++)
				{
					if (grid[1][j] == grid[1][i])
					{
						pair = true;
						break;
					}
					else if (grid[1][j] != 0)
					{
						break;
					}
				}
				if (j < 4 && pair)
				{
					grid[1][i] *= 2;
					grid[1][j] = 0;
					for (; j < 3; j++)
					{
						grid[1][j] = grid[1][j + 1];
					}
					grid[1][3] = 0;
				}
			}
			if (grid[2][i] == 0)
			{
				int j;
				for (j = i + 1; j < 4; j++)
				{
					if (grid[2][j] != 0)
					{
						break;
					}
				}
				if (j < 4)
				{
					grid[2][i] = grid[2][j];
					grid[2][j] = 0;
					for (; j < 3; j++)
					{
						grid[2][j] = grid[2][j + 1];
					}
					grid[2][3] = 0;
				}
			}
			else
			{
				int j;
				boolean pair = false;
				for (j = i + 1; j < 4; j++)
				{
					if (grid[2][j] == grid[2][i])
					{
						pair = true;
						break;
					}
					else if (grid[2][j] != 0)
					{
						break;
					}
				}
				if (j < 4 && pair)
				{
					grid[2][i] *= 2;
					grid[2][j] = 0;
					for (; j < 3; j++)
					{
						grid[2][j] = grid[2][j + 1];
					}
					grid[2][3] = 0;
				}
			}
			if (grid[3][i] == 0)
			{
				int j;
				for (j = i + 1; j < 4; j++)
				{
					if (grid[3][j] != 0)
					{
						break;
					}
				}
				if (j < 4)
				{
					grid[3][i] = grid[3][j];
					grid[3][j] = 0;
					for (; j < 3; j++)
					{
						grid[3][j] = grid[3][j + 1];
					}
					grid[3][3] = 0;
				}
			}
			else
			{
				int j;
				boolean pair = false;
				for (j = i + 1; j < 4; j++)
				{
					if (grid[3][j] == grid[3][i])
					{
						pair = true;
						break;
					}
					else if (grid[3][j] != 0)
					{
						break;
					}
				}
				if (j < 4 && pair)
				{
					grid[3][i] *= 2;
					grid[3][j] = 0;
					for (; j < 3; j++)
					{
						grid[3][j] = grid[3][j + 1];
					}
					grid[3][3] = 0;
				}
			}
		}

	}

	static void rotateMatrix(int N, int mat[][])
	{
		// Consider all squares one by one
		for (int x = 0; x < N / 2; x++)
		{
			// Consider elements in group of 4 in
			// current square
			for (int y = x; y < N - x - 1; y++)
			{
				// store current cell in temp variable
				int temp = mat[x][y];

				// move values from right to top
				mat[x][y] = mat[y][N - 1 - x];

				// move values from bottom to right
				mat[y][N - 1 - x] = mat[N - 1 - x][N - 1 - y];

				// move values from left to bottom
				mat[N - 1 - x][N - 1 - y] = mat[N - 1 - y][x];

				// assign temp to left
				mat[N - 1 - y][x] = temp;
			}
		}
	}
}
