/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
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
 * ����:��ع���ҵ��ӿ�ʵ����
 * ����������
 * ������¼�����    2012/02/09
 */
public class IGMNT01BLImpl extends BaseBLImpl implements IGMNT01BL{

	static Log log = LogFactory.getLog(IGMNT01BLImpl.class);
	
	protected MessageResources resources = MessageResources.getMessageResources("com.deliverik.infogovernor.soc.mnt.mntResources");
	
	/**
	 * DMXʵʱ
	 */
	protected SOC0301BL soc0301BL;	
	
	/** 
	 * �������BL
	 */
	protected MonitorTypeBL monitorTypeBL;
	
	/**
	 * ������ͷ�ֵ��ϢBL
	 */
	protected MonitorTypeDefBL monitorTypeDefBL;
	
	/**
	 * ��ض�����ϢBL
	 */
	protected MonitorObjectBL monitorObjectBL;
	/**
	 * debug�������BL
	 */
	protected SOC0304BL soc0304BL;
	
	/**
	 * debug����������BL
	 */
	protected MonitorTaskObjectBL monitorTaskObjectBL;
	/**
	 * ��ض���ֵ��ϢBL
	 */
	protected MonitorObjectDefBL monitorObjectDefBL;
	/**
	 * ��ȡ�����Ӷ���BL
	 */
	protected Object_ListBL object_ListBL;
	
	protected Collect_Symmetrix_InfoBL collect_Symmetrix_InfoBL;
	
	protected SOC0117BL soc0117BL;
	
	/** EntityItemBL */
	protected SOC0118BL soc0118BL;
	
	/** ��������BL */
	protected CodeDetailBL codeDetailBL;
	
	/** ������ϢBL */
	protected ReportFileDefinitionBL reportFileDefinitionBL;
	
	/** ����汾BL */
	protected ReportFileVersionBL reportFileVersionBL;
	
	/** �Զ�����BL */
	protected SOC0203BL soc0203BL;
	
	/** ��������BL */
	protected SOC0423BL soc0423BL;
	


	/**
	 *  �Զ�����BL�趨
	 * @param soc0203BL
	 */
	public void setSoc0203BL(SOC0203BL soc0203BL) {
		this.soc0203BL = soc0203BL;
	}

	/**
	 * ������ϢBL�趨
	 * @param reportFileDefinitionBL
	 */
	public void setReportFileDefinitionBL(
			ReportFileDefinitionBL reportFileDefinitionBL) {
		this.reportFileDefinitionBL = reportFileDefinitionBL;
	}

	

	/**
	 * ��ȡ�����Ӷ���BL�趨
	 *
	 * @param object_ListBL ��ȡ�����Ӷ���BL
	 */
	public void setObject_ListBL(Object_ListBL object_ListBL) {
		this.object_ListBL = object_ListBL;
	}


	/**
	 * debug����������BL�趨
	 *
	 * @param monitorTaskObjectBL debug����������BL
	 */
	public void setMonitorTaskObjectBL(MonitorTaskObjectBL monitorTaskObjectBL) {
		this.monitorTaskObjectBL = monitorTaskObjectBL;
	}

	/**
	 * ����汾BL�趨
	 * @param reportFileVersionBL
	 */
	public void setReportFileVersionBL(ReportFileVersionBL reportFileVersionBL) {
		this.reportFileVersionBL = reportFileVersionBL;
	}

	/**
	 * ��������BL�趨
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
	 * �������BL�趨
	 * @param monitorTypeBL
	 */
	public void setMonitorTypeBL(MonitorTypeBL monitorTypeBL) {
		this.monitorTypeBL = monitorTypeBL;
	}
	
	/**
	 * ������ͷ�ֵ��ϢBL�趨
	 * @param monitorTypeDefBL
	 */
	public void setMonitorTypeDefBL(MonitorTypeDefBL monitorTypeDefBL) {
		this.monitorTypeDefBL = monitorTypeDefBL;
	}

	/**
	 * ��ض�����ϢBL�趨
	 * @param monitorObjectBL
	 */
	public void setMonitorObjectBL(MonitorObjectBL monitorObjectBL) {
		this.monitorObjectBL = monitorObjectBL;
	}

	/**
	 * ��ض���ֵ��ϢBL�趨
	 * @param monitorObjectDefBL
	 */
	public void setMonitorObjectDefBL(MonitorObjectDefBL monitorObjectDefBL) {
		this.monitorObjectDefBL = monitorObjectDefBL;
	}
    protected SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	/**
	 * ��ع�����������ѯ
	 */
	public IGMNT01DTO searchMonitorTypeTreeAction(IGMNT01DTO dto)
			throws BLException {
		log.debug("========������ͷ�������ѯ����ʼ========");
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		List<MonitorTypeInfo> monitorTypeList = monitorTypeBL.searchMonitorType();
		for (MonitorTypeInfo monitorTypeInfo : monitorTypeList) {
			String mtSyscoding = monitorTypeInfo.getMtSyscoding();
			//����볤�ȵ���3λ�Ǹ��ڵ�
			if(mtSyscoding.length()==3){
				TreeNode pNode = new TreeNode();
				pNode.setId(String.valueOf(monitorTypeInfo.getMtId()));
				pNode.setName(monitorTypeInfo.getMtName());
				//��Ӻ��ӽ��
				int nowlen = mtSyscoding.length();
				getChildTreeNodeMap(monitorTypeList,pNode,nowlen,mtSyscoding);
				treeNodeMap.put(pNode.getId(),pNode);
			}
		}
		dto.setTreeNodeMap(treeNodeMap);
		
		log.debug("========�����������ѯ�������========");
		return dto;
	}
	
	/**
	 * <p>
	 * ��ѯ�ӽ��
	 * </p>
	 * @param ȫ���Ľ��LIST
	 * @param �ü������ϼ����
	 * @param �ü������ϼ�����syscoding�ĳ���
	 */
	private void getChildTreeNodeMap(List<MonitorTypeInfo> monitorTypeList,TreeNode ptNode,int ptlen,String syscoding){
		List<MonitorTypeInfo> nextcode = getNextLevelNodes(monitorTypeList,ptlen,syscoding);//ȡ�øü�����LIST
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
	 * ȡ��һlevel�Ľ�㼯��
	 * </p>
	 * @param ȫ���Ľ��LIST
	 * @param ��ǰ����len
	 * @param ��ǰ����syscode
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
	 * ������ͷ�ֵ��ѯ
	 */
	public IGMNT01DTO searchMonitorTypeDefAction(IGMNT01DTO dto)
			throws BLException {
		MonitorTypeDefSearchCondImpl cond=new MonitorTypeDefSearchCondImpl();
		cond.setMtId(String.valueOf(dto.getIgmnt0102Form().getMtId()));
		//�������id��ѯ��ֵ����
		List<MonitorTypeDefInfo> monitorTypeDefList = monitorTypeDefBL.searchMonitorTypeDef(cond);
		dto.setMonitorTypeDefInfoList(monitorTypeDefList);
		return dto;
	}

	/**
	 * ������ͷ�ֵ����
	 */
	public void updateMonitorTypeDefAction(IGMNT01DTO dto)
			throws BLException {
		IGMNT0102Form igmnt0102Form = dto.getIgmnt0102Form();
		String[] mtdValue = igmnt0102Form.getMtdValue();//��ֵ����
		String[] mtdId = igmnt0102Form.getMtdId();//������ͷ�ֵid����
		String[] compare = igmnt0102Form.getCompare();//�ȽϷ�
		String[] deleteFlag = igmnt0102Form.getDeleteFlag();//״̬
		String[] mtdDes = igmnt0102Form.getMtdDes();//�澯����
		int mtId = igmnt0102Form.getMtId();
		
		//���¼�����ͷ�ֵ��Ϣ
		for (int i=0;i<mtdId.length;i++) {
			MonitorTypeDefInfo monitorTypeDefInfo = monitorTypeDefBL.searchMonitorTypeDefByPK(Integer.valueOf(mtdId[i]));
			MonitorTypeDefTB monitorTypeDef=copyMonitorTypeDefInfo(monitorTypeDefInfo);//����������ͷ�ֵ��Ϣ
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
	 * ����������ͷ�ֵ��Ϣ
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
	 * ������Ͳ�ѯ
	 */
	public IGMNT01DTO searchMonitorTypeAction(IGMNT01DTO dto)
			throws BLException {
		List<MonitorTypeInfo> monitorTypeList = monitorTypeBL.searchMonitorType();//��ѯȫ���������
		List<LabelValueBean> newMonitorTypeList=new ArrayList<LabelValueBean>();
		newMonitorTypeList.add(new LabelValueBean("",""));
		for (MonitorTypeInfo monitorTypeInfo : monitorTypeList) {
			String mtSyscoding = monitorTypeInfo.getMtSyscoding();
			if(mtSyscoding.length()>3&&!mtSyscoding.startsWith("003")){//����볤�ȴ���3��Ҫ��ص�����
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
	 * ��ض���Ǽ�
	 */
	public IGMNT01DTO insertMonitorObject(IGMNT01DTO dto) throws BLException {
		IGMNT0103Form form = dto.getIgmnt0103Form();
		String moName = form.getSymm_id();//��ض�������
		String ip = form.getIp();//ip��ַ
		String mtId = form.getMtId();//�������id
		String[] deleteFlag = form.getModDeleteFlag();//״̬����
		String[] modValue = form.getModValue();//��ֵ����
		
		MonitorObjectSearchCondImpl cond=new MonitorObjectSearchCondImpl();
		cond.setMoName(moName);
		List<MonitorObjectInfo> monitorObjectList = monitorObjectBL.searchMonitorObject(cond);
		if(monitorObjectList!=null&&monitorObjectList.size()>0){
			throw new BLException("IGMNT0103.E001");
		}
		
		//���ݼ������id��ȡ�����
		MonitorTypeInfo monitorType = monitorTypeBL.searchMonitorTypeByPK(Integer.valueOf(mtId));
		String mtSyscoding = monitorType.getMtSyscoding();
		
		//��ض���Ǽ�
		MonitorObjectTB mo=new MonitorObjectTB();
		mo.setMoName(moName);
		mo.setIp(ip);
		mo.setMtSyscoding(mtSyscoding);
		mo.setDeleteFlag("0");
		mo.setMoCreateTime(IGStringUtils.getCurrentDateTime());
		MonitorObjectInfo monitorObject = monitorObjectBL.registMonitorObject(mo);
		
		// ��ض�����Ϣ
		dto.addMessage(new ActionMessage("IGCO10000.I004", resources
				.getMessage(dto.getLocale(), "message.IGMNT01BLImpl.001")));
		
		//���ݼ������id��ȡ������ͷ�ֵ����
		MonitorTypeDefSearchCondImpl mtdCond=new MonitorTypeDefSearchCondImpl();
		mtdCond.setMtId(String.valueOf(mtId));
		List<MonitorTypeDefInfo> monitorTypeDefList = monitorTypeDefBL.searchMonitorTypeDef(mtdCond);
		//��ض���ֵ��Ϣ�Ǽ�
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
	 * ��ض����ѯ
	 */
	public IGMNT01DTO searchMonitorObjectAction(IGMNT01DTO dto)
			throws BLException {
		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		//formȡ��
		IGMNT0104Form igmnt0104Form = dto.getIgmnt0104Form();
		//�������Idȡ��
		String mtId = igmnt0104Form.getMtId_eq();
		//����ʱ���ȡ��
		String moCreateTime_from = igmnt0104Form.getMoCreateTime_from();
		//����ʱ�䵽ȡ��
		String moCreateTime_to = igmnt0104Form.getMoCreateTime_to();
		//��ض�������ȡ��
		String moName = igmnt0104Form.getMoName_eq();
		
		String mtSyscoding="";
		if(StringUtils.isNotEmpty(mtId)){
			//�������ȡ��
			MonitorTypeInfo monitorType = monitorTypeBL.searchMonitorTypeByPK(Integer.valueOf(mtId));
			//�����ȡ��
			mtSyscoding = monitorType.getMtSyscoding();
		}
		
		MonitorObjectSearchCondImpl cond=new MonitorObjectSearchCondImpl();
		cond.setMtSyscoding(mtSyscoding);
		cond.setMoName(moName);
		cond.setMoCreateTime_from(moCreateTime_from);
		cond.setMoCreateTime_to(moCreateTime_to);
		
		int totalCount = monitorObjectBL.getSearchCount(cond);
		if (totalCount == 0) {
			log.debug("========��ض��󲻴���========");
			// ��ض��󲻴���
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));

			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ض������ݼ�������========");
			// ��ض������ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));

			return dto;
		}
		//��ȡ��ض�������
		List<MonitorObjectInfo> monitorObjectList = monitorObjectBL.searchMonitorObject(cond,pDto.getFromCount(),pDto.getPageDispCount());
		dto.setMonitorObjectList(monitorObjectList);
		
		pDto.setTotalCount(totalCount);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		return dto;
	}

	/**
	 * ��ض���������ѯ
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
	 * ��ض���ֵ��Ϣ��ѯ
	 */
	public IGMNT01DTO searchMonitorObjectDefAction(IGMNT01DTO dto)
			throws BLException {
		IGMNT0103Form igmnt0103Form = dto.getIgmnt0103Form();
		//��ض���id
		String moId = igmnt0103Form.getMoId();
		MonitorObjectDefSearchCondImpl cond=new MonitorObjectDefSearchCondImpl();
		cond.setMoId(moId);
		//ȡ�ü�ض���ֵ����
		List<MonitorObjectDefInfo> monitorObjectDefList = monitorObjectDefBL.searchMonitorObjectDef(cond);
		dto.setMonitorObjectDefList(monitorObjectDefList);
		return dto;
	}

	/**
	 * ��ض����޸�
	 */
	public void updateMonitorObjectAction(IGMNT01DTO dto) throws BLException {
		IGMNT0103Form form = dto.getIgmnt0103Form();
		String moId = form.getMoId();
		MonitorObjectInfo monitorObject = monitorObjectBL.searchMonitorObjectByPK(Integer.valueOf(moId));
		
		//����collect_Symmetrix_Info��
		Collect_Symmetrix_InfoTB collect_Symmetrix_InfoTB = monitorObject.getCollect_Symmetrix_InfoTB();
		if(collect_Symmetrix_InfoTB!=null){
			collect_Symmetrix_InfoTB.setSymm_model(form.getSymm_model());
			collect_Symmetrix_InfoTB.setSymm_version(form.getSymm_version());
			collect_Symmetrix_InfoTB.setSymm_cachesize(form.getSymm_cachesize());
			collect_Symmetrix_InfoBL.updateCollect_Symmetrix_Info(collect_Symmetrix_InfoTB);
		}
		
		//��ض������
		MonitorObjectTB mo=new MonitorObjectTB();
		mo.setMoId(monitorObject.getMoId());
		mo.setDeleteFlag(monitorObject.getDeleteFlag());
		mo.setIp(form.getIp());
		mo.setMoCreateTime(monitorObject.getMoCreateTime());
		mo.setMoName(form.getSymm_id());
		String mtId = form.getMtId();//��ȡ�������id
		
		//���ݼ������idȡ�ü�����Ͳ����
		MonitorTypeInfo monitorType = monitorTypeBL.searchMonitorTypeByPK(Integer.valueOf(mtId));
		String mtSyscoding = monitorType.getMtSyscoding();
		mo.setMtSyscoding(mtSyscoding);
		monitorObjectBL.updateMonitorObject(mo);
		
		//��ض���ɷ�ֵɾ��
		MonitorObjectDefSearchCondImpl modCond=new MonitorObjectDefSearchCondImpl();
		modCond.setMoId(moId);
		List<MonitorObjectDefInfo> monitorObjectDefList = monitorObjectDefBL.searchMonitorObjectDef(modCond);
		for (MonitorObjectDefInfo monitorObjectDefInfo : monitorObjectDefList) {
			monitorObjectDefBL.deleteMonitorObjectDef(monitorObjectDefInfo);
		}
		
		//��ض����·�ֵ����
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
	 * ��ض���״̬�޸�
	 */
	public void updateMonitorObjectStatusAction(IGMNT01DTO dto)
			throws BLException {
		IGMNT0104Form form = dto.getIgmnt0104Form();
		String moId = form.getMoId();//ȡ�ü�ض���id
		String deleteFlag = form.getDeleteFlag();//ȡ�ü�ض���Ҫ�޸ĵ�״̬
		MonitorObjectInfo monitorObject = monitorObjectBL.searchMonitorObjectByPK(Integer.valueOf(moId));
		MonitorObjectTB mo = copyMonitorObject(monitorObject);
		mo.setDeleteFlag(deleteFlag);
		monitorObjectBL.updateMonitorObject(mo);
		
		//��ض�����ֵ��Ϣ״̬�޸�
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
	 * ����MonitorObjectTB
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
	 * ����MonitorObjectDefTB
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
	 * ��ض������Ʋ�ѯ
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
	 * <p> ��ѯ�ʲ�ģ������ </p>
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
	 * �ʲ�����Ϣ��ѯ
	 * 
	 * @param dto
	 *            IGMNT01DTO
	 * @return IGMNT01DTO
	 */
	public IGMNT01DTO searchEntityItemAction(IGMNT01DTO dto) throws BLException
	{

		log.debug("========�ʲ���HELP��ѯ����ʼ========");

		// ��ѯ����ȡ��
		int totalCount = this.soc0118BL.getEntityItemVWSearchCount(dto
				.getEntityItemVWSearchCond());

		if (totalCount == 0)
		{
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount())
		{
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
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

		log.debug("========�ʲ���HELP��ѯ��������========");
		return dto;
	}

	/**
	 * ���������������
	 */
	public MonitorTypeInfo searchMonitorTypeByPK(IGMNT01DTO dto)
			throws BLException {
		MonitorTypeInfo monitorType = monitorTypeBL.searchMonitorTypeByPK(Integer.valueOf(dto.getMtId()));
		return monitorType;
	}
	
	/**
	 * �洢�ǼǴ���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO insertSymmInfoAction(IGMNT01DTO dto) throws BLException {
		log.debug("========�洢��Ϣ�ǼǴ���ʼ========");
		// ����Formȡ��
		IGMNT0103Form form = dto.getIgmnt0103Form();
		
		//��Ӵ洢������Ϣ
		this.collect_Symmetrix_InfoBL.saveCollect_Symmetrix_Info(form);
		
		// �洢������Ϣ
		//dto.addMessage(new ActionMessage("IGCO10000.I004", resources.getMessage(dto.getLocale(), "message.IGASM26BLImpl.001")));
		log.debug("========�洢��Ϣ�ǼǴ�������========");
		return dto;
	}

	/**
	 * �洢CodeDetail����Ϣ��Ӵ���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO insertCodeDetailInfoAction(IGMNT01DTO dto)
			throws BLException {
		log.debug("========�洢CodeDetail����Ϣ��Ӵ���ʼ========");
		IGMNT0103Form form=dto.getIgmnt0103Form();
		//��ȡ���CID
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
				//��ӱ��������
				this.codeDetailBL.registCodeDetail(codeDetailTB);
				dto.setSyscoding(syscoding);
			}
		}
		log.debug("========�洢CodeDetail����Ϣ��Ӵ�������========");
		return dto;
	}
	
	/**
	 * ��Integer���͵�cidת����String����
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
	 * ��ȡ�ô洢���͵ı���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO searchCodeDetailListActioin(IGMNT01DTO dto)
			throws BLException {
		log.debug("========��ȡ�ô洢���͵ı�����ʼ========");
		IGMNT0103Form form=dto.getIgmnt0103Form();
		CodeDetailSearchCondImpl codeDetailSearchCond=new CodeDetailSearchCondImpl();
		//���洢����ΪDMXʱ
		if(EntityItemKeyWords.SYMM_DMX.equals(form.getSymm_type())){
			codeDetailSearchCond.setCcid(EntityItemKeyWords.SYMM_DMX_CCID);
		}
		//���洢����ΪIBMʱ
		if(EntityItemKeyWords.SYMM_IBM.equals(form.getSymm_type())){
			codeDetailSearchCond.setCcid(EntityItemKeyWords.SYMM_IBM_CCID);
		}
		//���洢����ΪCXʱ
		if(EntityItemKeyWords.SYMM_CX.equals(form.getSymm_type())){
			codeDetailSearchCond.setCcid(EntityItemKeyWords.SYMM_CX_CCID);
		}
		//������������ΪBrocadeʱ
		if(EntityItemKeyWords.SYMM_BROCADE.equals(form.getSymm_type())){
			codeDetailSearchCond.setCcid(EntityItemKeyWords.SYMM_BROCADE_CCID);
		}
		//������������ΪMcdataʱ
		if(EntityItemKeyWords.SYMM_MCDATA.equals(form.getSymm_type())){
			codeDetailSearchCond.setCcid(EntityItemKeyWords.SYMM_MCDATA_CCID);
		}
		//���洢����ΪHDSʱ
		if(EntityItemKeyWords.SYMM_HDS.equals(form.getSymm_type())){
			codeDetailSearchCond.setCcid(EntityItemKeyWords.SYMM_HDS_CCID);
		}
		List<CodeDetail> codeDetailList=this.codeDetailBL.searchCodeDetail(codeDetailSearchCond, 0);
		if(codeDetailList!=null&&codeDetailList.size()>0){
			dto.setCodeDetailList(codeDetailList);
		}
		log.debug("========��ȡ�ô洢���͵ı���������========");
		return dto;
	}

	/**
	 * �Զ�������Ӵ���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO registSOC0203Action(IGMNT01DTO dto)
			throws BLException {
		log.debug("========�Զ�������Ӵ���ʼ========");
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
		log.debug("========�Զ�������Ӵ�������========");
		return dto;
	}

	/**
	 * ��ͨ������Ӵ���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO registReportFileDefinitionAction(IGMNT01DTO dto)
			throws BLException {
		log.debug("========��ͨ������Ӵ���ʼ========");
		IGMNT0103Form form=dto.getIgmnt0103Form();
		CodeDetail codeDetailInfo=dto.getCodeDetailInfo();
		//������ͨ����ʱ
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
		reportFileDefinitionTB.setRfddesc(codeDetailInfo.getCdinfo());//��������
		//ִ�б�����Ϣ���
		ReportFileDefinition reportFileDefinition=this.reportFileDefinitionBL.registReportFileDefinition(reportFileDefinitionTB);
		ReportFileVersionTB reportFileVersionTB=new ReportFileVersionTB();
		reportFileVersionTB.setRfvid(reportFileDefinition.getRfdid());
		reportFileVersionTB.setRfdid(reportFileDefinition.getRfdid());
		reportFileVersionTB.setRfvversion(1);
		reportFileVersionTB.setRfvinstime(IGStringUtils.getCurrentDateTime());
		//ִ�б���汾��Ϣ���
		this.reportFileVersionBL.registReportFileVersion(reportFileVersionTB);
		log.debug("========��ͨ������Ӵ�������========");
		return dto;
	}

	/**
	 * �洢������Ϣɾ������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO deleteSymmInfoAction(IGMNT01DTO dto) throws BLException {
		log.debug("========�洢��Ϣɾ������ʼ========");
		//Formȡ��
		IGMNT0104Form form=dto.getIgmnt0104Form();
		String moId = form.getMoId();
		MonitorObjectInfo monitorObject = monitorObjectBL.searchMonitorObjectByPK(Integer.valueOf(moId));
		Collect_Symmetrix_InfoTB collect_Symmetrix_InfoTB = monitorObject.getCollect_Symmetrix_InfoTB();
		if(collect_Symmetrix_InfoTB!=null){
			this.collect_Symmetrix_InfoBL.deleteCollect_Symmetrix_Info(collect_Symmetrix_InfoTB);
		}
		log.debug("========�洢��Ϣɾ����������========");
		return dto;
	}

	/**
	 * ��ض������ɾ������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO deleteSymmOtherInfoAction(IGMNT01DTO dto)
			throws BLException {
		log.debug("========�洢������Ϣɾ������ʼ========");
		//Formȡ��
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
						//ɾ������İ汾
						this.reportFileVersionBL.deleteReportFileVersion(reportFileDefinitionList.get(i).getRfdid());
						//ɾ��������Ϣ
						this.reportFileDefinitionBL.deleteReportFileDefinition(reportFileDefinitionList.get(i).getRfdid());
					}
				}
				//ɾ��CodeDetail�еĴ洢��Ϣ
				this.codeDetailBL.deleteCodeDetail(codeDetailList.get(0));
			}
			//ɾ���Զ�����
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
		log.debug("========�洢������Ϣɾ����������========");
		return dto;
	}

	/**
	 * ɾ����ض���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO deleteMonitorObject(IGMNT01DTO dto) throws BLException {
		IGMNT0104Form form = dto.getIgmnt0104Form();
		String moId = form.getMoId();
		//ɾ����ض���
		monitorObjectBL.deleteMonitorObjectByPK(Integer.valueOf(moId));
		
		//ɾ����ض�����ֵ��Ϣ
		MonitorObjectDefSearchCondImpl cond=new MonitorObjectDefSearchCondImpl();
		cond.setMoId(moId);
		List<MonitorObjectDefInfo> monitorObjectDefList = monitorObjectDefBL.searchMonitorObjectDef(cond);
		for (MonitorObjectDefInfo monitorObjectDefInfo : monitorObjectDefList) {
			monitorObjectDefBL.deleteMonitorObjectDef(monitorObjectDefInfo);
		}
		return dto;
	}

	/**
	 * �ʲ��������Ƽ���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT01DTO searchEsyscodingAction(IGMNT01DTO dto) throws BLException {
		List<MonitorTypeInfo> monitorTypeList = monitorTypeBL.searchMonitorType();//��ѯȫ���������
		List<LabelValueBean> esyscodingList=new ArrayList<LabelValueBean>();
		esyscodingList.add(new LabelValueBean("",""));
		for (MonitorTypeInfo monitorTypeInfo : monitorTypeList) {
			if(monitorTypeInfo.getMtSyscoding().length()>3){//����볤�ȴ���3��Ҫ��ص�����
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
	 * �����洢������Ϣʵ���
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
	 * DMXʵʱ�趨
	 *
	 * @param dmxRealTimeBL DMXʵʱ
	 */
	public void setDmxRealTimeBL(SOC0301BL dmxRealTimeBL) {
		this.soc0301BL = dmxRealTimeBL;
	}



	/** 
	 * ��ѯdebug��س�ʼ����Ϣ
	 */
	public IGMNT01DTO searchDebugTaskInitAction(IGMNT01DTO dto) throws BLException {
		
		Properties properties = this.getProperties();
		//��������ѯ����
		SOC0304SearchCondImpl mtcond=new SOC0304SearchCondImpl();
		//����ֻ��״̬
		mtcond.setMtStatus(IGMntConstantDefine.TASKSTATUSACTIVITY);
		//��ѯ���м������
		List<SOC0304Info> mtInfoList=soc0304BL.searchSoc0304(mtcond);
		//��ѯָ�����͵Ĵ洢���к�
		List<MonitorObjectInfo> moTypeList=getMoTypeList();
		
		//����dto
		dto.setMonitorObjectList(moTypeList);
		dto.setSoc0304List(mtInfoList);
		dto.setCheckedCount(properties.getProperty("CHECKED_COUNT"));
		dto.setInterValDefault(getIntervalDefault());
		//����ѡ������
		return dto;
	}
	/**
	 * ��ȡ�������͵Ķ���
	 * @return
	 */
	private List<MonitorObjectInfo> getMoTypeList()throws BLException{
		List<MonitorObjectInfo> monitorObjectList = monitorObjectBL.searchMonitorObject();
		List<MonitorObjectInfo> moTypeList=new ArrayList<MonitorObjectInfo>();
		if(monitorObjectList!=null){
			for (int i = 0; i < monitorObjectList.size(); i++) {
				MonitorObjectInfo moInfo=monitorObjectList.get(i);
				//��ȡָ������
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
	 * ��ʼִ�м������
	 */
	public IGMNT01DTO insertDebugTaskAction(IGMNT01DTO dto) throws BLException {
		//��ȡForm
		IGMNT0107Form form=dto.getIgmnt0107Form();
		Properties properties = this.getProperties();
		//����Ĭ��ֵ
		dto.setCheckedCount(properties.getProperty("CHECKED_COUNT"));
		dto.setInterValDefault(getIntervalDefault());
		dto.setMtSsn(form.getMtSsn());
		dto.setMonitorObjectList(getMoTypeList());
		//��������ѯ����
		SOC0304SearchCondImpl mtcond=new SOC0304SearchCondImpl();
		//����ֻ��״̬
		mtcond.setMtStatus(IGMntConstantDefine.TASKSTATUSACTIVITY);
		//�������к�
		mtcond.setMtSsn(form.getMtSsn());
		//��ѯ���м������
		List<SOC0304Info> mtInfoList=soc0304BL.searchSoc0304(mtcond);
		//�жϲ��ܳ���6�����������
		Integer limitCount=Integer.parseInt(properties.getProperty("MONITOR_TASK_COUNT"));
		boolean isTrue=(mtInfoList!=null)&&((mtInfoList.size()+1)<=limitCount);
		if(!isTrue){
			dto.addMessage(new ActionMessage("IGMNT0107.E001",limitCount));
			dto.setSoc0304List(mtInfoList);
			dto.setErrFlag(IGMntConstantDefine.ERR_FLAG);
			return dto;
		}
		//��֤С��1000����ض���
		//��ȡʱ����
		Integer timeVal=Integer.parseInt(properties.getProperty("MONITOR_TASK_INTERVAL"));
		//��������ض���
		Integer objectCount=Integer.parseInt(properties.getProperty("MONITOR_OBJECT_COUNT"));
		//����ͳ����
		Integer objectTotal=0;
		//ԭ�ȼ�¼��
		for (int i = 0; i < mtInfoList.size(); i++) {
			SOC0304Info mtInfo=mtInfoList.get(i);
			if(mtInfo!=null){
				if(mtInfo.getMtObjNames()!=null&&!"".equals(mtInfo.getMtObjNames())){
					String[] objArr=mtInfo.getMtObjNames().split(",");
					if(objArr!=null&&objArr.length>0){
						//��ȡ��������ļ�ض�������
						objectTotal+=objArr.length*(timeVal/mtInfo.getMtInterval());
					}
				}
			}
		}
		//��ȡ������֡�KPI��ʱ����
		//�������ѯ����
		CodeDetailSearchCondImpl cnameCond=new CodeDetailSearchCondImpl();
		cnameCond.setCid(form.getMtCname());
		cnameCond.setCcid(IGMntConstantDefine.COMPONENT_TYPE_CODE);
		//�������ѯ
		List<CodeDetail> cnameList=(List<CodeDetail>) codeDetailBL.searchCodeDetail(cnameCond, 1);
		//�������ʶ
		String cnameFlag=cnameList.get(0).getSyscoding();
		String kpiCcid=IGMntConstantDefine.getValue(cnameFlag.toUpperCase()+"_KPI_CODE");
		String valCcid=IGMntConstantDefine.getValue(cnameFlag.toUpperCase()+"_VAL_CODE");
		//KPI��ѯ����
		CodeDetailSearchCondImpl kpiCond=new CodeDetailSearchCondImpl();
		kpiCond.setCid(form.getMtKpi());
		kpiCond.setCcid(kpiCcid);
		List<CodeDetail> kpiList=(List<CodeDetail>) codeDetailBL.searchCodeDetail(kpiCond, 1);
		//ʱ��������
		CodeDetailSearchCondImpl valCond=new CodeDetailSearchCondImpl();
		valCond.setCcid(valCcid);
		valCond.setCid(form.getMtInterval());
		List<CodeDetail> valList=(List<CodeDetail>) codeDetailBL.searchCodeDetail(valCond, 1);
		//��ǰ�������ļ������
		String[] selectIds=form.getSelectedid();
		//�жϲ�Ϊnull�д���0
		if(selectIds!=null&&selectIds.length>0){
			if(valList!=null&&valList.size()>0){
				//��������
				objectTotal+=selectIds.length*(timeVal/Integer.parseInt(valList.get(0).getSyscoding()));
				if(objectTotal>objectCount){
					dto.addMessage(new ActionMessage("IGMNT0107.E002",objectCount));
					dto.setSoc0304List(mtInfoList);
					dto.setErrFlag(IGMntConstantDefine.ERR_FLAG);
					return dto;
				}
			}
		}
		//�ж�ͬ��������ͬ���ͬKPI�Ƿ�����ͬ�ļ�ض���
		boolean isEqual=isEqual(cnameFlag, kpiList.get(0).getSyscoding(), mtInfoList, selectIds);
		if(isEqual){
			dto.addMessage(new ActionMessage("IGMNT0107.E003"));
			dto.setSoc0304List(mtInfoList);
			dto.setErrFlag(IGMntConstantDefine.ERR_FLAG);
			return dto;
		}
		//ִ�в���
		User curuser=dto.getUser();
		SOC0304TB mtTb=new SOC0304TB();
			//�������
			mtTb.setMtCname(cnameFlag);
			//KPI����
			if(kpiList!=null&&kpiList.size()>0){
				mtTb.setMtKpi(kpiList.get(0).getSyscoding());
			}//ʱ���������
			if(valList!=null&&valList.size()>0){
				mtTb.setMtInterval(Integer.parseInt(valList.get(0).getSyscoding()));
				mtTb.setMtNum(timeVal/Integer.parseInt(valList.get(0).getSyscoding()));
			}
			//���к�
			mtTb.setMtSsn(form.getMtSsn());
			Calendar cal=Calendar.getInstance();
			//��ʼʱ��
			mtTb.setMtStartTime(sdf.format(cal.getTime()));
			cal.add(Calendar.SECOND, timeVal);
			//Ԥ����ʱ��
			mtTb.setMtPStopTime(sdf.format(cal.getTime()));
			//״̬
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
			
			//������־������bat
			createBat(mtTb.getMtSsn(),mtId+"",mtTb.getMtCname(),mtTb.getMtKpi(),mtTb.getMtInterval(),mtTb.getMtNum());
			
			//���ɵ��ý���bat
			createParseBat(mtId+"");
			//���ؽ���
			
			return dto;
	}

	 /**
	 *DMXREALTIME����Ӧ����Դ�ļ�
	 */
	private Properties getProperties() throws BLException {
		//CI����Ӧ����Դ�ļ�
		Properties properties = null;
		//������
		FileInputStream inputFile = null;
		//���������ļ�
		try {
			properties = new Properties();
			inputFile = new FileInputStream(ResourceUtility.getString("DMX_REALTIME_FILE_PATH"));
			properties.load(inputFile);
		} catch (FileNotFoundException e) {
			log.error("DMXREALTIME����Ӧ����Դ�ļ���ȡ����", e);
			throw new BLException("IGASM2001.E001");
		} catch (IOException e) {
			log.error("DMXREALTIME����Ӧ����Դ�ļ���ȡ����", e);
			throw new BLException("IGASM2001.E001");
		} finally {
			if(inputFile != null) {
				try {
					inputFile.close();
				} catch (IOException e) {
					log.error("DMXREALTIME����Ӧ����Դ�ļ���ȡ����", e);
					throw new BLException("IGASM2001.E001");
				}
			}
		}
		return properties;
	}
	/**
	 * ����һ��������־bat,������
	*/
	public void createBat(String mtSsn,String mtId,String mtCname,String mtKpi,Integer mtInterval,Integer mtNum){
		try{
			Properties properties = this.getProperties();
			//bat�ļ�·��
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
			//bat�ļ�����
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
				//systemΪ-raw
					bw.write(sysStr+" -raw > "+logStr);
				}else if(mtCname.equalsIgnoreCase("DA")){
					bw.write(sysStr+" -da all -type prefetch > "+logStr);
				}else if(mtCname.equalsIgnoreCase("DIRECTOR")){
					bw.write(sysStr+" -dir all > "+logStr);
				}else{
					log.error("=====�������("+mtCname+")������====");
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
			log.debug("=========IGMNT01Bl������־bat����=========");
		}
	}
	
	/**
	 * ����һ������bat,������
	*/
	public void createParseBat(String mtId){
		try{
			Properties properties = this.getProperties();
			//bat�ļ�·��
			String batFilePath=properties.getProperty("CREAT_BAT_FILEPATH");
			//String batFileName=properties.getProperty("PARSE_BAT_FILENAME");
			String vbsFileName=properties.getProperty("PARSE_VBS_FILENAME");
			//bat�ļ�����
			Runtime rt = Runtime.getRuntime(); 
			rt.exec("wscript "+batFilePath+vbsFileName+" "+mtId);
//			rt.exec("cmd.exe /c start " + batFilePath+batFileName+" "+mtId);
		}catch (Exception e) {
			log.debug("=========IGMNT01Bl����bat����=========");
		}
	}
	/**
	 * ��ȡSystemĬ��ʱ����
	 * @return
	 */
	private String getIntervalDefault(){
		String intervalDefault=IGMntConstantDefine.INTERVAL_DEFAULT;
		String[] defArr=intervalDefault.split(",");
		CodeDetailSearchCondImpl cond=new CodeDetailSearchCondImpl();
		//��ȡ���������ֵ
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
	 * �ж��Ƿ���ͬ����
	 * @return
	 */
	private  boolean isEqual(String cname,String kpi,List<SOC0304Info> mtInfoList,String[] selectIds){
		if(mtInfoList!=null&&mtInfoList.size()>0){
			for (int i = 0; i < mtInfoList.size(); i++) {
				SOC0304Info mtInfo=mtInfoList.get(i);
				//�ж���������kpi��ͬ
				boolean isEqual=cname.equals(mtInfo.getMtCname())&&kpi.equals(mtInfo.getMtKpi());
				if(isEqual){
					//��������ֵ���Ϊ0�����ж�ΪSystem��ͬ
					if(selectIds==null||selectIds.length==0){
						return true;
					}else{
						//��Ϊ0��ѭ���ж�
						String objNames=mtInfo.getMtObjNames();
						if(objNames!=null&&!"".equals(objNames)){
							String[] objArr=objNames.split(",");
							//�������������ͬ������ͬ�Ŀ���
							if(objArr.length==selectIds.length){
								int count=0;//�����������ȫ�����У�����ͬ
								for (int j = 0; j < selectIds.length; j++) {
									for (int j2 = 0; j2 < objArr.length; j2++) {
										//�����ֵ��ͬ�����������
										if(selectIds[j].equals(objArr[j2])){
											count++;
											break;
										}
									}
								}
								//����жϳ���һ�����
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
	 * ȡ��ʵʱ���ܼ���
	 * @param mtId
	 * @return
	 * @throws BLException
	 */
	public Map<String, List<SOC0301Info>> getDataMap(int mtId) throws BLException {
		Map<String, List<SOC0301Info>> dataMap=new HashMap<String, List<SOC0301Info>>();
		
		SOC0301SearchCondImpl cond=new SOC0301SearchCondImpl();
		cond.setMtId_eq(mtId);
		List<SOC0301Info> drtList = soc0301BL.searchSoc0301(cond);//����������ʵʱ��������
		
		SOC0304Info monitorTask = soc0304BL.searchSoc0304ByPK(mtId);
		String mtCname = monitorTask.getMtCname();//������
		
		if(mtCname.equals("System")){//������Ϊϵͳ
			dataMap.put("System", drtList);
		}else{//�������ϵͳ
			String[] mtObjNames = monitorTask.getMtObjNames().split(",");//��ض���������
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
		String[] mtdValue = igmnt0102Form.getMtdValue();//��ֵ����
		int mtId = igmnt0102Form.getMtId();
		//������ֵ�޸�
		if(mtId>9){
			SOC0423SearchCondImpl cond=new SOC0423SearchCondImpl();
			cond.setStatus(0);//δ�޸�
			if(mtId==10){//�ļ�ϵͳ
				cond.setObjectType("FS");
			}else if(mtId==11){//��ռ�
				cond.setObjectType("TS");
			}
			List<SOC0423Info> searchCapacityObjectList = soc0423BL.searchSOC0423(cond);
			for (SOC0423Info capacityObjectListInfo : searchCapacityObjectList) {
				SOC0423TB c=(SOC0423TB)capacityObjectListInfo;
				c.setWarningNum(Integer.valueOf(mtdValue[0]));//��ͨ�澯��ֵ
				c.setErrorNum(Integer.valueOf(mtdValue[1]));//���ظ澯��ֵ
				soc0423BL.updateSOC0423(c);
			}
		}
	}

	/**
	 * DMXʵʱ�趨
	 *
	 * @param soc0301BL DMXʵʱ
	 */
	public void setSoc0301BL(SOC0301BL soc0301BL) {
		this.soc0301BL = soc0301BL;
	}

	/**
	 * debug�������BL�趨
	 *
	 * @param soc0304BL debug�������BL
	 */
	public void setSoc0304BL(SOC0304BL soc0304BL) {
		this.soc0304BL = soc0304BL;
	}

	/**
	 * soc0117BL�趨
	 *
	 * @param soc0117BL soc0117BL
	 */
	public void setSoc0117BL(SOC0117BL soc0117BL) {
		this.soc0117BL = soc0117BL;
	}

	/**
	 * EntityItemBL�趨
	 *
	 * @param soc0118BL EntityItemBL
	 */
	public void setSoc0118BL(SOC0118BL soc0118BL) {
		this.soc0118BL = soc0118BL;
	}

	/**
	 * ��������BL�趨
	 *
	 * @param soc0423BL ��������BL
	 */
	public void setSoc0423BL(SOC0423BL soc0423BL) {
		this.soc0423BL = soc0423BL;
	}
}
