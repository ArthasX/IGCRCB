/*
 * 报表：T-B-9 网络安全管理情况表_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_item_RName = "总行网络安全域划分#内容#名称";
var label_item8 = "总行网络安全域划分#内容#用途";
var label_item9 = "总行网络安全域划分#内容#可访问哪些网络安全域";
var label_item10 = "总行网络安全域划分#内容#可被哪些网络安全域访问";
var label_item12 = "总行网络安全域划分#内容#隔离措施";
var label_item13 = "总行网络安全域划分#内容#远程接入";
var label_M_item14 = "总行网络安全域划分#内容#备注";

var label_item22 = "网络边界控制#表3#内容";
var label_item25 = "网络边界控制#表4#内容";

var label_item_RName2 = "生产网设备可用性#序号";
var label_item30 = "生产网设备可用性#表1#设备冗余情况";
var label_item31 = "生产网设备可用性#表1#内存峰值（%）";
var label_item32 = "生产网设备可用性#表1#CPU峰值（%）";
var label_M_item33= "生产网设备可用性#表1#备注";

var label_item_RName3 = "生产网线路可用性#表1#生产中心（或中心机房）名称";
var label_item46_GTZero = "生产网线路可用性#表1#表21#线路数(条）";
var label_item47_GTZero = "生产网线路可用性#表1#表21#不同运营商数（家）";
var label_item48 = "生产网线路可用性#表1#表21#主线路带宽（M）";
var label_item49 = "生产网线路可用性#表1#表21#主线路带宽使用率峰值(%)";
var label_M_item50 = "生产网线路可用性#表1#表21#备注";

var label_item_RName4 = "生产网线路可用性#表2#序号名称";
var label_item46_GTZero_2 = "生产网线路可用性#表2#线路数(条）";
var label_item47_GTZero_2 = "生产网线路可用性#表2#不同运营商数（家）";
var label_item48_2 = "生产网线路可用性#表2#主线路带宽（M）";
var label_item49_2 = "生产网线路可用性#表2#主线路带宽使用率峰值(%)";
var label_M_item50_2 = "生产网线路可用性#表2#备注";

var label_item68 = "生产网隔离#内容";

var label_YN73 = "网络带宽管理#内容#保障";
var label_YN73_01 = "网络带宽管理#内容#带宽保障的优先次序";

var label_YN86 = "核心网络设备管理#表4#内容#1";
var label_YN86_01 = "核心网络设备管理#表4#内容#审查周期";
var label_YN86_02 = "核心网络设备管理#表4#内容#保存时长";

var label_item1001_GTZero = "网络安全管理措施#表2#内容";

var label_YN88 = "内部网访问互联网#表1#是否允许从内部办公网访问互联网";
var label_YN88_01 = "内部网访问互联网#表1#审批部门：";
var label_YN91 = "内部网访问互联网#表1#监测与控制技术：";
var label_YN91_01 = "内部网访问互联网#表1#说明：";
/*
* 功能：初始化页面设置表单联动
* 配置：年报审批
*/
function initSet(){
	var obj = 0;
	setYN73_01Disable(obj);
	setYN86Disable(obj);
	setItem22Disable(obj);
	setItem25Disable(obj);
	setItem68(obj);
}
/*
 *功能：根据单选按钮修改表单是否可读写
 *配置：网络带宽管理#内容#保障
 */
function setYN73_01Disable(obj) {
	var obj_YN73 = getTableFormObjs(label_YN73)[0];
	var obj_YN73_01 = getTableFormObjs(label_YN73_01)[0];
	if (obj_YN73.value.trim() == "无") {
		// 只读
		obj_YN73_01.readOnly = "readonly";
		// 清空
		obj_YN73_01.value = "";

	} else if (obj_YN73.value.trim() == "有") {
		// 还原
		obj_YN73_01.readOnly = "";
	}
}

/*
 *功能：根据复选按钮“不保存”修改表单是否可读写
 *配置：核心网络设备管理#表4#内容#1
 */
function setYN86Disable(obj) {
	var obj_YN86 =getTableFormObjs(label_YN86)[0];
	var objs = getTableFormCheckBox(label_YN86,obj_YN86.rownumber);
	var obj_YN86_01 = getTableFormObjs(label_YN86_01)[0];
	var obj_YN86_02 = getTableFormObjs(label_YN86_02)[0];
	for(var i = 0; i < objs.length; i++){
		if (objs[i].value.trim() == "不保存" && objs[i].checked == true) {
			// 只读
			disableTableCheckBox1(objs,true,"不保存",false);
			obj_YN86_01.onclick = "";
			obj_YN86_02.onclick = "";
			// 清空
			obj_YN86_01.value = "";
			obj_YN86_02.value = "";
			obj_YN86.value = "不保存";
			break;
		} else if(objs[i].value == "不保存" && objs[i].checked == false){
			// 还原
			disableTableCheckBox1(objs,false,"不保存",false);
			obj_YN86_01.onclick = click_columnValueNumber;
			obj_YN86_02.onclick = click_columnValueNumber;
			break;
		}
	}
}

/*
 *功能：根据复选按钮“无网上银行边界”修改表单其他复选框是否可选
 *配置：网络边界控制#表3#内容
 */
function setItem22Disable(obj) {
	var obj_item22 = getTableFormObjs(label_item22)[0];
	var objs = getTableFormCheckBox(label_item22,obj_item22.rownumber);
	for(var i = 0; i < objs.length; i++){
		if (objs[i].value.trim() == "无网上银行边界" && objs[i].checked == true) {
			// 只读
			disableTableCheckBox1(objs,true,"无网上银行边界",true);
			obj_item22.value = "无网上银行边界";
			break;
		} else if(objs[i].value == "无网上银行边界" && objs[i].checked == false){
			// 还原
			disableTableCheckBox1(objs,false,"无网上银行边界",true);
			break;
		}
	}
}

/*
 *功能：根据复选按钮“无网上银行边界”修改表单其他复选框是否可选
 *配置：网络边界控制#表4#内容
 */
function setItem25Disable(obj) {
	var obj_item25 = getTableFormObjs(label_item25)[0];
	var objs = getTableFormCheckBox(label_item25,obj_item25.rownumber);
	for(var i = 0; i < objs.length; i++){
		if (objs[i].value.trim() == "无互联网边界" && objs[i].checked == true) {
			// 只读
			disableTableCheckBox1(objs,true,"无互联网边界",true);
			obj_item25.value = "无互联网边界";
			break;
		} else if(objs[i].value == "无互联网边界" && objs[i].checked == false){
			// 还原
			disableTableCheckBox1(objs,false,"无互联网边界",true);
			break;
		}
	}
}

/*
 *功能：恢复数字键盘输入
 */
var click_columnValueNumber = function() {
	columnValueNumber(this);
};

/*
* 功能：当选择 不保存 时其他多选项不可选
* 参数：objs 为所有复选框对象集合
* 	  flag 为设置不可选标识，true时除str复选框别的不可选，false反之
* 	  str  可选值（其他选项不可选）
* 	  qita 为是否有“其他”选项的文本框
*/	  
function disableTableCheckBox1(objs,flag,str,qita){
	if(objs != null && objs.length > 0){
		for(var i=0;i<objs.length;i++){
			if(flag && objs[i].value != str){
				objs[i].disabled = flag;
				objs[i].checked = false;
				if(qita){
					//清空“其他”并设置为只读
					var showvalue = getShowTarget(objs[i].parentElement);
					showvalue.value = "";
					showvalue.style.display="none";
				}
			}else if(!flag && objs[i].value != str ){
				objs[i].disabled = flag;
//				objs[i].checked = false;
			}
		}
	}
}

/*
 *功能：生产网隔离 的与其他网物理隔离与与其他网逻辑隔离 的多选项互斥
 *配置：生产网隔离 #内容
 */
function setItem68(obj) {
	var obj_item68 = getTableFormObjs(label_item68);
	var obj_item68checkbox = getTableFormCheckBox(label_item68,obj_item68[0].rownumber);
	var obj_item71checkbox = getTableFormCheckBox(label_item68,obj_item68[1].rownumber);
	for(var i = 0; i < obj_item68checkbox.length-1; i++ ){
		if(obj_item68checkbox[i].checked == true){
			obj_item71checkbox[i].checked = false;
			obj_item71checkbox[i].disabled = true;
		}else if(obj_item71checkbox[i].checked == true){
			obj_item68checkbox[i].checked = false;
			obj_item68checkbox[i].disabled = true;
		}else{
			obj_item71checkbox[i].disabled = false;
			obj_item68checkbox[i].disabled = false;
		}
	}
}


/*
* 功能：点击提交时进行的表单验证
* 配置：填报状态的“提交”按钮
*/
function checkData() {
	
	//清空错误表单的背景色
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.color="";
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];
	
	var objs = getTableFormObjs(label_item_RName);
	for ( var i = 0; i < objs.length; i++) {
		// 过滤模版
		if ((objs[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
			checkTableItemNull(objs[i]);
	}
	var objs2 = getTableFormObjs(label_item_RName2);
	for ( var i = 0; i < objs2.length; i++) {
		// 过滤模版
		if ((objs2[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
			checkTableItemNull2(objs2[i]);
	}
	var objs3 = getTableFormObjs(label_item_RName3);
	for ( var i = 0; i < objs3.length; i++) {
		// 过滤模版
		if ((objs3[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
			checkTableItemNull3(objs3[i]);
	}
	var objs4 = getTableFormObjs(label_item_RName4);
	for ( var i = 0; i < objs4.length; i++) {
		// 过滤模版
		if ((objs4[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
			checkTableItemNull4(objs4[i]);
	}
	var obj_item1001_GTZero = getTableFormObjs(label_item1001_GTZero);
	checkNumFloat(obj_item1001_GTZero[0],2);
	checkNumFloat(obj_item1001_GTZero[1],2);
	if(parseInt(obj_item1001_GTZero[0].value) > 100){
		errorObjs.push(obj_item1001_GTZero[0]);
		a += "防毒软件安装覆盖率<100出错！\n";
	  	isValid=false;
	}
	if(parseInt(obj_item1001_GTZero[1].value) > 100){
		errorObjs.push(obj_item1001_GTZero[1]);
		a += "病毒特征码更新率<100出错！\n";
	  	isValid=false;
	}
	var obj_YN73 = getTableFormObjs(label_YN73)[0];
	var obj_YN73_01 = getTableFormObjs(label_YN73_01)[0];
	if(obj_YN73.value == "有" && obj_YN73_01.value.trim() == ""){
		errorObjs.push(obj_YN73_01);
		a += "网络带宽管理：带宽保障的优先次序不能为空!\n";
		isValid=false;
	}
	var obj_YN86 = getTableFormObjs(label_YN86)[0];
	var obj_YN86_01 = getTableFormObjs(label_YN86_01)[0];
	var obj_YN86_02 = getTableFormObjs(label_YN86_02)[0];
	if(obj_YN86.value != "不保存" && obj_YN86_01.value.trim() == ""){
		errorObjs.push(obj_YN86_01);
		a += "日志管理 审查周期不能为空!\n";
		isValid=false;
	}
	if(obj_YN86.value != "不保存" && obj_YN86_02.value.trim() == ""){
		errorObjs.push(obj_YN86_02);
		a += "日志管理 保存时长不能为空!\n";
		isValid=false;
	}
	
	var obj_YN88 = getTableFormObjs(label_YN88)[0];
	var obj_YN88_01 = getTableFormObjs(label_YN88_01)[0];
	if(obj_YN88.value == "是" && obj_YN88_01.value.trim() == ""){
		errorObjs.push(obj_YN88_01);
		a += "内部网访问互联网：审批部门不能为空!\n";
		isValid=false;
	}
	
	var obj_YN91 = getTableFormObjs(label_YN91)[0];
	var obj_YN91_01 = getTableFormObjs(label_YN91_01)[0];
	if(obj_YN91.value == "有" && obj_YN91_01.value.trim() == ""){
		errorObjs.push(obj_YN91_01);
		a += "内部网访问互联网：监测与控制技术说明不能为空!\n";
		isValid=false;
	}
	
	if (!isValid && a > "") {
		for(var i=0 ;i<errorObjs.length;i++) {
			if (errorObjs[i].outerHTML.indexOf("TD") > -1) {
				errorObjs[i].style.color="red";
			} else {
				errorObjs[i].style.backgroundColor="red";
			}
		}
		alert(a);
		a = "";
		isValid = true;
		return false;
	}
	return isValid;
}

/*
 * 功能：根据项目名称判断该行是否全输入了值
 */
function checkTableItemNull(obj) {
	var obj_item8 = getTableFormObj(label_item8,obj.rownumber);
	var obj_item9 = getTableFormObj(label_item9,obj.rownumber);
	var obj_item10 = getTableFormObj(label_item10,obj.rownumber);
	var obj_item12 = getTableFormObj(label_item12, obj.rownumber);
	var obj_item13 = getTableFormObj(label_item13, obj.rownumber);
	var obj_M_item14 = getTableFormObj(label_M_item14, obj.rownumber);
	if (obj.value.trim() !="" && obj.value.trim() != "无"){
	
		if (replaceAll(obj_item8.value.trim()) == ""  ) {
			errorObjs.push(getEditDiv(obj_item8));
			a += "总行网络安全域划分"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，用途不能为空！\n";
			isValid = false;
		}
		if (replaceAll(obj_item9.value.trim()) == "" ) {
			errorObjs.push(getEditDiv(obj_item9));
			a += "总行网络安全域划分"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，可访问哪些网络安全域不能为空！\n";
			isValid = false;
		}
		if (replaceAll(obj_item10.value.trim()) == "" ) {
			errorObjs.push(getEditDiv(obj_item10));
			a += "总行网络安全域划分"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，可被哪些网络安全域访问不能为空！\n";
			isValid = false;
		}
		if (obj_item12.value == "" ) {
			errorObjs.push(obj_item12.parentElement);
			a += "总行网络安全域划分"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，隔离措施不能为空！\n";
			isValid = false;
		}
		if (obj_item13.value.trim() == "") {
			errorObjs.push(obj_item13.parentElement);
			a += "总行网络安全域划分"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，远程接入不能为空！\n";
			isValid = false;
		}
	}else{
		if(replaceAll(obj_item8.value.trim()) != "" || replaceAll(obj_item9.value.trim()) != "" || 
				replaceAll(obj_item10.value.trim()) != "" || obj_item12.value != "" || 
					obj_item13.value.trim() != "" || obj_M_item14.value != ""){
			errorObjs.push(getEditDiv(obj));
			a += "总行网络安全域划分"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不能为“无”或空！\n";
			isValid = false;
		}
	}
}

/*
 * 功能：根据项目名称判断该行是否全输入了值
 */
function checkTableItemNull2(obj) {
	var obj_item30s = getTableFormObjs(label_item30);
	var obj_item30 = new Array();
	for(var i = 0; i < obj_item30s.length; i++){
		if(obj_item30s[i].rownumber == obj.rownumber + "_1" || 
				obj_item30s[i].rownumber == obj.rownumber + "_2" || 
					obj_item30s[i].rownumber == obj.rownumber + "_3"){
			obj_item30[obj_item30.length] = obj_item30s[i];
		}
	}
	var obj_item31s = getTableFormObjs(label_item31);
	var obj_item31 = new Array();
	for(var i = 0; i < obj_item31s.length; i++){
		if(obj_item31s[i].rownumber == obj.rownumber+ "_1" || 
				obj_item31s[i].rownumber == obj.rownumber+ "_2" || 
					obj_item31s[i].rownumber == obj.rownumber+ "_3"){
			obj_item31[obj_item31.length] = obj_item31s[i];
		}
	}
	var obj_item32s = getTableFormObjs(label_item32);
	var obj_item32 = new Array();
	for(var i = 0; i < obj_item32s.length; i++){
		if(obj_item32s[i].rownumber == obj.rownumber+ "_1" || 
				obj_item32s[i].rownumber == obj.rownumber+ "_2" || 
					obj_item32s[i].rownumber == obj.rownumber+ "_3"){
			obj_item32[obj_item32.length] = obj_item32s[i];
		}
	}
	var obj_M_item33s = getTableFormObjs(label_M_item33);
	var obj_M_item33 = new Array();
	for(var i = 0; i < obj_M_item33s.length; i++){
		if(obj_M_item33s[i].rownumber == obj.rownumber+ "_1" || 
				obj_M_item33s[i].rownumber == obj.rownumber+ "_2" || 
					obj_M_item33s[i].rownumber == obj.rownumber+ "_3"){
			obj_M_item33[obj_M_item33.length] = obj_M_item33s[i];
		}
	}
	
	if (obj.value.trim() !="" && obj.value.trim() != "无"){
	
		if (replaceAll(obj_item30[0].value.trim()) == "" ) {
			errorObjs.push(obj_item30[0].parentElement);
			a += "生产网设备可用性：序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"，数据中心（或中心机房）名称不为“无”或空，核心路由器 设备冗余情况不能为空！\n";
			isValid = false;
		}
		if (obj_item31[0].value == "") {
			errorObjs.push(obj_item31[0]);
			a += "生产网设备可用性：序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"，数据中心（或中心机房）名称不为“无”或空，核心路由器 内存峰值（%）不能为空！\n";
			isValid = false;
		}else{
			checkNumFloat(obj_item31[0],2);
		}
		if (obj_item32[0].value == "") {
			errorObjs.push(obj_item32[0]);
			a += "生产网设备可用性：序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"，数据中心（或中心机房）名称不为“无”或空，核心路由器 CPU峰值（%）不能为空！\n";
			isValid = false;
		}else{
			checkNumFloat(obj_item32[0],2);
		}
		if (replaceAll(obj_item30[1].value.trim()) == "") {
			errorObjs.push(obj_item30[1].parentElement);
			a += "生产网设备可用性：序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"，数据中心（或中心机房）名称不为“无”或空，核心交换机 设备冗余情况不能为空！\n";
			isValid = false;
		}
		if (obj_item31[1].value == "" ) {
			errorObjs.push(obj_item31[1]);
			a += "生产网设备可用性：序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"，数据中心（或中心机房）名称不为“无”或空，核心交换机 内存峰值（%）不能为空！ \n";
			isValid = false;
			
		}else{
			checkNumFloat(obj_item31[1],2);
		}
		if (obj_item32[1].value == "") {
			errorObjs.push(obj_item32[1]);
			a += "生产网设备可用性：序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"，数据中心（或中心机房）名称不为“无”或空，核心交换机 CPU峰值（%）不能为空！ \n";
			isValid = false;
		}else{
			checkNumFloat(obj_item32[1],2);
		}
		if (replaceAll(obj_item30[2].value.trim()) == "" ) {
			errorObjs.push(obj_item30[2].parentElement);
			a += "生产网设备可用性：序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"，数据中心（或中心机房）名称不为“无”或空，核心网络安全设备 设备冗余情况不能为空！ \n";
			isValid = false;
		}
		if (obj_item31[2].value == "" ) {
			errorObjs.push(obj_item31[2]);
			a += "生产网设备可用性：序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"，数据中心（或中心机房）名称不为“无”或空，核心网络安全设备 内存峰值（%）不能为空！ \n";
			isValid = false;
		}else{
			checkNumFloat(obj_item31[2],2);
		}
		if (obj_item32[2].value == "") {
			errorObjs.push(obj_item32[2]);
			a += "生产网设备可用性：序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"，数据中心（或中心机房）名称不为“无”或空，核心网络安全设备 CPU峰值（%）不能为空！ \n";
			isValid = false;
		}else{
			checkNumFloat(obj_item32[2],2);
		}
	}else{
		if(replaceAll(obj_item30[0].value.trim()) != "" && replaceAll(obj_item30[1].value.trim()) != "" && replaceAll(obj_item30[2].value.trim()) != "" && 
				obj_item31[0].value != "" && obj_item31[1].value != "" && obj_item31[2].value != "" && 
					obj_item32[0].value != "" && obj_item32[1].value != "" && obj_item32[2].value !="" && 
						obj_M_item33[0].value != "" && obj_M_item33[1].value != "" && obj_M_item33[2].value != ""){
			errorObjs.push(getEditDiv(obj));
			a += "生产网设备可用性：序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"，名称不能为“无”或空！\n";
			isValid = false;
		}
	}
}

/*
 * 功能：根据项目名称判断该行是否全输入了值
 */
function checkTableItemNull3(obj) {
	var obj_item46_GTZeros = getTableFormObjs(label_item46_GTZero);
	var obj_item46_GTZero = new Array();
	for(var i = 0; i < obj_item46_GTZeros.length; i++){
		if(obj_item46_GTZeros[i].rownumber == obj.rownumber + "_1" || 
				obj_item46_GTZeros[i].rownumber == obj.rownumber + "_2" || 
					obj_item46_GTZeros[i].rownumber == obj.rownumber + "_3"){
			obj_item46_GTZero[obj_item46_GTZero.length] = obj_item46_GTZeros[i];
		}
	}
	var obj_item47_GTZeros = getTableFormObjs(label_item47_GTZero);
	var obj_item47_GTZero = new Array();
	for(var i = 0; i < obj_item47_GTZeros.length; i++){
		if(obj_item47_GTZeros[i].rownumber == obj.rownumber+ "_1" || 
				obj_item47_GTZeros[i].rownumber == obj.rownumber+ "_2" || 
					obj_item47_GTZeros[i].rownumber == obj.rownumber+ "_3"){
			obj_item47_GTZero[obj_item47_GTZero.length] = obj_item47_GTZeros[i];
		}
	}
	var obj_item48s = getTableFormObjs(label_item48);
	var obj_item48 = new Array();
	for(var i = 0; i < obj_item48s.length; i++){
		if(obj_item48s[i].rownumber == obj.rownumber+ "_1" || 
				obj_item48s[i].rownumber == obj.rownumber+ "_2" || 
					obj_item48s[i].rownumber == obj.rownumber+ "_3"){
			obj_item48[obj_item48.length] = obj_item48s[i];
		}
	}
	var obj_item49s = getTableFormObjs(label_item49);
	var obj_item49 = new Array();
	for(var i = 0; i < obj_item49s.length; i++){
		if(obj_item49s[i].rownumber == obj.rownumber+ "_1" || 
				obj_item49s[i].rownumber == obj.rownumber+ "_2" || 
					obj_item49s[i].rownumber == obj.rownumber+ "_3"){
			obj_item49[obj_item49.length] = obj_item49s[i];
		}
	}
	var obj_M_item50s = getTableFormObjs(label_M_item50);
	var obj_M_item50 = new Array();
	for(var i = 0; i < obj_M_item50s.length; i++){
		if(obj_M_item50s[i].rownumber == obj.rownumber+ "_1" || 
				obj_M_item50s[i].rownumber == obj.rownumber+ "_2" || 
				obj_M_item50s[i].rownumber == obj.rownumber+ "_3"){
			obj_M_item50[obj_M_item50.length] = obj_M_item50s[i];
		}
	}
	if (obj.value.trim() !="" && obj.value.trim() != "无"){
	
		if (obj_item46_GTZero[0].value== "" ) {
			errorObjs.push(obj_item46_GTZero[0]);
			a += "生产网线路可用性：序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"，生产中心（或中心机房）名称不为“无”或空，至一级分支机构 线路数(条）不能为空！ \n";
			isValid = false;
		}
		if (obj_item47_GTZero[0].value == "") {
			errorObjs.push(obj_item47_GTZero[0]);
			a += "生产网线路可用性：序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"，生产中心（或中心机房）名称不为“无”或空，至一级分支机构 不同运营商数（家）不能为空！ \n";
			isValid = false;
		}
		if (obj_item48[0].value == "") {
			errorObjs.push(obj_item48[0]);
			a += "生产网线路可用性：序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"，生产中心（或中心机房）名称不为“无”或空，至一级分支机构 主线路带宽（M)不能为空！ \n";
			isValid = false;
		}
		if (obj_item49[0].value == "") {
			errorObjs.push(obj_item49[0]);
			a += "生产网线路可用性：序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"，生产中心（或中心机房）名称不为“无”或空，至一级分支机构 主线路带宽使用率峰值(%)不能为空！ \n";
			isValid = false;
		}else{
			checkNumFloat(obj_item49[0],2);
		}
		if (obj_item46_GTZero[1].value == "") {
			errorObjs.push(obj_item46_GTZero[1]);
			a += "生产网线路可用性：序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"，生产中心（或中心机房）名称不为“无”或空，至同城灾备中心 线路数(条）不能为空！ \n";
			isValid = false;
		}
		if (obj_item47_GTZero[1].value == "" ) {
			errorObjs.push(obj_item47_GTZero[1]);
			a += "生产网线路可用性：序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"，生产中心（或中心机房）名称不为“无”或空，至同城灾备中心 不同运营商数（家）不能为空！ \n";
			isValid = false;
		}
		if (obj_item48[1].value == "" ) {
			errorObjs.push(obj_item48[1]);
			a += "生产网线路可用性：序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"，生产中心（或中心机房）名称不为“无”或空，至同城灾备中心 主线路带宽（M)不能为空！ \n";
			isValid = false;
		}
		if (obj_item49[1].value == "") {
			errorObjs.push(obj_item49[1]);
			a += "生产网线路可用性：序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"，生产中心（或中心机房）名称不为“无”或空，至同城灾备中心 主线路带宽使用率峰值(%)不能为空！ \n";
			isValid = false;
		}else{
			checkNumFloat(obj_item49[1],2);
		}
		if (obj_item46_GTZero[2].value == "") {
			errorObjs.push(obj_item46_GTZero[2]);
			a += "生产网线路可用性：序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"，生产中心（或中心机房）名称不为“无”或空，至异地灾备中心 线路数(条）不能为空！ \n";
			isValid = false;
		}
		if (obj_item47_GTZero[2].value == "") {
			errorObjs.push(obj_item47_GTZero[2]);
			a += "生产网线路可用性：序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"，生产中心（或中心机房）名称不为“无”或空，至异地灾备中心 不同运营商数（家）不能为空！ \n";
			isValid = false;
		}
		if (obj_item48[2].value == "") {
			errorObjs.push(obj_item48[2]);
			a += "生产网线路可用性：序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"，生产中心（或中心机房）名称不为“无”或空，至异地灾备中心 主线路带宽（M)不能为空！ \n";
			isValid = false;
		}
		if (obj_item49[2].value == "" ) {
			errorObjs.push(obj_item49[2]);
			a += "生产网线路可用性：序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"，生产中心（或中心机房）名称不为“无”或空，至异地灾备中心 主线路带宽使用率峰值(%)不能为空！ \n";
			isValid = false;
		}else{
			checkNumFloat(obj_item49[2],2);
		}
	}else{
		if(obj_item46_GTZero[0].value != "" || obj_item46_GTZero[1].value != "" || obj_item46_GTZero[2].value != "" || 
			obj_item47_GTZero[0].value != "" || obj_item47_GTZero[1].value != "" || obj_item47_GTZero[2].value != "" || 
			obj_item48[0].value != "" || obj_item48[1].value != "" || obj_item48[2].value !="" ||
			obj_item49[0].value != "" || obj_item49[1].value != "" || obj_item49[2].value != "" || 
			obj_M_item50[0].value != "" || obj_M_item50[1].value != "" || obj_M_item50[2].value != "" ){
			errorObjs.push(getEditDiv(obj));
			a += "生产网线路可用性：序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"名称不能为“无”或空！ \n";
			isValid = false;
		}
	}
}

/*
 * 功能：根据项目名称判断该行是否全输入了值
 */
function checkTableItemNull4(obj) {
	var obj_item46_GTZero_2 = getTableFormObj(label_item46_GTZero_2 , obj.rownumber);
	var obj_item47_GTZero_2 = getTableFormObj(label_item47_GTZero_2 , obj.rownumber);
	var obj_item48_2 = getTableFormObj(label_item48_2 , obj.rownumber);
	var obj_item49_2 = getTableFormObj(label_item49_2 , obj.rownumber);
	var obj_M_item50_2 = getTableFormObj(label_M_item50_2 , obj.rownumber);
	
	if (obj.value.trim() !="" && obj.value.trim() != "无"){

		if (obj_item46_GTZero_2.value== "" ) {
			errorObjs.push(obj_item46_GTZero_2);
			a += "生产网线路可用性：序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"，灾备中心（或灾备机房 ）名称不为“无”或空，线路数(条）不能为空！ \n";
			isValid = false;
		}
		if (obj_item47_GTZero_2.value == "" ) {
			errorObjs.push(obj_item47_GTZero_2);
			a += "生产网线路可用性：序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"，灾备中心（或灾备机房 ）名称不为“无”或空，不同运营商数（家）不能为空！ \n";
			isValid = false;
		}
		if (obj_item48_2.value == "" ) {
			errorObjs.push(obj_item48_2);
			a += "生产网线路可用性：序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"，灾备中心（或灾备机房 ）名称不为“无”或空，主线路带宽（M)不能为空！ \n";
			isValid = false;
		}
		if (obj_item49_2.value == "") {
			errorObjs.push(obj_item49_2);
			a += "生产网线路可用性：序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"，灾备中心（或灾备机房 ）名称不为“无”或空，主线路带宽使用率峰值(%)不能为空！ \n";
			isValid = false;
		}else{
			checkNumFloat(obj_item49_2,2);
		}
	}else{
		if( obj_item46_GTZero_2.value != "" ||
				obj_item47_GTZero_2.value != "" && obj_item48_2.value != "" || 
					obj_item49_2.value != "" || obj_M_item50_2.value != "" ){
			errorObjs.push(getEditDiv(obj));
			a += "生产网线路可用性：序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"名称不为“无”或空！ \n";
			isValid = false;
		}
	}
}

/*
 *功能：回车行替换
 */
function replaceAll(value) {
	if (value == null)
		return value;
	while (value.indexOf("\r") > -1) {
		value = value.replace("\r", "");
	}
	return value;
}

/*
* 功能：名称为空时， 其后面的不允许输入
* 配置：总行网络安全域划分#内容#名称
*/
/*function checkitem_RName(obj){
	var target = getTarget(obj);
	var obj_item8 = getTableFormObj(label_item8,target.rownumber);
	var obj_item8_area = getEditDiv(obj_item8);
	var obj_item9 = getTableFormObj(label_item9,target.rownumber);
	var obj_item9_area = getEditDiv(obj_item9);
	var obj_item10 = getTableFormObj(label_item10,target.rownumber);
	var obj_item10_area = getEditDiv(obj_item10);
	var obj_item12 = getTableFormCheckBox(label_item12, target.rownumber);
	var obj_item13 = getTableFormCheckBox(label_item13, target.rownumber);
	var obj_M_item14 = getTableFormObj(label_M_item14,target.rownumber);
	var obj_M_item14_area = getEditDiv(obj_M_item14);
//	alert(obj_item8_area.value);
	if(target.value == ""){
		//只读
		obj_item8_area.contentEditable  = false;
		obj_item9_area.contentEditable  = false;
		obj_item10_area.contentEditable  = false;
		disableTableCheckBox(obj_item12,true);
		disableTableCheckBox(obj_item13,true);
		obj_M_item14_area.contentEditable = false;
		//清空
		obj_item8_area.innerHTML = "";
		obj_item8.value = "";
		obj_item9_area.innerHTML = "";
		obj_item9.value = "";
		obj_item10_area.innerHTML = "";
		obj_item10.value = "";
		obj_item12.value = "";
		obj_item13.value = "";
		obj_M_item14_area.innerHTML = "";
		obj_M_item14.value = "";
	}else{
		//可写
		obj_item8_area.contentEditable  = true;
		obj_item9_area.contentEditable  = true;
		obj_item10_area.contentEditable  = true;
		disableTableCheckBox(obj_item12,false);
		disableTableCheckBox(obj_item13,false);
		obj_M_item14_area.contentEditable = true;
	}
}*/