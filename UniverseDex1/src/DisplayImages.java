import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DisplayImages extends Application {
	
		public static void EnterMouseDisplay(Pokemon p, Button b, Button displayPane, Button type1Display, Button type2Display, Button infographics, Button characterInfo) {
			/////////////////////////////////////// Gen 5 Animation /////////////////////////////////////////////
			
			String imageGif = ("https://projectpokemon.org/images/normal-sprite/" + p.name.toLowerCase() + ".gif");
				// https://play.pokemonshowdown.com/sprites/gen5ani/" + p.imageName.toLowerCase() + ".gif
			Image img = new Image(imageGif, 200, 200, true, true);
			ImageView view = new ImageView(img);
	        view.setTranslateX(-200);
	        view.setTranslateY(10);
			displayPane.setGraphic(view);
			
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
			
			/////////////////////////////////////// Gen 5 Animation Back /////////////////////////////////////////////
			
//			String imageBackGif = ("https://play.pokemonshowdown.com/sprites/gen5ani-back/" + p.name.toLowerCase() + ".gif");
//			
//			Image imgBack = new Image(imageBackGif, 100, 100, true, true);
//			ImageView viewBack = new ImageView(imgBack);
//	        displayBackPane.setGraphic(viewBack);
//	        displayBackPane.setContentDisplay(ContentDisplay.BOTTOM);
//	        viewBack.setTranslateX(0);
//	        viewBack.setTranslateY(-50);
//	        
//			displayBackPane.setStyle(
//					"-fx-background-color: transparent; "		// Background Color
//					+ "-fx-background-radius: 25; "			// Background Radius
//					+ "-fx-border-color: transparent; ");			// Background Color
			
			/////////////////////////////////////// Gen 5 Animation Shiny /////////////////////////////////////////////
			
//			String imageShinyGif = "https://play.pokemonshowdown.com/sprites/gen5ani-shiny/" + p.name.toLowerCase() + ".gif";
//			
//			Image imgShiny = new Image(imageShinyGif, 100, 100, true, true);
//			ImageView viewShiny = new ImageView(imgShiny);
//	        displayShinyPane.setGraphic(viewShiny);
//	        displayShinyPane.setContentDisplay(ContentDisplay.BOTTOM);
//	        viewShiny.setTranslateX(0);
//	        viewShiny.setTranslateY(50);
//	        
//			displayShinyPane.setStyle(
//					"-fx-background-color: transparent; "		// Background Color
//					+ "-fx-background-radius: 25; "			// Background Radius
//					+ "-fx-border-color: transparent; ");			// Background Color
			
			/////////////////////////////////////// STYLE /////////////////////////////////////////////
			
			b.setStyle(
					  "-fx-text-fill: #ffffff; "			// Text Color
					+ "-fx-font: bold 15pt \"Roboto\"; "	// Text Size & Font
					+ "-fx-background-color: #d3d3d3; "		// Background Color
					+ "-fx-background-radius: 25; "			// Background Radius
					+ "-fx-border-color: #ffff00; "			// Background Color
					+ "-fx-border-radius: 25;  "			// Border Radius
					+ "-fx-border-width: 5;");				// Border Width
			
			/////////////////////////////////////// INFOGRAPHICS /////////////////////////////////////////////
			
			String infoText = 
					"National Dex #" + p.order
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

		public static void LeaveMouseDisplay(Pokemon p, Button b, Button displayPane, String myString)  {
			b.setText(myString);
			if(p.selected.equals("Selected")) {
				b.setStyle(
						  "-fx-text-fill: #ffffff; "			// Text Color
						+ "-fx-font: bold 15pt \"Roboto\"; "	// Text Size & Font
						+ "-fx-background-color: #45F248; "		// Background Color
						+ "-fx-background-radius: 35; "			// Background Radius
						+ "-fx-border-color: #0074B7; "			// Background Color
						+ "-fx-border-radius: 25;  "			// Border Radius
						+ "-fx-border-width: 5;");				// Border Width
			} else {
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
		
		public static void StartUpDisplay(Button displayPane, Button platformPane, Button type1, Button type2, Button infographics, Button characterInfo) {
	        //////////////////////////////////////////// GIF BACK /////////////////////////////////////////////////////
//	        Button displayBackPane = new Button();
//	        root.setStyle("-fx-background-image: url(https://archives.bulbagarden.net/media/upload/2/2d/Box_Heart_HGSS.png); -fx-background-size: 500;");

//			String imageBackGif = "https://play.pokemonshowdown.com/sprites/gen5ani-back/bulbasaur.gif";
//			
//			Image imgBack = new Image(imageBackGif, 100, 100, true, true);
//			ImageView viewBack = new ImageView(imgBack);
//	        displayBackPane.setGraphic(viewBack);
//	        displayBackPane.setContentDisplay(ContentDisplay.BOTTOM);
//	        viewBack.setTranslateX(0);
//	        viewBack.setTranslateY(-50);
//	        
//			displayBackPane.setStyle(
//					"-fx-background-color: transparent; "		// Background Color
//					+ "-fx-background-radius: 25; "			// Background Radius
//					+ "-fx-border-color: transparent; ");			// Background Color
			
	        //////////////////////////////////////////// IMAGE SHINY /////////////////////////////////////////////////////
//	        Button displayShinyPane = new Button();

//			String imageShinyGif = "https://play.pokemonshowdown.com/sprites/gen5ani-shiny/bulbasaur.gif";
//			
//			Image imgShiny = new Image(imageShinyGif, 100, 100, true, true);
//			ImageView viewShiny = new ImageView(imgShiny);
//	        displayShinyPane.setGraphic(viewShiny);
//	        displayShinyPane.setContentDisplay(ContentDisplay.BOTTOM);
//	        viewShiny.setTranslateX(0);
//	        viewShiny.setTranslateY(50);
//	        
//			displayShinyPane.setStyle(
//					"-fx-background-color: transparent; "		// Background Color
//					+ "-fx-background-radius: 25; "			// Background Radius
//					+ "-fx-border-color: transparent; ");			// Background Color
	        
	        ///////////////////////////////////////////// IMAGE ////////////////////////////////////////////////
//			Button displayPane = new Button();
			displayPane.setStyle("-fx-background-color: transparent");

			String imageGif = "https://projectpokemon.org/images/normal-sprite/bulbasaur.gif";
			//	https://play.pokemonshowdown.com/sprites/gen5ani/bulbasaur.gif
			
			Image img = new Image(imageGif, 200, 200, true, true);
			ImageView view = new ImageView(img);
	        displayPane.setGraphic(view);
	        view.setTranslateX(-200);
	        view.setTranslateY(10);
	        
	        ///////////////////////////////////////////// PLATFORM ////////////////////////////////////////////////
//			Button platformPane = new Button();
			platformPane.setStyle("-fx-background-color: transparent");
			
	        String platform = "https://static.wikia.nocookie.net/capx/images/e/ec/Basic_Grass.png/revision/latest?cb=20130620230433";
	        Image platformView = new Image(platform, 300, 300, true, true);
			ImageView platformDisplay = new ImageView(platformView);
			platformPane.setGraphic(platformDisplay);
	        platformDisplay.setTranslateX(-200);
	        platformDisplay.setTranslateY(90);
       
//	        Button type1 = new Button();
			type1.setStyle("-fx-background-color: transparent");
			String type1Image = "https://archives.bulbagarden.net/media/upload/2/23/GrassIC_BW.png?20200224205542";
	        Image type1View = new Image(type1Image, 70, 70, true, true);
			ImageView type1Display = new ImageView(type1View);
			type1.setGraphic(type1Display);
			type1Display.setTranslateX(-260);
			type1Display.setTranslateY(160);
			
//			Button type2 = new Button();
			type2.setStyle("-fx-background-color: transparent");
			String type2Image = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/HD_transparent_picture.png/1024px-HD_transparent_picture.png";
	        Image type2View = new Image(type2Image, 70, 70, true, true);
			ImageView type2Display = new ImageView(type2View);
			type2.setGraphic(type2Display);
			type2Display.setTranslateX(-160);
			type2Display.setTranslateY(160);
			
			
	        //////////////////////////////////////////// INFOGRAPHIC /////////////////////////////////////////////////////
			
//			Button infographics = new Button();
//			Button characterInfo = new Button();

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
			

		}

		@Override
		public void start(Stage arg0) throws Exception {
			// TODO Auto-generated method stub
			
		}
	}
	
