export default class MijnKlantenService {

    getKlanten() {
        return fetch("restservices/klantbestand", {
                method: "GET",
                body: JSON.stringify(requestData),
                headers: {"Content-type": "application/json"}
            }
        )
    }
}