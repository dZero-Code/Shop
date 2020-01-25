(function($) {
	$(".main-menu a").mouseover(function(){
		$(this).children().first().css("display", "none");
		$(this).children().last().css("display", "block");
	});

	$(".main-menu a").mouseout(function(){
		$(this).children().first().css("display", "block");
		$(this).children().last().css("display", "none");
	});

})(jQuery);