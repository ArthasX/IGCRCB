/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.bl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.dut.bl.task.DelayBL;
import com.deliverik.infogovernor.dut.bl.task.DutyPlanBL;
import com.deliverik.infogovernor.dut.bl.task.DutyResultBL;
import com.deliverik.infogovernor.dut.bl.task.OnDutyPersonRecordBL;
import com.deliverik.infogovernor.dut.dto.IGDUT03DTO;
import com.deliverik.infogovernor.dut.form.IGDUT0302Form;
import com.deliverik.infogovernor.dut.form.IGDUT0304Form;
import com.deliverik.infogovernor.dut.model.DelayInfo;
import com.deliverik.infogovernor.dut.model.DutyPlan;
import com.deliverik.infogovernor.dut.model.DutyResult;
import com.deliverik.infogovernor.dut.model.OnDutyPersonRecordInfo;
import com.deliverik.infogovernor.dut.model.condition.DelaySearchCondImpl;
import com.deliverik.infogovernor.dut.model.condition.DutyPlanSearchCondImpl;
import com.deliverik.infogovernor.dut.model.condition.DutyResultSearchCondImpl;
import com.deliverik.infogovernor.dut.model.entity.DutyResultTB;

/**
 * ֵ���������BLʵ��
 */
public class IGDUT03BLImpl extends BaseBLImpl implements IGDUT03BL {

	static Log log = LogFactory.getLog(IGDUT03BLImpl.class);

	/** ֵ���������BL */
	protected DutyResultBL dutyResultBL;

	/** ֵ��ƻ�BL */
	protected DutyPlanBL dutyPlanBL;

	/** ά�ޱ�BL */
	protected OnDutyPersonRecordBL onDutyPersonRecordBL;

	/***/
	protected CodeDetailBL codeDetailBL;

	/** ��ʱ����BL */
	protected DelayBL delayBL;

	/**
	 * ��ʱ����BL�趨
	 * 
	 * @param delayBL
	 */
	public void setDelayBL(DelayBL delayBL) {
		this.delayBL = delayBL;
	}

	/**
	 * �趨
	 * 
	 * @param codeDetailBL
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	/**
	 * ֵ���������BL�趨
	 * 
	 * @param dutyResultBL
	 *            ֵ���������BL
	 */
	public void setDutyResultBL(DutyResultBL dutyResultBL) {
		this.dutyResultBL = dutyResultBL;
	}

	/**
	 * ֵ����ƻ�BL�趨
	 * 
	 * @param dutyPlanBL
	 *            ֵ����ƻ�BL
	 */
	public void setDutyPlanBL(DutyPlanBL dutyPlanBL) {
		this.dutyPlanBL = dutyPlanBL;
	}

	/**
	 * ֵ��������ܲ�ѯ����
	 * 
	 * @param dto
	 *            IGDUT03DTO
	 * @return IGDUT03DTO
	 */
	public IGDUT03DTO searchDutyResultAction(IGDUT03DTO dto) throws BLException {

		log.debug("========ֵ��������ܲ�ѯ����ʼ========");

		// ֵ��������ܲ�ѯ����ȡ��
		int totalCount = this.dutyResultBL.getSearchCount(dto
				.getDutyResultSearchCond());

		if (totalCount == 0) {
			log.debug("========ֵ��������ܲ�ѯ���ݲ�����========");
			// ֵ��������ܲ�ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========ֵ��������ܲ�ѯ���ݼ�������========");
			// ֵ��������ܲ�ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		// ��ǰҳ��Ϣȡ��
		List<DutyResult> dutyResultList = this.dutyResultBL.searchDutyResult(
				dto.getDutyResultSearchCond(), pDto.getFromCount(), pDto
						.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setDutyResultList(dutyResultList);

		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========ֵ��������ܲ�ѯ��������========");
		return dto;
	}

	/**
	 * ֵ��������ܲ�ѯ����
	 * 
	 * @param dto
	 *            IGDUT03DTO
	 * @return IGDUT03DTO
	 */
	public IGDUT03DTO searchAllDutyResultAction(IGDUT03DTO dto)
			throws BLException {

		log.debug("========ֵ��������ܲ�ѯ����ʼ========");

		// ��ǰҳ��Ϣȡ��
		List<DutyResult> dutyResultList = this.dutyResultBL.searchDutyResult(
				dto.getDutyResultSearchCond(), 0, 0);

		dto.setDutyResultList(dutyResultList);

		if (dutyResultList.size() > 0) {
			DutyPlanSearchCondImpl cond = new DutyPlanSearchCondImpl();
			cond.setDptime(dto.getDutyResultSearchCond().getDptime());
			List<DutyPlan> dpList = this.dutyPlanBL.searchDutyPlan(cond, 0, 0);
			for (DutyPlan dp : dpList) {
				if (IGDUTCONSTANTS.DAY_SHIFT.equals(dp.getDptype())) {
					dto.setDutyPlanAM(dp);
				} else if (IGDUTCONSTANTS.NIGHT_SHIFT.equals(dp.getDptype())) {
					dto.setDutyPlanPM(dp);
				}
			}
		}

		log.debug("========ֵ��������ܲ�ѯ��������========");
		return dto;
	}

	public IGDUT03DTO initIGDUT0301Action(IGDUT03DTO dto) throws BLException {
		int showYear = dto.getCalendarYear();
		int showMonth = dto.getCalendarMonth() + 1;
		Map<String, Integer> dutyResultMap = new HashMap<String, Integer>();
		String beginDate = showYear + "/" + appendZero(showMonth) + "/00";
		if (showMonth == 12) {
			showYear = showYear + 1;
			showMonth = 1;
		} else {
			showMonth++;
		}
		String endDate = showYear + "/" + appendZero(showMonth) + "/00";
		DutyResultSearchCondImpl dutyResultCond = new DutyResultSearchCondImpl();
		dutyResultCond.setDptime_ge(beginDate);
		dutyResultCond.setDptime_le(endDate);
		dutyResultCond.setDadcategory(dto.getDadcategory());
		List<DutyResult> dutyResultList = dutyResultBL.searchDutyResult(
				dutyResultCond, 0, 0);
		for (DutyResult dutyResult : dutyResultList) {
			String key = dutyResult.getDptime();
			String drcontent = dutyResult.getDrcontent();
			String drcretime = dutyResult.getDrcretime();
			// if(null == drcretime || (null != drcretime &&
			// dutyResult.getDrlimdtime().compareTo(drcretime)<0)){
			// dutyResultMap.put(key + "time", 1);
			// }
			if (null != drcretime
					&& dutyResult.getDrlimdtime().compareTo(drcretime) < 0) {
				dutyResultMap.put(key + "time", 1);
			} else if (("".equals(drcretime) || null == drcretime)
					&& dutyResult.getDrlimdtime().compareTo(
							IGStringUtils.getCurrentDateTime()) < 0) {
				dutyResultMap.put(key, 1); // �쳣
			}
			if (dutyResultMap.containsKey(key) && dutyResultMap.get(key) == 1) {
				continue;
			}
			if (IGDUTCONSTANTS.DUTY_RESULT_NORMAL.equals(drcontent)) {
				dutyResultMap.put(key, 0);
			} else {
				dutyResultMap.put(key, 1); // �쳣
			}
		}
		dto.setDutyResultMap(dutyResultMap);

		// ����
		Map<String, Integer> delayMap = new HashMap<String, Integer>();
		DelaySearchCondImpl delayCond = new DelaySearchCondImpl();
		delayCond.setDatetime_from(beginDate);
		delayCond.setDatetime_to(endDate);
		delayCond.setTitle_like(IGDUTCONSTANTS.DELAY_TITLE);
		List<DelayInfo> delayList = delayBL.searchDelay(delayCond);
		for (DelayInfo delayInfo : delayList) {
			String key = delayInfo.getDatetime().substring(0, 10);
			delayMap.put(key, 1);
		}
		dto.setDelayMap(delayMap);
		return dto;
	}

	private String appendZero(int arg) {
		if (arg < 10) {
			return "0" + arg;
		}
		return String.valueOf(arg);
	}

	/**
	 * ά�ޱ�BL�趨
	 * 
	 * @param onDutyPersonRecordBL
	 *            ά�ޱ�BL
	 */
	public void setOnDutyPersonRecordBL(
			OnDutyPersonRecordBL onDutyPersonRecordBL) {
		this.onDutyPersonRecordBL = onDutyPersonRecordBL;
	}

	/**
	 * ά�ޱ����&���¹��ܶ���
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDUT03DTO registOnDutyPersonRecordAction(IGDUT03DTO dto)
			throws BLException {
		IGDUT0304Form form = dto.getIgDUT0304Form();
		// �ж�����ӻ��Ǹ���
		if (form.getOdprid() == null) {
			dto.addMessage(new ActionMessage("IGDUT0304.I001", "�ճ�ά���Ǽ�"));
		} else {
			dto.addMessage(new ActionMessage("IGDUT0304.I001", "�ճ�ά������"));
		}
		//���ý����������
		String odprarea = "";
		//�ж��û��Ƿ�ѡ��checkbox(��������)
		if (form.getOdprareas() != null) {
			String[] odprareas = form.getOdprareas();
			//������ϳ�string׼������DB
			for (String odprareaTemp : odprareas) {
				odprarea = odprarea + odprareaTemp;
			}
		}
		//���ý�������
		form.setOdprarea(odprarea);
		//����|����
		OnDutyPersonRecordInfo info = onDutyPersonRecordBL
				.registOnDutyPersonRecord(form);
		dto.setOnDutyPersonRecordInfo(info);
		return dto;
	}

	/**
	 * ά�ޱ�ɾ�����ܶ���
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 * 
	 */
	public IGDUT03DTO deleteOnDutyPersonRecordAction(IGDUT03DTO dto)
			throws BLException {
		//��ʱ��������
		Integer id=0;
		//�ж��û��Ƿ�ѡ��checkbox(ɾ��)
		if(dto.getIgDUT0305Form().getDelall()!=null){
			//checkbox(ɾ��)ȡ��
  			String[]arg_i=dto.getIgDUT0305Form().getDelall();
  			//����ɾ��
  			for (int i = 0; i < arg_i.length; i++) {
  				
  				//������ֵ�趨
          		id=Integer.parseInt(arg_i[i]);
          		dto.getIgDUT0305Form().setOdprid_eq(id);
          		//������ӦBL����
          		onDutyPersonRecordBL.deleteOnDutyPersonRecordByPK(dto
          				.getOnDutyPersonRecordSearchCond().getOdprid_eq());
  			}
  			//�ÿ�������ѯ����
  			dto.getIgDUT0305Form().setOdprid_eq(null);
  			dto.addMessage(new ActionMessage("IGDUT0304.I001", "ɾ��"));
		}
		return dto;

	}

	/**
	 * ά�ޱ���¶���
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDUT03DTO updateOnDutyPersonRecordAction(IGDUT03DTO dto)
			throws BLException {
		//���ʵ��
		OnDutyPersonRecordInfo info = dto.getOnDutyPersonRecordInfo();
		
		//����ʵ��
		OnDutyPersonRecordInfo info_new = onDutyPersonRecordBL
				.updateOnDutyPersonRecord(info);
		//����dto
		dto.setOnDutyPersonRecordInfo(info_new);
		return dto;
	}

	/**
	 * ά�ޱ���������
	 * 
	 * @param dto
	 * @return IGDUT03DTO
	 * @throws BLException
	 */
	public IGDUT03DTO searchOnDutyPersonRecord(IGDUT03DTO dto)
			throws BLException {
		List<OnDutyPersonRecordInfo> list = onDutyPersonRecordBL
				.searchOnDutyPersonRecord(dto.getOnDutyPersonRecordSearchCond());
		dto.setOnDutyPersonRecordList(list);
		return dto;
	}

	/**
	 * ��ҳ����
	 * 
	 * @param dto
	 * @return IGDUT03DTO
	 */
	public IGDUT03DTO searchODPRAction(IGDUT03DTO dto) throws BLException {
		log.debug("========��ѯ����ʼ========");
		// ��ѯ��¼����
		int totalCount = onDutyPersonRecordBL.getSearchCount(dto
				.getOnDutyPersonRecordSearchCond());
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		// ��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		// ����DAO�ӿڲ�ѯ
		List<OnDutyPersonRecordInfo> odprList = onDutyPersonRecordBL
				.searchOnDutyPersonRecord(
						dto.getOnDutyPersonRecordSearchCond(), pDto
								.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setOnDutyPersonRecordList(odprList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========��ѯ��������========");
		return dto;
	}

	/** 
	 * ��ʼ������ҳ
	 */
	public IGDUT03DTO initIGDUT0304Action(IGDUT03DTO dto) throws BLException {
		//��ȡ��
		IGDUT0304Form form = dto.getIgDUT0304Form();
		//����������
		OnDutyPersonRecordInfo info = onDutyPersonRecordBL
				.searchOnDutyPersonRecordByPK(form.getOdprid());
		//Ϊ��Ԫ�ظ�ֵ
		form.setOdprid(info.getOdprid());
		//������Ա
		form.setOdprguest(info.getOdprguest());
		//������Ա��λ
		form.setOdprguestorg(info.getOdprguestorg());
		//������Ա���֤��
		form.setOdprguestidnum(info.getOdprguestidnum());
		//��������
		form.setOdprarea(info.getOdprarea());
		//����������ʱ����
		String[] odprareas = new String[info.getOdprarea().length()];
		for (int i = 0; i < info.getOdprarea().length(); i++) {
			odprareas[i] = info.getOdprarea().substring(i, i + 1);
		}
		//Ϊҳ���趨checkbox
		form.setOdprareas(odprareas);
		//����ʱ���趨
		form.setOdprctime(info.getOdprctime());
		//�뿪ʱ���趨
		form.setOdprltime(info.getOdprltime());
		//�������趨
		form.setOdpropter(info.getOdpropter());
		//��׼���趨
		form.setOdpracter(info.getOdpracter());
		//��¼��
		form.setOdprusername(info.getOdprusername());
		//����Ŀ��
		form.setOdprtarget(info.getOdprtarget());
		//������¼
		form.setOdprrecord(info.getOdprrecord());
		//¼��ʱ��
		form.setOdprinserttime(info.getOdprinserttime());
		//����dto
		dto.setIgDUT0304Form(form);

		return dto;

	}

	/**
	 * ��ѯ��������Checkbox List
	 * 
	 * @return
	 */
	public IGDUT03DTO searchOnDutyPersonRecordArea(IGDUT03DTO dto)
			throws BLException {
		//��ʼ����������
		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
		//ODPRAREA_LIST_KEY Ϊ ��������ļ�����������
		cond.setCcid(IGDUTCONSTANTS.ODPRAREA_LIST_KEY);
		//���������������������
		List<CodeDetail> list = codeDetailBL.searchCodeDetail(cond, 0);
		//����dto
		dto.setCodeDetailList(list);
		return dto;
	}
	
    /**
     * ֵ����˵���޸Ĵ���
     * @param dto
     * @return
     * @throws BLException
     */
	public IGDUT03DTO changeDrresultAction(IGDUT03DTO dto) throws BLException {
		log.debug("========ֵ����˵���޸Ĵ���ʼ========");
		//Formȡ��
		IGDUT0302Form form=dto.getIgDUT0302Form();
		//ֵ����drid����ֵ����
		DutyResult dutyResult=this.dutyResultBL.searchDutyResultByKey(form.getDrid());
		if(dutyResult!=null){
			DutyResultTB dutyResultTB=(DutyResultTB) SerializationUtils.clone(dutyResult);
			dutyResultTB.setDrresult(form.getDrresult());
			this.dutyResultBL.registDutyResult(dutyResultTB);
		}
		log.debug("========ֵ����˵���޸Ĵ�������========");
		return dto;
	}
}
