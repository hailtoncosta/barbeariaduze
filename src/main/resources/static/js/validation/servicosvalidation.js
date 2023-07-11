function validarCamposServicos() {

	var descricao = document.getElementById('descricao');
	var valor = document.getElementById('valor');
	
	if (descricao.value === '') {
		document.getElementById('descricao-error').innerHTML = "Informe a descrição do serviço!";
		descricao.focus();
		return false;
	} else {
		document.getElementById('descricao-error').innerHTML = "";
	}
	
	if (valor.value === '') {
		document.getElementById('valor-error').innerHTML = "Informe o valor do serviço!";
		valor.focus();
		return false;
	} else {
		document.getElementById('valor-error').innerHTML = "";
	}
	
		return true;
}

