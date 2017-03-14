/*
 * 报表：2014- T-B-7 信息科技基础设施情况表 
 */

//校验按钮
var isValid = true;
var a = "";
var errorObjs = [];

var label_YN01_01 = "基础设施灾备模式#内容#基础设施灾备模式";
// 基本情况
var label_YN02_00 = "信息科技基础设施情况#数据（灾备）中心机房名称";
var label_YN02_01_01 = "信息科技基础设施情况#基本情况#框架#类型#选择#1#选择#类型";
var label_YN02_01_02 = "信息科技基础设施情况#基本情况#框架#类型#选择#1#选择#多选#类型";

var label_YN02_02 = "信息科技基础设施情况#基本情况#框架#设计等级#单选";
var label_YN02_03 = "信息科技基础设施情况#基本情况#框架#机房总面积#数字控件";
var label_YN02_04 = "信息科技基础设施情况#基本情况#框架#功能用途#功能用途";

var label_YN02_05_01 = "信息科技基础设施情况#基本情况#框架#产权形式#内容#使用模式";
var label_YN02_05_02_01 = "信息科技基础设施情况#基本情况#框架#产权形式#内容#1#共有方名称";
var label_YN02_05_02_02 = "信息科技基础设施情况#基本情况#框架#产权形式#内容#1#出租(出借)方名称";
var label_YN02_05_03_01 = "信息科技基础设施情况#基本情况#框架#产权形式#内容#2#性质";

var label_YN02_06_01 = "信息科技基础设施情况#基本情况#框架#使用模式#1#单选";
var label_YN02_06_02 = "信息科技基础设施情况#基本情况#框架#使用模式#1#托管机构名称";
var label_YN02_06_03 = "信息科技基础设施情况#基本情况#框架#使用模式#1#性质";

var label_YN02_07_01 = "信息科技基础设施情况#基本情况#框架#运维模式#1#1#运维模式";
var label_YN02_07_02 = "信息科技基础设施情况#基本情况#框架#运维模式#1#1#外包商名称";
var label_YN02_07_03 = "信息科技基础设施情况#基本情况#框架#运维模式#1#1#性质";
var label_YN02_07_04 = "信息科技基础设施情况#基本情况#框架#运维模式#1#其他服务内容#外包服务内容";

var label_YN02_08_01 = "信息科技基础设施情况#基本情况#框架#地点#1#国家";
var label_YN02_08_02 = "信息科技基础设施情况#基本情况#框架#地点#1#省（自治区、直辖市）";
var label_YN02_08_03 = "信息科技基础设施情况#基本情况#框架#地点#1#市（县、州、盟）";

var label_YN02_09 = "信息科技基础设施情况#基本情况#框架#启用日期#日期";

var label_YN03_01_01 = "信息科技基础设施情况#供电#框架#供电线路#变配电室有双路市电接入";
var label_YN03_01_02 = "信息科技基础设施情况#供电#框架#供电线路#双路市电由不同变电所接入";

var label_YN03_02_01 = "信息科技基础设施情况#供电#框架#UPS#1#UPS供电模式#单选";
var label_YN03_02_02 = "信息科技基础设施情况#供电#框架#UPS#2#系统设计容量#1";
var label_YN03_02_03 = "信息科技基础设施情况#供电#框架#UPS#3#实际负载峰值#1";
var label_YN03_02_04 = "信息科技基础设施情况#供电#框架#UPS#4#满载电池可用时间#1";
var label_YN03_02_05 = "信息科技基础设施情况#供电#框架#UPS#5#UPS主机中最长使用年份#1";
var label_YN03_02_06 = "信息科技基础设施情况#供电#框架#UPS#6#UPS电池中最长使用年份#1";

var label_YN03_03_01 = "信息科技基础设施情况#供电#框架#发电机#1#是否配备#是否配备";
var label_YN03_03_02 = "信息科技基础设施情况#供电#框架#发电机#2#额定功率#额定功率";
var label_YN03_03_03 = "信息科技基础设施情况#供电#框架#发电机#3#自动启动#自动启动";
var label_YN03_03_04 = "信息科技基础设施情况#供电#框架#发电机#4#启动时间#启动时间";
var label_YN03_03_05 = "信息科技基础设施情况#供电#框架#发电机#5#本地油料储备可用时间#本地油料储备可用时间";

var label_YN03_03_06_01 = "信息科技基础设施情况#供电#框架#发电机#6#运维单位#运维单位";
var label_YN03_03_06_02 = "信息科技基础设施情况#供电#框架#发电机#6#运维单位#运维单位名称";
var label_YN03_03_07_01 = "信息科技基础设施情况#供电#框架#发电机#7#是否租用#是否租用";
var label_YN03_03_07_02 = "信息科技基础设施情况#供电#框架#发电机#7#是否租用#出租房名称";

var label_YN04_01_02 = "信息科技基础设施情况#门禁与监控#框架#机房门禁#门禁记录保存时间#数字控件";
var label_YN04_01_03 = "信息科技基础设施情况#门禁与监控#框架#机房门禁#是否采用国外设备#单选";

var label_YN04_02_02 = "信息科技基础设施情况#门禁与监控#框架#环境监控#监控记录保存时间#数字控件";

var label_YN05_01 = "信息科技基础设施情况#电磁屏蔽#框架#全屏蔽#是否屏蔽";
var label_YN05_02 = "信息科技基础设施情况#电磁屏蔽#框架#全屏蔽#电磁屏蔽区域";

var label_YN06 = "信息科技基础设施情况#防雷设施#框架#是否具备#单选";

var label_YN07 = "信息科技基础设施情况#防水#是否具备#单选";

var label_YN08_01 = "信息科技基础设施情况#空调#设计单位面积制冷量#数字控件";

var label_YN09_01 = "信息科技基础设施情况#消防#灭火方式#文本框";
var label_YN09_02 = "信息科技基础设施情况#消防#灭火剂类型#文本框";
var label_YN09_03 = "信息科技基础设施情况#消防#本年度是否有专业机构或部门对消防设备进行检测#是否进行检测";
var label_YN09_04 = "信息科技基础设施情况#消防#本年度是否有专业机构或部门对消防设备进行检测#检测时间";

var label_YN10 = "信息科技基础设施情况#巡检#巡检频度#数字控件";

var label_YN11_01 = "信息科技基础设施情况#灾备具体情况（仅在中心类型包含灾备中心或承担灾备功能时填写）#框架#备份生产中心名称";
var label_YN11_02 = "信息科技基础设施情况#灾备具体情况（仅在中心类型包含灾备中心或承担灾备功能时填写）#框架#区域";
var label_YN11_03 = "信息科技基础设施情况#灾备具体情况（仅在中心类型包含灾备中心或承担灾备功能时填写）#框架#与生产中心距离（公里）";
var label_YN11_04 = "信息科技基础设施情况#灾备具体情况（仅在中心类型包含灾备中心或承担灾备功能时填写）#框架#备注";
/*
 * 功能：通过单选来控制后面文本框和单选是否只读 配置：信息科技基础设施情况#消防#本年度是否有专业机构或部门对消防设备进行检测#单选
 */
function setObj_YN09_04Disable(obj) {
	if(obj){
		var rownumber = "";
		if (obj.flag == "是") {
			rownumber = obj.parentElement.nextSibling.nextSibling.rownumber;
		} else {
			rownumber = obj.parentElement.nextSibling.rownumber;
		}
		if (rownumber != "") {
			var obj_YN09_03 = getTableFormObj(label_YN09_03, rownumber);
			var obj_YN09_04 = getTableFormObj(label_YN09_04, obj_YN09_03.rownumber);
			if (obj_YN09_03.value == "是") {
				obj_YN09_04.onclick = click_columnshowDate;
			} else {
				obj_YN09_04.onclick = "";
				obj_YN09_04.value = "";
			}
		}
	}else{
		var obj_YN09_03Arr = getTableFormObjs(label_YN09_03);
		for ( var i = 0; i < obj_YN09_03Arr.length; i++) {
			var obj_YN09_03 = obj_YN09_03Arr[i];
			var obj_YN09_04 = getTableFormObj(label_YN09_04, obj_YN09_03.rownumber);
			if (obj_YN09_03.value == "是") {
				obj_YN09_04.onclick = click_columnshowDate;
			} else {
				obj_YN09_04.onclick = "";
				obj_YN09_04.value = "";
			}
		}
	}
	
	

}
/*
 * 功能：通过单选来控制后面文本框和单选是否只读 配置：电磁屏蔽#框架#全屏蔽#单选
 */
function setObj_YN05_02Disable(obj) {
	if(obj){
		var rownumber = "";
		if (obj.flag == "是") {
			rownumber = obj.parentElement.nextSibling.nextSibling.rownumber;
		} else {
			rownumber = obj.parentElement.nextSibling.rownumber;
		}
		if(rownumber != ""){
			var obj_YN05_01 = getTableFormObj(label_YN05_01,rownumber);
			var obj_YN05_02 = getTableFormObj(label_YN05_02, obj_YN05_01.rownumber);
			if (obj_YN05_01.value == "是") {
				obj_YN05_02.readOnly = "";
			} else {
				obj_YN05_02.readOnly = "readonly";
				obj_YN05_02.value = "";
			}
		}
	}else{
		var obj_YN05_01Arr = getTableFormObjs(label_YN05_01);
		for ( var i = 0; i < obj_YN05_01Arr.length; i++) {
			var obj_YN05_01 = obj_YN05_01Arr[i];
			var obj_YN05_02 = getTableFormObj(label_YN05_02, obj_YN05_01.rownumber);
			if (obj_YN05_01.value == "是") {
				obj_YN05_02.readOnly = "";
			} else {
				obj_YN05_02.readOnly = "readonly";
				obj_YN05_02.value = "";
			}
		}
	}

}
/*
 * 功能：通过单选来控制后面文本框和单选是否只读 配置：信息科技基础设施情况#供电#框架#发电机#7#是否租用#单选
 */
function setObj_YN03_03_07_02(obj) {
	if(obj){
		var rownumber = "";
		if (obj.flag == "是") {
			rownumber = obj.parentElement.nextSibling.nextSibling.rownumber;
		} else {
			rownumber = obj.parentElement.nextSibling.rownumber;
		}
		if(rownumber != ""){
			var obj_YN03_03_07_01 = getTableFormObj(label_YN03_03_07_01,rownumber);
			var obj_YN03_03_07_02 = getTableFormObj(label_YN03_03_07_02,
					obj_YN03_03_07_01.rownumber);
			if (obj_YN03_03_07_01.value == "是") {
				obj_YN03_03_07_02.readOnly = "";
			} else {
				obj_YN03_03_07_02.value = "";
				obj_YN03_03_07_02.readOnly = "readonly";
			}
		}
	}else{
		var obj_YN03_03_07_01Arr = getTableFormObjs(label_YN03_03_07_01);
		for ( var i = 0; i < obj_YN03_03_07_01Arr.length; i++) {
			var obj_YN03_03_07_01 = obj_YN03_03_07_01Arr[i];
			var obj_YN03_03_07_02 = getTableFormObj(label_YN03_03_07_02,
					obj_YN03_03_07_01.rownumber);
			if (obj_YN03_03_07_01.value == "是") {
				obj_YN03_03_07_02.readOnly = "";
			} else {
				obj_YN03_03_07_02.value = "";
				obj_YN03_03_07_02.readOnly = "readonly";
			}
		}
	}
	
}

/*
 * 功能：通过单选来控制后面文本框和单选是否只读 配置：信息科技基础设施情况#供电#框架#发电机#6#运维单位#单选
 */
function setObj_YN03_03_06_02(obj) {
	if(obj){
		var rownumber = "";
		if (obj.flag == "本机构") {
			rownumber = obj.parentElement.nextSibling.nextSibling.rownumber;
		} else {
			rownumber = obj.parentElement.nextSibling.rownumber;
		}
		if(rownumber != ""){
			var obj_YN03_03_06_01 = getTableFormObj(label_YN03_03_06_01,rownumber);
			var obj_YN03_03_06_02 = getTableFormObj(label_YN03_03_06_02,
					obj_YN03_03_06_01.rownumber);
			if (obj_YN03_03_06_01.value == "外部机构") {
				obj_YN03_03_06_02.readOnly = "";
			} else {
				obj_YN03_03_06_02.value = "";
				obj_YN03_03_06_02.readOnly = "readonly";
			}
		}
	}else{
		var obj_YN03_03_06_01Arr = getTableFormObjs(label_YN03_03_06_01);
		for ( var i = 0; i < obj_YN03_03_06_01Arr.length; i++) {
			var obj_YN03_03_06_01 = obj_YN03_03_06_01Arr[i];
			var obj_YN03_03_06_02 = getTableFormObj(label_YN03_03_06_02,
					obj_YN03_03_06_01.rownumber);
			if (obj_YN03_03_06_01.value == "外部机构") {
				obj_YN03_03_06_02.readOnly = "";
			} else {
				obj_YN03_03_06_02.value = "";
				obj_YN03_03_06_02.readOnly = "readonly";
			}
		}
	}
	
	
	
	
}

/*
 * 功能：通过单选来控制后面文本框和单选是否只读 配置：信息科技基础设施情况#供电#框架#发电机#1#是否配备#单选
 */
function setObj_YN03OthersDisable(obj) {
	if(obj){
		var rownumber = "";
		if (obj.flag == "是") {
			rownumber = obj.parentElement.nextSibling.nextSibling.rownumber;
		} else {
			rownumber = obj.parentElement.nextSibling.rownumber;
		}
		if(rownumber){
			var obj_YN03_03_01 = getTableFormObj(label_YN03_03_01,rownumber);
			var obj_YN03_03_02 = getTableFormObj(label_YN03_03_02,
					obj_YN03_03_01.rownumber);
			var obj_YN03_03_03 = getTableFormObj(label_YN03_03_03,
					obj_YN03_03_01.rownumber);
			var obj_YN03_03_04 = getTableFormObj(label_YN03_03_04,
					obj_YN03_03_01.rownumber);
			var obj_YN03_03_05 = getTableFormObj(label_YN03_03_05,
					obj_YN03_03_01.rownumber);
			var obj_YN03_03_06_01 = getTableFormObj(label_YN03_03_06_01,
					obj_YN03_03_01.rownumber);
			var obj_YN03_03_07_01 = getTableFormObj(label_YN03_03_07_01,
					obj_YN03_03_01.rownumber);
			if (obj_YN03_03_01.value == "是") {
				obj_YN03_03_02.readOnly = "";
				columnVallueRadio1(obj_YN03_03_03, true, 0);
				obj_YN03_03_04.readOnly = "";
				obj_YN03_03_05.readOnly = "";
				columnVallueRadio1(obj_YN03_03_06_01, true, 1);
				columnVallueRadio1(obj_YN03_03_07_01, true, 2);
			} else {
				obj_YN03_03_02.value = "";
				obj_YN03_03_03.value = "";
				obj_YN03_03_04.value = "";
				obj_YN03_03_05.value = "";
				obj_YN03_03_06_01.value = "";
				obj_YN03_03_07_01.value = "";
				obj_YN03_03_02.readOnly = "readonly";
				columnVallueRadio1(obj_YN03_03_03, false, 0);
				obj_YN03_03_04.readOnly = "readonly";
				obj_YN03_03_05.readOnly = "readonly";
				columnVallueRadio1(obj_YN03_03_06_01, false, 0);
				columnVallueRadio1(obj_YN03_03_07_01, false, 0);

			}

		}
	}else{
		var obj_YN03_03_01Arr = getTableFormObjs(label_YN03_03_01);
		for ( var i = 0; i < obj_YN03_03_01Arr.length; i++) {
			var obj_YN03_03_01 = obj_YN03_03_01Arr[i];
			var obj_YN03_03_02 = getTableFormObj(label_YN03_03_02,
					obj_YN03_03_01.rownumber);
			var obj_YN03_03_03 = getTableFormObj(label_YN03_03_03,
					obj_YN03_03_01.rownumber);
			var obj_YN03_03_04 = getTableFormObj(label_YN03_03_04,
					obj_YN03_03_01.rownumber);
			var obj_YN03_03_05 = getTableFormObj(label_YN03_03_05,
					obj_YN03_03_01.rownumber);
			var obj_YN03_03_06_01 = getTableFormObj(label_YN03_03_06_01,
					obj_YN03_03_01.rownumber);
			var obj_YN03_03_07_01 = getTableFormObj(label_YN03_03_07_01,
					obj_YN03_03_01.rownumber);
			if (obj_YN03_03_01.value == "是") {
				obj_YN03_03_02.readOnly = "";
				columnVallueRadio1(obj_YN03_03_03, true, 0);
				obj_YN03_03_04.readOnly = "";
				obj_YN03_03_05.readOnly = "";
				columnVallueRadio1(obj_YN03_03_06_01, true, 1);
				columnVallueRadio1(obj_YN03_03_07_01, true, 2);
			} else {
				obj_YN03_03_02.value = "";
				obj_YN03_03_03.value = "";
				obj_YN03_03_04.value = "";
				obj_YN03_03_05.value = "";
				obj_YN03_03_06_01.value = "";
				obj_YN03_03_07_01.value = "";
				obj_YN03_03_02.readOnly = "readonly";
				columnVallueRadio1(obj_YN03_03_03, false, 0);
				obj_YN03_03_04.readOnly = "readonly";
				obj_YN03_03_05.readOnly = "readonly";
				columnVallueRadio1(obj_YN03_03_06_01, false, 0);
				columnVallueRadio1(obj_YN03_03_07_01, false, 0);

			}

		}
	}
	
	
	
	
}
/*
 * 功能：通过单选来控制后面文本框和单选是否只读 配置：信息科技基础设施情况#基本情况#框架#运维模式#1#单选
 */
function setObj_YN02_07_02_03_04Disable(obj) {
	if(obj){
		var rownumber = "";
		if (obj.flag == "自主运维") {
			rownumber = obj.parentElement.nextSibling.nextSibling.nextSibling.rownumber;
		} else if(obj.flag == "整体运维外包"){
			rownumber = obj.parentElement.nextSibling.nextSibling.rownumber;
		}else{
			rownumber = obj.parentElement.nextSibling.rownumber;
		}
		if(rownumber != ""){
			var obj_YN02_07_01 = getTableFormObj(label_YN02_07_01,rownumber);
			var obj_YN02_07_02 = getTableFormObj(label_YN02_07_02,
					obj_YN02_07_01.rownumber);
			var obj_YN02_07_03 = getTableFormObj(label_YN02_07_03,
					obj_YN02_07_01.rownumber);
			var obj_YN02_07_04 = getTableFormCheckBox(label_YN02_07_04,
					obj_YN02_07_01.rownumber);
			if (obj_YN02_07_01.value == "自主运维" || obj_YN02_07_01.value == "") {
				obj_YN02_07_02.value = "";
				obj_YN02_07_03.value = "";
				obj_YN02_07_02.readOnly = "readonly";
				columnVallueRadio1(obj_YN02_07_03, false, 0);
				disableTableCheckBox(obj_YN02_07_04, true);

			} else if (obj_YN02_07_01.value == "整体运维外包") {

				obj_YN02_07_02.readOnly = "";
				columnVallueRadio1(obj_YN02_07_03, true, 0);
				disableTableCheckBox(obj_YN02_07_04, true);

			} else if (obj_YN02_07_01.value == "部分运维外包") {
				obj_YN02_07_02.value = "";
				obj_YN02_07_03.value = "";
				obj_YN02_07_02.readOnly = "readonly";
				columnVallueRadio1(obj_YN02_07_03, false, 0);
				disableTableCheckBox(obj_YN02_07_04, false);
			}
		}
	}else{
		var obj_YN02_07_01Arr = getTableFormObjs(label_YN02_07_01);
		for ( var i = 0; i < obj_YN02_07_01Arr.length; i++) {
			var obj_YN02_07_01 = obj_YN02_07_01Arr[i];
			var obj_YN02_07_02 = getTableFormObj(label_YN02_07_02,
					obj_YN02_07_01.rownumber);
			var obj_YN02_07_03 = getTableFormObj(label_YN02_07_03,
					obj_YN02_07_01.rownumber);
			var obj_YN02_07_04 = getTableFormCheckBox(label_YN02_07_04,
					obj_YN02_07_01.rownumber);
			if (obj_YN02_07_01.value == "自主运维" || obj_YN02_07_01.value == "") {
				obj_YN02_07_02.value = "";
				obj_YN02_07_03.value = "";
				obj_YN02_07_02.readOnly = "readonly";
				columnVallueRadio1(obj_YN02_07_03, false, 0);
				disableTableCheckBox(obj_YN02_07_04, true);

			} else if (obj_YN02_07_01.value == "整体运维外包") {

				obj_YN02_07_02.readOnly = "";

				columnVallueRadio1(obj_YN02_07_03, true, 0);
				disableTableCheckBox(obj_YN02_07_04, true);

			} else if (obj_YN02_07_01.value == "部分运维外包") {
				obj_YN02_07_02.value = "";
				obj_YN02_07_03.value = "";
				obj_YN02_07_02.readOnly = "readonly";
				columnVallueRadio1(obj_YN02_07_03, false, 0);
				disableTableCheckBox(obj_YN02_07_04, false);
			}
		}
	}
	

}

/*
 * 功能：通过单选来控制后面文本框和单选是否只读 配置：信息科技基础设施情况#基本情况#框架#产权形式#内容#单选
 */
function setObj_YN02_06_02_03Disable(obj) {
	if(obj){
		var rownumber = "";
		if (obj.flag == "独立使用") {
			rownumber = obj.parentElement.nextSibling.nextSibling.rownumber;
		} else {
			rownumber = obj.parentElement.nextSibling.rownumber;
		}
		if(rownumber){
			var obj_YN02_06_01 = getTableFormObj(label_YN02_06_01,rownumber);
			var obj_YN02_06_02 = getTableFormObj(label_YN02_06_02,
					obj_YN02_06_01.rownumber);
			var obj_YN02_06_03 = getTableFormObj(label_YN02_06_03,
					obj_YN02_06_01.rownumber);
			if (obj_YN02_06_01.value == "托管") {
				obj_YN02_06_02.readOnly = "";
				columnVallueRadio1(obj_YN02_06_03, true, 0);
			} else {
				obj_YN02_06_02.value = "";
				obj_YN02_06_03.value = "";
				obj_YN02_06_02.readOnly = "readonly";
				columnVallueRadio1(obj_YN02_06_03, false, 0);
			}
		}
	}else{
		var obj_YN02_06_01Arr = getTableFormObjs(label_YN02_06_01);
		for ( var i = 0; i < obj_YN02_06_01Arr.length; i++) {
			var obj_YN02_06_01 = obj_YN02_06_01Arr[i];
			var obj_YN02_06_02 = getTableFormObj(label_YN02_06_02,
					obj_YN02_06_01.rownumber);
			var obj_YN02_06_03 = getTableFormObj(label_YN02_06_03,
					obj_YN02_06_01.rownumber);
			if (obj_YN02_06_01.value == "托管") {
				obj_YN02_06_02.readOnly = "";
				columnVallueRadio1(obj_YN02_06_03, true, 0);
			} else {
				obj_YN02_06_02.value = "";
				obj_YN02_06_03.value = "";
				obj_YN02_06_02.readOnly = "readonly";
				columnVallueRadio1(obj_YN02_06_03, false, 0);
			}
		}
	}
	

}

/*
 * 功能：通过单选来控制后面文本框和单选是否只读 配置：信息科技基础设施情况#基本情况#框架#产权形式#内容#单选
 */
function setObj_YN02_05_02_03Disable(obj) {	
	if(obj){
		var rownumber = "";
		if (obj.flag == "自有") {
			rownumber = obj.parentElement.nextSibling.nextSibling.nextSibling.rownumber;
		} else if(obj.flag == "共有"){
			rownumber = obj.parentElement.nextSibling.nextSibling.rownumber;
		}else{
			rownumber = obj.parentElement.nextSibling.rownumber;
		}
		if(rownumber){
			var obj_YN02_05_01 = getTableFormObj(label_YN02_05_01,rownumber);
			var obj_YN02_05_02_01 = getTableFormObj(label_YN02_05_02_01,
					obj_YN02_05_01.rownumber + "_1");
			var obj_YN02_05_02_02 = getTableFormObj(label_YN02_05_02_02,
					obj_YN02_05_01.rownumber + "_1");
			var obj_YN02_05_03_01 = getTableFormObj(label_YN02_05_03_01,
					obj_YN02_05_01.rownumber + "_1");
			
			if (obj_YN02_05_01.value == "自有" || obj_YN02_05_01.value == "") {
				obj_YN02_05_02_01.value = "";
				obj_YN02_05_02_02.value = "";
				obj_YN02_05_03_01.value = "";
				obj_YN02_05_02_01.readOnly = "readonly";
				obj_YN02_05_02_02.readOnly = "readonly";
				columnVallueRadio1(obj_YN02_05_03_01, false, 0);
			} else if (obj_YN02_05_01.value == "共有") {
				obj_YN02_05_02_01.readOnly = "";
				obj_YN02_05_02_02.readOnly = "readonly";
				obj_YN02_05_02_02.value = "";
//				columnVallueRadio1(obj_YN02_05_03_01, false, 0);
				columnVallueRadio1(obj_YN02_05_03_01, true, 0);
//				obj_YN02_05_03_01.value = "";
			} else if (obj_YN02_05_01.value == "他有") {
				obj_YN02_05_02_01.readOnly = "readonly";
				obj_YN02_05_02_01.value = "";
				obj_YN02_05_02_02.readOnly = "";
//				columnVallueRadio1(obj_YN02_05_03_01, false, 0);
				columnVallueRadio1(obj_YN02_05_03_01, true, 0);
//				obj_YN02_05_03_01.value = "";
			}
		}
	}else{
		var obj_YN02_05_01Arr = getTableFormObjs(label_YN02_05_01);
		for ( var i = 0; i < obj_YN02_05_01Arr.length; i++) {
			var obj_YN02_05_01 = obj_YN02_05_01Arr[i];
			var obj_YN02_05_02_01 = getTableFormObj(label_YN02_05_02_01,
					obj_YN02_05_01.rownumber + "_1");
			var obj_YN02_05_02_02 = getTableFormObj(label_YN02_05_02_02,
					obj_YN02_05_01.rownumber + "_1");
			var obj_YN02_05_03_01 = getTableFormObj(label_YN02_05_03_01,
					obj_YN02_05_01.rownumber + "_1");
			
			if (obj_YN02_05_01.value == "自有" || obj_YN02_05_01.value == "") {
				obj_YN02_05_02_01.value = "";
				obj_YN02_05_02_02.value = "";
				obj_YN02_05_03_01.value = "";
				obj_YN02_05_02_01.readOnly = "readonly";
				obj_YN02_05_02_02.readOnly = "readonly";
				columnVallueRadio1(obj_YN02_05_03_01, false, 0);
			} else if (obj_YN02_05_01.value == "共有") {
				obj_YN02_05_02_01.readOnly = "";
				obj_YN02_05_02_02.readOnly = "readonly";
				obj_YN02_05_02_02.value = "";
				columnVallueRadio1(obj_YN02_05_03_01, true, 0);
//				obj_YN02_05_03_01.value = "";
			} else if (obj_YN02_05_01.value == "他有") {
				obj_YN02_05_02_01.readOnly = "readonly";
				obj_YN02_05_02_01.value = "";
				obj_YN02_05_02_02.readOnly = "";
				columnVallueRadio1(obj_YN02_05_03_01, true, 0);
//				obj_YN02_05_03_01.value = "";
			}
		}
	}
	
	

}
/*
 * 功能：通过单选来控制后面多选框中是否可选 配置：信息科技基础设施情况#基本情况#框架#类型#选择#1#选择#单选
 */
function setObj_YN02_01_02_03Disable(obj) {
	if(obj){
		var rownumber = "";
		
		if (obj.flag == "数据中心") {
			rownumber = obj.parentElement.nextSibling.nextSibling.nextSibling.nextSibling.rownumber;
		} else {
			rownumber = obj.parentElement.nextSibling.nextSibling.rownumber;
		}
		if(rownumber){
			var obj_YN02_01_01 = getTableFormObj(label_YN02_01_01,rownumber);
			var obj_YN02_01_02 = getTableFormCheckBox(label_YN02_01_02,
					obj_YN02_01_01.rownumber + "_1");
			var obj_YN02_01_02Header = [];
			var obj_YN02_01_02Last = [];
			for(var n = 0;n<3;n++){
				obj_YN02_01_02Header.push(obj_YN02_01_02[n]);
			}
			for(var j = 3;j<6;j++){
				obj_YN02_01_02Last.push(obj_YN02_01_02[j]);
			}
			if (obj_YN02_01_01.value == "数据中心") {
				disableTableCheckBox1(obj_YN02_01_02Header, false);
				disableTableCheckBox1(obj_YN02_01_02Last, true);
			} else if (obj_YN02_01_01.value == "中心机房") {
				disableTableCheckBox1(obj_YN02_01_02Header, true);
				disableTableCheckBox1(obj_YN02_01_02Last, false);
			} else {
				disableTableCheckBox1(obj_YN02_01_02Header, true);
				disableTableCheckBox1(obj_YN02_01_02Last, true);
			}
		}
	}else{
		var obj_YN02_01_01Arr = getTableFormObjs(label_YN02_01_01);
		for ( var i = 0; i < obj_YN02_01_01Arr.length; i++) {
			var obj_YN02_01_01 = obj_YN02_01_01Arr[i];
			var obj_YN02_01_02 = getTableFormCheckBox(label_YN02_01_02,
					obj_YN02_01_01.rownumber + "_1");
			var obj_YN02_01_02Header = [];
			var obj_YN02_01_02Last = [];
			for(var n = 0;n<3;n++){
				obj_YN02_01_02Header.push(obj_YN02_01_02[n]);
			}
			for(var j = 3;j<6;j++){
				obj_YN02_01_02Last.push(obj_YN02_01_02[j]);
			}
			if (obj_YN02_01_01.value == "数据中心") {
				disableTableCheckBox1(obj_YN02_01_02Header, false);
				disableTableCheckBox1(obj_YN02_01_02Last, true);
			} else if (obj_YN02_01_01.value == "中心机房") {
				disableTableCheckBox1(obj_YN02_01_02Header, true);
				disableTableCheckBox1(obj_YN02_01_02Last, false);
			} else {
				disableTableCheckBox1(obj_YN02_01_02Header, true);
				disableTableCheckBox1(obj_YN02_01_02Last, true);
			}
		}
	}

}

/*
 * 初始化
 */
function initSet() {
	var obj = null;
	setObj_YN02_01_02_03Disable(obj);
	setObj_YN02_05_02_03Disable(obj);
	setObj_YN02_06_02_03Disable(obj);
	setObj_YN02_07_02_03_04Disable(obj);
	setObj_YN03OthersDisable(obj);
	setObj_YN03_03_06_02(obj);
	setObj_YN03_03_07_02(obj);
	setObj_YN05_02Disable(obj);
	setObj_YN09_04Disable(obj);
	setZBQKDisable();
}

function setZBQKDisable(){
	var objs = getTableFormObjs(label_YN02_01_02);
	if(objs){
		for(var i=0;i<objs.length;i++){
			if(objs[i].rownumber.indexOf("_#_") < 0){
				setTableNoRightMenu(objs[i]);
			}
		}
	}
}
/*
 * 提交校验数据
 */
function checkData() {
	// 清空错误表单的背景色
	for ( var i = 0; i < errorObjs.length; i++) {
		errorObjs[i].style.backgroundColor = "";
		errorObjs[i].parentNode.style.color = "";	
	}
	errorObjs = [];
	//增加必填校验 wangjiahui start
	//校验基础设施灾备模式
	var obj_YN01_01 = getTableFormObj(label_YN01_01,"1_1");
	if(obj_YN01_01){
		if(obj_YN01_01.value == ""){
			errorObjs.push(obj_YN01_01);
			isValid = false;
			a += "基础设施灾备模式不能为空！\n";
		}
	}
	var obj_YN02_00Arr = getTableFormObjs(label_YN02_00);
	var index = 0;
	if(obj_YN02_00Arr){
		for(var i=0;i<obj_YN02_00Arr.length;i++){
			if(obj_YN02_00Arr[i].rownumber.indexOf("_#_") >= 0){
				continue;
			}else{
				index ++;
			}
			//校验中心机房名称
			if(obj_YN02_00Arr[i].value == ""){
				errorObjs.push(obj_YN02_00Arr[i]);
				isValid = false;
				a += "数据(灾备)中心机房"+ index + "：数据（灾备）中心机房名称不能为空！\n";
			}
			//校验中心
			var obj_YN02_01_01 = getTableFormObj(label_YN02_01_01,obj_YN02_00Arr[i].rownumber + "_1_1_1_1_1_1");
			if(obj_YN02_01_01){
				if(obj_YN02_01_01.value == ""){
					errorObjs.push(obj_YN02_01_01);
					isValid = false;
					a += "数据(灾备)中心机房"+ index + "：基本情况 类型 中心不能为空！\n";
				}else{
					//校验中心性质
					var obj_YN02_01_02 = getTableFormObj(label_YN02_01_02,obj_YN02_01_01.rownumber+"_1");
					if(obj_YN02_01_02.value == ""){
						errorObjs.push(obj_YN02_01_02);
						isValid = false;
						a += "数据(灾备)中心机房"+ index +"：基本情况 类型 中心性质不能为空！\n";
					}
				}
			}
			//校验设计等级
			var obj_YN02_02 = getTableFormObj(label_YN02_02,obj_YN02_00Arr[i].rownumber + "_1_1_1");
			if(obj_YN02_02){
				if(obj_YN02_02.value == ""){
					errorObjs.push(obj_YN02_02);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +"：基本情况 设计等级不能为空！\n";
				}
			}
			//校验机房总面积
			var obj_YN02_03 = getTableFormObj(label_YN02_03,obj_YN02_00Arr[i].rownumber + "_1_1_1");
			if(obj_YN02_03){
				if(obj_YN02_03.value == ""){
					errorObjs.push(obj_YN02_03);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +"：基本情况 机房总面积不能为空！\n";
				}
			}
			//校验功能用途
			var obj_YN02_04 = getTableFormObj(label_YN02_04,obj_YN02_00Arr[i].rownumber + "_1_1_1");
			if(obj_YN02_04){
				if(obj_YN02_04.value == ""){
					errorObjs.push(obj_YN02_04);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +"：基本情况 功能用途不能为空！\n";
				}
			}
			//校验产权形式
			var obj_YN02_05_01 = getTableFormObj(label_YN02_05_01,obj_YN02_00Arr[i].rownumber + "_1_1_1_1");
			if(obj_YN02_05_01){
				if(obj_YN02_05_01.value == ""){
					errorObjs.push(obj_YN02_05_01);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +"：基本情况 产权形式不能为空！\n";
				}else{
					var obj_YN02_05_02_01 = getTableFormObj(label_YN02_05_02_01, obj_YN02_05_01.rownumber + "_1");
					var obj_YN02_05_02_02 = getTableFormObj(label_YN02_05_02_02, obj_YN02_05_01.rownumber + "_1");
					var obj_YN02_05_03_01 = getTableFormObj(label_YN02_05_03_01, obj_YN02_05_01.rownumber + "_1");
					if (obj_YN02_05_01.value == "共有") {
						if(obj_YN02_05_02_01.value == ""){
							errorObjs.push(obj_YN02_05_02_01);
							isValid = false;
							a += "数据(灾备)中心机房"+ index +": 基本情况 产权形式 共有名称不能为空！\n";
						}
						if(obj_YN02_05_03_01.value == ""){
							errorObjs.push(obj_YN02_05_03_01);
							isValid = false;
							a += "数据(灾备)中心机房"+ index +": 基本情况 产权形式 性质不能为空！\n";
						}
					} else if (obj_YN02_05_01.value == "他有") {
						if(obj_YN02_05_02_02.value == ""){
							errorObjs.push(obj_YN02_05_02_02);
							isValid = false;
							a += "数据(灾备)中心机房"+ index +": 基本情况 产权形式 出租（出借）方名称不能为空！\n";
						}
						if(obj_YN02_05_03_01.value == ""){
							errorObjs.push(obj_YN02_05_03_01);
							isValid = false;
							a += "数据(灾备)中心机房"+ index +": 基本情况 产权形式 性质不能为空！\n";
						}
					}
				}
			}
			
			//校验使用模式
			var obj_YN02_06_01 = getTableFormObj(label_YN02_06_01,obj_YN02_00Arr[i].rownumber + "_1_1_1_1");
			if(obj_YN02_06_01){
				if(obj_YN02_06_01.value == ""){
					errorObjs.push(obj_YN02_06_01);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +"：基本情况 使用模式不能为空！\n";
				}else{
					var obj_YN02_06_02 = getTableFormObj(label_YN02_06_02, obj_YN02_06_01.rownumber);
					var obj_YN02_06_03 = getTableFormObj(label_YN02_06_03, obj_YN02_06_01.rownumber);
					if (obj_YN02_06_01.value == "托管") {
						if(obj_YN02_06_02.value == ""){
							errorObjs.push(obj_YN02_06_02);
							isValid = false;
							a += "数据(灾备)中心机房"+ index +": 基本情况 使用模式 托管机构名称 不能为空！\n";
						}
						if(obj_YN02_06_03.value == ""){
							errorObjs.push(obj_YN02_06_03);
							isValid = false;
							a += "数据(灾备)中心机房"+ index +": 基本情况 使用模式 性质不能为空！\n";
						}
					} 
				}
			}
			//校验运维模式
			var obj_YN02_07_01 = getTableFormObj(label_YN02_07_01,obj_YN02_00Arr[i].rownumber + "_1_1_1_1_1");
			if(obj_YN02_07_01){
				if(obj_YN02_07_01.value == ""){
					errorObjs.push(obj_YN02_07_01);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +"：基本情况 运维模式不能为空！\n";
				}else{
					var obj_YN02_07_02 = getTableFormObj(label_YN02_07_02, obj_YN02_07_01.rownumber);
					var obj_YN02_07_03 = getTableFormObj(label_YN02_07_03, obj_YN02_07_01.rownumber);
					var obj_YN02_07_04 = getTableFormCheckBox(label_YN02_07_04, obj_YN02_07_01.rownumber);
					if (obj_YN02_07_01.value == "整体运维外包") {
						if(obj_YN02_07_02.value == ""){
							errorObjs.push(obj_YN02_07_02);
							isValid = false;
							a += "数据(灾备)中心机房"+ index +": 基本情况 运维模式 外包商名称不能为空！\n";
						}
						if(obj_YN02_07_03.value == ""){
							errorObjs.push(obj_YN02_07_03);
							isValid = false;
							a += "数据(灾备)中心机房"+ index +": 基本情况 运维模式 性质不能为空！\n";
						}
					} else if (obj_YN02_07_01.value == "部分运维外包") {
						if(obj_YN02_07_04.value == ""){
							errorObjs.push(obj_YN02_07_04);
							isValid = false;
							a += "数据(灾备)中心机房"+ index +": 基本情况 运维模式 其他服务内容不能为空！\n";
						}
					}
				}
			}
			//校验地点
			var obj_YN02_08_01 = getTableFormObj(label_YN02_08_01,obj_YN02_00Arr[i].rownumber + "_1_1_1_1");
			if(obj_YN02_08_01){
				if(obj_YN02_08_01.value == ""){
					errorObjs.push(obj_YN02_08_01);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +": 基本情况 地点 国家不能为空！\n";
				}
			}
			var obj_YN02_08_02 = getTableFormObj(label_YN02_08_02,obj_YN02_00Arr[i].rownumber + "_1_1_1_1");
			if(obj_YN02_08_02){
				if(obj_YN02_08_02.value == ""){
					errorObjs.push(obj_YN02_08_02);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +": 基本情况 地点 省(自治区、直辖市)不能为空！\n";
				}
			}
			var obj_YN02_08_03 = getTableFormObj(label_YN02_08_03,obj_YN02_00Arr[i].rownumber + "_1_1_1_1");
			if(obj_YN02_08_03){
				if(obj_YN02_08_03.value == ""){
					errorObjs.push(obj_YN02_08_03);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +": 基本情况 地点 市（县、州、盟）不能为空！\n";
				}
			}
			//校验启用日期
			var obj_YN02_09 = getTableFormObj(label_YN02_09,obj_YN02_00Arr[i].rownumber + "_1_1_1");
			if(obj_YN02_09){
				if(obj_YN02_09.value == ""){
					errorObjs.push(obj_YN02_09);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +": 基本情况 启用日期不能为空！\n";
				}
			}
			//校验供电线路
			var obj_YN03_01_01 = getTableFormObj(label_YN03_01_01,obj_YN02_00Arr[i].rownumber + "_1_1_1_1");
			if(obj_YN03_01_01){
				if(obj_YN03_01_01.value == ""){
					errorObjs.push(obj_YN03_01_01);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +": 供电 供电线路 变配电室有双路市电接入不能为空！\n";
				}
			}
			var obj_YN03_01_02 = getTableFormObj(label_YN03_01_02,obj_YN02_00Arr[i].rownumber + "_1_1_1_1");
			if(obj_YN03_01_02){
				if(obj_YN03_01_02.value == ""){
					errorObjs.push(obj_YN03_01_02);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +": 供电 供电线路 双路市电由不同变电所接入不能为空！\n";
				}
			}
			//校验供电UPS
			var obj_YN03_02_01 = getTableFormObj(label_YN03_02_01,obj_YN02_00Arr[i].rownumber + "_1_1_1_1_1");
			if(obj_YN03_02_01){
				if(obj_YN03_02_01.value == ""){
					errorObjs.push(obj_YN03_02_01);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +": 供电 UPS UPS供电模式不能为空！\n";
				}
			}
			var obj_YN03_02_02 = getTableFormObj(label_YN03_02_02,obj_YN02_00Arr[i].rownumber + "_1_1_1_1_1");
			if(obj_YN03_02_02){
				if(obj_YN03_02_02.value == ""){
					errorObjs.push(obj_YN03_02_02);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +": 供电 UPS 系统设计容量不能为空！\n";
				}
			}
			var obj_YN03_02_03 = getTableFormObj(label_YN03_02_03,obj_YN02_00Arr[i].rownumber + "_1_1_1_1_1");
			if(obj_YN03_02_03){
				if(obj_YN03_02_03.value == ""){
					errorObjs.push(obj_YN03_02_03);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +": 供电 UPS 实际负载峰值不能为空！\n";
				}
			}
			var obj_YN03_02_04 = getTableFormObj(label_YN03_02_04,obj_YN02_00Arr[i].rownumber + "_1_1_1_1_1");
			if(obj_YN03_02_04){
				if(obj_YN03_02_04.value == ""){
					errorObjs.push(obj_YN03_02_04);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +": 供电 UPS 满载电池可用时间不能为空！\n";
				}
			}
			var obj_YN03_02_05 = getTableFormObj(label_YN03_02_05,obj_YN02_00Arr[i].rownumber + "_1_1_1_1_1");
			if(obj_YN03_02_05){
				if(obj_YN03_02_05.value == ""){
					errorObjs.push(obj_YN03_02_05);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +": 供电 UPS UPS主机中最长使用年份不能为空！\n";
				}
			}
			var obj_YN03_02_06 = getTableFormObj(label_YN03_02_06,obj_YN02_00Arr[i].rownumber + "_1_1_1_1_1");
			if(obj_YN03_02_06){
				if(obj_YN03_02_06.value == ""){
					errorObjs.push(obj_YN03_02_06);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +": 供电 UPS UPS电池中最长使用年份不能为空！\n";
				}
			}
			//校验供电发电机
			var obj_YN03_03_01 = getTableFormObj(label_YN03_03_01,obj_YN02_00Arr[i].rownumber + "_1_1_1_1_1");
			var obj_YN03_03_02 = getTableFormObj(label_YN03_03_02, obj_YN03_03_01.rownumber);
			var obj_YN03_03_03 = getTableFormObj(label_YN03_03_03, obj_YN03_03_01.rownumber);
			var obj_YN03_03_04 = getTableFormObj(label_YN03_03_04, obj_YN03_03_01.rownumber);
			var obj_YN03_03_05 = getTableFormObj(label_YN03_03_05, obj_YN03_03_01.rownumber);
			var obj_YN03_03_06_01 = getTableFormObj(label_YN03_03_06_01, obj_YN03_03_01.rownumber);
			var obj_YN03_03_07_01 = getTableFormObj(label_YN03_03_07_01, obj_YN03_03_01.rownumber);
			 if (obj_YN03_03_01.value == "是") {
				if(obj_YN03_03_02.value == ""){
					errorObjs.push(obj_YN03_03_02);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +": 供电 发电机 额定功率不能为空！\n";
				}
				if(obj_YN03_03_03.value == ""){
					errorObjs.push(obj_YN03_03_03);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +": 供电 发电机 自动启动不能为空！\n";
				}
				if(obj_YN03_03_04.value == ""){
					errorObjs.push(obj_YN03_03_04);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +": 供电 发电机 启动时间不能为空！\n";
				}
				if(obj_YN03_03_05.value == ""){
					errorObjs.push(obj_YN03_03_05);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +": 供电 发电机 本地油料储备可用时间不能为空！\n";
				}
				if(obj_YN03_03_06_01.value == ""){
					errorObjs.push(obj_YN03_03_06_01);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +": 供电 发电机 运维单位不能为空！\n";
				}
				if(obj_YN03_03_07_01.value == ""){
					errorObjs.push(obj_YN03_03_07_01);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +": 供电 发电机 是否租用不能为空！\n";
				}
				var obj_YN03_03_06_02 = getTableFormObj(label_YN03_03_06_02, obj_YN03_03_06_01.rownumber);
				if (obj_YN03_03_06_01.value == "外部机构" && obj_YN03_03_06_02.value == "") {
					errorObjs.push(obj_YN03_03_06_02);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +": 供电 发电机 运维单位外部机构名称不能为空！\n";
				}
				
				var obj_YN03_03_07_02 = getTableFormObj(label_YN03_03_07_02, obj_YN03_03_07_01.rownumber);
				if (obj_YN03_03_07_01.value == "是" && obj_YN03_03_07_02.value == "") {
					errorObjs.push(obj_YN03_03_07_02);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +": 供电 发电机 出租方名称不能为空！\n";
				}
			}
			//校验门禁与监控
			var obj_YN04_01_02 = getTableFormObj(label_YN04_01_02,obj_YN02_00Arr[i].rownumber + "_1_1_1_1");
			if(obj_YN04_01_02){
				if(obj_YN04_01_02.value == ""){
					errorObjs.push(obj_YN04_01_02);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +": 门禁与监控 门禁 门禁记录保存时间不能为空！\n";
				}
			}
			var obj_YN04_01_03 = getTableFormObj(label_YN04_01_03,obj_YN02_00Arr[i].rownumber + "_1_1_1_1");
			if(obj_YN04_01_03){
				if(obj_YN04_01_03.value == ""){
					errorObjs.push(obj_YN04_01_03);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +": 门禁与监控 门禁 是否采用国外设备不能为空！\n";
				}
			}
			var obj_YN04_02_02 = getTableFormObj(label_YN04_02_02,obj_YN02_00Arr[i].rownumber + "_1_1_1_1");
			if(obj_YN04_02_02){
				if(obj_YN04_02_02.value == ""){
					errorObjs.push(obj_YN04_02_02);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +": 门禁与监控 环境监控 监控记录保存时间不能为空！\n";
				}
			}
			
			//校验电磁屏蔽
			var obj_YN05_01 = getTableFormObj(label_YN05_01,obj_YN02_00Arr[i].rownumber + "_1_1_1");
			if(obj_YN05_01){
				if(obj_YN05_01.value == ""){
					errorObjs.push(obj_YN05_01);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +": 电磁屏蔽 是否全屏蔽不能为空！\n";
				}else if(obj_YN05_01.value == "是"){
					var obj_YN05_02 = getTableFormObj(label_YN05_02, obj_YN05_01.rownumber);
					if(obj_YN05_02 && obj_YN05_02.value == ""){
						errorObjs.push(obj_YN05_02);
						isValid = false;
						a += "数据(灾备)中心机房"+ index +": 电磁屏蔽 全屏蔽 电磁屏蔽区域不能为空！\n";
					}
				}
			}
			//校验防雷设施
			var obj_YN06 = getTableFormObj(label_YN06,obj_YN02_00Arr[i].rownumber + "_1_1_1");
			if(obj_YN06){
				if(obj_YN06.value == ""){
					errorObjs.push(obj_YN06);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +": 防雷设施 是否具备不能为空！\n";
				}
			}
			//校验防水
			var obj_YN07 = getTableFormObj(label_YN07,obj_YN02_00Arr[i].rownumber + "_1_1");
			if(obj_YN07){
				if(obj_YN07.value == ""){
					errorObjs.push(obj_YN07);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +": 防水 是否具备不能为空！\n";
				}
			}
			
			//校验空调
			var obj_YN08_01 = getTableFormObj(label_YN08_01,obj_YN02_00Arr[i].rownumber + "_1_1");
			if(obj_YN08_01){
				if(obj_YN08_01.value == ""){
					errorObjs.push(obj_YN08_01);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +": 空调 设计单位面积制冷量不能为空！\n";
				}
			}
			//校验消防
			var obj_YN09_01 = getTableFormObj(label_YN09_01,obj_YN02_00Arr[i].rownumber + "_1_1");
			if(obj_YN09_01){
				if(obj_YN09_01.value == ""){
					errorObjs.push(obj_YN09_01);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +": 消防 灭火方式不能为空！\n";
				}
			}
			var obj_YN09_02 = getTableFormObj(label_YN09_02,obj_YN02_00Arr[i].rownumber + "_1_1");
			if(obj_YN09_02){
				if(obj_YN09_02.value == ""){
					errorObjs.push(obj_YN09_02);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +": 消防 灭火剂类型不能为空！\n";
				}
			}
			var obj_YN09_03 = getTableFormObj(label_YN09_03,obj_YN02_00Arr[i].rownumber + "_1_1");
			if(obj_YN09_03){
				if(obj_YN09_03.value == ""){
					errorObjs.push(obj_YN09_03);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +": 消防 本年度是否由专业机构或部门对消防设备进行检测不能为空！\n";
				}else{
					var obj_YN09_04 = getTableFormObj(label_YN09_04, obj_YN09_03.rownumber);
					if (obj_YN09_03.value == "是" && obj_YN09_04.value == "") {
						errorObjs.push(obj_YN09_04);
						isValid = false;
						a += "数据(灾备)中心机房"+ index +": 消防 本年度是否有专业机构或部门对消防设备进行检测 检测时间不能为空！\n";
					}
				}
			}
			//校验巡检
			var obj_YN10 = getTableFormObj(label_YN10,obj_YN02_00Arr[i].rownumber + "_1_1");
			if(obj_YN10){
				if(obj_YN10.value == ""){
					errorObjs.push(obj_YN10);
					isValid = false;
					a += "数据(灾备)中心机房"+ index +": 巡检  巡检频度不能为空！\n";
				}
			}
			//灾备具体情况
			
			var obj_YN02_01_02 = getTableFormObj(label_YN02_01_02,obj_YN02_00Arr[i].rownumber + "_1_1_1_1_1_1_1");
			if(checkBoxValues(obj_YN02_01_02)){
				var obj_YN11_01Arr = getTableFormObjs(label_YN11_01);
				for(var index = 0;index<obj_YN11_01Arr.length;index++){
					var obj_YN11_01 = obj_YN11_01Arr[index];
					var rownumber = obj_YN11_01.rownumber.substring(0,1);
					if((index+1).toString() == rownumber){
						var obj_YN11_02 = getTableFormObj(label_YN11_02,obj_YN11_01.rownumber);
						var obj_YN11_03 = getTableFormObj(label_YN11_03,obj_YN11_01.rownumber);
						if(obj_YN11_01.value == ""){
							errorObjs.push(obj_YN11_01);
							isValid = false;
							a += "数据(灾备)中心机房"+(parseInt(i)+1)+": 10 灾备具体情况 备份生产中心名称不能为空！(表"+(parseInt(i)+1)+")\n";
						}
						if(obj_YN11_02.value == ""){
							errorObjs.push(obj_YN11_02);
							isValid = false;
							a += "数据(灾备)中心机房"+(parseInt(i)+1)+": 10 灾备具体情况 区域不能为空！(表"+(parseInt(i)+1)+")\n";
						}
						if(obj_YN11_03.value == ""){
							errorObjs.push(obj_YN11_03);
							isValid = false;
							a += "数据(灾备)中心机房"+(parseInt(i)+1)+": 10 灾备具体情况 与生产中心距离不能为空！(表"+(parseInt(i)+1)+")\n";
						}
					}
					
					
				}

			}
		}
	}
	//增加必填校验 wangjiahui end
	
	//校验复选中其他是否有值
	for(var i = 0;i<checkBoxValueObjs.length;i++){
		var checkBoxObj = checkBoxValueObjs[i];
		if(checkBoxObj.checked){
			var checkBoxObjValueObj= checkBoxObj.parentElement.nextSibling.nextSibling;
			if(checkBoxObjValueObj.value.indexOf("_cev_")<0){
				errorObjs.push(checkBoxObjValueObj.previousSibling);
				a+="其他项内容不能为空！\n";
				isValid=false;
			}
		}
	}
	if (!isValid && a > "") {
		for ( var i = 0; i < errorObjs.length; i++) {
			if (errorObjs[i].previousSibling == null ) {
				errorObjs[i].style.backgroundColor = "red";
			}else if(errorObjs[i].previousSibling.innerHTML.indexOf("其他")>-1){
				errorObjs[i].style.backgroundColor = "red";
			} else {
				errorObjs[i].parentNode.style.color = "red";
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
 * 功能：输入年份是否正确
 */ 
function checkYear(obj){
	if(obj.value.length != 4){
		obj.value = "";
		alert("输入年份不对，请重新输入（例如：2012）！");
	}
}
/*
 * 功能：输入年份是否正确
 */
function checkValueAbs(obj){
	if(parseFloat(obj.value)<0){
		obj.value = "";
		alert("输入的数值不能小于0，请重新输入！");
	}
}

/*
 * 功能：恢复日期输入
 */
var click_columnshowDate = function() {
	showDate(this);
};

/*
 * 功能：单选按钮的读写设置 参数：obj为单选对象 access当单选可被选时传true，不可被选时传false flag 为是否添加特殊函数调用
 */
function columnVallueRadio1(obj, access, flag) {
	if (!access) {
		obj.value = "";
	}
	var objs = obj.parentElement.childNodes;
	if (objs != null) {
		for ( var i = 0; i < objs.length; i++) {
			var imgs = objs[i].childNodes;
			for ( var k = 0; k < imgs.length; k++) {
				if (imgs[k].name == "radioImg") {
					if (!access) {
						imgs[k].src = "images/rb01.gif";
						imgs[k].onclick = "";
					} else {
						if (flag == 0) {
							imgs[k].onclick = function() {
								columnVallueRadio(this);
							};
						} else if (flag == 1) {
							imgs[k].onclick = function() {
								columnVallueRadio(this);
								setObj_YN03_03_06_02(this);
							};
						} else if (flag == 2) {
							imgs[k].onclick = function() {
								columnVallueRadio(this);
								setObj_YN03_03_07_02(this);
							};
						}
					}
				}
			}
		}
	}
}
/*
 * 功能：通过查找基本情况类型的值来决定灾备具体情况（仅在中心类型包含灾备中心或承担灾备功能时填写）是否可写以及能不能够添加
 * 参数：将基本情况类型的复选框对象传入方法中
 */
function checkBoxValues(checkBox1){
	if(checkBox1.value.indexOf("同城")>-1){
		return true;
	}
	if(checkBox1.value.indexOf("异地")>-1){
		return true;
	}
	return false;
}
/*
 * 功能：点击基本类型来决定灾备具体情况（仅在中心类型包含灾备中心或承担灾备功能时填写）是否可写以及能不能够添加
 */
function setAddImgClickDisable(obj) {
	if(obj){
		var target = getTarget(obj.parentElement);
		setTableNoRightMenu(target);
	}
}

function setTableNoRightMenu(target){
	if(target){
		var tb = getTableFormObj(label_YN11_01,target.rownumber.split("_")[0] + "_1_1").parentElement.parentElement.parentElement;
		var obj_YN11_01 = getTableFormObj(label_YN11_01,target.rownumber.split("_")[0] + "_1_1");
		var obj_YN11_02 = getTableFormObj(label_YN11_02,target.rownumber.split("_")[0] + "_1_1");
		var obj_YN11_03 = getTableFormObj(label_YN11_03,target.rownumber.split("_")[0] + "_1_1");
		var obj_YN11_04 = getTableFormObj(label_YN11_04,target.rownumber.split("_")[0] + "_1_1");
		if(!checkBoxValues(target)){
			if(tb.rows.length > 1){
				tb.rows[1].className = "";
				jQuery(tb.rows[1]).unbind("mousedown");
				var len = tb.rows.length;
				for(var i=2;i<len;i++){
					deleteRow(tb.rows[2]);
				}
			}
			obj_YN11_01.readOnly = "readonly";
			columnVallueRadio1(obj_YN11_02, false, 0);
			obj_YN11_03.readOnly = "readonly";
			obj_YN11_04.readOnly = "readonly";
			obj_YN11_01.value = "";
			obj_YN11_03.value = "";
			obj_YN11_04.value = "";
		}else{
			if(tb.rows.length > 1){
				tb.rows[1].className = "rightMenu";
				jQuery(tb.rows[1]).unbind("mousedown").mousedown(function(event){
					event.stopPropagation();
					rightMenu(this,event);
				}) ;
			}
			obj_YN11_01.readOnly = "";
			columnVallueRadio1(obj_YN11_02, true, 0);
			obj_YN11_03.readOnly = "";
			obj_YN11_04.readOnly = "";
		}
	}
}

/*
* 功能：点击复选框复选框中的其他，将起放入数组中，在提交的时候校验其他的内容是否为空 
* 
*/
var checkBoxValueObjs = [];
function showOrHiddenTableColumnCheckBoxElse(obj){
	var target = getTarget(obj.parentElement);
	var showTarget = getShowTarget(obj.parentElement);
	if(obj.checked){
		showTarget.style.display = "";
		checkBoxValueObjs.push(obj);
	}else{
		showTarget.value = "";
		showTarget.style.display = "none";
		var checkBoxValue = target.value;
		var strs = checkBoxValue.split("#");
		var valueStr = "";
		for(var i=0;i<strs.length;i++){
			if(strs[i].indexOf("_cev_") < 0){
				valueStr += strs[i] + "#";
			}
		}
		target.value = valueStr.substring(0, valueStr.length - 1);
		
	}
}

function disableTableCheckBox1(objs,flag){
	if(objs != null && objs.length > 0){
		for(var i=0;i<objs.length;i++){
			objs[i].disabled = flag;
			if(flag){
				objs[i].checked = false;
				getTarget(objs[i].parentElement).value = getTarget(objs[i].parentElement).value.replace(objs[i].value,"");
				//清空“其他”并设置为只读
				var showvalue = getShowTarget(objs[i].parentElement);
				if(showvalue!=null){
					showvalue.value = "";
					showvalue.style.display="none";
				}
			}
		}
	}
}

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
	setZBQKDisable();
//	//行号
//	var rowIndex = obj.rowIndex;
//	tb.deleteRow(rowIndex); 
	
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
	setZBQKDisable();
	return tr;
}