<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM1121" toScope="request"/>
<bean:define id="title" value="机柜设备详细查询" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
	function PrintPreview(){
		form.action = getAppRootUrl() + "/IGASM1111_Detail.do";
    	form.submit();
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
<html:form styleId="form" action="/IGASM1120_Disp"
             onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1">机房管理 &gt;&gt; 机柜列表&gt;&gt; 设备详细</p>
                    <div class="back"><html:link href="IGASM1111_Back.do">返回</html:link></div>
            </div>         
                               
                <div id="results_list">
					 
			       <table width="100%" class="table_style">
			            <!-- header部 -->
			                <tr>					          					           
					           <th width="15%">设备类型</th>
					           <th width="15%">设备名称</th>
					           <th width="15%">业务系统</th>
					           <th width="10%">型号</th>
					           <th width="15%">IP地址</th>
					           <th width="10%">所属机房</th>	
					           <th width="10%">机柜位置</th>					    					           
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
			                            <!-- 业务系统-->
			                            <td>
			                               ${bean.businesssys }
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
			                  
			                             <!-- 机柜位置 -->
			                            <td>
			                               ${bean.site }                                             			                             
			                            </td>			                           
			                    </logic:iterate>
			                </logic:present>
			       </table>
			     </div>
			     <div id="operate">
			               
			    </div>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>

</div>

</body>
</html:html>