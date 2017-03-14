<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.deliverik.infogovernor.util.SVCHelper"%>
<html:html>
<bean:define id="id" value="IGSMR0803" toScope="request" />
<bean:define id="title" value="监管报表详细页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">

</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> 
	<jsp:include page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation /></p>
	
	<div class="back">
		<a href="IGSMR0801_SEARCH.do?assesstype=${IGSMR08031VO.flag}" target="_self">返回</a>
	</div> 
	</div>
	</div>

<div id="results_list">
	<table class="table_style">
		<tr align="center">
			<th width="10%">姓名</th>
			<th width="30%">年报</th>
			<th width="30%">季报</th>
			<th width="30%">不定期</th>
		</tr>
		<logic:present name="IGSMR08031VO" property="detailMap">
		
		<logic:iterate id="map" name="IGSMR08031VO" property="detailMap">
			<bean:define id="list_dou" name="map" property="value"/>
			<bean:define id="userid" name="map" property="key"/>
			<bean:size id="listsize" name="list_dou"/>
			<logic:iterate id="bean" name="list_dou" indexId="index">			
			<tr>
			
			<c:if test="${index==0 }">
			<td rowspan="${listsize }">
			${bean.username }
			</td>
			</c:if>	
			
					<logic:equal name="bean" property="name_y" value="">
						<td>&nbsp;</td>
					</logic:equal>
					<logic:notEqual name="bean" property="name_y" value="">
					<c:if test="${bean.ontime_y == 1 && bean.con_y > 1}">
						<td>${bean.name_y }
						<img src="images/229.gif" alt="不及时" width="16" height="16" border="0"/>
						<img src="images/201.gif" alt="不准确" width="16" height="16" border="0"/>
						</td>
					</c:if>
					<c:if test="${bean.ontime_y == 0 && bean.con_y <= 1 }">
						<td>${bean.name_y }
						</td>
					</c:if>
					<c:if test="${bean.ontime_y == 1 && bean.con_y <= 1 }">
						<td>${bean.name_y }
						<img src="images/229.gif" alt="不及时" width="16" height="16" border="0"/>
						</td>
					</c:if>
					<c:if test="${bean.ontime_y == 0 && bean.con_y > 1 }">
						<td>${bean.name_y }
						<img src="images/201.gif" alt="不准确" width="16" height="16" border="0"/>
						</td>
					</c:if>
					</logic:notEqual>
				
					
					<logic:equal name="bean" property="name_m" value="">
						<td>&nbsp;</td>
					</logic:equal>
					<logic:notEqual name="bean" property="name_m" value="">
					<c:if test="${bean.ontime_m == 1 && bean.con_m > 1}">
						<td>${bean.name_m }
						<img src="images/229.gif" alt="不及时" width="16" height="16" border="0"/>
						<img src="images/201.gif" alt="不准确" width="16" height="16" border="0"/>
						</td>
					</c:if>
					<c:if test="${bean.ontime_m == 0 && bean.con_m <= 1 }">
						<td>${bean.name_m }
						</td>
					</c:if>
					<c:if test="${bean.ontime_m == 1 && bean.con_m <= 1 }">
						<td>${bean.name_m }
						<img src="images/229.gif" alt="不及时" width="16" height="16" border="0"/>
						</td>
					</c:if>
					<c:if test="${bean.ontime_m == 0 && bean.con_m > 1 }">
						<td>${bean.name_m }
						<img src="images/201.gif" alt="不准确" width="16" height="16" border="0"/>
						</td>
					</c:if>
					</logic:notEqual>
					
					<logic:equal name="bean" property="name_z" value="">
						<td>&nbsp;</td>
					</logic:equal>
					<logic:notEqual name="bean" property="name_z" value="">
					<c:if test="${bean.ontime_z == 1 && bean.con_z > 1}">
						<td>${bean.name_z }
						<img src="images/229.gif" alt="不及时" width="16" height="16" border="0"/>
						<img src="images/201.gif" alt="不准确" width="16" height="16" border="0"/>
						</td>
					</c:if>
					<c:if test="${bean.ontime_z == 0 && bean.con_z <= 1 }">
						<td>${bean.name_z }
						</td>
					</c:if>
					<c:if test="${bean.ontime_z == 1 && bean.con_z <= 1 }">
						<td>${bean.name_z }
						<img src="images/229.gif" alt="不及时" width="16" height="16" border="0"/>
						</td>
					</c:if>
					<c:if test="${bean.ontime_z == 0 && bean.con_z > 1 }">
						<td>${bean.name_z }
						<img src="images/201.gif" alt="不准确" width="16" height="16" border="0"/>
						</td>
					</c:if>
					</logic:notEqual>
			</tr> 
			</logic:iterate> 
			</logic:iterate> 
		
		
		</logic:present>

	</table>
	
	</div>
	</div> 
	
	<html:hidden property="prTypeArray" value="I"/>
	
</div>
</div>
<div class="zishiying"></div>
</body>
</html:html>
