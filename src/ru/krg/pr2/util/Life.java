package ru.krg.pr2.util;

public class Life {

	private byte widthArea = 8;
	private byte heightArea = 8;
	private boolean[][] area;

	public Life() {
		area = new boolean[heightArea][widthArea];
		for (byte y = 0; y < heightArea; y++) {
			for (byte x = 0; x < widthArea; x++) {
				area[y][x] = Math.random() >= 0.5;
			};
		};
	}

	public void run() {
		byte a = 0;
		while (a < 10) {
			print();
			recalc();
			//Thread.sleep(500);
			a++;
		};
	}

	private void print() {
		for (boolean[] col : area) {
			for (boolean cel : col) {
				System.out.print(cel ? "+" : "-");
				System.out.print("  ");
				//System.out.print(Math.random());
			};
			System.out.println("");
		};
		for (byte x = 0; x < widthArea; x++) {
			System.out.print("***");
		};
		System.out.println("");
	}

	private void recalc() {
		boolean[][] newArea = new boolean[heightArea][widthArea];;
		int rx, ry;
		for (byte y = 0; y < heightArea; y++) {
			for (byte x = 0; x < widthArea; x++) {

				byte count = 0;
				for (byte dx = -1; dx < 2; dx++) {
					for (byte dy = -1; dy < 2; dy++) {
						rx = x + dx;
						ry = y + dy;
						if (rx < 0
								|| rx >= widthArea
								|| ry < 0
								|| ry >= heightArea
								|| (x == rx && y == ry)) {
							continue;
						};
						if (area[ry][rx]) {
							//System.out.print("(" + rx + "," + ry + ")");
							count++;
						};
					};
				};
				//System.out.print(count);
				//System.out.print("  ");
				newArea[y][x] = (count > 1 && count < 4);
			};
			//System.out.println("");
		};
		for (byte x = 0; x < widthArea; x++) {
			//System.out.print("...");
		};
		//System.out.println("");
		area = newArea;
	}

}
