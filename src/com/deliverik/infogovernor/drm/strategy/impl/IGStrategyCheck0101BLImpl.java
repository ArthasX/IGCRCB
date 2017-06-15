package com.deliverik.infogovernor.drm.strategy.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import nl.justobjects.pushlet.util.Log;

import com.deliverik.infogovernor.crc.bl.task.IgalarmBL;
import com.deliverik.infogovernor.crc.model.IgalarmInfo;
import com.deliverik.infogovernor.crc.model.condition.IgalarmSearchCondImpl;
import com.deliverik.infogovernor.drm.strategy.StrategyCheckBL;

/**
 * ����ҵ��ϵͳ���������ϴ�������
 * @author crcb
 *
 */
public class IGStrategyCheck0101BLImpl implements StrategyCheckBL {
	
	
	protected IgalarmBL igalarmBL;
	
	

	public void setIgalarmBL(IgalarmBL igalarmBL) {
		this.igalarmBL = igalarmBL;
	}


	/**
	 * ���ݲ���������IP��ѯ�Ƿ����㴥������
	 */
	public boolean check(Object... objects) {
		
		Log.debug("===============�����������⴦��bl��ʼ====================");
		boolean result = true;
		
		String alarmMsg = objects[0].toString();
		
		String argStr = objects[1].toString();
		String[] args = argStr.trim().split("[\\s ]");
		
		for (String string : args) {
			
			if(StringUtils.isEmpty(string)){
				continue;
			}
			
			IgalarmSearchCondImpl cond = new IgalarmSearchCondImpl();
			cond.setIpaddr(string.trim());
			//����״̬�ĸ澯
			cond.setShieldflag("0");
			cond.setStatus("0");
			List<IgalarmInfo> igalarmList = igalarmBL.searchIgalarm(cond);
			if(igalarmList.size()==0){
				result = false;
				Log.warn("û���ҵ�IP��ַΪ��"+string+"���豸�����澯�����ܹ��ɴ�������");
				break;
			}
			
		}
		Log.debug("===============�����������⴦��bl��ʼ====================");
		return result;
	}
	
	
	public static void main(String[] arg3s) {
	String alarmMsg = "";
		
		String argStr = " sjdfj shdfk sfsdf 343 34jh3 ".toString();
		String[] args = argStr.trim().split("[\\s ]");
		System.out.println("����"+args.length);
		for (String string : args) {
			System.out.println("neirngo>"+string);
		}
	}

}
