<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGDRM0705" toScope="request"/>
<bean:define id="title" value="演练流程查询" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<style type="text/css">
	a img{
		border: 0px;
	}
	.hover{
		background-color: #d3d3d3;
		cursor: pointer;
	}
	.leftd{
		text-align: left;
	}
	#results_list INPUT{
		height: 20px;
	}
</style>
<!-- /header1 -->
<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<%-- <jsp:include page="/include/header2.jsp" /> --%>
<!--container 左菜单 右侧内容-->
<div id="container">

    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content" style="float:left; border:1px solid #D4EEFD;height:520px; margin-left: 10px;padding-top: 10px;">
		    <div id="results_list" >
			<!--  message -->
				<ig:message/>
			<!--  /message -->     
	       <table width="100%" class="table_style">
	       	<tr>
	       		<th width="5%">操作</th>
				<th width="8%">编号</th>
				<th width="18%">演练内容</th>
				<th width="8%">发起者</th>
				<th width="10%">发起时间</th>
				<th width="12%">当前处理人</th>
				<th width="10%">状态</th>
	       	</tr>
	       	 <logic:present name="IGDRM07011VO" property="ig500InfoList" >
	       	 	<logic:iterate id="bean" name="IGDRM07011VO" property="ig500InfoList" indexId="index">
	       	 		<tr>
	       	 			<td>
	       	 				<a href="javascript:void(0);" style="text-decoration: none;" onclick="setPrid('${bean.prid}','${bean.prtitle }')"><img src="images/select_asset.gif" title="选择"/> </a>
	       	 			</td>
	       	 			<td width="8%">${bean.prserialnum }</td>
						<td width="18%">${bean.prdesc }</td>
						<td width="8%">${bean.prusername }</td>
						<td width="10%">${bean.propentime }</td>
						<!-- 当前处理人 -->
						<td title="<ig:ProcessParticipantForStatusWriteTag prstatus="${bean.prstatus }" prid="${bean.prid }" />">
						<ig:SubstringShowEllipsisWriteTag len="8" showEllipsis="true">
							<ig:ProcessParticipantForStatusWriteTag prstatus="${bean.prstatus }" prid="${bean.prid }" />
						</ig:SubstringShowEllipsisWriteTag>
						
						</td>
						<!-- 流程状态 -->
					<td>	
						<logic:equal value="WD" name="bean" property="prtype">
						<ig:processDefineTypeValue prid="${bean.prid}"/>
						<logic:equal value="C" property="prsubstatus" name="bean">(中止)</logic:equal>
						</logic:equal>
						<logic:notEqual value="WD" name="bean" property="prtype">
						    <logic:notEqual value="" property="prsubstatus" name="bean">
								<ig:codeValue ccid="${bean.prtype}" cid="${bean.prstatus}" />
								(<ig:codeValue ccid="${bean.prtype}SUB" cid="${bean.prsubstatus}"/>)
							</logic:notEqual>
							<logic:equal value="" property="prsubstatus" name="bean">
								<ig:codeValue ccid="${bean.prtype}" cid="${bean.prstatus}" />
							</logic:equal>
						</logic:notEqual>
					</td>
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
    </div>
</div>
</div>
<script type="text/javascript">	

	function setPrid(prid,prname){
		if(this.opener&&!this.opener.closed){
			window.opener.setPrid(prid,prname);
		}
		window.close();
	}
</script>
</body>
</html:html>