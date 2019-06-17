$(function(){

		$(".wrap>li").mouseover(function(){
			$(this).css('background','#0395CA');
		});
		
		$(".wrap>li").mouseout(function(){
			$(this).css('background','');
		});
		
		$(".left>ul>li:first").find(".wrap").css('display', 'block');
		
		$(".left>ul>li").click(function(){
			$(this).siblings("li").find(".wrap").css('display', 'none');
			$(this).find(".wrap").css('display','block');
		});
	});