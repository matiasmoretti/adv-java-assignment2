package com.example.apidemo;

public class APIResponse {
    public int id;
    public String setup;
    public String punchline;
    //public String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSetup() {
        return setup;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public String getPunchline() {
        return punchline;
    }

    public void setBody(String punchline) {
        this.punchline = punchline;
    }
}

