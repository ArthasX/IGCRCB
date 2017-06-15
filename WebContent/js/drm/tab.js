function initTab(parent){
	parent.find(">.tabBox>ul>li").each(function(i,o){
		if(jQuery(this).hasClass("this")){
			jQuery(this).parent().parent().siblings(".tabContentGroup").children(".tabContent").each(function(n,t){
				if(i == n){
					jQuery(this).show();
					var _this = this;
					var prid = jQuery(this).attr("prid");
					if(prid){
						window.curPrid = prid;
						context = contextArray[prid];
						if(context == null){
							context = new WorkFlowContext(_this);
							context.onload = function(data){
								init(this);
								//发送按钮绑定
								jQuery(".sendbtn",_this).off().click(sendEvent);
								jQuery(".ckeckall",_this).off().click(chkAll);
								jQuery("#showLog",_this).off().click(showLog);
								if("WDC"==context.prtype){
									//应急指挥流程需要加载业务系统关联的预案和场景
									entityChange(data);
									if(data.prpdid+"002"==data.status){
										context.buttons.removeAll();
										}
								}else{
									//如果应急处置流程是关闭重新加载指挥流程
									if(data.prpdid+"002"==data.status){
										context.buttons.removeAll();
										var directContext ;
										for(var k in contextArray){
											if(k==data.prid){
												continue;
											}
											directContext = contextArray[k];
										}
										//删除处理按钮
										if(directContext){
											directContext.buttons.show();
										}
									}
								} 
								if(taskList.length>0){
									var len = taskList.length;
									for(var i=0;i<len;i++){
										var fn = taskList.pop();
										if(typeof fn ==="function"){
											fn.call(this);
										}
									}
								}
								
							};
							context.get(prid,"","");
							contextArray[prid] = context;
						}
					}
				}else{
					jQuery(this).hide();
				}
			});
		}
	});
}




/**
 * 添加应急处置工作台Tab
 * @param prid
 */
function addRecoverTab(prid,box){
	if(jQuery("li[data-prid='"+prid+"']").length==0){
		var _li = jQuery("#tabTit>ul>li:first");
		_li.after(_li.clone(true).attr("data-prid",prid).removeClass().text("应急处置工作台"));
		var _div = jQuery(box);
		_div.after(_div.clone(true).attr("prid",prid).data("emename","应急处置工作台").hide());
	}
}
/**
 * 发送按钮的点击事件
 * @param event
 */
function sendEvent(event){
	var $this = jQuery(this);
	var contentBox = $this.parent().prev().find("textarea");
	var content = contentBox.val();
	var trs = $this.parents("#crlBox").siblings(".statusList").find("tr:has(:checkbox:checked)");
	if("sms" == $this.data("sendtype")){
		if(!content){
			alert("短信内容不能为空!");
			return false;
		}else if(content.length>70){
			alert("短信内容不能多于70个字");
		}
		if(trs.length==0){
			alert("请勾选将要发的节点!");
			return false;
		}
		
		var userids = [];
		trs.each(function(i,t){
			var userid = jQ(t).data("userids");
			if(userid){
				userids = userids.concat(userid.split(","));
			}
		})
		//去重
		userids = unique(userids);
		
		if(userids.length==0){
			alert("选择的节点没有参与人,请重新选择!");
			return false;
		}
		
		jQuery.ajax({
			url:"IGDRM1010_Sms.do",
			 cache: false,
			data:{msg:content,userids:userids.toString()},
			type:"POST",
			dataType: "json",
			success:function(resultData){
				
				if(resultData.msg=="success"){
					alert("发送成功!");
					contentBox.val('');
				}
			}
		})
		
	}else{
		if(!content){
			alert("通知内容不能为空!");
			return false;
		}
		
		var prid = jQuery("li.this[data-prid]").data("prid");
		jQuery.ajax({
			url:"IGDRM1010_Notice.do",
			 cache: false,
			data:{msg:content,prid:prid},
			type:"POST",
			dataType: "json",
			success:function(resultData){
				if(resultData.msg=="success"){
					alert("发送成功!");
					contentBox.val('');
				}
			}
		})
		
	}
}
/**
 * 数据去重
 * @param arr
 * @returns {Array}
 */
function unique(arr) {
    var result = [], hash = {};
    for (var i = 0, elem; (elem = arr[i]) != null; i++) {
        if (!hash[elem]) {
            result.push(elem);
            hash[elem] = true;
        }
    }
    return result;
}

/**
 * 全选按钮点击事件
 * @param event
 */
function chkAll(event){
	var $this = jQuery(this);
	$this.parent().parent().siblings().find(":checkbox:enabled").prop("checked",$this.prop("checked"));
}

jQuery(document).ready(function(){
	jQuery(window).mask();
	jQuery(window).ajaxStart(function(){
		jQuery(this).mask();
	}).ajaxComplete(function(){
		if(!window.maskFlag)
		jQuery(this).unmask();
	});
	jQuery(".tabBox>ul>li").click(function(){
		if(!jQuery(this).hasClass("this")){
			jQuery(this).siblings(".this").removeClass("this");
			jQuery(this).addClass("this");
			initTab(jQuery(this).parent().parent().parent());
		}
	});
	initTab(jQuery(".tabBox>ul>li.this:first").parent().parent().parent());
});