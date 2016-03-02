package main;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import domaine.CheckSystemTime;
import domaine.PerformSystemCheck;

public class Main2 {

	public static void main(String[] args) {

		addThreadsToPool();
	}

	public static void addThreadsToPool(){

		ScheduledThreadPoolExecutor eventPool = new ScheduledThreadPoolExecutor(20); 
		//20 est le nombre de threads que peut gerer le thread pool

		//ajout des threads
		eventPool.scheduleAtFixedRate(new CheckSystemTime(), 0, 2, TimeUnit.SECONDS);
		eventPool.scheduleAtFixedRate(new PerformSystemCheck("Mail"), 5, 5, TimeUnit.SECONDS);
		eventPool.scheduleAtFixedRate(new PerformSystemCheck("Calendar"), 10, 10, TimeUnit.SECONDS);

		//affiche le nombre de threads actifs
		System.out.println("Number of Threads : " + Thread.activeCount());

		//lister threads actifs
		Thread[] listOfThreads = new Thread[Thread.activeCount()];
		Thread.enumerate(listOfThreads);
		for (Thread i : listOfThreads){
			System.out.println(i.getName());
		}

		//definir priorite
		listOfThreads[1].setPriority(4);

		//lister priorites
		for (Thread i : listOfThreads){
			System.out.println(i.getPriority());
		}

	}
}
