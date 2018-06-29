package de.ptaszyk.verbosesdk;

import android.os.Build;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static de.ptaszyk.verbosesdk.Sdk.LOLLIPOP;
import static junit.framework.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Build.class)
public class SdkTest {

    @Test
    public void isAtLeast_WithEqualSdkVersionTest() {
        //given
        Whitebox.setInternalState(Build.VERSION.class, "SDK_INT", Sdk.LOLLIPOP);
        //when
        boolean result = Sdk.isAtleast(LOLLIPOP);
        //then
        assertEquals(true, result);
    }

    @Test
    public void isAtLeast_WithHigherSdkVersionTest() {
        //given
        Whitebox.setInternalState(Build.VERSION.class, "SDK_INT", Sdk.OREO_MR1);
        //when
        boolean result = Sdk.isAtleast(LOLLIPOP);
        //then
        assertEquals(true, result);
    }

    @Test
    public void isAtLeast_WithLowerSdkVersionTest() {
        //given
        Whitebox.setInternalState(Build.VERSION.class, "SDK_INT", Sdk.ICS);
        //when
        boolean result = Sdk.isAtleast(LOLLIPOP);
        //then
        assertEquals(false, result);
    }

    @Test
    public void isHigherThan_WithHigherSdkVersionTest() {
        //given
        Whitebox.setInternalState(Build.VERSION.class, "SDK_INT", Sdk.OREO_MR1);
        //when
        boolean result = Sdk.isHigherThan(LOLLIPOP);
        //then
        assertEquals(true, result);
    }

    @Test
    public void isHigherThan_WithEqualSdkVersionTest() {
        //given
        Whitebox.setInternalState(Build.VERSION.class, "SDK_INT", Sdk.LOLLIPOP);
        //when
        boolean result = Sdk.isHigherThan(LOLLIPOP);
        //then
        assertEquals(false, result);
    }

    @Test
    public void isHigherThan_WithLowerSdkVersionTest() {
        //given
        Whitebox.setInternalState(Build.VERSION.class, "SDK_INT", Sdk.ICS);
        //when
        boolean result = Sdk.isHigherThan(LOLLIPOP);
        //then
        assertEquals(false, result);
    }

    @Test
    public void isLowerThan_WithHigherSdkVersionTest() {
        //given
        Whitebox.setInternalState(Build.VERSION.class, "SDK_INT", Sdk.OREO_MR1);
        //when
        boolean result = Sdk.isLowerThan(LOLLIPOP);
        //then
        assertEquals(false, result);
    }

    @Test
    public void isLowerThan_WithEqualSdkVersionTest() {
        //given
        Whitebox.setInternalState(Build.VERSION.class, "SDK_INT", Sdk.LOLLIPOP);
        //when
        boolean result = Sdk.isLowerThan(LOLLIPOP);
        //then
        assertEquals(false, result);
    }

    @Test
    public void isLowerThan_WithLowerSdkVersionTest() {
        //given
        Whitebox.setInternalState(Build.VERSION.class, "SDK_INT", Sdk.ICS);
        //when
        boolean result = Sdk.isLowerThan(LOLLIPOP);
        //then
        assertEquals(true, result);
    }

    @Test
    public void isMaximum_WithHigherSdkVersionTest() {
        //given
        Whitebox.setInternalState(Build.VERSION.class, "SDK_INT", Sdk.OREO_MR1);
        //when
        boolean result = Sdk.isMaximum(LOLLIPOP);
        //then
        assertEquals(false, result);
    }

    @Test
    public void isMaximum_WithEqualSdkVersionTest() {
        //given
        Whitebox.setInternalState(Build.VERSION.class, "SDK_INT", Sdk.LOLLIPOP);
        //when
        boolean result = Sdk.isMaximum(LOLLIPOP);
        //then
        assertEquals(true, result);
    }

    @Test
    public void isMaximum_WithLowerSdkVersionTest() {
        //given
        Whitebox.setInternalState(Build.VERSION.class, "SDK_INT", Sdk.ICS);
        //when
        boolean result = Sdk.isMaximum(LOLLIPOP);
        //then
        assertEquals(true, result);
    }
}
