package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.IG313Info;
import com.deliverik.framework.asset.model.IG800Info;
import com.deliverik.framework.asset.model.condition.IG800SearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.form.IGASM1502Form;
import com.deliverik.infogovernor.asset.form.IGASM1504Form;
import com.deliverik.infogovernor.asset.form.IGASM1505Form;
import com.deliverik.infogovernor.asset.form.IGASM1506Form;
import com.deliverik.infogovernor.asset.form.IGASM1507Form;
import com.deliverik.infogovernor.asset.form.IGASM1512Form;

/**
 * ��Ա���ù���ҵ����DTO
 * 
 */
@SuppressWarnings("serial")
public class IGASM15DTO extends BaseDTO implements Serializable{

	protected IG800SearchCond configItemSearchCond;
	public IG800SearchCond getConfigItemSearchCond() {
		return configItemSearchCond;
	}

	public void setConfigItemSearchCond(IG800SearchCond configItemSearchCond) {
		this.configItemSearchCond = configItemSearchCond;
	}

	/** ��Ա��Ϣ */
	protected IGASM1502Form igasm1502Form;
	
	/** ��Ա��Ϣ�������� */
	protected SOC0124SearchCond entityItemVWSearchCond;
	
	/** ���������� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;

	/** ��Ա������� */
	protected List<SOC0124Info> entityItemVWInfoList;

	/** ��Աɾ������ */
	protected String[] deleteEntityItem;

	/** ��Ա������Ϣ */
	protected IGASM1504Form igasm1504Form;
	
	/** ��Ա������Ϣ������� */
	protected List<IG002Info> configItemVWInfoList;

	/** ��Ա������Ϣ������Ա��Ϣ */
	protected SOC0124Info entityItemVWInfo;

	/** ��Ա������Ϣ��ʷ��¼�������� */
	protected IGASM1505Form igasm1505Form;
	
	/** ��Ա������Ϣ��ʷ��¼������� */
	protected List<IG800Info> configItemList;
	
	/** ��Ա��ϵ����������� */
	protected IGASM1506Form igasm1506Form;
	
	/** �ʲ����ϵ������Ϣ�������1 */
	protected List<IG313Info> parEntityItemRelationList;
	
	/** �ʲ����ϵ������Ϣ�������2 */
	protected List<IG313Info> cldEntityItemRelationList;
	
	/** ��Ա��ϵ�༭��Ϣ */
	protected IGASM1507Form igasm1507Form;
	
	/** ��Ա��ϵ�༭����Ϣ */
	protected SOC0119Info entityItemRelation;

	/** ��Ա��ϵɾ������ */
	protected String[] deleteEntityItemRelation;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String, List<SOC0129Info>> configItemVWInfoMap;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String, List<SOC0107Info>> configItemMap;
	
	/**������id*/
	protected String userid;
	
	/**����������*/
	protected String username;
	
	/** �ʲ������ϵ�����б� */
	protected List<LabelValueBean> relationList;
	
	protected String reciveUser;
	protected Map<String, List<SOC0119Info>> parEntityItemRelationMap;
	protected Map<String, List<SOC0119Info>> cldEntityItemRelationMap;
	protected int parCount;
	protected int cldCount;
	
	/** ��Ա������������ */
	protected String eiorgname;
	/** ��Ա��Ϣ�޸� */
	protected IGASM1512Form igasm1512Form;
	
	/** �û����� */
	private User user;
	
	/** Ȩ�ޱ�ʶ */
	protected Boolean flag;
	
	/**
	 * ��Ա��Ϣ��������ȡ��
	 * 
	 * @return entityItemVWSearchCond ��Ա��Ϣ��������
	 */
	public SOC0124SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * ��Ա��Ϣ���������趨
	 * 
	 * @param entityItemVWSearchCond
	 *            ��Ա��Ϣ��������
	 */
	public void setEntityItemVWSearchCond(SOC0124SearchCond entityItemVWSearchCond) {
		this.entityItemVWSearchCond = entityItemVWSearchCond;
	}

	/** ��������� */
	protected String orgsyscoding;
	
	/** ģ�Ͳ���� */
	protected String esyscoding;
	
	/** ģ������ */
	protected String ename;
	
	/** �ʲ��汾�б� */
	protected List<SOC0128Info> configItemVersionTime;
	
	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
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
	
	
	public IGASM1512Form getIgasm1512Form() {
		return igasm1512Form;
	}

	public void setIgasm1512Form(IGASM1512Form igasm1512Form) {
		this.igasm1512Form = igasm1512Form;
	}

	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}
	
	public Map<String, List<SOC0119Info>> getParEntityItemRelationMap() {
		return parEntityItemRelationMap;
	}

	public void setParEntityItemRelationMap(
Map<String, List<SOC0119Info>> parEntityItemRelationMap) {
		this.parEntityItemRelationMap = parEntityItemRelationMap;
	}

	public Map<String, List<SOC0119Info>> getCldEntityItemRelationMap() {
		return cldEntityItemRelationMap;
	}

	public void setCldEntityItemRelationMap(
Map<String, List<SOC0119Info>> cldEntityItemRelationMap) {
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
	public String getReciveUser() {
		return reciveUser;
	}

	public void setReciveUser(String reciveUser) {
		this.reciveUser = reciveUser;
	}
	
	/** ��Ա��������id */
	protected String orgid;
	
	/** ��Ա��������name */
	protected String orgname;
	
	/** ��Ա�·�ʱ�� */
	protected String issuetime;
	
	/** ��Ա������ */
	protected String recivename;
	
	/** ��Ա��ǰ�汾�� */
	protected String eiversion;
	
	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getIssuetime() {
		return issuetime;
	}

	public void setIssuetime(String issuetime) {
		this.issuetime = issuetime;
	}

	public String getRecivename() {
		return recivename;
	}

	public void setRecivename(String recivename) {
		this.recivename = recivename;
	}

	public String getEiversion() {
		return eiversion;
	}

	public void setEiversion(String eiversion) {
		this.eiversion = eiversion;
	}

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	
	/** ��Ա��Ϣ������Ա��Ϣ */
	protected IG013Info entityItem;
	
	public IG013Info getEntityItem() {
		return entityItem;
	}

	public void setEntityItem(IG013Info entityItem) {
		this.entityItem = entityItem;
	}
	/**
	 * ��Ա��Ϣȡ��
	 * @return ��Ա��Ϣ
	 */
	public IGASM1502Form getIgasm1502Form() {
		return igasm1502Form;
	}

	/**
	 * ��Ա��Ϣ�趨
	 *
	 * @param igasm1502Form ��Ա��Ϣ
	 */
	public void setIgasm1502Form(IGASM1502Form igasm1502Form) {
		this.igasm1502Form = igasm1502Form;
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
	 * ��Աɾ������ȡ��
	 * @return ��Աɾ������
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * ��Աɾ�������趨
	 *
	 * @param deleteEntityItem ��Աɾ������
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * ��Ա������Ϣȡ��
	 * @return ��Ա������Ϣ
	 */
	public IGASM1504Form getIgasm1504Form() {
		return igasm1504Form;
	}


	/**
	 * ��Ա������Ϣ���������趨
	 *
	 * @param igasm1504Form ��Ա������Ϣ��������
	 */
	public void setIgasm1504Form(IGASM1504Form igasm1504Form) {
		this.igasm1504Form = igasm1504Form;
	}

	/**
	 * ��Ա������Ϣ�������ȡ��
	 * @return ��Ա������Ϣ�������
	 */
	public List<IG002Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	/**
	 * ��Ա������Ϣ��������趨
	 *
	 * @param configItemVWInfoList ��Ա������Ϣ�������
	 */
	public void setConfigItemVWInfoList(List<IG002Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

	/**
	 * ��Ա������Ϣ��ʷ��¼��������ȡ��
	 * @return ��Ա������Ϣ��ʷ��¼��������
	 */
	public IGASM1505Form getIgasm1505Form() {
		return igasm1505Form;
	}

	/**
	 * ��Ա������Ϣ��ʷ��¼���������趨
	 *
	 * @param igasm1505Form ��Ա������Ϣ��ʷ��¼��������
	 */
	public void setIgasm1505Form(IGASM1505Form igasm1505Form) {
		this.igasm1505Form = igasm1505Form;
	}

	/**
	 * ��Ա������Ϣ��ʷ��¼�������ȡ��
	 * @return ��Ա������Ϣ��ʷ��¼�������
	 */
	public List<IG800Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * ��Ա������Ϣ��ʷ��¼��������趨
	 *
	 * @param configItemList ��Ա������Ϣ��ʷ��¼�������
	 */
	public void setConfigItemList(List<IG800Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * ��Ա��ϵ�����������ȡ��
	 * @return ��Ա��ϵ�����������
	 */
	public IGASM1506Form getIgasm1506Form() {
		return igasm1506Form;
	}

	/**
	 * ��Ա��ϵ������������趨
	 *
	 * @param igasm1506Form ��Ա��ϵ�����������
	 */
	public void setIgasm1506Form(IGASM1506Form igasm1506Form) {
		this.igasm1506Form = igasm1506Form;
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
	 * ��Ա��ϵ�༭��Ϣȡ��
	 * @return �༭��Ϣ
	 */
	public IGASM1507Form getIgasm1507Form() {
		return igasm1507Form;
	}

	/**
	 * ��Ա��ϵ�༭��Ϣ�趨
	 *
	 * @param igasm1507Form ��Ա��ϵ�༭��Ϣ
	 */
	public void setIgasm1507Form(IGASM1507Form igasm1507Form) {
		this.igasm1507Form = igasm1507Form;
	}

	/**
	 * ��Ա��ϵ�༭����Ϣȡ��
	 * 
	 * @return entityItemRelation ��Ա��ϵ�༭����Ϣ
	 */
	public SOC0119Info getEntityItemRelation() {
		return entityItemRelation;
	}

	/**
	 * ��Ա��ϵ�༭����Ϣ�趨
	 * @param entityItemRelation ��Ա��ϵ�༭����Ϣ
	 */
	public void setEntityItemRelation(SOC0119Info entityItemRelation) {
		this.entityItemRelation = entityItemRelation;
	}

	/**
	 * ��Ա��ϵɾ������ȡ��
	 * @return ��Ա��ϵɾ������
	 */
	public String[] getDeleteEntityItemRelation() {
		return deleteEntityItemRelation;
	}

	/**
	 * ��Ա��ϵɾ�������趨
	 *
	 * @param entityItemRelation ��Ա��ϵɾ������
	 */
	public void setDeleteEntityItemRelation(String[] deleteEntityItemRelation) {
		this.deleteEntityItemRelation = deleteEntityItemRelation;
	}
	
	/**
	 * �ʲ���������Ϣ�������ȡ��
	 * @return �ʲ���������Ϣ�������
	 */
	public Map<String, List<SOC0129Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}
	/**
	 * �ʲ���������Ϣ��������趨
	 *
	 * @param configItemVWInfoMap �ʲ���������Ϣ�������
	 */
	public void setConfigItemVWInfoMap(
Map<String, List<SOC0129Info>> configItemVWInfoMap) {
		this.configItemVWInfoMap = configItemVWInfoMap;
	}
	
	/**
	 * �ʲ���������Ϣ�������ȡ��
	 * @return �ʲ���������Ϣ�������
	 */
	public Map<String, List<SOC0107Info>> getConfigItemMap() {
		return configItemMap;
	}
	/**
	 * �ʲ���������Ϣ��������趨
	 *
	 * @param configItemMap �ʲ���������Ϣ�������
	 */
	public void setConfigItemMap(
Map<String, List<SOC0107Info>> configItemMap) {
		this.configItemMap = configItemMap;
	}

	/**
	 * ������idȡ��
	 * @return ������id
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * ������id�趨
	 *
	 * @param userid ������id
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * �����������趨
	 *
	 * @param username ����������
	 */
	public void setUsername(String username) {
		this.username = username;
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
	 * ��Ա�������ȡ��
	 * 
	 * @return entityItemVWInfoList ��Ա�������
	 */
	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * ��Ա������Ϣ������Ա��Ϣȡ��
	 * 
	 * @return entityItemVWInfo ��Ա������Ϣ������Ա��Ϣ
	 */
	public SOC0124Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * ��Ա������Ϣ������Ա��Ϣ�趨
	 * 
	 * @param entityItemVWInfo
	 *            ��Ա������Ϣ������Ա��Ϣ
	 */
	public void setEntityItemVWInfo(SOC0124Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * ��Ա��������趨
	 * 
	 * @param entityItemVWInfoList
	 *            ��Ա�������
	 */
	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/**
	 * �ʲ��汾�б�ȡ��
	 * 
	 * @return configItemVersionTime �ʲ��汾�б�
	 */
	public List<SOC0128Info> getConfigItemVersionTime() {
		return configItemVersionTime;
	}

	/**
	 * �ʲ��汾�б��趨
	 * @param configItemVersionTime �ʲ��汾�б�
	 */
	public void setConfigItemVersionTime(List<SOC0128Info> configItemVersionTime) {
		this.configItemVersionTime = configItemVersionTime;
	}
	
}


