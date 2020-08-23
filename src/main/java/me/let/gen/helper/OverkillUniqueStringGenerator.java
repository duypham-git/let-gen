package me.let.gen.helper;

import java.security.SecureRandom;
import java.util.Set;

/**
 * it's probably overkill
 */
public class OverkillUniqueStringGenerator extends SimpleUniqueStringGenerator implements IUniqueStringGenerator {
    
    private Set<String> uniqueStrStorage;
    private int maxUnluckyRolls;

    public OverkillUniqueStringGenerator(int maxUnluckRolls, Set<String> uniqueStrStorage){
        this.uniqueStrStorage = uniqueStrStorage;
        this.maxUnluckyRolls = maxUnluckRolls;

        init();
    }

    public OverkillUniqueStringGenerator(SecureRandom secureRandom, int maxUnluckRolls, Set<String> uniqueStrStorage){
        super(secureRandom);
        this.uniqueStrStorage = uniqueStrStorage;
        this.maxUnluckyRolls = maxUnluckRolls;

        init();
    }

    public void init(){
        if(maxUnluckyRolls < 0) throw new IllegalArgumentException("Invalid maxUnluckRolls: must >= 0");
        if(uniqueStrStorage == null) throw new IllegalArgumentException("Invalid uniqueStrStorage: must NOT NULL");
    }

    @Override
    public String generate(int length){
        int unluckyCounter = 0;
        String uniqueStr;
        
        //take advantage of Set to make sure str is unique.
        //Set.add will return false if element already present in Set.
        //try a couple times (generally 3) is enough.

        uniqueStr = super.generate(length);
        while(!uniqueStrStorage.add(uniqueStr)){
            if(unluckyCounter >= maxUnluckyRolls) throw new IllegalStateException("Unlucky Rolls! Try again another time, mate");
            uniqueStr = super.generate(length);
            unluckyCounter++;
        }

        return uniqueStr;
    }
}