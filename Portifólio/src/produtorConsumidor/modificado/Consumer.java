package produtorConsumidor.modificado;


public class Consumer implements Runnable{
    Buffer buffer;

    Consumer(Buffer buffer){
        this.buffer = buffer;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {

            try{
                // Antes do consumidor consumir um item
                // Adquire uma permissão do semáforo
                buffer.getConsumerPermission();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
            // Consumidor consome item
            System.out.println("Consumidor consumiu o item: " + buffer.getItem());
            try{
                // Despois do consumidor consumir um item
                // libera o semáforo do produtor
                buffer.setProducerPermission();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

}
