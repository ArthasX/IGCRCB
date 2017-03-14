<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<html:html>
<bean:define id="id" value="IGLOM0114" toScope="request" />
<bean:define id="title" value="接待客人查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	

	WebCalendar.timeShow   = false  ;        //是否返回时间
        
    function search(){
		document.forms[0].action = getAppRootUrl() + "/IGLOM0114.do";
		document.forms[0].submit();
	}

	
	</script>

<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
	<div id="content">
		<html:form styleId="form" action="/IGLOM0114" onsubmit="return checkSubmit(this);">
			<div id="location">
				<div class="image"></div>
				<p class="fonts1">后勤管理 &gt;&gt; 接待管理 &gt;&gt; 接待客人查询</p>
			</div>
			<div id="search">
				<div class="img"></div>
				<div class="conditions">
				<label>来宾单位：</label><html:text property="rgunit"></html:text>
				<label>来宾姓名：</label><html:text property="rgname"></html:text>
				<html:submit property="btn_search" value="查询" styleClass="button" onclick="return search();" /> 
				</div>
		    </div>
		    <div id="results_list">
							<!--  message -->
							<ig:message/>
							<!--  /message -->     
					       <table width="100%" class="table_style">
					            <!-- header部 -->
					                <tr>
							           <th width="5%">
							             <label>序号
							             </label>
							           </th>
							           <th width="10%">客人姓名</th>
							           <th width="12%">客人单位</th>
							           <th width="10%">接待工作名称</th>
							           <th width="10%">开始日期</th>
							           <th width="10%">结束日期</th>
							           <th width="10%">状态</th>
							           <th width="5%">物品信息</th>
					                </tr>
					            <!-- body部 -->			  
					                <logic:present name="IGLOM01131VO" property="guestRecptionList" >
					                    <logic:iterate id="bean" name="IGLOM01131VO" property="guestRecptionList" indexId="index">
					                        <tr class="<ig:rowcss index="${index}"/>">
					                            <td>
					                            	<div class="nowrapDiv">${PagingDTO.viewStartCount+index}</div>
					                            </td>
					                             <!-- 客人姓名 -->
					                            <td>
					                                <div class="nowrapDiv">${bean.rgname}</div>
					                            </td>
					                            <!-- 客人单位 -->
					                            <td>
					                                <div class="nowrapDiv">${bean.rgunit}</div>
					                            </td>
					                            <!-- 接待工作名称 -->
					                            <td>
		                                            <div class="nowrapDiv">${bean.rname}</div>
					                            </td>
					                            <!-- 开始日期 -->
					                            <td>
		                                            <div class="nowrapDiv">${bean.rstime}</div>
					                            </td>
					                            <!-- 结束日期 -->
					                            <td>
		                                            <div class="nowrapDiv">${bean.retime}</div>
					                            </td>
					                           <!-- 状态  进行中:1   结束:2 -->
					                            <td>
					                                <div class="nowrapDiv"><ig:cseCodeValue codeIndex="<%=CodeUtils.RECPTION_STATUS%>" codeValue="${bean.rstatus}" /></div>
					                            </td>
					                            
					                            <!-- 物品信息 -->
			                            <td><div align="center"><html:link action="/IGLOM0260_Disp.do?rid=${bean.rid}&goorg=${bean.organizationTB.orgsyscoding}&lomid=lom0114&hascategory=true"><img src="images/stock.gif" alt="显示物品信息" width="16" height="16"  border="0"/></html:link></div></td>
					                        </tr>
					                    </logic:iterate>
					                </logic:present>
					       </table>
			</div>
			<div id="operate">
               <logic:present name="IGLOM01131VO" property="recptionList" >
               
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