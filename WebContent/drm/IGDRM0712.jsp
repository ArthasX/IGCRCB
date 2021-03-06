<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGDRM0712" toScope="request"/>
<bean:define id="title" value="演练评估查询" toScope="request"/>

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
					<html:form action="/IGDRM0703">
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
					<span>&nbsp;&nbsp;演练内容：</span><html:text property="prdesc"/>
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
			<th width="18%">演练内容</th>
			<th width="8%">演练类型</th>
			<th width="10%">发起者</th>
			<th width="10%">发起时间</th>
			<th width="10%">关闭时间</th>
			<th width="8%">发起整改流程</th>
			<th width="5%">导出</th>
	       	</tr>
	       	 <logic:present name="IGDRM07011VO" property="ig500InfoList" >
	       	 	<logic:iterate id="bean" name="IGDRM07011VO" property="ig500InfoList" indexId="index">
					<tr style='cursor:hand' bgcolor="<ig:ProcessOverdueLevelBgColorTag prid="${bean.prid }"/>" onmouseover="mouseOver(this);" onmouseout="mouseOut(this);" 
					onclick="doLook(getAppRootUrl()+'/IGDRM0710.do?prid=<bean:write name="bean" property="prid" />&jump=382');">
	       	 			<td>${bean.prserialnum }</td>
						<td title="${bean.prdesc }"><div style="width:100%; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${bean.prdesc }</div></td>
						<td>
						<c:if test="${bean.prassetid ==2}">计划内</c:if>
						<c:if test="${bean.prassetid ==1}">计划外</c:if>
						</td>
						<td>${bean.prusername }</td>
						<td>${bean.propentime }</td>
						<td>${bean.prclosetime }</td>
						<td><a href="IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=02280&ptid=20&parameters=${bean.prid }">
								<img src="images/xx.gif" alt="发起整改流程" width="16" height="16" border="0" />
							</a>
						</td>
						<td><a href="IGDRM0703_Export.do?prid=${bean.prid }">
								<img src="images/batch.gif" alt="导出" width="16" height="16" border="0" />
							</a>
						</td>
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

function enterFigure(prid){
if(prid!=null){
	window.location.href = getAppRootUrl()+"/IGPRR0102_Disp.do?prid="+prid+"&jump=382";
}
	(window.event)&&(window.event.cancelBubble=true); 
//		e&&e.stopPropagation();
}
function enterDirect(prid){
if(prid!=null){
// 	window.location.href = getAppRootUrl()+"/IGPRR0102_Disp.do?prid="+prid+"&jump=382";
	var url = getAppRootUrl()+"/IGDRM0911_Disp.do?prid="+prid;
	this.subWindow = window.open(url, '应急指挥Dashboard', 'width=1024, height=768, scrollbars=no, resizable=no, status=no, top=0, left=1024').focus();

}
	(window.event)&&(window.event.cancelBubble=true); 
//		e&&e.stopPropagation();
}
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