/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.drm.igflow.status;

import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.soc.asset.bl.task.SOC0118VWBL;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.framework.soc.asset.model.entity.SOC0118VWPK;
import com.deliverik.framework.workflow.prd.bl.task.IG731BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prd.model.IG731Info;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.task.SigninBL;
import com.deliverik.infogovernor.drm.util.IGDRMEmergencyTools;

/**
 * Ӧ��ָ������-������(�¼��ϱ�) �ڵ� ����
 * 
 * ����ָ����������(��������,Ӧ������)
 * 
 * @author �Ž�
 *
 *         2015-3-11 ����10:24:34
 */
public class IGDRMEVENT0903BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGDRMEVENT0903BLImpl.class);
    
    private FlowSearchBL flowSearchBL;
    
	private IG500BL ig500BL;

	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}

	/** Ӧ��ǩ��BL */
    private SigninBL signinBL;
    

	/**
	 * signinBL   �趨
	 * @param signinBL signinBL
	 */
	public void setSigninBL(SigninBL signinBL) {
		this.signinBL = signinBL;
	}


	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * ����ָ����������(��������,Ӧ������)
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		//��ȡӦ����������id
		String drillPrid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), IGDRMCONSTANTS.PRACTISE_PRID_LABEL);
		IG500TB processInfo = (IG500TB) ig500BL.searchIG500InfoByKey(bean.getLogInfo().getPrid());
		if (StringUtils.isEmpty(drillPrid)) {
			processInfo.setPrurgency("0");
			//�����ַͨ��ҵ��ϵͳID����ҵ��ϵͳӦ������״̬
			IGDRMEmergencyTools.changeSystemState(processInfo.getPrid(), "ҵ��ϵͳ", "7",null);

		} else {
			processInfo.setPrurgency("1");
		}
		ig500BL.updateIG500Info(processInfo);
		//��Ϣϵͳ���������ֵ
		Integer prid = bean.getLogInfo().getPrid();
		IG731BL ig731BL = (IG731BL) WebApplicationSupport.getBean("ig731BL");
		SOC0118VWBL soc0118VWBL = (SOC0118VWBL) WebApplicationSupport.getBean("soc0118VWBL");
		IG599BL ig599BL = (IG599BL) WebApplicationSupport.getBean("ig599BL");
		IG599SearchCondImpl cond = new IG599SearchCondImpl();
		log.debug("=================��ѯҵ��ϵͳ��ʼ=========================");
		List<IG731Info> ig731InfoList = ig731BL.searchSenceBySePrid(prid,"ҵ��ϵͳ");
		if(ig731InfoList!=null && ig731InfoList.size()>0){
			StringBuffer strBuf = new StringBuffer();
			for(int index = 0;index<ig731InfoList.size();index++){
			    IG731Info ig731Info = ig731InfoList.get(index);
			    //ͨ��������ѯҵ��ϵͳ�ʲ�
				SOC0118VWPK pk = new SOC0118VWPK("1".equals(ig731Info.getFingerPrint())?1:0, ig731Info.getEiid());
				log.debug("=================ҵ��ϵͳ��ID��"+pk.getId()+"_"+pk.getEiid()+"=========================");
				SOC0118VWInfo soc0118Info = soc0118VWBL.searchEntityItemByKey(pk);
				if(index==ig731InfoList.size()-1){
					strBuf.append(soc0118Info.getEiname() + "������");
				}else{
					strBuf.append(soc0118Info.getEiname() + "��");
				}
				
			}
			log.debug("=================ҵ��ϵͳ�����ƣ�"+strBuf.toString()+"=========================");
			cond.setPrid(prid);
			cond.setPivarlabel("��Ϣϵͳ�������");
			List<IG599Info> ig599InfoList = ig599BL.searchIG599InfosByCond(cond);
			if(ig599InfoList!=null && ig599InfoList.size()>0){
				IG599TB ig599TB = (IG599TB) SerializationUtils.clone(ig599InfoList.get(0));
				ig599TB.setPivarvalue(strBuf.toString());
				log.debug("=================�����̱���ֵ,����ID��"+ig599TB.getPrid()+"_"+ig599TB.getPivarlabel()+"=========================");
				ig599BL.updateIG599Info(ig599TB);
			}
		}
		log.debug("=================��ѯҵ��ϵͳ����=========================");
    }
	
	/**
	 * 
	 */
    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    	
    }
}
