<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGCIM1001" toScope="request"/>
<bean:define id="title"  toScope="request">
	阈值设定画面
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
	function checkForm(){
		return true;
	}
	function setCutVakue(eiid,index){
		var obj = document.getElementById("cvalue_"+index);
		if(!isNaN(obj.value)){
			if(obj.value>100){
				alert("阈值必须小于100%!");
				return;
			}
			if(window.confirm('是否确认阈值设定!')){
		        form.action = getAppRootUrl() + "/IGCIM1001_Update.do?pdid="+eiid+"&cvalue="+obj.value;
		        form.submit();
			}
		}else{
			alert("阈值必须是数字类型!");
		}
	}
	</script>

<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
   
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
			<html:form styleId="form" action="/IGCIM1001"
             onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                  <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
            </div>    
                <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
                          <div class="conditions_border1">
                          <div>
                          <!-- 
			                <label>&nbsp;&nbsp;数据库名称</label>
			                <html:text property="DB_eq" styleId="dB_eq" errorStyleClass="inputError imeDisabled" size="10" ></html:text>&nbsp;&nbsp; 
	                       --> 
	                       <label>&nbsp;&nbsp;数据库类型</label>
							<html:select property="eid">
								<html:option value ="CM02010004">Oracle</html:option>
								<html:option value ="CM02030003">Informix</html:option>
								<html:option value ="CM02070003">Sybase</html:option>
							</html:select>&nbsp;&nbsp;
	                        <label>&nbsp;&nbsp;数据库实例</label>
			                <html:text property="instance_eq" styleId="instance_eq" errorStyleClass="inputError imeDisabled" size="10" ></html:text>&nbsp;&nbsp;
	                        <label>&nbsp;&nbsp;数据库表空间</label>
			                <html:text property="tablespace_eq" styleId="tablespace_eq" errorStyleClass="inputError imeDisabled" size="10" ></html:text>&nbsp;&nbsp;
                        <html:submit property="btn_search"   styleClass="button" onclick="return checkForm();">
                        		<bean:message bundle="asmResources" key="button.IGCIM0101.btn_search"/>
                        </html:submit>
                        </div>
                    </div>
		      </div>
		     
          </div>
                <div id="results_list">
					<!--  message -->
					<ig:message/>
					<!--  /message -->     
			       <table width="100%" class="table_style">
			            <!-- header部 -->
			                <tr>
			              	   <!-- <th width="10%">数据库名称</th>-->
			                   <th width="10%">数据库实例</th>
					           <th width="10%">表空间名称</th>
					           <th width="10%">表空间大小</th>
					           <!--th width="10%">表空间剩余大小</th>
					           <th width="10%">表空间使用大小</th-->
					           <th width="10%">使用率</th>
					           <th width="15%">阈值设定</th>
					           <th width="10%">确定操作</th>
			                </tr>
			            <!-- body部 -->			  
			                <logic:present name="IGCIM04371VO" property="entityDataList" >
			                	<bean:define id="vo"  name="IGCIM04371VO" />
			                    <logic:iterate id="bean" name="IGCIM04371VO" property="entityDataList" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                       	  <!-- 数据库名称
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="tsname">&nbsp;</logic:empty>
			                                ${bean.dbname}
			                                </div>
			                            </td>
			                             -->
			                           <!-- 数据库实例 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="tsname">&nbsp;</logic:empty>
			                                ${bean.instance}
			                                </div>
			                            </td>
			                            <!-- 表空间名称 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="tsname">&nbsp;</logic:empty>
			                                ${bean.tsname}
			                                </div>
			                            </td>
			                            <!--表空间大小 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="tsize">&nbsp;</logic:empty>
			                                ${bean.tsize}
			                                </div>
			                            </td>
			                            <!--表空间剩余大小-->
			                             <!--
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="freesize">&nbsp;</logic:empty>
			                                ${bean.freesize}
			                                </div>
			                            </td>	
			                            <td>
			                            <div class="nowrapDiv">
			                                <logic:empty name="bean" property="usesize">&nbsp;</logic:empty>
			                                ${bean.usesize}
			                                </div>
			                            </td>
			                            -->	
			                           <!--使用率 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="usagerate">&nbsp;</logic:empty>
			                                ${bean.usagerate}
			                                </div>
			                            </td>
			                           <!--阈值设定 -->
			                            <td>
			                              <html:text property="cvalue" styleId="cvalue_${index}" errorStyleClass="inputError imeDisabled" value="${bean.cvalue}" size="10" ></html:text> % 
			                            </td>
			                            <!--确定操作 -->
			                            <td>
										<img src="images/work.gif" style="cursor: hand;" width="16" height="16" border="0" alt="阈值设定" onclick="setCutVakue(${bean.eiid},${index})"/>
										</td>  
			                        </tr>
			                    </logic:iterate>
			                </logic:present>
			       </table>
			     </div>
			        <div id="operate">
	                <!-- paging -->
	                <jsp:include page="/include/paging.jsp"/>
	                <!-- /paging -->
			    </div>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>
</div>
</body>
</html:html>