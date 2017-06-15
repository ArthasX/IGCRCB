<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDRM2104" toScope="request" />
<bean:define id="title" value="预案详细信息登记" toScope="request" />
<!-- start header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- end header1 -->
<script type="text/javascript">
//打开应急资源查询页面
var selectArr = new Array();
function selectEMEntityForm(){
	openSubWindow('/IGDRM2104_Search.do', '', '850', '600');
}
function setParamIGDRM2105(nameArr,resultArr,appendTableArr){
	if(resultArr == "resetAll"){
		jQ("#tab").empty();
		selectArr = new Array();
	}else if(resultArr.length>0){
		for (var i = 0; i < resultArr.length; i++) {
			if(!contains(selectArr,resultArr[i])){
				 selectArr.push(resultArr[i]);
				 jQ("#tab").append(appendTableArr[i]);
			}
		}
	}
	jQ("#messgeId").text("");
	submitBtnAction();
}
function contains(a, obj) {
    var i = a.length;
    while (i--) {
       if (a[i] === obj) {
           return true;
       }
    }
    return false;
}
function deleteRow(nowTr,eiid){
	jQ(nowTr).parent().parent().remove(); 
	for(var arrIndex = 0;arrIndex<selectArr.length;arrIndex++){
		if(selectArr[arrIndex]==eiid){
			selectArr[arrIndex] = "";
		}
	}
	jQ("#messgeId").text("");
	submitBtnAction();
}
function submitBtnAction(){
	jQ.ajax({
		url:"IGDRM2104.do",
		type:"POST",
		dataType :"json",
		data:{eiids:selectArr,eiid:'${param.eiid}',eid:'${param.eid}',cid:'${param.cid}',esyscoding:'${param.esyscoding}'},
		async:false,
		cache:false,
		success:function(res){
			jQ("#messgeId").text(res);
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			alert('出错了');
		}
	});
}
function initVal(){
	<logic:present name="IGDRM21041VO" property="planList" >
	 	<logic:iterate id="bean" name="IGDRM21041VO" property="planList" indexId="index">
	 	selectArr.push('${bean.eiid}');
	 	</logic:iterate>
    </logic:present>
}
</script>
<body onload="initVal();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<!--container 左菜单 右侧内容-->
    <!--content  右侧内容-->
    <div id="contentWrap">  
    <html:form action="IGDRM2104" method="POST">
		    <!-- 左侧内容 -->
        <div id="content">
			<table border="0" style="margin-top: -5px;">
				<tr>
					<td align="center"><html:button onclick="selectEMEntityForm();" property="selectBtn" styleClass="button" styleId="btnSub">选择</html:button></td>
<%-- 					<td align="center"><html:button styleClass="button" property="submitBtn" styleId="btnSub" onclick="submitBtnAction();">保存</html:button></td> --%>
				</tr>
			</table>
		    <div id="results_list" >
			<!--  message -->
			<div id="messgeId"></div>
			<!--  /message -->     
	       <table width="100%" class="table_style">
	       	<tr>
	       		<th width="10%">场景编号</th>
	       		<th width="19%">场景名称</th>
	       		<th width="12%">场景负责人</th>
	       		<th width="10%">创建日期</th>
	       		<th width="8%">是否已演练</th>
	       		<th width="8%">场景分类</th>
	       		<th width="8%">版本</th>
	       		<th width="6%">操作</th>
	       	</tr>
   	 		<tbody  id="tab">
	       	 <logic:present name="IGDRM21041VO" property="planList" >
	       	 	<logic:iterate id="bean" name="IGDRM21041VO" property="planList" indexId="index">
	       	 		<tr class="<ig:rowcss index="${index}"/>">
	       	 			<td class="">${bean.eilabel}</td>
						<td>
							${bean.einame }
						</td>
	       	 			<td>${bean.eiusername }</td>
	       	 			<td>${bean.eiinsdate }</td>
	       	 			<td>${bean.isplan }</td>
	       	 			<td><c:if test="${bean.senceClassify=='1' }">演练场景</c:if><c:if test="${bean.senceClassify=='0' }">应急场景</c:if></td>
	       	 			<td> V${bean.eiversion }.${bean.eismallversion }</td>
	       	 			<td><img onclick="deleteRow(this, ${bean.eiid})" src="images/delete_16x16.gif"/></td>
	       	 		</tr>
	       	 	</logic:iterate>
	       	 </logic:present>
   	 		</tbody>
	       </table>
		 </div>
    </div>
    </html:form>
</div>
</div>
</body>
</html:html>