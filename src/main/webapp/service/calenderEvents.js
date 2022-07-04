function getBehandelingen() {
    fetch("restservices/behandelingen")
        .then(Response =>  Response.json())
        .then(data => {
            data.forEach((behandeling) => {
                const klantNaam = behandeling.klant;
                const behandelingType = behandeling.behandelingType;
                const behandelingDatum = behandeling.behandelDatum;
                const beginTijd = behandeling.beginTijd;
                const eindTijd = behandeling.eindTijd;
                addBehandelingToHtml(klantNaam, behandelingType,behandelingDatum, beginTijd, eindTijd)
                /*addBehandelingToHtml(behandelingTitel, tijden);*/
            })
        });
}

function addEvent(){
    /*let formData = new FormData(document.querySelector("#nieuweEventDetails"))
    const eventId = formData.get("eventname") + "1";
    const eventname = formData.get("eventname");
    const eventDescrition = formData.get("eventDescrition");
    const eventDate = formData.get("eventDate");
    const eventType = formData.get("eventType");*/
    window.alert("hier wordt nog gebouwt")
}

function openEventForm(){
    document.getElementById("nieuweEventForm").style.display = "block";
}
function closeForm() {
    document.getElementById("nieuweEventForm").style.display = "none";
}

function openEvents() {
    document.getElementById("behandelingen").style.display = "block";
}

function closeEvents() {
    document.getElementById("behandelingen").style.display = "none";
}



function addBehandelingToHtml(klantNaam, behandelingType,behandelingDatum, beginTijd, eindTijd){
    const tabel = document.querySelector("#behandelingTabel");
    const tabelvoorBehandeling = document.createElement("tr");
    tabelvoorBehandeling.classList.add("dynamischeBehandelingen");
    const tabelnaam = document.createElement("td");
    tabelnaam.innerText = klantNaam + " : " + behandelingType;
    const datumString = behandelingDatum[2] + "/"+ behandelingDatum[1] + "/"+ behandelingDatum[0];
    const legerow = document.createElement("td");
    const tabeltijd = document.createElement("td");
    const nieuweBeginTijd = beginTijd.slice(0,2);
    const nieuweEindTijd = eindTijd.slice(0,2);
    const beginTijdString = nieuweBeginTijd[0] + ":" + nieuweBeginTijd[1];
    const eindTijdString = nieuweEindTijd[0] + ":" + nieuweEindTijd[1];
    tabeltijd.innerText = datumString + " : van " + beginTijdString + " tot " + eindTijdString;
    legerow.innerText = "|";
    tabelvoorBehandeling.appendChild(tabelnaam);
    tabelvoorBehandeling.appendChild(legerow);
    tabelvoorBehandeling.appendChild(tabeltijd);
    tabel.appendChild(tabelvoorBehandeling);
}
getBehandelingen();