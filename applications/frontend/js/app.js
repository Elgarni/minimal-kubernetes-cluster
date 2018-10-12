// Backend Endpoints info
var SERVER_BASE_URL = "api";
var TIME_ENDPOINT_PATH = "/now";
var NUMBER_OF_REQUESTS_PATH = "/requestsCount";

// Start the app by registering callback functions to hit backend endpoints
function startApp() {
    setInterval(function () {
        getTimeFromServer();
    }, 1000);

    setInterval(function () {
        getTotalNumberOfRequests();
    }, 2000)
}

// GET total number of requests made to the server
function getTotalNumberOfRequests() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        var count = null;
        if (this.readyState === 4 && this.status === 200) {
            count = JSON.parse(this.responseText).count;
        }
        if (count != null)
            setHTMLObjectValueById("requests_number", count);
    };
    xhttp.open("GET", SERVER_BASE_URL + NUMBER_OF_REQUESTS_PATH, true);
    xhttp.send();
}

// GET time value from server
function getTimeFromServer() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        var value = null;
        if (this.readyState === 4 && this.status === 200) {
            value = JSON.parse(this.responseText).value;
        }
        if (value != null)
            setHTMLObjectValueById("time", value);
    };
    xhttp.open("GET", SERVER_BASE_URL + TIME_ENDPOINT_PATH, true);
    xhttp.send();
}

// Set the text of an HTML element to the value passed in
function setHTMLObjectValueById(elementId, value) {
    document.getElementById(elementId).innerHTML = value;
}
