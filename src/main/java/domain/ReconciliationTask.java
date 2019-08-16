package domain;

import java.time.LocalDateTime;

/**
 * @Classname ReconciliationTask
 * @Description TODO
 * @Date 2019/8/16 17:20
 * @Author lyn
 */
public class ReconciliationTask implements Runnable {
    @Override
    public void run() {
        System.out.println(LocalDateTime.now() +" "+Thread.currentThread().getName());
    }
}
