<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGRDP0101" toScope="request"/>
<bean:define id="title" value="远程部署升级登记画面" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<style>
.hosts_style{ 
	border-top:1px solid #CCCCCC; 
    width:83.5%;    
    margin:0 auto;    
    border-collapse:collapse;     
    text-align:center; 
    table-layout:left;  
}
.hosts_style td{ 
    border-bottom:1px solid #D3D3D3;
    word-break: break-all; 
    word-wrap:break-word;
}
</style>
<script type="text/javascript">	

	function load(){
	}
	
    function checkForm(){
    	if($("taskName").value.trim()==""){
    		alert("请输入任务名称！");
    		return false;
    	}
    	if($("currentFilePath").value.trim()==""){
    		alert("请输入升级文件夹！");
    		return false;
    	}
    	if($("scriptName").value.trim()==""){
    		alert("请输入待执行脚本名！");
    		return false;
    	}
    	
    	var hostips = document.getElementsByName("hostips");
    	if(hostips.length == 0){
    		alert("请至少选择一个执行主机！");
    		return false;
    	}
    	return true;
    }
    function getHosts(obj){
    	var id = obj.value;
		var objAjax = new Ajax.Request(getAppRootUrl() + '/IGRDP0101_getHostByAjax.do?bsmid='+id,{asynchronous:false,parameters:'',method:"post",
			 onSuccess:  function(req, json){
			 	 var result = req.responseText;
			 	 if(result == null) result = '';
			 	 var optionStr = createOptions(result);
			 	 hosts.innerHTML = optionStr;
		     }
			});
		return true;
    }
    
    function createOptions(result){
    	var temp = '<label for="Name"><strong><span class="red">*</span>执行主机</strong>：</label>';
    	var hosts = result.split("#");
    	for(var i=0;i<hosts.length;i++){
    		var buf = hosts[i].split("&");
    		if(i%2 ==0 && i!=0){
    			temp = temp + '<br/>';
    		}
    		temp = temp + '<input type="checkbox" name="hostips" value="'+buf[0]+'">'+buf[1]+"&nbsp;&nbsp;";
    	}
    	return temp;
    }
</script>
<body onload="load();">
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
                <p class="fonts1">远程部署&gt;&gt; 远程升级 &gt;&gt;升级任务添加
                </p>
            </div>

            <div id="formwrapper">
            <html:form styleId="form" action="/IGRDP0101_Insert" onsubmit="return checkSubmit(this);">
				<!--  message -->
				<ig:message/>
				<!--  /message -->     
                <fieldset>
					<legend>任务信息</legend>
					
					<div>
						<label for="Name"><strong><span class="red">*</span>任务名称</strong>：</label>
						<html:text name="IGRDP0101Form" property="taskName" size="18" style="width:160px;" errorStyleClass="inputError" tabindex="2"/>
						<br>
    				</div>
					
					<div>
						<label for="Name"><strong><span class="red">*</span>业务系统</strong>：</label>
						<html:select styleId="bsmid" property="bsmid" style="width: 160px;" errorStyleClass="inputError" onchange="getHosts(this);">
							<html:options collection="bsms" property="eiid" name="" labelProperty="einame"/>
						</html:select>
						<br>
    				</div>
    				<br/>
    				
    				<div>
						<label for="Name"><strong><span class="red">*</span>升级文件夹</strong>：</label>
						<html:text name="IGRDP0101Form" property="currentFilePath" size="18" style="width:200px;" errorStyleClass="inputError" tabindex="2" />
						<br>
    				</div>
    				
    				<div>
						<label for="Name"><span class="red">*</span><strong>待执行脚本名</strong>：</label>
						<html:text name="IGRDP0101Form" property="scriptName" size="18" style="width:160px;" errorStyleClass="inputError" tabindex="2" />
						<br>
    				</div>
    				
    				<div>
						<label for="Name"><strong>脚本执行参数</strong>：</label>
						<html:text name="IGRDP0101Form" property="scriptParam" size="18" style="width:160px;" errorStyleClass="inputError" tabindex="2"/>
						<br>
    				</div>
    				
    				<!-- 
    				<div>
						<label for="Name"><strong><span class="red">*</span>脚本传送位置</strong>：</label>
						<html:text name="IGRDP0101Form" property="scriptPath" size="18" style="width:200px;" errorStyleClass="inputError" tabindex="2" />
						<br>
    				</div>
    				
    				<div>
						<label for="Name"><span class="red">*</span><strong>升级包传送位置</strong>：</label>
						<html:text name="IGRDP0101Form" property="rdpFilePath" size="18" style="width:200px;" errorStyleClass="inputError" tabindex="2" />
						<br>
    				</div>
					 -->
					 
    				<div>
						<label for="Name"><strong>程序日志读取路径</strong>：</label>
						<html:text name="IGRDP0101Form" property="resultLogPath" size="18" style="width:200px;" errorStyleClass="inputError" tabindex="2"/>
						<br>
    				</div>
    				
    				<br/>
    				<div id="hosts">
    					<label for="Name"><strong><span class="red">*</span>执行主机</strong>：</label>
 						<logic:present name="IGRDP01011VO" property="hosts" >
	                    	<logic:iterate id="bean" name="IGRDP01011VO" property="hosts" indexId="index">
	                    		<c:if test="${index % 2 == 0 && index != 0}">
	                        		<br/>
	                        	</c:if>
	                        	<html:checkbox property="hostips" value="${bean.eilabel}"/>${bean.einame }（IP地址：${bean.eilabel }，类型：${bean.ename }）

	                    	</logic:iterate>
                    	</logic:present>
    				</div>
    				
    				
    				</fieldset>

				<div class="enter">
				    <html:submit property="btn_insert" value="登记" styleClass="button"  onclick="return checkForm();"  />
				    <html:reset styleClass="button" >重置</html:reset>
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