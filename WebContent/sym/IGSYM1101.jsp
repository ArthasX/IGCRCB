<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGSYM1101" toScope="request"/>
<bean:define id="title" value="数据分类列表画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
    var gid='IGSYM1101';
	
    function add(){
        document.forms[0].action = getAppRootUrl() + "/IGSYM1107_Disp.do";
        document.forms[0].submit();
    }

    function deleteCode(id){

    	if( window.confirm("您确认删除该条记录吗？")){
    		document.forms[0].ccid.value = id;
        	document.forms[0].action = getAppRootUrl() + "/IGSYM1101_Del.do";
            document.forms[0].submit();
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

            <html:form styleId="form" action="/IGSYM1101_Disp" onsubmit="return checkSubmit(this);">
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
					           <th width="5%"></th>
					           <th width="15%">编号</th>
					           <th width="20%">名称</th>
                               <th width="20%">说明</th>
                               <th width="10%">最大级数</th>
                               <th width="15%">编辑标识</th>
                               <th width="15%">删除</th>
			                </tr>
			      
			            <!-- body部 -->
			          
			                <logic:present name="IGSYM11011VO" property="codeCategoryInfoList" >
			                    <logic:iterate id="bean" name="IGSYM11011VO" property="codeCategoryInfoList" indexId="index">
			                        <tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="doLook('IGSYM1106_Disp.do?ccid=${bean.ccid}&clevel=1');">
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
                                        <!-- 编辑标识 -->
                                        <td>
                                            <div class="nowrapDiv">
                                           	可编辑
                                            </div>
                                        </td>
                                        <!-- 删除 -->
                                        <td>
                                            <div class="nowrapDiv">
                                            	<logic:equal name="bean" property="cceditable" value="3">
                                           		<html:link href="javascript:deleteCode('${bean.ccid}');">
                                                    <img src="images/delete.gif" alt="删除" width="16" height="16"  border="0"/>
                                                </html:link>
                                                </logic:equal>
                                            </div>
                                        </td>
			                        </tr>
			                    </logic:iterate>
			                </logic:present>
 			       </table>
			     </div>
                 <html:hidden property="ccid" styleId="ccid"/>
                 
                 <div id="operate">
			        <div class="content">
			            <div class="enter">

<!--	                        <html:button property="btn_add" value="增加" styleClass="button" onclick="add();" />-->
	                      
			            </div>
			        </div> 
    		    </div>
                 
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