/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.dev.crc.igflow.init.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.igflow.resultset.TableFormColumnValue;
import com.deliverik.framework.workflow.WorkFlowParameterInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowInitFormHandlerBL;
import com.deliverik.infogovernor.crc.bl.task.IgalarmBL;
import com.deliverik.infogovernor.crc.model.IgalarmInfo;
import com.deliverik.infogovernor.crc.model.condition.IgalarmSearchCondImpl;

/**
 * ����: ����״̬��ֵ��ʼ�� ��������: ����״̬��ֵ��ʼ�� ������¼: 2014/07/01 �޸ļ�¼: 2014/07/09
 * ����澯��Ϣ��ֵ��ʼ��
 */
public class IGCRC0201BLImpl extends BaseBLImpl implements
		WorkFlowInitFormHandlerBL {

	static Log log = LogFactory.getLog(IGCRC0201BLImpl.class);

	/** ��ѯ�๦��API�� */
	private FlowSearchBL flowSearchBL;
	/** ���ɸ澯��ҵ���߼�BL */
	private IgalarmBL igalarmBL;

	/**
	 * ���ɸ澯��ҵ���߼�BL����
	 * 
	 * @param igalarmBL
	 *            ���ɸ澯��ҵ���߼�BL
	 */
	public void setIgalarmBL(IgalarmBL igalarmBL) {
		this.igalarmBL = igalarmBL;
	}

	/**
	 * @param ��ѯ�๦��API��
	 *            the flowSearchBL to set
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * ����״̬��ֵ��ʼ��
	 * 
	 * @param param
	 *            ���̴�������ӿ�
	 * @return ��ֵ���ϣ�<����-ֵ>��
	 */
	public Map<String, Object> initForm(WorkFlowParameterInfo param)
			throws BLException {
		log.debug("======== �¼����̴�����ڵ��ʼ������ʼ========");
		Map<String, Object> map = new HashMap<String, Object>();
		if (param.getParprid() != null) {
			List<ProcessRecordInfo> process = flowSearchBL.searchProcessInfo(
					param.getParprid(), null);
			for (ProcessRecordInfo prInfo : process) {
				map.put("�¼�����", prInfo.getPrdesc());
			}
		}
		// �¼�����ҳ����������ʽ��(�澯��Ϣ)���ݵĳ�ʼ��
		if (StringUtils.isNotEmpty(param.getParameters())) {

			String[] split = param.getParameters().split(",");
			List<TableFormColumnValue> list = new ArrayList<TableFormColumnValue>();
			// ���ɸ澯���������
			IgalarmSearchCondImpl alarmSearchCond = new IgalarmSearchCondImpl();
			alarmSearchCond.setAlarmIds(split);
			// ͨ��������ѯ��ȫ����Ϣ����list��
			List<IgalarmInfo> lst = igalarmBL.searchIgalarm(alarmSearchCond);
			// ѭ����ʼ���澯��Ϣ���ʽ��
			for (int j = 0; j < lst.size(); j++) {
				TableFormColumnValue tfcv = new TableFormColumnValue();
				tfcv.setFullName("�澯��Ϣ#�澯ID");
				tfcv.setRownumber(j + 1 + "");
				tfcv.setValue(lst.get(j).getSerial());
				list.add(tfcv);
				TableFormColumnValue tfcv4 = new TableFormColumnValue();
				tfcv4.setFullName("�澯��Ϣ#��������");
				tfcv4.setRownumber(j + 1 + "");
				tfcv4.setValue(lst.get(j).getAppname());
				list.add(tfcv4);
				TableFormColumnValue tfcv1 = new TableFormColumnValue();
				tfcv1.setFullName("�澯��Ϣ#�¼�����");
				tfcv1.setRownumber(j + 1 + "");
				tfcv1.setValue(lst.get(j).getSummary());
				list.add(tfcv1);
				TableFormColumnValue tfcv2 = new TableFormColumnValue();
				tfcv2.setFullName("�澯��Ϣ#����ʱ��");
				tfcv2.setRownumber(j + 1 + "");
				tfcv2.setValue(lst.get(j).getLasttime());
				list.add(tfcv2);
				TableFormColumnValue tfcv3 = new TableFormColumnValue();
				tfcv3.setFullName("�澯��Ϣ#�ָ�ʱ��");
				tfcv3.setRownumber(j + 1 + "");
				tfcv3.setValue(lst.get(j).getRecoveryTime());
				list.add(tfcv3);
			}
			map.put("�澯��Ϣ", list);
			map.put("�¼���Դ", "��ظ澯");
		}

		log.debug("======== �¼����̴�����ڵ��ʼ���������========");
		return map;

	}

}
