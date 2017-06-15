package com.deliverik.infogovernor.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.IG117Info;
import com.deliverik.framework.asset.model.IG313Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.IG800Info;
import com.deliverik.framework.asset.model.condition.IG013SearchCond;
import com.deliverik.framework.asset.model.condition.IG117SearchCond;
import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.asset.model.condition.IG800SearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.soc.asset.SOC0130Info;
import com.deliverik.framework.soc.asset.SOC0131Info;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.SOC0132VW;
import com.deliverik.framework.soc.asset.model.SOC0133VW;
import com.deliverik.framework.soc.asset.model.SOC0139VW;
import com.deliverik.framework.soc.asset.model.SOC0605Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0121SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.form.IGCOM0303Form;
import com.deliverik.infogovernor.form.IGCOM0304Form;
import com.deliverik.infogovernor.form.IGCOM0305Form;
import com.deliverik.infogovernor.form.IGCOM0307Form;
import com.deliverik.infogovernor.form.IGCOM0308Form;
import com.deliverik.infogovernor.form.IGCOM0314Form;
import com.deliverik.infogovernor.form.IGCOM0318Form;
import com.deliverik.infogovernor.form.IGCOM0319Form;
import com.deliverik.infogovernor.form.IGCOM0320Form;
import com.deliverik.infogovernor.form.IGCOM0321Form;
import com.deliverik.infogovernor.form.IGCOM0322Form;
import com.deliverik.infogovernor.form.IGCOM0324Form;
import com.deliverik.infogovernor.form.IGCOM0328Form;
import com.deliverik.infogovernor.form.IGCOM0329Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0147Form;

/**
 * ��ѯHELPҵ����DTO
 * 
 */
@SuppressWarnings("serial")
public class IGCOM03DTO extends BaseDTO implements Serializable{
	
	protected SOC0121SearchCond snapshotRelationSearchCond;

	protected IG117SearchCond entitySearchCond;
	
	protected IG013SearchCond entityItemSearchCond;
	
	protected IG800SearchCond configItemSearchCond;

	protected List<IG117Info> entityList;
	
	/** �豸��ϵ��FS-LV-VG�� */
	protected List<SOC0130Info> fsLvVgInfoList;
	
	/** �豸��ϵ��VG-PV-META�� */
	protected List<SOC0131Info> vgPvMetaInfoList;
	
	/** �豸������������ */
	protected String eiorgname;
	
	/** �ʲ���id */
	protected Integer eiid;
	
	/** �ʲ�ģ������ */
	protected String ename;
	
	/** �ʲ�ģ�Ͳ���� */
	protected String esyscoding;

	protected int maxSearchCount;

	protected PagingDTO pagingDto;

	/** �ʲ�����Ϣ�������� */
	protected IG688SearchCond entityItemVWSearchCond;
	/** �ʲ�����Ϣ�������� */
	protected SOC0124SearchCond soc0214SearchCond;
	
	/** �ʲ��������� */
	protected List<IG688Info> entityItemVWInfoList;
	
	/** �ʲ��������� */
	protected List<SOC0124Info> soc0124List;

	/** ������ϸ��Ϣ�ü������� */
	protected IGCOM0303Form igcom0303Form;
	
	/** ������ϸ��Ϣ�ü������� */
	protected IGCOM0328Form igcom0328Form;
	
	/** ������ϸ��Ϣ�ü������� */
	protected IGCOM0318Form igcom0318Form;
	
	/** ������ϸ��Ϣ�ü������� */
	protected IGCOM0319Form igcom0319Form;
	
	/** ������ϸ��Ϣ�ü������� */
	protected IGCOM0320Form igcom0320Form;
	
	/** ������ϸ��Ϣ�ü������� */
	protected IGCOM0322Form igcom0322Form;
		
	/** ������Ϣ������� */
	protected List<SOC0107Info> configItemList;

	/** ��������Ϣ */
	protected IG688Info entityItemVWInfo;

	/** ������ϸ��Ϣ�ü������� */
	protected IGCOM0304Form igcom0304Form;
	
	/** ������ϸ��Ϣ��������� */
	protected List<CodeDetail> codeDetailList;
	
	/** ���ݷ�����Ϣ��������� */
	protected List<LabelValueBean> codeCategorylList;
	
	/** �ʲ����ϵ������Ϣ�������1 */
	protected Map<String,List<IG313Info>> parEntityItemRelationMap;
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<IG002Info>> configItemVWInfoMap;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<IG800Info>> configItemMap;
	
	/** �ʲ���������Ϣ�������(SOC) */
	protected Map<String,Map<String,List<IG002Info>>> configInfoMap;
	
	private Map<String,String> configItem;
	
	/** �ʲ���Ϣ */
	protected IG013Info entityItem;
	
	/** �û����� */
	private User user;
	
	/** Ȩ�ޱ�ʶ */
	protected Boolean flag;
	
	/** �ʲ���������Ϣ�汾�Ƚ���ʾ����FORM */
	protected IGCOM0307Form igcom0307Form;
	
	/** �ʲ���ϵͼFORM */
	protected IGCOM0305Form igcom0305Form;
	
	/** ������Ϣ��ʷ��¼����FORM */
	protected IGCOM0308Form igcom0308Form;
	
	protected Map<String,List<IG002Info>> emap;
	
	protected Map<String,List<String>> cname_map;
	
	protected Map<String,List<String>> einame_map;
	
	protected String srname;
	
	protected List<String> namelist;
	
	protected Map<String,Map<String,String>> eimap;
	
	/** ����ͼFORM */
	protected IGCOM0314Form igcom0314Form;
	
	/** Ӱ�����ͼFORM */
	protected IGCOM0321Form igcom0321Form;
	
	/** ������ͼFORM */
	protected IGCOM0324Form igcom0324Form;
	
	/** ��ϵͼXML */
	protected String graphXml;
	
	/** ��ѡEIID */
	protected String selEiid;
	
	/** �洢ͼ�õ�XML*/
	private String strXml;
	
	private String storageEiname;
	
	/**����������*/
	private SOC0139VW switchConfigItem;
	
	/**�˿�����*/
	private List<SOC0132VW> portList;
	
	/**Zone����*/
    private List<SOC0133VW> zoneList;
    
    private SOC0118Info soc0118Info;
    
    private SOC0124Info soc0124Info;
    
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<SOC0129Info>> soc0129InfoVWMap;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<SOC0107Info>> soc0107InfoMap;
	
	private IGCIM0147Form igcim0147Form;
    
	/** �ʲ��汾�б� */
	protected List<SOC0128Info> configItemVersionTime;
	
	protected IGCOM0329Form igcom0329Form;
	
	protected List<LabelValueBean> esyscodingList;
	
	protected List<SOC0118Info> entityItemList;
	

	public List<LabelValueBean> getEsyscodingList() {
		return esyscodingList;
	}

	public void setEsyscodingList(List<LabelValueBean> esyscodingList) {
		this.esyscodingList = esyscodingList;
	}

	public IGCOM0329Form getIgcom0329Form() {
		return igcom0329Form;
	}

	public void setIgcom0329Form(IGCOM0329Form igcom0329Form) {
		this.igcom0329Form = igcom0329Form;
	}

	public Map<String, List<SOC0129Info>> getSoc0129InfoVWMap() {
		return soc0129InfoVWMap;
	}

	public void setSoc0129InfoVWMap(Map<String, List<SOC0129Info>> soc0129InfoVWMap) {
		this.soc0129InfoVWMap = soc0129InfoVWMap;
	}

	public SOC0124Info getSoc0124Info() {
		return soc0124Info;
	}

	public void setSoc0124Info(SOC0124Info soc0124Info) {
		this.soc0124Info = soc0124Info;
	}

	public SOC0118Info getSoc0118Info() {
		return soc0118Info;
	}

	public void setSoc0118Info(SOC0118Info soc0118Info) {
		this.soc0118Info = soc0118Info;
	}

	public Map<String, Map<String, String>> getEimap() {
		return eimap;
	}

	public void setEimap(Map<String, Map<String, String>> eimap) {
		this.eimap = eimap;
	}

	public List<String> getNamelist() {
		return namelist;
	}

	public void setNamelist(List<String> namelist) {
		this.namelist = namelist;
	}

	public String getSrname() {
		return srname;
	}

	public void setSrname(String srname) {
		this.srname = srname;
	}

	public Map<String, List<String>> getEiname_map() {
		return einame_map;
	}

	public void setEiname_map(Map<String, List<String>> einame_map) {
		this.einame_map = einame_map;
	}

	public Map<String, List<String>> getCname_map() {
		return cname_map;
	}

	public void setCname_map(Map<String, List<String>> cname_map) {
		this.cname_map = cname_map;
	}

	public Map<String, List<IG002Info>> getEmap() {
		return emap;
	}

	public void setEmap(Map<String, List<IG002Info>> emap) {
		this.emap = emap;
	}

	public IG013Info getEntityItem() {
		return entityItem;
	}

	public void setEntityItem(IG013Info entityItem) {
		this.entityItem = entityItem;
	}

	public Map<String, Map<String, List<IG002Info>>> getConfigInfoMap() {
		return configInfoMap;
	}

	public void setConfigInfoMap(
			Map<String, Map<String, List<IG002Info>>> configInfoMap) {
		this.configInfoMap = configInfoMap;
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
	
	
	public Map<String, List<IG002Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}

	public void setConfigItemVWInfoMap(
			Map<String, List<IG002Info>> configItemVWInfoMap) {
		this.configItemVWInfoMap = configItemVWInfoMap;
	}

	public Map<String, List<IG800Info>> getConfigItemMap() {
		return configItemMap;
	}

	public void setConfigItemMap(Map<String, List<IG800Info>> configItemMap) {
		this.configItemMap = configItemMap;
	}

	/**
	 * 
	 * @return 
	 */
	public IG117SearchCond getEntitySearchCond() {
	    return this.entitySearchCond;
	}

	/**
	 * 
	 * @param
	 */
	public void setEntitySearchCond(IG117SearchCond entitySearchCond) {
	    this.entitySearchCond = entitySearchCond;
	}

	public List<IG117Info> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<IG117Info> entityList) {
		this.entityList = entityList;
	}

	/**
	 * 
	 * @return maxSearchCount
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}


	/**
	 * 
	 * @return pagingDto
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 
	 * @param maxSearchCount
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 
	 * @param pagingDto
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * �ʲ�����Ϣ��������ȡ��
	 * @return �ʲ�����Ϣ��������
	 */
	public IG688SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * �ʲ�����Ϣ���������趨
	 *
	 * @param entityItemVWSearchCond �ʲ�����Ϣ��������
	 */
	public void setEntityItemVWSearchCond(
			IG688SearchCond entityItemVWSearchCond) {
		this.entityItemVWSearchCond = entityItemVWSearchCond;
	}

	/**
	 * �ʲ���������ȡ��
	 * @return �ʲ���������
	 */
	public List<IG688Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * �ʲ����������趨
	 *
	 * @param entityItemVWInfoList �ʲ���������
	 */
	public void setEntityItemVWInfoList(List<IG688Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/**
	 * ������ϸ��Ϣ�ü�������ȡ��
	 * @return ������ϸ��Ϣ�ü�������
	 */
	public IGCOM0303Form getIgcom0303Form() {
		return igcom0303Form;
	}

	/**
	 * ������ϸ��Ϣ�ü��������趨
	 *
	 * @param igcom0303Form ������ϸ��Ϣ�ü�������
	 */
	public void setIgcom0303Form(IGCOM0303Form igcom0303Form) {
		this.igcom0303Form = igcom0303Form;
	}

	/**
	 * ��������Ϣȡ��
	 * @return ��������Ϣ
	 */
	public IG688Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * ��������Ϣ�趨
	 *
	 * @param entityItemVWInfo ��������Ϣ
	 */
	public void setEntityItemVWInfo(IG688Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * ������Ϣ�������ȡ��
	 * @return ������Ϣ�������
	 */
	public List<SOC0107Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * ������Ϣ��������趨
	 *
	 * @param configItemList ������Ϣ�������
	 */
	public void setConfigItemList(List<SOC0107Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * ������ϸ��Ϣ�ü�������ȡ��
	 * @return ������ϸ��Ϣ�ü�������
	 */
	public IGCOM0304Form getIgcom0304Form() {
		return igcom0304Form;
	}

	/**
	 * ������ϸ��Ϣ�ü��������趨
	 *
	 * @param igcom0304Form ������ϸ��Ϣ�ü�������
	 */
	public void setIgcom0304Form(IGCOM0304Form igcom0304Form) {
		this.igcom0304Form = igcom0304Form;
	}

	/**
	 * ������ϸ��Ϣ���������ȡ��
	 * @return ������ϸ��Ϣ���������
	 */
	public List<CodeDetail> getCodeDetailList() {
		return codeDetailList;
	}

	/**
	 * ������ϸ��Ϣ����������趨
	 *
	 * @param codeDetailList ������ϸ��Ϣ���������
	 */
	public void setCodeDetailList(List<CodeDetail> codeDetailList) {
		this.codeDetailList = codeDetailList;
	}

	/**
	 * ���ݷ�����Ϣ���������ȡ��
	 * @return ���ݷ�����Ϣ���������
	 */
	public List<LabelValueBean> getCodeCategorylList() {
		return codeCategorylList;
	}

	/**
	 * ���ݷ�����Ϣ����������趨
	 *
	 * @param codeCategorylList ���ݷ�����Ϣ���������
	 */
	public void setCodeCategorylList(List<LabelValueBean> codeCategorylList) {
		this.codeCategorylList = codeCategorylList;
	}

	/**
	 * �ʲ���idȡ��
	 * @return �ʲ���id
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * �ʲ���id�趨
	 *
	 * @param eiid �ʲ���id
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
	
	/**
	 * �ʲ����ϵ������Ϣ�������1ȡ��
	 * @return �ʲ����ϵ������Ϣ�������1
	 */
	public Map<String, List<IG313Info>> getParEntityItemRelationMap() {
		return parEntityItemRelationMap;
	}

	/**
	 * �ʲ����ϵ������Ϣ�������1�趨
	 *
	 * @param username �ʲ����ϵ������Ϣ�������1
	 */
	public void setParEntityItemRelationMap(
			Map<String, List<IG313Info>> parEntityItemRelationMap) {
		this.parEntityItemRelationMap = parEntityItemRelationMap;
	}

	/**
	 * �ʲ�ģ������ȡ��
	 * @return �ʲ�ģ������
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * �ʲ�ģ�������趨
	 *
	 * @param eiid �ʲ�ģ������
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * �ʲ�ģ�Ͳ����ȡ��
	 * @return �ʲ�ģ�Ͳ����
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * �ʲ�ģ�Ͳ�����趨
	 *
	 * @param eiid �ʲ�ģ�Ͳ����
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * �ʲ���������Ϣ�汾�Ƚ���ʾ����FORMȡ��
	 * @return �ʲ���������Ϣ�汾�Ƚ���ʾ����FORM
	 */
	public IGCOM0307Form getIgcom0307Form() {
		return igcom0307Form;
	}

	/**
	 * �ʲ���������Ϣ�汾�Ƚ���ʾ����FORM�趨
	 *
	 * @param igcom0307Form �ʲ���������Ϣ�汾�Ƚ���ʾ����FORM
	 */
	public void setIgcom0307Form(IGCOM0307Form igcom0307Form) {
		this.igcom0307Form = igcom0307Form;
	}

	/**
	 * �ʲ���ϵͼFORMȡ��
	 * @return �ʲ���ϵͼFORM
	 */
	public IGCOM0305Form getIgcom0305Form() {
		return igcom0305Form;
	}

	/**
	 * �ʲ���ϵͼFORM�趨
	 *
	 * @param igcom0305Form �ʲ���ϵͼFORM
	 */
	public void setIgcom0305Form(IGCOM0305Form igcom0305Form) {
		this.igcom0305Form = igcom0305Form;
	}

	/**
	 * ������Ϣ��ʷ��¼����FORMȡ��
	 * @return ������Ϣ��ʷ��¼����FORM
	 */
	public IGCOM0308Form getIgcom0308Form() {
		return igcom0308Form;
	}

	/**
	 * ������Ϣ��ʷ��¼����FORM�趨
	 *
	 * @param igcom0308Form ������Ϣ��ʷ��¼����FORM
	 */
	public void setIgcom0308Form(IGCOM0308Form igcom0308Form) {
		this.igcom0308Form = igcom0308Form;
	}

	/**
	 * ����ͼFORMȡ��
	 * @return ����ͼFORM
	 */
	public IGCOM0314Form getIgcom0314Form() {
		return igcom0314Form;
	}

	/**
	 * ����ͼFORM�趨
	 *
	 * @param igcom0314Form ����ͼFORM
	 */
	public void setIgcom0314Form(IGCOM0314Form igcom0314Form) {
		this.igcom0314Form = igcom0314Form;
	}
	
	
	/**
	 * Ӱ�����ͼForm
	 * 
	 * @return Ӱ�����ͼ
	 */
	public IGCOM0321Form getIgcom0321Form() {
		return igcom0321Form;
	}

	/**
	 * Ӱ�����ͼ�趨
	 * 
	 * @param igcom0321Form Ӱ�����ͼ
	 */
	public void setIgcom0321Form(IGCOM0321Form igcom0321Form) {
		this.igcom0321Form = igcom0321Form;
	}

	/**
	 * ��ϵͼXMLȡ��
	 * 
	 * @return ��ϵͼXML
	 */
	public String getGraphXml() {
		return graphXml;
	}

	/**
	 * ��ϵͼXML�趨
	 * @param graphXml��ϵͼXML
	 */
	public void setGraphXml(String graphXml) {
		this.graphXml = graphXml;
	}

	/**
	 * ��ѡEIIDȡ��
	 * 
	 * @return ��ѡEIID
	 */
	public String getSelEiid() {
		return selEiid;
	}

	/**
	 * ��ѡEIID�趨
	 * 
	 * @param selEiid��ѡEIID
	 */
	public void setSelEiid(String selEiid) {
		this.selEiid = selEiid;
	}

	public IGCOM0318Form getIgcom0318Form() {
		return igcom0318Form;
	}

	public void setIgcom0318Form(IGCOM0318Form igcom0318Form) {
		this.igcom0318Form = igcom0318Form;
	}

	public IGCOM0319Form getIGCOM0319Form() {
		return igcom0319Form;
	}

	public void setIGCOM0319Form(IGCOM0319Form IGCOM0319Form) {
		this.igcom0319Form = IGCOM0319Form;
	}

	public IGCOM0320Form getIGCOM0320Form() {
		return igcom0320Form;
	}

	public void setIGCOM0320Form(IGCOM0320Form IGCOM0320Form) {
		this.igcom0320Form = IGCOM0320Form;
	}

	public Map<String, String> getConfigItem() {
		return configItem;
	}

	public void setConfigItem(Map<String, String> configItem) {
		this.configItem = configItem;
	}

	public SOC0121SearchCond getSnapshotRelationSearchCond() {
		return snapshotRelationSearchCond;
	}

	public void setSnapshotRelationSearchCond(
			SOC0121SearchCond snapshotRelationSearchCond) {
		this.snapshotRelationSearchCond = snapshotRelationSearchCond;
	}

	public IG013SearchCond getEntityItemSearchCond() {
		return entityItemSearchCond;
	}

	public void setEntityItemSearchCond(IG013SearchCond entityItemSearchCond) {
		this.entityItemSearchCond = entityItemSearchCond;
	}

	public IGCOM0319Form getIgcom0319Form() {
		return igcom0319Form;
	}

	public void setIgcom0319Form(IGCOM0319Form igcom0319Form) {
		this.igcom0319Form = igcom0319Form;
	}

	public IGCOM0320Form getIgcom0320Form() {
		return igcom0320Form;
	}

	public void setIgcom0320Form(IGCOM0320Form igcom0320Form) {
		this.igcom0320Form = igcom0320Form;
	}

	public IG800SearchCond getConfigItemSearchCond() {
		return configItemSearchCond;
	}

	public void setConfigItemSearchCond(IG800SearchCond configItemSearchCond) {
		this.configItemSearchCond = configItemSearchCond;
	}

	/**
	 * �豸��ϵ��FS-LV-VG��ȡ��
	 * @return fsLvVgInfoList�豸��ϵ��FS-LV-VG��
	 */
	public List<SOC0130Info> getFsLvVgInfoList() {
		return fsLvVgInfoList;
	}
	
	/**
	 * �豸��ϵ��FS-LV-VG���趨
	 * @param fsLvVgInfoList�豸��ϵ��FS-LV-VG��
	 */
	public void setFsLvVgInfoList(List<SOC0130Info> fsLvVgInfoList) {
		this.fsLvVgInfoList = fsLvVgInfoList;
	}
	
	/**
	 * �豸��ϵ��VG-PV-META��ȡ��
	 * @return �豸��ϵ��VG-PV-META��
	 */
	public List<SOC0131Info> getVgPvMetaInfoList() {
		return vgPvMetaInfoList;
	}
	
	/**
	 * �豸��ϵ��VG-PV-META���趨
	 * @param vgPvMetaBeanList�豸��ϵ��VG-PV-META��
	 */
	public void setVgPvMetaInfoList(List<SOC0131Info> vgPvMetaInfoList) {
		this.vgPvMetaInfoList = vgPvMetaInfoList;
	}
	
	/**
	 * �豸������������ȡ��
	 * @return �豸������������
	 */
	public String getEiorgname() {
		return eiorgname;
	}

	/**
	 * �豸�������������趨
	 * @param eiorgname�豸������������
	 */
	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	public IGCOM0322Form getIgcom0322Form() {
		return igcom0322Form;
	}

	public void setIgcom0322Form(IGCOM0322Form igcom0322Form) {
		this.igcom0322Form = igcom0322Form;
	}

	public String getStrXml() {
		return strXml;
	}

	public void setStrXml(String strXml) {
		this.strXml = strXml;
	}

	public String getStorageEiname() {
		return storageEiname;
	}

	public void setStorageEiname(String storageEiname) {
		this.storageEiname = storageEiname;
	}

	/**
	 * ������ͼFORMȡ��
	 * 
	 * @return ������ͼFORM
	 */
	public IGCOM0324Form getIgcom0324Form() {
		return igcom0324Form;
	}

	/**
	 * ������ͼFORM�趨
	 * 
	 * @param igcom0324Form ������ͼFORM
	 */
	public void setIgcom0324Form(IGCOM0324Form igcom0324Form) {
		this.igcom0324Form = igcom0324Form;
	}

	public SOC0139VW getSwitchConfigItem() {
		return switchConfigItem;
	}

	public void setSwitchConfigItem(SOC0139VW switchConfigItem) {
		this.switchConfigItem = switchConfigItem;
	}

	public List<SOC0132VW> getPortList() {
		return portList;
	}

	public void setPortList(List<SOC0132VW> portList) {
		this.portList = portList;
	}

	public List<SOC0133VW> getZoneList() {
		return zoneList;
	}

	public void setZoneList(List<SOC0133VW> zoneList) {
		this.zoneList = zoneList;
	}

	/**
	 * �ʲ�����Ϣ��������ȡ��
	 *
	 * @return soc0214SearchCond �ʲ�����Ϣ��������
	 */
	public SOC0124SearchCond getSoc0214SearchCond() {
		return soc0214SearchCond;
	}

	/**
	 * �ʲ�����Ϣ���������趨
	 *
	 * @param soc0214SearchCond �ʲ�����Ϣ��������
	 */
	public void setSoc0214SearchCond(SOC0124SearchCond soc0214SearchCond) {
		this.soc0214SearchCond = soc0214SearchCond;
	}

	/**
	 * �ʲ���������ȡ��
	 *
	 * @return soc0124List �ʲ���������
	 */
	public List<SOC0124Info> getSoc0124List() {
		return soc0124List;
	}

	/**
	 * �ʲ����������趨
	 *
	 * @param soc0124List �ʲ���������
	 */
	public void setSoc0124List(List<SOC0124Info> soc0124List) {
		this.soc0124List = soc0124List;
	}

	public IGCOM0328Form getIgcom0328Form() {
		return igcom0328Form;
	}

	public void setIgcom0328Form(IGCOM0328Form igcom0328Form) {
		this.igcom0328Form = igcom0328Form;
	}

	public IGCIM0147Form getIgcim0147Form() {
		return igcim0147Form;
	}

	public void setIgcim0147Form(IGCIM0147Form igcim0147Form) {
		this.igcim0147Form = igcim0147Form;
	}

	public Map<String, List<SOC0107Info>> getSoc0107InfoMap() {
		return soc0107InfoMap;
	}

	public void setSoc0107InfoMap(Map<String, List<SOC0107Info>> soc0107InfoMap) {
		this.soc0107InfoMap = soc0107InfoMap;
	}

	public List<SOC0128Info> getConfigItemVersionTime() {
		return configItemVersionTime;
	}

	public void setConfigItemVersionTime(List<SOC0128Info> configItemVersionTime) {
		this.configItemVersionTime = configItemVersionTime;
	}

	public List<SOC0118Info> getEntityItemList() {
		return entityItemList;
	}

	public void setEntityItemList(List<SOC0118Info> entityItemList) {
		this.entityItemList = entityItemList;
	}

	//SOC����
	/** �ʲ���������Ϣ�������SOC */
	protected Map<String,List<SOC0107Info>> configItemMapSOC;
	/** ��������ϢSOC */
	protected SOC0605Info entityItemVWInfoSOC;


	/**
	 * �ʲ���������Ϣ�������SOCȡ��
	 * @return configItemMapSOC
	 */
	public Map<String, List<SOC0107Info>> getConfigItemMapSOC() {
		return configItemMapSOC;
	}
	/**
	 * �ʲ���������Ϣ�������SOC�趨
	 * @param configItemMapSOC
	 */
	public void setConfigItemMapSOC(Map<String, List<SOC0107Info>> configItemMapSOC) {
		this.configItemMapSOC = configItemMapSOC;
	}

	/**
	 * ��������ϢSOCȡ��
	 * @return entityItemVWInfoSOC
	 */
	public SOC0605Info getEntityItemVWInfoSOC() {
		return entityItemVWInfoSOC;
	}
	/**
	 * ��������ϢSOC�趨
	 * @param entityItemVWInfoSOC
	 */
	public void setEntityItemVWInfoSOC(SOC0605Info entityItemVWInfoSOC) {
		this.entityItemVWInfoSOC = entityItemVWInfoSOC;
	}
}