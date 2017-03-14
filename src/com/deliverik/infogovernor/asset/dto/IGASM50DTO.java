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
import com.deliverik.infogovernor.asset.form.IGASM5002Form;
import com.deliverik.infogovernor.asset.form.IGASM5004Form;
import com.deliverik.infogovernor.asset.form.IGASM5005Form;
import com.deliverik.infogovernor.asset.form.IGASM5006Form;
import com.deliverik.infogovernor.asset.form.IGASM5007Form;
import com.deliverik.infogovernor.asset.form.IGASM5008Form;

/**
 * �ĵ����ù���ҵ����DTO
 * 
 */
@SuppressWarnings("serial")
public class IGASM50DTO extends BaseDTO implements Serializable{

	/** �ĵ���Ϣ */
	protected IGASM5002Form igasm5002Form;
	
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
	protected IGASM5004Form igasm5004Form;
	
	/** �ĵ�������Ϣ������� */
	protected List<SOC0129Info> configItemVWInfoList;

	/** �ĵ�������Ϣ�����ĵ���Ϣ */
	protected SOC0124Info entityItemVWInfo;

	/** �ĵ�������Ϣ��ʷ��¼�������� */
	protected IGASM5005Form igasm5005Form;
	
	/** �ĵ�������Ϣ��ʷ��¼������� */
	protected List<SOC0107Info> configItemList;
	
	/** �ĵ���ϵ����������� */
	protected IGASM5006Form igasm5006Form;
	
	/** �ʲ����ϵ������Ϣ�������1 */
	protected List<SOC0119Info> parEntityItemRelationList;
	
	/** �ʲ����ϵ������Ϣ�������2 */
	protected List<SOC0119Info> cldEntityItemRelationList;
	
	/** �ĵ���ϵ�༭��Ϣ */
	protected IGASM5007Form igasm5007Form;
	
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
	
	protected IGASM5008Form igasm5008Form;
	
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
	
	
	public IGASM5008Form getIgasm5008Form() {
		return igasm5008Form;
	}

	public void setIgasm5008Form(IGASM5008Form igasm5008Form) {
		this.igasm5008Form = igasm5008Form;
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
	public IGASM5002Form getIgasm5002Form() {
		return igasm5002Form;
	}

	/**
	 * �ĵ���Ϣ�趨
	 *
	 * @param igasm5002Form �ĵ���Ϣ
	 */
	public void setIgasm5002Form(IGASM5002Form igasm5002Form) {
		this.igasm5002Form = igasm5002Form;
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
	public IGASM5004Form getIgasm5004Form() {
		return igasm5004Form;
	}


	/**
	 * �ĵ�������Ϣ���������趨
	 *
	 * @param igasm5004Form �ĵ�������Ϣ��������
	 */
	public void setIgasm5004Form(IGASM5004Form igasm5004Form) {
		this.igasm5004Form = igasm5004Form;
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
	public IGASM5005Form getIgasm5005Form() {
		return igasm5005Form;
	}

	/**
	 * �ĵ�������Ϣ��ʷ��¼���������趨
	 *
	 * @param igasm5005Form �ĵ�������Ϣ��ʷ��¼��������
	 */
	public void setIgasm5005Form(IGASM5005Form igasm5005Form) {
		this.igasm5005Form = igasm5005Form;
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
	public IGASM5006Form getIgasm5006Form() {
		return igasm5006Form;
	}

	/**
	 * �ĵ���ϵ������������趨
	 *
	 * @param igasm5006Form �ĵ���ϵ�����������
	 */
	public void setIgasm5006Form(IGASM5006Form igasm5006Form) {
		this.igasm5006Form = igasm5006Form;
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
	public IGASM5007Form getIgasm5007Form() {
		return igasm5007Form;
	}

	/**
	 * �ĵ���ϵ�༭��Ϣ�趨
	 *
	 * @param igasm5007Form �ĵ���ϵ�༭��Ϣ
	 */
	public void setIgasm5007Form(IGASM5007Form igasm5007Form) {
		this.igasm5007Form = igasm5007Form;
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


