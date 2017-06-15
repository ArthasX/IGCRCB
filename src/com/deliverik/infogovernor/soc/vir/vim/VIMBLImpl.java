/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ����: VIMҵ���߼�ʵ��
 * ��������: VIMҵ���߼�ʵ��
 * ������¼:
 * �޸ļ�¼:
 */
public class VIMBLImpl extends BaseBLImpl implements VIMBL {
	
	static Log log = LogFactory.getLog(VIMBLImpl.class);
	
	/** vCenter����BL */
	protected VIM01BL vim01BL;
	
	/**
	 * vCenter����BL�趨
	 * @param vim01BL vCenter����BL
	 */
	public void setVim01BL(VIM01BL vim01BL) {
		this.vim01BL = vim01BL;
	}
	
	/**
	 * ��ȡvCenter����ʵ����������֤��Ϣ
	 * @param vcInfo vCenter������Ϣ
	 * @return ����ʵ��
	 * @throws Exception
	 */
	private ServiceInstance getConnectInstance(VIM01Info vcInfo) throws Exception {
		return new ServiceInstance(new URL("https://" + vcInfo.getVcurl() + "/sdk"),
				vcInfo.getVcusername(), vcInfo.getVcpassword(), true);//true��ʾ������֤
	}

	/**
	 * ��ȡģ���б�
	 * ģ���к��ж�Ӧ��vCenter������Ϣ��VM������Ϣ
	 * @param si vCenter����ʵ��
	 * @param vcInfo vCenter������Ϣ
	 * @return ģ���б�
	 * @throws Exception
	 */
	private List<Template> searchTemplate(ServiceInstance si, VIM01Info vcInfo) throws Exception {
		//����VM�б�
		ManagedEntity[] vms = new InventoryNavigator(si.getRootFolder()).searchManagedEntities(
				new String[][] { { "VirtualMachine","name" }, }, true);
		List<Template> lst_Template = new ArrayList<Template>();
		Template template = null;
		VirtualMachineConfigInfo config = null;
		if(vms != null) {
			for (ManagedEntity entity : vms) {
				//VM������Ϣ
				config = ((VirtualMachine) entity)
						.getConfig();
				if(config == null) {
					continue;
				}
				//�Ƿ�ΪVMģ��
				if(config.isTemplate()) {
					template = new Template();
					template.setName(entity.getName());
					template.setVcid(vcInfo.getVcid());
					template.setVcname(vcInfo.getVcname());
					template.setNumCPU(config.hardware.getNumCPU());
					template.setMemoryGB(config.hardware.getMemoryMB() / 1024);
					//��ȡ�豸�б�
					VirtualDevice[] device = config.hardware.device;
					for (int s = 0; s < device.length; s++) {
						//����Ӳ��
						if (device[s].getDeviceInfo().getLabel().indexOf("Ӳ��") != -1) {
							template.setDiskGB(Integer.parseInt(device[s].getDeviceInfo().getSummary()
									.replace("KB", "").replace(",", "").trim()) / 1024 / 1024);
							break;//ֻ��ʾ��1��Ӳ��
						}
					}
					lst_Template.add(template);
				}
			}
		}
		return lst_Template;
	}

	/**
	 * ��ȡ����vCenter��ģ���б�
	 * @return ģ���б�
	 * @throws BLException
	 */
	public List<Template> searchTemplate() throws BLException {
		//��ѯvCenter���ñ�
		List<VIM01Info> lst_VIM01Info = this.vim01BL.searchVIM01(new VIM01SearchCondImpl());
		List<Template> lst_Template = new ArrayList<Template>();
		//����������vCenter
		for(VIM01Info vcInfo : lst_VIM01Info) {
			ServiceInstance si = null;
			try {
				//��ȡ����ʵ��
				si = getConnectInstance(vcInfo);
				//��ȡģ��
				lst_Template.addAll(searchTemplate(si, vcInfo));
			} catch (Exception e) {
				log.error("", e);
				throw new BLException("IGCO10000.E140", "��ȡ" + vcInfo.getVcname() + "���ģ��ʧ�ܣ�");
			} finally {
				//�ر�����
				if(si != null) {
					si.getServerConnection().logout();
					si = null;
				}
			}
		}
		return lst_Template;
	}
	
	/**
	 * ��ȡָ��vCenter�����������б�
	 * @param vcid vCenter����ID
	 * @return ���������б�
	 * @throws BLException
	 */
	public List<Data_Center> searchDatacenterByVcid(Integer vcid) throws BLException {
		//��ѯָ��vCenter
		VIM01Info vcInfo = this.vim01BL.searchVIM01ByPK(vcid);
		List<Data_Center> lst_Datacenter = new ArrayList<Data_Center>();
		Data_Center datacenter = null;
		ServiceInstance si = null;
		try {
			//��ȡ����ʵ��
			si = getConnectInstance(vcInfo);
			//��ȡDatacenter
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
			throw new BLException("IGCO10000.E140", "��ȡDatacenterʧ�ܣ�");
		} finally {
			//�ر�����
			if(si != null) {
				si.getServerConnection().logout();
				si = null;
			}
		}
		return lst_Datacenter;
	}
	
	/**
	 * ��ȡָ��vCenter����Դ���б�
	 * @param vcid vCenter����ID
	 * @return ��Դ���б�
	 * @throws BLException
	 */
	public List<Resource_Pool> searchResourcePoolByVcid(Integer vcid) throws BLException {
		//��ѯָ��vCenter
		VIM01Info vcInfo = this.vim01BL.searchVIM01ByPK(vcid);
		List<Resource_Pool> lst_ResourcePool = new ArrayList<Resource_Pool>();
		Resource_Pool resourcePool = null;
		ServiceInstance si = null;
		try {
			//��ȡ����ʵ��
			si = getConnectInstance(vcInfo);
			//��ȡResourcePool
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
			throw new BLException("IGCO10000.E140", "��ȡResourcePoolʧ�ܣ�");
		} finally {
			//�ر�����
			if(si != null) {
				si.getServerConnection().logout();
				si = null;
			}
		}
		return lst_ResourcePool;
	}
	
	/**
	 * ��ȡָ��vCenter������
	 * @param vcid vCenter����ID
	 * @return �����б�
	 * @throws BLException
	 */
	public List<Host> searchHostByVcid(Integer vcid) throws BLException {
		//��ѯָ��vCenter
		VIM01Info vcInfo = this.vim01BL.searchVIM01ByPK(vcid);
		List<Host> lst_Host = new ArrayList<Host>();
		Host host = null;
		ServiceInstance si = null;
		try {
			//��ȡ����ʵ��
			si = getConnectInstance(vcInfo);
			//��ȡHost
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
						//Ӳ��
						String capacity = String.format("%.2f", Double.parseDouble(String.valueOf(capacityLong))/1024/1024/1024);
						//����Ӳ��
						String freeSpace = String.format("%.2f", Double.parseDouble(String.valueOf(freeSpaceLong))/1024/1024/1024);
						//����״��
						String connectionState = info.getSummary().getRuntime().getConnectionState().name();
						
						int vm_powereOn_num = 0;
						int vm_powereOff_num = 0;
						int vm_num = 0;
						//���
						List<VMachine> vmsList = new ArrayList<VMachine>();
						VirtualMachine[] hvms = info.getVms();
						for(VirtualMachine hvm:hvms){
							if(!hvm.getConfig().isTemplate()){
								
								int vmCapacityLong = 0;
								int hvmfreeSpaceLong = 0;
								String netLabels = "";
								VirtualDevice[] device = hvm.getConfig().hardware.getDevice();
								for (int s = 0; s < device.length; s++) {
									//����Ӳ��
									if (device[s].getDeviceInfo().getLabel().indexOf("Ӳ��") != -1) {
										vmCapacityLong += Integer.parseInt(device[s].getDeviceInfo().getSummary().replace("KB", "").replace(",", "").trim());
									}else if(device[s].getDeviceInfo().getLabel().indexOf("����������") != -1){
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
			throw new BLException("IGCO10000.E140", "��ȡHostʧ�ܣ�");
		} finally {
			//�ر�����
			if(si != null) {
				si.getServerConnection().logout();
				si = null;
			}
		}
		return lst_Host;
	}

	/**
	 * ��ȡָ�������������ǩ
	 * @param vcid vCenter����ID
	 * @param hostip ����IP
	 * @return �����ǩ�б�
	 * @throws BLException
	 */
	public List<NetLabel> searchNetLabelByHost(Integer vcid, String hostip) throws BLException {
		//��ѯָ��vCenter
		VIM01Info vcInfo = this.vim01BL.searchVIM01ByPK(vcid);
		List<NetLabel> lst_NetLabel = new ArrayList<NetLabel>();
		NetLabel netLabel = null;
		ServiceInstance si = null;
		try {
			//��ȡ����ʵ��
			si = getConnectInstance(vcInfo);
			//��ȡHost
			HostSystem host = (HostSystem) new InventoryNavigator(si.getRootFolder()).searchManagedEntity("HostSystem", hostip);
			HostNetworkSystem hns = host.getHostNetworkSystem();
			HostNetworkInfo nwi = hns.getNetworkInfo();
			HostVirtualSwitch[] vswitch = nwi.getVswitch();
			if(vswitch != null) {
				//�������⽻����
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
			throw new BLException("IGCO10000.E140", "��ȡ�����ǩʧ�ܣ�");
		} finally {
			//�ر�����
			if(si != null) {
				si.getServerConnection().logout();
				si = null;
			}
		}
		return lst_NetLabel;
	}
	
	/**
	 * ��ȡָ��Datacenter�������ǩ
	 * @param vcid vCenter����ID
	 * @param dcanem ������������
	 * @return �����ǩ�б�
	 * @throws BLException
	 */
	public List<NetLabel> searchNetLabelByDatacenter(Integer vcid, String dcname) throws BLException {
	    //��ѯָ��vCenter
	    VIM01Info vcInfo = this.vim01BL.searchVIM01ByPK(vcid);
	    List<NetLabel> lst_NetLabel = new ArrayList<NetLabel>();
	    NetLabel netLabel = null;
	    ServiceInstance si = null;
	    try {
	        //��ȡ����ʵ��
	        si = getConnectInstance(vcInfo);
	        //��ȡHost
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
	        throw new BLException("IGCO10000.E140", "��ȡ�����ǩʧ�ܣ�");
	    } finally {
	        //�ر�����
	        if(si != null) {
	            si.getServerConnection().logout();
	            si = null;
	        }
	    }
	    return lst_NetLabel;
	}
	
	/**
	 * ͨ��ָ��ģ�渴��VM
	 * ��rpNameΪ��ʱ��Ĭ��ΪResources
	 * @param si vCenter����ʵ�� 
	 * @param cloneName ��VM����
	 * @param dcName ������������
	 * @param rpName ��Դ������
	 * @return ���س���Ϊ2������,[0]ֵ��0ʧ�ܣ�1�ɹ�;[1]ֵ��������Ϣ
	 * @throws BLException
	 */
	public String[] cloneVMFromTemplate(Template template, String cloneName, String dcName, String rpName, CloneProgressMonitorBase cloneProgressMonitor) throws BLException {
	    System.out.println(template.toString());
	    
		//��ѯָ��vCenter
		VIM01Info vcInfo = this.vim01BL.searchVIM01ByPK(template.getVcid());
		ServiceInstance si = null;
		Object[] result = null;
		try {
			//��ȡ����ʵ��
			si = getConnectInstance(vcInfo);
			//��ȡģ��
			VirtualMachine vm = (VirtualMachine) new InventoryNavigator(si.getRootFolder())
				.searchManagedEntity("VirtualMachine", template.getName());
			//����ResourcePool��Ĭ��ΪResources
			if(StringUtils.isEmpty(rpName)) {
				rpName = "Resources";
			}
			ResourcePool rp = (ResourcePool) new InventoryNavigator(si.getRootFolder())
				.searchManagedEntity("ResourcePool", rpName);
			//����Datacenter
			Datacenter dc = ((Datacenter) si.getSearchIndex()
					.findByInventoryPath(dcName));
			//��ȡ���λ��
			Folder vmFolder = dc.getVmFolder();
			//VMclone��Ϣ
			VirtualMachineCloneSpec cloneSpec = new VirtualMachineCloneSpec();
			//VMǨ����Ϣ
			VirtualMachineRelocateSpec vmrSpec = new VirtualMachineRelocateSpec();
			//�趨��Դ��
			vmrSpec.setPool(rp.getMOR());
			//Ĭ�Ϲػ�
			cloneSpec.setPowerOn(false);
			//���Ͳ���ģ��
			cloneSpec.setTemplate(false);
			
//			//VM������Ϣ
//	        VirtualMachineConfigSpec vmConfigSpec = new VirtualMachineConfigSpec();
//	        //�ڴ�
//	        vmConfigSpec.memoryMB = template.getMemoryGB() * 1024L;
//	        //CPU
//	        vmConfigSpec.numCPUs = template.getNumCPU();
//	        cloneSpec.config = vmConfigSpec;
	        
	        cloneSpec.setLocation(vmrSpec);
	        Task task = vm.cloneVM_Task(vmFolder, cloneName, cloneSpec);
	        
	        // �����ȼ�ض���Ϊ��ʱ�������ȼ��
	        if(null != cloneProgressMonitor){
	            cloneProgressMonitor.setTask(task);
	            cloneProgressMonitor.start();
	        }
	        
	        result = WaitForValues.waitForValues(si,task.getMOR(), new String[]{"info.state", "info.error", "info.progress"},
		            new String[]{"state"},
		            new Object[][]{new Object[]{TaskInfoState.success, TaskInfoState.error}});
	        // ��¡������ؽ��
	        // ����¡�ɹ����޸��������
	        if (result != null && result.length > 1 && result[0].equals(TaskInfoState.success)) {
	        	return reconfigVM(si, template, cloneName, cloneProgressMonitor);
	        } else {
	        	LocalizedMethodFault msg = (LocalizedMethodFault)result[1];
	        	
	        	// ������ʧ��ʱֹͣ���ȼ�ؽ���
	        	if(null != cloneProgressMonitor){
	        	    cloneProgressMonitor.setError(true);
	        	}
	        	return new String[]{"0", msg.localizedMessage};
	        }
		} catch (Exception e) {
			log.error("", e);
			// ������ʧ��ʱֹͣ���ȼ�ؽ���
            if(null != cloneProgressMonitor){
                cloneProgressMonitor.setError(true);
            }
			return new String[]{"0", "����ģ��ʧ�ܣ�"};
		} finally {
			//�ر�����
			if(si != null) {
				si.getServerConnection().logout();
				si = null;
			}
		}
	}

	/**
     * ͨ��ָ��ģ�渴�Ƶ���VM����
     * ��rpNameΪ��ʱ��Ĭ��ΪResources
     * @param vmName VM����
     * @return ���س���Ϊ2������,[0]ֵ��0ʧ�ܣ�1�ɹ�;[1]ֵ��������Ϣ
     * @throws BLException
     */
    public String[] reconfigVM(Template template, String vmName, CloneProgressMonitorBase cloneProgressMonitor) throws BLException {
        System.out.println(template.toString());
        
        //��ѯָ��vCenter
        VIM01Info vcInfo = this.vim01BL.searchVIM01ByPK(template.getVcid());
        ServiceInstance si = null;
        String result[] = null;
        try {
          //��ȡ����ʵ��
            si = getConnectInstance(vcInfo);
            result = reconfigVM(si, template, vmName, cloneProgressMonitor);
        } catch (Exception e) {
            log.debug("---------- ������������쳣 ---------");
            log.error("������������쳣", e);
        }
        
        return result;
        
    }	
    
	/**
	 * �޸�������� 
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
        //�޸�VM����
        VirtualMachine newVM = (VirtualMachine) new InventoryNavigator(si.getRootFolder()).searchManagedEntity("VirtualMachine", vmName);
        VirtualMachineConfigSpec reConfigSpec = getReConfigSpec(newVM, template);
        task = newVM.reconfigVM_Task(reConfigSpec);
        
        result = WaitForValues.waitForValues(si,task.getMOR(), new String[]{"info.state", "info.error", "info.progress"},
                new String[]{"state"}, new Object[][]{new Object[]{TaskInfoState.success, TaskInfoState.error}});
        // �޸�������ý��
        if (result != null && result.length > 1 && result[0].equals(TaskInfoState.success)) {
            if(null != cloneProgressMonitor){
                cloneProgressMonitor.setSuccessed(true);
            }
        	return new String[]{"1", ""};
        } else {
        	//�޸�����ʧ��ʱɾ��VM
        	newVM.unregisterVM();
        	LocalizedMethodFault msg = (LocalizedMethodFault)result[1];
        	
        	// ������ʧ��ʱֹͣ���ȼ�ؽ���
            if(null != cloneProgressMonitor){
                cloneProgressMonitor.setError(true);
            }
        	return new String[]{"0", msg.localizedMessage};
        }
    }
    
	/**
	 * ������Ҫ���µ�������Ϣ
	 * @param vm VM
	 * @param template ģ��
	 * @return ���µ�������Ϣ
	 */
	private VirtualMachineConfigSpec getReConfigSpec(VirtualMachine vm, Template template) {
		//�豸�б�
		VirtualDevice [] vds = vm.getConfig().getHardware().getDevice();
		VirtualDisk disk = null;
		VirtualEthernetCard nic = null;
		for(VirtualDevice device : vds) {
			//���ҵ�1��Ӳ��
			if(disk == null && device.getDeviceInfo().getLabel().indexOf("Ӳ��") > -1) {
				disk = (VirtualDisk)device;
				continue;
			}
			//���ҵ�1������
			if(nic == null && device.getDeviceInfo().getLabel().indexOf("����������") > -1) {
				nic = (VirtualEthernetCard)device;
				continue;
			}
		}
		//VM������Ϣ
		VirtualMachineConfigSpec vmConfigSpec = new VirtualMachineConfigSpec();
		//Ӳ��������Ϣ
		VirtualDeviceConfigSpec diskSpec = new VirtualDeviceConfigSpec(); 
		diskSpec.operation = VirtualDeviceConfigSpecOperation.edit;
		disk.capacityInKB = template.getDiskGB() * 1024*1024L;
		diskSpec.device = disk;
		// �ڴ�������Ϣ
        vmConfigSpec.memoryMB = template.getMemoryGB() * 1024L;
        // CPU������Ϣ
        vmConfigSpec.numCPUs = template.getNumCPU();

        //����������Ϣ
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
	 * ͨ��ָ��ģ�渴��VM
	 * ��rpNameΪ��ʱ��Ĭ��ΪResources
	 * @param si vCenter����ʵ�� 
	 * @param cloneName ��VM����
	 * @param dcName ������������
	 * @param rpName ��Դ������
	 * @return ���س���Ϊ2������,[0]ֵ��0ʧ�ܣ�1�ɹ�;[1]ֵ��������Ϣ
	 * @throws BLException
	 */
	public String[] createVM(Template template, String cloneName, String dcName, String rpName) throws BLException {
		//��ѯָ��vCenter
		VIM01Info vcInfo = this.vim01BL.searchVIM01ByPK(template.getVcid());
		ServiceInstance si = null;
		Object[] result = null;
		try {
			//��ȡ����ʵ��
			si = getConnectInstance(vcInfo);
			//����ResourcePool��Ĭ��ΪResources
			if(StringUtils.isEmpty(rpName)) {
				rpName = "Resources";
			}
			ResourcePool rp = (ResourcePool) new InventoryNavigator(si.getRootFolder())
				.searchManagedEntity("ResourcePool", rpName);
			//����Datacenter
			Datacenter dc = ((Datacenter) si.getSearchIndex()
					.findByInventoryPath(dcName));
			Folder vmFolder = dc.getVmFolder();
			//����VM�����ļ�
			VirtualMachineConfigSpec vmSpec = new VirtualMachineConfigSpec();
			vmSpec.setName(cloneName);
			vmSpec.setAnnotation("VirtualMachine Annotation");
			vmSpec.setMemoryMB(template.getMemoryGB() * 1024L);
			vmSpec.setNumCPUs(template.getNumCPU());
			//vmSpec.setGuestId(guestOsId);
			//�����豸
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
	        //���ؽ��
	        if (result != null && result.length > 1 && result[0].equals(TaskInfoState.success)) {
	 	        return new String[]{"1", ""};
	 	    } else {
	        	LocalizedMethodFault msg = (LocalizedMethodFault)result[1];
	        	return new String[]{"0", msg.localizedMessage};
	        }
		} catch (Exception e) {
			log.error("", e);
			return new String[]{"0", "����VMʧ��"};
		} finally {
			//�ر�����
			if(si != null) {
				si.getServerConnection().logout();
				si = null;
			}
		}
	}

	/**
	 * ����������������Ϣ
	 * @return ������������Ϣ
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
	  * ����Ӳ��������Ϣ
	 * @param dsName ��������
	 * @param diskSizeKB Ӳ�̴�С
	 * @return Ӳ��������Ϣ
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
	 * ��������������Ϣ
	 * @param netName �����ǩ����
	 * @return ����������Ϣ
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
	 * ����CDROM�����ļ�
	 * @return CDROM�����ļ�
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
	 * ��ȡָ��Host��Ϣ
	 * @param vcid vCenter����ID
	 * @param hostName host����
	 * @return Host��Ϣ
	 * @throws BLException
	 */
	public Host getHostInfo(Integer vcid,String hostName) throws BLException {
		//��ѯָ��vCenter
		VIM01Info vcInfo = this.vim01BL.searchVIM01ByPK(vcid);
		Host host = null;
		ServiceInstance si = null;
		try {
			//��ȡ����ʵ��
			si = getConnectInstance(vcInfo);
			//��ȡHost
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
				//Ӳ��
				String capacity = String.format("%.2f", Double.parseDouble(String.valueOf(capacityLong))/1024/1024/1024);
				//����Ӳ��
				String freeSpace = String.format("%.2f", Double.parseDouble(String.valueOf(freeSpaceLong))/1024/1024/1024);
				//����״��
				String connectionState = info.getSummary().getRuntime().getConnectionState().name();
				
				int vm_powereOn_num = 0;
				int vm_powereOff_num = 0;
				int vm_num = 0;
				//���
				List<VMachine> vmsList = new ArrayList<VMachine>();
				VirtualMachine[] hvms = info.getVms();
				for(VirtualMachine hvm:hvms){
					if(!hvm.getConfig().isTemplate()){
						
						long vmCapacityLong = 0;
						String netLabels = "";
						VirtualDevice[] device = hvm.getConfig().hardware.getDevice();
						for (int s = 0; s < device.length; s++) {
							//����Ӳ��
							if (device[s].getDeviceInfo().getLabel().indexOf("Ӳ��") != -1) {
								vmCapacityLong += Integer.parseInt(device[s].getDeviceInfo().getSummary().replace("KB", "").replace(",", "").trim());
							}else if(device[s].getDeviceInfo().getLabel().indexOf("����������") != -1){
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
			throw new BLException("IGCO10000.E140", "��ȡHost��Ϣʧ�ܣ�");
		} finally {
			//�ر�����
			if(si != null) {
				si.getServerConnection().logout();
				si = null;
			}
		}
		return host;
	}

	/**
	 * ������ر����
	 */
	public String oprateVM(Integer vcid, String hostName, String vmName,String oprateType) throws BLException {
		//��ѯָ��vCenter
		VIM01Info vcInfo = this.vim01BL.searchVIM01ByPK(vcid);
		ServiceInstance si = null;
		String waitForTask = "";
		try {
			//��ȡ����ʵ��
			si = getConnectInstance(vcInfo);
			//��ȡHost
			HostSystem entity = (HostSystem) new InventoryNavigator(si.getRootFolder()).searchManagedEntity("HostSystem", hostName);
			if(entity != null) {
				HostSystem host = (HostSystem)entity;
				VirtualMachine vm = (VirtualMachine) new InventoryNavigator(si.getRootFolder()).searchManagedEntity("VirtualMachine", vmName);
	            
				//�������
				if("1".equals(oprateType)){
					Task powerOnVM_Task = vm.powerOnVM_Task(host);
					waitForTask = powerOnVM_Task.waitForTask();
				//�ر����
				}else if("2".equals(oprateType)){
					Task powerOffVM_Task = vm.powerOffVM_Task();
					waitForTask = powerOffVM_Task.waitForTask();
				}
				
				log.debug("���������"+waitForTask);
			}
		}catch (Exception e) {
			if("1".equals(oprateType)) log.error("��������쳣",e);
			else if("2".equals(oprateType)) log.error("����ر��쳣",e);
		}
		return waitForTask;
	}
	
	/**
     * ���������
     * @param vcid ���������ID
     * @param vmname ���������
     * @param cloneProgressMonitor ���������߳�
     * @return
     * @throws BLException
     */
    public String[] RecycleVM(Integer vcid,String vmname, CloneProgressMonitorBase cloneProgressMonitor) throws BLException{
    	 //��ѯָ��vCenter
        VIM01Info vcInfo = this.vim01BL.searchVIM01ByPK(vcid);
    	
        ServiceInstance si = null;
        Object result[] = null;
        try {
          //��ȡ����ʵ��
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
		        // �޸�������ý��
		        if (result != null && result.length > 1 && result[0].equals(TaskInfoState.success)) {
		            if(null != cloneProgressMonitor){
		                cloneProgressMonitor.setSuccessed(true);
		            }
		        	return new String[]{"1", ""};
		        } else {
		        	//�޸�����ʧ��ʱɾ��VM
		        	LocalizedMethodFault msg = (LocalizedMethodFault)result[1];
		        	
		        	// ������ʧ��ʱֹͣ���ȼ�ؽ���
		            if(null != cloneProgressMonitor){
		                cloneProgressMonitor.setError(true);
		            }
		        	return new String[]{"0", msg.localizedMessage};
		        }
            }
        } catch (Exception e) {
            log.debug("---------- ������������쳣 ---------");
            log.error("������������쳣", e);
        }
        return null;
	}
    
    /**
     * �ر����
     * @param name
     * @throws BLException
     */
	public void poweredOffVM(Integer vcid, String name,String hostname) throws BLException{
		try{
		    VIM01Info vim01 = vim01BL.searchVIM01ByPK(vcid);
			ServiceInstance si = getConnectInstance(vim01);
			Folder folder = si.getRootFolder();
			VirtualMachine vm = (VirtualMachine) new InventoryNavigator(folder).searchManagedEntity("VirtualMachine", name);
			// ��ػ���������vmtools, ��vmûװtoolsʱִ��ǿ�ƹػ�
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
	 * �������
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

