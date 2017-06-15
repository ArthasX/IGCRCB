<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM1120" toScope="request"/>
<bean:define id="title" value="设备查询" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">	
function openJifangMap(url){
	window.open ("<%=request.getContextPath()%>" + url, '3D机房效果图');
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
<html:form styleId="form" action="/IGASM1120"
             onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
            </div>         
                <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
                          <div>
                           <label>&nbsp;&nbsp;IP地址：</label><html:text property="ip" styleId="ip" errorStyleClass="inputError imeDisabled" size="10" ></html:text>
                           <label>&nbsp;&nbsp;设备名称：</label><html:text property="einame" styleId="einame" errorStyleClass="inputError imeDisabled" size="10" ></html:text>
                           <label>&nbsp;&nbsp;设备编号：</label><html:text property="eilabel" styleId="eilabel" errorStyleClass="inputError imeDisabled" size="10" ></html:text>
			               <label>&nbsp;&nbsp;所属机柜：</label><html:text property="computerContainer" styleId="computerContainer" errorStyleClass="inputError imeDisabled" size="10" ></html:text>&nbsp;&nbsp; 
	                       <label>&nbsp;&nbsp;业务系统：</label><html:text property="businesssys" styleId="businesssys" errorStyleClass="inputError imeDisabled" size="10" ></html:text>
                        <html:submit property="btn_search" value="查询" styleClass="button" />
                          </div>
		       </div>
		     
          </div>
                               
                <div id="results_list">
					 
			       <table width="100%" class="table_style">
			            <!-- header部 -->
			                <tr>					          					           
					           <th width="10%">设备类型</th>
					           <th width="15%">设备名称</th>
					           <th width="10%">设备编号</th>
					           <th width="10%">业务系统</th>
					           <th width="10%">型号</th>
					           <th width="15%">IP地址</th>
					           <th width="11%">所属机房</th>
					           <th width="11%">所属机柜</th>	
					           <th width="3%">机柜位置</th>					    					           
					           <th width="3%">机房定位</th>					    					           
			                </tr>
			            <!-- body部 -->			  
			                <logic:present name="IGASM11201VO" property="eilist" >
			                <bean:define id="eilist" name="IGASM11201VO" property="eilist"/>
			                    <logic:iterate id="bean" name="eilist">
			                        <tr>
			                            <!-- 设备类型 -->
			                            <td>
			                               	${bean.ename }		             
			                            </td>
			                              <!-- 设备名称 -->
			                            <td>
			                                ${bean.einame}
			                            </td> 
			                              <!-- 设备编号 -->
			                            <td>
			                            	<div class="nowrapDiv">
                                                <html:link action="/IGASM1123_Disp.do?eiid=${bean.eiid}"> ${bean.eilabel}</html:link>
			                                </div>
			                            </td> 
			                            <!-- 业务系统-->
			                            <td>
			                               ${bean.businesssys}
			                            </td>
			                            <!-- 型号 -->
			                            <td>
			                                ${bean.pattern }
			                            </td>
			                            <!-- IP地址-->
			                            <td>
                                           ${bean.ip }
			                            </td>
			                            <!-- 所属机房 -->
			                            <td>
                                            ${bean.computerroom }
			                            </td>			                            
			                            <!-- 所属机柜 -->
			                            <td>
			                               ${bean.computerContainer }                                              
			                             
			                            </td>
			                             <!-- 机柜位置 -->
			                            <td>
			                               ${bean.site }                                             			                             
			                            </td>			                           
			                             <!-- 机房定位 -->
			                            <td>
			                         		<c:if test="${not empty bean.computerroomId}">
		                                      	<div align="center">
	                                                <html:link href="javascript:openJifangMap('/IGASM1104_Flex.do?eiid=${bean.computerroomId}&container_eiid=${bean.computerContainerId}')"><img src="images/look.gif" alt="查看详细信息" width="16" height="16"  border="0"/></html:link>
	                                            </div>                                            			                             
			                         		</c:if>
			                            </td>			                           
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