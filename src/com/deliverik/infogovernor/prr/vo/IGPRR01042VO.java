/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG602Info;

/**
 * @Description: ���̶���_������Vo
 * @Author  
 * @History 2009-8-23     �½� 
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGPRR01042VO extends BaseVO implements Serializable {
	
	/** �û���ɫID */
	private Integer roleid;

	/** �û���ɫ���� */
	private String rolename;
	
	/** �û��б� */
	private List<IG602Info> lst_ProcessExecutorVW;
	
	/**
	 * ���캯��
	 * 
	 * @param roleid �û���ɫID
	 * @param rolename �û���ɫ����
	 * @param lst_ProcessExecutorVW �û��б�
	 */
	public IGPRR01042VO(Integer roleid, String rolename) {
		this.roleid = roleid;
		this.rolename = rolename;
	}

	/**
	 * �û���ɫIDȡ��
	 * @return �û���ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * �û���ɫ����ȡ��
	 * @return �û���ɫ����
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * �û��б�ȡ��
	 * 
	 * @return �û��б�
	 */
	public List<IG602Info> getLst_ProcessExecutorVW() {
		return lst_ProcessExecutorVW;
	}
	
	/**
	 * ���ִ����
	 * @param processExecutorVWInfo
	 */
	public void add(IG602Info processExecutorVWInfo) {
		if(lst_ProcessExecutorVW == null) {
			lst_ProcessExecutorVW = new ArrayList<IG602Info>();
		}
		lst_ProcessExecutorVW.add(processExecutorVWInfo);
	}

}
