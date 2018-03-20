package org.oshopadma.customer.ws;

import org.oshopadma.customer.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ws")
public class FamilyResource {

    @RequestMapping(value="family/{familyId}", method = RequestMethod.GET, produces="application/json")
    public @ResponseBody User getFamily(@PathVariable long familyId) {
            System.out.println("cresting user");
             return new User();
         }

}