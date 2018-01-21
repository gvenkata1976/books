 
function updateEmployee(){
	 
	 document.forms[0].action = contextPath + "/employee/update.htm";
	 document.forms[0].submit();
 }
 
function deleteEmployee(){
	 
	document.forms[0].action = contextPath + "/employee/delete.htm";
	document.forms[0].submit();
}


/**
 * 
 * @param action
 */ 
function refreshEmployee(action){
	document.forms[0].action = contextPath + "/employee/refresh.htm";
	document.forms[0].submit();
	// location.href= contextPath + "/employee/refresh.htm"; 
 }
/**
 * @param id
 */
function addEmployee(id){
	editEmployee(id);
}
 /**
  * 
  * @param id
  * @returns {Boolean}
  */
 function editEmployee(id){
	 var features = 'resizable= yes;toolbar=no,directories=no,status=no;'+
			'menubar=no;scrollbars=no;help=no;center= yes;'+
			'location=no;modal=yes;dialogWidth:520px;dialogHeight:500px;dialogLeft:80px;dialogTop:80px;';
	var url = contextPath + "/employee/edit.htm?id="+id; 
    var myObject = new Object(); 
	window.dialogArguments = myObject;
	var newwindow = window.showModalDialog(url,myObject,features);
	window.dialogArguments = null;
	
	if (window.focus) {
		newwindow.focus();
	}
	return false;
} 
 
 $( document ).ready(function() {
	    console.log( "ready!" );
	    $( '[name="hireDate"]' ).datepicker();
	    
	    //$( "tr.zebra-style :odd" ).css( "background-color", "#c6cef0" );	    
	    // Delete row in a table
	    $('.delete-row').click(function(){
	      var c = confirm("Continue delete?");
	      if(c)
	        $(this).closest('tr').fadeOut(function(){
	          $(this).remove();
	        });
	        
	        return false;
	    });

	    // Show aciton upon row hover
	    $('.table tbody tr').hover(function(){
	      $(this).find('.table-action-hide a').animate({opacity: 1});
	    },function(){
	      $(this).find('.table-action-hide a').animate({opacity: 0});
	    });
});

