<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGDRM0605" toScope="request"/>
<bean:define id="title" value="演练计划内发起" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<style type="text/css">
#results_list INPUT{
	height: 18px;
}
.table_style,.tdtitle {
	border:1px solid #d3d3d3;
}
</style>

<body onload="startCheckOpenerClosed();">
<div id="maincontent">
<jsp:include page="/include/header2.jsp" />
<div id="container">

<!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">

	<html:form styleId="form" action="/IGDRM0604" onsubmit="return checkSubmit(this);">
		<div id="location">
        	<div class="image"></div>
            <p class="fonts1"><ig:navigation/></p>
		</div>
        <div id="search">
            <div class="img"></div>
            <div class="conditions">
                <div>
                	<!-- <label><span class="red"></span>演练计划编号：</label>  -->
                           
                    <%-- <html:text property="dserial" styleId="dserial" errorStyleClass="inputError imeActive" readonly="" tabindex="1"/> --%>
	               
	                <label>&nbsp;&nbsp;演练计划名称：</label>
	               
	                <html:text property="dname" styleId="dname" errorStyleClass="inputError imeDisabled" size="12" tabindex="2"/>
	               
	                <label>&nbsp;演练任务名称：</label><html:text property="diname" errorStyleClass="inputError imeDisabled" size="12"/>
	              
	                <%-- <label>&nbsp;&nbsp;&nbsp;&nbsp;登记人ID：</label>
	               
	                <html:text property="duserid" styleId="duserid" errorStyleClass="inputError imeDisabled" size="12" tabindex="3" />
	                <br/>
	                <label>&nbsp;&nbsp;&nbsp;&nbsp;登记人姓名：</label>
	               
	                <html:text property="dusername" styleId="dusername" errorStyleClass="inputError imeDisabled" size="12" tabindex="4" /> --%>
                         
<!-- 			    <label>&nbsp;&nbsp;&nbsp;&nbsp;审批状态：</label> -->
<!-- 			            审批通过 -->
<%-- 	                <html:hidden property="judgestatus" value="t" /> --%>
                    <label>&nbsp; 创建日期  <html:select property="crttimestart" styleId="crttimestart" value="${crttimestart }" style="width: 60px;" errorStyleClass="inputError">
					<ig:optionsCollection ccid="YEAR_CODE"  isMakeBlankRow="false" isCodeLabel="true" />
					</html:select>年</label>
                    <html:submit property="btn_search" value="查询" styleClass="button"/>
	             </div>
			</div>
		</div>
		<div id="results_list">	
            <!--  message -->
			<ig:message/>
            <!--  /message -->     
			<table width="100%" class="table_style" style="border:1px solid #d3d3d3" id="showtable">
	        <!-- header部 -->
				<tr>
				<th width="20%">演练计划名称</th>
				<!-- <th width="8%">演练计划编号</th>
				<th width="8%">制定人</th>
				<th width="5%">创建时间</th>	 -->
				<th width="10%">演练预期时间</th>
				<th width="20%">演练名称</th>
				<th width="20%">演练内容</th>
				<!-- <th width="8%">演练预期时间</th> -->
				<th width="20%">演练状态</th>
				<th width="10%">发起演练</th>
				</tr>
	       
	            <!-- body部 -->
	       
				<logic:present name="IGDRM06041VO" property="drillItemList" >
					<logic:iterate id="bean" name="IGDRM06041VO" property="drillItemList" indexId="index">
						<tr>
							<!-- 选择 -->
							<td id="cols${index+1 }" class="tdtitle" name="${bean.dname}">
								${bean.dname}
							</td>
                            <td>
	                            ${bean.expecttime}
                            </td>
                            <td>
	                            ${bean.diname}
                            </td>
                            <td title="${bean.dicontant}">
                            	<div class="ellips">${bean.dicontant}</div>
                            </td>
                            <%-- <td>
	                            ${bean.expecttime}
                            </td> --%>
                            <td>
	                            <c:if test="${bean.status=='已演练'}">
		                            <span style="color: green;">
										已演练
		                            </span>
								</c:if>
								<c:if test="${bean.status!='已演练'}">
									${bean.status}
								</c:if>
                            </td>
                            <td>
								<div class="nowrapDiv">
									<logic:empty name="bean" property="status">
										<a href="javascript:void(0);" onclick="jump('${bean.diid}')" >&nbsp;<img src="images/9.gif" style="border:0px;" title ="发起演练" /></a>
									</logic:empty>
								</div>
							</td>
                        </tr>
                    </logic:iterate>
                </logic:present>
	       </table>
		</div>
	    <div id="operate">
	                <!-- paging -->
	                <jsp:include page="/include/paging.jsp"/>
	    </div>
    </html:form>
    </div>
    </div>
</div>

</div>
	<script type="text/javascript">	
	
        function jump(diid){
        	window.location = getAppRootUrl()+"/IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01385&ptid=20&prassetid=2&parameters="+diid;
        }
        
        function setEntity(url){

        	url = "IGFAP0101_ASSET.do"+"?roletype=IGBP14&subtype=999018";
        	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
			if("_resetall"==temp){
				document.forms[0].ename.value = "";
				document.forms[0].esyscoding.value = "";
				return false;
			}
			if(null!=temp && temp.split("|").length>1){
				var syscode_eid = temp.split("|")[0];
				var name = temp.split("|")[1];
				var syscode;
				var eid;
				if(syscode_eid =="999")
				{
					alert("资产模型不可用！请选择其他模型！");
					return false;
				}else if(syscode_eid.split("_").length>1){
					eid = syscode_eid.split("_")[0];
					syscode = syscode_eid.split("_")[1];
				}
				document.forms[0].ename.value = name;
				document.forms[0].esyscoding.value = syscode;
			}		
			
		}
        var listsize = jQ("#showtable").find("tr").length-1;
        var tempsize = 1;
        while(tempsize<listsize){
	       	//获取第一个值
	        var index = jQ("#cols"+tempsize).text();
	      	//得到同样值得数量
	      	var size = jQ("td[name='"+index.trim()+"']").length;
	      	jQ("td[name='"+index.trim()+"']:not(td[name='"+index.trim()+"']:first)").remove();
	      	//合并
	      	jQ("#cols"+tempsize).attr("rowSpan",size);
	      	tempsize = parseInt(tempsize)+parseInt(size);
	      	if(tempsize>=listsize){
	      		break;
	      	}
        }
       
        
        
	</script>
</body>
</html:html>