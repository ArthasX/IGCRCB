/**
 * ���ܣ�ҳ��������ʱ��ʼ����Ҫ��Ϣ�����ر��ʽ��
 * ���ã�
 */
function IncidentLoad(){
	if(document.readyState == "complete"){
		if(getTableFormObj("�澯��Ϣ#�澯ID",1)){
			if(getTableFormObj("�澯��Ϣ#�澯ID",1).value.trim() == ""){
				getFormObj("�澯��Ϣ").parentElement.parentElement.style.display = "none";
			}
		}
	}else{
		setTimeout("IncidentLoad()", 100);
	}
}
IncidentLoad();

/**
 * ���ܣ�У�����̷���ʱ����Ҫ����ϵͳ��ǰʱ��
 * ���ã�����ʱ�������js
 * */
function checkOccurrence(obj){
		var D = new Date();
		var yy=D.getYear();
		var mm=D.getMonth()+1;
		var dd=D.getDate();
		var hours = D.getHours();
		var minute = D.getMinutes();
		if(mm < 10){
			mm = "0" + mm.toString();
		}
		if(dd < 10){
			dd = "0" + dd.toString();
		}
		if(hours < 10){
			hours = "0" + hours.toString();
		}
		if(minute < 10){
			minute = "0" + minute.toString();
		}
		var nowTime = yy + "/" + mm + "/" + dd + " " + hours + ":" + minute;//��ȡϵͳ��ǰʱ��
		var selectDate = obj.value;
		if(selectDate > nowTime){
			obj.value="";
			alert("����ʱ����Ҫ���ڵ�ǰʱ�䣡");
			return false;
		}
		return true;
	}