/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.risk.bl.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.risk.bl.IGRISCONSTANTS;
import com.deliverik.infogovernor.risk.model.RiskAudit;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditSearchCond;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditSearchCondImpl;
import com.deliverik.infogovernor.risk.model.dao.RiskAuditDAO;

/**
 * 
 * �����Ϣҵ���߼��ӿ�
 * @author liupeng@deliverik.com
 *
 */
public class RiskAuditBLImpl extends BaseBLImpl implements RiskAuditBL{
	
	/** RiskAudit DAO */
	protected RiskAuditDAO riskAuditDAO;
	
	public void setRiskAuditDAO(
			RiskAuditDAO riskAuditDAO) {
		this.riskAuditDAO = riskAuditDAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(RiskAuditSearchCond cond){
		
		return riskAuditDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param raid �����ϢID
	 * @return �����Ϣ
	 */
	public RiskAudit searchRiskAuditByKey(Integer raid) throws BLException{
		
		return checkExistRiskAudit(raid);
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ�������Ϣ��Ϣ
	 */
	public List<RiskAudit> searchRiskAuditAll(){
		
		return riskAuditDAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskAudit> searchRiskAudit(RiskAuditSearchCond cond, int start, int count){
		
		return riskAuditDAO.findByCond(cond,start,count);
	}

	/**
	 * ��¼����
	 * 
	 * @param riskAudit ��¼����
	 * @return �����Ϣ
	 */
	public RiskAudit registRiskAudit(RiskAudit riskAudit) throws BLException{
		
		checkNotExistRiskAudit(riskAudit.getRaversion());
		
		return riskAuditDAO.save(riskAudit);
	}

	/**
	 * ɾ������
	 * 
	 * @param raid �����ϢID
	 * @return
	 */
	public void deleteRiskAudit(Integer raid) throws BLException{
		
		RiskAudit riskAudit = checkExistRiskAudit(raid);
		
		riskAuditDAO.delete(riskAudit);
	}

	/**
	 * �������
	 * 
	 * @param riskAudit �������
	 * @return �����Ϣ
	 */
	public RiskAudit updateRiskAudit(RiskAudit riskAudit) throws BLException{
		
		checkExistRiskAudit(riskAudit.getRaid());
		return riskAuditDAO.save(riskAudit);
	}

	/**
	 * �����Ϣ���ڼ��
	 * 
	 * @param raid �����ϢID
	 * @return �����Ϣ
	 * @throws BLException 
	 */
	protected RiskAudit checkExistRiskAudit(Integer raid) throws BLException{
		RiskAudit info = riskAuditDAO.findByPK(raid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","��ƻ���");
		}
		return info;
	}
	
	/**
	 * У��汾�����Ƿ����
	 * 
	 * @param raversion �汾����
	 * @return
	 * @throws BLException 
	 */
	private void checkNotExistRiskAudit(String raversion) throws BLException{
		RiskAuditSearchCondImpl cond = new RiskAuditSearchCondImpl();
		
		cond.setRaversion(raversion);
		
		List<RiskAudit> raList = riskAuditDAO.findByCond(cond, 0, 0);
		if( raList != null && raList.size()>0 ) {
			throw new BLException("IGRIS0102.E001");
		}
	}
	
	/**
	 * �汾�����б��ѯ
	 * 
	 * @return �汾�����б�
	 */
	public List<LabelValueBean> searchRiskAuditLabelInUse() {
		RiskAuditSearchCondImpl cond = new RiskAuditSearchCondImpl();
		
		cond.setRastatus(IGRISCONSTANTS.RISKAUDIT_STATUS_ENABLE);
		
		List<RiskAudit> raList = riskAuditDAO.findByCond(cond,0,0);
		
		List<LabelValueBean> labelList= new ArrayList<LabelValueBean>();
		
		labelList.add(new LabelValueBean("",""));
		
		for(RiskAudit ra : raList) {
			labelList.add(new LabelValueBean(ra.getRaversion(),ra.getRaid().toString()));
		}
		
		return labelList;
	}
	
	/**
	 * ��ȡ��ǰ���汾����ʶ
	 * @return ���汾����ʶ
	 */
	
	public String getMaxRacode() {
		return riskAuditDAO.getMaxRacode();
	}
}
