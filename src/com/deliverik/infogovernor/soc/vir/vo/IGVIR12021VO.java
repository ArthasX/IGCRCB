/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.vir.model.VIM01Info;
import com.deliverik.infogovernor.soc.vir.vim.model.Host;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��Դʹ�����չʾVO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR12021VO extends BaseVO{

	/** ������ϢID */
	protected Integer vcid;
	
	/** ������Ϣ */
	protected List<VIM01Info> vim01List;
	
	/** Host��Ϣ���� */
	protected List<Host> hostList;

	/**
	 * ������ϢIDȡ��
	 * @return vcid ������ϢID
	 */
	public Integer getVcid() {
		return vcid;
	}

	/**
	 * ������ϢID�趨
	 * @param vcid ������ϢID
	 */
	public void setVcid(Integer vcid) {
		this.vcid = vcid;
	}

	/**
	 * ������Ϣȡ��
	 * @return vim01List ������Ϣ
	 */
	public List<VIM01Info> getVim01List() {
		return vim01List;
	}

	/**
	 * ������Ϣ�趨
	 * @param vim01List ������Ϣ
	 */
	public void setVim01List(List<VIM01Info> vim01List) {
		this.vim01List = vim01List;
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
