<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGFIN0301" toScope="request" />
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
		        <p class="fonts1">服务管理 &gt;&gt; 预算管理 &gt;&gt; 统计汇总</p>
		    </div>
     <div class="statistic"> 
		   <html:form action="/IGFIN0301_STATISTICS.do">     
		   <html:hidden name="IGFIN0301Form" property="finxml"/> 
		     <p class="fonts1" style="float: left;margin-left:20px;">年份：</p>
			 <div style="float: left">
			 <html:select property="year">
				 <ig:optionsCollection ccid="YEAR_CODE" isMakeBlankRow="false" isCodeLabel="true" /> 
			 </html:select> 
			 </div> 
			 <!--<span>实际金额显示方式：</span>
			 <html:select property="showType">
			 <html:option value="T">按整体显示</html:option>
			 <html:option value="S">按分段显示</html:option>	
		     </html:select>
		     -->
		     
		    <input type="button" name="button" title="统计" id="button" value="统计"  onclick="ope()" class="button"/>               
		   </html:form>
	</div>
		<table width="100%" border="0" cellspacing="0" cellpadding="3" align="center">
  		<tr> 
    		<td valign="top" align="center"> 
    			<div id="chartdiv" align="center" ></div>
		 	<script type="text/javascript">
		   	var finxml="";
		   	function getXmlInfo(){
		 	  var temp = document.forms[0].finxml.value;
		 		
		 	  if(null!=temp && temp!=""){
		 		 finxml=temp;
		 		
		 	  }
		 	
		   	}
		   	getXmlInfo();
		   	if(null!=finxml && finxml!=""){
			   
		       var chart = new FusionCharts("images/MSStackedColumn2DLineDY.swf", "ChartId", "800", "350", "0", "0");
		       chart.setDataXML(finxml);		   
		       chart.render("chartdiv");
		   	}
		 	</script>
		 
			<logic:notEmpty name="IGFIN0301Form" property="finxml">
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