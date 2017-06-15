package com.deliverik.infogovernor.sym.bl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeCategoryDefBL;
import com.deliverik.framework.bl.CodeDetailDefBL;
import com.deliverik.framework.model.CodeCategoryDefInfo;
import com.deliverik.framework.model.CodeDetailDef;
import com.deliverik.framework.model.condition.CodeCategoryDefSearchCondImpl;
import com.deliverik.framework.model.condition.CodeDetailDefSearchCondImpl;
import com.deliverik.framework.model.entity.CodeCategoryDefTB;
import com.deliverik.framework.model.entity.CodeDetailDefTB;
import com.deliverik.framework.model.entity.CodeDetailDefTBPK;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCondImpl;
import com.deliverik.infogovernor.sym.dto.IGSYM15DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1501Form;
import com.deliverik.infogovernor.sym.form.IGSYM1502Form;
import com.deliverik.infogovernor.sym.form.IGSYM1503Form;

/**
 * �������ݹ���ҵ���߼�ʵ��
 *
 */
public class IGSYM15BLImpl extends BaseBLImpl implements IGSYM15BL {
	
	static Log log = LogFactory.getLog(IGSYM15BLImpl.class);
	
//	public final static int CCID_LENGTH = 3;
//	
//	public final static int CID_LENGTH = 4;

	/** ���ݷ�����ϢBL */
	protected CodeCategoryDefBL codeCategoryDefiBL;
	
	/** ������ϸ��ϢBL */
	protected CodeDetailDefBL codeDetailDefBL;
	
	/** CodeListUtils */
	protected CodeListUtils codeListUtils;
	
	/**���̴���BL*/
	protected WorkFlowOperationBL workFlowOperationBL;
	
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	

	

	public void setCodeListUtils(CodeListUtils codeListUtils) {
		this.codeListUtils = codeListUtils;
	}

	
	
	
	/**
	 * ���ݷ�����Ϣ��ѯ����
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO initIGSYM1501Action(IGSYM15DTO dto) throws BLException {

		log.debug("========���ݷ�����Ϣ��ѯ����ʼ========");
		
		CodeCategoryDefSearchCondImpl cond = new CodeCategoryDefSearchCondImpl();
		cond.setTree(true);
		int totalCount = this.codeCategoryDefiBL.getSearchCount(cond);

		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		
		//���ݷ�����Ϣȡ��
		List<CodeCategoryDefInfo> codeCategoryInfoList = 
			this.codeCategoryDefiBL.searchCodeCategoryDefPaging(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setCodeCategoryDefInfoList(codeCategoryInfoList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========���ݷ�����Ϣ��ѯ��������========");
		return dto;
	}

	/**
	 * ���ݷ���ɾ������
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO deleteIGSYM1501Action(IGSYM15DTO dto) throws BLException {
		IGSYM1501Form form = dto.getIgsym1501Form();
		
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
		
		
		for(int i = 0; i < 4; i++){
			String ccid = String.valueOf((Integer.parseInt(form.getCcid())+i));
			this.codeCategoryDefiBL.deleteCodeCategoryDef(ccid);
		}
		
		
		dto.addMessage(new ActionMessage("IGSYM1101.I004"));
		
		return dto;
	}
	
	/**
	 * ���ݷ�����������
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO saveIGSYM11501Action(IGSYM15DTO dto) throws BLException {
		log.debug("========���ݷ�����������ʼ========");
		IGSYM1501Form form = dto.getIgsym1501Form();
		CodeCategoryDefSearchCondImpl cond = new CodeCategoryDefSearchCondImpl();
		List<CodeCategoryDefInfo> infoList = this.codeCategoryDefiBL.searchCodeCategoryDefDescCiid(cond, 0, 1);
		String ccid = "";
		if(infoList == null || infoList.size() == 0){
			ccid = "100";
		}else{
			ccid = infoList.get(0).getCcid();
		}
		//���CCID
//		CodeCategoryDefInfo cci = this.codeCategoryDefiBL.searchCodeCategoryDefByPK(form.getCcid());
//		if(cci!=null){
//			throw new BLException("IGSYM1107.E001");
//		}
		ccid = getNewCcid(ccid);
		//��������һ������
		CodeCategoryDefTB cctb = new CodeCategoryDefTB();
		cctb.setCcid(ccid);//���ݷ���ID
		cctb.setCcname(form.getCcname());
		cctb.setCcinfo(form.getCcinfo());
		cctb.setCceditable("3");//3����ǻ������ݣ���ɾ��
		cctb.setPcflag("4");//��������֧��4��Ŀ¼
		
		CodeCategoryDefInfo cc = this.codeCategoryDefiBL.registCodeCategoryDef(cctb);
		
		//���Ӹ����ݷ�����¼��ӷ��ࣨ����������⣩����Ϊ֧�ֵ�4����������Ҫ����3���ּ���¼
		
		//����1��
		CodeCategoryDefInfo cc1 = getCodeCategoryDefTB(cc,"һ������","һ������");
		//����2��
		CodeCategoryDefInfo cc2 = getCodeCategoryDefTB(cc1,"��������","��������");
		//����3��
		@SuppressWarnings("unused")
		CodeCategoryDefInfo cc3 = getCodeCategoryDefTB(cc2,"��������","��������");
		
		
		dto.addMessage(new ActionMessage("IGSYM1101.I003"));
		log.debug("========���ݷ���������������========");
		return dto;
	}
	
	/**
	 * ���ݷ����¼���������
	 */
	private CodeCategoryDefInfo getCodeCategoryDefTB(CodeCategoryDefInfo cci,String ccname,String ccinfo) throws BLException {
		
		Integer id = Integer.valueOf(cci.getCcid());
		
		while(true){
			if(id==999){
				throw new BLException("IGSYM1107.E002");
			}
			id++;
			CodeCategoryDefInfo temp_cc = this.codeCategoryDefiBL.searchCodeCategoryDefByPK(String.valueOf(id));
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
		
		CodeCategoryDefTB cctb1 = new CodeCategoryDefTB();
		cctb1.setCcid(temp_id);
		cctb1.setCcname(ccname);
		cctb1.setCcinfo(ccinfo);
		cctb1.setCceditable("3");//3����ǻ������ݣ���ɾ��
		cctb1.setPcflag("4");//��������֧��4��Ŀ¼
		cctb1.setPccid(cci.getCcid());//����ccid
		
		CodeCategoryDefInfo cci1 = this.codeCategoryDefiBL.registCodeCategoryDef(cctb1);
		
		return cci1;
	}
	
	
	/**
	 * ���ݷ���ǼǴ���
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO insertCodeCategoryDefAction(IGSYM15DTO dto) throws BLException {
		log.debug("========���ݷ���ǼǴ���ʼ========");
		
		this.codeCategoryDefiBL.registCodeCategoryDef(dto.getIgsym1507Form());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "���ݷ�����Ϣ") );

		log.debug("========���ݷ���ǼǴ�������========");
		return dto;
	}
	
	/**
	 * ���ݷ���༭���������ʾ
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
//	public IGSYM15DTO initIGSYM1102Action(IGSYM15DTO dto) throws BLException {
//		log.debug("========���ݷ���༭���������ʾ����ʼ========");
//		
//		IGSYM1507Form form = dto.getIgsym1507Form();
//		String ccid = form.getCcid();
//		
//		CodeCategoryDefInfo codeCategoryInfo = this.codeCategoryDefiBL.searchCodeCategoryDefByPK(ccid);
//		
//		if ( codeCategoryInfo == null ){
//			throw new BLException("IGCO10000.E004","����������ݷ���");
//		}
//		
//		form.setCcname(codeCategoryInfo.getCcname());
//		form.setCcinfo(codeCategoryInfo.getCcinfo());
//		form.setCceditable(codeCategoryInfo.getCceditable());
//		form.setMode("1");
//		
//		dto.setIgsym1507Form(form);
//		
//		log.debug("========���ݷ���༭���������ʾ��������========");
//		return dto;
//	}
	
	/**
	 * ���ݷ���������
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO updateCodeCategoryDefAction(IGSYM15DTO dto) throws BLException {
		log.debug("========���ݷ���������ʼ========");
		this.codeCategoryDefiBL.updateCodeCategoryDef(dto.getIgsym1507Form());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "���ݷ�����Ϣ") );
		
		log.debug("========���ݷ�������������========");
		return dto;
	}
	
	/**
	 * ������Ϣ��ϸ���������ʾ
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO initIGSYM1502Action(IGSYM15DTO dto) throws BLException {
		log.debug("========������ϸ��Ϣ���������ʾ����ʼ========");
		
		IGSYM1502Form form = dto.getIgsym1502Form();
		
		//���ݷ�����Ϣ��ѯ
		CodeCategoryDefInfo codeCategoryInfo = 
			this.codeCategoryDefiBL.searchCodeCategoryDefByPK(form.getCcid());
		
		CodeDetailDefTBPK pk = new CodeDetailDefTBPK();
		pk.setCcid(form.getCcid());
		pk.setCid(form.getCid());
		//������ϸ��Ϣ��ѯ
		CodeDetailDef codeDetail = this.codeDetailDefBL.searchCodeDetailDefByPK(pk);
		
		//������ϸ��Ϣ��ѯ
		CodeDetailDefSearchCondImpl cond = new CodeDetailDefSearchCondImpl();
		if("1".equals(form.getClevel())){
			cond.setCcid(form.getCcid());
			codeDetail= null;
		}else{
			cond.setPccid(form.getCcid());
			cond.setPcid(form.getCid());
		}
		List<CodeDetailDef> codeDetailList = 
			this.codeDetailDefBL.searchCodeDetailDef(cond,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
		
		dto.setCodeCategoryDefInfo(codeCategoryInfo);
		dto.setCodeDetailDefList(codeDetailList);
		dto.setCodeDetailDef(codeDetail);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",codeDetailList.size()));

		log.debug("========������ϸ��Ϣ���������ʾ��������========");
		return dto;
	}
	
	/**
	 * ������Ϣ��ϸ���淵����ʾ
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO initIGSYM1502BackAction(IGSYM15DTO dto) throws BLException {
	log.debug("========������ϸ��Ϣ���������ʾ����ʼ========");
		
		IGSYM1502Form form = dto.getIgsym1502Form();
		
		CodeDetailDefTBPK pkey = new CodeDetailDefTBPK();
		pkey.setCcid(form.getCcid());
		pkey.setCid(form.getCid());
		//������ϸ��Ϣ��ѯ
		CodeDetailDef pcodeDetail = this.codeDetailDefBL.searchCodeDetailDefByPK(pkey);
		//������ϸ��Ϣ��ѯ
		CodeDetailDefSearchCondImpl cond = new CodeDetailDefSearchCondImpl();
		//���ݷ�����Ϣ��ѯ
		CodeCategoryDefInfo codeCategoryInfo = 
			this.codeCategoryDefiBL.searchCodeCategoryDefByPK(pcodeDetail.getPccid());
		
		if(codeCategoryInfo==null){
			dto.setCodeDetailDef(null);
			form.setClevel("1");
		}else{
			CodeDetailDefTBPK pk = new CodeDetailDefTBPK();
			pk.setCcid(pcodeDetail.getPccid());
			pk.setCid(pcodeDetail.getPcid());
			//������ϸ��Ϣ��ѯ
			CodeDetailDef codeDetail = this.codeDetailDefBL.searchCodeDetailDefByPK(pk);
			dto.setCodeDetailDef(codeDetail);
		}
		if(codeCategoryInfo==null){
			codeCategoryInfo = 
				this.codeCategoryDefiBL.searchCodeCategoryDefByPK(pcodeDetail.getCcid());
			cond.setCcid(pcodeDetail.getCcid());
		}else{
			cond.setPccid(pcodeDetail.getPccid());
			cond.setPcid(pcodeDetail.getPcid());
		}
		
		
		List<CodeDetailDef> codeDetailList = 
			this.codeDetailDefBL.searchCodeDetailDef(cond,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
		
		dto.setCodeCategoryDefInfo(codeCategoryInfo);
		dto.setCodeDetailDefList(codeDetailList);
		dto.addMessage(new ActionMessage("IGCO10000.I002",codeDetailList.size()));

		log.debug("========������ϸ��Ϣ���������ʾ��������========");
		return dto;
	}
	

	/**
	 * ������Ϣɾ������
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO deleteCodeDetailDefAction(IGSYM15DTO dto) throws BLException {
		log.debug("========������Ϣɾ������ʼ========");
		CodeDetailDefTBPK pk = new CodeDetailDefTBPK();
		
		pk.setCcid(dto.getIgsym1502Form().getTempccid());
		pk.setCid(dto.getIgsym1502Form().getTempcid());
		CodeDetailDefTB codeDetailTB = (CodeDetailDefTB)this.codeDetailDefBL.searchCodeDetailDefByPK(pk);
		String cdstatus = "1" ;
		if("1".equals(dto.getIgsym1502Form().getCdstatus())){
			checkStop(dto.getIgsym1502Form().getTempccid(), dto.getIgsym1502Form().getTempcid());
			cdstatus = "0";
		}
		codeDetailTB.setCdstatus(cdstatus);
		
		this.codeDetailDefBL.updateCodeDetailDef(codeDetailTB);
		
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
	 * ������Ϣɾ������
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO realdeleteCodeDetailDefAction(IGSYM15DTO dto) throws BLException {
		log.debug("========��������ɾ������ʼ========");
		
		IGSYM1502Form form = dto.getIgsym1502Form();
		
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
				if(pidccid!=null && form.getTempccid().equals(pidccid.split("_tree_")[0])){
					psid_delFlag = true;
					break;
				}
				
			}
		}
		
		if(psid_delFlag){
			throw new BLException("IGSYM1101.E003");
		}
		CodeDetailDefSearchCondImpl condImpl = new CodeDetailDefSearchCondImpl();
		condImpl.setSyscoding(form.getSyscoding());
		List<CodeDetailDef> defList = this.codeDetailDefBL.searchCodeDetailDef(condImpl);
		for(CodeDetailDef def : defList){
			CodeDetailDefTB defClone = (CodeDetailDefTB)SerializationUtils.clone(def);
			codeDetailDefBL.deleteCodeDetailDef(defClone);
		}
		log.debug("========��������ɾ����������========");
		return dto;
	}
	
	/**
	 * ������Ϣ�༭���������ʾ
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO initIGSYM1503Action(IGSYM15DTO dto) throws BLException {
		log.debug("========������Ϣ�༭���������ʾ����ʼ========");
		IGSYM1503Form form = dto.getIgsym1503Form();
		
		CodeDetailDefTBPK pk = new CodeDetailDefTBPK();
		pk.setCcid(form.getCcid());
		pk.setCid(form.getCid());
		
		CodeDetailDefTB codeDetail = 
			(CodeDetailDefTB)this.codeDetailDefBL.searchCodeDetailDefByPK(pk);
		
		if (codeDetail==null) {
			throw new BLException("IGCO10000.E004","�����������");
		}
		
		//����������Ϣȡ��
		if (StringUtils.isNotEmpty(codeDetail.getPccid())
				&& StringUtils.isNotEmpty(codeDetail.getPcid())) {
			CodeDetailDefTBPK ppk = new  CodeDetailDefTBPK();
			ppk.setCcid(codeDetail.getPccid());
			ppk.setCid(codeDetail.getPcid());
			
			CodeDetailDefTB pCodeDetail = 
				(CodeDetailDefTB)this.codeDetailDefBL.searchCodeDetailDefByPK(ppk);
			
			if (pCodeDetail != null) {
				//����������Ϣ������,���������趨
				form.setPccname(pCodeDetail.getCodeCategoryDef().getCcname());
				form.setPcvalue(pCodeDetail.getCvalue());				
			}
			
		}else{
			form.setPcvalue("");				
		}
		form.setCvalue(codeDetail.getCvalue());
		form.setPccid(codeDetail.getPccid());
		form.setPcid(codeDetail.getPcid());
		form.setCcname(codeDetail.getCodeCategoryDef().getCcname());
		if(StringUtils.isEmpty(codeDetail.getPccid())){
			form.setClevel("1");
		}
		form.setPsyscoding(codeDetail.getPsyscoding());
		form.setSyscoding(codeDetail.getSyscoding());
		form.setCdstatus(codeDetail.getCdstatus());
		form.setBusinesscode(codeDetail.getBusinesscode());
		form.setMode("1");
		
		dto.setIgsym1503Form(form);
		
		log.debug("========������Ϣ�༭���������ʾ��������========");
		
		return dto;
	}
	
	/**
	 * ������Ϣ�ǼǴ���
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO insertCodeDetailDefAction(IGSYM15DTO dto) throws BLException {
		
		log.debug("========������Ϣ�ǼǴ���ʼ========");

		IGSYM1503Form form = dto.getIgsym1503Form();
		String syscoding = null;
		if(!"1".equals(form.getClevel())){
			CodeCategoryDefSearchCondImpl cond = new CodeCategoryDefSearchCondImpl();
			cond.setPccid(form.getCcid());
			List<CodeCategoryDefInfo> list = this.codeCategoryDefiBL.searchCodeCategoryDef(cond);
			form.setCcid(list.get(0).getCcid());
			syscoding = this.codeDetailDefBL.getSyscoding(form.getPsyscoding());
			if(syscoding == null){
				syscoding = getSyscoding(form.getPsyscoding()+StringUtils.leftPad("0", CommonDefineUtils.TREE_LEVEL_CODE , "0"),CommonDefineUtils.TREE_LEVEL_CODE);
			}else{
				syscoding = getSyscoding(syscoding,CommonDefineUtils.TREE_LEVEL_CODE);
			}
		}else{
			form.setPccid(null);
			syscoding = this.codeDetailDefBL.getSyscodingLevel1(form.getCcid());
			if(syscoding == null){
				syscoding = getSyscoding(form.getCcid()+StringUtils.leftPad("0", CommonDefineUtils.TREE_LEVEL_CODE , "0"),CommonDefineUtils.TREE_LEVEL_CODE);
			}else{
				syscoding = getSyscoding(syscoding,CommonDefineUtils.TREE_LEVEL_CODE);
			}
		}
		form.setSyscoding(syscoding);
		form.setCdstatus("1");
		checkParCodeDetail(form.getPccid(),form.getPcid());
		String tempcid = this.codeDetailDefBL.getMaxcid(form.getCcid());
		if(tempcid==null){
			form.setCid(getCid(StringUtils.leftPad("0", CommonDefineUtils.CID_LENGTH , "0"), CommonDefineUtils.CID_LENGTH));
		}else{
			form.setCid(getCid(tempcid, CommonDefineUtils.CID_LENGTH));
		}
		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		form.setUpdtime(datetime);
		this.codeDetailDefBL.registCodeDetailDef(form);
		
		
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
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO updateCodeDetailDefAction(IGSYM15DTO dto) throws BLException {
		log.debug("========������Ϣ���´���ʼ========");
		
		IGSYM1503Form form = dto.getIgsym1503Form();
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

		this.codeDetailDefBL.updateCodeDetailDef(form);
		
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
				CodeDetailDefTBPK pk = new CodeDetailDefTBPK();
				
				pk.setCcid(ccid);
				pk.setCid(cid);
				
				CodeDetailDef codeDetail = 
					this.codeDetailDefBL.searchCodeDetailDefByPK(pk);
				
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
		CodeDetailDefSearchCondImpl cond = new CodeDetailDefSearchCondImpl();
		cond.setPccid(ccid);
		cond.setPcid(cid);
		cond.setCdstatus("1");
		List<CodeDetailDef> codeDetailList = 
			this.codeDetailDefBL.searchCodeDetailDef(cond, 2);//������
		if (!codeDetailList.isEmpty()) {
			throw new BLException("IGSYM1101.E001");
		}
	}
	/**
	 * ���ݷ�����Ϣ��ѯ����
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM15DTO initIGSYM1506Action(IGSYM15DTO dto) throws BLException {

		log.debug("========���ݷ�����Ϣ��ѯ����ʼ========");
		
		CodeCategoryDefSearchCondImpl cond = new CodeCategoryDefSearchCondImpl();
		cond.setTree(true);
		int totalCount = this.codeCategoryDefiBL.getSearchCount(cond);

		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		
		//���ݷ�����Ϣȡ��
		List<CodeCategoryDefInfo> codeCategoryDefInfoList = 
			this.codeCategoryDefiBL.searchCodeCategoryDefPaging(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setCodeCategoryDefInfoList(codeCategoryDefInfoList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========���ݷ�����Ϣ��ѯ��������========");
		return dto;
	}
	public void setCodeDetailDefBL(CodeDetailDefBL codeDetailDefBL) {
		this.codeDetailDefBL = codeDetailDefBL;
	}





	public void setCodeCategoryDefiBL(CodeCategoryDefBL codeCategoryDefiBL) {
		this.codeCategoryDefiBL = codeCategoryDefiBL;
	}
	private String getNewCcid(String ccid)throws BLException{
		if(StringUtils.isEmpty(ccid)){
			return "100";
		}else{
			return String.valueOf(Integer.parseInt(ccid)+1);
		}
	}
}
