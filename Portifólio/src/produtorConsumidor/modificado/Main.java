package produtorConsumidor.modificado;
/*
* Modificado da solução em: https://acervolima.com/solucao-produtor-consumidor-usando-semaforos-em-java-conjunto-2/
* */
public class Main {
    public static void main(String[] args) {
        // criando a fila de buffer
        Buffer buffer = new Buffer();

        // iniciando a thread do consumidor
        new Consumer(buffer);

        // iniciando a thread do produtor
        new Producer(buffer);
    }
}
