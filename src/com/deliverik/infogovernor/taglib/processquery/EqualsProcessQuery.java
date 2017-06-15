/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.taglib.processquery;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;


/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class EqualsProcessQuery extends DefaultProcessQuery{

	/**
	 * ���ɱ�ǩ
	 * @param param ����
	 * @return ���ɺ�ı�ǩ�ַ���
	 */
	public String generatedTag(){
		//��������Ϣȡ��
		StringBuffer tagString = new StringBuffer();
		tagString.append("<span>");
		tagString.append(queryObj.getQname());
		tagString.append("��</span>");
		if("pi".equals(this.queryObj.getQtype())){
			IG007Info pid = queryObj.getPid();
			if("7".equals(pid.getPidtype())){
				tagString.append("<input type='text' name='queryValue' value='");
				tagString.append(IGStringUtils.filterXMLStr(value));
				tagString.append("' onkeydown='return columnValueNumber();' flag='");
				tagString.append(pid.getNumbertype());
				tagString.append("' decimals='");
				tagString.append(pid.getPidoption());
				tagString.append("' />");
			}else if("R".equals(pid.getPidtype())){
				String val = StringUtils.isNotEmpty(this.value) && this.value.contains("_role_") ? this.value.split("_role_")[1] : "";
				tagString.append("<input type='text' name='qv' readOnly='true' value='");
				tagString.append(val);
				tagString.append("' onclick=\"selectRoleOnIGSYM0306(this,'");
				tagString.append(pid.getPdid());
				tagString.append("');\" /> ");
				tagString.append("<input type='hidden' name='queryValue' value='");
				tagString.append(IGStringUtils.filterXMLStr(value));
				tagString.append("'/>");
			}else{
				tagString.append("<select name='queryValue'><option></option>");
				for(String option:pid.getPidoption().split("#")){
					if(StringUtils.isNotEmpty(option)){
						tagString.append("<option value='");
						tagString.append(option);
						tagString.append("'");
						if(option.equals(this.value)){
							tagString.append(" selected='true' ");
						}
						tagString.append(">");
						tagString.append(option);
						tagString.append("</option>");
					}
				}
				tagString.append("</select>");
			}
		}else{
			tagString.append("<select name='queryValue'><option></option>");
			if(this.psdList != null){
				for(IG333Info info:this.psdList){
					if(!IGPRDCONSTANTS.PROCESS_END_STATUS.equals(info.getPsdcode())){
						tagString.append("<option value='");
						tagString.append(info.getPsdcode());
						tagString.append("'");
						if(info.getPsdcode().equals(this.value)){
							tagString.append(" selected='true'");
						}
						tagString.append(">");
						tagString.append(info.getPsdname());
						tagString.append("</option>");
					}
				}
				tagString.append("<option value='");
				tagString.append(IGPRDCONSTANTS.PROCESS_END_STATUS);
				tagString.append("'");
				if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(this.value)){
					tagString.append(" selected='true'");
				}
				tagString.append(">�ر�</option>");
			}
			tagString.append("</select>");
		}
		tagString.append("<input type='hidden' name='queryKey' value='");
		tagString.append(queryObj.getQtype());
		tagString.append("#");
		tagString.append(queryObj.getQflag());
		tagString.append("#");
		tagString.append(queryObj.getQname());
		tagString.append("'/>");
		return tagString.toString();
	}
}
