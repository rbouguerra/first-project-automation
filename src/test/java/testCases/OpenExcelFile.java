package testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.testng.annotations.Test;

public class OpenExcelFile {

	public String filePath = "E:\\Formation_Selenium_Zied\\Projet\\firstProjectAutomation\\ExportExcel.xlsx";
	// public String filePath = "src/test/resources/temp/ExportExcel.xlsx";

	@Test

	public void robotTest() throws InterruptedException {

		openExcelFile(filePath);
		//

		Thread.sleep(3000);
	}

	private void openExcelFile(String filePath) throws InterruptedException {

		StringSelection stringSelection = new StringSelection(filePath);
		Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipBoard.setContents(stringSelection, null);

		Robot robot = null;
		try {

			robot = new Robot();

		} catch (AWTException e) {

			e.printStackTrace();

		}

		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(550);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(150);
		robot.keyPress(KeyEvent.VK_CLEAR);
		robot.keyRelease(KeyEvent.VK_CLEAR);
		robot.keyPress(KeyEvent.VK_CANCEL);
		robot.keyRelease(KeyEvent.VK_CANCEL);

	}

}
