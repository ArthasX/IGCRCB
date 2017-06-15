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
 * 基础数据管理业务逻辑实现
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

	/** 数据分类信息BL */
	protected CodeCategoryBL codeCategoryBL;
	
	/** 数据详细信息BL */
	protected CodeDetailBL codeDetailBL;
	
	/** CodeListUtils */
	protected CodeListUtils codeListUtils;
	
	/**流程处理BL*/
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
	 * 数据分类信息查询处理
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO initIGSYM1101Action(IGSYM11DTO dto) throws BLException {

		log.debug("========数据分类信息查询处理开始========");
		
		CodeCategorySearchCondImpl cond = new CodeCategorySearchCondImpl();
		cond.setTree(true);
		int totalCount = this.codeCategoryBL.getSearchCount(cond);

		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		
		//数据分类信息取得
		List<CodeCategoryInfo> codeCategoryInfoList = 
			this.codeCategoryBL.searchCodeCategoryPaging(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setCodeCategoryInfoList(codeCategoryInfoList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========数据分类信息查询处理终了========");
		return dto;
	}

	/**
	 * 数据分类删除处理
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO deleteIGSYM1101Action(IGSYM11DTO dto) throws BLException {
		IGSYM1101Form form = dto.getIgsym1101Form();
		
		//检查该树是否正在被未关闭的自定义流程使用，未使用可删除
		//boolean psi_delFlag = true;//流程变量表是否使用了该树，使用了不可删除
		boolean psid_delFlag = false;//流程变量定义表是否使用了该树，使用了不可删除
		
		//查询IG007表是否存在pidtype=T的记录,如存在则不允许删除
		IG007SearchCondImpl pidcond = new IG007SearchCondImpl();
		pidcond.setPidtype(IGPRDCONSTANTS.PROCESSVAR_TREE_TYPE);
		List<IG007Info> pidList = this.workFlowOperationBL.searchProcessInfoDefByCond(pidcond);
		
		if(pidList!=null && pidList.size()>0){
			for(IG007Info pid:pidList){
				String pidccid = pid.getCcid();
				//流程变量定义表是否使用了该树，使用了不可删除
				if(pidccid!=null && form.getCcid().equals(pidccid.split("_tree_")[0])){
					psid_delFlag = true;
					break;
				}
				
			}
		}
		
		if(psid_delFlag){
			throw new BLException("IGSYM1101.E003");
		}
		
		
//		//查询ProcessInfo表是否存在Pivartype=T的记录的prid，看其是否已经关闭（prstatus是否为C）,未关闭则不可以删除
//		ProcessInfoSearchCondImpl picond = new ProcessInfoSearchCondImpl();
//		picond.setPivartype(IGPRDCONSTANTS.PROCESSVAR_TREE_TYPE);
//		List<ProcessInfo> piList = this.workFlowOperationBL.searchProcessInfoByCond(picond);
//		for(ProcessInfo pi:piList){
//			Integer prid = pi.getPrid();
//			//String varvalue = pi.getPivarvalue();// || (varvalue!=null && form.getCcid().equals(varvalue.split("_tree_")[0].substring(0, 3)))
//			
//			ProcessRecord pr = this.workFlowOperationBL.searchProcessRecordByKey(prid);
//			//流程未关闭则不可删除
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
	 * 数据分类新增处理
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO saveIGSYM1107Action(IGSYM11DTO dto) throws BLException {
		log.debug("========数据分类新增处理开始========");
		IGSYM1101Form form = dto.getIgsym1101Form();
		
		//检查CCID
		CodeCategoryInfo cci = this.codeCategoryBL.searchCodeCategoryByPK(form.getCcid());
		if(cci!=null){
			throw new BLException("IGSYM1107.E001");
		}
		
		//保存数据一级分类
		CodeCategoryTB cctb = new CodeCategoryTB();
		cctb.setCcid(form.getCcid());//数据分类ID
		cctb.setCcname(form.getCcname());
		cctb.setCcinfo(form.getCcinfo());
		cctb.setCceditable("3");//3代表非基础数据，可删除
		cctb.setPcflag("4");//代表树形支持4级目录
		
		CodeCategoryInfo cc = this.codeCategoryBL.registCodeCategory(cctb);
		
		//增加该数据分类的下级子分类（除根结点以外），因为支持到4级，所以需要增加3条分级记录
		
		//增加1级
		CodeCategoryInfo cc1 = getCodeCategoryTB(cc,"一级分类","一级分类");
		//增加2级
		CodeCategoryInfo cc2 = getCodeCategoryTB(cc1,"二级分类","二级分类");
		//增加3级
		@SuppressWarnings("unused")
		CodeCategoryInfo cc3 = getCodeCategoryTB(cc2,"三级分类","三级分类");
		
		
		dto.addMessage(new ActionMessage("IGSYM1101.I003"));
		log.debug("========数据分类新增处理终了========");
		return dto;
	}
	
	/**
	 * 数据分类下级分类新增
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
		cctb1.setCceditable("3");//3代表非基础数据，可删除
		cctb1.setPcflag("4");//代表树形支持4级目录
		cctb1.setPccid(cci.getCcid());//父级ccid
		
		CodeCategoryInfo cci1 = this.codeCategoryBL.registCodeCategory(cctb1);
		
		return cci1;
	}
	
	
	/**
	 * 数据分类登记处理
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO insertCodeCategoryAction(IGSYM11DTO dto) throws BLException {
		log.debug("========数据分类登记处理开始========");
		
		this.codeCategoryBL.registCodeCategory(dto.getIgsym1102Form());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "数据分类信息") );

		log.debug("========数据分类登记处理终了========");
		return dto;
	}
	
	/**
	 * 数据分类编辑画面初期显示
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO initIGSYM1102Action(IGSYM11DTO dto) throws BLException {
		log.debug("========数据分类编辑画面初期显示处理开始========");
		
		IGSYM1102Form form = dto.getIgsym1102Form();
		String ccid = form.getCcid();
		
		CodeCategoryInfo codeCategoryInfo = this.codeCategoryBL.searchCodeCategoryByPK(ccid);
		
		if ( codeCategoryInfo == null ){
			throw new BLException("IGCO10000.E004","变更对象数据分类");
		}
		
		form.setCcname(codeCategoryInfo.getCcname());
		form.setCcinfo(codeCategoryInfo.getCcinfo());
		form.setCceditable(codeCategoryInfo.getCceditable());
		form.setMode("1");
		
		dto.setIgsym1102Form(form);
		
		log.debug("========数据分类编辑画面初期显示处理终了========");
		return dto;
	}
	
	/**
	 * 数据分类变更处理
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO updateCodeCategoryAction(IGSYM11DTO dto) throws BLException {
		log.debug("========数据分类变更处理开始========");
		this.codeCategoryBL.updateCodeCategory(dto.getIgsym1102Form());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "数据分类信息") );
		
		log.debug("========数据分类变更处理终了========");
		return dto;
	}
	
	/**
	 * 数据信息详细画面初期显示
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO initIGSYM1106Action(IGSYM11DTO dto) throws BLException {
		log.debug("========数据详细信息画面初期显示处理开始========");
		
		IGSYM1106Form form = dto.getIgsym1106Form();
		
		//数据分类信息查询
		CodeCategoryInfo codeCategoryInfo = 
			this.codeCategoryBL.searchCodeCategoryByPK(form.getCcid());
		
		CodeDetailTBPK pk = new CodeDetailTBPK();
		pk.setCcid(form.getCcid());
		pk.setCid(form.getCid());
		//数据详细信息查询
		CodeDetail codeDetail = this.codeDetailBL.searchCodeDetailByPK(pk);
		
		//数据详细信息查询
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

		log.debug("========数据详细信息画面初期显示处理终了========");
		return dto;
	}
	/**
	 * 数据信息详细画面返回显示
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO initIGSYM1106BackAction(IGSYM11DTO dto) throws BLException {
	log.debug("========数据详细信息画面初期显示处理开始========");
		
		IGSYM1106Form form = dto.getIgsym1106Form();
		
		CodeDetailTBPK pkey = new CodeDetailTBPK();
		pkey.setCcid(form.getCcid());
		pkey.setCid(form.getCid());
		//数据详细信息查询
		CodeDetail pcodeDetail = this.codeDetailBL.searchCodeDetailByPK(pkey);
		//数据详细信息查询
		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
		//数据分类信息查询
		CodeCategoryInfo codeCategoryInfo = 
			this.codeCategoryBL.searchCodeCategoryByPK(pcodeDetail.getPccid());
		
		if(codeCategoryInfo==null){
			dto.setCodeDetail(null);
			form.setClevel("1");
		}else{
			CodeDetailTBPK pk = new CodeDetailTBPK();
			pk.setCcid(pcodeDetail.getPccid());
			pk.setCid(pcodeDetail.getPcid());
			//数据详细信息查询
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

		log.debug("========数据详细信息画面初期显示处理终了========");
		return dto;
	}
	

	/**
	 * 数据信息删除处理
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO deleteCodeDetailAction(IGSYM11DTO dto) throws BLException {
		log.debug("========数据信息删除处理开始========");
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
		
		//Cache更新
//		codeListUtils.updateCodeDetailCache(codeDetail.getCcid(), codeDetail.getPccid(),
//				codeDetail.getPcid());
		if("1".equals(cdstatus)){
			dto.addMessage(new ActionMessage( "IGSYM1101.I002", "数据") );
		}else{
			dto.addMessage(new ActionMessage( "IGSYM1101.I001", "数据") );
		}

		log.debug("========数据信息删除处理终了========");
		return dto;
	}
	
	/**
	 * 数据信息编辑画面初期显示
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO initIGSYM1104Action(IGSYM11DTO dto) throws BLException {
		log.debug("========数据信息编辑画面初期显示处理开始========");
		IGSYM1104Form form = dto.getIgsym1104Form();
		
		CodeDetailTBPK pk = new CodeDetailTBPK();
		pk.setCcid(form.getCcid());
		pk.setCid(form.getCid());
		
		CodeDetailTB codeDetail = 
			(CodeDetailTB)this.codeDetailBL.searchCodeDetailByPK(pk);
		
		if (codeDetail==null) {
			throw new BLException("IGCO10000.E004","变更对象数据");
		}
		
		//关联数据信息取得
		if (StringUtils.isNotEmpty(codeDetail.getPccid())
				&& StringUtils.isNotEmpty(codeDetail.getPcid())) {
			CodeDetailTBPK ppk = new  CodeDetailTBPK();
			ppk.setCcid(codeDetail.getPccid());
			ppk.setCid(codeDetail.getPcid());
			
			CodeDetailTB pCodeDetail = 
				(CodeDetailTB)this.codeDetailBL.searchCodeDetailByPK(ppk);
			
			if (pCodeDetail != null) {
				//关联数据信息分类名,数据内容设定
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
		
		log.debug("========数据信息编辑画面初期显示处理终了========");
		
		return dto;
	}
	
	/**
	 * 数据信息登记处理
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO insertCodeDetailAction(IGSYM11DTO dto) throws BLException {
		
		log.debug("========数据信息登记处理开始========");

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
		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		form.setUpdtime(datetime);
		this.codeDetailBL.registCodeDetail(form);
		
		
//		//Cache更新
//		codeListUtils.updateCodeDetailCache(form.getCcid(), form.getPccid(), 
//				form.getPcid());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "数据") );

		log.debug("========数据信息登记处理终了========");

		return dto;
	}
	
	/**
	 * 获取当前最大值加1的字符串，不足长度补0
	 * 
	 * @param syscoding 当前最大字符串
	 * @param length 长度
	 * @return
	 */
	private String getSyscoding(String syscoding ,int length) throws BLException {
		String temp = syscoding.substring(syscoding.length()-length);
		if(temp.equals("999")){
			throw new BLException("IGSYM1101.E002","数据");
		}
		return syscoding.substring(0, syscoding.length()-length)+StringUtils.leftPad(Integer.valueOf(temp)+1+"", length , "0");
	}
	
	/**
	 * 获取当前最大值加1的字符串，不足长度补0
	 * 
	 * @param cid 当前最大字符串
	 * @param length 长度
	 * @param flag 是否拼接源字符串
	 * @return
	 */
	private String getCid(String cid ,int length) throws BLException {
		Integer temp = new Integer(cid);
		if(temp == 9999){
			throw new BLException("IGSYM1101.E002","数据");
		}
		return StringUtils.leftPad(temp + 1 + "", length , "0");
	}
	
	/**
	 * 数据信息更新处理
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO updateCodeDetailAction(IGSYM11DTO dto) throws BLException {
		log.debug("========数据信息更新处理开始========");
		
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
		
		
		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		form.setUpdtime(datetime);

		this.codeDetailBL.updateCodeDetail(form);
		
		//Cache更新
//		codeListUtils.updateCodeDetailCache(form.getCcid(), form.getPccid(), 
//				form.getPcid());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "数据") );

		log.debug("========数据信息更新处理终了========");
		return dto;
	}
	
	/**
	 * 校验上级是否存在
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
					throw new BLException("IGCO10000.E004","关联父类数据");
				}
				
			} else {
				throw new BLException("IGSYM1104.E001","数据编号(父)");
			}
		} else {
			if (StringUtils.isNotEmpty(cid)) {
				throw new BLException("IGSYM1104.E001","数据分类编号(父)");
			}
		}
	}
	
	/**
	 * 校验是否下级是否含有未停用的数据
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
			this.codeDetailBL.searchCodeDetail(cond, 2);//不排序
		if (!codeDetailList.isEmpty()) {
			throw new BLException("IGSYM1101.E001");
		}
	}
	/**
	 * 取得流程影响度及紧急度信息
	 *
	 * @param IGSYM11DTO
	 * @param 
	 */
	public IGSYM11DTO getPrimpactAndPrurgency(IGSYM11DTO dto) throws BLException {
		List<CodeDetail> primpactList = null;  //影响程度
		List<CodeDetail> prurgencyList = null; //紧急程度

		if("I".equals(dto.getIgsym1109Form().getPprtype())){
			CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
			cond.setCcid("101");
			primpactList = this.codeDetailBL.searchCodeDetail(cond, 1);//影响程度
			cond.setCcid("119");
			prurgencyList = this.codeDetailBL.searchCodeDetail(cond, 1);//紧急程度
		}
		if(primpactList == null){
			primpactList = new ArrayList<CodeDetail>();
		}
		if(prurgencyList == null){
			prurgencyList = new ArrayList<CodeDetail>();
		}
		dto.setPrimpactList(primpactList);//影响程度
		dto.setPrurgencyList(prurgencyList);//紧急程度
		return dto;
	}
	/**
	 * 搜索优先级所有数据
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
	 * 保存优先级所有数据
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public void savePriority(IGSYM11DTO dto) throws BLException {
		List<CodeDetail> primpactList = dto.getPrimpactList();  //影响程度
		List<CodeDetail> prurgencyList = dto.getPrurgencyList(); //紧急程度
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
