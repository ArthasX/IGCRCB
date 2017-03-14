/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0602Info;
import com.deliverik.framework.soc.asset.model.SOC0604Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0602SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0604SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0602DAO;
import com.deliverik.framework.soc.asset.model.dao.SOC0604DAO;


/**
 * �����豸��Ϣҵ���߼�ʵ��
 * 
 */
public class SOC0602BLImpl extends BaseBLImpl implements SOC0602BL {

	/** ComputerDeviceVW DAO */
	protected SOC0602DAO soc0602DAO;
	
	/** ����ʵ���豸����ͳ�Ʒ�����ѯ��DAO*/
	protected SOC0604DAO soc0604DAO;

	public void setSoc0602DAO(SOC0602DAO soc0602dao) {
		soc0602DAO = soc0602dao;
	}

	public void setSoc0604DAO(SOC0604DAO soc0604dao) {
		soc0604DAO = soc0604dao;
	}

	/**
	 * ���ݻ�����Ϣ����ȡ���ʲ�ģ����Ϣ
	 * 
	 * @param eiid ����ID
	 * @return �����豸��Ϣ
	 */
	public SOC0602Info searchSOC0602InfoByKey(String eiid){

		SOC0602Info ret = soc0602DAO.findByPK(eiid);
		return ret;
	}
	

	/**
	 * ���ݼ�������ȡ�û����豸��Ϣ�������
	 * 
	 * @param cond �����豸��Ϣ��������
	 * @return �����豸��Ϣ�������
	 */
	public int getSOC0602InfoSearchCount(SOC0602SearchCond cond){

		return soc0602DAO.getSearchCount(cond);
	}
	
	/**
	 * ���ݼ�������ȡ�û����豸��Ϣ�б�
	 * 
	 * @param cond �����豸��Ϣ��������
	 * @return �����豸��Ϣ��������б�
	 */
	public List<SOC0602Info> searchSOC0602Info(SOC0602SearchCond cond){

		List<SOC0602Info> ret = soc0602DAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * ���ݼ�������ȡ�û����豸��Ϣ�б�
	 * 
	 * @param cond �����豸��Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �����豸��Ϣ��������б�
	 */
	public List<SOC0602Info> searchSOC0602Info(SOC0602SearchCond cond, int start, int count){

		List<SOC0602Info> ret = soc0602DAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * ���ݼ�������ȡ�û����豸��Ϣ�б�
	 * 
	 * @param cond ��������ͳ�Ʒ�����Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �����豸��Ϣ��������б�
	 */
	public List<SOC0604Info> searchSOC0604Info(SOC0604SearchCond cond,int start,int count) throws BLException {
		
		List<SOC0604Info> ecList = soc0604DAO.findByCond(cond, start, count);
		
		return ecList;
	}
	
	/**
	 * ���ݼ�������ȡ�û����豸��Ϣ�������
	 * 
	 * @param cond �����豸��Ϣ��������
	 * @return �����豸��Ϣ�������
	 */
	public int getSOC0604InfoSearchCount(SOC0604SearchCond cond) throws BLException {

		List<SOC0604Info> ecList = soc0604DAO.findByCond(cond, 0, 0);
		
		return ecList.size();
	}
	
	/**
     * ������������ģ����ѯ�豸���������豸���ڻ��񣬻���
     * 
     * @param cond
     * @param start
     * @param count
     * @return
     */
    public List<Object[]> findZhiJiLocation(SOC0602SearchCond cond){
        List<Object[]> list = soc0602DAO.findZhiJiLocation(cond);
        return list;
    }
  
	
}
