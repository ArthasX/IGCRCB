<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM1101" toScope="request"/>
<bean:define id="title" value="机房列表画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
    var gid='IGASM1101';
	function deleteRec(){
        var message ='<bean:message key="IGCO10000.E002"/>';
        var confirmMsg ='<bean:message key="IGCO10000.W002" arg0="机房信息" />';
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
            return true;
        } else {
            return false;
        }
	}
	function openJifangMap(url){
		//window.open ("<%=request.getContextPath()%>" + url, '3D机房效果图', 'height=690, width=1005, top=0,left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no');
		window.open ("<%=request.getContextPath()%>" + url, '3D机房效果图');
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
            <html:form styleId="form" action="/IGASM1101"
             onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1">资产管理 &gt;&gt; 机房管理 &gt;&gt;机房列表</p>
            </div>

                <div id="results_list">
					<!--  message -->
					<ig:message/>
					<!--  /message -->     
			       <table  class="table_style" >
			            <!-- header部 -->
			
			                <tr>
					           <th width="2%"><input type="checkbox" name="allbox" id="allbox" onclick="selectAll('allbox','deleteEiid')"/></th>
					           <th width="15%" >机房名称</th>
					           <th width="29%">机房说明</th>
                               <th width="12%">横向宽(地板)</th>
                               <th width="12%">纵向宽(地板)</th>
					           <th width="10%">负责人</th>
					           <th width="10%">联系电话</th>
					           <th width="10%">3D效果图</th>
			                </tr>
			      
			            <!-- body部 -->
			          
			                <logic:present name="IGASM11011VO" property="entityDataList" >
			                    <logic:iterate id="bean" name="IGASM11011VO" property="entityDataList" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                            <td>
			                                <html:checkbox property="deleteEiid" value="${bean.eiid}"/>
			                            </td>
			                            <!-- 名称 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="einame">&nbsp;</logic:empty>
			                                <html:link
                                            action="/IGASM1102_Edit_Disp.do?eiid=${bean.eiid}">${bean.einame}</html:link>			                                
			                                </div>
			                            </td>
			                            <!-- 机房说明 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="eidesc">&nbsp;</logic:empty>
			                                ${bean.eidesc}
			                                </div>
			                            </td>
                                        <!-- 机房横向宽 -->
                                        <td>
                                            <div class="nowrapDiv">
                                            <logic:empty name="bean" property="x_total">&nbsp;</logic:empty>
                                            ${bean.x_total}块
                                            </div>
                                        </td>
                                        <!-- 机房纵向宽 -->
                                        <td>
                                            <div class="nowrapDiv">
                                            <logic:empty name="bean" property="y_total">&nbsp;</logic:empty>
                                            ${bean.y_total}块
                                            </div>
                                        </td>
			                            <!-- 负责人 -->
			                            <td>
                                            <div class="nowrapDiv">
                                            <logic:empty name="bean" property="manager">&nbsp;</logic:empty>
                                            ${bean.manager}
                                            </div>
			                            </td>
                                        <!-- 联系电话 -->
                                        <td>
                                            <div class="nowrapDiv">
                                            <logic:empty name="bean" property="tel">&nbsp;</logic:empty>
                                            ${bean.tel}
                                            </div>
                                        </td>
			                            <!-- 详细信息 -->
			                            <td>
			                                <div align="center">
                                                <html:link href="javascript:openJifangMap('/IGASM1104_Flex.do?eiid=${bean.eiid}')"><img src="images/look.gif" alt="查看详细信息" width="16" height="16"  border="0"/></html:link>
			                                </div>
			                            </td>
			                        </tr>
			                    </logic:iterate>
			                </logic:present>
			            
			       </table>
			     </div>
			     <div id="operate">
                            <logic:present name="IGASM11011VO" property="entityDataList" >
                            <html:submit property="btn_delete" value="删除所选" styleClass="button" onclick="return deleteRec();" />
                            </logic:present>
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