<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<html:html>
<bean:define id="id" value="IGCIC0202" toScope="request" />
<bean:define id="title" value="比对结果查看画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css">
.host {
	color: red;
}
#results_list  a:link{
   color:red;
   text-decoration:none;
}
#results_list a:visited{
   color:red;
   text-decoration: none;
}
#results_list a:hover{
   color:red;
   text-decoration:underline;
}
#results_list a:active{
   color:red;
   text-decoration: none;
}
 
</style>
<script type="text/javascript">
<!--
	
//-->
</script>
<body>
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
							<p class="fonts1">
								<ig:navigation extname1="${urlable}" />
							</p>
							<div class="back"><a href="IGCIC0201_Back.do" target="_self">返回</a></div> 
						</div>
						<div id="results_list">
							<ig:message />
							<table class="table_style">
								<tr>
									<th width="10%">业务系统</th>
									<th width="20%">规则类型</th>
									<th width="70%">比较对象</th>
								</tr>
								<c:forEach items="${IGCIC02021VO.resultVoMap}" var="map">
									<c:forEach items="${map.value}" var="obj" varStatus="sta">
										<tr>
											<c:if test="${sta.count == 1}">
												<td rowspan="${fn:length(map.value) }">${map.key }</td>
											</c:if>
											<td>
												<ig:codeValue ccid="COMPARE_TYPE" cid="${obj. crtype}"/>
											</td>
											<td align="left">
												
											<c:forEach items="${ obj.cotargetVOLi}" var="vomap">
												${vomap.key } -- > 
												<c:forEach items="${vomap.value}" var="vomapval">
													<c:if test="${vomapval.isDifferent == '0' }">
														${vomapval.hostname }
													</c:if> 
													<c:if test="${vomapval.isDifferent == '1' }">
														<span class="host">
															<a href="IGCIC0205.do?coid=${vomapval.coid }&cpid=${cpid}"  >${vomapval.hostname }</a>
														</span>
													</c:if> 
												</c:forEach> </br>
											</c:forEach>
											
											</td>
										</tr>
									</c:forEach>
								</c:forEach>
							</table>
						</div>
				</div>
			</div>
			<div class="zishiying"></div>
		</div>


	</div>
</body>
</html:html>