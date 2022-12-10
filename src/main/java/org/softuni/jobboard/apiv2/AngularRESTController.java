package org.softuni.jobboard.apiv2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
public class AngularRESTController {

    @GetMapping
    public String api(){
        return "<html><body><h1>Hello from new API</h1></body></html>";
    }
}
