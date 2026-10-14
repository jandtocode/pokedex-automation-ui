# language: es

  Característica: Búsqueda de Pokémon por los dos caminos
    Como entrenador Pokémon
    Quiero buscar un Pokémon por su nombre
    Para confirmar su nombre y conocer su evolución

    Esquema del escenario: Buscar un Pokémon y verificar su evolución
      Dado que Ash abre el navegador en la página de la Pokédex
      Cuando busca el Pokémon "<pokemon>"
      Entonces el nombre mostrado corresponde a "<pokemon>"
      Y la evolución mostrada es "<evolucion>"

      Ejemplos:
        | pokemon        | evolucion  |
        | haunter        | Gengar     |
        | Tauros         | Ninguna    |
        | nidoran-macho  | nidorino   |
        | nidoran-hembra | nidorina   |
        | Charmander     | Charmeleon |