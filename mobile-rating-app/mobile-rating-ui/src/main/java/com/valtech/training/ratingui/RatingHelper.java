package com.valtech.training.ratingui;


import com.valtech.training.mobileranking.MobileRankingService;

public class RatingHelper {
 private MobileRankingService mobileRankingService;
 public int getRanking(String mobile) {
	 return mobileRankingService.Mobile(mobile);
 }
}
