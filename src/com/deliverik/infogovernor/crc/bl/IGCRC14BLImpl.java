/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.bl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.infogovernor.crc.bl.task.ChangeProcessVWBL;
import com.deliverik.infogovernor.crc.dto.IGCRC14DTO;
import com.deliverik.infogovernor.crc.form.IGCRC1401Form;
import com.deliverik.infogovernor.crc.model.ChangeProcessVWInfo;
import com.deliverik.infogovernor.crc.model.condition.ChangeProcessVWSearchCondImpl;
import com.deliverik.infogovernor.crc.model.vo.IGCRC14011VO;
import com.deliverik.infogovernor.crc.model.vo.IGCRC14012VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �����ѯBLʵ��
 * </p>
 * 
 * shikailong@deliverik.com
 * @version 1.0
 */
public class IGCRC14BLImpl extends BaseBLImpl implements IGCRC14BL {

	/** ��־���� */
	private static final Log log = LogFactory.getLog(IGCRC14BLImpl.class);

	/** �������ҵ���߼�BL*/
	protected ChangeProcessVWBL changeProcessVWBL;
	
	/** ���̶���ҵ���߼� */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;

	/** ���̴���ҵ���߼� */
	protected WorkFlowOperationBL workFlowOperationBL;
	/**
	 * �������ҵ���߼�BL�趨
	 * @param changeProcessVWBL the �������ҵ���߼�BL
	 */
	public void setChangeProcessVWBL(ChangeProcessVWBL changeProcessVWBL) {
		this.changeProcessVWBL = changeProcessVWBL;
	}

	/**
	 * ���̶���ҵ���߼��趨
	 * @param workFlowDefinitionBL the ���̶���ҵ���߼�
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	/**
	 * ���̴���ҵ���߼��趨
	 * @param workFlowOperationBL the ���̴���ҵ���߼�
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * ��ѯ�������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC14DTO searchEntityItemAction(IGCRC14DTO dto) throws BLException{
		log.debug("========��ѯ������̴���ʼ========");
		if(dto.getForm()!=null && dto.getForm() instanceof IGCRC1401Form){
			//ȡ��form
			IGCRC1401Form form = (IGCRC1401Form)dto.getForm();
			//��ȡcond
			ChangeProcessVWSearchCondImpl cond = new ChangeProcessVWSearchCondImpl();
			//�����Ų�ѯ
			cond.setPrserialnum_like(form.getPrserialnum());
			//��������趨
			cond.setPrtitle_like(form.getPrtitle());
			//�������
			cond.setChangetype_like(form.getChangetype());
			//����ƽ̨
			cond.setUpdateplatform_like(form.getUpdateplatform());
			//����״̬
			cond.setPrstatus(form.getPrstatus());
			//�������
			cond.setChangecategory(form.getChangecategory());
			//����ʱ��
			cond.setPropentime_begin(form.getPropentime());
			cond.setPropentime_end(form.getPrclosetime());
			//ҵ��Ӱ�췶Χ
			cond.setBusinessscope(form.getBusinessscope());
			//���ԭ��
			cond.setChangereason_like(form.getChangereason());
			//�Ƿ�Ӱ��ҵ��
			cond.setIsinfluence(form.getIsinfluence());
			//�������
			cond.setChangeclassify(form.getChangeclassify());
			//�������
			cond.setChangecontent_like(form.getChangecontent());
			//������
			cond.setPpusername_like(form.getPpusername_like());
			
			// ��ѯ��¼����
			int totalCount = changeProcessVWBL.getSearchCount(cond);
			if (totalCount == 0) {
				log.debug("========��ѯ���ݲ�����========");
				// ��ѯ���ݲ�����
				dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
				return dto;
			}
			if (totalCount > dto.getMaxSearchCount()) {
				log.debug("========��ѯ���ݼ�������========");
				// ��ѯ���ݼ�������
				dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
				return dto;
			}
			// ��ȡ��ҳbean
			PagingDTO pDto = dto.getPagingDto();
			// ����DAO�ӿڲ�ѯ
			List<ChangeProcessVWInfo> list = changeProcessVWBL.searchChangeProcessVW(cond, pDto.getFromCount(), pDto.getPageDispCount());
			IGCRC14011VO vo = new IGCRC14011VO();
			vo = copyVo(list, vo);
			dto.setIgcrc14011VO(vo);
			pDto.setTotalCount(totalCount);
			dto.setChangeProcessVWInfos(list);
		}
		log.debug("========��ѯ������̴���ʼ========");
		return dto;
		
	}
	
	/**
	 * ���Ƽ��ϵ�vo��
	 * @param list
	 * @param vo
	 * @return
	 */
	protected IGCRC14011VO copyVo(List<ChangeProcessVWInfo> list,IGCRC14011VO vo){
		List<IGCRC14012VO> list2 = new ArrayList<IGCRC14012VO>();
		if(list != null && list.size()>0){
			for(int i =0;i<list.size();i++){
				ChangeProcessVWInfo info = list.get(i);
				IGCRC14012VO vo2 = new IGCRC14012VO();	
				copyProperties(vo2, info);
				if(StringUtils.isNotBlank(info.getChangetype())){
					if(info.getChangetype().split("_tree_")!=null && info.getChangetype().split("_tree_").length>1){
						String type = info.getChangetype().split("_tree_")[1];
						String[] types = type.split("-");
						vo2.setChangetype(types[types.length-1]);
					}
				}
				if(StringUtils.isNotBlank(info.getUpdateplatform())){
					String type = info.getUpdateplatform();
					String type2 = type.replaceAll("#", "��").replaceAll("cv_cev_","");
					if(type2.indexOf("��") == 0){
						type2 = type2.substring(1, type2.length());
					}
					vo2.setUpdateplatform(type2);
				}
				if(StringUtils.isNotBlank(info.getPrdesc())){
					String type = info.getPrdesc().replaceAll("&nbsp;", " ")
										.replaceAll("<br>", "\t")
										.replaceAll("&gt;", ">")
										.replaceAll("&lt;", "<");
					vo2.setPrdesc(type);
				}
				list2.add(vo2);
			}
		}
		vo.setIgcrc14012vos(list2);
		return vo;
	}
	
	/**
	 * ����PDID��ȡ���õ�����PDID
	 */
	public IGCRC14DTO searchPdid7BitAction(IGCRC14DTO dto) throws BLException {
		log.debug("========��ǰ�����������ð汾��PDIDȡ�ô���ʼ========");
        IG380SearchCondImpl condImpl = new IG380SearchCondImpl();
        condImpl.setPdid_like("01084");
        condImpl.setPdstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);
        List<IG380Info> ig380infoList = workFlowDefinitionBL.searchProcessDefinition(condImpl);
        if (ig380infoList.size() == 0) {
            //throw new BLException("IGCO10000.E027", dto.getPdid());
        } else {
            dto.setPdid(ig380infoList.get(ig380infoList.size() - 1).getPdid());
          //��ѯ�����̶����µ���������״̬
            IG333SearchCondImpl ig333Cond = new IG333SearchCondImpl();
            ig333Cond.setPdid(dto.getPdid());
            List<IG333Info> ig333Infos = workFlowDefinitionBL.searchProcessStatusDef(ig333Cond);
            dto.setIg333InfoList(ig333Infos);
        }
        log.debug("========��ǰ�����������ð汾��PDIDȡ�ô�������========");
		return dto;
	}
	
	/**
	 * �����������Excel
	 * @return
	 * @throws BLException
	 */
	public IGCRC14DTO getExcelDataList(IGCRC14DTO dto) throws BLException {
		log.debug("=================��ȡ���������Ӧ���ݼ���ʼ=================");
	
		// ��ѯ��������Ϣ����(����)
		IG337SearchCondImpl processParticipantCond = new IG337SearchCondImpl();
		processParticipantCond.setPsdid("01084");
		// ��ѯ��������Ϣ
		dto.setProcessParticipantList(workFlowOperationBL.searchProcessParticipants(processParticipantCond));
		log.debug("=================��ȡ���������Ӧ���ݼ�����=================");
		return dto;
	}
	
}
