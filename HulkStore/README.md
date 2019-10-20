# Inventario y Ventas HulkStore con Spring-boot
 Un sistema de ventas usando Java, Spring MVC-DAO, Postgres y Bootstrap

# Tutorial

Si quieres puedes clonar el repositorio.

Clonar repositorio: https://github.com/desarrollomarquez/Proyecto_InventarioVentas.git

[instalar gradle](instalar-configurar-gradle con eclipse), 
[Postgres o H2]( configurar-instalar-postgres en tu maquina-windows)
[Java](instalar-configurar-jdk-compilador-java-windows/);
todo lo necesario para programar con Spring Boot y Postgres.

Ejecuta el programa con:

`gradlew bootRun`

Y crea el jar usando:

`gradlew build`

visita _http://localhost:8050/productos/mostrar.

No olvides que dejo el codigo fuente en [GitHub](https://github.com/desarrollomarquez/Proyecto_InventarioVentas.git).


## Tu propio application.properties para Inventario y Ventas HulkStore  con Spring Boot

Si mi contraseña, usuario o configuración no son acorde a tus requisitos recuerda que siempre puedes crear un archivo llamado `application.properties` en el **mismo directorio** en donde está el jar, así, será tomado en cuenta ese archivo en lugar del mío.

Nota//: Recuerda antes de iniciar el proyecto crea la base de datos en postgres, para que pueda ser persistida con el JPA.