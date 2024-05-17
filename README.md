#FalkensMaze
Descripción
FalkensMaze es una aplicación de escritorio escrita en JavaFX que permite crear y editar laberintos personalizables.


![Screenshot_20240517_172522](https://github.com/AlejandraCanovas/FalkensMaze/assets/158309284/9228bcbf-add6-400a-b471-64688a94198b)

![Screenshot_20240517_172653](https://github.com/AlejandraCanovas/FalkensMaze/assets/158309284/f8d372c5-55c3-4b1d-8a2a-1979260c6e77)


Funcionalidades principales:
Elementos de la Interfaz:
-La clase utiliza JavaFX para crear la interfaz gráfica de usuario (GUI).
-La ventana principal se compone de tres secciones:
    Un MenuBar en la parte superior con opciones de Archivo ("Nuevo", "Guardar", "Abrir") y Opciones ("Sonido", "Tiempo", "Salir").
    Un BlocksPanel a la izquierda que muestra los diferentes tipos de bloques disponibles para construir el laberinto.
    Un MazeCanvas en el centro que representa el área de edición del laberinto.

Funcionalidades:
-Creación de un nuevo laberinto:
    Permite definir el tamaño del laberinto mediante un diálogo DialogSize.
    El laberinto se inicializa en el objeto MazeCanvas.
-Edición del laberinto:
    Se pueden arrastrar y soltar bloques desde el BlocksPanel hacia el MazeCanvas para construir el laberinto.
    La clase Block probablemente contiene información sobre el tipo de bloque (pared, salida, etc.).

-Guardar y cargar laberintos:
    Permite guardar el laberinto en diferentes formatos (XML, JSON, Bin) usando la clase Maze.save.
    También permite cargar laberintos previamente guardados usando la clase Maze.load.

-Opciones de sonido y tiempo:
    Se puede seleccionar un archivo de sonido (.mp3) para el laberinto.
    Se puede definir un tiempo límite para completar el laberinto.

-Otros aspectos:
    El código maneja el cierre seguro de la aplicación al pulsar la X de la ventana.
    Se utilizan cuadros de diálogo de alerta (Alert) para mostrar mensajes de error.

Funcionalidad de otras clases:
    -Block: Define la información de un bloque del laberinto (tipo, etc.).
    -BlocksPanel: Panel que muestra los diferentes tipos de bloques disponibles.
    -MazeCanvas: Representa el área gráfica del laberinto y gestiona su edición.
    -Maze: Representa el modelo del laberinto (contiene la información de los bloques, sonido, tiempo, etc.).
    
