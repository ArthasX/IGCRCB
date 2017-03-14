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
import com.deliverik.infogovernor.risk.model.RiskAuditIns;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditInsSearchCond;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditInsSearchCondImpl;
import com.deliverik.infogovernor.risk.model.dao.RiskAuditInsDAO;

/**
 * 
 * ��Ʒ�����Ϣҵ���߼��ӿ�
 * @author liupeng@deliverik.com
 *
 */
public class RiskAuditInsBLImpl extends BaseBLImpl implements RiskAuditInsBL{
	
	/** RiskAuditIns DAO */
	protected RiskAuditInsDAO riskAuditInsDAO;
	
	public void setRiskAuditInsDAO(
			RiskAuditInsDAO riskAuditInsDAO) {
		this.riskAuditInsDAO = riskAuditInsDAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(RiskAuditInsSearchCond cond){
		
		return riskAuditInsDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param raiid ��Ʒ�����ϢID
	 * @return ��Ʒ�����Ϣ
	 */
	public RiskAuditIns searchRiskAuditInsByKey(Integer raiid) throws BLException{
		
		return checkExistRiskAuditIns(raiid);
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ����Ʒ�����Ϣ��Ϣ
	 */
	public List<RiskAuditIns> searchRiskAuditInsAll(){
		
		return riskAuditInsDAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskAuditIns> searchRiskAuditIns(RiskAuditInsSearchCond cond, int start, int count){
		
		return riskAuditInsDAO.findByCond(cond,start,count);
	}

	/**
	 * ��¼����
	 * 
	 * @param riskAuditIns ��¼����
	 * @return ��Ʒ�����Ϣ
	 */
	public RiskAuditIns registRiskAuditIns(RiskAuditIns riskAuditIns) throws BLException{
		
		checkNotExistRiskAuditIns(riskAuditIns.getRaicode());
		
		return riskAuditInsDAO.save(riskAuditIns);
	}

	/**
	 * ɾ������
	 * 
	 * @param raiid ��Ʒ�����ϢID
	 * @return
	 */
	public void deleteRiskAuditIns(Integer raiid) throws BLException{
		
		RiskAuditIns riskAuditIns = checkExistRiskAuditIns(raiid);
		
		riskAuditInsDAO.delete(riskAuditIns);
	}

	/**
	 * �������
	 * 
	 * @param riskAuditIns �������
	 * @return ��Ʒ�����Ϣ
	 */
	public RiskAuditIns updateRiskAuditIns(RiskAuditIns riskAuditIns) throws BLException{
		
		checkExistRiskAuditIns(riskAuditIns.getRaiid());
		return riskAuditInsDAO.save(riskAuditIns);
	}

	/**
	 * ��Ʒ�����Ϣ���ڼ��
	 * 
	 * @param raiid ��Ʒ�����ϢID
	 * @return ��Ʒ�����Ϣ
	 * @throws BLException 
	 */
	protected RiskAuditIns checkExistRiskAuditIns(Integer raiid) throws BLException{
		RiskAuditIns info = riskAuditInsDAO.findByPK(raiid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","��Ʒ������");
		}
		return info;
	}
	
	/**
	 * У�����Ƿ����
	 * 
	 * @param raicode ���
	 * @return
	 * @throws BLException 
	 */
	private void checkNotExistRiskAuditIns(String raicode) throws BLException{
		RiskAuditInsSearchCondImpl cond = new RiskAuditInsSearchCondImpl();
		
		cond.setRaicode(raicode);
		
		List<RiskAuditIns> raiList = riskAuditInsDAO.findByCond(cond, 0, 0);
		if( raiList != null && raiList.size()>0 ) {
			throw new BLException("IGRIS0110.E001");
		}
	}

	/**
	 * �汾�����б��ѯ
	 * 
	 * @return �汾�����б�
	 */
	public List<LabelValueBean> searchRiskAuditInsLabelInUse() {
		RiskAuditInsSearchCondImpl cond = new RiskAuditInsSearchCondImpl();
		
		cond.setRaistatus(IGRISCONSTANTS.RISKAUDITINS_STATUS_ENABLE);
		
		List<RiskAuditIns> raiList = riskAuditInsDAO.findByCond(cond,0,0);
		List<LabelValueBean> labelList= new ArrayList<LabelValueBean>();
		
		labelList.add(new LabelValueBean("",""));
		
		for (RiskAuditIns riskAuditIns : raiList) {
			labelList.add(new LabelValueBean(riskAuditIns.getRaicode(),riskAuditIns.getRaiid().toString()));
			
		}		
		return labelList;
	}
}
