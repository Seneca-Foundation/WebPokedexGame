var data = "";

var xhr = new XMLHttpRequest();
xhr.withCredentials = true;

xhr.addEventListener("readystatechange", afterGettingPokemonViaGetIsFinished);

xhr.open("GET", "/pokemonSeconds/");
xhr.setRequestHeader("Content-Type", "application/json");

xhr.send(data);

function afterGettingPokemonViaGetIsFinished() {
    if(this.readyState === 4) {
        console.log(this.responseText);
        var pokemonsAsAnObject = JSON.parse(this.responseText);
        var htmlPlaceToPutPokemon = document.getElementById("pokemon");
        htmlPlaceToPutPokemon.innerText = pokemonsAsAnObject[0].region;
    }
}