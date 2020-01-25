(function($) {
	/*****************
		- 상품추가 -
	*****************/
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
	
})(jQuery);