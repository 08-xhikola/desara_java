/////////////////////Klasa KujdesRezervo///////////////

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KujdesRezervo extends JFrame{

	private JPanel kujdesP;
	private JLabel tekstL, ikoneL;
	
	private Transaksion aTrans = new Transaksion(); //akseson klasen Transaksion si nje deklarim global
	
	public KujdesRezervo(){
		
		Container pane = getContentPane(); //kontenieri
		kujdesP = new JPanel(null);
		kujdesP.setBackground(Color.WHITE);
		
		ImageIcon kujdesImazh = new ImageIcon("C:\\Users\\admin\\Downloads\\Projekt Java 2022\\imazhet\\warning_icon.GIF\\");
		ikoneL = new JLabel(kujdesImazh);
		ikoneL.setBounds(20, 35, 50, 50);
		kujdesP.add(ikoneL);
		
		tekstL = new JLabel("");
		tekstL.setText("E pavlefshme!");
		tekstL.setFont(new Font("Serif", Font.BOLD, 15));
		tekstL.setForeground(Color.RED);
		tekstL.setBounds(80, 48, 100, 20);
		kujdesP.add(tekstL);
		pane.add(kujdesP);
	}
}