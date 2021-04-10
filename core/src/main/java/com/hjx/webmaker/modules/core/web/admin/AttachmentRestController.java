package com.hjx.webmaker.modules.core.web.admin;

import com.hjx.webmaker.modules.base.web.BaseController;
import com.hjx.webmaker.modules.core.service.IAttachmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/attachment")
public class AttachmentRestController<Attachment> extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(AttachmentRestController.class);

    @Qualifier(value = "attachmentService")
    @Autowired
    private IAttachmentService attachmentService;
}
