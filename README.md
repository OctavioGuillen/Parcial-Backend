# Parcial-Backend
Instrucciones de ejecución del proyecto:
1. Clonar el Proyecto desde GitHub
Ve al repositorio de GitHub del proyecto.
Haz clic en el botón verde "Code" y copia la URL del repositorio (debe tener el formato https://github.com/usuario/proyecto.git).
Abre IntelliJ IDEA y selecciona File > New > Project from Version Control.
En el cuadro de diálogo, pega la URL y selecciona una carpeta local donde se clonará el proyecto.
Haz clic en Clone para descargar el proyecto en tu equipo.
2. Importar el Proyecto en IntelliJ IDEA
Una vez clonado, IntelliJ IDEA debería reconocer el proyecto como un proyecto de Gradle.
IntelliJ te pedirá automáticamente que lo importes. Asegúrate de hacer clic en Import Gradle Project.
Espera a que IntelliJ complete la sincronización. Esto puede tardar unos minutos, dependiendo de la cantidad de dependencias que necesite.
3. Ejecutar el Proyecto
Busca la clase principal del proyecto que contiene el método main().
Haz clic derecho sobre esta clase y selecciona Run o selecciona la opción Run en la barra superior de IntelliJ.
Spring Boot iniciará el servidor embebido y lanzará la aplicación.
4. Verificar la Ejecución
Una vez que el servidor se haya iniciado correctamente, abre tu navegador y navega a http://localhost:8080 (o el puerto que esté configurado en el archivo de propiedades) para verificar que la aplicación está corriendo.
Usa Postman para probar las rutas (endpoints) de la API.
