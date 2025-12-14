# Armería

Aplicación de Android que muestra una lista de armas y permite realizar operaciones CRUD (Crear, Leer, Actualizar, Borrar) sobre ellas.

## Características

*   **Visualización de armas**: muestra una lista de armas en un `RecyclerView` horizontal.
*   **Añadir arma**: permite añadir una nueva arma a través de un `DialogFragment`.
*   **Editar arma**: permite editar un arma existente a través de un `DialogFragment`.
*   **Borrar arma**: permite borrar un arma de la lista.

## Implementación

### Componentes principales

*   **`MainActivity.kt`**: la actividad principal de la aplicación. Contiene el `RecyclerView` y el botón para añadir nuevas armas. Se comunica con el `Controller` para gestionar los datos.
*   **`Controller.kt`**: se encarga de la lógica de negocio. Gestiona la lista de armas y se comunica con el `Adapter` del `RecyclerView`.
*   **`AdapterArma.kt`**: adaptador para el `RecyclerView` que muestra la lista de armas.
*   **`AddCardFragment.kt`**: `DialogFragment` que se usa para añadir una nueva arma.
*   **`EditCardFragment.kt`**: `DialogFragment` que se usa para editar un arma existente.

### Uso de `DialogFragment`

Para las operaciones de añadir y editar se usan `DialogFragment`. Esto permite mostrar una ventana de diálogo sobre la actividad principal sin interrumpir el ciclo de vida de la misma.

La comunicación entre los `DialogFragment` y la `MainActivity` se realiza a través de interfaces, lo que permite un diseño desacoplado y reutilizable.

### View Binding

Se utiliza View Binding para acceder a las vistas de los layouts de una forma segura y concisa.
