# 📌 Plan de Desarrollo - Fase 2

## 📂 Estructura del Proyecto

### 🔹 ED (Entornos de Desarrollo)
- Crear la estructura necesaria en **GitHub** para trabajar en el desarrollo del proyecto.
- Crear el **Diagrama de Clases** en *Visual Paradigm*.

### 🔹 BD (Base de Datos)
- **Diagrama MER**: Debe ser coherente y respetar el enunciado. Todo aquello que no pueda ser representado en el modelo debe estar comentado. Ejemplo: la restricción de que un equipo tenga como máximo 6 miembros no puede ser modelada, por lo que se anotará y se tratará más adelante.
- **Modelo Relacional**: Debe ser coherente con el modelo entidad-relación y reflejar todas las restricciones.

### 🔹 PG (Programación)
#### **Fase 1: Inscripción**
- ✅ Almacenar jugadores.
- ✅ Almacenar equipos.
- 🔄 Gestionar la relación equipo-jugador.
1. Hacer que solo se pueda meter una vez cada jugador
2. Mostrar mejor la lista de jugadores
3. Mirar si se puede meter dentro del crear equipo una redirección al método exclusivo para introducir jugadores
- 🔄 Gestionar restricciones.
- 🔄 Generar jornadas y enfrentamientos, almacenarlos.

#### **Fase 2: Campeonato**
- 🔄 Aplicar restricciones:
  1. El número de equipos debe ser par.
  2. Los equipos están formados por **6 jugadores**.
  3. El **salario mínimo** tiene que ser mayor al SMI.
  4. La competición será **todos contra todos**, generando un calendario de enfrentamientos.
  5. **Una jornada por semana**, los enfrentamientos de cada jornada se jugarán en un día.
  6. No se podrán generar jornadas con equipos de menos de **2 jugadores**.
  7. Una vez generado el calendario de una competición, **se cerrará la Fase 1**.

- **Codificación**:
  - Implementar el **Diagrama de Clases** en código. *(2H)*
  - Implementar **alta, baja y modificación** de equipos y jugadores de la competición. *(6H)*
  - Generación de **jornadas y enfrentamientos** en Java. *(1H)*

## 📌 Entregables
- 📜 **Diagrama de Clases** *(GitHub)*
- 💻 **Código del Proyecto** *(GitHub)*
- 📊 **MER (Modelo Entidad-Relación)** *(GitHub)*
- 🔗 **MR (Modelo Relacional)** *(GitHub)*

🔗 **Enlace Trello:** [Fase 2](https://trello.com/invite/b/67a5fdba23077d7eb9092b51/ATTI11bc185a410123f4e961ff19b7b7448bE6422D45/fase-2)

---

## 👥 Autores

| Área | Responsable |
|-------|-----------------------------|
| **Código** | David González, Iker Hernaez |
| **Bases de Datos** | David González |
| **Diagrama de Clases** | David González, Unax González De Langarica |

