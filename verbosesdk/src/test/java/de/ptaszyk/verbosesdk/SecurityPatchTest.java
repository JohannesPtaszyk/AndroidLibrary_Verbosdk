package de.ptaszyk.verbosesdk;

import android.os.Build;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static junit.framework.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Build.class)
public class SecurityPatchTest {

    @Test
    public void isLowerThan_withHigherPatchLevel() throws Exception{
        //given
        Whitebox.setInternalState(Build.VERSION.class, "SECURITY_PATCH",
                                  "2015-10-01");
        //when
        boolean result = SecurityPatch.isLowerThan("2014-10-01");
        //then
        assertEquals(false, result);
    }

    @Test
    public void isLowerThan_withEqualPatchLevel() throws Exception{
        //given
        Whitebox.setInternalState(Build.VERSION.class, "SECURITY_PATCH",
                                  "2015-10-01");
        //when
        boolean result = SecurityPatch.isLowerThan("2015-10-01");
        //then
        assertEquals(false, result);
    }

    @Test
    public void isLowerThan_withLowerPatchLevel() throws Exception {
        //given
        Whitebox.setInternalState(Build.VERSION.class, "SECURITY_PATCH",
                                  "2015-10-01");
        //when
        boolean result = SecurityPatch.isLowerThan("2016-10-01");
        //then
        assertEquals(true, result);
    }

    @Test
    public void isHigherThan_withHigherPatchLevel() throws Exception{
        //given
        Whitebox.setInternalState(Build.VERSION.class, "SECURITY_PATCH",
                                  "2015-10-01");
        //when
        boolean result = SecurityPatch.isHigherThan("2014-10-01");
        //then
        assertEquals(false, result);
    }

    @Test
    public void isHigherThan_withEqualPatchLevel() throws Exception{
        //given
        Whitebox.setInternalState(Build.VERSION.class, "SECURITY_PATCH",
                                  "2015-10-01");
        //when
        boolean result = SecurityPatch.isHigherThan("2015-10-01");
        //then
        assertEquals(false, result);
    }

    @Test
    public void isHigherThan_withLowerPatchLevel() throws Exception {
        //given
        Whitebox.setInternalState(Build.VERSION.class, "SECURITY_PATCH",
                                  "2015-10-01");
        //when
        boolean result = SecurityPatch.isHigherThan("2016-10-01");
        //then
        assertEquals(true, result);
    }
}
