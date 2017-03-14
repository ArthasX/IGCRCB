<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html:html>
<bean:define id="id" value="IGDRM2108" toScope="request" />
<bean:define id="title" value="预案信息查看" toScope="request" />
<!-- start header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- end header1 -->
<link rel="stylesheet" href="css/ztree/zTreeStyle/zTreeStyle.css" />
<script type="text/javascript" src="js/ztree/jquery-1.4.4.min.js"></script>
<script>
var jQ14 = jQuery.noConflict(true);
</script>
<script type="text/javascript" src="js/ztree/jquery.ztree.core-3.4.js"></script>
<style type="text/css">
.conditions a img{
	border: 0px;
}
.conditions .hover{
	background-color: #d3d3d3;
	cursor: pointer;
}
.conditions .leftd{
	text-align: left;
}
.conditions .delFlag{
	display: none;
}
.conditions .titBox{
	background-color: #FFB1BB;
	font-size: 14px; 
	font-weight: bold;
	color:#fff;
	border-bottom: 1px solid #BB0500;
	line-height: 30px;
	height: 30px;
	text-indent: 10px;
}
.conditions a{
	text-decoration: none;
	color: #f00;
}
.conditions a:HOVER{
	text-decoration: none !important;
}
.conditions a:VISITED {
	color:#f00;
}

.ellips{
	width:100%; 
	white-space:nowrap; 
	text-overflow:ellipsis; 
	overflow:hidden;
}


.docTitle{
	text-align: center;
	font-size: 30px;
	font-weight: 600;
	height: 100px;
	line-height: 100px;
}

.docontent{
	padding: 10px 2em;
}
.dirtitle{
	font-weight: 600;
}
.doclevel1{
	padding-left: 1em;
}
.doclevel1 .dirtitle{
	font-size: 1.6em;
}
.doclevel2{
	padding-left: 2em;
}
.doclevel2 .dirtitle{
	font-size: 1.4em;
}
.doclevel3{
	padding-left: 3em;
}
.doclevel3 .dirtitle{
	font-size: 1.2em;
}
.table_style{
	width:95% !important;
}
.table_style4{ 
    width:95%;    
	border-collapse:collapse;
	border:1px solid #959499;
    text-align:left;  
    margin-top:10px;  
} 

.table_style4 td{
	border:1px solid #959499;
	text-indent: 0px;
}
.table_style4 th{
	text-align: left;
	text-indent: 0px;
}
.td_style4 {
	border:0px;
}
</style>
<SCRIPT type="text/javascript">
	function initTree(){
		var setting = {
				data: {
					key: {
						name: "cname"
					},
					simpleData: {
						enable: true,
						idKey: "cid",
						pIdKey: "pcid",
						rootPId: "0"
					}
				},
				callback: {
					onClick: zTreeOnClick,
					beforeClick: zTreeBeforeClick
				}
			};
		jQ14.fn.zTree.init(jQ14("#treeDemo"), setting, zNodes);
		window.treeRoot = jQ14.fn.zTree.getZTreeObj("treeDemo"); 
		treeRoot.expandAll(true); 
		treeRoot.selectNode(treeRoot.getNodes()[0]);
	}
	function zTreeBeforeClick(treeId, treeNode, clickFlag) {
		if(undefined == treeNode.cattach){
			alert("父节点不可以编辑");
		    return false;
		}else{
		    return true;
		}
	};
	
	var zNodes = ${IGDRM21021VO.planSectionTreeJson}
	jQ14(document).ready(function(){
		initTree();
	});
	function reflashTree(){
		jQuery.ajax({
			url:"IGDRM2002_Ajax.do",
			type:"POST",
			dataType :"json",
			data:{},
			async:false,
			cache:false,
			success:function(res){
				zNodes = res;
				initTree();
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				alert('出错了');
			}
		});
	}
	
	function toback(){
		window.location.href = getAppRootUrl() + "/IGDRM2105_Back.do?mode="+jQuery("#pageMode").val();
	}
</SCRIPT>
<body>
<!-- 	<div style="position:absolute;  top: 200px;left: 0; width:100%; height: 100px;border: 1px solid red;z-index: 99;">&nbsp;</div> -->
	<div id="maincontent">
	<!--header  头部和 一级菜单-->
	<jsp:include page="/include/header2.jsp" />
	<!--container 左菜单 右侧内容-->
		<div id="container">
		<div id="location">
			<div class="image"></div>
			<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
			<div class="back"><html:link href="javascript:toback();">返回</html:link></div>
			<input type="hidden" id="pageMode" value="${IGDRM2102Form.mode }">
		</div>
		<div id="contentWrap">
			<div id="treeNode">
				<div style="width:240px;float:left;border:0px; border:1px solid #BB0500;height:550px; overflow:auto;">
					<div class="conditions" style="height:550px;" >
						<div>
							<div class="titBox">文档大纲</div>
							<ul id="treeDemo" class="ztree"></ul>
						</div>
						<html:hidden property="esyscoding" styleId="esyscoding" value="${IGDRM0402Form.ercode}"/>
					</div>
				</div>
				<div id="content" style="width:730px;float:left; border-top:1px solid #BB0500;border-right:1px solid #BB0500;border-left:1px solid #BB0500;height:55px; margin-left: 10px;">
					<div id="results_list">
					<table class="table_style" id="scenceInfo" data-eiid = "${IGDRM21021VO.entityItemVWInfo.eiid }">
						<tr>
							<th width="18%">模型名称</th>
							<th width="13%">预案编号</th>
							<th width="19%">预案名称</th>
							<th width="12%">预案所属机构</th>
							<th width="18%">预案说明</th>
							<th width="10%">管理人</th>
							<th width="10%">登记日</th>
						</tr>
						<tr>
							<td align="center" title="${IGDRM21021VO.entityItemVWInfo.ename}">
								<c:if test="${fn:length(IGDRM21021VO.entityItemVWInfo.ename)>10}">
									${fn:substring(IGDRM21021VO.entityItemVWInfo.ename,0,10)}...
								</c:if>
								<c:if test="${fn:length(IGDRM21021VO.entityItemVWInfo.ename)<=10}">${IGDRM21021VO.entityItemVWInfo.ename}</c:if>
							</td>
							<td>${IGDRM21021VO.entityItemVWInfo.eilabel}</td>
							<td title="${IGDRM21021VO.entityItemVWInfo.einame}">
								<c:if test="${fn:length(IGDRM21021VO.entityItemVWInfo.einame)>10}">
									${fn:substring(IGDRM21021VO.entityItemVWInfo.einame,0,10)}...
								</c:if>
								<c:if test="${fn:length(IGDRM21021VO.entityItemVWInfo.einame)<=10}">${IGDRM21021VO.entityItemVWInfo.einame}</c:if>
							</td>
							<td>${IGDRM21021VO.eiorgname}</td>
							<td title="${IGDRM21021VO.entityItemVWInfo.eidesc}">
								<c:if test="${fn:length(IGDRM21021VO.entityItemVWInfo.eidesc)>10}">
									${fn:substring(IGDRM21021VO.entityItemVWInfo.eidesc,0,10)}...
								</c:if>
								<c:if test="${fn:length(IGDRM21021VO.entityItemVWInfo.eidesc)<=10}">${IGDRM21021VO.entityItemVWInfo.eidesc}</c:if>
							</td>
							<td>${IGDRM21021VO.entityItemVWInfo.eiusername}</td>
							<td>${IGDRM21021VO.entityItemVWInfo.eiinsdate}</td>
						</tr>
					</table>
					</div>
				</div>
				<div id="docBox" style="width:730px;float:left; border:1px solid #BB0500;height:495px; margin-left: 10px; overflow:auto;">
				
					<div class="docTitle">${IGDRM21021VO.entityItemVWInfo.einame}</div>
					<logic:present name="IGDRM21021VO" property="treeMap">
						<logic:iterate id="map" name="IGDRM21021VO" property="treeMap" indexId="number">
							<bean:define id="soc0509Info" name="map" property="value" type="com.deliverik.infogovernor.drm.model.SOC0509Info" />
											<!-- 类型 0=富文本 ,1=场景,2=组织架构,3=应急资源 -->
							<div id="${map.key }" class="docontent doclevel<%=(soc0509Info.getCseq()>3?3:soc0509Info.getCseq()) %>" data-ctype="${soc0509Info.cattach}">
								<div class="dirtitle">
									${soc0509Info.cname }
								</div>
								<div class="dircontent">
								&nbsp;
								</div>
							</div>
						</logic:iterate>
					</logic:present>
				</div>
			</div>
		</div>
		<div class="zishiying"></div>
	
		</div>
	</div>
</body>
<script>
	jQ(function(){
		
		//定义一个Map对象装载每个章节段落的位置信息
		window.docMap = {
				docArr:{},
				posiMap :{},
				posiStr:"",
				length:0,
				curDir:null,
				add:function(key,obj){
					this.docArr[key]=obj;
					this.posiMap[obj.top] = obj.dom;
					if(this.posiStr){
						this.posiStr+=",";
					}
					this.posiStr+=(obj.top)
					this.length = this.posiStr.split(",").length;
				},
				get:function(key){
					return this.docArr[key];
				},
				setCur:function(dom){
					this.curDir = dom;
				},
				getCur:function(){
					return this.curDir;
				},
				//根据位置获取元素top1:高度
				//direct:方向 >false 小于(返回小于top,中最大的) true: 大于(返回大于top中最小的)
				getByPosi:function(top1,direct){
					
					var tempArr = direct?this.posiStr.split(",").reverse():this.posiStr.split(",");
					var tempTop = 0;
					for(var i = 0;i< tempArr.length;i++){
						
						//大于top(返回小于top中最大的)
						if(direct){
							if(tempArr[i]<=top1){
								tempTop = tempArr[i];
								break;
							}
						}else{
							if(tempArr[i]>=top1){
								tempTop = tempArr[i];
								break;
							}
						}
					}
					
					if(tempTop>0){
						return this.posiMap[tempTop];
					}else{
						return null;
					}
						
				}
		}
		
		//绑定滚动事件
		jQ("#docBox").scroll(function(){
			
			var $scrollTop = jQ(this).scrollTop();
			//滚动加载
			dirBox.trigger("scrollLoad",$scrollTop);
			
			
			//以下下是设置树中的高亮
			//如果是用户点击的树触发滚动则不需要设置
			if(!jQ("#docBox").data("scrolling")){
				
				//定义滚动方向  false滚动条向上  true向下
				var scrollDirecti = true;
				if(window.latsScroll&&window.latsScroll>$scrollTop){
					scrollDirecti = false;
				}else if(window.latsScroll = $scrollTop){
					scrollDirecti = window.laseDirect;
				}
				
				//设置树的高亮
				var box = docMap.getByPosi(100+$scrollTop,scrollDirecti);
				if(box&&box!=docMap.getCur()){
// 					console.log(">>>>>>>>>>>>>>>>>>>>>>>scrollTop:"+(100+$scrollTop));
// 				console.log("滚动方向"+scrollDirecti);
// 				console.log("latsScroll:"+window.latsScroll+"$scrollTop:"+$scrollTop);
// 					console.log("返回的数据:"+box.find(".dirtitle").text());
// 					console.log("top:"+docMap.get(box.attr("id")).top);
// 					console.log("方向："+scrollDirecti);
					docMap.setCur(box);
					box.trigger("setTree",scrollDirecti);
				}
			}
			window.latsScroll = $scrollTop;
			window.laseDirect = scrollDirecti;
		});
		
		window.dirBox = jQ(".docontent");
		
		//页面初始化加载文档数据
		dirBox.each(function(i,t){
			var _t = jQ(t);
			var $height = loadContent(_t.attr("id"),_t.data("ctype"));
			if(jQ("#docBox").height()<=$height){
				return false;
			}
		});
		
		//自定义事件  在文档预览窗口滚动时触发-判断当前文档章节是否需要加载
		
		dirBox.on("scrollLoad",function(event,scrollTop){
			var _this = jQ(this);
			if(!docMap.get(_this.attr("id"))&&_this.position().top<=698){
				loadContent(_this.attr("id"),_this.data("ctype"),scrollTop);
			}
		}).on("setCur",function(){
			//滚动到选中的章节
			jQ("#docBox").data("scrolling","true").stop().animate({
				scrollTop:(jQ(this).position().top)+"px"
			},300,"linear",function(){
				jQ(this).removeData("scrolling");
				if(!docMap.get(this.id)){
					jQ(this).trigger("setCur");
				}
			});
		}).on("setTree",function(event,scrollDirect){
			var _this = jQ(this);
			
			//滚动条向下
			if(scrollDirect){
				if(jQ(".curDirBox").length>0){
						_this.addClass("curDirBox").prev().removeClass("curDirBox");
						treeRoot.selectNode(treeRoot.getNodeByParam("cid",_this.attr("id"),null));
				}else{
					jQ(".docontent:first").addClass("curDirBox");
				}
			}else{
				//滚动条向上
					_this.addClass("curDirBox").next().removeClass("curDirBox");
					treeRoot.selectNode(treeRoot.getNodeByParam("cid",_this.attr("id"),null));
			}
		});
		
		
		
	})
	
	/**
	* 加载目录内容
	*/
	function loadContent(cid,ctype,scrollTop){
		var result = 0;
		jQ.ajax({
			url:"IGDRM2108_Ajax.do",
			data:{cid:cid,ctype:ctype,planEiid:jQ("#scenceInfo").data("eiid")},
			dataType:"HTML",
			type:"POST",
			async:false,
			success:function(html){
				var _curBox = jQ("#"+cid+"");
				_curBox.find(".dircontent").html(html).css("textIndent","1em");
				docMap.add(cid,{top:_curBox.position().top-jQ("#docBox").position().top+(scrollTop?scrollTop:0),height:_curBox.height()+20,dom:_curBox,name:_curBox.find(".dirtitle").text()});
				result = docMap.get(cid).top+docMap.get(cid).height;
				_curBox.find(".ke-insertfile").each(function(i,t){
					t=jQuery(t);
					t.attr("href",encodeURI(encodeURI(t.attr("href"))));
				});
			}
		});
		
		return result;
		
	}
	/**树的点击事件*/
	function zTreeOnClick(event, treeId, treeNode) {
			
		var curBoxPosi= docMap.get(treeNode.cid);
		if(curBoxPosi){
			jQ("#docBox").data("scrolling","true").stop().animate({
				scrollTop:(curBoxPosi.top)+"px"
			},"300","linear",function(){
				jQ(this).removeData("scrolling");
			});
		}else{
			jQ("#"+treeNode.cid).trigger("setCur");
		}
	};

</script>
</html:html>
