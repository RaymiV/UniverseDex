import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class UniverseDex extends Application {
	public final static String FILEPATH = "./src/data/pokemon.csv"; // SWITCH POKEMON DATABASE PATH LINE
//	public final static String ALTSPATH = "./src/data/altForms_1.csv";
//	public final static String MEGAALTSPATH = "./src/data/megas.csv";
//	public final static String ALOLAALTSPATH = "./src/data/altForms_1.csv";
	public static final String TITLE = "UniverseDex";
	public static int totalTemps = countTemps(FILEPATH);
	public static final Image icon = new Image("https://archives.bulbagarden.net/media/upload/9/98/Key_Rotom_Pok%C3%A9dex_Sprite.png");
	

	/**
	 * int lineCount is defined to be the total number of lines on a text file.
	 * Method will count how many lines there are in the provided text file and stored that value as lineCount.
	 * @param filePath
	 * @return lineCount
	 */
	public static int countTemps(String filePath) {
        int lineCount = 0;
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while (bufferedReader.readLine() != null) {
                System.out.println("Loading Pokemon " + lineCount + "...");
            	lineCount++;
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("File could not be loaded.");
        }
        return lineCount;
    }
	
	public static void main(String[] args) {
		launch(args);
	
	}
	
	public static Button createButton(Pokemon p, Button displayPane, Button type1Display, Button type2Display, Button infographics, Button characterInfo, Button displayBackPane, Button displayShinyPane) {
		
		String myString = "" + p.NID + " - " + p.name;
		Button b = new Button();
		b.setText(myString);
		b.setMinWidth(300);
		b.setMinHeight(40);
		b.setStyle(
			  "-fx-text-fill: #ffffff; "			// Text Color
			+ "-fx-font: bold 15pt \"Roboto\"; "	// Text Size & Font
			+ "-fx-background-color: #000000; "		// Background Color
			+ "-fx-background-radius: 25; "			// Background Radius
			+ "-fx-border-color: #0074B7; "			// Background Color
			+ "-fx-border-radius: 25;  "			// Border Radius
			+ "-fx-border-width: 3;");				// Border Width
		
		String icon = "";
		if(p.NID < 10) {
		 icon = "https://www.pokencyclopedia.info/sprites/menu-icons/ico_3ds/ico_3ds_00" + p.NID + ".png";
		} else if(p.NID >= 10 && p.NID <= 99) {
			 icon = "https://www.pokencyclopedia.info/sprites/menu-icons/ico_3ds/ico_3ds_0" + p.NID + ".png";
		} else if(p.NID >= 100) {
			 icon = "https://www.pokencyclopedia.info/sprites/menu-icons/ico_3ds/ico_3ds_" + p.NID + ".png";
		}
		Image iconImage = new Image(icon, 50, 50, true, true);
		ImageView iconView = new ImageView(iconImage);
		b.setGraphic(iconView);
		b.setContentDisplay(ContentDisplay.LEFT);
		b.setOnMouseEntered(event ->{
			displayChangeEnter(p, b, displayPane, type1Display, type2Display, infographics, characterInfo, displayBackPane, displayShinyPane);
		});
		b.setOnMouseExited(event ->{
			displayChangeLeave(p, b, displayPane, myString);
		});
		
		return b;
		
	}

	/**
	 * Returns the color (hex code)/symbol for the Pokemon type (as a string) provided.
	 * The Dictionary named "typing" will be the library holding the data (keys and values).
	 * @param type
	 * @return typing.get(type)
	 */
	public static String typeMatch(String type) {
		Dictionary<String, String> typing = new Hashtable<>();
		
		
		if (type == null || type.isEmpty()) {
			return ("#AAB09F");
		}
		
		type = type.toLowerCase();
		typing.put("normal", "#AAB09F");
		typing.put("fire", "#EE8130");
		typing.put("water", "#6390F0");
		typing.put("electric", "#F7D02C");
		typing.put("grass", "#7AC74C");
		typing.put("ice", "#96D9D6");
		typing.put("fighting", "#C22E28");
		typing.put("poison", "#A33EA1");
		typing.put("ground", "#E2BF65");
		typing.put("flying", "#A98FF3");
		typing.put("psychic", "#F95587");
		typing.put("bug", "#A6B91A");
		typing.put("rock", "#B6A136");
		typing.put("ghost", "#735797");
		typing.put("dragon", "#6F35FC");
		typing.put("dark", "#58535A");
		typing.put("steel", "#B7B7CE");
		typing.put("fairy", "#D685AD");
		typing.put("", "#ffffff");
		
		
		return typing.get(type);
	}
	
	
	/**
	 * Returns the array named "myArray" full of elements found on a string
	 * The code will check if the line is valid
	 * If the line is valid then:
	 * -Spaces will be removed
	 * -myArray will contain the contents of the string splitted by ","
	 * @param line
	 * @return myArray
	 * @throws IOException
	 */
	public static String[] readnSplit(String line) throws IOException {
		
        String[] myArray;
        char check = '"';
        String checker = "" + check;
        String b = "" + line.charAt(0);
        if(b.contentEquals(checker)) {
        	line = line.replaceAll(b, "");
        }
        
        myArray = line.split(",");
            
        return myArray;
    }
	
	
//	public static String capitalizer(String a) {
//		
//		if (a == null || a.isEmpty()) {
//			return "";
//		}
//		char first = a.charAt(0);
//		char upper = Character.toUpperCase(first);
//		StringBuilder result = new StringBuilder(a);
//		
//		result.setCharAt(0, upper);
//		
//		return result.toString();
//	}

	public static void displayChangeLeave(Pokemon p, Button b, Button displayPane, String myString)  {
		b.setText(myString);
		b.setStyle(
				  "-fx-text-fill: #ffffff; "			// Text Color
				+ "-fx-font: bold 15pt \"Roboto\"; "	// Text Size & Font
				+ "-fx-background-color: #000000; "		// Background Color
				+ "-fx-background-radius: 25; "			// Background Radius
				+ "-fx-border-color: #0074B7; "			// Background Color
				+ "-fx-border-radius: 25;  "			// Border Radius
				+ "-fx-border-width: 3;");				// Border Width
	}
	
	public static void displayChangeEnter(Pokemon p, Button b, Button displayPane, Button type1Display, Button type2Display, Button infographics, Button characterInfo, Button displayBackPane, Button displayShinyPane)  {

		
		/////////////////////////////////////// TYPE 1 /////////////////////////////////////////////

		String type1 = "";
		if(p.typeOne.equals("fire")) {
			type1 = "https://archives.bulbagarden.net/media/upload/1/15/FireIC_BW.png";
		} else if(p.typeOne.equals("water")) {
			type1 = "https://archives.bulbagarden.net/media/upload/2/2b/WaterIC_BW.png?20200224205729";
		} else if(p.typeOne.equals("grass")) {
			type1 = "https://archives.bulbagarden.net/media/upload/2/23/GrassIC_BW.png?20200224205542";
		} else if(p.typeOne.equals("electric")) {
			type1 = "https://archives.bulbagarden.net/media/upload/6/67/ElectricIC_BW.png?20200224205343";
		} else if(p.typeOne.equals("bug")) {
			type1 = "https://archives.bulbagarden.net/media/upload/2/2e/BugIC_BW.png?20200224205248";
		} else if(p.typeOne.equals("ice")) {
			type1 = "https://archives.bulbagarden.net/media/upload/4/4c/IceIC_RSE.png?20220424143150";
		} else if(p.typeOne.equals("dark")) {
			type1 = "https://archives.bulbagarden.net/media/upload/3/35/DarkIC_BW.png?20200224205309";
		} else if(p.typeOne.equals("dragon")) {
			type1 = "https://archives.bulbagarden.net/media/upload/a/ad/DragonIC_BW.png?20200224205326";
		} else if(p.typeOne.equals("psychic")) {
			type1 = "https://archives.bulbagarden.net/media/upload/6/60/PsychicIC_BW.png?20200224205654";
		} else if(p.typeOne.equals("ground")) {
			type1 = "https://archives.bulbagarden.net/media/upload/f/f4/GroundIC_BW.png?20200224205556";
		} else if(p.typeOne.equals("rock")) {
			type1 = "https://archives.bulbagarden.net/media/upload/8/85/RockIC_BW.png?20200224210101";
		} else if(p.typeOne.equals("fairy")) {
			type1 = "https://archives.bulbagarden.net/media/upload/7/73/FairyIC_Big.png?20170821035827";
		} else if(p.typeOne.equals("flying")) {
			type1 = "https://archives.bulbagarden.net/media/upload/8/8e/FlyingIC_BW.png?20200224205954";
		} else if(p.typeOne.equals("ghost")) {
			type1 = "https://archives.bulbagarden.net/media/upload/9/99/GhostIC_BW.png?20200224205515";
		} else if(p.typeOne.equals("steel")) {
			type1 = "https://archives.bulbagarden.net/media/upload/0/04/SteelIC_BW.png?20200224205713";
		} else if(p.typeOne.equals("poison")) {
			type1 = "https://archives.bulbagarden.net/media/upload/b/ba/PoisonIC_BW.png?20200224205528";
		} else if(p.typeOne.equals("fighting")) {
			type1 = "https://archives.bulbagarden.net/media/upload/c/c8/FightingIC_BW.png?20200224205358";
		} else if(p.typeOne.equals("normal")) {
			type1 = "https://archives.bulbagarden.net/media/upload/2/28/NormalIC_BW.png?20200224205131";
		}
		Image type1Image = new Image(type1, 70, 70, true, true);
		ImageView type1View = new ImageView(type1Image);
		type1View.setTranslateX(-260);
		type1View.setTranslateY(160);
		type1Display.setGraphic(type1View);
		
		/////////////////////////////////////// TYPE 2 /////////////////////////////////////////////
		
		String type2 = "";
		if(p.typeTwo.equals("fire")) {
		type2 = "https://archives.bulbagarden.net/media/upload/1/15/FireIC_BW.png";
		} else if(p.typeTwo.equals("water")) {
		type2 = "https://archives.bulbagarden.net/media/upload/2/2b/WaterIC_BW.png?20200224205729";
		} else if(p.typeTwo.equals("grass")) {
		type2 = "https://archives.bulbagarden.net/media/upload/2/23/GrassIC_BW.png?20200224205542";
		} else if(p.typeTwo.equals("electric")) {
		type2 = "https://archives.bulbagarden.net/media/upload/6/67/ElectricIC_BW.png?20200224205343";
		} else if(p.typeTwo.equals("bug")) {
		type2 = "https://archives.bulbagarden.net/media/upload/2/2e/BugIC_BW.png?20200224205248";
		} else if(p.typeTwo.equals("ice")) {
		type2 = "https://archives.bulbagarden.net/media/upload/4/4c/IceIC_RSE.png?20220424143150";
		} else if(p.typeTwo.equals("dark")) {
		type2 = "https://archives.bulbagarden.net/media/upload/3/35/DarkIC_BW.png?20200224205309";
		} else if(p.typeTwo.equals("dragon")) {
		type2 = "https://archives.bulbagarden.net/media/upload/a/ad/DragonIC_BW.png?20200224205326";
		} else if(p.typeTwo.equals("psychic")) {
		type2 = "https://archives.bulbagarden.net/media/upload/6/60/PsychicIC_BW.png?20200224205654";
		} else if(p.typeTwo.equals("ground")) {
		type2 = "https://archives.bulbagarden.net/media/upload/f/f4/GroundIC_BW.png?20200224205556";
		} else if(p.typeTwo.equals("rock")) {
		type2 = "https://archives.bulbagarden.net/media/upload/8/85/RockIC_BW.png?20200224210101";
		} else if(p.typeTwo.equals("fairy")) {
		type2 = "https://archives.bulbagarden.net/media/upload/7/73/FairyIC_Big.png?20170821035827";
		} else if(p.typeTwo.equals("flying")) {
		type2 = "https://archives.bulbagarden.net/media/upload/8/8e/FlyingIC_BW.png?20200224205954";
		} else if(p.typeTwo.equals("ghost")) {
		type2 = "https://archives.bulbagarden.net/media/upload/9/99/GhostIC_BW.png?20200224205515";
		} else if(p.typeTwo.equals("steel")) {
		type2 = "https://archives.bulbagarden.net/media/upload/0/04/SteelIC_BW.png?20200224205713";
		} else if(p.typeTwo.equals("poison")) {
		type2 = "https://archives.bulbagarden.net/media/upload/b/ba/PoisonIC_BW.png?20200224205528";
		} else if(p.typeTwo.equals("fighting")) {
		type2 = "https://archives.bulbagarden.net/media/upload/c/c8/FightingIC_BW.png?20200224205358";
		} else if(p.typeTwo.equals("normal")) {
		type2 = "https://archives.bulbagarden.net/media/upload/2/28/NormalIC_BW.png?20200224205131";
		} else if(p.typeTwo.equals("")) {
		type2 = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/HD_transparent_picture.png/1024px-HD_transparent_picture.png";
		}
		Image type2Image = new Image(type2, 70, 70, true, true);
		ImageView type2View = new ImageView(type2Image);
		type2Display.setTranslateX(-160);
		type2Display.setTranslateY(160);
		type2Display.setGraphic(type2View);
		
		/////////////////////////////////////// Gen 5 Animation /////////////////////////////////////////////
		
		String imageGif = ("https://play.pokemonshowdown.com/sprites/gen5ani/" + p.imageName.toLowerCase() + ".gif");
		Image img = new Image(imageGif, 200, 200, true, true);
		ImageView view = new ImageView(img);
        view.setTranslateX(-200);
        view.setTranslateY(10);
		displayPane.setGraphic(view);
		
		/////////////////////////////////////// Gen 5 Animation Back /////////////////////////////////////////////
		
		String imageBackGif = ("https://play.pokemonshowdown.com/sprites/gen5ani-back/" + p.imageName.toLowerCase() + ".gif");
		
		Image imgBack = new Image(imageBackGif, 100, 100, true, true);
		ImageView viewBack = new ImageView(imgBack);
        displayBackPane.setGraphic(viewBack);
        displayBackPane.setContentDisplay(ContentDisplay.BOTTOM);
        viewBack.setTranslateX(0);
        viewBack.setTranslateY(-50);
        
		displayBackPane.setStyle(
				"-fx-background-color: transparent; "		// Background Color
				+ "-fx-background-radius: 25; "			// Background Radius
				+ "-fx-border-color: transparent; ");			// Background Color
		
		/////////////////////////////////////// Gen 5 Animation Shiny /////////////////////////////////////////////
		
		String imageShinyGif = "https://play.pokemonshowdown.com/sprites/gen5ani-shiny/" + p.imageName.toLowerCase() + ".gif";
		
		Image imgShiny = new Image(imageShinyGif, 100, 100, true, true);
		ImageView viewShiny = new ImageView(imgShiny);
        displayShinyPane.setGraphic(viewShiny);
        displayShinyPane.setContentDisplay(ContentDisplay.BOTTOM);
        viewShiny.setTranslateX(0);
        viewShiny.setTranslateY(50);
        
		displayShinyPane.setStyle(
				"-fx-background-color: transparent; "		// Background Color
				+ "-fx-background-radius: 25; "			// Background Radius
				+ "-fx-border-color: transparent; ");			// Background Color
		
		/////////////////////////////////////// STYLE /////////////////////////////////////////////
		
		b.setStyle(
				  "-fx-text-fill: #ffffff; "			// Text Color
				+ "-fx-font: bold 15pt \"Roboto\"; "	// Text Size & Font
				+ "-fx-background-color: #d3d3d3; "		// Background Color
				+ "-fx-background-radius: 25; "			// Background Radius
				+ "-fx-border-color: #ffff00; "			// Background Color
				+ "-fx-border-radius: 25;  "			// Border Radius
				+ "-fx-border-width: 3;");				// Border Width
		
		// Infographic
		
		String infoText = 
				"National Dex #" + p.NID
				+ "\nWeight: " + p.weight
				+ " lbs\nHeight: " + p.height
				+ "'\n\nStats:\nHP:  " + p.health
				+ "\nATK:  " + p.attack 
				+ "\nSP. ATK:  " + p.spAttack 
				+ "\nDEF:  " + p.defense
				+ "\nSP. DEF:  " + p.spDefense
				+ "\nSPD:  " + p.speed 
				+ "\nTotal:  " + (Integer.parseInt(p.health) + (Integer.parseInt(p.attack)) + (Integer.parseInt(p.spAttack)) + (Integer.parseInt(p.defense)) + (Integer.parseInt(p.spDefense)) + (Integer.parseInt(p.speed)));
		
		infographics.setText(infoText);
		
		infographics.setStyle(
				"-fx-text-fill: white; "
				+ "-fx-font: 16pt \"Lucida Console\";"
				+ "-fx-background-color: transparent; "		// Background Color
				+ "-fx-border-color: transparent; ");			// Background Color
		
		String abilityText = "         " + p.name
				+ "\n\n        " + p.species;
		
		characterInfo.setStyle(
				"-fx-text-fill: white; "
				+ "-fx-font: 20pt \"Lucida Console\";"
				+ "-fx-background-color: transparent; "		// Background Color
				+ "-fx-border-color: transparent; ");			// Background Color
		
		characterInfo.setText(abilityText);
		characterInfo.setContentDisplay(ContentDisplay.RIGHT);
	}
	
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		Map<Integer, Pokemon> pokemonMap = new HashMap<>();
		
		int place = 1;
		int looking = 1;
		String currentLine;
		File f = new File(FILEPATH);
		
		try {
			Scanner s = new Scanner(f);
	        FlowPane display = new FlowPane(Orientation.HORIZONTAL, 50, 5); 
	        display.setStyle("-fx-background-color: #222222; -fx-border-color: #222222");
	        // -fx-background-image: url(); -fx-background-size: 2000; 
			display.setPadding(new Insets(80, 0, 0, 1000)); // (top/right/bottom/left)
			display.setAlignment(Pos.TOP_RIGHT);
			
			
			String [] store;
			while(s.hasNextLine()) {
				
				currentLine = s.nextLine();
				store = readnSplit(currentLine);
				Pokemon Pokemon = new Pokemon(store);
				pokemonMap.put(Pokemon.NID, Pokemon);
				
				
				place++;
			}
			
	        StackPane root = new StackPane();
			
	        // Image Back
	        Button displayBackPane = new Button();
//	        root.setStyle("-fx-background-image: url(https://archives.bulbagarden.net/media/upload/2/2d/Box_Heart_HGSS.png); -fx-background-size: 500;");

			String imageBackGif = "https://play.pokemonshowdown.com/sprites/gen5ani-back/bulbasaur.gif";
			
			Image imgBack = new Image(imageBackGif, 100, 100, true, true);
			ImageView viewBack = new ImageView(imgBack);
	        displayBackPane.setGraphic(viewBack);
	        displayBackPane.setContentDisplay(ContentDisplay.BOTTOM);
	        viewBack.setTranslateX(0);
	        viewBack.setTranslateY(-50);
	        
			displayBackPane.setStyle(
					"-fx-background-color: transparent; "		// Background Color
					+ "-fx-background-radius: 25; "			// Background Radius
					+ "-fx-border-color: transparent; ");			// Background Color
			
	        // Image Shiny
	        Button displayShinyPane = new Button();

			String imageShinyGif = "https://play.pokemonshowdown.com/sprites/gen5ani-shiny/bulbasaur.gif";
			
			Image imgShiny = new Image(imageShinyGif, 100, 100, true, true);
			ImageView viewShiny = new ImageView(imgShiny);
	        displayShinyPane.setGraphic(viewShiny);
	        displayShinyPane.setContentDisplay(ContentDisplay.BOTTOM);
	        viewShiny.setTranslateX(0);
	        viewShiny.setTranslateY(50);
	        
			displayShinyPane.setStyle(
					"-fx-background-color: transparent; "		// Background Color
					+ "-fx-background-radius: 25; "			// Background Radius
					+ "-fx-border-color: transparent; ");			// Background Color
	        
	        // Image
			Button displayPane = new Button();
			displayPane.setStyle("-fx-background-color: transparent");

			String imageGif = "https://play.pokemonshowdown.com/sprites/gen5ani/bulbasaur.gif";
			
			Image img = new Image(imageGif, 200, 200, true, true);
			ImageView view = new ImageView(img);
	        displayPane.setGraphic(view);
	        view.setTranslateX(-200);
	        view.setTranslateY(10);
	        
	        // Platform
			Button platformPane = new Button();
			platformPane.setStyle("-fx-background-color: transparent");
			
	        String platform = "https://static.wikia.nocookie.net/capx/images/e/ec/Basic_Grass.png/revision/latest?cb=20130620230433";
	        Image platformView = new Image(platform, 300, 300, true, true);
			ImageView platformDisplay = new ImageView(platformView);
			platformPane.setGraphic(platformDisplay);
	        platformDisplay.setTranslateX(-200);
	        platformDisplay.setTranslateY(90);
	        
	        Button type1 = new Button();
			type1.setStyle("-fx-background-color: transparent");
			String type1Image = "https://archives.bulbagarden.net/media/upload/2/23/GrassIC_BW.png?20200224205542";
	        Image type1View = new Image(type1Image, 70, 70, true, true);
			ImageView type1Display = new ImageView(type1View);
			type1.setGraphic(type1Display);
			type1Display.setTranslateX(-260);
			type1Display.setTranslateY(160);
			
			Button type2 = new Button();
			type2.setStyle("-fx-background-color: transparent");
			String type2Image = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/HD_transparent_picture.png/1024px-HD_transparent_picture.png";
	        Image type2View = new Image(type2Image, 70, 70, true, true);
			ImageView type2Display = new ImageView(type2View);
			type2.setGraphic(type2Display);
			type2Display.setTranslateX(-160);
			type2Display.setTranslateY(160);
			
			
			// Infographic
			
			Button infographics = new Button();
			Button characterInfo = new Button();

	        StackPane.setMargin(infographics, new javafx.geometry.Insets(-300, 0, 0, -950));
	        StackPane.setMargin(characterInfo, new javafx.geometry.Insets(-350, 0, 0, -400));
			
			String abilityText = "         " + "Bulbasaur"
					+ "\n\n        Seed Pokemon";
	        
			String infoText = 
					"National Dex #" + 1
					+ "\nWeight: " + 6.9 
					+ " lbs\nHeight: " + 0.7 
					+ "'\n\nStats:\nHP:  " + 45 
					+ "\nATK:  " + 49 
					+ "\nSP. ATK:  " + 49 
					+ "\nDEF:  " + 65 
					+ "\nSP. DEF:  " + 65 
					+ "\nSPD:  " + 45 
					+ "\nTotal:  " + 318;
			
			infographics.setText(infoText);
			
			infographics.setStyle(
					"-fx-text-fill: white; "
					+ "-fx-font: 16pt \"Lucida Console\";"
					+ "-fx-background-color: transparent; "		// Background Color
					+ "-fx-border-color: transparent; ");			// Background Color
			
			characterInfo.setText(abilityText);
			
			characterInfo.setStyle(
					"-fx-text-fill: white; "
					+ "-fx-font: 20pt \"Lucida Console\";"
					+ "-fx-background-color: transparent; "		// Background Color
					+ "-fx-border-color: transparent; ");			// Background Color
			
			while(looking < pokemonMap.size()) {
				
				Button b = createButton(pokemonMap.get(looking), displayPane, type1, type2, infographics, characterInfo, displayBackPane, displayShinyPane);
				display.getChildren().add(b);
				looking++;
			}
			
			ScrollPane scrollPane = new ScrollPane(display);
			scrollPane.setFitToWidth(true);
			scrollPane.setFitToHeight(false);
			root.getChildren().addAll(scrollPane, platformPane, displayPane, displayBackPane, type1, type2, infographics, characterInfo, displayShinyPane);
			Scene scene = new Scene(root, 600, 600);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setMinWidth(1200);
			primaryStage.setMinHeight(100);
			primaryStage.getIcons().add(icon);
			
			primaryStage.setTitle(TITLE);
			primaryStage.show();	
			
		} catch (FileNotFoundException e) {
			
			
			System.out.println("File cannot be reached");
			e.printStackTrace();
			System.exit(0);
		}
		
		
	}
	
	

}
