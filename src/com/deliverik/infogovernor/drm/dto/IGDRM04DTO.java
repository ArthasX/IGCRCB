/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.drm.dto;


import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.model.IG612Info;
import com.deliverik.framework.asset.model.condition.IG545SearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.ConfigurationCodeDetailBean;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0109VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.drm.form.IGDRM0401Form;
import com.deliverik.infogovernor.drm.form.IGDRM0402Form;
import com.deliverik.infogovernor.drm.form.IGDRM0404Form;
import com.deliverik.infogovernor.drm.form.IGDRM0411Form;
import com.deliverik.infogovernor.drm.form.IGDRM0412Form;
import com.deliverik.infogovernor.drm.form.IGDRM0414Form;
import com.deliverik.infogovernor.drm.form.IGDRM0418Form;
import com.deliverik.infogovernor.drm.form.IGDRM0419Form;
import com.deliverik.infogovernor.drm.form.IGDRM0420Form;
import com.deliverik.infogovernor.drm.form.IGDRM0421Form;
import com.deliverik.infogovernor.drm.form.IGDRM0424Form;
import com.deliverik.infogovernor.drm.form.IGDRM0430Form;
import com.deliverik.infogovernor.drm.model.EmergencyResourceInfo;


/**
 * Ӧ����Դ����DTO
 * @author �Ž�
 *
 * 2015-2-11 ����3:27:58
 */
public class IGDRM04DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	/**
	 * */
	protected IGDRM0401Form igdrm0401Form ;
	protected IGDRM0402Form igdrm0402Form ;
	protected IGDRM0404Form igdrm0404Form;
	/** Ӧ����Դ���Բ鿴Form */
	protected IGDRM0430Form igdrm0430Form;
	
	protected Integer eiid;
	protected Integer eiversion;
	protected Integer ciid;
	
	protected int maxSearchCount;

	protected User user;
	
	protected List<SOC0109VWInfo> configurationList;
	
	protected SOC0118VWInfo entityItemInfo;
	
	protected List<SOC0118VWInfo> entityVWItemList;
	
	protected String inJiguiFlg;  //�豸�Ƿ����ϼܱ�־λ
	
	/** ajax���ؽ�� */
	protected String ajaxResult;
	
	/**
	 * @return the igdrm0430Form
	 */
	public IGDRM0430Form getIgdrm0430Form() {
		return igdrm0430Form;
	}


	/**
	 * @param igdrm0430Form the igdrm0430Form to set
	 */
	public void setIgdrm0430Form(IGDRM0430Form igdrm0430Form) {
		this.igdrm0430Form = igdrm0430Form;
	}


	/**
	 * @param entityVWItemList the entityVWItemList to set
	 */
	public void setEntityVWItemList(List<SOC0118VWInfo> entityVWItemList) {
		this.entityVWItemList = entityVWItemList;
	}


	/**
	 * @return the entityVWItemList
	 */
	public List<SOC0118VWInfo> getEntityVWItemList() {
		return entityVWItemList;
	}


	protected List<SOC0118Info> entityItemList;
	
	protected List<SOC0107Info> entityItemConfigurations;
	
	protected SOC0118VWInfo entityItemVW;
	
	protected List<SOC0129Info> configItemList;
	
	protected String eilabel;
	
	protected String rootEsyscoding;
	
	/** ҳ����ʾ��Map */
	protected Hashtable<String, TreeNode> nodeMap;
	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;
	
	protected String eiorgname;
	
	protected boolean flag;
	
	protected Map<String,List<SOC0129Info>> configItemVWInfoMap;
	
	protected String esyscoding;
	
	/** �ʲ��汾�б� */
	protected List<SOC0128Info> configItemVersionTime;
	
	/** Ӧ���ʲ�ɾ������ */
	protected String[] deleteEntityItem;
	
	/** �豸�ʲ���������*/
	protected String area;

	/** �豸������Ϣ�����豸��Ϣ */
	protected SOC0118VWInfo entityItemVWInfo;
	
	/**
	 * @return the entityItemVWInfo
	 */
	public SOC0118VWInfo getEntityItemVWInfo() {
		return entityItemVWInfo;
	}


	/**
	 * @param entityItemVWInfo the entityItemVWInfo to set
	 */
	public void setEntityItemVWInfo(SOC0118VWInfo entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}


	/**
	 * @return the configItemVersionTime
	 */
	public List<SOC0128Info> getConfigItemVersionTime() {
		return configItemVersionTime;
	}


	/**
	 * @param configItemVersionTime the configItemVersionTime to set
	 */
	public void setConfigItemVersionTime(List<SOC0128Info> configItemVersionTime) {
		this.configItemVersionTime = configItemVersionTime;
	}


	/**
	 * @return the inJiguiFlg
	 */
	public String getInJiguiFlg() {
		return inJiguiFlg;
	}


	/**
	 * @param inJiguiFlg the inJiguiFlg to set
	 */
	public void setInJiguiFlg(String inJiguiFlg) {
		this.inJiguiFlg = inJiguiFlg;
	}


	/** �����豸���� */
	protected String[] relationEiid;
	
	
	/**
	 * @return the relationEiid
	 */
	public String[] getRelationEiid() {
		return relationEiid;
	}
	/**
	 * @param relationEiid the relationEiid to set
	 */
	public void setRelationEiid(String[] relationEiid) {
		this.relationEiid = relationEiid;
	}


	/**
	 * Ӧ����Դ
	 */
	protected SOC0124Info soc0124Info;
	
	protected List<SOC0124Info> soc0124List;
	
	protected String ename;
	
	protected String Sp_eiid;
	/**
	 * ��������Map
	 */
	protected  Map<String, List<SOC0129Info>>  soc0129InfoVWMap;
	
	/** ȡֵ��Χ�������� */
	protected Map<Integer, List<LabelValueBean>> selectedListMap = new HashMap<Integer, List<LabelValueBean>>();
	

	/** �豸��Ϣ�������� */
	protected SOC0124SearchCond entityItemVWSearchCond;

	/** �豸������� */
	protected List<SOC0118VWInfo> entityItemVWInfoList;
	
	/**
	 * ȡֵ��Χ��������ȡ��
	 * @return ȡֵ��Χ��������
	 */
	public List<LabelValueBean> getSelectedListMap(int index) {
		return (List<LabelValueBean>) selectedListMap.get( new Integer( index ) );
	}
	/**
	 * ȡֵ��Χ��������ȡ��
	 * @return ȡֵ��Χ��������
	 */
	public Map<Integer, List<LabelValueBean>> getSelectedListMap() {
		return selectedListMap;
	}
	/**
	 * ȡֵ��Χ���������趨
	 *
	 * @param selectedList ȡֵ��Χ��������
	 */
	public void setSelectedListMap(int index,List<LabelValueBean> selectedList) {
		selectedListMap.put(new Integer(index), selectedList);
	}
	/**
	 * pagingDto   ȡ��
	 * @return pagingDto pagingDto
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * pagingDto   �趨
	 * @param pagingDto pagingDto
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * igdrm0401Form   ȡ��
	 * @return igdrm0401Form igdrm0401Form
	 */
	public IGDRM0401Form getIgdrm0401Form() {
		return igdrm0401Form;
	}

	/**
	 * igdrm0401Form   �趨
	 * @param igdrm0401Form igdrm0401Form
	 */
	public void setIgdrm0401Form(IGDRM0401Form igdrm0401Form) {
		this.igdrm0401Form = igdrm0401Form;
	}

	/**
	 * maxSearchCount   ȡ��
	 * @return maxSearchCount maxSearchCount
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * maxSearchCount   �趨
	 * @param maxSearchCount maxSearchCount
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * user   ȡ��
	 * @return user user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * user   �趨
	 * @param user user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * configurationList   ȡ��
	 * @return configurationList configurationList
	 */
	public List<SOC0109VWInfo> getConfigurationList() {
		return configurationList;
	}

	/**
	 * configurationList   �趨
	 * @param configurationList configurationList
	 */
	public void setConfigurationList(List<SOC0109VWInfo> configurationList) {
		this.configurationList = configurationList;
	}

	/**
	 * entityItemInfo   ȡ��
	 * @return entityItemInfo entityItemInfo
	 */
	public SOC0118VWInfo getEntityItemInfo() {
		return entityItemInfo;
	}

	/**
	 * entityItemInfo   �趨
	 * @param entityItemInfo entityItemInfo
	 */
	public void setEntityItemInfo(SOC0118VWInfo entityItemInfo) {
		this.entityItemInfo = entityItemInfo;
	}

	/**
	 * entityItemConfigurations   ȡ��
	 * @return entityItemConfigurations entityItemConfigurations
	 */
	public List<SOC0107Info> getEntityItemConfigurations() {
		return entityItemConfigurations;
	}

	/**
	 * eilabel   ȡ��
	 * @return eilabel eilabel
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * eilabel   �趨
	 * @param eilabel eilabel
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * entityItemConfigurations   �趨
	 * @param entityItemConfigurations entityItemConfigurations
	 */
	public void setEntityItemConfigurations(
			List<SOC0107Info> entityItemConfigurations) {
		this.entityItemConfigurations = entityItemConfigurations;
	}

	/**
	 * igdrm0402Form   ȡ��
	 * @return igdrm0402Form igdrm0402Form
	 */
	public IGDRM0402Form getIgdrm0402Form() {
		return igdrm0402Form;
	}

	/**
	 * igdrm0402Form   �趨
	 * @param igdrm0402Form igdrm0402Form
	 */
	public void setIgdrm0402Form(IGDRM0402Form igdrm0402Form) {
		this.igdrm0402Form = igdrm0402Form;
	}

	/**
	 * entityItemList   ȡ��
	 * @return entityItemList entityItemList
	 */
	public List<SOC0118Info> getEntityItemList() {
		return entityItemList;
	}

	/**
	 * entityItemList   �趨
	 * @param entityItemList entityItemList
	 */
	public void setEntityItemList(List<SOC0118Info> entityItemList) {
		this.entityItemList = entityItemList;
	}

	/**
	 * nodeMap   ȡ��
	 * @return nodeMap nodeMap
	 */
	public Hashtable<String, TreeNode> getNodeMap() {
		return nodeMap;
	}

	/**
	 * nodeMap   �趨
	 * @param nodeMap nodeMap
	 */
	public void setNodeMap(Hashtable<String, TreeNode> nodeMap) {
		this.nodeMap = nodeMap;
	}

	/**
	 * rootEsyscoding   ȡ��
	 * @return rootEsyscoding rootEsyscoding
	 */
	public String getRootEsyscoding() {
		return rootEsyscoding;
	}

	/**
	 * rootEsyscoding   �趨
	 * @param rootEsyscoding rootEsyscoding
	 */
	public void setRootEsyscoding(String rootEsyscoding) {
		this.rootEsyscoding = rootEsyscoding;
	}

	/**
	 * entityItemVW   ȡ��
	 * @return entityItemVW entityItemVW
	 */
	public SOC0118VWInfo getEntityItemVW() {
		return entityItemVW;
	}

	/**
	 * entityItemVW   �趨
	 * @param entityItemVW entityItemVW
	 */
	public void setEntityItemVW(SOC0118VWInfo entityItemVW) {
		this.entityItemVW = entityItemVW;
	}

	/**
	 * configItemList   ȡ��
	 * @return configItemList configItemList
	 */
	public List<SOC0129Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * configItemList   �趨
	 * @param configItemList configItemList
	 */
	public void setConfigItemList(List<SOC0129Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * igdrm0404Form   ȡ��
	 * @return igdrm0404Form igdrm0404Form
	 */
	public IGDRM0404Form getIgdrm0404Form() {
		return igdrm0404Form;
	}

	/**
	 * igdrm0404Form   �趨
	 * @param igdrm0404Form igdrm0404Form
	 */
	public void setIgdrm0404Form(IGDRM0404Form igdrm0404Form) {
		this.igdrm0404Form = igdrm0404Form;
	}

	/**
	 * eiorgname   ȡ��
	 * @return eiorgname eiorgname
	 */
	public String getEiorgname() {
		return eiorgname;
	}

	/**
	 * eiorgname   �趨
	 * @param eiorgname eiorgname
	 */
	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}


	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}


	/**
	 * flag   ȡ��
	 * @return flag flag
	 */
	public boolean getFlag() {
		return flag;
	}

	/**
	 * flag   �趨
	 * @param flag flag
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	/**
	 * configItemVWInfoMap   ȡ��
	 * @return configItemVWInfoMap configItemVWInfoMap
	 */
	public Map<String, List<SOC0129Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}

	/**
	 * configItemVWInfoMap   �趨
	 * @param configItemVWInfoMap configItemVWInfoMap
	 */
	public void setConfigItemVWInfoMap(
			Map<String, List<SOC0129Info>> configItemVWInfoMap) {
		this.configItemVWInfoMap = configItemVWInfoMap;
	}

	/**
	 * esyscoding   ȡ��
	 * @return esyscoding esyscoding
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * esyscoding   �趨
	 * @param esyscoding esyscoding
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * deleteEntityItem   ȡ��
	 * @return deleteEntityItem deleteEntityItem
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * deleteEntityItem   �趨
	 * @param deleteEntityItem deleteEntityItem
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * eiid   ȡ��
	 * @return eiid eiid
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * eiid   �趨
	 * @param eiid eiid
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * eiversion   ȡ��
	 * @return eiversion eiversion
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * eiversion   �趨
	 * @param eiversion eiversion
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * ciid   ȡ��
	 * @return ciid ciid
	 */
	public Integer getCiid() {
		return ciid;
	}

	/**
	 * ciid   �趨
	 * @param ciid ciid
	 */
	public void setCiid(Integer ciid) {
		this.ciid = ciid;
	}
	
	
	//�ʲ�����ά��
	/** �ʲ���Ϣ�������� */
	protected SOC0117SearchCond entitySearchCond;
	
	/** ȡֵ��Χ��Ϣ��������� */
	protected List<SOC0151Info> ccdList;
	
	/** ������Ϣ��������� */
	protected List<Organization> orglist;
	
	/** �û���Ϣ��������� */
	protected List<User> userlist;

	/** �ʲ�һ��������Ϣ��������� */
	protected List<SOC0117Info> topEntityList;
	
	/** �ʲ���Ϣ��������� */
	protected List<SOC0117Info> entityList;

	/** �Ǽ��ʲ���Ϣ */
	protected SOC0117Info entity;

	/** �Ǽ��ʲ�������Ϣ */
	protected SOC0109Info configuration;

	/** �ʲ�������Ϣ�������� */
	protected SOC0109SearchCond configurationSearchCond;
	
	/** �ʲ�������Ϣ��������� */
	Map<String,List<SOC0109Info>> configurationMap;
	
	/** �ʲ���Ϣɾ������ */
	protected String[] deleteEntity;

	/** �ʲ�������Ϣɾ������ */
	protected String[] deleteConfiguration;
	
	/** ������ʲ�������Ϣ */
	protected IGDRM0414Form igdrm0414Form;
	/** ������ʲ�������Ϣ */
	protected IGDRM0412Form igdrm0412Form;
	
	protected IGDRM0420Form igdrm0420Form;
	
	protected IGDRM0421Form igdrm0421Form;
	
	protected IGDRM0419Form igdrm0419Form;
	
	/** ��ѯ���ʲ�������Ϣ */
	protected IGDRM0411Form igdrm0411Form;
	
	/** �ʲ�����״̬ 1���� 0ͣ�� */
	protected String estatus;

	/** �ʲ��������ݱ�ʶ�б� */
	protected List<ConfigurationCodeDetailBean> configurationCodeDetailBeanList;
	
	protected List<SOC0151Info> ConfigurationCodeDetailList;
	
	/** �ʲ�����Ĭ��ֵ�༭Form */
	protected IGDRM0424Form igDRM0424Form;
	
	/** �ʲ�������Ϣ��������� */
	protected List<Map<String,List<SOC0109Info>>> configurationMapList;
	
	/** �ʲ�����Ĭ��ֵ���� */
	protected Map<String,List<IG612Info>> map_IG612Info;
	
	protected String strflag;
	
	/** Ӧ����Դ��Ϣ��������� */
	protected List<EmergencyResourceInfo> erEntityList;
	 

	/** �ʲ��������ݻ�����Ϣ */
	protected IGDRM0418Form igdrm0418Form;
	
	/** �ʲ�����������Ϣ */
	protected SOC0151Info configurationcodedetail;
	
	/** �ʲ�����������Ϣ */
	protected IG545SearchCond configurationcodedetailsearchcond;
	/**
	 * ÿ�������Ƿ���ʾͣ�ð�ť
	 */
	
	protected  Map<String,String> stopbuttonMap;
	
	/**
	 * ÿ�������Ƿ���ʾ���ð�ť
	 */
	
	protected  Map<String,String> startbuttonMap;
	
	/** �ʲ���������״̬ 1���� 2ͣ�� */
	protected String cstatus;
	
	/** �ʲ���������id */
	protected String cid;

	/**
	 * @return the soc0124Info
	 */
	public SOC0124Info getSoc0124Info() {
		return soc0124Info;
	}


	/**
	 * @param soc0124Info the soc0124Info to set
	 */
	public void setSoc0124Info(SOC0124Info soc0124Info) {
		this.soc0124Info = soc0124Info;
	}


	/**
	 * @return the soc0124List
	 */
	public List<SOC0124Info> getSoc0124List() {
		return soc0124List;
	}


	/**
	 * @param soc0124List the soc0124List to set
	 */
	public void setSoc0124List(List<SOC0124Info> soc0124List) {
		this.soc0124List = soc0124List;
	}


	/**
	 * @return the ename
	 */
	public String getEname() {
		return ename;
	}


	/**
	 * @param ename the ename to set
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}


	/**
	 * @return the sp_eiid
	 */
	public String getSp_eiid() {
		return Sp_eiid;
	}


	/**
	 * @param sp_eiid the sp_eiid to set
	 */
	public void setSp_eiid(String sp_eiid) {
		Sp_eiid = sp_eiid;
	}


	/**
	 * @return the soc0129InfoVWMap
	 */
	public Map<String, List<SOC0129Info>> getSoc0129InfoVWMap() {
		return soc0129InfoVWMap;
	}


	/**
	 * @param soc0129InfoVWMap the soc0129InfoVWMap to set
	 */
	public void setSoc0129InfoVWMap(Map<String, List<SOC0129Info>> soc0129InfoVWMap) {
		this.soc0129InfoVWMap = soc0129InfoVWMap;
	}


	/**
	 * @return the entityItemVWSearchCond
	 */
	public SOC0124SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}


	/**
	 * @param entityItemVWSearchCond the entityItemVWSearchCond to set
	 */
	public void setEntityItemVWSearchCond(SOC0124SearchCond entityItemVWSearchCond) {
		this.entityItemVWSearchCond = entityItemVWSearchCond;
	}


	/**
	 * @return the entityItemVWInfoList
	 */
	public List<SOC0118VWInfo> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}


	/**
	 * @param entityItemVWInfoList the entityItemVWInfoList to set
	 */
	public void setEntityItemVWInfoList(List<SOC0118VWInfo> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}


	/**
	 * @return the entitySearchCond
	 */
	public SOC0117SearchCond getEntitySearchCond() {
		return entitySearchCond;
	}


	/**
	 * @param entitySearchCond the entitySearchCond to set
	 */
	public void setEntitySearchCond(SOC0117SearchCond entitySearchCond) {
		this.entitySearchCond = entitySearchCond;
	}


	/**
	 * @return the ccdList
	 */
	public List<SOC0151Info> getCcdList() {
		return ccdList;
	}


	/**
	 * @param ccdList the ccdList to set
	 */
	public void setCcdList(List<SOC0151Info> ccdList) {
		this.ccdList = ccdList;
	}


	/**
	 * @return the orglist
	 */
	public List<Organization> getOrglist() {
		return orglist;
	}


	/**
	 * @param orglist the orglist to set
	 */
	public void setOrglist(List<Organization> orglist) {
		this.orglist = orglist;
	}


	/**
	 * @return the userlist
	 */
	public List<User> getUserlist() {
		return userlist;
	}


	/**
	 * @param userlist the userlist to set
	 */
	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}


	/**
	 * @return the topEntityList
	 */
	public List<SOC0117Info> getTopEntityList() {
		return topEntityList;
	}


	/**
	 * @param topEntityList the topEntityList to set
	 */
	public void setTopEntityList(List<SOC0117Info> topEntityList) {
		this.topEntityList = topEntityList;
	}


	/**
	 * @return the entityList
	 */
	public List<SOC0117Info> getEntityList() {
		return entityList;
	}


	/**
	 * @param entityList the entityList to set
	 */
	public void setEntityList(List<SOC0117Info> entityList) {
		this.entityList = entityList;
	}


	/**
	 * @return the entity
	 */
	public SOC0117Info getEntity() {
		return entity;
	}


	/**
	 * @param entity the entity to set
	 */
	public void setEntity(SOC0117Info entity) {
		this.entity = entity;
	}


	/**
	 * @return the configuration
	 */
	public SOC0109Info getConfiguration() {
		return configuration;
	}


	/**
	 * @param configuration the configuration to set
	 */
	public void setConfiguration(SOC0109Info configuration) {
		this.configuration = configuration;
	}


	/**
	 * @return the configurationSearchCond
	 */
	public SOC0109SearchCond getConfigurationSearchCond() {
		return configurationSearchCond;
	}


	/**
	 * @param configurationSearchCond the configurationSearchCond to set
	 */
	public void setConfigurationSearchCond(SOC0109SearchCond configurationSearchCond) {
		this.configurationSearchCond = configurationSearchCond;
	}


	/**
	 * @return the configurationMap
	 */
	public Map<String, List<SOC0109Info>> getConfigurationMap() {
		return configurationMap;
	}


	/**
	 * @param configurationMap the configurationMap to set
	 */
	public void setConfigurationMap(Map<String, List<SOC0109Info>> configurationMap) {
		this.configurationMap = configurationMap;
	}


	/**
	 * @return the deleteEntity
	 */
	public String[] getDeleteEntity() {
		return deleteEntity;
	}


	/**
	 * @param deleteEntity the deleteEntity to set
	 */
	public void setDeleteEntity(String[] deleteEntity) {
		this.deleteEntity = deleteEntity;
	}


	/**
	 * @return the deleteConfiguration
	 */
	public String[] getDeleteConfiguration() {
		return deleteConfiguration;
	}


	/**
	 * @param deleteConfiguration the deleteConfiguration to set
	 */
	public void setDeleteConfiguration(String[] deleteConfiguration) {
		this.deleteConfiguration = deleteConfiguration;
	}


	/**
	 * @return the igdrm0414Form
	 */
	public IGDRM0414Form getIgdrm0414Form() {
		return igdrm0414Form;
	}


	/**
	 * @param igdrm0414Form the igdrm0414Form to set
	 */
	public void setIgdrm0414Form(IGDRM0414Form igdrm0414Form) {
		this.igdrm0414Form = igdrm0414Form;
	}


	/**
	 * @return the igdrm0412Form
	 */
	public IGDRM0412Form getIgdrm0412Form() {
		return igdrm0412Form;
	}


	/**
	 * @param igdrm0412Form the igdrm0412Form to set
	 */
	public void setIgdrm0412Form(IGDRM0412Form igdrm0412Form) {
		this.igdrm0412Form = igdrm0412Form;
	}


	/**
	 * @return the igdrm0420Form
	 */
	public IGDRM0420Form getIgdrm0420Form() {
		return igdrm0420Form;
	}


	/**
	 * @param igdrm0420Form the igdrm0420Form to set
	 */
	public void setIgdrm0420Form(IGDRM0420Form igdrm0420Form) {
		this.igdrm0420Form = igdrm0420Form;
	}


	/**
	 * @return the igdrm0421Form
	 */
	public IGDRM0421Form getIgdrm0421Form() {
		return igdrm0421Form;
	}


	/**
	 * @param igdrm0421Form the igdrm0421Form to set
	 */
	public void setIgdrm0421Form(IGDRM0421Form igdrm0421Form) {
		this.igdrm0421Form = igdrm0421Form;
	}


	/**
	 * @return the igdrm0419Form
	 */
	public IGDRM0419Form getIgdrm0419Form() {
		return igdrm0419Form;
	}


	/**
	 * @param igdrm0419Form the igdrm0419Form to set
	 */
	public void setIgdrm0419Form(IGDRM0419Form igdrm0419Form) {
		this.igdrm0419Form = igdrm0419Form;
	}


	/**
	 * @return the igdrm0411Form
	 */
	public IGDRM0411Form getIgdrm0411Form() {
		return igdrm0411Form;
	}


	/**
	 * @param igdrm0411Form the igdrm0411Form to set
	 */
	public void setIgdrm0411Form(IGDRM0411Form igdrm0411Form) {
		this.igdrm0411Form = igdrm0411Form;
	}


	/**
	 * @return the estatus
	 */
	public String getEstatus() {
		return estatus;
	}


	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}


	/**
	 * @return the configurationCodeDetailBeanList
	 */
	public List<ConfigurationCodeDetailBean> getConfigurationCodeDetailBeanList() {
		return configurationCodeDetailBeanList;
	}


	/**
	 * @param configurationCodeDetailBeanList the configurationCodeDetailBeanList to set
	 */
	public void setConfigurationCodeDetailBeanList(
			List<ConfigurationCodeDetailBean> configurationCodeDetailBeanList) {
		this.configurationCodeDetailBeanList = configurationCodeDetailBeanList;
	}


	/**
	 * @return the configurationCodeDetailList
	 */
	public List<SOC0151Info> getConfigurationCodeDetailList() {
		return ConfigurationCodeDetailList;
	}


	/**
	 * @param configurationCodeDetailList the configurationCodeDetailList to set
	 */
	public void setConfigurationCodeDetailList(
			List<SOC0151Info> configurationCodeDetailList) {
		ConfigurationCodeDetailList = configurationCodeDetailList;
	}


	/**
	 * @return the igDRM0424Form
	 */
	public IGDRM0424Form getIgDRM0424Form() {
		return igDRM0424Form;
	}


	/**
	 * @param igDRM0424Form the igDRM0424Form to set
	 */
	public void setIgDRM0424Form(IGDRM0424Form igDRM0424Form) {
		this.igDRM0424Form = igDRM0424Form;
	}


	/**
	 * @return the configurationMapList
	 */
	public List<Map<String, List<SOC0109Info>>> getConfigurationMapList() {
		return configurationMapList;
	}


	/**
	 * @param configurationMapList the configurationMapList to set
	 */
	public void setConfigurationMapList(
			List<Map<String, List<SOC0109Info>>> configurationMapList) {
		this.configurationMapList = configurationMapList;
	}


	/**
	 * @return the map_IG612Info
	 */
	public Map<String, List<IG612Info>> getMap_IG612Info() {
		return map_IG612Info;
	}


	/**
	 * @param map_IG612Info the map_IG612Info to set
	 */
	public void setMap_IG612Info(Map<String, List<IG612Info>> map_IG612Info) {
		this.map_IG612Info = map_IG612Info;
	}


	/**
	 * @return the strflag
	 */
	public String getStrflag() {
		return strflag;
	}


	/**
	 * @param strflag the strflag to set
	 */
	public void setStrflag(String strflag) {
		this.strflag = strflag;
	}


	/**
	 * @return the erEntityList
	 */
	public List<EmergencyResourceInfo> getErEntityList() {
		return erEntityList;
	}


	/**
	 * @param erEntityList the erEntityList to set
	 */
	public void setErEntityList(List<EmergencyResourceInfo> erEntityList) {
		this.erEntityList = erEntityList;
	}


	/**
	 * @return the igdrm0418Form
	 */
	public IGDRM0418Form getIgdrm0418Form() {
		return igdrm0418Form;
	}


	/**
	 * @param igdrm0418Form the igdrm0418Form to set
	 */
	public void setIgdrm0418Form(IGDRM0418Form igdrm0418Form) {
		this.igdrm0418Form = igdrm0418Form;
	}


	/**
	 * @return the configurationcodedetail
	 */
	public SOC0151Info getConfigurationcodedetail() {
		return configurationcodedetail;
	}


	/**
	 * @param configurationcodedetail the configurationcodedetail to set
	 */
	public void setConfigurationcodedetail(SOC0151Info configurationcodedetail) {
		this.configurationcodedetail = configurationcodedetail;
	}


	/**
	 * @return the configurationcodedetailsearchcond
	 */
	public IG545SearchCond getConfigurationcodedetailsearchcond() {
		return configurationcodedetailsearchcond;
	}


	/**
	 * @param configurationcodedetailsearchcond the configurationcodedetailsearchcond to set
	 */
	public void setConfigurationcodedetailsearchcond(
			IG545SearchCond configurationcodedetailsearchcond) {
		this.configurationcodedetailsearchcond = configurationcodedetailsearchcond;
	}


	/**
	 * @return the stopbuttonMap
	 */
	public Map<String, String> getStopbuttonMap() {
		return stopbuttonMap;
	}


	/**
	 * @param stopbuttonMap the stopbuttonMap to set
	 */
	public void setStopbuttonMap(Map<String, String> stopbuttonMap) {
		this.stopbuttonMap = stopbuttonMap;
	}


	/**
	 * @return the startbuttonMap
	 */
	public Map<String, String> getStartbuttonMap() {
		return startbuttonMap;
	}


	/**
	 * @param startbuttonMap the startbuttonMap to set
	 */
	public void setStartbuttonMap(Map<String, String> startbuttonMap) {
		this.startbuttonMap = startbuttonMap;
	}


	/**
	 * @return the cstatus
	 */
	public String getCstatus() {
		return cstatus;
	}


	/**
	 * @param cstatus the cstatus to set
	 */
	public void setCstatus(String cstatus) {
		this.cstatus = cstatus;
	}


	/**
	 * @return the cid
	 */
	public String getCid() {
		return cid;
	}


	/**
	 * @param cid the cid to set
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}


	/**
	 * @param selectedListMap the selectedListMap to set
	 */
	public void setSelectedListMap(
			Map<Integer, List<LabelValueBean>> selectedListMap) {
		this.selectedListMap = selectedListMap;
	}


	/**
	 * ajax���ؽ��ȡ��
	 * @return ajaxResult ajax���ؽ��
	 */
	public String getAjaxResult() {
		return ajaxResult;
	}


	/**
	 * ajax���ؽ���趨
	 * @param ajaxResult ajax���ؽ��
	 */
	public void setAjaxResult(String ajaxResult) {
		this.ajaxResult = ajaxResult;
	}

}