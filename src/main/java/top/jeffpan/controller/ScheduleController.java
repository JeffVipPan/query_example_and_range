package top.jeffpan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.jeffpan.schedulerdemo.ScheduledTasks;

/**
 * @author 潘峰
 * @date 2017/11/28 下午3:34
 */

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    ScheduledTasks scheduledTasks = new ScheduledTasks();


    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    public void printTask() {
        log.info("Hello World!");
    }


    public void longTimeTask() {
        log.info("Long time task start.");
        for (int n = Integer.MIN_VALUE; n < Integer.MAX_VALUE / 1; n++) {
            Math.sin(n);
        }
        log.info("Long time task finish.");
    }


}
