jQ(document).ready(function(){
	
	jQ('input[type=checkbox]').tzCheckbox({labels:['Enable','Disable']});
});

//改成JQ加载方法的原因是ready抛出异常，可能原因是与其他js的ready方法冲突
//jQ(function(){
//	
//	jQ('input[type=checkbox]').tzCheckbox({labels:['Enable','Disable']});
//})