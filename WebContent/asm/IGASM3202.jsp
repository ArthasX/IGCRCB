<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM3202" toScope="request"/>
<bean:define id="title" value="风险事件登记画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<style>
input {
width:254px;
margin-left:1px;
border:1px solid #ccc;
height:20px;
}

select {
width:258px;
margin-left:-2px;
margin-top:-2px;
height:40px;
border: solid #ccc;
} 
#shade{
border:solid 1px #ccc;
width:253px;
height:17px;
overflow:hidden;
margin-left:1px;

}
textarea {
	width:255px;
	padding:1px;
	border:1px solid #ccc;
	margin:1px;
	font-family:'Tahoma';	
	font-size:12px;
	font-weight: normal;
}
</style>
<body >
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
            </div>
            
		    <div id="formwrapper">
		         <html:form styleId="form" action="/IGASM3202">
                      <!--  message -->
                      <ig:message/>
                      <!--  /message -->     
		            <fieldset>
	                    <legend>风险事件基本信息</legend>
	                    <table  width="860px" style="margin-left:60px;margin-top:20px;">
			            	<tr>
				            	<td align="right" width="160px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>风险事件名称：</strong></td>
				            	<td align="left" width="254px"> <html:text property="fcname" tabindex="1"/></td>
				            	<td align="right" width="16px"/>
				            	<td align="right" width="160px" style="background-color: #EEEEEE; "><span class="red">*&nbsp&nbsp</span><strong>风险事件来源：</strong></td>
				            	<td align="left" width="254px"> 
				            	<div id="shade">
									<html:select property="fcorigin"  tabindex="2" style="width: 254px;" errorStyleClass="inputError">
										<ig:optionsCollection ccid="RISK_CASE_ORIGIN" isCodeLabel="true"/>
									</html:select>
								</div>
								</td>
								<td align="right" width="16px"/>
			            	</tr>
			            	<tr>
				            	<td align="right" width="160px" style="background-color: #EEEEEE; "><span class="red">*&nbsp&nbsp</span><strong>风险事件描述：</strong></td>
				            	<td align="left" width="254px" colspan="3"> <html:textarea property="fcdesc" style="width:254px" rows="3" tabindex="3"/></td>
				            	
			            	</tr>
			            	<tr>
				            	<td align="right" width="160px" style="background-color: #EEEEEE; "><strong>相关评估工作：</strong></td>
				            	<td align="left" width="254px"> 
				            		<html:text  property="fccheckjob" tabindex="4"  readonly="true"/>
				            		<input width="0px" type="hidden" name="riskjobid" id="riskjobid" />
				            	</td>
				            	<td align="right" width="16px"><img src="images/seek.gif" style="cursor: hand;" alt="选择评估工作" width="16" height="16" border="0" onclick="setOrg2();"/></td>
				            	<td align="right" width="160px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>风险事件所属领域：</strong></td>
				            	<td align="left" width="254px"> 
				            	<div id="shade">
									<html:select property="fccategory"  tabindex="5" style="width: 254px;" errorStyleClass="inputError">
										<ig:optionsCollection ccid="RISK_CASE_CATEGORY" isCodeLabel="true"/>
									</html:select>
								</div>
								</td>
								<td align="right" width="16px"/>
			            	</tr>
			            	<tr>
				            	<td align="right" width="160px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>风险点名称：</strong></td>
				            	<td align="left" width="254px"> 
				            		<html:text property="fcriskname" readonly="true" tabindex="5" />
									<input width="0px" type="hidden" name="riskid" id="riskid" />
				            	</td>
				            	<td align="right" width="16px">
				            		<img src="images/seek.gif" style="cursor: hand;" alt="选择风险点" width="16" height="16" border="0" onclick="setOrg3();"/>
				            	</td> 
				            	<td align="right" width="160px" style="background-color: #EEEEEE; "><strong>风险点分类：</strong></td>
				            	<td align="left" width="254px"> 
									<html:text property="fctypename" readonly="true" tabindex="6" />
									<input width="0px" type="hidden" name="risktype" id="risktype" />
								</td>
								<td align="right" width="16px"/>
			            	</tr>
			            	<tr>
				            	<td align="right" width="160px" style="background-color: #EEEEEE; "><strong>风险严重级别：</strong></td>
				            	<td align="left" width="254px"> 
				            		<html:text property="fcseveritylevel" readonly="true" tabindex="7" />
				            	</td>
				            	<td align="right" width="16px"/>
				            	<td align="right" width="160px" style="background-color: #EEEEEE; "><strong>风险发生可能性：</strong></td>
				            	<td align="left" width="254px"> 
									<html:text property="fcpossibility" readonly="true" tabindex="8" />
								</td>
								<td align="right" width="16px"/>
			            	</tr>
			            	<tr>
				            	<td align="right" width="160px" style="background-color: #EEEEEE; "><strong>风险级别：</strong></td>
				            	<td align="left" width="254px"> 
				            		<html:text property="fclevel" readonly="true" tabindex="9" />
				            	</td>
				            	<td align="right" width="16px"/>
				            	<td align="right" width="160px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>风险识别时间：</strong></td>
				            	<td align="left" width="254px"> 
									<html:text property="riskcatchtime" readonly="true" tabindex="10" />
								</td>
								<td align="right" width="16px">
									<img src="images/date.gif" align="middle" width="16"  style="cursor:pointer;" onClick="calendar($('riskcatchtime'))" border="0" />
								</td>
			            	</tr>
			            	<tr>
				            	<td align="right" width="160px" style="background-color: #EEEEEE; "><strong>应对任务名称：</strong></td>
				            	<td align="left" width="254px"> 
									<html:text property="fcrisktask" tabindex="11" />
								</td>
				            	<td align="right" width="16px"/>
				            	<td align="right" width="160px" style="background-color: #EEEEEE; "><strong>应对策略：</strong></td>
				            	<td align="left" width="254px"> 
				            	<div id="shade">
									<html:select property="fcpolicy"  tabindex="12" style="width: 254px;" errorStyleClass="inputError">
										<ig:optionsCollection ccid="RISK_POLICY" isCodeLabel="true"/>
									</html:select>
								</div>
								</td>
								<td align="right" width="16px"/>
			            	</tr>
			            	<tr>
				            	<td align="right" width="160px" style="background-color: #EEEEEE; "><strong>应对任务描述：</strong></td>
				            	<td align="left" width="254px" colspan="3"> 
				            		<html:textarea property="fcrisktaskdesc" style="width:254px" rows="3" tabindex="13" />
								</td>
			            	</tr>
			            	<tr>
			            		<td align="right" width="160px" style="background-color: #EEEEEE; "><strong>应对部门：</strong></td>
				            	<td align="left" width="254px"> 
									<html:text property="fcoperatordept" tabindex="14"  readonly="true"></html:text>
									<input type="hidden" width="0px" name="riskoperatordept" id="riskoperatordept" />
								</td>
								<td align="right" width="16px">
									<img src="images/seek.gif" style="cursor: hand;" alt="选择应对部门" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_ROLETREE.do');"/>
								</td>
				            	<td align="right" width="160px" style="background-color: #EEEEEE; "><strong>应对负责人：</strong></td>
				            	<td align="left" width="254px"> 
				            		<html:text property="fcoperator" tabindex="15"  readonly="true"></html:text>
									<input type="hidden" width="0px" name="riskoperator" id="riskoperator" />
				            	</td>
				            	<td align="right" width="16px">
				            		<img src="images/seek.gif" style="cursor: hand;" alt="选择负责人" width="16" height="16" border="0" onclick="searchuser();"/>
				            	</td>
			            	</tr>
			            	<tr>
				            	
				            	<td align="right" width="160px" style="background-color: #EEEEEE; "><strong>应对目标：</strong></td>
				            	<td align="left" width="254px"> 
				            		<html:text property="fcoperatoraim" tabindex="16" />
				            	</td>
				            	<td align="right" width="16px"/>
				            	<td align="right" width="160px" style="background-color: #EEEEEE; "><strong>抄送风控人员：</strong></td>
				            	<td align="left" width="254px"> 
									<html:text property="fcccoperator" tabindex="17"  readonly="true"></html:text>
									<input type="hidden" width="0px" name="riskccoperator" id="riskccoperator" />
								</td>
								<td align="right" width="16px">
									<img src="images/seek.gif" style="cursor: hand;" alt="选择风控人员" width="16" height="16" border="0" onclick="searchccuser();"/>
								</td>
			            	</tr>
			            </table>
			            
		            </fieldset>
		            <div class="enter">
		                <html:button property="btn_insert" value="提交" styleClass="button"  onclick="checkForm();"  />

		                <html:reset property="btn_ext" value="重置" styleClass="button" />
		               <!--  <a href="http://localhost:8080/InfoGovernor/IGASM0115.do?prid=909&&riskEiid=257">新的</a> -->
		                
		            </div>
		             <input width="0px" type="hidden" name="eiversion" id="eiversion" />
		             <html:hidden property="esyscoding"/>
		             <html:hidden property="eiorgsyscoding"/>
			         <html:hidden property="eid"/>
		         </html:form>
		    </div>
        </div>
    </div>
    <div class="zishiying"></div>
    
    
    
</div>


</div>
</body>
</html:html>