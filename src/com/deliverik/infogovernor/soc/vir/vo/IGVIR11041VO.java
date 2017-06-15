package com.deliverik.infogovernor.soc.vir.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;

/**
 * ������Դͳ�ƽ��	VO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGVIR11041VO extends BaseVO implements Serializable{
	
	/**
	 * ������Դͳ�ƽ��
	 */
	protected List<VIM03Info> oneVim03List;
	/**
	 * ������Դͳ�ƽ����ĳһ�û���
	 */
	protected List<VIM03Info> oneVim03uList;
	/**
	 * �û���Ϣ
	 */
	protected User user;

	/**
	 * ������Դͳ�ƽ��ȡ��
	 * @return oneVim03List ������Դͳ�ƽ��
	 */
	public List<VIM03Info> getOneVim03List() {
		return oneVim03List;
	}

	/**
	 * ������Դͳ�ƽ���趨
	 * @param oneVim03List ������Դͳ�ƽ��
	 */
	public void setOneVim03List(List<VIM03Info> oneVim03List) {
		this.oneVim03List = oneVim03List;
	}

	/**
	 * ������Դͳ�ƽ����ĳһ�û���ȡ��
	 * @return oneVim03uList ������Դͳ�ƽ����ĳһ�û���
	 */
	public List<VIM03Info> getOneVim03uList() {
		return oneVim03uList;
	}

	/**
	 * ������Դͳ�ƽ����ĳһ�û����趨
	 * @param oneVim03uList ������Դͳ�ƽ����ĳһ�û���
	 */
	public void setOneVim03uList(List<VIM03Info> oneVim03uList) {
		this.oneVim03uList = oneVim03uList;
	}

	/**
	 * �û���Ϣȡ��
	 * @return user �û���Ϣ
	 */
	public User getUser() {
		return user;
	}

	/**
	 * �û���Ϣ�趨
	 * @param user �û���Ϣ
	 */
	public void setUser(User user) {
		this.user = user;
	}

}


