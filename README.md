# Solucionador de Wordle para las palabras en español - Varias estrategias para solucionarlo
Este programa implementa varias estrategias para solucionar el conocido juego "Wordle" o en español "La palabra del día".
Lo más importante de este proyecto es mantener un código limpio, extensible, desacoplado y modular, por lo que se siguen los principios SOLID y se aplican patrones de diseño útiles en el 
día a día de todo programador, como por ejemplo el patrón Strategy.

## Estrategias utilizadas
  - Estrategía aleatoria: Escoge palabras aleatorias entre todas las opciones, sin tener en cuenta ningún feedback, lo que la hace la menos óptima, pero la más divertida si acierta en algún caso.
  - Estrategia simple: Esta representa la manera más humana de pensar. Comienza con la lista completa de todas las palabras y a lo largo que vamos acertando letras, se van reduciendo las opciones válidas.
  - Estrategia óptima: (todavía no implementada)

## Instalación y uso
1 _ Clona el repositorio en tu IDE favorito
2 _ Compila el programa (SDK utilizado: Amazon Corretto 21.0.3)
3 _ Entra en la clase Main y ejecuta el programa a la vez que el juego "La palabra de día" -> https://lapalabradeldia.com/
4 _ Escoge la estrategia que quieras utilizar, pero ten en cuenta que la estrategia aleatoria es, como dice su nombre, MUY aleatoria
5 _ En las demás estrategias habrá que introducir un feedback ("v" si esa posición tiene color verde, "g" si esa posición tiene color gris y "a" si esa posición tiene color amarillo)
