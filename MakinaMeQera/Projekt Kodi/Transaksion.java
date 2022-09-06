///////////////////Klasa Transaksion///////////////
import java.util.*;
import javax.swing.JOptionPane;
import java.io.*;

public class Transaksion {

	final static int MONTHS_DAYS = 30, MONTHS = 12; //le te supozojme se 30 dite eshte nje muaj per cdo muaj 
	private Klient aKlient; //nga klasa Klient ne te njejten direktori
	private Makine aMakine; //nga klasa Makine ne te njejten direktori
	private int muaji = 0, ditet = 0;
	
	private String MuajAktual;
	private int DataAktuale, VitAktual;
	
	private String ZgjidhMuajin;
	private int ZgjidhDaten, ZgjidhVitin;
	
	private String muajKthimi;
	private int dateKthimi, vitiKthimi;
	
	private String MuajLindje;
	private int dateLindje, VitLindje, mosha = 0;
		
	public Transaksion() { //konstruktor
		aKlient = new Klient();
		aMakine = new Makine();
		MuajAktual = "";
		DataAktuale = 0;
		VitAktual = 0;
		ZgjidhMuajin = "";
		ZgjidhDaten = 0;
		ZgjidhVitin = 0;
		muajKthimi = "";
		dateKthimi = 0;
		vitiKthimi = 0;
		MuajLindje = "";
		dateLindje = 0;
		VitLindje = 0;
 	}
	
	public void setTransaksion(Klient cU, Makine cA, String m, int d, int y, String pM, int pD, int pY, String rM, int rD, int rY, String bM, int bD, int bY) { //constructor
		aKlient = cU;
		aMakine = cA;
		MuajAktual = m;
		DataAktuale = d;
		VitAktual = y;
		ZgjidhMuajin = pM;
		ZgjidhDaten = pD;
		ZgjidhVitin = pY;
		muajKthimi = rM;
		dateKthimi = rD;
		vitiKthimi = rY;
		MuajLindje = bM;
		dateLindje = bD;
		VitLindje = bY;
	}
	
	public String getMuajAktual() { 
		return MuajAktual;
	}
	
	public int getDataAktuale() { 
		return DataAktuale;
	}
	
	public int getVitAktual() { 
		return VitAktual;
	}
////////////////////////gjenerojme vleren e muajit aktual/////////////////
	public int getMuajAktualVlere() {
		if(getMuajAktual().equals("Jan"))
			muaji = 1;
		
		else if(getMuajAktual().equals("Shku"))
			muaji = 2;
		
		else if(getMuajAktual().equals("Mar"))
			muaji = 3;
		
		else if(getMuajAktual().equals("Pri"))
			muaji = 4;
		
		else if(getMuajAktual().equals("Maj"))
			muaji = 5;
		
		else if(getMuajAktual().equals("Qer"))
			muaji = 6;
		
		else if(getMuajAktual().equals("Kor"))
			muaji = 7;
		
		else if(getMuajAktual().equals("Gush"))
			muaji = 8;		
		
		else if(getMuajAktual().equals("Shta"))
			muaji = 9;
			
		else if(getMuajAktual().equals("Tet"))
			muaji = 10;
			
		else if(getMuajAktual().equals("Nen"))
			muaji = 11;
			
		else if(getMuajAktual().equals("Dhje"))
			muaji = 12;
		
		return muaji;
	}
	
	public String getZgjidhMuajin() { 
		return ZgjidhMuajin;
	}
	
	public int  getZgjidhDaten() {
		return ZgjidhDaten;
	}
	
	public int getZgjidhVitin() {
		return ZgjidhVitin;
	}
	
//////////////////////////////////////marrim vleren e muajit te marrjes se makines///////////////////////////
	public int getZgjidhMuajinVlere() {
		if(getZgjidhMuajin().equals("Jan"))
			muaji = 1;
		
		else if(getZgjidhMuajin().equals("Shku"))
			muaji = 2;
		
		else if(getZgjidhMuajin().equals("Mar"))
			muaji = 3;
		
		else if(getZgjidhMuajin().equals("Pri"))
			muaji = 4;
		
		else if(getZgjidhMuajin().equals("Maj"))
			muaji = 5;
		
		else if(getZgjidhMuajin().equals("Qer"))
			muaji = 6;
		
		else if(getZgjidhMuajin().equals("Kor"))
			muaji = 7;
		
		else if(getZgjidhMuajin().equals("Gush"))
			muaji = 8;		
		
		else if(getZgjidhMuajin().equals("Shta"))
			muaji = 9;
			
		else if(getZgjidhMuajin().equals("Tet"))
			muaji = 10;
			
		else if(getZgjidhMuajin().equals("Nen"))
			muaji = 11;
			
		else if(getZgjidhMuajin().equals("Dhje"))
			muaji = 12;
		
		return muaji;
	}
	
	public String getMuajKthimi() {
		return muajKthimi;
	}
	
	public int getDateKthimi() { 
		return dateKthimi;
	}
	
	public int getVitKthimi() { 
		return vitiKthimi;
	}
	
////////////////////////////////marrim vleren e kthimit te muajit te makines////////////////////////////
	public int getMuajKthimiVlere() {
		if(getMuajKthimi().equals("Jan"))
			muaji = 1;
		
		else if(getMuajKthimi().equals("Shku"))
			muaji = 2;
		
		else if(getMuajKthimi().equals("Mar"))
			muaji = 3;
		
		else if(getMuajKthimi().equals("Pri"))
			muaji = 4;
		
		else if(getMuajKthimi().equals("Maj"))
			muaji = 5;
		
		else if(getMuajKthimi().equals("Qer"))
			muaji = 6;
		
		else if(getMuajKthimi().equals("Kor"))
			muaji = 7;
		
		else if(getMuajKthimi().equals("Gush"))
			muaji = 8;		
		
		else if(getMuajKthimi().equals("Shta"))
			muaji = 9;
			
		else if(getMuajKthimi().equals("Tet"))
			muaji = 10;
			
		else if(getMuajKthimi().equals("Nen"))
			muaji = 11;
			
		else if(getMuajKthimi().equals("Dhje"))
			muaji = 12;
		
		return muaji;
	}
	
	public String getMuajiLindje() { 
		return MuajLindje;
	}
	
	public int getDataLindje() { 
		return dateLindje;
	}
	
	public int getVitiLindje() { 
		return VitLindje;
	}

/////////////////////////////////////marrim vleren e muajit te lindjes////////////////////////////
	public int getMuajiLindjeVlere() { 
		if(getMuajiLindje().equals("Jan"))
			muaji = 1;
		
		else if(getMuajiLindje().equals("Shku"))
			muaji = 2;
		
		else if(getMuajiLindje().equals("Mar"))
			muaji = 3;
		
		else if(getMuajiLindje().equals("Pri"))
			muaji = 4;
		
		else if(getMuajiLindje().equals("Maj"))
			muaji = 5;
		
		else if(getMuajiLindje().equals("Qer"))
			muaji = 6;
		
		else if(getMuajiLindje().equals("Kor"))
			muaji = 7;
		
		else if(getMuajiLindje().equals("Gush"))
			muaji = 8;		
		
		else if(getMuajiLindje().equals("Shta"))
			muaji = 9;
			
		else if(getMuajiLindje().equals("Tet"))
			muaji = 10;
			
		else if(getMuajiLindje().equals("Nen"))
			muaji = 11;
			
		else if(getMuajiLindje().equals("Dhje"))
			muaji = 12;
		
		return muaji;
	}

//////////////////////////////////////////////marrim moshen///////////////////////////////////
	public int getMosha(){ 
		
		int mosha = 0;
		if((getVitAktual() > getVitiLindje())&&(getMuajAktualVlere() == getMuajiLindjeVlere())) {
            if(getDataAktuale() == getDataLindje())
				mosha = getVitAktual() - getVitiLindje();
			
            else if(getDataAktuale() < getDataLindje())
				mosha = getVitAktual() - getVitiLindje();
			
            else if(getDataAktuale() > getDataLindje())
				mosha = (getVitAktual() - 1) - getVitiLindje();
        }
		
		else if((getVitAktual() > getVitiLindje())&&(getMuajAktualVlere() > getMuajiLindjeVlere()))
            mosha = getVitAktual() - getVitiLindje();
		
		else if((getVitAktual() > getVitiLindje())&&(getMuajAktualVlere() < getMuajiLindjeVlere()))
			mosha = (getVitAktual() - 1) - getVitiLindje();
			
		return mosha;
	}

///////////////////////per te marre numrin e diteve qe kjo makine do meret me qera/////////////////
	public int getDitet(){
		
		int muajTotal = 0, viteTotal = 0;
		
		if((getZgjidhVitin() == getVitKthimi()) && (getZgjidhMuajinVlere() == getMuajKthimiVlere())) {
			if(getZgjidhDaten() == getDateKthimi())
				ditet = 0;
			else if(getZgjidhDaten() < getDateKthimi())
				ditet = getDateKthimi() - getZgjidhDaten();
		}
		
		else if((getZgjidhVitin() == getVitKthimi()) && (getZgjidhMuajinVlere() < getMuajKthimiVlere())) {
			if(getZgjidhDaten() == getDateKthimi()) {
				muajTotal = getMuajKthimiVlere() - getZgjidhMuajinVlere();
				ditet = muajTotal * MONTHS_DAYS;
			}
			else if(getZgjidhDaten() < getDateKthimi()) {
				muajTotal = getMuajKthimiVlere() - getZgjidhMuajinVlere();
				ditet = (muajTotal * MONTHS_DAYS) + (getDateKthimi() - getZgjidhDaten());
			}
		}
		
		else if(getZgjidhVitin() < getVitKthimi()) {
			if(getZgjidhMuajinVlere() == getMuajKthimiVlere()) {
				viteTotal = getVitKthimi() - getZgjidhVitin();
				ditet = ((viteTotal * MONTHS) * MONTHS_DAYS) + (getDateKthimi() - getZgjidhDaten());
			}
			
			else if(getZgjidhMuajinVlere() < getMuajKthimiVlere()) {
				muajTotal = getMuajKthimiVlere() - getZgjidhMuajinVlere(); 
				ditet = ((muajTotal + MONTHS) * MONTHS_DAYS) + (getDateKthimi() - getZgjidhDaten());
			}
			
			else if(getZgjidhMuajinVlere() > getMuajKthimiVlere()) { //kani mali
				muajTotal = MONTHS - (getZgjidhMuajinVlere() - getMuajKthimiVlere());
				ditet = (muajTotal * 30) + (getDateKthimi() - getZgjidhDaten());
			}
		}
		
		return ditet;
	}
	
///////////////////////////per te marre shumen totale te qerase per gjithe ditet/////////////////////////////////
	public double getQeraCmim() {
		
		return getDitet() * aMakine.getcmimiM();
	}
	
//////////////////////////////////////kthejme ne String per te kontrolluar daten////////////////////////
	public String toStringDateKontroll() {
		String afishim = "";
		
		if((getZgjidhMuajinVlere() > getMuajKthimiVlere()) && (getZgjidhVitin() == getVitKthimi())) 
			afishim += String.format("FALSE");
		
		if((getZgjidhMuajinVlere() == getMuajKthimiVlere()) && (getZgjidhDaten() > getDateKthimi()) && (getZgjidhVitin() == getVitKthimi()))
			afishim += String.format("FALSE");
		
		if(getZgjidhVitin() > getVitKthimi())
			afishim += String.format("FALSE");
		
		else
			afishim += String.format("TRUE");

		return afishim;
	}
	
//////////////////////////////////////////kthejme ne String per te kontrolluar moshen e klientit/////////////////////
	public String toStringMoshaKontroll() {
		String afisho1 = "";
		
		if(getMosha() >= 20)
			afisho1 += String.format("TRUE");
			
		else if(getMosha() < 20)
			afisho1 += String.format("FALSE");
			
		return afisho1;
	}

//////////////////////////////(int)mosha ne (String)mosha per tu printuar ne GUI/////////////////////
	public String toStringMosha() {
		String afisho2 = "";
		afisho2 += String.format("%d", getMosha()); 
		return afisho2;
	}
	
/////////////////////////////////kontrolli i statusit dhe gjinise///////////////////////////////////
	public String toStringZnjsh_Znj_Z() {
		String afisho3 = "";
		
		if(aKlient.getgjinia().equals("M") || aKlient.getgjinia().equals("m"))
			afisho3 += String.format("Z."); //kur gjinia mashkull shfaq Z. = zoteri
		
		else if((aKlient.getStatus().equals("S") || aKlient.getStatus().equals("s")) && aKlient.getgjinia().equals("F") || aKlient.getgjinia().equals("f"))
			afisho3 += String.format("Znjsh."); //kur gjinia femer dhe statusi single (s) shfaq Znjsh. = zonjushe
	
		else if((aKlient.getStatus().equals("Ma") || aKlient.getStatus().equals("ma")) && aKlient.getgjinia().equals("F") || aKlient.getgjinia().equals("f"))
			afisho3 += String.format("Znj."); //kur gjinia femer dhe statusi E martuar (Ma) shfaq Znj. = zonje
			
		return afisho3;
	}
	
/////////////////dhenia e informacionit per konsumatorin, shfaq detaje ne console////////////////
	public String toStringReceipt() {
		String shfaqStringun = "";
		
		shfaqStringun += String.format("               	             IE 202\n");
		shfaqStringun += String.format("                              Makina me qera\n");
		shfaqStringun += String.format("                                      2022\n");
		shfaqStringun += String.format("                                 Transaksion\n");
		shfaqStringun += String.format("-----------------------------------------------------------------------------------------------------\n");
		shfaqStringun += String.format("Makina                                                      %s\n", aMakine.getM());
		shfaqStringun += String.format("Ditet                                                           %d\n", getDitet());
		shfaqStringun += String.format("Cmimi (Lek)                                                     %.2f\n", aMakine.getcmimiM());
		shfaqStringun += String.format("                                                             -----------------\n");
		shfaqStringun += String.format("Pagesa totale (Lek)                                          %.2f\n",getQeraCmim());
		shfaqStringun += String.format(toStringZnjsh_Znj_Z() +" "+ aKlient.getEmriPlote());
		 return shfaqStringun;
	}
	
/////////////////////////////////////////ruajtja e fatures ne projektJava.txt me gjithe te dhenat e gjeneruara//////////////////////////////
public void saveToFile() throws IOException {
PrintWriter dokument = new PrintWriter(new FileOutputStream(new File("C:\\Users\\admin\\Downloads\\Projekt Java 2022\\projektJava.txt\\"), false));

dokument.println("Data sot: " + getMuajAktual() + " " + getDataAktuale() + ", " + getVitAktual());
dokument.println(" ");
dokument.println("Data e marrjes: " + getZgjidhMuajin() + " " + getZgjidhDaten() + ", " + getZgjidhVitin());
dokument.println("Data e kthimit: " + getMuajKthimi() + " " + getDateKthimi() + ", " + getVitKthimi()  + " = Dite: " + getDitet());
dokument.println("Emri: " + aKlient.getEmriPlote());
dokument.println("Mosha: " + getMosha());
dokument.println("Vendodhja: " + aKlient.getvendodhja());
dokument.println("Kontakti: " + aKlient.getkontakti());
dokument.println("Makina: " + aMakine.getM());
dokument.printf("Cmimi total: %.2f", + getQeraCmim());
dokument.println(" ");
dokument.println("--------------------------------------------------");
dokument.close();
}


}