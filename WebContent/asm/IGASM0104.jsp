<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM0104" toScope="request"/>
<logic:equal name="IGASM0104Form" property="mode" value="0">
<bean:define id="title" value="模型配置信息登记画面" toScope="request"/>
</logic:equal>

<logic:equal name="IGASM0104Form" property="mode" value="1">
<bean:define id="title" value="模型配置信息变更画面" toScope="request"/>
</logic:equal>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
		//画面再表示
		function confirmDisp(){

	    	if($F('cname').trim()==""){
	    		alert("请输入配置项名称！");
	    		return false;
	    	}
	    	if($F('ccategory').trim()==""){
	    		alert("请选择配置项类别！");
	    		return false;
	    	}
	    	if($F('cattach').trim()==""){
	    		alert("请选择数据类型！");
	    		return false;
	    	}
	    	if($F('cattach').trim()=="2"){
	    		if($F('rangename').trim()=="")
	    		{
		    		alert("请选择取值范围！");
		    		return false;
		    	}
	    	}
	    	if($F('cattach').trim()=="4"){
	    		if($F('cename').trim()=="")
	    		{
		    		alert("请选择关联模型！");
		    		return false;
		    	}
	    	}
			if($F('cname').strlen()>120){
	    		alert("配置项名称不能大于"+Math.floor(120/strByteFlag)+"个汉字！");
	    		return false;
	    	}if($F('cdesc').strlen()>40){
	    		alert("配置项说明不能大于"+Math.floor(40/strByteFlag)+"个汉字！");
	    		return false;
	    	}else {
				var message1 = '<bean:message key="IGCO10000.W001" arg0="模型配置信息" />';
	            var message2 = '<bean:message key="IGCO10000.W003" arg0="模型配置信息" />';
				if($F('cattach').trim()=="2" && $F('coption').trim()==""){
					alert("请选择取值范围！");
					return false;
				}
				if($F('cattach').trim()=="4" && $F('cesyscoding').trim()==""){
					alert("请选择关联模型！");
					return false;
				}
				if ('${IGASM0104Form.mode}' == '0'){
		            if( window.confirm(message1)){
		                return true;
		            } else {
		                return false;
		            }
				} else {
	                if( window.confirm(message2)){
	                    return true;
	                } else {
	                    return false;
	                }
				}
			}
		}

		function toback(){
            IGASM0104Form.action = getAppRootUrl() + "/IGASM0104.do?org.apache.struts.taglib.html.CANCEL=1";
            IGASM0104Form.submit();
		}

		function showDiv(obj){ 
			if(obj.value == "2"){
				document.getElementById("a").style.display = "";
				document.getElementById("b").style.display = "none";
			} else if(obj.value == "4"){
				document.getElementById("b").style.display = "";
				document.getElementById("a").style.display = "none";
			} else if(obj.value == "5"){
				document.getElementById("a").style.display = "";
				document.getElementById("b").style.display = "none";
			} else {
				document.getElementById("a").style.display = "none";
				$("rangename").value="";
				$("coption").value="";
				document.getElementById("b").style.display = "none";
				$("cename").value="";
				$("cesyscoding").value="";
			}
		}

		 function setEntity(url){
				var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
				if("_resetall"==temp){
					document.forms[0].cename.value = "";
					document.forms[0].cesyscoding.value = "";
					return false;
				}
				if(null!=temp && temp.split("|").length>1){
					var syscode_eid = temp.split("|")[0];
					var name = temp.split("|")[1];
					var syscode;
					var eid;
					var ecategory;
					if(syscode_eid =="999")
					{
						eid = "";
						syscode = syscode_eid;
					}else if(syscode_eid.split("_").length>1){
						eid = syscode_eid.split("_")[0];
						syscode = syscode_eid.split("_")[1];
						ecategory = syscode_eid.split("_")[2];
					}
					document.forms[0].cename.value = name;
					document.forms[0].cesyscoding.value = syscode;
				
				}		
				
			}
		function checkEntity(){
			if($F("esyscoding").substr(0,6) == "999009" || $F("esyscoding").substr(0,6) == "999012"){
				var obj = $("cattach").options;
				for(var i=0;obj.length;i++){
					if(obj[i].value == "4"){
						obj[i] = null;
						break;
					}
				}
			}
			//类型名称为机房时，数据类型去掉资产
			if($F("esyscoding").substr(0,6) == "999007"){
				var obj = $("cattach").options;
				for(var i=0;obj.length;i++){
					if(obj[i].value == "4"){
						obj[i] = null;
						break;
					}
				}
			}
		}

		 
		function showList(){
			var temp = window.showModalDialog("IGASM0107_Disp.do",null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
			if(null!=temp){
				$("rangename").value=temp.ccdlabel;
				$("coption").value=temp.ccdcategory;
			}		
		}

	</script>
<body onload="checkEntity()">
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
                <p class="fonts1">资产管理 &gt;&gt; 模型管理 &gt;&gt; 
                <logic:equal name="IGASM0104Form" property="route" value="0">
                                          模型登记 &gt;&gt; 配置项登记 
                </logic:equal>
                <logic:equal name="IGASM0104Form" property="route" value="1">
                <logic:equal name="IGASM0104Form" property="mode" value="0">
                                           模型查询 &gt;&gt; 详细信息 &gt;&gt; 配置项登记 
                </logic:equal>
                <logic:equal name="IGASM0104Form" property="mode" value="1">
                                            模型查询 &gt;&gt; 详细信息 &gt;&gt; 配置项变更
                </logic:equal>                    
                </logic:equal>                  
                </p>
                <div class="back"><html:link href="javascript:toback();">返回</html:link></div> 
            </div>

            <div id="formwrapper">
		         <html:form styleId="IGASM0104Form" action="/IGASM0104" onsubmit="return checkSubmit(this);">
                      <!--  message -->
                      <ig:message/>
                      <!--  /message -->     
                    <fieldset>
	                    <logic:equal name="IGASM0104Form" property="mode" value="0">
	                    <legend>配置信息添加</legend>
	                    </logic:equal>
	                    <logic:equal name="IGASM0104Form" property="mode" value="1">
			            <legend>配置信息变更</legend>
	                    </logic:equal>
			            <div>
			                <label for="Name"><strong><span class="red">*</span>模型名称</strong>：</label>
			                <html:text name="IGASM0104Form" property="ename" tabindex="-1" value="${IGASM01021VO.entityData.ename}" readonly="true" styleClass="inputDisable"/>
			               <html:hidden property="esyscoding" name="IGASM0104Form" value="${IGASM01021VO.entityData.esyscoding}"/>
			                <br>
			            </div>
			            
			            <div>
			                <label for="Name"><strong><span class="red">*</span>配置项名称</strong>：</label>
			                <html:text name="IGASM0104Form" property="cname" errorStyleClass="inputError imeActive" tabindex="2"/>
			                <br>
			            </div>
			            <div>
			                <label for="Name"><strong>配置项说明</strong>：</label>
			                <html:text name="IGASM0104Form" property="cdesc" styleId="cdesc" size="41"  tabindex="3" style="width:350px" errorStyleClass="inputError" />
			                <br>
			            </div>
	                    <div>
	                        <label for="Name"><strong>配置项单位</strong>：</label>
	                        <html:select name="IGASM0104Form" property="cunit" style="width: 85px;" errorStyleClass="inputError" tabindex="4">
	                            <ig:optionsCollection ccid="CONFIGURATION_UNIT_CODE" isMakeBlankRow="true" isCodeLabel="true"/>
	                        </html:select>
	                        <br>
	                    </div>
	                    <div>
	                        <label for="Name"><strong>是否必填</strong>：</label>
	                        <html:select name="IGASM0104Form" property="crequired" style="width: 85px;" errorStyleClass="inputError">
	                            <html:option value="0">否</html:option>
	                            <html:option value="1">是</html:option>
	                        </html:select>
	                        <br>
	                    </div>
	                    <div>
	                        <label for="Name"><strong><span class="red">*</span>配置项类别</strong>：</label>
	                        <html:select name="IGASM0104Form" property="ccategory" style="width: 85px;" errorStyleClass="inputError" tabindex="6">
	                            <ig:optionsCollection ccid="CONFIGURATION_CATEGORY_CODE" isMakeBlankRow="true" isCodeLabel="true"/>
	                        </html:select>
	                        <br>
	                    </div>
                        <div>
                            <label for="Name"><strong><span class="red">*</span>数据类型</strong>：</label>
                            <logic:equal name="IGASM0104Form" property="mode" value="0">
                            <html:select name="IGASM0104Form" property="cattach" style="width: 85px;" errorStyleClass="inputError" tabindex="7" onchange="showDiv(this)">
                                <ig:optionsCollection ccid="CONFIGURATION_ATTACH_CODE" isMakeBlankRow="true" isCodeLabel="true"/>
                            </html:select>
               			    </logic:equal>
                            
                            <logic:equal name="IGASM0104Form" property="mode" value="1">
                            <html:select name="IGASM0104Form" property="cattach" style="width: 85px;" errorStyleClass="inputError" tabindex="7" disabled="true" styleClass="inputDisable">
                                <ig:optionsCollection ccid="CONFIGURATION_ATTACH_CODE" isMakeBlankRow="true" isCodeLabel="true"/>
                            </html:select>        	
                			</logic:equal>          
                            
                            <br>
                        </div>
			            <div id="a" style="display: none;">
			                <label for="Name"><strong><span class="red">*</span>取值范围</strong>：</label>
			                <html:text name="IGASM0104Form" property="rangename" style="width: 85px;"  errorStyleClass="inputError imeActive" tabindex="8" readonly="true"/>
			                <html:hidden name="IGASM0104Form" property="coption" />
			                 <img src="images/seek.gif" width="16" height="16" alt="查询" onclick="showList()" style="cursor: hand"/>
			                <br>
			            </div>
			            <div id="b" style="display: none;">
			                <label for="Name"><strong><span class="red">*</span>关联模型</strong>：</label>
			                <html:text name="IGASM0104Form" property="cename" style="width: 85px;"  errorStyleClass="inputError imeActive" tabindex="8" readonly="true"/>
			                <html:hidden name="IGASM0104Form" property="cesyscoding" />
			                 <img src="images/tree.gif" style="cursor: hand;" alt="资产模型" width="16" height="16" border="0" onclick="setEntity('IGSYM1201_ENTITY_TREE_BYLEVEL.do?levelnode=999&del=999009_999012&type=0');"/>
			                <br>
			            </div>
		            </fieldset>
		            <div class="enter">
		                <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return confirmDisp();"  />
		                <html:cancel styleId="btn_cancel" styleClass="button" value="返回"/>
		            </div>
                    <html:hidden property="cseq" styleId="cseq" value="${IGASM0104Form.cseq}"/>
		            <html:hidden property="eid" styleId="eid" value="${IGASM01021VO.entityData.eid}"/>
                    <html:hidden property="cidStr" styleId="cidStr" value="${IGASM0104Form.cidStr}"/>
                    <html:hidden property="mode" styleId="mode" value="${IGASM0104Form.mode}"/>
                    <html:hidden property="route" styleId="route" value="${IGASM0104Form.route}"/>
                    <html:hidden property="cstatus" name="IGASM0104Form"/>
                    <html:hidden property="clabel" name="IGASM0104Form" value=""/>
 		         </html:form>
            </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
<script>
			<logic:equal name="IGASM0104Form" property="cattach" value="2">
				document.forms[0].rangename.value = "${IGASM0104Form.rangename}";
				document.getElementById("a").style.display = "";
			</logic:equal>  
			<logic:equal name="IGASM0104Form" property="cattach" value="4">
				document.forms[0].cename.value = "${IGASM0104Form.cename}";
				document.getElementById("b").style.display = "";
			</logic:equal>  
	</script>