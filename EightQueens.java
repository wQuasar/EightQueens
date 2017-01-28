/**
 * Created by: shaishav on 1/27/17.
 * A recursive solution to the Eight Queens Problem.
 */


public class EightQueens
{

    // Chess board declaration. Init all positions to 0.
    private static boolean[][] chessBoard = new boolean[8][8];

    // Keeping the count of the solutions
    private static int count;

    // Self start
    public static void main(String[] args)
    {
        setQueen(0);
    }


    // Set the queen and do the main grunt work of recursively moving over the entire board
    private static void setQueen(int row)
    {
        // GENERAL CASE
        if (row < 8)
        {
            for (int i = 0; i < 8; i++)
            {
                if (isSafe(row, i))
                {
                    // Placing the queen here, since its safe (for now)
                    chessBoard[row][i] = true;
                    setQueen(row + 1);

                    // When we reach here, the board should already be in need of reinitialization (either a success
                    // or a failure. In either case we don't need the queen at that position)
                    chessBoard[row][i] = false;
                }
            }
        }
        // END CASE
        // Printing the board because if the row provided is more than 7 that means we have 8 queens on the board already
        else
        {
            printBoard();
        }
    }


    // Prints the chess board and increases the count each time (for valid arrangements only)
    private static void printBoard()
    {
        System.out.print("\n\nSolution " + ++count + ":\n\n");

        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                System.out.print((chessBoard[i][j] ? "Q" : "-") + " ");
            }
            System.out.print("\n");
        }
    }


    // Return if a queen placed @(i, j) is safe
    private static boolean isSafe(int i, int j)
    {
        int m, n;

        m = i;
        n = j - 1;
        // top vertical clash check. m constant, n reducing
        while (n > -1)
        {
            if (chessBoard[m][n--])
                return false;
        }

        m = i;
        n = j + 1;
        // bottom vertical clash check. m constant, n increasing
        while (n < 8)
        {
            if (chessBoard[m][n++])
                return false;
        }

        m = i + 1;
        n = j;
        // right horizontal clash check. m increasing, n constant
        while (m < 8)
        {
            if (chessBoard[m++][n])
                return false;
        }

        m = i - 1;
        n = j;
        // right horizontal clash check. m increasing, n constant
        while (m > -1)
        {
            if (chessBoard[m--][n])
                return false;
        }

        m = i + 1;
        n = j + 1;
        // right bottom clash check. m increasing, n increasing
        while (m < 8 && n < 8)
        {
            if (chessBoard[m++][n++])
                return false;
        }

        m = i + 1;
        n = j - 1;
        // right top clash check. m increasing, n decreasing
        while (m < 8 && n > -1)
        {
            if (chessBoard[m++][n--])
                return false;
        }

        m = i - 1;
        n = j + 1;
        // left bottom clash check. m decreasing, n increasing
        while (m > -1 && n < 8)
        {
            if (chessBoard[m--][n++])
                return false;
        }

        m = i - 1;
        n = j - 1;
        // left top clash check. m decreasing, n decreasing
        while (m > -1 && n > -1)
        {
            if (chessBoard[m--][n--])
                return false;
        }

        return true;
    }

}