function voegKlantToe(){
    let formData = new FormData(document.querySelector("#nieuweKlantenDetails"))
    console.log(formData);

    let requestData = {
        naam: formData.get("naam"),
        geboortedatum: formData.get("geboortedatum"),
        telefoonnummer: formData.get("telefoonnummer"),
        straat: formData.get("straat"),
        postcode: formData.get("postcode"),
        woonplaats: formData.get("woonplaats")
    }
    console.log(requestData.geboortedatum);
    fetch("restservices/authentication", {
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