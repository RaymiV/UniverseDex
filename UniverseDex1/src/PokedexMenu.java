import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class PokedexMenu {

	public static final Image icon = new Image("https://archives.bulbagarden.net/media/upload/9/98/Key_Rotom_Pok%C3%A9dex_Sprite.png");
    static String firstPokemon = "";
    static String secondPokemon = "";
    static String thirdPokemon = "";
    
    static StackPane root = new StackPane();
    static Button b = new Button(); 
    
    static Button displayPane = new Button();
    static Button platformPane = new Button();
    static Button type1Display = new Button();
    static Button type2Display = new Button();
    static Button infographics = new Button();
    static Button characterInfo = new Button();
//    static Button displayBackPane = new Button();
//    static Button displayShinyPane = new Button();
    
    static Button firstCheckmark = new Button();
    static Button secondCheckmark = new Button();
    static Button thirdCheckmark = new Button();
	static Button randomizeButton = new Button();
	static Button clearButton = new Button();
	static Button enterBattle = new Button();
	static String clearItem = "";
	
	static Stage searchStage = new Stage();
	
	public static void pokedexDisplay(Stage primaryStage, Map<Integer, Pokemon> pokemonMap) {
		
		root.setStyle("-fx-background-color: #222222; -fx-border-color: #222222");
        
        Text resultCounter = new Text();
        resultCounter.setStyle(
				"-fx-fill: white;"
				+ "-fx-font: bold 18pt \"Lucida Sans Typewriter\"; ");
        
		resultCounter.setTranslateX(-400);
		resultCounter.setTranslateY(250);
	
        FlowPane pokemonList = new FlowPane(Orientation.HORIZONTAL, 50, 5); 
        pokemonList.setStyle("-fx-background-color: #222222; -fx-border-color: #222222");
        // -fx-background-image: url(); -fx-background-size: 2000; 
        pokemonList.setPadding(new Insets(80, 0, 0, 1000)); // (top/right/bottom/left)
        pokemonList.setAlignment(Pos.TOP_RIGHT);
        
		ScrollPane scrollPane = new ScrollPane(pokemonList);
		scrollPane.setFitToWidth(true);
		scrollPane.setFitToHeight(true);
		
		
        searchMenu(pokemonMap, pokemonList, resultCounter);
		
		// Title Text //
		Text titleText = new Text("UniverseDEX");
        titleText.setStyle(
				"-fx-fill: white;"
				+ "-fx-font: bold 60pt \"Arial\"; ");
        titleText.setTextAlignment(TextAlignment.CENTER);
        titleText.setTranslateY(-250);
        
        // Credit Text //
        Text creditText = new Text("Jon & Raymi");
        creditText.setStyle(
				"-fx-fill: white;"
				+ "-fx-font: bold 40pt \"Arial\"; ");
        creditText.setTextAlignment(TextAlignment.CENTER);
        creditText.setTranslateY(-150);
        
        Button versionBox = new Button();
        versionBox.setMinSize(100, 400);
        versionBox.setTranslateY(100);
        versionBox.setText("Version 2.5: Adding Battle Scenes! \nVersion 2.4: Added Teams & Randomizer \nVersion 2.0: Reconstructed pokedex display \nVersion 1.0: Created first pokedex display");
		versionBox.setStyle(
				  "-fx-text-fill: #ffffff; "			// Text Color
				+ "-fx-font: bold 15pt \"Roboto\"; "	// Text Size & Font
				+ "-fx-background-color: #222222; "		// Background Color
				+ "-fx-background-radius: 10; "			// Background Radius
				+ "-fx-border-color: #ffffff; "			// Background Color
				+ "-fx-border-radius: 10;  "			// Border Radius
				+ "-fx-border-width: 3;");				// Border Width
        
    			root.getChildren().setAll(
    					titleText, 
    					creditText,
    					versionBox
    	);
        
    			
    	randomizeButton.setOnMouseEntered(e -> {
    		randomizeButton.setStyle(
  				  "-fx-text-fill: #ffffff; "			// Text Color
  				+ "-fx-font: bold 15pt \"Roboto\"; "	// Text Size & Font
  				+ "-fx-background-color: #222222; "		// Background Color
  				+ "-fx-background-radius: 10; "			// Background Radius
  				+ "-fx-border-color: #ffff00; "			// Background Color
  				+ "-fx-border-radius: 10;  "			// Border Radius
  				+ "-fx-border-width: 3;");				// Border Width
    		
    	});		
    	
    	randomizeButton.setOnMouseExited(e -> {
    		randomizeButton.setStyle(
  				  "-fx-text-fill: #ffffff; "			// Text Color
  				+ "-fx-font: bold 15pt \"Roboto\"; "	// Text Size & Font
  				+ "-fx-background-color: #222222; "		// Background Color
  				+ "-fx-background-radius: 10; "			// Background Radius
  				+ "-fx-border-color: #ffffff; "			// Background Color
  				+ "-fx-border-radius: 10;  "			// Border Radius
  				+ "-fx-border-width: 3;");				// Border Width
    		
    	});		
    	
    	randomizeButton.setOnAction( e -> {
    		randomizer(pokemonMap);
		});
		/////////////////////////////////////////////////////////////////////////////////////////
    	clearButton.setOnMouseEntered(e -> {
    		clearButton.setStyle(
  				  "-fx-text-fill: #ffffff; "			// Text Color
  				+ "-fx-font: bold 15pt \"Roboto\"; "	// Text Size & Font
  				+ "-fx-background-color: #222222; "		// Background Color
  				+ "-fx-background-radius: 10; "			// Background Radius
  				+ "-fx-border-color: #ffff00; "			// Background Color
  				+ "-fx-border-radius: 10;  "			// Border Radius
  				+ "-fx-border-width: 3;");				// Border Width
    		
    	});		
    	
    	clearButton.setOnMouseExited(e -> {
    		clearButton.setStyle(
  				  "-fx-text-fill: #ffffff; "			// Text Color
  				+ "-fx-font: bold 15pt \"Roboto\"; "	// Text Size & Font
  				+ "-fx-background-color: #222222; "		// Background Color
  				+ "-fx-background-radius: 10; "			// Background Radius
  				+ "-fx-border-color: #ffffff; "			// Background Color
  				+ "-fx-border-radius: 10;  "			// Border Radius
  				+ "-fx-border-width: 3;");				// Border Width
    		
    	});		
    	
    	clearButton.setOnAction(e -> {
    		clearItem = "";
    		for(int search = 1; search < pokemonMap.size(); search++) {
    		clearTeamizer(pokemonMap.get(search), clearItem);
			}
		});
    	
    	firstCheckmark.setOnAction(e -> {
    		clearItem = "First";
			for(int search = 1; search < pokemonMap.size(); search++) {
	    		clearTeamizer(pokemonMap.get(search), clearItem);
			}
    	});
    	
    	secondCheckmark.setOnAction(e -> {
    		clearItem = "Second";
			for(int search = 1; search < pokemonMap.size(); search++) {
	    		clearTeamizer(pokemonMap.get(search), clearItem);
			}
    	});
    	
    	thirdCheckmark.setOnAction(e -> {
    		clearItem = "Third";
			for(int search = 1; search < pokemonMap.size(); search++) {
	    		clearTeamizer(pokemonMap.get(search), clearItem);
			}
    	});
		
    	enterBattle.setOnAction(e -> BattleScene.BattleDisplay(primaryStage, searchStage, pokemonMap, firstPokemon, secondPokemon, thirdPokemon));

        ///////////////////////////////////////////////////
		
		Scene pokedexScene = new Scene(root, 600, 600);

		primaryStage.setScene(pokedexScene); // Start-Up
		
		primaryStage.setResizable(false);
		primaryStage.setMinWidth(1200);
		primaryStage.setMinHeight(100);
//		primaryStage.getIcons().add(icon);
		
        DisplayImages.StartUpDisplay(displayPane, platformPane, type1Display, type2Display, infographics, characterInfo);
	}
	
	public static Button PokedexTabs(Pokemon p) {
		// Button displayPane, Button type1, Button type2, Button infographics, Button characterInfo, Button displayBackPane, Button displayShinyPane
		String myString = "" + p.order + " - " + p.name;
		Button b = new Button();
		b.setText(myString);
//		b.setTextAlignment(TextAlignment.CENTER);
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
//		b.setAlignment(Pos.TOP_LEFT);
		if(p.selected.equals("Selected")) {
			b.setStyle(
					  "-fx-text-fill: #ffffff; "			// Text Color
					+ "-fx-font: bold 15pt \"Roboto\"; "	// Text Size & Font
					+ "-fx-background-color: #45F248; "		// Background Color
					+ "-fx-background-radius: 35; "			// Background Radius
					+ "-fx-border-color: #0074B7; "			// Background Color
					+ "-fx-border-radius: 25;  "			// Border Radius
					+ "-fx-border-width: 5;");				// Border Width
//			return b;
		} else if(p.selected.equals("Not Selected")) {
			b.setStyle(
					  "-fx-text-fill: #ffffff; "			// Text Color
					+ "-fx-font: bold 15pt \"Roboto\"; "	// Text Size & Font
					+ "-fx-background-color: #000000; "		// Background Color
					+ "-fx-background-radius: 35; "			// Background Radius
					+ "-fx-border-color: #0074B7; "			// Background Color
					+ "-fx-border-radius: 25;  "			// Border Radius
					+ "-fx-border-width: 5;");				// Border Width
//			return b;
		}
		
		System.out.println(p.name + " matches");

		
//		String icon = "";
//		
//		if(p.name.toLowerCase().contains("mega") ) {
//			icon = "https://www.pokencyclopedia.info/sprites/menu-icons/ico_3ds/ico_3ds_" + p.order + "-mega.png";
//		} else if(p.order < 10) {
//		 icon = "https://www.pokencyclopedia.info/sprites/menu-icons/ico_3ds/ico_3ds_00" + p.order + ".png";
//		} else if(p.order >= 10 && p.order <= 99) {
//			icon = "https://www.pokencyclopedia.info/sprites/menu-icons/ico_3ds/ico_3ds_0" + p.order + ".png";
//		} else if(p.order >= 100) {
//			icon = "https://www.pokencyclopedia.info/sprites/menu-icons/ico_3ds/ico_3ds_" + p.order + ".png";
//		} else if(p.order >= 810) {
//			icon = "https://github.com/msikma/pokesprite/blob/master/pokemon-gen8/shiny/" + p.name.toLowerCase() + ".png";
//		}
//		
//		Image iconImage = new Image(icon, 100, 100, true, true);
//		ImageView iconView = new ImageView(iconImage);
//		b.setGraphic(iconView);
//		b.setContentDisplay(ContentDisplay.BOTTOM);
		
		b.setOnAction(event ->{
			if(p.selected.equals("Selected")) {
				p.selected = "Not Selected";
				checkmarkDisplay(p);
				return;
			} else {

			p.selected = "Selected";
			
			b.setStyle(
					  "-fx-text-fill: #ffffff; "			// Text Color
					+ "-fx-font: bold 15pt \"Roboto\"; "	// Text Size & Font
					+ "-fx-background-color: #45F248; "		// Background Color
					+ "-fx-background-radius: 25; "			// Background Radius
					+ "-fx-border-color: #ffff00; "			// Background Color
					+ "-fx-border-radius: 25;  "			// Border Radius
					+ "-fx-border-width: 5;");				// Border Width
			checkmarkDisplay(p);
			}
		});	
		
		b.setOnMouseEntered(event ->{
			DisplayImages.EnterMouseDisplay(p, b, displayPane, type1Display, type2Display, infographics, characterInfo);
		});
		
		b.setOnMouseExited(event ->{
			DisplayImages.LeaveMouseDisplay(p, b, displayPane, myString);
		});
//		
		return b;
	}
	
	public static void checkmarkDisplay(Pokemon p) {
		
		String icon = "";
		
		if(p.selected.equals("Selected")) {
//			icon = "https://raw.githubusercontent.com/msikma/pokesprite/master/pokemon-gen7x/regular/"+ p.name +".png";
//		if(p.name.toLowerCase().contains("mega") ) {
//			icon = "https://www.pokencyclopedia.info/sprites/menu-icons/ico_3ds/ico_3ds_" + p.order + "-mega.png";
//		} else
		if(p.order < 10) {
		 icon = "https://www.pokencyclopedia.info/sprites/menu-icons/ico-a_old/ico-a_old_00" + p.order + ".gif";
		} else if(p.order >= 10 && p.order <= 99) {
			icon = "https://www.pokencyclopedia.info/sprites/menu-icons/ico-a_old/ico-a_old_0" + p.order + ".gif";
		} else if(p.order >= 100) {
			icon = "https://www.pokencyclopedia.info/sprites/menu-icons/ico-a_old/ico-a_old_" + p.order + ".gif";
		} 
//		else if(p.order >= 810) {
//			icon = "https://github.com/msikma/pokesprite/blob/master/pokemon-gen8/shiny/" + p.name.toLowerCase() + ".png";
//		}
		////////////////// Selected Menu ////////////////////////
		
		Image iconImage = new Image(icon, 80, 80, true, true);
		ImageView iconView = new ImageView(iconImage);
		
		if(firstPokemon == "") {
			firstPokemon = p.name;
			firstCheckmark.setGraphic(iconView);
			firstCheckmark.setContentDisplay(ContentDisplay.CENTER);
			
		} else if(secondPokemon == "") {
			secondPokemon = p.name;
			secondCheckmark.setGraphic(iconView);
			secondCheckmark.setContentDisplay(ContentDisplay.CENTER);
			
		} else if(thirdPokemon == "") {
			thirdPokemon = p.name;
			thirdCheckmark.setGraphic(iconView);
			thirdCheckmark.setContentDisplay(ContentDisplay.CENTER);
			
		} else if(firstPokemon != "" || secondPokemon != "" || thirdPokemon != "") {
			p.selected = "Not Selected";
		}
		
		} else if(p.selected.equals("Not Selected")) {
			icon = "https://www.inpixio.com/remove-background/images/new/icon-file.svg";
			
			Image iconImage = new Image(icon, 80, 80, true, true);
			ImageView iconView = new ImageView(iconImage);
			
			if(firstPokemon == p.name) {
				firstPokemon = "";
				firstCheckmark.setGraphic(iconView);
				
			} else if(secondPokemon == p.name) {
				secondPokemon = "";
				secondCheckmark.setGraphic(iconView);
				
			} else if(thirdPokemon == p.name) {
				thirdPokemon = "";
				thirdCheckmark.setGraphic(iconView);
				
			}
		}

	}
	
	public static void searchMenu(Map<Integer, Pokemon> pokemonMap, FlowPane pokemonList, Text resultCounter) {
		
		
		////////////////// SEARCH MENU COMPONENTS ////////////////////////
		TextField textField = new TextField("Search");
        textField.setMaxSize(550, 50);
        textField.setStyle(
				"-fx-text-fill: darkgray;"
				+ "-fx-background-color: #222222;"
				+ "-fx-background-radius: 15;"
				+ "-fx-border-color: #ffffff;"
				+ "-fx-border-radius: 15;"
				+ "-fx-border-width: 3;"
				+ "-fx-font: bold 15pt \"Lucida Sans Typewriter\"; ");
        textField.setTranslateY(-0);
		
        // Search Window //
		StackPane searchWindow = new StackPane();
		searchWindow.setStyle("-fx-background-color: #222222; -fx-border-color: #222222");
		searchWindow.setAlignment(Pos.CENTER);
		
		// Checkmark Boxes //
		firstCheckmark.setStyle(
				"-fx-text-fill: darkgray;"
				+ "-fx-background-color: #222222;"
				+ "-fx-background-radius: 15;"
				+ "-fx-border-color: #ffffff;"
				+ "-fx-border-radius: 15;"
				+ "-fx-border-width: 3");
		firstCheckmark.setMinSize(110, 110);
		firstCheckmark.setTranslateY(-100);
		firstCheckmark.setTranslateX(-30);
		
		secondCheckmark.setStyle(
				"-fx-text-fill: darkgray;"
				+ "-fx-background-color: #222222;"
				+ "-fx-background-radius: 15;"
				+ "-fx-border-color: #ffffff;"
				+ "-fx-border-radius: 15;"
				+ "-fx-border-width: 3");
		secondCheckmark.setMinSize(110, 110);
		secondCheckmark.setTranslateY(-100);
		secondCheckmark.setTranslateX(90);
		
		thirdCheckmark.setStyle(
				"-fx-text-fill: darkgray;"
				+ "-fx-background-color: #222222;"
				+ "-fx-background-radius: 15;"
				+ "-fx-border-color: #ffffff;"
				+ "-fx-border-radius: 15;"
				+ "-fx-border-width: 3");
		thirdCheckmark.setMinSize(110, 110);
		thirdCheckmark.setTranslateY(-100);
		thirdCheckmark.setTranslateX(210);
		
		// Randomize Team Button //
		randomizeButton.setMinSize(20, 50);
		randomizeButton.setTranslateY(-130);
		randomizeButton.setTranslateX(-200);
		randomizeButton.setText("Randomize Team");
		randomizeButton.setStyle(
				  "-fx-text-fill: #ffffff; "			// Text Color
				+ "-fx-font: bold 15pt \"Roboto\"; "	// Text Size & Font
				+ "-fx-background-color: #222222; "		// Background Color
				+ "-fx-background-radius: 10; "			// Background Radius
				+ "-fx-border-color: #ffffff; "			// Background Color
				+ "-fx-border-radius: 10;  "			// Border Radius
				+ "-fx-border-width: 3;");				// Border Width
		
		// Clear Team Button //
		clearButton.setMinSize(20, 50);
		clearButton.setTranslateY(-70);
		clearButton.setTranslateX(-200);
		clearButton.setText("Clear Team");
		clearButton.setStyle(
				  "-fx-text-fill: #ffffff; "			// Text Color
				+ "-fx-font: bold 15pt \"Roboto\"; "	// Text Size & Font
				+ "-fx-background-color: #222222; "		// Background Color
				+ "-fx-background-radius: 10; "			// Background Radius
				+ "-fx-border-color: #ffffff; "			// Background Color
				+ "-fx-border-radius: 10;  "			// Border Radius
				+ "-fx-border-width: 3;");				// Border Width
		
		// Enter Battle Button //
		enterBattle.setMinSize(20, 50);
		enterBattle.setTranslateY(100);
		enterBattle.setTranslateX(-20);
		enterBattle.setText("Enter Battle");
		enterBattle.setStyle(
				  "-fx-text-fill: #ffffff; "			// Text Color
				+ "-fx-font: bold 15pt \"Roboto\"; "	// Text Size & Font
				+ "-fx-background-color: #222222; "		// Background Color
				+ "-fx-background-radius: 10; "			// Background Radius
				+ "-fx-border-color: #ffffff; "			// Background Color
				+ "-fx-border-radius: 10;  "			// Border Radius
				+ "-fx-border-width: 3;");				// Border Width
        ///////////////////////////////////////////////////
		VBox a = new VBox();
		a.setStyle(
				"-fx-background-color: #222222;"
			  + " -fx-border-color: #222222"
				);
    	
		a.getChildren().setAll(resultCounter, pokemonList);
		////////////////// EMPTY SEARCH BAR INTERACTION ////////////////////////
		
        textField.setOnMouseClicked(event -> {
        	textField.setText("");
        });
        
		////////////////// ENTER SEARCH BAR INTERACTION ///////////////////////
        
        textField.setOnKeyPressed(event -> {
			
        	  if( event.getCode() == KeyCode.ENTER ) {
        	if(textField.getText().contains("")) {
    			int resultCount = 0;
    			pokemonList.getChildren().clear();
    			for(int search = 1; search < pokemonMap.size(); search++) {
    				if(pokemonMap.get(search).name.toLowerCase().contains(textField.getText())) {
    				b = PokedexTabs(pokemonMap.get(search));
    				pokemonList.getChildren().add(b);
    				resultCount++;
					}
    			}
    	        resultCounter.setText(resultCount + " Results");
        	}
			
    		////////////////// DISPLAY POKEDEX ////////////////////////
			ScrollPane scrollPane = new ScrollPane(a);
			
  			scrollPane.setFitToWidth(true);
			scrollPane.setFitToHeight(true);
        	
			root.getChildren().setAll(
					scrollPane,
					platformPane,
					displayPane,
					type1Display,
					type2Display,
					infographics,
					characterInfo
					);
          }
        });
        
		////////////////// DISPLAY WINDOW ////////////////////////
        
		searchWindow.getChildren().setAll(
				randomizeButton,
				clearButton,
				textField,
				firstCheckmark,
				secondCheckmark,
				thirdCheckmark,
				enterBattle);
		
		Scene searchScene = new Scene(searchWindow, 600, 400);
		
		searchStage.setScene(searchScene);
		searchStage.setResizable(false);
		
		searchStage.show();
		
	}


	public static void randomizer(Map<Integer, Pokemon> pokemonMap) {
		for(int search = 1; search < pokemonMap.size(); search++) {
    		clearTeamizer(pokemonMap.get(search), clearItem);
			}
		
		Random rand = new Random();
		int random1 = rand.nextInt(pokemonMap.size());
		int random2 = rand.nextInt(pokemonMap.size());
		int random3 = rand.nextInt(pokemonMap.size());
		
		String firstIcon = "";
		String secondIcon = "";
		String thirdIcon = "";
		//////////////////Randomizer ////////////////////////
		int randNum1 = random1;
		firstPokemon = pokemonMap.get(randNum1).name;
		pokemonMap.get(randNum1).selected = "Selected";
		System.out.println(firstPokemon);
		int randNum2 = random2;
		secondPokemon = pokemonMap.get(randNum2).name;
		pokemonMap.get(randNum2).selected = "Selected";
		System.out.println(secondPokemon);
		int randNum3 = random3;
		thirdPokemon = pokemonMap.get(randNum3).name;
		pokemonMap.get(randNum3).selected = "Selected";
		System.out.println(thirdPokemon);
		
		if(pokemonMap.get(randNum1).order < 10) {
			firstIcon = "https://www.pokencyclopedia.info/sprites/menu-icons/ico-a_old/ico-a_old_00" + pokemonMap.get(randNum1).order + ".gif";
		} else if(pokemonMap.get(randNum1).order >= 10 && pokemonMap.get(randNum1).order <= 99) {
			firstIcon = "https://www.pokencyclopedia.info/sprites/menu-icons/ico-a_old/ico-a_old_0" + pokemonMap.get(randNum1).order + ".gif";
		} else if(pokemonMap.get(randNum1).order >= 100) {
			firstIcon = "https://www.pokencyclopedia.info/sprites/menu-icons/ico-a_old/ico-a_old_" + pokemonMap.get(randNum1).order + ".gif";
		} 
		
		if(pokemonMap.get(randNum2).order < 10) {
			secondIcon = "https://www.pokencyclopedia.info/sprites/menu-icons/ico-a_old/ico-a_old_00" + pokemonMap.get(randNum2).order + ".gif";
		} else if(pokemonMap.get(randNum2).order >= 10 && pokemonMap.get(randNum2).order <= 99) {
			secondIcon = "https://www.pokencyclopedia.info/sprites/menu-icons/ico-a_old/ico-a_old_0" + pokemonMap.get(randNum2).order + ".gif";
		} else if(pokemonMap.get(randNum2).order >= 100) {
			secondIcon = "https://www.pokencyclopedia.info/sprites/menu-icons/ico-a_old/ico-a_old_" + pokemonMap.get(randNum2).order + ".gif";
		}
		
		if(pokemonMap.get(randNum3).order < 10) {
			thirdIcon = "https://www.pokencyclopedia.info/sprites/menu-icons/ico-a_old/ico-a_old_00" + pokemonMap.get(randNum3).order + ".gif";
		} else if(pokemonMap.get(randNum3).order >= 10 && pokemonMap.get(randNum3).order <= 99) {
			thirdIcon = "https://www.pokencyclopedia.info/sprites/menu-icons/ico-a_old/ico-a_old_0" + pokemonMap.get(randNum3).order + ".gif";
		} else if(pokemonMap.get(randNum3).order >= 100) {
			thirdIcon = "https://www.pokencyclopedia.info/sprites/menu-icons/ico-a_old/ico-a_old_" + pokemonMap.get(randNum3).order + ".gif";
		}

		Image firstIconImage = new Image(firstIcon, 80, 80, true, true);
		ImageView firstIconView = new ImageView(firstIconImage);
		
		Image secondIconImage = new Image(secondIcon, 80, 80, true, true);
		ImageView secondIconView = new ImageView(secondIconImage);
		
		Image thirdIconImage = new Image(thirdIcon, 80, 80, true, true);
		ImageView thirdIconView = new ImageView(thirdIconImage);

		firstCheckmark.setGraphic(firstIconView);
		secondCheckmark.setGraphic(secondIconView);
		thirdCheckmark.setGraphic(thirdIconView);
		
		PokedexTabs(pokemonMap.get(randNum1));
		PokedexTabs(pokemonMap.get(randNum2));
		PokedexTabs(pokemonMap.get(randNum3));
	}

	public static void clearTeamizer(Pokemon p, String clearItem) {
		
		//////////////////Randomizer ////////////////////////
		
	if(clearItem.equals("")) {
		if(p.selected.equals("Selected")) {
		if(p.name == firstPokemon) {
			firstPokemon = "";
			p.selected = "Not Selected";
		} else if(p.name == secondPokemon) {
			secondPokemon = "";
			p.selected = "Not Selected";
		} else if(p.name == thirdPokemon) {
			thirdPokemon = "";
			p.selected = "Not Selected";
		}
		
		String clearIcon = "https://www.inpixio.com/remove-background/images/new/icon-file.svg";

		Image clearImage = new Image(clearIcon, 80, 80, true, true);
		ImageView clearView = new ImageView(clearImage);

		firstCheckmark.setGraphic(clearView);
		secondCheckmark.setGraphic(clearView);
		thirdCheckmark.setGraphic(clearView);
		
		b.setStyle(
				  "-fx-text-fill: #ffffff; "			// Text Color
				+ "-fx-font: bold 15pt \"Roboto\"; "	// Text Size & Font
				+ "-fx-background-color: #000000; "		// Background Color
				+ "-fx-background-radius: 35; "			// Background Radius
				+ "-fx-border-color: #0074B7; "			// Background Color
				+ "-fx-border-radius: 25;  "			// Border Radius
				+ "-fx-border-width: 5;");				// Border Width
		}
	} else if (clearItem.equals("First")) {
		if(firstPokemon != p.name) {
			return;
		}
			if(p.selected.equals("Selected")) {
		firstPokemon = "";
		
		p.selected = "Not Selected";
		
		String clearIcon = "https://www.inpixio.com/remove-background/images/new/icon-file.svg";

		Image clearImage = new Image(clearIcon, 80, 80, true, true);
		ImageView clearView = new ImageView(clearImage);

		firstCheckmark.setGraphic(clearView);
		
		b.setStyle(
				  "-fx-text-fill: #ffffff; "			// Text Color
				+ "-fx-font: bold 15pt \"Roboto\"; "	// Text Size & Font
				+ "-fx-background-color: #000000; "		// Background Color
				+ "-fx-background-radius: 35; "			// Background Radius
				+ "-fx-border-color: #0074B7; "			// Background Color
				+ "-fx-border-radius: 25;  "			// Border Radius
				+ "-fx-border-width: 5;");				// Border Width
		
		}
	} else if (clearItem.equals("Second")) {
		if(secondPokemon != p.name) {
			return;
		}
			if(p.selected.equals("Selected")) {
			secondPokemon = "";
			
			p.selected = "Not Selected";
			
			String clearIcon = "https://www.inpixio.com/remove-background/images/new/icon-file.svg";

			Image clearImage = new Image(clearIcon, 80, 80, true, true);
			ImageView clearView = new ImageView(clearImage);

			secondCheckmark.setGraphic(clearView);
			
			b.setStyle(
					  "-fx-text-fill: #ffffff; "			// Text Color
					+ "-fx-font: bold 15pt \"Roboto\"; "	// Text Size & Font
					+ "-fx-background-color: #000000; "		// Background Color
					+ "-fx-background-radius: 35; "			// Background Radius
					+ "-fx-border-color: #0074B7; "			// Background Color
					+ "-fx-border-radius: 25;  "			// Border Radius
					+ "-fx-border-width: 5;");				// Border Width
			
		}
	} else if (clearItem.equals("Third")) {
		if(thirdPokemon != p.name) {
			return;
		}
		if(p.selected.equals("Selected")) {
			thirdPokemon = "";
			
			p.selected = "Not Selected";
			
			String clearIcon = "https://www.inpixio.com/remove-background/images/new/icon-file.svg";

			Image clearImage = new Image(clearIcon, 80, 80, true, true);
			ImageView clearView = new ImageView(clearImage);

			thirdCheckmark.setGraphic(clearView);
			
			b.setStyle(
					  "-fx-text-fill: #ffffff; "			// Text Color
					+ "-fx-font: bold 15pt \"Roboto\"; "	// Text Size & Font
					+ "-fx-background-color: #000000; "		// Background Color
					+ "-fx-background-radius: 35; "			// Background Radius
					+ "-fx-border-color: #0074B7; "			// Background Color
					+ "-fx-border-radius: 25;  "			// Border Radius
					+ "-fx-border-width: 5;");				// Border Width
			
		}
			}
	clearItem = "";
	}
}
