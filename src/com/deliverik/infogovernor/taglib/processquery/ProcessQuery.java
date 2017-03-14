/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.taglib.processquery;

import java.util.List;

import com.deliverik.framework.workflow.prd.model.IG111Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̲�ѯ������ǩ�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface ProcessQuery {
	
	/** ֵ */
	public static final String PARAM_VALUE = "value";
	
	/** ��ѯ����������� */
	public static final String PARAM_DEFINITION_OBJECT = "object";
	
	/** ״̬������Ϣ */
	public static final String PARAM_STATUS_DEFINITION = "statusDefinition";
	
	/**
	 * ��ѯ������������趨
	 * @param queryObj ��ѯ�����������
	 */
	public void setQueryObj(IG111Info queryObj);
	
	/**
	 * ֵ�趨
	 * @param value ֵ
	 */
	public void setValue(String value) ;
	
	/**
	 * ״̬��Ϣ�趨
	 * @param psdList ״̬��Ϣ
	 */
	public void setPsdList(List<IG333Info> psdList);

	/**
	 * ���ɱ�ǩ
	 * @param param ����
	 * @return ���ɺ�ı�ǩ�ַ���
	 */
	public String generatedTag();
}
