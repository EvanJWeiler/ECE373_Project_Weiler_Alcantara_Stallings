package org.Pokedex.pokemon;
import java.util.*;
import java.awt.*;

public class Pokemon 
{
	private int pokeNum;
	private int generation;
	private double height;
	private double weight;
	private boolean isLegendary;
	private String name;
	private String gender;
	private ArrayList<String> moveset;
	private ArrayList<String> type;
	private ArrayList<Pokemon> evoFamily;
	private String spritePic;
	
	public Pokemon()
	{
		pokeNum = -1;
		height = -1;
		generation = -1;
		weight = -1;
		isLegendary = false;
		name = "EMPTY";
		gender = "Male/Female";
		moveset = new ArrayList<String>();
		type = new ArrayList<String>();
		evoFamily = new ArrayList<Pokemon>();
		spritePic = "resources/0.png";
	}
	
	public Pokemon(String aName)
	{
		this();
		name = aName;
	}
	
	public Pokemon(int aNum, int aHeight, int aGen, double aWeight, boolean aLegBool, String aName, String aGender)
	{
		this();
		pokeNum = aNum;
		height = aHeight;
		generation = aGen;
		weight = aWeight;
		isLegendary = aLegBool;
		name = aName;
		gender = aGender;
	}
	
	public int getPokeNum() 
	{
		return pokeNum;
	}
	
	public void setPokeNum(int pokeNum) 
	{
		this.pokeNum = pokeNum;
	}
	
	public double getHeight() 
	{
		return height;
	}
	
	public void setHeight(double height) 
	{
		this.height = height;
	}
	
	public int getGeneration() 
	{
		return generation;
	}
	
	public void setGeneration(int generation) 
	{
		this.generation = generation;
	}
	
	public double getWeight() 
	{
		return weight;
	}
	
	public void setWeight(double weight) 
	{
		this.weight = weight;
	}
	
	public boolean isLegendary() 
	{
		return isLegendary;
	}
	
	public void setLegendary(boolean isLegendary) 
	{
		this.isLegendary = isLegendary;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getGender() 
	{
		return gender;
	}
	
	public void setGender(String gender) 
	{
		this.gender = gender;
	}
	
	public ArrayList<String> getMoveset() 
	{
		return moveset;
	}
	
	public void setMoveset(ArrayList<String> moveset) 
	{
		this.moveset = moveset;
	}
	
	public ArrayList<String> getTypeList() 
	{
		return type;
	}
	
	public void addToTypeList(String aType)
	{
		this.type.add(aType);
	}
	
	public ArrayList<Pokemon> getEvoFamily() 
	{
		return evoFamily;
	}
	
	public void addToEvoFamily(Pokemon aPoke)
	{
		this.evoFamily.add(aPoke);
	}
	
	public int compareTo(Pokemon aPoke)
	{
		return 1;
	}

	public String getSpritePic() {
		return spritePic;
	}

	public void setSpritePic(String spritePic) {
		this.spritePic = spritePic;
	}
}