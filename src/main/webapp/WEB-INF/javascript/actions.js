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

function getCep(cep) {

    $.ajax({
        url: '/sindico/cep?cep=' + cep,
        type: 'GET',
        success: function(cep) {
        	       $('#endereco').val(cep.tipo_logradouro + ' ' +cep.logradouro);
                   $('#bairro').val(cep.bairro);
                   $('#cidade').val(cep.cidade);
                   $('#estado').val(cep.uf);
        	}
    });
}
