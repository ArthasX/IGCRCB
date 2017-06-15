<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGVIR0701" toScope="request"/>
<bean:define id="title" value="vCenter列表画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">	

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
             <div id="location">
                <div class="image"></div>
                    <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
					<div class="back"><a href="IGVIR0803_SEARCH1.do" target="_self">返回</a></div> 
            </div>
<!-- 			<div class="role_title">用户信息</div> -->
<!-- 			<div id="results_list"> -->
<%-- 			<ig:message />  --%>
<!-- 				<table class="table_style6" align="left" style="width: 60%;"> -->
<%-- 				<logic:present name="IGVIR08041VO" property="user"> --%>
<%-- 				<bean:define id="org0841"  name="IGVIR08041VO" property="orgbean"/> --%>
<!-- 						<tr> -->
<!-- 							<th width="20%" >所在部门</th> -->
<%-- 							<td width="20%">${org0841.orgname}</td> --%>
<!-- 						</tr>	 -->
<%-- 				</logic:present> --%>
<!-- 				</table> -->
<!-- 			</div> -->
<!-- 			<div class="role_title">虚机信息</div> -->
			<div id="results_list">
				<table id="vminfo" cellspacing="0" align="left" class="table_style4" style="margin-top: 5px; width: 98%;" >
					<tr>
						<th style="text-align: center;" width="5%">序号</th>
<!-- 						<th style="text-align: center;" width="15%">vCenter</th> -->
						<th style="text-align: center;" width="15%">虚机模板</th>
						<th style="text-align: center;" width="15%">虚机名称</th>
						<th style="text-align: center;" width="10%">CPU</th>
						<th style="text-align: center;" width="10%">内存</th>
						<th style="text-align: center;" width="10%">硬盘</th>
					</tr>
					<logic:present name="IGVIR08041VO" property="oneVim03oList">
							<logic:iterate id="bean" name="IGVIR08041VO"
								property="oneVim03oList" indexId="index">
								<tr class="<ig:rowcss index="${index}"/>">				
									<td>${index+1}</td>
									
<%-- 									<td>${bean.vcName}</td> --%>
									
									<td>${bean.templateName}</td>
									
									<td>${bean.vmName}</td>
									
									<td>${bean.vmCpus}(个)</td>
									
									<td>${bean.vmMem}(G)</td>
									
									<td>${bean.vmDisk}(G)</td>
								</tr>
							</logic:iterate>
						</logic:present>
				</table>
			</div>
                 <div id="operate">
<%-- 					<jsp:include page="/include/paging.jsp" /> --%>
				 </div>
        </div>
    </div>
</div>


</div>
</body>
</html:html>