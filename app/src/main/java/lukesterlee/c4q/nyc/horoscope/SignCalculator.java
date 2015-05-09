package lukesterlee.c4q.nyc.horoscope;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Luke on 5/8/2015.
 */
public class SignCalculator {



    public static String doWeMatch(String mySign, String yourSign) {
        if (mySign.equalsIgnoreCase("leo")) {

        }
        return "";
    }



    public static String getSign(int month, int day) {

        if ((month == 3 && day >= 21) || (month == 4 && day <= 19))
            return Data.signs[0];
        else if ((month == 4 && day >= 20) || month == 5 && day <= 20)
            return Data.signs[1];
        else if ((month == 5 && day >= 21) || month == 6 && day <= 21)
            return Data.signs[2];
        else if ((month == 6 && day >= 22) || month == 7 && day <= 22)
            return Data.signs[3];
        else if ((month == 7 && day >= 23) || month == 8 && day <= 22)
            return Data.signs[4];
        else if ((month == 8 && day >= 23) || month == 9 && day <= 22)
            return Data.signs[5];
        else if ((month == 9 && day >= 23) || month == 10 && day <= 23)
            return Data.signs[6];
        else if ((month == 10 && day >= 24) || month == 12 && day <= 20)
            return Data.signs[7];
        else if ((month == 11 && day >= 21) || month == 12 && day <= 22)
            return Data.signs[8];
        else if ((month == 12 && day >= 23) || month == 1 && day <= 20)
            return Data.signs[9];
        else if ((month == 1 && day >= 21) || month == 2 && day <= 21)
            return Data.signs[10];
        else
            return Data.signs[11];

    }

    public static String getRandomDate() {
        String result = "";
        Random random = new Random();
        int dayOfYear = random.nextInt(365) + 1;
        Calendar date = Calendar.getInstance();
        date.set(Calendar.DAY_OF_YEAR, dayOfYear);
        int month = date.get(Calendar.MONTH);
        int day = date.get(Calendar.DAY_OF_MONTH);

        //String sign = getSign(month+1, day);

        result += Data.month[month];
        result += " " + day;



        return result;
    }


    public static String getAnswer(String date) {
        String[] monthDay = date.split(" ");

        HashMap<String, Integer> month = new HashMap<String, Integer>();
        month.put("January", 1);
        month.put("February", 2);
        month.put("March", 3);
        month.put("April", 4);
        month.put("May", 5);
        month.put("June", 6);
        month.put("July", 7);
        month.put("August", 8);
        month.put("September", 9);
        month.put("October", 10);
        month.put("November", 11);
        month.put("December", 12);

        int m = month.get(monthDay[0]);
        int day = Integer.parseInt(monthDay[1]);
        return getSign(m, day);
    }

    public static int getSignPosition(String sign) {

        String[] s = {"Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo",
                "Libra", "Scorpio", "Sagittarius", "Capricorn", "Aquarius", "Pisces"};

        HashMap<String, Integer> signs = new HashMap<String, Integer>();
        signs.put("Aries", 0);
        signs.put("Taurus", 1);
        return 0;
    }

}
