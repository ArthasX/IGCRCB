<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM1111" toScope="request"/>
<bean:define id="title" value="机柜列表画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">
    var gid='IGASM1111';
    function deleteRec(){
        var message ='<bean:message key="IGCO10000.E002"/>';
        var confirmMsg ='<bean:message key="IGCO10000.W002" arg0="机柜信息" />';
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
    function openSubWindows(uri, wName, width, height){
    	if(width == "")
    		width = "800";
    	if(height == "")
    		height = "600";
    	var iTop = (window.screen.availHeight-30-width)/2;       //获得窗口的垂直位置;
    	var iLeft = (window.screen.availWidth-10-height)/2;           //获得窗口的水平位置;

    	window.open(getAppRootUrl() + uri, wName, 'width='+ width + ',height=' + height + ',scrollbars=yes,resizable=yes,status=yes,top='+iTop+',left='+iLeft+',').focus();
    }
    function fundDetail(eiid){
    	form.action = getAppRootUrl() + "/IGASM1111_Detail.do?computerContainerId="+eiid;
    	form.submit();
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
		    <html:form styleId="form" action="/IGASM1111" onsubmit="return checkSubmit(this);">

            <div id="location">
                <div class="image"></div>
                    <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
            </div>
		        <div id="results_list">
					<!--  message -->
					<ig:message/>
					<!--  /message -->     
		            <table class="table_style">
						<!-- header部 -->
						    <tr>
                                <th width="2%">
                                <input type="checkbox" name="allbox" id="allbox" onclick="selectAll('allbox','deleteEiid')"/>
                                </th>
		                        <th width="13%">名称
		                        </th>
		                        <th width="10%">类型
		                        </th>
		                        <th width="13%" >说明
		                        </th>
		                        <th width="5%">高度
		                        </th>
                                <th width="8%">横向宽(地板)
                                </th>
                                <th width="8%">纵向宽(地板)
                                </th>
		                        <th width="10%">所属容器
		                        </th>
		                        <th width="8%">位置（X）
		                        </th>
		                        <th width="8%">位置（Y）
		                        </th>
		                        <th width="8%">设备详细
		                        </th>
                                <th width="8%">效果图

			        </th>
		                    </tr>

		                <!-- body部 -->

				           <logic:present name="IGASM11111VO" property="entityDataList" >
				               <logic:iterate id="bean" name="IGASM11111VO" property="entityDataList" indexId="index">
				                   <tr class="<ig:rowcss index="${index}"/>">
				                       <!-- 机柜删除选择-->
                                        <td>
                                            <html:checkbox property="deleteEiid" value="${bean.eiid}"/>
                                        </td>
				                       <!-- 机柜名称 -->
				                       <td>
				                           <div class="nowrapDiv">
				                           <logic:empty name="bean" property="einame">&nbsp;</logic:empty>
                                            <html:link
                                            action="/IGASM1112_Edit_Disp.do?eiidStr=${bean.eiid}">${bean.einame}</html:link>                                            
				                           </div>
				                       </td>
				                       <!-- 机柜类型 -->
				                       <td>
				                           <div class="nowrapDiv">
				                           <logic:empty name="bean" property="containertype">机柜</logic:empty>
                                           <logic:notEmpty name="bean" property="containertype">
	                                           	<logic:equal name="bean" property="containertype" value="1">
	                                           		机架
	                                           	</logic:equal>
	                                           	<logic:equal name="bean" property="containertype" value="0">
	                                           		机柜
	                                           	</logic:equal>
                                           </logic:notEmpty>                                       
				                           </div>
				                       </td>
				                       <!-- 机柜说明 -->
				                       <td >
				                           <div class="nowrapDiv">
				                           <logic:empty name="bean" property="eidesc">&nbsp;</logic:empty>
				                           ${bean.eidesc}
				                           </div>
				                       </td>
				                       <!-- 机柜高 -->
				                       <td>
				                           <div class="nowrapDiv">
				                           <logic:empty name="bean" property="u_total">&nbsp;</logic:empty>
		                                   ${bean.u_total}
				                           </div>
				                       </td>
                                       <!-- 机柜横向宽 -->
                                       <td align="center">
                                           <div class="nowrapDiv">
                                           <logic:empty name="bean" property="x_width">&nbsp;</logic:empty>
                                           ${bean.x_width}块
                                           </div>
                                       </td>
                                       <!-- 机柜纵向宽 -->
                                       <td>
                                           <div class="nowrapDiv">
                                           <logic:empty name="bean" property="y_width">&nbsp;</logic:empty>
                                           ${bean.y_width}块
                                           </div>
                                       </td>
				                       <!-- 所属机房 -->
				                       <td>
				                           <div class="nowrapDiv">
				                           <logic:empty name="bean" property="room_einame">&nbsp;</logic:empty>
		                                   ${bean.room_einame}
				                           </div>
				                       </td>
				                       <!-- 位置（X） -->
				                       <td>
				                           <div class="nowrapDiv">
				                           <logic:empty name="bean" property="x_value">&nbsp;</logic:empty>
		                                   ${bean.x_value}
				                           </div>
				                       </td>
				                       <!-- 位置（Y） -->
				                       <td>
				                           <div class="nowrapDiv">
				                           <logic:empty name="bean" property="y_value">&nbsp;</logic:empty>
		                                   ${bean.y_value}
				                           </div>
				                       </td>
				                       <!-- 设备详细 -->
				                       <td>
				                       <img src="images/xx.gif" alt="查看设备详细信息" width="16" height="16"  border="0" onclick="fundDetail(${bean.eiid});" style="cursor: hand" border="0"/>
				                       </td>
                                        <!-- 详细信息 -->
                                        <td>
                                            <div align="center">
                                                <html:link href="javascript:openSubIGASM1109('${bean.eiid}','${bean.containertype}');"><img src="images/look.gif" alt="查看详细信息" width="16" height="16"  border="0"/></html:link>
                                            </div>
                                        </td>
				                   </tr>
				               </logic:iterate>
				           </logic:present> 
		            </table>
		        </div>
		        <div id="operate">
                            <logic:present name="IGASM11111VO" property="entityDataList" >
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