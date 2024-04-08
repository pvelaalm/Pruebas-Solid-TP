# Prueba SOLID-TP
[Link a mi repositorio de GitHub](https://github.com/pvelaalm/Pruebas-Solid-TP)
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

## Ejercicio 2:


El programa proporciona un sistema de gestión de pedidos que incluye autenticación de usuarios, creación, actualización y eliminación de pedidos, procesamiento de pagos básico y conexión a una base de datos para almacenar los pedidos. A continuación, se describe cada una de las clases involucradas y cómo interactúan entre sí.

### Clase `Authenticator`

La clase `Authenticator` se encarga de autenticar a los usuarios mediante un almacenamiento de usuarios proporcionado. Verifica si un usuario y contraseña son válidos consultando el almacenamiento de usuarios.

### Métodos:

* `authenticate(String username, String password)`: Este método toma un nombre de usuario y una contraseña como argumentos y verifica su validez consultando el almacenamiento de usuarios proporcionado.

### Clase `BasicPaymentProcessor`

La clase `BasicPaymentProcessor` implementa la interfaz `PaymentProcessor` y proporciona una implementación básica del procesamiento de pagos. Simplemente imprime un mensaje indicando el pago procesado exitosamente.

### Métodos:

* `processPayment(double amount, String paymentMethod)`: Este método toma el monto del pago y el método de pago como argumentos, imprime un mensaje indicando el procesamiento exitoso del pago y devuelve `true`.

### Clase `DataBaseManager`

La clase `DataBaseManager` maneja la conexión con la base de datos y realiza operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la tabla de pedidos.

### Métodos:

* Constructores: La clase tiene dos constructores, uno para establecer una conexión real con la base de datos y otro para propósitos de prueba con una conexión simulada.
* Métodos para operaciones CRUD: La clase incluye métodos para insertar un nuevo pedido en la base de datos, obtener todos los pedidos, actualizar un pedido existente y eliminar un pedido de la base de datos.
* `closeConnection()`: Este método cierra la conexión con la base de datos.

### Clase `HashMapUserStorage`

La clase `HashMapUserStorage` implementa la interfaz `UserStorage` utilizando un `HashMap` para almacenar pares de nombre de usuario y contraseña.

### Métodos:

* `getPassword(String username)`: Este método toma un nombre de usuario como argumento y devuelve la contraseña correspondiente almacenada en el `HashMap`.

### Clase `Main`

La clase `Main` es la clase principal del programa. Contiene el método `main`, que inicia el programa y proporciona un menú interactivo para que los usuarios inicien sesión, creen, actualicen y eliminen pedidos, y procesen pagos.

### Clase `OrderManager`

La clase `OrderManager` gestiona la creación, actualización, eliminación e impresión de pedidos. Utiliza un objeto `DataBaseManager` para interactuar con la base de datos y un objeto `Authenticator` para autenticar a los usuarios.

### Métodos:

* `createOrder(String username, String direccion, String pizza, int cantidad)`: Este método crea un nuevo pedido después de verificar la autenticación del usuario y la validez de los datos del pedido.
* `updateOrder(int orderId, String nuevaDireccion, String nuevaPizza, int nuevaCantidad)`: Este método actualiza un pedido existente después de verificar la autenticación del usuario y la existencia del pedido.
* `deleteOrder(int orderId)`: Este método elimina un pedido existente después de verificar la autenticación del usuario y la existencia del pedido.
* `printAllOrders()`: Este método imprime todos los pedidos almacenados en la lista de pedidos.

### Interfaz `PaymentProcessor`

La interfaz `PaymentProcessor` define un método para procesar pagos.

### Interfaz `UserStorage`

La interfaz `UserStorage` define un método para obtener la contraseña de un usuario dado su nombre de usuario.
