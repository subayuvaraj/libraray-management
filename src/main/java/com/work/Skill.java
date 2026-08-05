package com.work;

public class Skill {

    private String skillName;
    private int experience;

    public Skill() {
    }

    public Skill(String skillName, int experience) {
        this.skillName = skillName;
        this.experience = experience;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "skillName='" + skillName + '\'' +
                ", experience=" + experience +
                '}';
    }
}