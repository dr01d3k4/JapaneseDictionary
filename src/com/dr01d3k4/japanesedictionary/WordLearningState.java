package com.dr01d3k4.japanesedictionary;

public enum WordLearningState {
	NOT_LEARNT("Not learnt", 0f), LEARNING("Learning", 0.5f), LEARNT("learnt", 1f);
	
	private final String title;
	private final float value;
	
	
	private WordLearningState(final String title, final float value) {
		this.title = title;
		this.value = value;
	}
	
	
	public float getValue() {
		return value;
	}
	
	
	@Override
	public String toString() {
		return title;
	}
}
