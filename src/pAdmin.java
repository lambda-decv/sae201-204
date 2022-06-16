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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
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

//Reprendre la page entière
public class pAdmin extends JDialog implements ActionListener,ListSelectionListener {

    Connexion owner;
    GridBagConstraints cont;

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
    JList list;
    
    // Exit
    JButton exit;

    public pAdmin(Connexion owner) {
        this.owner = owner;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBackground(Color.white);
        this.setModal(true);
        this.setBackground(new Color(128, 150, 138));
        this.setTitle("Gestion base");
        this.setLocationRelativeTo(owner);
        this.setSize(new Dimension(600,400));
        this.setLayout(new GridBagLayout());
        cont = new GridBagConstraints();
        cont.fill = GridBagConstraints.BOTH;
        
        
        init(2);
   
        exit.addActionListener(this);
        this.pack();
      this.setVisible(true);
    }
    

   public void init(int rolex){
 
        
        
      
        
        //Ajout
        cont.gridheight=2;
        cont.gridwidth=2;
        ajout = new JLabel("Ajout de données : ");
        cont.gridx = 1;
        cont.gridy = 1;
        this.add(ajout, cont);
        
         cont.gridheight=1;
        cont.gridwidth=1;
          ajout2 = new JTextField("");
        cont.gridx = 2;
        cont.gridy = 3;
        this.add(ajout2, cont);
        
        valider=new JButton("Valider");
        cont.gridx = 3;
        cont.gridy = 3;
        this.add(valider, cont);
        //Supp

        cont.gridheight=2;
        cont.gridwidth=2;
          suppr = new JLabel("Supression données :");
         cont.gridx = 2;
        cont.gridy = 6;
        this.add(suppr, cont);
        
        cont.gridx = 4;
        cont.gridy = 6;
        this.add(new JScrollPane(drawJList()),cont);
          list.addListSelectionListener(this);
       
          if (rolex==1){
        this.setTitle("Gestion admin");
        //Role
        
         labelArea = new JTextArea("Attribution rôle \n\n                       à :");
        labelArea.setEditable(false);
        labelArea.setOpaque(false);
        cont.gridx = 7;
        cont.gridy = 3;
        this.add(labelArea, cont);
       cont.gridheight=1;
        cont.gridwidth=1;
          String[] tabRole= new String[] {"administrator","manager"};
        role = new JComboBox<String>(tabRole);
        cont.gridx = 9;
        cont.gridy = 3;
        this.add(role, cont);
      
         String[] tabUser= new String[] {"administrator","manager"};
        user = new JComboBox<String>(tabUser);
        cont.gridx = 9;
        cont.gridy = 4;
        this.add(user, cont);}

        
     
        exit = new JButton("exit");
        cont.gridx = 6;
        cont.gridy = 0;
        this.add(exit, cont);
        
        //Case
        

       
      
        
        

       
   }
   
   public JList drawJList(){
        String[] a={"daronne","a,","jules","corto","axeld'avion"};
        list=new JList(a);
        list.setVisibleRowCount(4);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        return list;
       
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
        if (e.getValueIsAdjusting())
        System.out.println(list.getSelectedIndex());
    }

}