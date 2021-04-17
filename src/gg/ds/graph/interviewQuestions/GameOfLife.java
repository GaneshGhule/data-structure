package gg.ds.graph.interviewQuestions;

public class GameOfLife {

    private int[][] direction = new int[][]{
            {1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}
    };


    public void gameOfLife(int[][] board) {

        int liveCount;

        //Note : We can not update board directly so calculate next state and store with different value
        // next state live : 3
        // next state dead : 2
        // At the end update next state values

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {

                liveCount = getLiveCount(row, col, board);

                //next state : dead
                if (board[row][col] == 1 && (liveCount < 2 || liveCount > 3)) {
                    board[row][col] = 2;
                }

                // next state : live
                if (board[row][col] == 0 && liveCount == 3) {
                    board[row][col] = 3;
                }
            }
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] %= 2;
                System.out.print(board[row][col]+"  ");
            }
            System.out.println();
        }
    }

    private int getLiveCount(int row, int col, int[][] board) {

        int liveCount = 0;

        for (int[] d : direction) {

            int newRow = row + d[0];

            int newCol = col + d[1];

            if (newRow < 0 || newRow == board.length) {
                continue;
            }

            if (newCol < 0 || newCol == board[0].length) {
                continue;
            }

            if (board[newRow][newCol] == 1 || board[newRow][newCol] == 2) {
                liveCount++;
            }
        }

        return liveCount;
    }

    public static void main(String[] args) {
        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.gameOfLife(
                new int[][]{
                        {0, 1, 0},
                        {0, 0, 1},
                        {1, 1, 1},
                        {0, 0, 0}
                }
        );

        // expected output
        //  [0,0,0],
        //  [1,0,1],
        //  [0,1,1],
        //  [0,1,0]
    }
}
