
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class UniverseDex extends Application {
	public final static String POKEMON_DATABASE_PATH = "./src/data/pokemon.csv"; // SWITCH POKEMON DATABASE PATH LINE
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
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		Map<Integer, Pokemon> pokemonMap = new HashMap<>();
		
		int place = 1;
		int looking = 1;
		String currentLine;
		File f = new File(POKEMON_DATABASE_PATH);
		
		try {
			Scanner s = new Scanner(f);
			
			
			String [] store;
			while(s.hasNextLine()) {
				
				currentLine = s.nextLine();
				store = readnSplit(currentLine);
				Pokemon Pokemon = new Pokemon(store);
				pokemonMap.put(Pokemon.order, Pokemon);
				
				place++;
			}
	        
	        PokedexMenu.pokedexDisplay(primaryStage, pokemonMap);

			primaryStage.show();
			
		} catch (FileNotFoundException e) {
			
			System.out.println("File cannot be reached");
			e.printStackTrace();
			System.exit(0);
		}
		
	}

	
	

}