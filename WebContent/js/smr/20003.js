/*
 * ����T-Q-4 ��������ҵ����ͳ�Ʊ�
 */
var isValid = true;
var a = "";
var errorObjs=[];

var item35_GTZero="����������Ҫҵ���ģ#���п�#����";


var label_item34_GTZero="����������Ҫҵ���ģ#�绰����#�绰����2#����";

var item56_GTZero="��Ҫ���ӽ��ױ���#POS#POS1#����";
var item59_GTZero="��Ҫ���ӽ��ױ���#POS#POS2#����";
var item62_GTZero="��Ҫ���ӽ��ױ���#POS#POS3#����";

var item65_GTZero="��Ҫ���ӽ��ױ���#ATM#ATM1#����";
var item68_GTZero="��Ҫ���ӽ��ױ���#ATM#ATM2#����";
var item71_GTZero="��Ҫ���ӽ��ױ���#ATM#ATM3#����";



var item77_GTZero="��Ҫ���ӽ��ױ���#��������#��������1#����";
var item128_GTZero="��Ҫ���ӽ��ױ���#��������#��������2#����";




var item78_GTZero="��Ҫ���ӽ��ױ���#�绰����#����";

var item79_GTZero="��Ҫ���ӽ��ױ���#�ֻ�����#����";

var item83_GTZero="��Ҫ���ӽ��ױ���#�ϼ�#����";

var item86_GTZero="��Ҫ���ӽ��׽��#POS#POS1#����";
var item89_GTZero="��Ҫ���ӽ��׽��#POS#POS2#����";
var item92_GTZero="��Ҫ���ӽ��׽��#POS#POS3#����";

var item95_GTZero="��Ҫ���ӽ��׽��#ATM#ATM1#����";
var item98_GTZero="��Ҫ���ӽ��׽��#ATM#ATM2#����";
var item101_GTZero="��Ҫ���ӽ��׽��#ATM#ATM3#����";



var item107_GTZero="��Ҫ���ӽ��׽��#��������#��������1#����";
var item129_GTZero="��Ҫ���ӽ��׽��#��������#��������2#����";

var item108_GTZero="��Ҫ���ӽ��׽��#�绰����#����";

var item110_GTZero="��Ҫ���ӽ��׽��#�ֻ�����#����";

var item113_GTZero="��Ҫ���ӽ��׽��#�ϼ�#����";



var item130_GTZero="��Ҫ���ӽ��������#��Ҫ���ӽ��������1#����";
var item131_GTZero="��Ҫ���ӽ��������#��Ҫ���ӽ��������2#����";
var item132_GTZero="��Ҫ���ӽ��������#��Ҫ���ӽ��������3#����";



function initSet(){
	var obj_item132 = getTableFormObjs(item132_GTZero);
	obj_item132[0].onclick = "";
	obj_item132[1].onclick = "";
	obj_item132[2].onclick = "";
	obj_item132[3].onclick = "";
	
}

/*
* ���ܣ�ͨ����Ҫ���ױ����ϼ� �� ��Ҫ���ӽ��������ȫ�����н��ױ��� ������Ҫ���ӽ��ױ�������ʵ�ֵ
* ���ã���Ҫ���ӽ��������#��Ҫ���ӽ��������1#����
* 	      ��Ҫ���ӽ��ױ���#��������#��������1#����
* 	      ��Ҫ���ӽ��ױ���#�ϼ�#���� 
* 	      ��Ҫ���ӽ��ױ���#��������#��������2#����
*/
function setItem130(obj){
	checkNumNotNegative(obj);
	var temp = 0;
	var obj_item77 = getTableFormObjs(item77_GTZero)[0];
	var obj_item83 = getTableFormObjs(item83_GTZero)[0];
	var obj_item128 = getTableFormObjs(item128_GTZero)[0];
	var obj_item130 = getTableFormObjs(item130_GTZero)[0];
	var obj_item132 = getTableFormObjs(item132_GTZero);
	obj_item132[0].onclick = "";
	obj_item132[2].onclick = "";
	if(obj_item130.value != ""){
		if(obj_item83.value != ""){
			temp = (parseFloat(obj_item83.value) / parseFloat(obj_item130.value))* 100;
			caculate(temp,obj_item132[0]);
		}else{
			obj_item132[0].value = 0;
		}
		if(obj_item77.value != "" || obj_item128.value !=""){
			temp = (( parseFloat(obj_item77.value) + parseFloat(obj_item128.value) )/ parseFloat(obj_item130.value)) * 100;
			caculate(temp,obj_item132[2]);
		}else{
			obj_item132[2].value = 0;
		}
	}
}
/*
* ���ܣ�����ٷֱȵ�ֵ�����Ҹ�ֵ��ָ���Ķ���
* ������temp �������ֵ
* 	  obj ָ���Ķ���
*/
function caculate(temp,obj){
	if(temp == 0){
		obj.value = temp;
	}else{
		obj.value = temp.toFixed(2);
	}
}

/*
* ���ܣ�ͨ����Ҫ���ױ����ϼ� �� ��Ҫ���ӽ��������ȫ�����н��ױ��� ������Ҫ���ӽ��ױ�������ʵ�ֵ
* ���ã���Ҫ���ӽ��������#��Ҫ���ӽ��������2#����
* 		��Ҫ���ӽ��׽��#�ϼ�#����
*  		��Ҫ���ӽ��׽��#��������#��������1#����
* 		��Ҫ���ӽ��׽��#��������#��������2#����
* 
*/
function setItem131_GTZero(obj){
	checkNumNotNegative(obj);
	var temp = 0;
	var obj_item113 = getTableFormObjs(item113_GTZero)[0];
	var obj_item131 = getTableFormObjs(item131_GTZero)[0];
	var obj_item107 = getTableFormObjs(item107_GTZero)[0];
	var obj_item129 = getTableFormObjs(item129_GTZero)[0];
	var obj_item132 = getTableFormObjs(item132_GTZero);
	obj_item132[1].onclick = "";
	obj_item132[3].onclick = "";
	if(obj_item131.value != ""){
		if(obj_item113.value != "" ){
			temp = ( parseFloat(obj_item113.value) / parseFloat(obj_item131.value)) * 100;
			caculate(temp,obj_item132[1]);
		}else{
			obj_item132[1].value = 0;
		}
		
		if(obj_item107.value != "" || obj_item129.value != ""){
			temp = ((parseFloat(obj_item107.value) + parseFloat(obj_item129.value))/ parseFloat(obj_item131.value))*100;
			caculate(temp,obj_item132[3]);
		}else{
			obj_item132[3].value = 0;
		}
	}
}
/*
* ���ܣ�����ύʱ���еı���֤
* ���ã��״̬�ġ��ύ����ť
*/
function checkData()
{

	checkNumFloat(getTableFormObjs(item35_GTZero)[0],4);
	checkNumFloat(getTableFormObjs(item35_GTZero)[1],4);
	checkNumFloat(getTableFormObjs(item35_GTZero)[2],4);
	checkNumFloat(getTableFormObjs(item35_GTZero)[3],4);
	checkNumFloat(getTableFormObjs(item35_GTZero)[4],4);
	checkNumFloat(getTableFormObjs(label_item34_GTZero)[0],2);
	checkNumFloat(getTableFormObjs(label_item34_GTZero)[1],2);
	checkNumFloat(getTableFormObjs(item56_GTZero)[0],4);
	checkNumFloat(getTableFormObjs(item59_GTZero)[0],4);
	checkNumFloat(getTableFormObjs(item62_GTZero)[0],4);
	checkNumFloat(getTableFormObjs(item65_GTZero)[0],4);
	checkNumFloat(getTableFormObjs(item68_GTZero)[0],4);
	checkNumFloat(getTableFormObjs(item71_GTZero)[0],4);
	checkNumFloat(getTableFormObjs(item77_GTZero)[0],4);
	checkNumFloat(getTableFormObjs(item128_GTZero)[0],4);
	checkNumFloat(getTableFormObjs(item78_GTZero)[0],4);
	checkNumFloat(getTableFormObjs(item79_GTZero)[0],4);
	checkNumFloat(getTableFormObjs(item83_GTZero)[0],4);
	checkNumFloat(getTableFormObjs(item86_GTZero)[0],4);
	checkNumFloat(getTableFormObjs(item89_GTZero)[0],4);
	checkNumFloat(getTableFormObjs(item92_GTZero)[0],4);
	checkNumFloat(getTableFormObjs(item95_GTZero)[0],4);
	checkNumFloat(getTableFormObjs(item98_GTZero)[0],4);
	checkNumFloat(getTableFormObjs(item101_GTZero)[0],4);
	checkNumFloat(getTableFormObjs(item107_GTZero)[0],4);
	checkNumFloat(getTableFormObjs(item129_GTZero)[0],4);
	checkNumFloat(getTableFormObjs(item108_GTZero)[0],4);
	checkNumFloat(getTableFormObjs(item110_GTZero)[0],4);
	checkNumFloat(getTableFormObjs(item113_GTZero)[0],4);
	checkNumFloat(getTableFormObjs(item130_GTZero)[0],4);
	checkNumFloat(getTableFormObjs(item131_GTZero)[0],4);
	checkNumFloat(getTableFormObjs(item132_GTZero)[0],2);
	checkNumFloat(getTableFormObjs(item132_GTZero)[1],2);
	checkNumFloat(getTableFormObjs(item132_GTZero)[2],2);
	checkNumFloat(getTableFormObjs(item132_GTZero)[3],2);
	
	for(var obj in arr_pididObj) {
		if(arr_pididObj[obj] instanceof pidObj) {
			var  pididobj=arr_pididObj[obj].pidlabelFull.split("#")[arr_pididObj[obj].pidlabelFull.split("#").length-1];
			if(pididobj=="ͬ������(%)"||pididobj=="��������(%)"){
				var tableFormObj=getTableFormObjs(arr_pididObj[obj].pidlabelFull);
				for(var i=0;i<tableFormObj.length;i++){
					if(tableFormObj[i]!=""){
						checkNumFloat(tableFormObj[i],2);
					}
				}
			}
		}
	}
	
	if (!checkEmptyReport()) {
		return true;
	}
	
	//��մ�����ı���ɫ
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.color="";
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];
//	if(T_Q_4.page1.Subform1.ND.value==1) return;
	//1.
//	alert(parseInt(getTableFormObj(item35_GTZero,"1_2").value)+parseInt(getTableFormObj(item35_GTZero,"1_3").value));
	var nums=0;
	var num1=0;
	var num2=0;
	if(getTableFormObj(item35_GTZero,"1_1").value!=""){nums=parseFloat(getTableFormObj(item35_GTZero,"1_1").value);}
	if(getTableFormObj(item35_GTZero,"1_2").value!=""){num1=parseFloat(getTableFormObj(item35_GTZero,"1_2").value);}
	if(getTableFormObj(item35_GTZero,"1_3").value!=""){num2=parseFloat(getTableFormObj(item35_GTZero,"1_3").value);}
	
	if((nums+0.01)*10000<Math.round((num1+num2)*10000)||(nums-0.01)*10000>Math.round((num1+num2)*10000))
	{
		alert("error");
		errorObjs.push(getTableFormObj(item35_GTZero,"1_1"));
		errorObjs.push(getTableFormObj(item35_GTZero,"1_2"));
		errorObjs.push(getTableFormObj(item35_GTZero,"1_3"));
	 	a+="����������Ҫҵ���ģ.���п��ܷ�����=��ǿ�����+���ǿ���������׼���ǿ���У�����\n";
	  	isValid=false;
	}
	//xfa.host.messageBox(String(Math.round(10.98707)),"����У��",3);	
	//2.
	var numss=0;
	var num11=0;
	var num12=0;
	var num13=0;
	var num14=0;
	var num15=0;
	var num16=0;
	var num17=0;
	var num18=0;
	var num19=0;
	var num20=0;
	if(getTableFormObj(item83_GTZero,"1_1").value!=""){numss=parseFloat(getTableFormObj(item83_GTZero,"1_1").value);}
	if(getTableFormObj(item78_GTZero,"1_1").value!=""){num11=parseFloat(getTableFormObj(item78_GTZero,"1_1").value);}
	if(getTableFormObj(item56_GTZero,"1_1_1").value!=""){num12=parseFloat(getTableFormObj(item56_GTZero,"1_1_1").value);}
	if(getTableFormObj(item59_GTZero,"1_1_1").value!=""){num13=parseFloat(getTableFormObj(item59_GTZero,"1_1_1").value);}
	if(getTableFormObj(item62_GTZero,"1_1_1").value!=""){num14=parseFloat(getTableFormObj(item62_GTZero,"1_1_1").value);}
	if(getTableFormObj(item65_GTZero,"1_1_1").value!=""){num15=parseFloat(getTableFormObj(item65_GTZero,"1_1_1").value);}
	if(getTableFormObj(item68_GTZero,"1_1_1").value!=""){num16=parseFloat(getTableFormObj(item68_GTZero,"1_1_1").value);}
	if(getTableFormObj(item71_GTZero,"1_1_1").value!=""){num17=parseFloat(getTableFormObj(item71_GTZero,"1_1_1").value);}
	if(getTableFormObj(item77_GTZero,"1_1_1").value!=""){num18=parseFloat(getTableFormObj(item77_GTZero,"1_1_1").value);}
	if(getTableFormObj(item128_GTZero,"1_1_1").value!=""){num19=parseFloat(getTableFormObj(item128_GTZero,"1_1_1").value);}
	if(getTableFormObj(item79_GTZero,"1_1").value!=""){num20=parseFloat(getTableFormObj(item79_GTZero,"1_1").value);}
	if((numss+0.01)*10000<Math.round((num11+num12+num13+num14+num15+num16+num17+num18+num19+num20)*10000)||
	   (numss-0.01)*10000>Math.round((num11+num12+num13+num14+num15+num16+num17+num18+num19+num20)*10000))
	{
		errorObjs.push(getTableFormObj(item83_GTZero,"1_1"));
		errorObjs.push(getTableFormObj(item78_GTZero,"1_1"));
		errorObjs.push(getTableFormObj(item56_GTZero,"1_1_1"));
		errorObjs.push(getTableFormObj(item59_GTZero,"1_1_1"));
		errorObjs.push(getTableFormObj(item62_GTZero,"1_1_1"));
		errorObjs.push(getTableFormObj(item65_GTZero,"1_1_1"));
		errorObjs.push(getTableFormObj(item68_GTZero,"1_1_1"));
		errorObjs.push(getTableFormObj(item71_GTZero,"1_1_1"));
		errorObjs.push(getTableFormObj(item77_GTZero,"1_1_1"));
		errorObjs.push(getTableFormObj(item128_GTZero,"1_1_1"));
		errorObjs.push(getTableFormObj(item79_GTZero,"1_1"));
	 	a+="��Ҫ���ӽ��ױ����ϼ�= ATM���н��ױ���+ATM���������ױ���+ATM���������ױ���+ POS���н��ױ���+POS���������ױ���+POS���������ױ���+�����������н��ױ���+��ҵ�������н��ױ���+�绰���н��ױ���+�ֻ����н��ױ��� У�����\n";
	 	isValid=false;
	}
	//3.
	var numsss=0;
	var num21=0;
	var num22=0;
	var num23=0;
	var num24=0;
	var num25=0;
	var num26=0;
	var num27=0;
	var num28=0;
	var num29=0;
	var num30=0;
	if(getTableFormObj(item113_GTZero,"1_1").value!=""){numsss=parseFloat(getTableFormObj(item113_GTZero,"1_1").value);}
	if(getTableFormObj(item86_GTZero,"1_1_1").value!=""){num21=parseFloat(getTableFormObj(item86_GTZero,"1_1_1").value);}
	if(getTableFormObj(item89_GTZero,"1_1_1").value!=""){num22=parseFloat(getTableFormObj(item89_GTZero,"1_1_1").value);}
	if(getTableFormObj(item92_GTZero,"1_1_1").value!=""){num23=parseFloat(getTableFormObj(item92_GTZero,"1_1_1").value);}
	if(getTableFormObj(item95_GTZero,"1_1_1").value!=""){num24=parseFloat(getTableFormObj(item95_GTZero,"1_1_1").value);}
	if(getTableFormObj(item98_GTZero,"1_1_1").value!=""){num25=parseFloat(getTableFormObj(item98_GTZero,"1_1_1").value);}
	if(getTableFormObj(item101_GTZero,"1_1_1").value!=""){num26=parseFloat(getTableFormObj(item101_GTZero,"1_1_1").value);}
	if(getTableFormObj(item107_GTZero,"1_1_1").value!=""){num27=parseFloat(getTableFormObj(item107_GTZero,"1_1_1").value);}
	if(getTableFormObj(item129_GTZero,"1_1_1").value!=""){num28=parseFloat(getTableFormObj(item129_GTZero,"1_1_1").value);}
	if(getTableFormObj(item108_GTZero,"1_1").value!=""){num29=parseFloat(getTableFormObj(item108_GTZero,"1_1").value);}
	if(getTableFormObj(item110_GTZero,"1_1").value!=""){num30=parseFloat(getTableFormObj(item110_GTZero,"1_1").value);}
	if((numsss+0.01)*10000<Math.round((num21+num22+num23+num24+num25+num26+num27+num28+num29+num30)*10000)||
			(numsss-0.01)*10000>Math.round((num21+num22+num23+num24+num25+num26+num27+num28+num29+num30)*10000))
	{
		errorObjs.push(getTableFormObj(item113_GTZero,"1_1"));
		errorObjs.push(getTableFormObj(item86_GTZero,"1_1_1"));
		errorObjs.push(getTableFormObj(item89_GTZero,"1_1_1"));
		errorObjs.push(getTableFormObj(item92_GTZero,"1_1_1"));
		errorObjs.push(getTableFormObj(item95_GTZero,"1_1_1"));
		errorObjs.push(getTableFormObj(item98_GTZero,"1_1_1"));
		errorObjs.push(getTableFormObj(item101_GTZero,"1_1_1"));
		errorObjs.push(getTableFormObj(item107_GTZero,"1_1_1"));
		errorObjs.push(getTableFormObj(item129_GTZero,"1_1_1"));
		errorObjs.push(getTableFormObj(item108_GTZero,"1_1"));
		errorObjs.push(getTableFormObj(item110_GTZero,"1_1"));
	 	a+="��Ҫ���ӽ��׽��ϼ�= ATM���н��׽��+ATM���������׽��+ATM���������׽��+ POS���н��׽��+POS���������׽��+POS���������׽��+�����������н��׽��+��ҵ�������н��׽��+�绰���н��׽��+�ֻ����н��׽�� У�����\n";
	 	isValid=false;
	}
	var number1=0;
	var number2=0;
	if(getTableFormObj(item130_GTZero,"1_1").value!=""){number1=parseInt(getTableFormObj(item130_GTZero,"1_1").value);}
	if(getTableFormObj(item83_GTZero,"1_1").value!=""){number2=parseInt(getTableFormObj(item83_GTZero,"1_1").value);}
	if(number1<number2)
	{
			errorObjs.push(getTableFormObj(item130_GTZero,"1_1"));
			errorObjs.push(getTableFormObj(item83_GTZero,"1_1"));
			a+="��Ҫ���ӽ��������-ȫ�����н��ױ���������Ҫ���ӽ��ױ����ϼ�У�����\n";
		  	isValid=false;
	}
	var number3=0;
	var number4=0;
	if(getTableFormObj(item131_GTZero,"1_1").value!=""){number3=parseInt(getTableFormObj(item131_GTZero,"1_1").value);}
	if(getTableFormObj(item113_GTZero,"1_1").value!=""){number4=parseInt(getTableFormObj(item113_GTZero,"1_1").value);}
	if(number3<number4)
	{		
		errorObjs.push(getTableFormObj(item131_GTZero,"1_1"));
		errorObjs.push(getTableFormObj(item113_GTZero,"1_1"));
		a+=" ��Ҫ���ӽ��������-ȫ�����н��׽�������Ҫ���ӽ��׽��ϼ�У�����\n";
	  	isValid=false;
	}
	validPercent(getTableFormObj(item132_GTZero,"1_1"),"��Ҫ���ӽ��ױ��������");
	validPercent(getTableFormObj(item132_GTZero,"1_2"),"��Ҫ���ӽ��׽�������");
	validPercent(getTableFormObj(item132_GTZero,"1_3"),"�������н��ױ��������");
	validPercent(getTableFormObj(item132_GTZero,"1_4"),"�������н��׽�������");
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

/**
 * ����ʵ���֤
 */
function validPercent(obj,objname){
	if(obj.value > 100 || obj.value < 0){
		a += objname+"����С��0�����100��\n";
		errorObjs.push(obj);
		isValid=false;
	}
}

/*
 *���ܣ��س����滻
 */
function replaceAll(value) {
	if (value == null)
		return value;
	while (value.indexOf("\r") > -1) {
		value = value.replace("\r", "");
	}
	return value;
}
