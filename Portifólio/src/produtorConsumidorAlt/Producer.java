package produtorConsumidorAlt;

public class Producer implements Runnable{
    Buffer buffer;

    Producer(Buffer buffer)
    {
        this.buffer = buffer;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 5; i++) {
            try {
                // Antes do produtor produzir um item
                // Adquire a permissão do semáforo
                buffer.getProducerPermission();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Produtor produz item
            buffer.setItem(i);
            System.out.println("Produtor produziu o item : " + buffer.getItem());
            try {
                // Depois do produtor produzir um item
                // libera o semáforo do consumidor
                buffer.setConsumerPermission();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

    }
}
