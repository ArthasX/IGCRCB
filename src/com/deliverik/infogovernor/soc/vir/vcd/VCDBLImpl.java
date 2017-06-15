/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * 概述: VCD业务逻辑实现
 * 功能描述: VCD业务逻辑实现
 * 创建记录:
 * 修改记录:
 */
public class VCDBLImpl extends BaseBLImpl implements VCDBL {
	
	static Log log = LogFactory.getLog(VCDBLImpl.class);
	
	/** vCloud配置BL */
	protected VCD01BL vcd01BL;
	
	/**
	 * vCloud配置BL设定
	 * @param vcd01BL vCloud配置BL
	 */
	public void setvcd01BL(VCD01BL vcd01BL) {
		this.vcd01BL = vcd01BL;
	}
	
	/**
	 * 获取vCloud连接实例，忽略认证信息
	 * @param vcInfo vCloud配置信息
	 * @return 连接实例
	 * @throws Exception
	 */
	private VcloudClient getConnectInstance(VCD01Info vcdInfo) throws Exception {
		return VCDConnection.getClient(vcdInfo);
	}

	/**
	 * 获取所有vCloud的组织列表
	 * @return 组织列表
	 * @throws BLException
	 */
	public List<Org> searchOrg() throws BLException {
		//查询vCloud配置表
		List<VCD01Info> lst_VCD01Info = this.vcd01BL.searchVCD01(new VCD01SearchCondImpl());
		List<Org> lst_Org = new ArrayList<Org>();
		//遍历并连接vCloud
		for(VCD01Info vcdInfo : lst_VCD01Info) {
			//获取模版
			lst_Org.addAll(searchOrg(vcdInfo));
		}
		return lst_Org;
	}
	
	/**
	 * 获取指定VCD的组织列表
	 * @param vcdInfo vCloud配置信息
	 * @return 组织列表
	 * @throws BLException
	 */
	public List<Org> searchOrg(VCD01Info vcdInfo) throws BLException {
		List<Org> lst_Org = new ArrayList<Org>();
		Org org = null;
		VcloudClient vcloudClient = null;
		try {
			//获取连接实例
			vcloudClient = getConnectInstance(vcdInfo);
			//获取组织
			for (ReferenceType orgRef : vcloudClient.getOrgRefs()) {
				org = new Org();
				org.setName(orgRef.getName());
				org.setVcid(vcdInfo.getVcid());
				lst_Org.add(org);
			}
		} catch (Exception e) {
			log.error("", e);
			throw new BLException("IGCO10000.E141", "获取" + vcdInfo.getVcname() + "组织失败！");
		}
		return lst_Org;
	}
	
	/**
	 * 获取指定组织的目录列表
	 * @param vcdInfo vCloud配置信息
	 * @return 目录列表
	 * @throws BLException
	 */
	public List<Catalog> searchCatalog(VCD01Info vcdInfo, String orgName) throws BLException {
		List<Catalog> lst_Catalog = new ArrayList<Catalog>();
		Catalog catalog = null;
		try {
			Organization org = getOrganization(vcdInfo, orgName);
			//获取目录
			for (ReferenceType catalogRef : org.getCatalogRefs()) {
				catalog = new Catalog();
				catalog.setName(catalogRef.getName());
				lst_Catalog.add(catalog);
			}
		} catch (Exception e) {
			log.error("", e);
			throw new BLException("IGCO10000.E141", "获取" + orgName + "相关模版失败！");
		}
		return lst_Catalog;
	}
	
	/**
	 * 获取所有vCloud的模版列表
	 * @return 模版列表
	 * @throws BLException
	 */
	@SuppressWarnings("unchecked")
	public List<Template> searchTemplate(VCD01Info vcdInfo, String orgName, String catalogName) throws BLException {
		List<Template> lst_Template = new ArrayList<Template>();
		VcloudClient vcloudClient = null;
		Template template = null;
		try {
			//获取连接实例
			vcloudClient = getConnectInstance(vcdInfo);
			//获取组织
			ReferenceType orgRef = vcloudClient.getOrgRefsByName().get(orgName);
			//获取目录
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
			throw new BLException("IGCO10000.E141", "获取" + orgName + "相关模版失败！");
		} 
		return lst_Template;
	}
	
	/**
     * 获取所有vCloud的虚机列表
     * @return 虚机列表
     * @throws BLException
     */
	@SuppressWarnings("unchecked")
    public List<VirtualMachine> searchVirtualMachine(VCD01Info vcdInfo, String orgName, String catalogName) throws BLException {
	    List<VirtualMachine> lst_vm = new ArrayList<VirtualMachine>();
	    VcloudClient vcloudClient = null;
	    try {
	        //获取连接实例
            vcloudClient = getConnectInstance(vcdInfo);
            // 获取组织
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
            throw new BLException("IGCO10000.E140", "获取" + orgName + "相关虚机失败！");
        }
	    return lst_vm;
	}
	
	/**
	 * 
	 * <p>功能：克隆虚拟机</p>
	 * 
	 * @param 连接信息
	 * @param org 组织
	 * @param vdc 
	 * @param vapp 分组名称
	 * @param catalog 目录
	 * @param template 模板
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
			//取得链接
			VcloudClient vcloudClient = getConnectInstance(vcd01);
			//取得vapp
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
			throw new BLException("IGCO10000.E141", "克隆虚拟机失败！");
		}
	}

	private Vapp getVapp(VCD01Info vcd01,String org, String vdc, String vapp) throws BLException{
		Vapp vappObj = null;
		try {
			//取得链接
			VcloudClient vcloudClient = getConnectInstance(vcd01);
			Vdc vdcObj = this.getVDC(vcd01,org, vdc);
			vappObj = Vapp.getVappByReference(vcloudClient, vdcObj.getVappRefByName(vapp));
		} catch (Exception e) {
			log.error("",e);
			throw new BLException("IGCO10000.E141", "获取链接信息失败！");
		}
		return vappObj;
	}
	
	private Vdc getVDC(VCD01Info vcd01,String org, String vdc) throws BLException{
		Vdc vdcObj = null;
		try {
			//取得链接
			VcloudClient vcloudClient = getConnectInstance(vcd01);
			Organization o = getOrganization(vcd01,org);
			ReferenceType vdcRef = o.getVdcRefByName(vdc);
			vdcObj = Vdc.getVdcByReference(vcloudClient, vdcRef);
		} catch (Exception e) {
			log.error("",e);
			throw new BLException("IGCO10000.E141", "获取vdc信息失败！");
		}
		return vdcObj;
	}
	
	private Organization getOrganization(VCD01Info vcd01,String org) throws BLException{
		Organization orgObj = null;
		try {
			//取得链接
			VcloudClient vcloudClient = getConnectInstance(vcd01);
			ReferenceType orgRef = vcloudClient.getOrgRefByName(org);
			orgObj = Organization.getOrganizationByReference(vcloudClient, orgRef);
		} catch (Exception e) {
			log.error("",e);
			throw new BLException("IGCO10000.E141", "获取组织信息失败！");
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
