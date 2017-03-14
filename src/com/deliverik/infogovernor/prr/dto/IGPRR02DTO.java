/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.dto;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.prr.form.IGPRR0114Form;
import com.deliverik.infogovernor.prr.model.CopyReadUserInfo;

/**
 * ����:������ 
 * ����������������
 * �����ˣ�����͢
 * ������¼�� 2013-02-25
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGPRR02DTO extends BaseDTO {
	
	
	/**������form*/
	protected IGPRR0114Form igprr0114form;
	
	/**ҳ��map����*/	
	protected Map<String,List<UserRoleInfo>> map_cru;
	
	/**����id*/	
	protected String prid;
	
	/** ���������� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;

	/** ��ǰ��¼�û� */
	protected User user;
	
	/**��ѯ���*/
	protected List<CopyReadUserInfo> list;
	
	/**������Ϣ*/
	protected IG500Info ig500;
	/** ͼ��ɨ��XML */
	protected String picuXml;
	
	/** ͼ��鿴XML */
	protected String picsXml;
   
	/**
	 * ������formȡ��
	 * @return ������form
	 */
	public IGPRR0114Form getIgprr0114form() {
		return igprr0114form;
	}
	/**
	 * ������form�趨
	 *
	 * @param igprr0114form ������form
	 */
	public void setIgprr0114form(IGPRR0114Form igprr0114form) {
		this.igprr0114form = igprr0114form;
	}
	/**
	 * ҳ��map����ȡ��
	 * @return ҳ��map����
	 */
	public Map<String, List<UserRoleInfo>> getMap_cru() {
		return map_cru;
	}
	/**
	 * ҳ��map�����趨
	 *
	 * @param map_cru ҳ��map����
	 */
	public void setMap_cru(Map<String, List<UserRoleInfo>> map_cru) {
		this.map_cru = map_cru;
	}

	/**
	 * ����idȡ��
	 * @return ����id
	 */
	public String getPrid() {
		return prid;
	}
	/**
	 * ����id�趨
	 *
	 * @param prid ����id
	 */
	public void setPrid(String prid) {
		this.prid = prid;
	}
	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * �����������趨
	 *
	 * @param maxSearchCount ����������
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * ��ҳ��DTOȡ��
	 * @return ��ҳ��DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ��ҳ��DTO�趨
	 *
	 * @param pagingDto ��ҳ��DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}
	/**
	 * ��ǰ��¼�û�ȡ��
	 * @return ��ǰ��¼�û�
	 */
	public User getUser() {
		return user;
	}
	/**
	 * ��ǰ��¼�û��趨
	 *
	 * @param user ��ǰ��¼�û�
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * ��ѯ���ȡ��
	 * @return ��ѯ���
	 */
	public List<CopyReadUserInfo> getList() {
		return list;
	}
	/**
	 * ��ѯ����趨
	 *
	 * @param user ��ѯ���
	 */
	public void setList(List<CopyReadUserInfo> list) {
		this.list = list;
	}
	public IG500Info getIg500() {
		return ig500;
	}
	public void setIg500(IG500Info ig500) {
		this.ig500 = ig500;
	}
	public String getPicuXml() {
		return picuXml;
	}

	public void setPicuXml(String picuXml) {
		this.picuXml = picuXml;
	}

	public String getPicsXml() {
		return picsXml;
	}

	public void setPicsXml(String picsXml) {
		this.picsXml = picsXml;
	}


	
}
