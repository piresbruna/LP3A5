# LP3A5
Portifólio de atividades da disciplina de LP3A5.

## Estrutura

### Aulas

Contém os códigos de exemplo e exercícios praticados durante as aulas.

#### Aula 02

Aula de Revisão dos conceitos e práticas da linguagem java.
De modo simples foram criadas duas classes Disciplina e Aluno afim de que fosse calculada a média das notas do Aluno e verificada sua presença, para então indicar de o Aluno estava Aprovado, Reprovado ou se precisaria passar pelo Instrumento Final de Avaliação (IFA) na disciplina.

#### Aula 03

Aula sobre threads, com pequenos exemplos das formas de se criar threads em java.

#### Aula 07

Aula sobre Streams, Operações Intermediárias e Terminais, Map/Reduce e Interfaces Funcionais.
Foram feitos vários pequenos exemplos implementos funções ou as combinando de modo a ilustrar as aplicações de streams, principalmente.

### Portifólio

Contém exercícios de prática dos conceitos vistos em aula.

#### [Produtor/Consumidor](https://github.com/piresbruna/LP3A5/tree/main/Portif%C3%B3lio/src/produtorConsumidor)

Exemplo de aplicação de semáforos com duas threads, onde uma produz conteúdo para uma fila limitada, enquanto outra consome o que é produzido. O exemplo sincroniza as threads de modo que o item seja consumido logo após a sua produção.

#### [Métodos de Stream](https://github.com/piresbruna/LP3A5/tree/main/Portif%C3%B3lio/src/metodosStream)

Exemplos de uso do `anyMatch` e `allMatch`.

#### [Exceções Calculadora](https://github.com/piresbruna/LP3A5/tree/main/Portif%C3%B3lio/src/exceptionsRefactorCalculadora)

Calculadora MVC que utilizava de exceções apenas do tipo `RunTimeException`. Refatoração do código para haver menos lançamento de exceções ou alterá-las para exceções próprias com extensão da classe `Exception`.

#### [Coding Dojo](https://github.com/piresbruna/LP3A5/tree/main/Portif%C3%B3lio/src/codingDojo/refactor)

Prática de refatoração usando um [desafio](https://github.com/emilybache/GildedRose-Refactoring-Kata) de Coding Dojo.