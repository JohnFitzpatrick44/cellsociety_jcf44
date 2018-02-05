package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import XML.DataHolder;
import javax.swing.JComboBox;

public class FileComboBox implements ActionListener {

	
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JComboBox cb = (JComboBox)e.getSource();
		File selectedFile = (File)cb.getSelectedItem();
		updateFile(selectedFile);	
	}
	
	//change the file
	public void updateFile(File chosenFile) {
		DataHolder.INPUTFILE = chosenFile;
	}
	
	}

