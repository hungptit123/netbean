/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var websocket = new WebSocket("ws://localhost:8080/WebSocket_Chat/chat_room");

websocket.onopen = function(message) {processOpen(message);};
websocket.onmessage = function(message) {processMessage(message);};
websocket.onclose = function(message) {processClose(message);};
websocket.onerror = function(message) {processError(message);};

function processOpen(message) {
//    textAreaMessage.value += "Server connect... \n";
}
function processMessage(message) {
    console.log(message);
    textAreaMessage.value += message.data + " \n";
}
function processClose(message) {
    textAreaMessage.value += "Server Disconnect... \n";
}
function processError(message) {
    textAreaMessage.value += "Error... " + message +" \n";
}

function sendMessage() {
    alert("hellow send message");
    if (typeof websocket != 'undefined' && websocket.readyState == WebSocket.OPEN) {
            if (object_chat.value == "") {
                object_chat.value = "all";
            }
            websocket.send(object_chat.value+"@"+textMessage.value);
            textMessage.value = "";
    }
}

function start_login() {
    document.getElementById("div_login").style.visibility = "hidden";
    document.getElementById("div_start_chat").style.visibility = "visible";
    if (typeof websocket != 'undefined' && websocket.readyState == WebSocket.OPEN) {
        if(user_name.value == "") {
            alert("False User Name");
        }
        if (pass_word.value == "") {
            alert("False Pass Word");
        }
        if (user_name.value != "" && pass_word != "") {
            var mess = JSON.stringify({
              "username": user_name.value,
              "password": pass_word.value
            });
            websocket.send(mess);
            
        }
    }
}

//function sendName() {
//    if (typeof websocket != 'undefined' && websocket.readyState == WebSocket.OPEN) {
//            websocket.send("label:"+label.value);
//            textAreaMessage.value += "User name register sucessful: " + label.value + "\n"; 
//    }
//}

