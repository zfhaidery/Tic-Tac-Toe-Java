

import java.util.Scanner;

public class TicTacToe {
    
    private static char[][] board ={{' ',' ',' '},{' ',' ',' '}, {' ',' ',' '}};
    
    private static Scanner scanner= new Scanner(System.in);
    
    private static void printBoard(){
        //System.out.println();
        System.out.println("    1    2    3");
        
        for(int row = 0; row <3; row++){
            System.out.print((row + 1)+ " ");
            
            for(int col=0;col <3; col++){
                System.out.print(" " + board[row][col] + " ");
                if(col<2){
                    System.out.print(" | ");   
                }
            }
            
            System.out.println();
            if(row <2 ){
                System.out.println("   ---+---+---  ");
            }
        }
        System.out.println();            
    }
    
    private static void makeMove(char player){
        int row,col;
        boolean validMove= false;
        while(!validMove){
            System.out.println("Player " + player + " give your move(row coloumn):");
        try {
            row=scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
            if (row >= 0 && row <3 && col >=0 && col<3){
                if(board[row][col] == ' '){
                    board[row][col] = player;
                    validMove = true;
                }else{
                    System.out.println("invalid move:this place is already taken by a player");
                }
            }else{
                System.out.println("invalid input:Row and column must be between 1 to 3");
            }
        }catch (Exception e){
                    System.out.println("only numbers are allowed(1-3)");
                    scanner.nextLine();
                 
                    }
        }
    }
    private static boolean hasWon(char player){
        for(int i=0; i<3;i++){
            if(board[i][0]==player && board[i][1]==player && board[i][2]==player){
                return true;
            }
        }
        for(int i=0;i<3;i++){
            if(board[0][i]==player && board[1][i]==player && board[2][i]==player){
                return true;
            }
        }
        
        if(board[0][0]==player && board[1][1]==player && board[2][2]==player)
            return true;
        if(board[0][2]==player && board[1][1]==player && board[2][0] == player)
            return true;
        return false;
    }
    
    private static boolean isBoardFull(){
       for(char[] row : board){
           for(char cell : row){
               if(cell == ' ')
                   return false;
           }
       }
        return true;
    }
    

public static void main(String[] args){
        System.out.println("=================================");
        System.out.println("   WELCOME TO TIC TAC TOE GAME   ");
        System.out.println("=================================");
        
        char currentPlayer = 'X';
        boolean gameRunning = true;
        
        printBoard();
        
        while(gameRunning){
            makeMove(currentPlayer);
            printBoard();
            
            if(hasWon(currentPlayer)){
                System.out.println("=================================");
                System.out.println("    PLAYER " + currentPlayer + " HAS WON THE GAME   ");
                System.out.println("=================================");
                gameRunning = false;
            }
            else if(isBoardFull()){
                 System.out.println("=================================");
                System.out.println("          IT'S A DRAW             ");
                System.out.println("=================================");
                gameRunning = false;   
            }
            else{
                currentPlayer=(currentPlayer == 'X')?'O' : 'X';
                System.out.println("Now it's " + currentPlayer + "'s turn" );
            }
        }
        scanner.close();
        System.out.println("\nGame over! Thanks for playing");
    }
    
}

