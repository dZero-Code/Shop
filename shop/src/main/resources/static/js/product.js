(function($) {
	/*********************
		- 상품추가 -
	*********************/
	$("#category1").on("change", function(e) {
		//console.log(category);

		var category2 = document.getElementById("category2");
		var choose;

		category2.options.length = 0;
		
		$("select option:selected").each(function(){
			choose = $(this).val();
			
			for (c in category) {
				if(category[c].category1 == choose){
					var opt = document.createElement("option");
					opt.value = category[c].categoryCode;
					opt.innerHTML = category[c].category2;
					category2.appendChild(opt);
				}
			}
        });

	}).change();	
	
	/*********************
		- 상품 이미지 체크 -
	 *********************/
	$('#photo').on("change", function(e) {
		var filesArr = Array.prototype.slice.call(e.target.files);
		
		filesArr.forEach(function(file){
			if(!file.type.match("image.*")){
				alert('이미지만 선택 가능합니다.');
				return;
			}
			
			$("label[for='photo']").text(filesArr[0].name);
			
			sel_file = file;
			
			var reader = new FileReader();
			reader.onload = function(evt){
				$("#uploadImg").attr("src", evt.target.result);
			}
			reader.readAsDataURL(file);
		});
	});
	
	
	/*********************
		- 상품 페이지 버튼 -
	 *********************/
	$('.update').on("click", function(e){
		var productNO = $(this).parents("tr").children().first().text();
		
		alert('수정 미구현 : '+productNo);
	});
	
	$('.delete').on("click", function(e){
		var productNO = $(this).parents("tr").children().first().text();
		
		alert('삭제 미구현 : '+productNo);
	});
	
})(jQuery);