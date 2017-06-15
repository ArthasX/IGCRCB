/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.crc.igflow.event.status;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.ProcessInfoDefinitionInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����δѡ�еķ��յ�ͼ����
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGFXK0402BLImpl implements WorkFlowEventHandlerBL{
	
	/** ��־���� */
	private static final Log log = LogFactory.getLog(IGFXK0402BLImpl.class);
	
	/** ��ѯ��API */
	protected FlowSearchBL flowSearchBL;
	
	/** ������API */
	protected FlowSetBL flowSetBL;

	/**
	 * ��ѯ��API�趨
	 * @param flowSearchBL ��ѯ��API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * ������API�趨
	 * @param flowSetBL ������API
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

	@SuppressWarnings("unchecked")
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("================���˱��ʽ��������ʼ=================");
		//��ѯ�����
		Map<String, ProcessInfoDefinitionInfo> def = flowSearchBL.searchProcessTableColumnDef(bean.getLogInfo().getPrid());
		//��ѯ�������ݱ��ʽ��ֵ
		Object obj = flowSearchBL.searchPublicTableValue("��������", bean.getLogInfo().getPrid(), null);
		//��ֵ�ṹ����һ��--ÿһ�������µķ��յ�ͼ����ڶ��㣬���嵽���յ�������ڲ�ֵ
		List<Map<String, Object>> dataList = (List<Map<String, Object>>) obj;
		if(dataList != null){
			//�������ݣ��������ݣ���¼��ѡ�е�ֵ��Ȼ�����ԭ��ֵ�������
			List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
			//���������к�
			int idx_one = 0;
			for(Map<String, Object> dataMap:dataList){
				idx_one ++;
				//��¼���յ�
				List<Map<String, String>> one_list = new ArrayList<Map<String,String>>();
				//��¼�����
				List<Map<String, String>> two_list = new ArrayList<Map<String,String>>();
				//ȡ�÷��յ���ʽ��ֵ
				List<Map<String, String>> one = (List<Map<String, String>>) dataMap.get("���յ�");
				if(one != null){
					//�������յ㣬ȡ�ñ�ѡ�е�ֵ
					int idx_two = 0;
					for(Map<String, String> map:one){
						idx_two ++;
						//ѡ���е�ֵΪ"."����������ݱ�ѡ��
						if(".".equals(map.get("ѡ��"))){
							one_list.add(map);
						}
						//ɾ�����ݿ��еļ�¼
						flowSetBL.deletePublicTableFormValue(def, "��������#���յ�", bean.getLogInfo().getPrid(), idx_one + "_" + idx_two);
					}
				}
				//ȡ�ü������ʽ��ֵ
				List<Map<String, String>> two = (List<Map<String, String>>) dataMap.get("�����");
				if(two != null){
					//�������յ㣬ȡ�ñ�ѡ�е�ֵ
					int idx_two = 0;
					for(Map<String, String> map:two){
						idx_two ++;
						//ѡ���е�ֵΪ"."����������ݱ�ѡ��
						if(".".equals(map.get("ѡ��"))){
							two_list.add(map);
						}
						//ɾ�����ݿ��еļ�¼
						flowSetBL.deletePublicTableFormValue(def, "��������#�����", bean.getLogInfo().getPrid(), idx_one + "_" + idx_two);
					}
				}
				//����ֵ
				Map<String, Object> tempMap = new LinkedHashMap<String, Object>();
				tempMap.put("�������", dataMap.get("�������"));
				tempMap.put("���յ�", one_list);
				tempMap.put("�����", two_list);
				list.add(tempMap);
			}
			idx_one = 0;
			//������ѡ�е�ֵ
			for(Map<String, Object> map:list){
				//ȡ�÷��յ�
				List<Map<String, String>> one_list = (List<Map<String, String>>) map.get("���յ�");
				//ȡ�ü����
				List<Map<String, String>> two_list = (List<Map<String, String>>) map.get("�����");
				//��װ������ʱ�ǰ��շ��շ����װ�����Ƿ����µķ��յ���������һ����ûѡ���������������������
				if(one_list.size() > 0 || two_list.size() > 0){
					idx_one ++;
					//����������
					flowSetBL.setPublicTableColumnValue(def, "��������#�������", bean.getLogInfo().getPrid(), idx_one + "", (String) map.get("�������"));
					//������յ�
					//�������������룬û��˵���ݲ���һ�п���
					if(one_list.size() > 0){
						int idx_two = 0;
						for(Map<String, String> oneMap:one_list){
							idx_two ++;
							for(Iterator<Entry<String, String>> iter = oneMap.entrySet().iterator();iter.hasNext();){
								Entry<String, String> entry = iter.next();
								String key = entry.getKey();
								String value = entry.getValue();
								flowSetBL.setPublicTableColumnValue(def, "��������#���յ�#" + key, bean.getLogInfo().getPrid(), idx_one + "_" + idx_two, value);
							}
						}
					}else{
						flowSetBL.setPublicTableColumnValue(def, "��������#���յ�#ѡ��", bean.getLogInfo().getPrid(), idx_one + "_1", "");
						flowSetBL.setPublicTableColumnValue(def, "��������#���յ�#���յ�", bean.getLogInfo().getPrid(), idx_one + "_1", "");
						flowSetBL.setPublicTableColumnValue(def, "��������#���յ�#�����", bean.getLogInfo().getPrid(), idx_one + "_1", "");
						flowSetBL.setPublicTableColumnValue(def, "��������#���յ�#����", bean.getLogInfo().getPrid(), idx_one + "_1", "");
						flowSetBL.setPublicTableColumnValue(def, "��������#���յ�#���յ�ID", bean.getLogInfo().getPrid(), idx_one + "_1", "");
						
					}
					//��������
					if(two_list.size() > 0){
						int idx_two = 0;
						for(Map<String, String> twoMap:two_list){
							idx_two ++;
							for(Iterator<Entry<String, String>> iter = twoMap.entrySet().iterator();iter.hasNext();){
								Entry<String, String> entry = iter.next();
								String key = entry.getKey();
								String value = entry.getValue();
								flowSetBL.setPublicTableColumnValue(def, "��������#�����#" + key, bean.getLogInfo().getPrid(), idx_one + "_" + idx_two, value);
							}
						}
					}else{
						flowSetBL.setPublicTableColumnValue(def, "��������#�����#ѡ��", bean.getLogInfo().getPrid(), idx_one + "_1", "");
						flowSetBL.setPublicTableColumnValue(def, "��������#�����#�����", bean.getLogInfo().getPrid(), idx_one + "_1", "");
						flowSetBL.setPublicTableColumnValue(def, "��������#�����#���տ������", bean.getLogInfo().getPrid(), idx_one + "_1", "");
						flowSetBL.setPublicTableColumnValue(def, "��������#�����#����", bean.getLogInfo().getPrid(), idx_one + "_1", "");
						flowSetBL.setPublicTableColumnValue(def, "��������#�����#�����ID", bean.getLogInfo().getPrid(), idx_one + "_1", "");
					}
				}
			}
		}
		log.debug("================���˱��ʽ����������=================");
	}

}
