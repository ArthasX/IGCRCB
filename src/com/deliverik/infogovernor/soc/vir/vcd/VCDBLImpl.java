/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.vcd;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.bl.task.VCD01BL;
import com.deliverik.infogovernor.soc.vir.model.VCD01Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD01SearchCondImpl;
import com.deliverik.infogovernor.soc.vir.vcd.conn.VCDConnection;
import com.deliverik.infogovernor.soc.vir.vcd.model.Catalog;
import com.deliverik.infogovernor.soc.vir.vcd.model.Org;
import com.deliverik.infogovernor.soc.vir.vcd.model.Template;
import com.deliverik.infogovernor.soc.vir.vcd.model.VirtualMachine;
import com.dev.vim.igflow.jobs.VcloudCloneProgressMonitor;
import com.vmware.vcloud.api.rest.schema.GuestCustomizationSectionType;
import com.vmware.vcloud.api.rest.schema.InstantiationParamsType;
import com.vmware.vcloud.api.rest.schema.NetworkConnectionSectionType;
import com.vmware.vcloud.api.rest.schema.NetworkConnectionType;
import com.vmware.vcloud.api.rest.schema.ObjectFactory;
import com.vmware.vcloud.api.rest.schema.QueryResultAdminVAppTemplateRecordType;
import com.vmware.vcloud.api.rest.schema.QueryResultAdminVMRecordType;
import com.vmware.vcloud.api.rest.schema.RecomposeVAppParamsType;
import com.vmware.vcloud.api.rest.schema.ReferenceType;
import com.vmware.vcloud.api.rest.schema.SourcedCompositionItemParamType;
import com.vmware.vcloud.api.rest.schema.ovf.MsgType;
import com.vmware.vcloud.api.rest.schema.ovf.SectionType;
import com.vmware.vcloud.sdk.CatalogItem;
import com.vmware.vcloud.sdk.Expression;
import com.vmware.vcloud.sdk.Filter;
import com.vmware.vcloud.sdk.Organization;
import com.vmware.vcloud.sdk.QueryParams;
import com.vmware.vcloud.sdk.RecordResult;
import com.vmware.vcloud.sdk.Task;
import com.vmware.vcloud.sdk.VCloudException;
import com.vmware.vcloud.sdk.Vapp;
import com.vmware.vcloud.sdk.VappTemplate;
import com.vmware.vcloud.sdk.VcloudClient;
import com.vmware.vcloud.sdk.Vdc;
import com.vmware.vcloud.sdk.constants.query.ExpressionType;
import com.vmware.vcloud.sdk.constants.query.FilterType;
import com.vmware.vcloud.sdk.constants.query.QueryAdminVAppTemplateField;
import com.vmware.vcloud.sdk.constants.query.QueryAdminVMField;
import com.vmware.vcloud.sdk.constants.query.QueryRecordType;

/**
 * ����: VCDҵ���߼�ʵ��
 * ��������: VCDҵ���߼�ʵ��
 * ������¼:
 * �޸ļ�¼:
 */
public class VCDBLImpl extends BaseBLImpl implements VCDBL {
	
	static Log log = LogFactory.getLog(VCDBLImpl.class);
	
	/** vCloud����BL */
	protected VCD01BL vcd01BL;
	
	/**
	 * vCloud����BL�趨
	 * @param vcd01BL vCloud����BL
	 */
	public void setvcd01BL(VCD01BL vcd01BL) {
		this.vcd01BL = vcd01BL;
	}
	
	/**
	 * ��ȡvCloud����ʵ����������֤��Ϣ
	 * @param vcInfo vCloud������Ϣ
	 * @return ����ʵ��
	 * @throws Exception
	 */
	private VcloudClient getConnectInstance(VCD01Info vcdInfo) throws Exception {
		return VCDConnection.getClient(vcdInfo);
	}

	/**
	 * ��ȡ����vCloud����֯�б�
	 * @return ��֯�б�
	 * @throws BLException
	 */
	public List<Org> searchOrg() throws BLException {
		//��ѯvCloud���ñ�
		List<VCD01Info> lst_VCD01Info = this.vcd01BL.searchVCD01(new VCD01SearchCondImpl());
		List<Org> lst_Org = new ArrayList<Org>();
		//����������vCloud
		for(VCD01Info vcdInfo : lst_VCD01Info) {
			//��ȡģ��
			lst_Org.addAll(searchOrg(vcdInfo));
		}
		return lst_Org;
	}
	
	/**
	 * ��ȡָ��VCD����֯�б�
	 * @param vcdInfo vCloud������Ϣ
	 * @return ��֯�б�
	 * @throws BLException
	 */
	public List<Org> searchOrg(VCD01Info vcdInfo) throws BLException {
		List<Org> lst_Org = new ArrayList<Org>();
		Org org = null;
		VcloudClient vcloudClient = null;
		try {
			//��ȡ����ʵ��
			vcloudClient = getConnectInstance(vcdInfo);
			//��ȡ��֯
			for (ReferenceType orgRef : vcloudClient.getOrgRefs()) {
				org = new Org();
				org.setName(orgRef.getName());
				org.setVcid(vcdInfo.getVcid());
				lst_Org.add(org);
			}
		} catch (Exception e) {
			log.error("", e);
			throw new BLException("IGCO10000.E141", "��ȡ" + vcdInfo.getVcname() + "��֯ʧ�ܣ�");
		}
		return lst_Org;
	}
	
	/**
	 * ��ȡָ����֯��Ŀ¼�б�
	 * @param vcdInfo vCloud������Ϣ
	 * @return Ŀ¼�б�
	 * @throws BLException
	 */
	public List<Catalog> searchCatalog(VCD01Info vcdInfo, String orgName) throws BLException {
		List<Catalog> lst_Catalog = new ArrayList<Catalog>();
		Catalog catalog = null;
		try {
			Organization org = getOrganization(vcdInfo, orgName);
			//��ȡĿ¼
			for (ReferenceType catalogRef : org.getCatalogRefs()) {
				catalog = new Catalog();
				catalog.setName(catalogRef.getName());
				lst_Catalog.add(catalog);
			}
		} catch (Exception e) {
			log.error("", e);
			throw new BLException("IGCO10000.E141", "��ȡ" + orgName + "���ģ��ʧ�ܣ�");
		}
		return lst_Catalog;
	}
	
	/**
	 * ��ȡ����vCloud��ģ���б�
	 * @return ģ���б�
	 * @throws BLException
	 */
	@SuppressWarnings("unchecked")
	public List<Template> searchTemplate(VCD01Info vcdInfo, String orgName, String catalogName) throws BLException {
		List<Template> lst_Template = new ArrayList<Template>();
		VcloudClient vcloudClient = null;
		Template template = null;
		try {
			//��ȡ����ʵ��
			vcloudClient = getConnectInstance(vcdInfo);
			//��ȡ��֯
			ReferenceType orgRef = vcloudClient.getOrgRefsByName().get(orgName);
			//��ȡĿ¼
			QueryParams<QueryAdminVAppTemplateField> queryParams = new QueryParams<QueryAdminVAppTemplateField>();
			List<Expression> lst_Expression = new ArrayList<Expression>();
			lst_Expression.add(new Expression(QueryAdminVAppTemplateField.ORG, orgRef.getId(), ExpressionType.EQUALS));
			lst_Expression.add(new Expression(QueryAdminVAppTemplateField.CATALOGNAME, catalogName, ExpressionType.EQUALS));
			queryParams.setFilter(new Filter(FilterType.AND, lst_Expression));
			RecordResult<QueryResultAdminVAppTemplateRecordType> vappTemplateResult = vcloudClient.
					getQueryService().queryRecords(QueryRecordType.ADMINVAPPTEMPLATE, queryParams);
			for (QueryResultAdminVAppTemplateRecordType vappTemplate : vappTemplateResult.getRecords()) {
				template = new Template();
				template.setName(vappTemplate.getName());
				lst_Template.add(template);
			}
		} catch (Exception e) {
			log.error("", e);
			throw new BLException("IGCO10000.E141", "��ȡ" + orgName + "���ģ��ʧ�ܣ�");
		} 
		return lst_Template;
	}
	
	/**
     * ��ȡ����vCloud������б�
     * @return ����б�
     * @throws BLException
     */
	@SuppressWarnings("unchecked")
    public List<VirtualMachine> searchVirtualMachine(VCD01Info vcdInfo, String orgName, String catalogName) throws BLException {
	    List<VirtualMachine> lst_vm = new ArrayList<VirtualMachine>();
	    VcloudClient vcloudClient = null;
	    try {
	        //��ȡ����ʵ��
            vcloudClient = getConnectInstance(vcdInfo);
            // ��ȡ��֯
            ReferenceType orgRef = vcloudClient.getOrgRefsByName().get(orgName);
            
            QueryParams<QueryAdminVAppTemplateField>  adminQueryParams = new QueryParams<QueryAdminVAppTemplateField>();
            List<Expression> lst_Expression = new ArrayList<Expression>();
            lst_Expression = new ArrayList<Expression>();
            lst_Expression.add(new Expression(QueryAdminVMField.ORG, orgRef.getId(), ExpressionType.EQUALS));
            lst_Expression.add(new Expression(QueryAdminVMField.CATALOGNAME, catalogName, ExpressionType.EQUALS));
            adminQueryParams.setFilter(new Filter(FilterType.AND, lst_Expression));
            RecordResult<QueryResultAdminVMRecordType> vmResult = vcloudClient.getQueryService().queryRecords( QueryRecordType.ADMINVM, adminQueryParams);
            for (QueryResultAdminVMRecordType vmresult : vmResult.getRecords()) {
                VirtualMachine vm = new VirtualMachine();
                this.copyProperties(vmresult, vm);
                lst_vm.add(vm);
            }
            
        } catch (Exception e) {
            log.error("", e);
            throw new BLException("IGCO10000.E140", "��ȡ" + orgName + "������ʧ�ܣ�");
        }
	    return lst_vm;
	}
	
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
			String ip, String network,VcloudCloneProgressMonitor cloneProgressMonitor)  throws BLException{
		try {
			//ȡ������
			VcloudClient vcloudClient = getConnectInstance(vcd01);
			//ȡ��vapp
			Vapp vappObj = getVapp(vcd01,org,vdc,vapp);
			CatalogItem itemObj = getCatalogItem(vcd01,org, catalog, template, 
					"application/vnd.vmware.vcloud.vAppTemplate+xml");
			VappTemplate templateObj = VappTemplate.getVappTemplateByReference(vcloudClient, 
					itemObj.getEntityReference());
			VappTemplate vmObj = null;
			for (VappTemplate child : templateObj.getChildren()) {
				if (child.isVm()) {
					vmObj = child;
				}
			}
			// Change vApp settings
			RecomposeVAppParamsType recomp = new RecomposeVAppParamsType();
			recomp.setName(vappObj.getReference().getName());
			List<SourcedCompositionItemParamType> sources = recomp.getSourcedItem();

			// Change new VM network settings
			NetworkConnectionType nw = new NetworkConnectionType();
			nw.setIpAddress(ip);
			nw.setMACAddress(null);
			nw.setIpAddressAllocationMode("MANUAL");
			nw.setNetwork(network);
			nw.setIsConnected(true);
			
			NetworkConnectionSectionType networkObject = new NetworkConnectionSectionType();
			networkObject.setInfo(new MsgType());
			networkObject.getNetworkConnection().add(nw);

			InstantiationParamsType instant = new InstantiationParamsType();
			List<JAXBElement<? extends SectionType>> sections = instant.getSection();
			sections.add(new ObjectFactory().createNetworkConnectionSection(networkObject));

			String[] fqdnParts = fqdn.split("\\.");

			GuestCustomizationSectionType guest = new GuestCustomizationSectionType();
			guest.setInfo(new MsgType());
			guest.setComputerName(fqdnParts[0]);
			guest.setAdminPasswordAuto(true);
			guest.setAdminPasswordEnabled(true);
			guest.setEnabled(true);
			sections.add(new ObjectFactory().createGuestCustomizationSection(guest));

			// Whip it all up
			SourcedCompositionItemParamType s = new SourcedCompositionItemParamType();
			s.setSource(vmObj.getReference());
			s.getSource().setName(fqdn);
			s.setSourceDelete(false);
			s.setInstantiationParams(instant);
			sources.add(s);
			
			Task task = vappObj.recomposeVapp(recomp);
			if(cloneProgressMonitor != null){
				cloneProgressMonitor.setTask(task);
				cloneProgressMonitor.start();
			}
			
			
		} catch (Exception e) {
			cloneProgressMonitor.setError(true);
			log.error("",e);
			throw new BLException("IGCO10000.E141", "��¡�����ʧ�ܣ�");
		}
	}

	private Vapp getVapp(VCD01Info vcd01,String org, String vdc, String vapp) throws BLException{
		Vapp vappObj = null;
		try {
			//ȡ������
			VcloudClient vcloudClient = getConnectInstance(vcd01);
			Vdc vdcObj = this.getVDC(vcd01,org, vdc);
			vappObj = Vapp.getVappByReference(vcloudClient, vdcObj.getVappRefByName(vapp));
		} catch (Exception e) {
			log.error("",e);
			throw new BLException("IGCO10000.E141", "��ȡ������Ϣʧ�ܣ�");
		}
		return vappObj;
	}
	
	private Vdc getVDC(VCD01Info vcd01,String org, String vdc) throws BLException{
		Vdc vdcObj = null;
		try {
			//ȡ������
			VcloudClient vcloudClient = getConnectInstance(vcd01);
			Organization o = getOrganization(vcd01,org);
			ReferenceType vdcRef = o.getVdcRefByName(vdc);
			vdcObj = Vdc.getVdcByReference(vcloudClient, vdcRef);
		} catch (Exception e) {
			log.error("",e);
			throw new BLException("IGCO10000.E141", "��ȡvdc��Ϣʧ�ܣ�");
		}
		return vdcObj;
	}
	
	private Organization getOrganization(VCD01Info vcd01,String org) throws BLException{
		Organization orgObj = null;
		try {
			//ȡ������
			VcloudClient vcloudClient = getConnectInstance(vcd01);
			ReferenceType orgRef = vcloudClient.getOrgRefByName(org);
			orgObj = Organization.getOrganizationByReference(vcloudClient, orgRef);
		} catch (Exception e) {
			log.error("",e);
			throw new BLException("IGCO10000.E141", "��ȡ��֯��Ϣʧ�ܣ�");
		}
		return orgObj;
	}
	
	private CatalogItem getCatalogItem(VCD01Info vcd01,String org, String catalog, 
			String item, String type) throws BLException{
		com.vmware.vcloud.sdk.Catalog cat = null;
		VcloudClient vcloudClient = null;
		try {
			vcloudClient= getConnectInstance(vcd01);
			Organization orgObj = this.getOrganization(vcd01,org);

			for (ReferenceType catalogRef : orgObj.getCatalogRefs()) {
				if (catalogRef.getName().equals(catalog)) {
					cat = com.vmware.vcloud.sdk.Catalog.getCatalogByReference(vcloudClient, catalogRef);
				}
			}
		} catch(Exception e){
			log.error("",e);
			throw new BLException("IGCO10000.E141", "An error occured while retrieving Catalog!");
		}

		if (cat == null) {
			throw new BLException("IGCO10000.E141", "Catalog not found!");
		}

		CatalogItem itemObj = null;
		try {
			itemObj = CatalogItem.getCatalogItemByReference(vcloudClient, cat.getCatalogItemRefByName(item));

			if (!itemObj.getEntityReference().getType().equals(type)) {
				throw new BLException("IGCO10000.E141", "Catalog item was found, but was not of the requested type!");
			}
		} catch (VCloudException e) {
			throw new BLException("IGCO10000.E141", "An error occured while retrieving vApp!");
		} catch (NullPointerException ne) {
			throw new BLException("IGCO10000.E141", "Catalog item not found!");
		}

		return itemObj;
	}
}
