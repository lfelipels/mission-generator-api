Teste prático:

Considere um sistema com as seguintes missões predefinidas:

1 - Locomoção

Você deve pegar um ônibus do bairro {0} ao bairro {1}, fazendo a baldeação no máximo {2} vezes.

1.1 - regra

Você deverá obter valores de forma aleatória para todas as variáveis. As variáveis 0 e 1 deverão ser alfanuméricas com nomes que representem bairros brasileiros. Os nomes não podem se repetir e devem ser utilizados de forma aleatória a partir de uma lista de bairros definida por você (10 bairros). A variável 2 deve ser número inteiro maior que 0 e menor que 10.

2 - Desafiar outra pessoa a se locomover

Você deve desafiar o jogador {0} a pegar um ônibus do bairro {1} ao bairro {2}, fazendo a baldeação no máximo {3} vezes.

2.1 - regra

A variável 0 deve ser o nome de algum dos usuários da lista predefinida, mas não deve ser o usuário para quem a missão foi atribuída. As variáveis 1 e 2 deverão ser alfanuméricas com nomes que representem bairros brasileiros. Os nomes não podem se repetir e devem ser utilizados de forma aleatória a partir de uma lista de bairros definida por você (10 bairros). A variável 3 deve ser número inteiro maior que 0 e menor que 10, gerado de forma aleatória.

3 - Ser o melhor entre seus colegas

Numa disputa entre você, {0} e {1}, você deve fazer a viagem com menos baldeações para pegar um ônibus do bairro {2} para o bairro {3}.

3.1 - regra

As variáveis 0 e 1 devem ser os nomes dos usuários da lista predefinida, mas não pode ser o usuário para quem foi atribuído a missão. As variáveis 2 e 3 são nomes de bairros escolhidos de forma aleatória a partir de uma lista predefinida por você (10 bairros).

O sistema deve gerar missões randomicamente para 3 usuários. A missão não pode repetir para o mesmo usuário. A missão não pode aparecer na mesma ordem para outro usuário. Exemplo:

Usuário 1 - Danilo

- Missão 1 -> Você deve pegar um ônibus do bairro Santo Amaro ao bairro Vila Prudente fazendo a baldeação no máximo 4 vezes.

- Missão 2 …

- Missão 3 …

Usuário 2 - Fernanda

- Missão 2 …

- Missão 3 …

- Missão 1 …

Usuário 3 - Eduardo

- Missão 3 …

- Missão 1 …

- Missão 2 …

O desafio é criar missões a partir de um predefinição mínima e randomizar o sorteio delas para três usuários.

Você precisa utilizar os conceitos de orientação a objetos.

A forma de apresentar a solução é a partir de uma api REST escrita com java (spring boot) com uma tela utilizando vue.js com vuetify - https://vuetifyjs.com/en/getting-started/installation/#vue-cli-install.

Você decide como apresentar ou obter as informações.

Não é preciso ter comunicação com banco de dados.

A api so precisa ter dois endpoints, um para inserir os 3 usuários e outro para listá-los com as missões com o texto enriquecido selecionado para cada um deles. Você utilizará essa api para alimentar o front em Vue.js.

Resultado exemplo para um dos usuários:

Usuário Danilo

Missões

- Você deve desafiar o jogador Eduardo a pegar um ônibus do bairro Periperi ao bairro Rio Vermelho, fazendo a baldeação no máximo 2 vezes.

- Você deve pegar um ônibus do bairro Santo Amaro ao bairro Vila Prudente fazendo a baldeação no máximo 4 vezes.

- Numa disputa entre você, Nanda e Eduardo, você deve fazer a viagem com menos baldeações para pegar um ônibus do bairro Imbuí para o bairro Costa Azul.

A solução pode ser entregue no github após a candidatura.
