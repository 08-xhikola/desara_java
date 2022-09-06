////////////////Klasa QeraShiko/////////////////////

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class QeraShiko extends JFrame{
	
	private Transaksion aTrans = new Transaksion(); //akseson klasen Transaksion si deklarim global
	private Klient aKlient = new Klient(); //akseson klasen Klient si deklarim global
	private Makine aMakine = new Makine(); //akseson klasen Makine si deklarim global
	KujdesRezervo hapKujdesRezervo; //klase per te aksesuar dritaren Kujdes!
	KujdesKlient hapKujdesKlient;
	KujdesMakine hapKujdesMakine;
	
	Container pane = getContentPane();
	private JPanel mainP, rezervoP, klientP,  makineP, finalP; //panelet per CardLayout

//////////////////////////////////////////////miresevini////////////////////////////////////////////////////
	private JLabel titullL, dataL; //brenda panelit te mainP
	private JButton mainParaB;
	private JComboBox cMCB, cDCB, cYCB;
	
//////////////////////////////////////////////rezervimi i dates////////////////////////////////////////////
	private JLabel diteL, marrjaDateL, dateKthimiL, dateLindjeL; //brenda panelit te rezervoP
	private JComboBox pUMCB, pUDCB, pUYCB, rMCB, rDCB, rYCB,
					bMCB, bDCB, bYCB;
	private JLabel dataKontroll, moshaKontroll;
	private JButton rezervoParaB, rezervoPasB;    
	
///////////////////////////////////////////informacionet per klientin/////////////////////////////////////
	private JLabel klientL, emriL, mbiemriL, vendodhjaL, kontaktiL, gjiniaL, moshaL,statusL, shfaqMoshaL; //brenda panelit te klientP
	private JTextField emriTF, mbiemriTF, vendodhjaTF, kontaktiTF, statusTF,gjiniaTF;
	private JLabel emriKontroll, mbiemriKontroll, gjiniaKontroll, statusKontroll, vendodhjaKontroll, kontaktiKontroll;
	private JButton klientParaB, klientPasB;

///////////////////////////zgjidh nje nga 10 makina/////////////////////////////////
	private JLabel makineL; //brenda panelit te makineP
	private JButton ePareMakineB, eDyteMakineB, eTreteMakineB, eKatertMakineB, ePesteMakineB, eGjashteMakineB, eShtateMakineB, eTeteMakineB, eNenteMakineB, eDhjeteMakineB, makineParaB, makinePasB;
	private JTextArea makineDetajeTA;

////////////////////////////////////////fatura e printuar ne NotePad////////////////////////////////////
	private JTextArea fatureA;

	public QeraShiko() {
	////////////////////////////////////////////////////////Paneli i pare Miresevini! (mainP)///////////////////////////////////
	//-------------------------------------------------vendosja e paneleve dhe etiketave per seksionin Miresevini
		pane.setLayout(new CardLayout());
		mainP = new JPanel(null);
		mainP.setBackground(new Color(240, 255,255));
		
		ImageIcon titullImazh = new ImageIcon("C:\\Users\\admin\\Downloads\\Projekt Java 2022\\imazhet\\carAnimation.gif\\");
		titullL = new JLabel(titullImazh);
		titullL.setBounds(90, 60,500, 300);
		mainP.add(titullL);
		
		dataL = new JLabel("DATA SOT"); //afishon butonat per perzgjedhjen e dates sot
		dataL.setFont(new Font("Serif", Font.BOLD, 30));
		dataL.setForeground(new Color (0, 74, 45));
		dataL.setBounds(210, 400, 400, 25);
		mainP.add(dataL);
	
	//--------------------------------------kutite kombinuese per daten aktuale
		String[] muajiAktualCB = {"Jan", "Shku", "Mar", "Pri", "Maj", "Qer", "Kor", "Gush", "Shta", "Tet", "Nen", "Dhje"};
		cMCB = new JComboBox(muajiAktualCB);
		cMCB.setBounds(210, 460, 60, 25);
		mainP.add(cMCB);
		
		Integer[] dataAktualeCB = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
		cDCB = new JComboBox(dataAktualeCB);
		cDCB.setBounds(280, 460, 60, 25);
		mainP.add(cDCB);
		
		Integer[] vitiAktualCB  = {2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022};
		cYCB = new JComboBox(vitiAktualCB);
		cYCB.setBounds(350, 460, 60, 25);
		mainP.add(cYCB);
	
	//------------------------------------butonat per te shkuar ne seksionin e rezervimit
		ImageIcon mainParaImazh = new ImageIcon("C:\\Users\\admin\\Downloads\\Projekt Java 2022\\imazhet\\customer.png\\");
		mainParaB = new JButton(mainParaImazh);
		mainParaB.setBackground(new Color(173, 255, 47));
		mainParaB.addActionListener(new mainParaButton());
		mainParaB.setBounds(400, 600, 150, 100);
		mainParaB.setRolloverEnabled(true);
		mainParaB.setRolloverIcon(mainParaImazh);
		mainParaB.setPressedIcon(mainParaImazh);
		mainParaB.setActionCommand("ParaTekRezervo");
		mainP.add(mainParaB);
		pane.add(mainP, "mireseviniForm");
		
	/////////////////////////////////////////////////paneli per rezervimin (rezervoP)//////////////////////////////////////////////
	//-----------------------------------------etiketat per kohezgjatjen e rezervimit
		rezervoP = new JPanel(null);
		rezervoP.setBackground(new Color(255, 248, 220));
		
		diteL = new JLabel("Rezervoni kohezgjatjen:");
		diteL.setFont(new Font("Verdana", Font.BOLD, 35));
		diteL.setForeground(new Color(139, 0, 0));
		diteL.setBounds(100, 170, 500, 100);
		rezervoP.add(diteL);
		
		marrjaDateL = new JLabel("Data e fillimit:");
		marrjaDateL.setFont(new Font("Serif", Font.BOLD, 18));
		marrjaDateL.setForeground(new Color(139, 0, 0));
		marrjaDateL.setBounds(110, 240, 130, 100);
		rezervoP.add(marrjaDateL);
		
		dateKthimiL = new JLabel("Data e kthimit:");
		dateKthimiL.setFont(new Font("Serif", Font.BOLD, 18));
		dateKthimiL.setForeground(new Color(139, 0, 0));
		dateKthimiL.setBounds(110, 280, 130, 100);
		rezervoP.add(dateKthimiL);
		
		dateLindjeL = new JLabel("Ditelindja:");
		dateLindjeL.setFont(new Font("Serif", Font.BOLD, 18));
		dateLindjeL.setForeground(new Color(139, 0, 0));
		dateLindjeL.setBounds(110, 320, 100, 100);
		rezervoP.add(dateLindjeL);
	
	//-------------------------------------------------kuti kontrolli per daten e marrjes, daten e kthimit, daten e lindjes
	//---------------------------------------------seksioni i perzgjedhjes se dates
		String[] muajiMarrjesCB = {"Jan", "Shku", "Mar", "Pri", "May", "Qer", "Kor", "Gush", "Shta", "Tet", "Nen", "Dhje"};
		pUMCB = new JComboBox(muajiMarrjesCB);
		pUMCB.setBounds(250, 280, 60, 25);
		rezervoP.add(pUMCB);
		
		Integer[] dataMarrjesCB = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
		pUDCB = new JComboBox(dataMarrjesCB);
		pUDCB.setBounds(315, 280, 60, 25);
		rezervoP.add(pUDCB);
		
		Integer[] vitiMarrjesCB = {2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022};
		pUYCB = new JComboBox(vitiMarrjesCB);
		pUYCB.setBounds(380, 280, 60, 25);
		rezervoP.add(pUYCB);
		
	//-------------------------------------------seksioni per daten e kthimit
		String[] muajKthimiCB = {"Jan", "Shku", "Mar", "Pri", "Maj", "Qer", "Kor", "Gush", "Shta", "Tet", "Nen", "Dhje"};
		rMCB = new JComboBox(muajKthimiCB);
		rMCB.setBounds(250, 320, 60, 25);
		rezervoP.add(rMCB);
		
		Integer[] dateKthimiCB = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
		rDCB = new JComboBox(dateKthimiCB);
		rDCB.setBounds(315, 320, 60, 25);
		rezervoP.add(rDCB);
		
		Integer[] kthimVitCB = {2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022};
		rYCB = new JComboBox(kthimVitCB);
		rYCB.setBounds(380, 320, 60, 25);
		rezervoP.add(rYCB);
		
	//---------------------------------------------seksioni per daten e lindjes
		String[] MuajLindjeCB = {"Jan", "Shku", "Mar", "Pri", "Maj", "Qer", "Kor", "Gush", "Shta", "Tet", "Nen", "Dhje"};
		bMCB = new JComboBox(MuajLindjeCB);
		bMCB.setBounds(250, 360, 60, 25);
		rezervoP.add(bMCB);
		
		Integer[] dateLindjeCB = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
		bDCB = new JComboBox(dateLindjeCB);
		bDCB.setBounds(315, 360, 60, 25);
		rezervoP.add(bDCB);
		
		Integer[] VitLindjeCB = {1970, 1971, 1972, 1973, 1974, 1975, 1976, 1977, 1978, 1979, 1980,
								1981, 1982, 1983, 1984, 1985, 1986, 1987, 1988, 1989, 1990,
								1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000,
								2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010,
								2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022};
		bYCB = new JComboBox(VitLindjeCB);
		bYCB.setBounds(380, 360, 60, 25);
		rezervoP.add(bYCB);
		
	//---------------------------------------------kontrollo daten
		dataKontroll = new JLabel("");
		dataKontroll.setFont(new Font("Serif", Font.BOLD, 15));
		dataKontroll.setBounds(350, 83, 100, 100);
		rezervoP.add(dataKontroll);
		
		moshaKontroll = new JLabel("");
		moshaKontroll.setFont(new Font("Serif", Font.BOLD, 15));
		moshaKontroll.setBounds(350, 153, 100, 100);
		rezervoP.add(moshaKontroll);
		
	//--------------------------------------butonat
	//-----------------------------------------------per te shkuar tek seksioni klient
		ImageIcon dataParaImazh  = new ImageIcon("C:\\Users\\admin\\Downloads\\Projekt Java 2022\\imazhet\\customer.png\\");
		rezervoParaB = new JButton(dataParaImazh );
		rezervoParaB.setBackground(new Color(173, 255, 47));
		rezervoParaB.addActionListener(new rezervoParaButton());
		rezervoParaB.setBounds(460, 600, 100, 50);
		rezervoParaB.setActionCommand("ParaTekKlient");
		rezervoP.add(rezervoParaB);
	
	//---------------------------------------------------per te shkuar pas tek seksioni fillestar
		ImageIcon dataPasImazh = new ImageIcon("C:\\Users\\admin\\Downloads\\Projekt Java 2022\\imazhet\\customer_back.GIF\\");
		rezervoPasB = new JButton(dataPasImazh);
		rezervoPasB.setBackground(new Color(250,128,114));
		rezervoPasB.setBounds(330, 600, 100, 50);
		rezervoPasB.addActionListener(new rezervoPasButton());
		rezervoPasB.setActionCommand("PasTekMiresevini");
		rezervoP.add(rezervoPasB);
		pane.add(rezervoP, "rezervoForm");


	//////////////////////////////////////////////////////////paneli i trete klient (klientP)/////////////////////////////////////
	//---------------------------------------------etiketat per te dhenat mbi klientin
		klientP = new JPanel(null);
		klientP.setBackground(new Color (224, 255, 255));
		
		klientL = new JLabel("Te dhenat e klientit: ");
		klientL.setFont(new Font("Verdana", Font.BOLD, 20));
		klientL.setForeground(new Color(59, 24, 13));
		klientL.setBounds(50, 130, 250, 30);
		klientP.add(klientL); 
		
		emriL = new JLabel("Emri:");
		emriL.setFont(new Font("Serif", Font.BOLD, 15));
		emriL.setForeground(Color.black);
		emriL.setBounds(50, 180, 250, 30);
		klientP.add(emriL);
		
		mbiemriL = new JLabel("Mbiemri:");
		mbiemriL.setFont(new Font("Serif", Font.BOLD, 15));
		mbiemriL.setForeground(Color.black);
		mbiemriL.setBounds(50, 215, 250, 30);
		klientP.add(mbiemriL);
		
		gjiniaL = new JLabel("Gjinia:");
		gjiniaL.setFont(new Font("Serif", Font.BOLD, 15));
		gjiniaL.setForeground(Color.black);
		gjiniaL.setBounds(50, 250, 250, 30);
		klientP.add(gjiniaL);
		
		statusL = new JLabel("Statusi:");
		statusL.setFont(new Font("Serif", Font.BOLD, 15));
		statusL.setForeground(Color.black);
		statusL.setBounds(50, 285, 250, 30);
		klientP.add(statusL); 
		
		vendodhjaL = new JLabel("Adresa:");
		vendodhjaL.setFont(new Font("Serif", Font.BOLD, 15));
		vendodhjaL.setForeground(Color.black);
		vendodhjaL.setBounds(50, 320, 250, 30);
		klientP.add(vendodhjaL);
		
		kontaktiL = new JLabel("Nr. kontakti:");
		kontaktiL.setFont(new Font("Serif", Font.BOLD, 15));
		kontaktiL.setForeground(Color.black);
		kontaktiL.setBounds(50, 355, 250, 30);
		klientP.add(kontaktiL);
		 
		moshaL = new JLabel("Mosha:");
		moshaL.setFont(new Font("Serif", Font.BOLD, 15));
		moshaL.setForeground(Color.black);
		moshaL.setBounds(50, 385, 250, 30);
		klientP.add(moshaL);
		
		shfaqMoshaL = new JLabel("");
		shfaqMoshaL.setFont(new Font("Serif", Font.BOLD, 20));
		shfaqMoshaL.setHorizontalAlignment(JTextField.CENTER);
		shfaqMoshaL.setForeground(Color.black);
		shfaqMoshaL.setBounds(70, 385, 250, 30);
		klientP.add(shfaqMoshaL);
		
	//--------------------------------fusha me tekst per detajet e klientit dhe per te marre te dhena nga tastiera
		emriTF = new JTextField("Shkruani emrin tuaj"); // kuti per te vendosur emrin 
		emriTF.setHorizontalAlignment(JTextField.CENTER);
		emriTF.setForeground(Color.GRAY);
		emriTF.setBounds(150, 180, 250, 30);
		klientP.add(emriTF);
	
		mbiemriTF = new JTextField("Shkruani mbiemrin tuaj"); // kuti per te vendosur mbiemrin
		mbiemriTF.setHorizontalAlignment(JTextField.CENTER);
		mbiemriTF.setForeground(Color.GRAY);
		mbiemriTF.setBounds(150, 215, 250, 30);
		klientP.add(mbiemriTF);
	
		gjiniaTF = new JTextField("M/F"); //kuti per te vendosur gjinine (M-mashkull, F-femer)
		gjiniaTF.setHorizontalAlignment(JTextField.CENTER); 
		gjiniaTF.setForeground(Color.GRAY);
		gjiniaTF.setBounds(150, 250, 50, 30);
		klientP.add(gjiniaTF);
		
		statusTF = new JTextField("S/Ma"); //kuti per te vendosur statusin(S-single, Ma-Martuar)
		statusTF.setHorizontalAlignment(JTextField.CENTER);
		statusTF.setForeground(Color.GRAY);
		statusTF.setBounds(150, 285, 50, 30);
		klientP.add(statusTF);
		
		vendodhjaTF = new JTextField("Shkruani adresen e plote"); //kuti per te vendosur adresen tuaaj te plote
		vendodhjaTF.setHorizontalAlignment(JTextField.CENTER);
		vendodhjaTF.setForeground(Color.GRAY);
		vendodhjaTF.setBounds(150, 320, 250, 30);
		klientP.add(vendodhjaTF);

		kontaktiTF = new JTextField("Shkruani numrin e kontaktit"); //kuti per te vendosur numrin e kontaktit
		kontaktiTF.setHorizontalAlignment(JTextField.CENTER);
		kontaktiTF.setForeground(Color.GRAY);
		kontaktiTF.setBounds(150, 355, 250, 30);
		klientP.add(kontaktiTF);
		
	//-----------------kontrollo klientin
	
		emriKontroll = new JLabel("");
		emriKontroll.setFont(new Font("Serif", Font.BOLD, 15));
		emriKontroll.setBounds(410, 45, 100, 100);
		klientP.add(emriKontroll);
			
		mbiemriKontroll = new JLabel("");
		mbiemriKontroll.setFont(new Font("Serif", Font.BOLD, 15));
		mbiemriKontroll.setBounds(410, 80, 100, 100);
		klientP.add(mbiemriKontroll);
		
		gjiniaKontroll = new JLabel("");
		gjiniaKontroll.setFont(new Font("Serif", Font.BOLD, 15));
		gjiniaKontroll.setBounds(210, 115, 100, 100);
		klientP.add(gjiniaKontroll);
	
		statusKontroll = new JLabel("");
		statusKontroll.setFont(new Font("Serif", Font.BOLD, 15));
		statusKontroll.setBounds(210, 140, 100, 100);
		klientP.add(statusKontroll);
		
		vendodhjaKontroll = new JLabel("");
		vendodhjaKontroll.setFont(new Font("Serif", Font.BOLD, 15));
		vendodhjaKontroll.setBounds(410, 185, 100, 100);
		klientP.add(vendodhjaKontroll);
		
		kontaktiKontroll = new JLabel("");
		kontaktiKontroll.setFont(new Font("Serif", Font.BOLD, 15));
		kontaktiKontroll.setBounds(410, 220, 100, 100);
		klientP.add(kontaktiKontroll);

	//-------------------------------------------butonat per klientin
	//----------------------------------------------per te shkuar ne seksionin e perzgjedhjes se nje makine
		ImageIcon klientParaImazh = new ImageIcon("C:\\Users\\admin\\Downloads\\Projekt Java 2022\\imazhet\\car.GIF\\");
		klientParaB = new JButton(klientParaImazh);
		klientParaB.setBackground(new Color(173, 255, 47));
		klientParaB.setBounds(460, 500, 100, 50);
		klientParaB.setRolloverEnabled(true);
		klientParaB.setRolloverIcon(klientParaImazh);
		klientParaB.setPressedIcon(klientParaImazh);
		klientParaB.addActionListener(new klientParaButton());
		klientParaB.setActionCommand("ParaTekZgjidhMakine");
		klientP.add(klientParaB);
	
	//--------------------------------------------per te shkuar pas tek seksioni i rezervimit
		ImageIcon klientPasImazh = new ImageIcon("C:\\Users\\admin\\Downloads\\Projekt Java 2022\\imazhet\\car_back.png\\");
		klientPasB = new JButton(klientPasImazh);
		klientPasB.setBackground(new Color(250,128,114));
		klientPasB.setBounds(330, 500, 100, 50);
		klientPasB.setRolloverEnabled(true);
		klientPasB.setRolloverIcon(klientPasImazh);
		klientPasB.setPressedIcon(klientPasImazh);
		klientPasB.addActionListener(new klientPasButton());
		klientPasB.setActionCommand("pasTekRezervo");
		klientP.add(klientPasB);
		pane.add(klientP, "klientForm");
 
	
		
	/////////////////////////////////////////////////////paneli i katert per perzgjedhjen e nje makine (makineP)//////////////////////////////////////////
	//--------------------------------etiketat per perzgjedhjen e makines
		makineP = new JPanel(null);
		makineP.setBackground(new Color(255, 245, 238));
	
		makineL = new JLabel("Te dhenat e makinave");
		makineL.setFont(new Font("Verdana", Font.BOLD, 20));
		makineL.setForeground(Color.BLACK);
		makineL.setBounds(415, 254, 340, 30);
		makineP.add(makineL);
	
	//------------------------------------butonat per perzgjedhjen e makines
	//---------------------------------------------------------butonat e makinave
	//-------------------------------------butoni i makines se pare
		ImageIcon ePareMakineImazh = new ImageIcon("C:\\Users\\admin\\Downloads\\Projekt Java 2022\\imazhet\\m1.PNG\\");
		ePareMakineB = new JButton(ePareMakineImazh);
		ePareMakineB.setBackground(Color.WHITE);
		ePareMakineB.addActionListener(new ePareMakineButton());
		ePareMakineB.setRolloverEnabled(true);
		ePareMakineB.setRolloverIcon(ePareMakineImazh);
		ePareMakineB.setPressedIcon(ePareMakineImazh);
		ePareMakineB.setBounds(10, 10, 190, 130);
		makineP.add(ePareMakineB);
	
	//---------------------------------butoni i makines se dyte
		ImageIcon eDyteMakineImazh = new ImageIcon("C:\\Users\\admin\\Downloads\\Projekt Java 2022\\imazhet\\m2.PNG\\");
		eDyteMakineB = new JButton(eDyteMakineImazh);
		eDyteMakineB.setBackground(Color.WHITE);
		eDyteMakineB.addActionListener(new eDyteMakineButton());
		eDyteMakineB.setRolloverEnabled(true);
		eDyteMakineB.setRolloverIcon(eDyteMakineImazh);
		eDyteMakineB.setPressedIcon(eDyteMakineImazh);
		eDyteMakineB.setBounds(210, 10, 190, 130);
		makineP.add(eDyteMakineB);
		
	//---------------------------------------butoni i makines se trete
		ImageIcon eTreteMakineImazh = new ImageIcon("C:\\Users\\admin\\Downloads\\Projekt Java 2022\\imazhet\\m3.PNG\\");
		eTreteMakineB = new JButton(eTreteMakineImazh);
		eTreteMakineB.setBackground(Color.WHITE);
		eTreteMakineB.addActionListener(new eTreteMakineButton());
		eTreteMakineB.setRolloverEnabled(true);
		eTreteMakineB.setRolloverIcon(eTreteMakineImazh);
		eTreteMakineB.setPressedIcon(eTreteMakineImazh);
		eTreteMakineB.setBounds(10, 150, 190, 130);
		makineP.add(eTreteMakineB);
	
	//------------------------------------------butoni i makines se katert
		ImageIcon eKatertMakineImazh= new ImageIcon("C:\\Users\\admin\\Downloads\\Projekt Java 2022\\imazhet\\m4.PNG\\");
		eKatertMakineB = new JButton(eKatertMakineImazh);
		eKatertMakineB.setBackground(Color.WHITE);
		eKatertMakineB.addActionListener(new eKatertMakineButton());
		eKatertMakineB.setRolloverEnabled(true);
		eKatertMakineB.setRolloverIcon(eKatertMakineImazh);
		eKatertMakineB.setPressedIcon(eKatertMakineImazh);
		eKatertMakineB.setBounds(210, 150, 190, 130);
		makineP.add(eKatertMakineB);
		
		//-------------------------------------butoni i makines se peste

		ImageIcon ePesteMakineImazh = new ImageIcon("C:\\Users\\admin\\Downloads\\Projekt Java 2022\\imazhet\\m5.PNG\\");
		ePesteMakineB = new JButton(ePesteMakineImazh);
		ePesteMakineB.setBackground(Color.WHITE);
		ePesteMakineB.addActionListener(new ePesteMakineButton());
		ePesteMakineB.setRolloverEnabled(true);
		ePesteMakineB.setRolloverIcon(ePesteMakineImazh);
		ePesteMakineB.setPressedIcon(ePesteMakineImazh);
		ePesteMakineB.setBounds(10, 290, 190, 130);
		makineP.add(ePesteMakineB);
		
		//-------------------------------------butoni i makines se gjashte

		ImageIcon eGjashteMakineImazh = new ImageIcon("C:\\Users\\admin\\Downloads\\Projekt Java 2022\\imazhet\\m6.PNG\\");
		eGjashteMakineB = new JButton(eGjashteMakineImazh);
		eGjashteMakineB.setBackground(Color.WHITE);
		eGjashteMakineB.addActionListener(new eGjashteMakineButton());
		eGjashteMakineB.setRolloverEnabled(true);
		eGjashteMakineB.setRolloverIcon(eGjashteMakineImazh);
		eGjashteMakineB.setPressedIcon(eGjashteMakineImazh);
		eGjashteMakineB.setBounds(210, 290, 190, 130);
		makineP.add(eGjashteMakineB);
		
		//-------------------------------------butoni i makines se shtate

		ImageIcon eShtateMakineImazh = new ImageIcon("C:\\Users\\admin\\Downloads\\Projekt Java 2022\\imazhet\\m7.PNG\\");
		eShtateMakineB = new JButton(eShtateMakineImazh);
		eShtateMakineB.setBackground(Color.WHITE);
		eShtateMakineB.addActionListener(new eShtateMakineButton());
		eShtateMakineB.setRolloverEnabled(true);
		eShtateMakineB.setRolloverIcon(eShtateMakineImazh);
		eShtateMakineB.setPressedIcon(eShtateMakineImazh);
		eShtateMakineB.setBounds(10, 430, 190, 130);
		makineP.add(eShtateMakineB);
		
		//-------------------------------------butoni i makines se tete

		ImageIcon eTeteMakineImazh = new ImageIcon("C:\\Users\\admin\\Downloads\\Projekt Java 2022\\imazhet\\m8.PNG\\");
		eTeteMakineB = new JButton(eTeteMakineImazh);
		eTeteMakineB.setBackground(Color.WHITE);
		eTeteMakineB.addActionListener(new eTeteMakineButton());
		eTeteMakineB.setRolloverEnabled(true);
		eTeteMakineB.setRolloverIcon(eTeteMakineImazh);
		eTeteMakineB.setPressedIcon(eTeteMakineImazh);
		eTeteMakineB.setBounds(210, 430, 190, 130);
		makineP.add(eTeteMakineB);
		
		//-------------------------------------butoni i makines se nente

		ImageIcon eNenteMakineImazh = new ImageIcon("C:\\Users\\admin\\Downloads\\Projekt Java 2022\\imazhet\\m9.PNG\\");
		eNenteMakineB = new JButton(eNenteMakineImazh);
		eNenteMakineB.setBackground(Color.WHITE);
		eNenteMakineB.addActionListener(new eNenteMakineButton());
		eNenteMakineB.setRolloverEnabled(true);
		eNenteMakineB.setRolloverIcon(eNenteMakineImazh);
		eNenteMakineB.setPressedIcon(eNenteMakineImazh);
		eNenteMakineB.setBounds(10, 570, 190, 130);
		makineP.add(eNenteMakineB);
		
		//-------------------------------------butoni i makines se dhjete

		ImageIcon eDhjeteMakineImazh = new ImageIcon("C:\\Users\\admin\\Downloads\\Projekt Java 2022\\imazhet\\m10.PNG\\");
		eDhjeteMakineB = new JButton(eDhjeteMakineImazh);
		eDhjeteMakineB.setBackground(Color.WHITE);
		eDhjeteMakineB.addActionListener(new eDhjeteMakineButton());
		eDhjeteMakineB.setRolloverEnabled(true);
		eDhjeteMakineB.setRolloverIcon(eDhjeteMakineImazh);
		eDhjeteMakineB.setPressedIcon(eDhjeteMakineImazh);
		eDhjeteMakineB.setBounds(210, 570, 190, 130);
		makineP.add(eDhjeteMakineB);
	//-------------------------------------------------per te shkuar tek seksioni i fatures (hapi final)
		ImageIcon makineParaImazh = new ImageIcon("C:\\Users\\admin\\Downloads\\Projekt Java 2022\\imazhet\\submit.GIF\\");
		makineParaB = new JButton(makineParaImazh);
		makineParaB.setBackground(new Color(173, 255, 47 ));
		makineParaB.setBounds(460, 750, 100, 50);
		makineParaB.addActionListener(new finalStepButton());
		makineParaB.setRolloverEnabled(true);
		makineParaB.setRolloverIcon(makineParaImazh);
		makineParaB.setPressedIcon(makineParaImazh);
		makineP.add(makineParaB);
		
	//--------------------------------------------------------------------per te shkuar pas tek seksioni i klientit
		ImageIcon makinePasImazh = new ImageIcon("C:\\Users\\admin\\Downloads\\Projekt Java 2022\\imazhet\\back.png\\");
		makinePasB = new JButton(makinePasImazh);
		makinePasB.setBackground(new Color(250, 128, 114));
		makinePasB.addActionListener(new makinePasButton());
		makinePasB.setBounds(330, 750, 100, 50);
		makinePasB.setRolloverEnabled(true);
		makinePasB.setRolloverIcon(makinePasImazh);
		makinePasB.setPressedIcon(makinePasImazh);
		makinePasB.setActionCommand("PasTekKlient");
		makineP.add(makinePasB);
		
	//-----------------------------------zone teksti per zgjedhjen e nje makine duke vendosur detaje per makinen kur klikojme butonat siper
		makineDetajeTA = new JTextArea(6, 25);
		makineDetajeTA.setText("\nKlikoni mbi makinen qe doni \n       te merrni me qera");
		makineDetajeTA.setFont(new Font("Serif", Font.BOLD, 20));
		makineDetajeTA.setBackground(new Color(245, 222, 179 ));
		makineDetajeTA.setAutoscrolls(true);
		makineDetajeTA.setEditable(false);
		makineDetajeTA.setBounds(420, 300, 380, 400);
		makineP.add(makineDetajeTA);
		pane.add(makineP, "zgjidhMakineForm");
		
	////////////////////////////////////////////////////paneli i fundit i fatures (finalP)/////////////////////////////////////
		finalP = new JPanel(null);

		fatureA = new JTextArea(2500, 2500);
		fatureA.setFont(new Font("Serif", Font.BOLD, 20));
		fatureA.setBackground(new Color(255,235,205));
		fatureA.setForeground(Color.black);
		fatureA.setEditable(false);
		fatureA.setBounds(60, 30, 500, 800); //
		finalP.add(fatureA);
		pane.add(finalP, "fature");

	}
	

	////////////////////////////////////////////////////////kontrolluesit//////////////////////////////////////////////
	//-------------------------------------main (shko tek rezervoForm)
	private class mainParaButton implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout)pane.getLayout();
			
			if(event.getActionCommand().equals("ParaTekRezervo")) {
				cL.show(pane, "rezervoForm");
			}
		}
	}
	
	//------------------------------------------------rezervo
	//---------------------------------------------------shko tek KlientForm
	//-----------------------------------------------duke perfshire vertetimin nese plotesohen kerkesat per panelin tjeter
	private class rezervoParaButton implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout)pane.getLayout();
			
			if(event.getActionCommand().equals("ParaTekKlient")) {
						
				String muajiAktual, muajiMarrjes, muajKthimi, MuajLindje;
				int	dataAktuale, vitiAktual, dataMarrjes, vitiMarrjes, dateKthimi,
					kthimVit, dateLindje, VitLindje;
					
				muajiAktual = (String)cMCB.getSelectedItem();
				dataAktuale = (int)cDCB.getSelectedItem();
				vitiAktual = (int)cYCB.getSelectedItem();
				
				muajiMarrjes = (String)pUMCB.getSelectedItem();
				dataMarrjes = (int)pUDCB.getSelectedItem();
				vitiMarrjes = (int)pUYCB.getSelectedItem();
			
				muajKthimi = (String)rMCB.getSelectedItem();
				dateKthimi = (int)rDCB.getSelectedItem();
				kthimVit = (int)rYCB.getSelectedItem();
			
				MuajLindje = (String)bMCB.getSelectedItem();
				dateLindje = (int)bDCB.getSelectedItem();
				VitLindje = (int)bYCB.getSelectedItem(); //ruajtja e dates se transaksionit, kontrollon vlefshmerine e dates dhe moshes, do tju kerkoje KujdesRezervo
			
				aTrans.setTransaksion(aKlient, aMakine, muajiAktual, dataAktuale, vitiAktual, muajiMarrjes,
				dataMarrjes, vitiMarrjes, muajKthimi, dateKthimi, kthimVit, 
				MuajLindje, dateLindje, VitLindje);
				shfaqMoshaL.setText(aTrans.toStringMosha()); //shfaq tekstin e moshes per te dhenat
			
				if(!aTrans.toStringDateKontroll().equals("TRUE")) { //kontrollon vlefshmerine e dates se marrjes dhe dates se kthimit
					dataKontroll.setForeground(Color.RED);
					dataKontroll.setText("E pavlefshme!");
				}
				
				else {
					dataKontroll.setForeground(Color.GREEN);
					dataKontroll.setText("E vlefshme");
				}
				
				if(!aTrans.toStringMoshaKontroll().equals("TRUE")) { // vlefshmeria e moshes
					moshaKontroll.setForeground(Color.RED);
					moshaKontroll.setText("E pavlefshme!");
				}
				
				else {
					moshaKontroll.setForeground(Color.GREEN);
					moshaKontroll.setText("E vlefshme");
				}
				
				if(aTrans.toStringDateKontroll().equals("TRUE") && aTrans.toStringMoshaKontroll().equals("TRUE")) { //Kontroll to proceed next panel
					cL.show(pane, "klientForm");
				}
				else { //nxjerr nje dritare per KujdesKlient
					if(hapKujdesRezervo == null){
						hapKujdesRezervo = new KujdesRezervo();
						ImageIcon kujdesRezervoImazh = new ImageIcon("C:\\Users\\admin\\Downloads\\Projekt Java 2022\\imazhet\\warning_top_icon.GIF\\");
						hapKujdesRezervo.setIconImage(kujdesRezervoImazh.getImage());
						hapKujdesRezervo.setTitle("Kujdes !!");
						hapKujdesRezervo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						hapKujdesRezervo.setSize(300, 150);
						hapKujdesRezervo.setVisible(true);
						hapKujdesRezervo.setResizable(false);
					}

					else{
						hapKujdesRezervo.setVisible(!hapKujdesRezervo.isVisible());
					}
				}
			}
		}
	}
				
				
	//-------------------------------------------------shko pas ne mireseviniForm
		private class rezervoPasButton implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				CardLayout cL = (CardLayout)pane.getLayout();
				
				if(event.getActionCommand().equals("PasTekMiresevini")) {
					cL.show(pane, "mireseviniForm");
				}
			}
		}
	
		//------------------------------------------klienti
		//-----------------------------------------------shko te ZgjidhMakineForm
		//-----------------------------------------------duke perfshire vertetimin nese plotesohen kerkesat per panelin tjeter
		private class klientParaButton implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				CardLayout cL = (CardLayout)pane.getLayout();
				
				
				if(event.getActionCommand().equals("ParaTekZgjidhMakine")) {
																			
					String emri, mbiemri, gjinia,status,  vendodhja, kontakti;
					
					emri = emriTF.getText();
					mbiemri = mbiemriTF.getText();
					gjinia = gjiniaTF.getText();
					status = statusTF.getText();
					vendodhja = vendodhjaTF.getText();
					kontakti = kontaktiTF.getText();
					
					aKlient.setKlient(emri, mbiemri, gjinia,status, vendodhja, kontakti);
					
					if(aKlient.getemri().equals("Shkruani emrin tuaj")) { //kontrollon nese emri eshte bosh apo jo
						emriKontroll.setForeground(Color.RED);
						emriKontroll.setText("E pavlefshme!");
					}
					
					else {
						emriKontroll.setForeground(Color.GREEN);
						emriKontroll.setText("E vlefshme");
					}
					
					if(aKlient.getmbiemri().equals("Shkruani mbiemrin tuaj")) { //kontrollon mbiemrin
						mbiemriKontroll.setForeground(Color.RED);
						mbiemriKontroll.setText("E pavlefshme!");
					}
					
					else {
						mbiemriKontroll.setForeground(Color.GREEN);
						mbiemriKontroll.setText("E vlefshme");
					}
					
					if(aKlient.getgjinia().equals("M/F")) { //kontrollon gjinine
						gjiniaKontroll.setForeground(Color.RED);
						gjiniaKontroll.setText("E pavlefshme!");
					}
					
					else {
						gjiniaKontroll.setForeground(Color.GREEN);
						gjiniaKontroll.setText("E vlefshme");
					}
					
					if(aKlient.getStatus().equals("S/Ma")) { //kontrollon statusin
						statusKontroll.setForeground(Color.RED);
						statusKontroll.setText("E pavlefshme!");
					}
					
					else {
						statusKontroll.setForeground(Color.GREEN);
						statusKontroll.setText("E vlefshme");
					}
					
					if(aKlient.getvendodhja().equals("Shkruani adresen e plote")) { //kontrollon vendodhjen
						vendodhjaKontroll.setForeground(Color.RED);
						vendodhjaKontroll.setText("E pavlefshme!");
					}
					
					else  {
						vendodhjaKontroll.setForeground(Color.GREEN);
						vendodhjaKontroll.setText("E vlefshme");
					}
					
					if(aKlient.getkontakti().equals("Shkruani numrin e kontaktit")) { //kontrollon numrin e kontaktit
						kontaktiKontroll.setForeground(Color.RED);
						kontaktiKontroll.setText("E pavlefshme!");
					}
					
					else  {
						kontaktiKontroll.setForeground(Color.GREEN);
						kontaktiKontroll.setText("E vlefshme");
					}
					
					if(!aKlient.getemri().equals("Shkruani emrin tuaj") && !aKlient.getmbiemri().equals("Shkruani mbiemrin tuaj") && !aKlient.getgjinia().equals("M/F") && !aKlient.getStatus().equals("S/Ma") && !aKlient.getvendodhja().equals("Shkruani adresen e plote") && !aKlient.getkontakti().equals("Shkruani numrin e kontaktit")){
						emriTF.setText("Shkruani emrin tuaj"); //nese te mesipermet jane te vlefshme, procedojme tek Makine Form
						mbiemriTF.setText("Shkruani mbiemrin tuaj");
						gjiniaTF.setText("M/F");
						statusTF.setText("S/Ma");
						vendodhjaTF.setText("Shkruani adresen e plote");
						kontaktiTF.setText("Shkruani numrin e kontaktit");
						cL.show(pane, "zgjidhMakineForm");
					}
					
					else { //nese nuk eshte e vlefshme, nxjerr nje dritare me mesazhin Kujdes
						if(hapKujdesKlient == null){
							hapKujdesKlient = new KujdesKlient();
							ImageIcon kujdesKlientImazh = new ImageIcon("C:\\Users\\admin\\Downloads\\Projekt Java 2022\\imazhet\\warning_top_icon.GIF\\");
							hapKujdesKlient.setIconImage(kujdesKlientImazh.getImage());
							hapKujdesKlient.setTitle("Kujdes E pavlefshme!!");
							hapKujdesKlient.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							hapKujdesKlient.setSize(300, 150);
							hapKujdesKlient.setVisible(true);
							hapKujdesKlient.setResizable(false);
						}
						
						else{
							hapKujdesKlient.setVisible(!hapKujdesKlient.isVisible());
						}
					}
				}
			}
		}
		
	
		//----------------------------------------------shko pas tek rezervoForm
		private class klientPasButton implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				CardLayout cL = (CardLayout)pane.getLayout();
				
				if(event.getActionCommand().equals("pasTekRezervo")) {
					cL.show(pane, "rezervoForm");
				}
			}
		}
	
	//--------------------------------------------makina
	//----------------------------------------------------shko pas tek klientForm
	private class ePareMakineButton implements ActionListener{ //kur klikohet, jep informacionin per makinen e pare
		public void actionPerformed(ActionEvent event) {
		
			makineDetajeTA.setText("");
			makineDetajeTA.setText("Audi SQ7\r\nLloji i Makines : SUV\r\nKilometra: 10000\r\nViti 2021\r\nLloji i motorit: V8 4.0 l(diesel) \n507 Kuaj fuqi\r\nShpejtesia maksimale:260 kmh\r\nNumri i vendeve: 5 ose 7 \r\nNgjyra: Vishnje\r\nKambio: 8g Automatike\r\nCmimi: 100 €\r\n");
			makineParaB.setActionCommand("Makine1");
		}
	}
	
	private class eDyteMakineButton implements ActionListener{ //butoni qe jep te dhenat per makinen e dyte
		public void actionPerformed(ActionEvent event) {
		
			makineDetajeTA.setText("");
			makineDetajeTA.setText("Audi A5\r\nLloji i makines :Sedan\r\nViti :2014\r\nKilometra : 180 000\r\n"
				+ "Lloji i motorit: 2.0 tfsi\n(petrol) 224 kuaj fuqi\r\n"
				+ "Shpejtesia maksimale:220 kmh\r\n"
				+ "Numri i vendeve:5\r\n"
				+ "Ngjyra: Brown metallic\r\n"
				+ "Kambio:Automatike\r\n"
				+ "Cmimi :80 €\r\n"
				+ "\r\n"
				+ "");
		makineParaB.setActionCommand("Makine2");
		}
	}
	
	private class eTreteMakineButton implements ActionListener{ //butoni qe jep te dhenat per makinen e trete
		public void actionPerformed(ActionEvent event) {
		
			makineDetajeTA.setText("");
			makineDetajeTA.setText("Mercedes Benz CLS 500\r\n"
				+ "Lloji i makines : Sedan\r\n"
				+ "Kilometra: 100 000\r\n"
				+ "Viti: 2014\r\n"
				+ "Lloji i motorit V6 4.6l (petrol)\r\n"
				+ "Shpejtesi maksimale:260 kmh\r\n"
				+ "Numri i vendeve:5\r\n"
				+ "Ngjyra: E zeze\r\n"
				+ "Kambio: Automatike\r\n"
				+ "Cmimi: 85 euro\r\n ");
		makineParaB.setActionCommand("Makine3");
		}
	}
	
	private class eKatertMakineButton implements ActionListener{ //butoni qe jep te dhenat per makinen e katert
		public void actionPerformed(ActionEvent event) {
		
			makineDetajeTA.setText("");
			makineDetajeTA.setText("Volkswagen Tiguan\r\n"
				+ "Lloji i makines :Mini SUV\r\n"
				+ "Kilometra: 90 000\r\n"
				+ "Viti:2014\r\n"
				+ "Lloji i motorit: 2.0 tdi \n177hp\r\n"
				+ "Shpejtesi maksimale:200 kmh\r\n"
				+ "\\Numri i vendeve :5\r\n"
				+ "Ngjyra: E bardhe\r\n"
				+ "Kambio : Automatike\r\n"
				+ "Cmimi: 65 €\r\n");
		makineParaB.setActionCommand("Makine4");
		}
	}
	
	private class ePesteMakineButton implements ActionListener{ //butoni qe jep te dhenat per makinen e peste
		public void actionPerformed(ActionEvent event) {
		
			makineDetajeTA.setText("");
			makineDetajeTA.setText("Volkswagen Golf VII\r\n"
				+ "Lloji i makines : Portobagazh\n(estate)\r\n"
				+ "Kilometra:110 000\r\n"
				+ "Viti: 2013\r\n"
				+ "Lloji i motorit :1.6l tdi\r\n"
				+ "Shpejtesi maksimale: 170 kmh\r\n"
				+ "Numri i vendeve: 5\r\n"
				+ "Ngjyra: Gri\r\n"
				+ "Kambio:Manuale 6+R\r\n"
				+ "Cmimi:30 €\r\n"
				+ "");
		makineParaB.setActionCommand("Makine5");
		}
	}
	
	private class eGjashteMakineButton implements ActionListener{ //butoni qe jep te dhenat per makinen e gjashte
		public void actionPerformed(ActionEvent event) {
		
			makineDetajeTA.setText("");
			makineDetajeTA.setText("BMW serie 1\r\n"
				+ "Lloji i makines : Sedan\r\n"
				+ "Kilometra: 70 000\r\n"
				+ "Viti:2014\r\n"
				+ "Lloji i motorit:1.6l petrol \r\n"
				+ "Shpejtesi maksimale: 190 kmh\r\n"
				+ "Numri i vendeve:5\r\n"
				+ "Ngjyra:E bardhe perle\r\n"
				+ "Kambio :Manuale 6+r\r\n"
				+ "Cmimi : 70 €\r\n"
				+ "");
		makineParaB.setActionCommand("Makine6");
		}
	}
	private class eShtateMakineButton implements ActionListener{ //butoni qe jep te dhenat per makinen e shtate
		public void actionPerformed(ActionEvent event) {
		
			makineDetajeTA.setText("");
			makineDetajeTA.setText("Audi TT\r\n"
				+ "Lloji i makines : Coupe\r\n"
				+ "Kilometra: 50 000\r\n"
				+ "Viti: 2014\r\n"
				+ "Lloji i motorit :2.0l(petrol) \n211 kuaj fuqi\r\n"
				+ "Shpejtesi maksimale:200 kmh\r\n"
				+ "Numri i vendeve:2\r\n"
				+ "Ngjyra:E zeze\r\n"
				+ "Kambio: Automatike\r\n"
				+ "Cmimi: 80 €");
		makineParaB.setActionCommand("Makine7");
		}
	}
	private class eTeteMakineButton implements ActionListener{ //butoni qe jep te dhenat per makinen e tete
		public void actionPerformed(ActionEvent event) {
		
			makineDetajeTA.setText("");
			makineDetajeTA.setText("Alfa Romeo Stelvio\r\n"
				+ "Lloji i makines : SUV\r\n"
				+ "Kilometra: 3000\r\n"
				+ "Viti: 2020\r\n"
				+ "Lloji i motorit: 2.2 l(diesel)\n 210 kuaj fuqi\r\n"
				+ "Shpejtesi maksimale: 200 kmh\r\n"
				+ "Numri i vendeve:5\r\n"
				+ "Ngjyra:Blu e erret\r\n"
				+ "Kambio: Automatike\r\n"
				+ "Cmimi:65 €\r\n"
				+ "");
		makineParaB.setActionCommand("Makine8");
		}
	}
	private class eNenteMakineButton implements ActionListener{ //butoni qe jep te dhenat per makinen e nente
		public void actionPerformed(ActionEvent event) {
		
			makineDetajeTA.setText("");
			makineDetajeTA.setText("Toyota C-HR\r\n"
				+ "Lloji i makines : SUV\r\n"
				+ "Kilometra: 110 000\r\n"
				+ "Viti: 2017\r\n"
				+ "Lloji i motorit:1.7 l \n(petrol/electric)\r\n"
				+ "Shpejtesi maksimale: 180 kmh\r\n"
				+ "Numri i vendeve:5\r\n"
				+ "Ngjyra:E bardhe perle\r\n"
				+ "Kambio: Automatike\r\n"
				+ "Cmimi: 50 €\r\n"
				+ "");
		makineParaB.setActionCommand("Makine9");
		}
	}
	
	private class eDhjeteMakineButton implements ActionListener{ //butoni qe jep te dhenat per makinen e dhjete
		public void actionPerformed(ActionEvent event) {
		
			makineDetajeTA.setText("");
			makineDetajeTA.setText("Porsche 718 Cayman\r\n"
				+ "Lloji i makines :Coupe\r\n"
				+ "Kilometra: 10 000\r\n"
				+ "Viti:2020\r\n"
				+ "Lloji i motorit :2.0l \n(petrol)299 hp\r\n"
				+ "Shpejtesi maksimale:250 kmh\r\n"
				+ "Numri i vendeve:2\r\n"
				+ "Ngjyra: Green metallic\r\n"
				+ "Kambio: Automatike 9g\r\n"
				+ "Cmimi:50 €\r\n"
				+ "");
		makineParaB.setActionCommand("Makine10");
		}
	}
	private class finalStepButton implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout)pane.getLayout();
			
			if(event.getActionCommand().equals("Makine1")) { //pasi kalojme perzgjedhjen, behemi gati per proceduren e transaksionit
			
				String tipiM = "Audi SQ7", modeliM = "2021";
				double cmimiM = 100.00;
		
				aMakine.setM(tipiM, modeliM, cmimiM);
				try {
					aTrans.saveToFile();
					}catch (IOException e) {} 
					
				fatureA.setText(aTrans.toStringReceipt());
				cL.show(pane, "fature");
				
			
			}
			
			else if(event.getActionCommand().equals("Makine2")) { //perzgjedhja e makines 2
			
				String tipiM = "Audi A5", modeliM = "2014";
				double cmimiM = 80.00;
		
				aMakine.setM(tipiM, modeliM, cmimiM); 
				try {
					aTrans.saveToFile();
					}catch (IOException e) {} 
					
				fatureA.setText(aTrans.toStringReceipt());
				cL.show(pane, "fature");
				
			}
			
			
			else if(event.getActionCommand().equals("Makine3")) { //perzgjedhja e makines 3
				
				String tipiM = "CLS 500", modeliM = "2014";
				double cmimiM = 85.00;
		
				aMakine.setM(tipiM, modeliM, cmimiM); 
				try {
					aTrans.saveToFile();
					}catch (IOException e) {} 
					
				fatureA.setText(aTrans.toStringReceipt());
				cL.show(pane, "fature");
				
			}
			
			else if(event.getActionCommand().equals("Makine4")) { //perzzgjedhja e makines 4
				
				String tipiM = "Tiguan", modeliM = "2014";
				double cmimiM = 65.00;
		
				aMakine.setM(tipiM, modeliM, cmimiM); 
				try {
					aTrans.saveToFile();
					}catch (IOException e) {} 
					
				fatureA.setText(aTrans.toStringReceipt());
				cL.show(pane, "fature");
				
			}
else if(event.getActionCommand().equals("Makine5")) { //perzgjedhja e makines 5
				
				String tipiM = "Golf", modeliM = "2013";
				double cmimiM = 30.00;
		
				aMakine.setM(tipiM, modeliM, cmimiM); 
				try {
					aTrans.saveToFile();
					}catch (IOException e) {} 
					
				fatureA.setText(aTrans.toStringReceipt());
				cL.show(pane, "fature");
				
			}
else if(event.getActionCommand().equals("Makine6")) { //perzgjedhja e makines 6
	
	String tipiM = "BMW", modeliM = "2014";
	double cmimiM = 70.00;

	aMakine.setM(tipiM, modeliM, cmimiM); 
	try {
		aTrans.saveToFile();
		}catch (IOException e) {} 
		
	fatureA.setText(aTrans.toStringReceipt());
	cL.show(pane, "fature");
	
}
else if(event.getActionCommand().equals("Makine7")) { //perzgjedhja e makines 7
	
	String tipiM = "Audi TT", modeliM = "2014";
	double cmimiM = 80.00;

	aMakine.setM(tipiM, modeliM, cmimiM); 
	try {
		aTrans.saveToFile();
		}catch (IOException e) {} 
		
	fatureA.setText(aTrans.toStringReceipt());
	cL.show(pane, "fature");
	
}
else if(event.getActionCommand().equals("Makine8")) { //perzgjedhja e makines 8
	
	String tipiM = "SUV", modeliM = "2020";
	double cmimiM = 65.00;

	aMakine.setM(tipiM, modeliM, cmimiM); 
	try {
		aTrans.saveToFile();
		}catch (IOException e) {} 
		
	fatureA.setText(aTrans.toStringReceipt());
	cL.show(pane, "fature");
	
}
else if(event.getActionCommand().equals("Makine9")) { //perzgjedhja e makines 9
	
	String tipiM = "Toyota", modeliM = "2017";
	double cmimiM = 50.00;

	aMakine.setM(tipiM, modeliM, cmimiM); 
	try {
		aTrans.saveToFile();
		}catch (IOException e) {} 
		
	fatureA.setText(aTrans.toStringReceipt());
	cL.show(pane, "fature");
	
}
else if(event.getActionCommand().equals("Makine10")) { //perzgjedhja e makines 10
	
	String tipiM = "Porche Cayene", modeliM = "2020";
	double cmimiM = 50.00;

	aMakine.setM(tipiM, modeliM, cmimiM); 
	try {
		aTrans.saveToFile();
		}catch (IOException e) {} 
		
	fatureA.setText(aTrans.toStringReceipt());
	cL.show(pane, "fature");
	
}
			
else { //shfaq mesazh Kujdes nese klienti nuk ka zgjedhur nje makine
	if(hapKujdesMakine == null){
		hapKujdesMakine = new KujdesMakine();
		ImageIcon kujdesMakineImazh = new ImageIcon("C:\\Users\\admin\\Downloads\\Projekt Java 2022\\imazhet\\warning_top_icon.GIF\\");
		hapKujdesMakine.setIconImage(kujdesMakineImazh.getImage());
		hapKujdesMakine.setTitle("Kujdes, e pavlefshme!!");
		hapKujdesMakine.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		hapKujdesMakine.setSize(300, 150);
		hapKujdesMakine.setVisible(true);
		hapKujdesMakine.setResizable(false);
	}
		
	else{
		hapKujdesMakine.setVisible(!hapKujdesMakine.isVisible());
	}
}
}
}

private class makinePasButton implements ActionListener{ //kthehu te forma e klientit kur klikohet dhe kryhet
public void actionPerformed(ActionEvent event) {
CardLayout cL = (CardLayout)pane.getLayout();

if(event.getActionCommand().equals("PasTekKlient")) {
	cL.show(pane, "klientForm");
}
}
}
}
