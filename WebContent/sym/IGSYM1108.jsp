<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>

<html:html>
<bean:define id="id" value="IGSYM1108" toScope="request" />
<bean:define id="title" value="预定义树查询画面" toScope="request" />
<%
	String path = request.getParameter("path");

%>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
		var gid='IGSYM1108';

        function setParentValue(ccid, ccname){
            if(!window.opener.closed){
                window.opener.setCcidParams(ccid, ccname);
            }
            window.close();
        }
        function clearParentValue(){
            if(!window.opener.closed){
                window.opener.setCcidParams("", "");
            }
            window.close();
        }
      
       
	</script>
<body style="background-color: white; background-image: none;" >
<div id="maincontent">
<div id="contentainer">
<html:form styleId="form" action="/IGSYM1108_Disp"
	onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1">预定义树查询</p>
</div>
	<div id="results_list"><ig:message />
	<table class="table_style">
			  <!-- header部 -->
			
			                <tr>
					           <th width="10%"></th>
					           <th width="20%">编号</th>
					           <th width="30%">名称</th>
                               <th width="30%">说明</th>
                               <th width="10%">最大级数</th>
                               
			                </tr>
			      
			            <!-- body部 -->
			          
			                <logic:present name="IGSYM11011VO" property="codeCategoryInfoList" >
			                    <logic:iterate id="bean" name="IGSYM11011VO" property="codeCategoryInfoList" indexId="index">
			                        <tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="setParentValue('${bean.ccid}','${bean.ccname}');">
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
                                        <!-- 说明 -->
                                        <td>
                                            <div class="nowrapDiv">
                                            <logic:empty name="bean" property="ccinfo">&nbsp;</logic:empty>
                                            ${bean.ccinfo}
                                            </div>
                                        </td>
                                        <!-- 最大级数 -->
                                        <td>
                                            <div class="nowrapDiv">
                                            <logic:empty name="bean" property="pcflag">&nbsp;</logic:empty>
                                            ${bean.pcflag}
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
	<div class="enter">
	<input id="parent" type="button" name="btn_clear" value="清空" onclick="clearParentValue()" class="button">
	<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>
	<html:hidden property="ccid" styleId="ccid"/>
</html:form></div>
</div>
</body>
</html:html>