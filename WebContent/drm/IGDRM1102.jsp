<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDRM1102" toScope="request" />
<bean:define id="title" value="人员代签到查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style>

	#results_list a:HOVER{
		text-decoration: none;
	}
	
</style>
<body style="background-color: white; background-image: none;">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->

	  <div id="contentWrap">
        <div id="content">
	
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	 <html:form styleId="form" action="IGDRM1102_Search.do">
			<span class="red">*</span><span id = "labPrname">演练流程名称:</span> 	<html:text property="prname" styleId="prname"></html:text>
			<html:hidden property="prid"  styleId="prid" /> 
			<img title="查找" src="images/seek.gif"  style="cursor: pointer;" onclick="selProcess();" />
			<html:hidden styleId="isDrill" property="isDrill"/>
			&nbsp;&nbsp;&nbsp;&nbsp;
		<html:submit property="btn_search" styleClass="button" value="查询" onclick="return searcher()" />
	</html:form>
	</div>
	</div>
	</div>
	<div id="results_list"><ig:message />
	<table class="table_style" id = "tb">
		<tr>
				<th width="8%">编号 </th>
				<logic:notEqual value="true" name="IGDRM1102Form" property="isDrill">
					<th  class="tdname">事件名称</th>
				</logic:notEqual>
				<logic:equal value="true" name="IGDRM1102Form" property="isDrill">
					<th  class="tddesc">演练内容</th>
				</logic:equal>
				<th width="10%">开始时间</th>
				<th width="10%">当前状态</th>
				<th width="10%">姓名</th>
				<th width="8%">是否就位</th>
				<th width="10%">签到时间</th>
				<th width="10%">管理</th>
			</tr>
		<logic:present name="IGDRM11021VO" property="signinMap">
			<logic:iterate id="bean" name="IGDRM11021VO" property="signinMap" indexId="index">
				<tr>
					<td id="cols${index+1 }" class="tdtitle" name="${bean['PRSERIALNUM'] }">${bean['PRSERIALNUM']}</td>
					<logic:notEqual value="true" name="IGDRM1102Form" property="isDrill">
						<td class="tdname">${bean['PRTITLE'] }</td>
					</logic:notEqual>
					<logic:equal value="true" name="IGDRM1102Form" property="isDrill">
						<td class="tddesc" title="${bean['PRDESC'] }"><div class="ellips" >${bean['PRDESC'] }</div></td>
					</logic:equal>
					<td>${bean['PROPENTIME']}</td>
					<!-- 流程状态 -->
					<td>	
					<ig:processDefineTypeValue prid="${bean['PRID']}"/>
					</td>
						<td>${bean['USERNAME']}</td>
						<td>
						<c:if test="${bean['SIGNINED']==1}">
						已就位
						</c:if>
						<c:if test="${bean['SIGNINED']!=1}">
						未就位
						</c:if>
						</td>
						<td>${bean['SITIME'] }</td>
						
						<td>
								<a href="javascript:;" onclick="changeFlag('${bean['PRID']}','${bean['SIUSERID']}','${bean['SIGNINED']}')">
									<c:if test="${bean['SIGNINED']!=1}">
										<img src="images/signout.jpg" border="0" alt="签到"/>
									</c:if>
									<c:if test="${bean['SIGNINED']==1}">
										<img src="images/sign.jpg" border="0" alt="签出"/>
									</c:if>
									</a>
						</td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
	<div class="zishiying"></div>
	</div>
	</div>
</div>
</div>
<script type="text/javascript">
function changeFlag(a,b,c){
	 var confirmMsg = c=='1'?"是否签出？":"是否签到？";
	    if(window.confirm(confirmMsg)){
	        window.location.href = getAppRootUrl() + "/IGDRM1102_Signin.do?siPrid="+a+"&siuserid="+b+"&signined="+c;
	    }
}
function searcher(){
	if(!jQ("#prid").val()){
		if((jQ("#isDrill").val()=="true")){
			alert("请先选择演练流程");
		}else{
			alert("请先选择指挥流程");
		}
		return false;
	}
}

function selProcess(){
	if(jQ("#isDrill").val()=="true"){
		openSubWindow('/IGDRM0701_Sel.do', '_blank', '1000', '600');
	}else{
		openSubWindow('/IGDRM0903_Sel.do?prtype=WDC', '_blank', '1000', '600');
	}
	
}
function setPrid(prid,prname){
	jQ("#prid").val(prid);
	jQ("#prname").val(prname);
}
jQ(function(){
	if(!(jQ("#isDrill").val()=="true")){
		jQ("#labPrname").text("指挥流程名称:");
	}
	
    var listsize = jQ("#tb").find("tr").length-1;
    var tempsize = 1;
    var temp = "";
    var temptd ;
    
    jQ(".tdtitle").each(function(i,t){
    	t = jQ(t);
    	if(!temp||temp !=t.attr("name")){
    		temp = t.attr("name");
    		tempsize = 1;
    		temptd = t;
    		t.parent().children(":eq(0),:eq(1),:eq(2),:eq(3)").css("borderRight","1px solid #d3d3d3");
//     		return true;
    	}else{
    		temptd.parent().children(":eq(0),:eq(1),:eq(2),:eq(3)").attr("rowSpan",++tempsize);
    		t.parent().children(":eq(0),:eq(1),:eq(2),:eq(3)").remove();
    	}
    })
})
</script>
</body>
</html:html>