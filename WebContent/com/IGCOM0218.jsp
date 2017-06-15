<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>

<html:html>
<bean:define id="id" value="IGCOM0218" toScope="request" />
<bean:define id="title"  toScope="request" >
<bean:message bundle="comResources" key="ietitle.IGCOM0209"/>
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style>
.trbg{
	background-color: #E6F3FF;
}
</style>
<style type="text/css">
body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre, 
form,fieldset,input,textarea,p,blockquote,th,td { 
padding: 0; 
margin: 0; 
} 
table { 
border-collapse: collapse; 
border-spacing: 0; 
} 
fieldset,img { 
border: 0; 
} 
address,caption,cite,code,dfn,em,strong,th,var { 
font-weight: normal; 
font-style: normal; 
} 
ol,ul { 
list-style: none; 
} 
caption,th { 
text-align: left; 
} 
h1,h2,h3,h4,h5,h6 { 
font-weight: normal; 
font-size: 100%; 
} 
q:before,q:after { 
content:''; 
} 
abbr,acronym { border: 0; 
}
.ql {
	padding: 4px;
	height: 502px;
	width: 994px;
}
.ql_til {
	height: 50px;
	width: 100%;
	text-align: center;
	line-height: 50px;
	font-size: 18px;
	color: #1259a9;
	font-weight: bold;
	font-family: Arial, Helvetica, sans-serif;
}
.pro_report {
	float: left;
	height: 406px;
	width: 593px;
}
.reportil {
	background-image: url(images/titlebg.jpg);
	background-repeat: no-repeat;
	height: 28px;
	width: 593px;
	line-height: 28px;
	font-weight: bold;
	color: #FFF;
	text-align: center;
	font-size: 14px;
}
.voltil {
	background-image: url(images/titlebg2.jpg);
	background-repeat: no-repeat;
	height: 28px;
	width: 391px;
	line-height: 28px;
	font-weight: bold;
	color: #FFF;
	text-align: center;
	font-size: 14px;
}
.vol_report {
	float: right;
	height: 406px;
	width: 391px;
}
.tab_table {
	height: 352px;
	width: 591px;
	background-color: #FFF;
	border: 1px solid #6991bd;
	font-size: 12px;
	overflow: auto;
	overflow-x: hidden;
	word-break:break-all;
	word-wrap:break-word;
	
}
.tab_table2 {
	height: 352px;
	width: 389px;
	background-color: #FFF;
	border: 1px solid #6991bd;
	font-size: 12px;
	overflow: auto;
	overflow-x: hidden;
	word-break:break-all;
	word-wrap:break-word;
}
.t_til {
	background-image: url(images/qlstbg.gif);
	background-repeat: repeat-x;
	font-weight: bold;
	color: #0055a4;
	line-height: 23px;
}

table, th, td
  {
  	text-align:center;
	
  }
.tab_table table ,.tab_table2 table {
	border: 1px solid #EEE;
}

.tab_table table tr td ,.tab_table2 table tr td {
	height: 24px;
}
</style>
<script type="text/javascript">
		function delMyChoicesByAjax(Id){
	   		 var res;
 			 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
 					parameters: 'type=delMyChoiceRCL&Id='+Id,
 					 onSuccess: function(req, json){
 					 var result=req.responseText;
 						if(result != null && result != ""){
 							res=result;
 						}else{
 							return "";
 						}
 				    }
 				});
 			return res;
		}

		function gotoReport(rclReportType,rclObjName,rclObjType,rclObjEiid,rclMode,rclCaType,rclRfdTitle,rclTemName,rclTemDesc){
			if(rclReportType=='01'){
				var str1="IGRPT0301_Disp.do?rclReportType=01&rclObjName="
					+rclObjName
					+"&rclObjType="+rclObjType
					+"&rclRfdTitle="+encodeURI(encodeURI(rclRfdTitle))
					+"&rclCaType="+rclCaType
					+"&rclTemName="+rclTemName
					+"&rclTemDesc="+rclTemDesc;
					location.href=str1;
			}else if(rclReportType=='03'){
				var str2="IGRPT0301_Disp.do?rclReportType=03&rclObjName="
					+rclObjName
					+"&rclObjType="+rclObjType
					+"&rclObjEiid="+rclObjEiid
					+"&rclMode="+rclMode
					+"&rclCaType="+rclCaType;
					location.href=str2;
			}
		}
		//delete by id
       function delMySel(id,tr){
           if(confirm("<bean:message bundle='rptResources' key='igcom0218.deleteConfirm'/>")){
			if(id>0 ){
				if(delMyChoicesByAjax(id)){
					alert("<bean:message bundle='rptResources' key='igcom0218.deleteSUCC'/>! ");
					if($(tr)!=null){
						$(tr).style.display="none";
					}
				}else{
					alert("<bean:message bundle='rptResources' key='igcom0218.deleteFAID'/>");
				}
			}else{
				
			}
           }
       }
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div class="ql">
  <div class="ql_til"><bean:message bundle="rptResources" key="igcom0218.indexTitle"/></div>
  <div class="pro_report">
    <div class="reportil"><bean:message bundle="rptResources" key="igcom0218.rclReportType_Perf"/></div>
    <div class="tab_table">
          <table width="100%" border="0" cellpadding="0" cellspacing="0"  align="center">
            <tr class="t_til" >
              <td width="10%" align="center" valign="middle" ><bean:message bundle="rptResources" key="igcom0218.rclObjName"/></td>
              <td width="8%" align="center" valign="middle"><bean:message bundle="rptResources" key="igcom0218.rclObjType"/></td>
              <td width="10%" align="center" valign="middle"><bean:message bundle="rptResources" key="igcom0218.rclRfdTitle"/></td>
              <td width="6%" align="center" valign="middle"><bean:message bundle="rptResources" key="igcom0218.timeType"/></td>
              <td width="5%" align="center" valign="middle"><bean:message bundle="rptResources" key="igcom0218.OP"/></td>
            </tr>
            <logic:present name="IGRPT02001VO" property="reportCustomLinkList_Pref">
				<logic:iterate id="bean" property="reportCustomLinkList_Pref" name="IGRPT02001VO" indexId="index">
					<tr id="perftr${bean.rclId}" <c:if test="${index%2==1 }">class='trbg'</c:if>>
						<td><a href="javascript:gotoReport('01','${bean.rclObjName}','${bean.rclObjType}','','','${bean.rclCaType}','${bean.rclRfdTitle}','${bean.rclTemName}','${bean.rclTemDesc}')">${bean.rclObjName}</a></td>
						<td>${bean.rclObjType}</td>
						<td>${bean.rclRfdTitle}</td>
						<td>
								<c:if test="${bean.rclCaType=='1'}"><bean:message bundle="rptResources" key="igcom0218.mode1"/></c:if>
								<c:if test="${bean.rclCaType=='2'}"><bean:message bundle="rptResources" key="igcom0218.mode2"/></c:if>
								<c:if test="${bean.rclCaType=='3'}"><bean:message bundle="rptResources" key="igcom0218.mode3"/></c:if>
								<c:if test="${bean.rclCaType=='4'}"><bean:message bundle="rptResources" key="igcom0218.mode4"/></c:if>
								<c:if test="${bean.rclCaType=='5'}"><bean:message bundle="rptResources" key="igcom0218.mode5"/></c:if>
						</td>
						<td><a href="javascript:delMySel('${bean.rclId}','perftr${bean.rclId}')"><img src="images/delete.gif" alt='<bean:message bundle="rptResources" key="igcom0218.delete"/>' width="16" height="16" border="0"/></a></td>
					</tr>
				</logic:iterate> 
			</logic:present>
          
          </table>
        </div>
  </div>
  <div class="vol_report">
    <div class="voltil"><bean:message bundle="rptResources" key="igcom0218.rclReportType_Cap"/></div>
    <div class="tab_table2">
          <table width="100%" border="0" cellpadding="0" cellspacing="0"  align="center">
            <tr class="t_til" >
              <td align="center" width="40%" valign="middle" ><bean:message bundle="rptResources" key="igcom0218.rclObjName"/></td>
              <td align="center" width="30%" valign="middle"><bean:message bundle="rptResources" key="igcom0218.rclObjType"/></td>
              <td align="center" width="30%" valign="middle"><bean:message bundle="rptResources" key="igcom0218.OP"/></td>
            </tr>
            <logic:present name="IGRPT02001VO" property="reportCustomLinkList_Cap">
				<logic:iterate id="bean" property="reportCustomLinkList_Cap" name="IGRPT02001VO" indexId="index">
					<tr id="captr${bean.rclId}" <c:if test="${index%2==1 }">class='trbg'</c:if>>
						<td ><a href="javascript:gotoReport('03','${bean.rclObjName}','${bean.rclObjType}','${bean.rclObjEiid}','${bean.rclMode}','${bean.rclCaType}','','','')">${bean.rclObjName}</a></td>
						<td >
								<c:if test="${bean.rclObjType!='host'}">${bean.rclObjType}</c:if>
								<c:if test="${bean.rclObjType=='host'}">${bean.rclCaType}</c:if>
						</td>
						<td><a href="javascript:delMySel('${bean.rclId}','captr${bean.rclId}')"><img src="images/delete.gif" alt='<bean:message bundle="rptResources" key="igcom0218.delete"/>' width="16" height="16" border="0"/></a></td>
					</tr>
				</logic:iterate>
			</logic:present>
          </table>
        </div>
  </div>
</div>

</div>
<div class="zishiying"></div>
</div>
</body>
</html:html>