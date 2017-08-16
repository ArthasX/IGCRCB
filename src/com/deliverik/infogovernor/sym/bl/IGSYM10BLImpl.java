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
import com.deliverik.framework.model.entity.CodeDetailTB;
import com.deliverik.framework.model.entity.CodeDetailTBPK;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.adapter.CodeDefinition;
import com.deliverik.infogovernor.sym.dto.IGSYM10DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1004Form;
import com.deliverik.infogovernor.sym.form.IGSYM1006Form;
import com.deliverik.infogovernor.util.StringEncrypt;

/**
 * 基础数据管理业务逻辑实现
 *
 */
public class IGSYM10BLImpl extends BaseBLImpl implements IGSYM10BL {

	static Log log = LogFactory.getLog(IGSYM10BLImpl.class);

	/** 数据分类信息BL */
	protected CodeCategoryBL codeCategoryBL;
	
	/** 数据详细信息BL */
	protected CodeDetailBL codeDetailBL;
	
	/** CodeListUtils */
	protected CodeListUtils codeListUtils;

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
	 * @param dto IGSYM10DTO
	 * @return IGSYM10DTO
	 */
	public IGSYM10DTO initIGSYM1001Action(IGSYM10DTO dto) throws BLException {

		log.debug("========数据分类信息查询处理开始========");
		
		CodeCategorySearchCondImpl cond = new CodeCategorySearchCondImpl();
		cond.setTree(false);
		cond.setCceditable("3");
		int totalCount = this.codeCategoryBL.getSearchCount(cond);

		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		
		//数据分类信息取得
		List<CodeCategoryInfo> codeCategoryList = 
			this.codeCategoryBL.searchCodeCategory(cond);
		
		pDto.setTotalCount(totalCount);
		
		dto.setCodeCategoryList(codeCategoryList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========数据分类信息查询处理终了========");
		return dto;
	}

	/**
	 * 数据分类删除处理
	 *
	 * @param dto IGSYM10DTO
	 * @return IGSYM10DTO
	 */
	public IGSYM10DTO deleteCodeCategoryAction(IGSYM10DTO dto) throws BLException {
		log.debug("========数据分类删除处理开始========");
		//数据详细信息存在检测
		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
		cond.setCcid(dto.getIgsym1001Form().getCcid());
		int totalcount = this.codeDetailBL.getSearchCount(cond);
		
		if ( totalcount >0 ) {
			throw new BLException(BLErrorType.CODECATEGORY_NOT_EXISTS_ERROR,
					"IGSYM1001.E001");
		}
		
		this.codeCategoryBL.deleteCodeCategory(dto.getIgsym1001Form().getCcid());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I006", "数据分类信息") );

		log.debug("========数据分类删除处理终了========");
		return dto;
	}
	
	/**
	 * 数据信息详细画面初期显示
	 *
	 * @param dto IGSYM10DTO
	 * @return IGSYM10DTO
	 */
	public IGSYM10DTO initIGSYM1006Action(IGSYM10DTO dto) throws BLException {
		log.debug("========数据详细信息画面初期显示处理开始========");
		
		IGSYM1006Form form = dto.getIgsym1006Form();
		
		//数据分类信息查询
		CodeCategoryInfo codeCategoryInfo = 
			this.codeCategoryBL.searchCodeCategoryByPK(form.getCcid());
		
		//数据详细信息查询
		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
		cond.setCcid(form.getCcid());
		
		List<CodeDetail> codeDetailList = 
			this.codeDetailBL.searchCodeDetail(cond,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
		if("153".equals(form.getCcid())||"159".equals(form.getCcid())||"160".equals(form.getCcid())||"177".equals(form.getCcid())){// 如果是短信配置(159工作提醒信息设定)
			List<CodeDetail> codeDetailListTmp = new ArrayList<CodeDetail>();
			if("1".equals(ResourceUtility.getString("SENDSMSMODE_CODE"))){ //如果使用短信猫方式发送短信
				for(CodeDetail cdBean:codeDetailList){
					if(Integer.parseInt(cdBean.getCid())>=10||"3".equals(cdBean.getCid())){
						codeDetailListTmp.add(cdBean);
					}
					if("6".equals(cdBean.getCid())){
						dto.setFlag(cdBean.getCvalue());
					}
				}
			}else{
				for(CodeDetail cdBean:codeDetailList){
					if(Integer.parseInt(cdBean.getCid())<10&&!"6".equals(cdBean.getCid())){
						codeDetailListTmp.add(cdBean);
					}
					if("6".equals(cdBean.getCid())){
						dto.setFlag(cdBean.getCvalue());
					}
				}
			}
			codeDetailList = codeDetailListTmp;
		}
		dto.setCodeCategoryInfo(codeCategoryInfo);
		dto.setCodeDetailList(codeDetailList);
		
//		dto.addMessage(new ActionMessage("IGCO10000.I002",codeDetailList.size()));
	
		log.debug("========数据详细信息画面初期显示处理终了========");
		return dto;
	}

	/**
	 * 数据信息删除处理
	 *
	 * @param dto IGSYM10DTO
	 * @return IGSYM10DTO
	 */
	public IGSYM10DTO deleteCodeDetailAction(IGSYM10DTO dto) throws BLException {
		log.debug("========数据信息删除处理开始========");
		CodeDetailTBPK pk = new CodeDetailTBPK();
		
		pk.setCcid(dto.getIgsym1006Form().getCcid());
		pk.setCid(dto.getIgsym1006Form().getCid());
				
		CodeDetail codeDetail = this.codeDetailBL.deleteCodeDetail(pk);
		
		//Cache更新
		codeListUtils.updateCodeDetailCache(codeDetail.getCcid(), codeDetail.getPccid(), 
				codeDetail.getPcid());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I006", "数据") );

		log.debug("========数据信息删除处理终了========");
		return dto;
	}
	
	/**
	 * 数据信息编辑画面初期显示
	 *
	 * @param dto IGSYM10DTO
	 * @return IGSYM10DTO
	 */
	public IGSYM10DTO initIGSYM1004Action(IGSYM10DTO dto) throws BLException {
		log.debug("========数据信息编辑画面初期显示处理开始========");
		IGSYM1004Form form = dto.getIgsym1004Form();
		
		CodeDetailTBPK pk = new CodeDetailTBPK();
		pk.setCcid(form.getCcid());
		pk.setCid(form.getCid());
		
		CodeDetailTB codeDetail = 
			(CodeDetailTB)this.codeDetailBL.searchCodeDetailByPK(pk);
		
		if (codeDetail==null) {
			throw new BLException(BLErrorType.CODEDETAIL_NOT_EXISTS_ERROR,
					"IGCO10000.E004","变更对象数据");
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
			
		}
		form.setCvalue(codeDetail.getCvalue());
		form.setPccid(codeDetail.getPccid());
		form.setPcid(codeDetail.getPcid());
		form.setCdstatus(codeDetail.getCdstatus());
		form.setCcname(codeDetail.getCodeCategory().getCcname());
		form.setCdinfo(codeDetail.getCdinfo());
		form.setMode("1");
		
		dto.setIgsym1004Form(form);
		
		log.debug("========数据信息编辑画面初期显示处理终了========");
		
		return dto;
	}
	
	/**
	 * 数据信息登记处理
	 *
	 * @param dto IGSYM10DTO
	 * @return IGSYM10DTO
	 */
	public IGSYM10DTO insertCodeDetailAction(IGSYM10DTO dto) throws BLException {
		
		log.debug("========数据信息登记处理开始========");

		IGSYM1004Form form = dto.getIgsym1004Form();

		checkParCodeDetail(form.getPccid(),form.getPcid());
		
		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		form.setUpdtime(datetime);

		this.codeDetailBL.registCodeDetail(form);
		
		//Cache更新
		codeListUtils.updateCodeDetailCache(form.getCcid(), form.getPccid(), 
				form.getPcid());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "数据") );

		log.debug("========数据信息登记处理终了========");

		return dto;
	}
	
	/**
	 * 数据信息更新处理
	 *
	 * @param dto IGSYM10DTO
	 * @return IGSYM10DTO
	 */
	public IGSYM10DTO updateCodeDetailAction(IGSYM10DTO dto) throws BLException {
		log.debug("========数据信息更新处理开始========");
		
		IGSYM1004Form form = dto.getIgsym1004Form();

		if (form.getCcid().equals(form.getPccid()) && 
				form.getCid().equals(form.getPcid())) {
			throw new BLException(BLErrorType.RELATION_CODEDETAIL_ERROR,
					"IGSYM1004.E002");
		}
		checkParCodeDetail(form.getPccid(),form.getPcid());
		
		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		form.setUpdtime(datetime);

		if("P".equalsIgnoreCase(form.getCdstatus())){
			String oldPassword = codeListUtils.getCodeValue(CodeDefinition.MAIL, "", "", CodeDefinition.MAIL_PASSWORD);
			String newPassword = form.getCvalue();
			if(oldPassword != null && oldPassword.equals(newPassword)){
				return dto;
			}
			if(StringEncrypt.charToAscii(form.getCvalue()).length() > 60){
				dto.setError(true);
				dto.addMessage(new ActionMessage("IGSYM1004.E001", "密码","20"));
				return dto;
			}
			form.setCvalue(StringEncrypt.charToAscii(form.getCvalue()));
		}
		this.codeDetailBL.updateCodeDetail(form);
		
		//Cache更新
		codeListUtils.updateCodeDetailCache(form.getCcid(), form.getPccid(), 
				form.getPcid());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "数据") );

		log.debug("========数据信息更新处理终了========");
		return dto;
	}
	
	protected void checkParCodeDetail(String ccid,String cid) throws BLException {
		if (StringUtils.isNotEmpty(ccid)) {
			if (StringUtils.isNotEmpty(cid)) {
				CodeDetailTBPK pk = new CodeDetailTBPK();
				
				pk.setCcid(ccid);
				pk.setCid(cid);
				
				CodeDetail codeDetail = 
					this.codeDetailBL.searchCodeDetailByPK(pk);
				
				if (codeDetail == null) {
					throw new BLException(BLErrorType.RELATION_CODEDETAIL_ERROR,
							"IGCO10000.E004","关联父类数据");
				}
				
			} else {
				throw new BLException(BLErrorType.RELATION_CODEDETAIL_ERROR,
						"IGSYM1004.E001","数据编号(父)");
			}
		} else {
			if (StringUtils.isNotEmpty(cid)) {
				throw new BLException(BLErrorType.RELATION_CODEDETAIL_ERROR,
						"IGSYM1004.E001","数据分类编号(父)");
			}
		}
	}
	
}
