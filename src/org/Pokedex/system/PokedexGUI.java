package org.Pokedex.system;

import javax.imageio.ImageIO;
import javax.swing.*;

import org.Pokedex.pokemon.Pokemon;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PokedexGUI extends JFrame {
	private Pokedex p1;
	private Pokemon currPokemon;
	
	
	public PokedexGUI(Pokedex pd1) {
		super("Pokemon Go Companion");
		
		p1 = pd1;
		
		setSize(500,550);
		setLocation(200,50);
		
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		launchDexScreen();
		setVisible(true);
		
		
	}
	
	public void launchDexScreen() {
		//initalizes structure
		JPanel structure = new JPanel();
		structure.setLayout(new BoxLayout(structure, BoxLayout.PAGE_AXIS));
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout());
		JPanel listPanel = new JPanel();
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.PAGE_AXIS));
		JPanel picPanel = new JPanel();
		picPanel.setLayout(new BoxLayout(picPanel, BoxLayout.PAGE_AXIS));
		JScrollPane scrollPanel = new JScrollPane(listPanel);
		
		
		//initalize info button
		JButton info = new JButton("Info");
		info.setAlignmentX(CENTER_ALIGNMENT);
		info.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currPokemon != null)
					LaunchInfoScreen(currPokemon);
				else
					JOptionPane.showMessageDialog(new JFrame(), "Please select a Pokemon", "No Pokemon Selected", JOptionPane.WARNING_MESSAGE);
			}
		});
		
		//add buttons and functionality
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LaunchSearchScreen(); //FIXME: Implement Search
			}
		});
		JButton matchupButton = new JButton("Matchup");
		matchupButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LaunchMathcupScreen();
				LaunchMatchupOutputScreen("0", null, null, null, "0.0", "0", null, null, null, "0.0"); //FIXME remove after testing
			}
		});
		
		//initialize image
		//FIX ME: load Pokemon images from currPokemon variable
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("resources/bulbasaur.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		} 
		JLabel imgLabel = new JLabel(new ImageIcon(image));
		imgLabel.setAlignmentX(CENTER_ALIGNMENT);
		
		//initialize Pokemon list
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		for (int i = 0; i < p1.getDexList().size(); ++i) {
			JButton pokeButton = new JButton(p1.getDexList().get(i).getPokeNum() + "   " + p1.getDexList().get(i).getName());
			
			pokeButton.setAlignmentX(CENTER_ALIGNMENT);
			listPanel.add(pokeButton);
			buttons.add(pokeButton);
		}
		
		setButtonActions(buttons);
		
		picPanel.add(imgLabel);
		picPanel.add(info);
		picPanel.setAlignmentX(RIGHT_ALIGNMENT);
		scrollPanel.setPreferredSize(new Dimension(200, 400));
		scrollPanel.setAlignmentX(LEFT_ALIGNMENT);
		topPanel.add(scrollPanel);
		topPanel.add(picPanel);
		bottomPanel.add(searchButton);
		bottomPanel.add(matchupButton);
		structure.add(topPanel);
		structure.add(bottomPanel);
		add(structure);
		
	}
	
	public void LaunchInfoScreen(Pokemon pn1) {
		JFrame info = new JFrame(pn1.getName());
		JPanel picAndType = new JPanel();
		picAndType.setLayout(new BoxLayout(picAndType, BoxLayout.PAGE_AXIS));
		JPanel pokeInfo = new JPanel();
		pokeInfo.setLayout(new BoxLayout(pokeInfo, BoxLayout.PAGE_AXIS));
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		JLabel evoLabel = new JLabel("Evolutions");
		evoLabel.setAlignmentX(CENTER_ALIGNMENT);
		JPanel evoPics = new JPanel();
		evoPics.setLayout(new FlowLayout());
		JButton closeButton = new JButton("Close");
		closeButton.setAlignmentX(CENTER_ALIGNMENT);
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.PAGE_AXIS));
		JPanel structure = new JPanel();
		structure.setLayout(new BoxLayout(structure, BoxLayout.PAGE_AXIS));
		
		info.setSize(500, 600);
		info.setLocation(600, 100);
		
		//initialize image
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("resources/white.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		} 
		JLabel imgLabel = new JLabel(new ImageIcon(image));
		imgLabel.setAlignmentX(CENTER_ALIGNMENT);
		
		//create string of types
		StringBuilder types = new StringBuilder();
		for (int i = 0; i < pn1.getTypeList().size(); ++i) {
			types.append(pn1.getTypeList().get(i));
			if (pn1.getTypeList().size() > 1 && i != 1)
				types.append("/");
		}
		JLabel typesLabel = new JLabel(types.toString());
		typesLabel.setAlignmentX(CENTER_ALIGNMENT);
		
		picAndType.add(imgLabel);
		picAndType.add(typesLabel);
		
		//initialize info section
		JLabel num = new JLabel("Num: " + pn1.getPokeNum());
		JLabel name = new JLabel("Name: " + pn1.getName());
		JLabel height = new JLabel("Height: " + pn1.getHeight());
		JLabel weight = new JLabel("Weight: " + pn1.getWeight());
		StringBuilder moveset = new StringBuilder();
		for (int i = 0; i < pn1.getMoveset().size(); ++i) {
			types.append(pn1.getMoveset().get(i));
			if (pn1.getMoveset().size() > 1 && i != 1)
				types.append("/");
		}
		JLabel movesetLabel = new JLabel(moveset.toString());
		JLabel gender = new JLabel("Gender: " + pn1.getGender());
		pokeInfo.add(num);
		pokeInfo.add(name);
		pokeInfo.add(height);
		pokeInfo.add(weight);
		//pokeInfo.add(movesetLabel);
		pokeInfo.add(gender);
		
		//setup EVO Section
		BufferedImage image1 = null;
		try {
			image1 = ImageIO.read(getClass().getResourceAsStream("resources/white128.png"));
		} catch (IOException e) {
			e.printStackTrace();
		} 
		JLabel imgLabel1 = new JLabel(new ImageIcon(image1));
		imgLabel1.setAlignmentX(CENTER_ALIGNMENT);
		BufferedImage image2 = null;
		try {
			image2 = ImageIO.read(getClass().getResourceAsStream("resources/white128.png"));
		} catch (IOException e) {
			e.printStackTrace();
		} 
		JLabel imgLabel2 = new JLabel(new ImageIcon(image2));
		imgLabel2.setAlignmentX(CENTER_ALIGNMENT);
		BufferedImage image3 = null;
		try {
			image3 = ImageIO.read(getClass().getResourceAsStream("resources/white128.png"));
		} catch (IOException e) {
			e.printStackTrace();
		} 
		JLabel imgLabel3 = new JLabel(new ImageIcon(image3));
		imgLabel3.setAlignmentX(CENTER_ALIGNMENT);
		evoPics.add(imgLabel1);
		evoPics.add(imgLabel2);
		evoPics.add(imgLabel3);
		
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				info.dispose();
			}
		});
		
		
		topPanel.add(picAndType);
		topPanel.add(pokeInfo);
		bottomPanel.add(evoLabel);
		bottomPanel.add(evoPics);
		bottomPanel.add(closeButton);
		structure.add(topPanel);
		structure.add(bottomPanel);
		info.add(structure);
		
		info.pack();
		info.setVisible(true);
	}
	
	public void LaunchSearchScreen() {
		JFrame frame = new JFrame("Search");
		JPanel structure = new JPanel();
		JPanel fieldsPanel = new JPanel();
		fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.PAGE_AXIS));
		JPanel searchButtonPanel = new JPanel();
		structure.setLayout(new BoxLayout(structure, BoxLayout.PAGE_AXIS));
		
		//setup labels
		JLabel num = new JLabel("Num:");
		num.setAlignmentX(LEFT_ALIGNMENT);
		JLabel name = new JLabel("Name:");
		name.setAlignmentX(LEFT_ALIGNMENT);
		JLabel type1 = new JLabel("Type1:");
		type1.setAlignmentX(LEFT_ALIGNMENT);
		JLabel type2 = new JLabel("Type2:");
		type2.setAlignmentX(LEFT_ALIGNMENT);
		JLabel generation = new JLabel("Generation:");
		generation.setAlignmentX(LEFT_ALIGNMENT);
		JLabel legendary = new JLabel("Legendary:");
		legendary.setAlignmentX(LEFT_ALIGNMENT);
		
		//setup fields
		JTextField numField = new JTextField();
		numField.setAlignmentX(LEFT_ALIGNMENT);
		JTextField nameField = new JTextField();
		nameField.setAlignmentX(LEFT_ALIGNMENT);
		JTextField type1Field = new JTextField();
		type1Field.setAlignmentX(LEFT_ALIGNMENT);
		JTextField type2Field = new JTextField();
		type2Field.setAlignmentX(LEFT_ALIGNMENT);
		JTextField generationField = new JTextField();
		generationField.setAlignmentX(LEFT_ALIGNMENT);
		
		//setup radio buttons
		boolean legendarySelect = false;
		JRadioButton yes = new JRadioButton("Yes");
		JRadioButton no = new JRadioButton("No", true);
		ButtonGroup yesOrNo = new ButtonGroup();
		if (yes.isSelected())
			legendarySelect = true;
		else
			legendarySelect = false;
		yesOrNo.add(yes);
		yesOrNo.add(no);
		
		
		//make search button
		JButton search = new JButton("Search");
		search.setAlignmentX(CENTER_ALIGNMENT);
		searchButtonPanel.add(search);
		searchButtonPanel.setAlignmentX(CENTER_ALIGNMENT);
		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		//add to fieldsPanel
		fieldsPanel.add(num);
		fieldsPanel.add(numField);
		fieldsPanel.add(name);
		fieldsPanel.add(nameField);
		fieldsPanel.add(type1);
		fieldsPanel.add(type1Field);
		fieldsPanel.add(type2);
		fieldsPanel.add(type2Field);
		fieldsPanel.add(generation);
		fieldsPanel.add(generationField);
		fieldsPanel.add(legendary);
		fieldsPanel.add(yes);
		fieldsPanel.add(no);
		
		fieldsPanel.setAlignmentX(CENTER_ALIGNMENT);
		
		structure.add(fieldsPanel);
		structure.add(searchButtonPanel);
		
		
		frame.setSize(300, 350);
		frame.setLocation(500, 100);
		frame.add(structure);
		frame.setVisible(true);
		
	}
	
	public void LaunchMathcupScreen() {
		JFrame frame = new JFrame("Input Matchup Parameters");
		JPanel structure = new JPanel();
		JPanel topPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		JPanel bottomLeft = new JPanel();
		JPanel bottomRight = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		//set Layouts
		topPanel.setLayout(new FlowLayout());
		bottomPanel.setLayout(new FlowLayout());
		bottomLeft.setLayout(new GridLayout(5, 2));
		bottomRight.setLayout(new GridLayout(5, 2));
		buttonPanel.setLayout(new FlowLayout());
		structure.setLayout(new BoxLayout(structure, BoxLayout.PAGE_AXIS));
		
		//initialize components of topPanel
		JLabel vs = new JLabel("VS");
		BufferedImage image1 = null;
		try {
			image1 = ImageIO.read(getClass().getResourceAsStream("resources/white128.png"));
		} catch (IOException e) {
			e.printStackTrace();
		} 
		JLabel imgLabel1 = new JLabel(new ImageIcon(image1));
		imgLabel1.setAlignmentX(CENTER_ALIGNMENT);
		BufferedImage image2 = null;
		try {
			image2 = ImageIO.read(getClass().getResourceAsStream("resources/white128.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel imgLabel2 = new JLabel(new ImageIcon(image2));
		imgLabel2.setAlignmentX(CENTER_ALIGNMENT);
		
		//initialize bottomLeft Labels
		JLabel numL = new JLabel("Num:");
		numL.setAlignmentX(LEFT_ALIGNMENT);
		JLabel nameL = new JLabel("Name:");
		nameL.setAlignmentX(LEFT_ALIGNMENT);
		JLabel type1L = new JLabel("Type1:");
		type1L.setAlignmentX(LEFT_ALIGNMENT);
		JLabel type2L = new JLabel("Type2:");
		type2L.setAlignmentX(LEFT_ALIGNMENT);
		JLabel cpL = new JLabel("CP:");
		cpL.setAlignmentX(LEFT_ALIGNMENT);
		
		//initialize bottomLeft Fields
		JTextField numFieldL = new JTextField();
		numFieldL.setAlignmentX(LEFT_ALIGNMENT);
		numFieldL.setMinimumSize(new Dimension(100, 5));
		JTextField nameFieldL = new JTextField();
		nameFieldL.setAlignmentX(LEFT_ALIGNMENT);
		JTextField type1FieldL = new JTextField();
		type1FieldL.setAlignmentX(LEFT_ALIGNMENT);
		JTextField type2FieldL = new JTextField();
		type2FieldL.setAlignmentX(LEFT_ALIGNMENT);
		JTextField cpFieldL = new JTextField();
		cpFieldL.setAlignmentX(LEFT_ALIGNMENT);
		
		//initialize bottomRight Labels
		JLabel numR = new JLabel("Num:");
		numR.setAlignmentX(LEFT_ALIGNMENT);
		JLabel nameR = new JLabel("Name:");
		nameR.setAlignmentX(LEFT_ALIGNMENT);
		JLabel type1R = new JLabel("Type1:");
		type1R.setAlignmentX(LEFT_ALIGNMENT);
		JLabel type2R = new JLabel("Type2:");
		type2R.setAlignmentX(LEFT_ALIGNMENT);
		JLabel cpR = new JLabel("CP:");
		cpR.setAlignmentX(LEFT_ALIGNMENT);
		
		//initialize bottomRight Fields
		JTextField numFieldR = new JTextField();
		numFieldR.setAlignmentX(LEFT_ALIGNMENT);
		JTextField nameFieldR = new JTextField();
		nameFieldR.setAlignmentX(LEFT_ALIGNMENT);
		JTextField type1FieldR = new JTextField();
		type1FieldR.setAlignmentX(LEFT_ALIGNMENT);
		JTextField type2FieldR = new JTextField();
		type2FieldR.setAlignmentX(LEFT_ALIGNMENT);
		JTextField cpFieldR = new JTextField();
		cpFieldR.setAlignmentX(LEFT_ALIGNMENT);
		
		//setup Buttons
		JButton okButton = new JButton("OK");
		JButton cancelButton = new JButton("Cancel");
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (numFieldL.getText().isEmpty() || nameFieldL.getText().isEmpty() || type1FieldL.getText().isEmpty() || cpFieldL.getText().isEmpty() || numFieldR.getText().isEmpty() || nameFieldR.getText().isEmpty() || type1FieldR.getText().isEmpty() || cpFieldR.getText().isEmpty()) {
					JOptionPane.showMessageDialog(new JFrame(), "Please fill out required fields", "Information Missing", JOptionPane.WARNING_MESSAGE);
				}
				else {
					if (type2FieldL.getText().isEmpty() && type2FieldR.getText().isEmpty())
						LaunchMatchupOutputScreen(numFieldL.getText(), nameFieldL.getText(), type1FieldL.getText(), "N/A", cpFieldL.getText(), numFieldR.getText(), nameFieldR.getText(), type1FieldR.getText(), "N/A", cpFieldR.getText());
					else if (type2FieldL.getText().isEmpty())
						LaunchMatchupOutputScreen(numFieldL.getText(), nameFieldL.getText(), type1FieldL.getText(), "N/A", cpFieldL.getText(), numFieldR.getText(), nameFieldR.getText(), type1FieldR.getText(), type2FieldR.getText(), cpFieldR.getText());
					else if (type2FieldR.getText().isEmpty())
						LaunchMatchupOutputScreen(numFieldL.getText(), nameFieldL.getText(), type1FieldL.getText(), type2FieldL.getText(), cpFieldL.getText(), numFieldR.getText(), nameFieldR.getText(), type1FieldR.getText(), "N/A", cpFieldR.getText());
					else
						LaunchMatchupOutputScreen(numFieldL.getText(), nameFieldL.getText(), type1FieldL.getText(), type2FieldL.getText(), cpFieldL.getText(), numFieldR.getText(), nameFieldR.getText(), type1FieldR.getText(), type2FieldR.getText(), cpFieldR.getText());
				}
			}
		});
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		//add to topPanel
		topPanel.add(imgLabel1);
		topPanel.add(vs);
		topPanel.add(imgLabel2);
		
		//add to bottomLeft
		bottomLeft.add(numL);
		bottomLeft.add(numFieldL);
		bottomLeft.add(nameL);
		bottomLeft.add(nameFieldL);
		bottomLeft.add(type1L);
		bottomLeft.add(type1FieldL);
		bottomLeft.add(type2L);
		bottomLeft.add(type2FieldL);
		bottomLeft.add(cpL);
		bottomLeft.add(cpFieldL);
		
		//add to bottomRight
		bottomRight.add(numR);
		bottomRight.add(numFieldR);
		bottomRight.add(nameR);
		bottomRight.add(nameFieldR);
		bottomRight.add(type1R);
		bottomRight.add(type1FieldR);
		bottomRight.add(type2R);
		bottomRight.add(type2FieldR);
		bottomRight.add(cpR);
		bottomRight.add(cpFieldR);
		
		//add to buttonPanel
		buttonPanel.add(okButton);
		buttonPanel.add(cancelButton);
		
		//add to bottomPanel
		bottomLeft.setAlignmentX(LEFT_ALIGNMENT);
		bottomRight.setAlignmentX(RIGHT_ALIGNMENT);
		bottomPanel.add(bottomLeft);
		bottomPanel.add(bottomRight);
		
		//add to structure
		structure.add(topPanel);
		structure.add(bottomPanel);
		structure.add(buttonPanel);
		
		frame.add(structure);
		frame.setSize(600, 600);
		frame.setLocation(800, 200);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public void LaunchMatchupOutputScreen(String num1, String name1, String type11, String type12, String cp1, String num2, String name2, String type21, String type22, String cp2) {
		JFrame frame = new JFrame("Matchup Output");
		JPanel structure = new JPanel();
		JPanel topPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		JPanel bottomLeft = new JPanel();
		JPanel bottomRight = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		//calculate IVs
		//FIXME add declaration for IV calc function
		double iv1 = 0.0; //FIXME: change to result of IV calculation
		double iv2 = 0.0; //FIXME: change to result of IV calculation
		
		//set Layouts
		topPanel.setLayout(new FlowLayout());
		bottomPanel.setLayout(new FlowLayout());
		bottomLeft.setLayout(new BoxLayout(bottomLeft, BoxLayout.PAGE_AXIS));
		bottomRight.setLayout(new BoxLayout(bottomRight, BoxLayout.PAGE_AXIS));
		buttonPanel.setLayout(new FlowLayout());
		structure.setLayout(new BoxLayout(structure, BoxLayout.PAGE_AXIS));
		
		//initialize components of topPanel
		JLabel vs = new JLabel("VS");
		//FIXME: add getPokemonSpritePics
		BufferedImage image1 = null;
		try {
			image1 = ImageIO.read(getClass().getResourceAsStream("resources/white128.png"));
		} catch (IOException e) {
			e.printStackTrace();
		} 
		JLabel imgLabel1 = new JLabel(new ImageIcon(image1));
		imgLabel1.setAlignmentX(CENTER_ALIGNMENT);
		BufferedImage image2 = null;
		try {
			image2 = ImageIO.read(getClass().getResourceAsStream("resources/white128.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel imgLabel2 = new JLabel(new ImageIcon(image2));
		imgLabel2.setAlignmentX(CENTER_ALIGNMENT);
		
		//FIXME: add recommendation level bar
		
		//initialize bottomLeft Labels
		JLabel numL = new JLabel("Num: " + num1);
		numL.setAlignmentX(LEFT_ALIGNMENT);
		JLabel nameL = new JLabel("Name: " + name1);
		nameL.setAlignmentX(LEFT_ALIGNMENT);
		JLabel type1L = new JLabel("Type1: " + type11);
		type1L.setAlignmentX(LEFT_ALIGNMENT);
		JLabel type2L = new JLabel("Type2: " + type12);
		type2L.setAlignmentX(LEFT_ALIGNMENT);
		JLabel cpL = new JLabel("CP: " + cp1);
		cpL.setAlignmentX(LEFT_ALIGNMENT);
		JLabel ivL = new JLabel("IV: " + iv1);
		ivL.setAlignmentX(LEFT_ALIGNMENT);
		
		//initialize bottomRight Labels
		JLabel numR = new JLabel("Num: " + num2);
		numR.setAlignmentX(LEFT_ALIGNMENT);
		JLabel nameR = new JLabel("Name: " + name2);
		nameR.setAlignmentX(LEFT_ALIGNMENT);
		JLabel type1R = new JLabel("Type1: " + type21);
		type1R.setAlignmentX(LEFT_ALIGNMENT);
		JLabel type2R = new JLabel("Type2: " + type22);
		type2R.setAlignmentX(LEFT_ALIGNMENT);
		JLabel cpR = new JLabel("CP: " + cp2);
		cpR.setAlignmentX(LEFT_ALIGNMENT);
		JLabel ivR = new JLabel("IV: " + iv2);
		ivR.setAlignmentX(LEFT_ALIGNMENT);
		
		//setup Buttons
		JButton closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		//add to topPanel
		topPanel.add(imgLabel1);
		topPanel.add(vs);
		topPanel.add(imgLabel2);
		
		//add to bottomLeft
		bottomLeft.add(numL);
		bottomLeft.add(nameL);
		bottomLeft.add(type1L);
		bottomLeft.add(type2L);
		bottomLeft.add(cpL);
		bottomLeft.add(ivL);
		
		//add to bottomRight
		bottomRight.add(numR);
		bottomRight.add(nameR);
		bottomRight.add(type1R);
		bottomRight.add(type2R);
		bottomRight.add(cpR);
		bottomRight.add(ivR);
		
		//add to buttonPanel
		buttonPanel.add(closeButton);
		
		//add to bottomPanel
		bottomLeft.setAlignmentX(LEFT_ALIGNMENT);
		bottomRight.setAlignmentX(RIGHT_ALIGNMENT);
		bottomPanel.add(bottomLeft);
		bottomPanel.add(bottomRight);
		
		//add to structure
		structure.add(topPanel);
		structure.add(bottomPanel);
		structure.add(buttonPanel);
		
		frame.add(structure);
		frame.setSize(600, 600);
		frame.setLocation(500, 150);
		frame.pack();
		frame.setVisible(true);
	}
	
	/*public ArrayList<Pokemon> searchPokemon(int aNum, String aName, String aType1, String aType2, int aGen, boolean aIsLegendary) {
		ArrayList<Pokemon> searchResult = new ArrayList<Pokemon>();
		//FIXME: Implement Search
		return searchResult;
	}*/
	
	public void setButtonActions(ArrayList<JButton> buttons) { //FIXME: add all actionlisteners
		buttons.get(0).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(0);
				
			}
		});
		buttons.get(1).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(1);
				
			}
		});
		buttons.get(2).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(2);
				
			}
		});
		buttons.get(3).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(3);
				
			}
		});
		buttons.get(4).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(4);
				
			}
		});
		buttons.get(5).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(5);
				
			}
		});
		buttons.get(6).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(6);
				
			}
		});
		buttons.get(7).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(7);
				
			}
		});
		buttons.get(8).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(8);
				
			}
		});
		buttons.get(9).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(9);
				
			}
		});
		buttons.get(10).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(10);
				
			}
		});
		buttons.get(11).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(11);
				
			}
		});
		buttons.get(12).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(12);
				
			}
		});
		buttons.get(13).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(13);
				
			}
		});
		buttons.get(14).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(14);
				
			}
		});
		buttons.get(15).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(15);
				
			}
		});
		buttons.get(16).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(16);
				
			}
		});
		buttons.get(17).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(17);
				
			}
		});
		buttons.get(18).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(18);
				
			}
		});
		buttons.get(19).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(19);
				
			}
		});
		buttons.get(20).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(20);
				
			}
		});
		buttons.get(21).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(21);
				
			}
		});
		buttons.get(22).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(22);
				
			}
		});
		buttons.get(23).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(23);
				
			}
		});
		buttons.get(24).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(24);
				
			}
		});
		buttons.get(25).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(25);
				
			}
		});
		buttons.get(26).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(26);
				
			}
		});
		buttons.get(27).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(27);
				
			}
		});
		buttons.get(28).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(28);
				
			}
		});
		buttons.get(29).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(29);
				
			}
		});
		buttons.get(30).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(30);
				
			}
		});
		buttons.get(31).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(31);
				
			}
		});
		buttons.get(32).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(32);
				
			}
		});
		buttons.get(33).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(33);
				
			}
		});
		buttons.get(34).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(34);
				
			}
		});
		buttons.get(35).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(35);
				
			}
		});
		buttons.get(36).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(36);
				
			}
		});
		buttons.get(37).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(37);
				
			}
		});
		buttons.get(38).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(38);
				
			}
		});
		buttons.get(39).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(39);
				
			}
		});
		buttons.get(40).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(40);
				
			}
		});
		buttons.get(41).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(41);
				
			}
		});
		buttons.get(42).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(42);
				
			}
		});
		buttons.get(43).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(43);
				
			}
		});
		buttons.get(44).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(44);
				
			}
		});
		buttons.get(45).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(45);
				
			}
		});
		buttons.get(46).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(46);
				
			}
		});
		buttons.get(47).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(47);
				
			}
		});
		buttons.get(48).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(48);
				
			}
		});
		buttons.get(49).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(49);
				
			}
		});
		buttons.get(50).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(50);
				
			}
		});
		buttons.get(51).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currPokemon = p1.getDexList().get(51);
				
			}
		});
	}
}





















