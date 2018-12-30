package com.java.Friday;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class helper extends JFrame implements ActionListener{

	JTextArea textArea;
	JTextField textField;
	JPanel p1,p2;
	JScrollPane scroll;
	JLabel label;
	JButton b;
	DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	public void bot() {
		JFrame frame = new JFrame();
		//frame.setResizable(false);
		frame.setLayout(null);
		frame.setSize(400, 400);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setTitle("FRIDAY");

		p1=new JPanel();
		p1.setBounds(0,0,400,300);
		p1.setLayout(new FlowLayout());
		p2=new JPanel();
		p2.setBounds(0,300,400,100);
		p2.setLayout(new FlowLayout());
		frame.add(p1);
		frame.add(p2);

		textArea=new JTextArea(18,32);
		textArea.setEditable(false);
		p1.add(textArea);
		scroll=new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		p1.add(scroll);
		label=new JLabel("Server:");
		p2.add(label);
		textField=new JTextField("",20);
		textField.addActionListener(this);
		p2.add(textField);
		b=new JButton("Submit");
		b.addActionListener(this);
		p2.add(b);
	}
	public void actionPerformed(ActionEvent arg0) {
		String body = textField.getText();
		textArea.append("User --> "+body+"\n");
		textArea.setText(textArea.getText()+dateFormat.format(new Date())+"\n");
		textField.setText("");
	}

}
