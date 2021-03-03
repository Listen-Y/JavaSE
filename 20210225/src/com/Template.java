package com;

public  class Template {

    public void play(String thing) {
        System.out.println(thing);
    }

    public void check() {
        System.out.println("check");
        this.play("pingpong");
    }
}
