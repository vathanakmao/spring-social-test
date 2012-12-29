package com.vathanakmao.testproj.testfacebookapp.web.controller;

import com.vathanakmao.testproj.testfacebookapp.model.FBUser;
import com.vathanakmao.testproj.testfacebookapp.service.FacebookAuthService;
import com.vathanakmao.testproj.testfacebookapp.service.FacebookOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/api")
public class FBOperationsController {
    private FacebookOperations facebookOperations;

    public FBOperationsController() {
        facebookOperations = new FacebookOperations();
    }


    /**
     * Get currently logged-in user's account information.
     *
     * @param request
     * @return the account info.
     */
    @RequestMapping(value="me", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public FBUser getMe(HttpServletRequest request) {
        return facebookOperations.getMyAccount(FacebookAuthService.getFacebookSignedRequestFromSession(request).getOauth_token());
    }

}
