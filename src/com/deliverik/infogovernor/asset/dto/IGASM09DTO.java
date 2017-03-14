package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.model.IG013Info;
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
import com.deliverik.infogovernor.asset.form.IGASM0902Form;
import com.deliverik.infogovernor.asset.form.IGASM0904Form;
import com.deliverik.infogovernor.asset.form.IGASM0905Form;
import com.deliverik.infogovernor.asset.form.IGASM0906Form;
import com.deliverik.infogovernor.asset.form.IGASM0907Form;
import com.deliverik.infogovernor.asset.form.IGASM0912Form;
import com.deliverik.infogovernor.asset.model.EntityItemFacilitatorVWInfo;
import com.deliverik.infogovernor.asset.model.condition.EntityItemFacilitatorVWSearchCond;

/**
 * ���������ù���ҵ����DTO
 * �޸ļ�¼: 2012/11/27 LuJiayuan ���ӱ�ʶ�ж��Ƿ���ʾͼ��ť
 */
@SuppressWarnings("serial")
public class IGASM09DTO extends BaseDTO implements Serializable{

	protected IG800SearchCond configItemSearchCond;
	public IG800SearchCond getConfigItemSearchCond() {
		return configItemSearchCond;
	}

	public void setConfigItemSearchCond(IG800SearchCond configItemSearchCond) {
		this.configItemSearchCond = configItemSearchCond;
	}
	/** ��������Ϣ��ͼ�������� */
	protected EntityItemFacilitatorVWSearchCond entityItemFacilitatorVWSearchCond;
	
	/** ��������Ϣ��ͼ������� */
	protected List<EntityItemFacilitatorVWInfo> entityItemFacilitatorList;
	
	/** ��������Ϣ */
	protected IGASM0902Form igasm0902Form;
	
	/** ��������Ϣ�������� */
	protected SOC0124SearchCond entityItemVWSearchCond;
	
	/** ���������� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;

	/** �����̼������ */
	protected List<SOC0124Info> entityItemVWInfoList;

	/** ������ɾ������ */
	protected String[] deleteEntityItem;

	/** ������������Ϣ */
	protected IGASM0904Form igasm0904Form;
	
	/** ������������Ϣ������� */
	protected List<SOC0129Info> configItemVWInfoList;

	/** ������������Ϣ�����������Ϣ */
	protected SOC0124Info entityItemVWInfo;

	/** ������������Ϣ��ʷ��¼�������� */
	protected IGASM0905Form igasm0905Form;
	
	/** ������������Ϣ��ʷ��¼������� */
	protected List<SOC0107Info> configItemList;
	
	/** �����̹�ϵ����������� */
	protected IGASM0906Form igasm0906Form;
	
	
	/** �ʲ����ϵ������Ϣ�������1 */
	protected List<SOC0119Info> parEntityItemRelationList;
	
	/** �ʲ����ϵ������Ϣ�������2 */
	protected List<SOC0119Info> cldEntityItemRelationList;
	
	/** �����̹�ϵ�༭��Ϣ */
	protected IGASM0907Form igasm0907Form;
	
	/** �����̹�ϵ�༭����Ϣ */
	protected SOC0119Info entityItemRelation;

	/** �����̹�ϵɾ������ */
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
	
	/** ������������������ */
	protected String eiorgname;
	/** ��������Ϣ�޸� */
	protected IGASM0912Form igasm0912Form;
	
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
	protected List<SOC0128Info> configItemVersionTime;
	
	/** ͼ��ɨ��XML */
	protected String picuXml;
	
	/** ͼ��鿴XML */
	protected String picsXml;
	
	/** �Ƿ���ʾͼ��ť��ʶ */
	protected Boolean image_flag;
	
	public String getPicuXml() {
		return picuXml;
	}

	public void setPicuXml(String picuXml) {
		this.picuXml = picuXml;
	}

	public String getPicsXml() {
		return picsXml;
	}

	public void setPicsXml(String picsXml) {
		this.picsXml = picsXml;
	}
	
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
	
	
	public IGASM0912Form getIgasm0912Form() {
		return igasm0912Form;
	}

	public void setIgasm0912Form(IGASM0912Form igasm0912Form) {
		this.igasm0912Form = igasm0912Form;
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
	
	/** ��������������id */
	protected String orgid;
	
	/** ��������������name */
	protected String orgname;
	
	/** �������·�ʱ�� */
	protected String issuetime;
	
	/** ������������ */
	protected String recivename;
	
	/** �����̵�ǰ�汾�� */
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

	
	/** ��������Ϣ�����������Ϣ */
	protected IG013Info entityItem;

	public IG013Info getEntityItem() {
		return entityItem;
	}

	public void setEntityItem(IG013Info entityItem) {
		this.entityItem = entityItem;
	}

	/**
	 * ��������Ϣȡ��
	 * @return ��������Ϣ
	 */
	public IGASM0902Form getIgasm0902Form() {
		return igasm0902Form;
	}

	/**
	 * ��������Ϣ�趨
	 *
	 * @param igasm0902Form ��������Ϣ
	 */
	public void setIgasm0902Form(IGASM0902Form igasm0902Form) {
		this.igasm0902Form = igasm0902Form;
	}
	

	/**
	 * ��������Ϣ��������ȡ��
	 * @return ��������Ϣ��������
	 */
	public SOC0124SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * ��������Ϣ���������趨
	 *
	 * @param entityItemVWSearchCond ��������Ϣ��������
	 */
	public void setEntityItemVWSearchCond(
			SOC0124SearchCond entityItemVWSearchCond) {
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
	 * �����̼������ȡ��
	 * @return �����̼������
	 */
	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * �����̼�������趨
	 *
	 * @param entityItemVWInfoList �����̼������
	 */
	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/**
	 * ������ɾ������ȡ��
	 * @return ������ɾ������
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * ������ɾ�������趨
	 *
	 * @param deleteEntityItem ������ɾ������
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * ������������Ϣȡ��
	 * @return ������������Ϣ
	 */
	public IGASM0904Form getIgasm0904Form() {
		return igasm0904Form;
	}


	/**
	 * ������������Ϣ���������趨
	 *
	 * @param igasm0904Form ������������Ϣ��������
	 */
	public void setIgasm0904Form(IGASM0904Form igasm0904Form) {
		this.igasm0904Form = igasm0904Form;
	}

	/**
	 * ������������Ϣ�������ȡ��
	 * @return ������������Ϣ�������
	 */
	public List<SOC0129Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	/**
	 * ������������Ϣ��������趨
	 *
	 * @param configItemVWInfoList ������������Ϣ�������
	 */
	public void setConfigItemVWInfoList(List<SOC0129Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

	/**
	 * ������������Ϣ�����������Ϣȡ��
	 * @return ������������Ϣ�����������Ϣ
	 */
	public SOC0124Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * ������������Ϣ�����������Ϣ�趨
	 *
	 * @param entityItemVWInfo ������������Ϣ�����������Ϣ
	 */
	public void setEntityItemVWInfo(SOC0124Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * ������������Ϣ��ʷ��¼��������ȡ��
	 * @return ������������Ϣ��ʷ��¼��������
	 */
	public IGASM0905Form getIgasm0905Form() {
		return igasm0905Form;
	}

	/**
	 * ������������Ϣ��ʷ��¼���������趨
	 *
	 * @param igasm0905Form ������������Ϣ��ʷ��¼��������
	 */
	public void setIgasm0905Form(IGASM0905Form igasm0905Form) {
		this.igasm0905Form = igasm0905Form;
	}

	/**
	 * ������������Ϣ��ʷ��¼�������ȡ��
	 * @return ������������Ϣ��ʷ��¼�������
	 */
	public List<SOC0107Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * ������������Ϣ��ʷ��¼��������趨
	 *
	 * @param configItemList ������������Ϣ��ʷ��¼�������
	 */
	public void setConfigItemList(List<SOC0107Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * �����̹�ϵ�����������ȡ��
	 * @return �����̹�ϵ�����������
	 */
	public IGASM0906Form getIgasm0906Form() {
		return igasm0906Form;
	}

	/**
	 * �����̹�ϵ������������趨
	 *
	 * @param igasm0906Form �����̹�ϵ�����������
	 */
	public void setIgasm0906Form(IGASM0906Form igasm0906Form) {
		this.igasm0906Form = igasm0906Form;
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
	 * �����̹�ϵ�༭��Ϣȡ��
	 * @return �༭��Ϣ
	 */
	public IGASM0907Form getIgasm0907Form() {
		return igasm0907Form;
	}

	/**
	 * �����̹�ϵ�༭��Ϣ�趨
	 *
	 * @param igasm0907Form �����̹�ϵ�༭��Ϣ
	 */
	public void setIgasm0907Form(IGASM0907Form igasm0907Form) {
		this.igasm0907Form = igasm0907Form;
	}

	/**
	 * �����̹�ϵ�༭����Ϣȡ��
	 * @return �����̹�ϵ�༭����Ϣ
	 */
	public SOC0119Info getEntityItemRelation() {
		return entityItemRelation;
	}

	/**
	 * �����̹�ϵ�༭����Ϣ�趨
	 *
	 * @param entityItemRelation �����̹�ϵ�༭����Ϣ
	 */
	public void setEntityItemRelation(SOC0119Info entityItemRelation) {
		this.entityItemRelation = entityItemRelation;
	}

	/**
	 * �����̹�ϵɾ������ȡ��
	 * @return �����̹�ϵɾ������
	 */
	public String[] getDeleteEntityItemRelation() {
		return deleteEntityItemRelation;
	}

	/**
	 * �����̹�ϵɾ�������趨
	 *
	 * @param entityItemRelation �����̹�ϵɾ������
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
	public List<SOC0128Info> getConfigItemVersionTime() {
		return configItemVersionTime;
	}

	/**
	 * �ʲ��汾�б��趨
	 *
	 * @param configItemVersionTime �ʲ��汾�б�
	 */
	public void setConfigItemVersionTime(
			List<SOC0128Info> configItemVersionTime) {
		this.configItemVersionTime = configItemVersionTime;
	}
	
	/**
	 * image_flagȡ��
	 *
	 * @return image_flag image_flag
	 */
	public Boolean getImage_flag() {
		return image_flag;
	}
	/**
	 * image_flag�趨
	 *
	 * @param image_flag image_flag
	 */
	public void setImage_flag(Boolean image_flag) {
		this.image_flag = image_flag;
	}
	
	/**
	 * ��������Ϣ��ͼ�������� ȡ��
	 *
	 * @return entityItemFacilitatorVWSearchCond
	 */
	public EntityItemFacilitatorVWSearchCond getEntityItemFacilitatorVWSearchCond() {
		return entityItemFacilitatorVWSearchCond;
	}
	
	/**
	 * ��������Ϣ��ͼ�������� �趨
	 *
	 * @param entityItemFacilitatorVWSearchCond
	 */
	public void setEntityItemFacilitatorVWSearchCond(
			EntityItemFacilitatorVWSearchCond entityItemFacilitatorVWSearchCond) {
		this.entityItemFacilitatorVWSearchCond = entityItemFacilitatorVWSearchCond;
	}
	/**
	 * ��������Ϣ��ͼ������� ȡ��
	 *
	 * @return entityItemFacilitatorList
	 */
	public List<EntityItemFacilitatorVWInfo> getEntityItemFacilitatorList() {
		return entityItemFacilitatorList;
	}
	/**
	 * ��������Ϣ��ͼ������� �趨
	 *
	 * @param entityItemFacilitatorList
	 */
	public void setEntityItemFacilitatorList(
			List<EntityItemFacilitatorVWInfo> entityItemFacilitatorList) {
		this.entityItemFacilitatorList = entityItemFacilitatorList;
	}

}