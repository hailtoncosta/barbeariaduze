
function validarCamposClientes() {

	var nome = document.getElementById('nome');
	var datanascimento = document.getElementById('datanascimento');
	var telefone = document.getElementById('telefone');
	var email = document.getElementById('email');
	var rg = document.getElementById('rg');
	var endereco = document.getElementById('endereco');
	var cep = document.getElementById('cep');

	if (nome.value === '') {
		document.getElementById('nome-error').innerHTML = "Informe o nome!";
		nome.focus();
		return false;
	} else {
		document.getElementById('nome-error').innerHTML = "";
	}
	
	if (datanascimento.value === '') {
		document.getElementById('datanascimento-error').innerHTML = "Informe a data!";
		datanascimento.focus();
		return false;
	} else {
		document.getElementById('datanascimento-error').innerHTML = "";
	}
	
	if (telefone.value === '') {
		document.getElementById('telefone-error').innerHTML = "Informe o telefone!";
		telefone.focus();
		return false;
	} else {
		document.getElementById('telefone-error').innerHTML = "";
	}
	
	if (email.value === '') {
		document.getElementById('email-error').innerHTML = "Informe o email!";
		email.focus();
		return false;
	} else {
		document.getElementById('email-error').innerHTML = "";
	}
	
	if (rg.value === '') {
		document.getElementById('rg-error').innerHTML = "Informe o RG!";
		rg.focus();
		return false;
	} else {
		document.getElementById('rg-error').innerHTML = "";
	}
	
	if (endereco.value === '') {
		document.getElementById('endereco-error').innerHTML = "Informe o endereço!";
		endereco.focus();
		return false;
	} else {
		document.getElementById('endereco-error').innerHTML = "";
	}
	
	if (cep.value === '') {
		document.getElementById('cep-error').innerHTML = "Informe o CEP!";
		cep.focus();
		return false;
	} else {
		document.getElementById('cep-error').innerHTML = "";
	}
	
		return true;
 
}