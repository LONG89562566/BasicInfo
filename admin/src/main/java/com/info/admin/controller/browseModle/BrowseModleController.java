package com.info.admin.controller.browseModle;

import com.info.admin.controller.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author administrator
 * @date 2018-11-14 23:45:42
 * @describe 三维交底 Controller
 */
@Controller
@RequestMapping("/admin/browseModle")
public class BrowseModleController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(BrowseModleController.class);

    @RequestMapping(value = "/browseModle", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("browseModle:query")
    public String browseModle(HttpServletRequest request, Model model) {
        logger.info("[BrowseModleController][browseModle] 模型浏览:");
        return "browseModle/browseModle";
    }

    @RequestMapping(value = "/browseModle/desktop", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("browseModle:query")
    public String browseModleDesktop(HttpServletRequest request, Model model) {
        logger.info("[BrowseModleController][browseModleDesktop] 模型浏览:");
        return "browseModle/browseModle";
    }
}
