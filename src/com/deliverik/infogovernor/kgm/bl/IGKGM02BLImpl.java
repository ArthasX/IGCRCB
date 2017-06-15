/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.bl;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
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

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.bl.CodeCategoryBL;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.CodeDetailDefBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.CodeDetailDef;
import com.deliverik.framework.model.condition.CodeDetailDefSearchCondImpl;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.model.entity.AttachmentTB;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.condition.RoleSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleSearchCondImpl;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.html.ExportHtml;
import com.deliverik.infogovernor.kgm.bl.task.KnowLedgeInfoBL;
import com.deliverik.infogovernor.kgm.bl.task.KnowLogBL;
import com.deliverik.infogovernor.kgm.bl.task.KnowledgeAppImpactBL;
import com.deliverik.infogovernor.kgm.bl.task.KnowledgeBL;
import com.deliverik.infogovernor.kgm.bl.task.KnowledgeGradeBL;
import com.deliverik.infogovernor.kgm.bl.task.KnowledgeProcessBL;
import com.deliverik.infogovernor.kgm.bl.task.KnowledgeStatisticsBL;
import com.deliverik.infogovernor.kgm.dto.IGKGM02DTO;
import com.deliverik.infogovernor.kgm.dto.IGKGM03DTO;
import com.deliverik.infogovernor.kgm.form.IGKGM0201Form;
import com.deliverik.infogovernor.kgm.form.IGKGM0203Form;
import com.deliverik.infogovernor.kgm.form.IGKGM0207Form;
import com.deliverik.infogovernor.kgm.form.IGKGM0208Form;
import com.deliverik.infogovernor.kgm.form.IGKGM0216Form;
import com.deliverik.infogovernor.kgm.form.IGKGM0228Form;
import com.deliverik.infogovernor.kgm.form.IGKGM0231Form;
import com.deliverik.infogovernor.kgm.model.KnowLedgeInfo;
import com.deliverik.infogovernor.kgm.model.KnowLogInfo;
import com.deliverik.infogovernor.kgm.model.Knowledge;
import com.deliverik.infogovernor.kgm.model.KnowledgeAppImpact;
import com.deliverik.infogovernor.kgm.model.KnowledgeGrade;
import com.deliverik.infogovernor.kgm.model.KnowledgeProcess;
import com.deliverik.infogovernor.kgm.model.KnowledgeStatisticsInfo;
import com.deliverik.infogovernor.kgm.model.condition.KnowLogSearchCond;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeAppImpactSearchCondImpl;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeGradeSearchCondImpl;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeSearchCondImpl;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeStatisticsSearchCondImpl;
import com.deliverik.infogovernor.kgm.model.entity.KnowLedgeInfoVW;
import com.deliverik.infogovernor.kgm.model.entity.KnowledgeAppImpactTB;
import com.deliverik.infogovernor.kgm.model.entity.KnowledgeTB;
import com.deliverik.infogovernor.kgm.model.entity.KnowledgeTBPK;
import com.deliverik.infogovernor.kgm.vo.IGKGM02052VO;
import com.deliverik.infogovernor.util.CodeDefine;




/**
 * ����: ֪ʶ����ҵ���߼�BLʵ����
 * ����������֪ʶ����ҵ���߼�BLʵ����
 * �޸ļ�¼��
 */
public class IGKGM02BLImpl extends BaseBLImpl implements IGKGM02BL {


	static Log log = LogFactory.getLog(IGKGM02BLImpl.class);
	
	/**֪ʶ���ѯBL */
	protected KnowLedgeInfoBL knowLedgeInfoBL;
	
	/**֪ʶ������BL*/
	protected KnowledgeBL knowledgeBL;
	
	/** ���ݷ�����ϢBL */
	protected CodeCategoryBL codeCategoryBL;
	
	
	/**֪ʶ������BL*/
	protected KnowledgeGradeBL knowledgeGradeBL;
	
	/**֪ʶ�����̹���BL*/
	protected KnowledgeProcessBL knowledgeProcessBL;
	
	/**����BL*/
	protected AttachmentBL attachmentBL;
	
	/**�����ϴ�BL*/
	protected FileUploadBL fileUploadBL;
	
	/** ����������ϢBL */
	protected CodeListUtils codeListUtils;
	
	/** ֪ʶ��ҵ��ϵͳBL */
	protected KnowledgeAppImpactBL knowledgeAppImpactBL;
	
	/** ����BL */
	protected IG500BL ig500BL;
	
	/** ��������BL */
	protected IG599BL ig599BL;
	
	/**��ɫ��Ϣҵ��BL*/
	protected RoleBL roleBL;
	/**�û���ɫBL*/
	protected UserRoleBL userRoleBL;
	
	/**֪ʶ��־BL*/
	protected KnowLogBL knowLogBL;
	
	/**֪ʶ��ͳ��BL*/
	protected KnowledgeStatisticsBL knowledgeStatisticsBL;
	
	/**���ݶ�������BL*/
	protected CodeDetailDefBL codeDetailDefBL;

	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	/**
	 * ��ɫ��Ϣҵ��BL�趨
	 * @param roleBL ��ɫ��Ϣҵ��BL
	 */
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}

	/**
	 * ��������BL�趨
	 * @param ig599BL ��������BL
	 */
	public void setIg599BL(IG599BL ig599BL) {
		this.ig599BL = ig599BL;
	}

	/**
	 * ֪ʶ��ҵ��ϵͳBL�趨
	 * 
	 * @param knowledgeAppImpactBL ֪ʶ��ҵ��ϵͳBL
	 */
	public void setKnowledgeAppImpactBL(KnowledgeAppImpactBL knowledgeAppImpactBL) {
		this.knowledgeAppImpactBL = knowledgeAppImpactBL;
	}

	/**
	 * ����������ϢBL�趨
	 * 
	 * @param codeListUtils����������ϢBL
	 */
	public void setCodeListUtils(CodeListUtils codeListUtils) {
		this.codeListUtils = codeListUtils;
	}
	
	/**
	 * �����ϴ�BL�趨
	 * @param fileUploadBL�����ϴ�BL
	 */
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}

	/**
	 * ����BL�趨
	 * @param attachmentBL����BL
	 */
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}


	/**
	 * ֪ʶ�����̹���BL�趨
	 * @param knowledgeProcessBL֪ʶ�����̹���BL
	 */
	public void setKnowledgeProcessBL(KnowledgeProcessBL knowledgeProcessBL) {
		this.knowledgeProcessBL = knowledgeProcessBL;
	}

	/**
	 * ֪ʶ������BL�趨
	 * @param knowledgeGradeBL ֪ʶ������BL
	 */
	public void setKnowledgeGradeBL(KnowledgeGradeBL knowledgeGradeBL) {
		this.knowledgeGradeBL = knowledgeGradeBL;
	}
	/**
	 * ֪ʶ���ѯBL�趨
	 * @param knowLedgeInfoBL ֪ʶ���ѯBL
	 */
	public void setKnowLedgeInfoBL(KnowLedgeInfoBL knowLedgeInfoBL) {
		this.knowLedgeInfoBL = knowLedgeInfoBL;
	}
	
	/**
	 * ֪ʶ��ͳ��BL�趨
	 * @param knowledgeStatisticsBL ֪ʶ��ͳ��BL
	 */
	public void setKnowledgeStatisticsBL(KnowledgeStatisticsBL knowledgeStatisticsBL) {
		this.knowledgeStatisticsBL = knowledgeStatisticsBL;
	}

	/**
	 * ֪ʶ��ѯ
	 */
	public IGKGM02DTO searchKnowLedgeInfoAction(IGKGM02DTO dto)
			throws BLException {
		
		return dto;
	}

	/**
	 * ֪ʶ��Ǽ�BL�趨
	 * @param knowLedgeBL ֪ʶ��Ǽ�BL
	 */
	public void setKnowledgeBL(KnowledgeBL knowledgeBL) {
		this.knowledgeBL = knowledgeBL;
	}

	/**
	 * ֪ʶ�Ǽǻ�ȡ
	 * @return knowledgeBL֪ʶ�Ǽ�
	 */
	public KnowledgeBL getKnowledgeBL() {
		return this.knowledgeBL;
	}
	
	/**
	 * ����BL�趨
	 * @param ig500BL ֪ʶ��Ǽ�BL
	 */
	public void setIg500BL(IG500BL ig500BL) {
		this.ig500BL = ig500BL;
	}

	/**
	 * ����BL��ȡ
	 * @return processRecordBL����BL
	 */
	public IG500BL getProcessRecordBL() {
		return this.ig500BL;
	}
	
	public void setCodeDetailDefBL(CodeDetailDefBL codeDetailDefBL) {
		this.codeDetailDefBL = codeDetailDefBL;
	}
	
	//-----------------------------------------------------------�κ���----------------------------------------------------------------------
	

	/**
	 * ���ܣ�֪ʶ����(��ѯ)
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO searchKnowLedgeAction(IGKGM03DTO dto) throws BLException {

		log.debug("========֪ʶ��������ʼ========");
		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		
		List<Knowledge> knowledgeList = new ArrayList<Knowledge>();//ҳ����ʾ����
		
		boolean spgl = dto.getKnowledgeSearchCond() instanceof IGKGM0208Form;
		
		if(spgl){
			//��֪ʶ�����˹���leexuzhi
			dto = this.getRoleKnApproveRole(dto);//ȡ��֪ʶ�����˽�ɫ
			IGKGM0208Form kdcond = (IGKGM0208Form) dto.getKnowledgeSearchCond();
			boolean qx = false;//�Ƿ���֪ʶ������Ȩ��
			List<Role> roleList = dto.getRoleList();
			Integer[] kars = null;
			if(roleList!=null&&roleList.size()>0){
				kars = new Integer[roleList.size()];
				
				for(int i=0;i<roleList.size();i++){
					Role role = roleList.get(i);
					User user = dto.getUser();
					UserRoleSearchCondImpl urcond = new UserRoleSearchCondImpl();
					urcond.setUserid(user.getUserid());
					urcond.setRoleid(role.getRoleid());
					List<UserRole> urList = userRoleBL.searchUserRole(urcond);
					if(urList!=null&&urList.size()>0){
						kars[i]=role.getRoleid();
						qx = true;
					}
				}
				
			}
			
			int totalCount = 0;
			
			if(qx){
				kdcond.setKnapproveroles(kars);
				totalCount = this.knowledgeBL.getSearchCount(kdcond);
			}
			
			if (totalCount == 0) {

				log.debug("========֪ʶ�������ݲ�����========");
				// ֪ʶ����������ݲ�����
				dto.addMessage(new ActionMessage("IGCO10000.I002", 0));

				return dto;
			}

			if (totalCount > dto.getMaxSearchCount()) {

				log.debug("========֪ʶ�������ݼ�������========");
				// ֪ʶ����������ݼ�������
				dto.addMessage(new ActionMessage("IGCO00000.E005", dto
						.getMaxSearchCount(), totalCount));

				return dto;
			}
			
			if(qx){
				knowledgeList = knowledgeBL.searchKnowledgeByCond(kdcond, pDto.getFromCount(), pDto.getPageDispCount());
			}
			
			dto.setKnowledgeList(knowledgeList);
			pDto.setTotalCount(totalCount);
			
			dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		}else{
			int totalCount  = this.knowledgeBL.getSearchCount(dto.getKnowledgeSearchCond());
			
			if (totalCount == 0) {

				log.debug("========֪ʶ�������ݲ�����========");
				// ֪ʶ����������ݲ�����
				dto.addMessage(new ActionMessage("IGCO10000.I002", 0));

				return dto;
			}

			if (totalCount > dto.getMaxSearchCount()) {

				log.debug("========֪ʶ�������ݼ�������========");
				// ֪ʶ����������ݼ�������
				dto.addMessage(new ActionMessage("IGCO00000.E005", dto
						.getMaxSearchCount(), totalCount));

				return dto;
			}
			
			knowledgeList = knowledgeBL.searchKnowledgeByCond(dto.getKnowledgeSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
			
			
			dto.setKnowledgeList(knowledgeList);
			pDto.setTotalCount(totalCount);
			
			dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		}
		
		

		

		log.debug("========֪ʶ������������========");

		return dto;
	}
	
	/**
	 * ���ܣ�����֪ʶ״̬
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO updateKnowLedgeStatus(IGKGM03DTO dto) throws BLException {

		String[] knids = dto.getKnids();
		String[] knrejects = dto.getKnrejects();
		String[] knversions = dto.getKnversions();
		KnowledgeTB tb = new KnowledgeTB();

		for (int i = 0; i < knids.length; i++) {
			
			//���ʱ�����Ƚ�����֪ʶ״̬��Ϊɾ��
			if(IGKGMCONSTANTS.KNOWLEDGE_APPROVEED.equals(dto.getKnstatus()) && Integer.valueOf(knversions[i])>1){
				//���µ��ڰ汾
				KnowledgeSearchCondImpl searchCon = new KnowledgeSearchCondImpl();
				searchCon.setKnid(Integer.valueOf(knids[i]));
				searchCon.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_APPROVEED);
				Knowledge knowledgeNow = this.knowledgeBL.searchKnowledgeByByKnid(searchCon);
				if(knowledgeNow !=null){
					KnowledgeTB knowledgeNowTB = (KnowledgeTB)SerializationUtils.clone(knowledgeNow);
					knowledgeNowTB.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_DELETE);
					this.knowledgeBL.updateKnowledge(knowledgeNowTB);
				}
			}
			
			
			//���»򲵻ش�����֪ʶ״̬���¡�
			KnowledgeTBPK pk = new KnowledgeTBPK(Integer.valueOf(knids[i]),Integer.valueOf(knversions[i]));
			Knowledge knowledge = this.knowledgeBL.searchKnowledgeByPK(pk);
			tb = (KnowledgeTB)SerializationUtils.clone(knowledge);
			tb.setKnstatus(dto.getKnstatus());
			if(IGKGMCONSTANTS.KNOWLEDGE_REJECT.equals(dto.getKnstatus())){//��д����ԭ��
				tb.setKnreject(knrejects[i]);
			}
			tb.setKnapprover(dto.getUser().getUserid());
			tb.setKnapprovername(dto.getUser().getUsername());
			tb.setKnapprovetime(IGStringUtils.getCurrentDateTime());

			this.knowledgeBL.updateKnowledge(tb);
			
		}

		return dto;
	}
	
	/**
	 * ���ܣ�����֪ʶ״̬
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO updateOneKnowLedgeStatus(IGKGM03DTO dto) throws BLException {

		KnowledgeTB tb = new KnowledgeTB();

		//���ʱ�����Ƚ�����֪ʶ״̬��Ϊɾ��
		if(IGKGMCONSTANTS.KNOWLEDGE_APPROVEED.equals(dto.getKnstatus()) && Integer.valueOf(dto.getKnversion())>1){
			//���µ��ڰ汾
			KnowledgeSearchCondImpl searchCon = new KnowledgeSearchCondImpl();
			searchCon.setKnid(Integer.valueOf(dto.getKnid()));
			searchCon.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_APPROVEED);
			Knowledge knowledgeNow = this.knowledgeBL.searchKnowledgeByByKnid(searchCon);
			if(knowledgeNow !=null){
				KnowledgeTB knowledgeNowTB = (KnowledgeTB)SerializationUtils.clone(knowledgeNow);
				knowledgeNowTB.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_DELETE);
				this.knowledgeBL.updateKnowledge(knowledgeNowTB);
			}
		}
		
		
		//���»򲵻ش�����֪ʶ״̬���¡�
		KnowledgeTBPK pk = new KnowledgeTBPK(Integer.valueOf(dto.getKnid()),Integer.valueOf(dto.getKnversion()));
		Knowledge knowledge = this.knowledgeBL.searchKnowledgeByPK(pk);
		tb = (KnowledgeTB)SerializationUtils.clone(knowledge);
		tb.setKnstatus(dto.getKnstatus());
		if("2".equals(dto.getKnstatus())){
			this.knowLogBL.addKnowLog(tb.getKnid(), dto.getUser().getUserid(), dto.getUser().getUsername(), IGStringUtils.getCurrentDateTime(), IGKGMCONSTANTS.KNOWLOG_RJECT+"  "+dto.getRlcomment());
		}
		if(StringUtils.isNotEmpty(dto.getRlcomment())){
			tb.setKnreject(dto.getRlcomment());
		}
		tb.setKnapprover(dto.getUser().getUserid());
		tb.setKnapprovername(dto.getUser().getUsername());
		tb.setKnapprovetime(IGStringUtils.getCurrentDateTime());

		this.knowledgeBL.updateKnowledge(tb);
		return dto;
	}
	
	/**
	 * ���ܣ���ѯ�Լ��ύ��֪ʶ
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO searchMyKnowLedgeAction(IGKGM03DTO dto) throws BLException {

		log.debug("========֪ʶ��������ʼ========");
		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		
		List<Knowledge> knowledgeList = new ArrayList<Knowledge>();//ҳ����ʾ����
	
		int totalCount = this.knowledgeBL.getSearchCount(dto.getKnowledgeSearchCond());

		if (totalCount == 0) {

			log.debug("========֪ʶ�������ݲ�����========");
			// ֪ʶ����������ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));

			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {

			log.debug("========֪ʶ�������ݼ�������========");
			// ֪ʶ����������ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));

			return dto;
		}
		knowledgeList = knowledgeBL.searchKnowledgeByCond(dto.getKnowledgeSearchCond(), pDto
				.getFromCount(), pDto.getPageDispCount());
		dto.setKnowledgeList(knowledgeList);
		pDto.setTotalCount(totalCount);

		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========֪ʶ������������========");

		return dto;
	}
	//-----------------------------------------------------------����----------------------------------------------------------------------
	
	
	
	//-----------------------------------------------------------����ǿ----------------------------------------------------------------------

	/**
	 * ֪ʶ��ѯ
	 */
	public IGKGM03DTO searchKnowLedgeInfoAction(IGKGM03DTO dto)
			throws BLException {
		log.debug("========֪ʶ��������ʼ========");
		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		
		IGKGM0203Form form = dto.getIgkgm0203Form();
		if(form.getKnkey() != null){
			String[] keys = form.getKnkey().split(" ");
			form.setKnkeys(keys);
		}
		String[] titles = form.getKntitle().split(" ");
		List<KnowLedgeInfo> knowLedgeList = new ArrayList<KnowLedgeInfo>();//ҳ����ʾ����
	
		form.setKntitles(titles);
		int totalCount = this.knowLedgeInfoBL.getSearchCount(form);

		if (totalCount == 0) {

			log.debug("========֪ʶ�������ݲ�����========");
			// ֪ʶ����������ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));

			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {

			log.debug("========֪ʶ�������ݼ�������========");
			// ֪ʶ����������ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));

			return dto;
		}
		knowLedgeList = knowLedgeInfoBL.searchKnowLedgeInfoByCond(form, pDto
				.getFromCount(), pDto.getPageDispCount());
		List<KnowLedgeInfo> knowLedgeListkl = new ArrayList<KnowLedgeInfo>();
		for(KnowLedgeInfo kli:knowLedgeList){
			KnowLedgeInfoVW kliVW = (KnowLedgeInfoVW)kli;
//			kliVW.setKntitle(getTurnString(kliVW.getKntitle()));
			knowLedgeListkl.add(kliVW);
		}
		dto.setKnowLedgeInfoList(knowLedgeListkl);
		pDto.setTotalCount(totalCount);

		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========֪ʶ������������========");

		return dto;
	}
	
	/**
	 * ֪ʶ����ϸ��ѯ
	 * @param knid
	 * @return
	 * @throws BLException
	 */
	public IGKGM03DTO searchKnowledgeDetailAction(IGKGM03DTO dto)
			throws BLException {
		//��������
		KnowledgeTBPK pk = new KnowledgeTBPK();
		//���������趨
		pk.setKnid(dto.getKnid());
		pk.setKnversion(dto.getKnversion());
		//��ѯ֪ʶ��ϸ����
		Knowledge knowledge = this.knowledgeBL.searchKnowledgeByPK(pk);
		//֪ʶ������̲�ѯ
		List<KnowledgeProcess> knowledgeProcessList = knowledgeProcessBL.searchProcessByKnid(dto.getKnid());
		
		dto.setKnowledge(knowledge);
		
		dto.setKnowledgeProcessList(knowledgeProcessList);
		
		return dto;
	}


	/**
	 * ֪ʶ���ֱ��ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGKGM03DTO searchKnowledgeGradeAction(IGKGM03DTO dto)
			throws BLException {
		
		//cond��ʼ��
		KnowledgeGradeSearchCondImpl cond = new KnowledgeGradeSearchCondImpl();
		
		if(dto.getKnid()!=null){
			cond.setKnid(dto.getKnid());
		}
		
		int totalCount = this.knowledgeGradeBL.getSearchCount(cond);

		if (totalCount == 0) {

			log.debug("========֪ʶ���ּ������ݲ�����========");
			// ֪ʶ����������ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));

			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {

			log.debug("========֪ʶ�������ݼ�������========");
			// ֪ʶ����������ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));

			return dto;
		}
		
		
		List<KnowledgeGrade> knowledgeGradeList = this.knowledgeGradeBL.findKnowledgeGradeByCond(cond, 0,0);
		dto.setKnowledgeGradeList(knowledgeGradeList);
		
		
		return dto;
	}

	/**
	 * ֪ʶ���ֵǼ�
	 * @param dto
	 * @return dto
	 * @throws BLException
	 */
	public IGKGM03DTO registKnowledgeGradeAction(IGKGM03DTO dto)
			throws BLException {
		//formȡ��
		IGKGM0207Form form = dto.getIgkgm0207Form();
		//���ֵǼ�
		this.knowledgeGradeBL.saveKnowledgeGrade(form);
		
		List<KnowledgeProcess> knowledgeProcessList = knowledgeProcessBL.searchProcessByKnid(dto.getKnid());
		
		dto.setKnowledgeProcessList(knowledgeProcessList);
		
		this.knowLogBL.addKnowLog(form.getKnid(), dto.getUser().getUserid(), dto.getUser().getUsername(),IGStringUtils.getCurrentDateTime(), IGKGMCONSTANTS.KNOWLOG_PINGFEN+"  ����:"+form.getKggrade()+"\n����:"+form.getKgappraise());
		return dto;
	}

	/**
	 * ���ܣ�֪ʶ��ϸ��Ϣ��ѯ(������ѯ)
	 *
	 * @param IGKGM03DTO 
	 * @return IGKGM03DTO
	 * @throws BLException 
	 */
	public IGKGM03DTO searchKnowLedgeDetailActionbyPK(IGKGM03DTO dto)
			throws BLException {
		//��������
		KnowledgeTBPK pk = new KnowledgeTBPK();
		//���������趨
		pk.setKnid(dto.getKnid());
		
		pk.setKnversion(dto.getKnversion());
		//��ѯ֪ʶ��ϸ����
		dto.setKnowledge(this.knowledgeBL.searchKnowledgeByPK(pk));
		//�����̴����й�����֪ʶ��ϸҳ�������
		dto.setKnowledgeProcessList(this.knowledgeProcessBL.searchProcessByKnid(dto.getKnid()));
		if(dto.getPrid() != null && dto.getPrid() > 0) {
			this.knowledgeProcessBL.registKnowledgeProcess(dto.getPrid(), dto.getKnid(), dto.getKnversion());
		}
		if(dto.getSfid() != null && dto.getSfid() > 0) {
			this.knowledgeProcessBL.registKnowledgeService(dto.getSfid(), dto.getKnid(), dto.getKnversion());
		}
		return dto;
	}
	
	/**
	 * ���ܣ���ѯ֪ʶ��ʷ��Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGKGM03DTO searchKnowledgeHistory(IGKGM03DTO dto) throws BLException {
		//��ѯ����
		KnowledgeSearchCondImpl cond = new KnowledgeSearchCondImpl();
		//�趨֪ʶID
		cond.setKnid(dto.getKnid());
		cond.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_APPROVEED);
		//��ѯ֪ʶ��ʷ�汾���
		List<Knowledge> knowledgeList = knowledgeBL.getKnowledgeHistory(cond);
		//��ȥ��һ����¼
		//knowledgeList.remove(0);

		List<IGKGM02052VO> voList = new ArrayList<IGKGM02052VO>();
		for(Knowledge kl : knowledgeList){
			IGKGM02052VO vo = new IGKGM02052VO();
			vo.setKnowledge(kl);
			KnowledgeAppImpactSearchCondImpl kacond = new KnowledgeAppImpactSearchCondImpl();
			kacond.setKnid(kl.getKnid());
			kacond.setKnversion(kl.getKnversion());
			List<KnowledgeAppImpact> processAppImpactList = knowledgeAppImpactBL.findKnowledgeAppImpactByCond(kacond, 0, 0);
			vo.setKnowledgeAppImpactList(processAppImpactList);
			voList.add(vo);
		}

		dto.setVoList(voList);
		dto.setKnowledgeList(knowledgeList);
		return dto;
	}
	
	/**
	 * ���ܣ��鿴֪ʶ���������̺ͷ��񹤵�
	 * @param dto
	 * @return dto
	 * @throws BLException
	 */
	public IGKGM03DTO searchKnowledgeProcessByKnid(IGKGM03DTO dto) throws BLException {
		//��ѯ�����������List
		List<KnowledgeProcess> knowledgeProcessList = knowledgeProcessBL.searchKnowledgeProcessByKnid(dto.getKnid());
		//��ѯ����趨��DTO��
		dto.setKnowledgeProcessList(knowledgeProcessList);
		return dto;
	}
	
	//-----------------------------------------------------------�޶���----------------------------------------------------------------------

	/**
	 * ֪ʶ����,��ѯKnowledge��
	 */
	public IGKGM03DTO searchUpdateKnowLedgeActionbyPK(IGKGM03DTO dto) throws BLException {
		
		List<Knowledge> knowledgeList = new ArrayList<Knowledge>();
		KnowledgeTBPK knowledgeTBPK = new KnowledgeTBPK();
		knowledgeTBPK.setKnid(dto.getIgkgm0216Form().getKnid());
		knowledgeTBPK.setKnversion(dto.getIgkgm0216Form().getKnversion());
		Knowledge knowledge = knowledgeBL.searchKnowledgeByPK(knowledgeTBPK);
		
		knowledgeList.add(knowledge);
		IGKGM0216Form iGKGM0216Form = dto.getIgkgm0216Form();
		iGKGM0216Form.setKnversion(knowledge.getKnversion());
		iGKGM0216Form.setKntelarea(knowledge.getKntelarea());
		iGKGM0216Form.setKntelareaname(knowledge.getKntelareaname());
		iGKGM0216Form.setKnarea(knowledge.getKnarea());
		iGKGM0216Form.setKnareaname(knowledge.getKnareaname());
		iGKGM0216Form.setKntitle(knowledge.getKntitle());
		iGKGM0216Form.setKnserial(knowledge.getKnserial());
		iGKGM0216Form.setKnreject(knowledge.getKnreject());
		iGKGM0216Form.setKndepartment(knowledge.getKndepartment());
		iGKGM0216Form.setKnapprover(knowledge.getKnapprover());
		iGKGM0216Form.setKnapprovetime(knowledge.getKnapprovetime());
		iGKGM0216Form.setKnclass(knowledge.getKnclass());
		iGKGM0216Form.setKnkey(knowledge.getKnkey());
		iGKGM0216Form.setKnorigin(knowledge.getKnorigin());
		iGKGM0216Form.setKnoriginname(knowledge.getKnoriginname());
		iGKGM0216Form.setKnproffer(knowledge.getKnproffer());
		iGKGM0216Form.setKnproffertime(knowledge.getKnproffertime());
		iGKGM0216Form.setKndes(knowledge.getKndes());
		iGKGM0216Form.setKnfaultcause(knowledge.getKnfaultcause());
		iGKGM0216Form.setKnsolveway(knowledge.getKnsolveway());
		iGKGM0216Form.setKnstatus(knowledge.getKnstatus());
		iGKGM0216Form.setKnclassname(knowledge.getKnclassname());
		iGKGM0216Form.setKnattkey(knowledge.getKnattkey());
		iGKGM0216Form.setKnapproverole(knowledge.getKnapproverole());
		dto.setIgkgm0216Form(iGKGM0216Form);
		dto.setKnowledgeList(knowledgeList);
		//���̹���֪ʶ���ϲ�ѯ����
		dto.setKnowledgeProcessList(this.knowledgeProcessBL.searchProcessByKnid(dto.getIgkgm0216Form().getKnid()));
		return dto;
	}
	
	/**
	 * ֪ʶ�Ǽ�,��ѯKnowledge��
	 */
	public IGKGM03DTO searchKnowLedgeActionbyPK(IGKGM03DTO dto) throws BLException {
		
		List<Knowledge> knowledgeList = new ArrayList<Knowledge>();
		KnowledgeTBPK knowledgeTBPK = new KnowledgeTBPK();
		knowledgeTBPK.setKnid(dto.getIgkgm0201Form().getKnid());
		knowledgeTBPK.setKnversion(dto.getIgkgm0201Form().getKnversion());
		Knowledge knowledge = knowledgeBL.searchKnowledgeByPK(knowledgeTBPK);
		knowledgeList.add(knowledge);
		IGKGM0201Form iGKGM0201Form = dto.getIgkgm0201Form();
		iGKGM0201Form.setKntitle(knowledge.getKntitle());
		iGKGM0201Form.setKnoriginname(knowledge.getKnoriginname());
		iGKGM0201Form.setKnarea(knowledge.getKnarea());
		iGKGM0201Form.setKnareaname(knowledge.getKnareaname());
		iGKGM0201Form.setKntelarea(knowledge.getKntelarea());
		iGKGM0201Form.setKntelareaname(knowledge.getKntelareaname());
		iGKGM0201Form.setKnserial(knowledge.getKnserial());
		iGKGM0201Form.setKnreject(knowledge.getKnreject());
		iGKGM0201Form.setKndepartment(knowledge.getKndepartment());
		iGKGM0201Form.setKnapprover(knowledge.getKnapprover());
		iGKGM0201Form.setKnapprovetime(knowledge.getKnapprovetime());
		iGKGM0201Form.setKnclass(knowledge.getKnclass());
		iGKGM0201Form.setKnkey(knowledge.getKnkey());
		iGKGM0201Form.setKnorigin(knowledge.getKnorigin());
		iGKGM0201Form.setKnproffer(knowledge.getKnproffer());
		iGKGM0201Form.setKnproffertime(knowledge.getKnproffertime());
		iGKGM0201Form.setKndes(knowledge.getKndes());
		iGKGM0201Form.setKnfaultcause(knowledge.getKnfaultcause());
		iGKGM0201Form.setKnsolveway(knowledge.getKnsolveway());
		iGKGM0201Form.setKnstatus(knowledge.getKnstatus());
		iGKGM0201Form.setKnclassname(knowledge.getKnclassname());
		iGKGM0201Form.setKnattkey(knowledge.getKnattkey());
		iGKGM0201Form.setKnapproverole(knowledge.getKnapproverole());
		dto.setIgkgm0201Form(iGKGM0201Form);
		dto.setKnowledgeList(knowledgeList);
		
		//���̹���֪ʶ���ϲ�ѯ����
		dto.setKnowledgeProcessList(this.knowledgeProcessBL.searchProcessByKnid(dto.getIgkgm0201Form().getKnid()));
		return dto;
	}
	
	/**
	 * ֪ʶ�Ǽ�,�޸ĺ󱣴浽Knowledge��
	 */
	public IGKGM03DTO updateKnowLedgeAction(IGKGM03DTO dto) throws BLException {
		
		IGKGM0201Form iGKGM0201Form = dto.getIgkgm0201Form();
		///this.uploadFileAction(dto);  song
		KnowledgeTB knowledgeTB = new KnowledgeTB();
		knowledgeTB.setKnid(Integer.valueOf(iGKGM0201Form.getKnid()));
		knowledgeTB.setKnversion(Integer.valueOf(iGKGM0201Form.getKnversion()));
		knowledgeTB.setKnkey(iGKGM0201Form.getKnkey());
		knowledgeTB.setKnreject(iGKGM0201Form.getKnreject());
		knowledgeTB.setKnproffer(dto.getUser().getUserid());
		if(StringUtils.isNotEmpty(iGKGM0201Form.getKnproffername())){
			knowledgeTB.setKnapprover(iGKGM0201Form.getKnapprover());//�鵵��
			knowledgeTB.setKnproffer(iGKGM0201Form.getKnproffer());
			knowledgeTB.setKnproffername(iGKGM0201Form.getKnproffername());//֪ʶ������
		}else{
			KnowledgeSearchCondImpl cond = new KnowledgeSearchCondImpl();
			cond.setKnid(Integer.valueOf(iGKGM0201Form.getKnid()));
			Knowledge kl = knowledgeBL.searchKnowledgeByByKnid(cond);//��ȡ���°汾֪ʶ��Ϣ
			knowledgeTB.setKnapprover(kl.getKnapprover());//�鵵��
			knowledgeTB.setKnproffer(iGKGM0201Form.getKnproffer());//������
			knowledgeTB.setKnproffername(kl.getKnproffername());

		}
		knowledgeTB.setKnproffertime(iGKGM0201Form.getKnproffertime());
		knowledgeTB.setKnserial(iGKGM0201Form.getKnserial());
		knowledgeTB.setKnorigin(iGKGM0201Form.getKnorigin());
		knowledgeTB.setKnoriginname(iGKGM0201Form.getKnoriginname());
		knowledgeTB.setKnarea(iGKGM0201Form.getKnarea());
		knowledgeTB.setKnareaname(iGKGM0201Form.getKnareaname());
		knowledgeTB.setKntelarea(iGKGM0201Form.getKntelarea());
		knowledgeTB.setKntelareaname(iGKGM0201Form.getKntelareaname());
		
		knowledgeTB.setKntitle(iGKGM0201Form.getKntitle());
		knowledgeTB.setKnclass(iGKGM0201Form.getKnclass());
		knowledgeTB.setKnclassname(iGKGM0201Form.getKnclassname());
		knowledgeTB.setKndepartment(iGKGM0201Form.getKndepartment());
		knowledgeTB.setKndes(iGKGM0201Form.getKndes());
		knowledgeTB.setKnfaultcause(iGKGM0201Form.getKnfaultcause());
		knowledgeTB.setKnsolveway(iGKGM0201Form.getKnsolveway());
		knowledgeTB.setKnstatus(iGKGM0201Form.getKnstatus());
		if(iGKGM0201Form.getFileMap() !=null && iGKGM0201Form.getFileMap().size()>0){
			knowledgeTB.setKnattkey(this.uploadFileAction(iGKGM0201Form.getKnattkey(),iGKGM0201Form.getFileMap()));
		}
		knowledgeTB.setKnapproverole(iGKGM0201Form.getKnapproverole());
		if(StringUtils.isNotEmpty(iGKGM0201Form.getKnattkey())){
			knowledgeTB.setKnattkey(iGKGM0201Form.getKnattkey());
		}
		Knowledge knowledge = knowledgeBL.updateKnowledge(knowledgeTB);
		//֪ʶ�������̴���
		this.knowledgeProcessBL.knowledgeRelateProcess(knowledge.getKnid(), knowledge.getKnversion(), iGKGM0201Form.getProcessList());
		//<<<<<<<<<<<<<< add by wangxiaoqiang ֪ʶҵ��ϵͳ����
		dto.setKnid(knowledge.getKnid());
		dto.setKnversion(knowledge.getKnversion());
		//����
//		if(!dto.isCheckflag()){
			List<KnowledgeAppImpact> knowledgeAppImpactList = this.getKnowledgeAppImpact(dto).getKnowledgeAppImpactList();
			if(knowledgeAppImpactList!=null && knowledgeAppImpactList.size()>0){
				for(int i=0;i<knowledgeAppImpactList.size();i++){
					knowledgeAppImpactBL.deleteKnowledgeAppImpact(knowledgeAppImpactList.get(i));
				}
			}
		
			if(iGKGM0201Form.getKaicodes()!=null && iGKGM0201Form.getKaicodes().length>0){
				for(int i=0;i<iGKGM0201Form.getKaicodes().length;i++){
					if(!("".equals(iGKGM0201Form.getKaicodes()[i]))){
						KnowledgeAppImpactTB knowledgeAppImpactTB = new KnowledgeAppImpactTB();
						knowledgeAppImpactTB.setKaicode(iGKGM0201Form.getKaicodes()[i]);
						knowledgeAppImpactTB.setKnid(dto.getKnid());
						knowledgeAppImpactTB.setKnversion(knowledge.getKnversion());
						knowledgeAppImpactBL.saveKnowledgeAppImpact(knowledgeAppImpactTB);
					}
				}
			}
//		}
		//<<<<<<<<<<<<<< add by wangxiaoqiang ֪ʶҵ��ϵͳ����
		
		
		
	//ɾ��ָ��������ʼ=====================>
		if(StringUtils.isNotEmpty(dto.getDelFiles())){
			String[] files = (dto.getDelFiles()).split("[|]");
			if(files != null){
				for(String fileId:files){
					if(StringUtils.isNotEmpty(fileId)){
						Attachment attFile = attachmentBL.searchAttachmentByKey(Integer.parseInt(fileId));
						attachmentBL.deleteAttachment(attFile);
					}
				}
			}
		}
	//ɾ��ָ����������=====================<
	

	//ɾ����ذ�����ʼ=====================>
		if(StringUtils.isNotEmpty(dto.getDelKgm())){
			String[] kgms = (dto.getDelKgm()).split("[|]");
			if(kgms != null){
				for(String kpid:kgms){
					if(StringUtils.isNotEmpty(kpid)){
						knowledgeProcessBL.deleteKnowledgeProcess(Integer.parseInt(kpid));
					}
				}
			}
		}
	//ɾ����ذ�������=====================<

		if(iGKGM0201Form.getKnstatus().equals(IGKGMCONSTANTS.KNOWLEDGE_INIT)){
			knowLogBL.addKnowLog(knowledge.getKnid(), dto.getUser().getUserid(), dto.getUser().getUsername(), IGStringUtils.getCurrentDateTime(), IGKGMCONSTANTS.KNOWLOG_UPDATE);
		}else if(IGKGMCONSTANTS.KNOWLEDGE_UN_APPROVE.equals(iGKGM0201Form.getKnstatus())){
			knowLogBL.addKnowLog(knowledge.getKnid(), dto.getUser().getUserid(), dto.getUser().getUsername(), IGStringUtils.getCurrentDateTime(), IGKGMCONSTANTS.KNOWLOG_WAIT);
		}else if(IGKGMCONSTANTS.KNOWLEDGE_APPROVEED.equals(iGKGM0201Form.getKnstatus())){
			knowLogBL.addKnowLog(knowledge.getKnid(), dto.getUser().getUserid(), dto.getUser().getUsername(), IGStringUtils.getCurrentDateTime(), IGKGMCONSTANTS.KNOWLOG_APPROCE);
		}
		
		
		log.debug("========֪ʶ��Ϣ�����������========");
		return dto;
	}
	
	/**
	 * ����һ��֪ʶ��������
	 */
	public synchronized IGKGM03DTO  insertKnowledgeAction(IGKGM03DTO dto) throws BLException {
		synchronized (this) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				throw new BLException("IGCO00000.E001");
			}

		IGKGM0216Form form = dto.getIgkgm0216Form();
		KnowledgeTB recordLogKnTB = new KnowledgeTB();
		recordLogKnTB.setKnid(form.getKnid());
		int version = form.getKnversion().intValue() + 1;
		recordLogKnTB.setKnversion(version);
		recordLogKnTB.setKnserial(form.getKnserial());
		recordLogKnTB.setKndepartment(form.getKndepartment());
		recordLogKnTB.setKnproffer(dto.getUser().getUserid());
		recordLogKnTB.setKnproffername(dto.getUser().getUsername());//֪ʶ������
		recordLogKnTB.setKnproffertime(IGStringUtils.getCurrentDateTime());//֪ʶ����ʱ��
		recordLogKnTB.setKnclass(form.getKnclass());
		recordLogKnTB.setKnclassname(form.getKnclassname());
		recordLogKnTB.setKnkey(form.getKnkey());
		recordLogKnTB.setKnorigin(form.getKnorigin());
		recordLogKnTB.setKnoriginname(form.getKnoriginname());
		
		recordLogKnTB.setKnarea(form.getKnarea());
		recordLogKnTB.setKnareaname(form.getKnareaname());
		recordLogKnTB.setKntelarea(form.getKntelarea());
		recordLogKnTB.setKntelareaname(form.getKntelareaname());
		
		recordLogKnTB.setKntitle(form.getKntitle());
		recordLogKnTB.setKndes(form.getKndes());
		recordLogKnTB.setKnfaultcause(form.getKnfaultcause());
		recordLogKnTB.setKnsolveway(form.getKnsolveway()); 
		recordLogKnTB.setKnstatus(form.getKnstatus());
		recordLogKnTB.setKndes(form.getKndes());
		recordLogKnTB.setKnapproverole(form.getKnapproverole());
//		recordLogKnTB.setKnattkey(form.getKnattkey());
		if(version==1 && form.getFileMap() !=null && form.getFileMap().size()>0){
		    recordLogKnTB.setKnattkey(this.uploadFileAction(form.getKnattkey(),form.getFileMap()));
		}
		if(form.getKnattkey()!=null){
			recordLogKnTB.setKnattkey(form.getKnattkey());
		}
		
		//֪ʶ����¸����޸�
		if (version > 1) {

			List<Attachment> attachmentList = new ArrayList<Attachment>();
			if (form.getKnattkey() != null && (!"".equals(form.getKnattkey()))) {
				// ȡ��ԭ�еĸ���list
				attachmentList = attachmentBL.searchAttachmentsByAttkey(form
						.getKnattkey());
				// ʣ��ĸ���list
				//List<Attachment> attachmentLeaveList = new ArrayList<Attachment>();
				
				if (StringUtils.isNotEmpty(dto.getDelFiles())) {// ǰ̨��������˸���ɾ������
					String[] files = (dto.getDelFiles()).split("[|]");
					if (files != null) {
						// ��ԭ�и����б��У�ȥ�����λ�����ɾ���ĸ���
						for (Iterator<Attachment> iter = attachmentList.iterator(); iter.hasNext();) {
							
							Attachment attachment = null;
							attachment = iter.next();
							for (String fileId : files) {
								if (StringUtils.isNotEmpty(fileId)
										&& attachment.getAttid() == Integer
												.parseInt(fileId)) {
									iter.remove();
								}
							}
						}
					}
				}
			}
			
			
			
			

			String attkey_new = null;// �µĸ���key
			// ǰ̨������Ӹ���ʱ�����ø����ϴ���������key
			if (form.getFileMap() != null && form.getFileMap().size() > 0) {
				attkey_new = this.uploadFileAction(null, form.getFileMap());
				for (int i = 0; i < attachmentList.size(); i++) {
					AttachmentTB attachmentTB = new AttachmentTB();
					attachmentTB.setAttkey(attkey_new);
					attachmentTB.setAttdesc(attachmentList.get(i).getAttdesc());
					attachmentTB.setAttname(attachmentList.get(i).getAttname());
					attachmentTB.setAtturl(attachmentList.get(i).getAtturl());
					attachmentBL.registAttachment(attachmentTB);
				}
			// ǰ̨û����Ӹ����������ϰ�֪ʶ�и������������������key
			} else if(attachmentList !=null && attachmentList.size()>0){
				attkey_new = IGStringUtils.getAttKey();
				for (int i = 0; i < attachmentList.size(); i++) {
					AttachmentTB attachmentTB = new AttachmentTB();
					attachmentTB.setAttkey(attkey_new);
					attachmentTB.setAttdesc(attachmentList.get(i).getAttdesc());
					attachmentTB.setAttname(attachmentList.get(i).getAttname());
					attachmentTB.setAtturl(attachmentList.get(i).getAtturl());
					attachmentBL.registAttachment(attachmentTB);
				}
			}
			
			recordLogKnTB.setKnattkey(attkey_new);
			
			//ɾ����ذ�����ʼ=====================>
			if(StringUtils.isNotEmpty(dto.getDelKgm())){
				String[] kgms = (dto.getDelKgm()).split("[|]");
				if(kgms != null){
					for(String kpid:kgms){
						if(StringUtils.isNotEmpty(kpid)){
							knowledgeProcessBL.deleteKnowledgeProcess(Integer.parseInt(kpid));
						}
					}
				}
			}
		//ɾ����ذ�������=====================<
		}
		
		Knowledge recordLogKn = this.knowledgeBL.registKnowledge(recordLogKnTB);
		
		//<<<<<<<<<<<<<< add by wangxiaoqiang ֪ʶҵ��ϵͳ����
		dto.setKnid(recordLogKn.getKnid());
		dto.setKnversion(recordLogKn.getKnversion());
		List<KnowledgeAppImpact> knowledgeAppImpactList = this.getKnowledgeAppImpact(dto).getKnowledgeAppImpactList();
		if(knowledgeAppImpactList!=null && knowledgeAppImpactList.size()>0){
			for(int i=0;i<knowledgeAppImpactList.size();i++){
				knowledgeAppImpactBL.deleteKnowledgeAppImpact(knowledgeAppImpactList.get(i));
			}
		}
		
		if(form.getKaicodes()!=null && form.getKaicodes().length>0){
			for(int i=0;i<form.getKaicodes().length;i++){
				if(!("".equals(form.getKaicodes()[i]))){
					KnowledgeAppImpactTB knowledgeAppImpactTB = new KnowledgeAppImpactTB();
					knowledgeAppImpactTB.setKaicode(form.getKaicodes()[i]);
					knowledgeAppImpactTB.setKnid(dto.getKnid());
					knowledgeAppImpactTB.setKnversion(recordLogKn.getKnversion());
					knowledgeAppImpactBL.saveKnowledgeAppImpact(knowledgeAppImpactTB);
				}
			}
			
		}
		//<<<<<<<<<<<<<< add by wangxiaoqiang ֪ʶҵ��ϵͳ����
		
		

		//֪ʶ�������̴���
		this.knowledgeProcessBL.knowledgeRelateProcess(recordLogKn.getKnid(), recordLogKn.getKnversion(), form.getProcessList());
		knowLogBL.addKnowLog(recordLogKn.getKnid(),dto.getUser().getUserid(), dto.getUser().getUsername(), IGStringUtils.getCurrentDateTime(), IGKGMCONSTANTS.KNOWLOG_UPDATE);


		dto.addMessage(new ActionMessage( "IGCO10000.I004", "֪ʶ") );
		return dto;
		}
	}
	
	/**
	 * ����֪ʶ�Ǽ�
	 */
	public synchronized IGKGM03DTO insertAction(IGKGM03DTO dto) throws BLException {
		synchronized (this) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				throw new BLException("IGCO00000.E001");
			}

		int temp = 0;
		KnowledgeSearchCondImpl cond = new KnowledgeSearchCondImpl();
		List<Knowledge> knowledgeList = knowledgeBL.searchKnowledgeByCond(cond, 0, 0);
		if(null != knowledgeList && knowledgeList.size() >0){
			
			for(int i=0;i<knowledgeList.size();i++){
				if(knowledgeList.get(i).getKnid().intValue() > temp){
					temp = knowledgeList.get(i).getKnid().intValue();
				}
			}
		}
		Integer maxid = Integer.valueOf(temp + 1);
		IGKGM0201Form form = dto.getIgkgm0201Form();
		KnowledgeTB KnowledgeTB = new KnowledgeTB();
		int id = maxid.intValue() + 1;
		KnowledgeTB.setKnid(Integer.valueOf(String.valueOf(id)));
		KnowledgeTB.setKnversion(Integer.valueOf("1"));
		KnowledgeTB.setKnserial(form.getKnserial());
		
		KnowledgeTB.setKnarea(form.getKnarea());
		KnowledgeTB.setKnareaname(form.getKnareaname());
		KnowledgeTB.setKntelarea(form.getKntelarea());
		KnowledgeTB.setKntelareaname(form.getKntelareaname());
		KnowledgeTB.setKnorigin(form.getKnorigin());
		KnowledgeTB.setKnoriginname(form.getKnoriginname());
		
		KnowledgeTB.setKndepartment(form.getKndepartment());
		KnowledgeTB.setKnproffer(dto.getUser().getUserid());
		KnowledgeTB.setKnproffername(dto.getUser().getUsername());//֪ʶ������
		KnowledgeTB.setKnproffertime(IGStringUtils.getCurrentDateTime());//֪ʶ����ʱ��
		KnowledgeTB.setKnclass(form.getKnclass());
		KnowledgeTB.setKnclassname(form.getKnclassname());
		KnowledgeTB.setKnkey(form.getKnkey());
		KnowledgeTB.setKntitle(form.getKntitle());
		KnowledgeTB.setKndes(form.getKndes());
		KnowledgeTB.setKnfaultcause(form.getKnfaultcause());
		KnowledgeTB.setKnsolveway(form.getKnsolveway()); 
		KnowledgeTB.setKnstatus(form.getKnstatus());
		KnowledgeTB.setKndes(form.getKndes());
		if(form.getFileMap() !=null && form.getFileMap().size()>0){
		    KnowledgeTB.setKnattkey(this.uploadFileAction(form.getKnattkey(),form.getFileMap()));
		}
		KnowledgeTB.setKnapproverole(form.getKnapproverole());
		Knowledge recordLogKn = this.knowledgeBL.registKnowledge(KnowledgeTB);
		Integer knid = recordLogKn.getKnid();
		if(form.getKaicodes()!=null && form.getKaicodes().length>0){
			for(int i=0;i<form.getKaicodes().length;i++){
				if(!("".equals(form.getKaicodes()[i]))){
					KnowledgeAppImpactTB knowledgeAppImpactTB = new KnowledgeAppImpactTB();
					knowledgeAppImpactTB.setKaicode(form.getKaicodes()[i]);
					knowledgeAppImpactTB.setKnid(knid);
					knowledgeAppImpactTB.setKnversion(recordLogKn.getKnversion());
					knowledgeAppImpactBL.saveKnowledgeAppImpact(knowledgeAppImpactTB);
				}
			}
		}
		
		//֪ʶ�������̴���
		this.knowledgeProcessBL.knowledgeRelateProcess(recordLogKn.getKnid(), recordLogKn.getKnversion(), form.getProcessList());
		knowLogBL.addKnowLog(recordLogKn.getKnid(),dto.getUser().getUserid(), dto.getUser().getUsername(), IGStringUtils.getCurrentDateTime(), IGKGMCONSTANTS.KNOWLOG_INSERT);

		dto.addMessage(new ActionMessage( "IGCO10000.I004", "֪ʶ") );
		return dto;
		}
	}
	
	/**
	 * ֪ʶ���ֱ��ѯ
	 * @param dto
	 * @return ����ֵ0��ʾû��δ�����ġ�֪ʶ���¡����ݡ�1��ʾ�С�
	 * @throws BLException
	 */
	public IGKGM03DTO searchKnowledgeNotCheckAction(IGKGM03DTO dto)
			throws BLException {
		
		//֪ʶ���£������Ƿ��и��µ�δ��������֪ʶ��
		int totalCount = 0;
		KnowledgeSearchCondImpl knowledgeSearchCond = new KnowledgeSearchCondImpl();
//		knowledgeSearchCond.setKnid(dto.getIgkgm0216Form().getKnid());
		knowledgeSearchCond.setKnid(dto.getKnid());
		knowledgeSearchCond.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_UN_APPROVE +","+IGKGMCONSTANTS.KNOWLEDGE_REJECT +","+IGKGMCONSTANTS.KNOWLEDGE_INIT);
		List<Knowledge> knowledgeList = this.knowledgeBL.searchKnowledgeByCond(knowledgeSearchCond, 0,0);
		if(null != knowledgeList && knowledgeList.size()>0){
			totalCount = 1;
			dto.setKnowledgeList(knowledgeList);
			dto.setKnowledge(knowledgeList.get(0));
		}
		dto.setVersions(totalCount);
		return dto;
	}

	/**
	 * ֪ʶ��ϸҳ���ѯ
	 * @param dto
	 * @return ����ֵ0��ʾû��δ�����ġ�֪ʶ���¡����ݡ�1��ʾ�С�
	 * @throws BLException
	 */
	public IGKGM03DTO searchKnowledgeNotCheckActionForKGMDis(IGKGM03DTO dto)
			throws BLException {
		//֪ʶ���£������Ƿ��и��µ�δ��������֪ʶ��
		int totalCount = 0;
		KnowledgeSearchCondImpl knowledgeSearchCond = new KnowledgeSearchCondImpl();
		knowledgeSearchCond.setKnid(dto.getKnid());
		knowledgeSearchCond.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_UN_APPROVE +","+IGKGMCONSTANTS.KNOWLEDGE_REJECT +","+IGKGMCONSTANTS.KNOWLEDGE_INIT);
		List<Knowledge> knowledgeList = this.knowledgeBL.searchKnowledgeByCond(knowledgeSearchCond, 0,0);
		if(null != knowledgeList && knowledgeList.size()>0){
			totalCount = 1;
		}
		dto.setVersions(totalCount);
		return dto;
	}
	
	/**
	 * ɾ��֪ʶ
	 */
	public IGKGM03DTO deleteKnowLedgeAction(IGKGM03DTO dto) throws BLException {
			log.debug("========֪ʶɾ������ʼ========");
			//ѭ��ɾ��
			String knids[] = dto.getIgkgm0202Form().getKnids();
			
			for( int i=0;i<knids.length;i++ ){
				//֪ʶɾ������
				KnowledgeTBPK knowledgeTBPK = new KnowledgeTBPK();
				knowledgeTBPK.setKnid(Integer.valueOf(knids[i]));
				
				KnowledgeSearchCondImpl knowledgeSearchCond = new KnowledgeSearchCondImpl();
				knowledgeSearchCond.setKnid(Integer.valueOf(knids[i]));
				knowledgeSearchCond.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_UN_APPROVE +","+IGKGMCONSTANTS.KNOWLEDGE_REJECT +","+IGKGMCONSTANTS.KNOWLEDGE_INIT);
				List<Knowledge> knowledgeList = this.knowledgeBL.searchKnowledgeByCond(knowledgeSearchCond, 0,0);
				if(null != knowledgeList && knowledgeList.size()>0){
					knowledgeTBPK.setKnversion(knowledgeList.get(0).getKnversion());
				}
				Knowledge knowledge = knowledgeBL.searchKnowledgeByPK(knowledgeTBPK);
				knowledgeBL.deleteKnowledge(knowledge);
			}
			dto.addMessage(new ActionMessage("IGCO10000.I006", "֪ʶ������Ϣ")); 
			log.debug("========֪ʶɾ����������========");
			return dto;
		}
	
//	/**
//	 * �޸Ĵ���������
//	 * @param dto
//	 * @return
//	 * @throws BLException
//	 */
//	private String uploadFileUpdateAction(IGKGM03DTO dto) throws BLException {
//		IGKGM0216Form form = dto.getIgkgm0216Form();
//		AttachmentTB attachment = new AttachmentTB();
//		// �ϴ��ļ����
//	    String  attkey = form.getKnattkey();
//		if (attkey==null ||attkey.equals("")) {
//			attkey = IGStringUtils.getAttKey();		
//		} 
//		attachment.setAttkey(attkey);
//		 
//		Map<Integer, FormFile> fileMap = form.getFileMap();
//		Set<Map.Entry<Integer,FormFile>> set = fileMap.entrySet();
//		for(Iterator<Map.Entry<Integer,FormFile>> iter = set.iterator();iter.hasNext();){
//				
//			Map.Entry<Integer,FormFile> entry = iter.next();
//			 FormFile file = entry.getValue();
//			 if (file != null && file.getFileSize() > 0) {
//				 // �ϴ��ļ����ڵ����
//				 // �ϴ��ļ�·��
//				 String rootPath = ResourceUtility
//				 .getString("UPLOAD_FILE_ROOT_PATH");
//				 StringBuffer pathBuf = new StringBuffer();
//				 // ��Ŀ¼
//				 pathBuf.append(rootPath);
//				 // ����ID
//				 pathBuf.append("kgm");
//				 pathBuf.append(File.separator);
//				 StringBuffer fileName = new StringBuffer();
//				 fileName.append(file.getFileName());
//				 // �ļ��ϴ�����
//				 try {
//					 this.fileUploadBL.saveFile(file, pathBuf.toString(), attkey
//							 + "_" + fileName.toString());
//				 } catch (FileNotFoundException e) {
//					 log.debug(e.getMessage());
//				 } catch (IOException e) {
//					 log.debug(e.getMessage());
//				 }
//				 // �ϴ��ļ�������
//				 attachment.setAttname(attkey + "_" + fileName.toString());
//				 // �ϴ��ļ���URL
//				 attachment.setAtturl("kgm");
//				 this.attachmentBL.registAttachment(attachment);
//			 }
//		 }
//		return attkey;
//	}
	
	/**
	 * �޸Ĵ���������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	private String uploadFileAction(String attkey,Map<Integer, FormFile> fileMap) throws BLException {
		//IGKGM0201Form form = dto.getIgkgm0201Form();
		AttachmentTB attachment = new AttachmentTB();
		// �ϴ��ļ����
	   // String  attkey = form.getKnattkey();
		if (attkey==null ||attkey.equals("")) {
			attkey = IGStringUtils.getAttKey();		
		} 
		attachment.setAttkey(attkey);
		 
		//Map<Integer, FormFile> fileMap = form.getFileMap();
		Set<Map.Entry<Integer,FormFile>> set = fileMap.entrySet();
		for(Iterator<Map.Entry<Integer,FormFile>> iter = set.iterator();iter.hasNext();){
				
			Map.Entry<Integer,FormFile> entry = iter.next();
			 FormFile file = entry.getValue();
			 if (file != null && file.getFileSize() > 0) {
				 // �ϴ��ļ����ڵ����
				 // �ϴ��ļ�·��
				 String rootPath = ResourceUtility
				 .getString("UPLOAD_FILE_ROOT_PATH");
				 StringBuffer pathBuf = new StringBuffer();
				 // ��Ŀ¼
				 pathBuf.append(rootPath);
				 // ����ID
				 pathBuf.append("kgm");
				 pathBuf.append(File.separator);
				 StringBuffer fileName = new StringBuffer();
				 fileName.append(file.getFileName());
				 // �ļ��ϴ�����
				 try {
					 this.fileUploadBL.saveFile(file, pathBuf.toString(), attkey
							 + "_" + fileName.toString());
				 } catch (FileNotFoundException e) {
					 log.debug(e.getMessage());
				 } catch (IOException e) {
					 log.debug(e.getMessage());
				 }
				 // �ϴ��ļ�������
				 attachment.setAttname(attkey + "_" + fileName.toString());
				 // �ϴ��ļ���URL
				 attachment.setAtturl("kgm");
				 this.attachmentBL.registAttachment(attachment);
			 }
		 }
		return attkey;
	}

	/**
	 * ���ܣ����ҹؼ���
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO searchKnowledgeKeyAction(IGKGM03DTO dto,CodeDetailBL codeDetailBL) throws BLException
	{
		
		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
		cond.setCcid(CodeDefine.getCodeDefine("KNOWLEDGE_KEYS").getCcid());
		cond.setCdstatus(String.valueOf(CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1));
		List<CodeDetail> codelist = codeDetailBL.searchCodeDetailTree(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);//�����е�1�����
		ArrayList<String> keys = new ArrayList<String>();
		CodeDetailSearchCondImpl cond2 = new CodeDetailSearchCondImpl();
		for(CodeDetail code:codelist){
			String syscoding = code.getSyscoding();
			
			//���õ�ǰ����������(�Ӹü��������)
			cond2.setSyscoding_q(syscoding);
			cond2.setCdstatus(String.valueOf(CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1));
			List<CodeDetail> detail = codeDetailBL.searchCodeDetailTree(cond2, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_3);//��ý����¼������
			keys.add(detail.get(0).getCvalue());
		}
		dto.setKeysFromDB(keys);
		log.debug("========��ѯSpecial_CODE_TREE_By_CdStatus����========");
		return dto;
	}
	

	public void setCodeCategoryBL(CodeCategoryBL codeCategoryBL) {
		this.codeCategoryBL = codeCategoryBL;
	}

	/**
	 * ���ܣ�֪ʶ����ҵ��ϵͳListȡ��
	 * @param dto
	 * @return dto
	 * @throws BLException
	 */
	public IGKGM03DTO getKnowledgeAppImpact(IGKGM03DTO dto) throws BLException {
		KnowledgeAppImpactSearchCondImpl cond = new KnowledgeAppImpactSearchCondImpl();
		cond.setKnid(dto.getKnid());
		cond.setKnversion(dto.getKnversion());
		List<KnowledgeAppImpact> processAppImpactList = knowledgeAppImpactBL.findKnowledgeAppImpactByCond(cond, 0, 0);
		dto.setKnowledgeAppImpactList(processAppImpactList);
		return dto;
	}

	/**
	 * ���ܣ�֪ʶ����ҵ��ϵͳ��ʼ��ȡ��
	 * @param dto
	 * @return dto
	 * @throws BLException
	 */
	public IGKGM03DTO getKnowledgeAppImpact_Disp(IGKGM03DTO dto)
			throws BLException {
		List<LabelValueBean> system_typeList = this.getSystem_typeList(dto).getSystem_typeList();
		List<KnowledgeAppImpact> knowledgeAppImpactList = this.getKnowledgeAppImpact(dto).getKnowledgeAppImpactList();
		Map<LabelValueBean,String> knowledgeAppImpactMap = new LinkedHashMap<LabelValueBean,String>();
		//��ʼ����������
		if(knowledgeAppImpactList!=null && knowledgeAppImpactList.size()>0){
			for(int i=0; i<system_typeList.size();i++){
				for(int j=0; j<knowledgeAppImpactList.size();j++){
					if(system_typeList.get(i).getValue().equals(knowledgeAppImpactList.get(j).getKaicode())){
						knowledgeAppImpactMap.put(system_typeList.get(i), "1");
						break;
					}else{
						knowledgeAppImpactMap.put(system_typeList.get(i), "0");
					}
				}
			}
		}else {
			for(int i=0; i<system_typeList.size();i++){
				knowledgeAppImpactMap.put(system_typeList.get(i), "0");
					
			}
		}
		dto.setKnowledgeAppImpactMap(knowledgeAppImpactMap);
		dto.setKnowledgeAppImpactList(knowledgeAppImpactList);
		return dto;
	}

	/**
	 * ���ܣ�ҵ��ϵͳListȡ��
	 * @param dto
	 * @return dto
	 * @throws BLException
	 */
	public IGKGM03DTO getSystem_typeList(IGKGM03DTO dto) throws BLException {
		List<LabelValueBean> system_typeList = codeListUtils.getCodeList(CodeDefine.getCodeDefine("BUSINESS_SYSTEM_CODE").getCcid(), null, null, false, false);
		dto.setSystem_typeList(system_typeList);
		return dto;
	}

	/**
	 * ���ܣ���������id������������
	 * @param dto
	 * @return dto
	 * @throws BLException
	 */
	public IGKGM03DTO searchProcessRecordByKey(IGKGM03DTO dto) throws BLException {
		IG500Info processRecord = ig500BL
		.searchIG500InfoByKey(Integer.valueOf(dto.getProcessID()));
		
		if(null != processRecord && null != processRecord.getPrtitle()){
			dto.setProcessName(processRecord.getPrtitle());
			
		}
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ��ѯ֪ʶ�����˽�ɫ
	 * </p>
	 * @return IGKGM03DTO
	 * @author leexuzhi@deliverik.com
	 */
	public IGKGM03DTO getRoleKnApproveRole(IGKGM03DTO dto) throws BLException{
		log.debug("========��ѯ֪ʶ�����˽�ɫ��ʼ========");
			RoleSearchCondImpl cond = new RoleSearchCondImpl();
			cond.setRoletype(WorkFlowConstDefine.KNOW_APPROVER_ROLE);
			List<Role> roleList = roleBL.searchRole(cond);
			dto.setRoleList(roleList);
		log.debug("========��ѯ֪ʶ�����˽�ɫ����========");
		return dto;
	}
	
	/**
	 * ���ܣ�֪ʶ����
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO downKnowLedgeAction(IGKGM03DTO dto) throws BLException{
		log.debug("========֪ʶ���ؿ�ʼ========");
		KnowledgeSearchCondImpl cond = new KnowledgeSearchCondImpl();
		cond.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_APPROVEED);//����ͨ��
		//�������ͨ����֪ʶ��Ϣ
		List<KnowLedgeInfo> knList = knowLedgeInfoBL.searchKnowLedgeInfoByCond(cond, 0, 0);
		
		//����HTML����ZIP��
		try{
			ExportHtml.downHtmlsForKn(knList, dto.getSessionID());
		}catch(Exception e){
			log.error("֪ʶ����쳣��", e);
		}
		log.debug("========֪ʶ���ؽ���========");
		return dto;
	}
	
	/**
	 * ���ܣ�֪ʶ��������
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO exportKnowLedgeAction(IGKGM03DTO dto) throws BLException{
		
		//��ȡform
		IGKGM0228Form form = dto.getIgkgm0228Form();
		
		//��Ҫ����֪ʶ��ID����
		String[] knids = form.getKnids();
		
		//��Ҫ����֪ʶ����Ϣ����
		List<Knowledge> knowledgelist = new ArrayList<Knowledge>();
		
		if(knids != null && knids.length > 0){
			for(String knid : knids){
				//��ѯ����
				KnowledgeSearchCondImpl cond = new KnowledgeSearchCondImpl();
				cond.setKnid(Integer.parseInt(knid));
				cond.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_APPROVEED);//����ͨ��
				//�������ͨ����֪ʶ��Ϣ
				Knowledge knowledge = knowledgeBL.searchKnowledgeByByKnid(cond);
				knowledgelist.add(knowledge);
			}
		}
		
		dto.setKnowledgelist(knowledgelist);
		
		return dto;
	}
	
	/**
	 * ���ܣ�֪ʶ����������ҵ��ϵͳ��ѯ
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public String searchKnowLedgeAppImpactAction(Integer knid, Integer knversion) throws BLException{
		
		// ��ȡҵ��ϵͳ����
		KnowledgeAppImpactSearchCondImpl cond = new KnowledgeAppImpactSearchCondImpl();
		cond.setKnid(knid);
		cond.setKnversion(knversion);
		List<KnowledgeAppImpact> kalist = knowledgeAppImpactBL.findKnowledgeAppImpactByCond(cond, 0, 0);
		
		// ҵ��ϵͳ�ַ���
		StringBuffer knareaname = new StringBuffer();
		if(kalist != null && kalist.size() > 0){
			for(KnowledgeAppImpact ka : kalist){
				String str = ka.getKaicode();
				if(StringUtils.isNotEmpty(str) && str.contains("_")){
					knareaname.append(str.split("_")[1]).append(" ");
				}
			}
		}
		
		return knareaname.toString();
	}
	
	
	/**
	 * ת�������ַ�
	 * @param ystr
	 * @return
	 */
	public String getTurnString(String ystr){
		String newstr = null;
		
		if(ystr!=null){
			// ���ַ�ת��byte��
			byte[] argms = ystr.getBytes();
			
			boolean single = true;
			boolean dou = true;
			
			// ת����byte���ַ���
			List<String> linkedturn = new ArrayList<String>();
			
			// 
			for(int i=0;i<argms.length;i++){
				byte untr = argms[i];
				
				// ���˻��з�
				if(untr==new Byte(String.valueOf(13)) || untr==new Byte(String.valueOf(10))){
					
				}
				
				// ���˵�����
				else if(untr==new Byte(String.valueOf(39))){
					if(single){
						linkedturn.add(String.valueOf(-95));
						linkedturn.add(String.valueOf(-82));
					}else{
						linkedturn.add(String.valueOf(-95));
						linkedturn.add(String.valueOf(-81));
					}
					single = !single;
					
				}
				
				//����˫����
				else if(untr==new Byte(String.valueOf(34))){
					if(dou){
						linkedturn.add(String.valueOf(-95));
						linkedturn.add(String.valueOf(-80));
					}else{
						linkedturn.add(String.valueOf(-95));
						linkedturn.add(String.valueOf(-79));
					}
					dou = !dou;
				}
				else{
					linkedturn.add(String.valueOf(untr));
				}
			}
			
			byte[] turnxo = new byte[linkedturn.size()];
			
			for(int i=0;i<linkedturn.size();i++){
				turnxo[i]=new Byte(linkedturn.get(i));
			}
			
			newstr = new String(turnxo);
		}
		try{
			String a1 = new String(newstr.getBytes("ISO8859-1"),"UTF-8");
			String a2 = new String(newstr.getBytes("GBK"),"UTF-8");
			String a3 = new String(newstr.getBytes("UTF-8"),"ISO8859-1");
			String a4 = new String(newstr.getBytes("GBK"),"ISO8859-1");
			String a5 = new String(newstr.getBytes("ISO8859-1"),"GBK");
			String a6 = new String(newstr.getBytes("UTF-8"),"GBK");
			log.debug("***************************************************");
			log.debug(a1+"===="+a2+"===="+a3+"===="+a4+"===="+a5+"===="+a6+"===="+newstr);
			System.out.println(a1+"===="+a2+"===="+a3+"===="+a4+"===="+a5+"===="+a6+"===="+newstr);
			log.debug("***************************************************");
		}catch(Exception e){
			
		}
		return newstr;
	}

	public IGKGM03DTO getKnowledgeCount(IGKGM03DTO dto) throws BLException {
		// TODO Auto-generated method stub
		dto.setCount(knowledgeBL.getSearchCount(dto.getKnowledgeSearchCond()));
		return dto;
	}

	public void setKnowLogBL(KnowLogBL knowLogBL) {
		this.knowLogBL = knowLogBL;
	}

	/**
	 * ֪ʶ����(��ѯ)
	 * @param dto
	 */
	public IGKGM02DTO searchProcessRecordLogAction(IGKGM02DTO dto)
			throws BLException {
		KnowLogSearchCond cond = dto.getKnowLogSearchCond();
		List<KnowLogInfo> recordLogList = knowLogBL.searchKnowLog(cond);
		dto.setRecordList(recordLogList);
		return dto;
	}
	
	/**
	 * ֪ʶ��������ͳ��(��ѯ)
	 * @param dto
	 */
	public IGKGM02DTO searchStatisticalKnowledgeContribution(IGKGM02DTO dto)
			throws BLException {
		IGKGM0231Form form = dto.getIgkgm0231Form();
		KnowledgeStatisticsSearchCondImpl cond = new KnowledgeStatisticsSearchCondImpl();
		List<KnowledgeStatisticsInfo> ksList = this.knowledgeStatisticsBL.searchKnprofferStatistics(cond);
//		String svcXml = "<chart caption='֪ʶ��������ͳ��' subcaption='' palette='3' baseFontSize='12'"+
//				"bgcolor='#FFFFFF' xAxisName='����' showValues='1' decimals='1' formatNumberScale='0' useRoundEdges='1'>";
		String svcXml = "<chart caption='' subcaption='' palette='3' baseFontSize='12' bgAngle='360'  startingAngle='70'"+
				"bgcolor='#FFFFFF' xAxisName='' showValues='1' decimals='1' formatNumberScale='0' useRoundEdges='1'>";
		for (KnowledgeStatisticsInfo ksInfo : ksList) {
			svcXml+= "<set label='"+ksInfo.getKnproffername()+"' value='"+ksInfo.getKlscount()+"' />";
		}
		svcXml+= "<styles>"+
				"<definition>"+
				"<style name='Anim1' type='animation' param='_xscale' start='0' duration='1' />"+
				"<style name='Anim2' type='animation' param='_alpha' start='0' duration='0.6' />"+
				"<style name='DataShadow' type='Shadow' alpha='40'/>"+
				"</definition>"+
				"<application>"+
				"<apply toObject='DIVLINES' styles='Anim1' />"+
				"<apply toObject='HGRID' styles='Anim2' />"+
				"<apply toObject='DATALABELS' styles='DataShadow,Anim2' />"+
				"</application>"+
				"</styles>"+
				"</chart>";
		form.setSvcxml(svcXml);
		return dto;
	}
	
	/**
	 * ��ѯҵ��ϵͳ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGKGM02DTO searchBusinessSystem(IGKGM02DTO dto) throws BLException{
		
		List<CodeDetailDef> list = new ArrayList<CodeDetailDef>();
		if(StringUtils.isNotEmpty(dto.getBusinessSystemSyscoding())){
			
			list = codeDetailDefBL.getFinalBusSys(dto.getBusinessSystemSyscoding());
			
		}else{
			//��ѯҵ��ϵͳ���������һ������
			CodeDetailDefSearchCondImpl cond = new CodeDetailDefSearchCondImpl();
			cond.setPccid("101");
			cond.setPcid("0001");
			 list = codeDetailDefBL.searchCodeDetailDef(cond);
		}
		dto.setBusinessSystemList(list);
		return dto;
	}

}
