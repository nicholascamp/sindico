function go(url) {

	window.location = url;
}

function deleteEntity(url) {
	var desejaDeletar = confirm("Deseja mesmo deletar este item ?");
	if (desejaDeletar) {
		go(url);
	}
}

function logout(url) {
	var desejaFazerLogout = confirm = ("Deseja realmente sair da aplicação ?");
	if (desejaFazerLogout) {
		go("/sindico/logout");
	}
}

function createRequestObject() {
    var tmpXmlHttpObject;
    
    //depending on what the browser supports, use the right way to create the XMLHttpRequest object
    if (window.XMLHttpRequest) { 
        // Mozilla, Safari would use this method ...
        tmpXmlHttpObject = new XMLHttpRequest();
	
    } else if (window.ActiveXObject) { 
        // IE would use this method ...
        tmpXmlHttpObject = new ActiveXObject("Microsoft.XMLHTTP");
    }
    
    return tmpXmlHttpObject;
}

//call the above function to create the XMLHttpRequest object
var http = createRequestObject();

function makeGetRequest(cep) {
    //make a connection to the server ... specifying that you intend to make a GET request 
    //to the server. Specifiy the page name and the URL parameters to send
    http.open('get', 'http://localhost:8080/sindico/cep?cep=' + '09607030');
	
    //assign a handler for the response
    http.onreadystatechange = processResponse;
	
    //actually send the request to the server
    http.send(null);
}

function processResponse() {
    //check if the response has been received from the server
    if(http.readyState == 4){
	
        //read and assign the response from the server
        var response = http.responseText;
		
        //do additional parsing of the response, if needed
		
        //in this case simply assign the response to the contents of the <div> on the page. 
        document.forms[0].endereco.value = 'teste';
		
        //If the server returned an error message like a 404 error, that message would be shown within the div tag!!. 
        //So it may be worth doing some basic error before setting the contents of the <div>
    }
}
