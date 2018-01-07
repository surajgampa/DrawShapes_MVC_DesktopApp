package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class RectangleForm extends Stage {

	TextField txtName;
	TextField txtLength;
	TextField txtBreadth;
	TextField txtXpos;
	TextField txtYpos;
	TextField txtStrokeWidth;
    RectangleModel rm;

	public void createRectangle()
	{
	    this.setTitle("Rectangle Add Form");

	    Label lblName = new Label("Name: ");
		txtName = new TextField();
		txtName.setPrefColumnCount(20);
		txtName.setMaxWidth(Double.MAX_VALUE);
		HBox paneName = new HBox();
		paneName.getChildren().addAll(lblName,txtName);

	    Label lblLength = new Label("Length: ");
		txtLength = new TextField();
		txtLength.setPrefColumnCount(20);
		txtLength.setMaxWidth(Double.MAX_VALUE);
	    Label lblBreadth = new Label("Breadth: ");
		txtBreadth = new TextField();
		txtBreadth.setPrefColumnCount(20);
		txtBreadth.setMaxWidth(Double.MAX_VALUE);
		HBox paneSize = new HBox();
		paneSize.getChildren().addAll(lblLength,txtLength,lblBreadth,txtBreadth);

		Label lblX = new Label("Position X: ");
		txtXpos = new TextField();
		txtXpos.setPrefColumnCount(20);
		txtXpos.setMaxWidth(Double.MAX_VALUE);
		HBox panePos = new HBox();
		panePos.getChildren().addAll(lblX,txtXpos);

	    Label lblY = new Label("Position Y: ");
		txtYpos = new TextField();
		txtYpos.setPrefColumnCount(20);
		txtYpos.setMaxWidth(Double.MAX_VALUE);
		panePos.getChildren().addAll(lblY,txtYpos);

	    Label lblStrW = new Label("Stroke Width: ");
		txtStrokeWidth = new TextField();
		txtStrokeWidth.setPrefColumnCount(20);
		txtStrokeWidth.setMaxWidth(Double.MAX_VALUE);
		HBox paneStrW = new HBox();
		paneStrW.getChildren().addAll(lblStrW,txtStrokeWidth);

		final ColorPicker colorPicker1 = new ColorPicker();
		final ColorPicker colorPicker2 = new ColorPicker();
		Label lblStrColors = new Label("Select Stroke Color   ");
		paneStrW.getChildren().addAll(lblStrColors,colorPicker1);
		Label lblColors = new Label("Select Fill Color for the Shape   ");
		HBox paneColorValues = new HBox();
		paneColorValues.getChildren().addAll(lblColors,colorPicker2);


		Button SubmitRect = new Button("Submit");
		SubmitRect.setOnAction((e) ->
		{
		    int l = Integer.parseInt(txtLength.getText().toString());
		    int b = Integer.parseInt(txtBreadth.getText().toString());
		    int x = Integer.parseInt(txtXpos.getText().toString());
		    int y = Integer.parseInt(txtYpos.getText().toString());
		    int strw = Integer.parseInt(txtStrokeWidth.getText().toString());
		    Color c1 = colorPicker1.getValue();
		    Color c2 = colorPicker2.getValue();
		    int strR = (int)(c1.getRed()*255);
		    int strG = (int)(c1.getGreen()*255);
		    int strB = (int)(c1.getBlue()*255);
		    int red =  (int)(c2.getRed()*255);
		    int green = (int)(c2.getGreen()*255);
		    int blue = (int)(c2.getBlue()*255);

			rm=new RectangleModel(txtName.getText().toString(),l,b,x,y,strw,strR,strG,strB,red,green,blue);
			this.close();
		}
		);

		VBox paneRect=new VBox(10,paneName,paneSize,panePos,paneStrW,paneColorValues,SubmitRect);

		Scene sceneOrder=new Scene(paneRect);
		this.setScene(sceneOrder);
		this.showAndWait();



	}
}
