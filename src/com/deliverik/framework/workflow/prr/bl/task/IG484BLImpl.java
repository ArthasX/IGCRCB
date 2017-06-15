/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG484Info;
import com.deliverik.framework.workflow.prr.model.condition.IG484SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG484SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.dao.IG484DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG484PK;
import com.deliverik.framework.workflow.prr.model.entity.IG484TB;

/**
  * ����: �������Աʵ��ҵ���߼�ʵ��
  * ��������: �������Աʵ��ҵ���߼�ʵ��
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public class IG484BLImpl extends BaseBLImpl implements
		IG484BL {

	/** �������Աʵ��DAO�ӿ� */
	protected IG484DAO ig484DAO;
	
	/**
	 * �������Աʵ��DAO�ӿ��趨
	 *
	 * @param ig484DAO �������Աʵ��DAO�ӿ�
	 */
	public void setIg484DAO(IG484DAO ig484DAO) {
		this.ig484DAO = ig484DAO;
	}

	/**
	 * �������Աʵ��ʵ��ȡ��
	 *
	 * @return �������Աʵ��ʵ��
	 */
	public IG484TB getIG484TBInstance() {
		return new IG484TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG484Info> searchIG484() {
		return ig484DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG484Info searchIG484ByPK(IG484PK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG484SearchCond cond) {
		return ig484DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG484Info> searchIG484(
			IG484SearchCond cond) {
		return ig484DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG484Info> searchIG484(
			IG484SearchCond cond, int start,
			int count) {
		return ig484DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG484Info registIG484(IG484Info instance)
		throws BLException {
		return ig484DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG484Info updateIG484(IG484Info instance)
		throws BLException {
		checkExistInstance(new IG484PK(instance.getPgrid(), instance.getPrid()));
		return ig484DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG484ByPK(IG484PK pk)
		throws BLException {
		ig484DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG484(IG484Info instance)
		throws BLException {
		ig484DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG484Info checkExistInstance(IG484PK pk)
		throws BLException {
		IG484Info instance = ig484DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	
	/**
	 * ͨ����һ���̲�ѯ�������ʵ��pgrid
	 *
	 * @param prid ����id
	 * @return �������pgrid ������ؿ���ǰ���̲���������������
	 */
	public Integer searchIG484PgridByPrid(Integer prid){
		Integer pgrid = null;
		IG484SearchCondImpl ig484cond = new IG484SearchCondImpl();
		ig484cond.setPrid(prid);
		List<IG484Info> ig484Lst = ig484DAO.findByCond(ig484cond, 0, 1);
		if(null!=ig484Lst&&ig484Lst.size()>0){
			pgrid = ig484Lst.get(0).getPgrid();
		}
		return pgrid;
	}

}