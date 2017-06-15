/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.rpt.bl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;
import org.apache.struts.util.MessageResources;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.CodeDetailDefBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.CodeDetailDef;
import com.deliverik.framework.model.condition.CodeDetailDefSearchCondImpl;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.rpt.bl.task.SOC0202BL;
import com.deliverik.infogovernor.rpt.bl.task.SOC0204BL;
import com.deliverik.infogovernor.rpt.bl.task.SOC0205BL;
import com.deliverik.infogovernor.rpt.bl.task.SOC0206BL;
import com.deliverik.infogovernor.rpt.bl.task.SOC0207BL;
import com.deliverik.infogovernor.rpt.bl.task.SOC0208BL;
import com.deliverik.infogovernor.rpt.bl.task.SOC0209BL;
import com.deliverik.infogovernor.rpt.dto.IGRPT02DTO;
import com.deliverik.infogovernor.rpt.form.IGRPT0201Form;
import com.deliverik.infogovernor.rpt.form.IGRPT0205Form;
import com.deliverik.infogovernor.rpt.form.IGRPT0207Form;
import com.deliverik.infogovernor.rpt.model.SOC0202Info;
import com.deliverik.infogovernor.rpt.model.SOC0204Info;
import com.deliverik.infogovernor.rpt.model.SOC0205Info;
import com.deliverik.infogovernor.rpt.model.SOC0206Info;
import com.deliverik.infogovernor.rpt.model.SOC0207Info;
import com.deliverik.infogovernor.rpt.model.SOC0208Info;
import com.deliverik.infogovernor.rpt.model.SOC0209Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0202SearchCondImpl;
import com.deliverik.infogovernor.rpt.model.condition.SOC0204SearchCondImpl;
import com.deliverik.infogovernor.rpt.model.condition.SOC0205SearchCond;
import com.deliverik.infogovernor.rpt.model.condition.SOC0205SearchCondImpl;
import com.deliverik.infogovernor.rpt.model.condition.SOC0206SearchCondImpl;
import com.deliverik.infogovernor.rpt.model.condition.SOC0207SearchCond;
import com.deliverik.infogovernor.rpt.model.condition.SOC0207SearchCondImpl;
import com.deliverik.infogovernor.rpt.model.condition.SOC0208SearchCondImpl;
import com.deliverik.infogovernor.rpt.model.condition.SOC0209SearchCondImpl;
import com.deliverik.infogovernor.rpt.model.entity.SOC0202TB;
import com.deliverik.infogovernor.rpt.model.entity.SOC0205TB;
import com.deliverik.infogovernor.rpt.model.entity.SOC0206TB;
import com.deliverik.infogovernor.rpt.model.entity.SOC0207TB;
import com.deliverik.infogovernor.rpt.model.entity.SOC0208TB;
import com.deliverik.infogovernor.rpt.model.entity.SOC0210;
import com.deliverik.infogovernor.rpt.util.JacobWordUtil;
import com.deliverik.infogovernor.soc.mnt.bl.task.MonitorObjectBL;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectInfo;

/**
 * 概述: 事件和变更服务效率业务逻辑实现 功能描述: 事件和变更服务效率业务逻辑实现 创建记录: 2011/11/23 修改记录: 2012/06/08
 */
public class IGRPT02BLImpl extends BaseBLImpl implements IGRPT02BL {
	static Log log = LogFactory.getLog(IGRPT02BLImpl.class);

	protected MessageResources resources = MessageResources
			.getMessageResources("com.deliverik.infogovernor.comResources");
	
	/** 自定义报告 */
	protected SOC0204BL soc0204BL;
	
	/**
	 * 自定义报告取得
	 *
	 * @return soc0204BL 自定义报告
	 */
	public SOC0204BL getSoc0204BL() {
		return soc0204BL;
	}

	/**
	 * 自定义报告设定
	 *
	 * @param soc0204BL 自定义报告
	 */
	public void setSoc0204BL(SOC0204BL soc0204BL) {
		this.soc0204BL = soc0204BL;
	}
	/** codedetailBL */
	protected CodeDetailBL codeDetailBL;

	/** 监控对象BL */
	protected MonitorObjectBL monitorObjectBL;
	/** 自动报告模板BL */
	protected SOC0207BL soc0207BL;
	/** 自动报告模板映射BL */
	protected SOC0206BL soc0206BL;
	/** 自动报表报告管理BL */
	protected SOC0205BL soc0205BL;
	/** 附加报表业务BL */
	protected SOC0202BL soc0202BL;

	/** 流程来源BL */
	protected SOC0209BL soc0209BL;

	/** 事件和变更服务效率BL */
	protected SOC0208BL soc0208BL;

	/** 流程基础数据BL */
	protected CodeDetailDefBL codeDetailDefBL;

	/** 日期格式 */
	protected SimpleDateFormat noFormat = new SimpleDateFormat(
			"yyyyMMdd_HHmmss");

	/** 日期格式 */
	protected SimpleDateFormat secondFormat = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");

	/**
	 * codedetailBL设定
	 * 
	 * @param codeDetailBL
	 *            codedetailBL
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	/**
	 * 监控对象BL设定
	 * 
	 * @param monitorObjectBL
	 *            监控对象BL
	 */
	public void setMonitorObjectBL(MonitorObjectBL monitorObjectBL) {
		this.monitorObjectBL = monitorObjectBL;
	}

	/**
	 * 自动报告模板BL设定
	 * 
	 * @param soc0207BL
	 *            自动报告模板BL
	 */
	public void setSoc0207BL(SOC0207BL soc0207BL) {
		this.soc0207BL = soc0207BL;
	}

	/**
	 * 自动报告模板映射BL设定
	 * 
	 * @param soc0206BL
	 *            自动报告模板映射BL
	 */
	public void setSoc0206BL(
			SOC0206BL soc0206BL) {
		this.soc0206BL = soc0206BL;
	}

	/**
	 * 自动报表报告管理BL设定
	 * 
	 * @param reportManageBL
	 *            自动报表报告管理BL
	 */
	public void setSoc0205BL(SOC0205BL reportManageBL) {
		this.soc0205BL = reportManageBL;
	}

	/**
	 * 附加报表业务BL设定
	 * 
	 * @param reportAnnexationBL
	 *            附加报表业务BL
	 */
	public void setSoc0202BL(SOC0202BL reportAnnexationBL) {
		this.soc0202BL = reportAnnexationBL;
	}

	/**
	 * 流程来源BL设定
	 * 
	 * @param processRecordInfoVWBL
	 *            流程来源BL
	 */
	public void setSoc0209BL(
			SOC0209BL processRecordInfoVWBL) {
		this.soc0209BL = processRecordInfoVWBL;
	}

	/**
	 * 事件和变更服务效率BL设定
	 * 
	 * @param soc0208BL
	 *            事件和变更服务效率BL
	 */
	public void setSoc0208BL(SOC0208BL soc0208BL) {
		this.soc0208BL = soc0208BL;
	}

	/**
	 * 流程基础数据BL设定
	 * 
	 * @param codeDetailDefBL
	 *            流程基础数据BL
	 */
	public void setCodeDetailDefBL(CodeDetailDefBL codeDetailDefBL) {
		this.codeDetailDefBL = codeDetailDefBL;
	}

	/**
	 * 执行添加变更服务效率处理
	 * 
	 * @throws BLException
	 */
	public void saveAlterationEfficiency() throws BLException {
		log.debug("========变更服务效率处理开始========");
		SOC0209SearchCondImpl processRecordInfoVWSearchCond = new SOC0209SearchCondImpl();
		processRecordInfoVWSearchCond.setPrtype("CD");
		processRecordInfoVWSearchCond.setPropentime(IGStringUtils
				.getCurrentDate());
		List<SOC0209Info> processRecordInfoVWList = this.soc0209BL
				.searchSOC0209(processRecordInfoVWSearchCond);
		CodeDetailDefSearchCondImpl codeDetailDefSearchCond = new CodeDetailDefSearchCondImpl();
		codeDetailDefSearchCond.setCcid("241");
		List<CodeDetailDef> codeDetailDefList = this.codeDetailDefBL
				.searchCodeDetailDef(codeDetailDefSearchCond, 0);
		if (codeDetailDefList != null && codeDetailDefList.size() > 0) {
			for (CodeDetailDef codeDetailDef : codeDetailDefList) {
				Integer count = 0;
				Integer timeConut = 0;
				Integer monthEfficiency = 0;
				SOC0208TB soc0208 = new SOC0208TB();
				soc0208.setPrtype("CD");
				soc0208.setPivaralue(codeDetailDef.getSyscoding());
				soc0208.setEfficiencyTime(IGStringUtils
						.getCurrentDate().substring(0, 7));
				if (processRecordInfoVWList != null
						&& processRecordInfoVWList.size() > 0) {
					for (SOC0209Info processRecordInfoVWInfo : processRecordInfoVWList) {
						if (codeDetailDef.getSyscoding().equals(
								processRecordInfoVWInfo.getPivarvalue()
										.substring(0, 6))) {
							count = count + 1;
							timeConut = timeConut
									+ processRecordInfoVWInfo.getPrfacttime();
						}
					}
				}
				// 本月服务效率
				if (timeConut != 0 && count != 0) {
					monthEfficiency = timeConut / count;
					soc0208.setMonthEfficiency(Integer
							.toString(monthEfficiency));
				} else {
					soc0208.setMonthEfficiency("0");
				}
				SOC0208SearchCondImpl soc0208SearchCond = new SOC0208SearchCondImpl();
				soc0208SearchCond.setPrtype("CD");
				soc0208SearchCond.setIsNotTime(IGStringUtils
						.getCurrentDate().substring(0, 7));
				// 检索变更历史服务效率
				List<SOC0208Info> soc0208InfoList = this.soc0208BL
						.searchSOC0208(soc0208SearchCond);
				if (soc0208InfoList != null
						&& soc0208InfoList.size() > 0) {
					Integer historyEfficiency = 0;
					Integer monthConut = 1;
					for (SOC0208Info soc0208Info : soc0208InfoList) {
						if (codeDetailDef.getCvalue().equals(
								soc0208Info.getPivaralue())) {
							monthConut = monthConut + 1;
							historyEfficiency = historyEfficiency
									+ Integer.parseInt(soc0208Info
											.getMonthEfficiency());
						}
					}
					if (!"0".equals(soc0208.getMonthEfficiency())
							|| historyEfficiency != 0) {
						Integer efficiency = (Integer.parseInt(soc0208
								.getMonthEfficiency()) + historyEfficiency)
								/ monthConut;
						soc0208.setHistoryEfficiency(Integer
								.toString(efficiency));
					} else {
						soc0208.setHistoryEfficiency("0");
					}
				} else {
					soc0208.setHistoryEfficiency(soc0208
							.getMonthEfficiency());
				}
				// 执行添加操作
				this.soc0208BL.registSOC0208(soc0208);
			}
		}
		log.debug("========变更服务效率处理结束========");
	}

	/**
	 * 执行添加事件服务效率处理
	 * 
	 * @throws BLException
	 */
	public void saveIncidentEfficiency() throws BLException {
		log.debug("========事件服务效率处理开始========");
		SOC0209SearchCondImpl processRecordInfoVWSearchCond = new SOC0209SearchCondImpl();
		processRecordInfoVWSearchCond.setPrtype("ID");
		processRecordInfoVWSearchCond.setPropentime(IGStringUtils
				.getCurrentDate());
		List<SOC0209Info> processRecordInfoVWList = this.soc0209BL
				.searchSOC0209(processRecordInfoVWSearchCond);
		CodeDetailDefSearchCondImpl codeDetailDefSearchCond = new CodeDetailDefSearchCondImpl();
		codeDetailDefSearchCond.setCcid("109");
		List<CodeDetailDef> codeDetailDefList = this.codeDetailDefBL
				.searchCodeDetailDef(codeDetailDefSearchCond, 0);
		if (codeDetailDefList != null && codeDetailDefList.size() > 0) {
			for (CodeDetailDef codeDetailDef : codeDetailDefList) {
				Integer count = 0;
				Integer timeConut = 0;
				Integer monthEfficiency = 0;
				SOC0208TB soc0208 = new SOC0208TB();
				soc0208.setPrtype("ID");
				soc0208.setPivaralue(codeDetailDef.getSyscoding());
				soc0208.setEfficiencyTime(IGStringUtils
						.getCurrentDate().substring(0, 7));
				if (processRecordInfoVWList != null
						&& processRecordInfoVWList.size() > 0) {
					for (SOC0209Info processRecordInfoVWInfo : processRecordInfoVWList) {
						if (codeDetailDef.getSyscoding().equals(
								processRecordInfoVWInfo.getPivarvalue()
										.substring(0, 6))) {
							count = count + 1;
							timeConut = timeConut
									+ processRecordInfoVWInfo.getPrfacttime();
						}
					}
				}
				// 本月服务效率
				if (timeConut != 0 && count != 0) {
					monthEfficiency = timeConut / count;
					soc0208.setMonthEfficiency(Integer
							.toString(monthEfficiency));
				} else {
					soc0208.setMonthEfficiency("0");
				}
				SOC0208SearchCondImpl soc0208SearchCond = new SOC0208SearchCondImpl();
				soc0208SearchCond.setPrtype("ID");
				soc0208SearchCond.setIsNotTime(IGStringUtils
						.getCurrentDate().substring(0, 7));
				// 检索事件历史服务效率
				List<SOC0208Info> soc0208InfoList = this.soc0208BL
						.searchSOC0208(soc0208SearchCond);
				if (soc0208InfoList != null
						&& soc0208InfoList.size() > 0) {
					Integer historyEfficiency = 0;
					Integer monthConut = 1;
					for (SOC0208Info soc0208Info : soc0208InfoList) {
						if (codeDetailDef.getCvalue().equals(
								soc0208Info.getPivaralue())) {
							monthConut = monthConut + 1;
							historyEfficiency = historyEfficiency
									+ Integer.parseInt(soc0208Info
											.getMonthEfficiency());
						}
					}
					if (!"0".equals(soc0208.getMonthEfficiency())
							|| historyEfficiency != 0) {
						Integer efficiency = (Integer.parseInt(soc0208
								.getMonthEfficiency()) + historyEfficiency)
								/ monthConut;
						soc0208.setHistoryEfficiency(Integer
								.toString(efficiency));
					} else {
						soc0208.setHistoryEfficiency("0");
					}
				} else {
					soc0208.setHistoryEfficiency(soc0208
							.getMonthEfficiency());
				}
				// 执行添加操作
				this.soc0208BL.registSOC0208(soc0208);
			}
		}
		log.debug("========事件服务效率处理结束========");
	}

	// ================================================2012/06/08=================================================
	/**
	 * 自动报表模板分页查询方法
	 * 
	 * @param IGRPT02DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO searchReportTemplateByCond(IGRPT02DTO dto)
			throws BLException {

		SOC0207SearchCond cond = (SOC0207SearchCond) dto
				.getIGRPT0202Form();
		if (cond == null) {
			cond = new SOC0207SearchCondImpl();
		}
		// 自动报表查询件数取得
		int totalCount = soc0207BL.getSearchCount(cond);

		if (totalCount == 0) {
			log.debug("========自动报表查询数据不存在========");
			dto.addMessage(new ActionMessage("IGRPT0101.E003", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========自动报表查询数据件数过多========");
			dto.addMessage(new ActionMessage("IGRPT0101.E002", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		pDto.setTotalCount(totalCount);

		// 当前页自动报表模板信息取得
		List<SOC0207Info> list = soc0207BL.searchSOC0207(
				cond, pDto.getFromCount(), pDto.getPageDispCount());

		//dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));  //查询结果:xx条;
		dto.setReportTemplateList(list);
		return dto;
	}

	/**
	 * 自动报表模板删除方法
	 * 
	 * @param IGRPT02DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO deleteReportTemplateInstance(IGRPT02DTO dto)
			throws BLException {
		// 取得批量删除id
		String[] rtid = dto.getIGRPT0202Form().getDelid();
		if (rtid != null) {
			for (int i = 0; i < rtid.length; i++) {
				SOC0207TB info = (SOC0207TB) soc0207BL
						.searchSOC0207ByPK(Integer.parseInt(rtid[i]));
				//模板文件路径
				String docPath=ResourceUtility.getString("REPORT_TEM_PATH")+info.getRtRealName();
				if (info != null) {// 存在条目即删除
					soc0207BL.deleteSOC0207(info);
					//删除文件
					deleteFile(docPath);
				} else {
					dto.addMessage(new ActionMessage("IGRPT0101.E001", 0));
				}
			}
		}
		dto.addMessage(new ActionMessage("IGRPT0101.I001", 0));
		dto.setIGRPT0202Form(null);//删除结束后置空条件
		return dto;
	}

	/**
	 * 自动报表模板新增方法
	 * 
	 * @param IGRPT02DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO insertReportTemplateInstance(IGRPT02DTO dto)
			throws BLException {
		IGRPT0201Form form = dto.getIGRPT0201Form();
		//先判断是否有rtId如果有则删除.
		if(form.getRtId()!=null&&form.getRtId()!=0){
				soc0207BL.deleteSOC0207ByPK(form.getRtId());//更新主表
		}
		Map<String, String> map = insertFileAction(dto);
		form.setRtUploadTime(IGStringUtils.getCurrentDate());
		form.setRtRealName(map.get("realfilename"));
		SOC0207Info rtinfo = soc0207BL.registSOC0207(form);
		//插入扫描记录
		//文档名字+路径
		String filePathAndName=ResourceUtility.getString("REPORT_TEM_PATH")+rtinfo.getRtRealName();
		
		insertRTM(rtinfo.getRtId(),filePathAndName);
		initMappingInsertAction(dto,rtinfo);
		
		return dto;
	}
	/**插入模板映射*/
	public List<SOC0206TB> insertRTM(Integer rtId,String temPath)throws BLException {
		JacobWordUtil jwUtil=new JacobWordUtil(false);
		String prefix=IGRptConstantDefine.WORD_FLAG_PREFIX;
		String suffix=IGRptConstantDefine.WORD_FLAG_SUFFIX;
		List<SOC0206TB> list=new ArrayList<SOC0206TB>();
		try{
		List<SOC0210> dtoList=jwUtil.scanDoc(temPath,prefix,suffix);
		if(dtoList!=null){
			for (SOC0210 docTemObj : dtoList) {
				SOC0206TB rtmtb = new SOC0206TB();
				rtmtb.setRtId(rtId);
				rtmtb.setRtmFlag(docTemObj.getFlag());
				rtmtb.setRtNumber(docTemObj.getLocationNum());
				rtmtb.setRtmUsed(IGRptConstantDefine.NOT_IS_USED);
				rtmtb.setRtmImgNumber(IGRptConstantDefine.SHAPE_IMG_LOCATION);
				soc0206BL.registSOC0206(rtmtb);
				list.add(rtmtb);
			}
		}
		
		}catch (Exception e) {
			log.error("====scan doc error==="+e);
		}finally{
			jwUtil.close();
		}
		return list;
	}
	
	/**
	 * 自动报表模板映射初始化方法
	 * @param IGRPT02DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO initMappingInsertAction(IGRPT02DTO dto,SOC0207Info rtinfo)
			throws BLException{
		
		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();

		cond.setCdinfo_eq("1");

		cond.setCcid("827");// dmx
		List<CodeDetail> dmx_list = codeDetailBL.searchCodeDetail(cond, 0);
		cond.setCcid("828");// ibm
		List<CodeDetail> ibm_list = codeDetailBL.searchCodeDetail(cond, 0);
		cond.setCcid("829");// cx
		List<CodeDetail> cx_list = codeDetailBL.searchCodeDetail(cond, 0);
		List<MonitorObjectInfo> ssn_list = monitorObjectBL
				.searchMonitorObject();
		//默认KPI.为存储查出第一个
		if(ssn_list!=null&&ssn_list.size()>0){
			for (int i = 0; i < ssn_list.size(); i++) {
				MonitorObjectInfo info=ssn_list.get(i);
				if(!"001001".equals(info.getMtSyscoding())&&!"001002".equals(info.getMtSyscoding())&&!"001003".equals(info.getMtSyscoding())){
					ssn_list.remove(info);
					i=i-1;
				}
			}
			String syscoding=ssn_list.get(0).getMtSyscoding();
			dto.getIGRPT0201Form().setSyscoding(syscoding);
		}
		dto.setMonitorObjectList(ssn_list);
		dto.setDmx_list(dmx_list);
		dto.setIbm_list(ibm_list);
		dto.setCx_list(cx_list);
		
		dto.getIGRPT0201Form().setRtId(rtinfo.getRtId());
		SOC0206SearchCondImpl rtmCond=new SOC0206SearchCondImpl();
		rtmCond.setRtId_eq(dto.getIGRPT0201Form().getRtId());
		List<SOC0206Info> rtmList=soc0206BL.searchSOC0206(rtmCond);
		dto.setSoc0206List(rtmList);
		
		return dto;
	}
	/**
	 * 自动报表模板更新方法
	 * 
	 * @param IGRPT02DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO updateReportTemplateInstance(IGRPT02DTO dto)
			throws BLException {
		IGRPT0201Form form = dto.getIGRPT0201Form();
		SOC0207Info info = soc0207BL.searchSOC0207ByPK(dto
				.getIGRPT0201Form().getRtId());
		SOC0207TB rttb = (SOC0207TB) SerializationUtils
				.clone(info);
		if (info != null) {
			rttb.setRtName(form.getRtName());
			rttb.setRtDateType(form.getRtDateType());
			if (!form.getAttachFile(0).getFileName().equals("")) {// 判断是否重新上传
				rttb.setRtRealName(insertFileAction(dto).get("realfilename"));
				soc0206BL.deleteByRtId(rttb.getRtId());
				//插入扫描记录
				//文档名字+路径
				String filePathAndName=ResourceUtility.getString("REPORT_TEM_PATH")+rttb.getRtRealName();
				String oldFileName=ResourceUtility.getString("REPORT_TEM_PATH")+info.getRtRealName();
				//如果文件存在文件删除
				File oldFile=new File(oldFileName);
				if(oldFile.exists()){
					oldFile.delete();
				}
				insertRTM(rttb.getRtId(),filePathAndName);
			} else {
				rttb.setRtRealName(info.getRtRealName());
			}
		}
		soc0207BL.updateSOC0207(rttb);//更新主表
		dto.addMessage(new ActionMessage("IGRPT0103.I002", 0));
		return dto;
	}
	/**修改映射关系*/
	public IGRPT02DTO updateSOC0206(IGRPT02DTO dto)throws BLException{
		IGRPT0201Form form=dto.getIGRPT0201Form();
		Integer rtId=form.getRtId();
		
		SOC0207Info info = soc0207BL.searchSOC0207ByPK(dto
				.getIGRPT0201Form().getRtId());
		if (info != null) {
			SOC0207TB rttb = (SOC0207TB) SerializationUtils
			.clone(info);
			rttb.setRtName(form.getRtName());
			rttb.setRtDateType(form.getRtDateType());
			soc0207BL.updateSOC0207(rttb);//更新主表
		
		String[] ssnArr=form.getSsn_select_list1();
		String[] kpiArr=form.getReal_kpi_list();
		String[] ssnTypeArr=form.getSsn_type_list();
		String[] mpIds=form.getMapid();
		if(ssnArr!=null){
			for (int i = 1; i <= ssnArr.length; i++) {
				SOC0206SearchCondImpl rtmCondImpl=new SOC0206SearchCondImpl();
				rtmCondImpl.setRtId_eq(rtId);
				rtmCondImpl.setRtNumber_eq(i);
				List<SOC0206Info> rtmList=soc0206BL.searchSOC0206(rtmCondImpl);
				if(rtmList!=null&&rtmList.size()>0){
					SOC0206TB rtmTB=(SOC0206TB) rtmList.get(0);
					rtmTB.setRtmUsed(IGRptConstantDefine.NOT_IS_USED);
					rtmTB.setRtmSsnType(null);
					rtmTB.setRtmKpi(null);
					rtmTB.setRtmSsn(null);
					if(mpIds!=null&&mpIds.length>0){
						for (int j = 0; j < mpIds.length; j++) {
							Integer rtNum=Integer.parseInt(mpIds[j]);
							if(rtNum==i){
								rtmTB.setRtmUsed(IGRptConstantDefine.IS_USED);
								rtmTB.setRtmSsnType(ssnTypeArr[rtNum-1]);
								rtmTB.setRtmKpi(kpiArr[rtNum-1]);
								rtmTB.setRtmSsn(ssnArr[rtNum-1]);
							}
						}
					}
					soc0206BL.updateSOC0206(rtmTB);
				}
			}
		}
		form.setMode("0");
		dto.addMessage(new ActionMessage("IGRPT0103.I003", 0));
		}
		return dto;
	}
	/**
	 * 自动报表模板更新画面显示方法
	 * 
	 * @param IGRPT02DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO initUpdateReportTemplateAction(IGRPT02DTO dto)
			throws BLException {
		// 查询出对应主表的一条记录
		SOC0207Info info = soc0207BL.searchSOC0207ByPK(dto
				.getIGRPT0201Form().getRtId());
		IGRPT0201Form form = dto.getIGRPT0201Form();
		form.setRtId(info.getRtId());
		form.setRtName(info.getRtName());
		form.setRtSum(info.getRtSum());
		form.setRtRealName(info.getRtRealName());
		form.setRtDateType(info.getRtDateType());
		dto.setIGRPT0201Form(form);
		initMappingInsertAction(dto,info);
		return dto;
	}

	/**
	 * 添加附件调用
	 * 
	 * @param dto
	 * @return Map<String,String> 返回文件信息
	 */
	public Map<String, String> insertFileAction(IGRPT02DTO dto)
			throws BLException {
		// 存储文件信息
		Map<String, String> remap = new HashMap<String, String>();
		// 获取form
		IGRPT0201Form form = dto.getIGRPT0201Form();
		// 上传文件Map
		Map<Integer, FormFile> filemaps = form.getFileMap();
		// 文件名字
		String realfilename = "";
		// 附件编号判断，赋值
		if (filemaps != null && filemaps.size() > 0) {//del
			realfilename = form.getRtRealName();//del
		}//del
		// 转换
		Iterator<Integer> iterator = filemaps.keySet().iterator();
		// 循环上传文件
		while (iterator.hasNext()) {
			FormFile file = (FormFile) filemaps.get(iterator.next());
			if (file != null) {
				// 上传文件存在的情况
				// 上传文件路径
				String rootPath = ResourceUtility.getString("REPORT_TEM_PATH");
				realfilename = file.getFileName();

				// 文件上传处理
				try {
					// 调用自己应用的上传文件
					saveFile(file, rootPath, realfilename, form.getMode());
				} catch (FileNotFoundException e) {
					log.debug(e.getMessage());
				} catch (IOException e) {
					log.debug(e.getMessage());
				}
			}
		}
		remap.put("realfilename", realfilename);
		return remap;
	}

	/**
	 * 文件上传
	 * 
	 * @param file
	 *            上传文件数据
	 * @param path
	 *            上传文件保存目录
	 * @param fileName
	 *            上传文件名
	 * 
	 * @return
	 * @throws BLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws BLException
	 */
	private void saveFile(FormFile file, String path, String fileName,
			String mode) throws FileNotFoundException, IOException, BLException {

		/** 上传文件检测 */
		checkFile(file, mode);
		/** 上传文件路径检测 */
		checkPath(path);
		/** 上传文件流取得 */
		InputStream is = file.getInputStream();
		/** 上传文件流缓存取得 */
		BufferedInputStream inBuffer = new BufferedInputStream(is);
		/** 上传文件保存流取得 */
		FileOutputStream out = new FileOutputStream(path + fileName);
		/** 上传文件保存流缓存取得 */
		BufferedOutputStream outBuffer = new BufferedOutputStream(out);
		/** 上传文件保存 */
		int contents = 0;
		while ((contents = inBuffer.read()) != -1) {
			outBuffer.write(contents);
		}

		outBuffer.flush();

		// 文件流关闭
		inBuffer.close();
		outBuffer.close();

		file.destroy();
	}

	/***
	 * 上传文件检测
	 * 
	 * @param file
	 *            上传文件数据
	 * @throws BLException
	 * @throws BLException
	 */
	private void checkFile(FormFile file, String mode) throws BLException {

		// 文件大小检查
		if (file == null || file.getFileSize() < 0.0) {
			// 
			throw new BLException("IGCO10000.E005");
		}
		// 重复文件的判断
		if (mode.equals("1")) {
			// 更新上传可以覆盖
		} else {
			// 新增上传不允许覆盖
			String filename = file.getFileName();
			List<SOC0207Info> list_tmp = soc0207BL
					.searchSOC0207();
			for (SOC0207Info rtinfo : list_tmp) {
				if (filename.equalsIgnoreCase(rtinfo.getRtRealName())) {
					if(!rtinfo.getRtRealName().equals("")){						
						throw new BLException("IGCO10000.E140", rtinfo.getRtRealName());
					}else{
						throw new BLException("IGCO10000.E005");
					}
				}
			}
		}
		// 文件扩展名检查
		String promitFileType = ResourceUtility.getString("WORD_FILE_TYPE")
				.toUpperCase();
		String fileName = file.getFileName();
		String subFileName = null;
		if (fileName != null) {
			int point = fileName.lastIndexOf(".");
			if (point != -1) {
				subFileName = fileName.substring(point + 1);
				boolean isPromitType=false;
				for (int i = 0; i < promitFileType.split(",").length; i++) {					
					if (promitFileType.split(",")[i].equalsIgnoreCase(subFileName)) {
						isPromitType=true;
						break;// 上传仅word
					}
				}
				if (!isPromitType) {					
					throw new BLException("IGCO10000.E007", subFileName);
				}
			}
		}
	}

	/***
	 * 文件目录检查
	 * 
	 * @param path
	 *            文件目录
	 */
	private void checkPath(String path) throws BLException {
		File objFile = new File(path);
		if (objFile.exists() != true && objFile.isDirectory() != true) {

			// 文件路径不存在时，创建目录
			boolean ret = objFile.mkdirs();

			if (!ret) {
				throw new BLException("IGCO10000.E008", path);
			}
		}
	}

	/**
	 * 初始化新增画面
	 */
	public IGRPT02DTO initInsertAction(IGRPT02DTO dto) throws BLException {

		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();

		cond.setCdinfo_eq("1");

		cond.setCcid("253");// dmx
		List<CodeDetail> dmx_list = codeDetailBL.searchCodeDetail(cond, 0);
		cond.setCcid("254");// ibm
		List<CodeDetail> ibm_list = codeDetailBL.searchCodeDetail(cond, 0);
		cond.setCcid("255");// cx
		List<CodeDetail> cx_list = codeDetailBL.searchCodeDetail(cond, 0);

		List<MonitorObjectInfo> ssn_list = monitorObjectBL
				.searchMonitorObject();

		if (ssn_list != null&& dmx_list != null&& ibm_list != null && cx_list != null) {
			dto.setMonitorObjectList(ssn_list);
			dto.setDmx_list(dmx_list);
			dto.setIbm_list(ibm_list);
			dto.setCx_list(cx_list);
		}
		//
		return dto;
	}

	/**
	 * 移动文件
	 * 
	 * @param dto
	 * @throws BLException
	 * @throws FileNotFoundException
	 */
	public void changeFilePath(String filename, String filepath_old,
			String filepath_new) throws FileNotFoundException, IOException {
		// 获取原路径下文件
		File scanfile = new File(filepath_old);
		// 获取所有文件信息
		File[] files = scanfile.listFiles();
		// 获取对应文件
		if (files != null) {
			for (File file : files) {
				// 如果是文件,同时文件名与需要移动的文件名一致,则进行读写工作
				if (file.isFile() && file.getName().equals(filename)) {
					FileUtils.copyFileToDirectory(file, new File(filepath_new));
					// 原文件删除
					file.delete();
				}
			}
		}
	}

	/***
	 * 生成word报告
	 */
	public IGRPT02DTO createWordAction(IGRPT02DTO dto,SOC0205Info rmInfo) throws BLException {
		//1.获取form,得到条件，
		IGRPT0205Form form=dto.getIgrpt0205Form();
		String year=form.getSelRmYear();
		String quarter=form.getSelRmQuarter();
		String month=form.getSelRmMonth();
//		String reportName=form.getRmName();//报告名称
		//2.找到模板,得到映射关系
		String isDel=form.getIsDel();
		//获取生成时间
		String createDate=rmInfo.getCreateDate();
		//获取附加报表
		String[] anIds=form.getAnIds();
		SOC0207TB rtTB=(SOC0207TB) rmInfo.getReportTemplateTB();
		if(rtTB!=null){
			//时间类型
			String dateType=rtTB.getRtDateType();
			List<SOC0206TB> rtmList=rtTB.getRtmList();
			List<SOC0210> docList=new ArrayList<SOC0210>();
			if(rtmList!=null&&rtmList.size()>0){
				//3.组拼List<DocTemObj>
				for (int i = 0; i < rtmList.size(); i++) {
					SOC0206TB rtmTB=rtmList.get(i);
					if(IGRptConstantDefine.IS_USED.equals(rtmTB.getRtmUsed())){
						String ssn=rtmTB.getRtmSsn();
						String kpi=rtmTB.getRtmKpi();
						SOC0210 docObj=new SOC0210();
						String fileName="";
						if(IGRptConstantDefine.TEM_TYPE_YEAR.equals(dateType)){
							fileName=year+"Y_"+ssn+kpi;
						}else if(IGRptConstantDefine.TEM_TYPE_QUARTER.equals(dateType)){
							fileName=quarter+"Q_"+ssn+kpi;
						}else if(IGRptConstantDefine.TEM_TYPE_MONTH.equals(dateType)){
							fileName=month+"M_"+ssn+kpi;
						}
						String docPath=ResourceUtility.getString("BIRT_GFILE_PATH")+year+"/"+ssn+kpi+"/"+fileName+".doc";
						docObj.setDocPath(docPath.toString());
						docObj.setImgStr(fileName);
						docObj.setDocName(fileName);
						docObj.setShapeIndex(rtmTB.getRtmImgNumber());
						docObj.setFlag(rtmTB.getRtmFlag());
						docList.add(docObj);
					}
				}
			}
			if(anIds!=null&&anIds.length>0){
				//.组拼List<DocTemObj> 附加报表 
				for (int i = 0; i < anIds.length; i++) {
					SOC0202TB raInfo=(SOC0202TB) soc0202BL.searchSOC0202ByPK(Integer.parseInt(anIds[i]));
					String fileName=raInfo.getRaName();
					String fileRealName=raInfo.getRaRealName();
					String ssn=raInfo.getRaSsn();
					String kpi=raInfo.getRaKpi();
					SOC0210 docObj=new SOC0210();
					String docPath=ResourceUtility.getString("CUSTOM_BIRT_GFILE_PATH")+ssn+kpi+"/"+fileRealName;
					docObj.setDocPath(docPath);
					docObj.setShapeIndex(IGRptConstantDefine.SHAPE_IMG_LOCATION);
					docObj.setFlag(null);
					docObj.setImgStr(fileName);
					docList.add(docObj);
					//如果删除，就删除对象
					if("0".equals(isDel)){
						soc0202BL.deleteSOC0202(raInfo);
					}
				}
			}
			//4.调用JacobWordUtil
			JacobWordUtil jwUtil=new JacobWordUtil(false);
			try {
				//模板路径与名字
				String temPathName=ResourceUtility.getString("REPORT_TEM_PATH")+rtTB.getRtRealName();
				//保存word路径与名字
				String savePath=ResourceUtility.getString("REPORT_WORD_PATH")+rmInfo.getRmId()+"_"+noFormat.format(secondFormat.parse(createDate))+rmInfo.getRmSuffix();
				jwUtil.createWordReport(temPathName, docList, savePath);
			} catch (ParseException e) {
				e.printStackTrace();
				log.error("===========ReportManageInfo with id"+rmInfo.getRmId()+" createDate Format is wrong");
			}finally{
				jwUtil.close();
			}
			//如果删除，就删除附加文件
			if("0".equals(isDel)){
				//删除文件
				for (int i = 0; i < docList.size(); i++) {
					if(docList.get(i).getFlag()==null){//等于null时为附加文件
						deleteFile(docList.get(i).getDocPath());
					}
					
				}
			}
		}
		return dto;
	}
	/**初始化查询附加报表*/
	public IGRPT02DTO searchInitAnnexationAction(IGRPT02DTO dto)
			throws BLException {
		IGRPT0207Form form=dto.getIgrpt0207Form();
		if(form!=null){
			Integer rmId=form.getRmId();
			SOC0205Info rmInfo=soc0205BL.searchSOC0205ByPK(rmId);
			if(rmInfo!=null){
				dto.setReportName(rmInfo.getRmName());
			}else{
				return dto;
			}
			//查询条件
			SOC0202SearchCondImpl cond=new SOC0202SearchCondImpl();
			User curUser=dto.getCurUser();
			//用户名字
			cond.setRaUserName_eq(curUser.getUsername());
			List<SOC0202Info> raInfoList=soc0202BL.searchSOC0202(cond);
			if(raInfoList==null||raInfoList.size()==0){
				dto.addMessage(new ActionMessage("IGRPT0107.E001"));
			}
			dto.setRaInfoList(raInfoList);
		}
		return dto;
	}

	/**删除附加报表*/
	public IGRPT02DTO deleteReportAnnexationInstance(IGRPT02DTO dto)
			throws BLException {
		log.debug("===========delete reportAnnexation start============");
		IGRPT0205Form form=dto.getIgrpt0205Form();
		if(form!=null){
			String[] anIds=form.getAnIds();
			if(anIds!=null&&anIds.length>0){
				for (int i = 0; i < anIds.length; i++) {
					SOC0202TB raInfo=(SOC0202TB) soc0202BL.searchSOC0202ByPK(Integer.parseInt(anIds[i]));
					//删除文件
					String ssn=raInfo.getRaSsn();
					String kpi=raInfo.getRaKpi();
					String fileRealName=raInfo.getRaRealName();
					String docPath=ResourceUtility.getString("CUSTOM_BIRT_GFILE_PATH")+ssn+kpi+"/"+fileRealName;
					soc0202BL.deleteSOC0202(raInfo);
					deleteFile(docPath);
				}
			}
		}
		dto.addMessage(new ActionMessage("IGRPT0107.I001"));
		log.debug("===========delete reportAnnexation end============");
		return dto;
	}
	/**
	 * 报表管理分页查询
	 * 
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO searchReportManageByCond(IGRPT02DTO dto)throws BLException{
		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		SOC0205SearchCond cond=dto.getIGRPT0204Form();
		//IGRPT0104Form form=dto.getIGRPT0104Form();
		if(cond==null){
			cond=new SOC0205SearchCondImpl();
		}
		//String rtDateType_eq=form.getRtdatetype_eq();
		// 报表管理查询件数取得
		int totalCount = soc0205BL.getSearchCount(cond);
		if (totalCount == 0) {
			log.debug("========报表管理查询数据不存在========");
			dto.addMessage(new ActionMessage("IGRPT0104.E003", 0));
			return dto;
		}
		
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========报表管理查询数据件数过多========");
			dto.addMessage(new ActionMessage("IGRPT0101.E002", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		pDto.setTotalCount(totalCount);
		List<SOC0205Info> reportManageList =soc0205BL.searchSOC0205(cond,pDto.getFromCount(),pDto.getPageDispCount());
		dto.setSoc0205List(reportManageList);
		return dto;
	}
	/**
	 * 报告管理删除
	 * 
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO deleteReportManageInstance(IGRPT02DTO dto)throws BLException{
		// 取得批量删除id by 主键
		String[] delid = dto.getIGRPT0204Form().getDelid();
		if (delid != null) {
			Integer delpk=null;
			for (int i = 0; i < delid.length; i++) {
				delpk=Integer.parseInt(delid[i]);
				SOC0205TB rmTb=(SOC0205TB) soc0205BL.searchSOC0205ByPK(delpk);
				String docPath="";
				try {
					docPath = ResourceUtility.getString("REPORT_WORD_PATH")+rmTb.getRmId()+"_"+noFormat.format(secondFormat.parse(rmTb.getCreateDate()))+rmTb.getRmSuffix();
				} catch (ParseException e) {
					log.debug("====delete ReportManage==="+e);
				}
				soc0205BL.deleteSOC0205(rmTb);
				deleteFile(docPath);
			}
		}
		dto.addMessage(new ActionMessage("IGRPT0104.I001", 0));
		return dto;
	}
	/**
	 * 报告管理新增
	 * 
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO insertReportManageInstance(IGRPT02DTO dto)throws BLException{
		//获取05form
		IGRPT0205Form form =dto.getIgrpt0205Form();
		if(form!=null){
			SOC0205TB rmTb=new SOC0205TB();
			rmTb.setRmName(form.getRmName());
			//模板对象
			SOC0207TB rtTB= (SOC0207TB) soc0207BL.searchSOC0207ByPK(Integer.parseInt(form.getSelTemplate()));
			rmTb.setReportTemplateTB(rtTB);
			rmTb.setRmYear(form.getSelRmYear());
			rmTb.setRtName(rtTB.getRtName());
			String curDateType=rtTB.getRtDateType();
			rmTb.setRmDateType(curDateType);
			int year =Integer.parseInt(form.getSelRmYear());
			String curRmDateStr="2012/01/01";
			if(curDateType.equals("0")){//月份
				String day="";
				String monthStr=form.getSelRmMonth();
				boolean d31=monthStr.equals("01")||monthStr.equals("03")||monthStr.equals("05")
				||monthStr.equals("07")||monthStr.equals("08")||monthStr.equals("10")||monthStr.equals("12");
				if(d31){
					day="31";
				}
				boolean d30=monthStr.equals("04")||monthStr.equals("06")||monthStr.equals("09")||monthStr.equals("11");
				if(d30){
					day="30";
				}
				if(monthStr.equals("02")){
					if(year%100==0||year%400==0||year%4==0){
						day="29";
					}else{
						day="28";
					}
				}
				rmTb.setRmMonth(form.getSelRmMonth());
				curRmDateStr=year+"/"+form.getSelRmMonth()+"/"+day;
			}else if(curDateType.equals("1")){//季度
				String quarter=form.getSelRmQuarter();
				if(quarter.equals("1")){
					curRmDateStr=year+"/03/31";
				}else if(quarter.equals("2")){
					curRmDateStr=year+"/06/30";
				}else if(quarter.equals("3")){
					curRmDateStr=year+"/09/30";
				}else if(quarter.equals("4")){
					curRmDateStr=year+"/12/31";
				}
				rmTb.setRmQuarter(form.getSelRmQuarter());
			}else if(curDateType.equals("2")){
				curRmDateStr=year+"/12/31";
			}
			//保存使用过的附加报表
			String[] raIds=form.getAnIds();
			if(raIds!=null&&raIds.length>0){
				String raStr="";
				for (int i = 0; i < raIds.length; i++) {
					if(i==0){
						raStr+=raIds[i];
					}else{
						raStr+=","+raIds[i];
					}
				}
				rmTb.setRaStr(raStr);
			}
			rmTb.setRmLastDay(curRmDateStr);
			Date curDate=new Date();
			rmTb.setCreateDate(secondFormat.format(curDate));
			rmTb.setLastAnnexationDate(secondFormat.format(curDate));
			String rtRealName=rtTB.getRtRealName();
			String rmSuffix=rtRealName.substring(rtRealName.indexOf("."),rtRealName.length());
			rmTb.setRmSuffix(rmSuffix);
			SOC0205Info rmInfo=soc0205BL.registSOC0205(rmTb);
			dto.addMessage(new ActionMessage("IGRPT0105.I001", 0));
			//生成报告
			dto=createWordAction(dto,rmInfo);
			
		}else{
			dto.addMessage(new ActionMessage("IGRPT0105.E001", 0));
		}
		return dto;
	}

	/**新增报告初始化*/
	public IGRPT02DTO insertReportManageInitAction(IGRPT02DTO dto)
			throws BLException {
		List<SOC0207Info> rtInfoList=soc0207BL.searchSOC0207();
		dto.setReportTemplateList(rtInfoList);
		//查询条件
		SOC0202SearchCondImpl cond=new SOC0202SearchCondImpl();
		User curUser=dto.getCurUser();
		//用户名字
		cond.setRaUserName_eq(curUser.getUsername());
		List<SOC0202Info> raInfoList=soc0202BL.searchSOC0202(cond);
		if(raInfoList==null||raInfoList.size()==0){
			dto.addMessage(new ActionMessage("IGRPT0107.E001"));
		}
		dto.setRaInfoList(raInfoList);
		return dto;
	}
	/**删除文件*/
	private void deleteFile(String path){
		
		File raFile=new File(path);
		if(raFile.exists()){
			raFile.delete();
		}
	}
	/**修改报告初始化*/
	public IGRPT02DTO initUpdateReportManageInstance(IGRPT02DTO dto)throws BLException{
		IGRPT0205Form form=dto.getIgrpt0205Form();
		Integer rmId=form.getRmId();
		SOC0205TB rmTB=(SOC0205TB) soc0205BL.searchSOC0205ByPK(rmId);
		
		if(rmTB!=null){
			//设置报告名字
			form.setRmName(rmTB.getRmName());
			//设置默认报告模板
			if(rmTB.getReportTemplateTB()!=null){
				form.setSelTemplate(rmTB.getReportTemplateTB().getRtId()+"");
			}else{
				form.setSelTemplate("none");
			}
			String dateType=rmTB.getRmDateType();
			//设置时间类型
			form.setRmDateType(dateType);
			//设置年季月
			form.setSelRmYear(rmTB.getRmYear());
			if(dateType.equals("0")){
				form.setSelRmMonth(rmTB.getRmMonth());
			}else if(dateType.equals("1")){
				form.setSelRmQuarter(rmTB.getRmQuarter());
			}
			form.setRmId(rmTB.getRmId());
			
			//初始化报告模板
			List<SOC0207Info> rtInfoList=soc0207BL.searchSOC0207();
			dto.setReportTemplateList(rtInfoList);
			//查询条件
			SOC0202SearchCondImpl cond=new SOC0202SearchCondImpl();
			User curUser=dto.getCurUser();
			//用户名字
			cond.setRaUserName_eq(curUser.getUsername());
			List<SOC0202Info> raInfoList=soc0202BL.searchSOC0202(cond);
			if(raInfoList==null||raInfoList.size()==0){
				dto.addMessage(new ActionMessage("IGRPT0107.E001"));
			}else{
				//获取使用过的附加报表ID
				String raStr=rmTB.getRaStr();
				if(raStr!=null&&!"".equals(raStr)){
					String[] raArr=raStr.split(",");
					if(raArr!=null){
						for (int i = 0; i < raArr.length; i++) {
							int raArrId=Integer.parseInt(raArr[i]);
							for (SOC0202Info ra : raInfoList) {
								if(raArrId==ra.getRaId()){
									SOC0202TB raTb=(SOC0202TB) ra;
									raTb.setIsUsed("1");
									break;
								}
							}
						}
					}
				}
			}
			dto.setRaInfoList(raInfoList);
		}
		return dto;
	}
	/**
	 * 报告管理修改
	 * 
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO updateReportManageInstance(IGRPT02DTO dto)throws BLException{
		//获取05form
		IGRPT0205Form form =dto.getIgrpt0205Form();
		if(form!=null){
			Integer rmId=form.getRmId();
			SOC0205TB rmTb=(SOC0205TB) soc0205BL.searchSOC0205ByPK(rmId);
			if(rmTb!=null){
				String createDate=rmTb.getCreateDate();
				try {
					String filePath = ResourceUtility.getString("REPORT_WORD_PATH")+rmTb.getRmId()+"_"+noFormat.format(secondFormat.parse(createDate))+rmTb.getRmSuffix();
					deleteFile(filePath);
				} catch (ParseException e) {
					log.debug("====delete ReportManage==="+e);
				}
			}else{
				rmTb=new SOC0205TB();
			}
			rmTb.setRmName(form.getRmName());
			
			//模板对象
			SOC0207TB rtTB= (SOC0207TB) soc0207BL.searchSOC0207ByPK(Integer.parseInt(form.getSelTemplate()));
			rmTb.setReportTemplateTB(rtTB);
			rmTb.setRmYear(form.getSelRmYear());
			rmTb.setRtName(rtTB.getRtName());
			String curDateType=rtTB.getRtDateType();
			rmTb.setRmDateType(curDateType);
			int year =Integer.parseInt(form.getSelRmYear());
			String curRmDateStr="2012/01/01";
			if(curDateType.equals("0")){//月份
				String day="";
				String monthStr=form.getSelRmMonth();
				boolean d31=monthStr.equals("01")||monthStr.equals("03")||monthStr.equals("05")
				||monthStr.equals("07")||monthStr.equals("08")||monthStr.equals("10")||monthStr.equals("12");
				if(d31){
					day="31";
				}
				boolean d30=monthStr.equals("04")||monthStr.equals("06")||monthStr.equals("09")||monthStr.equals("11");
				if(d30){
					day="30";
				}
				if(monthStr.equals("02")){
					if(year%100==0||year%400==0||year%4==0){
						day="29";
					}else{
						day="28";
					}
				}
				rmTb.setRmMonth(form.getSelRmMonth());
				rmTb.setRmQuarter(null);
				curRmDateStr=year+"/"+form.getSelRmMonth()+"/"+day;
			}else if(curDateType.equals("1")){//季度
				String quarter=form.getSelRmQuarter();
				if(quarter.equals("1")){
					curRmDateStr=year+"/03/31";
				}else if(quarter.equals("2")){
					curRmDateStr=year+"/06/30";
				}else if(quarter.equals("3")){
					curRmDateStr=year+"/09/30";
				}else if(quarter.equals("4")){
					curRmDateStr=year+"/12/31";
				}
				rmTb.setRmQuarter(form.getSelRmQuarter());
				rmTb.setRmMonth(null);
			}else if(curDateType.equals("2")){
				curRmDateStr=year+"/12/31";
			}
			//保存使用过的附加报表
			String[] raIds=form.getAnIds();
			if(raIds!=null&&raIds.length>0){
				String raStr="";
				for (int i = 0; i < raIds.length; i++) {
					if(i==0){
						raStr+=raIds[i];
					}else{
						raStr+=","+raIds[i];
					}
				}
				rmTb.setRaStr(raStr);
			}
			//存放后缀名
			String rtRealName=rtTB.getRtRealName();
			String rmSuffix=rtRealName.substring(rtRealName.indexOf("."),rtRealName.length());
			rmTb.setRmSuffix(rmSuffix);
			rmTb.setRmLastDay(curRmDateStr);
			Date curDate=new Date();
			if(rmTb.getCreateDate()==null){
				rmTb.setCreateDate(secondFormat.format(curDate));
			}
			rmTb.setLastAnnexationDate(secondFormat.format(curDate));
			SOC0205Info rmInfo=soc0205BL.updateSOC0205(rmTb);
			dto.addMessage(new ActionMessage("IGRPT0105.I002", 0));
			//生成报告
			dto=createWordAction(dto,rmInfo);
			
		}else{
			dto.addMessage(new ActionMessage("IGRPT0105.E001", 0));
		}
		return dto;
	}

	/**
	 * 自定义报告快速链接
	 * 
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO searchSOC0204Action(IGRPT02DTO dto)throws BLException {
		log.debug("=====自定义报告快速链接检索开始=====");
		SOC0204SearchCondImpl cond =new SOC0204SearchCondImpl();
		cond.setRclUserId_eq(dto.getCurUser().getUserid());
		cond.setRclReportType_eq("01");
		List<SOC0204Info> list_p=soc0204BL.searchSOC0204(cond);
		if(list_p.size()>0){
			dto.setReportCustomLinkList_Pref(list_p);//01性能
		}
		cond.setRclReportType_eq("03");
		List<SOC0204Info> list_c=soc0204BL.searchSOC0204(cond);
		if(list_c.size()>0){
			dto.setReportCustomLinkList_Cap(list_c);//03容量
		}
		log.debug("=====自定义报告快速链接检索结束=====");
		return dto;
	}
}
