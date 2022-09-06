//////////////////////////////////////Klasa Makine/////////////////////////////////////
import java.util.*;
import java.io.*;

public class Makine {

	private String tipiM, modeliM; //variabla fushe te tipit String per tipin dhe modelin e makines
	private double cmimiM;  //variabel fushe i tipit double per cmimin e makines
	
	public Makine() {
	
		tipiM= "";
		modeliM = "";
		cmimiM = 0;
	}
	
	public void setM(String cT, String cM, double cP){
		
		tipiM= cT;
		modeliM = cM;
		cmimiM = cP;	
	}
	
	public String gettipiM() {
		return tipiM;
	}
	
	public String getmodeliM() {
		return modeliM;
	}
	
	public String getM() {
		return gettipiM() + "-" + getmodeliM();
	}
		
	public double getcmimiM() {
		return cmimiM;
	}
	

}