<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCIM0144" toScope="request" />
<bean:define id="title"  toScope="request">
	<bean:message bundle="asmResources" key="ietitle.IGASM0344"/>
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">

	function toClose() {
		window.close();
	}

	function checkboxSubmit(){
		var alterVersion= '<bean:message bundle="asmResources" key="message.IGASM0344.001"/>';
		var alterHistoryVersion= '<bean:message bundle="asmResources" key="message.IGASM0344.002"/>';
		count = checkNumber();
    	if(count==0){
    		alert(alterVersion);
            return;
    	}else if(count!=2){
    		alert(alterHistoryVersion);
            return;
    	}
    	var url = "/IGASM0345_Disp.do?eiid="+<%=request.getParameter("eiid")%>+"&pre="+pre+"&next="+next;
    	openSubWindow(url, '_blank', '800', '600');
	}

	function checkNumber(){
		var count=0;
		var checkbox = document.getElementsByName("checkbox");
		
		for(var i=0;i<checkbox.length;i++){
			if(checkbox[i].checked==true){
				count++;
			}
		}
		if(count==2){
			var num=0;
			for(i=0;i<checkbox.length;i++){
				if(checkbox[i].checked==true){
					if(num==0){
						pre=checkbox[i].value;
						num++;
					}else if(num==1){
						next=checkbox[i].value;
						break;
					}
				}
			}
		}
		return count;
	}
	
</script>
<body style="background-image: none;background-color: #FFFFFF;">

<div class="title">
<div class="name"><bean:message bundle="asmResources" key="label.IGASM0344.HistoryVersionInfo"/></div>
</div>

<div class="message"><ig:message /></div>
 <div id="results_list">
    <table width="100%" class="table_style" >
      <!-- header部 -->
		 <tr>
		 	<th width="10%"></th>
			<th width="45%"><bean:message bundle="asmResources" key="label.IGASM0344.VersionNo"/></th>
			<th width="45%"><bean:message bundle="asmResources" key="label.IGASM0344.ModifyTime"/></th>
		 </tr>
		 <logic:present name="IGCIM01051VO" property="configItemVersionTime">
			<logic:iterate id="bean" name="IGCIM01051VO" property="configItemVersionTime"
				indexId="index">
				<tr>
					<td>
						<input name="checkbox" type="checkbox" value="${bean.civersion}<c:if test="${IGCIM01051VO.entityData.emodeltype == '1'}">_${bean.cismallversion}</c:if>" />
					</td>
		       		<td>
				       ${bean.civersion}<c:if test="${IGCIM01051VO.entityData.emodeltype == '1'}">.${bean.cismallversion}</c:if><bean:message bundle="asmResources" key="label.IGASM0344.Version"/>
		       		</td>
		       		<td>
		          		${bean.ciupdtime}
		       		</td>
		       </tr>
			</logic:iterate>
		</logic:present>
     </table>
 </div>
 
<div class="enter">
	<input onclick="checkboxSubmit();" type="button"  class="button" value='<bean:message bundle="asmResources" key="button.IGASM0344.btn_compare"/>'>
	<input onclick="toClose();" type="button"  class="button" value='<bean:message bundle="asmResources" key="button.IGASM0344.btn_close"/>'>
</div>

</body>
</html:html>