![Diagrama_Base_de_Dades](https://user-images.githubusercontent.com/99675044/158231038-0876ab24-8356-4372-abe8-a9bf533ad634.png)

El nostre model compta amb les següents classes:
  - User: Aquesta és una de les classes principals del nostre aplicatiu, compta amb un seguit d'atributs necessaris sobre un usuari i a més a més compta amb diverses relacions.
  - User (N) i Game (1): Aquesta relació és u N a 1, ja que un usuari només pot jugar una partida simultàniament i una partida pot ser jugada per 1 o més usuaris. El nostre model   compta amb les següents classes:
  - User: Aquesta classe compta amb un seguit d'atributs necessaris sobre un usuari.
  - UserToken: Aquesta classe conté el token i la id de l'usuari al qual pertany aquest.
  - Game: Aquesta classe conté els usuaris que juguen la partida, la seva puntuació, la ronda en la qual estan i la data d'aquesta.
  - Round: Aquesta classe conté el mapa de la ronda actual, les cartes utilitzades pels usuaris en aquesta i el número de ronda total de la partida.
  - Map: Aquesta classe conté el nom del mapa, l'atribut, l'extra i el tipus.
  - Rank: Aquesta classe conté l'usuari del qual és el rank, el seu tier, lliga, grup i posició.
  - Stats: Aquesta classe conté les partides jugades, victòries i derrotes de partides no classificatòries i classificatòries i l'usuari del qual són aquestes.
  - Collection: Aquesta classe conté la id de la baralla, la carta i l'usuari del qual formen part aquestes.
  - Card: Aquesta classe conté els atributs necessaris d'una carta.
  - Deck: Aquesta classe conté les diferents cartes que formen una baralla.

El nostre model compta amb les següents relacions:
  - User (N) i Game (1): Aquesta relació és u N a 1, ja que un usuari només pot jugar una partida simultàniament i una partida pot ser jugada per 1 o més usuaris.
  - User (1) i UserToken (N): Aquesta relació és 1 a 1, ja que un usuari pot tenir més d'un token, però un mateix token només pot pertànyer a 1 usuari.
  - User (1) i Rank (1): Aquesta relació és 1 a 1, ja que un usuari te només un rank i un rank amb un tier, lliga, grup i posició en concret, només hi ha 1 usuari.
  - User (N) i Stats (1): Aquesta relació és 1 a 1, ja que 1 usuari només té 1 propi stat i un stat en concret només forma part d'un usuari.
  - Game (1) i Round (N): Aquesta relació és un 1 a N, ja que una partida està formada per diverses rondes, però una ronda només pot formar part d'una partida, és a dir, no poden     haver-hi 2 rondes amb la mateixa Id a diferents partides.
  - Round (1) i Map (1): Aquesta relació és 1 a 1, ja que una ronda està formada per un mapa i un mapa només es pot repetir en una altra ronda.
  - Collection (1) i User (1): Aquesta relació és 1 a 1, ja que una col·lecció només pot tenir un usuari com a propietari i un usuari és propietari d'una única col·lecció.
  - Collection (1) i Card (1): Aquesta relació és 1 a N, ja que 1 col·lecció pot tenir diverses cartes, però una carta no pot estar més d'una vegada en una col·lecció, és a dir no   pot estar repetida.
  
