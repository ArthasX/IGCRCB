<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCOM0210" toScope="request" />
<bean:define id="title" value="系统管理首页" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
   <div id="content">
       <div class="caption">
          <div  class="caption_img"><img src="images/jggl.gif" width="64" height="64" /></div>
          <div class="caption_right">
          <div class="caption_title">
             <p class="fonts1">
			 <ig:menuAuth actname="ACT09SYM0101">
             <html:link action="/IGCOM0202.do?linkID=IGSYM0101&actname=ACT09SYM0101">机构管理</html:link>
             </ig:menuAuth>
             <ig:menuAuth actname="ACT09SYM0101" permission="false">
             	机构管理
             </ig:menuAuth>
             </p>
          </div>
          <div class="caption_content">
             <p>对名称、地址、联系人、联系方式等机构信息进行管理。</p>
          </div>
          </div>
      </div>
       <div class="caption">
         <div  class="caption_img"><img src="images/yhgl.gif" width="64" height="64" /></div>
         <div class="caption_right">
         <div class="caption_title">
            <p class="fonts1">
			<ig:menuAuth actname="ACT09SYM0201">
           		<html:link action="/IGCOM0202.do?linkID=IGSYM0201&actname=ACT09SYM0201">用户管理</html:link>
            </ig:menuAuth>
            <ig:menuAuth actname="ACT09SYM0201" permission="false">
             	用户管理
            </ig:menuAuth>
            </p>
         </div>
         <div class="caption_content">
            <p>对系统中的用户名称、口令、部门、联系方式、工作信息等进行统一管理。<br/>&nbsp;</p>
         </div>
         </div>
      </div>     
      <div class="caption">
         <div  class="caption_img"><img src="images/jsgl.gif" width="64" height="64" /></div>
         <div class="caption_right">
          <div class="caption_title">
            <p class="fonts1">
			<ig:menuAuth actname="ACT09SYM0301">
            	<html:link action="/IGCOM0202.do?linkID=IGSYM0301&actname=ACT09SYM0301">角色管理</html:link>
            </ig:menuAuth>
            <ig:menuAuth actname="ACT09SYM0301" permission="false">
             	角色管理
            </ig:menuAuth>
            </p>
          </div>
         <div class="caption_content">
            <p>对业务流程角色和系统功能角色进行统一管理。</p>
         </div>
         </div>
      </div>      
      
 <div class="caption">
     <div  class="caption_img"><img src="images/sqgl.gif" width="64" height="64" /></div>
       <div class="caption_right">
       <div class="caption_title">
       <p class="fonts1">
       
		<ig:menuAuth actname="ACT09SYM0401">
       		<html:link action="/IGCOM0202.do?linkID=IGSYM0401&actname=ACT09SYM0401">授权管理</html:link>
        </ig:menuAuth>
        <ig:menuAuth actname="ACT09SYM0401" permission="false">
            	授权管理
        </ig:menuAuth>
       </p>
      </div>
      <div class="caption_content">
        <p>对系统中用户的角色进行管理，并对角色的职能、权限进行管理。<br/>&nbsp;</p>
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
