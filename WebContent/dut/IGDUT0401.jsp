<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%
	String contextPath = request.getContextPath();
%>
<html:html>
<bean:define id="id" value="IGDUT0401" toScope="request" />
<bean:define id="title" value="延时解锁设定" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">   
	function prjSubmit(){
		if($F('datetime')==""){
			alert("日期时间不能为空！");
			return false;
		}
		if($F('orgname').trim()==""){
			alert("申请单位不能为空！");
			return false;
		}

		var temp = document.getElementsByName("titles");
        var tempFlag=true;
        for(var i=0;i<temp.length;i++){
        	if(temp[i].checked==true){
        		tempFlag=false;
        	}
        }
        if(tempFlag){
			alert("请选择申请标题！");
			return false;
		}

        
        if(temp[0].checked){
        	if($F('starttime').trim()==""){
				alert("开始时间不能为空！");
				return false;
			}
			if($F('endtime').trim()==""){
				alert("结束时间不能为空！");
				return false;
			}
			if(!checkDate("starttime","endtime")){
				alert("开始时间需小于结束时间！");
				return false;
			}
        }
        if(temp[1].checked){
        	if($F('unlocktime').trim()==""){
				alert("解锁时间不能为空！");
				return false;
			}
        }
		if($F('remark').strlen()>2000){
			alert("备注信息不能大于"+Math.floor(2000/strByteFlag)+"个汉字！");
			return false;
		}
		if(confirm("是否确认提交")){
			document.forms[0].submit();
		}
	}

	function setOrg(url){
		 
		var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if("_resetall"==temp){
			document.forms[0].orgname.value = "";
			return false;
		}
		if(null!=temp && temp.split("|").length>1){
			document.forms[0].orgname.value = temp.split("|")[1];
		}		

	}

	function showDelay(){
		if(document.getElementById("chb1").checked){
			document.getElementById("delay").style.display="block";
		}else{
			document.getElementById("delay").style.display="none";
			document.forms[0].starttime.value = "";
			document.forms[0].endtime.value = "";
		}
	}

	function showUnlock(){
		if(document.getElementById("chb2").checked){
			document.getElementById("unlock").style.display="block";
		}else{
			document.getElementById("unlock").style.display="none";
			document.forms[0].unlocktime.value = "";
		}
	}
	
	function hidDelay(){
		document.getElementById("delay").style.display="none";
		document.forms[0].starttime.value = "";
		document.forms[0].endtime.value = "";
	}

	//开始日期小于结束日期
	function checkDate(beginDateTextId,endDateTextId){
		var startDateTime = document.getElementById(beginDateTextId).value;
		var endDateTime = document.getElementById(endDateTextId).value;
		if(startDateTime>=endDateTime){
			return false;
		}
		return true;
	}

	function init(title){
		if(title=="01"){
			document.getElementById("delay").style.display="block";
			document.getElementById("unlock").style.display="block";
			document.getElementById("chb1").checked=true;
			document.getElementById("chb2").checked=true;
		}
		if(title=="0"){
			document.getElementById("delay").style.display="block";
			document.getElementById("chb1").checked=true;
		}
		if(title=="1"){
			document.getElementById("unlock").style.display="block";
			document.getElementById("chb2").checked=true;
		}
	}
	
	WebCalendar.timeShow   = true;
</script>

<body onload="init('${IGDUT0401Form.title}')">
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
        <p class="fonts1">服务管理 &gt;&gt; 值班管理 &gt;&gt; <logic:equal
	name="IGDUT0401Form" property="mode" value="0">
	                                             延时、解锁登记
	                </logic:equal> <logic:equal name="IGDUT0401Form" property="mode"
	value="1">
					延时、解锁变更
					</logic:equal></p>
	<logic:equal name="IGDUT0401Form" property="mode" value="1">
	<div class="back"><a href="IGDUT0402_Back.do" target="_self">返回</a></div>
	</logic:equal>
     </div>
      
   <div id="formwrapper">
       <html:form action="/IGDUT0401.do" method="post">
       <ig:message />
        <fieldset>
        <legend>延时、解锁信息设定</legend>
        <div>
          <label for="Name"><strong><span class="red">*</span>登记日期</strong>：</label>
          	 <html:text name="IGDUT0401Form" property="datetime" size="16" readonly="true" />
	                        <img src="<%=contextPath %>/images/date.gif" onClick="calendar($('datetime'))" border="0" />
          <br />
        </div>
        
        <div>
       		<label for="Name"><strong><span class="red">*</span>申请单位</strong>：</label>
		 	<html:text name="IGDUT0401Form" property="orgname" readonly="true"></html:text>
			<img src="images/tree.gif" style="cursor: hand;" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_TREE.do');" alt="请选择机构"/>
			<br/>
		</div>
		
		<div>
			<label for="Name"><strong><span class="red">*</span>申请（标题）</strong>：</label>
			延时<html:multibox styleId="chb1" property="titles" value="0" onclick="showDelay()"></html:multibox>
			解锁<html:multibox styleId="chb2" property="titles" value="1" onclick="showUnlock()"></html:multibox>
			<br/>
		</div>
		
		<div id="delay" style="display: none;">
			<label for="Name"><strong><span class="red">*</span>延时开始时间</strong>：</label>
				<html:text property="starttime" size="16" readonly="true" />
	                        <img src="<%=contextPath %>/images/date.gif" onClick="calendar($('starttime'))" border="0" />
	        <br/>
			<label for="Name"><strong><span class="red">*</span>延时结束时间</strong>：</label>
				<html:text property="endtime" size="16" readonly="true" />
	                        <img src="<%=contextPath %>/images/date.gif" onClick="calendar($('endtime'))" border="0" />
			<br/>
		</div>
		
		<div id="unlock" style="display: none;">
			<label for="Name"><strong><span class="red">*</span>解锁时间</strong>：</label>
				<html:text property="unlocktime" size="16" readonly="true" />
	                        <img src="<%=contextPath %>/images/date.gif" onClick="calendar($('unlocktime'))" border="0" />
	        <br/>
		</div>
		
        <div>
          <label for="Name"><strong>行长</strong>：</label>
          <html:text property="hzname" maxlength="5"/>
			<strong>电话</strong>：
           <html:text property="hztel" maxlength="16"/>
          <br />
        </div>
        
        <div>
            <label for="Name"><strong>经理</strong>：</label>
           <html:text property="jlname" maxlength="5"/>
           <strong>电话</strong>：
           <html:text property="jltel" maxlength="16"/>
            <br />
       </div>
       
       <div>
           <label for="Name"><strong>备注</strong>：</label>
    		<html:textarea property="remark" cols="80" rows="6"></html:textarea>
         <br />
        </div>

        <div>
           <label for="Name"><strong>操作人</strong>：</label>
    		<html:text property="operater" readonly="true"/>
         <br />
        </div>
        
        </fieldset>
    <div class="enter">
        <input name="save" type="button" class="button" value="提交" onclick="prjSubmit();" />
        <input name="cancel" type="reset" class="button" value="重置" />
    </div>
    <html:hidden property="id"/>
    <html:hidden property="mode" styleId="mode" name="IGDUT0401Form" />
    </html:form>
     </div>
   </div>

   </div>
  </div>


</div>
</body>
</html:html>