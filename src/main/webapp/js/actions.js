function go(url) {
	
	window.location = url;
}

function deleteEntity(url) {
	var desejaDeletar = confirm("Deseja mesmo deletar este item ?");
	if(desejaDeletar) {
		go(url);
	}
}

function logout(url) {
	var desejaFazerLogout = confirm=("Deseja realmente sair da aplicação ?");
	if(desejaFazerLogout) {
		go("/sindico/logout");
	}
}
