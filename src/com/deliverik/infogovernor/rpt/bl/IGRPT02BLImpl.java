/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ����: �¼��ͱ������Ч��ҵ���߼�ʵ�� ��������: �¼��ͱ������Ч��ҵ���߼�ʵ�� ������¼: 2011/11/23 �޸ļ�¼: 2012/06/08
 */
public class IGRPT02BLImpl extends BaseBLImpl implements IGRPT02BL {
	static Log log = LogFactory.getLog(IGRPT02BLImpl.class);

	protected MessageResources resources = MessageResources
			.getMessageResources("com.deliverik.infogovernor.comResources");
	
	/** �Զ��屨�� */
	protected SOC0204BL soc0204BL;
	
	/**
	 * �Զ��屨��ȡ��
	 *
	 * @return soc0204BL �Զ��屨��
	 */
	public SOC0204BL getSoc0204BL() {
		return soc0204BL;
	}

	/**
	 * �Զ��屨���趨
	 *
	 * @param soc0204BL �Զ��屨��
	 */
	public void setSoc0204BL(SOC0204BL soc0204BL) {
		this.soc0204BL = soc0204BL;
	}
	/** codedetailBL */
	protected CodeDetailBL codeDetailBL;

	/** ��ض���BL */
	protected MonitorObjectBL monitorObjectBL;
	/** �Զ�����ģ��BL */
	protected SOC0207BL soc0207BL;
	/** �Զ�����ģ��ӳ��BL */
	protected SOC0206BL soc0206BL;
	/** �Զ����������BL */
	protected SOC0205BL soc0205BL;
	/** ���ӱ���ҵ��BL */
	protected SOC0202BL soc0202BL;

	/** ������ԴBL */
	protected SOC0209BL soc0209BL;

	/** �¼��ͱ������Ч��BL */
	protected SOC0208BL soc0208BL;

	/** ���̻�������BL */
	protected CodeDetailDefBL codeDetailDefBL;

	/** ���ڸ�ʽ */
	protected SimpleDateFormat noFormat = new SimpleDateFormat(
			"yyyyMMdd_HHmmss");

	/** ���ڸ�ʽ */
	protected SimpleDateFormat secondFormat = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");

	/**
	 * codedetailBL�趨
	 * 
	 * @param codeDetailBL
	 *            codedetailBL
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	/**
	 * ��ض���BL�趨
	 * 
	 * @param monitorObjectBL
	 *            ��ض���BL
	 */
	public void setMonitorObjectBL(MonitorObjectBL monitorObjectBL) {
		this.monitorObjectBL = monitorObjectBL;
	}

	/**
	 * �Զ�����ģ��BL�趨
	 * 
	 * @param soc0207BL
	 *            �Զ�����ģ��BL
	 */
	public void setSoc0207BL(SOC0207BL soc0207BL) {
		this.soc0207BL = soc0207BL;
	}

	/**
	 * �Զ�����ģ��ӳ��BL�趨
	 * 
	 * @param soc0206BL
	 *            �Զ�����ģ��ӳ��BL
	 */
	public void setSoc0206BL(
			SOC0206BL soc0206BL) {
		this.soc0206BL = soc0206BL;
	}

	/**
	 * �Զ����������BL�趨
	 * 
	 * @param reportManageBL
	 *            �Զ����������BL
	 */
	public void setSoc0205BL(SOC0205BL reportManageBL) {
		this.soc0205BL = reportManageBL;
	}

	/**
	 * ���ӱ���ҵ��BL�趨
	 * 
	 * @param reportAnnexationBL
	 *            ���ӱ���ҵ��BL
	 */
	public void setSoc0202BL(SOC0202BL reportAnnexationBL) {
		this.soc0202BL = reportAnnexationBL;
	}

	/**
	 * ������ԴBL�趨
	 * 
	 * @param processRecordInfoVWBL
	 *            ������ԴBL
	 */
	public void setSoc0209BL(
			SOC0209BL processRecordInfoVWBL) {
		this.soc0209BL = processRecordInfoVWBL;
	}

	/**
	 * �¼��ͱ������Ч��BL�趨
	 * 
	 * @param soc0208BL
	 *            �¼��ͱ������Ч��BL
	 */
	public void setSoc0208BL(SOC0208BL soc0208BL) {
		this.soc0208BL = soc0208BL;
	}

	/**
	 * ���̻�������BL�趨
	 * 
	 * @param codeDetailDefBL
	 *            ���̻�������BL
	 */
	public void setCodeDetailDefBL(CodeDetailDefBL codeDetailDefBL) {
		this.codeDetailDefBL = codeDetailDefBL;
	}

	/**
	 * ִ����ӱ������Ч�ʴ���
	 * 
	 * @throws BLException
	 */
	public void saveAlterationEfficiency() throws BLException {
		log.debug("========�������Ч�ʴ���ʼ========");
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
				// ���·���Ч��
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
				// ���������ʷ����Ч��
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
				// ִ����Ӳ���
				this.soc0208BL.registSOC0208(soc0208);
			}
		}
		log.debug("========�������Ч�ʴ������========");
	}

	/**
	 * ִ������¼�����Ч�ʴ���
	 * 
	 * @throws BLException
	 */
	public void saveIncidentEfficiency() throws BLException {
		log.debug("========�¼�����Ч�ʴ���ʼ========");
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
				// ���·���Ч��
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
				// �����¼���ʷ����Ч��
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
				// ִ����Ӳ���
				this.soc0208BL.registSOC0208(soc0208);
			}
		}
		log.debug("========�¼�����Ч�ʴ������========");
	}

	// ================================================2012/06/08=================================================
	/**
	 * �Զ�����ģ���ҳ��ѯ����
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
		// �Զ������ѯ����ȡ��
		int totalCount = soc0207BL.getSearchCount(cond);

		if (totalCount == 0) {
			log.debug("========�Զ������ѯ���ݲ�����========");
			dto.addMessage(new ActionMessage("IGRPT0101.E003", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========�Զ������ѯ���ݼ�������========");
			dto.addMessage(new ActionMessage("IGRPT0101.E002", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		pDto.setTotalCount(totalCount);

		// ��ǰҳ�Զ�����ģ����Ϣȡ��
		List<SOC0207Info> list = soc0207BL.searchSOC0207(
				cond, pDto.getFromCount(), pDto.getPageDispCount());

		//dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));  //��ѯ���:xx��;
		dto.setReportTemplateList(list);
		return dto;
	}

	/**
	 * �Զ�����ģ��ɾ������
	 * 
	 * @param IGRPT02DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO deleteReportTemplateInstance(IGRPT02DTO dto)
			throws BLException {
		// ȡ������ɾ��id
		String[] rtid = dto.getIGRPT0202Form().getDelid();
		if (rtid != null) {
			for (int i = 0; i < rtid.length; i++) {
				SOC0207TB info = (SOC0207TB) soc0207BL
						.searchSOC0207ByPK(Integer.parseInt(rtid[i]));
				//ģ���ļ�·��
				String docPath=ResourceUtility.getString("REPORT_TEM_PATH")+info.getRtRealName();
				if (info != null) {// ������Ŀ��ɾ��
					soc0207BL.deleteSOC0207(info);
					//ɾ���ļ�
					deleteFile(docPath);
				} else {
					dto.addMessage(new ActionMessage("IGRPT0101.E001", 0));
				}
			}
		}
		dto.addMessage(new ActionMessage("IGRPT0101.I001", 0));
		dto.setIGRPT0202Form(null);//ɾ���������ÿ�����
		return dto;
	}

	/**
	 * �Զ�����ģ����������
	 * 
	 * @param IGRPT02DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO insertReportTemplateInstance(IGRPT02DTO dto)
			throws BLException {
		IGRPT0201Form form = dto.getIGRPT0201Form();
		//���ж��Ƿ���rtId�������ɾ��.
		if(form.getRtId()!=null&&form.getRtId()!=0){
				soc0207BL.deleteSOC0207ByPK(form.getRtId());//��������
		}
		Map<String, String> map = insertFileAction(dto);
		form.setRtUploadTime(IGStringUtils.getCurrentDate());
		form.setRtRealName(map.get("realfilename"));
		SOC0207Info rtinfo = soc0207BL.registSOC0207(form);
		//����ɨ���¼
		//�ĵ�����+·��
		String filePathAndName=ResourceUtility.getString("REPORT_TEM_PATH")+rtinfo.getRtRealName();
		
		insertRTM(rtinfo.getRtId(),filePathAndName);
		initMappingInsertAction(dto,rtinfo);
		
		return dto;
	}
	/**����ģ��ӳ��*/
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
	 * �Զ�����ģ��ӳ���ʼ������
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
		//Ĭ��KPI.Ϊ�洢�����һ��
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
	 * �Զ�����ģ����·���
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
			if (!form.getAttachFile(0).getFileName().equals("")) {// �ж��Ƿ������ϴ�
				rttb.setRtRealName(insertFileAction(dto).get("realfilename"));
				soc0206BL.deleteByRtId(rttb.getRtId());
				//����ɨ���¼
				//�ĵ�����+·��
				String filePathAndName=ResourceUtility.getString("REPORT_TEM_PATH")+rttb.getRtRealName();
				String oldFileName=ResourceUtility.getString("REPORT_TEM_PATH")+info.getRtRealName();
				//����ļ������ļ�ɾ��
				File oldFile=new File(oldFileName);
				if(oldFile.exists()){
					oldFile.delete();
				}
				insertRTM(rttb.getRtId(),filePathAndName);
			} else {
				rttb.setRtRealName(info.getRtRealName());
			}
		}
		soc0207BL.updateSOC0207(rttb);//��������
		dto.addMessage(new ActionMessage("IGRPT0103.I002", 0));
		return dto;
	}
	/**�޸�ӳ���ϵ*/
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
			soc0207BL.updateSOC0207(rttb);//��������
		
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
	 * �Զ�����ģ����»�����ʾ����
	 * 
	 * @param IGRPT02DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO initUpdateReportTemplateAction(IGRPT02DTO dto)
			throws BLException {
		// ��ѯ����Ӧ�����һ����¼
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
	 * ��Ӹ�������
	 * 
	 * @param dto
	 * @return Map<String,String> �����ļ���Ϣ
	 */
	public Map<String, String> insertFileAction(IGRPT02DTO dto)
			throws BLException {
		// �洢�ļ���Ϣ
		Map<String, String> remap = new HashMap<String, String>();
		// ��ȡform
		IGRPT0201Form form = dto.getIGRPT0201Form();
		// �ϴ��ļ�Map
		Map<Integer, FormFile> filemaps = form.getFileMap();
		// �ļ�����
		String realfilename = "";
		// ��������жϣ���ֵ
		if (filemaps != null && filemaps.size() > 0) {//del
			realfilename = form.getRtRealName();//del
		}//del
		// ת��
		Iterator<Integer> iterator = filemaps.keySet().iterator();
		// ѭ���ϴ��ļ�
		while (iterator.hasNext()) {
			FormFile file = (FormFile) filemaps.get(iterator.next());
			if (file != null) {
				// �ϴ��ļ����ڵ����
				// �ϴ��ļ�·��
				String rootPath = ResourceUtility.getString("REPORT_TEM_PATH");
				realfilename = file.getFileName();

				// �ļ��ϴ�����
				try {
					// �����Լ�Ӧ�õ��ϴ��ļ�
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
	 * �ļ��ϴ�
	 * 
	 * @param file
	 *            �ϴ��ļ�����
	 * @param path
	 *            �ϴ��ļ�����Ŀ¼
	 * @param fileName
	 *            �ϴ��ļ���
	 * 
	 * @return
	 * @throws BLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws BLException
	 */
	private void saveFile(FormFile file, String path, String fileName,
			String mode) throws FileNotFoundException, IOException, BLException {

		/** �ϴ��ļ���� */
		checkFile(file, mode);
		/** �ϴ��ļ�·����� */
		checkPath(path);
		/** �ϴ��ļ���ȡ�� */
		InputStream is = file.getInputStream();
		/** �ϴ��ļ�������ȡ�� */
		BufferedInputStream inBuffer = new BufferedInputStream(is);
		/** �ϴ��ļ�������ȡ�� */
		FileOutputStream out = new FileOutputStream(path + fileName);
		/** �ϴ��ļ�����������ȡ�� */
		BufferedOutputStream outBuffer = new BufferedOutputStream(out);
		/** �ϴ��ļ����� */
		int contents = 0;
		while ((contents = inBuffer.read()) != -1) {
			outBuffer.write(contents);
		}

		outBuffer.flush();

		// �ļ����ر�
		inBuffer.close();
		outBuffer.close();

		file.destroy();
	}

	/***
	 * �ϴ��ļ����
	 * 
	 * @param file
	 *            �ϴ��ļ�����
	 * @throws BLException
	 * @throws BLException
	 */
	private void checkFile(FormFile file, String mode) throws BLException {

		// �ļ���С���
		if (file == null || file.getFileSize() < 0.0) {
			// 
			throw new BLException("IGCO10000.E005");
		}
		// �ظ��ļ����ж�
		if (mode.equals("1")) {
			// �����ϴ����Ը���
		} else {
			// �����ϴ���������
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
		// �ļ���չ�����
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
						break;// �ϴ���word
					}
				}
				if (!isPromitType) {					
					throw new BLException("IGCO10000.E007", subFileName);
				}
			}
		}
	}

	/***
	 * �ļ�Ŀ¼���
	 * 
	 * @param path
	 *            �ļ�Ŀ¼
	 */
	private void checkPath(String path) throws BLException {
		File objFile = new File(path);
		if (objFile.exists() != true && objFile.isDirectory() != true) {

			// �ļ�·��������ʱ������Ŀ¼
			boolean ret = objFile.mkdirs();

			if (!ret) {
				throw new BLException("IGCO10000.E008", path);
			}
		}
	}

	/**
	 * ��ʼ����������
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
	 * �ƶ��ļ�
	 * 
	 * @param dto
	 * @throws BLException
	 * @throws FileNotFoundException
	 */
	public void changeFilePath(String filename, String filepath_old,
			String filepath_new) throws FileNotFoundException, IOException {
		// ��ȡԭ·�����ļ�
		File scanfile = new File(filepath_old);
		// ��ȡ�����ļ���Ϣ
		File[] files = scanfile.listFiles();
		// ��ȡ��Ӧ�ļ�
		if (files != null) {
			for (File file : files) {
				// ������ļ�,ͬʱ�ļ�������Ҫ�ƶ����ļ���һ��,����ж�д����
				if (file.isFile() && file.getName().equals(filename)) {
					FileUtils.copyFileToDirectory(file, new File(filepath_new));
					// ԭ�ļ�ɾ��
					file.delete();
				}
			}
		}
	}

	/***
	 * ����word����
	 */
	public IGRPT02DTO createWordAction(IGRPT02DTO dto,SOC0205Info rmInfo) throws BLException {
		//1.��ȡform,�õ�������
		IGRPT0205Form form=dto.getIgrpt0205Form();
		String year=form.getSelRmYear();
		String quarter=form.getSelRmQuarter();
		String month=form.getSelRmMonth();
//		String reportName=form.getRmName();//��������
		//2.�ҵ�ģ��,�õ�ӳ���ϵ
		String isDel=form.getIsDel();
		//��ȡ����ʱ��
		String createDate=rmInfo.getCreateDate();
		//��ȡ���ӱ���
		String[] anIds=form.getAnIds();
		SOC0207TB rtTB=(SOC0207TB) rmInfo.getReportTemplateTB();
		if(rtTB!=null){
			//ʱ������
			String dateType=rtTB.getRtDateType();
			List<SOC0206TB> rtmList=rtTB.getRtmList();
			List<SOC0210> docList=new ArrayList<SOC0210>();
			if(rtmList!=null&&rtmList.size()>0){
				//3.��ƴList<DocTemObj>
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
				//.��ƴList<DocTemObj> ���ӱ��� 
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
					//���ɾ������ɾ������
					if("0".equals(isDel)){
						soc0202BL.deleteSOC0202(raInfo);
					}
				}
			}
			//4.����JacobWordUtil
			JacobWordUtil jwUtil=new JacobWordUtil(false);
			try {
				//ģ��·��������
				String temPathName=ResourceUtility.getString("REPORT_TEM_PATH")+rtTB.getRtRealName();
				//����word·��������
				String savePath=ResourceUtility.getString("REPORT_WORD_PATH")+rmInfo.getRmId()+"_"+noFormat.format(secondFormat.parse(createDate))+rmInfo.getRmSuffix();
				jwUtil.createWordReport(temPathName, docList, savePath);
			} catch (ParseException e) {
				e.printStackTrace();
				log.error("===========ReportManageInfo with id"+rmInfo.getRmId()+" createDate Format is wrong");
			}finally{
				jwUtil.close();
			}
			//���ɾ������ɾ�������ļ�
			if("0".equals(isDel)){
				//ɾ���ļ�
				for (int i = 0; i < docList.size(); i++) {
					if(docList.get(i).getFlag()==null){//����nullʱΪ�����ļ�
						deleteFile(docList.get(i).getDocPath());
					}
					
				}
			}
		}
		return dto;
	}
	/**��ʼ����ѯ���ӱ���*/
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
			//��ѯ����
			SOC0202SearchCondImpl cond=new SOC0202SearchCondImpl();
			User curUser=dto.getCurUser();
			//�û�����
			cond.setRaUserName_eq(curUser.getUsername());
			List<SOC0202Info> raInfoList=soc0202BL.searchSOC0202(cond);
			if(raInfoList==null||raInfoList.size()==0){
				dto.addMessage(new ActionMessage("IGRPT0107.E001"));
			}
			dto.setRaInfoList(raInfoList);
		}
		return dto;
	}

	/**ɾ�����ӱ���*/
	public IGRPT02DTO deleteReportAnnexationInstance(IGRPT02DTO dto)
			throws BLException {
		log.debug("===========delete reportAnnexation start============");
		IGRPT0205Form form=dto.getIgrpt0205Form();
		if(form!=null){
			String[] anIds=form.getAnIds();
			if(anIds!=null&&anIds.length>0){
				for (int i = 0; i < anIds.length; i++) {
					SOC0202TB raInfo=(SOC0202TB) soc0202BL.searchSOC0202ByPK(Integer.parseInt(anIds[i]));
					//ɾ���ļ�
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
	 * ��������ҳ��ѯ
	 * 
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO searchReportManageByCond(IGRPT02DTO dto)throws BLException{
		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		SOC0205SearchCond cond=dto.getIGRPT0204Form();
		//IGRPT0104Form form=dto.getIGRPT0104Form();
		if(cond==null){
			cond=new SOC0205SearchCondImpl();
		}
		//String rtDateType_eq=form.getRtdatetype_eq();
		// ��������ѯ����ȡ��
		int totalCount = soc0205BL.getSearchCount(cond);
		if (totalCount == 0) {
			log.debug("========��������ѯ���ݲ�����========");
			dto.addMessage(new ActionMessage("IGRPT0104.E003", 0));
			return dto;
		}
		
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��������ѯ���ݼ�������========");
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
	 * �������ɾ��
	 * 
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO deleteReportManageInstance(IGRPT02DTO dto)throws BLException{
		// ȡ������ɾ��id by ����
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
	 * �����������
	 * 
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO insertReportManageInstance(IGRPT02DTO dto)throws BLException{
		//��ȡ05form
		IGRPT0205Form form =dto.getIgrpt0205Form();
		if(form!=null){
			SOC0205TB rmTb=new SOC0205TB();
			rmTb.setRmName(form.getRmName());
			//ģ�����
			SOC0207TB rtTB= (SOC0207TB) soc0207BL.searchSOC0207ByPK(Integer.parseInt(form.getSelTemplate()));
			rmTb.setReportTemplateTB(rtTB);
			rmTb.setRmYear(form.getSelRmYear());
			rmTb.setRtName(rtTB.getRtName());
			String curDateType=rtTB.getRtDateType();
			rmTb.setRmDateType(curDateType);
			int year =Integer.parseInt(form.getSelRmYear());
			String curRmDateStr="2012/01/01";
			if(curDateType.equals("0")){//�·�
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
			}else if(curDateType.equals("1")){//����
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
			//����ʹ�ù��ĸ��ӱ���
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
			//���ɱ���
			dto=createWordAction(dto,rmInfo);
			
		}else{
			dto.addMessage(new ActionMessage("IGRPT0105.E001", 0));
		}
		return dto;
	}

	/**���������ʼ��*/
	public IGRPT02DTO insertReportManageInitAction(IGRPT02DTO dto)
			throws BLException {
		List<SOC0207Info> rtInfoList=soc0207BL.searchSOC0207();
		dto.setReportTemplateList(rtInfoList);
		//��ѯ����
		SOC0202SearchCondImpl cond=new SOC0202SearchCondImpl();
		User curUser=dto.getCurUser();
		//�û�����
		cond.setRaUserName_eq(curUser.getUsername());
		List<SOC0202Info> raInfoList=soc0202BL.searchSOC0202(cond);
		if(raInfoList==null||raInfoList.size()==0){
			dto.addMessage(new ActionMessage("IGRPT0107.E001"));
		}
		dto.setRaInfoList(raInfoList);
		return dto;
	}
	/**ɾ���ļ�*/
	private void deleteFile(String path){
		
		File raFile=new File(path);
		if(raFile.exists()){
			raFile.delete();
		}
	}
	/**�޸ı����ʼ��*/
	public IGRPT02DTO initUpdateReportManageInstance(IGRPT02DTO dto)throws BLException{
		IGRPT0205Form form=dto.getIgrpt0205Form();
		Integer rmId=form.getRmId();
		SOC0205TB rmTB=(SOC0205TB) soc0205BL.searchSOC0205ByPK(rmId);
		
		if(rmTB!=null){
			//���ñ�������
			form.setRmName(rmTB.getRmName());
			//����Ĭ�ϱ���ģ��
			if(rmTB.getReportTemplateTB()!=null){
				form.setSelTemplate(rmTB.getReportTemplateTB().getRtId()+"");
			}else{
				form.setSelTemplate("none");
			}
			String dateType=rmTB.getRmDateType();
			//����ʱ������
			form.setRmDateType(dateType);
			//�����꼾��
			form.setSelRmYear(rmTB.getRmYear());
			if(dateType.equals("0")){
				form.setSelRmMonth(rmTB.getRmMonth());
			}else if(dateType.equals("1")){
				form.setSelRmQuarter(rmTB.getRmQuarter());
			}
			form.setRmId(rmTB.getRmId());
			
			//��ʼ������ģ��
			List<SOC0207Info> rtInfoList=soc0207BL.searchSOC0207();
			dto.setReportTemplateList(rtInfoList);
			//��ѯ����
			SOC0202SearchCondImpl cond=new SOC0202SearchCondImpl();
			User curUser=dto.getCurUser();
			//�û�����
			cond.setRaUserName_eq(curUser.getUsername());
			List<SOC0202Info> raInfoList=soc0202BL.searchSOC0202(cond);
			if(raInfoList==null||raInfoList.size()==0){
				dto.addMessage(new ActionMessage("IGRPT0107.E001"));
			}else{
				//��ȡʹ�ù��ĸ��ӱ���ID
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
	 * ��������޸�
	 * 
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO updateReportManageInstance(IGRPT02DTO dto)throws BLException{
		//��ȡ05form
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
			
			//ģ�����
			SOC0207TB rtTB= (SOC0207TB) soc0207BL.searchSOC0207ByPK(Integer.parseInt(form.getSelTemplate()));
			rmTb.setReportTemplateTB(rtTB);
			rmTb.setRmYear(form.getSelRmYear());
			rmTb.setRtName(rtTB.getRtName());
			String curDateType=rtTB.getRtDateType();
			rmTb.setRmDateType(curDateType);
			int year =Integer.parseInt(form.getSelRmYear());
			String curRmDateStr="2012/01/01";
			if(curDateType.equals("0")){//�·�
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
			}else if(curDateType.equals("1")){//����
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
			//����ʹ�ù��ĸ��ӱ���
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
			//��ź�׺��
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
			//���ɱ���
			dto=createWordAction(dto,rmInfo);
			
		}else{
			dto.addMessage(new ActionMessage("IGRPT0105.E001", 0));
		}
		return dto;
	}

	/**
	 * �Զ��屨���������
	 * 
	 * @return IGRPT01DTO
	 */
	public IGRPT02DTO searchSOC0204Action(IGRPT02DTO dto)throws BLException {
		log.debug("=====�Զ��屨��������Ӽ�����ʼ=====");
		SOC0204SearchCondImpl cond =new SOC0204SearchCondImpl();
		cond.setRclUserId_eq(dto.getCurUser().getUserid());
		cond.setRclReportType_eq("01");
		List<SOC0204Info> list_p=soc0204BL.searchSOC0204(cond);
		if(list_p.size()>0){
			dto.setReportCustomLinkList_Pref(list_p);//01����
		}
		cond.setRclReportType_eq("03");
		List<SOC0204Info> list_c=soc0204BL.searchSOC0204(cond);
		if(list_c.size()>0){
			dto.setReportCustomLinkList_Cap(list_c);//03����
		}
		log.debug("=====�Զ��屨��������Ӽ�������=====");
		return dto;
	}
}
