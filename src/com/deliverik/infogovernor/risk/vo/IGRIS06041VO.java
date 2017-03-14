package com.deliverik.infogovernor.risk.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.infogovernor.asset.model.CheckItemVWInfo;
import com.deliverik.infogovernor.asset.model.CheckToRiskRelateVWInfo;
import com.deliverik.infogovernor.asset.model.RiskToZhRelateVWInfo;
import com.deliverik.infogovernor.risk.form.IGRIS0604Form;
import com.deliverik.infogovernor.risk.form.IGRIS0614Form;

/**
 * �������ϸ��Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGRIS06041VO extends BaseVO implements Serializable{
	
	/** �������Ϣ */
	protected SOC0124Info entityItemData;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<SOC0129Info>> configItemVWInfoMap;

	/**
	 * ���캯��
	 * @param entityItemData���ʲ�����Ϣ
	 * @param configItemVWInfoMap���ʲ���������Ϣ�������
	 */
	public IGRIS06041VO(SOC0124Info entityItemData,Map<String,List<SOC0129Info>> configItemVWInfoMap) {
		this.entityItemData = entityItemData;
		this.configItemVWInfoMap = configItemVWInfoMap;
	}
	/** ����������������� */
	protected String eiorgname;
	
	/** Ȩ�ޱ�ʶ */
	protected Boolean flag;
	
	/**��������ݲ�ѯ*/
	protected IGRIS0614Form igris0614form;
	
	protected IGRIS0604Form igris0604Form;
	
	/**��������ݼ��ϲ�ѯ*/
	protected List<CheckItemVWInfo> itemList;
	/**�汾����*/
	protected Map<Integer,Integer> checkVersionMap;
	
	/**�������յ��ϵ����*/
	List<CheckToRiskRelateVWInfo> checkToRiskRelateList;
	
	/**�����---ָ��*/
	protected List<RiskToZhRelateVWInfo> riskToZhRelateList;
	
	/**�����������Ϣ*/
	protected List<SOC0109Info> soc0109List;
	/**
	 * �����---ָ��ȡ��
	 * @return riskToZhRelateList �����---ָ��
	 */
	public List<RiskToZhRelateVWInfo> getRiskToZhRelateList() {
		return riskToZhRelateList;
	}

	/**
	 * �����---ָ���趨
	 * @param riskToZhRelateList �����---ָ��
	 */
	public void setRiskToZhRelateList(List<RiskToZhRelateVWInfo> riskToZhRelateList) {
		this.riskToZhRelateList = riskToZhRelateList;
	}

	/**
	 * �������յ��ϵ����ȡ��
	 * @return checkToRiskRelateList �������յ��ϵ����
	 */
	public List<CheckToRiskRelateVWInfo> getCheckToRiskRelateList() {
		return checkToRiskRelateList;
	}

	/**
	 * �������յ��ϵ�����趨
	 * @param checkToRiskRelateList �������յ��ϵ����
	 */
	public void setCheckToRiskRelateList(
			List<CheckToRiskRelateVWInfo> checkToRiskRelateList) {
		this.checkToRiskRelateList = checkToRiskRelateList;
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
	 * ��������ݼ��ϲ�ѯȡ��
	 * @return itemList ��������ݼ��ϲ�ѯ
	 */
	public List<CheckItemVWInfo> getItemList() {
		return itemList;
	}

	/**
	 * ��������ݼ��ϲ�ѯ�趨
	 * @param itemList ��������ݼ��ϲ�ѯ
	 */
	public void setItemList(List<CheckItemVWInfo> itemList) {
		this.itemList = itemList;
	}

	/**
	 * ��������ݲ�ѯȡ��
	 * @return igris0614form ��������ݲ�ѯ
	 */
	public IGRIS0614Form getIgris0614form() {
		return igris0614form;
	}

	/**
	 * ��������ݲ�ѯ�趨
	 * @param igris0614form ��������ݲ�ѯ
	 */
	public void setIgris0614form(IGRIS0614Form igris0614form) {
		this.igris0614form = igris0614form;
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
	 * �������Ϣȡ��
	 * @return �������Ϣ
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
	 * �����������Ϣȡ��
	 * @return soc0109List  �����������Ϣ
	 */
	public List<SOC0109Info> getSoc0109List() {
		return soc0109List;
	}

	/**
	 * �����������Ϣ�趨
	 * @param soc0109List  �����������Ϣ
	 */
	public void setSoc0109List(List<SOC0109Info> soc0109List) {
		this.soc0109List = soc0109List;
	}

	/**
	 * @return the igris0604Form
	 */
	public IGRIS0604Form getIgris0604Form() {
		return igris0604Form;
	}

	/**
	 * @param igris0604Form the igris0604Form to set
	 */
	public void setIgris0604Form(IGRIS0604Form igris0604Form) {
		this.igris0604Form = igris0604Form;
	}
	
}


