/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.svc.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.infogovernor.com.model.ProcessInHandVWInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_�¼�����_��ѯVO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSVC01011VO extends BaseVO implements Serializable {

	/**����map*/
	private Map<String, List<IG500Info>> processRecordMap;
	
	/**�������������ͼmap*/
	private Map<String, List<IG677Info>> processRecordInfoMap;
	
	/**����ģ��鿴ҳURL*/
	private Map<String,String> detailPgMap;
	
	/**����ģ������*/
	private String[] templateNames;
	
	/**����ģ��鿴ҳURL*/
	private String[] detailPgs;
	
	/** ������Ϣ���� */
	protected List<ProcessInHandVWInfo> workList;
	
	/** ��ɫ������� */
	protected Map<String, List<ProcessInHandVWInfo>> workMap;

	/**
	 * ��ȡ����map
	 * @return ����map
	 */
	public Map<String, List<IG500Info>> getProcessRecordMap() {
		return processRecordMap;
	}

	/**
	 * ��������map
	 * @param processRecordMap ����map
	 */
	public void setProcessRecordMap(
			Map<String, List<IG500Info>> processRecordMap) {
		this.processRecordMap = processRecordMap;
	}

	/**
	 * ��ȡ����ģ��鿴ҳURL
	 * @return ����ģ��鿴ҳURL
	 */
	public Map<String,String> getDetailPgMap() {
		return detailPgMap;
	}

	/**
	 * ��������ģ��鿴ҳURL
	 * @param detailPgMap ����ģ��鿴ҳURL
	 */
	public void setDetailPgMap(Map<String,String> detailPgMap) {
		this.detailPgMap = detailPgMap;
	}
	
	/**
	 * ��ȡ�������������ͼmap
	 * @return �������������ͼmap
	 */
	public Map<String, List<IG677Info>> getProcessRecordInfoMap() {
		return processRecordInfoMap;
	}

	/**
	 * �����������������ͼmap
	 * @param processRecordInfoMap �������������ͼmap
	 */
	public void setProcessRecordInfoMap(
			Map<String, List<IG677Info>> processRecordInfoMap) {
		this.processRecordInfoMap = processRecordInfoMap;
	}
	
	
	/**
	 * ��ȡ����ģ��鿴ҳURL
	 * @return ����ģ��鿴ҳURL
	 */
	public String[] getDetailPgs() {
		return detailPgs;
	}

	/**
	 * ��������ģ��鿴ҳURL
	 * @param detailPgs ����ģ��鿴ҳURL
	 */
	public void setDetailPgs(String[] detailPgs) {
		this.detailPgs = detailPgs;
	}
	
		/**
	 * ��ȡ����ģ������
	 * @return ����ģ������
	 */
	public String[] getTemplateNames() {
		return templateNames;
	}

	/**
	 * ��������ģ������
	 * @param String[] ����ģ������
	 */
	public void setTemplateNames(String[] templateNames) {
		this.templateNames = templateNames;
	}

	/**
	 * ������Ϣ����ȡ��
	 * @return workList ������Ϣ����
	 */
	public List<ProcessInHandVWInfo> getWorkList() {
		return workList;
	}

	/**
	 * ������Ϣ�����趨
	 * @param workList ������Ϣ����
	 */
	public void setWorkList(List<ProcessInHandVWInfo> workList) {
		this.workList = workList;
	}

	/**
	 * ��ɫ�������ȡ��
	 * @return workMap ��ɫ�������
	 */
	public Map<String, List<ProcessInHandVWInfo>> getWorkMap() {
		if(workList != null && workList.size() > 0){
			workMap = new LinkedHashMap<String, List<ProcessInHandVWInfo>>();
			for(ProcessInHandVWInfo info:workList){
				if(workMap.get(info.getPprolename()) == null){
					workMap.put(info.getPprolename(), new ArrayList<ProcessInHandVWInfo>());
				}
				workMap.get(info.getPprolename()).add(info);
			}
		}
		return workMap;
	}
	
}
