


(function(){
	//ҳ���ʼ������
	window.initPage = function(){
		window.pdid = jQ("#pdid").val(),
		window.psdid = jQ("#psdid").val();
//		if(psdid.substring(7,10)=='003'){//���ڴ�����Ҳ����ſ�����
		jQ("#pidid"+pdid+"023").attr("readonly",true);
//		}
		hideForm();
		setPrurgency();
		hideBtn();
		addEveImg();
		formatPanel();
		initSwitch(jQ(".name:contains('������Ϣ')")[0],true);
		initSwitch(jQ(".name:contains('�¼���Ϣ')")[0]);
		jQ("#pidid"+pdid+"025:visible").parent().parent().hide();
		//���ؽ����¼�prid
		//jQuery("input[name='pivarvalue[21]']").parent().parent().hide();
	}
	
	//����<����ԭ��>��
	function hideForm(){
		//�����Ԥ�����ýڵ㲢�� ����ԭ�����ֵ�ǿ� ������ ����ԭ���
		if((pdid+"006"==jQ("#psdid").val())&&!jQ("#pidid"+pdid+"018").val()){
//			jQ("#pidid"+pdid+"018:visible").parent().parent().hide();
			jQ("input[value="+pdid+"018]").parent().parent().hide();
		}
	}
	
	/**
	 * ��ʼ������ڵ㱣���Ƿ�������
	 */
	function setPrurgency(){
		
		if(pdid+"001"==psdid ){
				
			//�����������prid �����ñ����̵Ľ�����Ϊ1(����) ������0(Ӧ��)
			if(getFormObj("Ӧ������prid").value){
				jQ("#prurgency").val("1");
			}else{
				jQ("#prurgency").val("0");
			}
		}
	}
	
	
	/**
	 * <Ӧ�����ýڵ�>ʱ��������ָ�����û��������ش���ť
	 */
	function hideBtn(){
		if(pdid+"007"==psdid){
			
			var cldStatus = jQ(".title:contains('Ӧ������')").next().find("tr:eq(1)").find("td:eq(3)").text();
			if(!("�ر�"==cldStatus||"��ֹ"==cldStatus)){
				jQ(".action:visible").parent().parent().hide();
			}
		}
	}
	
	
	function formatPanel(){
		if(jQ(".title:contains('������Ϣ')").length>0){
			var dvCase = jQ(".title:contains('������Ϣ')").next();
			dvCase.after("<div class='title'><div class='name'>�¼���Ϣ</div></div>");
		}
	}
	
	/**���ѡ���¼�����ͼ��*/
	function addEveImg(){
		if(pdid+"001"==psdid||pdid+"003"==psdid){
			jQ("#pidid"+pdid+"023").after("&nbsp;&nbsp;&nbsp;&nbsp;<img src='images/book_open.gif' style='cursor: pointer;' onclick='showEventLevel()' title='�鿴�¼�����' />")
		}
	}
	
	/**
	 * ��ʼ������
	 */
	jQ(function(){
		initPage();
		
	})
	
	
})();

/**
 * ��ʼ��ҳ����۵�title
 * @param dvbox
 */
function initSwitch(dvbox,isPackup){
	dvbox = jQ(dvbox);
	dvbox.css({cursor: "pointer"});
	dvbox.append("<img id='dealrecord' src='images/redu.gif' width='10' height='10' border='0'/>");
	dvbox.on("click",function(){
		jQ(this).parent().next().toggle();
		if(jQ(this).find("img").attr("src")=='images/addd.gif'){
			jQ(this).find("img").attr("src","images/redu.gif");
		}else{
			jQ(this).find("img").attr("src","images/addd.gif");
		}
	});
	(isPackup)&&dvbox.click();
}

/**
 * ���¼����𵯳���
 */
function showEventLevel(){
	openSubWindow("/IGDRM1605_Search.do", "eveWin", 1000, 600);
}

/**
 * ��ȡԤ����Դid
 * @returns
 */
function getPlanid(){
	var eiid ;
	if(jQ("a[asm='"+pdid+"015']:visible").length>0){
		var htmlStr = jQ("a[asm='"+pdid+"015']")[0].outerHTML;
		eiid = htmlStr.substring(htmlStr.indexOf('openSubIGCOM0303')+18,htmlStr.indexOf("'", htmlStr.indexOf('openSubIGCOM0303')+18));
	}else{
		eiid = jQ(":input[asm='"+pdid+"015']:first").parent().find(":input[name^='entityId']:first").val().split("#")[1];
	}
	return eiid ;
}

function openSubIGCOM0303(eiid,civersion){
	param = $H({sp_eiid: eiid,civersion:civersion}).toQueryString();
	openSubWindow('/IGDRM0702_Detail.do?' + param, '_blank', '1050', '600');
}

/**
 * ѡ�˰�ť����¼�
 * @param pidid
 * @param roletype
 */
function selectPeople(pidid,roletype){
	if(roletype == "N/A"){
		roletype = "";
	}
	cpidid = pidid;
	openSubWindow('/IGPRR0303_Disp.do?pidid=' + pidid + '&roletype=' + roletype +"&single=1", '_pblank','1050','600');
}

/**
 * ������Ա��ֵ
 * @param obj
 * @returns {Boolean}
 */
function setParticipant(obj){
	var tb = document.getElementById("people_" + cpidid);
	var tr,td1,td2,td3,td4,td5;
	if(obj != null && obj.length > 0){
		for(var k=0;k<obj.length;k++){
			for(var n=0;n<tb.rows.length;n++){
				if(obj[k][0] == tb.rows[n].name){
					alert("�û� \"" + obj[k][1] + "\" ���б����Ѵ��ڣ�������ѡ��");
					return true;
				}
			}
		}
		for(var i=0;i<obj.length;i++){
			tr = tb.insertRow();
			tr.name = obj[i][0];
			td1 = tr.insertCell();
			td1.innerHTML = obj[i][1] + 
							'<input type="hidden" name="par_userid" value="' + obj[i][0] + '" />' + 
							'<input type="hidden" name="par_username" value="' + obj[i][1] + '" />';
			td2 = tr.insertCell();
			td2.innerHTML = obj[i][3] +
							'<input type="hidden" name="par_orgid" value="' + obj[i][2] + '" />' +
							'<input type="hidden" name="par_orgname" value="' + obj[i][3] + '" />';
			td3 = tr.insertCell();
			td3.innerHTML = obj[i][5] + 
							'<input type="hidden" name="par_roleid" value="' + obj[i][4] + '" />' + 
							'<input type="hidden" name="par_rolename" value="' + obj[i][5] + '" />';
			td4 = tr.insertCell();
			td4.innerHTML = obj[i][6] + 
							'<input type="hidden" name="par_phone" value="' + obj[i][6] + '" />';
			td5 = tr.insertCell();
			td5.style.textAlign = "center";
			td5.innerHTML = '<a href="javascript:void(0);" onclick="deleteParticipant(this);">ɾ��</a>' +
							'<input type="hidden" name="par_pidid" value="' + cpidid + '"/>';
		}
	}
	
	jQ(tb).parent().prevAll().hide();
}
/**
 * ɾ����Ա��
 * @param obj
 */
function deleteParticipant(obj){
	var tr = obj.parentElement.parentElement;
	jQ(tr).parent().parent().parent().prevAll().show();
	
	tr.parentElement.deleteRow(tr.rowIndex);
}


/**
 * �ʲ�ѡ��ť����¼�
 * @param index
 * @param pidid
 * @param syscoding
 */
function selectEntity(index,pidid,syscoding){
	var pdid = jQ("#pdid").val();
	if(pidid == pdid+'026'){
		url = "/IGDRM2101_BsInit.do?esyscoding=1_CM03000000_999003&pidid="+pidid;
		openSubWindow(url, '', '850', '600');
	}else{
		if(syscoding!=null&&syscoding!=undefined&&syscoding.substring(0,6)=='999060'){
			var sp_eiid = getPlanid();
			
			if(!sp_eiid){
				alert("����ѡ��ר��Ԥ����");
			}else{
				openSubIGCOM0302PARAM('?pidid='+pidid + '&esyscoding=' + syscoding+'&sp_eiid='+sp_eiid);
			}
		}else{
			
			openSubIGCOM0302PARAM('?pidid='+pidid + '&esyscoding=' + syscoding);
		}
	}
	num = index;
}
/**
 * �򿪵���ҳ
 * @param param
 */
function openSubIGCOM0302PARAM(param){
	openSubWindow('/IGDRM0702_Disp.do'+param , '', '850', '600');
}
/**
 * ѡ���ʲ���ֵ
 * @param eid
 * @param elabel
 * @param ename
 * @param eiid
 * @param eilabel
 * @param einame
 * @param ecategory
 * @param pidid
 * @param eiversion
 * @param esyscoding
 */
function setParamIGCOM0302(eid, elabel,ename,eiid, eilabel, einame, ecategory, pidid, eiversion,esyscoding) {
	if(esyscoding!=null&&esyscoding!=undefined&&esyscoding.substring(0,6)=='999050'){
	//ר��Ԥ��eiid
	jQ("#pidid"+pdid+"015").val(eiid);
	}
	if(esyscoding!=null&&esyscoding!=undefined&&esyscoding.substring(0,6)=='999060'){
	//����eiid
		jQ("#pidid"+pdid+"016").val(eiid);
	}
	if(setEntityObj != null){
		var showvalue = null;
		var showvalues = setEntityObj.parentElement.childNodes;
		if(showvalues != null){
			for(var i=0;i<showvalues.length;i++){
				if(showvalues[i].name == "show_value"){
					showvalue = showvalues[i];
				}
			}
		}
		var columnvalue = null;
		var columnvalues = setEntityObj.parentElement.parentElement.parentElement.parentElement.parentElement.childNodes;
		if(columnvalues != null){
			for(var k=0;k<columnvalues.length;k++){
				if(columnvalues[k].name == "column_value"){
					columnvalue = columnvalues[k];
				}
			}
		}
		var crowIndex = setEntityObj.parentElement.parentElement.id;
		if("" == eiid){
			showvalue.value = "";
			if(columnvalue.value != ""){
				var str0 = columnvalue.value.split("_entityValue_")[0];
				var str1 = columnvalue.value.split("_entityValue_")[1];
				var str2 = "";
				if(columnvalue.value.split("_entityValue_").length == 3){
					str2 = columnvalue.value.split("_entityValue_")[2];
				}
				var strs = str1.split("#");
				var valueStr = "";
				for(var index=0;index<strs.length;index++){
					if(index > 0){
						valueStr += "#";
					}
					if(crowIndex != strs[index].split("_rowIndex_")[0]){
						valueStr += strs[index];
					}
				}
				if(str2 != ""){
					columnvalue.value = str0 + "_entityValue_" + valueStr + "_entityValue_" + str2;
				}else{
					columnvalue.value = str0 + "_entityValue_" + valueStr;
				}
			}
		}else{
			showvalue.value = einame;
			var crowIndex = setEntityObj.parentElement.parentElement.id;
			if(columnvalue.value == ""){
				columnvalue.value = "_entityValue_" + crowIndex + "_rowIndex_" + eiid + "_sp_" + eiversion;
			}else{
				var str0 = columnvalue.value.split("_entityValue_")[0];
				var str1 = columnvalue.value.split("_entityValue_")[1];
				var str2 = "";
				if(columnvalue.value.split("_entityValue_").length == 3){
					str2 = columnvalue.value.split("_entityValue_")[2];
				}
				var strs = str1.split("#");
				var flag = true;
				var valueStr = "";
				for(var index=0;index<strs.length;index++){
					if(index > 0){
						valueStr += "#";
					}
					if(crowIndex == strs[index].split("_rowIndex_")[0]){
						flag = false;
						valueStr += crowIndex + "_rowIndex_" + eiid + "_sp_" + eiversion;
					}else{
						valueStr += strs[index];
					}
				}
				if(flag){
					valueStr += "#" + crowIndex + "_rowIndex_" + eiid + "_sp_" + eiversion;
				}
				if(str2 != ""){
					columnvalue.value = str0 + "_entityValue_" + valueStr + "_entityValue_" + str2;
				}else{
					columnvalue.value = str0 + "_entityValue_" + valueStr;
				}
			}
		}
		setEntityObj = null;
	}else{
		if("" == eiid){
			$("entityId[" + num + "]").value = "";
			$("entityname[" + num + "]").value = "";
		} else {
			$("entityId[" + num + "]").value = pidid + "#" + eiid + "#" + eiversion;
			$("entityname[" + num + "]").value = einame;
			if(pidid != 'A'){
				jQ("#pidid" + pidid).val("N/A");
			}
		}
		num = 0;
	}
}

/**
 * ѡ���ʲ���ֵ(ҵ��ϵͳ)
 * @param eid
 * @param elabel
 * @param ename
 * @param eiid
 * @param eilabel
 * @param einame
 * @param ecategory
 * @param pidid
 * @param eiversion
 * @param esyscoding
 */
function setParamDRM2101(eid, elabel,ename,eiid, eilabel, einame, ecategory, pidid, eiversion,esyscoding,eiid_id) {
	if(setEntityObj != null){
		var showvalue = null;
		var showvalues = setEntityObj.parentElement.childNodes;
		if(showvalues != null){
			for(var i=0;i<showvalues.length;i++){
				if(showvalues[i].name == "show_value"){
					showvalue = showvalues[i];
				}
			}
		}
		var columnvalue = null;
		var columnvalues = setEntityObj.parentElement.parentElement.parentElement.parentElement.parentElement.childNodes;
		if(columnvalues != null){
			for(var k=0;k<columnvalues.length;k++){
				if(columnvalues[k].name == "column_value"){
					columnvalue = columnvalues[k];
				}
			}
		}
		var crowIndex = setEntityObj.parentElement.parentElement.id;
		if("" == eiid){
			showvalue.value = "";
			if(columnvalue.value != ""){
				var str0 = columnvalue.value.split("_entityValue_")[0];
				var str1 = columnvalue.value.split("_entityValue_")[1];
				var str2 = "";
				if(columnvalue.value.split("_entityValue_").length == 3){
					str2 = columnvalue.value.split("_entityValue_")[2];
				}
				var strs = str1.split("#");
				var valueStr = "";
				for(var index=0;index<strs.length;index++){
					if(index > 0){
						valueStr += "#";
					}
					if(crowIndex != strs[index].split("_rowIndex_")[0]){
						valueStr += strs[index];
					}
				}
				if(str2 != ""){
					columnvalue.value = str0 + "_entityValue_" + valueStr + "_entityValue_" + str2;
				}else{
					columnvalue.value = str0 + "_entityValue_" + valueStr;
				}
			}
		}else{
			showvalue.value = einame;
			var crowIndex = setEntityObj.parentElement.parentElement.id;
			if(columnvalue.value == ""){
				columnvalue.value = "_entityValue_" + crowIndex + "_rowIndex_" + eiid_id + "_" + eiid + "_sp_" + eiversion;
			}else{
				var str0 = columnvalue.value.split("_entityValue_")[0];
				var str1 = columnvalue.value.split("_entityValue_")[1];
				var str2 = "";
				if(columnvalue.value.split("_entityValue_").length == 3){
					str2 = columnvalue.value.split("_entityValue_")[2];
				}
				var strs = str1.split("#");
				var flag = true;
				var valueStr = "";
				for(var index=0;index<strs.length;index++){
					if(index > 0){
						valueStr += "#";
					}
					if(crowIndex == strs[index].split("_rowIndex_")[0]){
						flag = false;
						valueStr += crowIndex + "_rowIndex_" + eiid_id + "_" + eiid + "_sp_" + eiversion;
					}else{
						valueStr += strs[index];
					}
				}
				if(flag){
					valueStr += "#" + crowIndex + "_rowIndex_" + eiid_id + "_" + eiid + "_sp_" + eiversion;
				}
				if(str2 != ""){
					columnvalue.value = str0 + "_entityValue_" + valueStr + "_entityValue_" + str2;
				}else{
					columnvalue.value = str0 + "_entityValue_" + valueStr;
				}
			}
		}
		setEntityObj = null;
	}else{
		if("" == eiid){
			$("entityId[" + num + "]").value = "";
			$("entityname[" + num + "]").value = "";
		} else {
			$("entityId[" + num + "]").value = pidid + "#" + eiid_id + "_" + eiid + "#" + eiversion;
			$("entityname[" + num + "]").value = einame;
			if(pidid != 'A'){
				jQ("#pidid" + pidid).val("N/A");
			}
		}
		num = 0;
	}
	
	//ҵ��ϵͳ
	if(pidid == jQ("#pdid").val() + '026'){
		entityChange();
	}
}

//ɾ��
var pieids = "";
function delSingleEntity(pieid, pidid, property,pidid,syscoding,index,required){
		
	var flag = delEntity(pieid, pidid, property);
	if(flag){
		addSingleEntity(pidid, syscoding, index, required, property);
	}
	if(syscoding.substring(0,6)=='999050'){
		jQ("#pidid"+pdid+"015").val('');
		var cjpidid = pidid.substring(0,7)+'016';
		var cjpieid = parseInt(pieid)+1;
		document.getElementById(cjpieid).style.display = "none";
		document.getElementById(cjpieid + "ENT").style.display = "none";
		pieids = pieids + "#" + cjpieid;
		document.forms[0].pieids.value = pieids;
		checkAsm(cjpidid);
		
		if(jQ("#tbentity"+pdid+"016").is(":visible")==false){
			
			addSingleEntity(cjpidid, '999060', index, required, property);
		}
	}
}

function deleteSelect2(pidid){
	if(jQ("#ENT"+pidid).length > 0){
	 	var cjpieid = jQ("#ENT"+pidid).val();
	 	jQ("#"+cjpieid).remove();
 		jQ("#"+cjpieid + "ENT").remove();
 		jQ("#assetSelector"+pidid).attr("style","display:block;width: 180px;");
 		pieids = pieids + "#" + cjpieid;
 		document.forms[0].pieids.value = pieids;
 		jQ("#ENT"+pidid).val("");
	}
}

function delSelect2SingleEntity(pieid, pidid, property,pidid,syscoding,index,required){
	var pdid = jQ("#pdid").val();
	var flag = window.confirm("���Ƿ�ȷ��ɾ����");
	if(flag){
		if(pidid == pdid + '015'){
			deleteSelect2(pdid+"015");
			deleteSelect2(pdid+"016");
			entityChange();
		}else if(pidid == pdid+'016'){
			deleteSelect2(pdid+"016");
			jQ("#assetSelector"+pdid+"015").trigger("change");
		}
	}
}

function setRankValue(rankName){
	jQ("#pidid"+pdid+"023").val(rankName);
}

function showRelatedProcess(prid,prtype,isSingle){
	if(isSingle&&isSingle=="1"){
		//�򿪵�һ�����鿴ҳ��
		//openRelatedProcess(prid,prtype);
		openSubWindow("/IGDRM0906.do?prid="+prid,"��һ����",1024,600);
	}else{
		//����ϳ����鿴ҳ��
		openSubWindow("/IGDRM0906.do?pgrid="+prid,"��ϳ���",1024,600);
	}
}




