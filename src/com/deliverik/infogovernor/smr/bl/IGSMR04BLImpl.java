/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.bl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG337BL;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.infogovernor.smr.bl.task.RegulatoryReportInstanceBL;
import com.deliverik.infogovernor.smr.dto.IGSMR04DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0402Form;
import com.deliverik.infogovernor.smr.model.BatchExamineVWInfo;
import com.deliverik.infogovernor.smr.model.condition.RegulatoryReportInstanceSearchCondImpl;
import com.deliverik.infogovernor.smr.model.entity.BatchExamineVW;

/**
 * �걨����ҵ���߼�ʵ��
 *
 */
public class IGSMR04BLImpl extends BaseBLImpl implements IGSMR04BL {
	
	
	/** �����ʵ��BL */
	protected RegulatoryReportInstanceBL regulatoryReportInstanceBL;
	
	/** ������BL */
	protected IG337BL ig337BL;
	
	/** ���̴���BL */
	protected FlowOptBL flowOptBL;

	/** ���̴���BL */
	protected IG333BL ig333BL;
	
	/**��ֵbl*/
	protected IG599BL ig599BL;
	
	/**��������*/
	protected IG500BL ig500BL;
	/**
	 * �����ʵ��BL
	 * @param regulatoryReportInstanceBL
	 */	
	public void setRegulatoryReportInstanceBL(
			RegulatoryReportInstanceBL regulatoryReportInstanceBL) {
		this.regulatoryReportInstanceBL = regulatoryReportInstanceBL;
	}
	
	/**
	 *  ������BL
	 * @param ig337bl
	 */	
	public void setIg337BL(IG337BL ig337bl) {
		ig337BL = ig337bl;
	}
	
	public void setFlowOptBL(FlowOptBL flowOptBL) {
		this.flowOptBL = flowOptBL;
	}

	
	public void setIg333BL(IG333BL ig333bl) {
		ig333BL = ig333bl;
	}
    
	
	public void setIg599BL(IG599BL ig599bl) {
		ig599BL = ig599bl;
	}

	
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}

	/**
	 * �걨��ϸ�б��ѯ����
	 *
	 * @param dto IGSMR01DTO
	 * @return IGSMR01DTO
	 */
	public IGSMR04DTO initIGSMR0402Action(IGSMR04DTO dto) throws BLException {
		//ʵ������ѯ����
		RegulatoryReportInstanceSearchCondImpl cond = new RegulatoryReportInstanceSearchCondImpl();
		cond.setInstanceid(dto.getInstanceID());
		//��ѯ���������̰������̵�����ʱ��ͱ����������ʱ��
		List<BatchExamineVWInfo> list_be = regulatoryReportInstanceBL.findBatchExanmie(cond);
		//�½�һ��������˺ͱ��������˵ļ���
		List<BatchExamineVW> list_all = new ArrayList<BatchExamineVW>();
		//�������ϸ�������id��ѯ��Ӧ����˺ͱ���������
		for(BatchExamineVWInfo bean:list_be){
			BatchExamineVW tb = (BatchExamineVW)SerializationUtils.clone(bean);
			//�������
			String fillinusername ="";
			//�������״̬��ʶ��
			String fillincode = "";
			//��״̬���в�ѯ״̬��
			IG333SearchCondImpl cond333 = new IG333SearchCondImpl();
			cond333.setPsdname(IGSMRCONSTANT.PRSTATUSNAME_REPORT);
			cond333.setPdid(bean.getPrpdid());
			List<IG333Info> ig333 = ig333BL.searchIG333Info(cond333);
			for(IG333Info info3:ig333){
				fillincode = info3.getPsdcode();
			}
			//ʵ���������߲�ѯ����
			IG337SearchCondImpl cond337 = new IG337SearchCondImpl();
			cond337.setPpstatus_q(fillincode);
			cond337.setPrid(bean.getPrid());
			List<IG337Info> list_337 = ig337BL.getIG337Infos(cond337);
			//�������ƴд���
			for(int i=0;i<list_337.size();i++){
				IG337Info info1 = list_337.get(i);
				if(i!=list_337.size()-1){
					fillinusername = fillinusername+info1.getPpusername()+",";
				}else{
					fillinusername =fillinusername +info1.getPpusername();
				}
			}

			//���屨��������
			String examineusername = "";
			//���屨���״̬��ʶ��
			String examinecode = "";
			//��״̬���в�ѯ״̬��
			IG333SearchCondImpl cond_3 = new IG333SearchCondImpl();
			cond_3.setPsdname(IGSMRCONSTANT.PRSTATUSNAME_FIRSTEXAMINE);
			cond_3.setPdid(bean.getPrpdid());
			List<IG333Info> ig_3 = ig333BL.searchIG333Info(cond_3);
			for(IG333Info info3:ig_3){
				examinecode = info3.getPsdcode();
			}
			//ʵ���������߲�ѯ����
			IG337SearchCondImpl cond_ig337 = new IG337SearchCondImpl();
			cond_ig337.setPpstatus(examinecode);
			cond_ig337.setPrid(bean.getPrid());
			List<IG337Info> list_ig337 = ig337BL.getIG337Infos(cond_ig337);			
			//�������ƴд����������
			for(int i=0;i<list_ig337.size();i++){
				IG337Info info2 = list_ig337.get(i);
				if(i!=list_ig337.size()-1){
					examineusername = examineusername+info2.getPpusername()+",";
				}else{
					examineusername =examineusername +info2.getPpusername();
				}
			}
			//����˷Ž�ʵ����
			tb.setFillinusername(fillinusername);
			//�����������˷Ž�ʵ����
			tb.setExanimeusername(examineusername);
			IG599SearchCondImpl cond599 = new IG599SearchCondImpl();
		    cond599.setPrid(bean.getPrid());
		    cond599.setPivarlabel(IGSMRCONSTANT.BAOSONG_NULLTABLE);
		    List<IG599Info> ig599 =ig599BL.searchIG599InfosByCond(cond599);
		    if(ig599!=null&&ig599.size()!=0){		    	
		    	//�ж��Ƿ��Ϳձ����ñ�ʶ
		    	if(StringUtils.isNotEmpty(ig599.get(0).getPivarvalue())){
		    		tb.setFlag(IGSMRCONSTANT.BAOSONG_NULLTABLE);
		    	}
		    }
			//��ʵ��Ž�������
			list_all.add(tb);
		}
		dto.setLst_Report(list_all);
		return dto;
	}
	
	/**
	 * �걨��������
	 *
	 * @param dto IGSMR01DTO
	 * @return IGSMR01DTO
	 * @throws  
	 */
	public IGSMR04DTO managerIGSMR0402Action(IGSMR04DTO dto) throws BLException {
		//formȡ��
		IGSMR0402Form form = dto.getIgsmr0402Form();
	    for(Integer prid:form.getPrids()){						
	        //ѭ��ѡ������̣������̽��в��ػ�����ͨ������
	        if("1".equals(form.getType())){
	            flowOptBL.transitionProcess(prid, dto.getUser().getUserid(), "����ͨ��", IGStringUtils.getCurrentDateTime());
	        } else if("2".equals(form.getType())){
	            flowOptBL.transitionProcess(prid, dto.getUser().getUserid(), "����", IGStringUtils.getCurrentDateTime());
	        }
	    }
		return dto;
	}
}
