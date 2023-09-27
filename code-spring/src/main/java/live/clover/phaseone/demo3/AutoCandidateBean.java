package live.clover.phaseone.demo3;

import java.util.List;

/**
 * @author weibb
 * @date 2023-09-27
 */
public class AutoCandidateBean {

    private interface IService {}

    public static class ServiceA implements IService {}
    public static class ServiceB implements IService {}

    private IService service;
    private List<IService> serviceList;

    public void setService(IService service) {
        this.service = service;
    }

    public void setServiceList(List<IService> serviceList) {
        System.out.println(serviceList);
        this.serviceList = serviceList;
    }

    public List<IService> getServiceList() {
        return serviceList;
    }
}
