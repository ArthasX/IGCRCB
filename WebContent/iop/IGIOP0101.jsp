<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGIOP0101" toScope="request"/>
<bean:define id="title"  toScope="request" value="子网登记"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<style type="text/css">
	.errorStyle{
		border: 1px solid red;
		
	}
	input{
		border:1px solid black;
	}
</style>
<!-- /header1 -->


<body onLoad="">
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
            <div>
            
				<html:form styleId="form" action="/IGIOP0101"   onsubmit="return checkSubmit(this);">
            	<ig:message/>
	               	<fieldset>
             			<legend>子网登记</legend>
             			<div>
		                     <label for="Name"><strong><span class="red">*</span>子网掩码</strong>：</label>
		                     <html:text property="subnet" styleId="subnet" onblur="checkSubNet(this)" styleClass="" tabindex="1" ></html:text>
                 		</div>
                 		<div>
		                     <label for="Name"><strong><span class="red">*</span>起始IP</strong>：</label> 
		                     <html:text property="ipFrom" styleId="ipFrom" onblur="checkIP(this)" styleClass="" tabindex="2" ></html:text>
                 		</div>
		                <div>
			                 <label for="Name"><strong><span class="red">*</span>终止IP</strong>：</label> 
		                     <html:text property="ipTo" styleId="ipTo" styleClass="" onblur="checkIP(this)" tabindex="3" ></html:text>
		                </div>     		
                 		
                 		
             		</fieldset>      
             		<div class="enter">
							<html:submit  styleClass="button" onclick=" return checkForm();">提交</html:submit>
             		</div>          
	            </html:form>
            </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
<script type="text/javascript">
	
	function checkIpFormat(str){
		if(!str){
			return false;
		}
		var rex = new RegExp(/^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/);
		if(!rex.test(str)){
			return false;
		}
		return true;
	}
	
	
	function checkIP(obj){
		var str =obj.value;
		if(!checkIpFormat(str)){
			jQuery(obj).addClass("errorStyle").attr("errMsg","IP地址格式不正确!");
			showMsg(obj);
			//alert(jQuery(obj).attr("errMsg"));
		}else{
			jQuery(obj).removeClass("errorStyle").removeAttr("errMsg").hideMsg();
			//当前控件是开始IP 还是结束IP
			var isFrom = jQuery(obj).attr("id")=="ipFrom";
			//取出另一个IP地址
			var otherIP = isFrom?jQuery("#ipTo"):jQuery("#ipFrom");
			
			if(jQuery("#subnet").val()&&otherIP.val()){
				var netLength = getSubnetStr(jQuery("#subnet").val()).indexOf("0");
				
				var ipFrom = isFrom?getSubnetStr(str):getSubnetStr(otherIP.val());
				var ipTo = !isFrom?getSubnetStr(str):getSubnetStr(otherIP.val());
				if(ipFrom>=ipTo){
					jQuery(obj).addClass("errorStyle").attr("errMsg","IP结束地址应大于IP开始地址");
					showMsg(obj);
					//alert(jQuery(obj).attr("errMsg"));
				}else{
					jQuery("input[id^='ip']").removeClass("errorStyle").removeAttr("errMsg").hideMsg();
				
				}
			
			}
		}
		
	}
	//换算成二进制
	function getSubnetStr(str){
		var str2='';
		var subStr = str.split('.');
		for(var i=0;i< subStr.length;i++){
			var tempStr = parseInt(subStr[i], 10).toString(2);
			str2+=(tempStr.length<8)?"00000000".substring(tempStr.length)+tempStr:tempStr;
		}
		return str2;
	}
	//验证子网掩码
	function checkSubNet(obj){
		var str =obj.value;
		if(checkIpFormat(str)){
			var str2=getSubnetStr(str);
			if(str2.indexOf('01')>0){
				jQuery(obj).addClass("errorStyle").attr("errMsg","子网掩码格式不合法");
				showMsg(obj);
				//alert(jQuery(obj).attr("errMsg"));
			}else if(str2.indexOf("0")<16){
				jQuery(obj).addClass("errorStyle").attr("errMsg","该子网掩码子网内主机数量太大");
				showMsg(obj);
				//alert(jQuery(obj).attr("errMsg"));
			}else{
				jQuery(obj).removeClass("errorStyle").removeAttr("errMsg").hideMsg();
			}
		}else{
			jQuery(obj).addClass("errorStyle").attr("errMsg","子网掩码格式不正确");
			showMsg(obj);
			//alert(jQuery(obj).attr("errMsg"));
		}
	}
	
	function checkForm(){
		var result = true;
		jQuery(".errorStyle").each(function(i,t){
			alert(jQuery(t).attr("errMsg"));
			result = false;
			return false;
		});
		
		if(result){
			jQuery("input").each(function(i,t){
				if(!t.value){
					alert("请将表单填写完整");
					t.focus();
				result = false;
				return false;
				}
			});
		}
		
		if(result&&jQuery("#desc").val().lenght>80){
			alert("说明字符长度过长!");
			result = false;
		}
		
		return result;
	}
	
	function showMsg(obj){
		jQuery(obj).hideMsg().after("<span class='txtMsg' style='color:red;margin-left:10px;'>"+jQuery(obj).attr("errMsg")+"</span>");
	}
	jQuery.fn.extend({
		hideMsg:function(){
			this.next("span").remove();
			return this;
		}
	});
	
	
</script>
</body>
</html:html>