package miner;

import java.util.Scanner;

public class Play {

	public static void main(String[] args) {
		boolean gameOver = false;
		short side = 10;

		System.out.println("Welcome to my game, is miner(yeeahh)");
		System.out.println("select level\neasy(8x8)   medium(16x16)   hard(24X24)");
		System.out.println("your choice: ");
		Scanner scan = new Scanner(System.in);
		String lvl = scan.nextLine();

		if (lvl.equals("easy")) {
			side = 8;
		} else {
			if (lvl.equals("medium")) {
				side = 16;
			} else {
				if (lvl.equals("hard")) {
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
		for (int m = 0; m < numMine; m++) {
			for (int i = 0; i < side; i++) {
				for (int j = 0; j < side; j++) {
					if (numMine > 0) {

						int rnd = 0 + (int) (Math.random() * 99);

						if (rnd < 5 && field[i][j].content != cellType.mine) {

							field[i][j].content = cellType.mine;
							numMine--;
						}

					}
				}
			}
		}
		// how much mine around?

		for (int i = 0; i < side; i++) {
			for (int j = 0; j < side; j++) {
				if (field[i][j].content != cellType.mine) {
					for (int k = i - 1; k < i + 2; k++) {
						for (int l = j - 1; l < j + 2; l++) {
							if (k > -1 & l > -1 & k < side & l < side) {

								if (field[k][l].content == cellType.mine) {
									field[i][j].howMuchMineAround++;
								}
							}
						}

					}
				}
			}
		}

		// print top line
		char[] alfabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
				's', 't', 'u', 'v', 'w', 'x' };
		System.out.print("▚|");
		for (int i = 0; i < side; i++) {
			if (i < 10) {
				System.out.print("  " + i);

			} else {

				System.out.print(" " + i);

			}
			System.out.print(" |");
		}
		// print other

		for (int i = 0; i < side; i++) {
			System.out.print("\n" + alfabet[i]);
			for (int j = 0; j < side; j++) {
				System.out.print("  " + field[i][j]);
			}
			System.out.println();
		}

		// manual "how to play"
		System.out.println("\n   |for comfort use ctrl+m on console|\n");
		System.out.println("select and write cell's link for open action menu with her");

		// select player's choose
		System.out.println("your choice: ");

		String choiceCellLinkString = scan.nextLine();
		String frstLink = "error)";
		String otherLink = "error)";
		int choiceSecndLink = 0;

		if (choiceCellLinkString.matches("\\w{1}" + "\\d{1}") || choiceCellLinkString.matches("\\w{1}" + "\\d{2}")) {
//преобразуем строку в ссылки
			String[] stringArrLink = choiceCellLinkString.split("");
			String wLinkString = stringArrLink[0];
			char cLink = wLinkString.charAt(0);
			for (int i = 0; i < alfabet.length; i++) {
				if (cLink == alfabet[i]) {
					frstLink = Integer.toString(i);
				}
			}

			int choiceFrstlink = Integer.parseInt(frstLink);
			for (int i = 1; i < stringArrLink.length; i++) {

				choiceSecndLink += Integer.parseInt(stringArrLink[i]);
				otherLink = frstLink + choiceSecndLink;
				choiceCellLinkString = frstLink + otherLink;
			}
//выбор операции с клеткой
			System.out.println("\"o\" - open cell, \"m\"-mine mark cell, \"?\" - not decided");
			String choiceOperation = scan.nextLine();
			if (choiceOperation == "o" || choiceOperation == "m" || choiceOperation == "?") {
				System.out.println("sorry, idk this command");

			} else {
				field[choiceFrstlink][choiceSecndLink].used = true;

				// concrete operations

			}
			switch (choiceOperation) {
			case "o":
				System.out.println(choiceOperation);
				field[choiceFrstlink][choiceSecndLink].mark = field[choiceFrstlink][choiceSecndLink].content;
				if (field[choiceFrstlink][choiceSecndLink].content == cellType.mine) {
					gameOver = true;
				}
				break;
			case "m":
				System.out.println(choiceOperation);
				field[choiceFrstlink][choiceSecndLink].mark = cellType.mine;
				break;
			case "?":
				System.out.println(choiceOperation);
				field[choiceFrstlink][choiceSecndLink].mark = cellType.unknown;
				break;
			}

			scan.close();
		} else {
			System.out.println("uncorrect data, psl write like \"b2\"");
		}
		if (gameOver == true) {

			System.out.print(" ");
			for (int i = 0; i < side; i++) {
				System.out.print(" | " + i);

			}
			System.out.print(" |");
//просто выводит онли мины без отступов лол

//			for (int i = 0; i < side; i++) {
//				System.out.print("\n" + alfabet[i] + "  ");
//				for (int j = 0; j < side; j++) {
//					if (field[i][j].content == cellType.mine)
//						System.out.print("[▪]");
//				}
//			}

		} else {
			System.out.print(" ");
			for (int i = 0; i < side; i++) {
				System.out.print(" | " + i);

			}
			System.out.print(" |");

			for (int i = 0; i < side; i++) {
				System.out.print("\n" + alfabet[i]);
				for (int j = 0; j < side; j++) {
					System.out.print("  " + field[i][j]);
				}
				System.out.println();
			}

		}

		// if (gameOver == false){openNext();}else{end};

	}
}
