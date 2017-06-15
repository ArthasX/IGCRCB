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
import com.deliverik.infogovernor.asset.form.IGASM2402Form;
import com.deliverik.infogovernor.asset.form.IGASM2404Form;
import com.deliverik.infogovernor.asset.form.IGASM2405Form;
import com.deliverik.infogovernor.asset.form.IGASM2406Form;
import com.deliverik.infogovernor.asset.form.IGASM2407Form;
import com.deliverik.infogovernor.asset.form.IGASM2412Form;

/**
 * ��Ʊ���ù���ҵ����DTO
 * �޸ļ�¼: 2012/11/27 LuJiayuan ���ӱ�ʶ�ж��Ƿ���ʾͼ��ť
 */
@SuppressWarnings("serial")
public class IGASM24DTO extends BaseDTO implements Serializable{

	/** ��Ʊ��Ϣ */
	protected IGASM2402Form igasm2402Form;
	
	/** ��Ʊ��Ϣ�������� */
	protected IG688SearchCond entityItemVWSearchCond;
	
	/** ���������� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;

	/** ��Ʊ������� */
	protected List<IG688Info> entityItemVWInfoList;

	/** ��Ʊɾ������ */
	protected String[] deleteEntityItem;

	/** ��Ʊ������Ϣ */
	protected IGASM2404Form igasm2404Form;
	
	/** ��Ʊ������Ϣ������� */
	protected List<IG002Info> configItemVWInfoList;

	/** ��Ʊ������Ϣ���淢Ʊ��Ϣ */
	protected IG688Info entityItemVWInfo;

	/** ��Ʊ������Ϣ��ʷ��¼�������� */
	protected IGASM2405Form igasm2405Form;
	
	/** ��Ʊ������Ϣ��ʷ��¼������� */
	protected List<IG800Info> configItemList;
	
	/** ��Ʊ��ϵ����������� */
	protected IGASM2406Form igasm2406Form;
	
	/** �ʲ����ϵ������Ϣ�������1 */
	protected List<IG313Info> parEntityItemRelationList;
	
	/** �ʲ����ϵ������Ϣ�������2 */
	protected List<IG313Info> cldEntityItemRelationList;
	
	/** ��Ʊ��ϵ�༭��Ϣ */
	protected IGASM2407Form igasm2407Form;
	
	/** ��Ʊ��ϵ�༭����Ϣ */
	protected IG313Info entityItemRelation;

	/** ��Ʊ��ϵɾ������ */
	protected String[] deleteEntityItemRelation;
	
	/** �ʲ������ϵ�����б� */
	protected List<LabelValueBean> relationList;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<IG800Info>> configItemMap;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<IG002Info>> configItemVWInfoMap;
	
	protected Map<String,List<IG313Info>> parEntityItemRelationMap;
	protected Map<String,List<IG313Info>> cldEntityItemRelationMap;
	protected int parCount;
	protected int cldCount;
	/** ��Ʊ������������ */
	protected String eiorgname;
	protected IGASM2412Form igasm2412Form;
	
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
	protected List<IG887Info> configItemVersionTime;

    private String picuXml;

    private String picsXml;
    
    /** �Ƿ���ʾͼ��ť */
    protected Boolean image_flag;
	
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
	
	
	public IGASM2412Form getIgasm2412Form() {
		return igasm2412Form;
	}

	public void setIgasm2412Form(IGASM2412Form igasm2412Form) {
		this.igasm2412Form = igasm2412Form;
	}
	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
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
	 * ��Ʊ��Ϣȡ��
	 * @return ��Ʊ��Ϣ
	 */
	public IGASM2402Form getIgasm2402Form() {
		return igasm2402Form;
	}

	/**
	 * ��Ʊ��Ϣ�趨
	 *
	 * @param igasm2402Form ��Ʊ��Ϣ
	 */
	public void setIgasm2402Form(IGASM2402Form igasm2402Form) {
		this.igasm2402Form = igasm2402Form;
	}

	/**
	 * ��Ʊ��Ϣ��������ȡ��
	 * @return ��Ʊ��Ϣ��������
	 */
	public IG688SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * ��Ʊ��Ϣ���������趨
	 *
	 * @param entityItemVWSearchCond ��Ʊ��Ϣ��������
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
	 * ��Ʊ�������ȡ��
	 * @return ��Ʊ�������
	 */
	public List<IG688Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * ��Ʊ��������趨
	 *
	 * @param entityItemVWInfoList ��Ʊ�������
	 */
	public void setEntityItemVWInfoList(List<IG688Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/**
	 * ��Ʊɾ������ȡ��
	 * @return ��Ʊɾ������
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * ��Ʊɾ�������趨
	 *
	 * @param deleteEntityItem ��Ʊɾ������
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * ��Ʊ������Ϣȡ��
	 * @return ��Ʊ������Ϣ
	 */
	public IGASM2404Form getIgasm2404Form() {
		return igasm2404Form;
	}


	/**
	 * ��Ʊ������Ϣ���������趨
	 *
	 * @param igasm2404Form ��Ʊ������Ϣ��������
	 */
	public void setIgasm2404Form(IGASM2404Form igasm2404Form) {
		this.igasm2404Form = igasm2404Form;
	}

	/**
	 * ��Ʊ������Ϣ�������ȡ��
	 * @return ��Ʊ������Ϣ�������
	 */
	public List<IG002Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	/**
	 * ��Ʊ������Ϣ��������趨
	 *
	 * @param configItemVWInfoList ��Ʊ������Ϣ�������
	 */
	public void setConfigItemVWInfoList(List<IG002Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

	/**
	 * ��Ʊ������Ϣ���淢Ʊ��Ϣȡ��
	 * @return ��Ʊ������Ϣ���淢Ʊ��Ϣ
	 */
	public IG688Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * ��Ʊ������Ϣ���淢Ʊ��Ϣ�趨
	 *
	 * @param entityItemVWInfo ��Ʊ������Ϣ���淢Ʊ��Ϣ
	 */
	public void setEntityItemVWInfo(IG688Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * ��Ʊ������Ϣ��ʷ��¼��������ȡ��
	 * @return ��Ʊ������Ϣ��ʷ��¼��������
	 */
	public IGASM2405Form getIgasm2405Form() {
		return igasm2405Form;
	}

	/**
	 * ��Ʊ������Ϣ��ʷ��¼���������趨
	 *
	 * @param igasm2405Form ��Ʊ������Ϣ��ʷ��¼��������
	 */
	public void setIgasm2405Form(IGASM2405Form igasm2405Form) {
		this.igasm2405Form = igasm2405Form;
	}

	/**
	 * ��Ʊ������Ϣ��ʷ��¼�������ȡ��
	 * @return ��Ʊ������Ϣ��ʷ��¼�������
	 */
	public List<IG800Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * ��Ʊ������Ϣ��ʷ��¼��������趨
	 *
	 * @param configItemList ��Ʊ������Ϣ��ʷ��¼�������
	 */
	public void setConfigItemList(List<IG800Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * ��Ʊ��ϵ�����������ȡ��
	 * @return ��Ʊ��ϵ�����������
	 */
	public IGASM2406Form getIgasm2406Form() {
		return igasm2406Form;
	}

	/**
	 * ��Ʊ��ϵ������������趨
	 *
	 * @param igasm2406Form ��Ʊ��ϵ�����������
	 */
	public void setIgasm2406Form(IGASM2406Form igasm2406Form) {
		this.igasm2406Form = igasm2406Form;
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
	 * ��Ʊ��ϵ�༭��Ϣȡ��
	 * @return �༭��Ϣ
	 */
	public IGASM2407Form getIgasm2407Form() {
		return igasm2407Form;
	}

	/**
	 * ��Ʊ��ϵ�༭��Ϣ�趨
	 *
	 * @param igasm2407Form ��Ʊ��ϵ�༭��Ϣ
	 */
	public void setIgasm2407Form(IGASM2407Form igasm2407Form) {
		this.igasm2407Form = igasm2407Form;
	}

	/**
	 * ��Ʊ��ϵ�༭����Ϣȡ��
	 * @return ��Ʊ��ϵ�༭����Ϣ
	 */
	public IG313Info getEntityItemRelation() {
		return entityItemRelation;
	}

	/**
	 * ��Ʊ��ϵ�༭����Ϣ�趨
	 *
	 * @param entityItemRelation ��Ʊ��ϵ�༭����Ϣ
	 */
	public void setEntityItemRelation(IG313Info entityItemRelation) {
		this.entityItemRelation = entityItemRelation;
	}

	/**
	 * ��Ʊ��ϵɾ������ȡ��
	 * @return ��Ʊ��ϵɾ������
	 */
	public String[] getDeleteEntityItemRelation() {
		return deleteEntityItemRelation;
	}

	/**
	 * ��Ʊ��ϵɾ�������趨
	 *
	 * @param entityItemRelation ��Ʊ��ϵɾ������
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

    /**
     * @return
     */
    public String getPicsXml() {
        return picsXml;
    }

    /**
     * @return
     */
    public String getPicuXml() {
        // TODO Auto-generated method stub
        return picuXml;
    }

    /**
     * picuXml is set.
     * @param picuXml picuXml
     */
    public void setPicuXml(String picuXml) {
        this.picuXml = picuXml;
    }

    /**
     * picsXml is set.
     * @param picsXml picsXml
     */
    public void setPicsXml(String picsXml) {
        this.picsXml = picsXml;
    }
    
	/**
	 * �Ƿ���ʾͼ��ťȡ��
	 *
	 * @return image_flag �Ƿ���ʾͼ��ť
	 */
	public Boolean getImage_flag() {
		return image_flag;
	}
	
	/**
	 * �Ƿ���ʾͼ��ť�趨
	 *
	 * @param image_flag �Ƿ���ʾͼ��ť
	 */
	public void setImage_flag(Boolean image_flag) {
		this.image_flag = image_flag;
	}
}