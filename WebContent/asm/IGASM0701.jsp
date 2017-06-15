<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM0701" toScope="request"/>
<bean:define id="title" value="机房查询画面" toScope="request"/>

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
	function redisplay1(){
		$("ekey1").value = "";
		$("ekey2").value = "";
		form.action = getAppRootUrl() + "/IGASM0701_ReDisp.do";
		form.submit();
	}
	function redisplay2(){
		$("ekey2").value = "";
		form.action = getAppRootUrl() + "/IGASM0701_ReDisp.do";
		form.submit();
	}
	function redisplay3(){
		form.action = getAppRootUrl() + "/IGASM0701_ReDisp.do";
		form.submit();
	}

	function deleteRec(){
        var message ='<bean:message key="IGCO10000.E002"/>';
        var confirmMsg ='<bean:message key="IGCO10000.W002" arg0="机房基本信息" />';
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
            form.action = getAppRootUrl() + "/IGASM0701_Del.do";
            return true;
        } else {
            return false;
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
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
            </div>
            <html:form styleId="form" action="/IGASM0701"
             onsubmit="return checkSubmit(this);">
                <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
                          <div>
			                <label>类型名：</label><html:text property="ename" styleId="ename"  errorStyleClass="inputError imeDisabled" size="15" /> &nbsp;&nbsp;
			                <label>名称：</label><html:text property="einame" styleId="einame" errorStyleClass="inputError imeDisabled" size="10" />&nbsp;&nbsp; 
	                        <label>登记日：从</label><html:text property="eiupdtime_from" styleId="eiupdtime_from" errorStyleClass="inputError imeDisabled" size="12" /> 
	                        <img src="images/date.gif" align="middle" onClick="calendar($('eiupdtime_from'))" border="0"/>
	                        &nbsp;&nbsp;
	                        <label>到</label><html:text property="eiupdtime_to" styleId="eiupdtime_to" errorStyleClass="inputError imeDisabled" size="12" /> 
                            <img src="images/date.gif" align="middle" onClick="calendar($('eiupdtime_to'))" border="0"/>
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
					           <th width="8%">
					             <label>
					             </label>
					          </th>
					           <th width="8%">机房编号</th>
					           <th width="14%">名称</th>
					           <th width="20%">说明</th>
					           <!--<th width="10%">状态</th>
					           --><th width="10%">类别</th>
					           <th width="10%">登记日</th>
					           <th width="10%">详细信息</th>
					           <th width="10%">关系信息</th>
					           <th width="8%">历史版本</th>
			                </tr>
			          
			            <!-- body部 -->
			      
			                <logic:present name="IGASM07011VO" property="entityDataList" >
			                    <logic:iterate id="bean" name="IGASM07011VO" property="entityDataList" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                            <td>
			                                <html:checkbox property="deleteEiid" value="${bean.eiid}"/>
			                            </td>
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
			                            <!-- 状态 
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="eistatus">&nbsp;</logic:empty>
			                                <ig:codeValue ccid="ENTITY_ITEM_STATUS_CODE" cid="${bean.eistatus}"/>                                 
			                                </div>
			                            </td>
			                            --><!-- 类别 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="ecategory">&nbsp;</logic:empty>
			                                <ig:codeValue ccid="ENTITY_CATEGORY_CODE" cid="${bean.ecategory}"/>                                 
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
                                                <html:link action="/IGASM0704_Disp.do?eiid=${bean.eiid}"><img src="images/xx.gif" alt="显示详细信息" width="16" height="16"  border="0"/></html:link>
			                                </div>
			                            </td>
			                            <!-- 关系信息 -->
			                            <td>
			                                <div class="nowrapDiv">
                                                <html:link action="/IGASM0706_Disp.do?eiid=${bean.eiid}"><img src="images/record_(copy)_16x16.gif" alt="关系信息" width="16" height="16"  border="0"/></html:link>
			                                </div>
			                            </td>
			                            <!-- 历史版本 -->
			                            <td>
			                                <div class="nowrapDiv">
                                                <html:link action="/IGASM0705_Disp.do?eiid=${bean.eiid}&civersion="><img src="images/notepad_16x16.gif" alt="历史版本" width="16" height="16"  border="0"/></html:link>
			                                </div>
			                            </td>
			                        </tr>
			                    </logic:iterate>
			                </logic:present>
			         
			       </table>
			     </div>
			     <div id="operate">
                            <logic:present name="IGASM07011VO" property="entityDataList" >
                            <html:submit property="btn_delete" value="删除所选" styleClass="button" onclick="return deleteRec();" />
                            </logic:present>
			                <!-- paging -->
			                <jsp:include page="/include/paging.jsp"/>
			                <!-- /paging --> 
			    </div>
                <html:hidden property="ecategory" styleId="ecategory" value="${IGASM0701Form.ecategory}"/>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>