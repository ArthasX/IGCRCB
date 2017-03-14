<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Script-Type" content="text/javascript">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Language" content="zh-CN">
<bean:define id="id" value="IGDRM2103" toScope="request" />
<bean:define id="title" value="专项预案维护文本编辑器" toScope="request" />
<!-- start header1 -->
<link rel="stylesheet" href="editor/themes/default/default.css" />
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script charset="utf-8" src="editor/kindeditor-all.js"></script>
<script charset="utf-8" src="editor/lang/zh-CN.js"></script>
<style type="text/css">

#container{
	width: 98%;
	height: 475px;
}
.ke-icon-save {
        background-image: url(editor/themes/default/icons.png);
         background-position: -483px -22px; 
        width: 16px;
        height: 16px;
}
#messgeId{
	color: green;
	font-size: 12px;
}

</style>
</head>
<!-- end header1 -->
<body  >
	<html:form styleId="form" action="/IGDRM2103">
		<!-- 加载编辑器的容器 -->
		<div id="messgeId" style="margin-top: 5px;margin-left: 5px;"></div>
        <div id="results_list">
        	<textarea id="container">${IGDRM2103Form.civalue}</textarea>
			<html:hidden property="ciid"/>
		</div>
   	</html:form>
	<script type="text/javascript">
	KindEditor.plugin('save', function(K) {
        var editor = this;
        // 点击图标时执行
        editor.clickToolbar('save', function() {
        	submitByAjax(editor.html());
        });
	});
	KindEditor.lang({
		save : '保存'
	});
	KindEditor.ready(function(K) {
        window.editor = K.create('#container',{
        	 uploadJson : 'editor/jsp/upload_json.jsp',
        	allowImageRemote:false,
	        items:['source', '|', 'undo', 'redo', '|',   'code', 'cut', 'copy', 'paste',
	                       'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
	                       '|', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
	                       'superscript', 'clearhtml', 'quickformat', 'selectall', '|',  '/',
	                       'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
	                       'italic', 'underline', 'strikethrough',  '|', 'image',
	                        'insertfile', 'table', 'hr',   'pagebreak',
	                        '|', 'save']
        });
		
        
});
	
	
	
        function submitByAjax(dataVal){
    		jQuery.ajax({
    			url:"IGDRM2103.do",
    			type:"POST",
    			dataType :"json",
    			data:{content:dataVal,eiid:'${param.eiid}',eid:'${param.eid}',cid:'${param.cid}',esyscoding:'${param.esyscoding}',ciid:'${IGDRM2103Form.ciid}'},
    			async:true,
    			cache:false,
    			success:function(res){
    				alert("保存成功！");
    				jQuery("#messgeId").text(res);
    			},
    			error:function(XMLHttpRequest, textStatus, errorThrown){
    				alert('出错了'+XMLHttpRequest+textStatus+errorThrown);
    			}
    		});
    	}
    </script>
</body>
</html:html>
