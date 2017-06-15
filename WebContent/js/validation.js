function isEmail(s)
{
    //����Ƿ�Ϸ�Email��ʽ
	if((s.indexOf('@', 0) == -1 )
		|| (s.indexOf('.', 0) == -1))
    {
      	return false;
    }
    return true;
}

function isCharacter(s)
{
	//����Ƿ�Ӣ���ַ���
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
	//���һλ�Ƿ�����
	return ((c >= "0") && (c <= "9"))
}

function isData(s)
{
    //����Ƿ������֣�����������С������Ϊ��ȷ
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
    //�Ƿ�Ϊ�Ǹ�����,����0
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
	//�Ƿ�����
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
	//�Ƿ�Ϊ����������С�����
	var patrn=/^\d+[.]?\d+|\d$/;
	if (!patrn.exec(s))
	{
		alert('����������');
		return false
	}
	return true;
}

function isNegativeData(s)
{
	//�Ƿ�Ϊ����������С�����
	var patrn=/^-{1}\d+[.]?\d+|-{1}\d$/;
	if (!patrn.exec(s))
	{
		return false
	}
	return true;
}
function isMobieNumber(s)
{
	//  1.��13��ͷ   
	//  2.11λ   
	//  3.ȫ����   
	var patrn=/^13\d{9}$/; 
	if (!patrn.exec(s))
	{
		return false
	}
	return true;
}