package com.andy.utils;

import java.util.List;

/**
 * @Author: Lim, Andy
 * @Date: 2020/11/4
 * @Proposal:
 */
public class TestMain {


    public static void main(String[] args) {
        Fighter fighter = new Alpha(new Beta(null));
        fighter.fight("thai");
    }
}

abstract class Fighter {

    protected Fighter next;

    Fighter(Fighter next){
        this.next = next;
    }

    void doNext(String attack) {
        if(null != next) {
            next.fight(attack);
        }
    }

    abstract void fight(String name);
}

class Alpha extends Fighter {
    Alpha(Fighter next){
        super(next);
    }

    @Override
    void fight(String name) {
        System.out.println(name + " shows alpha atk");
        doNext(name);
    }
}

class Beta extends Fighter {
    Beta(Fighter next){
        super(next);
    }

    @Override
    void fight(String name) {
        System.out.println(name + " shows beta atk");
        doNext(name);
    }
}

interface ItemService {
    List<Integer> listItem(Player player);
}

class BaseProperty {
    private Integer hpCoefficient;
    private Integer manaCoefficient;
    public Integer getHpCoefficient() {
        return hpCoefficient;
    }

    public void setHpCoefficient(Integer hpCoefficient) {
        this.hpCoefficient = hpCoefficient;
    }

    public Integer getManaCoefficient() {
        return manaCoefficient;
    }

    public void setManaCoefficient(Integer manaCoefficient) {
        this.manaCoefficient = manaCoefficient;
    }
}

class Player {
    private String name;
    private Integer hitPoint;
    private Integer mana;
    private Integer level;

    Player(String name, Integer level, Occupation ocp) {
        this.hitPoint = level * 10;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(Integer hitPoint) {
        this.hitPoint = hitPoint;
    }

    public Integer getMana() {
        return mana;
    }

    public void setMana(Integer mana) {
        this.mana = mana;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}

abstract class Occupation {
    protected Integer hitPoint;
    protected Integer mana;
    abstract void doAtk();
}

