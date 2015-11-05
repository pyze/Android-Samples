package com.pyze.events;

public class RandomNumberGenerator {
	
	private int mRandomNumber = 0;
	private int mMinimum = 1;
	private int mMaximum = 10;

	public int getNumber() {
		int number = 0;
		if(mMinimum > 0 && mMaximum > 0 && mMinimum < mMaximum) {
			number = (mRandomNumber == 0 ? mMinimum : ++mRandomNumber) % 10;
			if(number == 0) {
				mRandomNumber = 0;
				number = mMaximum;
			}

			if(number < mMaximum && number >= mMinimum) {
				mRandomNumber = number;
				return number;
			}
			else
				return getNumber();
		} else {
			return 1;
		}		
	}

}
