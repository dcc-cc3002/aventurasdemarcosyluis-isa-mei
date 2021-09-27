# AventurasdeMarcosyLuis

Para empezar, decidí implementar dos clases principales, Players, para los personajes principales,
y AbstractEnemy, como la clase padre para todos los enemigos. Lo hice así, dado que si bien los 
jugadores comparten algunas estadísticas en común, como atk, def, hp, maxHp y lvl; sentí que si 
hacía una clase en común para ambos, como AbstractCharacter, ésta tendría mucho poder y luego la 
clase hija para los jugadores tendría que agregar nuevos parámetros y otro constructor. Asimismo, 
creo que el haber hecho dos clases principales para los personajes lo deja más simple de entender.

Para la clase Players y abstractEnemy se imoplementaron los getter para accceder a los parametros 
cada clase y se dejaron públicos para poder usarlos en los test, además que no dan un problema de
seguridad al solo devolver el valor que tiene el personaje. los métodos setter solo se impolemntaron
si otro método lo necesitaba y se dejaron en privado, así que son usados por el otro método. A ambas
clase se le implemento la interfaz ICharacter, el cual contiene métodos en común que usarán ambas
clases, en especifico, una clase para calcular el daño realizado por un personaje a otro, *damage*,
como el personaje recibe el daño, *recieveDamage*, y el gettter de defensa, *getDef*, puesto que
el método para calcualr el daño necesita obtener la defensa del personaje atacado. Con respecto a
los métodos *damage* y *getDef* se implementan de igual forma, ya que no varia lo que hacen en cada 
clase, pero el método *receiveDamage* es distinto: en Players, simplemente le aplica el daño hecho
al jugador y se lo aplica al hp actual de ésts, luego hace uso ddle método *changeHp*, la cual se 
encarga de modificar el hp de tal forma que éste siempre esté entre un valor 0 y su máxximo hp. En 
cambio, en AbstractEnemy, el método aplica el daño en los hp, pero además se encarga de verificar
que queden en un valor mayor o igual a 0. Como los enemigos no pueden usar objeos para curarse no 
vio necesario utilizar un método para que el hp no sea mayor a el máximo de hp. Si a después los 
enemigos pudieran recuperar hp de algun forma habría que implementar un método que se encargue
de que el hp quede dentro de los valores permitidos, como se hizo en players.

Sobre la clase Players si bien se inicalizó el inventario como una lista, no se hizo uso de este ya
que no se pedía en esta entrega, pero de todas formas se dejo el método para agregar los items. 
Además, se implementó un ataque, el salto, para verificar el bien uso de las funciones *damage*, 
*recieveDamage*, *getAtk*, *getDef*, *ChangeFp*, *changeHp*, junto con verificar que el personaje
no pudiese atacar si no estaba muerto o no le quedaban puntos de ataque. El método *changefp* es 
parecido a *changeHp*, pero se encarga de los fp.

Para verificar que cunado un personaje llegaba a los 0 hp, este debía estar derrotado por lo que no
podría atacar, se implemento que los personajes tuvieran una variable estatus, la cual indica si está 
muerto o vivo. En lo métodos que cmabian el hp, en el caso que éste sea igual a 0, ponen en marcha el 
mëtodo *dead]. el cual cambia el estado del personaja a muerto. Se implementó el método *isDead* que 
sirve para saber si el personaje está muerto o no, así que es usado en los métodos de ataque, puesto
que si está muerto el personaje ataca con 0. Por ahora la variable *status* es un string, lo que 
permitiría extenderlo a que hayan más cambios deestados por los que pueda pasar un personaje, como 
envenado o dormido, aunque tal vez sería más fácil representarlo simplemente con números, como si es
0 está derrortado o si es 1 está vivo, pero por ahora lo que se tiene funciona. 

Con respecto a las subclases de Abstractenemy, cada una representa a un enemigo, *Boo*, *Goomba* y 
*Spiny*. Preferí hacerlo así, puesto que al implementar de forma correcta los ataques a futuro, cada
enemigo tiene su particularidad al respecto, como que Boo no puede ser taacado con martillo y no puede
atacar a Mario, o si Spiny es atacado con salto el jugador recibe daño; por lo que cada particularidad 
deberá ser implementada en cada clase. Asimismo, si hay un nuevo tipo de enemigo en el juego, 
simplemente se puede crear una nueva subaclase de AbstractEnemy para éste.

Para los items se utilizó una interface para facilitar el uso de items en el jugador, con el método 
*useItem*. La interface presenta el método *usage*, la cual es implementada por cada clase de items 
que implementa la interfaz. En este caso se tiene una clase para Star, otra para Red Mushroom y otra para
Honey Syrup, donde en cada una se implementa su uso. Con respecto a al item Star su método solo printea un
mensaje, puesto que todavía no se indica bien lo que hace el método, por lo que su test es solo verificar
que cuando el jugador usa el item se muestre el mensaje. Para agregar, si fuese necesario agragar otro item 
al juego bastaría crear uan clase para éste y que implementará la iterfaz par auq eel personaje pudiera 
utilizarlo.

Por último, dado que es la tarea 1 habrá varias cosas que corregir a futuro por alguna indicación o porque
ahoraestáincompleto, como por ejemplo, la interacción nentre los jugadores y los enemigos a través de los 
atauqes por ahora funciona, pero no esta implemnetada completamente la lógica de estos. Falta implementar 
bien los ataques, salto y martillo, y como los enemigos lo reciben, asimismo, cada enemigo tiene su
particularidad sobre los ataques, como si se ataca con salto a Spiny el jugador recibe daño o que Boo 
solo ataca a Luis, por lo que será necesario ver como diferenciar a Marcos y a Luis, lo que podría resolverse
añadiendo un parámetro como tipo de jugador en su clase o creando una subclase para Marcos y otra para Luis,
pero se verá más adelante. Otro falo de la implementación es que como la clase Players imeplementa la interfaz
ICharacter, esto permite que un jugador ataque a otro jugador, lo que no se debería poder(como se ve en testPackge, 
linea 66), pero dado que no era neecesario impementar bien los ataques en esta entrega se dejó así y se corregirá
a futuro. La implementación de ataque actual es una base para lo que se hará despues y se dejó
puesto que para probar los métodos, al atacar se usan otros métodos que son privados, por lo que se realiza
un mejor test. Junto con esto, se agregaron solo los setter necesarios para que los usarán otros métodos para que
se mantuvieran privados, como por ejemplo changeHp y setHp. Pensando a futuro, como los jugadores tienen nivel y 
este puede ir aumentando a lo largo del juego, opdría ser que al aumentar de nivel este modifique sus paramétros,
por lo que sería hnecesario implementar los métodos setter para modificar los stats del jugador. También, falta
implementar bien el inventario, es decir, si este tiene un límite de tamaño para tener items, junto con que se 
pueden usar solo los items que están en el inventaerio y que al usarlos ésta sea eliminado, y además falta
implemnentar que si el jugador está derrotado este no pueda usar items. 
