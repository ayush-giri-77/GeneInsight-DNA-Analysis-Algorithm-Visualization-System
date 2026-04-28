package com.geneinsight;

import com.geneinsight.controller.AppController;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;

public class Main {
    public static void main(String[] args) {
        // 1. Attempt to launch the Visual Dashboard
        launchFrontend();

        // 2. Start the original Console Controller
        AppController controller = new AppController();
        controller.start();
    }

    private static void launchFrontend() {
        try {
            // This looks for the dashboard.html file in your project root
            File htmlFile = new File("dashboard.html");

            if (htmlFile.exists()) {
                System.out.println("🚀 Launching GeneInsight Visual Dashboard...");
                Desktop.getDesktop().browse(htmlFile.toURI());
            } else {
                System.out.println("⚠️ dashboard.html not found in project root.");
                System.out.println("Current Directory: " + System.getProperty("user.dir"));
            }
        } catch (IOException e) {
            System.out.println("❌ Error launching frontend: " + e.getMessage());
        } catch (UnsupportedOperationException e) {
            System.out.println("❌ Desktop browsing is not supported on this platform.");
        }
    }
}