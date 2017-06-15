package com.deliverik.infogovernor.soc.vir.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.infogovernor.soc.vir.model.VIM01Info;
import com.deliverik.infogovernor.soc.vir.vim.model.Host;

/**
 * ���⻯����ҵ����DTO
 * 
 */
@SuppressWarnings("serial")
public class IGVIR12DTO extends BaseDTO implements Serializable{
	
	/** ������*/
	protected List<Map<String, Object>> treeData;
	
	/** ��id*/
	protected String treeId;
	
	/** host��Ϣ*/
	protected Host host;
	
	/** �������������������/�رգ� */
	protected String vmName;
	
	/** ���������ʶ��1��������2���رգ� */
	protected String oprateType;
	
	/** vCenter������Ϣ���� */
	protected List<VIM01Info> vim01List;
	
	/** vCenter������ϢID */
	protected Integer vcid;
	
	/** Host��Ϣ���� */
	protected List<Host> hostList;

	/**
	 * ������ȡ��
	 * @return treeData ������
	 */
	public List<Map<String, Object>> getTreeData() {
		return treeData;
	}

	/**
	 * �������趨
	 * @param treeData ������
	 */
	public void setTreeData(List<Map<String, Object>> treeData) {
		this.treeData = treeData;
	}

	/**
	 * ��idȡ��
	 * @return treeId ��id
	 */
	public String getTreeId() {
		return treeId;
	}

	/**
	 * ��id�趨
	 * @param treeId ��id
	 */
	public void setTreeId(String treeId) {
		this.treeId = treeId;
	}

	/**
	 * host��Ϣȡ��
	 * @return host host��Ϣ
	 */
	public Host getHost() {
		return host;
	}

	/**
	 * host��Ϣ�趨
	 * @param host host��Ϣ
	 */
	public void setHost(Host host) {
		this.host = host;
	}

	/**
	 * �������������ȡ��
	 * @return
	 */
	public String getVmName() {
		return vmName;
	}

	/**
	 *  ��������������趨
	 * @param vmName
	 */
	public void setVmName(String vmName) {
		this.vmName = vmName;
	}

	/**
	 * ���������ʶȡ��
	 * @return
	 */
	public String getOprateType() {
		return oprateType;
	}

	/**
	 * ���������ʶ�趨
	 * @param oprateType
	 */
	public void setOprateType(String oprateType) {
		this.oprateType = oprateType;
	}

	/**
	 * vCenter������Ϣ����ȡ��
	 * @return vim01List vCenter������Ϣ����
	 */
	public List<VIM01Info> getVim01List() {
		return vim01List;
	}

	/**
	 * vCenter������Ϣ�����趨
	 * @param vim01List vCenter������Ϣ����
	 */
	public void setVim01List(List<VIM01Info> vim01List) {
		this.vim01List = vim01List;
	}

	/**
	 * vCenter������ϢIDȡ��
	 * @return vcid vCenter������ϢID
	 */
	public Integer getVcid() {
		return vcid;
	}

	/**
	 * vCenter������ϢID�趨
	 * @param vcid vCenter������ϢID
	 */
	public void setVcid(Integer vcid) {
		this.vcid = vcid;
	}

	/**
	 * Host��Ϣ����ȡ��
	 * @return hostList Host��Ϣ����
	 */
	public List<Host> getHostList() {
		return hostList;
	}

	/**
	 * Host��Ϣ�����趨
	 * @param hostList Host��Ϣ����
	 */
	public void setHostList(List<Host> hostList) {
		this.hostList = hostList;
	}
	
}


