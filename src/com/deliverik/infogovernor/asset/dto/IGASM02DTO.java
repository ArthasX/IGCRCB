package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.model.IG800Info;
import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG887Info;
import com.deliverik.framework.asset.model.EiBelongRelationInfo;
import com.deliverik.framework.asset.model.IG313Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.form.IGASM0202Form;
import com.deliverik.infogovernor.asset.form.IGASM0204Form;
import com.deliverik.infogovernor.asset.form.IGASM0205Form;
import com.deliverik.infogovernor.asset.form.IGASM0206Form;
import com.deliverik.infogovernor.asset.form.IGASM0207Form;

/**
 * �ʲ����ù���ҵ����DTO
 * 
 */
@SuppressWarnings("serial")
public class IGASM02DTO extends BaseDTO implements Serializable{

	/** �ʲ�����Ϣ */
	protected IGASM0202Form igasm0202Form;
	
	/** �ʲ�����Ϣ�������� */
	protected IG688SearchCond entityItemVWSearchCond;
	
	/** ���������� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;

	/** �ʲ��������� */
	protected List<IG688Info> entityItemVWInfoList;

	/** �ʲ���ɾ������ */
	protected String[] deleteEntityItem;

	/** �ʲ���������Ϣ */
	protected IGASM0204Form igasm0204Form;
	
	/** �ʲ���������Ϣ������� */
	protected List<IG002Info> configItemVWInfoList;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<IG002Info>> configItemVWInfoMap;
	
	/** �ʲ������ϵ�����б� */
	protected List<LabelValueBean> relationList;

	/** �ʲ���������Ϣ�����ʲ�����Ϣ */
	protected IG688Info entityItemVWInfo;

	/** �ʲ���������Ϣ��ʷ��¼�������� */
	protected IGASM0205Form igasm0205Form;
	
	/** �ʲ���������Ϣ��ʷ��¼������� */
	protected List<IG800Info> configItemList;
	
	/** �ʲ����ϵ����������� */
	protected IGASM0206Form igasm0206Form;
	
	/** �ʲ����ϵ������Ϣ�������1 */
	protected List<IG313Info> parEntityItemRelationList;
	
	/** �ʲ����ϵ������Ϣ�������2 */
	protected List<IG313Info> cldEntityItemRelationList;
	
	/** �ʲ����ϵ�༭��Ϣ */
	protected IGASM0207Form igasm0207Form;
	
	/** �ʲ����ϵ�༭����Ϣ */
	protected IG313Info entityItemRelation;

	/** �ʲ����ϵɾ������ */
	protected String[] deleteEntityItemRelation;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<IG800Info>> configItemMap;
	
	/** �û����� */
	private User user;
	
	/** Ȩ�ޱ�ʶ */
	protected Boolean flag;
	
	/** �ʲ��汾�б� */
	protected List<IG887Info> configItemVersionTime;
	/** ������ϵ */
	protected List<EiBelongRelationInfo> belongRelationList;
	
	public List<EiBelongRelationInfo> getBelongRelationList() {
		return belongRelationList;
	}

	public void setBelongRelationList(List<EiBelongRelationInfo> belongRelationList) {
		this.belongRelationList = belongRelationList;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	/**
	 * �ʲ�����Ϣȡ��
	 * @return �ʲ�����Ϣ
	 */
	public IGASM0202Form getIgasm0202Form() {
		return igasm0202Form;
	}

	
	protected Map<String,List<IG313Info>> parEntityItemRelationMap;
	protected Map<String,List<IG313Info>> cldEntityItemRelationMap;
	protected int parCount;
	protected int cldCount;
	
	
	public Map<String, List<IG313Info>> getParEntityItemRelationMap() {
		return parEntityItemRelationMap;
	}

	public void setParEntityItemRelationMap(
			Map<String, List<IG313Info>> parEntityItemRelationMap) {
		this.parEntityItemRelationMap = parEntityItemRelationMap;
	}

	public Map<String, List<IG313Info>> getCldEntityItemRelationMap() {
		return cldEntityItemRelationMap;
	}

	public void setCldEntityItemRelationMap(
			Map<String, List<IG313Info>> cldEntityItemRelationMap) {
		this.cldEntityItemRelationMap = cldEntityItemRelationMap;
	}

	public int getParCount() {
		return parCount;
	}

	public void setParCount(int parCount) {
		this.parCount = parCount;
	}

	public int getCldCount() {
		return cldCount;
	}

	public void setCldCount(int cldCount) {
		this.cldCount = cldCount;
	}

	/**
	 * �ʲ�����Ϣ�趨
	 *
	 * @param igasm0202Form �ʲ�����Ϣ
	 */
	public void setIgasm0202Form(IGASM0202Form igasm0202Form) {
		this.igasm0202Form = igasm0202Form;
	}

	/**
	 * �ʲ�����Ϣ��������ȡ��
	 * @return �ʲ�����Ϣ��������
	 */
	public IG688SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * �ʲ�����Ϣ���������趨
	 *
	 * @param entityItemVWSearchCond �ʲ�����Ϣ��������
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
	 * �ʲ���������ȡ��
	 * @return �ʲ���������
	 */
	public List<IG688Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * �ʲ����������趨
	 *
	 * @param entityItemVWInfoList �ʲ���������
	 */
	public void setEntityItemVWInfoList(List<IG688Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/**
	 * �ʲ���ɾ������ȡ��
	 * @return �ʲ���ɾ������
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * �ʲ���ɾ�������趨
	 *
	 * @param deleteEntityItem �ʲ���ɾ������
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * �ʲ���������Ϣȡ��
	 * @return �ʲ���������Ϣ
	 */
	public IGASM0204Form getIgasm0204Form() {
		return igasm0204Form;
	}


	/**
	 * �ʲ���������Ϣ���������趨
	 *
	 * @param igasm0204Form �ʲ���������Ϣ��������
	 */
	public void setIgasm0204Form(IGASM0204Form igasm0204Form) {
		this.igasm0204Form = igasm0204Form;
	}

	/**
	 * �ʲ���������Ϣ�������ȡ��
	 * @return �ʲ���������Ϣ�������
	 */
	public List<IG002Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	/**
	 * �ʲ���������Ϣ��������趨
	 *
	 * @param configItemVWInfoList �ʲ���������Ϣ�������
	 */
	public void setConfigItemVWInfoList(List<IG002Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

	/**
	 * �ʲ���������Ϣ�����ʲ�����Ϣȡ��
	 * @return �ʲ���������Ϣ�����ʲ�����Ϣ
	 */
	public IG688Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * �ʲ���������Ϣ�����ʲ�����Ϣ�趨
	 *
	 * @param entityItemVWInfo �ʲ���������Ϣ�����ʲ�����Ϣ
	 */
	public void setEntityItemVWInfo(IG688Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * �ʲ���������Ϣ��ʷ��¼��������ȡ��
	 * @return �ʲ���������Ϣ��ʷ��¼��������
	 */
	public IGASM0205Form getIgasm0205Form() {
		return igasm0205Form;
	}

	/**
	 * �ʲ���������Ϣ��ʷ��¼���������趨
	 *
	 * @param igasm0205Form �ʲ���������Ϣ��ʷ��¼��������
	 */
	public void setIgasm0205Form(IGASM0205Form igasm0205Form) {
		this.igasm0205Form = igasm0205Form;
	}

	/**
	 * �ʲ���������Ϣ��ʷ��¼�������ȡ��
	 * @return �ʲ���������Ϣ��ʷ��¼�������
	 */
	public List<IG800Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * �ʲ���������Ϣ��ʷ��¼��������趨
	 *
	 * @param configItemList �ʲ���������Ϣ��ʷ��¼�������
	 */
	public void setConfigItemList(List<IG800Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * �ʲ����ϵ�����������ȡ��
	 * @return �ʲ����ϵ�����������
	 */
	public IGASM0206Form getIgasm0206Form() {
		return igasm0206Form;
	}

	/**
	 * �ʲ����ϵ������������趨
	 *
	 * @param igasm0206Form �ʲ����ϵ�����������
	 */
	public void setIgasm0206Form(IGASM0206Form igasm0206Form) {
		this.igasm0206Form = igasm0206Form;
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
	 * �ʲ����ϵ�༭��Ϣȡ��
	 * @return �༭��Ϣ
	 */
	public IGASM0207Form getIgasm0207Form() {
		return igasm0207Form;
	}

	/**
	 * �ʲ����ϵ�༭��Ϣ�趨
	 *
	 * @param igasm0207Form �ʲ����ϵ�༭��Ϣ
	 */
	public void setIgasm0207Form(IGASM0207Form igasm0207Form) {
		this.igasm0207Form = igasm0207Form;
	}

	/**
	 * �ʲ����ϵ�༭����Ϣȡ��
	 * @return �ʲ����ϵ�༭����Ϣ
	 */
	public IG313Info getEntityItemRelation() {
		return entityItemRelation;
	}

	/**
	 * �ʲ����ϵ�༭����Ϣ�趨
	 *
	 * @param entityItemRelation �ʲ����ϵ�༭����Ϣ
	 */
	public void setEntityItemRelation(IG313Info entityItemRelation) {
		this.entityItemRelation = entityItemRelation;
	}

	/**
	 * �ʲ����ϵɾ������ȡ��
	 * @return �ʲ����ϵɾ������
	 */
	public String[] getDeleteEntityItemRelation() {
		return deleteEntityItemRelation;
	}

	/**
	 * �ʲ����ϵɾ�������趨
	 *
	 * @param entityItemRelation �ʲ����ϵɾ������
	 */
	public void setDeleteEntityItemRelation(String[] deleteEntityItemRelation) {
		this.deleteEntityItemRelation = deleteEntityItemRelation;
	}

	/**
	 * �ʲ���������Ϣ�������ȡ��
	 * @return �ʲ���������Ϣ�������
	 */
	public Map<String, List<IG002Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}
	/**
	 * �ʲ���������Ϣ��������趨
	 *
	 * @param configItemVWInfoMap �ʲ���������Ϣ�������
	 */
	public void setConfigItemVWInfoMap(
			Map<String, List<IG002Info>> configItemVWInfoMap) {
		this.configItemVWInfoMap = configItemVWInfoMap;
	}
	
	/**
	 * �ʲ������ϵ�����б�ȡ��
	 * @return �ʲ������ϵ�����б�
	 */
	public List<LabelValueBean> getRelationList() {
		return relationList;
	}
	
	/**
	 * �ʲ������ϵ�����б��趨
	 *
	 * @param username �ʲ������ϵ�����б�
	 */
	public void setRelationList(List<LabelValueBean> relationList) {
		this.relationList = relationList;
	}
	
	/**
	 * �ʲ���������Ϣ�������ȡ��
	 * @return �ʲ���������Ϣ�������
	 */
	public Map<String, List<IG800Info>> getConfigItemMap() {
		return configItemMap;
	}
	/**
	 * �ʲ���������Ϣ��������趨
	 *
	 * @param configItemMap �ʲ���������Ϣ�������
	 */
	public void setConfigItemMap(
			Map<String, List<IG800Info>> configItemMap) {
		this.configItemMap = configItemMap;
	}
	

	/**
	 * �ʲ��汾�б�ȡ��
	 * @return �ʲ��汾�б�
	 */
	public List<IG887Info> getConfigItemVersionTime() {
		return configItemVersionTime;
	}

	/**
	 * �ʲ��汾�б��趨
	 *
	 * @param configItemVersionTime �ʲ��汾�б�
	 */
	public void setConfigItemVersionTime(
			List<IG887Info> configItemVersionTime) {
		this.configItemVersionTime = configItemVersionTime;
	}

}


