<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html:html>
<bean:define id="id" value="IGDRM2109" toScope="request" />
<bean:define id="title" value="预案中查看组织架构页面" toScope="request" />
<!-- start header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- end header1 -->
<head>
<style type="text/css" >
.table_style{
	width:95% !important;
}
.table_style4{ 
    width:95%;    
	border-collapse:collapse;
	border:1px solid #959499;
    text-align:left;  
    margin-top:10px;  
    border:0px;
} 

.table_style4 td{
	border:1px solid #959499;
	text-indent: 0px;
}
.table_style4 th{
	text-align: left;
	text-indent: 0px;
}
.td_style4 {
	border:0px;
}
</style>
</head>
<body>
	<div id="main">
	
	</div>

</body>
<script>
jQuery.ajax({
	url:"IGDRM2108_Ajax.do",
	data:{cid:'${cid}',ctype:'${ctype}',planEiid:'${planEiid}'},
	dataType:"HTML",
	type:"POST",
	async:false,
	success:function(html){
		jQuery("#main").html(html);
		jQuery(".table_style4").css({width:'95%',borderCollapse:'collapse',border:'1px solid #959499',textAlign:'left',marginTop:'10px',border:'0px'});
		jQuery(".table_style4 th").css({
			textAlign: 'left',
			textIndent: '0px',
			color:'#000',
			borderTop:'1px solid #cccccc',
			borderBottom:'1px solid #cccccc',
			height:'20px'
			
		});
		jQuery(".table_style4 td").css({
			border:'1px solid #959499',
			textIndent: '0px'
			
		});
	}
});
</script>
</html:html>
