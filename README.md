![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)


# Java EE 🏢 Servlet Web App con Glassfish 🐠

Aplicación web servlet con Java Enterprise y Glassfish, repositorio y setup de una aplicación de `Java EE`.

# Setup 🛠️

**Importante**: Para realizar todo esto se requiere tener la versión **Ultimante** de IntelliJ idea.

Si aún no lo tienes, obtenlo con el [Github Student Pack](https://education.github.com/pack)🐙.

## Recursos 📚

Para crear y ejecutar el proyecto correctamente, se siguió el siguiente [tutorial](https://www.jetbrains.com/help/idea/creating-and-running-your-first-java-ee-application.html) oficial de Jet Brains.

Para evitar conflictos de versiones, se utilizó la versión del [JDK8](https://www.oracle.com/java/technologies/downloads/#java8-windows) de Java y la versión [5.0.1](https://javaee.github.io/glassfish/download) Full Platform de Glassfish.

## Procedimiento ⚙️

Seguir el [tutorial](https://www.jetbrains.com/help/idea/creating-and-running-your-first-java-ee-application.html), a medida que avances verás que algunas cosas son distintas pero no dan mayor problema.
Para empezar, al crear el proyecto en lugar de **Jakarta** es **Java Enterprise.**
Tener mucho cuidado de seleccionar el JDK 1.8

### Instalación de glassfish 🎣

Una vez descargado, solo descomprime en una carpeta (de preferencia lo más cerca de la raíz) y la carpeta que se descomprima es la ruta que indicarás durante todo el proceso para configurar glassfish.

En la sección del tutoria de [Configure GlassFish](https://www.jetbrains.com/help/idea/creating-and-running-your-first-java-ee-application.html#glassfish) muestra en la parte de abajo que debes configurar el archivo `asenv.conf` de la siguiente manera:

```bash
  AS_JAVA="C:\Program Files\Java\jdk1.8.0_341"
```

Sin embargo, si continuas con el tutorial al momento de intentar correr el proyecto te mandará la excepción:

```bash
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "org.glassfish.hk2.api.DynamicConfigurationService.createDynamicConfiguration()" because "dcs" is null
```

🟢 Para solucionarlo, aparte del archivo `asenv.conf` es **IMPORTANTE** que coloques la ruta del `JDK` en el archivo `asenv.bat`(asenv) de la siguiente manera indicando la misma ruta de arriba:

```bash
set AS_JAVA=C:\Program Files\Java\jdk1.8.0_341
```

Con esto ya puedes seguir con el tutorial y ejecutar el programa tranquilamente. ✨

🧠 IntelliGOD 1 - 0 Netbeanzzzz 😴
