/**
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

/**
 * �����嵥����js����
 * @time 2014/06/24
 * @author taoye
 * @version 1.0
 * @mail taoye@deliverik.com
 */

/**
 * ���ܣ������嵥ҳ���ʼ��
 * ���ã����������js����
 */
function valueInit(obj){
	//��ȡ�������ֵ
	var hiddenField = getFormObj('������').value;
	if(hiddenField != null && hiddenField.length >0){
		//ȥ���ָ���_$_
		var contents = hiddenField.split('_$_');
		//�ж�contents�ĳ��ȣ��������3�����1,2��ϲ�
		if(contents.length > 2){
			for(var i=2 ;i<contents.length; i++){
				if(i < contents.length -1){
					contents[2] +=  contents[i]+'_$_';
				}else{
					contents[2] +=  contents[i];
				}
			}
		}
		//Ϊ�����̱�����ʼֵ
		document.getElementsByName("show_value")[0].value = contents[2];
		document.getElementById("pivarvalue[4]").value = '_processValue_only_id_'+ contents[0]+'_svc_'+ contents[1]+'_name='+contents[2];
	}
	return true;
}
