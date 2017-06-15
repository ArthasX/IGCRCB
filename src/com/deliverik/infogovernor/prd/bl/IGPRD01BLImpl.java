/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.bl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Id;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;
import org.apache.struts.util.LabelValueBean;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.xml.sax.InputSource;

import com.deliverik.framework.asset.bl.task.IG013BL;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.condition.IG688SearchCondImpl;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.bl.CodeCategoryDefBL;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.CodeDetailDefBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.user.bl.task.ActionBL;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Action;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.ActionSearchCondImpl;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.user.model.condition.RoleSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserSearchCondImpl;
import com.deliverik.framework.user.model.entity.ActionTB;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.annotation.IdGeneratorMethod;
import com.deliverik.framework.workflow.prd.bl.task.IG007BL;
import com.deliverik.framework.workflow.prd.bl.task.IG212BL;
import com.deliverik.framework.workflow.prd.bl.task.IG481BL;
import com.deliverik.framework.workflow.prd.bl.task.IG900BL;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG008Info;
import com.deliverik.framework.workflow.prd.model.IG110Info;
import com.deliverik.framework.workflow.prd.model.IG111Info;
import com.deliverik.framework.workflow.prd.model.IG123Info;
import com.deliverik.framework.workflow.prd.model.IG126Info;
import com.deliverik.framework.workflow.prd.model.IG132Info;
import com.deliverik.framework.workflow.prd.model.IG156Info;
import com.deliverik.framework.workflow.prd.model.IG202Info;
import com.deliverik.framework.workflow.prd.model.IG212Info;
import com.deliverik.framework.workflow.prd.model.IG213Info;
import com.deliverik.framework.workflow.prd.model.IG221Info;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG233Info;
import com.deliverik.framework.workflow.prd.model.IG237Info;
import com.deliverik.framework.workflow.prd.model.IG238Info;
import com.deliverik.framework.workflow.prd.model.IG243Info;
import com.deliverik.framework.workflow.prd.model.IG258Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG273Info;
import com.deliverik.framework.workflow.prd.model.IG286Info;
import com.deliverik.framework.workflow.prd.model.IG298Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG334Info;
import com.deliverik.framework.workflow.prd.model.IG335Info;
import com.deliverik.framework.workflow.prd.model.IG373Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG413Info;
import com.deliverik.framework.workflow.prd.model.IG560Info;
import com.deliverik.framework.workflow.prd.model.IG560VWInfo;
import com.deliverik.framework.workflow.prd.model.IG699Info;
import com.deliverik.framework.workflow.prd.model.IG700Info;
import com.deliverik.framework.workflow.prd.model.IG701Info;
import com.deliverik.framework.workflow.prd.model.IG725Info;
import com.deliverik.framework.workflow.prd.model.IG881Info;
import com.deliverik.framework.workflow.prd.model.IG900Info;
import com.deliverik.framework.workflow.prd.model.IG913Info;
import com.deliverik.framework.workflow.prd.model.IG992Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG100SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG126SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG132SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG156SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG202SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG212SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG213SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG221SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG222SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG237SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG243SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG258SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG273SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG334SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG335SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG413SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG560SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG700SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG701SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG725SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG909SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG913SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG992SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG007TB;
import com.deliverik.framework.workflow.prd.model.entity.IG008TB;
import com.deliverik.framework.workflow.prd.model.entity.IG108TB;
import com.deliverik.framework.workflow.prd.model.entity.IG110TB;
import com.deliverik.framework.workflow.prd.model.entity.IG111TB;
import com.deliverik.framework.workflow.prd.model.entity.IG123TB;
import com.deliverik.framework.workflow.prd.model.entity.IG126TB;
import com.deliverik.framework.workflow.prd.model.entity.IG132TB;
import com.deliverik.framework.workflow.prd.model.entity.IG156TB;
import com.deliverik.framework.workflow.prd.model.entity.IG202TB;
import com.deliverik.framework.workflow.prd.model.entity.IG212TB;
import com.deliverik.framework.workflow.prd.model.entity.IG213TB;
import com.deliverik.framework.workflow.prd.model.entity.IG222TB;
import com.deliverik.framework.workflow.prd.model.entity.IG233TB;
import com.deliverik.framework.workflow.prd.model.entity.IG237TB;
import com.deliverik.framework.workflow.prd.model.entity.IG243TB;
import com.deliverik.framework.workflow.prd.model.entity.IG258TB;
import com.deliverik.framework.workflow.prd.model.entity.IG273TB;
import com.deliverik.framework.workflow.prd.model.entity.IG298TB;
import com.deliverik.framework.workflow.prd.model.entity.IG299TB;
import com.deliverik.framework.workflow.prd.model.entity.IG333TB;
import com.deliverik.framework.workflow.prd.model.entity.IG334TB;
import com.deliverik.framework.workflow.prd.model.entity.IG335TB;
import com.deliverik.framework.workflow.prd.model.entity.IG373TB;
import com.deliverik.framework.workflow.prd.model.entity.IG380TB;
import com.deliverik.framework.workflow.prd.model.entity.IG413TB;
import com.deliverik.framework.workflow.prd.model.entity.IG560TB;
import com.deliverik.framework.workflow.prd.model.entity.IG699TB;
import com.deliverik.framework.workflow.prd.model.entity.IG700PK;
import com.deliverik.framework.workflow.prd.model.entity.IG700TB;
import com.deliverik.framework.workflow.prd.model.entity.IG701PK;
import com.deliverik.framework.workflow.prd.model.entity.IG701TB;
import com.deliverik.framework.workflow.prd.model.entity.IG725TB;
import com.deliverik.framework.workflow.prd.model.entity.IG881TB;
import com.deliverik.framework.workflow.prd.model.entity.IG911TB;
import com.deliverik.framework.workflow.prd.model.entity.IG931TB;
import com.deliverik.framework.workflow.prd.model.entity.IG992TB;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0101Form;
import com.deliverik.infogovernor.prd.form.IGPRD0102Form;
import com.deliverik.infogovernor.prd.form.IGPRD0104Form;
import com.deliverik.infogovernor.prd.form.IGPRD0105Form;
import com.deliverik.infogovernor.prd.form.IGPRD0107Form;
import com.deliverik.infogovernor.prd.form.IGPRD0108Form;
import com.deliverik.infogovernor.prd.form.IGPRD0109Form;
import com.deliverik.infogovernor.prd.form.IGPRD0110Form;
import com.deliverik.infogovernor.prd.form.IGPRD0111Form;
import com.deliverik.infogovernor.prd.form.IGPRD0114Form;
import com.deliverik.infogovernor.prd.form.IGPRD0115Form;
import com.deliverik.infogovernor.prd.form.IGPRD0116Form;
import com.deliverik.infogovernor.prd.form.IGPRD0118Form;
import com.deliverik.infogovernor.prd.form.IGPRD0124Form;
import com.deliverik.infogovernor.prd.form.IGPRD0125Form;
import com.deliverik.infogovernor.prd.form.IGPRD0126Form;
import com.deliverik.infogovernor.prd.form.IGPRD0131Form;
import com.deliverik.infogovernor.prd.form.IGPRD0134Form;
import com.deliverik.infogovernor.prd.form.IGPRD0139Form;
import com.deliverik.infogovernor.prd.form.IGPRD0141Form;
import com.deliverik.infogovernor.prd.form.IGPRD0142Form;
import com.deliverik.infogovernor.prd.form.IGPRD0143Form;
import com.deliverik.infogovernor.prd.form.IGPRD0145Form;
import com.deliverik.infogovernor.prd.form.IGPRD0146Form;
import com.deliverik.infogovernor.prd.form.IGPRD0158Form;
import com.deliverik.infogovernor.prd.form.IGPRD0161Form;
import com.deliverik.infogovernor.prd.form.IGPRD0166Form;
import com.deliverik.infogovernor.prd.form.IGPRD0169Form;
import com.deliverik.infogovernor.prd.form.IGPRD0171Form;
import com.deliverik.infogovernor.prd.form.IGPRD0172Form;
import com.deliverik.infogovernor.prd.form.IGPRD0173Form;
import com.deliverik.infogovernor.prd.form.IGPRD0190Form;
import com.deliverik.infogovernor.prd.job.ProcessTacticsPollingJobInit;
import com.deliverik.infogovernor.util.CodeDefine;
import com.google.gson.Gson;

/**
 * ����: ���̶���ҵ���߼�ʵ��
 * ��������: ���̶���ҵ���߼�ʵ�� 
 * ������¼: 2010/11/07
 * �޸ļ�¼: 2013/02/25		130225	���̻�������޸�
 */
public class IGPRD01BLImpl extends BaseBLImpl implements IGPRD01BL {

	static Log log = LogFactory.getLog(IGPRD01BLImpl.class);
	
	/** ���̶���BL */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	
	/** ���̴���BL */
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/** ����BL */
	protected CodeDetailBL codeDetailBL;
	
	/** ��ɫ��ϢBL */
	protected RoleBL roleBL;
	
	/** �ϴ�������Ϣ���� */
	protected FileUploadBL fileUploadBL;
	
	/** ������Ϣ���� */
	protected AttachmentBL attachmentBL;
	
	/** �û���ɫBL */
	protected UserRoleBL userRoleBL;
	
	/** ������ϢBL */
	protected OrganizationBL organizationBL;
	
	/** ���ݷ�����ϢBL */
	protected CodeCategoryDefBL codeCategoryDefiBL;
	
	/** ������ϸ��ϢBL */
	protected CodeDetailDefBL codeDetailDefBL;
	
	/** �û�BL */
	protected UserBL userBL;
	
    /** �˵�BL*/
    protected ActionBL actionBL;
    
    /** �ʲ�BL */
    protected IG013BL ig013BL;

    /** �������Ա����BL */
    protected IG481BL ig481BL;

    /** ���̶���BL */
    protected IG007BL ig007BL;

    /** �Զ�������֪ͨ���Զ���BL */
    protected IG212BL ig212BL;

	/**
	 * ���̶���BL�趨
	 * @param workFlowDefinitionBL ���̶���BL
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	/**
	 * ���̴���BL�趨
	 * @param workFlowOperationBL ���̴���BL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * ����BL�趨
	 * @param codeDetailBL ����BL
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	/**
	 * ��ɫ��ϢBL�趨
	 * @param roleBL ��ɫ��ϢBL
	 */
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}

	/**
	 * �ϴ�������Ϣ�����趨
	 * @param fileUploadBL �ϴ�������Ϣ����
	 */
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}

	/**
	 * ������Ϣ�����趨
	 * @param attachmentBL ������Ϣ����
	 */
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}

	/**
	 * �û���ɫBL�趨
	 * @param userRoleBL �û���ɫBL
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	/**
	 * ������ϢBL�趨
	 * @param organizationBL ������ϢBL
	 */
	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}

	/**
	 * ���ݷ�����ϢBL�趨
	 * @param codeCategoryDefiBL ���ݷ�����ϢBL
	 */
	public void setCodeCategoryDefiBL(CodeCategoryDefBL codeCategoryDefiBL) {
		this.codeCategoryDefiBL = codeCategoryDefiBL;
	}

	/**
	 * ������ϸ��ϢBL�趨
	 * @param codeDetailDefBL ������ϸ��ϢBL
	 */
	public void setCodeDetailDefBL(CodeDetailDefBL codeDetailDefBL) {
		this.codeDetailDefBL = codeDetailDefBL;
	}

	/**
	 * �û�BL�趨
	 * @param userBL �û�BL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	/**
	 * �˵�BL�趨
	 * @param actionBL �˵�BL
	 */
	public void setActionBL(ActionBL actionBL) {
		this.actionBL = actionBL;
	}

	/**
	 * �ʲ�BL�趨
	 * @param ig013bl �ʲ�BL
	 */
	public void setIg013BL(IG013BL ig013bl) {
		ig013BL = ig013bl;
	}

	public void setIg212BL(IG212BL ig212bl) {
		this.ig212BL = ig212bl;
	}

	public void setIg481BL(IG481BL ig481bl) {
		ig481BL = ig481bl;
	}

	/**
	 * @param ig007bl the ig007BL to set
	 */
	public void setIg007BL(IG007BL ig007bl) {
		ig007BL = ig007bl;
	}
	//-----------------------------------------------------------���̶���----------------------------------------------------------------------
	/**
	 * ���̶�����Ϣ��ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessDefinitionAction(IGPRD01DTO dto) throws BLException {
		
		log.debug("========���̶�����Ϣ��ѯ����ʼ========");
		
		//���̶�����Ϣ��ѯ����ȡ�� 
		int totalCount = workFlowDefinitionBL.getProcessDefinitionSearchCount(dto.getProcessDefinitionSearchCond());
		
		if (totalCount == 0) {
			log.debug("========���̶�����Ϣ��ѯ���ݲ�����========");
			//���̶�����Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========���̶�����Ϣ��ѯ���ݼ�������========");
			//���̶�����Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		
		//��ǰҳ���̶�����Ϣȡ��
		List<IG380Info> processDefinitionList = workFlowDefinitionBL.searchProcessDefinition(dto.getProcessDefinitionSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		if(!processDefinitionList.isEmpty()){
			Map<String, String> map = new HashMap<String, String>();
//			List<String> list = new ArrayList<String>();
			int i = 0;
			for(IG380Info pd : processDefinitionList){
				pd = (IG380Info) SerializationUtils.clone(processDefinitionList.get(i++));
				IG259Info pt = workFlowDefinitionBL.searchProcessTemplateByKey(pd.getPtid());
//				list.add(pd.getPdid(), pt.getPtname());
				map.put(String.valueOf(pd.getPdid()), pt.getPtname());
			}
			dto.setMap(map);
		}
		pDto.setTotalCount(totalCount);
		
		dto.setProcessDefinitionList(processDefinitionList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========���̶�����Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * ������ʷ������Ϣ��ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchHistoryProcessDefinitionAction(IGPRD01DTO dto) throws BLException {
		
		log.debug("========������ʷ�汾��Ϣ��ѯ����ʼ========");
		
		//���̶�����Ϣ��ѯ����ȡ�� 
		IG380SearchCondImpl cond = new IG380SearchCondImpl();
		cond.setSearchHistory("1");
		cond.setPdid(dto.getProcessDefinitionSearchCond().getPdid());
		cond.setPrTypeArray(dto.getProcessDefinitionSearchCond().getPrTypeArray());
		int totalCount = workFlowDefinitionBL.getProcessDefinitionSearchHistoryCount(cond);
		
		if (totalCount == 0) {
			log.debug("========������ʷ�汾��ѯ���ݲ�����========");
			//���̶�����Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========������ʷ�汾��ѯ���ݼ�������========");
			//���̶�����Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		
		//��ǰҳ���̶�����Ϣȡ��
		List<IG380Info> processDefinitionList = workFlowDefinitionBL.searchHistoryProcessDefinition(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		if(!processDefinitionList.isEmpty()){
			Map<String, String> map = new HashMap<String, String>();
//			List<String> list = new ArrayList<String>();
			int i = 0;
			for(IG380Info pd : processDefinitionList){
				pd = (IG380Info) SerializationUtils.clone(processDefinitionList.get(i++));
				IG259Info pt = workFlowDefinitionBL.searchProcessTemplateByKey(pd.getPtid());
//				list.add(pd.getPdid(), pt.getPtname());
				map.put(String.valueOf(pd.getPdid()), pt.getPtname());
			}
			dto.setMap(map);
		}
		pDto.setTotalCount(totalCount);
		
		dto.setProcessDefinitionList(processDefinitionList);
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========������ʷ�汾��ѯ��������========");
		return dto;
	}
	
	/**
	 * ���̶�����Ϣ�ǼǴ���
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO insertProcessDefinitionAction(IGPRD01DTO dto) throws BLException {
		
		log.debug("========���̶�����Ϣ�ǼǴ���ʼ========");
		
		IGPRD0102Form form = dto.getIgPRD0102Form();
		
		form.setPdcrtdate(IGStringUtils.getCurrentDate());//����ʱ��
		String pttype = form.getPttype();
		//��ѯ����ģ��ID
		IG259Info pt = workFlowDefinitionBL.searchProcessTemplateByPrType(pttype);
		form.setPtid(pt.getPtid());
		//===��ܱ���Begin
		String message = "����";
		if(IGPRDCONSTANTS.PRTYPE_YEAR.equals(pttype) || IGPRDCONSTANTS.PRTYPE_SEASON.equals(pttype) || IGPRDCONSTANTS.PRTYPE_IRREGULAR.equals(pttype)){
			message = "����";
		}
		//===��ܱ���End

		form.setPdstatus(IGPRDCONSTANTS.PD_STATUS_DISABLE);//ͣ��״̬
		
		String pdid = workFlowDefinitionBL.getProcessDefinitionPK(pt.getFirstsite(),pt.getPdsequence());
		
		form.setPdid(pdid);//����
		form.setPdactname(this.actionBL.getActnameNextValue(form.getPdactname()));//�˵�����
		
		//���̶�����Ϣ�ǼǴ���
		IG380Info pd = workFlowDefinitionBL.registProcessDefinition(form);
		
		form.setPdid(pd.getPdid());//������������ID
		
		form.setPtdid(workFlowDefinitionBL.getProcessTitleDefPK(pd.getPdid()));//����
		
		//�������̱�����Ϣ
		workFlowDefinitionBL.registProcessTitleDef(form);
		
		IG333TB psdTB = new IG333TB();
		
		psdTB.setPsdid(workFlowDefinitionBL.getProcessStatusDefPK(pd.getPdid()));//����
		
		psdTB.setPdid(pd.getPdid());//���̶���ID
		
		psdTB.setPsdcode(IGPRDCONSTANTS.PROCESS_START_STATUS);//��ʼ״̬
		
		psdTB.setPsdtype(IGPRDCONSTANTS.PROCESS_NODE_TYPE_NORMAL);//��ͨ�ڵ�
		
		psdTB.setPsddesc(IGPRDCONSTANTS.PROCESS_START_STATUS_DESC);//˵��
		
		psdTB.setPsdname(IGPRDCONSTANTS.PROCESS_START_STATUS_LABEL);//��ʼ״̬��ʾ����
		
		psdTB.setPsdmode(IGPRDCONSTANTS.MODE_NORMAL);//��ͨģʽ
		
		psdTB.setPsdflag(IGPRDCONSTANTS.NOT_NEED_ASSIGN); //��ʼ״̬�Ƿ�ɷ�����"��"
		
		psdTB.setPsdconfirm(IGPRDCONSTANTS.SUBSTATUS_CONFIRM_NO);//��ȷ��״̬
		
		//����״̬������Ϣ�ǼǴ���
		workFlowDefinitionBL.registProcessStatus(psdTB);
		
		
		IG333TB psdTB1 = new IG333TB();
		
		psdTB1.setPsdid(workFlowDefinitionBL.getProcessStatusDefPK(pd.getPdid()));//����
		
		psdTB1.setPdid(pd.getPdid());//���̶���ID
		
		psdTB1.setPsdcode(IGPRDCONSTANTS.PROCESS_END_STATUS);//����״̬
		
		psdTB1.setPsdtype(IGPRDCONSTANTS.PROCESS_NODE_TYPE_NORMAL);//��ͨ�ڵ�
		
		psdTB1.setPsddesc(IGPRDCONSTANTS.PROCESS_END_STATUS_DESC);//˵��
		
		psdTB1.setPsdname(IGPRDCONSTANTS.PROCESS_END_STATUS_LABEL);//����״̬��ʾ����
		
		psdTB1.setPsdmode(IGPRDCONSTANTS.MODE_NORMAL);
		
		psdTB1.setPsdflag(IGPRDCONSTANTS.NOT_NEED_ASSIGN); //�Ƿ�ɷ�����"��"
		
		psdTB1.setPsdconfirm(IGPRDCONSTANTS.SUBSTATUS_CONFIRM_NO);//��ȷ��״̬
		
		//����״̬������Ϣ�ǼǴ���
		workFlowDefinitionBL.registProcessStatus(psdTB1);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", message + "������Ϣ") );
		
		log.debug("========���̶�����Ϣ�ǼǴ�������========");
		return dto;
	}
	
	/**
     * ��ѯ��ѡ��һ���˵��б�
     *
     * @param dto IGPRD01DTO
     * @return IGPRD01DTO
     */
	public IGPRD01DTO searchActionListAction(IGPRD01DTO dto) throws BLException {
	    
	    //��ѯ����һ���˵�
	    ActionSearchCondImpl cond = new ActionSearchCondImpl();
	    cond.setActtype("M3");
	    cond.setActurl_like("IGCOM0202.do?linkID=IGWKM0110");
	    List<Action> actionList = this.actionBL.searchAction(cond);
	    
	    //������һ���˵���װ��LabelValueBean��
	    List<LabelValueBean> actionLabelValuelist = new ArrayList<LabelValueBean>();
	    actionLabelValuelist.add(new LabelValueBean("", ""));
	    for(Action action : actionList){
	        actionLabelValuelist.add(new LabelValueBean(action.getActlabel(), action.getActname()));
        }
        dto.setActionLabelValueList(actionLabelValuelist);
	    return dto;
	}
	
	/**
	 * ���̶�����Ϣ��ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchLastProcessDefinitionAction(IGPRD01DTO dto) throws BLException {
		
		log.debug("========���̶�����Ϣ��ѯ����ʼ========");
		
		//���̶�����Ϣ��ѯ����ȡ�� 
		int totalCount = workFlowDefinitionBL.getProcessDefinitionSearchLastCount(dto.getProcessDefinitionSearchCond());
		
		if (totalCount == 0) {
			log.debug("========���̶�����Ϣ��ѯ���ݲ�����========");
			//���̶�����Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========���̶�����Ϣ��ѯ���ݼ�������========");
			//���̶�����Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		
		//��ǰҳ���̶�����Ϣȡ��
		List<IG380Info> processDefinitionList = workFlowDefinitionBL.searchLastProcessDefinition(dto.getProcessDefinitionSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		if(!processDefinitionList.isEmpty()){
			Map<String, String> map = new HashMap<String, String>();
//			List<String> list = new ArrayList<String>();
			int i = 0;
			for(IG380Info pd : processDefinitionList){
				pd = (IG380Info) SerializationUtils.clone(processDefinitionList.get(i++));
				IG259Info pt = workFlowDefinitionBL.searchProcessTemplateByKey(pd.getPtid());
//				list.add(pd.getPdid(), pt.getPtname());
				map.put(String.valueOf(pd.getPdid()), pt.getPtname());
			}
			dto.setMap(map);
		}
		pDto.setTotalCount(totalCount);
		
		dto.setProcessDefinitionList(processDefinitionList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========���̶�����Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
     * ��ط�������̶�����Ϣ��ѯ����
     *
     * @param dto IGPRD01DTO
     * @return IGPRD01DTO
     */
    public IGPRD01DTO searchRelevantProcessDefinitionAction(IGPRD01DTO dto) throws BLException {
        
        log.debug("========��ط�������̶�����Ϣ��ѯ����ʼ========");
        
        // ȡ�õ�ǰ״̬��������Ϣ
        IG222Info ig222info = workFlowDefinitionBL.searchParticipantDefByKey(dto.getIgPRD0108Form().getPpdid());
        
        IG913SearchCondImpl cond = new IG913SearchCondImpl();
        cond.setPdid(dto.getPdid());
        cond.setPsdid(dto.getIgPRD0108Form().getPsdid());
        cond.setRoleid(ig222info.getRoleid());
        
        // ��ط����Զ�������������Ϣȡ��
        List<IG913Info> relevantProcessDefinitionList = workFlowDefinitionBL.searchLastIG380AndIG911Info(cond);
        
        dto.setRelevantProcessDefinitionList(relevantProcessDefinitionList);
        
        log.debug("========��ط�������̶�����Ϣ��ѯ��������========");
        return dto;
    }
    
    /**
     * ȱʡȨ�޵���ط�������̶�����Ϣ��ѯ����
     *
     * @param dto IGPRD01DTO
     * @return IGPRD01DTO
     */
    public IGPRD01DTO searchDefaultRelevantProcessDefinitionAction(IGPRD01DTO dto) throws BLException {
        
        log.debug("========ȱʡȨ�޵���ط�������̶�����Ϣ��ѯ����ʼ========");
        
        IG913SearchCondImpl cond = new IG913SearchCondImpl();
        cond.setPdid(dto.getPdid());
        cond.setPsdid(dto.getIgPRD0116Form().getPsdid());
        
        // ��ط����Զ�������������Ϣȡ��
        List<IG913Info> relevantProcessDefinitionList = workFlowDefinitionBL.searchLastIG380AndIG931Info(cond);
        
        dto.setRelevantProcessDefinitionList(relevantProcessDefinitionList);
        
        log.debug("========ȱʡȨ�޵���ط�������̶�����Ϣ��ѯ��������========");
        return dto;
    }
    
	/**
	 * ���̶�����Ϣ�������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO updateProcessDefinitionAction(IGPRD01DTO dto) throws BLException {

		log.debug("========���̶�����Ϣ�������ʼ========");
		IGPRD0102Form form = dto.getIgPRD0102Form();
		
		IG380Info pdRecord = workFlowDefinitionBL.searchProcessDefinitionByKey(form.getPdid());
		
		if(!form.getPdname_bak().equals(form.getPdname())){
			workFlowDefinitionBL.checkNotExistProcessDefinition(pdRecord.getPtid(),form.getPdname());
		}
		
		//���ƶ���
		IG380TB pdTB = (IG380TB)SerializationUtils.clone(pdRecord);
		String pttype = form.getPttype();
		String message = "����";
		IG259Info pt = workFlowDefinitionBL.searchProcessTemplateByPrType(pttype);
		if(pt == null){
			throw new BLException("IGCO10000.E004","���̶���");
		}
		form.setPtid(pt.getPtid());
		//===��ܱ���Begin
		if(IGPRDCONSTANTS.PRTYPE_YEAR.equals(form.getPttype()) || IGPRDCONSTANTS.PRTYPE_SEASON.equals(form.getPttype()) || IGPRDCONSTANTS.PRTYPE_IRREGULAR.equals(form.getPttype())){
			message = "����";
		}
		//===��ܱ���End

		// ����һ���˵���������ɾ��ԭ�в˵����������²˵���
//		if (!StringUtils.isEmpty(pdTB.getPdactname())) {
//		    if (StringUtils.isEmpty(form.getPdactname()) || 
//		            !pdTB.getPdactname().substring(0, 8).equals(form.getPdactname())) {
//		        this.actionBL.deleteActionByKey(pdTB.getPdactname());
//                this.actionBL.deleteActionByKey(pdTB.getPdactname()+"01");
//                this.actionBL.deleteActionByKey(pdTB.getPdactname()+"02");
//                pdTB.setPdactname(null);//��չ����Ĳ˵�
//		    }
//		}
		
		pdTB.setPdname(form.getPdname());
		
		pdTB.setPermission(form.getPermission());//����������־Ȩ��
		
		pdTB.setPddesc(form.getPddesc());
		
		pdTB.setPtid(form.getPtid());
		
		pdTB.setReportdesc(form.getReportdesc());
		
		pdTB.setSerialgenerator(form.getSerialgenerator());
		
		
		//���̶�����Ϣ�������
		workFlowDefinitionBL.updateProcessDefinition(pdTB);
		
		//���̱���������
		if(StringUtils.isNotEmpty(form.getPtdid())){
			IG243Info ptdi = workFlowDefinitionBL.searchProcessTitleDefByPK(form.getPtdid());
			IG243TB ptdTB = (IG243TB)SerializationUtils.clone(ptdi);
			ptdTB.setPtitlename(form.getPtitlename());
			ptdTB.setPtitleaccess(form.getPtitleaccess());
			ptdTB.setPdescname(form.getPdescname());
			ptdTB.setPdescaccess(form.getPdescaccess());
			workFlowDefinitionBL.updateProcessTitleDef(ptdTB);
		}else{
			//������ǰû���ù������̽��в���
			workFlowDefinitionBL.registProcessTitleDef(form);
		}
        
		dto.addMessage(new ActionMessage( "IGCO10000.I005", message + "������Ϣ") );

		log.debug("========���̶�����Ϣ�����������========");
		return dto;
	}
	

	/**
	 * ����״̬��Ϣ�������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO updateProcessInfoDefAction(IGPRD01DTO dto) throws BLException {

		log.debug("========���̱���Ϣ�������ʼ========");
		IGPRD0111Form form = dto.getIgPRD0111Form();
		
		IG007Info pid = workFlowDefinitionBL.searchProcessInfoDefByKey(form.getPidid());
		//====> ��ܱ���Begin
		String message = "����";
		String pdid_one = StringUtils.isEmpty(pid.getPdid()) ? "0" : pid.getPdid().substring(0,1);
		if(IGPRDCONSTANTS.PRTYPE_YEAR_STATUS_ID.equals(pdid_one)
				|| IGPRDCONSTANTS.PRTYPE_SEASON_STATUS_ID.equals(pdid_one)
				|| IGPRDCONSTANTS.PRTYPE_IRREGULAR_STATUS_ID.equals(pdid_one)){
			message = "����";
			
		}
		//====> ��ܱ���End
		//�ж�״̬�����Ƿ��ظ�
		if(!pid.getPidlabel().equals(form.getPidlabel())) {
			IG007SearchCondImpl cond = new IG007SearchCondImpl();
			cond.setPidlabel(form.getPidlabel());
			cond.setPidid_notlike(form.getPidid());
			cond.setPdid(form.getPdid());
			// �ж��Ƿ�Ϊ�ӱ�
			if(StringUtils.isNotEmpty(form.getPpidid())){
				// һ�������²�ͬ�ı�������������ͬ�����������ӱ�
				cond.setPpidid(form.getPpidid());
			}else{
				cond.setTableColumn("N");
			}
			List<IG007Info> pInfoList = workFlowDefinitionBL.searchProcessInfoDef(cond);
			
			if(pInfoList != null && pInfoList.size() > 0 ){
				throw new BLException("IGPRD0111.E001","�������Ѵ���");
			}
		}
		//���ƶ���
		IG007TB pidTB = (IG007TB)SerializationUtils.clone(pid);
			
		pidTB.setPidlabel(form.getPidlabel());
		pidTB.setPidname(form.getPidlabel());
		pidTB.setPiddesc(form.getPiddesc());
		pidTB.setPidoption(form.getPidoption());
		pidTB.setPiddefault(form.getPiddefault());
		pidTB.setPidrequired(form.getPidrequired());
		pidTB.setPidmode(form.getPidmode());
		pidTB.setPrivatescope(form.getPrivatescope());
		pidTB.setRowwidth(form.getRowwidth());
		pidTB.setCcid(form.getCcid());//add by zhengyong 2012.10.15
		pidTB.setHasattach(form.getHasattach()); //add by wangtingzhi 2013.06.06
		// ��������ʾģʽ
		pidTB.setPiddisplay(form.getPiddisplay());
		// ������ʹ��ģʽ
		pidTB.setPiduse(form.getPiduse());
		// ���
		pidTB.setPidwidth(form.getPidwidth());
		// ����
		pidTB.setPidrows(form.getPidrows());
		// �Ƿ���������
		pidTB.setPidhide(form.getPidhide());
		//����λ
		pidTB.setPidunit(form.getPidunit());
		//�Ƿ������ע
		pidTB.setRemarks(form.getRemarks());
		//��ѡ��ѡ��ʾ��ʽ
		pidTB.setShowstyles(form.getShowstyles());
		
		
		pidTB.setShowrownum(form.getShowrownum()); // add by wangtingzhi 2013.07.22
		
		pidTB.setShowline(form.getShowline());
		
		pidTB.setTitledisplay(form.getTitledisplay());
		
		pidTB.setNeedidea(form.getNeedidea());
		
		pidTB.setJsfunction(form.getJsfunction());
		
		pidTB.setPidratio(form.getPidratio());
		
		pidTB.setPidsize(form.getPidsize());
		
		pidTB.setSelecedlast(form.getSelecedlast());
		
		pidTB.setNumbertype(form.getNumbertype());
		
		if("P".equals(pidTB.getPidtype())){
			pidTB.setCcid(form.getParticipantRoleType());
		}

		//���ֿؼ�
		if("7".equals(pidTB.getPidtype())) {
			//С��λ��
			pidTB.setPidoption(form.getDecimals());
		}
		if("F".equals(pidTB.getPidtype())){
			if(form.getFileMapMuti() != null && !form.getFileMapMuti().isEmpty()){
				if(StringUtils.isNotEmpty(pidTB.getPiddefault())){
					fileUploadBL.uploadFile(form.getFileMapMuti(),pidTB.getPiddefault());
				}else{
					String attkey = fileUploadBL.uploadFile(form.getFileMapMuti());
					pidTB.setPiddefault(attkey);
				}
			}
			if(form.getAttids() != null && form.getAttdel() != null){
				for(int i=0;i<form.getAttids().length;i++){
					if("Y".equals(form.getAttdel()[i])){
						Attachment att = attachmentBL.searchAttachmentByKey(Integer.parseInt(form.getAttids()[i]));
						attachmentBL.deleteAttachment(att);
					}
				}
			}
			if(StringUtils.isNotEmpty(pidTB.getPiddefault())){
				List<Attachment> list = attachmentBL.searchAttachmentsByAttkey(pidTB.getPiddefault());
				if(list.isEmpty()){
					pidTB.setPiddefault(null);
				}
			}
		}
		if("4".equals(pidTB.getPidtype())){
			if(form.getAsminfo() != null){
				StringBuffer asmids = new StringBuffer();
				for(int i=0;i<form.getAsminfo().length;i++){
					if(i > 0){
						asmids.append("#");
					}
					asmids.append(form.getAsminfo()[i]);
				}
				pidTB.setPiddefault(asmids.toString());
			}
		}
		pidTB.setAlign(form.getAlign());
		
		//����״̬��Ϣ�������
		IG007Info processInfoDef = workFlowDefinitionBL.updateProcessInfoDef(pidTB);
		//��Ա�������ɫ�޶�
		if("P".equals(processInfoDef.getPidtype())){
			//��ѯ��ɫ�޶���Ϣ
			List<IG008Info> pidrses = workFlowDefinitionBL.searchFormRoleScopeByPidid(processInfoDef.getPidid());
			Map<Integer, IG008Info> pidrsMap = new HashMap<Integer, IG008Info>();
			if(pidrses != null){
				for(IG008Info pidrs:pidrses){
					pidrsMap.put(pidrs.getRoleid(), pidrs);
				}
			}
			Map<Integer, IG008Info> hasMap = new HashMap<Integer, IG008Info>();
			List<IG008Info> addList = new ArrayList<IG008Info>();
			if(StringUtils.isNotEmpty(form.getParticipantRoles())){
				String[] infos = form.getParticipantRoles().split("_#_");
				for(String s:infos){
					String[] info = s.split("_sp_");
					Integer key = Integer.valueOf(info[1]);
					if(pidrsMap.get(key) == null){
						IG008TB entity = new IG008TB();
						entity.setPidid(processInfoDef.getPidid());
						entity.setRoleid(key);
						entity.setRolename(info[0]);
						addList.add(entity);
					}else{
						hasMap.put(key, pidrsMap.get(key));
					}
				}
			}
			if(addList.size() > 0){
				for(IG008Info entity:addList){
					workFlowDefinitionBL.registFormRoleScope(entity);
				}
			}
			List<IG008Info> delList = new ArrayList<IG008Info>();
			if(pidrses != null){
				for(IG008Info pidrs:pidrses){
					if(hasMap.get(pidrs.getRoleid()) == null){
						delList.add(pidrs);
					}
				}
			}
			if(delList.size() > 0){
				workFlowDefinitionBL.deleteFormRoleScope(delList);
			}
		}
		//====> ��ܱ���Begin
		dto.addMessage(new ActionMessage( "IGCO10000.I005", message + "������Ϣ") );
		//====> ��ܱ���End
		
		log.debug("========���̱���Ϣ�����������========");
		return dto;
	}
	
	/**
	 * �жϵ�ǰ�Ƿ����δ�رյ�������ʹ��ģ��
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO isProcessDefinitionInUse(IGPRD01DTO dto) throws BLException {
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		cond.setPrActive("Y");
		cond.setPrpdid(dto.getPdid());
		List<IG500Info> prlist = workFlowOperationBL.searchProcessRecord(cond);
		if(prlist!=null && prlist.size()>0){
			dto.setIsProcessDefinitionInUse(IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE);
		}else{
			if(!IGPRDCONSTANTS.PD_STATUS_ENABLE.equals(workFlowDefinitionBL.searchProcessDefinitionByKey(dto.getPdid()).getPdstatus())){
				dto.setIsProcessDefinitionInUse(IGPRDCONSTANTS.PROCESSDEFINITION_IS_NOT_IN_USE);
			} else {
				dto.setIsProcessDefinitionInUse(IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE);
			}
		}
		
		return dto;
	}
	
	/**
	 * ���̶�����Դ���
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO testProcessDefinitionAction(IGPRD01DTO dto) throws BLException {
		log.debug("========���̶�����Ϣ���Դ���ʼ========");
		IGPRD0102Form form = dto.getIgPRD0102Form();
		
		IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(form.getPdid());
		
		//���ƶ���
		IG380TB pdTB = (IG380TB)SerializationUtils.clone(pd);
		
		if(IGPRDCONSTANTS.PD_STATUS_TESTABLE.equals(form.getPdstatus())) {
			pdTB.setPdstatus(IGPRDCONSTANTS.PD_STATUS_TESTABLE);//����
			log.debug("========��������========");
			//���ֻ�п�ʼ�ͽ���״̬���ܲ���
			IG333SearchCondImpl cond = new IG333SearchCondImpl();
			cond.setPdid(pd.getPdid());
			List<IG333Info> psd = workFlowDefinitionBL.searchProcessStatusDef(cond);
			
			if(psd.size() < 3) {
				throw new BLException("IGPRD0102.E002");
			}
			//��������ͼ
			dto = this.initVmlAction(dto);	
			if(pd.getPdxml() == null){
				pdTB.setPdxml(dto.getImgxml());
			}
		}
		form.setPdid(null);
		form.setPdstatus(null);
		workFlowDefinitionBL.updateProcessDefinition(pdTB);
		log.debug("========���̶�����Ϣ���Դ�������========");
		return dto;
	}
	
	
	/**
	 * ���̶�����Ϣͣ��/���ô���
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO changeProcessDefinitionAction(IGPRD01DTO dto) throws BLException {
		log.debug("========���̶�����Ϣͣ��/���ô���ʼ========");
		IGPRD0102Form form = dto.getIgPRD0102Form();
		
		IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(form.getPdid());
		
		//���ƶ���
		IG380TB pdTB = (IG380TB)SerializationUtils.clone(pd);
		
		if(IGPRDCONSTANTS.PD_STATUS_DISABLE.equals(form.getPdstatus())) {
			if("TEST".equalsIgnoreCase(form.getFlag())){
				//�жϵ�ǰ�Ƿ����δ�رյ�������ʹ��ģ��
				IG500SearchCondImpl cond = new IG500SearchCondImpl();
				cond.setPrpdid(pd.getPdid());
				cond.setPrassetcategory(IGPRDCONSTANTS.PD_TEST_ID);
				List<IG500Info> prlist = workFlowOperationBL.searchProcessRecord(cond);
				for(IG500Info processRecord : prlist){
					workFlowOperationBL.delProcessRecord(processRecord.getPrid());
				}
			}else if("CHANGE".equalsIgnoreCase(form.getFlag())){
				//�жϵ�ǰ�Ƿ����δ�رյ�������ʹ��ģ��
				IG500SearchCondImpl cond = new IG500SearchCondImpl();
				cond.setPrActive("Y");
				cond.setPrpdid(pd.getPdid());
				List<IG500Info> prlist = workFlowOperationBL.searchProcessRecord(cond);
				if(prlist!=null && prlist.size()>0){
					throw new BLException("IGPRD0101.E001","�����̶������ڱ�ʹ�ò���ֹͣ");	
				}
				
				//ͣ�ò˵�
				if (!StringUtils.isEmpty(pdTB.getPdactname())) {
				    ActionSearchCondImpl actcond = new ActionSearchCondImpl();
	                actcond.setActname_like(pdTB.getPdactname());
	                List<Action> actionList = this.actionBL.searchAction(actcond);
	                for(Action action : actionList){
	                    ActionTB actionTB = (ActionTB)SerializationUtils.clone(action);
	                    actionTB.setActl1id(IGPRDCONSTANTS.ACTION_STATUS_STOP);
	                    this.actionBL.updateAction(actionTB);
	                }
				}
	            
			}
			pdTB.setPdstatus(IGPRDCONSTANTS.PD_STATUS_DISABLE);//ͣ��
			log.debug("========ͣ��========");
			dto.addMessage(new ActionMessage( "IGCO10000.I008", "����") );
		} else if(IGPRDCONSTANTS.PD_STATUS_ENABLE.equals(form.getPdstatus())) {
			pdTB.setPdstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);//����
			log.debug("========����========");
			//���ֻ�п�ʼ�ͽ���״̬��������
			IG333SearchCondImpl cond = new IG333SearchCondImpl();
			cond.setPdid(pd.getPdid());
			List<IG333Info> psd = workFlowDefinitionBL.searchProcessStatusDef(cond);
			
			if(psd.size() < 3) {
				throw new BLException("IGPRD0102.E001");
			}
			
			//�������δͣ�õľ��������Զ�ͣ�þ�����
			IG380SearchCondImpl condImpl = new IG380SearchCondImpl();
			condImpl.setPdid(form.getPdid());
			condImpl.setPdstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);
			condImpl.setSearchHistory("0");
			List<IG380Info> ig380InfoList = workFlowDefinitionBL.searchHistoryProcessDefinition(condImpl, 0, 0);
			for (IG380Info ig380info : ig380InfoList) {
			    IG380TB ig380tb = (IG380TB)SerializationUtils.clone(ig380info);
			    ig380tb.setPdstatus(IGPRDCONSTANTS.PD_STATUS_DISABLE);
			    workFlowDefinitionBL.updateProcessDefinition(ig380tb);
			}
			
			//��������ͼ
			dto = this.initVmlAction(dto);	
			if(pd.getPdxml() == null){
				pdTB.setPdxml(dto.getImgxml());
			}
			
			//ɾ������״̬�����ӵ�processRecord����ؼ�¼
			IG500SearchCondImpl prcond = new IG500SearchCondImpl();
			prcond.setPrpdid(pd.getPdid());
			prcond.setPrassetcategory(IGPRDCONSTANTS.PD_TEST_ID);
			List<IG500Info> prlist = workFlowOperationBL.searchProcessRecord(prcond);
			for(IG500Info processRecord : prlist){
				workFlowOperationBL.delProcessRecord(processRecord.getPrid());
			}
			
			//���ò˵�
			if (!StringUtils.isEmpty(pdTB.getPdactname())) {
				//��ѯ��ǰ�����������Ľ�ɫ����
				IG213SearchCondImpl ig213cond = new IG213SearchCondImpl();
				ig213cond.setPrtdid_like(pd.getPdid());
				List<IG213Info> lst_IG213Info = workFlowDefinitionBL.searchProcessRoleTypeDef(ig213cond);
				StringBuffer roletyBuffer = new StringBuffer(IGPRDCONSTANTS.ACTION_ROLE_TYPE);
				if(lst_IG213Info!=null){
					for(IG213Info ig213:lst_IG213Info){
						roletyBuffer.append(",").append(ig213.getRoletype());
					}
				}
			    ActionSearchCondImpl actcond = new ActionSearchCondImpl();
	            actcond.setActname_like(pdTB.getPdactname());
	            actcond.setActl1id(String.valueOf(IGPRDCONSTANTS.ACTION_STATUS_STOP));
	            List<Action> actionList = this.actionBL.searchAction(actcond);
	            if(actionList==null||actionList.isEmpty()){
	            	int sortid = new Integer(pdTB.getPdactname().substring(8, 10)) + 1;
	    		    ActionTB actionTB = new ActionTB();
	    	        actionTB.setActname(pdTB.getPdactname());
	    	        actionTB.setActlabel(pdTB.getPdname() + IGPRDCONSTANTS.ACTION_LABEL_MANAGE);
	    	        actionTB.setActtype(IGPRDCONSTANTS.ACTION_TYPE_2);
	    	        actionTB.setActroletype(IGPRDCONSTANTS.ACTION_ROLE_TYPE+roletyBuffer.toString());
	    	        actionTB.setActsortid(pdTB.getPdactname().substring(3, 5) + sortid);
	    	        actionTB.setActurltype(IGPRDCONSTANTS.ACTION_URL_TYPE);
	    	        this.actionBL.registAction(actionTB);
	    	        
	    	        ActionTB actionTB1 = new ActionTB();
	    	        actionTB1.setActname(pdTB.getPdactname() + IGPRDCONSTANTS.ACTION_LABEL_INIT_NUM);
	    	        actionTB1.setActlabel(pdTB.getPdname() + IGPRDCONSTANTS.ACTION_LABEL_INIT);
	    	        actionTB1.setActurl("/IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid="+form.getPdid().substring(0,5)+"&ptid=8");
	    	        actionTB1.setActtype(IGPRDCONSTANTS.ACTION_TYPE_3);
	    	        actionTB1.setActroletype(IGPRDCONSTANTS.ACTION_ROLE_TYPE+roletyBuffer.toString());
	    	        actionTB1.setActsortid(pdTB.getPdactname().substring(3, 5) + sortid + IGPRDCONSTANTS.ACTION_LABEL_INIT_NUM);
	    	        actionTB1.setActurltype(IGPRDCONSTANTS.ACTION_URL_TYPE);
	    	        this.actionBL.registAction(actionTB1);
	    	        
	    	        ActionTB actionTB2 = new ActionTB();
	    	        actionTB2.setActname(pdTB.getPdactname() + IGPRDCONSTANTS.ACTION_LABEL_SEARCH_NUM);
	    	        actionTB2.setActlabel(pdTB.getPdname() + IGPRDCONSTANTS.ACTION_LABEL_SEARCH);
	    	        actionTB2.setActurl("/IGCOM0202.do?linkID=IGWKM0103&prtype=WD&prpdid=" + form.getPdid().substring(0,5));
	    	        actionTB2.setActtype(IGPRDCONSTANTS.ACTION_TYPE_3);
	    	        actionTB2.setActroletype(IGPRDCONSTANTS.ACTION_ROLE_TYPE+roletyBuffer.toString());
	    	        actionTB2.setActsortid(pdTB.getPdactname().substring(3, 5) + sortid + IGPRDCONSTANTS.ACTION_LABEL_SEARCH_NUM);
	    	        actionTB2.setActurltype(IGPRDCONSTANTS.ACTION_URL_TYPE);
	    	        this.actionBL.registAction(actionTB2);
	            }else{
	            	for(Action action : actionList){
	            		ActionTB actionTB = (ActionTB)SerializationUtils.clone(action);
	            		actionTB.setActl1id(null);
	            		actionTB.setActroletype(IGPRDCONSTANTS.ACTION_URL_TYPE+roletyBuffer.toString());
	            		this.actionBL.updateAction(actionTB);
	            	}
	            }
	            //����һ���˵���Ϣ
	            //��ѯһ���˵�
	            Action stairAction = actionBL.searchActionByKey(pdTB.getPdactname().substring(0,8));
	            StringBuffer stairBuffer = new StringBuffer();
				if(stairAction!=null&&lst_IG213Info!=null){
					for(IG213Info ig213:lst_IG213Info){
						if(!stairAction.getActroletype().contains(ig213.getRoletype())){
							stairBuffer.append(",").append(ig213.getRoletype());
						}
					}
				}
				//����һ���˵�
				if(StringUtils.isNotEmpty(stairBuffer.toString())){
					ActionTB stairActionTB = (ActionTB) SerializationUtils.clone(stairAction);
					stairActionTB.setActroletype(stairActionTB.getActroletype()+stairBuffer.toString());
					this.actionBL.updateAction(stairActionTB);
				}
			}
			
			dto.addMessage(new ActionMessage( "IGCO10000.I009", "����") );
		}
		form.setPdid(null);
		form.setPdstatus(null);
		workFlowDefinitionBL.updateProcessDefinition(pdTB);
		log.debug("========���̶�����Ϣͣ��/���ô�������========");
		return dto;
	}
	
	/**
	 * ���̶�����Ϣ�����ʼ������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO initIGPRD0102Action(IGPRD01DTO dto) throws BLException {
		log.debug("========���̶�����Ϣ�����ʼ������ʼ========");
		
		IGPRD0102Form form = dto.getIgPRD0102Form();
		
		IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(form.getPdid());
		
		form.setPdname(pd.getPdname());
		
		form.setPermission(pd.getPermission());
		
		form.setPddesc(pd.getPddesc());
		
		form.setPdname_bak(pd.getPdname());
		
		form.setSerialgenerator(pd.getSerialgenerator());
		
		form.setReportdesc(pd.getReportdesc());
		
		form.setPdactname(StringUtils.isEmpty(pd.getPdactname()) ? null : pd
                .getPdactname().substring(0, 8));
		IG259Info pt = workFlowDefinitionBL.searchProcessTemplateByKey(pd.getPtid());
		form.setPttype(pt.getPttype());

		//�������������ѯ����
		IG243SearchCondImpl cond = new IG243SearchCondImpl();
		cond.setPdid(form.getPdid());
		List<IG243Info> lstProcessTitleDef = workFlowDefinitionBL.searchProcessTitleDef(cond);
		if(lstProcessTitleDef == null || lstProcessTitleDef.size() == 0){
			form.setPtdid("");//����
		}else{
			form.setPtdid(lstProcessTitleDef.get(0).getPtdid());//����
			form.setPtitlename(lstProcessTitleDef.get(0).getPtitlename());//��������
			form.setPtitleaccess(lstProcessTitleDef.get(0).getPtitleaccess());//���������Ƿ�ɼ�
			form.setPdescname(lstProcessTitleDef.get(0).getPdescname());//��������
			form.setPdescaccess(lstProcessTitleDef.get(0).getPdescaccess());//���������Ƿ�ɼ�
		}
		
		log.debug("========���̶�����Ϣ�����ʼ����������========");
		return dto;
	}
	
	//-----------------------------------------------------------����Ϣ----------------------------------------------------------------------
	
	/**
	 * ����Ϣ��Ϣ��ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessInfoDefAction(IGPRD01DTO dto) throws BLException {
		
		log.debug("========����Ϣ��Ϣ��ѯ����ʼ========");
		
		if(StringUtils.isNotEmpty(dto.getProcessInfoDefSearchCond().getPpidid())){
			IG007Info pid = workFlowDefinitionBL.searchProcessInfoDefByKey(dto.getProcessInfoDefSearchCond().getPpidid());
			dto.setProcessInfoDef(pid);
		}
		
		//����Ϣ��Ϣ��ѯ����ȡ�� 
		int totalCount = workFlowDefinitionBL.getProcessInfoDefSearchCount(dto.getProcessInfoDefSearchCond());
		
		if (totalCount == 0) {
			log.debug("========����Ϣ��Ϣ��ѯ���ݲ�����========");
			//����Ϣ��Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========����Ϣ��Ϣ��ѯ���ݼ�������========");
			//����Ϣ��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		
		
		//��ǰҳ����Ϣ��Ϣȡ��
		List<IG007Info> processInfoDefList = workFlowDefinitionBL.searchProcessInfoDef(dto.getProcessInfoDefSearchCond(), 0, 0);
		
		
		dto.setProcessInfoDefList(processInfoDefList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========����Ϣ��Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * ���ӹ�ͨ������ʼ����ѯҳ��IGPRD0119��
	 */
	public IGPRD01DTO searchProcessInfoDefGeneralActionFor0119(IGPRD01DTO dto) throws BLException {
		
		log.debug("========��ͨ������Ϣ��ѯ����ʼ========");
		
		//����Ϣ��Ϣ��ѯ����ȡ�� 
		int totalCount = workFlowDefinitionBL.getProcessInfoDefGeneralSearchCount(dto.getProcessInfoDefGeneralSearchCond());
		
		if (totalCount == 0) {
			log.debug("========��ͨ������Ϣ��ѯ���ݲ�����========");
			//����Ϣ��Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========��ͨ������Ϣ��ѯ���ݼ�������========");
			//����Ϣ��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		
		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		
		//��ǰҳ����Ϣ��Ϣȡ��
		List<IG202Info> processInfoDefGeneralList = workFlowDefinitionBL.searchProcessInfoDefGeneral(dto.getProcessInfoDefGeneralSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setProcessInfoDefGeneralList(processInfoDefGeneralList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========��ͨ������Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * ѡ��ͨ������ʼ����ѯҳ��IGPRD0122��
	 */
	public IGPRD01DTO searchProcessInfoDefGeneralAction(IGPRD01DTO dto) throws BLException {
		
		log.debug("========��ͨ������Ϣ��ѯ����ʼ========");
		
		//����Ϣ��Ϣ��ѯ����ȡ�� 
		int totalCount = workFlowDefinitionBL.getProcessInfoDefGeneralVWSearchCount(dto.getProcessInfoDefGeneralSearchCond());
		
		if (totalCount == 0) {
			log.debug("========��ͨ������Ϣ��ѯ���ݲ�����========");
			//����Ϣ��Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========��ͨ������Ϣ��ѯ���ݼ�������========");
			//����Ϣ��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		
		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		
		//��ǰҳ����Ϣ��Ϣȡ��
		List<IG202Info> processInfoDefGeneralList = workFlowDefinitionBL.searchProcessInfoDefGeneralVW(dto.getProcessInfoDefGeneralSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setProcessInfoDefGeneralList(processInfoDefGeneralList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========��ͨ������Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * ����Ϣ��Ϣ�ǼǴ���
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO insertProcessInfoDefAction(IGPRD01DTO dto) throws BLException {
		
		log.debug("========����Ϣ��Ϣ�ǼǴ���ʼ========");
		
		IGPRD0111Form form = dto.getIgPRD0111Form();
		
		if(StringUtils.isNotEmpty(form.getPdid())) {
			//�ж�״̬�����Ƿ��ظ�
			IG007SearchCondImpl cond = new IG007SearchCondImpl();
			cond.setPidlabel(form.getPidlabel());
			cond.setPdid(form.getPdid());
			// �ж��Ƿ�Ϊ�ӱ�
			if(StringUtils.isNotEmpty(form.getPpidid())){
				// һ�������²�ͬ�ı�������������ͬ�����������ӱ�
				cond.setPpidid(form.getPpidid());
			}else{
				cond.setTableColumn("N");
			}
			List<IG007Info> pInfoList = workFlowDefinitionBL.searchProcessInfoDef(cond);
			
			if(pInfoList != null && pInfoList.size() > 0 ){
				throw new BLException("IGPRD0111.E001","�������Ѵ���");
			}
			
			if("P".equals(form.getPidtype())){
				form.setCcid(form.getParticipantRoleType());
			}
			form.setPidname(form.getPidlabel());
			//���ֿؼ�
			if("7".equals(form.getPidtype())) {
				//С��λ��
				form.setPidoption(form.getDecimals());
			}
			
			form.setPidid(workFlowDefinitionBL.getProcessInfoDefPK(form.getPdid()));
			if("F".equals(form.getPidtype())){
				if(form.getFileMapMuti() != null && !form.getFileMapMuti().isEmpty()){
					String attkey = fileUploadBL.uploadFile(form.getFileMapMuti());
					form.setPiddefault(attkey);
				}
			}
			if("4".equals(form.getPidtype())){
				if(form.getAsminfo() != null){
					StringBuffer asmids = new StringBuffer();
					for(int i=0;i<form.getAsminfo().length;i++){
						if(i > 0){
							asmids.append("#");
						}
						asmids.append(form.getAsminfo()[i]);
					}
					form.setPiddefault(asmids.toString());
				}
			}
			
			//����Ϣ��Ϣ�ǼǴ���
			IG007Info pid = workFlowDefinitionBL.registProcessInfoDef(form);
			//��ʼ��״̬��˽�б�Ĭ��ֵ
            if(StringUtils.isNotEmpty(form.getPidmode())&&"2".equals(form.getPidmode())&&StringUtils.isNotEmpty(pid.getPiddefault())){
                workFlowDefinitionBL.saveOrUpdateStatusDefault(pid.getPiddefault(),true,null,pid.getPidid());
            }       
			//��Ա�������ɫ��Χ�޶�
			if("P".equals(pid.getPidtype())){
				if(StringUtils.isNotEmpty(form.getParticipantRoles())){
					String[] infos = form.getParticipantRoles().split("_#_");
					for(String s:infos){
						String[] info = s.split("_sp_");
						IG008TB entity = new IG008TB();
						entity.setPidid(pid.getPidid());
						entity.setRoleid(Integer.valueOf(info[1]));
						entity.setRolename(info[0]);
						workFlowDefinitionBL.registFormRoleScope(entity);
					}
				}
			}
		} else {
			throw new BLException("IGCO10000.E004","���̶������");
		}
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "��������Ϣ") );
		
		log.debug("========����Ϣ��Ϣ�ǼǴ�������========");
		return dto;
	}
	
	public IGPRD01DTO insertProcessInfoDefFromProcessInfoDefGeneralAction(IGPRD01DTO dto) throws BLException {
		
		log.debug("========��ͨ���������Ϣ��������ʼ========");
		
		IGPRD0118Form form = dto.getIgPRD0118Form();
		String pidgids[]= form.getPidgid();
		for(String pidgid : pidgids){
			IG202Info processInfoDefGeneral= workFlowDefinitionBL.searchProcessInfoDefGeneralByKey(Integer.valueOf(pidgid));
			IG007TB processInfoDef = new IG007TB();
			processInfoDef.setPidid(workFlowDefinitionBL.getProcessInfoDefPK(form.getPdid()));
			processInfoDef.setPdid(form.getPdid());
			processInfoDef.setPidname(processInfoDefGeneral.getPidname());
			processInfoDef.setPidlabel(processInfoDefGeneral.getPidlabel());
			processInfoDef.setPiddesc(processInfoDefGeneral.getPiddesc());
			processInfoDef.setPidtype(processInfoDefGeneral.getPidtype());
			processInfoDef.setPidoption(processInfoDefGeneral.getPidoption());
			processInfoDef.setPiddefault(processInfoDefGeneral.getPiddefault());
			processInfoDef.setPidrequired(processInfoDefGeneral.getPidrequired());
			processInfoDef.setPidsortid(processInfoDefGeneral.getPidsortid());
			processInfoDef.setPidgid(processInfoDefGeneral.getPidid());
			processInfoDef.setPidmode(processInfoDefGeneral.getPidmode());
			processInfoDef.setPrivatescope(processInfoDefGeneral.getPrivatescope());
			processInfoDef.setRowwidth(processInfoDefGeneral.getRowwidth());
			workFlowDefinitionBL.registProcessInfoDef(processInfoDef);
		}
		
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "����Ϣ������Ϣ") );
		
		log.debug("========��ͨ���������Ϣ������������========");
		return dto;
	}
	
	public IGPRD01DTO insertProcessInfoDefGeneralAction(IGPRD01DTO dto) throws BLException {
		
		log.debug("========����Ϣ��Ϣ�ǼǴ���ʼ========");
		
		IGPRD0118Form form = dto.getIgPRD0118Form();
		
		//�ж�״̬�����Ƿ��ظ�
		IG202SearchCondImpl cond = new IG202SearchCondImpl();
		cond.setPidlabel(form.getPidlabel());
		List<IG202Info> pInfoList = workFlowDefinitionBL.searchProcessInfoDefGeneral(cond,0,0);
		if(pInfoList != null && pInfoList.size() > 0 ){
			throw new BLException("IGPRD0111.E001","�������Ѵ���");
		}
		form.setPidname(form.getPidlabel());
		
		//����Ϣ��Ϣ�ǼǴ���
		workFlowDefinitionBL.registProcessInfoDefGeneral(form);
	
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "��������Ϣ") );
		
		log.debug("========����Ϣ��Ϣ�ǼǴ�������========");
		return dto;
	}
	
	/**
	 * ����Ϣ��Ϣɾ������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO deleteProcessInfoDefAction(IGPRD01DTO dto) throws BLException {

		log.debug("========����Ϣ��Ϣɾ������ʼ========");
		IGPRD0111Form form = dto.getIgPRD0111Form();

		//��Ҫ�ֶ�ɾ��IG334��IG335�Լ�IG237�����pidid��ID����Ӧ����
		deleteDataForCascades(form.getPidid());
		//����Ϣ��Ϣɾ������
		workFlowDefinitionBL.deleteProcessInfoDefByKey(form.getPidid());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I006", "��������Ϣ") );

		log.debug("========����Ϣ��Ϣɾ����������========");
		return dto;
	}

	/**
	 * ����pidid��IDɾ����Ӧ�ı�֪ͨ����
	 * @param pidid
	 * @throws BLException 
	 */
	private void deleteDataForCascades(String pidid) throws BLException {
		log.debug("=============ɾ�����̱��ֶ�����ɾ�������֪ͨ���Կ�ʼ=============");
		//���̶���ID
		String pdid = "";
		//ɾ��IG334�������Ϣ
		IG334SearchCondImpl ig334Cond = new IG334SearchCondImpl();
		ig334Cond.setPidid_eq(pidid);
		List<IG334Info> ig334List = workFlowDefinitionBL.searchInformStrategy(ig334Cond);
		if(ig334List != null && ig334List.size() > 0){
			//����ָ�ӳ���һ�м�¼
			for(IG334Info ig334 : ig334List){
				//ɾ��IG335�������Ϣ
				IG335SearchCondImpl ig335Cond = new IG335SearchCondImpl();
				ig335Cond.setPidid_eq(pidid);
				List<IG335Info> ig335List = workFlowDefinitionBL.searchFormStrategy(ig335Cond);
				if(ig335List != null && ig335List.size() > 0){
					for(IG335Info ig335 : ig335List){
						String psdid = ig335.getPsdid();//��ȡ����״̬������Ϣ
						pdid = ig335.getPdid();//��ȡ���̶���ID
						//ɾ��IG237�������Ϣ
						IG237SearchCondImpl ig237Cond = new IG237SearchCondImpl();
						ig237Cond.setPsdid(psdid);
						List<IG237Info> ig237List = workFlowDefinitionBL.searchProcessNoticeStrategyUserInfo(ig237Cond);
						if(ig237List != null && ig237List.size() > 0){
							for(IG237Info ig237 : ig237List){
								workFlowDefinitionBL.deleteProcessNoticeStrategyUserInfo(ig237);
							}
						}
					}
					//IG335�����ݽ���ɾ������
					workFlowDefinitionBL.deleteFormStrategy(ig335List);
				}
				//IG334�����ݽ���ɾ������
				workFlowDefinitionBL.deleteInformStrategy(ig334);
				
				if(StringUtils.isNotEmpty(pdid)){
					//ɾ��IG212�������Ϣ
					IG212SearchCondImpl ig212Cond = new IG212SearchCondImpl();
					ig212Cond.setPdid(pdid);
					List<IG212Info> ig212List = ig212BL.searchIG212Info(ig212Cond);
					if(ig212List != null && ig212List.size() > 0){
						//������Ӧ������Ϣʱ�����ֶ�����ɾ������
						for(IG212Info ig212 : ig212List){
							//ɾ����Ӧ��IG212������
							ig212BL.deleteIG212Info(ig212);
						}
					}
				}
			}
		}
		log.debug("=============ɾ�����̱��ֶ�����ɾ�������֪ͨ���Խ���=============");
	}

	/**
	 * ����Ϣ��Ϣɾ������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO orderProcessInfoDefAction(IGPRD01DTO dto) throws BLException {

		log.debug("========����Ϣ��������ʼ========");
		IGPRD0111Form form = dto.getIgPRD0111Form();
		String pididorder = form.getPididorder();
		if(StringUtils.isEmpty(pididorder)){
//			dto.addMessage(new ActionMessage( "IGCO10000.I011", "����Ϣ������Ϣ") );
			dto.addMessage(new ActionMessage( "IGCO10000.I010", "����Ϣ����") );
			log.debug("========����Ϣ��Ϣ����������========");
			return dto;
		}
		String[] keyvalue = pididorder.split("\\|");
		String[] pidids = new String[keyvalue.length];//����pidid
		String[] orders = new String[keyvalue.length];//��Ӧ˳��
		for(int i = 0; i < keyvalue.length; i++){
			String value = keyvalue[i];
			if(StringUtils.isNotEmpty(value)){
				if(value.split(":").length == 2){
					pidids[i] = value.split(":")[1];
					orders[i] = value.split(":")[0].length() == 2 ? value.split(":")[0] : "0"+value.split(":")[0];
				}
			}
		}
		List<IG007Info> infoList = workFlowDefinitionBL.searchProcessInfoDefsByPdid(form.getPdid());
		if(infoList == null || infoList.size() == 0){
			log.debug("========����Ϣ��Ϣ����������========");
			return dto;
		}
		for(int i=0; i< infoList.size(); i++){
			IG007Info info = infoList.get(i);
			for(int j= 0 ; j< pidids.length; j++){
				if(info.getPidid().equalsIgnoreCase(pidids[j])){
					if(!info.getPidsortid().equalsIgnoreCase(orders[j])){
						IG007TB tb = (IG007TB)SerializationUtils.clone(info);
						tb.setPidsortid(orders[j]);
						workFlowDefinitionBL.updateProcessInfoDef(tb);
					}
					break;
				}
			}
		} 
		//dto.addMessage(new ActionMessage( "IGCO10000.I011", "����Ϣ������Ϣ") );
		dto.addMessage(new ActionMessage( "IGCO10000.I010", "����Ϣ����") );
		log.debug("========����Ϣ��Ϣ����������========");
		return dto;
	}
	
	public IGPRD01DTO deleteProcessInfoDefGeneralAction(IGPRD01DTO dto) throws BLException {

		log.debug("========����Ϣ��Ϣɾ������ʼ========");
		IGPRD0118Form form = dto.getIgPRD0118Form();
		IG007SearchCondImpl pdcond = new IG007SearchCondImpl();
		pdcond.setPidgid(form.getPidid());
		List<IG007Info> pdlist = workFlowDefinitionBL.searchProcessInfoDef(pdcond);
		if(pdlist!=null&&pdlist.size()>0)
		{
			dto.addMessage(new ActionMessage( "IGCO10000.E025", "��ͨ��������Ϣ") );
			dto.setDelFalg("no");
		}else{
			//����Ϣ��Ϣɾ������
			workFlowDefinitionBL.deleteProcessInfoDefGeneralByKey(form.getPidid());
			dto.addMessage(new ActionMessage( "IGCO10000.I006", "��ͨ��������Ϣ") );
		}
		

		log.debug("========����Ϣ��Ϣɾ����������========");
		return dto;
	}
	
	//-----------------------------------------------------------ǰ����----------------------------------------------------------------------
	/**
	 * ǰ�����ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchPreProcessEventDefAction(IGPRD01DTO dto) throws BLException {
		
		log.debug("========������Ϣ��ѯ����ʼ========");
		IGPRD0126Form form = dto.getIgPRD0126Form();
		//��ȡ����״̬��Ϣ
		
	    IG413SearchCondImpl processEventDefSearchCondImpl = new IG413SearchCondImpl();
		processEventDefSearchCondImpl.setPdid(form.getPdid());
		processEventDefSearchCondImpl.setPsdid(form.getPsdid());
		List<IG413Info> processEventDefList = workFlowDefinitionBL.searchWorkFlowEventHandler(processEventDefSearchCondImpl);
	
        //����ǰ������Ϣ
		dto.setProcessEventDefList(processEventDefList);
	
		log.debug("========������Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * ��ť�¼������ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessStatusButtonDefAction(IGPRD01DTO dto) throws BLException {
		
		log.debug("========��ť�¼������ѯ����ʼ========");
		IGPRD0141Form form = dto.getIgPRD0141Form();
		//��ѯ��ţ������Ϣ
	    IG156SearchCondImpl cond = new IG156SearchCondImpl();
	    cond.setPdid(form.getPdid());
	    cond.setPsdid(form.getPsdid());
		List<IG156Info> processStatusButtonDefList = workFlowDefinitionBL.searchProcessStatusButtonDef(cond);
	
        //����ǰ������Ϣ
		dto.setProcessStatusButtonDefList(processStatusButtonDefList);
	
		log.debug("========��ť�¼������ѯ��������========");
		return dto;
	}
	/**
	 * ��ť�¼������ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessStatusButtonDefByPK(IGPRD01DTO dto) throws BLException {
		
		log.debug("========��ť�¼������ѯ����ʼ========");
		IGPRD0141Form form = dto.getIgPRD0141Form();
		//��ȡ����״̬��Ϣ
		IG156Info info = workFlowDefinitionBL.searchProcessStatusButtonDefByKey(form.getPseid());
	
		form.setPsebuttonid(info.getPsebuttonid());
		form.setPseactionid(info.getPseactionid());
		form.setPseorder(info.getPseorder());
		form.setPsedec(info.getPsedec());
		form.setPdid(info.getPdid());
		form.setPsdid(info.getPsdid());
		form.setPsbdname(info.getPsbdname());
		
        //����ǰ������Ϣ
		dto.setIgPRD0141Form(form);
	
		log.debug("========��ť�¼������ѯ��������========");
		return dto;
	}
	
	/**
	 * ǰ������Ӳ�ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO insertPreProcessEventDefAction(IGPRD01DTO dto) throws BLException {
		
		log.debug("========ǰ������Ӳ�ѯ����ʼ========");
		IGPRD0126Form form = dto.getIgPRD0126Form();
		//��ȡ����״̬��Ϣ
		IG413TB processEventDef = new IG413TB();
		processEventDef.setPedid(workFlowDefinitionBL.getWorkFlowEventHandlerPK(form.getPsdid()));
		processEventDef.setPdid(form.getPdid());
		processEventDef.setPsdid(form.getPsdid());
		processEventDef.setPedactionid(form.getPedactionid());	
		processEventDef.setPedblid(form.getPedblid());
		processEventDef.setPedtype(form.getPedtype());
		processEventDef.setPedorder(form.getPedorder());
		processEventDef.setPedec(form.getPedec());
		workFlowDefinitionBL.registWorkFlowEventHandler(processEventDef);
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "�¼���������") );
	  
		log.debug("========ǰ������Ӳ�ѯ��������========");
		return dto;
	}
	
	/**
	 * ǰ������Ӳ�ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO insertProcessStatusButtonDefAction(IGPRD01DTO dto) throws BLException {
		
		log.debug("========��ť�¼�������Ӳ�ѯ����ʼ========");
		IGPRD0141Form form = dto.getIgPRD0141Form();
		//��ȡ����״̬��Ϣ
		IG156TB tb = new IG156TB();
		tb.setPseid(workFlowDefinitionBL.getProcessStatusButtonDefPK(form.getPsdid()));
		tb.setPdid(form.getPdid());
		tb.setPsdid(form.getPsdid());
		tb.setPsebuttonid(form.getPsebuttonid());
		tb.setPseactionid(form.getPseactionid());
		tb.setPseorder(form.getPseorder());
		tb.setPsedec(form.getPsedec());
		tb.setPsbdname(form.getPsbdname());
		workFlowDefinitionBL.registProcessStatusButtonDef(tb);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "��ť�¼�����") );
		log.debug("========��ť�¼�������Ӳ�ѯ��������========");
		return dto;
	}
	/**
	 * ǰ������Ӳ�ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO updatePreProcessEventDefAction(IGPRD01DTO dto) throws BLException {
		
		log.debug("========ǰ�����޸Ĵ���ʼ========");
		IGPRD0126Form form = dto.getIgPRD0126Form();
		//��ȡ����״̬��Ϣ
		IG413TB processEventDef = new IG413TB();
		processEventDef.setPedid(form.getPedid());
		processEventDef.setPdid(form.getPdid());
		processEventDef.setPsdid(form.getPsdid());
		processEventDef.setPedactionid(form.getPedactionid());	
		processEventDef.setPedblid(form.getPedblid());
		processEventDef.setPedtype(form.getPedtype());
		processEventDef.setPedorder(form.getPedorder());
		processEventDef.setPedec(form.getPedec());
		workFlowDefinitionBL.updateWorkFlowEventHandler(processEventDef);
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "�¼���������") );
	  
		log.debug("========ǰ�����޸Ĵ�������========");
		return dto;
	}
	
	/**
	 * ǰ������Ӳ�ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO updateProcessStatusButtonDefAction(IGPRD01DTO dto) throws BLException {
		
		log.debug("========��ť�¼��޸Ĵ���ʼ========");
		IGPRD0141Form form = dto.getIgPRD0141Form();
		//��ȡ����״̬��Ϣ
		IG156TB info = new IG156TB();
		info.setPseid(form.getPseid());
		info.setPdid(form.getPdid());
		info.setPsdid(form.getPsdid());
		info.setPsebuttonid(form.getPsebuttonid());
		info.setPseactionid(form.getPseactionid());
		info.setPseorder(form.getPseorder());
		info.setPsedec(form.getPsedec());
		info.setPsbdname(form.getPsbdname());
		workFlowDefinitionBL.updateProcessStatusButtonDef(info);
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "��ť�¼�����") );
	  
		log.debug("========��ť�¼��޸Ĵ�������========");
		return dto;
	}
	
	/**
	 * ǰ������Ӳ�ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO deletePreProcessEventDefAction(IGPRD01DTO dto) throws BLException {
		
		log.debug("========ǰ����ɾ����ѯ����ʼ========");
		//��ȡ����״̬��Ϣ
		workFlowDefinitionBL.deleteWorkFlowEventHandlerByKey(dto.getIgPRD0126Form().getPedid()); 
		dto.addMessage(new ActionMessage( "IGCO10000.I006", "�¼���������") );
		log.debug("========ǰ����ɾ����ѯ��������========");
		
		return dto;
	}
	/**
	 * ǰ������Ӳ�ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO deleteProcessStatusButtonDefAction(IGPRD01DTO dto) throws BLException {
		
		log.debug("=======��ť�¼�ɾ����ѯ����ʼ========");
		IGPRD0141Form form = dto.getIgPRD0141Form();
		//��ȡ����״̬��Ϣ
		workFlowDefinitionBL.deleteProcessStatusButtonDefByPK(form.getPseid());
		dto.addMessage(new ActionMessage( "IGCO10000.I006", "��ť�¼�����") );
		log.debug("=========��ť�¼�ɾ����ѯ��������========");
		
		return dto;
	}
	
	//-----------------------------------------------------------������----------------------------------------------------------------------
	
	/**
	 * ��������Ϣ��ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessTransitionDefAction(IGPRD01DTO dto) throws BLException {
		
		log.debug("========��������Ϣ��ѯ����ʼ========");
		
		IGPRD0109Form form = dto.getIgPRD0109Form();
		
		IG725SearchCondImpl buttonCondImpl = new IG725SearchCondImpl();
		buttonCondImpl.setPsdid(form.getFpsdid());
		List<IG725Info> defInfoList = workFlowDefinitionBL.searchParticipantDefaultButtonDef(buttonCondImpl);
		if(defInfoList !=null && defInfoList.size()>0)
		{
			dto.setParticipantDefaultButtonDefInfoList(defInfoList);
		}else{
			List<IG725Info> lstInfo = new ArrayList<IG725Info>();
			dto.setParticipantDefaultButtonDefInfoList(lstInfo);
		}

		if(StringUtils.isNotEmpty(form.getFpsdid())){
			//��ȡ��ǰ״̬��Ϣ
			IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(form.getFpsdid());
			
			dto.setProcessStatusDef(psd);
			
			//��ȡ��ǰ��������״̬��Ϣ
			IG333SearchCondImpl psdCond = new IG333SearchCondImpl();
			
			psdCond.setPdid(psd.getPdid());
			if (StringUtils.isEmpty(nullToString(form.getPpsdid()))) {
				psdCond.setFatherflag("Y");
			} else {
				psdCond.setPpsdid(form.getPpsdid());
			}
			
			List<IG333Info> psdList = workFlowDefinitionBL.searchProcessStatusDef(psdCond);
			
			//����ԾǨ״̬�����б�
			List<LabelValueBean> labelList = new ArrayList<LabelValueBean>();
			
			for(IG333Info o : psdList){
				//process0001_begin
//				//����ԾǨ������״̬
//				if(!IGPRDCONSTANTS.PROCESS_START_STATUS.equals(psd.getPsdcode()) 
//						&& IGPRDCONSTANTS.PROCESS_START_STATUS.equals(o.getPsdcode())) {
//					continue;
//				}
				//process0001_end
				//���˵�ǰ״̬
				if(!o.getPsdid().equals(psd.getPsdid())) {
//					//ֻ�пɷ��ɽڵ����ԾǨ�����нڵ㣬���ǿɷ��ɽڵ��ԾǨ���Ľڵ�����Ҫ���˲��нڵ�
//					if(IGPRDCONSTANTS.PROCESS_NODE_TYPE_ASSIGN.equals(psd.getPsdtype())) {
//						labelList.add(new LabelValueBean(o.getPsdname(),o.getPsdid().toString()));
//					} else {
//						if(!IGPRDCONSTANTS.PROCESS_NODE_TYPE_CONCURRENCY.equals(o.getPsdtype())) {
//							labelList.add(new LabelValueBean(o.getPsdname(),o.getPsdid().toString()));
//						}
//					}
					labelList.add(new LabelValueBean(o.getPsdname(),o.getPsdid().toString()));
				}
			}
			
			dto.setLabelList(labelList);
			
			//��ȡ��������Ϣ
			IG273SearchCondImpl ptdCond = new IG273SearchCondImpl(); 
			
			ptdCond.setFpsdid(form.getFpsdid());
			
			//�Ƿ�ȱʡ������
			if("1".equals(form.getFlag())) {
				ptdCond.setDefaultRule(true);
			} else {
				ptdCond.setNotDefaultRule(true);
			}
			
			List<IG273Info> ptdList = workFlowDefinitionBL.searchProcessTransitionDef(ptdCond);
			
			//ԾǨ����ת��������
			for(IG273Info ptd : ptdList) {
				if(StringUtils.isNotEmpty(ptd.getPtdcond())) {
					((IG273TB)ptd).setPtdcondinfo(this.convertPtdCondInfo(ptd,dto.getParticipantDefaultButtonDefInfoList()));
				} else {
					throw new BLException("IGCO10000.E004","ԾǨ����");
				}
			}
			
			dto.setProcessTransitionDefList(ptdList);
			
			//�Ƿ�ȱʡ������
			if("1".equals(form.getFlag())) {
				//��ȡ����״̬ȱʡ������Ϣ
				IG725SearchCondImpl cond = new IG725SearchCondImpl();
				cond.setPsdid(form.getFpsdid());
				List<IG725Info> infoList = workFlowDefinitionBL.searchParticipantDefaultButtonDef(cond);
				dto.setParticipantDefaultButtonDefInfoList(infoList);
				
			} else {
				//��ȡ����״̬��������Ϣ
				IG222SearchCondImpl ppdCond = new IG222SearchCondImpl();
				ppdCond.setPsdid(form.getFpsdid());
				List<IG222Info> lstDef = workFlowDefinitionBL.searchParticipantDef(ppdCond);
				dto.setProcessParticipantDefList(lstDef);
				List<IG132Info> buttonTB = new ArrayList<IG132Info>();
				//ÿ�������ɫ��Ӧ���Եİ�ť����
				Map<String, List<IG132Info>> map_IG222Info = new LinkedHashMap<String, List<IG132Info>>();
				for(IG222Info ig222Info : lstDef) {
					IG132SearchCondImpl buttonImpl = new IG132SearchCondImpl();
					buttonImpl.setPpdid(ig222Info.getPpdid());
					buttonTB = workFlowDefinitionBL.searchParticipantButtonDef(buttonImpl);
					List<String> tbKey = new ArrayList<String>();
					for(IG132Info tb : buttonTB){
						tbKey.add(tb.getPbdid());
					}
					//��Ĭ�ϰ�ť���뵽�����߰�ť������
					if(defInfoList != null && defInfoList.size() > 0){
						for(IG725Info info :defInfoList){
							if(!tbKey.contains(info.getPbdid())){
								IG132TB ppbdtb = new IG132TB();
								ppbdtb.setPbdid(info.getPbdid());
								ppbdtb.setPpbdname(info.getPdbdname());
								buttonTB.add(ppbdtb);
							}
						}
					}
					map_IG222Info.put(ig222Info.getRoleid().toString(), buttonTB);
				}
				dto.setProcessParticipantButtonDefMap(map_IG222Info);
			}
			
			
		} else {
			throw new BLException("IGCO10000.E004","����״̬����");
		}
		
		log.debug("========��������Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * ������ת��������
	 *
	 * @param ptd ProcessTransitionDef
	 * @return ����
	 */
	private String convertPtdCondInfo(IG273Info ptd,List<IG725Info> defInfoList) throws BLException {
		//��ֶ��������
		String[] condArray = null;
		String[] varArray = null;
		if(ptd.getPtdcond().indexOf('|')==-1){
		condArray = ptd.getPtdcond().split(IGPRDCONSTANTS.COND_COND_SPLIT); 
		}else{
			condArray = ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[0].split(IGPRDCONSTANTS.COND_COND_SPLIT);
			varArray = ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[1].split(IGPRDCONSTANTS.COND_COND_SPLIT);
		}
		StringBuffer info = new StringBuffer();
		if(condArray != null) {
			for(String cond : condArray) {
				if(StringUtils.isNotEmpty(cond)) {
					//�����߶���
					String[] ppdArray = cond.split(IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT);
					if(ppdArray != null) {
						//��ȡ��ɫ����
						if(IGPRDCONSTANTS.COND_TYPE_DEFAULT_ROLE.equals(ppdArray[0])) {
							info.append("ȱʡ��ɫ");
							info.append("(").append(getDefaultButtonName(ppdArray[1],defInfoList)).append(")&nbsp;&nbsp;");
						} else {
							info.append(this.getRoleName(Integer.parseInt(ppdArray[0])));
							
							IG222SearchCondImpl ppdCond = new IG222SearchCondImpl();
							ppdCond.setPsdid(ptd.getFpsdid());
							ppdCond.setRoleid(Integer.parseInt(ppdArray[0]));
							List<IG222Info>  ppdList = workFlowDefinitionBL.searchParticipantDef(ppdCond);
							info.append("(").append(getButtonName(ppdArray[1],ppdList.get(0).getProcessParticipantButtonDefList(),defInfoList)).append(")&nbsp;&nbsp;");
						}
						
						
					} else {
						throw new BLException("IGCO10000.E004","ԾǨ����");
					}
					
				}
			}
			if(ptd.getPtdcond().indexOf('|')!=-1){
				for(String var : varArray){
					if(StringUtils.isNotEmpty(var)) {
						String[] vArray = var.split(IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT);
						try{//����п�ָ���쳣,˵�����Ѿ���ɾ��,ԾǨ�����Ե��ñ�
							info.append(this.getVariableName(vArray[0]))
							.append(IGPRDCONSTANTS.convertLogicSineInfo(Integer.parseInt(vArray[1])))
							.append(vArray[2]).append("&nbsp;&nbsp;");
						}catch(Exception e){
							continue;
						}
					}
				}
			}
		} else {
			throw new BLException("IGCO10000.E004","ԾǨ����");
		}
		
		return info.toString();
			
	}
	
	/**
	 * ��ȡ��ɫ����
	 *
	 * @param roleid Integer
	 * @return ��ɫ����
	 */
	private String getRoleName(Integer roleid) throws BLException {
		return this.roleBL.searchRoleByKey(roleid).getRolename();
	}
	
	/**
	 * ��ȡ���̱������
	 *
	 * @param pidid Integer
	 * @return ���̱�������
	 */
	private String getVariableName(String pidid) throws BLException {
		return workFlowDefinitionBL.searchProcessInfoDefByKey(pidid).getPidname();
	}
	
	/**
	 * ��������Ϣ��������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO insertProcessTransitionDefAction(IGPRD01DTO dto) throws BLException {
		
		log.debug("========��������Ϣ��������ʼ========");
		IGPRD0109Form form = dto.getIgPRD0109Form();
		
		/**��������Ϣ��������
		 * 
		 * ֻ��һ��������  roleid  ! 0001 #
		 * 
		 * ���������  roleid  ! 0001 # roleid  ! 0010 #
		 * 
		 */
		String[] roleidArray = form.getRoleidArray();
		String[] condArray = form.getCondArray();
		String[] variableID = form.getVariableID();
		String[] logicSign = form.getLogicSign();
		String[] vvalue = form.getVvalue();
		
		//����������п�ֵ����ʾ
		if(vvalue!=null){
			for(String value:vvalue){
				if(StringUtils.isEmpty(value)){
					throw new BLException("IGCO10000.E004","ԾǨ����");
				}
			}
		}
		
		String[] variableGroup = null;
		StringBuffer ptdVCond = new StringBuffer();
		ptdVCond.append(IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT);
		if(variableID!=null){
			variableGroup = new String[variableID.length];
			for(int i=0;i<variableID.length;i++){
				variableGroup[i] = variableID[i]+IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT+logicSign[i]+IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT+vvalue[i];
			}
			for(int i=0;i<variableGroup.length;i++){
				ptdVCond.append(variableGroup[i]+IGPRDCONSTANTS.COND_COND_SPLIT);
			}
		}
		StringBuffer ptdCond = new StringBuffer();
		String ptdtype = null;
		if(roleidArray != null && condArray != null && (roleidArray.length == condArray.length)) {
			if(roleidArray.length > 1) {
				ptdtype = IGPRDCONSTANTS.COND_TYPE_AND;
			} else {
				ptdtype = IGPRDCONSTANTS.COND_TYPE_OR;
			}
			for(int i = 0; i < roleidArray.length; i++) {
				if(StringUtils.isNotEmpty(roleidArray[i]) && StringUtils.isNotEmpty(roleidArray[i])) {
					ptdCond.append(roleidArray[i]).append(IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT);
					ptdCond.append(condArray[i]).append(IGPRDCONSTANTS.COND_COND_SPLIT);
				} else {
					throw new BLException("IGCO10000.E004","ԾǨ����");
				}
			}
		} else {
			throw new BLException("IGCO10000.E004","ԾǨ���������");
		}
		
		//������ǼǴ���
		
		
		//�ж���ͬ��ԾǨ״̬�Ƿ����
//		ProcessTransitionDefSearchCondImpl cond = new ProcessTransitionDefSearchCondImpl();
//		cond.setFpsdid(form.getFpsdid());
//		cond.setTpsdid(form.getTpsdid());
//		List<ProcessTransitionDef> ptList = this.ig273BL.searchProcessTransitionDef(cond, 0, 0);
//		
//		if(ptList!=null && ptList.size()>0){
//			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,"IGPRD0109.E001","��ͬԾǨ״̬�����̹������Ѵ���");
//		}else{
			boolean flag = false;//�жϿ�ʼ״̬��ԾǨ������ͬ�����̹������Ƿ����
			String ptdstring = ptdCond.toString();
			if(ptdstring!=null){
				//String[] ptds = ptdstring.split("#");
//				for(int i=0,j=ptds.length;i<j;i++){
//					ProcessTransitionDefSearchCondImpl cond1 = new ProcessTransitionDefSearchCondImpl();
//					cond1.setPtdcond(ptds[i]+"#");
//					cond1.setFpsdid(form.getFpsdid());
//
//					List<ProcessTransitionDef> ptList1 = this.ig273BL.searchProcessTransitionDef(cond1, 0, 0);
//					if(ptList1!=null && ptList1.size()>0){
//						flag = true;
//					}
//				}
				IG273SearchCondImpl cond1 = new IG273SearchCondImpl();
				cond1.setPtdcond(ptdstring);
				cond1.setFpsdid(form.getFpsdid());

				List<IG273Info> ptList1 = workFlowDefinitionBL.searchProcessTransitionDef(cond1);
				if(ptList1!=null && ptList1.size()>0){
					for(IG273Info pt:ptList1){
						if(pt.getTpsdid().equals(form.getTpsdid())){
							flag = true;
							break;
						}
					}
				}
				if(flag){
					throw new BLException("IGPRD0109.E002","��ʼ״̬��ԾǨ������ͬ�����̹������Ѵ���");
				}else{
					IG273TB ptdTB = new IG273TB();
					
					ptdTB.setPtdid(workFlowDefinitionBL.getProcessTransitionDefPK(form.getPdid()));//����
					
					ptdTB.setFpsdid(form.getFpsdid());
					
					ptdTB.setTpsdid(form.getTpsdid());
					if("|".equals(ptdVCond.toString())){
						ptdTB.setPtdcond(ptdCond.toString());
					}else{
						ptdTB.setPtdcond(ptdCond.toString()+ptdVCond.toString());
					}
					
					//ȱʡ����
					if("1".equals(form.getFlag())) {
						ptdTB.setPtdtype(IGPRDCONSTANTS.COND_TYPE_DEFAULT);
					} else {
						ptdTB.setPtdtype(ptdtype);
					}
					
					IG273Info ptd = workFlowDefinitionBL.registProcessTransitionDef(ptdTB);
					
					
					IG273SearchCondImpl cond2 = new IG273SearchCondImpl();
					cond2.setFpsdid(form.getFpsdid());
					cond2.setTpsdid(form.getTpsdid());
					//List<ProcessTransitionDef> ptList2 = this.ig273BL.searchProcessTransitionDef(cond2, 0, 0);
					
					if (StringUtils.isEmpty(nullToString(form.getPpsdid()))) {
						
						//�޸�����ͼ(����)
						IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(form.getPdid());
						if(pd.getPdxml()!=null && !"".equals(pd.getPdxml())){
							
							Document document;
							try {
								document = DocumentHelper.parseText(new String(pd.getPdxml()));
								Element root = document.getRootElement();
								
								addAction(root, String.valueOf(ptd.getPtdid()), ptd.getPtdname(),String.valueOf(ptd.getFpsdid()),String.valueOf(ptd.getTpsdid()));
								//����
								saveXml(pd,document);
//									ProcessDefinitionTB pdtb = (ProcessDefinitionTB)SerializationUtils.clone(pd);
//									pdtb.setPdxml(document.asXML().replaceAll("'", "\""));
//									this.ig380BL.updateProcessDefinition(pdtb);
							} catch (DocumentException e) {
								throw new BLException("IGPRD0104.E004","��ǰ���̵�����״̬ͼ�洢ʧ�ܣ��볢�����±��档");
							}
							
							
							
						}
					} else {

						//�޸�����ͼ(����)
						IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(form.getPpsdid());
						if(psd.getPsdxml()!=null && !"".equals(psd.getPsdxml())){
							
							Document document;
							try {
								document = DocumentHelper.parseText(new String(psd.getPsdxml()));
								Element root = document.getRootElement();
								
								addAction(root, String.valueOf(ptd.getPtdid()), ptd.getPtdname(),String.valueOf(ptd.getFpsdid()),String.valueOf(ptd.getTpsdid()));
								//����
								saveChildXml(psd,document);
//									ProcessDefinitionTB pdtb = (ProcessDefinitionTB)SerializationUtils.clone(pd);
//									pdtb.setPdxml(document.asXML().replaceAll("'", "\""));
//									this.ig380BL.updateProcessDefinition(pdtb);
							} catch (DocumentException e) {
								throw new BLException("IGPRD0104.E004","��ǰ���̵�����״̬ͼ�洢ʧ�ܣ��볢�����±��档");
							}
						}
					}
					
				}
			}else{
				throw new BLException("IGPRD0109.E003","ԾǨ���򲻴���");
			}

		//}
		
		
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "�����������Ϣ") );
		
		log.debug("========��������Ϣ������������========");
		return dto;
	}
	
	/**
	 * ��������Ϣɾ������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO deleteProcessTransitionDefAction(IGPRD01DTO dto) throws BLException {

		log.debug("========��������Ϣɾ������ʼ========");
		IGPRD0109Form form = dto.getIgPRD0109Form();
		
		//��������Ϣɾ������
		workFlowDefinitionBL.deleteProcessTransitionDefByKey(form.getPtdid());
		

		//ɾ������ͼ(����)
		IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(form.getPdid());
		if(pd.getPdxml()!=null && !"".equals(pd.getPdxml())){
			try{
				Document document = DocumentHelper.parseText(new String(pd.getPdxml()));
				Element root = document.getRootElement();
				
				//ֻɾ��
				removeActions(root,String.valueOf(form.getPtdid()));
				//����
				saveXml(pd,document);
//				ProcessDefinitionTB pdtb = (ProcessDefinitionTB)SerializationUtils.clone(pd);
//				pdtb.setPdxml(document.asXML());
//				this.ig380BL.updateProcessDefinition(pdtb);
			}catch (DocumentException e) {
				throw new BLException("IGPRD0104.E004","��ǰ���̵�����״̬ͼ�洢ʧ�ܣ��볢�����±��档");
			}
			
		}
		
		
		
		dto.addMessage(new ActionMessage( "IGCO10000.I006", "�����������Ϣ") );

		log.debug("========��������Ϣɾ����������========");
		return dto;
	}
	
	//-----------------------------------------------------------����״̬----------------------------------------------------------------------
	/**
	 * ����״̬��Ϣ��ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessStatusDefAction(IGPRD01DTO dto) throws BLException {
		
		log.debug("========����״̬��Ϣ��ѯ����ʼ========");
		IGPRD0104Form form = dto.getIgPRD0104Form();
		IG333SearchCondImpl cond = new IG333SearchCondImpl();
		cond.setPdid(form.getPdid());
		if (StringUtils.isEmpty(nullToString(form.getPpsdid()))) {
			cond.setFatherflag("Y");
		} else {
			cond.setPpsdid(form.getPpsdid());
			//�趨�ϼ�״̬ID
			IG333Info parentStatusDef = workFlowDefinitionBL.searchProcessStatusDefByKey(form.getPpsdid());
			dto.setProcessStatusDef(parentStatusDef);
		}
		//��ǰҳ��Ϣȡ��
		List<IG333Info> processStatusDefList = workFlowDefinitionBL.searchProcessStatusDef(cond);
		int totalCount = processStatusDefList.size();
		dto.setProcessStatusDefList(processStatusDefList);
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		log.debug("========����״̬��Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * ����״̬��Ϣɾ������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO deleteProcessStatusDefAction(IGPRD01DTO dto) throws BLException {

		log.debug("========����״̬��Ϣɾ������ʼ========");
		IGPRD0104Form form = dto.getIgPRD0104Form();
		
		//����״̬��Ϣɾ������
		IG333SearchCondImpl cond = new IG333SearchCondImpl();
		cond.setPsdid(form.getPsdid());
		int totalCount = workFlowDefinitionBL.getProcessStatusDefSearchCount(cond);
		//====> ��ܱ���Begin
		String message = "����";
		String pdid_one = StringUtils.isEmpty(form.getPdid()) ? "0" : form.getPdid().substring(0,1);
		if(IGPRDCONSTANTS.PRTYPE_YEAR_STATUS_ID.equals(pdid_one)
				|| IGPRDCONSTANTS.PRTYPE_SEASON_STATUS_ID.equals(pdid_one)
				|| IGPRDCONSTANTS.PRTYPE_IRREGULAR_STATUS_ID.equals(pdid_one)){
			message = "����";
			
		}
		//====> ��ܱ���End
		if(totalCount==0){
			//====> ��ܱ���Begin
			throw new BLException("IGPRD0104.E001",message + "״̬������");
			//====> ��ܱ���End
		}else{
			IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(form.getPsdid());
			
			if (StringUtils.isEmpty(psd.getPpsdid())) {
				workFlowDefinitionBL.deleteProcessStatusDefByPK(form.getPsdid());
				//ɾ������ͼ(���)
				IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(form.getPdid());
				if(pd.getPdxml()!=null && !"".equals(pd.getPdxml())){
					try{
						Document document = DocumentHelper.parseText(new String(pd.getPdxml()));
						Element root = document.getRootElement();
						
						//��ɾ�ߺ�ɾ��
						removeStepandActions(root,String.valueOf(form.getPsdid()));
						removeStep(root,String.valueOf(form.getPsdid()));
						
						
						//����
						saveXml(pd,document);
//						ProcessDefinitionTB pdtb = (ProcessDefinitionTB)SerializationUtils.clone(pd);
//						pdtb.setPdxml(document.asXML());
//						this.ig380BL.updateProcessDefinition(pdtb);
					}catch (DocumentException e) {
						//====> ��ܱ���Begin
						throw new BLException("IGPRD0104.E004","��ǰ" + message + "��" + message + "״̬ͼ�洢ʧ�ܣ��볢�����±��档");
						//====> ��ܱ���End
					}
				}
			} else {
				workFlowDefinitionBL.deleteProcessStatusDefByPK(form.getPsdid());
				//ɾ������ͼ(���)
				IG333Info ppsd = workFlowDefinitionBL.searchProcessStatusDefByKey(psd.getPpsdid());
				if(ppsd.getPsdxml()!=null && !"".equals(ppsd.getPsdxml())){
					try{
						Document document = DocumentHelper.parseText(new String(ppsd.getPsdxml()));
						Element root = document.getRootElement();
						
						//��ɾ�ߺ�ɾ��
						removeStepandActions(root,String.valueOf(form.getPsdid()));
						removeStep(root,String.valueOf(form.getPsdid()));
						
						
						//����
						saveChildXml(ppsd,document);
//						ProcessDefinitionTB pdtb = (ProcessDefinitionTB)SerializationUtils.clone(pd);
//						pdtb.setPdxml(document.asXML());
//						this.ig380BL.updateProcessDefinition(pdtb);
					}catch (DocumentException e) {
						//====> ��ܱ���Begin
						throw new BLException("IGPRD0104.E004","��ǰ" + message + "��" + message + "״̬ͼ�洢ʧ�ܣ��볢�����±��档");
						//====> ��ܱ���End
					}
				}
			}
			
			// ɾ�����̲��Ա�
			IG335SearchCondImpl ig335cond = new IG335SearchCondImpl();
			ig335cond.setPsdid_eq(form.getPsdid());
			List<IG335Info> ig335list = workFlowDefinitionBL.searchFormStrategy(ig335cond);
			if(ig335list.size() > 0){
			    workFlowDefinitionBL.deleteFormStrategy(ig335list);
			}
			
		}
		
		//====> ��ܱ���Begin
		dto.addMessage(new ActionMessage( "IGCO10000.I006", message + "״̬������Ϣ") );
		//====> ��ܱ���End

		log.debug("========����״̬��Ϣɾ����������========");
		return dto;
	}
	
	/**
	 * ����״̬��Ϣ�ǼǴ���
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO insertProcessStatusDefinitionAction(IGPRD01DTO dto) throws BLException {
		
		log.debug("========����״̬��Ϣ�ǼǴ���ʼ========");
		
		IGPRD0105Form form = dto.getIgPRD0105Form();
		if (StringUtils.isEmpty(nullToString(form.getPpsdid()))) {
			form.setPpsdid(null);
		}
		//====> ��ܱ���Begin
		String message = "����";
		String pdid_one = StringUtils.isEmpty(form.getPdid()) ? "0" : form.getPdid().substring(0,1);
		if(IGPRDCONSTANTS.PRTYPE_YEAR_STATUS_ID.equals(pdid_one)
				|| IGPRDCONSTANTS.PRTYPE_SEASON_STATUS_ID.equals(pdid_one)
				|| IGPRDCONSTANTS.PRTYPE_IRREGULAR_STATUS_ID.equals(pdid_one)){
			message = "����";
			
		}
		//====> ��ܱ���End
		if(StringUtils.isNotEmpty(form.getPdid())) {
			//�ж�״̬�����Ƿ��ظ�
			IG333SearchCondImpl cond = new IG333SearchCondImpl();
			cond.setPdid(form.getPdid());
			cond.setPsdname(form.getPsdname());
			if (StringUtils.isEmpty(nullToString(form.getPpsdid()))) {
				cond.setFatherflag("Y");
			} else {
				cond.setPpsdid(form.getPpsdid());
			}
			int totalCount = workFlowDefinitionBL.getProcessStatusDefSearchCount(cond);
			
			if(totalCount>0){
				//====> ��ܱ���Begin
				throw new BLException("IGPRD0105.E001",message + "״̬�����Ѵ���");
				//====> ��ܱ���End
			}else{
				//����״̬��Ϣ�ǼǴ���
				IG333SearchCondImpl cond1 = new IG333SearchCondImpl();
				cond1.setPdid(form.getPdid());
				if (StringUtils.isEmpty(nullToString(form.getPpsdid()))) {
					cond1.setFatherflag("Y");
				} else {
					cond1.setPpsdid(form.getPpsdid());
				}
				List<IG333Info> psdlist = workFlowDefinitionBL.searchProcessStatusDef(cond1);
				if(psdlist!=null && psdlist.size()>0){
					Set<Character> psdcodeSet = new HashSet<Character>();
					for(IG333Info psd:psdlist){
						psdcodeSet.add(psd.getPsdcode().charAt(0));
					}
					int hash = 90;
					boolean scheme_a = true;
					boolean scheme_b = false;
					String psdcode = null;
					while(scheme_a){
						hash--;
						char temp = (char)(hash);
						if(temp == 'E'){
							continue;
						}
						if(psdcodeSet.contains(temp)){
							if(hash == 65){
								scheme_b = true;
								hash = 123;
								break;
							}
						}else{
							psdcode = new String(new char[]{temp});
							break;
						}
					}
					while(scheme_b){
						hash--;
						char temp = (char)(hash);
						if(temp == 'e'){
							continue;
						}
						if(psdcodeSet.contains(temp)){
							if(hash == 97){
								throw new BLException("IGPRD0105.E003",message + "״̬�Ѿ��ﵽ������������ܼ������ӡ�");
							}
						}else{
							psdcode = new String(new char[]{temp});
							break;
						}
					}
					form.setPsdcode(psdcode);
				}else{
					//====> ��ܱ���Begin
					throw new BLException("IGPRD0105.E002","��" + message + "ȱ��Ĭ�Ͽ�ʼ״̬�����״̬����������״̬��");
					//====> ��ܱ���End
				}
				form.setPsdid(workFlowDefinitionBL.getProcessStatusDefPK(form.getPdid()));//����
				
				IG333Info psd = workFlowDefinitionBL.registProcessStatus(form);
				
				//֧�ֶ�ڵ�ͬʱ����ͬһ�ڵ�
				//����ǿɷ��ɽڵ㣬���÷�����Ϣ  20130318 start wangtingzhi
				if(IGPRDCONSTANTS.NEED_ASSIGN.equals(psd.getPsdflag())){
					if(form.getAssignpsdids()!=null&&form.getAssignpsdids().length>0){
						for(int i=0;i<form.getAssignpsdids().length;i++){
							IG233TB asTB = new IG233TB();
							asTB.setPsdid(psd.getPsdid());
							asTB.setAssignpsdid(form.getAssignpsdids()[i]);
							asTB.setAssignpbdid(form.getAssignpbdids()[i]);
							asTB.setAssignflag(form.getAssignflags()[i]);
							workFlowDefinitionBL.registAssignedDefInfo(asTB);
						}
					}
				}
				//����ǿɷ��ɽڵ㣬���÷�����Ϣ  20130318 en wangtingzhi

				//�޸�����ͼ(���)
				IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(form.getPdid());
				
				if (StringUtils.isEmpty(nullToString(form.getPpsdid()))) {
					
					if(pd.getPdxml()!=null && !"".equals(pd.getPdxml())){
						try{
							Document document = DocumentHelper.parseText(new String(pd.getPdxml()));
							Element root = document.getRootElement();

							addStep(root,String.valueOf(psd.getPsdid()),psd.getPsdname(), psd.getPsdtype());
							//����
							saveXml(pd,document);
//							ProcessDefinitionTB pdtb = (ProcessDefinitionTB)SerializationUtils.clone(pd);
//							pdtb.setPdxml(document.asXML());
//							this.ig380BL.updateProcessDefinition(pdtb);
						}catch (DocumentException e) {
							//====> ��ܱ���Begin
							throw new BLException("IGPRD0104.E004","��ǰ" + message + "��" + message + "״̬ͼ�洢ʧ�ܣ��볢�����±��档");
							//====> ��ܱ���End
						}
					}
					
				} else {
					
					IG333Info ppsd = workFlowDefinitionBL.searchProcessStatusDefByKey(form.getPpsdid());
					if(ppsd.getPsdxml()!=null && !"".equals(ppsd.getPsdxml())){
						try{
							Document document = DocumentHelper.parseText(new String(ppsd.getPsdxml()));
							Element root = document.getRootElement();

							addStep(root,String.valueOf(psd.getPsdid()),psd.getPsdname(), psd.getPsdtype());
							//����
							saveChildXml(ppsd,document);
//							ProcessDefinitionTB pdtb = (ProcessDefinitionTB)SerializationUtils.clone(pd);
//							pdtb.setPdxml(document.asXML());
//							this.ig380BL.updateProcessDefinition(pdtb);
						}catch (DocumentException e) {
							//====> ��ܱ���Begin
							throw new BLException("IGPRD0104.E004","��ǰ" + message + "��" + message + "״̬ͼ�洢ʧ�ܣ��볢�����±��档");
							//====> ��ܱ���End
						}
					}
				}
				
				//�������ȷ����״̬����ȷ�ϰ�ť���浽��״̬��ȱʡ��ť��
				if(IGPRDCONSTANTS.SUBSTATUS_CONFIRM_YES.equals(form.getPsdconfirm())) {
					workFlowDefinitionBL.registConfirmButton(psd.getPsdid());
				}
				
				//����������̽ڵ㣬��Ϊ�ýڵ���ӿ�ʼ������״̬
				if (IGPRDCONSTANTS.PROCESS_NODE_TYPE_CHILDPROCESS.equals(psd.getPsdtype())) {

					IG333TB psdTB = new IG333TB();
					
					psdTB.setPsdid(workFlowDefinitionBL.getProcessStatusDefPK(pd.getPdid()));//����
					
					psdTB.setPdid(pd.getPdid());//���̶���ID
					
					psdTB.setPpsdid(psd.getPsdid());//������״̬ID
					
					psdTB.setPsdcode(IGPRDCONSTANTS.PROCESS_START_STATUS);//��ʼ״̬
					
					psdTB.setPsdtype(IGPRDCONSTANTS.PROCESS_NODE_TYPE_NORMAL);//��ͨ�ڵ�
					
					psdTB.setPsddesc(IGPRDCONSTANTS.PROCESS_START_STATUS_DESC);//˵��
					
					psdTB.setPsdname("��ʼ");//��ʼ״̬��ʾ����
					
					psdTB.setPsdmode(IGPRDCONSTANTS.MODE_NORMAL);//��ͨģʽ
					
					psdTB.setPsdflag(IGPRDCONSTANTS.NOT_NEED_ASSIGN); //��ʼ״̬�Ƿ�ɷ�����"��"
					
					psdTB.setPsdconfirm(IGPRDCONSTANTS.SUBSTATUS_CONFIRM_NO);//��ȷ��״̬
					
					//����״̬������Ϣ�ǼǴ���
					workFlowDefinitionBL.registProcessStatus(psdTB);
					
					
					IG333TB psdTB1 = new IG333TB();
					
					psdTB1.setPsdid(workFlowDefinitionBL.getProcessStatusDefPK(pd.getPdid()));//����
					
					psdTB1.setPdid(pd.getPdid());//���̶���ID

					psdTB1.setPpsdid(psd.getPsdid());//������״̬ID
					
					psdTB1.setPsdcode(IGPRDCONSTANTS.PROCESS_END_SUBSTATUS);//����״̬
					
					psdTB1.setPsdtype(IGPRDCONSTANTS.PROCESS_NODE_TYPE_NORMAL);//��ͨ�ڵ�
					
					psdTB1.setPsddesc(IGPRDCONSTANTS.PROCESS_END_STATUS_DESC);//˵��
					
					psdTB1.setPsdname("����");//����״̬��ʾ����
					
					psdTB1.setPsdmode(IGPRDCONSTANTS.MODE_NORMAL);
					
					psdTB1.setPsdflag(IGPRDCONSTANTS.NOT_NEED_ASSIGN); //�Ƿ�ɷ�����"��"
					
					psdTB1.setPsdconfirm(IGPRDCONSTANTS.SUBSTATUS_CONFIRM_NO);//��ȷ��״̬
					
					//����״̬������Ϣ�ǼǴ���
					workFlowDefinitionBL.registProcessStatus(psdTB1);
					
					//����ύ��ťȱʡȨ��
					IG725TB tb = new IG725TB();
					tb.setPdbdid(workFlowDefinitionBL.getParticipantDefaultButtonDefPK(psd.getPsdid()));
					tb.setPsdid(psd.getPsdid());
					tb.setPbdid(IGPRDCONSTANTS.BUTTON_SUBMIT);
					tb.setPdbdname("�ύ");
					tb.setPdbddesc("�ύ");
					tb.setPdbdauth("0");
					tb.setCheckrequired("0");
					tb.setCheckrecord("0");
					workFlowDefinitionBL.registParticipantDefaultButtonDef(tb);
					
				}
				
				//����Ƕ�̬��֧�ڵ㣬��Ϊ�ýڵ���ӿ�ʼ������״̬
				if (IGPRDCONSTANTS.PROCESS_NODE_TYPE_DYNAMICBRANCH.equals(psd.getPsdtype())) {

					IG333TB psdTB = new IG333TB();
					
					psdTB.setPsdid(workFlowDefinitionBL.getProcessStatusDefPK(pd.getPdid()));//����
					
					psdTB.setPdid(pd.getPdid());//���̶���ID
					
					psdTB.setPpsdid(psd.getPsdid());//������״̬ID
					
					psdTB.setPsdcode(IGPRDCONSTANTS.PROCESS_START_STATUS);//��ʼ״̬
					
					psdTB.setPsdtype(IGPRDCONSTANTS.PROCESS_NODE_TYPE_NORMAL);//��ͨ�ڵ�
					
					psdTB.setPsddesc(IGPRDCONSTANTS.PROCESS_START_STATUS_DESC);//˵��
					
					psdTB.setPsdname("��ʼ");//��ʼ״̬��ʾ����
					
					psdTB.setPsdmode(IGPRDCONSTANTS.MODE_NORMAL);//��ͨģʽ
					
					psdTB.setPsdflag(IGPRDCONSTANTS.NOT_NEED_ASSIGN); //��ʼ״̬�Ƿ�ɷ�����"��"
					
					psdTB.setPsdconfirm(IGPRDCONSTANTS.SUBSTATUS_CONFIRM_NO);//��ȷ��״̬
					
					//����״̬������Ϣ�ǼǴ���
					workFlowDefinitionBL.registProcessStatus(psdTB);
					
					
					IG333TB psdTB1 = new IG333TB();
					
					psdTB1.setPsdid(workFlowDefinitionBL.getProcessStatusDefPK(pd.getPdid()));//����
					
					psdTB1.setPdid(pd.getPdid());//���̶���ID

					psdTB1.setPpsdid(psd.getPsdid());//������״̬ID
					
					psdTB1.setPsdcode(IGPRDCONSTANTS.PROCESS_END_SUBSTATUS);//����״̬
					
					psdTB1.setPsdtype(IGPRDCONSTANTS.PROCESS_NODE_TYPE_NORMAL);//��ͨ�ڵ�
					
					psdTB1.setPsddesc(IGPRDCONSTANTS.PROCESS_END_STATUS_DESC);//˵��
					
					psdTB1.setPsdname("����");//����״̬��ʾ����
					
					psdTB1.setPsdmode(IGPRDCONSTANTS.MODE_NORMAL);
					
					psdTB1.setPsdflag(IGPRDCONSTANTS.NOT_NEED_ASSIGN); //�Ƿ�ɷ�����"��"
					
					psdTB1.setPsdconfirm(IGPRDCONSTANTS.SUBSTATUS_CONFIRM_NO);//��ȷ��״̬
					
					//����״̬������Ϣ�ǼǴ���
					workFlowDefinitionBL.registProcessStatus(psdTB1);
					
					//����ύ��ťȱʡȨ��
					IG725TB tb = new IG725TB();
					tb.setPdbdid(workFlowDefinitionBL.getParticipantDefaultButtonDefPK(psd.getPsdid()));
					tb.setPsdid(psd.getPsdid());
					tb.setPbdid(IGPRDCONSTANTS.BUTTON_SUBMIT);
					tb.setPdbdname("�ύ");
					tb.setPdbddesc("�ύ");
					tb.setPdbdauth("0");
					tb.setCheckrequired("0");
					tb.setCheckrecord("0");
					workFlowDefinitionBL.registParticipantDefaultButtonDef(tb);
					
				}
			}
			
		} else {
			//====> ��ܱ���Begin
			throw new BLException("IGCO10000.E004",message + "�������");
			//====> ��ܱ���End
		}
		dto.addMessage(new ActionMessage( "IGCO10000.I004", message + "״̬������Ϣ") );
		//====> ��ܱ���Begin
		log.debug("========����״̬��Ϣ�ǼǴ�������========");
		//====> ��ܱ���End
		return dto;
	}
	
	
	/**
	 * ����״̬��Ϣ�����ʼ������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO initIGPRD0105Action(IGPRD01DTO dto) throws BLException {
		log.debug("========����״̬��Ϣ�����ʼ������ʼ========");
		
		IGPRD0105Form form = dto.getIgPRD0105Form();
		
		IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(form.getPsdid());
		form.setPsdid(psd.getPsdid());
		form.setPdid(psd.getPdid());
		form.setPsdname(psd.getPsdname());
		form.setPsddesc(psd.getPsddesc());
		form.setPsdcode(psd.getPsdcode());
		form.setPsdtype(psd.getPsdtype());
		form.setPsdmode(psd.getPsdmode());
		form.setPsdflag(psd.getPsdflag());
		form.setPsdassign(psd.getPsdassign());
		form.setAssignpsdid(psd.getAssignpsdid());
		form.setAssignpbdid(psd.getAssignpbdid());
		form.setAssignflag(psd.getAssignflag());
		form.setPsdorg(psd.getPsdorg());
		form.setPsdconfirm(psd.getPsdconfirm());
		form.setParticipantchange(psd.getParticipantchange());
		form.setAssignPageType(psd.getAssignPageType());
		form.setFormGlobalControl(psd.getFormGlobalControl());
		form.setJsfunction(psd.getJsfunction());
		form.setPpsdid(psd.getPpsdid());
		form.setBranchcond(psd.getBranchcond());
		form.setReplaceDispose(psd.getReplaceDispose());
		dto.setPdid(psd.getPdid());
		dto.setIgPRD0105Form(form);
		
		//���ɽڵ���Ϣ��ѯ
		List<IG233Info> apList = workFlowDefinitionBL.searchAssignedDefInfoByPsdid(form.getPsdid());
		dto.setApList(apList);
		log.debug("========����״̬��Ϣ�����ʼ����������========");
		return dto;
	}

	/**
	 * ����״̬��Ϣ�����ʼ������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO initIGPRD0111Action(IGPRD01DTO dto) throws BLException {
		log.debug("========���̱���Ϣ�����ʼ������ʼ========");
		
		IGPRD0111Form form = dto.getIgPRD0111Form();
		
		IG007Info pid = workFlowDefinitionBL.searchProcessInfoDefByKey(form.getPidid());
		
		form.setPiddisplaya(form.getPiddisplay());
		form.setPidid(pid.getPidid());
		form.setPdid(pid.getPdid());
		form.setPidname(pid.getPidname());
		form.setPidlabel(pid.getPidlabel());
		form.setPiddesc(pid.getPiddesc());
		form.setPidtype(pid.getPidtype());
		form.setPidoption(pid.getPidoption());
		form.setPiddefault(pid.getPiddefault());
		form.setPidrequired(pid.getPidrequired());
		form.setPidsortid(pid.getPidsortid());
		form.setCcid(pid.getCcid());
		form.setPidgid(pid.getPidgid());
		form.setPidmode(pid.getPidmode());
		form.setPrivatescope(pid.getPrivatescope());
		form.setRowwidth(pid.getRowwidth());
		form.setHasattach(pid.getHasattach());
		// ���ģʽ
		form.setPiddisplay(pid.getPiddisplay());
		// ʹ��ģʽ
		form.setPiduse(pid.getPiduse());
		// ���
		form.setPidwidth(pid.getPidwidth());
		// ������������
		form.setPpidid(pid.getPpidid());
		// ����
		form.setPidrows(pid.getPidrows());
		// �Ƿ���������
		form.setPidhide(pid.getPidhide());
		//����λ
		form.setPidunit(pid.getPidunit());
		//�Ƿ������ע
		form.setRemarks(pid.getRemarks());
		//��ѡ��ѡ��ʾ��ʽ
		form.setShowstyles(pid.getShowstyles());
		
		form.setShowrownum(pid.getShowrownum());
		
		form.setShowline(pid.getShowline());
		
		form.setTitledisplay(pid.getTitledisplay());
		
		form.setNeedidea(pid.getNeedidea());
		
		form.setJsfunction(pid.getJsfunction());
		
		form.setPidratio(pid.getPidratio());
		
		form.setPidsize(pid.getPidsize());
		
		form.setSelecedlast(pid.getSelecedlast());
		
		form.setNumbertype(pid.getNumbertype());
		
		//С��λ��
		if("7".equals(pid.getPidtype())){
			form.setDecimals(pid.getPidoption());
		}
		
		if("P".equals(pid.getPidtype())){
			form.setParticipantRoleType(pid.getCcid());
			List<IG008Info> pidrses = workFlowDefinitionBL.searchFormRoleScopeByPidid(pid.getPidid());
			if(pidrses != null){
				StringBuffer info = new StringBuffer();
				for(int i=0;i<pidrses.size();i++){
					if(i>0){
						info.append("_#_");
					}
					info.append(pidrses.get(i).getRolename()).append("_sp_").append(pidrses.get(i).getRoleid());
				}
				form.setParticipantRoles(info.toString());
			}
		}
		if("F".equals(pid.getPidtype()) && StringUtils.isNotEmpty(pid.getPiddefault())){
			List<Attachment> list = attachmentBL.searchAttachmentsByAttkey(pid.getPiddefault());
			if(!list.isEmpty()){
				form.setAttList(list);
			}
		}
		if("4".equals(pid.getPidtype()) && StringUtils.isNotEmpty(pid.getPiddefault())){
			IG688SearchCondImpl cond = new IG688SearchCondImpl();
			String[] split = pid.getPiddefault().split("#");
			List<String> eiids = new ArrayList<String>();
			for(String s:split){
				eiids.add(s);
			}
			cond.setEiidList(eiids);
			List<IG688Info> list = ig013BL.searchIG688Info(cond);
			Map<Integer, String> map = new LinkedHashMap<Integer, String>();
			for(IG688Info info : list){
				map.put(info.getEiid(), info.getEiname());
			}
			if(!map.isEmpty()){
				form.setEntityInfoMap(map);
			}
		}
		form.setAlign(pid.getAlign());
		
		dto.setIgPRD0111Form(form);
		
		log.debug("========���̱���Ϣ�����ʼ����������========");
		return dto;
	}
	
	/**
	 * ����״̬��Ϣ�������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO updateProcessStatusDefinitionAction(IGPRD01DTO dto) throws BLException {

		log.debug("========����״̬��Ϣ�������ʼ========");
		IGPRD0105Form form = dto.getIgPRD0105Form();
		
		IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(form.getPsdid());
		//====> ��ܱ���Begin
		String message = "����";
		String pdid_one = StringUtils.isEmpty(psd.getPdid()) ? "0" : psd.getPdid().substring(0,1);
		if(IGPRDCONSTANTS.PRTYPE_YEAR_STATUS_ID.equals(pdid_one)
				|| IGPRDCONSTANTS.PRTYPE_SEASON_STATUS_ID.equals(pdid_one)
				|| IGPRDCONSTANTS.PRTYPE_IRREGULAR_STATUS_ID.equals(pdid_one)){
			message = "����";
			
		}
		//====> ��ܱ���End
		//�ж�״̬�����Ƿ��ظ�
		IG333SearchCondImpl cond = new IG333SearchCondImpl();
		cond.setPdid(form.getPdid());
		cond.setPsdname(form.getPsdname());
		if (StringUtils.isEmpty(nullToString(form.getPpsdid()))) {
			cond.setFatherflag("Y");
		} else {
			cond.setPpsdid(form.getPpsdid());
		}
		List<IG333Info> psdList = workFlowDefinitionBL.searchProcessStatusDef(cond);
		int totalCount = 0;
		for(IG333Info psdI:psdList){
			if(psdI.getPsdid()!= form.getPsdid()){
				totalCount+=1;
			}
		}
		if(totalCount>0){
			form.setMode("1");
			//====> ��ܱ���Begin
			throw new BLException("IGPRD0105.E001",message + "״̬�����Ѵ���");
			//====> ��ܱ���End
		}else{
			//����״̬��Ϣ�ǼǴ���
//			this.ig333BL.registProcessStatusDef(form);
			
			//���ƶ���
			IG333TB psdTB = (IG333TB)SerializationUtils.clone(psd);
			
			//�������ȷ����״̬����ȷ�ϰ�ť���浽��״̬��ȱʡ��ť��
			if(!form.getPsdconfirm().equals(psd.getPsdconfirm())) {
				if(IGPRDCONSTANTS.SUBSTATUS_CONFIRM_YES.equals(form.getPsdconfirm())) {
					workFlowDefinitionBL.registConfirmButton(psd.getPsdid());
				} else {
					workFlowDefinitionBL.deleteConfirmButton(psd.getPsdid());
				}
			}
			
			//ԭ������
			String oldPsdname = psdTB.getPsdname();
			psdTB.setPsdname(form.getPsdname());
			
			psdTB.setPsddesc(form.getPsddesc());
			
			//psdTB.setPsdtype(form.getPsdtype());
			
			psdTB.setPsdorg(form.getPsdorg());
			
			psdTB.setPsdconfirm(form.getPsdconfirm());
			psdTB.setAssignflag(form.getAssignflag());
			psdTB.setAssignpbdid(form.getAssignpbdid());
			psdTB.setAssignpsdid(form.getAssignpsdid());
			psdTB.setParticipantchange(form.getParticipantchange());
			psdTB.setPsdflag(form.getPsdflag());
			psdTB.setPsdassign(form.getPsdassign());
			psdTB.setAssignPageType(form.getAssignPageType());
			psdTB.setFormGlobalControl(form.getFormGlobalControl());
			psdTB.setJsfunction(form.getJsfunction());
			psdTB.setBranchcond(form.getBranchcond());
			psdTB.setReplaceDispose(form.getReplaceDispose());
			
			//����״̬��Ϣ�������
			workFlowDefinitionBL.updateProcessStatus(psdTB);
			
			//��ѯ����״̬
			List<IG233Info> apList = workFlowDefinitionBL.searchAssignedDefInfoByPsdid(psdTB.getPsdid());
			//���ԭ�����ɽڵ���Ϣ��Ϊ�գ�ɾ��ԭ����Ϣ
			if(apList!=null&&!apList.isEmpty()){
				workFlowDefinitionBL.deleteAssignedDefInf(apList);
			}
			//�����ǰ״̬Ϊ�ɱ����ɣ���ӷ�����Ϣ
			if(IGPRDCONSTANTS.NEED_ASSIGN.equals(psd.getPsdflag())){
				if(form.getAssignpsdids()!=null&&form.getAssignpsdids().length>0){
					for(int i=0;i<form.getAssignpsdids().length;i++){
						IG233TB asTB = new IG233TB();
						asTB.setPsdid(psd.getPsdid());
						asTB.setAssignpsdid(form.getAssignpsdids()[i]);
						asTB.setAssignpbdid(form.getAssignpbdids()[i]);
						asTB.setAssignflag(form.getAssignflags()[i]);
						workFlowDefinitionBL.registAssignedDefInfo(asTB);
					}
				}
			}
			//����ɵ����������� "��" ��Ϊ"��" ��ɾ�����������õ�״̬
			if("0".equalsIgnoreCase(form.getParticipantchange())){
				//��ѯ��ǰ״̬�������õĵ���״̬
				IG258SearchCondImpl condImpl = new IG258SearchCondImpl();
				condImpl.setPsdid(form.getPsdid());
				List<IG258Info> infoList = workFlowDefinitionBL.searchProcessStatusPrtChangeDefInfo(condImpl);
				if(infoList.size() > 0){
					for(IG258Info info :infoList){
						workFlowDefinitionBL.deleteProcessStatusPrtChangeDefInfo(info);
					}
				}
			}
			
			if(!oldPsdname.equalsIgnoreCase(form.getPsdname())){
				if (StringUtils.isEmpty(nullToString(form.getPpsdid()))) {

					IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(psdTB.getPdid());
					IG380TB pdTB = (IG380TB)SerializationUtils.clone(pd);
					String content = pdTB.getPdxml();
					if(content != null && content.length() >= 0){
						String value = String.valueOf(content);
						//���滻����
						String old = "text=\'"+oldPsdname+"\'";
						//�滻����
						String newName = "text=\'"+form.getPsdname()+"\'";
						//�滻
						String str = StringUtils.replace(value, old, newName);
						pdTB.setPdxml(str);
						workFlowDefinitionBL.updateProcessDefinition(pdTB);
					}
				} else {
					
					IG333Info ppsd = workFlowDefinitionBL.searchProcessStatusDefByKey(psdTB.getPpsdid());
					IG333TB ppsdTB = (IG333TB)SerializationUtils.clone(ppsd);
					String content = ppsdTB.getPsdxml();
					if(content != null && content.length() >= 0){
						String value = String.valueOf(content);
						//���滻����
						String old = "text=\'"+oldPsdname+"\'";
						//�滻����
						String newName = "text=\'"+form.getPsdname()+"\'";
						//�滻
						String str = StringUtils.replace(value, old, newName);
						ppsdTB.setPsdxml(str);
						workFlowDefinitionBL.updateProcessStatus(ppsdTB);
					}
				}
			}
			//====> ��ܱ���Begin
			dto.addMessage(new ActionMessage( "IGCO10000.I005",message +  "������Ϣ") );
			//====> ��ܱ���End
			
		}
		//����״̬��˽�б�Ĭ��ֵ
		this.updateStatusDefaultValue(dto);
		log.debug("========����״̬��Ϣ�����������========");
		return dto;
	}

	/**
	 * ����״̬��Ϣ�������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO updateProcessStatusDefZAction(IGPRD01DTO dto) throws BLException{
		log.debug("========����״̬��Ϣ�������ʼ========");
		IGPRD0105Form form = dto.getIgPRD0105Form();
		IG333Info ig333Info = workFlowDefinitionBL.searchProcessStatusDefByKey(form.getPsdid());
		IG333TB psdTB = (IG333TB) SerializationUtils.clone(ig333Info);
		psdTB.setFormGlobalControl(form.getFormGlobalControl());
		psdTB.setJsfunction(form.getJsfunction());
		psdTB.setAssignPageType(form.getAssignPageType());
		workFlowDefinitionBL.updateProcessStatus(psdTB);
		//====> ��ܱ���Begin
		String message = "����";
		String pdid_one = StringUtils.isEmpty(psdTB.getPdid()) ? "0" : psdTB.getPdid().substring(0,1);
		if(IGPRDCONSTANTS.PRTYPE_YEAR_STATUS_ID.equals(pdid_one)
				|| IGPRDCONSTANTS.PRTYPE_SEASON_STATUS_ID.equals(pdid_one)
				|| IGPRDCONSTANTS.PRTYPE_IRREGULAR_STATUS_ID.equals(pdid_one)){
			message = "����";
			
		}
		dto.addMessage(new ActionMessage( "IGCO10000.I005", message + "������Ϣ") );
		//====> ��ܱ���End
		log.debug("========����״̬��Ϣ�����������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ��ȡ����״̬������
	 * </p>
	 */
	
	public IGPRD01DTO getProcessParticipants(IGPRD01DTO dto) throws BLException {
		log.debug("========����״̬�����߲�ѯ����ʼ========");
		IGPRD0107Form form = dto.getIgPRD0107Form();
		//״̬��Ϣȡ��
		dto.setProcessStatusDef(workFlowDefinitionBL.searchProcessStatusDefByKey(form.getPsdid()));
		// ��ȡ����ӽ�ɫ
		IG222SearchCondImpl cond = new IG222SearchCondImpl();
		cond.setPsdid(form.getPsdid());
		List<IG222Info> ppdlist = workFlowDefinitionBL.searchParticipantDef(cond);
		Map<Integer, List<IG222Info>> map = new LinkedHashMap<Integer, List<IG222Info>>();
		for(IG222Info info:ppdlist){
			if(map.get(info.getRoleid()) == null){
				List<IG222Info> list = new ArrayList<IG222Info>();
				list.add(info);
				map.put(info.getRoleid(), list);
			}else{
				map.get(info.getRoleid()).add(info);
			}
		}
		dto.setProcessParticipantDefMap(map);
		dto.setProcessParticipantDefList(ppdlist);
		

		// ��ȡ����ӽ�ɫ
//		RoleSearchCondImpl as = new RoleSearchCondImpl();
//		as.setRoles_Like(WorkFlowConstDefine.PROCESS_ROLE_MARK);
//		as.setRoletype_gt(WorkFlowConstDefine.DISPATCH_ROLE_TYPE);
		//ȡ�����е����̽�ɫ���͵Ľ�ɫ�б�
		//List<Role> list = this.roleBL.searchRole(as, 0, 0);
		RoleSearchCondImpl cond1 = new RoleSearchCondImpl();
		cond1.setPdid(dto.getProcessStatusDef().getPdid());
		List<Role> list = roleBL.searchRoleForSelfDef(cond1,0,0);
		
		
//		if(ppdlist==null || ppdlist.size()==0){
			//����������ӵĽ�ɫ����
			dto.setRoleList(list);
//		}else{
//			List<Role> roleList = new ArrayList<Role>();
//			for(Role role:list){
//				boolean flag = true;
//				for(IG222Info ppd:ppdlist){
//					if(role.getRoleid().equals(ppd.getRoleid())){
//						flag = false;
//						break;
//					}
//				}
//				if(flag){
//					roleList.add(role);
//				}
//			}
//			
//			dto.setRoleList(roleList);
//		}
		
		log.debug("========����״̬�����߲�ѯ��������========");
		return dto;
	}
	
	 /**
     * ״̬������֧�ֻ���ѡ��
     * @param dto
     * @return
     * @throws BLException
     */
	public IGPRD01DTO getProcessParticipantsByOrg(IGPRD01DTO dto) throws BLException {
		log.debug("============��������Ϣ��ѯ������ʼ=============");
		//ҳ����Ϣȡ��
		IGPRD0134Form form = dto.getIgprd0134Form();
		//״̬��Ϣȡ��
		dto.setProcessStatusDef(workFlowDefinitionBL.searchProcessStatusDefByKey(form.getPsdid()));
		// ��ȡ����Ӳ�����
		IG222SearchCondImpl cond = new IG222SearchCondImpl();
		cond.setPsdid(form.getPsdid());
		cond.setIsOrg("Y");
		List<IG222Info> ppdlist = workFlowDefinitionBL.searchParticipantDef(cond);
		dto.setProcessParticipantDefList(ppdlist);
		//��ѯ��ѡ������
		List<IG123Info> poList = workFlowDefinitionBL.searchProcessOrgScopeByPdid(form.getPdid());
		List<IG123Info> orgList = new ArrayList<IG123Info>();
		if(poList!=null){
			for(IG123Info po:poList){
				//��������ʶ
				boolean flag = true;
				for(IG222Info ppd:ppdlist){
					if(po.getOrgid().equals(ppd.getOrgid())){
						flag = false;
						break;
					}
				}
				if(flag){
					orgList.add(po);
				}
			}
		}
		//�趨��ѡ��������Ϣ��dto
		dto.setLst_orgdef(orgList);
		log.debug("============��������Ϣ��ѯ��������=============");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: �������״̬������ 
	 * </p>
	 */
	
	public IGPRD01DTO addProcessParticipants(IGPRD01DTO dto) throws BLException {
		log.debug("========�������״̬�����ߴ���ʼ========");
		IGPRD0107Form form = dto.getIgPRD0107Form();
		//��ѯ����Ӳ�����
		IG222SearchCondImpl cond = new IG222SearchCondImpl();
		cond.setPsdid(form.getPsdid());
		List<IG222Info> ppdList = workFlowDefinitionBL.searchParticipantDef(cond);
		Map<Integer, Map<String, IG222Info>> ppdMap = new HashMap<Integer, Map<String,IG222Info>>();
		for(IG222Info info:ppdList){
			String key = StringUtils.isNotEmpty(info.getUserid()) ? info.getUserid() : "NOTHAVEUSER";
			Map<String, IG222Info> map = new HashMap<String, IG222Info>();
			map.put(key, info);
			if(ppdMap.get(info.getRoleid()) == null){
				ppdMap.put(info.getRoleid(), map);
			}else{
				ppdMap.get(info.getRoleid()).put(key, info);
			}
		}
		//����ָ��Ĭ�ϲ�����
		String[] ppuserids = form.getPpuserids();
		if(form.getRoleids() != null) {
			for(int i=0;i<form.getRoleids().length;i++){
				IG222TB newppd = new IG222TB();
				newppd.setPsdid(form.getPsdid());
				newppd.setRoleid(Integer.parseInt(form.getRoleids()[i]));
				if(ppuserids != null && StringUtils.isNotEmpty(ppuserids[i])) {
					newppd.setUserid(ppuserids[i]);
				}
				newppd.setPpdid(workFlowDefinitionBL.getParticipantDefPK(form.getPsdid()));
				if(ppdMap.get(newppd.getRoleid()) != null){
					if(ppdMap.get(newppd.getRoleid()).get("NOTHAVEUSER") != null){
						throw new BLException("IGCO00000.E007");
					}
					if(ppdMap.get(newppd.getRoleid()).get(ppuserids[i]) != null){
						throw new BLException("IGCO00000.E007");
					}
				}
				IG222Info info = workFlowDefinitionBL.registParticipantDef(newppd);
				String key = StringUtils.isNotEmpty(info.getUserid()) ? info.getUserid() : "NOTHAVEUSER";
				Map<String, IG222Info> map = new HashMap<String, IG222Info>();
				map.put(key, info);
				if(ppdMap.get(info.getRoleid()) == null){
					ppdMap.put(info.getRoleid(), map);
				}else{
					ppdMap.get(info.getRoleid()).put(key, info);
				}
				
				IG298Info psrdInfo = workFlowDefinitionBL.checkProcessStatusRoleDefInfo(form.getPsdid(), Integer.parseInt(form.getRoleids()[i]));
				if(psrdInfo == null) {
					IG298TB psrdTB = new IG298TB();
					psrdTB.setPsrdid(workFlowDefinitionBL.getProcessStatusRoleDefInfoPK(form.getPsdid()));
					psrdTB.setPsdid(form.getPsdid());
					psrdTB.setRoleid(Integer.parseInt(form.getRoleids()[i]));
					workFlowDefinitionBL.registProcessStatusRoleDefInfo(psrdTB);
				}
			}
		}


		dto.addMessage(new ActionMessage("IGPRD0107.I001",IGPRDCONSTANTS.PPD_ADD_PROCESSPARTICIPANT_MESSAGE));
		log.debug("========�������״̬�����ߴ�������========");
		return dto;
	}
	
	
	/**
	 * <p>
	 * Description: ɾ������״̬������
	 * </p>
	 */
	
	public IGPRD01DTO removeProcessParticipants(IGPRD01DTO dto) throws BLException {
		log.debug("======== ɾ������״̬�����ߴ���ʼ========");
		IGPRD0107Form form = dto.getIgPRD0107Form();
		//====> ��ܱ���Begin
		String message = "����";
		String pdid_one = StringUtils.isEmpty(form.getPdid()) ? "0" : form.getPdid().substring(0,1);
		if(IGPRDCONSTANTS.PRTYPE_YEAR_STATUS_ID.equals(pdid_one)
				|| IGPRDCONSTANTS.PRTYPE_SEASON_STATUS_ID.equals(pdid_one)
				|| IGPRDCONSTANTS.PRTYPE_IRREGULAR_STATUS_ID.equals(pdid_one)){
			message = "����";
			
		}
		//====> ��ܱ���End
		for(int i=0;i<form.getPpdids().length;i++){
			IG222SearchCondImpl cond = new IG222SearchCondImpl();
			cond.setPpdid(form.getPpdids()[i]);
			int totalCount = workFlowDefinitionBL.getParticipantSearchCount(cond);
			if(totalCount==0){
				//====> ��ܱ���Begin
				throw new BLException("IGPRD0105.E001",message + "״̬�����߲�����");
				//====> ��ܱ���End
			}else{
				IG222Info pppd = workFlowDefinitionBL.searchParticipantDefByKey(form.getPpdids()[i]);
				IG273SearchCondImpl ptdsCond = new IG273SearchCondImpl();
				ptdsCond.setFpsdid(pppd.getPsdid());
				List<IG273Info> ptdList = workFlowDefinitionBL.searchProcessTransitionDef(ptdsCond);
				boolean idDel = false;
				if(ptdList!=null&&ptdList.size()>0)
				{
					for(IG273Info ptd:ptdList){
						String ptdcond = ptd.getPtdcond();
						if(ptdcond!=null)
						{
							String[] orcond = ptdcond.split("[|]");
							if(orcond!=null&&orcond.length>0){
								String[] andcond = orcond[0].split("[#]");
								if(andcond!=null&&andcond.length>0){
									for(String andcondi:andcond){
										String[] roids = andcondi.split("[!]");
										if(pppd.getRoleid().toString().equals(roids[0])){
											idDel = true;
										}
									}
								}
							}
						}
					}
				}
				if(!idDel){
					IG222Info ppdInfo = workFlowDefinitionBL.deleteParticipantDefByKey(form.getPpdids()[i]);
					IG298Info psrdInfo = workFlowDefinitionBL.checkProcessStatusRoleDefInfo(ppdInfo.getPsdid(), ppdInfo.getRoleid());
					if(psrdInfo != null) {
						workFlowDefinitionBL.deleteProcessStatusRoleDefInfoByKey(psrdInfo.getPsrdid());
					}
				}else{
					//====> ��ܱ���Begin
					throw new BLException("IGPRD0105.E004",message + "״̬���������й���");
					//====> ��ܱ���End
				}
			}
			
		}
		
		dto.addMessage(new ActionMessage("IGPRD0107.I002",IGPRDCONSTANTS.PPD_REMOVE_PROCESSPARTICIPANT_MESSAGE));
		log.debug("======== ɾ������״̬�����ߴ�������========");
		return dto;
	}
	
	
	/**
	 * <p>
	 * Description: ����״̬������Ȩ��ҳ���ʼ��
	 * </p>
	 */
	
	public IGPRD01DTO processInfoParticipantDefInitAction(IGPRD01DTO dto) throws BLException {
		log.debug("=======����״̬������Ȩ��ҳ���ʼ������ʼ========");
		IGPRD0108Form form = dto.getIgPRD0108Form();
		
		//ȡ�õ�ǰ����״̬����Ϣ
		IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(form.getPsdid());
		dto.setProcessStatusDef(psd);
		// ��ȡ������Ȩ�޵Ĳ����߼��ò����ߵĶ�����Ȩ��Ϣ
		IG222Info ppd = this.workFlowDefinitionBL.searchParticipantDefByKey(form.getPpdid());
		dto.setProcessParticipantDef(ppd);
		
		//��ȡ����Ĭ�ϵİ�ť����ǰ״̬�Ѿ��趨�İ�ť
		IG221SearchCondImpl condImpl = new IG221SearchCondImpl();
		condImpl.setPpdid(ppd.getPpdid());
		List<IG221Info> lstButtonInfo = workFlowDefinitionBL.searchParticipantButtonVW(condImpl);
		dto.setProcessParticipantButtonDefVWInfoList(lstButtonInfo);
		
		form.setPbdid(new String[lstButtonInfo.size()]);
		form.setPpbdname(new String[lstButtonInfo.size()]);
		form.setPpbddesc(new String[lstButtonInfo.size()]);
		form.setPpbdauth(new String[lstButtonInfo.size()]);
		form.setPpbdid(new String[lstButtonInfo.size()]);
		form.setCheckrequired(new String[lstButtonInfo.size()]);
		form.setCheckrecord(new String[lstButtonInfo.size()]);
		form.setActurl(new String[lstButtonInfo.size()]);
		
		//�����߱���Ȩ��ȡ��
		IG100SearchCondImpl cond = new IG100SearchCondImpl();
		cond.setPsdid(form.getPsdid());
		cond.setPpdid(form.getPpdid());
		cond.setPdid(psd.getPdid());
		dto.setLst_ProcessInfoParticipantDefVW(workFlowDefinitionBL.searchProcessInfoParticipantDefVW(cond));
		log.debug("========����״̬������Ȩ��ҳ���ʼ����������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ����״̬��������Ȩ����
	 * </p>
	 */
	
	public IGPRD01DTO grantPermissionAction(IGPRD01DTO dto) throws BLException {
		log.debug("=======����״̬��������Ȩ����ʼ========");
		IGPRD0108Form form = dto.getIgPRD0108Form();
		String[] ppbdids = form.getPpbdid();//������ID
		String[] pbdids = form.getPbdid();//������ť����
		String[] ppbdnames = form.getPpbdname();//������ť���Ƽ���
		String[] ppbddescs = form.getPpbddesc();  //������ť��ʾ��Ϣ����  
		String[] ppbdauths = form.getPpbdauth();//�ύȨ��
		String[] checkrequired = form.getCheckrequired();//�Ƿ�У���������
		String[] checkrecord = form.getCheckrecord();//�Ƿ����¼����
		String[] acturl = form.getActurl();//����ҳjs����
		
		
		//ȡ�����а�ť����
		IG132SearchCondImpl condImpl = new IG132SearchCondImpl();
		condImpl.setPpdid(form.getPpdid());
		List<IG132Info> infoList = workFlowDefinitionBL.searchParticipantButtonDef(condImpl);
		List<String> defPKList = new ArrayList<String>(); 
		if(infoList != null && infoList.size() >= 0){
			for(IG132Info defInfo : infoList){
				defPKList.add(defInfo.getPpbdid());
			}
		}
		
		//����ò����ߵĶ�����ť��Ȩ��Ϣ
		if(pbdids!=null){
			for(int i= 0; i < pbdids.length; i++){
				if(StringUtils.isNotEmpty(pbdids[i])){
					if(StringUtils.isNotEmpty(ppbdids[i].trim())){
						//�ѱ����
						IG132Info info = workFlowDefinitionBL.searchParticipantButtonDefByKey(ppbdids[i]);
						IG132TB tb = (IG132TB)SerializationUtils.clone(info);
						tb.setPpbdname(ppbdnames[i]);
						tb.setPpbddesc(ppbddescs[i]);
						tb.setPpbdauth(ppbdauths[i]);
						tb.setCheckrequired(checkrequired[i]);
						tb.setCheckrecord(checkrecord[i]);
						if(acturl!=null && acturl.length>= pbdids.length){
							tb.setActurl(acturl[i]);
						}
						workFlowDefinitionBL.updateParticipantButtonDef(tb);
						
						//ȥ�����±������������
						if(defPKList.contains(ppbdids[i])){
							defPKList.remove(ppbdids[i]);
						}
					}else{
						//δ��������½�
						IG132TB tb = new IG132TB();
						tb.setPpbdid(workFlowDefinitionBL.getParticipantButtonDefPK(form.getPpdid()));
						tb.setPpdid(form.getPpdid());
						tb.setPbdid(pbdids[i]);
						tb.setPpbdname(ppbdnames[i]);
						tb.setPpbddesc(ppbddescs[i]);
						tb.setPpbdauth(ppbdauths[i]);
						tb.setCheckrequired(checkrequired[i]);
						tb.setCheckrecord(checkrecord[i]);
						if(acturl!=null && acturl.length>= pbdids.length){
							tb.setActurl(acturl[i]);
						}
						workFlowDefinitionBL.registParticipantButtonDef(tb);
					}
				}
			}
		}
		//ɾ������İ�ť
		if(defPKList.size() > 0){
			for(String pk : defPKList){
				workFlowDefinitionBL.deleteParticipantButtonDefByKey(pk);
			}
		} 
		
		String[] pidaccesses = form.getPidaccesses();//������ť����
		String[] pidids = form.getPidids();//����ID����
		String[] pipdids = form.getPipdids();//������_Ȩ������ID����
		String[] types = form.getTypes();//��0�����趨Ȩ�ޱ���1��δ�趨Ȩ�ޱ���
		String[] pidrequired = form.getPidrequired();
		String ppdid = form.getPpdid();//����Ȩ�����̲�����ID
		String psdid = form.getPsdid();//����״̬ID
		//����ò����ߵı�����Ȩ��Ϣ
		if(types != null && pidids != null && pidaccesses != null && pipdids != null){
			if(types.length == pidids.length 
					&& types.length == pidaccesses.length 
					&& types.length == pipdids.length) {
				for(int i = 0; i < pidids.length; i++) {
					//��������Ȩ�ı��������޸�Ȩ�޲���
					if("0".equals(types[i])) {
						IG881Info pipdInfo = workFlowDefinitionBL.searchProcessInfoParticipantDefByKey(pipdids[i]);
						if(!pidaccesses[i].equals(pipdInfo.getProcessInfoDef().getPidaccess()) || !pidrequired[i].equals(pipdInfo.getProcessInfoDef().getPidrequired())) {
							IG881TB pipdTB = (IG881TB)SerializationUtils.clone(pipdInfo);
							pipdTB.setPidaccess(pidaccesses[i]);
							pipdTB.setPidrequired(pidrequired[i]);
							workFlowDefinitionBL.updateProcessInfoParticipantDef(pipdTB);
						}
					} else if("1".equals(types[i])) {//����δ��Ȩ�ı�����������Ȩ�޲���
						IG007Info pidInfo = workFlowDefinitionBL.searchProcessInfoDefByKey(pidids[i]);
						IG881TB pipdTB = new IG881TB();
						pipdTB.setPipdid(workFlowDefinitionBL.getProcessInfoParticipantDefPK(ppdid));
						pipdTB.setPidid(pidInfo.getPidid());
						pipdTB.setPidaccess(pidaccesses[i]);
						pipdTB.setPsdid(psdid);
						pipdTB.setPpdid(ppdid);
						pipdTB.setPidrequired(pidrequired[i]);
						workFlowDefinitionBL.registProcessInfoParticipantDef(pipdTB);
					} else {
						throw new BLException("IGCO10000.E004","����Ȩ������");
					}
				}
			} else {
				throw new BLException("IGPRD0108.E002");
			}
		}
		dto.addMessage(new ActionMessage("IGPRD0108.I002"));
		log.debug("========����״̬��������Ȩ��������========");
		return dto;
	}
	
	/**
	 * ������ط�����Զ�������������Ϣ
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO grantRelevantProcessAction(IGPRD01DTO dto) throws BLException{
	    
	    IGPRD0108Form  form = dto.getIgPRD0108Form();
        String[] psprpids = form.getPsprpid();//״̬�����߿���ط��������������Ϣ����������
        String[] relevantPdids = form.getRelevantPdid();//ҳ����ѡ����Զ�����������id����
        
    	// ȡ�õ�ǰ״̬��������Ϣ
        IG222Info ig222info = workFlowDefinitionBL.searchParticipantDefByKey(form.getPpdid());
        dto.setProcessParticipantDef(ig222info);
        // ����״̬�����߿���ط��������������Ϣ
        for(int i = 0 ; i < psprpids.length ; i++) {
            if (StringUtils.isNotEmpty(relevantPdids[i]) && StringUtils.isEmpty(psprpids[i])) {
                // ����
                IG911TB ig911TB = new IG911TB();
                ig911TB.setPsprpid(workFlowDefinitionBL.getParticipantRelevantDefPK(form.getPsdid()));
                ig911TB.setPdid(form.getPdid());
                ig911TB.setPsdid(form.getPsdid());
                ig911TB.setRelevantPdid(relevantPdids[i]);
                ig911TB.setRoleid(ig222info.getRoleid());
                workFlowDefinitionBL.registParticipantRelevantDefInfo(ig911TB);
            } else if (StringUtils.isEmpty(relevantPdids[i]) && StringUtils.isNotEmpty(psprpids[i])) {
                // ɾ��
                workFlowDefinitionBL.deleteParticipantRelevantDefInfoByKey(psprpids[i]);
            }
        }
        return dto;
	}
	
	/**
     * ����ȱʡȨ�޵���ط�����Զ�������������Ϣ
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGPRD01DTO grantDefaultRelevantProcessAction(IGPRD01DTO dto) throws BLException{
        
        IGPRD0116Form  form = dto.getIgPRD0116Form();
        String[] dpsprpids = form.getDpsprpid();//״̬�����߿���ط��������������Ϣ����������
        String[] relevantPdids = form.getRelevantPdid();//ҳ����ѡ����Զ�����������id����
        
        // ����ȱʡȨ�޵Ŀ���ط��������������Ϣ
        for(int i = 0 ; i < dpsprpids.length ; i++) {
            if (StringUtils.isNotEmpty(relevantPdids[i]) && StringUtils.isEmpty(dpsprpids[i])) {
                // ����
                IG931TB ig931TB = new IG931TB();
                ig931TB.setDpsprpid(workFlowDefinitionBL.getDefaultParticipantRelevantDefPK(form.getPsdid()));
                ig931TB.setPdid(form.getPdid());
                ig931TB.setPsdid(form.getPsdid());
                ig931TB.setRelevantPdid(relevantPdids[i]);
                workFlowDefinitionBL.registDefaultParticipantRelevantDefInfo(ig931TB);
            } else if (StringUtils.isEmpty(relevantPdids[i]) && StringUtils.isNotEmpty(dpsprpids[i])) {
                // ɾ��
                workFlowDefinitionBL.deleteDefaultParticipantRelevantDefInfoByKey(dpsprpids[i]);
            }
        }
        return dto;
    }
    
	/**
	 * <p>
	 * Description: ����״̬ȱʡ������Ȩ��ҳ���ʼ��
	 * </p>
	 */
	
	public IGPRD01DTO participantDefaultVariableInitAction(IGPRD01DTO dto) throws BLException {
		log.debug("=======����״̬ȱʡ������Ȩ��ҳ���ʼ������ʼ========");
		IGPRD0116Form form = dto.getIgPRD0116Form();
		
		//ȡ�õ�ǰ����״̬����Ϣ
		IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(form.getPsdid());
		dto.setProcessStatusDef(psd);
		
		//��ȡ����Ĭ�ϵİ�ť����ǰ״̬�Ѿ��趨��ȱʡ��ť
		IG221SearchCondImpl condImpl = new IG221SearchCondImpl();
		condImpl.setPsdid(form.getPsdid());
		List<IG221Info> lstButtonInfo = workFlowDefinitionBL.searchDefaultParticipantButtonVW(condImpl);
		dto.setProcessParticipantButtonDefVWInfoList(lstButtonInfo);
		
		form.setPdbdid(new String[lstButtonInfo.size()]);
		form.setPdbdname(new String[lstButtonInfo.size()]);
		form.setPdbddesc(new String[lstButtonInfo.size()]);
		form.setPdbdauth(new String[lstButtonInfo.size()]);
		form.setPbdid(new String[lstButtonInfo.size()]);
		form.setCheckrequired(new String[lstButtonInfo.size()]);
		form.setCheckrecord(new String[lstButtonInfo.size()]);
		form.setActurl(new String[lstButtonInfo.size()]);
		
		//ȱʡ����Ȩ��ȡ��
		IG909SearchCondImpl cond = new IG909SearchCondImpl();
		cond.setPsdid(form.getPsdid());
		cond.setPdid(psd.getPdid());
		dto.setLst_ParticipantDefaultVariableVW(workFlowDefinitionBL.searchParticipantDefaultVariableVW(cond));
		
		log.debug("========����״̬ȱʡ������Ȩ��ҳ���ʼ����������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ����״̬ȱʡ��������Ȩ����
	 * </p>
	 */
	
	public IGPRD01DTO grantDefaultPermissionAction(IGPRD01DTO dto) throws BLException {
		log.debug("=======����״̬ȱʡ��������Ȩ����ʼ========");
		IGPRD0116Form form = dto.getIgPRD0116Form();
		String[] pidaccesses = form.getPidaccesses();//������ť����
		String[] pidrequired = form.getPidrequired();//����������
		String[] pidids = form.getPidids();//����ID����
		String[] pdvids = form.getPdvids();//������_Ȩ������ID����
		String[] types = form.getTypes();//��0�����趨Ȩ�ޱ���1��δ�趨Ȩ�ޱ���
		String psdid = form.getPsdid();//����״̬ID
		
		//***********************************��ť����**************************************
		String[] pdbdids = form.getPdbdid();//������ID
		String[] pbdids = form.getPbdid();//������ť����
		String[] pdbdnames = form.getPdbdname();//������ť���Ƽ���
		String[] pdbddescs = form.getPdbddesc();  //������ť��ʾ��Ϣ����  
		String[] pdbdauths = form.getPdbdauth();//�ύȨ��
		String[] checkrequired = form.getCheckrequired();//�Ƿ�У���������
		String[] checkrecord = form.getCheckrecord();//�Ƿ����¼����
		String[] acturl = form.getActurl();//����ҳjs����
		
		//ȡ�����а�ť����
		IG725SearchCondImpl condImpl = new IG725SearchCondImpl();
		condImpl.setPsdid(form.getPsdid());
		List<IG725Info> infoList = workFlowDefinitionBL.searchParticipantDefaultButtonDef(condImpl);
		List<String> defPKList = new ArrayList<String>(); 
		if(infoList != null && infoList.size() >= 0){
			for(IG725Info defInfo : infoList){
				defPKList.add(defInfo.getPdbdid());
			}	
		}
		
		//����ò����ߵĶ�����ť��Ȩ��Ϣ
		if(pbdids!=null){
			for(int i= 0; i < pbdids.length; i++){
				if(StringUtils.isNotEmpty(pbdids[i])){
					if(StringUtils.isNotEmpty(pdbdids[i].trim())){
						//�ѱ����
						IG725Info info = workFlowDefinitionBL.searchParticipantDefaultButtonDefByKey(pdbdids[i]);
						IG725TB tb = (IG725TB)SerializationUtils.clone(info);
						tb.setPdbdname(pdbdnames[i]);
						tb.setPdbddesc(pdbddescs[i]);
						tb.setPdbdauth(pdbdauths[i]);
						tb.setCheckrequired(checkrequired[i]);
						tb.setCheckrecord(checkrecord[i]);
						if(acturl!=null && acturl.length>= pbdids.length){
							tb.setActurl(acturl[i]);
						}
						workFlowDefinitionBL.updateParticipantDefaultButtonDef(tb);
						
						//ȥ�����±������������
						if(defPKList.contains(pdbdids[i])){
							defPKList.remove(pdbdids[i]);
						}
					}else{
						//δ��������½�
						IG725TB tb = new IG725TB();
						tb.setPdbdid(workFlowDefinitionBL.getParticipantDefaultButtonDefPK(form.getPsdid()));
						tb.setPsdid(form.getPsdid());
						tb.setPbdid(pbdids[i]);
						tb.setPdbdname(pdbdnames[i]);
						tb.setPdbddesc(pdbddescs[i]);
						tb.setPdbdauth(pdbdauths[i]);
						tb.setCheckrequired(checkrequired[i]);
						tb.setCheckrecord(checkrecord[i]);
						if(acturl!=null && acturl.length>= pbdids.length){
							tb.setActurl(acturl[i]);
						}
						workFlowDefinitionBL.registParticipantDefaultButtonDef(tb);
					}
				}
			}
		}
		//ɾ������İ�ť
		if(defPKList.size() > 0){
			for(String pk : defPKList){
				workFlowDefinitionBL.deleteParticipantDefaultButtonDefByKey(pk);
			}
		} 
		
		//����ò����ߵı�����Ȩ��Ϣ
		if(types != null && pidids != null && pidaccesses !=null && pdvids != null){
			if(types.length == pidids.length 
					&& types.length == pidaccesses.length 
					&& types.length == pdvids.length) {
				for(int i = 0; i < pidids.length; i++) {
					//��������Ȩ�ı��������޸�Ȩ�޲���
					if("0".equals(types[i])) {
						IG699Info pipdInfo = workFlowDefinitionBL.searchParticipantDefaultVariableByKey(pdvids[i]);
						if(!pidaccesses[i].equals(pipdInfo.getPidaccess()) || !pidrequired[i].equals(pipdInfo.getPidrequired())) {
							IG699TB pipdTB = (IG699TB)SerializationUtils.clone(pipdInfo);
							pipdTB.setPidaccess(pidaccesses[i]);
							pipdTB.setPidrequired(pidrequired[i]);
							workFlowDefinitionBL.updateParticipantDefaultVariable(pipdTB);
						}
					} else if("1".equals(types[i])) {//����δ��Ȩ�ı�����������Ȩ�޲���
						IG007Info pidInfo = workFlowDefinitionBL.searchProcessInfoDefByKey(pidids[i]);
						IG699TB pipdTB = new IG699TB();
						pipdTB.setPdvid(workFlowDefinitionBL.getParticipantDefaultVariablePK(psdid));
						pipdTB.setPidid(pidInfo.getPidid());
						pipdTB.setPidaccess(pidaccesses[i]);
						pipdTB.setPidrequired(pidrequired[i]);
						pipdTB.setPsdid(psdid);
						workFlowDefinitionBL.registParticipantDefaultVariable(pipdTB);
					} else {
						throw new BLException("IGCO10000.E004","����Ȩ������");
					}
				}
			} else {
				throw new BLException("IGPRD0108.E002");
			}
		}
		
		dto.addMessage(new ActionMessage("IGPRD0108.I002"));
		log.debug("========����״̬ȱʡ��������Ȩ��������========");
		return dto;
	}
	
	//-----------------------------------------------------------��̬��ǩ----------------------------------------------------------------------
	
	/**
	 * <p>
	 * Description: �������̶���id������״̬ȡ�ø�����״̬������
	 * </p>
	 */
	
	public String getPsNameByPdidAndPsdidAction(String pdid,String psdcode) {
		String typename = "";
		//�Զ�������������ֹ״̬ start wangtingzhi 20130422
		if(StringUtils.isNotEmpty(psdcode)&&IGPRDCONSTANTS.PROCESS_TERMINATE.equals(psdcode)){
			//modify by zhaoyong
			return "��ֹ";
		}
		//�Զ�������������ֹ״̬ start end 20130422
		IG333SearchCondImpl cond = new IG333SearchCondImpl();
		cond.setPdid(pdid);
		cond.setPsdcode(psdcode);
		List<IG333Info> list = workFlowDefinitionBL.searchProcessStatusDef(cond);
		if(list!=null && list.size()>0){
			typename = list.get(0).getPsdname();
		}
		return typename;
	}
	
	//-----------------------------------------------------------����ͼ----------------------------------------------------------------------

	/**
	 * ����ͼ����״̬
	 * 
	 * @param root
	 * @param psdid
	 */
	@SuppressWarnings("unchecked")
	private void addStep(Element root, String psdid, String psdname, String psdtype) {
		for (Iterator<Element> steps = root.elementIterator("Steps"); steps.hasNext();) {
			Element stepsElement = (Element) steps.next();
			Element stepElement = stepsElement.addElement("Step");
			//����xml�еĸ�����ǩ
			createBasePropertiesElementOfStep(stepElement, psdid, psdname, psdtype);
			createVMLPropertiesElementOfStep(stepElement);
			createFlowPropertiesElementOfStep(stepElement);
		}
	}
	
	/**
	 * ����ͼɾ��״̬
	 * 
	 * @param root
	 * @param psdid
	 */
	@SuppressWarnings("unchecked")
	private void removeStep(Element root, String psdid) {
		for (Iterator<Element> steps = root.elementIterator("Steps"); steps.hasNext();) {
			Element stepsElement = (Element) steps.next();
			for (Iterator<Element> step = stepsElement.elementIterator("Step"); step.hasNext();) {
				Element stepElement = (Element) step.next();
				for (Iterator<Element> baseProperties = stepElement.elementIterator("BaseProperties"); baseProperties.hasNext();) {
					Element bp = (Element) baseProperties.next();
					for (Iterator<Attribute> i = bp.attributeIterator(); i.hasNext();) {
						Attribute attribute = (Attribute) i.next();
						if (psdid.equals(attribute.getValue())) {
							stepsElement.remove(stepElement);
							return;
						}
					}

				}
			}
		}
	}
	
	/**
	 * ������
	 * 
	 * @param root
	 * @param psdid
	 */
	@SuppressWarnings("unchecked")
	private void addAction(Element root, String ptdid, String ptdname,String fpsdid, String tpsdid) {
		for (Iterator<Element> actions = root.elementIterator("Actions"); actions.hasNext();) {
			Element actionsElement = (Element) actions.next();
			Element actionElement = actionsElement.addElement("Action");

			createBasePropertiesElementOfAction(actionElement, ptdid, ptdname,fpsdid, tpsdid);
			createVMLPropertiesElementOfAction(actionElement);
			createFlowPropertiesElementOfAction(actionElement);
		}
	}

	/**
	 * ɾ���㼰�������ϵ���
	 * 
	 * @param root
	 * @param psdid
	 */
	@SuppressWarnings("unchecked")
	private void removeStepandActions(Element root, String psdid) {
		for (Iterator<Element> actions = root.elementIterator("Actions"); actions.hasNext();) {
			Element actionsElement = (Element) actions.next();
			for (Iterator<Element> action = actionsElement
					.elementIterator("Action"); action.hasNext();) {
				Element actionElement = (Element) action.next();
				for (Iterator<Element> baseProperties = actionElement
						.elementIterator("BaseProperties"); baseProperties
						.hasNext();) {
					Element bp = (Element) baseProperties.next();
					for (Iterator<Attribute> i = bp.attributeIterator(); i
							.hasNext();) {
						Attribute attribute = (Attribute) i.next();
						if (attribute.getName().equals("from")
								|| attribute.getName().equals("to")) {
							if (psdid.equals(attribute.getValue())) {
								actionsElement.remove(actionElement);
							}
						}
					}

				}
			}
		}
	}
	
	/**
	 * ɾ����
	 * 
	 * @param root
	 * @param psdid
	 */
	@SuppressWarnings("unchecked")
	private void removeActions(Element root, String ptdid) {
		ptdid = IGPRDCONSTANTS.IMG_ACTION_ID_BEGIN_WITH+ptdid;
		for (Iterator<Element> actions = root.elementIterator("Actions"); actions.hasNext();) {
			Element actionsElement = (Element) actions.next();
			for (Iterator<Element> action = actionsElement
					.elementIterator("Action"); action.hasNext();) {
				Element actionElement = (Element) action.next();
				for (Iterator<Element> baseProperties = actionElement
						.elementIterator("BaseProperties"); baseProperties
						.hasNext();) {
					Element bp = (Element) baseProperties.next();
					for (Iterator<Attribute> i = bp.attributeIterator(); i
							.hasNext();) {
						Attribute attribute = (Attribute) i.next();
						if (attribute.getName().equals("id")) {
							if (ptdid.equals(attribute.getValue())) {
								actionsElement.remove(actionElement);
							}
						}
					}

				}
			}
		}
	}

	private void createBasePropertiesElementOfStep(Element step,String psdid, String psdname, String psdtype) {
		Element bp = step.addElement("BaseProperties");
		bp.addAttribute("id", psdid);
		bp.addAttribute("text", psdname);
		bp.addAttribute("stepType", "NormalStep");
		bp.addAttribute("psdtype", psdtype);//�ڵ�����
	}

	private void createVMLPropertiesElementOfStep(Element step) {
		String x = ResourceUtility.getString("PDIMG_DEFAULT_ADD_X")==null?"500":ResourceUtility.getString("PDIMG_DEFAULT_ADD_X");//����״̬��������Ĭ�Ϻ�����
		String y = ResourceUtility.getString("PDIMG_DEFAULT_ADD_Y")==null?"342":ResourceUtility.getString("PDIMG_DEFAULT_ADD_Y");//����״̬��������Ĭ��������
		String pdimg_default_width = ResourceUtility.getString("PDIMG_DEFAULT_WIDTH")==null?"50":ResourceUtility.getString("PDIMG_DEFAULT_WIDTH");//����״̬���Ŀ��
		String pdimg_default_height = ResourceUtility.getString("PDIMG_DEFAULT_HEIGHT")==null?"80":ResourceUtility.getString("PDIMG_DEFAULT_HEIGHT");//����״̬���ĸ߶�
		
		Element vml = step.addElement("VMLProperties");
		vml.addAttribute("width", pdimg_default_width);
		vml.addAttribute("height", pdimg_default_height);
		vml.addAttribute("x", (x+"px"));
		vml.addAttribute("y", (y+"px"));
		vml.addAttribute("textWeight", "");
		vml.addAttribute("strokeWeight", "");
		vml.addAttribute("isFocused", "");
		vml.addAttribute("zIndex", "40");
	}

	private void createFlowPropertiesElementOfStep(Element step) {
		step.addElement("FlowProperties");
	}

	private void createBasePropertiesElementOfAction(Element step,
			String ptdid, String ptdname, String fpsdid, String tpsdid) {
		Element bp = step.addElement("BaseProperties");
		bp.addAttribute("id", IGPRDCONSTANTS.IMG_ACTION_ID_BEGIN_WITH+ptdid);
		bp.addAttribute("text", ptdname);
		bp.addAttribute("actionType", "PolyLine");
		bp.addAttribute("from", fpsdid);
		bp.addAttribute("to", tpsdid);
	}

	private void createVMLPropertiesElementOfAction(Element step) {
		Element vml = step.addElement("VMLProperties");
		vml.addAttribute("startArrow", "");
		vml.addAttribute("endArrow", "Classic");
		vml.addAttribute("strokeWeight", "");
		vml.addAttribute("isFocused", "");
		vml.addAttribute("zIndex", "39");
	}

	private void createFlowPropertiesElementOfAction(Element step) {
		step.addElement("FlowProperties");
	}
	
	/**
	 * <p>
	 * Description: ��������ͼ
	 * </p>
	 */
	
	private void saveXml(IG380Info pd,Document document) throws BLException {
		IG380TB pdtb = (IG380TB)SerializationUtils.clone(pd);
		pdtb.setPdxml(document.getRootElement().asXML().replaceAll("\"", "'"));
		workFlowDefinitionBL.updateProcessDefinition(pdtb);
	}

	/**
	 * <p>
	 * Description: ��������������ͼ
	 * </p>
	 */
	
	private void saveChildXml(IG333Info psd,Document document) throws BLException {
		IG333TB psdtb = (IG333TB)SerializationUtils.clone(psd);
		psdtb.setPsdxml(document.getRootElement().asXML().replaceAll("\"", "'"));
		workFlowDefinitionBL.updateProcessStatus(psdtb);
	}
	
	/**
	 * <p>
	 * Description: ��������״̬�����򹹽�����ͼ
	 * </p>
	 */
	
	public IGPRD01DTO initVmlAction(IGPRD01DTO dto) throws BLException {
		IGPRD0104Form form = dto.getIgPRD0104Form();
		//====> ��ܱ���Begin
		String message = "����";
		String pdid_one = StringUtils.isEmpty(form.getPdid()) ? "0" : form.getPdid().substring(0,1);
		if(IGPRDCONSTANTS.PRTYPE_YEAR_STATUS_ID.equals(pdid_one)
				|| IGPRDCONSTANTS.PRTYPE_SEASON_STATUS_ID.equals(pdid_one)
				|| IGPRDCONSTANTS.PRTYPE_IRREGULAR_STATUS_ID.equals(pdid_one)){
			message = "����";
			
		}
		//====> ��ܱ���End
		if (StringUtils.isEmpty(nullToString(form.getPpsdid()))) {
			
			IG333SearchCondImpl cond = new IG333SearchCondImpl();
			cond.setPdid(form.getPdid());
			cond.setFatherflag("Y");
			List<IG333Info> pslist = workFlowDefinitionBL.searchProcessStatusDef(cond);
			if(pslist!=null && pslist.size()>1){
				IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(form.getPdid());
				if(pd!=null){
					if(pd.getPdxml()!=null && !"".equals(pd.getPdxml())){
						//��ȡ������λ�õ�����ͼ�μ�¼
						dto.setImgxml(new String(pd.getPdxml()));
					}else{
						//��ʼ������ͼ�μ�¼
						dto.setImgxml(getProcessDefinitionImgXml(pslist,pd));
					}
				}else{
					//====> ��ܱ���Begin
					throw new BLException("IGPRD0101.E002",message + "���岻���ڡ�");
					//====> ��ܱ���End
				}
				
			}else{
				//====> ��ܱ���Begin
				throw new BLException("IGPRD0104.E002","��" + message + "ȱ��Ĭ�Ͽ�ʼ״̬�����״̬��");
				//====> ��ܱ���End
			}
		} else {
			
			message = "�����̽ڵ�";
			IG333SearchCondImpl cond = new IG333SearchCondImpl();
			cond.setPdid(form.getPdid());
			cond.setPpsdid(form.getPpsdid());
			List<IG333Info> pslist = workFlowDefinitionBL.searchProcessStatusDef(cond);
			if(pslist!=null && pslist.size()>1){
				IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(form.getPdid());
				IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(form.getPpsdid());
				if(psd!=null){
					if(psd.getPsdxml()!=null && !"".equals(psd.getPsdxml())){
						//��ȡ������λ�õ�����ͼ�μ�¼
						dto.setImgxml(new String(psd.getPsdxml()));
					}else{
						//��ʼ������ͼ�μ�¼
						dto.setImgxml(getProcessDefinitionImgXml(pslist,pd));
					}
				}else{
					//====> ��ܱ���Begin
					throw new BLException("IGPRD0101.E002",message + "���岻���ڡ�");
					//====> ��ܱ���End
				}
				
			}else{
				//====> ��ܱ���Begin
				throw new BLException("IGPRD0104.E002","��" + message + "ȱ��Ĭ�Ͽ�ʼ״̬�����״̬��");
				//====> ��ܱ���End
			}
		}
		
		return dto;
	}
	
	/**
	 * ȡ������ͼ�ν��xml
	 */
	private String getNodeXml(IG333Info psd,String new_x,String new_y,String width,String height,String default_x_distance,
			String default_y_distance,String default_panel_width,String default_panel_height, String psdtype) throws BLException {
		
		StringBuffer xml = new StringBuffer();
		xml.append("<Step>");
		xml.append("<BaseProperties id='");
		if(psd!=null){
			xml.append(psd.getPsdid());
			xml.append("' text='");
			xml.append(psd.getPsdname());
		}else{
			xml.append("δ֪ID");
			xml.append("' text='");
			xml.append("δ֪״̬");
		}
		if(IGPRDCONSTANTS.PROCESS_START_STATUS.equals(psd.getPsdcode())){
			//����״̬
			xml.append("' stepType='BeginStep'");
			xml.append(" psdtype='");
			xml.append(psdtype);
			xml.append("'/>");
			xml.append("<VMLProperties width='");
			xml.append(width);
			xml.append("' height='");
			xml.append(height);
			xml.append("' x='155px' y='142px' textWeight='' strokeWeight='' zIndex='40'/>");
			xml.append("<FlowProperties/>");
			xml.append("</Step>");
		}else if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode()) || (StringUtils.isNotEmpty(psd.getPpsdid()) && IGPRDCONSTANTS.PROCESS_END_SUBSTATUS.equals(psd.getPsdcode()))){
			//����״̬
			xml.append("' stepType='EndStep'");
			xml.append(" psdtype='");
			xml.append(psdtype);
			xml.append("'/>");
			xml.append("<VMLProperties width='");
			xml.append(width);
			xml.append("' height='");
			xml.append(height);
			xml.append("' x='1406px' y='346px' textWeight='' strokeWeight='' zIndex='40'/>");
			xml.append("<FlowProperties/>");
			xml.append("</Step>");
		}else{

			xml.append("' stepType='NormalStep'");
			xml.append(" psdtype='");
			xml.append(psdtype);
			xml.append("'/>");
			xml.append("<VMLProperties width='");
			xml.append(width);
			xml.append("' height='");
			xml.append(height);
			xml.append("' x='");
			xml.append(new_x);
			xml.append("px' y='");
			xml.append(new_y);
			xml.append("px' textWeight='' strokeWeight='' isFocused='' zIndex='40'/>");
//			xml.append("");
//			xml.append("' zIndex='40'/>");
			
			xml.append("<FlowProperties/>");
			xml.append("</Step>");
		}
		
		
		return xml.toString();
	}
	
	
	/**
	 * ȡ������ͼ�ν��֮�������xml
	 */
	private String getLinebetweenNodesXml(String ptdid,String from_id,String to_id,String ptdname) {
		
		StringBuffer xml = new StringBuffer();
		xml.append("<Action>");
		xml.append("<BaseProperties id='");
		xml.append(IGPRDCONSTANTS.IMG_ACTION_ID_BEGIN_WITH+ptdid);
		xml.append("' text='");
		xml.append(ptdname);
		xml.append("' actionType='PolyLine' from='");
		xml.append(from_id);
		xml.append("' to='");
		xml.append(to_id);
		xml.append("'/>");
		xml.append("<VMLProperties startArrow='' endArrow='Classic' strokeWeight='' isFocused='' zIndex='39'/>");
//		xml.append("");
//		xml.append("' zIndex='39'/>");
		xml.append("<FlowProperties/>");
		xml.append("</Action>");
		return xml.toString();
	}

	/**
	 * ȡ������ͼ��xml
	 * @param  ����״̬����
	 * @param  ���̹��򼯺�
	 * @return ���ز�ѯ�����xml
	 */
	private String getProcessDefinitionImgXml(List<IG333Info> pslist,IG380Info pd) throws BLException{

		String default_panel_width = ResourceUtility.getString("DEFAULT_PANEL_WIDTH")==null?"2000":ResourceUtility.getString("DEFAULT_PANEL_WIDTH");//����Ĭ�Ͽ�ȣ�2000��
		String default_panel_height = ResourceUtility.getString("DEFAULT_PANEL_HEIGHT")==null?"2000":ResourceUtility.getString("DEFAULT_PANEL_HEIGHT");//����Ĭ�ϸ߶ȣ�2000��
		String default_width = ResourceUtility.getString("PDIMG_DEFAULT_WIDTH")==null?"50":ResourceUtility.getString("PDIMG_DEFAULT_WIDTH");//Ĭ������״̬���Ŀ��
		String default_height = ResourceUtility.getString("PDIMG_DEFAULT_HEIGHT")==null?"80":ResourceUtility.getString("PDIMG_DEFAULT_HEIGHT");//Ĭ������״̬���ĸ߶�
		String default_x_distance = ResourceUtility.getString("PDIMG_DEFAULT_X_DISTANCE")==null?"406":ResourceUtility.getString("PDIMG_DEFAULT_X_DISTANCE");//Ĭ�ϸ�����״̬���֮��Ŀ�Ȳ�
		String default_y_distance = ResourceUtility.getString("PDIMG_DEFAULT_Y_DISTANCE")==null?"406":ResourceUtility.getString("PDIMG_DEFAULT_Y_DISTANCE");//Ĭ�ϸ�����״̬���֮��ĸ߶Ȳ�
		int x = Integer.valueOf(ResourceUtility.getString("PDIMG_DEFAULT_X")==null?"466":ResourceUtility.getString("PDIMG_DEFAULT_X"));//����״̬�����ʼ������(466)
		int y = Integer.valueOf(ResourceUtility.getString("PDIMG_DEFAULT_Y")==null?"488":ResourceUtility.getString("PDIMG_DEFAULT_Y"));//����״̬�����ʼ������(488)
		//boolean flag = false;//�Ƿ�ֻ�������𡢽�����������״̬
//		if(pslist.size()==2){
//			//ֻ���ڿ�ʼ״̬������״̬
//			flag = true;
//		}
		
		
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version='1.0' encoding='GBK'?>");
		xml.append("<WebFlow>");
		
		xml.append("<FlowConfig>");
		
		//����<BaseProperties>����
		xml.append("<BaseProperties flowId='");
		xml.append(pd.getPdid());
		xml.append("'");
		xml.append(" flowText='");
		xml.append(pd.getPdname());//���Զ������̵�����
		xml.append("'/>");
	
		//����<VMLProperties>����
		xml.append("<VMLProperties stepTextColor='blue' stepStrokeColor='blue' stepShadowColor='#b3b3b3' stepFocusedStrokeColor='yellow' isStepShadow='T' actionStrokeColor='blue' actionTextColor='' actionFocusedStrokeColor='yellow' sStepTextColor='blue' sStepStrokeColor='blue' stepColor1='white' stepColor2='white' isStep3D='false' step3DDepth='20'/>");
		//xml.append("<VMLProperties stepTextColor='#000' stepStrokeColor='blue' stepShadowColor='gray' stepFocusedStrokeColor='yellow' isStepShadow='T' actionStrokeColor='#4677BF' actionTextColor='' actionFocusedStrokeColor='yellow' sStepTextColor='navy' sStepStrokeColor='navy' stepColor1='#A8A8A8' stepColor2='#D7D7D7' isStep3D='true' step3DDepth='10'/>");
	
		//����<FlowProperties>����
		xml.append("<FlowProperties flowMode='' startTime='' endTime='' ifMonitor='' runMode='' noteMode='' activeForm='' autoExe=''/>");
		xml.append("</FlowConfig>");
		xml.append("<Steps isFocusedId=''>");
		
		
		
		
		//��ʼ����������״̬���xml
		x = x+Integer.valueOf(default_x_distance);
		if((x+Integer.valueOf(default_x_distance))>(Integer.valueOf(default_panel_width)-Integer.valueOf(default_x_distance))){
			x = Integer.valueOf(ResourceUtility.getString("PDIMG_DEFAULT_X")==null?"466":ResourceUtility.getString("PDIMG_DEFAULT_X"));
			y = y+Integer.valueOf(default_y_distance);
//			if(y>(Integer.valueOf(default_panel_height)-Integer.valueOf(default_y_distance))){
//				throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,"IGPRD0104.E003","��ǰ���̵�����״̬ͼģ��ĸ߶����ù�С��������ģ��ĸ߶ȡ�");
//			}
		}
		for(IG333Info psd:pslist){
//			if(!IGPRDCONSTANTS.PROCESS_START_STATUS.equals(psd.getPsdcode()) && !IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode())){
//				//�ǿ�ʼ������״̬ʱ������һ������λ��
//				
//				
//			}
//			
			
			String new_x = String.valueOf(x);//��һ�����ĺ�����
			String new_y = String.valueOf(y);//��һ������������

				
			xml.append(getNodeXml(psd,new_x,new_y,default_width,default_height,default_x_distance,default_y_distance,default_panel_width,default_panel_height,psd.getPsdtype()));


		}
		xml.append("</Steps>");
		
		x = Integer.valueOf(ResourceUtility.getString("PDIMG_DEFAULT_X")==null?"466":ResourceUtility.getString("PDIMG_DEFAULT_X"));//����״̬�����ʼ������(466)
		y = Integer.valueOf(ResourceUtility.getString("PDIMG_DEFAULT_Y")==null?"488":ResourceUtility.getString("PDIMG_DEFAULT_Y"));//����״̬�����ʼ������(488)
		//��ʼ����������״̬���֮������xml
		xml.append("<Actions>");
		
		for(int i=0,j=pslist.size();i<j;i++){
			IG333Info psd = pslist.get(i);
			IG273SearchCondImpl cond = new IG273SearchCondImpl();
			cond.setFpsdid(psd.getPsdid());
			List<IG273Info> ptdlist = workFlowDefinitionBL.searchProcessTransitionDef(cond);
			if(ptdlist!=null && ptdlist.size()>0){
				for(int n=0,m=ptdlist.size();n<m;n++){
					IG273Info ptd = ptdlist.get(n);
					xml.append(getLinebetweenNodesXml(String.valueOf(ptd.getPtdid()),String.valueOf(psd.getPsdid()),String.valueOf(ptd.getTpsdid()),ptd.getPtdname()));
				}

			}
			
		}
		xml.append("</Actions>");	
		xml.append("</WebFlow>");
		
		
		return xml.toString();
	}
	
	/**
	 * <p>
	 * Description: ��������ͼ
	 * </p>
	 */
	
	public IGPRD01DTO savePdXmlAction(IGPRD01DTO dto) throws BLException {
		IGPRD0104Form form = dto.getIgPRD0104Form();
		
		if (StringUtils.isEmpty(nullToString(form.getPpsdid()))) {
			
			IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(form.getPdid());
			//����
			IG380TB pdtb = (IG380TB)SerializationUtils.clone(pd);
			pdtb.setPdxml(form.getPdxml().replaceAll("\"", "'"));
			workFlowDefinitionBL.updateProcessDefinition(pdtb);
		} else {
			
			IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(form.getPpsdid());
			//����
			IG333TB psdtb = (IG333TB)SerializationUtils.clone(psd);
			psdtb.setPsdxml(form.getPdxml().replaceAll("\"", "'"));
			workFlowDefinitionBL.updateProcessStatus(psdtb);
		}
		
		dto.addMessage(new ActionMessage("IGPRD0104.I001"));
		return dto;
	}
	
	/**
	 * ��ȡ���ɽ�ɫ
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 * @throws BLException
	 */
	public IGPRD01DTO searchDispatchProcessParticipant(IGPRD01DTO dto) throws BLException {
		log.debug("========����Ӳ����߲�ѯ����ʼ========");
		IGPRD0114Form form =dto.getIgPRD0114Form();
		// ��ȡ����ӽ�ɫ
		IG222SearchCondImpl cond = new IG222SearchCondImpl();
		cond.setPsdid(form.getPsdid());
		List<IG222Info> ppdlist = workFlowDefinitionBL.searchParticipantDef(cond);
		dto.setProcessParticipantDefList(ppdlist);
		log.debug("========����Ӳ����߲�ѯ��������========");
		return dto;
	}
	
	/**
	 * �趨���ɽ�ɫ
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 * @throws BLException
	 */
	public IGPRD01DTO assignProcessParticipant(IGPRD01DTO dto) throws BLException {
		log.debug("========�趨���ɽ�ɫ����ʼ========");
		IGPRD0114Form form = dto.getIgPRD0114Form();
		//����Ȩ��
		IG222SearchCondImpl cond = new IG222SearchCondImpl();
		cond.setPsdid(form.getPsdid());
		List<IG222Info> ppdlist = workFlowDefinitionBL.searchParticipantDef(cond);
		for(IG222Info obj : ppdlist) {
			if(IGPRDCONSTANTS.SUPER_ROLE.equals(obj.getPpdsuper()) && !obj.getPpdid().equals(form.getPpdid())) {
				IG222TB objTB = (IG222TB)SerializationUtils.clone(obj);
				objTB.setPpdsuper(IGPRDCONSTANTS.UN_SUPER_ROLE);
				workFlowDefinitionBL.updateParticipantDef(objTB);
				break;//һ���ڵ�ֻ����һ�����ɽ�ɫ
			}
		}
		//�趨���ɽ�ɫ
		IG222Info ppd = workFlowDefinitionBL.searchParticipantDefByKey(form.getPpdid());
		IG222TB ppdTB = (IG222TB)SerializationUtils.clone(ppd);
		ppdTB.setPpdsuper(IGPRDCONSTANTS.SUPER_ROLE);
		workFlowDefinitionBL.updateParticipantDef(ppdTB);
		dto.addMessage(new ActionMessage("IGPRD0114.I001"));
		log.debug("========�趨���ɽ�ɫ��������========");
		return dto;
	}
	
	/**
	 * ������ɽ�ɫ
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 * @throws BLException
	 */
	public IGPRD01DTO clearProcessParticipant(IGPRD01DTO dto) throws BLException {
		log.debug("========������ɽ�ɫ����ʼ========");
		IGPRD0114Form form = dto.getIgPRD0114Form();
		//����Ȩ��
		IG222SearchCondImpl cond = new IG222SearchCondImpl();
		cond.setPsdid(form.getPsdid());
		List<IG222Info> ppdlist = workFlowDefinitionBL.searchParticipantDef(cond);
		for(IG222Info obj : ppdlist) {
			if(IGPRDCONSTANTS.SUPER_ROLE.equals(obj.getPpdsuper())) {
				IG222TB objTB = (IG222TB)SerializationUtils.clone(obj);
				objTB.setPpdsuper(IGPRDCONSTANTS.UN_SUPER_ROLE);
				workFlowDefinitionBL.updateParticipantDef(objTB);
				break;//һ���ڵ�ֻ����һ�����ɽ�ɫ
			}
		}
		dto.addMessage(new ActionMessage("IGPRD0114.I002"));
		log.debug("========������ɽ�ɫ��������========");
		return dto;
	}
	
	/**
	 * ���нڵ��������Ϣ��ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchConcurrencyProcessTransitionDefAction(IGPRD01DTO dto) throws BLException {
		
		log.debug("========���нڵ��������Ϣ��ѯ����ʼ========");
		
		IGPRD0115Form form = dto.getIgPRD0115Form();
		//====> ��ܱ���Begin
		String message = "����";
		//====> ��ܱ���End
		if(StringUtils.isNotEmpty(form.getFpsdid())) {
			
			//��ȡ��ǰ״̬��Ϣ
			IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(form.getFpsdid());
			
			dto.setProcessStatusDef(psd);
			
			//��ȡ��ǰ��������״̬��Ϣ
			IG333SearchCondImpl psdCond = new IG333SearchCondImpl();
			
			psdCond.setPdid(psd.getPdid());
			
			List<IG333Info> psdList = workFlowDefinitionBL.searchProcessStatusDef(psdCond);
			
			//====> ��ܱ���Begin
			String pdid_one = StringUtils.isEmpty(psd.getPdid()) ? "0" : psd.getPdid().substring(0,1);
			if(IGPRDCONSTANTS.PRTYPE_YEAR_STATUS_ID.equals(pdid_one)
					|| IGPRDCONSTANTS.PRTYPE_SEASON_STATUS_ID.equals(pdid_one)
					|| IGPRDCONSTANTS.PRTYPE_IRREGULAR_STATUS_ID.equals(pdid_one)){
				message = "����";
				
			}
			//====> ��ܱ���End
			
			//����ԾǨ״̬�����б�
			List<LabelValueBean> labelList = new ArrayList<LabelValueBean>();
			
			for(IG333Info o : psdList){
				//����ԾǨ������״̬
				if(!IGPRDCONSTANTS.PROCESS_START_STATUS.equals(psd.getPsdcode()) 
						&& IGPRDCONSTANTS.PROCESS_START_STATUS.equals(o.getPsdcode())) {
					continue;
				}
				//���˵�ǰ״̬
				if(!o.getPsdid().equals(psd.getPsdid())) {
//					//ֻ�пɷ��ɽڵ����ԾǨ�����нڵ㣬���ǿɷ��ɽڵ��ԾǨ���Ľڵ�����Ҫ���˲��нڵ�
//					if(IGPRDCONSTANTS.PROCESS_NODE_TYPE_ASSIGN.equals(psd.getPsdtype())) {
//						labelList.add(new LabelValueBean(o.getPsdname(),o.getPsdid().toString()));
//					} else {
//						if(!IGPRDCONSTANTS.PROCESS_NODE_TYPE_CONCURRENCY.equals(o.getPsdtype())) {
//							labelList.add(new LabelValueBean(o.getPsdname(),o.getPsdid().toString()));
//						}
//					}
					labelList.add(new LabelValueBean(o.getPsdname(),o.getPsdid().toString()));

				}
			}
			
			//�趨ҳ�������б�ֵ
			IG273SearchCondImpl cond = new IG273SearchCondImpl();
			cond.setPtdcond(IGPRDCONSTANTS.TRANSITION_RULE_ANY);
			cond.setFpsdid(form.getFpsdid());
			
			List<IG273Info> ptList = workFlowDefinitionBL.searchProcessTransitionDef(cond);
			if(ptList.size() > 1) {
				throw new BLException("IGPRD0115.E001");
			}
			dto.setProcessTransitionDefList(ptList);
			
			dto.setLabelList(labelList);
			
		} else {
			//====> ��ܱ���Begin
			throw new BLException("IGCO10000.E004",message + "״̬����");
			//====> ��ܱ���End
		}
		
		log.debug("========���нڵ��������Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * ���нڵ��������Ϣ��������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO insertConcurrencyProcessTransitionDefAction(IGPRD01DTO dto) throws BLException {
		
		log.debug("========���нڵ��������Ϣ��������ʼ========");
		IGPRD0115Form form = dto.getIgPRD0115Form();
		//ɾ���ѽ����Ĺ���,ֻ��һ��
		IG273SearchCondImpl cond = new IG273SearchCondImpl();
		cond.setPtdcond(IGPRDCONSTANTS.TRANSITION_RULE_ANY);
		cond.setFpsdid(form.getFpsdid());
		
		String ptdid = "";
		
		List<IG273Info> ptList = workFlowDefinitionBL.searchProcessTransitionDef(cond);
		if(ptList.size() > 1) {
			throw new BLException("IGPRD0115.E001");
		}
		boolean flag = true;
		for(IG273Info pt : ptList){
			//�жϹ����Ƿ����
			if(pt.getTpsdid().equals(form.getTpsdid())) {
				flag = false;
				break;
			}
			ptdid = pt.getPtdid();
			workFlowDefinitionBL.deleteProcessTransitionDefByKey(pt.getPtdid());
		}
		if(flag) {
			//��������
			IG273TB ptdTB = new IG273TB();
			ptdTB.setPtdid(workFlowDefinitionBL.getProcessTransitionDefPK(form.getPdid()));
			//Դ״̬
			ptdTB.setFpsdid(form.getFpsdid());
			//ԾǨ״̬
			ptdTB.setTpsdid(form.getTpsdid());
			//����
			ptdTB.setPtdtype(IGPRDCONSTANTS.COND_TYPE_ANY);
			//����
			ptdTB.setPtdcond(IGPRDCONSTANTS.TRANSITION_RULE_ANY);
			
			IG273Info ptd = workFlowDefinitionBL.registProcessTransitionDef(ptdTB);
			
			//�޸�����ͼ(����)
			IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(form.getPdid());
			if(pd.getPdxml()!=null){
				Document document;
				try {
					document = DocumentHelper.parseText(new String(pd.getPdxml()));
					Element root = document.getRootElement();
					if(StringUtils.isNotEmpty(ptdid)) {
						//ֻɾ��
						removeActions(root,String.valueOf(ptdid));
					}
					addAction(root, String.valueOf(ptd.getPtdid()), ptd.getPtdname(),String.valueOf(ptd.getFpsdid()),String.valueOf(ptd.getTpsdid()));
					//����
					saveXml(pd,document);
				} catch (DocumentException e) {
					throw new BLException("IGPRD0104.E004");
				}
			}
		}
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "���нڵ�����������Ϣ") );
		
		log.debug("========���нڵ��������Ϣ������������========");
		return dto;
	}
	
	/**
	 * ���нڵ��������Ϣɾ������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO deleteConcurrencyProcessTransitionDefAction(IGPRD01DTO dto) throws BLException {

		log.debug("========���нڵ��������Ϣɾ������ʼ========");
		IGPRD0115Form form = dto.getIgPRD0115Form();
		
		//��������Ϣɾ������
		workFlowDefinitionBL.deleteProcessTransitionDefByKey(form.getPtdid());

		//ɾ������ͼ(����)
		IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(form.getPdid());
		if(pd.getPdxml()!=null && !"".equals(pd.getPdxml())){
			try{
				Document document = DocumentHelper.parseText(new String(pd.getPdxml()));
				Element root = document.getRootElement();
				
				//ֻɾ��
				removeActions(root,String.valueOf(form.getPtdid()));
				//����
				saveXml(pd,document);
			}catch (DocumentException e) {
				throw new BLException("IGPRD0104.E004");
			}
			
		}
		dto.addMessage(new ActionMessage( "IGCO10000.I006", "���нڵ�����������Ϣ") );

		log.debug("========��������Ϣɾ����������========");
		return dto;
	}
	
	/**
	 * ��ѯ��ѡ�Ľ�ɫ���ͺ����п�ѡ�Ľ�ɫ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO getProcessRoleTypeDefAction(IGPRD01DTO dto) throws BLException {

		log.debug("========��ѯ��ѡ�Ľ�ɫ���ͺ����п�ѡ�Ľ�ɫ���ʹ���ʼ========");
		IGPRD0124Form form = dto.getIgPRD0124Form();
		IG213SearchCondImpl cond = new IG213SearchCondImpl();
		cond.setPdid(form.getPdid());
		List<IG213Info> list = workFlowDefinitionBL.searchProcessRoleTypeDef(cond);
		
		CodeDetailSearchCondImpl cdCond = new CodeDetailSearchCondImpl();
		cdCond.setCcid(CodeDefine.getCodeDefine("ROLE_CATEGORY_CODE").getCcid());
		
		List<CodeDetail> codeDetailList = this.codeDetailBL.searchCodeDetail(cdCond, 0);
		CodeDetail cd = null;
		for(Iterator<CodeDetail> iter = codeDetailList.iterator(); iter.hasNext();){
			cd = iter.next();
			//ȡ���̽�ɫ,���������̹���Ա
			if(!cd.getCid().startsWith(WorkFlowConstDefine.PROCESS_ROLE_MARK) || 
					WorkFlowConstDefine.PROCESSADMIN_ROLE_TYPE.equals(cd.getCid())) {
				iter.remove();
			}
		}
		
		List<CodeDetail> realList = new ArrayList<CodeDetail>();
		if(list.size()>0){
			/**������ѡ����Ľ�ɫ����*/
			boolean flag = true;
			for(CodeDetail detail:codeDetailList){
				
				for(int i=0; i<list.size(); i++){
					if(detail.getCid().equals(list.get(i).getRoletype())){
						flag = false;
						break;
					}
					if(i==(list.size()-1)){
						flag = true;
					}
				}
				if(flag){
					realList.add(detail);
					flag = false;
				}
			}
			/***/
			dto.setCodeDetailList(realList);
		}else{
			dto.setCodeDetailList(codeDetailList);
		}
		dto.setProcessRoleTypeDefList(list);
		
		
		log.debug("========��ѯ��ѡ�Ľ�ɫ���ͺ����п�ѡ�Ľ�ɫ���ʹ�������========");
		return dto;
	}
	
	/**
	 * ���ӽ�ɫ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO addProcessRoleTypes(IGPRD01DTO dto) throws BLException {

		log.debug("========���ӽ�ɫ���ʹ���ʼ========");
		IGPRD0124Form form = dto.getIgPRD0124Form();
		
		if(form.getRoletypes() != null) {
			for(int i=0;i<form.getRoletypes().length;i++){
				IG213TB newppd = new IG213TB();
				newppd.setRoletype(form.getRoletypes()[i]);
				newppd.setPdid(form.getPdid());
				newppd.setPrtdid(workFlowDefinitionBL.getProcessRoleTypeDefPK(form.getPdid()));
				workFlowDefinitionBL.registProcessRoleTypeDef(newppd);
			}
		}


		dto.addMessage(new ActionMessage("IGPRD0124.I001",IGPRDCONSTANTS.PPD_ADD_ROLETYPE_MESSAGE));

		log.debug("========���ӽ�ɫ���ʹ�������========");
		return dto;
	}
	
	/**
	 * ɾ����ɫ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO removeProcessRoleTypes(IGPRD01DTO dto) throws BLException {

		log.debug("========ɾ����ɫ���ʹ���ʼ========");
		IGPRD0124Form form = dto.getIgPRD0124Form();

		for(int i=0;i<form.getPrtdids().length;i++){
			IG213SearchCondImpl cond = new IG213SearchCondImpl();
			cond.setPrtdid(form.getPrtdids()[i]);
			List<IG213Info> list = workFlowDefinitionBL.searchProcessRoleTypeDef(cond);
			if(list.size()==0){
				throw new BLException("IGCO10000.E004","��ɫ���ͻ���");
			}else{
				workFlowDefinitionBL.deleteProcessRoleTypeDefByKey(form.getPrtdids()[i]);
			}
			
		}

		log.debug("========ɾ����ɫ���ʹ�������========");
		return dto;
	}
	public String addAtt(Map<Integer, FormFile> filemap) throws BLException {
			return fileUploadBL.uploadFile(filemap);
	}
	//ȡ�����б�
	public  List<Attachment> searchInofAtt(String piattkey) {
		List<Attachment> InofAttList = new ArrayList<Attachment>();
		InofAttList = attachmentBL.searchAttachmentsByAttkey(piattkey);
		return InofAttList;
	}
	
	public IGPRD01DTO searchProcessLinkageDef(IGPRD01DTO dto)
		throws BLException {
		List<IG286Info> list = workFlowDefinitionBL.searchProcessLinkageDef(dto.getProcessLinkageDefSearchCond());
		dto.setProcessLinkageDefList(list);
		return dto;
	}
	public IGPRD01DTO insertProcessLinkageDef(IGPRD01DTO dto)
		throws BLException {
		IGPRD0125Form form = dto.getIgPRD0125Form();
		form.setPlid(workFlowDefinitionBL.getProcessLinkageDefPK(form.getPdid()));
		workFlowDefinitionBL.registProcessLinkageDef(form);
		return dto;
	}
	public void deleteProcessLinkageDef(String plid) throws BLException {
		IG286Info processLinkageDef = workFlowDefinitionBL.searchProcessLinkageDefByKey(plid);
		workFlowDefinitionBL.deleteProcessLinkageDef(processLinkageDef);
	}
	public IG286Info editProcessLinkageDef(String plid) throws BLException {
		IG286Info processLinkageDef = workFlowDefinitionBL.searchProcessLinkageDefByKey(plid);
		return processLinkageDef;
	}
	
	/**
	 * ���̶������洦��
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 * @throws BLException
	 */
	public IGPRD01DTO upgradeProcessDefAction(IGPRD01DTO dto) throws BLException {
		workFlowDefinitionBL.upgradeProcessDefVersion(dto.getPdid());
		dto.addMessage(new ActionMessage("IGPRD0101.I003"));
		return dto;
	}
	
	/**
	 * ���̶��帴�ƴ���
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 * @throws BLException
	 */
	public IGPRD01DTO copyProcessDefAction(IGPRD01DTO dto) throws BLException {
		workFlowDefinitionBL.copyProcessDefVersion(dto.getPdid());
		dto.addMessage(new ActionMessage("IGPRD0101.I004"));
		return dto;
	}
	
	/**
	 * ��ȡָ��XML
	 * @param path ·��
	 * @param filename �ļ���
	 * @return Document
	 * @throws BLException
	 */
	private org.jdom.Document readXmlJdom(String path, String filename) throws BLException{
		SAXBuilder sb = new SAXBuilder();
		org.jdom.Document doc;
		InputStreamReader is = null;
		try {
			is = new InputStreamReader(new FileInputStream(path),"UTF-8");
			doc = sb.build(is);
		} catch (Exception e) {
			log.error("XML�ļ���" + filename + "������ʧ��", e);
			throw new BLException("IGPRD0101.E003");
		} finally {
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					log.error("XML�ļ���" + filename + "������ʧ��", e);
					throw new BLException("IGPRD0101.E003");
				}
			}
		}
		return doc;
	}
	/**
	 * ��ȡָ��XML
	 * @param xml ����
	 * @return Document
	 * @throws BLException
	 */
	private org.jdom.Document readXmlJdom(String xml) throws BLException{
		SAXBuilder sb = new SAXBuilder();
		org.jdom.Document doc;
		StringReader sr = new StringReader(xml);
		InputSource is = new InputSource(sr);
		try {
			doc = sb.build(is);
		} catch (Exception e) {
			log.error("XML�ļ�����ʧ��", e);
			throw new BLException("IGPRD0101.E003");
		}
		return doc;
	}
	
	/**
	 * ��ȡָ��XML
	 * @param path ·��
	 * @param filename �ļ���
	 * @return Document
	 * @throws BLException
	 */
	private org.dom4j.Document readXmlDom4j(String path, String filename) throws BLException{
		SAXReader reader = new SAXReader(); 

		Document doc = null;
		try {
			doc = reader.read(new File(path));
		} catch (DocumentException e) {
			log.error("XML�ļ���" + filename + "������ʧ��", e);
			throw new BLException("IGPRD0101.E003");
		}
		return doc;
	}
	/**
	 * ���̶��嵼�봦��
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 * @throws BLException
	 */
	@SuppressWarnings("unchecked")
	public IGPRD01DTO importProcessDefAction(IGPRD01DTO dto) throws BLException {
		log.debug("========���̶��嵼�봦��ʼ========");
		IGPRD0101Form form = dto.getIgPRD0101Form();
		//���̶���SQL�ű������ļ�������·��
		String path = ResourceUtility.getString("PROCESS_IMPORT_FILE_PATH")
				+ "temp" + File.separator + "import" + File.separator;
		long l = System.currentTimeMillis();
		String filename = l + "_" + form.getXmlFile().getFileName();
		String pdid_new = form.getXmlFile().getFileName().substring(0, form.getXmlFile().getFileName().lastIndexOf("."));
		//�ж�PDID�Ƿ��Ѵ���
		IG380SearchCondImpl cond_IG380 = new IG380SearchCondImpl();
		cond_IG380.setPdid(pdid_new);
		List<IG380Info> lst_IG380 = workFlowDefinitionBL.searchProcessDefinition(cond_IG380);
		if(!lst_IG380.isEmpty()) {
			throw new BLException("IGPRD0101.E007", pdid_new);
		}
		//�ϴ��ļ�
		if(form.getXmlFile() != null) {
			try {
				this.fileUploadBL.saveFile(form.getXmlFile(), path, filename);
			} catch (Exception e) {
				log.error("XML�ļ���" + filename + "���ϴ�ʧ��", e);
				throw new BLException("IGPRD0101.E003");
			}
		}
		path += filename;
		//��ȡԴPDID
		org.jdom.Document doc = readXmlJdom(path, filename);
		org.jdom.Element root = doc.getRootElement();
		String pdid_src = root.getAttributeValue("PDID").toString();
		//���ļ�����PDID��ƥ��ʱ�����ļ�����Ϊ���µ�PDID���������滻���������ļ�
		if(!pdid_new.equals(pdid_src)) {
			org.dom4j.Document doc4j = readXmlDom4j(path, filename);
			doc = readXmlJdom(doc4j.asXML().replaceAll("\"" + pdid_src, "\"" + pdid_new)
					.replaceAll(">" + pdid_src, ">" + pdid_new)
					.replaceAll("a" + pdid_src, "a" + pdid_new)
					.replaceAll("\\|" + pdid_src, "\\|" + pdid_new));
			root = doc.getRootElement();
		}
		//У������
		org.jdom.Element checkElement = root.getChild("CHECKINFO");
		//У���ɫ��Ϣ
		org.jdom.Element roleCheck = checkElement.getChild("ROLEINFO");
		List<org.jdom.Element> roleCheckList = roleCheck.getChildren();
		List<String> errorMessages = new ArrayList<String>();
		if(roleCheckList != null){
			List<Integer> roleids = new ArrayList<Integer>();
			for(org.jdom.Element element : roleCheckList){
				roleids.add(Integer.valueOf(element.getChildText("ROLEID")));
			}
			if(roleids.size() > 0){
				RoleSearchCondImpl rolecond = new RoleSearchCondImpl();
				rolecond.setRoleid_in(roleids);
				List<Role> roles = roleBL.searchRole(rolecond);
				Map<String, Role> roleMap = new HashMap<String, Role>();
				for(Role role:roles){
					String key = role.getRoleid() + "";
					roleMap.put(key, role);
				}
				for(org.jdom.Element element : roleCheckList){
					String roleid = element.getChildText("ROLEID");
					String rolename = element.getChildText("ROLENAME");
					Role role = roleMap.get(roleid);
					if(role == null){
						errorMessages.add("��ɫ��Ϣ \"" + rolename + "\" �����ڣ�");
					}else if(!role.getRolename().equals(rolename)){
						errorMessages.add("��ɫ��Ϣ \"" + rolename + "\" ������");
					}
				}
			}
		}
		//У�������Ϣ
		org.jdom.Element orgCheck = checkElement.getChild("ORGINFO");
		List<org.jdom.Element> orgCheckList = orgCheck.getChildren();
		if(orgCheckList != null){
			List<String> orgids = new ArrayList<String>();
			for(org.jdom.Element element : orgCheckList){
				orgids.add(element.getChildText("ORGID"));
			}
			if(orgids.size() > 0){
				OrganizationSearchCondImpl orgcond = new OrganizationSearchCondImpl();
				orgcond.setSyscoding_area(orgids);
				List<Organization> orgs = organizationBL.searchOrganization(orgcond);
				Map<String, Organization> orgMap = new HashMap<String, Organization>();
				for(Organization org:orgs){
					orgMap.put(org.getOrgsyscoding(), org);
				}
				for(org.jdom.Element element : orgCheckList){
					String orgid = element.getChildText("ORGID");
					String orgname = element.getChildText("ORGNAME");
					Organization org = orgMap.get(orgid);
					if(org == null){
						errorMessages.add("������Ϣ \"" + orgname + "\" �����ڣ�");
					}else if(!org.getOrgname().equals(orgname)){
						errorMessages.add("������Ϣ \"" + orgname + "\" ������");
					}
				}
			}
		}
		//У���û���Ϣ
		org.jdom.Element userCheck = checkElement.getChild("USERINFO");
		List<org.jdom.Element> userCheckList = userCheck.getChildren();
		if(userCheckList != null){
			List<String> userids = new ArrayList<String>();
			for(org.jdom.Element element : userCheckList){
				userids.add(element.getChildText("USERID"));
			}
			if(userids.size() > 0){
				UserSearchCondImpl usercond = new UserSearchCondImpl();
				usercond.setUserid_in(userids);
				List<User> users = userBL.searchUser(usercond);
				Map<String, User> userMap = new HashMap<String, User>();
				for(User user : users){
					userMap.put(user.getUserid(), user);
				}
				for(org.jdom.Element element : userCheckList){
					String userid = element.getChildText("USERID");
					String username = element.getChildText("USERNAME");
					User user = userMap.get(userid);
					if(user == null){
						errorMessages.add("�û���Ϣ \"" + username + "\" �����ڣ�");
					}else if(!user.getUsername().equals(username)){
						errorMessages.add("�û���Ϣ \"" + username + "\" ������");
					}
				}
			}
		}
		//У�鲻ͨ��
		if(errorMessages.size() > 0){
			dto.setErrorMessages(errorMessages);
			return dto;
		}
		List<org.jdom.Element> children = root.getChildren();
		workFlowDefinitionBL.importXML(children);
		dto.addMessage(new ActionMessage("IGPRD0101.I005"));
		log.debug("========���̶��嵼�봦������========");
		return dto;
	}
	
	/**
	 * ���̶��嵼������
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 * @throws BLException
	 */
	public IGPRD01DTO exportProcessDefAction(IGPRD01DTO dto) throws BLException {
		log.debug("========���̶��嵼������ʼ========");
		//���̶���SQL�ű������ļ�������·��
		String path = ResourceUtility.getString("PROCESS_IMPORT_FILE_PATH") + "temp" + File.separator + "export";
		String pdid = dto.getIgPRD0101Form().getPdid_export();
		String sbf = workFlowDefinitionBL.exportXML(pdid);
		//ȡ�ñ�����Ϣ
		//1.��ɫ������Ϣ
		List<Integer> roleids = new ArrayList<Integer>();
		String roleid_regex = "&roleid_.*?;";
		Pattern roleid_pattern = Pattern.compile(roleid_regex);
		Matcher roleid_matcher = roleid_pattern.matcher(sbf);
		while(roleid_matcher.find()){
			String group = roleid_matcher.group();
			Integer roleid = Integer.valueOf(group.substring(group.indexOf("_") + 1,group.length() - 1));
			if(!roleids.contains(roleid)){
				roleids.add(roleid);
			}
		}
		//2.����������Ϣ
		List<String> orgids = new ArrayList<String>();
		String orgid_regex = "&orgid_.*?;";
		Pattern orgid_pattern = Pattern.compile(orgid_regex);
		Matcher orgid_matcher = orgid_pattern.matcher(sbf);
		while(orgid_matcher.find()){
			String group = orgid_matcher.group();
			String orgid = group.substring(group.indexOf("_") + 1,group.length() - 1);
			if(!orgids.contains(orgid)){
				orgids.add(orgid);
			}
		}
		//3.�û�������Ϣ
		List<String> userids = new ArrayList<String>();
		String userid_regex = "&userid_.*?;";
		Pattern userid_pattern = Pattern.compile(userid_regex);
		Matcher userid_matcher = userid_pattern.matcher(sbf);
		while(userid_matcher.find()){
			String group = userid_matcher.group();
			String userid = group.substring(group.indexOf("_") + 1,group.length() - 1);
			if(!userids.contains(userid)){
				userids.add(userid);
			}
		}
		StringBuffer xml = new StringBuffer();
		//���ɱ���
		xml.append("<!DOCTYPE VARIABLE[");
		for(Integer roleid:roleids){
			xml.append("<!ENTITY roleid_").append(roleid).append(" \"").append(roleid).append("\">");
		}
		for(String orgid:orgids){
			xml.append("<!ENTITY orgid_").append(orgid).append(" \"").append(orgid).append("\">");
		}
		for(String userid:userids){
			xml.append("<!ENTITY userid_").append(userid).append(" \"").append(userid).append("\">");
		}
		xml.append("]>");
		xml.append("<Process PDID=\"").append(pdid).append("\">");
		//����У����Ϣ
		xml.append("<CHECKINFO>");
		xml.append("<ROLEINFO>");
		if(roleids.size() > 0){
			RoleSearchCondImpl rolecond = new RoleSearchCondImpl();
			rolecond.setRoleid_in(roleids);
			List<Role> roleList = roleBL.searchRole(rolecond);
			for(Role role:roleList){
				xml.append("<DATA>");
				xml.append("<ROLEID>");
				xml.append("&roleid_" + role.getRoleid() + ";");
				xml.append("</ROLEID>");
				xml.append("<ROLENAME>");
				xml.append(role.getRolename());
				xml.append("</ROLENAME>");
				xml.append("</DATA>");
			}
		}
		xml.append("</ROLEINFO>");
		xml.append("<ORGINFO>");
		if(orgids.size() > 0){
			OrganizationSearchCondImpl orgcond = new OrganizationSearchCondImpl();
			orgcond.setSyscoding_area(orgids);
			List<Organization> organizationList = organizationBL.searchOrganization(orgcond);
			for(Organization org : organizationList){
				xml.append("<DATA>");
				xml.append("<ORGID>");
				xml.append("&orgid_" + org.getOrgsyscoding() + ";");
				xml.append("</ORGID>");
				xml.append("<ORGNAME>");
				xml.append(org.getOrgname());
				xml.append("</ORGNAME>");
				xml.append("</DATA>");
			}
		}
		xml.append("</ORGINFO>");
		xml.append("<USERINFO>");
		if(userids.size() > 0){
			UserSearchCondImpl usercond = new UserSearchCondImpl();
			usercond.setUserid_in(userids);
			List<User> userList = userBL.searchUser(usercond);
			for(User user:userList){
				xml.append("<DATA>");
				xml.append("<USERID>");
				xml.append("&userid_" + user.getUserid() + ";");
				xml.append("</USERID>");
				xml.append("<USERNAME>");
				xml.append(user.getUsername());
				xml.append("</USERNAME>");
				xml.append("</DATA>");
			}
		}
		xml.append("</USERINFO>");
		xml.append("</CHECKINFO>");
		xml.append(sbf);
		xml.append("</Process>");
		log.debug("���̶���XML��Ϣ��");
		log.debug(xml.toString());
		File file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
		}
		String filename = System.currentTimeMillis() + "_" + pdid + ".xml";
		path += File.separator + filename;
		writeXML(path, filename, xml.toString());
		dto.setFilepath_export(path);
		dto.addMessage(new ActionMessage("IGPRD0101.I006"));
		log.debug("========���̶��嵼����������========");
		return dto;
	}
	
	/**
	 * ����XML
	 * @param path ·��
	 * @param filename �ļ���
	 * @param sbf_xml ����
	 * @throws BLException
	 */
	private void writeXML(String path, String filename, String sbf_xml) throws BLException {
		try {
			//����XML��ʽ
			Format format = Format.getPrettyFormat();
			format.setIndent("    ");
			format.setEncoding("UTF-8");
			//��ʽ��XML
			XMLOutputter out = new XMLOutputter(format);
			SAXBuilder builder = new SAXBuilder();
			ByteArrayInputStream bais = null;
			try {
				bais = new ByteArrayInputStream(sbf_xml.getBytes("UTF-8"));
				out.output(builder.build(new InputSource(bais)), new OutputStreamWriter(new FileOutputStream(path), "UTF-8"));
			} catch (JDOMException e) {
				log.error("XML�ļ�" + filename + "����ʧ��", e);
				throw new BLException("IGPRD0101.E005");
			} finally {
				if(bais != null) {
					try {
						bais.close();
					} catch (IOException e) {
						log.error("XML�ļ���" + filename + "������ʧ��", e);
						throw new BLException("IGPRD0101.E003");
					}
				}
			}
		} catch (IOException e) {
			log.error("XML�ļ�" + filename + "����ʧ��", e);
			throw new BLException("IGPRD0101.E005");
		}
	}
	
	/**
	 * ����״̬�ɷ��ɽ�ɫ��ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessStatusRoleDefAction(IGPRD01DTO dto) throws BLException {
		log.debug("========����״̬�ɷ��ɽ�ɫ��ѯ����ʼ========");
		IGPRD0139Form form = dto.getIgPRD0139Form();
		//��ѯ��ѡ��ɫ
		dto.setLst_ProcessStatusRoleDef(workFlowDefinitionBL.searchProcessStatusRoleDefInfoByPsdid(form.getPsdid()));
		//��ѯ��ѡ��ɫ
		dto.setLst_Role(workFlowDefinitionBL.searchToBeAssignRole(form.getPdid(), form.getPsdid()));
		log.debug("========����״̬�ɷ��ɽ�ɫ��ѯ��������========");
		return dto;
	}
	
	/**
	 * ����״̬�ɷ��ɽ�ɫ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO addProcessStatusRoleDef(IGPRD01DTO dto) throws BLException {
		log.debug("========����״̬�ɷ��ɽ�ɫ��������ʼ========");
		IGPRD0139Form form = dto.getIgPRD0139Form();
		if(form.getRoleids() != null) {
			for(String roleid : form.getRoleids()){
				IG298TB psrdTB = new IG298TB();
				psrdTB.setPsrdid(workFlowDefinitionBL.getProcessStatusRoleDefInfoPK(form.getPsdid()));
				psrdTB.setPsdid(form.getPsdid());
				psrdTB.setRoleid(Integer.parseInt(roleid));
				workFlowDefinitionBL.registProcessStatusRoleDefInfo(psrdTB);
			}
		}
		dto.addMessage(new ActionMessage("IGPRD0139.I001"));
		log.debug("========����״̬�ɷ��ɽ�ɫ������������========");
		return dto;
	}
	
	/**
	 * ����״̬�ɷ��ɽ�ɫɾ��
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO removeProcessStatusRoleDef(IGPRD01DTO dto) throws BLException {
		log.debug("========����״̬�ɷ��ɽ�ɫɾ������ʼ========");
		IGPRD0139Form form = dto.getIgPRD0139Form();
		if(form.getPsrdids() != null) {
			for(String psrdids : form.getPsrdids()){
				workFlowDefinitionBL.deleteProcessStatusRoleDefInfoByKey(psrdids);
			}
		}
		dto.addMessage(new ActionMessage("IGPRD0139.I002"));
		log.debug("========����״̬�ɷ��ɽ�ɫɾ����������========");
		return dto;
	}
	/**
	 * ���ݰ�ťID ȡ�ö���İ�ť����
	 * @param pbdid
	 * @param defInfoList
	 * @return
	 */
	private String getDefaultButtonName(String pbdid, List<IG725Info> defInfoList){
		String buttonName = "";
		for(IG725Info info : defInfoList){
			if(pbdid.equalsIgnoreCase(info.getPbdid())){
				buttonName = info.getPdbdname();
				break;
			}
		}
		return buttonName;
	}
	/**
	 * ���ݰ�ťID ȡ�ö���İ�ť����
	 * @param pbdid
	 * @param defInfoList
	 * @return
	 */
	private String getButtonName(String pbdid, List<IG132TB> defInfoList,List<IG725Info> defaultInfoList){
		String buttonName = "";
		for(IG132TB info : defInfoList){
			if(pbdid.equalsIgnoreCase(info.getPbdid())){
				buttonName = info.getPpbdname();
				break;
			}
		}
		if(StringUtils.isEmpty(buttonName)){
			for(IG725Info info : defaultInfoList){
				if(pbdid.equalsIgnoreCase(info.getPbdid())){
					buttonName = info.getPdbdname();
					break;
				}
			}
		}
		return buttonName;
	}
	
	/**
	 * ����֪ͨ���Բ�ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO initIGPRD0158Action(IGPRD01DTO dto) throws BLException {
		log.debug("========����֪ͨ���Բ�ѯ����ʼ========");
		IGPRD0158Form form = dto.getIgPRD0158Form();
		// ���̶���ID
		String pdid = form.getPdid();
		
		// ��ѯ����֪ͨ������Ϣ
		IG334SearchCondImpl cond = new IG334SearchCondImpl();
		cond.setPdid_like(pdid);
		List<IG334Info> ig334List = workFlowDefinitionBL.searchInformStrategy(cond);
		// �Ѿ����ù�
		String pidid = "";
		if(ig334List.size() > 0){
			IG334Info info = ig334List.get(0);
			pidid = info.getPidid();
			form.setPidid(info.getPidid());
			form.setPidname(info.getPidname());
			form.setSms(info.getSms());
			form.setEmail(info.getEmail());
		}
		
		// ҳ����ʾ������ϢMap
		Map<IG238Info, List<IG335Info>> showMap = new LinkedHashMap<IG238Info, List<IG335Info>>();
		
		// ��ѯ����״̬֪ͨ��������
		List<IG238Info> ig238InfoList = workFlowDefinitionBL.searchProcessNoticeStrategyVWInfoByPdid(pdid);
		
		// ����״̬���� * ��ֵ
		int pisize = 0;
		// ��ѯ����״̬�±�ֵ֪ͨ����
		for (IG238Info ig238Info : ig238InfoList) {
			// û���������̱�
			if(pidid.equals("")){
				showMap.put(ig238Info, new ArrayList<IG335Info>());
			} else {
				List<IG335Info> ig335List = workFlowDefinitionBL.searchFormStrategyVW(pdid, ig238Info.getPsdid(), pidid, ig238Info.getPsdconfirm());
				// �����ǰ״̬��û�в鵽����򷵻�
				// ���֪ͨ����δ��������²�ѯ��Ӧ�ı�ֵȻ���������
				if(ig335List.size() == 0) {
					if(pidid.endsWith(IGPRDCONSTANTS.PROCESS_UNRELFORM_IDEND)){
						// ��û��������صı�(����ʹ����ķ�����ѯ�����JSP����)�ֶ�����ig335List
						IG335TB ig335TBUnRel = new IG335TB();
						ig335TBUnRel.setPsdid(ig238Info.getPsdid());
						ig335TBUnRel.setPdid(pdid);
						ig335TBUnRel.setPidid(pidid);
						ig335TBUnRel.setPivalue(IGPRDCONSTANTS.PROCESS_UNRELFORM_VALUE);
						ig335TBUnRel.setPsdconfirm("0");
						ig335List.add(ig335TBUnRel);
					}else {
						ig335List = workFlowDefinitionBL.searchFormStrategyVW(pdid, ig238Info.getPsdid(), pidid, "0");
					}
				}
				
				List<IG335Info> temp_list = new ArrayList<IG335Info>();
				// û������֪ͨ����
				if(ig335List.size() == 1){
					IG335Info info = ig335List.get(0);
					if(!IGPRDCONSTANTS.PROCESS_UNRELFORM_VALUE.equals(info.getPivalue())){
						// ���ޱ�ʱ����
						// ��ֵ������
						String[] pivalue_arr = info.getPivalue().split("#");
						for (String str : pivalue_arr) {
							IG335TB ig335TB = (IG335TB) SerializationUtils.clone(info);
							ig335TB.setPivalue(StringUtils.isNotEmpty(str) ? str : "#");
							temp_list.add(ig335TB);
							pisize ++;
						}
						showMap.put(ig238Info, temp_list);
						temp_list = null;
					} else {
						//�����ޱ�����ֻ��ѯһ��ʱ�������elseһ��
						for(IG335Info ig335Info : ig335List) {
							ig335Info = getProcessNoticeStrategyInfo(ig335Info);
							temp_list.add(ig335Info);
						}
						showMap.put(ig238Info, temp_list);
						pisize += ig335List.size();
					}
				} else {
					//�����ޱ�����ֻ��ѯһ��ʱ�������elseһ��
					for(IG335Info ig335Info : ig335List) {
						ig335Info = getProcessNoticeStrategyInfo(ig335Info);
						temp_list.add(ig335Info);
					}
					showMap.put(ig238Info, temp_list);
					pisize += ig335List.size();
				}
			}
		}
		
		// �����������
		List<IG335Info> processWholeTactic_list = new ArrayList<IG335Info>();
		int  pwtsize = 0;
        if(StringUtils.isNotEmpty(pidid)){
            IG335SearchCondImpl ig335cond = new IG335SearchCondImpl();
            ig335cond.setPsdid_eq(IGPRDCONSTANTS.MAIN_PROCESS_FLAG);
            ig335cond.setPidid_eq(pidid);
            List<IG335Info> ig335list  =workFlowDefinitionBL.searchFormStrategy(ig335cond);
            if(ig335list.size() == 0){
            	// ��ʼĬ�ϱ�ֵΪ���޹ص�"N/A"
				String[] pidoptions = {IGPRDCONSTANTS.PROCESS_UNRELFORM_VALUE};
				if(!pidid.endsWith(IGPRDCONSTANTS.PROCESS_UNRELFORM_IDEND)){
					IG007Info ig007info = workFlowDefinitionBL.searchProcessInfoDefByKey(pidid);
					pidoptions = ig007info.getPidoption().split("#");
				}
                IG335TB ig335tb ;
                for (String pidoption : pidoptions) {
                    ig335tb =  new IG335TB();
                    ig335tb.setPidid(pidid);
                    ig335tb.setPsdid(IGPRDCONSTANTS.MAIN_PROCESS_FLAG);
                    ig335tb.setPivalue(StringUtils.isNotEmpty(pidoption) ? pidoption : "#");
                    processWholeTactic_list.add(ig335tb);
                    pwtsize++;
                }
            } else {
                for (IG335Info ig335Info : ig335list) {
                    ig335Info = getProcessNoticeStrategyInfo(ig335Info);
                    processWholeTactic_list.add(ig335Info);
                    pwtsize++;
                }
            }
            
        }
        
		dto.setPssize(ig238InfoList.size());
		dto.setPisize(pisize);
		dto.setShowMap(showMap);
		dto.setProcessWholeTactic_list(processWholeTactic_list);
		dto.setProcessWholeTactic_listSize(pwtsize);
		log.debug("========����֪ͨ���Բ�ѯ��������========");
		return dto;
	}
	
	/**
	 * ��ѯ�����ϼ�֪ͨ����Ϣ
	 * 
	 * @param info
	 * @return
	 */
	private IG335Info getProcessNoticeStrategyInfo(IG335Info info){
		IG335TB ig335tb = (IG335TB) SerializationUtils.clone(info);
		
		IG237SearchCondImpl cond = new IG237SearchCondImpl();
		cond.setPsdid(info.getPsdid());
		cond.setPsdconfirm(info.getPsdconfirm());
		cond.setPivalue(info.getPivalue());
		List<IG237Info> ig237infoList = workFlowDefinitionBL.searchProcessNoticeStrategyUserInfo(cond);
		// �洢�����ϼ�֪ͨ������
		StringBuffer sbf_notifiernames = new StringBuffer();
		// �洢�����ϼ�֪ͨ��ID
		StringBuffer sbf_notifierids = new StringBuffer();
		for (IG237Info ig237Info : ig237infoList) {
			sbf_notifiernames.append(ig237Info.getUser().getUsername()).append("��");
			sbf_notifierids.append(ig237Info.getRoleid()).append("##").append(ig237Info.getUserid()).append("###");
		}
		String flagString = sbf_notifiernames.toString();
		if (sbf_notifiernames.toString().length() > 1) {
			flagString = sbf_notifiernames.toString().substring(0, sbf_notifiernames.toString().lastIndexOf("��"));
		}
		ig335tb.setNotifierids(sbf_notifierids.toString());
		ig335tb.setNotifiernames(flagString);
		
		return ig335tb;
	}
	
	
	/**
	 * ����֪ͨ�����趨����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO editIGPRD0158Action(IGPRD01DTO dto) throws BLException {
		log.debug("========����֪ͨ�����趨����ʼ========");
		IGPRD0158Form form = dto.getIgPRD0158Form();
		
		String pdid = form.getPdid(); // ���̶���ID
		String sms = form.getSms(); // �Ƿ��Ͷ���
		String email = form.getEmail(); // �Ƿ����ʼ�
		String[] isnotifys = form.getIsnotify(); // ÿ��״̬�Ƿ��ͽ�״̬֪ͨ����
		String[] psdid_s = form.getPsdid_s(); // ״̬Id����
		String[] psdconfirms_s = form.getPsdconfirms_s();
		// ��ÿ��״̬�Ƿ񷢶��Ż��ʼ����б���
		for (int i = 0; i < psdid_s.length; i++) {
			IG212TB ig212tb = new IG212TB();
			ig212tb.setPsdconfirm(psdconfirms_s[i]);
			// ״̬ID
			String psdid = psdid_s[i];
			// �Ƿ���֪ͨ
			String isnotify = isnotifys[i];
			ig212tb.setPdid(pdid);
			ig212tb.setPsdid(psdid);
			// ����֪ͨʱ����֪ͨ����
			if("0".equals(isnotify)){
				ig212tb.setSms(sms);
				ig212tb.setEmail(email);
			} else { // ������֪ͨʱ������
				ig212tb.setSms("");
				ig212tb.setEmail("");
			}
			workFlowDefinitionBL.registProcessNoticeStrategyDefInfo(ig212tb);
		}

		// ׷�Ӹ���IG334��(֪ͨ���Ի�����Ϣ��)
		updateIG334Info(form);
		// ���������������
		updateWholeTacticsInfo(form);
		// ����״̬����
		updateStatusTacticsInfo(form);
		
		// ��Ӷ�ʱ����
		ProcessTacticsPollingJobInit jobinit = new ProcessTacticsPollingJobInit();
		jobinit.addJob(form.getPdid());
		
		dto.addMessage(new ActionMessage("IGPRD0158.I001"));
		log.debug("========����֪ͨ�����趨��������========");
		return dto;
	}

	/**
	 * ����֪ͨ���Ի�����Ϣ��
	 * (1)��Ҫ��֪ͨ��ʽ���´���
	 * @param form
	 * @throws BLException
	 */
	private void updateIG334Info(IGPRD0158Form form) throws BLException {
		String pdid = form.getPdid(); // ���̶���ID
		String sms = form.getSms(); // �Ƿ��Ͷ���
		String email = form.getEmail(); // �Ƿ����ʼ�
		
		IG334SearchCondImpl cond = new IG334SearchCondImpl();
		cond.setPdid_like(pdid);
		List<IG334Info> ig334List = workFlowDefinitionBL.searchInformStrategy(cond);
		IG334TB ig334TB = null;
		// ��������������
		if(ig334List.size() > 0){
			ig334TB = (IG334TB) SerializationUtils.clone(ig334List.get(0));
			ig334TB.setSms(sms);
			ig334TB.setEmail(email);
			workFlowDefinitionBL.registInformStrategy(ig334TB);
		}
	}

	/**
     * �����������������Ϣ
     * 
     * @param form
     * @throws BLException
     */
    private void updateWholeTacticsInfo(IGPRD0158Form form) throws BLException {
        log.debug("============= ��������������Կ�ʼ =============");
        String[] pidids_all = form.getPidid_all();
		String[] pivalues_all = form.getPivalue_all();
		String[] notifyds_all = form.getNotifyd_all();
        String[] notifyh_all = form.getNotifyh_all();
        String[] notifym_all = form.getNotifym_all();
        String[] roleid_all = form.getRoleid_all();

        String[] processbl_all = form.getProcessbl_all();
        // ���̶���ID
     	String pdid = form.getPdid();
        // ���������������
        for (int i = 0; i < pivalues_all.length; i++) {
            IG335TB ig335tb = new IG335TB();
            ig335tb.setPsdid(IGPRDCONSTANTS.MAIN_PROCESS_FLAG);
            ig335tb.setPidid(pidids_all[i]);
            ig335tb.setPivalue(StringUtils.isNotEmpty(pivalues_all[i]) ? pivalues_all[i] : "#");
            ig335tb.setNotifyd(Integer.parseInt(StringUtils.isEmpty(notifyds_all[i]) ? "0" : notifyds_all[i]));
            ig335tb.setNotifyh(Integer.parseInt(StringUtils.isEmpty(notifyh_all[i]) ? "0" : notifyh_all[i]));
            ig335tb.setNotifym(Integer.parseInt(StringUtils.isEmpty(notifym_all[i]) ? "0" : notifym_all[i]));
            ig335tb.setRoleid(Integer.parseInt(StringUtils.isEmpty(roleid_all[i]) ? "0" : roleid_all[i]));
            ig335tb.setProcessbl(processbl_all[i]);
            ig335tb.setPsdconfirm("0");
            ig335tb.setPdid(pdid);
            workFlowDefinitionBL.registFormStrategy(ig335tb);
        }
        log.debug("============= ��������������Խ��� =============");
    }

	/**
	 * ����״̬������Ϣ
	 * 
	 * @param form
	 * @throws BLException
	 */
    private void updateStatusTacticsInfo(IGPRD0158Form form) throws BLException {
        log.debug("============= ��������״̬���Կ�ʼ =============");
        String[] pidids = form.getPidid_i();
		String[] psdids = form.getPsdid_i();
		String[] pivalues = form.getPivalue();
		String[] notifyds = form.getNotifyd();
		String[] notifyh = form.getNotifyh();
		String[] notifym = form.getNotifym();
		String[] reportd = form.getReportd();
		String[] reporth = form.getReporth();
		String[] reportm = form.getReportm();
		String[] roleid = form.getRoleid();
		String[] rolemanager = form.getRolemanager();
		String[] processbl = form.getProcessbl();
		String[] notifieridsarr = form.getNotifierids();
		String[] psdconfirms = form.getPsdconfirms();
		String pdid = form.getPdid();
		IG237SearchCondImpl ig237cond = new IG237SearchCondImpl();
		// ����֪ͨʱ�����
		for (int i = 0; i < pidids.length; i++) {
			IG335TB ig335tb = new IG335TB();
			ig335tb.setPsdid(psdids[i]);
			ig335tb.setPidid(pidids[i]);
			ig335tb.setPivalue(pivalues[i]);
			ig335tb.setNotifyd(Integer.parseInt(StringUtils.isEmpty(notifyds[i]) ? "0" : notifyds[i]));
			ig335tb.setNotifyh(Integer.parseInt(StringUtils.isEmpty(notifyh[i]) ? "0" : notifyh[i]));
			ig335tb.setNotifym(Integer.parseInt(StringUtils.isEmpty(notifym[i]) ? "0" : notifym[i]));
			ig335tb.setReportd(Integer.parseInt(StringUtils.isEmpty(reportd[i]) ? "0" : reportd[i]));
			ig335tb.setReporth(Integer.parseInt(StringUtils.isEmpty(reporth[i]) ? "0" : reporth[i]));
			ig335tb.setReportm(Integer.parseInt(StringUtils.isEmpty(reportm[i]) ? "0" : reportm[i]));
			ig335tb.setRoleid(Integer.parseInt(StringUtils.isEmpty(roleid[i]) ? "0" : roleid[i]));
			ig335tb.setRolemanager(rolemanager[i]);
			ig335tb.setProcessbl(processbl[i]);
			ig335tb.setPsdconfirm(psdconfirms[i]);
			ig335tb.setPdid(pdid);
			workFlowDefinitionBL.registFormStrategy(ig335tb);
			
			//ɾ��֮ǰ��֪ͨ��
			ig237cond.setPsdid(psdids[i]);
			ig237cond.setPsdconfirm(psdconfirms[i]);
			ig237cond.setPivalue(pivalues[i]);
			List<IG237Info> lst_ProcessNoticeStrategyUser = workFlowDefinitionBL.searchProcessNoticeStrategyUserInfo(ig237cond);
			for(IG237Info bean : lst_ProcessNoticeStrategyUser) {
				workFlowDefinitionBL.deleteProcessNoticeStrategyUserInfo(bean);
			}
			
			//֪ͨ������Ϊ��ָ����
			if(IGPRDCONSTANTS.STRATEGY_NOTIFIER_TYPE_USER.equals(rolemanager[i])) {
//				IG237TB userTB = this.ig237BL.getIG237TBInstance();
				//����֪ͨ��
				String notifierids = notifieridsarr[i];
				if(StringUtils.isNotEmpty(notifierids)) {
					String[] arr_str = notifierids.split("###");
					List<IG237Info> ig237tblist_temp = new ArrayList<IG237Info>();
					for(String str : arr_str) {
						IG237TB userTB = new IG237TB();
						userTB.setPsdid(psdids[i]);
						log.debug("psdid:" + psdids[i]);
						userTB.setPsdconfirm(psdconfirms[i]);
						userTB.setPivalue(pivalues[i]);
						userTB.setRoleid(Integer.parseInt(str.split("##")[0]));
						userTB.setUserid(str.split("##")[1]);
						ig237tblist_temp.add(userTB);
					}
					workFlowDefinitionBL.registProcessNoticeStrategyUserInfo(ig237tblist_temp);
				}
			}
		}
		log.debug("============= ��������״̬���Խ��� =============");
    }
	
	
	/**
	 * ����֪ͨ������Ϣ�趨����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO setIGPRD0158Action(IGPRD01DTO dto) throws BLException {
		log.debug("========����֪ͨ������Ϣ�趨����ʼ========");
		IGPRD0158Form form = dto.getIgPRD0158Form();
		//���õ�����״̬ID�б�
		List<String> psdidList = new ArrayList<String>();
		// ��ѯ����֪ͨ������Ϣ
		IG334SearchCondImpl cond = new IG334SearchCondImpl();
		cond.setPdid_like(form.getPdid());
		List<IG334Info> ig334List = workFlowDefinitionBL.searchInformStrategy(cond);
		IG334TB ig334TB = null;
		// �Ѿ����ù�
		if(ig334List.size() > 0){
			ig334TB = (IG334TB) SerializationUtils.clone(ig334List.get(0));
			
			// �ж����̱��Ƿ����仯
			if(!ig334TB.getPidid().equals(form.getPidid())){
				// ���������仯��ɾ��IG334��ԭ�������ò�������Ӧ��IG335ͬʱɾ��
				for (IG334Info ig334Info : ig334List) {
	                workFlowDefinitionBL.deleteInformStrategy(ig334Info);
	            }
				IG335SearchCondImpl ig335cond = new  IG335SearchCondImpl();
				ig335cond.setPidid_like(ig334TB.getPidid());
				List<IG335Info> ig335List = workFlowDefinitionBL.searchFormStrategy(ig335cond);
				if(ig335List != null && ig335List.size() > 0){
					for(IG335Info ig335Info : ig335List){
						psdidList.add(ig335Info.getPsdid());
					}
				}
				workFlowDefinitionBL.deleteFormStrategy(ig335List);
				
				ig335cond = null;
				ig335List= null;
			}
		} 
		// û������
		else {
			ig334TB = new IG334TB();
		}
		ig334TB.setPdid(form.getPdid());
		ig334TB.setPidid(form.getPidid());
		ig334TB.setPidname(form.getPidname());
		ig334TB.setSms(form.getSms());
		ig334TB.setEmail(form.getEmail());
		workFlowDefinitionBL.registInformStrategy(ig334TB);

		//��֮ǰ������֪ͨ����ָ����
		for(String psdid : psdidList){
			//��Ҫɾ��֮ǰ��֪ͨ��
			IG237SearchCondImpl ig237cond = new IG237SearchCondImpl();
			ig237cond.setPsdid(psdid);
			List<IG237Info> ig237List = workFlowDefinitionBL.searchProcessNoticeStrategyUserInfo(ig237cond);
			for(IG237Info ig237 : ig237List) {
				workFlowDefinitionBL.deleteProcessNoticeStrategyUserInfo(ig237);
			}
		}

		log.debug("========����֪ͨ������Ϣ�趨��������========");
		return dto;
	}
	
	/**
	 * ����֪ͨ���Բ�ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO initIGPRD0159Action(IGPRD01DTO dto) throws BLException {
		log.debug("========���̲���֪ͨ�˲�ѯ����ʼ========");
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setRoletype(WorkFlowConstDefine.STRATEGY_REPORTER_ROLE_TYPE);
		dto.setLst_UserRoleInfo(this.userRoleBL.searchUserRoleVW(cond));
		if(dto.getLst_UserRoleInfo() == null || dto.getLst_UserRoleInfo().isEmpty()) {
			dto.addMessage(new ActionMessage("IGCO10000.E004", "����֪ͨ�˻���"));
		}
		log.debug("========���̲���֪ͨ�˲�ѯ��������========");
		return dto;
	}
	
	/**
	 * ��ť�¼�����ҳ�水ť���ϲ�ѯ
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessButtonDef(IGPRD01DTO dto) throws BLException {
		
		log.debug("========���̰�ť���ϲ�ѯ��ʼ========");
		// ��ѯ�����߰�ť������Ϣ
		IG132SearchCondImpl ig132SearchCond = new IG132SearchCondImpl();
		ig132SearchCond.setPpbdid_like(dto.getIgPRD0141Form().getPsdid());
		List<IG132Info> processParticipantButtonDefList = workFlowDefinitionBL.searchParticipantButtonDef(ig132SearchCond);
		List<LabelValueBean> buttonDefList = new ArrayList<LabelValueBean>();
		buttonDefList.add(new LabelValueBean("", ""));
		buttonDefList.add(new LabelValueBean("����", IGPRDCONSTANTS.BUTTON_UPDATE));
		List<String> pbdidList = new ArrayList<String>();
		if (!processParticipantButtonDefList.isEmpty()) {
		    for(IG132Info processParticipantButton : processParticipantButtonDefList){
		        // ��������߽�ɫ��������ͬ�İ�ťʱ����ֻ��ʾһ����ť
		        if (!pbdidList.contains(processParticipantButton.getPbdid())) {
		            buttonDefList.add(new LabelValueBean(processParticipantButton.getPpbdname(), 
		                    processParticipantButton.getPbdid()));
		            pbdidList.add( processParticipantButton.getPbdid());
		        }
	        }
		} else {
		    // ��������߰�ť������ϢΪ�����ѯȱʡ�İ�ť������Ϣ
		    IG725SearchCondImpl ig725SearchCond = new IG725SearchCondImpl();
	        ig725SearchCond.setPdbdid_like(dto.getIgPRD0141Form().getPsdid());
	        List<IG725Info> participantDefaultButtonDefInfoList = workFlowDefinitionBL.searchParticipantDefaultButtonDef(ig725SearchCond);
	        for(IG725Info participantDefaultButton : participantDefaultButtonDefInfoList){
                buttonDefList.add(new LabelValueBean(participantDefaultButton.getPdbdname(), 
                        participantDefaultButton.getPbdid()));
            }
		}
        dto.setProcessButtonDefList(buttonDefList);
		
		log.debug("========���̰�ť���ϲ�ѯ����========");
		return dto;
	}
	
	/**
	 * �ⲿ�¼������ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessExternalDefByPK(IGPRD01DTO dto) throws BLException {
		
		log.debug("========�ⲿ�¼������ѯ����ʼ========");
		IGPRD0161Form form = dto.getIgPRD0161Form();
		//��ȡ����״̬��Ϣ
		IG992Info info = workFlowDefinitionBL.searchProcessExternalDefInfoByKey(form.getPedid());
		//form.setPedid(info.getPedid());
		form.setPedeventid(info.getPedeventid());
		form.setPedaction(info.getPedaction());
		form.setPeddesc(info.getPeddesc());
		log.debug("========��ť�¼������ѯ��������========");
		return dto;
	}
	
	/**
	 * �ⲿ�¼�����
	 */
	public IGPRD01DTO updateProcessExternalDefAction(IGPRD01DTO dto) throws BLException {
		
		log.debug("========�ⲿ�¼��޸Ĵ���ʼ========");
		IGPRD0161Form form = dto.getIgPRD0161Form();
		//��ȡ����״̬��Ϣ
		IG992TB info = new IG992TB();
		info.setPedid(form.getPedid());
		info.setPedeventid(form.getPedeventid());
		info.setPedaction(form.getPedaction());
		info.setPeddesc(form.getPeddesc());

		workFlowDefinitionBL.updateProcessExternalDefInfo(info);
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "�ⲿ�¼�����") );
	  
		log.debug("========�ⲿ�¼��޸Ĵ�������========");
		return dto;
	}
	/**
	 * �ⲿ�¼�����
	 */
	public IGPRD01DTO insertProcessExteralDefAction(IGPRD01DTO dto) throws BLException {
		
		log.debug("========�ⲿ������Ӳ�ѯ����ʼ========");
		IGPRD0161Form form = dto.getIgPRD0161Form();
		//��ȡ����״̬��Ϣ

		workFlowDefinitionBL.registProcessExternalDefInfo(form);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "�ⲿ�¼�����") );
		log.debug("========�ⲿ������Ӳ�ѯ��������========");
		return dto;
	}
	/**
	 * �ⲿ�¼�ɾ��
	 */
	public IGPRD01DTO deleteProcessExternalDefAction(IGPRD01DTO dto) throws BLException {
		
		log.debug("=======��ť�¼�ɾ����ѯ����ʼ========");
		IGPRD0161Form form = dto.getIgPRD0161Form();
		//��ȡ����״̬��Ϣ
		workFlowDefinitionBL.deleteProcessExternalDefInfoByKey(form.getPedid());
		dto.addMessage(new ActionMessage( "IGCO10000.I006", "��ť�¼�����") );
		log.debug("=========��ť�¼�ɾ����ѯ��������========");
		
		return dto;
	}
	
	/**
	 * �ⲿ�¼������ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessExternalDefAction(IGPRD01DTO dto) throws BLException {
		
		log.debug("========�ⲿ�¼������ѯ����ʼ========");
		//��ȡ����״̬��Ϣ
		List<IG992Info> processExternalDefList = workFlowDefinitionBL.searchProcessExternalDefInfo(new IG992SearchCondImpl());
		if (processExternalDefList.size() == 0) {
			dto.addMessage(new ActionMessage( "IGCO10000.I004", "����Ϣ������Ϣ") );
		}
        //����ǰ������Ϣ
		dto.setProcessExternalDefList(processExternalDefList);
		log.debug("========��ť�¼������ѯ��������========");
		return dto;
	}
	
	/**
	 * ͨ�ñ���Ϣ�����ʼ������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO initIGPRD0118Action(IGPRD01DTO dto) throws BLException {
		log.debug("========ͨ�ñ���Ϣ�����ʼ������ʼ========");
		
		IGPRD0118Form form = dto.getIgPRD0118Form();
		
		IG202Info pid = workFlowDefinitionBL.searchProcessInfoDefGeneralByKey(form.getPidid());
		
		form.setPidid(pid.getPidid());
		form.setPidname(pid.getPidname());
		form.setPidlabel(pid.getPidlabel());
		form.setPiddesc(pid.getPiddesc());
		form.setPidtype(pid.getPidtype());
		form.setPidoption(pid.getPidoption());
		form.setPiddefault(pid.getPiddefault());
		form.setPidrequired(pid.getPidrequired());
		form.setPidsortid(pid.getPidsortid());
		form.setCcid(pid.getCcid());
		form.setPidmode(pid.getPidmode());
		form.setPrivatescope(pid.getPrivatescope());
		form.setRowwidth(pid.getRowwidth());
		
		dto.setIgPRD0118Form(form);
		
		log.debug("========ͨ�ñ���Ϣ�����ʼ����������========");
		return dto;
	}
	
	/**
	 * ����״̬��Ϣ�������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO updateProcessInfoDefGeneralAction(IGPRD01DTO dto) throws BLException {

		log.debug("========ͨ�ñ���Ϣ�������ʼ========");
		IGPRD0118Form form = dto.getIgPRD0118Form();
		
		IG202Info pid = workFlowDefinitionBL.searchProcessInfoDefGeneralByKey(form.getPidid());
		
		//�ж�״̬�����Ƿ��ظ�
		IG202SearchCondImpl cond = new IG202SearchCondImpl();
		cond.setPidlabel(form.getPidlabel());
		cond.setPidid_notlike(form.getPidid());
		List<IG202Info> pInfoList = workFlowDefinitionBL.searchProcessInfoDefGeneral(cond,0,0);
		
		if(pInfoList != null && pInfoList.size() > 0 ){
			throw new BLException("IGPRD0111.E001","�������Ѵ���");
		}
		//���ƶ���
		IG202TB pidTB = (IG202TB)SerializationUtils.clone(pid);
			
		pidTB.setPidlabel(form.getPidlabel());
		pidTB.setPidname(form.getPidlabel());
		pidTB.setPiddesc(form.getPiddesc());
		pidTB.setPidoption(form.getPidoption());
		pidTB.setPiddefault(form.getPiddefault());
		pidTB.setPidrequired(form.getPidrequired());
		pidTB.setPidmode(form.getPidmode());
		pidTB.setPrivatescope(form.getPrivatescope());
		pidTB.setRowwidth(form.getRowwidth());
		//����״̬��Ϣ�������
		workFlowDefinitionBL.updateProcessInfoDefGeneral(pidTB);

		//====> ��ܱ���Begin
		String message = "����";
		String pdid_type = pidTB.getPidtype();
		if(IGPRDCONSTANTS.PRTYPE_YEAR.equals(pdid_type)
				|| IGPRDCONSTANTS.PRTYPE_SEASON.equals(pdid_type)
				|| IGPRDCONSTANTS.PRTYPE_IRREGULAR.equals(pdid_type)){
			message = "����";
			
		}
		dto.addMessage(new ActionMessage( "IGCO10000.I005", message + "������Ϣ") );
		//====> ��ܱ���End
		
		log.debug("========ͨ�ñ���Ϣ�����������========");
		return dto;
	}
	
	/**
	 * ����״̬��Ϣ��ѯ
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessStatusDef(IGPRD01DTO dto) throws BLException {
		
		log.debug("========����״̬��Ϣ��ѯ����ʼ========");
		IGPRD0105Form form = dto.getIgPRD0105Form();
		IG333SearchCondImpl cond = new IG333SearchCondImpl();
		cond.setPdid(form.getPdid());
		cond.setNotContainEndStatus("1");
		if (StringUtils.isEmpty(nullToString(form.getPpsdid()))) {
			cond.setFatherflag("Y");
		} else {
			cond.setPpsdid(form.getPpsdid());
		}
		if("1".equalsIgnoreCase(form.getMode())){
			cond.setNotContainSelf(form.getPsdid());
		}
		//��ǰҳ��Ϣȡ��
		List<IG333Info> processStatusDefList = workFlowDefinitionBL.searchProcessStatusDef(cond);
		dto.setProcessStatusDefList(processStatusDefList);
		log.debug("========����״̬��Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * ����״̬�ɵ��������߲�ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessStatusPrtChangeDefAction(IGPRD01DTO dto) throws BLException {
		log.debug("========����״̬���������߲�ѯ����ʼ========");
		IGPRD0142Form form = dto.getIgPRD0142Form();
		//��ѯ��ǰ�������̵�����״̬ ����������ʼ�͹رգ�
		IG333SearchCondImpl cond = new IG333SearchCondImpl();
		cond.setPdid(dto.getPdid());
		cond.setNotContainEndStatus("1");
		cond.setNotContainStartStatus("1");
		cond.setPsdtype("0");//��ͨ�ڵ�
		cond.setPsdmode("1");//��ͨģʽ
		if (StringUtils.isEmpty(nullToString(form.getPpsdid()))) {
			cond.setFatherflag("Y");
		} else {
			cond.setPpsdid(form.getPpsdid());//�ϼ�״̬ID
		}
		List<IG333Info> processStatusDefList = workFlowDefinitionBL.searchProcessStatusDef(cond);
		
		//��ѯ��ǰ״̬�������õĵ���״̬
		IG258SearchCondImpl condImpl = new IG258SearchCondImpl();
		condImpl.setPsdid(form.getPsdid());
		List<IG258Info> infoList = workFlowDefinitionBL.searchProcessStatusPrtChangeDefInfo(condImpl);
		
		//ȡ��ҳ����ʾ����
		List<IG333TB> lstProcessStatusDef = new ArrayList<IG333TB>();
		String isSelected = "";
		for(IG333Info def : processStatusDefList){
			IG333TB tb = (IG333TB)SerializationUtils.clone(def);
			isSelected = "0";
			//�ж��Ƿ����ù�
			for(IG258Info info : infoList){
				//�Ѿ����ù�����ʾʱѡ��
				if(info.getPspcdpsdid().equalsIgnoreCase(def.getPsdid())){
					isSelected = "1";
				}
			}
			tb.setIsSelected(isSelected);
			lstProcessStatusDef.add(tb);
		}
		dto.setPsdTBList(lstProcessStatusDef);
		log.debug("========����״̬�ɵ��������߲�ѯ��������========");
		return dto;
	}
	
	/**
	 * ����״̬�ɵ����������趨����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO changeProcessStatusPrtChangeDefAction(IGPRD01DTO dto) throws BLException {
		log.debug("========����״̬���������߲�ѯ����ʼ========");
		IGPRD0142Form form = dto.getIgPRD0142Form();
		String[] ids = form.getIds();
		//��ѯ��ǰ״̬�������õĵ���״̬
		IG258SearchCondImpl condImpl = new IG258SearchCondImpl();
		condImpl.setPsdid(form.getPsdid());
		List<IG258Info> infoList = workFlowDefinitionBL.searchProcessStatusPrtChangeDefInfo(condImpl);
		
		//ȡ����Ҫɾ������
		List<IG333TB> lstProcessStatusDef = new ArrayList<IG333TB>();
		boolean isSelected;
		if(ids != null) {
			for(String psdid : ids){
				isSelected = false;
				//�ж��Ƿ����ù�
				for(IG258Info info : infoList){
					//�Ѿ����ù�������������
					if(info.getPspcdpsdid().equalsIgnoreCase(psdid)){
						infoList.remove(info);
						isSelected = true;
						break;
					}
				}
				//û�б����
				if(!isSelected){
					IG258TB tb = new IG258TB();
					tb.setPspcdid(workFlowDefinitionBL.getProcessStatusPrtChangeDefPK(form.getPsdid()));//����);
					tb.setPsdid(form.getPsdid());
					tb.setPspcdpsdid(psdid);
					workFlowDefinitionBL.registProcessStatusPrtChangeDefInfo(tb);
				}
			}
		} 
		//ɾ��
		if(infoList.size() > 0){
			for(IG258Info info : infoList){
				workFlowDefinitionBL.deleteProcessStatusPrtChangeDefInfo(info);
			}
		}
		dto.setPsdTBList(lstProcessStatusDef);
		dto.addMessage(new ActionMessage("IGPRD0142.I001"));
		log.debug("========����״̬�ɵ��������߲�ѯ��������========");
		return dto;
	}
	
	/**
	 * ����ʼ�����ò�ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchIG373InfoAction(IGPRD01DTO dto) throws BLException {
		log.debug("========����ʼ�����ò�ѯ����ʼ========");
		dto.setLst_IG373Info(workFlowDefinitionBL.searchInitFormEventHandler(dto.getIgPRD0165Form()));
		log.debug("========����ʼ�����ò�ѯ��������========");
		return dto;
	}
	
	/**
	 * ����ʼ��������������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO insertIG373InfoAction(IGPRD01DTO dto) throws BLException {
		log.debug("========����ʼ��������������ʼ========");
		IGPRD0166Form form = dto.getIgPRD0166Form();
		form.setPiidid(workFlowDefinitionBL.getInitFormEventHandlerPK(form.getPsdid()));
		workFlowDefinitionBL.registInitFormEventHandler(form);
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "����ʼ��������Ϣ") );
		log.debug("========����ʼ������������������========");
		return dto;
	}
	
	/**
	 * ����ʼ������ɾ������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO deleteIG373InfoAction(IGPRD01DTO dto) throws BLException {
		log.debug("========����ʼ������ɾ������ʼ========");
		workFlowDefinitionBL.deleteInitFormEventHandlerByKey(dto.getIgPRD0165Form().getPiidid());
		dto.addMessage(new ActionMessage( "IGCO10000.I006", "����ʼ��������Ϣ") );
		log.debug("========����ʼ������ɾ����������========");
		return dto;
	}
	
	/**
	 * ����ʼ�������޸ĳ�ʼ������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO initIG373InfoAction(IGPRD01DTO dto) throws BLException {
		log.debug("========����ʼ�������޸ĳ�ʼ������ʼ========");
		IGPRD0166Form form = dto.getIgPRD0166Form();
		IG373Info ig373Info = workFlowDefinitionBL.searchInitFormEventHandlerByKey(dto.getIgPRD0166Form().getPiidid());
		form.setPiidblid(ig373Info.getPiidblid());
		form.setPiiddec(ig373Info.getPiiddec());
		form.setPdid(ig373Info.getPdid());
		form.setPsdid(ig373Info.getPsdid());
		log.debug("========����ʼ�������޸ĳ�ʼ����������========");
		return dto;
	}
	
	/**
	 * ����ʼ�������޸Ĵ���
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO editIG373InfoAction(IGPRD01DTO dto) throws BLException {
		log.debug("========����ʼ�������޸Ĵ���ʼ========");
		IG373TB ig373 = (IG373TB)SerializationUtils.clone(workFlowDefinitionBL.searchInitFormEventHandlerByKey(dto.getIgPRD0166Form().getPiidid()));
		ig373.setPiidblid(dto.getIgPRD0166Form().getPiidblid());
		ig373.setPiiddec(dto.getIgPRD0166Form().getPiiddec());
		workFlowDefinitionBL.updateInitFormEventHandler(ig373);
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "����ʼ��������Ϣ") );
		log.debug("========����ʼ�������޸Ĵ�������========");
		return dto;
	}
    
	/**
	 * ��Ȩ�޲�ѯ��ʼ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO getProcessRoleConfigAction(IGPRD01DTO dto)
			throws BLException {
		IGPRD0171Form form=dto.getIgPRD0171Form();
		
		IG700SearchCondImpl ig700cond=new IG700SearchCondImpl();
		ig700cond.setPdid(form.getPdid());
		List<IG700Info>  ig700InfoList=workFlowDefinitionBL.searchProcessSeeRoleInfo(ig700cond);
		dto.setIg700InfoList(ig700InfoList);
		RoleSearchCondImpl cond1 = new RoleSearchCondImpl();
		cond1.setPdid(dto.getPdid());
		List<Role> list = roleBL.searchRoleForSelfDef(cond1,0,0);
		if(ig700InfoList==null || ig700InfoList.size()==0){
			//����������ӵĽ�ɫ����
			dto.setRoleList(list);
		}else{
			List<Role> roleList = new ArrayList<Role>();
			for(Role role:list){
				boolean flag = true;
				for(IG700Info ppd:ig700InfoList){
					if(role.getRoleid().equals(ppd.getRoleid())){
						flag = false;
						break;
					}
				}
				if(flag){
					roleList.add(role);
				}
			}
			dto.setRoleList(roleList);
		}
		return dto;
	}
	
	/**
	 * ɾ����Ȩ�޽�ɫ
	 * @param dto
	 * @throws BLException
	 */
	public IGPRD01DTO removeProcessRoleConfig(IGPRD01DTO dto) throws BLException {
		log.debug("ɾ����Ȩ�޽�ɫ��ʼ");
		IGPRD0171Form form=dto.getIgPRD0171Form();
		String[] prdids=form.getPrdids();
		if(prdids!=null&&prdids.length>0){
			for(int i=0;i<prdids.length;i++){
				String pdid=prdids[i].split("_")[0];
				String roleid=prdids[i].split("_")[1];
				IG700PK pk=new IG700PK(pdid,Integer.parseInt(roleid));
				workFlowDefinitionBL.deleteProcessSeeRoleInfoByKey(pk);
			}
		}
		log.debug("ɾ����Ȩ�޽�ɫ����");
		return dto;
	}
	
	/**
	 * ��ӱ�Ȩ�޽�ɫ
	 * @param dto
	 * @throws BLException
	 */
	public IGPRD01DTO addProcessRoleConfig(IGPRD01DTO dto) throws BLException {
		log.debug("��ӱ�Ȩ�޽�ɫ��ʼ");
		IGPRD0171Form form=dto.getIgPRD0171Form();
		String pdid=form.getPdid();
		String[] roleids=form.getRoleids();
		if(roleids!=null&&roleids.length>0){
			for(int i=0;i<roleids.length;i++){
				IG700TB tb=new IG700TB();
				tb.setPdid(pdid);
				tb.setRoleid(Integer.parseInt(roleids[i]));
				workFlowDefinitionBL.registProcessSeeRoleInfo(tb);
			}
		}
		log.debug("��ӱ�Ȩ�޽�ɫ����");
		return dto;
	}
	
	
	/**
	 * ����ѯ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO getProcessRoleFormRelationAction(IGPRD01DTO dto)
			throws BLException {
		IGPRD0172Form form=dto.getIgPRD0172Form();
		
		IG701SearchCondImpl ig701cond=new IG701SearchCondImpl();
		ig701cond.setPdid(form.getPdid());
		ig701cond.setRoleid(Integer.parseInt(form.getRoleid()));
		//��ȡ���б���
		List<IG701Info>  ig701InfoList=workFlowDefinitionBL.searchRoleForm(ig701cond);
		dto.setIg701InfoList(ig701InfoList);
		//��ȡ�������������б���
//		List<IG007Info> list = this.ig007BL.searchIG007InfoByPdid(form.getPdid());
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPdid(form.getPdid());
		cond.setTableColumn("N");
		List<IG007Info> list = workFlowDefinitionBL.searchProcessInfoDef(cond);
		if(ig701InfoList==null || ig701InfoList.size()==0){
			//����������ӵı�����
			dto.setProcessInfoDefList(list);
		}else{
			List<IG007Info> ig007InfoList = new ArrayList<IG007Info>();
			for(IG007Info info:list){
				boolean flag = true;
				for(IG701Info ig701Info:ig701InfoList){
					if(info.getPidid().equals(ig701Info.getPidid())){
						flag = false;
						break;
					}
				}
				if(flag){
					ig007InfoList.add(info);
				}
			}
			dto.setProcessInfoDefList(ig007InfoList);
		}
		return dto;
	}
	
	/**
	 * ɾ����Ȩ��
	 * @param dto
	 * @throws BLException
	 */
	public IGPRD01DTO removeProcessRoleFormRelation(IGPRD01DTO dto) throws BLException {
		log.debug("ɾ����Ȩ�޿�ʼ");
		IGPRD0172Form form=dto.getIgPRD0172Form();
		String[] pidida=form.getPidida();
		if(pidida!=null&&pidida.length>0){
			for(int i=0;i<pidida.length;i++){
				String pdid=pidida[i].split("_")[0];
				String roleid=pidida[i].split("_")[1];
				String pidid=pidida[i].split("_")[2];
				IG701PK pk=new IG701PK(pdid,Integer.parseInt(roleid),pidid);
				workFlowDefinitionBL.deleteRoleForm(pk);
			}
		}
		log.debug("ɾ����Ȩ�޽���");
		return dto;
	}
	
	/**
	 * ��ӱ�Ȩ��
	 * @param dto
	 * @throws BLException
	 */
	public IGPRD01DTO addProcessRoleFormRelation(IGPRD01DTO dto) throws BLException {
		log.debug("��ӱ�Ȩ�޿�ʼ");
		IGPRD0172Form form=dto.getIgPRD0172Form();
		String pdid=form.getPdid();
		String[] pididb=form.getPididb();
		if(pididb!=null&&pididb.length>0){
			for(int i=0;i<pididb.length;i++){
				IG701TB tb=new IG701TB();
				tb.setPdid(pdid);
				tb.setRoleid(Integer.parseInt(form.getRoleid()));
				tb.setPidid(pididb[i]);
				workFlowDefinitionBL.registRoleForm(tb);
			}
		}
		log.debug("��ӱ�Ȩ�޽���");
		return dto;
	}
	
	/**
	 * �Զ�������ҳ�����ò�ѯ
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessJspInfoAction(IGPRD01DTO dto) throws BLException {
		log.debug("========�Զ�������ҳ������ѯ����ʼ========");
		IG126SearchCondImpl cond = new IG126SearchCondImpl();
		try {
			//IgPRD0168Form ���ڲ�ѯ
			if(dto.getIgPRD0168Form() != null)
			{
				BeanUtils.copyProperties(cond, dto.getIgPRD0168Form());
			}
			//IgPRD0169Form �����޸ĺ�����
			else if (dto.getIgPRD0169Form() != null)
			{
				BeanUtils.copyProperties(cond, dto.getIgPRD0169Form());
				cond.setPjdid_like(dto.getIgPRD0169Form().getPjdid());
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		List<IG126Info> list = workFlowDefinitionBL.searchProcessJspDef(cond);
		dto.setProcessJspInfoList(list);
		//��ѯ�������� 20121123 cuixuezhi
		if(StringUtils.isNotEmpty(cond.getPdid()))
		{
			IG380Info ig380info = workFlowDefinitionBL.searchProcessDefinitionByKey(cond.getPdid());
			dto.setIg380info(ig380info);
		}
		log.debug("========�Զ�������ҳ������ѯ��������========");
		return dto;
	}
	/**
	 * �Զ�������ҳ�����õǼ�
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO insertProcessJspAction(IGPRD01DTO dto) throws BLException {
		log.debug("========�Զ�������ҳ�����ǼǴ���ʼ========");
		IGPRD0169Form form = dto.getIgPRD0169Form();
		form.setPjdid(workFlowDefinitionBL.getProcessJspDefPK(form.getPdid()));
		IG126Info ig126Info = new IG126TB();
		try {
			BeanUtils.copyProperties(ig126Info, form);
		} catch (IllegalAccessException e) {			
			e.printStackTrace();
		} catch (InvocationTargetException e) {			
			e.printStackTrace();
		}		
		//====> ��ܱ���Begin
		IG126Info registIG126Info = workFlowDefinitionBL.registProcessJspDef(ig126Info);
		String message = "����";
		String pdid_one = StringUtils.isEmpty(registIG126Info.getPdid()) ? "0" : registIG126Info.getPdid().substring(0,1);
		if(IGPRDCONSTANTS.PRTYPE_YEAR_STATUS_ID.equals(pdid_one)
				|| IGPRDCONSTANTS.PRTYPE_SEASON_STATUS_ID.equals(pdid_one)
				|| IGPRDCONSTANTS.PRTYPE_IRREGULAR_STATUS_ID.equals(pdid_one)){
			message = "����";
			
		}
		dto.addMessage(new ActionMessage( "IGCO10000.I004", message + "ҳ�����") );
		//====> ��ܱ���End
		log.debug("========�Զ�������ҳ�����ǼǴ�������========");
		return dto;
	}
	/**
	 * 	 * �Զ�������ҳ�������޸�
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO editProcessJspAction(IGPRD01DTO dto) throws BLException {
		log.debug("========�Զ�������ҳ������޸Ĵ���ʼ========");
		IG126TB ig126 = (IG126TB)SerializationUtils.clone(workFlowDefinitionBL.searchProcessJspDefByKey(dto.getIgPRD0169Form().getPjdid()));
		//bl
		ig126.setPjdblid(dto.getIgPRD0169Form().getPjdblid());
		//ҳ������	
		ig126.setPjdtype(dto.getIgPRD0169Form().getPjdtype());
		//url
		ig126.setPjdurl(dto.getIgPRD0169Form().getPjdurl());	
		//====> ��ܱ���Begin
		IG126Info updateIG126Info = workFlowDefinitionBL.updateProcessJspDef(ig126);
		String message = "����";
		String pdid_one = StringUtils.isEmpty(updateIG126Info.getPdid()) ? "0" : updateIG126Info.getPdid().substring(0,1);
		if(IGPRDCONSTANTS.PRTYPE_YEAR_STATUS_ID.equals(pdid_one)
				|| IGPRDCONSTANTS.PRTYPE_SEASON_STATUS_ID.equals(pdid_one)
				|| IGPRDCONSTANTS.PRTYPE_IRREGULAR_STATUS_ID.equals(pdid_one)){
			message = "����";
			
		}
		dto.addMessage(new ActionMessage( "IGCO10000.I005", message + "ҳ�����") );
		//====> ��ܱ���End
		log.debug("========�Զ�������ҳ������޸Ĵ�������========");
		return dto;
	}
	/**
	 * �Զ�������ҳ������ɾ��
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO deleteProcessJspAction(IGPRD01DTO dto) throws BLException {
		log.debug("========�Զ�������ҳ�����ɾ������ʼ========");
		workFlowDefinitionBL.deleteProcessJspDefByKey(dto.getIgPRD0169Form().getPjdid());
		//====> ��ܱ���Begin
		String message = "����";
		String pdid_one = StringUtils.isEmpty(dto.getIgPRD0169Form().getPjdid()) ? "0" : dto.getIgPRD0169Form().getPjdid().substring(0,1);
		if(IGPRDCONSTANTS.PRTYPE_YEAR_STATUS_ID.equals(pdid_one)
				|| IGPRDCONSTANTS.PRTYPE_SEASON_STATUS_ID.equals(pdid_one)
				|| IGPRDCONSTANTS.PRTYPE_IRREGULAR_STATUS_ID.equals(pdid_one)){
			message = "����";
			
		}
		dto.addMessage(new ActionMessage( "IGCO10000.I006", message + "ҳ�����") );
		//====> ��ܱ���End
		log.debug("========�Զ�������ҳ�����ɾ����������========");
		return dto;
	}
	
	/**
	 * ��ѯ�����趨ҳ���ʼ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO getProcessInfoQueryInfo(IGPRD01DTO dto) throws BLException {
		log.debug("============��ѯ����ҳ���ʼ��������ʼ=============");
		//��ѯ�Ѷ���Ĳ�ѯ����
//		List<IG108Info> pqList = workFlowDefinitionBL.searchFormQueryDefByPdid(dto.getPdid());
//		//��ѯ����Ϣ
//		IG007SearchCondImpl cond = new IG007SearchCondImpl();
//		cond.setPdid(dto.getPdid());
//		cond.setTableColumn("N");
//		List<IG007Info> pidList = workFlowDefinitionBL.searchProcessInfoDef(cond);
//		//���˵��Ѵ��ڵ�����
//		List<IG007Info> pdList = new ArrayList<IG007Info>();
//		if(pidList!=null){
//			for(IG007Info pd:pidList){
//				boolean flag = true;
//				if(pqList!=null){
//					for(IG108Info pq:pqList){
//						if(pd.getPidid().equals(pq.getPidid())){
//							flag = false;
//							break;
//						}
//					}
//				}
//				if(flag){
//					if("0".equals(pd.getPidtype())
//					 ||"2".equals(pd.getPidtype())
//					 ||"9".equals(pd.getPidtype())
//					 ||"B".equals(pd.getPidtype())
//					 ||"C".equals(pd.getPidtype())
//					 ||"E".equals(pd.getPidtype())){
//						pdList.add(pd);
//					}
//				}
//			}
//		}
//		dto.setPdList(pdList);
//		dto.setPqList(pqList);
		if(dto.getForm() != null && dto.getForm() instanceof IGPRD0145Form){
			IGPRD0145Form form = (IGPRD0145Form) dto.getForm();
			//���̶���IDȡ��
			String pdid = form.getPdid();
			//��ѯ�������б�����
			IG007SearchCondImpl pidCond = new IG007SearchCondImpl();
			pidCond.setPdid(pdid);
			pidCond.setTableColumn("N");
			List<IG007Info> pidList = workFlowDefinitionBL.searchProcessInfoDef(pidCond);
			Map<String, String> sMap = IGPRD01BLType.getDefaultShowColumn();
			Map<String, String> qMap = IGPRD01BLType.getDefaultShowColumn();
			for(IG007Info info:pidList){
				if("0".equals(info.getPidtype())
						|| "2".equals(info.getPidtype())
						|| "3".equals(info.getPidtype())
						|| "7".equals(info.getPidtype())
						|| "8".equals(info.getPidtype())
						|| "9".equals(info.getPidtype())
						|| "A".equals(info.getPidtype())
						|| "B".equals(info.getPidtype())
						|| "C".equals(info.getPidtype())
						|| "G".equals(info.getPidtype())
						|| "R".equals(info.getPidtype())
						|| "T".equals(info.getPidtype())){
					String key = "pi#" + info.getPidid() + "#" + info.getPidname();
					sMap.put(key, info.getPidname());
					qMap.put(key, info.getPidname());
				}
			}
			//��ѯ���趨��ʾ��
			List<IG110Info> psList = workFlowDefinitionBL.searchProcessQueryShowColumnByPdid(pdid);
			for(IG110Info info:psList){
				String key = info.getStype() + "#" + info.getSflag() + "#" + info.getSname();
				if(sMap.get(key) != null){
					sMap.remove(key);
				}
			}
			//��ѯ���趨��ѯ����
			List<IG111Info> pqList = workFlowDefinitionBL.searchprocessQueryByPdid(pdid);
			for(IG111Info info:pqList){
				String key = info.getQtype() + "#" + info.getQflag() + "#" + info.getQname();
				if(qMap.get(key) != null){
					qMap.remove(key);
				}
			}
			dto.setQueryShowColumnList(psList);
			dto.setQueryShowColumnMap(sMap);
			dto.setQueryList(pqList);
			dto.setQueryMap(qMap);
			
		}
		log.debug("============��ѯ����ҳ���ʼ����������=============");
		return dto;
	}
	
	/**
	 * ��ѯ����ɾ������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO removeProcessInfoQuery(IGPRD01DTO dto) throws BLException{
		log.debug("============��ѯ����ɾ��������ʼ==============");
		//ҳ����Ϣȡ��
		IGPRD0145Form form = dto.getIgprd0145Form();
		if(form.getPidid_del()!=null&&form.getPidid_del().length>0){
			for(int i=0;i<form.getPidid_del().length;i++){
				workFlowDefinitionBL.deleteFormQueryDefByKey(Integer.valueOf(form.getPidid_del()[i]));
			}
		}
		log.debug("============��ѯ����ɾ����������==============");
		return dto;
	}

	/**
	 * ��ѯ������������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO addProcessInfoQuery(IGPRD01DTO dto) throws BLException{
		log.debug("==========��ѯ��������������ʼ==========");
		//ҳ����Ϣȡ��
		IGPRD0145Form form = dto.getIgprd0145Form();
		if(form.getPidid_add()!=null&&form.getPidid_add().length>0){
			for(int i=0;i<form.getPidid_add().length;i++){
				IG108TB pqTB = new IG108TB();
				pqTB.setPdid(form.getPdid());
				pqTB.setPidid(form.getPidid_add()[i]);
				workFlowDefinitionBL.registFormQueryDefInfo(pqTB);
			}
		}
		log.debug("==========��ѯ����������������==========");
		return dto;
	}
	
	//====>130225Begin
	/**
	 * ��ѯ����������
	 * 
	 * @param dto
	 * @return IGPRD01DTO
	 * @throws BLException
	 */
	public IGPRD01DTO searchCodedetailFromPsdassign(IGPRD01DTO dto) throws BLException {
		log.debug("==========�����������б��ѯҵ���߼�����ʼ==========");
		List<LabelValueBean> lvListRO = new ArrayList<LabelValueBean>();
		List<LabelValueBean> lvListUR = new ArrayList<LabelValueBean>();
		// ��ѯ
		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
		cond.setCcid(CodeDefine.getCodeDefine("PROCESSSTATUSDEF_PSDASSIGN").getCcid());
//		cond.setCdinfo("1");
		List<CodeDetail> cdList = codeDetailBL.searchCodeDetail(cond, 0);
		// ����
		for (CodeDetail cd : cdList) {
			// ���������ͣ���Ա�ͽ�ɫ
			if(IGPRDCONSTANTS.PSDASSIGN_USER.equals(cd.getCid()) 
					|| IGPRDCONSTANTS.PSDASSIGN_ROLE.equals(cd.getCid())){
				lvListUR.add(new LabelValueBean(cd.getCvalue(),cd.getCid()));
			}
			// ���������ͣ���ɫ�ͻ���
			if(IGPRDCONSTANTS.PSDASSIGN_ROLE.equals(cd.getCid()) 
					|| IGPRDCONSTANTS.PSDASSIGN_ORG.equals(cd.getCid())){
				lvListRO.add(new LabelValueBean(cd.getCvalue(),cd.getCid()));
			}
		}
		dto.setLvPsdassignListRO(lvListRO);
		dto.setLvPsdassignListUR(lvListUR);
		log.debug("==========�����������б��ѯҵ���߼���������==========");
		return dto;
	}
	
	/**
	 * ����״̬�ɷ��ɻ�����ѯ����
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO searchProcessStatusOrgDefAction(IGPRD01DTO dto) throws BLException {
		log.debug("========����״̬�ɷ��ɻ�����ѯ����ʼ========");
		IGPRD0143Form form = dto.getIgPRD0143Form();
		//��ѯ��ѡ����
		dto.setLst_ProcessStatusOrgDef(workFlowDefinitionBL.searchProcessStatusOrgDefInfoByPsdid(form.getPsdid()));
		//��ѯ��ѡ�����ļ���
		String orgnatation_level = ResourceUtility.getString("ORGNATATION_LEVEL");
		//�����ѯ��ѡ�����Ļ�������󳤶�
		int levellen = 28;
		if(StringUtils.isNotEmpty(orgnatation_level)){
			levellen = 4 + (Integer.valueOf(orgnatation_level)-1)*3;
		}else{
			throw new BLException("IGPRD0143.E001");
		}
		//��ѯ��ѡ������Ϣ
		List<Organization> lst_org = workFlowDefinitionBL.searchToBeAssignOrg(form.getPdid(), levellen,form.getPsdid());
		dto.setLst_org(lst_org);
		log.debug("========����״̬�ɷ��ɻ�����ѯ��������========");
		return dto;
	}
	
	/**
	 * ����״̬�ɷ��ɻ���ɾ��
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO removeProcessStatusOrgDef(IGPRD01DTO dto) throws BLException {
		log.debug("========����״̬�ɷ��ɻ���ɾ������ʼ========");
		IGPRD0143Form form = dto.getIgPRD0143Form();
		if(form.getPsodids() != null) {
			for(String psodid : form.getPsodids()){
				workFlowDefinitionBL.deleteProcessStatusOrgDefInfoByKey(psodid);
			}
		}
		dto.addMessage(new ActionMessage("IGPRD0143.I002"));
		log.debug("========����״̬�ɷ��ɻ���ɾ����������========");
		return dto;
	}
	
	/**
	 * ����״̬�ɷ��ɻ�������
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public IGPRD01DTO addProcessStatusOrgDef(IGPRD01DTO dto) throws BLException {
		log.debug("========����״̬�ɷ��ɻ�����������ʼ========");
		IGPRD0143Form form = dto.getIgPRD0143Form();
		OrganizationSearchCondImpl orgcond = new OrganizationSearchCondImpl();
		List<Organization> lst_org = new ArrayList<Organization>();
		if(form.getOrgsyscodings() != null) {
			for(String orgsyscoding : form.getOrgsyscodings()){
				IG299TB psoTB = new IG299TB();
				// �ɷ��ɻ�������
				psoTB.setPsodid(workFlowDefinitionBL.getProcessStatusOrgDefInfoPK(form.getPsdid()));
				// ״̬�ڵ�id
				psoTB.setPsdid(form.getPsdid());
				// ���������
				psoTB.setOrgsyscoding(orgsyscoding);
				// ���ݻ�������룬��ѯ��������
				orgcond.setOrgsyscoding(orgsyscoding);
				lst_org = organizationBL.searchOrganization(orgcond);
				psoTB.setOrgname(lst_org.get(0) == null ? "" : lst_org.get(0).getOrgname());
				workFlowDefinitionBL.registProcessStatusOrgDefInfo(psoTB);
			}
		}
		dto.addMessage(new ActionMessage("IGPRD0143.I001"));
		log.debug("========����״̬�ɷ��ɻ���������������========");
		return dto;
	}
	
	/**
	 * ����״̬�ɷ��ɻ���ɾ��
	 *
	 * @param dto IGPRD01DTO
	 * @return IGPRD01DTO
	 */
	public void deleteIg298Info(String psdid, boolean roleid_is_null, boolean orgsyscoding_is_null) throws BLException {
		log.debug("========����״̬�ɷ��ɽ�ɫ�����ɾ������ʼ========");
		List<IG298Info> searchIG298Info = workFlowDefinitionBL.searchProcessStatusRoleDefInfoByPsdid(psdid);
		if(searchIG298Info != null){
			for (IG298Info instance : searchIG298Info) {
				workFlowDefinitionBL.deleteProcessStatusRoleDefInfoByKey(instance.getPsrdid());
			}
		}
		
		log.debug("========����״̬�ɷ��ɽ�ɫ�����ɾ����������========");
	}
	
	/**
	 * ��ӻ���������
	 * @param dto
	 * @throws BLException
	 */
	public IGPRD01DTO addProcessParticipantsByOrg(IGPRD01DTO dto) throws BLException {
		log.debug("=============��Ӳ����˲�����ʼ===========");
		//ҳ����Ϣȡ��
		IGPRD0134Form form = dto.getIgprd0134Form();
		//����ָ��Ĭ�ϲ�����
		String[] ppuserids = form.getPpuserids();
		if(form.getOrgids()!=null){
			for(int i=0;i<form.getOrgids().length;i++){
				IG222TB newppd = new IG222TB();
				newppd.setPsdid(form.getPsdid());
				newppd.setOrgid(form.getOrgids()[i]);
				if(ppuserids != null && StringUtils.isNotEmpty(ppuserids[i])) {
					newppd.setUserid(ppuserids[i]);
				}
				newppd.setPpdid(workFlowDefinitionBL.getParticipantDefPK(form.getPsdid()));
				workFlowDefinitionBL.registParticipantDef(newppd);
			}
		}
		dto.addMessage(new ActionMessage("IGPRD0107.I001",IGPRDCONSTANTS.PPD_ADD_PROCESSPARTICIPANT_MESSAGE));
		log.debug("=============��Ӳ����˲�������===========");
		return dto;
	}
	
	
	/**
	 * ɾ������������
	 * @param dto
	 * @throws BLException
	 */
	public IGPRD01DTO removeProcessParticipantsByOrg(IGPRD01DTO dto) throws BLException {
		log.debug("=============ɾ�������˲�����ʼ=============");
		//ҳ����Ϣȡ��
		IGPRD0134Form form = dto.getIgprd0134Form();
		for(int i=0;i<form.getPpdids().length;i++){
			IG222SearchCondImpl cond = new IG222SearchCondImpl();
			cond.setPpdid(form.getPpdids()[i]);
			int totalCount = workFlowDefinitionBL.getParticipantDefSearchCount(cond);
			if(totalCount==0){
				throw new BLException("IGPRD0105.E001","״̬�����߲�����");
			}else{
				IG222Info pppd = workFlowDefinitionBL.searchParticipantDefByKey(form.getPpdids()[i]);
				IG273SearchCondImpl ptdsCond = new IG273SearchCondImpl();
				ptdsCond.setFpsdid(pppd.getPsdid());
				List<IG273Info> ptdList = workFlowDefinitionBL.searchProcessTransitionDef(ptdsCond);
				boolean idDel = false;
				if(ptdList!=null&&ptdList.size()>0)
				{
					for(IG273Info ptd:ptdList){
						String ptdcond = ptd.getPtdcond();
						if(ptdcond!=null)
						{
							String[] orcond = ptdcond.split("[|]");
							if(orcond!=null&&orcond.length>0){
								String[] andcond = orcond[0].split("[#]");
								if(andcond!=null&&andcond.length>0){
									for(String andcondi:andcond){
										String[] roids = andcondi.split("[!]");
										if(pppd.getRoleid().toString().equals(roids[0])){
											idDel = true;
										}
									}
								}
							}
						}
					}
				}
				if(!idDel){
					IG222Info ppdInfo = workFlowDefinitionBL.deleteParticipantDefByKey(form.getPpdids()[i]);
					IG298Info psrdInfo = workFlowDefinitionBL.checkProcessStatusRoleDefInfo(ppdInfo.getPsdid(), ppdInfo.getRoleid());
					if(psrdInfo != null) {
						workFlowDefinitionBL.deleteProcessStatusRoleDefInfoByKey(psrdInfo.getPsrdid());
					}
				}else{
					throw new BLException("IGPRD0105.E004","״̬���������й���");
				}
			}
		}
		dto.addMessage(new ActionMessage("IGPRD0107.I002",IGPRDCONSTANTS.PPD_REMOVE_PROCESSPARTICIPANT_MESSAGE));
		log.debug("=============ɾ�������˲�������=============");
		return dto;
	}
	
	/**
	 * ���̻�����Χѡ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO getProcessOrgDefAction(IGPRD01DTO dto) throws BLException {
		log.debug("============���̻�����Χѡ��ҳ���ʼ��������ʼ=============");
		//ҳ����Ϣȡ��
		IGPRD0131Form form = dto.getIgprd0131Form();
		//��ѯ��ѡ�����
		List<IG123Info> pordList = workFlowDefinitionBL.searchProcessOrgScopeByPdid(form.getPdid());
		//��ѡ������Χ��ѯ
		//��ѯ��ѡ�����ļ���
		String orgnatation_level = ResourceUtility.getString("ORGNATATION_LEVEL");
		//�����볤��
		List<Organization> organizationList = this.organizationBL.searchOrganization(new OrganizationSearchCondImpl(),"orgsyscoding");
		Map<String, Organization> orgMap = new HashMap<String, Organization>();
		List<Organization> orgList = new ArrayList<Organization>();
		Map<Organization, List<Organization>> orgtreemap = new LinkedHashMap<Organization, List<Organization>>();
		if(organizationList != null){
			int length = 4 + (Integer.valueOf(orgnatation_level)-1)*3;
			for(Organization org : organizationList){
				if (org.getOrgsyscoding().length() < length) {
					orgMap.put(org.getOrgsyscoding(), org);
				}
				boolean flag = true;
				if(pordList != null){
					for(IG123Info ig123:pordList){
						if(ig123.getOrgid().equals(org.getOrgsyscoding())){
							flag = false;
							break;
						}
					}
				}
				if(org.getOrgsyscoding().length() ==length&&flag){
					orgList.add(org);
				}
			}
		}
		for(Organization org:orgList){
			if(orgtreemap.get(orgMap.get(org.getOrgpar()))==null){
				List<Organization> temp = new ArrayList<Organization>();
				temp.add(org);
				orgtreemap.put(orgMap.get(org.getOrgpar()), temp);
			}else{
				orgtreemap.get(orgMap.get(org.getOrgpar())).add(org);
			}
		}
		dto.setPordList(pordList);
		dto.setOrgTreeMap(orgtreemap);
		log.debug("============���̻�����Χѡ��ҳ���ʼ����������=============");
		return dto;
	}
	
	/**
	 * �Ƴ�������Χ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO removeProcessOrg(IGPRD01DTO dto) throws BLException {
		log.debug("==========�Ƴ�������Χ������ʼ===========");
		//ҳ����Ϣȡ��
		IGPRD0131Form form = dto.getIgprd0131Form();
		if(form.getOrgid_del()!=null&&form.getOrgid_del().length>0){
			List<IG123Info> delList = new ArrayList<IG123Info>();
			for(String id:form.getOrgid_del()){
				IG123TB entity = new IG123TB();
				entity.setPotdid(id);
				delList.add(entity);
			}
			workFlowDefinitionBL.deleteProcessOrgScope(delList);
		}
		log.debug("==========�Ƴ�������Χ��������===========");
		return dto;
	}
	
	/**
	 * ��ӻ�����Χ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO addProcessOrg(IGPRD01DTO dto) throws BLException {
		log.debug("=============��ӻ�����Χ������ʼ=============");
		//ҳ����Ϣȡ��
		IGPRD0131Form form = dto.getIgprd0131Form();
		if(form.getOrgid_add()!=null && form.getOrgid_add().length>0){
			for(String info:form.getOrgid_add()){
				String[] orgInfo = info.split("_");
				IG123TB entity = new IG123TB();
				entity.setOrgid(orgInfo[0]);
				entity.setOrgname(orgInfo[1]);
				entity.setPdid(form.getPdid());
				entity.setPotdid(workFlowDefinitionBL.getProcessOrgScopePK(form.getPdid()));
				workFlowDefinitionBL.registProcessOrgScope(entity);
			}
		}
		log.debug("=============��ӻ�����Χ��������=============");
		return dto;
	}
	//====>130225End
	
	
	/**
	 * ������Ԥ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO searchColumnInfoAction(IGPRD01DTO dto) throws BLException{
		log.debug("===============������Ԥ��������ʼ==============");
		//dto����ȡ��
		IGPRD0173Form form = dto.getIgprd0173Form();
		//��������Ϣ��ѯ
		IG007Info pid = workFlowDefinitionBL.searchProcessInfoDefByKey(form.getPidid());
		dto.setPidInfo(pid);
		//ʵ������ѯ����
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPdid(form.getPdid());
		cond.setTableColumn("Y");
		List<IG007Info> columnList = workFlowDefinitionBL.searchProcessInfoDef(cond);
		if(columnList != null){
			Map<String, List<IG007Info>> columnInfoMap = new HashMap<String, List<IG007Info>>();
			for(IG007Info column:columnList){
				if(columnInfoMap.get(column.getPpidid()) == null){
					List<IG007Info> temp = new ArrayList<IG007Info>();
					temp.add(column);
					columnInfoMap.put(column.getPpidid(), temp);
				}else{
					columnInfoMap.get(column.getPpidid()).add(column);
				}
			}
			dto.setColumnInfoMap(columnInfoMap);
		}
		log.debug("===============������Ԥ����������==============");
		return dto;
	}
	
	/**
	 * ���̲����߱������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO changeProcessParticipants(IGPRD01DTO dto) throws BLException {
		log.debug("=============�����߱��������ʼ=================");
		//dto����ȡ��
		IGPRD0107Form form = dto.getIgPRD0107Form();
		//��ѯ�����̽ڵ��µ����в�������Ϣ
		IG222SearchCondImpl cond = new IG222SearchCondImpl();
		cond.setPsdid(form.getPsdid());
		List<IG222Info> ppdlist = workFlowDefinitionBL.searchParticipantDef(cond);
		String[] ppdids = form.getChange_ppdid();
		String[] userids = form.getUserid();
		Map<String, IG222Info> ppdMap = new HashMap<String, IG222Info>();
		if(ppdlist != null){
			for(IG222Info ppd:ppdlist){
				ppdMap.put(ppd.getPpdid(), ppd);
			}
		}
		if(ppdids != null && ppdids.length > 0){
			for(int i=0;i<ppdids.length;i++){
				IG222Info ppd = ppdMap.get(ppdids[i]);
				String userid = StringUtils.isNotBlank(userids[i]) ? userids[i] : "";
				if(ppd != null){
					if(!userid.equals(ppd.getUserid())){
						IG222TB ppdTB = (IG222TB) SerializationUtils.clone(ppd);
						ppdTB.setUserid(userid);
						workFlowDefinitionBL.updateParticipantDef(ppdTB);
					}
				}
			}
		}
		ppdlist = workFlowDefinitionBL.searchParticipantDef(cond);
		Map<Integer, Map<String, IG222Info>> ppdeMap = new HashMap<Integer, Map<String,IG222Info>>();
		for(IG222Info info:ppdlist){
			String key = StringUtils.isNotEmpty(info.getUserid()) ? info.getUserid() : "NOTHAVEUSER";
			Map<String, IG222Info> map = new HashMap<String, IG222Info>();
			map.put(key, info);
			if(ppdeMap.get(info.getRoleid()) == null){
				ppdeMap.put(info.getRoleid(), map);
			}else{
				if(StringUtils.isEmpty(info.getUserid())){
					if(ppdeMap.get(info.getRoleid()).size() > 0){
						throw new BLException("IGCO00000.E007");
					}
				}else{
					if(ppdeMap.get(info.getRoleid()).get("NOTHAVEUSER") != null){
						throw new BLException("IGCO00000.E007");
					}
					if(ppdeMap.get(info.getRoleid()).get(key) != null){
						throw new BLException("IGCO00000.E007");
					}
				}
				ppdeMap.get(info.getRoleid()).put(key, info);
			}
		}
		
		dto.addMessage(new ActionMessage("IGPRD0107.I003",IGPRDCONSTANTS.PPD_ADD_PROCESSPARTICIPANT_MESSAGE));
		log.debug("=============�����߱����������=================");
		return dto;
	}
	
	/**
	 * ��ѯ����URL
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO searchBackURLAction(IGPRD01DTO dto) throws BLException{
		log.debug("================����URL��ѯ������ʼ================");
		//dto����ȡ��
		IGPRD0110Form form = dto.getIgprd0110Form();
		if(StringUtils.isNotEmpty(form.getPpidid())){
			form.setBackURL("/IGPRD0110.do?pdid=" + form.getPdid() + "&flag=flase&viewhistory=" + form.getViewhistory() + "&tableColumn=N&ppidid=");
			IG007Info ppid = workFlowDefinitionBL.searchProcessInfoDefByKey(form.getPpidid());
			if(ppid != null){
				if(StringUtils.isNotEmpty(ppid.getPpidid())){
					form.setBackURL("/IGPRD0178.do?pdid=" + form.getPdid() + "&flag=flase&viewhistory=" + form.getViewhistory() + "&tableColumn=Y&ppidid=" + ppid.getPpidid());
				}
			}
		}
		log.debug("================����URL��ѯ��������================");
		return dto;
	}
	
	/**
	 * ��ѯ���̲���֪ͨ���ɫ
	 * 
	 * @param dto
	 * @return IGPRD01DTO
	 * @throws BLException
	 */
	public IGPRD01DTO searchRoleByIGBP06Action(IGPRD01DTO dto) throws BLException {
		log.debug("==========��ѯ���̲���֪ͨ���ɫ��ѯҵ���߼�����ʼ==========");
		List<LabelValueBean> lvListRO = new ArrayList<LabelValueBean>();
		// ��ѯ
		RoleSearchCondImpl cond = new RoleSearchCondImpl();
		cond.setRoletype("IGBP06");
		List<Role> roleList = roleBL.searchRole(cond);
		for (Role role : roleList) {
			lvListRO.add(new LabelValueBean(role.getRolename(),role.getRoleid() + ""));
		}
		dto.setLvPsdassignListRO(lvListRO);
		log.debug("==========��ѯ���̲���֪ͨ���ɫ��ѯҵ���߼���������==========");
		return dto;
	}
	
	
	/**
	 * ��ѯ���̲��Դ���Bl����
	 * 
	 * @param dto
	 * @return IGPRD01DTO
	 * @throws BLException
	 */
	public IGPRD01DTO searchProcessBLByIGBP06Action(IGPRD01DTO dto) throws BLException {
		log.debug("==========��ѯ���̲��Դ���Bl�����ѯҵ���߼�����ʼ==========");
		List<LabelValueBean> lvListRO = new ArrayList<LabelValueBean>();
		List<LabelValueBean> lvProcessAllList = new ArrayList<LabelValueBean>();
		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
		cond.setCcid(CodeDefine.getCodeDefine("PROCESSTACTICSBL_STATUS").getCcid());
		// ��ѯ
		List<CodeDetail> codedetailList = codeDetailBL.searchCodeDetail(cond, 0);
		for (CodeDetail cd : codedetailList) {
			lvListRO.add(new LabelValueBean(cd.getCdinfo(), cd.getCvalue()));
		}
		
		cond.setCcid(CodeDefine.getCodeDefine("PROCESSTACTICSBL_ALL").getCcid());
		// ��ѯ
		codedetailList = codeDetailBL.searchCodeDetail(cond, 0);
		for (CodeDetail cd : codedetailList) {
			lvProcessAllList.add(new LabelValueBean(cd.getCdinfo(), cd.getCvalue()));
		}
		
		dto.setProccessBLList(lvListRO);
		dto.setProcesstacticsbl_alllist(lvProcessAllList);
		log.debug("==========��ѯ���̲��Դ���Bl�����ѯҵ���߼���������==========");
		return dto;
	}
	
	/**
	 * ȡ������ģ����Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO searchProcessTemplateAction(IGPRD01DTO dto) throws BLException{
		IG259Info pt = workFlowDefinitionBL.searchProcessTemplateByPrType(dto.getPttype());
		if(pt == null){
			throw new BLException("IGCO10000.E004","����ģ��");
		}
		dto.setProcessTemplate(pt);
		return dto;
	}
	
	/**
	 * ��ѯ���̶�����Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO searchProcessDefinitonsAction(IGPRD01DTO dto) throws BLException {
		log.debug("===============���̶�����Ϣ��ѯ������ʼ=================");
		//dto����ȡ��
		String pdid = dto.getPdid();
		if(StringUtils.isNotEmpty(pdid)){
			IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(pdid);
			List<IG380Info> list = workFlowDefinitionBL.searchProcessDefinitionsByPtid(pd.getPtid());
			List<LabelValueBean> labelList = new ArrayList<LabelValueBean>();
			Set<String> set = new HashSet<String>();
			for(IG380Info info : list){
				String key = info.getPdid().substring(0,5);
				if(!set.contains(key)){
					set.add(key);
					LabelValueBean bean = new LabelValueBean();
					bean.setLabel(info.getPdname());
					bean.setValue(key);
					labelList.add(bean);
				}
			}
			Gson gson = new Gson();
			String json = gson.toJson(labelList);
			dto.setAjaxResult(json);
		}
		log.debug("===============���̶�����Ϣ��ѯ��������=================");
		return dto;
	}
	
	/**
	 * ת�����ַ���
	 * @param str
	 * @return
	 */
	private String nullToString(String str) {
		if (str == null || str.equals("") || str.equals("null") || str.equals("NULL")) {
			str = "";
		}
		return str;
	}
	
    /**
     * @Title: initStatusDefault
     * @Description: ״̬��˽�б�Ĭ��ֵ��ʼ��
     * @param dto
     * @return dto
     * @throws BLException
     * @throws
     */
    public IGPRD01DTO initStatusDefault(IGPRD01DTO dto)throws BLException{
        IGPRD0105Form form = dto.getIgPRD0105Form();
        if(StringUtils.isNotEmpty(form.getPsdid())){
            List<IG560VWInfo> lst=workFlowDefinitionBL.searchIG560VWInfo(form.getPsdid() ,form.getPsdid().substring(0,7));
            dto.setDefaultlist(lst);
        }
        return dto;
    }
    /**
     * ״̬����/�޸�ҳ���޸�״̬��˽�б�ֵ����
     * @param dto.form
     * @return dto
     * @throws BLException
     * @version 1.0
     */
    private IGPRD01DTO updateStatusDefaultValue(IGPRD01DTO dto)throws BLException {
        IGPRD0105Form form = dto.getIgPRD0105Form();
        //���û��״̬��˽�б�ֱ�������ò���
        if(form.getPidids()==null||form.getPidids().length==0){
            return dto;
        }
        IG560SearchCondImpl cond = new IG560SearchCondImpl();
        cond.settOrpsdid(form.getPsdid());
        List<IG560Info> lst=workFlowDefinitionBL.searchIG560TBInfo(cond);
        String[] valueArr=form.getDefvalues();
        //pidid����
        String[] keyArr=form.getPidids();
        List<IG560Info> copyList= new ArrayList<IG560Info>();
        Map<String,IG560Info> map560= new LinkedHashMap<String, IG560Info>();
        for(IG560Info info:lst ){
            if("T".equals(info.getUsedtoall())){
                map560.put(info.getPidid()+"ALL", info);
            }else{
                map560.put(info.getPidid(), info);
            }
        }
        for(int i=0;i<keyArr.length;i++){
            if(StringUtils.isEmpty(valueArr[i])&&map560.get(keyArr[i])==null&&map560.get(keyArr[i]+"ALL")==null){//���Ϊ�ն���ԭ����û�д�Ĭ��ֵ
                continue;
            }
            //��Ҫ�������
            if(map560.get(keyArr[i])!=null&&!valueArr[i].equals(map560.get(keyArr[i]).getDfvalue())){
                IG560TB tb= (IG560TB)SerializationUtils.clone(map560.get(keyArr[i]));
                tb.setDfvalue(valueArr[i]);
                copyList.add(tb);
            }
            //�����Ҫ���� û�иýڵ�ñ���Ĭ��ֵ��������ȫ��Ĭ��ֵ����formֵ����
            if(map560.get(keyArr[i])==null&&
                    (map560.get(keyArr[i]+"ALL")==null||!map560.get(keyArr[i]+"ALL").getDfvalue().equals(valueArr[i])
                    )
              ){
                IG560TB tb= new IG560TB();
                tb.setPidid(keyArr[i]);
                tb.setDfvalue(valueArr[i]);
                tb.setPsdid(form.getPsdid());
                tb.setUsedtoall("F");
                copyList.add(tb);
            }
        }
        if(copyList.size()>0){
            this.workFlowDefinitionBL.saveStatusDefaultList(copyList);
        }
        return dto;
    }
    
    /**
	 * ���̲�ѯ��ʾ�ж����ʼ������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO initProcessQueryShowColumnAction(IGPRD01DTO dto) throws BLException {
		log.debug("==============���̲�ѯ��ʾ�ж����ʼ��������ʼ==============");
		if(dto.getForm() != null && dto.getForm() instanceof IGPRD0146Form){
			IGPRD0146Form form = (IGPRD0146Form) dto.getForm();
			List<IG110Info> pqList = workFlowDefinitionBL.searchProcessQueryShowColumnByPdid(form.getPdid());
			dto.setQueryShowColumnList(pqList);
		}
		log.debug("==============���̲�ѯ��ʾ�ж����ʼ����������==============");
		return dto;
	}
	
	/**
	 * ���̲�ѯ�����п�ȵ���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO editProcessQueryShowColumnWidthAction(IGPRD01DTO dto) throws BLException {
		log.debug("==============���̲�ѯ�����п�ȵ�����ʼ==============");
		if(dto.getForm() != null && dto.getForm() instanceof IGPRD0146Form){
			IGPRD0146Form form = (IGPRD0146Form) dto.getForm();
			List<IG110Info> psList = workFlowDefinitionBL.searchProcessQueryShowColumnByPdid(form.getPdid());
			Map<String, IG110TB> map = new HashMap<String, IG110TB>();
			for(IG110Info info:psList){
				map.put(info.getSid(), ((IG110TB)info));
			}
			if(form.getSid() != null){
				for(int i=0;i<form.getSid().length;i++){
					IG110TB tb = map.get(form.getSid()[i]);
					tb.setWidth(form.getColumnWidth()[i]);
					workFlowDefinitionBL.updateProcessQueryShowColumn(tb);
				}
			}
		}
		log.debug("==============���̲�ѯ�����п�ȵ�������==============");
		return dto;
	}
	
	/**
	 * ��������������ı༭���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public IGPRD01DTO updFlowXML(IGPRD01DTO dto)throws BLException{
		
		String xml = dto.getIgprd0190Form().getUpdXML();
		
		Document doc = null;
		
		StringBuffer resultXML = new StringBuffer("<root  code = '0'>");
		
		try{
			doc = DocumentHelper.parseText(xml); 
			 Element rootElt = doc.getRootElement(); // ��ȡ���ڵ�
			 //����״̬�ڵ����б䶯����Ϣ
			a: for(Iterator<Element> it = rootElt.elementIterator("bean");it.hasNext();){
				 
				 Element el = it.next();
				 //��ȡ��Ӧ�ı���
				 String tableName = el.attributeValue("table");
				 
				 
				//���ݱ�������ʵ��
				 Class tbClass = Class.forName("com.deliverik.framework.workflow.prd.model.entity."+tableName+"TB");
				 //��ʵ�帳ֵ
				 BaseModel tb = (BaseModel)tbClass.newInstance();
				 
				 this.parseInfo(el, tb,tbClass);
				 
				 BaseHibernateDAO<BaseModel> dao = (BaseHibernateDAO<BaseModel>) WebApplicationSupport.getBean(tableName.toLowerCase()+"DAO");
				
				 //IG380 ��Ҫ���⴦�� ����XML
				 if("IG380".equals(tableName)){
					 IG380Info newPdInfo = (IG380Info)tb;
					 IG380TB ig380 = (IG380TB) workFlowDefinitionBL.searchProcessDefinitionByKey(newPdInfo.getPdid());
					 ig380.setPdxml(newPdInfo.getPdxml());
//						 dao.save(ig380);
					 workFlowDefinitionBL.updateProcessDefinition(ig380);
					 continue;
				 }
				 
				 Serializable pk = null;
				 //��ȡʵ���Ӧ��DAO
				 
				 //�ж���ɾ�����Ǳ���
				 if(IGPRDCONSTANTS.PD_ACTTYPE_DELETE.equals(el.attributeValue("activeType"))){
					 dao.delete(tb);
				 }else{
					 
					 //�ж������Ƿ�Ϊ��,���Ϊ���� �������dao���ȡ�����ķ���
					 
					Field[] fields = tb.getClass().getDeclaredFields();
					b: for(Field f:fields){
						 Id idFlag = f.getAnnotation(Id.class);
						 if(idFlag != null){
							 f.setAccessible(true);
							 if(isNull(f.get(tb))){
								 Method[] methods = dao.getClass().getDeclaredMethods();
								 for(Method m:methods){
									 IdGeneratorMethod idGeneratorMethodFlag = m.getAnnotation(IdGeneratorMethod.class);
									 if(idGeneratorMethodFlag != null){
										 String paramName = idGeneratorMethodFlag.value();
										 Field paramField = tb.getClass().getDeclaredField(paramName);
										 paramField.setAccessible(true);
										 Object param = paramField.get(tb);
										 m.setAccessible(true);
										 Object idValue = m.invoke(dao, param);
										 f.set(tb, idValue);
										 resultXML.append("<"+el.attributeValue("key")+">"+idValue.toString()+"</"+el.attributeValue("key")+">");
										 break;
									 }
								 }
								 if(isNull(f.get(tb))){
									 continue a;
								 }
								 break b;
							 }else{
								 
								 pk = (Serializable)f.get(tb);
								 break b;
							 }
						 }
					 }
					 
					 //���²�ѯԭ����������ʱ�丳���¶��� , �������У�����(IGCO0000.E0004)
					 if(pk!=null){
						 BaseEntity entity = (BaseEntity)tb;
						 BaseModel oldModel = dao.findByPK(entity.getPK());
//						 if(oldModel!= null){
//							 entity.setLastupdatetime(oldModel.getLastupdatetime());
//							 entity.setInitcreatetime(oldModel.getInitcreatetime());
//						 }
					 }
					 dao.save(tb);
				 }
			 }
			
		}catch(BLException e){
			e.printStackTrace();
			 throw e;
		} catch (DocumentException e) {
			e.printStackTrace();
			throw new BLException("IGCO10000.E141", "XML��������");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new BLException("IGCO10000.E141","�Ҳ�����Ӧʵ��");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new BLException("IGCO10000.E141","����ʵ�����");
		} catch (SecurityException e) {
			e.printStackTrace();
			throw new BLException("IGCO10000.E141","����ʵ�����");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new BLException("IGCO10000.E141","����ʵ�����");
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
			throw new BLException("IGCO10000.E141","����ʵ�����");
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}  catch (Exception e){
			throw new BLException("IGCO10000.E141","δ֪����");
		}
		resultXML.append("</root>");
		
		dto.getIgprd0190Form().setResultXMl(resultXML.toString());
		
		return dto;
	}

private boolean isNull(Object obj) {
		if(obj == null){
			return true;
		}else if(obj instanceof String && "".equals(obj)){
			return true;
		}
		else if(obj instanceof Integer && (Integer) obj == 0){
			return true;
		}
		return false;
	}
	
	protected IG900BL ig900BL;
	public void setIg900BL(IG900BL ig900bl) {
		ig900BL = ig900bl;
	}

	/**
	 * ���������������ʼ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO initFlowXML(IGPRD01DTO dto)throws BLException{
		IGPRD0190Form form = dto.getIgprd0190Form();
		
		StringBuffer xml = generateProcessDefXML(form.getPdid());
		
		List<IG900Info> ig900List =  ig900BL.searchIG900Info();
		
		StringBuffer ig900XML = new StringBuffer();
		
		ig900XML.append("<IG900><DATALIST>");
		for (IG900Info ig900Info : ig900List) {
			
			//���˸��º���ֹ��ť
			if("����".equals(ig900Info.getPbdname())||"��ֹ".equals(ig900Info.getPbdname()))
				continue;
			
			ig900XML.append("<DATA>");
			ig900XML.append("<PBDID>"+nullToEmpty(ig900Info.getPbdid())+"</PBDID>");
			ig900XML.append("<PBDNAME>"+nullToEmpty(ig900Info.getPbdname())+"</PBDNAME>");
//			ig900XML.append("<INITCREATETIME>"+nullToEmpty(ig900Info.getInitcreatetime())+"</INITCREATETIME>");
//  		ig900XML.append("<LASTUPDATETIME>"+nullToEmpty(ig900Info.getLastupdatetime())+"</LASTUPDATETIME>");
			ig900XML.append("<PBDFLAG>"+nullToEmpty(ig900Info.getPbdflag())+"</PBDFLAG>");
			ig900XML.append("<PBDIMAGE>"+nullToEmpty(ig900Info.getPbdimage())+"</PBDIMAGE>");
			ig900XML.append("</DATA>");
		}
		ig900XML.append("</DATALIST></IG900>");
		
		xml.insert(xml.length()-10, ig900XML.toString());
		
		form.setInitXML(xml.toString());
		
		return dto;
	}
	
	private StringBuffer generateProcessDefXML(String pdid) throws BLException {
		String sbf = workFlowDefinitionBL.exportXML(pdid);
		//ȡ�ñ�����Ϣ
		//1.��ɫ������Ϣ
		List<Integer> roleids = new ArrayList<Integer>();
		String roleid_regex = "&roleid_.*?;";
		Pattern roleid_pattern = Pattern.compile(roleid_regex);
		Matcher roleid_matcher = roleid_pattern.matcher(sbf);
		while(roleid_matcher.find()){
			String group = roleid_matcher.group();
			Integer roleid = Integer.valueOf(group.substring(group.indexOf("_") + 1,group.length() - 1));
			if(!roleids.contains(roleid)){
				roleids.add(roleid);
			}
		}
		//2.����������Ϣ
		List<String> orgids = new ArrayList<String>();
		String orgid_regex = "&orgid_.*?;";
		Pattern orgid_pattern = Pattern.compile(orgid_regex);
		Matcher orgid_matcher = orgid_pattern.matcher(sbf);
		while(orgid_matcher.find()){
			String group = orgid_matcher.group();
			String orgid = group.substring(group.indexOf("_") + 1,group.length() - 1);
			if(!orgids.contains(orgid)){
				orgids.add(orgid);
			}
		}
		//3.�û�������Ϣ
		List<String> userids = new ArrayList<String>();
		String userid_regex = "&userid_.*?;";
		Pattern userid_pattern = Pattern.compile(userid_regex);
		Matcher userid_matcher = userid_pattern.matcher(sbf);
		while(userid_matcher.find()){
			String group = userid_matcher.group();
			String userid = group.substring(group.indexOf("_") + 1,group.length() - 1);
			if(!userids.contains(userid)){
				userids.add(userid);
			}
		}
		StringBuffer xml = new StringBuffer();
		//���ɱ���
		xml.append("<!DOCTYPE VARIABLE[");
		for(Integer roleid:roleids){
			xml.append("<!ENTITY roleid_").append(roleid).append(" \"").append(roleid).append("\">");
		}
		for(String orgid:orgids){
			xml.append("<!ENTITY orgid_").append(orgid).append(" \"").append(orgid).append("\">");
		}
		for(String userid:userids){
			xml.append("<!ENTITY userid_").append(userid).append(" \"").append(userid).append("\">");
		}
		xml.append("]>");
		xml.append("<Process PDID=\"").append(pdid).append("\">");
		//����У����Ϣ
		xml.append("<CHECKINFO>");
		xml.append("<ROLEINFO>");
		if(roleids.size() > 0){
			RoleSearchCondImpl rolecond = new RoleSearchCondImpl();
			rolecond.setRoleid_in(roleids);
			List<Role> roleList = roleBL.searchRole(rolecond);
			for(Role role:roleList){
				xml.append("<DATA>");
				xml.append("<ROLEID>");
				xml.append("&roleid_" + role.getRoleid() + ";");
				xml.append("</ROLEID>");
				xml.append("<ROLENAME>");
				xml.append(role.getRolename());
				xml.append("</ROLENAME>");
				xml.append("</DATA>");
			}
		}
		xml.append("</ROLEINFO>");
		xml.append("<ORGINFO>");
		if(orgids.size() > 0){
			OrganizationSearchCondImpl orgcond = new OrganizationSearchCondImpl();
			orgcond.setSyscoding_area(orgids);
			List<Organization> organizationList = organizationBL.searchOrganization(orgcond);
			for(Organization org : organizationList){
				xml.append("<DATA>");
				xml.append("<ORGID>");
				xml.append("&orgid_" + org.getOrgsyscoding() + ";");
				xml.append("</ORGID>");
				xml.append("<ORGNAME>");
				xml.append(org.getOrgname());
				xml.append("</ORGNAME>");
				xml.append("</DATA>");
			}
		}
		xml.append("</ORGINFO>");
		xml.append("<USERINFO>");
		if(userids.size() > 0){
			UserSearchCondImpl usercond = new UserSearchCondImpl();
			usercond.setUserid_in(userids);
			List<User> userList = userBL.searchUser(usercond);
			for(User user:userList){
				
				
				xml.append("<DATA>");
				xml.append("<USERID>");
				xml.append("&userid_" + user.getUserid() + ";");
				xml.append("</USERID>");
				xml.append("<USERNAME>");
				xml.append(user.getUsername());
				xml.append("</USERNAME>");
				xml.append("</DATA>");
			}
		}
		xml.append("</USERINFO>");
		xml.append("</CHECKINFO>");
		xml.append(sbf);
		xml.append("</Process>");
		return xml;
	}
	/**
	 * ��������ͼxml
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	
	public IGPRD01DTO savePdXML(IGPRD01DTO dto)throws BLException{
		
		log.debug("==========��������ͼXML��ʼ============");
		
		IGPRD0190Form form = dto.getIgprd0190Form();
		
		String pdXML = form.getPdXML();
		
		IG380TB ig380Tb = (IG380TB)workFlowDefinitionBL.searchProcessDefinitionByKey(form.getPdid());
		
		ig380Tb.setPdxml(pdXML);
		
		workFlowDefinitionBL.updateProcessDefinition(ig380Tb);
		
		log.debug("==========��������ͼXML���============");
		
		return dto;
	}
	/**
	 * ��XML������java����
	 * @param e
	 * @param o
	 * @throws BLException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void parseInfo(Element e,Object o,Class c) throws BLException{
		Class<? extends Object> clz = null;
		if(c == null){
			 clz = o.getClass();
		}else{
			clz = c;
		}
		//baseAction ����
		Field[] superFields = clz.getSuperclass().getDeclaredFields();
		//��ǰ���е�����
		Field[] fields = Arrays.copyOf(clz.getDeclaredFields(), clz.getDeclaredFields().length+superFields.length);
		//�������е�������ӵ����������� ����������  ���������鿪ʼ���� ������������ ����������ŵ�λ��  ����������ĳ���
		System.arraycopy(superFields, 0, fields, fields.length-superFields.length, superFields.length);
		
		for(Field f:fields){
			f.setAccessible(true);
			String ev = e.attributeValue(f.getName());
			ev = nullToEmpty(ev).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
			String type = f.getType().toString();
			Object value = null;
			try{
				if(type.endsWith("java.lang.String")){
					value = ev;
				}else if(type.endsWith("java.lang.Integer")){
					if(!"".equals(ev)){
						value = Integer.valueOf(ev);
					}
				}else if(type.endsWith("java.lang.Double")){
					value = Double.valueOf(ev);
				}
				f.set(o, value);
			}catch (Exception ex) {
				log.error("",ex);
			}
		}
		
	}
	/**
	 * null->""
	 * @param String 
	 * @return
	 * @throws BLException
	 */
	public String nullToEmpty(String str) throws BLException{
		if(null==str){
			str = "";
		}	
		return str;
	}

	/**
	 * ��ѯ���̲�����xml �����������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO searchUserRoleInfoForPDeg(IGPRD01DTO dto) throws BLException{
		
		log.debug("=================��ѯ���̲����˿�ʼ==================");
		
		List<UserRoleInfo> userRoleList = userRoleBL.findByPdid(dto.getIgprd0190Form().getPdid());
		
		StringBuffer xml = new StringBuffer("<root>");
		
		String tempRoleType = null;
		Integer tempRoleId = null;
		
		for (UserRoleInfo userRole : userRoleList) {
			
			if(tempRoleType == null && tempRoleId == null){
				xml.append("<team roletype=\""+userRole.getRoletype().split("_")[0]+"\" teamName=\""+userRole.getRoletype().split("_")[1]+"\">");
				tempRoleType = userRole.getRoletype();
				xml.append("<role roleId=\""+userRole.getRoleid()+"\" roleName=\""+userRole.getRolename()+"\">");
				tempRoleId = userRole.getRoleid();
			}else{
				if(!userRole.getRoleid().equals(tempRoleId)){
					
					xml.append("</role>");
					if(!userRole.getRoletype().equals(tempRoleType)){
						xml.append("</team>");
						xml.append("<team roletype=\""+userRole.getRoletype().split("_")[0]+"\" teamName=\""+userRole.getRoletype().split("_")[1]+"\">");
						tempRoleType = userRole.getRoletype();
					}
					xml.append("<role roleId=\""+userRole.getRoleid()+"\" roleName=\""+userRole.getRolename()+"\">");
					tempRoleId = userRole.getRoleid();
				}
				
			}
			xml.append(" <user userId=\""+userRole.getUserid()+"\" userName=\""+userRole.getUsername()+"\" userOrgId = \""+userRole.getOrgid()+"\" userOrg=\""+userRole.getOrgname()+"\" />");
		}
		
		if(userRoleList.size()>0){
			xml.append("</role></team>");
		}
		xml.append("</root>");
		
		dto.getIgprd0190Form().setUserRoleXML(xml.toString());
		
		log.debug("=================��ѯ���̲����˽���==================");
		
		return dto;
	}

	/**
     * ȱʡȨ�޵���ط�������̶�����Ϣ��ѯ����
     *
     * @param dto IGPRD01DTO
     * @return IGPRD01DTO
     */
    public String searchProcessDefinitionList(IGPRD01DTO dto) throws BLException {
        log.debug("========ȱʡȨ�޵���ط�������̶�����Ϣ��ѯ����ʼ========");
        StringBuffer flowXml = new StringBuffer();
        IGPRD0190Form form = dto.getIgprd0190Form();
		
        IG913SearchCondImpl cond = new IG913SearchCondImpl();
        cond.setPdid(form.getPdid());
//        cond.setPsdid(dto.getIgPRD0116Form().getPsdid());
        
        // ��ط����Զ�������������Ϣȡ��
        List<IG913Info> flowList = workFlowDefinitionBL.searchLastIG380AndIG931Info(cond);
        flowXml.append("<flowList>");
        for(IG913Info info:flowList){
        	flowXml.append("<flow pdid=\""+info.getPdid()+"\" pdname=\""+info.getPdname()+"\" />");
        }
        flowXml.append("</flowList>");
        
        log.debug("========ȱʡȨ�޵���ط�������̶�����Ϣ��ѯ��������========");
        return flowXml.toString();
    }

    /**
	 * �������̲�ѯ�趨����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD01DTO changeProcessQueryAction(IGPRD01DTO dto) throws BLException {
		log.debug("============�������̲�ѯ�趨������ʼ=============");
		if(dto.getForm() != null && dto.getForm() instanceof IGPRD0145Form){
			IGPRD0145Form form = (IGPRD0145Form) dto.getForm();
			//���̶���ID
			String pdid = form.getPdid();

			workFlowDefinitionBL.deleteProcessQueryShowColumnByPdid(pdid);
			workFlowDefinitionBL.deleteProcessQueryByPdid(pdid);
			if(form.getProcessQueryShowColumns() != null){
				for(String info:form.getProcessQueryShowColumns()){
					String[] split = info.split("#");
					String type = split[0];
					String flag = split[1];
					String name = split[2];
					Integer width = Integer.valueOf(split[3]);
					IG110TB entity = new IG110TB();
					entity.setPdid(pdid);
					entity.setSflag(flag);
					entity.setStype(type);
					entity.setSname(name);
					entity.setWidth(width);
					entity.setSid(workFlowDefinitionBL.getProcessQueryShowColumnNextId(pdid));
					workFlowDefinitionBL.registProcessQueryShowColumn(entity);
				}
			}
			if(form.getProcessQuerys() != null){
				for(String info : form.getProcessQuerys()){
					IG111TB entity = new IG111TB();
					String[] split = info.split("#");
					String type = split[0];
					String flag = split[1];
					String name = split[2];
					entity.setPdid(pdid);
					entity.setQflag(flag);
					entity.setQtype(type);
					entity.setQname(name);
					entity.setQmode(getQmode(type,flag));
					entity.setQid(workFlowDefinitionBL.getProcessQueryNextId(pdid));
					workFlowDefinitionBL.registProcessQuery(entity);
				}
			}
		}
		log.debug("============�������̲�ѯ�趨��������=============");
		return dto;
	}
	private String getQmode(String type, String pidid) throws BLException{
		String mode = "like";
		if("pi".equals(type)){
			IG007Info pid = workFlowDefinitionBL.searchProcessInfoDefByKey(pidid);
			if("2".equals(pid.getPidtype())
					|| "7".equals(pid.getPidtype())
					|| "B".equals(pid.getPidtype())
					|| "R".equals(pid.getPidtype())){
				mode = "eq";
			}else if("A".equals(pid.getPidtype())
					|| "3".equals(pid.getPidtype())){
				mode = "bt";
			}else if("G".equals(pid.getPidtype())
					|| "T".equals(pid.getPidtype())){
				mode = "sl";
			}
		}else{
			if(pidid.equals("propentime") || pidid.equals("prclosetime")){
				mode = "bt";
			}else if("prstatus".equals(pidid)){
				mode = "eq";
			}
		}
		return mode;
	}
}