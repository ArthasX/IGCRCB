/**
 * �����������̶���ҳjs 
 */

/**
 * ����ڵ��ʼ��
 */
function init_001(){
	var access = jQuery(getFormObj("��������")).parent().find("[name='pidaccess']").val();
	//���ز���Ҫ�ı���
	var objs = getTableFormObjs("��������#���յ�#���յ�");
	if(objs != null){
		for(var i=0;i<objs.length;i++){
			var tb = objs[i].parentElement.parentElement.parentElement;
			for(var n=2;n<tb.rows[0].cells.length;n++){
				tb.rows[0].cells[n].style.display = "none";
			}
			var tr = objs[i].parentElement.parentElement;
			for(var n=2;n<tr.cells.length;n++){
				tr.cells[n].style.display = "none";
			}
			if(access == 3){
				objs[i].style.display = "none";
				objs[i].parentElement.innerHTML += "<span class='tempadd'>" + objs[i].value + "</span>";
			}
		}
	}
	objs = getTableFormObjs("��������#�����#�����");
	if(objs != null){
		for(var i=0;i<objs.length;i++){
			var tb = objs[i].parentElement.parentElement.parentElement;
			for(var n=2;n<tb.rows[0].cells.length;n++){
				tb.rows[0].cells[n].style.display = "none";
			}
			var tr = objs[i].parentElement.parentElement;
			for(var n=2;n<tr.cells.length;n++){
				tr.cells[n].style.display = "none";
			}
			if(access == 3){
				objs[i].style.display = "none";
				objs[i].parentElement.innerHTML += "<span class='tempadd'>" + objs[i].value + "</span>";
			}
		}
	}
	if(access == 3){
		objs = getTableFormObjs("��������#�������");
		if(objs != null){
			for(var i=0;i<objs.length;i++){
				objs[i].style.display = "none";
				objs[i].parentElement.innerHTML += "<span class='tempadd'>" + objs[i].value + "</span>";
			}
		}
	}
	//�����Ҽ��˵�
	jQuery(".rightMenu").each(function(i,o){
		o.className = "";
	});
	//����ոշ��������������ݱ�
	if(getFormObj("�������").value == ""){
		getFormObj("��������").parentElement.parentElement.style.display = "none";
	}
	jQuery("table[id^='0100101011']").each(function(idx,tb){
		for(var i=2;i<tb.rows[0].cells.length;i++){
			tb.rows[0].cells[i].style.display = "none";
		}
	});
	jQuery("table[id^='0100101010']").each(function(idx,tb){
		for(var i=2;i<tb.rows[0].cells.length;i++){
			tb.rows[0].cells[i].style.display = "none";
		}
	});
}

/**
 * ִ�нڵ��ʼ��
 */
function init_002(){
	//���ز���Ҫ�ı���
	var objs = getTableFormObjs("��������#���յ�#���յ�");
	if(objs != null){
		for(var i=0;i<objs.length;i++){
			var tb = objs[i].parentElement.parentElement.parentElement;
			for(var n=4;n<tb.rows[0].cells.length;n++){
				tb.rows[0].cells[n].style.display = "none";
			}
			var tr = objs[i].parentElement.parentElement;
			for(var n=4;n<tr.cells.length;n++){
				tr.cells[n].style.display = "none";
			}
			var items = getTableFormCheckBox("��������#���յ�#ѡ��",objs[i].rownumber);
			for(var n=0;n<items.length;n++){
				items[n].disabled = true;
			}
			objs[i].style.display = "none";
			objs[i].parentElement.innerHTML += "<span class='tempadd'>" + objs[i].value + "</span>";
		}
	}
	objs = getTableFormObjs("��������#�����#�����");
	if(objs != null){
		for(var i=0;i<objs.length;i++){
			var tb = objs[i].parentElement.parentElement.parentElement;
			for(var n=4;n<tb.rows[0].cells.length;n++){
				tb.rows[0].cells[n].style.display = "none";
			}
			var tr = objs[i].parentElement.parentElement;
			for(var n=4;n<tr.cells.length;n++){
				tr.cells[n].style.display = "none";
			}
			var items = getTableFormCheckBox("��������#�����#ѡ��",objs[i].rownumber);
			for(var n=0;n<items.length;n++){
				items[n].disabled = true;
			}
			objs[i].style.display = "none";
			objs[i].parentElement.innerHTML += "<span class='tempadd'>" + objs[i].value + "</span>";
		}
	}
	objs = getTableFormObjs("��������#�������");
	if(objs != null){
		for(var i=0;i<objs.length;i++){
			objs[i].style.display = "none";
			objs[i].parentElement.innerHTML += "<span class='tempadd'>" + objs[i].value + "</span>";
		}
	}
	//�����Ҽ��˵�
	jQuery(".rightMenu").each(function(i,o){
		o.className = "";
	});
	//����ոշ��������������ݱ�
	if(getFormObj("�������").value == ""){
		getFormObj("��������").parentElement.parentElement.style.display = "none";
	}
	
	getRelationProcess();
}

function init_003(){
	//���ز���Ҫ�ı���
	var objs = getTableFormObjs("��������#���յ�#���յ�");
	if(objs != null){
		for(var i=0;i<objs.length;i++){
			var tb = objs[i].parentElement.parentElement.parentElement;
			for(var n=4;n<tb.rows[0].cells.length;n++){
				tb.rows[0].cells[n].style.display = "none";
			}
			var tr = objs[i].parentElement.parentElement;
			for(var n=4;n<tr.cells.length;n++){
				tr.cells[n].style.display = "none";
			}
		}
	}
	objs = getTableFormObjs("��������#�����#�����");
	if(objs != null){
		for(var i=0;i<objs.length;i++){
			var tb = objs[i].parentElement.parentElement.parentElement;
			for(var n=4;n<tb.rows[0].cells.length;n++){
				tb.rows[0].cells[n].style.display = "none";
			}
			var tr = objs[i].parentElement.parentElement;
			for(var n=4;n<tr.cells.length;n++){
				tr.cells[n].style.display = "none";
			}
		}
	}
	//�����Ҽ��˵�
	jQuery(".rightMenu").each(function(i,o){
		o.className = "";
	});
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
		document.getElementById("show_value_pidid0100101005").value = resultlist;
		getFormObj("�������").value = rcids;
		cleanTableForm();
		gangedASM013(rcids,resultlist);
		gangedASM014(rcids,resultlist);
	}		
}

/**
 * ��ձ��ʽ��ֵ�����ر��ʽ��
 */
function cleanTableForm(){
	getFormObj("��������").parentElement.parentElement.style.display = "none";
	cleanTableFormValue();
}

function cleanTableFormValue(){
	var tb = document.getElementById(arr_pidlabelObj["��������"] + "_tableForm");
	for(var i=tb.rows.length-1;i>0;i--){
		deleteGroup(tb.rows[i]);
	}
	var objs = getTableFormObjs("��������#���յ�#���յ�");
	for(var i=0;i<objs.length;i++){
		if(objs[i].rownumber.indexOf("_#_") < 0){
			deleteRow(objs[i].parentElement.parentElement);
		}
	}
	objs = getTableFormObjs("��������#���յ�#���յ�");
	for(var i=0;i<objs.length;i++){
		var tr = objs[i].parentElement.parentElement;
		for(var n=2;n<tr.cells.length;n++){
			tr.cells[n].style.display = "none";
		}
	}
	objs = getTableFormObjs("��������#�����#�����");
	for(var i=0;i<objs.length;i++){
		if(objs[i].rownumber.indexOf("_#_") < 0){
			deleteRow(objs[i].parentElement.parentElement);
		}
	}
	objs = getTableFormObjs("��������#�����#�����");
	for(var i=0;i<objs.length;i++){
		var tr = objs[i].parentElement.parentElement;
		for(var n=2;n<tr.cells.length;n++){
			tr.cells[n].style.display = "none";
		}
	}
	var obj = getTableFormObj("��������#�������", 1);
	obj.value = '';
	jQuery(obj).parent().find(".tempadd").remove();
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
			//ȡ�ñ�����
			var tb = document.getElementById(arr_pidlabelObj["��������"] + "_tableForm");
			for(var i=0;i<data.length;i++){
				//�����һ�����ݣ������
				if( i > 0){
					var tr = addGroup(tb.rows[0]);
					//ɾ���¼��е��Ҽ��˵�
					tr.onmousedown = "";
					tr.oncontextmenu = function(){return true;};
					tr.className = "";
				}
				//���÷��յ��ֵ
				var item_name = getTableFormObj("��������#�������",(i + 1) + "");
				item_name.value = resultlist[i];
				item_name.style.display = "none";
				item_name.parentElement.innerHTML += "<span class='tempadd'>" + resultlist[i] + "</span>";
				//�����ӱ������
				for(var j=0;j<data[i].length;j++){
					//�����ֻһ�����ݣ������
					if(j > 0){
						var tr = addRow(getTableFormObj("��������#���յ�#���յ�",(i + 1) + "_1").parentElement.parentElement);
						//ɾ���¼��е��Ҽ��˵�
						tr.onmousedown = "";
						tr.oncontextmenu = function(){return true;};
						tr.className = "";
					}
					var item_001 = getTableFormObj("��������#���յ�#���յ�",(i + 1) + "_" + (1 + j));
					item_001.value = data[i][j].einame;
					item_001.style.display = "none";
					item_001.parentElement.innerHTML += "<span class='tempadd'>" + data[i][j].einame + "</span>";
					getTableFormObj("��������#���յ�#���յ�ID",(i + 1) + "_" + (1 + j)).value = data[i][j].eiid;// ���յ�ID
					//���ز���Ҫ��ʾ����
					getTableFormObj("��������#���յ�#�����",(i + 1) + "_" + (1 + j)).parentElement.style.display = "none";
					getTableFormObj("��������#���յ�#���յ�ID",(i + 1) + "_" + (1 + j)).parentElement.style.display = "none";
					getTableFormObj("��������#���յ�#����",(i + 1) + "_" + (1 + j)).parentElement.style.display = "none";
				}
				
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
function gangedASM014(rcids,str){
	//-----------��ѯ���յ�----------
	var resultlist = str.split(",");
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
			//ȡ�ñ�����
			var tb = document.getElementById(arr_pidlabelObj["��������"] + "_tableForm");
			for(var i=0;i<data.length;i++){
				//�����һ�����ݣ������
				if( i > tb.rows.length - 1){
					var tr = addGroup(tb.rows[0]);
					//ɾ���¼��е��Ҽ��˵�
					tr.onmousedown = "";
					tr.oncontextmenu = function(){return true;};
					tr.className = "";
					
					var item_name = getTableFormObj("��������#�������",(i + 1) + "");
					item_name.value = resultlist[i];
					item_name.style.display = "none";
					item_name.parentElement.innerHTML += "<span class='tempadd'>" + resultlist[i] + "</span>";
				}
				for(var j=0;j<data[i].length;j++){
					//��һ������λ��Ĭ�ϴ��ڣ�������ݴ���һ�У��������
					if(j>0){
						var tr = addRow(getTableFormObj("��������#�����#�����",(i + 1) + "_1").parentElement.parentElement);
						//ɾ���¼��е��Ҽ��˵�
						tr.onmousedown = "";
						tr.oncontextmenu = function(){return true;};
						tr.className = "";
					}
					//���ü�����ֵ
					var item_001 = getTableFormObj("��������#�����#�����",(i + 1) + "_" + (j + 1));
					item_001.value = data[i][j].einame;
					item_001.style.display = "none";
					item_001.parentElement.innerHTML += "<span class='tempadd'>" + data[i][j].einame + "</span>";
					//���ز���Ҫ��ʾ����
					getTableFormObj("��������#�����#���տ������",(i + 1) + "_" + (j + 1)).parentElement.style.display = "none";
					getTableFormObj("��������#�����#�����ID",(i + 1) + "_" + (j + 1)).parentElement.style.display = "none";
					getTableFormObj("��������#�����#����",(i + 1) + "_" + (j + 1)).parentElement.style.display = "none";
					
				}
			}
		},
		//ʧ�ܻص�����
		error:function(XMLHttpRequest, textStatus, errorThrown){
			alert("��ȡ����������쳣");
		}
	});
}

function getRelationProcess(){
	var prid = document.getElementById("prid").value;
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
			var objs = getTableFormObjs("��������#���յ�#���յ�");
			if(objs != null){
				for(var i=0;i<objs.length;i++){
					var isCheck = getTableFormObj("��������#���յ�#ѡ��",objs[i].rownumber);
					if(isCheck.value == "."){
						var eiid = getTableFormObj("��������#���յ�#���յ�ID",objs[i].rownumber).value;
						if(arr[eiid]){
							getTableFormObj("��������#���յ�#����",objs[i].rownumber).parentElement.innerHTML += "<a href='javascript:openEntity(" + arr[eiid].eiversion + ");'>" + arr[eiid].einame + "</a>";
						}else{
							if(getTableFormObj("��������#���յ�#�����",objs[i].rownumber).outerHTML.toUpperCase().indexOf("SELECT") >= 0){
								getTableFormObj("��������#���յ�#����",objs[i].rownumber).parentElement.innerHTML += "<a href='javascript:createEntity(" + eiid + ");'>��������¼�</a>";
							}
						}
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
function createEntity(eiid){
	var prid = document.getElementById("prid").value;
	window.showModalDialog(getAppRootUrl() + "/IGASM0115.do?prid=" + prid + "&riskEiid=" + eiid,
            null,"dialogWidth:1000px;dialogHeight:650px;status:no;help:no;resizable:no");
	window.location.href = "IGPRR0102_Disp.do?prid=" + prid; 
}
function openEntity(eiid){
	openSubWindow("/IGASM3203_T.do?eiid=" + eiid, "_blank", 1100, 600);
}