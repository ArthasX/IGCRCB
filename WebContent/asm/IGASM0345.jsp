<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ page import="java.util.Map"%>
<html:html>
<bean:define id="id" value="IGASM0345" toScope="request" />
<bean:define id="title" value="版本比较画面" toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<link rel="stylesheet" href="<html:rewrite forward='pop.css'/>" type="text/css">
	
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<style>
html{
overflow-x:auto;
overflow-y:hidden;
}
body{
overflow-x:auto;
overflow-y:auto;
}
</style>
<script type="text/javascript">

	function toClose() {
		window.close();
	}
	
</script>
<body>
	
	
	<div class="message"><ig:message /></div>
	 <div id="results_list">
	    <table width="100%" border="1">
	      <!-- header部 -->
			 <tr>

				<th >SECTION</th>
				<th >第${IGASM0341Form.pre}版</th>
				<th >第${IGASM0341Form.next}版</th>
			 </tr>
			 <logic:present name="IGASM03011VO" property="section_list">
	
			 	<bean:define id="command_list1" name="IGASM03011VO" property="command_list1" type="java.util.List"></bean:define>
			 	<bean:define id="output_list1" name="IGASM03011VO" property="output_list1" type="java.util.List"></bean:define>
			 	<bean:define id="command_list2" name="IGASM03011VO" property="command_list2" type="java.util.List"></bean:define>
			 	<bean:define id="output_list2" name="IGASM03011VO" property="output_list2" type="java.util.List"></bean:define>
			 	<bean:define id="command_color_list" name="IGASM03011VO" property="command_color_list" type="java.util.List"></bean:define>
			 	<bean:define id="output_color_list" name="IGASM03011VO" property="output_color_list" type="java.util.List"></bean:define>
			 	
				<logic:iterate id="bean" name="IGASM03011VO" property="section_list" indexId="index">
					
					<tr>

			       		
			       		
			       		<%if("1".equals(command_color_list.get(index)) || "1".equals(output_color_list.get(index))){ %>
			       		<td style="color:red;font-weight: bold;" align="center">
			       			
					    	${bean}
					    	
			       		</td>	
			       		<%}else{ %>
			       		<td align="center">
			       			
					    	${bean}
					    	
			       		</td>
			       		<%} %>
			       		
			       		
			       		<td style="padding-left:20px">
			       			<%if(command_list1.get(index)!=null && !"".equals(command_list1.get(index))){ %>
				       			<span>Command ：${command_list1[index]}</span>
				       			<br/>
			       			<%}%>
			       			<pre>
			       			${output_list1[index]}
			       			</pre>
			          		
			       		</td>
			       		

			       		<td style="padding-left:20px">
			       			<%if(command_list2.get(index)!=null && !"".equals(command_list2.get(index))){ %>
			       				<span>Command ：${command_list2[index]}</span>
			       				<br/>
			       			<%}%>
			       			
			       			<pre>
			          		${output_list2[index]}
			          		</pre>
			       		</td>
			       		
			       		
			       </tr>
				</logic:iterate>
			</logic:present>
	     </table>
	 </div>
	 
</body>
</html:html>