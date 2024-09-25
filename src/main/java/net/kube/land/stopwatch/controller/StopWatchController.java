package net.kube.land.stopwatch.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static net.kube.land.stopwatch.StopWatchApplication.LOCK;

@RestController
@RequestMapping("/stopwatch")
@CrossOrigin
public class StopWatchController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StopWatchController.class);

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> list() throws Exception {

        int number = 99;
        String responseString = objectMapper.writeValueAsString(number);

        return new ResponseEntity(responseString, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/{time}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> getCustomer(@PathVariable("time") Integer time) throws Exception {
        synchronized (LOCK) {
            System.out.println("StopWatch >>> " + (time - 1));
            Thread.sleep(1000);
            return new ResponseEntity(time - 1, HttpStatus.OK);
        }
    }
}
