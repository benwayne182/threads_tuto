package domaine;

import java.util.concurrent.locks.ReentrantLock;

public class PerformSystemCheck implements Runnable{
	private String checkWhat;
	
	ReentrantLock lock = new ReentrantLock();
	
	//constructeur
	public PerformSystemCheck(String checkWhat){
		this.checkWhat = checkWhat;
	}
	
	public void run(){
		lock.lock();
		//empeche l'acces par plusieurs threads
		//ajouter l'attribut synchronized a la methode permet le meme resultat
		
		System.out.println("Checking " + this.checkWhat);
		
		lock.unlock();
		//rend la methode a nouveau accessible par d'autres threads
	}
}
