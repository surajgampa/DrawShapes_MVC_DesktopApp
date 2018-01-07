package application;

public class LineModel {

	private String Name;
	private int X1;
	private int Y1;
	private int X2;
	private int Y2;
	private int redVal;
	private int greenVal;
	private int blueVal;

	public LineModel(String name,int x1,int y1,int x2,int y2,int redval,int greenval,int blueval)
	{
		Name = name;
		X1 = x1;
		Y1 = y1;
		X2 = x2;
		Y2 = y2;
		redVal = redval;
		greenVal = greenval;
		blueVal = blueval;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getX1() {
		return X1;
	}

	public void setX1(int x1) {
		X1 = x1;
	}

	public int getY1() {
		return Y1;
	}

	public void setY1(int y1) {
		Y1 = y1;
	}

	public int getX2() {
		return X2;
	}

	public void setX2(int x2) {
		X2 = x2;
	}

	public int getY2() {
		return Y2;
	}

	public void setY2(int y2) {
		Y2 = y2;
	}

	public int getRedVal() {
		return redVal;
	}

	public void setRedVal(int redVal) {
		this.redVal = redVal;
	}

	public int getGreenVal() {
		return greenVal;
	}

	public void setGreenVal(int greenVal) {
		this.greenVal = greenVal;
	}

	public int getBlueVal() {
		return blueVal;
	}

	public void setBlueVal(int blueVal) {
		this.blueVal = blueVal;
	}



}
