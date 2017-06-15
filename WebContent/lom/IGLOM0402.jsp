<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<html:html>
<bean:define id="id" value="IGLOM0402" toScope="request"/>
<bean:define id="title" value="发票管理画面" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	

	    WebCalendar.yearFall   = 50;           //定义年下拉框的年差值
	    WebCalendar.format     = "yyyy/mm/dd"  //回传日期的格式
	    WebCalendar.timeShow   = false          //是否返回时间
	    WebCalendar.drag       = true          //是否允许拖动
	    WebCalendar.darkColor  = "#014DB4";    //控件的暗色
	    WebCalendar.lightColor = "#FFFFFF";    //控件的亮色
	    WebCalendar.btnBgColor = "#FFFFF5";    //控件的按钮背景色
	    WebCalendar.wordColor  = "#000080";    //控件的文字颜色
	    WebCalendar.wordDark   = "#DCDCDC";    //控件的暗文字颜色
	    WebCalendar.dayBgColor = "#E6E6FA";    //日期数字背景色
	    WebCalendar.todayColor = "#FF0000";    //今天在日历上的标示背景色
	    WebCalendar.DarkBorder = "#D4D0C8";    //日期显示的立体表达色

	  //删除所选
		function deleteRec(obj){
			var message = '<bean:message key="IGCO10000.E002"/>';
		    var confirmMsg = '<bean:message key="IGCO10000.W002" arg0="发票基本信息" />';
			if(checkNum(obj)==0){
				alert(message);
		        return false;
			}
		    if(window.confirm(confirmMsg)){
		        form.action = getAppRootUrl() + "/IGLOM04_Del.do";
		        return true;
		    } else {
		        return false;
		    }
		}
		function checkSearch(){
			if(!checkDateByContent("rtime_from","rtime_to")){
				alert("开始日期不能晚于结束日期！");
				return false;
			}else{
				return true;
			}

		}
		function setRoleDomain(url){
			url = url+"?roletype=IGAC01";
			var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
			if("_resetall"==temp){
				document.forms[0].ireqemp.value = "";
				document.forms[0].ireqempid.value = "";
				return false;
			}
			if(null!=temp && temp.split("|").length>1){
				document.forms[0].ireqemp.value = temp.split("|")[0];
				document.forms[0].ireqempid.value = temp.split("|")[1];
			}		
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
            <html:form styleId="form" action="/IGLOM0403" onsubmit="return checkSubmit(this);">
          	<div id="location">
                <div class="image"></div>
                    <p class="fonts1">后勤管理 &gt;&gt; 发票管理 &gt;&gt; 发票管理</p>
            	</div>
                <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
		                 
                    	 <label>发票类型：</label>
							<span> 
								<html:select property="itype" style="width: 100px;" errorStyleClass="inputError imeActive" >
								<html:options collection="invoice_itype" property="value" name="" labelProperty="label" /></html:select>
							</span>&nbsp;&nbsp;

			             <label>申请部门：</label>
			             <html:text property="ireqempid" readonly="true" ></html:text>
						 <img src="images/tree.gif" style="cursor: hand;" alt="选择申请部门" width="16" height="16" border="0" onclick="setRoleDomain('IGSYM0101_TREE.do');"/>
						 <html:hidden property="ireqemp"/>&nbsp;&nbsp;						 
						 
   					     <label for="Name">申请人：</label>
                         <html:text property="irequsername"  size="16"  /> 
                         
                          <label>状态：</label>
			             <html:select property="istatus">
			            <html:options collection="invoice_istatus" property="value" name="" labelProperty="label" />
                  
                    	 </html:select>&nbsp;&nbsp; 
                         <br /> 
             
						 <label>发票金额：</label>
			             <html:text property="iamount" size="14" ></html:text>
						 &nbsp;&nbsp;
			          
		                 <label>开票日期：从</label>
		                 <html:text property="idate_from" styleId="rtime_from" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
		                 <img src="images/date.gif" align="middle" onClick="calendar($('idate_from'))" border="0" />&nbsp;&nbsp;
		                 <label> 到</label>
		                 <html:text property="idate_to" styleId="rtime_to" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
	                     <img src="images/date.gif" align="middle" onClick="calendar($('idate_to'))" border="0"/>
			        	 
			        	 <html:submit property="btn_search" value="查询" styleClass="button" onclick="return checkSearch();"/>
		     		</div>
          		</div> 
          		
     <div id="results_list">
	              <ig:message />
	<table class="table_style">
			<tr>
				<th width="10%"><label> <input type="checkbox"
					name="checkbox" id="checkbox" onclick="selectAll('checkbox','iid')"/></label>
				</th>
				<th width="13%">发票类型</th>
				<th width="10%">开票日期</th>
				<th width="10%">发票号码</th>
				<th width="10%">金额</th>
				<th width="20%">申请开票部门</th>
				<th width="8%">状态</th>
				<th width="8%">修改</th>
				
			</tr>
			 <logic:present name="IGLOM04021VO" property="invoiceList" >
			                    <logic:iterate id="bean" name="IGLOM04021VO" property="invoiceList" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                            <td>
				                            <html:checkbox property="iid" value="${bean.iid}"/>
			                            </td>
			                            <!-- 发票工作类型 -->
			                            
			                             <td>
			                                <div class="nowrapDiv">
			                                <ig:cseCodeValue codeIndex="<%=CodeUtils.INVOICE_ITYPE%>" codeValue="${bean.itype}" />
			                                </div>
			                            </td>
			                            
			                            <!-- 开票日期 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="idate">&nbsp;</logic:empty>
			                                ${bean.idate}
			                                </div>
			                            </td>
			                            <!-- 发票号码 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="inum">&nbsp;</logic:empty>
			                                ${bean.inum}
			                                </div>
			                            </td>
			                            <!-- 金额 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="iamount">&nbsp;</logic:empty>
			                                ${bean.iamount}                                 
			                                </div>
			                            </td>
			                            <!-- 申请开票部门-->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="ireqemp">&nbsp;</logic:empty>
			                                ${bean.organizationTB.orgname}                                
			                                </div>
			                            </td>
			                            <!-- 状态 -->
			                            
			                             <td>
			                                <div class="nowrapDiv">
			                                <ig:cseCodeValue codeIndex="<%=CodeUtils.INVOICE_ISTATUS%>" codeValue="${bean.istatus}" />
			                                </div>
			                            </td>
			                            
			                           <td>							
											<div class="nowrapDiv">
											<html:link action="/IGLOM0402_Edit_Disp.do?iid=${bean.iid}">
												<img src="images/edit.gif" width="16" height="16" border="0"/>
											</html:link>	
											</div>		
					              	 </td>
					              	
			                        </tr>
			                    </logic:iterate>
			                </logic:present>
	</table>
	</div>
	<div id="operate">
	<logic:present name="IGLOM04021VO"
		property="invoiceList">
		<span> <html:submit property="btn_delete" value="删除所选"
			styleClass="button" onclick="return deleteRec('iid');" /></span>
	</logic:present> <!-- paging --> <jsp:include page="/include/paging.jsp" />
	</div>

               
			    
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>

</div>

</div>
</body>
</html:html>