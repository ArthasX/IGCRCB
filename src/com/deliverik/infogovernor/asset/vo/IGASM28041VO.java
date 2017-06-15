package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.infogovernor.asset.form.IGASM2814Form;
import com.deliverik.infogovernor.asset.model.CheckItemVWInfo;
import com.deliverik.infogovernor.asset.model.CheckToRiskRelateVWInfo;
import com.deliverik.infogovernor.asset.model.RiskToZhRelateVWInfo;

/**
 * �������ϸ��Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM28041VO extends BaseVO implements Serializable{
	
	/** �������Ϣ */
	protected SOC0124Info entityItemData;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<SOC0129Info>> configItemVWInfoMap;

	/**
	 * ���캯��
	 * @param entityItemData���ʲ�����Ϣ
	 * @param configItemVWInfoMap���ʲ���������Ϣ�������
	 */
	public IGASM28041VO(SOC0124Info entityItemData,Map<String,List<SOC0129Info>> configItemVWInfoMap) {
		this.entityItemData = entityItemData;
		this.configItemVWInfoMap = configItemVWInfoMap;
	}
	/** ����������������� */
	protected String eiorgname;
	
	/** Ȩ�ޱ�ʶ */
	protected Boolean flag;
	
	/**��������ݲ�ѯ*/
	protected IGASM2814Form igasm2814form;
	
	/**��������ݼ��ϲ�ѯ*/
	protected List<CheckItemVWInfo> itemList;
	/**�汾����*/
	protected Map<Integer,Integer> checkVersionMap;
	
	/**�������յ��ϵ����*/
	List<CheckToRiskRelateVWInfo> checkToRiskRelateList;
	
	/**�����---ָ��*/
	protected List<RiskToZhRelateVWInfo> riskToZhRelateList;
	
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
	 * @return igasm2814form ��������ݲ�ѯ
	 */
	public IGASM2814Form getIgasm2814form() {
		return igasm2814form;
	}

	/**
	 * ��������ݲ�ѯ�趨
	 * @param igasm2814form ��������ݲ�ѯ
	 */
	public void setIgasm2814form(IGASM2814Form igasm2814form) {
		this.igasm2814form = igasm2814form;
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
}


