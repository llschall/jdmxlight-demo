package org.llschall.jdmxlight.demo.view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AdvancedPanel extends JPanel {

    AdvancedPanel() {
        JPanel centerPnl = new JPanel();
        centerPnl.setLayout(new GridLayout(16,0));
        for (int i = 0; i < 512; i++) {
            centerPnl.add(new Slider(i));
        }
        setLayout(new BorderLayout());
        add(centerPnl, BorderLayout.CENTER);
    }

    static class Slider extends JPanel {

        int value;

        Slider(int i) {

            JLabel label = new JLabel("" + value);
            label.setFont(label.getFont().deriveFont(17f));

            JLabel channel = new JLabel("" + i);
            channel.setFont(channel.getFont().deriveFont(Font.ITALIC));

            setLayout(new BorderLayout());
            add(label, BorderLayout.NORTH);
            add(channel, BorderLayout.SOUTH);

            addMouseWheelListener(e -> {
                int rotation = e.getWheelRotation();
                value -= rotation;
                if(value < 0) value =0;
                if (value > 255) value = 255;
                label.setText(""+value);
            });

            Border border = BorderFactory.createLineBorder(Color.GRAY);
            setBorder(border);


            addMouseListener(new MouseListener() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    setBorder(BorderFactory.createLineBorder(
                            Color.BLUE, 4)
                    );
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    setBorder(border);
                }

                @Override
                public void mouseClicked(MouseEvent e) {}

                @Override
                public void mousePressed(MouseEvent e) {}

                @Override
                public void mouseReleased(MouseEvent e) {}
            });
        }

    }
}