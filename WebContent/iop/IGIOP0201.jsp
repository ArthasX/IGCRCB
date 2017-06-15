<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGIOP0201" toScope="request"/>
<bean:define id="title"  toScope="request" value="IP管理"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">

	
</script>

<body onLoad="">
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
            <html:form action="IGIOP0201" method="POST">
	             <div id="search">
			             <div class="img"></div>
			             <div class="conditions">
	                          <div class="conditions_border1">
		                          <div>
		                          		<label>IP:</label><html:text property="eiName"></html:text>
		                          		<label>子网掩码:</label><html:text property="subnet"></html:text>
		                          		<label>分配状况:</label><html:select property="ipStatus" ><html:option value="1">已分配</html:option><html:option value="0">未分配</html:option> </html:select>
										&nbsp;&nbsp;&nbsp;&nbsp;
										<html:submit styleClass="button">查询</html:submit>
										<html:hidden property="eid" value="CM08010002"/>
		                          </div>
	                          </div>
	                     </div>
	             </div>   
            
            <div id="results_list">
					<!--  message -->
					<ig:message/>
					<!--  /message -->     
			       <table width="100%" class="table_style">
			       		<tr>
			       			<c:if test="${IGIOP0201Form.ipStatus=='1' }">
			       			<th width="6%"><input type="checkbox" onclick="changeAll(this)"/></th>
			       			</c:if>
			       			<th width="8%">序号</th>
			       			<th width="12%">IP</th>
			       			<th width="12%">子网掩码</th>
			       			<th width="12%">登记时间</th>
			       			<th width="40%">说明 </th>
			       			<c:if test="${IGIOP0201Form.ipStatus=='0' }">
			       				<th width="12%">IP操作</th>
			       			</c:if>
			       			
			       			
			       		</tr>
			       		<logic:present name="IGIOP02011VO"  property="ipList">
				       		<logic:iterate id="bean" name="IGIOP02011VO" property="ipList" indexId="index">
					       		<tr class="<ig:rowcss index="${index}"/>">
					       			<c:if test="${IGIOP0201Form.ipStatus=='1' }">
					       			<td><html:checkbox property="delEiids" value="${bean.eiid }"></html:checkbox></td>
					       			</c:if>
					       			<td>${PagingDTO.viewStartCount+index}</td>
					       			<td>${bean.einame }</td>
					       			<td>${fn:substring(bean.eilabel,0 ,fn:indexOf(bean.eilabel,"_")) }</td>
					       			<td>${bean.eiinsdate }</td>
					       			<td title="${bean.eidesc }"><div style="width:100%; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${bean.eidesc }</div></td>
					       			<logic:empty name="bean" property="eidesc">
					       				<td><html:link href="javascript:;" onclick="allotIP(${bean.eiid })"><img alt="IP分配" border="0" src="images/igasm0308.gif"/> </html:link></td>
					       			</logic:empty >
<%-- 					       			<logic:notEmpty name="bean" property="eidesc"> --%>
<%-- 					       				<td><html:link href="javascript:;" onclick="recoveryIP(${bean.eiid })"><img alt="IP回收" border="0" src="images/igasm0310.gif"/> </html:link></td> --%>
<%-- 					       			</logic:notEmpty> --%>
					       		</tr>
				       		</logic:iterate>
			       		</logic:present>
			       </table>	
            </div>
            <div id="operate">
                <!-- paging -->
                <jsp:include page="/include/paging.jsp"/>
                <!-- /paging -->
		    </div>
           			<c:if test="${IGIOP0201Form.ipStatus=='1' }">
			       <div class="enter"> <html:button property="btn_re" styleClass="button" value="批量回收" onclick="recoveryIP()"></html:button>
			        </div>
			       </c:if>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
<script type="text/javascript">
	//分配IP
	function allotIP(eiid){
		document.forms[0].action = getAppRootUrl()+"/IGIOP0202_Edit.do?eiid="+eiid;
		document.forms[0].submit();
	}
	//回收IP
	function recoveryIP(eiid){
		if(jQuery(":checkbox:checked[name ='delEiids']").length==0){
			alert("请选择将要回收的IP");
			return false; 
		}
		
		if(eiid){
			document.forms[0].action = getAppRootUrl()+"/IGIOP0201_Recovery.do?eiid="+eiid;
		}else{
			document.forms[0].action = getAppRootUrl()+"/IGIOP0201_Recovery.do";
		}
			
		document.forms[0].submit();
	}
	function changeAll(obj){
		jQuery(":checkbox[name='delEiids']").attr("checked",jQuery(obj).attr("checked"));
	}
	
</script>
</body>
</html:html>