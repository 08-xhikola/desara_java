//////////////////Klasa KujdesKlient///////////

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KujdesKlient extends JFrame{

	private JPanel kujdesP;
	private JLabel tekstL, ikoneL;
	
	private Transaksion aTrans = new Transaksion(); //akseson klasen Transaksion si nje deklarim global
	
	public KujdesKlient(){
		
		Container pane = getContentPane(); //krijojme kontenierin ku do vendosen etiketat,fushat dhe kutite e krijuara
		kujdesP = new JPanel(null);
		kujdesP.setBackground(Color.WHITE);
		
		ImageIcon kujdesImazh = new ImageIcon("C:\\Users\\admin\\Downloads\\Projekt Java 2022\\imazhet\\warning_icon.GIF\\");
		ikoneL = new JLabel(kujdesImazh);
		ikoneL.setBounds(20, 35, 50, 50);
		kujdesP.add(ikoneL);
		
		tekstL = new JLabel("");
		tekstL.setText("Plotesoni te gjitha detajet!");
		tekstL.setFont(new Font("Serif", Font.BOLD, 15));
		tekstL.setForeground(Color.RED);
		tekstL.setBounds(80, 48, 200, 20);
		kujdesP.add(tekstL);
		pane.add(kujdesP);
	}
}