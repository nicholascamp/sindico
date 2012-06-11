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
	var req;
	try {
		// Firefox, Opera, Safari
		req = new XMLHttpRequest();
	} catch (e) {
		// Internet Explorer
		try {
			// For IE 6
			req = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				// For IE 5
				req = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				alert('Your browser is not IE 5 or higher, or Firefox or Safari or Opera');
			}
		}
	}
	return req;
}

// Make the XMLHttpRequest Object
var http = createRequestObject();
function sendRequest(method, url) {
	if (method == 'get' || method == 'GET') {
		http.open(method, url, true);
		http.onreadystatechange = handleResponse;
		http.send(null);
	}
}

function handleResponse() {
	if (http.readyState == 4 && http.status == 200) {
		var response = http.responseText;
		if (response) {
			document.getElementById("ajax_res").innerHTML = response;
		}
	}
}
