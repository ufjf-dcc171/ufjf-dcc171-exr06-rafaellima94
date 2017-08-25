package ufjf.dcc;

import javax.swing.JFrame;

public class Aula05Exm02 {
    
    public static void main(String[] args) {
        PedraPapelTesoura ppt = new PedraPapelTesoura();
        ppt.setSize(400, 200);
        ppt.setLocationRelativeTo(null);
        ppt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ppt.setVisible(true);
    }
    
}
