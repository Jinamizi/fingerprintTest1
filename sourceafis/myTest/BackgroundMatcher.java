package com.machinezoo.sourceafis.myTest;

import com.machinezoo.sourceafis.FingerprintMatcher;
import com.machinezoo.sourceafis.FingerprintTemplate;
import javax.swing.SwingWorker;
import javax.swing.JLabel;
import java.util.concurrent.ExecutionException;

public class BackgroundMatcher extends SwingWorker<Double, Object>  {
    private final String file1, file2; //location of the two prints to match
    private final JLabel resultLabel, infoLabel; //JLabel to display th result
    
    public BackgroundMatcher(String f1, String f2, JLabel label, JLabel label1) {
        file1 = f1;
        file2 = f2;
        resultLabel = label;
        infoLabel = label1;
    }
    public Double doInBackground() {
        return match();
    }
    public void done() {
        try {
            //get the results of doInBackground and display it
            double value = get();
            resultLabel.setText(String.valueOf(value));
            if(value>40) infoLabel.setText("match");
            else infoLabel.setText("do not match");
        } catch(InterruptedException e) {
            resultLabel.setText("_");
            infoLabel.setText("Interrupted while waiting for results");
        } catch (ExecutionException e) {
            resultLabel.setText("_");
            infoLabel.setText("Error encountered while performing calculation");
        }
    }
    private double match() {
        FingerprintTemplate probe = new FingerprintTemplate().create(TemplateTest.loadImage(file1));
        FingerprintTemplate matching = new FingerprintTemplate().create(TemplateTest.loadImage(file2));
        FingerprintMatcher matcher = new FingerprintMatcher().index(probe);
        double value = matcher.match(matching);
        return value;
    }
}
