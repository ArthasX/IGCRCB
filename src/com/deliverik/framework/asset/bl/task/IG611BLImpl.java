/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.asset.model.IG611Info;
import com.deliverik.framework.asset.model.IG612Info;
import com.deliverik.framework.asset.model.condition.IG611SearchCond;
import com.deliverik.framework.asset.model.dao.IG611DAO;
import com.deliverik.framework.asset.model.entity.IG611PK;
import com.deliverik.framework.asset.model.entity.IG611TB;

/**
  * ����: �ʲ�ģ������ȱʡֵҵ���߼�ʵ��
  * ��������: �ʲ�ģ������ȱʡֵҵ���߼�ʵ��
  * ������¼: 2012/07/20
  * �޸ļ�¼: 
  */
public class IG611BLImpl extends BaseBLImpl implements
		IG611BL {

	/** �ʲ�ģ������ȱʡֵDAO�ӿ� */
	protected IG611DAO ig611DAO;
	
	/**
	 * �ʲ�ģ������ȱʡֵDAO�ӿ��趨
	 *
	 * @param ig611DAO �ʲ�ģ������ȱʡֵDAO�ӿ�
	 */
	public void setIg611DAO(IG611DAO ig611DAO) {
		this.ig611DAO = ig611DAO;
	}

	/**
	 * �ʲ�ģ������ȱʡֵʵ��ȡ��
	 *
	 * @return �ʲ�ģ������ȱʡֵʵ��
	 */
	public IG611TB getIG611TBInstance() {
		return new IG611TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG611Info> searchIG611Info() {
		return ig611DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG611Info searchIG611InfoByPK(IG611PK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG611SearchCond cond) {
		return ig611DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG611Info> searchIG611Info(
			IG611SearchCond cond) {
		return ig611DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG611Info> searchIG611Info(
			IG611SearchCond cond, int start,
			int count) {
		return ig611DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG611Info registIG611Info(IG611Info instance)
		throws BLException {
		return ig611DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG611Info updateIG611Info(IG611Info instance)
		throws BLException {
		checkExistInstance(new IG611PK(instance.getEid(), instance.getCid()));
		return ig611DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG611InfoByPK(IG611PK pk)
		throws BLException {
		ig611DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG611Info(IG611Info instance)
		throws BLException {
		ig611DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG611Info checkExistInstance(IG611PK pk)
		throws BLException {
		IG611Info instance = ig611DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	
	/**
	 * �ʲ�����Ĭ��ֵȡ��
	 * 
	 * @param cond ��������
	 * @return �ʲ�����Ĭ��ֵ
	 */
	public  List<IG612Info> searchDefaultValue(IG611SearchCond cond) {
		return ig611DAO.searchDefaultValue(cond);
	}
	
	/**
	 * �ʲ����Գ��ڻ���ѯ
	 * 
	 * @param cond ��������
	 * @return �ʲ�����
	 */
	public  List<IG612Info> searchDefaultLabel(IG611SearchCond cond) {
		return ig611DAO.searchDefaultLabel(cond);
	}

}