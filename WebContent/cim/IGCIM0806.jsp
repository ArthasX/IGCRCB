<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<html:html>
<bean:define id="id" value="IGCIM0805" toScope="request" />
<bean:define id="title" value="定时任务修改画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
	function checkForm(executstatus){
		
		var estatus = executstatus;
		var name = $F('typename').trim();
		var starthour = $F('starthour').trim();
		var startminute = $F('startminute').trim();
		var stophour = $F('stophour').trim();
		var stopminute = $F('stopminute').trim();
		var starttime = $F('starttime').trim();
		var stoptime = $F('stoptime').trim();
		var executstatus = $F('executstatus').trim();
		var periodTypes = document.getElementsByName("periodType");

		var periodType = '';
		for(var i = 0; i < periodTypes.length; i++){
			if(periodTypes[i].checked){
				periodType = periodTypes[i];
			}
		}
		
		if(name==""){
			alert("请输入采集项！");
			return false;
		}

		if(starttime==""){
			alert("请输入开始日期！");
			return false;
		}

		/**if(stoptime==""){
			alert("请输入结束日期！");
			return false;
		}**/

		if(starthour==""){
			alert("请选择开始小时！");
			return false;
		}
		if(startminute==""){
			alert("请选择开始分钟！");
			return false;
		}

		/**if(stophour==""){
			alert("请选择结束小时！");
			return false;
		}
		if(stopminute==""){
			alert("请选择结束分钟！");
			return false;
		}**/

		
		

		var D = new Date();
		var yy=D.getYear();
		var mm=D.getMonth()+1;
		var dd=D.getDate();
		var hours = D.getHours();
		var minute = D.getMinutes();

		if(mm < 10){
			mm = "0" + mm.toString();
		}
		if(dd < 10){
			dd = "0" + dd.toString();
		}
		if(hours < 10){
			hours = "0" + hours.toString();
		}
		if(minute < 10){
			minute = "0" + minute.toString();
		}

		var nowTime = yy + "/" + mm + "/" + dd + " " + hours + ":" + minute;
		var startDate = starttime + " " + starthour + ":" + startminute;
		var stopDate = stoptime + " " + stophour + ":" + stopminute;
	
		/**if(startDate < nowTime){
			alert("开始时间需要大于当前时间！");
			return false;
		}**/

		if(stoptime!=""){
			
			if(stophour==""){
				alert("请选择结束小时！");
				return false;
			}

			if(stopminute==""){
				alert("请选择结束分钟！");
				return false;
			}

			if( stopDate < startDate){
				alert("结束时间必须在开始时间之后！");
				return false;
			}
		}

		if(stophour!="" ){
			if(stoptime==""){
				alert("请输入结束日期！");
				return false;
			}
		}

		if(stopminute!=""){
			if(stophour==""){
				alert("请选择结束小时！");
				return false;
			}
		}

		if(estatus==""){
			alert("请选择操作！");
			return false;
		}

		if(periodType.value=='1' && estatus != '2'){

			if(startDate < nowTime){
				alert("仅一次, 开始时间需要大于当前时间！");
				return false;
			}

			if(stoptime==''){
				alert("仅一次, 需要添加结束时间");
				return false;
			}
		}
		
		/**if(estatus == '2'){
			if(confirm("是否确认停止?")){			
				return true;
			}
		}**/
		
		if(confirm("是否确认提交?")){
			$('executstatus').value=estatus;
			window.close();	
			return true;
		}else {
			return false;
		}
	}

	function onceClick(){
		$('stop_week').style.display = 'none';
		$('start_week').style.display = 'none';
		
	}

	window.onunload = function(){ 
		//var eid = $('eidStr').value;
		this.opener.parent.location.href = getAppRootUrl() + '/IGCIM0805_Search.do';
    };
</script>
<body >
<div id="maincontent">
<!--container 左菜单 右侧内容-->
<div id="container"  style="width:100%">
    
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1">配置管理 &gt;&gt;配置采集&gt;&gt;定时任务修改</p>
            </div><br />
            <div id="formwrapper">
                        	   
                   <html:form styleId="form" action="/IGCIM0806_EDIT" onsubmit="return checkSubmit(this);">
                   	<ig:message />
        			<fieldset>
        			<legend>采集规则</legend>
        			
        				<div>
        					<label for="Name"><strong>服务名</strong>：</label> 
          					<html:text property="name" readonly="true" size="20" errorStyleClass="inputError imeActive"/> <br />
		 				</div>
        				
        				<div>
        					<label for="Name"><strong>服务类型</strong>：</label> 
          					<html:text property="typename" readonly="true" size="20" errorStyleClass="inputError imeActive"/> <br />
		 				</div>
        				
        				<div>
	            			<label for="Name"><span class="red">*</span><strong>计划执行日期</strong>：</label>
	             			<html:text property="starttime" styleId="popentime" errorStyleClass="inputError imeDisabled" size="20" readonly="true"/>
       						<img src="images/date.gif" onClick="calendar($('starttime'))" border=0 />     
	          				<br />
      				    </div>

       					<div>
				            <label for="Name"><span class="red">*</span><strong>计划执行时间</strong>：</label>
				            
				           
				            
				            <html:select property="starthour">
				           	<html:option value=""></html:option>
					            <%for(int i = 0; i < 24; i++){ 
					            	if(i<10){%>
					            	<html:option value='<%="0"+String.valueOf(i) %>'><%="0"+String.valueOf(i) %></html:option>
					            <%} else{%>
					            	<html:option value='<%=String.valueOf(i) %>'><%=String.valueOf(i) %></html:option>
					            <%}}%>
				            
				          	</html:select>时
				           	<html:select property="startminute">
				           	<html:option value=""></html:option>
					           <%for(int i = 0; i < 60; i++){
					            	if(i<10){%>
					            	<html:option value='<%="0"+String.valueOf(i) %>'><%="0"+String.valueOf(i) %></html:option>
					            <%} else{%>
					            	<html:option value='<%=String.valueOf(i) %>'><%=String.valueOf(i) %></html:option>
					            <%}}%>
				          	</html:select>分
				          <br />
       					</div>
       					
       					<div>
	            			<label for="Name"><strong>计划终止日期</strong>：</label>
	             			<html:text property="stoptime" styleId="popentime" errorStyleClass="inputError imeDisabled" size="20" readonly="true"/>
       						<img src="images/date.gif" onClick="calendar($('stoptime'))" border=0 />     
	          				<br />
      				    </div>
       					
       					<div>
				            <label for="Name"><strong>计划终止时间</strong>：</label>
				            <html:select property="stophour">
				           	<html:option value=""></html:option>
					            <%for(int i = 0; i < 24; i++){ 
					            	if(i<10){%>
					            	<html:option value='<%="0"+String.valueOf(i) %>'><%="0"+String.valueOf(i) %></html:option>
					            <%} else{%>
					            	<html:option value='<%=String.valueOf(i) %>'><%=String.valueOf(i) %></html:option>
					            <%}}%>
				            
				          	</html:select>时
				           	<html:select property="stopminute">
				           	<html:option value=""></html:option>
					           <%for(int i = 0; i < 60; i++){
					            	if(i<10){%>
					            	<html:option value='<%="0"+String.valueOf(i) %>'><%="0"+String.valueOf(i) %></html:option>
					            <%} else{%>
					            	<html:option value='<%=String.valueOf(i) %>'><%=String.valueOf(i) %></html:option>
					            <%}}%>
				          	</html:select>分
				          <br />
       					</div>
       					
       					<div>
          				   <label for="Name"><span class="red">*</span><strong>周期类型</strong>：</label>
          				   
           					<html:radio property="periodtype" value="1" />仅一次
           					<html:radio property="periodtype" value="2" />日
           					<html:radio property="periodtype" value="3" />周
           					<html:radio property="periodtype" value="4" />月
           					
           					<!-- <input name="periodType" type="radio" value="quarter" onclick="" />季度 -->
       					 </div>
       					
       					<div>
       						<label for="Name"><strong>状态</strong>：</label>
       						
       						<c:if test="${IGCIM0806Form.executstatus == '1'}">
                    			&nbsp<img src="images/start.gif" border="0" alt="启动"/>
                    		</c:if>
                    		<c:if test="${IGCIM0806Form.executstatus == '2'}">
                    			&nbsp<img src="images/stop.gif" border="0" alt="停用"/>
                    		</c:if>
       					</div>
       					
        			</fieldset>
        			
        			<div class="enter">
        				<html:hidden property="uuid"/>
        				<html:hidden property="executstatus"/>
        				<html:submit property="submit" styleClass="button" value="启动" onclick="return checkForm('1');" />
        				<html:submit property="submit" styleClass="button" value="停止" onclick="return checkForm('2');" />
						<html:reset styleClass="button" value="重置" />
					</div>
					
                   </html:form>
                   
                   
            </div>
                
                <div id="results_list">
					<!--  message -->
					<ig:message />
					<!--  /message -->
				</div>
				<div id="operate">
	             <jsp:include page="/include/paging.jsp" />
                </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>