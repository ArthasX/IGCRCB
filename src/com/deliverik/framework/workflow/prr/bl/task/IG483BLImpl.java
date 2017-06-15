/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.prd.bl.task.IG480BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowGroupSerialnumGeneratorBL;
import com.deliverik.framework.workflow.prd.model.IG480Info;
import com.deliverik.framework.workflow.prr.model.IG483Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG483SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG483DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG483TB;

/**
  * ����: ������ʵ����ҵ���߼�ʵ��
  * ��������: ������ʵ����ҵ���߼�ʵ��
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public class IG483BLImpl extends BaseBLImpl implements
		IG483BL {

	/** ������ʵ����DAO�ӿ� */
	protected IG483DAO ig483DAO;

	
	/** �����鶨��BL */
	protected IG480BL ig480BL;
	
	/**
	 * ������ʵ����DAO�ӿ��趨
	 *
	 * @param ig483DAO ������ʵ����DAO�ӿ�
	 */
	public void setIg483DAO(IG483DAO ig483DAO) {
		this.ig483DAO = ig483DAO;
	}
	

	/**
	 * �����鶨��BL�趨
	 * @param ig480BL �����鶨��BL
	 */
	public void setIg480BL(IG480BL ig480BL) {
		this.ig480BL = ig480BL;
	}
	/**
	 * ������ʵ����ʵ��ȡ��
	 *
	 * @return ������ʵ����ʵ��
	 */
	public IG483TB getIG483TBInstance() {
		return new IG483TB();
	}
	
	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG483Info> searchIG483() {
		return ig483DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG483Info searchIG483ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG483SearchCond cond) {
		return ig483DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG483Info> searchIG483(
			IG483SearchCond cond) {
		return ig483DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG483Info> searchIG483(
			IG483SearchCond cond, int start,
			int count) {
		return ig483DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public synchronized IG483Info registIG483(IG483Info instance)
		throws BLException {
		//�����鶨��
				IG480Info ig480 = this.ig480BL.searchIG480ByPK(instance.getPgdid());
				
				//���ɹ�����
				if(ig480 != null && StringUtils.isNotEmpty(ig480.getSerialGenerator())) {
					WorkFlowGroupSerialnumGeneratorBL bl = null;
					try {
						bl = (WorkFlowGroupSerialnumGeneratorBL)WebApplicationSupport.getBean(ig480.getSerialGenerator());
					} catch (Exception e) {
						throw new BLException("IGCO10000.E004", "����������������");
					}
					((IG483TB)instance).setPgrserialnum(bl.serialnumGenerator(instance.getPgdid()));//�Զ������
				} else {
					((IG483TB)instance).setPgrserialnum(this.getSerialNum(instance.getPttype()));//Ĭ�Ϲ���
				}
				
				return ig483DAO.save(instance);
	}

	/**
	 * ��ˮ�ţ�WG+2λ��+6λ��ˮ��
	 * @param ptType ����ģ������
	 * @return ��ˮ��
	 */
	protected String getSerialNum(String ptType){
		String pgrserialnum = "";
		Calendar c = Calendar.getInstance();
		pgrserialnum = ptType + String.valueOf(c.get(Calendar.YEAR)).substring(2);
		String maxSerialNum =  ig483DAO.getMaxPgrserialnum(pgrserialnum);
		if(null == maxSerialNum){
			return pgrserialnum + StringUtils.leftPad("1", 6 ,"0");
		}
		//��ϳ������ΪWDP+��+��ˮ�ţ��޸Ľ�ȡ����Ϊpgrserialnum.length()
		int maxNumber = Integer.valueOf(maxSerialNum.substring(pgrserialnum.length())) + 1;
		pgrserialnum = pgrserialnum + StringUtils.leftPad(String.valueOf(maxNumber), 6,"0");
		return pgrserialnum;
	}
	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG483Info updateIG483(IG483Info instance)
		throws BLException {
		checkExistInstance(instance.getPgrid());
		return ig483DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG483ByPK(Integer pk)
		throws BLException {
		ig483DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG483(IG483Info instance)
		throws BLException {
		ig483DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG483Info checkExistInstance(Integer pk)
		throws BLException {
		IG483Info instance = ig483DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	
	/**
	 * ��ѯ�������Ա�б�
	 * @param pgrid ������ID
	 * @return �������Ա�б�
	 */
	public List<IG500Info> searchProcess(Integer pgrid) {
		return ig483DAO.searchProcess(pgrid);
	}
	
	/**
	 * ��ѯ�������ⷢ�������prid
	 * @param pgrid ��������-������ʵ��ID
	 */
	public List<Map<String,Object>> searchProcessInfoByCond(final int pgrid) {
		return ig483DAO.searchProcessInfoByCond(pgrid);
    }

}