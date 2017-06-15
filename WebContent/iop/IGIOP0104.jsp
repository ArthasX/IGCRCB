<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGIOP0104" toScope="request"/>
<bean:define id="title"  toScope="request" value="IP分配"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<style type="text/css" >
	.table{
		width:100%;
		
		border-collapse: collapse;
	}
	.table th{
		background: #EEEEEE;
		border-bottom: 1px solid #CCCCCC;
		border-top: 1px solid #CCCCCC;
	}
	.table td{
		border-bottom: 1px solid #d3d3d3;
	}
	#dvIPS{
		text-align: center;
		margin: 10px;
	}
	.errorStyle{
		border:1px solid red;
	}
</style>


<body onLoad="">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
   
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
            <div id="location">
                <div class="image"></div>
                  <p class="fonts1">网络管理 &gt;&gt; 子网管理 &gt;&gt; 子网管理&gt;&gt; IP分配登记</p>
            </div> 
            <html:form action="IGIOP0102_Allot" method="POST">
            <div id="dvIPS">
            	<table class="table">
            		<tr>
            			<th>IP地址</th>
            			<th>子网掩码</th>
            			<th>分配说明</th>
            			<th></th>
            			<th></th>
            		</tr>
            		<logic:present name="IGIOP01021VO" property="ipList">
            			<logic:iterate id="bean" name="IGIOP01021VO" property="ipList" indexId="index" >
            			<tr style="height:30px">
            				
            				<td>
            				<html:hidden property="eiids" value="${bean.eiid }"/>
            					${bean.einame }
            				</td>
            				<td>
            					${fn:substring(bean.eilabel,0,fn:indexOf(bean.eilabel,"_"))}
            				</td>
            				<td>
            					<html:text property="eidesc"   tabindex="${index+100 }" onblur="restoreStyle();" styleClass="desc"/>
            				</td>
            				<td>
            					<img alt="全部分配" src="images/down.gif" border="0" onclick="selAll(this)" />
            				</td>
            				<td>
            					<img alt="删除" src="images/delete_16x16.gif" border="0" onclick="delIP(this)" />
            				</td>
            				
            			</tr>
            			</logic:iterate>
            		</logic:present>
            	
            	</table>
            
            <div id ="enter" style="margin-top: 25px;">
		       	<html:submit  styleClass="button"  onclick="return cekForm();">提交</html:submit>   
		       	&nbsp;&nbsp;&nbsp;&nbsp;
		       	<html:button property="btn_back"  styleClass="button" onclick="toback()">返回</html:button>  
            </div>
            </div>
	       
            </html:form>
           
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>

<script type="text/javascript">
function toback(){
	document.forms[0].action = getAppRootUrl()+"/IGIOP0102_View.do";
	document.forms[0].submit();
}
function selAll(obj){
	var txtDesc = jQuery(obj).parent().prev().find(".desc").val();
	jQuery(obj).parent().parent().nextAll().find(".desc").val(txtDesc);
	restoreStyle();
}
function delIP(obj){
	var tr = jQuery(obj).parent().parent();
	tr.empty().animate({height:'0px'},150,jQuery.noop,function(){tr.remove()});
}
function cekForm(){
	
	jQuery(".desc").each(function(i,t){
		if(!t.value){
			t.focus();
			jQuery(t).addClass("errorStyle");
			//return false;
		}
	})
	
	if(jQuery(".errorStyle").length>0){
		alert("请将分配说明填写完整!");
		return false;		
	}
}
function restoreStyle(){
	jQuery(".errorStyle").each(function(i,t){
		if(t.value){
			jQuery(t).removeClass("errorStyle");
		}
	})
}
	
</script>
</body>
</html:html>