function deleteKlant(){
    window.alert("DELETE");
    const naamvandelete = (document.querySelector("#naam1")).textContent;
    let fetchnaam = "restservices/klantbestand/"+ naamvandelete;
    let fetchOptions ={
        method: "DELETE",
        headers: {"Content-type": "application/json"}
    }
    fetch((fetchnaam), fetchOptions)
        .then(function (response) {
            if (response.ok){
                console.log("customer deleted");
                location.reload();
            }
            else if (response.status == 404) console.log("customer not found")
            else console.log("something else happened")
        })
    /*fetch((fetchnaam), {
        method: "DELETE",
        headers: {"Content-type": "application/json"}
            .then(function (response) {
                if (response.ok) {
                    location.replace("calender.html")
                    return response.json();
                } else {
                    window.alert("Wrong username/password")
                    throw "Wrong username/password";
                }
            })
    })*/
}
function zekerWetenDelete(){
    document.getElementById('id01').style.display='block';
    closeForm2();
}

function closeForm2() {
    document.getElementById("klantdetails").style.display = "none";
}
var modal = document.getElementById('id01');
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
