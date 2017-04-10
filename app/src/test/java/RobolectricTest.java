import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;


import com.example.aveva.fsmalarm.BuildConfig;
import com.example.aveva.fsmalarm.MainActivity;
import com.example.aveva.fsmalarm.R;


import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertNotNull;


@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class RobolectricTest {
    private Button mButtonLock, mButtonUnLock, mButtonLockx2, mButtonUnLockx2;
    private Activity activity;
    private TextView textView;

    @Before
    public void setUp() {
        activity = Robolectric.setupActivity(MainActivity.class);
        mButtonLock = (Button) activity.findViewById(R.id.button_lock);
        mButtonUnLock = (Button) activity.findViewById(R.id.button_unlock);
        mButtonLockx2 = (Button) activity.findViewById(R.id.button_lockx2);
        mButtonUnLockx2 = (Button) activity.findViewById(R.id.button_unlockx2);
        textView = (TextView) activity.findViewById(R.id.tv_state);


    }

    @Test
    public void checkActivityNotNull() throws Exception {
        assertNotNull(activity);

    }

    @Test
    public void checkTextNotNull() throws Exception {

        mButtonLock.performClick();
        assertFalse(textView.getText().equals(""));
        mButtonUnLockx2.performClick();
        assertFalse(textView.getText().equals(""));
        mButtonLockx2.performClick();
        assertFalse(textView.getText().equals(""));
        mButtonUnLock.performClick();


        assertFalse(textView.getText().equals(""));

    }

}
