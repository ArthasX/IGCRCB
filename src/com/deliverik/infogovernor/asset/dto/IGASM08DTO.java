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
import com.deliverik.infogovernor.asset.form.IGASM0802Form;
import com.deliverik.infogovernor.asset.form.IGASM0804Form;
import com.deliverik.infogovernor.asset.form.IGASM0805Form;
import com.deliverik.infogovernor.asset.form.IGASM0806Form;
import com.deliverik.infogovernor.asset.form.IGASM0807Form;
import com.deliverik.infogovernor.asset.form.IGASM0812Form;

/**
 * Ӧ�����ù���ҵ����DTO
 * 
 */
@SuppressWarnings("serial")
public class IGASM08DTO extends BaseDTO implements Serializable{

	/** Ӧ����Ϣ */
	protected IGASM0802Form igasm0802Form;
	
	/** Ӧ����Ϣ�������� */
	protected SOC0124SearchCond entityItemVWSearchCond;
	
	/** ���������� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;

	/** Ӧ�ü������ */
	protected List<SOC0124Info> entityItemVWInfoList;

	/** Ӧ��ɾ������ */
	protected String[] deleteEntityItem;

	/** Ӧ��������Ϣ */
	protected IGASM0804Form igasm0804Form;
	
	/** Ӧ��������Ϣ������� */
	protected List<SOC0129Info> configItemVWInfoList;

	/** Ӧ��������Ϣ����Ӧ����Ϣ */
	protected SOC0124Info entityItemVWInfo;

	/** Ӧ��������Ϣ��ʷ��¼�������� */
	protected IGASM0805Form igasm0805Form;
	
	/** Ӧ��������Ϣ��ʷ��¼������� */
	protected List<SOC0107Info> configItemList;
	
	/** Ӧ�ù�ϵ����������� */
	protected IGASM0806Form igasm0806Form;
	
	/** �ʲ����ϵ������Ϣ�������1 */
	protected List<SOC0119Info> parEntityItemRelationList;
	
	/** �ʲ����ϵ������Ϣ�������2 */
	protected List<SOC0119Info> cldEntityItemRelationList;
	
	/** Ӧ�ù�ϵ�༭��Ϣ */
	protected IGASM0807Form igasm0807Form;
	
	/** Ӧ�ù�ϵ�༭����Ϣ */
	protected SOC0119Info entityItemRelation;

	/** Ӧ�ù�ϵɾ������ */
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
	/** Ӧ�������������� */
	protected String eiorgname;
	protected IGASM0812Form igasm0812Form;
	
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
	
	
	public IGASM0812Form getIgasm0812Form() {
		return igasm0812Form;
	}

	public void setIgasm0812Form(IGASM0812Form igasm0812Form) {
		this.igasm0812Form = igasm0812Form;
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
	 * Ӧ����Ϣȡ��
	 * @return Ӧ����Ϣ
	 */
	public IGASM0802Form getIgasm0802Form() {
		return igasm0802Form;
	}

	/**
	 * Ӧ����Ϣ�趨
	 *
	 * @param igasm0802Form Ӧ����Ϣ
	 */
	public void setIgasm0802Form(IGASM0802Form igasm0802Form) {
		this.igasm0802Form = igasm0802Form;
	}

	/**
	 * Ӧ����Ϣ��������ȡ��
	 * @return Ӧ����Ϣ��������
	 */
	public SOC0124SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * Ӧ����Ϣ���������趨
	 *
	 * @param entityItemVWSearchCond Ӧ����Ϣ��������
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
	 * Ӧ�ü������ȡ��
	 * @return Ӧ�ü������
	 */
	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * Ӧ�ü�������趨
	 *
	 * @param entityItemVWInfoList Ӧ�ü������
	 */
	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/**
	 * Ӧ��ɾ������ȡ��
	 * @return Ӧ��ɾ������
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * Ӧ��ɾ�������趨
	 *
	 * @param deleteEntityItem Ӧ��ɾ������
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * Ӧ��������Ϣȡ��
	 * @return Ӧ��������Ϣ
	 */
	public IGASM0804Form getIgasm0804Form() {
		return igasm0804Form;
	}


	/**
	 * Ӧ��������Ϣ���������趨
	 *
	 * @param igasm0804Form Ӧ��������Ϣ��������
	 */
	public void setIgasm0804Form(IGASM0804Form igasm0804Form) {
		this.igasm0804Form = igasm0804Form;
	}

	/**
	 * Ӧ��������Ϣ�������ȡ��
	 * @return Ӧ��������Ϣ�������
	 */
	public List<SOC0129Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	/**
	 * Ӧ��������Ϣ��������趨
	 *
	 * @param configItemVWInfoList Ӧ��������Ϣ�������
	 */
	public void setConfigItemVWInfoList(List<SOC0129Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

	/**
	 * Ӧ��������Ϣ����Ӧ����Ϣȡ��
	 * @return Ӧ��������Ϣ����Ӧ����Ϣ
	 */
	public SOC0124Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * Ӧ��������Ϣ����Ӧ����Ϣ�趨
	 *
	 * @param entityItemVWInfo Ӧ��������Ϣ����Ӧ����Ϣ
	 */
	public void setEntityItemVWInfo(SOC0124Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * Ӧ��������Ϣ��ʷ��¼��������ȡ��
	 * @return Ӧ��������Ϣ��ʷ��¼��������
	 */
	public IGASM0805Form getIgasm0805Form() {
		return igasm0805Form;
	}

	/**
	 * Ӧ��������Ϣ��ʷ��¼���������趨
	 *
	 * @param igasm0805Form Ӧ��������Ϣ��ʷ��¼��������
	 */
	public void setIgasm0805Form(IGASM0805Form igasm0805Form) {
		this.igasm0805Form = igasm0805Form;
	}

	/**
	 * Ӧ��������Ϣ��ʷ��¼�������ȡ��
	 * @return Ӧ��������Ϣ��ʷ��¼�������
	 */
	public List<SOC0107Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * Ӧ��������Ϣ��ʷ��¼��������趨
	 *
	 * @param configItemList Ӧ��������Ϣ��ʷ��¼�������
	 */
	public void setConfigItemList(List<SOC0107Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * Ӧ�ù�ϵ�����������ȡ��
	 * @return Ӧ�ù�ϵ�����������
	 */
	public IGASM0806Form getIgasm0806Form() {
		return igasm0806Form;
	}

	/**
	 * Ӧ�ù�ϵ������������趨
	 *
	 * @param igasm0806Form Ӧ�ù�ϵ�����������
	 */
	public void setIgasm0806Form(IGASM0806Form igasm0806Form) {
		this.igasm0806Form = igasm0806Form;
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
	 * @param cldEntityItemRelationList �ʲ����ϵ������Ϣ�������
	 */
	public void setCldEntityItemRelationList(
			List<SOC0119Info> cldEntityItemRelationList) {
		this.cldEntityItemRelationList = cldEntityItemRelationList;
	}

	/**
	 * Ӧ�ù�ϵ�༭��Ϣȡ��
	 * @return �༭��Ϣ
	 */
	public IGASM0807Form getIgasm0807Form() {
		return igasm0807Form;
	}

	/**
	 * Ӧ�ù�ϵ�༭��Ϣ�趨
	 *
	 * @param igasm0807Form Ӧ�ù�ϵ�༭��Ϣ
	 */
	public void setIgasm0807Form(IGASM0807Form igasm0807Form) {
		this.igasm0807Form = igasm0807Form;
	}

	/**
	 * Ӧ�ù�ϵ�༭����Ϣȡ��
	 * @return Ӧ�ù�ϵ�༭����Ϣ
	 */
	public SOC0119Info getEntityItemRelation() {
		return entityItemRelation;
	}

	/**
	 * Ӧ�ù�ϵ�༭����Ϣ�趨
	 *
	 * @param entityItemRelation Ӧ�ù�ϵ�༭����Ϣ
	 */
	public void setEntityItemRelation(SOC0119Info entityItemRelation) {
		this.entityItemRelation = entityItemRelation;
	}

	/**
	 * Ӧ�ù�ϵɾ������ȡ��
	 * @return Ӧ�ù�ϵɾ������
	 */
	public String[] getDeleteEntityItemRelation() {
		return deleteEntityItemRelation;
	}

	/**
	 * Ӧ�ù�ϵɾ�������趨
	 *
	 * @param entityItemRelation Ӧ�ù�ϵɾ������
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
}


