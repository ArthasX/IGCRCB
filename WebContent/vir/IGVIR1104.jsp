<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGVIR1104" toScope="request"/>
<bean:define id="title" value="资源列表" toScope="request"/>

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
                    <logic:equal name="IGVIR1104Form" property="showType"  value="ctrl">
                   		<logic:equal name="IGVIR1104Form" property="searchType"  value="org">
							<div class="back"><a href="IGVIR1102_SEARCH1.do" target="_self">返回</a></div> 
						</logic:equal>
						<logic:equal name="IGVIR1104Form" property="searchType"  value="proj">
							<div class="back"><a href="IGVIR1103_SEARCH1.do" target="_self">返回</a></div> 
						</logic:equal>
						<logic:equal name="IGVIR1104Form" property="searchType"  value="user">
							<div class="back"><a href="IGVIR1101_SEARCH1.do" target="_self">返回</a></div> 
						</logic:equal>
					</logic:equal>
            </div>
<!-- 			<div class="role_title">用户信息</div> -->
<!-- 			<div id="results_list"> -->
<%-- 			<ig:message />  --%>
<!-- 				<table class="table_style6" align="left" style="width: 60%;"> -->
<%-- 				<logic:present name="IGVIR11041VO" property="user"> --%>
<%-- 				<bean:define id="user0821"  name="IGVIR11041VO" property="user"/> --%>
<!-- 						<tr> -->
<!-- 							<th width="15%">用户id</th> -->
<%-- 							<td width="15%">${user0821.userid}</td> --%>
<!-- 							<th width="15%">用户名</th> -->
<%-- 							<td width="15%">${user0821.username}</td> --%>
<!-- 							<th width="20%" >所在部门</th> -->
<%-- 							<td width="20%">${user0821.orgname}</td> --%>
<!-- 						</tr>	 -->
<%-- 				</logic:present> --%>
<!-- 				</table> -->
<!-- 			</div> -->
<!-- 			<div class="role_title">虚机信息</div> -->
			<div id="results_list">
				<table id="vminfo" cellspacing="0" align="left" class="table_style4" style="margin-top: 5px; width: 98%;" >
					<tr>
						<th style="text-align: center;" width="6%">序号</th>
						
						<logic:notEqual name="IGVIR1104Form" property="searchType"  value="org">
							<logic:notEqual name="IGVIR1104Form" property="searchType"  value="proj">
								<th style="text-align: center;" width="16%">项目名称</th>
							</logic:notEqual>
							<logic:notEqual name="IGVIR1104Form" property="searchType"  value="user">
								<th style="text-align: center;" width="16%">申请人</th>	
							</logic:notEqual>
						</logic:notEqual>
						
						<logic:equal name="IGVIR1104Form" property="searchType"  value="org">
							<th style="text-align: center;" width="11%">项目名称</th>
							<th style="text-align: center;" width="11%">申请人</th>
						</logic:equal>
						
						<th style="text-align: center;" width="15%">虚机名称</th>
						<th style="text-align: center;" width="15%">申请日期</th>
						<th style="text-align: center;" width="11%">CPU数量</th>
						<th style="text-align: center;" width="11%">内存大小</th>
						<th style="text-align: center;" width="11%">硬盘大小</th>
						<th style="text-align: center;">费用</th>
					</tr>
					<logic:present name="IGVIR11041VO" property="oneVim03List">
							<logic:iterate id="bean" name="IGVIR11041VO"
								property="oneVim03List" indexId="index">
								<tr class="<ig:rowcss index="${index}"/>">				
									<td>${index+1}</td>
									
									<logic:notEqual name="IGVIR1104Form" property="searchType"  value="proj">
										<td>${bean.pname}</td>
									</logic:notEqual>
									<logic:notEqual name="IGVIR1104Form" property="searchType"  value="user">
										<td>${bean.userName}</td>
									</logic:notEqual>
									
									<td>${bean.vmName}</td>
									
									<td>${bean.applyTime}</td>
									
									<td>${bean.vmCpus}个</td>
									
									<td>${bean.vmMem}G</td>
									
									<td>${bean.vmDisk}G</td>
									
									<td>${bean.cpucost + bean.memcost + bean.diskcost}元</td>
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