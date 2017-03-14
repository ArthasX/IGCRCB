/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS02Info;
import com.deliverik.infogovernor.nms.model.condition.NMS02SearchCond;
import com.deliverik.infogovernor.nms.model.condition.NMS02SearchCondImpl;
import com.deliverik.infogovernor.nms.model.dao.NMS02DAO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: SNMP������Ϣʵ��BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS02BLImpl extends NMSBaseBLImpl implements NMS02BL {

	/** SNMP������Ϣʵ��DAO */
	protected NMS02DAO nms02DAO;

	/**
	 * SNMP������Ϣʵ��DAO�趨
	 * @param nms02DAO SNMP������Ϣʵ��DAO
	 */
	public void setNms02DAO(NMS02DAO nms02DAO) {
		this.nms02DAO = nms02DAO;
	}
	
	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public NMS02Info searchByPK(String pk) throws BLException {
		return checkExistInstance(pk);
	}
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(NMS02SearchCond cond) {
		return nms02DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<NMS02Info> search(NMS02SearchCond cond) {
		return nms02DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<NMS02Info> search(NMS02SearchCond cond, int start,int count) {
		return nms02DAO.findByCond(cond, start, count);
	}
	
	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public NMS02Info regist(NMS02Info instance) throws BLException {
		checkExistInstance(instance.getSnmpVersion(), instance.getSnmpPort(),
				instance.getReadCommit(), instance.getSnmpUser(), instance.getSnmpPassword());
		return nms02DAO.save(instance);
	}
	
	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public NMS02Info update(NMS02Info instance) throws BLException {
		checkExistInstance(instance.getId());
		return nms02DAO.save(instance);
	}
	
	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void delete(String pk) throws BLException {
		nms02DAO.delete(checkExistInstance(pk));
	}
	
	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void delete(NMS02Info instance) throws BLException {
		nms02DAO.delete(instance);
	}
	
	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public NMS02Info checkExistInstance(String pk) throws BLException {
		NMS02Info instance = nms02DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	
	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param snmpVersion SNMP�汾
	 * @param snmpPort �˿�
	 * @param readCommit ��ȡ������
	 * @param snmpUser V3��ȫ�û�
	 * @param snmpPassword V3�����֤����
	 * @return ʵ��
	 */
	public void checkExistInstance(Integer snmpVersion, Integer snmpPort, String readCommit,
			String snmpUser, String snmpPassword) throws BLException {
		NMS02SearchCondImpl cond = new NMS02SearchCondImpl();
		cond.setDeleteflag("0");
		cond.setSnmpVersion(snmpVersion);
		cond.setSnmpPort(snmpPort);
		cond.setReadCommit(readCommit);
		cond.setSnmpUser(snmpUser);
		cond.setSnmpPassword(snmpPassword);
		List<NMS02Info> lst_NMS02Info = this.search(cond);
		if (!lst_NMS02Info.isEmpty()) {
			throw new BLException("IGCO10000.E140", "���û�����Ϣ�Ѵ���");
		}
	}
}
