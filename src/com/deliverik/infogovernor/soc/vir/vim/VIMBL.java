/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.vim;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.vim.model.Data_Center;
import com.deliverik.infogovernor.soc.vir.vim.model.Host;
import com.deliverik.infogovernor.soc.vir.vim.model.NetLabel;
import com.deliverik.infogovernor.soc.vir.vim.model.Resource_Pool;
import com.deliverik.infogovernor.soc.vir.vim.model.Template;

/**
 * ����: VIMҵ���߼��ӿ�
 * ��������: VIMҵ���߼��ӿ�
 * ������¼:
 * �޸ļ�¼:
 */
public interface VIMBL extends BaseBL {
	
	/**
	 * ��ȡ����vCenter��ģ���б�
	 * @return ģ���б�
	 * @throws BLException
	 */
	public List<Template> searchTemplate() throws BLException;
	
	/**
	 * ��ȡָ��vCenter�����������б�
	 * @param vcid vCenter����ID
	 * @return ���������б�
	 * @throws BLException
	 */
	public List<Data_Center> searchDatacenterByVcid(Integer vcid) throws BLException;
	
	/**
	 * ��ȡָ��vCenter����Դ���б�
	 * @param vcid vCenter����ID
	 * @return ��Դ���б�
	 * @throws BLException
	 */
	public List<Resource_Pool> searchResourcePoolByVcid(Integer vcid) throws BLException;
	
	/**
	 * ��ȡָ��vCenter������
	 * @param vcid vCenter����ID
	 * @return �����б�
	 * @throws BLException
	 */
	public List<Host> searchHostByVcid(Integer vcid) throws BLException;

	/**
	 * ��ȡָ�������������ǩ
	 * @param vcid vCenter����ID
	 * @param hostip ����IP
	 * @return �����ǩ�б�
	 * @throws BLException
	 */
	public List<NetLabel> searchNetLabelByHost(Integer vcid, String hostip) throws BLException;

	/**
     * ��ȡָ��Datacenter�������ǩ
     * @param vcid vCenter����ID
     * @param dcanem ������������
     * @return �����ǩ�б�
     * @throws BLException
     */
    public List<NetLabel> searchNetLabelByDatacenter(Integer vcid, String dcname) throws BLException;
    
	/**
	 * ͨ��ָ��ģ�渴��VM
	 * ��rpNameΪ��ʱ��Ĭ��ΪResources
	 * @param si vCenter����ʵ�� 
	 * @param cloneName ��VM����
	 * @param dcName ������������
	 * @param rpName ��Դ������
	 * @return ���س���Ϊ2������,[0]ֵ��0ʧ�ܣ�1�ɹ�;[1]ֵ��������Ϣ
	 * @throws BLException
	 */
	public String[] cloneVMFromTemplate(Template template, String cloneName, String dcName, String rpName, CloneProgressMonitorBase cloneProgressMonitor) throws BLException;
	
	/**
     * ͨ��ָ��ģ�渴�Ƶ���VM����
     * ��rpNameΪ��ʱ��Ĭ��ΪResources
     * @param vmName VM����
     * @return ���س���Ϊ2������,[0]ֵ��0ʧ�ܣ�1�ɹ�;[1]ֵ��������Ϣ
     * @throws BLException
     */
    public String[] reconfigVM(Template template, String vmName, CloneProgressMonitorBase cloneProgressMonitor) throws BLException;
    
	/**
	 * ͨ��ָ��ģ�渴��VM
	 * ��rpNameΪ��ʱ��Ĭ��ΪResources
	 * @param si vCenter����ʵ�� 
	 * @param cloneName ��VM����
	 * @param dcName ������������
	 * @param rpName ��Դ������
	 * @return ���س���Ϊ2������,[0]ֵ��0ʧ�ܣ�1�ɹ�;[1]ֵ��������Ϣ
	 * @throws BLException
	 */
	public String[] createVM(Template template, String cloneName, String dcName, String rpName) throws BLException;

	/**
	 * ��ȡָ��Host��Ϣ
	 * @param vcid vCenter����ID
	 * @param hostName host����
	 * @return Host��Ϣ
	 * @throws BLException
	 */
	public Host getHostInfo(Integer vcid,String hostName) throws BLException;
	
	/**
	 * �����������/�ػ���
	 * @param oprateType
	 * @param vmName
	 * @return
	 * @throws BLException
	 */
	public String oprateVM(Integer vcid, String hostName,String vmName,String oprateType) throws BLException;
	
	/**
     * ���������
     * @param vcid ���������ID
     * @param vmname ���������
     * @param cloneProgressMonitor ���������߳�
     * @return
     * @throws BLException
     */
    public String[] RecycleVM(Integer vcid,String vmname, CloneProgressMonitorBase cloneProgressMonitor) throws BLException;

    /**
     * �ر����
     * @param name
     * @throws BLException
     */
	public void poweredOffVM(Integer vcid, String name,String hostname) throws BLException;
	
	/**
	 * �������
	 * @param name
	 * @throws BLException
	 */
	public void poweredOnVM(Integer vcid, String name,String hostname) throws BLException;
}
