package lk.dinuka.springfour.employeeservice.hystrix;

import lk.dinuka.springfour.employeeservice.model.Allocation;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AllocationCommand extends HystrixCommand<Allocation[]> {
    Integer employee_id;
    HttpHeaders httpHeaders;
    RestTemplate restTemplate;

    public AllocationCommand(Integer employee_id, HttpHeaders httpHeaders, RestTemplate restTemplate) {
        super(HystrixCommandGroupKey.Factory.asKey("default"));
        this.employee_id = employee_id;
        this.httpHeaders = httpHeaders;
        this.restTemplate = restTemplate;
    }

    @Override
    protected Allocation[] run() throws Exception {

            ResponseEntity<Allocation[]> responseEntity;
            HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);
            responseEntity = restTemplate.exchange("http://allocation/allocations/findByEmployee/" + employee_id, HttpMethod.GET, httpEntity, Allocation[].class);
            return responseEntity.getBody();
    }

    @Override
    protected Allocation[] getFallback() {
        return new Allocation[0];
    }
}
