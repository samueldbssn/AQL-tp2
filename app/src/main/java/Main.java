package model;

public class Main {

    public static void main(String[] args) {
        // Create a new game board
        Board board = new Board();
        
        // Simulate a simple Tic-Tac-Toe game
        System.out.println("Starting a new game...");
        
        // X plays at position (0, 0)
        board.mark(0, 0);
        System.out.println("X marked at (0, 0)");
        
        // O plays at position (0, 1)
        board.mark(0, 1);
        System.out.println("O marked at (0, 1)");
        
        // X plays at position (1, 1)
        board.mark(1, 1);
        System.out.println("X marked at (1, 1)");
        
        // O plays at position (1, 0)
        board.mark(1, 0);
        System.out.println("O marked at (1, 0)");
        
        // X plays at position (2, 2) - potential winning move
        board.mark(2, 2);
        System.out.println("X marked at (2, 2)");
        
        System.out.println("Game demonstration complete!");
    }
}
