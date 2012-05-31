function go(url) {
	
	window.location = url;
}

function deleteEntity(url) {
	var desejaDeletar = confirm("Deseja mesmo deletar este item ?");
	if(desejaDeletar) {
		go(url);
	}
}