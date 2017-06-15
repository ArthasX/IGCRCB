<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGASM0408" toScope="request"/>
<bean:define id="title" value="合同查询画面" toScope="request"/>

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
	
	//画面再表示

	function deleteRec(){
        var message ='<bean:message key="IGCO10000.E002"/>';
        var confirmMsg ='<bean:message key="IGCO10000.W002" arg0="合同基本信息" />';
        var frm = window.document.forms[0];
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

        if( window.confirm(confirmMsg)){
            form.action = getAppRootUrl() + "/IGASM0401_Del.do";
            return true;
        } else {
            return false;
        }
	}
	function checkForm(){

		//if($F('eiorgname').trim()==""){
			//alert("请选择所属机构！");
			//return false;
		//} else {
		//	return true;
		//}
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
            <html:form styleId="form" action="/IGASM0408"
             onsubmit="return checkSubmit(this);">

            <div id="location">
                <div class="image"></div>
                    <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
            </div>
             <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
                          <div>
                          <!-- 
                          <label><span class="red">*</span>所属机构：</label><html:text property="eiorgname" readonly="true"></html:text>
								<img src="images/tree.gif" style="cursor: hand;" alt="选择管理范围" width="16" height="16" border="0" onclick="setRoleDomain();"/>
								<html:hidden property="eiorgsyscoding"/>&nbsp;&nbsp;
			                <label>所属模型：</label><html:text property="ename" styleId="ename"  errorStyleClass="inputError imeDisabled" size="15" readonly="true"/>
			                 <img src="images/tree.gif" style="cursor: hand;" alt="资产模型" width="16" height="16" border="0" onclick="setEntity('IGSYM1201_ENTITY_TREE.do?levelnode=999011');"/>
			                <html:hidden property="esyscoding"/>&nbsp;&nbsp;
			                 -->
			                <label>合同编号：</label><html:text property="eilabel" styleId="eilabel" errorStyleClass="inputError imeDisabled" size="10" />&nbsp;&nbsp; 
	                        <label>服务商名称：</label><html:text property="facilitator" styleId="facilitator" errorStyleClass="inputError imeDisabled" size="10" />&nbsp;&nbsp; 
	                        <label>合同类别：</label>
	                        <html:select property="compacttype" styleId="compacttype" style="width: 110px;" errorStyleClass="inputError">
	                        <html:options collection="ADselectList" property="value" labelProperty="label"/>
	                        </html:select>
	                        <label>经手人：</label><html:text property="operator" styleId="operator" errorStyleClass="inputError imeDisabled" size="10" />&nbsp;&nbsp; 
	                        <br>
	                        <label>签订日期：从</label><html:text property="condudetime_from" styleId="condudetime_from" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
	                        <img src="images/date.gif" align="middle" onClick="calendar($('condudetime_from'))" border="0"/>
	                        &nbsp;&nbsp;
	                        <label>到</label><html:text property="condudetime_to" styleId="condudetime_to" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
                            <img src="images/date.gif" align="middle" onClick="calendar($('condudetime_to'))" border="0"/>
		        			<html:submit property="btn_search" value="查询" styleClass="button"/>
                          </div>
		     </div>
		     
          </div>
                <div id="results_list">
					<!--  message -->
					<ig:message/>
					<!--  /message -->     
			       <table class="table_style">
			            <!-- header部 -->

			                <tr>
					           <th width="15%" >合同编号</th>
					           <th width="15%">合同名称</th>
					           <th width="9%">合同类别</th>
					           <th>服务商</th>
					           <th width="7%">经手人</th>
					           <th width="9%">签订时间</th>
					           <th width="7%">合同款</th>
					           <th width="7%">已付款</th>
					           <th width="7%">详细信息</th>
					           <th width="7%">历史版本</th>
			                </tr>
			  
			            <!-- body部 -->
			            
			                <logic:present name="IGASM04011VO" property="entityItemCompactVWInfoList" >
			                    <logic:iterate id="bean" name="IGASM04011VO" property="entityItemCompactVWInfoList" indexId="index">
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
			                            <!-- 合同类别 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="compacttype">&nbsp;</logic:empty>
			                                ${bean.compacttype}
			                                </div>
			                            </td>
			                            <!-- 状态 
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="eistatus">&nbsp;</logic:empty>
			                                <ig:codeValue ccid="ENTITY_ITEM_STATUS_CODE" cid="${bean.eistatus}"/>                                 
			                                </div>
			                            </td>
			                            -->
			                            <!-- 服务商 -->
			                            <td>
                                            <div class="nowrapDiv">
                                            <logic:empty name="bean" property="facilitator">&nbsp;</logic:empty>
                                           	 ${fn:substringBefore(bean.facilitator,"(")}
                                            </div>
			                            </td>
			                           <!-- 经手人 -->
			                            <td>
                                            <div class="nowrapDiv">
                                            <logic:empty name="bean" property="operator">&nbsp;</logic:empty>
                                            ${bean.operator}
                                            </div>
			                            </td>
			                            <!-- 签订日 -->
			                            <td>
                                            <div class="nowrapDiv">
                                            <logic:empty name="bean" property="condudetime">&nbsp;</logic:empty>
                                            ${bean.condudetime}
                                            </div>
			                            </td>
			                            <!-- 合同款 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                 <logic:empty name="bean" property="contractpayment">&nbsp;</logic:empty>
                                            ${bean.contractpayment}
			                                </div>
			                            </td>
			                             <!-- 已付款 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                 <logic:empty name="bean" property="countmoney">&nbsp;</logic:empty>
                                            ${bean.countmoney}
			                                </div>
			                            </td>
			                            <!-- 详细信息 -->
			                            <td>
			                                <div align="center">
                                                <html:link action="/IGASM0409_Disp.do?eiid=${bean.eiid}"><img src="images/xx.gif" alt="显示详细信息" width="16" height="16"  border="0"/></html:link>
			                                </div>
			                            </td>
			                            <!-- 历史版本 -->
			                            <td>
			                                <div class="nowrapDiv">
                                                <html:link action="/IGASM0410_Disp.do?eiid=${bean.eiid}&civersion="><img src="images/notepad_16x16.gif" alt="历史版本" width="16" height="16"  border="0"/></html:link>
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
                <html:hidden property="ecategory" styleId="ecategory" value="${IGASM0401Form.ecategory}"/>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>