/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.crc.bl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.infogovernor.crc.bl.task.IGCRC2301BL;
import com.deliverik.infogovernor.crc.dto.IGCRC2301DTO;
import com.deliverik.infogovernor.crc.form.IGCRC2301Form;
import com.deliverik.infogovernor.crc.model.IGCRC2301VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2301CondImpl;

/**	
 * ����:���򿪷�ͳ�Ʋ�ѯҵ���߼�ʵ��
 * ������¼��yukexin    2014-8-15 ����2:26:23	
 * �޸ļ�¼��null
 */	
public class IGCRC23BLImpl implements IGCRC23BL {

	static Log log = LogFactory.getLog(IGCRC23BLImpl.class);
	
	/** ���򿪷�ͳ����ϢBL */
	protected IGCRC2301BL igcrc2301BL;

	
	/** ���̴���BL*/
	protected WorkFlowOperationBL workFlowOperationBL;
	
	public void setIgcrc2301BL(IGCRC2301BL igcrc2301bl) {
		igcrc2301BL = igcrc2301bl;
	}
	
	/**
	 * @param workFlowOperationBL the workFlowOperationBL to set
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**	
	 * ���ܣ����򿪷���Ϣ��ѯ����
	 * @param dto IGCRC2301DTO
	 * @return IGCRC2301DTO
	 * @throws BLException
	 * �޸ļ�¼��null
	 */	
	public IGCRC2301DTO searchEntityItemAction(IGCRC2301DTO dto)
			throws BLException {
		log.debug("========���򿪷�ͳ����Ϣ��ѯ����ʼ========");
		//��ȡform
		IGCRC2301Form form = dto.getIgcrc2301Form();
		//ʵ����cond
		IGCRC2301CondImpl cond = new IGCRC2301CondImpl();
		//��ֵ
		cond = copyProperties(form, cond);
		//��ȡ����
		List<IGCRC2301VWInfo> crList = igcrc2301BL.searchIGCRC2301(cond);
		//��ֵdto
		dto.setEntityItemVWInfoList(crList);
		log.debug("========���򿪷���Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * ��ȡ ���� 
	 */
	public IGCRC2301DTO searchIG500ItemAction(IGCRC2301DTO dto)throws BLException {
		
		log.debug("========���򿪷�ͳ����Ϣ��ѯ����ʼ========");
		//��ȡform
		IGCRC2301Form form = dto.getIgcrc2301Form();
		//ʵ����cond
		IGCRC2301CondImpl cond = new IGCRC2301CondImpl();
		//��ֵ
		cond = copyProperties(form, cond);
		List<Integer> crList = null;
		
		//��������
		if(form.getFlag().equals("0")){
			//��ȡ�ô����˴�������й�����prid
			crList = igcrc2301BL.searchListSum(cond);
		}
		//���Ը��²���    ���²���    ȷ�ϲ���
		if(form.getFlag().equals("1") || form.getFlag().equals("2") || form.getFlag().equals("3")){
			//��ȡ�ô����˴���Ĳ��ع�����prid
			crList = igcrc2301BL.searchList(cond);			
		}
		IG500SearchCondImpl cond500 = new IG500SearchCondImpl();
		StringBuffer prid_in = new StringBuffer();
		// �жϹ������ϲ�Ϊ�գ���prid���һ���ַ���
		if(crList.size()>0){
			for(int i =0  ; i<crList.size(); i++){
				prid_in.append("'");
				prid_in.append(crList.get(i).toString());
				prid_in.append("'");
				if(i < crList.size()-1){
					prid_in.append(",");
				}
			}
			cond500.setPrid_in(prid_in.toString());
			//��ѯ���з��������Ĺ���
			dto.setProcessList(workFlowOperationBL.searchProcessByType(cond500, 0, 0,
					null));
			dto.getPagingDto().setTotalCount(dto.getProcessList().size());
		}
		
		log.debug("========���򿪷���Ϣ��ѯ��������========");
		return dto;
	}
	
	

	/**	
	 * ���ܣ���form�еĲ�ѯ��������cond
	 * @param form ҳ���ѯ����
	 * @param cond ��������
	 * @return
	 * �޸ļ�¼��
	 */	
	private IGCRC2301CondImpl copyProperties(IGCRC2301Form form, IGCRC2301CondImpl cond){
		//��
		cond.setYear(form.getYear());
		//��
		cond.setMonth(form.getMonth());
		//����Ҫ��ѯ��־λ
		if(form.getFlag()!=null){
			cond.setFlag(form.getFlag());			
		}
		//�����û�ID
		if(form.getUserID()!=null){
			cond.setUserid(form.getUserID());			
		}
		// ��ȡ��
		String year = form.getYear();
		// ��ȡ��
		String month = form.getMonth();
		String propentime = null;
		// �ж������Ƿ�Ϊ��
		if (year == null && month == null) {
			propentime = "%";
		} else {
			propentime = year + "/" + month + "%";
		}
		// ƴ�ӵ����¸�ֵ
		cond.setPropentime(propentime);
		return cond;
	}
}
