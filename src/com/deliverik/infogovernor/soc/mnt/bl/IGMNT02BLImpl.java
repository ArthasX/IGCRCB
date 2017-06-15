/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
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
 * ����:������ع���ӿ�ʵ����
 * ����������
 * ������¼��
 */
public class IGMNT02BLImpl extends BaseBLImpl implements IGMNT02BL{

	static Log log = LogFactory.getLog(IGMNT02BLImpl.class);
	
	protected MessageResources resources = MessageResources.getMessageResources("com.deliverik.infogovernor.soc.mnt.mntResources");
	
	/** ������ع���BL*/
	protected SOC0423BL soc0423BL;
	/** ������ͼBL*/
	protected SOC0429BL soc0429BL;
	/**ע��SOC0305BL	 */
	protected SOC0305BL soc0305BL;
	/** ����������� */
	protected SOC0113BL soc0113BL;
	
	protected CodeDetailBL codeDetailBL;
	
	protected SOC0120BL soc0120BL;
	
	/** �������ݱ���BL */
	protected SOC0306BL soc0306BL;
	
	/**
	 * ���������ع��� ɾ��
	 */
	public IGMNT02DTO deleteSOC0423Action(IGMNT02DTO dto)
			throws BLException {
		//Ԥ��
		return dto;
	}
	
	/**
	 * ���������ع��� ����
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
	 * ���������ع��� ��ȡhostlist for select
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
	 * ���������ع��� ��ҳ��ѯ
	 * 
	 */
	public IGMNT02DTO searchSOC0423Action(IGMNT02DTO dto)
			throws BLException {
		//��ò�ѯ����form
		IGMNT0112Form form=dto.getIgmnt0112Form();
		//��������
		SOC0423SearchCondImpl cond=new SOC0423SearchCondImpl();
		cond.setName_like(form.getName());
		cond.setObjectType(form.getObjectType());
		cond.setObjectName(form.getObjectName());
		//��������Ŀ
		int totalCount = soc0423BL.getSearchCount(cond);
		
		if (totalCount == 0) {
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount() ) {
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		//����DAO�ӿڲ�ѯ
		pDto.setTotalCount(totalCount);
		
		List<SOC0423Info> list=soc0423BL.searchSOC0423(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		dto.setSoc0423List(list);
		
		return dto;
	}

	/**
	 * <p>
	 * Description: ������־��ѯ
	 * </p>
	 * 
	 * @param dto IGMNT02DTO
	 * @return IGMNT02DTO
	 * @throws BLException
	 * @update
	 */
	public IGMNT02DTO searchSOC0305Action(IGMNT02DTO dto)
			throws BLException {
		//��ѯ����
		int totalCount = soc0305BL.getVWSearchCount(dto.getSoc0305SearchCond());
		if(totalCount==0){
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		
		//�澯��ѯҳ�棬��ѯ�������10000��ʱ����ʾǰ50��
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			//dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			//return dto;
			totalCount=50;
			if(pDto.getFromCount()==40){//����ҳ��ʾ10����¼
				pDto.setPageDispCount(10);
			}
		}
		
		//����DAO�ӿڲ�ѯ ������־
		List<SOC0307Info> storageEventVWInfoList = soc0305BL.searchSOC0307(dto.getSoc0305SearchCond(), pDto.getFromCount(),
				pDto.getPageDispCount());
		pDto.setPageDispCount(20);
		pDto.setTotalCount(totalCount);
		dto.setSoc0307List(storageEventVWInfoList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========������־��ѯ��������========");
		return dto;
	}

	/**
	 * �����������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT02DTO getEiImportProgrammeAction(IGMNT02DTO dto)
			throws BLException {
		log.debug("========����������Ͳ�ѯ����ʼ========");
		List<SOC0113Info> impTypeInfoList=this.soc0113BL.searchEiImportProgramme();
		List<LabelValueBean> impTypeList = new ArrayList<LabelValueBean>();
		impTypeList.add(new LabelValueBean("",""));
		for(SOC0113Info info : impTypeInfoList){
			impTypeList.add(new LabelValueBean(info.getImpTypename(),info.getImpTypeid().toString()));
		}
		dto.setImpTypeList(impTypeList);
		log.debug("========����������Ͳ�ѯ�������========");
		return dto;
	}


	/**
	 * ��������������־
	 */
	public IGMNT02DTO searchSOC0305ByCond(IGMNT02DTO dto) throws BLException {
		//����DAO�ӿڲ�ѯ ������־
		SOC0305Info storageEvent=null;
		List<SOC0305Info> searchStorageEvent = soc0305BL.searchSoc0305(dto.getSoc0305SearchCond());
		if(searchStorageEvent!=null&&searchStorageEvent.size()>0){
			storageEvent=searchStorageEvent.get(0);
		}
		dto.setSoc0305Info(storageEvent);
		log.debug("========������־��ѯ��������========");
		return dto;
	}

	/**
	 * �澯����״̬���	0:δ����	1���Ѵ���
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
	 * �澯�ȼ�ȡ��
	 */
	public IGMNT02DTO getAlarmSeverity(IGMNT02DTO dto) throws BLException {
		log.debug("========�澯�ȼ���ѯ����ʼ========");
		CodeDetailSearchCondImpl cond=new CodeDetailSearchCondImpl();
		cond.setCcid(CodeDefine.ALARM_SEVERITY_CODE.getCcid());
		List<CodeDetail> codeDetailList = codeDetailBL.searchCodeDetail(cond, 0);
		List<LabelValueBean> alarmSeverityList = new ArrayList<LabelValueBean>();
		alarmSeverityList.add(new LabelValueBean("",""));
		for(CodeDetail c : codeDetailList){
			alarmSeverityList.add(new LabelValueBean(c.getCvalue(),c.getCvalue()));
		}
		dto.setAlarmSeverityList(alarmSeverityList);
		log.debug("========�澯�ȼ���ѯ�������========");
		return dto;
	}

	/**
	 * ȡ��CI���Ƽ���
	 */
	public IGMNT02DTO getCiList(IGMNT02DTO dto) throws BLException {
		log.debug("========CI��ѯ����ʼ========");
		SOC0120SearchCondImpl cond=new SOC0120SearchCondImpl();
		cond.setDeleteflag_eq("0");
		List<SOC0120Info> importVersionList = soc0120BL.searchImportVersion(cond);
		List<LabelValueBean> ciList=new ArrayList<LabelValueBean>();
		ciList.add(new LabelValueBean("",""));
		for (SOC0120Info importVersionInfo : importVersionList) {
			int impcitype = importVersionInfo.getImpcitype();
			//���˵�����
			if(impcitype==1||impcitype==4||impcitype==7){
				continue;
			}
			LabelValueBean ci=new LabelValueBean(importVersionInfo.getImpeiname(),importVersionInfo.getImpeiname());
			ciList.add(ci);
		}
		dto.setCiList(ciList);
		log.debug("========CI��ѯ�������========");
		return dto;
	}
	
	/**
	 * ��ѯ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT02DTO searchSOC0306Action(IGMNT02DTO dto) throws BLException {
		log.debug("========�������ݱ�����ѯ����ʼ========");
		//Formȡ��
		IGMNT0207Form form=dto.getIgmnt0207Form();
		

		// �������ݱ�����ѯ����ȡ��
		int totalCount = this.soc0306BL.getSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========�������ݱ�����ѯ���ݲ�����========");
			// �������ݱ�����ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========�������ݱ�����ѯ���ݼ�������========");
			// �������ݱ�����ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		// ��ǰҳ�������ݱ���ȡ��
		List<SOC0306Info> soc0306List = this.soc0306BL
				.findSoc0306ByCond(form, pDto.getFromCount(), pDto
						.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setSoc0306List(soc0306List);

		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========�������ݱ�����ѯ��������========");
		return dto;
	}


	/**
	 * �������ڲ�ѯ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT02DTO popSOC0306Action(IGMNT02DTO dto) throws BLException {
		log.debug("========�������ڲ�ѯ����ʼ========");
		//Formȡ��
		SOC0306SearchCondImpl cond = new SOC0306SearchCondImpl();
		cond.setReaddate(null);
		// �������ݱ�����ѯ����ȡ��
		this.soc0306BL.getSearchCount(cond);

		// ��ǰҳ�������ݱ���ȡ��
		List<SOC0306Info> soc0306List = this.soc0306BL
				.findSoc0306ByCond(cond, 0, 0);

		dto.setSoc0306List(soc0306List);

		log.debug("========�������ڲ�ѯ��������========");
		return dto;
	}

	/**
	 * resourcesȡ��
	 *
	 * @return resources resources
	 */
	public MessageResources getResources() {
		return resources;
	}

	/**
	 * resources�趨
	 *
	 * @param resources resources
	 */
	public void setResources(MessageResources resources) {
		this.resources = resources;
	}

	/**
	 * codeDetailBLȡ��
	 *
	 * @return codeDetailBL codeDetailBL
	 */
	public CodeDetailBL getCodeDetailBL() {
		return codeDetailBL;
	}

	/**
	 * codeDetailBL�趨
	 *
	 * @param codeDetailBL codeDetailBL
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	/**
	 * ������ع���BLȡ��
	 *
	 * @return soc0423BL ������ع���BL
	 */
	public SOC0423BL getSoc0423BL() {
		return soc0423BL;
	}

	/**
	 * ������ع���BL�趨
	 *
	 * @param soc0423BL ������ع���BL
	 */
	public void setSoc0423BL(SOC0423BL soc0423BL) {
		this.soc0423BL = soc0423BL;
	}

	/**
	 * ������ͼBLȡ��
	 *
	 * @return soc0429BL ������ͼBL
	 */
	public SOC0429BL getSoc0429BL() {
		return soc0429BL;
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
	 * ע��SOC0305BL�趨
	 *
	 * @param soc0305BL ע��SOC0305BL
	 */
	public void setSoc0305BL(SOC0305BL soc0305BL) {
		this.soc0305BL = soc0305BL;
	}

	/**
	 * ������������趨
	 *
	 * @param soc0113BL �����������
	 */
	public void setSoc0113BL(SOC0113BL soc0113BL) {
		this.soc0113BL = soc0113BL;
	}

	/**
	 * soc0120BL�趨
	 *
	 * @param soc0120BL soc0120BL
	 */
	public void setSoc0120BL(SOC0120BL soc0120BL) {
		this.soc0120BL = soc0120BL;
	}

	/**
	 * �������ݱ���BL�趨
	 *
	 * @param soc0306BL �������ݱ���BL
	 */
	public void setSoc0306BL(SOC0306BL soc0306BL) {
		this.soc0306BL = soc0306BL;
	}




}
