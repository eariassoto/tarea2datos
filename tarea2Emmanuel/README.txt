Nota, hice un Makefile para facilitar la compilada, con make go compila y ejecuta
También esta el archivo del proyecto de blueJ

tarea2datos Emmanuel Arias
===========
Haga un documento en el que incluya una explicación básica de cada algoritmo de ordenamiento,
el funcionamiento de su programa, problemas encontrados, descripción de su entrega 
(que incluya el porcentaje de completitud) y una lista de funcionalidades sin implementar.

Sobre los algoritmos de ordenamiento:
Inserción: El algoritmo itera sobre cada elemento de la lista empezando en 1 (para arrays
basados en indice 0) hasta el último elemento. En cada iteración toma el elemento y lo inserta
en hacia atrás hasta que encuentra su logar correspondiente.

Selección: Itera sobre la lista buscando el elemento menor para luego ponerlo en la posicion
0, luego busca desde el índice 1 a el menor de ese segmento y lo acomoda en la posición 1 y
así hasta que ordena el ultimo elemento.

Burbuja: Itera sobre la lista y luego itera internamente de 0 a (n-i) comparando los valores
dos a dos, acomodando siempre en cada iteración el elemento mayor. En otras palabras, en la
primera iteración acomoda el elemento mayor, luego itera y acomoda el que le sigue y así 
hasta que ordena toda la lista.

QuickSort: Este toma la lista, escoge como pivote el último elemento de la lista, y procede
a poner en el lado izquierdo los elementos menores que el pivote y al lado derecho los mayores
a este, luego acomoda el pivote en el centro. Luego de esto ordena de manera recursiva las
dos mitades de la lista (siendo el pivote el centro) hasta que los segmentos sean mayores a 1

ShellSort: Este primero calcula una lista de intervalos, dividiendo la lista entre dos hasta
que llega a uno. Luego itera en esta lista de intervalos y con cada uno de los intervalos
compara los elementos de la lista distanciados por dicho intervalo. 

El programa en Java lanza una ventana que muestra al usuario los valores de la distancia de
la lista y el rango de aleatoriedad de los elementos. Ya se muestra una lista creada aleatoriamente
el usuario puede modificar estos valores y hacer una nueva lista. Cuando se da clic al boton
Ordenar el programa hace los 5 tipos de busqueda en 5 listas iguales que la mostrada al usuario.
Cabe destacar que entre cada ordenamiento hay mediciones en milisegundos antes y despues de ejecutar,
con estos datos se calcula el tiempo de ejecución de cada implementación al usuario junto con la lista 
ordenada. De manera similar el programa en Javascript.

Problemas encontrados: Inserción en una lista simple es terriblemente ineficiente por el mero
hecho de no haber una forma fácil de acceder al nodo anterior sin tener que hacerlo moviendose
iterativamente desde la cabeza de la lista. Entonces al forzar al algoritmo a hacer getNodeByIndex(n-1)
por ejemplo, hace que el algoritmo tarde muchisimo más que acceder a un puntero como node.prev

Otro problema fue en quicksort donde la recursividad se quedaba enciclada porque habia definido mal
la condición que entra a la recursividad. Resulta que al escoger el pivote al final, cuando al lista es 
pocos elementos se puede dar el caso que el pivote quede después del final y se encicla al evaluar 
los valores de los nodos. Lo resolví evaluando la posición del nodo en la lista (por eso el int id)

La entrega está completa, sinceramente no leí bien el enunciado y pensé que había que implementar los
algoritmos de ordenamiento en Javascript, espero que no se entienda como algo pretencioso sino apelo a 
que leí por encima el encabezado.
