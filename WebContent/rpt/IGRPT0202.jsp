<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGRPT0202" toScope="request"/>
<bean:define id="title"  toScope="request">
<bean:message bundle="rptResources" key="ietitle.IGRPT0103"/>
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<style>
	select{
		width:150px;
	}
</style>
	<script type="text/javascript">
		 function checkForm(){
		        var alertName = '<bean:message bundle="rptResources" key="message.IGRPT0103.001"/>';
		        var alertSum = '<bean:message bundle="rptResources" key="message.IGRPT0103.002"/>';
		        var alertDateType = '<bean:message bundle="rptResources" key="message.IGRPT0103.003"/>';
		        var alertWenjian = '<bean:message bundle="rptResources" key="message.IGRPT0103.004"/>';
		        var alertSum999 = '<bean:message bundle="rptResources" key="message.IGRPT0103.005"/>';
		        var alertSumNAN = '<bean:message bundle="rptResources" key="message.IGRPT0103.006"/>';
		        var alertNameLen = '<bean:message bundle="rptResources" key="message.IGRPT0103.007"/>';
		        //var alertSum0 = '<bean:message bundle="rptResources" key="message.IGRPT0103.009"/>';
		        var alertSumER = '<bean:message bundle="rptResources" key="message.IGRPT0103.010"/>';

			    //判断kpi 是否为null
			    var alertKPInull= '<bean:message bundle="rptResources" key="message.IGRPT0103.014"/>';
	    		var tag=document.getElementsByTagName("input");
	  			for(var i=0;i<tag.length;i++){
	  				if(tag[i].type=='checkbox' && tag[i].name=='mapid'){
	  					if(tag[i].checked==true) {
		  					if($('kpiSelect'+tag[i].value).value == ""){
		  					alert(alertKPInull);
					    	return false;
			  				}
	  					}
	  				}
	  			}

		}
	    function toback(){//返回
	        location.href = getAppRootUrl() + "/IGRPT0201_ToBack.do";
	    }

		function chgevent(id){//选存储id触发
			var ssn=$(id).value;
			var kpiType=$(ssn+"").value;
			var num=String(id).split("ssnSelect");
			var flag=num[1];
			var kpiid="kpi"+String(flag);
			
			if(kpiType== '001001'){
				$(kpiid).innerHTML="<select name='real_kpi_list' id='kpiSelect"+flag+"'>"+$('dmx_select_list1').innerHTML+"</select>";
			}else if(kpiType== '001002'){
				$(kpiid).innerHTML="<select name='real_kpi_list' id='kpiSelect"+flag+"'>"+$('ibm_select_list1').innerHTML+"</select>";
			}else if( kpiType== '001003'){
				$(kpiid).innerHTML="<select name='real_kpi_list' id='kpiSelect"+flag+"'>"+$('cx_select_list1').innerHTML+"</select>";
			}
			$('rtmSsnType'+flag).value=kpiType;
		
		}
	</script>
<body >
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
                <bean:message bundle='rptResources' key='navigation.IGRPT0107.statisticsAnalyse' /> &gt;&gt; 
				<bean:message bundle='rptResources' key='navigation.IGRPT0107.autoReport' />&gt;&gt;
               	<bean:message bundle="rptResources" key="navigation.IGRPT0103.reportTemplate"/>&gt;&gt;
				<bean:message bundle="rptResources" key="navigation.IGRPT0103.reportTemplateMapping" />
                </p>
                <div class="back"><html:link href="javascript:toback();"><bean:message bundle="rptResources" key="button.IGRPT0103.btn_toback"/></html:link></div>
            </div>
            
		    <div id="formwrapper">
		         <html:form styleId="form" action="/IGRPT0202_MappingInsert" onsubmit="return checkForm();">
                      <!--  message -->
                      <ig:message/>
                      <!--  /message -->     
		            <fieldset>
			            <legend><bean:message bundle="rptResources" key="navigation.IGRPT0103.reportTemplateMapping"/></legend>
                    <div align="center" id="mappingDiv" style="overflow-y: auto;margin-left: 25px;">
                    <table  style="width: 85%"  class="table_style" id="synctable" >
	            <!-- header部 -->
	                <tr class="<ig:rowcss index="${index}"/>">
	                	<th width="2%"><input id="ckall" type="checkbox" onclick="selectAll('ckall','mapid')"></th>
	                	<th width="20%"><bean:message bundle="rptResources" key="label.IGRPT0103.rtNum"/></th>
                        <th width="18%"><bean:message bundle="rptResources" key="label.IGRPT0103.rtSumLabel"/></th>
                        <th width="20%"><bean:message bundle="rptResources" key="label.IGRPT0103.SSN"/></th>
                        <th width="20%"><bean:message bundle="rptResources" key="label.IGRPT0103.KPI"/></th>
	                </tr>
	            <!-- body部 -->
	            
	            	<tr style="display:none;">
	            	<td id="dmx_select_list">
	            	<html:select property='dmx_select_list1'>
	            	<html:optionsCollection name="ADDMX_KPI_List" label="syscoding" value="syscoding"/>
	            	</html:select>
	            	</td>
	            	<td id="ibm_select_list">
	            	<html:select property='ibm_select_list1'>
	            	<html:optionsCollection name="ADIBM_KPI_List" label="syscoding" value="syscoding"/>
	            	</html:select>
	            	</td>
	            	<td id="cx_select_list">
	            	<html:select property='cx_select_list1'>
	            	<html:optionsCollection name="ADCX_KPI_List" label="syscoding" value="syscoding"/>
	            	</html:select>
	            	</td>
	            	</tr>
	            		<logic:present name="IGRPT02011VO" property="reportTemplateMappingList">
	            			<logic:iterate id="bean" name="IGRPT02011VO" property="reportTemplateMappingList" indexId="index">
	            			<tr>
	            			<td>
	            			<c:if test="${bean.rtmUsed=='1'}">
	            			<input type="checkbox" checked="checked" name="mapid" value="${bean.rtNumber}"/>
	            			</c:if>
	            			<c:if test="${bean.rtmUsed!='1'}">
	            			<input type="checkbox" name="mapid" value="${bean.rtNumber}"/>
	            			</c:if>
	            			</td>
	            			<td>
	            			${bean.rtNumber}
	            			</td>
	            			<td>
	            			${bean.rtmFlag}
	            			</td>
	            			<td>
	           				<!-- ssn -->
	           				<select name="ssn_select_list1" id="ssnSelect${bean.rtNumber}" onchange="chgevent(id)" >
	           				<c:forEach items="${ADmonitorObjectList}" var="ssnops">
	           				<c:if test="${bean.rtmSsn == ssnops.moName}">
	           					<option selected="selected" value="${ssnops.moName}" >${ssnops.moName}</option>
	           				</c:if>
	           				<c:if test="${bean.rtmSsn != ssnops.moName}">
	           					<option value="${ssnops.moName}" >${ssnops.moName}</option>
	           				</c:if>
	           				</c:forEach>
	           				</select>
	           				
	           				<c:if test="${bean.rtmSsnType == ''||bean.rtmSsnType==null}">
	           				<input type="hidden" name="ssn_type_list" id="rtmSsnType${bean.rtNumber}" value="${IGRPT0203Form.syscoding}" />
	           				</c:if>
	           				<c:if test="${bean.rtmSsnType != ''&&bean.rtmSsnType!=null}">
	           				<input type="hidden" name="ssn_type_list" id="rtmSsnType${bean.rtNumber}" value="${bean.rtmSsnType}" />
	           				</c:if>
	            			</td>
	            			<!-- kpi -->
	            			<c:if test="${bean.rtmSsnType!=null}">
	            			<td id="kpi${bean.rtNumber}">
							<select name="real_kpi_list" id="kpiSelect${bean.rtNumber}" >
							<c:if test="${bean.rtmSsnType== '001001'}">
							<c:forEach items="${ADDMX_KPI_List}" var="dmxkpi">
	           				<c:if test="${bean.rtmKpi == dmxkpi.syscoding}">
	           				<option selected="selected" value="${dmxkpi.syscoding}">${dmxkpi.syscoding}</option>
	           				</c:if>
	           				<c:if test="${bean.rtmKpi != dmxkpi.syscoding}">
	           				<option value="${dmxkpi.syscoding}">${dmxkpi.syscoding}</option>
	           				</c:if>
	           				</c:forEach>
							</c:if>
							<c:if test="${bean.rtmSsnType== '001002'}">
							<c:forEach items="${ADIBM_KPI_List}" var="ibmkpi">
							<c:if test="${bean.rtmKpi == ibmkpi.syscoding}">
	           				<option selected="selected" value="${ibmkpi.syscoding}">${ibmkpi.syscoding}</option>
							</c:if>
							<c:if test="${bean.rtmKpi != ibmkpi.syscoding}">
	           				<option value="${ibmkpi.syscoding}">${ibmkpi.syscoding}</option>
							</c:if>
	           				</c:forEach>
							</c:if>
							<c:if test="${bean.rtmSsnType== '001003'}">
							<c:forEach items="${ADCX_KPI_List}" var="cxkpi">
	           				<c:if test="${bean.rtmKpi == cxkpi.syscoding}">
	           				<option selected="selected" value="${cxkpi.syscoding}">${cxkpi.syscoding}</option>
	           				</c:if>
	           				<c:if test="${bean.rtmKpi != cxkpi.syscoding}">
	           				<option value="${cxkpi.syscoding}">${cxkpi.syscoding}</option>
	           				</c:if>
	           				</c:forEach>
							</c:if>
							</select>
	            			</td>
	            			</c:if>
	            			<c:if test="${bean.rtmSsnType==null}">
	            			<td id="kpi${index+1}">
							<select name="real_kpi_list" id="kpiSelect${index+1}">
							<c:if test="${IGRPT0203Form.syscoding== '001001'}">
							<c:forEach items="${ADDMX_KPI_List}" var="dmxkpi">
	           				<option value="${dmxkpi.syscoding}">${dmxkpi.syscoding}</option>
	           				</c:forEach>
							</c:if>
							<c:if test="${IGRPT0203Form.syscoding== '001002'}">
							<c:forEach items="${ADIBM_KPI_List}" var="ibmkpi">
	           				<option value="${ibmkpi.syscoding}">${ibmkpi.syscoding}</option>
	           				</c:forEach>
							</c:if>
							<c:if test="${IGRPT0203Form.syscoding== '001003'}">
							<c:forEach items="${ADCX_KPI_List}" var="cxkpi">
	           				<option  value="${cxkpi.syscoding}">${cxkpi.syscoding}</option>
	           				</c:forEach>
							</c:if>
							</select>
	            			</td>
	            			</c:if>
	            			</tr>
	            			</logic:iterate>
	            		</logic:present>
	       			</table>
	       			<logic:present name="ADmonitorObjectList">
	       			<logic:iterate id="ssnobj" name="ADmonitorObjectList">
	       			<input type="hidden" id="${ssnobj.moName}" value="${ssnobj.mtSyscoding}"/>
	       			</logic:iterate>
	       			</logic:present>
	       			</div>
		            </fieldset>
		            <div class="enter">
		                <html:submit property="btn_insert" styleClass="button" >
		                	<bean:message bundle="rptResources" key="button.IGRPT0103.btn_commit"/>
		                </html:submit>
		            </div>
				<html:hidden property="rtId" value="${IGRPT0203Form.rtId}"/>
		         </html:form>
		         
		    </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>