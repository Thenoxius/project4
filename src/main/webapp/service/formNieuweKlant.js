function voegKlantToe(){
    let formData = new FormData(document.querySelector("#nieuweKlantenDetails"))
    console.log(formData);

    let requestData = {
        naam: formData.get("naam"),
        geboorteDatum: formData.get("geboortedatum"),
        telefoonNummer: formData.get("telefoonnummer"),
        straat: formData.get("straat"),
        postcode: formData.get("postcode"),
        woonPlaats: formData.get("woonplaats")
    }
    console.log(JSON.stringify(requestData));
    fetch("restservices/klantbestand", {
        method: "POST",
        body: JSON.stringify(requestData),
        headers: {"Content-type": "application/json"}
    })
        .then(function (response) {
            if (response.ok) {
                console.log(response);
                /*location.replace("klantbestand.html")*/
                return response.json();
            }
            else {
                window.alert("Klant kan niet aangemaakt worden")
                throw "Klant kan niet aangemaakt worden";
            }
        })
}