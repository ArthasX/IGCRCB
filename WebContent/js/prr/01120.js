/**
 * ���ܣ��������ڵ㣬�ĵ������ֶ���ʾΪ�ı�
 * ���ã��ĵ�����Ա���� �ۺϹ������������� �Ƽ����ܾ������� onload�¼� 
 * */
function checkNode(obj){
	//��ȡa��ǩ����
	var tagas = document.getElementsByTagName("a");
	for(var i=0;i<tagas.length;i++){
		if(tagas[i].innerHTML == '�鿴����־'){
			tagas[i-1].outerHTML = tagas[i-1].innerHTML;
		}
	}

}

/**
 * ���ܣ��ڹ黹�ڵ㣬���������¼�˲�һ�£��ĵ������ֶ���ʾΪ�ı�
 * ���ã��黹�ڵ�
 * */
function checkIsDownLoadReturn(obj){
	var tabs = document.getElementsByTagName("table");
	var loginer = tabs[0].rows[0].cells[1].innerHTML;
	var opener = tabs[2].rows[2].cells[1].innerHTML;
	if(loginer.indexOf(opener) < 0){
		checkNode();
	}
}

/**
 * ���ܣ��ڹرսڵ㣬���������¼�˲�һ�£��ĵ������ֶ���ʾΪ�ı�
 * ���ã��رսڵ�
 * */
function checkIsDownLoadClose(obj){
	var tabs = document.getElementsByTagName("table");
	var loginer = tabs[0].rows[0].cells[1].innerHTML;
	var opener = tabs[1].rows[2].cells[1].innerHTML;
	if(loginer.indexOf(opener) < 0){
		checkNode();
	}
}
