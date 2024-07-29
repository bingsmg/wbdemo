package live.clover.threadpool;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.Stream;

/**
 * @author weibb
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) throws InterruptedException {

        // main线程启动子线程，子线程的创造来自Executors.defaultThreadFactory()
        ExecutorService executorService = Executors.newCachedThreadPool();
        Set<Thread> threadsContainer = new HashSet<>();
        setThreadFactory(executorService, threadsContainer);
        for (int i = 0; i < 5; i++) {
            executorService.execute(() -> {});
        }
        executorService.awaitTermination(3, TimeUnit.MILLISECONDS);
        threadsContainer.stream()
                .filter(Thread::isAlive)
                .forEach(thread -> System.out.println("方法1:线程池中的线程：" + thread));
        //方法二：
        Thread mainThread = Thread.currentThread();
        ThreadGroup mainThreadThreadGroup = mainThread.getThreadGroup();
        //获取线程组中的线程。
        int count = mainThreadThreadGroup.activeCount();
        System.out.println("count:"+count);
        Thread[] threads = new Thread[count];
        //enumerate 枚举，recurse 递归
        mainThreadThreadGroup.enumerate(threads, true);
        Stream.of(threads).filter(Thread::isAlive).forEach(thread -> System.out.println("方法2：线程池的线程：" + thread ));

        //关闭线程池
        executorService.shutdown();
    }

    private static void setThreadFactory(ExecutorService executorService, Set<Thread> threadsContainer) throws InterruptedException {
        if (executorService instanceof ThreadPoolExecutor) {
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
            ThreadFactory oldThreadFactory = threadPoolExecutor.getThreadFactory();
            threadPoolExecutor.setThreadFactory(new MyThreadFactory(oldThreadFactory, threadsContainer));
        }
    }

    private static class MyThreadFactory implements ThreadFactory {
        private final ThreadFactory threadFactory;
        private final Set<Thread> threadsContainer;

        public MyThreadFactory(ThreadFactory threadFactory, Set<Thread> threadsContainer) {
            this.threadFactory = threadFactory;
            this.threadsContainer = threadsContainer;
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = threadFactory.newThread(r);
            threadsContainer.add(thread);
            // 删除不存活的线程
//            threadsContainer.removeIf(next -> !next.isAlive());
            return thread;
        }
    }
}
