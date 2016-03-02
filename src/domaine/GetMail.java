package domaine;

public class GetMail implements Runnable{

	private int startTime;
	
	//constructeur
	public GetMail(int startTime){
		this.startTime = startTime;
	}
	
	public void run(){
		try {
			Thread.sleep(startTime * 1000);
		} catch (InterruptedException e) {
		}
		System.out.println("Check Mail");
	}
}
