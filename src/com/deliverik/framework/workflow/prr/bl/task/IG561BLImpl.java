/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG561Info;
import com.deliverik.framework.workflow.prr.model.IG561VWInfo;
import com.deliverik.framework.workflow.prr.model.condition.IG561SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG561DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG561TB;

/**
  * ����: ״̬��˽�б�ֵ��¼��ҵ���߼�ʵ��
  * ��������: ״̬��˽�б�ֵ��¼��ҵ���߼�ʵ��
  * ������¼: 2015/02/07
  * �޸ļ�¼: 
  */
public class IG561BLImpl extends BaseBLImpl implements
		IG561BL {

	/** ״̬��˽�б�ֵ��¼��DAO�ӿ� */
	protected IG561DAO ig561DAO;
	
	/**
	 * ״̬��˽�б�ֵ��¼��DAO�ӿ��趨
	 *
	 * @param ig561DAO ״̬��˽�б�ֵ��¼��DAO�ӿ�
	 */
	public void setIg561DAO(IG561DAO ig561DAO) {
		this.ig561DAO = ig561DAO;
	}

	/**
	 * ״̬��˽�б�ֵ��¼��ʵ��ȡ��
	 *
	 * @return ״̬��˽�б�ֵ��¼��ʵ��
	 */
	public IG561TB getIG561TBInstance() {
		return new IG561TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG561Info> searchIG561() {
		return ig561DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG561Info searchIG561ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG561SearchCond cond) {
		return ig561DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG561Info> searchIG561(
			IG561SearchCond cond) {
		return ig561DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG561Info> searchIG561(
			IG561SearchCond cond, int start,
			int count) {
		return ig561DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG561Info registIG561(IG561Info instance)
		throws BLException {
		return ig561DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG561Info updateIG561(IG561Info instance)
		throws BLException {
		checkExistInstance(instance.getPvlid());
		return ig561DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG561ByPK(Integer pk)
		throws BLException {
		ig561DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG561(IG561Info instance)
		throws BLException {
		ig561DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG561Info checkExistInstance(Integer pk)
		throws BLException {
		IG561Info instance = ig561DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	
	   /**
     * ���̹رսڵ� ״̬˽�б���ʾ��ѯ������������ʾ��״̬��˽�б�����ʾ����
     * @Title: searchIG561VW
     * @Description: ���̹رսڵ� ״̬˽�б���ʾ��ѯ������������ʾ��״̬��˽�б�����ʾ����
     * @param 
     * prid ����id 
     * ppuserid ������id
     * isAdmin �Ƿ������̹���Ա
     * @return list561VW
     * @throws
     */
    public List<IG561VWInfo> searchIG561VW(String prid , String ppuserid, boolean isAdmin)throws BLException{
        return this.ig561DAO.searchIG561VW(prid, ppuserid, isAdmin);
    }

}