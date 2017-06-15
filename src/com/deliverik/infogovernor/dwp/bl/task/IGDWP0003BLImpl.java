/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dwp.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dwp.model.IGDWP0003Info;
import com.deliverik.infogovernor.dwp.model.condition.IGDWP0003SearchCond;
import com.deliverik.infogovernor.dwp.model.dao.IGDWP0003DAO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ճ������ƻ�����Ϣʵ��BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGDWP0003BLImpl extends BaseBLImpl implements IGDWP0003BL{

	/** �ճ������ƻ�����Ϣʵ��DAO */
	protected IGDWP0003DAO igdwp0003DAO;

	/**
	 * �ճ������ƻ�����Ϣʵ��DAO�趨
	 * @param igdwp0003DAO �ճ������ƻ�����Ϣʵ��DAO
	 */
	public void setIgdwp0003DAO(IGDWP0003DAO igdwp0003dao) {
		igdwp0003DAO = igdwp0003dao;
	}
	
	/**
	 * ������������
	 * @param pk ����
	 * @return �������
	 */
	public IGDWP0003Info searchByPk(Integer pk) throws BLException {
		return checkExistInstance(pk);
	}
	
	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IGDWP0003SearchCond cond){
		return this.igdwp0003DAO.getSearchCount(cond);
	}
	
	/**
	 * ������������
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IGDWP0003Info> search(IGDWP0003SearchCond cond){
		return this.igdwp0003DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IGDWP0003Info> search(IGDWP0003SearchCond cond,int start, int count){
		return this.igdwp0003DAO.findByCond(cond, start, count);
	}
	
	/**
	 * ��������
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IGDWP0003Info regist(IGDWP0003Info instance) throws BLException {
		return this.igdwp0003DAO.save(instance);
	}
	
	/**
	 * �޸Ĵ���
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IGDWP0003Info update(IGDWP0003Info instance) throws BLException {
		checkExistInstance(instance.getId());
		return this.igdwp0003DAO.save(instance);
	}
	
	/**
	 * ɾ������
	 * @param pk ����
	 */
	public void delete(Integer pk) throws BLException {
		this.igdwp0003DAO.delete(checkExistInstance(pk));
	}
	
	/**
	 * ɾ������
	 * @param instance ɾ��ʵ��
	 */
	public void delete(IGDWP0003Info instance) throws BLException {
		this.igdwp0003DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 * @param pk ����
	 * @return ʵ��
	 */
	private IGDWP0003Info checkExistInstance(Integer pk) throws BLException{
		IGDWP0003Info instance = this.igdwp0003DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
}
