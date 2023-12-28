package p1;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class LoginPage implements ActionListener
{
    JFrame f;
    JLabel un, ps;
    JTextField uname;
    JPasswordField p;
    JButton lg, ext;
    LoginPage()
    {
    	f=new JFrame("Login Page");
    	f.getContentPane().setBackground(Color.orange);
    	f.setLayout(null);
    	f.setSize(700, 500);
    	
    	un = new JLabel("Username");
    	un.setBounds(100, 100, 100, 70);
    	f.add(un);
    	
    	uname=new JTextField();
    	uname.setBackground(Color.CYAN);
    	uname.setBounds(250, 100, 100, 60);
    	f.add(uname);
    	
    	ps=new JLabel("Password");
    	ps.setBounds(100, 250, 100, 70);
    	f.add(ps);
    	
    	p=new JPasswordField();
    	p.setBackground(Color.GREEN);
    	p.setBounds(250, 250, 100, 60);
    	f.add(p);
    	
    	lg= new JButton("Login");
    	lg.setBounds(170, 350, 100, 50);
    	lg.addActionListener(this);
    	f.add(lg);
    	
    	ext=new JButton("EXIT");
    	ext.setBounds(320, 350, 100, 50);
    	ext.addActionListener(this);
    	f.add(ext);
    	
    	f.setVisible(true);
    }
	public static void main(String[] args) {
		new LoginPage();

	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==lg)
		{
			String name, pass;
			name=uname.getText();
			pass=new String(p.getPassword());
			if(name.equals("klu")==true && pass.equals("123")==true)
			{
				JOptionPane.showMessageDialog(f, "Username & password is correct");
				f.dispose();
				new Main().initUI();
			}
			else
			{
				JOptionPane.showMessageDialog(f, "Invalid username & password is ");
			}
		}
		else
		{
			f.dispose();
		}
	}
}