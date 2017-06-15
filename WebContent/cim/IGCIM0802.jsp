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
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html:html>
<bean:define id="id" value="IGCIM0802" toScope="request" />
<bean:define id="title" value="采集结果查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->
<script type="text/javascript">	
	//画面再表示
	 function setEntity(){
		 var alertMessage = 'CI模型不可用！请选择其他模型!';
	    	<logic:notPresent name="ADrolemanager">
			//var url = "IGSYM0304_ASSET.do?roletype=IGCI01&subtype=999001";
			var url = "IGSYM1203_ENTITY_TREE.do?levelnode=999&socflag=yes&flag=1";
			</logic:notPresent>
			
			<logic:present name="ADrolemanager">
			<logic:equal name="ADrolemanager" value="true">
			var url = "IGSYM1203_ENTITY_TREE.do?levelnode=999001";
			</logic:equal>
			</logic:present>

			var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
			if("_resetall"==temp){
				 document.forms[0].ename.value = "";
//				 document.forms[0].eid.value = "";
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
					alert(alertMessage);
					return false;
					
				}else if(syscode_eid.split("_").length>1){
					eid = syscode_eid.split("_")[0];
					syscode = syscode_eid.split("_")[1];
				}
				document.forms[0].ename.value = name;
			//	document.forms[0].eid.value = eid;
				document.forms[0].esyscoding.value = syscode;
			}		
		}
</script>
<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
    
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
          <html:form styleId="form" action="/IGCIM0802" onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
            </div>
            <div id="search">
                   <div class="img"></div>
                   <div class="conditions">
                   <div>
            		<span>CI名：</span><html:text property="impeiname_like" styleId="impeiname_like" errorStyleClass="inputError imeDisabled" size="10"/>&nbsp;&nbsp;
            		&nbsp;&nbsp;<span>IP：</span><html:text property="impip" styleId="impip" errorStyleClass="inputError imeDisabled" size="10"/>&nbsp;&nbsp;
			        &nbsp;&nbsp;<span>CI类型：</span><html:text property="ename" styleId="ename"  errorStyleClass="inputError imeDisabled" size="15" readonly="true"/>
			        <img src="images/tree.gif" style="cursor: hand;" alt='选择模型类型' width="16" height="16" border="0" onclick="setEntity();"/>&nbsp;&nbsp;
			        <html:hidden property="esyscoding"/>
			        <br>
	                <span>采集起始时间：</span>从<html:text property="impcreatetime_s" readonly="true"/>&nbsp;&nbsp;
	                <img src="images/date.gif" align="middle" style="cursor:pointer;" onClick="showDate($('impcreatetime_s'))" border="0" />&nbsp;&nbsp;
	                                           到<html:text property="impcreatetime_e" readonly="true"/>&nbsp;&nbsp;
	                <img src="images/date.gif" align="middle" style="cursor:pointer;" onClick="showDate($('impcreatetime_e'))" border="0" />&nbsp;&nbsp;
                    &nbsp;&nbsp;<html:submit property="btn_search" styleClass="button" value="查询" />
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
								<th width="5%">序号</th>
								<th width="17%" >CI名</th>
								<th width="17%" >IP地址</th>
								<th width="17%">CI类型</th>
								<th width="17%">脚本名</th>
								<th width="17%">采集时间</th>
								<th width="10%">原始数据</th>
							</tr>
						
						<!-- body部 -->
							  <logic:present name="IGCIM08021VO" property="cr03VWInfoList">
								<logic:iterate id="bean" name="IGCIM08021VO"
									property="cr03VWInfoList" indexId="index" >
									<tr class="<ig:rowcss index="${index}"/>">
										<!-- 序号 -->
										<td>
											<div class="nowrapDiv">${PagingDTO.viewStartCount+index}
											</div>
										</td>

										<!--CI名 -->
										<td>
										<div class="nowrapDiv">
										  ${bean.host}</div>
										</td>
										
										<!-- IP -->
										<td>
											<div class="nowrapDiv">
												${bean.ip}
											</div>
										</td>
										<!-- 模型名 -->
										<td>
										<div class="nowrapDiv">${bean.imptypename}</div>
										</td>
										<!-- 脚本名 -->
										<td>
											<div class="nowrapDiv">
												${bean.servername }
											</div>
										</td>
										<!-- 最新采集时间yyyy-MM-dd HH:mm:ss-->
										<td>
											<div class="nowrapDiv">
											${bean.maxctime }
											<!--${fn:substring(bean.maxctime,0,4)}/${fn:substring(bean.maxctime,4,6)}/${fn:substring(bean.maxctime,6,8)} ${fn:substring(bean.maxctime,8,10)}:${fn:substring(bean.maxctime,10,12)}:${fn:substring(bean.maxctime,12,14)}-->
											</div>
										</td>
										<!-- 数据详细链接 -->
			                            <td>
			                            <div align="center">
		                            	  	  <html:link action="/IGCIM0110_Disp.do?firstAccess=true&host=${bean.host}&ip=${bean.ip}&type=${bean.type}&servername=${bean.servername}"> 
			                            	  	 <img src="images/cr.gif" alt="数据详细" width="16" height="16"  border="0"/>
			                            	  </html:link>
			                            </div>
			                            </td>
									</tr>
								</logic:iterate>
							</logic:present>
						</table>
				</div>
				<div id="operate">
	             <jsp:include page="/include/paging.jsp" />
                </div>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>