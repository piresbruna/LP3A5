package exemplo2;

//Criar uma nova thread requer a interface Runnable
public class Main implements Runnable{

	@Override
	public void run() {
		System.out.println("Aqui quem fala é a " + Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		
		System.out.println("Estamos na: " + Thread.currentThread().getName());
		Runnable runnable = new Main();
		runnable.run();

	}

}
