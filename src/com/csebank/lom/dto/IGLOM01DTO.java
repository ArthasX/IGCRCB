/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.dto;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.form.IGLOM0101Form;
import com.csebank.lom.form.IGLOM0102Form;
import com.csebank.lom.form.IGLOM0103Form;
import com.csebank.lom.form.IGLOM0104Form;
import com.csebank.lom.form.IGLOM0107Form;
import com.csebank.lom.form.IGLOM0109Form;
import com.csebank.lom.form.IGLOM0115Form;
import com.csebank.lom.model.Deal;
import com.csebank.lom.model.DealAmount;
import com.csebank.lom.model.DealOrg;
import com.csebank.lom.model.DealVWInfo;
import com.csebank.lom.model.GuestRecption;
import com.csebank.lom.model.Recption;
import com.csebank.lom.model.RecptionAmount;
import com.csebank.lom.model.RecptionCost;
import com.csebank.lom.model.RecptionGuest;
import com.csebank.lom.model.RecptionGuestInfo;
import com.csebank.lom.model.RecptionOrg;
import com.csebank.lom.model.RecptionVWInfo;
import com.csebank.lom.model.condition.DealOrgVWSearchCond;
import com.csebank.lom.model.condition.DealSearchCond;
import com.csebank.lom.model.condition.DealVWSearchCond;
import com.csebank.lom.model.condition.RecptionGuestInfoCond;
import com.csebank.lom.model.condition.RecptionGuestSearchCond;
import com.csebank.lom.model.condition.RecptionOrgVWSearchCond;
import com.csebank.lom.model.condition.RecptionSearchCond;
import com.csebank.lom.model.condition.RecptionVWSearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;

/**
 * 
 * �Ӵ�����DTO
 *
 */
@SuppressWarnings("serial")
public class IGLOM01DTO extends BaseDTO implements Serializable {
	

	/** �Ӵ������ѯ���� */
	protected RecptionSearchCond recptionSearchCond;

	/** �Ӵ����˹����ѯ���� */
	protected RecptionGuestSearchCond recptionGuestSearchCond;
	
	/** �Ӵ�ͳ�Ʋ�ѯ���� */
	protected RecptionVWSearchCond recptionVWSearchCond;
	
	/** ���ŽӴ�ͳ�Ʋ�ѯ���� */
	protected RecptionOrgVWSearchCond recptionOrgVWSearchCond;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;

	/** �Ӵ���Ϣ���������� */
	protected int maxSearchCount;
	
	/** �Ӵ���ϢForm */
	protected IGLOM0101Form iglom0101Form;
	
	/** �Ӵ�����Form */
	protected IGLOM0102Form iglom0102Form;
	
	/** �Ӵ���������Form */
	protected IGLOM0103Form iglom0103Form;
	
	/** �Ӵ����˹���Form */
	protected IGLOM0104Form iglom0104Form;
	
	/** �Ӵ����� */
	protected Recption recption;
	
	/** �Ӵ�������������� */
	protected List<Recption> recptionList;
	
	/** �Ӵ����� */
	protected RecptionGuest recptionGuest;
	
	/** �Ӵ�������������� */
	protected List<RecptionGuest> recptionGuestList;
	
	/** �Ӵ�ͳ����������� */
	protected List<RecptionVWInfo> recptionVWList;
	
	/** ���ŽӴ�ͳ����������� */
	protected List<RecptionOrg> recptionOrgVWList;
	
	/** �Ӵ��������������(����) */
	protected List<RecptionAmount> recptionAmountList;
	/** �Ӵ��������������(����) */
	protected List<DealAmount> dealAmountList;
	
	/** ��Ҫ����������� */
	protected String rapporgname;
	
	/** �Ӵ�����ɾ������ */
	protected String[] deleteRid;
	
	/** �Ӵ�����ɾ������ */
	protected String[] deleteRgid;
	
	/** �Ӵ�������Ϣ */
	protected Recption recptionData;
	
	/** �Ӵ����˲�ѯ���� */
	protected RecptionGuestInfoCond recptionguestinfoCond;
	
	/** �Ӵ������ͷ���ͳ����������� */
	protected List<RecptionCost> recptionCostList;
	
	/** �Ӵ����˺ͽӴ�������������� */
	protected List<GuestRecption> guestRecptionList;
	
	
	protected DealOrgVWSearchCond dealOrgVWSearchCond;
	protected List<DealOrg> dealOrgVWList;
	protected DealSearchCond dealSearchCond;
	protected List<Deal> dealList;
	//����Ͳ�ʵ��
	protected Deal deal;
	/** �Ӵ�ͳ����������� */
	protected List<DealVWInfo> dealVWList;
	/** �Ӵ�ͳ�Ʋ�ѯ���� */
	protected DealVWSearchCond dealVWSearchCond;
	/** ����Ͳ���ϢForm */
	protected IGLOM0115Form iglom0115Form;
	protected IGLOM0107Form iglom0107Form;
	
	
	/** �Ӵ����˲�ѯ��ϢForm */
	protected IGLOM0109Form iglom0109Form;

	/** �Ӵ����˲�ѯ��������� */
	protected List<RecptionGuestInfo> recptionguestInfo;
	
	/** ��Ʊ���� */
	protected RecptionGuestInfo recptionguest;
	
	/**
	 * �Ӵ����˺ͽӴ��������������ȡ��
	 * @return �Ӵ����˺ͽӴ��������������
	 */
	public List<GuestRecption> getGuestRecptionList() {
		return guestRecptionList;
	}
	
	/**
	 * �Ӵ����˺ͽӴ���������������趨
	 * @param guestRecptionList �Ӵ����˺ͽӴ��������������
	 */
	public void setGuestRecptionList(List<GuestRecption> guestRecptionList) {
		this.guestRecptionList = guestRecptionList;
	}
	
	/**
	 * �Ӵ������ͷ���ͳ�����������ȡ��
	 * @return �Ӵ������ͷ���ͳ�����������
	 */
	public List<RecptionCost> getRecptionCostList() {
		return recptionCostList;
	}
	/**
	 * �Ӵ������ͷ���ͳ������������趨
	 * @param recptionCostList �Ӵ������ͷ���ͳ�����������
	 */
	public void setRecptionCostList(List<RecptionCost> recptionCostList) {
		this.recptionCostList = recptionCostList;
	}

	/**
	 * �Ӵ������ѯ����ȡ��
	 * @return �Ӵ������ѯ����
	 */
	public RecptionSearchCond getRecptionSearchCond() {
		return recptionSearchCond;
	}

	
	/**
	 * �Ӵ������ѯ�����趨
	 * @param recptionSearchCond �Ӵ������ѯ�����趨
	 */
	public void setRecptionSearchCond(RecptionSearchCond recptionSearchCond) {
		this.recptionSearchCond = recptionSearchCond;
	}

	/**
	 * ��ҳ��DTOȡ��
	 * @return ��ҳ��DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ��ҳ��DTO�趨
	 * @param pagingDto ��ҳ��DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * �Ӵ���Ϣ����������ȡ��
	 * @return �Ӵ���Ϣ����������ȡ��
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * �Ӵ���Ϣ�����������趨
	 * @param maxSearchCount �Ӵ���Ϣ����������
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * �Ӵ���ϢFormȡ��
	 * @return �Ӵ���ϢForm
	 */
	public IGLOM0101Form getIglom0101Form() {
		return iglom0101Form;
	}

	/**
	 * �Ӵ���ϢForm�趨
	 * @param igLOM0101Form �Ӵ���ϢForm
	 */
	public void setIglom0101Form(IGLOM0101Form iglom0101Form) {
		this.iglom0101Form = iglom0101Form;
	}

	/**
	 * �Ӵ�����ȡ��
	 * @return �Ӵ�����
	 */
	public Recption getRecption() {
		return recption;
	}

	/**
	 * �Ӵ������趨
	 * @param recption �Ӵ�����
	 */
	public void setRecption(Recption recption) {
		this.recption = recption;
	}

	/**
	 * �Ӵ��������������ȡ��
	 * @return �Ӵ��������������
	 */
	public List<Recption> getRecptionList() {
		return recptionList;
	}

	/**
	 * �Ӵ���������������趨
	 * @param recptionList �Ӵ��������������
	 */
	public void setRecptionList(List<Recption> recptionList) {
		this.recptionList = recptionList;
	}

	/**
	 * �Ӵ���������Formȡ��
	 * @return �Ӵ���������Form
	 */
	public IGLOM0103Form getIglom0103Form() {
		return iglom0103Form;
	}

	/**
	 * �Ӵ���������Form�趨
	 * @param iglom0103Form �Ӵ���������Form
	 */
	public void setIglom0103Form(IGLOM0103Form iglom0103Form) {
		this.iglom0103Form = iglom0103Form;
	}

	/**
	 * ��Ҫ�����������ȡ��
	 * @return ��Ҫ�����������
	 */
	public String getRapporgname() {
		return rapporgname;
	}

	/**
	 * ��Ҫ������������趨
	 * @param rapporgname ��Ҫ�����������
	 */
	public void setRapporgname(String rapporgname) {
		this.rapporgname = rapporgname;
	}

	/**
	 * �Ӵ�����ɾ������ȡ��
	 * @return �Ӵ�����ɾ������
	 */
	public String[] getDeleteRid() {
		return deleteRid;
	}

	/**
	 * �Ӵ�����ɾ�������趨
	 * @param deleteRid �Ӵ�����ɾ������
	 */
	public void setDeleteRid(String[] deleteRid) {
		this.deleteRid = deleteRid;
	}


	/**
	 * �Ӵ����˵Ǽ�Formȡ��
	 * @return �Ӵ����˵Ǽ�Form
	 */
	public IGLOM0102Form getIglom0102Form() {
		return iglom0102Form;
	}

	/**
	 * �Ӵ����˵Ǽ�Form�趨
	 * @param iglom0102Form �Ӵ����˵Ǽ�Form
	 */
	public void setIglom0102Form(IGLOM0102Form iglom0102Form) {
		this.iglom0102Form = iglom0102Form;
	}

	/**
	 * �Ӵ�����ȡ��
	 * @return �Ӵ�����
	 */
	public RecptionGuest getRecptionGuest() {
		return recptionGuest;
	}

	/**
	 * �Ӵ������趨
	 * @param recptionGuest �Ӵ�����
	 */
	public void setRecptionGuest(RecptionGuest recptionGuest) {
		this.recptionGuest = recptionGuest;
	}

	/**
	 * �Ӵ��������������ȡ��
	 * @return �Ӵ��������������
	 */
	public List<RecptionGuest> getRecptionGuestList() {
		return recptionGuestList;
	}

	/**
	 * �Ӵ���������������趨
	 * @param recptionGuestList �Ӵ��������������
	 */
	public void setRecptionGuestList(List<RecptionGuest> recptionGuestList) {
		this.recptionGuestList = recptionGuestList;
	}

	/**
	 * �Ӵ�����ɾ������ȡ��
	 * @return �Ӵ�����ɾ������
	 */
	public String[] getDeleteRgid() {
		return deleteRgid;
	}

	/**
	 * �Ӵ�����ɾ�������趨
	 * @param deleteRgid �Ӵ�����ɾ������
	 */
	public void setDeleteRgid(String[] deleteRgid) {
		this.deleteRgid = deleteRgid;
	}

	/**
	 * �Ӵ����˹����ѯ����ȡ��
	 * @return �Ӵ����˹����ѯ����
	 */
	public RecptionGuestSearchCond getRecptionGuestSearchCond() {
		return recptionGuestSearchCond;
	}

	/**
	 * �Ӵ����˹����ѯ�����趨
	 * @param recptionGuestSearchCond �Ӵ����˹����ѯ����
	 */
	public void setRecptionGuestSearchCond(
			RecptionGuestSearchCond recptionGuestSearchCond) {
		this.recptionGuestSearchCond = recptionGuestSearchCond;
	}

	/**
	 * �Ӵ����˹���Formȡ��
	 * @return �Ӵ����˹���Form
	 */
	public IGLOM0104Form getIglom0104Form() {
		return iglom0104Form;
	}

	/**
	 * �Ӵ����˹���Form�趨
	 * @param iglom0104Form �Ӵ����˹���Form
	 */
	public void setIglom0104Form(IGLOM0104Form iglom0104Form) {
		this.iglom0104Form = iglom0104Form;
	}

	/**
	 * �Ӵ�������Ϣȡ��
	 * @return �Ӵ�������Ϣ
	 */
	public Recption getRecptionData() {
		return recptionData;
	}

	/** 
	 * �Ӵ�������Ϣ�趨
	 * @param recptionData �Ӵ�������Ϣ
	 */
	public void setRecptionData(Recption recptionData) {
		this.recptionData = recptionData;
	}

	/**
	 * �Ӵ�ͳ�����������ȡ��
	 * @return �Ӵ�ͳ�����������
	 */
	public List<RecptionVWInfo> getRecptionVWList() {
		return recptionVWList;
	}

	/**
	 * �Ӵ�ͳ������������趨
	 * @param recptionVWList �Ӵ�ͳ�����������
	 */
	public void setRecptionVWList(List<RecptionVWInfo> recptionVWList) {
		this.recptionVWList = recptionVWList;
	}

	/**
	 * �Ӵ�ͳ�Ʋ�ѯ����ȡ��
	 * @return �Ӵ�ͳ�Ʋ�ѯ����
	 */
	public RecptionVWSearchCond getRecptionVWSearchCond() {
		return recptionVWSearchCond;
	}

	/**
	 * �Ӵ�ͳ�Ʋ�ѯ�����趨
	 * @param recptionVWSearchCond �Ӵ�ͳ�Ʋ�ѯ����
	 */
	public void setRecptionVWSearchCond(RecptionVWSearchCond recptionVWSearchCond) {
		this.recptionVWSearchCond = recptionVWSearchCond;
	}

	/**
	 * ���ŽӴ�ͳ�Ʋ�ѯ����ȡ��
	 * @return ���ŽӴ�ͳ�Ʋ�ѯ����
	 */
	public RecptionOrgVWSearchCond getRecptionOrgVWSearchCond() {
		return recptionOrgVWSearchCond;
	}

	/**
	 * ���ŽӴ�ͳ�Ʋ�ѯ�����趨
	 * @param recptionOrgVWSearchCond ���ŽӴ�ͳ�Ʋ�ѯ����
	 */
	public void setRecptionOrgVWSearchCond(
			RecptionOrgVWSearchCond recptionOrgVWSearchCond) {
		this.recptionOrgVWSearchCond = recptionOrgVWSearchCond;
	}


	/**
	 * ���ŽӴ�ͳ�����������ȡ��
	 * @return ���ŽӴ�ͳ�����������
	 */
	public List<RecptionOrg> getRecptionOrgVWList() {
		return recptionOrgVWList;
	}

	/**
	 * ���ŽӴ�ͳ������������趨
	 * @param recptionOrgVWList ���ŽӴ�ͳ�����������
	 */
	public void setRecptionOrgVWList(List<RecptionOrg> recptionOrgVWList) {
		this.recptionOrgVWList = recptionOrgVWList;
	}
	
	/**
	 * �Ӵ������ѯ����ȡ��
	 * @return
	 */
	public RecptionGuestInfoCond getRecptionGuestInfoCond() {
		return recptionguestinfoCond;
	}

	/**
	 * �Ӵ������ѯ�����趨
	 * @param recptionSearchCond �Ӵ������ѯ�����趨
	 */
	public void setRecptionGuestInfoCond(RecptionGuestInfoCond recptionguestinfoCond) {
		this.recptionguestinfoCond = recptionguestinfoCond;
	}

	public List<RecptionAmount> getRecptionAmountList() {
		return recptionAmountList;
	}

	public void setRecptionAmountList(List<RecptionAmount> recptionAmountList) {
		this.recptionAmountList = recptionAmountList;
	}

	public DealOrgVWSearchCond getDealOrgVWSearchCond() {
		return dealOrgVWSearchCond;
	}

	public void setDealOrgVWSearchCond(DealOrgVWSearchCond dealOrgVWSearchCond) {
		this.dealOrgVWSearchCond = dealOrgVWSearchCond;
	}

	public List<DealOrg> getDealOrgVWList() {
		return dealOrgVWList;
	}

	public void setDealOrgVWList(List<DealOrg> dealOrgVWList) {
		this.dealOrgVWList = dealOrgVWList;
	}

	public DealSearchCond getDealSearchCond() {
		return dealSearchCond;
	}

	public void setDealSearchCond(DealSearchCond dealSearchCond) {
		this.dealSearchCond = dealSearchCond;
	}

	public List<Deal> getDealList() {
		return dealList;
	}

	public void setDealList(List<Deal> dealList) {
		this.dealList = dealList;
	}

	public Deal getDeal() {
		return deal;
	}

	public void setDeal(Deal deal) {
		this.deal = deal;
	}

	public List<DealVWInfo> getDealVWList() {
		return dealVWList;
	}

	public void setDealVWList(List<DealVWInfo> dealVWList) {
		this.dealVWList = dealVWList;
	}

	public DealVWSearchCond getDealVWSearchCond() {
		return dealVWSearchCond;
	}

	public void setDealVWSearchCond(DealVWSearchCond dealVWSearchCond) {
		this.dealVWSearchCond = dealVWSearchCond;
	}

	public IGLOM0115Form getIglom0115Form() {
		return iglom0115Form;
	}

	public void setIglom0115Form(IGLOM0115Form iglom0115Form) {
		this.iglom0115Form = iglom0115Form;
	}

	public IGLOM0107Form getIglom0107Form() {
		return iglom0107Form;
	}

	public void setIglom0107Form(IGLOM0107Form iglom0107Form) {
		this.iglom0107Form = iglom0107Form;
	}

	public List<DealAmount> getDealAmountList() {
		return dealAmountList;
	}

	public void setDealAmountList(List<DealAmount> dealAmountList) {
		this.dealAmountList = dealAmountList;
	}
	
	

	/**
	 * �Ӵ����˲�ѯFormȡ��
	 * @return �Ӵ����˲�ѯForm
	 */
	public IGLOM0109Form getIglom0109Form() {
		return iglom0109Form;
	}

	/**
	 * �Ӵ����˲�ѯForm�趨
	 * @param iglom0109Form �Ӵ����˲�ѯForm
	 */
	public void setIglom0109Form(IGLOM0109Form iglom0109Form) {
		this.iglom0109Form = iglom0109Form;
	}
	
	/**
	 * �Ӵ����˲�ѯ���������
	 * @return ��Ʊ��Ϣ���������
	 */
	public List<RecptionGuestInfo> getRecptionGuestInfoList() {
		return recptionguestInfo;
	}

	/**
	 * �Ӵ����˲�ѯ���������
	 * @param recptionList �Ӵ����˲�ѯ���������
	 */
	public void setRecptionGuestInfoList(List<RecptionGuestInfo> recptionguestInfo) {
		this.recptionguestInfo = recptionguestInfo;
	}
	
	/**
	 * �Ӵ����˲�ѯ
	 * @return ��Ʊ����
	 */
	public RecptionGuestInfo getRecptionGuestInfo() {
		return recptionguest;
	}

	/**
	 * �Ӵ����˲�ѯ
	 * @param recption �Ӵ����˲�ѯ
	 */
	public void setRecptionGuestInfo(RecptionGuestInfo recptionguest) {
		this.recptionguest = recptionguest;
	}
}
