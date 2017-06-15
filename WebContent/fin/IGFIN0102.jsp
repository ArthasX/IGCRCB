<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGFIN0102" toScope="request" />
<bean:define id="title" value="预算查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css"> .file { font: 10pt; color: black; } </style>
<script type="text/javascript">
function deleteFin(firstbamount){
	if(firstbamount=="N"){
		alert("此预算下有项目，不可以删除！");
		return false;
		
	}else{
		if(confirm("请确认是否删除预算?")){
			return true;
		}
	}
	return false;
}

function closeFin(){
	if(confirm("请确认是否关闭预算?")){
		return true;
	}
	return false;
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
        <p class="fonts1">服务管理 &gt;&gt; 预算管理 &gt;&gt; 预算查询</p>
    </div>  
     <div id="search">
     <html:form styleId="form" action="/IGFIN0102" onsubmit="return checkSubmit(this);">
         <div class="img"></div>
          <div class="conditions">
      <div>
       <span>预算年度：</span> <html:select property="byear_q" style="width: 100px;" errorStyleClass="inputError">
            <html:options collection="byearList" property="value" name="" />
       </html:select>&nbsp;&nbsp;
       <span>预算类别：</span><html:select property="btype_q" style="width: 100px;" errorStyleClass="inputError">
            <ig:optionsCollection ccid="BUDGET_TYPE_CATEGORY_CODE" isMakeBlankRow="true" isCodeLabel="true" />
       </html:select>&nbsp;&nbsp;
         <span>预算名称：</span><html:text property="btitle_q" styleId="btitle" errorStyleClass="inputError imeDisabled" size="40" />&nbsp;&nbsp;
  <span>

       <html:submit property="btn_search" styleClass="button" value="查询" />
       </span> 
       </div>
      </div>
      </html:form>
    </div>
    
        
     
     <div id="results_list"><ig:message />
       <table  class="table_style">
						
						<tr>
							<th width="3%">序号</th>
							<th width="4%">年度</th>
							<th width="8%">预算类别</th>
							<th width="22%">预算名称</th>
							<th width="6%">预算金额</th>
							<th width="23%">预算内容</th>
							<th width="4%">开发</th>
							<th width="4%">硬件</th>
							<th width="4%">软件</th>
							<th width="4%">工程</th>
							<th width="4%">其他</th>
							<th width="4%">实施</th>
							<th width="4%">其他</th>
							<th width="3%">删除</th>

						</tr>
					
						
						<!-- body部 -->
                            <logic:present name="IGFIN01011VO" property="budgetFormList">
								<logic:iterate id="bean" name="IGFIN01011VO"
									property="budgetFormList" indexId="index" type="com.deliverik.infogovernor.fin.form.IGFIN0102Form">
									<tr>
										<!-- 编号 -->
										<td>
										<div class="nowrapDiv">
											${PagingDTO.viewStartCount+index}
											 <html:hidden name="bean" property="firstbamount" />
										</div>
										</td>
										<!-- 预算年度-->
										<td>
										<div class="nowrapDiv">
										<div class="nowrapDiv"><logic:empty name="bean"
											property="byear">&nbsp;</logic:empty> ${bean.byear}</div>
										</div>
										</td>
										<!-- 项目类别-->
										<td>
										<div class="nowrapDiv">
										<logic:empty name="bean"
											property="btype">&nbsp;</logic:empty> <ig:codeValue ccid="BUDGET_TYPE_CATEGORY_CODE" cid= "${bean.btype}" isChild="true"/></div>
										</td>
										<!-- 项目名称 -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="btitle">&nbsp;</logic:empty> 
											<html:link action="/IGFIN0107_Disp.do?bid=${bean.bid}">${bean.btitle}</html:link></div>
										</td>
										<!-- 项目预算-->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="bamount">&nbsp;</logic:empty> <bean:write name="bean" property="bamount" format="##.##" /></div>
										</td>
										
										
										<!-- 项目内容 -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="bdesc">&nbsp;</logic:empty> ${bean.bdesc}</div>
										</td>
										<!--  开发-->
										<td>
											<div class="nowrapDiv"><logic:empty name="bean"
											property="bzdevelop">&nbsp;</logic:empty> 
											<bean:write name="bean" property="bzdevelop" format="##.##" /></div>
										</td>
										<!-- 硬件-->
										<td>
											<div class="nowrapDiv"><logic:empty name="bean"
											property="bzhardware">&nbsp;</logic:empty> 
											<bean:write name="bean" property="bzhardware" format="##.##" /></div>
										</td>
										<!-- 软件-->
										<td>
											<div class="nowrapDiv"><logic:empty name="bean"
											property="bzsoftware">&nbsp;</logic:empty> 
											<bean:write name="bean" property="bzsoftware" format="##.##" /></div>
										</td>
										<!-- 工程-->
										<td>
											<div class="nowrapDiv"><logic:empty name="bean"
											property="bzproject">&nbsp;</logic:empty> 
											<bean:write name="bean" property="bzproject" format="##.##" /></div>
										</td>
										<!-- 其他-->
										<td>
											<div class="nowrapDiv"><logic:empty name="bean"
											property="bzelse">&nbsp;</logic:empty> 
											<bean:write name="bean" property="bzelse" format="##.##" /></div>
										</td>
										<!-- 实施-->
										<td>
											<div class="nowrapDiv"><logic:empty name="bean"
											property="bcimplement">&nbsp;</logic:empty> 
											<bean:write name="bean" property="bcimplement" format="##.##" /></div>
										</td>
										<!-- 其他-->
										<td>
											<div class="nowrapDiv"><logic:empty name="bean"
											property="bcelse">&nbsp;</logic:empty> 
											<bean:write name="bean" property="bcelse" format="##.##" /></div>
										</td>
										<td><!-- 删除 -->
										<html:link action="/IGFIN0105_Disp.do?bid=${bean.bid}" onclick="return deleteFin('${bean.firstbamount }');">
											<img src="images/delete.gif" width="16" height="16" border="0" />
										</html:link>
										</td>
									</tr>
								</logic:iterate>
							</logic:present>
					</table>
     </div>
     <div id="operate">
      <jsp:include page="/include/paging.jsp" />
	</div>

</div>
</div>
  </div>


</div>
</body>
</html:html>