/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.vim.igflow.jobs;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.soc.vir.bl.task.VCD03BL;
import com.deliverik.infogovernor.soc.vir.bl.task.VCD04BL;
import com.deliverik.infogovernor.soc.vir.model.VCD03Info;
import com.deliverik.infogovernor.soc.vir.model.entity.VCD03TB;
import com.deliverik.infogovernor.soc.vir.model.entity.VCD04TB;
import com.vmware.vcloud.sdk.Task;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: vm部署进度线程类
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class VcloudCloneProgressMonitor extends Thread{
	
	/** 日志对象 */
	private Log log = LogFactory.getLog(VcloudCloneProgressMonitor.class);
	
	/** 虚机信息 */
	protected VCD03Info vcd03;
	
	/** 虚机BL */
	protected VCD03BL vcd03BL;
	
	/** 日志BL */
	protected VCD04BL vcd04BL;
	
	/** 是否创建完成 */
	private boolean created = false;
	
	/** 任务信息 */
	protected Task task;

    /** 克隆虚机异常标识 */
    protected boolean error;
    
    /** 克隆虚机成功标识 */
    protected boolean successed;
    
    /** 项目ID */
    protected Integer pid;

	/**
	 * 虚机信息取得
	 * @return vcd03 虚机信息
	 */
	public VCD03Info getVcd03() {
		return vcd03;
	}

	/**
	 * 虚机信息设定
	 * @param vcd03 虚机信息
	 */
	public void setVcd03(VCD03Info vcd03) {
		this.vcd03 = vcd03;
	}

	/**
	 * 虚机BL取得
	 * @return vcd03BL 虚机BL
	 */
	public VCD03BL getVcd03BL() {
		return vcd03BL;
	}

	/**
	 * 虚机BL设定
	 * @param vcd03BL 虚机BL
	 */
	public void setVcd03BL(VCD03BL vcd03bl) {
		vcd03BL = vcd03bl;
	}
	
	/**
	 * 日志BL取得
	 * @return vcd04BL 日志BL
	 */
	public VCD04BL getVcd04BL() {
		return vcd04BL;
	}

	/**
	 * 日志BL设定
	 * @param vcd04BL 日志BL
	 */
	public void setVcd04BL(VCD04BL vcd04bl) {
		vcd04BL = vcd04bl;
	}

	/**
	 * 任务信息取得
	 * @return task 任务信息
	 */
	public Task getTask() {
		return task;
	}

	/**
	 * 任务信息设定
	 * @param task 任务信息
	 */
	public void setTask(Task task) {
		this.task = task;
	}

	/**
	 * 克隆虚机异常标识取得
	 * @return error 克隆虚机异常标识
	 */
	public boolean isError() {
		return error;
	}

	/**
	 * 克隆虚机异常标识设定
	 * @param error 克隆虚机异常标识
	 */
	public void setError(boolean error) {
		this.error = error;
	}

	/**
	 * 克隆虚机成功标识取得
	 * @return successed 克隆虚机成功标识
	 */
	public boolean isSuccessed() {
		return successed;
	}

	/**
	 * 克隆虚机成功标识设定
	 * @param successed 克隆虚机成功标识
	 */
	public void setSuccessed(boolean successed) {
		this.successed = successed;
	}

	/**
	 * 项目ID取得
	 * @return pid 项目ID
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * 项目ID设定
	 * @param pid 项目ID
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * 线程运行
	 */
	public void run(){
		while(!created){
			log.debug("=============== 更新虚机进度处理开始 ===============");
			if(this.vcd03 == null){
				continue;
			}
			
			VCD03TB vcd03TB = (VCD03TB) SerializationUtils.clone(vcd03);
			try{
				if(isError()){
					vcd03TB.setProgress("-1");
					vcd03BL.updateVCD03(vcd03TB);
					VCD04TB entity = new VCD04TB();
					entity.setContent(task.getResource().getDescription());
					entity.setFlag(task.getResource().getStatus());
					entity.setPid(pid);
					vcd04BL.registVCD04(entity);
					created = true;
				}
				
				if(getTask() == null){
					break;
				}
				
				Integer progress = getTask().getProgress();
				
				if(progress == null){
					continue;
				}
				
				vcd03TB.setProgress(progress + "");
				getVcd03BL().updateVCD03(vcd03TB);
				
				if(progress == 100){
					VCD04TB entity = new VCD04TB();
					entity.setContent(task.getResource().getDescription());
					entity.setFlag(task.getResource().getStatus());
					entity.setPid(pid);
					vcd04BL.registVCD04(entity);
					created = true;
				}
				
				log.debug("=============== 更新虚机进度处理结束 ===============");
			}catch(Exception e){
				log.debug("",e);
				vcd03TB.setProgress("-1");
				try {
					vcd03BL.updateVCD03(vcd03TB);
				} catch (BLException e1) {
					log.debug("",e1);
				}
				created = true;
			}
		}
	}
}
