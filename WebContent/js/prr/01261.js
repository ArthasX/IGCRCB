
/**
 * 选人按钮点击事件
 * @param pidid
 * @param roletype
 */
function selectPeople(pidid,roletype){
	if(roletype == "N/A"){
		roletype = "";
	}
	cpidid = pidid;
	openSubWindow('/IGPRR0303_Disp.do?pidid=' + pidid + '&roletype=' + roletype +"&single=1", '_pblank','1050','600');
}

/**
 * 设置人员表单值
 * @param obj
 * @returns {Boolean}
 */
function setParticipant(obj){
	var tb = document.getElementById("people_" + cpidid);
	var tr,td1,td2,td3,td4,td5;
	if(obj != null && obj.length > 0){
		for(var k=0;k<obj.length;k++){
			for(var n=0;n<tb.rows.length;n++){
				if(obj[k][0] == tb.rows[n].name){
					alert("用户 \"" + obj[k][1] + "\" 在列表中已存在，请重新选择！");
					return true;
				}
			}
		}
		for(var i=0;i<obj.length;i++){
			tr = tb.insertRow();
			tr.name = obj[i][0];
			td1 = tr.insertCell();
			td1.innerHTML = obj[i][1] + 
							'<input type="hidden" name="par_userid" value="' + obj[i][0] + '" />' + 
							'<input type="hidden" name="par_username" value="' + obj[i][1] + '" />';
			td2 = tr.insertCell();
			td2.innerHTML = obj[i][3] +
							'<input type="hidden" name="par_orgid" value="' + obj[i][2] + '" />' +
							'<input type="hidden" name="par_orgname" value="' + obj[i][3] + '" />';
			td3 = tr.insertCell();
			td3.innerHTML = obj[i][5] + 
							'<input type="hidden" name="par_roleid" value="' + obj[i][4] + '" />' + 
							'<input type="hidden" name="par_rolename" value="' + obj[i][5] + '" />';
			td4 = tr.insertCell();
			td4.innerHTML = obj[i][6] + 
							'<input type="hidden" name="par_phone" value="' + obj[i][6] + '" />';
			td5 = tr.insertCell();
			td5.style.textAlign = "center";
			td5.innerHTML = '<a href="javascript:void(0);" onclick="deleteParticipant(this);">删除</a>' +
							'<input type="hidden" name="par_pidid" value="' + cpidid + '"/>';
		}
	}
	
	jQ(tb).parent().prevAll().hide();
}
/**
 * 删除人员表单
 * @param obj
 */
function deleteParticipant(obj){
	var tr = obj.parentElement.parentElement;
	jQ(tr).parent().parent().parent().prevAll().show();
	
	tr.parentElement.deleteRow(tr.rowIndex);
}



