<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.drm.vo.IGDRM15011VO"%>
<html:html>
<bean:define id="id" value="IGDRM1511" toScope="request" />
<bean:define id="title" value="培训计划管理画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
    var delAttachList = "1";
<!--
	

//条件查询
function searchFunction(){
	 form.action = getAppRootUrl() + "/IGDRM1511_Disp.do";
	return true;
}

//-->
WebCalendar.timeShow   = true;          //是否返回时间

function deleteRec(){
    var message ='<bean:message key="IGCO10000.E002"/>';
    var confirmMsg ='<bean:message key="IGCO10000.W002" arg0="培训计划" />';
    var frm = window.document.forms[0];
    if(frm.deleteTpid) {
        if(frm.deleteTpid.length > 0){
            var bchecked = false;
            for( i=0;i<frm.deleteTpid.length;i++ ){
                if (frm.deleteTpid[i].checked == true){
                    bchecked = true;
                }
            }
            if (!bchecked) {
            	alert(message);
                return false;
            }
        } else {
          if ($("deleteTpid").checked == false){
              alert(message);
              return false;
          }  
        }
    } else {
    	alert("没有可删除的数据！");
        return false;
    }
    
    if( window.confirm(confirmMsg)){
        form.action = getAppRootUrl() + "/IGDRM1511_Delete.do";
        return true;
    } else {
        return false;
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
					<html:form styleId="form" action="/IGDRM1511_Disp"
						onsubmit="return checkSubmit(this);">
						<div id="location">
							<div class="image"></div>
							<p class="fonts1">
								应急管理 >> 培训管理 >> 培训计划管理
							</p>
						</div>

						<div id="search">
							<div class="img"></div>
							<div class="conditions">
							
							         <span>创建时间：</span> 
							         <span> <html:text name="IGDRM1501Form" property="startTimeBegin" styleId="startTimeBegin" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
												<img src="images/date.gif" align="middle" onclick="calendar($('startTimeBegin'))" border="0" style="cursor: hand;"/>
												<span>&nbsp;&nbsp;<font style="font-weight: bold;">到</font></span>
												<html:text name="IGDRM1501Form" property="startTimeEnd" styleId="startTimeEnd" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
												<img src="images/date.gif" align="middle" onclick="calendar($('startTimeEnd'))" border="0" style="cursor: hand;"/>
									</span>
							         <span>创建人：</span> 
							         <span> <html:text
											property="tpusername" styleId="tpusername"
											errorStyleClass="inputError imeDisabled" size="15"
											maxlength="32" tabindex="1" />
									</span>
									<span>创建部门：</span> 
							         <span> <html:text
											property="tporgname" styleId="tporgname"
											errorStyleClass="inputError imeDisabled" size="15"
											maxlength="32" tabindex="1" />
									</span>
									
									
									<span> <html:submit property="btn_search"
												styleClass="button" value="查询" />
										</span>
							
							</div>
						</div>
						<div id="results_list">
							<ig:message />
							<table class="table_style" id="table1">
								<tr>
									 <th  width="5%">
					             <label>
					             <input type="checkbox" name="allbox" id="allbox" onclick="selectAll('allbox','deleteTpid')"/>
					             </label>
					           </th>
									<th width="13%" align="left">培训计划名称</th>
									<th width="13%" align="left">发起部门</th>
									<th width="9%" align="left">发起人</th>
									<th width="9%" align="left">发起时间</th>
									<th width="5%" align="center">编辑</th>
									<!-- <th width="5%" align="center">删除</th> -->
								</tr>
								<logic:present name="IGDRM15011VO" property="trainplanInfoList">
									<logic:iterate id="bean" name="IGDRM15011VO"
										property="trainplanInfoList" indexId="index">
										<tr class="<ig:rowcss index="${index}"/>">
											<td> <html:checkbox property="deleteTpid" value="${bean.tpid}"/> </td>
											<td align="left">${bean.tpname}</td>
											<td align="left">${bean.tporgname}</td>
											<td align="left">${bean.tpusername}</td>
											<td align="left">${bean.tptime}</td>
											<td align="center">
											<html:link action="IGDRM1511_ToEdit.do?tpid=${bean.tpid}" title="编辑"><img src="images/edit.gif" align="middle" border="0" style="cursor: hand;"/></html:link>
											</td>
											<%-- <td align="center">
											
											<a href="javascript:void(0);" onclick="doDel(${bean.tpid})" title="删除"><img src="images/delete_16x16.gif" align="middle" border="0" style="cursor: hand;"/></a>
											</td> --%>
										</tr>
									</logic:iterate>
								</logic:present>
							</table>
						</div>
						<div id="operate">
						 	<logic:present name="IGDRM15011VO" property="trainplanInfoList" >
					      	<html:submit property="btn_delete" value="删除所选" styleClass="button" onclick="return deleteRec();" />
					      	</logic:present>
							<!-- paging -->
							<jsp:include page="/include/paging.jsp" />
						</div>
					</html:form>
				</div>
			</div>
			<div class="zishiying"></div>
		</div>
	</div>
	<script type="text/javascript">
	function doDel(id){
		var confirmMsg ='是否删除？';
		if( window.confirm(confirmMsg)){
			form.action = getAppRootUrl() + "/IGDRM1511_Delete.do?tpid="+id;
			form.submit();
		}
	}

	
	</script>
</body>
</html:html>