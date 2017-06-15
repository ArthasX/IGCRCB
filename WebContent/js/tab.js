/**********************************************************************
* 填写Tab标签的表头名称
* @param isfocus            是否显示该tab，1或者0，1：标征选中，0表征不选中
* @param caption            tab标签的上表头标题
* @param divId              tab标签表头的div的id
**********************************************************************/
function wrTabHeader(isfocus,caption,divId){
	if(isfocus=='1'){
		var inHtml = "<table height='26' border='0' cellpadding='0' cellspacing='0'><tr><td><img id='"+divId+"_Img01' src='images/tab/tab0_01.gif' width='6' height='26'></td><td style='cursor:pointer;background:url(images/tab/tab0_02.gif)' id='"+divId+"_Td02' height='26' nowrap>"+caption+"</td><td><img id='"+divId+"_Img03' src='images/tab/tab0_03.gif' width='13' height='26'></td></tr></table>";
		//alert(divId+' inHtml is ' + inHtml);		
		document.getElementById(divId).innerHTML = inHtml;
	}
	if(isfocus=='0'){
		var inHtml = "<table height='26' border='0' cellpadding='0' cellspacing='0'><tr><td><img id='"+divId+"_Img01' src='images/tab/tab_01.gif' width='6' height='26'></td><td style='cursor:pointer;background:url(images/tab/tab_02.gif)' id='"+divId+"_Td02' height='26' nowrap>"+caption+"</td><td><img id='"+divId+"_Img03' src='images/tab/tab_03.gif' width='13' height='26'></td></tr></table>";
		//alert(divId+' inHtml is ' + inHtml);
		document.getElementById(divId).innerHTML = inHtml;
	}
}
/**********************************************************************
* 更改选中标签
* @param containerId       用于放置所有tab标签头的div的id
* @param curObj            当前tab标签标头的对象，调用的是传this即可
**********************************************************************/
function changTab(containerId,curObj)
{
	var containerDiv = document.getElementById(containerId);
	var children = containerDiv.children;
	var focusDivId = curObj.id;	
	var count = children.length;
	//alert('count is ' + count);
	for (var i= 0;i < count;i++)
	{
		var childId = children[i].id;
		//alert('childId is ' + childId);
		if(childId){
			if (childId == focusDivId){
				children[i].className = 'newarticle1';
				document.getElementById(childId+'_Img01').src='images/tab/tab0_01.gif';
				document.getElementById(childId+'_Td02').style.background='url(images/tab/tab0_02.gif)';
				document.getElementById(childId+'_Img03').src='images/tab/tab0_03.gif';
				
				var contentId = childId.substring(0,childId.toString().length-2);
				document.getElementById(contentId).style.display = 'block';		 
				//alert('contentId is ' + contentId);
			}
			else{
				children[i].className = 'newarticle2';
				document.getElementById(childId+'_Img01').src='images/tab/tab_01.gif';
				document.getElementById(childId+'_Td02').style.background='url(images/tab/tab_02.gif)';
				document.getElementById(childId+'_Img03').src='images/tab/tab_03.gif';
				
				var contentId = childId.substring(0,childId.toString().length-2);
				//alert('contentId is ' + contentId);
				document.getElementById(contentId).style.display = 'none';
			}			
		}		
	}	
}
/**********************************************************************
* 一般用于设置默认的选中的标签页
* @param containerId       用于放置所有tab标签头的div的id
* @param curObj            当前tab标签标头的对象，可以通过document.getElementById('someTabHeaderDivId')
**********************************************************************/
function setFocusTab(containerId,focusObj)
{
	changTab(containerId,focusObj);
}