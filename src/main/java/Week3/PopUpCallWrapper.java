package Week3;

import org.junit.Test;

public class PopUpCallWrapper extends Wrapper1{

@Test
	public void primarywindowhandle()
{
	launchbrowser("chrome","http://popuptest.com/");
	getprimarywindow("primarywindow");
//	getsecondarywindow("primarywindow");
	movetolastwindow("primarywindow");
}

}
