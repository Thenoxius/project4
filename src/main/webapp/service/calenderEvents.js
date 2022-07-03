function addEvent(){
    const eventId = null;
    const eventname = null;
    const eventDescrition = null;
    const eventDate = null;
    const eventType = null;
    $('#calendar').evoCalendar('addCalendarEvent', {
        id: 'kNybja6',
        name: 'Mom\'s Birthday',
        description: 'Lorem ipsum dolor sit..',
        date: 'May 27, 2020',
        type: 'birthday'
    });
}

function openEventForm(){
    document.getElementById("nieuweEventForm").style.display = "block";
}
function closeForm() {
    document.getElementById("nieuweEventForm").style.display = "none";
}