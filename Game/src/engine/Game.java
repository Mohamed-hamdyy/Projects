package engine;
import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import units.*;


public class Game {
	
private Player player;
private ArrayList<City> availableCities;
private ArrayList<Distance> distances;
private final int maxTurnCount=30;
private int currentTurnCount=1;

public Player getPlayer() {
	return player;
}
public void setPlayer(Player player) {
	this.player = player;
}
public ArrayList<City> getAvailableCities() {
	return availableCities;
}
public ArrayList<Distance> getDistances() {
	return distances;
}

public int getCurrentTurnCount() {
	return currentTurnCount;
}
public void setCurrentTurnCount(int currentTurnCount) {
	this.currentTurnCount = currentTurnCount;
}
public int getMaxTurnCount() {
	return maxTurnCount; 
}

public Game(String playerName,String playerCity) throws IOException {
  player = new Player(playerName );
  availableCities= new ArrayList<City>();
  distances=new ArrayList<Distance>();
  loadCitiesAndDistances();
  int i ;
  for( i=0;i<availableCities.size();i++ ) {
	  if (playerCity.equals(availableCities.get(i).getName()) )
		  break;
  }
   player.getControlledCities().add(availableCities.get(i));
   availableCities.get(i).setDefendingArmy(null);
  
  for ( int j =0;j<availableCities.size();j++) {
	  if (!playerCity.equals(availableCities.get(j).getName()))
		  loadArmy(availableCities.get(j).getName(),availableCities.get(j).getName().toLowerCase()+"_army.csv");
	  
	  
	  
  }
  
  
  
  
	
}

public static ArrayList<String > readFile(String path) throws IOException{
		String currentLine = "";
		FileReader fileReader= new FileReader(path);
		BufferedReader br = new BufferedReader(fileReader);
		ArrayList<String > r = new ArrayList<String>() ;
		while ((currentLine = br.readLine()) != null) {
		  String []s = currentLine.split(","); 
	     for ( int i =0; i< s.length;i++) {
			r.add(s[i]);
	     }
		}
		return r ;
		
			}
public void loadArmy(String cityName,String path) throws IOException{
	
	ArrayList <Unit> army= new ArrayList<Unit>();
	ArrayList<String> def=readFile(path);
	for ( int i =0;i<def.size();i+=2) {
		switch(def.get(i)) {
		case"Archer":if (def.get(i+1).equals("1")) army.add(new Archer(1,60,0.4,0.5,0.6));
		             else if (def.get(i+1).equals("2"))army.add(new Archer(2,60,0.4,0.5,0.6));  
		             else army.add(new Archer(3,70,0.5,0.6,0.7));      break;
		case"Infantry":if (def.get(i+1).equals("1")) army.add(new Infantry(1,50,0.5,0.6,0.7));
		               else if (def.get(i+1).equals("2")) army.add(new Infantry(2,50,0.5,0.6,0.7));
		               else army.add(new Infantry(3,60,0.6,0.7,0.8));  break;	
		case"Cavalry":if (def.get(i+1).equals("1")) army.add(new Cavalry(1,40,0.6,0.7,0.75));
		              else if (def.get(i+1).equals("2")) army.add(new Cavalry(2,40,0.6,0.7,0.75));
		              else army.add(new Cavalry(3,60,0.7,0.8,0.9));    break;
		
		}	
	}
	Army a = new Army (cityName);
	a.setUnits(army);
	for ( int i=0; i<availableCities.size();i++) {
		if (cityName.equals(availableCities.get(i).getName()))
			availableCities.get(i).setDefendingArmy(a);
	}
	
	
}

private void loadCitiesAndDistances() throws IOException{
		
	ArrayList<String> dis= readFile("distances.csv");	
	for( int i =0;i<dis.size();i+=3) {
		distances.add(new Distance(dis.get(i),dis.get(i+1),Integer.parseInt(dis.get(i+2)) )); 
		for (int j=i;j<=i+1;j++ ) {
			boolean exist=false; 
			String city=dis.get(j);
			for ( int k=0;k<availableCities.size();k++) {
				if(city.equals(availableCities.get(k).getName()))
					exist=true;
				
			}
			if ( !exist)
			     availableCities.add(new City(city));
		}
			
		}
		
		
	}
		
	
	
	
	
	}
	
	
	
	
		
	
	
	