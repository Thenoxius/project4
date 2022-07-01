function getKlanten() {
    fetch("restservices/klantbestand")
        .then(Response =>  Response.json())
        .then(data => {
            data.forEach((klant) => {
                const naam = klant.naam;
                const geboorteDatum = klant.geboorteDatum;
                const telefoonNummer = klant.telefoonNummer;
                const straat =  klant.straat;
                const woonPlaats = klant.woonPlaats;
                const postcode = klant.postcode;
                const wrappergrid = document.querySelector("wrapper-grid");
                addKlantToHtml(naam, geboorteDatum, telefoonNummer, straat, woonPlaats, postcode, "klant-container");
            })
        });
}

function addKlantToHtml(naam, geboortedatum, telefoonNummer, straat, woonPlaats, postcode, divclass){
    const newDiv = document.createElement("div");
    const newFragment = document.createDocumentFragment();
    const breakElement = document.createElement("br");
    /*per klant attribuut maak ik een constant aan die ik in de nieuwe fragment zet deze voeg ik uiteindelijk aan de div toe  */
    const naamVanKlant = document.createElement('h1');
    naamVanKlant.textContent = naam;
    naamVanKlant.classList.add("klantennaam")
    newFragment.appendChild(naamVanKlant);
    newFragment.appendChild(breakElement);
    const bannerImage = document.createElement("div")
    bannerImage.classList.add("bannerimage")
    newDiv.appendChild(bannerImage);

    const profilepic = document.createElement("img")
    profilepic.classList.add("profile-img")
    newDiv.appendChild(profilepic);

    const button = document.createElement("button")
    button.classList.add("klantenbutton")
    button.innerHTML = "Details"
    button.onclick = function () {
        alert("Button is clicked");
    };

    newDiv.appendChild(newFragment);
    newDiv.appendChild(button);
    newDiv.classList.add(divclass);
    console.log(newDiv);
    const incontainer = document.querySelector(".wrapper-grid")
    console.log(incontainer);
    incontainer.appendChild(newDiv);
}
getKlanten();