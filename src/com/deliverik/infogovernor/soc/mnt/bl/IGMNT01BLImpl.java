/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.soc.mnt.bl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
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
import com.deliverik.framework.model.entity.CodeDetailTB;
import com.deliverik.framework.model.entity.CodeDetailTBPK;
import com.deliverik.framework.soc.asset.EntityItemKeyWords;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.rpt.bl.task.SOC0203BL;
import com.deliverik.infogovernor.rpt.bl.task.SOC0423BL;
import com.deliverik.infogovernor.rpt.model.SOC0203Info;
import com.deliverik.infogovernor.rpt.model.SOC0423Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0203SearchCondImpl;
import com.deliverik.infogovernor.rpt.model.condition.SOC0423SearchCondImpl;
import com.deliverik.infogovernor.rpt.model.entity.SOC0203TB;
import com.deliverik.infogovernor.rpt.model.entity.SOC0423TB;
import com.deliverik.infogovernor.soc.dbs.bl.task.Collect_Symmetrix_InfoBL;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Info;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_Symmetrix_InfoSearchCondImpl;
import com.deliverik.infogovernor.soc.dbs.model.entity.Collect_Symmetrix_InfoTB;
import com.deliverik.infogovernor.soc.mnt.bl.task.MonitorObjectBL;
import com.deliverik.infogovernor.soc.mnt.bl.task.MonitorObjectDefBL;
import com.deliverik.infogovernor.soc.mnt.bl.task.MonitorTaskObjectBL;
import com.deliverik.infogovernor.soc.mnt.bl.task.MonitorTypeBL;
import com.deliverik.infogovernor.soc.mnt.bl.task.MonitorTypeDefBL;
import com.deliverik.infogovernor.soc.mnt.bl.task.Object_ListBL;
import com.deliverik.infogovernor.soc.mnt.bl.task.SOC0301BL;
import com.deliverik.infogovernor.soc.mnt.bl.task.SOC0304BL;
import com.deliverik.infogovernor.soc.mnt.dto.IGMNT01DTO;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0102Form;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0103Form;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0104Form;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0107Form;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectDefInfo;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectInfo;
import com.deliverik.infogovernor.soc.mnt.model.MonitorTypeDefInfo;
import com.deliverik.infogovernor.soc.mnt.model.MonitorTypeInfo;
import com.deliverik.infogovernor.soc.mnt.model.SOC0301Info;
import com.deliverik.infogovernor.soc.mnt.model.SOC0304Info;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorObjectDefSearchCondImpl;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorObjectSearchCondImpl;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorTypeDefSearchCondImpl;
import com.deliverik.infogovernor.soc.mnt.model.condition.SOC0301SearchCondImpl;
import com.deliverik.infogovernor.soc.mnt.model.condition.SOC0304SearchCondImpl;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorObjectDefTB;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorObjectTB;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorTypeDefTB;
import com.deliverik.infogovernor.soc.mnt.model.entity.SOC0304TB;
import com.deliverik.infogovernor.sym.bl.task.ReportFileDefinitionBL;
import com.deliverik.infogovernor.sym.bl.task.ReportFileVersionBL;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;
import com.deliverik.infogovernor.sym.model.condition.ReportFileDefinitionSearchCondImpl;
import com.deliverik.infogovernor.sym.model.entity.ReportFileDefinitionTB;
import com.deliverik.infogovernor.sym.model.entity.ReportFileVersionTB;
/**
 * 概述:监控管理业务接口实现类
 * 功能描述：
 * 创建记录：张楠    2012/02/09
 */
public class IGMNT01BLImpl extends BaseBLImpl implements IGMNT01BL{

	static Log log = LogFactory.getLog(IGMNT01BLImpl.class);
	
	protected MessageResources resources = MessageResources.getMessageResources("com.deliverik.infogovernor.soc.mnt.mntResources");
	
	/**
	 * DMX实时
	 */
	protected SOC0301BL soc0301BL;	
	
	/** 
	 * 监控类型BL
	 */
	protected MonitorTypeBL monitorTypeBL;
	
	/**
	 * 监控类型阀值信息BL
	 */
	protected MonitorTypeDefBL monitorTypeDefBL;
	
	/**
	 * 监控对象信息BL
	 */
	protected MonitorObjectBL monitorObjectBL;
	/**
	 * debug监控任务BL
	 */
	protected SOC0304BL soc0304BL;
	
	/**
	 * debug监控任务对象BL
	 */
	protected MonitorTaskObjectBL monitorTaskObjectBL;
	/**
	 * 监控对象阀值信息BL
	 */
	protected MonitorObjectDefBL monitorObjectDefBL;
	/**
	 * 获取任务子对象BL
	 */
	protected Object_ListBL object_ListBL;
	
	protected Collect_Symmetrix_InfoBL collect_Symmetrix_InfoBL;
	
	protected SOC0117BL soc0117BL;
	
	/** EntityItemBL */
	protected SOC0118BL soc0118BL;
	
	/** 基础数据BL */
	protected CodeDetailBL codeDetailBL;
	
	/** 报表信息BL */
	protected ReportFileDefinitionBL reportFileDefinitionBL;
	
	/** 报表版本BL */
	protected ReportFileVersionBL reportFileVersionBL;
	
	/** 自动报表BL */
	protected SOC0203BL soc0203BL;
	
	/** 容量对象BL */
	protected SOC0423BL soc0423BL;
	


	/**
	 *  自动报表BL设定
	 * @param soc0203BL
	 */
	public void setSoc0203BL(SOC0203BL soc0203BL) {
		this.soc0203BL = soc0203BL;
	}

	/**
	 * 报表信息BL设定
	 * @param reportFileDefinitionBL
	 */
	public void setReportFileDefinitionBL(
			ReportFileDefinitionBL reportFileDefinitionBL) {
		this.reportFileDefinitionBL = reportFileDefinitionBL;
	}

	

	/**
	 * 获取任务子对象BL设定
	 *
	 * @param object_ListBL 获取任务子对象BL
	 */
	public void setObject_ListBL(Object_ListBL object_ListBL) {
		this.object_ListBL = object_ListBL;
	}


	/**
	 * debug监控任务对象BL设定
	 *
	 * @param monitorTaskObjectBL debug监控任务对象BL
	 */
	public void setMonitorTaskObjectBL(MonitorTaskObjectBL monitorTaskObjectBL) {
		this.monitorTaskObjectBL = monitorTaskObjectBL;
	}

	/**
	 * 报表版本BL设定
	 * @param reportFileVersionBL
	 */
	public void setReportFileVersionBL(ReportFileVersionBL reportFileVersionBL) {
		this.reportFileVersionBL = reportFileVersionBL;
	}

	/**
	 * 基础数据BL设定
	 * @param codeDetailBL
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	
	public void setCollect_Symmetrix_InfoBL(
			Collect_Symmetrix_InfoBL collect_Symmetrix_InfoBL) {
		this.collect_Symmetrix_InfoBL = collect_Symmetrix_InfoBL;
	}
	
	/**
	 * 监控类型BL设定
	 * @param monitorTypeBL
	 */
	public void setMonitorTypeBL(MonitorTypeBL monitorTypeBL) {
		this.monitorTypeBL = monitorTypeBL;
	}
	
	/**
	 * 监控类型阀值信息BL设定
	 * @param monitorTypeDefBL
	 */
	public void setMonitorTypeDefBL(MonitorTypeDefBL monitorTypeDefBL) {
		this.monitorTypeDefBL = monitorTypeDefBL;
	}

	/**
	 * 监控对象信息BL设定
	 * @param monitorObjectBL
	 */
	public void setMonitorObjectBL(MonitorObjectBL monitorObjectBL) {
		this.monitorObjectBL = monitorObjectBL;
	}

	/**
	 * 监控对象阀值信息BL设定
	 * @param monitorObjectDefBL
	 */
	public void setMonitorObjectDefBL(MonitorObjectDefBL monitorObjectDefBL) {
		this.monitorObjectDefBL = monitorObjectDefBL;
	}
    protected SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	/**
	 * 监控管理类型树查询
	 */
	public IGMNT01DTO searchMonitorTypeTreeAction(IGMNT01DTO dto)
			throws BLException {
		log.debug("========监控类型分类树查询处理开始========");
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		List<MonitorTypeInfo> monitorTypeList = monitorTypeBL.searchMonitorType();
		for (MonitorTypeInfo monitorTypeInfo : monitorTypeList) {
			String mtSyscoding = monitorTypeInfo.getMtSyscoding();
			//层次码长度等于3位是根节点
			if(mtSyscoding.length()==3){
				TreeNode pNode = new TreeNode();
				pNode.setId(String.valueOf(monitorTypeInfo.getMtId()));
				pNode.setName(monitorTypeInfo.getMtName());
				//添加孩子结点
				int nowlen = mtSyscoding.length();
				getChildTreeNodeMap(monitorTypeList,pNode,nowlen,mtSyscoding);
				treeNodeMap.put(pNode.getId(),pNode);
			}
		}
		dto.setTreeNodeMap(treeNodeMap);
		
		log.debug("========报表分类树查询处理结束========");
		return dto;
	}
	
	/**
	 * <p>
	 * 查询子结点
	 * </p>
	 * @param 全部的结点LIST
	 * @param 该级结点的上级结点
	 * @param 该级结点的上级结点的syscoding的长度
	 */
	private void getChildTreeNodeMap(List<MonitorTypeInfo> monitorTypeList,TreeNode ptNode,int ptlen,String syscoding){
		List<MonitorTypeInfo> nextcode = getNextLevelNodes(monitorTypeList,ptlen,syscoding);//取得该级结点的LIST
		for(int i=0,j=nextcode.size();i<j;i++){
			MonitorTypeInfo monitorTypeInfo = nextcode.get(i);
			String syscode = monitorTypeInfo.getMtSyscoding();
			TreeNode pdNode = new TreeNode();
			pdNode.setId(String.valueOf(monitorTypeInfo.getMtId()));
			pdNode.setName(monitorTypeInfo.getMtName());
			getChildTreeNodeMap(monitorTypeList,pdNode,syscode.length(),syscode);
			ptNode.addChildTreeNode(pdNode.getId(),pdNode);
		}
	}
	
	/**
	 * <p>
	 * 取下一level的结点集合
	 * </p>
	 * @param 全部的结点LIST
	 * @param 当前结点的len
	 * @param 当前结点的syscode
	 * @throws BLException
	 */
	private List<MonitorTypeInfo> getNextLevelNodes(List<MonitorTypeInfo> monitorTypeList,int levellen,String syscode) {
		List<MonitorTypeInfo> mtList = new ArrayList<MonitorTypeInfo>();
		for(int i=0,j=monitorTypeList.size();i<j;i++){
			String syscoding = monitorTypeList.get(i).getMtSyscoding();
			if(syscoding.length()==(levellen+3) && (syscoding.substring(0,syscoding.length()-3)).equals(syscode)){
				mtList.add(monitorTypeList.get(i));
			}
		}
		return mtList;
	}
	
	/**
	 * 监控类型阀值查询
	 */
	public IGMNT01DTO searchMonitorTypeDefAction(IGMNT01DTO dto)
			throws BLException {
		MonitorTypeDefSearchCondImpl cond=new MonitorTypeDefSearchCondImpl();
		cond.setMtId(String.valueOf(dto.getIgmnt0102Form().getMtId()));
		//监控类型id查询阀值集合
		List<MonitorTypeDefInfo> monitorTypeDefList = monitorTypeDefBL.searchMonitorTypeDef(cond);
		dto.setMonitorTypeDefInfoList(monitorTypeDefList);
		return dto;
	}

	/**
	 * 监控类型阀值更新
	 */
	public void updateMonitorTypeDefAction(IGMNT01DTO dto)
			throws BLException {
		IGMNT0102Form igmnt0102Form = dto.getIgmnt0102Form();
		String[] mtdValue = igmnt0102Form.getMtdValue();//阀值数组
		String[] mtdId = igmnt0102Form.getMtdId();//监控类型阀值id数组
		String[] compare = igmnt0102Form.getCompare();//比较符
		String[] deleteFlag = igmnt0102Form.getDeleteFlag();//状态
		String[] mtdDes = igmnt0102Form.getMtdDes();//告警描述
		int mtId = igmnt0102Form.getMtId();
		
		//更新监控类型阀值信息
		for (int i=0;i<mtdId.length;i++) {
			MonitorTypeDefInfo monitorTypeDefInfo = monitorTypeDefBL.searchMonitorTypeDefByPK(Integer.valueOf(mtdId[i]));
			MonitorTypeDefTB monitorTypeDef=copyMonitorTypeDefInfo(monitorTypeDefInfo);//拷贝监控类型阀值信息
			monitorTypeDef.setMtdValue(mtdValue[i]);
			if(mtId<9){
				monitorTypeDef.setDeleteFlag(deleteFlag[i]);
				monitorTypeDef.setCompare(compare[i]);
				monitorTypeDef.setMtdDes(mtdDes[i]);
			}
			monitorTypeDefBL.updateMonitorTypeDef(monitorTypeDef);
		}
	}

	/**
	 * 拷贝监控类型阀值信息
	 * @param monitorTypeDefInfo
	 * @return
	 */
	public MonitorTypeDefTB copyMonitorTypeDefInfo(MonitorTypeDefInfo monitorTypeDefInfo){
		MonitorTypeDefTB monitorTypeDef=new MonitorTypeDefTB();
		monitorTypeDef.setCompare(monitorTypeDefInfo.getCompare());
		monitorTypeDef.setDeleteFlag(monitorTypeDefInfo.getDeleteFlag());
		monitorTypeDef.setMtdCreateTime(monitorTypeDefInfo.getMtdCreateTime());
		monitorTypeDef.setMtdDes(monitorTypeDefInfo.getMtdDes());
		monitorTypeDef.setMtdId(monitorTypeDefInfo.getMtdId());
		monitorTypeDef.setMtdName(monitorTypeDefInfo.getMtdName());
		monitorTypeDef.setMtdValue(monitorTypeDefInfo.getMtdValue());
		monitorTypeDef.setMtId(monitorTypeDefInfo.getMtId());
		monitorTypeDef.setOrderNumber(monitorTypeDefInfo.getOrderNumber());
		return monitorTypeDef;
	}
	/**
	 * 监控类型查询
	 */
	public IGMNT01DTO searchMonitorTypeAction(IGMNT01DTO dto)
			throws BLException {
		List<MonitorTypeInfo> monitorTypeList = monitorTypeBL.searchMonitorType();//查询全部监控类型
		List<LabelValueBean> newMonitorTypeList=new ArrayList<LabelValueBean>();
		newMonitorTypeList.add(new LabelValueBean("",""));
		for (MonitorTypeInfo monitorTypeInfo : monitorTypeList) {
			String mtSyscoding = monitorTypeInfo.getMtSyscoding();
			if(mtSyscoding.length()>3&&!mtSyscoding.startsWith("003")){//层次码长度大于3是要监控的类型
				LabelValueBean monitorType=new LabelValueBean();
				monitorType.setLabel(monitorTypeInfo.getMtName());
				monitorType.setValue(String.valueOf(monitorTypeInfo.getMtId()));
				newMonitorTypeList.add(monitorType);
			}
		}
		dto.setMonitorTypeList(newMonitorTypeList);
		return dto;
	}

	/**
	 * 监控对象登记
	 */
	public IGMNT01DTO insertMonitorObject(IGMNT01DTO dto) throws BLException {
		IGMNT0103Form form = dto.getIgmnt0103Form();
		String moName = form.getSymm_id();//监控对象名称
		String ip = form.getIp();//ip地址
		String mtId = form.getMtId();//监控类型id
		String[] deleteFlag = form.getModDeleteFlag();//状态数组
		String[] modValue = form.getModValue();//阀值数组
		
		MonitorObjectSearchCondImpl cond=new MonitorObjectSearchCondImpl();
		cond.setMoName(moName);
		List<MonitorObjectInfo> monitorObjectList = monitorObjectBL.searchMonitorObject(cond);
		if(monitorObjectList!=null&&monitorObjectList.size()>0){
			throw new BLException("IGMNT0103.E001");
		}
		
		//根据监控类型id获取层次码
		MonitorTypeInfo monitorType = monitorTypeBL.searchMonitorTypeByPK(Integer.valueOf(mtId));
		String mtSyscoding = monitorType.getMtSyscoding();
		
		//监控对象登记
		MonitorObjectTB mo=new MonitorObjectTB();
		mo.setMoName(moName);
		mo.setIp(ip);
		mo.setMtSyscoding(mtSyscoding);
		mo.setDeleteFlag("0");
		mo.setMoCreateTime(IGStringUtils.getCurrentDateTime());
		MonitorObjectInfo monitorObject = monitorObjectBL.registMonitorObject(mo);
		
		// 监控对象信息
		dto.addMessage(new ActionMessage("IGCO10000.I004", resources
				.getMessage(dto.getLocale(), "message.IGMNT01BLImpl.001")));
		
		//根据监控类型id获取监控类型阀值集合
		MonitorTypeDefSearchCondImpl mtdCond=new MonitorTypeDefSearchCondImpl();
		mtdCond.setMtId(String.valueOf(mtId));
		List<MonitorTypeDefInfo> monitorTypeDefList = monitorTypeDefBL.searchMonitorTypeDef(mtdCond);
		//监控对象阀值信息登记
		for (int i = 0; i < monitorTypeDefList.size(); i++) {
			MonitorTypeDefInfo monitorTypeDefInfo = monitorTypeDefList.get(i);
			MonitorObjectDefTB mod=new MonitorObjectDefTB();
			mod.setDeleteFlag(deleteFlag[i]);
			mod.setModCreateTime(IGStringUtils.getCurrentDateTime());
			mod.setModDes(monitorTypeDefInfo.getMtdDes());
			mod.setModName(monitorTypeDefInfo.getMtdName());
			mod.setModValue(modValue[i]);
			mod.setMoId(monitorObject.getMoId());
			mod.setOrderNumber(monitorTypeDefInfo.getOrderNumber());
			mod.setCompare(monitorTypeDefInfo.getCompare());
			monitorObjectDefBL.registMonitorObjectDef(mod);
		}
		return dto;
	}

	/**
	 * 监控对象查询
	 */
	public IGMNT01DTO searchMonitorObjectAction(IGMNT01DTO dto)
			throws BLException {
		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		//form取得
		IGMNT0104Form igmnt0104Form = dto.getIgmnt0104Form();
		//监控类型Id取得
		String mtId = igmnt0104Form.getMtId_eq();
		//创建时间从取得
		String moCreateTime_from = igmnt0104Form.getMoCreateTime_from();
		//创建时间到取得
		String moCreateTime_to = igmnt0104Form.getMoCreateTime_to();
		//监控对象名称取得
		String moName = igmnt0104Form.getMoName_eq();
		
		String mtSyscoding="";
		if(StringUtils.isNotEmpty(mtId)){
			//监控类型取得
			MonitorTypeInfo monitorType = monitorTypeBL.searchMonitorTypeByPK(Integer.valueOf(mtId));
			//层次码取得
			mtSyscoding = monitorType.getMtSyscoding();
		}
		
		MonitorObjectSearchCondImpl cond=new MonitorObjectSearchCondImpl();
		cond.setMtSyscoding(mtSyscoding);
		cond.setMoName(moName);
		cond.setMoCreateTime_from(moCreateTime_from);
		cond.setMoCreateTime_to(moCreateTime_to);
		
		int totalCount = monitorObjectBL.getSearchCount(cond);
		if (totalCount == 0) {
			log.debug("========监控对象不存在========");
			// 监控对象不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));

			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========监控对象数据件数过多========");
			// 监控对象数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));

			return dto;
		}
		//获取监控对象结果集
		List<MonitorObjectInfo> monitorObjectList = monitorObjectBL.searchMonitorObject(cond,pDto.getFromCount(),pDto.getPageDispCount());
		dto.setMonitorObjectList(monitorObjectList);
		
		pDto.setTotalCount(totalCount);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		return dto;
	}

	/**
	 * 监控对象主键查询
	 */
	public IGMNT01DTO searchMonitorObjectByPKAction(IGMNT01DTO dto)
			throws BLException {
		IGMNT0103Form igmnt0103Form = dto.getIgmnt0103Form();
		String moId = igmnt0103Form.getMoId();
		MonitorObjectInfo monitorObject = monitorObjectBL.searchMonitorObjectByPK(Integer.valueOf(moId));
		dto.setMonitorObject(monitorObject);
		return dto;
	}

	/**
	 * 监控对象阀值信息查询
	 */
	public IGMNT01DTO searchMonitorObjectDefAction(IGMNT01DTO dto)
			throws BLException {
		IGMNT0103Form igmnt0103Form = dto.getIgmnt0103Form();
		//监控对象id
		String moId = igmnt0103Form.getMoId();
		MonitorObjectDefSearchCondImpl cond=new MonitorObjectDefSearchCondImpl();
		cond.setMoId(moId);
		//取得监控对象阀值集合
		List<MonitorObjectDefInfo> monitorObjectDefList = monitorObjectDefBL.searchMonitorObjectDef(cond);
		dto.setMonitorObjectDefList(monitorObjectDefList);
		return dto;
	}

	/**
	 * 监控对象修改
	 */
	public void updateMonitorObjectAction(IGMNT01DTO dto) throws BLException {
		IGMNT0103Form form = dto.getIgmnt0103Form();
		String moId = form.getMoId();
		MonitorObjectInfo monitorObject = monitorObjectBL.searchMonitorObjectByPK(Integer.valueOf(moId));
		
		//更新collect_Symmetrix_Info表
		Collect_Symmetrix_InfoTB collect_Symmetrix_InfoTB = monitorObject.getCollect_Symmetrix_InfoTB();
		if(collect_Symmetrix_InfoTB!=null){
			collect_Symmetrix_InfoTB.setSymm_model(form.getSymm_model());
			collect_Symmetrix_InfoTB.setSymm_version(form.getSymm_version());
			collect_Symmetrix_InfoTB.setSymm_cachesize(form.getSymm_cachesize());
			collect_Symmetrix_InfoBL.updateCollect_Symmetrix_Info(collect_Symmetrix_InfoTB);
		}
		
		//监控对象更新
		MonitorObjectTB mo=new MonitorObjectTB();
		mo.setMoId(monitorObject.getMoId());
		mo.setDeleteFlag(monitorObject.getDeleteFlag());
		mo.setIp(form.getIp());
		mo.setMoCreateTime(monitorObject.getMoCreateTime());
		mo.setMoName(form.getSymm_id());
		String mtId = form.getMtId();//获取监控类型id
		
		//根据监控类型id取得监控类型层次码
		MonitorTypeInfo monitorType = monitorTypeBL.searchMonitorTypeByPK(Integer.valueOf(mtId));
		String mtSyscoding = monitorType.getMtSyscoding();
		mo.setMtSyscoding(mtSyscoding);
		monitorObjectBL.updateMonitorObject(mo);
		
		//监控对象旧阀值删除
		MonitorObjectDefSearchCondImpl modCond=new MonitorObjectDefSearchCondImpl();
		modCond.setMoId(moId);
		List<MonitorObjectDefInfo> monitorObjectDefList = monitorObjectDefBL.searchMonitorObjectDef(modCond);
		for (MonitorObjectDefInfo monitorObjectDefInfo : monitorObjectDefList) {
			monitorObjectDefBL.deleteMonitorObjectDef(monitorObjectDefInfo);
		}
		
		//监控对象新阀值插入
		MonitorTypeDefSearchCondImpl mtdCond=new MonitorTypeDefSearchCondImpl();
		mtdCond.setMtId(String.valueOf(mtId));
		List<MonitorTypeDefInfo> monitorTypeDefList = monitorTypeDefBL.searchMonitorTypeDef(mtdCond);
		for (int i = 0; i < monitorTypeDefList.size(); i++) {
			MonitorTypeDefInfo monitorTypeDefInfo = monitorTypeDefList.get(i);
			MonitorObjectDefTB mod=new MonitorObjectDefTB();
			mod.setDeleteFlag(form.getModDeleteFlag()[i]);
			mod.setModCreateTime(IGStringUtils.getCurrentDateTime());
			mod.setModDes(monitorTypeDefInfo.getMtdDes());
			mod.setModName(monitorTypeDefInfo.getMtdName());
			mod.setModValue(form.getModValue()[i]);
			mod.setMoId(monitorObject.getMoId());
			mod.setOrderNumber(monitorTypeDefInfo.getOrderNumber());
			mod.setCompare(form.getCompare()[i]);
			monitorObjectDefBL.registMonitorObjectDef(mod);
		}
	}

	/**
	 * 监控对象状态修改
	 */
	public void updateMonitorObjectStatusAction(IGMNT01DTO dto)
			throws BLException {
		IGMNT0104Form form = dto.getIgmnt0104Form();
		String moId = form.getMoId();//取得监控对象id
		String deleteFlag = form.getDeleteFlag();//取得监控对象要修改的状态
		MonitorObjectInfo monitorObject = monitorObjectBL.searchMonitorObjectByPK(Integer.valueOf(moId));
		MonitorObjectTB mo = copyMonitorObject(monitorObject);
		mo.setDeleteFlag(deleteFlag);
		monitorObjectBL.updateMonitorObject(mo);
		
		//监控对象阈值信息状态修改
		MonitorObjectDefSearchCondImpl cond=new MonitorObjectDefSearchCondImpl();
		cond.setMoId(moId);
		List<MonitorObjectDefInfo> monitorObjectDefList = monitorObjectDefBL.searchMonitorObjectDef(cond);
		for (MonitorObjectDefInfo monitorObjectDefInfo : monitorObjectDefList) {
			MonitorObjectDefTB mod=copyMonitorObjectDef(monitorObjectDefInfo);
			mod.setDeleteFlag(deleteFlag);
			monitorObjectDefBL.updateMonitorObjectDef(mod);
		}
	}
	
	/**
	 * 拷贝MonitorObjectTB
	 * @param deleteFlag
	 * @param monitorObject
	 * @return
	 */
	private MonitorObjectTB copyMonitorObject(MonitorObjectInfo monitorObject) {
		MonitorObjectTB mo=new MonitorObjectTB();
		mo.setDeleteFlag(monitorObject.getDeleteFlag());
		mo.setIp(monitorObject.getIp());
		mo.setMoCreateTime(monitorObject.getMoCreateTime());
		mo.setMoId(monitorObject.getMoId());
		mo.setMoName(monitorObject.getMoName());
		mo.setMtSyscoding(monitorObject.getMtSyscoding());
		return mo;
	}

	/**
	 * 拷贝MonitorObjectDefTB
	 * @param monitorObjectDefInfo
	 */
	private MonitorObjectDefTB copyMonitorObjectDef(MonitorObjectDefInfo monitorObjectDefInfo) {
		MonitorObjectDefTB mod=new MonitorObjectDefTB();
		mod.setCompare(monitorObjectDefInfo.getCompare());
		mod.setDeleteFlag(monitorObjectDefInfo.getDeleteFlag());
		mod.setModCreateTime(monitorObjectDefInfo.getModCreateTime());
		mod.setModDes(monitorObjectDefInfo.getModDes());
		mod.setModId(monitorObjectDefInfo.getModId());
		mod.setModName(monitorObjectDefInfo.getModName());
		mod.setModValue(monitorObjectDefInfo.getModValue());
		mod.setMoId(monitorObjectDefInfo.getMoId());
		mod.setOrderNumber(monitorObjectDefInfo.getOrderNumber());
		return mod;
	}

	/**
	 * 监控对象名称查询
	 */
	public IGMNT01DTO searchMoNameAction(IGMNT01DTO dto) throws BLException {
		List<Collect_Symmetrix_Info> collect_Symmetrix_InfoList = collect_Symmetrix_InfoBL.findAllCollect_Symmetrix_Info();
		List<LabelValueBean> moNameList=new ArrayList<LabelValueBean>();
		for (Collect_Symmetrix_Info collect_Symmetrix_Info : collect_Symmetrix_InfoList) {
			String symm_id = collect_Symmetrix_Info.getSymm_id();
			LabelValueBean moName=new LabelValueBean(symm_id,symm_id);
			moNameList.add(moName);
		}
		dto.setMoNameList(moNameList);
		return dto;
	}

	/**
	 * <p> 查询资产模型名称 </p>
	 * 
	 * @param dto
	 *            IGMNT01DTO
	 * @return IGMNT01DTO
	 * @throws BLException
	 */

	public IGMNT01DTO searchEntityNameAction(IGMNT01DTO dto) throws BLException
	{
		SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
		cond.setEsyscoding(dto.getEsyscoding());
		List<SOC0117Info> list = soc0117BL.searchEntity(cond, 0, 0);
		if (list.size() == 1)
		{
			dto.setEname(list.get(0).getEname());
		}
		else
		{
			throw new BLException("IGASM0104.E001", dto.getEsyscoding());
		}
		return dto;
	}
	
	/**
	 * 资产项信息查询
	 * 
	 * @param dto
	 *            IGMNT01DTO
	 * @return IGMNT01DTO
	 */
	public IGMNT01DTO searchEntityItemAction(IGMNT01DTO dto) throws BLException
	{

		log.debug("========资产项HELP查询处理开始========");

		// 查询件数取得
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(dto
				.getEntityItemVWSearchCond());

		if (totalCount == 0)
		{
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount())
		{
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		PagingDTO pDto = dto.getPagingDto();

		List<SOC0124Info> entityItemVWInfoList = this.soc0118BL
				.searchEntityItemVW(dto.getEntityItemVWSearchCond(), pDto
						.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setEntityItemVWInfoList(entityItemVWInfoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========资产项HELP查询处理终了========");
		return dto;
	}

	/**
	 * 主键检索监控类型
	 */
	public MonitorTypeInfo searchMonitorTypeByPK(IGMNT01DTO dto)
			throws BLException {
		MonitorTypeInfo monitorType = monitorTypeBL.searchMonitorTypeByPK(Integer.valueOf(dto.getMtId()));
		return monitorType;
	}
	
	/**
	 * 存储登记处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO insertSymmInfoAction(IGMNT01DTO dto) throws BLException {
		log.debug("========存储信息登记处理开始========");
		// 输入Form取得
		IGMNT0103Form form = dto.getIgmnt0103Form();
		
		//添加存储基本信息
		this.collect_Symmetrix_InfoBL.saveCollect_Symmetrix_Info(form);
		
		// 存储基本信息
		//dto.addMessage(new ActionMessage("IGCO10000.I004", resources.getMessage(dto.getLocale(), "message.IGASM26BLImpl.001")));
		log.debug("========存储信息登记处理终了========");
		return dto;
	}

	/**
	 * 存储CodeDetail表信息添加处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO insertCodeDetailInfoAction(IGMNT01DTO dto)
			throws BLException {
		log.debug("========存储CodeDetail表信息添加处理开始========");
		IGMNT0103Form form=dto.getIgmnt0103Form();
		//获取最大CID
		String maxCid=this.codeDetailBL.getMaxcid(EntityItemKeyWords.SYMM_CCID);
		Integer cid=0001;
		CodeDetail codeDetailInfo=this.codeDetailBL.searchCodeDetailByPK(new CodeDetailTBPK(EntityItemKeyWords.SYMM_RELATION_CCID,form.getSymm_type()));
		if(codeDetailInfo!=null){
			CodeDetail codeDetail=this.codeDetailBL.searchCodeDetailByPK(new CodeDetailTBPK(EntityItemKeyWords.SYMM_SUPERIOR_CCID,codeDetailInfo.getCvalue()));
			if(codeDetail!=null){
				CodeDetailTB codeDetailTB=new CodeDetailTB();
				codeDetailTB.setCcid(EntityItemKeyWords.SYMM_CCID);
				if(StringUtils.isNotEmpty(maxCid)){
					cid=Integer.parseInt(maxCid)+1;
				}
				String cidstr=intergerToString(cid);
				codeDetailTB.setCid(cidstr);
				codeDetailTB.setCvalue(form.getSymm_id());
				codeDetailTB.setPccid(codeDetail.getCcid());
				codeDetailTB.setPcid(codeDetail.getCid());
				codeDetailTB.setUpdtime(IGStringUtils.getCurrentDateTime());
				String syscoding=codeDetail.getSyscoding()+cidstr.substring(cidstr.length()-3, cidstr.length());
				codeDetailTB.setSyscoding(syscoding);
				codeDetailTB.setPsyscoding(codeDetail.getSyscoding());
				codeDetailTB.setCdstatus("1");
				//添加报表分析树
				this.codeDetailBL.registCodeDetail(codeDetailTB);
				dto.setSyscoding(syscoding);
			}
		}
		log.debug("========存储CodeDetail表信息添加处理终了========");
		return dto;
	}
	
	/**
	 * 将Integer类型的cid转换成String类型
	 * @param cid
	 * @return
	 */
	public static String intergerToString(Integer cid){
		String cidstr=Integer.toString(cid);
		if(cidstr.length()<4){
			Integer length=4-cidstr.length();
			for(int i=0;i<length;i++){
				cidstr="0"+cidstr;
			}
		}
		return cidstr;
	}

	/**
	 * 获取该存储类型的报表
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO searchCodeDetailListActioin(IGMNT01DTO dto)
			throws BLException {
		log.debug("========获取该存储类型的报表处理开始========");
		IGMNT0103Form form=dto.getIgmnt0103Form();
		CodeDetailSearchCondImpl codeDetailSearchCond=new CodeDetailSearchCondImpl();
		//当存储类型为DMX时
		if(EntityItemKeyWords.SYMM_DMX.equals(form.getSymm_type())){
			codeDetailSearchCond.setCcid(EntityItemKeyWords.SYMM_DMX_CCID);
		}
		//当存储类型为IBM时
		if(EntityItemKeyWords.SYMM_IBM.equals(form.getSymm_type())){
			codeDetailSearchCond.setCcid(EntityItemKeyWords.SYMM_IBM_CCID);
		}
		//当存储类型为CX时
		if(EntityItemKeyWords.SYMM_CX.equals(form.getSymm_type())){
			codeDetailSearchCond.setCcid(EntityItemKeyWords.SYMM_CX_CCID);
		}
		//当交换机类型为Brocade时
		if(EntityItemKeyWords.SYMM_BROCADE.equals(form.getSymm_type())){
			codeDetailSearchCond.setCcid(EntityItemKeyWords.SYMM_BROCADE_CCID);
		}
		//当交换机类型为Mcdata时
		if(EntityItemKeyWords.SYMM_MCDATA.equals(form.getSymm_type())){
			codeDetailSearchCond.setCcid(EntityItemKeyWords.SYMM_MCDATA_CCID);
		}
		//当存储类型为HDS时
		if(EntityItemKeyWords.SYMM_HDS.equals(form.getSymm_type())){
			codeDetailSearchCond.setCcid(EntityItemKeyWords.SYMM_HDS_CCID);
		}
		List<CodeDetail> codeDetailList=this.codeDetailBL.searchCodeDetail(codeDetailSearchCond, 0);
		if(codeDetailList!=null&&codeDetailList.size()>0){
			dto.setCodeDetailList(codeDetailList);
		}
		log.debug("========获取该存储类型的报表处理终了========");
		return dto;
	}

	/**
	 * 自动报表添加处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO registSOC0203Action(IGMNT01DTO dto)
			throws BLException {
		log.debug("========自动报表添加处理开始========");
		IGMNT0103Form form=dto.getIgmnt0103Form();
		CodeDetail codeDetailInfo=dto.getCodeDetailInfo();
		SOC0203TB soc0203TB = new SOC0203TB();
		soc0203TB.setDataid(form.getSymm_id());
		soc0203TB.setR_path(codeDetailInfo.getSyscoding());
		soc0203TB.setR_title(form.getSymm_id()+ codeDetailInfo.getCvalue());
		soc0203TB.setPara(EntityItemKeyWords.REPORTCONFIGURATION_URl
						+ form.getSymm_id()
						+ EntityItemKeyWords.REPORTCONFIGURATION_TYPE);
		this.soc0203BL.saveSOC0203(soc0203TB);
		log.debug("========自动报表添加处理终了========");
		return dto;
	}

	/**
	 * 普通报表添加处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO registReportFileDefinitionAction(IGMNT01DTO dto)
			throws BLException {
		log.debug("========普通报表添加处理开始========");
		IGMNT0103Form form=dto.getIgmnt0103Form();
		CodeDetail codeDetailInfo=dto.getCodeDetailInfo();
		//当是普通报表时
		ReportFileDefinitionTB reportFileDefinitionTB=new ReportFileDefinitionTB();
		reportFileDefinitionTB.setRfdtitle(codeDetailInfo.getCvalue());
		reportFileDefinitionTB.setRfdtype(dto.getSyscoding());
		reportFileDefinitionTB.setRfdfilename(codeDetailInfo.getSyscoding());
		reportFileDefinitionTB.setRfduserid(EntityItemKeyWords.SYMM_USERID);
		reportFileDefinitionTB.setRfdusername(EntityItemKeyWords.SYMM_USERNAME);
		reportFileDefinitionTB.setRfdinstime(IGStringUtils.getCurrentDateTime());
		reportFileDefinitionTB.setRfdversion(1);
		reportFileDefinitionTB.setRfdnewversion(1);
		reportFileDefinitionTB.setRfdparameters(EntityItemKeyWords.REDPARAMETERS+form.getSymm_id());
		reportFileDefinitionTB.setRfddesc(codeDetailInfo.getCdinfo());//对象类型
		//执行报表信息添加
		ReportFileDefinition reportFileDefinition=this.reportFileDefinitionBL.registReportFileDefinition(reportFileDefinitionTB);
		ReportFileVersionTB reportFileVersionTB=new ReportFileVersionTB();
		reportFileVersionTB.setRfvid(reportFileDefinition.getRfdid());
		reportFileVersionTB.setRfdid(reportFileDefinition.getRfdid());
		reportFileVersionTB.setRfvversion(1);
		reportFileVersionTB.setRfvinstime(IGStringUtils.getCurrentDateTime());
		//执行报表版本信息添加
		this.reportFileVersionBL.registReportFileVersion(reportFileVersionTB);
		log.debug("========普通报表添加处理终了========");
		return dto;
	}

	/**
	 * 存储其它信息删除处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO deleteSymmInfoAction(IGMNT01DTO dto) throws BLException {
		log.debug("========存储信息删除处理开始========");
		//Form取得
		IGMNT0104Form form=dto.getIgmnt0104Form();
		String moId = form.getMoId();
		MonitorObjectInfo monitorObject = monitorObjectBL.searchMonitorObjectByPK(Integer.valueOf(moId));
		Collect_Symmetrix_InfoTB collect_Symmetrix_InfoTB = monitorObject.getCollect_Symmetrix_InfoTB();
		if(collect_Symmetrix_InfoTB!=null){
			this.collect_Symmetrix_InfoBL.deleteCollect_Symmetrix_Info(collect_Symmetrix_InfoTB);
		}
		log.debug("========存储信息删除处理终了========");
		return dto;
	}

	/**
	 * 监控对象相关删除处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO deleteSymmOtherInfoAction(IGMNT01DTO dto)
			throws BLException {
		log.debug("========存储其它信息删除处理开始========");
		//Form取得
		IGMNT0104Form form=dto.getIgmnt0104Form();
		String moId = form.getMoId();
		MonitorObjectInfo monitorObject = monitorObjectBL.searchMonitorObjectByPK(Integer.valueOf(moId));
		Collect_Symmetrix_InfoTB collect_Symmetrix_InfoTB = monitorObject.getCollect_Symmetrix_InfoTB();
		if(collect_Symmetrix_InfoTB!=null){
			CodeDetailSearchCondImpl codeDetailSearchCond=new CodeDetailSearchCondImpl();
			codeDetailSearchCond.setCvalue(collect_Symmetrix_InfoTB.getSymm_id());
			List<CodeDetail>  codeDetailList=this.codeDetailBL.searchCodeDetail(codeDetailSearchCond, 0);
			if(codeDetailList!=null&&codeDetailList.size()>0){
				ReportFileDefinitionSearchCondImpl reportFileDefinitionSearchCond=new ReportFileDefinitionSearchCondImpl();
				reportFileDefinitionSearchCond.setRfdtype(codeDetailList.get(0).getSyscoding());
				List<ReportFileDefinition> reportFileDefinitionList=this.reportFileDefinitionBL.searchReportFileDefinition(reportFileDefinitionSearchCond, 0, 0);
				if(reportFileDefinitionList!=null&&reportFileDefinitionList.size()>0){
					for(int i=0;i<reportFileDefinitionList.size();i++){
						//删除报表的版本
						this.reportFileVersionBL.deleteReportFileVersion(reportFileDefinitionList.get(i).getRfdid());
						//删除报表信息
						this.reportFileDefinitionBL.deleteReportFileDefinition(reportFileDefinitionList.get(i).getRfdid());
					}
				}
				//删除CodeDetail中的存储信息
				this.codeDetailBL.deleteCodeDetail(codeDetailList.get(0));
			}
			//删除自动报表
			SOC0203SearchCondImpl soc0203SearchCond=new SOC0203SearchCondImpl();
			soc0203SearchCond.setDataid(collect_Symmetrix_InfoTB.getSymm_id());
			List<SOC0203Info> soc0203List=this.soc0203BL.findSOC0203ByCond(soc0203SearchCond, 0, 0);
			if(soc0203List!=null&&soc0203List.size()>0){
				for(SOC0203Info soc0203:soc0203List){
					this.soc0203BL.deleteSOC0203(soc0203);
				}
			}
		}
		dto.addMessage(new ActionMessage("IGASM2601.I001"));
		log.debug("========存储其它信息删除处理终了========");
		return dto;
	}

	/**
	 * 删除监控对象
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO deleteMonitorObject(IGMNT01DTO dto) throws BLException {
		IGMNT0104Form form = dto.getIgmnt0104Form();
		String moId = form.getMoId();
		//删除监控对象
		monitorObjectBL.deleteMonitorObjectByPK(Integer.valueOf(moId));
		
		//删除监控对象阈值信息
		MonitorObjectDefSearchCondImpl cond=new MonitorObjectDefSearchCondImpl();
		cond.setMoId(moId);
		List<MonitorObjectDefInfo> monitorObjectDefList = monitorObjectDefBL.searchMonitorObjectDef(cond);
		for (MonitorObjectDefInfo monitorObjectDefInfo : monitorObjectDefList) {
			monitorObjectDefBL.deleteMonitorObjectDef(monitorObjectDefInfo);
		}
		return dto;
	}

	/**
	 * 资产类型名称检索
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO searchEsyscodingAction(IGMNT01DTO dto) throws BLException {
		List<MonitorTypeInfo> monitorTypeList = monitorTypeBL.searchMonitorType();//查询全部监控类型
		List<LabelValueBean> esyscodingList=new ArrayList<LabelValueBean>();
		esyscodingList.add(new LabelValueBean("",""));
		for (MonitorTypeInfo monitorTypeInfo : monitorTypeList) {
			if(monitorTypeInfo.getMtSyscoding().length()>3){//层次码长度大于3是要监控的类型
				LabelValueBean esyscoding=new LabelValueBean();
				esyscoding.setLabel(monitorTypeInfo.getMtName());
				String mtSyscoding = monitorTypeInfo.getMtSyscoding();
				String value="";
				if(mtSyscoding.equals("001001")){//DMX
					value="999001009001";
				}else if(mtSyscoding.equals("001002")){//IBM
					value="999001009002";
				}else if(mtSyscoding.equals("001003")){//CX
					value="999001009003";
				}else if(mtSyscoding.equals("002001")){//Brocade
					value="999001006001";
				}else if(mtSyscoding.equals("002002")){//Cisco
					value="999001006002";
				}else if(mtSyscoding.equals("002003")){//Mcdata
					value="999001006003";
				}
				esyscoding.setValue(value);
				esyscodingList.add(esyscoding);
			}
		}
		dto.setEsyscodingList(esyscodingList);
		return dto;
	}

	/**
	 * 检索存储基本信息实体表
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO searchCollect_Symmetrix_Info(IGMNT01DTO dto) throws BLException {
		IGMNT0103Form form = dto.getIgmnt0103Form();
		Collect_Symmetrix_InfoSearchCondImpl collect_Symmetrix_InfoSearchCond=new Collect_Symmetrix_InfoSearchCondImpl();
		collect_Symmetrix_InfoSearchCond.setSymm_id(form.getSymm_id());
		List<Collect_Symmetrix_Info> collect_Symmetrix_InfoList = collect_Symmetrix_InfoBL.findCollect_Symmetrix_InfoByCond(collect_Symmetrix_InfoSearchCond, 0, 0);
		dto.setCollect_Symmetrix_InfoList(collect_Symmetrix_InfoList);
		return dto;
	}

	/**
	 * DMX实时设定
	 *
	 * @param dmxRealTimeBL DMX实时
	 */
	public void setDmxRealTimeBL(SOC0301BL dmxRealTimeBL) {
		this.soc0301BL = dmxRealTimeBL;
	}



	/** 
	 * 查询debug监控初始化信息
	 */
	public IGMNT01DTO searchDebugTaskInitAction(IGMNT01DTO dto) throws BLException {
		
		Properties properties = this.getProperties();
		//监控任务查询条件
		SOC0304SearchCondImpl mtcond=new SOC0304SearchCondImpl();
		//设置只查活动状态
		mtcond.setMtStatus(IGMntConstantDefine.TASKSTATUSACTIVITY);
		//查询所有监控任务
		List<SOC0304Info> mtInfoList=soc0304BL.searchSoc0304(mtcond);
		//查询指定类型的存储序列号
		List<MonitorObjectInfo> moTypeList=getMoTypeList();
		
		//放入dto
		dto.setMonitorObjectList(moTypeList);
		dto.setSoc0304List(mtInfoList);
		dto.setCheckedCount(properties.getProperty("CHECKED_COUNT"));
		dto.setInterValDefault(getIntervalDefault());
		//放入选择条件
		return dto;
	}
	/**
	 * 获取符合类型的对象
	 * @return
	 */
	private List<MonitorObjectInfo> getMoTypeList()throws BLException{
		List<MonitorObjectInfo> monitorObjectList = monitorObjectBL.searchMonitorObject();
		List<MonitorObjectInfo> moTypeList=new ArrayList<MonitorObjectInfo>();
		if(monitorObjectList!=null){
			for (int i = 0; i < monitorObjectList.size(); i++) {
				MonitorObjectInfo moInfo=monitorObjectList.get(i);
				//获取指定类型
				String motypeStr=IGMntConstantDefine.MONITOR_OBJTYPE;
				String[] moTypeArr=motypeStr.split(",");
				boolean isTrue=false;
				String typeName=moInfo.getMonitorTypeTB().getMtName();
				for (int j = 0; j < moTypeArr.length; j++) {
					isTrue=typeName.equals(moTypeArr[j]);
				}
				if(isTrue){
					moTypeList.add(moInfo);
				}
			}
		}
		return moTypeList;
	}
	/**
	 * 开始执行监控任务
	 */
	public IGMNT01DTO insertDebugTaskAction(IGMNT01DTO dto) throws BLException {
		//获取Form
		IGMNT0107Form form=dto.getIgmnt0107Form();
		Properties properties = this.getProperties();
		//设置默认值
		dto.setCheckedCount(properties.getProperty("CHECKED_COUNT"));
		dto.setInterValDefault(getIntervalDefault());
		dto.setMtSsn(form.getMtSsn());
		dto.setMonitorObjectList(getMoTypeList());
		//监控任务查询条件
		SOC0304SearchCondImpl mtcond=new SOC0304SearchCondImpl();
		//设置只查活动状态
		mtcond.setMtStatus(IGMntConstantDefine.TASKSTATUSACTIVITY);
		//设置序列号
		mtcond.setMtSsn(form.getMtSsn());
		//查询所有监控任务
		List<SOC0304Info> mtInfoList=soc0304BL.searchSoc0304(mtcond);
		//判断不能超过6个对象的条件
		Integer limitCount=Integer.parseInt(properties.getProperty("MONITOR_TASK_COUNT"));
		boolean isTrue=(mtInfoList!=null)&&((mtInfoList.size()+1)<=limitCount);
		if(!isTrue){
			dto.addMessage(new ActionMessage("IGMNT0107.E001",limitCount));
			dto.setSoc0304List(mtInfoList);
			dto.setErrFlag(IGMntConstantDefine.ERR_FLAG);
			return dto;
		}
		//验证小于1000个监控对象
		//获取时间间隔
		Integer timeVal=Integer.parseInt(properties.getProperty("MONITOR_TASK_INTERVAL"));
		//最大允许监控对象
		Integer objectCount=Integer.parseInt(properties.getProperty("MONITOR_OBJECT_COUNT"));
		//对象统计数
		Integer objectTotal=0;
		//原先记录数
		for (int i = 0; i < mtInfoList.size(); i++) {
			SOC0304Info mtInfo=mtInfoList.get(i);
			if(mtInfo!=null){
				if(mtInfo.getMtObjNames()!=null&&!"".equals(mtInfo.getMtObjNames())){
					String[] objArr=mtInfo.getMtObjNames().split(",");
					if(objArr!=null&&objArr.length>0){
						//获取单个任务的监控对象数量
						objectTotal+=objArr.length*(timeVal/mtInfo.getMtInterval());
					}
				}
			}
		}
		//获取组件名字、KPI、时间间隔
		//组件类别查询条件
		CodeDetailSearchCondImpl cnameCond=new CodeDetailSearchCondImpl();
		cnameCond.setCid(form.getMtCname());
		cnameCond.setCcid(IGMntConstantDefine.COMPONENT_TYPE_CODE);
		//组件类别查询
		List<CodeDetail> cnameList=(List<CodeDetail>) codeDetailBL.searchCodeDetail(cnameCond, 1);
		//组件类别标识
		String cnameFlag=cnameList.get(0).getSyscoding();
		String kpiCcid=IGMntConstantDefine.getValue(cnameFlag.toUpperCase()+"_KPI_CODE");
		String valCcid=IGMntConstantDefine.getValue(cnameFlag.toUpperCase()+"_VAL_CODE");
		//KPI查询条件
		CodeDetailSearchCondImpl kpiCond=new CodeDetailSearchCondImpl();
		kpiCond.setCid(form.getMtKpi());
		kpiCond.setCcid(kpiCcid);
		List<CodeDetail> kpiList=(List<CodeDetail>) codeDetailBL.searchCodeDetail(kpiCond, 1);
		//时间间隔条件
		CodeDetailSearchCondImpl valCond=new CodeDetailSearchCondImpl();
		valCond.setCcid(valCcid);
		valCond.setCid(form.getMtInterval());
		List<CodeDetail> valList=(List<CodeDetail>) codeDetailBL.searchCodeDetail(valCond, 1);
		//当前插入对象的监控数量
		String[] selectIds=form.getSelectedid();
		//判断不为null切大于0
		if(selectIds!=null&&selectIds.length>0){
			if(valList!=null&&valList.size()>0){
				//计算数量
				objectTotal+=selectIds.length*(timeVal/Integer.parseInt(valList.get(0).getSyscoding()));
				if(objectTotal>objectCount){
					dto.addMessage(new ActionMessage("IGMNT0107.E002",objectCount));
					dto.setSoc0304List(mtInfoList);
					dto.setErrFlag(IGMntConstantDefine.ERR_FLAG);
					return dto;
				}
			}
		}
		//判断同磁盘阵列同类别同KPI是否有相同的监控对象
		boolean isEqual=isEqual(cnameFlag, kpiList.get(0).getSyscoding(), mtInfoList, selectIds);
		if(isEqual){
			dto.addMessage(new ActionMessage("IGMNT0107.E003"));
			dto.setSoc0304List(mtInfoList);
			dto.setErrFlag(IGMntConstantDefine.ERR_FLAG);
			return dto;
		}
		//执行插入
		User curuser=dto.getUser();
		SOC0304TB mtTb=new SOC0304TB();
			//组件名字
			mtTb.setMtCname(cnameFlag);
			//KPI名字
			if(kpiList!=null&&kpiList.size()>0){
				mtTb.setMtKpi(kpiList.get(0).getSyscoding());
			}//时间间隔与次数
			if(valList!=null&&valList.size()>0){
				mtTb.setMtInterval(Integer.parseInt(valList.get(0).getSyscoding()));
				mtTb.setMtNum(timeVal/Integer.parseInt(valList.get(0).getSyscoding()));
			}
			//序列号
			mtTb.setMtSsn(form.getMtSsn());
			Calendar cal=Calendar.getInstance();
			//开始时间
			mtTb.setMtStartTime(sdf.format(cal.getTime()));
			cal.add(Calendar.SECOND, timeVal);
			//预结束时间
			mtTb.setMtPStopTime(sdf.format(cal.getTime()));
			//状态
			mtTb.setMtStatus(IGMntConstantDefine.TASKSTATUSACTIVITY);
			mtTb.setMtUserId(curuser.getUserid());
			mtTb.setMtOrgId(curuser.getOrgid());
			StringBuilder sb=new StringBuilder();
			if(selectIds!=null){
				for (int i = 0; i < selectIds.length; i++) {
					if(i==selectIds.length-1){
						sb.append(selectIds[i]);
					}else{
						sb.append(selectIds[i]).append(",");
					}
				}
			}
			mtTb.setMtObjNames(sb.toString());
			SOC0304Info mtinfo=soc0304BL.registSoc0304(mtTb);
			dto.addMessage(new ActionMessage("IGCO10000.I004",""));
			Integer mtId=mtinfo.getMtId();
			dto.setTmpMtId(mtId+"");
			
			//生成日志并调用bat
			createBat(mtTb.getMtSsn(),mtId+"",mtTb.getMtCname(),mtTb.getMtKpi(),mtTb.getMtInterval(),mtTb.getMtNum());
			
			//生成调用解析bat
			createParseBat(mtId+"");
			//返回界面
			
			return dto;
	}

	 /**
	 *DMXREALTIME导入应用资源文件
	 */
	private Properties getProperties() throws BLException {
		//CI导入应用资源文件
		Properties properties = null;
		//输入流
		FileInputStream inputFile = null;
		//加载属性文件
		try {
			properties = new Properties();
			inputFile = new FileInputStream(ResourceUtility.getString("DMX_REALTIME_FILE_PATH"));
			properties.load(inputFile);
		} catch (FileNotFoundException e) {
			log.error("DMXREALTIME导入应用资源文件读取错误", e);
			throw new BLException("IGASM2001.E001");
		} catch (IOException e) {
			log.error("DMXREALTIME导入应用资源文件读取错误", e);
			throw new BLException("IGASM2001.E001");
		} finally {
			if(inputFile != null) {
				try {
					inputFile.close();
				} catch (IOException e) {
					log.error("DMXREALTIME导入应用资源文件读取错误", e);
					throw new BLException("IGASM2001.E001");
				}
			}
		}
		return properties;
	}
	/**
	 * 生成一个生成日志bat,并调用
	*/
	public void createBat(String mtSsn,String mtId,String mtCname,String mtKpi,Integer mtInterval,Integer mtNum){
		try{
			Properties properties = this.getProperties();
			//bat文件路径
			String batFilePath=properties.getProperty("CREAT_BAT_FILEPATH");
			String batFileName=mtSsn+"_"+mtId+"_"+mtCname+"_"+mtKpi+".bat";
			String vbsFileName=mtSsn+"_"+mtId+"_"+mtCname+"_"+mtKpi+".vbs";
			String jarFilePath=properties.getProperty("CREAT_JAR_FILEPATH");
			String cSwitch=properties.getProperty("SWITCH_CONTROL");
			String placeName=jarFilePath.substring(0,1);
			String jarFileName=properties.getProperty("JAR_FILENAME");
			String jdkPath=properties.getProperty("JAVA_HOME");
			String SYMSTAT_PATH=properties.getProperty("SYMSTAT_PATH");
			String DMXREALTIME_FILEPATH=properties.getProperty("DMXREALTIME_FILEPATH");
			SimpleDateFormat df=new SimpleDateFormat("yyyyMMddHHmmss");
			//bat文件名字
			File file=new File(batFilePath+batFileName);
			File vbsFile=new File(batFilePath+vbsFileName);
			BufferedWriter bw=null;
			FileWriter fw =null;
			if(file.exists()){
				file.delete();
			}
			if(vbsFile.exists()){
				vbsFile.delete();
			}
			fw= new FileWriter(file,true);
			bw=new BufferedWriter(fw);
			if("1".equals(cSwitch)){
				bw.write("@echo off\r\n");
				bw.write("set PERFPATH="+jarFilePath+"\r\n");
				bw.write("set JAVA_HOME="+jdkPath+"\r\n");
				bw.write("set EXE_JAVA=\"%JAVA_HOME%\\bin\\java\"\r\n");
				bw.write(placeName+":\r\n");
				bw.write("cd %PERFPATH%\r\n");
				bw.write("%EXE_JAVA% -Xmx1024m -jar "+jarFileName+" "+mtId+" "+mtSsn+" "+mtInterval+" "+mtNum+" "+mtCname+" "+mtKpi+"\r\n");
				bw.write("exit\r\n");
			}else{
				Date curDate=new Date();
				String curDateStr=df.format(curDate);
				bw.write("@echo off\r\n");
				String logStr=DMXREALTIME_FILEPATH+mtId+"_"+curDateStr+"_"+mtCname+".log\r\n";
				String sysStr="\""+SYMSTAT_PATH+"symstat\" -sid "+mtSsn+" -i "+mtInterval+" -c "+mtNum;
				if(mtCname.equalsIgnoreCase("RA")){
					bw.write(sysStr+" -RA all > "+logStr);
				}else if(mtCname.equalsIgnoreCase("SA")){
					bw.write(sysStr+" -SA all > "+logStr);
				}else if(mtCname.equalsIgnoreCase("PORT")){
					bw.write(sysStr+" -type port -dir all > "+logStr);
				}else if(mtCname.equalsIgnoreCase("CACHE")){
					bw.write(sysStr+" -type cache -dir all> "+logStr);
				}else if(mtCname.equalsIgnoreCase("DISK")){
					bw.write(sysStr+" -type disk -disk all > "+logStr);
				}else if(mtCname.equalsIgnoreCase("SYSTEM")){
				//system为-raw
					bw.write(sysStr+" -raw > "+logStr);
				}else if(mtCname.equalsIgnoreCase("DA")){
					bw.write(sysStr+" -da all -type prefetch > "+logStr);
				}else if(mtCname.equalsIgnoreCase("DIRECTOR")){
					bw.write(sysStr+" -dir all > "+logStr);
				}else{
					log.error("=====组件类型("+mtCname+")不存在====");
				}
				bw.write("exit\r\n");
				
			}
			bw.flush();
			bw.close();
			fw.close();
			
			fw= new FileWriter(vbsFile,true);
			bw=new BufferedWriter(fw);
			bw.write("Set ws=CreateObject(\"Wscript.Shell\")\r\n");
			bw.write("ws.run \"cmd /c "+batFilePath+batFileName+"\",vbhide");
			bw.flush();
			bw.close();
			fw.close();
			Runtime rt = Runtime.getRuntime(); 
			String[] cpCmd  = new String[]{"wscript", batFilePath+vbsFileName}; 
			rt.exec(cpCmd);
//			
//			Map<String, Process> map=new HashMap<String, Process>();
//			map.put(mtId,pro);
		}catch (Exception e) {
			log.debug("=========IGMNT01Bl生成日志bat出错=========");
		}
	}
	
	/**
	 * 生成一个解析bat,并调用
	*/
	public void createParseBat(String mtId){
		try{
			Properties properties = this.getProperties();
			//bat文件路径
			String batFilePath=properties.getProperty("CREAT_BAT_FILEPATH");
			//String batFileName=properties.getProperty("PARSE_BAT_FILENAME");
			String vbsFileName=properties.getProperty("PARSE_VBS_FILENAME");
			//bat文件名字
			Runtime rt = Runtime.getRuntime(); 
			rt.exec("wscript "+batFilePath+vbsFileName+" "+mtId);
//			rt.exec("cmd.exe /c start " + batFilePath+batFileName+" "+mtId);
		}catch (Exception e) {
			log.debug("=========IGMNT01Bl解析bat出错=========");
		}
	}
	/**
	 * 获取System默认时间间隔
	 * @return
	 */
	private String getIntervalDefault(){
		String intervalDefault=IGMntConstantDefine.INTERVAL_DEFAULT;
		String[] defArr=intervalDefault.split(",");
		CodeDetailSearchCondImpl cond=new CodeDetailSearchCondImpl();
		//获取反射的属性值
		String valCcid=IGMntConstantDefine.getValue("SYSTEM_VAL_CODE");
		cond.setCcid(valCcid);
		if(defArr!=null){
			for (int i = 0; i < defArr.length; i++) {
				if("System".equalsIgnoreCase(defArr[i])){
					cond.setSyscoding(IGMntConstantDefine.INTERVAL_DEFAULT_VAL);
				}else{
					cond.setSyscoding(IGMntConstantDefine.INTERVAL_DEFAULT_OTHER_VAL);
				}
			}
		}
		List<CodeDetail> list=codeDetailBL.searchCodeDetail(cond, 1);
		if(list!=null&&list.size()>0){
			return list.get(0).getCid();
		}else{
			return "";
		}
		
	}
	/**
	 * 判断是否相同数据
	 * @return
	 */
	private  boolean isEqual(String cname,String kpi,List<SOC0304Info> mtInfoList,String[] selectIds){
		if(mtInfoList!=null&&mtInfoList.size()>0){
			for (int i = 0; i < mtInfoList.size(); i++) {
				SOC0304Info mtInfo=mtInfoList.get(i);
				//判断组件类别与kpi相同
				boolean isEqual=cname.equals(mtInfo.getMtCname())&&kpi.equals(mtInfo.getMtKpi());
				if(isEqual){
					//传过来的值如果为0，则判断为System相同
					if(selectIds==null||selectIds.length==0){
						return true;
					}else{
						//不为0则循环判断
						String objNames=mtInfo.getMtObjNames();
						if(objNames!=null&&!"".equals(objNames)){
							String[] objArr=objNames.split(",");
							//如果数据数量相同则有相同的可能
							if(objArr.length==selectIds.length){
								int count=0;//计数器，如果全部含有，则相同
								for (int j = 0; j < selectIds.length; j++) {
									for (int j2 = 0; j2 < objArr.length; j2++) {
										//如果两值相同则计数，跳出
										if(selectIds[j].equals(objArr[j2])){
											count++;
											break;
										}
									}
								}
								//这回判断出来一定相等
								if(count==selectIds.length){
									return true;
								}
							}
						}
					}
				}
		}
		}
		return false;
	}

	/**
	 * 取得实时性能集合
	 * @param mtId
	 * @return
	 * @throws BLException
	 */
	public Map<String, List<SOC0301Info>> getDataMap(int mtId) throws BLException {
		Map<String, List<SOC0301Info>> dataMap=new HashMap<String, List<SOC0301Info>>();
		
		SOC0301SearchCondImpl cond=new SOC0301SearchCondImpl();
		cond.setMtId_eq(mtId);
		List<SOC0301Info> drtList = soc0301BL.searchSoc0301(cond);//该任务所有实时性能数据
		
		SOC0304Info monitorTask = soc0304BL.searchSoc0304ByPK(mtId);
		String mtCname = monitorTask.getMtCname();//组件类别
		
		if(mtCname.equals("System")){//组件类别为系统
			dataMap.put("System", drtList);
		}else{//组件类别非系统
			String[] mtObjNames = monitorTask.getMtObjNames().split(",");//监控对象名数组
			for (String mtObjName : mtObjNames) {
				List<SOC0301Info> objList=new ArrayList<SOC0301Info>();
				for (int i = drtList.size()-1; i >-1; i--) {
					SOC0301Info drt = drtList.get(i);
					if(drt.getMtoName().equals(mtObjName)){
						objList.add(drt);
					}
				}
				dataMap.put(mtObjName, objList);
			}
		}
		return dataMap;
	}

	public void updateCapacityObject(IGMNT01DTO dto) throws BLException {
		IGMNT0102Form igmnt0102Form = dto.getIgmnt0102Form();
		String[] mtdValue = igmnt0102Form.getMtdValue();//阀值数组
		int mtId = igmnt0102Form.getMtId();
		//容量阈值修改
		if(mtId>9){
			SOC0423SearchCondImpl cond=new SOC0423SearchCondImpl();
			cond.setStatus(0);//未修改
			if(mtId==10){//文件系统
				cond.setObjectType("FS");
			}else if(mtId==11){//表空间
				cond.setObjectType("TS");
			}
			List<SOC0423Info> searchCapacityObjectList = soc0423BL.searchSOC0423(cond);
			for (SOC0423Info capacityObjectListInfo : searchCapacityObjectList) {
				SOC0423TB c=(SOC0423TB)capacityObjectListInfo;
				c.setWarningNum(Integer.valueOf(mtdValue[0]));//普通告警阈值
				c.setErrorNum(Integer.valueOf(mtdValue[1]));//严重告警阈值
				soc0423BL.updateSOC0423(c);
			}
		}
	}

	/**
	 * DMX实时设定
	 *
	 * @param soc0301BL DMX实时
	 */
	public void setSoc0301BL(SOC0301BL soc0301BL) {
		this.soc0301BL = soc0301BL;
	}

	/**
	 * debug监控任务BL设定
	 *
	 * @param soc0304BL debug监控任务BL
	 */
	public void setSoc0304BL(SOC0304BL soc0304BL) {
		this.soc0304BL = soc0304BL;
	}

	/**
	 * soc0117BL设定
	 *
	 * @param soc0117BL soc0117BL
	 */
	public void setSoc0117BL(SOC0117BL soc0117BL) {
		this.soc0117BL = soc0117BL;
	}

	/**
	 * EntityItemBL设定
	 *
	 * @param soc0118BL EntityItemBL
	 */
	public void setSoc0118BL(SOC0118BL soc0118BL) {
		this.soc0118BL = soc0118BL;
	}

	/**
	 * 容量对象BL设定
	 *
	 * @param soc0423BL 容量对象BL
	 */
	public void setSoc0423BL(SOC0423BL soc0423BL) {
		this.soc0423BL = soc0423BL;
	}
}
