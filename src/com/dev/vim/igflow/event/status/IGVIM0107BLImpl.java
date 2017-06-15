/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.dev.vim.igflow.event.status;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM03BL;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM03TB;

/**
 * ��Դ����������������������
 * 
 * @author DLK)Administrator
 * @version 1.0.0
 */
public class IGVIM0107BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGVIM0107BLImpl.class);
    private FlowSearchBL flowSearchBL;
    
    /** ���¹���API�� */
    private FlowSetBL flowSetBL;

    /** �û���ɫ����BL */
    private UserRoleBL userRoleBL;

    /** ��Դ���������Ϣ��ҵ���߼� */
    protected VIM03BL vim03BL;
    
    public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
        this.flowSearchBL = flowSearchBL;
    }

    /**
     * ���ø��¹���API��
     * @param flowSetBL ���¹���API��
     */
    public void setFlowSetBL(FlowSetBL flowSetBL) {
        this.flowSetBL = flowSetBL;
    }

    /**
     * �����û���ɫ����BL
     * @param userRoleBL �û���ɫ����BL
     */
    public void setUserRoleBL(UserRoleBL userRoleBL) {
        this.userRoleBL = userRoleBL;
    }

    /**
     * ������Դ���������Ϣ��ҵ���߼�
     * @param vim03BL ��Դ���������Ϣ��ҵ���߼�
     */
    public void setVim03BL(VIM03BL vim03bl) {
        vim03BL = vim03bl;
    }

    public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
        log.debug("======== ��Դ���������������������̴���ʼ========");
        
        Integer prid = bean.getLogInfo().getPrid();
        String vmids = flowSearchBL.searchPublicProcessInfo(prid, "�������");
        
        if (StringUtils.isNotEmpty(vmids)) {
            String[] vmidarr = vmids.split("#");
            for (String vmid : vmidarr) {
                VIM03Info info = this.vim03BL.searchVim03ByPK(Integer.parseInt(vmid));
                VIM03TB vim03tb = (VIM03TB) SerializationUtils.clone(info);
                vim03tb.setPrid(prid);
                this.vim03BL.updateVim03(vim03tb);
            }
        }
        
        log.debug("======== ��Դ���������������������̴������ ========");
    }

    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {

        
    }
}
