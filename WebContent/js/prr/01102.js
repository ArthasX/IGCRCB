/**
 * ���ܣ�����Ƿ���Ҫ���Ա�ֵΪ����Ҫ���ԡ���TR���Ը�Ϊ��ʾ���������ظ�TR����
 * ���ã��Ƿ���Ҫ���Ա�����js
 * */
function checkTestWay(obj){
	var changeType = getFormObj("�Ƿ���Ҫ����").value;
	if(changeType == '��Ҫ����'){
		getFormObj("���Է�ʽ").parentElement.parentElement.style.display = "block"; 
	}else{
		getFormObj("���Է�ʽ").parentElement.parentElement.style.display = "none"; 
	}
}

/**
 * ���ܣ�����Ƿ���Ҫ���Ա�ֵΪ����Ҫ���ԡ���TR���Ը�Ϊ��ʾ���������ظ�TR����
 * ���ã��رսڵ����js
 * */
function checkTestClose(){
	var changeType = getFormObj("�Ƿ���Ҫ����").value;
	if(changeType == '��Ҫ����'){
		getFormObj("���Է�ʽ").parentElement.parentElement.style.display = "block"; 
	}else{
		getFormObj("���Է�ʽ").parentElement.parentElement.style.display = "none"; 
	}
}

/**
 * ���ܣ�����ڵ�У��
 * */
function checkTestSubmit(){
	var changeType = getFormObj("�Ƿ���Ҫ����").value;
	if(changeType == '��Ҫ����'){
		var testType = getFormObj("���Է�ʽ").value;  			// ���Է�ʽ
		if(testType == ''){
			alert("��ѡ����Է�ʽ��");
			return false;
		}else{
			return true;
		}
	}else{
		return true;
	}
}

/**
 * ���ܣ����ص�ʱ�򣬽����Է�ʽ������
 * ���ã���ʼ������js
 * */
function checkHideTestWay(obj){
	var changeType = getFormObj("�Ƿ���Ҫ����").value;
	if("��Ҫ����" != changeType){
		getFormObj("���Է�ʽ").parentElement.parentElement.style.display = "none"; 
		getFormObj("��������").parentElement.parentElement.style.display = "none"; 
		getFormObj("��ͨ���Խ��").parentElement.parentElement.style.display = "none"; 
		getFormObj("UAT���Խ��").parentElement.parentElement.style.display = "none"; 
	}else{
		getFormObj("���Է�ʽ").parentElement.parentElement.style.display = ""; 
		getFormObj("��������").parentElement.parentElement.style.display = ""; 
		getFormObj("��ͨ���Խ��").parentElement.parentElement.style.display = ""; 
		getFormObj("UAT���Խ��").parentElement.parentElement.style.display = ""; 
	}
}


function formJoinMove(){
	//if(getFormObj("��ͨ����").checked==true){
	var type = getFormObj("���Է�ʽ").value.split("#");
	if(type == null || type == ""){
		alert("��ѡ���Ӧ���Խ��");
		return false;
	}
	if(type.length == 1){
		if(type == "��ͨ����"){
			var str = getFormObj("��ͨ���Խ��").value;
			if(str == null || str == ""){
				alert("��ѡ����ͨ���Խ��");
				return false;
			}
		}
		else{
			var str = getFormObj("UAT���Խ��").value;
			if(str = null || str == ""){
				alert("��ѡ��UAT���Խ��");
				return false;
			}
		}
		
	}
	else{
		var str = getFormObj("��ͨ���Խ��").value;
		if(str == null || str == ""){
			alert("��ѡ����ͨ���Խ��");
			return false;
		}
		str = getFormObj("UAT���Խ��").value;
		if(str = null || str == ""){
			alert("��ѡ��UAT���Խ��");
			return false;
		}
	}
	return true;
}

/**
 * ���ܣ����Ľ���ʱ�����������Ŀ�ʼʱ��
 * ���ã��������ύ��ť
 * */
function checkTime(){
	//��ȡ���Ŀ�ʼʱ������Ľ���ʱ��
	var beginTime = getFormObj('�ƻ�ִ�п�ʼʱ��').value;
	var endTime = getFormObj('�ƻ�ִ�н���ʱ��').value;
	var changeType = getFormObj("�Ƿ���Ҫ����").value;
	//�жϿ�ʼʱ����߽�ֹʱ���Ƿ�Ϊ��
	if("" == beginTime || "" == endTime){
		return true;
	}
	
	//������Ŀ�ʼʱ����ڵ������Ľ���ʱ�䣬��ʾ��Ϣ
	if(beginTime.localeCompare(endTime) > 0){
		alert('�ƻ�ִ�н���ʱ�������ڼƻ�ִ�п�ʼʱ��!');
		return false;
	}else if(changeType == '��Ҫ����'){
		var testType = getFormObj("���Է�ʽ").value;  			// ���Է�ʽ
		if(testType == ''){
			alert("��ѡ����Է�ʽ��");
			return false;
		}else{
			return true;
		}
	}else{
		return true;
	}
}

/** -----------------------�汾2-----------------------  */
/**
 * ���ܣ�����Ƿ���Ҫ���Ա�ֵΪ����Ҫ���ԡ���TR���Ը�Ϊ��ʾ���������ظ�TR����
 * ���ã��Ƿ���Ҫ���Ա�����js
 * */
function checkTestWay2(obj){
}

/**
 * ���ܣ�����Ƿ���Ҫ���Ա�ֵΪ����Ҫ���ԡ���TR���Ը�Ϊ��ʾ���������ظ�TR����
 * ���ã��رսڵ����js
 * */
function checkTestClose2(){
}

/**
 * ���ܣ�����ڵ�У��
 * */
function checkTestSubmit2(){
}

/**
 * ���ܣ����ص�ʱ�򣬽����Է�ʽ������
 * ���ã���ʼ������js
 * */
function checkHideTestWay2(){
}


function formJoinMove2(){
	return true;
}

/**
 * ���ܣ����Ľ���ʱ�����������Ŀ�ʼʱ��
 * ���ã��������ύ��ť
 * */
function checkTime2(){
	//��ȡ���Ŀ�ʼʱ������Ľ���ʱ��
	var beginTime = getFormObj('�ƻ�ִ�п�ʼʱ��').value;
	var endTime = getFormObj('�ƻ�ִ�н���ʱ��').value;
	//������Ŀ�ʼʱ����ڵ������Ľ���ʱ�䣬��ʾ��Ϣ
	if(beginTime.localeCompare(endTime) > 0){
		alert('�ƻ�ִ�н���ʱ�������ڼƻ�ִ�п�ʼʱ��!');
		return false;
	}else{
		return true;
	}
}
function init_001(){
	var parprid = document.getElementById("parprid").value;
	if(parprid != ""){
		var params= {};
		params.parprid = parprid;
		
		//ajax��������
		jQuery.ajax({
			url:"IGCRC1005_GetParent.do",
			type:"POST",
			dataType :"json",
			data:params,
			cache:false,
			//�ɹ��ص�����
			success:function(data){
				if(data.type == "success"){
					document.getElementById("prtitle").value = data.prtitle;
//					document.getElementById("prdesc").value = data.prdesc;
				}
			},
			//ʧ�ܻص�����
			error:function(XMLHttpRequest, textStatus, errorThrown){
				//alert("��ȡ����������쳣");
			}
		});
	}
}

jQuery(document).ready(function(){
	//��־��Ϣ Ĭ��չʾ
	var path=jQuery("#loginfo").attr("src");
	if(path=="images/redu.gif"){
		jQuery("#loginfo").attr("src","images/addd.gif");
		jQuery("#TabbedPanels1").toggle();
	}else{
		jQuery("#loginfo").attr("src","images/redu.gif");
		jQuery("#TabbedPanels1").toggle();
	}
		
});
