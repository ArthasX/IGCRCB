/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.taglib.processquery;

import com.deliverik.framework.utility.IGStringUtils;


/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: Like��ʽ��ѯ��������
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class LikeProcessQuery extends DefaultProcessQuery{

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
		tagString.append("<input type='text' name='queryValue' value='");
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
