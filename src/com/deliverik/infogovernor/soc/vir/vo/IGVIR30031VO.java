/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.vir.model.VCD03Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �Զ����������ʾvo
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR30031VO extends BaseVO{
	
	/** ��ĿIG */
	protected Integer pid;
	
	/** �����ֵ�vm��Ϣ���� */
	protected List<VCD03Info> vcd03List;

	/**
	 * ��ĿIGȡ��
	 * @return pid ��ĿIG
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * ��ĿIG�趨
	 * @param pid ��ĿIG
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * �����ֵ�vm��Ϣ����ȡ��
	 * @return vcd03List �����ֵ�vm��Ϣ����
	 */
	public List<VCD03Info> getVcd03List() {
		return vcd03List;
	}

	/**
	 * �����ֵ�vm��Ϣ�����趨
	 * @param vcd03List �����ֵ�vm��Ϣ����
	 */
	public void setVcd03List(List<VCD03Info> vcd03List) {
		this.vcd03List = vcd03List;
	}
}
