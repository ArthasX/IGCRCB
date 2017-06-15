var context = null;
var contextArray = {};
function init(context){
	jQuery(context.forms.find("users").target.target).off().on("change", function(event){
		context.get(context.id,jQuery(this).val());
//		init(context.prid,this.getValue(),context.status);
		event.stopPropagation();
	}).on("click",function(){return false;});
	var form = context.forms.findByName("业务系统");
	if(form){
		form.target.url = "/IGDRM2101_BsInit.do?esyscoding=1_CM03000000_999003&pidid=" + form.id; 
	}
	//初始化处理时间
	form = context.forms.findByName("处理时间");
	
	form.target.target.value = getCurTime();
	
	
	form = context.forms.findByName("专项预案");
	
	
	if(form){
		form.onchange = function(event,scencVal){
			
			//资产id
			var val = this.getValue();
			var eiid = val ? val.split("#")[1] : "";
			if(eiid){
				jQ.ajax({  
					type: "post",  
					url:"IGDRM0702_Ajax.do",
			       	cache:false,  
			       	dataType:'json',  
//			    	data:{esyscoding:'999060',sp_eiid:eiid,prid:context.id, pidid:context.forms.findByName("应急场景").id},
			       	data:{esyscoding:'999060',sp_eiid:eiid,prid:context.id,scenceCategory:context.prCategory,pidid:context.forms.findByName("应急场景").id},
			       	success: function(data){
			       		if(data.length > 0){
			       			var scencForm = context.forms.findByName("应急场景");
			       			scencForm.target.sel2 = jQuery(scencForm.target.target).select2({
				       			 data:data,
				       			 placeholder:'请选择'
			       			});
			       			if(scencVal){
			       				jQuery(scencForm.target.target).val(scencVal);
			       				scencForm.target.sel2 = jQuery(scencForm.target.target).select2();
			       				scencForm.target.sel2.trigger("change");
			       			}else{
			       				scencForm.target.sel2.trigger("change");
			       			}
						}
					}  
				});
			}
		};
	}
	
	form = context.forms.findByName("应急场景");
	if(form){
		form.onchange = function(){
			var val = this.getValue();
			if(val){
				$.ajax({
					url:"IGDRM0702_AjaxUser.do",
					type: "post",  
			       	cache:false,  
			       	dataType:'json',  
			       	data:{sp_eiid:val.split("#")[1],cid:'CI600000001004'},
			       	success:function(data){
			       		var p = context.forms.findByName("场景参与人").target;
			       		var tb = p.target;
			       		p.removeAll();
			       		var td = null;
			       		var index = 1;
			       		for(var key in data){
			       			var rownum = index + "";
			       			if(p.container[rownum] == null){
								p.container[rownum] = new Array();
							}
			       			var tr = tb.insertRow(tb.rows.length);
			       			td = tr.insertCell(0);
			       			jQuery(td).css({"width":"30px","text-align":"center"});
			       			var checkbox = document.createElement("input");
							checkbox.className = "checkbox";
							checkbox.setAttribute("type","checkbox");
							checkbox.setAttribute("name","selectstatus");
							checkbox.setAttribute("value",rownum);
							checkbox.onclick = function(){
								checkRoles(p.container,this);
							};
							td.appendChild(checkbox);
							td = tr.insertCell(1);
							var content = new WorkFlowContext.Form.Table.Column(td,context.pdid + "028",rownum);
							content.setValue(data[key].psdname);
							p.container[rownum][context.pdid + "028"] = content;
							td = tr.insertCell(2);
							var showcontent = new WorkFlowContext.Form.Table.Column(td,context.pdid + "029",rownum);
							p.container[rownum][context.pdid + "029"] = showcontent;
							td = tr.insertCell(3);
							var rolecontent = new WorkFlowContext.Form.Table.Column(td,context.pdid + "030",rownum);
							p.container[rownum][context.pdid + "030"] = rolecontent;
							td.style.display = "none";
							td = tr.insertCell(4);
							var userrolecontent = new WorkFlowContext.Form.Table.Column(td,context.pdid + "031",rownum);
							p.container[rownum][context.pdid + "031"] = userrolecontent;
							td.style.display = "none";
							td = tr.insertCell(5);
							var psdcontent = new WorkFlowContext.Form.Table.Column(td,context.pdid + "032",rownum);
							p.container[rownum][context.pdid + "032"] = psdcontent;
							psdcontent.setValue(key);
							td.style.display = "none";
							var userrole = data[key].userrole;
							if(userrole){
								var str = '<table class="table_form" style="width:100%">';
								var roleids = new Array();
								var roles = new Array();
								for(var rkey in userrole){
									var role = rkey + "#" + userrole[rkey].rolename + "_role_"
									str += '<tr>';
									str += '<td style="width:30%;padding:3px;text-align:right;">';
									str += userrole[rkey].rolename;
									str += '</td>';
									str += '<td style="width:70%;padding:3px;text-align:left;">';
									var userinfo = userrole[rkey].userinfo;
									var users = new Array();
									if(userinfo){
										for(var i=0;i<userinfo.length;i++){
											if(i > 0){
												str += ',';
											}
											str += userinfo[i].username ? userinfo[i].username : ""
											users.push(userinfo[i].userid + "#" + userinfo[i].username);
										}
									}
									role += users.join("_user_");
									roles.push(role);
									str += '</td>';
									str += '</tr>';
									roleids.push(rkey);
								}
								str += '</table>';
								rolecontent.setValue(roleids.join(","));
								showcontent.setValue(str);
								userrolecontent.setValue(roles.join("_roleuser_"));
							}
							index++;
			       		}
			       	}
				})
			}else{
				
			}
		};
	}
	form = context.forms.findByName("事件级别");
	if(form){
		if(form.access == "3"){
			form.target.target.readOnly = true;
			form.target.target.onclick = function(){
				currentObj = this;
				openSubWindow("/IGDRM1605_Search.do", "eveWin", 1000, 600);
			};
		}
	}
	var btn = context.buttons.find("调整参与人");
	if(btn){
		btn.click = function(){
			if(jQuery("[name='selectstatus']:checked").length == 0){
				alert("请选择要调整参与人的节点！");
				return;
			}
			var psd = jQuery("[name='selectstatus']:checked:eq(0)");
			var cval = psd.parent().parent().find(">td:eq(3)").text();
			openSubWindow('/IGDRM0702_AdjustUser.do?roleids=' + cval, '', '960', '600');
		};
	}
}
function setUserParam(objs,roleids,resultObj){
	//遍历被选中节点
	var table = context.forms.findByName("场景参与人").target;
	if(table){
		jQuery("[name='selectstatus']:checked").each(function(i,o){
			var r = table.container[o.value];
			//用户角色隐藏对象
			var userrolecontent = r[context.pdid + "031"];
			userrolecontent.setValue(objs.join("_roleuser_"));
			//显示内容对象
			var showcontent = r[context.pdid + "029"];
			var str = '<table class="table_form" style="width:100%">';
			for(var key in resultObj){
				str += '<tr>';
				str += '<td style="width:30%;padding:3px;text-align:right;">';
				str += key;
				str += '</td>';
				str += '<td style="width:70%;padding:3px;text-align:left;">';
				str += resultObj[key];
				str += '</td>';
				str += '</tr>';
			}
		    str += '</table>';
		    showcontent.setValue(str);
			//角色隐藏对象
			var rolecontent = r[context.pdid + "030"];
			rolecontent.setValue(roleids);
		});
	}
}
function setParamDRM2101(eid, elabel, ename, eiid, eilabel, einame ,ecategory,eiversion,esyscoding){
	if(currentObj){
		currentObj.value = einame;
		currentObj.setAttribute("eiid","1_" + eiid);
		currentObj = null;
		entityChange();
	}
}

//业务系统
function entityChange(){
	
	
	var planForm = context.forms.findByName("专项预案");
	var scencForm = context.forms.findByName("应急场景");
	var sysForm = context.forms.findByName("业务系统");
	if(!planForm||planForm.access=='2'||!sysForm){
		return;
	}
	
	var eiids = "";
	
	var values = sysForm.getValue();
	var index = 0;
	if(values){
		var splits = values.split("_sp_");
		if(splits){
			for(var i=0;i<splits.length;i++){
				var eiid = splits[i].split("#")[1];
				if(eiid){
					if(index > 0){
						eiids += ",";
					}else{
						index ++;
					}
					if(eiid.indexOf("_") > 0){
						eiids += eiid.split("_")[1];
					}else{
						eiids += eiid;
					}
				}
			}
		}
	}
	var planVal = planForm.getValue();
	var scencVal = scencForm.getValue();

	planForm.target.clean();
	
	scencForm.target.clean();
	
	if(eiids){
		jQuery.ajax({  
			type: "post",  
			url:"IGDRM0702_Ajax.do",
	       	cache:false,  
	       	dataType:'json',  
	       	data:{esyscoding:'888001',sp_eiid:eiids,pidid:context.forms.findByName("专项预案").id},
	       	success: function(data){
	       		if(data.length > 0){
	       			planForm.target.sel2 = jQuery(planForm.target.target).select2({
		       			 data:data,
		       			 placeholder:'请选择'
	       			});
	       			if(planVal){
	       				jQuery(planForm.target.target).val(planVal);
	       				planForm.target.sel2 = jQuery(planForm.target.target).select2();
	       			} 
	       			jQuery(planForm).trigger("change",[scencVal]);
				}
			}  
		});
	}
}

/**
 * 计算时间
 * @param startTime
 * @param useTime
 * @returns {String}
 */
function compliteTime(startTime,useTime){
	
	if(!(startTime&&useTime)){
		return '';
	}
	
	var startTimeArr = startTime.split(":");
	var useTimeArr = useTime.split(":");
	var overTimeArr = new Array();
	var resultTimeArr = new Array();
	for(var i = 0;i<3;i++){
		var total = parseFloat(startTimeArr[i])+parseFloat(useTimeArr[i]);
		overTimeArr.push(total);
	}
	if(Number(overTimeArr[2])>59){
		overTimeArr[2] = Number(overTimeArr[2])-60;
		overTimeArr[1] = Number(overTimeArr[1])+1;
	}
	if(parseFloat(overTimeArr[1])>59){
		overTimeArr[1] = parseFloat(overTimeArr[1])-60;
		overTimeArr[0] = parseFloat(overTimeArr[0])+1;
	}
	for(var index = 0;index<3;index++){
		if(parseFloat(overTimeArr[index])<10){
			resultTimeArr.push("0"+overTimeArr[index]);
		}else{
			resultTimeArr.push(overTimeArr[index]);
		}
	}
	
	return resultTimeArr[0].toString()+":"+resultTimeArr[1].toString()+":"+resultTimeArr[2].toString();
}



function getCurTime(){
	var d = new Date();
	
	var result  = "";
	result+=d.getFullYear()+"/";
	result+= (d.getMonth()>9?d.getMonth():"0"+d.getMonth())+"/";
	result+= (d.getDate()>9?d.getDate():"0"+d.getDate())+" ";
	result+= (d.getHours()>9?d.getHours():"0"+d.getHours())+":";
	result+= (d.getMinutes()>9?d.getMinutes():"0"+d.getMinutes());
//	result+= ":"+(d.getSeconds()>9?d.getSeconds():"0"+d.getSeconds());
	return result;
}

String.prototype.strlen = function(){
	var len = 0;
    for (var i = 0; i < this.length; i++) {
        var c = this.charCodeAt(i);
        //单字节加1 
        if ((c >= 0x0001 && c <= 0x007e) || (0xff60 <= c && c <= 0xff9f)) {
            len++;
        }
        else {
            len += 2;
        }
    }
    return len;
}

/**
 * 显示日志
 * @param event
 * @returns
 */
function showLog(event){
	var prid = window.curPrid;
	window.maskFlag = true;
	jQuery.ajax({
		url:"IGDRM1010_Log.do",
		 cache: false,
		data:{prid:prid},
		type:"POST",
		dataType: "json",
		success:function(resultData){
			window.maskFlag = false;
			if(resultData.msg=="success"){
				showWin("处理日志",{width:800,height:550},function(box){
					jQuery(box).append("<table class='logtb'></table>");
					var logTable =jQuery(box).find("table");
					logTable.html("<tr><th width='15%'>节点名称</th><th width='10%'>处理人</th><th width='8%'>操作</th><th>处理日志</th><th width='15%'>处理时间</th></tr>");
					logTable.addClass("logTB");
					for(var i = 0;i<resultData.data.length;i++){
						var emeLog = resultData.data[i];
						logTable.append("<tr><td>"+emeLog.elpsdname+"</td><td>"+emeLog.elusername+"</td><td>"+(emeLog.operate||'')+"</td><td class='leftTd'>"+(emeLog.elliinfo||'')+"</td><td>"+emeLog.ellidtime+"</td></tr>")
					}
						
				});
			}
		}
	})
	
}

/**
 * 弹出处置说明补填窗口
 * @param event
 * @returns
 */
function showDesc(psdid){
	var prid = window.curPrid;
	jQuery.ajax({
		url:"IGDRM1010_GetDesc.do",
		 cache: false,
		data:{psdid:psdid,prid:prid},
		type:"POST",
		dataType: "json",
		success:function(resultData){
			window.maskFlag = false;
			if(resultData.msg=="SUCCESS"){
				showWin("修改处置说明",{width:400,height:220},function(box){
					jQuery(box).append("<table class='tbdesc' ></table>");
					var logTable =jQuery(box).find("table");
					logTable.html("<tr><th width='30%'>处置说明</th><td><textarea id='psddesc'>"+resultData.desc+"</textarea></td></tr><tr><td  colspan='2'><input type='button' class='btn' onclick='saveDesc(this,\""+psdid+"\",\""+resultData.pvlid+"\")' value='保存'> </td></tr>");
						window.descBox = box;
				});
			}
		},
		complete:function(){
			jQuery(window).unmask();
			}
	});
	
}

/**
 * 保存处置说明
 * @param btnObj  按钮dom对象
 * @param psdid
 * @param pvlid
 * @returns
 */
function saveDesc(btnObj,psdid,pvlid){
	
	var txt = jQuery(btnObj).parent().parent().parent().find("#psddesc").val();
	if(txt.strlen()>650){
		
		alert("处置说明不能多于"+(650)+"个汉字!");
		return false;
	}
	jQuery.ajax({
		url:"IGDRM1010_SaveDesc.do",
		 cache: false,
		data:{psdid:psdid,pvlid:pvlid,prid:window.curPrid,psdValue:jQuery(btnObj).parent().parent().parent().find("#psddesc").val()},
		type:"POST",
		dataType: "json",
		success:function(resultData){
			
		},
		complete:function(){
			window.descBox.close();
			 window.descBox = undefined;
		}
	});
	
}

/**
 * 弹出窗口
 * @param width
 * @param height
 * @param contentFun
 */
function showWin(title,cssObj,contentFun){
	var box = document.createElement("div");
	document.body.appendChild(box);
	width = cssObj.width||800;
	height = cssObj.height||400;
	box.className = "popwin";
	box.innerHTML="<div class='titBar'>"+title+"<span class='close-icon'>X</span></div>";
	var winWidth = jQuery(window).width();
	var winHeight = jQuery(window).height();
	var left = (winWidth-width)/2;
	var top = (winHeight-height)/2;
	jQuery("#maskbox").height(jQuery("#databox").height());
	jQuery("#maskbox").show();
	jQuery(box).css({left:winWidth/2,top:winHeight/2,maxHeight:height,minHeight:200}).animate({left:left,top:top,width:width,height:height},300);
	
	box.close = function(){
		
		jQuery(box).animate({width:0,height:0,left:winWidth/2,top:winHeight/2},300,function(){jQuery(this).remove();jQuery("#maskbox").hide();});
//		jQuery(box).remove();
	}
	jQuery(box).find(".close-icon").click(function(){
		box.close();
	});
	var contentBox = document.createElement("div");
	contentBox.id= "popContent";
	box.appendChild(contentBox)
	if(contentFun&&typeof(contentFun)==="function"){
		contentFun.call(window,box);
	}
}
function setRankValue(name){
	if(currentObj){
		currentObj.value = name;
		currentObj = null;
	}
}
function openSubIGCOM0303ForER(id,eiid){
	var url = "IGDRM0430_Disp.do?flag=open&id="+id+"&eiid="+eiid;
	window.showModalDialog(url,null,"dialogWidth:1100px;dialogHeight:600px;status:no;help:no;resizable:yes");
}
//点击切换主备按钮调用方法
function switchMaster(prid){
	//流程prid
	jQuery.ajax({
		url:getAppRootUrl()+"/IGDRM0110_SwitchMaster.do",
		data:{prid:prid},
		async : true,
		type:"POST",
		dataType :"text",
		//成功回调函数
		success:function(obj){
				alert(obj);
			}
		});
	
}
