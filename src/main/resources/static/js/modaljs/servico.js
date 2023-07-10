$('document').ready(function(){
	
	$('.table .btnEdit').on('click', function(event){
		
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(usuarios) {
			$('#idEdit').val(usuarios.id);
			$('#descricaoEdit').val(usuarios.descricao);
			$('#valorEdit').val(usuarios.valor);
		});
		
		$('#editModalServico').modal();
		
	});
	
	$('table #deleteButton').on('click', function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();
	});
});