package test;

import com.alibaba.fastjson.JSON;
import com.cloudapicommons.frontResultData.CommonResult;
import org.junit.jupiter.api.Test;

public class PublictTest {

    @Test
    public void test()
    {
        CommonResult<String> result = new CommonResult<>(500, "全局默认自定义处理");
         String s = JSON.toJSONString(result);
        System.out.println(s);
    }

    @Test
    public void test2()
    {
        try {
          // int i=10/0;
            System.out.println("第一步");
            try {
                System.out.println("第二步");
                int b=10/0;
            }catch (Exception e)
            {
                System.out.println("第二步异常");
                System.out.println(e.getMessage());
                //throw e;
            }
            finally {
                System.out.println("第二步最终执行");
            }
        }
        catch (Exception e)
        {
            System.out.println(" 第一步异常");
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("第一步最终执行");
        }
    }
    @Test
    public void  test3()
    {

        String property =System.getProperty("user.home") + "/sentinel/rules";
        System.out.println(property);
    }
}
