/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.com.model.ProcessInHandVWInfo;
import com.deliverik.infogovernor.soc.vir.vim.model.Host;
import com.deliverik.infogovernor.soc.vir.vim.model.Template;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��Դ������ҳVO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR10071VO extends BaseVO{
	
	/** ���칤������ */
	protected List<ProcessInHandVWInfo> pihList;
	
	/**ģ�弯��*/
	protected List<Template> templateList;
	
	/** Host��Ϣ���� */
	protected Map<Integer, List<Host>> hostMap;
	
	/** ��ҳ��ʾHost */
	protected List<List<Map<Integer, Host>>> showHostList;
	
	/** ��ҳ��ʾHost */
	
	/** ��������ͳ��Map */
	protected Map<String, Integer> vmReportMap;
	
	/** ��ά��������Map */
	protected Map<String, Map<String, Integer>> prRecportMap;

	/**
	 * ���칤������ȡ��
	 * @return pihList ���칤������
	 */
	public List<ProcessInHandVWInfo> getPihList() {
		return pihList;
	}

	/**
	 * ���칤�������趨
	 * @param pihList ���칤������
	 */
	public void setPihList(List<ProcessInHandVWInfo> pihList) {
		this.pihList = pihList;
	}

	/**
	 * ģ�弯��ȡ��
	 * @return templateList ģ�弯��
	 */
	public List<Template> getTemplateList() {
		return templateList;
	}

	/**
	 * ģ�弯���趨
	 * @param templateList ģ�弯��
	 */
	public void setTemplateList(List<Template> templateList) {
		this.templateList = templateList;
	}

	/**
	 * Host��Ϣ����ȡ��
	 * @return hostMap Host��Ϣ����
	 */
	public Map<Integer, List<Host>> getHostMap() {
		return hostMap;
	}

	/**
	 * Host��Ϣ�����趨
	 * @param hostMap Host��Ϣ����
	 */
	public void setHostMap(Map<Integer, List<Host>> hostMap) {
		this.hostMap = hostMap;
		if(hostMap != null){
			this.showHostList = new ArrayList<List<Map<Integer,Host>>>();
			List<Map<Integer, Host>> temp = new ArrayList<Map<Integer,Host>>();
			int index = 0;
			for(Iterator<Entry<Integer, List<Host>>> iter = hostMap.entrySet().iterator();iter.hasNext();){
				Entry<Integer, List<Host>> next = iter.next();
				Integer key = next.getKey();
				List<Host> list = next.getValue();
				for(Host host : list){
					if(index > 0 && index % 6 == 0){
						showHostList.add(temp);
						temp = new ArrayList<Map<Integer,Host>>();
					}
					Map<Integer, Host> map = new HashMap<Integer, Host>();
					map.put(key, host);
					temp.add(map);
					index ++;
				}
			}
			if(temp.size() > 0){
				showHostList.add(temp);
			}
		}
	}

	/**
	 * ��ҳ��ʾHostȡ��
	 * @return showHostList ��ҳ��ʾHost
	 */
	public List<List<Map<Integer, Host>>> getShowHostList() {
		return showHostList;
	}

	/**
	 * ��ҳ��ʾHost�趨
	 * @param showHostList ��ҳ��ʾHost
	 */
	public void setShowHostList(List<List<Map<Integer, Host>>> showHostList) {
		this.showHostList = showHostList;
	}

	/**
	 * ��������ͳ��Mapȡ��
	 * @return vmReportMap ��������ͳ��Map
	 */
	public Map<String, Integer> getVmReportMap() {
		return vmReportMap;
	}

	/**
	 * ��������ͳ��Map�趨
	 * @param vmReportMap ��������ͳ��Map
	 */
	public void setVmReportMap(Map<String, Integer> vmReportMap) {
		this.vmReportMap = vmReportMap;
	}

	/**
	 * ��ά��������Mapȡ��
	 * @return prRecportMap ��ά��������Map
	 */
	public Map<String, Map<String, Integer>> getPrRecportMap() {
		return prRecportMap;
	}

	/**
	 * ��ά��������Map�趨
	 * @param prRecportMap ��ά��������Map
	 */
	public void setPrRecportMap(Map<String, Map<String, Integer>> prRecportMap) {
		this.prRecportMap = prRecportMap;
	}
}
