package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.model.IG499Info;
import com.deliverik.framework.asset.model.condition.IG499SearchCond;
import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.form.IGASM0402Form;
import com.deliverik.infogovernor.asset.form.IGASM0404Form;
import com.deliverik.infogovernor.asset.form.IGASM0405Form;
import com.deliverik.infogovernor.asset.form.IGASM0406Form;
import com.deliverik.infogovernor.asset.form.IGASM0407Form;
import com.deliverik.infogovernor.asset.form.IGASM0412Form;
import com.deliverik.infogovernor.asset.form.IGASM0421Form;
import com.deliverik.infogovernor.asset.form.IGASM0422Form;


/**
 * 
 * ����: ��ͬ���ù���ҵ����DTO
 * ��������: ��ͬ���ù���ҵ����DTO
 * ������¼: 2012/04/11
 * �޸ļ�¼: 2012/11/26 LuJiayuan ���ӱ�ʶ�ж��Ƿ���ʾͼ��ť
 */
@SuppressWarnings("serial")
public class IGASM04DTO extends BaseDTO implements Serializable{

	/** ��ͬ��Ϣ */
	protected IGASM0402Form igasm0402Form;
	
	/** ��ͬ������Ϣ */
	protected IGASM0422Form igasm0422Form;
	
	/** ��ͬ������Ϣ */
	protected IGASM0421Form igasm0421Form;
	
	/** ��ͬ��Ϣ�������� */
	protected IG688SearchCond entityItemVWSearchCond;
	
	/** ��ͬ��Ϣ�������� */
	protected IG499SearchCond entityItemCompactVWSearchCond;
	
	/** ���������� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;

	/** ��ͬ������� */
	protected List<SOC0124Info> entityItemVWInfoList;

	/** ��ͬ��Ϣ������� */
	protected List<IG499Info> entityItemCompactVWInfoList;
	
	/** ��ͬ��Ϣ������� */
	protected IG499Info entityItemCompactVWInfo;
	
	/** ��ͬɾ������ */
	protected String[] deleteEntityItem;

	/** ��ͬ������Ϣ */
	protected IGASM0404Form igasm0404Form;
	
	/** ��ͬ������Ϣ������� */
	protected List<SOC0129Info> configItemVWInfoList;

	/** ��ͬ������Ϣ�����ͬ��Ϣ */
	protected SOC0124Info entityItemVWInfo;

	/** ��ͬ������Ϣ��ʷ��¼�������� */
	protected IGASM0405Form igasm0405Form;
	
	/** ��ͬ������Ϣ��ʷ��¼������� */
	protected List<SOC0107Info> configItemList;
	
	/** ��ͬ��ϵ����������� */
	protected IGASM0406Form igasm0406Form;
	
	/** �ʲ����ϵ������Ϣ�������1 */
	protected List<SOC0119Info> parEntityItemRelationList;
	
	/** �ʲ����ϵ������Ϣ�������2 */
	protected List<SOC0119Info> cldEntityItemRelationList;
	
	/** ��ͬ��ϵ�༭��Ϣ */
	protected IGASM0407Form igasm0407Form;
	
	/** ��ͬ��ϵ�༭����Ϣ */
	protected SOC0119Info entityItemRelation;
	
	/** �ʲ������ϵ�����б� */
	protected List<LabelValueBean> relationList;

	/** ��ͬ��ϵɾ������ */
	protected String[] deleteEntityItemRelation;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<SOC0129Info>> configItemVWInfoMap;
	
	protected Map<String,List<SOC0119Info>> parEntityItemRelationMap;
	protected Map<String,List<SOC0119Info>> cldEntityItemRelationMap;
	protected int parCount;
	protected int cldCount;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<SOC0107Info>> configItemMap;
	
	/** ��ͬ������������ */
	protected String eiorgname;
	
	/** ��ͬ��Ϣ�޸� */
	protected IGASM0412Form igasm0412Form;
	
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
	
	protected List<LabelValueBean> selectList;
	
	/** ������������  */
	private List<IG499Info> reportDataList;
	
	/** ͼ��ɨ��XML */
	protected String picuXml;
	
	/** ͼ��鿴XML */
	protected String picsXml;

	/** ��ʼ����ͬ�����ʾ�б� */
	protected Map<String,String> dismap;
	
	/** ������ */
	protected String kaihuhang;
	
	/** �����˺� */
	protected String kaihuzhanghao;
	
	/** �������� */
	protected String kaihumingcheng;
	
	protected Boolean image_flag;
	
	public Map<String, String> getDismap() {
		return dismap;
	}

	public void setDismap(Map<String, String> dismap) {
		this.dismap = dismap;
	}

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

	public List<LabelValueBean> getSelectList() {
		return selectList;
	}

	public void setSelectList(List<LabelValueBean> selectList) {
		this.selectList = selectList;
	}

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
	
	public IGASM0412Form getIgasm0412Form() {
		return igasm0412Form;
	}

	public void setIgasm0412Form(IGASM0412Form igasm0412Form) {
		this.igasm0412Form = igasm0412Form;
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
	 * ��ͬ��Ϣȡ��
	 * @return ��ͬ��Ϣ
	 */
	public IGASM0402Form getIgasm0402Form() {
		return igasm0402Form;
	}

	/**
	 * ��ͬ��Ϣ�趨
	 *
	 * @param igasm0402Form ��ͬ��Ϣ
	 */
	public void setIgasm0402Form(IGASM0402Form igasm0402Form) {
		this.igasm0402Form = igasm0402Form;
	}

	/**
	 * ��ͬ��Ϣ��������ȡ��
	 * @return ��ͬ��Ϣ��������
	 */
	public IG688SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * ��ͬ��Ϣ���������趨
	 *
	 * @param entityItemVWSearchCond ��ͬ��Ϣ��������
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
	 * ��ͬ�������ȡ��
	 * @return ��ͬ�������
	 */
	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * ��ͬ��������趨
	 *
	 * @param entityItemVWInfoList ��ͬ�������
	 */
	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/**
	 * ��ͬɾ������ȡ��
	 * @return ��ͬɾ������
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * ��ͬɾ�������趨
	 *
	 * @param deleteEntityItem ��ͬɾ������
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * ��ͬ������Ϣȡ��
	 * @return ��ͬ������Ϣ
	 */
	public IGASM0404Form getIgasm0404Form() {
		return igasm0404Form;
	}


	/**
	 * ��ͬ������Ϣ���������趨
	 *
	 * @param igasm0404Form ��ͬ������Ϣ��������
	 */
	public void setIgasm0404Form(IGASM0404Form igasm0404Form) {
		this.igasm0404Form = igasm0404Form;
	}

	/**
	 * ��ͬ������Ϣ�������ȡ��
	 * @return ��ͬ������Ϣ�������
	 */
	public List<SOC0129Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	/**
	 * ��ͬ������Ϣ��������趨
	 *
	 * @param configItemVWInfoList ��ͬ������Ϣ�������
	 */
	public void setConfigItemVWInfoList(List<SOC0129Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

	/**
	 * ��ͬ������Ϣ�����ͬ��Ϣȡ��
	 * @return ��ͬ������Ϣ�����ͬ��Ϣ
	 */
	public SOC0124Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * ��ͬ������Ϣ�����ͬ��Ϣ�趨
	 *
	 * @param entityItemVWInfo ��ͬ������Ϣ�����ͬ��Ϣ
	 */
	public void setEntityItemVWInfo(SOC0124Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * ��ͬ������Ϣ��ʷ��¼��������ȡ��
	 * @return ��ͬ������Ϣ��ʷ��¼��������
	 */
	public IGASM0405Form getIgasm0405Form() {
		return igasm0405Form;
	}

	/**
	 * ��ͬ������Ϣ��ʷ��¼���������趨
	 *
	 * @param igasm0405Form ��ͬ������Ϣ��ʷ��¼��������
	 */
	public void setIgasm0405Form(IGASM0405Form igasm0405Form) {
		this.igasm0405Form = igasm0405Form;
	}

	/**
	 * ��ͬ������Ϣ��ʷ��¼�������ȡ��
	 * @return ��ͬ������Ϣ��ʷ��¼�������
	 */
	public List<SOC0107Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * ��ͬ������Ϣ��ʷ��¼��������趨
	 *
	 * @param configItemList ��ͬ������Ϣ��ʷ��¼�������
	 */
	public void setConfigItemList(List<SOC0107Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * ��ͬ��ϵ�����������ȡ��
	 * @return ��ͬ��ϵ�����������
	 */
	public IGASM0406Form getIgasm0406Form() {
		return igasm0406Form;
	}

	/**
	 * ��ͬ��ϵ������������趨
	 *
	 * @param igasm0406Form ��ͬ��ϵ�����������
	 */
	public void setIgasm0406Form(IGASM0406Form igasm0406Form) {
		this.igasm0406Form = igasm0406Form;
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
	 * ��ͬ��ϵ�༭��Ϣȡ��
	 * @return �༭��Ϣ
	 */
	public IGASM0407Form getIgasm0407Form() {
		return igasm0407Form;
	}

	/**
	 * ��ͬ��ϵ�༭��Ϣ�趨
	 *
	 * @param igasm0407Form ��ͬ��ϵ�༭��Ϣ
	 */
	public void setIgasm0407Form(IGASM0407Form igasm0407Form) {
		this.igasm0407Form = igasm0407Form;
	}

	/**
	 * ��ͬ��ϵ�༭����Ϣȡ��
	 * @return ��ͬ��ϵ�༭����Ϣ
	 */
	public SOC0119Info getEntityItemRelation() {
		return entityItemRelation;
	}

	/**
	 * ��ͬ��ϵ�༭����Ϣ�趨
	 *
	 * @param entityItemRelation ��ͬ��ϵ�༭����Ϣ
	 */
	public void setEntityItemRelation(SOC0119Info entityItemRelation) {
		this.entityItemRelation = entityItemRelation;
	}

	/**
	 * ��ͬ��ϵɾ������ȡ��
	 * @return ��ͬ��ϵɾ������
	 */
	public String[] getDeleteEntityItemRelation() {
		return deleteEntityItemRelation;
	}

	/**
	 * ��ͬ��ϵɾ�������趨
	 *
	 * @param entityItemRelation ��ͬ��ϵɾ������
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

	public IG499SearchCond getEntityItemCompactVWSearchCond() {
		return entityItemCompactVWSearchCond;
	}

	public void setEntityItemCompactVWSearchCond(
			IG499SearchCond entityItemCompactVWSearchCond) {
		this.entityItemCompactVWSearchCond = entityItemCompactVWSearchCond;
	}

	public List<IG499Info> getEntityItemCompactVWInfoList() {
		return entityItemCompactVWInfoList;
	}

	public void setEntityItemCompactVWInfoList(
			List<IG499Info> entityItemCompactVWInfoList) {
		this.entityItemCompactVWInfoList = entityItemCompactVWInfoList;
	}

	public IGASM0422Form getIgasm0422Form() {
		return igasm0422Form;
	}

	public void setIgasm0422Form(IGASM0422Form igasm0422Form) {
		this.igasm0422Form = igasm0422Form;
	}

	/**
	 * ������������ȡ��
	 *
	 * @return reportDataList ������������
	 */
	public List<IG499Info> getReportDataList() {
		return reportDataList;
	}

	/**
	 * �������������趨
	 *
	 * @param reportDataList ������������
	 */
	public void setReportDataList(List<IG499Info> reportDataList) {
		this.reportDataList = reportDataList;
	}
	
	public IGASM0421Form getIgasm0421Form() {
		return igasm0421Form;
	}

	public void setIgasm0421Form(IGASM0421Form igasm0421Form) {
		this.igasm0421Form = igasm0421Form;
	}

	public IG499Info getEntityItemCompactVWInfo() {
		return entityItemCompactVWInfo;
	}

	public void setEntityItemCompactVWInfo(
			IG499Info entityItemCompactVWInfo) {
		this.entityItemCompactVWInfo = entityItemCompactVWInfo;
	}

	public String getKaihuhang() {
		return kaihuhang;
	}

	public void setKaihuhang(String kaihuhang) {
		this.kaihuhang = kaihuhang;
	}

	public String getKaihuzhanghao() {
		return kaihuzhanghao;
	}

	public void setKaihuzhanghao(String kaihuzhanghao) {
		this.kaihuzhanghao = kaihuzhanghao;
	}

	public String getKaihumingcheng() {
		return kaihumingcheng;
	}

	public void setKaihumingcheng(String kaihumingcheng) {
		this.kaihumingcheng = kaihumingcheng;
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
}


