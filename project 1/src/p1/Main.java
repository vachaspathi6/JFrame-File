package p1;
import java.awt.*;
import java.io.*;
import javax.swing.*;
public class Main {
  JTextArea textArea, textarea;
  JButton save, open, delete, add;
  void initUI() {
    JFrame frame = new JFrame(Main.class.getSimpleName());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    textArea = new JTextArea(100, 100);
    textArea.setBackground(Color.YELLOW);
    textArea.setForeground(Color.RED);
    save = new JButton("Save to file");
    save.addActionListener(e -> saveToFile());
    open = new JButton("Open from file");
    open.addActionListener(e -> {
		try {
			OpenFromfile();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	});
    delete = new JButton("Delete a file");
    delete.addActionListener(e -> DeleteAfile());
    add = new JButton("Add new Data");
    add.addActionListener(e -> AddNewData());
    frame.add(new JScrollPane(textArea));
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(save);
    buttonPanel.add(add);
    buttonPanel.add(open);
    buttonPanel.add(delete);
    frame.add(buttonPanel, BorderLayout.BEFORE_FIRST_LINE);
    frame.setSize(500, 400);
    
    frame.setVisible(true);
  }

    protected void OpenFromfile() throws Exception {
    	JFileChooser fileChooser = new JFileChooser();
        int a = fileChooser.showOpenDialog(null);

        if (a == JFileChooser.APPROVE_OPTION) {
          File fileToOpen = fileChooser.getSelectedFile();
          Desktop.getDesktop().open(fileToOpen);
        }
    }
    
    protected void DeleteAfile()
    {
    	JFileChooser chooser = new JFileChooser();
    	chooser.showOpenDialog(null);
    	File f = chooser.getSelectedFile();
    	if (f == null) {
            return;
          }
    	else {
    	    f.delete();
    	    JOptionPane.showConfirmDialog(chooser,"Are you sure want to delete this file?","Confirm",JOptionPane.YES_NO_OPTION);
    	    JOptionPane.showMessageDialog(chooser, "File is Successfully Deleted");
    	}
    }
    
    protected void AddNewData()
    {
    	textArea.setText(null);
    }
    
  protected void saveToFile() {
    JFileChooser fileChooser = new JFileChooser();
    int retval = fileChooser.showSaveDialog(save);
    if (retval == JFileChooser.APPROVE_OPTION) {
      File file = fileChooser.getSelectedFile();
      if (file == null) {
        return;
      }
      if (!file.getName().toLowerCase().endsWith(".txt")) {
        file = new File(file.getParentFile(), file.getName() + ".txt");
      }
      try {
        textArea.write(new OutputStreamWriter(new FileOutputStream(file),
            "utf-8"));
        Desktop.getDesktop().open(file);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}