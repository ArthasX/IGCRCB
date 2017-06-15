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
 * Description: �ָ�㼶������������
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class SplitLikeProcessQuery extends DefaultProcessQuery{

	/**
	 * ���ɱ�ǩ
	 * @param param ����
	 * @return ���ɺ�ı�ǩ�ַ���
	 */
	public String generatedTag() {
		StringBuffer tagString = new StringBuffer();
		tagString.append("<span>");
		tagString.append(queryObj.getQname());
		tagString.append("��</span>");
		tagString.append("<input type='text' readOnly='true' name='qv' ");
		if(this.queryObj.getQtype().equals("pi")){
			IG007Info pid = this.queryObj.getPid();
			String val = "";
			String function = "";
			if("T".equals(pid.getPidtype())){
				if(StringUtils.isNotEmpty(this.value) && this.value.contains("_tree_")){
					val = this.value.split("_tree_")[1];
				}
				function = "selectTree(this,'" + pid.getCcid() + "');";
			}else if("G".equals(pid.getPidtype())){
				if(StringUtils.isNotEmpty(this.value) && this.value.contains("_OrgTree_")){
					val = this.value.split("_OrgTree_")[1];
				}
				function = "selectOrgTree(this);";
			}
			tagString.append(" value='");
			tagString.append(val);
			tagString.append("' ");
			tagString.append(" onclick=\"");
			tagString.append(function);
			tagString.append("\" ");
		}
		tagString.append("/> ");
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
