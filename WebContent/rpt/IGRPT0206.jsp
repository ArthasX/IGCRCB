<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGRPT0206" toScope="request"/>
<bean:define id="title"  toScope="request">
<bean:message bundle="rptResources" key="ietitle.IGRPT0105b"/>
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">
	function chgdatetype(){
		 //ajax业务运行
		 var id =$("selTemplate").value;
		 if(id!=null&&id!=""){
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
		 function checkForm(obj,flag){//表单验证
				//1为生成，2为删除
		    	var message='<bean:message bundle="rptResources" key="message.IGRPT0107.confirmMsg"/>';
		    	var confirmDel='<bean:message bundle="rptResources" key="message.IGRPT0107.confirmDel"/>';
		    	var confirmCre='<bean:message bundle="rptResources" key="message.IGRPT0107.confirmCre"/>';
		    	var confirmCre2='<bean:message bundle="rptResources" key="message.IGRPT0107.confirmCre2"/>';

		    	if(flag==2){
		    		if(window.confirm(confirmDel)){
		    			form.action = getAppRootUrl() + "/IGRPT0205_RADelete.do?mode=1";
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
		    				form.action = getAppRootUrl() + "/IGRPT0205_Update.do?isDel=0";
		    			}else{
		    				form.action = getAppRootUrl() + "/IGRPT0205_Update.do?isDel=1";
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
				<bean:define id="urlable">
               	<bean:message bundle="rptResources" key="navigation.IGRPT0105.reportManage_Update"/>
				</bean:define>
					<ig:navigation extname1="${urlable}"/>
                </p>
                <div class="back"><html:link href="javascript:toback();"><bean:message bundle="rptResources" key="button.IGRPT0103.btn_toback"/></html:link></div>
            </div>
            
		    <div id="formwrapper">
		         <html:form styleId="form" action="/IGRPT0205_Update">
                      <!--  message -->
                      <ig:message/>
                      <!--  /message -->     
		            <fieldset>
		            <legend>
               		<bean:message bundle="rptResources" key="navigation.IGRPT0105.reportManage_Update"/>
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
								<c:if test="${IGRPT0205Form.selTemplate=='none'}"><option value=""></option></c:if>
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
						 <strong><bean:message bundle="rptResources" key="label.IGRPT0105.addedReport"/></strong>：</label>
						 <table><tr><td>
						 <logic:present name="IGRPT01051VO" property="reportAnnexationList">
							<logic:iterate id="bean" name="IGRPT01051VO"
								property="reportAnnexationList" indexId="index">
									<c:if test="${bean.isUsed=='1'}">
									${bean.raName}　
									</c:if>
							</logic:iterate>
						</logic:present>
						</td></tr></table>
						</div>
						</fieldset>
						<br>
						<fieldset>
			            <legend>
	               		<bean:message bundle="rptResources" key="label.IGRPT0105.haveaddReport"/>
	                	</legend>
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
										<c:if test="${bean.raStatus!='1'}">
										<tr class="<ig:rowcss index="${index}"/>">
										<td>
											<c:if test="${bean.isUsed=='1'}">
											<input type="checkbox" name="anIds" checked="checked" value="${bean.raId}"/>
											</c:if>
											<c:if test="${bean.isUsed!='1'}">
											<input type="checkbox" name="anIds" value="${bean.raId}"/>
											</c:if>
											</td>
											<td>${bean.raName}</td>
											<td>${bean.raSsn}</td>
											<td>${bean.raKpi}</td>
											<td>${bean.raUserName}</td>
											<td>${bean.raCreateDate}</td>
										</tr>
										</c:if>
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
				 <html:hidden property="rmId"/>
		         </html:form>
		         
		    </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>