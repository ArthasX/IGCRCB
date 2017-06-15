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
<bean:define id="id" value="IGASM2202" toScope="request" />
<bean:define id="title"  toScope="request" >
对比结果查询画面
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	

	 function setEntity(url){

			var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
			if("_resetall"==temp){
				document.forms[0].ename.value = "";
				document.forms[0].esyscoding.value = "";
				return false;
			}
			if(null!=temp && temp.split("|").length>1){
				var syscode_eid = temp.split("|")[0];
				var name = temp.split("|")[1];
				var syscode;
				var eid;
				if(syscode_eid =="999")
				{
					eid = "";
					syscode = syscode_eid;
					
				}else if(syscode_eid.split("_").length>1){
					eid = syscode_eid.split("_")[0];
					syscode = syscode_eid.split("_")[1];
				}
				document.forms[0].ename.value = name;
				document.forms[0].esyscoding.value = syscode;
			}		
			
		}

	 function checkForm(){
	       
	     var confirmMsg = '是否确认提交？';
		 var frm = window.document.forms[0];
	        if(frm.checkbox.length > 0){
	            var bchecked = false;
	            for( i = 0; i<frm.checkbox.length; i++ ){
	                if (frm.checkbox[i].checked == true){
		                if (frm.checkbox[i].checked == true){
		                	if(document.getElementsByName("ciresultdesces")[i-1].value.strlen()>256){
		                		alert("审计结果说明不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
		                		return false;
		                	}
		                }
	                }
	            }
	        }

	        if( window.confirm(confirmMsg)){
	            form.action = getAppRootUrl() + "/IGASM2202_Save.do";
	            return true;
	        } else {
	            return false;
	        }
	 }

	 function checkFormForUpdate(){
		 var confirmMsg = '请确认是否执行更新操作？';

	        if( window.confirm(confirmMsg)){
	            form.action = getAppRootUrl() + "/IGASM2202_Update.do";
	            return true;
	        } else {
	            return false;
	        }
	 }
	 
	 function exportExcel() {
	 	document.forms[0].action = getAppRootUrl() + "/IGASM2202_Export.do";
	 	document.forms[0].submit();
	 }
	 
	 function search() {
	 	document.forms[0].action = getAppRootUrl() + "/IGASM2202.do";
	 	document.forms[0].submit();
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
          <html:form styleId="form" action="/IGASM2202" onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1">资产管理 &gt;&gt; CI更新管理 &gt;&gt; 对比结果查询</p>
            </div>
            <div id="search">
                   <div class="img"></div>
                   <div class="conditions">
                   <div>
            		<span>CI更新任务：</span><html:text property="citdesc" styleId="citdesc" errorStyleClass="inputError imeDisabled" size="10"/>&nbsp;&nbsp;
					
                    <label>CI更新时间: 从</label><html:text property="citime_from" styleId="citime_from" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
                    <img src="images/date.gif" align="middle" onClick="calendar($('citime_from'))" border="0"/>
                    &nbsp;&nbsp;
                    <label>到</label><html:text property="citime_to" styleId="citime_to" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
                    <img src="images/date.gif" align="middle" onClick="calendar($('citime_to'))" border="0"/>
					&nbsp;&nbsp;
					<label>资产模型</label><html:text property="ename" styleId="ename"  errorStyleClass="inputError imeDisabled" size="15" readonly="true"/>
					<img src='images/tree.gif' style="cursor: hand;" alt='资产模型' width="16" height="16" border="0" onclick="setEntity('IGSYM1203_ENTITY_TREE.do?type=0&levelnode=999');"/>
					<html:hidden property="esyscoding"/>&nbsp;&nbsp;	
					<html:button property="btn_search" styleClass="button" onclick="search();"  >
					查询
					</html:button>
					
					<html:button property="btn_search" styleClass="button" onclick="exportExcel();"  >
						导出
					</html:button>
                   </div>
                   </div>
                </div>
                
                <div id="results_list">
					<!--  message -->
					<ig:message />
					<!--  /message -->
                    <table class="table_style">
						<!-- header部 -->
						
							<tr>
								<th width="5%">
								<label><input type="checkbox" name="checkbox" id="checkbox"  onclick="selectAll('checkbox','checkbox')"/></label>
								</th>
								<th width="15%">资产名称</th>
								<th width="12%">CI更新时间</th>
								<th width="8%">对比结果</th>
								<th width="10%">属性名称</th>
								<th width="10%">当前版本值</th>
								<th width="10%">采集值</th>
								<th width="10%">合理标识</th>
								<th width="20%">CI更新结果说明</th>
							</tr>
						
						<!-- body部 -->
						
                            <logic:present name="IGASM22021VO" property="ciResultList">
								<logic:iterate id="bean" name="IGASM22021VO" property="ciResultList" indexId="index">
									<tr class="<ig:rowcss index="${index}"/>">

										<td>
										<label>
										<c:if test="${bean.ciflag == '1'}">
											<input name="checkbox" type="checkbox" value="${bean.cirid}" checked="checked"/>
										</c:if>
										<c:if test="${bean.ciflag == '0'}">
											<html:checkbox property="checkbox" value="${bean.cirid}" />
										</c:if>
										</label> 
										</td>

										<!-- 资产名称 -->
										<td>
											<div class="nowrapDiv">${bean.einame}</div>
											<html:hidden property="cirids" value="${bean.cirid}"/>
										</td>
										
										<!-- 审计时间 -->
										<td>
											<div class="nowrapDiv">${bean.citime}</div>
										</td>

										<!-- 对比结果类型 -->
										<td>
											<div class="nowrapDiv"><ig:codeValue ccid="CIRESULT_CICMPTYPE" cid="${bean.cicmptype}" /></div>
										</td>
										
										<!-- 属性名称 -->
										<td>
											<div class="nowrapDiv">${bean.cname}</div>
										</td>
										
										<!-- 当前版本值 -->
										<td>
											<div class="nowrapDiv">${bean.civalue}</div>
										</td>
										
										<!-- 采集值 -->
										<td>
											<div class="nowrapDiv">${bean.auvalue}</div>
										</td>
										
										<!-- 合理标识 -->
										<td>
											<div class="nowrapDiv"><ig:codeValue ccid="CIRESULT_CIFLAG" cid="${bean.ciflag}" /></div>
										</td>
										
										<!-- 审计结果说明 -->
										<td>
											<div class="nowrapDiv"><html:text property="ciresultdesces" name="ciresultdesces" value="${bean.ciresultdesc}"/></div>
										</td>
									</tr>
									
									
								</logic:iterate>
							</logic:present>
					</table>
				</div>
	         <logic:present name="IGASM22021VO" property="ciResultList">
	         <bean:size id="num" name="IGASM22021VO" property="ciResultList" />
	         	<c:if test="${num > 0}">
					<div class="enter">
						<html:submit property="btn_search" styleClass="button" onclick="return checkForm();" >
						不合理
						</html:submit>
						<html:submit property="btn_search" styleClass="button" onclick="return checkFormForUpdate();" >
						更新
						</html:submit>
					</div>
	         	</c:if>
	         </logic:present>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>