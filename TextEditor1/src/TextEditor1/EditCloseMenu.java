package TextEditor1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class EditCloseMenu implements ActionListener {

	JMenuBar menuBar;
    JMenu edit;
	JTextArea textArea;
	JMenuItem copy,paste,cut,selectAll,close;
	EditCloseMenu(){
	// Initialize a textArea
	textArea = new JTextArea();

	// Initialize a menuBar
	menuBar = new JMenuBar();

	// Initialize a frame item
	edit  = new JMenu("Edit");
	close = new JMenuItem("Close");
		
	// Initialize a edit items
	copy = new JMenuItem("Copy");
	paste = new JMenuItem("Paste");
	cut = new JMenuItem("Cut");
	selectAll = new JMenuItem("Select All");
		
	//add action listeners to edit menu items
	copy.addActionListener(this);
	paste.addActionListener(this);
	cut.addActionListener(this);
	selectAll.addActionListener(this);
	    
	//add action listeners to close menu
	close.addActionListener(this);
	
	// add menu items to file Jmenu
	edit.add(copy);
	edit.add(paste);
	edit.add(cut);
	edit.add(selectAll);
	    
	// add edit and close to menu bar
	menuBar.add(edit);
	menuBar.add(close);
   
}
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
	// if copy option click
	if(actionEvent.getSource()==copy){
       textArea.copy();
      }
	
    // if paste option click
    if(actionEvent.getSource()==paste){
       textArea.paste();
      }
     
   	// if cut option clicks
    if(actionEvent.getSource()==cut){
       textArea.cut();
      }
        
    // if selectAll option clicks
    if(actionEvent.getSource()==selectAll){
       textArea.selectAll();
      }
    // if close option clicks
    if(actionEvent.getSource()==close){
       System.exit(0);
      }
		
}
}
