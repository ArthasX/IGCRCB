<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<bean:define id="id" value="IGCOM9900" toScope="request" />
<bean:define id="title" value="内容比较" toScope="request" />
<!-- header1 -->
<script type="text/javascript" src="js/mergely/excanvas.js"></script>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/mergely/codemirror.js"></script>
<link type="text/css" rel="stylesheet" href="css/mergely/codemirror.css" />
<script type="text/javascript" src="js/mergely/mergely.js"></script>
<link type="text/css" rel="stylesheet" href="css/mergely/mergely.css" />

<!-- /header1 -->
<script type="text/javascript">
/*
 * Function ES5 extend
*/
if (!Function.prototype.bind) {
  	Function.prototype.bind = function (oThis) {
		if (typeof this !== "function") {
	  		// closest thing possible to the ECMAScript 5 internal IsCallable function
	  		throw new TypeError("Function.prototype.bind - what is trying to be bound is not callable");
		}

		var aArgs = Array.prototype.slice.call(arguments, 1), 
			fToBind = this, 
			fNOP = function () {},
			fBound = function () {
		  		return fToBind.apply(this instanceof fNOP && oThis
								 ? this
								 : oThis || window,
							   aArgs.concat(Array.prototype.slice.call(arguments)));
			};

		fNOP.prototype = this.prototype;
		fBound.prototype = new fNOP();

		return fBound;
  	};
}

/*
 * Object ES5 extend
*/
if (!Object.keys) {
	Object.keys = function(o) {
		if (o !== Object(o)) {
			throw new TypeError('Object.keys called on a non-object');
		}
		var k=[], p;
		for (p in o) {
			if (Object.prototype.hasOwnProperty.call(o,p)) {
				k.push(p);
			}
		}
		return k;
	};
}
	

        $(document).ready(function () {
			$('#compare').mergely({
				cmsettings: { readOnly: true },
				editor_width: '520px',
				height: 550,
				lhs: function(setValue) {
					setValue($('#a').text());
				},
				rhs: function(setValue) {
					setValue($('#b').text());
				}
			});
		});
	</script>
<body>
	<div id="mergely-resizer" style="margin-left: 30px">
		<div id="compare">
		</div>
		</div>
	</div>
	<pre id="a" style="display: none">${a}</pre>
	<pre id="b" style="display: none">${b}</pre>
</body>
</html:html>
