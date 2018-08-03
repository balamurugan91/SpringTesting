$(document).ready(function(){
	
});



$('#submit').live('click',function(){
	
	$.ajax({
		
		url : 'validateform',
		type: 'post',
		data : { filter : $('#filter').val(), comments : $('#comments').val() },
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