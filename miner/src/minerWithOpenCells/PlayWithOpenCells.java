package minerWithOpenCells;

import java.util.Scanner;

public class PlayWithOpenCells {

	public static void main(String[] args) {
		short side = 10;
		System.out.println("Welcome to my game, is miner(yeeahh)");
		System.out.println("select level\neasy(4x4)   medium(10x10)   hard(20X20)");
		System.out.println("your choice: ");
		Scanner scanLvl = new Scanner(System.in);
		String lvl = scanLvl.nextLine();
		scanLvl.close();
		if (lvl.equals("easy")) {
			System.out.println(88);
			side = 8;
		} else {
			if (lvl.equals("medium")) {
				System.out.println(1616);
				side = 16;
			} else {
				if (lvl.equals("hard")) {
					System.out.println(2424);
					side = 24;
				} else
					System.out.println("uncorrect data");

			}
		}

//----------------------------------
		int numMine = (int) (side * side * 0.17);// получаю кол-во мин на поле со стороной side
		cell[][] field = new cell[side][side];

		for (int i = 0; i < side; i++) {
			for (int j = 0; j < side; j++) {
				cell tempCell = new cell("00", cellType.notMine);

				field[i][j] = tempCell;

			}
		}

		for (int i = 0; i < side; i++) {
			for (int j = 0; j < side; j++) {

				field[i][j].link = String.valueOf(i) + String.valueOf(j);

			}
		}

		for (int i = 0; i < side; i++) {
			for (int j = 0; j < side; j++) {
				if (numMine > 0) {

					int rnd = 0 + (int) (Math.random() * 99);
					if (rnd < 18) {

						field[i][j].content = cellType.mine;
						numMine--;
					}

				}
			}
		}
		// ------------------------------------

		// manual "how to play"
		System.out.println("for comfort use ctrl+m on console");

		char[] alfabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
				's', 't', 'u', 'v', 'w', 'x' };
		System.out.print(" ");
		for (int i = 0; i < side; i++) {
			System.out.print(" | " + i);

		}
		System.out.print(" |");

		for (int i = 0; i < side; i++) {
			System.out.print("\n" + alfabet[i] + "  ");
			for (int j = 0; j < side; j++) {
				System.out.print("" + field[i][j]);
			}
		}

		// * - iThinkItsMine, x - mine, [ ] - unused cell, [ - ](1,2,3,4,5,6,7,8) -
		// numMineAround
	}

}
