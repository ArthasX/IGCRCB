/**
 * �����������̶���ҳjs 
 */


//���ر�
jQuery(document).ready(function(){
	if(getFormObj("���ɱ�ʾ")!=null){
		getFormObj("���ɱ�ʾ").parentElement.parentElement.style.display = "none";
	}
	if(getFormObj("��Ա")!=null){
		getFormObj("��Ա").parentElement.parentElement.style.display = "none";
	}
});
/**
 * ����ڵ��ʼ��
 */
function init_001(){
	//���ط�����������
	getFormObj("��������").parentElement.parentElement.style.display = "none";
	
}

/**
 * ִ�нڵ��ʼ��
 */
function init_002(){
	var tb1 = document.getElementById(arr_pidlabelObj["���յ�"] + "_tableForm");
	var tb2 = document.getElementById(arr_pidlabelObj["�����"] + "_tableForm");
	
	//û������ʱ���ط��յ���ʽ��
	if(tb1.rows.length < 3){
		getFormObj("���յ�").parentElement.parentElement.style.display = "none";
	}else{
		for(var i=0;i<tb1.rows.length;i++){
			if(i > 0){
				var item = getTableFormObj("���յ�#���յ�",i);
				if(item.type == "text"){
					item.style.display = "none";
					item.parentElement.innerHTML += "<span class='tempadd'>" + item.value + "</span>";
				}
				var items = getTableFormCheckBox("���յ�#ѡ��",i);
				for(var n=0;n<items.length;n++){
					items[n].disabled = true;
				}
			}
			for(var j=4;j<tb1.rows[i].cells.length;j++){
				tb1.rows[i].cells[j].style.display = "none";
			}
		}
	}
	//û������ʱ���ؼ�����
	if(tb2.rows.length < 3){
		getFormObj("�����").parentElement.parentElement.style.display = "none";
	}else{
		for(var i=0;i<tb2.rows.length;i++){
			if(i > 0){
				var item = getTableFormObj("�����#�����",i);
				if(item.type == "text"){
					item.style.display = "none";
					item.parentElement.innerHTML += "<span class='tempadd'>" + item.value + "</span>";
				}
				var items = getTableFormCheckBox("�����#ѡ��",i);
				for(var n=0;n<items.length;n++){
					items[n].disabled = true;
				}
			}
			for(var j=3;j<tb2.rows[i].cells.length;j++){
				tb2.rows[i].cells[j].style.display = "none";
			}
		}
	}
	
	//���η��յ���ʽ���Ҽ��˵�
	deleteRightMenu(tb1);
	//���μ������ʽ���Ҽ��˵�
	deleteRightMenu(tb2);
}

/**
 * ��˽ڵ��ʼ��
 */
function init_003(){
	var tb1 = document.getElementById(arr_pidlabelObj["���յ�"] + "_tableForm");
	var tb2 = document.getElementById(arr_pidlabelObj["�����"] + "_tableForm");
	
	for(var i=0;i<tb1.rows.length;i++){
		for(var j=5;j<tb1.rows[i].cells.length;j++){
			tb1.rows[i].cells[j].style.display = "none";
		}
	}
	for(var i=0;i<tb2.rows.length;i++){
		for(var j=4;j<tb2.rows[i].cells.length;j++){
			tb2.rows[i].cells[j].style.display = "none";
		}
	}
	
	getRelationProcess();
}

/**
 * ȥ�����ʽ��������ӵ��Ҽ��˵���ʽ�������������ʱ�򲻻������Ҽ��˵�
 */
function deleteRightMenu(tb){
	for(var i=0;i<tb.rows.length;i++){
		if(tb.rows[i].className == "rightMenu"){
			tb.rows[i].className = "";
		}
	}
}

/**
 * ���ʲ�ģ����ѡ��������
 * @param obj �����ͼƬdom����
 */
function openAsmModel(obj){
	var temp = window.showModalDialog("IGFXK0401_ZTREE.do?roletype=IGAC13&subtype=999017",null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.getElementById("RiskCategory").value = "";
		cleanTableForm();
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		var syscode_eid = temp.split("|")[0];
		var name = temp.split("|")[1];
		if(syscode_eid =="999") {
			alert("�ʲ�ģ�Ͳ����ã���ѡ������ģ�ͣ�");
			return;
			
		}
		var rcids = "";
		var result = temp.split("@");
		var resultlist = "";
		for(var i =0; i < result.length-1; i++){
			if(resultlist!=""){
				resultlist=resultlist+",";
				rcids=rcids+"_";
			}
			var rcid = result[i].split("|")[0];
			var rcname = result[i].split("|")[1];
			rcids += rcid;
			resultlist += rcname;
		}
		document.getElementById("RiskCategory").value = resultlist;
		document.getElementById("RiskCategoryID").value = rcids;
		cleanTableForm();
		gangedASM013(rcids,resultlist);
		gangedASM014(rcids);
	}		
}

/**
 * ��ձ��ʽ��ֵ�����ر��ʽ��
 */
function cleanTableForm(){
//	getFormObj("���յ�").parentElement.parentElement.style.display = "none";
//	getFormObj("�����").parentElement.parentElement.style.display = "none";
//	getTableFormObj("��������#���յ�").parentElement.parentElement.style.display = "none";
//	getTableFormObj("��������#�����").parentElement.parentElement.style.display = "none";
	
//	cleanTableFormValue(document.getElementById(arr_pidlabelObj["���յ�"] + "_tableForm"));
//	cleanTableFormValue(document.getElementById(arr_pidlabelObj["�����"] + "_tableForm"));
	getFormObj("��������").parentElement.parentElement.style.display = "none";
	cleanTableFormValue();
}

function cleanTableFormValue(){
//	var tb = document.getElementById(arr_pidlabelObj["��������"] + "_tableForm");
//	alert(tb.length);
//	//�����������ʷ���ݣ����������ʷ����
//	if(tb.rows.length > 2) {
//		for(var n=tb.rows.length;n>2;n--){
//			var tr = tb.rows[n-1];
//			tb.deleteRow(tr.rowIndex);
//		}
//	}
//	//��յ�һ������
//	var temps = tb.rows[1].cells[1].childNodes;
//	alert(temps);
//	for(var j=0;j<temps.length;j++){
//		if(temps[j].className == "tempadd"){
//			temps[j].outerHTML = "";
//		}
//	}
}

/**
 * �������յ���ʽ��
 */
function gangedASM013(rcids,str){
	//-----------��ѯ���յ�----------
	var resultlist = str.split(",");
	// ��ʾ���յ���ʽ��
	getFormObj("��������").parentElement.parentElement.style.display = "";
		//��װ����
		var params = {};
		params.esyscoding = rcids;
		// ajax��������
		jQuery.ajax({
			url:"IGFXK0401_GetAsm013.do",
			type:"POST",
			dataType :"json",
			data:params,
			cache:false,
			// �ɹ��ص�����
			success:function(data){
			for(var j=0;j in data;j++){
				// ȡ�ñ�����
				var tb_tableForm = document.getElementById(arr_pidlabelObj["��������#���յ�"] + "_tableForm");
				var tb_tr = null;
				if(j>0){
					// ��ģʽ�����
					addGroup(tb_tableForm.rows[0]);
					tb_tr = tb_tableForm.rows[tb_tableForm.rows.length - 1];
					//ɾ���¼��е��Ҽ��˵�
					tb_tr.onmousedown = "";
					tb_tr.oncontextmenu = function(){return true;};
					tb_tr.className = "";
				}else{
					tb_tr = tb_tableForm.rows[tb_tableForm.rows.length - 1];
					//ɾ���¼��е��Ҽ��˵�
					tb_tr.onmousedown = "";
					tb_tr.oncontextmenu = function(){return true;};
					tb_tr.className = "";
				}
				// ȡ�ñ�����
				var tb = document.getElementById(arr_pidlabelObj["��������#���յ�"] + "_tableForm");
				// ����װ������
				for(var i=0;i<data[j].length;i++){
					//��һ������λ��Ĭ�ϴ��ڣ�������ݴ���һ�У��������
					var tr = null;
					if(i>0){
						addRow(tb.rows[0]);
						tr = tb.rows[tb.rows.length - 1];
						//ɾ���¼��е��Ҽ��˵�
						tr.onmousedown = "";
						tr.oncontextmenu = function(){return true;};
						tr.className = "";
					}else{
						tr = tb.rows[tb.rows.length - 1];
						//���÷��յ��ֵ
						var item_name = document.getElementById("0114001020"+"_"+(j + 1));
						item_name.value = resultlist[j];
						item_name.style.display = "none";
						item_name.parentElement.innerHTML += "<span class='tempadd'>" + resultlist[j] + "</span>";
					}
					var item_001 = document.getElementById("0114001014_"+ (j + 1) +"_"+(1 + i));// ���յ�
					item_001.value = data[j][i].einame;
					item_001.style.display = "none";
					item_001.parentElement.innerHTML += "<span class='tempadd'>" + data[j][i].einame + "</span>";
					document.getElementById("0114001018_"+ (j + 1) +"_"+(1 + i)).value = data[j][i].eiid;// ���յ�ID
					//���ر���
//					for(var k=3;k<tb.rows[i+1].cells.length;k++){
//						tb.rows[i+1].cells[k].style.display = "none";
//					}
//					tb.rows[i+1].cells[1].style.display = "none";
				}
//					tb.rows[0].cells[1].style.display = "none";
//					for(var k=3;k<tb.rows[0].cells.length;k++){
//						tb.rows[0].cells[k].style.display = "none";
//					}
			 }
			},
			//ʧ�ܻص�����
			error:function(XMLHttpRequest, textStatus, errorThrown){
				alert("��ȡ���յ������쳣");
			}
		});
}

/**
 * ���������
 */
function gangedASM014(rcids){
	//-----------��ѯ���յ�----------
	//��װ����
	var params = {};
	params.esyscoding = rcids;
	//ajax��������
	jQuery.ajax({
		url:"IGFXK0401_GetAsm014.do",
		type:"POST",
		dataType :"json",
		data:params,
		cache:false,
		//�ɹ��ص�����
		success:function(data){
		for(var j=0;j in data;j++){
			// ȡ�ñ�����
			var tb = document.getElementById(arr_pidlabelObj["��������#�����"] + "_tableForm");
			// ����װ������
			for(var i=0;i<data[j].length;i++){
				//��һ������λ��Ĭ�ϴ��ڣ�������ݴ���һ�У��������
				var tr = null;
				if(i>0){
					addRow(tb.rows[1]);
					tr = tb.rows[tb.rows.length - 1];
					//ɾ���¼��е��Ҽ��˵�
					tr.onmousedown = "";
					tr.oncontextmenu = function(){return true;};
					tr.className = "";
				}else{
					tr = tb.rows[tb.rows.length - 1];
				}
				//���÷��յ��ֵ
				var item_001 = document.getElementById("0114001009_"+ (j + 1) +"_"+(1 + i));// �����
				item_001.value = data[j][i].einame;
				item_001.style.display = "none";
				item_001.parentElement.innerHTML += "<span class='tempadd'>" + data[j][i].einame + "</span>";
				document.getElementById("0114001012_"+ (j + 1) +"_"+(1 + i)).value = data[j][i].eiid;// ���յ�ID
			}
			
			//���ر���
//			for(var k=3;k<tb.rows[0].cells.length;k++){
//				tb.rows[0].cells[k].style.display = "none";
//			}
		}
		},
		//ʧ�ܻص�����
		error:function(XMLHttpRequest, textStatus, errorThrown){
			alert("��ȡ����������쳣");
		}
	});
}

function getRelationProcess(){
	var prid = document.getElementById("prid");
	var params = {};
	params.prid = prid;
	//ajax��������
	jQuery.ajax({
		url:"IGFXK0401_GetRelationProcess.do",
		type:"POST",
		dataType :"json",
		data:params,
		cache:false,
		//�ɹ��ص�����
		success:function(data){
			var arr = new Array();
			if(data != null && data.length > 0){
				for(var i=0;i<data.length;i++){
					arr[data[i].eiid] = data[i];
				}
			}
			var tb1 = document.getElementById(arr_pidlabelObj["���յ�"] + "_tableForm");
			for(var i=1;i<tb1.rows.length;i++){
				var isCheck = getTableFormObj("���յ�#ѡ��",i);
				if(isCheck.value == "."){
					var eiid = getTableFormObj("���յ�#���յ�ID",i).value;
					if(arr[eiid]){
						getTableFormObj("���յ�#����",i).parentElement.innerHTML += "<a href=''>" + arr[eiid].prtitle + "</a>";
					}else{
						var einame = getTableFormObj("���յ�#���յ�",i).value;
						getTableFormObj("���յ�#����",i).parentElement.innerHTML += "<a href='javascript:createProcess(" + eiid + ",\"" + einame + "\");'>��������嵥</a>";
					}
				}
			}
			var tb2 = document.getElementById(arr_pidlabelObj["�����"] + "_tableForm");
			for(var i=1;i<tb2.rows.length;i++){
				var isCheck = getTableFormObj("�����#ѡ��",i);
				if(isCheck.value == "."){
					var eiid = getTableFormObj("�����#�����ID",i).value;
					if(arr[eiid]){
						getTableFormObj("�����#����",i).parentElement.innerHTML += "<a href=''>" + arr[eiid].prtitle + "</a>";
					}else{
						var einame = getTableFormObj("�����#�����",i).value;
						getTableFormObj("�����#����",i).parentElement.innerHTML += "<a href='javascript:createProcess(" + eiid + ",\"" + einame + "\");'>��������嵥</a>";
					}
				}
			}
		},
		//ʧ�ܻص�����
		error:function(XMLHttpRequest, textStatus, errorThrown){
			alert("��ȡ�����嵥��Ϣ�쳣��");
		}
	});
}

/**
 * ��������嵥
 * @param eiid �����ʲ�ID
 */
function createProcess(eiid,einame){
	var prid = document.getElementById("prid").value;
	window.showModalDialog(getAppRootUrl() + "/IGCOM0401.do?parprid="+prid+
            "&prtype=WD&prpdid=01000&flag=0&ptid=8&parameters=" + eiid + ",,,," + einame,
            null,"dialogWidth:1080px;dialogHeight:650px;status:no;help:no;resizable:yes");
	window.location.href = "IGPRR0102_Disp.do?prid=" + prid; 
}