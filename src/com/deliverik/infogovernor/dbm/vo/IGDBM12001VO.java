/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dbm.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.asset.model.CheckItemVWInfo;
import com.deliverik.infogovernor.asset.model.RiskPointVMInfo;
import com.deliverik.infogovernor.asset.model.RiskcaseVWInfo;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ������ȡVO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDBM12001VO extends BaseVO{

	/** ������Ϣ���� */
	protected List<IG500Info> prList;
	

	/** �ʲ���Ϣ���� */
	protected List<SOC0118Info> assetList;
	
	
	public List<SOC0118Info> getAssetList() {
		return assetList;
	}

	public void setAssetList(List<SOC0118Info> assetList) {
		this.assetList = assetList;
	}

	/** ��鹤������ */
	protected List<RiskCheckResult> rcrList;

	/**�ʲ��б�*/
	protected List<SOC0124Info> soc0124List;
	
	
	/**������*/
	protected  List<CheckItemVWInfo> checkItemList;
	/**���յ㼯��*/
	protected List<RiskPointVMInfo> riskPointList;
	
	/**�����¼�����*/
	protected List<RiskcaseVWInfo> riskcaseList;
	/**
	 * ������Ϣ����ȡ��
	 * @return prList ������Ϣ����
	 */
	public List<IG500Info> getPrList() {
		return prList;
	}

	/**
	 * ������Ϣ�����趨
	 * @param prList ������Ϣ����
	 */
	public void setPrList(List<IG500Info> prList) {
		this.prList = prList;
	}

	/**
	 * ��鹤������ȡ��
	 * @return rcrList ��鹤������
	 */
	public List<RiskCheckResult> getRcrList() {
		return rcrList;
	}

	/**
	 * ��鹤�������趨
	 * @param rcrList ��鹤������
	 */
	public void setRcrList(List<RiskCheckResult> rcrList) {
		this.rcrList = rcrList;
	}

	/**
	 * �ʲ��б�   ȡ��
	 * @return soc0124List �ʲ��б�
	 */
	public List<SOC0124Info> getSoc0124List() {
		return soc0124List;
	}

	/**
	 * �ʲ��б�   �趨
	 * @param soc0124List �ʲ��б�
	 */
	public void setSoc0124List(List<SOC0124Info> soc0124List) {
		this.soc0124List = soc0124List;
	}

	/**
	 * ������   ȡ��
	 * @return checkItemList ������
	 */
	public List<CheckItemVWInfo> getCheckItemList() {
		return checkItemList;
	}

	/**
	 * ������   �趨
	 * @param checkItemList ������
	 */
	public void setCheckItemList(List<CheckItemVWInfo> checkItemList) {
		this.checkItemList = checkItemList;
	}

	/**
	 * ���յ㼯��   ȡ��
	 * @return riskPointList ���յ㼯��
	 */
	public List<RiskPointVMInfo> getRiskPointList() {
		return riskPointList;
	}

	/**
	 * ���յ㼯��   �趨
	 * @param riskPointList ���յ㼯��
	 */
	public void setRiskPointList(List<RiskPointVMInfo> riskPointList) {
		this.riskPointList = riskPointList;
	}

	public List<RiskcaseVWInfo> getRiskcaseList() {
		return riskcaseList;
	}

	public void setRiskcaseList(List<RiskcaseVWInfo> riskcaseList) {
		this.riskcaseList = riskcaseList;
	}
	
	
	
}
