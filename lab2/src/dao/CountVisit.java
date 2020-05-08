package dao;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

@Singleton
public class CountVisit {

    int counter;
    public int getCounter(){
        return counter;
    }

    @PostConstruct
    public void init(){
        counter = 0;
    }

    public void increase(){
        counter++;
    }
}

