/**
 * 风险评估流程定制页js 
 */


//隐藏表单
jQuery(document).ready(function(){
	if(getFormObj("分派标示")!=null){
		getFormObj("分派标示").parentElement.parentElement.style.display = "none";
	}
	if(getFormObj("人员")!=null){
		getFormObj("人员").parentElement.parentElement.style.display = "none";
	}
});
/**
 * 发起节点初始化
 */
function init_001(){
	//隐藏风险类别输入框
	getFormObj("评估内容").parentElement.parentElement.style.display = "none";
	
}

/**
 * 执行节点初始化
 */
function init_002(){
	var tb1 = document.getElementById(arr_pidlabelObj["风险点"] + "_tableForm");
	var tb2 = document.getElementById(arr_pidlabelObj["检查项"] + "_tableForm");
	
	//没有数据时隐藏风险点表格式表单
	if(tb1.rows.length < 3){
		getFormObj("风险点").parentElement.parentElement.style.display = "none";
	}else{
		for(var i=0;i<tb1.rows.length;i++){
			if(i > 0){
				var item = getTableFormObj("风险点#风险点",i);
				if(item.type == "text"){
					item.style.display = "none";
					item.parentElement.innerHTML += "<span class='tempadd'>" + item.value + "</span>";
				}
				var items = getTableFormCheckBox("风险点#选择",i);
				for(var n=0;n<items.length;n++){
					items[n].disabled = true;
				}
			}
			for(var j=4;j<tb1.rows[i].cells.length;j++){
				tb1.rows[i].cells[j].style.display = "none";
			}
		}
	}
	//没有数据时隐藏检查项表单
	if(tb2.rows.length < 3){
		getFormObj("检查项").parentElement.parentElement.style.display = "none";
	}else{
		for(var i=0;i<tb2.rows.length;i++){
			if(i > 0){
				var item = getTableFormObj("检查项#检查项",i);
				if(item.type == "text"){
					item.style.display = "none";
					item.parentElement.innerHTML += "<span class='tempadd'>" + item.value + "</span>";
				}
				var items = getTableFormCheckBox("检查项#选择",i);
				for(var n=0;n<items.length;n++){
					items[n].disabled = true;
				}
			}
			for(var j=3;j<tb2.rows[i].cells.length;j++){
				tb2.rows[i].cells[j].style.display = "none";
			}
		}
	}
	
	//屏蔽风险点表格式表单右键菜单
	deleteRightMenu(tb1);
	//屏蔽检查项表格式表单右键菜单
	deleteRightMenu(tb2);
}

/**
 * 审核节点初始化
 */
function init_003(){
	var tb1 = document.getElementById(arr_pidlabelObj["风险点"] + "_tableForm");
	var tb2 = document.getElementById(arr_pidlabelObj["检查项"] + "_tableForm");
	
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
 * 去掉表格式表单行上面加的右键菜单样式，这样下面加载时则不会增加右键菜单
 */
function deleteRightMenu(tb){
	for(var i=0;i<tb.rows.length;i++){
		if(tb.rows[i].className == "rightMenu"){
			tb.rows[i].className = "";
		}
	}
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
		var name = temp.split("|")[1];
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
		document.getElementById("RiskCategory").value = resultlist;
		document.getElementById("RiskCategoryID").value = rcids;
		cleanTableForm();
		gangedASM013(rcids,resultlist);
		gangedASM014(rcids);
	}		
}

/**
 * 清空表格式表单值并隐藏表格式表单
 */
function cleanTableForm(){
//	getFormObj("风险点").parentElement.parentElement.style.display = "none";
//	getFormObj("检查项").parentElement.parentElement.style.display = "none";
//	getTableFormObj("评估内容#风险点").parentElement.parentElement.style.display = "none";
//	getTableFormObj("评估内容#检查项").parentElement.parentElement.style.display = "none";
	
//	cleanTableFormValue(document.getElementById(arr_pidlabelObj["风险点"] + "_tableForm"));
//	cleanTableFormValue(document.getElementById(arr_pidlabelObj["检查项"] + "_tableForm"));
	getFormObj("评估内容").parentElement.parentElement.style.display = "none";
	cleanTableFormValue();
}

function cleanTableFormValue(){
//	var tb = document.getElementById(arr_pidlabelObj["评估内容"] + "_tableForm");
//	alert(tb.length);
//	//如果表格包含历史数据，清除部分历史数据
//	if(tb.rows.length > 2) {
//		for(var n=tb.rows.length;n>2;n--){
//			var tr = tb.rows[n-1];
//			tb.deleteRow(tr.rowIndex);
//		}
//	}
//	//清空第一行数据
//	var temps = tb.rows[1].cells[1].childNodes;
//	alert(temps);
//	for(var j=0;j<temps.length;j++){
//		if(temps[j].className == "tempadd"){
//			temps[j].outerHTML = "";
//		}
//	}
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
			for(var j=0;j in data;j++){
				// 取得表格对象
				var tb_tableForm = document.getElementById(arr_pidlabelObj["评估内容#风险点"] + "_tableForm");
				var tb_tr = null;
				if(j>0){
					// 组模式添加行
					addGroup(tb_tableForm.rows[0]);
					tb_tr = tb_tableForm.rows[tb_tableForm.rows.length - 1];
					//删掉新加行的右键菜单
					tb_tr.onmousedown = "";
					tb_tr.oncontextmenu = function(){return true;};
					tb_tr.className = "";
				}else{
					tb_tr = tb_tableForm.rows[tb_tableForm.rows.length - 1];
					//删掉新加行的右键菜单
					tb_tr.onmousedown = "";
					tb_tr.oncontextmenu = function(){return true;};
					tb_tr.className = "";
				}
				// 取得表格对象
				var tb = document.getElementById(arr_pidlabelObj["评估内容#风险点"] + "_tableForm");
				// 遍历装载数据
				for(var i=0;i<data[j].length;i++){
					//第一行数据位置默认存在，如果数据大于一行，则添加行
					var tr = null;
					if(i>0){
						addRow(tb.rows[0]);
						tr = tb.rows[tb.rows.length - 1];
						//删掉新加行的右键菜单
						tr.onmousedown = "";
						tr.oncontextmenu = function(){return true;};
						tr.className = "";
					}else{
						tr = tb.rows[tb.rows.length - 1];
						//设置风险点的值
						var item_name = document.getElementById("0114001020"+"_"+(j + 1));
						item_name.value = resultlist[j];
						item_name.style.display = "none";
						item_name.parentElement.innerHTML += "<span class='tempadd'>" + resultlist[j] + "</span>";
					}
					var item_001 = document.getElementById("0114001014_"+ (j + 1) +"_"+(1 + i));// 风险点
					item_001.value = data[j][i].einame;
					item_001.style.display = "none";
					item_001.parentElement.innerHTML += "<span class='tempadd'>" + data[j][i].einame + "</span>";
					document.getElementById("0114001018_"+ (j + 1) +"_"+(1 + i)).value = data[j][i].eiid;// 风险点ID
					//隐藏标题
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
			//失败回调函数
			error:function(XMLHttpRequest, textStatus, errorThrown){
				alert("获取风险点数据异常");
			}
		});
}

/**
 * 联动检查项
 */
function gangedASM014(rcids){
	//-----------查询风险点----------
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
		for(var j=0;j in data;j++){
			// 取得表格对象
			var tb = document.getElementById(arr_pidlabelObj["评估内容#检查项"] + "_tableForm");
			// 遍历装载数据
			for(var i=0;i<data[j].length;i++){
				//第一行数据位置默认存在，如果数据大于一行，则添加行
				var tr = null;
				if(i>0){
					addRow(tb.rows[1]);
					tr = tb.rows[tb.rows.length - 1];
					//删掉新加行的右键菜单
					tr.onmousedown = "";
					tr.oncontextmenu = function(){return true;};
					tr.className = "";
				}else{
					tr = tb.rows[tb.rows.length - 1];
				}
				//设置风险点的值
				var item_001 = document.getElementById("0114001009_"+ (j + 1) +"_"+(1 + i));// 检查项
				item_001.value = data[j][i].einame;
				item_001.style.display = "none";
				item_001.parentElement.innerHTML += "<span class='tempadd'>" + data[j][i].einame + "</span>";
				document.getElementById("0114001012_"+ (j + 1) +"_"+(1 + i)).value = data[j][i].eiid;// 风险点ID
			}
			
			//隐藏标题
//			for(var k=3;k<tb.rows[0].cells.length;k++){
//				tb.rows[0].cells[k].style.display = "none";
//			}
		}
		},
		//失败回调函数
		error:function(XMLHttpRequest, textStatus, errorThrown){
			alert("获取检查项数据异常");
		}
	});
}

function getRelationProcess(){
	var prid = document.getElementById("prid");
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
			var tb1 = document.getElementById(arr_pidlabelObj["风险点"] + "_tableForm");
			for(var i=1;i<tb1.rows.length;i++){
				var isCheck = getTableFormObj("风险点#选择",i);
				if(isCheck.value == "."){
					var eiid = getTableFormObj("风险点#风险点ID",i).value;
					if(arr[eiid]){
						getTableFormObj("风险点#操作",i).parentElement.innerHTML += "<a href=''>" + arr[eiid].prtitle + "</a>";
					}else{
						var einame = getTableFormObj("风险点#风险点",i).value;
						getTableFormObj("风险点#操作",i).parentElement.innerHTML += "<a href='javascript:createProcess(" + eiid + ",\"" + einame + "\");'>发起风险清单</a>";
					}
				}
			}
			var tb2 = document.getElementById(arr_pidlabelObj["检查项"] + "_tableForm");
			for(var i=1;i<tb2.rows.length;i++){
				var isCheck = getTableFormObj("检查项#选择",i);
				if(isCheck.value == "."){
					var eiid = getTableFormObj("检查项#检查项ID",i).value;
					if(arr[eiid]){
						getTableFormObj("检查项#操作",i).parentElement.innerHTML += "<a href=''>" + arr[eiid].prtitle + "</a>";
					}else{
						var einame = getTableFormObj("检查项#检查项",i).value;
						getTableFormObj("检查项#操作",i).parentElement.innerHTML += "<a href='javascript:createProcess(" + eiid + ",\"" + einame + "\");'>发起风险清单</a>";
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
function createProcess(eiid,einame){
	var prid = document.getElementById("prid").value;
	window.showModalDialog(getAppRootUrl() + "/IGCOM0401.do?parprid="+prid+
            "&prtype=WD&prpdid=01000&flag=0&ptid=8&parameters=" + eiid + ",,,," + einame,
            null,"dialogWidth:1080px;dialogHeight:650px;status:no;help:no;resizable:yes");
	window.location.href = "IGPRR0102_Disp.do?prid=" + prid; 
}