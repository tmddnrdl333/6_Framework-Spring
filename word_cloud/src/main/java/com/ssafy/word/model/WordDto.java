package com.ssafy.word.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "WordDto (관심사 정보)", description = "관심사의 단어, 비중을 나타내는 클래스")
public class WordDto {
	
	@ApiModelProperty(value = "관심 단어")
	private String text;
	@ApiModelProperty(value = "관심 비중")
	private double weight;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}
