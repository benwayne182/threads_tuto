package main;

import domaine.GetMail;
import domaine.GetTime;


public class Main {

	public static void main(String[] args) {

		Thread getTime = new GetTime();
		Runnable getMail = new GetMail(10);
		Runnable getMailAgain = new GetMail(20);
		
		getTime.start();
		new Thread(getMail).start();
		new Thread(getMailAgain).start();
		
	}

}
