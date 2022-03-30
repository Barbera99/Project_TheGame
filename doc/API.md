# USER
## POST
  - Registrar un usuari. /user/register/
## PUT 
  - Per a poder modificar les dades de l'usuari. /profile/{username}/update
  - Per a poder modificar les dades de l'usuari. /profile/{username}/update
  - 
## DELETE
  - Per a poder donar de baixa un usuari. /{username}/delete

# GAME
## POST
  - Per a quan l'usuari busqui partida, crear-la /game/start
## PUT
  - Quan acabi la ronda, per si hi ha guanyat l'usuari o el contrincant per sumar el marcador corresponen /game/nextround

## GET
  - Per a poder veure les dades d'una partida jugada anteriorment /game/show

# CARD
## PUT
  - Per a quan es millori una carta /card/upgrade

## GET
  - Per a poder veure les stats de la carta de l'usuari /card/show{id}


# STATS
## POST
  - Quan l'usuari es registri, per poder inicialitzar les seves dades per poder després actualitzar-les /stats/create

## PUT
  - Per guardar els resultats de les seves partides i el nivell del usuari /stats/update

## GET
  - Per poder recollir la informació de les stats d'un usuari /stats/show{username}

# MAP
## GET
  - Per a quan el game comença una ronda poder recollir el mapa que hagi tocat aleatòriament /map/get

# DECK
## POST
  - Quan l'usuari es registri, es crearan les baralles buides per després poder actualitzar-les segons com vulgui /deck/create

## PUT
  - Per a quan l'usuari modifiqui una baralla poder guardarla /deck/update

## GET
  - Per a quan es vagi a modificar l'usuari li mostri les cartes que conti, i també per a quan comença una partida saber quina baralla està utilitzant l'usuari /deck/get

# ACHIVEMENTS

## PUT
  - Per a quan un usuari desbloquegi un assoliment /achiv/unlock

## GET
  - Per a quan l'usuari vulgui veure els assoliments que ha desbloquejat /achiv/get

# RANK
## PUT
  - Per a quan un usuari pugi o baixi del rank actualitzar-lo /rank/update

## GET
  - Per a quan un usuari vulgui obtenir el rank d'un usuari en concret /rank/show{username}
