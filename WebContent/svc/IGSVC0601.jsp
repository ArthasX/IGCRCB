<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.List"%>
<%@ page import="com.deliverik.infogovernor.svc.bl.IGPROCESSType" %>
<%@ page import="com.deliverik.framework.workflow.prd.model.IG259Info"%>

<html:html>
<bean:define id="id" value="IGSVC0601" toScope="request" />
<bean:define id="title" value="统计汇总" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->

<script type="text/javascript">

function ope(){
	document.forms[0].submit();
}
function setSWF(){
	   chart.render("chartdiv");
	}		
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />

<!--container 左菜单 右侧内容-->
<script src="<html:rewrite forward='FusionCharts.js'/>"></script>
<div id="container"> 
	<!--content  右侧内容-->
   <div id="contentWrap">
   <div id="content">
		   <div id="location">
		       <div class="image"></div>
		        <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
		    </div>
     <div class="statistic"> 
		   <html:form action="/IGSVC0601_STATISTICS.do">     
		   <html:hidden name="IGSVC0601Form" property="svcxml"/> 
		     <p class="fonts1" style="float: left;margin-left:20px;">年份：</p>
			 <div style="float: left">
			 <html:select property="pryear">
				<ig:optionsCollection ccid="YEAR_CODE" isMakeBlankRow="false" isCodeLabel="true" />    
		     </html:select>
		     </div>
		     <p class="fonts1" style="float: left;margin-left:20px;">类型：</p>
			 <div style="float: left">
				
			 <html:select property="prkind" errorStyleClass="inputError imeActive" >
					<html:options collection="processTemplateList" property="value" name="" labelProperty="label" />
			</html:select> 

		     </div>
		    <input type="button" name="button" title="统计" id="button" value="统计"  onclick="ope()" class="button"/>               
		   </html:form>
		</div>
		<table width="100%"  border="0" cellspacing="0" cellpadding="3" align="center">
  		<tr> 
    		<td valign="top" align="center"> <div id="chartdiv" align="center" ></div>
		 	<script type="text/javascript">
		   	var svcxml="";
		   	function getXmlInfo(){
		 	  var temp = document.forms[0].svcxml.value;
		 	
		 	  if(null!=temp && temp!=""){
		 		 svcxml=temp;
		 		//alert(svcxml);
		 	  }
		 	
		   	}
		   	getXmlInfo();
		   	if(null!=svcxml && svcxml!=""){
		       var chart = new FusionCharts("images/Column2D.swf", "ChartId", "800", "300", "0", "0");
		       chart.setDataXML(svcxml);		   
		       chart.render("chartdiv");
		   	}
		 	</script>
		 
			<logic:notEmpty name="IGSVC0601Form" property="svcxml">
				<input type="button" onclick="setSWF()" value="刷新" class="button"/>
			</logic:notEmpty>
			</td>
  		</tr>
  		<tr>
    		<td valign="top" align="center">&nbsp;</td>
  		</tr>
  
		</table>
</div>
</div>

</div>

 

</div>
</body>
</html:html>