<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@page import="com.deliverik.infogovernor.util.CodeDefine"%>

<html:html>
<bean:define id="id" value="IGKGM0202" toScope="request" />
<bean:define id="title" value="知识修改画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<%--

--%>

//删除所选
function deleteRec(){
	 var count=0;
	 count=checkAndCreate();
	 if(count==0){
		alert("请您先选择要删除的记录！");
		return;
	 }
    if(window.confirm("您确定要删除选定记录吗？")){
    	
        document.forms[0].action = getAppRootUrl() + "/IGKGM0202_DELETE.do";
        document.forms[0].submit();
    } 
}

function checkAndCreate(){
	var count=0;
	var check = document.getElementsByName("del");
	for(var i=0;i<check.length;i++){
		if(check[i].checked==true){
			count=1;
			createHiddenInput("knids",check[i].value);
		}
	}
    return count;
}	

function getDetail(id,version){
   doLook("IGKGM0216_READ.do?knid="+id+"&knversion="+version);
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
          <html:form styleId="form" action="/IGKGM0202" onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1">流程管理 &gt;&gt; 知识库 &gt;&gt; 知识修改</p>
            		
            </div>
          
                
                <div id="results_list">
					<!--  message -->
					<ig:message />
					<!--  /message -->
                    <table  class="table_style">
							<tr>
							   <th width="5%">
									<label> 
										<input type="checkbox" name="checkbox" id="checkbox" onclick="selectAll('checkbox','del')"/> 
									</label>
								</th>
								<th width="25%">标题</th>
								<th width="25%">关键字</th>
								<th width="15%">分类</th>
								<th width="5%">状态</th>
								<th width="15%">驳回说明</th>
								<th width="5%">修改</th>
							</tr>
						
						
						<!-- body部 -->
						
                            <logic:present name="IGKGM02011VO" property="knowledgeList">
								<logic:iterate id="bean" name="IGKGM02011VO"
									property="knowledgeList" indexId="index">
									<tr>
										
										
							            <td>
										<label>
											<input name="del" type="checkbox" value="${bean.knid}"/>
										</label>
										</td>
										
										<!-- 标题 -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="kntitle">&nbsp;</logic:empty> ${bean.kntitle}</div>
										</td>
										<!-- 关键字 -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="knkey">&nbsp;</logic:empty> ${bean.knkey}</div>
										</td>
										<!-- 分类-->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="knclassname">&nbsp;</logic:empty> ${bean.knclassname}</div>
										</td>
										
										<!-- 状态-->
										<td>
										<div class="nowrapDiv">  <ig:codeValue ccid="KNOWLEDGE_STATUS" cid="${bean.knstatus}" /></div>
										</td>
										
										<!-- 驳回说明-->
										<td align="left">
										<div class="nowrapDiv"><pre><logic:empty name="bean"
											property="knreject"></logic:empty>${bean.knreject}</pre></div>
										</td>
										
										<!-- 查看详细 -->
										<td>
											<a href="javascript:doLook('IGKGM0203_READ.do?knid=${bean.knid}&knversion=${bean.knversion}');" >
											<img src="images/edit.gif" alt="修改知识信息" width="16" height="16" border="0"/></a>
										</td>
									</tr>
								</logic:iterate>
							</logic:present>
						
					</table>
				</div>

	
	<div id="operate">
	<logic:present name="IGKGM02011VO"
		property="knowledgeList">
		<span> <html:button property="delete" value="删除所选"
			styleClass="button" onclick="deleteRec();" /></span>
	</logic:present> 
	<jsp:include page="/include/paging.jsp" />
	</div>
	
    </html:form>
    </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>