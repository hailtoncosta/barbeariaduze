$('document').ready(function(){
	
	$('.table .btnEdit').on('click', function(event){
		
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(usuarios) {
			$('#idEdit').val(usuarios.id);
			$('#nomeEdit').val(usuarios.nome);
			$('#sexoEdit').val(usuarios.sexo);
			$('#datanascimentoEdit').val(usuarios.datanascimento);
			$('#telefoneEdit').val(usuarios.telefone);
			$('#emailEdit').val(usuarios.email);
			$('#rgEdit').val(usuarios.rg);
			$('#enderecoEdit').val(usuarios.endereco);
			$('#cepEdit').val(usuarios.cep);
		});
		
		$('#editModalCliente').modal();
		
	});
	
	$('table #deleteButton').on('click', function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();
	});
});