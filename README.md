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

Para verificar que cuando un personaje llegaba a los 0 hp, este debía estar derrotado por lo que no
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
tres subclases, donde cada una a un enemigo, *Boo*, *Goomba* y *Spiny*. Se realizó así, puesto que en
cada clase se vio como se recibe un ataque de un jugador principal y en el caso de Boo este sólo podía 
ser atacado por Marcos y además solo puede atacar a Luis, por lo que Goomba y Spiny implementan la 
interfaz *AttackedByPlayers*, que tiene los métodos para cuando el ataque es salto o con martillo. En
el caso se Goomba no hay ninguna particularidad para algún ataque, mientras que Spiny no recibe daño 
al ser atacado con salto e incluso daña a quien lo ataco y recibe de forma normal el ataque de martillo.
Para el caso de Boo éste solo podía ser atacado por Marcos, asi que implementa la interfaz *AttackedByMarcos*,
que tiene los métodos para el caso de que se ataque con salto o martillo. Así, para el ataque de salto, Boo
lo recibe de forma normal, pero en el caso de martillo este siempre lo esquiva. Además, en la clase Boo se
sobreescribió el método *attack*, puesto que Boo sólo puede atacar a Luis. 

La clase AbstractPlayers hereda el constructor de su clase padre e inicializa sus puntos de ataque, 
Fp, en su constructor propio, donde también se incializa su dado, representado por un Random, el 
cual es necesario para implementar el ataque con martillo. Se implementaron los ataques salto y 
martillo de tal de forma que cada uno realiza el daño según la formula dada y verifica que el 
que el personaje principal este vivo y tenga los puntos de ataque necesarios para atacar con 
dicho ataque, por lo que se utiliza el método *cannotAtack*, que indica verdadero si el personaje
no puede atacar, y falso en caso contrario. Lunto con esto, al realizar el ataque se consumen fp,
lo que se realiza con métodod *changeFp*. Si bien el este calculo se realiza en los métodos *jump*
y *hammer*, los cuales son comprometidos por la interface IPlayer que los tiene y que es implementada
en la clase, en sí para realizar el ataque, utilizando double dispatch, es con los métodos *attackJump*
*attackHammmer*, según corresponda. Además, la clase implementa la interfaz AttackedByEnemy, para 
referenciar que Marcos y Luis pueden ser atacados de forma normal por Goomba y Spiny. Asimismo, la clase 
tiene como subclases Marcos y Luis, siendo una para cada personaje principal, lo  cual fue necesario dada
la particularidad de Boo, por lo que Marcos se encarga de implementar el ataque a Boo haciendo overloding 
de sus métodos de ataque, y Luis se encarga de poder recibir el ataque de Boo.

Se implemento la clase Baul, la cual hace uso de una lista para poder almacenar los objetos Items, lo que facilita
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
