import java.util.*;

public class Tic_Tac_Toe {

    static String[] board;
    static String turn;

    static

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String turn;
        String line;
        System.out.println("Welcome to 3x3 Tic Tac Toe.");
        String[] board = new String[9];
        for (int a = 0; a < 9; a++)
        {
            board[a] = String.valueOf(a + 1);
            if (a % 2 == 0) {
                turn = "X";
            } else {
                turn = "O";
            }
            System.out.println("|---|---|---|");
            System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
            System.out.println("|---|---|---|");
            System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
            System.out.println("|---|---|---|");
            System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
            System.out.println("|---|---|---|");
            System.out.println("X will play first. Enter a slot number to place X in: ");
            int numInput = scanner.nextInt();
            if (board[numInput - 1].equals(String.valueOf(numInput)))
            {
                board[numInput - 1] = turn;
            }
            else
            {
                System.out.println("Slot already taken; re-enter slot number:");
            }
            switch (a) {
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
                default:
                    turn = "draw";
            }
            if (line == "XXX");
            {

            }
        }
    }
}
