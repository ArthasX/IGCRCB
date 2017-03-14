/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.infogovernor.risk.model.RiskAuditDefResultVWInfo;
import com.deliverik.infogovernor.risk.model.RiskAuditIns;

/**
 * ��ƽ����Ϣ��������֣�
 * 
 * @author liupeng@deliverik.com
 *
 */
@SuppressWarnings("serial")
public class IGRIS01171VO extends BaseVO implements Serializable{
	
	/** ������ƽ����Ϣ��������� */
	protected List<RiskAuditDefResultVWInfo> riskAuditDefResultVWInfoList;
	
	/** �������󼶴� */
	protected Integer radMaxLevel;
	
	/** ������list */
	protected List<Integer> radMaxLevelList;
	
	/** ͳ�Ƹ����������� */
	protected Map<String, Integer> childCountMap;
	
	/** �����������ճ̶�list */
	protected List<CodeDetail> radrisklevelList;
	
	/** �����������ճ̶�size */
	protected int radrisklevelSizeColspan = 1;
	
	/** ������������Ƶ��list */
	protected List<CodeDetail> radfrequencyList;
	
	/** ������������Ƶ��size */
	protected int radfrequencySizeColspan = 1;
	
	/** �������������ֶ�list */
	protected List<CodeDetail> radmodeList;
	
	/** �������������ֶ�size */
	protected int radmodeSizeColspan = 1;
	
	/** ����������������list */
	protected List<CodeDetail> radtypeList;
	
	/** ����������������size */
	protected int radtypeSizeColspan = 1;
	
	/** ��������ƶȽ�������list */
	protected List<CodeDetail> rarplanscoreList;

	/** ��������ƶȽ�������size */
	protected int rarplanscoreSizeColspan = 1;
	
	/** ��������ƶ�ִ������list */
	protected List<CodeDetail> rarexecscoreList;

	/** ��������ƶ�ִ������size */
	protected int rarexecscoreSizeColspan = 1;
	
	/** ���������������list */
	protected List<CodeDetail> raroverallscoreList;

	/** ���������������size */
	protected int raroverallscoreSizeColspan = 1;
	
	/** ������Ʒ�����Ϣ */
	protected RiskAuditIns riskAuditIns;
	
	/**
	 * ������ƽ����Ϣ���������ȡ��
	 * 
	 * @return ������ƽ����Ϣ���������
	 */
	public List<RiskAuditDefResultVWInfo> getRiskAuditDefResultVWInfoList() {
		return riskAuditDefResultVWInfoList;
	}

	/**
	 * ������ƽ����Ϣ����������趨
	 *
	 * @param riskAuditDefResultVWInfoList ������ƽ����Ϣ���������
	 */
	public void setRiskAuditDefResultVWInfoList(
			List<RiskAuditDefResultVWInfo> riskAuditDefResultVWInfoList) {
		this.riskAuditDefResultVWInfoList = riskAuditDefResultVWInfoList;
	}

	/**
	 * �������󼶴�ȡ��
	 * 
	 * @return �������󼶴�
	 */
	public Integer getRadMaxLevel() {
		return radMaxLevel;
	}
	
	/**
	 * �������󼶴��趨
	 *
	 * @param radMaxLevel �������󼶴�
	 */
	public void setRadMaxLevel(Integer radMaxLevel) {
		this.radMaxLevel = radMaxLevel;
	}
	
	/**
	 * ������listȡ��
	 * 
	 * @return ������list
	 */
	public List<Integer> getRadMaxLevelList() {
		return radMaxLevelList;
	}

	/**
	 * ������list�趨
	 *
	 * @param List<Integer> ������list
	 */
	public void setRadMaxLevelList(List<Integer> radMaxLevelList) {
		this.radMaxLevelList = radMaxLevelList;
	}
	
	/**
	 * ͳ�Ƹ�����������ȡ��
	 * 
	 * @return ͳ�Ƹ�����������
	 */
	public Map<String, Integer> getChildCountMap() {
		return childCountMap;
	}

	/**
	 * ͳ�Ƹ������������趨
	 *
	 * @param childCountMap ͳ�Ƹ�����������
	 */
	public void setChildCountMap(Map<String, Integer> childCountMap) {
		this.childCountMap = childCountMap;
	}

	/**
	 * �����������ճ̶�Listȡ��
	 * 
	 * @return �����������ճ̶�List
	 */
	public List<CodeDetail> getRadrisklevelList() {
		return radrisklevelList;
	}

	/**
	 * �����������ճ̶�List�趨
	 *
	 * @param radrisklevelList �����������ճ̶�List
	 */
	public void setRadrisklevelList(List<CodeDetail> radrisklevelList) {
		this.radrisklevelList = radrisklevelList;
		if(radrisklevelList != null && !radrisklevelList.isEmpty()) {
			radrisklevelSizeColspan = radrisklevelList.size();
		}
	}

	/**
	 * ������������Ƶ��listȡ��
	 * 
	 * @return ������������Ƶ��list
	 */
	public List<CodeDetail> getRadfrequencyList() {
		return radfrequencyList;
	}

	/**
	 * ������������Ƶ��list�趨
	 *
	 * @param radfrequencyList ������������Ƶ��list
	 */
	public void setRadfrequencyList(List<CodeDetail> radfrequencyList) {
		this.radfrequencyList = radfrequencyList;
		if(radfrequencyList != null && !radfrequencyList.isEmpty()) {
			radfrequencySizeColspan = radfrequencyList.size();
		}
	}

	/**
	 * �������������ֶ�listȡ��
	 * 
	 * @return �������������ֶ�list
	 */
	public List<CodeDetail> getRadmodeList() {
		return radmodeList;
	}

	/**
	 * �������������ֶ�list�趨
	 *
	 * @param radmodeList �������������ֶ�list
	 */
	public void setRadmodeList(List<CodeDetail> radmodeList) {
		this.radmodeList = radmodeList;
		if(radmodeList != null && !radmodeList.isEmpty()) {
			radmodeSizeColspan = radmodeList.size();
		}
	}

	/**
	 * ����������������listȡ��
	 * 
	 * @return ����������������list
	 */
	public List<CodeDetail> getRadtypeList() {
		return radtypeList;
	}

	/**
	 * ����������������list�趨
	 *
	 * @param radtypeList ����������������list
	 */
	public void setRadtypeList(List<CodeDetail> radtypeList) {
		this.radtypeList = radtypeList;
		if(radtypeList != null && !radtypeList.isEmpty()) {
			radtypeSizeColspan = radtypeList.size();
		}
	}

	/**
	 * ��������ƶȽ�������listȡ��
	 * 
	 * @return ��������ƶȽ�������list
	 */
	public List<CodeDetail> getRarplanscoreList() {
		return rarplanscoreList;
	}

	/**
	 * ��������ƶȽ�������list�趨
	 *
	 * @param rarplanscoreList ��������ƶȽ�������list
	 */
	public void setRarplanscoreList(List<CodeDetail> rarplanscoreList) {
		this.rarplanscoreList = rarplanscoreList;
		if(rarplanscoreList != null && !rarplanscoreList.isEmpty()) {
			rarplanscoreSizeColspan = rarplanscoreList.size();
		}
	}

	/**
	 * ��������ƶ�ִ������listȡ��
	 * 
	 * @return ��������ƶ�ִ������list
	 */
	public List<CodeDetail> getRarexecscoreList() {
		return rarexecscoreList;
	}

	/**
	 * ��������ƶ�ִ������list�趨
	 *
	 * @param rarexecscoreList ��������ƶ�ִ������list
	 */
	public void setRarexecscoreList(List<CodeDetail> rarexecscoreList) {
		this.rarexecscoreList = rarexecscoreList;
		if(rarexecscoreList != null && !rarexecscoreList.isEmpty()) {
			rarexecscoreSizeColspan = rarexecscoreList.size();
		}
	}

	/**
	 * ���������������listȡ��
	 * 
	 * @return ���������������list
	 */
	public List<CodeDetail> getRaroverallscoreList() {
		return raroverallscoreList;
	}

	/**
	 * ���������������list�趨
	 *
	 * @param raroverallscoreList ���������������list
	 */
	public void setRaroverallscoreList(List<CodeDetail> raroverallscoreList) {
		this.raroverallscoreList = raroverallscoreList;
		if(raroverallscoreList != null && !raroverallscoreList.isEmpty()) {
			raroverallscoreSizeColspan = raroverallscoreList.size();
		}
	}
	
	/**
	 * �����������ճ̶�sizeȡ��
	 * 
	 * @return �����������ճ̶�size
	 */
	public int getRadrisklevelSizeColspan() {
		return radrisklevelSizeColspan;
	}

	/**
	 * ������������Ƶ��sizeȡ��
	 * 
	 * @return ������������Ƶ��size
	 */
	public int getRadfrequencySizeColspan() {
		return radfrequencySizeColspan;
	}

	/**
	 * �������������ֶ�sizeȡ��
	 * 
	 * @return �������������ֶ�size
	 */
	public int getRadmodeSizeColspan() {
		return radmodeSizeColspan;
	}

	/**
	 * ����������������sizeȡ��
	 * 
	 * @return ����������������size
	 */
	public int getRadtypeSizeColspan() {
		return radtypeSizeColspan;
	}

	/**
	 * ��������ƶȽ�������sizeȡ��
	 * 
	 * @return ��������ƶȽ�������size
	 */
	public int getRarplanscoreSizeColspan() {
		return rarplanscoreSizeColspan;
	}

	/**
	 * ��������ƶ�ִ������sizeȡ��
	 * 
	 * @return ��������ƶ�ִ������size
	 */
	public int getRarexecscoreSizeColspan() {
		return rarexecscoreSizeColspan;
	}

	/**
	 * ���������������sizeȡ��
	 * 
	 * @return ���������������size
	 */
	public int getRaroverallscoreSizeColspan() {
		return raroverallscoreSizeColspan;
	}
	
	/**
	 * ������Ʒ�����Ϣȡ��
	 * 
	 * @return ������Ʒ�����Ϣ
	 */
	public RiskAuditIns getRiskAuditIns() {
		return riskAuditIns;
	}

	/**
	 * ������Ʒ�����Ϣ�趨
	 *
	 * @param riskAuditIns ������Ʒ�����Ϣ
	 */
	public void setRiskAuditIns(RiskAuditIns riskAuditIns) {
		this.riskAuditIns = riskAuditIns;
	}
	
}


