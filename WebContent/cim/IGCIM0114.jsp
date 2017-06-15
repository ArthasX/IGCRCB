<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCIM0114" toScope="request" />
<bean:define id="title" value="采集版本比较" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
	function isGoclose(){
		if( window.confirm("确定关闭吗?")){
           window.close();
        } else {
            return false;
        }
	}
</script>
<style type="text/css">
	#datatable tr td{
		border-left:#d3d3d3 1px solid;
		border-right:#d3d3d3 1px solid;
	}
</style>
<body >
<div id="maincontent">
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<div id="location">
    	<div class="image"></div>
        <p class="fonts1"><ig:navigation extname1="${urlable}"/> &gt;&gt; 配置原数据（${IGCIM01141VO.host }）&gt;&gt;命令详细比较</p>
    </div>  
	<html:form styleId="form" action="/IGCIM0114_Search.do">
			<div style="width:98%;border:#a2cbf3 1px solid;margin-left:10px;margin-top:2px;">
				<table class="table_style">
					<tr>
						<th width="10%" style="border-right:#a2cbf3 1px solid">CI名</th>
						<td width="15%" style="border-right:#a2cbf3 1px solid">${IGCIM01141VO.host }</td>
						<th width="10%" style="border-right:#a2cbf3 1px solid">采集命令</th>
						<td width="40%" >${IGCIM01141VO.keys }</td>
					</tr>
				</table>
			</div>
			<div style="width:98%;height:480px;border:#a2cbf3 1px solid;margin-left:10px;margin-top:10px;overflow-x:hidden;">
			 <logic:present name="IGCIM01141VO" property="cr01List1" >
			 	<table class="table_style">
				 <tr>
					<th width="10%" style="border-right:#a2cbf3 1px solid">版本时间</th>
					<td width="40%" style="border-right:#a2cbf3 1px solid">${IGCIM01141VO.collecttime1 }</td>
					<th width="10%" style="border-right:#a2cbf3 1px solid">版本时间</th>
					<td width="40%">${IGCIM01141VO.collecttime2 }</td>
				</tr>
				</table>
				<div style="height:450px;overflow-y:scroll;overflow-x:hidden;">
				<div style="float: left;width: 50%">
				<table class="table_style">
			 	<logic:iterate id="bean" name="IGCIM01141VO" property="cr01List1" indexId="index">
		 		<c:if test="${bean.cdata!=''}">
				 	<tr>
						<!--<td width="10%" align="left" style="border-right:#a2cbf3 1px solid" >${index}</td>-->
						<td align="left" style="border-right: 1px solid"><pre>${bean.cdata}</pre></td>
					</tr>
				</c:if>
			 	</logic:iterate>
			 	</table>
			 	</div>
			 	<div style="float: right;">
				<table class="table_style">
			 	<logic:iterate id="bean" name="IGCIM01141VO" property="cr01List2" indexId="index">
		 		<c:if test="${bean.cdata!=''}">
				 	<tr>
						<!--<td width="10%" align="left" style="border-right:#a2cbf3 1px solid" >${index}</td>-->
						<td align="left" style="border-right: 1px solid"><pre>${bean.cdata}</pre></td>
					</tr>
				</c:if>
			 	</logic:iterate>
			 	</table>
			 	</div>
			 	</div>
			 </logic:present>
			</div>
		<ig:message/>
		<div class="enter">
		  <!-- paging -->
            <html:button property="close" value="关闭" styleClass="button" onclick="isGoclose();"/>
         <!-- /paging -->
         </div>
	</html:form>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>

