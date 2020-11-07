package com.eliasnogueira.ultil;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.eliasnogueira.driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUltil {

    public static File takeScreenShot() {
        WebDriver driver = DriverManager.getDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    }

    public static boolean takeScreenShot(String fileName) {
        File file = takeScreenShot();

        try {
            FileUtils.copyFile(file, new File(fileName));
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    public static boolean compareScreenShot(File origin, File incoming) {
        BufferedImage originImageFile;
        try {
            originImageFile = ImageIO.read(origin);
        } catch (IOException e) {
            return false;
        }

        BufferedImage incomingImageFile;
        try {
            incomingImageFile = ImageIO.read(incoming);
        } catch (IOException e) {
            return false;
        }

        DataBuffer originImageData = originImageFile.getData().getDataBuffer();
        int originSize = originImageData.getSize();
        DataBuffer incomingImageData = incomingImageFile.getData().getDataBuffer();
        int incomingSize = incomingImageData.getSize();

        if (originSize != incomingSize) {
            return false;
        }

        for (int i = 0; i < originSize; i++) {
            if (originImageData.getElem(i) != incomingImageData.getElem(i)) {
                return false;
            }
        }

        return true;
    }
}
