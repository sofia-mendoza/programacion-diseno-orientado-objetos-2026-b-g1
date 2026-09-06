# CONFIG
**FULL_NAME:** Sofía Mendoza  
**GITHUB_USER:** sofia-mendoza

# Actividad Semana 05 - Clase Integradora Corte 1

## Definición de la Invariante
La clase Termostato modela un dispositivo de control térmico que opera bajo la siguiente invariante de dominio:

Rango Permitido: La temperatura asignada o calculada del termostato siempre debe mantenerse entre 10.0 °C y 30.0 °C (ambos inclusive).

Protección: Esta regla es inviolable desde el nacimiento del objeto (constructores) y en todas las transiciones de estado (subirTemperatura y bajarTemperatura).

## Decisiones de Diseño
Identidad Inmutable: El atributo id está declarado como private final. No posee método setter, garantizando que la identidad del termostato no sea alterada.

Operaciones de Dominio en lugar de Setters: Se eliminó el setTemperatura() para evitar asignaciones arbitrarias. Las modificaciones se hacen mediante métodos explícitos (subirTemperatura, bajarTemperatura) que validan la invariante antes de aplicar el cambio.

Delegación de Constructores: Se usó this() en el constructor secundario para centralizar la validación en el constructor completo.

Garantía de Iguales: Los métodos equals() y hashCode() dependen exclusivamente del atributo id, asegurando que dos instancias con la misma identidad no coexistan en estructuras como HashSet.