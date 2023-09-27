package live.clover.phaseone.demo2;

import java.util.List;
import java.util.Map;

/**
 * @author weibb
 * @date 2023-09-27
 */
public class DiAutowireByTypeExtend {

    public interface IService {}

    public static class BaseService {
        private String desc;

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }

        @Override
        public String toString() {
            return "BaseService{" +
                    "desc='" + desc + '\'' +
                    '}';
        }
    }

    public static class Service1 extends BaseService implements IService {}

    public static class Service2 extends BaseService implements IService {}

    private List<IService> serviceList;
    private List<BaseService> baseServiceList;
    private Map<String, IService> serviceMap;
    private Map<String, BaseService> baseServiceMap;

    public List<IService> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<IService> serviceList) {
        this.serviceList = serviceList;
    }

    public List<BaseService> getBaseServiceList() {
        return baseServiceList;
    }

    public void setBaseServiceList(List<BaseService> baseServiceList) {
        this.baseServiceList = baseServiceList;
    }

    public Map<String, IService> getServiceMap() {
        return serviceMap;
    }

    public void setServiceMap(Map<String, IService> serviceMap) {
        this.serviceMap = serviceMap;
    }

    public Map<String, BaseService> getBaseServiceMap() {
        return baseServiceMap;
    }

    public void setBaseServiceMap(Map<String, BaseService> baseServiceMap) {
        this.baseServiceMap = baseServiceMap;
    }

    @Override
    public String toString() {
        return "DiAutowireByTypeExtend{" +
                "serviceList=" + serviceList +
                ", baseServiceList=" + baseServiceList +
                ", serviceMap=" + serviceMap +
                ", baseServiceMap=" + baseServiceMap +
                '}';
    }
}
