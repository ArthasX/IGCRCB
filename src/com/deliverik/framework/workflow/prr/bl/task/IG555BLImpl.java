/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG555Info;
import com.deliverik.framework.workflow.prr.model.condition.IG555SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG555DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG555TB;

/**
  * ����: ���̴���ҳ����������Ϣҵ���߼�ʵ��
  * ��������: ���̴���ҳ����������Ϣҵ���߼�ʵ��
  * ������¼: 2013/08/29
  * �޸ļ�¼: 
  */
public class IG555BLImpl extends BaseBLImpl implements
		IG555BL {

	/** ���̴���ҳ����������ϢDAO�ӿ� */
	protected IG555DAO ig555DAO;
	
	/**
	 * ���̴���ҳ����������ϢDAO�ӿ��趨
	 *
	 * @param ig555DAO ���̴���ҳ����������ϢDAO�ӿ�
	 */
	public void setIg555DAO(IG555DAO ig555DAO) {
		this.ig555DAO = ig555DAO;
	}

	/**
	 * ���̴���ҳ����������Ϣʵ��ȡ��
	 *
	 * @return ���̴���ҳ����������Ϣʵ��
	 */
	public IG555TB getIG555TBInstance() {
		return new IG555TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG555Info> searchIG555Info() {
		return ig555DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG555Info searchIG555InfoByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG555SearchCond cond) {
		return ig555DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG555Info> searchIG555Info(
			IG555SearchCond cond) {
		return ig555DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG555Info> searchIG555Info(
			IG555SearchCond cond, int start,
			int count) {
		return ig555DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG555Info registIG555Info(IG555Info instance)
		throws BLException {
		return ig555DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG555Info updateIG555Info(IG555Info instance)
		throws BLException {
		checkExistInstance(instance.getJump());
		return ig555DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG555InfoByPK(String pk)
		throws BLException {
		ig555DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG555Info(IG555Info instance)
		throws BLException {
		ig555DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG555Info checkExistInstance(String pk)
		throws BLException {
		IG555Info instance = ig555DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}