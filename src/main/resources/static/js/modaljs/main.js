$('document').ready(function(){
	
	$('.table .btnEdit').on('click', function(event){
		
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(usuarios) {
			$('#idEdit').val(usuarios.id);
			$('#nomeEdit').val(usuarios.nome);
			$('#senhaEdit').val(usuarios.senha);
			$('#confirmarEdit').val(usuarios.confirmar);
		});
		
		$('#editModalUsuario').modal();
		
	});
	
	$('.table .btnPesquisa').on('click', function(event){
		
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(usuarios) {
			$('#idEdit').val(usuarios.id);
			$('#nomeEdit').val(usuarios.nome);
			$('#senhaEdit').val(usuarios.senha);
			$('#confirmarEdit').val(usuarios.confirmar);
		});
		
		$('#editModalUsuario').modal();
		
	});
	
	$('table #deleteButton').on('click', function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();
	});
});