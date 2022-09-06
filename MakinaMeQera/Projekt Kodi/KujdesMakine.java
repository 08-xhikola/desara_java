//////////////Klasa KujdesMakine/////////////

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KujdesMakine extends JFrame{

	private JPanel kujdesP;
	private JLabel tekstL, ikoneL;
	
	private Transaksion aTrans = new Transaksion(); //akeson klasen Transaksion si nje deklarim global
	
	public KujdesMakine(){
		
		Container pane = getContentPane(); //kontenieri
		kujdesP = new JPanel(null);
		kujdesP.setBackground(Color.WHITE);
		
		ImageIcon kujdesImazh = new ImageIcon("C:\\Users\\admin\\Downloads\\Projekt Java 2022\\imazhet_e_perdorura_ne_kod\\warning_icon.GIF\\");
		ikoneL = new JLabel(kujdesImazh);
		ikoneL.setBounds(20, 35, 50, 50);
		kujdesP.add(ikoneL);
		
		tekstL = new JLabel("");
		tekstL.setText("Klikoni nje makine");
		tekstL.setFont(new Font("Serif", Font.BOLD, 15));
		tekstL.setForeground(Color.RED);
		tekstL.setBounds(80, 48, 200, 20);
		kujdesP.add(tekstL);
		pane.add(kujdesP);
	}
}