/*============================
	Author : fason ����
	Email		: fason_pfx@hotmail.com
============================*/

var Icon = {
	root :	"treeview/root.gif",
	folderopen :  "treeview/folderopen.gif",
	folderclosed :  "treeview/folderclosed.gif",
	Rminus:	  "treeview/Rminus.gif",
	Rplus:	 "treeview/Rplus.gif",
	minusbottom:	   "treeview/Lminus.gif",
	plusbottom:	  "treeview/Lplus.gif",
	minus:	 "treeview/minus.gif",
	plus:	 "treeview/plus.gif",
	join:	 "treeview/T.gif",
	joinbottom:	 "treeview/L.gif",
	blank:	 "treeview/blank.gif",
	line:	 "treeview/I.gif"
};

window.TV = [];
function TreeView()
{
	this.id = window.TV.length;
	window.TV[this.id] = this;
	this.target = "_self";
	this.checkbox = false;
	this.Nodes ={ '0' : { ID : '0', ParentID : '-1', Text : null, Href : null, Image : null, childNodes: new Array() } };
}
var tv = TreeView.prototype;
tv.setTarget = function(v) {
	this.target = v;
};
tv.setCheckbox = function(v) {
	this.checkbox = v;
};
tv.setName = function(v) {
	this.name = v;
};
tv.setImagePath = function(sPath) {
	for(o in Icon){
		tmp = sPath + Icon[o];
		Icon[o] = new Image();
		Icon[o].src = tmp;
	}
};
tv.add = function(iD,ParentiD,sText,sHref,sImage) {
	this.Nodes[iD] = { ID : iD, ParentID : ParentiD, Text : sText, Href : sHref, Image : sImage , childNodes: new Array() , open : false , checked : false };
	var ch = this.getNode(ParentiD).childNodes;
	ch[ch.length] = this.Nodes[iD];
};
tv.getNode = function(sKey) {
	if (typeof this.Nodes[sKey] != "undefined")
	{
		return this.Nodes[sKey];
	}
	return null;
};
tv.getParentNode = function(ID) {
	var key = this.getNode(ID).ParentID;
	if(this.getNode(key) == null) return null;
	return this.getNode(key);
}
tv.hasChildNodes = function(sKey) {
	return this.getNode(sKey).childNodes.length > 0;
};
tv.isLastNode = function(sKey) {
	var node = this.getNode(sKey);
	var par = this.getParentNode(sKey);
	if(par == null) node.isLast = true;
	else if (typeof node["isLast"] == "undefined") {
		for(var i = 0;i<par.childNodes.length;i++)
			if(par.childNodes[i].ID == sKey) break;
		node.isLast =  (i == par.childNodes.length-1)
	}
	return node.isLast;
};
tv.getRoot = function(ID) {
	var par = this.getParentNode(ID);
	if (this.getNode(ID).ParentID == 0)
	{
		return this.getNode(ID);
	}
	else
	{
		return this.getRoot(par.ID);
	}
}
tv.drawNode = function(ID) {
	var html = "";
	var node = this.getNode(ID);
	var rootid = this.getRoot(ID).ID;
	var hc = this.hasChildNodes(ID);
	var isRoot = rootid == ID;
	var parentId = this.getParentNode(ID).ID;
	var isMainNode = rootid == parentId;
	
	html += '<div class="TreeNode" nowrap>'+this.drawIndent(ID)+
				//'<a id="node'+ID+'" class="Anchor" href="'+node.Href+'" target="'+this.target+'" onclick ="window.TV['+this.id+'].openFolder('+ID+')" ondblclick="window.TV['+this.id+'].openHandler('+ID+')"><img id="folder'+ID+'" src="'+( node.Image ? node.Image : Icon.folderclosed.src)+'" align="absmiddle">'+
				'<a id="node'+ID+'" class="Anchor" ondblclick="window.TV['+this.id+'].openHandler('+ID+')"><img id="folder'+ID+'" src="'+( node.Image ? node.Image : Icon.folderclosed.src)+'" align="absmiddle">'+
				(!isRoot&&!isMainNode ? ('<input type=checkbox id="checkbox'+ID+'" name="'+this.name+'" onclick="window.TV['+this.id+'].oncheck('+ID+')">') : '')+				
				//(this.checkbox ? ('<input type=checkbox id="checkbox'+ID+'" name="'+this.name+'" onclick="window.TV['+this.id+'].oncheck('+ID+')">') : '')+
				//(!hc ? ('<input type=checkbox id="checkbox'+ID+'" name="'+this.name+'" onclick="window.TV['+this.id+'].oncheck('+ID+')">') : '')+
				'<span>'+ node.Text +'</span></a></div>\n'
	if (hc) {
		var io = ID ==  rootid;
		node.open = io;
		html += ('<div id="container'+ID+'" style="display:'+(io ? '' : 'none')+'">\n');
		html += this.addNode(ID);
		html += '</div>\n';
	}
	return html;
}

tv.addNode = function(ID) {
	var node = this.getNode(ID);
	var html = "";
	for(var i = 0;i<node.childNodes.length;i++)
		html += this.drawNode(node.childNodes[i].ID);
	return html;
}

tv.drawIndent = function(ID) {
	var s = ''
	var ir = this.getRoot(ID).ID == ID;
	var hc = this.hasChildNodes(ID);
	if(this.getParentNode(ID) != null)
		s += ((hc ? '<a href="javascript:void window.TV['+this.id+'].openHandler('+ID+');" target="_self">':'')+'<img id="handler'+ID+'" src="'+ (this.hasChildNodes(ID) ? (ir ? Icon.Rminus.src : (this.isLastNode(ID) ? Icon.plusbottom.src : Icon.plus.src)) : (ir ? Icon.blank.src : (this.isLastNode(ID) ? Icon.joinbottom.src : Icon.join.src))) + '" align="absmiddle">'+(hc?'</a>':''));
	var p = this.getParentNode(ID);
	while(p != null)
	{
		if(this.getParentNode(p.ID) == null)break;
		s = ('<img src="'+(this.isLastNode(p.ID) ? Icon.blank.src : Icon.line.src) + '" align="absmiddle">')+s;
		p = this.getParentNode(p.ID);
	}
	return s;
}
tv.setSelected = function(ID) {
	if(this.selectedID) { document.getElementById("node" + this.selectedID).className = "Anchor";}
	this.selectedID = ID;
	document.getElementById("node" + ID).className = "selected";
}
tv.oncheck = function(ID) {
	var o = this.getNode(ID);
	var v = o.checked;
	o.checked = document.getElementById("checkbox" + ID).checked;
	//this.checkChildren(ID,o.checked);
	this.checkParent(ID);
};
tv.check = function(ID,v){
	if (document.getElementById("checkbox" + ID)){
		this.getNode(ID).checked = v;	
		document.getElementById("checkbox" + ID).checked = v;	
	}	
}
tv.checkChildren = function(ID,v){
	var ch = this.getNode(ID).childNodes;
	for(var i = 0;i<ch.length;i++){
		this.check(ch[i].ID,v);
		this.checkChildren(ch[i].ID,v);
	}
}
tv.checkParent = function(ID) {
	var par = this.getParentNode(ID);
	if(ID != this.getRoot(ID).ID){
		/*
		for(var j = 0;j<par.childNodes.length;j++)
			if(!par.childNodes[j].checked) break;
		this.check(par.ID,(j == par.childNodes.length));*/
		this.check(par.ID,true)
		this.checkParent(par.ID);
	}
}

tv.openHandler = function(ID) {
	if (this.hasChildNodes(ID)) {
		if (this.getNode(ID).open) {
			this.collapse(ID);
		}
		else {
			this.expand(ID);
		}
	}
}
tv.expand = function(ID) {
	var handler = document.getElementById("handler"+ID);
	var container = document.getElementById("container"+ID);
	handler.src = this.getRoot(ID).ID == ID ? Icon.Rminus.src : ( this.getNode(ID).isLast ? Icon.minusbottom.src : Icon.minus.src);
	container.style.display = '';
	this.getNode(ID).open = true;
}
tv.collapse = function(ID) {
	var handler = document.getElementById("handler"+ID);
	var container = document.getElementById("container"+ID);
	handler.src = this.getRoot(ID).ID == ID ? Icon.Rplus.src : ( this.getNode(ID).isLast ? Icon.plusbottom.src : Icon.plus.src);
	container.style.display = 'none';
	this.getNode(ID).open = false;
}
tv.openFolder = function(ID)
{
	if(this.selectedID){ 
		if(this.getNode(this.selectedID).Image == null) {document.getElementById("folder"+this.selectedID).src = Icon.folderclosed.src;}
	}
	var folder = document.getElementById("folder" + ID);
	if(this.getNode(ID).Image == null) folder.src = Icon.folderopen.src;
	this.setSelected(ID);
	this.selectedID = ID;
	folder.parentNode.blur();
}
tv.toString = function() {
	return this.addNode(0);
}

function fillId8Name(idTag,nameTag,form,actonName,action)
{
	var chk = tree.Nodes;
	var tempId = '';
	var tempName = '';	
	for(var o in chk) {
		if(chk[o].checked){
			tempId=tempId+','+chk[o].ID;
			tempName=tempName+','+chk[o].Text;
		}
	}
	if(tempId.length > 0)
	{
		$(idTag).value=tempId.substring(1,tempId.length);
		$(nameTag).value=tempName.substring(1,tempName.length);
	}
	doSubmit(form,actonName,action);
}