function login() {
    let formData = new FormData(document.querySelector("#loginform"))
    let requestData = {
        username: formData.get("username"),
        password: formData.get("password")
    }
    fetch("restservices/authentication", {
        method: "POST",
        body: JSON.stringify(requestData),
        headers: {"Content-type": "application/json"}
    })
        .then(function (response) {
            if (response.ok) {
                location.replace("calender.html")
                return response.json();
            }
            else {
                window.alert("Wrong username/password")
                throw "Wrong username/password";
            }
        })
        .then(myJson => window.sessionStorage.setItem("myJWT", myJson.JWT))
        .catch(error => console.log(error));
}
