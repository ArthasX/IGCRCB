var taskList = [];
/** 声明核心程序对象 */
var WorkFlowContext = function(box){
	
	/** 流程定义ID */
	this.pdid = null;
	
	/** 容器对象 */
	this.box = box;
	
	/** 标识ID */
	this.id = 0;
	
	/** 处理用户ID */
	this.userid = "";
	
	/** 处理角色ID */
	this.roleid = 0;
	/**流程类型**/
	this.prtype="";
	
	/** 处理节点 */
	this.status = "";
	
	/** 标题对象 */
	this.title = new WorkFlowContext.NotHasValueObject("titlename",box);
	
	/** 流程开始时间 */
	this.startTime = new WorkFlowContext.NotHasValueObject("startTime",box,this); 
	
	/** 运行时长 */
	this.usedTime = new WorkFlowContext.NotHasValueObject("usedTime",box,this);
	
	/** 结束时间 */
	this.endTime = new WorkFlowContext.NotHasValueObject("endTime",box,this);
	
	/** 表单信息 */
	this.forms = new WorkFlowContext.Forms(this);
	
	/** 按钮信息 */
	this.buttons = new WorkFlowContext.Buttons(this);
	
	/** 处理记录 */
//	this.record = new WorkFlowContext.Record();
	
	/** 状态信息 */
	this.statuses = new WorkFlowContext.Statuses(this);
	
};

WorkFlowContext.Statuses = function(parent){
	
	this.tb = jQuery(parent.box).find("#statusContent")[0];
	this.condBox = 	jQuery(parent.box).find(".statusBox");

	
	this.dataIndex = [];
	var $this = this;
	this.parent = parent;
	
	var statuses = new Array();
	
	this.load = function(json){
		//应急指挥流程工作台时隐藏(预计时间)相关列
		if(parent.prtype=="WDC"){
			jQuery(parent.box).find(".eme").hide();
		}else{
			jQuery(parent.box).find(".eme").show();
		}
		$this.dataIndex = [];
		jQuery(this.tb).find("th[data-name]:visible").each(function(i,t){
			$this.dataIndex.push(jQuery(t).data("name"));
		});
		this.removeAll();
		
		//清空当前状态下拉列表
		var prstatusSel = jQuery("#prstatus",parent.box);
		prstatusSel.empty();
		
		if(json){
			for(var i=0;i<json.length;i++){
				this.add(json[i]);
			}
		}
		
		//如果当前状态选择下拉列表是空则隐藏
		if(!(prstatusSel.children().length>1)){
			prstatusSel.parent().hide();
		}else{
			prstatusSel.parent().show();
			prstatusSel.val(parent.status);
			prstatusSel.off().on("change",function(event){
//				parent.status = jQuery(this).val();
				parent.get(parent.id,null,jQuery(this).val())
			});
		}
		
	};
	
	this.removeAll = function(){
		$this.condBox.find("select[data-filter]:not(:last)>option[value]").remove();
		var len = this.tb.rows.length;
		for(var i=1;i<len;i++){
			this.tb.deleteRow(1);
		}
	};
	
	this.add = function(data){
		var status = new WorkFlowContext.Status(data,$this);
		statuses[statuses.length] = status;
	};
	
};

/**
 * 绑定状态列表(节点信息)的过滤条件的change事件
 */
WorkFlowContext.Statuses.prototype.bindFilter = function(){
	//条件下拉列表绑定事件
	var _this = this;
	
	_this.condBox.find("select[data-filter]").off("change").on("change",function(event){
		
		//定义查询条件集合
		var condMap = {};
		_this.condBox.find("select[data-filter]").each(function(i,t){
			if(jQuery(t).val())
				condMap[jQuery(t).data("filter")] = jQuery(t).val();
		});
		//遍历数据行 根据条件集合过滤显示列
			_this.condBox.next().find("tr:not(:first)").addClass("hide").each(function(i,t){
			var _t = jQuery(t);
			var showFlag = true;
			for(var k in condMap){
				if("status"==k){
					
					//未完成状态 >>>>隐藏已完成的状态的日志
					if("undone" == condMap[k]){
						if(_t.hasClass('his')){
							showFlag = false;
						}
					}else if(!_t.hasClass(condMap[k])){
						//否则根据选择的状态过滤  如果日志状态与选择的不同则隐藏
						showFlag = false;
					}
				}else{
					if(_t.find("td[data-name='"+k+"']").text().indexOf(condMap[k])==-1){
						showFlag = false;
					}
					
				}
			}
			showFlag&&_t.removeClass("hide");
		});
		jQuery(".box").scrollTop(9999);
		this.blur();
		
	});
	
	//如果当前查询条件中有值则直接触发过滤事件 (一般只有<节点状态>条件有值)
	_this.condBox.find("select[data-filter]").each(function(i,t){
		if(jQuery(t).val()){
			jQuery(t).change();
		}
			
	});
};
WorkFlowContext.Status = function(data,parent){
	
	if(data.psdname=="关闭"){
		return;
	}
	var prstatusSel = jQuery("#prstatus",parent.parent.box);
	var box = parent.tb;
	var dataIndex= parent.dataIndex;
	var tr = box.insertRow(box.rows.length);
	tr.className="wait";
	var td = null;
	td = tr.insertCell(0);
	//如果是处置流程并且已经关闭则使用填写处置说明图标替换复选框
	if(parent.parent.prtype=="WDP"&&parent.parent.status==parent.parent.pdid+"002"){
		td.innerHTML = "<span >&nbsp;</span><span class='editIcon' data-psdid='"+data.psdid+"'></span>";
	}else{
		td.innerHTML = "<span >&nbsp;</span><input type=\"checkbox\" value=\""+data.psdid+"\" >";
	}
	
	var ftime = "",etime = "";
	
	// 遍历列头装载数据
	if(dataIndex){
		for(var i=0;i<dataIndex.length;i++){
			var indexName = dataIndex[i];
			td = tr.insertCell(i+1);
			if(indexName&&indexName.indexOf("_")>-1){
				var arg = indexName.split("_");
				td.innerHTML = compliteTime(data[arg[0]],data[arg[1]]);
			}else{
				
				if("people"==indexName||"psdname"==indexName){
					td.className = 'ellips';
					var text = data[dataIndex[i]]||'';
					
					if("people"==indexName&&data.stepMessageList){
						var newtext = "";
						for(var j=0;j<data.stepMessageList.length;j++){
							var tempMsg = data.stepMessageList[j];
							if("提交"==tempMsg.operate){
								newtext = tempMsg.dealPeople;
							}
						}
					}
					
					td.innerHTML = "<div >"+(newtext||text).replace(/、/g,",")+"</div>";
					td.title = (newtext||text).replace(/、/g,",");
				}else{
					td.innerHTML = data[dataIndex[i].replace(/、/g,",")]||'';
				}
				
			}
			jQuery(td).attr("data-name",indexName);
			
			//已完成和进行中的节点不能勾选发送短信
			//已完成的状态
			if(indexName=="factStartTime_factUseTime"&&td.innerHTML){
				tr.className = "his";
				jQuery(tr).find(":checkbox").prop("disabled","disabled");
			}else if(indexName=="factStartTime"&&td.innerHTML){
				//进行中的状态
				tr.className = "cur";
				jQuery(tr).find(":checkbox").prop("disabled","disabled");
				
				
				
			}
			//屏蔽复选框的事件冒泡
			jQuery(tr).find(":checkbox").css({cursor:"default"}).off().click(function(event){event.stopPropagation()});
			if(indexName=="factUseTime"){
				ftime = td.innerHTML;
			}
			if(indexName=="expectUseTime"){
				etime = td.innerHTML;
			}
			//装载过滤条件到下拉列表中的option
			var _selBox = jQuery(box).parent().prev().find("select[data-filter='"+indexName+"']:first");
			if(_selBox.length>0&&td.innerText){
				var curDataArr = td.innerText.split(",");
				for(var j=0;j<curDataArr.length;j++){
					if(_selBox.text().indexOf(curDataArr[j])==-1){
						_selBox.append(_selBox.find("option:first").clone().text(curDataArr[j]).val(curDataArr[j]));
					}
				}
			}
		}
		
	}
	
	//添加处置说明按钮点击事件
	jQuery(tr).find(".editIcon").click(function(event){ 
		showDesc(data.psdid);
		
		event.stopPropagation();
	});
	//装载当前状态到显示下拉列表中
	if(jQuery(tr).hasClass("cur")){
		prstatusSel.append("<option value ='"+data.psdid+"'>"+data.psdname+"</option>")
	}
	
	jQuery(tr).data({userids:data.userids,psdDesc:data.nodeStep});
	if(data.nodeStep){
		jQuery(tr).css({cursor:"pointer"}).off("click").on("click",function(event){showArea("处置说明",data.nodeStep,event)});
	}
	
	if(ftime&&etime){
		if(ftime>etime){
			jQuery(tr).find("span:first").addClass("icon").addClass("icon4");
		}
	}
	
};

function showArea(name, content,event){
	removeShowRlComment();
	if(content){
		event = event||window.event;
		//新激活图层
	    var newDiv = document.createElement("div");
	    newDiv.id = "rlshowvaluediv";
	    newDiv.style.top = (event.clientY + document.documentElement.scrollTop) + "px";
	    newDiv.style.left = (parseInt(document.body.scrollWidth) - 340) / 2 + "px"; // 屏幕居中
	    var str = "<div id='title'><div id='fountDiv'>"+name+"</div><div id='imgDiv' onclick='removeShowRlComment();'><img src='images/title-delete.gif' width='20' height='20'/></div></div>";
	    newDiv.innerHTML = str + "<div id='content'><pre>" + content + "</pre></div>";
	    document.body.appendChild(newDiv);   
	} 
}

function removeShowRlComment(){
	jQuery("#rlshowvaluediv").remove();
}

/**
 * 展示对象
 * @param id 对象标识
 */
WorkFlowContext.NotHasValueObject = function(id,box,parent){
	//目标对象
	this.target = jQuery(box).find("#" + id);
	
	this.parent = parent;
	
	this.setValue = function(val){
		if(!this.target.text())
		this.target.text(val);
	};
	this.run = function(){
		if(!window.timeBox){
			window.timeBox = {};
		}
		if(!window.timeBox[this.parent.id]){
			window.timeBox[this.parent.id] = this.target;
		}
			
		if(!window.dateThead){
			window.dateThead = setInterval(runTime, 1000); 
		}
		
	};
	this.stop = function(prid){
		
		if(window.timeBox&&window.timeBox[prid]){
			delete window.timeBox[prid];
		}
	}
};
/**
 * 时间走动方法
 */
function runTime(){
	for(var k in window.timeBox){
		var _targer = window.timeBox[k];
		var timeArr;
		var text = "";
		if(_targer.text().indexOf("天")>-1){
			timeArr  = _targer.text().split(" ")[1].split(":");
			text += _targer.text().split(" ")[0]+" ";
		}else{
			timeArr = _targer.text().split(":");
		}
		
		var d = new Date();
		d.setHours(timeArr[0], timeArr[1], timeArr[2]);
		d.setSeconds(d.getSeconds()+1);
		_targer.text(text+(d.getHours()>9?d.getHours():"0"+d.getHours())+":"+(d.getMinutes()>9?d.getMinutes():"0"+d.getMinutes())+":"+(d.getSeconds()>9?d.getSeconds():"0"+d.getSeconds()));
	}
}

/**
 * 表单信息
 * @param data 表单数据
 */
WorkFlowContext.Form = function(data,wapperBox){
	
	/** 标识ID */
	this.id = data.id;
	
	/** 表单名称 */
	this.name = data.name;
	
	/** 访问权限 */
	this.access = data.access;
	
	/** 必填标识 */
	this.required = data.required;
	
	this.wapper = wapperBox;
	
	this.hide = function(){
		
		jQuery(this.wapper).prev().andSelf().hide();
		
	}
	
	/**
	 * 获取表单值
	 */
	this.getValue = function(){
		return this.target.getValue();
	};
	
	this.getTarget = function(){
		return this.target ? this.target.target : null;
	};
	this.setValue = function(val){
		this.target.setValue && this.target.setValue(val);
	}
	
	if(data.type == "0" 
		|| data.type == "3"
		|| data.type == "7"
		|| data.type == "A"){
		this.target = new WorkFlowContext.Form.Text(data, this);
	}else if(data.type == "2"){
		this.target = new WorkFlowContext.Form.Select(data, this);
	}else if(data.type == "9"){
		this.target = new WorkFlowContext.Form.TextArea(data, this);
	}else if(data.type == "4"){
		this.target = new WorkFlowContext.Form.Asset(data,this);
	}else if(data.type == "B" || data.type == "C"){
		this.target = new WorkFlowContext.Form.Check(data, this);
	}else if(data.type == "P"){
		this.target = new WorkFlowContext.Form.Participant(data, this);
	}else if(data.type == "W"){
		this.target = new WorkFlowContext.Form.Select2(data,this);
	}else if(data.type == "F"){
		this.target = new WorkFlowContext.Form.Attachment(data,this);
	}else if(data.type == "8"){
		this.target = new WorkFlowContext.Form.Table(data,this);
	}
};

/**
 * 表格式表单
 */
WorkFlowContext.Form.Table = function(json,parent){
	
	/** 内容容器 */
	this.container = new Array();
	
	/**
	 * 获取值
	 * @returns {Array}
	 */
	this.getValue = function(){
		var result = new Array();
		for(var key in this.container){
			for(var title in this.container[key]){
				result.push(this.container[key][title]);
			}
		}
		return result;
	};
	
	var _this = this;
	
	this.writeTable = function(table,data){
		if(data){
			for(var rownum in data){
				var titleRow = null;
				if(rownum == "1"){
					titleRow = table.insertRow(0);
				}
				var tr = null;
				if(data[rownum]["流程节点id"].value){
					tr = table.insertRow(table.rows.length);
				}
				var index = 0;
				for(var key in data[rownum]){
					if(rownum == "1"){
						var title = titleRow.insertCell(titleRow.cells.length);
						title.innerHTML = key;
						if(index == 0){
							if(json.access == "3"){
								var checkTitle = titleRow.insertCell(0);
								jQuery(checkTitle).css({"width":"30px","text-align":"center"});
								var checkbox = document.createElement("input");
								checkbox.className = "checkbox";
								checkbox.setAttribute("type","checkbox");
								checkbox.setAttribute("name","selectAll");
								checkTitle.appendChild(checkbox);
								checkbox.onclick = function(){
									var c = this;
									var roleid = null;
									jQuery("[name='selectstatus']").each(function(n,t){
										if(t.disabled){
											t.checked = false;
										}else{
											var id = t.parentElement.parentElement.cells[3].innerText;
											if(roleid == null){
												roleid = id;
												t.checked = c.checked;
											}else{
												if(roleid == id){
													t.checked = c.checked;
												}else{
													t.disabled = c.checked;
												}
											}
										}
									});
								}
								title.style.width = "220px";
							}else{
								title.style.width = "250px";
							}
						}else if(index == 1){
							title.style.width = "420px";
						}else{
							title.style.display = "none";
						}
					}
					var value = data[rownum][key].value;
					var pidid = data[rownum][key].pidid;
					if(index == 0){
						if(json.access == "3" && tr){
							var check = tr.insertCell(0);
							jQuery(check).css({"width":"30px","text-align":"center"});
							var checkbox = document.createElement("input");
							checkbox.className = "checkbox";
							checkbox.setAttribute("type","checkbox");
							checkbox.setAttribute("name","selectstatus");
							checkbox.setAttribute("value",rownum);
							checkbox.onclick = function(){
								checkRoles(_this.container,this);
							};
							check.appendChild(checkbox);
						}
					}
					if(tr){
						var td = tr.insertCell(tr.cells.length);
						var content = new WorkFlowContext.Form.Table.Column(td,pidid,rownum);
						content.setValue(value);
						if(this.container[rownum] == null){
							this.container[rownum] = new Array();
						}
						this.container[rownum][pidid] = content;
						if(index > 1){
							td.style.display = "none";
						}
					}
					index ++;
				}
			}
		}
	};
	this.target = document.createElement("table");
	this.target.className = "table_form";
	this.writeTable(this.target,json.value);
	
	this.removeAll = function(){
		var len = this.target.rows.length;
		for(var i=1;i<len;i++){
			this.target.deleteRow(1);
		}
		this.container = new Array();
	}
};

WorkFlowContext.Form.Table.Column = function(parent,pidid,rownum){
	this.value = "";
	this.pidid = pidid;
	this.rownum = rownum;
	this.parent = parent;
	this.setValue = function(val){
		this.value = val;
		this.parent.innerHTML = val;
	}
};

/**
 * 附件类型表单
 * @param data
 * @param parent
 */
WorkFlowContext.Form.Attachment = function(data,parent){
	this.value ="";
	this.getValue = function(){
		return this.value;
	}
	this.target = document.createElement("div");
		//如果原来有值
	if(data.atts){
		for(var i=0;i<data.atts.length;i++){
			var div = document.createElement("div");
			this.target.appendChild(div);
			var file = document.createElement("a");
			div.appendChild(file);
			file.innerText = data.atts[i].attname.substring(data.atts[i].attname.indexOf("_") + 1);
			file.setAttribute("href","download.do?attId=" + data.atts[i].attid + "&type=svc");
				if(data.access == "3"){
					var delimg = document.createElement("img");
					delimg.setAttribute("style","cursor: pointer;");
					delimg.setAttribute("align","middle");
					delimg.src = "images/delate.gif";
					div.appendChild(delimg);
					delimg.onclick = function(){
						
					};
				}
		}
	}
	if(((!data.atts||data.atts.length==0)||data.rows==0)&&data.access=="3"){
		var fileBox = $("<input type='file' name='file' class='fileBox' multiple='multiple'>").get(0);
		this.target.appendChild(fileBox);
		
		$(this.target).delegate("img","click",function(){
			var _img = $(this);
			$.ajax({
				url:"IGDRM1010_Att.do",
				success:function(result){
					_img.parent().find(":input").show();
					_img.parent().find(":not(:input)").remove();
				}
			})
		});
		
		var url = 'IGDRM1010_Att.do';
		var _this = this;
		taskList.push(function(){
			$(".fileBox",_this.target).fileupload({
				url: url,
				dataType: 'json',
				done: function (e, data) {
					if(data.result&&data.result.msg=="success"){
						$(this).hide().after("<span>"+data.result.fileName+"</span><img align='middle'style='cursor: pointer;' src='images/delate.gif'>");
						_this.value=data.result.attKey;
					}
				}
			})
			.prop('disabled', !$.support.fileInput)
			.parent().addClass($.support.fileInput ? undefined : 'disabled');
		});
	}
};

WorkFlowContext.Form.Select2 = function(data,parent){
	this.target = document.createElement("select");
	this.target.className = "js-example-basic-single js-states form-control";
	this.target.style.width = "180px";
	if(data.value&&data.value.length>0){
		var opt = document.createElement("option");
		opt.innerHTML=data.value[0].einame;
		opt.value = data.id+"#"+data.value[0].eiid+"#"+data.value[0].eiversion;
		this.target.appendChild(opt);
		this.target.selectIndex = 0;
	}
	this.clean = function(){
		this.target.className = "js-example-basic-single js-states form-control";
		jQuery(this.target).empty().siblings().remove();;
	};
	this.getValue = function(){
		return this.target.value||jQuery(this.target).val();
	};
	if(data.access == "2"){
		this.target.setAttribute("disabled", "disabled");
		return;
	}
	this.target.onchange = function(){
		if(parent.onchange){
			parent.onchange();
		}
	};
};

/**
 * 资产表单
 * @param data 表单数据
 * @param parent 父级对象
 */
WorkFlowContext.Form.Asset = function(data,parent){
	this.url = "/IGCOM0302_Disp.do?pidid" + data.id + '&esyscoding=' + data.code;
	var table = document.createElement("table");
	table.className = "table";
	var tr = null;
	var td = null;
	var _this = this;
	this.access = data.access;
	var shows = new Array();
	
	this.getValue = function(){
		var str = "";
		var index = 0;
		for(var i=0;i<shows.length;i++){
			var eiid = shows[i].getAttribute("eiid");
			if(eiid){
				if(index > 0){
					str += "_sp_";
				}else{
					index ++;
				}
				str += data.id + "#" + eiid + "#" + 1;
			}
		}
		return str;
	};
	if(data.access == "3" && data.rows > 1){
		tr = table.insertRow(table.rows.length);
		td = tr.insertCell(0);
		td.innerHTML = "<img src='images/addasm.gif' border='0'/>添加资产";
		td.setAttribute("style","cursor: pointer;");
		td.onclick = function(){
			tr = table.insertRow(table.rows.length);
			td = tr.insertCell(0);
			var show = document.createElement("input");
			show.setAttribute("type","text");
			show.setAttribute("readOnly",true);
			show.style.width = "150px";
			td.appendChild(show);
			show.onclick = function(){
				currentObj = this;
				openSubWindow(_this.url , '', '850', '600');
			};
			shows[shows.length] = show;
			var img = document.createElement("img");
			img.src = "images/delate.gif";
			td.appendChild(img);
			img.onclick = function(){
				var index = this.parentElement.parentElement.rowIndex;
				table.deleteRow(index);
				shows.splice(index-1,1);
				entityChange();
			};
		};
	}
	if(data.value&&data.value.length>0){
		for(var i = 0 ;i<data.value.length;i++){
			
			tr = table.insertRow(table.rows.length);
			td = tr.insertCell(0);
			var show = document.createElement("a");
			show.style.width = "150px";
			if(data.value[i].dataStr){
				show.setAttribute("id", "1_"+data.value[i].dataStr);
				show.onclick = function(){openSubIGCOM0303ForER(this.id.split("_")[1],this.id.split("_")[2]);};
			}else{
				show.setAttribute("id", "1_"+data.value[i].rid);
				show.onclick = function(){
					openSubIGCOM0303ForER(1,this.getAttribute("eiid"));};
			}
			show.href="javascript:void(0);";
			show.setAttribute("eiid",data.value[i].eiid);
			show.innerText = data.value[i].einame;
			var eiversion = data.value[i].eiversion,eiid = data.value[i].eiid
			td.appendChild(show);
			shows[shows.length] = show;
			if(data.access=="2"){
				continue;
			}
			var img = document.createElement("img");
			img.src = "images/delate.gif";
			td.appendChild(img);
			img.onclick = function(){
				var index = this.parentElement.parentElement.rowIndex;
				table.deleteRow(index);
				shows.splice(index-1,1);
				entityChange();
			};
		}
		
	}else if(data.rows == "0" ){
		tr = table.insertRow(table.rows.length);
		td = tr.insertCell(0);
		var show = document.createElement("input");
		show.setAttribute("type","text");
		show.setAttribute("readOnly",true);
		show.style.width = "150px";
		if(data.value&&data.value.length>0){
			show.value = data.value[0].einame;
			show.setAttribute("eiid", "1_"+data.value[0].eiid);
		}
		
		td.appendChild(show);
		shows[shows.length] = show;
		if(data.access=="2"){
			this.target = table;
			return;
		}
		show.onclick = function(){
			currentObj = this;
			openSubWindow(_this.url , '', '850', '600');
		};
		var img = document.createElement("img");
		img.src = "images/delate.gif";
		td.appendChild(img);
		img.onclick = function(){
			$(this).prev().val('').removeAttr("eiid");
			entityChange();
		};
	}
	this.target = table;
};

/**
 * 人员表单
 */
WorkFlowContext.Form.Participant = function(data,parent){
	this.target = document.createElement("table");
	this.target.className = "table";
	var tr = this.target.insertRow(this.target.rows.length);
	var td = null;
	td = tr.insertCell(0);
	td.innerHTML = "姓名";
	td = tr.insertCell(1);
	td.innerHTML = "机构";
	td = tr.insertCell(2);
	td.innerHTML = "角色";
	td = tr.insertCell(3);
	td.innerHTML = "电话";
	if(data.value && data.value.length > 0){
		for(var i=0;i<data.value.length;i++){
			tr = this.target.insertRow(this.target.rows.length);
			td = tr.insertCell(0);
			td.innerHTML = data.value[i].piusername;
			td = tr.insertCell(1);
			td.innerHTML = data.value[i].piorgname;
			td = tr.insertCell(2);
			td.innerHTML = data.value[i].pirolename;
			td = tr.insertCell(3);
			td.innerHTML = data.value[i].piphone;
		}
	}
};

/**
 * 单选/复选
 */
WorkFlowContext.Form.Check = function(data,parent){
	var optionArray = new Array();
	this.target = document.createElement("div");
	if(data.options && data.options.length > 0){
		for(var i=0;i<data.options.length;i++){
			var span = document.createElement("span");
			var labelBox = document.createElement("span");
			var option = null;
			option = document.createElement("input");
			if(data.type == "B"){
				option.setAttribute("type", "radio");
			}else{
				option.setAttribute("type", "checkbox");
			}
			if(data.access=="2"){
				option.setAttribute("disabled", "disabled");
			}
			
			option.setAttribute("name", data.id);
			option.value = data.options[i].value;
			optionArray[optionArray.length] = option;
			option.value = (data.options[i].value);
			if(data.value&&data.options[i].value==data.value){
				option.setAttribute("checked", "checked");
			}
			span.className = 'chkBox';
			span.appendChild(option);
			labelBox.innerHTML = data.options[i].label;
			span.appendChild(labelBox);
			this.target.appendChild(span);
		}
	}
	this.getValue = function(){
		var str = "";
		var index = 0;
		for(var i=0;i<optionArray.length;i++){
			if(optionArray[i].checked){
				if(index > 0){
					str += "#";
				}else{
					index ++;
				}
				str += optionArray[i].value;
			}
		}
		return str;
	};
};

/**
 * 文本域
 */
WorkFlowContext.Form.TextArea = function(data,parent){
	this.target = document.createElement("div");
	if(data.rowwidth=="0"){
		this.target.className = "editDiv allRow";
	}else{
		this.target.className = "editDiv halfRow";
	}
	if(data.access == "3"){
		this.target.setAttribute("contentEditable",true);
	}
	this.target.onkeydown = function(){
		editDivContent(this);
	};
	this.target.innerHTML = data.value ? data.value : "";
	this.getValue = function(){
		var value = this.target.innerHTML;
		value = value.replace(/<\/P>/g,"_#_");
		value = value.replace(/<br>/g,"_#_");
		value = value.replace(/<BR>/g,"_#_");
	    value = value.replace(/<[^>]+>/g,"");
	    while(value.indexOf("_#_") >= 0){
	    	value = value.replace(new RegExp("_#_","gm"),"<br>");
	    }
		value = value.replace(new RegExp("&lt;","gm"),"<");
		value = value.replace(new RegExp("&gt;","gm"),">");
		value = value.replace(new RegExp("&nbsp;","gm")," ");
		value = value.replace(new RegExp("&apos;","gm"),"'");
		value = value.replace(new RegExp("&amp;","gm"),"&");
		return value;
	};
};

/**
 * 下拉列表
 */
WorkFlowContext.Form.Select = function(data,parent){
	this.target = document.createElement("select");
	this.target.setAttribute("name", "pivarvalue");
	if(data.options && data.options.length > 0){
		for(var i=0;i<data.options.length;i++){
			var option = new Option(data.options[i].label,data.options[i].value);
			if(data.options[i].value == data.value){
				option.selected = true;
			}
			this.target.options.add(option);
		}
	}
	if(data.access != "3"){
		this.target.disabled = true;
	}
	
	this.getValue = function(){
		return this.target.value;
	};
	
	this.target.onchange = function(){
		if(parent.onchange){
			parent.onchange();
		};
	};
};

/**
 * 文本框类型
 */
WorkFlowContext.Form.Text = function(data,parent){
	
	this.target = document.createElement("input");
	this.target.setAttribute("type", "text");
	this.target.setAttribute("name", "pivarvalue");
	//如果不存在可写权限，将文本框设置为只读
	var readOnly = true;
	if(data.access == "3" && (data.type == "0" || (data.type == "7"&&data.name!="恢复所需时间"))){
		readOnly = false;
	}
	if(readOnly){
		this.target.setAttribute("readOnly",true);
	}
	//设置表单值
	this.target.value = data.value ? data.value : "";
	//处理数字控件
	if(data.type == "7"){
		//禁止中文输入法
		this.target.setAttribute("style", "ime-mode:disabled");
		this.target.onkeydown = function(){
			return columnValueNumber();
		};
		/** 阻止粘贴 */
		this.target.onpaste = function(){return false;};
		
		/** 阻止中文输入 */
		this.target.ondragenter = function(){return false;};
		
		/** 阻止右键菜单 */
		this.target.oncontextmenu = function(){return false;};
	}else if(data.type == "3"){
		//日期控件
		if(data.access == "3"){
			this.target.id = data.id+"date";
			this.target.onclick = function(){
			
				jeDate({
					dateCell:this, 
					format:"YYYY/MM/dd",
					isTime:false, //isClear:false,
				})
			}
		}
	}else if(data.type == "A"){
		if(data.access == "3"){
			
			this.target.setAttribute("onClick","laydate({format: 'YYYY/MM/DD hh:mm:ss', istime: true})");
		}
	}
	
	this.getValue = function(){
		return this.target.value;
	};
	this.setValue = function(val){
		this.target.value = val;
	}
};

/**
 * 表单信息集合
 */
WorkFlowContext.Forms = function(parent){
	
	/** 页面容器 */
	var target = jQuery(parent.box).find("#formscontent")[0];
	
	var forms = new Array();
	
	var formkeys = new Array();
	
	var currentRow = null;
	
	this.length = function(){
		return formkeys.length;
	};
	
	this.load = function(json){
		//清空表单
		this.removeAll();
		//循环添加
		if(json && json.length > 0){
			for(var i=0;i<json.length;i++){
				this.add(json[i]);
			}
		}
	};
	
	/**
	 * 添加方法
	 */
	this.add = function(data){
		if(currentRow == null || data.rowwidth == "0"){
			currentRow = target.insertRow();
		}
		var th = document.createElement("th");
		th.innerHTML = data.name;
		currentRow.appendChild(th);
		var td = currentRow.insertCell(currentRow.cells.length);
		if(data.rowwidth == "0"){
			td.colSpan = 3;
		}
		var form = new WorkFlowContext.Form(data,td);
		if(form.getTarget()){
			td.appendChild(form.getTarget());
			formkeys[formkeys.length] = form.id;
			forms[form.id] = form;
			//隐藏当前 处理人 表单  王亮  2017年5月24日10:38:10
			if("处理人"==data.name){
//				form.hide();
			}
			
		}
		if(data.rowwidth == "0" || currentRow.cells.length == 4){
			currentRow = null;
		}
	};
	
	/**
	 * 获取表单对象
	 * @param key 表单KEY
	 */
	this.get = function(index){
		return forms[formkeys[index]];
	};
	
	/**
	 * 根据表单标识查找表单
	 * @param key 表单标识
	 * @returns 表单对象
	 */
	this.find = function(key){
		return forms[key];
	};
	
	this.findByName = function(name){
		for(var key in forms){
			if(forms[key] && forms[key].name == name){
				return forms[key];
			}
		}
		return null;
	};
	
	/**
	 * 移除方法
	 */
	this.removeAll = function(){
		var rows = target.rows.length;
		for(var i=1;i<rows;i++){
			target.deleteRow(1);
		}
		forms = new Array();
		formkeys = new Array();
	};
};

WorkFlowContext.Button = function(data,parent){

	/** 按钮标识ID */
	this.id = data.vbid;
	
	/** 按钮名称 */
	this.name = data.vbname;
	
	/** 按钮呈现对象 */
	this.target = document.createElement("button");
	
	/** 设置按钮显示名称 */
	this.target.value = data.vbname;
	
	this.target.innerHTML = data.vbname;
	
	this.target.className = "btn";
	
	var _this = this;
	
	this.target.onclick = function(){
		_this.click();
	};
	
	this.click = function(){
		
		
		var result = {};
		result.forms = {};
		for(var i=0;i<parent.forms.length();i++){
			var form = parent.forms.get(i);
			//只提交可写表单
			if(form && form.access == "3"){
				var formData = {};
				formData.value = form.getValue();
				
//				(form.name=="处置说明"&&(alert(">"+formData.value+"<"+("changdu"+formData.value.length))));
				
				
				
				if(form.required=="1"&&(!formData.value||(form.name=="处置说明"&&formData.value.length==0))){
					
					//应急时不校验处置说明必填
					if(window.prCategory!="1"&&form.name=="处置说明"){
					}else{
						
						alert(form.name+"不能为空!");
						return false;
					}
					
				}else{
					result.forms[form.id] = formData;
				}
				
			}
		}
		if(window.confirm("是否确认" + this.name + "?")){
			var param = {};
			param.prid = parent.id;
			param.userid = parent.userid;
			param.roleid = parent.roleid;
			param.status = parent.status;
			param.btnid = this.id;
			param.result = {};
			
			
			param.result = JSON.stringify(result);
			//如果有按钮js事件则执行，否则执行默认的提交
			if(data.vbacturl){
					eval(data.vbacturl+'('+parent.id+')');
			}else{
				jQuery.ajax({
					url:"IGDRM1010_Commit.do",
					type:"POST",
					dataType :"text",
					data:param,
					success:function(data){
						if(data == "success"){
							parent.get(parent.id);
						}
					}
				});
			}
			
		};
	};
};

/**
 * 按钮信息
 */
WorkFlowContext.Buttons = function(parent){
	
	this.buttons = new Array();
	
	this.parent = parent;
	
	this.target = jQuery(parent.box).find("#btnTd")[0];
	
	this.load = function(json){
		//清空原有按钮
		this.removeAll();
		if(!json)
			return;
		
		this.add({vbid:"01",vbname:"保存"});
		if(json && json.length > 0){
			for(var i=0;i<json.length;i++){
				this.add(json[i]);
			}
		}
	};
	
	this.find = function(name){
		return this.buttons[name];
	}
	
	this.add = function(data){
		var btn = new WorkFlowContext.Button(data,this.parent);
		this.buttons[btn.name] = btn;
		if(btn.target){
			this.target.appendChild(btn.target);
		}
	};
	
	this.removeAll = function(){
		this.target.innerHTML = " ";
		this.buttons = new Array();
	};
	this.show = function(){
		$(this.target).children().show();
	};
	this.hide = function(){
		$(this.target).children().hide();
		
	}
};

/**
 * 数据加载方法
 */
WorkFlowContext.prototype.get = function(prid,userid,status,fun){
	var _this = this;
	var param = {prid:prid,userid:userid,status:status};
	jQuery.ajax({
		url:"IGDRM1010_Ajax.do",
		type:"POST",
		dataType :"json",
		data:param,
		success:function(data){
			if(data){
				//设置标识ID
				if(data.prid){
					_this.id = data.prid;
				}
				if(data.prCategory||data.prCategory=="0"){
					_this.prCategory = data.prCategory;
					window.prCategory = data.prCategory;
				}
				//设置标题
				if(data.title){
					_this.title.setValue(data.title);
				}
				if(data.prtype){
					_this.prtype = data.prtype;
				}
				//设置处理用户ID
				if(data.userid){
					_this.userid = data.userid;
				}
				//设置处理角色ID
				if(data.roleid){
					_this.roleid = data.roleid;
				}
				
				//设置流程定义ID
				if(data.prpdid){
					_this.pdid = data.prpdid;
				}
				//设置开始时间
				if(data.prTime){
					_this.startTime.setValue(data.prTime.starttime);
					_this.endTime.setValue(data.prTime.endtime);
					_this.usedTime.setValue(data.prTime.usedtime);
					if(!data.prTime.endtime){
						_this.usedTime.run();
					}else{
						_this.usedTime.stop(data.prid);
					}
				}
				//设置表单
				if(data.pid && data.pid.length > 0){
					
					//如果是处置流程需要设置处置说明(自动赋值)
					//张剑 2017年6月2日14:11:51
					//常熟新增需求
				   setDesc:	if(data.prtype=="WDP"){
						for(var k in data.pid){
							var pidForm = data.pid[k];
							if("处置说明" == pidForm.name){
								for(var key in data.psdList.stepList){
									var _statusInfo = data.psdList.stepList[key];
									if(data.status == _statusInfo.psdid){
										pidForm.value = _statusInfo.nodeStep;
										break setDesc;
									}
								}
								
							}
							
						}
					}
					
					
					
					_this.forms.load(data.pid);
				}
				//设置节点信息
				if(data.status){
					_this.status = data.status;
				}
				if(data.hasProcessPower){
					//设置按钮
					_this.buttons.load(data.buttons);
					
				}else{
					_this.buttons.removeAll();
				}
				//设置节点信息
				if(data.psdList&&data.psdList.stepList && data.psdList.stepList.length > 0){
					_this.statuses.load(data.psdList.stepList);
					_this.statuses.bindFilter();
				}
				//添加关联的技术恢复流程
				if(data.cldPrid){
					addRecoverTab(data.cldPrid,_this.box);
					//判断技术恢复流程状态隐藏按钮
					if(data.status==data.prpdid+"007"&&data.cldPrStatus!="C"){
						_this.buttons.hide();
					}else{
						_this.buttons.show();
					}
				}
				//触发回调函数
				if(fun){
					fun();
				}
				//触发响应事件
				if(_this.onload){
					_this.onload(data);
				}
				//如果处理人下拉列表的用户id不是当前登录用户则隐藏保存、提交、中止按钮  王亮 2017年5月24日10:39:33
				if(data.loginid!=data.userid){
					//设置保存、提交、中止按钮隐藏
//					jQuery("button[value='保存']").hide();
//					jQuery("button[value='提交']").hide();
//					jQuery("button[value='中止']").hide();
				}
				
			}
		}
	});
};
var currentObj = null;
function setParamIGCOM0302(eid, elabel, ename, eiid, eilabel, einame , ecategory, pidid){
	if(currentObj){
		currentObj.value = einame;
		currentObj.setAttribute("eiid",eiid);
	}
}
function checkRoles(container,obj){
	var role = container[obj.value][context.pdid + "030"].value;
	var tb = obj.parentElement.parentElement.parentElement;
	if(obj.checked){
		for(var i=1;i<tb.rows.length;i++){
			var roleids = tb.rows[i].cells[3].innerText;
			if(roleids != role){
				tb.rows[i].cells[0].childNodes[0].disabled = true;
			}
		}
	}else{
		for(var i=1;i<tb.rows.length;i++){
			var roleids = tb.rows[i].cells[3].innerText;
			if(roleids != role){
				tb.rows[i].cells[0].childNodes[0].disabled = false;
			}
		}
	}
}

