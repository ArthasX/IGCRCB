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
<bean:define id="id" value="IGIOP0102" toScope="request"/>
<bean:define id="title"  toScope="request" value="子网管理"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<style type="text/css">
	.opA{
		cursor: pointer;;
		color: blue;
	}
	.btnSty{
		clear:both;
		height: 18px;
		background-color: #BEE5F8;
		border: 0px;
	}
	#results_list INPUT{
		margin: 0px;
		padding: 0px;
	}
	.optionTD img{
		margin-right: 15px;
	}
</style>

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
                  <p class="fonts1">网络管理 &gt;&gt; 子网管理 &gt;&gt; 子网管理</p>
            </div> 
            <html:form action="IGIOP0102" method="POST">
	             <div id="search">
			             <div class="img"></div>
			             <div class="conditions">
	                          <div class="conditions_border1">
		                          <div>
		                          		<label>子网:</label><html:text property="einame"></html:text>
		                          		<label>子网掩码:</label><html:text property="subnet"></html:text>
										<html:submit styleClass="button">查询</html:submit>
										<html:hidden property="eid" value="CM08010001"/>
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
			       			<th width="8%"><input type="checkbox" onclick="selAll(this)" /></th>
			       			<th width="8%">序号</th>
			       			<th width="15%">子网</th>
			       			<th width="15%">子网掩码</th>
			       			<th width="10%">登记时间</th>
			       			<th width="24%">分配说明</th>
			       			<th width="7%">生成IP</th>
			       			<th width="7%">分配IP</th>
			       			<th width="7%">回收IP</th>
			       		</tr>
			       		<logic:present name="IGIOP01021VO"  property="ipsList">
				       		<logic:iterate id="bean" name="IGIOP01021VO" property="ipsList" indexId="index">
					       		<tr class="<ig:rowcss index="${index}"/>">
					       			<td>
					       				<html:checkbox property="delEiids" value="${bean.eiid }"></html:checkbox>
<%-- 					       				<input type="checkbox" name="delEiides" value="${bean.eiid }" /> --%>
					       			</td>
					       			<td>${PagingDTO.viewStartCount+index}</td>
					       			<td>${bean.einame }</td>
					       			<td>${fn:substring(bean.eilabel,0 ,fn:indexOf(bean.eilabel,"_")) }</td>
					       			<td>${bean.eiinsdate }</td>
					       			<logic:empty name="bean" property="eidesc">
					       				<td><a class="opA"  eiid='${bean.eiid }'>分配子网</a>&nbsp;</td>
					       			</logic:empty>
					       			<logic:notEmpty name="bean" property="eidesc">
					       				<td title="回收子网">
					       				<div style="width:95%; float:left; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;" ><a href="javascript:;" onclick="reSubNet(this)" eiid="${bean.eiid }">${bean.eidesc }</a></div> &nbsp;</td>
					       			</logic:notEmpty>
					       				
					       				<logic:notEqual name="bean" property="eistatus" value="N">
					       					<td class="optionTD">
					       						<html:link href="javascript:;"  onclick="creatIP(${bean.eiid })"><img alt="生成子网IP"  border="0" src="images/igasm0308.gif"/> </html:link>
					       					</td>
					       					<td class="optionTD">
					       						<img alt="IP分配" border="0"   src="images/igasm0701_h.gif"/>
					       					</td>
					       					<td class="optionTD">
					       						<img alt="IP回收" border="0"   src="images/igasm0310_h.gif"/>
				       						</td>
					       				</logic:notEqual>
					       				<logic:equal name="bean" property="eistatus" value="N">
					       					<td class="optionTD"><img alt="生成子网IP" border="0"  src="images/igasm0308_h.gif"/></td>
						       				<td class="optionTD"><html:link href="javascript:;"   onclick="showIP(${bean.eiid })"><img alt="IP分配" border="0"   src="images/igasm0701.gif"/> </html:link></td>
						       				<td class="optionTD"><html:link href="javascript:;"   onclick="recoveryIP(${bean.eiid })"><img alt="IP回收" border="0"   src="images/igasm0310.gif"/> </html:link> </td>
					       				</logic:equal>
					       		</tr>
				       		</logic:iterate>
			       		</logic:present>
			       </table>
            </div>
            	<html:hidden property="upeiid" styleId="upeiid"/>
            	<html:hidden property="upeidesc" styleId="upeidesc"/>
             </html:form>
            <div id="operate">
                <!-- paging -->
                <jsp:include page="/include/paging.jsp"/>
                <!-- /paging -->
		    </div>
		    <logic:present name="IGIOP01021VO" property="ipsList">
			    <div class="enter">
			    	<input type="button" value="批量删除" class="button" onclick="delSubNet()" />
			    </div>
		    </logic:present>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
<script type="text/javascript">
	function showIP(eiid){
		document.forms[0].action = getAppRootUrl()+"/IGIOP0102_View.do?eiid="+eiid;
		document.forms[0].submit();
	}
	function recoveryIP(eiid){
		document.forms[0].action = getAppRootUrl()+"/IGIOP0102_Recovery.do?eiid="+eiid;
		document.forms[0].submit();
	}
	function showTxt(obj){
		jQuery(obj).hide().before("<input type='text' name ='upeidesc' value = '' /> <input type='button' eiid='"+jQuery(obj).attr("eiid")+"' class='btnSty' style='height:17px;'onclick='save(this)' value='分配'");
		
	}
	jQuery(function(){
		jQuery(document).click(function(event){
			if(jQuery(event.target).nextAll(".opA").length>0){
				return;
			}
			jQuery(".opA:hidden").each(function(i,t){
				jQuery(t).show().prevAll().remove();
			});
			
			if(jQuery(event.target).attr("class")=='opA'){
				showTxt(event.target);
			}
		});
		
		
	});
	function save(obj){
		var upeiid = jQuery(obj).attr("eiid");
		var upeidesc = jQuery(obj).prev().val();
		if(!upeidesc){
			alert("请填写分配说明");
			return false;
		}
		jQuery("#upeidesc").val(upeidesc);
		jQuery("#upeiid").val(upeiid);
		document.forms[0].action = getAppRootUrl()+"/IGIOP0102_Update.do";
		document.forms[0].submit();
	}
	function creatIP(eiid){
		document.forms[0].action = getAppRootUrl()+"/IGIOP0102_Create.do?eiid="+eiid;
		document.forms[0].submit();
		
	}
	function selAll(obj){
		jQuery(":checkbox[name='delEiids']").attr("checked",jQuery(obj).attr("checked"));
	}
	
	function reSubNet(obj){
		if(confirm("请确认将要回收的子网")){
			jQuery("#upeidesc").val('');
			jQuery("#upeiid").val(jQuery(obj).attr("eiid"));
			document.forms[0].action = getAppRootUrl()+"/IGIOP0102_Update.do";
			document.forms[0].submit();
		}
	}
	function delSubNet(){
		if(jQuery(":checkbox:checked[name='delEiids']").length==0){
			alert("请选择将要删除的子网");
			return false;
		}
		if(confirm("将同时删除子网内的IP")){
			document.forms[0].action = getAppRootUrl()+"/IGIOP0102_Del.do";
			document.forms[0].submit();
		}
	}
</script>
</body>
</html:html>