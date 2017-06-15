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
<html:html>
<bean:define id="id" value="IGRIS0614" toScope="request" />
<bean:define id="title" value="检查项资产查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<%

	Map<Integer,String> stopbuttonmap = new HashMap<Integer,String>();
	Map<Integer,String> startbuttonmap = new HashMap<Integer,String>();
	if(null!=request.getAttribute("stopbuttonMap")){
		stopbuttonmap = (Map)request.getAttribute("stopbuttonMap");
	}
	if(null!=request.getAttribute("startbuttonMap")){
		startbuttonmap = (Map)request.getAttribute("startbuttonMap");
	}
	
%>

<!-- /header1 -->
<script type="text/javascript">	
         var gid='IGRIS0614';
         //删除所选
        function deleteRec(){
             var message ='<bean:message key="IGCO10000.E002"/>';
             var confirmMsg ='<bean:message key="IGCO10000.W002" arg0="检查项基本信息" />';
             var frm = window.document.forms[0];
             if(frm.deleteEiid) {
     	        if(frm.deleteEiid.length > 0){
     	            var bchecked = false;
     	            for( i=0; i<frm.deleteEiid.length; i++ ){
     	                if (frm.deleteEiid[i].checked == true){
     	                    bchecked = true;
     	                }
     	            }
     	            if (!bchecked) {
     	            	alert(message);
     	                return false;
     	            }
     	        } else {
     	          if ($("deleteEiid").checked == false){
     	              alert(message);
     	              return false;
     	          }  
     	        }
             } else {
             	alert("没有可删除的数据！");
                 return false;
             }

             if( window.confirm(confirmMsg)){
                 form.action = getAppRootUrl() + "/IGRIS0614_Del.do";
                 return true;
             } else {
                 return false;
             }
     	}
function setEntity(url){
	url = url+"?roletype=IGBP19&subtype=999021";
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.getElementById("ename").value = "";
		//document.getElementById("eid").value = "";
		document.getElementById("syscoding").value = "";
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		var syscode_eid = temp.split("|")[0];
		var name = temp.split("|")[1];
		var syscode;
		var eid;
		if(syscode_eid =="999")
		{
			alert("资产模型不可用！请选择其他模型！");
			return false;
			
		}else if(syscode_eid.split("_").length>1){
			eid = syscode_eid.split("_")[0];
			syscode = syscode_eid.split("_")[1];
		}
		document.getElementById("ename").value = name; 
		document.getElementById("syscoding").value = syscode;
}
}
function searchuser(){	
	openSubWindow('/IGSYM1905_Disp.do?', '_blank','1000','600','center:1');
}
function setIGCYB0101Params(username,orgname,orgid,useremail,userphone,usermobile,userid){
	document.getElementById("managername").value = username;
	document.getElementById("mguserid").value = userid;
}
function checkitem(eid,version){
	window.location.href="IGRIS0604_Disp.do?eiid="+eid+"&eiversion="+version+"&looksign=0";
}

function onExcel(){
	form.action = "IGRIS0614_Excel.do";
	form.submit();
}
function onSearch(){
	form.action = "IGRIS0614.do";
	form.submit();
}
</script>
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
    
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
          <html:form styleId="form" action="/IGRIS0614" onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
            </div>
            <div id="search">
                   <div class="img"></div>
                   <div class="conditions">
                   <div style="margin-top:4px">
                   <span class="subscribe">风险分类：</span>
                   <html:text property="ename" styleId="ename" readonly="true" />
                   	<img src="images/tree.gif" style="cursor: hand;" alt="风险分类" width="16" height="16" border="0" onclick="setEntity('IGSYM0304_RISK.do');"/>
					<html:hidden property="syscoding"/>
            		<span class="subscribe">检查项名称：</span>
            		<html:text property="einame" styleId="einame"/>
            		<span class="subscribe">检查项编号：</span>
            		<html:text property="eilabel" styleId="eilabel"/>
					<span class="subscribe">建议检查频度：</span>
					<html:select property="checkfrequency" styleId="checkfrequency" style="width:80px">
					<option value="">  </option>
						<logic:present name="IGRIS06071VO" property="checkfrequencyList" >
						<html:optionsCollection name="IGRIS06071VO" property="checkfrequencyList" label="ccdvalue" value="ccdvalue"/>						
						</logic:present> 
					</html:select>
					<html:submit property="btn_search" style="margin-left:5px" styleClass="button" value="查询" onclick="onSearch()"/>
                   </div>
                    <div style="margin-top:12px">
            		<span class="subscribe">检查项管理人：</span>
            		<html:text property="mguserid" styleId="mguserid" readonly="true" />
            		<img  id="img01" src="images/seek.gif" border="0" style="cursor: pointer;" onclick="searchuser();"/>
            		<html:hidden property="managername" styleId="managername"/>
					<span class="subscribe">登记日：</span>
					<html:text property="startdate" styleId="startdate" errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
					<img src="images/date.gif" align="middle" onclick="calendar($('startdate'))" border="0" style="cursor: hand" />
					<span>&nbsp;--&nbsp;</span>
					<html:text property="enddate" styleId="enddate" errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
					<img src="images/date.gif" align="middle" onclick="calendar($('enddate'))" border="0" style="cursor: hand" />
					<input type="button" value="导出" class="button" style="margin-left:39px;" onclick="onExcel()">
					
                   </div>
                   </div>
                </div>
                
                <div id="results_list">
					<ig:message />
                    <table class="table_style"  >
						<!-- header部 -->
						
							<tr>
								<th width="10%">风险领域</th>
								<th width="10%">风险子域</th>
								<th width="8%" >风险项</th>
								<th width="8%">编号</th>
								<th width="16%">检查项名称</th>
								<th width="12%">检查项说明</th>
								<th width="6%">管理人</th>
								<th width="6%">登记日</th>
								<th width="8%">建议检查频度</th>
							</tr>
						
						 <logic:present name="IGRIS06071VO" property="itemList" >
		               <logic:iterate id="bean" name="IGRIS06071VO" property="itemList" indexId="index">
									<tr class="<ig:rowcss index="${index}"/>">

										<td>
											${bean.riskly }
										</td>
											
										<td>
											${bean.riskarea}
										</td>
											
										<td>
											${bean.riskitem}
										</td>
										<td>
										<a href="javascript:void(0)" onclick="checkitem('${bean.eiid}','${bean.eiversion }')">${bean.eilabel}</a>
										</td>
										
										<td title="${bean.einame }">
											<ig:SubstringShowEllipsisWriteTag len="10" showEllipsis="true">
												${bean.einame }
											</ig:SubstringShowEllipsisWriteTag>
										</td>
										<td title="${bean. eidesc}">
											<ig:SubstringShowEllipsisWriteTag len="10" showEllipsis="true">
												${bean. eidesc}
											</ig:SubstringShowEllipsisWriteTag>
										</td>
										<td>
											${bean.mguserid }
										</td>
										<td>
											${bean.eiinsdate }
										</td>
										<td>
											${bean.checkfrequency }
										</td>
									</tr>
									
									</logic:iterate>
									</logic:present>
					</table>
				</div>
				<div id="operate">
				
	             <jsp:include page="/include/paging.jsp" />
                </div>
                <html:hidden property="syscoding"/>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>