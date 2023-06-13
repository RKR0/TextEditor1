package TextEditor1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class FileMenu implements ActionListener {

	
	JTextArea textArea;
    JMenuBar menuBar;
    JMenu file;
    JMenuItem newFile,openFile,saveFile;
	
    FileMenu(){
	 // Initialize a textArea
	 textArea = new JTextArea();

	 // Initialize a menuBar
	 menuBar = new JMenuBar();

	 // Initialize a frame item
	 file = new JMenu("File");
	    
	 // Initialize a file items
	 newFile = new JMenuItem("New Window");
	 openFile = new JMenuItem("Open File");
	 saveFile = new JMenuItem("Save File");
	    
	 //add action listeners to file menu items
	 newFile.addActionListener(this);
	 openFile.addActionListener(this);
	 saveFile.addActionListener(this);
	    
	 // add menu items to file Jmenu
	 file.add(newFile);
	 file.add(openFile);
	 file.add(saveFile);
	    
	 // add Jmenu to menu bar
	 menuBar.add(file);

	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {

	// if openFile option clicks
	if(actionEvent.getSource()==openFile){
       // Initialize file picker
       JFileChooser fileChooser = new JFileChooser("C:");
       // get choose option to file chooser
       int chooseoption  = fileChooser.showOpenDialog(null);
       // check if we clicked on open button
         if(chooseoption==JFileChooser.APPROVE_OPTION){
            //from file chooser to get a file
            File file = fileChooser.getSelectedFile();
            // from file to get a file path 
            String filepath = file.getPath();
            try{
            	//Initialize file reader
                FileReader fileReader = new FileReader(filepath);
                //Initialize buffer reader
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                //Intermediate for current line; output for complete content of file
                String interMedium = "", output = "";
                //Read line by line
                while((interMedium=bufferedReader.readLine())!=null){
                    output+=interMedium+"\n";
                }
                bufferedReader.close();
                //set text area with the content of the file
                textArea.setText(output);
            	}
            catch(IOException fileNotFoundExpection){
                fileNotFoundExpection.printStackTrace();
            	}
          }
        }
        
     // if saveFile option clicks
     if(actionEvent.getSource()==saveFile){
        // Initialize file picker
        JFileChooser fileChooser = new JFileChooser("C:");
        // get choose option to file chooser
        int chooseoption  = fileChooser.showSaveDialog(null);
        // check if we clicked on save button
        if(chooseoption==JFileChooser.APPROVE_OPTION){
           //Create a new file with directory's path
           File file = new File(fileChooser.getSelectedFile().getAbsolutePath()+".txt");
            try{
            	//Initialize file writer
                FileWriter fileWriter = new FileWriter(file);

                //Initialize buffer writer
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
               
                //write text area to file
                textArea.write(bufferedWriter);
                bufferedWriter.close();
            	}
            catch(IOException ioException){
              ioException.printStackTrace();
            	}
         }
     }
    // if newFile option clicks
    if(actionEvent.getSource()==newFile){
      TextEditor1 newtextEditor = new TextEditor1();
    }
		
}
}
