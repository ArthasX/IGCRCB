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
 * 基础数据管理业务逻辑实现
 *
 */
public class IGSYM15BLImpl extends BaseBLImpl implements IGSYM15BL {
	
	static Log log = LogFactory.getLog(IGSYM15BLImpl.class);
	
//	public final static int CCID_LENGTH = 3;
//	
//	public final static int CID_LENGTH = 4;

	/** 数据分类信息BL */
	protected CodeCategoryDefBL codeCategoryDefiBL;
	
	/** 数据详细信息BL */
	protected CodeDetailDefBL codeDetailDefBL;
	
	/** CodeListUtils */
	protected CodeListUtils codeListUtils;
	
	/**流程处理BL*/
	protected WorkFlowOperationBL workFlowOperationBL;
	
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	

	

	public void setCodeListUtils(CodeListUtils codeListUtils) {
		this.codeListUtils = codeListUtils;
	}

	
	
	
	/**
	 * 数据分类信息查询处理
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO initIGSYM1501Action(IGSYM15DTO dto) throws BLException {

		log.debug("========数据分类信息查询处理开始========");
		
		CodeCategoryDefSearchCondImpl cond = new CodeCategoryDefSearchCondImpl();
		cond.setTree(true);
		int totalCount = this.codeCategoryDefiBL.getSearchCount(cond);

		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		
		//数据分类信息取得
		List<CodeCategoryDefInfo> codeCategoryInfoList = 
			this.codeCategoryDefiBL.searchCodeCategoryDefPaging(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setCodeCategoryDefInfoList(codeCategoryInfoList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========数据分类信息查询处理终了========");
		return dto;
	}

	/**
	 * 数据分类删除处理
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO deleteIGSYM1501Action(IGSYM15DTO dto) throws BLException {
		IGSYM1501Form form = dto.getIgsym1501Form();
		
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
		
		
		for(int i = 0; i < 4; i++){
			String ccid = String.valueOf((Integer.parseInt(form.getCcid())+i));
			this.codeCategoryDefiBL.deleteCodeCategoryDef(ccid);
		}
		
		
		dto.addMessage(new ActionMessage("IGSYM1101.I004"));
		
		return dto;
	}
	
	/**
	 * 数据分类新增处理
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO saveIGSYM11501Action(IGSYM15DTO dto) throws BLException {
		log.debug("========数据分类新增处理开始========");
		IGSYM1501Form form = dto.getIgsym1501Form();
		CodeCategoryDefSearchCondImpl cond = new CodeCategoryDefSearchCondImpl();
		List<CodeCategoryDefInfo> infoList = this.codeCategoryDefiBL.searchCodeCategoryDefDescCiid(cond, 0, 1);
		String ccid = "";
		if(infoList == null || infoList.size() == 0){
			ccid = "100";
		}else{
			ccid = infoList.get(0).getCcid();
		}
		//检查CCID
//		CodeCategoryDefInfo cci = this.codeCategoryDefiBL.searchCodeCategoryDefByPK(form.getCcid());
//		if(cci!=null){
//			throw new BLException("IGSYM1107.E001");
//		}
		ccid = getNewCcid(ccid);
		//保存数据一级分类
		CodeCategoryDefTB cctb = new CodeCategoryDefTB();
		cctb.setCcid(ccid);//数据分类ID
		cctb.setCcname(form.getCcname());
		cctb.setCcinfo(form.getCcinfo());
		cctb.setCceditable("3");//3代表非基础数据，可删除
		cctb.setPcflag("4");//代表树形支持4级目录
		
		CodeCategoryDefInfo cc = this.codeCategoryDefiBL.registCodeCategoryDef(cctb);
		
		//增加该数据分类的下级子分类（除根结点以外），因为支持到4级，所以需要增加3条分级记录
		
		//增加1级
		CodeCategoryDefInfo cc1 = getCodeCategoryDefTB(cc,"一级分类","一级分类");
		//增加2级
		CodeCategoryDefInfo cc2 = getCodeCategoryDefTB(cc1,"二级分类","二级分类");
		//增加3级
		@SuppressWarnings("unused")
		CodeCategoryDefInfo cc3 = getCodeCategoryDefTB(cc2,"三级分类","三级分类");
		
		
		dto.addMessage(new ActionMessage("IGSYM1101.I003"));
		log.debug("========数据分类新增处理终了========");
		return dto;
	}
	
	/**
	 * 数据分类下级分类新增
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
		cctb1.setCceditable("3");//3代表非基础数据，可删除
		cctb1.setPcflag("4");//代表树形支持4级目录
		cctb1.setPccid(cci.getCcid());//父级ccid
		
		CodeCategoryDefInfo cci1 = this.codeCategoryDefiBL.registCodeCategoryDef(cctb1);
		
		return cci1;
	}
	
	
	/**
	 * 数据分类登记处理
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO insertCodeCategoryDefAction(IGSYM15DTO dto) throws BLException {
		log.debug("========数据分类登记处理开始========");
		
		this.codeCategoryDefiBL.registCodeCategoryDef(dto.getIgsym1507Form());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "数据分类信息") );

		log.debug("========数据分类登记处理终了========");
		return dto;
	}
	
	/**
	 * 数据分类编辑画面初期显示
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
//	public IGSYM15DTO initIGSYM1102Action(IGSYM15DTO dto) throws BLException {
//		log.debug("========数据分类编辑画面初期显示处理开始========");
//		
//		IGSYM1507Form form = dto.getIgsym1507Form();
//		String ccid = form.getCcid();
//		
//		CodeCategoryDefInfo codeCategoryInfo = this.codeCategoryDefiBL.searchCodeCategoryDefByPK(ccid);
//		
//		if ( codeCategoryInfo == null ){
//			throw new BLException("IGCO10000.E004","变更对象数据分类");
//		}
//		
//		form.setCcname(codeCategoryInfo.getCcname());
//		form.setCcinfo(codeCategoryInfo.getCcinfo());
//		form.setCceditable(codeCategoryInfo.getCceditable());
//		form.setMode("1");
//		
//		dto.setIgsym1507Form(form);
//		
//		log.debug("========数据分类编辑画面初期显示处理终了========");
//		return dto;
//	}
	
	/**
	 * 数据分类变更处理
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO updateCodeCategoryDefAction(IGSYM15DTO dto) throws BLException {
		log.debug("========数据分类变更处理开始========");
		this.codeCategoryDefiBL.updateCodeCategoryDef(dto.getIgsym1507Form());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "数据分类信息") );
		
		log.debug("========数据分类变更处理终了========");
		return dto;
	}
	
	/**
	 * 数据信息详细画面初期显示
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO initIGSYM1502Action(IGSYM15DTO dto) throws BLException {
		log.debug("========数据详细信息画面初期显示处理开始========");
		
		IGSYM1502Form form = dto.getIgsym1502Form();
		
		//数据分类信息查询
		CodeCategoryDefInfo codeCategoryInfo = 
			this.codeCategoryDefiBL.searchCodeCategoryDefByPK(form.getCcid());
		
		CodeDetailDefTBPK pk = new CodeDetailDefTBPK();
		pk.setCcid(form.getCcid());
		pk.setCid(form.getCid());
		//数据详细信息查询
		CodeDetailDef codeDetail = this.codeDetailDefBL.searchCodeDetailDefByPK(pk);
		
		//数据详细信息查询
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

		log.debug("========数据详细信息画面初期显示处理终了========");
		return dto;
	}
	
	/**
	 * 数据信息详细画面返回显示
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO initIGSYM1502BackAction(IGSYM15DTO dto) throws BLException {
	log.debug("========数据详细信息画面初期显示处理开始========");
		
		IGSYM1502Form form = dto.getIgsym1502Form();
		
		CodeDetailDefTBPK pkey = new CodeDetailDefTBPK();
		pkey.setCcid(form.getCcid());
		pkey.setCid(form.getCid());
		//数据详细信息查询
		CodeDetailDef pcodeDetail = this.codeDetailDefBL.searchCodeDetailDefByPK(pkey);
		//数据详细信息查询
		CodeDetailDefSearchCondImpl cond = new CodeDetailDefSearchCondImpl();
		//数据分类信息查询
		CodeCategoryDefInfo codeCategoryInfo = 
			this.codeCategoryDefiBL.searchCodeCategoryDefByPK(pcodeDetail.getPccid());
		
		if(codeCategoryInfo==null){
			dto.setCodeDetailDef(null);
			form.setClevel("1");
		}else{
			CodeDetailDefTBPK pk = new CodeDetailDefTBPK();
			pk.setCcid(pcodeDetail.getPccid());
			pk.setCid(pcodeDetail.getPcid());
			//数据详细信息查询
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

		log.debug("========数据详细信息画面初期显示处理终了========");
		return dto;
	}
	

	/**
	 * 数据信息删除处理
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO deleteCodeDetailDefAction(IGSYM15DTO dto) throws BLException {
		log.debug("========数据信息删除处理开始========");
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
	 * 数据信息删除处理
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO realdeleteCodeDetailDefAction(IGSYM15DTO dto) throws BLException {
		log.debug("========数据物理删除处理开始========");
		
		IGSYM1502Form form = dto.getIgsym1502Form();
		
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
		log.debug("========数据物理删除处理终了========");
		return dto;
	}
	
	/**
	 * 数据信息编辑画面初期显示
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO initIGSYM1503Action(IGSYM15DTO dto) throws BLException {
		log.debug("========数据信息编辑画面初期显示处理开始========");
		IGSYM1503Form form = dto.getIgsym1503Form();
		
		CodeDetailDefTBPK pk = new CodeDetailDefTBPK();
		pk.setCcid(form.getCcid());
		pk.setCid(form.getCid());
		
		CodeDetailDefTB codeDetail = 
			(CodeDetailDefTB)this.codeDetailDefBL.searchCodeDetailDefByPK(pk);
		
		if (codeDetail==null) {
			throw new BLException("IGCO10000.E004","变更对象数据");
		}
		
		//关联数据信息取得
		if (StringUtils.isNotEmpty(codeDetail.getPccid())
				&& StringUtils.isNotEmpty(codeDetail.getPcid())) {
			CodeDetailDefTBPK ppk = new  CodeDetailDefTBPK();
			ppk.setCcid(codeDetail.getPccid());
			ppk.setCid(codeDetail.getPcid());
			
			CodeDetailDefTB pCodeDetail = 
				(CodeDetailDefTB)this.codeDetailDefBL.searchCodeDetailDefByPK(ppk);
			
			if (pCodeDetail != null) {
				//关联数据信息分类名,数据内容设定
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
		
		log.debug("========数据信息编辑画面初期显示处理终了========");
		
		return dto;
	}
	
	/**
	 * 数据信息登记处理
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO insertCodeDetailDefAction(IGSYM15DTO dto) throws BLException {
		
		log.debug("========数据信息登记处理开始========");

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
		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		form.setUpdtime(datetime);
		this.codeDetailDefBL.registCodeDetailDef(form);
		
		
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
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO updateCodeDetailDefAction(IGSYM15DTO dto) throws BLException {
		log.debug("========数据信息更新处理开始========");
		
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
		
		
		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		form.setUpdtime(datetime);

		this.codeDetailDefBL.updateCodeDetailDef(form);
		
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
				CodeDetailDefTBPK pk = new CodeDetailDefTBPK();
				
				pk.setCcid(ccid);
				pk.setCid(cid);
				
				CodeDetailDef codeDetail = 
					this.codeDetailDefBL.searchCodeDetailDefByPK(pk);
				
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
		CodeDetailDefSearchCondImpl cond = new CodeDetailDefSearchCondImpl();
		cond.setPccid(ccid);
		cond.setPcid(cid);
		cond.setCdstatus("1");
		List<CodeDetailDef> codeDetailList = 
			this.codeDetailDefBL.searchCodeDetailDef(cond, 2);//不排序
		if (!codeDetailList.isEmpty()) {
			throw new BLException("IGSYM1101.E001");
		}
	}
	/**
	 * 数据分类信息查询处理
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM15DTO initIGSYM1506Action(IGSYM15DTO dto) throws BLException {

		log.debug("========数据分类信息查询处理开始========");
		
		CodeCategoryDefSearchCondImpl cond = new CodeCategoryDefSearchCondImpl();
		cond.setTree(true);
		int totalCount = this.codeCategoryDefiBL.getSearchCount(cond);

		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		
		//数据分类信息取得
		List<CodeCategoryDefInfo> codeCategoryDefInfoList = 
			this.codeCategoryDefiBL.searchCodeCategoryDefPaging(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setCodeCategoryDefInfoList(codeCategoryDefInfoList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========数据分类信息查询处理终了========");
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
