import java.util.Scanner;
public class BattleShip {
	public static void print_the_map(String[][] player) {
			StringBuilder ans = new StringBuilder();
			for (int y = 0; y < player[0].length; y++) {
				ans.append("[");
				for (int x = 0; x < player.length; x++) {
					ans.append(player[y][x]).append(",");
				}
				ans.append("]").append("\n");
			}
			System.out.println(ans);
		}

	public static boolean is_valid_starting_board(String[][] player) {
			String[] ship = new String[4];
			ship[0] = "2";
			ship[1] = "3";
			ship[2] = "4";
			ship[3] = "5";
			if (check_map(player,ship[0])==2){
				return true;
			}
			if (check_map(player,ship[1])==3){
				return true;
			}
			if (check_map(player,ship[2])==4){
				return true;
			}
			if (check_map(player,ship[3])==5){
				return true;
			}
			return check_map(player, "_") == 100;
		}
		
	public static  int check_map(String[][] player,String number){
			int of_number=0;
			for (int y = 0; y < 10; y++) {
				for (int x = 0; x < 10; x++) {
					if (player[y][x].equals(number)){
						of_number++;
					}
				}
			}
			return of_number;
		}
	
	
	public static String shoot(String[][] player, int x, int y) {
		if (!player[x][y].equals("_")) {
			String[] attend = new String[4];
			attend[0] = "2";
			attend[1] = "3";
			attend[2] = "4";
			attend[3] = "5";
			for (String i : attend) {
				if (player[x][y].equals(i)) {
					System.out.println("Hit the enemy's ship");
					player[x][y] = i + "H";
					run_sunk(player);
					return player[x][y];
				}
				if (player[x][y].equals(i + "H")) {
					System.out.println("Hit the enemy's ship, you was hit before");
					return player[x][y];
				}
			}
			return player[x][y];
		} else {
			return player[x][y] = "MISS";
		}
	}
	
	public static void run_sunk(String[][] player) {
			String[] attend = new String[4];
			attend[0] = "2";
			attend[1] = "3";
			attend[2] = "4";
			attend[3] = "5";
			for (String i : attend) {
				if (check_sunk(player, i)) {
					sunk(player, i);
				}
			}
		}
	
	public static boolean check_sunk(String[][] player, String ship) {
			int i = Integer.parseInt(ship);
			int number_of_ship = 0;
			for (int y = 0; y < 10; y++) {
				for (int x = 0; x < 10; x++) {
					if (player[y][x].equals(ship+"H")) {
						number_of_ship++;
					}
				}
			}
			return number_of_ship == i;
		}
	
	public static void sunk(String[][] player, String number) {
			for (int y = 0; y < 10; y++) {
				for (int x = 0; x < 10; x++) {
					if (player[y][x].equals(number + "H")) {
						player[y][x] = number + "Sunk";
					}
					
				}
			}
		}
	public static boolean can_place_ship_at(String[][] locate, char direction, int line, int x, int y) {
				if (direction == 'h') {
					for (int i = x - 1; i < y + 1; i++) {
						if (!locate[line][i].equals("_")) {
							return false;
						}
					}
					return true;
				}
				if (direction == 'v') {
					for (int i = x; i < y + 1; i++) {
						if (!locate[i][line].equals("_")) {
							return false;
						}
					}
					return true;
				}
				return false;
			}
	
	public static void check_can_place(String[][] player) {
			Scanner myscan = new Scanner(System.in);
			System.out.println("please show me the direction of you want to put v or h");
			char direction = myscan.next().charAt(0);
			System.out.println("which column/row do you want to put ");
			int line = myscan.nextInt();
			System.out.println("please show me the start point of the line of you want to put");
			int check_can_start = myscan.nextInt();
			System.out.println("please show me the end point of the line of you want to put");
			int check_can_end = myscan.nextInt();
			if (can_place_ship_at(player, direction, line, check_can_start, check_can_end)) {
				System.out.println("you can put your ship in your map and the direction with " +
						direction + " in line " + line +
						" begin at " + check_can_start + " end with " + check_can_end);
				print_the_map(player);
			} else {
				System.out.println("Sorry your check point can not put the ship");
				check_not_place(player);
			}
		}
	
	public static void check_not_place(String[][] player) {
			Scanner myscan = new Scanner(System.in);
			System.out.println("do you want to check another point yes/no");
			String choice = myscan.next();
			
			if (choice.equals("yes")) {
				check_can_place(player);
			}
			if (choice.equals("no")) {
				System.out.println("let shooting the ships");
			} else {
				check_not_place(player);
			}
		}
}
	