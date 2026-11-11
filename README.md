**Interpolación: Lagrange vs. Diferencias Divididas de Newton**
**Asignatura:** Métodos Numéricos U5.
**Institución:** Instituto Tecnológico Superior de Xalapa.
**Docente:** Víctor Hugo Vásquez Herrera.
**Alumna:** Andrés Garrido Denisse Itzel.

Proyecto en Java que implementa y compara dos formas de construir el polinomio interpolante: el método de Lagrange y el de Diferencias divididas de newton.

## Estructura
```
Interpolacion/
    -README.md
    -src/interpolacion/
        -InterpolacionLagrange.java   # Lagrange 
        -InterpolacionNewton.java     # Tabla de diferencias divididas + evaluación 
        -Main.java                    # Pruebas con nodos propios y comparación
```

## Ejecución rápida

**Desde terminal:**
```bash
cd src
javac interpolacion/*.java
java interpolacion.Main
```
## Datos de prueba (modificables en `Main.java`)
| i | 0 | 1 | 2 | 3 | 4 |
|---|---|---|---|---|---|
| x | 1.0 | 2.0 | 4.0 | 5.0 | 7.0 |
| y | 2.0 | 3.5 | 1.8 | 4.2 | 6.1 |

Punto de evaluación: x = 3.0. Resultado esperado en ambos métodos: **1.98**.

## Descripción de los métodos
 **Lagrange:** P(x) = E yi·Li(x), con Li(x) = Π_{j≠i} (x − xj)/(xi − xj). Evaluación O(n²).
 **Newton:** polinomio en base incremental con coeficientes de la tabla de diferencias divididas. Construcción O(n²), evaluación O(n).

Ambos devuelven el mismo polinomio (único de grado <  n−1); solo cambia su representación y su costo.
