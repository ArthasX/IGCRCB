/**
 * eventObj：事件源
 * 
 * 当右键点击表格式表单时，如果是可变行的表格式表单将会触发右键菜单
 * 此对象为触发事件的事件源对象，所有的新增行、删除行操作都会围绕此对象
 */
var eventObj = null;

/**
 * 生成可变行表格式表单行的右键菜单
 * 菜单包含内容：向上插入
 * 				向下插入
 * 				删除
 * 				上移
 * 				下移
 * 
 * @param obj -- 触发右键菜单时间的事件源
 * @param e  -- 事件对象
 */
var rightMenu = function(obj,e){
	var event = e || window.event;
	//判断是否是右键点击操作
	if(event.button == "2"){
		//生成右键菜单句柄
		oPopUp = window.createPopup();
		var popBody = oPopUp.document.body;
		popBody.style.backgroundColor = "#FFFF99";
		popBody.style.border = "none";
		//设定右键菜单内容
		var outStr = '<html><head><meta http-equiv="Content-Type" content="text/html; charset=gb2312"><style>';
			outStr += 'html,body{margin:0px;padding:0px;border:none;}';
		    outStr += '*{font-size: 12px; font-weight:800; font-family: 宋体;color:#666666}';
		    outStr += 'a{display:blok;width:100%;height:20px;background:#fff;text-align:left;margin:0px;padding-left:10px;line-height:20px;text-decoration:none;}';
		    outStr += 'a:hover{display:blok;width:100%;height:20px;background:#ccc;text-align:left;margin:0px;padding-left:10px;line-height:20px;text-decoration:none;}';
			outStr += '</style></head>';
			outStr += '<body style="overflow:hidden;padding:0px;">';
			outStr += '<div style="border:1px solid #ccc;">';
			outStr += '<a href="javascript:parent.rightMenuClick(1)">\u5411\u4e0a\u63d2\u5165</a>';
			outStr += '<a href="javascript:parent.rightMenuClick(2)">\u5411\u4e0b\u63d2\u5165</a>';
			outStr += '<a href="javascript:parent.rightMenuClick(3)">\u5220\u9664</a>';
			outStr += '<a href="javascript:parent.rightMenuClick(4)">\u4e0a\u79fb</a>';
			outStr += '<a href="javascript:parent.rightMenuClick(5)">\u4e0b\u79fb</a>';
			outStr += '</div>';
			outStr += '</body></html>';
		oPopUp.document.write(outStr);
		oPopUp.show(event.clientX,event.clientY + document.documentElement.scrollTop, 80, 110, document.body);
		eventObj = obj;
	}
};

/**
 * 页面加载完成时初始化必要信息
 */
function currentLoad(){
	if(document.readyState === "complete"){
		var objs = document.getElementsByTagName("tr");
		for(var i=0;i<objs.length;i++){
			//需要生成右键菜单的行添加右键菜单必要事件,并且屏蔽浏览器原生右键事件
			if(objs[i].className == "rightMenu"){
				//可变行套可变行bug
				objs[i].oncontextmenu = function(){return false;};
				jQuery(objs[i]).unbind("mousedown").mousedown(function(event){
					event.stopPropagation();
					rightMenu(this,event);
				}) ;
			}
		}
	}else{
		setTimeout("currentLoad()", 500);
	}
}
currentLoad();

/**
 * 点击右键菜单时进行对应操作
 * @param flag 1 在事件源对象之上添加一行；2 在事件源对象之下添加一行；3 删除当前行。
 */
function rightMenuClick(flag){
	if(eventObj && flag){
		//取得表格显示模式  1 二维表模式；2 组模式
		var display = eventObj.parentElement.parentElement.display;
		if(display == 1){
			switch (flag) {
				case 1:
					addRow(eventObj,eventObj.rowIndex);
					break;
				case 2:
					addRow(eventObj,eventObj.rowIndex + 1);
					break;
				case 3:
					deleteRow(eventObj);
					break;
				case 4:
					moveUp(eventObj);
					break;
				case 5:
					moveDown(eventObj);
					break;
				default:
					break;
			}
		}else{
			switch (flag) {
				case 1:
					addGroup(eventObj,eventObj.rowIndex);
					break;
				case 2:
					addGroup(eventObj,eventObj.rowIndex + 1);
					break;
				case 3:
					deleteGroup(eventObj);
					break;
				case 4:
					moveUp(eventObj);
					break;
				case 5:
					moveDown(eventObj);
					break;
				default:
					break;
			}
		}
	}
	//隐藏右键菜单句柄
	if(oPopUp){oPopUp.hide();};
	currentLoad();

}

/**
 * 
 * 二维表模式添加行
 * 
 * @param obj 事件源对象
 * @param insertRowNum 添加行的位置
 */
function addRow(obj,insertRowNum){
	//需要添加行的table对象
	var targetTab = obj.parentElement.parentElement;
	//模板对象
	var templateTab = document.getElementById(targetTab.id + "_template");
	//是否显示行号 Y 显示； N 不显示
	var showrownum = targetTab.showrownum;
	//遍历模板对象，将其内容添加到当前table对象中
	var tr = null;
	for(var i=0;i<templateTab.rows.length;i++){
		//需要添加的行对象
		//判断是否指定了行的添加位置，如果指定，在指定位置添加，如果未指定，默认添加到最后一行
		if(insertRowNum != null){
			tr = targetTab.insertRow(insertRowNum);
		}else{
			tr = targetTab.insertRow(targetTab.rows.length);
		}
		//设定新行的右键菜单
		tr.className = "rightMenu";
		tr.oncontextmenu = function(){return false;};
		jQuery(tr).unbind("mousedown").mousedown(function(event){
			event.stopPropagation();
			rightMenu(this,event);
		});
		//如果显示行号，预留行号显示位置
		if("Y" == showrownum){
			var indexCell2 = tr.insertCell(0);
			indexCell2.align = "center";
		}
		//遍历模板列，将其添加到当前对象中
		for(var j=0;j<templateTab.rows[i].cells.length;j++){
			var td = tr.insertCell();
			if( templateTab.rows[i].cells[j].style.textAlign){
				td.style.textAlign =  templateTab.rows[i].cells[j].style.textAlign;
			}
			td.innerHTML = templateTab.rows[i].cells[j].innerHTML;
		}
		//添加行后，行号有可能被打乱，需要重新排列行号
		shortRowNum(targetTab);
		var onAdd = targetTab.onAdd;
		if(onAdd){
			onAdd(tr);
		}
	}
	
	return tr;
}

/**
 * 二维表重新排列行号
 * 
 * @param targetTab 目标表格 
 */
function shortRowNum(targetTab){
	var rowSerIndex = 0;
	//父级表格的行号，如果没有则为空
	var parentRownum = "";
	//查找父级行号
	var objs = targetTab.parentElement.parentElement.childNodes;
	//是否显示行号 Y 显示； N 不显示
	var showrownum = targetTab.showrownum;
	if(objs != null){
		for(var index=0;index<objs.length;index++){
			if(objs[index].name == "column_table_rownumber" && "0" != objs[index].value){
				parentRownum = objs[index].value;
			}
		}
	}
	for(var i=0;i<targetTab.rows.length;i++){
		//titlerow为表格式表单名称显示行，titletr为表格式表单列标题显示行，此两行不参与行号排列
		if(targetTab.rows[i].name != "titlerow" && targetTab.rows[i].name != "titletr"){
			rowSerIndex ++;
			//----------- 重新排列序号 -----------
			if("Y" == showrownum){
				targetTab.rows[i].cells[0].innerHTML = rowSerIndex;
			}
			var rownumStr = parentRownum == "" ? rowSerIndex + "" : parentRownum + "_" + rowSerIndex;
			//----------- 重新排列隐含行号 -----------
			for(var k=0;k<targetTab.rows[i].cells.length;k++){
				var childs = targetTab.rows[i].cells[k].childNodes;
				if(childs != null && childs.length > 0){
					for(var n=0;n<childs.length;n++){
						//保存列值对象需要重新排列id以及行号属性
						if(childs[n].name == "column_value"){
							childs[n].id = childs[n].id.split("_")[0] + "_" + rownumStr;
							childs[n].rownumber = rownumStr;
						}
						//行号标识对象直接改变值
						if(childs[n].name == "column_rownumber" || childs[n].name == "column_table_rownumber"){
							childs[n].value = rownumStr;
						}
						//内部嵌套表格直接排列内容
						if(childs[n].name == "table_form_panel"){
							var tables = childs[n].childNodes;
							for(var j=0;j<tables.length;j++){
								if(tables[j].name == "table_form"){
									//表格模式 1 二维表；2 组模式。
									var display = tables[j].display;
									if(display == "1"){
										shortRowNum(tables[j]);
									}else{
										shortGroup(tables[j]);
									}
								}
							}
						}
					}
				}
			}
		}
	}
}

/**
 * 二维表模式表格式表单删除行
 * 
 * @param obj 事件源对象
 */
function deleteRow(obj){
	//目标table对象
	var tb = obj.parentElement.parentElement;
	//需要新增行标识：如果当前行为唯一数据行，则需要新增一行，然后再删除此行
	var index = 0;
	for(var i=0;i<tb.rows.length;i++){
		if(tb.rows[i].name != "titlerow" && tb.rows[i].name != "titletr"){
			index ++;
		}
	}
	var massage = "\u5df2\u7ecf\u662f\u6700\u540e\u4e00\u884c\uff0c\u4e0d\u80fd\u5220\u9664\uff01";
	if(index == 1){
		//last row
		alert(massage);
//		addRow(obj, obj.rowIndex);
	}else{
		var map = {};
		jQuery(tb).find("table[id$='_template']").each(function(index,obj){
			map[obj.id]=obj.outerHTML;
		});
		//要删除行的索引
		var rowIndex = obj.rowIndex;
		//删除行操作
		tb.deleteRow(rowIndex); 

		//删除行操作后行号有可能被打乱，需要重新排列
		shortRowNum(tb);
		for ( var prop in map) {
			if (map.hasOwnProperty(prop)) {
					jQuery("#"+prop.replace("_template","")).parent().append(jQuery(map[prop]).clone(true));
			}
		}
	}
}

/**
 * 删除模板对象
 */
function deleteTemplate(){
	//移除表格类表单要添加列模板table wangtingzhi  
	var templates = document.getElementsByTagName("table");
	if(templates != null){
		for(var i=0;i<templates.length;i++){
			var tid = templates[i].id;
			if(tid != null){
				if(tid.indexOf("_tableForm_template") > -1){
					templates[i].parentNode.removeChild(templates[i]);
				}
			}
		}
	}
}

/**
 * 
 * 组模式添加行
 * 
 * @param obj 事件源对象
 * @param insertRowNum 添加行的位置
 */
function addGroup(obj,insertRowNum){
	//需要添加行的table对象
	var targetTab = obj.parentElement.parentElement;
	//模板对象
	var templateTab = document.getElementById(targetTab.id + "_template");
	//新增行
	var tr = null;
	//判断是否指定了行的添加位置，如果指定，在指定位置添加，如果未指定，默认添加到最后一行
	if(insertRowNum != null){
		tr = targetTab.insertRow(insertRowNum);
	}else{
		tr = targetTab.insertRow(targetTab.rows.length);
	}
	//设定新行的右键菜单
	tr.className = "rightMenu";
	tr.oncontextmenu = function(){return false;};
	jQuery(tr).unbind("mousedown").mousedown(function(event){
		event.stopPropagation();
		rightMenu(this,event);
	});
	var td = tr.insertCell();
	td.innerHTML = templateTab.outerHTML;
	td.style.border = "none";
	shortGroup(targetTab);
	return tr;
}

/**
 * 组重新排列行号
 * 
 * @param targetTab 目标表格 
 */
function shortGroup(targetTab){
	var rowSerIndex = 0;
	//父级表格的行号，如果没有则为空
	var parentRownum = "";
	//查找父级行号
	var objs = targetTab.parentElement.parentElement.childNodes;
	if(objs != null){
		for(var index=0;index<objs.length;index++){
			if(objs[index].name == "column_table_rownumber" && "0" != objs[index].value){
				parentRownum = objs[index].value;
			}
		}
	}
	//----------- 重新排列隐含行号 -----------
	for(var i=0;i<targetTab.rows.length;i++){
		//titlerow为表格式表单名称显示行，titletr为表格式表单列标题显示行，此两行不参与行号排列
		if(targetTab.rows[i].name != "titlerow" && targetTab.rows[i].name != "titletr"){
			rowSerIndex ++;
			for(var k=0;k<targetTab.rows[i].cells.length;k++){
				var content = targetTab.rows[i].cells[k].childNodes[0];
				content.removeAttribute("style"); 
				content.removeAttribute("id"); 
				for(var crow=0;crow<content.rows.length;crow++){
					for(var ccell=0;ccell<content.rows[crow].cells.length;ccell++){
						var childs = content.rows[crow].cells[ccell].childNodes;
						if(childs != null && childs.length > 0){
							var rownumStr = parentRownum == "" ? rowSerIndex + "" : parentRownum + "_" + rowSerIndex;
							for(var k=0;k<childs.length;k++){
								var obj = childs[k];
								if("column_rownumber" == obj.name || obj.name == "column_table_rownumber"){
									obj.value = rownumStr;
								}
								if("column_value" == obj.name){
									obj.rownumber = rownumStr;
									obj.id = obj.id.split("_")[0] + "_" + rownumStr;
								}
								if("table_form_panel" == obj.name){
									var tables = obj.childNodes;
									for(var j=0;j<tables.length;j++){
										if(tables[j].name == "table_form"){
											//表格模式 1 二维表；2 组模式。
											var display = tables[j].display;
											if(display == "1"){
												shortRowNum(tables[j]);
											}else{
												shortGroup(tables[j]);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}

/**
 * 组模式表格式表单删除行
 * 
 * @param obj 事件源对象
 */
function deleteGroup(obj){
	//目标table对象
	var tb = obj.parentElement.parentElement;
	//需要新增行标识：如果当前行为唯一数据行，则需要新增一行，然后再删除此行
	var index = 0;
	for(var i=0;i<tb.rows.length;i++){
		if(tb.rows[i].name != "titlerow" && tb.rows[i].name != "titletr"){
			index ++;
		}
	}
	if(index == 1){
		addGroup(obj, obj.rowIndex);
	}
	var map = {};
	jQuery(tb).find("table[id$='_template']").each(function(index,obj){
		map[obj.id]=obj.outerHTML;
	});
	//要删除行的索引
	var rowIndex = obj.rowIndex;
	//删除行操作
	tb.deleteRow(rowIndex); 
	//删除行操作后行号有可能被打乱，需要重新排列
	shortGroup(tb);
	for ( var prop in map) {
		if (map.hasOwnProperty(prop)) {
				jQuery("#"+prop.replace("_template","")).parent().append(jQuery(map[prop]).clone(true));
		}
	}
//	//行号
//	var rowIndex = obj.rowIndex;
//	tb.deleteRow(rowIndex); 
	
}

/**
 * 向上移动行
 * @param tr 要移动的行对象
 */
function moveUp(tr){
	var tb = tr.parentElement.parentElement;
	var rowIndex = tr.rowIndex;
	if(rowIndex == 0){
		alert("\u9996\u884c\u6570\u636e\u65e0\u6cd5\u5411\u4e0a\u79fb\u52a8\uff01");
		return;
	}
	var upTr = tb.rows[tr.rowIndex - 1];
	if(upTr.name == "titletr" || upTr.name == "titlerow"){
		alert("\u9996\u884c\u6570\u636e\u65e0\u6cd5\u5411\u4e0a\u79fb\u52a8\uff01");
		return;
	}
	var temp = new Array();
	for(var i=0;i<tr.cells.length;i++){
		temp[i] = tr.cells[i].innerHTML;
	}
	for(var i=0;i<tr.cells.length;i++){
		tr.cells[i].innerHTML = upTr.cells[i].innerHTML;
	}
	for(var i=0;i<upTr.cells.length;i++){
		upTr.cells[i].innerHTML = temp[i];
	}
	var display = tb.display;
	if(display == "1"){
		shortRowNum(tb);
	}else{
		shortGroup(tb);
	}
}

/**
 * 向下移动行
 * @param tr 要移动的行对象
 */
function moveDown(tr){
	var tb = tr.parentElement.parentElement;
	var rowIndex = tr.rowIndex;
	if(rowIndex == tb.rows.length - 1){
		alert("\u672b\u884c\u6570\u636e\u65e0\u6cd5\u5411\u4e0b\u79fb\u52a8\uff01");
		return;
	}
	var temp = new Array();
	var upTr = tb.rows[tr.rowIndex + 1];
	for(var i=0;i<tr.cells.length;i++){
		temp[i] = tr.cells[i].innerHTML;
	}
	for(var i=0;i<tr.cells.length;i++){
		tr.cells[i].innerHTML = upTr.cells[i].innerHTML;
	}
	for(var i=0;i<upTr.cells.length;i++){
		upTr.cells[i].innerHTML = temp[i];
	}
	var display = tb.display;
	if(display == "1"){
		shortRowNum(tb);
	}else{
		shortGroup(tb);
	}
}

function getTarget(obj){
	var target = null;
	var targets = obj.parentElement.childNodes;
	if(targets != null){
		for(var i=0;i<targets.length;i++){
			if(targets[i].name=="column_value"){
				target = targets[i];
				break;
			}
		}
	}
	return target;
}
function getShowTarget(obj){
	var target = null;
	var targets = obj.parentElement.childNodes;
	if(targets != null){
		for(var i=0;i<targets.length;i++){
			if(targets[i].name=="show_value"){
				target = targets[i];
				break;
			}
		}
	}
	return target;
}
//取得常规表单多选其他/单选其他的"其他"文本框对象
function getNomalShowTarget(obj){
	var target = null;
	var targets = obj.parentElement.childNodes;
	if(targets != null){
		for(var i=0;i<targets.length;i++){
			if(targets[i].type=="text"){
				target = targets[i];
				break;
			}
		}
	}
	return target;
}

/**
 * 数字校验
 * @returns 非法格式返回false  正确格式返回true
 */
function columnValueNumber(){
	//获取事件对象
	var e = event || window.event;
	//阻止冒泡
	if (window.event) {
		e.cancelBubble = true;
	} else {
		e.stopPropagation();
	} 
	//判断是否按下了shift键，如果是，本次无效
	if(e.shiftKey){
		return false;
	}
	//获取事件源对象
	var target = e.target || window.event.srcElement;
	//无伤害按钮，无视
	if(isFunctionKey(e.keyCode)){
		return true;
	}
	// 对于"-"的处理方式
	else if(e.keyCode == 189 || e.keyCode == 109){
		// 1"-"只能出现在首位
		if(target.value){
			return false;
		}
		// 2非负数出现"-"视为非法格式
		if(target.flag && target.flag == "2"){
			return false;
		}
	}
	//对于 "." 的处理类方式
	else if(e.keyCode == 190 || e.keyCode == 110){
		// 1 不允许出现第二个 "."
		if(target.value && target.value.indexOf(".") >= 0){
			return false;
		}
		// 2 整数不允许出现 "."
		if(target.flag && (target.flag == "1" || target.flag == "2")){
			return false;
		}
	}
	//其他处理规则：数字按格式校验；非数字视为非法字符
	else if(isNumberKeyCode(e.keyCode)){
		//数字的处理规则：如果出现 "."，控制"."后数字位数
		if(target.value && target.value.indexOf(".") >= 0){
			//取得小数位数
			var decimals = target.decimals;
			var str = target.value.substring(target.value.indexOf(".") + 1,target.value.length);
			if(str && str.length >= decimals){
				return false;
			}else{
				return true;
			}
		}
	}else{
		return false;
	}
	return true;
}
function columnValueClean(obj){
	var target = getTarget(obj);
	if(target != null){
		clear(target);
	}
}
function columnValueCheckBox(obj){
	var target = getTarget(obj.parentElement);
	var checkboxvalue = target.value;
	if(target != null){
		if(obj.checked){
			if(checkboxvalue == ""){
				checkboxvalue = obj.value;
			}else{
				checkboxvalue = checkboxvalue+"#"+obj.value;
			}
		}else{
			var str = checkboxvalue.split("#");
			var afterDelValue = "";
			for(var i=0; i<str.length;i++){
				if(str[i] != obj.value){
					if(i == 0){
						afterDelValue = str[i];
					}else{
						afterDelValue += "#"+str[i];
					}
				}
			}
			checkboxvalue = afterDelValue;
		}
	}
	target.value = checkboxvalue;
}
function columnVallueRadio(obj){
	var target = getTarget(obj.parentElement);
	var objs = obj.parentElement.parentElement.childNodes;
	if(objs != null){
		for(var i=0;i<objs.length;i++){
			var imgs = objs[i].childNodes;
			for(var k=0;k<imgs.length;k++){
				if(imgs[k].name == "radioImg"){
					imgs[k].src = "images/rb01.gif";
				}else if(imgs[k].name == "show_value"){
					imgs[k].value = "";
					imgs[k].style.display = "none";
				}
			}
		}
	}
	obj.src = "images/rb02.gif";
	target.value = obj.flag;
}
function columnVallueRadioElse(obj){
	var target = getTarget(obj.parentElement);
	var objs = obj.parentElement.parentElement.childNodes;
	if(objs != null){
		for(var i=0;i<objs.length;i++){
			var imgs = objs[i].childNodes;
			for(var k=0;k<imgs.length;k++){
				if(imgs[k].name == "radioImg"){
					imgs[k].src = "images/rb01.gif";
				}else if(imgs[k].name == "show_value"){
					imgs[k].style.display = "";
				}
			}
		}
	}
	obj.src = "images/rb02.gif";
	target.value = "";
}
function columnVallueRadioElseTest(obj){
	var target = getTarget(obj.parentElement);
	if(obj.value == ""){
		target.value = "";
	}else{
		target.value = "cv_cev_" + obj.value;
	}
}
function columnValueTree(obj,selecedlast){
	var target = getTarget(obj);
	var showTarget = getShowTarget(obj);
	var ccid = obj.ccid;
	var temp = window.showModalDialog("IGSYM1505_TREE.do?ccid=" + ccid.split("_tree_")[0] + "&selecedlast=" + selecedlast,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		target.value = "";
		showTarget.value = "";
	}else if(null!=temp && temp.split("|").length>1){
		var id = temp.split("|")[0];
		var name = temp.split("|")[1];
		var treesyscode;
		
		if(id.split("_").length>1){
			treeccid = id.split("_")[0];
			treecid = id.split("_")[1];
			treesyscode = id.split("_")[2];
		}else{
			treeccid = id.split("_")[0];
			treecid = "";
			treesyscode = "";
		}

		if(treesyscode!=null && name!=null && treesyscode != ''){
			target.value = treesyscode + "_tree_" + name;
			showTarget.value = name;
		}else{
			target.value = '';
			$showTarget.value = '';
		}
		
	}	
	if(target.onchange){
		target.onchange();
	}
}

var setEntityObj = null;
function columnSelectEntity(obj,pidid,syscoding){
	setEntityObj = obj;
	openSubIGCOM0302PARAM('?pidid='+pidid + '&esyscoding=' + syscoding);
}
function delTableColumnEntity(obj,pieid){
	document.getElementById(pieid).style.display = "none";
	obj.style.display = "none";
	var columnvalue = null;
	var columnvalues = obj.parentElement.childNodes;
	if(columnvalues != null){
		for(var k=0;k<columnvalues.length;k++){
			if(columnvalues[k].name == "column_value"){
				columnvalue = columnvalues[k];
			}
		}
	}
	var strs = columnvalue.value.split("_entityValue_");
	if(strs.length == 2){
		columnvalue.value = columnvalue.value + "_entityValue_" + pieid;
	}else{
		var str0 = strs[0];
		var str1 = strs[1];
		var str2 = strs[2];
		var valueStr = "";
		if(str2 == ""){
			valueStr = pieid;
		}else{
			valueStr = str2 + "_sp_" + pieid;
		}
		columnvalue.value = str0 + "_entityValue_" + str1 + "_entityValue_" + valueStr;
	}
}

function delSingleTableColumnEntity(obj,pieid,pidid,syscoding){
	delTableColumnEntity(obj,pieid);
	addSingleTableColumnEntity(obj,pidid,syscoding);
}

function addSingleTableColumnEntity(obj,pidid,syscoding){
	var entityTable = null;
	var entityTables = obj.parentElement.childNodes;
	if(entityTables != null){
		for(var i=0;i<entityTables.length;i++){
			if(entityTables[i].name == "column_entity"){
				entityTable = entityTables[i];
			}
		}
	}
	var tr = entityTable.insertRow();
	tr.id = '0';
	var td = tr.insertCell();
	td.innerHTML = "<input type='text' name='show_value' size='18' readonly='true' /><img src='images/seek.gif' border='0' width='16' height='16' alt='\u67e5\u8be2' onclick=\"columnSelectEntity(this, '" + pidid + "','"+ syscoding +"');\" style='cursor: hand'/>";
}
function addTableColumnEntity(obj,pidid,syscoding){
	var entityTable = null;
	var entityTables = obj.parentElement.childNodes;
	if(entityTables != null){
		for(var i=0;i<entityTables.length;i++){
			if(entityTables[i].name == "column_entity"){
				entityTable = entityTables[i];
			}
		}
	}
	var tr = entityTable.insertRow();
	var cdate = new Date();
	tr.id = cdate.getFullYear() + cdate.getMonth() + cdate.getDate() + cdate.getHours() + cdate.getMinutes() + cdate.getSeconds() + cdate.getMilliseconds();
	var td = tr.insertCell();
	td.innerHTML = "<input type='text' name='show_value' size='18' readonly='true' /><img src='images/seek.gif' border='0' width='16' height='16' alt='\u67e5\u8be2' onclick=\"columnSelectEntity(this, '" + pidid + "','"+ syscoding +"');\" style='cursor: hand'/>";
}

function showOrHiddenCheckBoxElse(obj,index){
	if(obj.checked){
		document.getElementById("pivarcheckboxElseText[" + index + "]").style.display = "";
	}else{
		document.getElementById("pivarcheckboxElseText[" + index + "]").value = "";
		document.getElementById("pivarcheckboxElseText[" + index + "]").style.display = "none";
		var checkBoxValue = document.getElementById("pivarvalue[" + index + "]").value;
		var strs = checkBoxValue.split("#");
		var valueStr = "";
		for(var i=0;i<strs.length;i++){
			if(strs[i].indexOf("_cev_") < 0){
				valueStr += strs[i] + "#";
			}
		}
		document.getElementById("pivarvalue[" + index + "]").value = valueStr.substring(0, valueStr.length - 1);
	}
}
function setCheckBoxElseValue(obj,index){
	var rowValue = document.getElementById("pivarvalue[" + index + "]").value;
	if(rowValue != null){
		var strs = rowValue.split("#");
		var flag = true;
		var valueStr = "";
		if(rowValue){
			for(var i=0;i<strs.length;i++){
				if(strs[i]){
					if(strs[i].indexOf("_cev_") > -1){
						flag = false;
						if(obj.value){
							valueStr += "cv_cev_" + obj.value;
						}
					}else{
						valueStr += strs[i];
					}
					valueStr += "#";
				}
			}
		}
		if(flag){
			if(obj.value){
				document.getElementById("pivarvalue[" + index + "]").value += "#cv_cev_" + obj.value;
			}
		}else{
			document.getElementById("pivarvalue[" + index + "]").value = valueStr.substring(0, valueStr.length - 1);
		}
	}
}

function setTableColumnCheckBoxElseValue(obj){
	var objs = obj.parentElement.childNodes;
	var rowValueObj = null;
	for(var i=0;i<objs.length;i++){
		if(objs[i].name == "column_value"){
			rowValueObj = objs[i];
		}
	}
	if(rowValueObj.value == ""){
		rowValueObj.value = "cv_cev_" + obj.value;
	}else{
		var strs = rowValueObj.value.split("#");
		var flag = true;
		var valueStr = "";
		for(var index=0;index<strs.length;index++){
			if(strs[index].indexOf("_cev_") > -1){
				flag = false;
				valueStr += "cv_cev_" + obj.value;
			}else{
				valueStr += strs[index];
			}
			valueStr += "#";
		}
		if(flag){
			rowValueObj.value += "#cv_cev_" + obj.value;
		}else{
			rowValueObj.value = valueStr.substring(0, valueStr.length - 1);
		}
	}
}

function showOrHiddenTableColumnCheckBoxElse(obj){
	var target = getTarget(obj.parentElement);
	var showTarget = getShowTarget(obj.parentElement);
	if(obj.checked){
		showTarget.style.display = "";
	}else{
		showTarget.value = "";
		showTarget.style.display = "none";
		var checkBoxValue = target.value;
		var strs = checkBoxValue.split("#");
		var valueStr = "";
		for(var i=0;i<strs.length;i++){
			if(strs[i].indexOf("_cev_") < 0){
				valueStr + strs[i] + "#";
			}
		}
		target.value = valueStr.substring(0, valueStr.length - 1);
	}
}
var columnAttNum = 0;
function changeSingleAttachFile(obj){
	if(obj.name == "columnTempAttachFile"){
		obj.name = "attachFileTable[" +  columnAttNum + "]";
		columnAttNum ++;
	}
	var pididobj = null;
	var rownumobj = null;
	var objs = obj.parentElement.parentElement.parentElement.parentElement.parentElement.childNodes;
	for(var i=0;i<objs.length;i++){
		if(objs[i].name == "column_rownumber"){
			rownumobj = objs[i];
		}
		if(objs[i].name == "column_pidid"){
			pididobj = objs[i];
		}
		if(objs[i].name == "column_value"){
			objs[i].value = "N/A";
		}
	}
	if(document.getElementById("addTableColumnFileStr").value == ""){
		document.getElementById("addTableColumnFileStr").value = pididobj.value + "_sp_" + rownumobj.value + "_sp_" + (columnAttNum - 1 );
	}else{
		var sp = document.getElementById("addTableColumnFileStr").value.split("#");
		var str = "";
		for(var k=0;k<sp.length;k++){
			if(sp[k].indexOf(pididobj.value + "_sp_" + rownumobj.value) < 0){
				str += sp[k] + "#";
			}
		}
		document.getElementById("addTableColumnFileStr").value = str + pididobj.value + "_sp_" + rownumobj.value + "_sp_" + (columnAttNum - 1);
	}
	var showfiles = obj.parentElement.childNodes;
	if(showfiles != null && showfiles.length > 0){
		for(var i=0;i<showfiles.length;i++){
			if(showfiles[i].type == "text"){
				showfiles[i].value = obj.value;
			}
		}
	}
}

function delTableColumnFile(obj,attid){
	document.getElementById(attid + "").style.display = "none";
	document.getElementById(attid + "IMG").style.display = "none";
	if(document.getElementById("delTableColumnFileStr").value == ""){
		document.getElementById("delTableColumnFileStr").value = attid + "";
	}else{
		document.getElementById("delTableColumnFileStr").value += "#" + attid;
	}
}
function tableColumnAddAttach(obj){
	var objs = obj.parentElement.childNodes;
	var attTable = null;
	for(var i=0;i<objs.length;i++){
		if(objs[i].name == "column_attach"){
			attTable = objs[i];
		}
	}
	var td = attTable.insertRow().insertCell();
	var width = obj.parentElement.offsetWidth;
	if(width > 400){
		width == 300;
	}else{
		width = width - 100;
	}
	td.innerHTML = "<img src='images/attachment.gif' /><input type='text' readonly='true' name='show_value' class='tableColumnFile' style='width:" + width + "px;' /><input type='file' onchange=\"changeTableColumnFileValue(this);\" name='attachFileTable[" + columnAttNum + "]' style='width:" + width + "px;' class='ehdel_upload'/><img src='images/file_del.png' style='cursor: hand;' onclick='delTableColumnFileInput(this);' alt='\u5220\u9664'/>";
	columnAttNum ++;
}

function changeTableColumnFileValue(obj){
	var target = getTarget(obj.parentElement.parentElement.parentElement.parentElement);
	if(target.value == ""){
		target.value = "N/A";
	}
}

function delTableColumnFileInput(obj){
	var rowIndex = obj.parentElement.parentElement.rowIndex;
	var tb = obj.parentElement.parentElement.parentElement.parentElement;
	tb.deleteRow(rowIndex);
	if(tb.rows.length < 1){
		var target = getTarget(tb);
		if(target.value == "N/A"){
			target.value = "";
		}
	}
	return tb;
}
function delSingleTableColumnFile(obj,attid){
	delTableColumnFile(obj,attid);
	var objs = obj.parentElement.childNodes;
	var attTable = null;
	for(var i=0;i<objs.length;i++){
		if(objs[i].name == "column_attach"){
			attTable = objs[i];
		}
	}
	var td = attTable.insertRow().insertCell();
	var width = td.parentElement.parentElement.parentElement.parentElement.offsetWidth;
	if(width > 400){
		width = 300;
	}else{
		width = width - 100;
	}
	td.innerHTML = "<img src='images/attachment.gif' /><input type='text' readonly='true' name='show_value' class='tableColumnFile' style='width:" + width + "px;' /><input type='file' onchange=\"changeSingleAttachFile(this);\" name='attachFileTable[" + columnAttNum + "]' style='width:" + width + "px;' class='ehdel_upload'/><img src='images/file_del.png' style='cursor: hand;' alt='\u6e05\u7a7a' onclick='delSingleTableColumnFileInput(this);'/>";
	columnAttNum ++;
}
function delSingleTableColumnFileInput(obj){
	var tb = delTableColumnFileInput(obj);
	var td = tb.insertRow().insertCell();
	var width = td.parentElement.parentElement.parentElement.parentElement.offsetWidth;
	if(width > 400){
		width = 300;
	}else{	
		width = width - 100;
	}
	td.innerHTML = "<img src='images/attachment.gif' /><input type='text' readonly='true' name='show_value' class='tableColumnFile' style='width:" + width + "px;' /><input type='file' onchange=\"changeSingleAttachFile(this);\" name='attachFileTable[" + columnAttNum + "]' style='width:" + width + "px;' class='ehdel_upload'/><img src='images/file_del.png' style='cursor: hand;' alt='\u6e05\u7a7a' onclick='delSingleTableColumnFileInput(this);' />";
	columnAttNum ++;
}

function getTableColumnEditDivValue(obj){
	getTarget(obj).value = obj.innerHTML;
}
function automaticAddTable(pidlabel,index){
	var imgObj = document.getElementsByName(pidlabel)[index];
	imgObj.click();
}
//文本域高度自适应方法
function textAreaSelfadaption(){
	var textareaObjs = document.getElementsByTagName("div");
	if(textareaObjs != null && textareaObjs.length > 0){
		for(var i=0;i<textareaObjs.length;i++){
			if("textarea_show_value" == textareaObjs[i].name){
				textareaObjs[i].style.height = textareaObjs[i].parentElement.offsetHeight + "px";
			}
		}
	}
}
function columnSelectProcess(obj){
	processObj = obj.parentElement.childNodes[0];
	openSubWindow('/IGSVC0107_Disp.do', '_blank','1000','600');
}
function addTableProcessForm(obj){
	var objs = obj.parentElement.childNodes;
	var tb = null;
	for(var i=0;i<objs.length;i++){
		if(objs[i].name && objs[i].name == "table_column_process"){
			tb = objs[i];
			break;
		}
	}
	var tr = tb.insertRow();
	var cdate = new Date();
	tr.id = "" + cdate.getFullYear() + cdate.getMonth() + cdate.getDate() + cdate.getHours() + cdate.getMinutes() + cdate.getSeconds() + cdate.getMilliseconds();
	var td = tr.insertCell();
	td.style.border="none";
	td.innerHTML = '<input type="text" size="32" name="column_show" /><img src="images/seek.gif" alt="\u67e5\u8be2" onclick="columnSelectProcess(this);" style="cursor: hand;" />&nbsp;&nbsp;<img src="images/delate.gif" alt="\u5220\u9664" onclick="deleteProcess(this,\'table\');" style="cursor: hand;" />';
}
function deleteTableProcessValue(obj,piprrid){
	var rvalue =  getTarget(obj.parentElement.parentElement.parentElement.parentElement).value;
	var str1 = "";
	var str2 = "",str3 = "";
	var infos = rvalue.split("_processValue_");
	if(infos != null && infos.length > 0){
		str1 = infos[0];
		if(infos.length > 1){
			str2 = infos[1];
		}
		if(infos.length > 2){
			str3 = infos[2];
		}
	}
	if(str3 == ""){
		str3 = piprrid + "";
	}else{
		str3 += "#" + piprrid;
	}
	getTarget(obj.parentElement.parentElement.parentElement.parentElement).value = str1 + "_processValue_" + str2 + "_processValue_" + str3;
	var tr = obj.parentElement.parentElement;
	tr.parentElement.deleteRow(tr.rowIndex);
}
function deleteSingleTableProcessValue(obj,piprrid){
	var objs = obj.parentElement.parentElement.parentElement.parentElement.parentElement.childNodes;
	var tb = null;
	for(var i=0;i<objs.length;i++){
		if(objs[i].name && objs[i].name == "table_column_process"){
			tb = objs[i];
			break;
		}
	}
	var tr = tb.insertRow();
	var cdate = new Date();
	tr.id = "" + cdate.getFullYear() + cdate.getMonth() + cdate.getDate() + cdate.getHours() + cdate.getMinutes() + cdate.getSeconds() + cdate.getMilliseconds();
	var td = tr.insertCell();
	td.style.border="none";
	td.innerHTML = '<input type="text" size="32" name="column_show" /><img src="images/seek.gif" alt="\u67e5\u8be2" onclick="columnSelectProcess(this);" style="cursor: hand;" />';
	deleteTableProcessValue(obj, piprrid);
}
