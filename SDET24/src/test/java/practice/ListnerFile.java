package practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.genericfile.BaseClassAnnotation;
@Listeners(com.crm.genericfile.Listner.class)
public class ListnerFile  extends BaseClassAnnotation{
	@Test
	public void listenerPractice()
	{
		System.out.println("test script failed....");
		Assert.fail();
	}
}	