<div align="center">

## Estrutura de Dados em Java
### Henrique Otogami
#### Início: 26-11-2024
##### Readme versão 2.0

</div>
<br>
<div align="center">
<img width="500" src="https://github.com/henriqueotogami/todolistyoutube/blob/master/JAVA-Cover.png?raw=true">
</div>
<br>
<div align="center">
<img src="https://img.shields.io/github/deployments/henriqueotogami/data-structure/github-pages">
</div>
<br>
<div align="center">
<img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/henriqueotogami/data-structure">
<img src="https://img.shields.io/github/checks-status/henriqueotogami/data-structure/main">
<img src="https://img.shields.io/github/issues/henriqueotogami/data-structure">
</div>
<br>
<div align="center">
<img src="https://img.shields.io/github/forks/henriqueotogami/data-structure?style=flat">
<img src="https://img.shields.io/github/stars/henriqueotogami/data-structure?style=flat">
<img src="https://img.shields.io/github/license/henriqueotogami/data-structure">
</div>
<br>
<div align=center>
<a href="https://wakatime.com/badge/user/1e53636e-c916-4d50-9ce1-f3ac75a883e3/project/2c40b207-f4f2-4e1f-977c-e502cadca573"><img src="https://wakatime.com/badge/user/1e53636e-c916-4d50-9ce1-f3ac75a883e3/project/2c40b207-f4f2-4e1f-977c-e502cadca573.svg" alt="wakatime"></a>
</div>

### Descrição
> Repositório dedicado aos estudos de estrutura de dados em Java e sem framework.

<hr>

### Sumário
#### Principal
- [x] Fila | Queue.java
- [x] Lista Encadeada | LinkedList.java
- [x] Nó | Node.java

#### Secundário
- [x] Valores padrão | DefaultValues.java
- [x] Mapeamento de tipos de dados | MapTypes.java
- [x] Utilidades | Utils.java
<hr>

### Resumos

<details>
    <summary> Implementação de Fila | Queue.java </summary>
<br>

> Métodos:
> - [x] addElement(Object): void
> - [x] contains(Object): boolean
> - [x] eraseAllElements(): boolean
> - [x] getAllElements(): Object[]
> - [x] getElement(int): Object
> - [x] getObjectType(Object): String
> - [x] getSize(): int
> - [x] isEmpty(): boolean
> - [x] removeElement(int): boolean
> - [x] searchElement(Object): int
> - [x] searchElement(Object[], Object): int
> - [x] setAllElements(Object[]): void
> - [x] toString(Object): String

> Testes Unitários:
> - [x] addElementTest(): void
> - [x] containsTest(): void
> - [x] createQueueTest(): void
> - [x] isEmptyTest(): void
> - [x] removeElementTest(): void
> - [x] searchElementTest(): void
> - [x] toStringTest(): void
<hr>
</details>

<details>
    <summary> Implementação de Lista Encadeada | LinkedList.java</summary>
<br>

> Métodos:
> - [x] append(final Node<T> element): void
> - [x] append(final T element): void
> - [x] append(final int position, final T element): void
> - [x] appendBegin(final T element): void
> - [x] appendMiddle(final int position, final T element): void
> - [x] getSize(): int
> - [x] getLastIndex(): int
> - [x] isEmpty(): boolean
> - [x] isInvalidPosition(final int position): boolean
> - [x] clear(): void
> - [x] removeFirstElement(): T
> - [x] removeLastElement(): T
> - [x] removeElement(final int position): T
> - [x] searchNode(final int position): Node<T>
> - [x] searchElementByPosition(final int position): T
> - [x] searchElement(final T element): int
> - [x] toString(): String
> - [x] getClassName(): String

> Testes Unitários:
> - [x] createEmptyListTest(): void
> - [x] createFullListTest(): void
> - [x] appendTest(): void
> - [x] clearTest(): void
> - [x] clearEmptyListTest(): void
> - [x] searchElementTest(): void
> - [x] searchElementNonExistentTest(): void
> - [x] appendBeginTest(): void
> - [x] appendMiddleTest(): void
> - [x] appendEndTest(): void
> - [x] appendOutOfBoundsTest(): void
> - [x] removeFirstElementTest(): void
> - [x] removeLastElementTest(): void
> - [x] removeElementTest(): void
> - [x] removeElementOutOfBoundsTest(): void
> - [x] removeFirstElementEmptyListTest(): void
> - [x] removeEndElementEmptyListTest(): void
> - [x] createFullListTest(): void
> - [x] createFullListTest(): void
> - [x] createFullListTest(): void
<hr>
</details>

<details>
    <summary> Implementação de Nó | Node.java </summary>
<br>

> Métodos:
> - [x] getElement(): T
> - [x] setElement(final T element): void
> - [x] getNextElement(): Node<T>
> - [x] setNextElement(final Node<T> nextObject): void
> - [x] toString(): String
> - [x] getClassName(): String
</details>

<details>
    <summary> Implementação de Mapeamento de tipos de dados | MapTypes.java </summary>
<br>

> Métodos:
> - [x] getObjectArrayToString(Object element, String elementType): String
> - [x] getPrimitiveArrayToString(Object element, String elementType): String
> - [x] getObjectToString(Object element, String elementType): String
> - [x] getPrimitiveToString(Object element, String elementType): String
> - [x] getElementContentsToString(final Object[] objectArray): String
> - [x] getElementContentsToString(Object element): String
> - [x] getGroup(final String typeElement): String
> - [x] getObjectType(final Object element): String
</details>

<hr>

### Documentação
### Javadoc
> Documentação técnica gerada a partir das classes e métodos implementados.
- [x] [Javadoc - Estrutura de Dados](https://henriqueotogami.github.io/data-structure/)

### Wiki
> Informações gerais sobre o projeto deste repositório de estudos de estruturas de dados.
- [x] [Wiki - Estrutura de Dados](https://github.com/henriqueotogami/data-structure/wiki)

### Kanban
> Informações sobre as tarefas que estão sendo desenvolvidas nesse repositório de estrutura de dados.
- [x] [Kanban - Estrutura de Dados](https://github.com/users/henriqueotogami/projects/4)

<hr>

### Dependências
### Bibliotecas
#### Log4j
> API para gerenciamento de logs.
- [x] [log4j-api-2.3.2.jar](https://logging.apache.org/log4j/2.3.x/download.html)
- [x] [log4j-core-2.3.2.jar](https://logging.apache.org/log4j/2.3.x/download.html)

#### JUnit 5
> API para escrita de testes.
- [x] [junit-jupiter-5.8.1.jar](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.8.1)

<hr>

## 📝 Leia meus artigos

### [Artigos no Medium](https://medium.com/@henriqueotogami)
### [Artigos no Dev.to](https://dev.to/henriqueotogami)

<br>

## 💼 Conecte-se comigo
### [Perfil no LinkedIn](https://www.linkedin.com/in/henrique-matheus-alves-pereira)

<br>

## 🙏🏻 Apoie meu conteúdo
### [Compre-me um cafézinho | Buy me a coffee](https://ko-fi.com/henriqueotogami) ☕

<hr>

### Créditos
- [x] [Foto de capa by Clay Banks | Unsplash - Photos for everyone;](https://unsplash.com/photos/oO6Gm16Cqcg)
- [x] [Shields.io | Badges Info from Github](https://img.shields.io)
- [x] [Alexandre Sanlim | Badges Tech](https://github.com/alexandresanlim/Badges4-README.md-Profile)

<hr>

### Contribuição
> Caso você queira ajudar a melhorar este repositório, siga as etapas abaixo.
> Qualquer ajuda é bem-vinda.

- [x] Faça um **fork** deste repositório (https://github.com/henriqueotogami/data-structure/fork);
- [x] Crie um **branch** com as suas modificações ` git checkout -b meu-novo-recurso `;
- [x] Faça um **commit** ` git commit -am 'Adicionando um novo recurso ...'`;
- [x] Faça um **push** ` git push origin meu-novo-recurso ` ;
- [x] Crie uma nova **pull request** neste repositório.

**Depois que sua solicitação (pull request) for aceita e adicionada (merged) ao ramo principal (branch main), você pode excluir sua branch tranquilamente.**

<div align="center">

<br>

> ### **Muito obrigado, e que a força esteja com você.**
>
> ### Desenvolvido por **Henrique Otogami** 🦁

</div>
