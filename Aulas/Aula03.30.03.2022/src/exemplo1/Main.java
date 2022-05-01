package exemplo1;

public class Main {

	public static void main(String[] args) {
		Thread minhaThread = Thread.currentThread(); //Thread atual
		System.out.println("Nome da thread: " + minhaThread.getName());
		System.out.println("Thread.toString(): " + minhaThread);

	}

}
