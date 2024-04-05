import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class UniverseDex extends Application {
	public final static String FILEPATH = "./src/data/pokemon.csv"; // TODO: Replace parameter later with actual finished filePath
	public final static String ALTSPATH = "./src/data/altForms_1.csv";
	public final static String MEGAALTSPATH = "./src/data/megas.csv";
	public final static String ALOLAALTSPATH = "./src/data/altForms_1.cvs";
	public static final String TITLE = "UniverseDex";
	public static int totalTemps = countTemps(FILEPATH);
	public static final int NUMS_COLS = 5;
	public static final int PER_ROW = 5;
	
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
                lineCount++;
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("File could not be loaded.");
        }
        return lineCount;
    }
	
	
	
	/**
	 * Returns the color (hex code)/symbol for the Pokemon type (as a string) provided.
	 * The Dictionary named "typing" will be the library holding the data (keys and values).
	 * @param type
	 * @return typing.get(type)
	 */
	public static String typeMatch(String type) {
		Dictionary<String, String> typing = new Hashtable<>();
		
		typing.put("normal", "AAB09F");
		typing.put("fire", "EE8130");
		typing.put("water", "6390F0");
		typing.put("electric", "F7D02C");
		typing.put("grass", "7AC74C");
		typing.put("ice", "96D9D6");
		typing.put("fighting", "C22E28");
		typing.put("poison", "A33EA1");
		typing.put("ground", "E2BF65");
		typing.put("flying", "A98FF3");
		typing.put("psychic", "F95587");
		typing.put("bug", "A6B91A");
		typing.put("rock", "B6A136");
		typing.put("ghost", "735797");
		typing.put("dragon", "6F35FC");
		typing.put("dark", "58535A"); // 736c75
		typing.put("steel", "B7B7CE");
		typing.put("fairy", "D685AD");
		
		
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
		
        String[] myArray = null;
        if (line != null) {
        	line.replaceAll(" ", "");
            myArray = line.split(",");
        }
        return myArray;
    }
	
	public static Button createButton(Pokemon p) {
		Button b = new Button();
		
		// TODO: Button layout and functionality. Add your code here, Jon.
		
		return b;
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	
	}
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		Map<Integer, Pokemon> pokemonMap = new HashMap<>();
		HashSet <AlternateForms> altForms = new HashSet();
		
		
		
		//Hashset Construction
		File aForms = new File(ALTSPATH);
		File megaForms = new File(MEGAALTSPATH);
		File alolaForms = new File(ALOLAALTSPATH);
		Scanner altScan = new Scanner(aForms);
		Scanner megaAlts = new Scanner(megaForms);
		Scanner alolanAlts = new Scanner(alolaForms);
		
		
		String [] altSt;
		String altFormsLine;
		
		
		while(altScan.hasNext()) {
			altFormsLine = altScan.nextLine();
			altSt = readnSplit(altFormsLine);
			AlternateForms AlternateForms = new AlternateForms(altSt);
			altForms.add(AlternateForms);
			
			
		}
		
		
		while(megaAlts.hasNextLine()) {
			altFormsLine = megaAlts.nextLine();
			altSt  = readnSplit(altFormsLine);
			AlternateForms AlternateForms = new AlternateForms(altSt);
			altForms.add(AlternateForms);
		}
		
		while(alolanAlts.hasNextLine()) {
			altFormsLine = alolanAlts.nextLine();
			altSt = readnSplit(altFormsLine);
			AlternateForms AlternateForms = new AlternateForms(altSt);
			altForms.add(AlternateForms);
		}
		
		
		int current = 0;
		int place = 1;
		int rowIndex = 0;
		int columIndex = 0;
		int looking = 1;
		String currentLine;
		File f = new File(FILEPATH);
		
		try {
			Scanner s = new Scanner(f);
			// Initialize gridpane and it's dimensions
			GridPane display = new GridPane();
			display.setPadding(new Insets(10));
			display.setHgap(10);
			display.setVgap(10);
			
			// Set colum constraint
			for (int i = 0; i < NUMS_COLS; i++) {
	            ColumnConstraints column = new ColumnConstraints();
	            column.setPercentWidth(100.0 / NUMS_COLS);
	            display.getColumnConstraints().add(column);
	        }
			// was there an ;
			String [] store;
			while(s.hasNextLine()) {
				
				currentLine = s.nextLine();
				store = readnSplit(currentLine);
				Pokemon Pokemon = new Pokemon(store);
				pokemonMap.put(place, Pokemon);
				
				for(AlternateForms p: altForms) {
					if(p.NID == pokemonMap.get(place).NID) {
						pokemonMap.get(place).pokeAlts.add(p);
					}
				}
				place++;
			}
			
			while(looking < pokemonMap.size()) {
				
				int blooking = looking;
				String bName = pokemonMap.get(looking).name;
				String bColor = typeMatch(pokemonMap.get(looking).typeOne);
				String bImage = pokemonMap.get(looking).image;
				
				
				
				// TODO: (JON) ADD THINGS TO THE BUTTON
				
				
				Button b = createButton(pokemonMap.get(blooking));
				
				display.add(b, columIndex, rowIndex);
				columIndex++;
				
				if(columIndex == NUMS_COLS) {
					columIndex = 0;
					rowIndex++;
				}
				
				if(looking % PER_ROW == PER_ROW - 1) {
					display.getRowConstraints().add(new RowConstraints()); // adds a new row
				}
				
				looking++;
			}
			
			
			Scene primary = new Scene(display, primaryStage.getWidth(), primaryStage.getHeight());
			primaryStage.setScene(primary);
			primaryStage.setTitle(TITLE);
			primaryStage.show();
			
			
		} catch (FileNotFoundException e) {
			
			
			System.out.println("File cannot be reached");
			e.printStackTrace();
			System.exit(0);
		}
		
		
	}
	
	

}
