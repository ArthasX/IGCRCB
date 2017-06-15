<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGDRM0713" toScope="request"/>
<bean:define id="title" value="应急评估查询" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<style type="text/css">
a img {
	border: 0px;
}

.hover {
	background-color: #d3d3d3;
	cursor: pointer;
}

.leftd {
	text-align: left;
}

#results_list INPUT {
	height: 20px;
}

.ellips {
	width: 100%;
	white-space: nowrap;
	text-overflow: ellipsis;
	overflow: hidden;
}
</style>
<!-- /header1 -->
<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">

  <div id="contentWrap">
        <div id="content">
					<html:form action="/IGDRM0713">
 	<div id="location">
                <div class="image"></div>
                  <p class="fonts1">
                  <ig:navigation extname1="${urlable}"/>
                  </p>
     </div> 
			<div id="search">
				<div class="img"></div>
				<div class="conditions">
					<div><span>编号：&nbsp;&nbsp;</span><html:text property="prserialnum" size="12" />
					<span>&nbsp;&nbsp;事件名称：</span><html:text property="prtitle"/>
					<span>&nbsp;&nbsp;时间：从</span><html:text property="propentime" styleId="propentime" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
					<img src="images/date.gif" align="middle" onclick="calendar($('propentime'))" border="0" style="cursor: hand" />
					<span>&nbsp;&nbsp;到</span><html:text property="prclosetime" styleId="prclosetime" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
					<img src="images/date.gif" align="middle" onclick="calendar($('prclosetime'))" border="0" style="cursor: hand" />
					</div>
					<div>
					<span>发起者：</span><html:text property="prusername" style="width:90px"/>
					<html:hidden property="prpdid" />
					<html:submit property="btn_search" value="查询" styleClass="button" />
				</div>
			</div>
			</div>
					
		    <div id="results_list" >
			<!--  message -->
				<ig:message/>
			<!--  /message -->     
	       <table width="100%" class="table_style">
	       	<tr>
			<th width="8%">编号</th>
			<th width="18%">事件名称</th>
			<th width="10%">发起者</th>
			<th width="10%">发起时间</th>
			<th width="10%">关闭时间</th>
	       	</tr>
	       	 <logic:present name="IGDRM07011VO" property="ig500InfoList" >
	       	 	<logic:iterate id="bean" name="IGDRM07011VO" property="ig500InfoList" indexId="index">
					<tr style='cursor:hand' bgcolor="<ig:ProcessOverdueLevelBgColorTag prid="${bean.prid }"/>" onmouseover="mouseOver(this);" onmouseout="mouseOut(this);" 
					onclick="doLook(getAppRootUrl()+'/IGDRM0710_DISP.do?prid=<bean:write name="bean" property="prid" />&jump=383');">
	       	 			<td width="8%">${bean.prserialnum }</td>
						<td width="18%" title="${bean.prtitle }"><div style="width:100%; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${bean.prtitle }</div></td>
						<td width="5%">${bean.prusername }</td>
						<td width="10%">${bean.propentime }</td>
						<td width="5%">${bean.prclosetime }</td>
	       	 		</tr>
	       	 	</logic:iterate>
	       	 	
	       	 </logic:present>
	       </table>
		 </div>
		<div id="operate" style="float:left;margin-left:10px;">
			 <!-- paging -->
				<jsp:include page="/include/paging.jsp"/>
			 <!-- /paging -->
		</div>
	</html:form>
</div>
</div>
</div>
</div>
<script type="text/javascript">

jQ("img[prid]").each(function(i,t){
	t = jQ(t);
	t.click(function(event){
		eval(t.data("fn")+"("+t.attr("prid")+")")
		event.stopPropagation();
		
	});
	!t.attr("prid")&&t.hide();
})

</script>

</body>
</html:html>