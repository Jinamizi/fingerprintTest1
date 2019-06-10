
package com.machinezoo.sourceafis.myTest;
import javax.swing.*;

public class NewClass {
    public static void main(String []s ){
        JFrame frame = new JFrame();
        ImageIcon icon = new ImageIcon("C:\\tonny\\projecting\\Test1\\src\\test\\resources\\com\\machinezoo\\sourceafis\\probe.png" );
        JLabel label = new JLabel(icon);
        frame.add(label);
        frame.setSize(200,33);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
