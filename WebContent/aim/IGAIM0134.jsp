<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGAIM0134" toScope="request"/>
<bean:define id="title"  toScope="request">
	<bean:message bundle="asmResources" key="ietitle.IGASM0813"/>
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
	//按钮操作提示
	function deleteRec(flag){
        var message = '<bean:message key="IGCO10000.E002"/>';
        var arg0 = '<bean:message bundle="asmResources" key="message.IGASM0814.001"/>';
        var confirmMsg = '<bean:message bundle="asmResources" key="message.IGASM0814.003"/>';
        var mode="0";
        var count=0;
        if(flag=="0"){
        	count=checkAndCreate(flag);
			if(count==0){
				message ='<bean:message key="IGCO10000.E029" />';
				alert(message);
				return false;
			}else{
		confirmMsg = '<bean:message bundle="asmResources" key="message.IGASM0814.003"/>';
        IGCIM0129Form.action = getAppRootUrl() + "/IGCIM0129_Insert.do?";
			}
        }
		if(flag=="1"){
			count=checkAndCreate(flag);
			if(count==0){
				message = '<bean:message key="IGCO10000.E002"/>';
				alert(message);
				return false;
			}else{
			message = '<bean:message bundle="asmResources" key="message.IGASM0814.002"/>';
			confirmMsg = '<bean:message key="IGCO10000.W002" arg0="'+arg0+'" />';
			mode="1";
			IGCIM0129Form.action = getAppRootUrl() + "/IGCIM0129_Delete.do?";
			}
		}

		if(window.confirm(confirmMsg)){

            return true;
        } else {
            return false;
        }
	}
	
	function checkAndCreate(flag){
		var count=0;
		if(flag==0){
			var check=document.getElementsByName("eiid_add");
			var eiversion_add=document.getElementsByName("eiversion_add");
			var eismallversion_add=document.getElementsByName("eismallversion_add");
			for(var i=0;i<check.length;i++){
				if(check[i].checked==true){
					count=1;
					createHiddenInputForm("eiids",check[i].value,IGCIM0129Form);
					createHiddenInputForm("eiversions",eiversion_add[i].value,IGCIM0129Form);
					createHiddenInputForm("eismallversions",eismallversion_add[i].value,IGCIM0129Form);
				}
			}
		}else{
			var check=document.getElementsByName("eiid_del");
			var eiversion_add=document.getElementsByName("eiversion_del");
			var eismallversion_add=document.getElementsByName("eismallversion_del");
			for(var i=0;i<check.length;i++){
				if(check[i].checked==true){
					count=1;
					createHiddenInputForm("eiids",check[i].value,IGCIM0129Form);
					createHiddenInputForm("eiversions",eiversion_add[i].value,IGCIM0129Form);
					createHiddenInputForm("eismallversions",eismallversion_add[i].value,IGCIM0129Form);
				}
			}
		}
		return count;
	}

	
	 function toback(){
		var form = document.forms[0];
     	form.action = getAppRootUrl() + "/IGCIM0126_Disp.do?org.apache.struts.taglib.html.CANCEL=1";
     	form.submit();
     }
	 function toback1(){
		var form = document.forms[0];
     	form.action = getAppRootUrl() + "/IGCIM0133_Disp.do?org.apache.struts.taglib.html.CANCEL=1";
     	form.submit();
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
                <p class="fonts1">
                	<ig:navigation extname1="${urlable}"/> &gt;&gt; 关系管理  &gt;&gt; FS关系管理
                </p>
                <div class="back">
	             <logic:equal value="1" name="IGCIM0129Form" property="flag">
                 <html:link href="javascript:toback1();">
	                	<bean:message bundle="asmResources" key="button.IGASM0814.btn_toback"/>
	                </html:link>
                </logic:equal>
	           <logic:notEqual value="1" name="IGCIM0129Form" property="flag">
                 <html:link href="javascript:toback();">
	                	<bean:message bundle="asmResources" key="button.IGASM0814.btn_toback"/>
	                </html:link>
                </logic:notEqual>
                </div> 
     </div>
		<html:form styleId="form" action="/IGCIM0129_Disp" onsubmit="return checkSubmit(this);">
 				<div class="role_title">
                    <bean:message bundle="asmResources" key="label.IGASM0814.ChoosedFS"/>
                </div>
                <div id="results_list">
             	   <ig:message />
                    <table class="table_style4" align="left" style="width: 100%">
                        <tr>
	                        <th width="10%"><input type="checkbox" name="checkbox" id="checkbox" onclick="selectAll('checkbox','eiid_del')" /></th>
	                        <th width="21%"><bean:message bundle="asmResources" key="label.IGASM0814.UserNO"/></th>
	                        <th width="13%"><bean:message bundle="asmResources" key="label.IGASM0814.UserName"/></th>
	                        <th width="10%"><bean:message bundle="asmResources" key="label.IGASM0814.UserOrgan"/></th>
	                        <th width="18%"><bean:message bundle="asmResources" key="label.IGASM0814.UserRemark"/></th>
	                        <th width="7%"><bean:message bundle="asmResources" key="label.IGASM0814.UserManager"/></th>
	                        <th width="8%"><bean:message bundle="asmResources" key="label.IGASM0814.UserMarkDay"/></th>
	                        <th width="12%"><bean:message bundle="asmResources" key="label.IGASM0814.UpdateTime"/></th>
                        </tr>
                        <logic:present name="IGCIM01341VO" property="entityItemedList">
                        <logic:iterate id="beaned" name="IGCIM01341VO" property="entityItemedList" indexId="index">
	                      <tr class="<ig:rowcss index="${index}"/>" onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);">
	                      <td align="center"><input type="checkbox" name="eiid_del" value="${beaned.eiid}"><html:hidden property="eiversion_del" value="${beaned.eiversion}"/>
                          <html:hidden property="eismallversion_del" value="${beaned.eismallversion}"/></td>
                          <td align="center">${beaned.eilabel}</td>
                          <td align="center">${beaned.einame}</td>
                          <td>${IGASM08061VO.eiorgname}</td>
					 	  <td>${beaned.eidesc}</td>
                          <td align="center">${beaned.eiusername}</td>
                          <td align="center">${beaned.eiinsdate}</td>
                          <td align="center">${beaned.eiupdtime}</td>
	                      </tr>
                        </logic:iterate>
                        </logic:present>
                     </table>
                </div>
                <logic:notEqual value="1" name="IGCIM0129Form" property="flag">
                <html:submit property="btn_del" styleClass="button" onclick="return deleteRec('1');">
                     	<bean:message bundle="asmResources" key="button.IGASM0814.btn_del"/>    
                </html:submit>
                </logic:notEqual>
                <div class="role_title">
                   <bean:message bundle="asmResources" key="label.IGASM0814.chooseableFS"/>
                </div>
                <div id="results_list">
                    <table class="table_style4" align="left" style="width: 100%">
                        <tr>
	                        <th width="10%"><input type="checkbox" name="checkboxOne" id="checkboxOne" onclick="selectAll('checkboxOne','eiid_add')" /></th>
	                        <th width="21%"><bean:message bundle="asmResources" key="label.IGASM0814.UserNO"/></th>
	                        <th width="13%"><bean:message bundle="asmResources" key="label.IGASM0814.UserName"/></th>
	                        <th width="10%"><bean:message bundle="asmResources" key="label.IGASM0814.UserOrgan"/></th>
	                        <th width="18%"><bean:message bundle="asmResources" key="label.IGASM0814.UserRemark"/></th>
	                        <th width="7%"><bean:message bundle="asmResources" key="label.IGASM0814.UserManager"/></th>
	                        <th width="8%"><bean:message bundle="asmResources" key="label.IGASM0814.UserMarkDay"/></th>
	                        <th width="12%"><bean:message bundle="asmResources" key="label.IGASM0814.UpdateTime"/></th>
                        </tr>
                        <logic:present name="IGCIM01341VO" property="entityItemList">
                        <logic:iterate id="bean" name="IGCIM01341VO" property="entityItemList" indexId="index">
	                      <tr class="<ig:rowcss index="${index}"/>" onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);">
	                      <td align="center"><input type="checkbox" name="eiid_add" value="${bean.eiid}"><html:hidden property="eiversion_add" value="${bean.eiversion}"/>
                          <html:hidden property="eismallversion_add" value="${bean.eismallversion}"/></td>
                          <td align="center">${bean.eilabel}</td>
                          <td align="center">${bean.einame}</td>
                          <td>${IGASM08061VO.eiorgname}</td>
					 	  <td>${bean.eidesc}</td>
                          <td align="center">${bean.eiusername}</td>
                          <td align="center">${bean.eiinsdate}</td>
                          <td align="center">${bean.eiupdtime}</td>
	                      </tr>
                        </logic:iterate>
                        </logic:present>
                        
                     </table>
                </div>
                <logic:notEqual value="1" name="IGCIM0129Form" property="flag">
                <html:submit property="btn_add" styleClass="button" onclick="return deleteRec('0');">
                     	<bean:message bundle="asmResources" key="button.IGASM0814.btn_add"/>    
                </html:submit>
                </logic:notEqual>
                <html:hidden property="pareiid" styleId="pareiid"/>
                <html:hidden property="parversion" styleId="parversion"/>
                <html:hidden property="parsmallversion" styleId="parsmallversion"/>
</html:form>                
	</div>
		 </div>
    </div>
</div>

</body>
</html:html>