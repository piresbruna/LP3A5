package produtorConsumidor.fonte;
/*
* Solução encontrada em: https://acervolima.com/solucao-produtor-consumidor-usando-semaforos-em-java-conjunto-2/
* Q : a fila que você está tentando sincronizar
* Produtor: o objeto encadeado que está produzindo entradas na fila
* Consumidor: o objeto encadeado que está consumindo entradas da fila
* PC: a classe de driver que cria o único Q, Produtor e Consumidor.
* */
public class PC {
    public static void main(String args[])
    {
        // creating buffer queue
        Q q = new Q();

        // starting consumer thread
        new Consumer(q);

        // starting producer thread
        new Producer(q);
    }
}
