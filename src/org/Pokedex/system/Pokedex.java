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
		p1.setSpritePic("resources/bulbasaur.jpg");
		addToDexList(p1);
		
		//Ivysaur
		Pokemon p2 = new Pokemon("Ivysaur");
		p2.setPokeNum(2);
		p2.setGeneration(1);
		p2.setHeight(1.0);
		p2.setWeight(13.0);
		p2.addToTypeList("Grass");
		p2.addToTypeList("Poison");
		p2.setSpritePic("resources/white.jpg");//FIXME: change after adding correct sprite
		addToDexList(p2);
		
		//Venusaur
		Pokemon p3 = new Pokemon("Venusaur");
		p3.setPokeNum(3);
		p3.setGeneration(1);
		p3.setHeight(2.0);
		p3.setWeight(100.0);
		p3.addToTypeList("Grass");
		p3.addToTypeList("Poison");
		p3.setSpritePic("resources/bulbasaur.jpg"); //FIXME: change after adding correct sprite
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
		p4.setSpritePic("resources/white.jpg"); //FIXME: change after adding correct sprite
		addToDexList(p4);
		
		//Charmeleon
		Pokemon p5 = new Pokemon("Charmeleon");
		p5.setPokeNum(5);
		p5.setGeneration(1);
		p5.setHeight(1.1);
		p5.setWeight(19.0);
		p5.addToTypeList("Fire");
		p5.addToTypeList(null);
		addToDexList(p5);
		
		//Charizard
		Pokemon p6 = new Pokemon("Charizard");
		p6.setPokeNum(6);
		p6.setGeneration(1);
		p6.setHeight(1.7);
		p6.setWeight(90.5);
		p6.addToTypeList("Fire");
		p6.addToTypeList(null);
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
		addToDexList(p7);
		
		//Wartortle
		Pokemon p8 = new Pokemon("Wartortle");
		p8.setPokeNum(8);
		p8.setGeneration(1);
		p8.setHeight(1.0);
		p8.setWeight(22.5);
		p8.addToTypeList("Water");
		p8.addToTypeList(null);
		addToDexList(p8);
		
		//Blastoise
		Pokemon p9 = new Pokemon("Blastoise");
		p9.setPokeNum(9);
		p9.setGeneration(1);
		p9.setHeight(1.6);
		p9.setWeight(85.5);
		p9.addToTypeList("Water");
		p9.addToTypeList(null);
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
		addToDexList(p10);
		
		//Metapod
		Pokemon p11 = new Pokemon("Metapod");
		p11.setPokeNum(11);
		p11.setGeneration(1);
		p11.setHeight(0.7);
		p11.setWeight(9.9);
		p11.addToTypeList("Bug");
		p11.addToTypeList(null);
		addToDexList(p11);
		
		
		//Butterfree
		Pokemon p12 = new Pokemon("Butterfree");
		p12.setPokeNum(12);
		p12.setGeneration(1);
		p12.setHeight(1.1);
		p12.setWeight(32.0);
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
		p13.setHeight(0.3);
		p13.setWeight(3.2);
		p13.addToTypeList("Bug");
		p13.addToTypeList("Poison");
		addToDexList(p13);
		
		//Kakuna
		Pokemon p14 = new Pokemon("Kakuna");
		p14.setPokeNum(14);
		p14.setGeneration(1);
		p14.setHeight(0.6);
		p14.setWeight(10.0);
		p14.addToTypeList("Bug");
		p14.addToTypeList("Poison");
		addToDexList(p14);
		
		//Beedrill
		Pokemon p15 = new Pokemon("Beedrill");
		p15.setPokeNum(15);
		p15.setGeneration(1);
		p15.setHeight(1.0);
		p15.setWeight(29.5);
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
		p16.setHeight(0.3);
		p16.setWeight(1.8);
		p16.addToTypeList("Normal");
		p16.addToTypeList("Flying");
		addToDexList(p16);
		
		//Pidgeotto
		Pokemon p17 = new Pokemon("Pidgeotto");
		p17.setPokeNum(17);
		p17.setGeneration(1);
		p17.setHeight(1.1);
		p17.setWeight(30.0);
		p17.addToTypeList("Normal");
		p17.addToTypeList("Flying");
		addToDexList(p17);
		
		//Pidgeot
		Pokemon p18 = new Pokemon("Pidgeot");
		p18.setPokeNum(18);
		p18.setGeneration(1);
		p18.setHeight(1.5);
		p18.setWeight(39.5);
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
		p19.setHeight(0.3);
		p19.setWeight(3.5);
		p19.addToTypeList("Normal");
		p19.addToTypeList(null);
		addToDexList(p19);
		
		//Raticate
		Pokemon p20 = new Pokemon("Raticate");
		p20.setPokeNum(20);
		p20.setGeneration(1);
		p20.setHeight(0.7);
		p20.setWeight(18.5);
		p20.addToTypeList("Normal");
		p20.addToTypeList(null);
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
		addToDexList(p21);
		
		//Fearow
		Pokemon p22 = new Pokemon("Fearow");
		p22.setPokeNum(22);
		p22.setGeneration(1);
		p22.setHeight(1.2);
		p22.setWeight(38.0);
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
		p23.setHeight(2.0);
		p23.setWeight(6.9);
		p23.addToTypeList("Poison");
		p23.addToTypeList(null);
		addToDexList(p23);
		
		//Arbok
		Pokemon p24 = new Pokemon("Arbok");
		p24.setPokeNum(24);
		p24.setGeneration(1);
		p24.setHeight(3.5);
		p24.setWeight(65.0);
		p24.addToTypeList("Poison");
		p24.addToTypeList(null);
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
		addToDexList(p25);
		
		//Raichu
		Pokemon p26 = new Pokemon("Raichu");
		p26.setPokeNum(26);
		p26.setGeneration(1);
		p26.setHeight(0.8);
		p26.setWeight(30.0);
		p26.addToTypeList("Electric");
		p26.addToTypeList(null);
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
		addToDexList(p27);
		
		//Sandslash
		Pokemon p28 = new Pokemon("Sandslash");
		p28.setPokeNum(28);
		p28.setGeneration(1);
		p28.setHeight(1.0);
		p28.setWeight(29.5);
		p28.addToTypeList("Ground");
		p28.addToTypeList(null);
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
		addToDexList(p35);
		
		//Clefable
		Pokemon p36 = new Pokemon("Clefable");
		p36.setPokeNum(36);
		p36.setGeneration(1);
		p36.setHeight(1.3);
		p36.setWeight(40.0);
		p36.addToTypeList("Fairy");
		p36.addToTypeList(null);
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
		addToDexList(p37);
		
		//Ninetails
		Pokemon p38 = new Pokemon("Ninetails");
		p38.setPokeNum(38);
		p38.setGeneration(1);
		p38.setHeight(1.1);
		p38.setWeight(19.9);
		p38.addToTypeList("Fire");
		p38.addToTypeList(null);
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
		addToDexList(p39);
		
		//Wigglytuff
		Pokemon p40 = new Pokemon("Wigglytuff");
		p40.setPokeNum(40);
		p40.setGeneration(1);
		p40.setHeight(1.0);
		p40.setWeight(12.0);
		p40.addToTypeList("Normal");
		p40.addToTypeList("Fairy");
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
		addToDexList(p41);
		
		//Golbat
		Pokemon p42 = new Pokemon("Golbat");
		p42.setPokeNum(42);
		p42.setGeneration(1);
		p42.setHeight(1.6);
		p42.setWeight(55.0);
		p42.addToTypeList("Poison");
		p42.addToTypeList("Flying");
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
		addToDexList(p43);
		
		//Gloom
		Pokemon p44 = new Pokemon("Gloom");
		p44.setPokeNum(44);
		p44.setGeneration(1);
		p44.setHeight(0.8);
		p44.setWeight(8.6);
		p44.addToTypeList("Grass");
		p44.addToTypeList("Poison");
		addToDexList(p44);
		
		//Vileplume
		Pokemon p45 = new Pokemon("Vileplume");
		p45.setPokeNum(45);
		p45.setGeneration(1);
		p45.setHeight(1.2);
		p45.setWeight(18.6);
		p45.addToTypeList("Grass");
		p45.addToTypeList("Poison");
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
		addToDexList(p46);
		
		//Parasect
		
		Pokemon p47 = new Pokemon("Parasect");
		p47.setPokeNum(47);
		p47.setGeneration(1);
		p47.setHeight(1.0);
		p47.setWeight(29.5);
		p47.addToTypeList("Bug");
		p47.addToTypeList("Grass");
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
		addToDexList(p48);
		
		//Venomoth
		
		Pokemon p49 = new Pokemon("Venomoth");
		p49.setPokeNum(49);
		p49.setGeneration(1);
		p49.setHeight(1.5);
		p49.setWeight(12.5);
		p49.addToTypeList("Bug");
		p49.addToTypeList("Poison");
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
		addToDexList(p50);
		
		//Dugtrio
		
		Pokemon p51 = new Pokemon("Dugtrio");
		p51.setPokeNum(51);
		p51.setGeneration(1);
		p51.setHeight(0.7);
		p51.setWeight(33.3);
		p51.addToTypeList("Ground");
		p51.addToEvoFamily(null);
		addToDexList(p51);
		
		//DugEvoFam
		
		p50.addToEvoFamily(p50);
		p50.addToEvoFamily(p51);
		p51.addToEvoFamily(p50);
		p51.addToEvoFamily(p51);
		
		
		
		
		
		
		
		
		
		
		
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
		addToDexList(p151);
		
	}
}
