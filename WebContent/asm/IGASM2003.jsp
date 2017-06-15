<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGASM2003" toScope="request" />
<bean:define id="title" toScope="request" value="Domain管理界面"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
	function deleteRec(){
   		 var message ="请选择删除对象！";
    	 var arg0  = "Domain基本信息";
   		 var alertMsg = "没有可删除的数据。";
   		 var confirmMsg ="请确认是否要进行"+arg0+"删除处理?";
   		 var frm = window.document.forms[0];
    		if(frm.deleteEiddid) {
       			 if(frm.deleteEiddid.length > 0){
            		var bchecked = false;
           		 for(var i=0; i<frm.deleteEiddid.length; i++ ){
               		 if (frm.deleteEiddid[i].checked == true){
                   		 bchecked = true;
               	 }
            }
           		 if (!bchecked) {
            		alert(message);
                	return false;
            }
        } else {
          if ($("deleteEiddid").checked == false){
              alert(message);
              return false;
          }  
        }
    } else {
    	alert(alertMsg);
        return false;
    }
    
    if( window.confirm(confirmMsg)){
        form.action = getAppRootUrl() + "/IGASM2003_Del.do";
        return true;
    } else {
        return false;
    }
}

	function checkForm(){
		var alertTime="开始时间不能晚于结束时间！";
		if(!checkDateWithTimeShow("createtime_from","createtime_to")){
			alert(alertTime);
			return false;
		}
	}
	function check(){
		var confirmMsg1="是否进行Domain解析？";
		if(window.confirm(confirmMsg1)){
			return true;
		}else{
			return false;
		}
	}
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGASM2003"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">
	资产管理 &gt;&gt; 
	Domain管理 &gt;&gt; 
	Domain管理
	</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div class="conditions_border1">
	<div>
	<label>&nbsp;&nbsp;Domain名称： </label> 
	<html:text property="name_like" styleId="name_like"
		errorStyleClass="inputError imeDisabled" size="21" maxlength="21" />
	&nbsp;&nbsp; <label> 
	创建时间：从 </label> 
	<html:text property="createtime_from" styleId="createtime_from"
		errorStyleClass="inputError imeDisabled" size="12" readonly="true"name="IGASM2003Form" /> 
	<img src="images/date.gif" align="middle" onClick="calendar($('createtime_from'))" border="0" /> 
	&nbsp;&nbsp; <label>
	到
	</label> 
	<html:text property="createtime_to" styleId="createtime_to"
		errorStyleClass="inputError imeDisabled" size="12" readonly="true" name="IGASM2003Form" />
	<img src="images/date.gif" align="middle" onClick="calendar($('createtime_to'))" border="0" /> 
	<html:submit property="btn_search" styleClass="button" onclick="return checkForm();" value="查询"/>
	</div>
	</div>
	</div>

	</div>

	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table width="100%" class="table_style">
		<!-- header部 -->
		<tr>
			<th width="4%"><label> </label></th>
			<th width="10%">Domain名称</th>
			<th width="6%">版本号</th>
			<th width="10%">创建时间</th>
			<th width="10%">更新时间</th>
			<th width="8%">Domain明细</th>
			<th width="8%">修改</th>
			<th width="8%">历史版本</th>
			<th width="8%">拓扑图</th>
			<th width="8%">Domain解析</th>
		</tr>
		<!-- body部 -->
		<logic:present name="IGASM20031VO" property="eiDomainDefInfoList">
			<logic:iterate id="bean" name="IGASM20031VO"
				property="eiDomainDefInfoList" indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					<td><html:checkbox property="deleteEiddid"
						value="${bean.eiddid}_${bean.version}" /></td>
					<!-- 名称 -->
					<td>
					<div class="nowrapDiv"><html:link
						action="/IGASM2005_Disp.do?eiddid=${bean.eiddid}&&version=${bean.version}">${bean.name}</html:link>
					</div>
					</td>
					<!-- 版本号-->
					<td>
					<div class="nowrapDiv"> ${bean.version}</div>
					</td>
					<!-- 登记时间-->
					<td>
					<div class="nowrapDiv"> ${bean.createtime}</div>
					</td>
					<!-- 登记时间-->
					<td>
					<div class="nowrapDiv">${bean.updatetime}</div>
					</td>

					<!-- 资产预明细 -->
					<td>
					<div class="nowrapDiv"><html:link
						action="/IGASM2004_Disp.do?eiddid=${bean.eiddid}&eiddversion=${bean.version}">
						<img src="images/record_(copy)_16x16.gif"
							alt="显示资产域明细"
							width="16" height="16" border="0" />
					</html:link></div>
					</td>
					<!-- 修改 -->
					<td>
					<div align="center"><html:link
						action="/IGASM2002_Edit_Disp.do?eiddid=${bean.eiddid}&&version=${bean.version}">
						<img src="images/edit.gif" width="16" height="16" border="0" />
					</html:link></div>
					</td>
					<!-- 历史版本 -->
			        <td>
			        <div class="nowrapDiv">
                          <html:link action="/IGASM2012_Disp.do?eiddid=${bean.eiddid}&&version=${bean.version}"><img src="images/notepad_16x16.gif" alt="显示历史版本"  width="16" height="16"  border="0"/></html:link>
			        </div>
			        </td>
					<!-- 拓扑图 -->
			        <td>
			        <div class="nowrapDiv">
                          <a href="javascript:void(0)" onclick="openSubIGCOM0324('0','${bean.eiddid}','${bean.version}','${bean.updatetime}')"><img src="images/relationships.gif" alt="显示拓扑图" width="16" height="16"  border="0"/></a>
			        </div>
			        </td>
			        
			        <!-- 手动快照 -->
					<td>
					<div align="center"><html:link
						action="/IGASM2005_Snapshot.do?eiddid=${bean.eiddid}&&version=${bean.version}">
						<img src="images/edit.gif" width="16" height="16" border="0" onclick="return check();"/>
					</html:link></div>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate"><logic:present name="IGASM20031VO"
		property="eiDomainDefInfoList">
		<html:submit property="btn_delete" styleClass="button"
			onclick="return deleteRec();" value="删除" />
	</logic:present> <!-- paging --> <jsp:include page="/include/paging.jsp" /> <!-- /paging -->
	</div>
</html:form>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>