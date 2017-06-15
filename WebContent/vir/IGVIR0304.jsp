<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<script type="text/javascript" src="js/menu/jquery.js"></script>
<html:html>
<bean:define id="id" value="IGVIR0203" toScope="request"/>
<bean:define id="title" value="项目信息" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">	
	function selectProject(id, name){
		window.returnValue = id;
		window.close();
	}
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<%-- <jsp:include page="/include/header2.jsp" /> --%>
<!--container 左菜单 右侧内容-->
<div id="container">
     
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content" style="width: 800px">
			<div class="title">
			<div class="name">虚机信息</div>
			</div>
			<table id="vminfo" cellspacing="0" class="table_style" style="margin-top: 5px; width: 98%;" >
				<tr>
					<th style="text-align: center;" width="5%">序号</th>
					<th style="text-align: center;" width="15%">项目名称</th>
<!-- 					<th style="text-align: center;" width="15%">所属机构</th> -->
					<th style="text-align: center;" width="15%">项目类别</th>
					<th style="text-align: center;" width="10%">项目到期时间</th>
				</tr>
				<logic:present name="IGVIR03041VO" property="vim02List">
						<logic:iterate id="bean" name="IGVIR03041VO" property="vim02List" indexId="index">
							<tr class="<ig:rowcss index="${index}"/>" onclick="selectProject('${bean.id}')" style="cursor: pointer;">				
								<td>${index+1}</td>
								
								<td>${bean.projectName}</td>
								
<%-- 								<td>${bean.orgname}</td> --%>
								
								<td>${bean.projectType}</td>
								
								<td>${bean.projectExpireTime}</td>
								
							</tr>
						</logic:iterate>
					</logic:present>
			</table>
			<input type="hidden" id="vmpid" value="${IGVIR02031VO.pid}">
        </div>
    </div>
</div>

</div>
</body>
</html:html>