/////////////////////////////////////Klasa Klient///////////////////////////////
import java.util.*;
import java.io.*;

public class Klient {

	private String emri, mbiemri, gjinia,status, vendodhja, kontakti; //variabla fushe per ruajtjen e emrit, mbiemrit,gjinise
	//statusit, vendodhjes dhe nr.kontakti
	
	public Klient() {
	
		emri = "";
		mbiemri = "";
		gjinia = "";
		status = "";
		vendodhja = "";
		kontakti = "";
	}
	
	public void setKlient(String fN, String lN, String g, String s, String l, String c){
	
		emri = fN;
		mbiemri = lN;
		gjinia = g;
		status = s;
		vendodhja = l;
		kontakti = c;
	}
	
	public String getemri() {
		return emri;
	}
	
	public String getmbiemri() {
		return mbiemri;
	}
	
	public String getEmriPlote() {
		return getemri() + " " + getmbiemri();
	}
	
	public String getgjinia() {
		return gjinia;
	}
	
	public String getStatus() {
		return status;
	}
	
	public String getvendodhja() {
		return vendodhja;
	}
	
	public String getkontakti() {
		return kontakti;
	}

	
}