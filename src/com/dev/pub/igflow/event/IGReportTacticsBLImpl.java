/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.dev.pub.igflow.event;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG334VWInfo;
import com.deliverik.framework.workflow.prd.model.condition.IG334SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.infogovernor.util.DisposeTimeForPrstatus;

/**
 * ����������״̬��ʱ��ʵ��BL
 * ��������������״̬��ʱ��ʵ��BL
 * ������¼��2014/06/17
 * (1)�����ޱ���������Ӧ����
 * �޸ļ�¼��
 */
public class IGReportTacticsBLImpl extends IGReportSuperTacticsBLImpl {

	static Log log = LogFactory.getLog(IGReportTacticsBLImpl.class);
	
	/**
	 * ����״̬�����жϵĹ�����¼�
	 * 
	 * @param pdid 
	 * @param psdid 
	 * @throws BLException
	 */
	@Override
	public void regulation(String pdid, String psdid) throws BLException {
		//û����������IDʱ��������ϼ�����
		if(StringUtils.isEmpty(pdid)){
			log.debug("��������IDΪ����Ϊ�ա�");
			return;
		}
		
		//��ʱ����ʱ��ǰ�ļ��ʱ�䵥λ������
		Integer begintime = 5;//��ǰ�����ӷ���
		//���̲����趨��Ϣ��ѯ
		IG334SearchCondImpl condIg334 = new IG334SearchCondImpl();
		condIg334.setPdid_like(pdid);
		List<IG334VWInfo> lstTactics = this.ig334BL.findByCondTactics(condIg334);
		
		//û�����̲����趨��Ϣʱ������״̬��ʱ����
		if(lstTactics == null || lstTactics.size() <= 0){
			log.debug("��������IDΪ��"+pdid +"��������û������֪ͨ�������á�");
			return;
		}
		
		//����pidid�Ǳ���ص��ж�
		String pidid = lstTactics.get(0).getPidid();
		//������
		String pidname = lstTactics.get(0).getPidname();
		
		//��װ���̲�����Ϣ
		Map<String, Map<String, IG334VWInfo>> map = new LinkedHashMap<String, Map<String,IG334VWInfo>>();
		for (IG334VWInfo info : lstTactics) {
			if(map.get(info.getPsdcode()) != null){
				if(map.get(info.getPsdcode()).get(info.getPivalue()) == null){
					map.get(info.getPsdcode()).put(info.getPivalue(), info);
				}
			}else{
				Map<String, IG334VWInfo> mapIg334 = new LinkedHashMap<String, IG334VWInfo>();
				mapIg334.put(info.getPivalue(), info);
				map.put(info.getPsdcode(), mapIg334);
			}
		}
		
		//������������ID��ѯ����δ�رյ�����
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		cond.setPrActive("Y");
		cond.setPrpdid(pdid);
		
		//����״̬��Ϣ
		if(StringUtils.isNotEmpty(psdid)){
			IG333Info ig333Info = this.ig333BL.searchIG333InfoByKey(psdid);
			cond.setPrstatus(ig333Info.getPsdcode());
		}
		
		//��ѯ������Ϣ
		List<IG500Info> lstIG500Info = workFlowOperationBL.searchProcessRecord(cond);
		
		//û��δ�ر����̲�����״̬��ʱ����
		if(lstIG500Info != null && lstIG500Info.size() > 0){
			//��ǰ״̬����ʱ��
			Integer counttime = 0;
			//��ǰ״̬��ǰָ������Ӧ�ĳ�ʱʱ��
			Integer overtime = 0;
			//��ǰ����ָ������ֵ
			String pivalue = "";
			for (IG500Info info : lstIG500Info) {
				if(pidid.endsWith(IGPRDCONSTANTS.PROCESS_UNRELFORM_IDEND)){
					//֪ͨ��������޹�
					pivalue = IGPRDCONSTANTS.PROCESS_UNRELFORM_VALUE;
				} else {
					pivalue = flowSearchBL.searchPublicProcessInfo(info.getPrid(), pidname);
					pivalue = StringUtils.isEmpty(pivalue) ? "#" : pivalue;					
				}
				//��ȡ��ǰ״̬�Ĳ����趨��Ϣ
				if(map.get(info.getPrstatus()) == null ){
					log.debug("���̡�"+info.getPrtitle() +"���еĶ�Ӧ״̬��ʶΪ��"+info.getPrstatus()+"����״̬û�г�ʱ���̲��Ե����á�");
					continue;
				}
				
				//��ȡָ��״̬��ָ����ֵ��Ӧ�Ĳ����趨��Ϣ
				IG334VWInfo tactics = map.get(info.getPrstatus()).get(pivalue);
				
				//��ǰ״ָ̬����ֵ��Ӧ�����̲��Բ�����ʱ������һ��ѭ��
				if(tactics == null){
					if(pidid.endsWith(IGPRDCONSTANTS.PROCESS_UNRELFORM_IDEND)){
						//֪ͨ��������޹�
						log.debug("���̡�"+info.getPrtitle() +"����û��״̬��ʱ���̲��Ե����á�");
					} else {
						log.debug("���̡�"+info.getPrtitle() +"���еĶ�Ӧ��"+pidname+"���С�"+("#".equals(pivalue) ? "ȱʡ" :pivalue)+"��û��״̬��ʱ���̲��Ե����á�");
					}
					continue;
				}
				
				//���㵱ǰ״̬�Ĵ���ʱ��//�°汾ig224��û�ж�Ӧ��prstatus���Բ�����info.getPrstatus()
				if(IGPRDCONSTANTS.SUBSTATUS_CONFIRM_YES.equals(tactics.getPsdconfirm())){
					//״̬��ȷ�϶���ʱ��״̬��ǰ����ʱ��
					counttime = DisposeTimeForPrstatus.getCountTime(info.getPrid(), psdid, true);
				}else{
					//״̬û��ȷ�϶���ʱ��״̬��ǰ����ʱ��
					counttime = DisposeTimeForPrstatus.getCountTime(info.getPrid(), psdid, false);
				}
				
				//��ȡ�趨�ĳ�ʱʱ��
				if(tactics.getNotifyd() != null && tactics.getNotifyd() > 0){
					overtime += tactics.getNotifyd() * 24 * 60;
				}
				if(tactics.getNotifyh() != null && tactics.getNotifyh() > 0){
					overtime += tactics.getNotifyh() * 60;
				}
				if(tactics.getNotifym() != null && tactics.getNotifym() > 0){
					overtime += tactics.getNotifym();
				}
				
				//��ǰ���̳�ʱʱ�����0ʱ�����������
				if(overtime > 0){
					//��ǰ��ʱʱ��5�������Ѵ�����
					if(counttime >= overtime-begintime){
						this.event(tactics, info, begintime, false);
					}
					//��¼��ʱ״̬����Ա
					if(counttime > overtime){
						this.event(tactics, info, begintime, true);
					}
				}
			}//end for
		}//end if
	}
}