(function($) {
    /*------------------
		Background Set
	--------------------*/
	$('.set-bg').each(function() {
		var bg = $(this).data('setbg');
		$(this).css('background-image', 'url(' + bg + ')');
	});


    /*------------------
		Main-slider
	--------------------*/
    $(".main-slider").owlCarousel({
        items:1,
        loop:true,
        margin:0,
        nav: true,
        dots: true,
        autoplay:true,
        autoHeight: false,
        animateOut: 'fadeOut',
        animateIn: 'fadeIn',
        navText: ['<i class="fa fa-angle-left" aria-hidden="true"></i>', '<i class="fa fa-angle-right" aria-hidden="true"></i>'],
        autoplayTimeout:3000,
        autoplayHoverPause:true
    });
})(jQuery);