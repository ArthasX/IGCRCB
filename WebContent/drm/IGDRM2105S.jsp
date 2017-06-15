<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDRM2105S" toScope="request" />
<bean:define id="title" value="场景选择" toScope="request" />
<!-- start header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- end header1 -->
<script type="text/javascript">
function setParentValue(eiid,einame){
	if(!window.opener.closed){
        window.opener.setSceneValue(eiid,einame);
        window.close();
    }
}
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<!--container 左菜单 右侧内容-->
    <!--content  右侧内容-->
    <div id="contentWrap">  
    <html:form action="IGDRM2104_Single.do" method="POST">
		    <!-- 左侧内容 -->
        <div id="content">
        	<div id="search">
	        <div class="img"></div>
	        <div class="conditions" >
	        	<div>
	        		<span>场景编号：</span>
	        		<span>
	        			<html:text property="eilabel" styleId="eilabel"/>
	        		</span>
	        		&nbsp;&nbsp;
	        		<span>场景负责人：</span>
	        		<span>
	        			<html:text property="eiusername" styleId="eiusername"/>
	        		</span>
	        		&nbsp;&nbsp;
	        		<span>参与人：</span>
	        		<span>
	        			<html:text property="participants" styleId="participants"/>
	        		</span>
	        	</div>
	        	<div>
	        		<span>创建日期：</span>
	        		<span>
	        			<html:text property="eiinsdatestart" styleId="eiinsdatestart" readonly="true"/>
	        			<img src="images/date.gif" align="middle" onClick="calendar($('eiinsdatestart'))" border="0"/>
	        		</span>
	        		<span>--</span>
	        		<span>
	        			<html:text property="eiinsdateend" styleId="eiinsdateend" readonly="true"/>
	        			<img src="images/date.gif" align="middle" onClick="calendar($('eiinsdateend'))" border="0"/>
	        		</span>
	        		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        		<html:submit styleClass="button" styleId="btnSub">查询</html:submit>
	        	</div>
					
		        </div>
		    </div>
		    <div id="results_list" >
			<!--  message -->
				<ig:message/>
			<!--  /message -->     
	       <table width="100%" class="table_style">
	       	<tr>
	       		<th width="5%"></th>
	       		<th width="15%">场景编号</th>
	       		<th width="28%">场景名称</th>
	       		<th width="15%">场景负责人</th>
	       		<th width="10%">创建日期</th>
	       		<th width="8%">是否已演练</th>
	       	</tr>
	       	 <logic:present name="IGDRM21041VO" property="planList" >
	       	 	<logic:iterate id="bean" name="IGDRM21041VO" property="planList" indexId="index">
	       	 		<tr class="<ig:rowcss index="${index}"/>">
	       	 			<td align="center">
							<img alt="选择" src="images/select_asset.gif" width="16" height="16" style="cursor: pointer;" onclick="setParentValue('${bean.eiid}','${bean.einame}')"/>
						</td>
	       	 			<td class="">${bean.eilabel}</td>
						<td>
						<html:link action="/IGDRM0108_Disp.do?eiid=${bean.eiid}">${bean.einame }</html:link>
						</td>
	       	 			<td>${bean.eiusername }</td>
	       	 			<td>${bean.eiinsdate }</td>
	       	 			<td>${bean.isplan }</td>
	       	 		</tr>
	       	 	</logic:iterate>
	       	 </logic:present>
	       </table>
		 </div>
		 <div id="operate" style="float:left;margin-left:10px;">
			<!-- paging -->
			<jsp:include page="/include/paging.jsp"/>
			<!-- /paging -->
		</div>
		<div class="enter">
			<input id="parent" type="button" name="btn_clear" value="清空" onclick="setParentValue('','')" class="button">
			<input type="button" class="button" value="关闭" onclick="window.close();">
		</div>
    </div>
    </html:form>
</div>
</div>
</body>
</html:html>
