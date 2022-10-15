
import java.util.Arrays;
import java.util.Scanner;

public class ConnectFour {

	
	public static void main(String args[]) {
		int size = 7;
		int move;
		char[][] board = new char[size][size];
		char player = 'R';
		boolean game_over = false;
		
		Scanner myScanner = new Scanner(System.in);
		
		init_board(board);
		
		while(!game_over) {
			System.out.print("Please enter a move " + player + " Player:");
			move = myScanner.nextInt();
			make_move(board, player, move);
			print_board(board);
			if(row_contains_win(board, get_top_index(board, move), player)) {
				System.out.print("Congratulations " + player + " Player! You win!");
				game_over = true;
			}
			if(player == 'R') {
				player = 'B';
			}
			else {
				player = 'R';
			}
		}
		
		
		myScanner.close();
		
		/*
		print_board(board);
		make_move(board, 'B', 1);
		make_move(board, 'R', 1);
		make_move(board, 'B', 1);
		make_move(board, 'R', 1);
		print_board(board);*/
		
	}
	
	public static int get_top_index(char[][] board, int column) {
		for(int i = board.length - 1; i >= 0; i--) {
			if(board[i][column] == ' ') {
				return i+1;
			}
		}
		return 0;
	}
	
	public static boolean row_contains_win(char[][] board, int row, char player) {
		int streak = 0;
		for(int i = 0; i < board[0].length; i++) {
			if(board[row][i] == player) {
				streak++;
				if(streak == 4) {
					return true;
				}
			}
			else {
				streak = 0;
			}
		}
		return false;
	}
	
	public static void init_board(char[][] board) {
		int size = board.length;
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				board[i][j] = ' ';
			}
		}
	}
	
	
	public static void print_board(char[][] board) {
		String s = "";
		for(char[] row : board) {
			s += Arrays.toString(row) + "\n";
		}
		System.out.println(s);
	}
	
	public static void make_move(char[][] board, char player, int column) {
		board[get_top_index(board, column)-1][column] = player;
	}
	
	
	/*
	 * public static int get_top_index(char[][] board, int column) {
		for(int i = board.length - 1; i >= 0; i--) {
			if(board[i][column] == ' ') {
				return i+1;
			}
		}
		return -1;
	}
	
	public static boolean row_contains_win(char[][] board, int row, char player) {
		int streak = 0;
		for(int i = 0; i < board[row].length; i++) {
			if(board[row][i] == player) {
				streak++;
				if(streak == 4) {
					return true;
				}
			}
			else {
				streak = 0;
			}
		}
		return false;
	}
	
	public static void init_board(char[][] board) {
		int size = board.length;
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				board[i][j] = ' ';
			}
		}
	}
	
	
	public static void print_board(char[][] board) {
		String s = "";
		for(char[] row : board) {
			s += Arrays.toString(row) + "\n";
		}
		System.out.println(s);
	}
	
	public static void make_move(char[][] board, char player, int column) {
		for(int i = board.length - 1; i >= 0; i--) {
			if(board[i][column] == ' ') {
				board[i][column] = player;
				return;
			}
		}
	}
	 */
}
