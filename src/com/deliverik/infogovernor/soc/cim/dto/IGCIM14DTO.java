package com.deliverik.infogovernor.soc.cim.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.IG887Info;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1402Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1404Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1405Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1406Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1407Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1412Form;

/**
 * ��Ա���ù���ҵ����DTO
 * 
 */
@SuppressWarnings("serial")
public class IGCIM14DTO extends BaseDTO implements Serializable{

	protected SOC0107SearchCond configItemSearchCond;

	/** ��Ա��Ϣ */
	protected IGCIM1402Form igcim1402Form;
	
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
	protected IGCIM1404Form igcim1404Form;
	
	/** ��Ա������Ϣ������� */
	protected List<IG002Info> configItemVWInfoList;

	/** ��Ա������Ϣ������Ա��Ϣ */
	protected SOC0124Info entityItemVWInfo;

	/** ��Ա������Ϣ��ʷ��¼�������� */
	protected IGCIM1405Form igcim1405Form;
	
	/** ��Ա������Ϣ��ʷ��¼������� */
	protected List<SOC0107Info> configItemList;
	
	/** ��Ա��ϵ����������� */
	protected IGCIM1406Form igcim1406Form;
	
	/** �ʲ����ϵ������Ϣ�������1 */
	protected List<SOC0119Info> parEntityItemRelationList;
	
	/** �ʲ����ϵ������Ϣ�������2 */
	protected List<SOC0119Info> cldEntityItemRelationList;
	
	/** ��Ա��ϵ�༭��Ϣ */
	protected IGCIM1407Form igcim1407Form;
	
	/** ��Ա��ϵ�༭����Ϣ */
	protected SOC0119Info entityItemRelation;

	/** ��Ա��ϵɾ������ */
	protected String[] deleteEntityItemRelation;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<SOC0129Info>> configItemVWInfoMap;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<SOC0107Info>> configItemMap;
	
	/**������id*/
	protected String userid;
	
	/**����������*/
	protected String username;
	
	/** �ʲ������ϵ�����б� */
	protected List<LabelValueBean> relationList;
	
	protected String reciveUser;
	protected Map<String,List<SOC0119Info>> parEntityItemRelationMap;
	protected Map<String,List<SOC0119Info>> cldEntityItemRelationMap;
	protected int parCount;
	protected int cldCount;
	
	/** ��Ա������������ */
	protected String eiorgname;
	/** ��Ա��Ϣ�޸� */
	protected IGCIM1412Form igcim1412Form;
	
	/** �û����� */
	private User user;
	
	/** Ȩ�ޱ�ʶ */
	protected Boolean flag;
	
	/** ��������� */
	protected String orgsyscoding;
	
	/** ģ�Ͳ���� */
	protected String esyscoding;
	
	/** ģ������ */
	protected String ename;
	
	/** �ʲ��汾�б� */
	protected List<IG887Info> configItemVersionTime;
	
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
	 * �ʲ����ϵ������Ϣ�������1ȡ��
	 * @return �ʲ����ϵ������Ϣ�������1
	 */
	public List<SOC0119Info> getParEntityItemRelationList() {
		return parEntityItemRelationList;
	}

	/**
	 * �ʲ����ϵ������Ϣ�������1�趨
	 *
	 * @param parEntityItemRelationList �ʲ����ϵ������Ϣ�������1
	 */
	public void setParEntityItemRelationList(
			List<SOC0119Info> parEntityItemRelationList) {
		this.parEntityItemRelationList = parEntityItemRelationList;
	}

	/**
	 * �ʲ����ϵ������Ϣ�������2ȡ��
	 * @return �ʲ����ϵ������Ϣ�������2
	 */
	public List<SOC0119Info> getCldEntityItemRelationList() {
		return cldEntityItemRelationList;
	}

	/**
	 * �ʲ����ϵ������Ϣ�������2�趨
	 *
	 * @param cldEntityItemRelationList �ʲ����ϵ������Ϣ�������2
	 */
	public void setCldEntityItemRelationList(
			List<SOC0119Info> cldEntityItemRelationList) {
		this.cldEntityItemRelationList = cldEntityItemRelationList;
	}


	/**
	 * ��Ա��ϵ�༭����Ϣȡ��
	 * @return ��Ա��ϵ�༭����Ϣ
	 */
	public SOC0119Info getEntityItemRelation() {
		return entityItemRelation;
	}

	/**
	 * ��Ա��ϵ�༭����Ϣ�趨
	 *
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

	public SOC0107SearchCond getConfigItemSearchCond() {
		return configItemSearchCond;
	}

	public void setConfigItemSearchCond(SOC0107SearchCond configItemSearchCond) {
		this.configItemSearchCond = configItemSearchCond;
	}

	public SOC0124SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	public void setEntityItemVWSearchCond(SOC0124SearchCond entityItemVWSearchCond) {
		this.entityItemVWSearchCond = entityItemVWSearchCond;
	}

	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	public IGCIM1402Form getIgcim1402Form() {
		return igcim1402Form;
	}

	public void setIgcim1402Form(IGCIM1402Form igcim1402Form) {
		this.igcim1402Form = igcim1402Form;
	}

	public IGCIM1404Form getIgcim1404Form() {
		return igcim1404Form;
	}

	public void setIgcim1404Form(IGCIM1404Form igcim1404Form) {
		this.igcim1404Form = igcim1404Form;
	}

	public IGCIM1405Form getIgcim1405Form() {
		return igcim1405Form;
	}

	public void setIgcim1405Form(IGCIM1405Form igcim1405Form) {
		this.igcim1405Form = igcim1405Form;
	}

	public IGCIM1406Form getIgcim1406Form() {
		return igcim1406Form;
	}

	public void setIgcim1406Form(IGCIM1406Form igcim1406Form) {
		this.igcim1406Form = igcim1406Form;
	}

	public IGCIM1407Form getIgcim1407Form() {
		return igcim1407Form;
	}

	public void setIgcim1407Form(IGCIM1407Form igcim1407Form) {
		this.igcim1407Form = igcim1407Form;
	}

	public IGCIM1412Form getIgcim1412Form() {
		return igcim1412Form;
	}

	public void setIgcim1412Form(IGCIM1412Form igcim1412Form) {
		this.igcim1412Form = igcim1412Form;
	}

	public SOC0124Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	public void setEntityItemVWInfo(SOC0124Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	public List<SOC0107Info> getConfigItemList() {
		return configItemList;
	}

	public void setConfigItemList(List<SOC0107Info> configItemList) {
		this.configItemList = configItemList;
	}
	
}


