package miner;

public class cell {
	String link = new String();
	cellType content;
	int howMuchMineAround;
	boolean used = false;
	cellType mark;

	public cell(String link, cellType content) {
		super();
		this.link = link;
		this.content = content;
		

	}

	char[] alfabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
			't', 'u', 'v', 'w', 'x' };

	public void uLose(int side, cell field[][]) {

		System.out.print(" ");
		for (int i = 0; i < side; i++) {
			System.out.print(" | " + i);

		}
		System.out.print(" |");

		for (int i = 0; i < side; i++) {
			System.out.print("\n" + alfabet[i] + "  ");
			for (int j = 0; j < side; j++) {
				if (field[i][j].content == cellType.mine)
					System.out.print("[▪]");
			}
		}

	}

//	public static String openCell(cell cell) {
//		char[] alfabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
//				's', 't', 'u', 'v', 'w', 'x' };
//
//		String[] stringLink = cell.link.split("");
//		int firstNum = Integer.parseInt(stringLink[0]);
//		stringLink[0] = Character.toString(alfabet[firstNum]);
//		cell.link = stringLink[0] + stringLink[1];
//
//		if (cell.content == cellType.mine) {
//			return "u lose(";
//		} else {
//			{
//
//				return "[" + cell.howMuchMineAround + "]";
//			}
//		}
//
//	}

	@Override
	public String toString() {

		String[] stringLink = this.link.split("");
		int firstNum = Integer.parseInt(stringLink[0]);
		stringLink[0] = Character.toString(alfabet[firstNum]);
		this.link = stringLink[0] + stringLink[1];

		if (this.content == cellType.mine) {
			return "[▪]";
		} else {
			if (this.howMuchMineAround == 0) {
				return "[ ]";
			} else {

				return "[" + howMuchMineAround + "]";
			}
		}

	}
}
