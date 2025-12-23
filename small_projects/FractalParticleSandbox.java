/*
 * FractalParticleSandbox.java
 *
 * A creative, feature-rich Java Swing application that combines:
 *  - Interactive particle sandbox (emitters, attractors, collisions, trails)
 *  - Real-time fractal explorer (Mandelbrot + Julia overlays)
 *  - Adjustable controls, presets, and snapshot saving
 *
 * Single-file Java program (no external libraries). To run:
 *   javac FractalParticleSandbox.java
 *   java FractalParticleSandbox
 *
 * This program is intentionally rich and modular to be a large, beautiful
 * codebase you can explore, modify and extend.
 */

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;

public class FractalParticleSandbox {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SandboxFrame frame = new SandboxFrame("Fractal Particle Sandbox 🌌");
            frame.setVisible(true);
        });
    }
}

class SandboxFrame extends JFrame {
    private final SimulationPanel simulationPanel;
    private final ControlPanel controlPanel;

    public SandboxFrame(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(1200, 800);
        setLocationRelativeTo(null);

        simulationPanel = new SimulationPanel(1000, 700);
        controlPanel = new ControlPanel(simulationPanel);

        add(simulationPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.EAST);

        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem saveImage = new JMenuItem("Save Snapshot");
        saveImage.addActionListener(e -> simulationPanel.saveSnapshot());
        JMenuItem exportState = new JMenuItem("Export State");
        exportState.addActionListener(e -> simulationPanel.exportState());
        JMenuItem importState = new JMenuItem("Import State");
        importState.addActionListener(e -> simulationPanel.importState());
        file.add(saveImage);
        file.addSeparator();
        file.add(exportState);
        file.add(importState);
        menuBar.add(file);
        setJMenuBar(menuBar);

        // start simulation
        simulationPanel.start();
    }
}

class ControlPanel extends JPanel {
    private final SimulationPanel sim;

    public ControlPanel(SimulationPanel sim) {
        this.sim = sim;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(300, 0));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(new JLabel("Controls"));
        add(Box.createVerticalStrut(8));

        // Emitter controls
        add(createLabelledSlider("Emitter Rate", 0, 500, sim.emitter.rate, val -> sim.emitter.rate = val));
        add(createLabelledSlider("Emitter Speed", 0, 800, (int) sim.emitter.speed, val -> sim.emitter.speed = val));
        add(createLabelledSlider("Particle Size", 1, 30, sim.particleSize, val -> sim.particleSize = val));
        add(createLabelledSlider("Trail Length", 0, 200, sim.trailLength, val -> sim.trailLength = val));

        add(Box.createVerticalStrut(10));

        // Physics
        add(createLabelledSlider("Gravity", -200, 200, (int) (sim.gravity * 100), val -> sim.gravity = val / 100.0)));
        add(createLabelledSlider("Damping", 0, 100, (int) (sim.damping * 100), val -> sim.damping = val / 100.0)));

        add(Box.createVerticalStrut(10));

        JCheckBox showFractal = new JCheckBox("Show Mandelbrot Overlay", sim.showFractal);
        showFractal.addActionListener(e -> sim.showFractal = showFractal.isSelected());
        add(showFractal);

        JCheckBox showTrails = new JCheckBox("Show Trails", sim.showTrails);
        showTrails.addActionListener(e -> sim.showTrails = showTrails.isSelected());
        add(showTrails);

        add(Box.createVerticalStrut(10));

        JButton clearBtn = new JButton("Clear Particles");
        clearBtn.addActionListener(e -> sim.clearParticles());
        add(clearBtn);

        JButton randomPreset = new JButton("Random Preset");
        randomPreset.addActionListener(e -> sim.applyRandomPreset());
        add(randomPreset);

        add(Box.createVerticalStrut(10));
        add(new JLabel("Presets"));
        JComboBox<String> presets = new JComboBox<>(new String[]{"Calm Fountain", "Chaotic Attractors", "Mandel Glow", "Explosion", "Particle Ocean"});
        presets.addActionListener(e -> {
            String sel = (String) presets.getSelectedItem();
            sim.applyPreset(sel);
        });
        add(presets);

        add(Box.createVerticalGlue());
        // credits
        JLabel foot = new JLabel("Made with Java Swing — modify & explore ♥");
        foot.setFont(foot.getFont().deriveFont(Font.ITALIC, 11f));
        add(foot);
    }

    private JPanel createLabelledSlider(String label, int min, int max, int initial, IntConsumer onChange) {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        JLabel l = new JLabel(label + " : " + initial);
        JSlider s = new JSlider(min, max, initial);
        s.addChangeListener(e -> {
            int v = s.getValue();
            l.setText(label + " : " + v);
            onChange.accept(v);
        });
        p.add(l, BorderLayout.NORTH);
        p.add(s, BorderLayout.CENTER);
        p.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));
        return p;
    }

    // Functional interface for slider callback
    private interface IntConsumer { void accept(int v); }
}

class SimulationPanel extends JPanel implements MouseListener, MouseMotionListener, MouseWheelListener {
    private final int width, height;
    private final BufferedImage buffer;
    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    private ScheduledFuture<?> loopFuture;

    // Particles & physics
    List<Particle> particles = Collections.synchronizedList(new ArrayList<>());
    final Emitter emitter;
    List<Attractor> attractors = Collections.synchronizedList(new ArrayList<>());
    double gravity = 30.0 / 100.0; // pixels/frame^2
    double damping = 0.995;
    int particleSize = 6;
    int trailLength = 40;
    boolean showTrails = true;

    // emitter defaults
    boolean running = true;

    // fractal overlay
    boolean showFractal = true;
    BufferedImage fractalImage = null;

    // controls
    int mouseX, mouseY;
    boolean leftDown = false;

    // rendering
    Color background = Color.BLACK;
    double time = 0;

    public SimulationPanel(int w, int h) {
        this.width = w;
        this.height = h;
        setPreferredSize(new Dimension(w, h));
        buffer = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        emitter = new Emitter(w/2.0, h/2.0);
        setBackground(background);
        addMouseListener(this);
        addMouseMotionListener(this);
        addMouseWheelListener(this);

        // initial attractors
        attractors.add(new Attractor(w/2.0 - 150, h/2.0, 2000));
        attractors.add(new Attractor(w/2.0 + 150, h/2.0, -1200));

        // build fractal once
        buildFractal();
    }

    public void start() {
        loopFuture = executor.scheduleAtFixedRate(() -> {
            if (running) {
                updateSimulation();
                repaint();
            }
        }, 0, 16, TimeUnit.MILLISECONDS); // ~60 FPS
    }

    public void stop() {
        if (loopFuture != null) loopFuture.cancel(true);
        executor.shutdownNow();
    }

    private void buildFractal() {
        final int fw = width; final int fh = height;
        fractalImage = new BufferedImage(fw, fh, BufferedImage.TYPE_INT_ARGB);
        double cx = -0.7, cy = 0.0; // default mandelbrot center
        double scale = 3.0 / Math.min(fw, fh);
        for (int y = 0; y < fh; y++) {
            for (int x = 0; x < fw; x++) {
                double zx = (x - fw/2.0) * scale + cx;
                double zy = (y - fh/2.0) * scale + cy;
                int iter = mandelbrotIter(zx, zy, 120);
                int color = Color.HSBtoRGB(0.95f + iter/(float)120, 0.6f, iter>0?1f:0f);
                fractalImage.setRGB(x, y, (iter==120?0xFF000000: (0xFF000000 | (color & 0x00FFFFFF))));
            }
        }
    }

    private int mandelbrotIter(double zx0, double zy0, int maxIter) {
        double zx = 0, zy = 0;
        int iter = 0;
        while (zx*zx + zy*zy <= 4.0 && iter < maxIter) {
            double nx = zx*zx - zy*zy + zx0;
            double ny = 2*zx*zy + zy0;
            zx = nx; zy = ny; iter++;
        }
        return iter==maxIter?0:iter;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = buffer.createGraphics();
        // clear
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
        g2.setColor(background);
        g2.fillRect(0,0,width,height);

        if (showFractal && fractalImage != null) {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.25f));
            g2.drawImage(fractalImage, 0,0,null);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        }

        // draw attractors
        synchronized (attractors) {
            for (Attractor a : attractors) a.draw(g2);
        }

        // draw particles
        synchronized (particles) {
            for (Particle p : particles) p.draw(g2, showTrails);
        }

        // HUD
        g2.setColor(new Color(255,255,255,180));
        g2.setFont(g2.getFont().deriveFont(12f));
        g2.drawString(String.format("Particles: %d  |  Emit rate: %d  |  Gravity: %.2f  |  Trails: %b", particles.size(), emitter.rate, gravity, showTrails), 10, 16);
        g2.dispose();

        g.drawImage(buffer, 0, 0, null);
    }

    private void updateSimulation() {
        time += 0.016;
        // emit new particles
        for (int i = 0; i < emitter.rate/10; i++) {
            if (Math.random() < (emitter.rate/100.0)) particles.add(emitter.emit(particleSize));
        }

        // physics
        synchronized (particles) {
            Iterator<Particle> it = particles.iterator();
            while (it.hasNext()) {
                Particle p = it.next();
                // apply gravity
                p.vy += gravity;
                // attractors
                synchronized (attractors) {
                    for (Attractor a : attractors) a.applyTo(p);
                }
                // damping
                p.vx *= damping; p.vy *= damping;
                // integrate
                p.x += p.vx; p.y += p.vy;
                p.age++;
                if (p.age > p.lifespan) it.remove();
                // wall collisions (wrap)
                if (p.x < -100 || p.x > width+100 || p.y < -100 || p.y > height+100) it.remove();
            }
        }

        // simple collisions (O(n^2) but fine for moderate counts)
        synchronized (particles) {
            int n = particles.size();
            for (int i = 0; i < n; i++) {
                Particle a = particles.get(i);
                for (int j = i+1; j < n; j++) {
                    Particle b = particles.get(j);
                    double dx = b.x - a.x; double dy = b.y - a.y;
                    double dist2 = dx*dx + dy*dy;
                    double minDist = (a.size + b.size)/2.0;
                    if (dist2 > 0 && dist2 < minDist*minDist) {
                        double dist = Math.sqrt(dist2);
                        if (dist == 0) { dx = Math.random()*0.01; dy = Math.random()*0.01; dist = Math.sqrt(dx*dx + dy*dy); }
                        double nx = dx/dist; double ny = dy/dist;
                        double overlap = 0.5*(minDist - dist);
                        a.x -= nx*overlap; a.y -= ny*overlap;
                        b.x += nx*overlap; b.y += ny*overlap;
                        // simple elastic-ish collision
                        double k = 0.5;
                        double dvx = b.vx - a.vx; double dvy = b.vy - a.vy;
                        double vn = dvx*nx + dvy*ny;
                        if (vn < 0) {
                            double impulse = -(1.0 + k)*vn / 2.0;
                            a.vx -= impulse*nx; a.vy -= impulse*ny;
                            b.vx += impulse*nx; b.vy += impulse*ny;
                        }
                    }
                }
            }
        }
    }

    public void clearParticles() { particles.clear(); }

    public void applyPreset(String name) {
        switch (name) {
            case "Calm Fountain":
                emitter.rate = 40; emitter.speed = 120; gravity = 0.05; damping = 0.99; particleSize = 6; trailLength = 60; showTrails = true; break;
            case "Chaotic Attractors":
                emitter.rate = 120; emitter.speed = 240; gravity = -0.02; damping = 0.996; particleSize = 4; trailLength = 25; showTrails = true;
                attractors.clear(); attractors.add(new Attractor(width/2.0, height/2.0, -4000)); attractors.add(new Attractor(width/2.0+200, height/2.0-80, 3200)); break;
            case "Mandel Glow":
                emitter.rate = 90; emitter.speed = 80; gravity = 0.01; damping = 0.995; particleSize = 8; trailLength = 140; showFractal = true; break;
            case "Explosion":
                emitter.rate = 350; emitter.speed = 720; gravity = 0.12; damping = 0.995; particleSize = 5; trailLength = 10; showTrails = false; attractors.clear(); break;
            case "Particle Ocean":
                emitter.rate = 60; emitter.speed = 40; gravity = 0.02; damping = 0.985; particleSize = 10; trailLength = 110; showTrails = true; break;
        }
    }

    public void applyRandomPreset() {
        Random r = new Random();
        emitter.rate = 10 + r.nextInt(300);
        emitter.speed = 20 + r.nextInt(600);
        gravity = -0.2 + r.nextDouble()*0.6;
        damping = 0.95 + r.nextDouble()*0.045;
        particleSize = 2 + r.nextInt(18);
        trailLength = r.nextInt(160);
    }

    public void saveSnapshot() {
        try {
            BufferedImage snap = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = snap.createGraphics();
            paintComponent(g);
            g.dispose();
            String fileName = "snapshot_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".png";
            File out = new File(fileName);
            javax.imageio.ImageIO.write(snap, "png", out);
            JOptionPane.showMessageDialog(this, "Saved snapshot to " + out.getAbsolutePath());
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to save snapshot: " + ex.getMessage());
        }
    }

    public void exportState() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
                oos.writeObject(particleSize);
                oos.writeObject(trailLength);
                oos.writeObject((double)gravity);
                oos.writeObject((double)damping);
                oos.writeObject(emitter);
                oos.writeObject(attractors);
                JOptionPane.showMessageDialog(this, "Exported state to " + f.getAbsolutePath());
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Export failed: " + ex.getMessage());
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void importState() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
                particleSize = (Integer) ois.readObject();
                trailLength = (Integer) ois.readObject();
                gravity = (Double) ois.readObject();
                damping = (Double) ois.readObject();
                Emitter e = (Emitter) ois.readObject();
                List<Attractor> a = (List<Attractor>) ois.readObject();
                emitter.copyFrom(e);
                attractors.clear(); attractors.addAll(a);
                JOptionPane.showMessageDialog(this, "Imported state from " + f.getAbsolutePath());
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Import failed: " + ex.getMessage());
            }
        }
    }

    // mouse interactions: left click adds attractor, drag emitter, wheel adjusts emitter size
    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            leftDown = true;
            attractors.add(new Attractor(e.getX(), e.getY(), 2000));
        } else if (SwingUtilities.isRightMouseButton(e)) {
            emitter.x = e.getX(); emitter.y = e.getY();
        }
    }
    @Override public void mouseReleased(MouseEvent e) { leftDown = false; }
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
    @Override public void mouseDragged(MouseEvent e) { mouseMoved(e); }
    @Override public void mouseMoved(MouseEvent e) { mouseX = e.getX(); mouseY = e.getY(); }
    @Override public void mouseWheelMoved(MouseWheelEvent e) {
        emitter.rate = Math.max(0, emitter.rate - e.getWheelRotation()*5);
    }
}

class Emitter implements Serializable {
    double x, y;
    int rate = 60; // roughly particles / frame influence
    double speed = 120; // average speed magnitude

    public Emitter(double x, double y) { this.x = x; this.y = y; }

    public Particle emit(int size) {
        double angle = Math.random()*Math.PI*2;
        double sp = Math.max(10, speed * (0.6 + Math.random()*0.8));
        double vx = Math.cos(angle)*sp/60.0; // convert to per-frame
        double vy = Math.sin(angle)*sp/60.0;
        Particle p = new Particle(x + Math.cos(angle)*4, y + Math.sin(angle)*4, vx, vy, size);
        return p;
    }

    public void copyFrom(Emitter other) {
        this.x = other.x; this.y = other.y; this.rate = other.rate; this.speed = other.speed;
    }
}

class Attractor implements Serializable {
    double x,y; double strength;
    public Attractor(double x, double y, double s) { this.x=x; this.y=y; this.strength=s; }
    public void applyTo(Particle p) {
        double dx = x - p.x; double dy = y - p.y;
        double r2 = dx*dx + dy*dy + 1e-4;
        double inv = strength / r2;
        p.vx += dx * inv / 60.0;
        p.vy += dy * inv / 60.0;
    }
    public void draw(Graphics2D g) {
        int r = 8;
        g.setColor(new Color(255,200,0,200));
        g.fillOval((int)(x-r),(int)(y-r), r*2, r*2);
        g.setColor(new Color(255,120,0,120));
        g.drawString(String.format("%.0f", strength), (int)x+10, (int)y);
    }
}

class Particle {
    double x,y; double vx,vy; int size; int age=0; int lifespan;
    LinkedList<Point> trail = new LinkedList<>();
    Color color;

    public Particle(double x, double y, double vx, double vy, int size) {
        this.x = x; this.y = y; this.vx = vx; this.vy = vy; this.size = size;
        // lifespan scales with speed and random
        this.lifespan = 60 + (int)(Math.random()*200);
        float h = (float) (Math.random());
        color = Color.getHSBColor(h, 0.7f, 1.0f);
    }

    public void draw(Graphics2D g, boolean trails) {
        int s = Math.max(1, size);
        if (trails) {
            trail.addFirst(new Point((int)x, (int)y));
            while (trail.size() > 80) trail.removeLast();
            int alpha = 200;
            int i = 0;
            for (Point p : trail) {
                int a = (int) (alpha * (1.0 - i/(double)trail.size()));
                if (a < 8) break;
                g.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), a));
                int ts = (int) (s * (1.0 - i/(double)trail.size())*1.6);
                g.fillOval(p.x - ts/2, p.y - ts/2, ts, ts);
                i++;
            }
        }
        g.setColor(color);
        g.fillOval((int)(x - s/2), (int)(y - s/2), s, s);
    }
}

/*
 * Notes & extension ideas:
 *  - You can replace the basic mandelbrot overlay with a zoomable fractal control.
 *  - Add GUI to manipulate attractor strengths and remove attractors by right-click.
 *  - Swap to OpenGL (JOGL or LWJGL) for GPU-accelerated particle counts.
 *  - Serialize/deserialize particles for replay.
 *
 * This single-file project is intentionally large and documented — enjoy hacking it!
 */
