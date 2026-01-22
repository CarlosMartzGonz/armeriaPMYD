# Armería - Aplicación Android

Aplicación para gestión y visualización de armas desarrollada en Kotlin para Android.

## 📱 Características
- **Login de usuarios**: Sistema de autenticación con credenciales predefinidas
- **Catálogo de armas**: Listado completo con imágenes y detalles
- **CRUD completo**: Crear, Leer, Actualizar y Eliminar armas
- **Navegación intuitiva**: Bottom Navigation y Navigation Drawer (comparten destinos)
- **Perfil de usuario**: Información personal con estadísticas
- **Diálogos interactivos**: Para añadir y editar armas

## 🧭 Navegación y Drawer (nota importante)
- El `Navigation Drawer` y el `BottomNavigationView` comparten los mismos destinos principales (Inicio / Perfil / Ajustes) para mantener coherencia de navegación.
- Cambio reciente: `settingsFragment` (Ajustes) **ya no** está declarado como destino top-level en `AppBarConfiguration` (ver `MainActivity.kt`).
  - Consecuencia: al navegar a **Ajustes** ahora aparecerá la flecha de retroceso en la AppBar y la navegación considerará ese destino como no top-level.
  - Razón: los items del menú de opciones (`menu_settings`, `menu_about`) deben actuar como destinos no top-level según los requisitos del ejercicio; por eso `settingsFragment` se ha removido del conjunto top-level.
- Logout sigue accesible desde Drawer y desde el menú de opciones y redirige a `LoginActivity`.

## 📂 Estructura del Proyecto
com/example/armeria/
├── MainActivity.kt # Actividad principal
├── LoginActivity.kt # Pantalla de login
├── HomeFragment.kt # Listado de armas
├── DetailFragment.kt # Detalles de arma
├── ProfileFragment.kt # Perfil de usuario
├── adapter/ # Adaptadores RecyclerView
├── controller/ # Controladores de lógica
├── dao/ # Objetos de acceso a datos
├── models/ # Modelos de datos
├── objects_models/ # Repositorios y sesión
└── dialogs/ # Diálogos personalizados

## 🚀 Instalación
1. Clona el repositorio
2. Abre el proyecto en Android Studio
3. Sincroniza las dependencias de Gradle
4. Ejecuta en un emulador o dispositivo con Android 7.0+

## 🔑 Credenciales de Prueba
Usuario: admin
Contraseña: 1234

Usuario: usuario
Contraseña: 0000

## 📖 Uso de la Aplicación
1. **Login**: Introduce tus credenciales
2. **Explorar**: Navega por el catálogo de armas
3. **Añadir**: Usa el botón flotante (+) para crear nuevas armas
4. **Editar/Eliminar**: Toca los botones en cada tarjeta
5. **Detalles**: Haz clic en cualquier arma para ver información completa
6. **Perfil**: Accede a tu información desde el menú lateral

## 🔧 Configuración Técnica
- **compileSdkVersion**: 36
- **minSdkVersion**: 24
- **targetSdkVersion**: 36
- **ViewBinding**: Habilitado
- **SafeArgs**: Configurado para navegación segura

## 📚 Dependencias Principales
- androidx.navigation:navigation-fragment-ktx
- com.github.bumptech.glide:glide
- com.google.android.material:material
- androidx.constraintlayout:constraintlayout

## 👤 Autor
**Carlos MG**
