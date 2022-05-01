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
		//A interface collection possui o m�todo stream e parallelStream
		final List<String> lista = Arrays.asList("amor", "bola", "casa", "dado");
		
		//Cria��o de stream a partir de uma lista
		//Cada item da lista � impresso na tela
		System.out.println("\n>>Stream a partir de uma lista com .stream(): "); //sai na ordem
		lista.stream().forEach(System.out::println); //sintaxe sugar de lista.stream().forEach( palavra -> System.out.println(palavra));
		System.out.println("\n>>Stream a partir de uma lista com .parallelStream(): ");
		lista.parallelStream().forEach(System.out::println);//n�o necessariamente segue a ordem
	}
	
	private static void criandoStreamsComArray() {
		//Tamb�m � poss�vel criar streams a partir de arrays
		String[] nomes = new String[] {"Ana", "Beatriz", "Clara", "Diana", "Eliane"};
		System.out.println("\n>>Stream a partir de array usando a classe java.util.Arrays");
		Arrays.stream(nomes).forEach(System.out::println);
		
		System.out.println("\n>>Stream acima com parallel: ");
		Arrays.stream(nomes).parallel().forEach(System.out::println);
	}
	
	private static void criandoStreamsComStreamOf() {
		//� poss�vel criar um Stream tamb�m com a pr�pria classe Stream usando o m�todo of
		System.out.println("\n>>Ao usar o m�todo Stream.of podem ser passados Object");
		Stream.of("casa", 1, "teste").forEach(System.out::println);
	}
	
	private static void criandoStreamsParaIntervalo() {
		//Para n�meros � poss�vel gerar um intervalo 
		System.out.println("\n>>Criando um stream com o m�todo IntStream.range");
		IntStream.range(10, 15).forEach(System.out::println); 
		//caso deseje incluir o �ltimo n�mero pode usar o rangeClosed
		System.out.println("\n>>Criando um stream com o m�todo IntStream.rangeClosed");
		IntStream.rangeClosed(10, 15).forEach(System.out::println); 
	}
	
	private static void criandoStreamsComInterate() {
		//CUIDADO, n�o tem fim, � preciso limit�-lo => .limit(<quantidade de itera��es>)
		//Outra forma de criar um stream � o m�todo iterate.
		//Inicia-se com uma semente e uma fun��o que define como ela ser� transformada
		System.out.println("\n>>Criando um stream com o m�todo Stream.iterate");
		Stream.iterate(true, valor -> !valor).limit(4).forEach(System.out::println); 
	}
	
	private static void criandoStreamJuntoDePattern() {
		System.out.println("\n>>Exemplo com Pattern, quebra o texto onde h� espa�o:");
		Pattern padrao = Pattern.compile(" "); //Informa o que � padr�o, o que se repete, que deve ser buscado
		 
		padrao.splitAsStream("esse eh um.exemplo de pattern").forEach(System.out::println);	 
	}
	
	private static void streamsComOperacoesIntermediarias() {
		String[] nomes = new String[] {"Ana", "Beatriz", "Clara", "Diana", "Eliane"};
		System.out.println("\n>>Stream com .skip(1) e .limit(2):");
		Arrays.stream(nomes).skip(1).limit(2).forEach(System.out::println);
		System.out.println("\n>>Stream com .filter(nome -> nome.contains(\"B\"):");
		//.filter(nome -> nome.contains("B") busca qual cont�m a letra B mai�scula
		Arrays.stream(nomes).filter(nome -> nome.contains("B")).forEach(System.out::println);
		System.out.println("\n>>Stream com .filter + .map(String::toUpperCase):");
		//.map(String::toUpperCase) transforma o resultado em letras mai�sculas
		Arrays.stream(nomes).filter(nome -> nome.contains("B")).map(String::toUpperCase).forEach(System.out::println);
		System.out.println("\n>>Stream com .map(nome -> nome + \" \" + nome.length()):");
		//.map(String::toUpperCase) transforma o resultado em letras mai�sculas
		Arrays.stream(nomes).map(nome -> nome + " " + nome.length()).forEach(System.out::println);
		
	}
	
	private static void streamsComOperacoesTerminais() {
		String[] nomes = new String[] {"Ana", "Beatriz", "Clara", "Diana", "Eliane"};
		final List<String> listaColetada = 
				Arrays
					.stream(nomes)
					.map(nome -> nome + " " + nome.length())
					.collect(Collectors.toList());
		System.out.println("\nAgrupamento para uma lista ap�s a transforma��o: \n" + listaColetada);
		
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
		System.out.println("\n>>N�meros aleat�rios \"rand�micos\" com limite de 5 itera��es:");
		Stream.generate( () -> new Random().nextInt()).limit(5).forEach((v) -> System.out.println(v));
		//Random � Supplier; forEach � Consumer
		
		System.out.println("\n>>Agrupa entre nomes com estens�o maior e menor que 5:");
		//forEach do Map aceita um BiConsumer que vai receber a chave e o valor como par�metros
		Map<Boolean, List<String>> mapColetado = 
				Stream.of("Ana", "Beatriz", "Clara", "Diana", "Eliane")
					.collect(Collectors.groupingBy(nome -> nome.length() > 5));
		mapColetado.forEach((c,v) -> System.out.println(c + ": " + v));
		
	}
	/**
	 * Predicate � uma interface funcional que possui um m�todo test que recebe 
	 * um valor e retorna um boolean
	 * 
	 * Pode ser visto em a��o na fun��o filter de uma List
	 */
	private static void exemploPredicate() {
		final List<String> frutas = Arrays.asList("ameixa", "jaca", "abacate", "caqui", "banana", "abacaxi");
		
		System.out.println("\n>>Frutas da lista  que come�am com a letra \"a\": ");
		frutas.stream().filter(( fruta ) -> fruta.startsWith("a") ).forEach(System.out::println);
		
		System.out.println("\n>>Frutas da lista  que come�am com a letra \"a\" em ordem: ");
		frutas.stream().filter(( fruta ) -> fruta.startsWith("a") ).sorted().forEach(System.out::println);
	}
	
	/**
	 * Function � uma interface funcional que cont�m um m�todo apply
	 * que recebe um valor, aplica a fun��o e devolve um resultado 
	 */
	private static void exemploFunction() {
		final List<String> frutas = Arrays.asList("ameixa", "jaca", "abacate", "caqui", "banana", "abacaxi");
		
		System.out.println("\n>>Frutas da lista mais \"s\": ");
		frutas.stream().map((fruta) -> fruta + "s" ).forEach(System.out::println);
		
		//BiFunction � uma function com dois valores de entrada
		//UnaryOperator � uma uma function que obrigatoriamente recebe e devolve um valor do mesmo tipo
	}
	
	/**
	 * Supplier : fornecedor - n�o recebe nada e retorna um valor
	 * Consumer : consumidor - recebe um valor e n�o retorna nada
	 */
	/*private void exemploSupplierConsumer() {
		Stream
		.generate( () -> new Random().nextInt() ) // a fun��o generate recebe um supplier
		//Supplier : interface funcional que cont�m um m�todo get sem argumentos
		// Ou seja, n�o recebe input, mas devolve um output
		.limit(10) //limita a 10 valores
		.forEach( (e) -> System.out.println(e) ); // a fun��o forEach recebe um consumer
		//Consumer : interface funcional que cont�m um m�todo accept com um par�metro de entrada e void na sa�da
		//Consumer : oposto do supplier, n�o retorna nada, mas recebe um valor com o qual faz alguma a��o.
	}*/
	
	/**
	 * BiConsumer, interface funcional que cont�m um m�todo accept com dois valores de etrada e nenhum de sa�da.
	 * ou seja, recebe dois valores, realiza uma opera��o com eles, mas n�o retorna nada.
	 * O BiConsumer pode ser testado mais facilmente com um Map
	 */
	/*private static void exemploBiConsumer() {
		
		final HashMap< String, String> nomeSobrenome = new HashMap<>();
		nomeSobrenome.put("Diego", "Chaves");
		nomeSobrenome.put("Jo�o", "Ningu�m");
		
        final BiConsumer<String, String> merge = (nome, sobrenome) ->
        {
        	System.out.print("\n" + nome + " " + sobrenome);
        };
        
        //forEach do Map aceita um BiConsumer que vai receber a chave e o valor como par�metros
        nomeSobrenome.forEach(merge);
        
        System.out.println("\n\nExemplo com andThen");
        //Exemplo
        nomeSobrenome.forEach(merge.andThen(( a, b) -> System.out.print( " - " + (a + " " + b).length() ) ) );
	}*/
	
}
