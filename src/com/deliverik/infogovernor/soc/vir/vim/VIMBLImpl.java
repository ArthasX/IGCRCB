/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.vim;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM01BL;
import com.deliverik.infogovernor.soc.vir.model.VIM01Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM01SearchCondImpl;
import com.deliverik.infogovernor.soc.vir.vim.model.Data_Center;
import com.deliverik.infogovernor.soc.vir.vim.model.Host;
import com.deliverik.infogovernor.soc.vir.vim.model.NetLabel;
import com.deliverik.infogovernor.soc.vir.vim.model.Resource_Pool;
import com.deliverik.infogovernor.soc.vir.vim.model.Template;
import com.deliverik.infogovernor.soc.vir.vim.model.VMachine;
import com.vmware.vim25.ConcurrentAccess;
import com.vmware.vim25.DatastoreSummary;
import com.vmware.vim25.DuplicateName;
import com.vmware.vim25.FileFault;
import com.vmware.vim25.HostHardwareInfo;
import com.vmware.vim25.HostNetworkInfo;
import com.vmware.vim25.HostVirtualSwitch;
import com.vmware.vim25.InsufficientResourcesFault;
import com.vmware.vim25.InvalidDatastore;
import com.vmware.vim25.InvalidName;
import com.vmware.vim25.InvalidPowerState;
import com.vmware.vim25.InvalidProperty;
import com.vmware.vim25.InvalidState;
import com.vmware.vim25.LocalizedMethodFault;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.TaskInProgress;
import com.vmware.vim25.TaskInfoState;
import com.vmware.vim25.VirtualCdrom;
import com.vmware.vim25.VirtualDevice;
import com.vmware.vim25.VirtualDeviceConfigSpec;
import com.vmware.vim25.VirtualDeviceConfigSpecFileOperation;
import com.vmware.vim25.VirtualDeviceConfigSpecOperation;
import com.vmware.vim25.VirtualDisk;
import com.vmware.vim25.VirtualDiskFlatVer2BackingInfo;
import com.vmware.vim25.VirtualEthernetCard;
import com.vmware.vim25.VirtualEthernetCardNetworkBackingInfo;
import com.vmware.vim25.VirtualLsiLogicController;
import com.vmware.vim25.VirtualMachineCloneSpec;
import com.vmware.vim25.VirtualMachineConfigInfo;
import com.vmware.vim25.VirtualMachineConfigSpec;
import com.vmware.vim25.VirtualMachineRelocateSpec;
import com.vmware.vim25.VirtualPCNet32;
import com.vmware.vim25.VirtualSCSISharing;
import com.vmware.vim25.VmConfigFault;
import com.vmware.vim25.mo.Datacenter;
import com.vmware.vim25.mo.Datastore;
import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.HostNetworkSystem;
import com.vmware.vim25.mo.HostSystem;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ManagedEntity;
import com.vmware.vim25.mo.Network;
import com.vmware.vim25.mo.ResourcePool;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.Task;
import com.vmware.vim25.mo.VirtualMachine;

/**
 * 概述: VIM业务逻辑实现
 * 功能描述: VIM业务逻辑实现
 * 创建记录:
 * 修改记录:
 */
public class VIMBLImpl extends BaseBLImpl implements VIMBL {
	
	static Log log = LogFactory.getLog(VIMBLImpl.class);
	
	/** vCenter配置BL */
	protected VIM01BL vim01BL;
	
	/**
	 * vCenter配置BL设定
	 * @param vim01BL vCenter配置BL
	 */
	public void setVim01BL(VIM01BL vim01BL) {
		this.vim01BL = vim01BL;
	}
	
	/**
	 * 获取vCenter连接实例，忽略认证信息
	 * @param vcInfo vCenter配置信息
	 * @return 连接实例
	 * @throws Exception
	 */
	private ServiceInstance getConnectInstance(VIM01Info vcInfo) throws Exception {
		return new ServiceInstance(new URL("https://" + vcInfo.getVcurl() + "/sdk"),
				vcInfo.getVcusername(), vcInfo.getVcpassword(), true);//true表示忽略认证
	}

	/**
	 * 获取模版列表
	 * 模版中含有对应的vCenter配置信息和VM配置信息
	 * @param si vCenter连接实例
	 * @param vcInfo vCenter配置信息
	 * @return 模版列表
	 * @throws Exception
	 */
	private List<Template> searchTemplate(ServiceInstance si, VIM01Info vcInfo) throws Exception {
		//检索VM列表
		ManagedEntity[] vms = new InventoryNavigator(si.getRootFolder()).searchManagedEntities(
				new String[][] { { "VirtualMachine","name" }, }, true);
		List<Template> lst_Template = new ArrayList<Template>();
		Template template = null;
		VirtualMachineConfigInfo config = null;
		if(vms != null) {
			for (ManagedEntity entity : vms) {
				//VM配置信息
				config = ((VirtualMachine) entity)
						.getConfig();
				if(config == null) {
					continue;
				}
				//是否为VM模版
				if(config.isTemplate()) {
					template = new Template();
					template.setName(entity.getName());
					template.setVcid(vcInfo.getVcid());
					template.setVcname(vcInfo.getVcname());
					template.setNumCPU(config.hardware.getNumCPU());
					template.setMemoryGB(config.hardware.getMemoryMB() / 1024);
					//获取设备列表
					VirtualDevice[] device = config.hardware.device;
					for (int s = 0; s < device.length; s++) {
						//检索硬盘
						if (device[s].getDeviceInfo().getLabel().indexOf("硬盘") != -1) {
							template.setDiskGB(Integer.parseInt(device[s].getDeviceInfo().getSummary()
									.replace("KB", "").replace(",", "").trim()) / 1024 / 1024);
							break;//只显示第1块硬盘
						}
					}
					lst_Template.add(template);
				}
			}
		}
		return lst_Template;
	}

	/**
	 * 获取所有vCenter的模版列表
	 * @return 模版列表
	 * @throws BLException
	 */
	public List<Template> searchTemplate() throws BLException {
		//查询vCenter配置表
		List<VIM01Info> lst_VIM01Info = this.vim01BL.searchVIM01(new VIM01SearchCondImpl());
		List<Template> lst_Template = new ArrayList<Template>();
		//遍历并连接vCenter
		for(VIM01Info vcInfo : lst_VIM01Info) {
			ServiceInstance si = null;
			try {
				//获取连接实例
				si = getConnectInstance(vcInfo);
				//获取模版
				lst_Template.addAll(searchTemplate(si, vcInfo));
			} catch (Exception e) {
				log.error("", e);
				throw new BLException("IGCO10000.E140", "获取" + vcInfo.getVcname() + "相关模版失败！");
			} finally {
				//关闭连接
				if(si != null) {
					si.getServerConnection().logout();
					si = null;
				}
			}
		}
		return lst_Template;
	}
	
	/**
	 * 获取指定vCenter的数据中心列表
	 * @param vcid vCenter配置ID
	 * @return 数据中心列表
	 * @throws BLException
	 */
	public List<Data_Center> searchDatacenterByVcid(Integer vcid) throws BLException {
		//查询指定vCenter
		VIM01Info vcInfo = this.vim01BL.searchVIM01ByPK(vcid);
		List<Data_Center> lst_Datacenter = new ArrayList<Data_Center>();
		Data_Center datacenter = null;
		ServiceInstance si = null;
		try {
			//获取连接实例
			si = getConnectInstance(vcInfo);
			//获取Datacenter
			ManagedEntity[] dcs = new InventoryNavigator(si.getRootFolder())
				.searchManagedEntities(new String[][] { { "Datacenter", "name" }, }, true);
			if(dcs != null) {
				for (ManagedEntity entity : dcs) {
					datacenter = new Data_Center();
					datacenter.setName(entity.getName());
					lst_Datacenter.add(datacenter);
				}
			}
		} catch (Exception e) {
			log.error("", e);
			throw new BLException("IGCO10000.E140", "获取Datacenter失败！");
		} finally {
			//关闭连接
			if(si != null) {
				si.getServerConnection().logout();
				si = null;
			}
		}
		return lst_Datacenter;
	}
	
	/**
	 * 获取指定vCenter的资源池列表
	 * @param vcid vCenter配置ID
	 * @return 资源池列表
	 * @throws BLException
	 */
	public List<Resource_Pool> searchResourcePoolByVcid(Integer vcid) throws BLException {
		//查询指定vCenter
		VIM01Info vcInfo = this.vim01BL.searchVIM01ByPK(vcid);
		List<Resource_Pool> lst_ResourcePool = new ArrayList<Resource_Pool>();
		Resource_Pool resourcePool = null;
		ServiceInstance si = null;
		try {
			//获取连接实例
			si = getConnectInstance(vcInfo);
			//获取ResourcePool
			ManagedEntity[] dcs = new InventoryNavigator(si.getRootFolder())
				.searchManagedEntities(new String[][] { { "ResourcePool", "name" }, }, true);
			if(dcs != null) {
				for (ManagedEntity entity : dcs) {
					resourcePool = new Resource_Pool();
//					Integer index = entity.getName().indexOf("(");
//					if (index != -1) {
//					    resourcePool.setName(entity.getName().substring(0, index));
//					} else {
					    resourcePool.setName(entity.getName());
//					}
					lst_ResourcePool.add(resourcePool);
				}
			}
		} catch (Exception e) {
			log.error("", e);
			throw new BLException("IGCO10000.E140", "获取ResourcePool失败！");
		} finally {
			//关闭连接
			if(si != null) {
				si.getServerConnection().logout();
				si = null;
			}
		}
		return lst_ResourcePool;
	}
	
	/**
	 * 获取指定vCenter的主机
	 * @param vcid vCenter配置ID
	 * @return 主机列表
	 * @throws BLException
	 */
	public List<Host> searchHostByVcid(Integer vcid) throws BLException {
		//查询指定vCenter
		VIM01Info vcInfo = this.vim01BL.searchVIM01ByPK(vcid);
		List<Host> lst_Host = new ArrayList<Host>();
		Host host = null;
		ServiceInstance si = null;
		try {
			//获取连接实例
			si = getConnectInstance(vcInfo);
			//获取Host
			ManagedEntity[] hs = new InventoryNavigator(si.getRootFolder())
				.searchManagedEntities(new String[][] { { "HostSystem", "name" }, }, true);
			if(hs != null) {
				for (ManagedEntity entity : hs) {
					if(entity != null) {
						HostSystem info = (HostSystem)entity;
						HostHardwareInfo hardware = info.getHardware();
						//cpu
						int cpuCores = hardware.getCpuInfo().getNumCpuCores();
						Integer cpuHz = info.getSummary().getHardware().getCpuMhz();
						Integer cpuUsage = info.getSummary().getQuickStats().getOverallCpuUsage();
						//memory
						String memoryMB = String.format("%.2f", Double.parseDouble(String.valueOf(hardware.memorySize))/1024/1024);
						Integer memoryUsage = info.getSummary().getQuickStats().getOverallMemoryUsage();
						
						long capacityLong = 0;
						long freeSpaceLong = 0;
						Datastore[] datastores = info.getDatastores();
						for(Datastore datastore:datastores){
							DatastoreSummary datastoreSummary = datastore.getSummary();
							capacityLong += datastoreSummary.getCapacity();
							freeSpaceLong += datastoreSummary.getFreeSpace();
						}
						//硬盘
						String capacity = String.format("%.2f", Double.parseDouble(String.valueOf(capacityLong))/1024/1024/1024);
						//空闲硬盘
						String freeSpace = String.format("%.2f", Double.parseDouble(String.valueOf(freeSpaceLong))/1024/1024/1024);
						//连接状况
						String connectionState = info.getSummary().getRuntime().getConnectionState().name();
						
						int vm_powereOn_num = 0;
						int vm_powereOff_num = 0;
						int vm_num = 0;
						//虚机
						List<VMachine> vmsList = new ArrayList<VMachine>();
						VirtualMachine[] hvms = info.getVms();
						for(VirtualMachine hvm:hvms){
							if(!hvm.getConfig().isTemplate()){
								
								int vmCapacityLong = 0;
								int hvmfreeSpaceLong = 0;
								String netLabels = "";
								VirtualDevice[] device = hvm.getConfig().hardware.getDevice();
								for (int s = 0; s < device.length; s++) {
									//检索硬盘
									if (device[s].getDeviceInfo().getLabel().indexOf("硬盘") != -1) {
										vmCapacityLong += Integer.parseInt(device[s].getDeviceInfo().getSummary().replace("KB", "").replace(",", "").trim());
									}else if(device[s].getDeviceInfo().getLabel().indexOf("网络适配器") != -1){
										netLabels += device[s].getDeviceInfo().getSummary()+",";
									}
								}
								if(netLabels.length()>0) netLabels = netLabels.substring(0,netLabels.length()-1);
								String vmCapacity = String.format("%.2f", Double.parseDouble(String.valueOf(vmCapacityLong))/1024/1024);

								VMachine vMachine = new VMachine();
								vMachine.setName(hvm.getName());
								vMachine.setCpuCores(hvm.getConfig().hardware.numCPU);
								vMachine.setMemoryMB(""+hvm.getConfig().hardware.memoryMB);
								vMachine.setCapacity(vmCapacity);
								vMachine.setNetLabels(netLabels);
								vMachine.setPowerState(hvm.getSummary().getRuntime().getPowerState().name());
								vMachine.setIp(hvm.getSummary().getGuest().getIpAddress());
								vMachine.setCpuUsage(hvm.getSummary().getQuickStats().getOverallCpuUsage());
								vMachine.setMemoryUsage( hvm.getSummary().getQuickStats().getGuestMemoryUsage());
								vMachine.setCpuHz(hvm.getConfig().hardware.getNumCoresPerSocket());
								vMachine.setFreeSpace(String.format("%.2f", Double.parseDouble(String.valueOf(hvmfreeSpaceLong))/1024/1024/1024));
								String ostype = "oth";
								String fullname = hvm.getConfig().getGuestFullName() == null ? "" : hvm.getConfig().getGuestFullName();
								if (fullname.indexOf("Window") != -1) {
								    ostype = "win";
								} else if (fullname.indexOf("Linux") != -1 || fullname.indexOf("CentOS") != -1 || fullname.indexOf("Asianux") != -1) {
								    ostype = "lin";
								}
								vMachine.setOsType(ostype);
								vmsList.add(vMachine);
								 
								if("poweredOn".equals(hvm.getSummary().getRuntime().getPowerState().name())){
									vm_powereOn_num ++ ;
								}else{
									vm_powereOff_num ++ ;
								}
								vm_num ++;
							}
						}
						
						host = new Host();
						host.setName(entity.getName());
						host.setCpuCores(cpuCores);
						host.setCpuHz(cpuHz);
						host.setCpuUsage(cpuUsage);
						host.setMemoryMB(memoryMB);
						host.setMemoryUsage(memoryUsage);
						host.setCapacity(capacity);
						host.setFreeSpace(freeSpace);
						host.setConnectionState(connectionState);
						host.setVmsList(vmsList);
						host.setVm_powereOn_num(vm_powereOn_num);
						host.setVm_powereOff_num(vm_powereOff_num);
						host.setVm_num(vm_num);
						host.setPowerState(info.getSummary().getRuntime().getPowerState().name());
						lst_Host.add(host);
					}
				}
			}
		} catch (Exception e) {
			log.error("", e);
			throw new BLException("IGCO10000.E140", "获取Host失败！");
		} finally {
			//关闭连接
			if(si != null) {
				si.getServerConnection().logout();
				si = null;
			}
		}
		return lst_Host;
	}

	/**
	 * 获取指定主机的网络标签
	 * @param vcid vCenter配置ID
	 * @param hostip 主机IP
	 * @return 网络标签列表
	 * @throws BLException
	 */
	public List<NetLabel> searchNetLabelByHost(Integer vcid, String hostip) throws BLException {
		//查询指定vCenter
		VIM01Info vcInfo = this.vim01BL.searchVIM01ByPK(vcid);
		List<NetLabel> lst_NetLabel = new ArrayList<NetLabel>();
		NetLabel netLabel = null;
		ServiceInstance si = null;
		try {
			//获取连接实例
			si = getConnectInstance(vcInfo);
			//获取Host
			HostSystem host = (HostSystem) new InventoryNavigator(si.getRootFolder()).searchManagedEntity("HostSystem", hostip);
			HostNetworkSystem hns = host.getHostNetworkSystem();
			HostNetworkInfo nwi = hns.getNetworkInfo();
			HostVirtualSwitch[] vswitch = nwi.getVswitch();
			if(vswitch != null) {
				//查找虚拟交换机
				for (HostVirtualSwitch hostVirtualSwitch : vswitch) {
					for (String label : hostVirtualSwitch.getPortgroup()) {
						netLabel = new NetLabel();
						netLabel.setName(label.split("-")[2]);
						lst_NetLabel.add(netLabel);
					}
				}
			}
		} catch (Exception e) {
			log.error("", e);
			throw new BLException("IGCO10000.E140", "获取网络标签失败！");
		} finally {
			//关闭连接
			if(si != null) {
				si.getServerConnection().logout();
				si = null;
			}
		}
		return lst_NetLabel;
	}
	
	/**
	 * 获取指定Datacenter的网络标签
	 * @param vcid vCenter配置ID
	 * @param dcanem 数据中心名称
	 * @return 网络标签列表
	 * @throws BLException
	 */
	public List<NetLabel> searchNetLabelByDatacenter(Integer vcid, String dcname) throws BLException {
	    //查询指定vCenter
	    VIM01Info vcInfo = this.vim01BL.searchVIM01ByPK(vcid);
	    List<NetLabel> lst_NetLabel = new ArrayList<NetLabel>();
	    NetLabel netLabel = null;
	    ServiceInstance si = null;
	    try {
	        //获取连接实例
	        si = getConnectInstance(vcInfo);
	        //获取Host
	        Datacenter dc = (Datacenter) new InventoryNavigator(si.getRootFolder()).searchManagedEntity("Datacenter", "SDDC");
	        Network[] networks = dc.getNetworks();
            for (Network network : networks) {
                System.out.println("        " + network.getName() + "  " + network.getSummary());
                netLabel = new NetLabel();
                netLabel.setName(network.getName());
                lst_NetLabel.add(netLabel);
            }
	    } catch (Exception e) {
	        log.error("", e);
	        throw new BLException("IGCO10000.E140", "获取网络标签失败！");
	    } finally {
	        //关闭连接
	        if(si != null) {
	            si.getServerConnection().logout();
	            si = null;
	        }
	    }
	    return lst_NetLabel;
	}
	
	/**
	 * 通过指定模版复制VM
	 * 当rpName为空时，默认为Resources
	 * @param si vCenter连接实例 
	 * @param cloneName 新VM名称
	 * @param dcName 数据中心名称
	 * @param rpName 资源池名称
	 * @return 返回长度为2的数组,[0]值：0失败，1成功;[1]值：操作信息
	 * @throws BLException
	 */
	public String[] cloneVMFromTemplate(Template template, String cloneName, String dcName, String rpName, CloneProgressMonitorBase cloneProgressMonitor) throws BLException {
	    System.out.println(template.toString());
	    
		//查询指定vCenter
		VIM01Info vcInfo = this.vim01BL.searchVIM01ByPK(template.getVcid());
		ServiceInstance si = null;
		Object[] result = null;
		try {
			//获取连接实例
			si = getConnectInstance(vcInfo);
			//获取模版
			VirtualMachine vm = (VirtualMachine) new InventoryNavigator(si.getRootFolder())
				.searchManagedEntity("VirtualMachine", template.getName());
			//查找ResourcePool，默认为Resources
			if(StringUtils.isEmpty(rpName)) {
				rpName = "Resources";
			}
			ResourcePool rp = (ResourcePool) new InventoryNavigator(si.getRootFolder())
				.searchManagedEntity("ResourcePool", rpName);
			//查找Datacenter
			Datacenter dc = ((Datacenter) si.getSearchIndex()
					.findByInventoryPath(dcName));
			//获取虚机位置
			Folder vmFolder = dc.getVmFolder();
			//VMclone信息
			VirtualMachineCloneSpec cloneSpec = new VirtualMachineCloneSpec();
			//VM迁移信息
			VirtualMachineRelocateSpec vmrSpec = new VirtualMachineRelocateSpec();
			//设定资源池
			vmrSpec.setPool(rp.getMOR());
			//默认关机
			cloneSpec.setPowerOn(false);
			//类型不是模版
			cloneSpec.setTemplate(false);
			
//			//VM配置信息
//	        VirtualMachineConfigSpec vmConfigSpec = new VirtualMachineConfigSpec();
//	        //内存
//	        vmConfigSpec.memoryMB = template.getMemoryGB() * 1024L;
//	        //CPU
//	        vmConfigSpec.numCPUs = template.getNumCPU();
//	        cloneSpec.config = vmConfigSpec;
	        
	        cloneSpec.setLocation(vmrSpec);
	        Task task = vm.cloneVM_Task(vmFolder, cloneName, cloneSpec);
	        
	        // 当进度监控对象不为空时启动进度监控
	        if(null != cloneProgressMonitor){
	            cloneProgressMonitor.setTask(task);
	            cloneProgressMonitor.start();
	        }
	        
	        result = WaitForValues.waitForValues(si,task.getMOR(), new String[]{"info.state", "info.error", "info.progress"},
		            new String[]{"state"},
		            new Object[][]{new Object[]{TaskInfoState.success, TaskInfoState.error}});
	        // 克隆虚机返回结果
	        // 当克隆成功后修改虚机配置
	        if (result != null && result.length > 1 && result[0].equals(TaskInfoState.success)) {
	        	return reconfigVM(si, template, cloneName, cloneProgressMonitor);
	        } else {
	        	LocalizedMethodFault msg = (LocalizedMethodFault)result[1];
	        	
	        	// 当创建失败时停止进度监控进程
	        	if(null != cloneProgressMonitor){
	        	    cloneProgressMonitor.setError(true);
	        	}
	        	return new String[]{"0", msg.localizedMessage};
	        }
		} catch (Exception e) {
			log.error("", e);
			// 当创建失败时停止进度监控进程
            if(null != cloneProgressMonitor){
                cloneProgressMonitor.setError(true);
            }
			return new String[]{"0", "复制模版失败！"};
		} finally {
			//关闭连接
			if(si != null) {
				si.getServerConnection().logout();
				si = null;
			}
		}
	}

	/**
     * 通过指定模版复制调整VM配置
     * 当rpName为空时，默认为Resources
     * @param vmName VM名称
     * @return 返回长度为2的数组,[0]值：0失败，1成功;[1]值：操作信息
     * @throws BLException
     */
    public String[] reconfigVM(Template template, String vmName, CloneProgressMonitorBase cloneProgressMonitor) throws BLException {
        System.out.println(template.toString());
        
        //查询指定vCenter
        VIM01Info vcInfo = this.vim01BL.searchVIM01ByPK(template.getVcid());
        ServiceInstance si = null;
        String result[] = null;
        try {
          //获取连接实例
            si = getConnectInstance(vcInfo);
            result = reconfigVM(si, template, vmName, cloneProgressMonitor);
        } catch (Exception e) {
            log.debug("---------- 调整虚机配置异常 ---------");
            log.error("调整虚机配置异常", e);
        }
        
        return result;
        
    }	
    
	/**
	 * 修改虚机配置 
	 * 
	 * @param si
	 * @param template
	 * @param vmName
	 * @param cloneProgressMonitor
	 * @return
	 */
    private String[] reconfigVM(ServiceInstance si, Template template, String vmName,
            CloneProgressMonitorBase cloneProgressMonitor) throws InvalidProperty, RuntimeFault, RemoteException,
            InvalidName, VmConfigFault, DuplicateName, TaskInProgress, FileFault, InvalidState, ConcurrentAccess,
            InvalidDatastore, InsufficientResourcesFault, Exception, InvalidPowerState {
        Object[] result;
        Task task;
        //修改VM配置
        VirtualMachine newVM = (VirtualMachine) new InventoryNavigator(si.getRootFolder()).searchManagedEntity("VirtualMachine", vmName);
        VirtualMachineConfigSpec reConfigSpec = getReConfigSpec(newVM, template);
        task = newVM.reconfigVM_Task(reConfigSpec);
        
        result = WaitForValues.waitForValues(si,task.getMOR(), new String[]{"info.state", "info.error", "info.progress"},
                new String[]{"state"}, new Object[][]{new Object[]{TaskInfoState.success, TaskInfoState.error}});
        // 修改虚机配置结果
        if (result != null && result.length > 1 && result[0].equals(TaskInfoState.success)) {
            if(null != cloneProgressMonitor){
                cloneProgressMonitor.setSuccessed(true);
            }
        	return new String[]{"1", ""};
        } else {
        	//修改配置失败时删除VM
        	newVM.unregisterVM();
        	LocalizedMethodFault msg = (LocalizedMethodFault)result[1];
        	
        	// 当创建失败时停止进度监控进程
            if(null != cloneProgressMonitor){
                cloneProgressMonitor.setError(true);
            }
        	return new String[]{"0", msg.localizedMessage};
        }
    }
    
	/**
	 * 生成需要更新的配置信息
	 * @param vm VM
	 * @param template 模版
	 * @return 更新的配置信息
	 */
	private VirtualMachineConfigSpec getReConfigSpec(VirtualMachine vm, Template template) {
		//设备列表
		VirtualDevice [] vds = vm.getConfig().getHardware().getDevice();
		VirtualDisk disk = null;
		VirtualEthernetCard nic = null;
		for(VirtualDevice device : vds) {
			//查找第1块硬盘
			if(disk == null && device.getDeviceInfo().getLabel().indexOf("硬盘") > -1) {
				disk = (VirtualDisk)device;
				continue;
			}
			//查找第1块网卡
			if(nic == null && device.getDeviceInfo().getLabel().indexOf("网络适配器") > -1) {
				nic = (VirtualEthernetCard)device;
				continue;
			}
		}
		//VM配置信息
		VirtualMachineConfigSpec vmConfigSpec = new VirtualMachineConfigSpec();
		//硬盘配置信息
		VirtualDeviceConfigSpec diskSpec = new VirtualDeviceConfigSpec(); 
		diskSpec.operation = VirtualDeviceConfigSpecOperation.edit;
		disk.capacityInKB = template.getDiskGB() * 1024*1024L;
		diskSpec.device = disk;
		// 内存配置信息
        vmConfigSpec.memoryMB = template.getMemoryGB() * 1024L;
        // CPU配置信息
        vmConfigSpec.numCPUs = template.getNumCPU();

        //网卡配置信息
		VirtualDeviceConfigSpec nicSpec = new VirtualDeviceConfigSpec();
		VirtualEthernetCardNetworkBackingInfo nicBacking = (VirtualEthernetCardNetworkBackingInfo)nic.getBacking();
		nicBacking.setDeviceName(template.getNetName());
		nic.setBacking(nicBacking);
		nicSpec.operation = VirtualDeviceConfigSpecOperation.edit;
		nicSpec.device = nic;
		
		VirtualDeviceConfigSpec [] vdiskSpecArray = { diskSpec, nicSpec};         
		vmConfigSpec.setDeviceChange(vdiskSpecArray);
		return vmConfigSpec;
	}

	/**
	 * 通过指定模版复制VM
	 * 当rpName为空时，默认为Resources
	 * @param si vCenter连接实例 
	 * @param cloneName 新VM名称
	 * @param dcName 数据中心名称
	 * @param rpName 资源池名称
	 * @return 返回长度为2的数组,[0]值：0失败，1成功;[1]值：操作信息
	 * @throws BLException
	 */
	public String[] createVM(Template template, String cloneName, String dcName, String rpName) throws BLException {
		//查询指定vCenter
		VIM01Info vcInfo = this.vim01BL.searchVIM01ByPK(template.getVcid());
		ServiceInstance si = null;
		Object[] result = null;
		try {
			//获取连接实例
			si = getConnectInstance(vcInfo);
			//查找ResourcePool，默认为Resources
			if(StringUtils.isEmpty(rpName)) {
				rpName = "Resources";
			}
			ResourcePool rp = (ResourcePool) new InventoryNavigator(si.getRootFolder())
				.searchManagedEntity("ResourcePool", rpName);
			//查找Datacenter
			Datacenter dc = ((Datacenter) si.getSearchIndex()
					.findByInventoryPath(dcName));
			Folder vmFolder = dc.getVmFolder();
			//创建VM配置文件
			VirtualMachineConfigSpec vmSpec = new VirtualMachineConfigSpec();
			vmSpec.setName(cloneName);
			vmSpec.setAnnotation("VirtualMachine Annotation");
			vmSpec.setMemoryMB(template.getMemoryGB() * 1024L);
			vmSpec.setNumCPUs(template.getNumCPU());
			//vmSpec.setGuestId(guestOsId);
			//创建设备
			//int cKey = 1000;
			VirtualDeviceConfigSpec scsiSpec = createScsiSpec();
			VirtualDeviceConfigSpec diskSpec = createDiskSpec(dcName, template.getDiskGB() * 1024L * 1024L);
			VirtualDeviceConfigSpec nicSpec = createNicSpec(template.getNetName());
			VirtualDeviceConfigSpec cdrom = createCdromSpec();
			vmSpec.setDeviceChange(new VirtualDeviceConfigSpec[] {scsiSpec, diskSpec, nicSpec, cdrom});
//			    // create vm file info for the vmx file
//			    VirtualMachineFileInfo vmfi = new VirtualMachineFileInfo();
//			    vmfi.setVmPathName("["+ datastoreName +"]");
//			    vmSpec.setFiles(vmfi);

			Task task = vmFolder.createVM_Task(vmSpec, rp, null);
	        result = WaitForValues.waitForValues(si,task.getMOR(), new String[]{"info.state", "info.error", "info.progress"},
		            new String[]{"state"},
		            new Object[][]{new Object[]{TaskInfoState.success, TaskInfoState.error}});
	        //返回结果
	        if (result != null && result.length > 1 && result[0].equals(TaskInfoState.success)) {
	 	        return new String[]{"1", ""};
	 	    } else {
	        	LocalizedMethodFault msg = (LocalizedMethodFault)result[1];
	        	return new String[]{"0", msg.localizedMessage};
	        }
		} catch (Exception e) {
			log.error("", e);
			return new String[]{"0", "创建VM失败"};
		} finally {
			//关闭连接
			if(si != null) {
				si.getServerConnection().logout();
				si = null;
			}
		}
	}

	/**
	 * 创建控制器配置信息
	 * @return 控制器配置信息
	 */
	private VirtualDeviceConfigSpec createScsiSpec() {
		VirtualDeviceConfigSpec scsiSpec = new VirtualDeviceConfigSpec();
		scsiSpec.setOperation(VirtualDeviceConfigSpecOperation.add);
		VirtualLsiLogicController scsiCtrl = new VirtualLsiLogicController();
//		scsiCtrl.setKey(cKey);
//		scsiCtrl.setBusNumber(0);
		scsiCtrl.setSharedBus(VirtualSCSISharing.noSharing);
		scsiSpec.setDevice(scsiCtrl);
		return scsiSpec;
	}
	  
	 /**
	  * 创建硬盘配置信息
	 * @param dsName 数据中心
	 * @param diskSizeKB 硬盘大小
	 * @return 硬盘配置信息
	 */
	private VirtualDeviceConfigSpec createDiskSpec(String dcName, long diskSizeKB) {
		 VirtualDeviceConfigSpec diskSpec = new VirtualDeviceConfigSpec();
		 diskSpec.setOperation(VirtualDeviceConfigSpecOperation.add);
		 diskSpec.setFileOperation(VirtualDeviceConfigSpecFileOperation.create);
		 VirtualDisk vd = new VirtualDisk();
		 vd.setCapacityInKB(diskSizeKB);
		 diskSpec.setDevice(vd);
//		 vd.setKey(0);
//		 vd.setUnitNumber(0);
//		 vd.setControllerKey(cKey);
		 VirtualDiskFlatVer2BackingInfo diskfileBacking = new VirtualDiskFlatVer2BackingInfo();
//		 String fileName = "["+ dsName +"]";
//		 diskfileBacking.setFileName(fileName);
//		 diskmode :  persistent|`,independent_nonpersistent
		 diskfileBacking.setDiskMode("persistent");
		 diskfileBacking.setThinProvisioned(true);
		 vd.setBacking(diskfileBacking);
		 return diskSpec;
	 }

	/**
	 * 创建网卡配置信息
	 * @param netName 网络标签名称
	 * @return 网卡配置信息
	 */
	private VirtualDeviceConfigSpec createNicSpec(String netName) {
		  VirtualDeviceConfigSpec nicSpec = new VirtualDeviceConfigSpec();
		  nicSpec.setOperation(VirtualDeviceConfigSpecOperation.add);
		  VirtualEthernetCard nic =  new VirtualPCNet32();
		  VirtualEthernetCardNetworkBackingInfo nicBacking = new VirtualEthernetCardNetworkBackingInfo();
		  nicBacking.setDeviceName(netName);
		  //Description info = new Description();
		  //info.setLabel(nicName);
		  //info.setSummary(netName);
		  //nic.setDeviceInfo(info);
		  // type: "generated", "manual", "assigned" by VC
		  nic.setAddressType("generated");
		  nic.setBacking(nicBacking);
		  nic.setKey(0);
		  nicSpec.setDevice(nic);
		  return nicSpec;
	  }
	  
	  
	/**
	 * 创建CDROM配置文件
	 * @return CDROM配置文件
	 */
	private VirtualDeviceConfigSpec createCdromSpec() {
		VirtualDeviceConfigSpec cdromSpec = new VirtualDeviceConfigSpec();
		cdromSpec.setOperation(VirtualDeviceConfigSpecOperation.add);
		VirtualCdrom cdrom = new VirtualCdrom();
		//cdrom.setKey(cKey);
		cdromSpec.setDevice(cdrom);
		return cdromSpec;
	}
	
	/**
	 * 获取指定Host信息
	 * @param vcid vCenter配置ID
	 * @param hostName host名称
	 * @return Host信息
	 * @throws BLException
	 */
	public Host getHostInfo(Integer vcid,String hostName) throws BLException {
		//查询指定vCenter
		VIM01Info vcInfo = this.vim01BL.searchVIM01ByPK(vcid);
		Host host = null;
		ServiceInstance si = null;
		try {
			//获取连接实例
			si = getConnectInstance(vcInfo);
			//获取Host
			HostSystem entity = (HostSystem) new InventoryNavigator(si.getRootFolder()).searchManagedEntity("HostSystem", hostName);
			if(entity != null) {
				HostSystem info = (HostSystem)entity;
				HostHardwareInfo hardware = info.getHardware();
				//cpu
				int cpuCores = hardware.getCpuInfo().getNumCpuCores();
				int cpuHz = info.getSummary().getHardware().getCpuMhz();
				int cpuUsage = info.getSummary().getQuickStats().getOverallCpuUsage();
				//memory
				String memoryMB = String.format("%.2f", Double.parseDouble(String.valueOf(hardware.memorySize))/1024/1024);
				int memoryUsage = info.getSummary().getQuickStats().getOverallMemoryUsage();
				
				long capacityLong = 0;
				long freeSpaceLong = 0;
				Datastore[] datastores = info.getDatastores();
				for(Datastore datastore:datastores){
					DatastoreSummary datastoreSummary = datastore.getSummary();
					capacityLong += datastoreSummary.getCapacity();
					freeSpaceLong += datastoreSummary.getFreeSpace();
				}
				//硬盘
				String capacity = String.format("%.2f", Double.parseDouble(String.valueOf(capacityLong))/1024/1024/1024);
				//空闲硬盘
				String freeSpace = String.format("%.2f", Double.parseDouble(String.valueOf(freeSpaceLong))/1024/1024/1024);
				//连接状况
				String connectionState = info.getSummary().getRuntime().getConnectionState().name();
				
				int vm_powereOn_num = 0;
				int vm_powereOff_num = 0;
				int vm_num = 0;
				//虚机
				List<VMachine> vmsList = new ArrayList<VMachine>();
				VirtualMachine[] hvms = info.getVms();
				for(VirtualMachine hvm:hvms){
					if(!hvm.getConfig().isTemplate()){
						
						long vmCapacityLong = 0;
						String netLabels = "";
						VirtualDevice[] device = hvm.getConfig().hardware.getDevice();
						for (int s = 0; s < device.length; s++) {
							//检索硬盘
							if (device[s].getDeviceInfo().getLabel().indexOf("硬盘") != -1) {
								vmCapacityLong += Integer.parseInt(device[s].getDeviceInfo().getSummary().replace("KB", "").replace(",", "").trim());
							}else if(device[s].getDeviceInfo().getLabel().indexOf("网络适配器") != -1){
								netLabels += device[s].getDeviceInfo().getSummary()+",";
							}
						}
						if(netLabels.length()>0) netLabels = netLabels.substring(0,netLabels.length()-1);
						String vmCapacity = String.format("%.2f", Double.parseDouble(String.valueOf(vmCapacityLong))/1024/1024);

						VMachine vMachine = new VMachine();
						vMachine.setName(hvm.getName());
						vMachine.setCpuCores(hvm.getConfig().hardware.numCPU);
						vMachine.setMemoryMB(""+hvm.getConfig().hardware.memoryMB);
						vMachine.setCapacity(vmCapacity);
						vMachine.setNetLabels(netLabels);
						vMachine.setPowerState(hvm.getSummary().getRuntime().getPowerState().name());
						
						vmsList.add(vMachine);
						
						if("poweredOn".equals(hvm.getSummary().getRuntime().getPowerState().name())){
							vm_powereOn_num ++ ;
						}else{
							vm_powereOff_num ++ ;
						}
						vm_num ++;
					}
				}
				
				host = new Host();
				host.setName(entity.getName());
				host.setCpuCores(cpuCores);
				host.setCpuHz(cpuHz);
				host.setCpuUsage(cpuUsage);
				host.setMemoryMB(memoryMB);
				host.setMemoryUsage(memoryUsage);
				host.setCapacity(capacity);
				host.setFreeSpace(freeSpace);
				host.setConnectionState(connectionState);
				host.setVmsList(vmsList);
				host.setVm_powereOn_num(vm_powereOn_num);
				host.setVm_powereOff_num(vm_powereOff_num);
				host.setVm_num(vm_num);
			}
		} catch (Exception e) {
			log.error("", e);
			throw new BLException("IGCO10000.E140", "获取Host信息失败！");
		} finally {
			//关闭连接
			if(si != null) {
				si.getServerConnection().logout();
				si = null;
			}
		}
		return host;
	}

	/**
	 * 启动或关闭虚机
	 */
	public String oprateVM(Integer vcid, String hostName, String vmName,String oprateType) throws BLException {
		//查询指定vCenter
		VIM01Info vcInfo = this.vim01BL.searchVIM01ByPK(vcid);
		ServiceInstance si = null;
		String waitForTask = "";
		try {
			//获取连接实例
			si = getConnectInstance(vcInfo);
			//获取Host
			HostSystem entity = (HostSystem) new InventoryNavigator(si.getRootFolder()).searchManagedEntity("HostSystem", hostName);
			if(entity != null) {
				HostSystem host = (HostSystem)entity;
				VirtualMachine vm = (VirtualMachine) new InventoryNavigator(si.getRootFolder()).searchManagedEntity("VirtualMachine", vmName);
	            
				//启动虚机
				if("1".equals(oprateType)){
					Task powerOnVM_Task = vm.powerOnVM_Task(host);
					waitForTask = powerOnVM_Task.waitForTask();
				//关闭虚机
				}else if("2".equals(oprateType)){
					Task powerOffVM_Task = vm.powerOffVM_Task();
					waitForTask = powerOffVM_Task.waitForTask();
				}
				
				log.debug("虚机操作："+waitForTask);
			}
		}catch (Exception e) {
			if("1".equals(oprateType)) log.error("虚机启动异常",e);
			else if("2".equals(oprateType)) log.error("虚机关闭异常",e);
		}
		return waitForTask;
	}
	
	/**
     * 回收虚拟机
     * @param vcid 虚拟机连接ID
     * @param vmname 虚拟机名称
     * @param cloneProgressMonitor 创建进度线程
     * @return
     * @throws BLException
     */
    public String[] RecycleVM(Integer vcid,String vmname, CloneProgressMonitorBase cloneProgressMonitor) throws BLException{
    	 //查询指定vCenter
        VIM01Info vcInfo = this.vim01BL.searchVIM01ByPK(vcid);
    	
        ServiceInstance si = null;
        Object result[] = null;
        try {
          //获取连接实例
            si = getConnectInstance(vcInfo);
            Folder rootFolder = si.getRootFolder();
            ManagedEntity[] vms = new InventoryNavigator(rootFolder).searchManagedEntities(new String[][] { { "VirtualMachine","name" }, }, true);
            ManagedEntity vminfo = null;
            for (int i = 0; i < vms.length; i++) {
    		    VirtualMachine vm = (VirtualMachine) vms[i];
    			if (!vm.getConfig().template) {
    				if(vmname.equals(vms[i].getName())){
    					vminfo = vms[i];
    					break;
                    }
    			}
    		}
            if(vminfo != null){
            	Task task = vminfo.destroy_Task();
			    result = WaitForValues.waitForValues(si,task.getMOR(), new String[]{"info.state", "info.error", "info.progress"},
		                new String[]{"state"}, new Object[][]{new Object[]{TaskInfoState.success, TaskInfoState.error}});
		        // 修改虚机配置结果
		        if (result != null && result.length > 1 && result[0].equals(TaskInfoState.success)) {
		            if(null != cloneProgressMonitor){
		                cloneProgressMonitor.setSuccessed(true);
		            }
		        	return new String[]{"1", ""};
		        } else {
		        	//修改配置失败时删除VM
		        	LocalizedMethodFault msg = (LocalizedMethodFault)result[1];
		        	
		        	// 当创建失败时停止进度监控进程
		            if(null != cloneProgressMonitor){
		                cloneProgressMonitor.setError(true);
		            }
		        	return new String[]{"0", msg.localizedMessage};
		        }
            }
        } catch (Exception e) {
            log.debug("---------- 调整虚机配置异常 ---------");
            log.error("调整虚机配置异常", e);
        }
        return null;
	}
    
    /**
     * 关闭虚机
     * @param name
     * @throws BLException
     */
	public void poweredOffVM(Integer vcid, String name,String hostname) throws BLException{
		try{
		    VIM01Info vim01 = vim01BL.searchVIM01ByPK(vcid);
			ServiceInstance si = getConnectInstance(vim01);
			Folder folder = si.getRootFolder();
			VirtualMachine vm = (VirtualMachine) new InventoryNavigator(folder).searchManagedEntity("VirtualMachine", name);
			// 软关机方法依赖vmtools, 当vm没装tools时执行强制关机
			try {
			    vm.shutdownGuest();
            } catch (Exception e) {
                vm.powerOffVM_Task();
            }
		}catch (Exception e) {
			throw new BLException();
		}
	}
	
	/**
	 * 启动虚机
	 * @param name
	 * @throws BLException
	 */
	public void poweredOnVM(Integer vcid, String name,String hostname) throws BLException{
		try{
			VIM01Info vim01 = vim01BL.searchVIM01ByPK(vcid);
			ServiceInstance si = getConnectInstance(vim01);
			Folder folder = si.getRootFolder();
			InventoryNavigator navigator = new InventoryNavigator(folder);
			HostSystem info = (HostSystem) navigator.searchManagedEntity("HostSystem",hostname);
			VirtualMachine vm = (VirtualMachine) new InventoryNavigator(folder).searchManagedEntity("VirtualMachine", name);
			vm.powerOnVM_Task(info);
		}catch (Exception e) {
			throw new BLException();
		}
	}
}

