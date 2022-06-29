import MijnKlantenService from "src/main/webapp/service/mijnKlantenService.js"

function getKlanten(){
    MijnKlantenService.getKlanten()
    .then((Response) => Response.json())
        .then((Klanten) => {
        Klanten.forEach(
            (Klant) => console.log(Klant)
        )
        }
        )
}