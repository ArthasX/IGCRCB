/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.model.IG433Info;
import com.deliverik.framework.workflow.prd.model.IG567Info;
import com.deliverik.framework.workflow.prd.model.condition.IG433SearchCond;
import com.deliverik.framework.workflow.prd.model.dao.IG433DAO;
import com.deliverik.framework.workflow.prd.model.dao.IG567DAO;

/**
 * <p>����:����ȱʡ�����߶���Ȩ�޲���ҵ���߼�ʵ��</p>
 * <p>����������1.�رջ���ֹ����ȡ��</p>
 * <p>������¼��</p>
 */
public class IG433BLImpl extends BaseBLImpl implements IG433BL {

	/** ig567 DAO */
	protected IG567DAO ig567DAO;
	
	/** ig433 DAO */
	protected IG433DAO ig433DAO;
	
	/**
	 * ���ܣ���������DAO
	 * @param ig567DAO ��������dao
	 */
	public void setIg567DAO(
			IG567DAO ig567DAO) {
		this.ig567DAO = ig567DAO;
	}

	/**
	 * ���ܣ���������DAO
	 * @param ig433DAO ��������dao
	 */
	public void setIg433DAO(IG433DAO ig433DAO) {
		this.ig433DAO = ig433DAO;
	}



	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG567Info> searchIG567Info(IG433SearchCond cond, int start, int count){
		
		List<IG567Info> ret = ig567DAO.findByCond(cond,start,count);
		return ret;
	}

	/**
	 * ���ܣ��־û�����
	 * 
	 * @param IncomeAdjustʵ����
	 * @return IncomeAdjustʵ����
	 */
	public IG433Info saveIG567Info(
			IG433Info processAssessment) throws BLException {
		return ig433DAO.save(processAssessment);
	}

	public IG433Info findIG567Info(
			IG433SearchCond cond, int start, int count) {
		if(ig433DAO.findByCond_Entity(cond, 0, 0)!=null && ig433DAO.findByCond_Entity(cond, 0, 0).size()>0){
		return ig433DAO.findByCond_Entity(cond, 0, 0).get(0);
		}else{
			return null;
		}
	}

}
