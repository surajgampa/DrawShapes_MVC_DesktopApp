package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;
import java.util.Set;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;



public class ShapeView extends BorderPane {
	Controller c;
	Group g = new Group();
    Hashtable<String,int[]> h = new Hashtable<String,int[]>();
    File selectedFile;
	ComboBox<String> delBox = new ComboBox<String>();
    BorderPane groupEnc = new BorderPane();
    int i = 0;

	void accessController(Controller ac)
	{
		this.c=ac;
	}

	public ShapeView()
	{
		this.setPrefSize(1000, 1000);
		VBox menu = new VBox();
		MenuBar menuMain = createMenu();
		menu.getChildren().add(menuMain);
		this.setTop(menu);;
		delBox.setPromptText("Delete a shape!");
		delBox.setOnAction(e -> removeShape());
        g.setAutoSizeChildren(false);
        groupEnc.setPrefSize(1000, 1000);
        groupEnc.getChildren().add(g);
		this.setCenter(groupEnc);
		HBox shapesLists=new HBox(30,delBox);
		shapesLists.setAlignment(Pos.CENTER);
		this.setBottom(shapesLists);

	}

	public void circleShapesCreate(CircleModel c2){
		String n=c2.getName();
		int x=c2.getXpos();
		int y=c2.getYpos();
		int r=c2.getRadius();
		int strw=c2.getStrW();
		int rs=c2.getRstrw();
		int gs=c2.getGstrw();
		int bs=c2.getBstrw();
		int rc=c2.getRedVal();
		int gc=c2.getGreenVal();
		int bc=c2.getBlueVal();
		if(!(x>1000 || y>1000 || r>500 || x<r || y<r))
		{
		Circle cn=new Circle(x,y,r);
		cn.setStrokeWidth(strw);
		cn.setStroke(Color.rgb(rs, gs, bs));
		cn.setFill(Color.rgb(rc, gc, bc));
		g.getChildren().add(cn);
		delBox.getItems().add(n+cn.toString());
		int[] q= {x,y,r,strw,rs,gs,bs,rc,gc,bc};
		h.put(n, q);
		}

	}

	public void rectanglesShapesCreate(RectangleModel r2){
		String n=r2.getName();
		int x=r2.getXpos();
		int y=r2.getYpos();
		int l=r2.getLength();
		int b=r2.getBreadth();
		int strw=r2.getStrW();
		int rs=r2.getRstrw();
		int gs=r2.getGstrw();
		int bs=r2.getBstrw();
		int rc=r2.getRedVal();
		int gc=r2.getGreenVal();
		int bc=r2.getBlueVal();
		if(!(x>1000 || y>1000 || l>1000 || b>1000))
		{
		Rectangle rn=new Rectangle(x,y,l,b);
		rn.setStrokeWidth(strw);
		rn.setStroke(Color.rgb(rs, gs, bs));
		rn.setFill(Color.rgb(rc, gc, bc));
		g.getChildren().add(rn);
		delBox.getItems().add(n+rn.toString());
		int[] q={x,y,l,b,strw,rs,gs,bs,rc,gc,bc};
		h.put(n, q);
		}
	}

	public void LineShapesCreate(LineModel l2){
		String n=l2.getName();
		int x1=l2.getX1();
		int x2=l2.getX2();
		int y1=l2.getY1();
		int y2=l2.getY2();
		int rc=l2.getRedVal();
		int gc=l2.getGreenVal();
		int bc=l2.getBlueVal();
		if(!(x1>1000 || y1>1000 || x2>1000 || y2>1000))
		{
			Line ln=new Line(x1,y1,x2,y2);
			ln.setStroke(Color.rgb(rc, gc, bc));
			g.getChildren().add(ln);
			delBox.getItems().add(n+ln.toString());
			int[] q={x1,y1,x2,y2,rc,gc,bc};
			h.put(n, q);
		}
	}

	public void removeShape()
	{
		String a = delBox.getValue();
		delBox.getItems().remove(a);
		for(int i=0;i<g.getChildren().size();i++)
		{
			String b = g.getChildren().get(i).toString();
			if(a.contains(b))
			{
				g.getChildren().remove(i);
				Set<String> keys = h.keySet();
				for(String key: keys)
				{
					if(a.contains(key))
					{
						h.remove(key);
					}
				}

			}
		}
	}

	public MenuBar createMenu()
	{
		MenuBar menuBar = new MenuBar();
		Menu fileOpt = new Menu("File");
		Menu shapesOpt = new Menu("Shapes");
		MenuItem openOpt=new MenuItem("Open");
		openOpt.setOnAction(e -> {
			try {
				onOpen(null);
			} catch (ClassNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		});
		MenuItem saveOpt=new MenuItem("Save");
		saveOpt.setOnAction(e -> {
			try {
				onSave();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		});
		MenuItem saveAsOpt=new MenuItem("SaveAs");
		saveAsOpt.setOnAction(e -> {
			try {
				onSaveAs(null);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		MenuItem newOpt=new MenuItem("New");
		newOpt.setOnAction(e ->
		{
			onNew();

		});
		MenuItem exitOpt=new MenuItem("Exit");
		exitOpt.setOnAction(e -> onExit());
		MenuItem circleOpt = new MenuItem("Circle");
		circleOpt.setOnAction(e -> c.addCircle());
		MenuItem RectangleOpt = new MenuItem("Rectangle");
		RectangleOpt.setOnAction(e -> c.addRectangle());
		MenuItem lineOpt = new MenuItem("Line");
		lineOpt.setOnAction(e -> c.addLine());
		fileOpt.getItems().addAll(newOpt,openOpt,saveOpt,saveAsOpt,exitOpt);
		shapesOpt.getItems().addAll(circleOpt,RectangleOpt,lineOpt);
		menuBar.getMenus().addAll(fileOpt,shapesOpt);

		return menuBar;
	}

	public void onNew()
	{
		g.getChildren().clear();
		h.clear();
		delBox.getItems().clear();

	}

	@SuppressWarnings({ "unchecked", "resource" })
	public void onOpen(Stage primaryStage) throws IOException, ClassNotFoundException
	{
		g.getChildren().clear();
		h.clear();
		delBox.getItems().clear();

		FileChooser fileChooser = new FileChooser();
		selectedFile=fileChooser.showOpenDialog(primaryStage);
		FileInputStream fileIn = new FileInputStream(selectedFile.getAbsolutePath().toString());
	    ObjectInputStream in = new ObjectInputStream(fileIn);
	    Hashtable<String, int[]> h1 = (Hashtable<String, int[]>)in.readObject(  );
	    Set<String> keys = h1.keySet();
	//    int z = h1.size();
	    for(String key: keys)
		{
		    int[] r = (int[])h1.get(key);
		    if(key.contains("circle"))
		    {
		    	int x=0,y=0,r1=0,strw=0,rs=0,gs=0,bs=0,rc=0,gc=0,bc=0;
		    	for(int i=0;i<r.length;i++)
		    	{
		    		x= r[0];
		    		y= r[1];
		    		r1= r[2];
		    		strw= r[3];
		    		rs= r[4];
		    		gs= r[5];
		    		bs= r[6];
		    		rc= r[7];
		    		gc= r[8];
		    		bc= r[9];
		    	}

		    	Circle cn=new Circle(x,y,r1);
		    	cn.setStrokeWidth(strw);
		        cn.setStroke(Color.rgb(rs, gs, bs));
		    	cn.setFill(Color.rgb(rc, gc, bc));
		    	g.getChildren().add(cn);
		    	delBox.getItems().add(key+cn.toString());
		    	int[] q= {x,y,r1,strw,rs,gs,bs,rc,gc,bc};
		        h.put(key, q);

		    }
		    if(key.contains("rectangle"))
		    {
		    	int x=0,y=0,l=0,b=0,strw=0,rs=0,gs=0,bs=0,rc=0,gc=0,bc=0;
		    	for(int i=0;i<r.length;i++)
		    	{
		    		x= r[0];
		    		y= r[1];
		    		l= r[2];
		    		b= r[3];
		    		strw= r[4];
		    		rs= r[5];
		    		gs= r[6];
		    		bs= r[7];
		    		rc= r[8];
		    		gc= r[9];
		    		bc= r[10];
		    	}

		    	Rectangle rn=new Rectangle(x,y,l,b);
				rn.setStrokeWidth(strw);
				rn.setStroke(Color.rgb(rs, gs, bs));
				rn.setFill(Color.rgb(rc, gc, bc));
				g.getChildren().add(rn);
				delBox.getItems().add(key+rn.toString());
				int[] q={x,y,l,b,strw,rs,gs,bs,rc,gc,bc};
				h.put(key, q);

		    }
		    if(key.contains("line"))
		    {
		    	int x1=0,y1=0,x2=0,y2=0,rc=0,gc=0,bc=0;
		    	for(int i=0;i<r.length;i++)
		    	{
		    		x1=r[0];
		    		y1=r[1];
		    		x2=r[2];
		    		y2=r[3];
		    		rc=r[4];
		    		gc=r[5];
		    		bc=r[6];
		    	}

		    	Line ln = new Line(x1,y1,x2,y2);
		    	ln.setStroke(Color.rgb(rc,gc,bc));
		    	g.getChildren().add(ln);
				delBox.getItems().add(key+ln.toString());
				int[] q={x1,x2,y1,y2,rc,gc,bc};
				h.put(key, q);
		    }

		}
	    for(int i=0;i<3;i++)
	    {
	    	String a = g.getChildren().get(i).toString();
	    	Boolean b = g.getChildren().get(i).isVisible(); b.toString();
	    	System.out.println(a);
	    	System.out.println(b);
	    }

	}
	@SuppressWarnings({ "resource" })
	public void onSaveAs(Stage primaryStage) throws IOException, ClassNotFoundException
	{
		  FileChooser fileChooser = new FileChooser();

          //Set extension filter
          FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("SER files (*.ser)", "*.ser");
          fileChooser.getExtensionFilters().add(extFilter);

          //Show save file dialog
          File file = fileChooser.showSaveDialog(primaryStage);

          if(file != null)
          {
        	String a = file.toString();
        	a = a.replace("\\", "/");
      		FileOutputStream fileOut;
      	    fileOut = new FileOutputStream(a);
      		ObjectOutputStream out = new ObjectOutputStream(fileOut);
      		out.writeObject(h);
          }
	}

	@SuppressWarnings("resource")
	public void onSave() throws IOException
	{
		if(selectedFile!=null)
		{
			String a = selectedFile.getAbsolutePath().toString();
			a = a.replace("\\", "/");
      		FileOutputStream fileOut;
      	    fileOut = new FileOutputStream(a);
      		ObjectOutputStream out = new ObjectOutputStream(fileOut);
      		out.writeObject(h);
		}

	}

	public void onExit()
	{
		Platform.exit();
	}


}