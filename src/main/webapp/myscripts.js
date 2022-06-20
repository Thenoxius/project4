function login() {
    let formData = new FormData(document.querySelector("#loginform"))
    let jsonRequestBody = {}
    formData.forEach((value, key) => jsonRequestBody[key] = value);
    console.log(jsonRequestBody);
    fetch("restservices/authentication", {method: "POST", body: jsonRequestBody})
        .then(function (response){
            if (response.ok) return response.json();
            else throw "Wrong username/password";
        })
        .then(myJson => window.sessionStorage.setItem("myJWT", myJson.JWT))
        .catch(error => console.log(error));
}
