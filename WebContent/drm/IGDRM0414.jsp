<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGDRM0414" toScope="request"/>
<logic:equal name="IGDRM0414Form" property="mode" value="0">
<bean:define id="title" value="分类配置信息登记画面" toScope="request"/>
</logic:equal>

<logic:equal name="IGDRM0414Form" property="mode" value="1">
<bean:define id="title" value="分类配置信息变更画面" toScope="request"/>
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
		    		alert("请选择关联分类！");
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
				var message1 = '<bean:message key="IGCO10000.W001" arg0="分类配置信息" />';
	            var message2 = '<bean:message key="IGCO10000.W003" arg0="分类配置信息" />';
				if($F('cattach').trim()=="2" && $F('coption').trim()==""){
					alert("请选择取值范围！");
					return false;
				}
				if($F('cattach').trim()=="4" && $F('cesyscoding').trim()==""){
					alert("请选择关联分类！");
					return false;
				}
				if ('${IGDRM0414Form.mode}' == '0'){
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
            IGDRM0414Form.action = getAppRootUrl() + "/IGDRM0414.do?org.apache.struts.taglib.html.CANCEL=1";
            IGDRM0414Form.submit();
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
			var temp = window.showModalDialog("IGDRM0417_Disp.do",null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
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
                <p class="fonts1">资产管理 &gt;&gt; 分类管理 &gt;&gt; 
                <logic:equal name="IGDRM0414Form" property="route" value="0">
                                          分类登记 &gt;&gt; 配置项登记 
                </logic:equal>
                <logic:equal name="IGDRM0414Form" property="route" value="1">
                <logic:equal name="IGDRM0414Form" property="mode" value="0">
                                           分类查询 &gt;&gt; 详细信息 &gt;&gt; 配置项登记 
                </logic:equal>
                <logic:equal name="IGDRM0414Form" property="mode" value="1">
                                            分类查询 &gt;&gt; 详细信息 &gt;&gt; 配置项变更
                </logic:equal>                    
                </logic:equal>                  
                </p>
                <div class="back"><html:link href="javascript:toback();">返回</html:link></div> 
            </div>

            <div id="formwrapper">
		         <html:form styleId="IGDRM0414Form" action="/IGDRM0414" onsubmit="return checkSubmit(this);">
                      <!--  message -->
                      <ig:message/>
                      <!--  /message -->     
                    <fieldset>
	                    <logic:equal name="IGDRM0414Form" property="mode" value="0">
	                    <legend>配置信息添加</legend>
	                    </logic:equal>
	                    <logic:equal name="IGDRM0414Form" property="mode" value="1">
			            <legend>配置信息变更</legend>
	                    </logic:equal>
			            <div>
			                <label for="Name"><strong><span class="red">*</span>分类名称</strong>：</label>
			                <html:text name="IGDRM0414Form" property="ename" tabindex="-1" value="${IGDRM04121VO.entityData.ename}" readonly="true" styleClass="inputDisable"/>
			               <html:hidden property="esyscoding" name="IGDRM0414Form" value="${IGDRM04121VO.entityData.esyscoding}"/>
			                <br>
			            </div>
			            
			            <div>
			                <label for="Name"><strong><span class="red">*</span>配置项名称</strong>：</label>
			                <html:text name="IGDRM0414Form" property="cname" errorStyleClass="inputError imeActive" tabindex="2"/>
			                <br>
			            </div>
			            <div>
			                <label for="Name"><strong>配置项说明</strong>：</label>
			                <html:text name="IGDRM0414Form" property="cdesc" styleId="cdesc" size="41"  tabindex="3" style="width:350px" errorStyleClass="inputError" />
			                <br>
			            </div>
	                    <div>
	                        <label for="Name"><strong>配置项单位</strong>：</label>
	                        <html:select name="IGDRM0414Form" property="cunit" style="width: 85px;" errorStyleClass="inputError" tabindex="4">
	                            <ig:optionsCollection ccid="CONFIGURATION_UNIT_CODE" isMakeBlankRow="true" isCodeLabel="true"/>
	                        </html:select>
	                        <br>
	                    </div>
	                    <div>
	                        <label for="Name"><strong>是否必填</strong>：</label>
	                        <html:select name="IGDRM0414Form" property="crequired" style="width: 85px;" errorStyleClass="inputError">
	                            <html:option value="0">否</html:option>
	                            <html:option value="1">是</html:option>
	                        </html:select>
	                        <br>
	                    </div>
	                    <div>
	                        <label for="Name"><strong><span class="red">*</span>配置项类别</strong>：</label>
	                        <html:select name="IGDRM0414Form" property="ccategory" style="width: 85px;" errorStyleClass="inputError" tabindex="6">
	                            <ig:optionsCollection ccid="CONFIGURATION_CATEGORY_CODE" isMakeBlankRow="true" isCodeLabel="true"/>
	                        </html:select>
	                        <br>
	                    </div>
                        <div>
                            <label for="Name"><strong><span class="red">*</span>数据类型</strong>：</label>
                            <logic:equal name="IGDRM0414Form" property="mode" value="0">
                            <html:select name="IGDRM0414Form" property="cattach" style="width: 85px;" errorStyleClass="inputError" tabindex="7" onchange="showDiv(this)">
                                <ig:optionsCollection ccid="CONFIGURATION_ATTACH_CODE" isMakeBlankRow="true" isCodeLabel="true"/>
                            </html:select>
               			    </logic:equal>
                            
                            <logic:equal name="IGDRM0414Form" property="mode" value="1">
                            <html:select name="IGDRM0414Form" property="cattach" style="width: 85px;" errorStyleClass="inputError" tabindex="7" disabled="true" styleClass="inputDisable">
                                <ig:optionsCollection ccid="CONFIGURATION_ATTACH_CODE" isMakeBlankRow="true" isCodeLabel="true"/>
                            </html:select>        	
                			</logic:equal>          
                            
                            <br>
                        </div>
			            <div id="a" style="display: none;">
			                <label for="Name"><strong><span class="red">*</span>取值范围</strong>：</label>
			                <html:text name="IGDRM0414Form" property="rangename" style="width: 85px;"  errorStyleClass="inputError imeActive" tabindex="8" readonly="true"/>
			                <html:hidden name="IGDRM0414Form" property="coption" />
			                 <img src="images/seek.gif" width="16" height="16" alt="查询" onclick="showList()" style="cursor: hand"/>
			                <br>
			            </div>
			            <div id="b" style="display: none;">
			                <label for="Name"><strong><span class="red">*</span>关联分类</strong>：</label>
			                <html:text name="IGDRM0414Form" property="cename" style="width: 85px;"  errorStyleClass="inputError imeActive" tabindex="8" readonly="true"/>
			                <html:hidden name="IGDRM0414Form" property="cesyscoding" />
			                 <img src="images/tree.gif" style="cursor: hand;" alt="资产分类" width="16" height="16" border="0" onclick="setEntity('IGSYM1201_ENTITY_TREE_BYLEVEL.do?levelnode=999&del=999009_999012&type=0');"/>
			                <br>
			            </div>
		            </fieldset>
		            <div class="enter">
		                <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return confirmDisp();"  />
		                <html:cancel styleId="btn_cancel" styleClass="button" value="返回"/>
		            </div>
                    <html:hidden property="cseq" styleId="cseq" value="${IGDRM0414Form.cseq}"/>
		            <html:hidden property="eid" styleId="eid" value="${IGDRM04121VO.entityData.eid}"/>
                    <html:hidden property="cidStr" styleId="cidStr" value="${IGDRM0414Form.cidStr}"/>
                    <html:hidden property="mode" styleId="mode" value="${IGDRM0414Form.mode}"/>
                    <html:hidden property="route" styleId="route" value="${IGDRM0414Form.route}"/>
                    <html:hidden property="cstatus" name="IGDRM0414Form"/>
                    <html:hidden property="clabel" name="IGDRM0414Form" value=""/>
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
			<logic:equal name="IGDRM0414Form" property="cattach" value="2">
				document.forms[0].rangename.value = "${IGDRM0414Form.rangename}";
				document.getElementById("a").style.display = "";
			</logic:equal>  
			<logic:equal name="IGDRM0414Form" property="cattach" value="4">
				document.forms[0].cename.value = "${IGDRM0414Form.cename}";
				document.getElementById("b").style.display = "";
			</logic:equal>  
	</script>