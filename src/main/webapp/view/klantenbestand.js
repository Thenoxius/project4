
function naarCalender() {
    location.replace("calender.html");
}
function logout() {
    window.sessionStorage.setItem("myJWT", null);
    location.replace("index.html");
}
function openForm() {
    document.getElementById("nieuweKlantenForm").style.display = "block";
}
function closeForm() {
    document.getElementById("nieuweKlantenForm").style.display = "none";
}
