/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.crc.igflow.init.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.resultset.TableFormColumnValue;
import com.deliverik.framework.igflow.resultset.TableFormColumnValueInfo;
import com.deliverik.framework.workflow.WorkFlowParameterInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowInitFormHandlerBL;
import com.dev.crc.report.jdbc.query.ReportValueQueryDAO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��ܱ������ʼ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGSMR0101BLImpl extends BaseBLImpl implements WorkFlowInitFormHandlerBL{
	
	/** ��ֵ��ѯDAO */
	protected ReportValueQueryDAO reportValueQueryDAO;

	/**
	 * ��ֵ��ѯDAO�趨
	 * @param reportValueQueryDAO ��ֵ��ѯDAO
	 */
	public void setReportValueQueryDAO(ReportValueQueryDAO reportValueQueryDAO) {
		this.reportValueQueryDAO = reportValueQueryDAO;
	}


	public Map<String, Object> initForm(WorkFlowParameterInfo param)
			throws BLException {
		//��ֵMap
		Map<String, Object> map = new HashMap<String, Object>();
		//ȡ�����̶���ID
		String pdid = param.getPdid().substring(0,5);
		//��ѯ��ֵ
		Map<String, List<String>> dataMap = reportValueQueryDAO.getValue(pdid);
		//������װ���ݣ����˳����ʽ���Ķ�������
		Map<String, Map<String, List<String>>> valueMap = new HashMap<String, Map<String,List<String>>>();
		for(Iterator<Entry<String, List<String>>> iter = dataMap.entrySet().iterator();iter.hasNext();){
			Entry<String, List<String>> next = iter.next();
			//��ȫ·��
			String key = next.getKey();
			//��ֵ
			List<String> list = next.getValue();
			//��һ������
			String formName = key.split("#")[0];
			if(valueMap.get(formName) == null){
				valueMap.put(formName, new HashMap<String, List<String>>());
			}
			valueMap.get(formName).put(key, list);
		}
		//�������ݣ���������װ�ɿ��Դ��ݸ�ҳ��ĸ�ʽ
		Map<String, List<TableFormColumnValueInfo>> finalValueMap = new HashMap<String, List<TableFormColumnValueInfo>>();
		//����Map��ʼ��ҳ��
		for(Iterator<Entry<String, Map<String, List<String>>>> iter = valueMap.entrySet().iterator();iter.hasNext();){
			Entry<String, Map<String, List<String>>> next = iter.next();
			String key = next.getKey();
			Map<String, List<String>> value = next.getValue();
			if(finalValueMap.get(key) == null){
				finalValueMap.put(key, new ArrayList<TableFormColumnValueInfo>());
			}
			for(Iterator<Entry<String, List<String>>> iterator = value.entrySet().iterator();iterator.hasNext();){
				Entry<String, List<String>> entry = iterator.next();
				String formUrl = entry.getKey();
				List<String> valueList = entry.getValue();
				int i = 0;
				for(String val:valueList){
					i ++;
					TableFormColumnValue tableValue = new TableFormColumnValue();
					tableValue.setFullName(formUrl);
					/*
						ȷ���к��߼��д�ȷ����ĿǰĬ�ϰ�������˳������кţ�����Ҫ������λ����������ݣ�
						����������ݲ����Ϲ�񣬵ȴ��ֳ�����ʱ�����������ݸ�ʽ���Է������ܽ��ͨ���㷨��
						ps:Ŀǰֻ�ܰ��ղ㼶������ʽ�кţ���ǰ�����ռ���˳����ţ������㼶Ĭ��Ϊ��һ
						�У�Ȼ��ƴ�ӡ�
					*/
					String rownum = "";
					if(formUrl.split("#").length > 0){
						for(int j=1;j<formUrl.split("#").length;j++){
							if(j > 1){
								rownum += "_";
							}
							if(j == formUrl.split("#").length - 1){
								rownum += i;
							}else{
								rownum += "1";
							}
						}
					}
					tableValue.setRownumber(rownum);
					tableValue.setValue(val);
					finalValueMap.get(key).add(tableValue);
				}
			}
		}
		for(Iterator<Entry<String, List<TableFormColumnValueInfo>>> iter = finalValueMap.entrySet().iterator();iter.hasNext();){
			Entry<String, List<TableFormColumnValueInfo>> next = iter.next();
			String key = next.getKey();
			List<TableFormColumnValueInfo> value = next.getValue();
			map.put(key, value);
		}
		return map;
	}

}
