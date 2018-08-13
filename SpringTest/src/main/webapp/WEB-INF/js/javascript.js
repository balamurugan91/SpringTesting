$(document).ready(function(){
	
});



$('#submit').live('click',function(){
	
	$.ajax({
		
		url : 'validateform',
		type: 'post',
		data : { 	
					comments : $('#comments').val(),
					number : $('#number').val(),
					decimal : $('#decimal').val(),
					date : $('#date').val(),
					filepath: $('#filepath').val(),
					email: $('#email').val(),
					phone: $('#phone').val(),
					filter: $('#filter').val()
				},
		success: function(response){
			
			$('#successdiv').html(response);
			
		},
		//error: function (xhr, ajaxOptions, thrownError) {
		error: function(response) {
			var r = jQuery.parseJSON(response.responseText);
           /* alert("Message: " + r.Message);
            alert("StackTrace: " + r.StackTrace);
            alert("ExceptionType: " + r.ExceptionType);*/
	        $('#errorMessageDiv').html(response);
	      }  
	});
	
});