import java.util.Random;
import java.util.Scanner;

public class Vieropeenrij {
    public static boolean gameRuns = true;

    public static void main(String[] args) {
        Player playerRed = new Player('R');
        Player playerYellow = new Player('G');


        byte b = (byte) 320;
        System.out.println(b);


        Random random = new Random();
        int turnInt  = random.nextInt(2);
        if(turnInt == 0){
            Player.turn = 'R';
        }else if(turnInt == 1){
            Player.turn = 'G';
        }

        Scanner scanner = new Scanner(System.in);

        GameBoard.loadBoard();
        while(gameRuns){

            if(Player.turn == 'R'){
                System.out.println("Speler ROOD: geef aan in welke kolom je je steen wilt gooien.");
                char column = scanner.next().charAt(0);
                Player.insertCoin(column, 'R');
                Player.turn = 'G';
            }else if(Player.turn == 'G'){
                System.out.println("Speler GEEL: geef aan in welke kolom je je steen wilt gooien.");
                char column = scanner.next().charAt(0);
                Player.insertCoin(column, 'G');
                Player.turn = 'R';
            }
        }
    }
}

