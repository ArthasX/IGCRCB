/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.rpt.bl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.condition.UserRoleSearchCondImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.rpt.dto.IGRPT04DTO;
import com.deliverik.infogovernor.sym.bl.task.CustomConfigurationBL;
import com.deliverik.infogovernor.sym.bl.task.ReportFileDefinitionBL;
import com.deliverik.infogovernor.sym.bl.task.RoleReportBL;
import com.deliverik.infogovernor.sym.model.CustomConfigurationInfo;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;
import com.deliverik.infogovernor.sym.model.RoleReport;
import com.deliverik.infogovernor.sym.model.condition.ReportFileDefinitionSearchCondImpl;
import com.deliverik.infogovernor.sym.model.condition.RoleReportSearchCondImpl;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * 概述:报表统计实现 
 * 功能描述: 报表统计实现 
 */
public class IGRPT04BLImpl extends BaseBLImpl implements IGRPT04BL {
	static Log log = LogFactory.getLog(IGRPT04BLImpl.class);

	/** 数据详细信息BL */
	protected CodeDetailBL codeDetailBL;
	
	protected ReportFileDefinitionBL reportFileDefinitionBL;
	
	/** 定制报表参数信息BL*/
    protected CustomConfigurationBL customConfigurationBL;
    
	/** 报表信息BL */
	protected RoleReportBL roleReportBL;
	
	/** 用户角色操作 */
	private UserRoleBL userRoleBL;
	
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	
	public void setRoleReportBL(RoleReportBL roleReportBL) {
		this.roleReportBL = roleReportBL;
	}

	/**
     * @param 定制报表参数信息BL the customConfigurationBL to set
     */
    public void setCustomConfigurationBL(CustomConfigurationBL customConfigurationBL) {
        this.customConfigurationBL = customConfigurationBL;
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
	public IGRPT04DTO initReport(IGRPT04DTO dto) throws BLException {
		
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
		CodeDetailSearchCondImpl cdscond=new CodeDetailSearchCondImpl();
		cdscond.setCcid("217");
		cdscond.setCdstatus("2");
		List<String> sysList=new ArrayList<String>();
		List<CodeDetail> parCodeDetailList = codeDetailBL.searchCodeDetail(cdscond, 0);//一级节点
		List<CodeDetail> cldCodeDetailList=new ArrayList<CodeDetail>();//二级节点
		List<ReportFileDefinition> rfdList=new ArrayList<ReportFileDefinition>();//报表集合
		
		for (CodeDetail codeDetail : parCodeDetailList) {
			String cid = codeDetail.getCid();
			String sys = codeDetail.getSyscoding();
			sysList.add(sys);
			cdscond=new CodeDetailSearchCondImpl();
			cdscond.setPccid("217");
			cdscond.setPcid(cid);
			List<CodeDetail> codeDetailList = codeDetailBL.searchCodeDetail(cdscond, 0);
			cldCodeDetailList.addAll(codeDetailList);
			List<ReportFileDefinition> rfdNewList=new ArrayList<ReportFileDefinition>();
			
			if(codeDetailList!=null&&codeDetailList.size()>0){
				for (CodeDetail cldcodeDetail : codeDetailList) {
					String syscoding = cldcodeDetail.getSyscoding();
					//服务报表查询
					ReportFileDefinitionSearchCondImpl cond=new ReportFileDefinitionSearchCondImpl();
					cond.setRfdtype(syscoding);
					List<ReportFileDefinition> reportFileDefinitionList=reportFileDefinitionBL.searchReportFileDefinition(cond, 0, 0);
					
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
						}
					}
					
					String parSyscoding = codeDetail.getSyscoding();
					//服务报表查询
					 cond=new ReportFileDefinitionSearchCondImpl();
					cond.setRfdtype(parSyscoding);
					List<ReportFileDefinition> parReportFileDefinitionList=reportFileDefinitionBL.searchReportFileDefinition(cond, 0, 0);
					//放入dto
					if(rfdAllList!=null&&rfdAllList.size()>0){
						if(parReportFileDefinitionList!=null&&parReportFileDefinitionList.size()>0){
							for(ReportFileDefinition rfd:parReportFileDefinitionList){
								if(rfdAllList.contains(rfd)){
									if(!rfdNewList.contains(rfd)){
										rfdNewList.add(rfd);
									}
								}
							}
						}
					}
				}
			}else{
				String syscoding = codeDetail.getSyscoding();
				//服务报表查询
				ReportFileDefinitionSearchCondImpl cond=new ReportFileDefinitionSearchCondImpl();
				cond.setRfdtype(syscoding);
				List<ReportFileDefinition> reportFileDefinitionList=reportFileDefinitionBL.searchReportFileDefinition(cond, 0, 0);
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
					}
				}
			}
			rfdList.addAll(rfdNewList);
		}
		dto.setParCodeDetailList(parCodeDetailList);
		dto.setCldCodeDetailList(cldCodeDetailList);
		dto.setRfdList(rfdList);
		return dto;
	}
	
	/**
	 * 报表定义参数信息取得
	 * 
	 * @param IGRPT04DTO dto
	 * @return IGRPT04DTO
	 */
	public IGRPT04DTO getCustomConfigurationInfo(IGRPT04DTO dto) throws BLException  {
	    
	    //取得定制报表模板值
	    String reportTemplateValue = dto.getTemName();
	    
	    //取得定制报表所用模板名称
        CodeDetailSearchCondImpl codedetailcond = new CodeDetailSearchCondImpl();
        codedetailcond.setCcid(CodeDefine.getCodeDefine("RFDFILEMODEL").getCcid());
        codedetailcond.setCid(dto.getTemName());
        List<CodeDetail> cdList = codeDetailBL.searchCodeDetail(codedetailcond, 
                CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
        if (!cdList.isEmpty()) {
            dto.setTemName(cdList.get(0).getCdinfo());
        }
        
        //取得定制报表所需参数
        CustomConfigurationInfo customConfigurationInfo = 
            customConfigurationBL.searchCustomConfigurationByPK(Integer.valueOf(dto.getRfdid()));
        
        //传给报表的流程ID参数需要截取前五位，这样是为了在统计时包括所有版本。
        if (customConfigurationInfo.getPdid().indexOf("#") != -1) {
            String[] pdids = customConfigurationInfo.getPdid().split("#");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < pdids.length; i++) {
                if (i == 0) {
                    sb.append(pdids[i].substring(0, 5));
                } else {
                    sb.append("#").append(pdids[i].substring(0, 5));
                }
            }
            dto.setPdid(sb.toString());
        } else {
            dto.setPdid(customConfigurationInfo.getPdid().substring(0, 5));
        }
        dto.setPsdcode(customConfigurationInfo.getPrstatusInfo());
        dto.setPidid(customConfigurationInfo.getPidid());
        dto.setPidvalue(customConfigurationInfo.getPidvalue());
        
        //取得定制报表标题
        ReportFileDefinition rfdinfo = 
            reportFileDefinitionBL.searchReportFileDefinitionByKey(Integer.valueOf(dto.getRfdid()));
        dto.setTitle(rfdinfo.getRfdtitle());
        
        //如果是树形报表，需判断是按照一级还是二级统计。
        if (IGRptConstantDefine.REPORT_TEMPLATE_TREEFORM.equals(reportTemplateValue)) {
            if (dto.getPidvalue() != null) {
                String[] pidvalues = dto.getPidvalue().split("#");
                if(pidvalues[0].length() > 6) {
                    dto.setTreeFormLevel2("1");
                }
            }
        }
        return dto;
	}
	
}
