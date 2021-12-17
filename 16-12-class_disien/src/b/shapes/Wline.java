package b.shapes;

public class Wline extends Line {

	private int width;

	public Wline(int length, int width) {
		super(length);
		this.width = width;

	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public void print() {
		for (int i = 0; i < width; i++) {
			super.print();

		}
	}
}
