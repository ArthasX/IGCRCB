<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDRM2105" toScope="request" />
<bean:define id="title" value="场景选择" toScope="request" />
<!-- start header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- end header1 -->
<script type="text/javascript">
function getRelationEntityRec(resetFlag){
	if(resetFlag){
		window.opener.setParamIGDRM2105("resetAll","");
		window.close();
	}else{
		var message ='请至少选择一条数据！';
		var confirmMsg ='确认选择？';
		var frm = window.document.forms[0];
		if(frm.selectEiids) {
			if(frm.selectEiids.length > 0){
				var bchecked = false;
				for(var i=0; i<frm.selectEiids.length; i++ ){
					if(frm.selectEiids[i].checked == true) {
						bchecked = true;
					}
				}
				if(!bchecked) {
					alert(message);
					return false;
				}
			} else {
				if($("selectEiids").checked == false) {
					alert(message);
					return false;
				}
			}
		} else {
			alert("请至少选择一条数据！");
			return false;
		}
		
		if(window.confirm(confirmMsg)){
			//调用flex中的保存状态表单-资产的方法
			var arrStr = new Array();
			var nameStr = new Array();
			var arrs = frm.selectEiids;
			if(null == frm.selectEiids.length){
				arrs = [frm.selectEiids];
			}
			for(var i=0; i<arrs.length; i++ ){
				if(arrs[i].checked == true) {
					var values = arrs[i].value.split(",");
					arrStr.push(values[0]);
					nameStr.push(values[1]);
				}
			}
			var appendTableArr = new Array();
			jQ(":checkbox:checked:not('#allbox')").each(function(i,t){
				var appendTable = "<tr>";
				jQ(t).parent().parent().find("td").each(function(i2,t2){
					if(i2 != 0){
						appendTable += "<td>"+jQ(t2).text()+"</td>";
					}
				});
				appendTable += "<td><img onclick=\"deleteRow(this,"+jQ(t).val()+")\" src=\"images/delete_16x16.gif\"/></td></tr>";		
				appendTableArr.push(appendTable);
			});
			window.opener.setParamIGDRM2105(nameStr,arrStr,appendTableArr);
			window.close();
		}
	}
}
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<!--container 左菜单 右侧内容-->
    <!--content  右侧内容-->
    <div id="contentWrap">  
    <html:form action="IGDRM2104_Search" method="POST">
		    <!-- 左侧内容 -->
        <div id="content">
        	<div id="search">
	        <div class="img"></div>
	        <div class="conditions" >
					<div>
	        		<span>场景编号：</span>
	        		<span>
	        			<html:text property="eilabel" styleId="eilabel"/>
	        		</span>
	        		&nbsp;&nbsp;
	        		<span>场景名称：</span>
	        		<span>
	        			<html:text property="einame" styleId="einame"/>
	        		</span>
	        		&nbsp;&nbsp;
	        		<span>场景负责人：</span>
	        		<span>
	        			<html:text property="eiusername" styleId="eiusername"/>
	        		</span>
	        	</div>
	        	<div>
	        	<span>参与人：</span>
	        		<span>
	        			<html:text property="participants" styleId="participants"/>
	        		</span>
	        		<span>创建日期：</span>
	        		<span>
	        			<html:text property="eiinsdatestart" styleId="eiinsdatestart" readonly="true"/>
	        			<img src="images/date.gif" align="middle" onClick="calendar($('eiinsdatestart'))" border="0"/>
	        		</span>
	        		<span>--</span>
	        		<span>
	        			<html:text property="eiinsdateend" styleId="eiinsdateend" readonly="true"/>
	        			<img src="images/date.gif" align="middle" onClick="calendar($('eiinsdateend'))" border="0"/>
	        		</span>
	        		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        		<html:submit styleClass="button" styleId="btnSub">查询</html:submit>
	        	</div>
		        </div>
		    </div>
		    <div id="results_list" >
			<!--  message -->
				<ig:message/>
			<!--  /message -->     
	       <table width="100%" class="table_style">
	       	<tr>
	       		<th width="3%">
					<label>
						<input type="checkbox" class="delFlag" name="allbox" id="allbox" onclick="selectAll('allbox','selectEiids')"/>
					</label>
				</th>
	       		<th width="15%">场景编号</th>
	       		<th width="28%">场景名称</th>
	       		<th width="15%">场景负责人</th>
	       		<th width="10%">创建日期</th>
	       		<th width="8%">是否已演练</th>
	       		<th width="8%">场景分类</th>
	       		<th width="5%">版本</th>
	       	</tr>
	       	 <logic:present name="IGDRM21041VO" property="planList" >
	       	 	<logic:iterate id="bean" name="IGDRM21041VO" property="planList" indexId="index">
	       	 		<tr class="<ig:rowcss index="${index}"/>">
	       	 			<td>
							<html:checkbox property="selectEiids" styleClass="delFlag" value="${bean.eiid}"/>
						</td>
	       	 			<td class="">${bean.eilabel}</td>
						<td>
						<html:link action="/IGDRM0108_Disp.do?eiid=${bean.eiid}">${bean.einame }</html:link>
						</td>
	       	 			<td>${bean.eiusername }</td>
	       	 			<td>${bean.eiinsdate }</td>
	       	 			<td>${bean.isplan }</td>
	       	 			<td><c:if test="${bean.senceClassify=='1' }">演练场景</c:if><c:if test="${bean.senceClassify=='0' }">应急场景</c:if></td>
	       	 			<td> V${bean.eiversion }.${bean.eismallversion }</td>
	       	 		</tr>
	       	 	</logic:iterate>
	       	 </logic:present>
	       </table>
		 </div>
		 <div id="operate" style="float:left;margin-left:10px;">
		 	<html:button property="btn_delete" value="选择" styleClass="button" onclick="getRelationEntityRec(false);" />
			<html:button property="btn_delete" value="清空" styleClass="button" onclick="getRelationEntityRec(true);" />
			<!-- paging -->
			<jsp:include page="/include/paging.jsp"/>
			<!-- /paging -->
		</div>
    </div>
    </html:form>
</div>
</div>
</body>
</html:html>
