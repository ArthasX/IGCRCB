package com.deliverik.infogovernor.soc.vir.dto;

import java.io.Serializable;
import java.util.List;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.vir.form.IGVIR1101Form;
import com.deliverik.infogovernor.soc.vir.form.IGVIR1102Form;
import com.deliverik.infogovernor.soc.vir.form.IGVIR1103Form;
import com.deliverik.infogovernor.soc.vir.form.IGVIR1104Form;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByOrgVWInfo;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByProjVWInfo;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByUserVWInfo;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;

/**
 * ���⻯����ҵ����DTO
 * 
 */
@SuppressWarnings("serial")
public class IGVIR11DTO extends BaseDTO implements Serializable{
	
	protected IGVIR1101Form igVIR1101Form;
	protected IGVIR1102Form igVIR1102Form;
	protected IGVIR1103Form igVIR1103Form;
	protected IGVIR1104Form igVIR1104Form;
	
	/**
	 * ��ҳBean
	 */
	protected PagingDTO pagingDto;
	
	/**
	 * �����ѯ������¼��
	 */
	protected int maxSearchCount;
	
	/**
	 * ������Դͳ�ƽ�������û���
	 */
	protected List<VIM03CountByUserVWInfo> vim03uList;
	
	/**
	 * ������Դͳ�ƽ������������
	 */
	protected List<VIM03CountByOrgVWInfo> vim03oList;
	
	/**
	 * ������Դͳ�ƽ��������Ŀ��
	 */
	protected List<VIM03CountByProjVWInfo> vim03pList;
	
	/**
	 * ������Դͳ�ƽ����ĳһ�û���
	 */
	protected List<VIM03Info> oneVim03uList;
	
	/**
	 * ������Դͳ�ƽ����ĳһ������
	 */
	protected List<VIM03Info> oneVim03oList;
	
	/**
	 * ������Դͳ�ƽ��
	 */
	protected List<VIM03Info> oneVim03List;
	
	/**
	 * �û���Ϣ
	 */
	protected User user;
	
	/**
	 * ������Ϣ
	 */
	protected Organization orgbean;

	/**
	 * ��½�û�
	 * */
	protected User loginUser;
	
	/**
	 * igVIR0801Formȡ��
	 * @return igVIR0801Form igVIR0801Form
	 */
	public IGVIR1101Form getIgVIR1101Form() {
		return igVIR1101Form;
	}

	/**
	 * igVIR0801Form�趨
	 * @param igVIR0801Form igVIR0801Form
	 */
	public void setIgVIR0801Form(IGVIR1101Form igVIR1101Form) {
		this.igVIR1101Form = igVIR1101Form;
	}



	public IGVIR1102Form getIgVIR1102Form() {
		return igVIR1102Form;
	}

	public void setIgVIR1102Form(IGVIR1102Form igVIR1102Form) {
		this.igVIR1102Form = igVIR1102Form;
	}

	public IGVIR1103Form getIgVIR1103Form() {
		return igVIR1103Form;
	}

	public void setIgVIR1103Form(IGVIR1103Form igVIR1103Form) {
		this.igVIR1103Form = igVIR1103Form;
	}

	public IGVIR1104Form getIgVIR1104Form() {
		return igVIR1104Form;
	}

	public void setIgVIR1104Form(IGVIR1104Form igVIR1104Form) {
		this.igVIR1104Form = igVIR1104Form;
	}

	public void setIgVIR1101Form(IGVIR1101Form igVIR1101Form) {
		this.igVIR1101Form = igVIR1101Form;
	}

	/**
	 * ��ҳBeanȡ��
	 * @return pagingDto ��ҳBean
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ��ҳBean�趨
	 * @param pagingDto ��ҳBean
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * �����ѯ������¼��ȡ��
	 * @return maxSearchCount �����ѯ������¼��
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * �����ѯ������¼���趨
	 * @param maxSearchCount �����ѯ������¼��
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * ������Դͳ�ƽ�������û���ȡ��
	 * @return vim03uList ������Դͳ�ƽ�������û���
	 */
	public List<VIM03CountByUserVWInfo> getVim03uList() {
		return vim03uList;
	}

	/**
	 * ������Դͳ�ƽ�������û����趨
	 * @param vim03uList ������Դͳ�ƽ�������û���
	 */
	public void setVim03uList(List<VIM03CountByUserVWInfo> vim03uList) {
		this.vim03uList = vim03uList;
	}

	/**
	 * ������Դͳ�ƽ������������ȡ��
	 * @return vim03oList ������Դͳ�ƽ������������
	 */
	public List<VIM03CountByOrgVWInfo> getVim03oList() {
		return vim03oList;
	}

	/**
	 * ������Դͳ�ƽ�������������趨
	 * @param vim03oList ������Դͳ�ƽ������������
	 */
	public void setVim03oList(List<VIM03CountByOrgVWInfo> vim03oList) {
		this.vim03oList = vim03oList;
	}

	/**
	 * ������Դͳ�ƽ��������Ŀ��ȡ��
	 * @return vim03pList ������Դͳ�ƽ��������Ŀ��
	 */
	public List<VIM03CountByProjVWInfo> getVim03pList() {
		return vim03pList;
	}

	/**
	 * ������Դͳ�ƽ��������Ŀ���趨
	 * @param vim03pList ������Դͳ�ƽ��������Ŀ��
	 */
	public void setVim03pList(List<VIM03CountByProjVWInfo> vim03pList) {
		this.vim03pList = vim03pList;
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
	 * ������Դͳ�ƽ����ĳһ������ȡ��
	 * @return oneVim03oList ������Դͳ�ƽ����ĳһ������
	 */
	public List<VIM03Info> getOneVim03oList() {
		return oneVim03oList;
	}

	/**
	 * ������Դͳ�ƽ����ĳһ�������趨
	 * @param oneVim03oList ������Դͳ�ƽ����ĳһ������
	 */
	public void setOneVim03oList(List<VIM03Info> oneVim03oList) {
		this.oneVim03oList = oneVim03oList;
	}

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

	/**
	 * ������Ϣȡ��
	 * @return orgbean ������Ϣ
	 */
	public Organization getOrgbean() {
		return orgbean;
	}

	/**
	 * ������Ϣ�趨
	 * @param orgbean ������Ϣ
	 */
	public void setOrgbean(Organization orgbean) {
		this.orgbean = orgbean;
	}

	/**
	 * ��½�û�ȡ��
	 * @return loginUser ��½�û�
	 */
	public User getLoginUser() {
		return loginUser;
	}

	/**
	 * ��½�û��趨
	 * @param loginUser ��½�û�
	 */
	public void setLoginUser(User loginUser) {
		this.loginUser = loginUser;
	}
	
}


