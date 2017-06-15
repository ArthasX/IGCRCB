/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.cim.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.model.PortRelationInfo;
import com.deliverik.infogovernor.soc.model.condition.PortRelationSearchCond;
import com.deliverik.infogovernor.soc.model.dao.PortRelationDAO;
import com.deliverik.infogovernor.soc.model.entity.PortRelationPK;
import com.deliverik.infogovernor.soc.model.entity.PortRelationTB;


/**
  * ����: �˵��˹�ϵ��ҵ���߼�ʵ��
  * ��������: �˵��˹�ϵ��ҵ���߼�ʵ��
  * ������¼: 2013/01/17
  * �޸ļ�¼: 
  */
public class PortRelationBLImpl extends BaseBLImpl implements
		PortRelationBL {

	/** �˵��˹�ϵ��DAO�ӿ� */
	protected PortRelationDAO portRelationDao;
	
	/**  
	 * �˵��˹�ϵ��DAO�ӿ��趨
	 *
	 * @param portRelationDAO �˵��˹�ϵ��DAO�ӿ�
	 */
	public void setPortRelationDao(PortRelationDAO portRelationDao) {
		this.portRelationDao = portRelationDao;
	}

	/**
	 * �˵��˹�ϵ��ʵ��ȡ��
	 *
	 * @return �˵��˹�ϵ��ʵ��
	 */
	public PortRelationTB getPortRelationTBInstance() {
		return new PortRelationTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<PortRelationInfo> searchPortRelation() {
		return portRelationDao.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public PortRelationInfo searchPortRelationByPK(PortRelationPK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(PortRelationSearchCond cond) {
		return portRelationDao.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<PortRelationInfo> searchPortRelation(
			PortRelationSearchCond cond) {
		return portRelationDao.findByCond(cond, 0, 0);
	}
	/**
	 * ʣ��hyper��ѯ
	 */
	public List<String> searchPortRelationStr(
			PortRelationSearchCond cond) {
		return portRelationDao.findByCondStr(cond, 0, 0);
	}
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<PortRelationInfo> searchPortRelation(
			PortRelationSearchCond cond, int start,
			int count) {
		return portRelationDao.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public PortRelationInfo registPortRelation(PortRelationInfo instance)
		throws BLException {
		return portRelationDao.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public PortRelationInfo updatePortRelation(PortRelationInfo instance)
		throws BLException {
		checkExistInstance(new PortRelationPK(instance.getHBAPort_WWN(), instance.getDevicesName(), instance.getSymmetrixID(), instance.getFAName(), instance.getFAPortName()));
		return portRelationDao.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deletePortRelationByPK(PortRelationPK pk)
		throws BLException {
		portRelationDao.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deletePortRelation(PortRelationInfo instance)
		throws BLException {
		portRelationDao.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public PortRelationInfo checkExistInstance(PortRelationPK pk)
		throws BLException {
		PortRelationInfo instance = portRelationDao.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	/**
	 * ҵ��ϵͳ��ѯ
	 */
	public List<String> searchPortRelationBuss(PortRelationSearchCond cond) {

		return portRelationDao.findByCondBuss(cond, 0, 0);	
		}
	/**
	 * ����&HBA�ؼ��ֲ�ѯ
	 */
	public List<String> searchPortRelationHost(PortRelationSearchCond cond) {
		
		return portRelationDao.findByCondHost(cond, 0, 0);
	}
	/**
	 * �������ؼ��ֲ�ѯ
	 */
	public List<String> searchPortRelationSwitch(PortRelationSearchCond cond) {

		return portRelationDao.findByCondSwitch(cond, 0, 0);

	}
	/**
	 * FA
	 */
	public List<String> searchPortRelationFa(PortRelationSearchCond cond) {

		return portRelationDao.findByCondFa(cond, 0, 0);

	}
	/**
	 * ��ѯmeta��geteKeeper
	 * @param cond
	 * @return
	 */
	public List<String> searchPortRelationHyper(PortRelationSearchCond cond) {

		return portRelationDao.findByCondHyper(cond, 0, 0);

	}
	/**
	 * ��·��ѯHyper�õ�FAeiid
	 * @param eiid
	 * @return
	 */
	public List<String> getHypeEiid(final String eiid,final String einame){
		
		return portRelationDao.getHypeEiid(eiid,einame);
		
		}
}