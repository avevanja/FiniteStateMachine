import android.content.Context;



import com.example.aveva.fsmalarm.views.MainView;


import org.junit.Test;


import static org.mockito.Mockito.*;


public class MockitoTest {


    @Test
    public void checkView() {
        MainView mockView = mock(MainView.class);
        Context context = mock(Context.class);
        mockView.getContext();
        when(mockView.getContext()).thenReturn(context);
        verify(mockView).getContext();
    }


}
