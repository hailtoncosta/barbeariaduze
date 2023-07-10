$('document').ready(function(){
	
	$('.table .btnEdit').on('click', function(event){
		
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(usuarios) {
			$('#idEdit').val(usuarios.id);
			$('#clienteEdit').val(usuarios.cliente);
			$('#servicoEdit').val(usuarios.servico);
			$('#valorEdit').val(usuarios.valor);
			$('#observacaoEdit').val(usuarios.observacao);
		});
		
		$('#editModalAgendamento').modal();
		
	});
	
	$('table #deleteButton').on('click', function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();
	});
});