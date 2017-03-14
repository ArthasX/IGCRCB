/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.bl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeDetailDefBL;
import com.deliverik.framework.model.CodeDetailDef;
import com.deliverik.framework.model.condition.CodeDetailDefSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.bl.task.IG007BL;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.infogovernor.rpt.bl.task.SOC0424BL;
import com.deliverik.infogovernor.rpt.model.SOC0424Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0424SearchCondImpl;
import com.deliverik.infogovernor.soc.mnt.bl.task.Object_ListBL;
import com.deliverik.infogovernor.soc.mnt.model.Object_ListInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.Object_ListSearchCondImpl;
import com.deliverik.infogovernor.sym.bl.task.CustomConfigurationBL;
import com.deliverik.infogovernor.sym.bl.task.ReportFileDefinitionBL;
import com.deliverik.infogovernor.sym.bl.task.ReportFileVersionBL;
import com.deliverik.infogovernor.sym.dto.IGSYM14DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1402Form;
import com.deliverik.infogovernor.sym.form.IGSYM1407Form;
import com.deliverik.infogovernor.sym.model.CustomConfigurationInfo;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;
import com.deliverik.infogovernor.sym.model.ReportFileVersion;
import com.deliverik.infogovernor.sym.model.entity.CustomConfigurationTB;
import com.deliverik.infogovernor.sym.model.entity.ReportFileDefinitionTB;
import com.deliverik.infogovernor.sym.model.entity.ReportFileVersionTB;

/**
 * 报表信息业务逻辑实现
 *
 */
public class IGSYM14BLImpl extends BaseBLImpl implements IGSYM14BL {

	/**
	 * object_ListBL设定
	 *
	 * @param object_ListBL object_ListBL
	 */
	public void setObject_ListBL(Object_ListBL object_ListBL) {
		this.object_ListBL = object_ListBL;
	}

	/**
	 * soc0424BL设定
	 *
	 * @param soc0424BL soc0424BL
	 */
	public void setSoc0424BL(SOC0424BL soc0424BL) {
		this.soc0424BL = soc0424BL;
	}

	static Log log = LogFactory.getLog(IGSYM14BLImpl.class);
	
	/** 报表信息BL */
	protected ReportFileDefinitionBL reportFileDefinitionBL;
	
	/** 报表版本信息BL */
	protected ReportFileVersionBL reportFileVersionBL;
	
	protected Object_ListBL object_ListBL;
	
	protected SOC0424BL soc0424BL;
	
	protected IG380BL ig380BL;
	
	protected IG333BL ig333BL;
	
	protected IG007BL ig007BL;
	
	protected CodeDetailDefBL  codeDetailDefBL;
	
	protected CustomConfigurationBL customConfigurationBL;
    
	public void setCustomConfigurationBL(CustomConfigurationBL customConfigurationBL) {
		this.customConfigurationBL = customConfigurationBL;
	}

	public void setIg333BL(IG333BL ig333BL) {
		this.ig333BL = ig333BL;
	}

	public void setIg380BL(IG380BL ig380BL) {
		this.ig380BL = ig380BL;
	}

	public void setIg007BL(IG007BL ig007BL) {
		this.ig007BL = ig007BL;
	}

	public void setCodeDetailDefBL(CodeDetailDefBL codeDetailDefBL) {
		this.codeDetailDefBL = codeDetailDefBL;
	}

	/**
	 * 报表信息BL设定
	 * 
	 * @param reportFileDefinitionBL
	 */
	public void setReportFileDefinitionBL(
			ReportFileDefinitionBL reportFileDefinitionBL) {
		this.reportFileDefinitionBL = reportFileDefinitionBL;
	}
	
	/**
	 * 报表版本信息BL设定
	 * 
	 * @param reportFileVersionBL
	 */
	public void setReportFileVersionBL(
			ReportFileVersionBL reportFileVersionBL) {
		this.reportFileVersionBL = reportFileVersionBL;
	}

	/**
	 * 报表信息查询处理
	 *
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 */
	public IGSYM14DTO searchReportFileDefinitionAction(IGSYM14DTO dto) throws BLException {
		
		log.debug("========报表信息查询处理开始========");
		
		//报表信息查询件数取得 
		int totalCount = this.reportFileDefinitionBL.getSearchCount(dto.getReportFileDefinitionSearchCond());
		
		if (totalCount == 0) {
			log.debug("========报表信息查询数据不存在========");
			//报表信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========报表信息查询数据件数过多========");
			//报表信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		
		//当前页报表信息取得
		List<ReportFileDefinition> reportFileDefinitionList = this.reportFileDefinitionBL.searchReportFileDefinition(dto.getReportFileDefinitionSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setReportFileDefinitionList(reportFileDefinitionList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========报表信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 报表信息登记处理
	 *
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGSYM14DTO insertReportFileDefinitionAction(IGSYM14DTO dto) throws BLException, FileNotFoundException, IOException {
		
		log.debug("========报表信息登记处理开始========");
		
		IGSYM1402Form form = dto.getIgSYM1402Form();
		
		if(dto.getUser() == null) {
			throw new BLException("IGCO10000.E004","登陆用户基本");
		}
		
		//登记人ID
		form.setRfduserid(dto.getUser().getUserid());
		
		//登记人姓名
		form.setRfdusername(dto.getUser().getUsername());
		
		//登记时间
		form.setRfdinstime(IGStringUtils.getCurrentDateTime());
		
		//第一版
		form.setRfdversion(1);
		
		//第一版
		form.setRfdnewversion(1);
		
		//当是订制报表时，设定报表模版
		if("0".equals(form.getIsFlag())) {
		    form.setRfdfilename(form.getRfdfilemodel());
		}
		
		//报表信息登记处理
		ReportFileDefinition pfd = this.reportFileDefinitionBL.registReportFileDefinition(form);
		
		//新增版本信息
		ReportFileVersionTB rfvTB = new ReportFileVersionTB();
		
		rfvTB.setRfdid(pfd.getRfdid());
		
		rfvTB.setRfvversion(1);
		
		rfvTB.setRfvinstime(form.getRfdinstime());
		
		this.reportFileVersionBL.registReportFileVersion(rfvTB);
		
		//订制报表
		if("0".equals(form.getIsFlag())){
			CustomConfigurationTB ccTB = new CustomConfigurationTB();
			ccTB.setRfdid(pfd.getRfdid());
			//流程类型
			if(form.getPrtypes() != null && form.getPrtypes().length > 0 ) {
				ccTB.setPdid(getCustomConfigField(form.getPrtypes()));
			} else {
				ccTB.setPdid(form.getPrtype());
			}
			
			//流程状态
			if(form.getPrstatus() != null && form.getPrstatus().length > 0) {
				ccTB.setPrstatusInfo(getCustomConfigField(form.getPrstatus()));
			}
			
			//流程表单
			if(StringUtils.isNotEmpty(form.getPidid())){
				String[] pidids=form.getPidid().split("_");
				if (pidids != null && pidids.length > 0) {
					ccTB.setPidid(form.getPidid());
					//如果为树形表单时
					if("T".equals(pidids[1])){
						IG007Info ig007Info=this.ig007BL.searchIG007InfoByKey(pidids[0]);
						StringBuffer pidvalue=new StringBuffer();
						if(ig007Info!=null){
							String ccid=ig007Info.getCcid().split("_")[0];
							if(StringUtils.isNotEmpty(form.getRank())){
								//计算树形表单统计节点级数，ccid加上级数
								Integer cddccid=Integer.parseInt(ccid)+Integer.parseInt(form.getRank());
								CodeDetailDefSearchCondImpl cddCond=new CodeDetailDefSearchCondImpl();
								cddCond.setCcid(cddccid.toString());
								cddCond.setCdstatus("1");
								//根据树形节点ccid查询节点树形值
								List<CodeDetailDef> codeDetailDefList=this.codeDetailDefBL.searchCodeDetailDef(cddCond);
								if(codeDetailDefList!=null&&codeDetailDefList.size()>0){
									int i=0;
									for(CodeDetailDef info:codeDetailDefList){
										pidvalue.append(info.getSyscoding());
										if(i!=codeDetailDefList.size()){
											//用#拼写树形值，如：标准变更#常规变更
											pidvalue.append("#");
										}
										i++;
									}
								}
							}
						}
						ccTB.setPidvalue(pidvalue.toString());
					}else{
						IG007Info ig007Info = this.ig007BL.searchIG007InfoByKey(pidids[0]);
						if (ig007Info != null) {
							ccTB.setPidvalue(ig007Info.getPidoption());
						}
					}
				}
			}
			ccTB.setUserid(dto.getUser().getUserid());
			ccTB.setCreateTime(IGStringUtils.getCurrentDateTime());
			this.customConfigurationBL.registCustomConfiguration(ccTB);
		}
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "报表基本信息") );
		
		log.debug("========报表信息登记处理终了========");
		return dto;
	}
	
	/**
	 * 组装保存到CUSTOMCONFIGURATION表的字段
	 *
	 * 2012-11-16下午2:57:43
	 * @param pdids
	 * @return 以#号分隔的字符串
	 */
	private String getCustomConfigField(String[] pdids) {
		StringBuffer sb = new StringBuffer();
		for (String pdid : pdids) {
		    if(sb.length() == 0) {
		        sb.append(pdid);
		    } else {
		        sb.append("#").append(pdid);
		    }
		}
		return sb.toString();
	}

	/**
	 * 取得报表显示名称
	 * 
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 * @throws BLException
	 */
	
	public IGSYM14DTO getReportTitle(IGSYM14DTO dto) throws BLException {
		
		log.debug("========报表基本信息查询处理开始========");

		IGSYM1402Form form = new IGSYM1402Form();
		
		ReportFileDefinition rfd = this.reportFileDefinitionBL.searchReportFileDefinitionByKey(dto.getRfdid());
		
		form.setRfdtitle(rfd.getRfdtitle());//显示名称
		
		form.setRfdtype(rfd.getRfdtype());//分类
		
		form.setRfdid(rfd.getRfdid());//主键
		
		form.setRfdfilename(rfd.getRfdfilename());//文件名
		
		form.setRfddesc(rfd.getRfddesc());//说明
		
		form.setRfdtypename(rfd.getCodeDetailTB().getCvalue());//分类显示名称
		
		dto.setIgSYM1402Form(form);
		
		dto.addMessage(new ActionMessage("IGCO10000.I001","报表基本信息"));
		
		log.debug("========报表基本信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 报表信息变更初始化
	 * 
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 * @throws BLException
	 */
	
	public IGSYM14DTO initReportFileDefinitionAction(IGSYM14DTO dto) throws BLException {
		
		log.debug("========报表基本信息查询处理开始========");
		IGSYM1402Form form = dto.getIgSYM1402Form();
		
		ReportFileDefinition rfd = this.reportFileDefinitionBL.searchReportFileDefinitionByKey(form.getRfdid());
		
		form.setRfdtitle(rfd.getRfdtitle());//显示名称
		
		form.setRfdtype(rfd.getRfdtype());//分类
		
		form.setRfdid(rfd.getRfdid());//主键
		
		if("0".equals(rfd.getIsFlag())){
			form.setRfdfilemodel(rfd.getRfdfilename());//文件名
		}else{
			form.setRfdfilename(rfd.getRfdfilename());//文件名
		}
		
		form.setRfddesc(rfd.getRfddesc());//说明
		
		form.setRfdtypename(rfd.getCodeDetailTB().getCvalue());//分类显示名称
		
		form.setRfdpictype(rfd.getRfdpictype());
		
		form.setIsFlag(rfd.getIsFlag());
		
		if("0".equals(rfd.getIsFlag())){
			CustomConfigurationInfo ccInfo=this.customConfigurationBL.searchCustomConfigurationByPK(rfd.getRfdid());
			 if(ccInfo!=null){
				 form.setPrtype(ccInfo.getPdid());
				 form.setPidid(ccInfo.getPidid());
				 form.setPrstatuss(ccInfo.getPrstatusInfo());
				 form.setPidvalue(ccInfo.getPidvalue());
				 if(null !=ccInfo.getPidvalue())
				 {
					 if(ccInfo.getPidvalue().split("#")[0].length()==6){
							form.setRank("0");
					 }
					 else{
							form.setRank("1");
					 }
				 }
				 
			 }
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I001","报表基本信息"));
		
		log.debug("========报表基本信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 报表信息变更
	 * 
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 * @throws BLException
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGSYM14DTO editReportFileDefinitionAction(IGSYM14DTO dto) throws BLException, FileNotFoundException, IOException{
		
		IGSYM1402Form form = dto.getIgSYM1402Form();
		
		ReportFileDefinition rfd = this.reportFileDefinitionBL.searchReportFileDefinitionByKey(form.getRfdid());
		
		ReportFileDefinitionTB rfdTB = (ReportFileDefinitionTB)SerializationUtils.clone(rfd);
		
		//检查报表显示名称
		if(!rfdTB.getRfdtitle().equals(form.getRfdtitle())){
			this.reportFileDefinitionBL.checkRfdtitle(form.getRfdtitle());
		}
		
		rfdTB.setRfdtitle(form.getRfdtitle());//显示名称
		
		rfdTB.setRfdtype(form.getRfdtype());//分类
		
		rfdTB.setRfddesc(form.getRfddesc());//说明
		
		if(StringUtils.isNotEmpty(form.getRfdfilemodel())){
			rfdTB.setRfdfilename(form.getRfdfilemodel());
		}
		
	    // 当是订制报表时，设定报表模版
        if("0".equals(form.getIsFlag())){
            rfdTB.setRfdfilename(form.getRfdfilemodel());
        } else {
        	rfdTB.setRfdfilename(form.getRfdfilename());
        }
        
		rfdTB.setRfdpictype(form.getRfdpictype());//报表类型
		
		rfdTB.setIsFlag(form.getIsFlag());
		
		ReportFileDefinition pfd=this.reportFileDefinitionBL.updateReportFileDefinition(rfdTB);
		
		//订制报表
		if("0".equals(form.getIsFlag())){
			CustomConfigurationInfo ccInfo=this.customConfigurationBL.searchCustomConfigurationByPK(pfd.getRfdid());
			if(ccInfo!=null){
				CustomConfigurationTB ccTB=(CustomConfigurationTB)SerializationUtils.clone(ccInfo);
				//流程类型
				if(form.getPrtypes()!=null) {
					ccTB.setPdid(getCustomConfigField(form.getPrtypes()));
				} else {
					ccTB.setPdid(form.getPrtype());
				}
				if(form.getPrstatus()!=null&&form.getPrstatus().length>0){
					ccTB.setPrstatusInfo(getCustomConfigField(form.getPrstatus()));
				}
				if(StringUtils.isNotEmpty(form.getPidid())){
					String[] pidids=form.getPidid().split("_");
					if(pidids!=null&&pidids.length>0){
						ccTB.setPidid(form.getPidid());
						//如果为树形表单时
						if("T".equals(pidids[1])){
							IG007Info ig007Info=this.ig007BL.searchIG007InfoByKey(pidids[0]);
							StringBuffer pidvalue=new StringBuffer();
							if(ig007Info!=null){
								String ccid=ig007Info.getCcid().split("_")[0];
								if(StringUtils.isNotEmpty(form.getRank())){
									//计算树形表单统计节点级数，ccid加上级数
									Integer cddccid=Integer.parseInt(ccid)+Integer.parseInt(form.getRank());
									CodeDetailDefSearchCondImpl cddCond=new CodeDetailDefSearchCondImpl();
									cddCond.setCcid(cddccid.toString());
									//根据树形节点ccid查询节点树形值
									List<CodeDetailDef> codeDetailDefList=this.codeDetailDefBL.searchCodeDetailDefTree(cddCond, 0);
									if(codeDetailDefList!=null&&codeDetailDefList.size()>0){
										int i=0;
										for(CodeDetailDef info:codeDetailDefList){
											pidvalue.append(info.getSyscoding());
											if(i!=codeDetailDefList.size()){
												//用#拼写树形值，如：标准变更#常规变更
												pidvalue.append("#");
											}
											i++;
										}
									}
								}
							}
							ccTB.setPidvalue(pidvalue.toString());
						}else{
							IG007Info ig007Info=this.ig007BL.searchIG007InfoByKey(pidids[0]);
							if(ig007Info!=null){
								ccTB.setPidvalue(ig007Info.getPidoption());
							}
						}
					}
				}
				ccTB.setUserid(dto.getUser().getUserid());
				ccTB.setUpdateTime(IGStringUtils.getCurrentDateTime());
				this.customConfigurationBL.registCustomConfiguration(ccTB);
			}else{
				CustomConfigurationTB ccTB=new CustomConfigurationTB();
				ccTB.setRfdid(pfd.getRfdid());
				ccTB.setPdid(form.getPrtype());
				if(form.getPrstatus()!=null&&form.getPrstatus().length>0){
					StringBuffer prstatus=new StringBuffer();
					for(int i=0;i<form.getPrstatus().length;i++){
						prstatus.append(form.getPrstatus()[i]);
						if(i!=form.getPrstatus().length){
							prstatus.append("#");
						}
					}
					ccTB.setPrstatusInfo(prstatus.toString());
				}
				if(StringUtils.isNotEmpty(form.getPidid())){
					String[] pidids=form.getPidid().split("_");
					if(pidids!=null&&pidids.length>0){
						ccTB.setPidid(form.getPidid());
						//如果为树形表单时
						if("T".equals(pidids[1])){
							IG007Info ig007Info=this.ig007BL.searchIG007InfoByKey(pidids[0]);
							StringBuffer pidvalue=new StringBuffer();
							if(ig007Info!=null){
								String ccid=ig007Info.getCcid().split("_")[0];
								if(StringUtils.isNotEmpty(form.getRank())){
									//计算树形表单统计节点级数，ccid加上级数
									Integer cddccid=Integer.parseInt(ccid)+Integer.parseInt(form.getRank());
									CodeDetailDefSearchCondImpl cddCond=new CodeDetailDefSearchCondImpl();
									cddCond.setCcid(cddccid.toString());
									//根据树形节点ccid查询节点树形值
									List<CodeDetailDef> codeDetailDefList=this.codeDetailDefBL.searchCodeDetailDef(cddCond);
									if(codeDetailDefList!=null&&codeDetailDefList.size()>0){
										int i=0;
										for(CodeDetailDef info:codeDetailDefList){
											pidvalue.append(info.getSyscoding());
											if(i!=codeDetailDefList.size()){
												//用#拼写树形值，如：标准变更#常规变更
												pidvalue.append("#");
											}
											i++;
										}
									}
								}
							}
							ccTB.setPidvalue(pidvalue.toString());
						}else{
							IG007Info ig007Info=this.ig007BL.searchIG007InfoByKey(pidids[0]);
							if(ig007Info!=null){
								ccTB.setPidvalue(ig007Info.getPidoption());
							}
						}
					}
				}
				ccTB.setUserid(dto.getUser().getUserid());
				ccTB.setCreateTime(IGStringUtils.getCurrentDateTime());
				this.customConfigurationBL.registCustomConfiguration(ccTB);
			}
			
		}
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "报表基本信息") );
		return dto;
	}
	
	/**
	 * 报表版本升级处理
	 *
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 */
	public IGSYM14DTO insertReportFileVersionAction(IGSYM14DTO dto) throws BLException {
		log.debug("========报表版本升级处理开始========");
		
		//版本信息取得
		ReportFileDefinition rfd = this.reportFileDefinitionBL.searchReportFileDefinitionByKey(dto.getRfdid());
		
		ReportFileDefinitionTB rfdTB = (ReportFileDefinitionTB)SerializationUtils.clone(rfd);
		
		//版本加1
		int version = rfd.getRfdnewversion() + 1;
		
		//创建时间
		String datatime = IGStringUtils.getCurrentDateTime();
		
		rfdTB.setRfdnewversion(version);
		
		//更新报表信息
		this.reportFileDefinitionBL.updateReportFileDefinition(rfdTB);
		
		//新增版本信息
		ReportFileVersionTB rfvTB = new ReportFileVersionTB();
		
		rfvTB.setRfdid(dto.getRfdid());
		
		rfvTB.setRfvversion(version);
		
		rfvTB.setRfvinstime(datatime);
		
		this.reportFileVersionBL.registReportFileVersion(rfvTB);
		
		dto.addMessage(new ActionMessage("IGSYM1401.I001"));
		
		log.debug("========报表版本升级处理终了========");
		return dto;
	}
	
	/**
	 * 报表信息删除处理
	 *
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 */
	public IGSYM14DTO deleteReportFileDefinitionAction(IGSYM14DTO dto) throws BLException {
		log.debug("========报表信息删除处理开始========");
		if(dto.getDeleteRfdid() != null) {
			//循环删除
			for( int i=0;i<dto.getDeleteRfdid().length;i++ ){
				this.reportFileDefinitionBL.deleteReportFileDefinition(Integer.parseInt(dto.getDeleteRfdid()[i]));
				this.customConfigurationBL.deleteCustomConfigurationByPK(Integer.parseInt(dto.getDeleteRfdid()[i]));
			}
		}
		dto.addMessage(new ActionMessage("IGCO10000.I006", "报表基本信息"));
		log.debug("========报表信息删除处理终了========");
		return dto;
	}
	
	/**
	 * 报表版本信息查询处理
	 *
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 */
	public IGSYM14DTO searchReportFileVersionAction(IGSYM14DTO dto) throws BLException {
		
		log.debug("========报表版本信息查询处理开始========");
		
		//报表信息取得
		dto.setReportFileDefinition(this.reportFileDefinitionBL.searchReportFileDefinitionByKey(dto.getReportFileVersionSearchCond().getRfdid()));
		
		//报表版本信息取得
		List<ReportFileVersion> reportFileVersionList = this.reportFileVersionBL.searchReportFileVersion(dto.getReportFileVersionSearchCond(), 0, 0);
		
		dto.setReportFileVersionList(reportFileVersionList);
		
		log.debug("========报表版本信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 指定当前版本处理
	 *
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 */
	public IGSYM14DTO assignCurrentReportFileVersionAction(IGSYM14DTO dto) throws BLException {
		
		log.debug("========指定当前版本处理开始========");
		
		//报表版本信息取得
		ReportFileVersion rfv = this.reportFileVersionBL.searchReportFileVersionByKey(dto.getRfvid());
		
		//版本信息取得
		ReportFileDefinition rfd = this.reportFileDefinitionBL.searchReportFileDefinitionByKey(rfv.getRfdid());
		
		ReportFileDefinitionTB rfdTB = (ReportFileDefinitionTB)SerializationUtils.clone(rfd);
		
		rfdTB.setRfdversion(rfv.getRfvversion());//当前版本
		
		rfdTB.setRfdinstime(rfv.getRfvinstime());//创建时间
		
		//更新报表信息
		this.reportFileDefinitionBL.updateReportFileDefinition(rfdTB);
		
		dto.addMessage(new ActionMessage("IGSYM1405.I001"));
		
		log.debug("========指定当前版本处理终了========");
		return dto;
	}
	
	/**
	 * 取得对象名
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSYM14DTO getObjectName(IGSYM14DTO dto) throws BLException {
		List<LabelValueBean> objectNameList=new ArrayList<LabelValueBean>();
		IGSYM1407Form form=dto.getIgsym1407Form();
		if(form!=null){
			//模板名字
			String rtname=form.getReportname();
			if(rtname!=null&&!"".equals(rtname)){
				SOC0424SearchCondImpl rtCond=new SOC0424SearchCondImpl();
				rtCond.setReportName_eq(rtname);
				List<SOC0424Info> rtList=soc0424BL.searchSOC0424(rtCond);
				if(rtList!=null&&rtList.size()>0){
					Object_ListSearchCondImpl cond=new Object_ListSearchCondImpl();
					cond.setObject_Type(rtList.get(0).getRtType());
					cond.setDataId(form.getDataid());
					List<Object_ListInfo> object_List = object_ListBL.searchObject_List(cond);
					for (Object_ListInfo object_ListInfo : object_List) {
						LabelValueBean lvb=new LabelValueBean(object_ListInfo.getObject_Name(),object_ListInfo.getObject_Name());
						objectNameList.add(lvb);
					}
					dto.setObjectNameList(objectNameList);
				}
			}
		}
		return dto;
	}

	/**
	 * 获取流程类型和报表模板数据集
	 * @return
	 * @throws BLException
	 */
	public IGSYM14DTO searchPrtypeAndRfdFilenameList(IGSYM14DTO dto) throws BLException {
		log.debug("========获取流程类型和报表模板数据集开始========");
		IG380SearchCondImpl cond=new IG380SearchCondImpl();
		//流程类型取得
		cond.setPtid(8);
		cond.setPdstatus("a");
		List<IG380Info> ig380List=this.ig380BL.searchIG380Info(cond);
		List<LabelValueBean> prtypeList = new ArrayList<LabelValueBean>();
		prtypeList.add(new LabelValueBean("",""));
		for(IG380Info info:ig380List){
			prtypeList.add(new LabelValueBean(info.getPdname(), info.getPdid()));
		}
		dto.setPrtypeList(prtypeList);
		
		log.debug("========获取流程类型和报表模板数据集结束========");
		return dto;
	}

}
