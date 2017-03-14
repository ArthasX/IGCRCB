package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.infogovernor.asset.form.IGASM2704Form;
import com.deliverik.infogovernor.asset.model.RiskCheckVWInfo;
import com.deliverik.infogovernor.asset.model.RiskPointVMInfo;
import com.deliverik.infogovernor.asset.model.RiskToZhRelateVWInfo;

/**
 * ���յ���ϸ��Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM27041VO extends BaseVO implements Serializable{
	
	/** ���յ���Ϣ */
	protected SOC0124Info entityItemData;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<SOC0129Info>> configItemVWInfoMap;

	/**
	 * ���캯��
	 * @param entityItemData���ʲ�����Ϣ
	 * @param configItemVWInfoMap���ʲ���������Ϣ�������
	 */
	public IGASM27041VO(SOC0124Info entityItemData,Map<String,List<SOC0129Info>> configItemVWInfoMap) {
		this.entityItemData = entityItemData;
		this.configItemVWInfoMap = configItemVWInfoMap;
	}
	/** ���յ������������� */
	protected String eiorgname;
	
	/** Ȩ�ޱ�ʶ */
	protected Boolean flag;
	
	/**���յ��ѯ */
	protected List<RiskPointVMInfo> riskPointList;
	/**�汾����*/
	protected Map<Integer,Integer> checkVersionMap;
	
	protected IGASM2704Form igASM2704Form;
	/**����---�����*/
	protected List<RiskCheckVWInfo> searchRiskCheckList;

	/**����---ָ��*/
	protected List<RiskToZhRelateVWInfo> riskToZhRelateList;
	
	/**
	 * ����---ָ��ȡ��
	 * @return riskToZhRelateList ����---ָ��
	 */
	public List<RiskToZhRelateVWInfo> getRiskToZhRelateList() {
		return riskToZhRelateList;
	}

	/**
	 * ����---ָ���趨
	 * @param riskToZhRelateList ����---ָ��
	 */
	public void setRiskToZhRelateList(List<RiskToZhRelateVWInfo> riskToZhRelateList) {
		this.riskToZhRelateList = riskToZhRelateList;
	}

	/**
	 * ����---�����ȡ��
	 * @return searchRiskCheckList ����---�����
	 */
	public List<RiskCheckVWInfo> getSearchRiskCheckList() {
		return searchRiskCheckList;
	}

	/**
	 * ����---������趨
	 * @param searchRiskCheckList ����---�����
	 */
	public void setSearchRiskCheckList(List<RiskCheckVWInfo> searchRiskCheckList) {
		this.searchRiskCheckList = searchRiskCheckList;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	
	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}
	/**
	 * ���յ���Ϣȡ��
	 * @return ���յ���Ϣ
	 */
	public SOC0124Info getEntityData() {
		return entityItemData;
	}
	
	/**
	 * �ʲ���������Ϣ�������ȡ��
	 * @return �ʲ���������Ϣ�������
	 */
	public Map<String, List<SOC0129Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}

	/**
	 * ���յ��ѯȡ��
	 * @return riskPointList ���յ��ѯ
	 */
	public List<RiskPointVMInfo> getRiskPointList() {
		return riskPointList;
	}

	/**
	 * ���յ��ѯ�趨
	 * @param riskPointList ���յ��ѯ
	 */
	public void setRiskPointList(List<RiskPointVMInfo> riskPointList) {
		this.riskPointList = riskPointList;
	}

	/**
	 * �汾����ȡ��
	 * @return checkVersionMap �汾����
	 */
	public Map<Integer, Integer> getCheckVersionMap() {
		return checkVersionMap;
	}

	/**
	 * �汾�����趨
	 * @param checkVersionMap �汾����
	 */
	public void setCheckVersionMap(Map<Integer, Integer> checkVersionMap) {
		this.checkVersionMap = checkVersionMap;
	}

	/**
	 * igASM2704Formȡ��
	 * @return igASM2704Form igASM2704Form
	 */
	public IGASM2704Form getIgASM2704Form() {
		return igASM2704Form;
	}

	/**
	 * igASM2704Form�趨
	 * @param igASM2704Form igASM2704Form
	 */
	public void setIgASM2704Form(IGASM2704Form igASM2704Form) {
		this.igASM2704Form = igASM2704Form;
	}
}


