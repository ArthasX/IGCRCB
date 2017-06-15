<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="" toScope="request"/>
<bean:define id="title" value="" toScope="request"/>

<jsp:include page="/include/header1.jsp"/>

<style media=print>
.Noprint{
	display:none;
}
</style>
<style>
.prings{
	font-size: 29px;
	font-family: "黑体";
	font-weight:bold;
    text-align:center;
    table-layout:fixed; 
    height:300px;
    border:1px solid black;
}
.prings td{
    word-break: break-all; 
    word-wrap:break-word;    
}
</style>
<script>

</script>
<body >
<div id="maincontent">

<!--container 左菜单 右侧内容-->
<div id="container">
 
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
<html:form styleId="form" action="/IGASM1120_Disp"
             onsubmit="return checkSubmit(this);">
                  
                               
                <div id="results_list">
					 
			       <table  border="1"  class="prings" >
			         
			            <!-- body部 -->			  
			                <logic:present name="IGASM11201VO" property="eilist" >
			                <bean:define id="eilist" name="IGASM11201VO" property="eilist"/>
			                    <logic:iterate id="bean" name="eilist">
			                        <tr style="border:0px solid #ff00ff;">			                        
			                      <logic:empty name="bean" property="businesssys">
			                        <td style="border:0px solid #ff00ff;">
			                        ${bean.einame}${bean.pattern }( ${bean.ip })
			                        </td>
			                       </logic:empty>
			                        <logic:notEmpty name="bean" property="businesssys">
			                        <td style="border:0px solid #ff00ff;">
			                        ${bean.businesssys }(${bean.ip })
			                        </td>
			                      </logic:notEmpty > 
			                        </tr>        
			                    </logic:iterate>
			                </logic:present>
			       </table>
			       <OBJECT classid=CLSID:8856F961-340A-11D0-A96B-00C04FD705A2 height=0 id=WebBrowser width=0></OBJECT>
			     </div>
			     <div align="center">
			      <input type="button" class="Noprint" value="  打印  " style="
	color:#FFFFFF;
	padding:1px 10px;
	font-size:12px;
	border:2px outset #EEEEEE;
	background-color: #6699CC;
	cursor: hand;
	height:20px;" onClick=document.all.WebBrowser.ExecWB(6,1)>
<input type="button" class="Noprint" value="打印预览" style="
	color:#FFFFFF;
	padding:1px 10px;
	font-size:12px;
	border:2px outset #EEEEEE;
	background-color: #6699CC;
	cursor: hand;
	height:20px;" onClick=document.all.WebBrowser.ExecWB(7,1) >
			     
			      </div>
			     <div id="operate">
			               
			    </div>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>

</div>

</body>
</html:html>