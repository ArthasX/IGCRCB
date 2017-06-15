/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG787Info;
import com.deliverik.framework.workflow.prr.model.condition.IG787SearchCond;

/**
 * <p>����:���̹�ͬ������ͼҵ���߼��ӿ�</p>
 * <p>����������1.���ݲ�ѯ������ѯ���̵Ĺ�ͨ������Ϣ</p>
 *           
 * <p>������¼��</p>
 */
public interface IG787BL extends BaseBL{
	
	/**
	 * ���ܣ����ݲ�ѯ������ѯ���̵Ĺ�ͨ������Ϣ
	 * @param cond ���̹�ͨ������ͼ��ѯ����
	 * @param start ������¼��ʼ��
	 * @param count ������¼����
	 * @return ���̹�ͬ����List
	 * 
	 */
	public List<IG787Info> findByCond(final IG787SearchCond cond, final int start, final int count);
}
