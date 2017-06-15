<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html:html>
<bean:define id="id" value="IGDRM1701" toScope="request" />
	<bean:define id="title" value="培训记录管理" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<style>
.table_style tr:HOVER {
	background-color: #acacac;
	cursor: pointer;
}
.ellips{
width:100%; 
white-space:nowrap; 
text-overflow:ellipsis; 
overflow:hidden;
}
</style>
<!-- /header1 -->
<script type="text/javascript">
//机构选择
function setOrg(url){
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.getElementById("tarorgid").value="";
		document.forms[0].tarorgname.value = "";
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		document.getElementById("tarorgid").value = temp.split("|")[0];
		document.forms[0].tarorgname.value = temp.split("|")[1];
	}	
}
function deleteinfo(trid){
	if(confirm("确认删除培训记录")){
		document.forms[0].action=getAppRootUrl() + "/IGDRM1701_DELETE.do?trid="+trid;
		document.forms[0].submit();
	}
		(window.event)&&(window.event.cancelBubble=true); 
}
function edit(trid){
	document.forms[0].action=getAppRootUrl() + "/IGDRM1702_Disp.do?trid="+trid;
	document.forms[0].submit();
	(window.event)&&(window.event.cancelBubble=true);
}

function showDetail(trid){
	window.location.href = getAppRootUrl()+"/IGDRM1702_Disp.do?backUrl=0&trid="+trid;
}

function deleteRec(){
    var message ='<bean:message key="IGCO10000.E002"/>';
    var confirmMsg ='<bean:message key="IGCO10000.W002" arg0="设备基本信息" />';
    var frm = window.document.forms[0];
    if(frm.deleteTrid) {
        if(frm.deleteTrid.length > 0){
            var bchecked = false;
            for( i=0;i<frm.deleteTrid.length;i++ ){
                if (frm.deleteTrid[i].checked == true){
                    bchecked = true;
                }
            }
            if (!bchecked) {
            	alert(message);
                return false;
            }
        } else {
          if ($("deleteTrid").checked == false){
              alert(message);
              return false;
          }  
        }
    } else {
    	alert("没有可删除的数据！");
        return false;
    }
    

    if( window.confirm(confirmMsg)){
        form.action = getAppRootUrl() + "/IGDRM1701_DELETE.do";
        return true;
    } else {
        return false;
    }
}


</script>
<body onload="">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<html:form action="/IGDRM1701" styleId="form">
	<div id="location">
	<div class="image"></div>
		<p class="fonts1">应急管理 >> 培训管理 >> 培训记录管理</p>
		
	</div>
	<div id="search">
		<div class="img"></div>
		<div class="conditions">
			<div>
				<table>
					<tr >
						<td>培训名称：</td>
						<td><html:text property="trname" styleId="trname" /></td>
						<td>开始时间：</td>
						<td><html:text property="trstimeFrom" readonly="true" styleId="trstimeFrom" onclick="showDate(this)"/>
							到：
							<html:text property="trstimeTo" readonly="true"  styleId="trstimeTo" onclick="showDate(this)" />
						</td>
						<td>
							<html:submit styleClass="button">查询</html:submit>
						</td>
					</tr>
					
				</table>
			</div>
		</div>
	</div>
	<div id="results_list">   <ig:message />  
	<table class="table_style">
		<tr>
		  <th  width="5%">
             <label>
             <input type="checkbox" name="allbox" id="allbox" onclick="selectAll('allbox','deleteTrid')"/>
             </label>
           </th>
			<th width="9%">培训名称</th>
			<th width="9%">计划开始时间</th>
			<th width="9%">计划结束时间</th> 	
			<th width="9%">培训内容</th>
			<th width="9%">培训地点</th>
			<th width="9%">讲师</th>
			<!-- <th width="5%">删除</th> -->
			<th width="10%">修改</th>										
		</tr>
		<logic:present name="IGDRM17011VO" property="trainrecordList">
			<logic:iterate id="bean" name="IGDRM17011VO" property="trainrecordList" indexId="index">
				<%-- <tr onclick="showDetail('${bean.trid}')" class="<ig:rowcss index="${index}"/>"> --%>
				<tr class="<ig:rowcss index="${index}"/>">
					<td> <html:checkbox property="deleteTrid" value="${bean.trid}"/> </td>
					<td title="${bean.trname}"><div style="width:100%; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${bean.trname}</div></td>
					<td>${bean.trstime}</td>
					<td>${bean.tretime}</td>
					<td title="${bean.trside}"><div style="width:100%; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${bean.trside}</div></td>
					<td title="${bean.tpcontent}"><div style="width:100%; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${bean.tpcontent}</div></td>
					<td title="${bean.trlecturer}"><div style="width:100%; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${bean.trlecturer}</div></td>
					<%-- <td>&nbsp;
						<a href="javascript:void(0);" onclick="deleteinfo('${bean.trid}')">
							<img src="images/delete_16x16.gif" width="16" alt="删除" height="16" border="0"/>
						</a>
					</td> --%>
					<td>
						<a href="javascript:void(0);" onclick="edit('${bean.trid}')">
							<img src="images/edit.gif" width="16" alt="修改" height="16" border="0"/>
						</a>
					</td>
				</tr>
        	</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	  <logic:present name="IGDRM17011VO" property="trainrecordList" >
      <html:submit property="btn_delete" value="删除所选" styleClass="button" onclick="return deleteRec();" />
      </logic:present>
	<jsp:include page="/include/paging.jsp" />
	</div>
	</html:form>
</div>
</div>
</div>
<div class="zishiying"></div>
</div>
</body>
</html:html>
