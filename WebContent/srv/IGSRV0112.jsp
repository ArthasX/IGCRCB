<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
      function onloadnow(){
         // alert(window.location);
         window.location = "IGSRV0111.do?pdid=${pdid}&propentime=${propentime}&prclosetime=${prclosetime}&prtitle=${prtitle}&fromCount=${fromCount}&PAGING=PAGING";
      }
</script>
<body onload="onloadnow()">
</body>
