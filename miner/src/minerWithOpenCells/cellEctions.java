package minerWithOpenCells;

public class cellEctions {

	public void generateField(short side) {
		int numMine = (int) (side * side * 0.17);// получаю кол-во мин на поле со стороной side
		cell[][] field = new cell[side][side];
		cell tempCell = new cell("00", cellType.notMine);

		for (int i = 0; i < side; i++) {
			for (int j = 0; j < side; j++) {
				field[i][j].content = cellType.notMine;
				field[i][j].link = String.valueOf(i) + String.valueOf(j);
			}
		}

		for (int i = 0; i < side; i++) {
			for (int j = 0; j < side; j++) {
				while (numMine > 0) {
					int rnd = 0 + (int) (Math.random() * 99);
					if (rnd < 18) {

						tempCell.content = cellType.mine;
						numMine--;
					}

				}
			}
		}

	}

}
