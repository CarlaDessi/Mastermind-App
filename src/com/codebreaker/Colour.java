package com.codebreaker;


public enum Colour {
	RED(R.drawable.red),
	BLUE(R.drawable.blue),
	GREEN(R.drawable.green),
	YELLOW(R.drawable.yellow),
	PINK(R.drawable.pink),
	ORANGE(R.drawable.orange);
	/*creating tags for each image that can be used to set the answers, guesses in the list view and
	 * guesses in the image views
	 */
	


	private final int resourceId;

	Colour(int resourceId) {
		this.resourceId = resourceId;

	}

	public int getImageId() {
		return resourceId;
	}
}
