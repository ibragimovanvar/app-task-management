package com.ibragimov.apptaskmanagement.service.template;

import com.ibragimov.apptaskmanagement.api.response.ApiResponse;

public interface EmailService {

    ApiResponse sendEmail(String to, String code);
}
