package com.ibragimov.apptaskmanagement.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiResponse {

   private String message;
   private boolean successful;
   private Map<Object, Object> object;

    public ApiResponse(String message, boolean successful) {
        this.message = message;
        this.successful = successful;
    }
}
