package exemplo4;

//Usando o .join() e estendendo a classe Thread
public class Main {
	
	public static void main(String[] args) throws InterruptedException { //para usar o join, precisa colocar a exceção
		
		class Threading extends Thread{
			public void run() {
				System.out.println("Aqui quem fala é a " + Thread.currentThread().getName());
			}
		}
		
		Threading t1 = new Threading();
		Threading t2 = new Threading();
		
		t1.start();
		t1.join();
		
		t2.start();
		t2.join();
		
		System.out.println("Agora estamos na: " + Thread.currentThread().getName());	

	}
}
