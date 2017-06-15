/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dbm.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.asset.model.CheckItemVWInfo;
import com.deliverik.infogovernor.asset.model.RiskPointVMInfo;
import com.deliverik.infogovernor.asset.model.RiskcaseVWInfo;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;

@SuppressWarnings("serial")
public class IGDBM12DTO extends BaseDTO{
	
	/*���񹤵�ֵ*/
	protected String swoValue;
	
	/*�����걨ֵ*/
	protected String ftdValue;
	
	/*��������*/
	protected String serValue;
	
	/*�¼�*/
	protected String teValue;
	
	/*����*/
	protected String tpValue;
	
	/*���*/
	protected String chaValue;
	
	/*����*/
	protected String reqValue;
	
	/*ָ��*/
	protected String assValue;

	/*����һ����Ҫxml�����ַ���*/
	protected String resultXML;
	
	/*�������������ù���������Ӧ��PRPDID*/
	private String workValue;
	
	/** ajax��� */
	protected String ajaxResult;
	
	/*�Ƽ�����һ���񹤵��������걨��ҵ���������*/
	protected String processCountYW;
	
	/*�Ƽ�����һ�¼������⡢������Ƽ���������ָ��*/
	protected String processCountKJ;
	
	/*�Ƽ����� -���յ㡢�������ռƻ����������񡢷����嵥����������*/
	protected String riskCounter;
	/**������*/
	protected  List<CheckItemVWInfo> checkItemList;
	/**���յ㼯��*/
	protected List<RiskPointVMInfo> riskPointList;
	/**�����¼�����*/
	protected List<RiskcaseVWInfo> riskcaseList;

	public String getRiskCounter() {
		return riskCounter;
	}

	public void setRiskCounter(String riskCounter) {
		this.riskCounter = riskCounter;
	}
	/** �ʲ���Ϣ���� */
	protected List<SOC0118Info> assetList;
	
	public List<SOC0118Info> getAssetList() {
		return assetList;
	}

	public void setAssetList(List<SOC0118Info> assetList) {
		this.assetList = assetList;
	}
	/*�Ƽ�*/
	protected String sciValue;
	/*ҵ��*/
	protected String busiValue;
	
	/**�����ѯ������¼��*/
	protected int maxSearchCount;

	/**��ҳBean*/
	protected PagingDTO pagingDto;
	
	/** ������Ϣ���� */
	protected List<IG500Info> prList;
	
	/** ��鹤������ */
	protected List<RiskCheckResult> rcrList;
	
	/**�ʲ��б�*/
	protected List<SOC0124Info> soc0124List;
	
	public String getSwoValue() {
		return swoValue;
	}

	public void setSwoValue(String swoValue) {
		this.swoValue = swoValue;
	}

	public String getFtdValue() {
		return ftdValue;
	}

	public void setFtdValue(String ftdValue) {
		this.ftdValue = ftdValue;
	}

	public String getSerValue() {
		return serValue;
	}

	public void setSerValue(String serValue) {
		this.serValue = serValue;
	}

	public String getTeValue() {
		return teValue;
	}

	public void setTeValue(String teValue) {
		this.teValue = teValue;
	}

	public String getTpValue() {
		return tpValue;
	}

	public void setTpValue(String tpValue) {
		this.tpValue = tpValue;
	}

	public String getChaValue() {
		return chaValue;
	}

	public void setChaValue(String chaValue) {
		this.chaValue = chaValue;
	}

	public String getReqValue() {
		return reqValue;
	}

	public void setReqValue(String reqValue) {
		this.reqValue = reqValue;
	}

	public String getAssValue() {
		return assValue;
	}

	public void setAssValue(String assValue) {
		this.assValue = assValue;
	}

	public String getResultXML() {
		return resultXML;
	}

	public void setResultXML(String resultXML) {
		this.resultXML = resultXML;
	}

	public String getWorkValue() {
		return workValue;
	}

	public void setWorkValue(String workValue) {
		this.workValue = workValue;
	}

	/**
	 * ajax���ȡ��
	 * @return ajaxResult ajax���
	 */
	public String getAjaxResult() {
		return ajaxResult;
	}

	/**
	 * ajax����趨
	 * @param ajaxResult ajax���
	 */
	public void setAjaxResult(String ajaxResult) {
		this.ajaxResult = ajaxResult;
	}


	/**
	 * �Ƽ�����һ���񹤵��������걨��ҵ���������ȡ��
	 * @return processCountYW �Ƽ�����һ���񹤵��������걨��ҵ���������
	 */
	public String getProcessCountYW() {
		return processCountYW;
	}

	/**
	 * �Ƽ�����һ���񹤵��������걨��ҵ����������趨
	 * @param processCountYW �Ƽ�����һ���񹤵��������걨��ҵ���������
	 */
	public void setProcessCountYW(String processCountYW) {
		this.processCountYW = processCountYW;
	}


	/**
	 * �Ƽ�����һ�¼������⡢������Ƽ���������ָ��ȡ��
	 * @return processCountKJ �Ƽ�����һ�¼������⡢������Ƽ���������ָ��
	 */
	public String getProcessCountKJ() {
		return processCountKJ;
	}

	/**
	 * �Ƽ�����һ�¼������⡢������Ƽ���������ָ���趨
	 * @param processCountKJ �Ƽ�����һ�¼������⡢������Ƽ���������ָ��
	 */
	public void setProcessCountKJ(String processCountKJ) {
		this.processCountKJ = processCountKJ;
	}
	
	/**
	 * ��ȡ�����ѯ������¼��
	 * @return �����ѯ������¼��
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * ���������ѯ������¼��
	 * @param maxSearchCount �����ѯ������¼��
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}
	

	/**
	 * ��ȡ��ҳBean
	 * @return ��ҳBean
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ���÷�ҳBean
	 * @param pagingDto ��ҳBean
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	public String getSciValue() {
		return sciValue;
	}

	public void setSciValue(String sciValue) {
		this.sciValue = sciValue;
	}

	public String getBusiValue() {
		return busiValue;
	}

	/**
	 * @param busiValue
	 */
	public void setBusiValue(String busiValue) {
		this.busiValue = busiValue;
	}

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
