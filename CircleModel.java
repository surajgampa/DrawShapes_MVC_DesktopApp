package application;

public class CircleModel {

	private String Name;
	private int Radius;
	private int Xpos;
	private int Ypos;
	private int StrW;
	private int Rstrw;
	private int Gstrw;
	private int Bstrw;
	private int redVal;
	private int greenVal;
	private int blueVal;
	private String color1;

	public CircleModel(String name, int radius, int xpos, int ypos, int strw, int rstrw, int gstrw, int bstrw, int redval, int greenval, int blueval) {
		Name = name;
		Radius = radius;
	    Xpos = xpos;
	    Ypos = ypos;
	    StrW = strw;
	    Rstrw = rstrw;
	    Gstrw = gstrw;
	    Bstrw = bstrw;
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

	public int getRadius() {
		return Radius;
	}

	public void setRadius(int radius) {
		Radius = radius;
	}

	public int getXpos() {
		return Xpos;
	}

	public void setXpos(int xpos) {
		Xpos = xpos;
	}

	public int getYpos() {
		return Ypos;
	}

	public void setYpos(int ypos) {
		Ypos = ypos;
	}

	public int getStrW() {
		return StrW;
	}

	public void setStrW(int strW) {
		StrW = strW;
	}

	public int getRstrw() {
		return Rstrw;
	}

	public void setRstrw(int rstrw) {
		Rstrw = rstrw;
	}

	public int getGstrw() {
		return Gstrw;
	}

	public void setGstrw(int gstrw) {
		Gstrw = gstrw;
	}

	public int getBstrw() {
		return Bstrw;
	}

	public void setBstrw(int bstrw) {
		Bstrw = bstrw;
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

	public String getColor1() {
		return color1;
	}

	public void setColor1(String color1) {
		this.color1 = color1;
	}




}
