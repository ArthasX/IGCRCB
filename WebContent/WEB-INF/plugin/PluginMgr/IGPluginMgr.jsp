<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGPluginMgr" toScope="request"/>
<bean:define id="title" value="插件管理画面" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">	
	function chgStatus(o,stat,pathz){
		if(stat=='Y'){
			if(confirm("确定要启用"+o+" 插件")){
				location.href="IGPluginMgr_Mod.do?pluginStatus="+stat+"&pluginPath="+pathz;
			}
		}
		if(stat=='N'){
			if(confirm("确定要停用 "+o+" 插件")){
				location.href="IGPluginMgr_Mod.do?pluginStatus="+stat+"&pluginPath="+pathz;
			}
		}
	}
	function updatePluginData(o,stat,pathz){
		if(confirm("确定要立即更新插件 "+o+" 数据")){
			location.href="IGPluginMgr_Upd.do?pluginStatus="+stat+"&pluginPath="+pathz;//IGPluginMgr_Upd
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
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1">系统管理 &gt;&gt; 基础数据 &gt;&gt; 插件管理</p>
            </div>
                <div id="results_list">
					<!--  message -->
					<ig:message/>
					<!--  /message -->
			       <table class="table_style" >
			            <!-- header部 -->
			                <tr>
					           <th width="5%"></th>
					           <th width="15%">编号</th>
					           <th width="20%">名称</th>
                               <th width="20%">路径</th>
                               <th width="10%">状态</th>
                               <th width="15%">操作</th>
                               <th width="15%">更新数据</th>
			                </tr>
			            <!-- body部 -->
			            <logic:present property="pluginList" name="IGPluginMgrVO">
			           	<logic:iterate id="bean" property="pluginList" name="IGPluginMgrVO" indexId="rowId">
	                        <tr>
	                            <td>
	                            </td>
	                            <!-- 编号 -->
	                            <td>
	                                <div class="nowrapDiv" >
									${rowId+1}                        
	                                </div>
	                            </td>
	                            <!-- 名称 -->
	                            <td>
	                                <div class="nowrapDiv" align="left" >
										${bean.pluginName}
	                                </div>
	                            </td>
                                      <!-- 路径 -->
                                      <td>
                                      <div class="nowrapDiv" align="left" >
										${fn:substring(bean.pluginPath,fn:indexOf(bean.pluginPath,"WEB-INF"),255)}
                                      </div>
                                      </td>
                                      <!-- 状态-->
                                      <td>
                                      <div class="nowrapDiv">
                                    	 <c:if test="${bean.pluginStatus=='Y'}"><font color="#00C000">已启用</font></c:if>
                                    	 <c:if test="${bean.pluginStatus=='N'}"><font color="#C00000">已禁用</font></c:if>
                                      </div>
                                      </td>
                                      <!-- 操作 -->
                                      <td>
                                     	<c:if test="${bean.pluginStatus=='N'}"><input type="button" class="button" value="启用" style="height:20px" onclick="chgStatus('${bean.pluginName}','Y','${bean.pluginPath}')" /></c:if>
                                     	<c:if test="${bean.pluginStatus=='Y'}"><input type="button" class="button" value="禁用" style="height:20px" onclick="chgStatus('${bean.pluginName}','N','${bean.pluginPath}')" /></c:if>
                                      </td>
                                      <!-- 更新-->
                                      <td>
                                     	<input type="button" class="button" value="更新" style="height:20px" onclick="updatePluginData('${bean.pluginName}','${bean.pluginStatus}','${bean.pluginPath}')" />
                                      </td>
	                        </tr>
	                        </logic:iterate>
	                        </logic:present>
 			       </table>
			     </div>
                 <div id="operate">
			        <div class="content">
			            <div class="enter">
			            </div>
			        </div> 
    		    </div>
        </div>
    </div>
</div>


</div>
</body>
</html:html>