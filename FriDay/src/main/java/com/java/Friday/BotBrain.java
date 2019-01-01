package com.java.Friday;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.History;
import org.alicebot.ab.MagicBooleans;
import org.alicebot.ab.MagicStrings;

public class BotBrain {

	private static final boolean TRACE_MODE = false;
	static String botName = "super";
	DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


	public void brain(JTextField textField, JTextArea textArea, Chat chat, Bot bot) {

		String response = "";
		String body = "";
		try {
			body = setUserResponse(textField, textArea);

			System.out.print("Tapu : " +body+ "\n");
			if ((body == null) || (body.length() < 1))
				body = MagicStrings.null_input;
			if (body.equals("exit")) {
				System.exit(0);
			} else if (body.equals("wq")) {
				bot.writeQuit();
				System.exit(0);
			} else {
				String request = body;
				if (MagicBooleans.trace_mode)
					System.out.println("STATE=" + request + ":THAT=" + ((History) chat.thatHistory.get(0)).get(0) + ":TOPIC=" + chat.predicates.get("topic"));
				response = chat.multisentenceRespond(request);
				while (response.contains("&lt;"))
					response = response.replace("&lt;", "<");
				while (response.contains("&gt;"))
					response = response.replace("&gt;", ">");
				System.out.println("FriDay : " + response);
				setFridayResponse(textArea, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String setUserResponse(JTextField textField, JTextArea textArea) {
		String body = textField.getText();
		textArea.append("Tapu --> "+body+"\n");
		textArea.setText(textArea.getText()+dateFormat.format(new Date())+"\n");
		textField.setText("");
		return body;
	}

	private void setFridayResponse(JTextArea textArea, String response) {
		textArea.append("FriDay --> "+response+"\n");
		textArea.setText(textArea.getText()+dateFormat.format(new Date())+"\n");
	}
}
