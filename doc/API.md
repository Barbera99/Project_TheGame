# USER
## POST
  - Registrar un usuari. /user/register/
## PUT 
  - Per a poder modificar les dades de l'usuari. /{username}/profile/update
  - Per a donar de baixa un usuari. /{username}/unsubscribe
 
## DELETE
  - Per a eliminar usuari. /{username}/delete

# GAME
## POST
  - Per a quan l'usuari busqui partida, crear-la /game/start
## PUT
  - Quan acabi la partida, guardar el resultat. /{game_id}/end

## GET
  - Per a poder veure les dades d'una partida jugada anteriorment /{game_id}/show
  - Per a poder generar un historial de totes les partides. /{user_id}/games

# CARD
## PUT
  - Per a quan es millori una carta /card/upgrade

## GET
  - Per a poder veure les stats de la carta de l'usuari /card/show{id}
  - Per a poder mostrar la imatge. /card/{id}/image

# STATS
## POST
  - Quan l'usuari es registri, per poder inicialitzar les seves dades per poder després actualitzar-les /stats/{user_id}/create

## PUT
  - Per guardar els resultats de les seves partides i el nivell del usuari /stats/{user_id}/update

## GET
  - Per poder recollir la informació de les stats d'un usuari /stats/{user_id}

# MAP
## GET
  - Per a quan el game comença una ronda poder recollir el mapa que hagi tocat aleatòriament /map/get

# DECK
## POST
  - Quan l'usuari es registri, es crearan les baralles buides per després poder actualitzar-les segons com vulgui /deck/{user_id}/create

## PUT
  - Per a quan l'usuari modifiqui una baralla poder guardarla /{user_id}/{deck_id}/update

## GET
  - Per a quan es vagi a modificar l'usuari li mostri les cartes que conté, i també per a quan comença una partida saber quina baralla està utilitzant l'usuari /{user_id}/{deck_id}

# ACHIVEMENTS
## PUT
  - Per a quan un usuari desbloquegi un assoliment /{user_id}/{achivement_id}/unlock

## GET
  - Per a quan l'usuari vulgui veure els assoliments que ha desbloquejat /{user_id}/{achivement_id}
