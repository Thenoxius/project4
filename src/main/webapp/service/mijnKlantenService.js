function getKlanten() {
    fetch("restservices/klantbestand")
        .then(Response =>  Response.json())
        .then(data => {
            data.forEach((klant) => {
                const naam = klant.naam;
                addKlantToHtml(naam, "klant-container");
            })
        });
}
function getKlantDetails(naam){
    console.log("detail functie wordt aangeroepen")
    let fetchnaam = "restservices/klantbestand/"+ naam;
    fetch((fetchnaam))
        .then(Response =>  Response.json())
        .then(data => {
            const naam = data.naam;
            const geboorteDatum = data.geboorteDatum;
            const telefoonNummer = data.telefoonNummer;
            const straat =  data.straat;
            const woonPlaats = data.woonPlaats;
            const postcode = data.postcode;
            document.getElementById("klantdetails").style.display = "block";
            const naamdeel = document.querySelector("#naam1");
            naamdeel.innerHTML = naam;

            const geboortedatumdeel = document.querySelector("#geboortedatum2");
            geboortedatumdeel.innerHTML = geboorteDatum;

            const telefoonNummerdeel = document.querySelector("#telefoonnummer2");
            telefoonNummerdeel.innerHTML = telefoonNummer;

            const straatdeel = document.querySelector("#straat2");
            straatdeel.innerHTML = straat;

            const woonPlaatsdeel = document.querySelector("#woonplaats2");
            woonPlaatsdeel.innerHTML = woonPlaats;

            const postcodedeel = document.querySelector("#postcode2");
            postcodedeel.innerHTML = postcode;

        })
}

function addKlantToHtml(naam, divclass){
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
    bannerImage.alt = "bannerimg";
    newDiv.appendChild(bannerImage);

    const profilepic = document.createElement("img")
    profilepic.classList.add("profile-img")
    newDiv.appendChild(profilepic);

    const button = document.createElement("button")
    button.classList.add("klantenbutton")
    /* ik maak per klant een unieke button id aan met hun naam zodat ik deze persoonlijke onclickfuncties kan geven */
    let buttonnaam = naam + "-button";
    button.id = buttonnaam;
    button.innerHTML = "Details"
    button.onclick = () => getKlantDetails(naam);
    newDiv.appendChild(newFragment);
    newDiv.appendChild(button);
    newDiv.classList.add(divclass);
    console.log(newDiv);
    const incontainer = document.querySelector(".wrapper-grid")
    console.log(incontainer);
    incontainer.appendChild(newDiv);
}

/*
function showKlantDetails(naam, geboorteDatum, telefoonNummer, straat, woonPlaats, postcode){
    document.getElementById("klantdetails").style.display = "block";
    const naamdeel = document.querySelector("#naam1");
    naamdeel.innerHTML = naam;

    const geboortedatumdeel = document.querySelector("#geboortedatum2");
    geboortedatumdeel.innerHTML = geboorteDatum;

    const telefoonNummerdeel = document.querySelector("#telefoonnummer2");
    telefoonNummerdeel.innerHTML = telefoonNummer;

    const straatdeel = document.querySelector("#straat2");
    straatdeel.innerHTML = straat;

    const woonPlaatsdeel = document.querySelector("#woonplaats2");
    woonPlaatsdeel.innerHTML = woonPlaats;

    const postcodedeel = document.querySelector("#postcode2");
    postcodedeel.innerHTML = postcode;
}*/
getKlanten();