import java.util.*;

public class Tic_Tac_Toe {

    static String[] board;
    static int turn = 0;
    static String start = "X";

    static void printBoard ()
    {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|---|---|---|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|---|---|---|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("|---|---|---|");
    }

    static String checkWinningLines ()
    {
        for (int a = 0; a < 8; a++)
        {
            String line = null;

            switch (a)
            {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }

            if (line.equals("XXX"))
            {
                return "X";
            }
            else if (line.equals("OOO"))
            {
                return "O";
            }
        }

        if (turn == 9)
        {
            return "draw";
        }

        return null;
    }

    static boolean checkInput (int oneToNine)
    {
        if (oneToNine < 1 || oneToNine > 9)
        {
            System.out.println("Invalid input; re-enter slot number:");
            return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        board = new String[9];
        for (int a = 0; a < 9; a++)
        {
            board[a] = String.valueOf(a + 1);
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to 3x3 Tic Tac Toe.");
        printBoard();
        System.out.println("X will play first. Enter a slot number to place X in: ");

        for (; turn < 9;)
        {
            int numInput;
            try
            {
                numInput = scanner.nextInt();
                if (!checkInput(numInput))
                {
                    continue;
                }

                if (board[numInput - 1].equals(String.valueOf(numInput)))
                {
                    board[numInput - 1] = start;
                }
                else
                {
                    System.out.println("Slot already taken; re-enter slot number:");
                    continue;
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println(e.getMessage());
                scanner.nextLine();
                turn--;
                if (start.equals("X"))
                {
                    start = "O";
                }
                else
                {
                    start = "X";
                }
            }

            printBoard();
            if (turn <= 8)
            {
                if (start.equals("X"))
                {
                    start = "O";
                }
                else
                {
                    start = "X";
                }

                if (checkWinningLines() == null && turn < 8)
                {
                    System.out.println(start + "'s turn; enter a slot number to place " + start + " in:");
                }
            }
            turn++;

            if (turn >= 5) {
                if (!(checkWinningLines() == null))
                {
                    if (checkWinningLines().equals("X"))
                    {
                        System.out.println("Congratulations! X's have won! Thanks for playing.");
                    }
                    else if (checkWinningLines().equals("O"))
                    {
                        System.out.println("Congratulations! O's have won! Thanks for playing.");
                    }
                    else if (checkWinningLines().equals("draw"))
                    {
                        System.out.println("It's a draw! Thanks for playing.");
                    }
                    break;
                }
            }
        }
    }
}
