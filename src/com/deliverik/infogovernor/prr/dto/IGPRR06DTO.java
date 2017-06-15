/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.dto;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prd.model.IG110Info;
import com.deliverik.framework.workflow.prd.model.IG111Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.infogovernor.prr.model.condition.ProcessSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̲�ѯDTO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR06DTO extends BaseDTO{
	
	/** ���̶���ID */
	protected String pdid;

	/** �����ѯ������¼�� */
	protected int maxSearchCount;

	/** ��ҳBean */
	protected PagingDTO pagingDto;
	
	/** ��ѯ��� */
	protected List<Map<String, Object>> result;
	
	/**  ���̲�ѯ��ʾ�м��� */
	protected List<IG110Info> processQueryShowColumnList;
	
	/** ���̲�ѯ�������弯�� */
	protected List<IG111Info> processQueryList; 
	
	/** ���̲�ѯ���� */
	protected ProcessSearchCond processSearchCond;
	
	/** ״̬��Ϣ���弯�� */
	protected List<IG333Info> psdList;
	
	/** ��Ӧ���� */
	protected HttpServletResponse response;
	
	/** ������תJSP */
	protected String forwardJsp;
	
	protected User user;

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
	 * ��ѯ���ȡ��
	 * @return result ��ѯ���
	 */
	public List<Map<String, Object>> getResult() {
		return result;
	}

	/**
	 * ��ѯ����趨
	 * @param result ��ѯ���
	 */
	public void setResult(List<Map<String, Object>> result) {
		this.result = result;
	}

	/**
	 * ���̲�ѯ��ʾ�м���ȡ��
	 * @return processQueryShowColumnList ���̲�ѯ��ʾ�м���
	 */
	public List<IG110Info> getProcessQueryShowColumnList() {
		return processQueryShowColumnList;
	}

	/**
	 * ���̲�ѯ��ʾ�м����趨
	 * @param processQueryShowColumnList ���̲�ѯ��ʾ�м���
	 */
	public void setProcessQueryShowColumnList(
			List<IG110Info> processQueryShowColumnList) {
		this.processQueryShowColumnList = processQueryShowColumnList;
	}

	/**
	 * ���̲�ѯ�������弯��ȡ��
	 * @return processQueryList ���̲�ѯ�������弯��
	 */
	public List<IG111Info> getProcessQueryList() {
		return processQueryList;
	}

	/**
	 * ���̲�ѯ�������弯���趨
	 * @param processQueryList ���̲�ѯ�������弯��
	 */
	public void setProcessQueryList(List<IG111Info> processQueryList) {
		this.processQueryList = processQueryList;
	}

	/**
	 * ���̲�ѯ����ȡ��
	 * @return processSearchCond ���̲�ѯ����
	 */
	public ProcessSearchCond getProcessSearchCond() {
		return processSearchCond;
	}

	/**
	 * ���̲�ѯ�����趨
	 * @param processSearchCond ���̲�ѯ����
	 */
	public void setProcessSearchCond(ProcessSearchCond processSearchCond) {
		this.processSearchCond = processSearchCond;
	}

	/**
	 * ״̬��Ϣ���弯��ȡ��
	 * @return psdList ״̬��Ϣ���弯��
	 */
	public List<IG333Info> getPsdList() {
		return psdList;
	}

	/**
	 * ״̬��Ϣ���弯���趨
	 * @param psdList ״̬��Ϣ���弯��
	 */
	public void setPsdList(List<IG333Info> psdList) {
		this.psdList = psdList;
	}

	/**
	 * ��Ӧ����ȡ��
	 * @return response ��Ӧ����
	 */
	public HttpServletResponse getResponse() {
		return response;
	}

	/**
	 * ��Ӧ�����趨
	 * @param response ��Ӧ����
	 */
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	/**
	 * ������תJSPȡ��
	 * @return ������תJSP
	 */
	public String getForwardJsp() {
		return forwardJsp;
	}

	/**
	 * ������תJSP�趨
	 * @param forwardJsp������תJSP
	 */
	public void setForwardJsp(String forwardJsp) {
		this.forwardJsp = forwardJsp;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
