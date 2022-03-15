package minerWithOpenCells;

public class cell {
	String link = new String();
	cellType content;

	public cell(String link, cellType content) {
		super();
		this.link = link;
		this.content = content;
	}

	char[] alfabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
			't', 'u', 'v', 'w', 'x' };

	@Override
	public String toString() {

		String[] stringLink = this.link.split("");
		int firstNum = Integer.parseInt(stringLink[0]);
		stringLink[0] = Character.toString(alfabet[firstNum]);
		this.link = stringLink[0] + stringLink[1];

		if (this.content == cellType.mine) {
			return "[" + link + "X" + "]";
		}
		return "[" + link + " ]";
	}

}
