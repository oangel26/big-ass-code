import java.io.BufferedReader;
import java.io.InputStreamReader;

class MyConnectFour {

  private BufferedReader input;
  private char[][] board;

  final String SLOT = "|   ";
  final char EMPTY_SLOT = '\u0000';

  public MyConnectFour() {
    board = new char[6][7];
    System.out.println("se inicializa el board");
    input = new BufferedReader(new InputStreamReader(System.in));
    System.out.println();
    playGame();
  }

  private void playGame() {
    System.out.println("Welcome to Connect 4");
    System.out.println("There are 2 players red and yellow");
    System.out.println("Player 1 is Red, Player 2 is Yellow");
    System.out.println("To play the game type in the number of the column you want to drop you counter in");
    System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
    System.out.println("");
    printBoard();
    boolean win = false;
    while (!win) {
      // player 1
      String userInput = getUserInput();
      int move = Integer.parseInt(userInput);
      placeCounter('r', move);
      boolean hasWon = false;
      int count = 0;
      // check horizontal
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
          if (board[i][j] == 'r') {
            count = count + 1;
            if (count > 4) {
              hasWon = true;
            }
          } else {
            count = 0;
          }
        }

      }
      // check vertical
      count = 0;
      for (int i = 0; i < board[0].length; i++) {
        for (int j = 0; j < board.length; j++) {
          if (board[j][i] == 'r') {
            count = count + 1;
            if (count > 4) {
              hasWon = true;
            }
          } else {
            count = 0;
          }
        }

      }
      printBoard();
      if (hasWon) {
        win = true;
      } else {
        // player 2
        userInput = getUserInput();
        move = Integer.parseInt(userInput);
        placeCounter('y', move - 1);
        hasWon = false;
        count = 0;
        // check horizontal
        for (int i = 0; i < board.length; i++) {
          for (int j = 0; j < board[i].length; j++) {
            if (board[i][j] == 'y') {
              count = count + 1;
              if (count >= 4) {
                hasWon = true;
              }
            } else {

            }
          }
          count = 0;
        }
        // check vertical
        count = 0;
        for (int i = 0; i < board[0].length; i++) {
          for (int j = 0; j < board.length; j++) {
            if (board[j][i] == 'y') {
              count = count + 1;
              if (count >= 4) {
                hasWon = true;
              }
            } else {

            }
          }
          count = 0;
        }
        printBoard();
        if (hasWon) {
          win = true;
        }
      }
      System.out.println("You Have Won!!!");
    }

  }

  private String getUserInput() {
    String toReturn = null;
    try {
      toReturn = input.readLine();
    } catch (Exception e) {

    }
    return toReturn;
  }

  private void printBoard() {
    for (int i = 0; i < board.length - 1; i++) {
      for (int j = 0; j < board[i].length - 1; j++) {
        if (board[i][j] == 'r') {
          System.out.print("| r ");
        } else if (board[i][j] == 'y') {
          System.out.print("| y ");
        } else {
          System.out.print(SLOT);
        }
      }
      System.out.println(SLOT);
    }
    System.out.println("  1   2   3   4   5   6   7");
  }

  private boolean placeCounter(char player, int position) {
    boolean placed = false;
    for (int i = board.length - 1; i >= 0; i--) {
        if (board[i][position] == EMPTY_SLOT) {
            board[i][position] = player;
            placed = true;
            break;
        }
    }
    return placed;
  }
}
