package live.clover.demo2;

/**
 * @author weibb
 * @date 2023-09-26
 */
public class DiAutowireByType {

    private Service1 service1;
    private Service2 service2;

    @Override
    public String toString() {
        return "DiAutowireByType{" +
                "service1=" + service1 +
                ", service2=" + service2 +
                '}';
    }

    public Service1 getService1() {
        return service1;
    }

    public void setService1(Service1 service1) {
        System.out.println("setService1 ->" + service1);
        this.service1 = service1;
    }

    public Service2 getService2() {
        return service2;
    }

    public void setService2(Service2 service2) {
        System.out.println("setService2 ->" + service2);
        this.service2 = service2;
    }

    public static class Service1 {
        private String desc;

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        @Override
        public String toString() {
            return "Service1{" +
                    "desc='" + desc + '\'' +
                    '}';
        }
    }

    public static class Service2 {
        private String desc;

        @Override
        public String toString() {
            return "Service2{" +
                    "desc='" + desc + '\'' +
                    '}';
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
