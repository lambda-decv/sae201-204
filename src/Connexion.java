
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Alexis
 */
public class Connexion extends JDialog implements ActionListener, FocusListener {

    FenetreStat owner;
    JButton exit;
    JButton valider;
    JLabel nom;
    JTextField mdp;
    JLabel text;

    public Connexion(FenetreStat owner, int utilisateur) {
        this.owner = owner;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBackground(Color.white);
        this.setModal(true);
        
        this.setLocationRelativeTo(owner);
        this.setSize(new Dimension(125, 125));
        this.setLocation(350, 125);
        this.setLayout(new GridBagLayout());
        GridBagConstraints cont = new GridBagConstraints();
        cont.fill = GridBagConstraints.BOTH;
        
//        this.setBounds(300, 300, 50, 50);
        
     
        if (utilisateur==1){
            nom=new JLabel("administrator");
           
        }
        if (utilisateur==2){
            nom=new JLabel("manager");
        }
        cont.gridx = 0;
        cont.gridy = 0;
        this.add(nom, cont);

        mdp = new JTextField("");
        mdp.setText("MDP");
        cont.gridx = 0;
        cont.gridy = 2;
        this.add(mdp, cont);

        valider = new JButton("Valider");
        cont.gridx = 0;
        cont.gridy = 3;
        this.add(valider, cont);

        cont.gridx = 0;
        cont.gridy = 4;
        exit = new JButton("Exit");
        this.add(exit, cont);
        
        mdp.addActionListener(this);
        exit.addActionListener(this);
        valider.addActionListener(this);


        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            this.setVisible(false);
        }
        if (e.getSource() == valider ) {
            pAdmin a=new pAdmin(this);

        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == mdp) {
            mdp.setText("d");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
    }

}
