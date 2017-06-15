<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDRM2003" toScope="request" />
<bean:define id="title" value="模型维护画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript" src="js/jquery-ui-sortable/jquery-ui.min.js"></script>
<link rel="stylesheet" href="js/jquery-ui-sortable/jquery-ui.min.css">
<script type="text/javascript">
	// 是否有增加但未提交的信息
	var hasNewNode = false;
	//画面再表示
	function checkSubmit(obj) {
		// 未添加信息时不允许提交
		if(jQuery("input[name=parent_cids]").length == 0){
			alert("无新增内容！");
			return false;
		}
		else{
			
			
			var msg = "", bPass = true;
			var length= jQuery("input[name=node_names]").length;
			jQuery("input[name=node_names]").each(function(i, t) {
                t = jQ(t);
                if(!t.val()){
						msg += "    第" + t.parent().prev().text() + '行章节名称不能为空！\n';
						bPass = false;
						t.addClass('error');
                }else if($F(name).strlen() > 120){
					msg += "    第" +  t.parent().prev().text() + "行章节名称不能大于" + Math.floor(120 / strByteFlag) + "个汉字！";
				}
            });
			if(!bPass){
				alert(msg);
			}
			return bPass;
			
// 			var msg = "**错误信息**: \n", bPass = true;
// 			var n_names = obj.node_names;
// 			if(length>0){
// 				for(var i=0;i<length;i++){
// 					var name = n_names[i].value.trim();
// 					if(name == ''){
// 						msg += "    第" + (i+1) + '个节点名称不能为空；\n';
// 						bPass = false;
// 						j$(n_names[i]).addClass('error');
// 					} else if($F(name).strlen() > 120){
// 						msg += "    第" + (i+1) + "个节点名称不能大于" + Math.floor(120 / strByteFlag) + "个汉字！";
// 					}
// 				}
// 			}
// 			else{
// 				if(n_names == ''){
// 					msg += "第" + (i+1) + '个节点名称为空；';
// 					bPass = false;
// 				}
// 			}
// 			if(!bPass){
// 				alert(msg);
// 			}
// 			return bPass;
		}
		
		if ($F('cname').strlen() > 120) {
			alert("章节名称不能大于" + Math.floor(120 / strByteFlag) + "个汉字！");
			return false;
		}
		if ($F('cdesc').strlen() > 40) {
			alert("章节说明不能大于" + Math.floor(40 / strByteFlag) + "个汉字！");
			return false;
		} else {
			if (window.confirm("确认是否添加章节？")) {
				return true;
			} else {
				return false;
			}
		}
	}

	function toback() {
		IGDRM2003Form.action = getAppRootUrl()
				+ "/IGDRM2003.do?org.apache.struts.taglib.html.CANCEL=1";
		IGDRM2003Form.submit();
	}

	//提交成功后刷新父窗口
	function reloadParentPage() {
		var reloadFlg = '${param.reload}';
		if (reloadFlg == "true") {
			window.parent.reflashTree(true);
		}
	}
	
	function addSiblingNode(id, pcid){
		var nodes = jQ('.new-node'),
			max = 100;
		if(nodes.length != null && nodes.length > max){
			alert('最多允许插入' + max + '个新节点！');
			return;
		}
		var ltr = j$('#' + id + " tr:last");
		var count = j$('#' + id + " tr").length;
		var newNode = "<tr class='new-node bgRow" + count % 2 + "'>" + 
						"<td>" + count + "</td>" +
						"<td><input type='hidden' name='parent_cids' value='" + pcid + "'/><input name='node_names' type='text' style='width: 98%' onchange='nodeNameChange(this);' />"+
						
						"<input type='hidden' name='node_cseq' value='" + (1+parseInt(jQ("#pcseq").val())) + "'/></td>" +
						"<td>" +
							"<select name='node_attaches' tabindex='-1'>" +
								"<option value='0'>富文本</option>" +
								"<option value='1'>场景</option>" +
								"<option value='2'>组织架构</option>" +
								"<option value='3'>应急资源</option>" +
							"</select>" +
						"</td>" +
						"<td><img src='images/delate.gif' onclick='javascript:removeNodes(this, \"sub_node\");' style='cursor: pointer;' title='删除此节点' /></td>" +
					   "</tr>";
		ltr.after(newNode);
		checkNewNode(true);
	}
	
	function removeNodes(obj, pid, old, refresh){
		if(pid == 'old_node' && confirm("确认删除此目录？\n\n此操作会同时删除此目录下的所有子目录。")){
			(function(old_obj){
				jQuery.ajax({
					url:"IGDRM2005_Del_Ajax.do",
					type:"POST",
					dataType :"json",
					data:{'cid': obj},
					cache:false,
					success:function(rt){
						if('success' != rt){
							alert('删除出错');
						}else{
							window.parent.reflashTree(refresh);
							if(!refresh){
								removeNodes(old_obj);
							}
						}
					},
					error:function(XMLHttpRequest, textStatus, errorThrown){
						alert('删除出错');
					}
				});
			})(old);
		}
		else{
			jQ(obj).parent().parent().remove();
			checkNewNode(j$('.new-node').length != null && j$('.new-node').length > 0);
		}
	}
	
	function renameNode(cid, cname){
		if(!cname){
			alert("章节名称不能为空！");
		}else
		jQuery.ajax({
			url:"IGDRM2005_Rename_Ajax.do",
			type:"POST",
			dataType :"json",
			data:{'cid': cid, 'cname': cname},
			cache:false,
			success:function(rt){
				if('success' != rt){
					alert('更名出错');
				} else {
					window.parent.reflashTree(false);
				}
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				alert('更名出错');
			}
		});
	}
	
	function checkNewNode(b){
		hasNewNode = b;
		if(b){
			j$('#btn_save').show();
		}
		else{
			j$('#btn_save').hide();
		}
	}
	
	function nodeNameChange(obj){
		j$(obj).removeClass('error');
	}
	
	function sortNodes(){
		togglePanel(true);
	}
	
	function exitSort(){
		togglePanel(false);
	}
	
	function togglePanel(sort){
		if(sort){
			jQ('.panel-insort').hide();
			jQ('.panel-sort').show();
			jQ('#sub_node').addClass('sorting');
			jQ('#sub_node tbody').sortable('enable');

		}
		else{
			saveSort();
		}
	}
	
	function saveSort(){
		var cids = [];
		var arr  = jQ('#sub_node .tb-row');
		for(var i=0;i<arr.length;i++){
			cids.push(jQ(arr[i]).attr('cid'));
		}
		jQuery.ajax({
			url:"IGDRM2003_Sort_Ajax.do",
			type:"POST",
			dataType :"json",
			data:{'pcid': jQ('#parent_cid').val(),
				  'sort_cids': cids},
			cache:false,
			success:function(rt){
				if('success' != rt){
					alert('排序出错');
				}else{
					window.parent.reflashTree(false);
					jQ('.panel-insort').show();
					jQ('.panel-sort').hide();
					jQ('#sub_node').removeClass('sorting');
					jQ('#sub_node tbody').sortable('disable');
				}
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				alert('排序出错');
			}
		});
	}
	
	jQ(function(){
		var reindex = function(){
			var items = jQ('#sub_node .tb-row');
			items.each(function(index, ele){
				jQ('.sn', ele).text(index + 1);
			});
		};
		jQ('#sub_node tbody').sortable({
			items: '.tb-row',
			opacity: .8,
			stop: reindex,
	      	placeholder: "ui-state-highlight"
	    }).sortable('disable');
	});
</script>
<style>
	.head-title{
		position: absolute;
		left: 0;
		bottom: 0;
		width: 150px;
		height: 20px;
		line-height: 20px;
		text-align: center;
		margin: 5px 0;
		background-color: #ffb1bb;
	}
	
	.table-head{
		width: 100%;
		height: 30px;
		line-height: 30px;
		position: relative;
	}
	
	.table-head:last-of-type{
		height: 35px;
		line-height: 35px;
	}
	
	.btn-add{
		position: absolute;
		right: 15px;
		bottom: -5px;
	}
	
	.new-node{
		background-color: #ffdede;
	}
	
	#btn_save{
/* 		display: none; */
	}
	
	.error{
		background-color: #ffffc9;
	}
	
	.edit-name{
		background-color: white;*/
		width: 98%;
	}
	
	.panel-insort,
	.panel-sort{
		position: absolute;
		right: 50px;
		bottom: -5px;
	}
	
	.panel-sort{
		display: none;
	}
	
	#sub_node.sorting .tb-row{
		cursor: pointer;
		background-color: #c1fdc1;
	}
	
	#sub_node.sorting .edit-name{
	}
	
</style>
<body onload="reloadParentPage()">
	<div id="maincontent">
		<!--header  头部和 一级菜单-->
		<!--container 左菜单 右侧内容-->
		<!--content  右侧内容-->
		<div id="contentWrap">
			<div id="content" style="padding-top: -10px;">
				<div id="formwrapper">
					<html:form styleId="IGDRM2003Form" action="/IGDRM2003"
						onsubmit="return checkSubmit(this);">
						<div class="table-head">
							<span class="head-title">当前目录</span>
							<logic:present name="IGDRM20042VO" property="model">
<%-- 								<a href="###" class="btn-add" onclick="addSiblingNode('cur_node', '${IGDRM20042VO.model.pcid}')">增加</a> --%>
							</logic:present>
						</div>
						<table class="table_style" id="cur_node">
							<tr>
								<logic:present name="IGDRM20042VO" property="entity">
									<html:hidden styleId="parent_cid" property="pcid" value="CI${IGDRM20042VO.entity.esyscoding}" />
									<input type="hidden" id="pcseq" value="1"/>
									<th>模板名称</th>
								</logic:present>
								<logic:present name="IGDRM20042VO" property="model">
									<html:hidden styleId="parent_cid" property="pcid" value="${IGDRM20042VO.model.cid}" />
									<input type="hidden" id="pcseq" value="${IGDRM20042VO.model.cseq }"/>
									<th style="width: 10%;">序号</th>
									<th>章节名称</th>
									<th>章节类型</th>
									<th style="width: 10%;">操作</th>
								</logic:present>
							</tr>
							<tr>
								<logic:present name="IGDRM20042VO" property="entity">
									<td>${IGDRM20042VO.entity.ename}</td>
								</logic:present>
								<logic:present name="IGDRM20042VO" property="model">
									<c:set var="info" value="${IGDRM20042VO.model}" />
									<td>1</td>
									<td><input type="text" class="edit-name" value="${info.cname}" onchange="renameNode('${info.cid}', this.value.trim())" title="修改结束按回车（Enter）提交"/></td>
									<td>
									<c:if test="${info.cattach eq 0}">
				         				富文本
				         			</c:if> 
				         			<c:if test="${info.cattach eq 1}">
				         				场景
				         			</c:if> 
				         			<c:if test="${info.cattach eq 2}">
				         				组织架构
				         			</c:if>
				         			<c:if test="${info.cattach eq 3}">
				         				应急资源
				         			</c:if>
				         			</td>
									<td><img src="images/delate.gif" onclick="removeNodes('${info.cid}', 'old_node', this, true)" style="cursor: pointer;" title="删除此节点" /></td>
								</logic:present>
							</tr>
						</table>
						<div class="table-head">
							<span class="head-title">下级目录</span>
							<c:if test="${fn:length(IGDRM20042VO.children) >= 2}">
								<span class="panel-insort">
									<a href="###" onclick="sortNodes()">排序</a>
								</span>
								<span class="panel-sort">
									<a href="###" onclick="exitSort()">完成排序</a>
								</span>
							</c:if>
							<logic:present name="IGDRM20042VO" property="entity">
								<a href="###" class="btn-add" onclick="addSiblingNode('sub_node', 'CI${IGDRM20042VO.entity.esyscoding}')"><input type="button" class="button" value="增加"></a>
							</logic:present>
							<logic:present name="IGDRM20042VO" property="model">
								<a href="###" class="btn-add" onclick="addSiblingNode('sub_node', '${IGDRM20042VO.model.cid}')"><input type="button" class="button" value="增加"></a>
							</logic:present>
						</div>
						<br>
						<table class="table_style" id="sub_node">
							<tr>
								<th style="width: 10%;">序号</th>
								<th>章节名称</th>
								<th>章节类型</th>
								<th style="width: 10%;">操作</th>
							</tr>
							<logic:present name="IGDRM20042VO" property="children">
								<logic:iterate id="info" name="IGDRM20042VO" property="children"	indexId="index">
									<tr class="<ig:rowcss index="${index}"/> tb-row" cid="${info.cid}">
										<td class="sn">${index + 1}</td>
										<td>
											<input type="text" class="edit-name" value="${info.cname}" onchange="renameNode('${info.cid}', this.value.trim())" title="修改结束按回车（Enter）提交"/>
											<input type="hidden"  value = "${info.cseq }" />
										</td>
										<td>
											<c:if test="${info.cattach eq 0}">
						         				富文本
						         			</c:if> <c:if test="${info.cattach eq 1}">
						         				场景
						         			</c:if> <c:if test="${info.cattach eq 2}">
						         				组织架构
						         			</c:if><c:if test="${info.cattach eq 3}">
						         				应急资源
						         			</c:if>
						         		</td>
						         		<td><img src="images/delate.gif" onclick="removeNodes('${info.cid}', 'old_node', this, false);" style="cursor: pointer;" title="删除此节点" /></td>
									</tr>
								</logic:iterate>
							</logic:present>
						</table>
						<logic:present name="IGDRM20042VO" property="entity">
							<html:hidden property="eid" value="${IGDRM20042VO.entity.eid}" />
							<html:hidden property="esyscoding" value="${IGDRM20042VO.entity.esyscoding}" />
						</logic:present>
						<logic:present name="IGDRM20042VO" property="model">
							<html:hidden property="eid" value="${IGDRM20042VO.model.eid}" />
							<html:hidden property="esyscoding" value="${IGDRM20042VO.model.esyscoding}" />
						</logic:present>
						<div align="center">
						&nbsp;
						</div>
						<div align="center">
						<html:submit styleId="btn_save" property="btn_save" styleClass="button">提交</html:submit>
						</div>
					</html:form>
				</div>
			</div>
		</div>
		<div class="zishiying"></div>
	</div>
</body>
</html:html>