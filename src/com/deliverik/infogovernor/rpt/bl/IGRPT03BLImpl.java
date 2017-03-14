/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.rpt.bl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.util.MessageResources;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.CodeDetailEntity;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.condition.UserRoleSearchCondImpl;
import com.deliverik.infogovernor.rpt.bl.task.SOC0401BL;
import com.deliverik.infogovernor.rpt.bl.task.SOC0405BL;
import com.deliverik.infogovernor.rpt.bl.task.SOC0411BL;
import com.deliverik.infogovernor.rpt.bl.task.SOC0415BL;
import com.deliverik.infogovernor.rpt.bl.task.SOC0419BL;
import com.deliverik.infogovernor.rpt.bl.task.SOC0428BL;
import com.deliverik.infogovernor.rpt.bl.task.SOC0429BL;
import com.deliverik.infogovernor.rpt.dto.IGRPT03DTO;
import com.deliverik.infogovernor.rpt.form.IGRPT0302Form;
import com.deliverik.infogovernor.sym.bl.task.ReportFileDefinitionBL;
import com.deliverik.infogovernor.sym.bl.task.RoleReportBL;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;
import com.deliverik.infogovernor.sym.model.RoleReport;
import com.deliverik.infogovernor.sym.model.condition.ReportFileDefinitionSearchCondImpl;
import com.deliverik.infogovernor.sym.model.condition.RoleReportSearchCondImpl;

/**
 * 概述:报表统计实现 
 * 功能描述: 报表统计实现 
 * 创建记录: 杨龙全 2012/07/03 
 * 修改记录: 卢嘉元 2012/08/09
 * 			Capacity_Object_List修改为SOC0423
 * 			DBCapacityRealTime修改为SOC0401
 * 			LVCapacityRealTime修改为SOC0405
 * 			PVHostRealTime修改为SOC0409
 * 			PVStorageRealTime修改为SOC0410
 * 			ReportType修改为SOC0424
 * 			StorageCapacityRealTime修改为SOC0411
 * 			TSCapacityRealTime修改为SOC0415
 * 			VGCapacityRealTime修改为SOC0419
 * 			BusinessCapacityRealTimeVW修改为SOC0428
 * 			HostCapacityRealTimeVW修改为SOC0429
 */
public class IGRPT03BLImpl extends BaseBLImpl implements IGRPT03BL {
	static Log log = LogFactory.getLog(IGRPT03BLImpl.class);

	protected MessageResources resources = MessageResources
			.getMessageResources("com.deliverik.infogovernor.comResources");
	protected MessageResources syresources = MessageResources.getMessageResources("SystemConfigResources");
	/**存储实时BL*/
	protected SOC0411BL soc0411BL;
	/**业务系统视图BL*/
	protected SOC0428BL soc0428BL;
	/**主机视图BL*/
	protected SOC0429BL soc0429BL;
	/**VGBL*/
	protected SOC0419BL soc0419BL;
	/**DBBL*/
	protected SOC0401BL soc0401BL;
	/**LVBL*/
	protected SOC0405BL soc0405BL;
	/**TSBL*/
	protected SOC0415BL soc0415BL;
	/**entityItem*/
	protected SOC0118BL soc0118BL;
	/** 数据详细信息BL */
	protected CodeDetailBL codeDetailBL;
	
	protected ReportFileDefinitionBL reportFileDefinitionBL;
	
	/** 报表信息BL */
	protected RoleReportBL roleReportBL;
	
	/** 用户角色操作 */
	private UserRoleBL userRoleBL;
	
	/**
	 * resources设定
	 *
	 * @param resources resources
	 */
	public void setResources(MessageResources resources) {
		this.resources = resources;
	}
	/**
	 * 存储实时BL设定
	 *
	 * @param soc0411BL 存储实时BL
	 */
	public void setSoc0411BL(
			SOC0411BL soc0411BL) {
		this.soc0411BL = soc0411BL;
	}
	
	
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	/**
	 * 业务系统视图BL设定
	 *
	 * @param soc0428BL 业务系统视图BL
	 */
	public void setSoc0428BL(SOC0428BL soc0428BL) {
		this.soc0428BL = soc0428BL;
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
	 * VGBL设定
	 *
	 * @param soc0419BL VGBL
	 */
	public void setSoc0419BL(SOC0419BL soc0419BL) {
		this.soc0419BL = soc0419BL;
	}
	/**
	 * DBBL设定
	 *
	 * @param soc0401BL DBBL
	 */
	public void setSoc0401BL(SOC0401BL soc0401BL) {
		this.soc0401BL = soc0401BL;
	}
	/**
	 * LVBL设定
	 *
	 * @param soc0405BL LVBL
	 */
	public void setSoc0405BL(SOC0405BL soc0405BL) {
		this.soc0405BL = soc0405BL;
	}
	/**
	 * TSBL设定
	 *
	 * @param soc0415BL TSBL
	 */
	public void setSoc0415BL(SOC0415BL soc0415BL) {
		this.soc0415BL = soc0415BL;
	}
	
	public void setRoleReportBL(RoleReportBL roleReportBL) {
		this.roleReportBL = roleReportBL;
	}
	/**
	 * entityItem设定
	 *
	 * @param entityItemBL entityItem
	 */
	public void setSoc0118BL(SOC0118BL entityItemBL) {
		this.soc0118BL = entityItemBL;
	}
	/**
	 * 数据详细信息BL设定
	 *
	 * @param codeDetailBL 数据详细信息BL
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}
	
	
	
	/**
	 * reportFileDefinitionBL设定
	 *
	 * @param reportFileDefinitionBL reportFileDefinitionBL
	 */
	public void setReportFileDefinitionBL(
			ReportFileDefinitionBL reportFileDefinitionBL) {
		this.reportFileDefinitionBL = reportFileDefinitionBL;
	}
	/**初始化报表数据*/
	public IGRPT03DTO initReport(IGRPT03DTO dto) throws BLException {
		//可视报表集合
		List<ReportFileDefinition> rfdAllList=new ArrayList<ReportFileDefinition>();
		UserRoleSearchCondImpl userRoleCond=new UserRoleSearchCondImpl();
		userRoleCond.setUserid(dto.getUser().getUserid());
		//根据用户ID检索用户角色
		List<UserRole> userRoleList=this.userRoleBL.searchUserRole(userRoleCond);
		if(userRoleList!=null&&userRoleList.size()>0){
			for(UserRole userRole:userRoleList){
				RoleReportSearchCondImpl rrCond=new RoleReportSearchCondImpl();
				rrCond.setRoleid(userRole.getRoleid());
				List<RoleReport> roleReportList=this.roleReportBL.searchRoleReportByRoleid(rrCond);
				if(roleReportList!=null&&roleReportList.size()>0){
					for(RoleReport roleReport:roleReportList){
						if(!rfdAllList.contains(roleReport.getReportFileDefinitionTB())){
							rfdAllList.add(roleReport.getReportFileDefinitionTB());
						}
					}
				}
			}
		}
		//容量初始查询
		//查询存储
		SOC0118SearchCondImpl scCond=new SOC0118SearchCondImpl();
		scCond.setEsyscoding_eq(IGRptConstantDefine.STORAGE_ESYSCODING);
		List<SOC0118Info> scList=soc0118BL.searchEntityItem(scCond);
		dto.setScList(scList);
		SOC0118SearchCondImpl bcCond=new SOC0118SearchCondImpl();
		bcCond.setEsyscoding_eq(IGRptConstantDefine.BUSINESS_ESYSCODING);
		List<SOC0118Info> bcList=soc0118BL.searchEntityItem(bcCond);
		dto.setBcVWList(bcList);
//		//查询主机
		SOC0118SearchCondImpl hcCond=new SOC0118SearchCondImpl();
		hcCond.setEsyscoding_like(IGRptConstantDefine.HOST_ESYSCODING);
		List<SOC0118Info> hcList=soc0118BL.searchEntityItem(hcCond);
		dto.setHcVWList(hcList);
		//性能报表查询
		SOC0118SearchCondImpl tcond =new SOC0118SearchCondImpl();
		tcond.setCcid("913");
		tcond.setPcid("0001");
		tcond.setCdstatus("1");
		//查询类别
		List<CodeDetailEntity> cdtList=soc0118BL.searchCodeDetailSQL(tcond);
		if(cdtList!=null&&cdtList.size()>0){
			//查询子对象
			SOC0118SearchCondImpl cdcond =new SOC0118SearchCondImpl();
			cdcond.setCcid("914");
			cdcond.setCdstatus("1");
			List<CodeDetailEntity> cdList=soc0118BL.searchCodeDetailSQL(cdcond);
			dto.setObjCodeDeatilList(cdList);
		}
		dto.setCatagoryCodeDeatilList(cdtList);
		
		
		//服务报表查询
		ReportFileDefinitionSearchCondImpl cond=new ReportFileDefinitionSearchCondImpl();
		cond.setRfdtype("217002");
		List<ReportFileDefinition> reportFileDefinitionList=reportFileDefinitionBL.searchReportFileDefinition(cond, 0, 0);
		/**产品此处处理出现问题未将list存入dto中
		List<ReportFileDefinition> rfdNewList=new ArrayList<ReportFileDefinition>();
		//放入dto
		if(rfdAllList!=null&&rfdAllList.size()>0){
			if(reportFileDefinitionList!=null&&reportFileDefinitionList.size()>0){
				for(ReportFileDefinition rfd:reportFileDefinitionList){
					if(rfdAllList.contains(rfd)){
						if(!rfdNewList.contains(rfd)){
							rfdNewList.add(rfd);
						}
					}
				}
				dto.setReportFileDefinitionList(rfdNewList);
			}
		}**/
		dto.setReportFileDefinitionList(reportFileDefinitionList);
		return dto;
	}
	/**初始化主机查询数据*/
	public IGRPT03DTO initHostSearch(IGRPT03DTO dto) throws BLException {
		IGRPT0302Form form=dto.getIgrpt0302Form();
		String objName=form.getObjName();
		String objType=form.getObjType();
		String eiid=form.getEiid();
		if(objType.equals("storage")){
			form.setStorageName(objName);
			return dto;
		}else if(objType.equals("business")){
			form.setBusinessName(eiid);
			return dto;
		}else if(objType.equals("host")){
			form.setHostName(objName);
			return dto;
		}
		return dto;
	}
	/**容量路径转向*/
	public IGRPT03DTO capacityBirtForm(IGRPT03DTO dto) throws BLException{
		IGRPT0302Form form=dto.getIgrpt0302Form();
		if(form!=null){
			String objType=form.getObjType();
			//需要传参时间，时间类型,模板路径
			String rfdDesc="存储";
			if(objType.equals("storage")){
			}else if(objType.equals("business")){
				rfdDesc="业务系统";
			}else if(objType.equals("host")){
				rfdDesc="主机";
			}else if(objType.equals("vg")){
				String[] vgArr=form.getVgName().split(",");
				if(vgArr!=null&&vgArr.length>1){
					form.setMode("many");
				}
				rfdDesc="卷组";
			}else if(objType.equals("fs")){
				String[] fsArr=form.getFsName().split(",");
				if(fsArr!=null&&fsArr.length>1){
					form.setMode("many");
				}
				rfdDesc="文件系统";
			}else if(objType.equals("db")){
				rfdDesc="数据库";
			}else if(objType.equals("ts")){
				String[] tsArr=form.getTsName().split(",");
				if(tsArr!=null&&tsArr.length>1){
					form.setMode("many");
				}
				rfdDesc="表空间";
			}
			String rfdType="217003";
			ReportFileDefinitionSearchCondImpl cond=new ReportFileDefinitionSearchCondImpl();
			cond.setRfdtype(rfdType);
			cond.setRfdtitle(rfdDesc);
			List<ReportFileDefinition> rfdList=reportFileDefinitionBL.searchReportFileDefinition(cond, 0, 0);
			if(rfdList!=null&&rfdList.size()>0){
				String rfdFileName=rfdList.get(0).getRfdfilename();
				form.setReportPath(syresources.getMessage("BIRT_REPORT_PATH")+rfdFileName+"/1/"+rfdFileName+".rptdesign");
			}else{
				log.error("=========capacity have not rptdesign!|data is not exist========");
			}
		}
		return dto;
	}
	
}
