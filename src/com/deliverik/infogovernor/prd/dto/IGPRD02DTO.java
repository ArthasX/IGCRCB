/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prd.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.infogovernor.prd.form.IGPRD0201Form;
import com.deliverik.infogovernor.prd.vo.IGPRD02022VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:���̶��幤��dto 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD02DTO extends BaseDTO{
	
	/** ���̶���ID */
	protected String pdid;
	
	/** ���̶�����Ϣ */
	protected IG380Info processDefinition;
	
	/** ����ͼXML */
	protected String flowChartXML;
	
	/** ����ͼ�߶� */
	protected Integer flowChartHeight;
	
	/** �����ѯ������¼�� */
	protected int maxSearchCount;

	/** ��ҳBean */
	protected PagingDTO pagingDto;
	
	/** �û���ѯform */
	protected IGPRD0201Form igprd0201Form;
	
	/** �û���ɫ��Ϣ���� */
	protected List<UserRoleInfo> userroleList;
	
	/** �ڵ������Ϣ���� */
	protected List<IGPRD02022VO> voList;

	/**
	 * ���̶���IDȡ��
	 * @return pdid ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 * @param pdid ���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ���̶�����Ϣȡ��
	 * @return processDefinition ���̶�����Ϣ
	 */
	public IG380Info getProcessDefinition() {
		return processDefinition;
	}

	/**
	 * ���̶�����Ϣ�趨
	 * @param processDefinition ���̶�����Ϣ
	 */
	public void setProcessDefinition(IG380Info processDefinition) {
		this.processDefinition = processDefinition;
	}

	/**
	 * ����ͼXMLȡ��
	 * @return flowChartXML ����ͼXML
	 */
	public String getFlowChartXML() {
		return flowChartXML;
	}

	/**
	 * ����ͼXML�趨
	 * @param flowChartXML ����ͼXML
	 */
	public void setFlowChartXML(String flowChartXML) {
		this.flowChartXML = flowChartXML;
	}

	/**
	 * ����ͼ�߶�ȡ��
	 * @return flowChartHeight ����ͼ�߶�
	 */
	public Integer getFlowChartHeight() {
		return flowChartHeight;
	}

	/**
	 * ����ͼ�߶��趨
	 * @param flowChartHeight ����ͼ�߶�
	 */
	public void setFlowChartHeight(Integer flowChartHeight) {
		this.flowChartHeight = flowChartHeight;
	}

	/**
	 * �����ѯ������¼��ȡ��
	 * @return �����ѯ������¼��
	 */
	public final int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * �����ѯ������¼���趨
	 * @param maxSearchCount �����ѯ������¼��
	 */
	public final void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * ��ҳbeanȡ��
	 * @return ��ҳbean
	 */
	public final PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ��ҳbean�趨
	 * @param pagingDto ��ҳbean
	 */
	public final void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * �û���ѯformȡ��
	 * @return �û���ѯform
	 */
	public IGPRD0201Form getIgprd0201Form() {
		return igprd0201Form;
	}

	/**
	 * �û���ѯform�趨
	 * @param igprd0201Form �û���ѯform
	 */
	public void setIgprd0201Form(IGPRD0201Form igprd0201Form) {
		this.igprd0201Form = igprd0201Form;
	}

	/**
	 * �û���ɫ��Ϣ����ȡ��
	 * @return �û���ɫ��Ϣ����
	 */
	public List<UserRoleInfo> getUserroleList() {
		return userroleList;
	}

	/**
	 * �û���ɫ��Ϣ�����趨
	 * @param userroleList �û���ɫ��Ϣ����
	 */
	public void setUserroleList(List<UserRoleInfo> userroleList) {
		this.userroleList = userroleList;
	}

	/**
	 * �ڵ������Ϣ����ȡ��
	 * @return voList �ڵ������Ϣ����
	 */
	public List<IGPRD02022VO> getVoList() {
		return voList;
	}

	/**
	 * �ڵ������Ϣ�����趨
	 * @param voList �ڵ������Ϣ����
	 */
	public void setVoList(List<IGPRD02022VO> voList) {
		this.voList = voList;
	}
}
