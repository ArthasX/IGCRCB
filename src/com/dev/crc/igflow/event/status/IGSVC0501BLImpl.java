/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.dev.crc.igflow.event.status;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.drm.util.IGDRMEmergencyTools;
import com.deliverik.plugin.change.bl.IGCHANGE01BLImpl;
import com.deliverik.plugin.change.socket.IgChangeThread;
/**
 * ����ر�  �ڵ����WebServers
 * @author zhangqiang
 * @mail zhangq@deliverik.com
 * @time 2015-09-15
 *
 */
public class IGSVC0501BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
	/**��־����ȡ��*/
	static Log log = LogFactory.getLog(IGSVC0501BLImpl.class);
	
	protected IGCHANGE01BLImpl iGCHANGE01BLImpl;
	
	
    
	/**
	 * iGCHANGE01BLImpl�趨
	 * @param iGCHANGE01BLImpl iGCHANGE01BLImpl
	 */
	public void setiGCHANGE01BLImpl(IGCHANGE01BLImpl iGCHANGE01BLImpl) {
		this.iGCHANGE01BLImpl = iGCHANGE01BLImpl;
	}

	/**
     * ����
     */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		  log.debug("========������̹رսڵ����========");

		    //����prid
		    Integer prid = bean.getLogInfo().getPrid();
		    
		    Thread thread = new Thread(new IgChangeThread(prid));
			//�̵߳��ÿ�ʼ
			thread.start();
	      
			log.debug("========������̹رսڵ�������========");
			//�����ַͨ��ҵ��ϵͳID����ҵ��ϵͳӦ������״̬
			IGDRMEmergencyTools.changeFlowSystemState(prid, "0",null);
	}
	
	/**
	 * ǰ������Ӳ�����
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		
	  
	}

}

