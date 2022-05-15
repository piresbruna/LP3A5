import java.util.Arrays;
import java.util.stream.Stream;

public class ExemploExercicio {
    public static void main(String[] args) {
        //Exemplos de uso de .allMatch e .anyMatch da API Stream
        //Ambos retornam um boolean
        String[] nomes = new String[] {"Ana", "Beatriz", "Clara", "Diana", "Eliane", "Fernandas"};
        String[] nomes2 = new String[] {"Ana", "Bianca", "Raj", "Day", "Eli", "Fernandas"};
        System.out.println("\nLista de nomes 1:");
        allMatch(nomes);
        anyMatch(nomes);
        System.out.println("\nLista de nomes 2:");
        anyMatch(nomes2);

    }

    public static void allMatch(String[] lista) {
        Boolean isOk = Arrays.stream(lista).allMatch(n -> n.length() > 5);
        if(isOk) {
            System.out.println("\nTodos os nomes possuem tamanho maior do que 5.");
            System.out.println(lista);
        } else {
            System.out.println("\nNem todos os nomes possuem tamanho maior do que 5.");
        }
    }

    public static void anyMatch(String[] lista) {
        Boolean isOk = Arrays.stream(lista).anyMatch(n -> n.length() < 4);
        if(isOk) {
            System.out.println("\nAlgum nome possui tamanho menor do que 4:");
            Stream.of(lista).filter(n -> n.length() < 4).forEach(System.out::println);
        } else {
            System.out.println("\nNenhum nome possui tamanho menor do que 4.\n");
        }
    }
}
