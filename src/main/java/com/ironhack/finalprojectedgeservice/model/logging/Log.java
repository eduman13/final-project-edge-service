package com.ironhack.finalprojectedgeservice.model.logging;

public class Log {

    private String microservice;
    private String timestamp;
    private StatusLog status;
    private Error error;

    public Log() {
    }

    public String getMicroservice() {
        return microservice;
    }

    public void setMicroservice(String microservice) {
        this.microservice = microservice;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public StatusLog getStatus() {
        return status;
    }

    public void setStatus(StatusLog status) {
        this.status = status;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
