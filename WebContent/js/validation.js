function isEmail(s)
{
    //检查是否合法Email格式
	if((s.indexOf('@', 0) == -1 )
		|| (s.indexOf('.', 0) == -1))
    {
      	return false;
    }
    return true;
}

function isCharacter(s)
{
	//检查是否英文字符串
	var i;
	var ichar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	for(i = 0;i < s.length;i++)
  	{
    	if (ichar.indexOf(s.charAt(i),0) == -1)
    	{
			return false;
		}
	}
	return true;
}

function isDigit (c)
{
	//检查一位是否数字
	return ((c >= "0") && (c <= "9"))
}

function isData(s)
{
    //检查是否是数字，负数，及带小数均认为正确
	var i;
    var seenDecimalPoint = false;
	if (s.length>0)
	{
    	if (s == "." || s == "-")
		{
	       	return false;
		}
		for (i = 0; i < s.length; i++)
	    {
	        if ((i == 0 ) &&(s.charAt(i) == ".")){return false;}
    	    if ((i == 0 ) &&(s.charAt(i) == "-")){ i++ ;}
	       	var c = s.charAt(i);
    	  	if ((c == ".") && !seenDecimalPoint)
	    	{	
				seenDecimalPoint = true;
			}
			else
    	   	{   
			 	if (!isDigit(c))
	    	    	return false;
			}
	    }
    	return true;
	}
	else
	{
		return false;
	}
}

function isPositiveInt(s)
{
    //是否为非负整数,包括0
    if (s.length>0)
	{
		for (var i = 0; i < s.length; i++)
		{
			var c = s.charAt(i);
			if (!isDigit(c))
				return false;
		}
		return true;
	}
	else
	{
		return false;
	}
}

function isInIntRange(s,smer,biger)
{
	if(isPositiveInt(s))
	{
		if(Number(s) >= Number(smer) && Number(s)<=Number(biger))
		{
			return true;	
		}
	}
	return false;
}

function isNegativeInt(s)
{
	//是否负整数
	if (s.length>0)
	{
		if (s.charAt(0) != "-")
		{
			return false;
		}
		if (!isPositiveInt(s.substring(1,s.length)))
		{
			return false;
		}
		return true;
	}
	else
	{
		return false;
	}	
}

function isPositiveData(s)
{
	//是否为正数，包括小数情况
	var patrn=/^\d+[.]?\d+|\d$/;
	if (!patrn.exec(s))
	{
		alert('不是正数！');
		return false
	}
	return true;
}

function isNegativeData(s)
{
	//是否为负数，包括小数情况
	var patrn=/^-{1}\d+[.]?\d+|-{1}\d$/;
	if (!patrn.exec(s))
	{
		return false
	}
	return true;
}
function isMobieNumber(s)
{
	//  1.以13开头   
	//  2.11位   
	//  3.全数字   
	var patrn=/^13\d{9}$/; 
	if (!patrn.exec(s))
	{
		return false
	}
	return true;
}