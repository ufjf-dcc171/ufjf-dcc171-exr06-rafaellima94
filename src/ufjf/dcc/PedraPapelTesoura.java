package ufjf.dcc;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class PedraPapelTesoura extends JFrame{
    private final JTextField placar = new JTextField("Placar", 20);
    private final JTextField jogada = new JTextField("Jogada do computador", 20);
    private final JButton btnPedra;
    private final JButton btnPapel;
    private final JButton btnTesoura;
    private Integer pontosPlayer = 0;
    private Integer pontosPC = 0;
            
    public PedraPapelTesoura() throws HeadlessException{
        super("Radio");
        setLayout(new FlowLayout());
        btnPedra = new JButton("Pedra");
        btnPapel = new JButton("Papel");
        btnTesoura = new JButton("Tesoura");
        
        add(btnPedra);
        add(btnPapel);
        add(btnTesoura);
        add(jogada);
        add(placar);
      
        btnPedra.addActionListener(new Jogo());
        btnPapel.addActionListener(new Jogo());
        btnTesoura.addActionListener(new Jogo());
    }
    
    private class Jogo implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Random rand = new Random();
            String jogadaPCText;
            Integer jogadaPC =rand.nextInt(3);
            
            if(jogadaPC == 0){
                jogadaPCText = "Pedra";
            } else if(jogadaPC == 1){
                jogadaPCText = "Papel";                
            } else {
                jogadaPCText = "Tesoura";                
            }
            
            // player ganha ponto se
            if((jogadaPC == 0 && e.getActionCommand() == btnPapel.getText())|| (jogadaPC == 1 && e.getActionCommand() == btnTesoura.getText()) || (jogadaPC == 2 && e.getActionCommand() == btnPedra.getText())){
                pontosPlayer++;
            } else if((jogadaPC == 0 && e.getActionCommand() == btnTesoura.getText()) || (jogadaPC == 1 && e.getActionCommand() == btnPedra.getText()) || (jogadaPC == 2 && e.getActionCommand() == btnPapel.getText())){
                pontosPC++;
            }
            
            jogada.setText("o computador jogou: "+jogadaPCText);
            placar.setText("Jogador: "+pontosPlayer+" x Computador: "+pontosPC);
        }
        
    }
}
