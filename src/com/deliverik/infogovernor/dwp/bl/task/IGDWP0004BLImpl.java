/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dwp.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dwp.model.IGDWP0004Info;
import com.deliverik.infogovernor.dwp.model.condition.IGDWP0004SearchCond;
import com.deliverik.infogovernor.dwp.model.dao.IGDWP0004DAO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ճ������ƻ���������Ϣʵ��BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGDWP0004BLImpl extends BaseBLImpl implements IGDWP0004BL{

	/** �ճ������ƻ���������Ϣʵ��DAO */
	protected IGDWP0004DAO igdwp0004DAO;

	/**
	 * �ճ������ƻ���������Ϣʵ��DAO�趨
	 * @param igdwp0004DAO �ճ������ƻ���������Ϣʵ��DAO
	 */
	public void setIgdwp0004DAO(IGDWP0004DAO igdwp0004dao) {
		igdwp0004DAO = igdwp0004dao;
	}
	
	/**
	 * ������������
	 * @param pk ����
	 * @return �������
	 */
	public IGDWP0004Info searchByPk(Integer pk) throws BLException {
		return checkExistInstance(pk);
	}
	
	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IGDWP0004SearchCond cond){
		return this.igdwp0004DAO.getSearchCount(cond);
	}
	
	/**
	 * ������������
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IGDWP0004Info> search(IGDWP0004SearchCond cond){
		return this.igdwp0004DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IGDWP0004Info> search(IGDWP0004SearchCond cond,int start, int count){
		return this.igdwp0004DAO.findByCond(cond, start, count);
	}
	
	/**
	 * ��������
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IGDWP0004Info regist(IGDWP0004Info instance) throws BLException {
		return this.igdwp0004DAO.save(instance);
	}
	
	/**
	 * �޸Ĵ���
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IGDWP0004Info update(IGDWP0004Info instance) throws BLException {
		checkExistInstance(instance.getId());
		return this.igdwp0004DAO.save(instance);
	}
	
	/**
	 * ɾ������
	 * @param pk ����
	 */
	public void delete(Integer pk) throws BLException {
		this.igdwp0004DAO.delete(checkExistInstance(pk));
	}
	
	/**
	 * ɾ������
	 * @param instance ɾ��ʵ��
	 */
	public void delete(IGDWP0004Info instance) throws BLException {
		this.igdwp0004DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 * @param pk ����
	 * @return ʵ��
	 */
	private IGDWP0004Info checkExistInstance(Integer pk) throws BLException{
		IGDWP0004Info instance = this.igdwp0004DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
}
