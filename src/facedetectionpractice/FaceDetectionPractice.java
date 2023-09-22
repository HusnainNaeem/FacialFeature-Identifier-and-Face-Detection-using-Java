package facedetectionpractice;

import org.opencv.core.Core;

public class FaceDetectionPractice {

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        new DisplayFrame().setVisible(true);
    }
}