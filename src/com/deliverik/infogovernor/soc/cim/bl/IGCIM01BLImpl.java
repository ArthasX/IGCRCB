package com.deliverik.infogovernor.soc.cim.bl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;
import org.apache.struts.util.LabelValueBean;
import org.apache.struts.util.MessageResources;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.model.entity.CodeDetailTBPK;
import com.deliverik.framework.soc.asset.EiDomainKeyWords;
import com.deliverik.framework.soc.asset.EiRelationKeyWords;
import com.deliverik.framework.soc.asset.EntityCategory;
import com.deliverik.framework.soc.asset.EntityItemKeyWords;
import com.deliverik.framework.soc.asset.SOC0138Info;
import com.deliverik.framework.soc.asset.TableSpaceInfo;
import com.deliverik.framework.soc.asset.bl.task.PlatformManagerBL;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0109BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0110BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0111BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0112BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0113BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0114BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0119BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0126BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0151BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0152BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0153BL;
import com.deliverik.framework.soc.asset.model.PlatformManagerInfo;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0110Info;
import com.deliverik.framework.soc.asset.model.SOC0111Info;
import com.deliverik.framework.soc.asset.model.SOC0112Info;
import com.deliverik.framework.soc.asset.model.SOC0113Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0123Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0126Info;
import com.deliverik.framework.soc.asset.model.SOC0127Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.SOC0152Info;
import com.deliverik.framework.soc.asset.model.SOC0153Info;
import com.deliverik.framework.soc.asset.model.condition.PlatformManagerVWSearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0110SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0126SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0127SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0152SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0153SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.RelationTreeTB;
import com.deliverik.framework.soc.asset.model.entity.SOC0107TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0110TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0112PK;
import com.deliverik.framework.soc.asset.model.entity.SOC0112TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0119TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0123VW;
import com.deliverik.framework.soc.asset.model.entity.SOC0124VW;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.asset.bl.IGASM03BLImpl;
import com.deliverik.infogovernor.soc.bl.task.CR01BL;
import com.deliverik.infogovernor.soc.bl.task.CR03BL;
import com.deliverik.infogovernor.soc.bl.task.SocRelationBL;
import com.deliverik.infogovernor.soc.cim.bl.task.IG500VWBL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0101Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0102Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0104Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0107Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0108Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0110Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0111Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0112Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0114Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0122Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0124Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0127Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0128Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0129Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0135Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0136Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0137Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0139Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0146Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0148Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0149Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0152Form;
import com.deliverik.infogovernor.soc.cim.model.IG500VWInfo;
import com.deliverik.infogovernor.soc.cim.model.condition.IG500VWSearchCondImpl;
import com.deliverik.infogovernor.soc.model.CR01VWInfo;
import com.deliverik.infogovernor.soc.model.CR03VWInfo;
import com.deliverik.infogovernor.soc.model.NetDeviceInfo;
import com.deliverik.infogovernor.soc.model.condition.CR01SearchCondImpl;
import com.deliverik.infogovernor.soc.model.condition.CR03SearchCondImpl;
import com.deliverik.infogovernor.soc.model.entity.SocRelationTB;
import com.deliverik.infogovernor.util.ASMHelper;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * �豸���ù���ҵ���߼�ʵ��
 *
 */
public class IGCIM01BLImpl extends BaseBLImpl implements IGCIM01BL {

	static Log log = LogFactory.getLog(IGCIM01BLImpl.class);
	
	protected static Map<String,String> resource_cid = new HashMap<String,String>();
	static{
		resource_cid.put("CM01010001", "CI010100010025");	//����
		resource_cid.put("CM01010034", "CI010100010025");	//linux
		resource_cid.put("CM01010039", "CI010100010025");	//windows
		resource_cid.put("CM02010001", "CI020100010005");	//oracle
		resource_cid.put("CM02110001", "CI021100010005");	//sqlserver
	}
	
	public static final String DEVICE_DEVICE = "001-001";
	
	public static final String DEVICE_DEVICE_CONN_ID = "1";
	/** �ʲ���ϢBL */
	protected SOC0117BL soc0117BL;

	/** ��������ϢBL */
	protected SOC0118BL soc0118BL;
	
	/** �ʲ�������BL */
	protected SOC0107BL soc0107BL;
	
	/**��·BL*/
	protected SOC0114BL soc0114BL;
	
	/** �������ϵBL */
	protected SOC0119BL soc0119BL;
	
	/** �ļ��ϴ�BL */
	protected FileUploadBL fileUploadBL;
	
	/** �ʲ�ȡֵ��Χ��������BL */
	protected SOC0151BL soc0151BL;
	
	/** �ʲ�������ϵ��������BL */
	protected CodeDetailBL codeDetailBL;
	
	/** ����BL */
	protected OrganizationBL organizationBL;
	
	/** ������BL */
	protected SOC0109BL soc0109BL;
	
	/** �û���ɫBL */
	protected UserRoleBL userRoleBL;
	
	/** SOC��ϵ��BL */
	protected SocRelationBL socRelationBL;

	protected MessageResources resources = MessageResources.getMessageResources("com.deliverik.infogovernor.soc.cim.asmResources"); 
	
	/** ������ϵ��BL */
	protected SOC0110BL soc0110BL;
	
	/** ���汾����ϸBL */
	protected SOC0126BL soc0126BL;
	
	/** ����ϸBL */
	protected SOC0112BL soc0112BL;
	
	/** ������ϢBL */
	protected SOC0111BL soc0111BL;
	
	/** ����Ԫ���ݰ汾��ϢBL */
	protected CR03BL cr03BL;
	
	/** �ɼ����BL */
	protected CR01BL cr01BL;
	
	/** �ʲ���ϵ */
	protected SOC0152BL soc0152BL;
	
	/**��־��ϢBL*/
	private SOC0153BL soc0153BL;
	private SOC0113BL soc0113BL;
	
	protected PlatformManagerBL platformManagerBL;
	
	protected IG500VWBL ig500VWBL;
	
	public void setSoc0114BL(SOC0114BL soc0114bl) {
		soc0114BL = soc0114bl;
	}

	
	public void setSoc0113BL(SOC0113BL soc0113bl) {
		soc0113BL = soc0113bl;
	}


	public void setPlatformManagerBL(PlatformManagerBL platformManagerBL) {
		this.platformManagerBL = platformManagerBL;
	}

	public void setSoc0153BL(SOC0153BL soc0153bl) {
		soc0153BL = soc0153bl;
	}
	
	public void setSoc0117BL(SOC0117BL soc0117BL) {
		this.soc0117BL = soc0117BL;
	}


	public void setSoc0118BL(SOC0118BL soc0118BL) {
		this.soc0118BL = soc0118BL;
	}


	public void setSoc0107BL(SOC0107BL soc0107BL) {
		this.soc0107BL = soc0107BL;
	}


	public void setSoc0119BL(SOC0119BL soc0119BL) {
		this.soc0119BL = soc0119BL;
	}


	public void setSoc0109BL(SOC0109BL soc0109BL) {
		this.soc0109BL = soc0109BL;
	}


	public void setSoc0110BL(SOC0110BL soc0110BL) {
		this.soc0110BL = soc0110BL;
	}


	public void setSoc0126BL(SOC0126BL soc0126BL) {
		this.soc0126BL = soc0126BL;
	}


	public void setSoc0112BL(SOC0112BL soc0112BL) {
		this.soc0112BL = soc0112BL;
	}


	public void setSoc0111BL(SOC0111BL soc0111BL) {
		this.soc0111BL = soc0111BL;
	}


	public void setSocRelationBL(SocRelationBL socRelationBL) {
		this.socRelationBL = socRelationBL;
	}


	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}


	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}
	
	
	public void setSoc0151BL(SOC0151BL soc0151BL) {
		this.soc0151BL = soc0151BL;
	}


	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}
	
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	/**
	 * ����Ԫ���ݰ汾��ϢBL�趨
	 * @param cr03bl ����Ԫ���ݰ汾��ϢBL
	 */
	public void setCr03BL(CR03BL cr03bl) {
		cr03BL = cr03bl;
	}
	
	/**
	 * �ɼ����BL�趨
	 * @param cr01bl �ɼ����BL
	 */
	public void setCr01BL(CR01BL cr01bl) {
		cr01BL = cr01bl;
	}
	
	
	/**
	 * �ʲ���ϵ�趨
	 *
	 * @param soc0152BL �ʲ���ϵ
	 */
	
	public void setSoc0152BL(SOC0152BL soc0152BL) {
		this.soc0152BL = soc0152BL;
	}
	
	

	/**
	 * ig500VWBL�趨
	 * @param ig500VWBL ig500VWBL
	 */
	public void setIg500VWBL(IG500VWBL ig500vwbl) {
		ig500VWBL = ig500vwbl;
	}


	/**
	 * �豸��Ϣ��ѯ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO searchEntityItemAction(IGCIM01DTO dto) throws BLException {

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
	 * �豸��Ϣ�ǼǴ���
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO insertEntityItemAction(IGCIM01DTO dto) throws BLException {
		log.debug("========�豸��Ϣ�ǼǴ���ʼ========");
		//����Formȡ��
		IGCIM0102Form form = dto.getIgasm0302Form();
		
		form.setEidStr(form.getEid().toString());
		
		//����ʱ���趨
		
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		form.setEiupdtime(datetime);
		
		//��汾�趨���̶���Ϊ0��2014/01/26 wj
		form.setEiversion(1);
		
		//С�汾�趨���̶���Ϊ0��
		form.setEismallversion(0);
		
		form.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_NEW);

		//��ȡ�Ǽ�Eilabel
		String[] eilabel = form.getEilabel().split("_");
		String ip = "";
		if(eilabel.length>1){
			ip = eilabel[1];
		}
		SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
		cond.setCivalue(ip);
		cond.setCid("CI010100010005");
		List<SOC0107Info> soc0107infoList = this.soc0107BL.searchSOC0107(cond);
		
		//�豸��Ϣ��¼
		SOC0118Info entityItem = this.soc0118BL.registEntityItem(dto.getIgasm0302Form());
		SOC0118TB ei=(SOC0118TB)SerializationUtils.clone(entityItem);
		if(ei.getEirootmark()==null && soc0107infoList.size()>0){
			ei.setEirootmark(soc0107infoList.get(0).getEiid());
		}else{
			ei.setEirootmark(entityItem.getEiid());
		}
		this.soc0118BL.updateEntityItem(ei);
		form.setEiidStr(entityItem.getEiid().toString());
		
		dto.setIgasm0302Form(form);
		//�豸������Ϣ
		dto.addMessage(new ActionMessage( "IGCO10000.I004", resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.001")) );
		
		log.debug("========�豸��Ϣ�ǼǴ�������========");
		return dto;
	}

	/**
	 * �豸��Ϣɾ������
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO deleteEntityItemAction(IGCIM01DTO dto) throws BLException {
		log.debug("========�豸��Ϣɾ������ʼ========");
		
		List<Integer> retList = new ArrayList<Integer>();//�ݹ�ɾ�������û�ѡ��ɾ�������ظ�
		for( int i=0;i<dto.getDeleteEntityItem().length;i++ ){
			String eiid = dto.getDeleteEntityItem()[i];
			if(!retList.contains(Integer.parseInt(eiid))){
				cycleDelete (eiid,retList);
			}
		}
		for(Integer eiid : retList){
			//ɾ��ǰɾ�������豸ȷ��
			SOC0118Info entityItem = this.soc0118BL.searchEntityItemByKey(eiid);
			
			if (entityItem == null){
				throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.002"));
			}
			this.soc0110BL.delByEiid(eiid);
			//ɾ����ϵ
			this.soc0119BL.delByEiid(eiid);
			//�豸ɾ��
			this.soc0118BL.deleteEntityItem(entityItem);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006",resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.003")));

		log.debug("========�豸��Ϣɾ����������========");
		return dto;
	}
	//�ݹ�ɾ���豸���������
	private List<Integer> cycleDelete (String eiid,List<Integer> retList) throws BLException{
		SOC0119SearchCondImpl cond = new SOC0119SearchCondImpl();
		cond.setEirinfo("#" + eiid + "#");
		cond.setEirstatus("C");
		cond.setDeleteflag("0");
		//����ָ���豸�µ��������������ݹ����
		List<SOC0119Info> list = this.soc0119BL.searchEntityItemRelation(cond, 0, 0);
		for(SOC0119Info eir : list){
			this.cycleDelete(eir.getPareiid()+"",retList);
		}
		if(!retList.contains(Integer.parseInt(eiid))){
			retList.add(Integer.parseInt(eiid));
		}
		return retList;
	}


	
	

	/**
	 * �豸������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initIGASM0305Action(IGCIM01DTO dto) throws BLException {
		log.debug("========�豸������Ϣ��ʷ��¼������ڻ�����ʼ========");
		
		//�豸��Ϣ����
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				Integer.parseInt(dto.getIgasm0305Form().getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.004"));
		}
		
		if ( entityItemVWInfo.getEiversion() == 0 ) {
			dto.addMessage(new ActionMessage("IGASM0205.W001"));
		}
		String eiorgsyscoding = entityItemVWInfo.getEiorgsyscoding();
		if(!StringUtils.isEmpty(eiorgsyscoding)){
			OrganizationSearchCondImpl OrgCond = new OrganizationSearchCondImpl();
			OrgCond.setOrgsyscoding(eiorgsyscoding);
			List<Organization> orgList = this.organizationBL.searchOrganization(OrgCond, 0, 0);
			for (int i = 0; i < orgList.size(); i++) {
				dto.setEiorgname(orgList.get(0).getOrgname());
			}
		}
		dto.setEntityItemVWInfo(entityItemVWInfo);
		
		if (StringUtils.isEmpty(dto.getIgasm0305Form().getCiversion())) {
			dto.getIgasm0305Form().setCiversion(entityItemVWInfo.getEiversion()+"");
		}
		//��ȡ��ʷ�汾����ʱ��
		dto.setConfigItemVersionTime(this.soc0118BL.searchVersionUpdateTime(Integer.parseInt(dto.getIgasm0305Form().getEiid())));
		
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		log.debug("========�豸������Ϣ��ʷ��¼������ڻ���������========");
		return dto;
	}

	/**
	 * �豸������Ϣ�汾�Ƚϻ�����ڻ�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initIGASM0305ActionForXML(IGCIM01DTO dto) throws BLException {
		log.debug("========�豸������Ϣ��ʷ��¼������ڻ�����ʼ========");
		
		//�豸��Ϣ����
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				Integer.parseInt(dto.getIgasm0305Form().getEiid()));
		String eiid = dto.getIgasm0305Form().getEiid();
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.004"));
		}
		
		if ( entityItemVWInfo.getEiversion() == 0 ) {
			dto.addMessage(new ActionMessage("IGASM0205.W001"));
		}
		String eiorgsyscoding = entityItemVWInfo.getEiorgsyscoding();
		if(!StringUtils.isEmpty(eiorgsyscoding)){
			OrganizationSearchCondImpl OrgCond = new OrganizationSearchCondImpl();
			OrgCond.setOrgsyscoding(eiorgsyscoding);
			List<Organization> orgList = this.organizationBL.searchOrganization(OrgCond, 0, 0);
			for (int i = 0; i < orgList.size(); i++) {
				dto.setEiorgname(orgList.get(0).getOrgname());
			}
		}
		dto.setEntityItemVWInfo(entityItemVWInfo);
		
		if (StringUtils.isEmpty(dto.getIgasm0305Form().getCiversion())) {
			dto.getIgasm0305Form().setCiversion(entityItemVWInfo.getEiversion()+"");
		}
		
		String fileversion = entityItemVWInfo.getEiversion() + "";//XML�ļ��汾
		
		if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(entityItemVWInfo.getEmodeltype())) {
			fileversion = fileversion + "_" + entityItemVWInfo.getEismallversion();
		}
		//��ȡ��ʷ�汾����ʱ��
		List<SOC0128Info> old_civtList = this.soc0118BL.searchVersionUpdateTime(Integer.parseInt(dto.getIgasm0305Form().getEiid()));
		List<SOC0128Info> civtList = new ArrayList<SOC0128Info>();
		String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
		for(SOC0128Info civt:old_civtList){
			File verfile = new File(rootPath+"XML"+File.separator+"asm"+File.separator+eiid+File.separator+"config-view.xml_" + fileversion);
			if(verfile.exists()){
				civtList.add(civt);
			}
		}
		
		dto.setConfigItemVersionTime(civtList);
		
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		log.debug("========�豸������Ϣ��ʷ��¼������ڻ���������========");
		return dto;
	}
	
	/**
	 * �豸��ϵ��������ڻ�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initIGASM0306Action(IGCIM01DTO dto) throws BLException {
		log.debug("========�豸��ϵ��������ڻ�����ʼ========");
		
		//�豸��Ϣ����
//		EntityItemVWInfo entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
//				Integer.parseInt(dto.getIgasm0306Form().getEiid()));
		//��ǰ����ͼ�����ǵ�����������ҳ��ֻ�õ�2�������ݣ�ֻ���2�������ݣ�Ȼ��ƴ����ͼ����. _ylq
		SOC0118Info entityItemInfo=soc0118BL.searchEntityItemByKey(Integer.parseInt(dto.getIgcim0106Form().getEiid()));
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
		entityItemVWInfo.setEiorgsyscoding(entityItemInfo.getEiorgsyscoding());
		entityItemVWInfo.setEiversion(entityItemInfo.getEiversion());
		entityItemVWInfo.setEismallversion(entityItemInfo.getEismallversion());
		entityItemVWInfo.setEid(entityItemInfo.getEid());
		entityItemVWInfo.setEiid(entityItemInfo.getEiid());
		entityItemVWInfo.setEirootmark(entityItemInfo.getEirootmark());
		entityItemVWInfo.setEsyscoding(entityItemInfo.getEsyscoding());
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.004"));
		}
		String eiorgsyscoding = entityItemVWInfo.getEiorgsyscoding();
		if(!StringUtils.isEmpty(eiorgsyscoding)){
			OrganizationSearchCondImpl OrgCond = new OrganizationSearchCondImpl();
			OrgCond.setOrgsyscoding(eiorgsyscoding);
			List<Organization> orgList = this.organizationBL.searchOrganization(OrgCond, 0, 0);
			for (int i = 0; i < orgList.size(); i++) {
				dto.setEiorgname(orgList.get(0).getOrgname());
			}
		}
		dto.setEntityItemVWInfo(entityItemVWInfo);
		
		Map<String,List<SOC0119Info>> parmap = new LinkedHashMap<String,List<SOC0119Info>>();
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);
//		Boolean flag=true;
		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		//���������ϵ����
		SOC0119SearchCondImpl parcond = new SOC0119SearchCondImpl();
		parcond.setPareiid(Integer.parseInt(dto.getIgcim0106Form().getEiid()));
		parcond.setParversion(Integer.parseInt(entityItemVWInfo.getEiversion().toString()));
		parcond.setParsmallversion(Integer.parseInt(entityItemVWInfo.getEismallversion().toString()));
		parcond.setDeleteflag("0");
		//�豸��ϵ��Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0119BL.getEntityItemRelationSearchCount(parcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�豸��ϵ��Ϣ��ѯ���ݼ�������========");
			//�豸��ϵ��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		if ( totalCount>0 ) {
			//�豸��ϵ��Ϣȫ������
			List<SOC0119Info> parEntityItemRelationList = 
				this.soc0119BL.searchMaxEntityItemRelation(parcond);
			dto.setParCount(parEntityItemRelationList.size());
			for(SOC0119Info e : parEntityItemRelationList){
				String key = e.getEirrelationcode().split("-")[0];
				String eirrelationcode = e.getEirrelationcode();
				String ecategory = e.getParEntityItemVW().getEcategory();
				if(!"-".equals(eirrelationcode.replaceAll(ecategory, ""))){
					key = eirrelationcode.replaceAll(ecategory, "").replaceAll("-", "");
				}
					if(!parmap.containsKey(key)){
						parmap.put(key, new ArrayList<SOC0119Info>());
					}
					((SOC0119TB)e).setParflag("0");
					parmap.get(key).add(e);
				}
		}

		//���������ϵ����
		//������ϵ����
		SOC0119SearchCondImpl cldcond = new SOC0119SearchCondImpl();
		
		cldcond.setCldeiid(Integer.parseInt(dto.getIgcim0106Form().getEiid()));
		cldcond.setCldversion(entityItemVWInfo.getEiversion());
		cldcond.setCldsmallversion(entityItemVWInfo.getEismallversion());
		cldcond.setDeleteflag("0");
		//�豸��ϵ��Ϣ��ѯ����ȡ�� 
		totalCount = this.soc0119BL.getEntityItemRelationSearchCount(cldcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�豸��ϵ��Ϣ��ѯ���ݼ�������========");
			//�豸��ϵ��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//�豸��ϵ��Ϣȫ������
		List<SOC0119Info> cldEntityItemRelationList = 
			this.soc0119BL.searchMaxEntityItemRelation(cldcond);
		dto.setParCount(dto.getParCount()+cldEntityItemRelationList.size());
//		dto.addMessage(new ActionMessage("IGCO10000.I007",dto.getParCount()));
		for(SOC0119Info e : cldEntityItemRelationList){
			String key = e.getEirrelationcode().split("-")[0];
			String eirrelationcode = e.getEirrelationcode();
			String ecategory = e.getCldEntityItemVW().getEcategory();
			if(!"-".equals(eirrelationcode.replaceAll(ecategory, ""))){
				key = eirrelationcode.replaceAll(ecategory, "").replaceAll("-", "");
			}
			if(!parmap.containsKey(key)){
				parmap.put(key, new ArrayList<SOC0119Info>());
			}
			((SOC0119TB)e).setParflag("1");
			parmap.get(key).add(e);
		}
		if(parmap.size()==0){
			parmap = null;
		}
		dto.setParEntityItemRelationMap(parmap);

		
		log.debug("========�豸��ϵ��������ڻ���������========");
		return dto;
	}
	/**
	 * �豸������ϵ������ڻ�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initIGASM0306BelongAction(IGCIM01DTO dto) throws BLException {
		log.debug("========�豸������ϵ��������ڻ�����ʼ========");
		
		//�豸��Ϣ����
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				Integer.parseInt(dto.getIgcim0106Form().getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.004"));
		}
		String eiorgsyscoding = entityItemVWInfo.getEiorgsyscoding();
		if(!StringUtils.isEmpty(eiorgsyscoding)){
			OrganizationSearchCondImpl OrgCond = new OrganizationSearchCondImpl();
			OrgCond.setOrgsyscoding(eiorgsyscoding);
			List<Organization> orgList = this.organizationBL.searchOrganization(OrgCond, 0, 0);
			for (int i = 0; i < orgList.size(); i++) {
				dto.setEiorgname(orgList.get(0).getOrgname());
			}
		}
		dto.setEntityItemVWInfo(entityItemVWInfo);
		
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		//������ϵ�������
		SOC0110SearchCondImpl belongcond = new SOC0110SearchCondImpl();
		belongcond.setBrpareiid(entityItemVWInfo.getEiid().toString());
		belongcond.setBrparsmallversion(entityItemVWInfo.getEismallversion().toString());
		belongcond.setBrparversion(entityItemVWInfo.getEiversion().toString());
		belongcond.setDeleteflag("0");
		List<SOC0110Info> eiBelongRelationList = null;
		//�豸������ϵ��Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0110BL.getSearchCount(belongcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�豸��ϵ��Ϣ��ѯ���ݼ�������========");
			//�豸������ϵ��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		Map<String,List<SOC0110Info>> rlnmap = new LinkedHashMap<String,List<SOC0110Info>>();
		if ( totalCount>0 ) {
			//�豸������ϵ��Ϣȫ������
			eiBelongRelationList = this.soc0110BL.searchEiBelongRelation(belongcond);
			
			for (SOC0110Info info : eiBelongRelationList) {
				String key = "";
				if("003-002".equals(info.getBrraletioncode())){
					key="ҵ��ϵͳ�����";
				}else if("002-002".equals(info.getBrraletioncode())){
					key="��������";
				}else if("001-001".equals(info.getBrraletioncode())){
					key = "�豸���豸";
				}else if("001-002".equals(info.getBrraletioncode())){
					key = "�豸�����";
				}
				if(!rlnmap.containsKey(key)){
					rlnmap.put(key, new ArrayList<SOC0110Info>());
				}
				rlnmap.get(key).add(info);
			}
		}
		
		
//		//���������ϵ����
//		SOC0110SearchCondImpl cldcond = new SOC0110SearchCondImpl();
//		
//		cldcond.setBrcldeiid(entityItemVWInfo.getEiid().toString());
//		cldcond.setBrcldsmallversion(entityItemVWInfo.getEismallversion().toString());
//		cldcond.setBrcldversion(entityItemVWInfo.getEiversion().toString());
//		cldcond.setDeleteflag("0");
//		//�豸������ϵ��Ϣ��ѯ����ȡ�� 
//		totalCount = this.soc0110BL.getSearchCount(cldcond);
//		
//		if ( totalCount > dto.getMaxSearchCount() ) {
//			log.debug("========�豸��ϵ��Ϣ��ѯ���ݼ�������========");
//			//�豸��ϵ��Ϣ��ѯ���ݼ�������
//			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
//			return dto;
//		}
//
//		if ( totalCount>0 ) {
//			//�豸������ϵ��Ϣȫ������
//			eiBelongRelationList = this.soc0110BL.searchEiBelongRelation(cldcond);
//			
//			for (SOC0110Info info : eiBelongRelationList) {
//				String key = "";
//				if("003-002".equals(info.getBrraletioncode())){
//					key="ҵ��ϵͳ�����";
//				}else if("002-002".equals(info.getBrraletioncode())){
//					key="��������";
//				}else if("001-001".equals(info.getBrraletioncode())){
//					key = "�豸���豸";
//				}else if("001-002".equals(info.getBrraletioncode())){
//					key = "�豸�����";
//				}
//				if(!rlnmap.containsKey(key)){
//					rlnmap.put(key, new ArrayList<SOC0110Info>());
//				}
//				rlnmap.get(key).add(info);
//			}
//		}
		
		dto.setRlnmap(rlnmap);
		//dto.setEiBelongRelationList(eiBelongRelationList);

		log.debug("========�豸������ϵ��������ڻ���������========");
		return dto;
	}
	
	
	/**
	 * �豸��ϵ��������ڻ�����(��ʾȫ��������EIΪ��)
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initIGASM0346Action(IGCIM01DTO dto) throws BLException {
		log.debug("========���ð�����ϵ��ʾ����ʼ========");
		
		IGCIM0146Form form = dto.getIgcim0146Form();
		//��ѯ���������ʲ��������ӽڵ�
		SOC0127SearchCondImpl cond = new SOC0127SearchCondImpl();
		cond.setEirootmark(Integer.parseInt(form.getEirootmark()));
		cond.setBrparversion(Integer.parseInt(form.getEiversion()));
		cond.setBrcldversion(cond.getBrparversion());
		List<SOC0127Info> eibrList = this.soc0110BL.searchEiBelongRelationVW(cond);
		//��ѯ����EI
		SOC0123Info rootEi = this.soc0118BL.searchEntityItemEntityVWByKey(Integer.parseInt(form.getEirootmark()));
		//����ѡ���ʲ���汾��ѯ����EI�����С�汾
		Integer rootEiMaxSmallveision = this.soc0107BL.searchEiMaxSmallVersion(rootEi.getEiid(), Integer.parseInt(form.getEiversion()));
		//����������
		Map<String,TreeNode> treeNodeMap = new LinkedHashMap<String,TreeNode>();
		//�����	
		TreeNode rootNode = new TreeNode();
		rootNode.setId(rootEi.getEiid() + "_" + rootEi.getEiversion() + "_" + rootEiMaxSmallveision);//�ʲ�ID|��汾|С�汾
		rootNode.setName(rootEi.getEiname() + "(" + form.getEiversion() + "." + rootEiMaxSmallveision + ")");//�ʲ�����
		//�ݹ鹹�������ϵ��
		searchConfigurationTreeNode(eibrList, rootEi, rootNode);
		if(rootEi.getEsyscoding().startsWith(EiRelationKeyWords.STORAGE)){
			searchTreeNodeForStorage(eibrList, rootEi, rootNode);
		}
		//�����ڵ�
		treeNodeMap.put(rootNode.getId(),rootNode);		
		dto.setTreeNodeMap(treeNodeMap);
		
		log.debug("========���ð�����ϵ��ʾ��������========");
		return dto;
	}
	
	/**
	 * �豸��ϵ��������ڻ�����(��ʾȫ��������EIΪ��)
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initIGCIM0149Action(IGCIM01DTO dto) throws BLException {
		log.debug("========���ð�����ϵ��ʾ����ʼ========");
		
		IGCIM0146Form form = dto.getIgcim0146Form();
		//��ѯ���������ʲ��������ӽڵ�
		SOC0127SearchCondImpl cond = new SOC0127SearchCondImpl();
		cond.setEirootmark(Integer.parseInt(form.getEirootmark()));
		cond.setBrparversion(Integer.parseInt(form.getEiversion()));
		cond.setBrcldversion(cond.getBrparversion());
		List<SOC0127Info> eibrList = this.soc0110BL.searchEiBelongRelationVW(cond);
		//��ѯ����EI
		SOC0123Info rootEi = this.soc0118BL.searchEntityItemEntityVWByKey(Integer.parseInt(form.getEirootmark()));
		//����ѡ���ʲ���汾��ѯ����EI�����С�汾
		Integer rootEiMaxSmallveision = this.soc0107BL.searchEiMaxSmallVersion(rootEi.getEiid(), Integer.parseInt(form.getEiversion()));
		//����������
		Map<String,TreeNode> treeNodeMap = new LinkedHashMap<String,TreeNode>();
		//�����	
		TreeNode rootNode = new TreeNode();
		rootNode.setId(rootEi.getEiid() + "_" + rootEi.getEiversion() + "_" + rootEiMaxSmallveision);//�ʲ�ID|��汾|С�汾
		rootNode.setName(rootEi.getEiname() + "(" + form.getEiversion() + "." + rootEiMaxSmallveision + ")");//�ʲ�����
		//�ݹ鹹�������ϵ��
		searchConfigurationTreeNode(eibrList, rootEi, rootNode);
		if(rootEi.getEsyscoding().startsWith(EiRelationKeyWords.STORAGE)){
			searchTreeNodeForStorage(eibrList, rootEi, rootNode);
		}
		//�����ڵ�
		treeNodeMap.put(rootNode.getId(),rootNode);		
		dto.setTreeNodeMap(treeNodeMap);
		
		log.debug("========���ð�����ϵ��ʾ��������========");
		return dto;
	}
	
	/**
	 * �豸��ϵ��������ڻ�����(ѡ�е��ʲ�Ϊ��)
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	/*public IGASM03DTO initIGASM0346Action(IGASM03DTO dto) throws BLException {
		log.debug("========���ð�����ϵ��ʾ����ʼ========");
		
		IGASM0346Form form = dto.getIgasm0346Form();
		//��ѯ���������ʲ��������ӽڵ�
		EiBelongRelationVWSearchCondImpl cond = new EiBelongRelationVWSearchCondImpl();
		cond.setEirootmark(Integer.parseInt(form.getEirootmark()));
		cond.setBrparversion(Integer.parseInt(form.getEiversion()));
		cond.setBrcldversion(cond.getBrparversion());
		List<EiBelongRelationVWInfo> eibrList = this.soc0110BL.searchEiBelongRelationVW(cond);
		//��ѯ��ǰEI
		EntityItemEntityVWInfo rootEi = this.soc0118BL.searchEntityItemEntityVWByKey(Integer.parseInt(form.getEiid()));
		//����������
		Map<String,TreeNode> treeNodeMap = new LinkedHashMap<String,TreeNode>();
		//�����	
		TreeNode rootNode = new TreeNode();
		rootNode.setId(rootEi.getEiid() + "_" + form.getEiversion() + "_" + form.getEismallversion());//�ʲ�ID|��汾|С�汾
		rootNode.setName(rootEi.getEiname() + "(" + form.getEiversion() + "." + form.getEismallversion() + ")");//�ʲ�����
		//�ݹ鹹�������ϵ��
		searchConfigurationTreeNode(eibrList, rootEi, rootNode);
		//�����ڵ�
		treeNodeMap.put(rootNode.getId(),rootNode);		
		dto.setTreeNodeMap(treeNodeMap);
		
		log.debug("========���ð�����ϵ��ʾ��������========");
		return dto;
	}*/
	
	/**
	 * �ݹ鹹�����ð���������
	 *
	 * @param eibrList �ڵ㼯��
	 * @param ei �����ʲ��ڵ�
	 * @param parNode �����ڵ�
	 */
	public void searchConfigurationTreeNode(List<SOC0127Info> eibrList,
			SOC0123Info ei, TreeNode parNode) throws BLException {
		
		//�����ڵ㼯��
		for(SOC0127Info eibr : eibrList) {
			if(ei.getEiid().equals(eibr.getBrpareiid())) {//ƥ��ID
				//�����ӽڵ�
				TreeNode cldNode = new TreeNode();
				cldNode.setId(eibr.getBrcldeiid() + "_" + eibr.getBrcldversion() + "_" + eibr.getBrcldsmallversion());//�ʲ�ID|��汾|С�汾
				cldNode.setName(eibr.getCldEntityItemVW().getEiname() + "(" + eibr.getBrcldversion() + "." + eibr.getBrcldsmallversion() + ")");//�ʲ�����
				//����ӽڵ�
				parNode.addChildTreeNode(cldNode.getId(),cldNode);
				//�ݹ�
				searchConfigurationTreeNode(eibrList, eibr.getCldEntityItemVW(), cldNode);
			}
		}
		
	}
	/**
	 * �洢�������faport-fa fa-storage
	 *
	 * @param eibrList �ڵ㼯��
	 * @param ei �����ʲ��ڵ�
	 * @param parNode �����ڵ�
	 */
	public void searchTreeNodeForStorage(List<SOC0127Info> eibrList,
			SOC0123Info ei, TreeNode parNode) throws BLException {
		
		//�����ڵ㼯��
		for(SOC0127Info eibr : eibrList) {
			if(ei.getEiid().equals(eibr.getBrcldeiid())) {//ƥ��ID
				//�����ӽڵ�
				TreeNode cldNode = new TreeNode();
				cldNode.setId(eibr.getBrpareiid() + "_" + eibr.getBrparversion() + "_" + eibr.getBrparsmallversion());//�ʲ�ID|��汾|С�汾
				cldNode.setName(eibr.getParEntityItemVW().getEiname() + "(" + eibr.getBrparversion() + "." + eibr.getBrparsmallversion() + ")");//�ʲ�����
				//����ӽڵ�
				parNode.addChildTreeNode(cldNode.getId(),cldNode);
				//�ݹ�
				searchTreeNodeForStorage(eibrList, eibr.getParEntityItemVW(), cldNode);
			}
		}
		
	}
	
	/**
	 * �豸��ϵɾ������
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO deleteEntityItemRelationAction(IGCIM01DTO dto) throws BLException {
		log.debug("========�豸��ϵɾ������ʼ========");
		
		for( int i=0;i<dto.getDeleteEntityItemRelation().length;i++ ){
			String eirid = dto.getDeleteEntityItemRelation()[i];
			
			SOC0119Info entityItemRelation = 
				this.soc0119BL.searchEntityItemRelationByKey(Integer.parseInt(eirid));
			
			if (entityItemRelation == null){
				throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.008"));
			}

			this.soc0119BL.deleteEntityItemRelation(entityItemRelation);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006",resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.009")));

		log.debug("========�豸��ϵɾ����������========");
		return dto;
	}

	/**
	 * �豸������ϵɾ������
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO deleteEiBelongRelationAction(IGCIM01DTO dto) throws BLException {
		log.debug("========�豸������ϵɾ������ʼ========");
		
		for( int i=0;i<dto.getDeleteEntityItemRelation().length;i++ ){
			String eirid = dto.getDeleteEntityItemRelation()[i];
			
			SOC0110Info eiBelongRelationInfo = 
				this.soc0110BL.searchEiBelongRelationByPK(Integer.parseInt(eirid));
			
			if (eiBelongRelationInfo == null){
				throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.013"));
			}

			this.soc0110BL.deleteEiBelongRelation(eiBelongRelationInfo);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006",resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.013")));

		log.debug("========�豸������ϵɾ����������========");
		return dto;
	}
	/**
	 * �豸������ϵ�ǼǴ���
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO insertEntityItemEiBelongRelationAction(IGCIM01DTO dto) throws BLException {
		log.debug("========�豸������ϵ�ǼǴ���ʼ========");
		
		IGCIM0107Form form = dto.getIgcim0107Form();
		
		//�豸ID���ӣ�ȡ��
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		
		cond.setElabel(form.getElabel());
		cond.setEilabel(form.getEilabel());
		
		List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
		
		if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.010")
					+ form.getElabel() + resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.011") 
					+ form.getEilabel() + resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.012"));
		}
		
		
		//�豸ID�������ͣ��ӣ����
		if (form.getPareiid().intValue() == form.getCldeiid().intValue()) {
			//�豸ID������= ���ӣ�
			throw new BLException(BLErrorType.ENTITY_ITEM_RELATION_ERROR,
					"IGCO10000.E012",resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.004"));
		}
		
		
		SOC0110SearchCondImpl belongcond = new SOC0110SearchCondImpl();
		belongcond.setBrpareiid(form.getPareiid().toString());
		belongcond.setBrparsmallversion(form.getParsmallversion().toString());
		belongcond.setBrparversion(form.getParversion().toString());
		belongcond.setBrcldeiid(entityItemVWList.get(0).getEiid().toString());
		belongcond.setBrcldversion(entityItemVWList.get(0).getEiversion().toString());
		belongcond.setBrcldsmallversion(entityItemVWList.get(0).getEismallversion().toString());
		belongcond.setDeleteflag("0");
		
		int totalCount = this.soc0110BL.getSearchCount(belongcond);
		if(totalCount>0){
			//ͬһ������ϵ�Ѿ�����
			throw new BLException(BLErrorType.ENTITY_ITEM_RELATION_ERROR,"IGCO10000.E026");
		}
		
		//������ϵ�Ǽ�
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		SOC0110TB eiBelongRelationTB = soc0110BL.getEiBelongRelationTBInstance();
		eiBelongRelationTB.setBrpareiid(form.getPareiid());
		eiBelongRelationTB.setBrparsmallversion(form.getParsmallversion());
		eiBelongRelationTB.setBrparversion(form.getParversion());
		eiBelongRelationTB.setBrcldeiid(entityItemVWList.get(0).getEiid());
		eiBelongRelationTB.setBrcldsmallversion(entityItemVWList.get(0).getEismallversion());
		eiBelongRelationTB.setBrcldversion(entityItemVWList.get(0).getEiversion());
		eiBelongRelationTB.setBrcreatetime(datetime);
		eiBelongRelationTB.setBrdes(form.getEirdesc());
		
		eiBelongRelationTB.setBrraletioncode(form.getEirrelationcode());
		eiBelongRelationTB.setBrassetrelation(form.getEirrelation());
		
		eiBelongRelationTB.setBrtype(form.getBelongType());
		eiBelongRelationTB.setEirootmark(form.getEirootmark());
		
		soc0110BL.registEiBelongRelation(eiBelongRelationTB);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.013")) );
		
		log.debug("========�豸������ϵ�ǼǴ�������========");
		return dto;
	}
	/**
	 * �豸��ϵ�༭������ڻ�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initIGASM0307Action(IGCIM01DTO dto) throws BLException {
		log.debug("========�豸��ϵ�༭������ڻ�����ʼ========");
		
		IGCIM0107Form form = dto.getIgcim0107Form();
		SOC0119TB ret = 		
			(SOC0119TB) this.soc0119BL.searchEntityItemRelationByKey(
				form.getEirid());
		
		if ( ret == null ){
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.014"));
		}
		
		//��������趨
		form.setPareiname(ret.getParEntityItemVW().getEiname());
		form.setPareid(ret.getPareid());
		form.setPareiid(ret.getPareiid());
		form.setCldeid(ret.getCldeid());
		form.setCldeiid(ret.getCldeiid());
		form.setEiridStr(ret.getEirid().toString());
		form.setEirdesc(ret.getEirdesc());
		form.setEirinfo(ret.getEirinfo());
		form.setEirrelation(ret.getEirrelation());
		form.setEirrelationcode(ret.getEirrelationcode());
		form.setElabel(ret.getCldEntityItemVW().getElabel());
		form.setEilabel(ret.getCldEntityItemVW().getEilabel());
		form.setEiname(ret.getCldEntityItemVW().getEiname());
		form.setTempeirrelation(ret.getEirrelation()+"#"+ret.getEirrelationcode());
		form.setMode("1");
		
		log.debug("========�豸��ϵ�༭������ڻ���������========");
		return dto;
	}

	
	/**
	 * �豸�·���Ϣ��ѯ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO searchNewAndReciveEntityItemAction(IGCIM01DTO dto) throws BLException {

		log.debug("========�豸�·���Ϣ��ѯ����ʼ========");
		
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

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========�豸�·���Ϣ��ѯ��������========");
		return dto;
	}
	

	
	/**
	 * �豸�Ͻ���Ϣ��ѯ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO searchUsingEntityItemAction(IGCIM01DTO dto)
			throws BLException {
		log.debug("========�豸�Ͻ���Ϣ��ѯ����ʼ========");
		
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

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========�豸�Ͻ���Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * �豸������Ϣ��ѯ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO searchCanScrapEntityItemAction(IGCIM01DTO dto) throws BLException {
		log.debug("========�豸������Ϣ��ѯ����ʼ========");
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
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		log.debug("========�豸������Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * �豸�·�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityIssueAction(IGCIM01DTO dto) throws BLException {

		log.debug("========�豸�·�����ʼ========");
		
		SOC0118TB entityItem = (SOC0118TB)soc0118BL.searchEntityItemByKey(dto.getIgasm0309Form().getEiid());
		entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_USE);
//		entityItem.setEiorgsyscoding(dto.getIgasm0309Form().getOrgid());
		entityItem.setEiversion(entityItem.getEiversion() + 1);
		soc0118BL.updateEntityItem(entityItem);
		
		SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
		cond.setEiid(String.valueOf(dto.getIgasm0309Form().getEiid()));
		cond.setCiversion(dto.getIgasm0309Form().getEiversion());
		List<SOC0107Info> configItemList = soc0107BL.searchSOC0107(cond, 0, 0);
		
		for (SOC0107Info configItem : configItemList) {
			SOC0107TB ciTB = (SOC0107TB)SerializationUtils.clone(configItem);
			ciTB.setCiversion(configItem.getCiversion() + 1);
			String cLabel = configItem.getConfiguration().getClabel();
			if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_STATUS.equals(cLabel)){
				ciTB.setCivalue(CommonDefineUtils.ENTITYITEM_STARUS_USE);
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORID.equals(cLabel)){
				ciTB.setCivalue(dto.getUserid());
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORNAME.equals(cLabel)){
				ciTB.setCivalue(dto.getUsername());
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVENAME.equals(cLabel)){
				ciTB.setCivalue(dto.getIgasm0309Form().getReciveUser());
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGNAME.equals(cLabel)){
				ciTB.setCivalue(dto.getIgasm0309Form().getOrgname());
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGCODE.equals(cLabel)){
				ciTB.setCivalue(dto.getIgasm0309Form().getOrgid());
			}
			if(configItem.getCivalue().equals(ciTB.getCivalue())) {
				//���Ը��±�ʶ
				ciTB.setCicurver("0");
			} else {
				//���Ը��±�ʶ
				ciTB.setCicurver("1");
			}
			SOC0107Info ci = soc0107BL.registSOC0107(ciTB);
			//�������Ϊ�ʲ�ʱ���޸Ĺ�����ϵ
			if("4".equals(configItem.getConfiguration().getCattach()) && StringUtils.isNotEmpty(configItem.getCivalue())){
				SOC0119TB e = new SOC0119TB();
				e.setPareid(entityItem.getEid());
				e.setPareiid(entityItem.getEiid());
				String str = configItem.getCivalue();			
				SOC0118Info ei = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
				e.setCldeid(ei.getEid());
				e.setCldeiid(ei.getEiid());
				//У���ϵ�Ƿ����
				SOC0119SearchCondImpl eirCond = new SOC0119SearchCondImpl();
				eirCond.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
				eirCond.setEirstatus("C");
				eirCond.setDeleteflag("0");
				List<SOC0119Info> eirlist = this.soc0119BL.searchEntityItemRelation(eirCond, 0, 0);
				if(eirlist.size() != 1) {
					throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR, "IGCO10000.E017");
				} else {
					SOC0119TB eirTB = (SOC0119TB)SerializationUtils.clone(eirlist.get(0));
					
					eirTB.setEirinfo(eirTB.getEirinfo().replaceAll("_" + configItem.getCiid() + "_", "_" + ci.getCiid() + "_"));
					
					this.soc0119BL.updateEntityItemRelation(eirTB);
				}
			}
		}
		
		dto.addMessage(new ActionMessage("IGASM0309.I001"));
	}
	
	/**
	 * �豸�����·�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityBatchIssueAction(IGCIM01DTO dto) throws BLException{
		for (int i = 0; i < dto.getBatchEntityItem().length; i++) {
			SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
			String eiid = dto.getBatchEntityItem()[i];
			cond.setEiid(eiid);
			SOC0118TB entityItem = (SOC0118TB)soc0118BL.searchEntityItemByKey(Integer.parseInt(eiid));
			cond.setCiversion(String.valueOf(entityItem.getEiversion()));
			List<SOC0107Info> configItemList = soc0107BL.searchSOC0107(cond, 0, 0);
			
			for (SOC0107Info configItem : configItemList) {
				SOC0107TB ciTB = (SOC0107TB)SerializationUtils.clone(configItem);
				ciTB.setCiversion(configItem.getCiversion() + 1);
				String cLabel = configItem.getConfiguration().getClabel();
				if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_STATUS.equals(cLabel)){
					ciTB.setCivalue(CommonDefineUtils.ENTITYITEM_STARUS_USE);
				} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORID.equals(cLabel)){
					ciTB.setCivalue(dto.getUserid());
				} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORNAME.equals(cLabel)){
					ciTB.setCivalue(dto.getUsername());
				} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVENAME.equals(cLabel)){
					ciTB.setCivalue(dto.getIgasm0309Form().getReciveUser());
				} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGNAME.equals(cLabel)){
					ciTB.setCivalue(dto.getIgasm0309Form().getOrgname());
				} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGCODE.equals(cLabel)){
					ciTB.setCivalue(dto.getIgasm0309Form().getOrgid());
				}
				if(configItem.getCivalue().equals(ciTB.getCivalue())) {
					//���Ը��±�ʶ
					ciTB.setCicurver("0");
				} else {
					//���Ը��±�ʶ
					ciTB.setCicurver("1");
				}
				SOC0107Info ci = soc0107BL.registSOC0107(ciTB);
				//�������Ϊ�ʲ�ʱ���޸Ĺ�����ϵ
				if("4".equals(configItem.getConfiguration().getCattach()) && StringUtils.isNotEmpty(configItem.getCivalue())){
					SOC0119TB e = new SOC0119TB();
					e.setPareid(entityItem.getEid());
					e.setPareiid(entityItem.getEiid());
					String str = configItem.getCivalue();			
					SOC0118Info ei = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
					e.setCldeid(ei.getEid());
					e.setCldeiid(ei.getEiid());
					//У���ϵ�Ƿ����
					SOC0119SearchCondImpl eirCond = new SOC0119SearchCondImpl();
					eirCond.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
					eirCond.setEirstatus("C");
					eirCond.setDeleteflag("0");
					List<SOC0119Info> eirlist = this.soc0119BL.searchEntityItemRelation(eirCond, 0, 0);
					if(eirlist.size() != 1) {
						throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR, "IGCO10000.E017");
					} else {
						SOC0119TB eirTB = (SOC0119TB)SerializationUtils.clone(eirlist.get(0));
						
						eirTB.setEirinfo(eirTB.getEirinfo().replaceAll("_" + configItem.getCiid() + "_", "_" + ci.getCiid() + "_"));
						
						this.soc0119BL.updateEntityItemRelation(eirTB);
					}
				}
			}
			
			entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_USE);
			entityItem.setEiversion(entityItem.getEiversion() + 1);
			soc0118BL.updateEntityItem(entityItem);
		}
		dto.addMessage(new ActionMessage("IGASM0309.I001"));
	}
	
	/**
	 * ��ѯָ��eiid�Ĵ��Ͻ��豸
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO searchEntityPayByEiidAction(IGCIM01DTO dto) throws BLException {

		log.debug("========���Ͻ��豸��ѯ��ʼ========");
		SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
		cond.setEiid(String.valueOf(dto.getIgasm0313Form().getEiid()));
		List<SOC0107Info> configItemList = soc0107BL.searchSOC0107(cond, 0, 0);
		ArrayList<SOC0107Info> list = new ArrayList<SOC0107Info>();//�洢���µ��豸�汾��Ϣ
		//int version = 0;
		//ȡ�����µİ汾��Ϣ
//		for(int i = 0,j = configItemList.size();i<j;i++ ){
//			if(i==0){
//				version = configItemList.get(i).getCiversion();
//				list.add(configItemList.get(i));
//			}else{
//				if(version==configItemList.get(i).getCiversion()){
//					list.add(configItemList.get(i));
//				}
//			}
//			
//		}
		for(int i = 0,j = configItemList.size();i<j;i++ ){
			if(Integer.valueOf(dto.getEiversion())==configItemList.get(i).getCiversion()){
				list.add(configItemList.get(i));
			}
		}
		//ȡ��������,����
		for(SOC0107Info config:list){
			if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVENAME.equals(config.getConfiguration().getClabel())){//������name
				dto.setRecivename(config.getCivalue());
			}
			if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGNAME.equals(config.getConfiguration().getClabel())){//������org
				dto.setOrgname(config.getCivalue());
				
			}
		}
		log.debug("========���Ͻ��豸��ѯ����========");
		return dto;
	}
	
	/**
	 * �豸�Ͻɴ���
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityPayAction(IGCIM01DTO dto) throws BLException {

		log.debug("========�豸�Ͻɴ���ʼ========");
		SOC0118TB entityItem = (SOC0118TB)soc0118BL.searchEntityItemByKey(dto.getIgasm0313Form().getEiid());
		entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_RENEW);
	//	entityItem.setEiorgsyscoding(dto.getIgasm0313Form().getEiiorgid().substring(0, 4));//ȡ�����˻�����1������
		entityItem.setEiversion(entityItem.getEiversion() + 1);
		soc0118BL.updateEntityItem(entityItem);
		
		SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
		cond.setEiid(String.valueOf(dto.getIgasm0313Form().getEiid()));
		cond.setCiversion(dto.getIgasm0313Form().getEiversion());
		List<SOC0107Info> configItemList = soc0107BL.searchSOC0107(cond, 0, 0);
		
		for (SOC0107Info configItem : configItemList) {
			SOC0107TB ciTB = (SOC0107TB)SerializationUtils.clone(configItem);
			ciTB.setCiversion(configItem.getCiversion() + 1);
			String cLabel = configItem.getConfiguration().getClabel();
			if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_STATUS.equals(cLabel)){//�ʲ�״̬
				ciTB.setCivalue(CommonDefineUtils.ENTITYITEM_STARUS_RENEW);
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORID.equals(cLabel)){//������ID
				ciTB.setCivalue(dto.getUserid());
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORNAME.equals(cLabel)){//������name
				ciTB.setCivalue(dto.getUsername());
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVENAME.equals(cLabel)){
				ciTB.setCivalue("");
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGNAME.equals(cLabel)){
				ciTB.setCivalue("");
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGCODE.equals(cLabel)){
				ciTB.setCivalue("");
			}
			if(configItem.getCivalue().equals(ciTB.getCivalue())) {
				//���Ը��±�ʶ
				ciTB.setCicurver("0");
			} else {
				//���Ը��±�ʶ
				ciTB.setCicurver("1");
			}
			SOC0107Info ci = soc0107BL.registSOC0107(ciTB);
			//�������Ϊ�ʲ�ʱ���޸Ĺ�����ϵ
			if("4".equals(configItem.getConfiguration().getCattach()) && StringUtils.isNotEmpty(configItem.getCivalue())){
				SOC0119TB e = new SOC0119TB();
				e.setPareid(entityItem.getEid());
				e.setPareiid(entityItem.getEiid());
				String str = configItem.getCivalue();			
				SOC0118Info ei = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
				e.setCldeid(ei.getEid());
				e.setCldeiid(ei.getEiid());
				//У���ϵ�Ƿ����
				SOC0119SearchCondImpl eirCond = new SOC0119SearchCondImpl();
				eirCond.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
				eirCond.setEirstatus("C");
				eirCond.setDeleteflag("0");
				List<SOC0119Info> eirlist = this.soc0119BL.searchEntityItemRelation(eirCond, 0, 0);
				if(eirlist.size() != 1) {
					throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR, "IGCO10000.E017");
				} else {
					SOC0119TB eirTB = (SOC0119TB)SerializationUtils.clone(eirlist.get(0));
					
					eirTB.setEirinfo(eirTB.getEirinfo().replaceAll("_" + configItem.getCiid() + "_", "_" + ci.getCiid() + "_"));
					
					this.soc0119BL.updateEntityItemRelation(eirTB);
				}
			}
		}
		dto.addMessage(new ActionMessage("IGASM0313.I001"));
		
	}
	
	/**
	 * �豸�����Ͻɴ���
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityBatchPayAction(IGCIM01DTO dto) throws BLException {

		log.debug("========�豸�����Ͻɴ���ʼ========");
		for (int i = 0; i < dto.getBatchEntityItem().length; i++) {
		SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
		String eiid = dto.getBatchEntityItem()[i];
		cond.setEiid(eiid);
		SOC0118TB entityItem = (SOC0118TB)soc0118BL.searchEntityItemByKey(Integer.parseInt(eiid));
		cond.setCiversion(String.valueOf(entityItem.getEiversion()));
		List<SOC0107Info> configItemList = soc0107BL.searchSOC0107(cond, 0, 0);
		
		for (SOC0107Info configItem : configItemList) {
			SOC0107TB ciTB = (SOC0107TB)SerializationUtils.clone(configItem);
			ciTB.setCiversion(configItem.getCiversion() + 1);
			String cLabel = configItem.getConfiguration().getClabel();
			if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_STATUS.equals(cLabel)){//�ʲ�״̬
				ciTB.setCivalue(CommonDefineUtils.ENTITYITEM_STARUS_RENEW);
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORID.equals(cLabel)){//������ID
				ciTB.setCivalue(dto.getUserid());
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORNAME.equals(cLabel)){//������name
				ciTB.setCivalue(dto.getUsername());
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVENAME.equals(cLabel)){
				ciTB.setCivalue("");
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGNAME.equals(cLabel)){
				ciTB.setCivalue("");
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGCODE.equals(cLabel)){
				ciTB.setCivalue("");
			}
			if(configItem.getCivalue().equals(ciTB.getCivalue())) {
				//���Ը��±�ʶ
				ciTB.setCicurver("0");
			} else {
				//���Ը��±�ʶ
				ciTB.setCicurver("1");
			}
			SOC0107Info ci = soc0107BL.registSOC0107(ciTB);
			//�������Ϊ�ʲ�ʱ���޸Ĺ�����ϵ
			if("4".equals(configItem.getConfiguration().getCattach()) && StringUtils.isNotEmpty(configItem.getCivalue())){
				SOC0119TB e = new SOC0119TB();
				e.setPareid(entityItem.getEid());
				e.setPareiid(entityItem.getEiid());
				String str = configItem.getCivalue();			
				SOC0118Info ei = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
				e.setCldeid(ei.getEid());
				e.setCldeiid(ei.getEiid());
				//У���ϵ�Ƿ����
				SOC0119SearchCondImpl eirCond = new SOC0119SearchCondImpl();
				eirCond.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
				eirCond.setEirstatus("C");
				eirCond.setDeleteflag("0");
				List<SOC0119Info> eirlist = this.soc0119BL.searchEntityItemRelation(eirCond, 0, 0);
				if(eirlist.size() != 1) {
					throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR, "IGCO10000.E017");
				} else {
					SOC0119TB eirTB = (SOC0119TB)SerializationUtils.clone(eirlist.get(0));
					
					eirTB.setEirinfo(eirTB.getEirinfo().replaceAll("_" + configItem.getCiid() + "_", "_" + ci.getCiid() + "_"));
					
					this.soc0119BL.updateEntityItemRelation(eirTB);
				}
			}
		}
		entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_RENEW);
		entityItem.setEiversion(entityItem.getEiversion() + 1);
		soc0118BL.updateEntityItem(entityItem);
		}
		dto.addMessage(new ActionMessage("IGASM0313.I001"));
		log.debug("========�豸�����Ͻɴ���ʼ========");
		
	}
	public IGCIM01DTO searchPreScrapEntityItemAction(IGCIM01DTO dto) throws BLException {
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(dto.getIgasm0311Form().getEiid());
		dto.setEntityItemVWInfo(entityItemVWInfo);
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);
		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E023","Ԥ����"));
		}
		dto.setFlag(flag);
		return dto;
	}
	
	public IGCIM01DTO searchScrapEntityItemAction(IGCIM01DTO dto) throws BLException {
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(dto.getIgasm0314Form().getEiid());
		dto.setEntityItemVWInfo(entityItemVWInfo);
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);
		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E023","����"));
		}
		dto.setFlag(flag);
		return dto;
	}
	
	public IGCIM01DTO searchReceiveEntityItemAction(IGCIM01DTO dto) throws BLException {
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(dto.getIgasm0315Form().getEiid());
		dto.setEntityItemVWInfo(entityItemVWInfo);
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);
		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E023","����Ԥ����"));
		}
		dto.setFlag(flag);
		return dto;
	}
		
	/**
	 * �豸Ԥ���ϴ���
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityPreScrapAction(IGCIM01DTO dto) throws BLException {
			SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
			cond.setEiid(String.valueOf(dto.getIgasm0311Form().getEiid()));
			cond.setCiversion(dto.getIgasm0311Form().getEiversion());
			this.saveConfigItem(dto, cond, CommonDefineUtils.ENTITYITEM_STARUS_PRESCRAP);
			
			SOC0118TB entityItem = (SOC0118TB)soc0118BL.searchEntityItemByKey(dto.getIgasm0311Form().getEiid());
			entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_PRESCRAP);
			entityItem.setEiversion(entityItem.getEiversion() + 1);
			soc0118BL.updateEntityItem(entityItem);
	}
	
	public void entityPreScrapBatchAction(IGCIM01DTO dto) throws BLException {
		for (int i = 0; i < dto.getBatchEntityItem().length; i++) {
			SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
			cond.setEiid(dto.getBatchEntityItem()[i]);
			SOC0118TB entityItem = (SOC0118TB)soc0118BL.searchEntityItemByKey(Integer.parseInt(dto.getBatchEntityItem()[i]));
			cond.setCiversion(String.valueOf(entityItem.getEiversion()));
			this.saveConfigItem(dto, cond, CommonDefineUtils.ENTITYITEM_STARUS_PRESCRAP);
			
			entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_PRESCRAP);
			entityItem.setEiversion(entityItem.getEiversion() + 1);
			soc0118BL.updateEntityItem(entityItem);
		}
	}
	
	/**
	 * �豸���ϴ���
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityScrapAction(IGCIM01DTO dto) throws BLException {
		SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
		cond.setEiid(String.valueOf(dto.getIgasm0314Form().getEiid()));
		cond.setCiversion(dto.getIgasm0314Form().getEiversion());
		this.saveConfigItem(dto, cond, CommonDefineUtils.ENTITYITEM_STARUS_SCRAP);
		
		SOC0118TB entityItem = (SOC0118TB)soc0118BL.searchEntityItemByKey(dto.getIgasm0314Form().getEiid());
		entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_SCRAP);
		entityItem.setEiversion(entityItem.getEiversion() + 1);
		soc0118BL.updateEntityItem(entityItem);
	}
	
	public void entityScrapBatchAction(IGCIM01DTO dto) throws BLException {
		for (int i = 0; i < dto.getBatchEntityItem().length; i++) {
			SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
			cond.setEiid(dto.getBatchEntityItem()[i]);
			SOC0118TB entityItem = (SOC0118TB)soc0118BL.searchEntityItemByKey(Integer.parseInt(dto.getBatchEntityItem()[i]));
			cond.setCiversion(String.valueOf(entityItem.getEiversion()));
			this.saveConfigItem(dto, cond, CommonDefineUtils.ENTITYITEM_STARUS_SCRAP);
			
			entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_SCRAP);
			entityItem.setEiversion(entityItem.getEiversion() + 1);
			soc0118BL.updateEntityItem(entityItem);
		}
	}
	
	/**
	 * �豸Ԥ���ϳ�������
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityCancelPreScrapAction(IGCIM01DTO dto) throws BLException {
		SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
		cond.setEiid(String.valueOf(dto.getIgasm0315Form().getEiid()));
		cond.setCiversion(dto.getIgasm0315Form().getEiversion());
		this.saveConfigItem(dto, cond, CommonDefineUtils.ENTITYITEM_STARUS_RENEW);
		
		SOC0118TB entityItem = (SOC0118TB)soc0118BL.searchEntityItemByKey(dto.getIgasm0315Form().getEiid());
		entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_RENEW);
		entityItem.setEiversion(entityItem.getEiversion() + 1);
		soc0118BL.updateEntityItem(entityItem);
	}
	public void entityCancelPreScrapBatchAction(IGCIM01DTO dto) throws BLException {
		for (int i = 0; i < dto.getBatchEntityItem().length; i++) {
			SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
			cond.setEiid(dto.getBatchEntityItem()[i]);
			SOC0118TB entityItem = (SOC0118TB)soc0118BL.searchEntityItemByKey(Integer.parseInt(dto.getBatchEntityItem()[i]));
			cond.setCiversion(String.valueOf(entityItem.getEiversion()));
			this.saveConfigItem(dto, cond, CommonDefineUtils.ENTITYITEM_STARUS_RENEW);
			
			entityItem.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_RENEW);
			entityItem.setEiversion(entityItem.getEiversion() + 1);
			soc0118BL.updateEntityItem(entityItem);
		}
	}
	
	private void saveConfigItem(IGCIM01DTO dto,SOC0107SearchCond cond,String status) throws BLException {
		List<SOC0107Info> configItemList = soc0107BL.searchSOC0107(cond, 0, 0);
		for (SOC0107Info configItem : configItemList) {
			SOC0107TB ciTB = (SOC0107TB)SerializationUtils.clone(configItem);
			ciTB.setCiversion(configItem.getCiversion() + 1);
			String cLabel = configItem.getConfiguration().getClabel();
			if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_STATUS.equals(cLabel)){
				ciTB.setCivalue(status);
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORID.equals(cLabel)){
				ciTB.setCivalue(dto.getUserid());
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORNAME.equals(cLabel)){
				ciTB.setCivalue(dto.getUsername());
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVENAME.equals(cLabel)){
				ciTB.setCivalue("");
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGNAME.equals(cLabel)){
				ciTB.setCivalue("");
			} else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGCODE.equals(cLabel)){
				ciTB.setCivalue("");
			}
			if(configItem.getCivalue().equals(ciTB.getCivalue())) {
				//���Ը��±�ʶ
				ciTB.setCicurver("0");
			} else {
				//���Ը��±�ʶ
				ciTB.setCicurver("1");
			}
			SOC0107Info ci = soc0107BL.registSOC0107(ciTB);
			SOC0118TB entityItem = (SOC0118TB)soc0118BL.searchEntityItemByKey(Integer.parseInt(cond.getEiid()));
			//�������Ϊ�ʲ�ʱ���޸Ĺ�����ϵ
			if("4".equals(configItem.getConfiguration().getCattach()) && StringUtils.isNotEmpty(configItem.getCivalue())){
				SOC0119TB e = new SOC0119TB();
				e.setPareid(entityItem.getEid());
				e.setPareiid(entityItem.getEiid());
				String str = configItem.getCivalue();			
				SOC0118Info ei = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
				e.setCldeid(ei.getEid());
				e.setCldeiid(ei.getEiid());
				//У���ϵ�Ƿ����
				SOC0119SearchCondImpl eirCond = new SOC0119SearchCondImpl();
				eirCond.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
				eirCond.setEirstatus("C");
				eirCond.setDeleteflag("0");
				List<SOC0119Info> eirlist = this.soc0119BL.searchEntityItemRelation(eirCond, 0, 0);
				if(eirlist.size() != 1) {
					throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR, "IGCO10000.E017");
				} else {
					SOC0119TB eirTB = (SOC0119TB)SerializationUtils.clone(eirlist.get(0));
					
					eirTB.setEirinfo(eirTB.getEirinfo().replaceAll("_" + configItem.getCiid() + "_", "_" + ci.getCiid() + "_"));
					
					this.soc0119BL.updateEntityItemRelation(eirTB);
				}
			}
		}
	}	
	/**
	 *�豸��Ϣ�޸ĳ�����ʾ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initEntityItem(IGCIM01DTO dto) throws BLException {

		log.debug("========�豸��Ϣ�༭���������ʾ����ʼ========");
		
		IGCIM0108Form form = dto.getIgcim0108Form();
		
		//��ʾ���ʲ���Ϣȡ��
		SOC0124Info entityItem = this.soc0118BL.searchEntityItemVWByKey(form.getEiid());
		
		if ( entityItem == null ){
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.015"));
		}
		
		//������ʾ�趨
		
		String orgsyscoding = entityItem.getEiorgsyscoding();
		String esyscoding = entityItem.getEsyscoding();
		SOC0117SearchCondImpl EntityCond = new SOC0117SearchCondImpl();
		EntityCond.setEsyscoding(esyscoding);
		List<SOC0117Info> entityList = this.soc0117BL.searchEntity(EntityCond, 0, 0);
		for (int i = 0; i < entityList.size(); i++) {
			form.setEname(entityList.get(0).getEname());
		}
		OrganizationSearchCondImpl OrgCond = new OrganizationSearchCondImpl();
		OrgCond.setOrgsyscoding(orgsyscoding);
		List<Organization> orgList = this.organizationBL.searchOrganization(OrgCond, 0, 0);
		for (int i = 0; i < orgList.size(); i++) {
			form.setEiorgname(orgList.get(0).getOrgname());
		}
		form.setEiorgsyscoding(orgsyscoding);
		form.setEiid(entityItem.getEiid());
		form.setEid(entityItem.getEid());
		form.setEistatus(entityItem.getEistatus());
		form.setEiupdtime(entityItem.getEiupdtime());
		form.setEiversion(entityItem.getEiversion());
		form.setEsyscoding(entityItem.getEsyscoding());
		form.setEilabel(entityItem.getEilabel());
		form.setEiname(entityItem.getEiname());
		form.setEiinsdate(entityItem.getEiinsdate());
		form.setEidesc(entityItem.getEidesc());
		form.setEilabelbak(entityItem.getEilabel());
		form.setEiuserid(entityItem.getEiuserid());
		form.setEiusername(entityItem.getEiusername());
		form.setEismallversion(entityItem.getEismallversion());
		form.setEirootmark(entityItem.getEirootmark());
		
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		boolean permission = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItem);
		boolean isRoleManager = this.userRoleBL.checkRoleManagerByType(dto.getUser().getUserid(), EntityCategory.ROLE_TYPE_DEVICE);
		form.setRoleManager(isRoleManager);
		form.setPermission(permission);
		
		dto.setIgcim0108Form(form);
		
		if(!permission) {
			dto.addMessage(new ActionMessage("IGCO10000.E023",resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.016")));
		}
		
		log.debug("========�豸��Ϣ�༭���������ʾ��������========");
		return dto;
	}
	
	
	/**
	 *	��ȡ�豸������ϵ����
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
//	public IGCIM01DTO searchRelationListAction(IGCIM01DTO dto) throws BLException {
//		log.debug("========��ȡ�豸������ϵ����ʼ========");
//		List<LabelValueBean> newlist=new ArrayList<LabelValueBean>();
//		CodeDetailSearchCondImpl cond=new CodeDetailSearchCondImpl();
//		LabelValueBean lvb=null;
//		cond.setCcid("832");
//		cond.setBusinesscode_like("003-001");// host relation
//		List<CodeDetail> list=this.codeDetailBL.searchCodeDetail(cond, 0);
//		if(list.size()>0){
//			newlist.add(new LabelValueBean("",""));
//			for (int i = 0; i < list.size(); i++) {
//				lvb=new LabelValueBean();
//				lvb.setLabel(list.get(i).getCvalue());
//				lvb.setValue(list.get(i).getCid()+"#"+list.get(i).getBusinesscode());
//				newlist.add(lvb);
//			}
//		}
//		dto.setRelationList(newlist);
//		log.debug("========��ȡ�豸������ϵ��������========");
//		return dto;
//	}
	
	public IGCIM01DTO searchRelationListAction(IGCIM01DTO dto) throws BLException {
		log.debug("========��ȡ�豸������ϵ����ʼ========");
		IGCIM0107Form form = dto.getIgcim0107Form();
		String esyscoding = form.getEsyscoding();
		List<LabelValueBean> newlist=new ArrayList<LabelValueBean>();
		CodeDetailSearchCondImpl cond=new CodeDetailSearchCondImpl();
		LabelValueBean lvb=null;
		cond.setCcid("832");
		//��������Ӧ��ģ��
		if (esyscoding.startsWith(CommonDefineUtils.HOST_ESYSCODING)) {
			cond.setBusinesscode_like("001-003");
		} 
		//���-���
		else {
			cond.setBusinesscode_like("002-002");
		}
		List<CodeDetail> list=this.codeDetailBL.searchCodeDetail(cond, 0);
		if(list.size()>0){
			newlist.add(new LabelValueBean("",""));
			for (int i = 0; i < list.size(); i++) {
				lvb=new LabelValueBean();
				CodeDetail codeDetail = list.get(i);
				String cid = codeDetail.getCid();
//				��������Ӧ��ģ��
				if (esyscoding.startsWith(CommonDefineUtils.HOST_ESYSCODING)) {
					lvb.setLabel(codeDetail.getCvalue());
					lvb.setValue(codeDetail.getCid()+"#"+codeDetail.getBusinesscode());
					newlist.add(lvb);
				} 
//				Tuxedo Machine����INSTANCE
//				Tuxedo Machine����Informix Server
				if (esyscoding.startsWith(EntityItemKeyWords.MACHINE_ESYSCODING)) {
					if (cid.equals(EntityItemKeyWords.Machine_INSTANCE_Relation) 
							|| cid.equals(EntityItemKeyWords.Machine_Informix_Server_Relation)) {
						lvb.setLabel(codeDetail.getCvalue());
						lvb.setValue(codeDetail.getCid()+"#"+codeDetail.getBusinesscode());
						newlist.add(lvb);
					}
				}
//				Jboss Webapp����INSTANCE
//				Jboss Webapp����Informix Server
				if (esyscoding.startsWith(EntityItemKeyWords.JBOSSWEBAPP_ESYSCODING)) {
					if (cid.equals(EntityItemKeyWords.JbossWebapp_INSTANCE_Relation) 
							|| cid.equals(EntityItemKeyWords.JbossWebapp_Informix_Server_Relation)) {
						lvb.setLabel(codeDetail.getCvalue());
						lvb.setValue(codeDetail.getCid()+"#"+codeDetail.getBusinesscode());
						newlist.add(lvb);
					}
				}
//				Webligc Webapp����INSTANCE
//				Webligc Webapp����Informix Server
				if (esyscoding.startsWith(EntityItemKeyWords.WEBAPP_ESYSCODING)) {
					if (cid.equals(EntityItemKeyWords.WEBAPP_INSTANCE_Relation) 
							|| cid.equals(EntityItemKeyWords.WEBAPP_Informix_Server_Relation)) {
						lvb.setLabel(codeDetail.getCvalue());
						lvb.setValue(codeDetail.getCid()+"#"+codeDetail.getBusinesscode());
						newlist.add(lvb);
					}
				}
				if (esyscoding.startsWith(EntityItemKeyWords.APPCOURSE)) {
					if (cid.equals(EntityItemKeyWords.APPCOURSE_INSTANCE_Relation)) {
						lvb.setLabel(codeDetail.getCvalue());
						lvb.setValue(codeDetail.getCid()+"#"+codeDetail.getBusinesscode());
						newlist.add(lvb);
					}
				}

			}
		}
		dto.setRelationList(newlist);
		log.debug("========��ȡ�豸������ϵ��������========");
		return dto;
	}
	
	/**
	 *	��ȡ�豸������ϵ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO searchEiBelongRelationListAction(IGCIM01DTO dto) throws BLException {
		log.debug("========��ȡ�豸������ϵ����ʼ========");
		//List<LabelValueBean> list = this.codeDetailBL.searchLabelValueBeanList(CommonDefineUtils.ENTIY_CATEGORY_DEVICE,CodeDefine.getCodeDefine("ENTITY_ITEM_BELONG_RELATION_CODE").getCcid());
		List<LabelValueBean> list=new ArrayList<LabelValueBean>();
		list.add(new LabelValueBean("", ""));
		IGCIM0107Form form = dto.getIgcim0107Form();
		String pareid = form.getPareid();
		String esyscoding = form.getEsyscoding();
		
		if(esyscoding.startsWith(EiRelationKeyWords.HOST)){
			pareid = EntityItemKeyWords.HOST_EID;
		}
		if(esyscoding.startsWith(EiRelationKeyWords.SWITCH)){
			pareid = EntityItemKeyWords.SWITCH_EID;
		}
		if(esyscoding.startsWith(EiRelationKeyWords.STORAGE)){
			pareid = EntityItemKeyWords.STORAGE_EID;
		}
		//�����ѯ
		SOC0152SearchCondImpl cond=new SOC0152SearchCondImpl();
		cond.setFromModelEid_eq(pareid);
		List<SOC0152Info> list1 = soc0152BL.searchSOC0152(cond);
		if(list1!=null&&list1.size()>0){
			for (SOC0152Info info : list1) {
				CodeDetail cod = codeDetailBL.searchCodeDetailByPK(new CodeDetailTBPK(CodeDefine.ENTITYITEM_RELATION_CODE.getCcid(),info.getRlnCode()));
				if(cod!=null){
					list.add(new LabelValueBean(info.getRlnDesc(), info.getRlnCode()+"#"+cod.getBusinesscode()+"#"+info.getTo0117TB().getEsyscoding()));
				}
			}
		}
		//�����ѯ
		cond=new SOC0152SearchCondImpl();
		cond.setToModelEid_eq(pareid);
		List<SOC0152Info> list2 = soc0152BL.searchSOC0152(cond);
		if(list2!=null&&list2.size()>0){
			for (SOC0152Info info : list2) {
				//ҵ��ϵͳ-������ϵ������
				if (EntityItemKeyWords.BUSINESS_HOST_Relation.equals(info.getRlnCode())) {
					continue;
				}
				CodeDetail cod = codeDetailBL.searchCodeDetailByPK(new CodeDetailTBPK(CodeDefine.ENTITYITEM_RELATION_CODE.getCcid(),info.getRlnCode()));
				if(cod!=null){
					list.add(new LabelValueBean(info.getRlnDesc(), info.getRlnCode()+"#"+cod.getBusinesscode()+"#"+info.getFrom0117TB().getEsyscoding()));
				}
			}
		}
		
		dto.setRelationList(list);
		log.debug("========��ȡ�豸������ϵ��������========");
		return dto;
	}
	
//	/**
//	 * �豸�������ǼǱ༭������ڻ�����
//	 *
//	 * @param dto IGASM03DTO
//	 * @return IGASM03DTO
//	 */
//	public IGCIM01DTO initIGASM0317Action(IGCIM01DTO dto) throws BLException{
//		
//		log.debug("========�豸�������Ǽ���Ϣ�༭���������ʾ����ʼ========");
//		
//		IGASM0317Form form = dto.getIgasm0317Form();
//		///��ʾ���ʲ���Ϣȡ��
//		SOC0118Info entityItem = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getPareiid()));
//		
//		if ( entityItem == null ){
//			throw new BLException("IGCO10000.E004","��������豸ģ�����");
//		}
//		
//		//������ʾ�趨
//		
//		String orgsyscoding = entityItem.getEiorgsyscoding();
//		String esyscoding = entityItem.getEsyscoding();
//		SOC0117SearchCondImpl EntityCond = new SOC0117SearchCondImpl();
//		EntityCond.setEsyscoding(esyscoding);
//		List<SOC0117Info> entityList = this.soc0117BL.searchEntity(EntityCond, 0, 0);
//		for (int i = 0; i < entityList.size(); i++) {
//			form.setEname(entityList.get(0).getEname());
//		}
//		form.setEsyscoding(esyscoding);
//		OrganizationSearchCondImpl OrgCond = new OrganizationSearchCondImpl();
//		OrgCond.setOrgsyscoding(orgsyscoding);
//		List<Organization> orgList = this.organizationBL.searchOrganization(OrgCond, 0, 0);
//		for (int i = 0; i < orgList.size(); i++) {
//			form.setEiorgname(orgList.get(0).getOrgname());
//		}
//		form.setEiorgsyscoding(orgsyscoding);
//		Date nowDateTime = new Date();
//		String date = CommonDefineUtils.DATE_FORMAT.format(nowDateTime);
//		form.setEid(entityItem.getEid());
//		form.setEiinsdate(date);
//		form.setEidesc(entityItem.getEidesc());
//		form.setEiname(entityItem.getEiname());
//		dto.setIgasm0317Form(form);
//		log.debug("========�豸�������Ǽ���Ϣ�༭���������ʾ����ʼ========");
//		return dto;
//	}
	
	

	/**
	 * ��ȡ�豸������ֵ
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO searchEntityItemLableAction(IGCIM01DTO dto) throws BLException {
		
		log.debug("========��ȡ�豸������ֵ����ʼ========");
		
		IGCIM0102Form form = dto.getIgasm0302Form();
		
		SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		
		cond.setEilabel(CommonDefineUtils.ENTIY_CATEGORY_DEVICE_KEY + IGStringUtils.getCurrentYear().substring(2));
		
		String eilabel = this.soc0118BL.searchNextEntityItemLable(cond);
		
		form.setEilabel(eilabel);
		
		log.debug("========��ȡ�豸������ֵ��������========");
		return dto;
	}
	
	/**
	 * �жϵ�½�û��Ƿ����豸�ʲ������ɫ������
	 * 
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 * @throws BLException 
	 */
	public IGCIM01DTO checkEntityItemDomain(IGCIM01DTO dto) throws BLException{
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
	 * ��ȡ��ʷ�汾����ʱ��
	 * @param version
	 * @return list
	 * @throws BLException
	 */
	public List<SOC0128Info> getVersionUpdateTime (String eiid)throws BLException{
		
		
		List<SOC0128Info> resultList=this.soc0118BL.searchVersionUpdateTime(Integer.parseInt(eiid));
		return resultList;
	}

	/**
	 * ��ʼ���ʲ�������Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO initXMLInfo(IGCIM01DTO dto) throws BLException{
		//dto.setTreeNodeMap(parseXML(new File(dto.getFilepath())));
		dto.setTreeNodeMap(parseXML(dto.getFilepath()));
		return dto;
	}
	
	/**
	 * �鿴������Ϣָ��������Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO readXMLNodeInfo(IGCIM01DTO dto) throws BLException{
		IGCIM0101Form form = dto.getIgcim0101Form();
		//dto.setInfoMap(parseXMLNode(new File(dto.getFilepath()),form.getNodeID()));
		dto.setInfoMap(parseXMLNode(dto.getFilepath(),form.getNodeID()));
		return dto;
	}
	
	/**
	 * ����������ϢXML�ļ��е�ָ����������
	 * @param File
	 * @return Map<String,TreeNode> 
	 */
	@SuppressWarnings({"finally" })
	public Map<TreeNode,String> parseXMLNode(String filepath,String id) {
		Map<TreeNode,String> infoMap=new LinkedHashMap<TreeNode,String>();
		try{
			DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
			DocumentBuilder dombuilder = domfac.newDocumentBuilder();
		    //InputStream is = new FileInputStream(file); //���ļ���ȡ��
		    InputSource is = new InputSource(new InputStreamReader(new FileInputStream(new File(filepath)), "GBK"));
		    Document doc = dombuilder.parse(is);   
		    Element root = doc.getDocumentElement();
		    NodeList nodes = root.getChildNodes();
		    String key = ASMHelper.NODE_KEY;
		    if(nodes!=null){
		    	//���ø����
		    	TreeNode rootNode = new TreeNode();
	    	    rootNode.setId(key);
	    	    rootNode.setName(root.getNodeName());

	    	    //���һ�����ӽ��
		    	for(int i=0,j=nodes.getLength();i<j;i++){
		    		Node node = nodes.item(i);
		    		
		    		if(node.getNodeType()==Node.ELEMENT_NODE && !"DATE".equals(node.getNodeName().toUpperCase()) && !"VER".equals(node.getNodeName().toUpperCase()) && !"RELATION".equals(node.getNodeName().toUpperCase())){

			    	    TreeNode ptNode = new TreeNode();
			    	    key = getXMLKey(key,2);
			    		ptNode.setId(key);
			 			ptNode.setName(node.getNodeName());
			 			//��麢�ӽ��
			 			checkChildNodes(node,ptNode,key,3,id,infoMap);

		    		}
		    		
		    	}
		    	
		    }
		}catch(Exception e){
			e.printStackTrace();
			log.debug(e.getCause());
		}finally{
			return infoMap;
		}
	}
	
	/**
	 * ���ÿ������Ƿ�Ϊѡ���Ľ��
	 * @param node	��ǰ���
	 * @param ptNode �ϼ����
	 */
	public  void checkChildNodes(Node node,TreeNode ptNode,String key,Integer level,String id,Map<TreeNode,String> infoMap) {
		 NodeList nodes = node.getChildNodes();
		 
		 for(int i=0,j=nodes.getLength();i<j;i++){
			 Node tempnode = nodes.item(i);
			 if(tempnode.getNodeType()==Node.ELEMENT_NODE){
				 String temp_key = getXMLKey(key,level);
				 
				 TreeNode pdNode = new TreeNode();
				 pdNode.setId(temp_key);
				 pdNode.setName(tempnode.getNodeName());
				 //���Ϊѡ�����ĺ��ӽ����ȡ��������
				 if(pdNode.getId().substring(0, id.length()).equals(id) && pdNode.getId().length()>id.length()){
					 NamedNodeMap nodemap = tempnode.getAttributes();//��ǰ�������Լ���
					 TreeNode showNode = new TreeNode();
					 String value = "";
					 showNode.setId(nodemap.getNamedItem("cid").getNodeValue());
					 showNode.setName(nodemap.getNamedItem("cname").getNodeValue());
					 NodeList temp_nodes = tempnode.getChildNodes();
					 for(int x=0,y=temp_nodes.getLength();x<y;x++){
						 Node cinode = temp_nodes.item(x);
						 if(cinode.getNodeType()==Node.ELEMENT_NODE && "value".equals(cinode.getNodeName().toLowerCase())){
							 value = cinode.getTextContent();
							 break;
						 }
					 }
					 infoMap.put(showNode, value);
				 }

				 if(tempnode.getChildNodes().getLength()>0 && level <= 3){
					 checkChildNodes(tempnode,pdNode,pdNode.getId(),(level+1),id,infoMap);
				 }
				 ptNode.addChildTreeNode(pdNode.getId(),pdNode); 
				 
				 key = getXMLKey(key,level);
			 }
		 }
	}
	
	
	/**
	 * ����������ϢXML�ļ��е�����
	 * @param File
	 * @return Map<String,TreeNode> 
	 */
	@SuppressWarnings({"finally" })
	public Map<String,TreeNode> parseXML(String filepath) {
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		try{
			DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
			DocumentBuilder dombuilder = domfac.newDocumentBuilder();
			
		    //InputStream is = new FileInputStream(file); //���ļ���ȡ��
			InputSource is = new InputSource(new InputStreamReader(new FileInputStream(new File(filepath)), "GBK"));
		    Document doc = dombuilder.parse(is);   
		    Element root = doc.getDocumentElement();
		    NamedNodeMap rootmap = root.getAttributes();//root�������Լ���
		    NodeList nodes = root.getChildNodes();
		    String key = ASMHelper.NODE_KEY;
		    if(nodes!=null){
		    	//���ø����
		    	TreeNode rootNode = new TreeNode();
	    	    rootNode.setId(key);
	    	    String tmp = "";//HOST Name
	    	    String tmp_type = "";//AIX etc.
	    	    if(rootmap!=null && rootmap.getLength()>0){
	    	    	tmp = rootmap.getNamedItem("label").getNodeValue();
	    	    	tmp_type = rootmap.getNamedItem("type").getNodeValue();
	    	    }
	    	    rootNode.setName(tmp_type+"-"+tmp);

	    	    //���һ�����ӽ��
		    	for(int i=0,j=nodes.getLength();i<j;i++){
		    		Node node = nodes.item(i);
		    		if(node.getNodeType()==Node.ELEMENT_NODE && !"DATE".equals(node.getNodeName().toUpperCase()) && !"VER".equals(node.getNodeName().toUpperCase()) && !"RELATION".equals(node.getNodeName().toUpperCase())){
		    			NamedNodeMap nodemap = node.getAttributes();
		    			
			    	    TreeNode ptNode = new TreeNode();
			    	    key = getXMLKey(key,2);
			    		ptNode.setId(key);
			    		if(nodemap!=null && nodemap.getNamedItem("label")!=null){
			    			ptNode.setName(nodemap.getNamedItem("label").getNodeValue());
			    		}else{
			    			ptNode.setName(node.getNodeName());
			    		}
			    		//ptNode.setName(node.getNodeName());
			    		
			 			//��Ӻ��ӽ��
			 			getChildNodes(node,ptNode,key,3);
			 			rootNode.addChildTreeNode(ptNode.getId(), ptNode);
		    		}
		    		
		    	}
		    	treeNodeMap.put(rootNode.getId(),rootNode);
		    	
		    }
		}catch(Exception e){
			e.printStackTrace();
			log.debug(e.getCause());
		}finally{
			return treeNodeMap;
		}
	}
	
	/**
	 * ȡ���¼����
	 * @param node	��ǰ���
	 * @param ptNode �ϼ����
	 */
	public  void getChildNodes(Node node,TreeNode ptNode,String key,Integer level) {
		 NodeList nodes = node.getChildNodes();
		 
		 for(int i=0,j=nodes.getLength();i<j;i++){
			 Node tempnode = nodes.item(i);
			 if(tempnode.getNodeType()==Node.ELEMENT_NODE){
				 NamedNodeMap nodemap = tempnode.getAttributes();//��ǰ�������Լ���
				 
				 String temp_key = getXMLKey(key,level);
				 TreeNode pdNode = new TreeNode();
				 pdNode.setId(temp_key);
				 if(nodemap!=null && nodemap.getLength()>0){
					 pdNode.setName(nodemap.getNamedItem("einame").getNodeValue());
				 }else{
					 pdNode.setName(tempnode.getNodeName());
				 }
				 
				 //ֻȡǰ3���Ľ����Ϊ�������Ԫ��
//				 if(tempnode.getChildNodes().getLength()>0 && level <= 3){
//					getChildNodes(tempnode,pdNode,pdNode.getId(),(level+1));
//				 }
				 if(level <= 3){
					//����ΪCOMMAND����
					ptNode.addChildTreeNode(pdNode.getId(),pdNode); 
				 }
				 key = getXMLKey(key,level);
			 }
		 }
	}
	
	/**
	 * ȡ�ø�����ΨһID(ÿ3λΪһ��)
	 * @param String key
	 * @param String level
	 * @return String
	 */
	public static synchronized String getXMLKey(String key,Integer level){
		String syscode = key;
		String temp = "";
		if(key.length()>=(level*3)){
			temp = key.substring(key.length()-3);	
			if("0".equals(temp.substring(0, 1))){//0**
				String tmp = String.valueOf(Integer.valueOf(temp)+1);
				if(tmp.length()==1){
					temp = "00"+tmp;
				}else if(tmp.length()==2){
					temp = "0"+tmp;
				}else{
					temp = tmp;
				}
				syscode = syscode.substring(0,syscode.length()-3)+temp;
			}else{//***
				syscode = syscode.substring(0,syscode.length()-3)+String.valueOf(Integer.valueOf(temp)+1);
			}
		}else{
			syscode = key + "001";
		}

		return syscode;
	 }
	
	
	/**
	 * �Ƚ�2���汾������ϢXML�е�����(����XML�ļ��е�SCETION����һ�����ܽ��бȽ�)
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO compareXMLInfoByVersion(IGCIM01DTO dto) throws BLException{
		
		//ȡ�õ�1���汾������
		//dto = searchXMLInfo(new File(dto.getFilepath()),dto);
		dto = searchXMLInfo(dto.getFilepath(),dto);
		List<String> section_list = new ArrayList<String>();
	    Map<String,List<TreeNode>> command_map_1 = dto.getCommand_map();
	    
	    //ȡ�õ�2���汾������
		//dto = searchXMLInfo(new File(dto.getOtherfilepath()),dto);
		dto = searchXMLInfo(dto.getOtherfilepath(),dto);
	    Map<String,List<TreeNode>> command_map_2 = dto.getCommand_map();
	    
	    //�Ƚ�����
		Set<Map.Entry<String,List<TreeNode>>> set_1 = command_map_1.entrySet();
		
		List<String> new_command_list1 = new ArrayList<String>();
		List<String> new_command_list2 = new ArrayList<String>();
		List<String> new_output_list1 = new ArrayList<String>();
		List<String> new_output_list2 = new ArrayList<String>();
		List<String> command_color_list = new ArrayList<String>();//0����ɫ 1��ɫ
		List<String> output_color_list = new ArrayList<String>();//0����ɫ 1��ɫ
		
		for(Iterator<Map.Entry<String,List<TreeNode>>> iter = set_1.iterator();iter.hasNext();){
			Map.Entry<String,List<TreeNode>> entry_1 = iter.next();
			String section =  entry_1.getKey();//eitype: HOST HBA etc.
			
			List<TreeNode> list1 = entry_1.getValue();
			List<TreeNode> list2 = command_map_2.get(section);
			
			
			//����SECTION
			if(list2==null ||(list1!=null &&  list1.size()>=list2.size())){
				for(TreeNode node:list1){
					section_list.add(section);
				}
			}else{
				for(TreeNode node:list2){
					section_list.add(section);
				}
			}
			
				//��һ���汾Ϊ������Ƚ�����һ���汾�е�����
				for(int i=0,j=list1.size();i<j;i++){
					TreeNode node1 = list1.get(i);
					boolean flag = true;
					boolean flag2 = true;
					
					//�Ƚ�command
					if(list2!=null){
						for(int m=0,n=list2.size();m<n;m++){
							TreeNode node2 = list2.get(m);	
							if(node1.getId().equals(node2.getId())){
								//��command1����command2ʱ��ֱ�ӽ���ǰcommand���浽�Լ��µ�list��
								new_command_list1.add(node1.getName());
								new_command_list2.add(node2.getName());
								flag = false;
								command_color_list.add("0");
								break;
							}
						}
					}
					
					
					if(flag){
						//��command2��������list1�в���new_command_list2������command2ʱ����new_command_list2�����һ�����У������ñ�ɫ
						new_command_list1.add(node1.getName());
						new_command_list2.add("");
						command_color_list.add("1");
					}

					//�Ƚ�output
					if(list2!=null){
						for(int m=0,n=list2.size();m<n;m++){
							TreeNode node2 = list2.get(m);
							if(node1.getBelong().equals(node2.getBelong())){
								new_output_list1.add(node1.getBelong());
								new_output_list2.add(node2.getBelong());
								flag2 = false;
								output_color_list.add("0");
								break;
							}
						}
					}
					
					
					if(flag2){
						//��output2��������list1�в���new_output_list1������output2ʱ����new_output_list2�����һ�����У������ñ�ɫ
						new_output_list1.add(node1.getBelong());
						new_output_list2.add("");
						output_color_list.add("1");
					}
					
				}

				//����һ���汾Ϊ������Ƚ�����
				if(list2!=null){
					for(int i=0,j=list2.size();i<j;i++){
						TreeNode node2 = list2.get(i);
						boolean flag = true;
						boolean flag2 = true;
						
						//�Ƚ�command
						if(list1!=null){
							for(int m=0,n=list1.size();m<n;m++){
								TreeNode node1 = list1.get(m);
								if(node2.getId().equals(node1.getId())){
									//new_command_list1.add(node1.getName());
									//new_command_list2.add(node2.getName());
									//command_color_list.add("0");
									flag = false;
									break;
								}
							}
						}
						
						if(flag){
							new_command_list1.add("");
							new_command_list2.add(node2.getName());
							command_color_list.add("1");
						}
						
						//�Ƚ�output
						if(list1!=null){
							for(int m=0,n=list1.size();m<n;m++){
								TreeNode node1 = list1.get(m);
								if(node2.getBelong().equals(node1.getBelong())){
									//new_output_list1.add(node1.getBelong());
									//new_output_list2.add(node2.getBelong());
									//output_color_list.add("0");
									flag2 = false;
									break;
								}
							}
						}
						
						if(flag2){
							new_output_list1.add("");
							new_output_list2.add(node2.getBelong());
							output_color_list.add("1");
						}
						
					}
				}
				
			
		}

		//����ȽϺ������
	    dto.setSection_list(section_list);
	    dto.setCommand_list1(new_command_list1);
	    dto.setCommand_list2(new_command_list2);
	    dto.setOutput_list1(new_output_list1);
	    dto.setOutput_list2(new_output_list2);
	    dto.setCommand_color_list(command_color_list);
	    dto.setOutput_color_list(output_color_list);
	    
		return dto;
	}
	
	
	/**
	 * ��XML�ļ���ȡ����Ҫ������
	 * @param File
	 * @param IGVIR06DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO searchXMLInfo(String filepath,IGCIM01DTO dto) throws BLException {
		try{
			DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
			DocumentBuilder dombuilder = domfac.newDocumentBuilder();
		    //InputStream is = new FileInputStream(file); //���ļ���ȡ��
		    InputSource is = new InputSource(new InputStreamReader(new FileInputStream(new File(filepath)), "GBK"));
		    Document doc = dombuilder.parse(is);   
		    Element root = doc.getDocumentElement();
		    NodeList nodes = root.getChildNodes();
		    Map<String,List<TreeNode>> command_map = new LinkedHashMap<String,List<TreeNode>>();
		    if(nodes!=null){
		    	for(int i=0,j=nodes.getLength();i<j;i++){
			    	//ȡ������SECTION NODE
		    		Node node = nodes.item(i);
		    		
		    		if(node.getNodeType()==Node.ELEMENT_NODE && !"DATE".equals(node.getNodeName().toUpperCase()) && !"VER".equals(node.getNodeName().toUpperCase()) && !"RELATION".equals(node.getNodeName().toUpperCase())){
		    			NamedNodeMap rootnodemap = node.getAttributes();
		    			
		    			List<TreeNode> commandList = new ArrayList<TreeNode>();
		    			//����SECTION
		    			TreeNode rootNode = new TreeNode();
		    			String section_name = "";
		    			
		    			if(rootnodemap!=null && rootnodemap.getNamedItem("label")!=null){
		    				section_name = rootnodemap.getNamedItem("label").getNodeValue();
			    		}else{
			    			section_name = node.getNodeName();
			    		}
		    			rootNode.setName(section_name);
		    			
		    			//rootNode.setId(eilabel);
		    			//section_list.add(section_name);
			 			NodeList commandnodes = node.getChildNodes();
			 			//ȡ��COMMAND
			 			for(int m=0,n=commandnodes.getLength();m<n;m++){
			 				Node commandnode = commandnodes.item(m);
			 				if(commandnode.getNodeType()==Node.ELEMENT_NODE){
			 					TreeNode pdNode = new TreeNode();
			 					//����COMMAND
			 					NamedNodeMap commandnodemap = commandnode.getAttributes();//��ǰ�������Լ���
			 					String command_LBL = "";
			 					String command_eilabel = "";
			 					if(commandnodemap!=null && commandnodemap.getLength()>0){
			 						command_LBL = commandnodemap.getNamedItem("einame").getNodeValue();
			 						command_eilabel = commandnodemap.getNamedItem("eilabel").getNodeValue();
			 					}

			 					pdNode.setName(command_LBL);//einame
			 					pdNode.setId(command_eilabel);//eilabel

				 				NodeList outputnodes = commandnode.getChildNodes();
				 				//ȡ��OUTPUT��CI��
				 				StringBuffer buff = new StringBuffer();
				 				for(int x=0,y=outputnodes.getLength();x<y;x++){
				 					Node outputnode = outputnodes.item(x);
				 					//�жϵ�ǰ����Ƿ�Ϊҳ��ѡ��Ľ��
				 					if(outputnode.getNodeType()==Node.ELEMENT_NODE && "CI".equals(outputnode.getNodeName().toUpperCase())){
				 						NodeList cinodes = outputnode.getChildNodes();
				 						String cname = "";
				 						String value = "";
				 						for(int a=0,b=cinodes.getLength();a<b;a++){
				 							Node cinode = cinodes.item(a);
				 							if(cinode.getNodeType()==Node.ELEMENT_NODE && "CNAME".equals(cinode.getNodeName().toUpperCase())){
				 								cname = cinode.getTextContent();
				 							}else if(cinode.getNodeType()==Node.ELEMENT_NODE && "VALUE".equals(cinode.getNodeName().toUpperCase())){
				 								value = cinode.getTextContent();
				 							}
				 						}
				 						
				 						//����OUTPUT
				 						buff.append("\n");
				 						buff.append(cname);
				 						buff.append(" : ");
				 						buff.append(value);
				 						buff.append("\n");
				 					}
				 					
				 				}
				 				pdNode.setBelong(buff.toString());
				 				commandList.add(pdNode);
			 				}
			 			}
			 			
			 			command_map.put(section_name, commandList);
		    		}
		    		
		    	}
		    	dto.setCommand_map(command_map);
		    }
		}catch(Exception e){
			log.debug(e.getCause());
			throw new BLException("IGCO10000.E004","�����ļ�");
		}
		return dto;
	}
	
	
	
	
	public static void main(String[] args){
		try{
			Date data = new Date();
//			DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
//			DocumentBuilder dombuilder = domfac.newDocumentBuilder();
////		    InputStream is = new FileInputStream("F:/SOC/AIX XML Resource/Result/x/config-view.xml"); //���ļ���ȡ��
////		    Document doc = dombuilder.parse(is);   
//		    //Document doc = dombuilder.parse(new InputSource(new StringReader(source)));
//			InputSource is = new InputSource(new InputStreamReader(new FileInputStream(new File("C:\\parseXML\\AIX_XML\\config-view.xml")), "GBK"));
//		    Document doc = dombuilder.parse(is);   
//		    Element root = doc.getDocumentElement();
//		    NodeList nodes = root.getChildNodes();
//		    NamedNodeMap map = root.getAttributes();
//		    System.out.println("root==="+root.getNodeName()+"----"+map.getNamedItem("label").getNodeValue()); 
//		    if(nodes!=null){
//		    	for(int i=0,j=nodes.getLength();i<j;i++){
//		    		 Node node = nodes.item(i);
//		    		 if(node.getNodeType()==Node.ELEMENT_NODE && !"RELATION".equals(node.getNodeName().toUpperCase()) && !"DATE".equals(node.getNodeName().toUpperCase()) && !"VER".equals(node.getNodeName().toUpperCase())){
//		    			 NamedNodeMap nodemap = node.getAttributes();
//		    			 if(nodemap!=null && nodemap.getLength()>0){
//		    				 System.out.println("name==="+node.getNodeName()+"----"+nodemap.getNamedItem("esyscoding").getNodeValue());
//		    			 }
//		    			 
//		    			 //System.out.println("pppp==="+node.a); 
//		    			// getChildNodes(node,ptNode,key,3);
//		    		 }else if(node.getNodeType()==Node.ELEMENT_NODE && "RELATION".equals(node.getNodeName().toUpperCase())){
//		    			 NamedNodeMap nodemap = node.getAttributes();
//		    			 System.out.println("name==="+node.getNodeName()+"----"+nodemap.getNamedItem("ename").getNodeValue());
//		    		 }
//
//		    	}
//			
//		    }
//		    
		}catch(Exception e ){
			e.printStackTrace();
		}
		
	}
	/**
	 * �豸������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initIGCIM0104Action(IGCIM01DTO dto) throws BLException {

		log.debug("========�豸������Ϣ�༭������ڻ�����ʼ========");
		
		IGCIM0104Form form = dto.getIgasm0304Form();
		
		//�豸��Ϣ����
//		EntityItemVWInfo entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
//				Integer.parseInt(form.getEiid()));
		//��ǰ����ͼ�����ǵ�����������ҳ��ֻ�õ�2�������ݣ�ֻ���2�������ݣ�Ȼ��ƴ����ͼ����. _ylq
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
		entityItemVWInfo.setEmodeltype(entity.getEmodeltype());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.004"));
		}
		
		form.setEidesc(entityItemVWInfo.getEidesc());
		form.setEistatus(entityItemVWInfo.getEistatus());
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
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		//�Ƿ�ɼ̳б�ʶ��ʹ��entity����Ԥ���ֶ�EKEY2, 0����̳У�1�����̳�
		String ekey2 = entity.getEkey2();
		form.setEkey2(ekey2);
		
		//�豸������Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0107BL.getConfigItemVWSearchCount(form);
		
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
		Collections.reverse(configItemVWInfoList);
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
				if("4".equals(e.getCattach()) && StringUtils.isNotEmpty(e.getCivalue())){
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
		//form.setDelfile(delfile);
		form.setCivalue_bak(civalue_bak);
		
		dto.setConfigItemVWInfoMap(map);
//		dto.addMessage(new ActionMessage("IGCO10000.I007",totalCount));
		
		
		//��ȡ��ʷ�汾����ʱ��
		if(entityItemVWInfo.getEiversion() > 0) {
			dto.setConfigItemVersionTime(this.soc0118BL.searchVersionUpdateTime(entityItemVWInfo.getEiid()));
		}

		
		log.debug("========�豸������Ϣ�༭������ڻ���������========");
		return dto;
	}
		/**
		 * �豸������Ϣ�༭����
		 *
		 * @param dto IGASM03DTO
		 * @return IGASM03DTO
		 * @throws IOException 
		 * @throws FileNotFoundException 
		 */
		public IGCIM01DTO editEntityItemAction(IGCIM01DTO dto) throws BLException,FileNotFoundException,IOException {
			log.debug("========�豸������Ϣ�༭����ʼ========");
			//�汾������
			IGCIM0104Form form = dto.getIgasm0304Form();
			
			//����ģ������С�汾������������汾
			int version = form.getEiversion();//��汾
			int smallversion = form.getEismallversion();//С�汾
			String fileversion = version + "";//�����汾
			
			if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(form.getEmodeltype())) {
				smallversion++;
				fileversion = version + "_" + smallversion;
			} else {
				version++;
			}
			
			//�豸������Ϣ����
			SOC0118TB entityItem = (SOC0118TB) this.soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getEiid()));

			//�ж������Ƿ��Ѿ�������
			if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(form.getEmodeltype())) {
				if(smallversion - 1 != entityItem.getEismallversion()) {
					throw new BLException("IGCO00000.E004");
				}
			} else {
				if(version - 1 != entityItem.getEiversion()) {
					throw new BLException("IGCO00000.E004");
				}
			}
			
			//�ʲ���ϵ��Ϣ�汾��������
			this.soc0119BL.upgradeEntityItemRelation(entityItem.getEiid(), entityItem.getEiversion(), entityItem.getEismallversion(),
					version, smallversion);
			
			//�ʲ�������ϵ��Ϣ�汾��������
			this.soc0110BL.upgradeEntityItemRelation(entityItem.getEiid(), entityItem.getEiversion(), entityItem.getEismallversion(),
					version, smallversion);
			
			//�豸״̬
			entityItem.setEistatus(form.getEistatus());
			
			//�豸��汾
			entityItem.setEiversion(version);
			
			//�豸С�汾
			entityItem.setEismallversion(smallversion);
			
			//�豸˵��
			entityItem.setEidesc(form.getEidesc());

			Date nowDateTime = new Date();
			String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
			
			//����ʱ��
			entityItem.setEiupdtime(datetime);
			
			//�豸����
			entityItem.setEiname(form.getEiname());
			
			SOC0118Info hostei = this.soc0118BL.updateEntityItem(entityItem);
			
			//���ø���BL
			String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
			String fileNameXML = null;
			SOC0118Info hosteiXML = null;
			boolean flagXML = false;
			
			boolean copyFlag = false;//�Ƿ�Ϊ�����������ļ�
			SOC0107TB configItemXML = new SOC0107TB();
			//�豸������Ϣ����
			if (form.getCiid() != null && form.getCiid().length > 0 ) {
				//���޸�����ʱ��ȡ�ò�������չ���Ե��������ԣ�������Ա��������Ӧ�����Ը������
				Map<String,String> ssMap = new HashMap<String,String>();
				for( int i=0 ; i < form.getCiid().length; i++ ){
					if(form.getCid()[i].indexOf("CI")!=-1){
						ssMap.put(form.getCid()[i], form.getCivalue()[i]);
					}
				}
				for( int i=0 ; i < form.getCiid().length; i++ ){
					SOC0107TB configItem = new SOC0107TB();
					//�豸ID
					configItem.setEiid(Integer.parseInt(form.getEiid()));
					//�ʲ�����ID
					configItem.setCid(form.getCid()[i]);
					//����ID
					configItem.setEid(form.getEid()[i]);
					//���Ͳ����
					configItem.setEsyscoding(form.getEsyscoding()[i]);
					//��汾��
					configItem.setCiversion(version);
					//С�汾��
					configItem.setCismallversion(smallversion);
					//����ʱ��
					configItem.setCiupdtime(datetime);
					
					if (StringUtils.isEmpty(form.getCiid()[i])) {
						//Ĭ�����ԣ��豸״̬
						if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_STATUS.equals(form.getClabel()[i])){
							configItem.setCivalue(CommonDefineUtils.ENTITYITEM_STARUS_NEW);
						}else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORID.equals(form.getClabel()[i])){
							//Ĭ�����ԣ�������id
							configItem.setCivalue(dto.getUserid());
						}else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORNAME.equals(form.getClabel()[i])){
							//Ĭ�����ԣ�������
							configItem.setCivalue(dto.getUsername());
						}else{
							//��ʾ���ʲ����ƣ�ʵ�ʴ�ֵ���ʲ�����(�ʲ�ID)
							if("4".equals(form.getCiattach()[i]) && StringUtils.isNotEmpty(form.getEntityItemCivalue()[i])){
								configItem.setCivalue(form.getEntityItemCivalue()[i]);
							}else {
								configItem.setCivalue(form.getCivalue()[i]);
							}
						}
						
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
							if(IGASM03BLImpl.DEVICE_DEVICE.equals(relationcode)){
								e.setEirrelation(IGASM03BLImpl.DEVICE_DEVICE_CONN_ID);
								e.setEirrelationcode(IGASM03BLImpl.DEVICE_DEVICE);
							}else{
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
							}
							e.setEirupdtime(datetime);
							//��ѯ��������
							SOC0109Info config = this.soc0109BL.searchConfigurationByKey(form.getCid()[i]);
							String cname = config.getCname();
							e.setEirdesc(resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.005")+cname+
									resources.getMessage(dto.getLocale(),"message.IGACIM01BLImpl.006"));
							//����key
							e.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
							//����״̬ΪC����ϵ�����в���ɾ��
							e.setEirstatus("C");
							this.soc0119BL.registEntityItemRelation(e);
						}
						log.debug("�ʲ������[�ʲ�����ID:" + form.getCid()[i] + "]���봦��ɹ���");
						
					} else {
						if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORID.equals(form.getClabel()[i])){
							//Ĭ�����ԣ�������id
							configItem.setCivalue(dto.getUserid());
						}else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORNAME.equals(form.getClabel()[i])){
							//Ĭ�����ԣ�������
							configItem.setCivalue(dto.getUsername());
						}else{
							//��ʾ���ʲ����ƣ�ʵ�ʴ�ֵ���ʲ�����(�ʲ�ID)
							if("4".equals(form.getCiattach()[i]) && StringUtils.isNotEmpty(form.getEntityItemCivalue()[i])){
								configItem.setCivalue(form.getEntityItemCivalue()[i]);
							}else {
								configItem.setCivalue(form.getCivalue()[i]);
								//�޸ĶԱ�����
								if(form.getCid()[i].indexOf("BI")!=-1){
									String value = ssMap.get(form.getCid()[i].replace("BI", "CI"));
									if(StringUtils.isNotEmpty(value)){
										configItem.setCivalue(value);
									}
								}
							}
						}
						
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
								if(IGASM03BLImpl.DEVICE_DEVICE.equals(relationcode)){
									e.setEirrelation(IGASM03BLImpl.DEVICE_DEVICE_CONN_ID);
									e.setEirrelationcode(IGASM03BLImpl.DEVICE_DEVICE);
								}else{
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
								}
								e.setEirupdtime(datetime);
								//��ѯ��������
								SOC0109Info config = this.soc0109BL.searchConfigurationByKey(form.getCid()[i]);
								String cname = config.getCname();
								e.setEirdesc(resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.005")+cname+
										resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.006"));
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
							
							StringBuffer pathBuf = new StringBuffer();
							
							//��Ŀ¼
							pathBuf.append(rootPath);
							//����ID
							pathBuf.append("asm"+File.separator);
							//�豸ID
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
							fileName.append(fileversion);
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
					//=================================>
					//�ϴ�xml�ļ����
					if (form.getCiattach()[i].toUpperCase().equals("8")) {
						FormFile file = form.getAttachFileXML(i);
						if ( file != null && file.getFileSize() > 0) {
							//�ϴ��ļ����ڵ����
							//�ϴ��ļ�·��
							
							StringBuffer pathBuf = new StringBuffer();
							
							//��Ŀ¼
							pathBuf.append(rootPath+"XML"+File.separator+"asm"+File.separator);
							//�豸ID
							pathBuf.append(configItem.getEiid()+File.separator);
							
							StringBuffer fileName = new StringBuffer();
							
							//��չ��ȡ��
							String fileType = "";
							String sFileName = file.getFileName();
							int point = sFileName.lastIndexOf(".");
							if (point != -1) {
								fileType = sFileName.substring(point);
								fileName.append(sFileName.substring(0, point));
							}

							//�ļ���չ��
							fileName.append(fileType);
							fileName.append("_" + fileversion);
							//�ļ��ϴ�����
							this.fileUploadBL.saveFile(file, pathBuf.toString(), fileName.toString());
							
							//�ϴ��ļ�������
							configItem.setCivalue(fileName.toString());
							
							//�������Ա�ʶ
							configItem.setCicurver("1");
							
							this.soc0107BL.updateSOC0107(configItem);			
							hosteiXML = hostei;
							flagXML = true;
							fileNameXML = fileName.toString();
							configItemXML = configItem;
							
							copyFlag = true;
						}else{
							if(!copyFlag){
								//�����ļ�����
								//����ģ�崴��Excel�ļ�
								Integer ver = configItem.getCiversion() - 1;
								if(ver==0){
									ver = 1;
								}
								File modelfile = new File(rootPath+"XML"+File.separator+"asm"+File.separator+String.valueOf(configItem.getEiid())+File.separator+"config-view.xml_"+String.valueOf(ver));
								
								if(modelfile.exists()){
									File newfile = new File(rootPath+"XML"+File.separator+"asm"+File.separator+String.valueOf(configItem.getEiid())+File.separator+"config-view.xml_" + fileversion);
									
									FileInputStream fis = new FileInputStream(modelfile);
									BufferedReader in = new BufferedReader(new InputStreamReader(fis));
									
									FileOutputStream output = new FileOutputStream(newfile);
									String str = null;
									while((str=in.readLine())!=null){
										output.write(str.getBytes());
									}
									
									in.close();
									output.flush();
									output.close();
									
									copyFlag = false;
									
									SOC0107TB newConfigItem = (SOC0107TB)SerializationUtils.clone(configItem);
									newConfigItem.setCivalue("config-view.xml_" + fileversion);
									
									this.soc0107BL.updateSOC0107(newConfigItem);			
								}
								
								
								
							}
							
						}
					}
					//<============================================
				}
				
				if(copyFlag){
					saveXML(new File(rootPath+"XML"+File.separator+"asm"+File.separator+String.valueOf(configItemXML.getEiid())+File.separator+fileNameXML),dto.getUser(),hostei);
				}
				
				
			}
			
		    //����ֵ�����仯ʱ������ʵ��Ķ���CI���Ϊ�޸ģ�����ֶ����յ�Ч��
			if (entityItem.getEirootmark() != null) {
				SOC0118TB topCI = (SOC0118TB) this.soc0118BL.searchEntityItemByKey(entityItem.getEirootmark());
				String topciName = topCI.getEiname();
				SOC0126SearchCondImpl eiDomainDetailMaxVWSearchCond = new SOC0126SearchCondImpl();
				eiDomainDetailMaxVWSearchCond.setTypeId("1");
				eiDomainDetailMaxVWSearchCond.setEiname(topciName);
				List<SOC0138Info> listEiDomainDetailMax=soc0126BL.searchEiDomainDetailVW(eiDomainDetailMaxVWSearchCond,0,0);
				for(SOC0138Info eiDomainDetailMaxVWInfo:listEiDomainDetailMax){
					
					SOC0112PK pk = new SOC0112PK(eiDomainDetailMaxVWInfo.getEiddid(),
							eiDomainDetailMaxVWInfo.getEiddversion(),
							eiDomainDetailMaxVWInfo.getEiname(),
							eiDomainDetailMaxVWInfo.getEiImportversion());
					SOC0112Info eiDomainDetailInfo =soc0112BL.searchEiDomainDetailByPK(pk);
					SOC0112TB instance = (SOC0112TB)SerializationUtils.clone(eiDomainDetailInfo);
					instance.setModifyFlag("1");
					soc0112BL.updateEiDomainDetail(instance);
					
				}
			}
			
			dto.addMessage(new ActionMessage("IGCO10000.I005",resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.007")));
			
			log.debug("========�豸������Ϣ�༭��������========");
			
			return dto;
		}
	

		/**
		 * �״α������IG�淶��XML�ļ��е�����
		 * @param filepath
		 * @param user
		 * @throws IOException 
		 * @throws FileNotFoundException 
		 */
		public void insertIntoDBFromXMLFirst(IGCIM0104Form form,User user) throws BLException,FileNotFoundException,IOException {

			saveXMLFrist(form,user);

//			File filedir = new File(filepath);//IG�淶XML�ļ���
//			if(filedir.isDirectory()){
//				File[] files = filedir.listFiles();
//				if(files!=null && files.length>0){
//					saveXML(files[0],user,null);
//					//files[0].delete();//ɾ����������ļ�
//				}else{
//					throw new BLException("IGASM0322.E003");
//				}
//				
//			}
		}

	
	/**
	 * ������IGƽ̨�淶��XML�����ļ����뵽CMDB��
	 * @param file
	 * @param user
	 * @param eiid ��ֵ������Ҫ������������Ϣ
	 * @return
	 * @throws BLException
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@SuppressWarnings({"finally" })
	private String saveXMLFrist(IGCIM0104Form form,User user) throws BLException, FileNotFoundException, IOException {
		String result = "";
		String eiorgsyscoding = ASMHelper.XML_FILE_ORG_ID;
		String eiuserid = user.getUserid();
		String eiusername = user.getUsername();
		try{
			
			//��������ʵ��
			SOC0118TB ei_temp = new SOC0118TB();
			ei_temp.setEilabel("NO_NAME_ENTITY");
			ei_temp.setEid("CM0101");
			SOC0118Info host_ei = this.soc0118BL.registEntityItem(ei_temp);
			String rootPath = ResourceUtility.getString("UPLOAD_XML_FILE_ROOT_PATH");
			String ci_Civalue = "";//�ϴ��ļ���
			String ci_Cicurver = "1";//���Ը��±�ʶ
			String file_eid = "CM01010001";
			String file_cid = "CI010100010021";
			String file_esyscoding = "999001001";
			
			//���渽��
			FormFile file = form.getAttachFileXML(0);
			if ( file != null && file.getFileSize() > 0) {
				//�ϴ��ļ����ڵ����
				//�ϴ��ļ�·��
				
				StringBuffer pathBuf = new StringBuffer();
				
				//��Ŀ¼
				pathBuf.append(rootPath+File.separator);
				//�豸ID
				pathBuf.append(host_ei.getEiid()+File.separator);
				
				StringBuffer fileName = new StringBuffer();
				
				//��չ��ȡ��
				String fileType = "";
				String sFileName = file.getFileName();
				int point = sFileName.lastIndexOf(".");
				if (point != -1) {
					fileType = sFileName.substring(point);
					fileName.append(sFileName.substring(0, point));
				}

				//�ļ���չ��
				fileName.append(fileType);
				fileName.append("_1");
				//�ļ��ϴ�����
				this.fileUploadBL.saveFile(file, pathBuf.toString(), fileName.toString());
				
				//�ϴ��ļ�������
				ci_Civalue = fileName.toString();
				//configItem.setCivalue(fileName.toString());

			}
			File xmlfile = new File(rootPath+String.valueOf(host_ei.getEiid())+File.separator+ci_Civalue);
			DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
			DocumentBuilder dombuilder;

			dombuilder = domfac.newDocumentBuilder();
			
		    //InputStream is = new FileInputStream(file); //���ļ���ȡ��
			
		    InputSource is = new InputSource(new InputStreamReader(new FileInputStream(xmlfile), "GBK"));
		    Document doc;
			
			doc = dombuilder.parse(is);
			
		    //Document doc = dombuilder.parse(new InputSource(new StringReader(source)));
		    Element root = doc.getDocumentElement();
		    //NamedNodeMap rootmap = root.getAttributes();//root�������Լ���
		    NodeList nodes = root.getChildNodes();
		    //String key = ASMHelper.NODE_KEY;
		    if(nodes!=null){
		    	//ȡ��ģ��esyscoding
		    	String nowdate = IGStringUtils.getCurrentDateTime();
		    	String indate = "";
		    	List<String> existList = new ArrayList<String>();//�����Ѿ����ڵ��ʲ�ʵ��eilabel
		    	for(int i=0,j=nodes.getLength();i<j;i++){
		    		Node node = nodes.item(i);
		    		Integer ver = 1;
		    		if(node.getNodeType()==Node.ELEMENT_NODE && "DATE".equals(node.getNodeName())){
		    			//ȡ�õǼ�����
		    			indate = node.getTextContent();
		    		}else if(node.getNodeType()==Node.ELEMENT_NODE && "RELATION".equals(node.getNodeName().toUpperCase())){
		    			NamedNodeMap nodemap = node.getAttributes();
		    			NodeList relation_nodes = node.getChildNodes();//from,to
		    			String esyscoding_to = nodemap.getNamedItem("esyscoding").getNodeValue().trim();
		    			String ename_to = nodemap.getNamedItem("ename").getNodeValue().trim();
		    			SocRelationTB soctb = new SocRelationTB();
		    			soctb.setSresycoding(esyscoding_to);
		    			soctb.setSrename(ename_to);
		    			soctb.setVersion(Integer.valueOf(ver));//�汾��
		    			for(int n=0,m=relation_nodes.getLength();n<m;n++){
		    				Node relation_node = relation_nodes.item(n);
		    				if(relation_node.getNodeType()==Node.ELEMENT_NODE && "FROM".equals(relation_node.getNodeName().toUpperCase())){
			    				soctb.setSreilabel(relation_node.getTextContent());
			    			}else if(relation_node.getNodeType()==Node.ELEMENT_NODE && "TO".equals(relation_node.getNodeName().toUpperCase())){
			    				soctb.setSrpareilabel(relation_node.getTextContent());
			    			}
		    			}
		    			
		    			//���ʲ�δ�����ʱ������ʲ���ϵ
		    			if(!existList.contains(soctb.getSrpareilabel())){
		    				//�����ʲ���ϵ
			    			this.socRelationBL.registSocRelation(soctb);
		    			}
		    			
		    			
		    			
		    		}else if(node.getNodeType()==Node.ELEMENT_NODE  && "ATTR_SELF".equals(node.getNodeName().toUpperCase())){//HOST
		    			
		    			NodeList ei_nodes = node.getChildNodes();
		    			
		    			if(ei_nodes!=null && ei_nodes.getLength()>0){
		    				for(int a=0,b=ei_nodes.getLength();a<b;a++){
		    					Node einode = ei_nodes.item(a);
		    					if(einode.getNodeType()==Node.ELEMENT_NODE && "ENTITYITEM".equals(einode.getNodeName().toUpperCase())){
		    						NamedNodeMap nodemap = einode.getAttributes();
		    		    			//ȡ���ʲ���Ϣ
		    		    			//��ѯ���ʲ��Ƿ��Ѵ���,�粻�����򱣴棬����������
		    						String esyscoding = nodemap.getNamedItem("esyscoding").getNodeValue();
		    				    	String eid = nodemap.getNamedItem("eid").getNodeValue();;
		    		    			String eilabel = nodemap.getNamedItem("eilabel").getNodeValue().trim();//�ʲ����
		    		    			String einame = nodemap.getNamedItem("einame").getNodeValue().trim();//�ʲ�����
		    		    			SOC0118Info ei = null;

		    		    			//��ѯentityitem�Ƿ����
		    		    			SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		    		    			cond.setEilabel(eilabel);
		    		    			List<SOC0118Info> eilist = this.soc0118BL.searchEntityItem(cond);
		    		    			
		    		    			//�����ڣ��򱣴�
		    		    			if(eilist==null || eilist.size()==0){
		    		    				//����
		    		    				ver = 1;
		    		    				SOC0118TB eitb = (SOC0118TB)SerializationUtils.clone(host_ei);
		    			    			eitb.setEid(eid);
		    			    			eitb.setEiname(einame);//�ʲ�����
		    			    			eitb.setEiorgsyscoding(eiorgsyscoding);//��������
		    			    			eitb.setEiinsdate(indate);//�Ǽ���
		    			    			eitb.setEiupdtime(nowdate);//����ʱ��
		    			    			eitb.setEsyscoding(esyscoding.trim());//�ʲ�ģ�Ͳ����
		    			    			eitb.setEilabel(eilabel);//�ʲ����
		    			    			eitb.setEiuserid(eiuserid);//�Ǽ���ID
		    			    			eitb.setEiusername(eiusername);//�Ǽ�������
		    			    			if(esyscoding!=null && esyscoding.length()>=6 && "999001".equals(esyscoding.substring(0, 6))){
		    			    				eitb.setEistatus("N");
		    							}else{
		    								eitb.setEistatus("");//EISTATUS 
		    							}
		    			    			eitb.setEiversion(ver);
		    			    			
		    			    			ei = this.soc0118BL.updateEntityItem(eitb);
		    			    			
			    		    			if(ei == null){
			    		    				throw new BLException("IGASM0322.E001");
			    		    			}
			    		    			
			    		    			//���渽������
			    		    			SOC0107TB file_citb = new SOC0107TB();
			    		    			file_citb.setEiid(ei.getEiid());
			    		    			file_citb.setCiupdtime(nowdate);//����ʱ��
			    		    			file_citb.setCiversion(ver);//���԰汾
			    		    			file_citb.setEid(file_eid);
			    		    			file_citb.setEsyscoding(file_esyscoding);
			    		    			file_citb.setCid(file_cid);//CID
			    		    			file_citb.setCivalue(ci_Civalue);
			    		    			file_citb.setCicurver(ci_Cicurver);
	        							this.soc0107BL.registSOC0107(file_citb);
			    		    			
			    		    			//ȡ�ø��ʲ������Լ���
			    		    			NodeList cinodes = einode.getChildNodes();
			    		    			for(int n=0,m=cinodes.getLength();n<m;n++){
			    		    				Node cinode = cinodes.item(n);
			    		    				if(cinode.getNodeType()==Node.ELEMENT_NODE && "CI".equals(cinode.getNodeName().toUpperCase())){
			    		    					NamedNodeMap ci_nodemap = cinode.getAttributes();
			    		    					NodeList cid_nodes = cinode.getChildNodes();//cname,value

			    		    					SOC0107TB citb = new SOC0107TB();
			    		    					citb.setEiid(ei.getEiid());
			    		    					citb.setCiupdtime(nowdate);//����ʱ��
			    		    					citb.setCiversion(ver);//���԰汾
			    		    					citb.setEid(ci_nodemap.getNamedItem("eid").getNodeValue());
			        							citb.setEsyscoding(ci_nodemap.getNamedItem("esyscoding").getNodeValue().trim());
			        							citb.setCid(ci_nodemap.getNamedItem("cid").getNodeValue());//CID
			    		    					for(int x=0,y=cid_nodes.getLength();x<y;x++){
			    		    						Node cid_node = cid_nodes.item(x);
			    		    						//����������Ϣ
			    		    						if(cid_node.getNodeType()==Node.ELEMENT_NODE && "VALUE".equals(cid_node.getNodeName().toUpperCase())){
			    		    							citb.setCivalue(cid_node.getTextContent()==null?"":cid_node.getTextContent());
			    		    							//CICURVERΪ0����δ�޸ĸ����ԣ�1�����޸��˸�����
			    		    							if(StringUtils.isNotEmpty(cid_node.getTextContent().trim())){
			    		    								citb.setCicurver("1");
			    		    							}else{
			    		    								citb.setCicurver("0");
			    		    							}
			    		    						}	
			    		    					}
			    		    					//��������
			    		    					this.soc0107BL.registSOC0107(citb);
			    		    				}
			    		    			}
		    		    			}else{
		    		    				//�����Ѿ����ڵ��ʲ����ʲ����
		    		    				existList.add(eilabel);
		    		    				//ɾ��ռλ��entityitem
		    		    				this.soc0118BL.deleteEntityItem(host_ei);
		    		    			}

		    					}
		    				}
		    			}

		    		}else if(node.getNodeType()==Node.ELEMENT_NODE){//HBA��VG��
		    			
		    			NodeList ei_nodes = node.getChildNodes();
		    			
		    			if(ei_nodes!=null && ei_nodes.getLength()>0){
		    				for(int a=0,b=ei_nodes.getLength();a<b;a++){
		    					Node einode = ei_nodes.item(a);
		    					if(einode.getNodeType()==Node.ELEMENT_NODE && "ENTITYITEM".equals(einode.getNodeName().toUpperCase())){
		    						NamedNodeMap nodemap = einode.getAttributes();
		    		    			//ȡ���ʲ���Ϣ
		    		    			//��ѯ���ʲ��Ƿ��Ѵ���,�粻�����򱣴棬����������
		    		    			String esyscoding = nodemap.getNamedItem("esyscoding").getNodeValue();
		    				    	String eid = nodemap.getNamedItem("eid").getNodeValue();;
		    		    			String eilabel = nodemap.getNamedItem("eilabel").getNodeValue().trim();//�ʲ����
		    		    			String einame = nodemap.getNamedItem("einame").getNodeValue().trim();//�ʲ�����
		    		    			SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		    		    			cond.setEilabel(eilabel);
		    		    			List<SOC0118Info> eiList = this.soc0118BL.searchEntityItem(cond);
		    		    			SOC0118Info ei = null;
		    		    			//���ڣ��򲻱���
		    		    			if(eiList!=null && eiList.size()>0){
		    		    				//����
//		    		    				ver = eiList.get(0).getEiversion()+1;
//		    		    				EntityItemTB eitb = (EntityItemTB)SerializationUtils.clone(eiList.get(0));
//		    		    				eitb.setEiupdtime(nowdate);//����ʱ��
//		    		    				eitb.setEiversion(ver);
//		    		    				
//		    		    				ei = this.soc0118BL.updateEntityItem(eitb);
		    		    				
		    		    				//�����Ѿ����ڵ��ʲ����ʲ����
		    		    				existList.add(eilabel);
		    		    			}else{
		    		    				//����
		    		    				ver = 1;
		    		    				SOC0118TB eitb = new SOC0118TB();
		    			    			eitb.setEid(eid);
		    			    			eitb.setEiname(einame);//�ʲ�����
		    			    			eitb.setEiorgsyscoding(eiorgsyscoding);//��������
		    			    			eitb.setEiinsdate(indate);//�Ǽ���
		    			    			eitb.setEiupdtime(nowdate);//����ʱ��
		    			    			eitb.setEsyscoding(esyscoding.trim());//�ʲ�ģ�Ͳ����
		    			    			eitb.setEilabel(eilabel);//�ʲ����
		    			    			eitb.setEiuserid(eiuserid);//�Ǽ���ID
		    			    			eitb.setEiusername(eiusername);//�Ǽ�������
		    			    			if(esyscoding!=null && esyscoding.length()>=6 && "999001".equals(esyscoding.substring(0, 6))){
		    			    				eitb.setEistatus("N");
		    							}else{
		    								eitb.setEistatus("");//EISTATUS 
		    							}
		    			    			eitb.setEiversion(ver);

		    			    			ei = this.soc0118BL.registEntityItem(eitb);
		    			    			
		    			    			if(ei == null){
			    		    				throw new BLException("IGASM0322.E001");
			    		    			}
			    		    			//ȡ�ø��ʲ������Լ���
			    		    			NodeList cinodes = einode.getChildNodes();
			    		    			for(int n=0,m=cinodes.getLength();n<m;n++){
			    		    				Node cinode = cinodes.item(n);
			    		    				if(cinode.getNodeType()==Node.ELEMENT_NODE && "CI".equals(cinode.getNodeName().toUpperCase())){
			    		    					NamedNodeMap ci_nodemap = cinode.getAttributes();
			    		    					NodeList cid_nodes = cinode.getChildNodes();//cname,value

			    		    					SOC0107TB citb = new SOC0107TB();
			    		    					citb.setEiid(ei.getEiid());
			    		    					citb.setCiupdtime(nowdate);//����ʱ��
			    		    					citb.setCiversion(ver);//���԰汾
			    		    					citb.setEid(ci_nodemap.getNamedItem("eid").getNodeValue());
			        							citb.setEsyscoding(ci_nodemap.getNamedItem("esyscoding").getNodeValue().trim());
			        							citb.setCid(ci_nodemap.getNamedItem("cid").getNodeValue());//CID
			    		    					for(int x=0,y=cid_nodes.getLength();x<y;x++){
			    		    						Node cid_node = cid_nodes.item(x);
			    		    						//����������Ϣ
			    		    						if(cid_node.getNodeType()==Node.ELEMENT_NODE && "VALUE".equals(cid_node.getNodeName().toUpperCase())){
			    		    							citb.setCivalue(cid_node.getTextContent()==null?"":cid_node.getTextContent());
			    		    							//CICURVERΪ0����δ�޸ĸ����ԣ�1�����޸��˸�����
			    		    							if(StringUtils.isNotEmpty(cid_node.getTextContent().trim())){
			    		    								citb.setCicurver("1");
			    		    							}else{
			    		    								citb.setCicurver("0");
			    		    							}
			    		    						}	
			    		    					}
			    		    					//��������
			    		    					this.soc0107BL.registSOC0107(citb);
			    		    				}
			    		    			}

		    		    			}
		    		    			
		    					}
		    				}
		    			}
		    			
		    			
		    			
		    		}
		    		
		    	}
		    	
		    }
		    
		    return result;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			log.debug(e.getCause());
			throw new BLException("IGASM0322.E002");
		} catch (SAXException e) {
			e.printStackTrace();
			log.debug(e.getCause());
			throw new BLException("IGASM0322.E002");
		}  
	}
	/**
	 * ������IGƽ̨�淶��XML�����ļ����뵽CMDB��
	 * @param file
	 * @param user
	 * @param eiid ��ֵ������Ҫ������������Ϣ
	 * @return
	 * @throws BLException
	 */
	@SuppressWarnings({"finally" })
	private String saveXML(File file,User user,SOC0118Info hostei) throws BLException {
		String result = "";
		String eiorgsyscoding = ASMHelper.XML_FILE_ORG_ID;
		String eiuserid = user.getUserid();
		String eiusername = user.getUsername();
		try{
			DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
			DocumentBuilder dombuilder = domfac.newDocumentBuilder();
		    //InputStream is = new FileInputStream(file); //���ļ���ȡ��
			
		    InputSource is = new InputSource(new InputStreamReader(new FileInputStream(file), "GBK"));
		    Document doc = dombuilder.parse(is);   
		    //Document doc = dombuilder.parse(new InputSource(new StringReader(source)));
		    Element root = doc.getDocumentElement();
		    //NamedNodeMap rootmap = root.getAttributes();//root�������Լ���
		    NodeList nodes = root.getChildNodes();
		    //String key = ASMHelper.NODE_KEY;
		    if(nodes!=null){
		    	//ȡ��ģ��esyscoding
		    	String nowdate = IGStringUtils.getCurrentDateTime();
		    	String indate = "";
		    	
		    	for(int i=0,j=nodes.getLength();i<j;i++){
		    		Integer ver = hostei.getEiversion();//���°汾��
		    		Node node = nodes.item(i);
		    		if(node.getNodeType()==Node.ELEMENT_NODE && "DATE".equals(node.getNodeName())){
		    			//ȡ�õǼ�����
		    			indate = node.getTextContent();
		    		}else if(node.getNodeType()==Node.ELEMENT_NODE && "RELATION".equals(node.getNodeName().toUpperCase())){
		    			NamedNodeMap nodemap = node.getAttributes();
		    			NodeList relation_nodes = node.getChildNodes();//from,to
		    			String esyscoding_to = nodemap.getNamedItem("esyscoding").getNodeValue().trim();
		    			String ename_to = nodemap.getNamedItem("ename").getNodeValue().trim();
		    			SocRelationTB soctb = new SocRelationTB();
		    			soctb.setSresycoding(esyscoding_to);
		    			soctb.setSrename(ename_to);
		    			soctb.setVersion(Integer.valueOf(ver));//�汾��
		    			for(int n=0,m=relation_nodes.getLength();n<m;n++){
		    				Node relation_node = relation_nodes.item(n);
		    				if(relation_node.getNodeType()==Node.ELEMENT_NODE && "FROM".equals(relation_node.getNodeName().toUpperCase())){
			    				soctb.setSreilabel(relation_node.getTextContent());
			    			}else if(relation_node.getNodeType()==Node.ELEMENT_NODE && "TO".equals(relation_node.getNodeName().toUpperCase())){
			    				soctb.setSrpareilabel(relation_node.getTextContent());
			    			}
		    			}
		    			//�����ʲ���ϵ
		    			this.socRelationBL.registSocRelation(soctb);
		    			
		    		}else if(node.getNodeType()==Node.ELEMENT_NODE  && "ATTR_SELF".equals(node.getNodeName().toUpperCase())){//HOST
		    			
		    			NodeList ei_nodes = node.getChildNodes();
		    			
		    			if(ei_nodes!=null && ei_nodes.getLength()>0){
		    				for(int a=0,b=ei_nodes.getLength();a<b;a++){
		    					Node einode = ei_nodes.item(a);
		    					if(einode.getNodeType()==Node.ELEMENT_NODE && "ENTITYITEM".equals(einode.getNodeName().toUpperCase())){
		    						NamedNodeMap nodemap = einode.getAttributes();
		    		    			//ȡ���ʲ���Ϣ
		    		    			//��ѯ���ʲ��Ƿ��Ѵ���,�粻�����򱣴棬����������
//		    						String esyscoding = nodemap.getNamedItem("esyscoding").getNodeValue();
//		    				    	String eid = nodemap.getNamedItem("eid").getNodeValue();;
//		    		    			String eilabel = nodemap.getNamedItem("eilabel").getNodeValue().trim();//�ʲ����
		    		    			String einame = nodemap.getNamedItem("einame").getNodeValue().trim();//�ʲ�����
		    		    			SOC0118Info ei = null;
		    						
	    							
	    							//����
	    		    				//ver = entityitem.getEiversion()+1;
	    		    				SOC0118TB eitb = (SOC0118TB)SerializationUtils.clone(hostei);
	    		    				eitb.setEiname(einame);
	    		    				eitb.setEiupdtime(nowdate);//����ʱ��
	    		    				eitb.setEiversion(ver);
	    		    				
	    		    				ei = this.soc0118BL.updateEntityItem(eitb);
		    						

		    		    			if(ei == null){
		    		    				throw new BLException("IGASM0322.E001");
		    		    			}
		    		    			
		    		    			//���ҵ�ǰ�汾�����ԣ�������
    		    					SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
    		    					cond.setEiid(String.valueOf(ei.getEiid()));
    		    					cond.setCiversion(String.valueOf(ver));//���԰汾
    		    					List<SOC0107Info>  cilist = this.soc0107BL.searchSOC0107(cond);
		    		    			
		    		    			//ȡ�ø��ʲ������Լ���
		    		    			NodeList cinodes = einode.getChildNodes();
		    		    			for(int n=0,m=cinodes.getLength();n<m;n++){
		    		    				Node cinode = cinodes.item(n);
		    		    				if(cinode.getNodeType()==Node.ELEMENT_NODE && "CI".equals(cinode.getNodeName().toUpperCase())){
		    		    					NamedNodeMap ci_nodemap = cinode.getAttributes();
		    		    					NodeList cid_nodes = cinode.getChildNodes();//cname,value
	
		    		    					//boolean ciflag = true;//�Ƿ���Ҫ��������
		    		    					SOC0107TB citb = new SOC0107TB();
		    		    					citb.setEiid(ei.getEiid());
		    		    					citb.setCiupdtime(nowdate);//����ʱ��
		    		    					citb.setCiversion(ver);//���԰汾
		    		    					citb.setEid(ci_nodemap.getNamedItem("eid").getNodeValue());
		        							citb.setEsyscoding(ci_nodemap.getNamedItem("esyscoding").getNodeValue().trim());
		        							citb.setCid(ci_nodemap.getNamedItem("cid").getNodeValue());//CID
		        							for(int x=0,y=cid_nodes.getLength();x<y;x++){
		    		    						Node cid_node = cid_nodes.item(x);
		    		    						//����������Ϣ
		    		    						if(cid_node.getNodeType()==Node.ELEMENT_NODE && "VALUE".equals(cid_node.getNodeName().toUpperCase())){
		    		    							citb.setCivalue(cid_node.getTextContent()==null?"":cid_node.getTextContent());
		    		    							//CICURVERΪ0����δ�޸ĸ����ԣ�1�����޸��˸�����
		    		    							if(StringUtils.isNotEmpty(cid_node.getTextContent().trim())){
		    		    								citb.setCicurver("1");
		    		    							}else{
		    		    								citb.setCicurver("0");
		    		    							}
		    		    						}	
		    		    					}

		        							for(SOC0107Info config:cilist){
		    		    						if(config.getCid().equals(citb.getCid())){
		    		    							citb.setCiid(config.getCiid());//��������
		    		    							//��������
				    		    					this.soc0107BL.updateSOC0107(citb);
				    		    					break;
		    		    						}
		    		    					}

		    		    					//��������
//		        							if(ciflag){
//		        								this.soc0107BL.registSOC0107(citb);
//		        							}
		    		    					
		    		    				}
		    		    			}
		    					}
		    				}
		    			}

		    		}else if(node.getNodeType()==Node.ELEMENT_NODE){//HBA��VG��
		    			
		    			NodeList ei_nodes = node.getChildNodes();
		    			
		    			if(ei_nodes!=null && ei_nodes.getLength()>0){
		    				for(int a=0,b=ei_nodes.getLength();a<b;a++){
		    					Node einode = ei_nodes.item(a);
		    					if(einode.getNodeType()==Node.ELEMENT_NODE && "ENTITYITEM".equals(einode.getNodeName().toUpperCase())){
		    						NamedNodeMap nodemap = einode.getAttributes();
		    		    			//ȡ���ʲ���Ϣ
		    		    			//��ѯ���ʲ��Ƿ��Ѵ���,�粻�����򱣴棬����������
		    		    			String esyscoding = nodemap.getNamedItem("esyscoding").getNodeValue();
		    				    	String eid = nodemap.getNamedItem("eid").getNodeValue();;
		    		    			String eilabel = nodemap.getNamedItem("eilabel").getNodeValue().trim();//�ʲ����
		    		    			String einame = nodemap.getNamedItem("einame").getNodeValue().trim();//�ʲ�����
		    		    			SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		    		    			cond.setEilabel(eilabel);
		    		    			List<SOC0118Info> eiList = this.soc0118BL.searchEntityItem(cond);
		    		    			SOC0118Info ei = null;
		    		    			if(eiList!=null && eiList.size()>0){
		    		    				//����
		    		    				ver = eiList.get(0).getEiversion()+1;
		    		    				SOC0118TB eitb = (SOC0118TB)SerializationUtils.clone(eiList.get(0));
		    		    				eitb.setEiupdtime(nowdate);//����ʱ��
		    		    				eitb.setEiversion(ver);
		    		    				
		    		    				ei = this.soc0118BL.updateEntityItem(eitb);
		    		    			}else{
		    		    				//����
		    		    				ver = 1;
		    		    				SOC0118TB eitb = new SOC0118TB();
		    			    			eitb.setEid(eid);
		    			    			eitb.setEiname(einame);//�ʲ�����
		    			    			eitb.setEiorgsyscoding(eiorgsyscoding);//��������
		    			    			eitb.setEiinsdate(indate);//�Ǽ���
		    			    			eitb.setEiupdtime(nowdate);//����ʱ��
		    			    			eitb.setEsyscoding(esyscoding.trim());//�ʲ�ģ�Ͳ����
		    			    			eitb.setEilabel(eilabel);//�ʲ����
		    			    			eitb.setEiuserid(eiuserid);//�Ǽ���ID
		    			    			eitb.setEiusername(eiusername);//�Ǽ�������
		    			    			if(esyscoding!=null && esyscoding.length()>=6 && "999001".equals(esyscoding.substring(0, 6))){
		    			    				eitb.setEistatus("N");
		    							}else{
		    								eitb.setEistatus("");//EISTATUS 
		    							}
		    			    			eitb.setEiversion(ver);

		    			    			ei = this.soc0118BL.registEntityItem(eitb);
		    		    			}
		    		    			if(ei == null){
		    		    				throw new BLException("IGASM0322.E001");
		    		    			}
		    		    			//ȡ�ø��ʲ������Լ���
		    		    			NodeList cinodes = einode.getChildNodes();
		    		    			for(int n=0,m=cinodes.getLength();n<m;n++){
		    		    				Node cinode = cinodes.item(n);
		    		    				if(cinode.getNodeType()==Node.ELEMENT_NODE && "CI".equals(cinode.getNodeName().toUpperCase())){
		    		    					NamedNodeMap ci_nodemap = cinode.getAttributes();
		    		    					NodeList cid_nodes = cinode.getChildNodes();//cname,value

		    		    					SOC0107TB citb = new SOC0107TB();
		    		    					citb.setEiid(ei.getEiid());
		    		    					citb.setCiupdtime(nowdate);//����ʱ��
		    		    					citb.setCiversion(ver);//���԰汾
		    		    					citb.setEid(ci_nodemap.getNamedItem("eid").getNodeValue());
		        							citb.setEsyscoding(ci_nodemap.getNamedItem("esyscoding").getNodeValue().trim());
		        							citb.setCid(ci_nodemap.getNamedItem("cid").getNodeValue());//CID
		    		    					for(int x=0,y=cid_nodes.getLength();x<y;x++){
		    		    						Node cid_node = cid_nodes.item(x);
		    		    						//����������Ϣ
		    		    						if(cid_node.getNodeType()==Node.ELEMENT_NODE && "VALUE".equals(cid_node.getNodeName().toUpperCase())){
		    		    							citb.setCivalue(cid_node.getTextContent()==null?"":cid_node.getTextContent());
		    		    							//CICURVERΪ0����δ�޸ĸ����ԣ�1�����޸��˸�����
		    		    							if(StringUtils.isNotEmpty(cid_node.getTextContent().trim())){
		    		    								citb.setCicurver("1");
		    		    							}else{
		    		    								citb.setCicurver("0");
		    		    							}
		    		    						}	
		    		    					}
		    		    					//��������
		    		    					this.soc0107BL.registSOC0107(citb);
		    		    				}
		    		    			}
		    					}
		    				}
		    			}
		    			
		    			
		    			
		    		}
		    		
		    	}
		    	
		    }
		}catch(Exception e){
			e.printStackTrace();
			log.debug(e.getCause());
			throw new BLException("IGASM0322.E002");
		}finally{
			return result;
		}
	}


	/**
	 *�豸��Ϣ�޸Ĵ���
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO updateEntityItem(IGCIM01DTO dto) throws BLException {
		
		log.debug("========�豸��Ϣ�༭���������ʾ����ʼ========");
		
		IGCIM0108Form form = dto.getIgcim0108Form();
		if(!form.getEilabel().equals(form.getEilabelbak())){
			this.soc0118BL.checkNotExistEntityItem(form.getEilabel());
		}
		this.soc0118BL.updateEntityItem(form);
		dto.addMessage(new ActionMessage("IGCO10000.I005",resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.001")));
		log.debug("========�豸��Ϣ�༭���������ʾ��������========");
		return dto;
	}


	/**
	 * �豸��ϵ�ǼǴ���
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO insertEntityItemRelationAction(IGCIM01DTO dto) throws BLException{
		log.debug("========�豸��ϵ�ǼǴ���ʼ========");
		
		IGCIM0107Form form = dto.getIgcim0107Form();
		
		//�豸ID���ӣ�ȡ��
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		
		cond.setElabel(form.getElabel());
		cond.setEilabel(form.getEilabel());
		
		List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
		
		if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
			try {
				throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.010")
						+ form.getElabel() + resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.011") 
						+ form.getEilabel() + resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.012"));
			} catch (BLException e) {
				//
				e.printStackTrace();
			}
		}
		
		form.setCldeiid(entityItemVWList.get(0).getEiid());
		form.setCldeid(entityItemVWList.get(0).getEid());
		
		//�豸ID�������ͣ��ӣ����
		if (form.getPareiid().intValue() == form.getCldeiid().intValue()) {
			//�豸ID������= ���ӣ�
			try {
				throw new BLException(BLErrorType.ENTITY_ITEM_RELATION_ERROR,
						"IGCO10000.E012",resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.004"));
			} catch (BLException e) {
				//
				e.printStackTrace();
			}
		}
		
		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
		form.setCldversion(entityItemVWList.get(0).getEiversion());
		
		//�ʲ���ϵ�Ǽ�      20120731 add �ظ���ϵ��֤
		SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
		condeir.setPareiid(Integer.parseInt(form.getPareiid().toString()));
		condeir.setCldeiid(form.getCldeiid());
		condeir.setEirrelationcode(form.getEirrelationcode());
		condeir.setDeleteflag("0");
		List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
		condeir =new SOC0119SearchCondImpl();
		condeir.setCldeiid(form.getPareiid());
		condeir.setPareiid(Integer.parseInt(form.getCldeiid().toString()));
		condeir.setEirrelationcode(form.getEirrelationcode());
		condeir.setDeleteflag("0");
		List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
		if(list_eir.size()>0||list_eirCld.size()>0){
				throw new BLException(BLErrorType.ENTITY_ITEM_RELATION_ERROR,"IGASM0307.E001",resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.020"));
		}
		SOC0119Info ret = null;
		try {
			ret = this.soc0119BL.registEntityItemRelation(dto.getIgcim0107Form());
		} catch (BLException e) {
			//
			e.printStackTrace();
		}
		
		dto.setEntityItemRelation(ret);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.013")) );
		
		log.debug("========�豸��ϵ�ǼǴ�������========");
		return dto;
	}


	/**
	 * �豸��ϵ���������
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO updateEntityItemRelationAction(IGCIM01DTO dto) {
		log.debug("========�豸��ϵ���������ʼ========");
		IGCIM0107Form form = dto.getIgcim0107Form();

		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		try {
			this.soc0119BL.updateEntityItemRelation(form);
		} catch (BLException e) {
			//
			e.printStackTrace();
		}

		dto.addMessage(new ActionMessage( "IGCO10000.I005", resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.009")) );

		log.debug("========�豸��ϵ�������������========");
		return dto;
	}
	//add from asm08blimpl
	/**
	 * Ӧ����Ϣ��ѯ����
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO searchEntityItemActionApp(IGCIM01DTO dto) throws BLException {

		log.debug("========Ӧ����Ϣ��ѯ����ʼ========");
		
		//Ӧ����Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(dto.getEntityItemVWSearchCond());
		
		if (totalCount == 0) {
			log.debug("========Ӧ����Ϣ��ѯ���ݲ�����========");
			//Ӧ����Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========Ӧ����Ϣ��ѯ���ݼ�������========");
			//Ӧ����Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳӦ����Ϣȡ��
		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL.searchEntityItemVW(dto.getEntityItemVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemVWInfoList(entityItemVWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========Ӧ����Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * Ӧ����Ϣ�ǼǴ���
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO insertEntityItemActionApp(IGCIM01DTO dto) throws BLException {
		log.debug("========Ӧ����Ϣ�ǼǴ���ʼ========");
		//����Formȡ��
		IGCIM0122Form form = dto.getIgasm0802Form();
		
		/*//����IDȡ��
		EntitySearchCondImpl cond = new EntitySearchCondImpl();
		cond.setElabel(form.getElabel());
		
		//�ǼǴ���ǰ���ʲ���Ϣȷ��
		List<Entity> entityList = this.soc0117BL.searchEntity(cond, 0, 0);
		
		if ( entityList == null || entityList.size() ==0 ) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","(���=" + form.getElabel() + ")�ʲ�����");
		}
		
		Entity entity = entityList.get(0);
		
		//***************************************************************************
		//���ͷ�����
		if (!entity.getEcategory().equals(CommonDefineUtils.ENTIY_CATEGORY_APPLICATION)) {
			//Ӧ����������
			throw new BLException(BLErrorType.ENTITY_CATEGORY_ERROR,
					"IGCO10000.E011","Ӧ��");
		}
		//***************************************************************************
		
		form.setEid(entity.getEid());*/
		form.setEidStr(form.getEid().toString());
		
		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		form.setEiupdtime(datetime);
		
		//��汾�趨���̶���Ϊ0��
		form.setEiversion(0);
		
		//С�汾�趨���̶���Ϊ0��
		form.setEismallversion(0);

		//Ӧ����Ϣ��¼
		SOC0118Info entityItem = this.soc0118BL.registEntityItem(dto.getIgasm0802Form());
		
		form.setEiidStr(entityItem.getEiid().toString());
		
		dto.setIgasm0802Form(form);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.001")) );

		log.debug("========Ӧ����Ϣ�ǼǴ�������========");
		return dto;
	}

	/**
	 * Ӧ����Ϣɾ������
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO deleteEntityItemActionApp(IGCIM01DTO dto) throws BLException {
		log.debug("========Ӧ����Ϣɾ������ʼ========");
		
		for( int i=0;i<dto.getDeleteEntityItem().length;i++ ){
			String eiid = dto.getDeleteEntityItem()[i];
			
			//ɾ��ǰɾ������Ӧ��ȷ��
			SOC0118Info entityItem = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(eiid));
			
			if (entityItem == null){
				throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.002"));
			}

			//ɾ����·
			this.soc0114BL.delByEiid(entityItem.getEiid());
			//ɾ����ϵ
			this.soc0119BL.delByEiid(entityItem.getEiid());
			//Ӧ��ɾ��
			this.soc0118BL.deleteEntityItem(entityItem);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.003")));

		log.debug("========Ӧ����Ϣɾ����������========");
		return dto;
	}

	/**
	 * Ӧ��������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO initIGCIM0124Action(IGCIM01DTO dto) throws BLException {

		log.debug("========Ӧ��������Ϣ�༭������ڻ�����ʼ========");
		
		IGCIM0124Form form = dto.getIgasm0804Form();
		
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
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.004"));
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
		//Ӧ��������Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0107BL.getConfigItemVWSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========Ӧ��������Ϣ��ѯ���ݲ�����========");
			//Ӧ��������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========Ӧ��������Ϣ��ѯ���ݼ�������========");
			//Ӧ��������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//Ӧ��������Ϣȫ����ѯ
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
				if("4".equals(e.getCattach()) && StringUtils.isNotEmpty(e.getCivalue())){
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
//		dto.addMessage(new ActionMessage("IGCO10000.I007",totalCount));


		
		log.debug("========Ӧ��������Ϣ�༭������ڻ���������========");
		return dto;
	}
	
	/**
	 * Ӧ��������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO initIGCIM0148Action(IGCIM01DTO dto) throws BLException {

		log.debug("========Ӧ��������Ϣ�༭������ڻ�����ʼ========");
		
		IGCIM0148Form form = dto.getIgcim0148Form();
		
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
		entityItemVWInfo.setEmodeltype(entity.getEmodeltype());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.004"));
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
		
		//�Ƿ�ɼ̳б�ʶ��ʹ��entity����Ԥ���ֶ�EKEY2, 0����̳У�1�����̳�
		String ekey2 = entity.getEkey2();
		form.setEkey2(ekey2);
		
		//Ӧ��������Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0107BL.getConfigItemVWSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========Ӧ��������Ϣ��ѯ���ݲ�����========");
			//Ӧ��������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========Ӧ��������Ϣ��ѯ���ݼ�������========");
			//Ӧ��������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		
		//Ӧ��������Ϣȫ����ѯ
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
				if("4".equals(e.getCattach()) && StringUtils.isNotEmpty(e.getCivalue())){
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
//		dto.addMessage(new ActionMessage("IGCO10000.I007",totalCount));


		
		log.debug("========Ӧ��������Ϣ�༭������ڻ���������========");
		return dto;
	}
	
	/**
	 * Ӧ��������Ϣ�༭����
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGCIM01DTO editEntityItemActionApp(IGCIM01DTO dto) throws BLException, FileNotFoundException, IOException {
		log.debug("========Ӧ��������Ϣ�༭����ʼ========");
		//�汾������
		IGCIM0124Form form = dto.getIgasm0804Form();
		
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
				if("4".equals(form.getCiattach()[i]) && StringUtils.isNotEmpty(form.getEntityItemCivalue()[i])){
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
	
		//���ø�����·����
		Properties properties = getProperties();
		String importBatName = properties.getProperty("MANUALSNAPSHOTAPP_PATH");
		String[] cmd = new String[5];
		cmd[0] = "cmd";
		cmd[1] = "/c";
		cmd[2] = "start";
		cmd[3] = " ";
		try {
			cmd[4] = importBatName;
		    //����bat�ļ�ִ��
			if("true".equals(properties.getProperty("MANUALSNAPSHOTAPP_FLAG"))){
				java.lang.Runtime.getRuntime().exec(cmd);
			}
		} catch (IOException e) {
			log.error("������·�����쳣", e);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I005",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.007")));
		
		log.debug("========Ӧ��������Ϣ�༭��������========");
		
		return dto;
	}
	
	private Properties getProperties() throws BLException {
		//CI����Ӧ����Դ�ļ�
		Properties properties = null;
		//������
		FileInputStream inputFile = null;
		//���������ļ�
		try {
			properties = new Properties();
			inputFile = new FileInputStream(ResourceUtility.getString("CI_IMPORT_FILE_PATH"));
			properties.load(inputFile);
		} catch (FileNotFoundException e) {
			log.error("CI����Ӧ����Դ�ļ���ȡ����", e);
			throw new BLException("IGCIM0201.E001");
		} catch (IOException e) {
			log.error("CI����Ӧ����Դ�ļ���ȡ����", e);
			throw new BLException("IGCIM0201.E001");
		} finally {
			if(inputFile != null) {
				try {
					inputFile.close();
				} catch (IOException e) {
					log.error("CI����Ӧ����Դ�ļ���ȡ����", e);
					throw new BLException("IGCIM0201.E001");
				}
			}
		}
		return properties;
	}
	/**
	 * Ӧ��������Ϣ�༭����
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGCIM01DTO editIGCIM0148ActionApp(IGCIM01DTO dto) throws BLException, FileNotFoundException, IOException {
		log.debug("========�豸������Ϣ�༭����ʼ========");
		//�汾������
		IGCIM0148Form form = dto.getIgcim0148Form();
		
		//����ģ������С�汾������������汾
		int version = form.getEiversion();//��汾
		int smallversion = form.getEismallversion();//С�汾
		String fileversion = version + "";//�����汾
		
		if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(form.getEmodeltype())) {
			smallversion++;
			fileversion = version + "_" + smallversion;
		} else {
			version++;
		}
		
		//�豸������Ϣ����
		SOC0118TB entityItem = (SOC0118TB) this.soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getEiid()));

		//�ж������Ƿ��Ѿ�������
		if(EntityItemKeyWords.EMODELTYPE_CONFIGURATION.equals(form.getEmodeltype())) {
			if(smallversion - 1 != entityItem.getEismallversion()) {
				throw new BLException("IGCO00000.E004");
			}
		} else {
			if(version - 1 != entityItem.getEiversion()) {
				throw new BLException("IGCO00000.E004");
			}
		}
		
		//�ʲ���ϵ��Ϣ�汾��������
		this.soc0119BL.upgradeEntityItemRelation(entityItem.getEiid(), entityItem.getEiversion(), entityItem.getEismallversion(),
				version, smallversion);
		
		//�ʲ�������ϵ��Ϣ�汾��������
		this.soc0110BL.upgradeEntityItemRelation(entityItem.getEiid(), entityItem.getEiversion(), entityItem.getEismallversion(),
				version, smallversion);
		
		//�豸״̬
		entityItem.setEistatus(form.getEistatus());
		
		//�豸��汾
		entityItem.setEiversion(version);
		
		//�豸С�汾
		entityItem.setEismallversion(smallversion);
		
		//�豸˵��
		entityItem.setEidesc(form.getEidesc());

		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		//����ʱ��
		entityItem.setEiupdtime(datetime);
		
		//�豸����
		entityItem.setEiname(form.getEiname());
		
		SOC0118Info hostei = this.soc0118BL.updateEntityItem(entityItem);
		
		//���ø���BL
		String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
		String fileNameXML = null;
		SOC0118Info hosteiXML = null;
		boolean flagXML = false;
		
		boolean copyFlag = false;//�Ƿ�Ϊ�����������ļ�
		SOC0107TB configItemXML = new SOC0107TB();
		//�豸������Ϣ����
		if (form.getCiid() != null && form.getCiid().length > 0 ) {
			
			for( int i=0 ; i < form.getCiid().length; i++ ){
				SOC0107TB configItem = new SOC0107TB();
				//�豸ID
				configItem.setEiid(Integer.parseInt(form.getEiid()));
				//�ʲ�����ID
				configItem.setCid(form.getCid()[i]);
				//����ID
				configItem.setEid(form.getEid()[i]);
				//���Ͳ����
				configItem.setEsyscoding(form.getEsyscoding()[i]);
				//��汾��
				configItem.setCiversion(version);
				//С�汾��
				configItem.setCismallversion(smallversion);
				//����ʱ��
				configItem.setCiupdtime(datetime);
				
				if (StringUtils.isEmpty(form.getCiid()[i])) {
					//Ĭ�����ԣ��豸״̬
					if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_STATUS.equals(form.getClabel()[i])){
						configItem.setCivalue(CommonDefineUtils.ENTITYITEM_STARUS_NEW);
					}else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORID.equals(form.getClabel()[i])){
						//Ĭ�����ԣ�������id
						configItem.setCivalue(dto.getUserid());
					}else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORNAME.equals(form.getClabel()[i])){
						//Ĭ�����ԣ�������
						configItem.setCivalue(dto.getUsername());
					}else{
						//��ʾ���ʲ����ƣ�ʵ�ʴ�ֵ���ʲ�����(�ʲ�ID)
						if("4".equals(form.getCiattach()[i]) && StringUtils.isNotEmpty(form.getEntityItemCivalue()[i])){
							configItem.setCivalue(form.getEntityItemCivalue()[i]);
						}else {
							configItem.setCivalue(form.getCivalue()[i]);
						}
					}
					
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
						if(IGASM03BLImpl.DEVICE_DEVICE.equals(relationcode)){
							e.setEirrelation(IGASM03BLImpl.DEVICE_DEVICE_CONN_ID);
							e.setEirrelationcode(IGASM03BLImpl.DEVICE_DEVICE);
						}else{
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
						}
						e.setEirupdtime(datetime);
						//��ѯ��������
						SOC0109Info config = this.soc0109BL.searchConfigurationByKey(form.getCid()[i]);
						String cname = config.getCname();
						e.setEirdesc(resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.005")+cname+
								resources.getMessage(dto.getLocale(),"message.IGACIM01BLImpl.006"));
						//����key
						e.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
						//����״̬ΪC����ϵ�����в���ɾ��
						e.setEirstatus("C");
						this.soc0119BL.registEntityItemRelation(e);
					}
					log.debug("�ʲ������[�ʲ�����ID:" + form.getCid()[i] + "]���봦��ɹ���");
					
				} else {
					if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORID.equals(form.getClabel()[i])){
						//Ĭ�����ԣ�������id
						configItem.setCivalue(dto.getUserid());
					}else if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_OPERATORNAME.equals(form.getClabel()[i])){
						//Ĭ�����ԣ�������
						configItem.setCivalue(dto.getUsername());
					}else{
						//��ʾ���ʲ����ƣ�ʵ�ʴ�ֵ���ʲ�����(�ʲ�ID)
						if("4".equals(form.getCiattach()[i]) && StringUtils.isNotEmpty(form.getEntityItemCivalue()[i])){
							configItem.setCivalue(form.getEntityItemCivalue()[i]);
						}else {
							configItem.setCivalue(form.getCivalue()[i]);
						}
					}
					
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
							if(IGASM03BLImpl.DEVICE_DEVICE.equals(relationcode)){
								e.setEirrelation(IGASM03BLImpl.DEVICE_DEVICE_CONN_ID);
								e.setEirrelationcode(IGASM03BLImpl.DEVICE_DEVICE);
							}else{
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
							}
							e.setEirupdtime(datetime);
							//��ѯ��������
							SOC0109Info config = this.soc0109BL.searchConfigurationByKey(form.getCid()[i]);
							String cname = config.getCname();
							e.setEirdesc(resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.005")+cname+
									resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.006"));
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
						
						StringBuffer pathBuf = new StringBuffer();
						
						//��Ŀ¼
						pathBuf.append(rootPath);
						//����ID
						pathBuf.append("asm"+File.separator);
						//�豸ID
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
						fileName.append(fileversion);
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
				//=================================>
				//�ϴ�xml�ļ����
				if (form.getCiattach()[i].toUpperCase().equals("8")) {
					FormFile file = form.getAttachFileXML(i);
					if ( file != null && file.getFileSize() > 0) {
						//�ϴ��ļ����ڵ����
						//�ϴ��ļ�·��
						
						StringBuffer pathBuf = new StringBuffer();
						
						//��Ŀ¼
						pathBuf.append(rootPath+"XML"+File.separator+"asm"+File.separator);
						//�豸ID
						pathBuf.append(configItem.getEiid()+File.separator);
						
						StringBuffer fileName = new StringBuffer();
						
						//��չ��ȡ��
						String fileType = "";
						String sFileName = file.getFileName();
						int point = sFileName.lastIndexOf(".");
						if (point != -1) {
							fileType = sFileName.substring(point);
							fileName.append(sFileName.substring(0, point));
						}

						//�ļ���չ��
						fileName.append(fileType);
						fileName.append("_" + fileversion);
						//�ļ��ϴ�����
						this.fileUploadBL.saveFile(file, pathBuf.toString(), fileName.toString());
						
						//�ϴ��ļ�������
						configItem.setCivalue(fileName.toString());
						
						//�������Ա�ʶ
						configItem.setCicurver("1");
						
						this.soc0107BL.updateSOC0107(configItem);			
						hosteiXML = hostei;
						flagXML = true;
						fileNameXML = fileName.toString();
						configItemXML = configItem;
						
						copyFlag = true;
					}else{
						if(!copyFlag){
							//�����ļ�����
							//����ģ�崴��Excel�ļ�
							Integer ver = configItem.getCiversion() - 1;
							if(ver==0){
								ver = 1;
							}
							File modelfile = new File(rootPath+"XML"+File.separator+"asm"+File.separator+String.valueOf(configItem.getEiid())+File.separator+"config-view.xml_"+String.valueOf(ver));
							
							if(modelfile.exists()){
								File newfile = new File(rootPath+"XML"+File.separator+"asm"+File.separator+String.valueOf(configItem.getEiid())+File.separator+"config-view.xml_" + fileversion);
								
								FileInputStream fis = new FileInputStream(modelfile);
								BufferedReader in = new BufferedReader(new InputStreamReader(fis));
								
								FileOutputStream output = new FileOutputStream(newfile);
								String str = null;
								while((str=in.readLine())!=null){
									output.write(str.getBytes());
								}
								
								in.close();
								output.flush();
								output.close();
								
								copyFlag = false;
								
								SOC0107TB newConfigItem = (SOC0107TB)SerializationUtils.clone(configItem);
								newConfigItem.setCivalue("config-view.xml_" + fileversion);
								
								this.soc0107BL.updateSOC0107(newConfigItem);			
							}
							
							
							
						}
						
					}
				}
				//<============================================
			}
			
			if(copyFlag){
				saveXML(new File(rootPath+"XML"+File.separator+"asm"+File.separator+String.valueOf(configItemXML.getEiid())+File.separator+fileNameXML),dto.getUser(),hostei);
			}
			
			
		}
		
	    //����ֵ�����仯ʱ������ʵ��Ķ���CI���Ϊ�޸ģ�����ֶ����յ�Ч��
		if (entityItem.getEirootmark() != null) {
			SOC0118TB topCI = (SOC0118TB) this.soc0118BL.searchEntityItemByKey(entityItem.getEirootmark());
			String topciName = topCI.getEiname();
			SOC0126SearchCondImpl eiDomainDetailMaxVWSearchCond = new SOC0126SearchCondImpl();
			eiDomainDetailMaxVWSearchCond.setTypeId("1");
			eiDomainDetailMaxVWSearchCond.setEiname(topciName);
			List<SOC0138Info> listEiDomainDetailMax=soc0126BL.searchEiDomainDetailVW(eiDomainDetailMaxVWSearchCond,0,0);
			for(SOC0138Info eiDomainDetailMaxVWInfo:listEiDomainDetailMax){
				
				SOC0112PK pk = new SOC0112PK(eiDomainDetailMaxVWInfo.getEiddid(),
						eiDomainDetailMaxVWInfo.getEiddversion(),
						eiDomainDetailMaxVWInfo.getEiname(),
						eiDomainDetailMaxVWInfo.getEiImportversion());
				SOC0112Info eiDomainDetailInfo =soc0112BL.searchEiDomainDetailByPK(pk);
				SOC0112TB instance = (SOC0112TB)SerializationUtils.clone(eiDomainDetailInfo);
				instance.setModifyFlag("1");
				soc0112BL.updateEiDomainDetail(instance);
				
			}
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I005",resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.007")));
		
		log.debug("========�豸������Ϣ�༭��������========");
		
		return dto;
	}

	/**
	 * Ӧ��������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO initIGCIM0125Action(IGCIM01DTO dto) throws BLException {
		log.debug("========Ӧ��������Ϣ��ʷ��¼������ڻ�����ʼ========");
		
		//Ӧ����Ϣ����
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				Integer.parseInt(dto.getIgasm0805Form().getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.004"));
		}
		String eiorgsyscoding = entityItemVWInfo.getEiorgsyscoding();
		if(!StringUtils.isEmpty(eiorgsyscoding)){
			OrganizationSearchCondImpl OrgCond = new OrganizationSearchCondImpl();
			OrgCond.setOrgsyscoding(eiorgsyscoding);
			List<Organization> orgList = this.organizationBL.searchOrganization(OrgCond, 0, 0);
			for (int i = 0; i < orgList.size(); i++) {
				dto.setEiorgname(orgList.get(0).getOrgname());
			}
		}
		if ( entityItemVWInfo.getEiversion() == 0 ) {
			dto.addMessage(new ActionMessage("IGASM0205.W001"));
		}
		
		dto.setEntityItemVWInfo(entityItemVWInfo);
		
		if (StringUtils.isEmpty(dto.getIgasm0805Form().getCiversion())) {
			dto.getIgasm0805Form().setCiversion(entityItemVWInfo.getEiversion()+"");
		}
		//��ȡ��ʷ�汾����ʱ��
		dto.setConfigItemVersionTime(this.soc0118BL.searchVersionUpdateTime(Integer.parseInt(dto.getIgasm0805Form().getEiid())));
		
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		log.debug("========Ӧ��������Ϣ��ʷ��¼������ڻ���������========");
		return dto;
	}

	/**
	 * Ӧ�ù�ϵ��������ڻ�����
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO initIGCIM0126Action(IGCIM01DTO dto) throws BLException {
		log.debug("========Ӧ�ù�ϵ��������ڻ�����ʼ========");
		
		//Ӧ����Ϣ����
//		EntityItemVWInfo entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
//				Integer.parseInt(dto.getIgasm0806Form().getEiid()));
		//��ǰ����ͼ�����ǵ�����������ҳ��ֻ�õ�2�������ݣ�ֻ���2�������ݣ�Ȼ��ƴ����ͼ����. _ylq
		String eiid = dto.getIgasm0806Form().getEiid();
		if (StringUtils.isEmpty(eiid)) {
			return dto;
		}
		SOC0118Info entityItemInfo=soc0118BL.searchEntityItemByKey(Integer.parseInt(dto.getIgasm0806Form().getEiid()));
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
		entityItemVWInfo.setEiorgsyscoding(entityItemInfo.getEiorgsyscoding());
		entityItemVWInfo.setEiversion(entityItemInfo.getEiversion());
		entityItemVWInfo.setEismallversion(entityItemInfo.getEismallversion());
		entityItemVWInfo.setEid(entityItemInfo.getEid());
		entityItemVWInfo.setEiid(entityItemInfo.getEiid());
		entityItemVWInfo.setEirootmark(entityItemInfo.getEirootmark());
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.004"));
		}
		String eiorgsyscoding = entityItemVWInfo.getEiorgsyscoding();
		if(!StringUtils.isEmpty(eiorgsyscoding)){
			OrganizationSearchCondImpl OrgCond = new OrganizationSearchCondImpl();
			OrgCond.setOrgsyscoding(eiorgsyscoding);
			List<Organization> orgList = this.organizationBL.searchOrganization(OrgCond, 0, 0);
			for (int i = 0; i < orgList.size(); i++) {
				dto.setEiorgname(orgList.get(0).getOrgname());
			}
		}
		dto.setEntityItemVWInfo(entityItemVWInfo);
		
		Map<String,List<SOC0119Info>> parmap = new LinkedHashMap<String,List<SOC0119Info>>();
		//���������ϵ����
		SOC0119SearchCondImpl parcond = new SOC0119SearchCondImpl();
		
		parcond.setPareiid(Integer.parseInt(dto.getIgasm0806Form().getEiid()));
		parcond.setParversion(Integer.parseInt(entityItemVWInfo.getEiversion().toString()));
		parcond.setParsmallversion(Integer.parseInt(entityItemVWInfo.getEismallversion().toString()));
		parcond.setDeleteflag("0");
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		//Ӧ�ù�ϵ��Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0119BL.getEntityItemRelationSearchCount(parcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========Ӧ�ù�ϵ��Ϣ��ѯ���ݼ�������========");
			//Ӧ�ù�ϵ��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		if ( totalCount>0 ) {
			//Ӧ�ù�ϵ��Ϣȫ������
			//�豸��ϵ��Ϣȫ������
			List<SOC0119Info> parEntityItemRelationList = 
				this.soc0119BL.searchMaxEntityItemRelation(parcond);
			dto.setParCount(parEntityItemRelationList.size());
			for(SOC0119Info e : parEntityItemRelationList){
				String eirrelation = e.getEirrelation();
				//�����ϵ����ʾ
				if (EntityItemKeyWords.PASSWORD_Relation.equals(eirrelation)) {
					continue;
				}
				String key = e.getEirrelationcode().split("-")[0];
				String eirrelationcode = e.getEirrelationcode();
				String ecategory = e.getParEntityItemVW().getEcategory();
				if(!"-".equals(eirrelationcode.replaceAll(ecategory, ""))){
					key = eirrelationcode.replaceAll(ecategory, "").replaceAll("-", "");
				}
				if(!"014001".equals(key)){
					if(!parmap.containsKey(key)){
						parmap.put(key, new ArrayList<SOC0119Info>());
					}
					((SOC0119TB)e).setParflag("0");
					parmap.get(key).add(e);
				}
					
			}
		}
		
		//���������ϵ����
		//������ϵ����
		SOC0119SearchCondImpl cldcond = new SOC0119SearchCondImpl();
		
		cldcond.setCldeiid(Integer.parseInt(dto.getIgasm0806Form().getEiid()));
		cldcond.setCldversion(entityItemVWInfo.getEiversion());
		cldcond.setCldsmallversion(entityItemVWInfo.getEismallversion());
		cldcond.setDeleteflag("0");
		
		//Ӧ�ù�ϵ��Ϣ��ѯ����ȡ�� 
		totalCount = this.soc0119BL.getEntityItemRelationSearchCount(cldcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========Ӧ�ù�ϵ��Ϣ��ѯ���ݼ�������========");
			//Ӧ�ù�ϵ��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//Ӧ�ù�ϵ��Ϣȫ������
		List<SOC0119Info> cldEntityItemRelationList = 
			this.soc0119BL.searchMaxEntityItemRelation(
					cldcond);
		
		dto.setParCount(dto.getParCount()+cldEntityItemRelationList.size());
//		dto.addMessage(new ActionMessage("IGCO10000.I007",dto.getParCount()));
		for(SOC0119Info e : cldEntityItemRelationList){
			String eirrelation = e.getEirrelation();
			//�����ϵ����ʾ
			if (EntityItemKeyWords.PASSWORD_Relation.equals(eirrelation)) {
				continue;
			}
			String key = e.getEirrelationcode().split("-")[0];
			String eirrelationcode = e.getEirrelationcode();
			String ecategory = e.getCldEntityItemVW().getEcategory();
			if(!"-".equals(eirrelationcode.replaceAll(ecategory, ""))){
				key = eirrelationcode.replaceAll(ecategory, "").replaceAll("-", "");
			}
			if(!"014001".equals(key)){
				if(!parmap.containsKey(key)){
					parmap.put(key, new ArrayList<SOC0119Info>());
				}
				((SOC0119TB)e).setParflag("1");
				parmap.get(key).add(e);
			}
		}
		if(parmap.size()==0){
			parmap = null;
		}
		dto.setParEntityItemRelationMap(parmap);

		log.debug("========Ӧ�ù�ϵ��������ڻ���������========");
		return dto;
	}
	
	/**
	 * Ӧ�ù�ϵɾ������
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO deleteEntityItemRelationActionApp(IGCIM01DTO dto) throws BLException {
		log.debug("========Ӧ�ù�ϵɾ������ʼ========");
		
		for( int i=0;i<dto.getDeleteEntityItemRelation().length;i++ ){
			String eirid = dto.getDeleteEntityItemRelation()[i];
			
			SOC0119Info entityItemRelation = 
				this.soc0119BL.searchEntityItemRelationByKey(Integer.parseInt(eirid));
			
			if (entityItemRelation == null){
				throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.008"));
			}
			//baiyf 2011/12/23  start
			SOC0118SearchCondImpl entityItemcond=new SOC0118SearchCondImpl();
			entityItemcond.setEid("115");
			entityItemcond.setEirootmark(entityItemRelation.getCldeiid());
			//�������µ�FS��Ϣ
			List<SOC0118Info> entityItemList=this.soc0118BL.searchEntityItem(entityItemcond);
			SOC0119SearchCondImpl cond=new SOC0119SearchCondImpl();
			cond.setPareiid(entityItemRelation.getPareiid());
			cond.setDeleteflag("0");
			//��Ӧ�õ����й�ϵ��Ϣ
			List<SOC0119Info> entityItemRelationList=this.soc0119BL.searchEntityItemRelation(cond);
			if(entityItemRelationList!=null&&entityItemRelationList.size()>0){
				for(SOC0119Info entityItemRelationInfo:entityItemRelationList){
					//ɾ����Ӧ��������������й�ϵ���߼�ɾ����
					if(entityItemRelationInfo.getCldeiid().equals(entityItemRelation.getCldeiid())){
						this.soc0119BL.deleteEntityItemRelation(entityItemRelationInfo);
					}
					//ɾ����Ӧ�����������FS�����й�ϵ���߼�ɾ����
					if(entityItemList!=null&&entityItemList.size()>0){
						for(SOC0118Info entityItemInfo:entityItemList){
							if(entityItemInfo.getEiid().equals(entityItemRelationInfo.getCldeiid())){
								this.soc0119BL.deleteEntityItemRelation(entityItemRelationInfo);
							}
						}
					}
				}
			}
			//baiyf 2011/12/23  end
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.009")));

		log.debug("========Ӧ�ù�ϵɾ����������========");
		return dto;
	}

	/**
	 * Ӧ�ù�ϵ�ǼǴ���
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO insertEntityItemRelationActionApp(IGCIM01DTO dto) throws BLException {
		log.debug("========Ӧ�ù�ϵ�ǼǴ���ʼ========");
		
		IGCIM0127Form form = dto.getIgasm0807Form();
		
		//Ӧ��ID���ӣ�ȡ��
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		
		cond.setElabel(form.getElabel());
		cond.setEilabel(form.getEilabel());
		
		List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
		
		if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.010")
					+ form.getElabel() + resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.011") 
					+ form.getEilabel() + resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.012"));
		}
		
		form.setCldeiid(entityItemVWList.get(0).getEiid());
		form.setCldeid(entityItemVWList.get(0).getEid());
		form.setCldversion(entityItemVWList.get(0).getEiversion());
		form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
		//Ӧ��ID�������ͣ��ӣ����
		if (form.getPareiid().intValue() == form.getCldeiid().intValue()) {
			//Ӧ��ID������= ���ӣ�
			throw new BLException(BLErrorType.ENTITY_ITEM_RELATION_ERROR,
					"IGCO10000.E012",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.004"));
		}
		
		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		//�ʲ���ϵ�Ǽ�      20120731 add �ظ���ϵ��֤
		SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
		condeir.setPareiid(form.getPareiid());
		condeir.setCldeiid(form.getCldeiid());
		condeir.setEirrelationcode(form.getEirrelationcode());
		condeir.setDeleteflag("0");
		List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
		condeir =new SOC0119SearchCondImpl();
		condeir.setCldeiid(form.getPareiid());
		condeir.setPareiid(form.getCldeiid());
		condeir.setEirrelationcode(form.getEirrelationcode());
		condeir.setDeleteflag("0");
		List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
		if(list_eir.size()>0||list_eirCld.size()>0){
			throw new BLException(BLErrorType.ENTITY_ITEM_RELATION_ERROR,"IGASM0307.E001",resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.020"));
		}
		SOC0119Info ret = 
			this.soc0119BL.registEntityItemRelation(dto.getIgasm0807Form());
		//�ж���ʵ��ʱ������ҵ��ϵͳ��DB��ҵ��ϵͳ������֮��Ĺ�ϵ
		if("CR030001000002".equals(form.getEirrelation())){
			createEntityItemRelationActionAppToWebServer(form,entityItemVWList.get(0));
			createEntityItemRelationActionAppToHost(form,entityItemVWList.get(0));
		}else if("CR030001000003".equals(form.getEirrelation())){
			createEntityItemRelationActionAppToWEBAPP2(form,entityItemVWList.get(0));
			createEntityItemRelationActionAppToHost(form,entityItemVWList.get(0));
		}
		dto.setEntityItemRelation(ret);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.013")) );
		
		log.debug("========Ӧ�ù�ϵ�ǼǴ�������========");
		return dto;
	}
	
	private void createEntityItemRelationActionAppToWEBAPP2(IGCIM0127Form form,
			SOC0124Info soc0124Info) throws BLException {
		SOC0110SearchCondImpl soc0110Cond=new SOC0110SearchCondImpl();
		soc0110Cond.setBrcldeiid(soc0124Info.getEiid()+"");
		soc0110Cond.setBrcldversion(soc0124Info.getEiversion()+"");
		soc0110Cond.setBrcldsmallversion(soc0124Info.getEismallversion()+"");
		soc0110Cond.setBrassetrelation("CR020004000001");
		List<SOC0110Info> soc0110InfoList=this.soc0110BL.searchEiBelongRelation(soc0110Cond);
		if(soc0110InfoList!=null&&soc0110InfoList.size()>0){
			SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
			List<String> eiidList=new ArrayList<String>();
			eiidList.add(soc0110InfoList.get(0).getBrpareiid()+"");
			cond.setEiidList(eiidList);
			List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
			if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
				throw new BLException("IGCO10000.E004","���ݿ�");
			}
			form.setCldeiid(entityItemVWList.get(0).getEiid());
			form.setCldeid(entityItemVWList.get(0).getEid());
			form.setCldversion(entityItemVWList.get(0).getEiversion());
			form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
			form.setEirrelation("CR030001000005");
			//����ʱ���趨
			Date nowDateTime = new Date();
			String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

			form.setEirupdtime(datetime);
			
			//�ʲ���ϵ�Ǽ�      20120731 add �ظ���ϵ��֤
			SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
			condeir.setPareiid(form.getPareiid());
			condeir.setCldeiid(form.getCldeiid());
			condeir.setEirrelationcode(form.getEirrelationcode());
			condeir.setDeleteflag("0");
			List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
			condeir =new SOC0119SearchCondImpl();
			condeir.setCldeiid(form.getPareiid());
			condeir.setPareiid(form.getCldeiid());
			condeir.setEirrelationcode(form.getEirrelationcode());
			condeir.setDeleteflag("0");
			List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
			if(list_eir.size()>0||list_eirCld.size()>0){
			}else{
				this.soc0119BL.registEntityItemRelation(form);
			}
		}
	}
	
	/**
	 * ����ҵ��ϵͳ������֮��Ĺ�ϵ
	 * @param form
	 * @param soc0124Info
	 * @throws BLException
	 */
	public void createEntityItemRelationActionAppToHost(IGCIM0127Form form,SOC0124Info soc0124Info) throws BLException {
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		List<String> eiidList=new ArrayList<String>();
		eiidList.add(soc0124Info.getEirootmark()+"");
		cond.setEiidList(eiidList);
		List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
		if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
			throw new BLException("IGCO10000.E004","����");
		}
		form.setCldeiid(entityItemVWList.get(0).getEiid());
		form.setCldeid(entityItemVWList.get(0).getEid());
		form.setCldversion(entityItemVWList.get(0).getEiversion());
		form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
		form.setEirrelation("CR030100010001");
		form.setEirrelationcode("003-001");
		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		//�ʲ���ϵ�Ǽ�      20120731 add �ظ���ϵ��֤
		SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
		condeir.setPareiid(form.getPareiid());
		condeir.setCldeiid(form.getCldeiid());
		condeir.setEirrelationcode(form.getEirrelationcode());
		condeir.setDeleteflag("0");
		List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
		condeir =new SOC0119SearchCondImpl();
		condeir.setCldeiid(form.getPareiid());
		condeir.setPareiid(form.getCldeiid());
		condeir.setEirrelationcode(form.getEirrelationcode());
		condeir.setDeleteflag("0");
		List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
		if(list_eir.size()>0||list_eirCld.size()>0){
		}else{
			this.soc0119BL.registEntityItemRelation(form);
		}
	}
	
	public void createEntityItemRelationActionAppToWebServer(IGCIM0127Form form,SOC0124Info soc0124Info) throws BLException {
		SOC0110SearchCondImpl soc0110Cond=new SOC0110SearchCondImpl();
		soc0110Cond.setBrcldeiid(soc0124Info.getEiid()+"");
		soc0110Cond.setBrcldversion(soc0124Info.getEiversion()+"");
		soc0110Cond.setBrcldsmallversion(soc0124Info.getEismallversion()+"");
		soc0110Cond.setBrassetrelation("CR020002000001");
		List<SOC0110Info> soc0110InfoList=this.soc0110BL.searchEiBelongRelation(soc0110Cond);
		if(soc0110InfoList!=null&&soc0110InfoList.size()>0){
			SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
			List<String> eiidList=new ArrayList<String>();
			eiidList.add(soc0110InfoList.get(0).getBrpareiid()+"");
			cond.setEiidList(eiidList);
			List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
			if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
				throw new BLException("IGCO10000.E004","Web������");
			}
			form.setCldeiid(entityItemVWList.get(0).getEiid());
			form.setCldeid(entityItemVWList.get(0).getEid());
			form.setCldversion(entityItemVWList.get(0).getEiversion());
			form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
			form.setEirrelation("CR030001000004");
			//����ʱ���趨
			Date nowDateTime = new Date();
			String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

			form.setEirupdtime(datetime);
			
			//�ʲ���ϵ�Ǽ�      20120731 add �ظ���ϵ��֤
			SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
			condeir.setPareiid(form.getPareiid());
			condeir.setCldeiid(form.getCldeiid());
			condeir.setEirrelationcode(form.getEirrelationcode());
			condeir.setDeleteflag("0");
			List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
			condeir =new SOC0119SearchCondImpl();
			condeir.setCldeiid(form.getPareiid());
			condeir.setPareiid(form.getCldeiid());
			condeir.setEirrelationcode(form.getEirrelationcode());
			condeir.setDeleteflag("0");
			List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
			if(list_eir.size()>0||list_eirCld.size()>0){
			}else{
				this.soc0119BL.registEntityItemRelation(form);
			}
			createEntityItemRelationWebToAppServer(form,entityItemVWList.get(0));
		}
	}
	
	public void createEntityItemRelationWebToAppServer(IGCIM0127Form form,SOC0124Info soc0124Info) throws BLException {
		SOC0110SearchCondImpl soc0110Cond=new SOC0110SearchCondImpl();
		soc0110Cond.setBrcldeiid(soc0124Info.getEiid()+"");
		soc0110Cond.setBrcldversion(soc0124Info.getEiversion()+"");
		soc0110Cond.setBrcldsmallversion(soc0124Info.getEismallversion()+"");
		soc0110Cond.setBrassetrelation("CR020001000001");
		List<SOC0110Info> soc0110InfoList=this.soc0110BL.searchEiBelongRelation(soc0110Cond);
		if(soc0110InfoList!=null&&soc0110InfoList.size()>0){
			for(SOC0110Info soc0110Info:soc0110InfoList){
				SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
				List<String> eiidList=new ArrayList<String>();
				eiidList.add(soc0110Info.getBrpareiid()+"");
				cond.setEiidList(eiidList);
				List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
				if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
				}else{
					form.setCldeiid(entityItemVWList.get(0).getEiid());
					form.setCldeid(entityItemVWList.get(0).getEid());
					form.setCldversion(entityItemVWList.get(0).getEiversion());
					form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
					form.setEirrelation("CR030001000001");
					form.setEirrelationcode("003-002");
					//����ʱ���趨
					Date nowDateTime = new Date();
					String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

					form.setEirupdtime(datetime);
					
					//�ʲ���ϵ�Ǽ�      20120731 add �ظ���ϵ��֤
					SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
					condeir.setPareiid(form.getPareiid());
					condeir.setCldeiid(form.getCldeiid());
					condeir.setEirrelationcode(form.getEirrelationcode());
					condeir.setDeleteflag("0");
					List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
					condeir =new SOC0119SearchCondImpl();
					condeir.setCldeiid(form.getPareiid());
					condeir.setPareiid(form.getCldeiid());
					condeir.setEirrelationcode(form.getEirrelationcode());
					condeir.setDeleteflag("0");
					List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
					if(list_eir.size()>0||list_eirCld.size()>0){
					}else{
						this.soc0119BL.registEntityItemRelation(form);
					}
					createEntityItemRelationAppToHostByWebServer(form,entityItemVWList.get(0));
				}
			}
		}
	}
	
	/**
	 * ����ҵ��ϵͳ��webapp
	 * @param form
	 * @param soc0124Info
	 */
	private void createEntityItemRelationActionAppToWEBAPP(IGCIM0127Form form,
			SOC0124Info soc0124Info) throws BLException {
		SOC0110SearchCondImpl soc0110Cond=new SOC0110SearchCondImpl();
		soc0110Cond.setBrcldeiid(soc0124Info.getEiid()+"");
		soc0110Cond.setBrcldversion(soc0124Info.getEiversion()+"");
		soc0110Cond.setBrcldsmallversion(soc0124Info.getEismallversion()+"");
		soc0110Cond.setBrassetrelation("CR020002000001");
		List<SOC0110Info> soc0110InfoList=this.soc0110BL.searchEiBelongRelation(soc0110Cond);
		if(soc0110InfoList!=null&&soc0110InfoList.size()>0){
			SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
			List<String> eiidList=new ArrayList<String>();
			eiidList.add(soc0110InfoList.get(0).getBrpareiid()+"");
			cond.setEiidList(eiidList);
			List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
			if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
				throw new BLException("IGCO10000.E004","Webapp");
			}
			form.setCldeiid(entityItemVWList.get(0).getEiid());
			form.setCldeid(entityItemVWList.get(0).getEid());
			form.setCldversion(entityItemVWList.get(0).getEiversion());
			form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
			form.setEirrelation("CR030100010005");
			//����ʱ���趨
			Date nowDateTime = new Date();
			String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

			form.setEirupdtime(datetime);
			
			//�ʲ���ϵ�Ǽ�      20120731 add �ظ���ϵ��֤
			SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
			condeir.setPareiid(form.getPareiid());
			condeir.setCldeiid(form.getCldeiid());
			condeir.setEirrelationcode(form.getEirrelationcode());
			condeir.setDeleteflag("0");
			List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
			condeir =new SOC0119SearchCondImpl();
			condeir.setCldeiid(form.getPareiid());
			condeir.setPareiid(form.getCldeiid());
			condeir.setEirrelationcode(form.getEirrelationcode());
			condeir.setDeleteflag("0");
			List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
			if(list_eir.size()>0||list_eirCld.size()>0){
			}else{
				this.soc0119BL.registEntityItemRelation(form);
			}
		}
	}


	/**
	 * ����ҵ��ϵͳ������֮��Ĺ�ϵ
	 * @param form
	 * @param soc0124Info
	 * @throws BLException
	 */
	public void createEntityItemRelationActionAppToHost(IGCIM0152Form form,SOC0124Info soc0124Info) throws BLException {
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		List<String> eiidList=new ArrayList<String>();
		eiidList.add(soc0124Info.getEirootmark()+"");
		cond.setEiidList(eiidList);
		List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
		if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
			throw new BLException("IGCO10000.E004","����");
		}
		form.setCldeiid(entityItemVWList.get(0).getEiid());
		form.setCldeid(entityItemVWList.get(0).getEid());
		form.setCldversion(entityItemVWList.get(0).getEiversion());
		form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
		form.setEirrelation("CR030100010001");
		form.setEirrelationcode("003-001");
		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		//�ʲ���ϵ�Ǽ�      20120731 add �ظ���ϵ��֤
		SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
		condeir.setPareiid(form.getPareiid());
		condeir.setCldeiid(form.getCldeiid());
		condeir.setEirrelationcode(form.getEirrelationcode());
		condeir.setDeleteflag("0");
		List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
		condeir =new SOC0119SearchCondImpl();
		condeir.setCldeiid(form.getPareiid());
		condeir.setPareiid(form.getCldeiid());
		condeir.setEirrelationcode(form.getEirrelationcode());
		condeir.setDeleteflag("0");
		List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
		if(list_eir.size()>0||list_eirCld.size()>0){
		}else{
			this.soc0119BL.registEntityItemRelation(form);
		}
	}
	
	/**
	 * ����ҵ��ϵͳ��DB֮��Ĺ�ϵ
	 * @param form
	 * @param soc0124Info
	 * @throws BLException
	 */
	public void createEntityItemRelationActionAppToOracle(IGCIM0127Form form,SOC0124Info soc0124Info) throws BLException {
		SOC0110SearchCondImpl soc0110Cond=new SOC0110SearchCondImpl();
		soc0110Cond.setBrcldeiid(soc0124Info.getEiid()+"");
		soc0110Cond.setBrcldversion(soc0124Info.getEiversion()+"");
		soc0110Cond.setBrcldsmallversion(soc0124Info.getEismallversion()+"");
		soc0110Cond.setBrassetrelation("CR020004000001");
		List<SOC0110Info> soc0110InfoList=this.soc0110BL.searchEiBelongRelation(soc0110Cond);
		if(soc0110InfoList!=null&&soc0110InfoList.size()>0){
			SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
			List<String> eiidList=new ArrayList<String>();
			eiidList.add(soc0110InfoList.get(0).getBrpareiid()+"");
			cond.setEiidList(eiidList);
			List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
			if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
				throw new BLException("IGCO10000.E004","DB");
			}
			form.setCldeiid(entityItemVWList.get(0).getEiid());
			form.setCldeid(entityItemVWList.get(0).getEid());
			form.setCldversion(entityItemVWList.get(0).getEiversion());
			form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
			form.setEirrelation("CR030100010003");
			//����ʱ���趨
			Date nowDateTime = new Date();
			String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

			form.setEirupdtime(datetime);
			
			//�ʲ���ϵ�Ǽ�      20120731 add �ظ���ϵ��֤
			SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
			condeir.setPareiid(form.getPareiid());
			condeir.setCldeiid(form.getCldeiid());
			condeir.setEirrelationcode(form.getEirrelationcode());
			condeir.setDeleteflag("0");
			List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
			condeir =new SOC0119SearchCondImpl();
			condeir.setCldeiid(form.getPareiid());
			condeir.setPareiid(form.getCldeiid());
			condeir.setEirrelationcode(form.getEirrelationcode());
			condeir.setDeleteflag("0");
			List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
			if(list_eir.size()>0||list_eirCld.size()>0){
			}else{
				this.soc0119BL.registEntityItemRelation(form);
			}
		}
	}
	
	/**
	 * ����ҵ��ϵͳ��DB֮��Ĺ�ϵ
	 * @param form
	 * @param soc0124Info
	 * @throws BLException
	 */
	public void createEntityItemRelationWebAppToOracle(IGCIM0127Form form,SOC0124Info soc0124Info) throws BLException {
		SOC0110SearchCondImpl soc0110Cond=new SOC0110SearchCondImpl();
		soc0110Cond.setBrcldeiid(soc0124Info.getEiid()+"");
		soc0110Cond.setBrcldversion(soc0124Info.getEiversion()+"");
		soc0110Cond.setBrcldsmallversion(soc0124Info.getEismallversion()+"");
		soc0110Cond.setBrassetrelation("CR020100010001");
		List<SOC0110Info> soc0110InfoList=this.soc0110BL.searchEiBelongRelation(soc0110Cond);
		if(soc0110InfoList!=null&&soc0110InfoList.size()>0){
			SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
			List<String> eiidList=new ArrayList<String>();
			eiidList.add(soc0110InfoList.get(0).getBrpareiid()+"");
			cond.setEiidList(eiidList);
			List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
			if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
				throw new BLException("IGCO10000.E004","DB");
			}
			form.setCldeiid(entityItemVWList.get(0).getEiid());
			form.setCldeid(entityItemVWList.get(0).getEid());
			form.setCldversion(entityItemVWList.get(0).getEiversion());
			form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
			form.setEirrelation("CR030100010003");
			//����ʱ���趨
			Date nowDateTime = new Date();
			String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

			form.setEirupdtime(datetime);
			
			//�ʲ���ϵ�Ǽ�      20120731 add �ظ���ϵ��֤
			SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
			condeir.setPareiid(form.getPareiid());
			condeir.setCldeiid(form.getCldeiid());
			condeir.setEirrelationcode(form.getEirrelationcode());
			condeir.setDeleteflag("0");
			List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
			condeir =new SOC0119SearchCondImpl();
			condeir.setCldeiid(form.getPareiid());
			condeir.setPareiid(form.getCldeiid());
			condeir.setEirrelationcode(form.getEirrelationcode());
			condeir.setDeleteflag("0");
			List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
			if(list_eir.size()>0||list_eirCld.size()>0){
			}else{
				this.soc0119BL.registEntityItemRelation(form);
			}
		}
		
	}
	
	/**
	 * Ӧ�ù�ϵ�༭������ڻ�����
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO initIGCIM0127Action(IGCIM01DTO dto) throws BLException {
		log.debug("========Ӧ�ù�ϵ�༭������ڻ�����ʼ========");
		
		IGCIM0127Form form = dto.getIgasm0807Form();
		SOC0119TB ret = 		
			(SOC0119TB) this.soc0119BL.searchEntityItemRelationByKey(
				form.getEirid());
		
		if ( ret == null ){
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.014"));
		}
		
		//��������趨
		form.setPareiname(ret.getParEntityItemVW().getEiname());
		form.setPareid(ret.getPareid());
		form.setPareiid(ret.getPareiid());
		form.setCldeid(ret.getCldeid());
		form.setCldeiid(ret.getCldeiid());
		form.setEiridStr(ret.getEirid().toString());
		form.setEirdesc(ret.getEirdesc());
		form.setEirinfo(ret.getEirinfo());
		form.setEirrelation(ret.getEirrelation());
		form.setEirrelationcode(ret.getEirrelationcode());
		form.setElabel(ret.getCldEntityItemVW().getElabel());
		form.setEilabel(ret.getCldEntityItemVW().getEilabel());
		form.setTempeirrelation(ret.getEirrelation()+"#"+ret.getEirrelationcode());
		form.setEiname(ret.getCldEntityItemVW().getEiname());
		form.setMode("1");
		
		log.debug("========Ӧ�ù�ϵ�༭������ڻ���������========");
		return dto;
	}

	/**
	 * Ӧ�ù�ϵ���������
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO updateEntityItemRelationActionApp(IGCIM01DTO dto) throws BLException {
		log.debug("========Ӧ�ù�ϵ���������ʼ========");
		IGCIM0127Form form = dto.getIgasm0807Form();

		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		this.soc0119BL.updateEntityItemRelation(form);

		dto.addMessage(new ActionMessage( "IGCO10000.I005", resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.013")) );

		log.debug("========Ӧ�ù�ϵ�������������========");
		return dto;
	}
	
	/**
	 *	��ȡӦ�ù�����ϵ����
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO searchRelationListActionApp(IGCIM01DTO dto) throws BLException {
		log.debug("========��ȡӦ�ù�����ϵ����ʼ========");
		List<LabelValueBean> list = this.codeDetailBL.searchLabelValueBeanList(CommonDefineUtils.ENTIY_CATEGORY_APPLICATION,CodeDefine.getCodeDefine("ENTITYITEM_RELATION_CODE").getCcid());
		dto.setRelationList(list);
		log.debug("========��ȡӦ�ù�����ϵ��������========");
		return dto;
	}
	

	/**
	 *	��ȡFS������ϵ����
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO searchFSRelationListAction(IGCIM01DTO dto) throws BLException {
		log.debug("========��ȡFS������ϵ����ʼ========");
		SOC0118SearchCondImpl econd = new SOC0118SearchCondImpl();
		econd.setEirootmark(dto.getIgasm0813Form().getEiid());		//FS������Ӧ��EIID
		econd.setEid(EntityItemKeyWords.FS_EID);					//FS��EID
		List<SOC0118Info> eiList = this.soc0118BL.searchEntityItem(econd);
		SOC0119SearchCondImpl ercond  = new SOC0119SearchCondImpl();
		ercond.setPareiid(dto.getIgasm0813Form().getPareiid());
		ercond.setEirrelationcode(EntityItemKeyWords.APP_FS_RelationCODE);
		ercond.setDeleteflag("0");
		List<SOC0119Info> eirList = this.soc0119BL.searchEntityItemRelation(ercond);
		List<SOC0118Info> choosedList = new ArrayList<SOC0118Info>();		//�Ѿ�ѡ���fs��ϵ�б�
		List<SOC0118Info> choosableList = new ArrayList<SOC0118Info>();	//����ѡ���fs��ϵ�б�
		if(eirList!=null&&eirList.size()>0){
			List<Integer> eiidList = new ArrayList<Integer>();
			for(SOC0119Info eir:eirList){//�����Ѿ�ѡ���fs eiid�б�
				eiidList.add(eir.getCldeiid());
			}
			if(eiList!=null&&eiList.size()>0){
				for(SOC0118Info ei:eiList){
					if(eiidList.contains(ei.getEiid())){
						choosedList.add(ei);
					}else{
						choosableList.add(ei);
					}
				}
			}
			dto.setEntityItemList(choosableList);	//����ѡ���fs��ϵ�б�
			dto.setEntityItemedList(choosedList);//�Ѿ�ѡ���fs��ϵ�б�
		}else{
			dto.setEntityItemList(eiList);	//����ѡ���fs��ϵ�б�
			dto.setEntityItemedList(choosedList);//�Ѿ�ѡ���fs��ϵ�б�
		}
		
		
		log.debug("========��ȡFS������ϵ��������========");
		return dto;
	}
	
	/**
	 *	����FS������ϵ����
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO insertFSRelationAction(IGCIM01DTO dto) throws BLException {
		log.debug("========����FS������ϵ����ʼ========");
		IGCIM0129Form form  = dto.getIgasm0813Form();
		String[] eiids = form.getEiids();
		if(eiids!=null&&eiids.length>0){
			for(int i=0;i<eiids.length;i++){
				SOC0119TB entityItemRelation = new SOC0119TB();
				entityItemRelation.setPareiid(form.getPareiid());	//Ӧ��eiid
				entityItemRelation.setPareid(EntityItemKeyWords.APP_EID); //Ӧ��EID
				entityItemRelation.setCldeiid(Integer.valueOf(eiids[i]));	//FS eiid
				entityItemRelation.setCldeid(EntityItemKeyWords.FS_EID); //FS EID
				entityItemRelation.setEirrelation(EntityItemKeyWords.APP_FS_Relation);	//Ӧ��fs��ϵ
				entityItemRelation.setEirrelationcode(EntityItemKeyWords.APP_FS_RelationCODE);
				entityItemRelation.setEirupdtime(IGStringUtils.getCurrentDateTime());
				entityItemRelation.setParversion(form.getParversion());
				entityItemRelation.setParsmallversion(form.getParsmallversion());
				entityItemRelation.setCldversion(Integer.valueOf(form.getEiversions()[i]));
				entityItemRelation.setCldsmallversion(Integer.valueOf(form.getEismallversions()[i]));
				entityItemRelation.setDeleteflag("0");		//�߼�ɾ����ʶ
				this.soc0119BL.registEntityItemRelation(entityItemRelation);
			}
		}
		
		
		log.debug("========����FS������ϵ��������========");
		return dto;
	}
	
	/**
	 *	ɾ��FS������ϵ����
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO deleteFSRelationAction(IGCIM01DTO dto) throws BLException {
		log.debug("========ɾ��FS������ϵ����ʼ========");
		IGCIM0129Form form  = dto.getIgasm0813Form();
		String[] eiids = form.getEiids();
		if(eiids!=null&&eiids.length>0){
			for(int i=0;i<eiids.length;i++){
				SOC0119SearchCondImpl ercond  = new SOC0119SearchCondImpl();
				ercond.setCldeiid(Integer.parseInt(eiids[i]));
				ercond.setEirrelationcode(EntityItemKeyWords.APP_FS_RelationCODE);
				ercond.setDeleteflag("0");
				List<SOC0119Info> eirList= this.soc0119BL.searchEntityItemRelation(ercond);
				if(eirList!=null&&eirList.size()>0){
					SOC0119TB eirTB = (SOC0119TB) eirList.get(0);
					eirTB.setDeleteflag("1");
					this.soc0119BL.updateEntityItemRelation(eirTB);
				}
			}
		}
		
		
		log.debug("========ɾ��FS������ϵ��������========");
		return dto;
	}
	
	/**
	 *Ӧ����Ϣ�޸ĳ�����ʾ����
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO initEntityItemApp(IGCIM01DTO dto) throws BLException {

		log.debug("========Ӧ����Ϣ�༭���������ʾ����ʼ========");
		
		IGCIM0128Form form = dto.getIgasm0812Form();
		
		//��ʾ���ʲ���Ϣȡ��
		SOC0124Info entityItem = this.soc0118BL.searchEntityItemVWByKey(form.getEiid());
		
		if ( entityItem == null ){
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.015"));
		}
		
		//������ʾ�趨
		
		String orgsyscoding = entityItem.getEiorgsyscoding();
		String esyscoding = entityItem.getEsyscoding();
		SOC0117SearchCondImpl EntityCond = new SOC0117SearchCondImpl();
		EntityCond.setEsyscoding(esyscoding);
		List<SOC0117Info> entityList = this.soc0117BL.searchEntity(EntityCond, 0, 0);
		for (int i = 0; i < entityList.size(); i++) {
			form.setEname(entityList.get(0).getEname());
		}
		OrganizationSearchCondImpl OrgCond = new OrganizationSearchCondImpl();
		OrgCond.setOrgsyscoding(orgsyscoding);
		List<Organization> orgList = this.organizationBL.searchOrganization(OrgCond, 0, 0);
		for (int i = 0; i < orgList.size(); i++) {
			form.setEiorgname(orgList.get(0).getOrgname());
		}
		form.setEiorgsyscoding(orgsyscoding);
		form.setEiid(entityItem.getEiid());
		form.setEid(entityItem.getEid());
		form.setEistatus(entityItem.getEistatus());
		form.setEiupdtime(entityItem.getEiupdtime());
		form.setEiversion(entityItem.getEiversion());
		form.setEsyscoding(entityItem.getEsyscoding());
		form.setEilabel(entityItem.getEilabel());
		form.setEiname(entityItem.getEiname());
		form.setEiinsdate(entityItem.getEiinsdate());
		form.setEidesc(entityItem.getEidesc());
		form.setEilabelbak(entityItem.getEilabel());
		form.setEiuserid(entityItem.getEiuserid());
		form.setEiusername(entityItem.getEiusername());
		
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		boolean permission = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItem);
		boolean isRoleManager = this.userRoleBL.checkRoleManagerByType(dto.getUser().getUserid(), EntityCategory.ROLE_TYPE_APPLICATION);
		form.setRoleManager(isRoleManager);
		form.setPermission(permission);
		
		dto.setIgasm0812Form(form);
		
		//dto.addMessage(new ActionMessage("IGCO10000.I001","Ӧ�û�����Ϣ"));
		if(!permission) {
			dto.addMessage(new ActionMessage("IGCO10000.E023",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.016")));
		}
		log.debug("========Ӧ����Ϣ�༭���������ʾ��������========");
		return dto;
	}
	/**
	 *Ӧ����Ϣ�޸Ĵ���
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGCIM01DTO updateEntityItemApp(IGCIM01DTO dto) throws BLException {
		
		log.debug("========Ӧ����Ϣ�༭���������ʾ����ʼ========");
		
		IGCIM0128Form form = dto.getIgasm0812Form();
		if(!form.getEilabel().equals(form.getEilabelbak())){
			this.soc0118BL.checkNotExistEntityItem(form.getEilabel());
		}
		this.soc0118BL.updateEntityItem(form);
		dto.addMessage(new ActionMessage("IGCO10000.I005",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.001")));
		log.debug("========Ӧ����Ϣ�༭���������ʾ��������========");
		return dto;
	}
	
	/**
	 * ��ȡӦ�ñ�����ֵ
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO searchEntityItemLableActionApp(IGCIM01DTO dto) throws BLException {
		
		log.debug("========��ȡӦ�ñ�����ֵ����ʼ========");
		
		IGCIM0122Form form = dto.getIgasm0802Form();
		
		SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		
		cond.setEilabel(CommonDefineUtils.ENTIY_CATEGORY_APPLICATION_KEY + IGStringUtils.getCurrentYear().substring(2));
		
		String eilabel = this.soc0118BL.searchNextEntityItemLable(cond);
		
		form.setEilabel(eilabel);
		
		log.debug("========��ȡӦ�ñ�����ֵ��������========");
		return dto;
	}
	
	/**
	 * �жϵ�½�û��Ƿ���Ӧ���ʲ������ɫ������
	 * 
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 * @throws BLException 
	 */
	public IGCIM01DTO checkEntityItemDomainApp(IGCIM01DTO dto) throws BLException{
		boolean isRoleManager = this.userRoleBL.checkRoleManagerByType(dto.getUser().getUserid(), EntityCategory.ROLE_TYPE_APPLICATION);
		
		if(isRoleManager) {
			OrganizationSearchCondImpl orgCond = new OrganizationSearchCondImpl();
			orgCond.setOrgpar("0001");
			List<Organization> org = this.organizationBL.searchOrganization(orgCond);
			
			if(org.size() != 1) {
				throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.017"));
			} else {
				dto.setOrgname(org.get(0).getOrgname());
				dto.setOrgsyscoding(org.get(0).getOrgsyscoding());
			}
			SOC0117SearchCondImpl entityCond = new SOC0117SearchCondImpl();
			entityCond.setEsyscoding(CommonDefineUtils.ENTIY_CATEGORY_APPLICATION_SYSCODING);
			List<SOC0117Info> entity = this.soc0117BL.searchEntity(entityCond, 0, 0);
			
			if(entity.size() != 1) {
				throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.018"));
			} else {
				dto.setEname(entity.get(0).getEname());
				dto.setEsyscoding(entity.get(0).getEsyscoding());
			}
		}
		
		dto.setFlag(isRoleManager);
		
		return dto;
	}

	/**
	 * ����Դ���ݰ汾��Ϣȡ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO getRciVersionsAction(IGCIM01DTO dto) throws BLException {
		log.debug("==============����Դ���ݰ汾��Ϣȡ�ò�����ʼ===============");
		//ҳ����Ϣȡ��
		IGCIM0110Form form = dto.getIgcim0110Form();
		//�ʲ���Ϣȡ��
//		SOC0118Info entity = this.soc0118BL.searchEntityItemByKey(form.getEiid());
//		dto.setEntityItem(entity);
		//����ԭ���������б��ѯ
//		if(entity!=null&&StringUtils.isNotEmpty(entity.getEiname())){
		int count = Integer.valueOf(ResourceUtility.getString("CI_SHOW_CONT"));
		CR03SearchCondImpl cond = new CR03SearchCondImpl();
//			cond.setHost(entity.getEiname());
		cond.setHost(form.getHost());
		cond.setIp(form.getIp());
		cond.setType(form.getType());
		cond.setServername(form.getServername());
		try{
			if(StringUtils.isNotEmpty(form.getCollecttimeFrom())){
				SimpleDateFormat d1 = new SimpleDateFormat("yyyyMMddHHmmss");
				SimpleDateFormat d2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				cond.setCollecttimeFrom(d1.format(d2.parse(form.getCollecttimeFrom().trim()+" 00:00:00")));
				if(StringUtils.isNotEmpty(form.getCollecttimeTo())){
					cond.setCollecttimeTo(d1.format(d2.parse(form.getCollecttimeTo().trim()+" 23:59:59")));
					count = 0;
				}
			}
		}catch (Exception e) {
			log.error("",e);
		}
//		List<CR03Info> list = cr03BL.searchCR03(cond,0,count);
		List<CR03VWInfo> list = cr03BL.getRciVersions(cond, 0, count); 
//			dto.setEntityItem(entity);
		dto.setCr03VWList(list);
//		}
		if(dto.getCr03VWList()==null||dto.getCr03VWList().isEmpty()){
			dto.setShowFlag("N");
		}else{
			dto.setShowFlag("Y");
		}
		log.debug("==============����Դ���ݰ汾��Ϣȡ�ò�������===============");
		return dto;
	}
	
	/**
	 * ��ǰ���°汾��Ϣȡ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO getCurrentNewCriVersionAction(IGCIM01DTO dto) throws BLException {
		log.debug("=============��ǰ���°汾��Ϣȡ�ò�����ʼ=============");
		//���а汾��Ϣȡ��
		long maxTime = 0;
		List<CR03VWInfo> list = dto.getCr03VWList();
		//��ȡ���°汾
		CR03VWInfo cr03 = null;
		if(list!=null){
			for(CR03VWInfo c:list){
				if(cr03 == null){
					maxTime = Long.valueOf(c.getMinctime());
					cr03 = c;
				}else{
					if(Long.valueOf(c.getMinctime())>Long.valueOf(cr03.getMinctime())){
						cr03 = c;
					}
					
				
				}
			}
		}
		dto.setCr03VW(cr03);
		log.debug("=============��ǰ���°汾��Ϣȡ�ò�������=============");
		return dto;
	}
	
	/**
	 * ��ʷ�汾��Ϣȡ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO getHostoryVersions(IGCIM01DTO dto) throws BLException {
		log.debug("=============��ʷ�汾��Ϣȡ�ò�����ʼ=============");
		//ҳ����Ϣȡ��
		IGCIM0110Form form = dto.getIgcim0110Form();
		//��������ȡ��
		String collecttime = form.getCollecttime();
		//�ʲ�ʵ��ȡ��
//		SOC0118Info entity = dto.getEntityItem();
//		if(StringUtils.isNotEmpty(tablename)&&entity!=null&&StringUtils.isNotEmpty(entity.getEiname())){
		if(StringUtils.isNotEmpty(collecttime)&&StringUtils.isNotEmpty(form.getHost())){
			CR03SearchCondImpl cond = new CR03SearchCondImpl();
			cond.setCollecttime(collecttime);
			cond.setHost(form.getHost());
			cond.setIp(form.getIp());
			cond.setType(form.getType());
			cond.setServername(form.getServername());
			List<CR03VWInfo> list = cr03BL.getRciVersions(cond, 0, 12);
			if(list!=null&&!list.isEmpty()){
				dto.setCr03VW(list.get(0));
			}
		}
		log.debug("=============��ʷ�汾��Ϣȡ�ò�������=============");
		return dto;
	}
	
	/**
	 * ��ǰ�ɼ���Ϣȡ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO getCR01InfoList(IGCIM01DTO dto) throws BLException {
		log.debug("============��ǰ�ɼ���Ϣȡ�ò�����ʼ==============");
		IGCIM0110Form form=dto.getIgcim0110Form();
		//�汾��Ϣȡ��
		CR03VWInfo cr03 = dto.getCr03VW();
		//�豸��Ϣȡ��
//		SOC0118Info entity = dto.getEntityItem();
//		if(cr03!=null&&entity!=null&&StringUtils.isNotEmpty(entity.getEiname())){
		if(cr03!=null&&StringUtils.isNotEmpty(form.getHost())){
			CR01SearchCondImpl cond = new CR01SearchCondImpl();
			cond.setServertype(String.valueOf(cr03.getType()));
			cond.setTablename(cr03.getTablename());
			cond.setHost(form.getHost());
			cond.setIp(cr03.getIp());
			cond.setServername(cr03.getServername());
			cond.setCollecttime(cr03.getMinctime());
			List<CR01VWInfo> cr01List = cr01BL.searchCR01VWInfoList(cond, 0, 0);
			dto.setCr01List(cr01List);
		}
		log.debug("============��ǰ�ɼ���Ϣȡ�ò�������==============");
		return dto;
	}
	

	/**
	 * ��ȡ��ǰĳ�������µ����вɼ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO getCR01InfoListByCommand(IGCIM01DTO dto) throws BLException {
		log.debug("============��ǰ�ɼ���Ϣȡ�ò�����ʼ==============");
		IGCIM0112Form form=dto.getIgcim0112Form();
		//�豸��Ϣȡ��
		if(form!=null){
			CR01SearchCondImpl cond = new CR01SearchCondImpl();
			cond.setTablename(form.getTablename());
			cond.setHost(form.getHost());
			SimpleDateFormat d1 = new SimpleDateFormat("yyyyMMddHHmmss");
			SimpleDateFormat d2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			try {
				cond.setCollecttime(d1.format(d2.parse(form.getCollecttime().trim())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			cond.setCommand(form.getKeys());
			cond.setServertype(form.getType());
			cond.setIp(form.getIp());
			cond.setServername(form.getServername());
			
			//�豸��Ϣ��ѯ����ȡ�� 
			List<CR01VWInfo> cr01List = cr01BL.searchCR01VWInfoList(cond, 0, 0);
			if (cr01List == null||cr01List.size()==0) {
				log.debug("========��Ҫ��ѯ���������ݲ�����========");
				//��Ҫ��ѯ���������ݲ�����
				dto.addMessage(new ActionMessage("IGCO10000.I002",0));
				return dto;
			} 
			int totalCount=cr01List.size();
			if ( cr01List.size() > dto.getMaxSearchCount() ) {
				log.debug("========��Ҫ��ѯ���������ݹ���========");
				//��Ҫ��ѯ���������ݹ���
				dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
				return dto;
			}
			//��ҳ����Ϣȡ��
			PagingDTO pDto = dto.getPagingDto();

			//��ǰҳ�豸��Ϣȡ��
			cr01List = cr01BL.searchCR01VWInfoList(cond, pDto.getFromCount(), pDto.getPageDispCount());;
			
			pDto.setTotalCount(totalCount);
			
			dto.setCr01List(cr01List);
		}
		log.debug("============��ǰ�ɼ���Ϣȡ�ò�������==============");
		return dto;
	}
	
	/**
	 * ������ϸ�ԱȽ��
	 * @param dto
	 * @return
	 * @throws BLException
	 * @throws ParseException 
	 */
	public IGCIM01DTO getCR01InfoListByCommand2(IGCIM01DTO dto) throws BLException {
		log.debug("============��ǰ�ɼ���Ϣȡ�ò�����ʼ==============");
		IGCIM0114Form form=dto.getIgcim0114Form();
		//�豸��Ϣȡ��
		if(form!=null){
			String tablenames = form.getTablenames();
			String table1 = tablenames.split(",")[0];
			CR01SearchCondImpl cond = new CR01SearchCondImpl();
			cond.setTablename(table1.split("_sp_")[0]);
			cond.setHost(form.getHost());
			cond.setCollecttime(table1.split("_sp_")[1]);
			cond.setCommand(form.getKeys());
			cond.setServertype(form.getType());
			cond.setIp(form.getIp());
			cond.setServername(form.getServername());
			
			//�豸��Ϣ��ѯ����ȡ�� 
			List<CR01VWInfo> cr01List1 = cr01BL.searchCR01VWInfoList(cond, 0, 0);
			if (cr01List1 == null||cr01List1.size()==0) {
				log.debug("========��Ҫ��ѯ���������ݲ�����========");
				//��Ҫ��ѯ���������ݲ�����
				dto.addMessage(new ActionMessage("IGCO10000.I002",0));
				return dto;
			} 
			int totalCount1=cr01List1.size();
			if ( cr01List1.size() > dto.getMaxSearchCount() ) {
				log.debug("========��Ҫ��ѯ���������ݹ���========");
				//��Ҫ��ѯ���������ݹ���
				dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount1));
				return dto;
			}

			//��ҳ����Ϣȡ��
			PagingDTO pDto = dto.getPagingDto();
			
			//��ǰҳ�豸��Ϣȡ��
			//cr01List1 = cr01BL.searchCR01VWInfoList(cond, pDto.getFromCount(), pDto.getPageDispCount());
			
			String table2 = tablenames.split(",")[1];
			cond = new CR01SearchCondImpl();
			cond.setTablename(table2.split("_sp_")[0]);
			cond.setHost(form.getHost());
			cond.setCollecttime(table2.split("_sp_")[1]);
			cond.setCommand(form.getKeys());
			cond.setServertype(form.getType());
			cond.setIp(form.getIp());
			cond.setServername(form.getServername());
			
			//�豸��Ϣ��ѯ����ȡ�� 
			List<CR01VWInfo> cr01List2 = cr01BL.searchCR01VWInfoList(cond, 0, 0);
			if (cr01List2 == null||cr01List2.size()==0) {
				log.debug("========��Ҫ��ѯ���������ݲ�����========");
				//��Ҫ��ѯ���������ݲ�����
				dto.addMessage(new ActionMessage("IGCO10000.I002",0));
				return dto;
			} 
			int totalCount2=cr01List2.size();
			if ( cr01List2.size() > dto.getMaxSearchCount() ) {
				log.debug("========��Ҫ��ѯ���������ݹ���========");
				//��Ҫ��ѯ���������ݹ���
				dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount2));
				return dto;
			}

			//��ǰҳ�豸��Ϣȡ��
			//cr01List2 = cr01BL.searchCR01VWInfoList(cond, pDto.getFromCount(), pDto.getPageDispCount());;
			
			
			pDto.setTotalCount(totalCount1>totalCount1?totalCount1:totalCount2);
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
			try {
				Date date1 = sdf.parse(table1.split("_sp_")[1]);
				Date date2 = sdf.parse(table2.split("_sp_")[1]);
				sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				dto.setCollecttime1(sdf.format(date1));
				dto.setCollecttime2(sdf.format(date2));
			} catch (ParseException e) {
				log.error("==============����ת���쳣=============");
			}
			dto.setCr01List1(cr01List1);
			dto.setCr01List2(cr01List2);
		}
		log.debug("============��ǰ�ɼ���Ϣȡ�ò�������==============");
		return dto;
	}
	
	/**
	 * ����Դ���ݶ�汾��Ϣ��ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO compareVersionsAction(IGCIM01DTO dto) throws BLException {
		log.debug("===========����Դ���ݶ�汾��Ϣ��ѯ������ʼ=============");
		//ҳ����Ϣȡ��
		IGCIM0111Form form = dto.getIgcim0111Form();
//		//�豸��Ϣȡ��
//		SOC0118Info entity = this.soc0118BL.searchEntityItemByKey(form.getEiid());
//		dto.setEntityItem(entity);
		if(StringUtils.isNotEmpty(form.getTablenames())){
			//����ȡ��
			String[] tablenames = form.getTablenames().split(",");
//			if(entity!=null&&StringUtils.isNotEmpty(entity.getEiname())){
			if(StringUtils.isNotEmpty(form.getHost())){
				Map<String, List<CR01VWInfo>> crMap = new HashMap<String, List<CR01VWInfo>>();
				if(tablenames!=null&&tablenames.length>0){
					for(String tablename:tablenames){
						if(StringUtils.isNotEmpty(tablename)){
							CR01SearchCondImpl cond = new CR01SearchCondImpl();
//							cond.setHost(entity.getEiname());
							cond.setHost(form.getHost());
							cond.setTablename(tablename.split("_sp_")[0]);
							cond.setCollecttime(tablename.split("_sp_")[1]);
							cond.setIp(form.getIp());
							cond.setServertype(form.getType());
							cond.setServername(form.getServername());
							List<CR01VWInfo> cr01List = cr01BL.searchCR01VWInfoList(cond, 0, 0);
							crMap.put(getShowtime(tablename.split("_sp_")[1]), cr01List);
						}
					}
				}
				dto.setCompareVersionsMap(crMap);
			}
			
		}
		log.debug("===========����Դ���ݶ�汾��Ϣ��ѯ��������=============");
		return dto;
	}
	public String getShowtime(String collecttime) {
		String showtime ="";
		if(StringUtils.isNotEmpty(collecttime)){
			try{
				SimpleDateFormat d1 = new SimpleDateFormat("yyyyMMddHHmmss");
				SimpleDateFormat d2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				showtime = d2.format(d1.parse(collecttime));
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return showtime;
	}	/**
	 * �豸��ϵ��������ڻ�����(��ʾȫ��������EIΪ��)
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO initIGAIM0146Action(IGCIM01DTO dto) throws BLException {
		log.debug("========���ð�����ϵ��ʾ����ʼ========");
		
		IGCIM0146Form form = dto.getIgcim0146Form();
		//��ѯ���������ʲ��������ӽڵ�
		SOC0127SearchCondImpl cond = new SOC0127SearchCondImpl();
		cond.setEirootmark(Integer.parseInt(form.getEirootmark()));
		cond.setBrparversion(Integer.parseInt(form.getEiversion()));
		cond.setBrcldversion(cond.getBrparversion());
		List<SOC0127Info> eibrList = this.soc0110BL.searchEiBelongRelationVW2(cond);
		//��ѯ����EI
		SOC0123Info rootEi = this.soc0118BL.searchEntityItemEntityVWByKey(Integer.parseInt(form.getEirootmark()));
		//����ѡ���ʲ���汾��ѯ����EI�����С�汾
		Integer rootEiMaxSmallveision = this.soc0107BL.searchEiMaxSmallVersion(rootEi.getEiid(), Integer.parseInt(form.getEiversion()));
		//����������
		Map<String,TreeNode> treeNodeMap = new LinkedHashMap<String,TreeNode>();
		//�����	
		TreeNode rootNode = new TreeNode();
		rootNode.setId(rootEi.getEiid() + "_" + rootEi.getEiversion() + "_" + rootEiMaxSmallveision);//�ʲ�ID|��汾|С�汾
		rootNode.setName(rootEi.getEiname() + "(" + form.getEiversion() + "." + rootEiMaxSmallveision + ")");//�ʲ�����
		
		//�ݹ鹹�������ϵ��
		searchConfigurationTreeNode2(eibrList, rootEi, rootNode);
		if(rootEi.getEsyscoding().startsWith(EiRelationKeyWords.STORAGE)){
			searchTreeNodeForStorage2(eibrList, rootEi, rootNode);
		}
		//�����ڵ�
		treeNodeMap.put(rootNode.getId(),rootNode);
		dto.setTreeNodeMap(treeNodeMap);
		
		log.debug("========���ð�����ϵ��ʾ��������========");
		return dto;
	}
	
	/**
	 * �ݹ鹹�����ð���������
	 *
	 * @param eibrList �ڵ㼯��
	 * @param ei �����ʲ��ڵ�
	 * @param parNode �����ڵ�
	 */
	public void searchConfigurationTreeNode2(List<SOC0127Info> eibrList,
			SOC0123Info ei, TreeNode parNode) throws BLException {
		
		//�����ڵ㼯��
		for(SOC0127Info eibr : eibrList) {
			if(ei.getEiid().equals(eibr.getBrpareiid())) {//ƥ��ID
				//�����ӽڵ�
				TreeNode cldNode = new TreeNode();
				cldNode.setId(eibr.getBrcldeiid() + "_" + eibr.getBrcldversion() + "_" + eibr.getBrcldsmallversion());//�ʲ�ID|��汾|С�汾
				cldNode.setName(eibr.getCldEntityItemVW().getEiname() + "(" + eibr.getBrcldversion() + "." + eibr.getBrcldsmallversion() + ")");//�ʲ�����
				//���ģ�ͽڵ�
				String cldEsyscoding = eibr.getCldEntityItemVW().getEsyscoding();
				if(cldEsyscoding.startsWith(EiRelationKeyWords.SWITCH)){
					continue;
				}
				String parEsyscoding = ei.getEsyscoding();
				if(EiRelationKeyWords.SANPORT.equals(parEsyscoding)){
					continue;
				}
				LinkedHashMap<String, TreeNode> childTreeNodeMap = parNode.getChildTreeNodeMap();
				TreeNode treeNode = childTreeNodeMap.get(cldEsyscoding);
				SOC0117Info entity = soc0117BL.searchEntityByKey(eibr.getCldEntityItemVW().getEid());
				//�豸���ģ�������ӽڵ㣬ģ�����ƽڵ����ģ���ӽڵ�
				if(treeNode==null){
					if(parEsyscoding.startsWith(EiRelationKeyWords.HOST)
							||parEsyscoding.startsWith(EiRelationKeyWords.SWITCH)
							||parEsyscoding.startsWith(EiRelationKeyWords.STORAGE)){
						treeNode=new TreeNode();
						treeNode.setId(entity.getEsyscoding());
						treeNode.setName(entity.getEname());
						parNode.addChildTreeNode(treeNode.getId(), treeNode);
						treeNode.addChildTreeNode(cldNode.getId(),cldNode);
					}else{
						parNode.addChildTreeNode(cldNode.getId(),cldNode);
					}
				}else{
					treeNode.addChildTreeNode(cldNode.getId(),cldNode);
				}
					
				//�ݹ�
				searchConfigurationTreeNode2(eibrList, eibr.getCldEntityItemVW(), cldNode);
			}
		}
		
	}
	/**
	 * �洢�������faport-fa fa-storage
	 *
	 * @param eibrList �ڵ㼯��
	 * @param ei �����ʲ��ڵ�
	 * @param parNode �����ڵ�
	 */
	public void searchTreeNodeForStorage2(List<SOC0127Info> eibrList,
			SOC0123Info ei, TreeNode parNode) throws BLException {
		
		//�����ڵ㼯��
		for(SOC0127Info eibr : eibrList) {
			if(ei.getEiid().equals(eibr.getBrcldeiid())) {//ƥ��ID
				//�����ӽڵ�
				TreeNode cldNode = new TreeNode();
				cldNode.setId(eibr.getBrpareiid() + "_" + eibr.getBrparversion() + "_" + eibr.getBrparsmallversion());//�ʲ�ID|��汾|С�汾
				cldNode.setName(eibr.getParEntityItemVW().getEiname() + "(" + eibr.getBrparversion() + "." + eibr.getBrparsmallversion() + ")");//�ʲ�����
				String parEsyscoding = eibr.getParEntityItemVW().getEsyscoding();
				LinkedHashMap<String, TreeNode> childTreeNodeMap = parNode.getChildTreeNodeMap();
				TreeNode treeNode = childTreeNodeMap.get(parEsyscoding);
				SOC0117Info entity = soc0117BL.searchEntityByKey(eibr.getParEntityItemVW().getEid());
				String cldEsyscoding = ei.getEsyscoding();
				
				if(treeNode==null){
//					if(EiRelationKeyWords.FA.equals(esyscoding)){
//						treeNode=new TreeNode();
//						treeNode.setId(EiRelationKeyWords.FA);
//						treeNode.setName("FA");
//						parNode.addChildTreeNode(treeNode.getId(), treeNode);
//						treeNode.addChildTreeNode(cldNode.getId(),cldNode);
//					}else{
//						parNode.addChildTreeNode(cldNode.getId(),cldNode);
//					}
					if(cldEsyscoding.startsWith(EiRelationKeyWords.STORAGE)){
						treeNode=new TreeNode();
						treeNode.setId(entity.getEsyscoding());
						treeNode.setName(entity.getEname());
						parNode.addChildTreeNode(treeNode.getId(), treeNode);
						treeNode.addChildTreeNode(cldNode.getId(),cldNode);
					}else{
						parNode.addChildTreeNode(cldNode.getId(),cldNode);
					}
				}else{
					treeNode.addChildTreeNode(cldNode.getId(),cldNode);
				}
				//����ӽڵ�
//				if(treeNode!=null){
//					treeNode.addChildTreeNode(cldNode.getId(),cldNode);
//				}else{
//					parNode.addChildTreeNode(cldNode.getId(),cldNode);
//				}
				//�ݹ�
				searchTreeNodeForStorage2(eibrList, eibr.getParEntityItemVW(), cldNode);
			}
		}
	}


	public IGCIM01DTO initIGASM0317Action(IGCIM01DTO dto) throws BLException {
		return null;
	}
	/**
	 * ������
	 *
	 * @param eibrList �ڵ㼯��
	 * @param ei �����ʲ��ڵ�
	 * @param parNode �����ڵ�
	 */
	public IGCIM01DTO getContainTree(IGCIM01DTO dto) throws BLException {
		IGCIM0146Form form=dto.getIgcim0146Form();
		Map<Integer,List<RelationTreeTB>> treeMap=new LinkedHashMap<Integer, List<RelationTreeTB>>();
		int levelNum=100;
		String jsonStr=null;
		Integer eiid=Integer.parseInt(form.getEiid());
		Integer eirootmark=Integer.parseInt(form.getEirootmark());
		Integer eiversion=Integer.parseInt(form.getEiversion());
		Integer eismallversion=Integer.parseInt(form.getEismallversion());
		//���ϲ�ѯ
		treeMap=searchUpTreeNode(eiid,eiversion,eismallversion,eirootmark,levelNum,treeMap);
		//���²�ѯ
		treeMap=searchDownTreeNodeByEiid(eiid,eiversion,eismallversion,eirootmark,levelNum,treeMap);
		//Ȼ����treeMap
		jsonStr=initChangeJsonObject(treeMap,levelNum);
		//���ó�ʼ�����
		String initNodeId=getInitNodeId(treeMap,levelNum);
		dto.setInitTreeStr(jsonStr);
		dto.setInitNodeID(initNodeId);
		return dto;
	}
	/**
	 * ������
	 *
	 * @param eibrList �ڵ㼯��
	 * @param ei �����ʲ��ڵ�
	 * @param parNode �����ڵ�
	 */
	public IGCIM01DTO getContainTree0149Action(IGCIM01DTO dto) throws BLException {
		IGCIM0149Form form=dto.getIgcim0149Form();
		Map<Integer,List<RelationTreeTB>> treeMap=new LinkedHashMap<Integer, List<RelationTreeTB>>();
		int levelNum=100;
		String jsonStr=null;
		Integer eiid=Integer.parseInt(form.getEiid());
		Integer eirootmark=Integer.parseInt(form.getEirootmark());
		Integer eiversion=Integer.parseInt(form.getEiversion());
		Integer eismallversion=Integer.parseInt(form.getEismallversion());
		//���ϲ�ѯ
		treeMap=searchUpTreeNode(eiid,eiversion,eismallversion,eirootmark,levelNum,treeMap);
		//���²�ѯ
		treeMap=searchDownTreeNodeByEiid(eiid,eiversion,eismallversion,eirootmark,levelNum,treeMap);
		//Ȼ����treeMap
		jsonStr=initChangeJsonObject(treeMap,levelNum);
		//���ó�ʼ�����
		String initNodeId=getInitNodeId(treeMap,levelNum);
		dto.setInitTreeStr(jsonStr);
		dto.setInitNodeID(initNodeId);
		return dto;
	}


	

	/**
	 * ����ȡ��ʼ��Ĭ��IDֵ
	 * @param Integer levelNum  ��㼶���
	 * @param Map<Integer,List<RelationTreeTB>> treeMap  ��Ž��map
	 */
	public String getInitNodeId(Map<Integer,List<RelationTreeTB>> treeMap, Integer levelNum){
		List<RelationTreeTB> rtList=treeMap.get(levelNum-1);
		if(rtList!=null&&rtList.size()>0){
			RelationTreeTB tb=rtList.get(0);
			String objId="1_"+tb.getEiid()+"_"+tb.getEirootmark()+"_"+tb.getEiversion()+"_"+tb.getEismallversion()+"_"+(levelNum-1)+"_"+tb.getFatherEiid();
			return objId;
		}else{
			return "";
		}
	}
	
	/**
	 * ��treeMapת��Ϊjson����Ȼ�󴫸��ַ���
	 * @param Integer levelNum  ��㼶���
	 * @param Map<Integer,List<RelationTreeTB>> treeMap  ��Ž��map
	 */
	public String initChangeJsonObject(Map<Integer,List<RelationTreeTB>> treeMap, Integer levelNum){
		//��Ҫ���ص��ַ���
		String returnStr="";
		if(treeMap!=null&&treeMap.size()>0){
			//1.���Ƚ�map��key����
			Integer[] keyArr=new Integer[treeMap.size()];
			treeMap.keySet().toArray(keyArr);
			//����
			Arrays.sort(keyArr);
			//2.��valueֵתΪ����
			//��������
			JSONArray jsonArr=new JSONArray();
			String lastId="0";
			Map<String, String> itemImageMap = this.getItemImagesInfoByCodeDetail();
			for (Integer key : keyArr) {
				//��ȡ����ֵ
				List<RelationTreeTB> rtList=treeMap.get(key);
				//�ж��Ƿ��Ͻ��
				//id:1, pId:0, name:"����", open:true, iconSkin:"pIcon01"
				//ID����, ģ�� ��������   0_eidֵ_eirootmarkֵ_eiversionֵ_eismallversionֵ_LevelNum_����eiid_��ϵ��ֵ
				//        ������������    1_eiidֵ_eirootmarkֵ_eiversionֵ_eismallversionֵ_LevelNum_����eiid
				try{
				if(key<levelNum){
					for (RelationTreeTB tb : rtList) {
						String imagekey = tb.getEid();
						JSONObject objType=new JSONObject();
						String typeId="0_"+tb.getEid()+"_"+tb.getEirootmark()+"_"+tb.getEiversion()+"_"+tb.getEismallversion()+"_"+key+"_"+tb.getFatherEiid()+"_0_"+tb.getSourceEiid();
						objType.put(IGCIMConstants.TREE_PARAMETER_ID, typeId);
						objType.put(IGCIMConstants.TREE_PARAMETER_PID, lastId);
						objType.put(IGCIMConstants.TREE_PARAMETER_NAME, tb.getEname());
						objType.put(IGCIMConstants.TREE_PARAMETER_OPEN, IGCIMConstants.TREE_PARAMETER_OPEN_VALUE_TRUE);
//						objType.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN, IGCIMConstants.TREE_PARAMETER_ICONSKIN_FATHERICON);
						objType = this.getItemImageByName(objType, itemImageMap, imagekey, tb.getIsLeaf(), true, tb.getEid());
						jsonArr.put(objType);
						lastId=typeId;
						
						JSONObject obj=new JSONObject();
						String objId="1_"+tb.getEiid()+"_"+tb.getEirootmark()+"_"+tb.getEiversion()+"_"+tb.getEismallversion()+"_"+key+"_"+tb.getFatherEiid()+"_"+tb.getSourceEiid();
						obj.put(IGCIMConstants.TREE_PARAMETER_ID, objId);
						obj.put(IGCIMConstants.TREE_PARAMETER_PID, lastId);
						obj.put(IGCIMConstants.TREE_PARAMETER_NAME, tb.getEiname());
						//���Ǹ��ڵ����Ҷ�ӽڵ�
						if(IGCIMConstants.TREE_PARAMETER_ISLEAF_VALUE_TRUE.equals(tb.getIsLeaf())){
							obj.put(IGCIMConstants.TREE_PARAMETER_OPEN, IGCIMConstants.TREE_PARAMETER_OPEN_VALUE_TRUE);
						}else{
						}
						objType = this.getItemImageByName(obj, itemImageMap, imagekey, tb.getIsLeaf(), false, tb.getEid());
						jsonArr.put(obj);
						lastId=objId;
					}
				}else{
					for (RelationTreeTB tb : rtList) {
						String imagekey = tb.getEid();
						boolean isModule = false;
						JSONObject objType=new JSONObject();
						String typeId="";
						String name="";
						if(tb.getRlnCode()!=null&&!"".equals(tb.getRlnCode())){
							typeId="0_"+tb.getEid()+"_"+tb.getEirootmark()+"_"+tb.getEiversion()+"_"+tb.getEismallversion()+"_"+key+"_"+tb.getFatherEiid()+"_"+tb.getRlnCode()+"_"+tb.getSourceEiid();
							name=tb.getEname();
							isModule = true;
						}else{
							typeId="1_"+tb.getEiid()+"_"+tb.getEirootmark()+"_"+tb.getEiversion()+"_"+tb.getEismallversion()+"_"+key+"_"+tb.getFatherEiid()+"_"+tb.getSourceEiid();
							name=tb.getEiname();
						}
						objType.put(IGCIMConstants.TREE_PARAMETER_ID, typeId);
						objType.put(IGCIMConstants.TREE_PARAMETER_PID, lastId);
						objType.put(IGCIMConstants.TREE_PARAMETER_NAME, name);
						objType.put(IGCIMConstants.TREE_PARAMETER_OPEN, IGCIMConstants.TREE_PARAMETER_OPEN_VALUE_FALSE);
						//���Ǹ��ڵ����Ҷ�ӽڵ�
						if(IGCIMConstants.TREE_PARAMETER_ISLEAF_VALUE_TRUE.equals(tb.getIsLeaf())){
							objType.put("isParent", false);
							objType = this.getItemImageByName(objType, itemImageMap, imagekey, tb.getIsLeaf(), isModule, tb.getEid());
//							objType.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN, IGCIMConstants.TREE_PARAMETER_ICONSKIN_LEAFICON);
						}else{
							objType.put("isParent", true);
							objType = this.getItemImageByName(objType, itemImageMap, imagekey, tb.getIsLeaf(), isModule, tb.getEid());
//							objType.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN, IGCIMConstants.TREE_PARAMETER_ICONSKIN_FATHERICON);
						}
						jsonArr.put(objType);
					}
				}
				}catch (JSONException e) {
					log.debug("=====JSON����====="+e);
				}
			}
			returnStr=jsonArr.toString();
		}
		return returnStr;
	}
	
	
	/**
	 * ���ݽ�����ϲ�ѯ
	 * @param Integer eiid  ��Ҫ��ѯ�Ķ���eiid
	 * @param Integer eiversion  ����汾
	 * @param Integer eismallversion  ����С�汾
	 * @param Integer eirootmark  ���󶥼�eiid
	 * @param Integer levelNum  ��㼶���
	 * @param Map<Integer,List<RelationTreeTB>> treeMap  ��Ž��map
	 */
	public Map<Integer,List<RelationTreeTB>> searchUpTreeNode(Integer eiid,Integer eiversion,Integer eismallversion,Integer eirootmark,
			Integer levelNum,Map<Integer,List<RelationTreeTB>> treeMap)throws BLException{
		//�ж��Ƿ��Ƕ���CI�豸
		//��ѯ��ģ�Ͷ���
		SOC0118Info soc0118Info=soc0118BL.searchEntityItemByKey(eiid);
		SOC0117Info soc0117Info=soc0117BL.searchEntityByKey(soc0118Info.getEid());
		RelationTreeTB tb=null;
		if(eiid.compareTo(eirootmark)==0){
			//���ɽ�����
			
			List<RelationTreeTB> rtlist=new ArrayList<RelationTreeTB>();
			
			//��ѯ�����Ƿ���ֵ
			SOC0110SearchCondImpl cond0110=new SOC0110SearchCondImpl();
			cond0110.setBrpareiid(eiid+"");
			cond0110.setBrparversion(eiversion+"");
			cond0110.setBrparsmallversion(eismallversion+"");
			//���й�ϵ��
			List<String> codeList=soc0110BL.searchBrassetrelationByBrpareiid(cond0110);
			if(codeList!=null&&codeList.size()>0){
				tb=new RelationTreeTB(eiid,soc0118Info.getEiname(),eirootmark,soc0117Info.getEname(),soc0117Info.getEid()+"",
						eiversion,eismallversion,eiid,IGCIMConstants.TREE_PARAMETER_ISLEAF_VALUE_TRUE,eirootmark);
			}else{
				tb=new RelationTreeTB(eiid,soc0118Info.getEiname(),eirootmark,soc0117Info.getEname(),soc0117Info.getEid()+"",
						eiversion,eismallversion,eiid,IGCIMConstants.TREE_PARAMETER_ISLEAF_VALUE_FALSE,eirootmark);
			}
			rtlist.add(tb);
			//��map�з������
			treeMap.put(levelNum-1, rtlist);
			
		}else{
			//������ǣ���ѯ���ø��׽��
			//���ɽ�����
			List<RelationTreeTB> rtlist=new ArrayList<RelationTreeTB>();
			//��ѯ��ǰ����ĸ�������
			SOC0110SearchCondImpl cond0110=new SOC0110SearchCondImpl();
			cond0110.setBrcldeiid(eiid+"");
			cond0110.setBrcldversion(eiversion+"");
			cond0110.setBrcldsmallversion(eismallversion+"");
			cond0110.setBrassetrelation_not("CR020001000001");
			List<SOC0110Info> soc0110InfoList=soc0110BL.searchEiBelongRelation(cond0110);
			
			//��ѯ�����Ƿ���ֵ
			cond0110=new SOC0110SearchCondImpl();
			cond0110.setBrpareiid(eiid+"");
			cond0110.setBrparversion(eiversion+"");
			cond0110.setBrparsmallversion(eismallversion+"");
			//���й�ϵ��
			List<String> codeList=soc0110BL.searchBrassetrelationByBrpareiid(cond0110);
			
			//�жϲ�ѯ��֮�й�ϵ�ĸ�������Ϊ0
			if(soc0110InfoList!=null&&soc0110InfoList.size()>0){
				SOC0110Info soc0110Info=soc0110InfoList.get(0);
					//���ӽڵ�
					if(codeList!=null&&codeList.size()>0&&!"CM02060001".equals(soc0110Info.getCldEntityItemVW().getEid())){
						tb=new RelationTreeTB(eiid,soc0118Info.getEiname(),eirootmark,soc0117Info.getEname(),soc0117Info.getEid()+"",
								eiversion,eismallversion,soc0110Info.getBrpareiid(),IGCIMConstants.TREE_PARAMETER_ISLEAF_VALUE_TRUE,eirootmark);
					} 
					//���ӽڵ�
					else {
						tb=new RelationTreeTB(eiid,soc0118Info.getEiname(),eirootmark,soc0117Info.getEname(),soc0117Info.getEid()+"",
								eiversion,eismallversion,soc0110Info.getBrpareiid(),IGCIMConstants.TREE_PARAMETER_ISLEAF_VALUE_FALSE,eirootmark);
					}
					rtlist.add(tb);
					//��map�з������
					treeMap.put(levelNum-1, rtlist);
					//������ѯ�ϼ����
					treeMap=searchUpTreeNode(soc0110Info.getBrpareiid(),soc0110Info.getBrparversion(),soc0110Info.getBrcldsmallversion(),eirootmark,
							levelNum-1,treeMap);
			}else{
				//���ӽڵ�
				if(codeList!=null&&codeList.size()>0){
					tb=new RelationTreeTB(eiid,soc0118Info.getEiname(),eirootmark,soc0117Info.getEname(),soc0117Info.getEid()+"",
							eiversion,eismallversion,eiid,IGCIMConstants.TREE_PARAMETER_ISLEAF_VALUE_FALSE,eirootmark);
				} 
				//���ӽڵ�
				else {
					tb=new RelationTreeTB(eiid,soc0118Info.getEiname(),eirootmark,soc0117Info.getEname(),soc0117Info.getEid()+"",
							eiversion,eismallversion,eiid,IGCIMConstants.TREE_PARAMETER_ISLEAF_VALUE_TRUE,eirootmark);
				}
				rtlist.add(tb);
				//��map�з������
				treeMap.put(levelNum-1, rtlist);
			}
		}
		return treeMap;
	}
	/**
	 * ���ݽ�����²�ѯ�����н��
	 * @param Integer eiid  ��Ҫ��ѯ�Ķ���eiid
	 * @param Integer eiversion  ����汾
	 * @param Integer eismallversion  ����С�汾
	 * @param Integer eirootmark  ���󶥼�eiid
	 * @param Integer levelNum  ��㼶���
	 * @param Map<Integer,List<RelationTreeTB>> treeMap  ��Ž��map
	 */
	public Map<Integer,List<RelationTreeTB>> searchDownTreeNodeByEiid(Integer eiid,Integer eiversion,Integer eismallversion,Integer eirootmark,
			Integer levelNum,Map<Integer,List<RelationTreeTB>> treeMap)throws BLException{
		//��ѯ�Ƿ��а����Ĺ�ϵ�Ӷ�������в�����й�ϵ��
		SOC0110SearchCondImpl cond0110=new SOC0110SearchCondImpl();
		cond0110.setBrpareiid(eiid+"");
		cond0110.setBrparversion(eiversion+"");
		cond0110.setBrparsmallversion(eismallversion+"");
		cond0110.setEirootmark(eirootmark+"");
		//���й�ϵ
		List<SOC0110Info> soc0110List=soc0110BL.searchMaxEiBelongRelation(cond0110);
		if(soc0110List!=null&&soc0110List.size()>0){
			//����ϵģ�ͷ�������
			List<RelationTreeTB> rtlist=new ArrayList<RelationTreeTB>();
			List<String>  formEiid_toEiid=new ArrayList<String>();
			for(SOC0110Info soc0110:soc0110List){
				//���ݹ�ϵ���ѯ��ϵ��ϸ��Ϣ
				SOC0152SearchCondImpl cond0152=new SOC0152SearchCondImpl();
				//������ϵ��
				cond0152.setRlnType_eq(IGCIMConstants.TYPE_CODE_CONTAIN_RELATION);
				if("CM01010020".equals(soc0110.getParEntityItemVW().getEid())||
						"CM01010022".equals(soc0110.getParEntityItemVW().getEid())||
						"CM01010031".equals(soc0110.getParEntityItemVW().getEid())||
						"CM01010039".equals(soc0110.getParEntityItemVW().getEid())||
						"CM01010034".equals(soc0110.getParEntityItemVW().getEid())||
						"CM01010043".equals(soc0110.getParEntityItemVW().getEid())){
					cond0152.setFromModelEid_eq("CM01010001");
				}else{
					cond0152.setFromModelEid_eq(soc0110.getParEntityItemVW().getEid());
				}
				cond0152.setToModelEid_eq(soc0110.getCldEntityItemVW().getEid());
				String eiids=cond0152.getFromModelEid_eq()+"_"+cond0152.getToModelEid_eq();
				if(!formEiid_toEiid.contains(eiids)){
					formEiid_toEiid.add(eiids);
				}else{
					continue;
				}
				List<SOC0152Info> soc0152InfoList=soc0152BL.searchSOC0152(cond0152);
				if(soc0152InfoList!=null&soc0152InfoList.size()>0){
					for (SOC0152Info info : soc0152InfoList) {
						RelationTreeTB tb=new RelationTreeTB();
						tb.setEid(info.getToModelEid());
						tb.setEname(info.getToModelName());
						tb.setRlnCode(info.getRlnCode());
						tb.setFatherEiid(eiid);
						tb.setEiversion(eiversion);
						tb.setEismallversion(eismallversion);
						tb.setEirootmark(eirootmark);
						tb.setIsLeaf("false");
						tb.setSourceEiid(eirootmark);
						rtlist.add(tb);
					}
				}
			}
			//����map��
			treeMap.put(levelNum+1, rtlist);
		}
		return treeMap;
	}
	/**
	 * ���ݽ�����²�ѯ�����н��
	 * @param Integer eiid  ��Ҫ��ѯ�Ķ���eiid
	 * @param Integer eiversion  ����汾
	 * @param Integer eismallversion  ����С�汾
	 * @param Integer eirootmark  ���󶥼�eiid
	 * @param Integer levelNum  ��㼶���
	 * @param Map<Integer,List<RelationTreeTB>> treeMap  ��Ž��map
	 */
	public Map<Integer,List<RelationTreeTB>> searchDownTreeNodeByEid(String rlnCode,Integer fathereiid,Integer eiversion,Integer eismallversion,Integer eirootmark,
			Integer levelNum,Map<Integer,List<RelationTreeTB>> treeMap)throws BLException{
		//��ѯ�Ƿ��а����Ĺ�ϵ�Ӷ�������в�����й�ϵ��
		SOC0110SearchCondImpl cond0110=new SOC0110SearchCondImpl();
		cond0110.setBrpareiid(fathereiid+"");
		cond0110.setBrparversion(eiversion+"");
		cond0110.setBrparsmallversion(eismallversion+"");
		cond0110.setBrassetrelation(rlnCode);
		//�����ӽ��
		List<SOC0110Info> soc0110infoList=soc0110BL.searchEiBelongRelation(cond0110);
		if(soc0110infoList!=null&&soc0110infoList.size()>0){
			//����ϵģ�ͷ�������
			
			//���Ȳ�ѯ�Ƿ����ӽڵ�
			SOC0110Info fristInfo=soc0110infoList.get(0);
			SOC0123VW fristSoc0123vw=fristInfo.getCldEntityItemVW();
			//��ѯ��ϵ��
			SOC0152SearchCondImpl frist0152Cond=new SOC0152SearchCondImpl();
			//������ϵ��
			frist0152Cond.setRlnType_eq(IGCIMConstants.TYPE_CODE_CONTAIN_RELATION);
			frist0152Cond.setFromModelEid_eq(fristSoc0123vw.getEid()+"");
			//��ѯ�����
			List<SOC0152Info> soc0152List=soc0152BL.searchSOC0152(frist0152Cond);
			//Map �ж��Ƿ����ӽڵ��map
			Map<Integer, List<SOC0110Info>> isLeafMap=new HashMap<Integer, List<SOC0110Info>>();
		
			//�����ѯ���������ô��ģ���»����ڶ���
			if(soc0152List!=null&&soc0152List.size()>0){
				StringBuilder sb=new StringBuilder();
				for (int i = 0; i < soc0152List.size(); i++) {
					String code=soc0152List.get(i).getRlnCode();
					if(i==(soc0152List.size()-1)){
						sb.append("'"+code+"'");
					}else{
						sb.append("'"+code+"'"+",");
					}
				}
				//��ѯ���������Ƿ��ж���
				SOC0110SearchCondImpl soc0110Cond=new SOC0110SearchCondImpl();
				soc0110Cond.setEirootmark(eirootmark+"");
				soc0110Cond.setBrparversion(eiversion+"");
				soc0110Cond.setBrparsmallversion(eismallversion+"");
				soc0110Cond.setBrassetrelation_in(sb.toString());
				List<SOC0110Info> listtmp=soc0110BL.searchInBrassetrelationByEirootmark(soc0110Cond);
				if(listtmp!=null&&listtmp.size()>0){
					for (SOC0110Info info : listtmp) {
						Integer brpareiid=info.getBrpareiid();
						List<SOC0110Info> tmpList=isLeafMap.get(brpareiid);
						if(tmpList==null){
							tmpList=new ArrayList<SOC0110Info>();
						}
						tmpList.add(info);
						isLeafMap.put(brpareiid,tmpList);
					}
				}
			}
			List<RelationTreeTB> rtlist=new ArrayList<RelationTreeTB>();
			for (SOC0110Info info : soc0110infoList) {
				SOC0123VW soc0123vw=info.getCldEntityItemVW();
				RelationTreeTB tb=new RelationTreeTB();
				tb.setEiid(soc0123vw.getEiid());
				tb.setEiname(soc0123vw.getEiname());
				tb.setEirootmark(eirootmark);
				tb.setEid(soc0123vw.getEid()+"");
				tb.setFatherEiid(fathereiid);
				tb.setEiversion(eiversion);
				tb.setEismallversion(eismallversion);
				if(isLeafMap.containsKey(tb.getEiid())){
					tb.setIsLeaf("true");
				}else{
					tb.setIsLeaf("false");
				}
				rtlist.add(tb);
			}
			//����map��
			treeMap.put(levelNum+1, rtlist);
		}
		return treeMap;
	}


	public IGCIM01DTO searchIGCIM0135Action(IGCIM01DTO dto) throws BLException {
		IGCIM0135Form form=dto.getIgcim0135Form();
		int num=1;
		StringBuffer pareiids=new StringBuffer();
		StringBuffer cldeiids=new StringBuffer();
		SOC0118SearchCondImpl soc0118cond=new SOC0118SearchCondImpl();
		List<SOC0118Info> soc0118InfoList=null;
		boolean flag=false;
		if(StringUtils.isNotEmpty(form.getEiname())){
			soc0118cond.setEiname(form.getEiname());
			soc0118cond.setEiorgsyscoding(form.getEiorgsyscoding());
			soc0118cond.setEsyscoding_eq("999010");
			soc0118InfoList=this.soc0118BL.searchEntityItem(soc0118cond);
			if(soc0118InfoList!=null&&soc0118InfoList.size()>0){
				for(SOC0118Info soc0118Info:soc0118InfoList){
					if(soc0118InfoList.size()==num){
						cldeiids.append(soc0118Info.getEiid());
					}else{
						cldeiids.append(soc0118Info.getEiid()).append(",");
					}
					num++;
				}
			}
			flag=true;
		}
		
		if(StringUtils.isNotEmpty(form.getBusinessName())){
			num=1;
			soc0118cond.setEiname(form.getBusinessName());
			soc0118cond.setEiorgsyscoding(form.getEiorgsyscoding());
			soc0118cond.setEsyscoding_eq("999003001");
			soc0118InfoList=this.soc0118BL.searchEntityItem(soc0118cond);
			if(soc0118InfoList!=null&&soc0118InfoList.size()>0){
				for(SOC0118Info soc0118Info:soc0118InfoList){
					if(soc0118InfoList.size()==num){
						pareiids.append(soc0118Info.getEiid());
					}else{
						pareiids.append(soc0118Info.getEiid()).append(",");
					}
					num++;
				}
			}
			flag=true;
		}
		
		SOC0119SearchCondImpl soc0119Cond=new SOC0119SearchCondImpl();
		soc0119Cond.setPareiids(pareiids.toString());
		soc0119Cond.setCldeiids(cldeiids.toString());
		soc0119Cond.setEirrelation("23");
		soc0119Cond.setFlag(flag);
		
		List<SOC0119Info> soc0119List = this.soc0119BL.searchMaxEntityItemRelation(soc0119Cond, 0, 0);
		if (soc0119List == null||soc0119List.size()==0) {
			log.debug("========��Ҫ��ѯ���������ݲ�����========");
			//��Ҫ��ѯ���������ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		int totalCount=soc0119List.size();
		if ( soc0119List.size() > dto.getMaxSearchCount() ) {
			log.debug("========��Ҫ��ѯ���������ݹ���========");
			//��Ҫ��ѯ���������ݹ���
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		List<SOC0119Info> soc0119InfoList=this.soc0119BL.searchMaxEntityItemRelation(soc0119Cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setSoc0119InfoList(soc0119InfoList);
		return dto;
	}

	public IGCIM01DTO searchIGCIM0139Action(IGCIM01DTO dto) throws BLException {
		IGCIM0139Form form=dto.getIgcim0139Form();
		int num=1;
		StringBuffer pareiids=new StringBuffer();
		StringBuffer cldeiids=new StringBuffer();
		SOC0118SearchCondImpl soc0118cond=new SOC0118SearchCondImpl();
		List<SOC0118Info> soc0118InfoList=null;
		boolean flag=false;
		if(StringUtils.isNotEmpty(form.getEiname())){
			soc0118cond.setEiname(form.getEiname());
			soc0118cond.setEiorgsyscoding(form.getEiorgsyscoding());
			soc0118cond.setEsyscoding_eq("999010");
			soc0118InfoList=this.soc0118BL.searchEntityItem(soc0118cond);
			if(soc0118InfoList!=null&&soc0118InfoList.size()>0){
				for(SOC0118Info soc0118Info:soc0118InfoList){
					if(soc0118InfoList.size()==num){
						cldeiids.append(soc0118Info.getEiid());
					}else{
						cldeiids.append(soc0118Info.getEiid()).append(",");
					}
					num++;
				}
			}
			flag=true;
		}
		
		if(StringUtils.isNotEmpty(form.getBusinessName())){
			num=1;
			soc0118cond.setEiname(form.getBusinessName());
			soc0118cond.setEiorgsyscoding(form.getEiorgsyscoding());
			soc0118cond.setEsyscoding_eq("999003001");
			soc0118InfoList=this.soc0118BL.searchEntityItem(soc0118cond);
			if(soc0118InfoList!=null&&soc0118InfoList.size()>0){
				for(SOC0118Info soc0118Info:soc0118InfoList){
					if(soc0118InfoList.size()==num){
						pareiids.append(soc0118Info.getEiid());
					}else{
						pareiids.append(soc0118Info.getEiid()).append(",");
					}
					num++;
				}
			}
			flag=true;
		}
		
		SOC0119SearchCondImpl soc0119Cond=new SOC0119SearchCondImpl();
		soc0119Cond.setPareiids(pareiids.toString());
		soc0119Cond.setCldeiids(cldeiids.toString());
		soc0119Cond.setEirrelation("23");
		soc0119Cond.setFlag(flag);
		
		List<SOC0119Info> soc0119List = this.soc0119BL.searchMaxEntityItemRelation(soc0119Cond, 0, 0);
		if (soc0119List == null||soc0119List.size()==0) {
			log.debug("========��Ҫ��ѯ���������ݲ�����========");
			//��Ҫ��ѯ���������ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		int totalCount=soc0119List.size();
		if ( soc0119List.size() > dto.getMaxSearchCount() ) {
			log.debug("========��Ҫ��ѯ���������ݹ���========");
			//��Ҫ��ѯ���������ݹ���
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		List<SOC0119Info> soc0119InfoList=this.soc0119BL.searchMaxEntityItemRelation(soc0119Cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setSoc0119InfoList(soc0119InfoList);
		return dto;
	}
	

	public IGCIM01DTO searchIGCIM0136Action(IGCIM01DTO dto) throws BLException {
		IGCIM0136Form form=dto.getIgcim0136Form();
		SOC0118SearchCondImpl soc0118Cond=new SOC0118SearchCondImpl();
		soc0118Cond.setTableName(form.getTableName());
		soc0118Cond.setTableSpaceName(form.getTableSpaceName());
		soc0118Cond.setInstanceName(form.getInstanceName());
		soc0118Cond.setBusinessName(form.getBusinessName());
		List<TableSpaceInfo> tableSpaceInfoCount=this.soc0118BL.searchTableRelationInfo(soc0118Cond,0,0); 
		if (tableSpaceInfoCount == null||tableSpaceInfoCount.size()==0) {
			log.debug("========��Ҫ��ѯ���������ݲ�����========");
			//��Ҫ��ѯ���������ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		int totalCount=tableSpaceInfoCount.size();
		if ( tableSpaceInfoCount.size() > dto.getMaxSearchCount() ) {
			log.debug("========��Ҫ��ѯ���������ݹ���========");
			//��Ҫ��ѯ���������ݹ���
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		List<TableSpaceInfo> tableSpaceInfoList=this.soc0118BL.searchTableRelationInfo(soc0118Cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setTableSpaceInfoList(tableSpaceInfoList);
		return dto;
	}


	public IGCIM01DTO initIGAIM0137Action(IGCIM01DTO dto) throws BLException {
		IGCIM0137Form form=dto.getIgcim0137Form();
		SOC0118Info soc0118Info=this.soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getEiid()));
		if(soc0118Info!=null){
			form.setEiversion(soc0118Info.getEiversion()+"");
			form.setEismallversion(soc0118Info.getEismallversion()+"");
		}
		Map<Integer,List<RelationTreeTB>> treeMap=new LinkedHashMap<Integer, List<RelationTreeTB>>();
		int levelNum=100;
		String jsonStr=null;
		Integer eiid=Integer.parseInt(form.getEiid());
		Integer eirootmark=Integer.parseInt(form.getEirootmark());
		Integer eiversion=Integer.parseInt(form.getEiversion());
		Integer eismallversion=Integer.parseInt(form.getEismallversion());
		//���ϲ�ѯ
		treeMap=searchUpTreeNode(eiid,eiversion,eismallversion,eirootmark,levelNum,treeMap);
		//���²�ѯ
		treeMap=searchDownTreeNodeByEiid(eiid,eiversion,eismallversion,eirootmark,levelNum,treeMap);
		//Ȼ����treeMap
		jsonStr=initChangeJsonObject(treeMap,levelNum);
		//���ó�ʼ�����
		String initNodeId=getInitNodeId(treeMap,levelNum);
		dto.setInitTreeStr(jsonStr);
		dto.setInitNodeID(initNodeId);
		return dto;
	}
	/**��ʼ����ѯָ��*/
	public IGCIM01DTO initIGCIM0155Action(IGCIM01DTO dto) throws BLException {
		return dto;
	}
	
	/**
	 * �������ˣ�ȡ��Ӧ�ù�ϵ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO getBusinessTree(IGCIM01DTO dto) throws BLException {
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version='1.0' encoding='UTF-8' ?>");
		xml.append("<root>");
		xml.append("<node eiid='' eid='' name='ҵ��ϵͳ' desc='ҵ��ϵͳ' icon='bussImage'>");
		User user = dto.getUser();
		SOC0118SearchCondImpl cond0118 = new SOC0118SearchCondImpl();
		UserRoleVWSearchCondImpl rolecond = new UserRoleVWSearchCondImpl();
		rolecond.setUserid(user.getUserid());
		List<UserRoleInfo> urlist = userRoleBL.searchUserRoleVW(rolecond);
		boolean flag = false;//
		for(UserRoleInfo ur:urlist){
			//�����ɫ����Ϊ�ĲĹ���Ĭ�Ͻ�ɫ����
			if(EntityItemKeyWords.ROLE_BUSINESS_MANAGER.equals(ur.getRoleid())){
					flag = true;
					break;
			}
			
		}
		if(!flag){
			cond0118.setMagName(dto.getUser().getUsername());
		}
		cond0118.setEid(EntityItemKeyWords.BUSINESS_EID);
		//ȡ������ҵ��ϵͳ
		List<SOC0118Info> businessList = soc0118BL.searchEntityItem(cond0118);

		if (businessList != null && businessList.size() >0 ) {
			int i=0;
			for (SOC0118Info info0118 : businessList) {
				if(i==0){
					dto.setEiid(info0118.getEiid().toString());
				}
				SOC0107SearchCondImpl cond0107 = new SOC0107SearchCondImpl();
		   		cond0107.setEiid(info0118.getEiid().toString());
		   		cond0107.setCiversion(info0118.getEiversion().toString());
		   		cond0107.setCismallversion(info0118.getEismallversion().toString());
		   		cond0107.setCid("CI030100010023");
		   		List<SOC0107Info> info0107_list=soc0107BL.searchSOC0107(cond0107);
		   		if(info0107_list == null){continue;}
		   		if(info0107_list.size() == 0){continue;}
		   		if(info0107_list.get(0).getCivalue().equals("��")){
		   			xml.append("<node eiid='" + info0118.getEiid() + "' eid='" + info0118.getEid() + "' name='" + info0118.getEiname() + "' desc='' icon='appImage'>");
		   			searchCldTreeNode(xml, info0118);
		   		}else{
		   			continue;
		   		}
				xml.append("</node>");
				i++;
			}
		}
		xml.append("</node>");
		xml.append("</root>");
		String treeXml = xml.toString();
		dto.setTreeXml(treeXml);
		return dto;
	}

	/**
	 * �������ˣ���ѯҵ��ϵͳ��ϵ���ӽڵ�
	 * @param xml
	 * @param info0118
	 * @throws BLException
	 */
	private void searchCldTreeNode(StringBuffer xml, SOC0118Info info0118) throws BLException {
		SOC0119SearchCondImpl cond0119 = new SOC0119SearchCondImpl();
		cond0119.setPareiid(info0118.getEiid());
		cond0119.setParversion(info0118.getEiversion());
		cond0119.setParsmallversion(info0118.getEismallversion());
		cond0119.setDeleteflag("0");
		List<SOC0119Info> soc0119List = soc0119BL.searchMaxEntityItemRelation(cond0119);
		if (soc0119List != null && soc0119List.size() > 0) {
			for (SOC0119Info info0119 : soc0119List) {
				//����Ӧ��-����Ĺ�ϵ
				if (EntityItemKeyWords.APP_SERVICE_RelationCODE.equals(info0119.getEirrelationcode())) {
					if(!EntityItemKeyWords.BUSINESS_BUSINESS_Relation.equals(info0119.getEirrelation())
							&&!EntityItemKeyWords.BUSINESS_OTHER_Relation.equals(info0119.getEirrelation())
							&&!EntityItemKeyWords.BUSINESS_MODULE_Relation.equals(info0119.getEirrelation())
							&&!EntityItemKeyWords.BUSINESS_SP_Relation.equals(info0119.getEirrelation())
							&&!EntityItemKeyWords.BUSINESS_SI_Relation.equals(info0119.getEirrelation())){
						SOC0118Info soc0118Info = soc0118BL.searchEntityItemByKey(info0119.getCldeiid());
						String icon = "webappImage";
						if(EntityItemKeyWords.SERVICE_PROVIDER_EID.equals(soc0118Info.getEid())){
							icon = "srvproviderImage";
						} else {
							icon = "srvcallerImage";
						}
						SOC0107SearchCondImpl cond0107 = new SOC0107SearchCondImpl();
				   		cond0107.setEiid(info0118.getEiid().toString());
				   		cond0107.setCiversion(info0118.getEiversion().toString());
				   		cond0107.setCismallversion(info0118.getEismallversion().toString());
				   		cond0107.setCid("CI030100010023");
				   		List<SOC0107Info> info0107_list=soc0107BL.searchSOC0107(cond0107);
				   		if(info0107_list == null){continue;}
				   		if(info0107_list.size() == 0){continue;}
				   		if(info0107_list.get(0).getCivalue().equals("��")){
				   			xml.append("<node eiid='" + soc0118Info.getEiid() + "' eid='" + soc0118Info.getEid() + "' name='" + soc0118Info.getEiname() + "' desc='' icon='" + icon + "'>");
				   			searchCldTreeNode(xml, soc0118Info);
				   		}else{
					   		continue;
					   	}
						xml.append("</node>");
					}
				}
			}
		}
	}
	
	/**
	 *	�������ˣ�Ӧ�ù�ϵ�Ǽǳ�ʼ��
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO initIGCIM0152Action(IGCIM01DTO dto) throws BLException {
		log.debug("========Ӧ�ù�ϵ�Ǽǳ�ʼ������ʼ========");
		List<LabelValueBean> lvList = new ArrayList<LabelValueBean>();
		lvList.add(new LabelValueBean("",""));
		dto.setRelationList(lvList);
		IGCIM0152Form form = dto.getIgcim0152Form();
		Integer eiid = form.getPareiid();
		if (eiid == null || eiid ==0) {
			return dto;
		}
		SOC0118Info info = soc0118BL.searchEntityItemByKey(eiid);
		form.setPareid(info.getEid());
		form.setPareilabel(info.getEilabel());
		form.setPareiname(info.getEiname());
		form.setParversion(info.getEiversion());
		form.setParsmallversion(info.getEismallversion());
		String eid = info.getEid();
		List<LabelValueBean> list = this.codeDetailBL.searchLabelValueBeanList(CommonDefineUtils.ENTIY_CATEGORY_APPLICATION,CodeDefine.getCodeDefine("ENTITYITEM_RELATION_CODE").getCcid());
		if (list != null && list.size() >0) {
			String type = form.getType();//service��Ӧ��-����software��Ӧ��-���
			for (LabelValueBean lv : list) {
				String value = lv.getValue();
				//Ӧ��-����
				if ("service".equals(type) && value.endsWith(EntityItemKeyWords.APP_SERVICE_RelationCODE)) {
					//fromҵ��ϵͳ,ҵ��ϵͳ-�����ṩ�߻�ҵ��ϵͳ-���������
					if (EntityItemKeyWords.BUSINESS_EID.equals(eid)) {
						if (value.startsWith(EntityItemKeyWords.BUSINESS_SP_Relation) ||
								value.startsWith(EntityItemKeyWords.BUSINESS_SI_Relation)||
								value.startsWith(EntityItemKeyWords.BUSINESS_BUSINESS_Relation)||
								value.startsWith(EntityItemKeyWords.BUSINESS_OTHER_Relation)||
								value.startsWith(EntityItemKeyWords.BUSINESS_MODULE_Relation)) {
							lvList.add(lv);
						}
					}
					//from�����ṩ��,�����ṩ��-���������
					if (EntityItemKeyWords.SERVICE_PROVIDER_EID.equals(eid)) {
						if (value.startsWith(EntityItemKeyWords.SP_SI_Relation)) {
							lvList.add(lv);
						}
					}
					//from���������,�����ṩ��-���������
					if (EntityItemKeyWords.SERVICE_INVOKER_EID.equals(eid)) {
						if (value.startsWith(EntityItemKeyWords.SP_SI_Relation)) {
							lvList.add(lv);
						}
					}
				}
				
				//Ӧ��-���
				if ("software".equals(type) && (value.endsWith(EntityItemKeyWords.APP_SW_RelationCODE)
						||value.endsWith(EntityItemKeyWords.APP_VM_RelationCODE))) {
					lvList.add(lv);
				}
			}
		}
		log.debug("========Ӧ�ù�ϵ�Ǽǳ�ʼ����������========");
		return dto;
	}
	
	/**
	 * �������ˣ�Ӧ�ù�ϵ�ǼǴ���
	 *
	 * @param dto IGCIM01DTO
	 * @return IGCIM01DTO
	 */
	public IGCIM01DTO insertEntityItemRelationActionApp2(IGCIM01DTO dto) throws BLException {
		log.debug("========Ӧ�ù�ϵ�ǼǴ���ʼ========");
		
		IGCIM0152Form form = dto.getIgcim0152Form();
		SOC0118Info soc0118Info=soc0118BL.searchEntityItemByKey(form.getPareiid());
		//Ӧ��ID���ӣ�ȡ��
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		
		cond.setElabel(form.getElabel());
		cond.setEilabel(form.getEilabel());
		
		List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
		
		if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.010")
					+ form.getElabel() + resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.011") 
					+ form.getEilabel() + resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.012"));
		}
		
		form.setCldeiid(entityItemVWList.get(0).getEiid());
		form.setCldeid(entityItemVWList.get(0).getEid());
		form.setCldversion(entityItemVWList.get(0).getEiversion());
		form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
		//Ӧ��ID�������ͣ��ӣ����
		if (form.getPareiid().intValue() == form.getCldeiid().intValue()) {
			//Ӧ��ID������= ���ӣ�
			throw new BLException(BLErrorType.ENTITY_ITEM_RELATION_ERROR,
					"IGCO10000.E012",resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.004"));
		}
		
		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		//�ʲ���ϵ�Ǽ�      20120731 add �ظ���ϵ��֤
		SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
		condeir.setPareiid(form.getPareiid());
		condeir.setCldeiid(form.getCldeiid());
		condeir.setEirrelationcode(form.getEirrelationcode());
		condeir.setDeleteflag("0");
		List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
		condeir =new SOC0119SearchCondImpl();
		condeir.setCldeiid(form.getPareiid());
		condeir.setPareiid(form.getCldeiid());
		condeir.setEirrelationcode(form.getEirrelationcode());
		condeir.setDeleteflag("0");
		List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
		if(list_eir.size()>0||list_eirCld.size()>0){
			throw new BLException(BLErrorType.ENTITY_ITEM_RELATION_ERROR,"IGASM0307.E001",resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.020"));
		}
		SOC0119Info ret = 
			this.soc0119BL.registEntityItemRelation(dto.getIgcim0152Form());
		//�ж��Ǵ���ҵ��ϵͳ��webӦ�õĹ�ϵʱ��ͬʱ����ҵ��ϵͳ��������ҵ��ϵͳ��web�������Ĺ�ϵ
		if("CR030001000002".equals(form.getEirrelation())){
			createEntityItemRelationActionAppToWebServer(form,entityItemVWList.get(0));
			createEntityItemRelationActionAppToHost(form,entityItemVWList.get(0));
		}else if("CR030001000003".equals(form.getEirrelation())){
			createEntityItemRelationActionAppToWEBAPP2(form,entityItemVWList.get(0));
			createEntityItemRelationActionAppToHost(form,entityItemVWList.get(0));
		}
		dto.setEntityItemRelation(ret);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.013")) );
		
		log.debug("========Ӧ�ù�ϵ�ǼǴ�������========");
		return dto;
	}
	
	/**
	 * �������ˣ�����ҵ��ϵͳ��Web������֮��Ĺ�ϵ
	 * @param form
	 * @param soc0124Info
	 * @throws BLException
	 */
	public void createEntityItemRelationActionAppToWebServer(IGCIM0152Form form,SOC0124Info soc0124Info) throws BLException {
		SOC0110SearchCondImpl soc0110Cond=new SOC0110SearchCondImpl();
		soc0110Cond.setBrcldeiid(soc0124Info.getEiid()+"");
		soc0110Cond.setBrcldversion(soc0124Info.getEiversion()+"");
		soc0110Cond.setBrcldsmallversion(soc0124Info.getEismallversion()+"");
		soc0110Cond.setBrassetrelation("CR020002000001");
		List<SOC0110Info> soc0110InfoList=this.soc0110BL.searchEiBelongRelation(soc0110Cond);
		if(soc0110InfoList!=null&&soc0110InfoList.size()>0){
			SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
			List<String> eiidList=new ArrayList<String>();
			eiidList.add(soc0110InfoList.get(0).getBrpareiid()+"");
			cond.setEiidList(eiidList);
			List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
			if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
				throw new BLException("IGCO10000.E004","Web������");
			}
			form.setCldeiid(entityItemVWList.get(0).getEiid());
			form.setCldeid(entityItemVWList.get(0).getEid());
			form.setCldversion(entityItemVWList.get(0).getEiversion());
			form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
			form.setEirrelation("CR030001000004");
			//����ʱ���趨
			Date nowDateTime = new Date();
			String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

			form.setEirupdtime(datetime);
			
			//�ʲ���ϵ�Ǽ�      20120731 add �ظ���ϵ��֤
			SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
			condeir.setPareiid(form.getPareiid());
			condeir.setCldeiid(form.getCldeiid());
			condeir.setEirrelationcode(form.getEirrelationcode());
			condeir.setDeleteflag("0");
			List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
			condeir =new SOC0119SearchCondImpl();
			condeir.setCldeiid(form.getPareiid());
			condeir.setPareiid(form.getCldeiid());
			condeir.setEirrelationcode(form.getEirrelationcode());
			condeir.setDeleteflag("0");
			List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
			if(list_eir.size()>0||list_eirCld.size()>0){
			}else{
				this.soc0119BL.registEntityItemRelation(form);
			}
			createEntityItemRelationWebToAppServer(form,entityItemVWList.get(0));
		}
	}
	
	/**
	 * �������ˣ�����ҵ��ϵͳ��Web������֮��Ĺ�ϵ
	 * @param form
	 * @param soc0124Info
	 * @throws BLException
	 */
	public void createEntityItemRelationWebToAppServer(IGCIM0152Form form,SOC0124Info soc0124Info) throws BLException {
		SOC0110SearchCondImpl soc0110Cond=new SOC0110SearchCondImpl();
		soc0110Cond.setBrcldeiid(soc0124Info.getEiid()+"");
		soc0110Cond.setBrcldversion(soc0124Info.getEiversion()+"");
		soc0110Cond.setBrcldsmallversion(soc0124Info.getEismallversion()+"");
		soc0110Cond.setBrassetrelation("CR020001000001");
		List<SOC0110Info> soc0110InfoList=this.soc0110BL.searchEiBelongRelation(soc0110Cond);
		if(soc0110InfoList!=null&&soc0110InfoList.size()>0){
			for(SOC0110Info soc0110Info:soc0110InfoList){
				SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
				List<String> eiidList=new ArrayList<String>();
				eiidList.add(soc0110Info.getBrpareiid()+"");
				cond.setEiidList(eiidList);
				List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
				if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
				}else{
					form.setCldeiid(entityItemVWList.get(0).getEiid());
					form.setCldeid(entityItemVWList.get(0).getEid());
					form.setCldversion(entityItemVWList.get(0).getEiversion());
					form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
					form.setEirrelation("CR030001000001");
					form.setEirrelationcode("003-002");
					//����ʱ���趨
					Date nowDateTime = new Date();
					String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

					form.setEirupdtime(datetime);
					
					//�ʲ���ϵ�Ǽ�      20120731 add �ظ���ϵ��֤
					SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
					condeir.setPareiid(form.getPareiid());
					condeir.setCldeiid(form.getCldeiid());
					condeir.setEirrelationcode(form.getEirrelationcode());
					condeir.setDeleteflag("0");
					List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
					condeir =new SOC0119SearchCondImpl();
					condeir.setCldeiid(form.getPareiid());
					condeir.setPareiid(form.getCldeiid());
					condeir.setEirrelationcode(form.getEirrelationcode());
					condeir.setDeleteflag("0");
					List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
					if(list_eir.size()>0||list_eirCld.size()>0){
					}else{
						this.soc0119BL.registEntityItemRelation(form);
					}
					createEntityItemRelationAppToHostByWebServer(form,entityItemVWList.get(0));
				}
			}
		}
	}
	
	public void createEntityItemRelationAppToHostByWebServer(IGCIM0152Form form,SOC0124Info soc0124Info) throws BLException {
		SOC0110SearchCondImpl soc0110Cond=new SOC0110SearchCondImpl();
		soc0110Cond.setBrcldeiid(soc0124Info.getEiid()+"");
		soc0110Cond.setBrcldversion(soc0124Info.getEiversion()+"");
		soc0110Cond.setBrcldsmallversion(soc0124Info.getEismallversion()+"");
		soc0110Cond.setBrassetrelation("CR010100010024");
		List<SOC0110Info> soc0110InfoList=this.soc0110BL.searchEiBelongRelation(soc0110Cond);
		if(soc0110InfoList!=null&&soc0110InfoList.size()>0){
			for(SOC0110Info soc0110Info:soc0110InfoList){
				SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
				List<String> eiidList=new ArrayList<String>();
				eiidList.add(soc0110Info.getBrpareiid()+"");
				cond.setEiidList(eiidList);
				List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
				if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
				}else{
					form.setCldeiid(entityItemVWList.get(0).getEiid());
					form.setCldeid(entityItemVWList.get(0).getEid());
					form.setCldversion(entityItemVWList.get(0).getEiversion());
					form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
					form.setEirrelation("CR030100010001");
					form.setEirrelationcode("003-001");
					//����ʱ���趨
					Date nowDateTime = new Date();
					String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

					form.setEirupdtime(datetime);
					
					//�ʲ���ϵ�Ǽ�      20120731 add �ظ���ϵ��֤
					SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
					condeir.setPareiid(form.getPareiid());
					condeir.setCldeiid(form.getCldeiid());
					condeir.setEirrelationcode("003-001");
					condeir.setDeleteflag("0");
					List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
					condeir =new SOC0119SearchCondImpl();
					condeir.setCldeiid(form.getPareiid());
					condeir.setPareiid(form.getCldeiid());
					condeir.setEirrelationcode("003-001");
					condeir.setDeleteflag("0");
					List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
					if(list_eir.size()>0||list_eirCld.size()>0){
					}else{
						this.soc0119BL.registEntityItemRelation(form);
					}
				}
			}
		}
	}
	
	public void createEntityItemRelationAppToHostByWebServer(IGCIM0127Form form,SOC0124Info soc0124Info) throws BLException {
		SOC0110SearchCondImpl soc0110Cond=new SOC0110SearchCondImpl();
		soc0110Cond.setBrcldeiid(soc0124Info.getEiid()+"");
		soc0110Cond.setBrcldversion(soc0124Info.getEiversion()+"");
		soc0110Cond.setBrcldsmallversion(soc0124Info.getEismallversion()+"");
		soc0110Cond.setBrassetrelation("CR010100010024");
		List<SOC0110Info> soc0110InfoList=this.soc0110BL.searchEiBelongRelation(soc0110Cond);
		if(soc0110InfoList!=null&&soc0110InfoList.size()>0){
			for(SOC0110Info soc0110Info:soc0110InfoList){
				SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
				List<String> eiidList=new ArrayList<String>();
				eiidList.add(soc0110Info.getBrpareiid()+"");
				cond.setEiidList(eiidList);
				List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
				if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
				}else{
					form.setCldeiid(entityItemVWList.get(0).getEiid());
					form.setCldeid(entityItemVWList.get(0).getEid());
					form.setCldversion(entityItemVWList.get(0).getEiversion());
					form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
					form.setEirrelation("CR030100010001");
					form.setEirrelationcode("003-001");
					//����ʱ���趨
					Date nowDateTime = new Date();
					String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

					form.setEirupdtime(datetime);
					
					//�ʲ���ϵ�Ǽ�      20120731 add �ظ���ϵ��֤
					SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
					condeir.setPareiid(form.getPareiid());
					condeir.setCldeiid(form.getCldeiid());
					condeir.setEirrelationcode("003-001");
					condeir.setDeleteflag("0");
					List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
					condeir =new SOC0119SearchCondImpl();
					condeir.setCldeiid(form.getPareiid());
					condeir.setPareiid(form.getCldeiid());
					condeir.setEirrelationcode("003-001");
					condeir.setDeleteflag("0");
					List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
					if(list_eir.size()>0||list_eirCld.size()>0){
					}else{
						this.soc0119BL.registEntityItemRelation(form);
					}
				}
			}
		}
	}
	
	/**
	 * �������ˣ�����ҵ��ϵͳ������֮��Ĺ�ϵ
	 * @param form
	 * @param soc0124Info
	 * @throws BLException
	 */
	public void createEntityItemRelationActionAppToHost2(IGCIM0152Form form,SOC0124Info soc0124Info) throws BLException {
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		List<String> eiidList=new ArrayList<String>();
		eiidList.add(soc0124Info.getEirootmark()+"");
		cond.setEiidList(eiidList);
		List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
		if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
			throw new BLException("IGCO10000.E004","����");
		}
		form.setCldeiid(entityItemVWList.get(0).getEiid());
		form.setCldeid(entityItemVWList.get(0).getEid());
		form.setCldversion(entityItemVWList.get(0).getEiversion());
		form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
		form.setEirrelation("CR030100010001");
		form.setEirrelationcode("003-001");
		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		//�ʲ���ϵ�Ǽ�      20120731 add �ظ���ϵ��֤
		SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
		condeir.setPareiid(form.getPareiid());
		condeir.setCldeiid(form.getCldeiid());
		condeir.setEirrelationcode(form.getEirrelationcode());
		condeir.setDeleteflag("0");
		List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
		condeir =new SOC0119SearchCondImpl();
		condeir.setCldeiid(form.getPareiid());
		condeir.setPareiid(form.getCldeiid());
		condeir.setEirrelationcode(form.getEirrelationcode());
		condeir.setDeleteflag("0");
		List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
		if(list_eir.size()>0||list_eirCld.size()>0){
		}else{
			this.soc0119BL.registEntityItemRelation(form);
		}
	}
	
	/**
	 * �������ˣ�����ҵ��ϵͳ��webapp
	 * @param form
	 * @param soc0124Info
	 */
	private void createEntityItemRelationActionAppToWEBAPP2(IGCIM0152Form form,
			SOC0124Info soc0124Info) throws BLException {
		SOC0110SearchCondImpl soc0110Cond=new SOC0110SearchCondImpl();
		soc0110Cond.setBrcldeiid(soc0124Info.getEiid()+"");
		soc0110Cond.setBrcldversion(soc0124Info.getEiversion()+"");
		soc0110Cond.setBrcldsmallversion(soc0124Info.getEismallversion()+"");
		soc0110Cond.setBrassetrelation("CR020004000001");
		List<SOC0110Info> soc0110InfoList=this.soc0110BL.searchEiBelongRelation(soc0110Cond);
		if(soc0110InfoList!=null&&soc0110InfoList.size()>0){
			SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
			List<String> eiidList=new ArrayList<String>();
			eiidList.add(soc0110InfoList.get(0).getBrpareiid()+"");
			cond.setEiidList(eiidList);
			List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
			if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
				throw new BLException("IGCO10000.E004","���ݿ�");
			}
			form.setCldeiid(entityItemVWList.get(0).getEiid());
			form.setCldeid(entityItemVWList.get(0).getEid());
			form.setCldversion(entityItemVWList.get(0).getEiversion());
			form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
			form.setEirrelation("CR030001000005");
			//����ʱ���趨
			Date nowDateTime = new Date();
			String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

			form.setEirupdtime(datetime);
			
			//�ʲ���ϵ�Ǽ�      20120731 add �ظ���ϵ��֤
			SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
			condeir.setPareiid(form.getPareiid());
			condeir.setCldeiid(form.getCldeiid());
			condeir.setEirrelationcode(form.getEirrelationcode());
			condeir.setDeleteflag("0");
			List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
			condeir =new SOC0119SearchCondImpl();
			condeir.setCldeiid(form.getPareiid());
			condeir.setPareiid(form.getCldeiid());
			condeir.setEirrelationcode(form.getEirrelationcode());
			condeir.setDeleteflag("0");
			List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
			if(list_eir.size()>0||list_eirCld.size()>0){
			}else{
				this.soc0119BL.registEntityItemRelation(form);
			}
		}
	}


	/**
	 * ��ϵ���Ͳ�ѯ
	 */
	public IGCIM01DTO searchRelationType(IGCIM01DTO dto) throws BLException {
//		IGCIM0107Form form = dto.getIgasm0307Form();
//		String esyscoding = form.getEsyscoding();
//		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
//		cond.setCcid(CodeDefine.BELONG_RELATION_TYPE.getCcid());
//		//�豸
//		if(esyscoding.startsWith(EiRelationKeyWords.DEVICE)){
//			cond.setBusinesscode_like("001");
//		}
//		//���
//		if(esyscoding.startsWith(EiRelationKeyWords.SOFTWARE)){
//			cond.setBusinesscode_like("002");
//		}
//		//Ӧ��
//		if(esyscoding.startsWith(EiRelationKeyWords.APP)){
//			cond.setBusinesscode_like("003");
//		}
//		List<CodeDetail> cdList = codeDetailBL.searchCodeDetail(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
//		List<LabelValueBean> list = new ArrayList<LabelValueBean>();
//		list.add(new LabelValueBean("", ""));
//		for(CodeDetail cd : cdList){
//			list.add(new LabelValueBean(cd.getCvalue(), cd.getCid()));
//		}
		List<LabelValueBean> lvList = new ArrayList<LabelValueBean>();
		lvList.add(new LabelValueBean("",""));
		IGCIM0107Form form=dto.getIgcim0107Form();
		List<LabelValueBean> list = this.codeDetailBL.searchLabelValueBeanList("002",CodeDefine.getCodeDefine("RELATIONCODE").getCcid());
		if(list!=null&&list.size()>0){
			for(LabelValueBean lv : list){
				String value=lv.getValue();
				if("999002003001".equals(form.getEsyscoding())){
					if(value.startsWith(EntityItemKeyWords.APP_Relation)){
						lvList.add(lv);
					}
				}else{
					if(!value.startsWith(EntityItemKeyWords.APP_Relation)&&StringUtils.isNotEmpty(value)){
						lvList.add(lv);
					}
				}
			}
		}
		dto.setRelationTypeList(lvList);
		dto.setRelationList(lvList);
		return dto;
	}
	
	
	/**
	 * �������ˣ�����ҵ��ϵͳ��Informix֮��Ĺ�ϵ
	 * @param form
	 * @param soc0124Info
	 * @throws BLException
	 */
	public void createEntityItemRelationActionAppToInformix(IGCIM0152Form form,SOC0124Info soc0124Info) throws BLException {
		SOC0110SearchCondImpl soc0110Cond=new SOC0110SearchCondImpl();
		soc0110Cond.setBrcldeiid(soc0124Info.getEiid()+"");
		soc0110Cond.setBrcldversion(soc0124Info.getEiversion()+"");
		soc0110Cond.setBrcldsmallversion(soc0124Info.getEismallversion()+"");
		soc0110Cond.setBrassetrelation("CR020300010001");
		List<SOC0110Info> soc0110InfoList=this.soc0110BL.searchEiBelongRelation(soc0110Cond);
		if(soc0110InfoList!=null&&soc0110InfoList.size()>0){
			SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
			List<String> eiidList=new ArrayList<String>();
			eiidList.add(soc0110InfoList.get(0).getBrpareiid()+"");
			cond.setEiidList(eiidList);
			List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
			if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
				throw new BLException("IGCO10000.E004","Informix");
			}
			form.setCldeiid(entityItemVWList.get(0).getEiid());
			form.setCldeid(entityItemVWList.get(0).getEid());
			form.setCldversion(entityItemVWList.get(0).getEiversion());
			form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
			form.setEirrelation("CR030100010011");
			//����ʱ���趨
			Date nowDateTime = new Date();
			String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

			form.setEirupdtime(datetime);
			
			//�ʲ���ϵ�Ǽ�      20120731 add �ظ���ϵ��֤
			SOC0119SearchCondImpl condeir =new SOC0119SearchCondImpl();
			condeir.setPareiid(form.getPareiid());
			condeir.setCldeiid(form.getCldeiid());
			condeir.setEirrelationcode(form.getEirrelationcode());
			condeir.setDeleteflag("0");
			List<SOC0119Info> list_eir=this.soc0119BL.searchEntityItemRelation(condeir);
			condeir =new SOC0119SearchCondImpl();
			condeir.setCldeiid(form.getPareiid());
			condeir.setPareiid(form.getCldeiid());
			condeir.setEirrelationcode(form.getEirrelationcode());
			condeir.setDeleteflag("0");
			List<SOC0119Info> list_eirCld=this.soc0119BL.searchEntityItemRelation(condeir);
			if(list_eir.size()>0||list_eirCld.size()>0){
			}else{
				this.soc0119BL.registEntityItemRelation(form);
			}
		}
	}
	
	
	/**
	 * get Item Images Info By Code Detail table
	 * @return
	 */
	private Map<String, String> getItemImagesInfoByCodeDetail(){
		CodeDetailSearchCondImpl cond=new CodeDetailSearchCondImpl();
		cond.setCcid("002");
		Map<String, String> imageMap = null;
		List<CodeDetail> imageInfolist = this.codeDetailBL.searchCodeDetail(cond, 0);
		if(imageInfolist != null && imageInfolist.size() != 0){
			imageMap = new HashMap<String, String>();
			for(CodeDetail codeDetail : imageInfolist){
				String keys[] = codeDetail.getCdinfo().split("_");
				if(keys.length == 3){
					imageMap.put(keys[0], codeDetail.getCvalue());
					//imageMap.put(keys[1]+"_"+keys[2], codeDetail.getCvalue());
				}else{
					imageMap.put(codeDetail.getCdinfo(), codeDetail.getCvalue());
				}
			}
		}
		return imageMap;
	}
	
	/**
	 * get Item Image By Name
	 * @param jsonObject
	 * @param itemImageMap
	 * @param key
	 * @return
	 * @throws JSONException
	 */
	private JSONObject getItemImageByName(JSONObject jsonObject, Map<String, 
			String> itemImageMap, String key, String isLeaf, boolean isModule, String deviceCode) throws JSONException{
		
//		if ("CM02060001".equals(deviceCode)) {
//			jsonObject.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN,
//					IGCIMConstants.TREE_PARAMETER_ICONSKIN_LEAFICON);
//			log.info(" >> >> " + jsonObject.toString());
//			return jsonObject;
//		}
		//�ж��Ƿ���Ҷ�ӽڵ�
		if (!IGCIMConstants.TREE_PARAMETER_ISLEAF_VALUE_TRUE.equals(isLeaf)&&!isModule) {
			if(itemImageMap.get(key)!=null){
				jsonObject.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN, itemImageMap.get(key)+"leaf");
			}else{
				jsonObject.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN,
						IGCIMConstants.TREE_PARAMETER_ICONSKIN_LEAFICON);
			}
		} else {
			if (itemImageMap != null && itemImageMap.containsKey(key)&& isModule) {
				//��ģ�ͽڵ㣬�����ܻ�ȡ��ͼƬ��Ϣ
				jsonObject.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN,
						itemImageMap.get(key));

			} else if (itemImageMap != null && !itemImageMap.containsKey(key)
					&& isModule) {
				//��ģ�ͽڵ㣬���Ҳ��ܻ�ȡ��ͼƬ��Ϣ
				jsonObject.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN,
						"modeliconCOMMON");
			} else {
				if (IGCIMConstants.TREE_PARAMETER_ISLEAF_VALUE_TRUE
						.equals(isLeaf)) {
					if(itemImageMap.get(key)!=null){
						jsonObject.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN,
								itemImageMap.get(key));
					}else{
						jsonObject.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN,
								IGCIMConstants.TREE_PARAMETER_ICONSKIN_FATHERICON);
					}
				} else {
//					if ("CM02060001".equals(deviceCode)) {
//						jsonObject.put(IGCIMConstants.TREE_PARAMETER_OPEN, IGCIMConstants.TREE_PARAMETER_OPEN_VALUE_FALSE);
//					}
					if(itemImageMap.get(key)!=null){
						jsonObject.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN, itemImageMap.get(key)+"leaf");
					}else{
						jsonObject.put(IGCIMConstants.TREE_PARAMETER_ICONSKIN,
								IGCIMConstants.TREE_PARAMETER_ICONSKIN_LEAFICON);
					}
				}
			}
		}

		return jsonObject;
	}
	
	
	/**
	 * ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM01DTO searchSoc0153List(IGCIM01DTO dto)throws BLException{
		
		
		log.debug("========��־��Ϣ��ѯ����ʼ========");
		
		SOC0153SearchCondImpl cond = new SOC0153SearchCondImpl();
		
		dto = searchSoc0113Info(dto);
		
		if("1".equals(dto.getWarnType())){
			BeanUtils.copyProperties(dto.getIgcim0160Form(), cond);
			
		}else{
			BeanUtils.copyProperties(dto.getIgcim0161Form(), cond);
		}
		
		cond.setWarnType(dto.getWarnType());

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		String sDate = cond.getsDate();
		String eDate = cond.geteDate();
		try {
			if (StringUtils.isNotEmpty(sDate)) {
				cond.setsDate(sdf2.format(sdf1.parse(sDate)));
			}
			if (StringUtils.isNotEmpty(eDate)) {
				cond.seteDate(sdf2.format(sdf1.parse(eDate)));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		int totalCount = soc0153BL.getSearchCount(cond);
		if (totalCount == 0) {
			log.debug("========��־��ѯ���ݲ�����========");
			//��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========��־��Ϣ��ѯ���ݼ�������========");
			//��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		
		//��ҳ����Ϣȡ��
			PagingDTO pDto = dto.getPagingDto();
			
			//��ǰҳӦ����Ϣȡ��
			List<SOC0153Info> soc0153List = soc0153BL.searchSoc0153(cond, pDto.getFromCount(), pDto.getPageDispCount());
			
			pDto.setTotalCount(totalCount);
			
			dto.setSoc0153List(soc0153List);
			
			dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));

			log.debug("========��־��Ϣ��ѯ�������========");
		return dto;
		
		
	}

	/**
	 * ��ѯҵ��ϵͳ������Աȱʧ
	 */
	public IGCIM01DTO searchIGCIM0140Action(IGCIM01DTO dto) throws BLException {
		
		log.debug("========ҵ��ϵͳ������Աȱʧ��Ϣ��ѯ����ʼ========");
		
		PlatformManagerVWSearchCondImpl cond = new PlatformManagerVWSearchCondImpl();
		
		BeanUtils.copyProperties(dto.getIgcim0140Form(), cond);
		platformManagerBL.getCount(cond);
		int totalCount = platformManagerBL.getCount(cond);
		if (totalCount == 0) {
			log.debug("========ҵ��ϵͳ������Աȱʧ��ѯ���ݲ�����========");
			//��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========ҵ��ϵͳ������Աȱʧ��Ϣ��ѯ���ݼ�������========");
			//��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		
		//��ҳ����Ϣȡ��
			PagingDTO pDto = dto.getPagingDto();
			
			//��ǰҳӦ����Ϣȡ��
			List<PlatformManagerInfo> platformManagerList = platformManagerBL.findByCond(cond, pDto.getFromCount(), pDto.getPageDispCount());
			
			pDto.setTotalCount(totalCount);
			
			dto.setPlatformManagerList(platformManagerList);
			
			dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));

			log.debug("========ҵ��ϵͳ������Աȱʧ��Ϣ��ѯ�������========");
		return dto;
	}
	/**
	 * ��ѯ�����豸�˿�״̬
	 */
	public IGCIM01DTO searchIGCIM0911Action(IGCIM01DTO dto) throws BLException {
		log.debug("========��ѯ���罻�����˿�״̬��ѯ����ʼ========");
		int totalCount = soc0118BL.getNetDeviceInfoListCount(dto.getIgcim0911Form());
		if (totalCount == 0) {
			log.debug("========��ѯ�����豸�˿�״̬��ѯ���ݲ�����========");
			//��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========��ѯ�����豸�˿�״̬��ѯ���ݼ�������========");
			//��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//��ҳ����Ϣȡ��
			PagingDTO pDto = dto.getPagingDto();
			//��ǰҳӦ����Ϣȡ��
			List<NetDeviceInfo> eiList = soc0118BL.searchNetDeviceInfoList(dto.getIgcim0911Form(), pDto.getFromCount(), pDto.getPageDispCount());
			
			pDto.setTotalCount(totalCount);
			
			dto.setNetDeviceList(eiList);
			dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
			log.debug("========��ѯ�����豸�˿�״̬��ѯ�������========");
		return dto;
	}
	
    /**
     *  �ʲ��Զ��屨����/Ԥ������
     * 
     * @param dto IGCIM01DTO
     * @return IGCIM01DTO 
     */
    public IGCIM01DTO exportReport(IGCIM01DTO dto) throws BLException {

		log.debug("========�ʲ��Զ��屨����/Ԥ������ʼ========");
		
		//��ѯ��Excel��ͷ����
		SOC0109SearchCondImpl soc0109Cond = new SOC0109SearchCondImpl();
		soc0109Cond.setCseq(1);
		List<SOC0109Info> soc0109List = this.soc0109BL.searchConfiguration(soc0109Cond);
		Map<String,List<SOC0109Info>> ciMap = new HashMap<String,List<SOC0109Info>>();
		for(SOC0109Info ciInfo:soc0109List){
			if(ciMap.get(ciInfo.getEid())==null){
				List<SOC0109Info> temp_list = new ArrayList<SOC0109Info>();
				temp_list.add(ciInfo);
				ciMap.put(ciInfo.getEid(), temp_list);
			}else{
				ciMap.get(ciInfo.getEid()).add(ciInfo);
			}
		}
		//��ѯ���������Ա��е�����
		SOC0107SearchCondImpl configItemCond = new SOC0107SearchCondImpl();
		//��ѯ����Ӧ��ϵ�����к����ʲ�ID
		List<Integer> eiid_list = getEiidByParentList(dto);
		List<SOC0107Info> soc0107List = null;
		if(eiid_list.size()>0){
			StringBuffer sb = new StringBuffer();
			for(Integer i :eiid_list){
				sb.append(String.valueOf(i)).append(",");
			}
			sb.append(dto.getEiid());
			configItemCond.setEid(sb.toString());
			soc0107List = this.soc0107BL.getConfigItemByEid(configItemCond);
		}else{
			soc0107List = new ArrayList<SOC0107Info>();
		}
		Map<String,List<SOC0107Info>> confMap = new HashMap<String,List<SOC0107Info>>();
		for(SOC0107Info ciInfo:soc0107List){
			if(confMap.get(ciInfo.getEiid()+"_"+ciInfo.getCiversion()+"_"+ciInfo.getCismallversion())==null){
				List<SOC0107Info> temp_list = new ArrayList<SOC0107Info>();
				temp_list.add(ciInfo);
				confMap.put(ciInfo.getEiid()+"_"+ciInfo.getCiversion()+"_"+ciInfo.getCismallversion(), temp_list);
			}else{
				confMap.get(confMap.get(ciInfo.getEiid()+"_"+ciInfo.getCiversion()+"_"+ciInfo.getCismallversion()).add(ciInfo));
			}
		}
		
		//��ѯ����ǰҵ��ϵͳ������Ϣ
    	SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(Integer.parseInt(dto.getEiid()));
		
		dto.setSheetType(IGCIMConstants.SHEETTYPE_BUSSINESS);
		dto = getSheetBussinessData(dto,"ҵ��",entityItemVWInfo,ciMap,confMap);
		List<SOC0119Info> soc0119list = getSOC0119List(dto,entityItemVWInfo);
		String eid = "";
		
		//ͨ��CodeDetail��ѯ����Ҫ�����Ĺ�ϵ
		CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
		condimpl.setCcid("835");
		List<CodeDetail> cdList = codeDetailBL.searchCodeDetail(condimpl,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
		Map<String,String> cdMap = new HashMap<String,String>();
		for(CodeDetail cd : cdList){
			cdMap.put(cd.getCid(), cd.getCvalue());
		}
		
		for(SOC0119Info soc0119info : soc0119list){
			if(soc0119info.getEirrelation().equals(IGCIMConstants.RELATION_HOST)){
				eid = IGCIMConstants.EID_HOST;
			}else{
				eid = soc0119info.getCldeid();
			}
			String cvalue = cdMap.get(soc0119info.getEirrelation());
			if(StringUtils.isNotEmpty(cvalue)){
				dto.setSheetType(cvalue);
		    	List<Integer> appList = getEiidList(soc0119info.getEirrelation(),dto);
		    	if(appList.size()>0)
		    		dto = getSheetAppModuleData(dto,appList,eid,cvalue.split("-")[1],ciMap,confMap);
			}
			
		}
    	
    	log.debug("========�ʲ��Զ��屨����/Ԥ���������========");
		return dto;
    }
  
    /**
     *  ��ȡ��Ӧsheetҳ����������Ϣ
     * 
     * @param dto IGCIM01DTO
     * @param List<Integer> cldList
     * @return IGCIM01DTO 
     */
    public IGCIM01DTO getSheetAppModuleData(IGCIM01DTO dto,List<Integer> cldList,String eid,
    		String key,Map<String,List<SOC0109Info>> ciMap,Map<String,List<SOC0107Info>> confMap) throws BLException {
    	
    	List<String> eiidlist = new ArrayList<String>();
    	for(Integer eiid:cldList){
    		eiidlist.add(String.valueOf(eiid));
    	}
    	SOC0124SearchCondImpl soc0124cond = new SOC0124SearchCondImpl();
    	soc0124cond.setEiidList(eiidlist);
    	List<SOC0124Info> soc0124list =this.soc0118BL.searchEntityItemVW(soc0124cond);
    	
		//����ģ�ͱ�����excel��ͷ����ʾ��
		List<SOC0109Info> soc0109List =arraysList109(ciMap.get(eid));
    	
		//�б��⼯��
        List<String> titleList = new ArrayList<String>();
		List<String[]>  contentList =  new ArrayList<String[]>();
		
    	//��ѯ���ʲ����Ա��е�����ֵ
    	String[] titlevalue = new String[soc0109List.size()+3];
		titlevalue[0] = key+"����";
		titlevalue[1] = "�ʲ�����";
		titlevalue[2] = key+"���";
		int i = 3;
		Map<String,Boolean> soc0109Map = new HashMap<String,Boolean>();
		for(SOC0109Info soc0109Info :soc0109List){
			soc0109Map.put(soc0109Info.getCid(),true);
			titlevalue[i] = soc0109Info.getCname();
			i++;
		}
		for(String str :titlevalue){
			titleList.add(str);
		}
    	String[] contentvalue = null;
    	for(SOC0124Info soc0124info:soc0124list){
    		String cond = soc0124info.getEiid()+"_"+soc0124info.getEiversion()+"_"+soc0124info.getEismallversion();
    		List<SOC0107Info> soc0107List = null;
    		if(confMap.get(cond)==null){
    			soc0107List = new ArrayList<SOC0107Info>();
    		}else{
    			soc0107List = arraysList107(confMap.get(cond));
    		}
    		contentvalue = new String[soc0109List.size()+3];
    		contentvalue[0] =soc0124info.getEiname();
    		contentvalue[1] =soc0124info.getEname();
    		contentvalue[2] =soc0124info.getEilabel(); 
    		int k = 3;
    		for(SOC0107Info soc0107Info : soc0107List){
    			if(soc0109Map.get(soc0107Info.getCid())!=null)
	    			if(soc0109Map.get(soc0107Info.getCid())){
	    				contentvalue[k] = soc0107Info.getCivalue();
	    				k++;
	    			}
    		}
    		contentList.add(contentvalue);
    	}
    	if(contentList.size()>0){
        	dto.getTitleListMap().put(dto.getSheetType(), titleList);
            
            //��������������������Ԥ��ҳ����ʾ��¼������
        	dto.getReportSizeMap().put(dto.getSheetType(), contentList.size());
            
            //���������ڵ���/Ԥ��ʱ�ϲ���Ԫ��
        	dto.getColumnSizeMap().put(dto.getSheetType(), titlevalue.length);
            
        	dto.getContentListMap().put(dto.getSheetType(), contentList);
    	}
    	
    	return dto;
    }
    /**
     *  ��ȡ��Ӧsheetҳ����������Ϣ
     * 
     * @param dto IGCIM01DTO
     * @return IGCIM01DTO 
     */
    public IGCIM01DTO getSheetBussinessData(IGCIM01DTO dto,String key,SOC0124Info entityItemVWInfo,
    		Map<String,List<SOC0109Info>> ciMap,Map<String,List<SOC0107Info>> confMap) throws BLException {
    
		List<SOC0109Info> soc0109List =arraysList109(ciMap.get(entityItemVWInfo.getEid()));
		
		//�б��⼯��
        List<String> titleList = new ArrayList<String>();
		List<String[]>  contentList =  new ArrayList<String[]>();
		
    	//��ѯ���ʲ����Ա��е�����ֵ
    	String[] titlevalue = new String[soc0109List.size()+3];
		titlevalue[0] = key+"����";
		titlevalue[1] = "�ʲ�����";
		titlevalue[2] = key+"���";
		int i = 3;
		Map<String,Boolean> soc0109Map = new HashMap<String,Boolean>();
		for(SOC0109Info soc0109Info :soc0109List){
			soc0109Map.put(soc0109Info.getCid(),true);
			titlevalue[i] = soc0109Info.getCname();
			i++;
		}
		for(String str :titlevalue){
			titleList.add(str);
		}
    	String[] contentvalue = null;
		String cond = entityItemVWInfo.getEiid()+"_"+entityItemVWInfo.getEiversion()+"_"+entityItemVWInfo.getEismallversion();
		List<SOC0107Info> soc0107List = null;
		if(confMap.get(cond)==null){
			soc0107List = new ArrayList<SOC0107Info>();
		}else{
			soc0107List = arraysList107(confMap.get(cond));
		}		
		contentvalue = new String[soc0109List.size()+3];
		contentvalue[0] =entityItemVWInfo.getEiname();
		contentvalue[1] =entityItemVWInfo.getEname();
		contentvalue[2] =entityItemVWInfo.getEilabel(); 
		int k = 3;
		for(SOC0107Info soc0107Info : soc0107List){
			if(soc0109Map.get(soc0107Info.getCid())!=null)
    			if(soc0109Map.get(soc0107Info.getCid())){
    				contentvalue[k] = soc0107Info.getCivalue();
    				k++;
    			}
		}
		
		contentList.add(contentvalue);
		
		dto.setReportTitle(entityItemVWInfo.getEiname());
		Map<String,List<String>> titleListMap = new LinkedHashMap<String,List<String>>();
		titleListMap.put(dto.getSheetType(), titleList);
		dto.setTitleListMap(titleListMap);
       
        //��������������������Ԥ��ҳ����ʾ��¼������
		Map<String,Integer> reportSizeMap = new LinkedHashMap<String,Integer>();
		reportSizeMap.put(dto.getSheetType(), contentList.size());
        dto.setReportSizeMap(reportSizeMap);
        
        //���������ڵ���/Ԥ��ʱ�ϲ���Ԫ��
        Map<String,Integer> columnSizeMap = new LinkedHashMap<String,Integer>();
        columnSizeMap.put(dto.getSheetType(), titleList.size());
        dto.setColumnSizeMap(columnSizeMap);
        
        Map<String,List<String[]>> contentListMap = new LinkedHashMap<String,List<String[]>>();
        contentListMap.put(dto.getSheetType(), contentList);
        dto.setContentListMap(contentListMap);
    	
    	return dto;
    }
    
	/**
	 * �жϸ�ҵ��ϵͳ���Ƿ��и���ģ��
	 * @throws BLException 
	 * @throws Exception
	 */  
    public List<Integer> getEiidList(String relationCode,IGCIM01DTO dto) throws BLException{
    	SOC0119SearchCondImpl soc0119cond = new SOC0119SearchCondImpl();
    	soc0119cond.setPareiid(Integer.parseInt(dto.getEiid()));
    	soc0119cond.setEirrelation(relationCode);
    	soc0119cond.setDeleteflag("0");
    	return this.soc0119BL.searchCldeiidByPareiid(soc0119cond);
    }
    public List<Integer> getEiidByParentList(IGCIM01DTO dto) throws BLException{
    	SOC0119SearchCondImpl soc0119cond = new SOC0119SearchCondImpl();
    	soc0119cond.setPareiid(Integer.parseInt(dto.getEiid()));
    	soc0119cond.setDeleteflag("0");
    	return this.soc0119BL.searchCldeiidByPareiid(soc0119cond);
    }
    public List<SOC0119Info> getSOC0119List(IGCIM01DTO dto,SOC0124Info entityItemVWInfo) throws BLException{
    	SOC0119SearchCondImpl soc0119cond = new SOC0119SearchCondImpl();
    	soc0119cond.setParversion(entityItemVWInfo.getEiversion());
    	soc0119cond.setParsmallversion(entityItemVWInfo.getEismallversion());
    	soc0119cond.setPareiid(Integer.parseInt(dto.getEiid()));
    	soc0119cond.setDeleteflag("0");
    	return this.soc0119BL.searchMaxEntityItemRelation(soc0119cond);
    }
	/**
	 * ��CID����
	 * @throws Exception
	 */
	public List<SOC0107Info> arraysList107(List<SOC0107Info> soc0107List){
        //list����
		Collections.sort(soc0107List,new Comparator<SOC0107Info>(){
			public int compare(SOC0107Info soc1,SOC0107Info soc2){
				String len1 =  soc1.getCid().substring(soc1.getCid().length()-5,soc1.getCid().length());
				String len2 =  soc2.getCid().substring(soc2.getCid().length()-5,soc1.getCid().length());
			return Integer.parseInt(len1)-Integer.parseInt(len2);
			}
		  } 
		);
		return soc0107List;
	}
	/**
	 * ��CID����
	 * @throws Exception
	 */
	public List<SOC0109Info> arraysList109(List<SOC0109Info> soc0109List){
        //list����
		Collections.sort(soc0109List,new Comparator<SOC0109Info>(){
			public int compare(SOC0109Info soc1,SOC0109Info soc2){
				String len1 =  soc1.getCid().substring(soc1.getCid().length()-5,soc1.getCid().length());
				String len2 =  soc2.getCid().substring(soc2.getCid().length()-5,soc1.getCid().length());
			return Integer.parseInt(len1)-Integer.parseInt(len2);
			}
		  } 
		);
		return soc0109List;
	}
	/**
	 * ��ѯ������Ϣ
	 * @param dto
	 * @return
	 */
	public IGCIM01DTO searchSoc0113Info(IGCIM01DTO dto){
		List<SOC0113Info> list = soc0113BL.searchEiImportProgramme();
		dto.setSoc0113List(list);
		return dto;
	}
	
	/**
	 * �豸��Ϣ��ѯ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM01DTO searchSOC0118(IGCIM01DTO dto) throws BLException {

		log.debug("========�豸��Ϣ��ѯ����ʼ========");
		
		//�豸��Ϣ��ѯ����ȡ�� 
		SOC0124SearchCond entityItemVWSearchCond = dto.getEntityItemVWSearchCond();
		String esyscoding = entityItemVWSearchCond.getEsyscoding();
		String einame = entityItemVWSearchCond.getEiname();
		String eiupdtime_from = entityItemVWSearchCond.getEiupdtime_from();
		String eiupdtime_to = entityItemVWSearchCond.getEiupdtime_to();
		Integer eirootmark_eq = entityItemVWSearchCond.getEirootmark_eq();
		
		SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		cond.setEsyscoding_eq(esyscoding);
		cond.setEiname(einame);
		cond.setEiupdtime_from(eiupdtime_from);
		cond.setEirootmark(eirootmark_eq);
		
		if (StringUtils.isNotEmpty(eiupdtime_to)) {
			cond.setEiupdtime_to(eiupdtime_to + " 23:59");
		}
		int totalCount = soc0118BL.getEntityItemSearchCount(cond);
		
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
		List<SOC0118Info> soc0118List = this.soc0118BL.searchEntityItem(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemList(soc0118List);

		Integer domainid = EiDomainKeyWords.DOOMAIN_ID_DEFAULT;
		SOC0111Info domain  = this.soc0111BL.searchDomainMaxVersion(domainid);
		Integer domainversion = domain.getVersion();
		String createtime = domain.getUpdatetime();
		String showRelation = "N";
		Map<String,String> showRelationMap = new HashMap<String,String>();
		if(soc0118List!=null){
			//���������������洢���Բ鿴��ϵ
			// ���洢��Ϊֻ�鿴DMX�洢 --20130607 yanglongquan
			for(SOC0118Info bean:soc0118List){
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
     *  ��ȡresourceid
     * 
     * @param dto IGCIM01DTO
     * @return IGCIM01DTO 
     */
    public IGCIM01DTO getResid(IGCIM01DTO dto) throws BLException {
    	SOC0118Info entityItem = soc0118BL.searchEntityItemByKey(Integer.parseInt(dto.getEiid()));
    	String cid = resource_cid.get(entityItem.getEid());
    	SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
    	cond.setEiid(dto.getEiid());
    	cond.setCid(cid);
    	cond.setCiversion(""+entityItem.getEiversion());
    	cond.setCismallversion(""+entityItem.getEismallversion());
    	List<SOC0107Info> clist = soc0107BL.searchSOC0107(cond);
    	if(clist!=null&&clist.size()>0){
    		String resid = clist.get(0).getCivalue();
        	dto.setResid(resid);
    	}
    	if(StringUtils.isEmpty(dto.getResid())){
    		dto.addMessage(new ActionMessage("IGCIM0156.E001"));
    	}
    	return dto;
    }
    
    /**
     *  ��ȡ�ʲ��������
     * 
     * @param dto IGCIM01DTO
     * @return IGCIM01DTO 
     */
    public IGCIM01DTO getProcessByEiid(IGCIM01DTO dto) throws BLException {
    	IG500VWSearchCondImpl cond = new IG500VWSearchCondImpl();
    	cond.setEiid(dto.getEiid());
    	List<String> prpdid_in = new ArrayList<String>();
    	prpdid_in.add("0108001");
    	prpdid_in.add("0108301");
    	prpdid_in.add("0108402");
    	prpdid_in.add("0110001");
    	cond.setPrpdid_in(prpdid_in);
    	List<IG500VWInfo> resList = ig500VWBL.findByCond(cond);
    	dto.setRes500VWList(resList);
    	return dto;
    }
    
    /**
     *  ��ȡ�ʲ������¼
     * 
     * @param dto IGCIM01DTO
     * @return IGCIM01DTO 
     */
    public IGCIM01DTO getMaintainByEiid(IGCIM01DTO dto) throws BLException {
    	IG500VWSearchCondImpl cond = new IG500VWSearchCondImpl();
    	cond.setEiid(dto.getEiid());
    	cond.setPrpdid_eq("0100201");
    	List<IG500VWInfo> resList = ig500VWBL.findByCond(cond);
    	dto.setRes500VWList(resList);
    	return dto;
    }
    
    /**
	 * �������ò�ѯ
	 */
	public IGCIM01DTO searchSOC0118ByHost(IGCIM01DTO dto) throws BLException {
		log.debug("========������Ϣ��ѯ����ʼ========");
		
		//������Ϣ��ѯ����ȡ�� 
		IGCIM0101Form form = dto.getIgcim0101Form();
		String esyscoding = form.getEsyscoding();
		String einame = form.getEiname();
		String eiupdtime_from = form.getEiupdtime_from();
		String eiupdtime_to = form.getEiupdtime_to();
		Integer eirootmark_eq = form.getEirootmark_eq();
		
		SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		cond.setEsyscoding_eq(esyscoding);
		cond.setEiname(einame);
		cond.setEiupdtime_from(eiupdtime_from);
		cond.setEirootmark(eirootmark_eq);
		cond.setEitype(form.getEitype());
		
		if (StringUtils.isNotEmpty(eiupdtime_to)) {
			cond.setEiupdtime_to(eiupdtime_to + " 23:59");
		}
		int totalCount = soc0118BL.getEntityItemSearchCountByHost(cond);
		
		if (totalCount == 0) {
			log.debug("========������Ϣ��ѯ���ݲ�����========");
			//������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========������Ϣ��ѯ���ݼ�������========");
			//������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳ�豸��Ϣȡ��
		List<SOC0118Info> soc0118List = this.soc0118BL.searchEntityItemByHost(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemList(soc0118List);

		Integer domainid = EiDomainKeyWords.DOOMAIN_ID_DEFAULT;
		SOC0111Info domain  = this.soc0111BL.searchDomainMaxVersion(domainid);
		Integer domainversion = domain.getVersion();
		String createtime = domain.getUpdatetime();
		String showRelation = "N";
		Map<String,String> showRelationMap = new HashMap<String,String>();
		if(soc0118List!=null){
			//���������������洢���Բ鿴��ϵ
			for(SOC0118Info bean:soc0118List){
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
		
		log.debug("========������Ϣ��ѯ��������========");
		return dto;
	}
}
