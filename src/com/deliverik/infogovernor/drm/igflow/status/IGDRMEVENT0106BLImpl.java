/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.drm.igflow.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCondImpl;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.IG731BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG731Info;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG731SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;
import com.deliverik.infogovernor.drm.util.ComputingTime;
import com.deliverik.infogovernor.drm.util.IGDRMEmergencyTools;
import com.ibm.icu.text.SimpleDateFormat;

/**
 * ��Ԥ�ƻָ�ʱ�丳ֵ
 * 
 * @author zb
 */
public class IGDRMEVENT0106BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGDRMEVENT0106BLImpl.class);
   
    private IG599BL ig599BL;
    private IG333BL ig333BL;
    private IG731BL ig731BL;
    private SOC0107BL soc0107BL;
    
	/**  
	 * ��ȡsoc0107BL  
	 * @return soc0107BL 
	 */
	public SOC0107BL getSoc0107BL() {
		return soc0107BL;
	}

	/**  
	 * ����soc0107BL  
	 * @param soc0107BL
	 */
	
	public void setSoc0107BL(SOC0107BL soc0107bl) {
		soc0107BL = soc0107bl;
	}

	/**  
	 * ��ȡig599BL  
	 * @return ig599BL 
	 */
	public IG599BL getIg599BL() {
		return ig599BL;
	}

	/**  
	 * ��ȡig731BL  
	 * @return ig731BL 
	 */
	public IG731BL getIg731BL() {
		return ig731BL;
	}

	/**  
	 * ����ig731BL  
	 * @param ig731BL
	 */
	
	public void setIg731BL(IG731BL ig731bl) {
		ig731BL = ig731bl;
	}

	/**  
	 * ����ig599BL  
	 * @param ig599BL
	 */
	
	public void setIg599BL(IG599BL ig599bl) {
		ig599BL = ig599bl;
	}

	/**  
	 * ��ȡig333BL  
	 * @return ig333BL 
	 */
	public IG333BL getIg333BL() {
		return ig333BL;
	}

	/**  
	 * ����ig333BL  
	 * @param ig333BL
	 */
	
	public void setIg333BL(IG333BL ig333bl) {
		ig333BL = ig333bl;
	}

	/**
	 * ���Ԥ��ʱ��ֵ
	 */
    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    	
    }

	/* (non-Javadoc)
	 * @see com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL#afterTreatmentExecute(com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo)
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		//ͨ��prid��ѯ��Ӧ�������ʲ���piid
		log.debug("========����Ԥ�ƻָ�ʱ�俪ʼ==========");
		Integer prid = bean.getLogInfo().getPrid();
    	IG599SearchCondImpl ig599Cond = new IG599SearchCondImpl();
    	ig599Cond.setPrid(prid);
    	ig599Cond.setPivarname("Ӧ������");
    	List<IG599Info> ig599List = ig599BL.searchIG599InfosByCond(ig599Cond);
    	Integer piid = 0;
//    	ͨ��piid��ѯ���������ʲ�
    	List<IG731Info> ig731List = new ArrayList<IG731Info>();
    	Integer eiid = 0;
    	if(ig599List!=null && ig599List.size()>0){
    		piid = ig599List.get(0).getPiid();
    	}
    	if(piid!=0){
    		IG731SearchCondImpl ig731Cond = new IG731SearchCondImpl();
    		ig731Cond.setPrid(prid);
    		ig731Cond.setPiid(piid);
    		ig731List = ig731BL.searchIG731Info(ig731Cond);
    	}
		if(ig731List!=null && ig731List.size()>0){
			eiid = ig731List.get(0).getEiid();
		}
		log.debug("========�����ʲ���eiid="+eiid+"==========");
		List<SOC0107Info> searchSOC0107List = new ArrayList<SOC0107Info>();
		if(eiid !=0){
			SOC0107SearchCondImpl soc0107Cond = new SOC0107SearchCondImpl();
			soc0107Cond.setEiid(eiid.toString());
			soc0107Cond.setCid("CI600000001004");
			searchSOC0107List = soc0107BL.searchSOC0107(soc0107Cond);
			
		}
		//ͨ���ʲ���ѯ������
		if(searchSOC0107List!=null && searchSOC0107List.size()>0){
			IG333SearchCondImpl ig333Cond = new IG333SearchCondImpl();
			ig333Cond.setPdid(searchSOC0107List.get(0).getCivalue());
			List<IG333Info> ig333List = ig333BL.searchIG333Info(ig333Cond);
			Map<String,IG333Info> ig333Map = new HashMap<String, IG333Info>();
    		if(ig333List!=null && ig333List.size()>0){
    			for(IG333Info ig333Info:ig333List){
    					ig333Map.put(ig333Info.getPsdid(), ig333Info);
    			}
    		}
    		//�����Ԥ�ƻָ�ʱ��
    		if(ig333Map.size()>2){
    			ComputingTime computingTime = new ComputingTime();
    			Integer countTotalTime = computingTime.countTotalTime(ig333Map);
    			log.debug("========���̵�Ԥ�ƻظ�ʱ��="+countTotalTime+"==========");
    			ig599Cond.setPivarname("�ָ�����ʱ��");
    			List<IG599Info> ig599List1 = ig599BL.searchIG599InfosByCond(ig599Cond);
    			if(ig599List1!=null && ig599List1.size()>0){
    				IG599TB ig599TB = (IG599TB) ig599List1.get(0);
    				ig599TB.setPivarvalue(countTotalTime.toString());
    				ig599BL.updateIG599Info(ig599TB);
    			}
    		}
		}
		log.debug("========����Ԥ�ƻָ�ʱ�����==========");
	}
    
}
