package com.deliverik.infogovernor.soc.vir.bl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.axis.utils.StringUtils;
import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;
import org.apache.struts.util.LabelValueBean;
import org.apache.struts.util.MessageResources;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.soc.asset.EiDomainKeyWords;
import com.deliverik.framework.soc.asset.EiRelationKeyWords;
import com.deliverik.framework.soc.asset.EntityCategory;
import com.deliverik.framework.soc.asset.EntityItemKeyWords;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0109BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0110BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0111BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0112BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0119BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0126BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0151BL;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0110Info;
import com.deliverik.framework.soc.asset.model.SOC0111Info;
import com.deliverik.framework.soc.asset.model.SOC0112Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0126Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0110SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0126SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0107TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0112PK;
import com.deliverik.framework.soc.asset.model.entity.SOC0112TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0119TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0124VW;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR06DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0602Form;

/**
 * ���⻯����ҵ���߼�ʵ��
 *
 */
public class IGVIR06BLImpl extends BaseBLImpl implements IGVIR06BL {

	static Log log = LogFactory.getLog(IGVIR06BLImpl.class);
	
	/** ��������ϢBL */
	protected SOC0118BL soc0118BL;
	
	/** �������ϵBL */
	protected SOC0119BL soc0119BL;
	
	/** ������ϵBL */
	protected SOC0110BL soc0110BL;
	
	/** �ʲ���ϢBL */
	protected SOC0117BL soc0117BL;
	
	/** ����BL */
	protected OrganizationBL organizationBL;
	
	/** �ʲ�������BL */
	protected SOC0107BL soc0107BL;
	
	/** �ʲ�ȡֵ��Χ��������BL */
	protected SOC0151BL soc0151BL;
	
	/** ���汾����ϸBL */
	protected SOC0126BL soc0126BL;
	
	/** ����ϸBL */
	protected SOC0112BL soc0112BL;
	protected SOC0111BL soc0111BL;
	protected UserRoleBL userRoleBL;
	
	/** �ʲ�������ϵ��������BL */
	protected CodeDetailBL codeDetailBL;
	
	/** ������BL */
	protected SOC0109BL soc0109BL;
	
	/** �ļ��ϴ�BL */
	protected FileUploadBL fileUploadBL;
	
	protected MessageResources resources = MessageResources.getMessageResources("com.deliverik.infogovernor.soc.vir.asmResources"); 

	
	public SOC0118BL getSoc0118BL() {
		return soc0118BL;
	}

	public void setSoc0118BL(SOC0118BL soc0118BL) {
		this.soc0118BL = soc0118BL;
	}

	public SOC0119BL getSoc0119BL() {
		return soc0119BL;
	}

	public void setSoc0119BL(SOC0119BL soc0119BL) {
		this.soc0119BL = soc0119BL;
	}

	public void setSoc0111BL(SOC0111BL soc0111bl) {
		soc0111BL = soc0111bl;
	}

	public SOC0110BL getSoc0110BL() {
		return soc0110BL;
	}

	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	public void setSoc0110BL(SOC0110BL soc0110BL) {
		this.soc0110BL = soc0110BL;
	}
	
	public SOC0117BL getSoc0117BL() {
		return soc0117BL;
	}

	public void setSoc0117BL(SOC0117BL soc0117BL) {
		this.soc0117BL = soc0117BL;
	}

	public OrganizationBL getOrganizationBL() {
		return organizationBL;
	}

	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}

	public SOC0107BL getSoc0107BL() {
		return soc0107BL;
	}

	public void setSoc0107BL(SOC0107BL soc0107BL) {
		this.soc0107BL = soc0107BL;
	}

	public SOC0151BL getSoc0151BL() {
		return soc0151BL;
	}

	public void setSoc0151BL(SOC0151BL soc0151BL) {
		this.soc0151BL = soc0151BL;
	}

	public SOC0126BL getSoc0126BL() {
		return soc0126BL;
	}

	public void setSoc0126BL(SOC0126BL soc0126BL) {
		this.soc0126BL = soc0126BL;
	}

	public SOC0112BL getSoc0112BL() {
		return soc0112BL;
	}

	public void setSoc0112BL(SOC0112BL soc0112BL) {
		this.soc0112BL = soc0112BL;
	}

	public CodeDetailBL getCodeDetailBL() {
		return codeDetailBL;
	}

	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	public SOC0109BL getSoc0109BL() {
		return soc0109BL;
	}

	public void setSoc0109BL(SOC0109BL soc0109BL) {
		this.soc0109BL = soc0109BL;
	}

	public FileUploadBL getFileUploadBL() {
		return fileUploadBL;
	}

	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}

	/**
	 * ���⻯������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGVIR06DTO initIGVIR0602Action(IGVIR06DTO dto) throws BLException {

		log.debug("========���⻯������Ϣ�༭������ڻ�����ʼ========");
		
		IGVIR0602Form form = dto.getIgvir0602Form();
		
		//Ӧ����Ϣ����
//		EntityItemVWInfo entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
//				Integer.parseInt(form.getEiid()));
		//��ǰ����ͼ�����ǵ�����������ҳ��ֻ�õ�2�������ݣ�ֻ���2�������ݣ�Ȼ��ƴ����ͼ����. _ylq
		if (StringUtils.isEmpty(form.getEiid())) {
			return dto;
		}
		SOC0118Info entityItemInfo=soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getEiid()));
		SOC0117Info entity=soc0117BL.searchEntityByKey(entityItemInfo.getEid());
		SOC0124VW entityItemVWInfo=new SOC0124VW();
		entityItemVWInfo.setEname(entity.getEname());
		entityItemVWInfo.setEilabel(entityItemInfo.getEilabel());
		entityItemVWInfo.setEiname(entityItemInfo.getEiname());
		entityItemVWInfo.setEidesc(entityItemInfo.getEidesc());
		entityItemVWInfo.setEistatus(entityItemInfo.getEistatus());
		entityItemVWInfo.setEiusername(entityItemInfo.getEiusername());
		entityItemVWInfo.setEiinsdate(entityItemInfo.getEiinsdate());
		entityItemVWInfo.setEiupdtime(entityItemInfo.getEiupdtime());
		entityItemVWInfo.setEsyscoding(entityItemInfo.getEsyscoding());
		entityItemVWInfo.setEiorgsyscoding(entityItemInfo.getEiorgsyscoding());
		entityItemVWInfo.setEiversion(entityItemInfo.getEiversion());
		entityItemVWInfo.setEismallversion(entityItemInfo.getEismallversion());
		entityItemVWInfo.setEid(entityItemInfo.getEid());
		entityItemVWInfo.setEiid(entityItemInfo.getEiid());
		entityItemVWInfo.setEirootmark(entityItemInfo.getEirootmark());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGVIR06BLImpl.004"));
		}
		
		form.setEidesc(entityItemVWInfo.getEidesc());
//		form.setEistatus(entityItemVWInfo.getEistatus());
		String eiorgsyscoding = entityItemVWInfo.getEiorgsyscoding();
		form.setEiorgsyscoding(eiorgsyscoding);
		form.setEsyscoding_q(entityItemVWInfo.getEsyscoding());
		if(!StringUtils.isEmpty(eiorgsyscoding)){
			OrganizationSearchCondImpl OrgCond = new OrganizationSearchCondImpl();
			OrgCond.setOrgsyscoding(eiorgsyscoding);
			List<Organization> orgList = this.organizationBL.searchOrganization(OrgCond, 0, 0);
			for (int i = 0; i < orgList.size(); i++) {
				form.setEiorgname(orgList.get(0).getOrgname());
			}
		}
		dto.setEiorgname(form.getEiorgname());
		dto.setEntityItemVWInfo(entityItemVWInfo);
		
		//��ȡ��ʷ�汾����ʱ��
		dto.setConfigItemVersionTime(this.soc0118BL.searchVersionUpdateTime(Integer.parseInt(form.getEiid())));
		
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		//���⻯������Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0107BL.getConfigItemVWSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========���⻯������Ϣ��ѯ���ݲ�����========");
			//���⻯������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========���⻯������Ϣ��ѯ���ݼ�������========");
			//���⻯������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//���⻯������Ϣȫ����ѯ
		List<SOC0129Info> configItemVWInfoList = this.soc0107BL.searchConfigItemVW(
				form, 0, 0);
		
		String[] civalue = new String[totalCount];
		String[] entityItemCivalue = new String[totalCount];
		//��žɰ汾ֵ
		String[] civalue_bak = new String[totalCount];
		Map<String,List<SOC0129Info>> map = new LinkedHashMap<String,List<SOC0129Info>>();
		int i = 0;
		int j = 0;
		List<String> strlist = new ArrayList<String>();
		for(SOC0129Info e : configItemVWInfoList){
			if(!map.containsKey(e.getCcategory())){
				map.put(e.getCcategory(), new ArrayList<SOC0129Info>());
				strlist.add(e.getCcategory());
			}
			map.get(e.getCcategory()).add(e);
			if("2".equals(e.getCattach())){
				List<LabelValueBean> list = soc0151BL.searchLabelValueBeanList(e.getCoption());
				form.setSelectedListMap(j++, list);
			}
			if("5".equals(e.getCattach())){
				List<LabelValueBean> list = soc0151BL.searchLabelValueBeanList(e.getCoption());
				if(list.size() > 0){
					list.remove(0);
				}
				form.setSelectedListMap(j++, list);
			}
		}
		for(String str : strlist){
			for(SOC0129Info e : map.get(str)){
				//��ʾ���ʲ����ƣ�ʵ�ʴ�ֵ���ʲ�����(�ʲ�ID)
				if("4".equals(e.getCattach()) && !StringUtils.isEmpty(e.getCivalue())){
					civalue[i] = e.getCivalue().substring(0, e.getCivalue().lastIndexOf("("));
					entityItemCivalue[i] = e.getCivalue();
				} else {
					civalue[i] = e.getCivalue();
				}
				civalue_bak[i] = e.getCivalue();
				i++;
			}
		}
		
		form.setCivalue(civalue);
		form.setEntityItemCivalue(entityItemCivalue);
		form.setCivalue_bak(civalue_bak);
		dto.setConfigItemVWInfoMap(map);


		
		log.debug("========���⻯������Ϣ�༭������ڻ���������========");
		return dto;
	}
	/**
	 * ��ѯ���������µ������ʲ���Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public Map<Integer,SOC0118Info> getEntityItem(Integer eiid){
		//��ѯ���������µ���Ϣת����MAP
		Map<Integer,SOC0118Info> isMap = new HashMap<Integer,SOC0118Info>();
		SOC0118SearchCondImpl cond0118 = new SOC0118SearchCondImpl();
		cond0118.setEirootmark(eiid);
		List<SOC0118Info> allList = soc0118BL.searchEntityItem(cond0118);
		for(SOC0118Info entityItem:allList){
			isMap.put(entityItem.getEiid(), entityItem);
		}
		return isMap;
	}
	/**
	 * �������ˣ�ȡ�����⻯�����ϵ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR06DTO getVMWareTree(IGVIR06DTO dto) throws BLException {
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version='1.0' encoding='UTF-8' ?>");
		xml.append("<root>");
		SOC0118SearchCondImpl cond0118 = new SOC0118SearchCondImpl();
		cond0118.setEid(EntityItemKeyWords.DATACENTER_EID);
		String eiid = dto.getEiid();
		//ȡ��������������
		List<SOC0118Info> vmwareList = soc0118BL.searchEntityItem(cond0118);
		if (vmwareList != null && vmwareList.size() >0 ) {
			int i=0;
			for (SOC0118Info info0118 : vmwareList) {
				Map<String,String> siMap = new HashMap<String,String>();
				siMap.put("eiid", eiid);
				if(i==0){
					dto.setEiid(info0118.getEiid().toString());
				}
				xml.append("<node eiid='" + info0118.getEiid() + "' eid='" + info0118.getEid() + "' name='" + info0118.getEiname() + "' isExpand='1' desc='' icon='dbImage'>");
				searchCldTreeNode(xml, info0118,siMap,getEntityItem(info0118.getEiid()));
				xml.append("</node>");
				i++;
				xml.append("</node>");
			}
		}
		xml.append("</root>");
		String treeXml = xml.toString();
		dto.setTreeXml(treeXml);
		return dto;
	}
	private void searchCldTreeNode(StringBuffer xml, SOC0118Info info0118,Map<String,String> siMap,Map<Integer,SOC0118Info> isMap) throws BLException {
		
		SOC0110SearchCondImpl cond0110 = new SOC0110SearchCondImpl();
		cond0110.setBrpareiid(String.valueOf(info0118.getEiid()));
		cond0110.setBrparversion(String.valueOf(info0118.getEiversion()));
		cond0110.setBrparsmallversion(String.valueOf(info0118.getEismallversion()));
		cond0110.setBrassetrelation_in(EntityItemKeyWords.Relation_In);
		cond0110.setDeleteflag("0");
		String icon = "";
		List<SOC0110Info> soc0110List = arraysList(soc0110BL.searchMaxEiBelongRelation(cond0110));
		if (soc0110List != null && soc0110List.size() > 0) {
			
			for (SOC0110Info info0110 : soc0110List) {
				if(info0110.getBrassetrelation().equals(EntityItemKeyWords.DATACENTER_CLUSTER_Relation)
						|| info0110.getBrassetrelation().equals(EntityItemKeyWords.DATACENTER_NETWORK_Relation)
						|| info0110.getBrassetrelation().equals(EntityItemKeyWords.DATACENTER_DATASTORE_Relation)){
					if(StringUtils.isEmpty(siMap.get("relation")))
						siMap.put("relation", info0110.getBrassetrelation());
					else if(!siMap.get("relation").equals(info0110.getBrassetrelation()))
						xml.append("</node>");
					setFixedNode(info0110,xml,siMap);
					SOC0118Info soc0118Info = isMap.get(info0110.getBrcldeiid());//soc0118BL.searchEntityItemByKey(info0110.getBrcldeiid());
					xml.append("<node eiid='" + soc0118Info.getEiid() + "' eid='" + soc0118Info.getEid() + "' name='" + soc0118Info.getEiname() + "'  isExpand='1' desc='' icon='" + icon + "'>");
					if(info0110.getBrassetrelation().equals(EntityItemKeyWords.DATACENTER_CLUSTER_Relation))
						xml.append(searchCldTreeNodeHost(soc0118Info,isMap,siMap));
					xml.append("</node>");
					if(!siMap.get("relation").equals(info0110.getBrassetrelation())){
						siMap.put("relation", info0110.getBrassetrelation());
					}
				}
			}
		}
	}
	private String searchCldTreeNodeHost(SOC0118Info info0118,Map<Integer,SOC0118Info> isMap,Map<String,String> siMap) throws BLException{
		SOC0110SearchCondImpl cond0110 = new SOC0110SearchCondImpl();
		cond0110.setBrpareiid(String.valueOf(info0118.getEiid()));
		cond0110.setBrparversion(String.valueOf(info0118.getEiversion()));
		cond0110.setBrparsmallversion(String.valueOf(info0118.getEismallversion()));
		cond0110.setBrassetrelation_in("'"+EntityItemKeyWords.CLUSTER_ESXHOST_Relation+"'");
		cond0110.setDeleteflag("0");
		StringBuffer xml = new StringBuffer();
		String icon = "";
		String host = "<node eiid='' eid='' name='Esx����' isExpand='1' desc='' icon='hostImage'>";
		List<SOC0110Info> soc0110List = getArraySOC0110Info(soc0110BL.searchMaxEiBelongRelation(cond0110), isMap);
		if (soc0110List != null && soc0110List.size() > 0) {
			xml.append(host);
			for (SOC0110Info info0110 : soc0110List) {
				//SOC0118Info soc0118Info = soc0118BL.searchEntityItemByKey(info0110.getBrcldeiid());
				SOC0118Info soc0118Info = isMap.get(info0110.getBrcldeiid());
				xml.append("<node eiid='" + soc0118Info.getEiid() + "' eid='" + soc0118Info.getEid() + "' name='" + soc0118Info.getEiname() + "' isExpand='1' desc='' icon='" + icon + "'>");
				xml.append(searchCldTreeNodeVM(soc0118Info,isMap,siMap));
				xml.append(searchCldTreeNodeHBA(soc0118Info,isMap));
				xml.append("</node>");
			}
			xml.append("</node>");
		}
		return xml.toString();
	}
	private String searchCldTreeNodeVM(SOC0118Info info0118,Map<Integer,SOC0118Info> isMap,Map<String,String> siMap) throws BLException{
		SOC0110SearchCondImpl cond0110 = new SOC0110SearchCondImpl();
		cond0110.setBrpareiid(String.valueOf(info0118.getEiid()));
		cond0110.setBrparversion(String.valueOf(info0118.getEiversion()));
		cond0110.setBrparsmallversion(String.valueOf(info0118.getEismallversion()));
		cond0110.setBrassetrelation_in("'"+EntityItemKeyWords.ESXHOST_VM_Relation+"'");
		cond0110.setDeleteflag("0");
		StringBuffer xml = new StringBuffer();
		String icon = "";
		String isExpand = "";
		if(siMap.get("eiid")!=null){
			isExpand = "isExpand='1'";
		}
		String vm = "<node eiid='' eid='' name='�����' "+isExpand+" desc='' icon=''>";
		List<SOC0110Info> soc0110List = soc0110BL.searchMaxEiBelongRelation(cond0110);
		if (soc0110List != null && soc0110List.size() > 0) {
			xml.append(vm);
			for (SOC0110Info info0110 : soc0110List) {
				//SOC0118Info soc0118Info = soc0118BL.searchEntityItemByKey(info0110.getBrcldeiid());
				SOC0118Info soc0118Info = isMap.get(info0110.getBrcldeiid());
				if(siMap.get("eiid")!=null && siMap.get("eiid").equals(soc0118Info.getEiid())){
					xml.toString().replace("vmExpand", isExpand);
				}
				xml.append("<node eiid='" + soc0118Info.getEiid() + "' eid='" + soc0118Info.getEid() + "' name='" + soc0118Info.getEiname() + "' "+isExpand+" desc='' icon='" + icon + "'>");
				xml.append("</node>");
			}
			xml.append("</node>");
		}
		return xml.toString();
	}
	private String searchCldTreeNodeHBA(SOC0118Info info0118,Map<Integer,SOC0118Info> isMap) throws BLException{
		SOC0110SearchCondImpl cond0110 = new SOC0110SearchCondImpl();
		cond0110.setBrpareiid(String.valueOf(info0118.getEiid()));
		cond0110.setBrparversion(String.valueOf(info0118.getEiversion()));
		cond0110.setBrparsmallversion(String.valueOf(info0118.getEismallversion()));
		cond0110.setBrassetrelation_in("'"+EntityItemKeyWords.ESXHOST_HBA_Relation+"'");
		cond0110.setDeleteflag("0");
		StringBuffer xml = new StringBuffer();
		String icon = "";
		String hba = "<node eiid='' eid='' name='HBA��' desc='' icon=''>";
		List<SOC0110Info> soc0110List = soc0110BL.searchMaxEiBelongRelation(cond0110);
		if (soc0110List != null && soc0110List.size() > 0) {
			xml.append(hba);
			for (SOC0110Info info0110 : soc0110List) {
				//SOC0118Info soc0118Info = soc0118BL.searchEntityItemByKey(info0110.getBrcldeiid());
				SOC0118Info soc0118Info = isMap.get(info0110.getBrcldeiid());
				xml.append("<node eiid='" + soc0118Info.getEiid() + "' eid='" + soc0118Info.getEid() + "' name='" + soc0118Info.getEiname() + "' desc='' icon='" + icon + "'>");
				xml.append(searchCldTreeNodeLun(soc0118Info,isMap));
				xml.append("</node>");
			}
			xml.append("</node>");
		}
		return xml.toString();
	}
	private String searchCldTreeNodeLun(SOC0118Info info0118,Map<Integer,SOC0118Info> isMap) throws BLException{
		SOC0110SearchCondImpl cond0110 = new SOC0110SearchCondImpl();
		cond0110.setBrpareiid(String.valueOf(info0118.getEiid()));
		cond0110.setBrparversion(String.valueOf(info0118.getEiversion()));
		cond0110.setBrparsmallversion(String.valueOf(info0118.getEismallversion()));
		cond0110.setBrassetrelation_in("'"+EntityItemKeyWords.HBA_LUN_Relation+"'");
		cond0110.setDeleteflag("0");
		StringBuffer xml = new StringBuffer();
		String icon = "webappImage";
		String lun = "<node eiid='' eid='' name='LUN' desc='' icon=''>";
		List<SOC0110Info> soc0110List = soc0110BL.searchMaxEiBelongRelation(cond0110);
		if (soc0110List != null && soc0110List.size() > 0) {
			xml.append(lun);
			for (SOC0110Info info0110 : soc0110List) {
				//SOC0118Info soc0118Info = soc0118BL.searchEntityItemByKey(info0110.getBrcldeiid());
				SOC0118Info soc0118Info = isMap.get(info0110.getBrcldeiid());
				xml.append("<node eiid='" + soc0118Info.getEiid() + "' eid='" + soc0118Info.getEid() + "' name='" + soc0118Info.getEiname() + "' desc='' icon='" + icon + "'>");
				xml.append("</node>");
			}
			xml.append("</node>");
		}
		return xml.toString();
	}
	/**
	 * Esx������������
	 * @param soc0110List
	 * @param isMap
	 */
	public List<SOC0110Info> getArraySOC0110Info(List<SOC0110Info> soc0110List,Map<Integer,SOC0118Info> isMap){
		List<SOC0110Info> soc0110List_new = new ArrayList<SOC0110Info>();
		List<SOC0118Info> entityItemList = new ArrayList<SOC0118Info>();
		Map<Integer,SOC0110Info> soc0110Map = new HashMap<Integer,SOC0110Info>();
		for(SOC0110Info soc0110Info : soc0110List){
			entityItemList.add(isMap.get(soc0110Info.getBrcldeiid()));
			soc0110Map.put(soc0110Info.getBrcldeiid(), soc0110Info);
		}
		entityItemList = arraysListTo0118(entityItemList);
		for(SOC0118Info entityItem:entityItemList){
			soc0110List_new.add(soc0110Map.get(entityItem.getEiid()));
		}
		return soc0110List_new;
	}
	
	/**
	 * �������ˣ�������̶��ڵ�
	 * @param xml
	 * @param siMap
	 * @param info0110
	 * @throws BLException
	 */
	private void setFixedNode(SOC0110Info info0110,StringBuffer xml,Map<String,String> siMap){
		String cluster = "<node eiid='' eid='' name='��Ⱥ' isExpand='1' desc='' icon='clusterImage'>";
		String datastore = "<node eiid='' eid='' name='���ݴ洢' isExpand='1' desc='' icon='storageImage'>";
		String network = "<node eiid='' eid='' name='����' desc='' isExpand='1' icon='netImage'>";
		if(info0110.getBrassetrelation().equals(EntityItemKeyWords.DATACENTER_CLUSTER_Relation) &&
				StringUtils.isEmpty(siMap.get(info0110.getBrassetrelation()+info0110.getBrpareiid()))){
			siMap.put(info0110.getBrassetrelation()+info0110.getBrpareiid(), "true");
			xml.append(cluster);
		}else if(info0110.getBrassetrelation().equals(EntityItemKeyWords.DATACENTER_NETWORK_Relation) &&
				StringUtils.isEmpty(siMap.get(info0110.getBrassetrelation()+info0110.getBrpareiid()))){
			siMap.put(info0110.getBrassetrelation()+info0110.getBrpareiid(), "true");
			xml.append(network);
		}else if(info0110.getBrassetrelation().equals(EntityItemKeyWords.DATACENTER_DATASTORE_Relation) &&
				StringUtils.isEmpty(siMap.get(info0110.getBrassetrelation()+info0110.getBrpareiid()))){
			siMap.put(info0110.getBrassetrelation()+info0110.getBrpareiid(), "true");
			xml.append(datastore);
		}
	}
	public List<SOC0110Info> arraysList(List<SOC0110Info> soc0110List){
        //list����
		Collections.sort(soc0110List,new Comparator<SOC0110Info>(){
			public int compare(SOC0110Info soc1,SOC0110Info soc2){
				String len1 =  soc1.getBrassetrelation().substring(soc1.getBrassetrelation().length()-5, soc1.getBrassetrelation().length());
				String len2 =  soc2.getBrassetrelation().substring(soc2.getBrassetrelation().length()-5, soc2.getBrassetrelation().length());
			return Integer.parseInt(len1)-Integer.parseInt(len2);
			}
		  } 
		);
		return soc0110List;
	}
	public List<SOC0118Info> arraysListTo0118(List<SOC0118Info> soc0118List){
        //list����
		Collections.sort(soc0118List,new Comparator<SOC0118Info>(){
			public int compare(SOC0118Info soc1,SOC0118Info soc2){
				int flag=soc1.getEiname().compareTo(soc2.getEiname());
				if(flag==0){
					return soc1.getEiid().compareTo(soc2.getEiid());
					}else{
						return flag;
				}  
			}
		  } 
		);
		return soc0118List;
	}
	/**
	 * Ӧ��������Ϣ�༭����
	 *
	 * @param dto IGVIR06DTO
	 * @return IGVIR06DTO
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGVIR06DTO editEntityItemActionApp(IGVIR06DTO dto) throws BLException, FileNotFoundException, IOException {
		log.debug("========Ӧ��������Ϣ�༭����ʼ========");
		//�汾������
		IGVIR0602Form form = dto.getIgvir0602Form();
		
		int version = form.getEiversion() + 1;
		
		//Ӧ�û�����Ϣ����
		SOC0118TB entityItem = (SOC0118TB) this.soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getEiid()));

		if(version - 1 != entityItem.getEiversion()) {
			throw new BLException("IGCO00000.E004");
		}
		//�ʲ���ϵ��Ϣ�汾��������
		this.soc0119BL.upgradeEntityItemRelation(entityItem.getEiid(), entityItem.getEiversion(), entityItem.getEismallversion(),
				version, 0);
		
		//Ӧ��״̬
//		entityItem.setEistatus(form.getEistatus());
		//Ӧ�ð汾
		entityItem.setEiversion(version);
		
		//Ӧ��˵��
		entityItem.setEidesc(form.getEidesc());

		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		//����ʱ��
		entityItem.setEiname(form.getEiname());
		entityItem.setEidesc(form.getEidesc());
		entityItem.setEiupdtime(datetime);
		//���ø���BL
		this.soc0118BL.updateEntityItem(entityItem);
		
		
		SOC0126SearchCondImpl eiDomainCond = new SOC0126SearchCondImpl();
		eiDomainCond.setEiname(entityItem.getEiname());
		List<SOC0126Info> eiDomailMaxList = soc0126BL.searchEiDomainDetailAllVW(eiDomainCond,0,0);
		
		if(eiDomailMaxList!=null && eiDomailMaxList.size()>0){
			for(SOC0126Info eiDomainBean:eiDomailMaxList){
				SOC0112PK pk = new SOC0112PK();
				pk.setEiddid(eiDomainBean.getEiddid());
				pk.setEiddversion(eiDomainBean.getEiddversion());
				pk.setEiImportversion(eiDomainBean.getEiImportversion());
				pk.setEiname(eiDomainBean.getEiname());;
				SOC0112Info eiInfo = soc0112BL.searchEiDomainDetailByPK(pk);
				SOC0112TB eiddTB = (SOC0112TB)SerializationUtils.clone(eiInfo);
				eiddTB.setEiImportversion(version);
				soc0112BL.deleteEiDomainDetailByPK(pk);
				soc0112BL.registEiDomainDetail(eiddTB);
			}
		}
		

		
		//Ӧ��������Ϣ����
		if (form.getCiid() != null && form.getCiid().length > 0 ) {
			
			for( int i=0 ; i < form.getCiid().length; i++ ){
				SOC0107TB configItem = new SOC0107TB();
				//Ӧ��ID
				configItem.setEiid(Integer.parseInt(form.getEiid()));
				//�ʲ�����ID
				configItem.setCid(form.getCid()[i]);
				//����ID
				configItem.setEid(form.getEid()[i]);
				//���Ͳ����
				configItem.setEsyscoding(form.getEsyscoding()[i]);
				//����
				configItem.setCivalue(form.getCivalue()[i]);
				//��汾��
				configItem.setCiversion(version);
				//С�汾��
				configItem.setCismallversion(0);
				//����ʱ��
				configItem.setCiupdtime(datetime);
				
				//��ʾ���ʲ����ƣ�ʵ�ʴ�ֵ���ʲ�����(�ʲ�ID)
				if("4".equals(form.getCiattach()[i]) && !StringUtils.isEmpty(form.getEntityItemCivalue()[i])){
					configItem.setCivalue(form.getEntityItemCivalue()[i]);
				}
				if (StringUtils.isEmpty(form.getCiid()[i])) {	
					//���±�ʶ
					if(StringUtils.isEmpty(configItem.getCivalue())) {
						configItem.setCicurver("0");
					} else {
						configItem.setCicurver("1");
					}
					configItem = (SOC0107TB) this.soc0107BL.registSOC0107(configItem);
					
					//�������Ϊ�ʲ�ʱ�����ӹ�����ϵ
					if("4".equals(form.getCiattach()[i]) && !StringUtils.isEmpty(form.getCivalue()[i])){
						SOC0119TB e = new SOC0119TB();
						e.setPareid(entityItem.getEid());
						e.setPareiid(entityItem.getEiid());
						e.setParversion(entityItem.getEiversion());
						e.setParsmallversion(entityItem.getEismallversion());
						String str = form.getEntityItemCivalue()[i];
						SOC0118Info ei = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
						e.setCldeid(ei.getEid());
						e.setCldeiid(ei.getEiid());
						e.setCldversion(ei.getEiversion());
						e.setCldsmallversion(ei.getEismallversion());
						//˫��
						String relationcode = entityItem.getEsyscoding().substring(3, 6)+"-"+ei.getEsyscoding().substring(3, 6);	
						boolean flag = true ;
						CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
						condimpl.setBusinesscode_like(relationcode);
						List<CodeDetail> cd = codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
						if ( cd.size()==1){
							flag = false;
							e.setEirrelation(cd.get(0).getCid());
							e.setEirrelationcode(cd.get(0).getBusinesscode());
						}
						if(flag){
							condimpl.setBusinesscode_like(ei.getEsyscoding().substring(3, 6)+"-"+entityItem.getEsyscoding().substring(3, 6));
							cd = codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
							if ( cd.size()!=1){
								throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
										"IGCO10000.E017");
							}else{
								e.setEirrelation(cd.get(0).getCid());
								e.setEirrelationcode(cd.get(0).getBusinesscode());
								flag = false;
							}
						}
						if (flag){
							throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
									"IGCO10000.E017");
						}
						e.setEirupdtime(datetime);
						//��ѯ��������
						SOC0109Info config = this.soc0109BL.searchConfigurationByKey(form.getCid()[i]);
						String cname = config.getCname();
						e.setEirdesc(resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.005")+cname+
								resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.006"));
						//����key
						e.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
						//����״̬ΪC����ϵ�����в���ɾ��
						e.setEirstatus("C");
						this.soc0119BL.registEntityItemRelation(e);
					}
					log.debug("�ʲ������[�ʲ�����ID:" + form.getCid()[i] + "]���봦��ɹ���");
					
				} else {
					//���±�ʶĬ��Ϊ0
					configItem.setCicurver("0");
					if ("4".equals(form.getCiattach()[i])){
						if(!form.getCivalue_bak()[i].equals(configItem.getCivalue())){
							//�����ʲ����Ա�ʶ
							configItem.setCicurver("1");
						}
					} else if(!form.getCivalue_bak()[i].equals(configItem.getCivalue())){
						//�������Ա�ʶ
						configItem.setCicurver("1");
					}
					
					configItem = (SOC0107TB) this.soc0107BL.registSOC0107(configItem);
					
					//�������Ϊ�ʲ�ʱ�����ӹ�����ϵ
					if("4".equals(form.getCiattach()[i]) && !StringUtils.isEmpty(form.getCivalue()[i])){
						SOC0119TB e = new SOC0119TB();
						e.setPareid(entityItem.getEid());
						e.setPareiid(entityItem.getEiid());
						e.setParversion(entityItem.getEiversion());
						e.setParsmallversion(entityItem.getEismallversion());
						String str = form.getEntityItemCivalue()[i];			
						SOC0118Info ei = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
						e.setCldeid(ei.getEid());
						e.setCldeiid(ei.getEiid());
						e.setCldversion(ei.getEiversion());
						e.setCldsmallversion(ei.getEismallversion());
						//У���ϵ�Ƿ����
						SOC0119SearchCondImpl cond = new SOC0119SearchCondImpl();
						cond.setEirinfo(entityItem.getEiid()+"_"+form.getCiid()[i]+"_"+ei.getEiid());
						cond.setEirstatus("C");
						cond.setParversion(Integer.parseInt(entityItem.getEiversion().toString()));
						cond.setParsmallversion(Integer.parseInt(entityItem.getEismallversion().toString()));
						cond.setDeleteflag("0");
						List<SOC0119Info> eirlist = this.soc0119BL.searchEntityItemRelation(cond, 0, 0);
						if(eirlist.isEmpty()){
							//ɾ��ԭ�����еĹ�ϵ
							SOC0119SearchCondImpl eircond = new SOC0119SearchCondImpl();
							eircond.setEirinfo(entityItem.getEiid()+"_"+form.getCiid()[i]+"_");
							eircond.setEirstatus("C");
							eircond.setParversion(Integer.parseInt(entityItem.getEiversion().toString()));
							eircond.setParsmallversion(Integer.parseInt(entityItem.getEismallversion().toString()));
							eircond.setDeleteflag("0");
							List<SOC0119Info> eir = this.soc0119BL.searchEntityItemRelation(eircond, 0, 0);
							for (SOC0119Info entityItemRelation : eir) {
								this.soc0119BL.deleteEntityItemRelation(entityItemRelation);
							}
							//˫��
							String relationcode = entityItem.getEsyscoding().substring(3, 6)+"-"+ei.getEsyscoding().substring(3, 6);	
							boolean flag = true ;
							CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
							condimpl.setBusinesscode_like(relationcode);
							List<CodeDetail> cd = codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
							if ( cd.size()==1){
								flag = false;
								e.setEirrelation(cd.get(0).getCid());
								e.setEirrelationcode(cd.get(0).getBusinesscode());
							}
							if(flag){
								condimpl.setBusinesscode_like(ei.getEsyscoding().substring(3, 6)+"-"+entityItem.getEsyscoding().substring(3, 6));
								cd = codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
								if ( cd.size()!=1){
									throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
											"IGCO10000.E017");
								}else{
									e.setEirrelation(cd.get(0).getCid());
									e.setEirrelationcode(cd.get(0).getBusinesscode());
									flag = false;
								}
							}
							if (flag){
								throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
										"IGCO10000.E017");
							}
							e.setEirupdtime(datetime);
							//��ѯ��������
							SOC0109Info config = this.soc0109BL.searchConfigurationByKey(form.getCid()[i]);
							String cname = config.getCname();
							e.setEirdesc(resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.005")+cname+
									resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.006"));
							//����key
							e.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
							//����״̬ΪC����ϵ�����в���ɾ��
							e.setEirstatus("C");
							this.soc0119BL.registEntityItemRelation(e);
						} else {
							if(eirlist.size() != 1) {
								throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR, "IGCO10000.E017");
							} else {
								SOC0119TB eirTB = (SOC0119TB)SerializationUtils.clone(eirlist.get(0));
								
								eirTB.setEirinfo(eirTB.getEirinfo().replaceAll("_" + form.getCiid()[i] + "_", "_" + configItem.getCiid() + "_"));
								
								this.soc0119BL.updateEntityItemRelation(eirTB);
							}
						}
					}
					
					if("4".equals(form.getCiattach()[i]) && StringUtils.isEmpty(form.getCivalue()[i])){
						//ɾ��ԭ�����еĹ�ϵ
						SOC0119SearchCondImpl eircond = new SOC0119SearchCondImpl();
						eircond.setEirinfo(entityItem.getEiid()+"_"+form.getCiid()[i]+"_");
						eircond.setEirstatus("C");
						eircond.setParversion(Integer.parseInt(entityItem.getEiversion().toString()));
						eircond.setParsmallversion(Integer.parseInt(entityItem.getEismallversion().toString()));
						eircond.setDeleteflag("0");
						List<SOC0119Info> eir = this.soc0119BL.searchEntityItemRelation(eircond, 0, 0);
						for (SOC0119Info entityItemRelation : eir) {
							this.soc0119BL.deleteEntityItemRelation(entityItemRelation);
						}
					}
					log.debug("�ʲ������[�ʲ�����ID:" + form.getCid()[i] + "]���´���ɹ���");
				}
				
				//�ϴ��ļ����
				if (form.getCiattach()[i].toUpperCase().equals("1")) {
					FormFile file = form.getAttachFile(i);
					if ( file != null && file.getFileSize() > 0) {
						//�ϴ��ļ����ڵ����
						//�ϴ��ļ�·��
						String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
						StringBuffer pathBuf = new StringBuffer();
						
						//��Ŀ¼
						pathBuf.append(rootPath);
						//����ID
						pathBuf.append("asm"+File.separator);
						//Ӧ��ID
						pathBuf.append(configItem.getEiid());
						pathBuf.append(File.separator);
						
						StringBuffer fileName = new StringBuffer();
						
						//��չ��ȡ��
						String fileType = "";
						String sFileName = file.getFileName();
						int point = sFileName.lastIndexOf(".");
						if (point != -1) {
							fileType = sFileName.substring(point);
							fileName.append(sFileName.substring(0, point));
						}
						
						//�ļ�����Ӱ汾��
						fileName.append("_");
						fileName.append(configItem.getCiversion());
						//�ļ���չ��
						fileName.append(fileType);

						//�ļ��ϴ�����
						this.fileUploadBL.saveFile(file, pathBuf.toString(), fileName.toString());
						
						//�ϴ��ļ�������
						configItem.setCivalue(fileName.toString());
						
						//�������Ա�ʶ
						configItem.setCicurver("1");
						
						this.soc0107BL.updateSOC0107(configItem);					
						
					}
				}
			}
			
		}
	
		dto.addMessage(new ActionMessage("IGCO10000.I005","Ӧ��������Ϣ"));
		
		log.debug("========Ӧ��������Ϣ�༭��������========");
		
		return dto;
	}
	
	/**
	 * 0604�豸��Ϣ��ѯ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGVIR06DTO searchEntityItem0604Action(IGVIR06DTO dto) throws BLException {

		log.debug("========�豸��Ϣ��ѯ����ʼ========");
		
		//�豸��Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(dto.getEntityItemVWSearchCond());
		
		if (totalCount == 0) {
			log.debug("========�豸��Ϣ��ѯ���ݲ�����========");
			//�豸��Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�豸��Ϣ��ѯ���ݼ�������========");
			//�豸��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳ�豸��Ϣȡ��
		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL.searchEntityItemVW(dto.getEntityItemVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemVWInfoList(entityItemVWInfoList);

		Integer domainid = EiDomainKeyWords.DOOMAIN_ID_DEFAULT;
		SOC0111Info domain  = this.soc0111BL.searchDomainMaxVersion(domainid);
		Integer domainversion = domain.getVersion();
		String createtime = domain.getUpdatetime();
		String showRelation = "N";
		Map<String,String> showRelationMap = new HashMap<String,String>();
		if(entityItemVWInfoList!=null){
			//���������������洢���Բ鿴��ϵ
			// ���洢��Ϊֻ�鿴DMX�洢 --20130607 yanglongquan
			for(SOC0124Info bean:entityItemVWInfoList){
				if(bean.getEsyscoding().startsWith(EiRelationKeyWords.HOST) 
						|| bean.getEsyscoding().startsWith(EiRelationKeyWords.SWITCH)
						|| bean.getEsyscoding().startsWith(EiRelationKeyWords.STORAGE_DMX)) {
					showRelation = "Y";
				}else{
					showRelation = "N";
				}
				showRelationMap.put(String.valueOf(bean.getEiid()), showRelation);
			}
		}
		dto.setDomainid(domainid);
		dto.setDomainversion(domainversion);
		dto.setCreatetime(createtime);
		dto.setShowRelationMap(showRelationMap);
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========�豸��Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * �жϵ�½�û��Ƿ����豸�ʲ������ɫ������
	 * 
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 * @throws BLException 
	 */
	public IGVIR06DTO checkEntityItemDomain(IGVIR06DTO dto) throws BLException{
		boolean isRoleManager = this.userRoleBL.checkRoleManagerByType(dto.getUser().getUserid(), EntityCategory.ROLE_TYPE_STORAGE);
		
		if(isRoleManager) {
			OrganizationSearchCondImpl orgCond = new OrganizationSearchCondImpl();
			orgCond.setOrgpar("0001");
			List<Organization> org = this.organizationBL.searchOrganization(orgCond);
			
			if(org.size() != 1) {
				throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.017"));
			} else {
				dto.setOrgname(org.get(0).getOrgname());
				dto.setOrgsyscoding(org.get(0).getOrgsyscoding());
			}
			SOC0117SearchCondImpl entityCond = new SOC0117SearchCondImpl();
			entityCond.setEsyscoding(CommonDefineUtils.ENTIY_CATEGORY_DEVICE_SYSCODING);
			List<SOC0117Info> entity = this.soc0117BL.searchEntity(entityCond, 0, 0);
			
			if(entity.size() != 1) {
				throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.018"));
			} else {
				dto.setEname(entity.get(0).getEname());
				dto.setEsyscoding(entity.get(0).getEsyscoding());
			}
		}
		
		dto.setFlag(isRoleManager);
		
		return dto;
	}
	

	/**
	 * 0605�豸��Ϣ��ѯ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGVIR06DTO searchEntityItem0605Action(IGVIR06DTO dto) throws BLException {

		log.debug("========�豸��Ϣ��ѯ����ʼ========");
		
		//�豸��Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(dto.getEntityItemVWSearchCond());
		
		if (totalCount == 0) {
			log.debug("========�豸��Ϣ��ѯ���ݲ�����========");
			//�豸��Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�豸��Ϣ��ѯ���ݼ�������========");
			//�豸��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳ�豸��Ϣȡ��
		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL.searchEntityItemVW(dto.getEntityItemVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemVWInfoList(entityItemVWInfoList);

		Integer domainid = EiDomainKeyWords.DOOMAIN_ID_DEFAULT;
		SOC0111Info domain  = this.soc0111BL.searchDomainMaxVersion(domainid);
		Integer domainversion = domain.getVersion();
		String createtime = domain.getUpdatetime();
		String showRelation = "N";
		Map<String,String> showRelationMap = new HashMap<String,String>();
		if(entityItemVWInfoList!=null){
			//���������������洢���Բ鿴��ϵ
			// ���洢��Ϊֻ�鿴DMX�洢 --20130607 yanglongquan
			for(SOC0124Info bean:entityItemVWInfoList){
				if(bean.getEsyscoding().startsWith(EiRelationKeyWords.HOST) 
						|| bean.getEsyscoding().startsWith(EiRelationKeyWords.SWITCH)
						|| bean.getEsyscoding().startsWith(EiRelationKeyWords.STORAGE_DMX)) {
					showRelation = "Y";
				}else{
					showRelation = "N";
				}
				showRelationMap.put(String.valueOf(bean.getEiid()), showRelation);
			}
		}
		dto.setDomainid(domainid);
		dto.setDomainversion(domainversion);
		dto.setCreatetime(createtime);
		dto.setShowRelationMap(showRelationMap);
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========�豸��Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * 0606�豸��Ϣ��ѯ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGVIR06DTO searchEntityItem0606Action(IGVIR06DTO dto) throws BLException {

		log.debug("========�豸��Ϣ��ѯ����ʼ========");
		
		//�豸��Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(dto.getEntityItemVWSearchCond());
		
		if (totalCount == 0) {
			log.debug("========�豸��Ϣ��ѯ���ݲ�����========");
			//�豸��Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�豸��Ϣ��ѯ���ݼ�������========");
			//�豸��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳ�豸��Ϣȡ��
		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL.searchEntityItemVW(dto.getEntityItemVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemVWInfoList(entityItemVWInfoList);

		Integer domainid = EiDomainKeyWords.DOOMAIN_ID_DEFAULT;
		SOC0111Info domain  = this.soc0111BL.searchDomainMaxVersion(domainid);
		Integer domainversion = domain.getVersion();
		String createtime = domain.getUpdatetime();
		String showRelation = "N";
		Map<String,String> showRelationMap = new HashMap<String,String>();
		if(entityItemVWInfoList!=null){
			//���������������洢���Բ鿴��ϵ
			// ���洢��Ϊֻ�鿴DMX�洢 --20130607 yanglongquan
			for(SOC0124Info bean:entityItemVWInfoList){
				if(bean.getEsyscoding().startsWith(EiRelationKeyWords.HOST) 
						|| bean.getEsyscoding().startsWith(EiRelationKeyWords.SWITCH)
						|| bean.getEsyscoding().startsWith(EiRelationKeyWords.STORAGE_DMX)) {
					showRelation = "Y";
				}else{
					showRelation = "N";
				}
				showRelationMap.put(String.valueOf(bean.getEiid()), showRelation);
			}
		}
		dto.setDomainid(domainid);
		dto.setDomainversion(domainversion);
		dto.setCreatetime(createtime);
		dto.setShowRelationMap(showRelationMap);
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========�豸��Ϣ��ѯ��������========");
		return dto;
	}
	
}
