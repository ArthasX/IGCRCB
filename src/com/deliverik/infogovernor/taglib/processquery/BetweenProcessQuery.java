/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.taglib.processquery;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.model.IG007Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: Between��ʽ��ѯ��������
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class BetweenProcessQuery extends DefaultProcessQuery{

	/**
	 * ���ɱ�ǩ
	 * @param param ����
	 * @return ���ɺ�ı�ǩ�ַ���
	 */
	public String generatedTag() {
		StringBuffer tagString = new StringBuffer();
		String function = "showTime(this);";
		if(this.queryObj.getQtype().equals("pi")){
			IG007Info pid = this.queryObj.getPid();
			if("3".equals(pid.getPidtype())){
				function = "showDate(this);";
			}
		}
		String v1 = "";
		String v2 = "";
		if(StringUtils.isNotEmpty(this.value)){
		    if(!"#".equals(value)){
		        String[] split = this.value.split("#");
	            v1 = split[0];
	            if(split.length > 1){
	                v2 = split[1];
	            }
		    }
		}
		tagString.append("<span>");
		tagString.append(queryObj.getQname());
		tagString.append("����</span>");
		tagString.append("<input type='text' name='qv1' value='");
		tagString.append(v1);
		tagString.append("' style='cursor: hand;' readOnly='true' onclick='");
		tagString.append(function);
		tagString.append("' onchange='changeDateOrTimeForQueryValue(this);'/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name='qv2' value='");
		tagString.append(v2);
		tagString.append("' style='cursor: hand;' readOnly='true' onclick='");
		tagString.append(function);
		tagString.append("' onchange='changeDateOrTimeForQueryValue(this);'/>");
		tagString.append("<input type='hidden' name='queryValue' value='");
		tagString.append(IGStringUtils.filterXMLStr(value));
		tagString.append("'/><input type='hidden' name='queryKey' value='");
		tagString.append(queryObj.getQtype());
		tagString.append("#");
		tagString.append(queryObj.getQflag());
		tagString.append("#");
		tagString.append(queryObj.getQname());
		tagString.append("'/>");
		return tagString.toString();
	}
}
