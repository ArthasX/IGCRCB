/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.bl.task.IG482BL;
import com.deliverik.framework.workflow.prd.model.IG482Info;
import com.deliverik.framework.workflow.prd.model.condition.IG482SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.IG485Info;
import com.deliverik.framework.workflow.prr.model.condition.IG485SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG485DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG224VW;
import com.deliverik.framework.workflow.prr.model.entity.IG485PK;
import com.deliverik.framework.workflow.prr.model.entity.IG485TB;
import com.deliverik.framework.workflow.prr.model.entity.IG485VW;

/**
  * ����: �����������ϵʵ����ҵ���߼�ʵ��
  * ��������: �����������ϵʵ����ҵ���߼�ʵ��
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public class IG485BLImpl extends BaseBLImpl implements
		IG485BL {

	/** �����������ϵʵ����DAO�ӿ� */
	protected IG485DAO ig485DAO;
	
	/** �����������ϵ����BL */
	protected IG482BL ig482BL;
	
	/**
	 * �����������ϵʵ����DAO�ӿ��趨
	 *
	 * @param ig485DAO �����������ϵʵ����DAO�ӿ�
	 */
	public void setIg485DAO(IG485DAO ig485DAO) {
		this.ig485DAO = ig485DAO;
	}
	
	/**
	 * �����������ϵ����BL�趨
	 * @param ig482BL �����������ϵ����BL
	 */
	public void setIg482BL(IG482BL ig482BL) {
		this.ig482BL = ig482BL;
	}

	/**
	 * �����������ϵʵ����ʵ��ȡ��
	 *
	 * @return �����������ϵʵ����ʵ��
	 */
	public IG485TB getIG485TBInstance() {
		return new IG485TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG485Info> searchIG485() {
		return ig485DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG485Info searchIG485ByPK(IG485PK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG485SearchCond cond) {
		return ig485DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG485Info> searchIG485(
			IG485SearchCond cond) {
		return ig485DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG485Info> searchIG485(
			IG485SearchCond cond, int start,
			int count) {
		return ig485DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG485Info registIG485(IG485Info instance)
		throws BLException {
		return ig485DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG485Info updateIG485(IG485Info instance)
		throws BLException {
		checkExistInstance(new IG485PK(instance.getPgreid(), instance.getPgrid(), instance.getPrid()));
		return ig485DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG485ByPK(IG485PK pk)
		throws BLException {
		ig485DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG485(IG485Info instance)
		throws BLException {
		ig485DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG485Info checkExistInstance(IG485PK pk)
		throws BLException {
		IG485Info instance = ig485DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	
	/**
	 * �ж�ָ��״̬�Ƿ���Ҫ����
	 * @param prid Ӱ������ID
	 * @param pgrid ������ʵ��ID
	 * @param pgdid �����鶨��ID
	 * @param ipsdid Ӱ��״̬ID
	 * @return �Ƿ���Ҫ����
	 */
	public boolean checkPend(Integer pgrid, String pgdid, String ipsdid) {
		//��ѯ������ʵ����Ӱ������״̬������Ĳο�״̬�Ĵ�����ɼ�¼
		List<Object[]> lst_Object = ig485DAO.checkPend(pgrid, pgdid, ipsdid);
		if(lst_Object.isEmpty()) {
			return false; 
		}
		Set<String> set_NotDone = new HashSet<String>();//δ��ɹ�ϵʵ���еĲο�״̬ID
		Set<String> set_Done = new HashSet<String>();//����ɹ�ϵʵ���еĲο�״̬ID
		for(Object[] obj : lst_Object) {
			if(obj[1] == null || "0".equals(obj[1].toString())) {//��pgrrstatus=0 or null��δ���
				set_NotDone.add(obj[0].toString());
			}
			if("1".equals(obj[1].toString())) {//��pgrrstatus=1�������
				set_Done.add(obj[0].toString());
			}
		}
		//ͬһ�ο�״̬�����ж����ϵʵ����ȡ���ϵ
		for(String notDone : set_NotDone) {
			if(!set_Done.contains(notDone)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * �ж�ָ���ο�״̬�������ʱ�����Ӧ��Ӱ��״̬��������Ƿ�ԾǨ
	 * @param prid Ӱ������ID
	 * @param pgrid ������ʵ��ID
	 * @param pgdid �����鶨��ID
	 * @param rpsdid �ο�״̬ID
	 * @param rtpsdid �ο�����Ŀ��״̬ID����
	 * @return ԾǨ����ID����
	 */
	public List<IG224VW> searchTriggerPrid(Integer prid, Integer pgrid,
			String pgdid, String rpsdid, List<String> rtpsdids) {
		List<IG224VW> lst_TriggerPrid = new ArrayList<IG224VW>();
		//���ݲο�״̬��ѯ��Ӱ���״̬ID�����ж��
		IG482SearchCondImpl cond = new IG482SearchCondImpl();
		cond.setPgdid(pgdid);
		cond.setRpsdid(rpsdid);
		List<IG482Info> lst_ig482 = ig482BL.searchIG482(cond);
		//�����ظ���Ӱ��״̬ID
		Set<String> lst_ipsdid = new HashSet<String>();
		for(IG482Info ig482 : lst_ig482) {
			//���������ϵû�ж��崥����������Ϊ�κι����ܴ����������̣�����ƥ��Ŀ��״̬
			if(StringUtils.isEmpty(ig482.getRtpsdid()) || rtpsdids.contains(ig482.getRtpsdid())){
				lst_ipsdid.add(ig482.getIpsdid());
			}
		}
		
		//����Ӱ��״̬ID����ѯ������ʵ���е�����ʵ��
		for(String ipsdid : lst_ipsdid) {
			List<IG224VW> lst_prid = ig485DAO.searchPendPrid(pgrid, ipsdid);
			for(IG224VW obj : lst_prid) {
				//���ݵõ�������ʵ��ID���͸����̶�Ӧ��Ӱ��״̬ID���жϸ������Ƿ����
				boolean isPend = checkPend(pgrid, pgdid, ipsdid);
				//���δ�����򴥷�Ӱ������ԾǨ
				if(!isPend) {
					lst_TriggerPrid.add(obj);
				}
			}
		}
		return lst_TriggerPrid;
	}
	
	/**
	 * ��ѯ������ϵʵ��δ�����¼
	 * @param prid �ο�����ID
	 * @param rpsdid �ο�����״̬ID
	 * @return δ�����¼
	 */
	public List<IG485VW> searchNotDone(Integer prid, String rpsdid) {
		return this.ig485DAO.searchNotDone(prid, rpsdid);
	}

}