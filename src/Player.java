public class Player {
    private char colour;
    public static char turn;

    Player(char colour){
        this.colour = colour;
    }

    //checking the arrays for R or Gs
    public static int checkColumn(char[] column){

        if(column == null){
            return -1;
        }

        int i = 1;
        while(i < column.length - 1){
            if(column[i] == 'G' || column[i] == 'R'){
                return i - 1;
            }else i++;
        }
        return 6;
    }

    public char getColour(){
        return colour;
    }

    //functionality for inserting coins into the grid
    public static void insertCoin(char column, char player){ //char player = 'R' of 'G'. de kleur van een speler
        int index;

        switch(column){
            case 'a':
                index = checkColumn(GameBoard.getArray(0));
                if(index == 0){
                    System.out.println("Kolom is vol, kies een ander kolom.");
                }else{
                    GameBoard.setArray(0, index, player);
                }
                break;
            case 'b':
                index = checkColumn(GameBoard.getArray(1));
                if(index == 0){
                    System.out.println("Kolom is vol, kies een ander kolom.");
                }else{
                    GameBoard.setArray(1, index, player);
                }
                break;
            case 'c':
                index = checkColumn(GameBoard.getArray(2));
                if(index == 0){
                    System.out.println("Kolom is vol, kies een ander kolom.");
                }else{
                    GameBoard.setArray(2, index, player);
                }
                break;
            case 'd':
                index = checkColumn(GameBoard.getArray(3));
                if(index == 0){
                    System.out.println("Kolom is vol, kies een ander kolom.");
                }else{
                    GameBoard.setArray(3, index, player);
                }
                break;
            case 'e':
                index = checkColumn(GameBoard.getArray(4));
                if(index == 0){
                    System.out.println("Kolom is vol, kies een ander kolom.");
                }else{
                    GameBoard.setArray(4, index, player);
                }
                break;
            case 'f':
                index = checkColumn(GameBoard.getArray(5));
                if(index == 0){
                    System.out.println("Kolom is vol, kies een ander kolom.");
                }else{
                    GameBoard.setArray(5, index, player);
                }
                break;
            case 'g':
                index = checkColumn(GameBoard.getArray(6));
                if(index == 0){
                    System.out.println("Kolom is vol, kies een ander kolom.");
                }else{
                    GameBoard.setArray(6, index, player);
                }
                break;
            default :
        }

        GameBoard.loadBoard();
        GameBoard.gameState();
    }
}
