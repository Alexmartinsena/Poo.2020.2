1.O QUE FEZ ? ---> Fiz o codigo do Twitter onde os usuario podem: Adicionar outros usuarios, dar follow ou unfollow em outros usuarios,escrever mensagens para suas timelines,dar like em mensagens de outros usuarios e exibir os likes da mesma.

2.COMO FEZ ? ---> Ao todo foram 4 classes(Tweet,User,Controller e Twitter).

(Tweet) é a classe responsável por armazenar o (id) da mensagem que foi postada, o (username) que a escreveu, as postagens e os usernames que deram like na postagem na sua timeline.


(User)  é a classe responsável por armazenar o (username), as mensagens não lidas(UnreadCount), um Arraylist para a (Timeline) e 2 TreeMap para (Followers) e para os (Following).
Nela podemos encontrar metodos como:
public void follow(User other), public void unfollow(String username), public Tweet getTweet(int id), public void sendTweet(Tweet twt), public String getTimeline() e public String getUnread().


(Controller) é a classe responsável por armazenar todos os usuários e mensagens postadas por eles no sistema, ela possui 2 TreeMap para os (Users) e para os (Tweets) e tmb armazena o id do prox tweet(int nextTWTid). Desse jeito a classe adiciona e chama os métodos para um usuário na main da aplicação, o que garante a interatividade com o código. 


(Twitter) é simplesmente a classe Main :P.

3.COM QUEM FEZ ---> Individual.

4.APRENDIZADO E DIFICULDADES ---> Senti um pouco de dificuldade no que condiz a assosiação reflexiva então tive que dar uma estudada mais aprofundada. 

5.TEMPO ---> Umas 4 horas. 
