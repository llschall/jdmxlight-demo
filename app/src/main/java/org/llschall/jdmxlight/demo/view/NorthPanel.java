package org.llschall.jdmxlight.demo.view;

import org.llschall.jdmxlight.demo.controller.DemoController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

class NorthPanel extends JPanel {

    NorthPanel(DemoController controller, String libraryName) {

        JPanel panel = new JPanel();

        panel.setLayout(new BorderLayout());
        JLabel label = new JLabel("Featuring " + libraryName);
        label.setFont(label.getFont().deriveFont(Font.ITALIC, 10));
        panel.add(label, BorderLayout.NORTH);
        panel.add(new LocationPanel(controller), BorderLayout.CENTER);

        setLayout(new FlowLayout());
        add(panel);
    }
}

class LocationPanel extends JPanel {

    final DemoController controller;

    final Point location = new Point(50, 50);
    boolean moving = false;

    LocationPanel(DemoController controller) {
        this.controller = controller;

        setPreferredSize(new Dimension(200, 200));

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            } // do nothing

            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                double distance = point.distance(location);
                moving = distance < 30;
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                moving = false;
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            } // do nothing

            @Override
            public void mouseExited(MouseEvent e) {
            } // do nothing
        });

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point point = e.getPoint();
                location.move(point.x, point.y);
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            } // do nothing
        });
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D gr = (Graphics2D) g.create();
        gr.setColor(Color.DARK_GRAY);
        gr.fillRect(0, 0, 300, 200);
        gr.setColor(moving ? Color.YELLOW : Color.CYAN);
        gr.fillOval(location.x, location.y, 20, 20);
    }
}