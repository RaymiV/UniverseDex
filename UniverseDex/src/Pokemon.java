
public class Pokemon {
	public int NID;
	public String name;
	public String species;
	public String typeOne, typeTwo;
	public String abilities;
	public String catchRate;
	public String weight;
	public String height;
	public String image;
	public String voiceEntry;
	public String health, attack, defense, spAttack, spDefense, speed;
	
	public Pokemon(String [] a) {
		
		this.NID = Integer.parseInt(a[0], 10);
		this.name = a[0];
		this.species = a[1];
		this.typeOne = a[2];
		this.typeTwo = a[3];
		this.abilities = a[4];
		this.catchRate = a[5];
		this.weight = a[6];
		this.height = a[7];
		this.image = "https://img.pokemondb.net/artwork/large/" + name + ".jpg";
		this.voiceEntry = a[9];
		this.health = a[10];
		this.attack = a[11];
		this.defense = a[12];
		this.spAttack = a[13];
		this.spDefense = a[14];
		this.speed = a[15];
		
		System.out.println("Data successfully assigned");
				
	}
	

}
