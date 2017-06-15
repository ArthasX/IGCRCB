/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.drm.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;


/**
 * <p>
 * Title : InfoGovernor Ӧ������
 * </p>
 * <p>
 * Description:ͳ�Ʒ���DTO
 * </p>
 * 
 * @author zhangjian@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM18DTO extends BaseDTO implements Serializable {
	
	/** �����ѯ������¼�� */
	protected int maxSearchCount;

	/** ��ҳBean */
	protected PagingDTO pagingDto;
	
	/** Ԥ��ͳ���б� */
	protected List<Map<String,Object>> planRateList;
	
	/**����ͳ��*/
	protected List<Map<String,Object>> drillRateList;
	
	/**��������ͳ��*/
	protected List<Map<String,Object>> drillTypeRateList;
	
	/**ר��Ԥ���б�*/
	protected List<SOC0124Info> planList;
	

	/**  
	 * ��ȡ�����ѯ������¼��  
	 * @return maxSearchCount �����ѯ������¼��  
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
	 * @return pagingDto ��ҳBean  
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

	public List<SOC0124Info> getPlanList() {
		return planList;
	}

	public void setPlanList(List<SOC0124Info> planList) {
		this.planList = planList;
	}

	/**
	 * Ԥ��ͳ���б�ȡ��
	 * @return planRateList Ԥ��ͳ���б�
	 */
	public List<Map<String, Object>> getPlanRateList() {
		return planRateList;
	}

	/**
	 * Ԥ��ͳ���б��趨
	 * @param planRateList Ԥ��ͳ���б�
	 */
	public void setPlanRateList(List<Map<String, Object>> planRateList) {
		this.planRateList = planRateList;
	}

	/**
	 * ����ͳ��ȡ��
	 * @return drillRateList ����ͳ��
	 */
	public List<Map<String, Object>> getDrillRateList() {
		return drillRateList;
	}

	/**
	 * ����ͳ���趨
	 * @param drillRateList ����ͳ��
	 */
	public void setDrillRateList(List<Map<String, Object>> drillRateList) {
		this.drillRateList = drillRateList;
	}

	/**
	 * ��������ͳ��ȡ��
	 * @return drillTypeRateList ��������ͳ��
	 */
	public List<Map<String, Object>> getDrillTypeRateList() {
		return drillTypeRateList;
	}

	/**
	 * ��������ͳ���趨
	 * @param drillTypeRateList ��������ͳ��
	 */
	public void setDrillTypeRateList(List<Map<String, Object>> drillTypeRateList) {
		this.drillTypeRateList = drillTypeRateList;
	}
}
