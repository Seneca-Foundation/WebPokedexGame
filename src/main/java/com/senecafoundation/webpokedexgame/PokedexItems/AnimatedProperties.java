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

import com.senecafoundation.webpokedexgame.DataHandler.IDataWriter;

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
    private Double spriteSheetWindowWidth;
    private Double spriteSheetWindowHeight;
    private Double spriteSheetLeftPosition;
    private Double spriteSheetRightPosition;
    private Double spriteSheetUpPosition;

    public AnimatedProperties(
        String spriteSheetUrl,
        Double spriteSheetWidth,
        Double spriteSheetHeight,
        Double spriteSheetWindowWidth,
        Double spriteSheetWindowHeight,
        Double spriteSheetLeftPosition,
        Double spriteSheetRightPosition,
        Double spriteSheetUpPosition,
        IDataWriter dataHolder
    ) {
        this.setId(UUID.randomUUID());
        this.setSpriteSheetUrl(spriteSheetUrl);
        this.setSpriteSheetWidth(spriteSheetWidth);
        this.setSpriteSheetHeight(spriteSheetHeight);
        this.setSpriteSheetWindowWidth(spriteSheetWindowWidth);
        this.setSpriteSheetWindowHeight(spriteSheetWindowHeight);
        this.setSpriteSheetLeftPosition(spriteSheetLeftPosition);
        this.setSpriteSheetRightPosition(spriteSheetRightPosition);
        this.setSpriteSheetUpPosition(spriteSheetUpPosition);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public AnimatedProperties() {
    }

    public Double getSpriteSheetUpPosition() {
        return spriteSheetUpPosition;
    }

    public void setSpriteSheetUpPosition(Double spriteSheetUpPosition) {
        this.spriteSheetUpPosition = spriteSheetUpPosition;
    }

    public Double getSpriteSheetRightPosition() {
		return spriteSheetRightPosition;
	}

	public void setSpriteSheetRightPosition(Double spriteSheetRightPosition) {
		this.spriteSheetRightPosition = spriteSheetRightPosition;
	}

	public Double getSpriteSheetLeftPosition() {
		return spriteSheetLeftPosition;
	}

	public void setSpriteSheetLeftPosition(Double spriteSheetLeftPosition) {
		this.spriteSheetLeftPosition = spriteSheetLeftPosition;
	}

	public Double getSpriteSheetWindowHeight() {
		return spriteSheetWindowHeight;
	}

	public void setSpriteSheetWindowHeight(Double spriteSheetWindowHeight) {
		this.spriteSheetWindowHeight = spriteSheetWindowHeight;
	}

	public Double getSpriteSheetWindowWidth() {
        return spriteSheetWindowWidth;
    }

    public void setSpriteSheetWindowWidth(Double spriteSheetWindowWidth) {
        this.spriteSheetWindowWidth = spriteSheetWindowWidth;
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