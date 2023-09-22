package facedetectionpractice;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import javax.swing.ImageIcon;
import javax.swing.Timer;
import org.opencv.core.Core;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.objdetect.Objdetect;
import org.opencv.videoio.VideoCapture;

public class LiveCam extends javax.swing.JFrame {
    private VideoCapture capture;
    private CascadeClassifier faceCascade;
    private CascadeClassifier smileCascade;
    
    public LiveCam() {
        getContentPane().setBackground(Color.BLACK);
        initComponents();
        // Load the face detection classifier
        faceCascade = new CascadeClassifier();
        if (!faceCascade.load("data/haarcascade_frontalface_alt2.xml")) {
            System.err.println("Error loading face detection classifier.");
            System.exit(1);
        }

        // Load the smile detection classifier
        smileCascade = new CascadeClassifier();
        if (!smileCascade.load("data/haarcascade_smile.xml")) {
            System.err.println("Error loading smile detection classifier.");
            System.exit(1);
        }

        // Open the default camera (usually 0)
        capture = new VideoCapture(0);

        if (!capture.isOpened()) {
            System.err.println("Error opening camera.");
            System.exit(1);
        }

        Timer timer = new Timer(30, e -> detectAndDisplay());
        timer.start();
    }
    
    private void detectAndDisplay() {
        Mat frame = new Mat();
        capture.read(frame);

        if (!frame.empty()) {
            MatOfRect faces = new MatOfRect();
            MatOfRect smiles = new MatOfRect(); // For storing detected smiles
            Mat grayFrame = new Mat();

            Imgproc.cvtColor(frame, grayFrame, Imgproc.COLOR_BGR2GRAY);
            Imgproc.equalizeHist(grayFrame, grayFrame);

            faceCascade.detectMultiScale(grayFrame, faces, 1.1, 2, 0 | Objdetect.CASCADE_SCALE_IMAGE, new Size(30, 30), new Size());
            smileCascade.detectMultiScale(grayFrame, smiles, 1.8, 8, 0 | Objdetect.CASCADE_SCALE_IMAGE, new Size(30, 30), new Size());

            Rect[] faceArray = faces.toArray();
            Rect[] smileArray = smiles.toArray(); // Get detected smiles

            for (Rect faceRect : faceArray) {
                Imgproc.rectangle(frame, faceRect, new Scalar(0, 0, 255), 3);
                for (Rect smileRect : smileArray) {
                    // Check if the smile rectangle is within the face rectangle
                    if (faceRect.contains(smileRect.tl()) && faceRect.contains(smileRect.br())) {
                        Imgproc.rectangle(frame, smileRect, new Scalar(255, 0, 0), 3);
                    }
                }
            }

            BufferedImage bufferedImage = matToBufferedImage(frame);
            outputPanelLabel.setIcon(new ImageIcon(bufferedImage));
        }
    }

    public static BufferedImage matToBufferedImage(Mat mat) {
        int type = BufferedImage.TYPE_BYTE_GRAY;
        if (mat.channels() > 1) {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }
        int bufferSize = mat.channels() * mat.cols() * mat.rows();
        byte[] buffer = new byte[bufferSize];
        mat.get(0, 0, buffer); // Get all the pixels
        BufferedImage image = new BufferedImage(mat.cols(), mat.rows(), type);
        final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        System.arraycopy(buffer, 0, targetPixels, 0, buffer.length);
        return image;
    }

    
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        outputPanelLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        backButton.setBackground(new java.awt.Color(255, 255, 255));
        backButton.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        backButton.setForeground(new java.awt.Color(0, 0, 0));
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        exitButton.setBackground(new java.awt.Color(255, 255, 255));
        exitButton.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        exitButton.setForeground(new java.awt.Color(0, 0, 0));
        exitButton.setText("EXIT");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(outputPanelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitButton)
                .addGap(147, 147, 147))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(outputPanelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(exitButton))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        
    }//GEN-LAST:event_backButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
       dispose();
    if (capture != null && capture.isOpened()) {
        capture.release();
    }
        System.exit(0); // Explicitly exit the application
    }//GEN-LAST:event_exitButtonActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel outputPanelLabel;
    // End of variables declaration//GEN-END:variables
}
