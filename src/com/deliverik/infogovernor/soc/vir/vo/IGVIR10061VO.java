/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.vo;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.infogovernor.soc.vir.vim.model.Template;
import com.deliverik.infogovernor.soc.vir.vim.model.VMachine;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �û���ҳVO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR10061VO extends BaseVO{

	/** �ҷ����������Ϣ */
	protected List<IG677Info> myOpenProcessList;
	
	/**����VM�б�*/
	protected List<VMachine> ownVMList ;
	
	/** ҳ����ʾ����VM�б���Ϣ */
	protected List<List<VMachine>> showOwnVMList;
	
	/**ģ�弯��*/
	protected List<Template> templateList;

	/**
	 * �ҷ����������Ϣȡ��
	 * @return myOpenProcessList �ҷ����������Ϣ
	 */
	public List<IG677Info> getMyOpenProcessList() {
		return myOpenProcessList;
	}

	/**
	 * �ҷ����������Ϣ�趨
	 * @param myOpenProcessList �ҷ����������Ϣ
	 */
	public void setMyOpenProcessList(List<IG677Info> myOpenProcessList) {
		this.myOpenProcessList = myOpenProcessList;
	}

	/**
	 * ����VM�б�ȡ��
	 * @return ownVMList ����VM�б�
	 */
	public List<VMachine> getOwnVMList() {
		return ownVMList;
	}

	/**
	 * ����VM�б��趨
	 * @param ownVMList ����VM�б�
	 */
	public void setOwnVMList(List<VMachine> ownVMList) {
		this.ownVMList = ownVMList;
		if(ownVMList == null) return;
		this.showOwnVMList = new ArrayList<List<VMachine>>();
		List<VMachine> temp = new ArrayList<VMachine>();
		for(int i=0;i<ownVMList.size();i++){
			if(i > 0 && i % 10 == 0){
				showOwnVMList.add(temp);
				temp = new ArrayList<VMachine>();
			}
			temp.add(ownVMList.get(i));
		}
		if(temp.size() > 0){
			showOwnVMList.add(temp);
		}
	}

	/**
	 * ҳ����ʾ����VM�б���Ϣȡ��
	 * @return showOwnVMList ҳ����ʾ����VM�б���Ϣ
	 */
	public List<List<VMachine>> getShowOwnVMList() {
		return showOwnVMList;
	}

	/**
	 * ҳ����ʾ����VM�б���Ϣ�趨
	 * @param showOwnVMList ҳ����ʾ����VM�б���Ϣ
	 */
	public void setShowOwnVMList(List<List<VMachine>> showOwnVMList) {
		this.showOwnVMList = showOwnVMList;
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
}
