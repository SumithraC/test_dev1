function swapSection(sectionId, displayId){
	$('#'+sectionId).css({"display":"none"});
	$('#'+displayId).css({"display":"block"});
	$('#newText').attr('value','');
	$('#textDescription').attr('vlaue','');
}

function saveContents(i){
	var text_name =  $('#newText').val();
	var text_desc = $('#textDescription').val();
	
	$.ajax({
		type : "POST",
		url :'/test_dev1/editText',
		contentType : 'application/json',
		data : JSON.stringify({'textName' : text_name, 'description' : text_desc}),
		success : function(data){
			$('#editDiv').css({"display":"none"});
			$('#searchDiv').css({"display":"block"});
			$('#currentText').html('');
			 getTexts();
		},error:function(e){
			console.log(e);
		}
	})
}
function searchName(){
	var searchValue = $('#searchText').val();
	var tableData = [];
	$('#currentText tbody tr').each(function(){
		var temp = $(this).find('td').html();
		if (temp.indexOf(searchValue) != -1){
			tableData.push(temp);
		}
	});
	$('#currentText').html('');
	for (var i=0;i<tableData.length;i++){
		$('#currentText').append('<tr><td>'+tableData[i]+'</td></tr>')
	}
	console.log(tableData);
}
function getTexts(){
//	$('#currentText').html('');
	$.ajax({
		type : "GET",
		url :'/test_dev1/getText',
		dataType : 'json',
		contentType : 'application/json',
		success : function(data){
			console.log(data);
			for (var i=0;i<data.length;i++){
				$('#currentText').append('<tr><td>'+data[i].textName+'</td></tr>')
			}
			
		},
		error:function(e){
			console.log(e);
		}
	})
}