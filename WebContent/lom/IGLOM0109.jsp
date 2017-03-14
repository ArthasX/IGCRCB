<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<html:html>
<bean:define id="id" value="IGLOM0109VO" toScope="request"/>
<bean:define id="title" value="接待客人查询画面" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	

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
            <html:form styleId="form" action="/IGLOM0109" onsubmit="return checkSubmit(this);">
          	<div id="location">
                <div class="image"></div>
                    <p class="fonts1">后勤管理 &gt;&gt; 接待管理 &gt;&gt;接待客人查询</p>
            	</div>
                <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
		                 
                    	 
                    	  <label for="Name"><strong>来宾单位</strong>：</label>
							 <html:text property="rgunit"  size="32"  /> 
						
                    	 
			              <label for="Name"><strong>来宾姓名</strong>：</label>
			              <html:text property="rgunit"  size="20"  />
				
			        	 <html:submit property="btn_search" value="查询" styleClass="button"/>
		     		</div>
          		</div> 
          		
     <div id="results_list">
	              <ig:message />
	<table class="table_style">
			<tr>
			
				<th width="11%">接待工作名称</th>
				<th width="11%">主要申请部门</th>
				<th width="11%">接待开始日期</th>
				<th width="11%">接待结束日期</th>
				<th width="14%">其他参与部门</th>
				<th width="18%">接待内容描述</th>
				
				
			</tr>
			 <logic:present name="IGLOM0109VO" property="recptionguestInfoList" >
			                    <logic:iterate id="bean" name="IGLOM0109VO" property="recptionguestInfoList" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
  1
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="rname">&nbsp;</logic:empty>
			                                ${bean.rname}
			                                </div>
			                            </td>
			                         
			                            <td>
			                                <div class="nowrapDiv">
			                                
			                                ${bean.organizationTB.orgname}
			                                </div>
			                            </td>
			                           
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="rstime">&nbsp;</logic:empty>
			                                ${bean.rstime}                                 
			                                </div>
			                            </td>
			                           
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="retime">&nbsp;</logic:empty>
			                                ${bean.retime}                                
			                                </div>
			                            </td>
			                            
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="rpporg">&nbsp;</logic:empty>
			                                ${bean.rpporg}                                
			                                </div>
			                            </td>
			                            
			                           <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="rdescription">&nbsp;</logic:empty>
			                                ${bean.rdescription}                                
			                                </div>
			                            </td>
					              	
			                        </tr>
			                    </logic:iterate>
			                </logic:present>
			 
	</table>             
   </html:form>
        </div>
    </div>
    <div class="zishiying"></div>

</div>

</div>
</body>
</html:html>