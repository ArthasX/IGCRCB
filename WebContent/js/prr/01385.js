	jQ(document).ready(function(){
		var pdid = jQ("#pdid").val();
		var psdid = jQ("#psdid").val();
		
		//������������ڵ�-������� ������� Ҫ��ʾ
		if (jQuery("#psdid[value$='003']").length > 0) {
			// �������
			var assessDesId = "pidid" + pdid + "012";
			var jAssessDes = jQ("#"+assessDesId);
//			if(!jAssessDes.val()){//��������������Ϊ������ʾ
//				jAssessDes.parent().parent().hide();
//				jQ("input[value="+pdid+"012]").parent().parent().hide();
//			}
			var value = jQ("input[value="+pdid+"012]").parent().find(".editDiv").text();
			if(!value){
				jQ("input[value="+pdid+"012]").parent().parent().hide();
			}
		}
		
		
		var dvCase = jQ(".title:contains('������Ϣ')").next();
		dvCase.after("<div class='title'><div class='name'>����������Ϣ</div></div>");
		
		//�������������Ǽƻ��ⷢ��
		if(jQ("#pidid"+pdid+"015").val()){
			jQ("#pidid"+pdid+"014").removeAttr("onclick");
			jQ("#pidid"+pdid+"001").attr("readonly",true);
		}
		if(psdid== pdid + '003'){
			
			jQ("input[name='pidid'][value='"+pdid+"016']").parent().parent().hide();
			jQ("#pidid"+pdid+"016").parent().prev("th").hide();
			jQ("input[name='pidid'][value='"+pdid+"017']").parent().hide();
			jQ("#pidid"+pdid+"017").parent().prev("th").hide();
			
		}
		//����ʵʩ�ڵ�-����ָ���Ƿ���� ��ֵ������ʱ����button10��ť
		if(psdid==pdid+'006'){
			if(!jQ("#pidid"+pdid+"019").val()){
				jQ("#button10").parent().hide();
			}
		}
		//�رս��� ����ר��Ԥ��id��
		if(psdid==pdid+'002'){
				jQ("#pidid"+pdid+"016").parent().parent().hide();
		}
		

	});
//}
	
function initPage(){
	initSwitch(jQ(".name:contains('������Ϣ')")[0],true);
	initSwitch(jQ(".name:contains('����������Ϣ')")[0]);
}	
function choosePlan(){
	openSubWindow('/IGDRM0604_Disp.do', '_blank', '1000', '600');

}
function openSubIGCOM0303(eiid,civersion){
	param = $H({sp_eiid: eiid,civersion:civersion}).toQueryString();
	openSubWindow('/IGDRM0702_Detail.do?' + param, '_blank', '1050', '600');
}


function selectEntity(index,pidid,syscoding){
	var pdid = jQ("#pdid").val();
	if(pidid ==  pdid + '021'){
		url = "/IGDRM2101_BsInit.do?esyscoding=1_CM03000000_999003&pidid="+pidid;
		openSubWindow(url, '', '850', '600');
	}else{
		if(syscoding!=null&&syscoding!=undefined&&syscoding.substring(0,6)=='999060'){
			
			var sp_eiid = jQ("#pidid"+pdid+"016").val();
			if(sp_eiid==''){
				alert("����ѡ��ר��Ԥ����");
			}else{
				
				openSubIGCOM0302PARAM('?pidid='+pidid + '&esyscoding=' + syscoding+'&sp_eiid='+sp_eiid);
			}
		}else{
			
			openSubIGCOM0302PARAM('?pidid='+pidid + '&esyscoding=' + syscoding);
		}
	}
	num = index;
}
function openSubIGCOM0302PARAM(param){
	openSubWindow('/IGDRM0702_Disp.do'+param , '', '850', '600');
}
/**
 * ��ʼ��ҳ����۵�title
 * @param dvbox
 */
function initSwitch(dvbox,isPackup){
	dvbox = jQ(dvbox);
	dvbox.css({cursor: "pointer"});
	dvbox.append("<img  src='images/addd.gif' width='10' height='10' border='0'/>");
	dvbox.on("click",function(){
		jQ(this).parent().next().toggle();
		if(jQ(this).find("img").attr("src")=='images/addd.gif'){
			jQ(this).find("img").attr("src","images/redu.gif");
		}else{
			jQ(this).find("img").attr("src","images/addd.gif");
		}
	});
	(isPackup)&&dvbox.click();
}

function showMsg(){
}

jQ(function(){
	
	if(jQ("#psdid").val()==jQ("#pdid").val()+"006"){
		var ckFn = jQ("#button10").attr("onclick");
		if(ckFn){
			jQ("#button10").removeAttr("onclick");
			jQ("#button10").click(function(){
				eval(ckFn.substring(0, ckFn.length-1)+",null,null,true)");
			});
		}
	}
	
})

jQuery(".table_style1 tr th:contains(ר��Ԥ��id)").parent().hide();
jQuery(".table_style1 tr th:contains(ָ������prid)").parent().hide();
jQuery(".table_style1 tr th:contains(����ָ���Ƿ����)").parent().hide();

