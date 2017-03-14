<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGSYM1004" toScope="request"/>
<bean:define id="title" value="数据信息变更画面" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
    var gid='IGSYM1004';
		function confirmDisp(){
			var message1 = '<bean:message key="IGCO10000.W001" arg0="数据信息" />';
            var message2 = '<bean:message key="IGCO10000.W003" arg0="数据信息" />';
			if ('${IGSYM1004Form.mode}' == '0' || '${IGSYM1004Form.mode}' == '2'){
			    if($F('cid').strlen()>4){
	            	alert("数据编号不能大于4个字符！");
	    			return false;
	    		}
			    regExp=/[\u4E00-\u9FA5]/g;
				if(regExp.test($('cvalue').value)){
					alert("内容不能输入汉字");
					return false;
				}
			    if($F('cvalue').strlen()>512){
	            	alert("内容不能大于512个字符！");
	    			return false;
	    		}
	            if( window.confirm(message1)){
	                return true;
	            } else {
	                return false;
	            }
			} else {

				regExp=/[\u4E00-\u9FA5]/g;
				if(regExp.test($('cvalue').value)){
					alert("内容不能输入汉字");
					return false;
				}
			    if($F('cid').strlen()>4){
	            	alert("数据编号不能大于4个字符！");
	    			return false;
	    		}
			    if($F('cvalue').strlen()>512){
	            	alert("内容不能大于512个字符！");
	    			return false;
	    		}
                if( window.confirm(message2)){
                    return true;
                } else {
                    return false;
                }
			}
		}

		function toback(){
            IGSYM1004Form.action = getAppRootUrl() + "/IGSYM1004.do?org.apache.struts.taglib.html.CANCEL=1";
            IGSYM1004Form.submit();
		}
		
        function setParamIGCOM0304(ccid, ccname, cid, cvalue) {
            $("pccid").value = ccid;
            $("pcid").value = cid;   
            $("pccname").value = ccname;   
            $("pcvalue").value = cvalue;   
                   
        }
        
        //Ajax调用
        function execAssistCodeCategory(ccid, ccname){
            if($(ccid).value.length == 3){
                execAjaxCcname($(ccid).value,ccname);
            }
        }
        function execAssistCodeDetail(ccid, cid, cvalue){
            if($(ccid).value.length == 3 && $(cid).value.length >= 3){
                execAjaxCvalue($(ccid).value,$(cid).value,cvalue);
            }
        }
	</script><body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">

            <div id="location">
                <div class="image"></div>
                <p class="fonts1"><ig:navigation extname1="${urlable}"/> &gt;&gt; 数据详细信息 &gt;&gt; 数据变更
               
                </p>
                <div class="back"><html:link href="IGSYM1006_Disp.do?ccid=${IGSYM1004Form.ccid}">返回</html:link></div> 
            </div>

            <div id="formwrapper">
		         <html:form styleId="IGSYM1004Form" action="/IGSYM1004" onsubmit="return checkSubmit(this);">
                      <!--  message -->
                      <ig:message/>
                      <!--  /message -->     
                    <fieldset>
			            <legend>数据变更</legend>
			            <div>
			                <label for="Name"><strong><span class="red">*</span>字段说明</strong>：</label>
			                <html:text name="IGSYM1004Form" property="cdinfo" size="18" style="width:300px;" styleClass="inputDisable" tabindex="2" readonly="true"/>
			                <br>
			            </div>
			            <div>
			                <label for="Name"><strong><span class="red">*</span>内容</strong>：</label>
			                
			                <logic:equal name="IGSYM1004Form" property="cdstatus" value="P">
			                	<html:password name="IGSYM1004Form" property="cvalue"  size="18" style="width:300px;" errorStyleClass="inputError imeActive"/>
			                	<html:hidden property="cdstatus" value="${IGSYM1004Form.cdstatus}"/>
			                </logic:equal>
			                <logic:notEqual name="IGSYM1004Form" property="cdstatus" value="P">
			               		<html:text name="IGSYM1004Form" property="cvalue"  size="18" style="width:300px;" errorStyleClass="inputError imeActive"/>
			                </logic:notEqual>
			                	
			                <br>
			            </div>
		            </fieldset>
		            <div class="enter">
		                <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return confirmDisp();"  />
		            </div>
                    <html:hidden property="mode" styleId="mode" value="${IGSYM1004Form.mode}"/>
                    <html:hidden property="route" styleId="route" value="${IGSYM1004Form.route}"/>
                    <html:hidden property="ccid" styleId="ccid" value="${IGSYM1004Form.ccid}"/>
                    <html:hidden property="cid" styleId="cid" value="${IGSYM1004Form.cid}"/>
 		         </html:form>
            </div>
        </div>
    </div>
</div>

</div>
</body>
</html:html>