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
 * Description: Ĭ�ϱ�ǩ����
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public abstract class DefaultProcessQuery implements ProcessQuery{
	
	/** ��ѯ����������� */
	protected IG111Info queryObj;
	
	/** ֵ */
	protected String value;
	
	/** ״̬��Ϣ */
	protected List<IG333Info> psdList;

	/**
	 * ��ѯ������������趨
	 * @param queryObj ��ѯ�����������
	 */
	public void setQueryObj(IG111Info queryObj) {
		this.queryObj = queryObj;
	}

	/**
	 * ֵ�趨
	 * @param value ֵ
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * ״̬��Ϣ�趨
	 * @param psdList ״̬��Ϣ
	 */
	public void setPsdList(List<IG333Info> psdList) {
		this.psdList = psdList;
	}
}
