<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGALM0202" toScope="request"/>
<bean:define id="title"  toScope="request">
	规则模板管理
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">	
function deleteRec(obj){
	if(checkNum(obj)==0){
		alert("请选择删除对象！");
        return false;
	}
    
    if( window.confirm("确认删除吗？")){
        form.action = getAppRootUrl() + "/IGALM0202_Del.do";
        return true;
    } else {
        return false;
    }
}

function changeStatus(id,status){
	if(confirm("是否改变状态？")){
		var form = document.getElementById("form");
		form.action="IGALM0202_ChangeStatus.do?ruletempid="+id+"&tempstate="+status;
		form.submit();
	}
}
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
<html:form styleId="form" action="/IGALM0202">
           <div id="location">
                <div class="image"></div>
                <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
           </div>    
           <div id="search">
	       <div class="img"></div>
	       <div class="conditions">
                    <div class="conditions_border1">
                        <div>
                        <label>模板名：</label><html:text property="ruletempname_like"></html:text>
						&nbsp;
		                <label>状态：</label>
		                <html:select property="tempstate_eq">
		                	<html:option value="2">&nbsp;</html:option>
		                	<html:option value="0">停用</html:option>
		                	<html:option value="1">可用</html:option>
		                </html:select>
                        &nbsp;
                        <label>类型：</label>
                        <html:select styleId="typecid" property="typecid" style="width: 130px;" errorStyleClass="inputError">
							<html:options collection="monitorTypeList" property="value" name="" labelProperty="label" />
						</html:select>
                       	&nbsp;
                        <html:submit property="btn_search"  styleClass="button">
                        		查询
                        </html:submit>
                       </div>
                   </div>
	      	</div>
         	</div>
         	
         	<div id="results_list">
			<!--  message --> <ig:message /> <!--  /message -->
			<table class="table_style">
				<!-- header部 -->
				<tr>
					<th width="4%">
					<label> <input type="checkbox"
					name="checkbox" id="checkbox" onclick="selectAll('checkbox','deleteId')"/> </label>
					</th>
					<th>模板名称</th>
					<th>条件</th>
					<th>类型</th>
					<th>指标类型</th>	
					<th>条件个数</th>
					<th>状态</th>	
					<th>修改 </th>
				</tr>
				<!-- body部 -->
				<logic:present name="IGALM02021VO" property="crm08InfoList">
					<logic:iterate id="bean" name="IGALM02021VO"
						property="crm08InfoList" indexId="index">
						<tr class="<ig:rowcss index="${index}"/>">
							<td>
							<html:checkbox property="deleteId" value="${bean.ruletempid}"/>
							</td>
							<!-- 模板名称-->
							<td>
							<div class="nowrapDiv">${bean.ruletempname}</div>
							</td>
							<!-- 条件-->
							<td>
							<div class="nowrapDiv">
							<c:if test="${bean.rulecondition==0}">
							与
							</c:if>
							<c:if test="${bean.rulecondition==1}">
							或
							</c:if>
							</div>
							</td>
							<!-- 类型 -->
							<td>
							<div class="nowrapDiv">
							<ig:codeValue ccid="PERF_MONITOR_TYPE" cid="${bean.typecid}"/>
							</div>
							</td>
							<!-- 指标类型-->
							<td>
							<div class="nowrapDiv">
							${bean.codeDetailTB.cvalue}
							</div>
							</td>
							<!-- 条件个数-->
							<td>
							<div class="nowrapDiv">
							<bean:size id="size" name="bean" property="crm07TBList"/>
							${size }
							</div>
							</td>
							<!-- 状态-->
							<td>
							<div class="nowrapDiv">
								<logic:equal name="bean" property="tempstate" value="0">									
									<a href="javascript:changeStatus(${bean.ruletempid},1);"><img src="images/stop.gif" border="0" alt="停用"/></a>
								</logic:equal>
								<logic:equal name="bean" property="tempstate" value="1">									
									<a href="javascript:changeStatus(${bean.ruletempid},0);"><img src="images/start.gif" border="0" alt="启用"/></a>
								</logic:equal>
							</div>
							</td>
							<!-- 修改-->
							<td>
							<div class="nowrapDiv">
							<html:link action="/IGALM0203_Edit_Disp.do?ruletempid=${bean.ruletempid}">
								<img src="images/edit.gif" width="16" height="16" border="0" alt='修改'/>
							</html:link>
							</div>
							</td>
						</tr>
					</logic:iterate>
				</logic:present>
			</table>
			</div>
			<div id="operate">
                            <logic:present name="IGALM02021VO" property="crm08InfoList" >
                            <html:submit property="btn_delete"  styleClass="button" onclick="return deleteRec('deleteId');" >
                        		删除
                            </html:submit>
                            </logic:present>
			                <!-- paging -->
			                <jsp:include page="/include/paging.jsp"/>
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