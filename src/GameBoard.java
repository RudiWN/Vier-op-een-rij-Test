public class GameBoard {
    private static char[][] cellArrays = {{'a', ' ', ' ', ' ', ' ', ' ', ' ', '-'},
            {'b', ' ', ' ', ' ', ' ', ' ', ' ', '-'},
            {'c', ' ', ' ', ' ', ' ', ' ', ' ', '-'},
            {'d', ' ', ' ', ' ', ' ', ' ', ' ', '-'},
            {'e', ' ', ' ', ' ', ' ', ' ', ' ', '-'},
            {'f', ' ', ' ', ' ', ' ', ' ', ' ', '-'},
            {'g', ' ', ' ', ' ', ' ', ' ', ' ', '-'},
            {' ', '6', '5', '4', '3', '2', '1', ' '}};

    public static void loadBoard() {
        for (int i = 0; i < cellArrays[0].length; i++) {
            System.out.println();
            for (int j = 0; j < cellArrays.length; j++) {
                if (i == 0) {
                    System.out.print(" " + cellArrays[j][i]);
                } else if (i < 7) {
                    if (j < 7) {
                        System.out.print("|" + cellArrays[j][i]);
                    } else {
                        System.out.print("| " + cellArrays[j][i]);
                    }
                } else {
                    System.out.print(" " + cellArrays[j][i]);
                }
            }
        }
        System.out.println();
    }

    public static char[] getArray(int i) {
        return cellArrays[i];
    }

    public static void setArray(int array, int index, char colour) {
        cellArrays[array][index] = colour;
    }

    public static void gameState() {
        int coinCounter;
        char playerCoin;

        //Vertical check
        for (int i = 0; i < cellArrays.length - 1; i++) {
            coinCounter = 0;
            playerCoin = ' ';

            for (int j = 6; j > 0; j--) {
                if (cellArrays[i][j] != ' ') {
                    if (j == 6) {
                        playerCoin = cellArrays[i][j];
                        coinCounter++;
                    } else {
                        if (cellArrays[i][j] == playerCoin) {
                            //if same, don't change playerCoin, increase counter
                            coinCounter++;

                            if(coinCounter == 4){
                                break;
                            }
                        } else {
                            //if not same, change playerCoin. reset counter to 1
                            playerCoin = cellArrays[i][j];
                            coinCounter = 1;
                        }
                    }
                }
            }
            if(coinCounter == 4){
                String winner = (playerCoin == 'R') ? "Speler ROOD" : "Speler GEEL";
                System.out.println(winner + " heeft gewonnen!");
                Vieropeenrij.gameRuns = false;
                break;
            }
        }

        //Horizontal Check
        for (int h = 6; h > 0; h--) {
            coinCounter = 0;
            playerCoin = ' ';
            for (int a = 0; a < cellArrays.length - 1; a++) {
                if (cellArrays[a][h] != ' ') {
                    if (a == 0) {
                        playerCoin = cellArrays[a][h];
                        coinCounter++;
                    } else {
                        if (cellArrays[a][h] == playerCoin) {
                            coinCounter++;

                            if (coinCounter == 4) {
                                break;
                            }
                        } else {
                            playerCoin = cellArrays[a][h];
                            coinCounter = 1;
                        }
                    }
                }
            }
            if(coinCounter == 4) {
                String winner = (playerCoin == 'R') ? "Speler ROOD" : "Speler GEEL";
                System.out.println(winner + " heeft gewonnen!");
                Vieropeenrij.gameRuns = false;
                break;
            }
        }

        //Diagonal Check
        COLUMN:
        for(int d = 0; d < cellArrays.length - 1; d++){
            coinCounter = 0;
            playerCoin = ' ';

            ROW:
            for(int e = 6; e > 0; e--){
                if(cellArrays[d][e] != ' '){
                    if(e - 3 > 0){
                        playerCoin = cellArrays[d][e];
                        coinCounter++;
                        System.out.println("Column: " + d + " Row: " + e + " player: " + playerCoin + " counter: " + coinCounter) ;

                        int di = e;
                        for(int c = 1; c < 4; c++){
                            if(cellArrays[c][di - 1] != ' ' && cellArrays[c][di - 1] == playerCoin){
                                coinCounter++;
                                System.out.println("Increasing coinCounter: " + coinCounter);
                                System.out.println("Increase triggered by c: " + c + " r: " + (di - 1));
                                di--;
                            }else{
                                coinCounter = 0;
                            }
                        }
                    }
                }
            }

            if(coinCounter == 4) {
                String winner = (playerCoin == 'R') ? "Speler ROOD" : "Speler GEEL";
                System.out.println(winner + " heeft gewonnen!");
                Vieropeenrij.gameRuns = false;
                break;
            }
        }
    }
}



