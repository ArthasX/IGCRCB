/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.soc.alarm.bl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.soc.alarm.bl.task.CRM04BL;
import com.deliverik.infogovernor.soc.alarm.bl.task.CRM05BL;
import com.deliverik.infogovernor.soc.alarm.dto.IGALM04DTO;
import com.deliverik.infogovernor.soc.alarm.form.IGALM0401Form;
import com.deliverik.infogovernor.soc.alarm.model.CRM04Info;
import com.deliverik.infogovernor.util.CodeDefine;


/**
 * ���̶���ҵ���߼�ʵ��
 *
 */
public class IGALM04BLImpl extends BaseBLImpl implements IGALM04BL {
	
	static Log log = LogFactory.getLog(IGALM04BLImpl.class);
	
	protected CRM05BL crm05BL;
	
	protected CRM04BL crm04BL;
	
	/** ��������taskBL */
	protected CodeDetailBL codeDetailBL;

	public void setCrm05BL(CRM05BL crm05BL) {
		this.crm05BL = crm05BL;
	}
	
	public void setCrm04BL(CRM04BL crm04BL) {
		this.crm04BL = crm04BL;
	}
	
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}
	/**
	 * �澯��Ϣ��ѯ
	 * 
	 * @param dto IGALM04DTO
	 * @return IGALM04DTO
	 * @throws BLException
	 */
	public IGALM04DTO searchCRM04Action(IGALM04DTO dto){
		log.debug("========�澯��Ϣ��ѯҳ���ѯ����ʼ========");
		//Formȡ��
		IGALM0401Form form=dto.getIgalm0401Form();
		// �澯��Ϣ��ѯ����ȡ��
		int totalCount = this.crm04BL.getSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========�澯��Ϣ��ѯҳ���ѯ���ݲ�����========");
			// �澯��Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========�澯��Ϣ��ѯҳ���ѯ���ݼ�������========");
			// �������ݱ�����ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		// ��ǰҳ�������ݱ���ȡ��
		List<CRM04Info> crm04infoList = this.crm04BL.searchCRM04(form,pDto.getFromCount(),pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setCrm04infoList(crm04infoList);

		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========�澯��Ϣ��ѯҳ���ѯ��������========");
		return dto;
	}
	
	/**
	 * ��ȡ�澯����
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public IGALM04DTO getAlarmPriority(IGALM04DTO dto) throws BLException {
		
		String alarmPrioritiesStr = "";
        CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
        condimpl.setCcid(CodeDefine.MOCHAALARM_PRIORITY.getCcid());
        List<CodeDetail> cds = this.codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
        dto.setAlarmPrioritiesList(cds);
        //ҳ��澯�����ѯ����
        for(CodeDetail cd:cds){
        	alarmPrioritiesStr = alarmPrioritiesStr + cd.getCid()+"&"+cd.getCvalue()+",";
        }
        dto.setAlarmPrioritiesStr(alarmPrioritiesStr);
        return dto;
	}
	
	/**
	 * ��ȡʵʱ����ˢ��Ƶ��
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public IGALM04DTO getRefreshRate(IGALM04DTO dto) throws BLException {
		CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
        condimpl.setCcid("950");
        condimpl.setCid("4");
        List<CodeDetail> cds = this.codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
        String rate = cds.get(0).getCvalue();
        if(StringUtils.isEmpty(rate) || "0".equals(rate)) rate = "60";
        dto.setRefreshRate(rate.trim());
		return dto;
	}	
}
