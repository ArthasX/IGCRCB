package com.deliverik.infogovernor.sym.bl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeCategoryBL;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.CodeCategoryInfo;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeCategorySearchCondImpl;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.model.entity.CodeCategoryTB;
import com.deliverik.framework.model.entity.CodeDetailTB;
import com.deliverik.framework.model.entity.CodeDetailTBPK;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCondImpl;
import com.deliverik.infogovernor.sym.bl.task.PriorityBL;
import com.deliverik.infogovernor.sym.dto.IGSYM11DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1101Form;
import com.deliverik.infogovernor.sym.form.IGSYM1102Form;
import com.deliverik.infogovernor.sym.form.IGSYM1104Form;
import com.deliverik.infogovernor.sym.form.IGSYM1106Form;
import com.deliverik.infogovernor.sym.model.Priority;
import com.deliverik.infogovernor.sym.model.condition.PrioritySearchCondImpl;
import com.deliverik.infogovernor.sym.model.entity.PriorityTB;

/**
 * �������ݹ���ҵ���߼�ʵ��
 *
 */
public class IGSYM11BLImpl extends BaseBLImpl implements IGSYM11BL {
	
	static Log log = LogFactory.getLog(IGSYM11BLImpl.class);
	
//	public final static int CCID_LENGTH = 3;
//	
//	public final static int CID_LENGTH = 4;
	protected PriorityBL priorityBL;

	public void setPriorityBL(PriorityBL priorityBL) {
		this.priorityBL = priorityBL;
	}

	/** ���ݷ�����ϢBL */
	protected CodeCategoryBL codeCategoryBL;
	
	/** ������ϸ��ϢBL */
	protected CodeDetailBL codeDetailBL;
	
	/** CodeListUtils */
	protected CodeListUtils codeListUtils;
	
	/**���̴���BL*/
	protected WorkFlowOperationBL workFlowOperationBL;
	
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	public void setCodeCategoryBL(CodeCategoryBL codeCategoryBL) {
		this.codeCategoryBL = codeCategoryBL;
	}

	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	public void setCodeListUtils(CodeListUtils codeListUtils) {
		this.codeListUtils = codeListUtils;
	}

	
	
	
	/**
	 * ���ݷ�����Ϣ��ѯ����
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO initIGSYM1101Action(IGSYM11DTO dto) throws BLException {

		log.debug("========���ݷ�����Ϣ��ѯ����ʼ========");
		
		CodeCategorySearchCondImpl cond = new CodeCategorySearchCondImpl();
		cond.setTree(true);
		int totalCount = this.codeCategoryBL.getSearchCount(cond);

		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		
		//���ݷ�����Ϣȡ��
		List<CodeCategoryInfo> codeCategoryInfoList = 
			this.codeCategoryBL.searchCodeCategoryPaging(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setCodeCategoryInfoList(codeCategoryInfoList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========���ݷ�����Ϣ��ѯ��������========");
		return dto;
	}

	/**
	 * ���ݷ���ɾ������
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO deleteIGSYM1101Action(IGSYM11DTO dto) throws BLException {
		IGSYM1101Form form = dto.getIgsym1101Form();
		
		//�������Ƿ����ڱ�δ�رյ��Զ�������ʹ�ã�δʹ�ÿ�ɾ��
		//boolean psi_delFlag = true;//���̱������Ƿ�ʹ���˸�����ʹ���˲���ɾ��
		boolean psid_delFlag = false;//���̱���������Ƿ�ʹ���˸�����ʹ���˲���ɾ��
		
		//��ѯIG007���Ƿ����pidtype=T�ļ�¼,�����������ɾ��
		IG007SearchCondImpl pidcond = new IG007SearchCondImpl();
		pidcond.setPidtype(IGPRDCONSTANTS.PROCESSVAR_TREE_TYPE);
		List<IG007Info> pidList = this.workFlowOperationBL.searchProcessInfoDefByCond(pidcond);
		
		if(pidList!=null && pidList.size()>0){
			for(IG007Info pid:pidList){
				String pidccid = pid.getCcid();
				//���̱���������Ƿ�ʹ���˸�����ʹ���˲���ɾ��
				if(pidccid!=null && form.getCcid().equals(pidccid.split("_tree_")[0])){
					psid_delFlag = true;
					break;
				}
				
			}
		}
		
		if(psid_delFlag){
			throw new BLException("IGSYM1101.E003");
		}
		
		
//		//��ѯProcessInfo���Ƿ����Pivartype=T�ļ�¼��prid�������Ƿ��Ѿ��رգ�prstatus�Ƿ�ΪC��,δ�ر��򲻿���ɾ��
//		ProcessInfoSearchCondImpl picond = new ProcessInfoSearchCondImpl();
//		picond.setPivartype(IGPRDCONSTANTS.PROCESSVAR_TREE_TYPE);
//		List<ProcessInfo> piList = this.workFlowOperationBL.searchProcessInfoByCond(picond);
//		for(ProcessInfo pi:piList){
//			Integer prid = pi.getPrid();
//			//String varvalue = pi.getPivarvalue();// || (varvalue!=null && form.getCcid().equals(varvalue.split("_tree_")[0].substring(0, 3)))
//			
//			ProcessRecord pr = this.workFlowOperationBL.searchProcessRecordByKey(prid);
//			//����δ�ر��򲻿�ɾ��
//			if(!IGPRDCONSTANTS.PROCESS_END_STATUS.equals(pr.getPrstatus())){
//				delFlag = false;
//				break;
//			}
//		}
//		if(!delFlag){
//			throw new BLException("IGSYM1101.E003");
//		}
//		
		
		
		
		this.codeCategoryBL.deleteCodeCategory(form.getCcid());
		
		dto.addMessage(new ActionMessage("IGSYM1101.I004"));
		
		return dto;
	}
	
	/**
	 * ���ݷ�����������
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO saveIGSYM1107Action(IGSYM11DTO dto) throws BLException {
		log.debug("========���ݷ�����������ʼ========");
		IGSYM1101Form form = dto.getIgsym1101Form();
		
		//���CCID
		CodeCategoryInfo cci = this.codeCategoryBL.searchCodeCategoryByPK(form.getCcid());
		if(cci!=null){
			throw new BLException("IGSYM1107.E001");
		}
		
		//��������һ������
		CodeCategoryTB cctb = new CodeCategoryTB();
		cctb.setCcid(form.getCcid());//���ݷ���ID
		cctb.setCcname(form.getCcname());
		cctb.setCcinfo(form.getCcinfo());
		cctb.setCceditable("3");//3����ǻ������ݣ���ɾ��
		cctb.setPcflag("4");//��������֧��4��Ŀ¼
		
		CodeCategoryInfo cc = this.codeCategoryBL.registCodeCategory(cctb);
		
		//���Ӹ����ݷ�����¼��ӷ��ࣨ����������⣩����Ϊ֧�ֵ�4����������Ҫ����3���ּ���¼
		
		//����1��
		CodeCategoryInfo cc1 = getCodeCategoryTB(cc,"һ������","һ������");
		//����2��
		CodeCategoryInfo cc2 = getCodeCategoryTB(cc1,"��������","��������");
		//����3��
		@SuppressWarnings("unused")
		CodeCategoryInfo cc3 = getCodeCategoryTB(cc2,"��������","��������");
		
		
		dto.addMessage(new ActionMessage("IGSYM1101.I003"));
		log.debug("========���ݷ���������������========");
		return dto;
	}
	
	/**
	 * ���ݷ����¼���������
	 */
	private CodeCategoryInfo getCodeCategoryTB(CodeCategoryInfo cci,String ccname,String ccinfo) throws BLException {
		
		Integer id = Integer.valueOf(cci.getCcid());
		
		while(true){
			if(id==999){
				throw new BLException("IGSYM1107.E002");
			}
			id++;
			CodeCategoryInfo temp_cc = this.codeCategoryBL.searchCodeCategoryByPK(String.valueOf(id));
			if(temp_cc==null){
				break;
			}
		}
		
		String temp_id = "";
		String tmp = String.valueOf(id);
		if(tmp.length()==1){
			temp_id = "00"+tmp;
		}else if(tmp.length()==2){
			temp_id = "0"+tmp;
		}else{
			temp_id = tmp;
		}
		
		CodeCategoryTB cctb1 = new CodeCategoryTB();
		cctb1.setCcid(temp_id);
		cctb1.setCcname(ccname);
		cctb1.setCcinfo(ccinfo);
		cctb1.setCceditable("3");//3����ǻ������ݣ���ɾ��
		cctb1.setPcflag("4");//��������֧��4��Ŀ¼
		cctb1.setPccid(cci.getCcid());//����ccid
		
		CodeCategoryInfo cci1 = this.codeCategoryBL.registCodeCategory(cctb1);
		
		return cci1;
	}
	
	
	/**
	 * ���ݷ���ǼǴ���
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO insertCodeCategoryAction(IGSYM11DTO dto) throws BLException {
		log.debug("========���ݷ���ǼǴ���ʼ========");
		
		this.codeCategoryBL.registCodeCategory(dto.getIgsym1102Form());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "���ݷ�����Ϣ") );

		log.debug("========���ݷ���ǼǴ�������========");
		return dto;
	}
	
	/**
	 * ���ݷ���༭���������ʾ
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO initIGSYM1102Action(IGSYM11DTO dto) throws BLException {
		log.debug("========���ݷ���༭���������ʾ����ʼ========");
		
		IGSYM1102Form form = dto.getIgsym1102Form();
		String ccid = form.getCcid();
		
		CodeCategoryInfo codeCategoryInfo = this.codeCategoryBL.searchCodeCategoryByPK(ccid);
		
		if ( codeCategoryInfo == null ){
			throw new BLException("IGCO10000.E004","����������ݷ���");
		}
		
		form.setCcname(codeCategoryInfo.getCcname());
		form.setCcinfo(codeCategoryInfo.getCcinfo());
		form.setCceditable(codeCategoryInfo.getCceditable());
		form.setMode("1");
		
		dto.setIgsym1102Form(form);
		
		log.debug("========���ݷ���༭���������ʾ��������========");
		return dto;
	}
	
	/**
	 * ���ݷ���������
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO updateCodeCategoryAction(IGSYM11DTO dto) throws BLException {
		log.debug("========���ݷ���������ʼ========");
		this.codeCategoryBL.updateCodeCategory(dto.getIgsym1102Form());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "���ݷ�����Ϣ") );
		
		log.debug("========���ݷ�������������========");
		return dto;
	}
	
	/**
	 * ������Ϣ��ϸ���������ʾ
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO initIGSYM1106Action(IGSYM11DTO dto) throws BLException {
		log.debug("========������ϸ��Ϣ���������ʾ����ʼ========");
		
		IGSYM1106Form form = dto.getIgsym1106Form();
		
		//���ݷ�����Ϣ��ѯ
		CodeCategoryInfo codeCategoryInfo = 
			this.codeCategoryBL.searchCodeCategoryByPK(form.getCcid());
		
		CodeDetailTBPK pk = new CodeDetailTBPK();
		pk.setCcid(form.getCcid());
		pk.setCid(form.getCid());
		//������ϸ��Ϣ��ѯ
		CodeDetail codeDetail = this.codeDetailBL.searchCodeDetailByPK(pk);
		
		//������ϸ��Ϣ��ѯ
		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
		if("1".equals(form.getClevel())){
			cond.setCcid(form.getCcid());
			codeDetail= null;
		}else{
			cond.setPccid(form.getCcid());
			cond.setPcid(form.getCid());
		}
		List<CodeDetail> codeDetailList = 
			this.codeDetailBL.searchCodeDetail(cond,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
		
		dto.setCodeCategoryInfo(codeCategoryInfo);
		dto.setCodeDetailList(codeDetailList);
		dto.setCodeDetail(codeDetail);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",codeDetailList.size()));

		log.debug("========������ϸ��Ϣ���������ʾ��������========");
		return dto;
	}
	/**
	 * ������Ϣ��ϸ���淵����ʾ
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO initIGSYM1106BackAction(IGSYM11DTO dto) throws BLException {
	log.debug("========������ϸ��Ϣ���������ʾ����ʼ========");
		
		IGSYM1106Form form = dto.getIgsym1106Form();
		
		CodeDetailTBPK pkey = new CodeDetailTBPK();
		pkey.setCcid(form.getCcid());
		pkey.setCid(form.getCid());
		//������ϸ��Ϣ��ѯ
		CodeDetail pcodeDetail = this.codeDetailBL.searchCodeDetailByPK(pkey);
		//������ϸ��Ϣ��ѯ
		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
		//���ݷ�����Ϣ��ѯ
		CodeCategoryInfo codeCategoryInfo = 
			this.codeCategoryBL.searchCodeCategoryByPK(pcodeDetail.getPccid());
		
		if(codeCategoryInfo==null){
			dto.setCodeDetail(null);
			form.setClevel("1");
		}else{
			CodeDetailTBPK pk = new CodeDetailTBPK();
			pk.setCcid(pcodeDetail.getPccid());
			pk.setCid(pcodeDetail.getPcid());
			//������ϸ��Ϣ��ѯ
			CodeDetail codeDetail = this.codeDetailBL.searchCodeDetailByPK(pk);
			dto.setCodeDetail(codeDetail);
		}
		if(codeCategoryInfo==null){
			codeCategoryInfo = 
				this.codeCategoryBL.searchCodeCategoryByPK(pcodeDetail.getCcid());
			cond.setCcid(pcodeDetail.getCcid());
		}else{
			cond.setPccid(pcodeDetail.getPccid());
			cond.setPcid(pcodeDetail.getPcid());
		}
		
		
		List<CodeDetail> codeDetailList = 
			this.codeDetailBL.searchCodeDetail(cond,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
		
		dto.setCodeCategoryInfo(codeCategoryInfo);
		dto.setCodeDetailList(codeDetailList);
		dto.addMessage(new ActionMessage("IGCO10000.I002",codeDetailList.size()));

		log.debug("========������ϸ��Ϣ���������ʾ��������========");
		return dto;
	}
	

	/**
	 * ������Ϣɾ������
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO deleteCodeDetailAction(IGSYM11DTO dto) throws BLException {
		log.debug("========������Ϣɾ������ʼ========");
		CodeDetailTBPK pk = new CodeDetailTBPK();
		
		pk.setCcid(dto.getIgsym1106Form().getTempccid());
		pk.setCid(dto.getIgsym1106Form().getTempcid());
		CodeDetailTB codeDetailTB = (CodeDetailTB)this.codeDetailBL.searchCodeDetailByPK(pk);
		String cdstatus = "1" ;
		if("1".equals(dto.getIgsym1106Form().getCdstatus())){
			checkStop(dto.getIgsym1106Form().getTempccid(), dto.getIgsym1106Form().getTempcid());
			cdstatus = "0";
		}
		codeDetailTB.setCdstatus(cdstatus);
		
		this.codeDetailBL.updateCodeDetail(codeDetailTB);
		
		//Cache����
//		codeListUtils.updateCodeDetailCache(codeDetail.getCcid(), codeDetail.getPccid(),
//				codeDetail.getPcid());
		if("1".equals(cdstatus)){
			dto.addMessage(new ActionMessage( "IGSYM1101.I002", "����") );
		}else{
			dto.addMessage(new ActionMessage( "IGSYM1101.I001", "����") );
		}

		log.debug("========������Ϣɾ����������========");
		return dto;
	}
	
	/**
	 * ������Ϣ�༭���������ʾ
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO initIGSYM1104Action(IGSYM11DTO dto) throws BLException {
		log.debug("========������Ϣ�༭���������ʾ����ʼ========");
		IGSYM1104Form form = dto.getIgsym1104Form();
		
		CodeDetailTBPK pk = new CodeDetailTBPK();
		pk.setCcid(form.getCcid());
		pk.setCid(form.getCid());
		
		CodeDetailTB codeDetail = 
			(CodeDetailTB)this.codeDetailBL.searchCodeDetailByPK(pk);
		
		if (codeDetail==null) {
			throw new BLException("IGCO10000.E004","�����������");
		}
		
		//����������Ϣȡ��
		if (StringUtils.isNotEmpty(codeDetail.getPccid())
				&& StringUtils.isNotEmpty(codeDetail.getPcid())) {
			CodeDetailTBPK ppk = new  CodeDetailTBPK();
			ppk.setCcid(codeDetail.getPccid());
			ppk.setCid(codeDetail.getPcid());
			
			CodeDetailTB pCodeDetail = 
				(CodeDetailTB)this.codeDetailBL.searchCodeDetailByPK(ppk);
			
			if (pCodeDetail != null) {
				//����������Ϣ������,���������趨
				form.setPccname(pCodeDetail.getCodeCategory().getCcname());
				form.setPcvalue(pCodeDetail.getCvalue());				
			}
			
		}else{
			form.setPcvalue("");				
		}
		form.setCvalue(codeDetail.getCvalue());
		form.setPccid(codeDetail.getPccid());
		form.setPcid(codeDetail.getPcid());
		form.setCcname(codeDetail.getCodeCategory().getCcname());
		if(StringUtils.isEmpty(codeDetail.getPccid())){
			form.setClevel("1");
		}
		form.setPsyscoding(codeDetail.getPsyscoding());
		form.setSyscoding(codeDetail.getSyscoding());
		form.setCdstatus(codeDetail.getCdstatus());
		form.setBusinesscode(codeDetail.getBusinesscode());
		form.setMode("1");
		
		dto.setIgsym1104Form(form);
		
		log.debug("========������Ϣ�༭���������ʾ��������========");
		
		return dto;
	}
	
	/**
	 * ������Ϣ�ǼǴ���
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO insertCodeDetailAction(IGSYM11DTO dto) throws BLException {
		
		log.debug("========������Ϣ�ǼǴ���ʼ========");

		IGSYM1104Form form = dto.getIgsym1104Form();
		String syscoding = null;
		if(!"1".equals(form.getClevel())){
			CodeCategorySearchCondImpl cond = new CodeCategorySearchCondImpl();
			cond.setPccid(form.getCcid());
			List<CodeCategoryInfo> list = this.codeCategoryBL.searchCodeCategory(cond);
			form.setCcid(list.get(0).getCcid());
			syscoding = this.codeDetailBL.getSyscoding(form.getPsyscoding());
			if(syscoding == null){
				syscoding = getSyscoding(form.getPsyscoding()+StringUtils.leftPad("0", CommonDefineUtils.TREE_LEVEL_CODE , "0"),CommonDefineUtils.TREE_LEVEL_CODE);
			}else{
				syscoding = getSyscoding(syscoding,CommonDefineUtils.TREE_LEVEL_CODE);
			}
		}else{
			form.setPccid(null);
			syscoding = this.codeDetailBL.getSyscodingLevel1(form.getCcid());
			if(syscoding == null){
				syscoding = getSyscoding(form.getCcid()+StringUtils.leftPad("0", CommonDefineUtils.TREE_LEVEL_CODE , "0"),CommonDefineUtils.TREE_LEVEL_CODE);
			}else{
				syscoding = getSyscoding(syscoding,CommonDefineUtils.TREE_LEVEL_CODE);
			}
		}
		form.setSyscoding(syscoding);
		form.setCdstatus("1");
		checkParCodeDetail(form.getPccid(),form.getPcid());
		String tempcid = this.codeDetailBL.getMaxcid(form.getCcid());
		if(tempcid==null){
			form.setCid(getCid(StringUtils.leftPad("0", CommonDefineUtils.CID_LENGTH , "0"), CommonDefineUtils.CID_LENGTH));
		}else{
			form.setCid(getCid(tempcid, CommonDefineUtils.CID_LENGTH));
		}
		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		form.setUpdtime(datetime);
		this.codeDetailBL.registCodeDetail(form);
		
		
//		//Cache����
//		codeListUtils.updateCodeDetailCache(form.getCcid(), form.getPccid(), 
//				form.getPcid());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "����") );

		log.debug("========������Ϣ�ǼǴ�������========");

		return dto;
	}
	
	/**
	 * ��ȡ��ǰ���ֵ��1���ַ��������㳤�Ȳ�0
	 * 
	 * @param syscoding ��ǰ����ַ���
	 * @param length ����
	 * @return
	 */
	private String getSyscoding(String syscoding ,int length) throws BLException {
		String temp = syscoding.substring(syscoding.length()-length);
		if(temp.equals("999")){
			throw new BLException("IGSYM1101.E002","����");
		}
		return syscoding.substring(0, syscoding.length()-length)+StringUtils.leftPad(Integer.valueOf(temp)+1+"", length , "0");
	}
	
	/**
	 * ��ȡ��ǰ���ֵ��1���ַ��������㳤�Ȳ�0
	 * 
	 * @param cid ��ǰ����ַ���
	 * @param length ����
	 * @param flag �Ƿ�ƴ��Դ�ַ���
	 * @return
	 */
	private String getCid(String cid ,int length) throws BLException {
		Integer temp = new Integer(cid);
		if(temp == 9999){
			throw new BLException("IGSYM1101.E002","����");
		}
		return StringUtils.leftPad(temp + 1 + "", length , "0");
	}
	
	/**
	 * ������Ϣ���´���
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO updateCodeDetailAction(IGSYM11DTO dto) throws BLException {
		log.debug("========������Ϣ���´���ʼ========");
		
		IGSYM1104Form form = dto.getIgsym1104Form();
		if("1".equals(form.getClevel())){
			form.setPccid(null);
			checkParCodeDetail(form.getPccid(),form.getPcid());
		}else{
		}
		if (form.getCcid().equals(form.getPccid()) && 
				form.getCid().equals(form.getPcid())) {
			throw new BLException("IGSYM1104.E002");
		}
		
		
		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		form.setUpdtime(datetime);

		this.codeDetailBL.updateCodeDetail(form);
		
		//Cache����
//		codeListUtils.updateCodeDetailCache(form.getCcid(), form.getPccid(), 
//				form.getPcid());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "����") );

		log.debug("========������Ϣ���´�������========");
		return dto;
	}
	
	/**
	 * У���ϼ��Ƿ����
	 *
	 * @param ccid 
	 * @param cid 
	 */
	protected void checkParCodeDetail(String ccid,String cid) throws BLException {
		if (StringUtils.isNotEmpty(ccid)) {
			if (StringUtils.isNotEmpty(cid)) {
				CodeDetailTBPK pk = new CodeDetailTBPK();
				
				pk.setCcid(ccid);
				pk.setCid(cid);
				
				CodeDetail codeDetail = 
					this.codeDetailBL.searchCodeDetailByPK(pk);
				
				if (codeDetail == null) {
					throw new BLException("IGCO10000.E004","������������");
				}
				
			} else {
				throw new BLException("IGSYM1104.E001","���ݱ��(��)");
			}
		} else {
			if (StringUtils.isNotEmpty(cid)) {
				throw new BLException("IGSYM1104.E001","���ݷ�����(��)");
			}
		}
	}
	
	/**
	 * У���Ƿ��¼��Ƿ���δͣ�õ�����
	 *
	 * @param ccid
	 * @param cid
	 */
	protected void checkStop(String ccid,String cid) throws BLException {
		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
		cond.setPccid(ccid);
		cond.setPcid(cid);
		cond.setCdstatus("1");
		List<CodeDetail> codeDetailList = 
			this.codeDetailBL.searchCodeDetail(cond, 2);//������
		if (!codeDetailList.isEmpty()) {
			throw new BLException("IGSYM1101.E001");
		}
	}
	/**
	 * ȡ������Ӱ��ȼ���������Ϣ
	 *
	 * @param IGSYM11DTO
	 * @param 
	 */
	public IGSYM11DTO getPrimpactAndPrurgency(IGSYM11DTO dto) throws BLException {
		List<CodeDetail> primpactList = null;  //Ӱ��̶�
		List<CodeDetail> prurgencyList = null; //�����̶�

		if("I".equals(dto.getIgsym1109Form().getPprtype())){
			CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
			cond.setCcid("101");
			primpactList = this.codeDetailBL.searchCodeDetail(cond, 1);//Ӱ��̶�
			cond.setCcid("119");
			prurgencyList = this.codeDetailBL.searchCodeDetail(cond, 1);//�����̶�
		}
		if(primpactList == null){
			primpactList = new ArrayList<CodeDetail>();
		}
		if(prurgencyList == null){
			prurgencyList = new ArrayList<CodeDetail>();
		}
		dto.setPrimpactList(primpactList);//Ӱ��̶�
		dto.setPrurgencyList(prurgencyList);//�����̶�
		return dto;
	}
	/**
	 * �������ȼ���������
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO findByPriorityCond(IGSYM11DTO dto) throws BLException {
    	PrioritySearchCondImpl cond = new PrioritySearchCondImpl(); 
    	cond.setIvalue(dto.getIvalue());
    	cond.setPprtype(dto.getPprtype());
    	cond.setUvalue(dto.getUvalue());
		List<Priority> prioritieList = this.priorityBL.findByCond(cond, 0, 0);
		dto.setPrioritieList(prioritieList);
		return dto;
	}
	/**
	 * �������ȼ���������
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public void savePriority(IGSYM11DTO dto) throws BLException {
		List<CodeDetail> primpactList = dto.getPrimpactList();  //Ӱ��̶�
		List<CodeDetail> prurgencyList = dto.getPrurgencyList(); //�����̶�
		String[][] prioritys = dto.getIgsym1109Form().getPvalues();

		for(int i=0;i<primpactList.size();i++){
			CodeDetail primpact = primpactList.get(i);
			for(int j=0;j<prurgencyList.size();j++){
				CodeDetail	prurgency = prurgencyList.get(j);
				PriorityTB ptb = new PriorityTB();
				ptb.setIvalue(primpact.getCid());
				ptb.setUvalue(prurgency.getCid());
				ptb.setPprtype(dto.getPprtype());
				ptb.setPvalue(prioritys[i][j]);
				this.priorityBL.savePriority(ptb);
			}
		}
	}
}
