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

public class LineForm extends Stage{

	TextField txtName;
	TextField x1Pos;
	TextField y1Pos;
	TextField x2Pos;
	TextField y2Pos;
	LineModel lm;

	public void createLine()
	{
		this.setTitle("Create a Line");

		Label lblName = new Label("Name: ");
		txtName = new TextField();
		txtName.setPrefColumnCount(20);
		txtName.setMaxWidth(Double.MAX_VALUE);
		HBox paneName = new HBox();
		paneName.getChildren().addAll(lblName,txtName);

		Label lblX1 = new Label("Position X1: ");
		x1Pos = new TextField();
		x1Pos.setPrefColumnCount(20);
		x1Pos.setMaxWidth(Double.MAX_VALUE);
		HBox panePos = new HBox();
		panePos.getChildren().addAll(lblX1, x1Pos);

	    Label lblY1 = new Label("Position Y: ");
		y1Pos = new TextField();
		y1Pos.setPrefColumnCount(20);
		y1Pos.setMaxWidth(Double.MAX_VALUE);
		panePos.getChildren().addAll(lblY1,y1Pos);

		Label lblX2 = new Label("Position X2: ");
		x2Pos = new TextField();
		x2Pos.setPrefColumnCount(20);
		x2Pos.setMaxWidth(Double.MAX_VALUE);
		HBox panePos1 = new HBox();
		panePos1.getChildren().addAll(lblX2, x2Pos);

	    Label lblY2 = new Label("Position Y2: ");
		y2Pos = new TextField();
		y2Pos.setPrefColumnCount(20);
		y2Pos.setMaxWidth(Double.MAX_VALUE);
		panePos1.getChildren().addAll(lblY2,y2Pos);


		final ColorPicker colorPicker = new ColorPicker();
		Label lblColors = new Label("Select Fill Color for the Shape   ");
		HBox paneColorValues = new HBox();
		paneColorValues.getChildren().addAll(lblColors,colorPicker);

		Button submitCircle = new Button("Submit");
		Button cancelSub = new Button("Cancel");
		cancelSub.setOnAction(e -> this.close());
		HBox btns = new HBox(30,submitCircle,cancelSub);
		submitCircle.setAlignment(Pos.CENTER);
		submitCircle.setOnAction((e) ->
		{
			 int x1 = Integer.parseInt(x1Pos.getText().toString());
			 int y1 = Integer.parseInt(y1Pos.getText().toString());
			 int x2 = Integer.parseInt(x2Pos.getText().toString());
			 int y2 = Integer.parseInt(y2Pos.getText().toString());
			 Color c1 = colorPicker.getValue();
			 int red =  (int)(c1.getRed()*255);
			 int green = (int)(c1.getGreen()*255);
			 int blue = (int)(c1.getBlue()*255);

			 lm=new LineModel(txtName.getText().toString(),x1,y1,x2,y2,red,green,blue);
		     this.close();
		});

		VBox paneLine=new VBox(10,paneName,panePos,panePos1,paneColorValues,btns);

		Scene sceneOrder=new Scene(paneLine);
		this.setScene(sceneOrder);
		this.showAndWait();

	}


}
