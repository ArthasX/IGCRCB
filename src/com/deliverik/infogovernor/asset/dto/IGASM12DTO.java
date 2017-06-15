package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG800Info;
import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG313Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.asset.form.IGASM1202Form;
import com.deliverik.infogovernor.asset.form.IGASM1204Form;
import com.deliverik.infogovernor.asset.form.IGASM1205Form;
import com.deliverik.infogovernor.asset.form.IGASM1206Form;
import com.deliverik.infogovernor.asset.form.IGASM1207Form;

/**
 * �������ù���ҵ����DTO
 * 
 */
@SuppressWarnings("serial")
public class IGASM12DTO extends BaseDTO implements Serializable{

	/** ������Ϣ */
	protected IGASM1202Form igasm1202Form;
	
	/** ������Ϣ�������� */
	protected IG688SearchCond entityItemVWSearchCond;
	
	/** ���������� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;

	/** ���������� */
	protected List<IG688Info> entityItemVWInfoList;

	/** ����ɾ������ */
	protected String[] deleteEntityItem;

	/** ����������Ϣ */
	protected IGASM1204Form igasm1204Form;
	
	/** ����������Ϣ������� */
	protected List<IG002Info> configItemVWInfoList;

	/** ����������Ϣ���������Ϣ */
	protected IG688Info entityItemVWInfo;

	/** ����������Ϣ��ʷ��¼�������� */
	protected IGASM1205Form igasm1205Form;
	
	/** ����������Ϣ��ʷ��¼������� */
	protected List<IG800Info> configItemList;
	
	/** �����ϵ����������� */
	protected IGASM1206Form igasm1206Form;
	
	/** �ʲ����ϵ������Ϣ�������1 */
	protected List<IG313Info> parEntityItemRelationList;
	
	/** �ʲ����ϵ������Ϣ�������2 */
	protected List<IG313Info> cldEntityItemRelationList;
	
	/** �����ϵ�༭��Ϣ */
	protected IGASM1207Form igasm1207Form;
	
	/** �����ϵ�༭����Ϣ */
	protected IG313Info entityItemRelation;

	/** �����ϵɾ������ */
	protected String[] deleteEntityItemRelation;

	/**
	 * ������Ϣȡ��
	 * @return ������Ϣ
	 */
	public IGASM1202Form getIgasm1202Form() {
		return igasm1202Form;
	}

	/**
	 * ������Ϣ�趨
	 *
	 * @param igasm1202Form ������Ϣ
	 */
	public void setIgasm1202Form(IGASM1202Form igasm1202Form) {
		this.igasm1202Form = igasm1202Form;
	}

	/**
	 * ������Ϣ��������ȡ��
	 * @return ������Ϣ��������
	 */
	public IG688SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * ������Ϣ���������趨
	 *
	 * @param entityItemVWSearchCond ������Ϣ��������
	 */
	public void setEntityItemVWSearchCond(
			IG688SearchCond entityItemVWSearchCond) {
		this.entityItemVWSearchCond = entityItemVWSearchCond;
	}

	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * �����������趨
	 *
	 * @param maxSearchCount ����������
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
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
	 *
	 * @param pagingDto ��ҳ��DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public List<IG688Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * �����������趨
	 *
	 * @param entityItemVWInfoList ����������
	 */
	public void setEntityItemVWInfoList(List<IG688Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/**
	 * ����ɾ������ȡ��
	 * @return ����ɾ������
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * ����ɾ�������趨
	 *
	 * @param deleteEntityItem ����ɾ������
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * ����������Ϣȡ��
	 * @return ����������Ϣ
	 */
	public IGASM1204Form getIgasm1204Form() {
		return igasm1204Form;
	}


	/**
	 * ����������Ϣ���������趨
	 *
	 * @param igasm1204Form ����������Ϣ��������
	 */
	public void setIgasm1204Form(IGASM1204Form igasm1204Form) {
		this.igasm1204Form = igasm1204Form;
	}

	/**
	 * ����������Ϣ�������ȡ��
	 * @return ����������Ϣ�������
	 */
	public List<IG002Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	/**
	 * ����������Ϣ��������趨
	 *
	 * @param configItemVWInfoList ����������Ϣ�������
	 */
	public void setConfigItemVWInfoList(List<IG002Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

	/**
	 * ����������Ϣ���������Ϣȡ��
	 * @return ����������Ϣ���������Ϣ
	 */
	public IG688Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * ����������Ϣ���������Ϣ�趨
	 *
	 * @param entityItemVWInfo ����������Ϣ���������Ϣ
	 */
	public void setEntityItemVWInfo(IG688Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * ����������Ϣ��ʷ��¼��������ȡ��
	 * @return ����������Ϣ��ʷ��¼��������
	 */
	public IGASM1205Form getIgasm1205Form() {
		return igasm1205Form;
	}

	/**
	 * ����������Ϣ��ʷ��¼���������趨
	 *
	 * @param igasm1205Form ����������Ϣ��ʷ��¼��������
	 */
	public void setIgasm1205Form(IGASM1205Form igasm1205Form) {
		this.igasm1205Form = igasm1205Form;
	}

	/**
	 * ����������Ϣ��ʷ��¼�������ȡ��
	 * @return ����������Ϣ��ʷ��¼�������
	 */
	public List<IG800Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * ����������Ϣ��ʷ��¼��������趨
	 *
	 * @param configItemList ����������Ϣ��ʷ��¼�������
	 */
	public void setConfigItemList(List<IG800Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * �����ϵ�����������ȡ��
	 * @return �����ϵ�����������
	 */
	public IGASM1206Form getIgasm1206Form() {
		return igasm1206Form;
	}

	/**
	 * �����ϵ������������趨
	 *
	 * @param igasm1206Form �����ϵ�����������
	 */
	public void setIgasm1206Form(IGASM1206Form igasm1206Form) {
		this.igasm1206Form = igasm1206Form;
	}

	/**
	 * �ʲ����ϵ������Ϣ�������1ȡ��
	 * @return �ʲ����ϵ������Ϣ�������1
	 */
	public List<IG313Info> getParEntityItemRelationList() {
		return parEntityItemRelationList;
	}

	/**
	 * �ʲ����ϵ������Ϣ�������1�趨
	 *
	 * @param parEntityItemRelationList �ʲ����ϵ������Ϣ�������1
	 */
	public void setParEntityItemRelationList(
			List<IG313Info> parEntityItemRelationList) {
		this.parEntityItemRelationList = parEntityItemRelationList;
	}

	/**
	 * �ʲ����ϵ������Ϣ�������2ȡ��
	 * @return �ʲ����ϵ������Ϣ�������2
	 */
	public List<IG313Info> getCldEntityItemRelationList() {
		return cldEntityItemRelationList;
	}

	/**
	 * �ʲ����ϵ������Ϣ�������2�趨
	 *
	 * @param cldEntityItemRelationList �ʲ����ϵ������Ϣ�������2
	 */
	public void setCldEntityItemRelationList(
			List<IG313Info> cldEntityItemRelationList) {
		this.cldEntityItemRelationList = cldEntityItemRelationList;
	}

	/**
	 * �����ϵ�༭��Ϣȡ��
	 * @return �༭��Ϣ
	 */
	public IGASM1207Form getIgasm1207Form() {
		return igasm1207Form;
	}

	/**
	 * �����ϵ�༭��Ϣ�趨
	 *
	 * @param igasm1207Form �����ϵ�༭��Ϣ
	 */
	public void setIgasm1207Form(IGASM1207Form igasm1207Form) {
		this.igasm1207Form = igasm1207Form;
	}

	/**
	 * �����ϵ�༭����Ϣȡ��
	 * @return �����ϵ�༭����Ϣ
	 */
	public IG313Info getEntityItemRelation() {
		return entityItemRelation;
	}

	/**
	 * �����ϵ�༭����Ϣ�趨
	 *
	 * @param entityItemRelation �����ϵ�༭����Ϣ
	 */
	public void setEntityItemRelation(IG313Info entityItemRelation) {
		this.entityItemRelation = entityItemRelation;
	}

	/**
	 * �����ϵɾ������ȡ��
	 * @return �����ϵɾ������
	 */
	public String[] getDeleteEntityItemRelation() {
		return deleteEntityItemRelation;
	}

	/**
	 * �����ϵɾ�������趨
	 *
	 * @param entityItemRelation �����ϵɾ������
	 */
	public void setDeleteEntityItemRelation(String[] deleteEntityItemRelation) {
		this.deleteEntityItemRelation = deleteEntityItemRelation;
	}

}


