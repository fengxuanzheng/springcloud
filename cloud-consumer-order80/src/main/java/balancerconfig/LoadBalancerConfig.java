package balancerconfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadBalancerConfig {

  /*  @Bean
    public RandomLoadBalancer randomLoadBalancer(ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider)
    {
        log.info(serviceInstanceListSupplierProvider.getClass().toString());
        return new RandomLoadBalancer(serviceInstanceListSupplierProvider,"CLOUD-PROVIDER-PAYMENT");
    }*/

  /*  @Bean
    public RandomRule randomRule()
    {
      return   new RandomRule();
    }*/
}
