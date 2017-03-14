/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.dev.vim.igflow.event.status;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.SchedulerException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.scheduling.jobs.JobManager;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM03BL;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;
import com.deliverik.infogovernor.soc.vir.model.condition.Vim03SearchCondImpl;
import com.dev.vim.igflow.jobs.IGVIM0102JOB;
import com.dev.vim.igflow.jobs.IGVIM0201JOB;
import com.dev.vim.igflow.jobs.IGVIM0202JOB;

public class IGVIM0201BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGVIM0201BLImpl.class);
    private FlowSearchBL flowSearchBL;

    /** ��Դ���������Ϣ��ҵ���߼� */
    protected VIM03BL vim03BL;
    
    public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
        this.flowSearchBL = flowSearchBL;
    }

    /**
     * ������Դ���������Ϣ��ҵ���߼�
     * @param vim03BL ��Դ���������Ϣ��ҵ���߼�
     */
    public void setVim03BL(VIM03BL vim03bl) {
        vim03BL = vim03bl;
    }

    public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
        
    }

    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {

        log.debug("========��Դ�����Զ�����ǰ����ʼ========");
        
        String pid = this.flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "��Ŀ����");
        if(StringUtils.isEmpty(pid)){
            
            log.error("��Ŀ����������");
            return;
        }
        
        // ������Ŀ��ѯ�����Ϣ
        Vim03SearchCondImpl cond = new Vim03SearchCondImpl();
        cond.setPid_eq(Integer.parseInt(pid));
        List<VIM03Info> searchVim03 = this.vim03BL.searchVim03(cond);
        // ���������ӿ�¡����
        for (VIM03Info vim03Info : searchVim03) {
            try {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("pid", vim03Info.getPid());
                map.put("vmid", vim03Info.getId());
                map.put("prid", bean.getLogInfo().getPrid());
                map.put("executorid", bean.getLogInfo().getExecutorid());
                JobManager.addRealTimeJob(IGVIM0201JOB.JOB_NAME + vim03Info.getId(), IGVIM0201JOB.JOB_GROUP_NAME, IGVIM0201JOB.TRIGGER_NAME + vim03Info.getId(), 
                        IGVIM0201JOB.TRIGGER_GROUP_NAME, new IGVIM0201JOB(), map);
            } catch (SchedulerException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
//        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pid", Integer.parseInt(pid));
        map.put("prid", bean.getLogInfo().getPrid());
        map.put("executorid", bean.getLogInfo().getExecutorid());
        
        try {
            JobManager.addRealTimeJob(IGVIM0202JOB.JOB_NAME + pid, IGVIM0202JOB.JOB_GROUP_NAME, IGVIM0202JOB.TRIGGER_NAME + pid, 
                    IGVIM0202JOB.TRIGGER_GROUP_NAME, new IGVIM0202JOB(), map);
        } catch (SchedulerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        log.debug("========��Դ�����Զ�����ǰ�������========");

    
    }
}
