package aula07;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ExemploStream {

	public static void main(String[] args) {
		//ExemploStream.criandoStreams();
		//ExemploStream.criandoStreamsComArray();
		//ExemploStream.criandoStreamsComStreamOf();
		//ExemploStream.criandoStreamsParaIntervalo();
		//ExemploStream.criandoStreamsComInterate();
		//ExemploStream.criandoStreamJuntoDePattern();
		//ExemploStream.streamsComOperacoesIntermediarias();
		//ExemploStream.streamsComOperacoesTerminais();
		//ExemploStream.exemploReduce();
		//ExemploStream.exemploInterfacesFuncionais();
		ExemploStream.exemploPredicate();
		ExemploStream.exemploFunction();

	}
	
	private static void criandoStreams() {
		//A interface collection possui o método stream e parallelStream
		final List<String> lista = Arrays.asList("amor", "bola", "casa", "dado");
		
		//Criação de stream a partir de uma lista
		//Cada item da lista é impresso na tela
		System.out.println("\n>>Stream a partir de uma lista com .stream(): "); //sai na ordem
		lista.stream().forEach(System.out::println); //sintaxe sugar de lista.stream().forEach( palavra -> System.out.println(palavra));
		System.out.println("\n>>Stream a partir de uma lista com .parallelStream(): ");
		lista.parallelStream().forEach(System.out::println);//não necessariamente segue a ordem
	}
	
	private static void criandoStreamsComArray() {
		//Também é possível criar streams a partir de arrays
		String[] nomes = new String[] {"Ana", "Beatriz", "Clara", "Diana", "Eliane"};
		System.out.println("\n>>Stream a partir de array usando a classe java.util.Arrays");
		Arrays.stream(nomes).forEach(System.out::println);
		
		System.out.println("\n>>Stream acima com parallel: ");
		Arrays.stream(nomes).parallel().forEach(System.out::println);
	}
	
	private static void criandoStreamsComStreamOf() {
		//É possível criar um Stream também com a própria classe Stream usando o método of
		System.out.println("\n>>Ao usar o método Stream.of podem ser passados Object");
		Stream.of("casa", 1, "teste").forEach(System.out::println);
	}
	
	private static void criandoStreamsParaIntervalo() {
		//Para números é possível gerar um intervalo 
		System.out.println("\n>>Criando um stream com o método IntStream.range");
		IntStream.range(10, 15).forEach(System.out::println); 
		//caso deseje incluir o último número pode usar o rangeClosed
		System.out.println("\n>>Criando um stream com o método IntStream.rangeClosed");
		IntStream.rangeClosed(10, 15).forEach(System.out::println); 
	}
	
	private static void criandoStreamsComInterate() {
		//CUIDADO, não tem fim, é preciso limitá-lo => .limit(<quantidade de iterações>)
		//Outra forma de criar um stream é o método iterate.
		//Inicia-se com uma semente e uma função que define como ela será transformada
		System.out.println("\n>>Criando um stream com o método Stream.iterate");
		Stream.iterate(true, valor -> !valor).limit(4).forEach(System.out::println); 
	}
	
	private static void criandoStreamJuntoDePattern() {
		System.out.println("\n>>Exemplo com Pattern, quebra o texto onde há espaço:");
		Pattern padrao = Pattern.compile(" "); //Informa o que é padrão, o que se repete, que deve ser buscado
		 
		padrao.splitAsStream("esse eh um.exemplo de pattern").forEach(System.out::println);	 
	}
	
	private static void streamsComOperacoesIntermediarias() {
		String[] nomes = new String[] {"Ana", "Beatriz", "Clara", "Diana", "Eliane"};
		System.out.println("\n>>Stream com .skip(1) e .limit(2):");
		Arrays.stream(nomes).skip(1).limit(2).forEach(System.out::println);
		System.out.println("\n>>Stream com .filter(nome -> nome.contains(\"B\"):");
		//.filter(nome -> nome.contains("B") busca qual contém a letra B maiúscula
		Arrays.stream(nomes).filter(nome -> nome.contains("B")).forEach(System.out::println);
		System.out.println("\n>>Stream com .filter + .map(String::toUpperCase):");
		//.map(String::toUpperCase) transforma o resultado em letras maiúsculas
		Arrays.stream(nomes).filter(nome -> nome.contains("B")).map(String::toUpperCase).forEach(System.out::println);
		System.out.println("\n>>Stream com .map(nome -> nome + \" \" + nome.length()):");
		//.map(String::toUpperCase) transforma o resultado em letras maiúsculas
		Arrays.stream(nomes).map(nome -> nome + " " + nome.length()).forEach(System.out::println);
		
	}
	
	private static void streamsComOperacoesTerminais() {
		String[] nomes = new String[] {"Ana", "Beatriz", "Clara", "Diana", "Eliane"};
		final List<String> listaColetada = 
				Arrays
					.stream(nomes)
					.map(nome -> nome + " " + nome.length())
					.collect(Collectors.toList());
		System.out.println("\nAgrupamento para uma lista após a transformação: \n" + listaColetada);
		
		Map<Integer, List<String>> mapColetado = 
				Arrays
					.stream(nomes)
					.collect(Collectors.groupingBy(nome -> nome.length()));
		System.out.println("\nMapeamento com agrupamento por tamanho: \n" + mapColetado);
		
	}
	
	private static void exemploReduce() {
		
		//Exemplos com BinaryOperator
		final OptionalInt resultadoSoma = IntStream.rangeClosed(1, 10).reduce( (v1, v2) -> v1+v2  );
		System.out.println(resultadoSoma.getAsInt());
		
		
		final Optional<String> resultadoConcatenacao =
				Stream.of("Ana", "Beatriz", "Clara", "Diana", "Eliane")
				.reduce( (v1, v2) -> v1.concat(v2) );
		System.out.println(resultadoConcatenacao.get());
		
		
		//Exemplos com valor de identidade e BinaryOperator
		final String resultadoConcatenacao2 =
				Stream.of("Ana", "Beatriz", "Clara", "Diana", "Eliane", "")
				.reduce("", (v1, v2) -> v1.concat(v2) );
		System.out.println(resultadoConcatenacao2);
		
		try {
			final Optional<String>  resultadoConcatenacao3 =
					Arrays.stream(new String[] {})
					.reduce((v1, v2) -> v1.concat(v2) );
			System.out.println(resultadoConcatenacao3.get());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println();
		final String  resultadoConcatenacao4 =
				Arrays.stream(new String[] {})
				.reduce("",(v1, v2) -> v1.concat(v2) );
		System.out.println("RESULTADO COM IDENTIDADE =[" + resultadoConcatenacao4 + "]");

	}
	
	private static void exemploInterfacesFuncionais() {
		System.out.println("\n>>Números aleatórios \"randômicos\" com limite de 5 iterações:");
		Stream.generate( () -> new Random().nextInt()).limit(5).forEach((v) -> System.out.println(v));
		//Random é Supplier; forEach é Consumer
		
		System.out.println("\n>>Agrupa entre nomes com estensão maior e menor que 5:");
		//forEach do Map aceita um BiConsumer que vai receber a chave e o valor como parâmetros
		Map<Boolean, List<String>> mapColetado = 
				Stream.of("Ana", "Beatriz", "Clara", "Diana", "Eliane")
					.collect(Collectors.groupingBy(nome -> nome.length() > 5));
		mapColetado.forEach((c,v) -> System.out.println(c + ": " + v));
		
	}
	/**
	 * Predicate é uma interface funcional que possui um método test que recebe 
	 * um valor e retorna um boolean
	 * 
	 * Pode ser visto em ação na função filter de uma List
	 */
	private static void exemploPredicate() {
		final List<String> frutas = Arrays.asList("ameixa", "jaca", "abacate", "caqui", "banana", "abacaxi");
		
		System.out.println("\n>>Frutas da lista  que começam com a letra \"a\": ");
		frutas.stream().filter(( fruta ) -> fruta.startsWith("a") ).forEach(System.out::println);
		
		System.out.println("\n>>Frutas da lista  que começam com a letra \"a\" em ordem: ");
		frutas.stream().filter(( fruta ) -> fruta.startsWith("a") ).sorted().forEach(System.out::println);
	}
	
	/**
	 * Function é uma interface funcional que contém um método apply
	 * que recebe um valor, aplica a função e devolve um resultado 
	 */
	private static void exemploFunction() {
		final List<String> frutas = Arrays.asList("ameixa", "jaca", "abacate", "caqui", "banana", "abacaxi");
		
		System.out.println("\n>>Frutas da lista mais \"s\": ");
		frutas.stream().map((fruta) -> fruta + "s" ).forEach(System.out::println);
		
		//BiFunction é uma function com dois valores de entrada
		//UnaryOperator é uma uma function que obrigatoriamente recebe e devolve um valor do mesmo tipo
	}
	
	/**
	 * Supplier : fornecedor - não recebe nada e retorna um valor
	 * Consumer : consumidor - recebe um valor e não retorna nada
	 */
	/*private void exemploSupplierConsumer() {
		Stream
		.generate( () -> new Random().nextInt() ) // a função generate recebe um supplier
		//Supplier : interface funcional que contém um método get sem argumentos
		// Ou seja, não recebe input, mas devolve um output
		.limit(10) //limita a 10 valores
		.forEach( (e) -> System.out.println(e) ); // a função forEach recebe um consumer
		//Consumer : interface funcional que contém um método accept com um parâmetro de entrada e void na saída
		//Consumer : oposto do supplier, não retorna nada, mas recebe um valor com o qual faz alguma ação.
	}*/
	
	/**
	 * BiConsumer, interface funcional que contém um método accept com dois valores de etrada e nenhum de saída.
	 * ou seja, recebe dois valores, realiza uma operação com eles, mas não retorna nada.
	 * O BiConsumer pode ser testado mais facilmente com um Map
	 */
	/*private static void exemploBiConsumer() {
		
		final HashMap< String, String> nomeSobrenome = new HashMap<>();
		nomeSobrenome.put("Diego", "Chaves");
		nomeSobrenome.put("João", "Ninguém");
		
        final BiConsumer<String, String> merge = (nome, sobrenome) ->
        {
        	System.out.print("\n" + nome + " " + sobrenome);
        };
        
        //forEach do Map aceita um BiConsumer que vai receber a chave e o valor como parâmetros
        nomeSobrenome.forEach(merge);
        
        System.out.println("\n\nExemplo com andThen");
        //Exemplo
        nomeSobrenome.forEach(merge.andThen(( a, b) -> System.out.print( " - " + (a + " " + b).length() ) ) );
	}*/
	
}
