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

- Testes unitários - por motivos de falta 

- Arquitetura MVP

## Pontos de melhoria

A seguir, algumas melhorias arquiteturais, visando um desenvolvimento escalável do app. 
Ao lado indico um repositório contendo a respectiva implementação feita por mim para demonstração.



- Tratamentos de erro de consulta (erros http 400, 500 ou erros de conectividade )
- Desacoplamento de regras de negócio em classes comumente chamadas de "`Interactors`" ou "`UseCases`". Motivo: facilita os testes das classes em separado. [Referência](https://github.com/rafaelanastacioalves/android-app-templates/blob/arch_comp_and_java/app/src/main/java/com/example/rafaelanastacioalves/moby/domain/interactors/MainEntityListInteractor.java)
- Encapsulamento dos dados vindos do repositório até chegar às Views (comumente chamados de "`Resources`"). Motivo: facilita às Views de saber informação sobre o que exibir. [Referência](https://github.com/rafaelanastacioalves/android-app-templates/blob/arch_comp_and_kotlin_coroutines/app/src/main/java/com/example/rafaelanastacioalves/moby/domain/entities/Resource.kt)
- Atribuição do conhecimento de quais componentes utilizar para obter os dados em classes "`Repository`". Motivo: facilita os testes das classes em separado. Cada classe fica com uma atribuição específica. [Referência](https://github.com/rafaelanastacioalves/android-app-templates/blob/arch_comp_and_kotlin_coroutines/app/src/main/java/com/example/rafaelanastacioalves/moby/retrofit/AppRepository.kt)
- Atribuição de decidir de onde obter os dados (http ou local) bem como encaspular os mesmos por meio de "`NetworkBoundResource`". Motivo: Isola essa atribuição a uma classe só e evita código repetido. [Referência](https://github.com/rafaelanastacioalves/android-app-templates/blob/arch_comp_and_kotlin_coroutines/app/src/main/java/com/example/rafaelanastacioalves/moby/retrofit/NetworkBoundResource.kt)
- Utilização de `Coroutines` para assincronicidade. Motivo: é uma paradigma para chamadas assícronas que permite uma melhor organização e leitura do código. [Referência](https://github.com/rafaelanastacioalves/android-app-templates/blob/arch_comp_and_kotlin_coroutines/app/src/main/java/com/example/rafaelanastacioalves/moby/retrofit/NetworkBoundResource.kt)

