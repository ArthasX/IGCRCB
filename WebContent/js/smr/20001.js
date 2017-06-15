/*
 * 报表：T-Q-2 信息科技项目情况表_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_item5_1="1 本季度新增的重大项目#项目名称";
var label_item24_GTZero_1="1 本季度新增的重大项目#本季度新增的重大项目#项目投入";
var label_item25_1="1 本季度新增的重大项目#本季度新增的重大项目#项目日期#计划上线日期#计划上线日期";
var label_item26_1="1 本季度新增的重大项目#本季度新增的重大项目#项目日期#项目开始日期#项目开始日期";
var label_item48_1="1 本季度新增的重大项目#本季度新增的重大项目#实施模式";
var label_item26_desc_1="1 本季度新增的重大项目#本季度新增的重大项目#系统功能描述";
var label_qudaoguanli_1="1 本季度新增的重大项目#本季度新增的重大项目#渠道管理#渠道管理#系统类别";
var label_qudaoguanliItems_1="1 本季度新增的重大项目#本季度新增的重大项目#渠道管理#渠道管理#子类别";
var label_kehuguanli_1="1 本季度新增的重大项目#本季度新增的重大项目#渠道管理#客户管理#系统类别";
var label_kehuguanliItems_1="1 本季度新增的重大项目#本季度新增的重大项目#渠道管理#客户管理#子类别";
var label_chanpinguanli_1="1 本季度新增的重大项目#本季度新增的重大项目#渠道管理#产品管理#系统类别";
var label_chanpinguanliItems_1="1 本季度新增的重大项目#本季度新增的重大项目#渠道管理#产品管理#子类别";
var label_caiwuguanli_1="1 本季度新增的重大项目#本季度新增的重大项目#渠道管理#财务管理#系统类别";
var label_caiwuguanliItems_1="1 本季度新增的重大项目#本季度新增的重大项目#渠道管理#财务管理#子类别";
var label_juecezhichi_1="1 本季度新增的重大项目#本季度新增的重大项目#渠道管理#决策支持#系统类别";
var label_juecezhichiItems_1="1 本季度新增的重大项目#本季度新增的重大项目#渠道管理#决策支持#子类别";
var label_gongxiangzhichi_1="1 本季度新增的重大项目#本季度新增的重大项目#渠道管理#共享支持#系统类别";
var label_gongxiangzhichiItems_1="1 本季度新增的重大项目#本季度新增的重大项目#渠道管理#共享支持#子类别";
var label_jichusheshi_1="1 本季度新增的重大项目#本季度新增的重大项目#渠道管理#基础设施#系统类别";
var label_jichusheshiItems_1="1 本季度新增的重大项目#本季度新增的重大项目#渠道管理#基础设施#子类别";
var label_qita_1="1 本季度新增的重大项目#本季度新增的重大项目#渠道管理#其他#系统类别";
var label_qitaItems_1="1 本季度新增的重大项目#本季度新增的重大项目#渠道管理#其他#子类别";
var label_item5_2="2 本季度完成的重大项目#项目名称";
var label_item24_GTZero_2="2 本季度完成的重大项目#本季度完成的重大项目#项目投入";
var label_item25_2="2 本季度完成的重大项目#本季度完成的重大项目#项目日期#上线日期#上线日期";
var label_item26_2="2 本季度完成的重大项目#本季度完成的重大项目#项目日期#项目开始日期#项目开始日期";
var label_item48_2="2 本季度完成的重大项目#本季度完成的重大项目#实施模式";
var label_item26_desc_2="2 本季度完成的重大项目#本季度完成的重大项目#系统功能描述";
var label_item27_2="2 本季度完成的重大项目#本季度完成的重大项目#延期#延期";
var label_O_item27_2="2 本季度完成的重大项目#本季度完成的重大项目#延期#延期原因";
var label_qudaoguanli_2="2 本季度完成的重大项目#本季度完成的重大项目#渠道管理#渠道管理#系统类别";
var label_qudaoguanliItems_2="2 本季度完成的重大项目#本季度完成的重大项目#渠道管理#渠道管理#子类别";
var label_kehuguanli_2="2 本季度完成的重大项目#本季度完成的重大项目#渠道管理#客户管理#系统类别";
var label_kehuguanliItems_2="2 本季度完成的重大项目#本季度完成的重大项目#渠道管理#客户管理#子类别";
var label_chanpinguanli_2="2 本季度完成的重大项目#本季度完成的重大项目#渠道管理#产品管理#系统类别";
var label_chanpinguanliItems_2="2 本季度完成的重大项目#本季度完成的重大项目#渠道管理#产品管理#子类别";
var label_caiwuguanli_2="2 本季度完成的重大项目#本季度完成的重大项目#渠道管理#财务管理#系统类别";
var label_caiwuguanliItems_2="2 本季度完成的重大项目#本季度完成的重大项目#渠道管理#财务管理#子类别";
var label_juecezhichi_2="2 本季度完成的重大项目#本季度完成的重大项目#渠道管理#决策支持#系统类别";
var label_juecezhichiItems_2="2 本季度完成的重大项目#本季度完成的重大项目#渠道管理#决策支持#子类别";
var label_gongxiangzhichi_2="2 本季度完成的重大项目#本季度完成的重大项目#渠道管理#共享支持#系统类别";
var label_gongxiangzhichiItems_2="2 本季度完成的重大项目#本季度完成的重大项目#渠道管理#共享支持#子类别";
var label_jichusheshi_2="2 本季度完成的重大项目#本季度完成的重大项目#渠道管理#基础设施#系统类别";
var label_jichusheshiItems_2="2 本季度完成的重大项目#本季度完成的重大项目#渠道管理#基础设施#子类别";
var label_qita_2="2 本季度完成的重大项目#本季度完成的重大项目#渠道管理#其他#系统类别";
var label_qitaItems_2="2 本季度完成的重大项目#本季度完成的重大项目#渠道管理#其他#子类别";
var label_item5_3="3 本季度正在实施的重大项目#项目名称";
var label_item24_GTZero_3="3 本季度正在实施的重大项目#本季度正在实施的重大项目#项目投入";
var label_item25_3="3 本季度正在实施的重大项目#本季度正在实施的重大项目#项目日期#计划上线日期#计划上线日期";
var label_item26_3="3 本季度正在实施的重大项目#本季度正在实施的重大项目#项目日期#项目开始日期#项目开始日期";
var label_item48_3="3 本季度正在实施的重大项目#本季度正在实施的重大项目#实施模式";
var label_item26_desc_3="3 本季度正在实施的重大项目#本季度正在实施的重大项目#系统功能描述";
var label_item27_3="3 本季度正在实施的重大项目#本季度正在实施的重大项目#延期#延期";
var label_O_item27_3="3 本季度正在实施的重大项目#本季度正在实施的重大项目#延期#延期原因";
var label_qudaoguanli_3="3 本季度正在实施的重大项目#本季度正在实施的重大项目#渠道管理#渠道管理#系统类别";
var label_qudaoguanliItems_3="3 本季度正在实施的重大项目#本季度正在实施的重大项目#渠道管理#渠道管理#子类别";
var label_kehuguanli_3="3 本季度正在实施的重大项目#本季度正在实施的重大项目#渠道管理#客户管理#系统类别";
var label_kehuguanliItems_3="3 本季度正在实施的重大项目#本季度正在实施的重大项目#渠道管理#客户管理#子类别";
var label_chanpinguanli_3="3 本季度正在实施的重大项目#本季度正在实施的重大项目#渠道管理#产品管理#系统类别";
var label_chanpinguanliItems_3="3 本季度正在实施的重大项目#本季度正在实施的重大项目#渠道管理#产品管理#子类别";
var label_caiwuguanli_3="3 本季度正在实施的重大项目#本季度正在实施的重大项目#渠道管理#财务管理#系统类别";
var label_caiwuguanliItems_3="3 本季度正在实施的重大项目#本季度正在实施的重大项目#渠道管理#财务管理#子类别";
var label_juecezhichi_3="3 本季度正在实施的重大项目#本季度正在实施的重大项目#渠道管理#决策支持#系统类别";
var label_juecezhichiItems_3="3 本季度正在实施的重大项目#本季度正在实施的重大项目#渠道管理#决策支持#子类别";
var label_gongxiangzhichi_3="3 本季度正在实施的重大项目#本季度正在实施的重大项目#渠道管理#共享支持#系统类别";
var label_gongxiangzhichiItems_3="3 本季度正在实施的重大项目#本季度正在实施的重大项目#渠道管理#共享支持#子类别";
var label_jichusheshi_3="3 本季度正在实施的重大项目#本季度正在实施的重大项目#渠道管理#基础设施#系统类别";
var label_jichusheshiItems_3="3 本季度正在实施的重大项目#本季度正在实施的重大项目#渠道管理#基础设施#子类别";
var label_qita_3="3 本季度正在实施的重大项目#本季度正在实施的重大项目#渠道管理#其他#系统类别";
var label_qitaItems_3="3 本季度正在实施的重大项目#本季度正在实施的重大项目#渠道管理#其他#子类别";


/*
* 功能：二级审批状态初始化时设置表单权限
* 配置：二级审批状态初始化js
*/
function initSet(){
	var objs_1 = getTableFormObjs(label_item5_1);
	var objs_2 = getTableFormObjs(label_item5_2);
	var objs_3 = getTableFormObjs(label_item5_3);
	initSet_1(objs_1);
	initSet_2(objs_2);
	initSet_3(objs_3);
	var cc = 0;
	set_O_item27_2(cc);
	set_O_item27_3(cc);
}

/*
* 功能：2.本季度完成的重大项目 延期原因设置
* 配置：2 本季度完成的重大项目#本季度完成的重大项目#延期#延期
*/
function set_O_item27_2(obj){
	var obj_item27_2s = getTableFormObjs(label_item27_2);
	for(var i = 0; i< obj_item27_2s.length; i++){
		var obj_O_item27_2 = getTableFormObj(label_O_item27_2,obj_item27_2s[i].rownumber );
		var obj_O_item27_2_area = getEditDiv(obj_O_item27_2);
		if(obj_item27_2s[i].value == "否"){
			obj_O_item27_2_area.contentEditable = false;
			obj_O_item27_2_area.innerHTML = "";
			obj_O_item27_2.value = "";
		}else{
			obj_O_item27_2_area.contentEditable = true;
		}
	}
}

/*
* 功能：3 本季度正在实施的重大项目 延期原因设置
* 配置：3 本季度正在实施的重大项目#本季度正在实施的重大项目#延期#延期
*/
function set_O_item27_3(obj){
	var obj_item27_3s = getTableFormObjs(label_item27_3);
	for(var i = 0; i< obj_item27_3s.length; i++){
		var obj_O_item27_3 = getTableFormObj(label_O_item27_3,obj_item27_3s[i].rownumber );
		var obj_O_item27_3_area = getEditDiv(obj_O_item27_3);
		if(obj_item27_3s[i].value == "否"){
			obj_O_item27_3_area.contentEditable = false;
			obj_O_item27_3_area.innerHTML = "";
			obj_O_item27_3.value = "";
		}else{
			obj_O_item27_3_area.contentEditable = true;
		}
	}
}

/*
* 功能：1 本季度新增的重大项目各系统类别相互制域处理
* 配置：1 本季度新增的重大项目#本季度新增的重大项目#渠道管理#渠道管理#系统类别
* 1 本季度新增的重大项目#本季度新增的重大项目#渠道管理#客户管理#系统类别
* 1 本季度新增的重大项目#本季度新增的重大项目#渠道管理#产品管理#系统类别
* 1 本季度新增的重大项目#本季度新增的重大项目#渠道管理#财务管理#系统类别
* 1 本季度新增的重大项目#本季度新增的重大项目#渠道管理#决策支持#系统类别
* 1 本季度新增的重大项目#本季度新增的重大项目#渠道管理#共享支持#系统类别
* 1 本季度新增的重大项目#本季度新增的重大项目#渠道管理#基础设施#系统类别
* 1 本季度新增的重大项目#本季度新增的重大项目#渠道管理#其他#系统类别
*/
function xitongleibie_click_1(obj) {
	var target = getTarget(obj.parentElement);
	var obj_qudaoguanli = getTableFormObj(label_qudaoguanli_1, target.rownumber);
	var obj_item8 = getTableFormCheckBox(label_qudaoguanliItems_1,target.rownumber);
	var obj_kehuguanli = getTableFormObj(label_kehuguanli_1, target.rownumber);
	var obj_item10 = getTableFormCheckBox(label_kehuguanliItems_1,target.rownumber);
	var obj_chanpinguanli = getTableFormObj(label_chanpinguanli_1, target.rownumber);
	var obj_item12 = getTableFormCheckBox(label_chanpinguanliItems_1,target.rownumber );
	var obj_caiwuguanli = getTableFormObj(label_caiwuguanli_1, target.rownumber);
	var obj_item14 = getTableFormCheckBox(label_caiwuguanliItems_1,target.rownumber );
	var obj_juecezhichi = getTableFormObj(label_juecezhichi_1, target.rownumber);
	var obj_item16 = getTableFormCheckBox(label_juecezhichiItems_1,target.rownumber );
	var obj_gongxiangzhichi = getTableFormObj(label_gongxiangzhichi_1, target.rownumber);
	var obj_item18 = getTableFormCheckBox(label_gongxiangzhichiItems_1,target.rownumber );
	var obj_jichusheshi = getTableFormObj(label_jichusheshi_1, target.rownumber);
	var obj_item89 = getTableFormCheckBox(label_jichusheshiItems_1,target.rownumber );
	var obj_qita = getTableFormObj(label_qita_1,target.rownumber );
	var obj_item87 = getTableFormObj(label_qitaItems_1,target.rownumber );
	
	//设置系统类别的全部多选框为只读并清空值
	disableTableCheckBox(obj_item8,true);
	disableTableCheckBox(obj_item10,true);
	disableTableCheckBox(obj_item12,true);
	disableTableCheckBox(obj_item14,true);
	disableTableCheckBox(obj_item16,true);
	disableTableCheckBox(obj_item18,true);
	disableTableCheckBox(obj_item89,true);
	obj_item87.value= "";
	obj_item87.readOnly="readonly";

	if (target.value=="渠道管理"){
		//指定复选框对象还原状态
		disableTableCheckBox(obj_item8,false);
		//设置其他无关单选框状态为非选中
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_gongxiangzhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="客户管理"){
		disableTableCheckBox(obj_item10,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_gongxiangzhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="产品管理") {
		disableTableCheckBox(obj_item12,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_gongxiangzhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_qita);
	} else if(target.value=="财务管理") {
		disableTableCheckBox(obj_item14,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_gongxiangzhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="决策支持") {
		disableTableCheckBox(obj_item16,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_gongxiangzhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="共享支持") {
		disableTableCheckBox(obj_item18,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="基础设施") {
		disableTableCheckBox(obj_item89,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_gongxiangzhichi);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="其他") {
		obj_item87.readOnly="";
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_gongxiangzhichi);
	}
}


/*
* 功能：2 本季度完成的重大项目各系统类别相互制域处理
* 配置：2 本季度完成的重大项目#本季度新增的重大项目#渠道管理#渠道管理#系统类别
* 2 本季度完成的重大项目#本季度新增的重大项目#渠道管理#客户管理#系统类别
* 2 本季度完成的重大项目#本季度新增的重大项目#渠道管理#产品管理#系统类别
* 2 本季度完成的重大项目#本季度新增的重大项目#渠道管理#财务管理#系统类别
* 2 本季度完成的重大项目#本季度新增的重大项目#渠道管理#决策支持#系统类别
* 2 本季度完成的重大项目#本季度新增的重大项目#渠道管理#共享支持#系统类别
* 2 本季度完成的重大项目#本季度新增的重大项目#渠道管理#基础设施#系统类别
* 2 本季度完成的重大项目#本季度新增的重大项目#渠道管理#其他#系统类别
*/
function xitongleibie_click_2(obj) {
	var target = getTarget(obj.parentElement);
	var obj_qudaoguanli = getTableFormObj(label_qudaoguanli_2, target.rownumber);
	var obj_item8 = getTableFormCheckBox(label_qudaoguanliItems_2,target.rownumber);
	var obj_kehuguanli = getTableFormObj(label_kehuguanli_2, target.rownumber);
	var obj_item10 = getTableFormCheckBox(label_kehuguanliItems_2,target.rownumber);
	var obj_chanpinguanli = getTableFormObj(label_chanpinguanli_2, target.rownumber);
	var obj_item12 = getTableFormCheckBox(label_chanpinguanliItems_2,target.rownumber );
	var obj_caiwuguanli = getTableFormObj(label_caiwuguanli_2, target.rownumber);
	var obj_item14 = getTableFormCheckBox(label_caiwuguanliItems_2,target.rownumber );
	var obj_juecezhichi = getTableFormObj(label_juecezhichi_2, target.rownumber);
	var obj_item16 = getTableFormCheckBox(label_juecezhichiItems_2,target.rownumber );
	var obj_gongxiangzhichi = getTableFormObj(label_gongxiangzhichi_2, target.rownumber);
	var obj_item18 = getTableFormCheckBox(label_gongxiangzhichiItems_2,target.rownumber );
	var obj_jichusheshi = getTableFormObj(label_jichusheshi_2, target.rownumber);
	var obj_item89 = getTableFormCheckBox(label_jichusheshiItems_2,target.rownumber );
	var obj_qita = getTableFormObj(label_qita_2,target.rownumber );
	var obj_item87 = getTableFormObj(label_qitaItems_2,target.rownumber );
	
	//设置系统类别的全部多选框为只读并清空值
	disableTableCheckBox(obj_item8,true);
	disableTableCheckBox(obj_item10,true);
	disableTableCheckBox(obj_item12,true);
	disableTableCheckBox(obj_item14,true);
	disableTableCheckBox(obj_item16,true);
	disableTableCheckBox(obj_item18,true);
	disableTableCheckBox(obj_item89,true);
	obj_item87.value= "";
	obj_item87.readOnly="readonly";

	if (target.value=="渠道管理"){
		//指定复选框对象还原状态
		disableTableCheckBox(obj_item8,false);
		//设置其他无关单选框状态为非选中
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_gongxiangzhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="客户管理"){
		disableTableCheckBox(obj_item10,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_gongxiangzhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="产品管理") {
		disableTableCheckBox(obj_item12,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_gongxiangzhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_qita);
	} else if(target.value=="财务管理") {
		disableTableCheckBox(obj_item14,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_gongxiangzhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="决策支持") {
		disableTableCheckBox(obj_item16,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_gongxiangzhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="共享支持") {
		disableTableCheckBox(obj_item18,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="基础设施") {
		disableTableCheckBox(obj_item89,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_gongxiangzhichi);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="其他") {
		obj_item87.readOnly="";
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_gongxiangzhichi);
	}
}

/*
* 功能：3 本季度正在实施的重大项目各系统类别相互制域处理
* 配置：3 本季度正在实施的重大项目#本季度新增的重大项目#渠道管理#渠道管理#系统类别
* 3 本季度正在实施的重大项目#本季度新增的重大项目#渠道管理#客户管理#系统类别
* 3 本季度正在实施的重大项目#本季度新增的重大项目#渠道管理#产品管理#系统类别
* 3 本季度正在实施的重大项目#本季度新增的重大项目#渠道管理#财务管理#系统类别
* 3 本季度正在实施的重大项目#本季度新增的重大项目#渠道管理#决策支持#系统类别
* 3 本季度正在实施的重大项目#本季度新增的重大项目#渠道管理#共享支持#系统类别
* 3 本季度正在实施的重大项目#本季度新增的重大项目#渠道管理#基础设施#系统类别
* 3 本季度正在实施的重大项目#本季度新增的重大项目#渠道管理#其他#系统类别
*/
function xitongleibie_click_3(obj) {
	var target = getTarget(obj.parentElement);
	var obj_qudaoguanli = getTableFormObj(label_qudaoguanli_3, target.rownumber);
	var obj_item8 = getTableFormCheckBox(label_qudaoguanliItems_3,target.rownumber);
	var obj_kehuguanli = getTableFormObj(label_kehuguanli_3, target.rownumber);
	var obj_item10 = getTableFormCheckBox(label_kehuguanliItems_3,target.rownumber);
	var obj_chanpinguanli = getTableFormObj(label_chanpinguanli_3, target.rownumber);
	var obj_item12 = getTableFormCheckBox(label_chanpinguanliItems_3,target.rownumber );
	var obj_caiwuguanli = getTableFormObj(label_caiwuguanli_3, target.rownumber);
	var obj_item14 = getTableFormCheckBox(label_caiwuguanliItems_3,target.rownumber );
	var obj_juecezhichi = getTableFormObj(label_juecezhichi_3, target.rownumber);
	var obj_item16 = getTableFormCheckBox(label_juecezhichiItems_3,target.rownumber );
	var obj_gongxiangzhichi = getTableFormObj(label_gongxiangzhichi_3, target.rownumber);
	var obj_item18 = getTableFormCheckBox(label_gongxiangzhichiItems_3,target.rownumber );
	var obj_jichusheshi = getTableFormObj(label_jichusheshi_3, target.rownumber);
	var obj_item89 = getTableFormCheckBox(label_jichusheshiItems_3,target.rownumber );
	var obj_qita = getTableFormObj(label_qita_3,target.rownumber );
	var obj_item87 = getTableFormObj(label_qitaItems_3,target.rownumber );
	
	//设置系统类别的全部多选框为只读并清空值
	disableTableCheckBox(obj_item8,true);
	disableTableCheckBox(obj_item10,true);
	disableTableCheckBox(obj_item12,true);
	disableTableCheckBox(obj_item14,true);
	disableTableCheckBox(obj_item16,true);
	disableTableCheckBox(obj_item18,true);
	disableTableCheckBox(obj_item89,true);
	obj_item87.value = "";
	obj_item87.readOnly="readonly";

	if (target.value=="渠道管理"){
		//指定复选框对象还原状态
		disableTableCheckBox(obj_item8,false);
		//设置其他无关单选框状态为非选中
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_gongxiangzhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="客户管理"){
		disableTableCheckBox(obj_item10,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_gongxiangzhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="产品管理") {
		disableTableCheckBox(obj_item12,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_gongxiangzhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_qita);
	} else if(target.value=="财务管理") {
		disableTableCheckBox(obj_item14,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_gongxiangzhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="决策支持") {
		disableTableCheckBox(obj_item16,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_gongxiangzhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="共享支持") {
		disableTableCheckBox(obj_item18,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="基础设施") {
		disableTableCheckBox(obj_item89,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_gongxiangzhichi);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="其他") {
		obj_item87.readOnly="";
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_gongxiangzhichi);
	}
}

/*
*功能：点击提交时进行的表单验证
*配置：填报状态的“提交”按钮
*/
function checkData() {
	if (!checkEmptyReport()) {
		return true;
	}
	var objs_1 = getTableFormObjs(label_item5_1);
	var objs_2 = getTableFormObjs(label_item5_2);
	var objs_3 = getTableFormObjs(label_item5_3);
	
	//清空错误表单的背景色
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.color="";
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];
	
	//1 本季度新增的重大项目 校验
	subCheckfunction1(objs_1);
	//2 本季度完成的重大项目校验
	subCheckfunction2(objs_2);
	//3 本季度正在实施的重大项目校验
	subCheckfunction3(objs_3);
	
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
*功能：1 本季度新增的重大项目表单验证
*/
function subCheckfunction1(objs_1){
	for ( var i = 0; i < objs_1.length; i++) {
		// 过滤模版
		if ((objs_1[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
		var obj_qudaoguanli = getTableFormObj(label_qudaoguanli_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_kehuguanli = getTableFormObj(label_kehuguanli_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_chanpinguanli = getTableFormObj(label_chanpinguanli_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_caiwuguanli = getTableFormObj(label_caiwuguanli_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_juecezhichi = getTableFormObj(label_juecezhichi_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_gongxiangzhichi = getTableFormObj(label_gongxiangzhichi_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_jichusheshi = getTableFormObj(label_jichusheshi_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_qita = getTableFormObj(label_qita_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_item24_GTZero_1 = getTableFormObj(label_item24_GTZero_1,
				objs_1[i].rownumber + "_1");
		var obj_item25_1 = getTableFormObj(label_item25_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_item26_1 = getTableFormObj(label_item26_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_item48_1 = getTableFormObj(label_item48_1,
				objs_1[i].rownumber + "_1");
		var obj_item26_desc_1 = getTableFormObj(label_item26_desc_1,
				objs_1[i].rownumber + "_1");
		if (objs_1[i].value.trim() !="" && objs_1[i].value.trim() != "无"){
			if (obj_qudaoguanli.value=="" && obj_kehuguanli.value=="" && obj_chanpinguanli.value=="" &&
					obj_caiwuguanli.value=="" && obj_juecezhichi.value=="" && obj_gongxiangzhichi.value=="" && 
					obj_jichusheshi.value=="" && obj_qita.value=="") {
				errorObjs.push(obj_qudaoguanli.parentElement);
				errorObjs.push(obj_kehuguanli.parentElement);
				errorObjs.push(obj_chanpinguanli.parentElement);
				errorObjs.push(obj_caiwuguanli.parentElement);
				errorObjs.push(obj_juecezhichi.parentElement);
				errorObjs.push(obj_gongxiangzhichi.parentElement);
				errorObjs.push(obj_jichusheshi.parentElement);
				errorObjs.push(obj_qita.parentElement);
				a +="1、本季度新增的重大项目"+(i+1)+ "：名称不为“无”或空，则此项系统类别不能为空！\n";
				isValid = false;
			}
			if (obj_qudaoguanli.value != "" && 
					getTarget(getTableFormObj(label_qudaoguanliItems_1, objs_1[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_qudaoguanli.parentElement);
				a += "1、本季度新增的重大项目"+(i+1)+"：名称不为“无”或空，选择“渠道管理”时，其对应的子类型不能为空！\n";
				isValid = false;
			}
			if (obj_kehuguanli.value != "" && 
					getTarget(getTableFormObj(label_kehuguanliItems_1, objs_1[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_kehuguanli.parentElement);
				a += "1、本季度新增的重大项目"+(i+1)+"：名称不为“无”或空，选择“客户管理”时，其对应的子类型不能为空！\n";
				isValid = false;
			}
			if (obj_chanpinguanli.value != "" && 
					getTarget(getTableFormObj(label_chanpinguanliItems_1, objs_1[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_chanpinguanli.parentElement);
				a += "1、本季度新增的重大项目"+(i+1)+"：名称不为“无”或空，选择“产品管理”时，其对应的子类型不能为空！\n";
				isValid = false;
			}
			if (obj_caiwuguanli.value != "" && 
					getTarget(getTableFormObj(label_caiwuguanliItems_1, objs_1[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_caiwuguanli.parentElement);
				a += "1、本季度新增的重大项目"+(i+1)+"：名称不为“无”或空，选择“财务管理”时，其对应的子类型不能为空！\n";
				isValid = false;
			}
			if (obj_juecezhichi.value != "" && 
					getTarget(getTableFormObj(label_juecezhichiItems_1, objs_1[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_juecezhichi.parentElement);
				a += "1、本季度新增的重大项目"+(i+1)+"：名称不为“无”或空，选择“决策支持”时，其对应的子类型不能为空！\n";
				isValid = false;
			}
			if (obj_gongxiangzhichi.value != "" && 
					getTarget(getTableFormObj(label_gongxiangzhichiItems_1, objs_1[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_gongxiangzhichi.parentElement);
				a += "1、本季度新增的重大项目"+(i+1)+"：名称不为“无”或空，选择“决策支持”时，其对应的子类型不能为空！\n";
				isValid = false;
			}
			if (obj_jichusheshi.value != "" && 
					getTarget(getTableFormObj(label_jichusheshiItems_1, objs_1[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_jichusheshi.parentElement);
				a += "1、本季度新增的重大项目"+(i+1)+"：名称不为“无”或空，选择“决策支持”时，其对应的子类型不能为空！\n";
				isValid = false;
			}
			if (obj_qita.value != "" && 
					getTarget(getTableFormObj(label_qitaItems_1, objs_1[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_qita.parentElement);
				a += "1、本季度新增的重大项目"+(i+1)+"：名称不为“无”或空，选择“其他”时，其对应的子类型不能为空！\n";
				isValid = false;
			}
			if (obj_item24_GTZero_1.value.trim() == "") {
				errorObjs.push(obj_item24_GTZero_1);
				a += "1、本季度新增的重大项目"+(i+1)+"：名称不为“无”或空，则此项项目投入不能为空！\n";
				isValid = false;
			}
			if (obj_item25_1.value.trim() == "") {
				errorObjs.push(obj_item25_1);
				a += "1、本季度新增的重大项目"+(i+1)+"：名称不为“无”或空，则此项计划上线日期不能为空！\n";
				isValid = false;
			}
			if (obj_item26_1.value.trim() == "") {
				errorObjs.push(obj_item26_1);
				a += "1、本季度新增的重大项目"+(i+1)+"：名称不为“无”或空，则此项项目开始日期不能为空！\n";
				isValid = false;
			}
			if (obj_item48_1.value.trim() == "") {
				errorObjs.push(obj_item48_1.parentElement);
				a += "1、本季度新增的重大项目"+(i+1)+"：名称不为“无”或空，则此项实施模式不能为空！\n";
				isValid = false;
			}
			if (obj_item26_desc_1.value.trim() == "") {
				errorObjs.push(getEditDiv(obj_item26_desc_1));
				a += "1、本季度新增的重大项目"+(i+1)+"：名称不为“无”或空，则此项系统功能描述不能为空！\n";
				isValid = false;
			}
			if (obj_item25_1.value!="" && obj_item26_1.value!="") {
				if (obj_item25_1.value < obj_item26_1.value){
					errorObjs.push(obj_item26_1);
					errorObjs.push(obj_item25_1);
					a += "1、本季度新增的重大项目"+(i+1)+"：“项目开始日期”应小于“计划上线日期”！\n";
					isValid = false;
				}
			}
		} else {
			if (obj_qudaoguanli.value!="" || obj_kehuguanli.value!="" || obj_chanpinguanli.value!="" ||
					obj_caiwuguanli.value!="" || obj_juecezhichi.value!="" || obj_gongxiangzhichi.value!="" || 
					obj_jichusheshi.value!="" || obj_qita.value!="" || obj_item24_GTZero_1.value.trim()!=""||
					obj_item25_1.value.trim() != ""||obj_item26_1.value.trim() != ""||obj_item48_1.value.trim() != ""||
					obj_item26_desc_1.value.trim() != "") {
				errorObjs.push(objs_1[i]);
				a += "1、本季度新增的重大项目"+(i+1)+"：下方内容非空，则项目名称不能为空！\n";
				isValid = false;
			}
		}
	}
}



/*
*功能：2 本季度完成的重大项目表单验证
*/
function subCheckfunction2(objs_2){
	for ( var i = 0; i < objs_2.length; i++) {
		// 过滤模版
		if ((objs_2[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
		var obj_qudaoguanli = getTableFormObj(label_qudaoguanli_2,
				objs_2[i].rownumber + "_1_1_1");
		var obj_kehuguanli = getTableFormObj(label_kehuguanli_2,
				objs_2[i].rownumber + "_1_1_1");
		var obj_chanpinguanli = getTableFormObj(label_chanpinguanli_2,
				objs_2[i].rownumber + "_1_1_1");
		var obj_caiwuguanli = getTableFormObj(label_caiwuguanli_2,
				objs_2[i].rownumber + "_1_1_1");
		var obj_juecezhichi = getTableFormObj(label_juecezhichi_2,
				objs_2[i].rownumber + "_1_1_1");
		var obj_gongxiangzhichi = getTableFormObj(label_gongxiangzhichi_2,
				objs_2[i].rownumber + "_1_1_1");
		var obj_jichusheshi = getTableFormObj(label_jichusheshi_2,
				objs_2[i].rownumber + "_1_1_1");
		var obj_qita = getTableFormObj(label_qita_2,
				objs_2[i].rownumber + "_1_1_1");
		var obj_item24_GTZero_2 = getTableFormObj(label_item24_GTZero_2,
				objs_2[i].rownumber + "_1");
		var obj_item25_2 = getTableFormObj(label_item25_2,
				objs_2[i].rownumber + "_1_1_1");
		var obj_item26_2 = getTableFormObj(label_item26_2,
				objs_2[i].rownumber + "_1_1_1");
		var obj_item48_2 = getTableFormObj(label_item48_2,
				objs_2[i].rownumber + "_1");
		var obj_item26_desc_2 = getTableFormObj(label_item26_desc_2,
				objs_2[i].rownumber + "_1");
		var obj_item27_2 = getTableFormObj(label_item27_2,
				objs_2[i].rownumber + "_1_1");
		var obj_O_item27_2 = getTableFormObj(label_O_item27_2,
				objs_2[i].rownumber + "_1_1");
		
		if (objs_2[i].value.trim() !="" && objs_2[i].value.trim() != "无"){
			if (obj_qudaoguanli.value=="" && obj_kehuguanli.value=="" && obj_chanpinguanli.value=="" &&
					obj_caiwuguanli.value=="" && obj_juecezhichi.value=="" && obj_gongxiangzhichi.value=="" && 
					obj_jichusheshi.value=="" && obj_qita.value=="") {
				errorObjs.push(obj_qudaoguanli.parentElement);
				errorObjs.push(obj_kehuguanli.parentElement);
				errorObjs.push(obj_chanpinguanli.parentElement);
				errorObjs.push(obj_caiwuguanli.parentElement);
				errorObjs.push(obj_juecezhichi.parentElement);
				errorObjs.push(obj_gongxiangzhichi.parentElement);
				errorObjs.push(obj_jichusheshi.parentElement);
				errorObjs.push(obj_qita.parentElement);
				a +="2 本季度完成的重大项目"+(i+1)+ "：名称不为“无”或空，则此项系统类别不能为空！\n";
				isValid = false;
			}
			if (obj_qudaoguanli.value != "" && 
					getTarget(getTableFormObj(label_qudaoguanliItems_2, objs_2[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_qudaoguanli.parentElement);
				a += "2 本季度完成的重大项目"+(i+1)+"：名称不为“无”或空，选择“渠道管理”时，其对应的子类型不能为空！\n";
				isValid = false;
			}
			if (obj_kehuguanli.value != "" && 
					getTarget(getTableFormObj(label_kehuguanliItems_2, objs_2[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_kehuguanli.parentElement);
				a += "2 本季度完成的重大项目"+(i+1)+"：名称不为“无”或空，选择“客户管理”时，其对应的子类型不能为空！\n";
				isValid = false;
			}
			if (obj_chanpinguanli.value != "" && 
					getTarget(getTableFormObj(label_chanpinguanliItems_2, objs_2[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_chanpinguanli.parentElement);
				a += "2 本季度完成的重大项目"+(i+1)+"：名称不为“无”或空，选择“产品管理”时，其对应的子类型不能为空！\n";
				isValid = false;
			}
			if (obj_caiwuguanli.value != "" && 
					getTarget(getTableFormObj(label_caiwuguanliItems_2, objs_2[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_caiwuguanli.parentElement);
				a += "2 本季度完成的重大项目"+(i+1)+"：名称不为“无”或空，选择“财务管理”时，其对应的子类型不能为空！\n";
				isValid = false;
			}
			if (obj_juecezhichi.value != "" && 
					getTarget(getTableFormObj(label_juecezhichiItems_2, objs_2[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_juecezhichi.parentElement);
				a += "2 本季度完成的重大项目"+(i+1)+"：名称不为“无”或空，选择“决策支持”时，其对应的子类型不能为空！\n";
				isValid = false;
			}
			if (obj_gongxiangzhichi.value != "" && 
					getTarget(getTableFormObj(label_gongxiangzhichiItems_2, objs_2[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_gongxiangzhichi.parentElement);
				a += "2 本季度完成的重大项目"+(i+1)+"：名称不为“无”或空，选择“决策支持”时，其对应的子类型不能为空！\n";
				isValid = false;
			}
			if (obj_jichusheshi.value != "" && 
					getTarget(getTableFormObj(label_jichusheshiItems_2, objs_2[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_jichusheshi.parentElement);
				a += "2 本季度完成的重大项目"+(i+1)+"：名称不为“无”或空，选择“决策支持”时，其对应的子类型不能为空！\n";
				isValid = false;
			}
			if (obj_qita.value != "" && 
					getTarget(getTableFormObj(label_qitaItems_2, objs_2[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_qita.parentElement);
				a += "2 本季度完成的重大项目"+(i+1)+"：名称不为“无”或空，选择“其他”时，其对应的子类型不能为空！\n";
				isValid = false;
			}
			if (obj_item24_GTZero_2.value.trim() == "") {
				errorObjs.push(obj_item24_GTZero_2);
				a += "2 本季度完成的重大项目"+(i+1)+"：名称不为“无”或空，则此项项目投入不能为空！\n";
				isValid = false;
			}
			if (obj_item25_2.value.trim() == "") {
				errorObjs.push(obj_item25_2);
				a += "2 本季度完成的重大项目"+(i+1)+"：名称不为“无”或空，则此项计划上线日期不能为空！\n";
				isValid = false;
			}
			if (obj_item26_2.value.trim() == "") {
				errorObjs.push(obj_item26_2);
				a += "2 本季度完成的重大项目"+(i+1)+"：名称不为“无”或空，则此项项目开始日期不能为空！\n";
				isValid = false;
			}
			if (obj_item48_2.value.trim() == "") {
				errorObjs.push(obj_item48_2.parentElement);
				a += "2 本季度完成的重大项目"+(i+1)+"：名称不为“无”或空，则此项实施模式不能为空！\n";
				isValid = false;
			}
			if (obj_item26_desc_2.value.trim() == "") {
				errorObjs.push(getEditDiv(obj_item26_desc_2));
				a += "2 本季度完成的重大项目"+(i+1)+"：名称不为“无”或空，则此项系统功能描述不能为空！\n";
				isValid = false;
			}
			if (obj_item27_2.value.trim() == "") {
				errorObjs.push(obj_item27_2.parentElement);
				a += "2 本季度完成的重大项目"+(i+1)+"：名称不为“无”或空，则此项是否延期不能为空！\n";
				isValid = false;
			}
			if (obj_item25_2.value!="" && obj_item26_2.value!="") {
				if (obj_item25_2.value < obj_item26_2.value){
					errorObjs.push(obj_item26_2);
					errorObjs.push(obj_item25_2);
					a += "2 本季度完成的重大项目"+(i+1)+"：“项目开始日期”应小于“计划上线日期”！\n";
					isValid = false;
				}
			}
		} else {
			if (obj_qudaoguanli.value!="" || obj_kehuguanli.value!="" || obj_chanpinguanli.value!="" ||
					obj_caiwuguanli.value!="" || obj_juecezhichi.value!="" || obj_gongxiangzhichi.value!="" || 
					obj_jichusheshi.value!="" || obj_qita.value!="" || obj_item24_GTZero_2.value.trim()!=""||
					obj_item25_2.value.trim() != ""||obj_item26_2.value.trim() != ""||obj_item48_2.value.trim() != ""||
					obj_item26_desc_2.value.trim() != "" || obj_item27_2.value.trim() !="") {
				errorObjs.push(objs_2[i]);
				a += "2 本季度完成的重大项目"+(i+1)+"：下方内容非空，则项目名称不能为空！\n";
				isValid = false;
			}
		}
	}
	
}


/*
*功能：3 本季度正在实施的重大项目
*/
function subCheckfunction3(objs_3){
	for ( var i = 0; i < objs_3.length; i++) {
		// 过滤模版
		if ((objs_3[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
		var obj_qudaoguanli = getTableFormObj(label_qudaoguanli_3,
				objs_3[i].rownumber + "_1_1_1");
		var obj_kehuguanli = getTableFormObj(label_kehuguanli_3,
				objs_3[i].rownumber + "_1_1_1");
		var obj_chanpinguanli = getTableFormObj(label_chanpinguanli_3,
				objs_3[i].rownumber + "_1_1_1");
		var obj_caiwuguanli = getTableFormObj(label_caiwuguanli_3,
				objs_3[i].rownumber + "_1_1_1");
		var obj_juecezhichi = getTableFormObj(label_juecezhichi_3,
				objs_3[i].rownumber + "_1_1_1");
		var obj_gongxiangzhichi = getTableFormObj(label_gongxiangzhichi_3,
				objs_3[i].rownumber + "_1_1_1");
		var obj_jichusheshi = getTableFormObj(label_jichusheshi_3,
				objs_3[i].rownumber + "_1_1_1");
		var obj_qita = getTableFormObj(label_qita_3,
				objs_3[i].rownumber + "_1_1_1");
		var obj_item24_GTZero_3 = getTableFormObj(label_item24_GTZero_3,
				objs_3[i].rownumber + "_1");
		var obj_item25_3 = getTableFormObj(label_item25_3,
				objs_3[i].rownumber + "_1_1_1");
		var obj_item26_3 = getTableFormObj(label_item26_3,
				objs_3[i].rownumber + "_1_1_1");
		var obj_item48_3 = getTableFormObj(label_item48_3,
				objs_3[i].rownumber + "_1");
		var obj_item26_desc_3 = getTableFormObj(label_item26_desc_3,
				objs_3[i].rownumber + "_1");
		var obj_item27_3 = getTableFormObj(label_item27_3,
				objs_3[i].rownumber + "_1_1");
		var obj_O_item27_3 = getTableFormObj(label_O_item27_3,
				objs_3[i].rownumber + "_1_1");
		
		if (objs_3[i].value.trim() !="" && objs_3[i].value.trim() != "无"){
			if (obj_qudaoguanli.value=="" && obj_kehuguanli.value=="" && obj_chanpinguanli.value=="" &&
					obj_caiwuguanli.value=="" && obj_juecezhichi.value=="" && obj_gongxiangzhichi.value=="" && 
					obj_jichusheshi.value=="" && obj_qita.value=="") {
				errorObjs.push(obj_qudaoguanli.parentElement);
				errorObjs.push(obj_kehuguanli.parentElement);
				errorObjs.push(obj_chanpinguanli.parentElement);
				errorObjs.push(obj_caiwuguanli.parentElement);
				errorObjs.push(obj_juecezhichi.parentElement);
				errorObjs.push(obj_gongxiangzhichi.parentElement);
				errorObjs.push(obj_jichusheshi.parentElement);
				errorObjs.push(obj_qita.parentElement);
				a +="3 本季度正在实施的重大项目"+(i+1)+ "：名称不为“无”或空，则此项系统类别不能为空！\n";
				isValid = false;
			}
			if (obj_qudaoguanli.value != "" && 
					getTarget(getTableFormObj(label_qudaoguanliItems_3, objs_3[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_qudaoguanli.parentElement);
				a += "3 本季度正在实施的重大项目"+(i+1)+"：名称不为“无”或空，选择“渠道管理”时，其对应的子类型不能为空！\n";
				isValid = false;
			}
			if (obj_kehuguanli.value != "" && 
					getTarget(getTableFormObj(label_kehuguanliItems_3, objs_3[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_kehuguanli.parentElement);
				a += "3 本季度正在实施的重大项目"+(i+1)+"：名称不为“无”或空，选择“客户管理”时，其对应的子类型不能为空！\n";
				isValid = false;
			}
			if (obj_chanpinguanli.value != "" && 
					getTarget(getTableFormObj(label_chanpinguanliItems_3, objs_3[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_chanpinguanli.parentElement);
				a += "3 本季度正在实施的重大项目"+(i+1)+"：名称不为“无”或空，选择“产品管理”时，其对应的子类型不能为空！\n";
				isValid = false;
			}
			if (obj_caiwuguanli.value != "" && 
					getTarget(getTableFormObj(label_caiwuguanliItems_3, objs_3[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_caiwuguanli.parentElement);
				a += "3 本季度正在实施的重大项目"+(i+1)+"：名称不为“无”或空，选择“财务管理”时，其对应的子类型不能为空！\n";
				isValid = false;
			}
			if (obj_juecezhichi.value != "" && 
					getTarget(getTableFormObj(label_juecezhichiItems_3, objs_3[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_juecezhichi.parentElement);
				a += "3 本季度正在实施的重大项目"+(i+1)+"：名称不为“无”或空，选择“决策支持”时，其对应的子类型不能为空！\n";
				isValid = false;
			}
			if (obj_gongxiangzhichi.value != "" && 
					getTarget(getTableFormObj(label_gongxiangzhichiItems_3, objs_3[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_gongxiangzhichi.parentElement);
				a += "3 本季度正在实施的重大项目"+(i+1)+"：名称不为“无”或空，选择“决策支持”时，其对应的子类型不能为空！\n";
				isValid = false;
			}
			if (obj_jichusheshi.value != "" && 
					getTarget(getTableFormObj(label_jichusheshiItems_3, objs_3[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_jichusheshi.parentElement);
				a += "3 本季度正在实施的重大项目"+(i+1)+"：名称不为“无”或空，选择“决策支持”时，其对应的子类型不能为空！\n";
				isValid = false;
			}
			if (obj_qita.value != "" && 
					getTarget(getTableFormObj(label_qitaItems_3, objs_3[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_qita.parentElement);
				a += "3 本季度正在实施的重大项目"+(i+1)+"：名称不为“无”或空，选择“其他”时，其对应的子类型不能为空！\n";
				isValid = false;
			}
			if (obj_item24_GTZero_3.value.trim() == "") {
				errorObjs.push(obj_item24_GTZero_3);
				a += "3 本季度正在实施的重大项目"+(i+1)+"：名称不为“无”或空，则此项项目投入不能为空！\n";
				isValid = false;
			}
			if (obj_item25_3.value.trim() == "") {
				errorObjs.push(obj_item25_3);
				a += "3 本季度正在实施的重大项目"+(i+1)+"：名称不为“无”或空，则此项计划上线日期不能为空！\n";
				isValid = false;
			}
			if (obj_item26_3.value.trim() == "") {
				errorObjs.push(obj_item26_3);
				a += "3 本季度正在实施的重大项目"+(i+1)+"：名称不为“无”或空，则此项项目开始日期不能为空！\n";
				isValid = false;
			}
			if (obj_item48_3.value.trim() == "") {
				errorObjs.push(obj_item48_3.parentElement);
				a += "3 本季度正在实施的重大项目"+(i+1)+"：名称不为“无”或空，则此项实施模式不能为空！\n";
				isValid = false;
			}
			if (obj_item26_desc_3.value.trim() == "") {
				errorObjs.push(getEditDiv(obj_item26_desc_3));
				a += "3 本季度正在实施的重大项目"+(i+1)+"：名称不为“无”或空，则此项系统功能描述不能为空！\n";
				isValid = false;
			}
			if (obj_item27_3.value.trim() == "") {
				errorObjs.push(obj_item27_3.parentElement);
				a += "3 本季度正在实施的重大项目"+(i+1)+"：名称不为“无”或空，则此项是否延期不能为空！\n";
				isValid = false;
			}
			if (obj_item25_3.value!="" && obj_item26_3.value!="") {
				if (obj_item25_3.value < obj_item26_3.value){
					errorObjs.push(obj_item26_3);
					errorObjs.push(obj_item25_3);
					a += "3 本季度正在实施的重大项目"+(i+1)+"：“项目开始日期”应小于“计划上线日期”！\n";
					isValid = false;
				}
			}
		} else {
			if (obj_qudaoguanli.value!="" || obj_kehuguanli.value!="" || obj_chanpinguanli.value!="" ||
					obj_caiwuguanli.value!="" || obj_juecezhichi.value!="" || obj_gongxiangzhichi.value!="" || 
					obj_jichusheshi.value!="" || obj_qita.value!="" || obj_item24_GTZero_3.value.trim()!=""||
					obj_item25_3.value.trim() != ""||obj_item26_3.value.trim() != ""||obj_item48_3.value.trim() != ""||
					obj_item26_desc_3.value.trim() != "" || obj_item27_3.value.trim() !="") {
				errorObjs.push(objs_3[i]);
				a += "3 本季度正在实施的重大项目"+(i+1)+"：下方内容非空，则项目名称不能为空！\n";
				isValid = false;
			}
		}
	}
	//如果必填校验无误则校验计划上线日期和项目开始日期前后关系
	if (isValid){
		for ( var i = 0; i < objs_3.length; i++) {
			// 过滤模版
			if ((objs_3[i].rownumber + "").indexOf("#") > -1) {
				continue;
			}
			var obj_item25 = getTableFormObj(label_item25_3,
					objs_3[i].rownumber + "_1_1_1");
			var obj_item26 = getTableFormObj(label_item26_3,
					objs_3[i].rownumber + "_1_1_1");
			if (obj_item25.value < obj_item26.value){
				errorObjs.push(obj_item26);
				a += "3 本季度正在实施的重大项目"+(i+1)+"：“项目开始日期”应小于“计划上线日期”！\n";
				isValid = false;
			}
		}
	}
}


/*
* 功能："1 本季度新增的重大项目"二级审批状态初始化时设置表单权限
*/
function initSet_1(objs_1){
	for ( var i = 0; i < objs_1.length; i++) {
		// 过滤模版
		if ((objs_1[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
		var obj_qudaoguanli = getTableFormObj(label_qudaoguanli_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_kehuguanli = getTableFormObj(label_kehuguanli_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_chanpinguanli = getTableFormObj(label_chanpinguanli_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_caiwuguanli = getTableFormObj(label_caiwuguanli_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_juecezhichi = getTableFormObj(label_juecezhichi_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_gongxiangzhichi = getTableFormObj(label_gongxiangzhichi_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_jichusheshi = getTableFormObj(label_jichusheshi_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_qita = getTableFormObj(label_qita_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_item8 = getTableFormCheckBox(label_qudaoguanliItems_1,objs_1[i].rownumber + "_1_1_1");
		var obj_item10 = getTableFormCheckBox(label_kehuguanliItems_1,objs_1[i].rownumber + "_1_1_1");
		var obj_item12 = getTableFormCheckBox(label_chanpinguanliItems_1,objs_1[i].rownumber + "_1_1_1");
		var obj_item14 = getTableFormCheckBox(label_caiwuguanliItems_1,objs_1[i].rownumber + "_1_1_1" );
		var obj_item16 = getTableFormCheckBox(label_juecezhichiItems_1,objs_1[i].rownumber + "_1_1_1");
		var obj_item18 = getTableFormCheckBox(label_gongxiangzhichiItems_1,objs_1[i].rownumber + "_1_1_1" );
		var obj_item89 = getTableFormCheckBox(label_jichusheshiItems_1,objs_1[i].rownumber + "_1_1_1" );
		var obj_item87 = getTableFormObj(label_qitaItems_1,objs_1[i].rownumber + "_1_1_1" );
		
		if (obj_qudaoguanli.value=="渠道管理") {
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item18,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_kehuguanli.value=="客户管理") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item18,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_chanpinguanli.value=="产品管理") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item18,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_caiwuguanli.value=="财务管理") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item18,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_juecezhichi.value=="决策支持") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item18,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_gongxiangzhichi.value=="共享支持") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_jichusheshi.value=="基础设施") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item18,true);
			obj_item87.readOnly="readonly";
		} else if (obj_qita.value=="其他") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item18,true);
			disableTableCheckBox(obj_item89,true);
		}
	}
}
/*
* 功能："2 本季度完成的重大项目"二级审批状态初始化时设置表单权限
*/
function initSet_2(objs_1){
	for ( var i = 0; i < objs_1.length; i++) {
		// 过滤模版
		if ((objs_1[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
		var obj_qudaoguanli = getTableFormObj(label_qudaoguanli_2,
				objs_1[i].rownumber + "_1_1_1");
		var obj_kehuguanli = getTableFormObj(label_kehuguanli_2,
				objs_1[i].rownumber + "_1_1_1");
		var obj_chanpinguanli = getTableFormObj(label_chanpinguanli_2,
				objs_1[i].rownumber + "_1_1_1");
		var obj_caiwuguanli = getTableFormObj(label_caiwuguanli_2,
				objs_1[i].rownumber + "_1_1_1");
		var obj_juecezhichi = getTableFormObj(label_juecezhichi_2,
				objs_1[i].rownumber + "_1_1_1");
		var obj_gongxiangzhichi = getTableFormObj(label_gongxiangzhichi_2,
				objs_1[i].rownumber + "_1_1_1");
		var obj_jichusheshi = getTableFormObj(label_jichusheshi_2,
				objs_1[i].rownumber + "_1_1_1");
		var obj_qita = getTableFormObj(label_qita_2,
				objs_1[i].rownumber + "_1_1_1");
		var obj_item8 = getTableFormCheckBox(label_qudaoguanliItems_2,objs_1[i].rownumber + "_1_1_1");
		var obj_item10 = getTableFormCheckBox(label_kehuguanliItems_2,objs_1[i].rownumber + "_1_1_1");
		var obj_item12 = getTableFormCheckBox(label_chanpinguanliItems_2,objs_1[i].rownumber + "_1_1_1");
		var obj_item14 = getTableFormCheckBox(label_caiwuguanliItems_2,objs_1[i].rownumber + "_1_1_1" );
		var obj_item16 = getTableFormCheckBox(label_juecezhichiItems_2,objs_1[i].rownumber + "_1_1_1");
		var obj_item18 = getTableFormCheckBox(label_gongxiangzhichiItems_2,objs_1[i].rownumber + "_1_1_1" );
		var obj_item89 = getTableFormCheckBox(label_jichusheshiItems_2,objs_1[i].rownumber + "_1_1_1" );
		var obj_item87 = getTableFormObj(label_qitaItems_2,objs_1[i].rownumber + "_1_1_1" );
		
		if (obj_qudaoguanli.value=="渠道管理") {
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item18,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_kehuguanli.value=="客户管理") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item18,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_chanpinguanli.value=="产品管理") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item18,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_caiwuguanli.value=="财务管理") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item18,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_juecezhichi.value=="决策支持") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item18,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_gongxiangzhichi.value=="共享支持") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_jichusheshi.value=="基础设施") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item18,true);
			obj_item87.readOnly="readonly";
		} else if (obj_qita.value=="其他") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item18,true);
			disableTableCheckBox(obj_item89,true);
		}
	}
}

/*
* 功能："3 本季度正在实施的重大项目"二级审批状态初始化时设置表单权限
*/
function initSet_3(objs_1){
	for ( var i = 0; i < objs_1.length; i++) {
		// 过滤模版
		if ((objs_1[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
		var obj_qudaoguanli = getTableFormObj(label_qudaoguanli_3,
				objs_1[i].rownumber + "_1_1_1");
		var obj_kehuguanli = getTableFormObj(label_kehuguanli_3,
				objs_1[i].rownumber + "_1_1_1");
		var obj_chanpinguanli = getTableFormObj(label_chanpinguanli_3,
				objs_1[i].rownumber + "_1_1_1");
		var obj_caiwuguanli = getTableFormObj(label_caiwuguanli_3,
				objs_1[i].rownumber + "_1_1_1");
		var obj_juecezhichi = getTableFormObj(label_juecezhichi_3,
				objs_1[i].rownumber + "_1_1_1");
		var obj_gongxiangzhichi = getTableFormObj(label_gongxiangzhichi_3,
				objs_1[i].rownumber + "_1_1_1");
		var obj_jichusheshi = getTableFormObj(label_jichusheshi_3,
				objs_1[i].rownumber + "_1_1_1");
		var obj_qita = getTableFormObj(label_qita_3,
				objs_1[i].rownumber + "_1_1_1");
		var obj_item8 = getTableFormCheckBox(label_qudaoguanliItems_3,objs_1[i].rownumber + "_1_1_1");
		var obj_item10 = getTableFormCheckBox(label_kehuguanliItems_3,objs_1[i].rownumber + "_1_1_1");
		var obj_item12 = getTableFormCheckBox(label_chanpinguanliItems_3,objs_1[i].rownumber + "_1_1_1");
		var obj_item14 = getTableFormCheckBox(label_caiwuguanliItems_3,objs_1[i].rownumber + "_1_1_1" );
		var obj_item16 = getTableFormCheckBox(label_juecezhichiItems_3,objs_1[i].rownumber + "_1_1_1");
		var obj_item18 = getTableFormCheckBox(label_gongxiangzhichiItems_3,objs_1[i].rownumber + "_1_1_1" );
		var obj_item89 = getTableFormCheckBox(label_jichusheshiItems_3,objs_1[i].rownumber + "_1_1_1" );
		var obj_item87 = getTableFormObj(label_qitaItems_3,objs_1[i].rownumber + "_1_1_1" );
		
		if (obj_qudaoguanli.value=="渠道管理") {
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item18,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_kehuguanli.value=="客户管理") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item18,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_chanpinguanli.value=="产品管理") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item18,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_caiwuguanli.value=="财务管理") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item18,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_juecezhichi.value=="决策支持") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item18,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_gongxiangzhichi.value=="共享支持") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_jichusheshi.value=="基础设施") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item18,true);
			obj_item87.readOnly="readonly";
		} else if (obj_qita.value=="其他") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item18,true);
			disableTableCheckBox(obj_item89,true);
		}
	}
}