package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.IG912Info;
import com.deliverik.framework.asset.model.IG790Info;
import com.deliverik.framework.asset.model.condition.IG912SearchCond;
import com.deliverik.framework.asset.model.condition.IG790SearchCond;
import com.deliverik.framework.asset.model.dao.IG912DAO;
import com.deliverik.framework.asset.model.dao.IG790DAO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;


/**
 * �����豸��Ϣҵ���߼�ʵ��
 * 
 */
public class IG912BLImpl extends BaseBLImpl implements IG912BL {

	/** ComputerDeviceVW DAO */
	protected IG912DAO ig912DAO;
	
	/** ����ʵ���豸����ͳ�Ʒ�����ѯ��DAO*/
	protected IG790DAO ig790DAO;

	public void setIg912DAO(IG912DAO ig912DAO) {
		this.ig912DAO = ig912DAO;
	}
	
	public void setIg790DAO(
			IG790DAO ig790DAO) {
		this.ig790DAO = ig790DAO;
	}

	/**
	 * ���ݻ�����Ϣ����ȡ���ʲ�ģ����Ϣ
	 * 
	 * @param eiid ����ID
	 * @return �����豸��Ϣ
	 */
	public IG912Info searchIG912InfoByKey(String eiid){

		IG912Info ret = ig912DAO.findByPK(eiid);
		return ret;
	}
	

	/**
	 * ���ݼ�������ȡ�û����豸��Ϣ�������
	 * 
	 * @param cond �����豸��Ϣ��������
	 * @return �����豸��Ϣ�������
	 */
	public int getIG912InfoSearchCount(IG912SearchCond cond){

		return ig912DAO.getSearchCount(cond);
	}
	
	/**
	 * ���ݼ�������ȡ�û����豸��Ϣ�б�
	 * 
	 * @param cond �����豸��Ϣ��������
	 * @return �����豸��Ϣ��������б�
	 */
	public List<IG912Info> searchIG912Info(IG912SearchCond cond){

		List<IG912Info> ret = ig912DAO.findByCond(cond,0,0);
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
	public List<IG912Info> searchIG912Info(IG912SearchCond cond, int start, int count){

		List<IG912Info> ret = ig912DAO.findByCond(cond,start,count);
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
	public List<IG790Info> searchIG790Info(IG790SearchCond cond,int start,int count) throws BLException {
		
		List<IG790Info> ecList = ig790DAO.findByCond(cond, start, count);
		
		return ecList;
	}
	
	/**
	 * ���ݼ�������ȡ�û����豸��Ϣ�������
	 * 
	 * @param cond �����豸��Ϣ��������
	 * @return �����豸��Ϣ�������
	 */
	public int getIG790InfoSearchCount(IG790SearchCond cond) throws BLException {

		List<IG790Info> ecList = ig790DAO.findByCond(cond, 0, 0);
		
		return ecList.size();
	}
	
	
}
