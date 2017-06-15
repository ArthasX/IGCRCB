<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGSYM1001" toScope="request"/>
<bean:define id="title" value="数据分类列表画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
    var gid='IGSYM1001';
	function deleteRec(ccid){
        var message ='<bean:message key="IGCO10000.E002"/>';
        var confirmMsg ='<bean:message key="IGCO10000.W002" arg0="数据分类信息" />';
        if( window.confirm(confirmMsg)){
            $("ccid").value = ccid;
            var form = window.document.forms[0];
            form.submit();
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
            <html:form styleId="form" action="/IGSYM1001_Delete" onsubmit="return checkSubmit(this);">
             <div id="location">
                <div class="image"></div>
                    <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
            </div>
         <div id="results_list">
					<!--  message -->
					<ig:message/>
					<!--  /message -->     
			       <table  class="table_style" >
			            <!-- header部 -->
			
			                <tr>
					           <th width="10%"></th>
					           <th width="30%">编号</th>
					           <th width="30%">名称</th>
					           <th width="30%">详细信息</th>
			                </tr>
			      
			            <!-- body部 -->
			          
			                <logic:present name="IGSYM10011VO" property="entityDataList" >
			                    <logic:iterate id="bean" name="IGSYM10011VO" property="entityDataList" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                            <td>
			                                ${index+1}
			                            </td>
			                            <!-- 编号 -->
			                            <td>
			                                <div class="nowrapDiv">
			                               		${bean.ccid}                          
			                                </div>
			                            </td>
			                            <!-- 名称 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="ccname">&nbsp;</logic:empty>
			                                ${bean.ccname}
			                                </div>
			                            </td>
			                            <!-- 详细信息 -->
                                        <td>
                                            <div align="center">
                                                <html:link action="/IGSYM1006_Disp.do?ccid=${bean.ccid}"><img src="images/look.gif" alt="查看详细信息" width="16" height="16"  border="0"/></html:link>
                                            </div>
                                        </td>
			                        </tr>
			                    </logic:iterate>
			                </logic:present>
 			       </table>
			     </div>
                 <html:hidden property="ccid" styleId="ccid"/>
                 <div id="operate">
					<jsp:include page="/include/paging.jsp" />
				 </div>
			</html:form>
        </div>
    </div>
</div>


</div>
</body>
</html:html>