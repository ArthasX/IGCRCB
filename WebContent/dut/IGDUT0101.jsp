<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDUT0101" toScope="request" />
<bean:define id="title" value="值班检查设定基本信息画面" toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
		function timeShow(){
			time.style.display="";
	    }

		//检查时间的添加
	    function add(){
		    
			var obj = $("dattimes").options;
			var time = $F("selectXiao") + ":" + $F("selectFen");

	    	//校验是否存在重复时间
	    	for(var i = 0;  i < obj.length; i++){
		    	if(time == obj[i].value){
			    	alert("已存在输入的时间！");
			    	return false;
			    }
    	    }
    	    
			obj.add(new Option(time,time));
	    	
		}

		//检查时间的删除
		function del(){
			
			var obj = $("dattimes");
			var count = 0;
			for(var i = 0; i < obj.options.length; i++){
				if(obj.options[i].selected){
					obj.options.remove(i--);
					count=1;
				}
			}
			if(count == 0){
				alert("请您选中要删除的检查时间后，再点击删除。");
			}
		 }

		function confirmDisp(){
			var message = '';
            if ('${IGDUT0101Form.mode}' == '0'){
                message = '<bean:message key="IGCO10000.W001" arg0="值班检查基本信息" />';
            } else {
                message = '<bean:message key="IGCO10000.W003" arg0="值班检查基本信息" />';
            }
            if($F('dadname').trim()==""){
	    		alert("请输入检查名称！");
	    		return false;
	    	}
	    	if($F('dadname').strlen()>128){
	    		alert("检查名称不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
	    		return false;
	    	}

	    	if($("dattimes").options.length==0){
	    		alert("请增加检查时间！");
	    		return false;
	    	}

	    	if($F("dadorderby").trim()==""){
	    		alert("请输入检查项排序！");
	    		return false;
	    	}
	    	
	    	var reg=/^\d+$/;
			if(!reg.test($F("dadorderby"))){
				alert("检查项排序必须为数字！");
				return false;
			}
			
            var selects = $("dattimes").options;
    		for(var i=0;i < selects.length;i++){ 
                //将检查时间全部选中
    			selects[i].selected = true; 
    		} 
    		
			if( window.confirm(message)){
				return true;
			} else {
				return false;
			}
		}

       function deldattimes(){
	        var obj = $("dattimes");
	        var selLen=document.getElementById("dattimes").options.length;
	        for(var i=0;i<selLen;i++){
		        obj.options.remove(0);
	        }
        }

       function showCustomDate(){
    		var periodTypes = document.getElementsByName("periodType");
    		var showDayDIV = false;
    		var showWeekDIV = false;
    		var showMonthDIV = false;
    		var showQuarterDIV = false;
    		for(var i = 0; i < periodTypes.length; i++){
    			if(periodTypes[i].checked && periodTypes[i].value == "day"){
    				showDayDIV = true;
    				break;
    			}
    			if(periodTypes[i].checked && periodTypes[i].value == "week"){
    				showWeekDIV = true;
    				break;
    			}
    			if(periodTypes[i].checked && periodTypes[i].value == "month"){
    				showMonthDIV=true;
    				break;
    			}
    			if(periodTypes[i].checked && periodTypes[i].value == "quarter"){
    				showQuarterDIV = true;
    				break;
    			}
    		}
    		if(showDayDIV){
    			document.getElementById("weekDIV").style.display = "none"; 
    			document.getElementById("monthDIV").style.display = "none"; 
    			document.getElementById("quarterDIV").style.display = "none"; 
    		}
    		if(showWeekDIV){
    			document.getElementById("weekDIV").style.display = ""; 
    			document.getElementById("monthDIV").style.display = "none"; 
    			document.getElementById("quarterDIV").style.display = "none"; 
    		}
    		if(showMonthDIV){
    			document.getElementById("weekDIV").style.display = "none"; 
    			document.getElementById("monthDIV").style.display = ""; 
    			document.getElementById("quarterDIV").style.display = "none"; 
    		}
    		if(showQuarterDIV){
    			document.getElementById("weekDIV").style.display = "none"; 
    			document.getElementById("monthDIV").style.display = "none"; 
    			document.getElementById("quarterDIV").style.display = ""; 
    		}
    	}
   	
       function inti(){
    	   if('${IGDUT0101Form.periodType}'=='week'){
    		document.getElementById("radio_week").checked=true;
   			document.getElementById("weekDIV").style.display = ""; 
   			document.getElementById("monthDIV").style.display = "none"; 
   			document.getElementById("quarterDIV").style.display = "none"; 
   			}else if('${IGDUT0101Form.periodType}'=='month'){
       			document.getElementById("radio_month").checked=true;
      			document.getElementById("weekDIV").style.display = "none"; 
      			document.getElementById("monthDIV").style.display = ""; 
      			document.getElementById("quarterDIV").style.display = "none"; 
      		}else if('${IGDUT0101Form.periodType}'=='quarter'){
       			document.getElementById("radio_quarter").checked=true;
      			document.getElementById("weekDIV").style.display = "none"; 
      			document.getElementById("monthDIV").style.display = "none"; 
      			document.getElementById("quarterDIV").style.display = ""; 
      		}else{
      			document.getElementById("radio_day").checked=true;
      			document.getElementById("weekDIV").style.display = "none"; 
      			document.getElementById("monthDIV").style.display = "none"; 
      			document.getElementById("quarterDIV").style.display = "none"; 
          	}
       }
	</script>
<body onload="inti();">
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">

<div id="location">
<div class="image"></div>
<p class="fonts1">服务管理&gt;&gt; 值班管理 &gt;&gt; <logic:equal
	name="IGDUT0101Form" property="mode" value="0">
	                                             值班检查设定
	                </logic:equal> <logic:equal name="IGDUT0101Form" property="mode"
	value="1">
					  值班检查变更
					</logic:equal></p>
<logic:equal name="IGDUT0101Form" property="mode" value="1">
	<div class="back"><a href="IGDUT0102_Back.do" target="_self">返回</a></div>
</logic:equal></div>

<div id="formwrapper"><html:form styleId="form"
	action="/IGDUT0101" onsubmit="return checkSubmit(this);">
	<!--  message -->
	<ig:message />
	<!--  /message -->
	<fieldset><logic:equal name="IGDUT0101Form" property="mode"
		value="0">
		<legend> 值班检查信息设定</legend>
		<div><label for="checkName"><strong><span
			class="red">*</span>检查分类</strong>：</label> <html:select property="dadtype"
			name="IGDUT0101Form">
			<ig:optionsCollection ccid="DUTY_TYPE"
				type="${IGDUT0101Form.dadcategory}" isMakeBlankRow="false"
				isCodeLabel="true" />
		</html:select></div>
	</logic:equal> <logic:equal name="IGDUT0101Form" property="mode" value="1">
		<legend>值班检查信息变更</legend>
		<html:hidden property="dadid" styleId="dadcategory"
			name="IGDUT0101Form" />
		<div><label for="checkName"><strong><span
			class="red">*</span>检查分类</strong>：</label> <html:select property="dadtype"
			name="IGDUT0101Form" disabled="true">
			<ig:optionsCollection ccid="DUTY_TYPE" isMakeBlankRow="false"
				isCodeLabel="true" />
		</html:select></div>

	</logic:equal>




	<div><label for="checkName"><strong><span
		class="red">*</span>检查名称</strong>：</label> <html:text property="dadname"
		name="IGDUT0101Form" size="18" style="width:200px;"
		errorStyleClass="inputError" /></div>

	<div><label for="checkTime"><strong><span
		class="red">*</span>检查时间</strong>：</label> <span> <html:select
		property="dattimes" multiple="multiple" size="6" style="width:100px">
		<html:options collection="ADtimelist" property="value" name="time"
			labelProperty="label" />
	</html:select> </span> <span>小时</span><select name="selectXiao">
		<option>00</option>
		<option>01</option>
		<option>02</option>
		<option>03</option>
		<option>04</option>
		<option>05</option>
		<option>06</option>
		<option>07</option>
		<option>08</option>
		<option>09</option>
		<option>10</option>
		<option>11</option>
		<option>12</option>
		<option>13</option>
		<option>14</option>
		<option>15</option>
		<option>16</option>
		<option>17</option>
		<option>18</option>
		<option>19</option>
		<option>20</option>
		<option>21</option>
		<option>22</option>
		<option>23</option>
	</select> <span>分钟</span><select name="selectFen">
		<option>00</option>
		<option>15</option>
		<option>30</option>
		<option>45</option>
	</select> <input name="按钮" type="button" value="增加" onclick="add()" /> <input
		name="按钮" type="button" value="删除" onclick="del()" /></div>

	<div><label for="timeLimit"><strong><span
		class="red">*</span>填报时间限制</strong>：</label> <html:select property="dadlimtime"
		name="IGDUT0101Form">
		<ig:optionsCollection ccid="DUTY_LIMIT_TIME" isMakeBlankRow="false"
			isCodeLabel="true" />
	</html:select> 分钟内</div>

	<div><label for="checkResult"><strong><span
		class="red">*</span>检查结果</strong>：</label> <html:select property="dadcontent"
		name="IGDUT0101Form">
		<ig:optionsCollection ccid="DUTY_CONTENT" isMakeBlankRow="false"
			isCodeLabel="true" />
	</html:select> <br />
	</div>

	<div><label for="checkName"><strong>结果说明</strong>：</label> <html:select
		property="dadinfo" name="IGDUT0101Form">
		<ig:optionsCollection ccid="DUTY_INFO" isMakeBlankRow="false"
			isCodeLabel="true" />
	</html:select></div>

	<div>
		<label for="checkName"><span
		class="red">*</span><strong>检查项排序</strong>：</label>
		<html:text property="dadorderby"
		name="IGDUT0101Form" size="3" maxlength="3"
		errorStyleClass="inputError" />
	</div>
	<div>
        <label for="Name"><span class="red">*</span><strong>周期类型</strong>：</label>
        <input name="periodType" type="radio" id="radio_day" value="day"  onclick="showCustomDate();"/>日
        <input name="periodType" type="radio" id="radio_week" value="week" onclick="showCustomDate();" />周
        <input name="periodType" type="radio" id="radio_month" value="month" onclick="showCustomDate();" />月
		<input name="periodType" type="radio" id="radio_quarter" value="quarter" onclick="showCustomDate();" />季度
    </div>
    <div id="weekDIV">
        <label for="Name"><span class="red">*</span><strong>周期时间</strong>：</label>
        <html:select property="week_value" name="IGDUT0101Form">
        <html:option value="星期日">星期日</html:option>
		<html:option value="星期一">星期一</html:option>
		<html:option value="星期二">星期二</html:option>
		<html:option value="星期三">星期三</html:option>
		<html:option value="星期四">星期四</html:option>
		<html:option value="星期五">星期五</html:option>
		<html:option value="星期六">星期六</html:option>
        </html:select>
    </div>
    <div id="monthDIV">
        <label for="Name"><span class="red">*</span><strong>周期时间</strong>：</label>
        <html:select property="month_value" name="IGDUT0101Form">
		<html:option value="01">01</html:option>
		<html:option value="02">02</html:option>
		<html:option value="03">03</html:option>
		<html:option value="04">04</html:option>
		<html:option value="05">05</html:option>
		<html:option value="06">06</html:option>
		<html:option value="07">07</html:option>
		<html:option value="08">08</html:option>
		<html:option value="09">09</html:option>
		<html:option value="10">10</html:option>
		<html:option value="11">11</html:option>
		<html:option value="12">12</html:option>
		<html:option value="13">13</html:option>
		<html:option value="14">14</html:option>
		<html:option value="15">15</html:option>
		<html:option value="16">16</html:option>
		<html:option value="17">17</html:option>
		<html:option value="18">18</html:option>
		<html:option value="19">19</html:option>
		<html:option value="20">20</html:option>
		<html:option value="21">21</html:option>
		<html:option value="22">22</html:option>
		<html:option value="23">23</html:option>
		<html:option value="24">24</html:option>
		<html:option value="25">25</html:option>
		<html:option value="26">26</html:option>
		<html:option value="27">27</html:option>
		<html:option value="28">28</html:option>
		<html:option value="29">29</html:option>
		<html:option value="30">30</html:option>
		<html:option value="31">31</html:option>
        </html:select>号
    </div>
    <div id="quarterDIV">
        <label for="Name"><span class="red">*</span><strong>周期时间</strong>：</label>
        <html:select property="quarter_monthValue">
        <html:option value="one">第一个</html:option>
        <html:option value="two">第二个</html:option>
        <html:option value="three">第三个</html:option>
        </html:select>月
        <html:select property="quarter_dayValue">
       	<html:option value="01">01</html:option>
		<html:option value="02">02</html:option>
		<html:option value="03">03</html:option>
		<html:option value="04">04</html:option>
		<html:option value="05">05</html:option>
		<html:option value="06">06</html:option>
		<html:option value="07">07</html:option>
		<html:option value="08">08</html:option>
		<html:option value="09">09</html:option>
		<html:option value="10">10</html:option>
		<html:option value="11">11</html:option>
		<html:option value="12">12</html:option>
		<html:option value="13">13</html:option>
		<html:option value="14">14</html:option>
		<html:option value="15">15</html:option>
		<html:option value="16">16</html:option>
		<html:option value="17">17</html:option>
		<html:option value="18">18</html:option>
		<html:option value="19">19</html:option>
		<html:option value="20">20</html:option>
		<html:option value="21">21</html:option>
		<html:option value="22">22</html:option>
		<html:option value="23">23</html:option>
		<html:option value="24">24</html:option>
		<html:option value="25">25</html:option>
		<html:option value="26">26</html:option>
		<html:option value="27">27</html:option>
		<html:option value="28">28</html:option>
		<html:option value="29">29</html:option>
		<html:option value="30">30</html:option>
		<html:option value="31">31</html:option>
        </html:select>号
    </div>

	</fieldset>
	<div class="enter"><html:submit property="btn_insert" value="提交"
		styleClass="button" onclick="return confirmDisp();" /> <html:reset
		property="btn_clear" styleClass="button" value="重置"
		onclick="deldattimes()" /></div>
	<html:hidden property="dadcategory" styleId="dadcategory"
		name="IGDUT0101Form" />
	<html:hidden property="dadstatus" styleId="dadstatus"
		name="IGDUT0101Form" />
	<html:hidden property="mode" styleId="mode" name="IGDUT0101Form" />
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>