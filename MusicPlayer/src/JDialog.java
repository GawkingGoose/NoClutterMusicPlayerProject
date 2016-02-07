
import java.awt.Component;
import java.awt.Dimension;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JDialog {

	private static JFrame parentFrame = new JFrame();
	
	public static void openMessageDialog(Component parent, String message){
		if(parent == null){
			JOptionPane.showMessageDialog(parentFrame, message);
		}else{
			JOptionPane.showMessageDialog(parent, message);
		}
	}
	
	public static String openInputDialog(String message){
		return JOptionPane.showInputDialog(message);
	}
	
	public static int openConfirmDialog(Component parent, String message){
		if(parent == null){
			return JOptionPane.showConfirmDialog(parentFrame, message);
		}else{
			return JOptionPane.showConfirmDialog(parent, message);
		}
	}
	
	public static File[] openBrowseFileSelectDialog(){
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setMultiSelectionEnabled(true);
        int returnValue = fileChooser.showOpenDialog(parentFrame);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
          return fileChooser.getSelectedFiles();
        }
		return new File[0];
	}
	
	public static int openOptionDialog(String title, String message, String[] options){
	    return JOptionPane.showOptionDialog(parentFrame,title,message,
	        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
	        options[0]);
	}
	
	public static void showTextArea(String title, String message){
		JTextArea textArea = new JTextArea(message);
		JScrollPane scrollPane = new JScrollPane(textArea);  
		textArea.setLineWrap(true);  
		textArea.setWrapStyleWord(true); 
		scrollPane.setPreferredSize( new Dimension( 700, 400 ) );
		JOptionPane.showMessageDialog(parentFrame, scrollPane, title,  
		                                       JOptionPane.INFORMATION_MESSAGE);
	}
}
