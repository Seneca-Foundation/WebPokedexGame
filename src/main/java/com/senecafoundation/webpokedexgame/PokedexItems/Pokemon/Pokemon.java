package com.senecafoundation.webpokedexgame.PokedexItems.Pokemon;

import javax.persistence.MappedSuperclass;

import com.senecafoundation.webpokedexgame.DataHandler.IDataWriter;

@MappedSuperclass
public class Pokemon extends ActualPokemon{
    private String name;
    private String avgSize; 
    private String pokemonType;
    private String region; 
    private Integer hp; 
    private Integer attack; 
    private Integer defense; 
    private Integer spDefense;
    private Integer spAttack; 
    private Integer speed; 
    private String typeEffectiveness;
    private String typeWeakeness; 
    
    public Pokemon(
        String name, 
        String avgSize,
        String color, 
        String pokemonType, 
        String region, 
        Integer hp, 
        Integer attack, 
        Integer defense, 
        Integer spDefense, 
        Integer spAttack, 
        Integer speed,
        String ability1, 
        String typeEffectiveness, 
        String typeWeakness,
        IDataWriter dataHolder
        ) {
        super(color, ability1, dataHolder);
        this.setName(name);
        this.setAvgSize(avgSize);
        this.setPokemonType(pokemonType);
        this.setRegion(region);
        this.setHp(hp);
        this.setAttack(attack);
        this.setDefense(defense);
        this.setSpDefense(spDefense);
        this.setSpAttack(spAttack);
        this.setSpeed(speed);
        this.setTypeEffectiveness(typeEffectiveness);
        this.setTypeWeakness(typeWeakness);
    }

    public Pokemon() {
        super();
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name; 
    }
    public String getAvgSize()
    {
        return avgSize;
    }
    public void setAvgSize(String avgSize)
    {
        this.avgSize = avgSize;
    }
    public String getPokemonType()
    {
        return pokemonType;
    }
    public void setPokemonType(String pokemonType)
    {
        this.pokemonType = pokemonType; 
    }
    public String getRegion()
    {
        return region; 
    }
    public void setRegion(String region)
    {
        this.region = region;
    }
    public Integer getHp()
    {
        return hp; 
    }
    public void setHp(Integer hp)
    {
        this.hp = hp;
    }
    public Integer getAttack()
    {
        return attack;
    }
    public void setAttack(Integer attack)
    {
        this.attack = attack; 
    }
    public Integer getDefense()
    {
        return defense; 
    }
    public void setDefense(Integer defense)
    {
        this.defense = defense;
    }
    public Integer getSpDefense()
    {
        return spDefense;
    }
    public void setSpDefense(Integer spDefense)
    {
        this.spDefense = spDefense;
    }
    public Integer getSpAttack()
    {
        return spAttack;
    }
    public void setSpAttack(Integer spAttack)
    {
        this.spAttack = spAttack;
    }
    public Integer getSpeed()
    {
        return speed;
    }
    public void setSpeed(Integer speed)
    {
        this.speed = speed;
    }
    public String getTypeEffectiveness()
    {
        return typeEffectiveness;
    }
    public void setTypeEffectiveness(String typeEffectiveness)
    {
        this.typeEffectiveness = typeEffectiveness;
    }
    public String getTypeWeakness()
    {
        return typeWeakeness;
    }
    public void setTypeWeakness(String typeWeakness)
    {
        this.typeWeakeness = typeWeakness;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "," + this.getID() + "," + this.getColor() + "," + this.getAvgSize() + "," + this.getPokemonType() + "," + this.getRegion() + "," + this.getHp().toString() + "," + this.getAttack().toString() + "," + this.getDefense().toString() + "," + this.getSpDefense().toString() + "," + this.getSpAttack().toString() + "," + this.getSpeed().toString() + "," + this.getAbility1() + "," + this.getTypeEffectiveness() + "," + this.getTypeWeakness();
    } 
}
