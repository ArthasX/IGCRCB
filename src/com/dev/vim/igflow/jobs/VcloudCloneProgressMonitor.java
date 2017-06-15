/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: vm��������߳���
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class VcloudCloneProgressMonitor extends Thread{
	
	/** ��־���� */
	private Log log = LogFactory.getLog(VcloudCloneProgressMonitor.class);
	
	/** �����Ϣ */
	protected VCD03Info vcd03;
	
	/** ���BL */
	protected VCD03BL vcd03BL;
	
	/** ��־BL */
	protected VCD04BL vcd04BL;
	
	/** �Ƿ񴴽���� */
	private boolean created = false;
	
	/** ������Ϣ */
	protected Task task;

    /** ��¡����쳣��ʶ */
    protected boolean error;
    
    /** ��¡����ɹ���ʶ */
    protected boolean successed;
    
    /** ��ĿID */
    protected Integer pid;

	/**
	 * �����Ϣȡ��
	 * @return vcd03 �����Ϣ
	 */
	public VCD03Info getVcd03() {
		return vcd03;
	}

	/**
	 * �����Ϣ�趨
	 * @param vcd03 �����Ϣ
	 */
	public void setVcd03(VCD03Info vcd03) {
		this.vcd03 = vcd03;
	}

	/**
	 * ���BLȡ��
	 * @return vcd03BL ���BL
	 */
	public VCD03BL getVcd03BL() {
		return vcd03BL;
	}

	/**
	 * ���BL�趨
	 * @param vcd03BL ���BL
	 */
	public void setVcd03BL(VCD03BL vcd03bl) {
		vcd03BL = vcd03bl;
	}
	
	/**
	 * ��־BLȡ��
	 * @return vcd04BL ��־BL
	 */
	public VCD04BL getVcd04BL() {
		return vcd04BL;
	}

	/**
	 * ��־BL�趨
	 * @param vcd04BL ��־BL
	 */
	public void setVcd04BL(VCD04BL vcd04bl) {
		vcd04BL = vcd04bl;
	}

	/**
	 * ������Ϣȡ��
	 * @return task ������Ϣ
	 */
	public Task getTask() {
		return task;
	}

	/**
	 * ������Ϣ�趨
	 * @param task ������Ϣ
	 */
	public void setTask(Task task) {
		this.task = task;
	}

	/**
	 * ��¡����쳣��ʶȡ��
	 * @return error ��¡����쳣��ʶ
	 */
	public boolean isError() {
		return error;
	}

	/**
	 * ��¡����쳣��ʶ�趨
	 * @param error ��¡����쳣��ʶ
	 */
	public void setError(boolean error) {
		this.error = error;
	}

	/**
	 * ��¡����ɹ���ʶȡ��
	 * @return successed ��¡����ɹ���ʶ
	 */
	public boolean isSuccessed() {
		return successed;
	}

	/**
	 * ��¡����ɹ���ʶ�趨
	 * @param successed ��¡����ɹ���ʶ
	 */
	public void setSuccessed(boolean successed) {
		this.successed = successed;
	}

	/**
	 * ��ĿIDȡ��
	 * @return pid ��ĿID
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * ��ĿID�趨
	 * @param pid ��ĿID
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * �߳�����
	 */
	public void run(){
		while(!created){
			log.debug("=============== ����������ȴ���ʼ ===============");
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
				
				log.debug("=============== ����������ȴ������ ===============");
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
