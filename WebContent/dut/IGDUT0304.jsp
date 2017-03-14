<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>

<html:html>
<bean:define id="id" value="IGDUT0304" toScope="request" />
<bean:define id="title" value="日常维护登记画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
		function checkForm(){
			if($F('odprguest').trim()==""){
				alert('来访人员不能为空');
				return false;
			}
	        if($F('odprguest').trim().strlen()>256){
	            alert("来访人员说明不能超过"+Math.floor(256/strByteFlag)+"个汉字！");
	            return false;
	        }
			if($F('odprguestorg').trim()==""){
				alert('来访人员部门不能为空');
				return false;
			}
            if($F('odprguestorg').trim().strlen()>256){
                alert("来访人员部门不能超过"+Math.floor(256/strByteFlag)+"个汉字！");
                return false;
            }
			if($F('odprguestidnum').trim()==""){
				alert('来访人员身份证明不能为空');
				return false;
			}
            if($F('odprguestidnum').trim().strlen()>32){
                alert("来访人员身份证明不能超过"+Math.floor(32/strByteFlag)+"个汉字！");
                return false;
            }
            var temp = document.getElementsByName("odprareas");
            var tempFlag=true;
            for(var i=0;i<temp.length;i++){
            	if(temp[i].checked==true){
            		tempFlag=false;
            	}
            }
			if(tempFlag){
				alert("请选择进入区域！");
				return false;
			}
			if($F('odprctime').trim()==""){
				alert('进入时间不能为空');
				return false;
			}
			if($F('odprltime').trim()==""){
				alert('离开时间不能为空');
				return false;
			}
			if($F('odpropter').trim()==""){
				alert('操作人不能为空');
				return false;
			}
            if($F('odpropter').trim().strlen()>32){
                alert("操作人不能大于"+Math.floor(32/strByteFlag)+"个汉字！");
                return false;
            }
			if($F('odpracter').trim()==""){
				alert('批准人不能为空');
				return false;
			}
			if($F('odpracter').trim().strlen()>32){
				alert("批准人不能大于"+Math.floor(32/strByteFlag)+"个汉字！");
				return false;
			}
			if($F('odprtarget').trim()==""){
				alert('操作目标不能为空');
				return false;
			}
			if($F('odprtarget').trim().strlen()>256){
				alert("操作目标不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
				return false;
			}
			if($F('odprrecord').trim().strlen()>2000){
				alert("操作记录不能大于"+Math.floor(2000/strByteFlag)+"个汉字！");
				return false;
			}
			if($F('odprinserttime').trim()==""){
				alert('记录时间不能为空');
				return false;
			}
		}
</script>

<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">服务管理 &gt;&gt; 值班管理 &gt;&gt; 日常维护登记</p>
	<logic:equal name="IGDUT0304Form" property="mode" value="1">
	<div class="back"><a href="IGDUT0403_Back.do" target="_self">返回</a></div>
	</logic:equal></div>
            <div id="formwrapper">
                 <html:form styleId="form" action="/IGDUT0304_Insert" onsubmit="return confirm('确定提交?')">
                      <!--  message -->
                      <ig:message/>
                      <!--  /message -->     
                    <fieldset>
                        <legend>日常维护登记</legend>
                        <c:if test="${igdut0304Form.odprid != null}"><html:text property="odprid" readonly="true"></html:text></c:if>
                       <div>
                            <label for="Name"><strong><span class="red">*</span>来访人员</strong>：</label>
                            <html:text property="odprguest" errorStyleClass="inputError imeActive" tabindex="2"/>
                            &nbsp;
                        </div>
                        <div><label for="Name"><strong><span class="red">*</span>所属单位</strong>：</label>
                            <html:text property="odprguestorg" style="width:300px;" errorStyleClass="inputError imeActive" tabindex="2"></html:text>
                            &nbsp;
                            </div>
                       <div>
                            <label for="Name"><strong><span class="red">*</span>身份证明</strong>：</label>
                            <html:text property="odprguestidnum" style="width:300px;" errorStyleClass="inputError imeActive" tabindex="2"/>
                            <br>
                        </div>
                        <div>
                            <logic:present name="IGDUT03041VO" property="codeDetailList">
                            <label for="Name"><strong><span class="red">*</span>进入区域</strong>：</label>
                            <logic:iterate id="bean" name="IGDUT03041VO" property="codeDetailList">
                            <html:multibox property="odprareas" value="${bean.cid}" styleId="odprareas"/>${bean.cvalue}
                            </logic:iterate>
                            &nbsp;
                            </logic:present>
                        </div>
                        <div>
                            <label for="Name"><strong><span class="red">*</span>进入时间</strong>：</label>
                            <html:text property="odprctime" styleId="eidesc" size="12" tabindex="2" style="width:125px;" errorStyleClass="inputError" readonly="true" />
                            <img src="images/date.gif" align="middle" onClick="showTime($('odprctime'))" border="0"/>
                            &nbsp;
                        </div>
                        <div>
                            <label for="Name"><strong><span class="red">*</span>离开时间</strong>：</label>
                            <html:text property="odprltime" styleId="eidesc" size="12" tabindex="2" style="width:125px;" errorStyleClass="inputError" readonly="true" />
                            <img src="images/date.gif" align="middle" onClick="showTime($('odprltime'))" border="0"/>
                            <br>
                        </div>
                                                                        <div>
                            <label for="Name"><strong><span class="red">*</span>录入时间</strong>：</label>
                            <html:text property="odprinserttime" styleId="eidesc" size="12" tabindex="2" style="width:125px;" errorStyleClass="inputError" readonly="true" />
                            <img src="images/date.gif" align="middle" onClick="showDate($('odprinserttime'))" border="0"/>
                            <br>
                        </div>
                        <div>
                            <label for="Name"><strong><span class="red">*</span>操作人</strong>：</label>
                            <html:text property="odpropter" styleId="eidesc" tabindex="2" style="width:125px;" errorStyleClass="inputError"/>
                            &nbsp;
                        </div>
                        <div>
                            <label for="Name"><strong><span class="red">*</span>批准人</strong>：</label>
                            <html:text property="odpracter" styleId="eidesc" tabindex="2" style="width:125px;" errorStyleClass="inputError"/>
                            &nbsp;
                        </div>
                            <html:hidden property="odprusername"/>
                        <div>
                            <label for="Name"><strong><span class="red">*</span>操作目标</strong>：</label>
                            <html:text property="odprtarget" styleId="eidesc" tabindex="2" style="width:125px;" errorStyleClass="inputError"/>
                            <br>
                        </div>
                        <div>
                            <label for="Name"><strong>操作记录</strong>：</label>
                            <html:textarea property="odprrecord" styleId="eidesc" tabindex="2" errorStyleClass="inputError" rows="10" cols="50"/>
                            <br>
                        </div>

                                                                     
                    </fieldset>
                    <div class="enter">
                        <html:submit value="提交" styleClass="button"  onclick="return checkForm();"  />
                        <html:reset styleClass="button" value="重置"></html:reset>
                    </div>
                 </html:form>
            </div>
    </div>
<div class="zishiying"></div>
</div>
</div>
</div>
</body>
</html:html>