package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.model.IG800Info;
import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG887Info;
import com.deliverik.framework.asset.model.IG313Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.form.IGASM1702Form;
import com.deliverik.infogovernor.asset.form.IGASM1704Form;
import com.deliverik.infogovernor.asset.form.IGASM1705Form;
import com.deliverik.infogovernor.asset.form.IGASM1706Form;
import com.deliverik.infogovernor.asset.form.IGASM1707Form;
import com.deliverik.infogovernor.asset.form.IGASM1712Form;

/**
 * ������ù���ҵ����DTO
 * 
 */
@SuppressWarnings("serial")
public class IGASM17DTO extends BaseDTO implements Serializable{

	/** �����Ϣ */
	protected IGASM1702Form igasm1702Form;
	
	/** �����Ϣ�������� */
	protected IG688SearchCond entityItemVWSearchCond;
	
	/** ���������� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;

	/** ���������� */
	protected List<IG688Info> entityItemVWInfoList;

	/** ���ɾ������ */
	protected String[] deleteEntityItem;

	/** ���������Ϣ */
	protected IGASM1704Form igasm1704Form;
	
	/** ���������Ϣ������� */
	protected List<IG002Info> configItemVWInfoList;

	/** ���������Ϣ���������Ϣ */
	protected IG688Info entityItemVWInfo;

	/** ���������Ϣ��ʷ��¼�������� */
	protected IGASM1705Form igasm1705Form;
	
	/** ���������Ϣ��ʷ��¼������� */
	protected List<IG800Info> configItemList;
	
	/** �����ϵ����������� */
	protected IGASM1706Form igasm1706Form;
	
	/** �ʲ����ϵ������Ϣ�������1 */
	protected List<IG313Info> parEntityItemRelationList;
	
	/** �ʲ����ϵ������Ϣ�������2 */
	protected List<IG313Info> cldEntityItemRelationList;
	
	/** �����ϵ�༭��Ϣ */
	protected IGASM1707Form igasm1707Form;
	
	/** �����ϵ�༭����Ϣ */
	protected IG313Info entityItemRelation;
	
	/** �ʲ������ϵ�����б� */
	protected List<LabelValueBean> relationList;

	/** �����ϵɾ������ */
	protected String[] deleteEntityItemRelation;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<IG002Info>> configItemVWInfoMap;
	
	protected Map<String,List<IG313Info>> parEntityItemRelationMap;
	protected Map<String,List<IG313Info>> cldEntityItemRelationMap;
	protected int parCount;
	protected int cldCount;
	
	/** �ʲ��汾�б� */
	protected List<IG887Info> configItemVersionTime;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<IG800Info>> configItemMap;
	/** �����Ϣ�޸� */
	protected IGASM1712Form igasm1712Form;
	
	/** �û����� */
	private User user;
	
	/** Ȩ�ޱ�ʶ */
	protected Boolean flag;
	
	/** ��������� */
	protected String orgsyscoding;
	
	/** �������� */
	protected String orgname;
	
	/** ģ�Ͳ���� */
	protected String esyscoding;
	
	/** ģ������ */
	protected String ename;
	
	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
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
	
	
	public IGASM1712Form getIgasm1712Form() {
		return igasm1712Form;
	}

	public void setIgasm1712Form(IGASM1712Form igasm1712Form) {
		this.igasm1712Form = igasm1712Form;
	}
	
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
	 * �����Ϣȡ��
	 * @return �����Ϣ
	 */
	public IGASM1702Form getIgasm1702Form() {
		return igasm1702Form;
	}

	/**
	 * �����Ϣ�趨
	 *
	 * @param igasm1702Form �����Ϣ
	 */
	public void setIgasm1702Form(IGASM1702Form igasm1702Form) {
		this.igasm1702Form = igasm1702Form;
	}

	/**
	 * �����Ϣ��������ȡ��
	 * @return �����Ϣ��������
	 */
	public IG688SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * �����Ϣ���������趨
	 *
	 * @param entityItemVWSearchCond �����Ϣ��������
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
	 * ���ɾ������ȡ��
	 * @return ���ɾ������
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * ���ɾ�������趨
	 *
	 * @param deleteEntityItem ���ɾ������
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * ���������Ϣȡ��
	 * @return ���������Ϣ
	 */
	public IGASM1704Form getIgasm1704Form() {
		return igasm1704Form;
	}


	/**
	 * ���������Ϣ���������趨
	 *
	 * @param igasm1704Form ���������Ϣ��������
	 */
	public void setIgasm1704Form(IGASM1704Form igasm1704Form) {
		this.igasm1704Form = igasm1704Form;
	}

	/**
	 * ���������Ϣ�������ȡ��
	 * @return ���������Ϣ�������
	 */
	public List<IG002Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	/**
	 * ���������Ϣ��������趨
	 *
	 * @param configItemVWInfoList ���������Ϣ�������
	 */
	public void setConfigItemVWInfoList(List<IG002Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

	/**
	 * ���������Ϣ���������Ϣȡ��
	 * @return ���������Ϣ���������Ϣ
	 */
	public IG688Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * ���������Ϣ���������Ϣ�趨
	 *
	 * @param entityItemVWInfo ���������Ϣ���������Ϣ
	 */
	public void setEntityItemVWInfo(IG688Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * ���������Ϣ��ʷ��¼��������ȡ��
	 * @return ���������Ϣ��ʷ��¼��������
	 */
	public IGASM1705Form getIgasm1705Form() {
		return igasm1705Form;
	}

	/**
	 * ���������Ϣ��ʷ��¼���������趨
	 *
	 * @param igasm1705Form ���������Ϣ��ʷ��¼��������
	 */
	public void setIgasm1705Form(IGASM1705Form igasm1705Form) {
		this.igasm1705Form = igasm1705Form;
	}

	/**
	 * ���������Ϣ��ʷ��¼�������ȡ��
	 * @return ���������Ϣ��ʷ��¼�������
	 */
	public List<IG800Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * ���������Ϣ��ʷ��¼��������趨
	 *
	 * @param configItemList ���������Ϣ��ʷ��¼�������
	 */
	public void setConfigItemList(List<IG800Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * �����ϵ�����������ȡ��
	 * @return �����ϵ�����������
	 */
	public IGASM1706Form getIgasm1706Form() {
		return igasm1706Form;
	}

	/**
	 * �����ϵ������������趨
	 *
	 * @param igasm1706Form �����ϵ�����������
	 */
	public void setIgasm1706Form(IGASM1706Form igasm1706Form) {
		this.igasm1706Form = igasm1706Form;
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
	public IGASM1707Form getIgasm1707Form() {
		return igasm1707Form;
	}

	/**
	 * �����ϵ�༭��Ϣ�趨
	 *
	 * @param igasm1707Form �����ϵ�༭��Ϣ
	 */
	public void setIgasm1707Form(IGASM1707Form igasm1707Form) {
		this.igasm1707Form = igasm1707Form;
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


