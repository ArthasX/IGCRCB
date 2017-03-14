jQuery(document).ready(function(){
	//日志信息 默认展示
	var path=jQuery("#loginfo").attr("src");
	if(path=="images/redu.gif"){
		jQuery("#loginfo").attr("src","images/addd.gif");
		jQuery("#TabbedPanels1").toggle();
	}else{
		jQuery("#loginfo").attr("src","images/redu.gif");
		jQuery("#TabbedPanels1").toggle();
	}
});
