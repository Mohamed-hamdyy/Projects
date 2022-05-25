package engine;
import java.util.*;
import buildings.*;
import units.*;

public class City {
private String name ;	
private ArrayList<EconomicBuilding> economicalBuildings	;
private ArrayList<MilitaryBuilding> militaryBuildings;
private Army defendingArmy;
private int turnsUnderSiege;
private boolean underSiege ;

public String getName() {
	return name;
}

public ArrayList<EconomicBuilding> getEconomicalBuildings() {
	return economicalBuildings;
}
public ArrayList<MilitaryBuilding> getMilitaryBuildings() {
	return militaryBuildings;
}
public Army getDefendingArmy() {
	return defendingArmy;
}
public void setDefendingArmy(Army defendingArmy) {
	this.defendingArmy = defendingArmy;
}
public int getTurnsUnderSiege() {
	return turnsUnderSiege;
}
public void setTurnsUnderSiege(int turnsUnderSiege) {
	this.turnsUnderSiege = turnsUnderSiege;
}
public boolean isUnderSiege() {
	return underSiege;
}
public void setUnderSiege(boolean underSiege) {
	this.underSiege = underSiege;
}
public City ( String name ) {
	this.name =name ;
    economicalBuildings=new ArrayList<EconomicBuilding>();
    militaryBuildings=new  ArrayList<MilitaryBuilding>();
    defendingArmy =new Army(name);   
	underSiege=false ;
}




}
