package de.ptaszyk.verbosesdk;

import android.os.Build;

public class Sdk {

    //Android Versions as verbose constants
    public static final int ICE_CREAM_SANDWITCH = 14;
    public static final int ICS = 14;
    public static final int I = 14;

    public static final int ICE_CREAM_SANDWITCH_MR1 = 14;

    public static final int JELLY_BEAN = 16;
    public static final int JELLY_BEAN_MR1 = 17;
    public static final int JELLY_BEAN_MR2 = 18;

    public static final int KIT_KAT = 19;
    public static final int KIT_KAT_WEAR = 20;

    public static final int LOLLIPOP = 21;
    public static final int LOLLIPOP_MR1 = 22;

    public static final int MARSHMALLOW = 23;
    public static final int M = 23;

    public static final int NOUGAT = 24;
    public static final int N = 24;
    public static final int NOUGAT_MR1 = 25;

    public static final int OREO = 26;
    public static final int OREO_MR1 = 27;

    private Sdk() {
        //Private constructor to make this class not instantiable.
    }

    /**
     * Android Version is at least the version passed to the method.
     *
     * @param version the Android Version you want to compare your current
     *                version to.
     *
     * @return true or false, depending on the current SDK_INT version and
     * the Android version passed to the method.
     */
    public static boolean isAtleast(int version) {

        return getSdk() >= version;
    }

    /**
     * Android Version is higher than the version passed to the method.
     *
     * @param version the Android Version you want to compare your current
     *                version to.
     *
     * @return true or false, depending on the current SDK_INT version and
     * the Android version passed to the method.
     */
    public static boolean isHigherThan(int version) {

        return getSdk() > version;
    }

    /**
     * Android Version is maximum the version passed to the method.
     *
     * @param version the Android Version you want to compare your current
     *                version to.
     *
     * @return true or false, depending on the current SDK_INT version and
     * the Android version passed to the method.
     */
    public static boolean isMaximum(int version) {

        return getSdk() <= version;
    }

    /**
     * Android Version is lower than the version passed to the method.
     *
     * @param version the Android Version you want to compare your current
     *                version to.
     *
     * @return true or false, depending on the current SDK_INT version and
     * the Android version passed to the method.
     */
    public static boolean isLowerThan(int version) {

        return getSdk()  < version;
    }

    private static int getSdk() {
        return Build.VERSION.SDK_INT;
    }
}
