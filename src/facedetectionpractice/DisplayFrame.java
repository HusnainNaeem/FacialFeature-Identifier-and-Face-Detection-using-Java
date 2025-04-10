package facedetectionpractice; 

import java.awt.image.DataBufferByte;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import javax.swing.JFileChooser;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.objdetect.Objdetect;

public class DisplayFrame extends javax.swing.JFrame {
    private Mat matFileOutput ;
     private Mat matFileInput ;
    
    
    public DisplayFrame() {
        setTitle("Facial Recognation");
        try{
          setIconImage(new ImageIcon("images/logo.png").getImage());
        } catch(Exception e){
            System.out.println("logo not found");
        }
        initComponents();
        buttonStates(false);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        inputPanel = new javax.swing.JPanel();
        inputPanelScrollPane = new javax.swing.JScrollPane();
        inputPanelLabel = new javax.swing.JLabel();
        outputPanel = new javax.swing.JPanel();
        outputPanelScrollPane = new javax.swing.JScrollPane();
        outputPanelLabel = new javax.swing.JLabel();
        eyeDetectionButton = new javax.swing.JButton();
        faceDetectionButton = new javax.swing.JButton();
        smileDetectionButton = new javax.swing.JButton();
        allDetectionButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        fiileMenue = new javax.swing.JMenu();
        LoadFileMenueItem = new javax.swing.JMenuItem();
        saveFileMenueItem = new javax.swing.JMenu();
        SaveImageMenueItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        titleLabel.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        titleLabel.setText("Visual Feature Identifer");

        inputPanelScrollPane.setViewportView(inputPanelLabel);

        javax.swing.GroupLayout inputPanelLayout = new javax.swing.GroupLayout(inputPanel);
        inputPanel.setLayout(inputPanelLayout);
        inputPanelLayout.setHorizontalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inputPanelScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
        );
        inputPanelLayout.setVerticalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inputPanelScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
        );

        outputPanelScrollPane.setViewportView(outputPanelLabel);

        javax.swing.GroupLayout outputPanelLayout = new javax.swing.GroupLayout(outputPanel);
        outputPanel.setLayout(outputPanelLayout);
        outputPanelLayout.setHorizontalGroup(
            outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(outputPanelScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
        );
        outputPanelLayout.setVerticalGroup(
            outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(outputPanelScrollPane)
        );

        eyeDetectionButton.setBackground(new java.awt.Color(0, 0, 153));
        eyeDetectionButton.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        eyeDetectionButton.setForeground(new java.awt.Color(255, 255, 255));
        eyeDetectionButton.setText("Detect Eyes");
        eyeDetectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eyeDetectionButtonActionPerformed(evt);
            }
        });

        faceDetectionButton.setBackground(new java.awt.Color(0, 0, 153));
        faceDetectionButton.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        faceDetectionButton.setForeground(new java.awt.Color(255, 255, 255));
        faceDetectionButton.setText("Detect Faces");
        faceDetectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                faceDetectionButtonActionPerformed(evt);
            }
        });

        smileDetectionButton.setBackground(new java.awt.Color(0, 0, 153));
        smileDetectionButton.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        smileDetectionButton.setForeground(new java.awt.Color(255, 255, 255));
        smileDetectionButton.setText("Detect Smile");
        smileDetectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smileDetectionButtonActionPerformed(evt);
            }
        });

        allDetectionButton.setBackground(new java.awt.Color(0, 0, 153));
        allDetectionButton.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        allDetectionButton.setForeground(new java.awt.Color(255, 255, 255));
        allDetectionButton.setText("Analyze Whole Image");
        allDetectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allDetectionButtonActionPerformed(evt);
            }
        });

        jMenuBar1.setMaximumSize(new java.awt.Dimension(58, 200));

        fiileMenue.setText("File");

        LoadFileMenueItem.setText("LoadFile");
        LoadFileMenueItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadFileMenueItemActionPerformed(evt);
            }
        });
        fiileMenue.add(LoadFileMenueItem);

        jMenuBar1.add(fiileMenue);

        saveFileMenueItem.setText("Save");
        saveFileMenueItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileMenueItemActionPerformed(evt);
            }
        });

        SaveImageMenueItem.setText("SaveImage");
        saveFileMenueItem.add(SaveImageMenueItem);

        jMenuBar1.add(saveFileMenueItem);

        jMenu1.setText("Cam");

        jMenuItem1.setText("OpenCamera");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(inputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(smileDetectionButton)
                                .addGap(141, 141, 141)
                                .addComponent(faceDetectionButton)))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(outputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(eyeDetectionButton)
                                .addGap(143, 143, 143)
                                .addComponent(allDetectionButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(532, 532, 532)
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(titleLabel)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(outputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eyeDetectionButton)
                    .addComponent(smileDetectionButton)
                    .addComponent(faceDetectionButton)
                    .addComponent(allDetectionButton))
                .addGap(15, 15, 15))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LoadFileMenueItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadFileMenueItemActionPerformed
        JFileChooser objJFileChooser = new JFileChooser();   // Object forthe file to be choosed   
        File objFile = null;                                 // An object of the file to store the choosen file
        BufferedImage inputImageFile;
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        
        int option = objJFileChooser.showOpenDialog(null);
        if(option == objJFileChooser.APPROVE_OPTION){
            objFile = objJFileChooser.getSelectedFile();
            try {
                inputImageFile = ImageIO.read(objFile);
                inputPanelLabel.setIcon(new ImageIcon(inputImageFile));
                outputPanelLabel.setIcon(new ImageIcon(inputImageFile));
             
            } catch (Exception objIoException) {
                JOptionPane.showMessageDialog(null, objIoException, "Unable to open", JOptionPane.ERROR_MESSAGE);
            }
        }
        try {
            String imagePath = objFile.getPath(); // Adjust the path based on your project structure
            File imageFile = new File(imagePath);
            Mat inputImage = Imgcodecs.imread(imageFile.getAbsolutePath());
            matFileInput = inputImage;
            buttonStates(true);
        } catch (Exception e) {
            System.out.println("Image file not found");
        }
        
        
    }//GEN-LAST:event_LoadFileMenueItemActionPerformed

    private void saveFileMenueItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileMenueItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveFileMenueItemActionPerformed

    private void smileDetectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smileDetectionButtonActionPerformed
       Mat tempFile = matFileInput.clone();
        detectFaceAndSmile(tempFile);
    }//GEN-LAST:event_smileDetectionButtonActionPerformed

    private void faceDetectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_faceDetectionButtonActionPerformed
         Mat tempFile = matFileInput.clone();
        detectFace(tempFile);
    }//GEN-LAST:event_faceDetectionButtonActionPerformed

    private void eyeDetectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eyeDetectionButtonActionPerformed
       
        Mat tempFile = matFileInput.clone();
        detectFaceAndMarkEyes(tempFile);
    }//GEN-LAST:event_eyeDetectionButtonActionPerformed

    private void allDetectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allDetectionButtonActionPerformed
         Mat tempFile = matFileInput.clone();
        detectFaceEyeAndSmile(tempFile);
    }//GEN-LAST:event_allDetectionButtonActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        dispose();
        new LiveCam().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void detectFace(Mat inputImage) {
        //creating objects
        MatOfRect faces = new MatOfRect();  //for storing more than one faces
        
        //Now converting into gray scale because it reduce the computational complexity and simplifies the processing
        Mat grayFrame = new Mat();
        Imgproc.cvtColor(inputImage, grayFrame, Imgproc.COLOR_BGR2GRAY);
        
        //NOw trying to improving the contrast (Merzi ha apni werna kam chal agata ha is ka baghir ) 
        Imgproc.equalizeHist(grayFrame, grayFrame);
        
        int height = grayFrame.height();
        int absoluteFaceSize = 0;
        if(Math.round(height * 0.2f) > 0) {
            absoluteFaceSize = Math.round(height * 0.2f );
        }
        
        
        // Now detetct faces
        CascadeClassifier faceCascade = new CascadeClassifier();
        //lode trained data file
        try{
           
            faceCascade.load("data/haarcascade_frontalface_alt2.xml");
        }catch (Exception e) {
            System.out.println("Trained model not loadd");
        }
         faceCascade.detectMultiScale(grayFrame, faces, 1.1, 2, 0 | Objdetect.CASCADE_SCALE_IMAGE, new Size(absoluteFaceSize, absoluteFaceSize), new Size());
         
         // Writing to file 
         Rect[] faceArray = faces.toArray();
         for(int index = 0; index < faceArray.length; index++ ) {
             // Drawing rectanges
             Imgproc.rectangle(inputImage, faceArray[index], new Scalar(0,0,255),3);
         }
         BufferedImage bufferedImage = matToBufferedImage(inputImage);
         outputPanelLabel.setIcon(null);
         outputPanelLabel.setIcon(new ImageIcon(bufferedImage));
         
    }
    
    public void detectFaceAndSmile(Mat inputImage) {
        MatOfRect faces = new MatOfRect();
        MatOfRect smiles = new MatOfRect(); // For storing detected smiles

        Mat grayFrame = new Mat();
        Imgproc.cvtColor(inputImage, grayFrame, Imgproc.COLOR_BGR2GRAY);
        Imgproc.equalizeHist(grayFrame, grayFrame);

        int height = grayFrame.height();
        int absoluteFaceSize = Math.round(height * 0.2f);

        CascadeClassifier faceCascade = new CascadeClassifier();
        CascadeClassifier smileCascade = new CascadeClassifier(); // Load smile cascade classifier

        try {
            faceCascade.load("data/haarcascade_frontalface_alt2.xml");
            smileCascade.load("data/haarcascade_smile.xml"); // Load smile cascade classifier
        } catch (Exception e) {
            System.out.println("Trained model not loaded");
        }

        faceCascade.detectMultiScale(grayFrame, faces, 1.1, 2, 0 | Objdetect.CASCADE_SCALE_IMAGE, new Size(absoluteFaceSize, absoluteFaceSize), new Size());
        smileCascade.detectMultiScale(grayFrame, smiles, 1.8, 8, 0 | Objdetect.CASCADE_SCALE_IMAGE, new Size(30, 30), new Size());  //the factor of 8 works fine on single as well as multi faces  the figure of 10 is good for ulti faces and the figure of 3 or 4 is good for the single

        Rect[] faceArray = faces.toArray();
        Rect[] smileArray = smiles.toArray(); // Get detected smiles

        for (Rect faceRect : faceArray) {
            Imgproc.rectangle(inputImage, faceRect, new Scalar(0, 0, 255), 3);
            for (Rect smileRect : smileArray) {
                // Check if the smile rectangle is within the face rectangle
                if (faceRect.contains(smileRect.tl()) && faceRect.contains(smileRect.br())) {
                    Imgproc.rectangle(inputImage, smileRect, new Scalar(255, 0, 0), 3);
                }
            }
        }
         BufferedImage bufferedImage = matToBufferedImage(inputImage);
         outputPanelLabel.setIcon(null);
         outputPanelLabel.setIcon(new ImageIcon(bufferedImage));
      
    }
    
    public static BufferedImage matToBufferedImage(Mat mat) {   //convertig the Mat image to Buffer Image
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
    
    public void detectFaceAndMarkEyes(Mat inputImage) {
    MatOfRect faces = new MatOfRect();
    Mat grayFrame = new Mat();
    Imgproc.cvtColor(inputImage, grayFrame, Imgproc.COLOR_BGR2GRAY);
    Imgproc.equalizeHist(grayFrame, grayFrame);

    int height = grayFrame.height();
    int absoluteFaceSize = Math.round(height * 0.2f);

    CascadeClassifier faceCascade = new CascadeClassifier();
    CascadeClassifier eyeCascade = new CascadeClassifier(); // Load eye cascade classifier

    try {
        faceCascade.load("data/haarcascade_frontalface_alt2.xml");
        eyeCascade.load("data/haarcascade_eye.xml"); // Load eye cascade classifier
    } catch (Exception e) {
        System.out.println("Trained model not loaded");
    }

    faceCascade.detectMultiScale(grayFrame, faces, 1.1, 1, 0 | Objdetect.CASCADE_SCALE_IMAGE, new Size(absoluteFaceSize, absoluteFaceSize), new Size());

    Rect[] faceArray = faces.toArray();

    for (Rect faceRect : faceArray) {
        Imgproc.rectangle(inputImage, faceRect, new Scalar(0, 0, 255), 3);

        Mat faceROI = grayFrame.submat(faceRect);
        MatOfRect eyes = new MatOfRect();
        eyeCascade.detectMultiScale(faceROI, eyes, 1.1,8, 0 | Objdetect.CASCADE_SCALE_IMAGE, new Size(30, 30), new Size());

        Rect[] eyeArray = eyes.toArray();
        for (Rect eyeRect : eyeArray) {
            Point center = new Point(faceRect.x + eyeRect.x + eyeRect.width * 0.5, faceRect.y + eyeRect.y + eyeRect.height * 0.5);
            int radius = (int) Math.round((eyeRect.width + eyeRect.height) * 0.25);
            Imgproc.rectangle(inputImage, new Point(center.x - radius, center.y - radius), new Point(center.x + radius, center.y + radius), new Scalar(0, 255, 0), 2);
        }
    }
         BufferedImage bufferedImage = matToBufferedImage(inputImage);
         outputPanelLabel.setIcon(null);
         outputPanelLabel.setIcon(new ImageIcon(bufferedImage));
}

    
    private void detectFaceEyeAndSmile(Mat inputImage) {
        MatOfRect faces = new MatOfRect();
        MatOfRect smiles = new MatOfRect(); // For storing detected smiles

        Mat grayFrame = new Mat();
        Imgproc.cvtColor(inputImage, grayFrame, Imgproc.COLOR_BGR2GRAY);
        Imgproc.equalizeHist(grayFrame, grayFrame);

        int height = grayFrame.height();
        int absoluteFaceSize = Math.round(height * 0.2f);

        CascadeClassifier faceCascade = new CascadeClassifier();
        CascadeClassifier smileCascade = new CascadeClassifier();
        CascadeClassifier eyeCascade = new CascadeClassifier(); // Load eye cascade classifier

        try {
            faceCascade.load("data/haarcascade_frontalface_alt2.xml");
            smileCascade.load("data/haarcascade_smile.xml");
            eyeCascade.load("data/haarcascade_eye.xml"); // Load eye cascade classifier
        } catch (Exception e) {
            System.out.println("Trained model not loaded");
        }

        faceCascade.detectMultiScale(grayFrame, faces, 1.1, 2, 0 | Objdetect.CASCADE_SCALE_IMAGE, new Size(absoluteFaceSize, absoluteFaceSize), new Size());
        smileCascade.detectMultiScale(grayFrame, smiles, 1.8, 8, 0 | Objdetect.CASCADE_SCALE_IMAGE, new Size(30, 30), new Size());

        Rect[] faceArray = faces.toArray();
        Rect[] smileArray = smiles.toArray();

        for (Rect faceRect : faceArray) {
            Imgproc.rectangle(inputImage, faceRect, new Scalar(0, 0, 255), 3);

            Mat faceROI = grayFrame.submat(faceRect);
            MatOfRect eyes = new MatOfRect();
            eyeCascade.detectMultiScale(faceROI, eyes, 1.1, 8, 0 | Objdetect.CASCADE_SCALE_IMAGE, new Size(30, 30), new Size());

            Rect[] eyeArray = eyes.toArray();
            for (Rect eyeRect : eyeArray) {
                Point center = new Point(faceRect.x + eyeRect.x + eyeRect.width * 0.5, faceRect.y + eyeRect.y + eyeRect.height * 0.5);
                int radius = (int) Math.round((eyeRect.width + eyeRect.height) * 0.25);
                Imgproc.circle(inputImage, center, radius, new Scalar(0, 255, 0), 2);
            }

            for (Rect smileRect : smileArray) {
                // Check if the smile rectangle is within the face rectangle
                if (faceRect.contains(smileRect.tl()) && faceRect.contains(smileRect.br())) {
                    Imgproc.rectangle(inputImage, smileRect, new Scalar(255, 0, 0), 2);
                    System.out.println("Smile is detected...");
                }
            }
        }
         BufferedImage bufferedImage = matToBufferedImage(inputImage);
         outputPanelLabel.setIcon(null);
         outputPanelLabel.setIcon(new ImageIcon(bufferedImage));
        
    }
    
    private void buttonStates(boolean state ) {
        smileDetectionButton.setEnabled(state);
        faceDetectionButton.setEnabled(state);
        eyeDetectionButton.setEnabled(state);
        allDetectionButton.setEnabled(state);
        saveFileMenueItem.setEnabled(state);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem LoadFileMenueItem;
    private javax.swing.JMenuItem SaveImageMenueItem;
    private javax.swing.JButton allDetectionButton;
    private javax.swing.JButton eyeDetectionButton;
    private javax.swing.JButton faceDetectionButton;
    private javax.swing.JMenu fiileMenue;
    private javax.swing.JPanel inputPanel;
    private javax.swing.JLabel inputPanelLabel;
    private javax.swing.JScrollPane inputPanelScrollPane;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel outputPanel;
    private javax.swing.JLabel outputPanelLabel;
    private javax.swing.JScrollPane outputPanelScrollPane;
    private javax.swing.JMenu saveFileMenueItem;
    private javax.swing.JButton smileDetectionButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
