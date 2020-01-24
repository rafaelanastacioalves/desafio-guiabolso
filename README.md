# DESAFIO GUIA BOLSO

## Descrição Geral

Desafio tecnico da empresa Guia Bolso.

![tela de listagem](captures/)

![tela de detalhes](captures/)

## Arquitetura

Neste projeto, decidi por utilizar a arquitetura MVVM, por fazer uso da componente [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) do [Android Architecture Components](https://developer.android.com/topic/libraries/architecture).
A utilização desses componentes é recomendada pelo Google por permitir um melhor gerenciamento do ciclo de vida de Activity e Fragments, simpllificando o desenvolvimento e trazendo mais qualidade aos projetos.
 

## Descrição técnica

Utilizei as seguintes bibliotecas:
- Retrofit: Para consultas http 

- RxJava: Utilizado para viabilizar as chamadas http de maneira assíncrona

- Picasso: Para a renderização de imagens 

- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata): Utilizado para manipulação assícrona de variáveis relacionadas às Views, utiliznado o padrão observer.


## Testes Funcionais (Instrumentados)

Os testes utilizam o buildtype ```instrumentation``` para execução, pois forçamos que o app seja gerado para apontar para `localhost` durante os testes.

## O que não foi implementado

- Testes unitários

- Arquitetura MVP

## Pontos de melhoria

- Tratamentos de erro de consulta (erros http 400, 500 ou erros de conectividade )
- Desacoplamento de regras de negócio em classes comumente chamadas de "`Interactors`" ou "`UseCases`"
- Encapsulamento dos dados vindos do repositório até chegar às Views (comumente chamados de "`Resources`").
- Atribuição do conhecimento de quais componentes utilizar para obter os dados em classes "`Repository`".
- Atribuição de decidir de onde obter os dados (http ou local) bem como encaspular os mesmos por meio de "`NetworkBoundResource`".
