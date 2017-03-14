<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="java.util.*;" %>
<html:html>
<bean:define id="id" value="IGVIR0903" toScope="request"/>
<bean:define id="title"  toScope="request" value="策略管理"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<body onLoad="">
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
                  <p class="fonts1">计费管理 >> 计费策略 >> 策略管理</p>
            </div> 
            <html:form action="/IGVIR0901_Search" method="POST">
	             <div id="search">
			             <div class="img"></div>
			             <div class="conditions">
	                          <div class="conditions_border1">
		                          <div>
		                          		<label>策略名称:</label>&nbsp;<html:text property="strategyName_eq"></html:text>
										&nbsp;&nbsp;&nbsp;
										<html:submit styleClass="button">查询</html:submit>
		                          </div>
	                          </div>
	                     </div>
	             </div>   
            
            <div id="results_list">
					<!--  message -->
					<ig:message/>
					<!--  /message -->     
			       <table width="100%" class="table_style">
			       		<tr>
			       			<th width="6%"><input type="checkbox" onclick="changeAll(this)"/></th>
			       			<th width="8%">序号</th>
			       			<th width="12%">策略名称</th>
			       			<logic:present name="IGVIR09011VO" property="configItemList" >
			       				<logic:iterate id="bean" name="IGVIR09011VO" property="configItemList" indexId="index">
			       					<th>${bean.cvalue}</th>
			       				</logic:iterate>
			       			</logic:present>
			       			<th width="8%">操作</th>
			       		</tr>
			       		<logic:present name="IGVIR09011VO"  property="strategies">
				       		<logic:iterate id="bean" name="IGVIR09011VO" property="strategies" indexId="index">
					       		<tr class="<ig:rowcss index="${index}"/>">
					       			<td><html:checkbox property="delids" value="${bean.id }"></html:checkbox></td>
					       			<td>${PagingDTO.viewStartCount+index}</td>
					       			<td>${bean.name}</td>

					       			<logic:iterate id="bean2" name="IGVIR09011VO" property="configItemList" indexId="index2">
					       				<%
					       					String flag = "no";
					       				%>
					       				<logic:iterate id="bean1" name="bean" property="configItemList" indexId="index1">
					       					<c:if test="${bean1.resourceitem == bean2.cid}">
					       						<td>${bean1.price}元/天</td>
					       						<%
					       							flag = "yes";
					       						%>	
					       					</c:if>
					       				</logic:iterate>
					       				<%
					       					if("no".equals(flag)){
					       				%>	
					       					<td>0元/天</td>
					       					<%} %>
					       			</logic:iterate>
					       			<td><a href="javascript:void(0)" onclick="modifyStr(${bean.id})">修改</a></td>
					       		</tr>
				       		</logic:iterate>
			       		</logic:present>
			       </table>	
            </div>
            <div id="operate">
            	<logic:present name="IGVIR09011VO"  property="strategies">
           			<html:button property="btn_re" styleClass="button" value="删除" onclick="deleteStr();"></html:button>
           		</logic:present>
           		<jsp:include page="/include/paging.jsp"/>
		    </div>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
<script type="text/javascript">
	function changeAll(obj){
		jQuery(":checkbox[name='delids']").attr("checked",jQuery(obj).attr("checked"));
	}

	function deleteStr(){
		if(jQuery(":checkbox:checked[name='delids']").length==0){
			alert("请选择将要删除的策略");
			return false;
		}
		if(confirm("确定删除？")){
			document.forms[0].action = getAppRootUrl()+"/IGVIR0901_Del.do";
			document.forms[0].submit();
		}
	}

	function modifyStr(id){
		document.forms[0].action = getAppRootUrl()+"/IGVIR0901_Edit_Disp.do?strid="+id;
		document.forms[0].submit();
	}
	
</script>
</body>
</html:html>