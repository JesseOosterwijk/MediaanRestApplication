var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#orders").html("");
}

function connect() {
    var socket = new SockJS('/mediaan-ws');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/kitchen', function (receivedOrder) { showOrder(receivedOrder); });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

// Receive method
function showOrder(order) {
	const receivedOrder = JSON.parse(order.body);
	
	let orderString = "<p><b>Table " + receivedOrder.tableNumber + "</b></p><ul>";
	for(const orderItem of receivedOrder.dishes){
		orderString += "<li>" + orderItem.name + "</li>";
	}
	orderString += "</ul><hr style='width: 120px; float: left; background-color: black; height: 2px;'>";
	$("#orders").append(orderString);
}

connect();

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
// $( "#send" ).click(function() { sendName(); });
});