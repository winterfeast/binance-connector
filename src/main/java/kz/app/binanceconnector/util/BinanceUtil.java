package kz.app.binanceconnector.util;

public class BinanceUtil {

    public static final String ZERO_BALANCE_REGEX = "^0\\.0{1,8}$";

    public static boolean isNotZeroValue(String input) {
        return !input.matches(ZERO_BALANCE_REGEX);
    }
}
