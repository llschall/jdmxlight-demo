package org.llschall.jdmxlight.demo.view;

import org.llschall.jdmxlight.demo.model.DemoModel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RawPanel extends JPanel {

    RawPanel(DemoModel model, int channels, int rows) {
        JPanel centerPnl = new JPanel();
        centerPnl.setLayout(new GridLayout(rows, 0));
        for (int i = 1; i <= channels; i++) {
            centerPnl.add(new Slider(model, i));
        }
        setLayout(new BorderLayout());
        add(centerPnl, BorderLayout.CENTER);
    }

    class Slider extends JPanel {

        int value;

        Slider(DemoModel model, int i) {

            JLabel channel = new JLabel(buildLabel(i));
            channel.setFont(channel.getFont().deriveFont(Font.ITALIC));
            channel.setOpaque(true);
            channel.setBackground(Color.LIGHT_GRAY);

            JLabel value = new JLabel("" + this.value);
            value.setFont(value.getFont().deriveFont(17f));

            setLayout(new FlowLayout(FlowLayout.LEFT));
            add(channel);
            add(value);

            addMouseWheelListener(e -> {
                int rotation = e.getWheelRotation();
                this.value -= rotation;
                if (this.value < 0) this.value = 0;
                if (this.value > 255) this.value = 255;
                value.setText("" + this.value);
                model.fireDmxValueChanged(i, this.value);
            });

            Border border = BorderFactory.createLineBorder(Color.GRAY);
            setBorder(border);

            addMouseListener(new MouseListener() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    setBorder(BorderFactory.createLineBorder(
                            Color.BLUE, 2)
                    );
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    setBorder(border);
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                    String str = JOptionPane.showInternalInputDialog(RawPanel.this, "");
                    try {
                        int i1 = Integer.parseInt(str);
                        if (i1 >= 0 && i1 < 255) {
                            Slider.this.value = i1;
                            value.setText("" + Slider.this.value);
                            model.fireDmxValueChanged(i, Slider.this.value);
                        }
                    } catch (NumberFormatException ex) {
                        ex.printStackTrace();
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }
            });
        }

        String buildLabel(int i) {
            if (i > 99) return Integer.toString(i);
            if (i > 9) return "0" + i;
            return "00" + i;
        }

    }
}