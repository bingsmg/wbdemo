package live.clover.phasefour.demo2;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author weibb
 * @date 2023-10-11
 */
@Component
public class ArticleService {

    @Cacheable(cacheNames = {"cache1"})
    public List<String> list() {
        System.out.println("Get article list");
        return Arrays.asList("Spring", "MySQL", "Algorithm 4");
    }

    @Cacheable(cacheNames = {"cache1"}, key = "#root.target.class.name + '-' + #page + '-' + #pageSize")
    public String getPage(int page, int pageSize) {
        String msg = String.format("page-%s-pageSize-%s", page, pageSize);
        System.out.println("Get data from db: " + msg);
        return msg;
    }

    @Cacheable(cacheNames = "cache1", key = "'getById' + #id", condition = "#cache")
    public String getById(Long id, boolean cache) {
        System.out.println("Get data!");
        return "Spring cache:" + UUID.randomUUID().toString();
    }
}
