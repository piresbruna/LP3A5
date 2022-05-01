package exemplo3;

//Precisa da classe Thread junto com a interface Runnable
public class Main implements Runnable{
	
	@Override
	public void run() {
		System.out.println("Aqui quem fala é a " + Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		
		System.out.println("Estamos na: " + Thread.currentThread().getName());
		Runnable runnable = new Main(); //Instancia o runnable
		Thread t = new Thread(runnable); //Cria uma nova thread
		t.start(); //Inicia a nova Thread

	}

}
