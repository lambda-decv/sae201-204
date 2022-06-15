
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Alexis
 */
public class pAdmin extends JDialog implements ActionListener,ListSelectionListener {

    Connexion owner;

    // Attribution rôle
    JComboBox role;
    JComboBox user;
    JTextArea labelArea;
 
   // SUpression donnée
    JLabel suppr;
    JList listasup;
    
    // Ajout
    JLabel ajout;
    JTextField ajout1;
    JTextField ajout2;
    JButton valider;
    
    // Exit
    JButton exit;

    public pAdmin(Connexion owner) {
        this.owner = owner;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBackground(Color.white);
        this.setModal(true);
        
        this.setLocationRelativeTo(owner);
        this.setSize(new Dimension(400,400));
        this.setLayout(new GridBagLayout());
        GridBagConstraints cont = new GridBagConstraints();
        cont.fill = GridBagConstraints.BOTH;

        
        //Texte
        cont.gridheight=2;
        cont.gridwidth=2;
        ajout = new JLabel("Ajout de données : ");
        cont.gridx = 1;
        cont.gridy = 1;
        this.add(ajout, cont);

      
        
        
        labelArea = new JTextArea("Attribution rôle \n\n                       à :");
        labelArea.setEditable(false);
        labelArea.setOpaque(false);
        cont.gridx = 5;
        cont.gridy = 1;
        this.add(labelArea, cont);
        
          suppr = new JLabel("Supression données :");
        cont.gridx = 3;
        cont.gridy = 4;
        this.add(suppr, cont);
        
        //Case
        
 cont.gridheight=1;
        cont.gridwidth=1;
          String[] tabRole= new String[] {"administrator","manager"};
        role = new JComboBox<String>(tabRole);
        cont.gridx = 7;
        cont.gridy = 1;
        this.add(role, cont);
      
         String[] tabUser= new String[] {"administrator","manager"};
        user = new JComboBox<String>(tabUser);
        cont.gridx = 7;
        cont.gridy = 2;
        this.add(user, cont);

       
        ajout1 = new JTextField("");
        cont.gridx = 0;
        cont.gridy = 2;
        this.add(ajout1, cont);
        
        exit = new JButton("exit");
        cont.gridx = 5;
        cont.gridy = 0;
        this.add(exit, cont);


        ajout2 = new JTextField("");
        cont.gridx = 2;
        cont.gridy = 2;
        this.add(ajout2, cont);
        
        
        valider=new JButton("Valider");
        cont.gridx = 3;
        cont.gridy = 2;
        this.add(valider, cont);

        exit.addActionListener(this);
      this.setVisible(true);
    }
    

   

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==exit){
            System.exit(0);
        }
    if (e.getSource()==valider){
     ajout1.getText();
     ajout2.getText();
    }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
