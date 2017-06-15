<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM3203" toScope="request"/>
<bean:define id="title" value="风险事件处理画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
         var gid='0';
		 function checkForm(){
			 var flag = true;
			 if($F('fcname').trim()==""){
		    		alert("请输入风险事件名称！");
		    		return false;
		    	}
			 
			var objs=document.getElementsByTagName("select");
		  	if(objs[1].value==null||objs[1].value==""){
		  		alert("请选择风险事件来源");
		  		flag=false;
		  		return;
		  	}
			 var ename  = document.getElementById("fcdesc").value;
			 if(ename==""||ename==null){
			   		alert("请输入风险事件描述！");
			   		flag=false;
			   		return;
			   	}
			 if(objs[2].value==null||objs[2].value==""){
			  		alert("请选择风险事件所属领域 ");
			  		flag=false;
			  		return;
			  	}
			
			 var ename  = document.getElementById("fcriskname").value;
			 if(ename==""||ename==null){
			   		alert("请输入风险点名称！");
			   		flag=false;
			   		return;
			   	}
			  	var message = '<bean:message key="IGCO10000.W001" arg0="风险事件基本信息" />';
				if( window.confirm(message)){
					flag=true;				
				} else {
					flag=false;
			  		return;
				}
				if(flag){
					form.action = "IGASM3203.do";
			  		form.submit();
			  		}
			}
		 
		 
		 function selectVersion(eiid){
			 var a = document.getElementById("selecteiversion").value;
			 if(a==0){
				 return false;
			 }
			 var high =	document.getElementById("highVersion").value;
			 window.location.href="IGASM3203_VersionChange.do?eiid="+eiid+"&eiversion="+a+"&highVersion="+high;
		    }
	    function setOrg(url){
		   	 
	    	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	    	if("_resetall"==temp){
				document.getElementById("riskoperatordept").value = "";
				document.getElementById("fcoperatordept").value = "";
				return false;
			}
	    	if(null!=temp && temp.split("|").length>1){
	    		document.getElementById("riskoperatordept").value = temp.split("|")[0];
	    		document.getElementById("fcoperatordept").value = temp.split("|")[1];
	   		}		

	    }
	    
	    function searchuser(){
	    	gid='0';
	    	var obj = $F('riskoperatordept');
			openSubWindow('/IGSYM1905_Disp.do?orgStr='+obj, '_blank','1000','600','center:1');
		}
	    function searchccuser(){
	    	gid='1';
			openSubWindow('/IGSYM1905_Disp.do?', '_blank','1000','600','center:1');
		}
	    function setIGCYB0101Params(username,orgname,orgid,useremail,userphone,usermobile,userid){
	    	if(gid=='0'){
	    		document.getElementById("fcoperator").value = username;
				document.getElementById("riskoperator").value = userid;
	    	}else{
	    		document.getElementById("fcccoperator").value = username;
				document.getElementById("riskccoperator").value = userid;
	    	}
		}
	    
	    function rectification(eiid){
			var url = '/IGCOM0401.do?parprid=&prtype=WD&prpdid=01002&flag=0&ptid=8&parameters='+eiid+'&isServiceStart=C&parameters=${IGASM3202Form.eiid}&pjdtype=3';
			window.showModalDialog(getAppRootUrl() + url,
		            null,"dialogWidth:1080px;dialogHeight:650px;status:no;help:no;resizable:yes");
			location.reload();
	    }
	    function relatedRectification(prid){
	    	var url = '/IGPRR0112_Disp.do?prid='+prid;
			openSubWindow(url, '_blank','1000','600','center:1');
	    }
	    function toBack(){
			form.action = "./IGFXK0000.do";
			form.submit();
		}
	   
	    
	    function setParams(prcorid, prcortype, prcortitle){
	    	document.getElementById("fccheckjob").value = prcortitle;
	    	document.getElementById("riskjobid").value = prcorid;
	    	
	    }
	    
	    function setParams2(eiid,einame,riskitem,poss,levels,grad){
	  
	    	document.getElementById("riskid").value = eiid;
	    	document.getElementById("fcriskname").value = einame;
	    	document.getElementById("fctypename").value = riskitem;
	    	document.getElementById("risktype").value = riskitem;
	    	document.getElementById("fcseveritylevel").value = poss;
	    	document.getElementById("fcpossibility").value = levels;
	    	document.getElementById("fclevel").value = grad;
	    	
	    }
	    function setOrg2(url){
	    	openSubWindow('/IGSVC0107_Disp.do?prpdid=01001', '_blank','1000','600','center:1');	
	    	
	    }
	    function setOrg3(url){
	    	var a = document.getElementById("riskjobid").value
	    	if(a==null || a==0){
	    		a=0;
	    	}
	    	openSubWindow('/IGWKM0104.do?prid='+a+'&jump=78', '_blank','1000','600','center:1');
	    }
	    
	    
	WebCalendar.timeShow   = true;          //是否返回时间
	</script>
<style>
input {
width:254px;
margin-left:1px;
border:1px solid #ccc;
height:20px;
}

select {
width:255px;
margin-left:1px;
border:1px solid #ccc;
height:20px;
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
                <p class="fonts1"><ig:navigation extname1="风险事件处理"/></p>
                <div class="back">
                	<a href="IGASM3201_Back.do">返回</a>
                </div>
            </div>
            
		    <div id="formwrapper">
		         <html:form styleId="form" action="/IGASM3203">
                      <!--  message -->
                      <ig:message/>
                      <!--  /message -->     
		            <fieldset>
	                    <legend>风险事件基本信息</legend>
	                    <table  width="860px" style="margin-left:60px;margin-top:20px;">
	                    	<tr>
				            	<td align="right" width="160px" style="background-color: #EEEEEE; "><strong>风险事件版本：</strong></td>
				            	<td align="left" width="254px"> 
				            		<html:select property="selecteiversion" onchange="selectVersion(${IGASM3202Form.eiid});" style="border:1px solid #CCCCCC;">
				            			<option value="0">当前版本&nbsp&nbsp第&nbsp&nbsp ${IGASM3202Form.eiversion} &nbsp&nbsp版 </option>
									 <logic:present name="IGASM3202Form" property="checkVersionMap" >
						               <logic:iterate id="versionMap" name="IGASM3202Form" property="checkVersionMap" indexId="index">
										<option value="${versionMap.value}">版本选择&nbsp&nbsp第&nbsp&nbsp ${versionMap.value} &nbsp&nbsp版</option>
									   </logic:iterate>
									  </logic:present>
									</html:select>
				            	</td>
				            	<td align="right" width="16px"/>
				            	<td align="right" width="160px"/>
				            	<td align="left" width="254px"/>
								<td align="right" width="16px"/>
			            	</tr>
			            	<tr>
				            	<td align="right" width="160px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>风险事件名称：</strong></td>
				            	<td align="left" width="254px"> <html:text property="fcname" tabindex="1"/></td>
				            	<td align="right" width="16px"/>
				            	<td align="right" width="160px" style="background-color: #EEEEEE; "><span class="red">*&nbsp&nbsp</span><strong>风险事件来源：</strong></td>
				            	<td align="left" width="254px"> 
									<html:select property="fcorigin"  tabindex="2" style="width: 254px;" errorStyleClass="inputError">
										<ig:optionsCollection ccid="RISK_CASE_ORIGIN" isCodeLabel="true"/>
									</html:select>
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
				            		<html:text property="fccheckjob" tabindex="4"  readonly="true"/>
				            		<input width="0px" type="hidden" name="riskjobid" id="riskjobid" value="${IGASM3202Form.riskjobid}"/>
				            	</td>
				            	<td align="right" width="16px"><img src="images/seek.gif" style="cursor: hand;" alt="选择评估工作" width="16" height="16" border="0" onclick="setOrg2()"/></td>
				            	<td align="right" width="160px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>风险事件所属领域：</strong></td>
				            	<td align="left" width="254px"> 
									<html:select property="fccategory"  tabindex="5" style="width: 254px;" errorStyleClass="inputError">
										<ig:optionsCollection ccid="RISK_CASE_CATEGORY" isCodeLabel="true"/>
									</html:select>
								</td>
								<td align="right" width="16px"/>
			            	</tr>
			            	<tr>
				            	<td align="right" width="160px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>风险点名称：</strong></td>
				            	<td align="left" width="254px"> 
				            		<html:text property="fcriskname" readonly="true" tabindex="5" />
									<input width="0px" type="hidden" name="riskid" id="riskid" value="${IGASM3202Form.riskid}" />
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
				            	<td align="right" width="160px" style="background-color: #EEEEEE; "><strong>风险识别时间：</strong></td>
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
									<html:select property="fcpolicy"  tabindex="12" style="width: 254px;" errorStyleClass="inputError">
										<ig:optionsCollection ccid="RISK_POLICY" isCodeLabel="true"/>
									</html:select>
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
			            	
			            	<tr>
			            		
				            	<td align="right" width="160px" style="background-color: #EEEEEE; "><strong>状态：</strong></td>
				            	<td align="left" width="254px"> 
				            		<html:select property="eistatus"  tabindex="12" style="width: 254px;" errorStyleClass="inputError">
										<ig:optionsCollection ccid="RISK_STATUS" isCodeLabel="true"/>
									</html:select>
				            	</td>
				            	<td align="right" width="16px"></td>
				            	<td align="right" width="160px" style="background-color: #EEEEEE; "><strong>评审结果：</strong></td>
				            	<td align="left" width="254px"> 
									<html:select property="riskreviewresult"  tabindex="12" style="width: 254px;" errorStyleClass="inputError">
										<ig:optionsCollection ccid="RISK_REVIEW_RESULT" isCodeLabel="true"/>
									</html:select>
								</td>
								<td align="right" width="16px"/>
			            	</tr>
			            	
			            	<tr>
			            		<c:if test="${IGASM3202Form.riskdealid ==''|| IGASM3202Form.riskdealid ==null}">
				            	<td align="right" width="160px" style="background-color: #EEEEEE; "><strong>发起问题整改：</strong></td>
								<td align="left"><a href="###" onclick="rectification(${IGASM3202Form.eiid});">发起相关问题整改</a>
								</td>
								</c:if>
								<c:if test="${IGASM3202Form.riskdealid !=''&& IGASM3202Form.riskdealid !=null }">
								<td align="right" width="160px" style="background-color: #EEEEEE; "><strong>相关问题整改：</strong></td>
								<td align="left"><a href="###" onclick="relatedRectification(${IGASM3202Form.riskdealid});">查看相关问题整改</a>
								</td>
								</c:if>
			            	</tr>
			            </table>
		            </fieldset>
		            <div class="enter">
		                <html:button property="btn_insert" value="提交" styleClass="button"  onclick="checkForm();"  />
		            </div>
		            
		             <html:hidden property="esyscoding"/>
		             <html:hidden property="eiorgsyscoding"/>
		             <html:hidden property="eistatus"/>
		             <html:hidden property="eiid"/>
			         <html:hidden property="eid"/>
			         <html:hidden property="highVersion" value="${highVersion}"/>
			        
		         </html:form>
		    </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>