/**
* ǰ̨JS��ҳ���
* author:ZhangYu
* �÷���1.��ҳ������js;2.�ڴ���ҳ��table���棬ֱ��������´��롣
* var pc = new Pagination('pc','pageBarSpanId','theTableId',tableHeaderNum,rsCount,rsPerPage,before8afterPageNum);
*/
var curPageNum_ = 1;
/*
* pcVarName,�����ҳ�������������
* containerId�����ڷ��÷�ҳspan��ID
* tableId������ҳtable��ID
* tableHeaderNum������ҳtable��Header������
* recCount_����¼����
* recPerPage_��ÿҳ��ʾ�ļ�¼��
* pageNum����ѡ��ҳ��ǰ��������ʾ�ķ�ҳ��ĸ���
*/
function Pagination(pcVarName,containerId,tableId,tableHeaderNum,recCount_,recPerPage_,pageNum)
{
	/**********************��ʼ����ʾ����*********************/
	this.currPageFont1_ = "ҳ��:<font color='red'>";
	this.currPageFont2_ = "</font>/";	
	this.pageCountFont1_ = "<font color='red'>";
	this.pageCountFont2_ = "</font>ҳ&nbsp;";
	this.prePageFont1_ = "&nbsp;ÿҳ<font color='red'>";
	this.prePageFont2_ = "</font>��&nbsp;";	
	this.recCountFont1_ = "&nbsp;��<font color='red'>";
	this.recCountFont2_ = "</font>����¼&nbsp;&nbsp;";
	this.firstFont_ = "��ҳ";
	this.prevFont_ = "��һҳ";
	this.nextFont_ = "��һҳ";	
	this.lastFont_ = "βҳ";	
	this.jump_ = "&nbsp;&nbsp;��ת:";
	this.pageNumFont1_ = "<font color='red'>";
	this.pageNumFont2_ = "</font>";
	this.pageNumFont3_ = "[<font color='red'>";
	this.pageNumFont4_ = "</font>]";
	
	this.pageURL_ = '?p=param1&';		
	this.firstPageUrl_;
	this.prevPageUrl_;
	this.nextPageUrl_;
	this.lastPageUrl_;
	
	this.tableObj = document.getElementById(tableId);
	this.containerObj = document.getElementById(containerId);	
	this.varName = pcVarName;
	this.tableHeaderNum_ = tableHeaderNum;
	this.pageNum_ = pageNum;
	
	//��ǰҳ
	this.currPage_ = 1;
	//��ǰҳ��ʼ��¼
	this.pageStart_;
	//��ǰҳ��ֹ��¼
	this.pageEnd_;
	//�ܼ�¼��
	this.recCount_ = recCount_;
	//ÿҳ��ʾ��¼��
	this.recPerPage_ = recPerPage_;
	//������ҳ
	this.pageCount_;	
	
	var prevpage;
	var nextpage;
   	
	this.init();
	this.printHtml();
}
Pagination.prototype.printHtml = function()
{
	if (this.recCount_%this.recPerPage_==0) {
		this.pageCount_=this.recCount_/this.recPerPage_;
	}
	else {
		this.pageCount_=(parseInt(this.recCount_/this.recPerPage_)+1);
	}
	if (this.pageCount_<=1) {
		this.pageCount_=1
	}
	prevpage=parseInt(this.currPage_-1);
	if (prevpage<1) {
		prevpage=1;
	}
	nextpage=parseInt(this.currPage_+1)
	if (nextpage>this.pageCount_) {
		nextpage=this.pageCount_;
	}
	if (this.currPage_<=1&&this.pageCount_==1) {
		this.currPage_=1;
		this.firstPageUrl_="&nbsp;"+this.firstFont_+"&nbsp;";
		this.prevPageUrl_="&nbsp;"+this.prevFont_+"&nbsp;";
		this.nextPageUrl_="&nbsp;"+this.nextFont_+"&nbsp;";
		this.lastPageUrl_="&nbsp;"+this.lastFont_+"&nbsp;";
	}
	else if (this.currPage_<=1) {
		this.currPage_=1;
		this.firstPageUrl_="&nbsp;"+this.firstFont_+"&nbsp;";
		this.prevPageUrl_="&nbsp;"+this.prevFont_+"&nbsp;";
		this.nextPageUrl_="&nbsp;<A href=\"javascript:"+this.varName+".goToPage("+nextpage+")\">"+this.nextFont_+"</A>&nbsp;";
		this.lastPageUrl_="&nbsp;<A href=\"javascript:"+this.varName+".goToPage("+this.pageCount_+")\">"+this.lastFont_+"</A>&nbsp;";
	}
	else if (this.currPage_>=this.pageCount_) {
		this.currPage_=this.pageCount_;
		this.firstPageUrl_="&nbsp;<A href=\"javascript:"+this.varName+".goToPage(1)\">"+this.firstFont_+"</A>&nbsp;";
		this.prevPageUrl_="&nbsp;<A href=\"javascript:"+this.varName+".goToPage("+prevpage+")\">"+this.prevFont_+"</A>&nbsp;";
		this.nextPageUrl_="&nbsp;"+this.nextFont_+"&nbsp;";
		this.lastPageUrl_="&nbsp;"+this.lastFont_+"&nbsp;";
	}	  
	else {
		this.currPage_=this.currPage_;	   
		this.firstPageUrl_="&nbsp;<A href=\"javascript:"+this.varName+".goToPage(1)\">"+this.firstFont_+"</A>&nbsp;";
		this.prevPageUrl_="&nbsp;<A href=\"javascript:"+this.varName+".goToPage("+prevpage+")\">"+this.prevFont_+"</A>&nbsp;";
		this.nextPageUrl_="&nbsp;<A href=\"javascript:"+this.varName+".goToPage("+nextpage+")\">"+this.nextFont_+"</A>&nbsp;";
		this.lastPageUrl_="&nbsp;<A href=\"javascript:"+this.varName+".goToPage("+this.pageCount_+")\">"+this.lastFont_+"</A>&nbsp;";
	}
	if (this.currPage_-this.pageNum_<=1) {
		this.pageStart_=1;
	}
	else {
		this.pageStart_=this.currPage_-this.pageNum_;
	}
	if (this.currPage_+this.pageNum_>=this.pageCount_) {
		this.pageEnd_=this.pageCount_;
	}
	else {
		this.pageEnd_=this.currPage_+this.pageNum_;
	}

	
	var theHtml = '';
 	theHtml=theHtml+this.currPageFont1_+this.currPage_+this.currPageFont2_+this.pageCountFont1_+this.pageCount_+this.pageCountFont2_+this.prePageFont1_;
  	theHtml=theHtml+this.recPerPage_+this.prePageFont2_+this.recCountFont1_+this.recCount_+this.recCountFont2_+this.firstPageUrl_+this.prevPageUrl_;
	var i;
  	for (i=this.pageStart_;i<=this.pageEnd_;i++) {
    	if (i==this.currPage_) {
      		theHtml=theHtml+"&nbsp;"+this.pageNumFont3_+i+this.pageNumFont4_+"&nbsp;";
    	} 
    	else {
	  		theHtml=theHtml+"&nbsp;<A href=\"javascript:"+this.varName+".goToPage("+i+")\">"+this.pageNumFont1_+i+this.pageNumFont2_+"</A>&nbsp;";
		}
  	}
  	theHtml=theHtml+this.nextPageUrl_+this.lastPageUrl_+this.jump_;
  	theHtml=theHtml+"<INPUT id='goToPageNum' type=\"text\" name=\"goToPageNum\" size=\"4\" maxlength=\"4\"><INPUT type=\"button\" value=\"Go\" name=\"goToPageNumBtn\" onclick=\"javascript:"+this.varName+".goToPage(document.getElementById('goToPageNum').value)\">";
	this.containerObj.innerHTML = theHtml;
}
Pagination.prototype.showTablePage = function()
{		
	var pageNum = this.currPage_;
	var objRows = this.tableObj.rows;
	var pageTotalCount = this.recPerPage_;
	this.hideTablePage();
	var startIndex = (pageNum-1)*pageTotalCount+1+this.tableHeaderNum_-1;
	var endIndex =  startIndex+pageTotalCount;
	for (i= startIndex;i < endIndex && i < objRows.length;i++)
	{
		objRows[i].style.display='';
	}	
	curPageNum_ = pageNum;
}
Pagination.prototype.hideTablePage= function()
{
	var pageNum = this.currPage_;
	var objRows = this.tableObj.rows;
	var pageTotalCount = this.recPerPage_;
	if (curPageNum_ == pageNum)return;
	var startIndex = (curPageNum_-1)*pageTotalCount+1+this.tableHeaderNum_-1;
	var endIndex =  startIndex+pageTotalCount;
	for (i= startIndex;i < endIndex && i < objRows.length;i++)
	{
		objRows[i].style.display='none';
	}
}
Pagination.prototype.getStartIndex=function()
{
	var pageTotalCount = this.recPerPage_;
	var result = (curPageNum_-1)*pageTotalCount+1+this.tableHeaderNum_-1;
	return result - this.tableHeaderNum_+1;
}
Pagination.prototype.getEndIndex=function()
{
	var result;
	var pageTotalCount = this.recPerPage_;
	var startIndex = (curPageNum_-1)*pageTotalCount+1+this.tableHeaderNum_-1;
	var endIndex =  startIndex+pageTotalCount;
	var objRows = this.tableObj.rows;
	if (objRows.length < endIndex)
	{
		result = objRows.length;
	}
	else{
		result = endIndex;
	}
	return result-this.tableHeaderNum_+1;
}
Pagination.prototype.init=function ()
{
	var headerNum = this.tableHeaderNum_;
	var objRows = this.tableObj.rows;
	for (j=headerNum;j < objRows.length;j++)
	{
		objRows[j].style.display='none';
	}
	this.showTablePage();
}
Pagination.prototype.goToPage=function(pageNum)
{
	if (!checkIsNumber(pageNum))
	{
		alert('����Ϊ�ջ������벻������!');
		return;
	}
	if (pageNum>this.pageCount_ || pageNum < 1)
	{
		alert('��������Ӧ��1��'+this.pageCount_+'֮��!');
		return;
	}
	this.currPage_ = pageNum;
	this.showTablePage();
	this.printHtml();
}
function checkIsNumber(num) {
	result = true;
  	str=""+num;
  	if (str.length>=1) {
    	mynum=parseInt(str);
    	if (isNaN(mynum)) {
			result = false;
    	}
  	}
	else{
		result = false;
	}	
	return result;
}
function checkCurPage(pc,checkBoxTagPrefix)
{
	var startIndex = pc.getStartIndex();
	var endIndex = pc.getEndIndex();
	for(i=startIndex; i< endIndex;i++)
	{
		var e = document.getElementById(checkBoxTagPrefix+i.toString());
		e.checked=true;
	}
}
function cancleCurPage(pc,checkBoxTagPrefix)
{
	var startIndex = pc.getStartIndex();
	var endIndex = pc.getEndIndex();
	for(i=startIndex; i< endIndex;i++)
	{
		var e = document.getElementById(checkBoxTagPrefix+i.toString());
		e.checked=false;
	}
}