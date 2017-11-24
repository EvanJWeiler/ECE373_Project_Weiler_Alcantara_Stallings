package org.Pokedex.system;
import java.util.*;
import org.Pokedex.pokemon.*;

public class Pokedex 
{
	private ArrayList<Pokemon> dexList;
	
	public Pokedex()
	{
		dexList = new ArrayList<Pokemon>();
		addGenerationOne();
	}

	public ArrayList<Pokemon> getDexList() 
	{
		return dexList;
	}
	
	public void addToDexList(Pokemon aPoke)
	{
		this.dexList.add(aPoke);
	}
	
	public ArrayList<Pokemon> searchPokemon(int aNum, String aName, String aType1, String aType2, int aGen, boolean aIsLegendary)
	{
		ArrayList<Pokemon> tempList = new ArrayList<Pokemon>();
		
		for(int i = 0; i < dexList.size(); i++)
		{
			if(dexList.get(i).getPokeNum() == aNum && 
			   dexList.get(i).getName().equals(aName) &&
			   dexList.get(i).getTypeList().get(0).equals(aType1) &&
			   dexList.get(i).getTypeList().get(1).equals(aType2) &&
			   dexList.get(i).getGeneration() == aGen &&
			   dexList.get(i).isLegendary() == aIsLegendary)
			{
				tempList.add(dexList.get(i));
			}
		}
		
		return tempList;
	}
	
	public void addGenerationOne() //FIXME: finish adding pokemon
	{	
		//Bulbasaur
		Pokemon p1 = new Pokemon("Bulbasaur");
		p1.setPokeNum(1);
		p1.setGeneration(1);
		p1.addToTypeList("Grass");
		p1.addToTypeList("Poison");
		addToDexList(p1);
		
		//Ivysaur
		Pokemon p2 = new Pokemon("Ivysaur");
		p2.setPokeNum(2);
		p2.setGeneration(1);
		p2.addToTypeList("Grass");
		p2.addToTypeList("Poison");
		addToDexList(p2);
		
		//Venusaur
		Pokemon p3 = new Pokemon("Venusaur");
		p3.setPokeNum(3);
		p3.setGeneration(1);
		p3.addToTypeList("Grass");
		p3.addToTypeList("Poison");
		addToDexList(p3);
		
		//BulbEvoFam
		p1.addToEvoFamily(p1);
		p1.addToEvoFamily(p2);
		p1.addToEvoFamily(p3);
		p2.addToEvoFamily(p1);
		p2.addToEvoFamily(p2);
		p2.addToEvoFamily(p3);
		p3.addToEvoFamily(p1);
		p3.addToEvoFamily(p2);
		p3.addToEvoFamily(p3);
		
		//Charmander
		Pokemon p4 = new Pokemon("Charmander");
		p4.setPokeNum(4);
		p4.setGeneration(1);
		p4.addToTypeList("Fire");
		p4.addToTypeList("NULL");
		addToDexList(p4);
		
		//Charmeleon
		Pokemon p5 = new Pokemon("Charmeleon");
		p5.setPokeNum(5);
		p5.setGeneration(1);
		p5.addToTypeList("Fire");
		p5.addToTypeList("NULL");
		addToDexList(p5);
		
		//Charizard
		Pokemon p6 = new Pokemon("Charizard");
		p6.setPokeNum(6);
		p6.setGeneration(1);
		p6.addToTypeList("Fire");
		p6.addToTypeList("NULL");
		addToDexList(p6);
		
		//CharEvoFam
		p4.addToEvoFamily(p4);
		p4.addToEvoFamily(p5);
		p4.addToEvoFamily(p6);
		p5.addToEvoFamily(p4);
		p5.addToEvoFamily(p5);
		p5.addToEvoFamily(p6);
		p6.addToEvoFamily(p4);
		p6.addToEvoFamily(p5);
		p6.addToEvoFamily(p6);
		
		//Squirtle
		Pokemon p7 = new Pokemon("Squirtle");
		p7.setPokeNum(7);
		p7.setGeneration(1);
		p7.addToTypeList("Water");
		p7.addToTypeList("NULL");
		addToDexList(p7);
		
		//Wartortle
		Pokemon p8 = new Pokemon("Wartortle");
		p8.setPokeNum(8);
		p8.setGeneration(1);
		p8.addToTypeList("Water");
		p8.addToTypeList("NULL");
		addToDexList(p8);
		
		//Blastoise
		Pokemon p9 = new Pokemon("Blastoise");
		p9.setPokeNum(9);
		p9.setGeneration(1);
		p9.addToTypeList("Water");
		p9.addToTypeList("NULL");
		addToDexList(p9);
		
		//SquirEvoFam
		p7.addToEvoFamily(p7);
		p7.addToEvoFamily(p8);
		p7.addToEvoFamily(p9);
		p8.addToEvoFamily(p7);
		p8.addToEvoFamily(p8);
		p8.addToEvoFamily(p9);
		p9.addToEvoFamily(p7);
		p9.addToEvoFamily(p8);
		p9.addToEvoFamily(p9);
		
		//Caterpie
		Pokemon p10 = new Pokemon("Caterpie");
		p10.setPokeNum(10);
		p10.setGeneration(1);
		p10.addToTypeList("Bug");
		p10.addToTypeList("NULL");
		addToDexList(p10);
		
		//Metapod
		Pokemon p11 = new Pokemon("Metapod");
		p11.setPokeNum(11);
		p11.setGeneration(1);
		p11.addToTypeList("Bug");
		p11.addToTypeList("NULL");
		addToDexList(p11);
		
		
		//Butterfree
		Pokemon p12 = new Pokemon("Butterfree");
		p12.setPokeNum(12);
		p12.setGeneration(1);
		p12.addToTypeList("Bug");
		p12.addToTypeList("Flying");
		addToDexList(p12);
		
		//CaterEvoFam
		p10.addToEvoFamily(p10);
		p10.addToEvoFamily(p11);
		p10.addToEvoFamily(p12);
		p11.addToEvoFamily(p10);
		p11.addToEvoFamily(p11);
		p11.addToEvoFamily(p12);
		p12.addToEvoFamily(p10);
		p12.addToEvoFamily(p11);
		p12.addToEvoFamily(p12);
		
		//Weedle
		Pokemon p13 = new Pokemon("Weedle");
		p13.setPokeNum(13);
		p13.setGeneration(1);
		p13.addToTypeList("Bug");
		p13.addToTypeList("Poison");
		addToDexList(p13);
		
		//Kakuna
		Pokemon p14 = new Pokemon("Kakuna");
		p14.setPokeNum(14);
		p14.setGeneration(1);
		p14.addToTypeList("Bug");
		p14.addToTypeList("Poison");
		addToDexList(p14);
		
		//Beedrill
		Pokemon p15 = new Pokemon("Beedrill");
		p15.setPokeNum(15);
		p15.setGeneration(1);
		p15.addToTypeList("Bug");
		p15.addToTypeList("Poison");
		addToDexList(p15);
		
		//WeedEvoFam
		p13.addToEvoFamily(p13);
		p13.addToEvoFamily(p14);
		p13.addToEvoFamily(p15);
		p14.addToEvoFamily(p13);
		p14.addToEvoFamily(p14);
		p14.addToEvoFamily(p15);
		p15.addToEvoFamily(p13);
		p15.addToEvoFamily(p14);
		p15.addToEvoFamily(p15);
		
		//Pidgey
		Pokemon p16 = new Pokemon("Pidgey");
		p16.setPokeNum(16);
		p16.setGeneration(1);
		p16.addToTypeList("Normal");
		p16.addToTypeList("Flying");
		addToDexList(p16);
		
		//Pidgeotto
		Pokemon p17 = new Pokemon("Pidgeotto");
		p17.setPokeNum(17);
		p17.setGeneration(1);
		p17.addToTypeList("Normal");
		p17.addToTypeList("Flying");
		addToDexList(p17);
		
		//Pidgeot
		Pokemon p18 = new Pokemon("Pidgeot");
		p18.setPokeNum(18);
		p18.setGeneration(1);
		p18.addToTypeList("Normal");
		p18.addToTypeList("Flying");
		addToDexList(p18);
		
		//PidgEvoFam
		p16.addToEvoFamily(p16);
		p16.addToEvoFamily(p17);
		p16.addToEvoFamily(p18);
		p17.addToEvoFamily(p16);
		p17.addToEvoFamily(p17);
		p17.addToEvoFamily(p18);
		p18.addToEvoFamily(p16);
		p18.addToEvoFamily(p17);
		p18.addToEvoFamily(p18);
		
		//Rattata
		Pokemon p19 = new Pokemon("Rattata");
		p19.setPokeNum(19);
		p19.setGeneration(1);
		p19.addToTypeList("Normal");
		p19.addToTypeList("NULL");
		addToDexList(p19);
		
		//Raticate
		Pokemon p20 = new Pokemon("Raticate");
		p20.setPokeNum(20);
		p20.setGeneration(1);
		p20.addToTypeList("Normal");
		p20.addToTypeList("NULL");
		addToDexList(p20);
		
		//RatEvoFam
		p19.addToEvoFamily(p19);
		p19.addToEvoFamily(p20);
		p20.addToEvoFamily(p19);
		p20.addToEvoFamily(p20);
		
		//Spearow
		Pokemon p21 = new Pokemon("Spearow");
		p21.setPokeNum(21);
		p21.setGeneration(1);
		p21.addToTypeList("Normal");
		p21.addToTypeList("Flying");
		addToDexList(p21);
		
		//Fearow
		Pokemon p22 = new Pokemon("Fearow");
		p22.setPokeNum(22);
		p22.setGeneration(1);
		p22.addToTypeList("Normal");
		p22.addToTypeList("Flying");
		addToDexList(p22);
		
		//SpearEvoFam
		p21.addToEvoFamily(p21);
		p21.addToEvoFamily(p22);
		p22.addToEvoFamily(p21);
		p22.addToEvoFamily(p22);
		
		//Ekans
		Pokemon p23 = new Pokemon("Ekans");
		p23.setPokeNum(23);
		p23.setGeneration(1);
		p23.addToTypeList("Poison");
		p23.addToTypeList("NULL");
		addToDexList(p23);
		
		//Arbok
		Pokemon p24 = new Pokemon("Arbok");
		p24.setPokeNum(24);
		p24.setGeneration(1);
		p24.addToTypeList("Poison");
		p24.addToTypeList("NULL");
		addToDexList(p24);
		
		//EkansEvoFam
		p23.addToEvoFamily(p23);
		p23.addToEvoFamily(p24);
		p24.addToEvoFamily(p23);
		p24.addToEvoFamily(p24);
		
		//Pikachu
		Pokemon p25 = new Pokemon("Pikachu");
		p25.setPokeNum(25);
		p25.setGeneration(1);
		p25.addToTypeList("Electric");
		p25.addToTypeList("NULL");
		addToDexList(p25);
		
		//Raichu
		Pokemon p26 = new Pokemon("Raichu");
		p26.setPokeNum(26);
		p26.setGeneration(1);
		p26.addToTypeList("Electric");
		p26.addToTypeList("NULL");
		addToDexList(p26);
		
		//PikaEvoFam
		p25.addToEvoFamily(p25);
		p25.addToEvoFamily(p26);
		p26.addToEvoFamily(p25);
		p26.addToEvoFamily(p26);
		
		// OTHER POKEMON TO BE ADDED LATER
		
		//Articuno
		Pokemon p144 = new Pokemon("Articuno");
		p144.setPokeNum(144);
		p144.setGeneration(1);
		p144.setLegendary(true);
		p144.addToTypeList("Ice");
		p144.addToTypeList("Flying");
		addToDexList(p144);
		
		//Zapdos
		Pokemon p145 = new Pokemon("Zapdos");
		p145.setPokeNum(145);
		p145.setGeneration(1);
		p145.setLegendary(true);
		p145.addToTypeList("Electric");
		p145.addToTypeList("Flying");
		addToDexList(p145);
		
		//Moltres
		Pokemon p146 = new Pokemon("Moltres");
		p146.setPokeNum(146);
		p146.setGeneration(1);
		p146.setLegendary(true);
		p146.addToTypeList("Fire");
		p146.addToTypeList("Flying");
		addToDexList(p146);
		
		//Dratini-Dragonite goes here TEST2
		
		//Mewtwo
		Pokemon p150 = new Pokemon("Mewtwo");
		p150.setPokeNum(150);
		p150.setGeneration(1);
		p150.setLegendary(true);
		p150.addToTypeList("Psychic");
		p150.addToTypeList("NULL");
		addToDexList(p150);
		
		//Mew
		Pokemon p151 = new Pokemon("Mew");
		p151.setPokeNum(151);
		p151.setGeneration(1);
		p151.setLegendary(true);
		p151.addToTypeList("Psychic");
		p151.addToTypeList("NULL");
		addToDexList(p151);
		
	}
}
