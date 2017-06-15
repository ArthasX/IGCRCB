/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ����:����ͳ��ʵ�� 
 * ��������: ����ͳ��ʵ�� 
 * ������¼: ����ȫ 2012/07/03 
 * �޸ļ�¼: ¬��Ԫ 2012/08/09
 * 			Capacity_Object_List�޸�ΪSOC0423
 * 			DBCapacityRealTime�޸�ΪSOC0401
 * 			LVCapacityRealTime�޸�ΪSOC0405
 * 			PVHostRealTime�޸�ΪSOC0409
 * 			PVStorageRealTime�޸�ΪSOC0410
 * 			ReportType�޸�ΪSOC0424
 * 			StorageCapacityRealTime�޸�ΪSOC0411
 * 			TSCapacityRealTime�޸�ΪSOC0415
 * 			VGCapacityRealTime�޸�ΪSOC0419
 * 			BusinessCapacityRealTimeVW�޸�ΪSOC0428
 * 			HostCapacityRealTimeVW�޸�ΪSOC0429
 */
public class IGRPT03BLImpl extends BaseBLImpl implements IGRPT03BL {
	static Log log = LogFactory.getLog(IGRPT03BLImpl.class);

	protected MessageResources resources = MessageResources
			.getMessageResources("com.deliverik.infogovernor.comResources");
	protected MessageResources syresources = MessageResources.getMessageResources("SystemConfigResources");
	/**�洢ʵʱBL*/
	protected SOC0411BL soc0411BL;
	/**ҵ��ϵͳ��ͼBL*/
	protected SOC0428BL soc0428BL;
	/**������ͼBL*/
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
	/** ������ϸ��ϢBL */
	protected CodeDetailBL codeDetailBL;
	
	protected ReportFileDefinitionBL reportFileDefinitionBL;
	
	/** ������ϢBL */
	protected RoleReportBL roleReportBL;
	
	/** �û���ɫ���� */
	private UserRoleBL userRoleBL;
	
	/**
	 * resources�趨
	 *
	 * @param resources resources
	 */
	public void setResources(MessageResources resources) {
		this.resources = resources;
	}
	/**
	 * �洢ʵʱBL�趨
	 *
	 * @param soc0411BL �洢ʵʱBL
	 */
	public void setSoc0411BL(
			SOC0411BL soc0411BL) {
		this.soc0411BL = soc0411BL;
	}
	
	
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	/**
	 * ҵ��ϵͳ��ͼBL�趨
	 *
	 * @param soc0428BL ҵ��ϵͳ��ͼBL
	 */
	public void setSoc0428BL(SOC0428BL soc0428BL) {
		this.soc0428BL = soc0428BL;
	}
	/**
	 * ������ͼBL�趨
	 *
	 * @param soc0429BL ������ͼBL
	 */
	public void setSoc0429BL(SOC0429BL soc0429BL) {
		this.soc0429BL = soc0429BL;
	}
	
	/**
	 * VGBL�趨
	 *
	 * @param soc0419BL VGBL
	 */
	public void setSoc0419BL(SOC0419BL soc0419BL) {
		this.soc0419BL = soc0419BL;
	}
	/**
	 * DBBL�趨
	 *
	 * @param soc0401BL DBBL
	 */
	public void setSoc0401BL(SOC0401BL soc0401BL) {
		this.soc0401BL = soc0401BL;
	}
	/**
	 * LVBL�趨
	 *
	 * @param soc0405BL LVBL
	 */
	public void setSoc0405BL(SOC0405BL soc0405BL) {
		this.soc0405BL = soc0405BL;
	}
	/**
	 * TSBL�趨
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
	 * entityItem�趨
	 *
	 * @param entityItemBL entityItem
	 */
	public void setSoc0118BL(SOC0118BL entityItemBL) {
		this.soc0118BL = entityItemBL;
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
	public IGRPT03DTO initReport(IGRPT03DTO dto) throws BLException {
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
		//������ʼ��ѯ
		//��ѯ�洢
		SOC0118SearchCondImpl scCond=new SOC0118SearchCondImpl();
		scCond.setEsyscoding_eq(IGRptConstantDefine.STORAGE_ESYSCODING);
		List<SOC0118Info> scList=soc0118BL.searchEntityItem(scCond);
		dto.setScList(scList);
		SOC0118SearchCondImpl bcCond=new SOC0118SearchCondImpl();
		bcCond.setEsyscoding_eq(IGRptConstantDefine.BUSINESS_ESYSCODING);
		List<SOC0118Info> bcList=soc0118BL.searchEntityItem(bcCond);
		dto.setBcVWList(bcList);
//		//��ѯ����
		SOC0118SearchCondImpl hcCond=new SOC0118SearchCondImpl();
		hcCond.setEsyscoding_like(IGRptConstantDefine.HOST_ESYSCODING);
		List<SOC0118Info> hcList=soc0118BL.searchEntityItem(hcCond);
		dto.setHcVWList(hcList);
		//���ܱ����ѯ
		SOC0118SearchCondImpl tcond =new SOC0118SearchCondImpl();
		tcond.setCcid("913");
		tcond.setPcid("0001");
		tcond.setCdstatus("1");
		//��ѯ���
		List<CodeDetailEntity> cdtList=soc0118BL.searchCodeDetailSQL(tcond);
		if(cdtList!=null&&cdtList.size()>0){
			//��ѯ�Ӷ���
			SOC0118SearchCondImpl cdcond =new SOC0118SearchCondImpl();
			cdcond.setCcid("914");
			cdcond.setCdstatus("1");
			List<CodeDetailEntity> cdList=soc0118BL.searchCodeDetailSQL(cdcond);
			dto.setObjCodeDeatilList(cdList);
		}
		dto.setCatagoryCodeDeatilList(cdtList);
		
		
		//���񱨱��ѯ
		ReportFileDefinitionSearchCondImpl cond=new ReportFileDefinitionSearchCondImpl();
		cond.setRfdtype("217002");
		List<ReportFileDefinition> reportFileDefinitionList=reportFileDefinitionBL.searchReportFileDefinition(cond, 0, 0);
		/**��Ʒ�˴������������δ��list����dto��
		List<ReportFileDefinition> rfdNewList=new ArrayList<ReportFileDefinition>();
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
				dto.setReportFileDefinitionList(rfdNewList);
			}
		}**/
		dto.setReportFileDefinitionList(reportFileDefinitionList);
		return dto;
	}
	/**��ʼ��������ѯ����*/
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
	/**����·��ת��*/
	public IGRPT03DTO capacityBirtForm(IGRPT03DTO dto) throws BLException{
		IGRPT0302Form form=dto.getIgrpt0302Form();
		if(form!=null){
			String objType=form.getObjType();
			//��Ҫ����ʱ�䣬ʱ������,ģ��·��
			String rfdDesc="�洢";
			if(objType.equals("storage")){
			}else if(objType.equals("business")){
				rfdDesc="ҵ��ϵͳ";
			}else if(objType.equals("host")){
				rfdDesc="����";
			}else if(objType.equals("vg")){
				String[] vgArr=form.getVgName().split(",");
				if(vgArr!=null&&vgArr.length>1){
					form.setMode("many");
				}
				rfdDesc="����";
			}else if(objType.equals("fs")){
				String[] fsArr=form.getFsName().split(",");
				if(fsArr!=null&&fsArr.length>1){
					form.setMode("many");
				}
				rfdDesc="�ļ�ϵͳ";
			}else if(objType.equals("db")){
				rfdDesc="���ݿ�";
			}else if(objType.equals("ts")){
				String[] tsArr=form.getTsName().split(",");
				if(tsArr!=null&&tsArr.length>1){
					form.setMode("many");
				}
				rfdDesc="��ռ�";
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
