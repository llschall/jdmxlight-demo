package org.llschall.jdmxlight.demo.view;

import org.llschall.jdmxlight.demo.controller.DemoController;
import org.llschall.jdmxlight.demo.model.DemoModel;
import org.llschall.jdmxlight.demo.model.IChangeListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

class NorthPanel extends JPanel {

    NorthPanel(DemoController controller, DemoModel model, String libraryName) {

        JPanel panel = new JPanel();

        panel.setLayout(new BorderLayout());
        JLabel label = new JLabel("Featuring " + libraryName);
        label.setFont(label.getFont().deriveFont(Font.ITALIC, 10));
        panel.add(label, BorderLayout.NORTH);
        panel.add(new LocationPanel(controller, model), BorderLayout.CENTER);

        setLayout(new FlowLayout());
        add(panel);
    }
}

class LocationPanel extends JPanel implements IChangeListener {

    final DemoModel model;
    final DemoController controller;

    boolean moving = false;

    LocationPanel(DemoController controller, DemoModel model) {
        this.controller = controller;
        this.model = model;
        model.addListener(this);

        setPreferredSize(new Dimension(200, 200));

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            } // do nothing

            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                Point location = new Point(model.rotation.get(), model.rotation.get());
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
                int x = point.x - 20;
                int y = point.y - 20;
                model.fireLocationMoved(x, y);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            } // do nothing
        });
    }

    @Override
    public void paint(Graphics g) {

        int x = model.rotation.get();
        int y = model.inclination.get();

        Graphics2D gr = (Graphics2D) g.create();
        gr.setColor(Color.DARK_GRAY);
        gr.fillRect(0, 0, 300, 200);
        gr.setColor(moving ? Color.YELLOW : Color.CYAN);
        gr.fillOval(x, y, 40, 40);
    }

    @Override
    public void modelChanged() {
        int x = model.rotation.get();
        int y = model.inclination.get();
        repaint();
    }
}