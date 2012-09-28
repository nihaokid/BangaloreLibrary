package com.thoughtworks.wzhai.command;

import com.thoughtworks.wzhai.tool.LogForLibrary;

import static java.lang.System.exit;

public enum Action {
    Exit {
        @Override
        public void run() {
            exit(0);
        }
    },
    Ok {
        @Override
        public void run() {
        }
    };
    public abstract void run();
}
