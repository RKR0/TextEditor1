package TextEditor1;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


class TextEditor1{
   
    JFrame frame;
    JTextArea textArea;
  
    TextEditor1(){
    	
    // Initialize fileMenu and editcloseMenu
    FileMenu fileMenu = new FileMenu();
    EditCloseMenu editcloseMenu = new EditCloseMenu();
    
    // Initialize a frame
    frame = new JFrame();
    
    // initialize a text Area
    textArea = new JTextArea();
    
    // add file menu bar and edit menu bar to frame
    frame.setJMenuBar(fileMenu.menuBar);
    frame.setJMenuBar(editcloseMenu.menuBar);

    // text area properties
    textArea.setBackground(Color.darkGray);
    textArea.setForeground(Color.white);
    
    // title of frame
    frame.setTitle("TextEditor");

    // Initialize panel and dimensions
    JPanel panel = new JPanel();
    panel.setBorder(new EmptyBorder(5, 5, 5, 5));
    panel.setLayout(new BorderLayout(0, 0));

    // add text area to panel	
    panel.add(textArea,BorderLayout.CENTER);

    // Initialize scroll pane
    JScrollPane scrollPane = new JScrollPane(textArea, 
    		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    // add scroll pane to panel
    panel.add(scrollPane);
    
    // add panel to frame
    frame.add(panel);
    
    // Initialize frame dimensions
    frame.setBounds(150, 150, 400, 400);
    frame.setVisible(true);
    frame.setLayout(null);
    }

    public static void main(String[] args) {
    	
        TextEditor1 textEditor = new TextEditor1();
        }
    }







