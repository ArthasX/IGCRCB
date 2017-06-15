/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.soc.mnt.bl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;
import org.apache.struts.util.MessageResources;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.soc.asset.bl.task.SOC0113BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0120BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0305BL;
import com.deliverik.framework.soc.asset.model.SOC0113Info;
import com.deliverik.framework.soc.asset.model.SOC0120Info;
import com.deliverik.framework.soc.asset.model.SOC0305Info;
import com.deliverik.framework.soc.asset.model.SOC0307Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0120SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0305TB;
import com.deliverik.infogovernor.rpt.bl.task.SOC0423BL;
import com.deliverik.infogovernor.rpt.bl.task.SOC0429BL;
import com.deliverik.infogovernor.rpt.model.SOC0423Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0423SearchCondImpl;
import com.deliverik.infogovernor.rpt.model.entity.SOC0423TB;
import com.deliverik.infogovernor.soc.mnt.bl.task.SOC0306BL;
import com.deliverik.infogovernor.soc.mnt.dto.IGMNT02DTO;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0112Form;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0207Form;
import com.deliverik.infogovernor.soc.mnt.model.SOC0306Info;
import com.deliverik.infogovernor.soc.mnt.model.condition.SOC0306SearchCondImpl;
import com.deliverik.infogovernor.util.CodeDefine;
/**
 * 概述:容量监控管理接口实现类
 * 功能描述：
 * 创建记录：
 */
public class IGMNT02BLImpl extends BaseBLImpl implements IGMNT02BL{

	static Log log = LogFactory.getLog(IGMNT02BLImpl.class);
	
	protected MessageResources resources = MessageResources.getMessageResources("com.deliverik.infogovernor.soc.mnt.mntResources");
	
	/** 容量监控管理BL*/
	protected SOC0423BL soc0423BL;
	/** 主机视图BL*/
	protected SOC0429BL soc0429BL;
	/**注入SOC0305BL	 */
	protected SOC0305BL soc0305BL;
	/** 导入对象类型 */
	protected SOC0113BL soc0113BL;
	
	protected CodeDetailBL codeDetailBL;
	
	protected SOC0120BL soc0120BL;
	
	/** 性能数据报警BL */
	protected SOC0306BL soc0306BL;
	
	/**
	 * 容量对象监控管理 删除
	 */
	public IGMNT02DTO deleteSOC0423Action(IGMNT02DTO dto)
			throws BLException {
		//预留
		return dto;
	}
	
	/**
	 * 容量对象监控管理 更新
	 */
	public IGMNT02DTO updateSOC0423Action(IGMNT02DTO dto)
	throws BLException {
		
		SOC0423TB instance=null;
		IGMNT0112Form form=dto.getIgmnt0112Form();
		String[] idarr=form.getSelArr();
		if(idarr!=null){
			int num=0;
			for (int i = 0; i < idarr.length; i++) {
				instance=new SOC0423TB();
				num=Integer.parseInt(idarr[i]);
				instance.setId(Integer.parseInt(form.getIds()[num]));
				instance.setName(form.getNames()[num]);
				instance.setObjectName(form.getObjectNames()[num]);
				instance.setObjectType(form.getObjectTypes()[num]);
				instance.setErrorNum(form.getErrorNums()[num]);
				instance.setWarningNum(form.getWarningNums()[num]);
				instance.setStatus(1);
				
				soc0423BL.updateSOC0423(instance);
			}
		}
		dto.addMessage(new ActionMessage("IGMNT0112.I001"));
		return dto;
	}
	
	/**
	 * 容量对象监控管理 获取hostlist for select
	 */
	public IGMNT02DTO initHostListSelectAction(IGMNT02DTO dto)
			throws BLException {
		LabelValueBean lvb=null;
		List<LabelValueBean> lvblist=new ArrayList<LabelValueBean>();
		SOC0423SearchCondImpl cond=new SOC0423SearchCondImpl();
		cond.setObjectType("VG");
		List<SOC0423Info> list=soc0423BL.searchSOC0423(cond);
		if(list.size()>0){
			lvb=new LabelValueBean("","");
			lvblist.add(lvb);
			lvb=new LabelValueBean();
			lvb.setLabel(list.get(0).getName());
			lvb.setValue(list.get(0).getName());
			lvblist.add(lvb);
			for(int t=1;t<list.size();t++){
				if(list.get(t).getName().equals(list.get(t-1).getName())){
					continue;
				}else{
					lvb=new LabelValueBean();
					lvb.setLabel(list.get(t).getName());
					lvb.setValue(list.get(t).getName());
					lvblist.add(lvb);
				}
			}
		}
		dto.setLabelValueBeanList(lvblist);
		return dto;
	}

	
	/**
	 * 
	 * 容量对象监控管理 分页查询
	 * 
	 */
	public IGMNT02DTO searchSOC0423Action(IGMNT02DTO dto)
			throws BLException {
		//获得查询条件form
		IGMNT0112Form form=dto.getIgmnt0112Form();
		//设置条件
		SOC0423SearchCondImpl cond=new SOC0423SearchCondImpl();
		cond.setName_like(form.getName());
		cond.setObjectType(form.getObjectType());
		cond.setObjectName(form.getObjectName());
		//检索总条目
		int totalCount = soc0423BL.getSearchCount(cond);
		
		if (totalCount == 0) {
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount() ) {
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		//调用DAO接口查询
		pDto.setTotalCount(totalCount);
		
		List<SOC0423Info> list=soc0423BL.searchSOC0423(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		dto.setSoc0423List(list);
		
		return dto;
	}

	/**
	 * <p>
	 * Description: 错误日志查询
	 * </p>
	 * 
	 * @param dto IGMNT02DTO
	 * @return IGMNT02DTO
	 * @throws BLException
	 * @update
	 */
	public IGMNT02DTO searchSOC0305Action(IGMNT02DTO dto)
			throws BLException {
		//查询总数
		int totalCount = soc0305BL.getVWSearchCount(dto.getSoc0305SearchCond());
		if(totalCount==0){
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		
		//告警查询页面，查询结果超过10000条时，显示前50条
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			//dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			//return dto;
			totalCount=50;
			if(pDto.getFromCount()==40){//第三页显示10条记录
				pDto.setPageDispCount(10);
			}
		}
		
		//调用DAO接口查询 错误日志
		List<SOC0307Info> storageEventVWInfoList = soc0305BL.searchSOC0307(dto.getSoc0305SearchCond(), pDto.getFromCount(),
				pDto.getPageDispCount());
		pDto.setPageDispCount(20);
		pDto.setTotalCount(totalCount);
		dto.setSoc0307List(storageEventVWInfoList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========错误日志查询处理终了========");
		return dto;
	}

	/**
	 * 导入对象类型
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT02DTO getEiImportProgrammeAction(IGMNT02DTO dto)
			throws BLException {
		log.debug("========导入对象类型查询处理开始========");
		List<SOC0113Info> impTypeInfoList=this.soc0113BL.searchEiImportProgramme();
		List<LabelValueBean> impTypeList = new ArrayList<LabelValueBean>();
		impTypeList.add(new LabelValueBean("",""));
		for(SOC0113Info info : impTypeInfoList){
			impTypeList.add(new LabelValueBean(info.getImpTypename(),info.getImpTypeid().toString()));
		}
		dto.setImpTypeList(impTypeList);
		log.debug("========导入对象类型查询处理结束========");
		return dto;
	}


	/**
	 * 主键检索报警日志
	 */
	public IGMNT02DTO searchSOC0305ByCond(IGMNT02DTO dto) throws BLException {
		//调用DAO接口查询 错误日志
		SOC0305Info storageEvent=null;
		List<SOC0305Info> searchStorageEvent = soc0305BL.searchSoc0305(dto.getSoc0305SearchCond());
		if(searchStorageEvent!=null&&searchStorageEvent.size()>0){
			storageEvent=searchStorageEvent.get(0);
		}
		dto.setSoc0305Info(storageEvent);
		log.debug("========错误日志查询处理终了========");
		return dto;
	}

	/**
	 * 告警处理状态变更	0:未处理	1：已处理
	 */
	public IGMNT02DTO updateSOC0305(IGMNT02DTO dto) throws BLException {
		String[] ids = dto.getIds();
		for (int i = 0; i < ids.length; i++) {
			String id = ids[i];
			SOC0305TB storageEvent = (SOC0305TB)soc0305BL.searchSoc0305ByPK(Integer.valueOf(id));
			storageEvent.setStatus("1");
			soc0305BL.updateSoc0305(storageEvent);
		}
		dto.addMessage(new ActionMessage("IGCO10000.I005",""));
		return dto;
	}


	/**
	 * 告警等级取得
	 */
	public IGMNT02DTO getAlarmSeverity(IGMNT02DTO dto) throws BLException {
		log.debug("========告警等级查询处理开始========");
		CodeDetailSearchCondImpl cond=new CodeDetailSearchCondImpl();
		cond.setCcid(CodeDefine.ALARM_SEVERITY_CODE.getCcid());
		List<CodeDetail> codeDetailList = codeDetailBL.searchCodeDetail(cond, 0);
		List<LabelValueBean> alarmSeverityList = new ArrayList<LabelValueBean>();
		alarmSeverityList.add(new LabelValueBean("",""));
		for(CodeDetail c : codeDetailList){
			alarmSeverityList.add(new LabelValueBean(c.getCvalue(),c.getCvalue()));
		}
		dto.setAlarmSeverityList(alarmSeverityList);
		log.debug("========告警等级查询处理结束========");
		return dto;
	}

	/**
	 * 取得CI名称集合
	 */
	public IGMNT02DTO getCiList(IGMNT02DTO dto) throws BLException {
		log.debug("========CI查询处理开始========");
		SOC0120SearchCondImpl cond=new SOC0120SearchCondImpl();
		cond.setDeleteflag_eq("0");
		List<SOC0120Info> importVersionList = soc0120BL.searchImportVersion(cond);
		List<LabelValueBean> ciList=new ArrayList<LabelValueBean>();
		ciList.add(new LabelValueBean("",""));
		for (SOC0120Info importVersionInfo : importVersionList) {
			int impcitype = importVersionInfo.getImpcitype();
			//过滤掉主机
			if(impcitype==1||impcitype==4||impcitype==7){
				continue;
			}
			LabelValueBean ci=new LabelValueBean(importVersionInfo.getImpeiname(),importVersionInfo.getImpeiname());
			ciList.add(ci);
		}
		dto.setCiList(ciList);
		log.debug("========CI查询处理结束========");
		return dto;
	}
	
	/**
	 * 查询处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT02DTO searchSOC0306Action(IGMNT02DTO dto) throws BLException {
		log.debug("========性能数据报警查询处理开始========");
		//Form取得
		IGMNT0207Form form=dto.getIgmnt0207Form();
		

		// 性能数据报警查询件数取得
		int totalCount = this.soc0306BL.getSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========性能数据报警查询数据不存在========");
			// 性能数据报警查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========性能数据报警查询数据件数过多========");
			// 性能数据报警查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		// 当前页性能数据报警取得
		List<SOC0306Info> soc0306List = this.soc0306BL
				.findSoc0306ByCond(form, pDto.getFromCount(), pDto
						.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setSoc0306List(soc0306List);

		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========性能数据报警查询处理终了========");
		return dto;
	}


	/**
	 * 弹出窗口查询处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT02DTO popSOC0306Action(IGMNT02DTO dto) throws BLException {
		log.debug("========弹出窗口查询处理开始========");
		//Form取得
		SOC0306SearchCondImpl cond = new SOC0306SearchCondImpl();
		cond.setReaddate(null);
		// 性能数据报警查询件数取得
		this.soc0306BL.getSearchCount(cond);

		// 当前页性能数据报警取得
		List<SOC0306Info> soc0306List = this.soc0306BL
				.findSoc0306ByCond(cond, 0, 0);

		dto.setSoc0306List(soc0306List);

		log.debug("========弹出窗口查询处理终了========");
		return dto;
	}

	/**
	 * resources取得
	 *
	 * @return resources resources
	 */
	public MessageResources getResources() {
		return resources;
	}

	/**
	 * resources设定
	 *
	 * @param resources resources
	 */
	public void setResources(MessageResources resources) {
		this.resources = resources;
	}

	/**
	 * codeDetailBL取得
	 *
	 * @return codeDetailBL codeDetailBL
	 */
	public CodeDetailBL getCodeDetailBL() {
		return codeDetailBL;
	}

	/**
	 * codeDetailBL设定
	 *
	 * @param codeDetailBL codeDetailBL
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	/**
	 * 容量监控管理BL取得
	 *
	 * @return soc0423BL 容量监控管理BL
	 */
	public SOC0423BL getSoc0423BL() {
		return soc0423BL;
	}

	/**
	 * 容量监控管理BL设定
	 *
	 * @param soc0423BL 容量监控管理BL
	 */
	public void setSoc0423BL(SOC0423BL soc0423BL) {
		this.soc0423BL = soc0423BL;
	}

	/**
	 * 主机视图BL取得
	 *
	 * @return soc0429BL 主机视图BL
	 */
	public SOC0429BL getSoc0429BL() {
		return soc0429BL;
	}

	/**
	 * 主机视图BL设定
	 *
	 * @param soc0429BL 主机视图BL
	 */
	public void setSoc0429BL(SOC0429BL soc0429BL) {
		this.soc0429BL = soc0429BL;
	}

	/**
	 * 注入SOC0305BL设定
	 *
	 * @param soc0305BL 注入SOC0305BL
	 */
	public void setSoc0305BL(SOC0305BL soc0305BL) {
		this.soc0305BL = soc0305BL;
	}

	/**
	 * 导入对象类型设定
	 *
	 * @param soc0113BL 导入对象类型
	 */
	public void setSoc0113BL(SOC0113BL soc0113BL) {
		this.soc0113BL = soc0113BL;
	}

	/**
	 * soc0120BL设定
	 *
	 * @param soc0120BL soc0120BL
	 */
	public void setSoc0120BL(SOC0120BL soc0120BL) {
		this.soc0120BL = soc0120BL;
	}

	/**
	 * 性能数据报警BL设定
	 *
	 * @param soc0306BL 性能数据报警BL
	 */
	public void setSoc0306BL(SOC0306BL soc0306BL) {
		this.soc0306BL = soc0306BL;
	}




}
