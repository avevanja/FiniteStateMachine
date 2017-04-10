package com.example.aveva.fsmalarm.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aveva on 07.04.2017.
 */

public class FiniteStateMachine {
    @SerializedName("states")
    private List<String> states;

    public List<String> getStates() {
        return states;
    }

    public void setStates(List<String> states) {
        this.states = states;
    }
}
