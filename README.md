# mcs-ricky 
api para prestamo de  libros 

** Requisitos **
Se usa java 21
Maven 3

postgres

 descargar libreria libreria  
 https://github.com/juliaosistem/maven-lib-common

una vez bajada la ramma master ejecutar mvn install 




# Arquitectura

Se usa una arquitectura hexagonal separando reponsabilidades 
donde se definen  2 pagetes  importantes  


**paquete primary**

com.juliaosystem.infrastructure.adapters.primary
Este se encarga de implementar toda la logica de negocio

**paquete secundary**
Este se encarga de interactuar con la base de datos

com.juliaosystem.infrastructure.adapters.secondary


 adjunto imagen 

 ![Texto alternativo](https://github.com/Farius-red/rick-mortyPrueba/blob/master/imgDocumentacion/Arquitectura.png)



## Proceso de installacion y ejecucion sin ide

**paso 1**  descargar repositorio comm lib 
   https://github.com/juliaosistem/maven-lib-common

**paso 2**  instalar maven 

**paso 3**  instalar en maquina local jdk 21

**paso 4**    ir ala carpeta  donde se descargo maven-lib-common 
 y entrar mcs-libreria desde la terminal 

**paso 5**  ejecutar mvn clean  install 


**paso 6** ya con esto clonar el repositorio de la pruba 


**paso 7**  ubicarse en la consola en la carpeta prueba

**paso 8**  ejecutar mvn clean  install 

**paso 9**  copiar la ruta donde se instala el jar que genera para ubicarse hay desde la terminal  

**paso 10**  ejecutar 
  java -jar aquiIriaNombreDeJarGenerado.jar


 

 **paso 11**
  

ir a google y poner esta url
http://localhost:8080/documentacion

aquie podra ver la interfax de swagger 


