package com.surfilter.lyc.springJava;

import com.surfilter.lyc.springJava.bm.SmallCDPlayer;
import com.surfilter.lyc.springJava.bm.concert.Performance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 使用spring的SpringJUnit4ClassRunner自动创建spring应用上下文（等效于SpringContextMain）
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextConfig.class)
public class SpringContextMainTest {
    @Autowired
    SmallCDPlayer smallCDPlayer;
    @Autowired
    Performance performance;
    @Test
    public void beginPlay(){
        smallCDPlayer.playAuto("cdAutoTest");
    }
    @Test
    public void beginPerformance(){
        performance.perform();
    }
}
