package com.deliverik.infogovernor.soc.vir.vim;

import com.vmware.vim25.mo.Task;

public class CloneProgressMonitorBase extends Thread {
    
    protected Task task;

    /** 克隆虚机异常标识 */
    protected boolean error;
    
    /** 克隆虚机成功标识 */
    protected boolean successed;
    
    /**
     * 获取task
     * @return task 
     */
    public Task getTask() {
        return task;
    }

    /**
     * 设置task
     * @param task task
     */
    public void setTask(Task task) {
        this.task = task;
    }

    /**
     * 获取克隆虚机异常标识
     * @return 克隆虚机异常标识 
     */
    public boolean isError() {
        return error;
    }

    /**
     * 设置克隆虚机异常标识
     * @param error 克隆虚机异常标识
     */
    public void setError(boolean error) {
        this.error = error;
    }

    /**
     * 获取克隆虚机成功标识
     * @return 克隆虚机成功标识 
     */
    public boolean isSuccessed() {
        return successed;
    }

    /**
     * 设置克隆虚机成功标识
     * @param successed 克隆虚机成功标识
     */
    public void setSuccessed(boolean successed) {
        this.successed = successed;
    }
    
}
