package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.form.IGASM0502Form;
import com.deliverik.infogovernor.asset.form.IGASM0504Form;
import com.deliverik.infogovernor.asset.form.IGASM0505Form;
import com.deliverik.infogovernor.asset.form.IGASM0506Form;
import com.deliverik.infogovernor.asset.form.IGASM0507Form;
import com.deliverik.infogovernor.asset.form.IGASM0512Form;

/**
 * �ĵ����ù���ҵ����DTO
 * 
 */
@SuppressWarnings("serial")
public class IGASM05DTO extends BaseDTO implements Serializable{

	/** �ĵ���Ϣ */
	protected IGASM0502Form igasm0502Form;
	
	/** �ĵ���Ϣ�������� */
	protected SOC0124SearchCond entityItemVWSearchCond;
	
	/** ���������� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;

	/** �ĵ�������� */
	protected List<SOC0124Info> entityItemVWInfoList;

	/** �ĵ�ɾ������ */
	protected String[] deleteEntityItem;

	/** �ĵ�������Ϣ */
	protected IGASM0504Form igasm0504Form;
	
	/** �ĵ�������Ϣ������� */
	protected List<SOC0129Info> configItemVWInfoList;

	/** �ĵ�������Ϣ�����ĵ���Ϣ */
	protected SOC0124Info entityItemVWInfo;

	/** �ĵ�������Ϣ��ʷ��¼�������� */
	protected IGASM0505Form igasm0505Form;
	
	/** �ĵ�������Ϣ��ʷ��¼������� */
	protected List<SOC0107Info> configItemList;
	
	/** �ĵ���ϵ����������� */
	protected IGASM0506Form igasm0506Form;
	
	/** �ʲ����ϵ������Ϣ�������1 */
	protected List<SOC0119Info> parEntityItemRelationList;
	
	/** �ʲ����ϵ������Ϣ�������2 */
	protected List<SOC0119Info> cldEntityItemRelationList;
	
	/** �ĵ���ϵ�༭��Ϣ */
	protected IGASM0507Form igasm0507Form;
	
	/** �ĵ���ϵ�༭����Ϣ */
	protected SOC0119Info entityItemRelation;

	/** �ĵ���ϵɾ������ */
	protected String[] deleteEntityItemRelation;
	
	/** �ʲ������ϵ�����б� */
	protected List<LabelValueBean> relationList;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<SOC0107Info>> configItemMap;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<SOC0129Info>> configItemVWInfoMap;
	
	protected Map<String,List<SOC0119Info>> parEntityItemRelationMap;
	protected Map<String,List<SOC0119Info>> cldEntityItemRelationMap;
	protected int parCount;
	protected int cldCount;
	/** �ĵ������������� */
	protected String eiorgname;
	protected IGASM0512Form igasm0512Form;
	
	/**�汾����*/
	protected Map<Integer,Integer> checkVersionMap;
	
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
	
	/** �ʲ�ϸ������ */
	protected String contentitem;
	
	/** �ʲ��汾�б� */
	protected List<SOC0128Info> configItemVersionTime;
	
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
	
	
	public IGASM0512Form getIgasm0512Form() {
		return igasm0512Form;
	}

	public void setIgasm0512Form(IGASM0512Form igasm0512Form) {
		this.igasm0512Form = igasm0512Form;
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
	/**
	 * �ĵ���Ϣȡ��
	 * @return �ĵ���Ϣ
	 */
	public IGASM0502Form getIgasm0502Form() {
		return igasm0502Form;
	}

	/**
	 * �ĵ���Ϣ�趨
	 *
	 * @param igasm0502Form �ĵ���Ϣ
	 */
	public void setIgasm0502Form(IGASM0502Form igasm0502Form) {
		this.igasm0502Form = igasm0502Form;
	}

	/**
	 * �ĵ���Ϣ��������ȡ��
	 * @return �ĵ���Ϣ��������
	 */
	public SOC0124SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * �ĵ���Ϣ���������趨
	 *
	 * @param entityItemVWSearchCond �ĵ���Ϣ��������
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
	 * �ĵ��������ȡ��
	 * @return �ĵ��������
	 */
	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * �ĵ���������趨
	 *
	 * @param entityItemVWInfoList �ĵ��������
	 */
	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/**
	 * �ĵ�ɾ������ȡ��
	 * @return �ĵ�ɾ������
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * �ĵ�ɾ�������趨
	 *
	 * @param deleteEntityItem �ĵ�ɾ������
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * �ĵ�������Ϣȡ��
	 * @return �ĵ�������Ϣ
	 */
	public IGASM0504Form getIgasm0504Form() {
		return igasm0504Form;
	}


	/**
	 * �ĵ�������Ϣ���������趨
	 *
	 * @param igasm0504Form �ĵ�������Ϣ��������
	 */
	public void setIgasm0504Form(IGASM0504Form igasm0504Form) {
		this.igasm0504Form = igasm0504Form;
	}

	/**
	 * �ĵ�������Ϣ�������ȡ��
	 * @return �ĵ�������Ϣ�������
	 */
	public List<SOC0129Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	/**
	 * �ĵ�������Ϣ��������趨
	 *
	 * @param configItemVWInfoList �ĵ�������Ϣ�������
	 */
	public void setConfigItemVWInfoList(List<SOC0129Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

	/**
	 * �ĵ�������Ϣ�����ĵ���Ϣȡ��
	 * @return �ĵ�������Ϣ�����ĵ���Ϣ
	 */
	public SOC0124Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * �ĵ�������Ϣ�����ĵ���Ϣ�趨
	 *
	 * @param entityItemVWInfo �ĵ�������Ϣ�����ĵ���Ϣ
	 */
	public void setEntityItemVWInfo(SOC0124Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * �ĵ�������Ϣ��ʷ��¼��������ȡ��
	 * @return �ĵ�������Ϣ��ʷ��¼��������
	 */
	public IGASM0505Form getIgasm0505Form() {
		return igasm0505Form;
	}

	/**
	 * �ĵ�������Ϣ��ʷ��¼���������趨
	 *
	 * @param igasm0505Form �ĵ�������Ϣ��ʷ��¼��������
	 */
	public void setIgasm0505Form(IGASM0505Form igasm0505Form) {
		this.igasm0505Form = igasm0505Form;
	}

	/**
	 * �ĵ�������Ϣ��ʷ��¼�������ȡ��
	 * @return �ĵ�������Ϣ��ʷ��¼�������
	 */
	public List<SOC0107Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * �ĵ�������Ϣ��ʷ��¼��������趨
	 *
	 * @param configItemList �ĵ�������Ϣ��ʷ��¼�������
	 */
	public void setConfigItemList(List<SOC0107Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * �ĵ���ϵ�����������ȡ��
	 * @return �ĵ���ϵ�����������
	 */
	public IGASM0506Form getIgasm0506Form() {
		return igasm0506Form;
	}

	/**
	 * �ĵ���ϵ������������趨
	 *
	 * @param igasm0506Form �ĵ���ϵ�����������
	 */
	public void setIgasm0506Form(IGASM0506Form igasm0506Form) {
		this.igasm0506Form = igasm0506Form;
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
	 * �ĵ���ϵ�༭��Ϣȡ��
	 * @return �༭��Ϣ
	 */
	public IGASM0507Form getIgasm0507Form() {
		return igasm0507Form;
	}

	/**
	 * �ĵ���ϵ�༭��Ϣ�趨
	 *
	 * @param igasm0507Form �ĵ���ϵ�༭��Ϣ
	 */
	public void setIgasm0507Form(IGASM0507Form igasm0507Form) {
		this.igasm0507Form = igasm0507Form;
	}

	/**
	 * �ĵ���ϵ�༭����Ϣȡ��
	 * @return �ĵ���ϵ�༭����Ϣ
	 */
	public SOC0119Info getEntityItemRelation() {
		return entityItemRelation;
	}

	/**
	 * �ĵ���ϵ�༭����Ϣ�趨
	 *
	 * @param entityItemRelation �ĵ���ϵ�༭����Ϣ
	 */
	public void setEntityItemRelation(SOC0119Info entityItemRelation) {
		this.entityItemRelation = entityItemRelation;
	}

	/**
	 * �ĵ���ϵɾ������ȡ��
	 * @return �ĵ���ϵɾ������
	 */
	public String[] getDeleteEntityItemRelation() {
		return deleteEntityItemRelation;
	}

	/**
	 * �ĵ���ϵɾ�������趨
	 *
	 * @param entityItemRelation �ĵ���ϵɾ������
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
	 * �ʲ�ϸ������ȡ��
	 * @return �ʲ�ϸ������
	 */
	public String getContentitem() {
		return contentitem;
	}
	
	/**
	 * �ʲ�ϸ�������趨
	 * @param contentitem �ʲ�ϸ������
	 */
	public void setContentitem(String contentitem) {
		this.contentitem = contentitem;
	}
	
	/**
	 * �汾����ȡ��
	 * @return checkVersionMap �汾����
	 */
	public Map<Integer, Integer> getCheckVersionMap() {
		return checkVersionMap;
	}

	/**
	 * �汾�����趨
	 * @param checkVersionMap �汾����
	 */
	public void setCheckVersionMap(Map<Integer, Integer> checkVersionMap) {
		this.checkVersionMap = checkVersionMap;
	}

}


