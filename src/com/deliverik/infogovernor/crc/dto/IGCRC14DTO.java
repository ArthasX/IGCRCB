/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.infogovernor.crc.model.ChangeProcessVWInfo;
import com.deliverik.infogovernor.crc.model.vo.IGCRC14011VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ������̲�ѯDTO
 * </p>
 * 
 * @author shikailong@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC14DTO extends BaseDTO{

	/** �����ѯ������¼�� */
	protected int maxSearchCount;

	/** ��ҳBean */
	protected PagingDTO pagingDto;
	
	/** ��ǰ�û�*/
	protected User user;
	
	/** ������̼���*/
	protected List<ChangeProcessVWInfo> changeProcessVWInfos;

	/** �����ѯVO*/
	protected IGCRC14011VO igcrc14011VO;
	
	/** ��������ID*/
	protected String pdid;
	
	/** ״̬����*/
	private List<IG333Info> ig333InfoList;
	
	/** ������*/
	protected List<IG337Info> processParticipantList;
	
	/** ״̬����*/
	protected List<IG333Info> processStatusDefList;
	
	/**
	 * �����ѯ������¼��ȡ��
	 * @return the maxSearchCount
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * �����ѯ������¼���趨
	 * @param maxSearchCount the �����ѯ������¼��
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * ��ҳBeanȡ��
	 * @return the pagingDto
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ��ҳBean�趨
	 * @param pagingDto the ��ҳBean
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * ��ǰ�û�ȡ��
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * ��ǰ�û��趨
	 * @param user the ��ǰ�û�
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * ������̼���ȡ��
	 * @return the changeProcessVWInfos
	 */
	public List<ChangeProcessVWInfo> getChangeProcessVWInfos() {
		return changeProcessVWInfos;
	}

	/**
	 * ������̼����趨
	 * @param changeProcessVWInfos the ������̼���
	 */
	public void setChangeProcessVWInfos(
			List<ChangeProcessVWInfo> changeProcessVWInfos) {
		this.changeProcessVWInfos = changeProcessVWInfos;
	}

	/**
	 * �����ѯVOȡ��
	 * @return the igcrc14011VO
	 */
	public IGCRC14011VO getIgcrc14011VO() {
		return igcrc14011VO;
	}

	/**
	 * �����ѯVO�趨
	 * @param igcrc14011vo the igcrc14011VO
	 */
	public void setIgcrc14011VO(IGCRC14011VO igcrc14011vo) {
		igcrc14011VO = igcrc14011vo;
	}

	/**
	 * ��������IDȡ��
	 * @return the pdid
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ��������ID�趨
	 * @param pdid the ��������ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ״̬����ȡ��
	 * @return the ig333InfoList
	 */
	public List<IG333Info> getIg333InfoList() {
		return ig333InfoList;
	}

	/**
	 * ״̬�����趨
	 * @param ig333InfoList the ״̬����
	 */
	public void setIg333InfoList(List<IG333Info> ig333InfoList) {
		this.ig333InfoList = ig333InfoList;
	}

	/**
	 * ������ȡ��
	 * @return the processParticipantList
	 */
	public List<IG337Info> getProcessParticipantList() {
		return processParticipantList;
	}

	/**
	 * �������趨
	 * @param processParticipantList the ������
	 */
	public void setProcessParticipantList(List<IG337Info> processParticipantList) {
		this.processParticipantList = processParticipantList;
	}

	/**
	 * ״̬����ȡ��
	 * @return the processStatusDefList
	 */
	public List<IG333Info> getProcessStatusDefList() {
		return processStatusDefList;
	}

	/**
	 * ״̬�����趨
	 * @param processStatusDefList the ״̬����
	 */
	public void setProcessStatusDefList(List<IG333Info> processStatusDefList) {
		this.processStatusDefList = processStatusDefList;
	}
	
}
