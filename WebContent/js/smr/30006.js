/*
 * 报表：T-A-7 信息科技相关案件报告表_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_zuoanshijian_item8 = "作案时间#作案时间#开始时间";
var label_zuoanshijian_item9 = "作案时间#作案时间#结束时间";
var label_faxianshijian_item10 = "作案时间#发现时间";
var label_qudaoguanli="涉案信息系统类别#类别明细#渠道管理类别#渠道管理";
var label_item8="涉案信息系统类别#类别明细#渠道管理类别#渠道子分类";
var label_kehuguanli="涉案信息系统类别#类别明细#客户管理类别#客户管理";
var label_item10="涉案信息系统类别#类别明细#客户管理类别#客户管理子分类";
var label_chanpinguanli="涉案信息系统类别#类别明细#产品管理类别#产品管理";
var label_item12="涉案信息系统类别#类别明细#产品管理类别#产品管理子类别";
var label_caiwuguanli="涉案信息系统类别#类别明细#财务管理类别#财务管理";
var label_item14="涉案信息系统类别#类别明细#财务管理类别#财务管理子类别";
var label_juecezhichi="涉案信息系统类别#类别明细#决策支持类别#决策支持";
var label_item16="涉案信息系统类别#类别明细#决策支持类别#决策支持子类别";
var label_qita="涉案信息系统类别#类别明细#其他类别#其他";
var label_item19="涉案信息系统类别#类别明细#其他类别#其他内容";
var label_item13 = "涉案人#姓名";
var label_item15 = "涉案人#年龄";
var label_sheanjine= "涉案金额（万元）#涉案金额（万元）";
var label_fengxianjine="涉案金额（万元）#风险金额（万元）";

/*
* 功能：二级审批状态初始化时设置表单权限
* 配置：二级审批状态初始化js
*/
function initSet(){
	var obj_qudaoguanli = getTableFormObj(label_qudaoguanli, "1_1_1");
	var obj_item8 = getTableFormCheckBox(label_item8,"1_1_1");
	var obj_kehuguanli = getTableFormObj(label_kehuguanli, "1_1_1");
	var obj_item10 = getTableFormCheckBox(label_item10,"1_1_1");
	var obj_chanpinguanli = getTableFormObj(label_chanpinguanli, "1_1_1");
	var obj_item12 = getTableFormCheckBox(label_item12,"1_1_1" );
	var obj_caiwuguanli = getTableFormObj(label_caiwuguanli, "1_1_1");
	var obj_item14 = getTableFormCheckBox(label_item14,"1_1_1" );
	var obj_juecezhichi = getTableFormObj(label_juecezhichi, "1_1_1");
	var obj_item16 = getTableFormCheckBox(label_item16,"1_1_1" );
	var obj_qita = getTableFormObj(label_qita,"1_1_1" );
	var obj_item19 = getTableFormObj(label_item19,"1_1_1" );
	
	if (obj_qudaoguanli.value=="渠道管理") {
		disableTableCheckBox(obj_item10,true);
		disableTableCheckBox(obj_item12,true);
		disableTableCheckBox(obj_item14,true);
		disableTableCheckBox(obj_item16,true);
		getEditDiv(obj_item19).contentEditable=false;
	} else if (obj_kehuguanli.value=="客户管理") {
		disableTableCheckBox(obj_item8,true);
		disableTableCheckBox(obj_item12,true);
		disableTableCheckBox(obj_item14,true);
		disableTableCheckBox(obj_item16,true);
		getEditDiv(obj_item19).contentEditable=false;
	} else if (obj_chanpinguanli.value=="产品管理") {
		disableTableCheckBox(obj_item8,true);
		disableTableCheckBox(obj_item10,true);
		disableTableCheckBox(obj_item14,true);
		disableTableCheckBox(obj_item16,true);
		getEditDiv(obj_item19).contentEditable=false;
	} else if (obj_caiwuguanli.value=="财务管理") {
		disableTableCheckBox(obj_item8,true);
		disableTableCheckBox(obj_item10,true);
		disableTableCheckBox(obj_item12,true);
		disableTableCheckBox(obj_item16,true);
		getEditDiv(obj_item19).contentEditable=false;
	} else if (obj_juecezhichi.value=="决策支持") {
		disableTableCheckBox(obj_item8,true);
		disableTableCheckBox(obj_item10,true);
		disableTableCheckBox(obj_item12,true);
		disableTableCheckBox(obj_item14,true);
		getEditDiv(obj_item19).contentEditable=false;
	} else if (obj_qita.value=="其他") {
		disableTableCheckBox(obj_item8,true);
		disableTableCheckBox(obj_item10,true);
		disableTableCheckBox(obj_item12,true);
		disableTableCheckBox(obj_item14,true);
		disableTableCheckBox(obj_item16,true);
	}
}

/*
* 功能：开始和结束时间前后校验
* 配置：作案时间#作案时间#开始时间
*/
function checkStartTime(obj){
	var obj_endtime=getTableFormObj(label_zuoanshijian_item9,"1_1");
	if(obj_endtime.value!="" && obj.value > obj_endtime.value) {
		alert("开始时间应在结束时间之前，请重新输入！");
		obj.value="";
		obj.focus();
	}
}

/*
* 功能：开始和结束时间前后校验
* 配置：作案时间#作案时间#结束时间
*/
function checkEndTime(obj){
	var obj_starttime=getTableFormObj(label_zuoanshijian_item8,"1_1");
	if(obj_starttime.value!="" && obj.value < obj_starttime.value) {
		alert("结束时间应在起始时间之后，请重新输入！");
		obj.value="";
		obj.focus();
	}
}
/*
* 功能：发现时间和作案开始时间的前后校验
* 配置：作案时间#发现时间
*/
function checkDiscoveryTime(obj) {
	var obj_starttime=getTableFormObj(label_zuoanshijian_item8,"1_1");
	if(obj_starttime.value!="" && obj.value < obj_starttime.value) {
		alert("发现时间不能早于作案时间，请重新输入！");
		obj.value="";
		obj.focus();
	}
}

/*
* 功能：各涉案信息系统类别相互制域处理
* 配置：涉案信息系统类别#类别明细#渠道管理类别#渠道管理
* 涉案信息系统类别#类别明细#客户管理类别#客户管理
* 涉案信息系统类别#类别明细#产品管理类别#产品管理
* 涉案信息系统类别#类别明细#财务管理类别#财务管理
* 涉案信息系统类别#类别明细#决策支持类别#决策支持
* 涉案信息系统类别#类别明细#其他类别#其他
*/
function sheanxitongleibie_click(obj) {
	var target = getTarget(obj.parentElement);
	var obj_qudaoguanli = getTableFormObj(label_qudaoguanli, target.rownumber);
	var obj_item8 = getTableFormCheckBox(label_item8,target.rownumber);
	var obj_kehuguanli = getTableFormObj(label_kehuguanli, target.rownumber);
	var obj_item10 = getTableFormCheckBox(label_item10,target.rownumber);
	var obj_chanpinguanli = getTableFormObj(label_chanpinguanli, target.rownumber);
	var obj_item12 = getTableFormCheckBox(label_item12,target.rownumber );
	var obj_caiwuguanli = getTableFormObj(label_caiwuguanli, target.rownumber);
	var obj_item14 = getTableFormCheckBox(label_item14,target.rownumber );
	var obj_juecezhichi = getTableFormObj(label_juecezhichi, target.rownumber);
	var obj_item16 = getTableFormCheckBox(label_item16,target.rownumber );
	var obj_qita = getTableFormObj(label_qita,target.rownumber);
	var obj_item19 = getTableFormObj(label_item19,target.rownumber);

	//设置系统类别的全部多选框为只读并清空值
	disableTableCheckBox(obj_item8,true);
	disableTableCheckBox(obj_item10,true);
	disableTableCheckBox(obj_item12,true);
	disableTableCheckBox(obj_item14,true);
	disableTableCheckBox(obj_item16,true);
	getEditDiv(obj_item19).innerHTML = "";
	obj_item19.value="";
	getEditDiv(obj_item19).contentEditable=false;

	if (target.value=="渠道管理"){
		//指定复选框对象还原状态
		disableTableCheckBox(obj_item8,false);
		//设置其他无关单选框状态为非选中
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="客户管理"){
		disableTableCheckBox(obj_item10,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="产品管理") {
		disableTableCheckBox(obj_item12,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_qita);
	} else if(target.value=="财务管理") {
		disableTableCheckBox(obj_item14,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="决策支持") {
		disableTableCheckBox(obj_item16,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="其他") {
		getEditDiv(obj_item19).contentEditable=true;
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
	}
}

/*
*功能：点击提交时进行的表单验证
*配置：填报状态的“提交”按钮
*/
function checkData() {
	var obj_starttime=getTableFormObj(label_zuoanshijian_item8,"1_1");
	var obj_endtime=getTableFormObj(label_zuoanshijian_item9,"1_1");
	var obj_discoverytime=getTableFormObj(label_faxianshijian_item10,"1");
	var obj_qudaoguanli = getTableFormObj(label_qudaoguanli, "1_1_1");
	var obj_item8 = getTableFormCheckBox(label_item8,"1_1_1");
	var obj_kehuguanli = getTableFormObj(label_kehuguanli, "1_1_1");
	var obj_item10 = getTableFormCheckBox(label_item10,"1_1_1");
	var obj_chanpinguanli = getTableFormObj(label_chanpinguanli, "1_1_1");
	var obj_item12 = getTableFormCheckBox(label_item12,"1_1_1" );
	var obj_caiwuguanli = getTableFormObj(label_caiwuguanli, "1_1_1");
	var obj_item14 = getTableFormCheckBox(label_item14,"1_1_1" );
	var obj_juecezhichi = getTableFormObj(label_juecezhichi, "1_1_1");
	var obj_item16 = getTableFormCheckBox(label_item16,"1_1_1" );
	var obj_qita = getTableFormObj(label_qita,"1_1_1" );
	var obj_item19 = getTableFormObj(label_item19,"1_1_1" );
	var obj_sheanjine = getTableFormObj(label_sheanjine,"1" );
	var obj_fengxianjine = getTableFormObj(label_fengxianjine,"1" );
	
	// 小数位补零处理
	checkNumFloat(obj_sheanjine,2);
	checkNumFloat(obj_fengxianjine,2);
	
	//清空错误表单的背景色
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.color="";
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];
	
	if(obj_starttime.value > obj_endtime.value) {
		errorObjs.push(obj_starttime);
		errorObjs.push(obj_endtime);
		a += "发现时间不能早于作案时间，请重新输入！\n";
		isValid = false;
	}

	if(obj_starttime.value > obj_discoverytime.value) {
		errorObjs.push(obj_discoverytime);
		a += "开始时间应在变更时间之前，请重新输入！\n";
		isValid = false;
	}
	if (obj_qudaoguanli.value=="" && obj_kehuguanli.value=="" && obj_chanpinguanli.value=="" &&
			obj_caiwuguanli.value=="" && obj_juecezhichi.value=="" && obj_qita.value=="") {
		errorObjs.push(obj_qudaoguanli.parentElement);
		errorObjs.push(obj_kehuguanli.parentElement);
		errorObjs.push(obj_chanpinguanli.parentElement);
		errorObjs.push(obj_caiwuguanli.parentElement);
		errorObjs.push(obj_juecezhichi.parentElement);
		errorObjs.push(obj_qita.parentElement);
		a += "涉案信息系统类别不能为空！\n";
		isValid = false;
	}
	if (obj_qudaoguanli.value != "" && getTarget(getTableFormObj(label_item8, "1_1_1")).value=="") {
		errorObjs.push(obj_qudaoguanli.parentElement);
		a += "涉案信息系统类别选择“渠道管理”时，其对应的子类型不能为空！\n";
		isValid = false;
	}
	if (obj_kehuguanli.value != "" && getTarget(getTableFormObj(label_item10, "1_1_1")).value=="") {
		errorObjs.push(obj_kehuguanli.parentElement);
		a += "涉案信息系统类别选择“客户管理”时，其对应的子类型不能为空！\n";
		isValid = false;
	}
	if (obj_chanpinguanli.value != "" && getTarget(getTableFormObj(label_item12, "1_1_1")).value=="") {
		errorObjs.push(obj_chanpinguanli.parentElement);
		a += "涉案信息系统类别选择“产品管理”时，其对应的子类型不能为空！\n";
		isValid = false;
	}
	if (obj_caiwuguanli.value != "" && getTarget(getTableFormObj(label_item14, "1_1_1")).value=="") {
		errorObjs.push(obj_caiwuguanli.parentElement);
		a += "涉案信息系统类别选择“财务管理”时，其对应的子类型不能为空！\n";
		isValid = false;
	}
	if (obj_juecezhichi.value != "" && getTarget(getTableFormObj(label_item16, "1_1_1")).value=="") {
		errorObjs.push(obj_juecezhichi.parentElement);
		a += "涉案信息系统类别选择“决策支持”时，其对应的子类型不能为空！\n";
		isValid = false;
	}
	
	// 年龄大于100时自动设置为100
	if (isValid) {
		var objs = getTableFormObjs(label_item13);
		for ( var i = 0; i < objs.length; i++) {
			// 过滤模版
			if ((objs[i].rownumber + "").indexOf("#") > -1) {
				continue;
			}
			var obj_item15 = getTableFormObj(label_item15,objs[i].rownumber);
			if (obj_item15.value>"100"){
				obj_item15.value="100";
			}
		}
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