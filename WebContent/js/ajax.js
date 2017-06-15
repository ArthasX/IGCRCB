var http_request = false;
function sendRequest(url) {
	http_request = false;
	if(window.XMLHttpRequest) {
		http_request = new XMLHttpRequest();
		if (http_request.overrideMimeType) {
			http_request.overrideMimeType('text/xml');
		}
	}
	else if (window.ActiveXObject) {
		try {
			http_request = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
			try {
			 http_request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {}
		}
	}
	if (!http_request) {
		window.alert("不能创建XMLHttpRequest对象实例.");
		return false;
	}
	//alert('url is ' + url);
	http_request.onreadystatechange = function(){processRequest();};
	http_request.open("GET", url, true);
	http_request.send(null);
}
function processRequest() {
	if (http_request.readyState == 4) {
		if (http_request.status == 200) {
			eval(http_request.responseText);
		} else {
			//alert("您所请求的页面有异常。");
		}
	}
}
function ajaxLoadPage(url,request,method)
{
	method=method.toUpperCase();	
	if (method=='GET')
	{
		urls=url.split("?");
		if (urls[1]=='' || typeof urls[1]=='undefined')
		{
			url=urls[0]+"?"+request;
		}
		else
		{
			url=urls[0]+"?"+urls[1]+"&"+request;
		}
		
		request=null;//for GET method,loader should send NULL
	}
	var loader=new XMLHttpRequest;
	loader.open(method,url,true);
	if (method=="POST")
	{
		loader.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	}
	loader.onreadystatechange=function(){
		if (loader.readyState==4)
		{
			eval(loader.responseText);
		}
	}
	loader.send(request);
}
function getFullURL(url,form_obj)
{
	request = formToRequestString(form_obj);
	urls=url.split("?");
	if (urls[1]=='' || typeof urls[1]=='undefined')
	{
		url=urls[0]+"?"+request;
	}
	else
	{
		url=urls[0]+"?"+urls[1]+"&"+request;
	}
	return url;
}
function formToRequestString(form_obj)
{
    var query_string='';	
	for (var i = 0; i < form_obj.elements.length; i++) {
        var el = form_obj.elements[i];
        if (el.tagName.toLowerCase() == "select") {
            for (var j = 0; j < el.options.length; j++) {
                var op = el.options[j];
                if (op.selected)
                    query_string += "&" + encodeURIComponent(el.name) + "=" + encodeURIComponent(op.value);
            }
        } else if (el.tagName.toLowerCase() == "textarea") {
            query_string += "&" + encodeURIComponent(el.name) + "=" + encodeURIComponent(el.value);
        } else if (el.tagName.toLowerCase() == "input") {
            if (el.type.toLowerCase() == "checkbox" || el.type.toLowerCase() == "radio") {
                if (el.checked)
                    query_string += "&" + encodeURIComponent(el.name) + "=" + encodeURIComponent(el.value);
            } else if (el.type.toLowerCase() == "submit") {
                if (el == submitButton)
                    query_string += "&" + encodeURIComponent(el.name) + "=" + encodeURIComponent(el.value);
            } else if (el.type.toLowerCase() != "button") {
                query_string += "&" + encodeURIComponent(el.name) + "=" + encodeURIComponent(el.value);
            }
        }
    }	
    return query_string.substring(1,query_string.length);
}
function ajaxFormSubmit(form_obj)
{
	ajaxLoadPage(form_obj.getAttributeNode("action").value,formToRequestString(form_obj),form_obj.getAttributeNode("method").value)
}
