package com.openld.jetpacksample.databinding;

/**
 * author: lllddd
 * created on: 2021/11/4 14:27
 * description:
 */
public class BookRatingUtil {
    /**
     * 计算星级描述文字
     *
     * @param rating 星星等级
     * @return 星级描述文字
     */
    public static String getBookRatingStr(int rating) {
        switch (rating) {
            case 0:
                return "0星星";
            case 1:
                return "1星星";
            case 2:
                return "2星星";
            case 3:
                return "3星星";
            case 4:
                return "4星星";
            case 5:
                return "5星星";
            default:
                return "";
        }
    }
}
