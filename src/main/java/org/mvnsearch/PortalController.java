package org.mvnsearch;

import com.fizzed.rocker.RockerModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * portal controller
 *
 * @author linux_china
 */
@Controller
public class PortalController {

    @GetMapping(value = "/")
    @ResponseBody
    public RockerModel index() {
        return templates.Index.template("Welcome", "欢迎光临");
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }
}
