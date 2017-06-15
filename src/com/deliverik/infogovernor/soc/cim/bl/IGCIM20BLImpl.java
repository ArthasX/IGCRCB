package com.deliverik.infogovernor.soc.cim.bl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

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
import com.deliverik.framework.soc.asset.EiDomainKeyWords;
import com.deliverik.framework.soc.asset.EiRelationKeyWords;
import com.deliverik.framework.soc.asset.EntityCategory;
import com.deliverik.framework.soc.asset.EntityItemKeyWords;
import com.deliverik.framework.soc.asset.SOC0138Info;
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
import com.deliverik.framework.soc.asset.bl.task.SOC0163BL;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0110Info;
import com.deliverik.framework.soc.asset.model.SOC0111Info;
import com.deliverik.framework.soc.asset.model.SOC0112Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.SOC0163Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0110SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0126SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0107TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0110TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0112PK;
import com.deliverik.framework.soc.asset.model.entity.SOC0112TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0119TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0124VW;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.asset.bl.IGASM03BLImpl;
import com.deliverik.infogovernor.soc.bl.task.SocRelationBL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM20DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM2001Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM2002Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM2003Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM2006Form;
import com.deliverik.infogovernor.soc.model.entity.SocRelationTB;
import com.deliverik.infogovernor.util.ASMHelper;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * �������BLʵ��
 * @author Administrator
 *
 */
public class IGCIM20BLImpl  extends BaseBLImpl implements IGCIM20BL{
	
	static Log log = LogFactory.getLog(IGCIM20BLImpl.class);
	
	private SOC0118BL soc0118BL;
	private SOC0117BL soc0117BL;
	private SOC0119BL soc0119BL;
	private SOC0110BL soc0110BL;
	private SOC0111BL soc0111BL;
	private SOC0163BL soc0163BL;
	
	private SOC0109BL soc0109BL;
	private OrganizationBL organizationBL;
	private SocRelationBL socRelationBL;
	private SOC0107BL soc0107BL;
	private SOC0151BL soc0151BL;
	private SOC0126BL soc0126BL;
	private SOC0112BL soc0112BL;
	private CodeDetailBL codeDetailBL;
	private UserRoleBL userRoleBL;
	private FileUploadBL fileUploadBL;
	
	protected MessageResources resources = MessageResources.getMessageResources("com.deliverik.infogovernor.soc.cim.asmResources"); 
	
	
	
	public void setSoc0163BL(SOC0163BL soc0163bl) {
		soc0163BL = soc0163bl;
	}
	public void setSoc0111BL(SOC0111BL soc0111bl) {
		soc0111BL = soc0111bl;
	}
	public void setSocRelationBL(SocRelationBL socRelationBL) {
		this.socRelationBL = socRelationBL;
	}
	
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	
	public void setSoc0109BL(SOC0109BL soc0109bl) {
		soc0109BL = soc0109bl;
	}
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}



	public void setSoc0119BL(SOC0119BL soc0119bl) {
		soc0119BL = soc0119bl;
	}



	public void setSoc0110BL(SOC0110BL soc0110bl) {
		soc0110BL = soc0110bl;
	}



	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}



	public void setSoc0107BL(SOC0107BL soc0107bl) {
		soc0107BL = soc0107bl;
	}



	public void setSoc0151BL(SOC0151BL soc0151bl) {
		soc0151BL = soc0151bl;
	}


	public void setSoc0118BL(SOC0118BL soc0118bl) {
		soc0118BL = soc0118bl;
	}



	public void setSoc0117BL(SOC0117BL soc0117bl) {
		soc0117BL = soc0117bl;
	}



	public void setSoc0112BL(SOC0112BL soc0112BL) {
		this.soc0112BL = soc0112BL;
	}
	
	
	public void setSoc0126BL(SOC0126BL soc0126BL) {
		this.soc0126BL = soc0126BL;
	}
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}
	/**
	 * ��ȡ�豸������ֵ
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM20DTO searchEntityItemLableAction(IGCIM20DTO dto) throws BLException {
		
		log.debug("========��ȡ�豸������ֵ����ʼ========");
		
		IGCIM2001Form form = dto.getIgcim2001Form();
		
		SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		
		cond.setEilabel(CommonDefineUtils.ENTIY_CATEGORY_DEVICE_KEY + IGStringUtils.getCurrentYear().substring(2));
		
		String eilabel = this.soc0118BL.searchNextEntityItemLable(cond);
		
		form.setEilabel(eilabel);
		
		log.debug("========��ȡ�豸������ֵ��������========");
		return dto;
	}
	
	/**
	 * �豸��Ϣ�ǼǴ���
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM20DTO insertEntityItemAction(IGCIM20DTO dto) throws BLException {
		log.debug("========�����豸��Ϣ�ǼǴ���ʼ========");
		//����Formȡ��
		IGCIM2001Form form = dto.getIgcim2001Form();
		
		form.setEidStr(form.getEid().toString());
		
		//����ʱ���趨
		
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		form.setEiupdtime(datetime);
		
		//��汾�趨���̶���Ϊ1��
		form.setEiversion(1);
		
		//С�汾�趨���̶���Ϊ0��
		form.setEismallversion(0);
		
		form.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_NEW);

		SOC0118TB soc0118 = new SOC0118TB();
		
		BeanUtils.copyProperties(form, soc0118);
		//�豸��Ϣ��¼
		SOC0118Info entityItem = this.soc0118BL.registEntityItem(soc0118);
		SOC0118TB ei=(SOC0118TB)SerializationUtils.clone(entityItem);
		ei.setEirootmark(entityItem.getEiid());
		this.soc0118BL.updateEntityItem(ei);
		
		form.setEiidStr(entityItem.getEiid().toString());
		
		dto.setIgcim2001Form(form);
		//�豸������Ϣ
		dto.addMessage(new ActionMessage( "IGCO10000.I004", resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.001")) );
		
		log.debug("========�����豸��Ϣ�ǼǴ�������========");
		return dto;
	}
	
	/**
	 * �豸������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM20DTO initIGCIM2002Action(IGCIM20DTO dto) throws BLException {

		log.debug("========�豸������Ϣ�༭������ڻ�����ʼ========");
		
		IGCIM2003Form form = dto.getIgcim2003Form();
		
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

		
		log.debug("========�����豸������Ϣ�༭������ڻ���������========");
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
	public IGCIM20DTO editEntityItemAction(IGCIM20DTO dto) throws BLException,FileNotFoundException,IOException {
		log.debug("========�豸������Ϣ�༭����ʼ========");
		//�汾������
		IGCIM2003Form form = dto.getIgcim2003Form();
		
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
	private String saveXMLFrist(IGCIM2002Form form,User user) throws BLException, FileNotFoundException, IOException {
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
	 * �жϵ�½�û��Ƿ����豸�ʲ������ɫ������
	 * 
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 * @throws BLException 
	 */
	public IGCIM20DTO checkEntityItemDomain(IGCIM20DTO dto) throws BLException{
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
	 * �豸��Ϣ��ѯ����
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM20DTO searchEntityItemAction(IGCIM20DTO dto) throws BLException {

		log.debug("========�豸��Ϣ��ѯ����ʼ========");
		
		//�豸��Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0163BL.getSearchCountForNetAsset(dto.getIgcim2004Form());
	//	int totalCount = this.soc0118BL.getEntityItemVWSearchCount(dto.getEntityItemVWSearchCond());
		
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
		List<SOC0163Info> entityVWInfoList = this.soc0163BL.findByCondForNetAsset(dto.getIgcim2004Form(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		dto.setEntityVWInfoList(entityVWInfoList);
		//dto.setEntityItemVWInfoList(entityItemVWInfoList);

		Integer domainid = EiDomainKeyWords.DOOMAIN_ID_DEFAULT;
		SOC0111Info domain  = this.soc0111BL.searchDomainMaxVersion(domainid);
		Integer domainversion = domain.getVersion();
		String createtime = domain.getUpdatetime();
		String showRelation = "N";
		Map<String,String> showRelationMap = new HashMap<String,String>();
		if(entityVWInfoList!=null){
			//���������������洢���Բ鿴��ϵ
			for(SOC0163Info bean:entityVWInfoList){
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
	 * �豸��Ϣɾ������
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM20DTO deleteEntityItemAction(IGCIM20DTO dto) throws BLException {
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
		 *	��ȡӦ�ù�����ϵ����
		 *
		 * @param dto IGCIM01DTO
		 * @return IGCIM01DTO
		 */
		public IGCIM20DTO searchRelationListActionApp(IGCIM20DTO dto) throws BLException {
			log.debug("========��ȡӦ�ù�����ϵ����ʼ========");
//			List<LabelValueBean> list = this.codeDetailBL.searchLabelValueBeanList(CommonDefineUtils.ENTIY_CATEGORY_APPLICATION,CodeDefine.getCodeDefine("ENTITYITEM_RELATION_CODE").getCcid());
			CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
			cond.setCcid(CodeDefine.getCodeDefine("ENTITYITEM_RELATION_CODE").getCcid());
			cond.setCdinfo_eq(dto.getIgcim2006Form().getPareid());
			List<CodeDetail> codetailList = this.codeDetailBL.searchCodeDetail(cond,0);
			dto.setRelationList(codetailList);
			log.debug("========��ȡӦ�ù�����ϵ��������========");
			return dto;
		}
		
		/**
		 * Ӧ�ù�ϵ�ǼǴ���
		 *
		 * @param dto IGCIM01DTO
		 * @return IGCIM01DTO
		 */
		public IGCIM20DTO insertEntityItemRelationActionApp(IGCIM20DTO dto) throws BLException {
			log.debug("========�����豸��ϵ�ǼǴ���ʼ========");
			
			IGCIM2006Form form = dto.getIgcim2006Form();
			
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
			
			SOC0110SearchCondImpl soc0110cond = new SOC0110SearchCondImpl();
			
			soc0110cond.setBrpareiid(form.getPareiid().toString());
			soc0110cond.setBrcldeiid(form.getCldeiid().toString());
			soc0110cond.setBrassetrelation(form.getEirrelation());
			soc0110cond.setDeleteflag("0");
			
			List<SOC0110Info> list_eirl = this.soc0110BL.searchEiBelongRelation(soc0110cond);
			
			soc0110cond = new SOC0110SearchCondImpl();
			
			soc0110cond.setBrpareiid(form.getPareiid().toString());
			soc0110cond.setBrcldeiid(form.getCldeiid().toString());
			soc0110cond.setBrassetrelation(form.getEirrelation());
			soc0110cond.setDeleteflag("0");
			
			List<SOC0110Info> list_cld = this.soc0110BL.searchEiBelongRelation(soc0110cond);
			
			if(list_eirl.size()>0||list_cld.size()>0){
				throw new BLException(BLErrorType.ENTITY_ITEM_RELATION_ERROR,"IGASM0307.E001",resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.020"));
			}
			
			//�������豸��rootmark
			SOC0118TB cldEntity = (SOC0118TB)soc0118BL.searchEntityItemByKey(form.getCldeiid());
			cldEntity.setEirootmark(form.getPareiid());
			
			SOC0110TB soc0110Tb = new SOC0110TB();
			
			soc0110Tb.setBrassetrelation(form.getTempeirrelation());
			soc0110Tb.setBrcldeiid(form.getCldeiid());
			soc0110Tb.setBrcldsmallversion(form.getCldsmallversion());
			soc0110Tb.setBrcldversion(form.getCldversion());
			soc0110Tb.setBrcreatetime(datetime);
			soc0110Tb.setBrpareiid(form.getPareiid());
			soc0110Tb.setBrparsmallversion(form.getParsmallversion());
			soc0110Tb.setBrparversion(form.getParversion());
			soc0110Tb.setBrraletioncode(form.getEirrelationcode());
			soc0110Tb.setDeleteflag("0");
			soc0110Tb.setEirootmark(form.getPareiid());
			soc0110Tb.setBrtype("1");
			soc0110Tb.setBrdes(form.getEirdesc());
			soc0110Tb.setBrraletioncode("001-001");
			SOC0110Info result = soc0110BL.registEiBelongRelation(soc0110Tb);
			
			dto.setEntityRelation(result);
			//dto.addMessage(new ActionMessage( "IGCO10000.I004", resources.getMessage(dto.getLocale(),"message.IGASM08BLImpl.013")) );
			dto.addMessage(new ActionMessage("IGCIM2005.I001"));
			log.debug("========Ӧ�ù�ϵ�ǼǴ�������========");
			return dto;
		}
		
		/**
		 * ����ҵ��ϵͳ��DB֮��Ĺ�ϵ
		 * @param form
		 * @param soc0124Info
		 * @throws BLException
		 */
		public void createEntityItemRelationActionAppToOracle(IGCIM2006Form form,SOC0124Info soc0124Info) throws BLException {
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
		 * ����ҵ��ϵͳ��webapp
		 * @param form
		 * @param soc0124Info
		 */
		private void createEntityItemRelationActionAppToWEBAPP(IGCIM2006Form form,
				SOC0124Info soc0124Info) throws BLException {
			SOC0110SearchCondImpl soc0110Cond=new SOC0110SearchCondImpl();
			soc0110Cond.setBrcldeiid(soc0124Info.getEiid()+"");
			soc0110Cond.setBrcldversion(soc0124Info.getEiversion()+"");
			soc0110Cond.setBrcldsmallversion(soc0124Info.getEismallversion()+"");
			soc0110Cond.setBrassetrelation("CR020200010001");
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
		 * Ӧ�ù�ϵ���������
		 *
		 * @param dto IGCIM01DTO
		 * @return IGCIM01DTO
		 */
		public IGCIM20DTO updateEntityItemRelationActionApp(IGCIM20DTO dto) throws BLException {
			log.debug("========Ӧ�ù�ϵ���������ʼ========");
			IGCIM2006Form form = dto.getIgcim2006Form();

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
		 * Ӧ�ù�ϵ�༭������ڻ�����
		 *
		 * @param dto IGCIM01DTO
		 * @return IGCIM01DTO
		 */
		public IGCIM20DTO initIGCIM2006Action(IGCIM20DTO dto) throws BLException {
			log.debug("========Ӧ�ù�ϵ�༭������ڻ�����ʼ========");
			
			IGCIM2006Form form = dto.getIgcim2006Form();
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
		 * Ӧ�ù�ϵ��������ڻ�����
		 *
		 * @param dto IGCIM01DTO
		 * @return IGCIM01DTO
		 */
		public IGCIM20DTO initIGCIM2005Action(IGCIM20DTO dto) throws BLException {
			log.debug("========�豸������ϵ��������ڻ�����ʼ========");
			
			//�豸��Ϣ����
			SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
					Integer.parseInt(dto.getIgcim2005Form().getEiid()));
			
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

			Map<String,List<SOC0110Info>> parmap = new LinkedHashMap<String,List<SOC0110Info>>();
			
			if ( totalCount>0 ) {
				//�豸������ϵ��Ϣȫ������
				eiBelongRelationList = this.soc0110BL.searchEiBelongRelation(belongcond);
				
				for (SOC0110Info info : eiBelongRelationList) {
					String key = "";
					if("CR010100450001".equals(info.getBrassetrelation())){
						key="������-VLAN";
					}else if("CR010100450002".equals(info.getBrassetrelation())){
						key="������-�˿�";
					}else if("CR010100460001".equals(info.getBrassetrelation())){
						key="·����-VLAN";
					}else if("CR010100460002".equals(info.getBrassetrelation())){
						key="·����-�˿�";
					}else if("CR010100470001".equals(info.getBrassetrelation())){
						key="����ǽ-�˿�";
					}
					if(!parmap.containsKey(key)){
						parmap.put(key, new ArrayList<SOC0110Info>());
					}
					parmap.get(key).add(info);
				}
			}
			
			dto.setParEntityRelationMap(parmap);
			
			Map<String,List<SOC0110Info>> cldmap = new LinkedHashMap<String,List<SOC0110Info>>();
			//���������ϵ����
			SOC0110SearchCondImpl cldcond = new SOC0110SearchCondImpl();
			
			cldcond.setBrcldeiid(entityItemVWInfo.getEiid().toString());
			cldcond.setBrcldsmallversion(entityItemVWInfo.getEismallversion().toString());
			cldcond.setBrcldversion(entityItemVWInfo.getEiversion().toString());
			cldcond.setDeleteflag("0");
			//�豸������ϵ��Ϣ��ѯ����ȡ�� 
			totalCount = this.soc0110BL.getSearchCount(cldcond);
			
			
			if ( totalCount > dto.getMaxSearchCount() ) {
				log.debug("========�豸��ϵ��Ϣ��ѯ���ݼ�������========");
				//�豸��ϵ��Ϣ��ѯ���ݼ�������
				dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
				return dto;
			}

			if ( totalCount>0 ) {
				//�豸������ϵ��Ϣȫ������
				eiBelongRelationList = this.soc0110BL.searchEiBelongRelation(cldcond);
				
				for (SOC0110Info info : eiBelongRelationList) {
					String key = "";
					if("CR010100450001".equals(info.getBrassetrelation())){
						key="������-VLAN";
					}else if("CR010100450002".equals(info.getBrassetrelation())){
						key="������-�˿�";
					}else if("CR010100460001".equals(info.getBrassetrelation())){
						key="·����-VLAN";
					}else if("CR010100460001".equals(info.getBrassetrelation())){
						key="·����-�˿�";
					}else if("CR010100470001".equals(info.getBrassetrelation())){
						key="����ǽ-�˿�";
					}
					if(!cldmap.containsKey(key)){
						cldmap.put(key, new ArrayList<SOC0110Info>());
					}
					cldmap.get(key).add(info);
				}
			}
			dto.setCldEntityRelationMap(cldmap);
			
			log.debug("========�豸������ϵ��������ڻ���������========");
			
			return dto;
		}
		
		/**
		 * Ӧ�ù�ϵɾ������
		 *
		 * @param dto IGCIM01DTO
		 * @return IGCIM01DTO
		 */
		public IGCIM20DTO deleteEntityItemRelationActionApp(IGCIM20DTO dto) throws BLException {
			log.debug("========Ӧ�ù�ϵɾ������ʼ========");
			
			for( int i=0;i<dto.getDeleteEntityItemRelation().length;i++ ){
				String eirid = dto.getDeleteEntityItemRelation()[i];
			
				soc0110BL.deleteEiBelongRelationByPK(Integer.valueOf(eirid));
				
			}
			
			dto.addMessage(new ActionMessage("IGCIM2005.I002"));

			log.debug("========Ӧ�ù�ϵɾ����������========");
			return dto;
		}
		
		/**
		 * �����豸������汾
		 * @param dto
		 * @return
		 * @throws BLException
		 */
		public IGCIM20DTO updateVersion(IGCIM20DTO dto) throws BLException {
			log.debug("========�����豸������汾��ʼ========");
			Properties properties = getProperties();
			String filepath = properties.getProperty("INSTALL_FILE_PATH");
			String batName = properties.getProperty("UPDATE_VERSION_BAT_NAME");
			String[] cmd = new String[5];
			cmd[0] = "cmd";
			cmd[1] = "/c";
			cmd[2] = "start";
			cmd[3] = " ";
			cmd[4] = filepath + batName;
			try {
				java.lang.Runtime.getRuntime().exec(cmd);
			} catch (Exception e) {
				log.error("�����豸������汾Ӧ�ó�������ʧ��", e);
				throw new BLException("IGCIM2004.E001");
			}finally{
			}
			log.debug("========�����豸������汾����========");
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
}
