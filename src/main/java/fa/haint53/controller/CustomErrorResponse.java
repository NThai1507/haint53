package fa.haint53.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Date;

public class CustomErrorResponse {
    private Date timestamp;
    private String message;
    private String details;

    public CustomErrorResponse() {
    }

}
