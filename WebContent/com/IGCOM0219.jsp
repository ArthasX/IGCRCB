<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCOM0219" toScope="request" />
<bean:define id="title" value="配置管理首页" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
	function isGoTopo(){
		var isGoFlag="${IGCIM05001VO.isGoTopology}";
		
		//判断为1时，弹出拓扑图
		if(isGoFlag!=null&&isGoFlag=='1'){
			var version="${IGCIM05001VO.version}";
			var eiddid="${IGCIM05001VO.eiddid}";
			var updatetime="${IGCIM05001VO.updatetime}";
			openSubIGCOM0324('0',eiddid,version,updatetime);
		}
	}
</script>
<body onload="isGoTopo()">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
 <div id="contentWrap">
  <div id="content">
   
   
<div class="caption">
<div class="caption_img"><img src="images/peizhimoxing.jpg"
	width="64" height="64" /></div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">

<ig:menuAuth actname="ACT04CIM0701">
<html:link action="/IGCOM0202.do?linkID=IGAIM0401&actname=ACT04CIM0701">配置模型</html:link>
</ig:menuAuth>
<ig:menuAuth actname="ACT04CIM0701" permission="false">
 	配置模型
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>可相关的模型名称，模型说明，停用或启用模型状态，修改相关模型信息</p>
</div>
</div>
</div>   
   
<div class="caption">
<div class="caption_img"><img src="images/dj.png"
	width="64" height="64" /></div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
<ig:menuAuth actname="ACT04CIM0801">
	<html:link action="/IGCOM0202.do?linkID=IGCIM0801&actname=ACT04CIM0801">配置采集</html:link>
</ig:menuAuth>
<ig:menuAuth actname="ACT04CIM0801" permission="false">
      配置采集
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>根据需要配置采集插件</p>
</div>
</div>
</div>  

<div class="caption">
<div class="caption_img"><img src="images/peizhixinxi.jpg"
	width="64" height="64" /></div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
<ig:menuAuth actname="ACT04CIM0901">
<html:link action="/IGCOM0202.do?linkID=IGCIM0901&actname=ACT04CIM0901">配置信息</html:link>
</ig:menuAuth>
<ig:menuAuth actname="ACT04CIM0901" permission="false">
 	配置信息
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>可以查询相关的CI属性，CI关系等信息</p>
</div>
</div>
</div>
   
 

<div class="caption">
<div class="caption_img"><img src="images/peizhifenxi.jpg"
	width="64" height="64" /></div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
<ig:menuAuth actname="ACT04CIM1002">
<html:link action="/IGCOM0202.do?linkID=IGCIM1101&actname=ACT04CIM1002">配置导出管理</html:link>
</ig:menuAuth>
<ig:menuAuth actname="ACT04CIM1002" permission="false">
 	配置导出管理
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>以业务系统为单位，可以将与该业务系统关联的配置信息导出&nbsp;</p>
</div>
</div>
</div>


<div class="caption">
<div class="caption_img"><img src="images/sdsjcj.jpg"
	width="64" height="64" /></div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
<ig:menuAuth actname="ACT04CIM1101">
	<html:link action="/IGCOM0202.do?linkID=IGCIM0808&actname=ACT04CIM1101">手动采集</html:link>
</ig:menuAuth>
<ig:menuAuth actname="ACT04CIM1101" permission="false">
      手动采集
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>管理员手动开启CI数据采集</p>
</div>
</div>
</div>


<div class="caption">
<div class="caption_img"><img src="images/sdgxfx.jpg"
	width="64" height="64" /></div>
<div class="caption_right">
<div class="caption_title">
<p class="fonts1">
<ig:menuAuth actname="ACT04CIM1201">
<html:link action="/IGCOM0202.do?linkID=IGCIM0160&actname=ACT04CIM1201">配置状况</html:link>
</ig:menuAuth>
<ig:menuAuth actname="ACT04CIM1201" permission="false">
 	配置状况
</ig:menuAuth>
</p>
</div>
<div class="caption_content">
<p>可查询配置采集状况，配置解析状况</p>
</div>
</div>
</div>

</div>
</div>
<div class="zishiying"></div>
</div>

</div>
</body>
</html:html>