function validarCamposUsuarios() {

	var nome = document.getElementById('nome');
	var senha = document.getElementById('senha');
	var confirmar = document.getElementById('confirmar');

	if (nome.value === '') {
		document.getElementById('nome-error').innerHTML = "Informe o nome do usuário!";
		nome.focus();
		return false;
	} else {
		document.getElementById('nome-error').innerHTML = "";
	}
	
	if (senha.value === '') {
		document.getElementById('senha-error').innerHTML = "Informe a senha do usuário!";
		senha.focus();
		return false;
	} else {
		document.getElementById('senha-error').innerHTML = "";
	}
	
	if (confirmar.value === '') {
		document.getElementById('confirmar-error').innerHTML = "Confirme a senha do usuário!";
		confirmar.focus();
		return false;
	} else {
		document.getElementById('confirmar-error').innerHTML = "";
	}
	
	if (senha.value != confirmar.value) {
		document.getElementById('confirmar-error').innerHTML = "A senha informada é diferente!";
		confirmar.focus();
		return false;
	}
	
		return true;

}