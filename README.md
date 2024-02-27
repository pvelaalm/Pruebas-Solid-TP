# Prueba SOLID-TP

## Ejercicio 1:


El programa proporciona un menú interactivo para realizar operaciones en una matriz. Este menú permite imprimir la matriz actual y calcular su transpuesta. A continuación, se describe cada una de las clases involucradas y cómo interactúan entre sí.

### Clase `Menu`

La clase `Menu` representa el menú interactivo del programa. Contiene métodos para mostrar el menú y gestionar las opciones seleccionadas por el usuario.

### Métodos:

* `mostrarMenu()`: Este método muestra el menú al usuario y le permite seleccionar una opción. Dependiendo de la opción seleccionada, se invocan métodos para imprimir la matriz o calcular su transpuesta.
* `main(String[] args)`: Este método es el punto de entrada del programa. Crea una instancia de `Menu` con una matriz predefinida y llama al método `mostrarMenu()` para comenzar la interacción con el usuario.

### Clase `Matriz`

La clase `Matriz` representa una matriz numérica. Contiene una matriz de enteros y proporciona un método para obtener esta matriz.

### Métodos:

* `getMatriz()`: Este método devuelve la matriz almacenada en la instancia.

### Clase `MatrizPrinter`

La clase `MatrizPrinter` se utiliza para imprimir una matriz en la consola. Contiene un método para imprimir una matriz de enteros en formato tabular.

### Métodos:

* `imprimir(int[][] matriz)`: Este método toma una matriz como argumento y la imprime en la consola en formato tabular.

### Clase `MatrizTraspuesta`

La clase `MatrizTraspuesta` proporciona un método para calcular la transpuesta de una matriz dada.

### Métodos:

* `calcularTranspuesta(int[][] matriz)`: Este método toma una matriz como argumento y devuelve su transpuesta.
