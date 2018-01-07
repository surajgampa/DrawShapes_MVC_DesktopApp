package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class CircleForm extends Stage{

	TextField txtName;
	TextField txtRadius;
	TextField txtXpos;
	TextField txtYpos;
	TextField txtStrokeWidth;
	CircleModel cm;

	public void createCircle()
	{
	    this.setTitle("Circle Add Form");

	    Label lblName = new Label("Name: ");
		txtName = new TextField();
		txtName.setPrefColumnCount(20);
		txtName.setMaxWidth(Double.MAX_VALUE);
		HBox paneName = new HBox();
		paneName.getChildren().addAll(lblName,txtName);

	    Label lblRadius = new Label("Radius: ");
		txtRadius = new TextField();
		txtRadius.setPrefColumnCount(20);
		txtRadius.setMaxWidth(Double.MAX_VALUE);
		HBox paneSize = new HBox();
		paneSize.getChildren().addAll(lblRadius,txtRadius);

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

		Button submitCircle = new Button("Submit");
		Button cancelSub = new Button("Cancel");
		cancelSub.setOnAction(e -> this.close());
		HBox btns = new HBox(30,submitCircle,cancelSub);
		submitCircle.setAlignment(Pos.CENTER);
		submitCircle.setOnAction((e) ->
		{
		    int r = Integer.parseInt(txtRadius.getText().toString());
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


			cm=new CircleModel(txtName.getText().toString(),r,x,y,strw,strR,strG,strB,red,green,blue);
			this.close();
		}
		);

		VBox paneCircle=new VBox(10,paneName,paneSize,panePos,paneStrW,paneColorValues,btns);

		Scene sceneOrder=new Scene(paneCircle);
		this.setScene(sceneOrder);
		this.showAndWait();


	}
}