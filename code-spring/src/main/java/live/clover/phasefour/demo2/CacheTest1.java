package live.clover.phasefour.demo2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author weibb
 * @date 2023-10-11
 */
public class CacheTest1 {

    private ArticleService articleService;
    private AnnotationConfigApplicationContext context;

    @BeforeEach
    public void setUp() {
        context = new AnnotationConfigApplicationContext();
        context.register(MainConfig1.class);
        context.refresh();
        articleService = context.getBean(ArticleService.class);
    }

    @Test
    public void test1() {
        System.out.println(articleService.list());
        System.out.println(articleService.list());
    }

    @Test
    public void test2() {
        System.out.println(articleService.getPage(1, 10));
        System.out.println(articleService.getPage(1, 10));

        System.out.println(articleService.getPage(2, 10));
        System.out.println(articleService.getPage(2, 10));

        {
            System.out.println("print the key list of cache1");
            ConcurrentMapCacheManager cacheManager = context.getBean(ConcurrentMapCacheManager.class);
            ConcurrentMapCache cache1 = (ConcurrentMapCache) cacheManager.getCache("cache1");
            assert cache1 != null;
            cache1.getNativeCache().keySet().forEach(System.out::println);
        }
    }

    @Test
    public void test3() {
        System.out.println(articleService.getById(1L, true));
        System.out.println(articleService.getById(1L, true));
        System.out.println(articleService.getById(1L, false));
        System.out.println(articleService.getById(1L, true));
    }
}
