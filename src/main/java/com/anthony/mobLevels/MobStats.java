package com.anthony.mobLevels;

import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.*;


public class MobStats {
    private int strength;
    private int agility;
    private int health;
    private final LevelCalc calc = new LevelCalc();

    public void adjustStats(Entity entity) {

        if(entity instanceof LivingEntity le){
            initializeBaseStats(entity);

            double newHealth = getHealth(entity);
            double newSpeed = getAg(entity) / 100;
            double newStr = getStr(entity);

            AttributeInstance health = le.getAttribute(Attribute.MAX_HEALTH);
            if(health != null){
                health.setBaseValue(newHealth);
                le.setHealth(newHealth);
            }
            AttributeInstance speed = le.getAttribute(Attribute.MOVEMENT_SPEED);
            if(speed != null){
                speed.setBaseValue(newSpeed);
            }

            AttributeInstance dmg = le.getAttribute(Attribute.ATTACK_DAMAGE);
            if(dmg != null){
                dmg.setBaseValue(newStr);
            }
        }



    }

    public double getStr(Entity entity){

        return strength * Math.pow(1.25, calc.getMobLevel(entity));
    }

    public double getAg(Entity entity){
        return agility * Math.pow(1.25, calc.getMobLevel(entity));
    }
    public double getHealth(Entity entity){
        return health * Math.pow(1.25, calc.getMobLevel(entity));
    }


    private void initializeBaseStats(Entity entity){
        if(entity instanceof Piglin || entity instanceof Wolf){
            strength = 1;
            agility = 2;
            health = 20;
        } else if(entity instanceof Monster){
            strength = 2;
            agility = 3;
            health = 40;
        } else {
            strength = 1;
            agility = 1;
            health = 20;
        }
    }
}
