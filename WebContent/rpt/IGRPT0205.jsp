<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGRPT0205" toScope="request"/>
<bean:define id="title"  toScope="request">
<c:if test="${IGRPT0205Form.mode == 0}"><bean:message bundle="rptResources" key="ietitle.IGRPT0105a"/></c:if>
<c:if test="${IGRPT0205Form.mode == 1}"><bean:message bundle="rptResources" key="ietitle.IGRPT0105b"/></c:if>
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">
	function chgdatetype(){
		 //ajax业务运行
		 var id =$("selTemplate").value;
		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: 'type=getTemDateType&rtId='+id,
				 onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						$("dateType").value=result;
						setDateType();
					}else{
						return "";	
					}
			    }
			});
	}
		
		 function load_yearAndTypes(){//获取近5年 
			 $('selYears').options.length=0;
			 var y_date=new Date().getFullYear();
			 var yest_date="";
			 for ( var i = 0; i < 5; i++) {  // 5-1/2=x ; i==x ; y_date-x+i
				 if(i==2){
					 yest_date=y_date;
			     }else{
			    	 yest_date=y_date-2+i;
				 }
				 $('selYears').options.add(new Option(yest_date,yest_date));
				 if(i==2){
					 $('selYears').options[i].selected = true;
				 }
			 }
			 setDateType();
		 }
		 function setDateType(){
			 //设置默认显示
			$("yearDiv").style.display="none";
			$("quarterDiv").style.display="none";
			$("monthDiv").style.display="none";
			var dateType= $("dateType").value;
			if(dateType!=null){
				if(dateType=='0'){
					$("yearDiv").style.display="";
					$("monthDiv").style.display="";
				}else if(dateType=='1'){
					$("yearDiv").style.display="";
					$("quarterDiv").style.display="";
				}else if(dateType=='2'){
					$("yearDiv").style.display="";
				}
			}

		}
		 function isUpdate(){//判断是更新还是新增
			 if($('mode').value==1){
				 form.action = getAppRootUrl() + "/IGRPT0205_Update.do";
				 if(checkForm()){
					 form.submit;
					 return true;
				 }else{
					 return false;
				 }
			 }
		 }
		 function checkForm(obj,flag){//表单验证

				//1为生成，2为删除
		    	var message='<bean:message bundle="rptResources" key="message.IGRPT0107.confirmMsg"/>';
		    	var confirmDel='<bean:message bundle="rptResources" key="message.IGRPT0107.confirmDel"/>';
		    	var confirmCre='<bean:message bundle="rptResources" key="message.IGRPT0107.confirmCre"/>';
		    	var confirmCre2='<bean:message bundle="rptResources" key="message.IGRPT0107.confirmCre2"/>';

		    	if(flag==2){
		    		if(window.confirm(confirmDel)){
		    			form.action = getAppRootUrl() + "/IGRPT0205_RADelete.do";
		    			return true;
		    		}else{
		    			return false;
		    		}
		    	}else {
		    			 var alertName = '<bean:message bundle="rptResources" key="message.IGRPT0105.001"/>';
				        var alertNameLen = '<bean:message bundle="rptResources" key="message.IGRPT0105.002"/>';
				        var alertselTemplate = '<bean:message bundle="rptResources" key="message.IGRPT0105.003"/>';
				        var rtNameFont = '<bean:message bundle="rptResources" key="message.IGRPT0103.016"/>';
						if($F('rmName').trim()==""){
				    		alert(alertName);
				    		return false;
				    	}
				    	if($F('rmName').strlen()>128){
				  			alert("alertNameLen"+Math.floor(128/strByteFlag)+rtNameFont);
				  			return false;
				  		}
					 	var messageAlert='<bean:message bundle="rptResources" key="message.IGRPT0105.004"/>';
						var reg = /^(\w|[\u4E00-\u9FA5])*$/;
						if(!$F('rmName').match(reg)){
							alert(messageAlert);
							return false;
						}
				    	if($('selTemplate').value.trim()==""){
				    	alert(alertselTemplate); 
				    	return false;
					    }
		    		if(window.confirm(confirmCre)){
		    			//0为删除附加 1为不删除
		    			if(window.confirm(confirmCre2)){
		    				form.action = getAppRootUrl() + "/IGRPT0205_Insert.do?isDel=0";
		    			}else{
		    				form.action = getAppRootUrl() + "/IGRPT0205_Insert.do?isDel=1";
		    			}
		    			return true;
		    		}else{
		    			return false;
		    		}
		    	}
		}
	    function toback(){//返回
	        location.href = getAppRootUrl() + "/IGRPT0204_ToBack.do";
	    }

	</script>
<body onload="load_yearAndTypes()">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
            <div id="location">
                <div class="image"></div>
                <p class="fonts1">
                <bean:message
				bundle='rptResources' key='navigation.IGRPT0107.statisticsAnalyse' /> &gt;&gt; <bean:message
				bundle='rptResources' key='navigation.IGRPT0107.autoReport' />&gt;&gt;
				<bean:message bundle="rptResources" key="ietitle.IGRPT0104" />&gt;&gt;
               	<c:if test="${IGRPT0205Form.mode == 0}"><bean:message bundle="rptResources" key="navigation.IGRPT0105.reportManage"/></c:if>
               	<c:if test="${IGRPT0205Form.mode == 1}"><bean:message bundle="rptResources" key="navigation.IGRPT0105.reportManage_Update"/></c:if>
                </p>
                <div class="back"><html:link href="javascript:toback();"><bean:message bundle="rptResources" key="button.IGRPT0103.btn_toback"/></html:link></div>
            </div>
            
		    <div id="formwrapper">
		         <html:form styleId="form" action="/IGRPT0205_Insert">
                      <!--  message -->
                      <ig:message/>
                      <!--  /message -->     
		            <fieldset>
		            <legend>
		        	<c:if test="${IGRPT0205Form.mode == 0}"><bean:message bundle="rptResources" key="navigation.IGRPT0105.reportManage"/></c:if>
               		<c:if test="${IGRPT0205Form.mode == 1}"><bean:message bundle="rptResources" key="navigation.IGRPT0105.reportManage_Update"/></c:if>
                	</legend>
                        <div>
                        <html:hidden property="rmId"/>
                            <label for="Name"><strong><span class="red">*</span><bean:message bundle="rptResources" key="label.IGRPT0105.rmName"/></strong>：</label>
                            <html:text property="rmName" styleId="rmName" tabindex="5" errorStyleClass="inputError imeActive" />
							<br/>
                        </div>
                        <div>
                            <label for="Name"><strong><span class="red">*</span><bean:message bundle="rptResources" key="label.IGRPT0105.selectTemplate"/></strong>：</label>
							<html:select property="selTemplate"  style="width:200px" onchange="chgdatetype()"  >
								<html:optionsCollection name="reportTemplateList"  value="rtId" label="rtName"/>
							</html:select>
							<!-- x
							<select id="selTemplate" name="selTemplate" style="width:200px" onchange="chgdatetype()" >
							<logic:present name="IGRPT01051VO" property="reportTemplateList">
	            			<logic:iterate id="bean" name="IGRPT01051VO" property="reportTemplateList" indexId="index">
	            			<option value="${bean.rtId }" label="${bean.rtName }"/>
	            			</logic:iterate>
	            			</logic:present>
							</select>
							-->
                            <br>
                        </div>
                        <div id="yearDiv"><label for="Name">
                        <strong><span class="red">*</span><bean:message bundle="rptResources" key="label.IGRPT0105.selRmYear"/></strong>：</label>
							<select id="selYears" name="selRmYear" style="width:100px">
							</select>
						</div>
						<div id="quarterDiv"><label for="Name">
						 <strong><span class="red">*</span><bean:message bundle="rptResources" key="label.IGRPT0105.selRmQuarter"/></strong>：</label>
							<html:select property="selRmQuarter" style="width:100px">
								<ig:optionsCollection ccid="REPORT_DATETYPEQ_CODE" isMakeBlankRow="false" isCodeLabel="true"/>
							</html:select>
						</div>
						<div id="monthDiv"><label for="Name">
						 <strong><span class="red">*</span><bean:message bundle="rptResources" key="label.IGRPT0105.selRmMonth"/></strong>：</label>
							
							<html:select property="selRmMonth" style="width:100px">
								<ig:optionsCollection ccid="MONTH_CODE" isMakeBlankRow="false" isCodeLabel="true"/>
							</html:select>
							<br/>
						</div>
						<div id="monthDiv"><label for="Name">
						 <strong><bean:message bundle="rptResources" key="label.IGRPT0105.addReport"/> </strong>：</label>
							<br/>
						</div>
						<div id="results_list" style="overflow-y: auto; ">
							<table class="table_style" style="width:95%;">
								<!-- header部 -->
								<tr>
									<th width="4%"><input id="isSel" type="checkbox" onclick="selectAll('isSel','anIds')" /></th>
									<th width="10%"><bean:message bundle='rptResources' key='label.IGRPT0107.additionReportName' /></th>
									<th width="10%"><bean:message bundle='rptResources' key='label.IGRPT0107.ssne' /></th>
									<th width="8%"><bean:message bundle='rptResources' key='label.IGRPT0107.kpi' /></th>
									<th width="10%"><bean:message bundle='rptResources' key='label.IGRPT0107.userName' /></th>
									<th width="10%"><bean:message bundle='rptResources' key='label.IGRPT0107.createDate' /></th>
								</tr>
								<!-- body部 -->
								<logic:present name="IGRPT02051VO" property="reportAnnexationList">
									<logic:iterate id="bean" name="IGRPT02051VO"
										property="reportAnnexationList" indexId="index">
										<tr class="<ig:rowcss index="${index}"/>">
											<td><html:checkbox property="anIds" value="${bean.raId}" /></td>
											<td>${bean.raName}</td>
											<td>${bean.raSsn}</td>
											<td>${bean.raKpi}</td>
											<td>${bean.raUserName}</td>
											<td>${bean.raCreateDate}</td>
										</tr>
									</logic:iterate>
								</logic:present>
							</table>
							</div>
		            </fieldset>
		            <div class="enter">
						 <html:submit property="btn_delete" style="height:20px;" styleClass="button" 
							onclick="return checkForm('anIds',2);">
							<bean:message bundle="rptResources" key="button.IGRPT0101.btn_delete" />
						</html:submit>
		                <html:submit property="btn_insert" styleClass="button" onclick="return checkForm('anIds',1);">
		                	<bean:message bundle="rptResources" key="button.IGRPT0103.btn_commit"/>
		                </html:submit>
		            </div>
		         <div id="datetypeused" style="display:none;">
				 </div>
				 <html:hidden property="dateType" value="${IGRPT02051VO.rtDateType}"/>
				 <html:hidden property="mode"/>
		         </html:form>
		         
		    </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>