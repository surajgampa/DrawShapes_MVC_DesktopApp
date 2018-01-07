package application;

public class Controller {

	public ShapeView view;

	public Controller(ShapeView v){
		this.view=v;
	}

    public void addCircle()
    {
    	CircleForm newCircle = new CircleForm();
    	newCircle.createCircle();
		this.view.circleShapesCreate(newCircle.cm);
    }

    public void addRectangle()
    {
    	RectangleForm newRectangle = new RectangleForm();
    	newRectangle.createRectangle();
    	this.view.rectanglesShapesCreate(newRectangle.rm);
    }

    public void addLine()
    {
    	LineForm newLine = new LineForm();
    	newLine.createLine();
    	this.view.LineShapesCreate(newLine.lm);
    }

}
