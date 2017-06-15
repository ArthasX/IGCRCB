/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import com.csebank.lom.model.DealOrg;
import com.csebank.lom.model.EEOrg;
import com.csebank.lom.model.RecptionOrg;
import com.csebank.lom.util.LOMHelper;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * ���ŽӴ�����ͳ��VO
 *
 */
public class IGLOM01081VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * ���ŽӴ�����ͳ�Ƽ������
	 */
	protected List<RecptionOrg> recptionOrgVWList;
	/**
	 * ��������Ͳ͹���ͳ�Ƽ������
	 */
	protected List<DealOrg> dealOrgVWList;
	/**
	 * ʳ�ù���-ʳ���д����Ż��ܲ�ѯ���
	 */
	protected List<EEOrg> eeOrgVWList;
	
	/** �����ܽ�� */
	protected BigDecimal sumamount;
	
	/** ���������� */
	protected Integer sumdisnum;
	
	/** δ���������� */
	protected Integer sumennum;
	
	/** �Ӵ������� */
	protected Integer sumrnum;


	/**
	 * ���ŽӴ�����ͳ�Ƽ������ȡ��
	 * @return ���ŽӴ�����ͳ�Ƽ������
	 */
	public List<RecptionOrg> getRecptionOrgVWList() {
		return recptionOrgVWList;
	}

	/**
	 * ���ŽӴ�����ͳ�Ƽ������
	 * @param recptionList ���ŽӴ�����ͳ�Ƽ������
	 */
	public void setRecptionOrgVWList(List<RecptionOrg> recptionOrgVWList) {
		this.recptionOrgVWList = recptionOrgVWList;
		//�ϼ�
		RecptionOrg ro = null;
		BigDecimal dbamount = new BigDecimal(0);
		Integer dbdisnum = 0;
		Integer dbennum = 0;
		Integer dbrnum = 0;
		
		Iterator<RecptionOrg> it = recptionOrgVWList.iterator();
		while(it.hasNext()){
				ro = it.next();
				dbamount = LOMHelper.getAdd(dbamount, ro.getAmount());
				dbdisnum += ro.getDisnum();
				dbennum += ro.getEnnum();
				dbrnum += ro.getRnum();
		}	
		sumamount = dbamount;
		sumdisnum = dbdisnum;
		sumennum = dbennum;
		sumrnum = dbrnum;
	}

	/**
	 * �����ܽ��ȡ��
	 * @return �����ܽ��
	 */
	public BigDecimal getSumamount() {
		return sumamount;
	}

	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public Integer getSumdisnum() {
		return sumdisnum;
	}

	/**
	 * δ����������ȡ��
	 * @return δ����������
	 */
	public Integer getSumennum() {
		return sumennum;
	}

	/**
	 * �Ӵ�������ȡ��
	 * @return �Ӵ�������
	 */
	public Integer getSumrnum() {
		return sumrnum;
	}

	public List<DealOrg> getDealOrgVWList() {
		return dealOrgVWList;
	}

	public void setDealOrgVWList(List<DealOrg> dealOrgVWList) {
		this.dealOrgVWList = dealOrgVWList;
		//�ϼ�
		DealOrg ro = null;
		BigDecimal dbamount = new BigDecimal(0);
		Integer dbdisnum = 0;
		Integer dbennum = 0;
		Integer dbrnum = 0;
		
		Iterator<DealOrg> it = dealOrgVWList.iterator();
		while(it.hasNext()){
				ro = it.next();
				dbamount = LOMHelper.getAdd(dbamount, ro.getAmount());
				dbdisnum += ro.getDisnum();
				dbennum += ro.getEnnum();
				dbrnum += ro.getRnum();
		}	
		sumamount = dbamount;
		sumdisnum = dbdisnum;
		sumennum = dbennum;
		sumrnum = dbrnum;
	}


	public void setSumamount(BigDecimal sumamount) {
		this.sumamount = sumamount;
	}

	public void setSumdisnum(Integer sumdisnum) {
		this.sumdisnum = sumdisnum;
	}

	public void setSumennum(Integer sumennum) {
		this.sumennum = sumennum;
	}

	public void setSumrnum(Integer sumrnum) {
		this.sumrnum = sumrnum;
	}
	public List<EEOrg> getEeOrgVWList() {
		return eeOrgVWList;
	}

	public void setEeOrgVWList(List<EEOrg> eeOrgVWList) {
		this.eeOrgVWList = eeOrgVWList;
		//�ϼ�
		EEOrg ro = null;
		BigDecimal dbamount = new BigDecimal(0);
		Integer dbrnum = 0;
		
		Iterator<EEOrg> it = eeOrgVWList.iterator();
		while(it.hasNext()){
				ro = it.next();
				dbamount = LOMHelper.getAdd(dbamount, ro.getAmount());
				dbrnum += ro.getRnum();
		}	
		sumamount = dbamount;
		sumrnum = dbrnum;
	}

}
