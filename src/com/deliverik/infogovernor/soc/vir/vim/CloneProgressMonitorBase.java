package com.deliverik.infogovernor.soc.vir.vim;

import com.vmware.vim25.mo.Task;

public class CloneProgressMonitorBase extends Thread {
    
    protected Task task;

    /** ��¡����쳣��ʶ */
    protected boolean error;
    
    /** ��¡����ɹ���ʶ */
    protected boolean successed;
    
    /**
     * ��ȡtask
     * @return task 
     */
    public Task getTask() {
        return task;
    }

    /**
     * ����task
     * @param task task
     */
    public void setTask(Task task) {
        this.task = task;
    }

    /**
     * ��ȡ��¡����쳣��ʶ
     * @return ��¡����쳣��ʶ 
     */
    public boolean isError() {
        return error;
    }

    /**
     * ���ÿ�¡����쳣��ʶ
     * @param error ��¡����쳣��ʶ
     */
    public void setError(boolean error) {
        this.error = error;
    }

    /**
     * ��ȡ��¡����ɹ���ʶ
     * @return ��¡����ɹ���ʶ 
     */
    public boolean isSuccessed() {
        return successed;
    }

    /**
     * ���ÿ�¡����ɹ���ʶ
     * @param successed ��¡����ɹ���ʶ
     */
    public void setSuccessed(boolean successed) {
        this.successed = successed;
    }
    
}
