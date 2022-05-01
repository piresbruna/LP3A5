package produtorConsumidor.modificado;

import java.util.concurrent.Semaphore;

public class Buffer {
    int item; //item do buffer

    //semáforo que controla as permissões do consumidor, inicia
    //com 0 permissões para asegurar que um item será produzido primeiro
    static Semaphore semaforoConsumidor = new Semaphore(0);

    //semáforo que controla as permissões do produtor
    static Semaphore semaforoProdutor = new Semaphore(1);

    //pegar item
    public int getItem() {
        return item;
    }

    //colocar item
    public void setItem(int item) {
        this.item = item;
    }

    //adquirir a permissão para o produtor
    public void getProducerPermission() throws InterruptedException{
        semaforoProdutor.acquire();
    }

    //liberar o produtor
    public void setProducerPermission() throws InterruptedException{
        semaforoProdutor.release();
    }

    //adquirir permissão para o consumidor
    public void getConsumerPermission() throws InterruptedException{
        semaforoConsumidor.acquire();
    }

    //liberar o consumidor
    public void setConsumerPermission() throws InterruptedException{
        semaforoConsumidor.release();
    }
}
