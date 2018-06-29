package de.ptaszyk.verbosesdk;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@TargetApi(Sdk.MARSHMALLOW)
public class SecurityPatch {

    //Android Security Patch
    public static final String OKT_15 = "2015-10-01";
    public static final String NOV_15 = "2015-11-01";
    public static final String DEC_15 = "2015-12-01";

    public static final String JAN_2016 = "2016-01-01";
    public static final String FEB_2016 = "2016-02-01";
    public static final String MAR_2016 = "2016-03-01";
    public static final String APR_2016 = "2016-04-02";
    public static final String MAY_2016 = "2016-05-01";
    public static final String JUN_2016 = "2016-06-01";
    public static final String JUL_2016 = "2016-07-05";
    public static final String AUG_2016 = "2016-08-05";
    public static final String SEP_2016 = "2016-09-06";
    public static final String OCT_2016 = "2016-10-05";
    public static final String NOV_2016 = "2016-11-06";
    public static final String DEZ_2016 = "2016-12-05";

    public static final String JAN_2017 = "2017-01-05";
    public static final String FEB_2017 = "2017-02-05";
    public static final String MAR_2017 = "2017-03-05";
    public static final String APR_2017 = "2017-04-05";
    public static final String MAY_2017 = "2017-05-05";
    public static final String JUN_2017 = "2017-06-05";
    public static final String JUL_2017 = "2017-07-05";
    public static final String AUG_2017 = "2017-08-05";
    public static final String SEP_2017 = "2017-09-05";
    public static final String OCT_2017 = "2017-10-05";
    public static final String NOV_2017 = "2017-11-06";
    public static final String DEZ_2017 = "2017-12-05";

    public static final String JAN_2018 = "2018-01-05";
    public static final String FEB_2018 = "2018-02-05";
    public static final String MAR_2018 = "2018-03-05";
    public static final String APR_2018 = "2018-04-05";
    public static final String MAY_2018 = "2018-05-05";
    public static final String JUN_2018 = "2018-06-05";

    private SecurityPatch() {
        //Private constructor to make this class not instantiable.
    }

    /**
     * Android Security Patch is higher than the version passed to the method.
     *
     * @param patch the Android Version you want to compare your current
     *              version to.
     *
     * @return true or false, depending on the current SDK_INT version and
     * the Android version passed to the method.
     */
    public static boolean isHigherThan(String patch) throws ParseException {

        if (Sdk.isAtleast(Sdk.OREO)) {
            return LocalDate.parse(patch)
                            .isAfter(LocalDate.parse(getPatch()));
        } else {
            return toDate(patch) != null
                    && toDate(patch).after(toDate(getPatch()));

        }
    }

    /**
     * Android Security Patch is lower than the version passed to the method.
     *
     * @param patch the Android Version you want to compare your current
     *              version to.
     *
     * @return true or false, depending on the current SDK_INT version and
     * the Android version passed to the method.
     */
    public static boolean isLowerThan(String patch) throws ParseException {

        if (Sdk.isAtleast(Sdk.OREO)) {
            return LocalDate.parse(patch)
                            .isBefore(LocalDate.parse(getPatch()));
        } else {
            return toDate(patch).after(toDate(getPatch()));
        }
    }

    private static String getPatch() {

        return Build.VERSION.SECURITY_PATCH;
    }

    private static Date toDate(String date) throws ParseException {

        DateFormat dateFromat = new SimpleDateFormat("yyyy-mm-dd",
                                                     Locale.GERMANY);
        return dateFromat.parse(date);

    }
}
