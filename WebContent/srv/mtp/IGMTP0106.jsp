<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<base target="_self" >
<bean:define id="id" value="IGMTP0106" toScope="request" />
<bean:define id="title" value="日历选择画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<script type="text/javascript">
function back(year,month){
	var form = document.getElementById("submitForm");
	form.action="IGMTP0107_Disp.do?forward=back&showYear=" + year + "&showMonth=" + month ;
	form.submit();
}

function next(year,month){
	var form = document.getElementById("submitForm");
	form.action="IGMTP0107_Disp.do?forward=next&showYear=" + year + "&showMonth=" + month ;
	form.submit();
}

function next1(){
	if(window.confirm("您是否确认提交？")){
		var form = document.getElementById("submitForm");
		form.action="IGMTP0107_NEXT_SOC.do?";
		form.submit();
	}
	
}

function changeS(ch,date){
	//alert(5);
	var v=document.getElementById(ch).bgColor;
	if(v == '#adf795'){
		//选中改未选中状态
	document.getElementById(ch).bgColor = '#e6fdd9';
	//var a= document.getElementById(date);
	//alert(document.getElementById(date).value);
	document.getElementById(date).value = date+'_0';
	document.getElementById(date+'_l').innerHTML = '';
	
	}else{
			document.getElementById(ch).bgColor = '#adf795';
			document.getElementById(date).value = date+'_1';
			document.getElementById(date+'_l').innerHTML = '<img src=\"images/igmtp1.gif\" width=\"14\" height=\"18\" border=\"0\">';
			//alert(date+'_'+0);
		}
}

</script>
<!-- /header1 -->
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<!--container 左菜单 右侧内容-->
<div id="container">

<!--content  右侧内容-->
<div id="contentWrap">
    <div id="content">
       <div id="location">
           <div class="image"></div>
              <p class="fonts1">日历</p>
       </div>
       
       <form id="submitForm" method="post" >
       <div id="results_list">
	      <table width="700" border="0" align="center" cellspacing="0" cellpadding="0" style="margin-top:40px;">
	    	<tr height="20">
			  	<td width="26">
			  		<a href="#" onclick="back(${IGMTP01041VO.calendarYear},${IGMTP01041VO.calendarMonth});">
				  		<img src="images/up.gif" alt="上月" border="0" />
				  	</a>
			  	</td>
				<td width="26">
					<a href="#" onclick="next(${IGMTP01041VO.calendarYear},${IGMTP01041VO.calendarMonth + 1});">
						<img src="images/next.gif" alt="下月" border="0" />
					</a>
				</td>
				<td width="145" align="left" style="font-size:14px; font-weight:bold">
				${IGMTP01041VO.calendarYear}年${IGMTP01041VO.calendarMonth + 1}月</td>
				<td width="426">&nbsp;</td>
				<td width="239" align="right" style="font-weight:bold">
					计划开始时间：${begin_time}
					<input type="hidden" name="begin_time" value="${begin_time}">
				</td>
				<td width="238" align="right" style="font-weight:bold">
					计划结束时间：${end_time}
					<input type="hidden" name="end_time" value="${end_time}">
					
				</td>
		  	</tr>
		  </table>
        <table width="710" border="0" cellspacing="1" cellpadding="4"  bgcolor="#7CA8FE"  align="center" >
		  <tr height="20" align="center" style="font-size:14px;">
			<td width="100" bgcolor="#9DBEFF">星期日</td>
			<td width="100" bgcolor="#9DBEFF">星期一</td>
			<td width="100" bgcolor="#9DBEFF">星期二</td>
			<td width="100" bgcolor="#9DBEFF">星期三</td>
			<td width="100" bgcolor="#9DBEFF">星期四</td>
			<td width="100" bgcolor="#9DBEFF">星期五</td>
			<td width="100" bgcolor="#9DBEFF">星期六</td>
		  </tr>
		  <logic:iterate id="row" name="IGMTP01041VO" property="weekVOList">
		   <tr height="41">
		   <logic:iterate id="cell" name="row" property="cellVOList">
		   <logic:equal property="bgColor" name="cell" value="#EFEFEF">
		   	<td bgcolor="${cell.bgColor}">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
	              		<tr height="20">
			                <td style="font-size:16px;">${cell.showDay}</td>
			                <td>&nbsp;</td>
			                <td>&nbsp;</td>
	              		</tr>
			            <tr height="20">
				            <td>
					            <logic:equal name="cell" property="link" value="0">
					            	${cell.img}
					            </logic:equal>
				            </td>
			            </tr>
	            	</table>
	            </td>
		   </logic:equal>
		    <logic:equal property="bgColor" name="cell" value="#ADF795" >
					<logic:equal name="cell" property="dateYMD" value="${todayYMD}">
						<td bgcolor="${cell.bgColor}"
							id="${cell.showDay}">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr height="20">
								<td style="font-size: 16px;">${cell.showDay}</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
							<tr height="20">
								<td id="${cell.dateYMD}_l"><logic:equal name="cell"
									property="link" value="0">
									<!--					            <div id="${cell.dateYMD}_l">-->
					            	${cell.img}
<!--					            	</div>-->
								</logic:equal></td>
							</tr>
						</table>
						<input type="hidden" name="selectedCheck" id="${cell.dateYMD}"
							value="${cell.dateYMD}_${cell.selectedDate}" /></td>
					</logic:equal>
<logic:notEqual name="cell" property="dateYMD" value="${todayYMD}">
<td bgcolor="${cell.bgColor}"
							onclick="javascript:changeS('${cell.showDay}','${cell.dateYMD}')"
							id="${cell.showDay}">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr height="20">
								<td style="font-size: 16px;">${cell.showDay}</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
							<tr height="20">
								<td id="${cell.dateYMD}_l"><logic:equal name="cell"
									property="link" value="0">
									<!--					            <div id="${cell.dateYMD}_l">-->
					            	${cell.img}
<!--					            	</div>-->
								</logic:equal></td>
							</tr>
						</table>
						<input type="hidden" name="selectedCheck" id="${cell.dateYMD}"
							value="${cell.dateYMD}_${cell.selectedDate}" /></td>

</logic:notEqual>

				</logic:equal>
		   <logic:equal property="bgColor" name="cell" value="#E6FDD9">
		   	<td bgcolor="${cell.bgColor}" onclick="javascript:changeS('${cell.showDay}','${cell.dateYMD}')" id="${cell.showDay}">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
	              		<tr height="20">
			                <td style="font-size:16px;">${cell.showDay}</td>
			                <td>&nbsp;</td>
			                <td>&nbsp;</td>
	              		</tr>
			            <tr height="20">
				            <td id="${cell.dateYMD}_l">
					            <logic:equal name="cell" property="link" value="0">
<!--					            	<div id="${cell.dateYMD}_l">-->
					            	${cell.img}
<!--					            	</div>-->
					            </logic:equal>
				            </td>
			            </tr>
	            	</table>
	            	<input type="hidden" name="selectedCheck" id="${cell.dateYMD}" value="${cell.dateYMD}_${cell.selectedDate}"/>
	            </td>
		   </logic:equal>
		   <logic:equal property="bgColor" name="cell" value="#FFFFFF">
				<td bgcolor="${cell.bgColor}" >
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
	              		<tr height="20">
			                <td style="font-size:16px;">${cell.showDay}</td>
			                <td>&nbsp;</td>
			                <td>&nbsp;</td>
	              		</tr>
			            <tr height="20">
				            <td>
					            <logic:equal name="cell" property="link" value="0">
					            	${cell.img}
					            </logic:equal>
				            </td>
			            </tr>
	            	</table>
	            </td>
	          </logic:equal>
	          
            </logic:iterate>
		  </tr>
		  </logic:iterate>
		  
		  
		</table>
		  <table width="488" border="0" cellspacing="5" cellpadding="0"  align="center" style="margin-top:10px;">
            <tr height="12" align="center">
			  <td width="12" bgcolor="#EFEFEF"></td>
              <td width="60" align="left">不可选择</td>
			  <td width="12" bgcolor="#ADF795"></td>
              <td width="60" align="left">已选择</td>
			  <td width="12" bgcolor="#E6FDD9"></td>
              <td width="60" align="left">可以选择</td>
               <td width="12" ><img src="images/igmtp3.gif" width="14" height="18" border="0"/></td>
              <td width="60" align="left">当前日期</td>
               <td width="12"><img src="images/igmtp1.gif" width="14" height="18" border="0"/></td>
              <td width="60" align="left">未执行</td>
               <td width="12" ><img src="images/igmtp2.gif" width="14" height="18" border="0"/></td>
              <td width="60" align="left">已执行</td>
<!--              <td width="12" bgcolor="#AFEBEF"></td>-->
<!--              <td width="60" align="left">当前日期</td>          -->
            </tr>
          </table>
		  </div>
		  		  </form>
		  		  <div class="enter">
		  		  <html:submit styleClass="button" onclick="next1();" value="提交"/>
		  		  </div>
		  		   </div>
</div>
</div>
</div>
</body>
</html:html>