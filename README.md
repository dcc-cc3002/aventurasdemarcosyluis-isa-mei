# AventurasdeMarcosyLuis

Para empezar, se implemento una clase principal, *abastractCharacter* para los personajes en gereral, 
enemigos y personajes principales, dado comparten los getters y setters de las estadísticas que 
tienen en común y como se calcula el daño al atacar. Luego, se tiene una subclase para los enemigos,
*AbtractcEnemies*, otra para los personajes principales *AbstractPlayers*.

En abstractCharacters se dejaron los getters públicos para poder acceder a ellos y poder usarlos en
los test, además que no dan un problema de seguridad al solo devolver el valor que tiene el personaje.
Asimismo, se implementaron los setters en está clase, debido a la privacidad que tienen las variables
de los personajes, así que se se dejaron los métodos protegidos para que las subclases los pudieran 
usar, como por ejemplo AbstractPlayers al subir de nivel. a la clase se le implementó la interfaz 
ICharacter que contiene el método *damage* para calcular el daño realizado por un personaje a otro,
*recieveDamage* que se encarga de reflejar el daño recibido en los puntos de vida del personaje,
el getter de defensa *getdef*, dado que lo necesita damage, y el getter de hp, *getHp*, dado que lo
necesita otro método que está en una interfaz hija de ICharacter. Cabe destacar que se tiene el 
método *changeHp* en la clase, el cual se encarga modificar el hp de tal forma que éste siempre 
esté entre un valor 0 y su máximo hp, lo cual es necesario al momento de recibir daño  y cuando
los personajes se curan. 

Para verificar que cuando un personaje llegaba a los 0 hp, éste debía estar derrotado por lo que no
podría atacar, se implemento que los personajes tuvieran una variable estatus, la cual indica si está
muerto o vivo. En lo métodos que cambian el hp, en el caso que éste sea igual a 0, ponen en marcha el
método *dead*. el cual cambia el estado del personaja a muerto. Se implementó el método *isDead* que
sirve para saber si el personaje está muerto o no, así que es usado en los métodos de ataque, puesto
que si está muerto el personaje ataca con 0. Por ahora la variable *status* es un string, lo que
permitiría extenderlo a que hayan más cambios de estados por los que pueda pasar un personaje, como
envenado o dormido, aunque tal vez sería más fácil representarlo simplemente con números, como si es
0 está derrortado o si es 1 está vivo, pero por ahora lo que se tiene funciona.

La subclase AbstractEnemy simplemente hereda el constructor de su clase padre para el suyo, ya que no
tiene otros parámetros. Aquí también está el método *attack* para calcular el daño que realizan los 
enemigos, el cual es solo uno, ya que los enemigos no tienen más de un ataque. Este método está 
presente en la interfaz IEnemies, el cual es implementado por la clase abstracta. AbstractEnemy tiene
tres subclases, donde cada una es un enemigo, *Boo*, *Goomba* y *Spiny*. Se realizó así, puesto que en
cada clase se vió como se recibe un ataque de un jugador principal y en el caso de Boo este sólo podía 
ser atacado por Marcos y además solo puede atacar a Luis, por lo que Goomba y Spiny implementan la 
interfaz *AttackedByPlayers*, que tiene los métodos para cuando el ataque es salto o con martillo. En
el caso se Goomba no hay ninguna particularidad para algún ataque, mientras que Spiny no recibe daño 
al ser atacado con salto e incluso daña a quien lo ataco y recibe de forma normal el ataque de martillo.
Para el caso de Boo éste solo podía ser atacado por Marcos, asi que implementa la interfaz *AttackedByMarcos*,
que tiene los métodos para el caso de que se ataque con salto o martillo. Así, para el ataque de salto, Boo
lo recibe de forma normal, pero en el caso de martillo este siempre lo esquiva. Cabe destacar que en los 
ataques que los enemigos esquivan o que en si no pueden recibir, de todas formas se le indica al jugador
principal, dado el doble dispatch, el ataque que utilizó para que se gasten los fp correspondientes. 
Con respecto a cómo atacan los enemigos se implementó el método *attackTo* para aplicar el double dispatch. 
Este método en sí está comprometido por la interfaz *GoombaAndSpiny* para que estos enemigos lo implementen 
de igual forma en su clase, y además se implementa en Boo, pero con una firma distinta dado que su argumento es
Luis, puesto que solo lo puede atacar a él; por lo tanto, este es un método con Overload. En sí se creo la 
interfaz *GoombaAndSpiny* para permitir que ambos pudieran atacar a los dos personajes principales, por lo que
se necesitaba algo que los "contuviera" a ambos y poder diferenciarlos de Boo. Si bien está la interfaz 
*AttackedByPlayer* que tnato Goomba y Spiny la implementan, incluir el método ahí pareciera estar fuera de 
lugar con la interfaz ya que su función principal es para ver como reciben los ataques de los personajes 
principales, así que se creó la interfaz *GoombaAndSpiny* para que tuviera el método para atacar.

La clase AbstractPlayers hereda el constructor de su clase padre e inicializa sus puntos de ataque, 
Fp, en su constructor propio, donde también se incializa su dado, representado por un Random, el 
cual es necesario para implementar el ataque con martillo. Se implementaron los ataques salto, método
*Jump*, y martillo, método *Hammer*, de tal de forma que cada uno realiza el daño según la formula 
dada y verifica que el que el personaje principal este vivo y tenga los puntos de ataque necesarios
para atacar con dicho ataque, por lo que se utiliza el método *cannotAtack*, que indica verdadero si
el personaje no puede atacar, y falso en caso contrario. Junto con esto, al realizar el ataque se 
consumen fp, lo que se realiza con método *changeFp*. Si bien este calculo se realiza en los métodos
*jump* y *hammer*, los cuales son comprometidos por la interface IPlayer que los tiene y que es implementada
en la clase, en sí para realizar el ataque, utilizando double dispatch, es con los métodos *attackJump*
*attackHammmer*, según corresponda. Asimismo, la clase implementa la interfaz *AttakedByGoombaAndSpiny* que
tiene el método *attackedByEnemy* que se encarga de que el personaje principal reciba el daño infligido por 
Goomba o Spiny. Con respecto Boo, dado su particularidad de que sólo puede ser atacado por Marcos y que sólo
ataca Luis, se tiene que la clase AbstractPlayers tiene como subclases Marcos y Luis, donde cada una representa
a un personaje principal, y se tiene que Marcos se encarga de implementar el ataque a Boo haciendo overloding
de sus métodos de ataque, y Luis se encarga de poder recibir el ataque de Boo con el método *attackedByBoo*, 
que es un método comprometido dado que Luis implementa la interfaz del mismo nombre del método..

Se implementó la clase Baul, la cual hace uso de una lista para poder almacenar los objetos Items, lo que facilita
poder pregintar si está X objeto en la lista y poder removerlo al usarlo. Se decidió crear una clase en sí 
para esto, dado que los personajes principales comparten el inventario, junto con el uso de objetos, por lo
que en AbstractPlayers, el método *usaItem* recibe el inventario que comparten y el objeto a usar, con lo 
que verifica que este el objeto a usar y que el personaje este vivo para realizar tal acción. Luego de usar
el objeto le avisa al baul que remueva el objeto de la lista. Por lo tanto, la clase Baul tiene métodos para
agregar objetos, removerlos y preguntar si hay un objeto en particular en la lista. 

Para los items se utilizó una interface para facilitar el uso de items en el jugador, con el método 
*useItem*. La interface presenta el método *usage*, la cual es implementada por cada clase de items 
que implementa la interfaz. En este caso se tiene una clase  para Red Mushroom y otra para Honey Syrup, 
donde en cada una se implementa su uso. Si fuese necesario agragar otro item 
al juego bastaría crear uan clase para éste y que implementará la iterfaz parq que el personaje pudiera 
utilizarlo.

En el controlador del juego se tienen los parametros necesarios para el funcionamiento del juego. Se tiene
un variables para indicar en todo momento el personaje que esta en turno actualmente y a quien le toca en el
proximo turno. Asimismo, se tiene una lista para tener a los personajes principales que están actualmente en el 
juego, otra lista para guardar a los guardar a los jugadores que son derrotados, lo que sirve para ver cuando 
los personajes pierden; se tiene otra lista para tener a los enemigos que estan en el juego, y otra lista que 
mantiene los personajes como al inicio de cada nivel, ocn el propósito de cuando se pase de nivel se les aplique
el método parasubir de nivel y se mantenga el oden de que marcos va primero que luis en el juego. También se tiene 
una variable para indicar en que nivel del juego se está y en que turno de los personjaes se está. Además se tiene
el baul de los personajes y los objetos, red mushroom y honey syrup, estos tres últimos son inicializados al momento de
que se inicializa el constructor. En el constructor se tiene los métodos para crea a los personajes, el baul y los 
objetos. Con respecto a esto se sigue el patron de diseño factory, por lo que se retorna el objeto que se creó lo que
sirve para luego verficiar en los test que el objeto está en la lista correspondiente, sin embargo una mejor 
implementación hubiera sido que se creará el personaje y simplemente se agregara a la lista y además dejando los
métodos create privados para evitar problemas. La idea es que al inicializar el juego siempre se llame primero al 
create de Marcos y luego el Luis, para tener siempre ese orden en las batallas. Con respecto a los enemigos se creó el
método *addEnemy* que de forma al azar va creando enemigos y los agrega a la lista, esto con el proposito que en cada 
nivel del juego se tiene enemigos pero estos son al azar y se debe mantener un orden para las batallas, así que 
dependiendo del nivel que se está se debe llamar este método las veces necesarias. Con respecto a los objetos, cada vez
que se llamma su create se reemplaza el parametro que se tiene en el constructor para éste, si se quiere agregar 
objetos al baul de los jugadores se tiene que llamar el método *add* correspondiente para agregar el item. Para usar
los items se tienen los métodos *playerUseHoney* y *playerUseMushroom*, el cual tiene como argumento el personaje 
principal que utilizara el item y el item a utilizar, luego se utiliza los métodos propios de la clase baul para 
el correcto uso de los item(si el jugador esta KO no se usa el item o si no está el item ene el baul el jugador no 
utiliza el item).  Se tiene también el método *getCharactersInTurn* que devuelve todos los personajes que están 
actualmente en el juego. Cuando se termina cada turno de un personaje(enemigos atacan y jugadores atacan, usan un item 
o pasan) se tiene el método *endTurn* para que se remueven los personajes que están KO(usando *removeKO*, se aumenta el 
contador de turnos tal que permanezca dentro de los valores correspondientes(con *nextTurn*, y se actualiza el 
personaje al cual de toca ahora y al que le tocara después. Por último, se tiene el método *playersWin* que indica si 
los persoanjes principlaes ganaron, y se tiene el método *advancedLevel* que verifica si los jugadores ganaron para 
avnzar al siguiente nivel, por lo que se resetean los turnos y los personajes principales suben de nivel, por lo
que se utiliza ademas el método *nextLevel*. Cabe destacar que para el correcto funcionamiento se tuvieron que agregar 
métodos a las interfaces de los personajes(ICharacter, IPlayer y IEnemy), que en sí eran métodos que ya estaban 
implementados en las clase, pero dado que en el controlador se utiliz como tipo las interfaces era necesario que los 
métodos estuvieran en la interfaz.
