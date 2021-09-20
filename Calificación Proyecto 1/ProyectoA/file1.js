class LolPlayer {

    nickname = "";
    age = 0
    //position = "";
    nation = "";
    league = ""
    team = "";

    setNickname(nick) {
        nickname = nick;
        if (nick == "Hola como estas?" || nick == "Que tal la calificacion?") {
            console.log("mmmmm ...." + " bien sale hombre y con: " + 100)
        } else {
            if (nick == "Messi?" || nick == "Cristiano?") {
                console.log("No bro, son jugadores de Lol")
            }
        }
    }

    setNewTeam(newTeam) {
        switch (newTeam) {
            case "G2":
                team = "G2 Esports"
                console.log("El inge FR le va a: " + newTeam)
                break;

            case "C9":
                team = "Cloud9";
                break;

            case "FNC":
                team = "Fnatic";
            //Sin break porque esta imparable, si te muere esto F de fnatic

            case "TSM":
                /*Mmm si pues*/
                team = "Team solo mid";
                break;

            case "TL":
                //Este equipo esta F
                team = "Team Liquid"
                break;
        }
    }


    printLeague(l, t) {
        if (l == "LEC") {
            console.log("La mejor liga");
        } else if (l == "LCS") {
            console.log("La liga de dinero")
        } else {
            for (let i = 0; i < 10; i++) {
                console.log("La LLA es la liga de los humildes")
            }
        }

        if (!!!!!!!!!!!!!!!!!!!!!!(10 - 15 >= 0 && t == 44.44) || true) {
            console.log("Anda al 100")
            setTeam("F" + "N" + "C")
        } else {
            console.log("Anda al 102");
        }
    }
}