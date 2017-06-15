/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.IG499Info;
import com.deliverik.framework.asset.model.condition.IG499SearchCond;
import com.deliverik.framework.asset.model.dao.IG499DAO;
import com.deliverik.framework.asset.model.entity.IG499VW;
import com.deliverik.framework.base.BaseBLImpl;

/**
  * ����: ��ͬ�ʲ���Ϣ��ͼҵ���߼�ʵ��
  * ��������: ��ͬ�ʲ���Ϣ��ͼҵ���߼�ʵ��
  * ������¼: 2012/04/10
  * �޸ļ�¼: 
  */
public class IG499BLImpl extends BaseBLImpl implements
		IG499BL {

	/** ��ͬ�ʲ���Ϣ��ͼDAO�ӿ� */
	protected IG499DAO ig499DAO;
	
	/**
	 * ��ͬ�ʲ���Ϣ��ͼDAO�ӿ��趨
	 *
	 * @param IG499DAO ��ͬ�ʲ���Ϣ��ͼDAO�ӿ�
	 */
	public void setIg499DAO(IG499DAO ig499DAO) {
		this.ig499DAO = ig499DAO;
	}

	/**
	 * ��ͬ�ʲ���Ϣ��ͼʵ��ȡ��
	 *
	 * @return ��ͬ�ʲ���Ϣ��ͼʵ��
	 */
	public IG499VW getIG499VWInstance() {
		return new IG499VW();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG499Info> searchIG499Info() {
		return ig499DAO.findAll();
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG499SearchCond cond) {
		return ig499DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG499Info> searchIG499Info(
			IG499SearchCond cond) {
		return ig499DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG499Info> searchIG499Info(
			IG499SearchCond cond, int start,
			int count) {
		return ig499DAO.findByCond(cond, start, count);
	}
	
	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchImprestCount(final IG499SearchCond cond){
		return ig499DAO.getSearchImprestCount(cond);
	}
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG499Info> findImprestByCond(final IG499SearchCond cond, 
			final int start, final int count){
		return ig499DAO.findImprestByCond(cond, start, count);
	}


}