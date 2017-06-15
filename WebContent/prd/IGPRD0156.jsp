<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>
<html:html>
<bean:define id="id" value="IGPRD0156" toScope="request" />
<bean:define id="title" value="按钮事件处理" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	


	function toback(pdid,psdid,psdcode) {
		form.action = getAppRootUrl() + "/IGPRD0141_List.do?ppsdid=${IGPRD0141Form.ppsdid}&pdid=" + pdid+"&psdid=" + psdid +"&psdcode="+psdcode;
		form.submit();
	}
	function isdigit(s)
	{
	var r,re;
	re = /\d*/i; //\d表示数字,*表示匹配多个数字
	r = s.match(re);
	return (r==s)?1:0;
	}
	function checkForm() {
		if ($F('psebuttonid').trim() == "") {
            alert("请选择按钮名称！");
            return false;
        }   
		if ($F('pseactionid').trim() == "") {
			alert("请输入自定义BL名称！");
			return false;
		}	
		if ($F('pseactionid').strlen() > 32) {
			alert("自定义BL不能大于32个字符！");
			return false;
		}		
		if ($F('psedec').strlen() > 256) {
			alert("流程描述不能大于256个字符！");
			return false;
		}
		else {
			var message = "";
			if(document.getElementById("mode").value=="0"){
				message = '确定要添加按钮事件基本信息吗?';
			}else{
				message = '确定要修改按钮事件基本信息吗?';
			}
			if (window.confirm(message)) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	function setPsbdname(selectObj){
		var index = selectObj.options.selectedIndex;
		var text = selectObj[index].text;
		document.getElementById("psbdname").value = text;
	}

</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
  <div id="container"><!--content  右侧内容-->
    <div id="contentWrap">
       <div id="content">
          <div id="location">
               <div class="image"></div>
               <logic:equal name="form" property="mode" value="0">
		           <p class="fonts1">系统管理 &gt;&gt; 流程定义 &gt;&gt; 流程管理 &gt;&gt; 状态列表 &gt;&gt; 按钮事件配置 &gt;&gt; 按钮事件定义</p>
	           </logic:equal> 
	           <logic:equal name="form" property="mode" value="1">
		            <p class="fonts1">系统管理 &gt;&gt; 流程定义 &gt;&gt; 流程管理 &gt;&gt; 状态列表 &gt;&gt; 按钮事件配置 &gt;&gt; 按钮事件修改</p>
	           </logic:equal> 
               <div class="back">
               <html:link href="javascript:toback('${pdid}','${psdid}','${psdcode}');">返回</html:link>
	           </div>
          </div>
            <div id="formwrapper"> 
		           <html:form styleId="form" action="/IGPRD0141_Insert"> 
	           <!--  message -->
	           <ig:message />
	           <!--  /message -->     
	           <fieldset>         
	                  <logic:equal name="form" property="mode" value="0">
	                   <legend>按钮事件定义</legend>
	                   </logic:equal>
	                   <logic:equal name="form" property="mode" value="1">
	                   <legend>按钮事件修改</legend>
	                   </logic:equal>
	                 <div><label for="Name"><strong><span class="red">*</span>按钮名称</strong>：</label>
							<html:select property="psebuttonid" styleId="psebuttonid" onchange="setPsbdname(this)" >
								<logic:equal name="form" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_START_STATUS %>">
								    <html:option value=""></html:option>
									<logic:iterate id="buttonDef" name="IGPRD0141VO" property="processButtonDefList">
										<logic:equal name="buttonDef" property="value" value="<%=IGPRDCONSTANTS.BUTTON_SUBMIT %>">
											<html:option value="${buttonDef.value}">${buttonDef.label}</html:option>
										</logic:equal>
									</logic:iterate>
								</logic:equal>
								<logic:notEqual name="form" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_START_STATUS %>">
								    <logic:iterate id="buttonDef" name="IGPRD0141VO" property="processButtonDefList">
                                               <html:option value="${buttonDef.value}">${buttonDef.label}</html:option>
                                       </logic:iterate>
								</logic:notEqual>
							</html:select> <br>
					</div>  
	                 <div><label for="Name"><strong><span class="red">*</span>自定义BL名称</strong>：</label>
	             			<html:text property="pseactionid" styleId="pseactionid" size="32"
								style="width:200px;" errorStyleClass="inputError" tabindex="1" /> <br>
					 </div>
					<div><label for="Name"><strong><span class="red">*</span>处理顺序</strong>：</label>
					        <html:select property="pseorder" styleId="pseorder">							        
									<html:option value="1">1</html:option>
									<html:option value="2">2</html:option>
									<html:option value="3">3</html:option>
									<html:option value="4">4</html:option>
									<html:option value="5">5</html:option>
									<html:option value="6">6</html:option>
									<html:option value="7">7</html:option>
									<html:option value="9">8</html:option>
									<html:option value="9">9</html:option>
									<html:option value="10">10</html:option>
									<html:option value="11">11</html:option>
									<html:option value="12">12</html:option>
									<html:option value="13">13</html:option>
									<html:option value="14">14</html:option>
									<html:option value="15">15</html:option>
									<html:option value="16">16</html:option>
									<html:option value="17">17</html:option>
									<html:option value="18">18</html:option>
									<html:option value="19">19</html:option>
									<html:option value="20">20</html:option>
							</html:select> <br>							
					</div>
					<div><label for="Name"><strong>任务描述</strong>：</label>
							<html:textarea  property="psedec" styleId="psedec" cols="60" rows="6" errorStyleClass="inputError imeActive"  tabindex="4"/>
							<br>
					</div>
				       </fieldset>
					          <div class="enter">
				                    <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return checkForm();"  />
				              </div>
					    												
							     <html:hidden name="form" property="pseid"/>				        
							     <html:hidden name="form" property="mode" styleId="mode"/>
							     <html:hidden name="form" property="pdid"/>				        
							     <html:hidden name="form" property="psdid"/>
							     <html:hidden name="form" property="psdcode"/>
							     <html:hidden name="form" property="psbdname"/>
							     <html:hidden name="form" property="ppsdid"/>
		             </html:form></div>		
 			</div>  				          
       </div>
    </div>
   </div>
   
</body>
</html:html>
