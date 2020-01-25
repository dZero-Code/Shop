/*------------------
	회원가입
 ------------------*/
(function($) {
	/* 회원가입 버튼 클릭 */
    $("#signup").on("click", function(){
    	//alert('click');
    	let userid = $('#userid').val();
    	let passswd = $('#passwd').val();
    	let name = $('#name').val();
    	let birth = $('#birth').val();
    	let email = $('#email').val();
    	let phone = $('#phone').val();
    	
    	const user = {
    			userid: userid,
    			passwd: passwd,
    			name: name,
    			birth: birth,
    			email: email,
    			phone: phone
    	}
    	
    	$.ajax({
    		url:'/signup',
    		method:'POST',
    		data: JSON.stringify(user);
    		success:function(res){
    			
    		}
    	})
    })
})(jQuery);