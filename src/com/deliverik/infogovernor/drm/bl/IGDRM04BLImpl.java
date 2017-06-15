/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.bl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;
import org.apache.struts.util.LabelValueBean;
import org.springframework.beans.BeanUtils;

import com.deliverik.framework.asset.bl.task.IG611BL;
import com.deliverik.framework.asset.model.IG612Info;
import com.deliverik.framework.asset.model.condition.IG611SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG912SearchCondImpl;
import com.deliverik.framework.asset.model.entity.IG013TB;
import com.deliverik.framework.asset.model.entity.IG611TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0107VWBL;
import com.deliverik.framework.soc.asset.bl.task.SOC0109BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0109VWBL;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0117VWBL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118VWBL;
import com.deliverik.framework.soc.asset.bl.task.SOC0119BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0151BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0151VWBL;
import com.deliverik.framework.soc.asset.model.ConfigurationCodeDetailBean;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0109VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0117VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0109VWSearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0117VWSearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0118VWSearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0151SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0107TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0109TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0117TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0117VWPK;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0118VWPK;
import com.deliverik.framework.soc.asset.model.entity.SOC0119TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0129VW;
import com.deliverik.framework.soc.asset.model.entity.SOC0151TB;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.asset.bl.IGASM05BLImpl;
import com.deliverik.infogovernor.drm.bl.task.EmergencyResourceBL;
import com.deliverik.infogovernor.drm.bl.task.ErRelationBL;
import com.deliverik.infogovernor.drm.dto.IGDRM04DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0401Form;
import com.deliverik.infogovernor.drm.form.IGDRM0402Form;
import com.deliverik.infogovernor.drm.form.IGDRM0404Form;
import com.deliverik.infogovernor.drm.form.IGDRM0406Form;
import com.deliverik.infogovernor.drm.form.IGDRM0408Form;
import com.deliverik.infogovernor.drm.form.IGDRM0411Form;
import com.deliverik.infogovernor.drm.form.IGDRM0412Form;
import com.deliverik.infogovernor.drm.form.IGDRM0414Form;
import com.deliverik.infogovernor.drm.form.IGDRM0418Form;
import com.deliverik.infogovernor.drm.form.IGDRM0421Form;
import com.deliverik.infogovernor.drm.form.IGDRM0424Form;
import com.deliverik.infogovernor.drm.form.IGDRM0430Form;
import com.deliverik.infogovernor.drm.model.EmergencyResourceInfo;
import com.deliverik.infogovernor.drm.model.ErRelationInfo;
import com.deliverik.infogovernor.drm.model.condition.EmergencyResourceSearchCondImpl;
import com.deliverik.infogovernor.drm.model.condition.ErRelationSearchCondImpl;
import com.deliverik.infogovernor.drm.model.entity.EmergencyResourceTB;
import com.deliverik.infogovernor.drm.model.entity.ErRelationTB;
import com.deliverik.infogovernor.sym.bl.IGSYM01BL;
import com.deliverik.infogovernor.sym.bl.IGSYM02BL;
import com.deliverik.infogovernor.sym.dto.IGSYM01DTO;
import com.deliverik.infogovernor.sym.dto.IGSYM02DTO;
import com.deliverik.infogovernor.util.DateUtils;
import com.google.gson.Gson;

/**
 * Ӧ����Դ����BLʵ��
 * 
 * @author �Ž�
 *
 * 2015-2-12 ����11:07:19
 */
public class IGDRM04BLImpl implements IGDRM04BL {
	
	static Log log = LogFactory.getLog(IGDRM04BLImpl.class);
	
	protected SOC0118BL soc0118BL;
	
	protected SOC0117BL soc0117BL;
	
	protected SOC0109BL soc0109BL;
	
	protected SOC0107BL soc0107BL;
	
	protected SOC0118VWBL soc0118VWBL;
	
	protected SOC0117VWBL soc0117VWBL;
	
	protected SOC0109VWBL soc0109VWBL;
	
	protected SOC0107VWBL soc0107VWBL; 
	
	protected SOC0151VWBL soc0151VWBL;
	/** �ļ��ϴ�BL */
	protected FileUploadBL fileUploadBL;
	
	protected OrganizationBL organizationBL;
	
	protected SOC0119BL soc0119BL;
	
	protected SOC0151BL soc0151BL;
	
	protected CodeDetailBL codeDetailBL;

	/** Ӧ����Դ�ʲ���ϵBL */
	protected ErRelationBL erRelationBL;

	/** Ӧ����Դ��ģ��BL */
	protected EmergencyResourceBL emergencyResourceBL;
	
	

	/**
	 * @param soc0151vwbl the soc0151VWBL to set
	 */
	public void setSoc0151VWBL(SOC0151VWBL soc0151vwbl) {
		soc0151VWBL = soc0151vwbl;
	}

	/**
	 * @param soc0118vwbl the soc0118VWBL to set
	 */
	public void setSoc0118VWBL(SOC0118VWBL soc0118vwbl) {
		soc0118VWBL = soc0118vwbl;
	}

	/**
	 * @param soc0117vwbl the soc0117VWBL to set
	 */
	public void setSoc0117VWBL(SOC0117VWBL soc0117vwbl) {
		soc0117VWBL = soc0117vwbl;
	}

	/**
	 * @param soc0109vwbl the soc0109VWBL to set
	 */
	public void setSoc0109VWBL(SOC0109VWBL soc0109vwbl) {
		soc0109VWBL = soc0109vwbl;
	}

	/**
	 * @param soc0107vwbl the soc0107VWBL to set
	 */
	public void setSoc0107VWBL(SOC0107VWBL soc0107vwbl) {
		soc0107VWBL = soc0107vwbl;
	}

	/**
	 * @param soc0151bl the soc0151BL to set
	 */
	public void setSoc0151BL(SOC0151BL soc0151bl) {
		soc0151BL = soc0151bl;
	}

	/**
	 * @param erRelationBL the erRelationBL to set
	 */
	public void setErRelationBL(ErRelationBL erRelationBL) {
		this.erRelationBL = erRelationBL;
	}

	/**
	 * @param emergencyResourceBL the emergencyResourceBL to set
	 */
	public void setEmergencyResourceBL(EmergencyResourceBL emergencyResourceBL) {
		this.emergencyResourceBL = emergencyResourceBL;
	}

	/**
	 * ��ʼ��Ӧ����Դ����ҳ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM04DTO init0401Action(IGDRM04DTO dto) throws BLException{
		
		log.info("==========Ӧ����Դ�Ǽǳ�ʼ����ʼ============");
		
		
//		Integer eiid = dto.getIgdrm0401Form().getEiid();
		String eiid = dto.getIgdrm0401Form().getEiidstr();
		IGDRM0401Form form = new IGDRM0401Form();
		form.setEiid(Integer.parseInt(eiid.split("_")[1]));
		form.setEiidstr(eiid);
		if(StringUtils.isNotEmpty(eiid)){
			SOC0118VWInfo soc0124 = soc0118VWBL.searchEntityItemByKey(new SOC0118VWPK(Integer.parseInt((eiid+"").split("_")[0]), Integer.parseInt((eiid+"").split("_")[1])));
			SOC0129SearchCondImpl cond = new SOC0129SearchCondImpl();
			cond.setId((eiid+"").split("_")[0]);
			cond.setEiid((eiid+"").split("_")[1]);
			cond.setEsyscoding_q(soc0124.getEsyscoding());
			List<SOC0129Info> soc0129List = soc0107BL.searchConfigItemVW(cond);
			dto.setConfigItemList(soc0129List);
			dto.setEntityItemVW(soc0124);
			form.setEiname(soc0124.getEiname());
			form.setEilabel(soc0124.getEilabel());
			form.setEiinsdate(soc0124.getEiinsdate());
			form.setEsyscoding(soc0124.getEsyscoding());
			dto.setIgdrm0401Form(form);
		}else{
			String eid = "CM40000000";
			SOC0109VWSearchCondImpl cond = new SOC0109VWSearchCondImpl();
			cond.setEid(eid);
			List<SOC0109VWInfo> soc0119List = soc0109VWBL.searchConfiguration(cond);
			dto.setConfigurationList(soc0119List);
		}
		
		
		log.info("==========Ӧ����Դ�Ǽǳ�ʼ������============");
		
		return dto;
	}
	
	/**
	 * Ӧ����Դ������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO initIGDRM0404Action(IGDRM04DTO dto) throws BLException {

		log.debug("========Ӧ����Դ������Ϣ�༭������ڻ�����ʼ========");
		
		IGDRM0404Form form = dto.getIgdrm0404Form();
		
		//Ӧ����Դ��Ϣ����
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				Integer.parseInt(form.getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","Ӧ����Դ");
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
//		dto.setEntityItemVW(entityItemVWInfo);
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		
		//Ӧ����Դ������Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0107BL.getConfigItemVWSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========Ӧ����Դ������Ϣ��ѯ���ݲ�����========");
			//Ӧ����Դ������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========Ӧ����Դ������Ϣ��ѯ���ݼ�������========");
			//Ӧ����Դ������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//Ӧ����Դ������Ϣȫ����ѯ
		List<SOC0129Info> configItemVWInfoList = this.soc0107BL.searchConfigItemVW(
				form, 0, 0);
		
		String[] civalue = new String[totalCount];
		String[] delfile = new String[totalCount];
		String[] entityItemCivalue = new String[totalCount];
		String[] isUpgrade=new String[totalCount];
		//��žɰ汾ֵ
		String[] civalue_bak = new String[totalCount];
		Map<String,List<SOC0129Info>> map = new LinkedHashMap<String,List<SOC0129Info>>();
		int i = 0;
		int j = 0;
		List<String> strlist = new ArrayList<String>();
		Map<String, String> cldVersionMap=new HashMap<String, String>();//���ʲ��汾����
		for(SOC0129Info e : configItemVWInfoList){
			if("4".equals(e.getCattach())){
				String value = e.getCivalue();
				if(StringUtils.isNotEmpty(value)){
					Integer cldeiid = Integer.parseInt(value.substring(value.lastIndexOf("(")+1, value.length()-1));//���ʲ�eiid
					
					SOC0119SearchCondImpl cond=new SOC0119SearchCondImpl();
					cond.setPareiid(Integer.parseInt(form.getEiid()));
					cond.setCldeiid(cldeiid);
					cond.setParversion(entityItemVWInfo.getEiversion());
					cond.setEirinfo("_"+e.getCiid()+"_");
					cond.setDeleteflag("0");
					List<SOC0119Info> soc0119Info = soc0119BL.searchEntityItemRelation(cond);
					String cldversion="";
					if(soc0119Info!=null&&soc0119Info.size()>0){
						cldversion = String.valueOf(soc0119Info.get(0).getCldversion());//���ʲ��汾
					}
					cldVersionMap.put(cldeiid.toString(), cldversion);
				}
			}
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
		form.setCldVersionMap(cldVersionMap);
		for(String str : strlist){
			for(SOC0129Info e : map.get(str)){
				//��ʾ���ʲ����ƣ�ʵ�ʴ�ֵ���ʲ�����(�ʲ�ID)
				if("4".equals(e.getCattach()) && StringUtils.isNotEmpty(e.getCivalue())){
					civalue[i] = e.getCivalue().substring(0, e.getCivalue().lastIndexOf("("));
					isUpgrade[i]= e.getCivalue().substring(e.getCivalue().lastIndexOf("(")+1, e.getCivalue().lastIndexOf(")"));
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
		form.setDelfile(delfile);
		form.setCivalue_bak(civalue_bak);
		form.setIsUpgrade(isUpgrade);
		dto.setConfigItemVWInfoMap(map);
//		dto.addMessage(new ActionMessage("IGCO10000.I007",totalCount));


		
		log.debug("========Ӧ����Դ������Ϣ�༭������ڻ���������========");
		return dto;
	}
	/**
	 * �豸������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO initIGDRM0430Action(IGDRM04DTO dto) throws BLException {

		log.debug("========�豸������Ϣ�༭������ڻ�����ʼ========");
		
		IGDRM0430Form form = dto.getIgdrm0430Form();
		String eiidstr = form.getEiid();
		String id = form.getId();
		//�豸��Ϣ����
		SOC0118VWInfo entityItemVWInfo = soc0118VWBL.searchEntityItemByKey(new SOC0118VWPK(Integer.parseInt(id), Integer.parseInt(eiidstr)));

		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","�豸");
		}
		
		form.setEidesc(entityItemVWInfo.getEidesc());
		form.setEistatus(entityItemVWInfo.getEistatus());
//		form.setEmodeltype(entityItemVWInfo.getEmodeltype());
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
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118VWBL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		
		//�豸������Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0107VWBL.getConfigItemVWSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========�豸������Ϣ��ѯ���ݲ�����========");
			//�豸������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�豸������Ϣ��ѯ���ݼ�������========");
			//�豸������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//������������Ϣȫ����ѯ
		List<SOC0129Info> configItemVWInfoList = this.soc0107VWBL.searchConfigItemVW(
				form, 0, 0);
		
		String[] civalue = new String[totalCount];
		String[] delfile = new String[totalCount];
		String[] entityItemCivalue = new String[totalCount];
		String[] isUpgrade=new String[totalCount];
		//��žɰ汾ֵ
		String[] civalue_bak = new String[totalCount];
		Map<String,List<SOC0129Info>> map = new LinkedHashMap<String,List<SOC0129Info>>();
		int i = 0;
		List<String> strlist = new ArrayList<String>();
		Map<String, String> cldVersionMap=new HashMap<String, String>();//���ʲ��汾����
		for(SOC0129Info e : configItemVWInfoList){
			if("4".equals(e.getCattach())){
				String value = e.getCivalue();
				if(StringUtils.isNotEmpty(value)){
					String cldeiid = value.substring(value.lastIndexOf("(")+1, value.length()-1);//���ʲ�eiid
					
					SOC0119SearchCondImpl cond=new SOC0119SearchCondImpl();
					cond.setPareiid(Integer.parseInt(form.getEiid()));
					if(cldeiid!=null){
					cond.setCldeiid(Integer.parseInt(cldeiid));}
					cond.setParversion(Integer.parseInt(entityItemVWInfo.getEiversion()));
					cond.setEirinfo("_"+e.getCiid()+"_");
					cond.setDeleteflag("0");
//					List<SOC0119VWInfo> ig313Info = soc0119VWBL.searchEntityItemRelation(cond);
//					String cldversion="";
//					if(ig313Info!=null&&ig313Info.size()>0){
//						cldversion = String.valueOf(ig313Info.get(0).getCldversion());//���ʲ��汾
//					}
//					cldVersionMap.put(cldeiid, cldversion);
				}
			}
			if(!map.containsKey(e.getCcategory())){
				map.put(e.getCcategory(), new ArrayList<SOC0129Info>());
				strlist.add(e.getCcategory());
			}
			map.get(e.getCcategory()).add(e);
//			if("IG_0012".equals(e.getClabel())){
//				List<LabelValueBean> list = new ArrayList<LabelValueBean>();
//				list.add(new LabelValueBean("", ""));
//				SOC0601SearchCondImpl soc0601cond = new SOC0601SearchCondImpl();
//				List<SOC0601Info> soc0601List = soc0601BL.searchSOC0601Info(soc0601cond);
//				for(SOC0601Info ccd : soc0601List){
//					list.add(new LabelValueBean(ccd.getEiname(), ccd.getEiname()));
//				}
//				form.setSelectedListMap(j++, list);
//				continue;
//			}
//			
//			if("IG_0013".equals(e.getClabel())){
//				List<LabelValueBean> list = new ArrayList<LabelValueBean>();
//				if(e.getCivalue()!=null && !(e.getCivalue().equals(""))){
//					dto.setArea(e.getCivalue());					
//				}
//				form.setSelectedListMap(j++, list);
//				continue;
//			}
//			if("IG_0014".equals(e.getClabel())){
//				List<LabelValueBean> list = new ArrayList<LabelValueBean>();
//				list.add(new LabelValueBean("", ""));
//				SOC0603SearchCondImpl soc0603cond = new SOC0603SearchCondImpl();
//				List<SOC0603Info> soc0603List = soc0603BL.searchSOC0603Info(soc0603cond);
//				for(SOC0603Info ccd : soc0603List){
//					list.add(new LabelValueBean(ccd.getEiname(), ccd.getEiname()));
//				}
//				form.setSelectedListMap(j++, list);
//				continue;
//			}
			if("2".equals(e.getCattach())){
//				List<LabelValueBean> list = soc0151BL.searchLabelValueBeanList(e.getCoption());
//				form.setSelectedListMap(j++, list);
			}
			if("5".equals(e.getCattach())){
//				List<LabelValueBean> list = soc0151BL.searchLabelValueBeanList(e.getCoption());
//				if(list.size() > 0){
//					list.remove(0);
//				}
//				form.setSelectedListMap(j++, list);
			}
		}
		form.setCldVersionMap(cldVersionMap);
		for(String str : strlist){
			for(SOC0129Info e : map.get(str)){
				//��ʾ���ʲ����ƣ�ʵ�ʴ�ֵ���ʲ�����(�ʲ�ID)
				if("4".equals(e.getCattach()) && StringUtils.isNotEmpty(e.getCivalue())){
					civalue[i] = e.getCivalue().substring(0, e.getCivalue().lastIndexOf("("));
					isUpgrade[i]= e.getCivalue().substring(e.getCivalue().lastIndexOf("(")+1, e.getCivalue().lastIndexOf(")"));
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
		form.setDelfile(delfile);
		form.setCivalue_bak(civalue_bak);
		form.setIsUpgrade(isUpgrade);
		dto.setConfigItemVWInfoMap(map);
//		dto.addMessage(new ActionMessage("IGCO10000.I007",totalCount));
		
		
		//��ȡ��ʷ�汾����ʱ��
		if(Integer.parseInt(entityItemVWInfo.getEiversion()) > 0) {
//			dto.setConfigItemVersionTime(this.soc0118VWBL.searchVersionUpdateTime(entityItemVWInfo.getEiid()));
		}

    	IG912SearchCondImpl cond = new IG912SearchCondImpl();
    	cond.setInJiguiFlg("Y");
    	cond.setEiid(Integer.parseInt(form.getEiid()));
		//��ǰҳ�豸��Ϣȡ��
//		List<IG912Info> computerDeviceVWInfoList = ig912BL.searchIG912Info(cond,0,0);
//		if(computerDeviceVWInfoList!=null&&computerDeviceVWInfoList.size()>0){
//			dto.setInJiguiFlg("Y");
//		}else{
//			dto.setInJiguiFlg("N");
//		}
		log.debug("========�豸������Ϣ�༭������ڻ���������========");
		return dto;
	}
	/***
	 * ��ѯӦ����Դ�����б�
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM04DTO searchConfigList(IGDRM04DTO dto) throws BLException{//0129qwer
		log.info("==========Ӧ����Դ�����б��ȡ��ʼ============");
		
		IGDRM0401Form form = dto.getIgdrm0401Form();
//		Integer eiid = form.getEiid();
		String eiidstr = form.getEiidstr();
			////��ѯ ��������
			String esyscoding = form.getEsyscoding();
			if(StringUtils.isEmpty(esyscoding)){
				SOC0118VWInfo info = soc0118VWBL.searchEntityItemByKey(new SOC0118VWPK(Integer.parseInt(eiidstr.split("_")[0]), Integer.parseInt(eiidstr.split("_")[1])));
				esyscoding = info.getEsyscoding();
			}
			SOC0109VWSearchCondImpl cond = new SOC0109VWSearchCondImpl();
			cond.setId(Integer.parseInt(eiidstr.split("_")[0]));
			List<String> esyscodingList  = new ArrayList<String>();
			for(int i=6;i<=esyscoding.length();){
				esyscodingList.add(esyscoding);
				esyscoding = esyscoding.substring(0,esyscoding.length()-3);
			}
			cond.setEsyscodingList(esyscodingList);
			//����״̬
			cond.setCstatus("1");
			List<SOC0109VWInfo> soc0109List = soc0109VWBL.searchConfiguration(cond);
			
//			int j = 0;
//			for(int i=0;i<soc0109List.size();i++){
//				SOC0109VWInfo info = soc0109List.get(i);
//				//2:�����˵�
//				if("2".equals(info.getCattach())){
//					List<LabelValueBean> list = soc0151VWBL.searchLabelValueBeanList(info.getCoption(),Integer.parseInt((eiidstr+"").split("_")[0]));
//					dto.setSelectedListMap(j++, list);
//				}
//				if("5".equals(info.getCattach())){
//					List<LabelValueBean> list = soc0151BL.searchLabelValueBeanList(info.getCoption());
//					if(list.size() > 0){
//						list.remove(0);
//					}
//					form.setSelectedListMap(j++, list);
//				}
//			}
			
		//�޶��Ͳ鿴ҳ��
//			SOC0124Info soc0124 = soc0118BL.searchEntityItemVWByKey(eiid);
		SOC0118VWInfo soc0124 = soc0118VWBL.searchEntityItemByKey(new SOC0118VWPK(Integer.parseInt((eiidstr+"").split("_")[0]), Integer.parseInt((eiidstr+"").split("_")[1])));
		SOC0129SearchCondImpl soc0129cond = new SOC0129SearchCondImpl();
		soc0129cond.setId((eiidstr+"").split("_")[0]);
		soc0129cond.setEiid((eiidstr+"").split("_")[1]);
		soc0129cond.setEsyscoding_q(soc0124.getEsyscoding());
		//��ѯ�������Ѿ����ڵ�����ֵ��Ϣ
		List<SOC0129Info> soc0129List = soc0107BL.searchConfigItemVW(soc0129cond);
		
		//
		Map<String, SOC0129Info> configItemMap = new HashMap<String, SOC0129Info>(); 
		for (SOC0129Info soc0129Info : soc0129List) {
			configItemMap.put(soc0129Info.getCid(), soc0129Info);
		}
		//������ģ�͵�����,װ��û�и�ֵ��������
		for (SOC0109VWInfo soc0109Info : soc0109List) {
			//�������ֵ��û�� ���������е�һ�������һ���յ�����ֵ���б���
			if(!configItemMap.containsKey(soc0109Info.getCid())){
				SOC0129VW soc0129vw = new SOC0129VW();
				BeanUtils.copyProperties(soc0109Info, soc0129vw,new String[]{"cseq"});
//					soc0129vw.setCattach(soc0109Info.getCattach());
//					soc0129vw.setCcategory(soc0109Info.getCattach());
//					soc0129vw.setCdesc(soc0109Info.getCdesc());
//					soc0129vw.setCid(soc0109Info.getCid());
//					soc0129vw.setClabel(soc0109Info.getClabel());
//					soc0129vw.setCname(soc0109Info.getCname());
//					soc0129vw.setCoption(soc0109Info.getCoption());
//					soc0129vw.setCrequired(soc0109Info.getCrequired());
				soc0129vw.setCseq(soc0109Info.getCseq()+"");
//					soc0129vw.setCunit(soc0109Info.getCunit());
//					soc0129vw.setEid(soc0109Info.getEid());
//					soc0129vw.setEsyscoding(soc0109Info.getEsyscoding());
				soc0129List.add(soc0129vw);
			}else{
				//���� ɾ��map�е�������
				configItemMap.remove(soc0109Info.getCid());
			}
		}
		
		for(Iterator<SOC0129Info> it = configItemMap.values().iterator();it.hasNext();){
			SOC0129Info soc0129Info = it.next();
			soc0129List.remove(soc0129Info);
		}

		
		
		dto.setConfigItemList(soc0129List);
		dto.setEntityItemVW(soc0124);
		
		log.info("==========Ӧ����Դ�����б��ȡ����============");
		
		
		return dto;
	}
	
	/**
	 * Ӧ����Դ�Ǽ�������Ϣ�б�
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 * @throws IOException 
	 */
	public String getConfigList(IGDRM04DTO dto) throws BLException {
		IGDRM0412Form form = dto.getIgdrm0412Form();
		Map<String, String> nameMap = new HashMap<String, String>();
		SOC0117VWSearchCondImpl s117Cond = new SOC0117VWSearchCondImpl();
		String cids = "";
		String erid =form.getFingerPrint();
		String id = form.getEsyscoding().split("_")[0];
		String esyscoding = form.getEsyscoding().split("_")[2];
		s117Cond.setId(Integer.parseInt(id));
		s117Cond.setEsyscoding(esyscoding);
		List<SOC0117VWInfo> firstList = soc0117VWBL.searchEntity(s117Cond);
		if(firstList!=null&&firstList.size()>0){
			nameMap.put(esyscoding, firstList.get(0).getEname());
		}
		if(StringUtils.isNotEmpty(erid)){
			EmergencyResourceInfo erInfo = emergencyResourceBL.searchEmergencyResourceByPK(Integer.parseInt(erid));
			cids = erInfo.getErcids();
		}
		SOC0109VWSearchCondImpl cond = new SOC0109VWSearchCondImpl();
		cond.setId(Integer.parseInt(id));
		List<String> esyscodingList  = new ArrayList<String>();
		for(int i=6;i<=esyscoding.length();){
			esyscodingList.add(esyscoding);
			esyscoding = esyscoding.substring(0,esyscoding.length()-3);
			s117Cond.setEsyscoding(esyscoding);
			List<SOC0117VWInfo> s117List = soc0117VWBL.searchEntity(s117Cond);
			if(s117List!=null&&s117List.size()>0){//���̳�Ϊֹ
				if(s117List.get(0).getEkey2()!=null&&s117List.get(0).getEkey2() == "1") break;
				nameMap.put(esyscoding, s117List.get(0).getEname());
			}
		}
		cond.setEsyscodingList(esyscodingList);
		//����״̬
		cond.setCstatus("1");
		cond.setCcategory("ASCCCATEGORY");
		List<SOC0109VWInfo> soc0109VWList = soc0109VWBL.searchConfiguration(cond);
		Map<String , List<Map<String,String>>> finalMap = new LinkedHashMap<String, List<Map<String,String>>>();
		//ģ�ͷ����������
		CodeDetailBL codeDetailBL = (CodeDetailBL) WebApplicationSupport.getBean("codeDetailBL");
		CodeDetailSearchCondImpl ccond = new CodeDetailSearchCondImpl();
		ccond.setCcid("008");//���Է���
		List<CodeDetail> detailList = codeDetailBL.searchCodeDetailTree(ccond,2);
		Map<String, String> cdMap = new LinkedHashMap<String, String>();
		for(CodeDetail cd : detailList){
			cdMap.put(cd.getCid(), cd.getCvalue());
		}
		Set<String> ccategorySet = new LinkedHashSet<String>();//���˵�û�е�ģ��
		for(SOC0109VWInfo info : soc0109VWList){
			if(!ccategorySet.contains(info.getCcategory()))
				ccategorySet.add(info.getCcategory());
		}
		Iterator<String> it = ccategorySet.iterator();
		while (it.hasNext()) {  
			String str = it.next();  
			List<Map<String,String>> ccategoryList = new ArrayList<Map<String,String>>();
			for(SOC0109VWInfo info : soc0109VWList){
				Map<String,String> map = null ;
				if(str.equals(info.getCcategory())){
					map = new HashMap<String, String>();
					map.put("cid", info.getCid());
					map.put("cname", info.getCname());
					map.put("esyscoding", info.getEsyscoding());
					map.put("codename", nameMap.get(info.getEsyscoding()));
					map.put("ccategory", nameMap.get(info.getCcategory()));
					if("new".equals(form.getFlag())){
						map.put("checked", "0");
					}else{
						if(cids.indexOf(info.getCid())>-1) {
							map.put("checked", "1");
						} else{
							map.put("checked", "0");
						}
					}
				}
				if(map!=null)
					ccategoryList.add(map);
			}
			if(ccategoryList.size()>0)
			finalMap.put(str + "_" + cdMap.get(str), ccategoryList);
		} 
		Gson g = new Gson();
		return g.toJson(finalMap);
	}
	/**
	 * Ӧ����Դ������Ϣ�༭����
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGDRM04DTO editEntityItemAction(IGDRM04DTO dto) throws BLException, FileNotFoundException, IOException {
		log.debug("========Ӧ����Դ������Ϣ�༭����ʼ========");
		//�汾������
		IGDRM0404Form form = dto.getIgdrm0404Form();
		//Ӧ����Դ������Ϣ����
		SOC0118TB entityItem = (SOC0118TB) this.soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getEiid()));
		// ȡ�ð汾�Ƿ�������ʶ
		String ident = form.getIdent();
		if(StringUtils.isEmpty(ident)){
			ident = IGASM05BLImpl.SAVE_VERSION;
		}
		// �汾�ų�ʼ��
		int version = 1;
		boolean versonFlag = false;
		// �ж��Ƿ������汾��
		// =====================>> �޸� start
		if (IGASM05BLImpl.SAVE_VERSION_UP.equals(ident)) { // �����汾��
			version = form.getEiversion() + 1;
			
			//�����Ƿ��ϵ������ѡ���ж��ĸ��ʲ���ϵ����
			String[] cldeiids=new String[form.getCiid().length];
			int index=0;
			if(form.getIsUpgrade()!=null&&form.getIsUpgrade().length>0){
                for(int i=0;i<form.getIsUpgrade().length;i++){
                    if(form.getIsUpgrade()[i]!=null&&"1".equals(form.getIsUpgrade()[i])){
                        if(form.getEntityItemCivalue()[i].lastIndexOf("(") != -1 && form.getEntityItemCivalue()[i].lastIndexOf(")") != -1){
                            String cldeiid=form.getEntityItemCivalue()[i].substring(form.getEntityItemCivalue()[i].lastIndexOf("(")+1,
                                    form.getEntityItemCivalue()[i].lastIndexOf(")"));
                            //���ʲ�������Ϣ
                            IG013TB cldEntityItem = (IG013TB) this.soc0118BL.searchEntityItemByKey(Integer.parseInt(cldeiid));
                            if(cldEntityItem!=null){
                            	 cldeiids[index]=cldeiid+"_"+cldEntityItem.getEiversion()+"_"+cldEntityItem.getEismallversion()+"_"+form.getCiid()[i];
                            }
                        }
                        index++;
                    }
                }
            }
			
//			//�ʲ���ϵ��Ϣ�汾��������
			this.soc0119BL.upgradeEntityItemRelationOne(entityItem.getEiid(), entityItem.getEiversion(), entityItem.getEismallversion(),
					version, 0,cldeiids);
			
			if (version - 1 != entityItem.getEiversion()) {
				throw new BLException("IGCO00000.E004");
			}
		} else if (IGASM05BLImpl.SAVE_VERSION.equals(ident)) { // �������汾��

			version = form.getEiversion();
			if (version != entityItem.getEiversion()) {
				throw new BLException("IGCO00000.E004");
			}

			if (form.getEiversion() == 0) { // ���Ϊ��һ��ʱ�趨�汾��Ϊ ��1��
				versonFlag = true;
				version = 1;
			}
		}
		//  << =================  end
		
		//�汾
		entityItem.setEiversion(version);
		
		entityItem.setEidesc(form.getEidesc());
		
		entityItem.setEid(form.getEid_q());

		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		
		
		//����ʱ��
		entityItem.setEiupdtime(datetime);
		
		entityItem.setEsyscoding(form.getEsyscoding_q());
		
		entityItem.setEid(form.getEid()[0]);
		
		//====================add at 2013-03-24 start========================
		if(StringUtils.isNotEmpty(form.getEiname())){
			entityItem.setEiname(form.getEiname());
		}
		if(StringUtils.isNotEmpty(form.getEiinsdate())){
			entityItem.setEiinsdate(form.getEiinsdate());
		}
		if(StringUtils.isNotEmpty(form.getEilabel())){
			entityItem.setEilabel(form.getEilabel());
		}
		//====================add at 2013-03-24 end========================
		
		this.soc0118BL.updateEntityItem(entityItem);
		//=======���¹�ϵ��ʼ========
		if(version ==1&&versonFlag){
			SOC0119SearchCondImpl eircond1 = new SOC0119SearchCondImpl();
			//ɾ����ʶ
			eircond1.setDeleteflag("0");
			//����ʲ���صĹ�ϵ��
			eircond1.setEirrelationcode(IGASM05BLImpl.EIRRELATIONCODE);
			eircond1.setEiid(String.valueOf(entityItem.getEiid()));
			//���ʲ����еĹ�ϵ��Ϣ
			List<SOC0119Info> soc0119InfoList = this.soc0119BL.searchMaxEntityItemRelation(eircond1);
			if(soc0119InfoList!=null&&soc0119InfoList.size()>0){
				for(SOC0119Info soc0119Info:soc0119InfoList){
					SOC0119TB soc0119tb=new SOC0119TB();
					soc0119tb.setPareiid(soc0119Info.getPareiid());
					soc0119tb.setPareid(soc0119Info.getPareid());
					soc0119tb.setParsmallversion(soc0119Info.getParsmallversion());
					soc0119tb.setParversion(soc0119Info.getParversion());
					soc0119tb.setCldeiid(soc0119Info.getCldeiid());
					soc0119tb.setCldeid(soc0119Info.getCldeid());
					soc0119tb.setCldsmallversion(soc0119Info.getCldsmallversion());
					soc0119tb.setCldversion(soc0119Info.getCldversion());
					soc0119tb.setEirdesc(soc0119Info.getEirdesc());
					soc0119tb.setEirinfo(soc0119Info.getEirinfo());
					soc0119tb.setEirrelation(soc0119Info.getEirrelation());
					soc0119tb.setEirrelationcode(soc0119Info.getEirrelationcode());
					soc0119tb.setDeleteflag(soc0119Info.getDeleteflag());
					soc0119tb.setEirstatus(soc0119Info.getEirstatus());
					soc0119tb.setEirupdtime(soc0119Info.getEirupdtime());
					soc0119tb.setFingerPrint(soc0119tb.getFingerPrint());
					//�����ϵʱ
					if(entityItem.getEiid().equals(soc0119Info.getPareiid())){
						soc0119tb.setParversion(entityItem.getEiversion());
						this.soc0119BL.registEntityItemRelation(soc0119tb);
					}
					//�����ϵʱ
					if(entityItem.getEiid().equals(soc0119Info.getCldeiid())){
						soc0119tb.setCldversion(entityItem.getEiversion());
						this.soc0119BL.registEntityItemRelation(soc0119tb);
					}
				}
			}
		}
		//=======���¹�ϵ����========
		
		//���ø���BL
		
		//Ӧ����Դ������Ϣ����
		if (form.getCiid() != null && form.getCiid().length > 0 ) {
			
			for( int i=0 ; i < form.getCiid().length; i++ ){
				SOC0107TB configItem = new SOC0107TB();
				//Ӧ����ԴID
				configItem.setEiid(Integer.parseInt(form.getEiid()));
				//�ʲ�����ID
				configItem.setCid(form.getCid()[i]);
				//����ID
				configItem.setEid(form.getEid()[i]);
				//���Ͳ����
				configItem.setEsyscoding(form.getEsyscoding()[i]);
				//����
				if("CI070000000011".equalsIgnoreCase(form.getCid()[i])){
					configItem.setCivalue(version+"");
				}else {
					configItem.setCivalue(form.getCivalue()[i]);
				}
				//��汾��
				configItem.setCiversion(version);
				//С�汾��
				configItem.setCismallversion(0);
				//����ʱ��
				configItem.setCiupdtime(datetime);
				
				//��ʾ���ʲ����ƣ�ʵ�ʴ�ֵ���ʲ�����(�ʲ�ID)
				if("4".equals(form.getCiattach()[i]) && StringUtils.isNotEmpty(form.getEntityItemCivalue()[i])){
					configItem.setCivalue(form.getEntityItemCivalue()[i]);
				}
				
				//����ɾ��
				if("1".equals(form.getCiattach()[i]) && "1".equals(form.getDelfile()[i])){
					configItem.setCivalue("");
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
					if("4".equals(form.getCiattach()[i]) && StringUtils.isNotEmpty(form.getCivalue()[i])){
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
						e.setEirdesc("�������"+cname+"����");
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
					
					// �ж��Ƿ������汾��
					if (IGASM05BLImpl.SAVE_VERSION_UP.equals(ident)) { // �����汾��

						configItem = (SOC0107TB) this.soc0107BL.registSOC0107(configItem);

					} else if (IGASM05BLImpl.SAVE_VERSION.equals(ident)) { // �������汾��
					
						Integer ciid = Integer.valueOf(form.getCiid()[i]); 
						
						// ��ѯ��ǰ������
						SOC0107Info cfi = this.soc0107BL.searchSOC0107ByKey(ciid);
						
						// �жϵ�ǰ�������Ƿ���������
						if(configItem.getCid().equals(cfi.getCid())){ // ����������������и���
							
							configItem.setCiid(ciid);
							configItem = (SOC0107TB) this.soc0107BL
								.updateSOC0107(configItem);
							
						}else{  // �����������������
							
							configItem = (SOC0107TB) this.soc0107BL
							.registSOC0107(configItem);
							
						}
					}
					
					//�������Ϊ�ʲ�ʱ�����ӹ�����ϵ
					if("4".equals(form.getCiattach()[i]) && StringUtils.isNotEmpty(form.getCivalue()[i])){
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
						SOC0119SearchCondImpl condPar = new SOC0119SearchCondImpl();
						condPar.setPareiid(entityItem.getEiid());//�ʲ�ID
						condPar.setParversion(entityItem.getEiversion());//�ʲ���汾
						condPar.setParsmallversion(entityItem.getEismallversion());//�ʲ�С�汾
						condPar.setDeleteflag("0");
						condPar.setEirstatus("C");
						condPar.setEirinfo(entityItem.getEiid()+"_"+form.getCiid()[i]+"_"+ei.getEiid());
						
						List<SOC0119Info> eirlist = this.soc0119BL.searchEntityItemRelation(condPar);
						
						if(eirlist.isEmpty()){
							//ɾ��ԭ�����еĹ�ϵ
							SOC0119SearchCondImpl eircond = new SOC0119SearchCondImpl();
							eircond.setEirinfo(entityItem.getEiid()+"_"+form.getCiid()[i]+"_");
							eircond.setEirstatus("C");
							eircond.setDeleteflag("0");
							List<SOC0119Info> eir = this.soc0119BL.searchMaxEntityItemRelation(eircond);
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
							e.setEirdesc("�������"+cname+"����");
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
						eircond.setDeleteflag("0");
						List<SOC0119Info> eir = this.soc0119BL.searchMaxEntityItemRelation(eircond);
						for (SOC0119Info entityItemRelation : eir) {
							this.soc0119BL.deleteEntityItemRelation(entityItemRelation);
						}
					}
					log.debug("�ʲ������[�ʲ�����ID:" + form.getCid()[i] + "]���´���ɹ���");
				}
				//ɾ�������������ϴ�zyl
//				if(form.getDelfile().length<i&&StringUtils.isEmpty(form.getDelfile()[i]))
				if(form.getDelfile()[i]==null)
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
						//Ӧ����ԴID
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
	
		dto.addMessage(new ActionMessage("IGCO10000.I005","Ӧ����Դά��"));
		
		log.debug("========Ӧ����Դ������Ϣ�༭��������========");
		
		return dto;
	}
	
	
	
	/**
	 * Ӧ����Դ��ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM04DTO searchEmergencyResource(IGDRM04DTO dto)throws BLException{
		
		log.info("============Ӧ����Դ�б��ѯ��ʼ==============");
		
		IGDRM0402Form form = dto.getIgdrm0402Form();
		
 		dto.setRootEsyscoding("000");
		this.initNewNodeMap(dto);//�°�Ӧ����Դ��
		SOC0118VWSearchCondImpl cond = new SOC0118VWSearchCondImpl();
		cond.setEiname(form.getEiname());
		cond.setEiusername(form.getEiusername());
		cond.setEiinsdate_gt(form.getPropentime());
		cond.setEiinsdate_lt(form.getPrclosetime());
		cond.setEsyscoding_like(form.getErcode());
		cond.setEiidNotIn(form.getEiidNotIn());
		cond.setResourceType(form.getResourceType());
		// Ӧ����Դ��ѯ����ȡ��
		int totalCount = this.soc0118VWBL.getEmergencyRelationCount(cond );
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========"); 
			// Ӧ����Դ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
 
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========�ʲ�������Ϣ��ѯ���ݼ�������========");
			// Ӧ����Դ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}

		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		int from = pDto.getFromCount();
		int to = pDto.getPageDispCount();
		List<SOC0118VWInfo> entitys = this.soc0118VWBL.getEmergencyRelationList(cond, from, to);
		// Ӧ����Դȡ��
		pDto.setTotalCount(totalCount);
	

		dto.setEntityVWItemList(entitys);

		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		
		log.info("============Ӧ����Դ�б��ѯ����==============");
		return dto;
		
	}
	public List<SOC0118VWInfo> getList(List<SOC0118VWInfo> list ,int from ,int to){
		List<SOC0118VWInfo> newList = new LinkedList<SOC0118VWInfo>();
		newList = list.subList(from, to);
		return newList;
		
	}
	/**
	 * ��ʼ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM04DTO initNodeMap(IGDRM04DTO dto)throws BLException{
		
		List<Map<String, Object>> soc0117List = soc0117BL.getEntityNum(dto.getRootEsyscoding());
		Hashtable<String,TreeNode> tempMap = new Hashtable<String, TreeNode>();
		Map<String,TreeNode> allNode = new HashMap<String, TreeNode>();
		for(Map<String, Object> map : soc0117List){
			TreeNode node = new TreeNode();
			node.setId(map.get("ESYSCODING").toString());
			node.setRemark(map.get("EPARCODING").toString());
			//�豸��Ϣ��ѯ����ȡ�� 
			node.setName(map.get("ENAME").toString()+"("+map.get("ACCOUNT").toString()+")");
			
			if(allNode.get(map.get("EPARCODING").toString())==null){
				tempMap.put(map.get("ESYSCODING").toString(), node);
			} else{
				allNode.get(map.get("EPARCODING").toString()).addChildTreeNode(map.get("ESYSCODING").toString(), node);
			}
			allNode.put(map.get("ESYSCODING").toString(), node);	
		}
		dto.setNodeMap(tempMap);
		
		return dto;
	}
	/**
	 * ��ʼ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM04DTO initNewNodeMap(IGDRM04DTO dto)throws BLException{
		
		List<Map<String, Object>> soc0117List = soc0117BL.getEntityNumNEW(dto.getRootEsyscoding(),dto.getResourceType());
		Hashtable<String,TreeNode> tempMap = new Hashtable<String, TreeNode>();
		Map<String,TreeNode> allNode = new HashMap<String, TreeNode>();
		for(Map<String, Object> map : soc0117List){
			TreeNode node = new TreeNode();
			node.setId(map.get("ERCODE").toString());
			node.setRemark(map.get("ERID").toString()+"_"+map.get("ESYSCODING").toString());
//			node.setRemark(map.get("ERPARCODE").toString());
			//�豸��Ϣ��ѯ����ȡ�� 
			node.setName(map.get("ERNAME").toString()+"("+map.get("ACCOUNT").toString()+")");
			
			if(allNode.get(map.get("ERPARCODE").toString())==null){
				tempMap.put(map.get("ERCODE").toString(), node);
			} else{
				allNode.get(map.get("ERPARCODE").toString()).addChildTreeNode(map.get("ERCODE").toString(), node);
			}
			allNode.put(map.get("ERCODE").toString(), node);	
		}
		dto.setNodeMap(tempMap);
		
		return dto;
	}
	
	
	
	/**
	 * Ӧ����Դ�������
	 * @param dto
	 * @return
	 * @throws BLException
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGDRM04DTO regEmergencyResource(IGDRM04DTO dto)throws BLException, FileNotFoundException, IOException{
		IGDRM0401Form form = dto.getIgdrm0401Form();
		SOC0118TB soc0118tb = new SOC0118TB();
		BeanUtils.copyProperties(form, soc0118tb);
		if(soc0118tb.getEiid()==null || soc0118tb.getEiid()==0){
			//��������
			soc0118tb.setEiversion(1);
			soc0118tb.setEismallversion(0);
			soc0118tb.setEiuserid(dto.getUser().getUserid());
			soc0118tb.setEiusername(dto.getUser().getUsername());
			soc0118tb.setEiorgsyscoding(dto.getUser().getOrgid());
			SOC0118Info soc0118Info = soc0118BL.registEntityItem(soc0118tb);
			String[] cids = form.getCids();
			String[] civalues = form.getCivalues();
			int i = 0;
			for (String cid : cids) {
				SOC0107TB soc0107tb = new SOC0107TB();
				soc0107tb.setCid(cid);
				soc0107tb.setCiupdtime(DateUtils.getCurrentTime());
				soc0107tb.setEid(soc0118Info.getEid());
				soc0107tb.setEsyscoding(soc0118Info.getEsyscoding());
				soc0107tb.setEiid(soc0118Info.getEiid());
				soc0107tb.setCiversion(soc0118Info.getEiversion());
				soc0107tb.setCismallversion(soc0118Info.getEismallversion());
				if("ciattach".equals(civalues[i])){
					//����Ǹ���
					uploadFile(form.getFiles(),soc0107tb);
				}else{
					soc0107tb.setCivalue(civalues[i]);
				}
				soc0107BL.registSOC0107(soc0107tb);
				i++;
			}
		}else{
			//�޸Ĳ���
		}
		
		return dto;
	}
	
	private SOC0107TB uploadFile( FormFile file,SOC0107TB soc0107tb) throws FileNotFoundException, IOException, BLException{
		if ( file != null && file.getFileSize() > 0) {
			//�ϴ��ļ����ڵ����
			//�ϴ��ļ�·��
			StringBuffer pathBuf = new StringBuffer();
			String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
			//��Ŀ¼
			pathBuf.append(rootPath);
			//����ID
			pathBuf.append("asm"+File.separator);
			//�豸ID
			pathBuf.append(soc0107tb.getEiid());
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
			fileName.append(soc0107tb.getCiversion()+"_"+soc0107tb.getCismallversion());
			//�ļ���չ��
			fileName.append(fileType);

			//�ļ��ϴ�����
			this.fileUploadBL.saveFile(file, pathBuf.toString(), fileName.toString());
			
			//�ϴ��ļ�������
			soc0107tb.setCivalue(fileName.toString());
			
			//�������Ա�ʶ
			soc0107tb.setCicurver("1");
			
		}else{
			soc0107tb.setCivalue(null);
		}
		return soc0107tb;
	}
	
	/**
	 * Ӧ����Դɾ������
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO deleteEntityItemAction(IGDRM04DTO dto) throws BLException {
		log.debug("========Ӧ����Դɾ������ʼ========");
		
		for( int i=0;i<dto.getDeleteEntityItem().length;i++ ){
			String eiid = dto.getDeleteEntityItem()[i];
			
			//ɾ��ǰɾ�������ĵ�ȷ��
			SOC0118Info entityItem = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(eiid));
			
			if (entityItem == null){
				throw new BLException("IGCO10000.E004","ɾ�������ĵ�����");
			}

			//Ӧ����Դɾ��
			SOC0118TB soc0118tb = (SOC0118TB) SerializationUtils.clone(entityItem);
			soc0118tb.setEistatus("D");
			//Ӧ����Դ�߼�ɾ��
			this.soc0118BL.updateEntityItem(soc0118tb);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","Ӧ����Դ"));

		log.debug("========Ӧ����Դɾ����������========");
		return dto;
	}
	
	/**
	 * ��ȡӦ����Դ���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM04DTO getLabel(IGDRM04DTO dto)throws BLException{
		IGDRM0401Form form = dto.getIgdrm0401Form();
		dto.setEilabel(creatEiLabel(form.getEid()));
		return dto;
	}

	private String creatEiLabel( String eid)
			throws BLException {
		SOC0117Info soc0117Info = soc0117BL.searchEntityByKey(eid);
		
		SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		
		cond.setEilabel_like(soc0117Info.getElabel());
		
		List<SOC0118Info> entitys = soc0118BL.searchEntityItem(cond);
		
		if(entitys.size()>0){
			String num = String.valueOf(Integer.valueOf(entitys.get(entitys.size()-1).getEilabel().split("-")[1])+1);
			
			return soc0117Info.getElabel()+"-"+("0000".substring(num.length())+num);
			
		}else{
			return soc0117Info.getElabel()+"-0001";
		}
	}
	
	/**
	 * ��ȡӦ����Դ�и�����ciid
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM04DTO getArrId(IGDRM04DTO dto)throws BLException{
		
		SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
		cond.setEiid(""+dto.getEiid());
		cond.setCiversion(""+dto.getEiversion());
		cond.setCid("CI400000000001");
		List<SOC0107Info> list = soc0107BL.searchSOC0107(cond);
		if(list.size()>0){
			dto.setCiid(list.get(0).getCiid());
		}
		
		return dto;
	}
	
	
	
	/**
	 * Ӧ����Դ��ݱ������
	 * @param dto
	 * @return
	 * @throws BLException
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGDRM04DTO regEmergencyResourceShortcut(IGDRM04DTO dto)throws BLException, FileNotFoundException, IOException{
		
		IGDRM0408Form form = (IGDRM0408Form)dto.getForm();
		SOC0118TB soc0118Tb = new SOC0118TB();
		soc0118Tb.setEid("CM40000000");
		soc0118Tb.setEsyscoding("999040");
		soc0118Tb.setEiuserid(dto.getUser().getUserid());
		soc0118Tb.setEiusername(dto.getUser().getUsername());
		soc0118Tb.setEiinsdate(DateUtils.getCurrentTime().substring(0,10));
		soc0118Tb.setEilabel(this.creatEiLabel(soc0118Tb.getEid()));
		soc0118Tb.setEiorgsyscoding(dto.getUser().getOrgid());
		soc0118Tb.setEiname(form.getEiname());
		soc0118Tb.setEiversion(1);
		soc0118Tb.setEismallversion(0);
		SOC0118Info soc0118Info = soc0118BL.registEntityItem(soc0118Tb);
		String[] cids = form.getCids();
		String[] civalues = form.getCivalues();
		form.setEiid(soc0118Info.getEiid());
		int i = 0;
		for (String cid : cids) {
			SOC0107TB soc0107tb = new SOC0107TB();
			soc0107tb.setCid(cid);
			soc0107tb.setCiupdtime(DateUtils.getCurrentTime());
			soc0107tb.setEid(soc0118Info.getEid());
			soc0107tb.setEsyscoding(soc0118Info.getEsyscoding());
			soc0107tb.setEiid(soc0118Info.getEiid());
			soc0107tb.setCiversion(soc0118Info.getEiversion());
			soc0107tb.setCismallversion(soc0118Info.getEismallversion());
			if("ciattach".equals(civalues[i])){
				//����Ǹ���
				uploadFile(form.getFiles(),soc0107tb);
			}else{
				soc0107tb.setCivalue(civalues[i]);
			}
			soc0107BL.registSOC0107(soc0107tb);
			i++;
		}
		return dto;
	}

	/**
	 * soc0118BL   ȡ��
	 * @return soc0118BL soc0118BL
	 */
	public SOC0118BL getSoc0118BL() {
		return soc0118BL;
	}

	/**
	 * soc0118BL   �趨
	 * @param soc0118BL soc0118BL
	 */
	public void setSoc0118BL(SOC0118BL soc0118bl) {
		soc0118BL = soc0118bl;
	}

	/**
	 * soc0117BL   ȡ��
	 * @return soc0117BL soc0117BL
	 */
	public SOC0117BL getSoc0117BL() {
		return soc0117BL;
	}

	/**
	 * soc0117BL   �趨
	 * @param soc0117BL soc0117BL
	 */
	public void setSoc0117BL(SOC0117BL soc0117bl) {
		soc0117BL = soc0117bl;
	}

	/**
	 * soc0109BL   ȡ��
	 * @return soc0109BL soc0109BL
	 */
	public SOC0109BL getSoc0109BL() {
		return soc0109BL;
	}

	/**
	 * soc0109BL   �趨
	 * @param soc0109BL soc0109BL
	 */
	public void setSoc0109BL(SOC0109BL soc0109bl) {
		soc0109BL = soc0109bl;
	}

	/**
	 * soc0107BL   ȡ��
	 * @return soc0107BL soc0107BL
	 */
	public SOC0107BL getSoc0107BL() {
		return soc0107BL;
	}

	/**
	 * soc0107BL   �趨
	 * @param soc0107BL soc0107BL
	 */
	public void setSoc0107BL(SOC0107BL soc0107bl) {
		soc0107BL = soc0107bl;
	}
	/**
	 * organizationBL   �趨
	 * @param organizationBL organizationBL
	 */
	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}

	/**
	 * fileUploadBL   �趨
	 * @param fileUploadBL fileUploadBL
	 */
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}

	/**
	 * soc0119BL   �趨
	 * @param soc0119BL soc0119BL
	 */
	public void setSoc0119BL(SOC0119BL soc0119bl) {
		soc0119BL = soc0119bl;
	}

	/**
	 * codeDetailBL   �趨
	 * @param codeDetailBL codeDetailBL
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}
	
	
	
	
	/**
	 * <p>
	 * �ж�ÿ���ʲ������Ƿ����ͣ��
	 * </p>
	 * @param �ʲ�����esyscoding
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	private boolean isCouldStop(String syscode) {
		IGDRM0411Form form = new IGDRM0411Form();
		IGDRM04DTO dto = new IGDRM04DTO();
		boolean flag = true;
		
		form.setEparcoding_status(syscode);
		form.setEstatus("1");
		dto.setEntitySearchCond(form);
		List<SOC0117Info> ret = soc0117BL.searchEntity(dto.getEntitySearchCond(), 0, 0);//��÷����Ƿ����ʹ���е��¼�����
		if(ret.size()>0){
			flag = false;
		}
		return flag;
	}
	
	/**
	 * <p>
	 * Description: ȷ���Ƿ���ʾ'ͣ��'��ť
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public Map<String,String> getButtonNameList(List<SOC0117Info> entityList) throws BLException {
		Map<String,String> org = new HashMap<String,String>();
		for(SOC0117Info ret:entityList){
			String flag = "0";//0����ʾ 1��ʾ
			
			if(isCouldStop(ret.getEsyscoding())){
				flag = "1";
			}
			
			org.put(ret.getEid(), flag);
		}
		
		return org;
	}
	
	/**
	 * <p>
	 * �ж�ÿ�������Ƿ��������
	 * </p>
	 * @param �ʲ�����esyscoding
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	private boolean isCouldStart(String syscode) {
		IGDRM0411Form form = new IGDRM0411Form();
		IGDRM04DTO dto = new IGDRM04DTO();
		boolean flag = true;
		
		form.setEparcoding_status_start(syscode);
		dto.setEntitySearchCond(form);
		List<SOC0117Info> ret = soc0117BL.searchEntity(dto.getEntitySearchCond(), 0, 0);//����ʲ������Ƿ����ͣ�õ��ϼ�����

		if(ret.size()>0&&ret.get(0).getEstatus().equals("2")){//�����ǰ�����ϼ���ͣ��״̬��ǰ��㲻������
			flag = false;
		}
		return flag;
	}
	
	/**
	 * <p>
	 * Description: ȷ���Ƿ���ʾ'����'��ť
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public Map<String,String> getStartButtonNameList(List<SOC0117Info> entityList) throws BLException {
		Map<String,String> org = new HashMap<String,String>();
		for(SOC0117Info ret:entityList){
			String flag = "0";//0����ʾ 1��ʾ
			String syscode = ret.getEsyscoding();
			String parcode = ret.getEparcoding();
			if(parcode.equals("999")){//����Ϊ1�����࣬��ֱ������flagΪ1
				flag = "1";
			}else{
				if(isCouldStart(syscode.substring(0,syscode.length()-3))){
					flag = "1";
				}
				
			}

			org.put(ret.getEid(), flag);
		}
		
		return org;
	}
	
	/**
	 * <p>
	 * Description: �ʲ���������״̬�仯
	 * </p>
	 * 
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 * @throws BLException
	 * @author duchong@deliverik.com
	 * @update
	 */
	public void changeConfigStatus(IGDRM04DTO dto) throws BLException {
		log.debug("========�ʲ���������״̬�仯����ʼ========");

		SOC0109Info configuration = soc0109BL.searchConfigurationByKey(dto.getCid());
		String status = "";
		if(configuration == null){
			throw new BLException("IGCO10000.E004","�ʲ���������״̬���");
		}
		//1Ϊ���� 2Ϊͣ��
		if("1".equals(dto.getCstatus())){
			status="2";
		}else if("2".equals(dto.getCstatus())){
			status="1";
		}
		SOC0109TB cfr = new SOC0109TB();
		//������ʾ�趨
		cfr.setCattach(configuration.getCattach());
		cfr.setCcategory(configuration.getCcategory());
		cfr.setCdesc(configuration.getCdesc());
		cfr.setCid(configuration.getCid());
		cfr.setClabel(configuration.getClabel());
		cfr.setCname(configuration.getCname());
		cfr.setCoption(configuration.getCoption());
		cfr.setCseq(configuration.getCseq());
		cfr.setCstatus(status);
		cfr.setEsyscoding(configuration.getEsyscoding());
		cfr.setCunit(configuration.getCunit());
		cfr.setEid(configuration.getEid());
		cfr.setCrequired(configuration.getCrequired());

		soc0109BL.updateConfiguration(cfr);

		log.debug("========�ʲ���������״̬�仯�������========");
		
	}
	
	/**
	 * <p>
	 * Description: �ʲ�����״̬�仯
	 * </p>
	 * 
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 * @throws BLException
	 * @author duchong@deliverik.com
	 * @update
	 */
	public void changeEntityStatus(IGDRM04DTO dto) throws BLException {
		log.debug("========�ʲ�����״̬�仯����ʼ========");
		IGDRM0411Form form = dto.getIgdrm0411Form();
		EmergencyResourceInfo info = emergencyResourceBL.searchEmergencyResourceByPK(Integer.parseInt(form.getEid()));
		if(info == null){
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","Ӧ����Դ״̬���");
		}
		EmergencyResourceTB Tb = (EmergencyResourceTB) SerializationUtils.clone(info);
		Tb.setErstatus(form.getEstatus()!=null&&"1".equals(form.getEstatus())? "0" : "1");
		emergencyResourceBL.updateEmergencyResource(Tb);
		if(form.getEstatus()!=null&&"1".equals(form.getEstatus())){
			EmergencyResourceSearchCondImpl cond = new EmergencyResourceSearchCondImpl();
			cond.setErparcode_like(info.getErcode());
			List<EmergencyResourceInfo> infoList = emergencyResourceBL.searchEmergencyResource(cond);
			
			if(infoList!=null&&infoList.size()>0){
				for(EmergencyResourceInfo temp : infoList){
					EmergencyResourceTB tempTB = (EmergencyResourceTB) SerializationUtils.clone(temp);
					tempTB.setErstatus("0");
					emergencyResourceBL.updateEmergencyResource(tempTB);
				}
			}
		}
		
//		SOC0117Info entity = soc0117BL.searchEntityByKey(form.getEid());
//		String status = "";
//		if(entity == null){
//			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
//					"IGCO10000.E004","�ʲ�����״̬���");
//		}
//		//1Ϊ���� 2Ϊͣ��
//		if("1".equals(dto.getEstatus())){
//			status="2";
//		}else if("2".equals(dto.getEstatus())){
//			status="1";
//		}
//		IGDRM0412Form form0102 = new IGDRM0412Form();
//		//������ʾ�趨
//		form0102.setEcategory(entity.getEcategory());
//		form0102.setEid(entity.getEid());
//		form0102.setEkey1(entity.getEkey1());
//		form0102.setEkey2(entity.getEkey2());
//		form0102.setEkey3(entity.getEkey3());
//		form0102.setElabel(entity.getElabel());
//		form0102.setEname(entity.getEname());
//		form0102.setEstatus(status);//�����ʲ�����״̬
//		form0102.setEsyscoding(entity.getEsyscoding());
//		form0102.setEparcoding(entity.getEparcoding());
//		form0102.setEdesc(entity.getEdesc());
//		if("999".equals(entity.getEparcoding())){
//			form0102.setEparname("�ʲ�����");
//		}
//		else{
//			SOC0117SearchCondImpl ret = new SOC0117SearchCondImpl();
//			ret.setEsyscoding(entity.getEparcoding());
//			List<SOC0117Info> list = this.soc0117BL.searchEntity(ret, 0, 0);
//			for (int i = 0; i < list.size(); i++) {
//				form0102.setEparname(list.get(0).getEname());
//			}
//		}
//		form0102.setEidStr(String.valueOf(form.getEid()));
//		
//		soc0117BL.updateEntity(form0102);

		log.debug("========�ʲ�����״̬�仯�������========");
		
	}
	
	/**
	 * ��ѯ���������������񼰷����¼��һ�����ࣨ����EXCELģ��ʹ�ã�
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO searchEntityActionForExportExcelModel(IGDRM04DTO dto) throws BLException {

		log.debug("========һ�������ѯ����ʼ========");
		
		//�ʲ���Ϣ��ѯ����ȡ�� 
		
		int totalCount = this.soc0117BL.getEntitySearchCount(dto.getEntitySearchCond());
		
		if (totalCount == 0) {
			log.debug("========�ʲ���Ϣ��ѯ���ݲ�����========");
			//�ʲ���Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�ʲ���Ϣ��ѯ���ݼ�������========");
			//�ʲ���Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		//��ǰҳ�ʲ���Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		List<SOC0117Info> entityList = this.soc0117BL.searchEntity(dto.getEntitySearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
//		List<Entity> newList = new ArrayList<Entity>();
//		for(Entity e:entityList){
//			if(!CommonDefineUtils.ENTIY_CATEGORY_SERVICE_RECORD_SYSCODING.equals(e.getEsyscoding())){
//				newList.add(e);
//			}
//		}
//		if(newList==null){
//			throw new BLException("IGDRM0411.E006");
//		}
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityList(entityList);
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========һ�������ѯ��������========");
		return dto;
	}
	
	
	/**
	 * ȡ�øý����ʲ�����ȫ��
	 * @param syscoding
	 * @return
	 */
	private String getCompleteEntityName(String syscoding) {
		StringBuffer ename = new StringBuffer();
		try{
			ArrayList<String> codelist = new ArrayList<String>();
			if(syscoding.length()==6){
				codelist.add(syscoding);
			}else{
				String pcode = syscoding.substring(0, 6);
				codelist.add(pcode);
				String childs = syscoding.substring(6);
				int j = childs.length()/3;
				for(int i=1;i<=j;i++){
					codelist.add(pcode+childs.substring(0, 3*i));
				}
				
			}
			SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
			cond.setSelectList(codelist);
			List<SOC0117Info> ret = soc0117BL.searchEntity(cond, 0, 0);
			
			for(int i=0,j=ret.size();i<j;i++){
				String syscode = ret.get(i).getEsyscoding();
				if(syscoding.contains(syscode)){
					if(i>0){
						ename.append("-");
					}
					ename.append(ret.get(i).getEname());
				}
				
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return ename.toString();
	}
	
	
	/**
	 * ����Excelģ��
	 * @throws Exception
	 */
	public IGDRM04DTO searchInfoForExportExcel(String esyscode) throws BLException{

		try
		{
			IGDRM04DTO dto = new IGDRM04DTO();
			//��ѯ�ʲ����ࣨ�����������񡢷����¼��
//			List<String> selectList = new ArrayList<String>();
//			selectList.add("999001");
//			selectList.add("999002");
//			selectList.add("999003");
//			selectList.add("999005");
//			selectList.add("999006");
//			selectList.add("999010");
//			selectList.add("999011");
//			selectList.add("999012");
//			selectList.add("999013");
			SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
			//cond.setSelectList(selectList);
			cond.setEsyscoding(esyscode);
			List<SOC0117Info> list = soc0117BL.searchEntity(cond, 0, 0);
			dto.setTopEntityList(list);
			
			
			//��ѯ�ʲ����ࣨ�����������񡢷����¼,����Ϊ��ǰ������ʲ���������Ӧ���ʲ����༯�ϣ�
			List<String> delList = new ArrayList<String>();
			delList.add("999007");
			delList.add("999008");
			delList.add("999009");
			SOC0117SearchCondImpl cond1 = new SOC0117SearchCondImpl();
			cond1.setDelList(delList);
			cond1.setSyscoding_q(esyscode);
			List<SOC0117Info> elist = soc0117BL.searchEntity(cond1, 0, 0);
			List<SOC0117Info> entitylist = new ArrayList<SOC0117Info>();
			for(SOC0117Info entity:elist){
				SOC0117TB etb = (SOC0117TB)SerializationUtils.clone(entity);
				etb.setEname(getCompleteEntityName(etb.getEsyscoding()));
				entitylist.add(etb);
			}
			dto.setEntityList(entitylist);
			
			//��ȡֵ��Χ
			SOC0151SearchCondImpl ccdcond = new SOC0151SearchCondImpl();
			ccdcond.setCcdstatus("1");//��ѯ״̬Ϊ���õ�����
			List<SOC0151Info> ccdlist  = soc0151BL.searchConfigurationCodeDetail(ccdcond, 0, 0);
			dto.setCcdList(ccdlist);
			
			//��ѯ����
			IGSYM01BL sym01BL = (IGSYM01BL) WebApplicationSupport.getBean("igsym01BL");
			IGSYM01DTO sym01dto = sym01BL.searchOrganizationForIGASM0101();
			List<Organization> orglist = sym01dto.getOrganizationCondList();
			dto.setOrglist(orglist);
			
			//��ѯ���ʲ�������
			List<Map<String,List<SOC0109Info>>> maplist = new ArrayList<Map<String,List<SOC0109Info>>>();
			for(SOC0117Info entity:list){
				List<String> cattachList = new ArrayList<String>();
				Map<String,List<SOC0109Info>> map = new LinkedHashMap<String,List<SOC0109Info>>();
				//codedetail����CCIDΪ012�ļ�¼�����ʲ����������ͣ�CIDΪ�ʲ����������͵�ֵ
				cattachList.add("0");//�ʲ�����������Ϊ�ı���
				cattachList.add("2");//�ʲ�����������Ϊ������
				cattachList.add("3");//�ʲ�����������Ϊ����
				
				//�ʲ�������Ϣ�ֲ�β�ѯ
				List<SOC0117Info> parentlist = this.soc0117BL.getParentNodes(entity.getEid());
				for(SOC0117Info e : parentlist){
					SOC0109SearchCondImpl cond2 = new SOC0109SearchCondImpl();
					cond2.setCseq(1);//ֻ��ѯҳ����ʾ������
					cond2.setEid(e.getEid().toString());
					cond2.setCattachList(cattachList);
					List<SOC0109Info> configurationList = this.soc0109BL.searchConfiguration(cond2, 0, 0);
					map.put(e.getEsyscoding(), configurationList);
				}
				maplist.add(map);
			}
			dto.setConfigurationMapList(maplist);

			
			//��ѯ�û�
			IGSYM02BL sym02BL = (IGSYM02BL) WebApplicationSupport.getBean("igsym02BL");
			IGSYM02DTO sym02dto = sym02BL.searchUserActionForIGASM0101();
			List<User> userlist = sym02dto.getUserList();
			dto.setUserlist(userlist);
			
			
			return dto;
		}catch (Exception e){
			e.printStackTrace();
			log.debug("=============����һ���ʲ�����ģ�����==============");
			log.debug(e.getMessage());
			throw new BLException("IGDRM0411.E007");
		}
		
	}

	
	/**
	 * �ʲ�����Ϣ��ѯ
	 * 
	 * @param dto
	 *            IGDRM07DTO
	 * @return IGDRM07DTO
	 */
	public IGDRM04DTO searchEntityItem0406Action(IGDRM04DTO dto) throws BLException
	{
		
		log.debug("========�ʲ���HELP��ѯ����ʼ========");
		IGDRM0406Form form = (IGDRM0406Form)dto.getForm();
		
		//�ҹ������ʲ���ϵeiid
		List<Integer> eiids = new ArrayList<Integer>();
		List<String> eiidstrs = new ArrayList<String>();
		SOC0124SearchCondImpl soc0124cond = new SOC0124SearchCondImpl();
		soc0124cond.setEsyscoding(form.getEsyscoding());
		soc0124cond.setEiname(form.getEiname());
		//��������ר��Ԥ��
		if(dto.getSp_eiid()!=null&&!"".equals(dto.getSp_eiid())){
			if(soc0124cond.getEsyscoding()!=null&&"999060".equals(soc0124cond.getEsyscoding().substring(0, 6))){
				
			SOC0119SearchCondImpl soc0119cond = new SOC0119SearchCondImpl();
			soc0119cond.setPareiid(Integer.parseInt(dto.getSp_eiid()));
			soc0119cond.setDeleteflag("0");
			eiids = soc0119BL.searchCldeiidByPareiid(soc0119cond);
			if(eiids.size()>0){
				for(int i = 0; i<eiids.size();i++){
					eiidstrs.add(eiids.get(i)+"");
				}
				soc0124cond.setEiidList(eiidstrs);
			}else{
				//û���ʲ�������ϵ�����
				eiidstrs.add("999");
				soc0124cond.setEiidList(eiidstrs);
			}
			}
		}
		soc0124cond.setEistatus("ISNULL");
		// ��ѯ����ȡ��												  
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(soc0124cond);
	
		if (totalCount == 0)
		{
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
	
		if (totalCount > dto.getMaxSearchCount())
		{
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
	
		PagingDTO pDto = dto.getPagingDto();
	
		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL.searchEntityItemVW(soc0124cond, pDto
						.getFromCount(), pDto.getPageDispCount());
	
		pDto.setTotalCount(totalCount);
	
		dto.setSoc0124List(entityItemVWInfoList);
	
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
	
		log.debug("========�ʲ���HELP��ѯ��������========");
		return dto;
	}
	/**
	 * �ʲ���Ϣ��ѯ����
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO searchEntityAction(IGDRM04DTO dto) throws BLException {

		log.debug("========�ʲ���Ϣ��ѯ����ʼ========");
		IGDRM0411Form form = dto.getIgdrm0411Form();
		EmergencyResourceSearchCondImpl erCond = new EmergencyResourceSearchCondImpl();
		erCond.setErname(form.getEname());
		erCond.setErparcode_like(form.getEparcoding());
		//�ʲ���Ϣ��ѯ����ȡ�� 
		int totalCount = emergencyResourceBL.getSearchCount(erCond);
		
		if (totalCount == 0) {
			log.debug("========�ʲ���Ϣ��ѯ���ݲ�����========");
			//�ʲ���Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�ʲ���Ϣ��ѯ���ݼ�������========");
			//�ʲ���Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳ�ʲ���Ϣȡ��
		List<EmergencyResourceInfo> erEntityList = emergencyResourceBL.searchEmergencyResource(erCond, pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
//		
		dto.setErEntityList(erEntityList);
		
//		dto.setStopbuttonMap(getButtonNameList(entityList));
//		dto.setStartbuttonMap(getStartButtonNameList(entityList));
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========�ʲ���Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * �ʲ���Ϣ�ǼǴ���
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
//	public IGDRM04DTO insertEntityAction(IGDRM04DTO dto) throws BLException {
//		log.debug("========�ʲ���Ϣ�ǼǴ���ʼ========");
//		
//		IGDRM0412Form form = dto.getIgdrm0412Form();
//		dto.setEntity(form);
//		SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
//		cond.setEsyscoding(form.getEparcoding());
//		List<SOC0117Info> entityList = this.soc0117BL.searchEntity(cond);
//		if(entityList!=null && entityList.size()>0){
//			//�ʲ���Ϣ�ǼǴ���
//			SOC0117Info entity = this.soc0117BL.registEntity(dto.getEntity(),entityList.get(0).getEid());			
//			dto.setEntity(entity);
//		}else{
//			//�ʲ���Ϣ�ǼǴ���
//			SOC0117Info entity = this.soc0117BL.registEntity(dto.getEntity(),"");		
//			dto.setEntity(entity);
//		}
//
//		dto.addMessage(new ActionMessage( "IGCO10000.I004", "���������Ϣ") );
//
//		log.debug("========�ʲ���Ϣ�ǼǴ�������========");
//		return dto;
//	}
	/**
	 * �ʲ���Ϣ�༭���������ʾ����
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
//	public IGDRM04DTO initIGDRM0412Action(IGDRM04DTO dto) throws BLException {
//
//		log.debug("========�ʲ���Ϣ�༭���������ʾ����ʼ========");
//		
//		IGDRM0412Form form = dto.getIgdrm0412Form();
//		
//		String eidStr = form.getEidStr();
//		
//		String eid = form.getEidStr();
//		
//		//��ʾ���ʲ���Ϣȡ��
//		SOC0117Info entity = this.soc0117BL.searchEntityByKey(eid);
//		
//		if ( entity == null ){
//			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
//					"IGCO10000.E004","��������ʲ�����");
//		}
//		
//		//������ʾ�趨
//		form.setEcategory(entity.getEcategory());
//		form.setEdesc(entity.getEdesc());
//		form.setEid(entity.getEid());
//		form.setEkey1(entity.getEkey1());
//		form.setEkey2(entity.getEkey2());
//		form.setEkey3(entity.getEkey3());
//		form.setElabel(entity.getElabel());
//		form.setEname(entity.getEname());
//		form.setEstatus(entity.getEstatus());
//		form.setEsyscoding(entity.getEsyscoding());
//		form.setEparcoding(entity.getEparcoding());
//		form.setEmodeltype(entity.getEmodeltype());
//		if("999".equals(entity.getEparcoding()))
//		{
//			form.setEparname("��Դ����");
//		}
//		else{
//			SOC0117SearchCondImpl ret = new SOC0117SearchCondImpl();
//			ret.setEsyscoding(entity.getEparcoding());
//			List<SOC0117Info> list = this.soc0117BL.searchEntity(ret, 0, 0);
//			for (int i = 0; i < list.size(); i++) {
//				form.setEparname(list.get(0).getEname());
//			}
//		}
//		form.setEidStr(eidStr);
//		
//		//�༭ģʽ�趨
//		form.setMode("1");
//		
//		dto.setIgdrm0412Form(form);
//		
//		dto.addMessage(new ActionMessage("IGCO10000.I001","���������Ϣ"));
//		
//		log.debug("========�ʲ���Ϣ�༭���������ʾ��������========");
//		return dto;
//	}

	/**
	 * �ʲ���Ϣ���´���
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
//	public IGDRM04DTO updateEntityAction(IGDRM04DTO dto) throws BLException {
//		log.debug("========�ʲ���Ϣ���´���ʼ========");
//		
//		//�ʲ���Ϣ���´���
//		this.soc0117BL.updateEntity(dto.getEntity());
//		
//		dto.addMessage(new ActionMessage( "IGCO10000.I005", "���������Ϣ") );
//		log.debug("========�ʲ���Ϣ���´�������========");
//		return dto;
//	}
	/**
	 * Ӧ����Դ��Ϣ�ǼǴ���
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO insertEntityAction(IGDRM04DTO dto) throws BLException {
		log.debug("========Ӧ����Դ��Ϣ�ǼǴ���ʼ========");
		
		IGDRM0412Form form = dto.getIgdrm0412Form();
		//��ȡ�����
		EmergencyResourceSearchCondImpl erCond = new EmergencyResourceSearchCondImpl();
		erCond.setErparcode(form.getEparcoding());
		erCond.setOrder("DESC");
		erCond.setOrderby("ercode");
		List<EmergencyResourceInfo> list = emergencyResourceBL.searchEmergencyResource(erCond);
		String ercode = "";
		if(list!=null&&list.size()>0){
			EmergencyResourceInfo info = list.get(0);
			String str = info.getErcode();
			String currentCount = str.substring(str.length()-3, str.length());
			Integer count = Integer.parseInt(currentCount.replaceAll("0", "")) + 1;
			ercode = form.getEparcoding() + "000".substring(0,3-(count + "").length()) + count;
		}else{
			ercode = form.getEparcoding() + "001";
		}
		EmergencyResourceTB erTB = new EmergencyResourceTB();
		String[] cids = form.getCids();
		String cidstr = "";
		if(cids!=null&&cids.length>0){
			for(String cid : cids){
				cidstr = cidstr + cid +"_";
			}
		}
		if(StringUtils.isNotEmpty(cidstr)) erTB.setErcids(cidstr.substring(0, cidstr.length()-1));
		erTB.setEsyscoding(form.getEsyscoding());
		erTB.setErparcode(form.getEparcoding());
		erTB.setErcode(ercode);
		erTB.setErname(form.getErname());
		erTB.setErdesc(form.getEdesc());
		erTB.setErcreatetime(DateUtils.getCurrentTime());
		erTB.setErstatus("1");
		erTB.setEruserid(dto.getUser().getUserid());
		erTB.setErusername(dto.getUser().getUsername());
		emergencyResourceBL.registEmergencyResource(erTB);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "Ӧ����Դģ�ͻ�����Ϣ") );
		
		log.debug("========Ӧ����Դ��Ϣ�ǼǴ�������========");
		return dto;
	}
	/**
	 * Ӧ����Դ��Ϣ�༭���������ʾ����
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO initIGDRM0412Action(IGDRM04DTO dto) throws BLException {

		log.debug("========�ʲ���Ϣ�༭���������ʾ����ʼ========");
		
		IGDRM0412Form form = dto.getIgdrm0412Form();
		
		String eidStr = form.getEidStr();
		
		EmergencyResourceInfo info = emergencyResourceBL.searchEmergencyResourceByPK(Integer.parseInt(form.getEidStr()));
		//��ʾ���ʲ���Ϣȡ��
//		SOC0117Info entity = this.soc0117BL.searchEntityByKey(eid);
		
		if ( info == null ){
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","Ӧ����Դģ�ͻ���");
		}
		//������ʾ�趨
		form.setFingerPrint(info.getErid()+"");
		form.setEdesc(info.getErdesc());
		form.setErname(info.getErname());
//		form.setEname(info.getEname());
		form.setEstatus(info.getErstatus());
		if(StringUtils.isNotEmpty(info.getEsyscoding())){
			SOC0117VWInfo s0117info = soc0117VWBL.searchEntityByKey(new SOC0117VWPK(Integer.parseInt(info.getEsyscoding().split("_")[0]), info.getEsyscoding().split("_")[1]));
			if(s0117info!=null){
				form.setEsyscoding(s0117info.getId()+"_"+s0117info.getEid()+"_"+s0117info.getEsyscoding());
				form.setEname(s0117info.getEname());
			}
		}
		form.setEparcoding(info.getErparcode());
		if("000".equals(info.getErparcode()))
		{
			form.setEparname("��Դģ��");
		}
		else{
			EmergencyResourceSearchCondImpl erCond = new EmergencyResourceSearchCondImpl();
			erCond.setErcode(info.getErparcode());
			List<EmergencyResourceInfo> list = emergencyResourceBL.searchEmergencyResource(erCond);
			for (int i = 0; i < list.size(); i++) {
				form.setEparname(list.get(0).getErname());
			}
		}
		form.setEidStr(eidStr);
		
		//�༭ģʽ�趨
		form.setMode("1");
		
		dto.setIgdrm0412Form(form);
		
		dto.addMessage(new ActionMessage("IGCO10000.I001","Ӧ����Դģ�ͻ�����Ϣ"));
		
		log.debug("========�ʲ���Ϣ�༭���������ʾ��������========");
		return dto;
	}

	/**
	 * Ӧ����Դ��Ϣ���´���
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO updateEntityAction(IGDRM04DTO dto) throws BLException {
		log.debug("========Ӧ����Դ��Ϣ���´���ʼ========");
		
		IGDRM0412Form form = dto.getIgdrm0412Form();
		EmergencyResourceInfo info = emergencyResourceBL.searchEmergencyResourceByPK(Integer.parseInt(form.getEidStr()));
		EmergencyResourceTB erTB = (EmergencyResourceTB) SerializationUtils.clone(info);
		String[] cids = form.getCids();
		String cidstr = "";
		if(cids!=null&&cids.length>0){
			for(String cid : cids){
				cidstr = cidstr + cid +"_";
			}
		}
		if(StringUtils.isNotEmpty(cidstr)) erTB.setErcids(cidstr.substring(0, cidstr.length()-1));
		//Ӧ����Դ��Ϣ���´���
		erTB.setEsyscoding(form.getEsyscoding());
//		erTB.setErparcode(form.getEparcoding());
		erTB.setErname(form.getErname());
		erTB.setErdesc(form.getEdesc());
//		erTB.setErstatus(form.getEstatus());
		erTB.setEruserid(dto.getUser().getUserid());
		erTB.setErusername(dto.getUser().getUsername());
		emergencyResourceBL.updateEmergencyResource(erTB);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "Ӧ����Դģ�ͻ�����Ϣ") );
		log.debug("========Ӧ����Դ��Ϣ���´�������========");
		return dto;
	}
	
	/**
	 * �ʲ�������Ϣ�ǼǴ���
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO insertConfigurationAction(IGDRM04DTO dto) throws BLException {
		log.debug("========�ʲ�������Ϣ�ǼǴ���ʼ========");
		
	/*	//������Ϣ��ż��
		if (dto.getConfiguration().getClabel().compareTo(
				CommonDefineUtils.COMMON_CONFIG_LABEL_MIN) >=0 &&
				dto.getConfiguration().getClabel().compareTo(
						CommonDefineUtils.COMMON_CONFIG_LABEL_MAX) <=0 ) {
			throw new BLException(BLErrorType.CONFIGURATION_ALREADY_EXISTS,
			"IGCOM0102.E001");
			
		}*/

		//�ʲ�������Ϣ�ǼǴ���
		SOC0109Info configuration = this.soc0109BL.registConfiguration(dto.getConfiguration());
		
		dto.setConfiguration(configuration);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "����������Ϣ") );

		log.debug("========�ʲ�������Ϣ�ǼǴ�������========");
		return dto;
	}

	/**
	 * �ʲ���ϸ��Ϣ���������ʾ����
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO initIGDRM0416Action(IGDRM04DTO dto) throws BLException {

		log.debug("========�ʲ���ϸ��Ϣ���������ʾ����ʼ========");
		//�ʲ�������Ϣ��ѯ
		SOC0117Info entity = this.soc0117BL.searchEntityByKey(dto.getConfigurationSearchCond().getEid());
		
		if (entity == null) {
			//�ʲ�����������Ϣ������
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E001");
		}
		
		dto.setEntity(entity);
		
		//�ʲ�������Ϣ��ѯ����ȡ�� 
		int totalCount = 0;
		List<SOC0117Info> list = this.soc0117BL.getParentNodes(entity.getEid());
		Map<String,List<SOC0109Info>> map = new LinkedHashMap<String,List<SOC0109Info>>();
		SOC0109SearchCondImpl cond = new SOC0109SearchCondImpl();
		cond.setCseq(1);
		//�ʲ�������Ϣ�ֲ�β�ѯ
		for(SOC0117Info e : list){
			cond.setEid(e.getEid().toString());
			List<SOC0109Info> configurationList = this.soc0109BL.searchConfiguration(cond, 0, 0);
			map.put(e.getEname(), configurationList);
			totalCount+=configurationList.size();
		}
		if (totalCount == 0) {
			log.debug("========�ʲ�������Ϣ��ѯ���ݲ�����========");
			//�ʲ�������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�ʲ�������Ϣ��ѯ���ݼ�������========");
			//�ʲ�������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		dto.setConfigurationMap(map);

		dto.addMessage(new ActionMessage("IGCO10000.I007",totalCount));
		
		log.debug("========�ʲ���ϸ��Ϣ���������ʾ��������========");
		return dto;
	}

	/**
	 * �ʲ�������Ϣ���´���
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO updateConfigurationAction(IGDRM04DTO dto) throws BLException {
		log.debug("========�ʲ�������Ϣ���´���ʼ========");
		
		//�ʲ�������Ϣ���´���
		this.soc0109BL.updateConfiguration(dto.getConfiguration());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "����������Ϣ") );
		log.debug("========�ʲ�������Ϣ���´�������========");
		return dto;
	}
	
	/**
	 * �ʲ�������Ϣ�༭���������ʾ����
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO initIGDRM0414Action(IGDRM04DTO dto) throws BLException {

		log.debug("========������ʲ�������Ϣ�༭���������ʾ����ʼ========");
		IGDRM0414Form form = dto.getIgdrm0414Form();
		
		String cid = form.getCidStr();
		
		//��ʾ���ʲ�������Ϣ��ѯ
		SOC0109Info configuration = this.soc0109BL.searchConfigurationByKey(cid);
		
		if ( configuration == null ){
			throw new BLException("IGCO10000.E004","��������ʲ�����");
		}
		
		//��ʾ���趨
		//KEY
		form.setEid(configuration.getEid());
		form.setCid(configuration.getCid());
		//���
		form.setClabel(configuration.getClabel());
		//����
		form.setCname(configuration.getCname());
		//��λ
		form.setCunit(configuration.getCunit());
		//����
		form.setCrequired(configuration.getCrequired());
		//״̬
		form.setCstatus(configuration.getCstatus());
		//˵��
		form.setCdesc(configuration.getCdesc());
		//���
		form.setCcategory(configuration.getCcategory());
		//ȡֵ��Χ
		form.setCoption(configuration.getCoption());
		//ȡֵ��Χ
		if("2".equals(configuration.getCattach())){
			SOC0151SearchCondImpl cond = new SOC0151SearchCondImpl();
			cond.setCcdcategory(configuration.getCoption());
			cond.setCcdstatus("1");
			List<SOC0151Info> list = soc0151BL.searchConfigurationCodeDetail(cond, 0, 0);
			if(!list.isEmpty()){
				form.setRangename(list.get(0).getCcdlabel());
			}
		}else if ("4".equals(configuration.getCattach())){//����ֵ��������
			SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
			cond.setEsyscoding(configuration.getCoption());
			List<SOC0117Info> list = soc0117BL.searchEntity(cond, 0, 0);
			if(list.size() == 1){
				form.setCename(list.get(0).getEname());
			}else{
				throw new BLException("IGDRM0414.E001",dto.getEntitySearchCond().getEsyscoding());
			}
			form.setCesyscoding(configuration.getCoption());
			form.setCoption(null);
		}
		
		//˳��
		form.setCseq(configuration.getCseq());
		
		//������ʶ
		form.setCattach(configuration.getCattach());
		
		form.setCstatus(configuration.getCstatus());
		
		//�༭ģʽ�趨
		form.setMode("1");
		
		dto.setIgdrm0414Form(form);
		
		dto.addMessage(new ActionMessage("IGCO10000.I001","����������Ϣ"));
		
		log.debug("========������ʲ�������Ϣ�༭���������ʾ��������========");
		return dto;
	}

	/**
	 * �ʲ���Ϣɾ������
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO deleteEntityAction(IGDRM04DTO dto) throws BLException {
		log.debug("========�ʲ���Ϣɾ������ʼ========");
		
		for( int i=0;i<dto.getDeleteEntity().length;i++ ){
			String eid = dto.getDeleteEntity()[i];
			
			//�ʲ���Ϣ��ѯ����
			SOC0117Info entity = this.soc0117BL.searchEntityByKey(eid);
			
			if (entity == null){
				throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
						"IGCO10000.E004","ɾ�������ʲ�����");
			}

			//�ʲ���Ϣɾ������
			this.soc0117BL.deleteEntity(entity);
		}
		
		log.debug("========�ʲ���Ϣɾ����������========");
		return dto;
	}
	
	/**
	 * �ʲ�������Ϣɾ������
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO deleteConfigurationAction(IGDRM04DTO dto) throws BLException {
		log.debug("========�ʲ�������Ϣɾ������ʼ========");
		
		for( int i=0;i<dto.getDeleteConfiguration().length;i++ ){
			String cid = dto.getDeleteConfiguration()[i];
			
			//�ʲ�������Ϣ��ѯ
			SOC0109Info configuration = 
				this.soc0109BL.searchConfigurationByKey(cid);
			
			if (configuration == null){
				throw new BLException("IGCO10000.E004","ɾ�������ʲ�����");
			}
			
			//�ʲ�������Ϣɾ��
			this.soc0109BL.deleteConfiguration(configuration);
		}
		
		log.debug("========�ʲ�������Ϣɾ����������========");
		return dto;
	}
	
	/**
	 * �ʲ��������ݱ�ʶ��ѯ
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO searchConfigurationCodeDetailBean(IGDRM04DTO dto) throws BLException {
		log.debug("========�ʲ��������ݲ�ѯ����ʼ========");
		SOC0151SearchCondImpl cond = new SOC0151SearchCondImpl();
		cond.setCcdtype("A");
		cond.setCcdstatus("1");
		List<ConfigurationCodeDetailBean> list = this.soc0151BL.searchConfigurationCodeDetailBean(cond);
		dto.setConfigurationCodeDetailBeanList(list);
		log.debug("========�ʲ��������ݲ�ѯ��������========");
		return dto;
	}
	
	/**
	 * �ʲ��������ݱ�ʶ��ѯ
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO searchConfigurationCodeDetail(IGDRM04DTO dto) throws BLException {
		log.debug("========�ʲ��������ݲ�ѯ����ʼ========");
		if(dto.getIgdrm0419Form() != null){
			this.changeCfgCodeDetailLabel(dto);
		}
		SOC0151SearchCondImpl cond = new SOC0151SearchCondImpl();
		cond.setCcdtype("A");
		List<String> tempList = new ArrayList<String>();
		List<SOC0151Info> retList = new ArrayList<SOC0151Info>();
		List<SOC0151Info> list = this.soc0151BL.searchConfigurationCodeDetail(cond, 0, 0);
		for (SOC0151Info configurationCodeDetail : list) {
			String ccdcategory = configurationCodeDetail.getCcdcategory();
			if(!tempList.contains(ccdcategory)){
				tempList.add(ccdcategory);
				retList.add(configurationCodeDetail);
			}
		}
		dto.setConfigurationCodeDetailList(retList);
		log.debug("========�ʲ��������ݲ�ѯ��������========");
		return dto;
	}
	
	protected void changeCfgCodeDetailLabel(IGDRM04DTO dto) throws BLException{
		SOC0151SearchCondImpl cond = new SOC0151SearchCondImpl();
		cond.setCcdcategory(dto.getIgdrm0419Form().getCcdcategory());
		List<SOC0151Info> list = this.soc0151BL.searchConfigurationCodeDetail(cond, 0, 0);
		for (SOC0151Info configurationCodeDetail : list) {
			SOC0151TB ccdTB = (SOC0151TB) configurationCodeDetail;
			ccdTB.setCcdlabel(dto.getIgdrm0419Form().getCcdlabel());
			this.soc0151BL.registConfigurationCodeDetail(ccdTB);
		}
	}
	
	public IGDRM04DTO searchCfgCodeDetailByCategory(IGDRM04DTO dto) throws BLException {
		log.debug("========�ʲ��������ݲ�ѯ����ʼ========");
		if("changeValue".equals(dto.getStrflag())){
			this.changeCfgCodeDetailValue(dto);
		} else if ("status".equals(dto.getStrflag())){
			this.changeCfgCodeDetailStatus(dto);
		}
		SOC0151SearchCondImpl cond = new SOC0151SearchCondImpl();
		cond.setCcdtype("A");
		cond.setCcdcategory(dto.getIgdrm0420Form().getCcdcategory());
		List<SOC0151Info> list = this.soc0151BL.searchConfigurationCodeDetail(cond, 0, 0);
		dto.setConfigurationCodeDetailList(list);
		log.debug("========�ʲ��������ݲ�ѯ��������========");
		return dto;
	}
	
	protected void changeCfgCodeDetailValue(IGDRM04DTO dto) throws BLException{
		Integer ccdid = Integer.valueOf(dto.getIgdrm0420Form().getCcdid());
		SOC0151Info configurationCodeDetail = soc0151BL.searchConfigurationCodeDetailByKey(ccdid);
		SOC0151TB ccdTB = (SOC0151TB) configurationCodeDetail;
		ccdTB.setCcdvalue(dto.getIgdrm0420Form().getCcdvalue());
		this.soc0151BL.registConfigurationCodeDetail(ccdTB);
	}
	
	protected void changeCfgCodeDetailStatus(IGDRM04DTO dto) throws BLException{
		Integer ccdid = Integer.valueOf(dto.getIgdrm0420Form().getCcdid());
		SOC0151Info configurationCodeDetail = soc0151BL.searchConfigurationCodeDetailByKey(ccdid);
		SOC0151TB ccdTB = (SOC0151TB) configurationCodeDetail;
		if("1".equals(ccdTB.getCcdstatus())){
			ccdTB.setCcdstatus("0");
		}else if ("0".equals(ccdTB.getCcdstatus())){
			ccdTB.setCcdstatus("1");
		}
		this.soc0151BL.registConfigurationCodeDetail(ccdTB);
	}
	
	/**
	 * �ʲ��������ݵǼǴ���
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO insertConfigurationCodeDetailAction(IGDRM04DTO dto) throws BLException {
		log.debug("========�ʲ���Ϣ�ǼǴ���ʼ========");
		
		IGDRM0418Form igdrm0418form = dto.getIgdrm0418Form();
		String[] values = igdrm0418form.getCcdvalues();
		igdrm0418form.setCcdtype("A");
		igdrm0418form.setCcdstatus("1");
		String ccdcategory = "";
		SOC0151SearchCondImpl cond = new SOC0151SearchCondImpl();
		List<SOC0151Info> list = this.soc0151BL.searchConfigurationCodeDetail(cond, 0, 0);
		if(list.size()>0){//�����¼�����
			SOC0151Info ConfigurationCodeDetail = list.get(list.size() - 1);
			ccdcategory = ConfigurationCodeDetail.getCcdcategory();
			
			if(ccdcategory.equals("999")){
				throw new BLException("IGSYM0101.E004","���ݻ�����Ϣ");
			}
			if(Integer.parseInt(ccdcategory)<999){
				String tmp = String.valueOf(Integer.valueOf(ccdcategory)+1);
				if(tmp.length()==1){
					ccdcategory = "00"+tmp;
				}else if(tmp.length()==2){
					ccdcategory = "0"+tmp;
				}else{
					ccdcategory = tmp;
				}
			}
			igdrm0418form.setCcdcategory(ccdcategory);
		}else{
			igdrm0418form.setCcdcategory("001");
		}
		if (values!=null && values.length>0) {
			for (int i = 0; i < values.length; i++) {
				igdrm0418form.setCcdvalue(values[i]);
				dto.setIgdrm0418Form(igdrm0418form);
				dto.setConfigurationcodedetail(igdrm0418form);
				SOC0151Info configurationcodedetail = this.soc0151BL.registConfigurationCodeDetail(dto.getConfigurationcodedetail());
				dto.setConfigurationcodedetail(configurationcodedetail);
			}
		}else{
			dto.setIgdrm0418Form(igdrm0418form);
			dto.setConfigurationcodedetail(igdrm0418form);
			SOC0151Info configurationcodedetail = this.soc0151BL.registConfigurationCodeDetail(dto.getConfigurationcodedetail());
			dto.setConfigurationcodedetail(configurationcodedetail);
		}
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "���ݻ�����Ϣ") );

		log.debug("========�ʲ���Ϣ�ǼǴ�������========");
		return dto;
	}
	
/**
 * ��ѯӦ����Դ��������
 * @param dto
 * @return
 * @throws BLException
 */

	public IGDRM04DTO searchEntityNameActionSOC(IGDRM04DTO dto) throws BLException
	{
		SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
		cond.setEsyscoding(dto.getEsyscoding());
		List<SOC0117Info> list = soc0117BL.searchEntity(cond, 0, 0);
		if (list.size() == 1)
		{
			dto.setEname(list.get(0).getEname());
		}
		else
		{
			throw new BLException("IGASM0104.E001", dto.getEsyscoding());
		}
		return dto;
	}
	
	/**
	 * ��ȡӦ����Դ��ϸ��Ϣ
	 * 
	 * @param dto    IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO getEntityFullInfo(IGDRM04DTO dto) throws BLException
	{
		log.debug("========Ӧ����Դ��ϸ��Ϣ������ڻ�����ʼ========");
		
		IGDRM0406Form form = (IGDRM0406Form)dto.getForm();

		// �豸��Ϣ����
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(Integer.valueOf(form.getSp_eiid()));

		if (entityItemVWInfo == null)
		{
			throw new BLException("IGCO10000.E004", "����");
		}

		dto.setSoc0124Info(entityItemVWInfo);

		// ������Ϣ��ѯ����ȡ��
		SOC0107SearchCondImpl socCond = new SOC0107SearchCondImpl();
		BeanUtils.copyProperties(form, socCond);
		// ������������Ϣȫ����ѯ
		SOC0129SearchCondImpl cond = new SOC0129SearchCondImpl();
		cond.setEiid(entityItemVWInfo.getEiid().toString());
		cond.setEsyscoding_q(entityItemVWInfo.getEsyscoding());
		List<SOC0129Info> configItemVWInfoList = this.soc0107BL.searchConfigItemVW(cond, 0, 0);

		Map<String, List<SOC0129Info>> map = new LinkedHashMap<String, List<SOC0129Info>>();
		List<String> strlist = new ArrayList<String>();
		for (SOC0129Info e : configItemVWInfoList)
		{
			if (!map.containsKey(e.getCcategory()))
			{
				map.put(e.getCcategory(), new ArrayList<SOC0129Info>());
				strlist.add(e.getCcategory());
			}
			map.get(e.getCcategory()).add(e);
		}

		dto.setSoc0129InfoVWMap(map);

		log.debug("========������ϸ��Ϣ���ڻ���������========");
		return dto;

	}

	
	
	public IGDRM04DTO getCfgCodeDetailByCategory(IGDRM04DTO dto) throws BLException {
		log.debug("========�ʲ��������ݲ�ѯ����ʼ========");
		SOC0151SearchCondImpl cond = new SOC0151SearchCondImpl();
		cond.setCcdtype("A");
		cond.setCcdcategory(dto.getIgdrm0421Form().getCcdcategory());
		List<SOC0151Info> list = this.soc0151BL.searchConfigurationCodeDetail(cond, 0, 0);
		dto.setConfigurationcodedetail(list.get(0));
		log.debug("========�ʲ��������ݲ�ѯ��������========");
		return dto;
	}
	
	public IGDRM04DTO insertCfgCodeDetailAction(IGDRM04DTO dto) throws BLException {
		log.debug("========�ʲ���Ϣ�ǼǴ���ʼ========");
		IGDRM0421Form igdrm0421form = dto.getIgdrm0421Form();
		String[] values = igdrm0421form.getCcdvalues();
		igdrm0421form.setCcdtype("A");
		igdrm0421form.setCcdstatus("1");
		for (int i = 0; i < values.length; i++) {
			igdrm0421form.setCcdvalue(values[i]);
			dto.setConfigurationcodedetail(igdrm0421form);
			this.soc0151BL.registConfigurationCodeDetail(dto.getConfigurationcodedetail());
		}
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "���ݻ�����Ϣ") );

		log.debug("========�ʲ���Ϣ�ǼǴ�������========");
		return dto;
	}
	
	/**
	 * �ʲ�����Ĭ��ֵ�༭������ڻ�����
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 * @throws BLException
	 */
	public IGDRM04DTO initIGDRM0424Action(IGDRM04DTO dto) throws BLException {
		log.debug("========�ʲ�����Ĭ��ֵ�༭������ڻ�����ʼ========");
		IGDRM0424Form form = dto.getIgDRM0424Form();
		IG611SearchCondImpl cond = new IG611SearchCondImpl();
		cond.setEsyscoding(form.getEsyscoding());
		cond.setEid(form.getEid());
		//������������Ϣȫ����ѯ
		List<IG612Info> lst_IG612Info = this.ig611BL.searchDefaultValue(cond);
		//��ѯ������Ϣ
		SOC0117Info ig117info = soc0117BL.searchEntityByKey(form.getEid());
		if(ig117info != null){
			//Ϊ�������������˵����ֵ
			form.setEname(ig117info.getEname());
			form.setEdesc(ig117info.getEdesc());
		}
		int totalCount = lst_IG612Info.size();
		String[] Cvalue = new String[totalCount];
		String[] entityItemCvalue = new String[totalCount];
		Map<String,List<IG612Info>> map = new LinkedHashMap<String,List<IG612Info>>();
		int i = 0;
		int j = 0;
		List<String> strlist = new ArrayList<String>();
		for(IG612Info e : lst_IG612Info){
			if(!map.containsKey(e.getCcategory())){
				map.put(e.getCcategory(), new ArrayList<IG612Info>());
				strlist.add(e.getCcategory());
			}
			map.get(e.getCcategory()).add(e);
			if("2".equals(e.getCattach())){
				List<LabelValueBean> list = soc0151BL.searchLabelValueBeanList(e.getCoption());
				form.setSelectedListMap(j++, list);
			}
			if ("5".equals(e.getCattach())) {
				List<LabelValueBean> list =soc0151BL.searchLabelValueBeanList(e
						.getCoption());
				if (list.size() > 0) {
					list.remove(0);
				}
				form.setSelectedListMap(j++, list);
			}
		}
		for(String str : strlist){
			for(IG612Info e : map.get(str)){
				//��ʾ���ʲ����ƣ�ʵ�ʴ�ֵ���ʲ�����(�ʲ�ID)
				if("4".equals(e.getCattach()) && StringUtils.isNotEmpty(e.getCvalue())){
					Cvalue[i] = e.getCvalue().substring(0, e.getCvalue().lastIndexOf("("));
					entityItemCvalue[i] = e.getCvalue();
				} else {
					Cvalue[i] = e.getCvalue();
				}
				i++;
			}
		}
		form.setCvalue(Cvalue);
		form.setEntityItemCvalue(entityItemCvalue);
		dto.setMap_IG612Info(map);
		log.debug("========�ʲ�����Ĭ��ֵ�༭������ڻ���������========");
		return dto;
	}
	
	/**
	 * �ʲ�����Ĭ��ֵ�༭����
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 * @throws BLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGDRM04DTO editIGDRM0424Action(IGDRM04DTO dto) throws BLException, FileNotFoundException, IOException {
		log.debug("========�ʲ�����Ĭ��ֵ�༭����ʼ========");
		IGDRM0424Form form = dto.getIgDRM0424Form();
		//��ѯ������Ϣ
		SOC0117Info entity = this.soc0117BL.searchEntityByKey(form.getEid());
		SOC0117TB etb = (SOC0117TB)SerializationUtils.clone(entity);
		etb.setEdesc(form.getEdesc());
		etb.setEname(form.getEname());
		//���·�����Ϣ
		this.soc0117BL.updateEntity(etb);
		for( int i=0 ; i < form.getCid().length; i++ ){
			IG611TB ig611 = new IG611TB();
			//����ID
			ig611.setEid(Integer.parseInt(form.getEid()));
			//�ʲ�����ID
			ig611.setCid(Integer.parseInt(form.getCid()[i]));
			//����
			ig611.setCvalue(form.getCvalue()[i]);
			//��ʾ���ʲ����ƣ�ʵ�ʴ�ֵ���ʲ�����(�ʲ�ID)
			if("4".equals(form.getCiattach()[i]) && StringUtils.isNotEmpty(form.getEntityItemCvalue()[i])){
				ig611.setCvalue(form.getEntityItemCvalue()[i]);
			}
			//����ɾ��
			if("1".equals(form.getCiattach()[i]) && "1".equals(form.getDelfile()[i])){
				ig611.setCvalue("");
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
					//����ID
					pathBuf.append("model");
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
					
					//�ļ���
					fileName.append("_");
					fileName.append(form.getEid());
					fileName.append("&");
					fileName.append(form.getCid()[i]);
					//�ļ���չ��
					fileName.append(fileType);

					//�ļ��ϴ�����
					this.fileUploadBL.saveFile(file, pathBuf.toString(), fileName.toString());
					
					//����
					//�ϴ��ļ�������
					ig611.setCvalue(fileName.toString());
				}
			}
			this.ig611BL.registIG611Info(ig611);
		}
		dto.addMessage(new ActionMessage("IGCO10000.I005","�������༰��������Ϣ"));
		log.debug("========�ʲ�����Ĭ��ֵ�༭��������========");
		return dto;
	}
	/**
	 * Ӧ����Դ�ʲ�������ѯ����(��ʼ��)
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO searchEntityDisp(IGDRM04DTO dto) throws BLException {
		
		log.debug("========�豸��Ϣ��ѯ����ʼ========");
		//��ȡform
		IGDRM0402Form form = dto.getIgdrm0402Form();
		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		EmergencyResourceInfo erInfo = emergencyResourceBL.searchEmergencyResourceByPK(form.getErid());
		String esyscoding = erInfo.getEsyscoding();
		SOC0117VWInfo s117Info = soc0117VWBL.searchEntityByKey(new SOC0117VWPK(Integer.parseInt(esyscoding.split("_")[0]), esyscoding.split("_")[1]));
		form.setEname(s117Info.getEname());
		form.setEsyscoding(esyscoding.split("_")[0]+"_"+esyscoding.split("_")[2]);
		//�豸��Ϣ��ѯ����ȡ�� 
		SOC0118VWSearchCondImpl cond = new SOC0118VWSearchCondImpl();
		cond.setId(Integer.parseInt(esyscoding.split("_")[0]));
		cond.setEsyscoding_like(esyscoding.split("_")[2]);
		int totalCount = this.soc0118VWBL.getEntityItemSearchCount(cond);
		if (totalCount == 0) {
			log.debug("========�ʲ���Ϣ��ѯ���ݲ�����========");
			//�ʲ���Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�ʲ���Ϣ��ѯ���ݼ�������========");
			//�ʲ���Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		List<SOC0118VWInfo> entityItemVWInfoList = this.soc0118VWBL.searchEntityItem(cond,  pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemVWInfoList(entityItemVWInfoList);
		dto.setIgdrm0402Form(form);
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========�豸��Ϣ��ѯ��������========");
		return dto;
	}
	/**
	 * Ӧ����Դ�ʲ�������ѯ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGDRM04DTO searchEntityItemAction(IGDRM04DTO dto) throws BLException {

		log.debug("========�豸��Ϣ��ѯ����ʼ========");
		//��ȡform
		IGDRM0402Form form = dto.getIgdrm0402Form();
		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		
		//�豸��Ϣ��ѯ����ȡ�� 
//		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(dto.getEntityItemVWSearchCond());\
		SOC0118VWSearchCondImpl cond = new SOC0118VWSearchCondImpl();
		cond.setId(Integer.parseInt(form.getEsyscoding().split("_")[0]));
		cond.setEiinsdate_gt(form.getEiupdtime_from());
		cond.setEiinsdate_lt(form.getEiupdtime_to());
		cond.setEiname(form.getEiname());
		cond.setEid(form.getEid());
		cond.setEiname(form.getEiname());
		cond.setEsyscoding_like(form.getEsyscoding().split("_")[1]);
		cond.setEiorgsyscoding(form.getEiorgsyscoding());
		cond.setResourceType(form.getResourceType());
		int totalCount = this.soc0118VWBL.getEntityItemSearchCount(cond);
//		int totalCount = entityItemVWInfoList!=null&&entityItemVWInfoList.size()>0?entityItemVWInfoList.size():0;
		if (totalCount == 0) {
			log.debug("========�ʲ���Ϣ��ѯ���ݲ�����========");
			//�ʲ���Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�ʲ���Ϣ��ѯ���ݼ�������========");
			//�ʲ���Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		List<SOC0118VWInfo> entityItemVWInfoList = this.soc0118VWBL.searchEntityItem(cond,  pDto.getFromCount(), pDto.getPageDispCount());


		//��ǰҳ�ʲ���Ϣȡ��
//		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL.searchEntityItemVW(dto.getEntityItemVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemVWInfoList(entityItemVWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========�豸��Ϣ��ѯ��������========");
		return dto;
	}
	/**
	 * Ӧ����Դ�ʲ���������
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO setRelationAction(IGDRM04DTO dto) throws BLException{
		log.debug("========Ӧ����Դ�����ʲ�����ʼ========");
		IGDRM0402Form form = dto.getIgdrm0402Form();
		String[] relationEiid = form.getRelationEiid();//��Ҫ�������ʲ�
		String ercode = form.getErcode();//Ӧ����Դ����
		Integer erid = form.getErid();//Ӧ����Դid
		ErRelationSearchCondImpl errCond = new ErRelationSearchCondImpl();
		errCond.setErid(erid);
		errCond.setErcode(ercode);
		errCond.setResourceType(form.getResourceType());
		for(String eiid : relationEiid){
			errCond.setEiid(eiid);
			List<ErRelationInfo> errList = erRelationBL.searchErRelation(errCond);
			if(errList!=null&&errList.size()>0){
				if("1".equals(errList.get(0).getDeleteflag())){
					ErRelationTB errTB = (ErRelationTB) SerializationUtils.clone(errList.get(0));
					errTB.setDeleteflag("0");
					erRelationBL.updateErRelation(errTB);
				}
			}else{
				ErRelationTB errTB = new ErRelationTB();
				errTB.setEiid(eiid);
				errTB.setErid(erid);;
				errTB.setErcode(ercode);
				errTB.setDeleteflag("0");
				//ռ�� fingerprint�ֶδ洢 ��Դ���� (1:Ӧ��,0:����);
				//�Ž� 2017��3��17��11:04:03
				errTB.setFingerPrint(form.getResourceType());
				erRelationBL.registErRelation(errTB);
			}
			
		}
		log.debug("========Ӧ����Դ�����ʲ��������========");
		return dto;
	}
	/**
	 * Ӧ����Դ�ʲ��������������ϵ
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO deleteRelationAction(IGDRM04DTO dto) throws BLException{
		log.debug("========Ӧ����Դ������������ʲ�����ʼ========");
		IGDRM0402Form form = dto.getIgdrm0402Form();
		String[] relationEiid = form.getDeleteEiid();//��Ҫ����������ʲ�
//		String ercode = form.getErcode();//Ӧ����Դ����
//		Integer erid = form.getErid();//Ӧ����Դid
		ErRelationSearchCondImpl errCond = new ErRelationSearchCondImpl();
//		errCond.setErid(erid);
//		errCond.setErcode(ercode);
		for(String eiid : relationEiid){
			errCond.setEiid(eiid.split("_")[0]+ "_" +eiid.split("_")[1]);
			errCond.setErcode(eiid.split("_")[2]);
			errCond.setResourceType(form.getResourceType());
			List<ErRelationInfo> errList = erRelationBL.searchErRelation(errCond);
			if(errList!=null&&errList.size()>0){
				ErRelationTB errTB = (ErRelationTB) SerializationUtils.clone(errList.get(0));
				errTB.setDeleteflag("1");
				erRelationBL.updateErRelation(errTB);
			}
		}
		dto.addMessage(new ActionMessage("IGCO10000.I006", "Ӧ����Դ"));
		log.debug("========Ӧ����Դ������������ʲ��������========");
		return dto;
	}
	/**
	 * Ӧ����Դ�޸Ķ�Ӧ�ʲ�ģ�ͣ����й��������޸ģ�
	 *
	 * @param erid
	 * @return boolean
	 */
	public boolean searchRelationAjaxAction(Integer erid) throws BLException{
		ErRelationSearchCondImpl cond = new ErRelationSearchCondImpl();
		cond.setErid(erid);
		cond.setDeleteflag("NOTONE");
		List<ErRelationInfo> list = erRelationBL.searchErRelation(cond);
		if(list!=null&&list.size()>0){
			return true;
		}else{
			
			return false;
		}
	}
	/**
	 * Ӧ����Դ�ʲ��������������ϵ
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO deleteSigleRelationAction(IGDRM04DTO dto) throws BLException{
		log.debug("========Ӧ����Դ�ؽ�����ʲ�����ʼ========");
		IGDRM0402Form form = dto.getIgdrm0402Form();
		Integer eiid = form.getEiid();//��Ҫ����������ʲ�
		String ercode = form.getErcode();//Ӧ����Դ����
		Integer erid = form.getErid();//Ӧ����Դid
		ErRelationSearchCondImpl errCond = new ErRelationSearchCondImpl();
		errCond.setErid(erid);
		errCond.setErcode(ercode);
		errCond.setEiid(eiid+"");
		List<ErRelationInfo> errList = erRelationBL.searchErRelation(errCond);
			if(errList!=null&&errList.size()>0){
				ErRelationTB errTB = (ErRelationTB) SerializationUtils.clone(errList.get(0));
				errTB.setDeleteflag("1");
				erRelationBL.updateErRelation(errTB);
			}
		log.debug("========Ӧ����Դ�ؽ�����ʲ��������========");
		return dto;
	}
	
	/**
	 * ��ȡӦ����Դ��������ʾ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM04DTO getTreeNodeNameCountAction(IGDRM04DTO dto) throws BLException {
		log.debug("=========��ȡӦ����Դ��������ʾ���ݿ�ʼ=========");
		IGDRM0402Form form = dto.getIgdrm0402Form();
		SOC0118VWSearchCondImpl cond = new SOC0118VWSearchCondImpl();
		cond.setEsyscoding_like(form.getErcode());
		cond.setResourceType(dto.getResourceType());
		// Ӧ����Դ��ѯ����ȡ��
		int totalCount = this.soc0118VWBL.getEmergencyRelationCount(cond );
		dto.setAjaxResult(totalCount + "");
		log.debug("=========��ȡӦ����Դ��������ʾ���ݽ���=========");
		return dto;
	}
	
	/** �ʲ���������ȱʡֵBL */
	protected IG611BL ig611BL;

	/**
	 * �ʲ���������ȱʡֵBL�趨
	 * 
	 * @param ig611BL �ʲ���������ȱʡֵBL
	 */
	public void setIg611BL(IG611BL ig611BL) {
		this.ig611BL = ig611BL;
	}
}
