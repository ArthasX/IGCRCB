/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl;

import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.csebank.lom.bl.task.DealBL;
import com.csebank.lom.bl.task.DealOrgVWBL;
import com.csebank.lom.bl.task.DealVWBL;
import com.csebank.lom.bl.task.EentertainmentBL;
import com.csebank.lom.bl.task.GoutstockBL;
import com.csebank.lom.bl.task.LoanPayDetailBL;
import com.csebank.lom.bl.task.RecptionBL;
import com.csebank.lom.bl.task.RecptionGuestBL;
import com.csebank.lom.bl.task.RecptionOrgVWBL;
import com.csebank.lom.bl.task.RecptionVWBL;
import com.csebank.lom.dto.IGLOM01DTO;
import com.csebank.lom.form.IGLOM0101Form;
import com.csebank.lom.form.IGLOM0102Form;
import com.csebank.lom.form.IGLOM0103Form;
import com.csebank.lom.form.IGLOM0107Form;
import com.csebank.lom.form.IGLOM0115Form;
import com.csebank.lom.model.Deal;
import com.csebank.lom.model.DealOrg;
import com.csebank.lom.model.DealVWInfo;
import com.csebank.lom.model.GuestRecption;
import com.csebank.lom.model.Recption;
import com.csebank.lom.model.RecptionAmount;
import com.csebank.lom.model.RecptionCost;
import com.csebank.lom.model.RecptionGuest;
import com.csebank.lom.model.RecptionGuestInfo;
import com.csebank.lom.model.RecptionOrg;
import com.csebank.lom.model.RecptionVWInfo;
import com.csebank.lom.model.condition.EentertainmentSearchCondImpl;
import com.csebank.lom.model.condition.GoutstockSearchCondImpl;
import com.csebank.lom.model.condition.RecptionGuestSearchCondImpl;
import com.csebank.lom.model.entity.DealTB;
import com.csebank.lom.model.entity.RecptionTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.utility.IGStringUtils;

/**
 *  接待管理BL实现
 */
public class IGLOM01BLImpl extends BaseBLImpl implements IGLOM01BL {
	
	static Log log = LogFactory.getLog(IGLOM01BLImpl.class);

	/** 接待管理BL */
	protected RecptionBL recptionBL;
	protected DealBL dealBL;

	/** 接待客人BL */
	protected RecptionGuestBL recptionGuestBL;

	/** 接待汇总BL */
	protected RecptionVWBL recptionVWBL;
	protected DealVWBL dealVWBL;

	/** 部门接待汇总BL */
	protected RecptionOrgVWBL recptionOrgVWBL;
	protected DealOrgVWBL dealOrgVWBL;
	
	/** 借款BL */
	protected LoanPayDetailBL loanPayDetailBL;
	
	/** 食堂招待BL */
	protected EentertainmentBL eentertainmentBL;
	
	/** 物品出库BL */
	protected GoutstockBL goutstockBL;

	/**
	 * 接待管理BL设定
	 * @param recptionBL 接待管理BL
	 */
	public void setRecptionBL(RecptionBL recptionBL) {
		this.recptionBL = recptionBL;
	}

	/**
	 * 接待客人BL设定
	 * @param recptionGuestBL 接待客人BL
	 */
	public void setRecptionGuestBL(RecptionGuestBL recptionGuestBL) {
		this.recptionGuestBL = recptionGuestBL;
	}

	/**
	 * 接待汇总BL设定 
	 * @param recptionVWBL 接待汇总BL
	 */
	public void setRecptionVWBL(RecptionVWBL recptionVWBL) {
		this.recptionVWBL = recptionVWBL;
	}

	/**
	 * 部门接待汇总BL设定
	 * @param recptionOrgVWBL 部门接待汇总BL
	 */
	public void setRecptionOrgVWBL(RecptionOrgVWBL recptionOrgVWBL) {
		this.recptionOrgVWBL = recptionOrgVWBL;
	}

	/**
	 * 借款BL设定
	 * @param loanPayDetailBL 借款BL
	 */
	public void setLoanPayDetailBL(LoanPayDetailBL loanPayDetailBL) {
		this.loanPayDetailBL = loanPayDetailBL;
	}

	/**
	 * 食堂招待BL设定
	 * @param eentertainmentBL 食堂招待BL
	 */
	public void setEentertainmentBL(EentertainmentBL eentertainmentBL) {
		this.eentertainmentBL = eentertainmentBL;
	}

	/**
	 * 物品出库BL设定
	 * @param goutstockBL 物品出库BL
	 */
	public void setGoutstockBL(GoutstockBL goutstockBL) {
		this.goutstockBL = goutstockBL;
	}

	/**
	 * 接待变更初期显示处理
	 *
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO initRecption(IGLOM01DTO dto) throws BLException {

		log.debug("========接待变更画面初期显示处理开始========");	
		IGLOM0101Form form = dto.getIglom0101Form();
		Recption rp = recptionBL.searchRecptionByKey(form.getRid());
		
		//画面显示设定
		form.setRid(rp.getRid());
		form.setOrganizationTB(rp.getOrganizationTB());
		form.setRdescription(rp.getRdescription());
		form.setRetime(rp.getRetime());
		form.setRname(rp.getRname());
		form.setRpporg(rp.getRpporg());
		form.setRscale(rp.getRscale());
		form.setRstandard(rp.getRstandard());
		form.setRstime(rp.getRstime());
		form.setRdate(rp.getRdate());
		//部门层次码
		String rapporgid = rp.getRapporgid();
		form.setRapporgid(rapporgid);
		form.setRapporgname(rp.getOrganizationTB().getOrgname());
		form.setRlodgecost(rp.getRlodgecost());//住宿费用
		form.setRlodgestandard(rp.getRlodgestandard());//住宿标准
		//变更标识
		form.setMode("1");

		dto.setIglom0101Form(form);
		
		log.debug("========接待变更画面初期显示处理终了========");
		return dto;
	}

	/**
	 * 接待登记新增
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO insertRecptionAction(IGLOM01DTO dto) throws BLException {
		log.debug("========接待工作登记处理开始========");
		//输入Form取得
		IGLOM0101Form form = dto.getIglom0101Form();
		//状态    进行中:1
		form.setRstatus(IGLOMCONSTANTS.REC_STATUS_ENABLE);
		form.setRdate(IGStringUtils.getCurrentDate());
		//接待工作登录
		Recption rp = this.recptionBL.registRecption(dto.getIglom0101Form());
		form.setRid(rp.getRid());
		dto.setIglom0101Form(form);
				
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "接待工作") );

		log.debug("========接待工作登记处理终了========");
		return dto;
	}

	/**
	 * 接待工作更新
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO updateRecptionAction(IGLOM01DTO dto) throws BLException {
		
		log.debug("========接待工作变更处理开始========");
		
		//接待工作登录
		this.recptionBL.updateRecption(dto.getRecption());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "接待工作信息") );

		log.debug("========接待工作变更处理终了========");
		
		return dto;
	}



	
	/**
	 * 接待工作信息查询处理
	 *
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO searchRecptionAction(IGLOM01DTO dto) throws BLException {

		log.debug("========接待工作信息查询处理开始========");
		
		//接待工作信息查询件数取得 
		int totalCount = this.recptionBL.getSearchCount(dto.getRecptionSearchCond());
		
		if (totalCount == 0) {
			log.debug("========接待工作信息查询数据不存在========");
			//接待工作信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========接待工作信息查询数据件数过多========");
			//接待工作信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		//当前页信息取得
		List<RecptionAmount> recptionAmountList = this.recptionBL.searchRecptionAmount(dto.getRecptionSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		List<Recption> recptionList = this.recptionBL.searchRecption(dto.getRecptionSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		
		dto.setRecptionAmountList(recptionAmountList);
		dto.setRecptionList(recptionList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========接待工作信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 接待工作费用信息查询处理
	 *
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO searchRecptionCostAction(IGLOM01DTO dto) throws BLException {

		log.debug("========接待工作费用信息查询处理开始========");
		
		//接待工作信息查询件数取得 
		int totalCount = this.recptionBL.getRecptionCostCount(dto.getRecptionSearchCond());
		
		if (totalCount == 0) {
			log.debug("========接待工作信费用息查询数据不存在========");
			//接待工作信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========接待工作信费用息查询数据件数过多========");
			//接待工作信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		//当前页信息取得
//		List<Recption> recptionList = this.recptionBL.searchRecption(dto.getRecptionSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		List<RecptionCost> recptionList = this.recptionBL.searchRecptionCost(dto.getRecptionSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());


		pDto.setTotalCount(totalCount);
		
//		dto.setRecptionList(recptionList);
		dto.setRecptionCostList(recptionList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========接待工作信费用息查询处理终了========");
		return dto;
	}

	/**
	 * 接待工作结束处理
	 * 
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO changeRecptionAction(IGLOM01DTO dto) throws BLException {
		log.debug("========接待工作结束处理开始========");
		IGLOM0103Form form = dto.getIglom0103Form();
		
		Recption rai = this.recptionBL.searchRecptionByKey(form.getRid());
		
		//复制对象
		RecptionTB pdTB = (RecptionTB)SerializationUtils.clone(rai);
		
		if(IGLOMCONSTANTS.REC_STATUS_ENABLE.equals(form.getRstatus())) {
			pdTB.setRstatus(IGLOMCONSTANTS.REC_STATUS_DISABLE);//结束
			this.recptionBL.updateRecption(pdTB);
			log.debug("========结束========");
			dto.addMessage(new ActionMessage("IGLOM0103.I001") );
		} 
		log.debug("========接待工作结束处理终了========");
		return dto;
	}

	/**
	 * 接待工作删除处理
	 * 
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO deleteRecptionAction(IGLOM01DTO dto) throws BLException {

		log.debug("========接待工作信息删除处理开始========");
		
		for( int i = 0; i < dto.getDeleteRid().length; i++){
			//接待ID
			String rid = dto.getDeleteRid()[i];
			Recption rt = this.recptionBL.searchRecptionByKey(Integer.parseInt(rid));
			
//			//判断借款下是否有相关明细,存在明细不能删除
//			LoanPayDetailSearchCondImpl lcond = new LoanPayDetailSearchCondImpl();
//			lcond.setRid_q(Integer.parseInt(rid));
//			int lline = this.loanPayDetailBL.getSearchCount(lcond);
//			if(lline > 0){
//				throw new BLException("IGLOM0103.E001", rt.getRname(), "借款");
//			}
			
			//判断食堂接待下是否有相关明细,存在明细不能删除
			EentertainmentSearchCondImpl econd = new EentertainmentSearchCondImpl();
			econd.setRid_org(Integer.parseInt(rid));
			int eline = this.eentertainmentBL.getSearchCount(econd);
			if(eline > 0){
				throw new BLException("IGLOM0103.E001", rt.getRname(), "在食堂就餐");
			}
			
			//判断物品下是否有相关明细,存在明细不能删除
			GoutstockSearchCondImpl gcond = new GoutstockSearchCondImpl();
			gcond.setRid(Integer.parseInt(rid));
			int gline = this.goutstockBL.getSearchCount(gcond);
			if(gline > 0){
				throw new BLException("IGLOM0103.E001", rt.getRname(), "进行物品领用");
			}
			
			
			
			//删除接待客人
			RecptionGuestSearchCondImpl cond = new RecptionGuestSearchCondImpl();
			cond.setRid(Integer.parseInt(rid));
			List<RecptionGuest> rgList = this.recptionGuestBL.searchRecptionGuest(cond, 0, 0);
			for(RecptionGuest rg : rgList) {
				this.recptionGuestBL.deleteRecptionGuest(rg.getRgid());
			}
			//删除接待工作
			this.recptionBL.deleteRecption(Integer.parseInt(rid));
		}

		dto.addMessage(new ActionMessage("IGCO10000.I006","接待工作信息"));

		log.debug("========接待工作信息删除处理结束========");
		
		return dto;
	}

	/**
	 * 接待客人初期显示画面
	 * 
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO initRecptionGuest(IGLOM01DTO dto) throws BLException {

		log.debug("========接待客人变更画面初期显示处理开始========");	
		IGLOM0102Form form = dto.getIglom0102Form();
		RecptionGuest rp = recptionGuestBL.searchRecptionGuestByKey(form.getRgid());
		if ( rp == null ){
			throw new BLException("IGCO10000.E004","接待客人");
		}
		
		//画面显示设定
		form.setRid(rp.getRid());
		form.setRgname(rp.getRgname());
		form.setRgpost(rp.getRgpost());
		form.setRgtel(rp.getRgtel());
		form.setRgunit(rp.getRgunit());
		form.setRgid(rp.getRgid());
		form.setRgdate(rp.getRgdate());
		//变更标识
		form.setMode("1");

		dto.setIglom0102Form(form);
		
		log.debug("========接待客人变更画面初期显示处理终了========");
		return dto;
	}

	/**
	 * 接待客人登记新增
	 * 
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO insertRecptionGuestAction(IGLOM01DTO dto)
			throws BLException {
		
		log.debug("========接待客人登记处理开始========");
		//输入Form取得
		IGLOM0102Form form = dto.getIglom0102Form();
		//登记时间
		form.setRgdate(IGStringUtils.getCurrentDate());
		//接待客人登录
		this.recptionGuestBL.registRecptionGuest(dto.getIglom0102Form());
		
		dto.setIglom0102Form(form);
				
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "接待客人信息") );

		log.debug("========接待客人登记处理终了========");
		
		return dto;
		
	}

	/**
	 * 接待客人信息查询处理
	 *
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO searchRecptionGuestAction(IGLOM01DTO dto)
			throws BLException {

		log.debug("========接待客人信息查询处理开始========");
		
		
		//接待客人信息查询件数取得 
		int totalCount = this.recptionGuestBL.getSearchCount(dto.getRecptionGuestSearchCond()); 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========接待客人信息查询数据件数过多========");
			//接待客人信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		//当前页信息取得
		List<RecptionGuest> recptionGuestList = this.recptionGuestBL.searchRecptionGuest(dto.getRecptionGuestSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		//接待工作信息取得
		Recption recptionData = this.recptionBL.searchRecptionByKey(dto.getRecptionGuestSearchCond().getRid());

		pDto.setTotalCount(totalCount);
		
		dto.setRecptionGuestList(recptionGuestList);
		dto.setRecptionData(recptionData);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========接待客人信息查询处理终了========");
		
		return dto;
		
	}

	/**
	 * 接待客人更新
	 * 
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO updateRecptionGuestAction(IGLOM01DTO dto)
			throws BLException {
		
		log.debug("========接待客人变更处理开始========");
		
		//接待客人登录
		this.recptionGuestBL.updateRecptionGuest(dto.getRecptionGuest());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "接待客人信息") );

		log.debug("========接待客人变更处理终了========");
		
		return dto;
	}

	/**
	 * 接待客人删除处理
	 * 
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO deleteRecptionGuestAction(IGLOM01DTO dto)
			throws BLException {

		log.debug("========接待客人信息删除处理开始========");
		
		for( int i = 0; i < dto.getDeleteRgid().length; i++){
			
			String rgid = dto.getDeleteRgid()[i];
			//删除接待客人
			this.recptionGuestBL.deleteRecptionGuest(Integer.parseInt(rgid));
			
		}

		dto.addMessage(new ActionMessage("IGCO10000.I006","接待客人信息"));

		log.debug("========接待客人信息删除处理结束========");
		
		return dto;
	}

	/**
	 * 接待统计信息查询
	 * 
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO searchRecptionVWAction(IGLOM01DTO dto) throws BLException {

		log.debug("========接待统计信息查询处理开始========");


		//当前页信息取得
		List<RecptionVWInfo> recptionList = this.recptionVWBL.searchRecptionVW(dto.getRecptionVWSearchCond(), 0, 0);
	
		dto.setRecptionVWList(recptionList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",""));
		
		log.debug("========接待统计信息查询处理终了========");
		return dto;
	}

	/**
	 * 部门接待统计
	 * 
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO searchRecptionOrgVWAction(IGLOM01DTO dto)
			throws BLException {

		log.debug("========部门接待统计信息查询处理开始========");

		//当前页信息取得
		List<RecptionOrg> recptionOrgList = this.recptionOrgVWBL.searchRecptionOrgVW(dto.getRecptionOrgVWSearchCond(), 0, 0);
	
		dto.setRecptionOrgVWList(recptionOrgList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",""));
		
		log.debug("========部门接待统计信息查询处理终了========");
		return dto;
	}


	
	/**
	 * 接待客人查询画面
	 *
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO searchRecptionGuestInfoAction(IGLOM01DTO dto)
			throws BLException {

		log.debug("========接待客人信息查询处理开始========");
      
		int totalCount = this.recptionGuestBL.getSearchCount(dto.getRecptionGuestInfoCond());
		
		if (totalCount == 0) {
			log.debug("========接待客人信息查询数据不存在========");
			//接客人作信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========接待客人信息查询数据件数过多========");
			//接待客人信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}


		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		//当前页信息取得
		List<RecptionGuestInfo> recptionGuestList = this.recptionGuestBL.searchRecptionGuestInfo(dto.getRecptionGuestInfoCond(), pDto.getFromCount(), pDto.getPageDispCount());
        pDto.setTotalCount(totalCount);
		
		dto.setRecptionGuestInfoList(recptionGuestList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========接待客人查询处理终了========");
		return dto;
		
	}
	
	/**
	 * 根据客户信息查询接待工作信息处理
	 *
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO searchRecptionByGusetAction(IGLOM01DTO dto) throws BLException {

		log.debug("========根据客户信息查询接待工作信息处理开始========");
		
		//接待工作信息查询件数取得 
		int totalCount = this.recptionBL.getRecptionSearchCount(dto.getRecptionGuestInfoCond());
		
		if (totalCount == 0) {
			log.debug("========接待工作信息查询数据不存在========");
			//接待工作信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========接待工作信息查询数据件数过多========");
			//接待工作信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		//当前页信息取得
		List<GuestRecption> recptionList = this.recptionBL.searchRecptionByGuset(dto.getRecptionGuestInfoCond(), pDto.getFromCount(), pDto.getPageDispCount());


		pDto.setTotalCount(totalCount);
		
//		dto.setRecptionList(recptionList);
		dto.setGuestRecptionList(recptionList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========根据客户信息查询接待工作信息处理终了========");
		return dto;
	}
	/**
	 * 部门外出就餐统计
	 * 
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO searchDealOrgVWAction(IGLOM01DTO dto)
			throws BLException {

		log.debug("========部门外出就餐统计信息查询处理开始========");

		//当前页信息取得
		List<DealOrg> dealOrgList = this.dealOrgVWBL.searchDealOrgVW(dto.getDealOrgVWSearchCond(), 0, 0);
	
		dto.setDealOrgVWList(dealOrgList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",""));
		
		log.debug("========部门外出就餐统计信息查询处理终了========");
		return dto;
	}
	public IGLOM01DTO deleteDealAction(IGLOM01DTO dto)throws BLException{
        log.debug("========外出就餐信息删除处理开始========");
     
		for( int i = 0; i < dto.getDeleteRid().length; i++){
			 //接待ID
			String rid = dto.getDeleteRid()[i];
			this.dealBL.searchDealByKey(Integer.parseInt(rid));
	      //判断物品下是否有相关明细,存在明细不能删除
			GoutstockSearchCondImpl gcond = new GoutstockSearchCondImpl();
			gcond.setRid(Integer.parseInt(rid));
			int gline = this.goutstockBL.getSearchCount(gcond);
			if(gline > 0){
				throw new BLException("IGLOM0107.E001", "", "物品");
			}

			//删除接待工作
			this.dealBL.deleteDeal(Integer.parseInt(rid));
		}

		dto.addMessage(new ActionMessage("IGCO10000.I006","外出就餐信息"));

		log.debug("========外出就餐信息删除处理结束========");
		
		return dto;
	}
	/**
	 * 外出就餐变更初期显示处理
	 *
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO initDeal(IGLOM01DTO dto) throws BLException {

		log.debug("========外出就餐变更画面初期显示处理开始========");	
		IGLOM0115Form form = dto.getIglom0115Form();
		Deal rp = dealBL.searchDealByKey(form.getRid());
		
		//画面显示设定
		form.setRid(rp.getRid());
		form.setOrganizationTB(rp.getOrganizationTB());
		form.setDealCash(rp.getDealCash());
		form.setDealDesc(rp.getDealDesc());
		form.setDealScale(rp.getDealScale());
		form.setDealTime(rp.getDealTime());
		form.setDeptName(rp.getDeptName());
		form.setInvoiceNumber(rp.getInvoiceNumber());
		form.setOtherJoiner(rp.getOtherJoiner());
		form.setRapporgid(rp.getRapporgid());

		//变更标识
		form.setMode("1");

		dto.setIglom0115Form(form);
		
		log.debug("========外出就餐变更画面初期显示处理终了========");
		return dto;
	}
	/**
	 * 外出就餐信息管理查询
	 * 
	 */
	public IGLOM01DTO searchDealInfo(IGLOM01DTO dto) throws BLException {
	log.debug("========接待工作信息查询处理开始========");
		
		//接待工作信息查询件数取得 
		int totalCount = this.dealBL.getSearchCount(dto.getDealSearchCond());
		
		if (totalCount == 0) {
			log.debug("========外出就餐信息查询数据不存在========");
			//接待工作信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========外出就餐信息查询数据件数过多========");
			//接待工作信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		//当前页信息取得
		List<Deal> dealList = this.dealBL.searchDeal(dto.getDealSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());


		pDto.setTotalCount(totalCount);
		
		dto.setDealList(dealList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========外出就餐信息查询处理终了========");
		return dto;
	}
	public IGLOM01DTO changeDealAction(IGLOM01DTO dto) throws BLException{
		log.debug("========外出就餐工作结束处理开始========");
		IGLOM0107Form form = dto.getIglom0107Form();
		
		Deal rai = this.dealBL.searchDealByKey(form.getRid());
		
		//复制对象
		DealTB pdTB = (DealTB)SerializationUtils.clone(rai);
		
		if(IGLOMCONSTANTS.REC_STATUS_ENABLE.equals(form.getRstatus())) {
			pdTB.setRstatus(IGLOMCONSTANTS.REC_STATUS_DISABLE);//结束
			this.dealBL.updateDeal(pdTB);
			log.debug("========结束========");
			dto.addMessage(new ActionMessage("IGLOM0103.I001") );
		} 
		log.debug("========外出就餐工作结束处理终了========");
		return dto;
	}
	/**
     * 外出就餐登记信息入库处理
     * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
     */
	public IGLOM01DTO insetDealInfo(IGLOM01DTO dto)throws BLException{
		log.debug("========外出就餐信息登记处理开始========");
		IGLOM0115Form form = dto.getIglom0115Form();//获取外出就餐登记信息form
		form.setRstatus(IGLOMCONSTANTS.REC_STATUS_ENABLE);//设置状态为1
		Deal deal=this.dealBL.insertDealInfo(form);
		form.setRid(deal.getRid());
		dto.setIglom0115Form(form);
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "外出就餐") );
		log.debug("=============外出就餐信息登记完毕=========");
		return dto;
	}
	/**
	 * 外出就餐统计信息查询
	 * 
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO searchDealVWAction(IGLOM01DTO dto) throws BLException {

		log.debug("========外出就餐统计信息查询处理开始========");


		//当前页信息取得
		List<DealVWInfo> recptionList = this.dealVWBL.searchDealVW(dto.getDealVWSearchCond(), 0, 0);
	
		dto.setDealVWList(recptionList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",""));
		
		log.debug("========外出就餐统计信息查询处理终了========");
		return dto;
	}
	/**
	 * 外出就餐工作更新
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO updateDealAction(IGLOM01DTO dto) throws BLException {
		
		log.debug("========外出就餐工作变更处理开始========");
		
		//接待工作登录
		this.dealBL.updateDeal(dto.getDeal());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "外出就餐信息") );

		log.debug("========外出就餐工作变更处理终了========");
		
		return dto;
	}

	public DealBL getDealBL() {
		return dealBL;
	}

	public void setDealBL(DealBL dealBL) {
		this.dealBL = dealBL;
	}

	public DealVWBL getDealVWBL() {
		return dealVWBL;
	}

	public void setDealVWBL(DealVWBL dealVWBL) {
		this.dealVWBL = dealVWBL;
	}

	public DealOrgVWBL getDealOrgVWBL() {
		return dealOrgVWBL;
	}

	public void setDealOrgVWBL(DealOrgVWBL dealOrgVWBL) {
		this.dealOrgVWBL = dealOrgVWBL;
	}
}
