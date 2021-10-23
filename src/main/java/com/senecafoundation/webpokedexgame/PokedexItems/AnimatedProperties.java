package com.senecafoundation.webpokedexgame.PokedexItems;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import com.senecafoundation.webpokedexgame.DataHandler.Interfaces.IDataWriter;

@Entity
@Table(name = "animatedproperties")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class AnimatedProperties {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String spriteSheetUrl;
    private Double spriteSheetWidth;
    private Double spriteSheetHeight;
    private Double widthOfCharacterWindowUp;
    private Double heightOfCharacterWindowUp;
    private Double widthOfCharacterWindowRight;
    private Double heightOfCharacterWindowRight;
    private Double widthOfCharacterWindowDown; 
    private Double heightOfCharacterWindowDown;
    private Double widthOfCharacterWindowLeft;
    private Double heightOfCharacterWindowLeft;
    private Double xOfCharacterPositionLeft;
    private Double yOfCharacterPositionLeft;
    private Double xOfCharacterPositionRight;
    private Double yOfCharacterPositionRight;
    private Double xOfCharacterPositionUp;
    private Double yOfCharacterPositionUp;
    private Double xOfCharacterPositionDown;
    private Double yOfCharacterPositionDown;
    private Double stepCountRight;
    private Double stepCountLeft;
    private Double stepCountUp;
    private Double stepCountDown;
    private Double animationStartPercentageLeft;
    private Double animationStartPercentageRight;
    private Double animationStartPercentageUp;
    private Double animationStartPercentageDown;
    private Double animationStopPercentageLeft;
    private Double animationStopPercentageRight;
    private Double animationStopPercentageUp;
    private Double animationStopPercentageDown;
    
    public AnimatedProperties(
        String spriteSheetUrl,
        Double spriteSheetWidth,
        Double spriteSheetHeight,
        Double widthOfCharacterWindowUp,
        Double heightOfCharacterWindowUp,
        Double widthOfCharacterWindowRight,
        Double heightOfCharacterWindowRight,
        Double widthOfCharacterWindowDown,
        Double heightOfCharacterWindowDown,
        Double widthOfCharacterWindowLeft,
        Double heightOfCharacterWindowLeft,
        Double xOfCharacterPositionLeft,
        Double yOfCharacterPositionLeft,
        Double xOfCharacterPositionRight,
        Double yOfCharacterPositionRight,
        Double xOfCharacterPositionUp,
        Double yOfCharacterPositionUp,
        Double xOfCharacterPositionDown,
        Double yOfCharacterPositionDown,
        Double stepCountRight,
        Double stepCountLeft,
        Double stepCountUp,
        Double stepCountDown,
        Double animationStartPercentageLeft,
        Double animationStartPercentageRight,
        Double animationStartPercentageUp,
        Double animationStartPercentageDown,
        Double animationStopPercentageLeft,
        Double animationStopPercentageRight,
        Double animationStopPercentageUp,
        Double animationStopPercentageDown
    ) {
        this.setId(UUID.randomUUID());
        this.setSpriteSheetUrl(spriteSheetUrl);
        this.setSpriteSheetWidth(spriteSheetWidth);
        this.setSpriteSheetHeight(spriteSheetHeight);        
        this.setWidthOfCharacterWindowUp(widthOfCharacterWindowUp);
        this.setHeightOfCharacterWindowUp(heightOfCharacterWindowUp);
        this.setWidthOfCharacterWindowRight(widthOfCharacterWindowRight);
        this.setHeightOfCharacterWindowRight(heightOfCharacterWindowRight);
        this.setWidthOfCharacterWindowDown(widthOfCharacterWindowDown);
        this.setHeightOfCharacterWindowDown(heightOfCharacterWindowDown);        
        this.setWidthOfCharacterWindowLeft(widthOfCharacterWindowLeft);
        this.setHeightOfCharacterWindowLeft(heightOfCharacterWindowLeft);
        this.setxOfCharacterPositionLeft(xOfCharacterPositionLeft);
        this.setyOfCharacterPositionLeft(yOfCharacterPositionLeft);
        this.setxOfCharacterPositionRight(xOfCharacterPositionRight); 
        this.setyOfCharacterPositionRight(yOfCharacterPositionRight); 
        this.setxOfCharacterPositionUp(xOfCharacterPositionUp); 
        this.setyOfCharacterPositionUp(yOfCharacterPositionUp);       
        this.setxOfCharacterPositionDown(xOfCharacterPositionDown); 
        this.setyOfCharacterPositionDown(yOfCharacterPositionDown); 
        this.setStepCountRight(stepCountRight);
        this.setStepCountLeft(stepCountLeft);
        this.setStepCountUp(stepCountUp);
        this.setStepCountDown(stepCountDown);
        this.setAnimationStartPercentageLeft(animationStartPercentageLeft);
        this.setAnimationStartPercentageRight(animationStartPercentageRight);
        this.setAnimationStartPercentageUp(animationStartPercentageUp);
        this.setAnimationStartPercentageDown(animationStartPercentageDown);
        this.setAnimationStopPercentageLeft(animationStopPercentageLeft);
        this.setAnimationStopPercentageRight(animationStopPercentageRight);
        this.setAnimationStopPercentageUp(animationStopPercentageUp);
        this.setAnimationStopPercentageDown(animationStopPercentageDown);
    }

    public Double getAnimationStopPercentageDown() {
        return animationStopPercentageDown;
    }

    public void setAnimationStopPercentageDown(Double animationStopPercentageDown) {
        this.animationStopPercentageDown = animationStopPercentageDown;
    }

    public Double getAnimationStopPercentageUp() {
        return animationStopPercentageUp;
    }

    public void setAnimationStopPercentageUp(Double animationStopPercentageUp) {
        this.animationStopPercentageUp = animationStopPercentageUp;
    }

    public Double getAnimationStopPercentageRight() {
        return animationStopPercentageRight;
    }

    public void setAnimationStopPercentageRight(Double animationStopPercentageRight) {
        this.animationStopPercentageRight = animationStopPercentageRight;
    }

    public Double getAnimationStopPercentageLeft() {
        return animationStopPercentageLeft;
    }

    public void setAnimationStopPercentageLeft(Double animationStopPercentageLeft) {
        this.animationStopPercentageLeft = animationStopPercentageLeft;
    }

    public Double getAnimationStartPercentageDown() {
        return animationStartPercentageDown;
    }

    public void setAnimationStartPercentageDown(Double animationStartPercentageDown) {
        this.animationStartPercentageDown = animationStartPercentageDown;
    }

    public Double getAnimationStartPercentageUp() {
        return animationStartPercentageUp;
    }

    public void setAnimationStartPercentageUp(Double animationStartPercentageUp) {
        this.animationStartPercentageUp = animationStartPercentageUp;
    }

    public Double getAnimationStartPercentageRight() {
        return animationStartPercentageRight;
    }

    public void setAnimationStartPercentageRight(Double animationStartPercentageRight) {
        this.animationStartPercentageRight = animationStartPercentageRight;
    }

    public Double getAnimationStartPercentageLeft() {
        return animationStartPercentageLeft;
    }

    public void setAnimationStartPercentageLeft(Double animationStartPercentageLeft) {
        this.animationStartPercentageLeft = animationStartPercentageLeft;
    }

    public Double getStepCountDown() {
        return stepCountDown;
    }

    public void setStepCountDown(Double stepCountDown) {
        this.stepCountDown = stepCountDown;
    }

    public Double getStepCountUp() {
        return stepCountUp;
    }

    public void setStepCountUp(Double stepCountUp) {
        this.stepCountUp = stepCountUp;
    }

    public Double getStepCountLeft() {
        return stepCountLeft;
    }

    public void setStepCountLeft(Double stepCountLeft) {
        this.stepCountLeft = stepCountLeft;
    }

    public Double getStepCountRight() {
        return stepCountRight;
    }

    public void setStepCountRight(Double stepCountRight) {
        this.stepCountRight = stepCountRight;
    }

    public Double getyOfCharacterPositionDown() {
        return yOfCharacterPositionDown;
    }

    public void setyOfCharacterPositionDown(Double yOfCharacterPositionDown) {
        this.yOfCharacterPositionDown = yOfCharacterPositionDown;
    }

    public Double getxOfCharacterPositionDown() {
        return xOfCharacterPositionDown;
    }

    public void setxOfCharacterPositionDown(Double xOfCharacterPositionDown) {
        this.xOfCharacterPositionDown = xOfCharacterPositionDown;
    }

    public Double getyOfCharacterPositionUp() {
        return yOfCharacterPositionUp;
    }

    public void setyOfCharacterPositionUp(Double yOfCharacterPositionUp) {
        this.yOfCharacterPositionUp = yOfCharacterPositionUp;
    }

    public Double getxOfCharacterPositionUp() {
        return xOfCharacterPositionUp;
    }

    public void setxOfCharacterPositionUp(Double xOfCharacterPositionUp) {
        this.xOfCharacterPositionUp = xOfCharacterPositionUp;
    }

    public Double getyOfCharacterPositionRight() {
        return yOfCharacterPositionRight;
    }

    public void setyOfCharacterPositionRight(Double yOfCharacterPositionRight) {
        this.yOfCharacterPositionRight = yOfCharacterPositionRight;
    }

    public Double getxOfCharacterPositionRight() {
        return xOfCharacterPositionRight;
    }

    public void setxOfCharacterPositionRight(Double xOfCharacterPositionRight) {
        this.xOfCharacterPositionRight = xOfCharacterPositionRight;
    }

    public Double getyOfCharacterPositionLeft() {
        return yOfCharacterPositionLeft;
    }

    public void setyOfCharacterPositionLeft(Double yOfCharacterPositionLeft) {
        this.yOfCharacterPositionLeft = yOfCharacterPositionLeft;
    }

    public Double getxOfCharacterPositionLeft() {
        return xOfCharacterPositionLeft;
    }

    public void setxOfCharacterPositionLeft(Double xOfCharacterPositionLeft) {
        this.xOfCharacterPositionLeft = xOfCharacterPositionLeft;
    }

    public Double getHeightOfCharacterWindowLeft() {
        return heightOfCharacterWindowLeft;
    }

    public void setHeightOfCharacterWindowLeft(Double heightOfCharacterWindowLeft) {
        this.heightOfCharacterWindowLeft = heightOfCharacterWindowLeft;
    }

    public Double getWidthOfCharacterWindowLeft() {
        return widthOfCharacterWindowLeft;
    }

    public void setWidthOfCharacterWindowLeft(Double widthOfCharacterWindowLeft) {
        this.widthOfCharacterWindowLeft = widthOfCharacterWindowLeft;
    }

    public Double getHeightOfCharacterWindowDown() {
        return heightOfCharacterWindowDown;
    }

    public void setHeightOfCharacterWindowDown(Double heightOfCharacterWindowDown) {
        this.heightOfCharacterWindowDown = heightOfCharacterWindowDown;
    }

    public Double getWidthOfCharacterWindowDown() {
        return widthOfCharacterWindowDown;
    }

    public void setWidthOfCharacterWindowDown(Double widthOfCharacterWindowDown) {
        this.widthOfCharacterWindowDown = widthOfCharacterWindowDown;
    }

    public Double getHeightOfCharacterWindowRight() {
        return heightOfCharacterWindowRight;
    }

    public void setHeightOfCharacterWindowRight(Double heightOfCharacterWindowRight) {
        this.heightOfCharacterWindowRight = heightOfCharacterWindowRight;
    }

    public Double getWidthOfCharacterWindowRight() {
        return widthOfCharacterWindowRight;
    }

    public void setWidthOfCharacterWindowRight(Double widthOfCharacterWindowRight) {
        this.widthOfCharacterWindowRight = widthOfCharacterWindowRight;
    }

    public Double getHeightOfCharacterWindowUp() {
        return heightOfCharacterWindowUp;
    }

    public void setHeightOfCharacterWindowUp(Double heightOfCharacterWindowUp) {
        this.heightOfCharacterWindowUp = heightOfCharacterWindowUp;
    }

    public Double getWidthOfCharacterWindowUp() {
        return widthOfCharacterWindowUp;
    }

    public void setWidthOfCharacterWindowUp(Double widthOfCharacterWindowUp) {
        this.widthOfCharacterWindowUp = widthOfCharacterWindowUp;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public AnimatedProperties() {
    }

    public Double getSpriteSheetHeight() {
        return spriteSheetHeight;
    }

    public void setSpriteSheetHeight(Double spriteSheetHeight) {
        this.spriteSheetHeight = spriteSheetHeight;
    }

    public Double getSpriteSheetWidth() {
		return spriteSheetWidth;
	}

	public void setSpriteSheetWidth(Double spriteSheetWidth) {
		this.spriteSheetWidth = spriteSheetWidth;
	}

	public String getSpriteSheetUrl() {
        return spriteSheetUrl;
    }

    public void setSpriteSheetUrl(String spriteSheetUrl) {
        this.spriteSheetUrl = spriteSheetUrl;
    }

}