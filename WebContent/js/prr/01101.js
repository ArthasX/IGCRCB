jQuery(document).ready(function(){
	//��־��Ϣ Ĭ��չʾ
	var path=jQuery("#loginfo").attr("src");
	if(path=="images/redu.gif"){
		jQuery("#loginfo").attr("src","images/addd.gif");
		jQuery("#TabbedPanels1").toggle();
	}else{
		jQuery("#loginfo").attr("src","images/redu.gif");
		jQuery("#TabbedPanels1").toggle();
	}
});
