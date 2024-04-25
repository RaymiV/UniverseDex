import java.math.BigDecimal;
import java.util.Map;

import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class BattleScene {
	
	static StackPane root = new StackPane();
	static Button menu = new Button();
	static Button pokemonList = new Button("Pokemon");
	
    static Button userPlatform = new Button();
    static Button userPokemon = new Button();
    static Text userName = new Text();
    static Text userLevel = new Text("Lv.50");
    static Button userStats = new Button();
    static ProgressBar userProgressBar = new ProgressBar(1.0);
    static BigDecimal userProgress = new BigDecimal(String.format("%.2f", 0.0).replace(",", "."));
    static Text userHP = new Text(Math.round(userProgressBar.getProgress() * 100) + "/100");
	
    static Button enemyPlatform = new Button();
    static Button enemyPokemon = new Button();
    static Text enemyName = new Text();
    static Text enemyLevel = new Text("Lv.50");
    static Button enemyStats = new Button();
    static ProgressBar enemyProgressBar = new ProgressBar(1.0);
    static BigDecimal enemyProgress = new BigDecimal(String.format("%.2f", 0.0).replace(",", "."));
    static Text enemyHP = new Text(Math.round(enemyProgressBar.getProgress() * 100) + "/100");
    
    static Button Pokemon1Icon = new Button();
	static Button Pokemon2Icon = new Button();
	static Button Pokemon3Icon = new Button();
	static Button Enemy1Icon = new Button();
	static Button Enemy2Icon = new Button();
	static Button Enemy3Icon = new Button();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// User Sprites and User Stats Health Bar
	public static void userStartUpDisplay(Map<Integer, Pokemon> pokemonMap, String firstPokemon, String secondPokemon, String thirdPokemon) {
		
        ///// USER PLATFORM /////
        userPlatform.setStyle("-fx-background-color: transparent");
		
        String platform = "https://static.wikia.nocookie.net/capx/images/e/ec/Basic_Grass.png/revision/latest?cb=20130620230433";
        Image platformView = new Image(platform, 700, 700, true, true);
		ImageView platformDisplay = new ImageView(platformView);
		userPlatform.setGraphic(platformDisplay);
        platformDisplay.setTranslateX(-300);
        platformDisplay.setTranslateY(240);
        
		///// USER POKEMON /////
        userPokemon.setStyle("-fx-background-color: transparent");
        
        String userPokemonString = "";
        
//        if(pokemonMap < 10) {
//        	userPokemonString = "https://www.pokencyclopedia.info/sprites/3ds/ani-b_6/3a-b__00" + pokemonMap.get(firstPokemon).order + "__xy.gif";
//        }
        
        Image userPokemonView = new Image(userPokemonString, 700, 700, true, true);
		ImageView userPokemonDisplay = new ImageView(userPokemonView);
		userPokemon.setGraphic(userPokemonDisplay);
		userPokemonDisplay.setTranslateX(-300);
		userPokemonDisplay.setTranslateY(-00);

	    ///// STATS USER /////

		userName.setStyle(	  
				"-fx-fill: white; "
			  + "-fx-font: bold 17pt \"Lucida Console\"; ");
		
		userName.setTranslateX(360);
		userName.setTranslateY(105);
		
		userLevel.setStyle(				  
				"-fx-fill: white; "
			  + "-fx-font: bold 17pt \"Lucida Console\"; ");
		
		userLevel.setTranslateX(505);
		userLevel.setTranslateY(105);
		
        userStats.setMinSize(340, 85);
		
        userStats.setTranslateX(400);
        userStats.setTranslateY(120);
        
		userStats.setStyle(
				"-fx-background-color: #222222; "
				+ "-fx-background-radius: 0; "
				+ "-fx-border-color: #ffffff; "
				+ "-fx-border-radius: 0;  "
				+ "-fx-border-width: 3;");
		
	    ///// PROGRESS BAR USER /////
		
		userProgressBar.setMinSize(250, 20);
		userProgressBar.setTranslateX(420);
		userProgressBar.setTranslateY(135);
		
		userProgressBar.setStyle("-fx-accent: limegreen");
		
        String userMegaSymbol = "https://raw.githubusercontent.com/msikma/pokesprite/master/items/key-item/key-stone.png";
        Image userMegaSymbolView = new Image(userMegaSymbol, 45, 45, true, true);
		ImageView userMegaSymbolDisplay = new ImageView(userMegaSymbolView);
		
		userMegaSymbolDisplay.setTranslateX(-140);
		userMegaSymbolDisplay.setTranslateY(-15);
		
		userStats.setGraphic(userMegaSymbolDisplay);
		
		///// TEXT BOX 
		
		menu.setStyle(
				"-fx-text-fill: white; "
				+ "-fx-background-color: #222222; "
				+ "-fx-background-radius: 0; "
				+ "-fx-border-color: #ffffff; "
				+ "-fx-border-radius: 0;  "
				+ "-fx-border-width: 3;"
				+ "-fx-font: bold 10pt \"Lucida Console\"; ");
	}
	// Enemy Sprites and Enemy Stats Health Bar
	public static void enemyStartUpDisplay(Map<Integer, Pokemon> pokemonMap, String firstPokemon, String secondPokemon, String thirdPokemon) {
		     
        ///// ENEMY PLATFORM /////
        enemyPlatform.setStyle("-fx-background-color: transparent");
        
        String enemyPlatform1 = "https://static.wikia.nocookie.net/capx/images/e/ec/Basic_Grass.png/revision/latest?cb=20130620230433";
        Image enemyPlatformView = new Image(enemyPlatform1, 400, 400, true, true);
		ImageView enemyPlatformDisplay = new ImageView(enemyPlatformView);
		enemyPlatform.setGraphic(enemyPlatformDisplay);
		enemyPlatformDisplay.setTranslateX(300);
		enemyPlatformDisplay.setTranslateY(-0);
		
		///// ENEMY POKEMON /////

        enemyPokemon.setStyle("-fx-background-color: transparent");
        
        String enemyPokemonString = "https://www.pokencyclopedia.info/sprites/3ds/ani_6_shiny/3ani_-S_384-mega__oras.gif";
        Image enemyPokemonView = new Image(enemyPokemonString, 300, 300, true, true);
		ImageView enemyPokemonDisplay = new ImageView(enemyPokemonView);
		enemyPokemon.setGraphic(enemyPokemonDisplay);
		enemyPokemonDisplay.setTranslateX(330);
		enemyPokemonDisplay.setTranslateY(-130);
		
	    ///// ENEMY STATS /////

		enemyName.setStyle(
				"-fx-fill: white; "
			  + "-fx-font: bold 17pt \"Lucida Console\"; ");
		enemyName.setTranslateX(-450);
		enemyName.setTranslateY(-244);
		

		enemyLevel.setStyle(
				"-fx-fill: white; "
			  + "-fx-font: bold 17pt \"Lucida Console\"; ");
		enemyLevel.setTranslateX(-285);
		enemyLevel.setTranslateY(-244);
		
        enemyStats.setMinSize(345, 80);
        enemyStats.setTranslateX(-400);
        enemyStats.setTranslateY(-230);
        
        enemyStats.setStyle(
				"-fx-background-color: #222222; "
				+ "-fx-background-radius: 0; "
				+ "-fx-border-color: #ffffff; "
				+ "-fx-border-radius: 0;  "
				+ "-fx-border-width: 3;");
        
        String enemyMegaSymbol = "https://raw.githubusercontent.com/msikma/pokesprite/master/items/key-item/key-stone.png";
        Image enemyMegaSymbolView = new Image(enemyMegaSymbol, 45, 45, true, true);
		ImageView enemyMegaSymbolDisplay = new ImageView(enemyMegaSymbolView);
		
		enemyMegaSymbolDisplay.setTranslateX(-140);
		enemyMegaSymbolDisplay.setTranslateY(-15);
        
		enemyStats.setGraphic(enemyMegaSymbolDisplay);
		
	    ///// PROGRESS BAR ENEMY /////
		
		enemyProgressBar.setMinSize(250, 20);
		enemyProgressBar.setTranslateX(-380);
		enemyProgressBar.setTranslateY(-215);
		
		enemyProgressBar.setStyle("-fx-accent: limegreen");
		
		///////// ENEMY HP //////////
		enemyHP.setStyle(
		"-fx-fill: white; "
		  + "-fx-font: bold 11pt \"Lucida Console\"; ");
		enemyHP.setTranslateX(-536);
		enemyHP.setTranslateY(-215);
		
	}
	// Don't need to do this too
	public static void BattleDisplay(Stage battleStage, Stage menuStage, Map<Integer, Pokemon> pokemonMap, String firstPokemon, String secondPokemon, String thirdPokemon) {

		menu.setMaxSize(600, 175); // Width x Length
		menu.setTranslateX(300);
		menu.setTranslateY(260);
		pokemonList.setTranslateX(-500);
        root.setStyle("-fx-background-size: 1200; -fx-background-image: url(https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/2fb2821a-1406-4a1d-9b04-6668f278e944/d84e272-ad3b3161-1b6d-4dcd-ab79-cfe351168290.png/v1/fill/w_800,h_480,q_80,strp/pokemon_x_and_y_battle_city__day__background_by_phoenixoflight92_d84e272-fullview.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9NDgwIiwicGF0aCI6IlwvZlwvMmZiMjgyMWEtMTQwNi00YTFkLTliMDQtNjY2OGYyNzhlOTQ0XC9kODRlMjcyLWFkM2IzMTYxLTFiNmQtNGRjZC1hYjc5LWNmZTM1MTE2ODI5MC5wbmciLCJ3aWR0aCI6Ijw9ODAwIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmltYWdlLm9wZXJhdGlvbnMiXX0.V3f4Jbp-eR-LXUBKoiK9RxEij1-5Q_afvTyLOVrLuBk); -fx-background-color: #222222; -fx-border-color: #222222");
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        userName.setText(firstPokemon);
       
		userStartUpDisplay(pokemonMap, firstPokemon, secondPokemon, thirdPokemon);
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		enemyName.setText("Rayquaza");
		
		enemyStartUpDisplay(pokemonMap, thirdPokemon, thirdPokemon, thirdPokemon);
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		menuStartUpDisplay();
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Button versusSymbol = new Button();
        
    		versusSymbol.setStyle(
    				"-fx-background-color: transparent; ");
    		String versusIcon = "https://upload.wikimedia.org/wikipedia/commons/7/70/Street_Fighter_VS_logo.png";
            Image versusView = new Image(versusIcon, 70, 70, true, true);
    		ImageView versusDisplay = new ImageView(versusView);
    		
    		versusDisplay.setTranslateX(300); // Autoset
    		versusDisplay.setTranslateY(240); // Autoset
    		
    		versusSymbol.setGraphic(versusDisplay);
        		
		Scene sceneBattle = new Scene(root, 1200, 600); // Length x Width
		root.getChildren().addAll(
				// Display
				userPlatform,	
				userPokemon,
				enemyPlatform,
				enemyPokemon,
				// User Stats
				userStats, 		
				userName,
				userLevel,
				userProgressBar,
				
				// Enemy Stats
				enemyStats,
				enemyName,
				enemyLevel,
				enemyProgressBar,
				enemyHP,
				// Menu
				menu, 			
				Pokemon1Icon,
				Pokemon2Icon,
				Pokemon3Icon,
				Enemy1Icon,
				Enemy2Icon,
				Enemy3Icon,
				pokemonList,
				versusSymbol
				); 
		
		battleStage.setScene(sceneBattle); // Start-Up
		
		battleStage.setResizable(false);
//		battleStage.setMinWidth(600);
//		battleStage.setMinHeight(600);
		
		BottomBattleScene.BottomBattleDisplay(enemyProgressBar, enemyHP, enemyProgress, menuStage);
		
		battleStage.setTitle("Battle Scene");
		battleStage.setX(130);
		battleStage.setY(-5);
//		battleStage.show();
		
		pokemonList.setOnMouseEntered(e -> System.exit(0));
	}
	
	private static void menuStartUpDisplay() {
		/////// POKEMON 1 ICON ///////
		Pokemon1Icon.setStyle(
				"-fx-background-color: transparent; ");
		String pokemon1Icon = "https://www.pokencyclopedia.info/sprites/menu-icons/ico_3ds_shiny-recolored/ico_3ds-S_006-mega-x.png";
        Image pokemon1View = new Image(pokemon1Icon, 80, 80, true, true);
		ImageView pokemon1Display = new ImageView(pokemon1View);
		
		pokemon1Display.setTranslateX(70); // Autoset
		pokemon1Display.setTranslateY(240); // Autoset
		
		Pokemon1Icon.setGraphic(pokemon1Display);
		
		/////// POKEMON 2 ICON ///////

		Pokemon2Icon.setStyle(
				"-fx-background-color: transparent; ");
		String pokemon2Icon = "https://www.pokencyclopedia.info/sprites/menu-icons/ico_3ds_shiny-recolored/ico_3ds-S_681-shield.png";
        Image pokemon2View = new Image(pokemon2Icon, 80, 80, true, true);
		ImageView pokemon2Display = new ImageView(pokemon2View);
		
		pokemon2Display.setTranslateX(140); // Autoset
		pokemon2Display.setTranslateY(240); // Autoset
		
		Pokemon2Icon.setGraphic(pokemon2Display);
		
		/////// POKEMON 3 ICON ///////
		
		Pokemon3Icon.setStyle(
				"-fx-background-color: transparent; ");
		String pokemon3Icon = "https://www.pokencyclopedia.info/sprites/menu-icons/ico_3ds_shiny-recolored/ico_3ds-S_038.png";
        Image pokemon3View = new Image(pokemon3Icon, 80, 80, true, true);
		ImageView pokemon3Display = new ImageView(pokemon3View);
		
		pokemon3Display.setTranslateX(210); // Autoset
		pokemon3Display.setTranslateY(240); // Autoset
		
		Pokemon3Icon.setGraphic(pokemon3Display);
		
		/////// ENEMY 1 ICON ///////
		
		Enemy1Icon.setStyle(
				"-fx-background-color: transparent; ");
		String enemy1Icon = "https://www.pokencyclopedia.info/sprites/menu-icons/ico_3ds_shiny-recolored/ico_3ds-S_384-mega.png";
        Image enemy1View = new Image(enemy1Icon, 80, 80, true, true);
		ImageView enemy1Display = new ImageView(enemy1View);
		
		enemy1Display.setTranslateX(400); // Autoset
		enemy1Display.setTranslateY(240); // Autoset
		
		Enemy1Icon.setGraphic(enemy1Display);
		
		/////// ENEMY 2 ICON ///////

		Enemy2Icon.setStyle(
				"-fx-background-color: transparent; ");
		String enemy2Icon = "https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Pok%C3%A9_Ball_icon.svg/1200px-Pok%C3%A9_Ball_icon.svg.png";
        Image enemy2View = new Image(enemy2Icon, 40, 40, true, true);
		ImageView enemy2Display = new ImageView(enemy2View);
		
		enemy2Display.setTranslateX(470); // Autoset
		enemy2Display.setTranslateY(240); // Autoset
		
		Enemy2Icon.setGraphic(enemy2Display);
		
		/////// ENEMY 3 ICON ///////
		
		Enemy3Icon.setStyle(
				"-fx-background-color: transparent; ");
		String enemy3Icon = "https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Pok%C3%A9_Ball_icon.svg/1200px-Pok%C3%A9_Ball_icon.svg.png";
        Image enemy3View = new Image(enemy3Icon, 40, 40, true, true);
		ImageView enemy3Display = new ImageView(enemy3View);
		
		enemy3Display.setTranslateX(540); // Autoset
		enemy3Display.setTranslateY(240); // Autoset
		
		Enemy3Icon.setGraphic(enemy3Display);
	}
		
}
