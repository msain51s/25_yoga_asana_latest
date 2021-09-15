package com.yoga_asana.model;

import java.io.Serializable;

/**
 * Created by Administrator on 8/30/2017.
 */

public class YogaDetailModel implements Serializable{
    public String yogaTitle;
    public String stepsOfYoga;

    public int getGifOrNormal() {
        return gifOrNormal;
    }

    public void setGifOrNormal(int gifOrNormal) {
        this.gifOrNormal = gifOrNormal;
    }

    public int gifOrNormal;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int position;

    public String getYogaTitle() {
        return yogaTitle;
    }

    public void setYogaTitle(String yogaTitle) {
        this.yogaTitle = yogaTitle;
    }

    public String getStepsOfYoga() {
        return stepsOfYoga;
    }

    public void setStepsOfYoga(String stepsOfYoga) {
        this.stepsOfYoga = stepsOfYoga;
    }

    public String getBenefitsOfYoga() {
        return benefitsOfYoga;
    }

    public void setBenefitsOfYoga(String benefitsOfYoga) {
        this.benefitsOfYoga = benefitsOfYoga;
    }

    public String getPrecautions() {
        return precautions;
    }

    public void setPrecautions(String precautions) {
        this.precautions = precautions;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String benefitsOfYoga;
    public String precautions;
    public String imageName;
}
