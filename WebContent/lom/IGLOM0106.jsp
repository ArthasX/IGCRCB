<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<html:html>
<bean:define id="id" value="IGLOM0106" toScope="request"/>
<bean:define id="title" value="接待月度汇总画面" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	

	WebCalendar.timeShow   = false  ;        //是否返回时间
        

	function checkSearch(){
		document.forms[0].action = getAppRootUrl() + "/IGLOM0106.do";
		document.forms[0].submit();

	}
function exportExcel() {
		document.forms[0].action = getAppRootUrl() + "/IGLOM0106.do?report=1";
		document.forms[0].submit();

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
            <html:form styleId="form" action="/IGLOM0106" onsubmit="return checkSubmit(this);">
          	<div id="location">
                <div class="image"></div>
                    <p class="fonts1">后勤管理 &gt;&gt; 接待管理 &gt;&gt; 接待月度汇总</p>
            	</div>
                <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
				         
		                 &nbsp;&nbsp;&nbsp;&nbsp;<span class="red">*</span>年度：
			        	 <html:select property="year"  name="IGLOM0106Form">
								<ig:optionsCollection ccid="YEAR_CODE" isMakeBlankRow="false" isCodeLabel="true"/>
						 </html:select>&nbsp;&nbsp;
			        	 <html:submit property="btn_search" value="查询" styleClass="button" onclick="checkSearch();"/>
			        	 <html:button property="btn_search" value="导出" styleClass="button" onclick="exportExcel();"/>
		     		</div>
          		</div> 
          		
                <div id="results_list">
					<!--  message -->
					<ig:message/>
					<!--  /message -->     
			       <table width="100%" class="table_style">
			            <!-- header部 -->
			                <tr>
					           <th width="10%">月份</th>
					           <th width="12%">接待工作数量</th>
					           <th width="10%">费用总额</th>
			                </tr>
			            <!-- body部 -->			  
			                <logic:present name="IGLOM01061VO" property="recptionVWList" >
			                    <logic:iterate id="bean" name="IGLOM01061VO" property="recptionVWList" indexId="index">
								<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="doLook('IGLOM0111.do?year=${IGLOM0106Form.year}&month=${bean.month}');">
			                            <!-- 月份 -->
			                            <td>
			                                <div class="nowrapDiv">${bean.month}</div>
			                            </td>
			                            <!-- 接待工作数量 -->
			                            <td>
			                                <div class="nowrapDiv">${bean.rnum}</div>
			                            </td>
			                            <!-- 费用总额 -->
			                            <td>
			                                <div class="nowrapDiv">${bean.amount}</div>
			                            </td>
			                        </tr>
			                    </logic:iterate>
								<logic:iterate id="bean" name="IGLOM01061VO"
									property="recptionVWList" length="1">
									<tr>
										<td>合计:</td>
										<td align="center">${IGLOM01061VO.sumrnum}</td>
										<td align="center">${IGLOM01061VO.sumamount}</td>
									</tr>
								</logic:iterate>
			                    
			                </logic:present>
			       </table>
			     </div>

            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>

</div>

</div>
</body>
</html:html>