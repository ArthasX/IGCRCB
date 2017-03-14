<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM1007" toScope="request"/>
<bean:define id="title" value="资产模型属性显示画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">	
function doSelect(cname,cattach,coption){
	
	window.returnValue = cname + "_" + cattach + "_" +coption;
	window.close();
}
function resetType(){
	window.returnValue = "_reset_cname";
	window.close();
}
</script>
<style>
body{
   overflow-x: hidden;
   overflow-y: auto;
}

</style>

<body>

<!--header  头部和 一级菜单-->
<!--container 左菜单 右侧内容-->

    <!--sidebar  左菜单--> 

    <!--content  右侧内容-->

            <html:form styleId="form" >
            	 <div id="location">
                <div class="image"></div>
                    <p class="fonts1">资产模型属性（按层次关系显示）</p>
           		 </div>
				 
                <div id="results_list">

			        <table class="table_style">
			            <!-- header部 -->
			                <tr>
			                   <th width="8%"></th>
			                   <th width="5%">序号</th>
					           <th width="25%">配置项名称</th>
					           <th width="30%">配置项说明</th>
					           <th width="16%">配置项单位</th>
					           <th width="16%">配置项类别</th>
			                </tr>
			            <!-- body部 -->
			           <logic:present name="IGASM01061VO" property="configurationMap">
						<bean:define id="countMap" name="IGASM01061VO" property="configurationMap" type="java.util.Map" />
			           			<logic:iterate id="map" name="IGASM01061VO" property="configurationMap" indexId="num">
						           <bean:define id="list" name="map" property="value" type="java.util.ArrayList" />
						           <bean:define id="name" name="map" property="key"/>
						          
						           <tr class="ParentEntityTR">
						           <td colspan="10" align="left"><img src="images/ee.gif" border="0"/>&nbsp;&nbsp;<bean:write name="map" property="key"/></td>           
						           </tr>
						           
			                    <logic:iterate id="bean" name="list" indexId="index">
			                
			                        <tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="doSelect('${bean.cname}','${bean.cattach}','${bean.coption}');">
			                        	 <td align="center">
			                        	 </td>
			                            <td align="center">
			                              	<%=index+1 %>
			                            </td>
	
			                            <!-- 名称 -->
			                            <td align="center">
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="cname">&nbsp;</logic:empty>
			                                ${bean.cname}
			                                </div>
			                            </td>
			                            <!-- 说明 -->
			                            <td align="center">
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="cdesc">&nbsp;</logic:empty>
			                                ${bean.cdesc}
			                                </div>
			                            </td>
			                            <!-- 单位 -->
			                            <td align="center">
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="cunit">&nbsp;</logic:empty>
			                                <ig:codeValue ccid="CONFIGURATION_UNIT_CODE" cid="${bean.cunit}"/>                              
			                                </div>
			                            </td>
			                            <!-- 类别 -->
			                            <td align="center">
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="ccategory">&nbsp;</logic:empty>
			                                <ig:codeValue ccid="CONFIGURATION_CATEGORY_CODE" cid="${bean.ccategory}"/>                              
			                                </div>
			                            </td>
	                                    <!-- 调整-->
										
			                        
	                                    <!-- 修改  -->
										
			                        </tr>
			                   		 </logic:iterate>
			                    </logic:iterate>
			                </logic:present>
	                </table>
		        </div>

                <div id="operate">
			        <div class="content">
			            <div class="enter">
			           		<input onclick="resetType();" type="button"  class="button" value="清空">
	                        <input onclick="javascript:window.close()" type="button"  class="button" value="取消">
			            </div>
			        </div> 
    		    </div>
		    </html:form>





</body>
</html:html>