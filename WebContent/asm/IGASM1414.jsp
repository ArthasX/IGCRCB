<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM1414" toScope="request"/>
<bean:define id="title" value="资产服务记录查询" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	

	    WebCalendar.yearFall   = 50;           //定义年下拉框的年差值
	    WebCalendar.format     = "yyyy/mm/dd"  //回传日期的格式
	    WebCalendar.timeShow   = false          //是否返回时间
	    WebCalendar.drag       = true          //是否允许拖动
	    WebCalendar.darkColor  = "#014DB4";    //控件的暗色
	    WebCalendar.lightColor = "#FFFFFF";    //控件的亮色
	    WebCalendar.btnBgColor = "#FFFFF5";    //控件的按钮背景色
	    WebCalendar.wordColor  = "#000080";    //控件的文字颜色
	    WebCalendar.wordDark   = "#DCDCDC";    //控件的暗文字颜色
	    WebCalendar.dayBgColor = "#E6E6FA";    //日期数字背景色
	    WebCalendar.todayColor = "#FF0000";    //今天在日历上的标示背景色
	    WebCalendar.DarkBorder = "#D4D0C8";    //日期显示的立体表达色

	


	function checkForm(){
		if($F('ename').trim()==""){
			alert("请选择所属模型！");
			return false;
		} else {
			return true;
		}
	}

	 function setEntity(url){
		 
     	url+="999";
       
     	
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
				alert("资产类型不可用！请选择其他类型！");
				return false;
			}else if(syscode_eid.split("_").length>1){
				eid = syscode_eid.split("_")[0];
				syscode = syscode_eid.split("_")[1];
			}
			document.forms[0].ename.value = name;
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
<html:form styleId="form" action="/IGASM1414"
             onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
            </div>    
                <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
                          <div class="conditions_border1">
                          <div>
                          	
			                <label><span class="red">*</span>所属模型：</label><html:text property="ename" styleId="ename"  errorStyleClass="inputError imeDisabled" size="15" readonly="true"/>
			                <img src="images/tree.gif" style="cursor: hand;" alt="选择资产管理内容" width="16" height="16" border="0" onclick="setEntity('IGSYM1201_ENTITY_TREE.do?type=0&levelnode=');"/>
			                <html:hidden property="esyscoding"/>
			                <label>&nbsp;&nbsp;资产名称：</label><html:text property="einame" styleId="einame" errorStyleClass="inputError imeDisabled" size="10" />&nbsp;&nbsp; 
	                       
	                        <label>资产登记日：从</label><html:text property="eiupdtime_from" styleId="eiupdtime_from" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
	                        <img src="images/date.gif" align="middle" onClick="calendar($('eiupdtime_from'))" border="0"/>
	                        &nbsp;&nbsp;
	                        <label>到</label><html:text property="eiupdtime_to" styleId="eiupdtime_to" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
                            <img src="images/date.gif" align="middle" onClick="calendar($('eiupdtime_to'))" border="0"/>
                        <html:submit property="btn_search" value="查询" styleClass="button" onclick="return checkForm();"/>
                          </div>
                    </div>
		      </div>
		     
          </div>
                               
                <div id="results_list">
					<!--  message -->
					<ig:message/>
					<!--  /message -->     
			       <table width="100%" class="table_style">
			            <!-- header部 -->
			                 <tr>
					           
					           <th width="12%">服务记录编号</th>
					           <th width="20%">服务记录名称</th>
					           <th width="20%" >服务记录说明</th>
					           <th width="7%">管理人</th>
					           <th width="14%">服务记录登记日</th>
					           <th width="7%">详细信息</th>
			                </tr>
			            <!-- body部 -->			  
			                <logic:present name="IGASM14141VO" property="entityDataList" >
			                    <logic:iterate id="bean" name="IGASM14141VO" property="entityDataList" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                            
			                            <!-- 编号 -->
			                            <td>
			                                <div class="nowrapDiv">
                                                ${bean.eilabel}
			                                </div>
			                            </td>
			                            <!-- 名称 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="einame">&nbsp;</logic:empty>
			                                ${bean.einame}
			                                </div>
			                            </td>
			                            <!-- 说明 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="eidesc">&nbsp;</logic:empty>
			                                ${bean.eidesc}
			                                </div>
			                            </td>
			                            <!-- 管理人-->
			                            <td>
                                            <div class="nowrapDiv">
                                            <logic:empty name="bean" property="eiusername">&nbsp;</logic:empty>
                                            ${bean.eiusername}
                                            </div>
			                            </td>
			                            <!-- 登记日 -->
			                            <td>
                                            <div class="nowrapDiv">
                                            <logic:empty name="bean" property="eiinsdate">&nbsp;</logic:empty>
                                            ${bean.eiinsdate}
                                            </div>
			                            </td>
			                            <!-- 详细信息 -->
			                            <td>
			                                <div align="center">
                                                 <html:link action="/IGASM1409_Disp.do?eiid=${bean.eiid}&route=asm1414"><img src="images/xx.gif" alt="显示详细信息" width="16" height="16"  border="0"/></html:link>
			                                </div>
			                            </td>
			                           
			                        </tr>
			                    </logic:iterate>
			                </logic:present>
			       </table>
			     </div>
			      <div id="operate">
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