package com.bee.eshop.utils;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

/**
 * Created by Matt on 10.09.2018 at 19:34.
 */

@Component
public class OnInitBean {

    @PostConstruct
    public void onInit() {
        LoggingService.logMessage("On init bean created!");
    }
}
