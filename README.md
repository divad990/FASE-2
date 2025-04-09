# 📌 Plan de Desarrollo - Fase 2 y 3

## 📂 Estructura del Proyecto

### 🔹 ED (Entornos de Desarrollo)
- Crear la estructura necesaria en **GitHub** para trabajar en el desarrollo del proyecto.
- Crear el **Diagrama de Clases** en *Visual Paradigm*.
- Crear el **Diagrama de casos de uso** en *Visual Paradigm*.

### 🔹 BD (Base de Datos)
- **Diagrama MER**: Debe ser coherente y respetar el enunciado. Todo aquello que no pueda ser representado en el modelo debe estar comentado. Ejemplo: la restricción de que un equipo tenga como máximo 6 miembros no puede ser modelada, por lo que se anotará y se tratará más adelante.
- **Modelo Relacional**: Debe ser coherente con el modelo entidad-relación y reflejar todas las restricciones.

### 🔹 PG (Programación)
#### **Fase 1: Inscripción**
- 🔄 Login básico (Admins podrán hacer CRUD general, cerrar etapa inscripción, generar calendario, introducir resultados de enfrentamientos, ver todos los informes) (Usuarios podrán visualizar informe de relación de equipos que conforman la competición, visualizar informe correspondiente a resultados de la última jornada)
- 🔄 CRUD Jugadores
- 🔄 CRUD Equipos
- 🔄 Gestionar restricciones. (BD)
- 🔄 Generar jornadas y enfrentamientos, almacenarlos.

### **Fase 1.2: Inscripción BD**

- ✅ Crear script sql y crear la base de datos
- 🔄 Procedimiento almacenado en la base de datos, que permita después en Java, ver el
informe de la relación de los equipos que conforman la competición incluyendo para
cada equipo el nombre del mismo, la fecha de creación, la cantidad de jugadores que
hay en ese equipo, el salario máximo, el salario mínimo y la media de los salarios de los
jugadores de ese equipo. Las excepciones serán visualizadas en el programa Java.
- 🔄 Procedimiento almacenado en la base de datos, que permita después en Java, ver el
informe con la relación de los jugadores de un equipo concreto. De cada jugador se
verá el nombre, apellido, rol y salario. El nombre del equipo le llegará como
parámetro. Las excepciones serán visualizadas en el programa Java.
- 🔄 Triggers
✅1. Asegurar que el salario de los jugadores cumple el enunciado.
✅2. Controlar que no haya más de 6 jugadores en un equipo.
🔄3. Antes de generar el calendario de una competición, garantizar que todos los
      equipos tienen un mínimo de dos jugadores.
🔄4. Controlar que una vez generado el calendario de la competición, no se pueden
    modificar, ni los equipos, ni los jugadores de cada equipo.
-🔄 Bloque anónimo pruebas: Script que contenga todos los procedimientos PL/SQL anónimos
destinados a probar la funcionalidad de los procedimientos almacenados y
funciones. Cada procedimiento anónimo debe tener un comentario explicando el
procedimiento que está probando y dónde se utiliza en la aplicación Java.


#### **Fase 2: Campeonato**
-🔄 Aplicar restricciones:
  1. El número de equipos debe ser par.
  2. Los equipos están formados por **6 jugadores**.
  3. El **salario mínimo** tiene que ser mayor al SMI.
  4. La competición será **todos contra todos**, generando un calendario de enfrentamientos.
  5. **Una jornada por semana**, los enfrentamientos de cada jornada se jugarán en un día.
  6. No se podrán generar jornadas con equipos de menos de **2 jugadores**.
  7. Una vez generado el calendario de una competición, **se cerrará la Fase 1**.

#### **Fase 3: Entorno gráfico**
-🔄 Desarrollo del entorno gráfico de la aplicación siguiendo la estructura MVC.

#### **Fase 4: Pruebas y documentación**
-🔄 Utilizando el JUnit generar pruebas para comprobar el código creado.

## 📌 Entregables
- 📜 **Diagrama de Clases** *(GitHub)*
- 💻 **Código del Proyecto** *(GitHub)*
- 📊 **MER (Modelo Entidad-Relación)** *(GitHub)*
- 🔗 **MR (Modelo Relacional)** *(GitHub)*

- 🧾**Pruebas documentdas** *(GitHub)*
- 📃**Documentación del código** *(GitHub - URL)*
- 💻**Código del proyecto** *(GitHub)*
- ➿**Script SQL estructura** *(GitHub)*
- ➿**Script SQL inserción** *(GitHub)*
- ➿**Script SQL triggers** *(GitHub)*
- ➿**Script SQL prueba triggers** *(GitHub)*
- ♻️**Script PL/SQL procedimientos y fucniones** *(GitHub)*
- ♻️**Script PL/SQL comprobación procedimientos anon** *(GitHub)*


🔗 **Enlace Trello:** [Fase 2 y 3](https://trello.com/invite/b/67a5fdba23077d7eb9092b51/ATTI11bc185a410123f4e961ff19b7b7448bE6422D45/fase-2)

---

## 👥 Autores

| Área | Responsable |
|-------|-----------------------------|
| **Código** | David González, Iker Hernaez |
| **Bases de Datos** | David González, Gorka Emaldi|
| **Entornos de desarrollo** | David González, Unax González De Langarica |

