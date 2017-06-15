package com.deliverik.framework.asset.bl.task;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.asset.model.IG445Info;
import com.deliverik.framework.asset.model.IG011Info;
import com.deliverik.framework.asset.model.condition.IG445SearchCond;
import com.deliverik.framework.asset.model.condition.IG011SearchCond;
import com.deliverik.framework.asset.model.dao.IG445DAO;
import com.deliverik.framework.asset.model.dao.IG011DAO;
import com.deliverik.framework.base.BLException;
/**
 * <p>
 * �ʲ�ͳ��ҵ���߼�ʵ��
 * </p>
 */
public class IG189BLImpl implements IG189BL {

	static Log log = LogFactory.getLog(IG189BLImpl.class);

	/** ����ʵ���豸����ͳ�Ʒ�����ѯ��DAO*/
	protected IG011DAO ig011DAO;
	
	/** ����ʵ���豸�����ֲ�ʽͳ�Ʒ�����ѯ��DAO*/
	protected IG445DAO ig445DAO;
	
	public void setIg011DAO(IG011DAO ig011DAO) {
		this.ig011DAO = ig011DAO;
	}

	
	public void setIg445DAO(
			IG445DAO ig445DAO) {
		this.ig445DAO = ig445DAO;
	}


	/**
	 * ����ͳ�Ʒ�������
	 */
	public List<IG011Info> searchIG011Info(IG011SearchCond cond) throws BLException {

		List<IG011Info> ecList = findEquimentCountByCondition(cond);
		
		
		return ecList;
	}
	
	/**
	 * ���зֲ�ʽͳ�Ʒ�������
	 */
	public List<IG445Info> searchIG445Info(IG445SearchCond cond) throws BLException {
		

		List<IG445Info> edList = findEquDistributingCountByCondition(cond);
		
		return edList;
	}
	
	
	
	
	/**
	 * ����ͳ��������ѯ���,���ط��������Ľ������
	 */
	public int getIG011InfoSearchCount(IG011SearchCond cond) throws BLException {
		
		if("0".equals(cond.getOrgType())){
			//��������
			List<IG011Info> ecList = ig011DAO.findByCond(cond, 0, 0);
			return ecList.size();
		}else{
			//ʹ�û���
			List<IG011Info> ecList = ig011DAO.findIG011InfoCondByUseOrg(cond, 0, 0);
			return ecList.size();
		}
	
	}
	
	/**
	 * ����ͳ��������ѯ���,���ط��������Ľ������
	 */
	public int getIG445InfoSearchCount(IG445SearchCond cond) throws BLException {
		
		//��������
		List<IG445Info> edList = ig445DAO.findByCond(cond, 0, 0);
		return edList.size();
	
	}
	/**
	 * ����ͳ��������ѯ���,�����������Ľ��������
	 */
	public List<IG011Info> findEquimentCountByCondition(IG011SearchCond cond) throws BLException {
		
		//List<EntityCount> ecList = ig011DAO.findByCond(cond, pDto.getFromCount(), pDto.getPageDispCount());
		if("0".equals(cond.getOrgType())){
			//��������
			List<IG011Info> ecList = ig011DAO.findByCond(cond, 0, 0);
			return ecList;
		}else{
			//ʹ�û���
			List<IG011Info> ecList = ig011DAO.findIG011InfoCondByUseOrg(cond, 0, 0);
			return ecList;
		}

	}
	
	/**
	 * ����ͳ��������ѯ���,�����������Ľ��������
	 */
	public List<IG445Info> findEquDistributingCountByCondition(IG445SearchCond cond) throws BLException {
		
		//��������
		List<IG445Info> edList = ig445DAO.findByCond(cond, 0, 0);
		return edList;
		
	}
	
	
	/**
	 * ���ݼ�����������ָ���ʲ�ģ���µ��ʲ�����б�
	 * @param cond ��������
	 * @return �ʲ�����б�
	 */
	public List<IG011Info> searchIG011InfoByEcatory(IG011SearchCond cond) throws BLException {
		//��������
		List<IG011Info> ecList = ig011DAO.findByCond(cond);
		return ecList;

	}
}
