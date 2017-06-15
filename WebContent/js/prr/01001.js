/**
 * 风险评估流程定制页js 
 */

/**
 * 发起节点初始化
 */
function init_001(){
	var access = jQuery(getFormObj("评估内容")).parent().find("[name='pidaccess']").val();
	//隐藏不需要的标题
	var objs = getTableFormObjs("评估内容#风险点#风险点");
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
	objs = getTableFormObjs("评估内容#检查项#检查项");
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
		objs = getTableFormObjs("评估内容#风险类别");
		if(objs != null){
			for(var i=0;i<objs.length;i++){
				objs[i].style.display = "none";
				objs[i].parentElement.innerHTML += "<span class='tempadd'>" + objs[i].value + "</span>";
			}
		}
	}
	//屏蔽右键菜单
	jQuery(".rightMenu").each(function(i,o){
		o.className = "";
	});
	//如果刚刚发起，隐藏评估内容表单
	if(getFormObj("风险类别").value == ""){
		getFormObj("评估内容").parentElement.parentElement.style.display = "none";
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
 * 执行节点初始化
 */
function init_002(){
	//隐藏不需要的标题
	var objs = getTableFormObjs("评估内容#风险点#风险点");
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
			var items = getTableFormCheckBox("评估内容#风险点#选择",objs[i].rownumber);
			for(var n=0;n<items.length;n++){
				items[n].disabled = true;
			}
			objs[i].style.display = "none";
			objs[i].parentElement.innerHTML += "<span class='tempadd'>" + objs[i].value + "</span>";
		}
	}
	objs = getTableFormObjs("评估内容#检查项#检查项");
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
			var items = getTableFormCheckBox("评估内容#检查项#选择",objs[i].rownumber);
			for(var n=0;n<items.length;n++){
				items[n].disabled = true;
			}
			objs[i].style.display = "none";
			objs[i].parentElement.innerHTML += "<span class='tempadd'>" + objs[i].value + "</span>";
		}
	}
	objs = getTableFormObjs("评估内容#风险类别");
	if(objs != null){
		for(var i=0;i<objs.length;i++){
			objs[i].style.display = "none";
			objs[i].parentElement.innerHTML += "<span class='tempadd'>" + objs[i].value + "</span>";
		}
	}
	//屏蔽右键菜单
	jQuery(".rightMenu").each(function(i,o){
		o.className = "";
	});
	//如果刚刚发起，隐藏评估内容表单
	if(getFormObj("风险类别").value == ""){
		getFormObj("评估内容").parentElement.parentElement.style.display = "none";
	}
	
	getRelationProcess();
}

function init_003(){
	//隐藏不需要的标题
	var objs = getTableFormObjs("评估内容#风险点#风险点");
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
	objs = getTableFormObjs("评估内容#检查项#检查项");
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
	//屏蔽右键菜单
	jQuery(".rightMenu").each(function(i,o){
		o.className = "";
	});
}

/**
 * 打开资产模型树选择风险类别
 * @param obj 点击的图片dom对象
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
			alert("资产模型不可用！请选择其他模型！");
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
		getFormObj("风险类别").value = rcids;
		cleanTableForm();
		gangedASM013(rcids,resultlist);
		gangedASM014(rcids,resultlist);
	}		
}

/**
 * 清空表格式表单值并隐藏表格式表单
 */
function cleanTableForm(){
	getFormObj("评估内容").parentElement.parentElement.style.display = "none";
	cleanTableFormValue();
}

function cleanTableFormValue(){
	var tb = document.getElementById(arr_pidlabelObj["评估内容"] + "_tableForm");
	for(var i=tb.rows.length-1;i>0;i--){
		deleteGroup(tb.rows[i]);
	}
	var objs = getTableFormObjs("评估内容#风险点#风险点");
	for(var i=0;i<objs.length;i++){
		if(objs[i].rownumber.indexOf("_#_") < 0){
			deleteRow(objs[i].parentElement.parentElement);
		}
	}
	objs = getTableFormObjs("评估内容#风险点#风险点");
	for(var i=0;i<objs.length;i++){
		var tr = objs[i].parentElement.parentElement;
		for(var n=2;n<tr.cells.length;n++){
			tr.cells[n].style.display = "none";
		}
	}
	objs = getTableFormObjs("评估内容#检查项#检查项");
	for(var i=0;i<objs.length;i++){
		if(objs[i].rownumber.indexOf("_#_") < 0){
			deleteRow(objs[i].parentElement.parentElement);
		}
	}
	objs = getTableFormObjs("评估内容#检查项#检查项");
	for(var i=0;i<objs.length;i++){
		var tr = objs[i].parentElement.parentElement;
		for(var n=2;n<tr.cells.length;n++){
			tr.cells[n].style.display = "none";
		}
	}
	var obj = getTableFormObj("评估内容#风险类别", 1);
	obj.value = '';
	jQuery(obj).parent().find(".tempadd").remove();
}

/**
 * 联动风险点表格式表单
 */
function gangedASM013(rcids,str){
	//-----------查询风险点----------
	var resultlist = str.split(",");
	// 显示风险点表格式表单
	getFormObj("评估内容").parentElement.parentElement.style.display = "";
	//封装参数
	var params = {};
	params.esyscoding = rcids;
	// ajax请求数据
	jQuery.ajax({
		url:"IGFXK0401_GetAsm013.do",
		type:"POST",
		dataType :"json",
		data:params,
		cache:false,
		// 成功回调函数
		success:function(data){
			//取得表格对象
			var tb = document.getElementById(arr_pidlabelObj["评估内容"] + "_tableForm");
			for(var i=0;i<data.length;i++){
				//如果不一组数据，添加组
				if( i > 0){
					var tr = addGroup(tb.rows[0]);
					//删掉新加行的右键菜单
					tr.onmousedown = "";
					tr.oncontextmenu = function(){return true;};
					tr.className = "";
				}
				//设置风险点的值
				var item_name = getTableFormObj("评估内容#风险类别",(i + 1) + "");
				item_name.value = resultlist[i];
				item_name.style.display = "none";
				item_name.parentElement.innerHTML += "<span class='tempadd'>" + resultlist[i] + "</span>";
				//遍历子表格数据
				for(var j=0;j<data[i].length;j++){
					//如果不只一行数据，添加行
					if(j > 0){
						var tr = addRow(getTableFormObj("评估内容#风险点#风险点",(i + 1) + "_1").parentElement.parentElement);
						//删掉新加行的右键菜单
						tr.onmousedown = "";
						tr.oncontextmenu = function(){return true;};
						tr.className = "";
					}
					var item_001 = getTableFormObj("评估内容#风险点#风险点",(i + 1) + "_" + (1 + j));
					item_001.value = data[i][j].einame;
					item_001.style.display = "none";
					item_001.parentElement.innerHTML += "<span class='tempadd'>" + data[i][j].einame + "</span>";
					getTableFormObj("评估内容#风险点#风险点ID",(i + 1) + "_" + (1 + j)).value = data[i][j].eiid;// 风险点ID
					//隐藏不必要显示的列
					getTableFormObj("评估内容#风险点#检查结果",(i + 1) + "_" + (1 + j)).parentElement.style.display = "none";
					getTableFormObj("评估内容#风险点#风险点ID",(i + 1) + "_" + (1 + j)).parentElement.style.display = "none";
					getTableFormObj("评估内容#风险点#操作",(i + 1) + "_" + (1 + j)).parentElement.style.display = "none";
				}
				
			}
		},
		//失败回调函数
		error:function(XMLHttpRequest, textStatus, errorThrown){
			alert("获取风险点数据异常");
		}
	});
}

/**
 * 联动检查项
 */
function gangedASM014(rcids,str){
	//-----------查询风险点----------
	var resultlist = str.split(",");
	//封装参数
	var params = {};
	params.esyscoding = rcids;
	//ajax请求数据
	jQuery.ajax({
		url:"IGFXK0401_GetAsm014.do",
		type:"POST",
		dataType :"json",
		data:params,
		cache:false,
		//成功回调函数
		success:function(data){
			//取得表格对象
			var tb = document.getElementById(arr_pidlabelObj["评估内容"] + "_tableForm");
			for(var i=0;i<data.length;i++){
				//如果不一组数据，添加组
				if( i > tb.rows.length - 1){
					var tr = addGroup(tb.rows[0]);
					//删掉新加行的右键菜单
					tr.onmousedown = "";
					tr.oncontextmenu = function(){return true;};
					tr.className = "";
					
					var item_name = getTableFormObj("评估内容#风险类别",(i + 1) + "");
					item_name.value = resultlist[i];
					item_name.style.display = "none";
					item_name.parentElement.innerHTML += "<span class='tempadd'>" + resultlist[i] + "</span>";
				}
				for(var j=0;j<data[i].length;j++){
					//第一行数据位置默认存在，如果数据大于一行，则添加行
					if(j>0){
						var tr = addRow(getTableFormObj("评估内容#检查项#检查项",(i + 1) + "_1").parentElement.parentElement);
						//删掉新加行的右键菜单
						tr.onmousedown = "";
						tr.oncontextmenu = function(){return true;};
						tr.className = "";
					}
					//设置检查项的值
					var item_001 = getTableFormObj("评估内容#检查项#检查项",(i + 1) + "_" + (j + 1));
					item_001.value = data[i][j].einame;
					item_001.style.display = "none";
					item_001.parentElement.innerHTML += "<span class='tempadd'>" + data[i][j].einame + "</span>";
					//隐藏不必要显示的列
					getTableFormObj("评估内容#检查项#风险控制情况",(i + 1) + "_" + (j + 1)).parentElement.style.display = "none";
					getTableFormObj("评估内容#检查项#检查项ID",(i + 1) + "_" + (j + 1)).parentElement.style.display = "none";
					getTableFormObj("评估内容#检查项#操作",(i + 1) + "_" + (j + 1)).parentElement.style.display = "none";
					
				}
			}
		},
		//失败回调函数
		error:function(XMLHttpRequest, textStatus, errorThrown){
			alert("获取检查项数据异常");
		}
	});
}

function getRelationProcess(){
	var prid = document.getElementById("prid").value;
	var params = {};
	params.prid = prid;
	//ajax请求数据
	jQuery.ajax({
		url:"IGFXK0401_GetRelationProcess.do",
		type:"POST",
		dataType :"json",
		data:params,
		cache:false,
		//成功回调函数
		success:function(data){
			var arr = new Array();
			if(data != null && data.length > 0){
				for(var i=0;i<data.length;i++){
					arr[data[i].eiid] = data[i];
				}
			}
			var objs = getTableFormObjs("评估内容#风险点#风险点");
			if(objs != null){
				for(var i=0;i<objs.length;i++){
					var isCheck = getTableFormObj("评估内容#风险点#选择",objs[i].rownumber);
					if(isCheck.value == "."){
						var eiid = getTableFormObj("评估内容#风险点#风险点ID",objs[i].rownumber).value;
						if(arr[eiid]){
							getTableFormObj("评估内容#风险点#操作",objs[i].rownumber).parentElement.innerHTML += "<a href='javascript:openEntity(" + arr[eiid].eiversion + ");'>" + arr[eiid].einame + "</a>";
						}else{
							if(getTableFormObj("评估内容#风险点#检查结果",objs[i].rownumber).outerHTML.toUpperCase().indexOf("SELECT") >= 0){
								getTableFormObj("评估内容#风险点#操作",objs[i].rownumber).parentElement.innerHTML += "<a href='javascript:createEntity(" + eiid + ");'>发起风险事件</a>";
							}
						}
					}
				}
			}
		},
		//失败回调函数
		error:function(XMLHttpRequest, textStatus, errorThrown){
			alert("获取风险清单信息异常！");
		}
	});
}

/**
 * 发起风险清单
 * @param eiid 风险资产ID
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