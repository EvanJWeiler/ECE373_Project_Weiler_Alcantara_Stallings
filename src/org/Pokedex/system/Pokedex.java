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
	
	public Pokemon CalculateWinner(Pokemon p1, Pokemon p2, int CP1, int CP2) {//I am setting this up so that p1 is our pokemon, and p2 is the opponent's
		double typeCalculation = 0;
		double modifiedCP = 0;
		
		typeCalculation = CompareTypes(p1, p2);//this is the value to modify the cp of our pokemon based on type weaknesses and resistances
		modifiedCP = CP1 * typeCalculation;
		if(modifiedCP > CP2) {//comparison between modified CP for our pokemon and the cp of the opponent
			return p1;
		}
		else if(modifiedCP < CP2) {
			return p2;
		}
		else {
			return p2;
		}
		
		
	}
	
	public double CompareTypes(Pokemon p1, Pokemon p2) {//This is gonna be one MASSIVE if else statement
		int numberOfTypesP1 = 0;
		int numberOfTypesP2 = 0;
		double typeCalculation = 0;
		double typeCalculation2 = 0;
		double typeCalculation3 = 0;
		double typeCalculation4 = 0;
		numberOfTypesP1 = p1.getTypeList().size();
		numberOfTypesP2 = p2.getTypeList().size();
		
		if(numberOfTypesP1 == 1 && numberOfTypesP2 == 1) {//both pokemon are one type
			typeCalculation = comparison(p1.getTypeList().get(0), p2.getTypeList().get(0));
		}
		else if(numberOfTypesP1 == 1 && numberOfTypesP2 == 2) {
			typeCalculation = comparison(p1.getTypeList().get(0), p2.getTypeList().get(0));
			typeCalculation2 = comparison(p1.getTypeList().get(0), p2.getTypeList().get(1));
			
			if(typeCalculation == typeCalculation2) {
				typeCalculation = typeCalculation;
			}
			else {
				typeCalculation = typeCalculation * typeCalculation2;
			}
		}
		else if(numberOfTypesP1 == 2 && numberOfTypesP2 == 1) {
			typeCalculation = comparison(p1.getTypeList().get(0), p2.getTypeList().get(0));
			typeCalculation2 = comparison(p1.getTypeList().get(1), p2.getTypeList().get(0));
			
			if(typeCalculation == typeCalculation2) {
				typeCalculation = typeCalculation;
			}
			else {
				typeCalculation = typeCalculation * typeCalculation2;
			}
		}
		else {
			typeCalculation = comparison(p1.getTypeList().get(0), p2.getTypeList().get(0));
			typeCalculation2 = comparison(p1.getTypeList().get(0), p2.getTypeList().get(1));
			typeCalculation3 = comparison(p1.getTypeList().get(1), p2.getTypeList().get(0));
			typeCalculation4 = comparison(p1.getTypeList().get(1), p2.getTypeList().get(1));
			
			if(typeCalculation == typeCalculation3) {
				typeCalculation = typeCalculation;
			}
			else
				typeCalculation = typeCalculation * typeCalculation3;
			if(typeCalculation2 == typeCalculation4) {
				typeCalculation2 = typeCalculation2;
			}
			else {
				//typeCalculation = typeCalculation * typeCalculation3;
				typeCalculation2 = typeCalculation2 * typeCalculation4;
			}
			typeCalculation = typeCalculation * typeCalculation2;
		}
		
		return typeCalculation;
	}
	
	public double comparison(String t1, String t2) {
		double typeCalculation = 0;
		
		if(t1 == "Normal" && (t2 == "Steel" || t2 == "Rock")) {
			typeCalculation = 0.5;
		}
		else if(t1 == "Normal" && t2 == "Ghost") {//Ghost types aren't affected by normal types
			typeCalculation = 0;
		}
		else if(t1 == "Fire" && (t2 == "Fire" || t2 == "Water" || t2 == "Rock" || t2 == "Dragon")) {
			typeCalculation = 0.5;
		}
		else if(t1 == "Fire" && (t2 == "Grass" || t2 == "Ice" || t2 == "Bug" || t2 == "Steel")) {
			typeCalculation = 2;
		}
		else if(t1 == "Water" && (t2 == "Water" || t2 == "Ice" || t2 == "Dragon")) {
			typeCalculation = 0.5;
		}
		else if(t1 == "Water" && (t2 == "Fire" || t2 == "Ground" || t2 == "Rock")) {
			typeCalculation = 2;
		}
		else if(t1 == "Electric" && (t2 == "Electric" || t2 == "Grass" || t2 == "Dragon")) {
			typeCalculation = 0.5;
		}
		else if(t1 == "Electric" && t2 == "Ground") {
			typeCalculation = 0;
		}
		else if(t1 == "Electric" && (t2 == "Water" || t2 == "Flying")) {
			typeCalculation = 2;
		}
		else if(t1 == "Grass" && (t2 == "Fire" || t2 == "Grass" || t2 == "Poison" || t2 == "Flying" || t2 == "Bug" || t2 == "Dragon" || t2 == "Steel")) {
			typeCalculation = 0.5;
		}
		else if(t1 == "Grass" && (t2 == "Water" || t2 == "Ground" || t2 == "Rock")) {
			typeCalculation = 2;
		}
		else if(t1 == "Ice" && (t2 == "Fire" || t2 == "Water" || t2 == "Ice" ||t2 == "Steel")) {
			typeCalculation = 0.5;
		}
		else if(t1 == "Ice" && (t2 == "Grass" || t2 == "Ground" || t2 == "Flying" || t2 == "Dragon")) {
			typeCalculation = 2;
		}
		else if(t1 == "Fighting" && (t2 == "Poison" || t2 == "Flying" || t2 == "Psychic" || t2 == "Bug" || t2 == "Fairy")) {
			typeCalculation = 0.5;
		}
		else if(t1 == "Fighting" && (t2 == "Normal" || t2 == "Ice" || t2 == "Rock" || t2 == "Dark" || t2 == "Steel")) {
			typeCalculation = 2;
		}
		else if(t1 == "Fighting" && t2 == "Ghost") {
			typeCalculation = 0;
		}
		else if(t1 == "Poison" && (t2 == "Poison" || t2 == "Ground" || t2 == "Rock" || t2 == "Ghost")) {
			typeCalculation = 0.5;
		}
		else if(t1 == "Poison" && (t2 == "Grass" || t2 == "Fairy")) {
			typeCalculation = 2;
		}
		else if(t1 == "Poison" && t2 == "Steel") {
			typeCalculation = 0;
		}
		else if(t1 == "Ground" && (t2 == "Grass" || t2 == "Bug")) {
			typeCalculation = 0.5;
		}
		else if(t1 == "Ground" && (t2 == "Fire" || t2 == "Electric" || t2 == "Poison" || t2 == "Rock" || t2 == "Steel")) {
			typeCalculation = 2;
		}
		else if(t1 == "Ground" && t2 == "Flying") {
			typeCalculation = 0;
		}
		else if(t1 == "Flying" && (t2 == "Electric" || t2 == "Rock" || t2 == "Steel")) {
			typeCalculation = 0.5;
		}
		else if(t1 == "Flying" && (t2 == "Grass" || t2 == "Fighting" || t2 == "Bug")) {
			typeCalculation = 2;
		}
		else if(t1 == "Psychic" && (t2 == "Psychic" || t2 == "Steel")) {
			typeCalculation = 0.5;
		}
		else if(t1 == "Psychic" && (t2 == "Fighting" || t2 == "Poison")) {
			typeCalculation = 2;
		}
		else if(t1 == "Psychic" && (t2 == "Dark")) {
			typeCalculation = 0;
		}
		else if(t1 == "Bug" && (t2 == "Fire" || t2 == "Fighting" || t2 == "Poison" || t2 == "Flying" || t2 == "Ghost" || t2 == "Steel" || t2 == "Fairy")) {
			typeCalculation = 0.5;
		}
		else if(t1 == "Bug" && (t2 == "Grass" || t2 == "Psychic" || t2 == "Dark")) {
			typeCalculation = 2;
		}
		else if(t1 == "Rock" && (t2 == "Fighting" || t2 == "Ground" || t2 == "Steel")) {
			typeCalculation = 0.5;
		}
		else if(t1 == "Rock" && (t2 == "Fire" || t2 == "Ice" || t2 == "Flying" || t2 == "Bug")) {
			typeCalculation = 2;
		}
		else if(t1 == "Ghost" && t2 == "Dark") {
			typeCalculation = 0.5;
		}
		else if(t1 == "Ghost" && (t2 == "Psychic" || t2 == "Ghost")) {
			typeCalculation = 2;
		}
		else if(t1 == "Ghost" && t2 == "Normal") {
			typeCalculation = 0;
		}
		else if(t1 == "Dragon" && (t2 == "Steel")) {
			typeCalculation = 0.5;
		}
		else if(t1 == "Dragon" && t2 == "Dragon") {
			typeCalculation = 2;
		}
		else if(t1 == "Dragon" && t2 == "Fairy") {
			typeCalculation = 0;
		}
		else if(t1 == "Dark" && (t2 == "Fighting" || t2 == "Dark" || t2 == "Fairy")) {
			typeCalculation = 0.5;
		}
		else if(t1 == "Dark" && (t2 == "Psychic" || t2 == "Ghost")) {
			typeCalculation = 2;
		}
		else if(t1 == "Steel" && (t2 == "Fire" || t2 == "Water" || t2 == "Electric" || t2 == "Steel")) {
			typeCalculation = 0.5;
		}
		else if(t1 == "Steel" && (t2 == "Ice" || t2 == "Rock" || t2 == "Fairy")) {
			typeCalculation = 2;
		}
		else if(t1 == "Fairy" && (t2 == "Normal" || t2 == "Poison" || t2 == "Steel")) {
			typeCalculation = 0.5;
		}
		else if(t1 == "Fairy" && (t2 == "Fighting" || t2 == "Dragon" || t2 == "Dark")) {
			typeCalculation = 2;
		}
		else {
			typeCalculation = 1;
		}
		
		return typeCalculation;
	}
	
	public void addGenerationOne() //FIXME: finish adding pokemon
	{	
		//Bulbasaur
		Pokemon p1 = new Pokemon("Bulbasaur");
		p1.setPokeNum(1);
		p1.setGeneration(1);
		p1.setHeight(0.7);
		p1.setWeight(6.9);
		p1.addToTypeList("Grass");
		p1.addToTypeList("Poison");
		p1.setSpritePic("resources/1.png");
		addToDexList(p1);
		
		//Ivysaur
		Pokemon p2 = new Pokemon("Ivysaur");
		p2.setPokeNum(2);
		p2.setGeneration(1);
		p2.setHeight(1.0);
		p2.setWeight(13.0);
		p2.addToTypeList("Grass");
		p2.addToTypeList("Poison");
		p2.setSpritePic("resources/2.png");
		addToDexList(p2);
		
		//Venusaur
		Pokemon p3 = new Pokemon("Venusaur");
		p3.setPokeNum(3);
		p3.setGeneration(1);
		p3.setHeight(2.0);
		p3.setWeight(100.0);
		p3.addToTypeList("Grass");
		p3.addToTypeList("Poison");
		p3.setSpritePic("resources/3.png");
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
		p4.setHeight(0.6);
		p4.setWeight(8.5);
		p4.addToTypeList("Fire");
		p4.addToTypeList(null);
		p4.setSpritePic("resources/4.png");
		addToDexList(p4);
		
		//Charmeleon
		Pokemon p5 = new Pokemon("Charmeleon");
		p5.setPokeNum(5);
		p5.setGeneration(1);
		p5.setHeight(1.1);
		p5.setWeight(19.0);
		p5.addToTypeList("Fire");
		p5.addToTypeList(null);
		p5.setSpritePic("resources/5.png");
		addToDexList(p5);
		
		//Charizard
		Pokemon p6 = new Pokemon("Charizard");
		p6.setPokeNum(6);
		p6.setGeneration(1);
		p6.setHeight(1.7);
		p6.setWeight(90.5);
		p6.addToTypeList("Fire");
		p6.addToTypeList(null);
		p6.setSpritePic("resources/6.png");
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
		p7.setHeight(0.5);
		p7.setWeight(9.0);
		p7.addToTypeList("Water");
		p7.addToTypeList(null);
		p7.setSpritePic("resources/7.png");
		addToDexList(p7);
		
		//Wartortle
		Pokemon p8 = new Pokemon("Wartortle");
		p8.setPokeNum(8);
		p8.setGeneration(1);
		p8.setHeight(1.0);
		p8.setWeight(22.5);
		p8.addToTypeList("Water");
		p8.addToTypeList(null);
		p8.setSpritePic("resources/8.png");
		addToDexList(p8);
		
		//Blastoise
		Pokemon p9 = new Pokemon("Blastoise");
		p9.setPokeNum(9);
		p9.setGeneration(1);
		p9.setHeight(1.6);
		p9.setWeight(85.5);
		p9.addToTypeList("Water");
		p9.addToTypeList(null);
		p9.setSpritePic("resources/9.png");
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
		p10.setHeight(0.3);
		p10.setWeight(2.9);
		p10.addToTypeList("Bug");
		p10.addToTypeList(null);
		p10.setSpritePic("resources/10.png");
		addToDexList(p10);
		
		//Metapod
		Pokemon p11 = new Pokemon("Metapod");
		p11.setPokeNum(11);
		p11.setGeneration(1);
		p11.setHeight(0.7);
		p11.setWeight(9.9);
		p11.addToTypeList("Bug");
		p11.addToTypeList(null);
		p11.setSpritePic("resources/11.png");
		addToDexList(p11);
		
		
		//Butterfree
		Pokemon p12 = new Pokemon("Butterfree");
		p12.setPokeNum(12);
		p12.setGeneration(1);
		p12.setHeight(1.1);
		p12.setWeight(32.0);
		p12.addToTypeList("Bug");
		p12.addToTypeList("Flying");
		p12.setSpritePic("resources/12.png");
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
		p13.setHeight(0.3);
		p13.setWeight(3.2);
		p13.addToTypeList("Bug");
		p13.addToTypeList("Poison");
		p13.setSpritePic("resources/13.png");
		addToDexList(p13);
		
		//Kakuna
		Pokemon p14 = new Pokemon("Kakuna");
		p14.setPokeNum(14);
		p14.setGeneration(1);
		p14.setHeight(0.6);
		p14.setWeight(10.0);
		p14.addToTypeList("Bug");
		p14.addToTypeList("Poison");
		p14.setSpritePic("resources/14.png");
		addToDexList(p14);
		
		//Beedrill
		Pokemon p15 = new Pokemon("Beedrill");
		p15.setPokeNum(15);
		p15.setGeneration(1);
		p15.setHeight(1.0);
		p15.setWeight(29.5);
		p15.addToTypeList("Bug");
		p15.addToTypeList("Poison");
		p15.setSpritePic("resources/15.png");
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
		p16.setHeight(0.3);
		p16.setWeight(1.8);
		p16.addToTypeList("Normal");
		p16.addToTypeList("Flying");
		p16.setSpritePic("resources/16.png");
		addToDexList(p16);
		
		//Pidgeotto
		Pokemon p17 = new Pokemon("Pidgeotto");
		p17.setPokeNum(17);
		p17.setGeneration(1);
		p17.setHeight(1.1);
		p17.setWeight(30.0);
		p17.addToTypeList("Normal");
		p17.addToTypeList("Flying");
		p17.setSpritePic("resources/17.png");
		addToDexList(p17);
		
		//Pidgeot
		Pokemon p18 = new Pokemon("Pidgeot");
		p18.setPokeNum(18);
		p18.setGeneration(1);
		p18.setHeight(1.5);
		p18.setWeight(39.5);
		p18.addToTypeList("Normal");
		p18.addToTypeList("Flying");
		p18.setSpritePic("resources/18.png");
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
		p19.setHeight(0.3);
		p19.setWeight(3.5);
		p19.addToTypeList("Normal");
		p19.addToTypeList(null);
		p19.setSpritePic("resources/19.png");
		addToDexList(p19);
		
		//Raticate
		Pokemon p20 = new Pokemon("Raticate");
		p20.setPokeNum(20);
		p20.setGeneration(1);
		p20.setHeight(0.7);
		p20.setWeight(18.5);
		p20.addToTypeList("Normal");
		p20.addToTypeList(null);
		p20.setSpritePic("resources/20.png");
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
		p21.setHeight(0.3);
		p21.setWeight(2.0);
		p21.addToTypeList("Normal");
		p21.addToTypeList("Flying");
		p21.setSpritePic("resources/21.png");
		addToDexList(p21);
		
		//Fearow
		Pokemon p22 = new Pokemon("Fearow");
		p22.setPokeNum(22);
		p22.setGeneration(1);
		p22.setHeight(1.2);
		p22.setWeight(38.0);
		p22.addToTypeList("Normal");
		p22.addToTypeList("Flying");
		p22.setSpritePic("resources/22.png");
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
		p23.setHeight(2.0);
		p23.setWeight(6.9);
		p23.addToTypeList("Poison");
		p23.addToTypeList(null);
		p23.setSpritePic("resources/23.png");
		addToDexList(p23);
		
		//Arbok
		Pokemon p24 = new Pokemon("Arbok");
		p24.setPokeNum(24);
		p24.setGeneration(1);
		p24.setHeight(3.5);
		p24.setWeight(65.0);
		p24.addToTypeList("Poison");
		p24.addToTypeList(null);
		p24.setSpritePic("resources/24.png");
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
		p25.setHeight(0.4);
		p25.setWeight(6.0);
		p25.addToTypeList("Electric");
		p25.addToTypeList(null);
		p25.setSpritePic("resources/25.png");
		addToDexList(p25);
		
		//Raichu
		Pokemon p26 = new Pokemon("Raichu");
		p26.setPokeNum(26);
		p26.setGeneration(1);
		p26.setHeight(0.8);
		p26.setWeight(30.0);
		p26.addToTypeList("Electric");
		p26.addToTypeList(null);
		p26.setSpritePic("resources/26.png");
		addToDexList(p26);
		
		//PikaEvoFam
		p25.addToEvoFamily(p25);
		p25.addToEvoFamily(p26);
		p26.addToEvoFamily(p25);
		p26.addToEvoFamily(p26);
		
		//Sandshrew
		Pokemon p27 = new Pokemon("Sandshrew");
		p27.setPokeNum(27);
		p27.setGeneration(1);
		p27.setHeight(0.6);
		p27.setWeight(12.0);
		p27.addToTypeList("Ground");
		p27.addToTypeList(null);
		p27.setSpritePic("resources/27.png");
		addToDexList(p27);
		
		//Sandslash
		Pokemon p28 = new Pokemon("Sandslash");
		p28.setPokeNum(28);
		p28.setGeneration(1);
		p28.setHeight(1.0);
		p28.setWeight(29.5);
		p28.addToTypeList("Ground");
		p28.addToTypeList(null);
		p28.setSpritePic("resources/28.png");
		addToDexList(p28);
		
		//SandslashEvoFam
		p27.addToEvoFamily(p27);
		p27.addToEvoFamily(p28);
		p28.addToEvoFamily(p27);
		p28.addToEvoFamily(p28);
		
		//Nidoran (F)
		Pokemon p29 = new Pokemon("Nidoran\u2640");
		p29.setPokeNum(29);
		p29.setGeneration(1);
		p29.setHeight(0.4);
		p29.setWeight(7.0);
		p29.addToTypeList("Poison");
		p29.addToTypeList(null);
		p29.setGender("Female");
		p29.setSpritePic("resources/29.png");
		addToDexList(p29);
		
		//Nidorina
		Pokemon p30 = new Pokemon("Nidorina");
		p30.setPokeNum(30);
		p30.setGeneration(1);
		p30.setHeight(0.8);
		p30.setWeight(20.0);
		p30.addToTypeList("Poison");
		p30.addToTypeList(null);
		p30.setGender("Female");
		p30.setSpritePic("resources/30.png");
		addToDexList(p30);
		
		//Nidoqueen
		Pokemon p31 = new Pokemon("Nidoqueen");
		p31.setPokeNum(31);
		p31.setGeneration(1);
		p31.setHeight(1.3);
		p31.setWeight(60.0);
		p31.addToTypeList("Poison");
		p31.addToTypeList("Ground");
		p31.setGender("Female");
		p31.setSpritePic("resources/31.png");
		addToDexList(p31);
		
		//NidorinaEvoFam
		p29.addToEvoFamily(p29);
		p29.addToEvoFamily(p30);
		p29.addToEvoFamily(p31);
		p30.addToEvoFamily(p29);
		p30.addToEvoFamily(p30);
		p30.addToEvoFamily(p31);
		p31.addToEvoFamily(p29);
		p31.addToEvoFamily(p30);
		p31.addToEvoFamily(p31);
		
		//Nidoran (M)
		Pokemon p32 = new Pokemon("Nidoran\u2642");
		p32.setPokeNum(32);
		p32.setGeneration(1);
		p32.setHeight(0.5);
		p32.setWeight(9.0);
		p32.addToTypeList("Poison");
		p32.addToTypeList(null);
		p32.setGender("Male");
		p32.setSpritePic("resources/32.png");
		addToDexList(p32);
		
		//Nidorino
		Pokemon p33 = new Pokemon("Nidorino");
		p33.setPokeNum(33);
		p33.setGeneration(1);
		p33.setHeight(0.9);
		p33.setWeight(19.5);
		p33.addToTypeList("Poison");
		p33.addToTypeList(null);
		p33.setGender("Male");
		p33.setSpritePic("resources/33.png");
		addToDexList(p33);
		
		//Nidoking
		Pokemon p34 = new Pokemon("Nidoking");
		p34.setPokeNum(34);
		p34.setGeneration(1);
		p34.setHeight(1.4);
		p34.setWeight(62.0);
		p34.addToTypeList("Poison");
		p34.addToTypeList("Ground");
		p34.setGender("Male");
		p34.setSpritePic("resources/34.png");
		addToDexList(p34);
		
		//NidoinoEvoFam
		p32.addToEvoFamily(p32);
		p32.addToEvoFamily(p33);
		p32.addToEvoFamily(p34);
		p33.addToEvoFamily(p32);
		p33.addToEvoFamily(p33);
		p33.addToEvoFamily(p34);
		p34.addToEvoFamily(p32);
		p34.addToEvoFamily(p33);
		p34.addToEvoFamily(p34);
		
		//Clefairy
		Pokemon p35 = new Pokemon("Clefairy");
		p35.setPokeNum(35);
		p35.setGeneration(1);
		p35.setHeight(0.6);
		p35.setWeight(7.5);
		p35.addToTypeList("Fairy");
		p35.addToTypeList(null);
		p35.setSpritePic("resources/35.png");
		addToDexList(p35);
		
		//Clefable
		Pokemon p36 = new Pokemon("Clefable");
		p36.setPokeNum(36);
		p36.setGeneration(1);
		p36.setHeight(1.3);
		p36.setWeight(40.0);
		p36.addToTypeList("Fairy");
		p36.addToTypeList(null);
		p36.setSpritePic("resources/36.png");
		addToDexList(p36);
		
		//ClefairyEvoFam
		p35.addToEvoFamily(p35);
		p35.addToEvoFamily(p36);
		p36.addToEvoFamily(p35);
		p36.addToEvoFamily(p36);
		
		//Vulpix
		Pokemon p37 = new Pokemon("Vulpix");
		p37.setPokeNum(37);
		p37.setGeneration(1);
		p37.setHeight(0.6);
		p37.setWeight(9.9);
		p37.addToTypeList("Fire");
		p37.addToTypeList(null);
		p37.setSpritePic("resources/37.png");
		addToDexList(p37);
		
		//Ninetails
		Pokemon p38 = new Pokemon("Ninetails");
		p38.setPokeNum(38);
		p38.setGeneration(1);
		p38.setHeight(1.1);
		p38.setWeight(19.9);
		p38.addToTypeList("Fire");
		p38.addToTypeList(null);
		p38.setSpritePic("resources/38.png");
		addToDexList(p38);
		
		//VulpixEvoFam
		p37.addToEvoFamily(p37);
		p37.addToEvoFamily(p38);
		p38.addToEvoFamily(p37);
		p38.addToEvoFamily(p38);
		
		//Jigglypuff
		Pokemon p39 = new Pokemon("Jigglypuff");
		p39.setPokeNum(39);
		p39.setGeneration(1);
		p39.setHeight(0.5);
		p39.setWeight(5.5);
		p39.addToTypeList("Normal");
		p39.addToTypeList("Fairy");
		p39.setSpritePic("resources/39.png");
		addToDexList(p39);
		
		//Wigglytuff
		Pokemon p40 = new Pokemon("Wigglytuff");
		p40.setPokeNum(40);
		p40.setGeneration(1);
		p40.setHeight(1.0);
		p40.setWeight(12.0);
		p40.addToTypeList("Normal");
		p40.addToTypeList("Fairy");
		p40.setSpritePic("resources/40.png");
		addToDexList(p40);
		
		//JigglyEvoFam
		p39.addToEvoFamily(p39);
		p39.addToEvoFamily(p40);
		p40.addToEvoFamily(p39);
		p40.addToEvoFamily(p40);
		
		//Zubat
		Pokemon p41 = new Pokemon("Zubat");
		p41.setPokeNum(41);
		p41.setGeneration(1);
		p41.setHeight(0.8);
		p41.setWeight(7.5);
		p41.addToTypeList("Poison");
		p41.addToTypeList("Flying");
		p41.setSpritePic("resources/41.png");
		addToDexList(p41);
		
		//Golbat
		Pokemon p42 = new Pokemon("Golbat");
		p42.setPokeNum(42);
		p42.setGeneration(1);
		p42.setHeight(1.6);
		p42.setWeight(55.0);
		p42.addToTypeList("Poison");
		p42.addToTypeList("Flying");
		p42.setSpritePic("resources/42.png");
		addToDexList(p42);
		
		//ZubatEvoFam
		p41.addToEvoFamily(p41);
		p41.addToEvoFamily(p42);
		p42.addToEvoFamily(p41);
		p42.addToEvoFamily(p42);
		
		//Oddish
		Pokemon p43 = new Pokemon("Oddish");
		p43.setPokeNum(43);
		p43.setGeneration(1);
		p43.setHeight(0.5);
		p43.setWeight(5.4);
		p43.addToTypeList("Grass");
		p43.addToTypeList("Poison");
		p43.setSpritePic("resources/43.png");
		addToDexList(p43);
		
		//Gloom
		Pokemon p44 = new Pokemon("Gloom");
		p44.setPokeNum(44);
		p44.setGeneration(1);
		p44.setHeight(0.8);
		p44.setWeight(8.6);
		p44.addToTypeList("Grass");
		p44.addToTypeList("Poison");
		p44.setSpritePic("resources/44.png");
		addToDexList(p44);
		
		//Vileplume
		Pokemon p45 = new Pokemon("Vileplume");
		p45.setPokeNum(45);
		p45.setGeneration(1);
		p45.setHeight(1.2);
		p45.setWeight(18.6);
		p45.addToTypeList("Grass");
		p45.addToTypeList("Poison");
		p45.setSpritePic("resources/45.png");
		addToDexList(p45);
		
		//OddishEvoFam
		p43.addToEvoFamily(p43);
		p43.addToEvoFamily(p44);
		p43.addToEvoFamily(p45);
		p44.addToEvoFamily(p43);
		p44.addToEvoFamily(p44);
		p44.addToEvoFamily(p45);
		p45.addToEvoFamily(p43);
		p45.addToEvoFamily(p44);
		p45.addToEvoFamily(p45);
	
		//Paras
		Pokemon p46 = new Pokemon("Paras");
		p46.setPokeNum(46);
		p46.setGeneration(1);
		p46.setHeight(0.3);
		p46.setWeight(5.4);
		p46.addToTypeList("Bug");
		p46.addToTypeList("Grass");
		p46.setSpritePic("resources/46.png");
		addToDexList(p46);
		
		//Parasect
		Pokemon p47 = new Pokemon("Parasect");
		p47.setPokeNum(47);
		p47.setGeneration(1);
		p47.setHeight(1.0);
		p47.setWeight(29.5);
		p47.addToTypeList("Bug");
		p47.addToTypeList("Grass");
		p47.setSpritePic("resources/47.png");
		addToDexList(p47);
		
		//ParasEvoFam
		p46.addToEvoFamily(p46);
		p46.addToEvoFamily(p47);
		p47.addToEvoFamily(p46);
		p47.addToEvoFamily(p47);
		
		//Venonat
		Pokemon p48 = new Pokemon("Venonat");
		p48.setPokeNum(48);
		p48.setGeneration(1);
		p48.setHeight(1.0);
		p48.setWeight(30.0);
		p48.addToTypeList("Bug");
		p48.addToTypeList("Poison");
		p48.setSpritePic("resources/48.png");
		addToDexList(p48);
		
		//Venomoth
		Pokemon p49 = new Pokemon("Venomoth");
		p49.setPokeNum(49);
		p49.setGeneration(1);
		p49.setHeight(1.5);
		p49.setWeight(12.5);
		p49.addToTypeList("Bug");
		p49.addToTypeList("Poison");
		p49.setSpritePic("resources/49.png");
		addToDexList(p49);
		
		//VenoEvoFam
		p48.addToEvoFamily(p48);
		p48.addToEvoFamily(p49);
		p49.addToEvoFamily(p48);
		p49.addToEvoFamily(p49);
		
		//Diglett
		Pokemon p50 = new Pokemon("Diglett");
		p50.setPokeNum(50);
		p50.setGeneration(1);
		p50.setHeight(0.2);
		p50.setWeight(0.8);
		p50.addToTypeList("Ground");
		p50.addToTypeList(null);
		p50.setSpritePic("resources/50.png");
		addToDexList(p50);
		
		//Dugtrio
		Pokemon p51 = new Pokemon("Dugtrio");
		p51.setPokeNum(51);
		p51.setGeneration(1);
		p51.setHeight(0.7);
		p51.setWeight(33.3);
		p51.addToTypeList("Ground");
		p51.addToTypeList(null);
		p51.setSpritePic("resources/51.png");
		addToDexList(p51);
		
		//DugEvoFam
		p50.addToEvoFamily(p50);
		p50.addToEvoFamily(p51);
		p51.addToEvoFamily(p50);
		p51.addToEvoFamily(p51);
		
		//Meowth
		Pokemon p52 = new Pokemon("Meowth");
		p52.setPokeNum(52);
		p52.setGeneration(1);
		p52.setHeight(0.4);
		p52.setWeight(4.2);
		p52.addToTypeList("Normal");
		p52.setSpritePic("resources/52.png");
		p52.addToTypeList(null);
		addToDexList(p52);
		
		//Persian
		Pokemon p53 = new Pokemon("Persian");
		p53.setPokeNum(53);
		p53.setGeneration(1);
		p53.setHeight(1.0);
		p53.setWeight(32.0);
		p53.addToTypeList("Normal");
		p53.setSpritePic("resources/53.png");
		p53.addToTypeList(null);
		addToDexList(p53);
		
		//MeoEvoFam
		p52.addToEvoFamily(p52);
		p52.addToEvoFamily(p53);
		p53.addToEvoFamily(p52);
		p53.addToEvoFamily(p53);
		
		//Psyduck
		Pokemon p54 = new Pokemon("Psyduck");
		p54.setPokeNum(54);
		p54.setGeneration(1);
		p54.setHeight(0.8);
		p54.setWeight(19.6);
		p54.addToTypeList("Water");
		p54.addToTypeList(null);
		p54.setSpritePic("resources/54.png");
		addToDexList(p54);
		
		//Golduck
		Pokemon p55 = new Pokemon("Golduck");
		p55.setPokeNum(55);
		p55.setGeneration(1);
		p55.setHeight(1.7);
		p55.setWeight(76.6);
		p55.addToTypeList("Water");
		p55.addToTypeList(null);
		p55.setSpritePic("resources/55.png");
		addToDexList(p55);
		
		//PsyEvoFam
		p54.addToEvoFamily(p54);
		p54.addToEvoFamily(p55);
		p55.addToEvoFamily(p54);
		p55.addToEvoFamily(p55);
		
		//Mankey
		Pokemon p56 = new Pokemon("Mankey");
		p56.setPokeNum(56);
		p56.setGeneration(1);
		p56.setHeight(0.5);
		p56.setWeight(28.0);
		p56.addToTypeList("Fighting");
		p56.addToTypeList(null);
		p56.setSpritePic("resources/56.png");
		addToDexList(p56);
		
		//Primeape
		Pokemon p57 = new Pokemon("Primeape");
		p57.setPokeNum(57);
		p57.setGeneration(1);
		p57.setHeight(1.0);
		p57.setWeight(32.0);
		p57.addToTypeList("Fighting");
		p57.addToTypeList(null);
		p57.setSpritePic("resources/57.png");
		addToDexList(p57);
		
		//MankEvoFam
		p56.addToEvoFamily(p56);
		p56.addToEvoFamily(p57);
		p57.addToEvoFamily(p56);
		p57.addToEvoFamily(p57);
		
		//Growlithe
		Pokemon p58 = new Pokemon("Growlithe");
		p58.setPokeNum(58);
		p58.setGeneration(1);
		p58.setHeight(0.7);
		p58.setWeight(19.0);
		p58.addToTypeList("Fire");
		p58.addToTypeList(null);
		p58.setSpritePic("resources/58.png");
		addToDexList(p58);
		
		//Arcanine
		Pokemon p59 = new Pokemon("Arcanine");
		p59.setPokeNum(59);
		p59.setGeneration(1);
		p59.setHeight(1.9);
		p59.setWeight(155.0);
		p59.addToTypeList("Fire");
		p59.addToTypeList(null);
		p59.setSpritePic("resources/59.png");
		addToDexList(p59);
		
		//Poliwag
		Pokemon p60 = new Pokemon("Poliwag");
		p60.setPokeNum(60);
		p60.setGeneration(1);
		p60.setHeight(0.6);
		p60.setWeight(12.4);
		p60.addToTypeList("Water");
		p60.addToTypeList(null);
		p60.setSpritePic("resources/60.png");
		addToDexList(p60);
		
		//Poliwhirl
		Pokemon p61 = new Pokemon("Poliwhirl");
		p61.setPokeNum(61);
		p61.setGeneration(1);
		p61.setHeight(1.0);
		p61.setWeight(20.0);
		p61.addToTypeList("Water");
		p61.addToTypeList(null);
		p61.setSpritePic("resources/61.png");
		addToDexList(p61);
		
		//Poliwrath
		Pokemon p62 = new Pokemon("Poliwrath");
		p62.setPokeNum(62);
		p62.setGeneration(1);
		p62.setHeight(1.3);
		p62.setWeight(54.0);
		p62.addToTypeList("Water");
		p62.addToTypeList(null);
		p62.setSpritePic("resources/62.png");
		addToDexList(p62);
		
		//PoliEvoFam
		p60.addToEvoFamily(p60);
		p60.addToEvoFamily(p61);
		p60.addToEvoFamily(p62);
		p61.addToEvoFamily(p60);
		p61.addToEvoFamily(p61);
		p61.addToEvoFamily(p62);
		p62.addToEvoFamily(p60);
		p62.addToEvoFamily(p61);
		p62.addToEvoFamily(p62);
		
		//Abra
		Pokemon p63 = new Pokemon("Abra");
		p63.setPokeNum(63);
		p63.setGeneration(1);
		p63.setHeight(0.9);
		p63.setWeight(19.5);
		p63.addToTypeList("Psychic");
		p63.addToTypeList(null);
		p63.setSpritePic("resources/63.png");
		addToDexList(p63);
		
		//Kadabra
		Pokemon p64 = new Pokemon("Kadabra");
		p64.setPokeNum(64);
		p64.setGeneration(1);
		p64.setHeight(1.3);
		p64.setWeight(56.5);
		p64.addToTypeList("Psychic");
		p64.addToTypeList(null);
		p64.setSpritePic("resources/64.png");
		addToDexList(p64);
		
		//Alakazam
		Pokemon p65 = new Pokemon("Alakazam");
		p65.setPokeNum(65);
		p65.setGeneration(1);
		p65.setHeight(1.5);
		p65.setWeight(48.0);
		p65.addToTypeList("Psychic");
		p65.addToTypeList(null);
		p65.setSpritePic("resources/65.png");
		addToDexList(p65);
		
		//AbraEvoFam
		p63.addToEvoFamily(p63);
		p63.addToEvoFamily(p64);
		p63.addToEvoFamily(p65);
		p64.addToEvoFamily(p63);
		p64.addToEvoFamily(p64);
		p64.addToEvoFamily(p65);
		p65.addToEvoFamily(p63);
		p65.addToEvoFamily(p64);
		p65.addToEvoFamily(p65);
		
		//Machop
		Pokemon p66 = new Pokemon("Machop");
		p66.setPokeNum(66);
		p66.setGeneration(1);
		p66.setHeight(0.8);
		p66.setWeight(19.5);
		p66.addToTypeList("Fighting");
		p66.addToTypeList(null);
		p66.setSpritePic("resources/66.png");
		addToDexList(p66);
		
		//Machoke
		Pokemon p67 = new Pokemon("Machoke");
		p67.setPokeNum(67);
		p67.setGeneration(1);
		p67.setHeight(1.5);
		p67.setWeight(70.5);
		p67.addToTypeList("Fighting");
		p67.addToTypeList(null);
		p67.setSpritePic("resources/67.png");
		addToDexList(p67);
		
		//Machamp
		Pokemon p68 = new Pokemon("Machamp");
		p68.setPokeNum(68);
		p68.setGeneration(1);
		p68.setHeight(1.6);
		p68.setWeight(130.0);
		p68.addToTypeList("Fighting");
		p68.addToTypeList(null);
		p68.setSpritePic("resources/68.png");
		addToDexList(p68);
		
		//MachEvoFam
		p66.addToEvoFamily(p66);
		p66.addToEvoFamily(p67);
		p66.addToEvoFamily(p68);
		p67.addToEvoFamily(p66);
		p67.addToEvoFamily(p67);
		p67.addToEvoFamily(p68);
		p68.addToEvoFamily(p66);
		p68.addToEvoFamily(p67);
		p68.addToEvoFamily(p68);
		
		//Bellsprout
		Pokemon p69 = new Pokemon("Bellsprout"); //nice
		p69.setPokeNum(69);
		p69.setGeneration(1);
		p69.setHeight(0.7);
		p69.setWeight(4.0);
		p69.addToTypeList("Grass");
		p69.addToTypeList("Poison");
		p69.setSpritePic("resources/69.png");
		addToDexList(p69);
		
		//Weepinbell
		Pokemon p70 = new Pokemon("Weepinbell");
		p70.setPokeNum(70);
		p70.setGeneration(1);
		p70.setHeight(1.0);
		p70.setWeight(6.4);
		p70.addToTypeList("Grass");
		p70.addToTypeList("Poison");
		p70.setSpritePic("resources/70.png");
		addToDexList(p70);
		
		//Victreebel
		Pokemon p71 = new Pokemon("Victreebel");
		p71.setPokeNum(71);
		p71.setGeneration(1);
		p71.setHeight(1.7);
		p71.setWeight(15.5);
		p71.addToTypeList("Grass");
		p71.addToTypeList("Poison");
		p71.setSpritePic("resources/71.png");
		addToDexList(p71);
		
		//BellEvoFam
		p69.addToEvoFamily(p69);
		p69.addToEvoFamily(p70);
		p69.addToEvoFamily(p71);
		p70.addToEvoFamily(p69);
		p70.addToEvoFamily(p70);
		p70.addToEvoFamily(p71);
		p71.addToEvoFamily(p69);
		p71.addToEvoFamily(p70);
		p71.addToEvoFamily(p71);
		
		//Tentacool
		Pokemon p72 = new Pokemon("Tentacool");
		p72.setPokeNum(72);
		p72.setGeneration(1);
		p72.setHeight(0.9);
		p72.setWeight(45.5);
		p72.addToTypeList("Water");
		p72.addToTypeList("Poison");
		p72.setSpritePic("resources/72.png");
		addToDexList(p72);
		
		//Tentacruel
		Pokemon p73 = new Pokemon("Tentacruel");
		p73.setPokeNum(73);
		p73.setGeneration(1);
		p73.setHeight(1.6);
		p73.setWeight(55.0);
		p73.addToTypeList("Water");
		p73.addToTypeList("Poison");
		p73.setSpritePic("resources/73.png");
		addToDexList(p73);
		
		//TentEvoFam
		p72.addToEvoFamily(p72);
		p72.addToEvoFamily(p73);
		p73.addToEvoFamily(p72);
		p73.addToEvoFamily(p73);
		
		//Geodude
		Pokemon p74 = new Pokemon("Geodude");
		p74.setPokeNum(74);
		p74.setGeneration(1);
		p74.setHeight(0.4);
		p74.setWeight(22.0);
		p74.addToTypeList("Rock");
		p74.addToTypeList("Ground");
		p74.setSpritePic("resources/74.png");
		addToDexList(p74);
		
		//Graveler
		Pokemon p75 = new Pokemon("Graveler");
		p75.setPokeNum(75);
		p75.setGeneration(1);
		p75.setHeight(1.0);
		p75.setWeight(105.0);
		p75.addToTypeList("Rock");
		p75.addToTypeList("Ground");
		p75.setSpritePic("resources/75.png");
		addToDexList(p75);
		
		//Golem
		Pokemon p76 = new Pokemon("Golem");
		p76.setPokeNum(76);
		p76.setGeneration(1);
		p76.setHeight(1.4);
		p76.setWeight(300.0);
		p76.addToTypeList("Rock");
		p76.addToTypeList("Ground");
		p76.setSpritePic("resources/76.png");
		addToDexList(p76);
		
		//GeoEvoFam
		p74.addToEvoFamily(p74);
		p74.addToEvoFamily(p75);
		p74.addToEvoFamily(p76);
		p75.addToEvoFamily(p74);
		p75.addToEvoFamily(p75);
		p75.addToEvoFamily(p76);
		p76.addToEvoFamily(p74);
		p76.addToEvoFamily(p75);
		p76.addToEvoFamily(p76);
		
		//Ponyta
		Pokemon p77 = new Pokemon("Ponyta");
		p77.setPokeNum(77);
		p77.setGeneration(1);
		p77.setHeight(1.0);
		p77.setWeight(30.0);
		p77.addToTypeList("Fire");
		p77.addToTypeList(null);
		p77.setSpritePic("resources/77.png");
		addToDexList(p77);
		
		//Rapidash
		Pokemon p78 = new Pokemon("Rapidash");
		p78.setPokeNum(78);
		p78.setGeneration(1);
		p78.setHeight(1.7);
		p78.setWeight(95.0);
		p78.addToTypeList("Fire");
		p78.addToTypeList(null);
		p78.setSpritePic("resources/78.png");
		addToDexList(p78);
		
		//RapidEvoFam
		p77.addToEvoFamily(p77);
		p77.addToEvoFamily(p78);
		p78.addToEvoFamily(p77);
		p78.addToEvoFamily(p78);
		
		//Slowpoke
		Pokemon p79 = new Pokemon("Slowpoke");
		p79.setPokeNum(79);
		p79.setGeneration(1);
		p79.setHeight(1.2);
		p79.setWeight(36.0);
		p79.addToTypeList("Water");
		p79.addToTypeList("Psychic");
		p79.setSpritePic("resources/79.png");
		addToDexList(p79);
		
		//Slowbro
		Pokemon p80 = new Pokemon("Slowbro");
		p80.setPokeNum(80);
		p80.setGeneration(1);
		p80.setHeight(1.6);
		p80.setWeight(78.5);
		p80.addToTypeList("Water");
		p80.addToTypeList("Psychic");
		p80.setSpritePic("resources/80.png");
		addToDexList(p80);
		
		//SlowEvoFam
		p79.addToEvoFamily(p79);
		p79.addToEvoFamily(p80);
		p80.addToEvoFamily(p79);
		p80.addToEvoFamily(p80);
		
		//Magnemite
		Pokemon p81 = new Pokemon("Magnemite");
		p81.setPokeNum(81);
		p81.setGeneration(1);
		p81.setHeight(0.3);
		p81.setWeight(6.0);
		p81.addToTypeList("Electric");
		p81.addToTypeList("Steel");
		p81.setSpritePic("resources/81.png");
		p81.setGender("Unknown");
		addToDexList(p81);
		
		//Magneton
		Pokemon p82 = new Pokemon("Magneton");
		p82.setPokeNum(82);
		p82.setGeneration(1);
		p82.setHeight(1.0);
		p82.setWeight(60.0);
		p82.addToTypeList("Electric");
		p82.addToTypeList("Steel");
		p82.setSpritePic("resources/82.png");
		p82.setGender("Unknown");
		addToDexList(p82);
		
		//MagEvoFam
		p81.addToEvoFamily(p81);
		p81.addToEvoFamily(p82);
		p82.addToEvoFamily(p81);
		p82.addToEvoFamily(p82);
		
		//Farfetchd
		Pokemon p83 = new Pokemon("Farfetch'd");
		p83.setPokeNum(83);
		p83.setGeneration(1);
		p83.setHeight(0.8);
		p83.setWeight(15.0);
		p83.addToTypeList("Normal");
		p83.addToTypeList("Flying");
		p83.setSpritePic("resources/83.png");
		p83.addToEvoFamily(p83);
		addToDexList(p83);
		
		//Doduo
		Pokemon p84 = new Pokemon("Doduo");
		p84.setPokeNum(84);
		p84.setGeneration(1);
		p84.setHeight(1.4);
		p84.setWeight(39.2);
		p84.addToTypeList("Normal");
		p84.addToTypeList("Flying");
		p84.setSpritePic("resources/84.png");
		addToDexList(p84);
		
		//Dodrio
		Pokemon p85 = new Pokemon("Dodrio");
		p85.setPokeNum(85);
		p85.setGeneration(1);
		p85.setHeight(1.8);
		p85.setWeight(85.2);
		p85.addToTypeList("Normal");
		p85.addToTypeList("Flying");
		p85.setSpritePic("resources/85.png");
		addToDexList(p85);
		
		//DodEvoFam
		p84.addToEvoFamily(p84);
		p84.addToEvoFamily(p85);
		p85.addToEvoFamily(p84);
		p85.addToEvoFamily(p85);
		
		//Seel
		Pokemon p86 = new Pokemon("Seel");
		p86.setPokeNum(86);
		p86.setGeneration(1);
		p86.setHeight(1.1);
		p86.setWeight(90.0);
		p86.addToTypeList("Water");
		p86.addToTypeList(null);
		p86.setSpritePic("resources/86.png");
		addToDexList(p86);
		
		//Dewgong
		Pokemon p87 = new Pokemon("Dewgong");
		p87.setPokeNum(87);
		p87.setGeneration(1);
		p87.setHeight(1.7);
		p87.setWeight(120.0);
		p87.addToTypeList("Water");
		p87.addToTypeList("Ice");
		p87.setSpritePic("resources/87.png");
		addToDexList(p87);
		
		//SeelEvoFam
		p86.addToEvoFamily(p86);
		p86.addToEvoFamily(p87);
		p87.addToEvoFamily(p86);
		p87.addToEvoFamily(p87);
		
		//Grimer
		Pokemon p88 = new Pokemon("Grimer");
		p88.setPokeNum(88);
		p88.setGeneration(1);
		p88.setHeight(0.9);
		p88.setWeight(30.0);
		p88.addToTypeList("Poison");
		p88.addToTypeList(null);
		p88.setSpritePic("resources/88.png");
		addToDexList(p88);
		
		//Muk
		Pokemon p89 = new Pokemon("Muk");
		p89.setPokeNum(89);
		p89.setGeneration(1);
		p89.setHeight(1.2);
		p89.setWeight(30.0);
		p89.addToTypeList("Poison");
		p89.addToTypeList(null);
		p89.setSpritePic("resources/89.png");
		addToDexList(p89);
		
		//GrimerEvoFam
		p88.addToEvoFamily(p88);
		p88.addToEvoFamily(p89);
		p89.addToEvoFamily(p88);
		p89.addToEvoFamily(p89);
		
		//Shellder
		Pokemon p90 = new Pokemon("Shellder");
		p90.setPokeNum(90);
		p90.setGeneration(1);
		p90.setHeight(0.3);
		p90.setWeight(4.0);
		p90.addToTypeList("Water");
		p90.addToTypeList(null);
		p90.setSpritePic("resources/90.png");
		addToDexList(p90);
		
		//Cloyster
		Pokemon p91 = new Pokemon("Cloyster");
		p91.setPokeNum(91);
		p91.setGeneration(1);
		p91.setHeight(1.5);
		p91.setWeight(132.5);
		p91.addToTypeList("Water");
		p91.addToTypeList("Ice");
		p91.setSpritePic("resources/91.png");
		addToDexList(p91);
		
		//ShellEvoFam
		p90.addToEvoFamily(p90);
		p90.addToEvoFamily(p91);
		p91.addToEvoFamily(p90);
		p91.addToEvoFamily(p91);
		
		//Gastly
		Pokemon p92 = new Pokemon("Gastly");
		p92.setPokeNum(92);
		p92.setGeneration(1);
		p92.setHeight(1.3);
		p92.setWeight(0.1);
		p92.addToTypeList("Ghost");
		p92.addToTypeList("Poison");
		p92.setSpritePic("resources/92.png");
		addToDexList(p92);
		
		//Haunter
		Pokemon p93 = new Pokemon("Haunter");
		p93.setPokeNum(93);
		p93.setGeneration(1);
		p93.setHeight(1.6);
		p93.setWeight(0.1);
		p93.addToTypeList("Ghost");
		p93.addToTypeList("Poison");
		p93.setSpritePic("resources/93.png");
		addToDexList(p93);
		
		//Gengar
		Pokemon p94 = new Pokemon("Gengar");
		p94.setPokeNum(94);
		p94.setGeneration(1);
		p94.setHeight(1.5);
		p94.setWeight(40.5);
		p94.addToTypeList("Ghost");
		p94.addToTypeList("Poison");
		p94.setSpritePic("resources/94.png");
		addToDexList(p94);
		
		//GastEvoFam
		p92.addToEvoFamily(p92);
		p92.addToEvoFamily(p93);
		p92.addToEvoFamily(p94);
		p93.addToEvoFamily(p92);
		p93.addToEvoFamily(p93);
		p93.addToEvoFamily(p94);
		p94.addToEvoFamily(p92);
		p94.addToEvoFamily(p93);
		p94.addToEvoFamily(p94);
		
		//Onix
		Pokemon p95 = new Pokemon("Onix");
		p95.setPokeNum(95);
		p95.setGeneration(1);
		p95.setHeight(8.8);
		p95.setWeight(210.0);
		p95.addToTypeList("Rock");
		p95.addToTypeList("Ground");
		p95.setSpritePic("resources/95.png");
		addToDexList(p95);
		p95.addToEvoFamily(p95);
		
		//Drowzee
		Pokemon p96 = new Pokemon("Drowzee");
		p96.setPokeNum(96);
		p96.setGeneration(1);
		p96.setHeight(1.0);
		p96.setWeight(32.4);
		p96.addToTypeList("Psychic");
		p96.addToTypeList(null);
		p96.setSpritePic("resources/96.png");
		addToDexList(p96);
		
		//Hypno
		Pokemon p97 = new Pokemon("Hypno");
		p97.setPokeNum(97);
		p97.setGeneration(1);
		p97.setHeight(1.6);
		p97.setWeight(75.6);
		p97.addToTypeList("Psychic");
		p97.addToTypeList(null);
		p97.setSpritePic("resources/97.png");
		addToDexList(p97);
		
		//DrowEvoFam
		p96.addToEvoFamily(p96);
		p96.addToEvoFamily(p97);
		p97.addToEvoFamily(p96);
		p97.addToEvoFamily(p97);
		
		//Krabby
		Pokemon p98 = new Pokemon("Krabby");
		p98.setPokeNum(98);
		p98.setGeneration(1);
		p98.setHeight(0.4);
		p98.setWeight(6.5);
		p98.addToTypeList("Water");
		p98.addToTypeList(null);
		p98.setSpritePic("resources/98.png");
		addToDexList(p98);
		
		//Kingler
		Pokemon p99 = new Pokemon("Kingler");
		p99.setPokeNum(99);
		p99.setGeneration(1);
		p99.setHeight(1.3);
		p99.setWeight(60.0);
		p99.addToTypeList("Water");
		p99.addToTypeList(null);
		p99.setSpritePic("resources/99.png");
		addToDexList(p99);
		
		//KrabEvoFam
		p98.addToEvoFamily(p98);
		p98.addToEvoFamily(p99);
		p99.addToEvoFamily(p98);
		p99.addToEvoFamily(p99);
		
		//Voltorb
		Pokemon p100 = new Pokemon("Voltorb");
		p100.setPokeNum(100);
		p100.setGeneration(1);
		p100.setHeight(0.5);
		p100.setWeight(10.4);
		p100.addToTypeList("Electric");
		p100.addToTypeList(null);
		p100.setSpritePic("resources/100.png");
		addToDexList(p100);
		
		//Electrode
		Pokemon p101 = new Pokemon("Electrode");
		p101.setPokeNum(101);
		p101.setGeneration(1);
		p101.setHeight(1.2);
		p101.setWeight(66.6);
		p101.addToTypeList("Electric");
		p101.addToTypeList(null);
		p101.setSpritePic("resources/101.png");
		addToDexList(p101);
		
		//VoltEvoFam
		p100.addToEvoFamily(p100);
		p100.addToEvoFamily(p101);
		p101.addToEvoFamily(p100);
		p101.addToEvoFamily(p101);
		
		//Exeggcute
		Pokemon p102 = new Pokemon("Exeggcute");
		p102.setPokeNum(102);
		p102.setGeneration(1);
		p102.setHeight(0.4);
		p102.setWeight(2.5);
		p102.addToTypeList("Grass");
		p102.addToTypeList("Psychic");
		p102.setSpritePic("resources/102.png");
		addToDexList(p102);
		
		//Exeggutor
		Pokemon p103 = new Pokemon("Exeggutor");
		p103.setPokeNum(103);
		p103.setGeneration(1);
		p103.setHeight(2.0);
		p103.setWeight(120.0);
		p103.addToTypeList("Grass");
		p103.addToTypeList("Psychic");
		p103.setSpritePic("resources/103.png");
		addToDexList(p103);
		
		//EggEvoFamm
		p102.addToEvoFamily(p102);
		p102.addToEvoFamily(p103);
		p103.addToEvoFamily(p102);
		p103.addToEvoFamily(p103);
		
		//Cubone
		Pokemon p104 = new Pokemon("Cubone");
		p104.setPokeNum(104);
		p104.setGeneration(1);
		p104.setHeight(0.4);
		p104.setWeight(6.5);
		p104.addToTypeList("Ground");
		p104.addToTypeList(null);
		p104.setSpritePic("resources/104.png");
		addToDexList(p104);
		
		//Marowak
		Pokemon p105 = new Pokemon("Marowak");
		p105.setPokeNum(105);
		p105.setGeneration(1);
		p105.setHeight(1.0);
		p105.setWeight(45.0);
		p105.addToTypeList("Ground");
		p105.addToTypeList(null);
		p105.setSpritePic("resources/105.png");
		addToDexList(p105);
		
		//BoneEvoFam
		p104.addToEvoFamily(p104);
		p104.addToEvoFamily(p105);
		p105.addToEvoFamily(p104);
		p105.addToEvoFamily(p105);
		
		//Hitmonlee
		Pokemon p106 = new Pokemon("Hitmonlee");
		p106.setPokeNum(106);
		p106.setGeneration(1);
		p106.setHeight(1.5);
		p106.setWeight(49.8);
		p106.addToTypeList("Fighting");
		p106.addToTypeList(null);
		p106.setSpritePic("resources/106.png");
		p106.setGender("Male");
		addToDexList(p106);
		
		//Hitmonchan
		Pokemon p107 = new Pokemon("Hitmonchan");
		p107.setPokeNum(107);
		p107.setGeneration(1);
		p107.setHeight(1.4);
		p107.setWeight(50.2);
		p107.addToTypeList("Fighting");
		p107.addToTypeList(null);
		p107.setSpritePic("resources/107.png");
		p107.setGender("Male");
		addToDexList(p107);
		
		//HitEvoFam
		p106.addToEvoFamily(p106);
		p106.addToEvoFamily(p107);
		p107.addToEvoFamily(p106);
		p107.addToEvoFamily(p107);
		
		//Lickitung
		Pokemon p108 = new Pokemon("Lickitung");
		p108.setPokeNum(108);
		p108.setGeneration(1);
		p108.setHeight(1.2);
		p108.setWeight(65.5);
		p108.addToTypeList("Normal");
		p108.addToTypeList(null);
		p108.setSpritePic("resources/108.png");
		addToDexList(p108);
		p108.addToEvoFamily(p108);
		
		//Koffing
		Pokemon p109 = new Pokemon("Koffing");
		p109.setPokeNum(109);
		p109.setGeneration(1);
		p109.setHeight(0.6);
		p109.setWeight(1.0);
		p109.addToTypeList("Poison");
		p109.addToTypeList(null);
		p109.setSpritePic("resources/109.png");
		addToDexList(p109);
		
		//Weezing
		Pokemon p110 = new Pokemon("Weezing");
		p110.setPokeNum(110);
		p110.setGeneration(1);
		p110.setHeight(1.2);
		p110.setWeight(9.5);
		p110.addToTypeList("Poison");
		p110.addToTypeList(null);
		p110.setSpritePic("resources/110.png");
		addToDexList(p110);
		
		//KoffEvoFam
		p109.addToEvoFamily(p109);
		p109.addToEvoFamily(p110);
		p110.addToEvoFamily(p109);
		p110.addToEvoFamily(p110);
		
		//Rhyhorn
		Pokemon p111 = new Pokemon("Rhyhorn");
		p111.setPokeNum(111);
		p111.setGeneration(1);
		p111.setHeight(1.0);
		p111.setWeight(115.0);
		p111.addToTypeList("Ground");
		p111.addToTypeList("Rock");
		p111.setSpritePic("resources/111.png");
		addToDexList(p111);
		
		//Rhydon
		Pokemon p112 = new Pokemon("Rhydon");
		p112.setPokeNum(112);
		p112.setGeneration(1);
		p112.setHeight(1.9);
		p112.setWeight(120.0);
		p112.addToTypeList("Ground");
		p112.addToTypeList("Rock");
		p112.setSpritePic("resources/112.png");
		addToDexList(p112);
		
		//HornEvoFam
		p111.addToEvoFamily(p111);
		p111.addToEvoFamily(p112);
		p112.addToEvoFamily(p111);
		p112.addToEvoFamily(p112);
		
		//Chancey
		Pokemon p113 = new Pokemon("Chansey");
		p113.setPokeNum(113);
		p113.setGeneration(1);
		p113.setHeight(1.1);
		p113.setWeight(34.6);
		p113.addToTypeList("Normal");
		p113.addToTypeList(null);
		p113.setSpritePic("resources/113.png");
		p113.setGender("Female");
		addToDexList(p113);
		p113.addToEvoFamily(p113);
		
		//Tangela
		Pokemon p114 = new Pokemon("Tangela");
		p114.setPokeNum(114);
		p114.setGeneration(1);
		p114.setHeight(1.0);
		p114.setWeight(35.0);
		p114.addToTypeList("Grass");
		p114.addToTypeList(null);
		p114.setSpritePic("resources/114.png");
		addToDexList(p114);
		p114.addToEvoFamily(p114);
		
		//Kangaskhan
		Pokemon p115 = new Pokemon("Kangaskhan");
		p115.setPokeNum(115);
		p115.setGeneration(1);
		p115.setHeight(2.2);
		p115.setWeight(80.0);
		p115.addToTypeList("Normal");
		p115.addToTypeList(null);
		p115.setSpritePic("resources/115.png");
		p115.setGender("Female");
		addToDexList(p115);
		p115.addToEvoFamily(p115);
		
		//Horsea
		Pokemon p116 = new Pokemon("Horsea");
		p116.setPokeNum(116);
		p116.setGeneration(1);
		p116.setHeight(0.4);
		p116.setWeight(8.0);
		p116.addToTypeList("Water");
		p116.addToTypeList(null);
		p116.setSpritePic("resources/116.png");
		addToDexList(p116);
		
		//Seadra
		Pokemon p117 = new Pokemon("Seadra");
		p117.setPokeNum(117);
		p117.setGeneration(1);
		p117.setHeight(1.2);
		p117.setWeight(25.0);
		p117.addToTypeList("Water");
		p117.addToTypeList(null);
		p117.setSpritePic("resources/117.png");
		addToDexList(p117);
		
		//SeaEvoFam
		p116.addToEvoFamily(p116);
		p116.addToEvoFamily(p117);
		p117.addToEvoFamily(p116);
		p117.addToEvoFamily(p117);
		
		//Goldeen
		Pokemon p118 = new Pokemon("Goldeen");
		p118.setPokeNum(118);
		p118.setGeneration(1);
		p118.setHeight(0.6);
		p118.setWeight(15.0);
		p118.addToTypeList("Water");
		p118.addToTypeList(null);
		p118.setSpritePic("resources/118.png");
		addToDexList(p118);
		
		//Seaking
		Pokemon p119 = new Pokemon("Seaking");
		p119.setPokeNum(119);
		p119.setGeneration(1);
		p119.setHeight(1.3);
		p119.setWeight(39.0);
		p119.addToTypeList("Water");
		p119.addToTypeList(null);
		p119.setSpritePic("resources/119.png");
		addToDexList(p119);
		
		//GoldEvoFam
		p118.addToEvoFamily(p118);
		p118.addToEvoFamily(p119);
		p119.addToEvoFamily(p118);
		p119.addToEvoFamily(p119);
		
		//Staryu
		Pokemon p120 = new Pokemon("Staryu");
		p120.setPokeNum(120);
		p120.setGeneration(1);
		p120.setHeight(0.8);
		p120.setWeight(34.5);
		p120.addToTypeList("Water");
		p120.addToTypeList(null);
		p120.setSpritePic("resources/120.png");
		p120.setGender("Unknown");
		addToDexList(p120);
		
		//Starmie
		Pokemon p121 = new Pokemon("Starmie");
		p121.setPokeNum(121);
		p121.setGeneration(1);
		p121.setHeight(1.1);
		p121.setWeight(80.0);
		p121.addToTypeList("Water");
		p121.addToTypeList("Psychic");
		p121.setSpritePic("resources/121.png");
		p121.setGender("Unknown");
		addToDexList(p121);
		
		//StarEvoFam
		p120.addToEvoFamily(p120);
		p120.addToEvoFamily(p121);
		p121.addToEvoFamily(p120);
		p121.addToEvoFamily(p121);
		
		//Mr. Mime
		Pokemon p122 = new Pokemon("Mr. Mime");
		p122.setPokeNum(122);
		p122.setGeneration(1);
		p122.setHeight(1.3);
		p122.setWeight(54.5);
		p122.addToTypeList("Psychic");
		p122.addToTypeList("Fairy");
		p122.setSpritePic("resources/122.png");
		addToDexList(p122);
		p122.addToEvoFamily(p122);
		
		//Scyther
		Pokemon p123 = new Pokemon("Scyther");
		p123.setPokeNum(123);
		p123.setGeneration(1);
		p123.setHeight(1.5);
		p123.setWeight(56.0);
		p123.addToTypeList("Bug");
		p123.addToTypeList("Flying");
		p123.setSpritePic("resources/123.png");
		addToDexList(p123);
		p123.addToEvoFamily(p123);
		
		//Jynx
		Pokemon p124 = new Pokemon("Jynx");
		p124.setPokeNum(124);
		p124.setGeneration(1);
		p124.setHeight(1.4);
		p124.setWeight(40.6);
		p124.addToTypeList("Ice");
		p124.addToTypeList("Psychic");
		p124.setSpritePic("resources/124.png");
		addToDexList(p124);
		p124.addToEvoFamily(p124);
		
		//Electabuzz
		Pokemon p125 = new Pokemon("Electabuzz");
		p125.setPokeNum(125);
		p125.setGeneration(1);
		p125.setHeight(1.1);
		p125.setWeight(30.0);
		p125.addToTypeList("Electric");
		p125.addToTypeList(null);
		p125.setSpritePic("resources/125.png");
		addToDexList(p125);
		p125.addToEvoFamily(p125);
		
		//Magmar
		Pokemon p126 = new Pokemon("Magmar");
		p126.setPokeNum(126);
		p126.setGeneration(1);
		p126.setHeight(1.3);
		p126.setWeight(44.5);
		p126.addToTypeList("Fire");
		p126.addToTypeList(null);
		p126.setSpritePic("resources/126.png");
		addToDexList(p126);
		p126.addToEvoFamily(p126);
		
		//Pinsir
		Pokemon p127 = new Pokemon("Pinsir");
		p127.setPokeNum(127);
		p127.setGeneration(1);
		p127.setHeight(1.5);
		p127.setWeight(55.0);
		p127.addToTypeList("Bug");
		p127.addToTypeList(null);
		p127.setSpritePic("resources/127.png");
		addToDexList(p127);
		p127.addToEvoFamily(p127);
		
		//Tauros
		Pokemon p128 = new Pokemon("Tauros");
		p128.setPokeNum(128);
		p128.setGeneration(1);
		p128.setHeight(1.4);
		p128.setWeight(88.4);
		p128.addToTypeList("Normal");
		p128.addToTypeList(null);
		p128.setSpritePic("resources/128.png");
		p128.setGender("Male");
		addToDexList(p128);
		p128.addToEvoFamily(p128);
		
		//Magikarp
		Pokemon p129 = new Pokemon("Magikarp");
		p129.setPokeNum(129);
		p129.setGeneration(1);
		p129.setHeight(0.9);
		p129.setWeight(10.0);
		p129.addToTypeList("Water");
		p129.addToTypeList(null);
		p129.setSpritePic("resources/129.png");
		addToDexList(p129);
		
		//Gyarados
		Pokemon p130 = new Pokemon("Gyarados");
		p130.setPokeNum(130);
		p130.setGeneration(1);
		p130.setHeight(6.5);
		p130.setWeight(235.0);
		p130.addToTypeList("Water");
		p130.addToTypeList("Flying");
		p130.setSpritePic("resources/130.png");
		addToDexList(p130);
		
		//KarpEvoFam
		p129.addToEvoFamily(p129);
		p129.addToEvoFamily(p130);
		p130.addToEvoFamily(p129);
		p130.addToEvoFamily(p130);
		
		//Lapras
		Pokemon p131 = new Pokemon("Lapras");
		p131.setPokeNum(131);
		p131.setGeneration(1);
		p131.setHeight(2.5);
		p131.setWeight(220.0);
		p131.addToTypeList("Water");
		p131.addToTypeList("Ice");
		p131.setSpritePic("resources/131.png");
		addToDexList(p131);
		p131.addToEvoFamily(p131);
		
		//Ditto
		Pokemon p132 = new Pokemon("Ditto");
		p132.setPokeNum(132);
		p132.setGeneration(1);
		p132.setHeight(0.3);
		p132.setWeight(4.0);
		p132.addToTypeList("Normal");
		p132.addToTypeList(null);
		p132.setSpritePic("resources/132.png");
		p132.setGender("Unknown");
		addToDexList(p132);
		p132.addToEvoFamily(p132);
		
		//Eevee
		Pokemon p133 = new Pokemon("Eevee");
		p133.setPokeNum(133);
		p133.setGeneration(1);
		p133.setHeight(0.3);
		p133.setWeight(6.5);
		p133.addToTypeList("Normal");
		p133.addToTypeList(null);
		p133.setSpritePic("resources/133.png");
		addToDexList(p133);
		
		//Vaporeon
		Pokemon p134 = new Pokemon("Vaporeon");
		p134.setPokeNum(134);
		p134.setGeneration(1);
		p134.setHeight(1.0);
		p134.setWeight(29.0);
		p134.addToTypeList("Water");
		p134.addToTypeList(null);
		p134.setSpritePic("resources/134.png");
		addToDexList(p134);
		
		//Jolteon
		Pokemon p135 = new Pokemon("Jolteon");
		p135.setPokeNum(135);
		p135.setGeneration(1);
		p135.setHeight(0.8);
		p135.setWeight(24.5);
		p135.addToTypeList("Electric");
		p135.addToTypeList(null);
		p135.setSpritePic("resources/135.png");
		addToDexList(p135);
		
		//Flareon
		Pokemon p136 = new Pokemon("Flareon");
		p136.setPokeNum(136);
		p136.setGeneration(1);
		p136.setHeight(0.9);
		p136.setWeight(25.0);
		p136.addToTypeList("Fire");
		p136.addToTypeList(null);
		p136.setSpritePic("resources/136.png");
		addToDexList(p136);
		
		//EeveeEvoFam
		p133.addToEvoFamily(p133);
		p133.addToEvoFamily(p134);
		p133.addToEvoFamily(p135);
		p133.addToEvoFamily(p136);
		p134.addToEvoFamily(p133);
		p134.addToEvoFamily(p134);
		p134.addToEvoFamily(p135);
		p134.addToEvoFamily(p136);
		p135.addToEvoFamily(p133);
		p135.addToEvoFamily(p134);
		p135.addToEvoFamily(p135);
		p135.addToEvoFamily(p136);
		p136.addToEvoFamily(p133);
		p136.addToEvoFamily(p134);
		p136.addToEvoFamily(p135);
		p136.addToEvoFamily(p136);
		
		//Porygon
		Pokemon p137 = new Pokemon("Porygon");
		p137.setPokeNum(137);
		p137.setGeneration(1);
		p137.setHeight(0.8);
		p137.setWeight(36.5);
		p137.addToTypeList("Normal");
		p137.addToTypeList(null);
		p137.setSpritePic("resources/137.png");
		p137.setGender("Unknown");
		addToDexList(p137);
		p137.addToEvoFamily(p137);
		
		//Omanyte
		Pokemon p138 = new Pokemon("Omanyte");
		p138.setPokeNum(138);
		p138.setGeneration(1);
		p138.setHeight(0.4);
		p138.setWeight(7.5);
		p138.addToTypeList("Rock");
		p138.addToTypeList("Water");
		p138.setSpritePic("resources/138.png");
		addToDexList(p138);
		
		//Omastar
		Pokemon p139 = new Pokemon("Omastar");
		p139.setPokeNum(139);
		p139.setGeneration(1);
		p139.setHeight(1.0);
		p139.setWeight(35.0);
		p139.addToTypeList("Rock");
		p139.addToTypeList("Water");
		p139.setSpritePic("resources/139.png");
		addToDexList(p139);
		
		//OmaEvoFam
		p138.addToEvoFamily(p138);
		p138.addToEvoFamily(p139);
		p139.addToEvoFamily(p138);
		p139.addToEvoFamily(p139);
		
		//Kabuto
		Pokemon p140 = new Pokemon("Kabuto");
		p140.setPokeNum(140);
		p140.setGeneration(1);
		p140.setHeight(0.5);
		p140.setWeight(11.5);
		p140.addToTypeList("Rock");
		p140.addToTypeList("Water");
		p140.setSpritePic("resources/140.png");
		addToDexList(p140);
		
		//Kabutops
		Pokemon p141 = new Pokemon("Kabutops");
		p141.setPokeNum(141);
		p141.setGeneration(1);
		p141.setHeight(1.3);
		p141.setWeight(40.5);
		p141.addToTypeList("Rock");
		p141.addToTypeList("Water");
		p141.setSpritePic("resources/141.png");
		addToDexList(p141);
		
		//KabuEvoFam
		p140.addToEvoFamily(p140);
		p140.addToEvoFamily(p141);
		p141.addToEvoFamily(p140);
		p141.addToEvoFamily(p141);
		
		//Aerodactyl
		Pokemon p142 = new Pokemon("Aerodactyl");
		p142.setPokeNum(142);
		p142.setGeneration(1);
		p142.setHeight(1.8);
		p142.setWeight(59.0);
		p142.addToTypeList("Rock");
		p142.addToTypeList("Flying");
		p142.setSpritePic("resources/142.png");
		addToDexList(p142);
		p142.addToEvoFamily(p142);
		
		//Snorlax
		Pokemon p143 = new Pokemon("Snorlax");
		p143.setPokeNum(143);
		p143.setGeneration(1);
		p143.setHeight(2.1);
		p143.setWeight(460.0);
		p143.addToTypeList("Normal");
		p143.addToTypeList(null);
		p143.setSpritePic("resources/143.png");
		addToDexList(p143);
		p143.addToEvoFamily(p143);
		
		//Articuno
		Pokemon p144 = new Pokemon("Articuno");
		p144.setPokeNum(144);
		p144.setGeneration(1);
		p144.setLegendary(true);
		p144.setHeight(1.7);
		p144.setWeight(55.4);
		p144.addToTypeList("Ice");
		p144.addToTypeList("Flying");
		p144.setSpritePic("resources/144.png");
		p144.addToEvoFamily(p144);
		addToDexList(p144);
		
		//Zapdos
		Pokemon p145 = new Pokemon("Zapdos");
		p145.setPokeNum(145);
		p145.setGeneration(1);
		p145.setLegendary(true);
		p145.setHeight(1.6);
		p145.setWeight(52.6);
		p145.addToTypeList("Electric");
		p145.addToTypeList("Flying");
		p145.setSpritePic("resources/145.png");
		p145.addToEvoFamily(p145);
		addToDexList(p145);
		
		//Moltres
		Pokemon p146 = new Pokemon("Moltres");
		p146.setPokeNum(146);
		p146.setGeneration(1);
		p146.setLegendary(true);
		p146.setHeight(2.0);
		p146.setWeight(60.0);
		p146.addToTypeList("Fire");
		p146.addToTypeList("Flying");
		p146.setSpritePic("resources/146.png");
		p146.addToEvoFamily(p146);
		addToDexList(p146);
		
		//Dratini
		Pokemon p147 = new Pokemon("Dratini");
		p147.setPokeNum(147);
		p147.setGeneration(1);
		p147.setHeight(1.8);
		p147.setWeight(3.3);
		p147.addToTypeList("Dragon");
		p147.addToTypeList(null);
		p147.setSpritePic("resources/147.png");
		addToDexList(p147);
		
		//Dragonair
		Pokemon p148 = new Pokemon("Dragonair");
		p148.setPokeNum(148);
		p148.setGeneration(1);
		p148.setHeight(4.0);
		p148.setWeight(16.5);
		p148.addToTypeList("Dragon");
		p148.addToTypeList(null);
		p148.setSpritePic("resources/148.png");
		addToDexList(p148);
		
		//Dragonite
		Pokemon p149 = new Pokemon("Dragonite");
		p149.setPokeNum(149);
		p149.setGeneration(1);
		p149.setHeight(2.2);
		p149.setWeight(210.0);
		p149.addToTypeList("Dragon");
		p149.addToTypeList("Flying");
		p149.setSpritePic("resources/149.png");
		addToDexList(p149);
		
		p147.addToEvoFamily(p147);
		p147.addToEvoFamily(p148);
		p147.addToEvoFamily(p149);
		p148.addToEvoFamily(p147);
		p148.addToEvoFamily(p148);
		p148.addToEvoFamily(p149);
		p149.addToEvoFamily(p147);
		p149.addToEvoFamily(p148);
		p149.addToEvoFamily(p149);
		
		//Mewtwo
		Pokemon p150 = new Pokemon("Mewtwo");
		p150.setPokeNum(150);
		p150.setGeneration(1);
		p150.setLegendary(true);
		p150.setHeight(2.0);
		p150.setWeight(122.0);
		p150.addToTypeList("Psychic");
		p150.addToTypeList(null);
		p150.setSpritePic("resources/150.png");
		p150.addToEvoFamily(p150);
		addToDexList(p150);
		
		//Mew
		Pokemon p151 = new Pokemon("Mew");
		p151.setPokeNum(151);
		p151.setGeneration(1);
		p151.setLegendary(true);
		p151.setHeight(0.4);
		p151.setWeight(4.0);
		p151.addToTypeList("Psychic");
		p151.addToTypeList(null);
		p151.setSpritePic("resources/151.png");
		p151.addToEvoFamily(p151);
		addToDexList(p151);
		
	}
}
