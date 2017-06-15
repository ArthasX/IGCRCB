<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<html:html>
<bean:define id="id" value="IGRIS0205" toScope="request" />
<bean:define id="title" value="关联审计项" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
		var gid='IGRIS0205';
		function toback(){
	        form.action = getAppRootUrl() + "/IGRIS0201_Back.do";
	        form.submit();
	    }

		function ope(name){
	        if(name=="save"){
	        	if(window.confirm("您确定要提交吗？")){
	        		var count=0;
	   			 	count=checkAndCreate();
	   				 if(count==0){
	   					alert("请您先选择要提交的记录！");
	   					return false;
	   			 	}
	   			 	if(count==9){
	   				 	return false;
	   			 	}
	        		document.forms[0].action = getAppRootUrl() + "/IGRIS0201_Save.do";
					document.forms[0].submit();

	        	}
				
	        }
	    }
		
		function checkAndCreate(){
			var count=0;	
			var check = document.getElementsByName("radids");
			
			for(var i=0;i<check.length;i++){
				if(check[i].checked==true){
					count=1;
				}
			}
		
		    return count;
		}
		function checkForm(){
			if($F('raid').trim()==""){
				alert("请选择版本！");
				return false;
			}else {
				return true;
			}
		}
		<%Map<String,Integer> countMap = new HashMap<String,Integer>(); %>
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGRIS0201_Relevance" styleId="form"
	onsubmit="return checkSubmit(this);">
	<input type="hidden" name="rcid" value="<%=request.getAttribute("rcid") %>">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">信息安全 &gt;&gt; 风险检查 &gt;&gt; 检查策略管理 &gt;&gt;关联审计项</p>
	<div class="back"><html:link href="javascript:toback();" target="_self">返回</html:link></div>
	</div>
	<div id="search">
      <div class="img"></div>
         <div class="conditions">
         <div>
         <label><span class="red">*</span>版本：</label>
         <span>
         <logic:present name="labelList">
			<html:select property="raid" errorStyleClass="inputError imeActive" styleId="raid">
				<html:options collection="labelList" property="value" name="" labelProperty="label"/>
			</html:select> 
		 </logic:present>
         </span>
         
        <span>&nbsp;<html:submit styleClass="button" value="查询"  onclick="return checkForm();"/></span>
         </div>
        </div>
    </div>
	<div id="results_list">
	<ig:message/>
	<table class="table_style">
		<tr>
			<th width="10%">
				<label> 
				<input type="checkbox" name="checkbox1" id="checkbox1" onclick="selectAll('checkbox1','radids')"/> 
				</label>
			</th>
			<th width="20%">编号</th>
			<th width="70%" colspan="${IGRIS02011VO.radMaxLevel}">审计项目</th>

		</tr>
		<logic:present name="IGRIS02011VO" property="riskAuditDefList">
			<logic:iterate id="bean" name="IGRIS02011VO" property="riskAuditDefList" indexId="index" type="com.deliverik.infogovernor.risk.model.RiskAuditDef">
				<tr>
					<td height="20">
						<label>
						<html:multibox property="radids" value="${bean.radid}" />
					 	</label>
					</td>
					<td align="left"><%String radparcode = bean.getRadparcode();
						if(countMap.containsKey(radparcode)) {
							countMap.put(radparcode,countMap.get(radparcode) + 1);
						} else {
							countMap.put(radparcode,1);
						}%><% String levelCode = countMap.get(radparcode).toString();
								int level = Integer.parseInt(bean.getRadlevel());
								for(int i = level - 1; i > 0; i--) {
									String parcode = radparcode.substring(0 , radparcode.length() -3);
									radparcode = radparcode.substring(0 , radparcode.length() -3);
									levelCode = countMap.get(parcode) + "." +levelCode;
								}
						%><%=levelCode%></td>
					<c:if test="${bean.radlevel > 1}">
					<logic:iterate id="count" name="IGRIS02011VO" property="radMaxLevelList" length="${bean.radlevel - 1}"><td width="10%">&nbsp;</td></logic:iterate>
					</c:if>
					<td colspan="${IGRIS02011VO.radMaxLevel - bean.radlevel + 1}" align="left">
						<logic:empty name="bean" property="radname">&nbsp;</logic:empty>${bean.radname}
					</td>
					
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div class="enter">
	<logic:present name="IGRIS02011VO" property="riskAuditDefList">
	<logic:notEmpty name="IGRIS02011VO" property="riskAuditDefList">
	<html:button property="btn_insert" value="保存" styleClass="button" onclick="ope('save')"/>
	<html:reset property="btn_reset" value="重置" styleClass="button"/>
	</logic:notEmpty>
	</logic:present>
	</div>

</html:form></div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
