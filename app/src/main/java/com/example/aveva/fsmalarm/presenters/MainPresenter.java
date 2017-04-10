package com.example.aveva.fsmalarm.presenters;

import com.example.aveva.fsmalarm.models.FiniteStateMachine;
import com.example.aveva.fsmalarm.views.MainView;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by aveva on 07.04.2017.
 */

public class MainPresenter {
    private MainView mainView;
    List<String> states;
    private String state;


    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    public void Lock() {
        if (state.equals(states.get(0))) {
            state = states.get(1);
            mainView.isArmed(false, state);
        }
        else if (state.equals(states.get(1))) {

            state = states.get(2);
            mainView.isArmed(true, state);
        }
        else if (state.equals(states.get(2))) {
            mainView.isArmed(true, state);
        }
        else if (state.equals(states.get(3))){

            state = states.get(1);
            mainView.isArmed(false, state);
        }



    }
    public void UnLock() {
        if (state.equals(states.get(0))) {
            mainView.isArmed(false, state);
        }
       else if (state.equals(states.get(1))) {
            state = states.get(3);
            mainView.isArmed(false, state);
        }
       else if (state.equals(states.get(2))) {
            state = states.get(3);
            mainView.isArmed(false, state);
        }
       else if (state.equals(states.get(3))){
            state = states.get(3);
            mainView.isArmed(false, state);
        }


    }
    public void Lockx2() {
        if (state.equals(states.get(0))) {
            state = states.get(2);
            mainView.isArmed(true, state);
        }
        else if (state.equals(states.get(1))) {
            state = states.get(2);
            mainView.isArmed(true, state);
        }
        else if (state.equals(states.get(2))) {
            mainView.isArmed(true, state);
        }
        else if (state.equals(states.get(3))){
            state = states.get(2);
            mainView.isArmed(true, state);
        }


    }
    public void UnLockx2() {
        if (state.equals(states.get(0))) {
            mainView.isArmed(false, state);
        }
        else if (state.equals(states.get(1))) {
            state = states.get(0);
            mainView.isArmed(false, state);
        }

        else if (state.equals(states.get(2))) {
            state = states.get(0);
            mainView.isArmed(false, state);

        }
        else if (state.equals(states.get(3))){

            state = states.get(3);
            mainView.isArmed(false, state);
        }


    }



    public void getFsm()

    {
        Gson gson = new Gson();
        FiniteStateMachine finiteStateMachine = gson.fromJson(readJson(), FiniteStateMachine.class);
        states = finiteStateMachine.getStates();
        state = states.get(0);
        mainView.isArmed(false, state);
    }

    private String readJson() {
        String json = "";
        try {
            InputStream inputStream = mainView.getContext().getAssets().open("JSON FSM");
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();

        }
        return json;
    }

}
