import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class UniverseDex extends Application {
	public final static String POKEMON_DATABASE_PATH = "./src/data/test-battle.csv"; // SWITCH POKEMON DATABASE PATH LINE
//	public final static String ALTERNATE_POKEMON_DATABASE_PATH = "./src/data/altForms_1.csv";
	public static final String TITLE = "UniverseDex";
	public static int totalTemps = countTemps(POKEMON_DATABASE_PATH);
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
                System.out.println("Loading National Dex #" + lineCount + "...");
            	lineCount++;
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("File could not be loaded.");
        }
        return lineCount;
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
	
	public static void main(String[] args) {
		launch(args);
	
	}
	
	public static Button PokedexTabs(Pokemon p, Button displayPane, Button type1Display, Button type2Display, Button infographics, Button characterInfo, Button displayBackPane, Button displayShinyPane) {
		
		DisplayImages mouse = new DisplayImages();
		
		String myString = "" + p.order + " - " + p.name;
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
		
//		String icon = "";
//		
//		if(p.name.toLowerCase().contains("mega") ) {
//			icon = "https://www.pokencyclopedia.info/sprites/menu-icons/ico_3ds/ico_3ds_" + p.nationalDex + "-mega.png";
//		} else if(p.nationalDex < 10) {
//		 icon = "https://www.pokencyclopedia.info/sprites/menu-icons/ico_3ds/ico_3ds_00" + p.nationalDex + ".png";
//		} else if(p.nationalDex >= 10 && p.nationalDex <= 99) {
//			icon = "https://www.pokencyclopedia.info/sprites/menu-icons/ico_3ds/ico_3ds_0" + p.nationalDex + ".png";
//		} else if(p.nationalDex >= 100) {
//			icon = "https://www.pokencyclopedia.info/sprites/menu-icons/ico_3ds/ico_3ds_" + p.nationalDex + ".png";
//		} else if(p.nationalDex >= 810) {
//			icon = "https://github.com/msikma/pokesprite/blob/master/pokemon-gen8/shiny/" + p.name.toLowerCase() + ".png";
//		}
//		
//		Image iconImage = new Image(icon, 50, 50, true, true);
//		ImageView iconView = new ImageView(iconImage);
//		b.setGraphic(iconView);
//		b.setContentDisplay(ContentDisplay.LEFT);
		b.setOnMouseEntered(event ->{
			mouse.EnterMouseDisplay(p, b, displayPane, type1Display, type2Display, infographics, characterInfo, displayBackPane, displayShinyPane);
		});
		b.setOnMouseExited(event ->{
			mouse.LeaveMouseDisplay(p, b, displayPane, myString);
		});
		
		return b;
		
	}
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		Map<Integer, Pokemon> pokemonMap = new HashMap<>();
		
		int place = 1;
		int looking = 1;
		String currentLine;
		File f = new File(POKEMON_DATABASE_PATH);
		
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
				pokemonMap.put(Pokemon.order, Pokemon);
				
				
				place++;
			}
			
	        StackPane root = new StackPane();
			
	        Button displayPane = new Button();
	        Button platformPane = new Button();
	        Button type1 = new Button();
	        Button type2 = new Button();
	        Button infographics = new Button();
	        Button characterInfo = new Button();
	        Button displayBackPane = new Button();
	        Button displayShinyPane = new Button();
	        
	        Button EnterButton = new Button();
	        
			EnterButton.setStyle(
					  "-fx-text-fill: #ffffff; "			// Text Color
					+ "-fx-font: bold 15pt \"Roboto\"; "	// Text Size & Font
					+ "-fx-background-color: #d3d3d3; "		// Background Color
					+ "-fx-background-radius: 25; "			// Background Radius
					+ "-fx-border-color: #ffff00; "			// Background Color
					+ "-fx-border-radius: 25;  "			// Border Radius
					+ "-fx-border-width: 3;");				// Border Width
			
			EnterButton.setTranslateX(100);
			EnterButton.setTranslateY(-100);
	        
	        DisplayImages.StartUpDisplay(displayPane, platformPane, type1, type2, infographics, characterInfo, displayBackPane, displayShinyPane);
			
			while(looking < pokemonMap.size()) {
				
				Button b = PokedexTabs(pokemonMap.get(looking), displayPane, type1, type2, infographics, characterInfo, displayBackPane, displayShinyPane);
				display.getChildren().add(b);
				looking++;
			}
			

			
			
			ScrollPane scrollPane = new ScrollPane(display);
			scrollPane.setFitToWidth(true);
			scrollPane.setFitToHeight(false);
			root.getChildren().addAll(
					scrollPane,
					platformPane,
					displayPane,
					displayBackPane,
					type1,
					type2,
					infographics,
					characterInfo,
					displayShinyPane,
					EnterButton);
			
			Scene scene1 = new Scene(root, 600, 600);
			
			primaryStage.setScene(scene1); // Start-Up
			
			primaryStage.setResizable(false);
			primaryStage.setMinWidth(1200);
			primaryStage.setMinHeight(100);
			primaryStage.getIcons().add(icon);
			
			////////////////////////////////////////////////////////////////////////////////
//			EnterButton.setOnMouseEntered(event -> BattleScene.BattleDisplay(EnterButton, primaryStage));
			////////////////////////////////////////////////////////////////////////////////
			BattleScene.BattleDisplay(EnterButton, primaryStage);
			
			primaryStage.setTitle(TITLE);
			primaryStage.show();
			
		} catch (FileNotFoundException e) {
			
			System.out.println("File cannot be reached");
			e.printStackTrace();
			System.exit(0);
		}
		
	}

	
	

}
