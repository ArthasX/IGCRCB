/*
 * ����2014 -T-B-9 ��Ϣϵͳ��Ӳ����Ʒʹ��������������
 */
//У�鰴ť
var isValid = true;
var a = "";
var errorObjs = [];
// �����Ʒʹ�����,������滯���
var label_YN01_01_01 = "�����Ʒʹ�����������滯���#����#������滯����#������滯����������";
var label_YN01_01_02 = "�����Ʒʹ�����������滯���#����#������滯����#��������";

var label_YN01_02_01 = "�����Ʒʹ�����������滯���#����#������滯����������#������滯����������";
var label_YN01_02_02 = "�����Ʒʹ�����������滯���#����#������滯����������#����";
var label_YN01_02_03 = "�����Ʒʹ�����������滯���#����#������滯����������#ְ��";

var label_YN01_03_01 = "�����Ʒʹ�����������滯���#����#����������滯�йع����ƶ�#����������滯�йع����ƶ�";
var label_YN01_03_02 = "�����Ʒʹ�����������滯���#����#����������滯�йع����ƶ�#�ƶ�����";
var label_YN01_03_03 = "�����Ʒʹ�����������滯���#����#����������滯�йع����ƶ�#����ʱ��";
var label_YN01_03_04 = "�����Ʒʹ�����������滯���#����#����������滯�йع����ƶ�#���һ���޶�ʱ��";
//��Ϣϵͳ��Ӳ������֧���������
var label_YN04_01 = "��Ϣϵͳ��Ӳ������֧�����#����#��������ʹ�ù�Ӧ����ֹ֧ͣ�ֵ������Ӳ��ƽ̨����Ҫ��Ϣϵͳ";
var label_YN04_02 = "��Ϣϵͳ��Ӳ������֧�����#����#���ǣ�����";
var label_YN04_03 = "��Ϣϵͳ��Ӳ������֧�����#����#����ϵͳ����";
var label_YN04_04 = "��Ϣϵͳ��Ӳ������֧�����#����#������ֹ֧ͣ�ֵ�Ӳ��ƽ̨����";
var label_YN04_05 = "��Ϣϵͳ��Ӳ������֧�����#����#��ֹ֧ͣ�ֵ����ƽ̨����";

// �����Ʒʹ�����,������滯�������
var obj_YN01_01_01 = getTableFormObjs(label_YN01_01_01)[0];
var obj_YN01_01_02 = getTableFormObj(label_YN01_01_02, obj_YN01_01_01.rownumber);

var obj_YN01_02_01 = getTableFormObjs(label_YN01_02_01)[0];
var obj_YN01_02_02 = getTableFormObj(label_YN01_02_02, obj_YN01_02_01.rownumber);
var obj_YN01_02_03 = getTableFormObj(label_YN01_02_03, obj_YN01_02_01.rownumber);

var obj_YN01_03_01 = getTableFormObjs(label_YN01_03_01)[0];
var obj_YN01_03_02 = getTableFormObj(label_YN01_03_02, obj_YN01_03_01.rownumber);
var obj_YN01_03_03 = getTableFormObj(label_YN01_03_03, obj_YN01_03_01.rownumber);
var obj_YN01_03_04 = getTableFormObj(label_YN01_03_04, obj_YN01_03_01.rownumber);

//��Ϣϵͳ��Ӳ������֧���������
var ojb_YN04_01 = getTableFormObjs(label_YN04_01)[0];
var ojb_YN04_02 = getTableFormObj(label_YN04_02, ojb_YN04_01.rownumber);
var ojb_YN04_03 = getTableFormObj(label_YN04_03, ojb_YN04_01.rownumber);
var ojb_YN04_04 = getTableFormObj(label_YN04_04, ojb_YN04_01.rownumber);
var ojb_YN04_05 = getTableFormObj(label_YN04_05, ojb_YN04_01.rownumber);

/*
 * ���ܣ���������ʹ�ù�Ӧ����ֹ֧ͣ�ֵ������Ӳ��ƽ̨����Ҫ��Ϣϵͳ�е�ֵ��ȷ���������Ƿ�����
 * ���ã����Ĳ���#����#��������ʹ�ù�Ӧ����ֹ֧ͣ�ֵ������Ӳ��ƽ̨����Ҫ��Ϣϵͳ
 */
function setObj_YN04_02_03_04_05Disable(obj){
	if(ojb_YN04_01){
		if(ojb_YN04_01.value == "��"){
			ojb_YN04_02.readOnly = "";
			ojb_YN04_03.readOnly = "";
			ojb_YN04_04.readOnly = "";
			ojb_YN04_05.readOnly = "";
		}else{
			ojb_YN04_02.readOnly = "readonly";
			ojb_YN04_03.readOnly = "readonly";
			ojb_YN04_04.readOnly = "readonly";
			ojb_YN04_05.readOnly = "readonly";
			
			ojb_YN04_02.value = "";
			ojb_YN04_03.value = "";
			ojb_YN04_04.value = "";
			ojb_YN04_05.value = "";
		}
	}
	
}





/*
 * ���ܣ�У�������ı���֮���ֵ
 */
function checkInputsNumber(obj){
	var inputId1 = obj.id.substring(0,obj.id.indexOf("_"));
	if(inputId1%2 == 0){
		var input2 = document.getElementById((parseInt(inputId1)-1)+"_"+obj.rownumber);
		if(input2.value!=""&&obj.value!=""){
			if(parseInt(input2.value)<parseInt(obj.value)){
				obj.value ="";
				alert("����ʹ��ʱ�䳬��5����������ܴ�������");
			}
		}
		
	}else{
		var input2 = document.getElementById((parseInt(inputId1)+1)+"_"+obj.rownumber);
		if(input2.value!=""&&obj.value!=""){
			if(parseInt(input2.value)>parseInt(obj.value)){
				input2.value ="";
				alert("����ʹ��ʱ�䳬��5����������ܴ�������");
			}
		}
	}
}

/*
 * ���ܣ��ڶ����ֵ�ѡ������ı��Ƿ���ֵ
 */
function setNumberInputDisable(obj) {
	if(obj){
		if (obj.flag == "�������������") {
			var getObj = obj.parentElement.nextSibling.nextSibling.nextSibling.nextSibling;
			if (!getObj.id) {
				getObj = obj.parentElement.nextSibling.nextSibling;
			}
			var objId = getObj.id;
			var objLastId = getObj.rownumber;
			var nextInputId = (parseInt(objId.substring(0, objId.indexOf("_"))) + 1)
					+ "_" + objLastId;
			var nextInputObj = document.getElementById(nextInputId);
			nextInputObj.readOnly = "readonly";
			nextInputObj.value = "";
		} else if(obj!="0"){
			var getObj = obj.parentElement.nextSibling.nextSibling;
			if (!getObj.id) {
				getObj = obj.parentElement.nextSibling;
			}
			var objId = getObj.id;
			var objLastId = getObj.rownumber;
			var nextInputId = (parseInt(objId.substring(0, objId.indexOf("_"))) + 1)
					+ "_" + objLastId;
			var nextInputObj = document.getElementById(nextInputId);
			nextInputObj.readOnly = "";
		}
	}
	

}

/*
 * ���ܣ�У���Ƿ�Ϊ������Ϊ���������Ϊ����
 */
function checkDataAbs(obj) {
	if (parseFloat(obj.value) < 0) {
		obj.value = "";
		alert("��������С��0�����֣����������룡");
	}
}

/*
 * ���ܣ�ͨ��������滯���������˿�������ְ���ֻ���Ϳ�д ���ã�������滯���#����#������滯����������#������滯����������
 */
function setObj_YN01_03_02_03_04Disable(obj) {
	if(obj_YN01_03_01){
		if (obj_YN01_03_01.value == "��") {
			obj_YN01_03_02.readOnly = "";
			obj_YN01_03_03.onclick = click_columnshowDate;
			obj_YN01_03_04.onclick = click_columnshowDate;
		} else {
			obj_YN01_03_02.readOnly = "readonly";
			obj_YN01_03_03.onclick = "";
			obj_YN01_03_04.onclick = "";
			obj_YN01_03_02.value = "";
			obj_YN01_03_03.value = "";
			obj_YN01_03_04.value = "";
		}
	}
	
}

/*
 * ���ܣ�ͨ��������滯���������˿�������ְ���ֻ���Ϳ�д ���ã�������滯���#����#������滯����������#������滯����������
 */
function setObj_YN01_02_02_03Disable(obj) {
	if(obj_YN01_02_01){
		if (obj_YN01_02_01.value == "��") {
			obj_YN01_02_02.readOnly = "";
			obj_YN01_02_03.readOnly = "";
		} else {
			obj_YN01_02_02.readOnly = "readonly";
			obj_YN01_02_03.readOnly = "readonly";

			obj_YN01_02_02.value = "";
			obj_YN01_02_03.value = "";
		}
	}
	
}

/*
 * ���ܣ�ͨ��������滯���������ſ��Ʋ������Ƶ�ֻ���Ϳ�д ���ã�������滯���#����#������滯����#������滯����������
 */
function setObj_YN01_01_02Disable(obj) {
	if(obj_YN01_01_01){
		if (obj_YN01_01_01.value == "��") {
			obj_YN01_01_02.readOnly = "";
		} else {
			obj_YN01_01_02.readOnly = "readonly";
			obj_YN01_01_02.value = "";
		}
	}
	
}

/*
 * ��ʼ��
 */
function initSet() {
	var obj = 0;
	setObj_YN04_02_03_04_05Disable(obj);
	setNumberInputDisable(obj);
	setObj_YN01_03_02_03_04Disable(obj);
	setObj_YN01_02_02_03Disable(obj);
	setObj_YN01_01_02Disable(obj);

}
/*
 * ���ܣ��ָ���������
 */
var click_columnshowDate = function() {
	showDate(this);
};
/*
 * ���ܣ���ѡ��ť�Ķ�д���� ������objΪ��ѡ���� access����ѡ�ɱ�ѡʱ��true�����ɱ�ѡʱ��false flag Ϊ�Ƿ�������⺯������
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
						if (!flag) {
							imgs[k].onclick = function() {
								columnVallueRadio(this);
							};
						} else {
							imgs[k].onclick = function() {
								columnVallueRadio(this);
								setYN10_05Disable(this);
							};
						}
					}
				}
			}
		}
	}
}
function checkData() {
	// ��մ�����ı���ɫ
	for ( var i = 0; i < errorObjs.length; i++) {
		errorObjs[i].style.backgroundColor = "";
		errorObjs[i].parentNode.style.color = "";
	}
	errorObjs = [];
	if(obj_YN01_01_01.value =="��" && obj_YN01_01_02.value == ""){
		isValid = false;
		errorObjs.push(obj_YN01_01_02);
		a += "������滯�����������滯�������� �������Ʋ���Ϊ�գ�\n";
	}
	
	if(obj_YN01_02_01.value =="��" && obj_YN01_02_02.value == ""){
		isValid = false;
		errorObjs.push(obj_YN01_02_02);
		a += "������滯�����������滯���������� ��������Ϊ�գ�\n";
	}
	if(obj_YN01_02_01.value =="��" && obj_YN01_02_03.value == ""){
		isValid = false;
		errorObjs.push(obj_YN01_02_03);
		a += "������滯�����������滯���������� ְ����Ϊ�գ�\n";
	}
	
	if(obj_YN01_03_01.value =="��" && obj_YN01_03_02.value == ""){
		isValid = false;
		errorObjs.push(obj_YN01_03_02);
		a += "������滯���������������滯�йع����ƶ� �ƶ����Ʋ���Ϊ�գ�\n";
	}
	if(obj_YN01_03_01.value =="��" && obj_YN01_03_03.value == ""){
		isValid = false;
		errorObjs.push(obj_YN01_03_03);
		a += "������滯���������������滯�йع����ƶ� ����ʱ�䲻��Ϊ�գ�\n";
	}
	if(obj_YN01_03_01.value =="��" && obj_YN01_03_04.value == ""){
		isValid = false;
		errorObjs.push(obj_YN01_03_04);
		a += "������滯�����ʵʩ����ʲ�������Ϊ�գ�\n";
	}
	
	if(ojb_YN04_01.value =="��" && ojb_YN04_02.value == ""){
		isValid = false;
		errorObjs.push(ojb_YN04_02);
		a += "��Ϣϵͳ��Ӳ������֧���������������ʹ�ù�Ӧ����ֹ֧ͣ�ֵ������Ӳ��ƽ̨����Ҫ��Ϣϵͳ ��������Ϊ�գ�\n";
	}
	if(ojb_YN04_01.value =="��" && ojb_YN04_03.value == ""){
		isValid = false;
		errorObjs.push(ojb_YN04_03);
		a += "��Ϣϵͳ��Ӳ������֧���������������ʹ�ù�Ӧ����ֹ֧ͣ�ֵ������Ӳ��ƽ̨����Ҫ��Ϣϵͳ ����ϵͳ���Ʋ���Ϊ�գ�\n";
	}
	if(ojb_YN04_01.value =="��" && ojb_YN04_04.value == ""){
		isValid = false;
		errorObjs.push(ojb_YN04_04);
		a += "��Ϣϵͳ��Ӳ������֧���������������ʹ�ù�Ӧ����ֹ֧ͣ�ֵ������Ӳ��ƽ̨����Ҫ��Ϣϵͳ ��ֹ֧ͣ�ֵ�Ӳ��ƽ̨��������Ϊ�գ�\n";
	}
	if(ojb_YN04_01.value =="��" && ojb_YN04_05.value == ""){
		isValid = false;
		errorObjs.push(ojb_YN04_05);
		a += "��Ϣϵͳ��Ӳ������֧���������������ʹ�ù�Ӧ����ֹ֧ͣ�ֵ������Ӳ��ƽ̨����Ҫ��Ϣϵͳ ��ֹ֧ͣ�ֵ����ƽ̨��������Ϊ�գ�\n";
	}
	
	//ȡԪ�ص�ֵΪ�������������
	var inputArr = jQuery("input[name='column_value']");
	var inputArr1 = [];
	for(var i = 0;i<inputArr.length;i++){
	   if(inputArr[i].value == "�������������"){
		inputArr1.push(inputArr[i]);
		}
	}
	for(var i = 0;i<inputArr1.length;i++){
		var permitObj = inputArr1[i];
		var permitNumberObjId =  (parseInt(permitObj.id.substring(0,permitObj.id.indexOf("_")))+1)+"_"+permitObj.rownumber;
		var permitNumberObj = document.getElementById(permitNumberObjId);
		if(permitNumberObj.value == ""){
//			var softNameObjId = (parseInt(permitNumberObj.id.substring(0,permitNumberObj.id.indexOf("_")))+2)+"_"+permitNumberObj.rownumber;
//			var softName = document.getElementById(softNameObjId).value;
			isValid = false;
			errorObjs.push(permitNumberObj);
			a +=  " ������� �����������������Ϊ�գ�\n";
		}
	}
	//У�鸴ѡ�������Ƿ���ֵ
	for(var i = 0;i<checkBoxValueObjs.length;i++){
		var checkBoxObj = checkBoxValueObjs[i];
		if(checkBoxObj.checked){
			var checkBoxObjValueObj= checkBoxObj.parentElement.nextSibling.nextSibling;
			if(checkBoxObjValueObj.value.indexOf("_cev_")<0){
				errorObjs.push(checkBoxObjValueObj.previousSibling);
				a+="���������ݲ���Ϊ�գ�\n";
				isValid=false;
			}
		}
	}
	if (!isValid && a > "") {
		for ( var i = 0; i < errorObjs.length; i++) {
			if (errorObjs[i].previousSibling == null ) {
				errorObjs[i].style.backgroundColor = "red";
			}else if(errorObjs[i].previousSibling.innerHTML.indexOf("����")>-1){
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
/**
 * 
 * ��ά��ģʽ�����
 * 
 * @param obj
 *            �¼�Դ����
 * @param insertRowNum
 *            ����е�λ��
 */
//��಻�ܶ�������
function addRow(obj, insertRowNum) {
	// ��Ҫ����е�table����
	var targetTab = obj.parentElement.parentElement;
	// ģ�����
	var templateTab = document.getElementById(targetTab.id + "_template");
	// �Ƿ���ʾ�к� Y ��ʾ�� N ����ʾ
	var showrownum = targetTab.showrownum;
	var rows = 0;
	if (targetTab.rows[0].name == "titletr") {
		rows = targetTab.rows.length - 3;
	} else {
		rows = targetTab.rows.length - 2;
	}
	if(rows<1){
		//��Ҫ����е�table����
		var targetTab = obj.parentElement.parentElement;
		//ģ�����
		var templateTab = document.getElementById(targetTab.id + "_template");
		//�Ƿ���ʾ�к� Y ��ʾ�� N ����ʾ
		var showrownum = targetTab.showrownum;
		//����ģ����󣬽���������ӵ���ǰtable������
		var tr = null;
		for(var i=0;i<templateTab.rows.length;i++){
			//��Ҫ��ӵ��ж���
			//�ж��Ƿ�ָ�����е����λ�ã����ָ������ָ��λ����ӣ����δָ����Ĭ����ӵ����һ��
			if(insertRowNum != null){
				tr = targetTab.insertRow(insertRowNum);
			}else{
				tr = targetTab.insertRow(targetTab.rows.length);
			}
			//�趨���е��Ҽ��˵�
			tr.className = "rightMenu";
			tr.oncontextmenu = function(){return false;};
			jQuery(tr).unbind("mousedown").mousedown(function(event){
				event.stopPropagation();
				rightMenu(this,event);
			});
			//�����ʾ�кţ�Ԥ���к���ʾλ��
			if("Y" == showrownum){
				var indexCell2 = tr.insertCell(0);
				indexCell2.align = "center";
			}
			//����ģ���У�������ӵ���ǰ������
			for(var j=0;j<templateTab.rows[i].cells.length;j++){
				var td = tr.insertCell();
				if( templateTab.rows[i].cells[j].style.textAlign){
					td.style.textAlign =  templateTab.rows[i].cells[j].style.textAlign;
				}
				td.innerHTML = templateTab.rows[i].cells[j].innerHTML;
			}
			//����к��к��п��ܱ����ң���Ҫ���������к�
			shortRowNum(targetTab);
			var onAdd = targetTab.onAdd;
			if(onAdd){
				onAdd(tr);
			}
		}
		
		return tr;
//		// ����ģ����󣬽���������ӵ���ǰtable������
//		for ( var i = 0; i < templateTab.rows.length; i++) {
//			// ��Ҫ��ӵ��ж���
//			var tr = null;
//			// �ж��Ƿ�ָ�����е����λ�ã����ָ������ָ��λ����ӣ����δָ����Ĭ����ӵ����һ��
//			if (insertRowNum != null) {
//				tr = targetTab.insertRow(insertRowNum);
//			} else {
//				tr = targetTab.insertRow(targetTab.rows.length - 1);
//			}
//			var delTd = tr.insertCell(0);
//			delTd.align = "center";
//			delTd.innerHTML = '<img src="images/bullet_delete.png" onclick="deleteRow(this);" style="cursor: hand" border="0" />';
//			var idxFlag = 1;
//			// �����ʾ�кţ�Ԥ���к���ʾλ��
//			if ("Y" == showrownum) {
//				idxFlag = 2;
//				var indexCell2 = tr.insertCell(1);
//				indexCell2.align = "center";
//				if (targetTab.rows[0].name == "titlerow") {
//					indexCell2.innerHTML = targetTab.rows.length - 3;
//				} else {
//					indexCell2.innerHTML = targetTab.rows.length - 2;
//				}
//			}
//			// ����ģ���У�������ӵ���ǰ������
//			for ( var j = 0; j < templateTab.rows[i].cells.length; j++) {
//				var td = tr.insertCell(j + idxFlag);
//				if (templateTab.rows[i].cells[j].style.textAlign) {
//					td.style.textAlign = templateTab.rows[i].cells[j].style.textAlign;
//				}
//				if (templateTab.rows[i].cells[j].style.display) {
//					td.style.display = templateTab.rows[i].cells[j].style.display;
//				}
//				td.innerHTML = templateTab.rows[i].cells[j].innerHTML;
//			}
//			// ����к��к��п��ܱ����ң���Ҫ���������к�
//			shortRowNum(targetTab);
//			var onAdd = targetTab.onAdd;
//			if (onAdd) {
//				onAdd(tr);
//			}
//			return tr;
//		}
	}else{
		alert("���ֻ����ӵ����У�");
	}
	
}
/*
* ���ܣ������ѡ��ѡ���е�������������������У����ύ��ʱ��У�������������Ƿ�Ϊ�� 
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
//��ʼ����ʽ
jQuery(function() {
	var tdArr = jQuery("table[id$='tableForm']"); 
	for(var i = 0;i<tdArr.length;i++){
		jQuery(tdArr[i]).css("padding-right","");
		jQuery(tdArr[i]).css("width","100%");
	}
});