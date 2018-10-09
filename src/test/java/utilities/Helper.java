package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	public static void takescreenShots(WebDriver driver, String screenshotName) throws IOException
	{
		Path destination  = Paths.get("./Screenshots", screenshotName+".png");
		Files.createDirectories(destination.getParent());
		FileOutputStream out = new FileOutputStream(destination.toString());
		out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
		out.close();
	}
}
