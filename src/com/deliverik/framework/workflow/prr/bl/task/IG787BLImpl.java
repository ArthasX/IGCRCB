/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG787Info;
import com.deliverik.framework.workflow.prr.model.condition.IG787SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG787DAO;

/**
 * <p>����:���̹�ͬ������ͼҵ���߼�ʵ��</p>
 * <p>����������1.���ݲ�ѯ������ѯ���̵Ĺ�ͨ������Ϣ</p>
 *           
 * <p>������¼��</p>
 */
public class IG787BLImpl extends BaseBLImpl implements IG787BL{
	
	/** ���̹�ͨ������ͼDAO*/
	protected IG787DAO ig787DAO;

	/**
	 * ���ܣ����̹�ͨ������ͼDAO
	 * 
	 * @param ig787DAO ���̹�ͨ������ͼDAO
	 */
	public void setIg787DAO(
			IG787DAO ig787DAO) {
		this.ig787DAO = ig787DAO;
	}


	/**
	 * ���ܣ����ݲ�ѯ������ѯ���̵Ĺ�ͨ������Ϣ
	 * @param cond ���̹�ͨ������ͼ��ѯ����
	 * @param start ������¼��ʼ��
	 * @param count ������¼����
	 * @return ���̹�ͬ����List
	 * 
	 */
	public List<IG787Info> findByCond(final IG787SearchCond cond, final int start, final int count) {
		return ig787DAO.findByCond(cond, start, count);
	}

}
