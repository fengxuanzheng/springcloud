package com.seataorderservice2001.uitll;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SnowFlakeAuto {

    private Long workeId=0L;
    private Long datacenter=1L;
    private Snowflake snowflake=new Snowflake(workeId,datacenter);

    public SnowFlakeAuto(Long workeId, Long datacenter, Snowflake snowflake) {
        this.workeId = workeId;
        this.datacenter = datacenter;
        this.snowflake = snowflake;
    }

    public SnowFlakeAuto() {
    }

   @PostConstruct
   public void init()
    {
        workeId= Long.valueOf(NetUtil.getLocalhostStr().hashCode());
    }
    public Long getSnowFlake()
    {
        long id = snowflake.nextId();
        System.out.println(snowflake.getWorkerId(id));
        System.out.println(workeId);
        return id;
    }
}
