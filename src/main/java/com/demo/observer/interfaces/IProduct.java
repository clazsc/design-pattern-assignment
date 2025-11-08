package com.demo.observer.interfaces;

public interface IProduct {
    void attach(IMember member);
    void detach(IMember member);
    void notifyObservers();
}