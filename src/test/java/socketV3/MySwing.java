package socketV3;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MySwing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame = new JFrame("ob工具");
		frame.setBounds(500,200,500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		JTextArea textArea = new JTextArea(6,20);
		panel.add(textArea);
		JTextField textField = new JTextField(20);
		
		panel.add(textField);
		JButton button = new JButton("发送");
		button.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				String strField = textField.getText();
				String strText = textArea.getText();
				String str = null;
				if(!strText.isEmpty()){				
					str = strText +"\r\n"+strField;
				}else{
					str = strField;
				}
				System.out.println(str);
				textArea.setText(str);
				//System.out.println("发送消息");
			}
		});
		panel.add(button);
		panel.setVisible(true);
		frame.setContentPane(panel);;
		frame.setVisible(true);
	}

}
