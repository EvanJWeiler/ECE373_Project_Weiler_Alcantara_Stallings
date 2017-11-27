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
		p2.setSpritePic("resources/2.png");//FIXME: change after adding correct sprite
		addToDexList(p2);
		
		//Venusaur
		Pokemon p3 = new Pokemon("Venusaur");
		p3.setPokeNum(3);
		p3.setGeneration(1);
		p3.setHeight(2.0);
		p3.setWeight(100.0);
		p3.addToTypeList("Grass");
		p3.addToTypeList("Poison");
		p3.setSpritePic("resources/3.png"); //FIXME: change after adding correct sprite
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
		p4.setSpritePic("resources/4.png"); //FIXME: change after adding correct sprite
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
		
		
		
		
		
		
		
		
		
		// FIXME OTHER POKEMON TO BE ADDED LATER
		
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
		addToDexList(p146);
		
		//Dratini-Dragonite goes here TEST2
		
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
		addToDexList(p151);
		
	}
}
