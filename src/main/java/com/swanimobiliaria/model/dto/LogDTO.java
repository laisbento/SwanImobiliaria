package com.swanimobiliaria.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;
import java.util.UUID;

@ApiModel(
        value = "Log",
        description = "Model of a log event"
)
public class LogDTO {

    @ApiModelProperty(
            value = "Log identification UUID",
            dataType = "string",
            example = "1d96a44b-ed7c-466c-9365-75914353c7c3"
    )
    private UUID logId;

    @ApiModelProperty(
            value = "Date and time of the log event",
            dataType = "time"
    )
    private Timestamp timestamp;

    @ApiModelProperty(
            value = "Register type of the event",
            dataType = "string",
            example = "Login",
            required = true
    )
    private String registro;

    @ApiModelProperty(
            value = "User's email",
            dataType = "string",
            example = "joaodasilva@gmail.com",
            required = true
    )
    private String user;

    public UUID getLogId() {
        return logId;
    }

    public void setLogId(UUID logId) {
        this.logId = logId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
