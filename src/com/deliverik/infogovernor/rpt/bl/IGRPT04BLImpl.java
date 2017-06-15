/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ����:����ͳ��ʵ�� 
 * ��������: ����ͳ��ʵ�� 
 */
public class IGRPT04BLImpl extends BaseBLImpl implements IGRPT04BL {
	static Log log = LogFactory.getLog(IGRPT04BLImpl.class);

	/** ������ϸ��ϢBL */
	protected CodeDetailBL codeDetailBL;
	
	protected ReportFileDefinitionBL reportFileDefinitionBL;
	
	/** ���Ʊ��������ϢBL*/
    protected CustomConfigurationBL customConfigurationBL;
    
	/** ������ϢBL */
	protected RoleReportBL roleReportBL;
	
	/** �û���ɫ���� */
	private UserRoleBL userRoleBL;
	
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	
	public void setRoleReportBL(RoleReportBL roleReportBL) {
		this.roleReportBL = roleReportBL;
	}

	/**
     * @param ���Ʊ��������ϢBL the customConfigurationBL to set
     */
    public void setCustomConfigurationBL(CustomConfigurationBL customConfigurationBL) {
        this.customConfigurationBL = customConfigurationBL;
    }
    
	/**
	 * ������ϸ��ϢBL�趨
	 *
	 * @param codeDetailBL ������ϸ��ϢBL
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}
	
	/**
	 * reportFileDefinitionBL�趨
	 *
	 * @param reportFileDefinitionBL reportFileDefinitionBL
	 */
	public void setReportFileDefinitionBL(
			ReportFileDefinitionBL reportFileDefinitionBL) {
		this.reportFileDefinitionBL = reportFileDefinitionBL;
	}
	/**��ʼ����������*/
	public IGRPT04DTO initReport(IGRPT04DTO dto) throws BLException {
		
		//���ӱ�����
		List<ReportFileDefinition> rfdAllList=new ArrayList<ReportFileDefinition>();
		UserRoleSearchCondImpl userRoleCond=new UserRoleSearchCondImpl();
		userRoleCond.setUserid(dto.getUser().getUserid());
		//�����û�ID�����û���ɫ
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
		List<CodeDetail> parCodeDetailList = codeDetailBL.searchCodeDetail(cdscond, 0);//һ���ڵ�
		List<CodeDetail> cldCodeDetailList=new ArrayList<CodeDetail>();//�����ڵ�
		List<ReportFileDefinition> rfdList=new ArrayList<ReportFileDefinition>();//������
		
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
					//���񱨱��ѯ
					ReportFileDefinitionSearchCondImpl cond=new ReportFileDefinitionSearchCondImpl();
					cond.setRfdtype(syscoding);
					List<ReportFileDefinition> reportFileDefinitionList=reportFileDefinitionBL.searchReportFileDefinition(cond, 0, 0);
					
					//����dto
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
					//���񱨱��ѯ
					 cond=new ReportFileDefinitionSearchCondImpl();
					cond.setRfdtype(parSyscoding);
					List<ReportFileDefinition> parReportFileDefinitionList=reportFileDefinitionBL.searchReportFileDefinition(cond, 0, 0);
					//����dto
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
				//���񱨱��ѯ
				ReportFileDefinitionSearchCondImpl cond=new ReportFileDefinitionSearchCondImpl();
				cond.setRfdtype(syscoding);
				List<ReportFileDefinition> reportFileDefinitionList=reportFileDefinitionBL.searchReportFileDefinition(cond, 0, 0);
				//����dto
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
	 * �����������Ϣȡ��
	 * 
	 * @param IGRPT04DTO dto
	 * @return IGRPT04DTO
	 */
	public IGRPT04DTO getCustomConfigurationInfo(IGRPT04DTO dto) throws BLException  {
	    
	    //ȡ�ö��Ʊ���ģ��ֵ
	    String reportTemplateValue = dto.getTemName();
	    
	    //ȡ�ö��Ʊ�������ģ������
        CodeDetailSearchCondImpl codedetailcond = new CodeDetailSearchCondImpl();
        codedetailcond.setCcid(CodeDefine.getCodeDefine("RFDFILEMODEL").getCcid());
        codedetailcond.setCid(dto.getTemName());
        List<CodeDetail> cdList = codeDetailBL.searchCodeDetail(codedetailcond, 
                CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
        if (!cdList.isEmpty()) {
            dto.setTemName(cdList.get(0).getCdinfo());
        }
        
        //ȡ�ö��Ʊ����������
        CustomConfigurationInfo customConfigurationInfo = 
            customConfigurationBL.searchCustomConfigurationByPK(Integer.valueOf(dto.getRfdid()));
        
        //�������������ID������Ҫ��ȡǰ��λ��������Ϊ����ͳ��ʱ�������а汾��
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
        
        //ȡ�ö��Ʊ������
        ReportFileDefinition rfdinfo = 
            reportFileDefinitionBL.searchReportFileDefinitionByKey(Integer.valueOf(dto.getRfdid()));
        dto.setTitle(rfdinfo.getRfdtitle());
        
        //��������α������ж��ǰ���һ�����Ƕ���ͳ�ơ�
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
