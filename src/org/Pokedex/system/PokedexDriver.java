package org.Pokedex.system;

import java.util.*;

import org.Pokedex.pokemon.Pokemon;
import org.Pokedex.system.*;

public class PokedexDriver
{
	public static void main(String[] args) {
		Pokedex myPokedex = new Pokedex();
		PokedexGUI newGUI;
		
		myPokedex.addGenerationOne();
		
		newGUI = new PokedexGUI(myPokedex);
		
	}
}
