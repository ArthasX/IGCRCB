<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCIM0411" toScope="request"/>
<bean:define id="title" value="取值范围登记画面" toScope="request"/>
<bean:define id="bean" name="IGCIM04111VO" property="configurationCodeDetail" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">	
var attachFileNum = 0;
function addFileValue() {
	var tb = document.getElementById("tb");
	var currRow = tb.insertRow();
	var cell = currRow.insertCell();
	cell.innerHTML= "<label for='Name' style='margin-left:60px'><strong><span class='red'>*</span>数据值：</strong></label><input type='text' id='ccdvalues["+attachFileNum+"]' name='ccdvalues' contentEditable='true'><input type='button' class='button' value='\u5220\u9664' onclick='deleteText(this)'>";
	attachFileNum++;
}		
function deleteText(obj)
{
	var curRow = obj.parentNode.parentNode;
	tb.deleteRow(curRow.rowIndex);
}
function checkSubmit(){
	var temp = document.getElementsByName("ccdvalues");
	if(temp!=null&&temp.length>0){
		for ( var i = 0; i < temp.length; i++) {
			if(temp[i].value == "" ){
				alert("请增加第"+(i+1)+"个数据值！");
				return false;
			}
			if(temp[i].value.strlen()>32){
				alert("请增加第"+(i+1)+"个数据值不能大于"+Math.floor(32/strByteFlag)+"个汉字！");
				return false;
			}
		}
	}
	else
	{
		alert("请增加数据值！");
		return false;
	}
	var message = '';
    if ('${IGCIM0402Form.mode}' == '0'){
        message = '<bean:message key="IGCO10000.W001" arg0="数据基本信息" />';
    } else {
        message = '<bean:message key="IGCO10000.W003" arg0="数据基本信息" />';
    }
	if( window.confirm(message)){
		return true;
	} else {
		return false;
	}
}
</script>
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
                <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
            </div>

            <div id="formwrapper">
            <html:form styleId="form" action="/IGAIM0411" onsubmit="return checkSubmit();">
				<!--  message -->
				<ig:message/>
				<!--  /message -->     
                <fieldset>
					    <legend>基本信息添加</legend>
                    <div>
	                    <label for="Name"><strong><span class="red">*</span>数据类型编号</strong>：</label>
	                    	<html:text property="ccdcategory" style="width:85" tabindex="2" value="${bean.ccdcategory}" readonly="true" styleClass="inputDisable" />
                        <br>
					</div>
					<div>
	                    <label for="Name"><strong><span class="red">*</span>数据类型名称</strong>：</label>
	                    	<html:text property="ccdlabel" style="width:85" tabindex="2" value="${bean.ccdlabel}" readonly="true" styleClass="inputDisable" />
                        <br>
					</div>
    				<div style="padding-left: 20px"><img src="images/brick.gif" width="13" height="13"/><a
						href="javascript:addFileValue();" id="aAddAttach">&nbsp;增加数据值</a>
						</div>
					<table id="tb">
					</table>
    				</fieldset>
				<div class="enter">
				    <html:submit property="btn_insert" value="提交" styleClass="button" />
				    <input type="button" value="返回" class="button" onclick="window.location='IGAIM0410_Disp.do?ccdcategory=<%=request.getParameter("ccdcategory") %>';"/>
				</div>
            </html:form>
            </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
