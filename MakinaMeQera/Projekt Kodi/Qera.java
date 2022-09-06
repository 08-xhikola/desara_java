//////////////////////////////////////////////////////////MAIN//////////////////////////////////////////
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.URL;


public class Qera{ 

  private static final int WIDTH = 700;  //japim permasat e kornizes
  private static final int HEIGHT = 850;

  public static void main(String[] args) {

    JFrame frame = new QeraShiko();
    ImageIcon img = new ImageIcon("C:\\Users\\admin\\Downloads\\Projekt Java 2022\\imazhet\\logo.GIF\\"); //logo e kornizes
    frame.setIconImage(img.getImage());
    frame.setTitle("Sistemi i dhenies me qera te makinave:"); //emertojme kornizen
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(WIDTH, HEIGHT);
    frame.setVisible(true); //bejme shfaqjen e dritares
    frame.setResizable(false); //permasat e dritares te pandryshueshme
   }


}
