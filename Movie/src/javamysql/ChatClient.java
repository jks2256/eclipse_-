package javamysql;


import java.awt.BorderLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

import java.io.BufferedReader;

import java.io.BufferedWriter;

import java.io.IOException;

import java.io.InputStreamReader;

import java.io.OutputStreamWriter;

import java.net.Socket;

import java.net.UnknownHostException;



import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JScrollPane;

import javax.swing.JTextArea;

import javax.swing.JTextField;



//������â�� �����ڰ� ������� ������ ����Ʈ�� BorderLayout�� ����ȴ�.

public class ChatClient extends JFrame implements ActionListener,KeyListener{

	

	JButton btn;

	JTextArea area;

	JScrollPane scoll;

	JTextField input;

	Socket client;	//��ȭ�� ����

	String ip = "203.252.218.95";

	int port = 7777;



	BufferedReader bufferR;

	BufferedWriter bufferW;

	
	
	

	public ChatClient() {

		btn = new JButton("����");

		area = new JTextArea();

		scoll = new JScrollPane(area);

		input = new  JTextField();

		

		btn.addActionListener(this);

		input.addKeyListener(this);

		connect();

		this.add(btn, BorderLayout.NORTH);

		this.add(scoll);

		this.add(input,BorderLayout.SOUTH);

		setSize(300,400);

		setVisible(true);

	}

	//ä�ü����� ����

	public void connect(){

		try {

			client = new Socket(ip, port);
			
			if(client != null) {
				System.out.println(client.toString());
			}

			//����� �������κ��� ��ȭ�� ���� ��Ʈ���� ����

			bufferR = new BufferedReader(new InputStreamReader(client.getInputStream()));

			bufferW = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

			

		} catch (UnknownHostException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	//������ �޽��� ������

	public void listen(){

		String msg="";

		

		try {

			msg = bufferR.readLine();

			area.append(msg+"\n");

			

		} catch (IOException e) {

			e.printStackTrace();

		}

		

		

		

	}

	//�������� �޽��� û���ϱ�

	public void send(){

		String v = input.getText();

		try {

			bufferW.write(v+"\n");

			bufferW.flush();

		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

	

	public void actionPerformed(ActionEvent e) {

		System.out.println("Ŭ��");

		connect();

	}

	public static void main(String[] args) {

		

		new ChatClient();

	}

	

	//Ű�� ������ ������

	public void keyPressed(KeyEvent e) {

		

	}

	//Ű�� ������ ������

	public void keyReleased(KeyEvent e) {

		System.out.println("Ű:"+e.getKeyCode());

		if(e.getKeyCode()==KeyEvent.VK_ENTER){

			System.out.println("����");

			send();

			input.setText("");

			listen();

			

			

		}

		

	}

	//Ÿ�����ϸ�

	public void keyTyped(KeyEvent e) {

		

	}



}

