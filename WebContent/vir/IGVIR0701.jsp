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
	function opedel(vcid){
		if(window.confirm("确认删除该行？")){
			location.href = "IGVIR0702_DEL.do?&vcid="+vcid;
		}
		
	}
	function opeedit(vcid){
		location.href = "IGVIR0702_EDIT.do?&vcid="+vcid;
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
             <div id="location">
                <div class="image"></div>
                    <p class="fonts1">虚拟化管理 &gt;&gt; vCenter管理 &gt;&gt; vCenter查询</p>
            </div>
			     
			<div id="results_list">
				<ig:message /> 
				<table class="table_style">
					<tr>		
						<th width="20%">名称 </th>
						<th width="20%">IP</th>
						<th width="20%">用户名</th>
						<th width="20%">密码</th>
						<th width="10%">修改</th>
						<th width="10%">删除</th>
					</tr>
					<logic:present name="IGVIR07011VO" property="vim01InfoList">
						<logic:iterate id="bean" name="IGVIR07011VO"
							property="vim01InfoList" indexId="index">
							<tr class="<ig:rowcss index="${index}"/>">					
								<td>
									${bean.vcname}
								</td>
								<td>${bean.vcurl}</td>
								
								<td>${bean.vcusername}</td>
								
								<td>${bean.vcpassword}</td>
							
								<td>
								<a href="javascript:opeedit('${bean.vcid}');"><img src="images/edit.gif" width="16" height="16" border="0" alt="修改" /></a>
								</td>
								<td>
								<a href="javascript:opedel('${bean.vcid}');"><img src="images/delete.gif" width="16" height="16" border="0" alt="删除" /></a>
								</td>
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