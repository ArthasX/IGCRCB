/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.vcd;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.model.VCD01Info;
import com.deliverik.infogovernor.soc.vir.vcd.model.Catalog;
import com.deliverik.infogovernor.soc.vir.vcd.model.Org;
import com.deliverik.infogovernor.soc.vir.vcd.model.Template;
import com.dev.vim.igflow.jobs.VcloudCloneProgressMonitor;

/**
 * ����: VCDҵ���߼��ӿ�
 * ��������: VCDҵ���߼��ӿ�
 * ������¼:
 * �޸ļ�¼:
 */
public interface VCDBL extends BaseBL {
	
	/**
	 * ��ȡ����vCloud����֯�б�
	 * @return ��֯�б�
	 * @throws BLException
	 */
	public List<Org> searchOrg() throws BLException;
	
	/**
	 * ��ȡָ����֯��Ŀ¼�б�
	 * @param vcdInfo vCloud������Ϣ
	 * @return Ŀ¼�б�
	 * @throws BLException
	 */
	public List<Catalog> searchCatalog(VCD01Info vcdInfo, String orgName) throws BLException;
	
	/**
	 * ��ȡ����vCloud��ģ���б�
	 * @return ģ���б�
	 * @throws BLException
	 */
	public List<Template> searchTemplate(VCD01Info vcdInfo, String orgName, String catalogName) throws BLException;
	
	/**
	 * 
	 * <p>���ܣ���¡�����</p>
	 * 
	 * @param ������Ϣ
	 * @param org ��֯
	 * @param vdc 
	 * @param vapp ��������
	 * @param catalog Ŀ¼
	 * @param template ģ��
	 * @param fqdn 
	 * @param description
	 * @param ip
	 * @param network
	 * @return
	 */
	public void cloneVM(VCD01Info vcd01,String org, String vdc, String vapp, 
			String catalog, String template, String fqdn, String description, 
			String ip, String network,VcloudCloneProgressMonitor cloneProgressMonitor)  throws BLException;
	
}
