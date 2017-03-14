/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.soc.dbs.bl;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0119BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0305BL;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0305Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0305SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0305TB;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.IG731BL;
import com.deliverik.framework.workflow.prd.model.IG731Info;
import com.deliverik.framework.workflow.prd.model.condition.IG731SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.infogovernor.rpt.bl.task.SOC0411BL;
import com.deliverik.infogovernor.rpt.model.SOC0411Info;
import com.deliverik.infogovernor.scheduling.bl.task.QuartzJobsBL;
import com.deliverik.infogovernor.scheduling.model.QuartzJobsDetail;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzJobsSearchCondImpl;
import com.deliverik.infogovernor.soc.dbs.bl.task.Collect_Symmetrix_InfoBL;
import com.deliverik.infogovernor.soc.dbs.bl.task.Collect_Symmetrix_Monitor_RtBL;
import com.deliverik.infogovernor.soc.dbs.dto.IGDBS01DTO;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Info;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Monitor_Rt;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Monitor_RtVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_Symmetrix_InfoSearchCondImpl;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_Symmetrix_Monitor_RtSearchCondImpl;
import com.deliverik.infogovernor.soc.dbs.model.entity.Collect_Symmetrix_Monitor_RtTB;
import com.deliverik.infogovernor.soc.dbs.model.entity.Collect_Symmetrix_Monitor_RtVW;
import com.deliverik.infogovernor.soc.mnt.bl.task.MonitorObjectDefVWBL;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectDefVWInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorObjectDefVWSearchCondImpl;
import com.deliverik.infogovernor.util.CodeDefine;
import com.deliverik.infogovernor.util.SVCHelper;


/**
 * @����SOC EMC��ά�洢����ƽ̨��ҳBL
 * @�������� 1. ��IOPS/������
 *			2. ��������Ϣ
 *			3. ���д���ʡ�����������
 *			4. ��IOPS/������
 *			5. ��������Ϣ
 * 			6. �Ҷ�д���ʡ�����������
 *			7. ҵ���������
 *			8. ����KPI
 *			9.	��ά������ʾ
 *			10.����DMX���ܸ澯��Ϣ
 * @������¼��������    2010/12/09
 * @�޸ļ�¼��byf 2012/02/14
 * @version 1.0
 */

public class IGDBS01BLImpl extends BaseBLImpl implements IGDBS01BL {
	
	static Log log = LogFactory.getLog(IGDBS01BLImpl.class);
	protected SOC0411BL soc0411BL;
	protected CodeListUtils codeListUtils;
	protected IG500BL ig500BL;
	/**
	 * soc0411BL�趨
	 *
	 * @param soc0411BL soc0411BL
	 */
	public void setSoc0411BL(SOC0411BL soc0411BL) {
		this.soc0411BL = soc0411BL;
	}
	/**
	 * ig500BL�趨
	 *
	 * @param ig500BL ig500BL
	 */
	public void setIg500BL(IG500BL ig500BL) {
		this.ig500BL = ig500BL;
	}
	/**
	 * ig731BL�趨
	 *
	 * @param ig731BL ig731BL
	 */
	public void setIg731BL(IG731BL ig731BL) {
		this.ig731BL = ig731BL;
	}
	/**
	 * StorageEventҵ���߼��ӿ��趨
	 *
	 * @param soc0305BL StorageEventҵ���߼��ӿ�
	 */
	public void setSoc0305BL(SOC0305BL soc0305BL) {
		this.soc0305BL = soc0305BL;
	}
	/**
	 * ���̴���BL�趨
	 *
	 * @param workFlowOperationBL ���̴���BL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}
	/**
	 * ��ض���KPI��Ϣ��ͼҵ���߼��ӿ��趨
	 *
	 * @param monitorObjectDefVWBL ��ض���KPI��Ϣ��ͼҵ���߼��ӿ�
	 */
	public void setMonitorObjectDefVWBL(MonitorObjectDefVWBL monitorObjectDefVWBL) {
		this.monitorObjectDefVWBL = monitorObjectDefVWBL;
	}
	/**
	 * �������ϵBL�趨
	 *
	 * @param soc0119BL �������ϵBL
	 */
	public void setSoc0119BL(SOC0119BL soc0119BL) {
		this.soc0119BL = soc0119BL;
	}
	/**
	 * EntityItemBL�趨
	 *
	 * @param soc0118BL EntityItemBL
	 */
	public void setSoc0118BL(SOC0118BL soc0118BL) {
		this.soc0118BL = soc0118BL;
	}
	protected IG731BL ig731BL;
	/** StorageEventҵ���߼��ӿ� */
	protected SOC0305BL soc0305BL;
	protected QuartzJobsBL quartzJobsBL;
	protected Collect_Symmetrix_InfoBL collect_Symmetrix_InfoBL;
	protected Collect_Symmetrix_Monitor_RtBL collect_Symmetrix_Monitor_RtBL;
	protected CodeDetailBL codeDetailBL;
	private UserRoleBL userRoleBL;
	/**���̴���BL*/
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/**��ض���KPI��Ϣ��ͼҵ���߼��ӿ�*/
	protected MonitorObjectDefVWBL monitorObjectDefVWBL;
	
	/** �������ϵBL */
	protected SOC0119BL soc0119BL;
	/** EntityItemBL */
	protected SOC0118BL soc0118BL;
	
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	public void setEntityItemBL(SOC0118BL entityItemBL) {
		this.soc0118BL = entityItemBL;
	}
	/**
	 * @param quartzJobsBL the quartzJobsBL to set
	 */
	public void setQuartzJobsBL(QuartzJobsBL quartzJobsBL) {
		this.quartzJobsBL = quartzJobsBL;
	}

	public void setCodeListUtils(CodeListUtils codeListUtils) {
		this.codeListUtils = codeListUtils;
	}
	public void setCollect_Symmetrix_InfoBL(
			Collect_Symmetrix_InfoBL collect_Symmetrix_InfoBL) {
		this.collect_Symmetrix_InfoBL = collect_Symmetrix_InfoBL;
	}
	public void setCollect_Symmetrix_Monitor_RtBL(
			Collect_Symmetrix_Monitor_RtBL collect_Symmetrix_Monitor_RtBL) {
		this.collect_Symmetrix_Monitor_RtBL = collect_Symmetrix_Monitor_RtBL;
	}
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	/**
	 * ����: ��ά������ʾ
	 * @param  IGDBS01DTO dto
	 * @return ��ά����xml����
	 * @throws BLException
	 */
	public IGDBS01DTO getOperationManagement(IGDBS01DTO dto) throws BLException {
		Date paramDate = new Date(); // Ĭ��ȡ��ϵͳʱ��
		String turnPageFlag = ""; // ��ҳ��־
		SimpleDateFormat formatterYearMonth = null;
		if (dto.getLanguage()!=null && "en".equals(dto.getLanguage())) {
			formatterYearMonth = new SimpleDateFormat("yyyy-MM");			
		}else{
		    formatterYearMonth = new SimpleDateFormat("yyyy �� MM �� ");		 
		}
		   SimpleDateFormat formatterDay = new SimpleDateFormat("dd");
		    SimpleDateFormat formatterYMD = new SimpleDateFormat("yyyyMMdd");
		    SimpleDateFormat sformatterYMD = new SimpleDateFormat("yyyy/MM/dd");
		    Calendar c = Calendar.getInstance();
		String valueOfDate = dto.getValueOfDate();// ȡ�ô������ڲ���

		try {
			// ������ʽΪ'next|yyyyMMdd'�����ݣ�backΪ��ǰ��ҳ��nextΪ���ҳ
			if (valueOfDate != null && !"".equals(valueOfDate)) {
				int location = valueOfDate.indexOf("|");
				// ȡ�÷�ҳ��ʽ
				turnPageFlag = valueOfDate.substring(0, location);
				// ȡ�÷�ҳ�ύ������
				paramDate = formatterYMD.parse(valueOfDate
						.substring(location + 1));
				// �����ҳ�򽫵�ǰʱ������Ϊ�ύʱ��
				c.setTime(paramDate);
			}

			if ("".equals(turnPageFlag)) {// ������ʼ�������ȡ�ñ��ܵ�һ��
				int dayofweek = c.get(Calendar.DAY_OF_WEEK);
				c.add(Calendar.DATE, 1 - dayofweek);

			} else if ("back".equals(turnPageFlag)) {// ������ǰ�������ȡ�����ܵ�һ��
				c.add(Calendar.DATE, -8);
			}
			// xmlƴ��
			String content = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><ROOT>";

			// ��ά�ƻ���ѯ����
			QuartzJobsSearchCondImpl cond = new QuartzJobsSearchCondImpl();
			// ��ѯ�������վ��еļƻ�������ƴ��xml
			for (int i = 1; i <= 7; i++) {
				c.add(Calendar.DATE, 1);
				sformatterYMD.format(c.getTime());
				// ��ѯ�յĿ�ʼʱ��
				cond.setDate_q(sformatterYMD.format(c.getTime()) + " 00:00");
				
				//�ͻ���ά��Ա�ɼ�ȫ����ά����
				boolean flag = true;//�Ƿ�����û�Ȩ��У��
				String customer_role_id = ResourceUtility.getString("CUSTOMERROLEID");
				if(StringUtils.isNotEmpty(customer_role_id)){
					if(userRoleBL.isRoleInUserRole(dto.getUser().getUserid(),Integer.valueOf(customer_role_id))){
						flag = false;
					}
				}
				
				//��ǰ�û�Ϊ�ͻ���ά��Ա�򲻽����û�У�飬�ɼ�ȫ����ά�ƻ�����
				if(flag){
					cond.setUserid(dto.getUser().getUserid());
				}
				
				
				// ��ѯ�յĽ���ʱ��
				cond.setDate_j(sformatterYMD.format(c.getTime()) + " 23:59");
				// ��ѯ�յ���ά����ȡ��
				List<QuartzJobsDetail> quartzJobsList = quartzJobsBL
						.getQuartzJobsByUserDate(cond, 0, 3);

				content = content + "<dateroot yearmonth= \""
						+ formatterYearMonth.format(c.getTime()) + "\""
						+ " day=\"" + formatterDay.format(c.getTime()) + "\"";
				String week = getWeekStr(i);
				if (dto.getLanguage()!=null && "en".equals(dto.getLanguage())) {
					week = getWeekStr_EN(i);
				}
				// �������������������ɫ��Ϊ��ɫ,������Ϊ��ɫ
				if ("������".equals(week) || "������".equals(week) ||
					"Saturday".equals(week) || "Sunday".equals(week)) {
					content = content + " color=\"2\"";
				} else {
					content = content + " color=\"1\"";
				}
				// ��ʼ����ʾ��ά����
				// ������ά�������
				if (null != quartzJobsList && quartzJobsList.size() > 0) {
					content = content + " week=\"" + week + "\""
							+ " url=\"IGSDL0110.do?date="
							+ sformatterYMD.format(c.getTime()) + "\""
							+ " amount=\"4\"" + " returnValue=\""
							+ formatterYMD.format(c.getTime()) + "\">";
					for (int j = 0; j < quartzJobsList.size(); j++) {
						content = content + " <cplan color=\"1\">" + (j + 1)
								+ "." + quartzJobsList.get(j).getQjname()
								+ "</cplan>";
					}
					// ������������������ʱ�ٵĲ���xmlƴ����Ϊ��
					for (int j = 0; j < 3 - quartzJobsList.size(); j++) {
						content = content + " <cplan color=\"1\"></cplan>";
					}
				} else {
					// ��������ά�ƻ����
					content = content + " week=\"" + week + "\""
							+ " amount=\"4\"" + " returnValue=\""
							+ formatterYMD.format(c.getTime()) + "\">";
					for (int j = 0; j < 3; j++) {
						content = content + " <cplan color=\"1\"></cplan>";
					}
				}
				content = content + " </dateroot>";

			}
			// ��������־
			content = content + "</ROOT>";
			// ���÷���xmlֵ
			dto.setOperationManagement(content);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return dto;
	}
	
	/**
	 * ����: ҵ���������
	 * @param  IGDBS01DTO dto
	 * @return ҵ����������
	 * @throws BLException
	 */
	public IGDBS01DTO getBusinessRus(IGDBS01DTO dto) throws BLException{
		
		//��ȡҪ��ص�Ӧ���ʲ�  �Ƕ��嵽codeDetail�е�
		//List<LabelValueBean> appList = codeListUtils.getCodeList(CodeDefine.getCodeDefine("BUSINESSRUN_ENTITYITEM").getCcid(), null, null, false, false);
		CodeDetailSearchCondImpl cdcond = new CodeDetailSearchCondImpl();
	    cdcond.setCcid(CodeDefine.getCodeDefine("BUSINESSRUN_ENTITYITEM").getCcid());
	    cdcond.setCdstatus("1");
	    List<CodeDetail> appList = this.codeDetailBL.searchCodeDetail(cdcond, 1);
	    IG500SearchCondImpl prCond = new IG500SearchCondImpl();
		prCond.setPrpdid("1011");//����
		prCond.setPrActive("Y");//δ�ر�
		prCond.setPrtype("ID");//�Զ����¼�
		//���δ�رյ��Զ�������¼�
		List<IG500Info>  prList = ig500BL.searchIG500Info(prCond);	
		
		String content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
	
		//��¼�й��ϵ�Ӧ��
		//List<Integer> redent = new ArrayList<Integer>();
		Map<String,String> app_map = new HashMap<String,String>();	 	
		//��ѯӦ���Ƿ��ܵ�����Ӱ��
		//��ѭ��Ӧ��
		for(int j=0,n=appList.size();j<n;j++){
			CodeDetail lvbBean = (CodeDetail)appList.get(j);
			String ename = lvbBean.getCvalue();
			Integer eiid = Integer.valueOf(0);
			//ͨ�������ҵ�������EntityItem
			SOC0118SearchCondImpl itemRelation = new SOC0118SearchCondImpl();
			itemRelation.setEiname_equal(ename);
			List<SOC0118Info> EntityItemList = soc0118BL.searchEntityItem(itemRelation);
			if (EntityItemList.size()>0) {
				SOC0118Info entityItem = EntityItemList.get(0);
				eiid = entityItem.getEiid();
					
			//��ѭ�������¼�
			for(int i=0,m=prList.size();i<m;i++){
				IG500Info precord = prList.get(i);
				
				//���������ʲ����ձ����Ƿ���Ӱ���Ӧ�õ��ʲ���¼����	
				IG731SearchCondImpl piecond = new IG731SearchCondImpl();
				//������ʲ�Ӱ����ʲ�
//				piecond.setPietype("1");
				piecond.setPrid(precord.getPrid());
				piecond.setEiid(eiid);
				List<IG731Info> pieList= ig731BL.searchIG731Info(piecond);
			

				if(pieList!=null && pieList.size()>0){
					//�ж��¼������һ����ϻ����ش����
					String faultType = "";
					List<IG599Info> processInfolist = workFlowOperationBL.getProcessInfo(precord.getPrid());
					for(IG599Info pi:processInfolist){
						//�ж��Ƿ�Ϊ�¼�������
						if("1006".equals(pi.getPidid())){
							faultType = pi.getPivarvalue();
							break;
						}
					}
					
					//��װ�����¼��б�
					if(StringUtils.isNotEmpty(faultType)){
						content = content+"<item ename='"+ ename +"' prid='"+ precord.getPrid() +"' sn='"+ precord.getPrserialnum() +
									"' title='"+ precord.getPrtitle() +"' level='"+ faultType +"' />";
					}
					
					
					
					//����Ӱ���Ӧ�õ��¼�����ID���¼����,���ȱ����ش���ϵ��¼�
					if(app_map.get(ename)!=null){
						String level = app_map.get(ename).split("_")[1];
						if(StringUtils.isNotEmpty(faultType)){
							if(("һ�����".equals(level) || "general failure".equals(level.toLowerCase())) &&
									("�ش����".equals(faultType) || "major failure".equals(faultType.toLowerCase()))){
								app_map.put(ename, String.valueOf(precord.getPrid())+"_"+faultType);
							}
						}
						
					}else{
						if(StringUtils.isNotEmpty(faultType)){
							app_map.put(ename, String.valueOf(precord.getPrid())+"_"+faultType);
						}
					}
					
				}
			}	
		}
		}

		
		//��������ش����Ӱ���Ӧ��
		for(int j=0,i=appList.size();j<i;j++){
			CodeDetail lvbBean = (CodeDetail)appList.get(j);
			String ename = lvbBean.getCvalue();
			if(app_map.get(ename)!=null){
				String prid = app_map.get(ename).split("_")[0];
				String level = app_map.get(ename).split("_")[1];
				if("�ش����".equals(level) || "major failure".equals(level.toLowerCase())){
					content = content+"<HOST color='3' href='"+prid+"'>" + ename + "</HOST>";
				}
			}
		}
		//�������һ�����Ӱ���Ӧ��
		for(int j=0,i=appList.size();j<i;j++){
			CodeDetail lvbBean = (CodeDetail)appList.get(j);
			String ename = lvbBean.getCvalue();
			if(app_map.get(ename)!=null){
				String prid = app_map.get(ename).split("_")[0];
				String level = app_map.get(ename).split("_")[1];
				if("һ�����".equals(level) || "general failure".equals(level.toLowerCase())){
					content = content+"<HOST color='2' href='"+prid+"'>" + ename + "</HOST>";
				}
			}
		}
		//������������Ӧ��
		for(int j=0,i=appList.size();j<i;j++){
			CodeDetail lvbBean = (CodeDetail)appList.get(j);
			String ename = lvbBean.getCvalue();
			if(app_map.get(ename)==null){
				content = content+"<HOST color='1' href='null'>" + ename + "</HOST>";
			}
			
		}
		
		
		
		
	    content = content+"</ROOT>";
	    System.out.println("---"+content);
	    dto.setBusinessRus(content);
		return dto;
	}
	
	/**
	 * ����:�����͵����ֱ�ɺ��ֵ�����
	 * @param int dayofweek
	 * @return ����X
	 * @throws BLException
	 */
	private  String getWeekStr(int dayofweek){   
		  String week = "";   
		  switch ( dayofweek )
			{
				case 1:
					 week = "����һ"; 
					break;
				case 2:
					 week = "���ڶ�"; 
					break;
				case 3:
					 week = "������"; 
					break;
				case 4:
					 week = "������"; 
					break;
				case 5:
					 week = "������"; 
					break;
				case 6:
					 week = "������"; 
					break;
				case 7:
					 week = "������"; 
					break;
			}		
		 
		  return week;   
		 } 
	/**
	 * ����:�����͵����ֱ�ɺ��ֵ�����
	 * @param int dayofweek
	 * @return ����X
	 * @throws BLException
	 */
	private  String getWeekStr_EN(int dayofweek){   
		  String week = "";   
		  switch ( dayofweek )
			{
				case 1:
					 week = "Monday"; 
					break;
				case 2:
					 week = "Tuesday"; 
					break;
				case 3:
					 week = "Wednesday"; 
					break;
				case 4:
					 week = "Thursday"; 
					break;
				case 5:
					 week = "Friday"; 
					break;
				case 6:
					 week = "Saturday"; 
					break;
				case 7:
					 week = "Sunday"; 
					break;
			}		
		 
		  return week;   
		 } 
	/**
	 * ����: ����KPI
	 * @param  IGDBS01DTO dto
	 * @return ����KPI
	 * @throws BLException
	 */
//	public IGDBS01DTO getProcessKPI(IGDBS01DTO dto) throws BLException{
//		
//		IG500SearchCondImpl cond = new IG500SearchCondImpl();
//		
//		//�Զ����¼�
//		cond.setPrtype("ID");
//		String today = IGStringUtils.getCurrentDate();
//		String year = today.split("/")[0];
//		String month = today.split("/")[1];
//		System.out.println(today);
//		cond.setPropentime(year+"/"+month+"/"+"01 00:00");
//		cond.setPrclosetime(year+"/"+month+"/"+"31 00:00");
//		int countID = ig500BL.getProcessRecordVWSearchCount(cond);
//		
//		//�Զ�����
//		cond.setPrtype("CD");
//		cond.setPropentime(year+"/"+month+"/"+"01 00:00");
//		cond.setPrclosetime(year+"/"+month+"/"+"31 00:00");
//		int countCD = ig500BL.getProcessRecordVWSearchCount(cond);
//		
//		//���˹���
//		cond.setPrtype("WB");
//		cond.setPropentime(year+"/"+month+"/"+"01 00:00");
//		cond.setPrclosetime(year+"/"+month+"/"+"31 00:00");
//		int countWB = ig500BL.getProcessRecordVWSearchCount(cond);
//		
//		//ָ�ɹ���
//		cond.setPrtype("WA");
//		cond.setPropentime(year+"/"+month+"/"+"01 00:00");
//		cond.setPrclosetime(year+"/"+month+"/"+"31 00:00");
//		int countWA = ig500BL.getProcessRecordVWSearchCount(cond);
//		
//		//�ѹر��¼�
//		cond.setPrtype("ID");
//		cond.setPropentime(year+"/"+month+"/"+"01 00:00");
//		cond.setPrclosetime(year+"/"+month+"/"+"31 00:00");
//		cond.setPrstatus("C");
//		int countIDClosed = ig500BL.getProcessRecordVWSearchCount(cond);
//		
//		//�ѹرձ��
//		cond.setPrtype("CD");
//		cond.setPropentime(year+"/"+month+"/"+"01 00:00");
//		cond.setPrclosetime(year+"/"+month+"/"+"31 00:00");
//		cond.setPrstatus("C");
//		int countCDClosed = ig500BL.getProcessRecordVWSearchCount(cond);
//		
//		//�ѹرո��˹���
//		cond.setPrtype("WB");
//		cond.setPropentime(year+"/"+month+"/"+"01 00:00");
//		cond.setPrclosetime(year+"/"+month+"/"+"31 00:00");
//		cond.setPrstatus("C");
//		int countWBClosed = ig500BL.getProcessRecordVWSearchCount(cond);
//		
//		//�ѹر�ָ�ɹ���
//		cond.setPrtype("WA");
//		cond.setPropentime(year+"/"+month+"/"+"01 00:00");
//		cond.setPrclosetime(year+"/"+month+"/"+"31 00:00");
//		cond.setPrstatus("C");
//		int countWAClosed = ig500BL.getProcessRecordVWSearchCount(cond);
//			
//		int countIDOpen = countID-countIDClosed;
//		int countCDOpen = countCD-countCDClosed;
//		int countW = countWA+countWB-countWAClosed-countWBClosed;
//		dto.setProcessKPI(countID+";"+countCD+";"+countIDOpen+";"+countCDOpen+";"+countW);
//				
//		return dto;
//	}
	
	/**
	 * ����: IOPS/������
	 * @param  IGDBS01DTO dto
	 * @return IOPS/������
	 * @update baiyanfu_20120301_��ҳDashBoard��ֵ��ʾ
	 * @throws BLException
	 */
	@SuppressWarnings("deprecation")
	public IGDBS01DTO  getIOPSandThroughput1(IGDBS01DTO dto) throws BLException{
		
		String symmid = dto.getSymmid();//��ǰѡ�����к�
		String hostchoose = dto.getHostchoose();//����ѡ��������ѡ��
		
		String content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
		String mmvalue = "";				//��װy�����ֵ��Сֵ
		String bottom = "<BOTTOM>";			//x��̶�
		String time ="<TIME>";              //��ʾ��ʱ��
		String iops = "<LEFTLINE>";		//iops��ֵ
		String throughput = "<RIGHTLINE>";	//��������ֵ
		String type="<TYPE></TYPE>";//�洢����
		String flag="<FLAG>false</FLAG>";	//�Ƿ���ʾ��ֵ�߱�ʶ
		String flagValue="<FLAGVALUE></FLAGVALUE>";	//��ֵ
		String flagOne="<FLAGONE>false</FLAGONE>";	//�Ƿ���ʾ��ֵ�߱�ʶ
		String flagValueOne="<FLAGVALUEONE></FLAGVALUEONE>";//��ֵ
		boolean isFlag=false;
		boolean isFlagOne=false;
		//������ǵ�һ�ν���dashboard
		if(StringUtils.isNotEmpty(symmid)){

			Collect_Symmetrix_InfoSearchCondImpl infoCond = new Collect_Symmetrix_InfoSearchCondImpl();
			String[] symm_type={"IBM","DMX","CX"};
			infoCond.setSymm_typeStr(symm_type);
			List<Collect_Symmetrix_Info> csiList = collect_Symmetrix_InfoBL.findCollect_Symmetrix_InfoByCond(infoCond, 0, 0);
			
			int c=0;
			
			if("0".equals(hostchoose)){
				for(int i=0;i<csiList.size();i++){
					if(csiList.get(i).getSymm_id().equals(symmid)){
						c--;
						break;
					}
					c++;
				}
			}
			if("1".equals(hostchoose)){
				for(int i=0;i<csiList.size();i++){
					if(csiList.get(i).getSymm_id().equals(symmid)){
						c++;
						break;
					}
					c++;
				}
			}
		
			
			Collect_Symmetrix_Monitor_RtSearchCondImpl rtCond = new Collect_Symmetrix_Monitor_RtSearchCondImpl();
			//CXʵʱ���ܲ�ѯ
			if("CX".equalsIgnoreCase(csiList.get(c).getSymm_type())){
				type="<TYPE>CX</TYPE>";
				dto.setSymm_type(csiList.get(c).getSymm_type());
				rtCond.setSymm_id(csiList.get(c).getSymm_id()+"_SP A");
			}else{
				rtCond.setSymm_id(csiList.get(c).getSymm_id());
			}
			List<Collect_Symmetrix_Monitor_RtVWInfo> csmrList = getCollect_Symmetrix_Monitor_RtInfo(rtCond,csiList.get(c).getSymm_type());
			//���ݽ��������ƻ�ȡ��ֵ��Ϣ
			MonitorObjectDefVWSearchCondImpl moCond=new MonitorObjectDefVWSearchCondImpl();
			moCond.setMoName(csiList.get(c).getSymm_id());
			moCond.setDeleteFlag("0");
			List<MonitorObjectDefVWInfo> monitorObjectDefVWInfoList=this.monitorObjectDefVWBL.searchMonitorObjectDefVW(moCond);
			long rmax = 0l;
			long rmin = 0l;
			long lmax = 0l;
			long lmin = 0l;
			int bv = new Date().getHours()-1;
			for(int i=0;i<csmrList.size();i++){
				Collect_Symmetrix_Monitor_RtVWInfo csmr = csmrList.get(i);
				if(rmin>csmr.getSymiops().longValue()){
					rmin = csmr.getSymiops().longValue();
				}
				if(rmax<csmr.getSymiops().longValue()){
					rmax = csmr.getSymiops().longValue();
				}
				if(lmin>csmr.getSymthroughput().longValue()){
					lmin = csmr.getSymthroughput().longValue();
				}
				if(lmax<csmr.getSymthroughput().longValue()){
					lmax = csmr.getSymthroughput().longValue();
				}
				//�ж��Ƿ���ʾ��ֵ��
				if(monitorObjectDefVWInfoList!=null&&monitorObjectDefVWInfoList.size()>0){
					for(MonitorObjectDefVWInfo info:monitorObjectDefVWInfoList){
						//�ж��Ƿ��Ѿ���ʾ��ֵ��
						if(!isFlag){
							if(info.getOrderNumber()==1){
								if(">=".equals(info.getCompare())){
									if(csmr.getSymiops().longValue()>=Long.parseLong(info.getModValue())){
										isFlag=true;
										flag = "<FLAG>true</FLAG>";
										flagValue = "<FLAGVALUE>"+info.getModValue()+"</FLAGVALUE>";
									}
								}
								if("<=".equals(info.getCompare())){
									if(csmr.getSymiops().longValue()<=Long.parseLong(info.getModValue())){
										isFlag=true;
										flag = "<FLAG>true</FLAG>";
										flagValue = "<FLAGVALUE>"+info.getModValue()+"</FLAGVALUE>";
									}
								}
							}
						}
						//�ж��Ƿ��Ѿ���ʾ��ֵ��
						if(!isFlagOne){
							if(info.getOrderNumber()==2){
								if(">=".equals(info.getCompare())){
									if(csmr.getSymthroughput().longValue()>=Long.parseLong(info.getModValue())){
										isFlagOne=true;
										flagOne= "<FLAGONE>true</FLAGONE>";
										flagValueOne = "<FLAGVALUEONE>"+info.getModValue()+"</FLAGVALUEONE>";
									}
								}
								if("<=".equals(info.getCompare())){
									if(csmr.getSymthroughput().longValue()<=Long.parseLong(info.getModValue())){
										isFlagOne=true;
										flagOne = "<FLAGONE>true</FLAGONE>";
										flagValueOne = "<FLAGVALUEONE>"+info.getModValue()+"</FLAGVALUEONE>";
									}
								}
							}
						}
					}
				}
				bv = Integer.valueOf(csmr.getSymtime());
				bottom = bottom+"<value>" + csmr.getSymtime() + "</value>";
				time = time + "<value>" + csmr.getFulltime() + "</value>";
				iops = iops+"<value>" + csmr.getSymiops() + "</value>";
				throughput = throughput+"<value>" + csmr.getSymthroughput() + "</value>";
			}
			//��С��8����ʱ
			int m = 8-csmrList.size();	
			for (int i = 0; i < m; i++) {
				bv = (++bv)%24;
				bottom = bv<10 ? bottom+"<value>" + "0"+bv + "</value>" :bottom+"<value>" + bv + "</value>";
				time = time + "<value></value>";
				iops = iops+"<value></value>";
				throughput = throughput+"<value></value>";
			}	
			//��ѯ���������Ϣ
			CodeDetailSearchCondImpl cdcond = new CodeDetailSearchCondImpl();
			cdcond.setCvalue(csiList.get(c).getSymm_id());
			cdcond.setCdstatus("1");
			List<CodeDetail> cdList = codeDetailBL.searchCodeDetail(cdcond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
			if(cdList!=null&&cdList.size()>0){
				CodeDetail codeDetail = cdList.get(0);
				String hostid = codeDetail.getCcid()+"_"+codeDetail.getCid()+"_"+codeDetail.getSyscoding();
				content = content+"<REPORT>" + hostid+"|"+csiList.get(c).getSymm_type() + "</REPORT>";
			}else{
				content = content+"<REPORT>" + "false" + "</REPORT>";
			}
			content = content+"<HOST color='#000000'>" + csiList.get(c).getSymm_id() + "</HOST>";
			
			//������Y�����ֵ
			int n=0;
			while(rmax/new Double(Math.pow(10, n)).longValue()>100){
				n++;
			}
			rmax = (rmax/new Double(Math.pow(10, n)).longValue()+1)*new Double(Math.pow(10, n)).longValue();
			//������Y�����ֵ
			n=0;
			while(lmax/new Double(Math.pow(10, n)).longValue()>100){
				n++;
			}
			lmax = (lmax/new Double(Math.pow(10, n)).longValue()+1)*new Double(Math.pow(10, n)).longValue();
			//������Y����Сֵ
			n=0;
			while(rmin/new Double(Math.pow(10, n)).longValue()>10){
				n++;
			}
			rmin = (rmin/new Double(Math.pow(10, n)).longValue())*new Double(Math.pow(10, n)).longValue();
			//������Y����Сֵ
			n=0;
			while(lmin/new Double(Math.pow(10, n)).longValue()>10){
				n++;
			}
			lmin = (lmin/new Double(Math.pow(10, n)).longValue())*new Double(Math.pow(10, n)).longValue();
			
			mmvalue = mmvalue+"<RIGHTMAXVALUE>" + lmax + "</RIGHTMAXVALUE>";
			mmvalue = mmvalue+"<RIGHTMINVALUE>" + lmin + "</RIGHTMINVALUE>";
			mmvalue = mmvalue+"<LEFTMAXVALUE>" + rmax + "</LEFTMAXVALUE>";
			mmvalue = mmvalue+"<LEFTMINVALUE>" + rmin + "</LEFTMINVALUE>";	

			bv = (++bv)%24;
			if(bv<10){
				bottom = bottom+"<value>" + "0"+bv + "</value>";
			}else{
				bottom = bottom+"<value>" + bv + "</value>";
			}
			bv = (++bv)%24;
			if(bv<10){
				bottom = bottom+"<value>" + "0"+bv + "</value>";
			}else{
				bottom = bottom+"<value>" + bv + "</value>";
			}
			bottom = bottom+"</BOTTOM>";
			time = time + "</TIME>";
			iops = iops+"</LEFTLINE>";		
			throughput = throughput+"</RIGHTLINE>";	
		}
		//������״ν���dashboard
		else{
			Collect_Symmetrix_InfoSearchCondImpl infoCond = new Collect_Symmetrix_InfoSearchCondImpl();
			String[] symm_type={"IBM","DMX","CX"};
			infoCond.setSymm_typeStr(symm_type);
			List<Collect_Symmetrix_Info> csiList = collect_Symmetrix_InfoBL.findCollect_Symmetrix_InfoByCond(infoCond, 0, 0);
			if (csiList.size()>0) {
				
				Collect_Symmetrix_Monitor_RtSearchCondImpl rtCond = new Collect_Symmetrix_Monitor_RtSearchCondImpl();
				//CXʵʱ���ܲ�ѯ
				if("CX".equalsIgnoreCase(csiList.get(0).getSymm_type())){
					type="<TYPE>CX</TYPE>";
					dto.setSymm_type(csiList.get(0).getSymm_type());
					rtCond.setSymm_id(csiList.get(0).getSymm_id()+"_SP A");
				}else{
					rtCond.setSymm_id(csiList.get(0).getSymm_id());
				}
				List<Collect_Symmetrix_Monitor_RtVWInfo> csmrList = getCollect_Symmetrix_Monitor_RtInfo(rtCond,csiList.get(0).getSymm_type());
				//���ݽ��������ƻ�ȡ��ֵ��Ϣ
				MonitorObjectDefVWSearchCondImpl moCond=new MonitorObjectDefVWSearchCondImpl();
				moCond.setMoName(csiList.get(0).getSymm_id());
				moCond.setDeleteFlag("0");
				List<MonitorObjectDefVWInfo> monitorObjectDefVWInfoList=this.monitorObjectDefVWBL.searchMonitorObjectDefVW(moCond);
				long rmax = 0l;
				long rmin = 0l;
				long lmax = 0l;
				long lmin = 0l;
				int bv = new Date().getHours()-1;
				for(int i=0;i<csmrList.size();i++){
					Collect_Symmetrix_Monitor_RtVWInfo csmr = csmrList.get(i);
					if(rmin>csmr.getSymiops().longValue()){
						rmin = csmr.getSymiops().longValue();
					}
					if(rmax<csmr.getSymiops().longValue()){
						rmax = csmr.getSymiops().longValue();
					}
					if(lmin>csmr.getSymthroughput().longValue()){
						lmin = csmr.getSymthroughput().longValue();
					}
					if(lmax<csmr.getSymthroughput().longValue()){
						lmax = csmr.getSymthroughput().longValue();
					}
					//�ж��Ƿ���ʾ��ֵ��
					if(monitorObjectDefVWInfoList!=null&&monitorObjectDefVWInfoList.size()>0){
						for(MonitorObjectDefVWInfo info:monitorObjectDefVWInfoList){
							//�ж��Ƿ��Ѿ���ʾ��ֵ��
							if(!isFlag){
								if(info.getOrderNumber()==1){
									if(">=".equals(info.getCompare())){
										if(csmr.getSymiops().longValue()>=Long.parseLong(info.getModValue())){
											isFlag=true;
											flag = "<FLAG>true</FLAG>";
											flagValue = "<FLAGVALUE>"+info.getModValue()+"</FLAGVALUE>";
										}
									}
									if("<=".equals(info.getCompare())){
										if(csmr.getSymiops().longValue()<=Long.parseLong(info.getModValue())){
											isFlag=true;
											flag = "<FLAG>true</FLAG>";
											flagValue = "<FLAGVALUE>"+info.getModValue()+"</FLAGVALUE>";
										}
									}
								}
							}
							//�ж��Ƿ��Ѿ���ʾ��ֵ��
							if(!isFlagOne){
								if(info.getOrderNumber()==2){
									if(">=".equals(info.getCompare())){
										if(csmr.getSymthroughput().longValue()>=Long.parseLong(info.getModValue())){
											isFlagOne=true;
											flagOne= "<FLAGONE>true</FLAGONE>";
											flagValueOne = "<FLAGVALUEONE>"+info.getModValue()+"</FLAGVALUEONE>";
										}
									}
									if("<=".equals(info.getCompare())){
										if(csmr.getSymthroughput().longValue()<=Long.parseLong(info.getModValue())){
											isFlagOne=true;
											flagOne = "<FLAGONE>true</FLAGONE>";
											flagValueOne = "<FLAGVALUEONE>"+info.getModValue()+"</FLAGVALUEONE>";
										}
									}
								}
							}
						}
					}
					bv = Integer.valueOf(csmr.getSymtime());
					bottom = bottom+"<value>" + csmr.getSymtime() + "</value>";
					time = time + "<value>" + csmr.getFulltime() + "</value>";
					iops = iops+"<value>" + csmr.getSymiops() + "</value>";
					throughput = throughput+"<value>" + csmr.getSymthroughput() + "</value>";
				}
				//��С��8����ʱ
				int m = 8-csmrList.size();
				for (int i = 0; i < m; i++) {
					bv = (++bv)%24;
					bottom = bv<10 ? bottom+"<value>" + "0"+bv + "</value>" :bottom+"<value>" + bv + "</value>";
					time = time + "<value></value>";
					iops = iops+"<value></value>";
					throughput = throughput+"<value></value>";
				}	
				//��ѯ���������Ϣ
				CodeDetailSearchCondImpl cdcond = new CodeDetailSearchCondImpl();
				cdcond.setCvalue(csiList.get(0).getSymm_id());
				cdcond.setCdstatus("1");
				List<CodeDetail> cdList = codeDetailBL.searchCodeDetail(cdcond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
				if(cdList!=null&&cdList.size()>0){
					CodeDetail codeDetail = cdList.get(0);
					String hostid = codeDetail.getCcid()+"_"+codeDetail.getCid()+"_"+codeDetail.getSyscoding();
					content = content+"<REPORT>" + hostid +"|"+csiList.get(0).getSymm_type()+ "</REPORT>";
				}else{
					content = content+"<REPORT>" + "false" + "</REPORT>";
				}
				content = content+"<HOST color='#000000'>" + csiList.get(0).getSymm_id() + "</HOST>";
				//������Y�����ֵ
				int n=0;
				while(rmax/new Double(Math.pow(10, n)).longValue()>100){
					n++;
				}
				rmax = (rmax/new Double(Math.pow(10, n)).longValue()+1)*new Double(Math.pow(10, n)).longValue();
				//������Y�����ֵ
				n=0;
				while(lmax/new Double(Math.pow(10, n)).longValue()>100){
					n++;
				}
				lmax = (lmax/new Double(Math.pow(10, n)).longValue()+1)*new Double(Math.pow(10, n)).longValue();
				//������Y����Сֵ
				n=0;
				while(rmin/new Double(Math.pow(10, n)).longValue()>10){
					n++;
				}
				rmin = (rmin/new Double(Math.pow(10, n)).longValue())*new Double(Math.pow(10, n)).longValue();
				//������Y����Сֵ
				n=0;
				while(lmin/new Double(Math.pow(10, n)).longValue()>10){
					n++;
				}
				lmin = (lmin/new Double(Math.pow(10, n)).longValue())*new Double(Math.pow(10, n)).longValue();
				
				mmvalue = mmvalue+"<RIGHTMAXVALUE>" + lmax + "</RIGHTMAXVALUE>";
				mmvalue = mmvalue+"<RIGHTMINVALUE>" + lmin + "</RIGHTMINVALUE>";
				mmvalue = mmvalue+"<LEFTMAXVALUE>" + rmax + "</LEFTMAXVALUE>";
				mmvalue = mmvalue+"<LEFTMINVALUE>" + rmin + "</LEFTMINVALUE>";	

				bv = (++bv)%24;
				if(bv<10){
					bottom = bottom+"<value>" + "0"+bv + "</value>";
				}else{
					bottom = bottom+"<value>" + bv + "</value>";
				}
				bv = (++bv)%24;
				if(bv<10){
					bottom = bottom+"<value>" + "0"+bv + "</value>";
				}else{
					bottom = bottom+"<value>" + bv + "</value>";
				}
			}//�ж������Ƿ�Ϊ�ս���
			 else{
				 //Ϊ��ʱ���ܵ�
				 content = content+"<REPORT>" + "false" + "</REPORT>";
			}
			bottom = bottom+"</BOTTOM>";	
			time = time + "</TIME>";
			iops = iops+"</LEFTLINE>";		
			throughput = throughput+"</RIGHTLINE>";	
		}
		content = content+type;
		content = content+flag;
		content = content+flagValue;
		content = content+flagOne;
		content = content+flagValueOne;
		content = content+mmvalue;
		content = content+bottom;
		content = content+time;
		content = content+iops;
		content = content+throughput;
		content = content+"</ROOT>";
		
		dto.setIopsThroughput(content);
		
		return dto;
	}
	
	/**
	 * ����: IOPS/������
	 * @param  IGDBS01DTO dto
	 * @return IOPS/������
	 * @update baiyanfu_20120301_��ҳDashBoard��ֵ��ʾ
	 * @throws BLException
	 */
	@SuppressWarnings("deprecation")
	public IGDBS01DTO  getIOPSandThroughputCX(IGDBS01DTO dto) throws BLException{
		
		String symmid = dto.getSymmid();//��ǰѡ�����к�
		String hostchoose = dto.getHostchoose();//����ѡ��������ѡ��
		
		String content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
		String mmvalue = "";				//��װy�����ֵ��Сֵ
		String bottom = "<BOTTOM>";			//x��̶�
		String time ="<TIME>";              //��ʾ��ʱ��
		String iops = "<LEFTLINE>";		//iops��ֵ
		String throughput = "<RIGHTLINE>";	//��������ֵ
		String type="<TYPE></TYPE>";//�洢����
		String flag="<FLAG>false</FLAG>";	//�Ƿ���ʾ��ֵ�߱�ʶ
		String flagValue="<FLAGVALUE></FLAGVALUE>";	//��ֵ
		String flagOne="<FLAGONE>false</FLAGONE>";	//�Ƿ���ʾ��ֵ�߱�ʶ
		String flagValueOne="<FLAGVALUEONE></FLAGVALUEONE>";//��ֵ
		boolean isFlag=false;
		boolean isFlagOne=false;
		//������ǵ�һ�ν���dashboard
		if(StringUtils.isNotEmpty(symmid)){

			Collect_Symmetrix_InfoSearchCondImpl infoCond = new Collect_Symmetrix_InfoSearchCondImpl();
			String[] symm_type={"IBM","DMX","CX"};
			infoCond.setSymm_typeStr(symm_type);
			List<Collect_Symmetrix_Info> csiList = collect_Symmetrix_InfoBL.findCollect_Symmetrix_InfoByCond(infoCond, 0, 0);
			
			int c=0;
			
			if("0".equals(hostchoose)){
				for(int i=0;i<csiList.size();i++){
					if(csiList.get(i).getSymm_id().equals(symmid)){
						c--;
						break;
					}
					c++;
				}
			}
			if("1".equals(hostchoose)){
				for(int i=0;i<csiList.size();i++){
					if(csiList.get(i).getSymm_id().equals(symmid)){
						c++;
						break;
					}
					c++;
				}
			}
		
			
			Collect_Symmetrix_Monitor_RtSearchCondImpl rtCond = new Collect_Symmetrix_Monitor_RtSearchCondImpl();
			//CXʵʱ���ܲ�ѯ
			if("CX".equalsIgnoreCase(csiList.get(c).getSymm_type())){
				type="<TYPE>CX</TYPE>";
				dto.setSymm_type(csiList.get(c).getSymm_type());
				rtCond.setSymm_id(csiList.get(c).getSymm_id()+"_SP B");
			}else{
				rtCond.setSymm_id(csiList.get(c).getSymm_id());
			}
			List<Collect_Symmetrix_Monitor_RtVWInfo> csmrList = getCollect_Symmetrix_Monitor_RtInfo(rtCond,csiList.get(c).getSymm_type());
			//���ݽ��������ƻ�ȡ��ֵ��Ϣ
			MonitorObjectDefVWSearchCondImpl moCond=new MonitorObjectDefVWSearchCondImpl();
			moCond.setMoName(csiList.get(c).getSymm_id());
			moCond.setDeleteFlag("0");
			List<MonitorObjectDefVWInfo> monitorObjectDefVWInfoList=this.monitorObjectDefVWBL.searchMonitorObjectDefVW(moCond);
			long rmax = 0l;
			long rmin = 0l;
			long lmax = 0l;
			long lmin = 0l;
			int bv = new Date().getHours()-1;
			for(int i=0;i<csmrList.size();i++){
				Collect_Symmetrix_Monitor_RtVWInfo csmr = csmrList.get(i);
				if(rmin>csmr.getSymiops().longValue()){
					rmin = csmr.getSymiops().longValue();
				}
				if(rmax<csmr.getSymiops().longValue()){
					rmax = csmr.getSymiops().longValue();
				}
				if(lmin>csmr.getSymthroughput().longValue()){
					lmin = csmr.getSymthroughput().longValue();
				}
				if(lmax<csmr.getSymthroughput().longValue()){
					lmax = csmr.getSymthroughput().longValue();
				}
				//�ж��Ƿ���ʾ��ֵ��
				if(monitorObjectDefVWInfoList!=null&&monitorObjectDefVWInfoList.size()>0){
					for(MonitorObjectDefVWInfo info:monitorObjectDefVWInfoList){
						//�ж��Ƿ��Ѿ���ʾ��ֵ��
						if(!isFlag){
							if(info.getOrderNumber()==1){
								if(">=".equals(info.getCompare())){
									if(csmr.getSymiops().longValue()>=Long.parseLong(info.getModValue())){
										isFlag=true;
										flag = "<FLAG>true</FLAG>";
										flagValue = "<FLAGVALUE>"+info.getModValue()+"</FLAGVALUE>";
									}
								}
								if("<=".equals(info.getCompare())){
									if(csmr.getSymiops().longValue()<=Long.parseLong(info.getModValue())){
										isFlag=true;
										flag = "<FLAG>true</FLAG>";
										flagValue = "<FLAGVALUE>"+info.getModValue()+"</FLAGVALUE>";
									}
								}
							}
						}
						//�ж��Ƿ��Ѿ���ʾ��ֵ��
						if(!isFlagOne){
							if(info.getOrderNumber()==2){
								if(">=".equals(info.getCompare())){
									if(csmr.getSymthroughput().longValue()>=Long.parseLong(info.getModValue())){
										isFlagOne=true;
										flagOne= "<FLAGONE>true</FLAGONE>";
										flagValueOne = "<FLAGVALUEONE>"+info.getModValue()+"</FLAGVALUEONE>";
									}
								}
								if("<=".equals(info.getCompare())){
									if(csmr.getSymthroughput().longValue()<=Long.parseLong(info.getModValue())){
										isFlagOne=true;
										flagOne = "<FLAGONE>true</FLAGONE>";
										flagValueOne = "<FLAGVALUEONE>"+info.getModValue()+"</FLAGVALUEONE>";
									}
								}
							}
						}
					}
				}
				bv = Integer.valueOf(csmr.getSymtime());
				bottom = bottom+"<value>" + csmr.getSymtime() + "</value>";
				time = time + "<value>" + csmr.getFulltime() + "</value>";
				iops = iops+"<value>" + csmr.getSymiops() + "</value>";
				throughput = throughput+"<value>" + csmr.getSymthroughput() + "</value>";
			}
			//��С��8����ʱ
			int m = 8-csmrList.size();	
			for (int i = 0; i < m; i++) {
				bv = (++bv)%24;
				bottom = bv<10 ? bottom+"<value>" + "0"+bv + "</value>" :bottom+"<value>" + bv + "</value>";
				time = time + "<value></value>";
				iops = iops+"<value></value>";
				throughput = throughput+"<value></value>";
			}	
			//��ѯ���������Ϣ
			CodeDetailSearchCondImpl cdcond = new CodeDetailSearchCondImpl();
			cdcond.setCvalue(csiList.get(c).getSymm_id());
			cdcond.setCdstatus("1");
			List<CodeDetail> cdList = codeDetailBL.searchCodeDetail(cdcond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
			if(cdList!=null&&cdList.size()>0){
				CodeDetail codeDetail = cdList.get(0);
				String hostid = codeDetail.getCcid()+"_"+codeDetail.getCid()+"_"+codeDetail.getSyscoding();
				content = content+"<REPORT>" + hostid + "</REPORT>";
			}else{
				content = content+"<REPORT>" + "false" + "</REPORT>";
			}
			content = content+"<HOST color='#000000'>" + csiList.get(c).getSymm_id() + "</HOST>";
			
			//������Y�����ֵ
			int n=0;
			while(rmax/new Double(Math.pow(10, n)).longValue()>100){
				n++;
			}
			rmax = (rmax/new Double(Math.pow(10, n)).longValue()+1)*new Double(Math.pow(10, n)).longValue();
			//������Y�����ֵ
			n=0;
			while(lmax/new Double(Math.pow(10, n)).longValue()>100){
				n++;
			}
			lmax = (lmax/new Double(Math.pow(10, n)).longValue()+1)*new Double(Math.pow(10, n)).longValue();
			//������Y����Сֵ
			n=0;
			while(rmin/new Double(Math.pow(10, n)).longValue()>10){
				n++;
			}
			rmin = (rmin/new Double(Math.pow(10, n)).longValue())*new Double(Math.pow(10, n)).longValue();
			//������Y����Сֵ
			n=0;
			while(lmin/new Double(Math.pow(10, n)).longValue()>10){
				n++;
			}
			lmin = (lmin/new Double(Math.pow(10, n)).longValue())*new Double(Math.pow(10, n)).longValue();
			
			mmvalue = mmvalue+"<RIGHTMAXVALUE>" + lmax + "</RIGHTMAXVALUE>";
			mmvalue = mmvalue+"<RIGHTMINVALUE>" + lmin + "</RIGHTMINVALUE>";
			mmvalue = mmvalue+"<LEFTMAXVALUE>" + rmax + "</LEFTMAXVALUE>";
			mmvalue = mmvalue+"<LEFTMINVALUE>" + rmin + "</LEFTMINVALUE>";	

			bv = (++bv)%24;
			if(bv<10){
				bottom = bottom+"<value>" + "0"+bv + "</value>";
			}else{
				bottom = bottom+"<value>" + bv + "</value>";
			}
			bv = (++bv)%24;
			if(bv<10){
				bottom = bottom+"<value>" + "0"+bv + "</value>";
			}else{
				bottom = bottom+"<value>" + bv + "</value>";
			}
			bottom = bottom+"</BOTTOM>";
			time = time + "</TIME>";
			iops = iops+"</LEFTLINE>";		
			throughput = throughput+"</RIGHTLINE>";	
		}
		//������״ν���dashboard
		else{
			Collect_Symmetrix_InfoSearchCondImpl infoCond = new Collect_Symmetrix_InfoSearchCondImpl();
			String[] symm_type={"IBM","DMX","CX"};
			infoCond.setSymm_typeStr(symm_type);
			List<Collect_Symmetrix_Info> csiList = collect_Symmetrix_InfoBL.findCollect_Symmetrix_InfoByCond(infoCond, 0, 0);
			if (csiList.size()>0) {
				
				Collect_Symmetrix_Monitor_RtSearchCondImpl rtCond = new Collect_Symmetrix_Monitor_RtSearchCondImpl();
				//CXʵʱ���ܲ�ѯ
				if("CX".equalsIgnoreCase(csiList.get(0).getSymm_type())){
					type="<TYPE>CX</TYPE>";
					dto.setSymm_type(csiList.get(0).getSymm_type());
					rtCond.setSymm_id(csiList.get(0).getSymm_id()+"_SP B");
				}else{
					rtCond.setSymm_id(csiList.get(0).getSymm_id());
				}
				List<Collect_Symmetrix_Monitor_RtVWInfo> csmrList = getCollect_Symmetrix_Monitor_RtInfo(rtCond,csiList.get(0).getSymm_type());
				//���ݽ��������ƻ�ȡ��ֵ��Ϣ
				MonitorObjectDefVWSearchCondImpl moCond=new MonitorObjectDefVWSearchCondImpl();
				moCond.setMoName(csiList.get(0).getSymm_id());
				moCond.setDeleteFlag("0");
				List<MonitorObjectDefVWInfo> monitorObjectDefVWInfoList=this.monitorObjectDefVWBL.searchMonitorObjectDefVW(moCond);
				long rmax = 0l;
				long rmin = 0l;
				long lmax = 0l;
				long lmin = 0l;
				int bv = new Date().getHours()-1;
				for(int i=0;i<csmrList.size();i++){
					Collect_Symmetrix_Monitor_RtVWInfo csmr = csmrList.get(i);
					if(rmin>csmr.getSymiops().longValue()){
						rmin = csmr.getSymiops().longValue();
					}
					if(rmax<csmr.getSymiops().longValue()){
						rmax = csmr.getSymiops().longValue();
					}
					if(lmin>csmr.getSymthroughput().longValue()){
						lmin = csmr.getSymthroughput().longValue();
					}
					if(lmax<csmr.getSymthroughput().longValue()){
						lmax = csmr.getSymthroughput().longValue();
					}
					//�ж��Ƿ���ʾ��ֵ��
					if(monitorObjectDefVWInfoList!=null&&monitorObjectDefVWInfoList.size()>0){
						for(MonitorObjectDefVWInfo info:monitorObjectDefVWInfoList){
							//�ж��Ƿ��Ѿ���ʾ��ֵ��
							if(!isFlag){
								if(info.getOrderNumber()==1){
									if(">=".equals(info.getCompare())){
										if(csmr.getSymiops().longValue()>=Long.parseLong(info.getModValue())){
											isFlag=true;
											flag = "<FLAG>true</FLAG>";
											flagValue = "<FLAGVALUE>"+info.getModValue()+"</FLAGVALUE>";
										}
									}
									if("<=".equals(info.getCompare())){
										if(csmr.getSymiops().longValue()<=Long.parseLong(info.getModValue())){
											isFlag=true;
											flag = "<FLAG>true</FLAG>";
											flagValue = "<FLAGVALUE>"+info.getModValue()+"</FLAGVALUE>";
										}
									}
								}
							}
							//�ж��Ƿ��Ѿ���ʾ��ֵ��
							if(!isFlagOne){
								if(info.getOrderNumber()==2){
									if(">=".equals(info.getCompare())){
										if(csmr.getSymthroughput().longValue()>=Long.parseLong(info.getModValue())){
											isFlagOne=true;
											flagOne= "<FLAGONE>true</FLAGONE>";
											flagValueOne = "<FLAGVALUEONE>"+info.getModValue()+"</FLAGVALUEONE>";
										}
									}
									if("<=".equals(info.getCompare())){
										if(csmr.getSymthroughput().longValue()<=Long.parseLong(info.getModValue())){
											isFlagOne=true;
											flagOne = "<FLAGONE>true</FLAGONE>";
											flagValueOne = "<FLAGVALUEONE>"+info.getModValue()+"</FLAGVALUEONE>";
										}
									}
								}
							}
						}
					}
					bv = Integer.valueOf(csmr.getSymtime());
					bottom = bottom+"<value>" + csmr.getSymtime() + "</value>";
					time = time + "<value>" + csmr.getFulltime() + "</value>";
					iops = iops+"<value>" + csmr.getSymiops() + "</value>";
					throughput = throughput+"<value>" + csmr.getSymthroughput() + "</value>";
				}
				//��С��8����ʱ
				int m = 8-csmrList.size();
				for (int i = 0; i < m; i++) {
					bv = (++bv)%24;
					bottom = bv<10 ? bottom+"<value>" + "0"+bv + "</value>" :bottom+"<value>" + bv + "</value>";
					time = time + "<value></value>";
					iops = iops+"<value></value>";
					throughput = throughput+"<value></value>";
				}	
				//��ѯ���������Ϣ
				CodeDetailSearchCondImpl cdcond = new CodeDetailSearchCondImpl();
				cdcond.setCvalue(csiList.get(0).getSymm_id());
				cdcond.setCdstatus("1");
				List<CodeDetail> cdList = codeDetailBL.searchCodeDetail(cdcond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
				if(cdList!=null&&cdList.size()>0){
					CodeDetail codeDetail = cdList.get(0);
					String hostid = codeDetail.getCcid()+"_"+codeDetail.getCid()+"_"+codeDetail.getSyscoding();
					content = content+"<REPORT>" + hostid + "</REPORT>";
				}else{
					content = content+"<REPORT>" + "false" + "</REPORT>";
				}
				content = content+"<HOST color='#000000'>" + csiList.get(0).getSymm_id() + "</HOST>";
				//������Y�����ֵ
				int n=0;
				while(rmax/new Double(Math.pow(10, n)).longValue()>100){
					n++;
				}
				rmax = (rmax/new Double(Math.pow(10, n)).longValue()+1)*new Double(Math.pow(10, n)).longValue();
				//������Y�����ֵ
				n=0;
				while(lmax/new Double(Math.pow(10, n)).longValue()>100){
					n++;
				}
				lmax = (lmax/new Double(Math.pow(10, n)).longValue()+1)*new Double(Math.pow(10, n)).longValue();
				//������Y����Сֵ
				n=0;
				while(rmin/new Double(Math.pow(10, n)).longValue()>10){
					n++;
				}
				rmin = (rmin/new Double(Math.pow(10, n)).longValue())*new Double(Math.pow(10, n)).longValue();
				//������Y����Сֵ
				n=0;
				while(lmin/new Double(Math.pow(10, n)).longValue()>10){
					n++;
				}
				lmin = (lmin/new Double(Math.pow(10, n)).longValue())*new Double(Math.pow(10, n)).longValue();
				
				mmvalue = mmvalue+"<RIGHTMAXVALUE>" + lmax + "</RIGHTMAXVALUE>";
				mmvalue = mmvalue+"<RIGHTMINVALUE>" + lmin + "</RIGHTMINVALUE>";
				mmvalue = mmvalue+"<LEFTMAXVALUE>" + rmax + "</LEFTMAXVALUE>";
				mmvalue = mmvalue+"<LEFTMINVALUE>" + rmin + "</LEFTMINVALUE>";	

				bv = (++bv)%24;
				if(bv<10){
					bottom = bottom+"<value>" + "0"+bv + "</value>";
				}else{
					bottom = bottom+"<value>" + bv + "</value>";
				}
				bv = (++bv)%24;
				if(bv<10){
					bottom = bottom+"<value>" + "0"+bv + "</value>";
				}else{
					bottom = bottom+"<value>" + bv + "</value>";
				}
			}//�ж������Ƿ�Ϊ�ս���
			 else{
				 //Ϊ��ʱ���ܵ�
				 content = content+"<REPORT>" + "false" + "</REPORT>";
			}
			bottom = bottom+"</BOTTOM>";	
			time = time + "</TIME>";
			iops = iops+"</LEFTLINE>";		
			throughput = throughput+"</RIGHTLINE>";	
		}
		content = content+type;
		content = content+flag;
		content = content+flagValue;
		content = content+flagOne;
		content = content+flagValueOne;
		content = content+mmvalue;
		content = content+bottom;
		content = content+time;
		content = content+iops;
		content = content+throughput;
		content = content+"</ROOT>";
		
		dto.setReadperWriteperHitper(content);
		
		return dto;
	}
	
	/**
	 * ����: ������������
	 * @param  IGDBS01DTO dto
	 * @return ������������
	 * @update baiyanfu_20120301_��ҳDashBoard��ֵ��ʾ
	 * @throws BLException
	 */
	@SuppressWarnings("deprecation")
	public IGDBS01DTO  getIOPSandThroughput2(IGDBS01DTO dto) throws BLException{
		
		String symmid = dto.getSymmid();//��ǰѡ�����к�
		String hostchoose = dto.getHostchoose();//����ѡ��������ѡ��
		
		String content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
		String mmvalue = "";				//��װy�����ֵ��Сֵ
		String bottom = "<BOTTOM>";			//x��̶�
		String time ="<TIME>";              //��ʾ��ʱ��
		String throughput = "<LINE>";		//������
		String flag="<FLAG>false</FLAG>";	//�Ƿ���ʾ��ֵ�߱�ʶ
		String flagValue="<FLAGVALUE></FLAGVALUE>";	//��ֵ
		boolean flagOne=false;
		//������ǵ�һ�ν���dashboard
		if(StringUtils.isNotEmpty(symmid)){

			Collect_Symmetrix_InfoSearchCondImpl infoCond = new Collect_Symmetrix_InfoSearchCondImpl();
			String[] symm_type={"Brocade","Mcdata"};
			infoCond.setSymm_typeStr(symm_type);
			List<Collect_Symmetrix_Info> csiList = collect_Symmetrix_InfoBL.findCollect_Symmetrix_InfoByCond(infoCond, 0, 0);
			
			int c=0;
			
			if("0".equals(hostchoose)){
				for(int i=0;i<csiList.size();i++){
					if(csiList.get(i).getSymm_id().equals(symmid)){
						c--;
						break;
					}
					c++;
				}
			}
			if("1".equals(hostchoose)){
				for(int i=0;i<csiList.size();i++){
					if(csiList.get(i).getSymm_id().equals(symmid)){
						c++;
						break;
					}
					c++;
				}
			}
		
			Collect_Symmetrix_Monitor_RtSearchCondImpl rtCond = new Collect_Symmetrix_Monitor_RtSearchCondImpl();
			rtCond.setSymm_id(csiList.get(c).getSymm_id());
			List<Collect_Symmetrix_Monitor_RtVWInfo> csmrList = getCollect_Symmetrix_Monitor_RtInfo(rtCond,csiList.get(c).getSymm_type());
			//���ݽ��������ƻ�ȡ��ֵ��Ϣ
			MonitorObjectDefVWSearchCondImpl moCond=new MonitorObjectDefVWSearchCondImpl();
			moCond.setMoName(csiList.get(c).getSymm_id());
			moCond.setDeleteFlag("0");
			List<MonitorObjectDefVWInfo> monitorObjectDefVWInfoList=this.monitorObjectDefVWBL.searchMonitorObjectDefVW(moCond);
			long rmax = 0l;
			long rmin = 0l;
			int bv = new Date().getHours()-1;
			for(int i=0;i<csmrList.size();i++){
				Collect_Symmetrix_Monitor_RtVWInfo csmr = csmrList.get(i);
				if(rmin>csmr.getSymiops().longValue()){
					rmin = csmr.getSymiops().longValue();
				}
				if(rmax<csmr.getSymiops().longValue()){
					rmax = csmr.getSymiops().longValue();
				}
				//�ж��Ƿ���ʾ��ֵ��
				if(!flagOne){
					if(monitorObjectDefVWInfoList!=null&&monitorObjectDefVWInfoList.size()>0){
						for(MonitorObjectDefVWInfo info:monitorObjectDefVWInfoList){
							if(info.getOrderNumber()==1){
								if(">=".equals(info.getCompare())){
									if(csmr.getSymiops().longValue()>=Long.parseLong(info.getModValue())){
										flagOne=true;
										flag = "<FLAG>true</FLAG>";
										flagValue = "<FLAGVALUE>"+info.getModValue()+"</FLAGVALUE>";
									}
								}
								if("<=".equals(info.getCompare())){
									if(csmr.getSymiops().longValue()<=Long.parseLong(info.getModValue())){
										flagOne=true;
										flag = "<FLAG>true</FLAG>";
										flagValue = "<FLAGVALUE>"+info.getModValue()+"</FLAGVALUE>";
									}
								}
							}
						}
					}
				}
				bv = Integer.valueOf(csmr.getSymtime());
				bottom = bottom+"<value>" + csmr.getSymtime() + "</value>";
				time = time + "<value>" + csmr.getFulltime() + "</value>";
				throughput = throughput+"<value>" + csmr.getSymiops() + "</value>";
			}
			//��С��8����ʱ
			int m = 8-csmrList.size();	
			for (int i = 0; i < m; i++) {
				bv = (++bv)%24;
				bottom = bv<10 ? bottom+"<value>" + "0"+bv + "</value>" :bottom+"<value>" + bv + "</value>";
				time = time + "<value></value>";
				throughput = throughput+"<value></value>";
			}	
			//��ѯ���������Ϣ
			CodeDetailSearchCondImpl cdcond = new CodeDetailSearchCondImpl();
			cdcond.setCvalue(csiList.get(c).getSymm_id());
			cdcond.setCdstatus("1");
			List<CodeDetail> cdList = codeDetailBL.searchCodeDetail(cdcond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
			if(cdList!=null&&cdList.size()>0){
				CodeDetail codeDetail = cdList.get(0);
				String hostid = codeDetail.getCcid()+"_"+codeDetail.getCid()+"_"+codeDetail.getSyscoding();
				content = content+"<REPORT>" + hostid + "</REPORT>";
			}else{
				content = content+"<REPORT>" + "false" + "</REPORT>";
			}
			content = content+"<HOST color='#000000'>" + csiList.get(c).getSymm_id() + "</HOST>";
			
			//����Y�����ֵ
			int n=0;
			while(rmax/new Double(Math.pow(10, n)).longValue()>100){
				n++;
			}
			rmax = (rmax/new Double(Math.pow(10, n)).longValue()+1)*new Double(Math.pow(10, n)).longValue();
			//����Y����Сֵ
			n=0;
			while(rmin/new Double(Math.pow(10, n)).longValue()>10){
				n++;
			}
			rmin = (rmin/new Double(Math.pow(10, n)).longValue())*new Double(Math.pow(10, n)).longValue();
			//����Y����Сֵ�����ֵ
			mmvalue = mmvalue+"<MAXVALUE>" + rmax + "</MAXVALUE>";
			mmvalue = mmvalue+"<MINVALUE>" + rmin + "</MINVALUE>";	

			bv = (++bv)%24;
			if(bv<10){
				bottom = bottom+"<value>" + "0"+bv + "</value>";
			}else{
				bottom = bottom+"<value>" + bv + "</value>";
			}
			bv = (++bv)%24;
			if(bv<10){
				bottom = bottom+"<value>" + "0"+bv + "</value>";
			}else{
				bottom = bottom+"<value>" + bv + "</value>";
			}
			bottom = bottom+"</BOTTOM>";
			time = time + "</TIME>";
			throughput = throughput+"</LINE>";		
		}
		//������״ν���dashboard
		else{
			Collect_Symmetrix_InfoSearchCondImpl infoCond = new Collect_Symmetrix_InfoSearchCondImpl();
			String[] symm_type={"Brocade","Mcdata"};
			infoCond.setSymm_typeStr(symm_type);
			List<Collect_Symmetrix_Info> csiList = collect_Symmetrix_InfoBL.findCollect_Symmetrix_InfoByCond(infoCond, 0, 0);
			if (csiList.size()>0) {
				
				Collect_Symmetrix_Monitor_RtSearchCondImpl rtCond = new Collect_Symmetrix_Monitor_RtSearchCondImpl();
				rtCond.setSymm_id(csiList.get(0).getSymm_id());
				List<Collect_Symmetrix_Monitor_RtVWInfo> csmrList = getCollect_Symmetrix_Monitor_RtInfo(rtCond,csiList.get(0).getSymm_type());
				//���ݽ��������ƻ�ȡ��ֵ��Ϣ
				MonitorObjectDefVWSearchCondImpl moCond=new MonitorObjectDefVWSearchCondImpl();
				moCond.setMoName(csiList.get(0).getSymm_id());
				moCond.setDeleteFlag("0");
				List<MonitorObjectDefVWInfo> monitorObjectDefVWInfoList=this.monitorObjectDefVWBL.searchMonitorObjectDefVW(moCond);
				long rmax = 0l;
				long rmin = 0l;
				int bv = new Date().getHours()-1;
				if(csmrList!=null&&csmrList.size()>0){
					for(int i=0;i<csmrList.size();i++){
						Collect_Symmetrix_Monitor_RtVWInfo csmr = csmrList.get(i);
						if(rmin>csmr.getSymiops().longValue()){
							rmin = csmr.getSymiops().longValue();
						}
						if(rmax<csmr.getSymiops().longValue()){
							rmax = csmr.getSymiops().longValue();
						}
						//�ж��Ƿ���ʾ��ֵ��
						if(!flagOne){
							if(monitorObjectDefVWInfoList!=null&&monitorObjectDefVWInfoList.size()>0){
								for(MonitorObjectDefVWInfo info:monitorObjectDefVWInfoList){
									if(info.getOrderNumber()==1){
										if(">=".equals(info.getCompare())){
											if(csmr.getSymiops().longValue()>=Long.parseLong(info.getModValue())){
												flagOne=true;
												flag = "<FLAG>true</FLAG>";
												flagValue = "<FLAGVALUE>"+info.getModValue()+"</FLAGVALUE>";
											}
										}
										if("<=".equals(info.getCompare())){
											if(csmr.getSymiops().longValue()<=Long.parseLong(info.getModValue())){
												flagOne=true;
												flag = "<FLAG>true</FLAG>";
												flagValue = "<FLAGVALUE>"+info.getModValue()+"</FLAGVALUE>";
											}
										}
									}
								}
							}else{
								flag = "<FLAG>false</FLAG>";
								flagValue = "<FLAGVALUE></FLAGVALUE>";
							}
						}
						bv = Integer.valueOf(csmr.getSymtime());
						bottom = bottom+"<value>" + csmr.getSymtime() + "</value>";
						time = time + "<value>" + csmr.getFulltime() + "</value>";
						throughput = throughput+"<value>" + csmr.getSymiops() + "</value>";
					}
				}else{
					content = content+"<FLAG>false</FLAG>";
					content = content+"<FLAGVALUE></FLAGVALUE>";
				}
				
				//��С��8����ʱ
				int m = 8-csmrList.size();
				for (int i = 0; i < m; i++) {
					bv = (++bv)%24;
					bottom = bv<10 ? bottom+"<value>" + "0"+bv + "</value>" :bottom+"<value>" + bv + "</value>";
					time = time + "<value></value>";
					throughput = throughput+"<value></value>";
				}
				//��ѯ���������Ϣ
				CodeDetailSearchCondImpl cdcond = new CodeDetailSearchCondImpl();
				cdcond.setCvalue(csiList.get(csiList.size()-1).getSymm_id());
				cdcond.setCdstatus("1");
				List<CodeDetail> cdList = codeDetailBL.searchCodeDetail(cdcond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
				if(cdList!=null&&cdList.size()>0){
					CodeDetail codeDetail = cdList.get(0);
					String hostid = codeDetail.getCcid()+"_"+codeDetail.getCid()+"_"+codeDetail.getSyscoding();
					content = content+"<REPORT>" + hostid + "</REPORT>";
				}else{
					content = content+"<REPORT>" + "false" + "</REPORT>";
				}
				content = content+"<HOST color='#000000'>" + csiList.get(0).getSymm_id() + "</HOST>";
				
				//����Y�����ֵ
				int n=0;
				while(rmax/new Double(Math.pow(10, n)).longValue()>100){
					n++;
				}
				rmax = (rmax/new Double(Math.pow(10, n)).longValue()+1)*new Double(Math.pow(10, n)).longValue();
				//����Y����Сֵ
				n=0;
				while(rmin/new Double(Math.pow(10, n)).longValue()>10){
					n++;
				}
				rmin = (rmin/new Double(Math.pow(10, n)).longValue())*new Double(Math.pow(10, n)).longValue();
				//����Y����Сֵ�����ֵ
				mmvalue = mmvalue+"<MAXVALUE>" + rmax + "</MAXVALUE>";
				mmvalue = mmvalue+"<MINVALUE>" + rmin + "</MINVALUE>";	

				bv = (++bv)%24;
				if(bv<10){
					bottom = bottom+"<value>" + "0"+bv + "</value>";
				}else{
					bottom = bottom+"<value>" + bv + "</value>";
				}
				bv = (++bv)%24;
				if(bv<10){
					bottom = bottom+"<value>" + "0"+bv + "</value>";
				}else{
					bottom = bottom+"<value>" + bv + "</value>";
				}
			}//�ж�Ϊ�ս���
			else{
				content = content+"<REPORT>" + "false" + "</REPORT>";
			}			
			bottom = bottom+"</BOTTOM>";	
			time = time + "</TIME>";
			throughput = throughput+"</LINE>";		
		}
		content = content+flag;
		content = content+flagValue;
		content = content+mmvalue;
		content = content+bottom;
		content = content+time;
		content = content+throughput;
		content = content+"</ROOT>";
		
		dto.setIopsThroughput(content);
		
		return dto;
	}
	
	/**
	 * ����: ������/д����/����������
	 * @param  IGDBS01DTO dto
	 * @return ������/д����/����������
	 * @update baiyanfu_20120301_��ҳDashBoard��ֵ��ʾ
	 * @throws BLException
	 */
	@SuppressWarnings("deprecation")
	public IGDBS01DTO  getReadperWriteperHitper1(IGDBS01DTO dto) throws BLException{
		
		String symmid = dto.getSymmid();//��ǰѡ�����к�
		String hostchoose = dto.getHostchoose();//����ѡ��������ѡ��
		
		String content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
		String mmvalue = "";				//��װy�����ֵ��Сֵ
		String bottom = "<BOTTOM>";			//x��̶�
		String time ="<TIME>";                //��ʾʱ��
		String oneline = "<ONELINE>";		//������
		String twoline = "<TWOLINE>";	//д����
		String threeline = "<THREELINE>";		//����������
		String flag="<FLAG>false</FLAG>";	//�Ƿ���ʾ��ֵ�߱�ʶ
		String flagValue="<FLAGVALUE></FLAGVALUE>";	//��ֵ
		String flagOne="<FLAGONE>false</FLAGONE>";	//�Ƿ���ʾ��ֵ�߱�ʶ
		String flagValueOne="<FLAGVALUEONE></FLAGVALUEONE>";//��ֵ
		String flagTwo="<FLAGTWO>false</FLAGTWO>";	//�Ƿ���ʾ��ֵ�߱�ʶ
		String flagValueTwo="<FLAGVALUETWO></FLAGVALUETWO>";	//��ֵ
		boolean isFlag=false;
		boolean isFlagOne=false;
		boolean isFlagTwo=false;
		//������ǵ�һ�ν���dashboard
		if(StringUtils.isNotEmpty(symmid)){

			Collect_Symmetrix_InfoSearchCondImpl infoCond = new Collect_Symmetrix_InfoSearchCondImpl();
			String[] symm_type={"IBM","DMX","CX"};
			infoCond.setSymm_typeStr(symm_type);
			List<Collect_Symmetrix_Info> csiList = collect_Symmetrix_InfoBL.findCollect_Symmetrix_InfoByCond(infoCond, 0, 0);
			
			int c=0;
			
			if("0".equals(hostchoose)){
				for(int i=0;i<csiList.size();i++){
					if(csiList.get(i).getSymm_id().equals(symmid)){
						c--;
						break;
					}
					c++;
				}
			}
			if("1".equals(hostchoose)){
				for(int i=0;i<csiList.size();i++){
					if(csiList.get(i).getSymm_id().equals(symmid)){
						c++;
						break;
					}
					c++;
				}
			}
			
			Collect_Symmetrix_Monitor_RtSearchCondImpl rtCond = new Collect_Symmetrix_Monitor_RtSearchCondImpl();
			rtCond.setSymm_id(csiList.get(c).getSymm_id());
			List<Collect_Symmetrix_Monitor_RtVWInfo> csmrList = getCollect_Symmetrix_Monitor_RtInfo(rtCond,csiList.get(c).getSymm_type());
			//���ݽ��������ƻ�ȡ��ֵ��Ϣ
			MonitorObjectDefVWSearchCondImpl moCond=new MonitorObjectDefVWSearchCondImpl();
			moCond.setMoName(csiList.get(c).getSymm_id());
			moCond.setDeleteFlag("0");
			List<MonitorObjectDefVWInfo> monitorObjectDefVWInfoList=this.monitorObjectDefVWBL.searchMonitorObjectDefVW(moCond);
			long rmax = 0l;
			long rmin = 0l;
			int bv = new Date().getHours()-1;
			for(int i=0;i<csmrList.size();i++){
				Collect_Symmetrix_Monitor_RtVWInfo csmr = csmrList.get(i);
				if(rmin>csmr.getReadper().longValue()){
					rmin = csmr.getReadper().longValue();
				}
				if(rmin>csmr.getWriteper().longValue()){
					rmin = csmr.getWriteper().longValue();
				}
				if(rmin>csmr.getHitper().longValue()){
					rmin = csmr.getHitper().longValue();
				}
				if(rmax<csmr.getReadper().longValue()){
					rmax = csmr.getReadper().longValue();
				}
				if(rmax<csmr.getWriteper().longValue()){
					rmax = csmr.getWriteper().longValue();
				}
				if(rmax<csmr.getHitper().longValue()){
					rmax = csmr.getHitper().longValue();
				}
				//�ж��Ƿ���ʾ��ֵ��
				if(monitorObjectDefVWInfoList!=null&&monitorObjectDefVWInfoList.size()>0){
					for(MonitorObjectDefVWInfo info:monitorObjectDefVWInfoList){
						//�ж��Ƿ��Ѿ���ʾ��ֵ��
						if(!isFlag){
							if(info.getOrderNumber()==3){
								if(">=".equals(info.getCompare())){
									if(csmr.getReadper().longValue()>=Long.parseLong(info.getModValue())){
										isFlag=true;
										flag = "<FLAG>true</FLAG>";
										flagValue = "<FLAGVALUE>"+info.getModValue()+"</FLAGVALUE>";
									}
								}
								if("<=".equals(info.getCompare())){
									if(csmr.getReadper().longValue()<=Long.parseLong(info.getModValue())){
										isFlag=true;
										flag = "<FLAG>true</FLAG>";
										flagValue = "<FLAGVALUE>"+info.getModValue()+"</FLAGVALUE>";
									}
								}
							}
						}
						//�ж��Ƿ��Ѿ���ʾ��ֵ��
						if(!isFlagOne){
							if(info.getOrderNumber()==4){
								if(">=".equals(info.getCompare())){
									if(csmr.getWriteper().longValue()>=Long.parseLong(info.getModValue())){
										isFlagOne=true;
										flagOne= "<FLAGONE>true</FLAGONE>";
										flagValueOne = "<FLAGVALUEONE>"+info.getModValue()+"</FLAGVALUEONE>";
									}
								}
								if("<=".equals(info.getCompare())){
									if(csmr.getWriteper().longValue()<=Long.parseLong(info.getModValue())){
										isFlagOne=true;
										flagOne = "<FLAGONE>true</FLAGONE>";
										flagValueOne = "<FLAGVALUEONE>"+info.getModValue()+"</FLAGVALUEONE>";
									}
								}
							}
						}
						//�ж��Ƿ��Ѿ���ʾ��ֵ��
						if(!isFlagTwo){
							if(info.getOrderNumber()==5){
								if(">=".equals(info.getCompare())){
									if(csmr.getHitper().longValue()>=Long.parseLong(info.getModValue())){
										isFlagTwo=true;
										flagTwo= "<FLAGTWO>true</FLAGTWO>";
										flagValueTwo = "<FLAGVALUETWO>"+info.getModValue()+"</FLAGVALUETWO>";
									}
								}
								if("<=".equals(info.getCompare())){
									if(csmr.getHitper().longValue()<=Long.parseLong(info.getModValue())){
										isFlagTwo=true;
										flagTwo = "<FLAGTWO>true</FLAGTWO>";
										flagValueTwo = "<FLAGVALUETWO>"+info.getModValue()+"</FLAGVALUETWO>";
									}
								}
							}
						}
					}
				}
				bv = Integer.valueOf(csmr.getSymtime());
				bottom = bottom+"<value>" + csmr.getSymtime() + "</value>";
				time = time + "<value>" + csmr.getFulltime() + "</value>";
				oneline = oneline+"<value>" + csmr.getReadper() + "</value>";
				twoline = twoline+"<value>" + csmr.getWriteper() + "</value>";
				threeline = threeline+"<value>" + csmr.getHitper() + "</value>";
			}
			//��С��8����ʱ
			int m = 8-csmrList.size();
			for (int i = 0; i < m; i++) {
				bv = (++bv)%24;
				bottom = bv<10 ? bottom+"<value>" + "0"+bv + "</value>" :bottom+"<value>" + bv + "</value>";
				time = time + "<value></value>";
				oneline = oneline+"<value></value>";
				twoline = twoline+"<value></value>";
				threeline = threeline+"<value></value>";
			}
			//��ѯ���������Ϣ
			CodeDetailSearchCondImpl cdcond = new CodeDetailSearchCondImpl();
			cdcond.setCvalue(csiList.get(c).getSymm_id());
			cdcond.setCdstatus("1");
			List<CodeDetail> cdList = codeDetailBL.searchCodeDetail(cdcond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
			if(cdList!=null&&cdList.size()>0){
				CodeDetail codeDetail = cdList.get(0);
				String hostid = codeDetail.getCcid()+"_"+codeDetail.getCid()+"_"+codeDetail.getSyscoding();
				content = content+"<REPORT>" + hostid + "</REPORT>";
			}else{
				content = content+"<REPORT>" + "false" + "</REPORT>";
			}
			content = content+"<HOST color='#000000'>" + csiList.get(c).getSymm_id() + "</HOST>";
			//������Y�����ֵ
			int n=0;
			while(rmax/new Double(Math.pow(10, n)).longValue()>10){
				n++;
			}
			rmax = (rmax/new Double(Math.pow(10, n)).longValue()+1)*new Double(Math.pow(10, n)).longValue();
			//������Y����Сֵ
			n=0;
			while(rmin/new Double(Math.pow(10, n)).longValue()>10){
				n++;
			}
			rmin = (rmin/new Double(Math.pow(10, n)).longValue())*new Double(Math.pow(10, n)).longValue();
			
			mmvalue = mmvalue+"<MAXVALUE>100</MAXVALUE>";
			mmvalue = mmvalue+"<MINVALUE>0</MINVALUE>";
		
			bv = (++bv)%24;
			if(bv<10){
				bottom = bottom+"<value>" + "0"+bv + "</value>";
			}else{
				bottom = bottom+"<value>" + bv + "</value>";
			}
			bv = (++bv)%24;
			if(bv<10){
				bottom = bottom+"<value>" + "0"+bv + "</value>";
			}else{
				bottom = bottom+"<value>" + bv + "</value>";
			}
			bottom = bottom+"</BOTTOM>";
			time = time +"</TIME>";
			oneline = oneline+"</ONELINE>";		
			twoline = twoline+"</TWOLINE>";	
			threeline = threeline+"</THREELINE>";
		}
		//������״ν���dashboard
		else{
			Collect_Symmetrix_InfoSearchCondImpl infoCond = new Collect_Symmetrix_InfoSearchCondImpl();
			String[] symm_type={"IBM","DMX","CX"};
			infoCond.setSymm_typeStr(symm_type);
			List<Collect_Symmetrix_Info> csiList = collect_Symmetrix_InfoBL.findCollect_Symmetrix_InfoByCond(infoCond, 0, 0);
			if (csiList.size()>0) {
				Collect_Symmetrix_Monitor_RtSearchCondImpl rtCond = new Collect_Symmetrix_Monitor_RtSearchCondImpl();
				rtCond.setSymm_id(csiList.get(0).getSymm_id());
				List<Collect_Symmetrix_Monitor_RtVWInfo> csmrList = getCollect_Symmetrix_Monitor_RtInfo(rtCond,csiList.get(0).getSymm_type());
				//���ݽ��������ƻ�ȡ��ֵ��Ϣ
				MonitorObjectDefVWSearchCondImpl moCond=new MonitorObjectDefVWSearchCondImpl();
				moCond.setMoName(csiList.get(0).getSymm_id());
				moCond.setDeleteFlag("0");
				List<MonitorObjectDefVWInfo> monitorObjectDefVWInfoList=this.monitorObjectDefVWBL.searchMonitorObjectDefVW(moCond);
				long rmax = 0l;
				long rmin = 0l;
				int bv = new Date().getHours()-1;
				for(int i=0;i<csmrList.size();i++){
					Collect_Symmetrix_Monitor_RtVWInfo csmr = csmrList.get(i);
					if(rmin>csmr.getReadper().longValue()){
						rmin = csmr.getReadper().longValue();
					}
					if(rmin>csmr.getWriteper().longValue()){
						rmin = csmr.getWriteper().longValue();
					}
					if(rmin>csmr.getHitper().longValue()){
						rmin = csmr.getHitper().longValue();
					}
					if(rmax<csmr.getReadper().longValue()){
						rmax = csmr.getReadper().longValue();
					}
					if(rmax<csmr.getWriteper().longValue()){
						rmax = csmr.getWriteper().longValue();
					}
					if(rmax<csmr.getHitper().longValue()){
						rmax = csmr.getHitper().longValue();
					}
					//�ж��Ƿ���ʾ��ֵ��
					if(monitorObjectDefVWInfoList!=null&&monitorObjectDefVWInfoList.size()>0){
						for(MonitorObjectDefVWInfo info:monitorObjectDefVWInfoList){
							//�ж��Ƿ��Ѿ���ʾ��ֵ��
							if(!isFlag){
								if(info.getOrderNumber()==3){
									if(">=".equals(info.getCompare())){
										if(csmr.getReadper().longValue()>=Long.parseLong(info.getModValue())){
											isFlag=true;
											flag = "<FLAG>true</FLAG>";
											flagValue = "<FLAGVALUE>"+info.getModValue()+"</FLAGVALUE>";
										}
									}
									if("<=".equals(info.getCompare())){
										if(csmr.getReadper().longValue()<=Long.parseLong(info.getModValue())){
											isFlag=true;
											flag = "<FLAG>true</FLAG>";
											flagValue = "<FLAGVALUE>"+info.getModValue()+"</FLAGVALUE>";
										}
									}
								}
							}
							//�ж��Ƿ��Ѿ���ʾ��ֵ��
							if(!isFlagOne){
								if(info.getOrderNumber()==4){
									if(">=".equals(info.getCompare())){
										if(csmr.getWriteper().longValue()>=Long.parseLong(info.getModValue())){
											isFlagOne=true;
											flagOne= "<FLAGONE>true</FLAGONE>";
											flagValueOne = "<FLAGVALUEONE>"+info.getModValue()+"</FLAGVALUEONE>";
										}
									}
									if("<=".equals(info.getCompare())){
										if(csmr.getWriteper().longValue()<=Long.parseLong(info.getModValue())){
											isFlagOne=true;
											flagOne = "<FLAGONE>true</FLAGONE>";
											flagValueOne = "<FLAGVALUEONE>"+info.getModValue()+"</FLAGVALUEONE>";
										}
									}
								}
							}
							//�ж��Ƿ��Ѿ���ʾ��ֵ��
							if(!isFlagTwo){
								if(info.getOrderNumber()==5){
									if(">=".equals(info.getCompare())){
										if(csmr.getHitper().longValue()>=Long.parseLong(info.getModValue())){
											isFlagTwo=true;
											flagTwo= "<FLAGTWO>true</FLAGTWO>";
											flagValueTwo = "<FLAGVALUETWO>"+info.getModValue()+"</FLAGVALUETWO>";
										}
									}
									if("<=".equals(info.getCompare())){
										if(csmr.getHitper().longValue()<=Long.parseLong(info.getModValue())){
											isFlagTwo=true;
											flagTwo = "<FLAGTWO>true</FLAGTWO>";
											flagValueTwo = "<FLAGVALUETWO>"+info.getModValue()+"</FLAGVALUETWO>";
										}
									}
								}
							}
						}
					}
					bv = Integer.valueOf(csmr.getSymtime());
					bottom = bottom+"<value>" + csmr.getSymtime() + "</value>";
					time = time + "<value>" + csmr.getFulltime() + "</value>";
					oneline = oneline+"<value>" + csmr.getReadper() + "</value>";
					twoline = twoline+"<value>" + csmr.getWriteper() + "</value>";
					threeline = threeline+"<value>" + csmr.getHitper() + "</value>";
				}
				//��С��8����ʱ
				int m = 8-csmrList.size();
				for (int i = 0; i < m; i++) {
					bv = (++bv)%24;
					bottom = bv<10 ? bottom+"<value>" + "0"+bv + "</value>" :bottom+"<value>" + bv + "</value>";	
					time = time + "<value></value>";
					oneline = oneline+"<value></value>";
					twoline = twoline+"<value></value>";
					threeline = threeline+"<value></value>";
				}
				//��ѯ���������Ϣ
				CodeDetailSearchCondImpl cdcond = new CodeDetailSearchCondImpl();
				cdcond.setCvalue(csiList.get(0).getSymm_id());
				cdcond.setCdstatus("1");
				List<CodeDetail> cdList = codeDetailBL.searchCodeDetail(cdcond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
				if(cdList!=null&&cdList.size()>0){
					CodeDetail codeDetail = cdList.get(0);
					String hostid = codeDetail.getCcid()+"_"+codeDetail.getCid()+"_"+codeDetail.getSyscoding();
					content = content+"<REPORT>" + hostid + "</REPORT>";
				}else{
					content = content+"<REPORT>" + "false" + "</REPORT>";
				}
				content = content+"<HOST color='#000000'>" + csiList.get(0).getSymm_id() + "</HOST>";
				//������Y�����ֵ
				int n=0;
				while(rmax/new Double(Math.pow(10, n)).longValue()>10){
					n++;
				}
				rmax = (rmax/new Double(Math.pow(10, n)).longValue()+1)*new Double(Math.pow(10, n)).longValue();
				//������Y����Сֵ
				n=0;
				while(rmin/new Double(Math.pow(10, n)).longValue()>10){
					n++;
				}
				rmin = (rmin/new Double(Math.pow(10, n)).longValue())*new Double(Math.pow(10, n)).longValue();
				
				mmvalue = mmvalue+"<MAXVALUE>100</MAXVALUE>";
				mmvalue = mmvalue+"<MINVALUE>0</MINVALUE>";
			
				bv = (++bv)%24;
				if(bv<10){
					bottom = bottom+"<value>" + "0"+bv + "</value>";
				}else{
					bottom = bottom+"<value>" + bv + "</value>";
				}
				bv = (++bv)%24;
				if(bv<10){
					bottom = bottom+"<value>" + "0"+bv + "</value>";
				}else{
					bottom = bottom+"<value>" + bv + "</value>";
				}
			}//�ж�����Ϊ�ս���
			else{
				content = content+"<REPORT>" + "false" + "</REPORT>";
			}		
			bottom = bottom+"</BOTTOM>";
			time = time+"</TIME>";
			oneline = oneline+"</ONELINE>";		
			twoline = twoline+"</TWOLINE>";	
			threeline = threeline+"</THREELINE>";
		}
		content = content+flag;
		content = content+flagValue;
		content = content+flagOne;
		content = content+flagValueOne;
		content = content+flagTwo;
		content = content+flagValueTwo;
		content = content+mmvalue;
		content = content+bottom;
		content = content+time;
		content = content+oneline;
		content = content+twoline;
		content = content+threeline;
		content = content+"</ROOT>";
		
		dto.setReadperWriteperHitper(content);
		
		return dto;
	}
	
	/**
	 * ����: ������������
	 * @param  IGDBS01DTO dto
	 * @return ������������
	 * @update baiyanfu_20120301_��ҳDashBoard��ֵ��ʾ
	 * @throws BLException
	 */
	@SuppressWarnings("deprecation")
	public IGDBS01DTO  getReadperWriteperHitper2(IGDBS01DTO dto) throws BLException{
		
		String symmid = dto.getSymmid();//��ǰѡ�����к�
		String hostchoose = dto.getHostchoose();//����ѡ��������ѡ��
		
		String content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
		String mmvalue = "";				//��װy�����ֵ��Сֵ
		String bottom = "<BOTTOM>";			//x��̶�
		String time ="<TIME>";              //��ʾ��ʱ��
		String throughput = "<LINE>";		//������
		String flag="<FLAG>false</FLAG>";	//�Ƿ���ʾ��ֵ�߱�ʶ
		String flagValue="<FLAGVALUE></FLAGVALUE>";	//��ֵ
		boolean flagOne=false;
		//������ǵ�һ�ν���dashboard
		if(StringUtils.isNotEmpty(symmid)){

			Collect_Symmetrix_InfoSearchCondImpl infoCond = new Collect_Symmetrix_InfoSearchCondImpl();
			String[] symm_type={"Brocade","Mcdata"};
			infoCond.setSymm_typeStr(symm_type);
			List<Collect_Symmetrix_Info> csiList = collect_Symmetrix_InfoBL.findCollect_Symmetrix_InfoByCond(infoCond, 0, 0);
			
			int c=0;
			
			if("0".equals(hostchoose)){
				for(int i=0;i<csiList.size();i++){
					if(csiList.get(i).getSymm_id().equals(symmid)){
						c--;
						break;
					}
					c++;
				}
			}
			if("1".equals(hostchoose)){
				for(int i=0;i<csiList.size();i++){
					if(csiList.get(i).getSymm_id().equals(symmid)){
						c++;
						break;
					}
					c++;
				}
			}
		
			Collect_Symmetrix_Monitor_RtSearchCondImpl rtCond = new Collect_Symmetrix_Monitor_RtSearchCondImpl();
			rtCond.setSymm_id(csiList.get(c).getSymm_id());
			List<Collect_Symmetrix_Monitor_RtVWInfo> csmrList = getCollect_Symmetrix_Monitor_RtInfo(rtCond,csiList.get(c).getSymm_type());
			//���ݽ��������ƻ�ȡ��ֵ��Ϣ
			MonitorObjectDefVWSearchCondImpl moCond=new MonitorObjectDefVWSearchCondImpl();
			moCond.setMoName(csiList.get(c).getSymm_id());
			moCond.setDeleteFlag("0");
			List<MonitorObjectDefVWInfo> monitorObjectDefVWInfoList=this.monitorObjectDefVWBL.searchMonitorObjectDefVW(moCond);
			long rmax = 0l;
			long rmin = 0l;
			
			int bv = new Date().getHours()-1;
			for(int i=0;i<csmrList.size();i++){
				Collect_Symmetrix_Monitor_RtVWInfo csmr = csmrList.get(i);
				if(rmin>csmr.getSymthroughput().longValue()){
					rmin = csmr.getSymthroughput().longValue();
				}
				if(rmax<csmr.getSymthroughput().longValue()){
					rmax = csmr.getSymthroughput().longValue();
				}
				//�ж��Ƿ���ʾ��ֵ��
				if(!flagOne){
					if(monitorObjectDefVWInfoList!=null&&monitorObjectDefVWInfoList.size()>0){
						for(MonitorObjectDefVWInfo info:monitorObjectDefVWInfoList){
							if(info.getOrderNumber()==2){
								if(">=".equals(info.getCompare())){
									if(csmr.getSymthroughput().longValue()>=Long.parseLong(info.getModValue())){
										flagOne=true;
										flag = "<FLAG>true</FLAG>";
										flagValue = "<FLAGVALUE>"+info.getModValue()+"</FLAGVALUE>";
									}
								}
								if("<=".equals(info.getCompare())){
									if(csmr.getSymthroughput().longValue()<=Long.parseLong(info.getModValue())){
										flagOne=true;
										flag = "<FLAG>true</FLAG>";
										flagValue = "<FLAGVALUE>"+info.getModValue()+"</FLAGVALUE>";
									}
								}
							}
						}
					}
				}
				bv = Integer.valueOf(csmr.getSymtime());
				bottom = bottom+"<value>" + csmr.getSymtime() + "</value>";
				time = time + "<value>" + csmr.getFulltime() + "</value>";
				throughput = throughput+"<value>" + csmr.getSymthroughput() + "</value>";
			}
			//��С��8����ʱ
			int m = 8-csmrList.size();	
			for (int i = 0; i < m; i++) {
				bv = (++bv)%24;
				bottom = bv<10 ? bottom+"<value>" + "0"+bv + "</value>" :bottom+"<value>" + bv + "</value>";
				time = time + "<value></value>";
				throughput = throughput+"<value></value>";
			}	
			//��ѯ���������Ϣ
			CodeDetailSearchCondImpl cdcond = new CodeDetailSearchCondImpl();
			cdcond.setCvalue(csiList.get(c).getSymm_id());
			cdcond.setCdstatus("1");
			List<CodeDetail> cdList = codeDetailBL.searchCodeDetail(cdcond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
			if(cdList!=null&&cdList.size()>0){
				CodeDetail codeDetail = cdList.get(0);
				String hostid = codeDetail.getCcid()+"_"+codeDetail.getCid()+"_"+codeDetail.getSyscoding();
				content = content+"<REPORT>" + hostid + "</REPORT>";
			}else{
				content = content+"<REPORT>" + "false" + "</REPORT>";
			}
			content = content+"<HOST color='#000000'>" + csiList.get(c).getSymm_id() + "</HOST>";
			
			//����Y�����ֵ
			int n=0;
			while(rmax/new Double(Math.pow(10, n)).longValue()>100){
				n++;
			}
			rmax = (rmax/new Double(Math.pow(10, n)).longValue()+1)*new Double(Math.pow(10, n)).longValue();
			//����Y����Сֵ
			n=0;
			while(rmin/new Double(Math.pow(10, n)).longValue()>10){
				n++;
			}
			rmin = (rmin/new Double(Math.pow(10, n)).longValue())*new Double(Math.pow(10, n)).longValue();
			
			mmvalue = mmvalue+"<MAXVALUE>" + rmax + "</MAXVALUE>";
			mmvalue = mmvalue+"<MINVALUE>" + rmin + "</MINVALUE>";	

			bv = (++bv)%24;
			if(bv<10){
				bottom = bottom+"<value>" + "0"+bv + "</value>";
			}else{
				bottom = bottom+"<value>" + bv + "</value>";
			}
			bv = (++bv)%24;
			if(bv<10){
				bottom = bottom+"<value>" + "0"+bv + "</value>";
			}else{
				bottom = bottom+"<value>" + bv + "</value>";
			}
			bottom = bottom+"</BOTTOM>";
			time = time + "</TIME>";
			throughput = throughput+"</LINE>";		
		}
		//������״ν���dashboard
		else{
			Collect_Symmetrix_InfoSearchCondImpl infoCond = new Collect_Symmetrix_InfoSearchCondImpl();
			String[] symm_type={"Brocade","Mcdata"};
			infoCond.setSymm_typeStr(symm_type);
			List<Collect_Symmetrix_Info> csiList = collect_Symmetrix_InfoBL.findCollect_Symmetrix_InfoByCond(infoCond, 0, 0);
			if (csiList.size()>0) {
				
				Collect_Symmetrix_Monitor_RtSearchCondImpl rtCond = new Collect_Symmetrix_Monitor_RtSearchCondImpl();
				rtCond.setSymm_id(csiList.get(0).getSymm_id());
				List<Collect_Symmetrix_Monitor_RtVWInfo> csmrList = getCollect_Symmetrix_Monitor_RtInfo(rtCond,csiList.get(0).getSymm_type());
				//���ݽ��������ƻ�ȡ��ֵ��Ϣ
				MonitorObjectDefVWSearchCondImpl moCond=new MonitorObjectDefVWSearchCondImpl();
				moCond.setMoName(csiList.get(0).getSymm_id());
				moCond.setDeleteFlag("0");
				List<MonitorObjectDefVWInfo> monitorObjectDefVWInfoList=this.monitorObjectDefVWBL.searchMonitorObjectDefVW(moCond);
				long rmax = 0l;
				long rmin = 0l;
				int bv = new Date().getHours()-1;
				if(csmrList!=null&&csmrList.size()>0){
					for(int i=0;i<csmrList.size();i++){
						Collect_Symmetrix_Monitor_RtVWInfo csmr = csmrList.get(i);
						if(rmin>csmr.getSymthroughput().longValue()){
							rmin = csmr.getSymthroughput().longValue();
						}
						if(rmax<csmr.getSymthroughput().longValue()){
							rmax = csmr.getSymthroughput().longValue();
						}
						//�ж��Ƿ���ʾ��ֵ��
						if(!flagOne){
							if(monitorObjectDefVWInfoList!=null&&monitorObjectDefVWInfoList.size()>0){
								for(MonitorObjectDefVWInfo info:monitorObjectDefVWInfoList){
									if(info.getOrderNumber()==2){
										if(">=".equals(info.getCompare())){
											if(csmr.getSymthroughput().longValue()>=Long.parseLong(info.getModValue())){
												flagOne=true;
												flag = "<FLAG>true</FLAG>";
												flagValue = "<FLAGVALUE>"+info.getModValue()+"</FLAGVALUE>";
											}
										}
										if("<=".equals(info.getCompare())){
											if(csmr.getSymthroughput().longValue()<=Long.parseLong(info.getModValue())){
												flagOne=true;
												flag = "<FLAG>true</FLAG>";
												flagValue = "<FLAGVALUE>"+info.getModValue()+"</FLAGVALUE>";
											}
										}
									}
								}
							}else{
								flag = "<FLAG>false</FLAG>";
								flagValue = "<FLAGVALUE></FLAGVALUE>";
							}
						}
						bv = Integer.valueOf(csmr.getSymtime());
						bottom = bottom+"<value>" + csmr.getSymtime() + "</value>";
						time = time + "<value>" + csmr.getFulltime() + "</value>";
						throughput = throughput+"<value>" + csmr.getSymthroughput() + "</value>";
					}
				}else{
					flag = "<FLAG>false</FLAG>";
					flagValue = "<FLAGVALUE></FLAGVALUE>";
				}
				
				//��С��8����ʱ
				int m = 8-csmrList.size();
				for (int i = 0; i < m; i++) {
					bv = (++bv)%24;
					bottom = bv<10 ? bottom+"<value>" + "0"+bv + "</value>" :bottom+"<value>" + bv + "</value>";
					time = time + "<value></value>";
					throughput = throughput+"<value></value>";
				}
				//��ѯ���������Ϣ
				CodeDetailSearchCondImpl cdcond = new CodeDetailSearchCondImpl();
				cdcond.setCvalue(csiList.get(csiList.size()-1).getSymm_id());
				cdcond.setCdstatus("1");
				List<CodeDetail> cdList = codeDetailBL.searchCodeDetail(cdcond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
				if(cdList!=null&&cdList.size()>0){
					CodeDetail codeDetail = cdList.get(0);
					String hostid = codeDetail.getCcid()+"_"+codeDetail.getCid()+"_"+codeDetail.getSyscoding();
					content = content+"<REPORT>" + hostid + "</REPORT>";
				}else{
					content = content+"<REPORT>" + "false" + "</REPORT>";
				}
				content = content+"<HOST color='#000000'>" + csiList.get(0).getSymm_id() + "</HOST>";
				
				//����Y�����ֵ
				int n=0;
				while(rmax/new Double(Math.pow(10, n)).longValue()>100){
					n++;
				}
				rmax = (rmax/new Double(Math.pow(10, n)).longValue()+1)*new Double(Math.pow(10, n)).longValue();
				//����Y����Сֵ
				n=0;
				while(rmin/new Double(Math.pow(10, n)).longValue()>10){
					n++;
				}
				rmin = (rmin/new Double(Math.pow(10, n)).longValue())*new Double(Math.pow(10, n)).longValue();
				//����Y����Сֵ�����ֵ
				mmvalue = mmvalue+"<MAXVALUE>" + rmax + "</MAXVALUE>";
				mmvalue = mmvalue+"<MINVALUE>" + rmin + "</MINVALUE>";	

				bv = (++bv)%24;
				if(bv<10){
					bottom = bottom+"<value>" + "0"+bv + "</value>";
				}else{
					bottom = bottom+"<value>" + bv + "</value>";
				}
				bv = (++bv)%24;
				if(bv<10){
					bottom = bottom+"<value>" + "0"+bv + "</value>";
				}else{
					bottom = bottom+"<value>" + bv + "</value>";
				}
			}//�ж�Ϊ�ս���
			else{
				content = content+"<REPORT>" + "false" + "</REPORT>";
			}			
			bottom = bottom+"</BOTTOM>";	
			time = time + "</TIME>";
			throughput = throughput+"</LINE>";		
		}
		content = content+flag;
		content = content+flagValue;
		content = content+mmvalue;
		content = content+bottom;
		content = content+time;
		content = content+throughput;
		content = content+"</ROOT>";
		
		dto.setReadperWriteperHitper(content);
		
		return dto;
	}
	
	/**
	 * ����: ������ϸ��Ϣ
	 * @param  IGDBS01DTO dto
	 * @return ������ϸ��Ϣ
	 * @update baiyanfu_20120301_��ҳDashBoard��ֵ��ʾ
	 * @throws BLException
	 */
	public IGDBS01DTO  getHostInfo1(IGDBS01DTO dto) throws BLException{
		
		String symmid = dto.getSymmid();//��ǰѡ�����к�
		String hostchoose = dto.getHostchoose();//����ѡ��������ѡ��
		String content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
		
		//������ǵ�һ�ν���dashboard
		if(StringUtils.isNotEmpty(symmid)){
			Collect_Symmetrix_InfoSearchCondImpl infoCond = new Collect_Symmetrix_InfoSearchCondImpl();
			String[] symm_type={"IBM","DMX","CX"};
			infoCond.setSymm_typeStr(symm_type);
			List<Collect_Symmetrix_Info> csiList = collect_Symmetrix_InfoBL.findCollect_Symmetrix_InfoByCond(infoCond, 0, 0);
			
			int c=0;
			
			if("0".equals(hostchoose)){
				for(int i=0;i<csiList.size();i++){
					if(csiList.get(i).getSymm_id().equals(symmid)){
						c--;
						break;
					}
					c++;
				}
			}
			if("1".equals(hostchoose)){
				for(int i=0;i<csiList.size();i++){
					if(csiList.get(i).getSymm_id().equals(symmid)){
						c++;
						break;
					}
					c++;
				}
			}
				
			Collect_Symmetrix_Monitor_RtSearchCondImpl rtCond = new Collect_Symmetrix_Monitor_RtSearchCondImpl();
			if("CX".equalsIgnoreCase(csiList.get(c).getSymm_type())){
				rtCond.setSymm_id(csiList.get(c).getSymm_id()+"_SP A");
			}else{
				rtCond.setSymm_id(csiList.get(c).getSymm_id());
			}
			List<Collect_Symmetrix_Monitor_RtVWInfo> csmrList = getCollect_Symmetrix_Monitor_RtInfo(rtCond,csiList.get(c).getSymm_type());
			
			Collect_Symmetrix_Monitor_RtSearchCondImpl rtCondB = new Collect_Symmetrix_Monitor_RtSearchCondImpl();
			if("CX".equalsIgnoreCase(csiList.get(c).getSymm_type())){
				rtCondB.setSymm_id(csiList.get(c).getSymm_id()+"_SP B");
			}else{
				rtCondB.setSymm_id(csiList.get(c).getSymm_id());
			}
			List<Collect_Symmetrix_Monitor_RtVWInfo> csmrListB = getCollect_Symmetrix_Monitor_RtInfo(rtCondB,csiList.get(c).getSymm_type());
			if(c>0){
				content = content+"<UP>" + "true" + "</UP>";
			}else{
				content = content+"<UP>" + "false" + "</UP>";
			}
			
			if(c>=(csiList.size()-1)){
				content = content+"<DOWN>" + "false" + "</DOWN>";
			}
			else{
				content = content+"<DOWN>" + "true" + "</DOWN>";
			}
			
			//��ѯ���������Ϣ
			CodeDetailSearchCondImpl cdcond = new CodeDetailSearchCondImpl();
			cdcond.setCvalue(csiList.get(c).getSymm_id());
			cdcond.setCdstatus("1");
			List<CodeDetail> cdList = codeDetailBL.searchCodeDetail(cdcond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
			if(cdList!=null&&cdList.size()>0){
				CodeDetail codeDetail = cdList.get(0);
				String hostid = codeDetail.getCcid()+"_"+codeDetail.getCid()+"_"+codeDetail.getSyscoding();
				content = content+"<REPORT>" + hostid + "</REPORT>";
			}else{
				content = content+"<REPORT>" + "false" + "</REPORT>";
			}
			content = content+"<VERSION>V2</VERSION>";
			//ADD BY WANGLONGYU 20110805 ����getSymm_type�ж�����
			String type = csiList.get(c).getSymm_type() == null?"":csiList.get(c).getSymm_type();
			content = content+"<TYPE>"+type+"</TYPE>";
			content = content+"<HOST color='#000000' name='hostinfo1@Model'>" + csiList.get(c).getSymm_model() + "</HOST>";
			content = content+"<HOST color='#000000' name='hostinfo1@SN'>" + csiList.get(c).getSymm_id() + "</HOST>";
			content = content+"<HOST color='#000000' name='hostinfo1@MicrocodeVer'>" + csiList.get(c).getSymm_version() + "</HOST>";
			content = content+"<HOST color='#000000' name='hostinfo1@CacheSize'>" + csiList.get(c).getSymm_cachesize() + "</HOST>";
			if("CX".equalsIgnoreCase(type)){
				if (csmrList.size()>0&&csmrListB.size()>0) {
					content = content+"<HOST color='#000000' name='IOPS(SP A)��'>" + round(csmrList.get(csmrList.size()-1).getReadper().toString(), 2) + "</HOST>";
					content = content+"<HOST color='#000000' name='hostinfo1@Throughput(SP A)��'>" + round(csmrList.get(csmrList.size()-1).getWriteper().toString(), 2) + "</HOST>";
					content = content+"<HOST color='#000000' name='IOPS(SP B)��'>" + round(csmrListB.get(csmrListB.size()-1).getReadper().toString(), 2) + "</HOST>";
					content = content+"<HOST color='#000000' name='hostinfo1@Throughput(SP B)��'>" + round(csmrListB.get(csmrListB.size()-1).getWriteper().toString(), 2) + "</HOST>";
				}else{
					content = content+"<HOST color='#000000' name='IOPS(SP A)��'></HOST>";
					content = content+"<HOST color='#000000' name='hostinfo1@Throughput(SP A)��'></HOST>";
					content = content+"<HOST color='#000000' name='IOPS(SP B)��'></HOST>";
					content = content+"<HOST color='#000000' name='hostinfo1@Throughput(SP B)��'></HOST>";
				}
				content = content+"<HOST color='#000000' name=''></HOST>";
			}else{
				 //����ʾ����Ϣ��Ϊ0��ʱ
				if (csmrList.size()>0) {
				content = content+"<HOST color='#000000' name='hostinfo1@Reads'>" + round(csmrList.get(csmrList.size()-1).getReadper().toString(), 2) + "%</HOST>";
				content = content+"<HOST color='#000000' name='hostinfo1@Writes'>" + round(csmrList.get(csmrList.size()-1).getWriteper().toString(), 2) + "%</HOST>";
				content = content+"<HOST color='#000000' name='hostinfo1@Hit'>" + round(csmrList.get(csmrList.size()-1).getHitper().toString(), 2) + "%</HOST>";
				content = content+"<HOST color='#000000' name='hostinfo1@IOPS'>" + round(csmrList.get(csmrList.size()-1).getSymiops().toString(), 2) + "</HOST>";
				content = content+"<HOST color='#000000' name='hostinfo1@Transferred'>" + round(csmrList.get(csmrList.size()-1).getSymthroughput().toString(), 2) + "</HOST>";
				}else{
					content = content+"<HOST color='#000000' name='hostinfo1@Reads'>%</HOST>";
					content = content+"<HOST color='#000000' name='hostinfo1@Writes'>%</HOST>";
					content = content+"<HOST color='#000000' name='hostinfo1@Hit'>%</HOST>";
					content = content+"<HOST color='#000000' name='hostinfo1@IOPS'></HOST>";
					content = content+"<HOST color='#000000' name='hostinfo1@Transferred'></HOST>";	
				}
			}
		}
		//������״ν���dashboard
		else{
			Collect_Symmetrix_InfoSearchCondImpl infoCond = new Collect_Symmetrix_InfoSearchCondImpl();
			String[] symm_type={"IBM","DMX","CX"};
			infoCond.setSymm_typeStr(symm_type);
			List<Collect_Symmetrix_Info> csiList = collect_Symmetrix_InfoBL.findCollect_Symmetrix_InfoByCond(infoCond, 0, 0);
			
			if (csiList.size()>0) {
				
				Collect_Symmetrix_Monitor_RtSearchCondImpl rtCond = new Collect_Symmetrix_Monitor_RtSearchCondImpl();
				//CX���ʹ洢
				if("CX".equalsIgnoreCase(csiList.get(0).getSymm_type())){
					rtCond.setSymm_id(csiList.get(0).getSymm_id()+"_SP A");
				}else{
					rtCond.setSymm_id(csiList.get(0).getSymm_id());
				}
				List<Collect_Symmetrix_Monitor_RtVWInfo> csmrList = getCollect_Symmetrix_Monitor_RtInfo(rtCond,csiList.get(0).getSymm_type());
				
				Collect_Symmetrix_Monitor_RtSearchCondImpl rtCondB = new Collect_Symmetrix_Monitor_RtSearchCondImpl();
				//CX���ʹ洢
				if("CX".equalsIgnoreCase(csiList.get(0).getSymm_type())){
					rtCondB.setSymm_id(csiList.get(0).getSymm_id()+"_SP B");
				}else{
					rtCondB.setSymm_id(csiList.get(0).getSymm_id());
				}
				List<Collect_Symmetrix_Monitor_RtVWInfo> csmrListB = getCollect_Symmetrix_Monitor_RtInfo(rtCondB,csiList.get(0).getSymm_type());
    			
				content = content+"<UP>" + "false" + "</UP>";
				//�ж����ֻ��һ�����ݣ���������������ѡ��ť
				if(csiList.size()>1){
					content = content+"<DOWN>" + "true" + "</DOWN>";
				}
				else{
					content = content+"<DOWN>" + "false" + "</DOWN>";
				}
				
				//��ѯ���������Ϣ
				CodeDetailSearchCondImpl cdcond = new CodeDetailSearchCondImpl();
				cdcond.setCvalue(csiList.get(0).getSymm_id());
				cdcond.setCdstatus("1");
				List<CodeDetail> cdList = codeDetailBL.searchCodeDetail(cdcond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
				if(cdList!=null&&cdList.size()>0){
					CodeDetail codeDetail = cdList.get(0);
					String hostid = codeDetail.getCcid()+"_"+codeDetail.getCid()+"_"+codeDetail.getSyscoding();
					content = content+"<REPORT>" + hostid + "</REPORT>";
				}else{
					content = content+"<REPORT>" + "false" + "</REPORT>";
				}
				content = content+"<VERSION>V2</VERSION>";
				//ADD BY WANGLONGYU 20110805 ����getSymm_type�ж�����
				String type = csiList.get(0).getSymm_type() == null?"":csiList.get(0).getSymm_type();
				content = content+"<TYPE>"+type+"</TYPE>";
				content = content+"<HOST color='#000000' name='hostinfo1@Model'>" + csiList.get(0).getSymm_model() + "</HOST>";
				
				content = content+"<HOST color='#000000' name='hostinfo1@SN'>" + csiList.get(0).getSymm_id() + "</HOST>";
				content = content+"<HOST color='#000000' name='hostinfo1@MicrocodeVer'>" + csiList.get(0).getSymm_version() + "</HOST>";
				content = content+"<HOST color='#000000' name='hostinfo1@CacheSize'>" + csiList.get(0).getSymm_cachesize() + "</HOST>";
				if("CX".equalsIgnoreCase(type)){
					if (csmrList.size()>0&&csmrListB.size()>0) {
						content = content+"<HOST color='#000000' name='IOPS(SP A)��'>" + round(csmrList.get(0).getReadper().toString(), 2) + "</HOST>";
						content = content+"<HOST color='#000000' name='hostinfo1@Throughput(SP A)��'>" + round(csmrList.get(0).getWriteper().toString(), 2) + "</HOST>";
						content = content+"<HOST color='#000000' name='IOPS(SP B)��'>" + round(csmrListB.get(0).getReadper().toString(), 2) + "</HOST>";
						content = content+"<HOST color='#000000' name='hostinfo1@Throughput(SP B)��'>" + round(csmrListB.get(0).getWriteper().toString(), 2) + "</HOST>";
					}else{
						content = content+"<HOST color='#000000' name='IOPS(SP A)��'></HOST>";
						content = content+"<HOST color='#000000' name='hostinfo1@Throughput(SP A)��'></HOST>";
						content = content+"<HOST color='#000000' name='IOPS(SP B)��'></HOST>";
						content = content+"<HOST color='#000000' name='hostinfo1@Throughput(SP B)��'></HOST>";
					}
					content = content+"<HOST color='#000000' name=''></HOST>";
				}else{
					 //����ʾ����Ϣ��Ϊ0��ʱ
					if (csmrList.size()>0) {
					content = content+"<HOST color='#000000' name='hostinfo1@Reads'>" + round(csmrList.get(0).getReadper().toString(), 2) + "%</HOST>";
					content = content+"<HOST color='#000000' name='hostinfo1@Writes'>" + round(csmrList.get(0).getWriteper().toString(), 2) + "%</HOST>";
					content = content+"<HOST color='#000000' name='hostinfo1@Hit'>" + round(csmrList.get(0).getHitper().toString(), 2) + "%</HOST>";
					content = content+"<HOST color='#000000' name='hostinfo1@IOPS'>" + round(csmrList.get(0).getSymiops().toString(), 2) + "</HOST>";
					content = content+"<HOST color='#000000' name='hostinfo1@Transferred'>" + round(csmrList.get(0).getSymthroughput().toString(), 2) + "</HOST>";
					}else{
						content = content+"<HOST color='#000000' name='hostinfo1@Reads'>%</HOST>";
						content = content+"<HOST color='#000000' name='hostinfo1@Writes'>%</HOST>";
						content = content+"<HOST color='#000000' name='hostinfo1@Hit'>%</HOST>";
						content = content+"<HOST color='#000000' name='hostinfo1@IOPS'></HOST>";
						content = content+"<HOST color='#000000' name='hostinfo1@Transferred'></HOST>";	
					}
				}
				
			}//�ж�����Ϊ�ս���
			else{
				content = content+"<UP>" + "false" + "</UP>";
				content = content+"<DOWN>" + "false" + "</DOWN>";
				content = content+"<REPORT>" + "false" + "</REPORT>";
			}			
		}
		content = content+"</ROOT>";
		dto.setHostInfo(content);
		return dto;
	}
	/**
	 * ����: ��������ϸ��Ϣ
	 * @param  IGDBS01DTO dto
	 * @return ��������ϸ��Ϣ
	 * @update baiyanfu_20120301_��ҳDashBoard��ֵ��ʾ
	 * @throws BLException
	 */
	public IGDBS01DTO  getHostInfo2(IGDBS01DTO dto) throws BLException{
		
		String symmid = dto.getSymmid();//��ǰѡ�����к�
		String hostchoose = dto.getHostchoose();//����ѡ��������ѡ��
		String content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
		
		//������ǵ�һ�ν���dashboard
		if(StringUtils.isNotEmpty(symmid)){
			Collect_Symmetrix_InfoSearchCondImpl infoCond = new Collect_Symmetrix_InfoSearchCondImpl();
			String[] symm_type={"Brocade","Mcdata"};
			infoCond.setSymm_typeStr(symm_type);
			List<Collect_Symmetrix_Info> csiList = collect_Symmetrix_InfoBL.findCollect_Symmetrix_InfoByCond(infoCond, 0, 0);
			
			int c=0;
			
			if("0".equals(hostchoose)){
				for(int i=0;i<csiList.size();i++){
					if(csiList.get(i).getSymm_id().equals(symmid)){
						c--;
						break;
					}
					c++;
				}
			}
			if("1".equals(hostchoose)){
				for(int i=0;i<csiList.size();i++){
					if(csiList.get(i).getSymm_id().equals(symmid)){
						c++;
						break;
					}
					c++;
				}
			}
			
			Collect_Symmetrix_Monitor_RtSearchCondImpl rtCond = new Collect_Symmetrix_Monitor_RtSearchCondImpl();
			rtCond.setSymm_id(csiList.get(c).getSymm_id());
			List<Collect_Symmetrix_Monitor_RtVWInfo> csmrList = getCollect_Symmetrix_Monitor_RtInfo(rtCond,csiList.get(c).getSymm_type());
			
			if(c>0){
				content = content+"<UP>" + "true" + "</UP>";
			}else{
				content = content+"<UP>" + "false" + "</UP>";
			}
			
			if(c>=(csiList.size()-1)){
				content = content+"<DOWN>" + "false" + "</DOWN>";
			}else{
				content = content+"<DOWN>" + "true" + "</DOWN>";
			}
			
			//��ѯ���������Ϣ
			CodeDetailSearchCondImpl cdcond = new CodeDetailSearchCondImpl();
			cdcond.setCvalue(csiList.get(c).getSymm_id());
			cdcond.setCdstatus("1");
			List<CodeDetail> cdList = codeDetailBL.searchCodeDetail(cdcond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
			if(cdList!=null&&cdList.size()>0){
				CodeDetail codeDetail = cdList.get(0);
				String hostid = codeDetail.getCcid()+"_"+codeDetail.getCid()+"_"+codeDetail.getSyscoding();
				content = content+"<REPORT>" + hostid + "</REPORT>";
			}else{
				content = content+"<REPORT>" + "false" + "</REPORT>";
			}
			content = content+"<VERSION>V2</VERSION>";
			//ADD BY WANGLONGYU 20110805 ����getSymm_type�ж�����
			String type = csiList.get(c).getSymm_type() == null?"":csiList.get(c).getSymm_type();
			content = content+"<TYPE>"+type+"</TYPE>";
			content = content+"<HOST color='#000000'>" + csiList.get(c).getSymm_model() + "</HOST>";
			content = content+"<HOST color='#000000'>" + csiList.get(c).getSymm_id() + "</HOST>";
			
			 //����ʾ����Ϣ��Ϊ0��ʱ
			if (csmrList.size()>0) {
				content = content+"<HOST color='#000000'>" + round(csmrList.get(csmrList.size()-1).getSymiops().toString(), 2) + "</HOST>";
				content = content+"<HOST color='#000000'>" + round(csmrList.get(csmrList.size()-1).getSymthroughput().toString(), 2) + "</HOST>";
			}else{
				content = content+"<HOST color='#000000'></HOST>";
				content = content+"<HOST color='#000000'></HOST>";	
			}
		}
		//������״ν���dashboard
		else{
			Collect_Symmetrix_InfoSearchCondImpl infoCond = new Collect_Symmetrix_InfoSearchCondImpl();
			String[] symm_type={"Brocade","Mcdata"};
			infoCond.setSymm_typeStr(symm_type);
			List<Collect_Symmetrix_Info> csiList = collect_Symmetrix_InfoBL.findCollect_Symmetrix_InfoByCond(infoCond, 0, 0);
			
            if (csiList.size()>0) {
            	
            	Collect_Symmetrix_Monitor_RtSearchCondImpl rtCond = new Collect_Symmetrix_Monitor_RtSearchCondImpl();
    			rtCond.setSymm_id(csiList.get(0).getSymm_id());
    			List<Collect_Symmetrix_Monitor_RtVWInfo> csmrList = getCollect_Symmetrix_Monitor_RtInfo(rtCond,csiList.get(0).getSymm_type());
    			
    			content = content+"<UP>" + "false" + "</UP>";
				//�ж����ֻ��һ�����ݣ���������������ѡ��ť
				if(csiList.size()>1){
					content = content+"<DOWN>" + "true" + "</DOWN>";
				}
				else{
					content = content+"<DOWN>" + "false" + "</DOWN>";
				}
    			
    			//��ѯ���������Ϣ
    			CodeDetailSearchCondImpl cdcond = new CodeDetailSearchCondImpl();
    			cdcond.setCvalue(csiList.get(0).getSymm_id());
    			cdcond.setCdstatus("1");
    			List<CodeDetail> cdList = codeDetailBL.searchCodeDetail(cdcond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
    			if(cdList!=null&&cdList.size()>0){
    				CodeDetail codeDetail = cdList.get(0);
    				String hostid = codeDetail.getCcid()+"_"+codeDetail.getCid()+"_"+codeDetail.getSyscoding();
    				content = content+"<REPORT>" + hostid + "</REPORT>";
    			}else{
    				content = content+"<REPORT>" + "false" + "</REPORT>";
    			}
    			content = content+"<VERSION>V2</VERSION>";
    			//ADD BY WANGLONGYU 20110805 ����getSymm_type�ж�����
    			String type = csiList.get(csiList.size()-1).getSymm_type() == null?"":csiList.get(csiList.size()-1).getSymm_type();
    			content = content+"<TYPE>"+type+"</TYPE>";
    			content = content+"<HOST color='#000000'>" + csiList.get(0).getSymm_model() + "</HOST>";
    			content = content+"<HOST color='#000000'>" + csiList.get(0).getSymm_id() + "</HOST>";
    			
    			 //����ʾ����Ϣ��Ϊ0��ʱ
    			if (csmrList.size()>0) {
	    			content = content+"<HOST color='#000000'>" + csmrList.get(csmrList.size()-1).getSymiops().toString() + "</HOST>";
	    			content = content+"<HOST color='#000000'>" + csmrList.get(csmrList.size()-1).getSymthroughput().toString() + "</HOST>";
    			}else{
    				content = content+"<HOST color='#000000'></HOST>";
    				content = content+"<HOST color='#000000'></HOST>";
    			}
			}//����Ϊ���жϽ���
            else{
            	content = content+"<DOWN>" + "false" + "</DOWN>";
            	content = content+"<UP>" + "false" + "</UP>";
            	content = content+"<REPORT>" + "false" + "</REPORT>";
            }		
		}
		content = content+"</ROOT>";
		dto.setHostInfo(content);
		return dto;
	}
	
	/**
	 * ���ر���ȡ�������
	 * @param doubleValue ����ȡ������
	 * @param scale С�������λ��
	 * @return
	 */
	public static Double round(String doubleValue, int scale){ 
		Double value = null; 
		String text = doubleValue; 
		BigDecimal bd=new BigDecimal(text).setScale(scale, BigDecimal.ROUND_HALF_UP); 
		value = bd.doubleValue(); 
		return value; 
	}
	
	/**
	 * �õ�SYMMETRIX��ʵʱ������Ϣ
	 * @param total
	 * @return
	 * @throws Exception
	 */
	private Collect_Symmetrix_Monitor_RtTB getData(String total,String timestamp,String symm_id,String uptime) throws Exception{
		//String nowTime = IGStringUtils.getCurrentDateTime();
		String nowTime = uptime.substring(0,4)+"/"+uptime.substring(4,6)+"/"+uptime.substring(6,8)+" "+uptime.substring(8,10)+":"+uptime.substring(10);
		
		
		Collect_Symmetrix_Monitor_RtTB symm = new Collect_Symmetrix_Monitor_RtTB();
		symm.setSavetime(nowTime);
		symm.setSymm_id(symm_id);
		symm.setTimestamp(timestamp);
		symm.setReads_per_sec(new BigDecimal(getDoubleValueAfterFormat(total.split(" ")[1].trim(),"")));
		symm.setWrites_per_sec(new BigDecimal(getDoubleValueAfterFormat(total.split(" ")[2].trim(),"")));
		symm.setKbytes_read_per_sec(new BigDecimal(getDoubleValueAfterFormat(total.split(" ")[3].trim(),"")));
		symm.setKbytes_written_per_sec(new BigDecimal(getDoubleValueAfterFormat(total.split(" ")[4].trim(),"")));
		symm.setHits_read_per_sec(new BigDecimal(getDoubleValueAfterFormat(total.split(" ")[5].trim(),"percent")));//%
		symm.setHits_written_per_sec(new BigDecimal(getDoubleValueAfterFormat(total.split(" ")[6].trim(),"percent")));//%
//		symm.setSeq_read_per_sec(new BigDecimal(getDoubleValueAfterFormat(total.split(" ")[7].trim(),"percent")));//%
//		symm.setSeq_written_per_sec(new BigDecimal(getDoubleValueAfterFormat(total.split(" ")[8].trim(),"percent")));//%
//		symm.setNumber_write_pending_tracks(new BigDecimal(getDoubleValueAfterFormat(total.split(" ")[9].trim(),"")));
		
		
		return symm;
	}
	
	/**
	 * ���浽DB��
	 */
	private boolean insertToDB(List<Collect_Symmetrix_Monitor_Rt> smrtList) throws Exception{
		boolean flag = true;
		if(smrtList!=null){
			for(Collect_Symmetrix_Monitor_Rt smrt:smrtList){
				Collect_Symmetrix_Monitor_Rt crt = collect_Symmetrix_Monitor_RtBL.saveCollect_Symmetrix_Monitor_Rt(smrt);
				if(crt==null || crt.getId()==null){
					flag = false;
					break;
				}
			}
		}else{
			flag = false;
		}
		
		return flag;
	}
	
	/**
	 * DashBoard����ʵʱ���ݵ���
	 */
	public List<Collect_Symmetrix_Monitor_Rt> getSymmetrixMonitorData(){
		//��װ����
		List<Collect_Symmetrix_Monitor_Rt> dataListAll = new ArrayList<Collect_Symmetrix_Monitor_Rt>();
		try{
			//log.debug("DashBoard����ʵʱ���ݽ�����ʼ......");
			
			String confPath = ResourceUtility.getString("DashBoardRT");// �����ļ�
			
			//��ȡ������Ϣ
			InputStream ins = new BufferedInputStream(new FileInputStream(new File(confPath)));
			Properties pros = new Properties();
			pros.load(ins);
			String filepath = pros.getProperty("DATA.PATH");//Ҫ����������ļ�·��
			
			List<String> filenameList = new ArrayList<String>();

			File sourcefiledir = new File(filepath);
			
			if(sourcefiledir.isDirectory()){
				File[] files = sourcefiledir.listFiles();
				if(files!=null && files.length>0){
					//ѭ�����������ļ�
					for(int a=0,b=files.length;a<b;a++){
						
						File modelfile = files[a];
						//�жϸ������ļ��Ƿ��Ѿ�������
						if(filenameList.contains(modelfile.getName())){
							continue;
						}
						filenameList.add(modelfile.getName());
						String dirname = modelfile.getName().split("\\.txt")[0];//�ļ�����
						String symm_id = dirname.split("_")[1];
						String time_interval = dirname.split("_")[2];
						String uptime = dirname.split("_")[3];//
						if(modelfile.getName().split("\\.").length==2 && "txt".equals(modelfile.getName().split("\\.")[1])){

							FileInputStream fis = new FileInputStream(modelfile);
							BufferedReader in = new BufferedReader(new InputStreamReader(fis));
					
							int line_num = 0;
							String total = "";
							String str = null;
							Map<Integer,String> map = new LinkedHashMap<Integer, String>();
							while((str = in.readLine())!=null){
								if((str.toUpperCase()).indexOf("TOTAL")!=-1){
									String  regEx="[' ']+";   //һ�������ո�   
							        Pattern p = Pattern.compile(regEx);   
							        Matcher m = p.matcher(str);   
							        String newtemp = m.replaceAll(" ");//�滻Ϊһ���ո�
							        String[] temps = newtemp.split(" ");
									if(temps!=null && temps.length>1 && "TOTAL".equals(temps[0].trim().toUpperCase())){
										total = newtemp.replace("N/A", "0");
										
										if(line_num%2==0){
											map.put(0, total);//������2��
											
										}else{
											map.put(1, total);//������1��
											
										}
										
										line_num++;
									}
								}
							}
							
//							Set<Map.Entry<Integer,String>> set = map.entrySet();
//							for(Iterator<Map.Entry<Integer,String>> iter = set.iterator();iter.hasNext();){
//								Map.Entry<Integer,String> entry = iter.next();
//								
//							}
							
							boolean flag = true;//ɾ���ļ���ʶ
							if(map.size()>0){
								//��ֻ��1��TOTAL����ʱ
								if(map.size()==1){
									map.put(1, map.get(0));//��������1�����ݸ�ֵ��index 1
								}
								
								//��װ����
								List<Collect_Symmetrix_Monitor_Rt> dataList = new ArrayList<Collect_Symmetrix_Monitor_Rt>();
								if(map.size()>0){
									//������2������
									//dataList.add(checkData(map.get(0),));
									
									//������1������
									dataList.add(getData(map.get(1),time_interval,symm_id,uptime));
									
								}
								dataListAll.addAll(dataList);
								flag = insertToDB(dataList);
								
								
								
								//System.out.println("------������2��total------"+map.get(0));
								log.debug("------������1��total------"+map.get(1));
								
							}
							
							
							in.close();
							fis.close();
							
							if(flag){
								//ɾ���������������ļ�
								modelfile.delete();
							}else{
								//��ǰ���ݿ����ӳ����쳣,�ļ��������´�ִ��ʱ�ٵ���
								break;
							}

						}

						log.debug(dirname+"������ɡ�");
						
						
					}
				}else{
					//log.debug("����ʵʱ���ݲ�����......");
				}
				
				
			}
		}catch(Exception e ){
			e.printStackTrace();
		}
		return dataListAll;
	}
	
	/**
	 * ���ɸ澯��Ϣ
	 * @param dataList
	 */
	public void getWarnInfo(List<Collect_Symmetrix_Monitor_Rt> dataList) throws BLException{
		//��ֵ��Ϣ����
		List<MonitorObjectDefVWInfo> monitorObjectDefVWInfoList=new ArrayList<MonitorObjectDefVWInfo>();
		//�澯��Ϣ����
		List<SOC0305Info> storageEventInfoList=new ArrayList<SOC0305Info>();
		if(dataList!=null&&dataList.size()>0){
			String symm_id=dataList.get(0).getSymm_id();
			for(Collect_Symmetrix_Monitor_Rt rt:dataList){
				//����ֵ��ϢΪ��ʱ
				if(monitorObjectDefVWInfoList.size()==0||!symm_id.equals(rt.getSymm_id())){
					//���¸�ֵsymm_id
					symm_id=rt.getSymm_id();
					//���ݴ洢���Ƽ����洢�ķ�ֵ��Ϣ
					MonitorObjectDefVWSearchCondImpl cond=new MonitorObjectDefVWSearchCondImpl();
					cond.setMoName(rt.getSymm_id());
					cond.setDeleteFlag("0");
					monitorObjectDefVWInfoList=this.monitorObjectDefVWBL.searchMonitorObjectDefVW(cond);
				}
				//���洢��ֵ��Ϣ����ʱ
				if(monitorObjectDefVWInfoList!=null&&monitorObjectDefVWInfoList.size()>0){
					for(MonitorObjectDefVWInfo monitorObjectDefVWInfo:monitorObjectDefVWInfoList){
						//��ȡ�澯��Ϣ
						storageEventInfoList=getStorageEventInfoOne(rt,monitorObjectDefVWInfo,storageEventInfoList);
					}
				}
			}
			//����澯��Ϣ
			if(storageEventInfoList!=null&&storageEventInfoList.size()>0){
				for(int i=0;i<storageEventInfoList.size();i++){
					this.soc0305BL.registSoc0305(storageEventInfoList.get(i));
				}
			}
		}
	}
	
	/**
	 * ��ȡ�澯��Ϣ
	 * @param rt
	 * @param monitorObjectDefVWInfo
	 * @param storageEventInfoList
	 * @return
	 */
	public List<SOC0305Info> getStorageEventInfoOne(Collect_Symmetrix_Monitor_Rt rt,
			MonitorObjectDefVWInfo monitorObjectDefVWInfo,List<SOC0305Info> storageEventInfoList) throws BLException{
		BigDecimal iopsValue = rt.getReads_per_sec().add(rt.getWrites_per_sec());
		//����ֵΪIOPSʱ
		if(monitorObjectDefVWInfo.getOrderNumber()==1){
			if(">=".equals(monitorObjectDefVWInfo.getCompare())){
				if(iopsValue.longValue()>=Double.valueOf(monitorObjectDefVWInfo.getModValue())){
					storageEventInfoList=getStorageEventInfo(rt,monitorObjectDefVWInfo,storageEventInfoList,iopsValue.longValue());
				}
			}else{
				if(iopsValue.longValue()<=Double.valueOf(monitorObjectDefVWInfo.getModValue())){
					storageEventInfoList=getStorageEventInfo(rt,monitorObjectDefVWInfo,storageEventInfoList,iopsValue.longValue());
				}
			}
		}
		BigDecimal throughput=rt.getKbytes_read_per_sec().add(rt.getKbytes_written_per_sec());
		//����ֵΪ������ʱ
		if(monitorObjectDefVWInfo.getOrderNumber()==2){
			if(">=".equals(monitorObjectDefVWInfo.getCompare())){
				if(throughput.longValue()>=Double.valueOf(monitorObjectDefVWInfo.getModValue())){
					storageEventInfoList=getStorageEventInfo(rt,monitorObjectDefVWInfo,storageEventInfoList,throughput.longValue());
				}
			}else{
				if(throughput.longValue()<=Double.valueOf(monitorObjectDefVWInfo.getModValue())){
					storageEventInfoList=getStorageEventInfo(rt,monitorObjectDefVWInfo,storageEventInfoList,throughput.longValue());
				}
			}
		}
		//����ֵΪ������ʱ
		BigDecimal readper=iopsValue.doubleValue() == 0 ? new BigDecimal("0.000000") : new BigDecimal("100").multiply((rt.getReads_per_sec()).divide(iopsValue,MathContext.DECIMAL32));
		if(monitorObjectDefVWInfo.getOrderNumber()==3){
			if(">=".equals(monitorObjectDefVWInfo.getCompare())){
				if(readper.longValue()>=Double.valueOf(monitorObjectDefVWInfo.getModValue())){
					storageEventInfoList=getStorageEventInfo(rt,monitorObjectDefVWInfo,storageEventInfoList,readper.longValue());
				}
			}else{
				if(readper.longValue()<=Double.valueOf(monitorObjectDefVWInfo.getModValue())){
					storageEventInfoList=getStorageEventInfo(rt,monitorObjectDefVWInfo,storageEventInfoList,readper.longValue());
				}
			}
		}
		//����ֵΪд����ʱ
		BigDecimal writeper=iopsValue.doubleValue() == 0 ? new BigDecimal("0.000000") : new BigDecimal("100").multiply((rt.getWrites_per_sec()).divide(iopsValue,MathContext.DECIMAL32));
		if(monitorObjectDefVWInfo.getOrderNumber()==4){
			if(">=".equals(monitorObjectDefVWInfo.getCompare())){
				if(writeper.longValue()>=Double.valueOf(monitorObjectDefVWInfo.getModValue())){
					storageEventInfoList=getStorageEventInfo(rt,monitorObjectDefVWInfo,storageEventInfoList,writeper.longValue());
				}
			}else{
				if(writeper.longValue()<=Double.valueOf(monitorObjectDefVWInfo.getModValue())){
					storageEventInfoList=getStorageEventInfo(rt,monitorObjectDefVWInfo,storageEventInfoList,writeper.longValue());
				}
			}
		}
		//����ֵΪ����������ʱ
		BigDecimal hitper=iopsValue.doubleValue() == 0 ? 
				new BigDecimal("0.000000") : new BigDecimal("100").multiply((rt.getWrites_per_sec().multiply(rt.getHits_written_per_sec())).add(rt.getReads_per_sec().multiply(rt.getHits_read_per_sec()))).divide(iopsValue,MathContext.DECIMAL32);
		if(monitorObjectDefVWInfo.getOrderNumber()==5){
			if(">=".equals(monitorObjectDefVWInfo.getCompare())){
				if(hitper.longValue()>=Double.valueOf(monitorObjectDefVWInfo.getModValue())){
					storageEventInfoList=getStorageEventInfo(rt,monitorObjectDefVWInfo,storageEventInfoList,hitper.longValue());
				}
			}else{
				if(hitper.longValue()<=Double.valueOf(monitorObjectDefVWInfo.getModValue())){
					storageEventInfoList=getStorageEventInfo(rt,monitorObjectDefVWInfo,storageEventInfoList,hitper.longValue());
				}
			}
		}
		return storageEventInfoList;
	}
	
	/**
	 * ��ȡ�澯��Ϣ
	 * @param rt
	 * @param monitorObjectDefVWInfo
	 * @param storageEventInfoList
	 * @return
	 */
	public List<SOC0305Info> getStorageEventInfo(Collect_Symmetrix_Monitor_Rt rt,
			MonitorObjectDefVWInfo monitorObjectDefVWInfo,List<SOC0305Info> storageEventInfoList,Long nowValue) throws BLException{
		//TTP��Դ�ļ�
		Properties properties = this.getProperties();
		
		//�澯����
		String severity  = properties.getProperty("SEVERITY");
		SOC0305TB storageEventTB=new SOC0305TB();
		storageEventTB.setEirootmark(rt.getSymm_id());//�澯����
		storageEventTB.setErrordesc(monitorObjectDefVWInfo.getModDes()+"("+nowValue.toString()+")");//�澯����
		storageEventTB.setAlarmType("2");//�澯����
		storageEventTB.setImptypeid(3);//�澯��������
		storageEventTB.setState("0");
		storageEventTB.setStatus("0");//����״̬
		storageEventTB.setSeverity(severity);//�澯����
		storageEventTB.setFru2Loc(IGStringUtils.getCurrentDateTime());
		storageEventTB.setDetectiontime(IGStringUtils.getCurrentDateTime());//�澯ʱ��
		storageEventInfoList.add(storageEventTB);
		
		//���slug����
		String syslog = properties.getProperty("SYSLOG");
		if("TRUE".equals(syslog)){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm");
			try {
				log.info("SOC|+|NA|+|NA|+|NA|+|NA|+|"+storageEventTB.getEirootmark()+"|+|NATURE|+|"+monitorObjectDefVWInfo.getModName()+"|+|"+nowValue+
						"|+|DMX�洢|+|NA|+|NA|+|"+storageEventTB.getSeverity().toUpperCase()+"-4|+|"+storageEventTB.getErrordesc()+"|+|"+sdf.parse(storageEventTB.getDetectiontime()).getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		return storageEventInfoList;
	}
	
	/**
	 * ��ȡTTP��Դ�ļ�
	 * @return
	 * @throws BLException
	 */
	private Properties getProperties() throws BLException {
		//TTP��Դ�ļ�
		Properties properties = null;
		//������
		FileInputStream inputFile = null;
		//���������ļ�
		try {
			properties = new Properties();
			inputFile = new FileInputStream(ResourceUtility.getString("TTP_FILE_FILE_PATH"));
			properties.load(inputFile);
		} catch (FileNotFoundException e) {
			log.error("TTP��Դ�ļ���ȡ����", e);
			throw new BLException("IGDBM01BLImpl.E001");
		} catch (IOException e) {
			log.error("TTP��Դ�ļ���ȡ����", e);
			throw new BLException("IGDBM01BLImpl.E001");
		} finally {
			if(inputFile != null) {
				try {
					inputFile.close();
				} catch (IOException e) {
					log.error("TTP��Դ�ļ���ȡ����", e);
					throw new BLException("IGDBM01BLImpl.E001");
				}
			}
		}
		return properties;
	}
			
	
	
	/**
	 * ȡ��Double���͵����ݣ�����ʽ��Ϊ6λС��
	 */
	private String getDoubleValueAfterFormat(String value,String unit) throws Exception{
		if(StringUtils.isNotEmpty(value) && "0".equals(value)){
			return "0";
		}else if(StringUtils.isNotEmpty(value)){
			DecimalFormat df=new DecimalFormat("#.000000"); 
			String d = df.format((round(value, 6)));
			if("percent".equals(unit)){
				//�ٷ�����Ҫ����100
				d = getDivide(d,"100");
			}
			return d;
		}else{
			return "0";
		}
		
	}
	
	/**
	 * ���ش������֮��
	 * @return
	 */
	private String getDivide(String bd1,String bd2){
		
		if(StringUtils.isNotEmpty(bd1) && StringUtils.isNotEmpty(bd2) && !"0".equals(bd2) && !"0.0".equals(bd2)){
			BigDecimal bd1_b = new BigDecimal(bd1); 
			BigDecimal bd2_b = new BigDecimal(bd2); 
//			System.out.println("--������--"+bd1);
//			System.out.println("--����--"+bd2);
			return String.valueOf(bd1_b.divide(bd2_b,MathContext.DECIMAL32));
		}else{
			return "0";
		}
		
	}
	/**
	 * ȡ��Collect_Symmetrix_Monitor_Rt���ж�Ӧ�洢�����8Сʱ��ʾ����
	 * @param cond
	 * @return
	 */
	private List<Collect_Symmetrix_Monitor_RtVWInfo> getCollect_Symmetrix_Monitor_RtInfo(Collect_Symmetrix_Monitor_RtSearchCondImpl cond, String serverType){
		List<Collect_Symmetrix_Monitor_RtVWInfo> lstCSMRVW = new ArrayList<Collect_Symmetrix_Monitor_RtVWInfo>();
		
		SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date d = collect_Symmetrix_Monitor_RtBL.getMaxSaveTimeRT(cond);
		
		String date_from = sdfTime.format(new Date(d.getTime()+1000-8*61*59*1000));
		cond.setSavetime(date_from);
		List<Collect_Symmetrix_Monitor_Rt> lstCSMR  = collect_Symmetrix_Monitor_RtBL.findByCond(cond);
		Collect_Symmetrix_Monitor_Rt csmr = null;
		Collect_Symmetrix_Monitor_RtVW csmrVW = null;
		BigDecimal maxValue = null;
		Map<String, Integer> mapTime2Num = new HashMap<String, Integer>();
		for(int i = 0; i < 8; i++)
		{
			Collect_Symmetrix_Monitor_RtVW csmrVWNULL = new Collect_Symmetrix_Monitor_RtVW();
			csmrVWNULL.setSymtime(getStartTime(date_from, i));
			csmrVWNULL.setFulltime(csmrVWNULL.getSymtime()+":00");
			csmrVWNULL.setSymiops(new BigDecimal("0.000000"));
			csmrVWNULL.setSymthroughput(new BigDecimal("0.000000"));
			csmrVWNULL.setReadper(new BigDecimal("0.000000"));
			csmrVWNULL.setWriteper(new BigDecimal("0.000000"));
			csmrVWNULL.setHitper(new BigDecimal("0.000000"));
			lstCSMRVW.add(csmrVWNULL);
			mapTime2Num.put(getStartTime(date_from, i), i);
		}
		if("DMX".equalsIgnoreCase(serverType))
		{
			for(int i = 0, j = lstCSMR.size(); i < j; i++)
			{
				csmr = lstCSMR.get(i);
				String dateTime = getCurrentTime(csmr.getSavetime());
				int iNumInList = mapTime2Num.get(dateTime);
				maxValue = lstCSMRVW.get(iNumInList).getSymiops();
				BigDecimal tempValue = csmr.getReads_per_sec().add(csmr.getWrites_per_sec());
				if(tempValue.subtract(maxValue).doubleValue() >= 0)
				{
					maxValue = tempValue;
					csmrVW = new Collect_Symmetrix_Monitor_RtVW();
					csmrVW.setSymtime(dateTime);
					csmrVW.setFulltime(getFullTime(csmr.getSavetime()));
					csmrVW.setSymiops(maxValue);
					csmrVW.setSymthroughput(csmr.getKbytes_read_per_sec().add(csmr.getKbytes_written_per_sec()));
					csmrVW.setReadper(maxValue.doubleValue() == 0 ? new BigDecimal("0.000000") : new BigDecimal("100").multiply((csmr.getReads_per_sec()).divide(maxValue,MathContext.DECIMAL32)));
					csmrVW.setWriteper(maxValue.doubleValue() == 0 ? new BigDecimal("0.000000") : new BigDecimal("100").multiply((csmr.getWrites_per_sec()).divide(maxValue,MathContext.DECIMAL32)));
					csmrVW.setHitper(maxValue.doubleValue() == 0 ? new BigDecimal("0.000000") : new BigDecimal("100").multiply((csmr.getWrites_per_sec().multiply(csmr.getHits_written_per_sec())).add(csmr.getReads_per_sec().multiply(csmr.getHits_read_per_sec()))).divide(maxValue,MathContext.DECIMAL32));
					lstCSMRVW.set(iNumInList, csmrVW);
				}
			}
		}
		if("IBM".equalsIgnoreCase(serverType))
		{
			for(int i = 0, j = lstCSMR.size(); i < j; i++)
			{
				csmr = lstCSMR.get(i);
				String dateTime = getCurrentTime(csmr.getSavetime());
				int iNumInList = mapTime2Num.get(dateTime);
				csmrVW = new Collect_Symmetrix_Monitor_RtVW();
				BigDecimal tempValue = csmr.getKbytes_read_per_sec().add(csmr.getKbytes_written_per_sec());
				csmrVW.setSymtime(dateTime);
				csmrVW.setFulltime(StringUtils.isEmpty(getFullTime(csmr.getSavetime()))? csmrVW+":00" : getFullTime(csmr.getSavetime()));
				csmrVW.setSymiops(csmr.getReads_per_sec());
				csmrVW.setSymthroughput(csmr.getWrites_per_sec());
				csmrVW.setReadper(tempValue.doubleValue() == 0 ? new BigDecimal("0.000000") : new BigDecimal("100").multiply((csmr.getKbytes_read_per_sec()).divide(tempValue,MathContext.DECIMAL32)));
				csmrVW.setWriteper(tempValue.doubleValue() == 0 ? new BigDecimal("0.000000") : new BigDecimal("100").multiply((csmr.getKbytes_written_per_sec()).divide(tempValue,MathContext.DECIMAL32)));
				csmrVW.setHitper(csmr.getHits_read_per_sec());
				lstCSMRVW.set(iNumInList, csmrVW);
			}
		}
		if("Brocade".equalsIgnoreCase(serverType))
		{
			for(int i = 0, j = lstCSMR.size(); i < j; i++)
			{
				csmr = lstCSMR.get(i);
				String dateTime = getCurrentTime(csmr.getSavetime());
				int iNumInList = mapTime2Num.get(dateTime);
				csmrVW = new Collect_Symmetrix_Monitor_RtVW();
				csmrVW.setSymtime(dateTime);
				csmrVW.setFulltime(StringUtils.isEmpty(getFullTime(csmr.getSavetime()))? csmrVW+":00" : getFullTime(csmr.getSavetime()));
				csmrVW.setSymiops(csmr.getReads_per_sec());
				csmrVW.setSymthroughput(csmr.getWrites_per_sec());
				lstCSMRVW.set(iNumInList, csmrVW);
			}
		}
		if("Mcdata".equalsIgnoreCase(serverType))
		{
			for(int i = 0, j = lstCSMR.size(); i < j; i++)
			{
				csmr = lstCSMR.get(i);
				String dateTime = getCurrentTime(csmr.getSavetime());
				int iNumInList = mapTime2Num.get(dateTime);
				csmrVW = new Collect_Symmetrix_Monitor_RtVW();
				csmrVW.setSymtime(dateTime);
				csmrVW.setFulltime(StringUtils.isEmpty(getFullTime(csmr.getSavetime()))? csmrVW+":00" : getFullTime(csmr.getSavetime()));
				csmrVW.setSymiops(csmr.getReads_per_sec());
				csmrVW.setSymthroughput(csmr.getWrites_per_sec());
				lstCSMRVW.set(iNumInList, csmrVW);
			}
		}
		if("CX".equalsIgnoreCase(serverType))
		{
			for(int i = 0, j = lstCSMR.size(); i < j; i++)
			{
				csmr = lstCSMR.get(i);
				String dateTime = getCurrentTime(csmr.getSavetime());
				int iNumInList = mapTime2Num.get(dateTime);
				csmrVW = new Collect_Symmetrix_Monitor_RtVW();
				csmrVW.setSymtime(dateTime);
				csmrVW.setFulltime(StringUtils.isEmpty(getFullTime(csmr.getSavetime()))? csmrVW+":00" : getFullTime(csmr.getSavetime()));
				csmrVW.setSymiops(csmr.getWrites_per_sec());
				csmrVW.setSymthroughput(csmr.getReads_per_sec());
				csmrVW.setReadper(csmr.getWrites_per_sec());
				csmrVW.setWriteper(csmr.getReads_per_sec());
				csmrVW.setHitper(BigDecimal.valueOf(0));
				lstCSMRVW.set(iNumInList, csmrVW);
			}
		}
      	return lstCSMRVW;		
	}
	
	/**
	 * ȡ�ò���time�� ����ʱ�䣨Сʱ���֣�
	 * @param time 2011/11/11 12:30 ����ʱ��
	 * @return
	 */
	private String getFullTime(String time){
		if(StringUtils.isEmpty(time))
		{
			return "";
		}
		return time.substring(11, 16);
	}
	
	/**
	 * ȡ��time����������ʱ��
	 * @param time 2011/11/11 12:30 ����ʱ��
	 * @return
	 */
	private String getCurrentTime(String time){
		if(StringUtils.isEmpty(time))
		{
			return "";
		}
		return time.substring(11, 13);
	}
	
	/**
	 * ���ݲ���ȡ�õ�ǰӦ����ʾ������ʱ��
	 * @param startTime ʱ��
	 * @param num �Ӻ�Сʱ��
	 * @return
	 */
	private String getStartTime(String startTime, int num){
		if(num == 0){
			// ֱ��ȡ��startTime������ʱ��
			return startTime.substring(11, 13);
		}
		else
		{
			//���ݲ��� num ����startTime������ʱ��num��Сʱ�������ʱ��
			int time = Integer.parseInt(startTime.substring(11, 13)) + num ;
			if(time > 23)
			{
				time = time - 24;
			}
			//ת��Ϊ�ַ�������
			String nowTime = String.valueOf(time);
			if(nowTime.length() == 1)
			{
				nowTime = "0" + nowTime;
			}
			return nowTime;
		}
	}

	public IGDBS01DTO getPieAll(IGDBS01DTO dto) throws BLException {
		log.debug("---��ѯ�洢��ͼALL��ʼ---");
		SOC0118SearchCondImpl eicond=new SOC0118SearchCondImpl();
		eicond.setEsyscoding_eq("999001009001");//only dmx
		List<SOC0118Info> list_ei=soc0118BL.searchEntityItem(eicond);
		List<SOC0411Info> list=soc0411BL.searchSOC0411();
		String pieXmlStr="";
		double sumStorage=0.0;
		if(list.size()>0){
			List<SOC0411Info> tmplist=new ArrayList<SOC0411Info>();
			for (SOC0411Info scinfo:list){
				for (SOC0118Info eiinfo:list_ei){
					if(eiinfo.getEiname().equals(scinfo.getSName())){
						sumStorage+=scinfo.getRawCapacity();
						tmplist.add(scinfo);
						break;
					}
				}
			}
			list=tmplist;
			if(list.size()>0){
				pieXmlStr+="<?xml version='1.0' encoding='utf-8'?>";
				pieXmlStr+="<ROOT>";
				pieXmlStr+="<DATA value='    pie@total    #"+mBToTB(sumStorage,2)+"(TB)'>";
				for(int i = 0; i < list.size(); i++){
					pieXmlStr+="<STORAGE name='"+list.get(i).getSName()+"' "+
					"label='"+list.get(i).getSName()+"' "+
					"text='pie@sid:"+list.get(i).getSName()+"#pie@rawcap: "+mBToTB(list.get(i).getRawCapacity(),2)+" TB#pie@eff: "+mBToTB(list.get(i).getEffectiveCapacity(),2)+" TB#pie@alloc: "+mBToTB(list.get(i).getAllottedCapacity(),2)+" TB#pie@free: "+mBToTB(list.get(i).getFreeCapacity(),2)+" TB#' "+
					"pietext='"+SVCHelper.round(SVCHelper.getDivide(list.get(i).getRawCapacity(), sumStorage)*100, 2)+"%'>";
					pieXmlStr+="<VOLUME category='EffCap' value='"+mBToTB(list.get(i).getEffectiveCapacity(),2)+"' text='pie@eff:"+mBToTB(list.get(i).getEffectiveCapacity(),2)+"(TB)' />";
					pieXmlStr+="<VOLUME category='RedunCap' value='"+mBToTB(list.get(i).getRedundancyCapacity(),2)+"' text='pie@redundant:"+mBToTB(list.get(i).getRedundancyCapacity(),2)+"(TB)' />";
					pieXmlStr+="</STORAGE>";
				}
				pieXmlStr+="</DATA>";
				pieXmlStr+="</ROOT>";
			}
		}
		dto.setPieall(pieXmlStr);
		log.debug("---��ѯ�洢��ͼALL����---");
		return dto;
	}

	//
	public IGDBS01DTO getWarningList(IGDBS01DTO dto) throws BLException {
		//20120704���� �澯��ʾ
		log.debug("---��ѯ�澯��Ϣ��ʼ---");
		String resxml = "";
		SOC0305SearchCondImpl second=new SOC0305SearchCondImpl();
		second.setStatus("0");//ֻ��δ����
		List<SOC0305Info> list=soc0305BL.searchSoc0305(second, 0, 30);
		if(list.size()>0){
			for (int i = 0; i < list.size(); i++) {
				resxml+="<DG>";
				resxml+="<STORAGE>"+list.get(i).getEirootmark()+"</STORAGE>";//�洢id
				resxml+="<TYPE>"+getWarningType(list.get(i).getAlarmType())+"</TYPE>";//�澯����1:�¼�2:����
				
				String detectiontime="";
				detectiontime=list.get(i).getDetectiontime();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
				
					try {
						detectiontime=sdf.format(sdf.parse(detectiontime));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				resxml+="<WETIME>"+detectiontime+"</WETIME>";//�澯ʱ��
				resxml+="<WELV>"+list.get(i).getSeverity()+"</WELV>";//�澯�ȼ�
				resxml+="</DG>";
			}
		}
		dto.setWarninglist(resxml);
		log.debug("---��ѯ�澯��Ϣ����---");
		return dto;
	}
	private String getWarningType(String type){
		int intype=Integer.parseInt(type);
		if(intype==1){
			return "pie.datagrid.type1";
		}else if(intype==2){
			return "pie.datagrid.type2";
		}else{
			return "pie.datagrid.type3";
		}
		
	}
	
    private String mBToTB(double d,int scale){
    	double tmp=d;
    	tmp=SVCHelper.getDivide(tmp, 1024);
    	tmp=SVCHelper.getDivide(tmp, 1024);
    	tmp=SVCHelper.round(tmp, scale);
    	return String.valueOf(tmp);
    }    
    private String mBToTB(int d,int scale){
    	double tmp=d;
    	tmp=SVCHelper.getDivide(tmp, 1024);
    	tmp=SVCHelper.getDivide(tmp, 1024);
    	tmp=SVCHelper.round(tmp, scale);
    	return String.valueOf(tmp);
    }
}

