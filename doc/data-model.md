![Diagrama_Base_de_Dades drawio (2)](https://user-images.githubusercontent.com/99675044/158834366-c2b95f44-06a3-43cc-9b36-919065334232.png)


El nostre model compta amb les següents classes:
  - User: Aquesta és una de les classes principals del nostre aplicatiu, compta amb un seguit d'atributs necessaris sobre un usuari i a més a més compta amb diverses       relacions.
  - User: Aquesta classe compta amb un seguit d'atributs necessaris sobre un usuari.
  - UserToken: Aquesta classe conté el token i la id de l'usuari al qual pertany aquest.
  - Game: Aquesta classe conté els usuaris que juguen la partida, la seva puntuació, la ronda en la qual estan i la data d'aquesta.
  - Round: Aquesta classe conté el mapa de la ronda actual, les cartes utilitzades pels usuaris en aquesta i el número de ronda total de la partida.
  - Map: Aquesta classe conté el nom del mapa, l'atribut, l'extra i el tipus.
  - Rank: Aquesta classe conté l'usuari del qual és el rank, el seu tier, lliga, grup i posició.
  - Stats: Aquesta classe conté les partides jugades, victòries i derrotes de partides no classificatòries i classificatòries i l'usuari del qual són aquestes.
  - Card: Aquesta classe conté els atributs necessaris d'una carta.
  - Deck: Aquesta classe conté les diferents cartes que formen una baralla.

El nostre model compta amb les següents relacions:
  - User (N) i Game (1): Aquesta relació és u N a 1, ja que un usuari només pot jugar una partida simultàniament i una partida pot ser jugada per 1 o més usuaris.
  - User (1) i UserToken (N): Aquesta relació és 1 a 1, ja que un usuari pot tenir més d'un token, però un mateix token només pot pertànyer a 1 usuari.
  - User (1) i Rank (N): Aquesta relació és 1 a N, ja que un usuari te només un rank i un rank pot tenir diversos usuaris.
  - User (N) i Stats (1): Aquesta relació és 1 a 1, ja que 1 usuari només té 1 propi stat i un stat en concret només forma part d'un usuari.
  - Game (N) i Map (N): Aquesta relació és N a N, ja que una partida compta amb diversos mapes i un mapa pot estar en diverses partides. Al ser N a N, hem de crear una     taula intermèdia, on guardarem com a FK id_Game i id_Map.
  - User (N) i Achivements (N): Aquesta relació és N a N, ja que un usuari pot assolir més d'un achivement i un achivement pot ser adquirida per diversos usuaris. Al ser    N a N, hem   de crear una taula intermitja, on guardarem com a FK id_User i id_Card.
  - User (N) i Card (N): Aquesta relació és N a N, ja que un usuari pot ser propietari d'una o més cartes i una carta pot ser assolit per diversos usuaris. Al ser N a N,   hem de crear una taula intermitja, on guardarem com a FK id_User i id_Achivement.
  - User (1) i Deck (N): Aquesta relació és 1 a N, ja que un usuari pot tenir diferents baralles, tanmateix una baralla només forma part d'un usuari.
  - Deck (N) i Card (1): Aquesta relació és N a 1, ja que una baralla només pot tenir una carta una única vegada i una carta pot estar en diferents baralles.
  
