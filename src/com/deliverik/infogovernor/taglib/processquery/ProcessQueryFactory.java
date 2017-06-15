/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.taglib.processquery;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.workflow.prd.model.IG111Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̲�ѯ������ǩ���ɹ�����
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("unchecked")
public class ProcessQueryFactory {

	/** �������� */
	protected Map<String, ProcessQuery> map;

	/**
	 * ���������趨
	 * @param map ��������
	 */
	public void setMap(Map<String, ProcessQuery> map) {
		this.map = map;
	}
	
	/**
	 * ���ɱ�ǩ
	 * @param param ����
	 * @return ���ɺ�ı�ǩ�ַ���
	 */
	public String generatedTag(Map<String, Object> param){
		IG111Info info = (IG111Info) param.get(ProcessQuery.PARAM_DEFINITION_OBJECT);
		String value = (String) param.get(ProcessQuery.PARAM_VALUE);
		List<IG333Info> psdList = (List<IG333Info>) param.get(ProcessQuery.PARAM_STATUS_DEFINITION);
		ProcessQuery tag = map.get(info.getQmode());
		if(tag == null) return "�ݲ�֧�ִ˲�ѯ����";
		tag.setQueryObj(info);
		tag.setValue(value);
		tag.setPsdList(psdList);
		return tag.generatedTag();
	}
}
